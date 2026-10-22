package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.admin.prompt.PrompterDataContext;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.roommanage.admin.PrompterDialog;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.Panel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o4 extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
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

    public o4() {
        super(ToolbarButton.PROMPT, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.r(o4.class));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2
    public final boolean b() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.e, 0, 2);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m r1 = r0.isPortraitInteraction();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        RoomPermissionContext.a r2 = RoomPermissionContext.Companion;
        DataCenter r3 = this.e;
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r4 = LiveRoomPermission.m;
        r2.getClass();
        if (RoomPermissionContext.a.e(r3, r4) == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        com.bytedance.android.livesdk.sharedpref.e r1 = new com.bytedance.android.livesdk.sharedpref.e("has_show_admin_prompt_red_dot_" + jc1.k.n(IUserService.class).user().n(), Boolean.FALSE);
        Boolean r0 = (Boolean) r1.getValue();
        Boolean r2 = Boolean.TRUE;
        Intrinsics.areEqual(r0, r2);
        return !Intrinsics.areEqual((Boolean) r1.getValue(), r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e2
    public final Panel a() {
        return Panel.MORE;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.l;
    }

    public final void c(String r6) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.e, 0, 2);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m r1 = r0.getUser();
        if (r1 == null) goto L12;
        User r2 = (User) r1.getValue();
        if (r2 == null) goto L13;
        com.bytedance.android.livesdk.log.g r3 = com.bytedance.android.livesdk.log.u.l();
        PrompterDataContext.Companion.getClass();
        Map r4 = PrompterDataContext.a.b(r2);
        r4.put("action_type", r6);
        Unit r7 = Unit.INSTANCE;
        r3.f("livesdk_prompter_button", r4, new Object[]{Room.class, am2.x.class});
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("has_show_admin_prompt_red_dot_" + jc1.k.n(IUserService.class).user().n(), Boolean.FALSE), Boolean.TRUE);
        c("click");
        Activity r6 = bz2.b.a(r5.getContext());
        if ((r6 instanceof FragmentActivity) == true) goto L5;
        r6 = null;
    L5:
        FragmentActivity r7 = (FragmentActivity) r6;
        if (r7 != null) goto L8;
        return;
    L8:
        PrompterDialog r0 = new PrompterDialog();
        FragmentManager r8 = r7.getSupportFragmentManager();
        String r1 = o4.class.getSimpleName();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r1, r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r0, r2) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        r0.show(r8, r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e = r3;
        c("show");
    }
}
