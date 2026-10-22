package a7a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l extends k {
    public Paint m;

    @Override // a7a.k
    public final boolean c() {
        return true;
    }

    @Override // a7a.k
    public final void d(ReadableArray r3, LynxBaseUI r4) {
        super.d(r3, r4);
        if (this.m != null) goto L12;
        Paint r5 = new Paint();
        this.m = r5;
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.m.setAntiAlias(true);
        if ((r4 instanceof LynxUI) == false) goto L13;
        View r6 = ((LynxUI) r4).getView();
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.getLayerType() == 2) goto L15;
        r6.setWillNotDraw(false);
        r6.setLayerType(2, null);
        return;
    L15:
        return;
    L13:
        return;
    }

    public l(LynxContext r1, Drawable r2, float r3) {
        super(r1, r2);
        this.m = null;
    }

    @Override // a7a.k
    public final void a(Canvas r13, RectF r14, RectF r15, RectF r16, RectF r17, Path r18, Path r19, boolean r20) {
        int r11 = r13.saveLayer(null, this.m, 31);
        super.a(r13, r14, r15, r16, r17, null, null, r20);
        r13.restoreToCount(r11);
    }
}
