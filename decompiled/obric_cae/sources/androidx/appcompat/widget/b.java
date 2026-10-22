package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f1103a;

    public b(ActionBarContainer r8) {
        this.f1103a = r8;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        ActionBarContainer r10 = this.f1103a;
        if (r10.f907r == false) goto L7;
        Drawable r11 = r10.f906q;
        if (r11 == null) goto L16;
        r11.draw(r8);
        return;
    L16:
        return;
    L7:
        Drawable r12 = r10.f904o;
        if (r12 == null) goto L10;
        r12.draw(r8);
    L10:
        Drawable r13 = r10.f905p;
        if (r13 != null) goto L13;
        return;
    L13:
        if (r10.f908s == false) goto L19;
        r13.draw(r8);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline r8) {
        ActionBarContainer r10 = this.f1103a;
        if (r10.f907r == true) goto L5;
        Drawable r11 = r10.f904o;
        if (r11 == null) goto L13;
    L7:
        r11.getOutline(r8);
        return;
    L13:
        return;
    L5:
        if (r10.f906q == null) goto L11;
        r11 = r10.f904o;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
    }
}
