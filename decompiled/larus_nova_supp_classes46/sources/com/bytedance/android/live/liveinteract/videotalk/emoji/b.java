package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ BaseDynamicEmojiDialog a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Ref.ObjectRef c;

    public b(BaseDynamicEmojiDialog r1, Ref.IntRef r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(BaseDynamicEmojiDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        if (TeamFightContext.Companion.h() == true) goto L5;
    L8:
        int r8 = this.a.V0(this.b.element);
        if (je0.d.N() == false) goto L22;
        if (this.a.n == false) goto L22;
        com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r12 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r13 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r12.getValue();
        if (r13 == null) goto L18;
        r13.t();
    L18:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.d() == false) goto L22;
        f2.b(2131919002, 0);
        return;
    L22:
        if (TextUtils.isEmpty((String) this.c.element) == true) goto L29;
        Context r3 = this.a.getContext();
        BaseDynamicEmojiDialog r0 = this.a;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m r14 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m(r3, r0.n, r8, r0.v, true, Boolean.TRUE, 32);
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L51;
        DialogLancet.handleBlockedDialogShow(r14);
    L28:
        a(this.a);
        jf0.a r15 = jf0.a.a;
        jf0.a.d(this.b.element, this.a.t);
        return;
    L51:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L27:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        goto L28
    L29:
        ArrayList<com.bytedance.android.livesdk.multilink.base.model.c0> r16 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        this.a.getClass();
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L36;
        IInteractService r17 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r17 == null) goto L36;
        if (r17.isLinkCasting() != true) goto L36;
        boolean r18 = true;
    L37:
        if (r18 == false) goto L40;
        f2.b(2131919002, 0);
        return;
    L40:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.e r19 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.e(this.a.getContext(), this.a.v, r8, false, true, r8);
        if (DialogLancet.shouldBlockDialogShow(r19) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r19);
    L45:
        a(this.a);
        jf0.a r110 = jf0.a.a;
        jf0.a.a(this.b.element, true, true, "order", this.a.t);
        return;
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L48
    L44:
        DialogLancet.beforeDialogShow(r19);
        r19.show();
        DialogLancet.afterDialogShow(r19);
    L36:
        r18 = false;
        goto L37
    L5:
        if (li0.d.g(null) == true) goto L8;
        f2.b(2131922781, 0);
    }
}
