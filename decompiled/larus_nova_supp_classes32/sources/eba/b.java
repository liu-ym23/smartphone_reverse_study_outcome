package eba;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends FrameLayout {
    public Function1<? super Configuration, Unit> a;

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super.onConfigurationChanged(r3);
        Function1<? super Configuration, Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke(new Configuration(r3));
        return;
    }
}
