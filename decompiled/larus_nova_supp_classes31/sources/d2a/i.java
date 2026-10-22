package d2a;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class i extends h implements k {
    public final View i;
    public final Property<View, Float> j;

    public i(View r2, Property<View, Float> r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "property");
        super(0);
        this.i = r2;
        this.j = r3;
        this.h.setTarget(r2);
        this.h.setProperty(r3);
    }

    @Override // d2a.k
    public final void a(float r5, float r6) {
        float[] r1 = {r5, r6};
        Intrinsics.checkNotNullParameter(r1, "value");
        this.h.setValues(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(this.j, Arrays.copyOf(r1, 2))});
    }
}
