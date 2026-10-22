package com.bytedance.android.livesdk.chatroom.ui.behavior;

import am2.x;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.t6;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import pp1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LandscapePictureTypeBehavior implements c0.b {
    public t6 a;
    public DataCenter b;
    public final Room c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.t.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.x;
    }

    public LandscapePictureTypeBehavior(Room r1) {
        this.c = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.t;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L5;
        f.d(r0, Boolean.FALSE);
        y3.m(this.b).b(ToolbarButton.MORE, new j(false));
    L5:
        a("livesdk_picture_fit_setting", null);
        if (this.a != null) goto L13;
        if (r5 == null) goto L11;
        Context r6 = r5.getContext();
        if (r6 == null) goto L11;
        t6 r1 = new t6(r6, new LandscapePictureTypeBehavior$onClick$$inlined$let$lambda$1(this));
    L12:
        this.a = r1;
    L11:
        r1 = null;
    L13:
        t6 r7 = this.a;
        if (r7 == null) goto L18;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L18;
        r8.setDimAmount(0.0f);
    L18:
        t6 r9 = this.a;
        if (r9 != null) goto L21;
        return;
    L21:
        if (r9.isShowing() == true) goto L34;
        a("livesdk_picture_fit_setting_button_show", x6.b(null));
        t6 r10 = this.a;
        if (r10 != null) goto L25;
        return;
    L25:
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r10);
        return;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L28:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        t6 r5 = this.a;
        if (r5 == null) goto L22;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r5);
    L19:
        this.a = null;
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r7 == null) goto L18;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L7:
        if (Looper.myLooper() == r6.getLooper()) goto L9;
        r6.post(DialogLancet.createDismissRunnable(r5));
        goto L19
    }

    public final void a(String r8, String r9) {
        o r0 = u.l().c(x.class);
        g r1 = u.l();
        Pair[] r2 = new Pair[8];
        IUserService r3 = k.f(IUserService.class);
        LiveMode r4 = null;
        if (r3 == null) goto L7;
        com.bytedance.android.livesdk.user.f r5 = r3.user();
        if (r5 == null) goto L7;
        String r6 = r5.n();
    L8:
        r2[0] = TuplesKt.to("user_id", r6);
        Room r7 = this.c;
        if (r7 == null) goto L11;
        String r10 = r7.getOwnerUserIdString();
    L12:
        r2[1] = TuplesKt.to("anchor_id", r10);
        r2[2] = TuplesKt.to("room_orientation", u.h);
        r2[3] = TuplesKt.to("enter_method", r0.getMap().get("enter_method"));
        r2[4] = TuplesKt.to("enter_from_merge", r0.getMap().get("enter_from_merge"));
        Room r11 = this.c;
        if (r11 == null) goto L15;
        r4 = r11.getStreamType();
    L15:
        int r12 = h1.a;
        r2[5] = TuplesKt.to("live_type", i1.a(r4));
        r2[6] = TuplesKt.to("picture_type", r9);
        if (x6.f() == false) goto L18;
        String r13 = "1";
    L19:
        r2[7] = TuplesKt.to("is_sandwich", r13);
        r1.sendLog(r8, MapsKt.mapOf(r2), new Object[0]);
        return;
    L18:
        r13 = "0";
        goto L19
    L11:
        r10 = null;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = r3;
        a("livesdk_picture_fit_setting_show", null);
    }
}
