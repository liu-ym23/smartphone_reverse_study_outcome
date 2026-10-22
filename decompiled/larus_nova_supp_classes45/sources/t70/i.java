package t70;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class i implements o {
    public Object[] a;
    public final boolean b;
    public final boolean c;
    public final Class<? extends Widget> d;

    @Override // j70.o
    public final ViewGroup e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    @Override // j70.o
    public final boolean g() {
        return false;
    }

    @Override // j70.o
    public final boolean i() {
        return false;
    }

    @Override // j70.o
    public /* synthetic */ w70.a j() {
        return null;
    }

    @Override // j70.o
    public final Object[] a() {
        return this.a;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return this.d;
    }

    @Override // j70.o
    public final boolean f() {
        return this.c;
    }

    @Override // j70.o
    public final boolean h() {
        return this.b;
    }

    public final void d(Object[] r5) {
        Intrinsics.checkNotNullParameter(r5, "args");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L20;
        Object r2 = r5[r1];
        if ((r2 instanceof String) == true) goto L19;
        if ((r2 instanceof Integer) == true) goto L19;
        if ((r2 instanceof Float) == true) goto L19;
        if ((r2 instanceof Double) == true) goto L19;
        if ((r2 instanceof Long) == true) goto L19;
        if ((r2 instanceof Boolean) == true) goto L19;
        if ((r2 instanceof Byte) == true) goto L19;
        boolean r3 = r2 instanceof Bundle;
    L19:
        r1 = r1 + 1;
        goto L3
    L20:
        this.a = r5;
    }

    public i(boolean r2, boolean r3, Class r4) {
        Intrinsics.checkNotNullParameter(r4, "widgetClz");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
