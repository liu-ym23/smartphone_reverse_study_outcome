package com.larus.bmhome.chat.markdown.code;

import com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 implements PreviewSwitchButton.a {
    public final /* synthetic */ ClickableMarkdownCodeView a;

    public k0(ClickableMarkdownCodeView r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton.a
    public final void a(boolean r3) {
        ClickableMarkdownCodeView r0 = this.a;
        r0.h = Boolean.valueOf(r3);
        ClickableMarkdownCodeView r4 = this.a;
        Boolean r1 = r4.h;
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L6:
        r4.t(r2);
        this.a.r();
        this.a.q();
        ClickableMarkdownCodeView r5 = this.a;
        Function2<? super CodeClickActionEnum, ? super String, Unit> r6 = r5.d;
        if (r6 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r5.h, Boolean.TRUE) == false) goto L11;
        CodeClickActionEnum r7 = CodeClickActionEnum.CLICK_ACTION_SWITCH_TAB_GRAPH;
    L12:
        r6.invoke(r7, this.a.getCardType());
        return;
    L11:
        r7 = CodeClickActionEnum.CLICK_ACTION_SWITCH_TAB_CODE;
        goto L12
    L5:
        r2 = false;
        goto L6
    }
}
