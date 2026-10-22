package com.ss.android.lark.flow.bottomsheet.plugin;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.ui.TitleBarIconSize;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ FlowBottomSheetPlugin a;

    public b(FlowBottomSheetPlugin r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        if (r6 != null) goto L6;
    L32:
        ITitlebarComponent r7 = this.a.g;
        if (r7 == null) goto L37;
        FlowTitleBarComponent.LeftAreaImpl r8 = r7.x00();
        if (r8 == null) goto L37;
        r8.a((FlowBottomSheetPlugin$closeAction$2.a) this.a.s.getValue());
    L37:
        ITitlebarComponent r9 = this.a.g;
        if (r9 == null) goto L42;
        FlowTitleBarComponent.LeftAreaImpl r10 = r9.x00();
        if (r10 == null) goto L42;
        r10.b((FlowBottomSheetPlugin$halfScreenLeftActionInterceptor$2.a) this.a.p.getValue());
    L42:
        ITitlebarComponent r11 = this.a.g;
        if (r11 == null) goto L47;
        FlowTitleBarComponent.LeftAreaImpl r12 = r11.x00();
        if (r12 == null) goto L47;
        r12.g(TitleBarIconSize.SMALL);
    L47:
        ITitlebarComponent r13 = this.a.g;
        if (r13 == null) goto L52;
        FlowTitleBarComponent.RightAreaImpl r14 = r13.F00();
        if (r14 == null) goto L52;
        FlowBottomSheetPlugin$expandAction$2.AnonymousClass1 r0 = (FlowBottomSheetPlugin$expandAction$2.AnonymousClass1) this.a.r.getValue();
        Context r1 = this.a.getContext();
        Pair r2 = TitleBarIconSize.SMALL.rightActionSize(r1);
        new LinearLayout.LayoutParams(((Number) r2.getFirst()).intValue(), ((Number) r2.getSecond()).intValue()).gravity = 16;
        r14.a(r0);
    L52:
        ITitlebarComponent r15 = this.a.g;
        if (r15 == null) goto L61;
        FlowTitleBarComponent.RightAreaImpl r16 = r15.F00();
        if (r16 == null) goto L62;
        r16.b((FlowBottomSheetPlugin$halfScreenRightActionInterceptor$2.a) this.a.o.getValue());
        return;
    L62:
        return;
    L61:
        return;
    L6:
        if (r6.intValue() != 2) goto L32;
        ITitlebarComponent r17 = this.a.g;
        if (r17 == null) goto L12;
        FlowTitleBarComponent.LeftAreaImpl r18 = r17.x00();
        if (r18 == null) goto L12;
        r18.e(TitleBarActionKey.CLOSE);
    L12:
        ITitlebarComponent r19 = this.a.g;
        if (r19 == null) goto L17;
        FlowTitleBarComponent.LeftAreaImpl r20 = r19.x00();
        if (r20 == null) goto L17;
        r20.f((FlowBottomSheetPlugin$halfScreenLeftActionInterceptor$2.a) this.a.p.getValue());
    L17:
        ITitlebarComponent r21 = this.a.g;
        if (r21 == null) goto L22;
        FlowTitleBarComponent.LeftAreaImpl r22 = r21.x00();
        if (r22 == null) goto L22;
        r22.g(TitleBarIconSize.NORMAL);
    L22:
        ITitlebarComponent r23 = this.a.g;
        if (r23 == null) goto L27;
        FlowTitleBarComponent.RightAreaImpl r24 = r23.F00();
        if (r24 == null) goto L27;
        r24.e(TitleBarActionKey.BOTTOM_SHEET_EXPAND);
    L27:
        ITitlebarComponent r25 = this.a.g;
        if (r25 == null) goto L58;
        FlowTitleBarComponent.RightAreaImpl r26 = r25.F00();
        if (r26 == null) goto L59;
        r26.f((FlowBottomSheetPlugin$halfScreenRightActionInterceptor$2.a) this.a.o.getValue());
        return;
    L59:
        return;
    }
}
