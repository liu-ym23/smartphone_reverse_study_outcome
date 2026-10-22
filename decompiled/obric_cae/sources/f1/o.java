package f1;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import j0.h0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7298a = null;

    public static class a extends Property<View, Float> {
        public a() {
            super(Float.class, "translationAlpha");
        }

        @Override // android.util.Property
        public final Float get(View r8) {
            return Float.valueOf(r8.getTransitionAlpha());
        }

        @Override // android.util.Property
        public final void set(View r8, Float r10) {
            r8.setTransitionAlpha(r10.floatValue());
        }
    }

    public static class b extends Property<View, Rect> {
        public b() {
            super(Rect.class, "clipBounds");
        }

        @Override // android.util.Property
        public final Rect get(View r8) {
            WeakHashMap<View, h0> r10 = j0.w.f8437a;
            return j0.w.f.a(r8);
        }

        @Override // android.util.Property
        public final void set(View r8, Rect r10) {
            WeakHashMap<View, h0> r11 = j0.w.f8437a;
            j0.w.f.c(r8, r10);
        }
    }

    static {
        new t();
        f7298a = new a();
        new b();
    }
}
