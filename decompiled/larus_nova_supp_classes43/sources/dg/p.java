package dg;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.presenter.t2;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p extends QUIModule {
    public final ViewGroup l;
    public final SkuParams m;

    public final QIPresenter h() {
        Fragment r1 = a().i();
        if (r1 == null) goto L7;
        return new t2(r1);
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final List<QUIModule> i() {
        return CollectionsKt.listOf(new QUIModule[]{new i(k(2131564780)), new a(k(2131564766)), new h(k(2131564774)), new d(k(2131564769)), new n(k(2131564791)), new f(k(2131564772), this.m), new k(k(2131564784)), new b(k(2131564767)), new r(k(2131564620))});
    }

    public final View k(int r10) {
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = this.l.getContext();
        r0.getClass();
        return ShoppingAsyncInflater.a.a(r1).aU(r10, this.l, false);
    }

    public p(ViewGroup r10, SkuParams r11) {
        Intrinsics.checkNotNullParameter(r10, "rootView");
        Intrinsics.checkNotNullParameter(r11, "skuParams");
        super(0);
        this.l = r10;
        this.m = r11;
    }

    public final View f(Context r1, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
