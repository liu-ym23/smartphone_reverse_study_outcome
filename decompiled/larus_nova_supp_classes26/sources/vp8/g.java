package vp8;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class g {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Fragment g;

    public void d() {
    }

    public boolean f(z0 r1) {
        return false;
    }

    public void i() {
    }

    public void l() {
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }

    public boolean q(r r1) {
        return false;
    }

    public void r(String r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
    }

    public void t(com.larus.bmhome.view.actionbar.edit.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
    }

    public void u(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
    }

    public final ICoreInputAbility c() {
        return (ICoreInputAbility) this.a.getValue();
    }

    public g(final ComponentFeature r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        this.a = LazyKt.lazy(new a(r2));
        this.b = LazyKt.lazy(new b(r2));
        this.c = LazyKt.lazy(new c(r2));
        this.d = LazyKt.lazy(new d(r2));
        this.e = LazyKt.lazy(new e(r2));
        this.f = LazyKt.lazy(new f(r2));
        Intrinsics.checkNotNullParameter(r2, "<this>");
        this.g = com.larus.ui.arch.component.internal.attach.a.b(r2, r2);
    }
}
