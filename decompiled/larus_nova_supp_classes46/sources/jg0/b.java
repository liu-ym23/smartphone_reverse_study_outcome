package jg0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b<T> implements d<T> {
    public ViewGroup a;
    public final int b;
    public final xg0.a c;

    public int b() {
        return 0;
    }

    @Override // jg0.d
    public void e(int r1, p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    @Override // jg0.f
    public final void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // jg0.f
    public final View l() {
        ViewGroup r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("root");
    L5:
        return r0;
    }

    public String c() {
        return getClass().getSimpleName();
    }

    public b(xg0.a r1) {
        this.c = r1;
        if (r1 == null) goto L5;
        int r2 = r1.getFeedType();
    L6:
        this.b = r2;
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // jg0.f
    public void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        View r6 = VerticalNitaInflate.a(c(), b(), r5, null, false);
        if (r6 == null) goto L7;
        ViewGroup r7 = (ViewGroup) r6;
        this.a = r7;
        r7.setClipChildren(false);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
