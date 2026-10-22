package com.bytedance.android.live.livepkaudience.linksecurity;

import android.text.TextUtils;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.k60;
import com.bytedance.android.livesdk.config.p60;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import dl0.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkSecurityManager {
    public static long a;
    public static final CompositeDisposable b = null;
    public static a c;
    public static LinkSecurityApi.VideoCaptureType d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/linksecurity/LinkSecurityManager$AckFromSource;", "", "PK_WITH_AUDIENCE_SILENCE_API", "PK_WITH_AUDIENCE_SILENCE_MESSAGE", "PK_WITH_AUDIENCE_CAMERA_API", "PK_WITH_AUDIENCE_CAMERA_MESSAGE", "TALK_ROOM_SILENCE_API", "TALK_ROOM_SILENCE_MESSAGE", "TALK_ROOM_CAMERA_API", "TALK_ROOM_CAMERA_MESSAGE", "VOICE_CHAT_SILENCE_API", "VOICE_CHAT_SILENCE_MESSAGE", "KTV_CAMERA_API", "KTV_CAMERA_MESSAGE", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AckFromSource extends Enum<AckFromSource> {
        public static final AckFromSource KTV_CAMERA_API = null;
        public static final AckFromSource KTV_CAMERA_MESSAGE = null;
        public static final AckFromSource PK_WITH_AUDIENCE_CAMERA_API = null;
        public static final AckFromSource PK_WITH_AUDIENCE_CAMERA_MESSAGE = null;
        public static final AckFromSource PK_WITH_AUDIENCE_SILENCE_API = null;
        public static final AckFromSource PK_WITH_AUDIENCE_SILENCE_MESSAGE = null;
        public static final AckFromSource TALK_ROOM_CAMERA_API = null;
        public static final AckFromSource TALK_ROOM_CAMERA_MESSAGE = null;
        public static final AckFromSource TALK_ROOM_SILENCE_API = null;
        public static final AckFromSource TALK_ROOM_SILENCE_MESSAGE = null;
        public static final AckFromSource VOICE_CHAT_SILENCE_API = null;
        public static final AckFromSource VOICE_CHAT_SILENCE_MESSAGE = null;
        public static final /* synthetic */ AckFromSource[] a = null;

        static {
            AckFromSource r1 = new AckFromSource("PK_WITH_AUDIENCE_SILENCE_API", 0);
            PK_WITH_AUDIENCE_SILENCE_API = r1;
            AckFromSource r2 = new AckFromSource("PK_WITH_AUDIENCE_SILENCE_MESSAGE", 1);
            PK_WITH_AUDIENCE_SILENCE_MESSAGE = r2;
            AckFromSource r3 = new AckFromSource("PK_WITH_AUDIENCE_CAMERA_API", 2);
            PK_WITH_AUDIENCE_CAMERA_API = r3;
            AckFromSource r4 = new AckFromSource("PK_WITH_AUDIENCE_CAMERA_MESSAGE", 3);
            PK_WITH_AUDIENCE_CAMERA_MESSAGE = r4;
            AckFromSource r5 = new AckFromSource("TALK_ROOM_SILENCE_API", 4);
            TALK_ROOM_SILENCE_API = r5;
            AckFromSource r6 = new AckFromSource("TALK_ROOM_SILENCE_MESSAGE", 5);
            TALK_ROOM_SILENCE_MESSAGE = r6;
            AckFromSource r7 = new AckFromSource("TALK_ROOM_CAMERA_API", 6);
            TALK_ROOM_CAMERA_API = r7;
            AckFromSource r8 = new AckFromSource("TALK_ROOM_CAMERA_MESSAGE", 7);
            TALK_ROOM_CAMERA_MESSAGE = r8;
            AckFromSource r9 = new AckFromSource("VOICE_CHAT_SILENCE_API", 8);
            VOICE_CHAT_SILENCE_API = r9;
            AckFromSource r10 = new AckFromSource("VOICE_CHAT_SILENCE_MESSAGE", 9);
            VOICE_CHAT_SILENCE_MESSAGE = r10;
            AckFromSource r11 = new AckFromSource("KTV_CAMERA_API", 10);
            KTV_CAMERA_API = r11;
            AckFromSource r12 = new AckFromSource("KTV_CAMERA_MESSAGE", 11);
            KTV_CAMERA_MESSAGE = r12;
            a = new AckFromSource[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12};
        }

        public static AckFromSource valueOf(String r1) {
            return (AckFromSource) r27.a.a(AckFromSource.class, r1);
        }

        public static AckFromSource[] values() {
            return (AckFromSource[]) a.clone();
        }

        public AckFromSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/linksecurity/LinkSecurityManager$CheckAudienceLinkersAction;", "", "CheckAudienceLinkersAction_None", "CheckAudienceLinkersAction_Silence", "CheckAudienceLinkersAction_UnSilence", "CheckAudienceLinkersAction_Leave", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CheckAudienceLinkersAction extends Enum<CheckAudienceLinkersAction> {
        public static final CheckAudienceLinkersAction CheckAudienceLinkersAction_Leave = null;
        public static final CheckAudienceLinkersAction CheckAudienceLinkersAction_None = null;
        public static final CheckAudienceLinkersAction CheckAudienceLinkersAction_Silence = null;
        public static final CheckAudienceLinkersAction CheckAudienceLinkersAction_UnSilence = null;
        public static final /* synthetic */ CheckAudienceLinkersAction[] a = null;

        static {
            CheckAudienceLinkersAction r1 = new CheckAudienceLinkersAction("CheckAudienceLinkersAction_None", 0);
            CheckAudienceLinkersAction_None = r1;
            CheckAudienceLinkersAction r2 = new CheckAudienceLinkersAction("CheckAudienceLinkersAction_Silence", 1);
            CheckAudienceLinkersAction_Silence = r2;
            CheckAudienceLinkersAction r3 = new CheckAudienceLinkersAction("CheckAudienceLinkersAction_UnSilence", 2);
            CheckAudienceLinkersAction_UnSilence = r3;
            CheckAudienceLinkersAction r4 = new CheckAudienceLinkersAction("CheckAudienceLinkersAction_Leave", 3);
            CheckAudienceLinkersAction_Leave = r4;
            a = new CheckAudienceLinkersAction[]{r1, r2, r3, r4};
        }

        public static CheckAudienceLinkersAction valueOf(String r1) {
            return (CheckAudienceLinkersAction) r27.a.a(CheckAudienceLinkersAction.class, r1);
        }

        public static CheckAudienceLinkersAction[] values() {
            return (CheckAudienceLinkersAction[]) a.clone();
        }

        public CheckAudienceLinkersAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        int a();

        void b();

        boolean c();

        String getRtcExtInfo();
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AckFromSource c;
        public final /* synthetic */ long d;

        public b(String r1, String r2, AckFromSource r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r13) {
            m r0 = m.a;
            String r1 = this.a;
            String r2 = this.b;
            String r3 = this.c.name();
            long r4 = this.d;
            String r14 = ((com.bytedance.android.live.network.response.a) r13).logId;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "toUserId");
            Intrinsics.checkNotNullParameter(r3, "fromSource");
            Intrinsics.checkNotNullParameter(r14, "logId");
            JSONObject r11 = new JSONObject();
            r11.put("to_user_id", r1);
            r11.put("ack_message", r2);
            r11.put("from_source", r3);
            r11.put("log_id", r14);
            m.z("ack_message", 0, "", System.currentTimeMillis() - r4, r11);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AckFromSource c;
        public final /* synthetic */ long d;

        public c(String r1, String r2, AckFromSource r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r13) {
            ApiServerException r14 = (Throwable) r13;
            m r0 = m.a;
            String r1 = this.a;
            String r2 = this.b;
            String r3 = this.c.name();
            long r4 = this.d;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "toUserId");
            Intrinsics.checkNotNullParameter(r3, "fromSource");
            JSONObject r11 = new JSONObject();
            r11.put("to_user_id", r1);
            r11.put("ack_message", r2);
            r11.put("from_source", r3);
            long r9 = System.currentTimeMillis() - r4;
            if (r14 != null) goto L5;
            return;
        L5:
            if ((r14 instanceof ApiServerException) == false) goto L10;
            ApiServerException r15 = r14;
            int r7 = r15.getErrorCode();
            String r16 = r15.getErrorMsg();
            if (r16 != null) goto L9;
            r16 = "";
        L9:
            m.z("ack_message", r7, r16, r9, r11);
            return;
        L10:
            m.z("ack_message", 1, r14.toString(), r9, r11);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            LinkSecurityManager.e();
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r1) {
            com.bytedance.android.live.network.response.a r2 = (com.bytedance.android.live.network.response.a) r1;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.data;
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
        a = 20;
        b = new CompositeDisposable();
        d = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_UNKNOWN;
    }

    public static LinkSecurityApi.VideoCaptureType a() {
        a r0 = c;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.a());
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L16:
        if (r1 != null) goto L19;
    L21:
        if (r1 == null) goto L27;
        if (r1.intValue() != 5) goto L27;
        return LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_RADIO_MODE;
    L27:
        return LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_UNKNOWN;
    L19:
        if (r1.intValue() != 2) goto L21;
    L29:
        return LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_VIDEO;
    L14:
        if (r1.intValue() != 1) goto L16;
    L9:
        if (r1.intValue() != 0) goto L11;
        return LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_NONE;
    L5:
        r1 = null;
        goto L6
    }

    public static long c() {
        Room r0 = k.n(ILiveRoomService.class).getCurrentRoomFromRoomContext();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getRoomId();
    }

    public static String d() {
        return k.n(IUserService.class).user().n();
    }

    public static void e() {
        if (ILiveLinkCameraBackUpConfigKt.supportAudienceCheckLinker((ILiveLinkCameraBackUpConfig) k60.a.getValue()) == true) goto L5;
        return;
    L5:
        long r10 = c();
        String r0 = d();
        com.bytedance.android.live.pkaudience.api.a r1 = ((IPkAudienceLinkOutService) k.n(IPkAudienceLinkOutService.class)).getPkLinkUserInfoCenter();
        if (r1 == null) goto L28;
        ILinkPlayerInfoBridge r2 = r1.getGuestInfo(r0, "");
        if (r2 == null) goto L28;
        LinkSecurityApi.VideoCaptureType r12 = a();
        a r3 = c;
        if (r3 != null) goto L14;
    L16:
        LinkSecurityApi.AudioCaptureType r4 = LinkSecurityApi.AudioCaptureType.AUDIO_CAPTURE_DEVICE_ING;
    L17:
        LinkSecurityApi.AudioCaptureType r13 = r4;
        a r5 = c;
        if (r5 == null) goto L20;
        r5.b();
    L20:
        LinkSecurityApi.FilterReasonID r14 = LinkSecurityApi.FilterReasonID.FilterNone;
        a r6 = c;
        if (r6 == null) goto L26;
        String r7 = r6.getRtcExtInfo();
        if (r7 == null) goto L26;
        String r9 = r7;
    L27:
        Disposable r8 = ((LinkSecurityApi) com.bytedance.android.live.network.c.b().e(LinkSecurityApi.class)).checkAudienceLinkers(r10, r2.getLinkType(), r2.getSilenceStatus(), r12.ordinal(), r13.ordinal(), r14.ordinal(), r9).compose(RxUtil.rxSchedulerHelper()).subscribe(new zk0.a(r10, r0, r12, r13, r14), zk0.b.a);
        b.add(r8);
    L26:
        r9 = "";
        goto L27
    L14:
        if (r3.c() != true) goto L16;
        r4 = LinkSecurityApi.AudioCaptureType.AUDIO_CAPTURE_DEVICE_NONE;
    L28:
        Disposable r11 = Observable.timer(Math.max(a, 5), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(d.a);
        b.add(r11);
    }

    public static void f(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reqSrc");
        if (((Boolean) p60.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        a r0 = c;
        if (r0 == null) goto L21;
        String r5 = r0.getRtcExtInfo();
        if (r5 == null) goto L22;
        com.bytedance.android.live.pkaudience.api.a r1 = ((IPkAudienceLinkOutService) k.n(IPkAudienceLinkOutService.class)).getPkLinkUserInfoCenter();
        if (r1 != null) goto L13;
        return;
    L13:
        LinkSecurityApi.VideoCaptureType r2 = a();
        if (r2 != d) goto L16;
        return;
    L16:
        long r3 = c();
        ILinkPlayerInfoBridge r4 = r1.getGuestInfo(d(), "");
        if (r4 != null) goto L19;
        return;
    L19:
        d = r2;
        Disposable r11 = ((LinkSecurityApi) com.bytedance.android.live.network.c.b().e(LinkSecurityApi.class)).guestMediaInfoChangeCallBack(r3, r4.getInteractId(), r5, 0, r2.ordinal(), r10).compose(RxUtil.rxSchedulerHelper()).subscribe(e.a, f.a);
        b.add(r11);
        return;
    L22:
        return;
    }

    public static void b(String r11, String r12, AckFromSource r13) {
        Intrinsics.checkNotNullParameter(r11, "toUserId");
        Intrinsics.checkNotNullParameter(r13, "fromSource");
        if (ILiveLinkCameraBackUpConfigKt.supportReportAckMessage((ILiveLinkCameraBackUpConfig) k60.a.getValue()) == true) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(r11, d())) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r12) == false) goto L11;
        return;
    L11:
        long r0 = c();
        long r8 = System.currentTimeMillis();
        b.add(((LinkSecurityApi) com.bytedance.android.live.network.c.b().e(LinkSecurityApi.class)).ackMessage(r0, r12).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r11, r12, r13, r8), new c(r11, r12, r13, r8)));
    }
}
