package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    public r() {
    }

    public static q d() {
        ReplayPlayUtil$getVideoEngineFactory$1 r0 = ReplayPlayUtil$getVideoEngineFactory$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "onRemedyAction");
        return new q(r0);
    }

    static {
    }

    public static Resolution a(VideoModel r10) {
        Intrinsics.checkNotNullParameter(r10, "videoModel");
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r0 = nq1.d.b;
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.c(((VideoResolutionItem) r0.getValue()).getKey()) == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.f.d(r0, nq1.d.a.getValue());
    L5:
        VideoResolutionItem r1 = (VideoResolutionItem) r0.getValue();
        com.bytedance.android.livesdk.sharedpref.e<VideoResolutionItem> r2 = nq1.d.a;
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r1);
        Resolution[] r11 = r10.getSupportResolutions();
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L39;
        Resolution r3 = null;
        if (r11 == null) goto L19;
        int r4 = r11.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L15;
        Resolution r6 = r11[r5];
        if (Intrinsics.areEqual(r6.toString(VideoRef.TYPE_VIDEO), r1.getKey()) == true) goto L16;
        r5 = r5 + 1;
    L16:
        if (r6 == null) goto L19;
    L18:
        r3 = r6;
    L36:
        if (r3 == null) goto L45;
        return r3;
    L45:
        return com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a(r11, jc1.a.b());
    L15:
        r6 = null;
    L19:
        if (r11 == null) goto L36;
        int r7 = r11.length;
        int r8 = 0;
    L21:
        if (r8 >= r7) goto L36;
        r6 = r11[r8];
        String r9 = r6.toString(VideoRef.TYPE_VIDEO);
        String r12 = r1.getKey();
        if (r12 != null) goto L25;
        r12 = "null";
    L25:
        boolean r13 = StringsKt.contains$default(r9, r12, false, 2, null);
        boolean r14 = true;
        if (r13 == true) goto L33;
        String r15 = r1.getKey();
        if (r15 != null) goto L30;
    L32:
        r14 = false;
        goto L33
    L30:
        if (StringsKt.contains$default(r15, r6.toString(VideoRef.TYPE_VIDEO), false, 2, null) != true) goto L32;
    L33:
        if (r14 == true) goto L18;
        r8 = r8 + 1;
        goto L21
    L39:
        return com.bytedance.android.livesdk.chatroom.vs_base.base.util.l.a(r11, jc1.a.b());
    }

    public static VideoModel e(String r2) {
        if (r2 == null) goto L10;
        VideoRef r0 = new VideoRef();
        r0.extractFields(new JSONObject(r2));     // Catch: Throwable -> L6
    L8:
        VideoModel r3 = new VideoModel();
        r3.setVideoRef(r0);
        return r3;
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    L10:
        return null;
    }

    public static /* synthetic */ u c(jq1.c r13, long r14, long r16, int r18) {
        return b(0, r13, -1, r14, r16, r18, 0, true, -1L);
    }

    public static u b(long r24, jq1.c r26, long r27, long r29, long r31, int r33, int r34, boolean r35, Long r36) {
        Intrinsics.checkNotNullParameter(r26, "localProgress");
        if (r24 >= r26.b) goto L7;
        long r9 = r26.a;
        if (r9 == 0) goto L7;
    L8:
        long r13 = r33;
        if (r9 < (r13 - 5000)) goto L13;
        r9 = 0;
    L13:
        if (r31 <= 0) goto L16;
        r9 = r31;
        int r18 = 2;
    L22:
        long r10 = r9 + ((long) r34);
        if (r10 < r13) goto L25;
    L26:
        r10 = 0;
        r18 = 0;
    L27:
        if (r35 == true) goto L39;
        long r11 = -1;
        if (r36 == null) goto L31;
        long r21 = r36.longValue();
    L32:
        long r19 = 0;
        if (r21 <= 0) goto L40;
        if (r36 == null) goto L37;
        r11 = r36.longValue();
    L37:
        if (r10 <= ((r11 - ((long) 2)) * 1000)) goto L40;
        long r12 = 0;
        int r7 = 0;
    L42:
        if (r7 == 1) goto L44;
    L54:
        ALogger.e("ReplayPlayUtil", "getStartTime params(serverTs:" + r24 + " localProgress:" + r26 + " videoStartPosition:" + r27 + " startPosition:" + r29 + " duration:" + r33 + " progressOffset:" + r34 + " hasFullRight:" + r35 + " freeDuration:" + r36 + ") return(progress:" + r12 + " startPositionType:" + r7 + ")");
        return new u(r12, r7);
    L44:
        if (r12 > AppointmentService.SOURCE_UNDEFINED) goto L46;
    L53:
        r12 = r19;
        r7 = 0;
        goto L54
    L46:
        if (r12 >= r13) goto L53;
        if (r12 < r13) goto L50;
    L52:
        r12 = r12 - AppointmentService.SOURCE_UNDEFINED;
        goto L54
    L50:
        if (r12 < (r13 - AppointmentService.SOURCE_UNDEFINED)) goto L52;
    L40:
        r12 = r10;
        r7 = r18;
        goto L42
    L31:
        r21 = -1;
        goto L32
    L39:
        r19 = 0;
        goto L40
    L25:
        if (r10 >= 0) goto L27;
    L16:
        if (r29 <= 0) goto L19;
        r9 = r29;
        r18 = 4;
        goto L22
    L19:
        if (r9 <= 0) goto L21;
        r18 = 1;
        goto L22
    L21:
        r9 = 0;
        r18 = 0;
    L7:
        r9 = r27;
        goto L8
    }
}
