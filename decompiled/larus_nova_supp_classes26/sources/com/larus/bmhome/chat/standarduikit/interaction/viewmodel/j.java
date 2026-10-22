package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.standarduikit.browsercontrol.utils.BrowserControlTipDialog;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j implements g {
    public final FragmentActivity a;
    public final tp8.h b;
    public final tp8.f c;
    public String d;
    public h e;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.standarduikit.interaction.viewmodel.g
    public final void dispose() {
        this.e = null;
        String r0 = this.d;
        if (r0 == null) goto L6;
        c(r0, true);
        return;
    }

    @Override // com.larus.bmhome.chat.standarduikit.interaction.viewmodel.g
    public final void b(f r13) {
        Intrinsics.checkNotNullParameter(r13, "vmData");
        int r0 = com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.a;
        com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.a.b(new com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b(r13.c, r13.a, r13.d, r13.e, r13.g, r13.f, r13.h, r13.b, 2752));
    }

    @Override // com.larus.bmhome.chat.standarduikit.interaction.viewmodel.g
    public final boolean finish(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        tp8.f r0 = this.c;
        if (r0 != null) goto L6;
        FLogger.a.w("InteractionQuickReplyDep", "[finish] host pass data missing, reason=" + r6);
        return false;
    L6:
        boolean r1 = r0.finish(r6);
        if (r1 == false) goto L16;
        tp8.h r2 = this.b;
        if (r2 == null) goto L14;
        Function1<String, Unit> r3 = r2.a;
        if (r3 == null) goto L14;
        r3.invoke(r6);
    L14:
        if (this.b != null) goto L17;
        FLogger.a.d("InteractionQuickReplyDep", "[finish] no business result callback, reason=" + r6);
    L17:
        return r1;
    L16:
        FLogger.a.w("InteractionQuickReplyDep", "[finish] host rejected result, reason=" + r6);
        goto L17
    }

    public final void c(String r4, boolean r5) {
        FragmentActivity r0 = this.a;
        if (r0 == null) goto L20;
        FragmentManager r1 = r0.getSupportFragmentManager();
        if (r1 == null) goto L20;
        if (r5 == false) goto L18;
        BrowserControlTipDialog r6 = r1.findFragmentByTag(r4);
        if ((r6 instanceof BrowserControlTipDialog) == false) goto L10;
        BrowserControlTipDialog r7 = r6;
    L11:
        if (r7 == null) goto L18;
        r7.dismissAllowingStateLoss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L18;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L18
    L10:
        r7 = null;
    L18:
        r1.clearFragmentResult(r4);
        r1.clearFragmentResultListener(r4);
    L20:
        if (Intrinsics.areEqual(this.d, r4) == false) goto L25;
        this.d = null;
        return;
    }

    public j(FragmentActivity r1, tp8.h r2, tp8.f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.larus.bmhome.chat.standarduikit.interaction.viewmodel.g
    public final com.larus.bmhome.taskskill.service.l a(f r16, QuickReplyItem r17, int r18, k r19) {
        Intrinsics.checkNotNullParameter(r16, "vmData");
        Intrinsics.checkNotNullParameter(r17, "item");
        Intrinsics.checkNotNullParameter(r19, "onEvent");
        StringBuilder r3 = new StringBuilder("quick_reply_pc_guide_");
        String r4 = r16.a;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r3.append(r4);
        r3.append('_');
        String r5 = r16.b;
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r3.append(r5);
        final String r12 = r3.toString();
        h r6 = new h(this, r12, r19);
        this.e = r6;
        if (r12 != null) goto L11;
    L20:
        SkillServiceDelegate r2 = SkillServiceDelegate.a;
        String r7 = r16.c;
        String r8 = r16.a;
        if (r8 != null) goto L23;
        String r9 = "";
    L24:
        String r10 = r16.b;
        FragmentActivity r11 = this.a;
        QuickReplyBlock r13 = r16.h;
        if (r13 == null) goto L27;
        Integer r14 = r13.getInteractionType();
    L28:
        w r1 = r16.i;
        if (r1 == null) goto L31;
        String r15 = r1.a;
    L32:
        if (r1 == null) goto L34;
        String r110 = r1.b;
    L36:
        return r2.c(new com.larus.bmhome.taskskill.service.m(r7, r9, r10, r17, r18, r11, r14, r12, r15, r110), r6);
    L34:
        r110 = null;
        goto L36
    L31:
        r15 = null;
        goto L32
    L27:
        r14 = null;
        goto L28
    L23:
        r9 = r8;
        goto L24
    L11:
        if (Intrinsics.areEqual(this.d, r12) == true) goto L20;
        String r20 = this.d;
        if (r20 == null) goto L16;
        c(r20, true);
    L16:
        FragmentActivity r21 = this.a;
        if (r21 != null) goto L19;
        FLogger.a.w("InteractionQuickReplyDep", "[pcGuide] listener registration skipped, hasActivity=false");
        goto L20
    L19:
        this.d = r12;
        r21.getSupportFragmentManager().setFragmentResultListener(r12, r21, new i(this, r12));
        goto L20
    }
}
