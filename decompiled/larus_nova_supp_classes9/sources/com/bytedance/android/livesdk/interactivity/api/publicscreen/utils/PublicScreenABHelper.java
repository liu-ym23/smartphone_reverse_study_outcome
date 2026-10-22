package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.g7;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.i0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.j0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.n0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.o0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.p0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.r0;
import com.bytedance.android.livesdk.k7;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenAttachments;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenInfo;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.com.bytedance.android.livesdk.model.LiveFirstMessageOptConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.j3;
import r52.o3;
import r52.s3;
import r52.u4;
import r52.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PublicScreenABHelper {
    public static final Lazy A = null;
    public static final Lazy B = null;
    public static final boolean C = false;
    public static final o0 D = null;
    public static final Lazy E = null;
    public static final Lazy F = null;
    public static final Lazy G = null;
    public static final Lazy H = null;
    public static final Lazy I = null;
    public static final Lazy J = null;
    public static final boolean K = false;
    public static final Lazy L = null;
    public static final Lazy M = null;
    public static final Lazy N = null;
    public static final Lazy O = null;
    public static final boolean P = false;
    public static final long Q = 0;
    public static final boolean R = false;
    public static final Boolean S = null;
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Boolean p = null;
    public static final Boolean q = null;
    public static final Lazy r = null;
    public static final Lazy s = null;
    public static final Lazy t = null;
    public static final Lazy u = null;
    public static final Lazy v = null;
    public static final Lazy w = null;
    public static final Lazy x = null;
    public static final Lazy y = null;
    public static final Lazy z = null;

    public static float e() {
        return ((Number) J.getValue()).floatValue();
    }

    public static final a0 f() {
        return (a0) G.getValue();
    }

    public static final r0 h() {
        return (r0) F.getValue();
    }

    static {
        a = LazyKt.lazy(PublicScreenABHelper$audienceWaitBufferScrollSize$2.INSTANCE);
        b = LazyKt.lazy(PublicScreenABHelper$audienceWaitBufferFoldSize$2.INSTANCE);
        c = LazyKt.lazy(PublicScreenABHelper$anchorWaitBufferScrollSize$2.INSTANCE);
        d = LazyKt.lazy(PublicScreenABHelper$anchorWaitBufferFoldSize$2.INSTANCE);
        e = LazyKt.lazy(PublicScreenABHelper$audienceDynamicSpeedStrategyV2$2.INSTANCE);
        f = LazyKt.lazy(PublicScreenABHelper$audienceDynamicSpeedLevelConfigV2$2.INSTANCE);
        g = LazyKt.lazy(PublicScreenABHelper$anchorDynamicSpeedStrategyV2$2.INSTANCE);
        h = LazyKt.lazy(PublicScreenABHelper$anchorDynamicSpeedLevelConfigV2$2.INSTANCE);
        i = LazyKt.lazy(PublicScreenABHelper$individualConfigForAnchor$2.INSTANCE);
        j = LazyKt.lazy(PublicScreenABHelper$individualConfigForAudience$2.INSTANCE);
        k = LazyKt.lazy(PublicScreenABHelper$audienceUpdateHotOptConfig$2.INSTANCE);
        l = LazyKt.lazy(PublicScreenABHelper$heightPlatformStrategyConfig$2.INSTANCE);
        m = LazyKt.lazy(PublicScreenABHelper$customerEntranceRemoteIconEnable$2.INSTANCE);
        n = LazyKt.lazy(PublicScreenABHelper$useCustomItemAnimator$2.INSTANCE);
        o = LazyKt.lazy(PublicScreenABHelper$enableFocusWhenMove$2.INSTANCE);
        p = (Boolean) z2.a.getValue();
        q = (Boolean) j3.a.getValue();
        r = LazyKt.lazy(PublicScreenABHelper$enableUpdateWhenHeightChange$2.INSTANCE);
        s = LazyKt.lazy(PublicScreenABHelper$heatAudienceConfig$2.INSTANCE);
        t = LazyKt.lazy(PublicScreenABHelper$heatAnchorConfig$2.INSTANCE);
        u = LazyKt.lazy(PublicScreenABHelper$animOptConfig$2.INSTANCE);
        v = LazyKt.lazy(PublicScreenABHelper$messageHeatAnchorStrategy$2.INSTANCE);
        w = LazyKt.lazy(PublicScreenABHelper$messageHeatAudienceStrategy$2.INSTANCE);
        x = LazyKt.lazy(PublicScreenABHelper$messageBufferSizeAudienceConfig$2.INSTANCE);
        y = LazyKt.lazy(PublicScreenABHelper$messageBufferSizeAnchorConfig$2.INSTANCE);
        z = LazyKt.lazy(PublicScreenABHelper$anchorShowOrderMessageEnable$2.INSTANCE);
        A = LazyKt.lazy(PublicScreenABHelper$audienceShowOrderMessageEnable$2.INSTANCE);
        B = LazyKt.lazy(PublicScreenABHelper$enableGiftMessageDecoupleInPublicScreen$2.INSTANCE);
        C = ((Boolean) s3.a.getValue()).booleanValue();
        D = (o0) o3.a.getValue();
        E = LazyKt.lazy(PublicScreenABHelper$animFramesPerSecond$2.INSTANCE);
        F = LazyKt.lazy(PublicScreenABHelper$styleOptConfig$2.INSTANCE);
        G = LazyKt.lazy(PublicScreenABHelper$horizontalHeightOptConfig$2.INSTANCE);
        H = LazyKt.lazy(PublicScreenABHelper$templateSwitch$2.INSTANCE);
        I = LazyKt.lazy(PublicScreenABHelper$fusionEmojiSendEnable$2.INSTANCE);
        J = LazyKt.lazy(PublicScreenABHelper$fusionEmojiResizeFactor$2.INSTANCE);
        K = ((n0) u4.a.getValue()).enable;
        L = LazyKt.lazy(PublicScreenABHelper$overlappingHeight$2.INSTANCE);
        M = LazyKt.lazy(PublicScreenABHelper$enableNewPSOperateExpandScene$2.INSTANCE);
        N = LazyKt.lazy(PublicScreenABHelper$audienceMentionChatShowStyle$2.INSTANCE);
        O = LazyKt.lazy(PublicScreenABHelper$anchorMentionChatShowStyle$2.INSTANCE);
        g7 r0 = g7.a;
        boolean r1 = ((LiveFirstMessageOptConfig) r0.getValue()).getEnable();
        P = r1;
        Q = ((LiveFirstMessageOptConfig) r0.getValue()).getThreshold();
        if (r1 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        R = r2;
        S = (Boolean) k7.a.getValue();
        return;
    L5:
        if (((LiveFirstMessageOptConfig) r0.getValue()).getEnableVSSimplifyFirstMessage() == false) goto L7;
        r2 = true;
        goto L8
    }

    public static boolean c() {
        return !Float.valueOf(e()).equals(Float.valueOf(1.0f));
    }

    @JvmStatic
    public static final boolean a(IRoom r6) {
        if (r6 != null) goto L5;
        return true;
    L5:
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r1 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r2 == null) goto L28;
        com.bytedance.live.datacontext.n r3 = r2.getTemplateContext();
        if (r3 == null) goto L29;
        z70.b r4 = (z70.b) r3.getValue();
        if (r4 == null) goto L34;
        int r5 = com.bytedance.android.livesdk.interactivity.service.model.e.a;
        if (com.bytedance.android.livesdk.interactivity.service.model.e.a.a().hotMsgTray == true) goto L17;
        return true;
    L17:
        if (r4.k() == false) goto L31;
        RoomPublicScreenInfo r7 = gb2.b.b(r6);
        if (r7 == null) goto L32;
        RoomPublicScreenAttachments r8 = r7.attachments;
        if (r8 != null) goto L23;
        return true;
    L23:
        if (r8.hotMessageTray != 2) goto L35;
        return false;
    L35:
        return true;
    L32:
        return true;
    L31:
        return true;
    L34:
        return true;
    L29:
        return true;
    L28:
        return true;
    L27:
        return true;
    }

    public static boolean b(IRoom r1) {
        if (((Boolean) I.getValue()).booleanValue() == false) goto L10;
        if (r1 == null) goto L10;
        IRoomAuthStatus r2 = r1.getRoomAuthStatus();
        if (r2 == null) goto L10;
        if (r2.isEnableFusionEmoji() != true) goto L10;
        return true;
    L10:
        return false;
    }

    @JvmStatic
    public static final j0 d(boolean r2) {
        if (r2 == false) goto L12;
        Lazy r3 = h;
        List<p0> r1 = ((j0) r3.getValue()).b();
        if (r1 == null) goto L11;
        if (r1.isEmpty() != true) goto L11;
        int r4 = j0.a;
        return j0.a.a();
    L11:
        return (j0) r3.getValue();
    L12:
        Lazy r5 = f;
        List<p0> r6 = ((j0) r5.getValue()).b();
        if (r6 == null) goto L19;
        if (r6.isEmpty() != true) goto L19;
        int r7 = j0.a;
        return j0.a.a();
    L19:
        return (j0) r5.getValue();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.interactivity.api.settings.config.m g(boolean r0) {
        if (r0 == false) goto L5;
        return (com.bytedance.android.livesdk.interactivity.api.settings.config.m) i.getValue();
    L5:
        return (com.bytedance.android.livesdk.interactivity.api.settings.config.m) j.getValue();
    }

    @JvmStatic
    public static final boolean i(IRoom r4) {
        Intrinsics.checkNotNullParameter(r4, "room");
        i0 r1 = (i0) u.getValue();
        if (r1.b() == true) goto L5;
        return false;
    L5:
        if (r1.a() == false) goto L19;
        Intrinsics.checkNotNullParameter(r4, "room");
        IBaseStreamUrl r0 = r4.getStreamUrl();
        if (r0 != null) goto L9;
    L11:
        IStreamUrlExtra r5 = r4.getStreamUrlExtraSafely();
        if (r5.getWidth() <= r5.getHeight()) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L10;
        boolean r7 = false;
    L18:
        if (r7 == true) goto L19;
        return false;
    L10:
        r7 = true;
        goto L18
    L14:
        r6 = false;
        goto L15
    L9:
        if (r0.getStreamOrientation() != 2) goto L11;
    L19:
        return true;
    }
}
