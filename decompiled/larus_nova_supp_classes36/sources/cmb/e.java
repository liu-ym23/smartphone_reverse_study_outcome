package cmb;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Function1<ViewGroup, View> {
    public e() {
    }

    public final Object invoke(Object r2) {
        ViewGroup r3 = (ViewGroup) r2;
        Intrinsics.checkNotNullParameter(r3, "contentView");
        return r3;
    }
}
