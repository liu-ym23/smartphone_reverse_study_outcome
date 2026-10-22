package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.a;
import com.bytedance.android.live.openplatform.api.model.shelf.d;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayItemViewHolder;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/a;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CommonShelfDisplayItemViewHolder<T extends com.bytedance.android.live.openplatform.api.model.shelf.a> extends RecyclerView.ViewHolder {
    public final ConstraintLayout a;
    public final HSImageView b;
    public final TextView c;
    public final LinearLayout d;
    public final TextView e;
    public final Button f;
    public final TextView g;
    public final CommonProductIntroductionLayout h;
    public final CommonProductLabelLayout i;
    public final CommonProductPriceView j;

    public abstract boolean T3(T r1);

    public abstract void U3(CommonProductLabelLayout r1, T r2);

    public abstract String V3(T r1);

    public abstract String W3(T r1);

    public abstract boolean X3();

    public abstract boolean Y3();

    public abstract boolean Z3();

    public CommonShelfDisplayItemViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131365166);
        this.b = r2.findViewById(2131365169);
        this.c = (TextView) r2.findViewById(2131365181);
        this.d = (LinearLayout) r2.findViewById(2131371936);
        this.e = (TextView) r2.findViewById(2131365218);
        this.f = (Button) r2.findViewById(2131381546);
        this.g = (TextView) r2.findViewById(2131385888);
        this.h = (CommonProductIntroductionLayout) r2.findViewById(2131383168);
        this.i = (CommonProductLabelLayout) r2.findViewById(2131383170);
        this.j = (CommonProductPriceView) r2.findViewById(2131383174);
    }

    public final void a4(T r8) {
        Intrinsics.checkNotNullParameter(r8, "cardInfo");
        this.c.setText(String.valueOf(d.a(r8.getCardId())));
        boolean r5 = false;
        if (r8.getStatus() != 1) goto L5;
        boolean r0 = true;
    L6:
        LinearLayout r1 = this.d;
        if (r0 == false) goto L9;
        int r2 = 0;
    L10:
        r1.setVisibility(r2);
        this.e.setText(V3(r8));
        ImageLoader.bindImage(this.b, W3(r8));
        boolean r3 = T3(r8);
        if (r3 == false) goto L13;
        this.g.setVisibility(0);
        this.g.setText(r8.b());
    L14:
        ProductInfo r4 = r8.getProductInfo();
        if (X3() == false) goto L42;
        if (r4 == null) goto L42;
        LinearLayout r6 = this.d;
        if (r4.isShow == false) goto L20;
        int r7 = 0;
    L21:
        r6.setVisibility(r7);
        if (Y3() == false) goto L33;
        List<ProductIntroductionInfo> r9 = r4.introductionList;
        if (r9 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == true) goto L33;
        CommonProductIntroductionLayout r11 = this.h;
        List<ProductIntroductionInfo> r12 = r4.introductionList;
        Intrinsics.checkNotNull(r12);
        r11.r(r12);
        this.h.setVisibility(0);
        boolean r13 = true;
    L35:
        if (Z3() == false) goto L40;
        ProductPriceInfo r14 = r4.price;
        if (r14 == null) goto L40;
        CommonProductPriceView r15 = this.j;
        Intrinsics.checkNotNull(r14);
        r15.b(r14);
        this.j.setVisibility(0);
    L41:
        r5 = r13;
    L43:
        if (r3 == false) goto L46;
        if (r5 == false) goto L46;
        this.i.setVisibility(8);
    L47:
        int r16 = ((uc1) ee0.a.getValue()).p();
        if (r16 != 1) goto L50;
        Pair r17 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(116)), Integer.valueOf(UtilityKotlinExtentionsKt.i(116)));
    L57:
        int r18 = ((Number) r17.component1()).intValue();
        int r19 = ((Number) r17.component2()).intValue();
        HSImageView r20 = this.b;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        r21.width = r18;
        r21.height = r19;
        Unit r22 = Unit.INSTANCE;
        r20.setLayoutParams(r21);
        return;
    L50:
        if (r16 == 2) goto L52;
        r17 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(87)), Integer.valueOf(UtilityKotlinExtentionsKt.i(87)));
        goto L57
    L52:
        MiniAppDataContext.Companion.getClass();
        if (g.d(MiniAppDataContext.a.b()) == false) goto L55;
        r17 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(116)), Integer.valueOf(UtilityKotlinExtentionsKt.i(116)));
        goto L57
    L55:
        r17 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(87)), Integer.valueOf(UtilityKotlinExtentionsKt.i(87)));
    L46:
        U3(this.i, r8);
    L40:
        this.j.setVisibility(8);
        goto L41
    L26:
        if (r9.isEmpty() == true) goto L29;
        r10 = false;
    L33:
        this.h.setVisibility(8);
        r13 = false;
        goto L35
    L20:
        r7 = 8;
    L42:
        this.h.setVisibility(8);
        this.j.setVisibility(8);
        goto L43
    L13:
        this.g.setVisibility(8);
        goto L14
    L9:
        r2 = 8;
        goto L10
    L5:
        r0 = false;
        goto L6
    }
}
