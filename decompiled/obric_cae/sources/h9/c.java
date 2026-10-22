package h9;

import android.util.Property;
import android.view.ViewGroup;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class c extends Property<ViewGroup, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7949a = null;

    static {
        f7949a = new c();
    }

    public c() {
        super(Float.class, "childrenAlpha");
    }

    @Override // android.util.Property
    public final Float get(ViewGroup r8) {
        Float r10 = (Float) r8.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (r10 == null) goto L6;
        return r10;
    L6:
        return Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public final void set(ViewGroup r8, Float r10) {
        ViewGroup r11 = r8;
        float r12 = r10.floatValue();
        r11.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(r12));
        int r13 = r11.getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.getChildAt(r14).setAlpha(r12);
        r14 = r14 + 1;
        goto L3
    }
}
