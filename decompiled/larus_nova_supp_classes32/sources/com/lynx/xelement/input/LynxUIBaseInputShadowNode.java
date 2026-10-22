package com.lynx.xelement.input;

import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.utils.n;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/lynx/xelement/input/LynxUIBaseInputShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "Lf6a/a;", "lineSpacing", NameKeys.UnloadStrategy_No_Strategy, "setLineSpacingStr", "<init>", "()V", "Input_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIBaseInputShadowNode extends TextShadowNode {
    public int p0;

    public LynxUIBaseInputShadowNode() {
    }

    @LynxProp(name = "line-spacing")
    public final void setLineSpacingStr(f6a.a r10) {
        Intrinsics.checkNotNullParameter(r10, "lineSpacing");
        if (r10.getType() != ReadableType.String) goto L6;
        float r11 = n.b(r10.asString(), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getContext().getScreenMetrics());
    L12:
        setLineSpacing(r11);
        return;
    L6:
        if (r10.getType() != ReadableType.Number) goto L8;
    L11:
        r11 = com.lynx.tasm.utils.i.a(r10.asDouble());
        goto L12
    L8:
        if (r10.getType() == ReadableType.Int) goto L11;
        r11 = 0.0f;
        goto L12
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final long c(LayoutNode r2, float r3, MeasureMode r4, float r5, MeasureMode r6) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r4, "widthMode");
        Intrinsics.checkNotNullParameter(r6, "heightMode");
        if (r6 != MeasureMode.UNDEFINED) goto L6;
        r5 = this.p0;
    L9:
        return y6a.i.a(r3, r5);
    L6:
        if (r6 != MeasureMode.AT_MOST) goto L9;
        r5 = Math.min(this.p0, r5);
        goto L9
    }
}
