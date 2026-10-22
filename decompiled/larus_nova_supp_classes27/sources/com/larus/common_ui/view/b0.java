package com.larus.common_ui.view;

import android.view.View;
import android.view.ViewStub;
import androidx.viewbinding.ViewBinding;
import com.larus.utils.e1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b0<T extends ViewBinding> {
    public final ViewStub a;
    public final Function1<View, T> b;
    public T c;

    public final void a() {
        T r0 = this.c;
        if (r0 == null) goto L8;
        View r1 = r0.getRoot();
        if (r1 == null) goto L9;
        e1.o(r1);
        return;
    L9:
        return;
    }

    public final T b() {
        if (this.c != null) goto L11;
        ViewStub r0 = this.a;
        if (r0 == null) goto L9;
        View r1 = r0.inflate();
        if (r1 == null) goto L9;
        T r2 = (T) this.b.invoke(r1);
    L10:
        this.c = r2;
    L9:
        r2 = null;
    L11:
        T r3 = this.c;
        if (r3 == null) goto L15;
        e1.x(r3.getRoot());
        return r3;
    L15:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(ViewStub r2, Function1<? super View, ? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, "viewBinder");
        this.a = r2;
        this.b = r3;
    }
}
