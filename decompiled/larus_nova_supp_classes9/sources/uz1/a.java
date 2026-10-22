package uz1;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.b;
import com.bytedance.android.anya.p;
import com.bytedance.android.scope.o;
import i12.d;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends b implements o {
    public final d a;
    public final com.bytedance.android.scope.a<BaseMVIViewModel<?, ?>> b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Collection<BaseMVIViewModel<?, ?>> d() {
        return this.b;
    }

    public final <STATE extends MVIState<?>, ACTION extends p> BaseMVIViewModel<STATE, ACTION> f(Class<? extends BaseMVIViewModel<STATE, ACTION>> r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Iterator r0 = this.b.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (r5.isInstance((BaseMVIViewModel) r1) == false) goto L3;
    L10:
        if ((r1 instanceof BaseMVIViewModel) == false) goto L14;
        r2 = r1;
    L14:
        return (BaseMVIViewModel) r2;
    L8:
        r1 = null;
        goto L10
    }

    public a(d r2, e33.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "viewModelList");
        this.a = r2;
        this.b = r3;
    }
}
