package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.project.ProjectPanelController;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g7 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ CoreInputComponent a;

    public g7(CoreInputComponent r1) {
        this.a = r1;
    }

    public final void c(Object r7) {
        wc9.e r8 = (wc9.e) r7;
        Intrinsics.checkNotNullParameter(r8, "new");
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        r0.k4().u = null;
        this.a.F4().setConversationId(r8.a);
        ChatInputMentionPanelController r2 = this.a.k1;
        boolean r3 = false;
        if (r2 == null) goto L16;
        qp8.b r4 = r2.f;
        if (r4 == null) goto L7;
        r4.b();
    L7:
        MultiTypeMentionPanelController r5 = r2.g;
        if (r5 == null) goto L16;
        r5.o(false);
        MentionPanelController r6 = r5.Y;
        if (r6 == null) goto L12;
        r6.n();
    L12:
        r5.g();
        r5.C.a();
        ProjectPanelController r9 = r5.a0;
        if (r9 == null) goto L15;
        r9.b();
    L15:
        r5.G = null;
        r5.H = null;
        r5.I = null;
        r5.M = false;
        r5.p(false);
    L16:
        this.a.U6(r8);
        CoreInputComponent r10 = this.a;
        zb8.e r11 = (zb8.e) r10.w.getValue();
        if (r11 != null) goto L19;
    L21:
        if (r3 == true) goto L23;
        r10.k4().Jc(r10.getContext());
    L23:
        final CoreInputAbility r12 = r10.k4();
        if (r12.f.Mb() == true) goto L27;
        r12.p = new d2(r12);
    L27:
        CoreInputAbility r13 = r10.k4();
        if (r13.f.Mb() == true) goto L31;
        r13.s = new u1();
    L31:
        CoreInputComponent r14 = this.a;
        r14.getClass();
        FLogger.a.i("CoreInputComponent", "[updateConversationDisableStatus] conversation.isDisabled() = " + r8.h() + ' ' + r8.t + ' ' + r8.a);
        r14.F4().updateChatEnableStatus(r8.h() ^ true);
        this.a.k4().T0(this.a.F4().getBotModel());
        return;
    L19:
        if (r11.qt() != true) goto L21;
        r3 = true;
        goto L21
    }
}
