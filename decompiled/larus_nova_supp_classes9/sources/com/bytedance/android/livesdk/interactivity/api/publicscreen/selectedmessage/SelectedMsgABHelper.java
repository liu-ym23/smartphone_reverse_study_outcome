package com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.settings.config.f0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.UriProtector;
import gd0.v;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SelectedMsgABHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    public static f0 b() {
        return (f0) a.getValue();
    }

    static {
        a = LazyKt.lazy(SelectedMsgABHelper$config$2.INSTANCE);
        b = LazyKt.lazy(SelectedMsgABHelper$aiConfig$2.INSTANCE);
        c = LazyKt.lazy(SelectedMsgABHelper$aiAgentZoomOutDelay$2.INSTANCE);
        d = LazyKt.lazy(SelectedMsgABHelper$aiAgentAutoFocusDelay$2.INSTANCE);
        e = LazyKt.lazy(SelectedMsgABHelper$isAiAgentOpenSettingPad$2.INSTANCE);
        f = LazyKt.lazy(SelectedMsgABHelper$excludePk$2.INSTANCE);
        g = LazyKt.lazy(SelectedMsgABHelper$enableAudio$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean c(DataCenter r5) {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r5, 0, 2);
        if (r0 == null) goto L7;
        i r1 = r0.getLiveMode();
        if (r1 == null) goto L7;
        LiveMode r2 = (LiveMode) r1.getValue();
    L9:
        if (r2 != LiveMode.VIDEO) goto L17;
        if (f(r5, null) == true) goto L13;
        return false;
    L13:
        if (g(r5, null) == false) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r2 == LiveMode.AUDIO) goto L19;
        return false;
    L19:
        if (e(r5) == true) goto L21;
        return false;
    L21:
        if (f(r5, null) == false) goto L28;
        return true;
    L28:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean d(f<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        u3 r5 = r4.b;
        if ((r5 instanceof u3) == true) goto L5;
        r5 = null;
    L5:
        u3 r6 = r5;
        if (r6 == null) goto L12;
        IPublicAreaCommon r7 = r6.getOrInitPublicAreaCommon();
        if (r7 == null) goto L12;
        if (r7.isSelected() != 1) goto L12;
        return true;
    L12:
        return false;
    }

    @JvmStatic
    public static final boolean e(DataCenter r4) {
        MiddlewareRoomContext r5 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r4, 0, 2);
        if (r5 == null) goto L19;
        j r6 = r5.getVoiceTalkRoomSubScene();
        if (r6 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r6.getValue();
        if (r7 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r8 = r7.t();
        if (r8 == null) goto L19;
        ALogger.i("PSSelectedMessage", "current voice scene: " + r8.a + ",uiLayout:" + r8.b);
        int r0 = r8.a;
        if (r0 != 0) goto L15;
        if (r8.b != 0) goto L15;
    L18:
        return true;
    L15:
        if (r0 != 5) goto L19;
        if (r8.b == 29) goto L18;
    L19:
        return false;
    }

    @JvmStatic
    public static final boolean f(DataCenter r6, Integer r7) {
        LiveMode r0 = null;
        if (r7 != null) goto L7;
        if (r6 == null) goto L6;
        r7 = (Integer) r6.get("data_link_state", 0);
        goto L7
    L6:
        r7 = null;
    L7:
        if (r7 == null) goto L9;
        int r8 = r7.intValue();
    L10:
        ALogger.i("PSSelectedAiAgent", "isSupportedLinkState, state = " + r8);
        MiddlewareRoomContext r9 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r6, 0, 2);
        if (r9 == null) goto L16;
        i r10 = r9.getLiveMode();
        if (r10 == null) goto L16;
        r0 = (LiveMode) r10.getValue();
    L16:
        if (r0 != LiveMode.VIDEO) goto L31;
        if (((Boolean) f.getValue()).booleanValue() == true) goto L20;
        boolean r11 = v.a(r8, 32);
    L26:
        if (r8 == 0) goto L28;
        if (r11 == true) goto L28;
        return false;
    L28:
        return true;
    L20:
        if (v.a(r8, 32) == true) goto L22;
    L24:
        r11 = false;
        goto L26
    L22:
        if (v.a(r8, 4) == true) goto L24;
        r11 = true;
        goto L26
    L31:
        if (r0 == LiveMode.AUDIO) goto L33;
        return false;
    L33:
        if (r8 == 8) goto L35;
        if (r8 == 0) goto L35;
        return false;
    L35:
        return true;
    L9:
        r8 = 0;
        goto L10
    }

    @JvmStatic
    public static final boolean g(DataCenter r1, Integer r2) {
        if (r2 != null) goto L7;
        IInteractivityInjectService r3 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r3 == null) goto L6;
        r2 = r3.getVideoTalkRoomSubScene(r1);
        goto L7
    L6:
        r2 = null;
    L7:
        if (r2 != null) goto L10;
    L11:
        if (r2 != null) goto L14;
    L16:
        return false;
    L14:
        if (r2.intValue() != 0) goto L16;
    L17:
        return true;
    L10:
        if (r2.intValue() == 8) goto L17;
        goto L11
    }

    @JvmStatic
    public static final boolean a(boolean r2, IRoom r3, LiveMode r4) {
        if (r2 == false) goto L26;
        if (r3 == null) goto L27;
        IRoomAuthStatus r5 = r3.getRoomAuthStatus();
        if (r5 != null) goto L8;
        return false;
    L8:
        if (r5.isPSSelectedMessageEnable() == true) goto L10;
        return false;
    L10:
        if (b().enable == true) goto L12;
        return false;
    L12:
        if (r4 != LiveMode.VIDEO) goto L14;
    L24:
        return true;
    L14:
        if (r4 != LiveMode.AUDIO) goto L22;
        Map r6 = IRoomKt_androidKt.getAnchorABMap((IRoomBase) r3);
        if (r6 == null) goto L18;
        String r7 = (String) r6.get("public_area_helper_radio_ab_value");
    L20:
        if (Intrinsics.areEqual(r7, "1") == false) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L24;
        return false;
    L18:
        r7 = null;
    L22:
        r8 = false;
        goto L23
    L27:
        return false;
    L26:
        return false;
    }

    @JvmStatic
    public static final void h(Context r5, DataCenter r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "source");
        if (r6 != null) goto L5;
        return;
    L5:
        boolean r0 = false;
        boolean r1 = a0.d(r6, false);
        IRoom r2 = a0.n(r6);
        Intrinsics.checkNotNullParameter(r6, "$this$getMiddlewareLiveMode");
        if (a(r1, r2, (LiveMode) r6.get("data_live_mode", LiveMode.UNDEFINED)) == true) goto L8;
    L21:
        f2.c(s1.B(2131922408), 0);
        return;
    L8:
        if (c(r6) == false) goto L21;
        if (r8 != null) goto L12;
        r8 = b().settingPageSchema;
    L12:
        if (r8 != null) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L23;
        Uri r9 = UriProtector.parse(r8 + "&request_source=" + r7);
        IBaseLiveActionHandler r10 = k.f(IBaseLiveActionHandler.class);
        if (r10 == null) goto L24;
        r10.handle(r5, r9);
        return;
    L24:
        return;
    L23:
        return;
    L14:
        if (r8.length() != 0) goto L16;
        goto L15
    }
}
