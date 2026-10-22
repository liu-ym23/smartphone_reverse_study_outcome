package com.obric.flow.cardlistpage.ui.component.topgradient;

import android.view.View;
import cn.nubia.neopush.commons.Constant;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.feedlist.w;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.flow.cardlistpage.mvi.c {
    public final View d;

    public b(View r5, CoroutineScope r10, CardFeedLayout r11) {
        Intrinsics.checkNotNullParameter(r5, "topGradientView");
        Intrinsics.checkNotNullParameter(r10, "coroutineScope");
        Intrinsics.checkNotNullParameter(r11, "parent");
        super(new w(new f(), 5), r10, r11);
        this.d = r5;
        i();
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void g(com.obric.flow.cardlistpage.mvi.e r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.COMMAND);
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void h() {
    }

    @Override // com.obric.flow.cardlistpage.mvi.c
    public final void j() {
        TopGradientComponent$observeState$$inlined$collectState$1 r5 = new TopGradientComponent$observeState$$inlined$collectState$1(null, this, this);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r5, 3, null);
        TopGradientComponent$observeState$$inlined$collectState$2 r10 = new TopGradientComponent$observeState$$inlined$collectState$2(null, this, this);
        BuildersKt.launch$default((CoroutineScope) this.f11532b, null, null, r10, 3, null);
    }
}
