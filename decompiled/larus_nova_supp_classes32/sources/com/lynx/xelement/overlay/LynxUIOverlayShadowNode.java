package com.lynx.xelement.overlay;

import android.util.DisplayMetrics;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import kotlin.Metadata;
import y6a.j;
import y6a.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/lynx/xelement/overlay/LynxUIOverlayShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Ly6a/e;", "<init>", "()V", "Overlay_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIOverlayShadowNode extends ShadowNode implements y6a.e {
    public LynxUIOverlayShadowNode() {
        h(this);
    }

    @Override // y6a.e
    public final k b(j r5, y6a.g r6) {
        if (l() <= 0) goto L9;
        ShadowNode r7 = k(0);
        if ((r7 instanceof NativeLayoutNodeRef) == false) goto L9;
        DisplayMetrics r1 = DisplayMetricsHolder.getRealScreenDisplayMetrics(this.m);
        j r2 = new j();
        r2.c = r1.heightPixels;
        r2.a = r1.widthPixels;
        MeasureMode r3 = MeasureMode.EXACTLY;
        r2.b = r3;
        r2.d = r3;
        ((NativeLayoutNodeRef) r7).D(r6, r2);
        return new k(0.0f, 0.0f);
    L9:
        return new k(0.0f, 0.0f);
    }

    @Override // y6a.e
    public final void d(y6a.b r1, y6a.a r2) {
        if (l() <= 0) goto L8;
        ShadowNode r3 = k(0);
        if ((r3 instanceof NativeLayoutNodeRef) == false) goto L9;
        ((NativeLayoutNodeRef) r3).C(new y6a.b());
        return;
    L9:
        return;
    }
}
