package h9;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f7950a = null;

    static {
        f7950a = new d();
    }

    public d() {
        super(Integer.class, "drawableAlphaCompat");
        new WeakHashMap();
    }

    @Override // android.util.Property
    public final Integer get(Drawable r8) {
        return Integer.valueOf(r8.getAlpha());
    }

    @Override // android.util.Property
    public final void set(Drawable r8, Integer r10) {
        r8.setAlpha(r10.intValue());
    }
}
