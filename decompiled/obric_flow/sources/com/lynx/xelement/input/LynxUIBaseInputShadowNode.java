package com.lynx.xelement.input;

import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.utils.g;
import com.lynx.tasm.utils.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pm.a;
import ym.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/lynx/xelement/input/LynxUIBaseInputShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "<init>", "()V", "Lpm/a;", "lineSpacing", "", "setLineSpacingStr", "(Lpm/a;)V", "Input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxUIBaseInputShadowNode extends TextShadowNode {
    public int Z;

    public LynxUIBaseInputShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final long B(TextShadowNode r5, float r10, MeasureMode r11, float r12, MeasureMode r13) {
        Intrinsics.checkNotNullParameter(r5, "node");
        Intrinsics.checkNotNullParameter(r11, "widthMode");
        Intrinsics.checkNotNullParameter(r13, "heightMode");
        if (r13 != MeasureMode.f10339b) goto L6;
        r12 = this.Z;
    L9:
        return h.b(r10, r12);
    L6:
        if (r13 != MeasureMode.d) goto L9;
        r12 = Math.min(this.Z, r12);
        goto L9
    }

    @c0(name = "line-spacing")
    public final void setLineSpacingStr(a r10) {
        Intrinsics.checkNotNullParameter(r10, "lineSpacing");
        if (r10.getType() != ReadableType.String) goto L6;
        float r11 = k.c(r10.asString(), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, k().f10152u);
    L12:
        setLineSpacing(r11);
        return;
    L6:
        if (r10.getType() != ReadableType.Number) goto L8;
    L11:
        r11 = g.a((float) r10.asDouble(), 0.0f);
        goto L12
    L8:
        if (r10.getType() == ReadableType.Int) goto L11;
        r11 = 0.0f;
        goto L12
    }
}
