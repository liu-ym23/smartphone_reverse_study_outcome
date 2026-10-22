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
    protected RoundedBitmapDrawable21(Resources r10, Bitmap r11) {
        super(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline r10) {
        updateDstRect();
        r10.setRoundRect(this.mDstRect, getCornerRadius());
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    void gravityCompatApply(int r10, int r11, int r12, Rect r13, Rect r14) {
        Gravity.apply(r10, r11, r12, r13, r14, 0);
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public boolean hasMipMap() {
        Bitmap r10 = this.mBitmap;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.hasMipMap() == false) goto L7;
        return true;
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void setMipMap(boolean r10) {
        Bitmap r11 = this.mBitmap;
        if (r11 == null) goto L6;
        r11.setHasMipMap(r10);
        invalidateSelf();
        return;
    }
}
