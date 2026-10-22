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
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void getOutline(Drawable r10, Outline r11) {
            r10.getOutline(r11);
        }
    }

    public ActionBarBackgroundDrawable(ActionBarContainer r10) {
        this.mContainer = r10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        ActionBarContainer r11 = this.mContainer;
        if (r11.mIsSplit == false) goto L7;
        Drawable r12 = r11.mSplitBackground;
        if (r12 == null) goto L16;
        r12.draw(r10);
        return;
    L16:
        return;
    L7:
        Drawable r13 = r11.mBackground;
        if (r13 == null) goto L10;
        r13.draw(r10);
    L10:
        ActionBarContainer r14 = this.mContainer;
        Drawable r15 = r14.mStackedBackground;
        if (r15 != null) goto L13;
        return;
    L13:
        if (r14.mIsStacked == false) goto L19;
        r15.draw(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline r10) {
        ActionBarContainer r11 = this.mContainer;
        if (r11.mIsSplit == true) goto L5;
        Drawable r12 = r11.mBackground;
        if (r12 == null) goto L12;
    L9:
        Api21Impl.getOutline(r12, r10);
        return;
    L12:
        return;
    L5:
        if (r11.mSplitBackground == null) goto L11;
        r12 = r11.mBackground;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
    }
}
