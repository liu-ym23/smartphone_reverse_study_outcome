package an;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends j {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f352m;

    @Override // an.j
    public final void a(Canvas r12, RectF r13, RectF r14, RectF r15, RectF r16, Path r17, Path r18, boolean r19) {
        int r10 = r12.saveLayer(null, this.f352m, 31);
        super.a(r12, r13, r14, r15, r16, null, null, r19);
        r12.restoreToCount(r10);
    }

    @Override // an.j
    public final void b(ReadableArray r5, LynxBaseUI r10) {
        super.b(r5, r10);
        if (this.f352m != null) goto L12;
        Paint r11 = new Paint();
        this.f352m = r11;
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f352m.setAntiAlias(true);
        if ((r10 instanceof LynxUI) == false) goto L13;
        View r12 = ((LynxUI) r10).getView();
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.getLayerType() == 2) goto L15;
        r12.setWillNotDraw(false);
        r12.setLayerType(2, null);
        return;
    L15:
        return;
    L13:
        return;
    }

    @Override // an.j
    public final boolean c() {
        return true;
    }
}
