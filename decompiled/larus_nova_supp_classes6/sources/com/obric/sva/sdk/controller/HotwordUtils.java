package com.obric.sva.sdk.controller;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.common.AndroidLogcat;
import com.obric.assistant.spi.audio.ObricBackTraceLogDelegate;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.CredibilityType;
import com.obric.sva.sdk.data.CredibilityTypeKt;
import com.obric.sva.sdk.ipc.TrackAPI;
import com.obric.sva.sdk.nonstream.KWSScore;
import com.obric.sva.sdk.service.WakeProcessStartupEvidence;
import com.obric.sva.sdk.service.WakeupToken;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import hga.b;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001CB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0007J\f\u0010'\u001a\u00020\u0007*\u00020(H\u0007JT\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u000103H\u0007J\b\u00104\u001a\u00020$H\u0007J\f\u00105\u001a\u00020$*\u00020\u0018H\u0002J?\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00052\u0006\u0010&\u001a\u0002092\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010%\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0002\u0010;JO\u0010<\u001a\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030=2\u001e\u0010>\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002090?0\n0\u001a2\u0018\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070?0\n¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020$H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/obric/sva/sdk/controller/HotwordUtils;", "", "<init>", "()V", "READ_BUFFER_SIZE", "", "TAG", "", "INTERVAL_TIME", "intervalList", "", "SAMPLE_SIZE_PER_INTERVAL", "timeFormater", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "getTimeFormater", "()Ljava/time/format/DateTimeFormatter;", "timeFormater$delegate", "Lkotlin/Lazy;", "executors", "Ljava/util/concurrent/ExecutorService;", "minBufferSize", "audioRecordFuture", "Ljava/util/concurrent/Future;", "Landroid/media/AudioRecord;", "pipe", "", "Landroid/os/ParcelFileDescriptor;", "getPipe", "()[Landroid/os/ParcelFileDescriptor;", "setPipe", "([Landroid/os/ParcelFileDescriptor;)V", "[Landroid/os/ParcelFileDescriptor;", "backTraceTracer", "Lcom/obric/assistant/spi/audio/IObricBackTraceTracer;", "createRecorderAsync", "", "sessionId", "historyLength", "asString", "", "startNonStreamingHotWordRecording", "context", "Landroid/content/Context;", "wakeupToken", "Lcom/obric/sva/sdk/service/WakeupToken;", "fileId", "credibility", "fKConfidenceLevel", "fUsrConfidenceLevel", "hotwordBufferCallback", "Lcom/obric/sva/sdk/controller/HotwordUtils$INonStreamingHotwordBufferCallback;", "releaseRecorder", "quit", "calculateScore", "Lcom/obric/sva/sdk/nonstream/KWSScore;", "index", "", "callback", "(IJ[Landroid/os/ParcelFileDescriptor;ILcom/obric/sva/sdk/controller/HotwordUtils$INonStreamingHotwordBufferCallback;)Lcom/obric/sva/sdk/nonstream/KWSScore;", "merge", "", "durations", "Landroid/util/Pair;", "detail", "([Ljava/util/List;Ljava/util/List;)Ljava/util/Map;", "prepare", "INonStreamingHotwordBufferCallback", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class HotwordUtils {
    public static final HotwordUtils INSTANCE = null;
    private static final int INTERVAL_TIME = 120;
    public static final int READ_BUFFER_SIZE = 1280;
    private static final int SAMPLE_SIZE_PER_INTERVAL = 7680;
    private static final String TAG = null;
    private static Future<AudioRecord> audioRecordFuture;
    private static final b backTraceTracer = null;
    private static final ExecutorService executors = null;
    private static final List<Integer> intervalList = null;
    private static final int minBufferSize = 0;
    private static ParcelFileDescriptor[] pipe;
    private static final Lazy timeFormater$delegate = null;

    private HotwordUtils() {
    }

    public static /* synthetic */ void a() {
        _init_$lambda$3();
    }

    public static /* synthetic */ Unit b(int r0, int r1, Ref.IntRef r2, ByteArrayOutputStream r3, int r4, int r5, byte[] r6) {
        return startNonStreamingHotWordRecording$lambda$17(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit c(Ref.IntRef r0, int r1, ByteArrayOutputStream r2, int r3, int r4, byte[] r5) {
        return startNonStreamingHotWordRecording$lambda$19(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Thread d(Runnable r0) {
        return executors$lambda$2(r0);
    }

    public static /* synthetic */ DateTimeFormatter e() {
        return timeFormater_delegate$lambda$0();
    }

    public static /* synthetic */ Unit f(Ref.ObjectRef r0) {
        return startNonStreamingHotWordRecording$lambda$24(r0);
    }

    public static /* synthetic */ Unit g(Ref.BooleanRef r0, Function0 r1, boolean r2) {
        return startNonStreamingHotWordRecording$lambda$25(r0, r1, r2);
    }

    public static /* synthetic */ AudioRecord h(AudioRecord r0, int r1, int r2) {
        return createRecorderAsync$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ Unit i(int r0, int r1, Ref.IntRef r2, INonStreamingHotwordBufferCallback r3, ByteArrayOutputStream r4, int r5, int r6, byte[] r7) {
        return startNonStreamingHotWordRecording$lambda$16(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    static {
        INSTANCE = new HotwordUtils();
        TAG = "HotwordUtils";
        intervalList = CollectionsKt.listOf(new Integer[]{0, Integer.valueOf(INTERVAL_TIME), 240, 360});
        timeFormater$delegate = LazyKt.lazy(new r());
        ExecutorService r0 = PThreadExecutorsUtils.newSingleThreadExecutor(new s());
        executors = r0;
        minBufferSize = AudioRecord.getMinBufferSize(16000, 16, 2);
        backTraceTracer = ObricBackTraceLogDelegate.b.c();
        r0.submit(new t());
    }

    private static final void _init_$lambda$3() {
        LogUtils.d(TAG, "executor inited", new Object[0]);
    }

    private final DateTimeFormatter getTimeFormater() {
        return (DateTimeFormatter) timeFormater$delegate.getValue();
    }

    @JvmStatic
    public static final void prepare() {
        LogUtils.d(TAG, "HotwordUtils class prepared..", new Object[0]);
    }

    @JvmStatic
    public static final void releaseRecorder() {
        LogUtils.d(TAG, "releaseRecorder " + audioRecordFuture, new Object[0]);
        if (audioRecordFuture != null) goto L5;
        return;
    L5:
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Future<AudioRecord> r2 = audioRecordFuture;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        AudioRecord r3 = r2.get(2, TimeUnit.SECONDS);     // Catch: Throwable -> L12
    L10:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L12
    L14:
        audioRecordFuture = null;
        if (Result.isFailure-impl(r4) == true) goto L18;
        r0 = r4;
    L18:
        AudioRecord r5 = (AudioRecord) r0;
        if (r5 != null) goto L21;
        return;
    L21:
        INSTANCE.quit(r5);
        return;
    L9:
        r3 = null;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    private static final DateTimeFormatter timeFormater_delegate$lambda$0() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public final ParcelFileDescriptor[] getPipe() {
        return pipe;
    }

    @JvmStatic
    public static final String asString(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r1 = new ArrayList(r10.length);
        int r0 = r10.length;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        byte r4 = r10[r3];
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r1.add(String.format("0x%02X", Arrays.copyOf(new Object[]{Byte.valueOf(r4)}, 1)));
        r3 = r3 + 1;
        goto L3
    L6:
        return CollectionsKt.joinToString$default(r1, " ", null, null, 0, null, null, 62, null);
    }

    private static final Thread executors$lambda$2(Runnable r2) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r2, "/HotwordUtils");
        ThreadMethodProxy.setName(r0, "recorder_thread_hotword");
        ThreadMethodProxy.setPriority(r0, 9);
        return r0;
    }

    private final void quit(AudioRecord r2) {
        HotwordRecorderMgr.quit(r2, SessionType.VOICE);
    }

    private static final Unit startNonStreamingHotWordRecording$lambda$24(Ref.ObjectRef r1) {
        INSTANCE.quit((AudioRecord) r1.element);
        releaseRecorder();
        return Unit.INSTANCE;
    }

    public final void setPipe(ParcelFileDescriptor[] r1) {
        pipe = r1;
    }

    @JvmStatic
    public static final void createRecorderAsync(int r12, int r13) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Future<AudioRecord> r1 = audioRecordFuture;     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        AudioRecord r2 = r1.get(2, TimeUnit.SECONDS);     // Catch: Throwable -> L8
    L6:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L13;
        LogUtils.e(TAG, "createRecorderAsync: get oldRecorder failed, " + r4, new Object[0]);
        TrackAPI.trackWakeupInterrupted$default("stage2_entry", "createRecorderAsync failed", "createRecorderAsync: get oldRecorder failed, " + r4, null, 8, null);
    L13:
        ResultKt.throwOnFailure(r3);
        audioRecordFuture = executors.submit(new u((AudioRecord) r3, r12, r13));
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final Map<String, ?> merge(List<Pair<String, Long>>[] r7, List<? extends Pair<String, String>> r8) {
        Intrinsics.checkNotNullParameter(r7, "durations");
        Intrinsics.checkNotNullParameter(r8, "detail");
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Iterator<T> r3 = r7[r2].iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Pair r4 = (Pair) r3.next();
        r0.put(r4.first, r4.second);
        goto L6
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L13;
        Pair r10 = (Pair) r9.next();
        r0.put(r10.first, r10.second);
        goto L11
    L13:
        return r0;
    }

    private static final AudioRecord createRecorderAsync$lambda$6(AudioRecord r4, int r5, int r6) {
        LogUtils.i(TAG, "createRecorderParallel invoked ...", new Object[0]);
        if (r4 == null) goto L10;
        HotwordRecorderMgr.quit(r4, SessionType.VOICE);
    L10:
        return HotwordRecorderMgr.createRecorder(SessionType.VOICE, r5, r6, 2, false);
    L7:
        th = move-exception;
        LogUtils.e(TAG, "createRecorder threw, " + th, new Object[0]);
        throw th;
    }

    private static final Unit startNonStreamingHotWordRecording$lambda$25(Ref.BooleanRef r0, Function0 r1, boolean r2) {
        r0.element = r2;
        r1.invoke();
        return Unit.INSTANCE;
    }

    private final KWSScore calculateScore(int r6, long r7, ParcelFileDescriptor[] r9, int r10, INonStreamingHotwordBufferCallback r11) {
        if (r11 == null) goto L4;
        String r0 = TAG;
        LogUtils.i(r0, "start calculate score with index " + r6 + " and historyLength " + r7, new Object[0]);
        if (r6 >= 0) goto L8;
        r6 = 0;
    L8:
        long r8 = ((r7 * ((long) 1000)) / ((long) 64000)) + ((long) (r6 * INTERVAL_TIME));
        KWSScore r1 = new KWSScore();
        r1.setOffsetTime(r8);
        if (r9 != null) goto L11;
    L13:
        ParcelFileDescriptor r12 = null;
    L14:
        KWSScore r13 = r11.onCalculateScore(r1, r12, r10, false);
        LogUtils.i(r0, "after calculate score with index " + r6 + " , and score is " + r13, new Object[0]);
        r13.setOffsetTime(r8);
        return r13;
    L11:
        if (r9.length != 2) goto L13;
        r12 = r9[1];
        goto L14
    L4:
        return new KWSScore();
    }

    private static final Unit startNonStreamingHotWordRecording$lambda$19(Ref.IntRef r3, int r4, ByteArrayOutputStream r5, int r6, int r7, byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "array");
        WakeProcessStartupEvidence.INSTANCE.markAsrReady(r7);
        LogUtils.i(TAG, "voice recorder additional read chunk index=" + r3.element + " pos=" + r6 + " read=" + r7 + " target=" + r4 + " useBacktrace=false", new Object[0]);
        r5.write(r8, r6, r7);
        return Unit.INSTANCE;
    }

    private static final Unit startNonStreamingHotWordRecording$lambda$17(int r2, int r3, Ref.IntRef r4, ByteArrayOutputStream r5, int r6, int r7, byte[] r8) {
        Intrinsics.checkNotNullParameter(r8, "array");
        WakeProcessStartupEvidence.INSTANCE.markAsrReady(r7);
        LogUtils.i(TAG, "voice recorder history retry read chunk pos=" + r6 + " read=" + r7 + " target=" + r2 + " historyLength=" + r3 + " useBacktrace=false", new Object[0]);
        r5.write(r8, r6, r7);
        return Unit.INSTANCE;
    }

    private static final Unit startNonStreamingHotWordRecording$lambda$16(int r6, int r7, Ref.IntRef r8, INonStreamingHotwordBufferCallback r9, ByteArrayOutputStream r10, int r11, int r12, byte[] r13) {
        Intrinsics.checkNotNullParameter(r13, "array");
        WakeProcessStartupEvidence.INSTANCE.markAsrReady(r12);
        LogUtils.i(TAG, "voice recorder history read chunk pos=" + r11 + " read=" + r12 + " target=" + r6 + " historyLength=" + r7 + " useBacktrace=false", new Object[0]);
        if (r9 == null) goto L5;
        r9.onBuffer(r13, r11, r12, true, false);
    L5:
        r10.write(r13, r11, r12);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final int startNonStreamingHotWordRecording(Context r67, WakeupToken r68, int r69, String r70, int r71, int r72, int r73, int r74, INonStreamingHotwordBufferCallback r75) {
        Intrinsics.checkNotNullParameter(r68, "wakeupToken");
        Intrinsics.checkNotNullParameter(r70, "fileId");
        WakeProcessStartupEvidence.INSTANCE.reset();
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        CredibilityType r0 = CredibilityTypeKt.fromCredibility(r72);
        CredibilityTypeKt.trackCredibilityType(r0);
        if (r0 != CredibilityType.SUSPECT) goto L23;
        LogUtils.d(TAG, "startHotWordRecording credibilityType is SUSPECT , just return , not check anymore !", new Object[0]);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        if (r75 == null) goto L7;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_14_suspect_wakeup", null, 2, null);
        Unit r2 = Unit.INSTANCE;
    L7:
        byte[] r3 = r68.getFtrtData();
        if (r3 != null) goto L229;
    L21:
        releaseRecorder();
        return -1;
    L229:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        if (r75 == null) goto L12;
        r75.onBuffer(r3, 0, r68.getFtrtLength(), false, false);     // Catch: Throwable -> L18
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L12:
        if (r75 == null) goto L14;
        r75.onSuspectCalculateScore();     // Catch: Throwable -> L18
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L14:
        if (r75 == null) goto L16;
        r75.onWakeupAttemptFinished(false, false);     // Catch: Throwable -> L18
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        r1.write(r3, 0, r68.getFtrtLength());     // Catch: Throwable -> L18
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Result.box-impl(r8);
    L18:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L23:
        LogUtils.d(TAG, "startHotWordRecording init start S0 and wait for the recorder prepared ,  blocking wait ...", new Object[0]);
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        if (r68.getFtrtDataGetWay() != WakeupToken.FTRT_DATA_GETWAY.OPAQUE_DATA) goto L26;
        boolean r17 = true;
    L231:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L29
        Object r15 = Result.constructor-impl(ParcelFileDescriptor.createPipe());     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r15) == false) goto L34;
        r15 = null;
    L34:
        pipe = (ParcelFileDescriptor[]) r15;
        String r16 = TAG;
        LogUtils.i(r16, "startHotWordRecording has got recorder ,and now start to create the pipe", new Object[0]);
        TrackAPI.trackStage1$default(TrackAPI.INSTANCE, SessionType.VOICE, null, 2, null);
        Ref.IntRef r18 = new Ref.IntRef();
        Ref.ObjectRef r610 = r12;
        String r19 = "history";
        String r110 = "sid_threshold";
        String r20 = "threshold";
        String r21 = "name";
        String r22 = "wakeup_stage2_8_lab_start_reading_history_buffer";
        String r23 = "error_message";
        String r24 = "wakeup_flow_interrupted";
        if (r17 == false) goto L61;
        byte[] r32 = r68.getFtrtData();
        if (r32 != null) goto L42;
        LogUtils.d(r16, "startHotWordRecording ftrtData is null, just return", new Object[0]);
        if (r75 == null) goto L41;
        r75.onEvent("wakeup_flow_interrupted", MapsKt.mapOf(TuplesKt.to("error_message", "ftrtData is null")));
        Unit r25 = Unit.INSTANCE;
    L41:
        return -1;
    L42:
        r10.write(r68.getFtrtData());
        int r111 = r68.getFtrtLength();
        LogUtils.i(r16, "startHotWordRecording ftrtDataSize is " + r111, new Object[0]);
        if (r75 == null) goto L45;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_8_lab_start_reading_history_buffer", null, 2, null);
        Unit r26 = Unit.INSTANCE;
    L45:
        LogUtils.d(r16, "startHotWordRecording ftrtDataSize is end", new Object[0]);
        if (r75 == null) goto L50;
        r75.onBuffer(r32, 0, r111, true, false);
        Unit r27 = Unit.INSTANCE;
    L50:
        if (r75 == null) goto L52;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_9_lab_after_reading_history_buffer", null, 2, null);
        Unit r28 = Unit.INSTANCE;
    L52:
        LogUtils.d(r16, "startHotWordRecording start to calculate score", new Object[0]);
        if (r75 == null) goto L55;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_10_lab_start_calculate_score", null, 2, null);
        Unit r29 = Unit.INSTANCE;
    L55:
        HotwordUtils r30 = INSTANCE;
        ByteArrayOutputStream r611 = r10;
        String r51 = r28;
        Ref.BooleanRef r31 = r11;
        String r52 = r29;
        Ref.IntRef r33 = r18;
        Ref.ObjectRef r34 = r13;
        KWSScore r35 = r30.calculateScore(-1, r111, pipe, r69, r75);
        r34.element = r35;
        r31.element = r35.getCombineResult();
        r35.getKws_result();
        boolean r112 = r35.getSid_result();
        if (r75 == null) goto L58;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_11_lab_after_calculate_score", null, 2, null);
        Unit r36 = Unit.INSTANCE;
    L58:
        if (r75 == null) goto L60;
        String r113 = "score0";
        r75.onMiscInfo(r113, Double.valueOf(r35.getKws_score0()));
        String r114 = "sid_score";
        r75.onMiscInfo(r114, Double.valueOf(r35.getSid_score()));
        String r115 = "hit";
        r75.onMiscInfo(r115, Boolean.valueOf(r35.getCombineResult()));
        String r37 = "kwsHit";
        r75.onMiscInfo(r37, Boolean.valueOf(r35.getKws_result()));
        String r38 = "sidHit";
        r75.onMiscInfo(r38, Boolean.valueOf(r35.getSid_result()));
        String r50 = "wakeup_stage2_11_lab_after_calculate_score";
        r75.onMiscInfo(r21, r35.getName());
        r75.onMiscInfo(r20, Float.valueOf(r35.getKws_threshold()));
        r75.onMiscInfo(r110, Float.valueOf(r35.getSid_threshold()));
        r75.onMiscInfo(r19, Integer.valueOf(r611.size()));
        String r116 = "index";
        r75.onMiscInfo(r116, -1);
        String r39 = "time";
        r75.onMiscInfo(r39, LocalDateTime.now().format(r30.getTimeFormater()));
        Integer r40 = Integer.valueOf(r35.getFrames());
        String r41 = "frame";
        r75.onMiscInfo(r41, r40);
        Unit r42 = Unit.INSTANCE;
    L62:
        if (r17 == true) goto L64;
    L66:
        String r46 = r37;
        if (r17 == true) goto L69;
    L74:
        LogUtils.i(r16, "startNonStreamingHotWordRecording section C", new Object[0]);
    L75:
        boolean r117 = true;
    L76:
        if (r17 == false) goto L79;
        if (r75 == null) goto L79;
        r75.onWakeupAttemptFinished(r117, r31.element);
        Unit r43 = Unit.INSTANCE;
    L79:
        String r49 = r113;
        String r44 = r116;
        if (r117 == false) goto L192;
        Future<AudioRecord> r45 = audioRecordFuture;
        if (r45 != null) goto L86;
        if (r75 == null) goto L85;
        r75.onEvent(r24, MapsKt.mapOf(TuplesKt.to(r23, "audioRecordFuture null")));
        Unit r47 = Unit.INSTANCE;
    L85:
        return -1;
    L86:
        String r48 = r24;
        String r53 = r23;
        if (r45 != null) goto L235;
        AudioRecord r54 = null;
    L92:
        Object r55 = Result.constructor-impl(r54);     // Catch: Throwable -> L89
    L95:
        audioRecordFuture = null;
        if (Result.isFailure-impl(r55) == false) goto L99;
        r55 = null;
    L99:
        r610.element = r55;
        AudioRecord r56 = (AudioRecord) r55;
        if (r56 != null) goto L104;
        if (r75 == null) goto L103;
        r75.onEvent(r48, MapsKt.mapOf(TuplesKt.to(r53, "audioRecord null")));
        Unit r57 = Unit.INSTANCE;
    L103:
        return -1;
    L104:
        HotwordRecorderMgr.shareHistory(r56, SessionType.VOICE, 0);
        if (r75 == null) goto L107;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, r22, null, 2, null);
        Unit r58 = Unit.INSTANCE;
    L107:
        String r59 = TAG;
        LogUtils.i(r59, "startHotWordRecording start to read history buffer ...bufferSize:" + r71, new Object[0]);
        long r210 = System.currentTimeMillis();
        Ref.IntRef r60 = new Ref.IntRef();
        if (r33.element != 0) goto L110;
        int r118 = r71;
        int r119 = 0;
        KtUtils.readBuffer$default((AudioRecord) r610.element, r71, false, new m(r71, r71, r60, r75, r611), 4, null);
        Map r120 = null;
    L111:
        LogUtils.d(r59, "startHotWordRecording B reading buffer end with buffer " + r611.size(), new Object[r119]);
        if (r75 == null) goto L114;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, r52, r120, 2, r120);
        Unit r61 = Unit.INSTANCE;
    L114:
        Ref.IntRef r62 = r33;
        int r63 = r62.element;
        int r64 = intervalList.size();
        int r65 = r63;
        int r66 = 0;
    L115:
        if (r65 >= r64) goto L190;
        long r211 = System.currentTimeMillis();
        List<Integer> r76 = intervalList;
        int r77 = ((Number) ListProtector.get(r76, r65)).intValue();
        String r78 = TAG;
        LogUtils.i(r78, "startHotWordRecording index read time " + r62.element + " , with interval " + r77, new Object[r119]);
        if (r62.element != 0) goto L122;
        String r121 = r51;
        if (r75 == null) goto L121;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, r121, null, 2, null);
        Unit r79 = Unit.INSTANCE;
    L121:
        ByteArrayOutputStream r122 = r611;
        int r80 = r66;
        r76 = r76;
        r65 = r65;
        r64 = r64;
        r41 = r41;
        String r81 = r78;
    L145:
        HotwordUtils r82 = INSTANCE;
        int r612 = r80;
        String r83 = r39;
        String r510 = r81;
        String r84 = r115;
        Ref.ObjectRef r511 = r610;
        ByteArrayOutputStream r85 = r122;
        String r613 = r114;
        String r614 = r49;
        String r123 = r121;
        String r615 = r44;
        String r616 = r19;
        String r617 = r110;
        String r618 = r20;
        String r619 = r21;
        r50 = r50;
        KWSScore r86 = r82.calculateScore(r62.element, r118, pipe, r69, r75);
        Ref.ObjectRef r87 = r34;
        r87.element = r86;
        Ref.BooleanRef r124 = r31;
        r124.element = r86.getCombineResult();
        if (r62.element != 0) goto L149;
        if (r75 == null) goto L151;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, r50, null, 2, null);
        Unit r125 = Unit.INSTANCE;
    L151:
        if (r75 == null) goto L157;
        String r126 = r614;
        r75.onMiscInfo(r126, Double.valueOf(r86.getKws_score0()));
        String r127 = r613;
        r75.onMiscInfo(r127, Double.valueOf(r86.getSid_score()));
        r75.onMiscInfo(r84, Boolean.valueOf(r86.getCombineResult()));
        String r128 = r46;
        r75.onMiscInfo(r128, Boolean.valueOf(r86.getKws_result()));
        String r88 = r38;
        r75.onMiscInfo(r88, Boolean.valueOf(r86.getSid_result()));
        r21 = r619;
        r75.onMiscInfo(r21, r86.getName());
        r75.onMiscInfo(r618, Float.valueOf(r86.getKws_threshold()));
        r20 = r618;
        r75.onMiscInfo(r617, Float.valueOf(r86.getSid_threshold()));
        r110 = r617;
        r75.onMiscInfo(r616, Integer.valueOf(r85.size()));
        r19 = r616;
        r75.onMiscInfo(r615, Integer.valueOf(r62.element));
        r44 = r615;
        if (Build.VERSION.SDK_INT < 26) goto L155;
        String r89 = LocalDateTime.now().format(r82.getTimeFormater());
        String r90 = r83;
        r75.onMiscInfo(r90, r89);
    L156:
        String r129 = r41;
        r75.onMiscInfo(r129, Integer.valueOf(r86.getFrames()));
        String r410 = r88;
        r75.onMiscInfo("is_continue_wakeup", Boolean.valueOf(r86.is_continue_wakeup()));
        r75.onMiscInfo("env_status", Integer.valueOf(r86.getEnv_status()));
        Unit r91 = Unit.INSTANCE;
    L159:
        if (r124.element == false) goto L161;
    L165:
        boolean r92 = false;
    L166:
        if (r75 == null) goto L168;
        r75.onWakeupAttemptFinished(r92, r124.element);
        Unit r93 = Unit.INSTANCE;
    L168:
        LogUtils.d(r510, "wakeup data is " + asString(r85.toByteArray()), new Object[0]);
        if (r124.element == true) goto L170;
        if (r62.element == (r76.size() - 1)) goto L176;
        if (r86.getSid_result() == false) goto L176;
        long r94 = System.currentTimeMillis() - r211;
        if (r94 < 120) goto L181;
        LogUtils.i(r510, "check time A loop now ", new Object[0]);
        Unit r95 = Unit.INSTANCE;
    L189:
        r62.element++;
        r65 = r65 + 1;
        r66 = r612;
        r611 = r85;
        r34 = r87;
        r41 = r129;
        r49 = r126;
        r114 = r127;
        r46 = r128;
        r31 = r124;
        r51 = r123;
        r38 = r410;
        r115 = r84;
        r610 = r511;
        r119 = 0;
        r118 = r71;
        r39 = r90;
        r64 = r64;
        goto L115
    L181:
        if (r94 <= 0) goto L188;
        LogUtils.i(r510, "check time B sleep " + r94, new Object[0]);
        Result.Companion r96 = Result.Companion;     // Catch: Throwable -> L185
        Thread.sleep(((long) INTERVAL_TIME) - r94);     // Catch: Throwable -> L185
        Object r97 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L185
    L187:
        Result.box-impl(r97);
    L185:
        th = move-exception;
        Result.Companion r98 = Result.Companion;
        r97 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L187
    L188:
        LogUtils.i(r510, "check time C very strange case", new Object[0]);
        Unit r99 = Unit.INSTANCE;
    L176:
        int r130 = r612;
    L191:
        int r100 = r130;
    L194:
        if (r124.element == false) goto L196;
        int r101 = AndroidLogcat.a;
        AndroidLogcat.b(TAG, "onKeywordDetected");
    L199:
        KtUtils.runInIo(new startNonStreamingHotWordRecording.12(r87, r124, r70, r73, r74, null));
        Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = true;
        if (r124.element == false) goto L223;
        long r103 = ((long) ((r71 * 1000) / 64000)) + ((long) (r100 * INTERVAL_TIME));
        String r104 = TAG;
        LogUtils.d(r104, "hasWakeWord YES and array size is = " + r85.size() + " main chunk historyLength :" + r71 + " share offset time:" + r103 + " , time to step " + r100, new Object[0]);
        r85.size();
        Ref.ObjectRef r105 = r511;
        if (r105.element != null) goto L219;
        LogUtils.i(r104, "createRecorderParallel to shareAudioHistory ...", new Object[0]);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L210
        Future<AudioRecord> r107 = audioRecordFuture;     // Catch: Throwable -> L210
        if (r107 == null) goto L207;
        AudioRecord r131 = r107.get(2, TimeUnit.SECONDS);     // Catch: Throwable -> L210
    L208:
        Object r108 = Result.constructor-impl(r131);     // Catch: Throwable -> L210
    L212:
        Object r132 = r108;
        audioRecordFuture = null;
        if (Result.isFailure-impl(r132) == false) goto L215;
        r132 = null;
    L215:
        r105.element = r132;
        if (r132 != null) goto L219;
        LogUtils.e(TAG, "absolutely not impossible to get recorder !!!! WARNING !!!! this will cause ERROR occurs, need check", new Object[0]);
        return -1;
    L207:
        r131 = null;
    L210:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.constructor-impl(ResultKt.createFailure(th));
    L219:
        p r133 = new p(r105);
        if (pipe != null) goto L222;
        r133.invoke();
    L227:
        pipe = null;
        LogUtils.d(TAG, "################# all Done ################# save the voice file", new Object[0]);
        return !r102.element ? 1 : 0;
    L222:
        SessionType r134 = SessionType.VOICE;
        ParcelFileDescriptor[] r135 = pipe;
        Intrinsics.checkNotNull(r135);
        HotwordRecorderMgr.waitAssistantSignal(r134, r135, new q(r102, r133));
        goto L227
    L223:
        LogUtils.d(TAG, "startHotWordRecording: failed to get wakeup word ", new Object[0]);
        AudioRecord r136 = (AudioRecord) r511.element;
        if (r136 == null) goto L226;
        INSTANCE.quit(r136);
        Unit r137 = Unit.INSTANCE;
    L226:
        releaseRecorder();
        goto L227
    L196:
        if (r75 == null) goto L198;
        r75.onKeywordNotDetected();
        Unit r138 = Unit.INSTANCE;
    L198:
        int r139 = AndroidLogcat.a;
        AndroidLogcat.b(TAG, "onKeywordNotDetected");
        goto L199
    L170:
        LogUtils.i(r510, "get wake word at index " + r62.element + " with total duration is " + (System.currentTimeMillis() - r210) + " back until read buffer", new Object[0]);
        goto L176
    L161:
        if (r62.element >= CollectionsKt.getLastIndex(r76)) goto L165;
        if (r86.getSid_result() == false) goto L165;
        r92 = true;
        goto L166
    L155:
        r90 = r83;
        goto L156
    L157:
        r90 = r83;
        r129 = r41;
        r128 = r46;
        r410 = r38;
        r127 = r613;
        r126 = r614;
        r44 = r615;
        r19 = r616;
        r110 = r617;
        r20 = r618;
        r21 = r619;
        goto L159
    L149:
        if (r75 == null) goto L151;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_11_lab_start_calculate_score_additional_" + r62.element, null, 2, null);
        Unit r140 = Unit.INSTANCE;
        goto L151
    L122:
        r121 = r51;
        int r141 = r66 + 1;
        LogUtils.i(r78, "start to read additional buffer with index " + r62.element, new Object[r119]);
        if (r75 == null) goto L125;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_8_lab_start_reading_additional_history_buffer_" + r62.element, null, 2, null);
        Unit r142 = Unit.INSTANCE;
    L125:
        r122 = r611;
        KtUtils.readBuffer$default((AudioRecord) r610.element, SAMPLE_SIZE_PER_INTERVAL, false, new o(r62, r122), 4, null);
        if (r75 == null) goto L129;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_9_lab_after_reading_additional_history_buffer_" + r62.element, null, 2, null);
        Unit r143 = Unit.INSTANCE;
    L129:
        LogUtils.i(r78, "after read additional buffer with index " + r62.element, new Object[0]);
        byte[] r144 = r122.toByteArray();
        if (r75 == null) goto L132;
        r75.onReset();
        Unit r145 = Unit.INSTANCE;
    L132:
        LogUtils.i(r78, "after reset sami core with index " + r62.element, new Object[0]);
        LogUtils.d(r78, "Sami process audio size: " + r144.length, new Object[0]);
        if (r75 == null) goto L140;
        Intrinsics.checkNotNull(r144);
        int r146 = r144.length;
        if (r65 != (r76.size() - 1)) goto L137;
        boolean r212 = true;
    L138:
        r75.onBuffer(r144, 0, r146, true, r212);
        Unit r147 = Unit.INSTANCE;
        goto L140
    L137:
        r212 = false;
    L140:
        r81 = r78;
        LogUtils.i(r81, "after on buffer with array size " + r144.length + " with index " + r62.element, new Object[0]);
        if (r75 == null) goto L144;
        INonStreamingHotwordBufferCallback.DefaultImpls.onEvent$default(r75, "wakeup_stage2_10_lab_start_calculate_score_additional_" + r62.element, null, 2, null);
        Unit r148 = Unit.INSTANCE;
    L144:
        r80 = r141;
        goto L145
    L190:
        r85 = r611;
        r511 = r610;
        r124 = r31;
        r87 = r34;
        r130 = r66;
        goto L191
    L110:
        r118 = r71;
        r120 = null;
        r119 = 0;
        r611.reset();
        KtUtils.readBuffer$default((AudioRecord) r610.element, r71, false, new n(r118, r118, r60, r611), 4, null);
    L89:
        th = move-exception;
        Result.Companion r149 = Result.Companion;
        r55 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L95
    L235:
        r54 = r45.get(2, TimeUnit.SECONDS);     // Catch: Throwable -> L89
        goto L92
    L192:
        r85 = r611;
        r124 = r31;
        r87 = r34;
        r511 = r610;
        r100 = 0;
        goto L194
    L69:
        if (r31.element == true) goto L74;
        if (r112 == true) goto L73;
        LogUtils.i(r16, "startNonStreamingHotWordRecording section B0", new Object[0]);
        LogUtils.i(r16, "hasNotWakeWord, but kwsCheckPass is true, this means the sid check is failed , do not create recorder", new Object[0]);
    L72:
        r117 = false;
        goto L76
    L73:
        r33.element = 1;
        LogUtils.i(r16, "startNonStreamingHotWordRecording section B1", new Object[0]);
        LogUtils.i(r16, "createRecorder hasWakeWord is false, and kwsCheckPass is false too ,  start to create recorder", new Object[0]);
        goto L75
    L64:
        if (r31.element == false) goto L66;
        r46 = r37;
        LogUtils.i(r16, "startNonStreamingHotWordRecording section A", new Object[0]);
        goto L72
    L60:
        r50 = "wakeup_stage2_11_lab_after_calculate_score";
        r39 = r2;
        r41 = r31;
        r116 = r72;
        r38 = r22;
        r37 = r23;
        r115 = r24;
        r114 = r25;
        r113 = r26;
        goto L62
    L61:
        r610 = r610;
        r116 = "index";
        r24 = "wakeup_flow_interrupted";
        r23 = "error_message";
        r22 = "wakeup_stage2_8_lab_start_reading_history_buffer";
        r611 = r10;
        r34 = r13;
        r19 = r19;
        r110 = r110;
        r20 = r20;
        r21 = r21;
        r38 = "sidHit";
        r37 = "kwsHit";
        r115 = "hit";
        r114 = "sid_score";
        r113 = "score0";
        r50 = "wakeup_stage2_11_lab_after_calculate_score";
        r51 = "wakeup_stage2_10_lab_start_calculate_score";
        r52 = "wakeup_stage2_9_lab_after_reading_history_buffer";
        r39 = "time";
        r33 = r18;
        r31 = r11;
        r41 = "frame";
        r112 = false;
    L29:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L26:
        r17 = false;
        goto L231
    }
}
