package com.obric.cae.smartNetwork.AppQoEManager;

import android.aimedia.IAIMediaEventCallback;
import android.aimedia.IAIMediaEvents;
import android.aimedia.MediaEventEnvelope;
import android.aimedia.MediaEventField;
import android.aimedia.MediaEventFilter;
import android.aimedia.MediaEventQueryResult;
import android.aimedia.MediaEventSubscribeOptions;
import android.os.IBinder;
import com.obric.cae.log.CaeLog;
import defpackage.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AIMediaEventsConsumer {
    private static final String AIMEDIA_EVENTS_SERVICE = "aimedia.events";
    private static final int STATUS_OK = 0;
    private static final String TAG = "AIMediaEventsConsumer";
    private static volatile IAIMediaEvents mAiMediaService = null;
    private static volatile boolean mIsSubscribed = false;
    private static volatile int mSubscriptionId = -1;

    public AIMediaEventsConsumer() {
    }

    public static /* synthetic */ void a() {
        lambda$resolveService$0();
    }

    public static long getLongField(MediaEventEnvelope r8, String r10, long r11) {
        if (r8 == null) goto L15;
        List<MediaEventField> r12 = r8.fields;
        if (r12 == null) goto L15;
        Iterator<MediaEventField> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L15;
        MediaEventField r14 = r13.next();
        if (r10.equals(r14.key) == false) goto L8;
        if (r14.valueType != 2) goto L8;
        return r14.longValue;
    L15:
        return r11;
    }

    private static IBinder getService(String r8) {
        return (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{r8});
    L5:
        e = move-exception;
        CaeLog.e(TAG, "failed to call ServiceManager.getService: " + e.getMessage());
        return null;
    }

    public static String getStringField(MediaEventEnvelope r8, String r10) {
        if (r8 == null) goto L16;
        List<MediaEventField> r11 = r8.fields;
        if (r11 == null) goto L16;
        Iterator<MediaEventField> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L16;
        MediaEventField r13 = r12.next();
        if (r10.equals(r13.key) == false) goto L9;
        if (r13.valueType != 4) goto L9;
        return r13.stringValue;
    L16:
        return null;
    }

    private static void handleAudioTrackUnderrun(MediaEventEnvelope r11) {
        CaeLog.i(TAG, "audio underrun seq=" + r11.sequenceNumber + " portId=" + getLongField(r11, AIMediaEventSchema.FIELD_PORT_ID, Long.MIN_VALUE) + " firstThresholdCount=" + getLongField(r11, AIMediaEventSchema.FIELD_UNDERRUN_FIRST_THRESHOLD_COUNT, Long.MIN_VALUE) + " secondThresholdCount=" + getLongField(r11, AIMediaEventSchema.FIELD_UNDERRUN_SECOND_THRESHOLD_COUNT, Long.MIN_VALUE) + " totalMs=" + getLongField(r11, AIMediaEventSchema.FIELD_UNDERRUN_TOTAL_MS, Long.MIN_VALUE));
    }

    private static void handleCodecBucketEvent(MediaEventEnvelope r8) {
        String r10 = getStringField(r8, AIMediaEventSchema.FIELD_KEY_EVENT);
        if (r10 != null) goto L7;
        CaeLog.w(TAG, "codec event missing key_event seq=" + r8.sequenceNumber);
        return;
    L7:
        if (AIMediaEventSchema.EVENT_CODEC_START.equals(r10) == false) goto L12;
        StringBuilder r11 = new StringBuilder("codec start seq=");
    L9:
        r11.append(r8.sequenceNumber);
    L10:
        CaeLog.i(TAG, r11.toString());
        return;
    L12:
        if (AIMediaEventSchema.EVENT_CODEC_STOP.equals(r10) == false) goto L15;
        r11 = new StringBuilder("codec stop seq=");
        goto L9
    L15:
        if (AIMediaEventSchema.EVENT_CODEC_PAUSE.equals(r10) == false) goto L19;
        r11 = new StringBuilder("codec pause seq=");
    L17:
        r11.append(r8.sequenceNumber);
        r11.append(" reason=");
        r11.append(getStringField(r8, AIMediaEventSchema.FIELD_STALL_REASON));
        goto L10
    L19:
        if (AIMediaEventSchema.EVENT_CODEC_RESUME.equals(r10) == false) goto L22;
        r11 = new StringBuilder("codec resume seq=");
        goto L9
    L22:
        if (AIMediaEventSchema.EVENT_CODEC_NETWORK_STARVATION.equals(r10) == false) goto L25;
        r11 = new StringBuilder("codec starvation seq=");
        goto L17
    }

    private static void handleCodecInputBitrate(MediaEventEnvelope r8) {
        CaeLog.d(TAG, "codec bitrate seq=" + r8.sequenceNumber + " bitrate=" + getLongField(r8, AIMediaEventSchema.FIELD_CODEC_INPUT_BITRATE_BPS, Long.MIN_VALUE) + "bps bitrate5s=" + getLongField(r8, AIMediaEventSchema.FIELD_CODEC_INPUT_BITRATE_BPS_5S, Long.MIN_VALUE) + "bps");
    }

    public static void handleEvent(MediaEventEnvelope r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (AIMediaEventSchema.EVENT_CODEC_INPUT_BITRATE_UPDATE.equals(r8.eventName) == false) goto L8;
        handleCodecInputBitrate(r8);
        return;
    L8:
        if (AIMediaEventSchema.EVENT_AUDIO_TRACK_UNDERRUN_STATS.equals(r8.eventName) == false) goto L11;
        handleAudioTrackUnderrun(r8);
        return;
    L11:
        if (AIMediaEventSchema.MEDIA_TYPE_CODEC.equals(r8.eventName) == false) goto L16;
        handleCodecBucketEvent(r8);
        return;
    }

    private static /* synthetic */ void lambda$resolveService$0() {
        monitor-enter(AIMediaEventsConsumer.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (mAiMediaService != null) goto L7;
    L9:
        mAiMediaService = null;     // Catch: Throwable -> L12
        mIsSubscribed = false;     // Catch: Throwable -> L12
        mSubscriptionId = -1;     // Catch: Throwable -> L12
        monitor-exit(AIMediaEventsConsumer.class);     // Catch: Throwable -> L12
        return;
    L7:
        if (mSubscriptionId <= 0) goto L9;
        unsubscribe(mAiMediaService, mSubscriptionId);     // Catch: Throwable -> L12
        goto L9
    }

    public static MediaEventFilter makeBusinessFilter() {
        MediaEventFilter r8 = new MediaEventFilter();
        ArrayList r10 = new ArrayList();
        r10.add(AIMediaEventSchema.EVENT_CODEC_INPUT_BITRATE_UPDATE);
        r10.add(AIMediaEventSchema.MEDIA_TYPE_CODEC);
        r10.add(AIMediaEventSchema.EVENT_AUDIO_TRACK_UNDERRUN_STATS);
        r8.eventNames = r10;
        r8.origins = new ArrayList();
        r8.sources = new ArrayList();
        r8.mediaTypes = new ArrayList();
        r8.eventTypes = new ArrayList();
        r8.sessionIds = new ArrayList();
        return r8;
    }

    public static long queryOnce(IAIMediaEvents r8, long r10) {
        MediaEventQueryResult r11 = new MediaEventQueryResult();
        int r12 = r8.queryEventsSince(makeBusinessFilter(), r10, 128, r11);     // Catch: Exception -> L17
        if (r12 == 0) goto L6;
    L15:
        StringBuilder r13 = b.f("queryEventsSince failed rc=", r12, " status=");
        r13.append(r11.statusCode);
        CaeLog.w(TAG, r13.toString());
        return r10;
    L6:
        if (r11.statusCode != 0) goto L15;
        List<MediaEventEnvelope> r14 = r11.events;
        if (r14 == null) goto L15;
        Iterator<MediaEventEnvelope> r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        MediaEventEnvelope r16 = r15.next();
        handleEvent(r16);
        r10 = Math.max(r10, r16.sequenceNumber);
        goto L12
    L14:
        return r10;
    L17:
        e = move-exception;
        b.k(e, new StringBuilder("queryOnce exception: "), TAG);
        return r10;
    }

    public static IAIMediaEvents resolveService() {
        if (mAiMediaService == null) goto L7;
        return mAiMediaService;
    L7:
        monitor-enter(AIMediaEventsConsumer.class);
    L30:
        th = move-exception;
        throw th;
    L9:
        if (mAiMediaService == null) goto L13;
        IAIMediaEvents r8 = mAiMediaService;     // Catch: Throwable -> L30
        monitor-exit(AIMediaEventsConsumer.class);     // Catch: Throwable -> L30
        return r8;
    L13:
        IBinder r10 = getService(AIMEDIA_EVENTS_SERVICE);     // Catch: Throwable -> L30
        if (r10 != null) goto L18;
        CaeLog.e(TAG, "aimedia.events not found: service not registered or SELinux find denied");     // Catch: Throwable -> L30
        monitor-exit(AIMediaEventsConsumer.class);     // Catch: Throwable -> L30
        return null;
    L18:
        IAIMediaEvents r11 = IAIMediaEvents.Stub.asInterface(r10);     // Catch: Throwable -> L30
        if (r11 != null) goto L33;
        CaeLog.e(TAG, "failed to cast aimedia.events");     // Catch: Throwable -> L30
        monitor-exit(AIMediaEventsConsumer.class);     // Catch: Throwable -> L30
        return null;
    L33:
        r10.linkToDeath(new a(), 0);     // Catch: Exception -> L25 Throwable -> L30
    L27:
        mAiMediaService = r11;     // Catch: Throwable -> L30
        IAIMediaEvents r12 = mAiMediaService;     // Catch: Throwable -> L30
        monitor-exit(AIMediaEventsConsumer.class);     // Catch: Throwable -> L30
        return r12;
    L25:
        e = move-exception;
        CaeLog.w(TAG, "linkToDeath failed: " + e.getMessage());     // Catch: Throwable -> L30
        goto L27
    }

    public static void subscribe() {
        if (mIsSubscribed == false) goto L6;
        CaeLog.i(TAG, "Already subscribed, skip.");
        return;
    L6:
        IAIMediaEvents r8 = resolveService();
        if (r8 != null) goto L10;
        CaeLog.e(TAG, "subscribe: resolveService returned null");
        return;
    L10:
        MediaEventSubscribeOptions r10 = new MediaEventSubscribeOptions();
        r10.startSequenceNumber = 0;
        r10.minIntervalMs = 0;
        r10.maxBatchSize = 16;
        r10.maxPendingEvents = 128;
        r10.deliverCurrentSnapshot = false;
        IAIMediaEventCallback.Stub r11 = new AnonymousClass1();
        int r12 = r8.subscribeEvents(makeBusinessFilter(), r10, r11);     // Catch: Exception -> L17
        if (r12 > 0) goto L15;
        android.aimedia.a.p("subscribeEvents failed id=", r12, TAG);
        return;
    L15:
        mSubscriptionId = r12;
        mIsSubscribed = true;
        defpackage.a.i("subscribeEvents success id=", r12, TAG);
        return;
    L17:
        e = move-exception;
        b.k(e, new StringBuilder("subscribe exception: "), TAG);
    }

    public static void unsubscribe(IAIMediaEvents r8, int r10) {
        if (mIsSubscribed == true) goto L15;
        CaeLog.i(TAG, "unsubscribe: Not subscribed, skip.");
        return;
    L15:
        int r11 = r8.unsubscribeEvents(r10);     // Catch: Exception -> L11
        if (r11 == 0) goto L9;
        CaeLog.e(TAG, "unsubscribeEvents failed rc=" + r11);     // Catch: Exception -> L11
    L14:
        return;
    L9:
        mIsSubscribed = false;     // Catch: Exception -> L11
        mSubscriptionId = -1;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        b.k(e, new StringBuilder("unsubscribe exception: "), TAG);
    }
}
