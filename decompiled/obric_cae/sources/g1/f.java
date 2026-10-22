package g1;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f7561a;

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        b0.a.b.a(r10, r8);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void clearColorFilter() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L6;
        r8.clearColorFilter();
        return;
    L6:
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getCurrent();
    L7:
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getMinimumHeight();
    L7:
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getMinimumWidth();
    L7:
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L7;
        return r10.getPadding(r8);
    L7:
        return super.getPadding(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getState();
    L7:
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L7;
        return r8.getTransparentRegion();
    L7:
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        Drawable r8 = this.f7561a;
        if (r8 == null) goto L6;
        r8.jumpToCurrentState();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L7;
        return r10.setLevel(r8);
    L7:
        return super.onLevelChange(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.setChangingConfigurations(r8);
        return;
    L6:
        super.setChangingConfigurations(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(int r8, PorterDuff.Mode r10) {
        Drawable r11 = this.f7561a;
        if (r11 == null) goto L6;
        r11.setColorFilter(r8, r10);
        return;
    L6:
        super.setColorFilter(r8, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L6;
        r10.setFilterBitmap(r8);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float r8, float r10) {
        Drawable r11 = this.f7561a;
        if (r11 == null) goto L6;
        b0.a.b.e(r11, r8, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int r8, int r10, int r11, int r12) {
        Drawable r13 = this.f7561a;
        if (r13 == null) goto L6;
        b0.a.b.f(r13, r8, r10, r11, r12);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] r8) {
        Drawable r10 = this.f7561a;
        if (r10 == null) goto L7;
        return r10.setState(r8);
    L7:
        return super.setState(r8);
    }
}
