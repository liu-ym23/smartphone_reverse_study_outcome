package x61;

import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements d {
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Class c;
    public final /* synthetic */ Function1 d;

    @Override // x61.h
    public final Class<? extends Widget> a(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return this.c;
    }

    @Override // x61.d
    public final void b(Widget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Function1 r0 = this.b;
        if (r0 == null) goto L6;
        Unit r3 = (Unit) r0.invoke(r2);
        return;
    }

    @Override // x61.d
    public final ViewGroup c(d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Function1 r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ViewGroup) r0.invoke(r2);
    }

    public g(Function1 r1, Class r2) {
        this.b = r1;
        this.c = r2;
        this.d = null;
    }
}
