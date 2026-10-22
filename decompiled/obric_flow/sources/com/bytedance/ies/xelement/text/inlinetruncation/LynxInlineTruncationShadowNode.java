package com.bytedance.ies.xelement.text.inlinetruncation;

import android.text.SpannableStringBuilder;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import java.util.ArrayList;
import kotlin.Metadata;
import zm.b;
import zm.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/text/inlinetruncation/LynxInlineTruncationShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "<init>", "()V", "", "stick", "", "setStick", "(Z)V", "x-element-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxInlineTruncationShadowNode extends TextShadowNode {
    public boolean Z;

    public LynxInlineTruncationShadowNode() {
    }

    @c0(name = "stick")
    public final void setStick(boolean r5) {
        this.Z = r5;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void w(SpannableStringBuilder r10, ArrayList r11) {
        SpannableStringBuilder r12 = new SpannableStringBuilder();
        ArrayList r13 = new ArrayList();
        super.w(r12, r13);
        int r5 = r13.size() - 1;
        if (r5 < 0) goto L9;
    L4:
        int r14 = r5 - 1;
        ((b) r13.get(r5)).a(r12);
        if (r14 < 0) goto L9;
        r5 = r14;
    L9:
        if (o() == false) goto L11;
        r12.setSpan(new h(this.f10335b, this.f10352p, this.f10353q, this.f10356u, this.f10354r, this.s, this.f10355t), 0, r12.length(), 18);
    L11:
        this.L = r12;
    }
}
