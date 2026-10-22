package com.bytedance.ies.xelement.text.inlineimage;

import com.lynx.tasm.behavior.ui.text.a;
import com.lynx.tasm.ui.image.FrescoInlineImageShadowNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xelement/text/inlineimage/LynxInlineImageShadowNode;", "Lcom/lynx/tasm/ui/image/FrescoInlineImageShadowNode;", "<init>", "()V", "x-element-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxInlineImageShadowNode extends FrescoInlineImageShadowNode {
    public LynxInlineImageShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void C(a r5) {
        Intrinsics.checkNotNullParameter(r5, "span");
        r5.f23456a = 11;
        r5.f23457b = 0.0f;
    }
}
