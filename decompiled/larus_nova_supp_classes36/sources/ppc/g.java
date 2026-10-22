package ppc;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public final Activity a;
    public final Fragment b;
    public final FrameLayout c;
    public final ForwardV3ViewModel d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DoubaoForwardPreviewContext(activity=" + this.a + ", fragment=" + this.b + ", parent=" + this.c + ", viewModel=" + this.d + ')';
    }

    public final Activity getActivity() {
        return this.a;
    }

    public g(FragmentActivity r2, Fragment r3, FrameLayout r4, ForwardV3ViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
