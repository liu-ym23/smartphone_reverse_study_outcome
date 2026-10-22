package g70;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements o {
    public final /* synthetic */ e a;
    public final /* synthetic */ e70.f b;
    public final /* synthetic */ boolean c;

    @Override // j70.o
    public final /* synthetic */ Object[] a() {
        return null;
    }

    @Override // j70.o
    public final ViewGroup e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    @Override // j70.o
    public final /* synthetic */ boolean g() {
        return true;
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return ((e70.h) this.b).m();
    }

    @Override // j70.o
    public final boolean f() {
        ((e70.h) this.b).s(this.a.b);
        return false;
    }

    @Override // j70.o
    public final boolean h() {
        return ((e70.h) this.b).o(this.a.b);
    }

    @Override // j70.o
    public final w70.a j() {
        return new b(this);
    }

    @Override // j70.o
    public final boolean i() {
        return this.c;
    }

    public c(e r1, e70.f r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
