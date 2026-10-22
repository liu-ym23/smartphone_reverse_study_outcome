package r1a;

import android.view.View;
import com.larus.ui.arch.component.external.delegate.BaseComponentWidget;
import com.larus.ui.arch.component.external.delegate.BaseComponentWidget$b;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements BaseComponentWidget$b {
    public final /* synthetic */ BaseComponentWidget<?> a;
    public final /* synthetic */ ComponentStateController b;

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget$b
    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        BaseComponentWidget<?> r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.h.remove(this);
        ComponentStateController r1 = this.b;
        if (r1.e != null) goto L6;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "container");
        r1.e = r3;
        return;
    }

    public b(BaseComponentWidget<?> r1, ComponentStateController r2) {
        this.a = r1;
        this.b = r2;
    }
}
