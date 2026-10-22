package com.bytedance.android.ec.core.widget;

import android.view.View;
import com.bytedance.android.ec.window.base.product.presenter.element.source.ECWindowProductCardSourceInfoElementPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends d {
    public final /* synthetic */ View.OnClickListener g;

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        this.g.onClick(r10);
    }

    public g(ECWindowProductCardSourceInfoElementPresenter r1, Long r10, String r11) {
        this.g = r1;
        super(r10, r11);
    }
}
