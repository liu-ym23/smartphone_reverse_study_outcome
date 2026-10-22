package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void getOutline(Drawable r5, Outline r10) {
            r5.getOutline(r10);
        }
    }

    public ActionBarBackgroundDrawable(ActionBarContainer r5) {
        this.mContainer = r5;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        ActionBarContainer r10 = this.mContainer;
        if (r10.mIsSplit == false) goto L7;
        Drawable r11 = r10.mSplitBackground;
        if (r11 == null) goto L16;
        r11.draw(r5);
        return;
    L16:
        return;
    L7:
        Drawable r12 = r10.mBackground;
        if (r12 == null) goto L10;
        r12.draw(r5);
    L10:
        ActionBarContainer r13 = this.mContainer;
        Drawable r14 = r13.mStackedBackground;
        if (r14 != null) goto L13;
        return;
    L13:
        if (r13.mIsStacked == false) goto L19;
        r14.draw(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline r5) {
        ActionBarContainer r10 = this.mContainer;
        if (r10.mIsSplit == true) goto L5;
        Drawable r11 = r10.mBackground;
        if (r11 == null) goto L13;
        Api21Impl.getOutline(r11, r5);
        return;
    L13:
        return;
    L5:
        if (r10.mSplitBackground == null) goto L11;
        Api21Impl.getOutline(r10.mBackground, r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
    }
}
