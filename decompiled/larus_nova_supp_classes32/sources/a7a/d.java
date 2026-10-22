package a7a;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class d extends Drawable {
    public Path a;

    public abstract int a();

    public abstract int b();

    public abstract boolean c();

    public abstract void d();

    public abstract void e();

    public void f() {
    }

    public abstract void g(int r1, int r2);

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    public void h(Bitmap.Config r1) {
    }

    public void i(boolean r1) {
    }

    public void j(LynxBaseUI r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public d() {
    }
}
