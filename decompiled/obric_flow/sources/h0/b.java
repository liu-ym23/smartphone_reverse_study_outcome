package h0;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    @Override // com.bumptech.glide.load.engine.d0
    public final int a() {
        Drawable r5 = this.f17270a;
        int r10 = r5.getIntrinsicWidth();
        return Math.max(1, (r5.getIntrinsicHeight() * r10) * 4);
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final Class c() {
        return this.f17270a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.d0
    public final void recycle() {
    }
}
