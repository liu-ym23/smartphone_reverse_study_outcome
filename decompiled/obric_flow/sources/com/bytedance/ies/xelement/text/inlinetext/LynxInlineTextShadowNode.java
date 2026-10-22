package com.bytedance.ies.xelement.text.inlinetext;

import android.text.SpannableStringBuilder;
import com.bytedance.ies.xelement.text.text.LynxTextShadowNode;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode;
import java.util.regex.Pattern;
import k5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import we.c;
import ym.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/text/inlinetext/LynxInlineTextShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/InlineTextShadowNode;", "<init>", "()V", "", "noTrim", "", "setNoTrim", "(Z)V", "x-element-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxInlineTextShadowNode extends InlineTextShadowNode {
    public boolean N;
    public String O;

    public LynxInlineTextShadowNode() {
        this.O = "none";
    }

    @c0(defaultBoolean = true, name = "no-trim")
    public final void setNoTrim(boolean r5) {
        this.N = r5;
        n();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void v(SpannableStringBuilder r5, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "sb");
        if (this.N == true) goto L9;
        Regex r12 = LynxTextShadowNode.f6504d0;
        if (r10 == null) goto L7;
        r10 = d.d(0, LynxTextShadowNode.f6504d0.replace(r10, ""));
        goto L9
    L7:
        r10 = null;
    L9:
        if (Intrinsics.areEqual(this.O, "bracket") == false) goto L12;
        Pattern r13 = c.f22858a;
        k();
        k.b(this.f10357v.f23520k);
        r5.append(c.a(r10));
        return;
    L12:
        r5.append(r10);
    }
}
