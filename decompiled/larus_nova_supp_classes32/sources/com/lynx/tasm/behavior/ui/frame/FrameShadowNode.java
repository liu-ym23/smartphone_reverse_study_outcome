package com.lynx.tasm.behavior.ui.frame;

import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import java.util.HashMap;
import y6a.a;
import y6a.b;
import y6a.e;
import y6a.g;
import y6a.j;
import y6a.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxShadowNode(tagName = "frame")
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.frame")
public class FrameShadowNode extends CustomLayoutShadowNode implements e {
    public int w;
    public int x;

    @Override // y6a.e
    public final void d(b r1, a r2) {
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void e() {
        h(this);
        super.e();
    }

    public FrameShadowNode() {
    }

    @Override // y6a.e
    public final k b(j r4, g r5) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        HashMap r6 = new HashMap();
        r6.put("input_width", String.valueOf(r4.a));
        r6.put("input_height", String.valueOf(r4.c));
        r6.put("input_width_mode", r4.b.name());
        r6.put("input_height_mode", r4.d.name());
        TraceEvent.beginSection("FrameShadowNode.measure", r6);
    L5:
        int r7 = this.w;
        if (r7 == 0) goto L8;
    L10:
        MeasureMode r1 = r4.b;
        MeasureMode r2 = MeasureMode.EXACTLY;
        if (r1 != r2) goto L13;
        float r8 = r4.a;
    L15:
        if (r4.d != r2) goto L17;
        float r9 = r4.c;
    L18:
        k r10 = new k(r8, r9);
    L20:
        if (TraceEvent.isTracingStarted() == false) goto L22;
        HashMap r11 = new HashMap();
        r11.put("width", String.valueOf(r10.a[0]));
        r11.put("height", String.valueOf(r10.a[1]));
        TraceEvent.endSection(0, "FrameShadowNode.measure", r11);
    L22:
        return r10;
    L17:
        r9 = this.x;
        goto L18
    L13:
        r8 = r7;
        goto L15
    L8:
        if (this.x != 0) goto L10;
        r10 = new k(r4.a, r4.c);
        goto L20
    }
}
