package h0;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.a0;
import com.bumptech.glide.load.engine.d0;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import io.reactivex.internal.observers.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d0, a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f17270a;

    public a(Drawable r5) {
        h.h(r5, "Argument must not be null");
        this.f17270a = r5;
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Object get() {
        Drawable r5 = this.f17270a;
        Drawable.ConstantState r10 = r5.getConstantState();
        if (r10 != null) goto L6;
        return r5;
    L6:
        return r10.newDrawable();
    }

    public void initialize() {
        Drawable r5 = this.f17270a;
        if ((r5 instanceof BitmapDrawable) == false) goto L6;
        ((BitmapDrawable) r5).getBitmap().prepareToDraw();
        return;
    L6:
        if ((r5 instanceof GifDrawable) == false) goto L10;
        ((GifDrawable) r5).b().prepareToDraw();
        return;
    }
}
