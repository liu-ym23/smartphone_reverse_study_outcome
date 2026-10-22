package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.y2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import n62.i;
import pp1.g;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements c0.b {
    public View a;
    public final CompositeDisposable b;
    public DataCenter c;
    public a d;
    public boolean e;
    public final DataCenter f;
    public final RoomContext g;
    public final s22.e h;
    public final boolean i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.chatchannel.toolbar.a$a, reason: collision with other inner class name */
    public static final class C0107a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void a() {
            final a r0 = this.a;
            r0.getClass();
            RoomContext.a r1 = RoomContext.Companion;
            DataCenter r2 = r0.c;
            r1.getClass();
            RoomContext r3 = RoomContext.a.a(r2, 0);
            if (r3 == null) goto L17;
            View r4 = r0.a;
            if (r4 == null) goto L17;
            Context r5 = r4.getContext();
            if (r5 == null) goto L17;
            View r6 = r0.a;
            if (r6 == null) goto L17;
            a0 r7 = (a0) r3.getToolbarBubbleManager().getValue();
            if (r7 == null) goto L17;
            int r8 = pp1.c.o;
            pp1.c r9 = pp1.c.a.a("邀请朋友边看边聊");
            r7.addBubble(r9, r9.k, new q2(r0.c, r5, r6), new ChatChannelToolbarBehavior$showGuideBubble$1(r0));
            boolean r10 = true;
        L18:
            if (r10 == false) goto L21;
            com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.b.g3;
            Boolean r13 = Boolean.TRUE;
            r11.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r11, r13);
            return;
        L21:
            return;
        L17:
            r10 = false;
            goto L18
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final boolean showRedDot() {
        return true;
    }

    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.i;
    }

    public final void SY(s r6) {
        if (u40.a.a() == false) goto L26;
        if (r6 == null) goto L27;
        k r0 = r6.c;
        if (y3.m(this.f).n(ToolbarButton.ROOM_CHANNEL) == false) goto L30;
        SkinLoader.c.getClass();
        if (SkinLoader.a.b() == true) goto L11;
    L20:
        if (r0 == null) goto L31;
        Disposable r7 = a1.l(r0, s1.f(38.0f), s1.f(38.0f), false, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a);
        if (r7 == null) goto L29;
        RxUtilKt.c(r7, this.b);
        return;
    L29:
        return;
    L31:
        return;
    L11:
        if (this.i == true) goto L20;
        SkinLoader r8 = SkinLoader.a.e(r6);
        View r1 = this.a;
        if (r1 == null) goto L15;
        View r2 = r1.findViewById(2131374718);
    L16:
        if (r2 == null) goto L20;
        ResKeyEnum r3 = ResKeyEnum.STATIC_ICON;
        if (r8.b(y2.b(r3)) == null) goto L20;
        r8.c(y2.a(r3, 2131251454), r2, new com.bytedance.android.livesdk.interactivity.chatchannel.toolbar.b(this));
        return;
    L15:
        r2 = null;
        goto L16
    L30:
        return;
    L27:
        return;
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r5) {
        Intrinsics.checkNotNullParameter(r5, "command");
        if (u40.a.a() == true) goto L6;
        return;
    L6:
        if (this.i == false) goto L9;
        return;
    L9:
        if ((r5 instanceof g) == false) goto L21;
        StringBuilder r0 = new StringBuilder("move to more = ");
        g r6 = (g) r5;
        r0.append(r6.a);
        ALogger.e("ToolbarRoomChannelBehavior", r0.toString());
        DataCenter r1 = this.c;
        if (r1 == null) goto L14;
        r1.put("data_room_channel_move_to_more", Boolean.valueOf(r6.a));
    L14:
        if (r6.a == true) goto L16;
        y3.f(this.f).d(ToolbarButton.ROOM_CHANNEL, this.d);
        return;
    L16:
        if (this.d != null) goto L18;
        this.d = new a(this.f, this.g, this.h, true);
    L18:
        y3.f(this.f).k(ToolbarButton.ROOM_CHANNEL, this.d);
        return;
    }

    public final void onClick(View r13) {
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L10;
        com.bytedance.android.livesdk.user.f r0 = f72.b.a().user();
        if (r13 == null) goto L7;
        Context r14 = r13.getContext();
    L8:
        r0.login(r14, new l(new l.a())).subscribe(new h());
        return;
    L7:
        r14 = null;
        goto L8
    L10:
        if (r13 == null) goto L33;
        Context r2 = r13.getContext();
        if (r2 == null) goto L36;
        s22.a r6 = (s22.a) sh6.c.b((sh6.b) this.h.getCurrentChannel().getValue());
        if (r6 == null) goto L25;
        DataCenter r3 = this.c;
        if (r3 == null) goto L37;
        ChannelMemberManagerDialog r15 = new ChannelMemberManagerDialog(r2, r3, ((Room) this.g.getRoom().getValue()).id, r6, this.h);
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r15);
        return;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L23:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
        return;
    L37:
        return;
    L25:
        if (this.i == false) goto L27;
        String r16 = "more";
    L28:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r1 = new com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e(r16);
        n62.h.a(r2, this.g, this.f, this.h, new i(true, 200, true, r1)).c(this.b);
        j.c(r1);
        return;
    L27:
        r16 = "toolbar";
        goto L28
    L36:
        return;
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e = false;
        this.b.clear();
        this.a = null;
    }

    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.a = r3;
        this.c = r4;
        ImageView r5 = (ImageView) r3.findViewById(2131384095);
        if (r5 == null) goto L6;
        r5.getVisibility();
    L6:
        if (this.e == true) goto L13;
        this.e = true;
        int r6 = j.a;
        if (this.i == false) goto L10;
        String r7 = "more";
    L11:
        j.d(false, r7);
        goto L13
    L10:
        r7 = "toolbar";
    L13:
        if (this.i == false) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual((Boolean) com.bytedance.android.livesdk.sharedpref.b.g3.getValue(), Boolean.FALSE) == false) goto L19;
        MainThreadPostUtils.c(new b(this), 500);
        return;
    }

    public a(DataCenter r2, RoomContext r3, s22.e r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "chatChannelManager");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.b = new CompositeDisposable();
    }
}
