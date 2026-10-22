package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void getOutline(Drawable r0, Outline r1) {
            r0.getOutline(r1);
        }
    }

    public ActionBarBackgroundDrawable(ActionBarContainer r1) {
        this.mContainer = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (this.mContainer.mIsSplit == false) goto L9;
        if (this.mContainer.mSplitBackground == null) goto L16;
        Drawable r1 = this.mContainer.mSplitBackground;
    L7:
        r1.draw(r2);
        return;
    L16:
        return;
    L9:
        if (this.mContainer.mBackground == null) goto L12;
        this.mContainer.mBackground.draw(r2);
    L12:
        if (this.mContainer.mStackedBackground != null) goto L14;
        return;
    L14:
        if (this.mContainer.mIsStacked == false) goto L19;
        r1 = this.mContainer.mStackedBackground;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r2) {
        if (this.mContainer.mIsSplit == false) goto L8;
        if (this.mContainer.mSplitBackground == null) goto L11;
    L9:
        Api21Impl.getOutline(this.mContainer.mBackground, r2);
        return;
    L11:
        return;
    L8:
        if (this.mContainer.mBackground != null) goto L9;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r1) {
    }
}
