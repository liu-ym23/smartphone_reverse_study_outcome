package ua8;

import android.text.method.LinkMovementMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends TextView implements ow8.a {
    public l a;

    public final int getMarkdownWidth() {
        return 0;
    }

    public final int getSelectedColor() {
        return 1719254015;
    }

    public final TextView o() {
        return this;
    }

    public final boolean q(int r1, int r2) {
        return false;
    }

    public a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2.getContext());
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
