package a7a;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SweepGradient;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends b {
    public final double h;
    public final com.lynx.tasm.behavior.ui.utils.j i;
    public final com.lynx.tasm.behavior.ui.utils.j j;

    public a(ReadableArray r6) {
        if (r6 != null) goto L7;
        LLog.e("ConicGradient", "native parse error array is null");
        return;
    L7:
        if (r6.size() >= 4) goto L10;
        LLog.e("ConicGradient", "native parse error, array.size must be 4  ");
        return;
    L10:
        this.h = r6.getDouble(0);
        ReadableArray r2 = r6.getArray(1);
        this.i = new com.lynx.tasm.behavior.ui.utils.j(r2.getDynamic(0), r2.getInt(1));
        this.j = new com.lynx.tasm.behavior.ui.utils.j(r2.getDynamic(2), r2.getInt(3));
        k(r6.getArray(2), r6.getArray(3));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r8) {
        this.c = Math.max(r8.width(), 1);
        this.d = Math.max(r8.height(), 1);
        int[] r0 = this.f;
        if (r0 != null) goto L5;
    L15:
        this.b = null;
    L16:
        super.setBounds(r8);
        return;
    L5:
        if (r0.length < 2) goto L15;
        float[] r2 = this.g;
        if (r2 != null) goto L10;
    L12:
        float r1 = this.i.b(this.c);
        float r3 = this.j.b(this.d);
        this.b = new SweepGradient(r1, r3, this.f, this.g);
        double r4 = this.h - 90.0d;
        if (r4 == 0.0d) goto L16;
        Matrix r5 = new Matrix();
        r5.preRotate((float) r4, r1, r3);
        this.b.setLocalMatrix(r5);
        goto L16
    L10:
        if (r2.length == r0.length) goto L12;
        this.b = null;
        goto L16
    }
}
