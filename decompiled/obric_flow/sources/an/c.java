package an;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f328a;

    public abstract void a(int r5, int r10);

    public void b(Bitmap.Config r5) {
    }

    public void c(LynxBaseUI r5) {
    }

    public void d(boolean r5) {
    }

    public abstract int e();

    public abstract int f();

    public abstract boolean g();

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    public abstract void h();

    public abstract void i();

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r5) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r5) {
    }
}
