package com.bytedance.android.livesdk.floatview.inner;

import android.content.Context;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.ui.SmallWindowQuestionCircleDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.LiveBgPlayUtil;
import com.bytedance.android.livesdk.config.bs;
import com.bytedance.android.livesdk.config.g4;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSwitchManager;
import com.bytedance.keva.Keva;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements IInnerFloatWindowSwitchManager {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
    }

    public final boolean isGlobalSwitchOpen() {
        return ((Boolean) LiveInfraSettingKeys.LIVE_ADD_FLOAT_WINDOW_SWITCH_TO_GLOBAL_CONFIG.getValue()).booleanValue();
    }

    public static void a() {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        HashMap r1 = new HashMap();
        r1.put("event_belong", "live_view");
        r1.put("event_page", "personal_homepage");
        Unit r2 = Unit.INSTANCE;
        r0.sendLog("mini_window_setting_open", r1, new Object[0]);
    }

    public static void b(String r3) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        HashMap r1 = new HashMap();
        r1.put("click_result", r3);
        r1.put("event_page", "personal_homepage");
        Unit r4 = Unit.INSTANCE;
        r0.sendLog("livesdk_part_mini_window_set_click", r1, new Object[0]);
    }

    public final boolean canShowSwitch(IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType r4) {
        Intrinsics.checkNotNullParameter(r4, "switchType");
        if (((Boolean) LiveInfraSettingKeys.LIVE_ADD_FLOAT_WINDOW_SWITCH_TO_GLOBAL_CONFIG.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        int r5 = d.a[r4.ordinal()];
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L22;
        if (r5 == 3) goto L13;
        return false;
    L13:
        if (bs.a.getValue().booleanValue() == false) goto L15;
    L16:
        return true;
    L15:
        if (g4.a.getValue().booleanValue() == true) goto L16;
        return false;
    L22:
        return com.bytedance.android.livesdk.floatview.p.b();
    L19:
        return LiveBgPlayUtil.a().a();
    }

    public final void showPartSceneWindowDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        SmallWindowQuestionCircleDialog r0 = new SmallWindowQuestionCircleDialog(r2);
        r0.B = true;
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    public final boolean hasPermission(Context r3, IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "switchType");
        int r5 = d.b[r4.ordinal()];
        if (r5 != 1) goto L5;
        return true;
    L5:
        if (r5 == 2) goto L11;
        if (r5 == 3) goto L17;
        return true;
    L17:
        return rx1.m.e(r3);
    L11:
        if (com.bytedance.android.livesdk.floatview.p.e() == false) goto L15;
        return rx1.m.f(r3);
    L15:
        return rx1.m.e(r3);
    }

    public final boolean isSwitchEnable(Context r3, IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "switchType");
        int r5 = d.c[r4.ordinal()];
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L11;
        if (r5 == 3) goto L18;
    L15:
        return false;
    L18:
        return h.b(r3);
    L11:
        if (com.bytedance.android.livesdk.floatview.p.f() == false) goto L13;
        return true;
    L13:
        if (com.bytedance.android.livesdk.floatview.p.d(r3) == false) goto L15;
        return true;
    L17:
        return LiveBgPlayUtil.b;
    }

    public final boolean requestPermission(Context r3, IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "switchType");
        int r5 = d.e[r4.ordinal()];
        if (r5 == 1) goto L9;
        if (r5 == 2) goto L7;
        return false;
    L7:
        rx1.m.h(r3);
        return true;
    L9:
        if (com.bytedance.android.livesdk.floatview.p.e() == false) goto L11;
        com.bytedance.android.livesdk.floatview.p.h(r3);
        return true;
    L11:
        com.bytedance.android.livesdk.floatview.p.g(r3);
        return true;
    }

    public final void enableSwitch(Context r7, boolean r8, IInnerFloatWindowSwitchManager.LiveFloatWindowSwitchType r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "switchType");
        int r10 = d.d[r9.ordinal()];
        if (r10 == 1) goto L29;
        if (r10 != 2) goto L6;
        if (r8 == true) goto L17;
        com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.b.k0;
        Boolean r12 = Boolean.FALSE;
        r11.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r11, r12);
        com.bytedance.android.livesdk.log.g r13 = u.l();
        HashMap r14 = new HashMap();
        r14.put("event_belong", "live_view");
        r14.put("event_page", "personal_homepage");
        Unit r15 = Unit.INSTANCE;
        r13.sendLog("mini_window_setting_close", r14, new Object[0]);
        return;
    L17:
        if (com.bytedance.android.livesdk.floatview.p.e() == false) goto L23;
        if (rx1.m.f(r7) == false) goto L21;
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.k0;
        Boolean r17 = Boolean.TRUE;
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r17);
        a();
        return;
    L21:
        com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.b.k0;
        Boolean r19 = Boolean.TRUE;
        r18.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r18, r19);
        com.bytedance.android.livesdk.floatview.p.h(r7);
        a();
        return;
    L23:
        if (rx1.m.e(r7) == false) goto L26;
        com.bytedance.android.livesdk.sharedpref.e r20 = com.bytedance.android.livesdk.sharedpref.b.k0;
        Boolean r21 = Boolean.TRUE;
        r20.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r20, r21);
        a();
        return;
    L26:
        if (rx1.m.e(r7) == true) goto L40;
        com.bytedance.android.livesdk.sharedpref.e r22 = com.bytedance.android.livesdk.sharedpref.b.k0;
        Boolean r23 = Boolean.TRUE;
        r22.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r22, r23);
        com.bytedance.android.livesdk.floatview.p.g(r7);
        a();
        return;
    L40:
        return;
    L6:
        if (r10 != 3) goto L43;
        if (r8 == true) goto L10;
        com.bytedance.android.livesdk.sharedpref.e r24 = b6.j;
        r24.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r24, 2);
        b("close");
        return;
    L10:
        if (rx1.m.e(r7) == false) goto L12;
        com.bytedance.android.livesdk.sharedpref.e r25 = b6.j;
        r25.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r25, 1);
    L13:
        b("open");
        return;
    L12:
        rx1.m.h(r7);
        com.bytedance.android.livesdk.sharedpref.e r26 = b6.j;
        r26.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r26, 1);
        goto L13
    L43:
        return;
    L29:
        LiveBgPlayUtil.b = r8;
        ((Keva) LiveBgPlayUtil.a.getValue()).storeBoolean("key_keep_playing_switch_config", r8);
        j0 r27 = j0.l();
        Pair[] r28 = new Pair[2];
        if (r8 == false) goto L32;
        String r29 = "turn_on";
    L33:
        r28[0] = TuplesKt.to("click_type", r29);
        r28[1] = TuplesKt.to("event_page", "personal_homepage");
        r27.sendLog("livesdk_background_video_setting_click", MapsKt.mutableMapOf(r28), new Object[0]);
        return;
    L32:
        r29 = "turn_off";
        goto L33
    }
}
