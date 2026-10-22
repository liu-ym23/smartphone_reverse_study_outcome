package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    public RoundedBitmapDrawable21(Resources r5, Bitmap r10) {
        super(r5, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline r5) {
        updateDstRect();
        r5.setRoundRect(this.mDstRect, getCornerRadius());
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void gravityCompatApply(int r10, int r11, int r12, Rect r13, Rect r14) {
        Gravity.apply(r10, r11, r12, r13, r14, 0);
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public boolean hasMipMap() {
        Bitmap r5 = this.mBitmap;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.hasMipMap() == false) goto L7;
        return true;
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void setMipMap(boolean r5) {
        Bitmap r10 = this.mBitmap;
        if (r10 == null) goto L6;
        r10.setHasMipMap(r5);
        invalidateSelf();
        return;
    }
}
