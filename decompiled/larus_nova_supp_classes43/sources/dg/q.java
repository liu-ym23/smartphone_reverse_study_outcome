package dg;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.presenter.m2;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q extends QUIModule {
    public final ViewGroup l;
    public final SkuParams m;

    public final QIPresenter h() {
        Fragment r1 = a().i();
        if (r1 == null) goto L7;
        return new m2(r1);
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final List<QUIModule> i() {
        QUIModule[] r0 = new QUIModule[12];
        String r10 = this.m.getDetailUrl();
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == false) goto L13;
    L17:
        int r12 = 2131564782;
    L19:
        r0[0] = new j(k(r12));
        r0[1] = new a(k(2131564766));
        r0[2] = new e(k(2131564770));
        r0[3] = new o(k(2131564792));
        r0[4] = new g(k(2131564773), this.m);
        r0[5] = new l(k(2131564786));
        r0[6] = new c(k(2131564768));
        r0[7] = new s(k(2131564621));
        r0[8] = new u(k(2131564796));
        r0[9] = new m(k(2131564790));
        r0[10] = new t(k(2131564794));
        r0[11] = new v(k(2131564797));
        return CollectionsKt.listOf(r0);
    L13:
        if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L15;
    L18:
        r12 = 2131564781;
        goto L19
    L15:
        if (com.bytedance.android.ec.core.abtest.d.F() != 2) goto L17;
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L10
    }

    public final View k(int r10) {
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = this.l.getContext();
        r0.getClass();
        return ShoppingAsyncInflater.a.a(r1).aU(r10, this.l, false);
    }

    public q(ViewGroup r10, SkuParams r11) {
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
