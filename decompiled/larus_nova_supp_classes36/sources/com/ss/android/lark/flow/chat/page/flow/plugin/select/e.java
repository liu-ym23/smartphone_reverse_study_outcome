package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.flow.chat.component.banner.IFlowBottomBannerComponent;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements IMessageListComponent.a {
    public final /* synthetic */ FlowMessageSelectPlugin a;

    public final /* synthetic */ void A9() {
    }

    public final void B9(ChatChatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatChatter");
    }

    public final void e(BasePageStore r2) {
        Intrinsics.checkNotNullParameter(r2, "store");
    }

    public final void w9(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
    }

    public final /* synthetic */ void x9() {
    }

    public final void z9(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
    }

    public final void y9() {
        final FlowMessageSelectPlugin r0 = this.a;
        IMessageListComponent r1 = r0.j;
        List r2 = null;
        if (r1 == null) goto L20;
        RelativeLayout r3 = r1.UI();
        if (r3 == null) goto L20;
        if (r0.t != null) goto L20;
        ViewStub r4 = (ViewStub) r3.findViewById(2131365621);
        if (r4 == null) goto L12;
        Intrinsics.checkNotNull(r4);
        View r5 = r4.inflate();
    L13:
        r0.t = r5;
        if (r5 == null) goto L16;
        TextView r6 = (TextView) r5.findViewById(2131364827);
    L17:
        r0.u = r6;
        if (r6 == null) goto L20;
        r6.setBackgroundResource(2131231979);
        goto L20
    L16:
        r6 = null;
        goto L17
    L12:
        r5 = r3.findViewById(2131365620);
    L20:
        r0.Q();
        r0.P();
        r0.T();
        View r7 = r0.t;
        if (r7 == null) goto L23;
        r7.setVisibility(0);
    L23:
        View r8 = r0.p;
        if (r8 == null) goto L26;
        r8.setVisibility(8);
    L26:
        IKeyboardWrapper r9 = r0.n;
        if (r9 == null) goto L29;
        r9.r(new com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a());
    L29:
        ITitlebarComponent r10 = r0.l;
        if (r10 == null) goto L35;
        FlowTitleBarComponent.LeftAreaImpl r11 = r10.x00();
        if (r11 == null) goto L35;
        r11.b(r0.e0);
    L35:
        if (r0.F == false) goto L41;
        ITitlebarComponent r12 = r0.l;
        if (r12 == null) goto L41;
        FlowTitleBarComponent.LeftAreaImpl r13 = r12.x00();
        if (r13 == null) goto L41;
        r13.b(r0.W);
    L41:
        ITitlebarComponent r14 = r0.l;
        if (r14 == null) goto L46;
        FlowTitleBarComponent.RightAreaImpl r15 = r14.F00();
        if (r15 == null) goto L46;
        r15.b(r0.a0);
    L46:
        IMessageListComponent r16 = r0.j;
        if (r16 == null) goto L49;
        r16.Ml((FlowMessageSelectPlugin$mSelectedMessageChangeListener$2.a) r0.c0.getValue());
    L49:
        TextView r17 = r0.u;
        if (r17 == null) goto L53;
        r17.setOnClickListener(new FlowMessageSelectPlugin$changeToSelectMessagesForCallerMode$1(r0));
    L53:
        if (r0.F == false) goto L71;
        IMessageListComponent r18 = r0.j;
        if (r18 == null) goto L57;
        r2 = r18.gK();
    L57:
        List r19 = r2;
        if (r19 != null) goto L60;
    L63:
        boolean r20 = true;
    L64:
        if (r20 == false) goto L71;
        TextView r21 = r0.u;
        if (r21 == null) goto L68;
        r21.setEnabled(false);
    L68:
        StringCompanionObject r22 = StringCompanionObject.INSTANCE;
        String r23 = String.format(Locale.getDefault(), "（%d）", Arrays.copyOf(new Object[]{0}, 1));
        TextView r24 = r0.u;
        if (r24 == null) goto L71;
        r24.setText(UIUtils.getString(r0.getContext(), 2131891625) + r23);
        goto L71
    L60:
        if (r19.isEmpty() == true) goto L63;
        r20 = false;
    L71:
        ListMode r25 = ListMode.SELECT_MESSAGES_FOR_CALLER;
        r0.E = r25;
        IMessageListComponent r26 = r0.j;
        if (r26 == null) goto L74;
        r26.Y00(r25, -1);
    L74:
        IFlowBottomBannerComponent r27 = r0.k;
        if (r27 == null) goto L78;
        r27.hO(false);
        return;
    }

    public e(FlowMessageSelectPlugin r1) {
        this.a = r1;
    }
}
