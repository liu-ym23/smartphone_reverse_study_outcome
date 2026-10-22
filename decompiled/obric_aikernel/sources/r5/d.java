package r5;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class d extends Property<ViewGroup, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property<ViewGroup, Float> f12679a = null;

    static {
        f12679a = new d("childrenAlpha");
    }

    private d(String r10) {
        super(Float.class, r10);
    }

    @NonNull
    public Float a(@NonNull ViewGroup r10) {
        Float r11 = (Float) r10.getTag(q5.f.mtrl_internal_children_alpha_tag);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return Float.valueOf(1.0f);
    }

    public void b(@NonNull ViewGroup r10, @NonNull Float r11) {
        float r12 = r11.floatValue();
        r10.setTag(q5.f.mtrl_internal_children_alpha_tag, Float.valueOf(r12));
        int r13 = r10.getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r10.getChildAt(r14).setAlpha(r12);
        r14 = r14 + 1;
        goto L3
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Float get(@NonNull ViewGroup r10) {
        return a(r10);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ViewGroup r10, @NonNull Float r11) {
        b(r10, r11);
    }
}
