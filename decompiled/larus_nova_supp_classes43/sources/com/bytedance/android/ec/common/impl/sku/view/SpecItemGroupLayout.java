package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0005-./01J\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0017\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001f\u0010\u001aJ\b\u0010 \u001a\u0004\u0018\u00010\u0003J\b\u0010\"\u001a\u0004\u0018\u00010!J\b\u0010#\u001a\u0004\u0018\u00010\u0003J\u000f\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b$\u0010%J\b\u0010&\u001a\u0004\u0018\u00010\u0003J\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'J\u000e\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*¨\u00062"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "", "getImageUrlList", "getNameList", "getFirstIdList", "", "getCurrentPosition", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout$b;", "checkChangeListener", "", "setCheckedChangeListener", "", "getCheckedIdArray", "()[Ljava/lang/String;", "getCheckedId", "getCheckedSkuId", "getCheckSkuImageUrl", "getCheckSkuBigImageUrl", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "getCheckSkuMaxPurchaseCount", "getCheckSkuLeastPurchaseCount", "getLimitText", "", "getRealStock", "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getCheckSkuCarAdapt", "getCheckSkuPrice", "getCheckSkuOriginPrice", "getCheckSkuDiscountPrice", "getCheckSkuDiscountPriceText", "", "getSelectEPInfo", "getCheckSkuCampaignPriceHeader", "getCheckSkuPriceHedaerStyle", "()Ljava/lang/Integer;", "getNewBonusText", "", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "getSkuBenefitLabel", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemGroupLayout$d;", "logger", "setSpecGroupLogEventLogger", "a", "b", "c", "d", "e", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecItemGroupLayout extends LinearLayoutCompat {
    public Context a;
    public cg.g b;
    public String[] c;
    public final List<n> d;
    public final List<View> e;
    public b f;
    public List<String> g;
    public List<String> h;
    public List<String> i;
    public List<String> j;
    public d k;
    public final c l;

    public static final class a {
    }

    public interface b {
        void a(String[] r1);
    }

    public interface c {
        List<String> L0();

        cg.g M0();

        List<String> N0();

        List<String> O0();

        List<String> getNameList();
    }

    public interface d {
        void a(int r1);

        void b();
    }

    public interface e {
        n.c getCheckedItemViewInfo();
    }

    static {
    }

    public final String getCheckSkuBigImageUrl() {
        String[] r0 = this.c;
        if (r0 == null) goto L8;
        cg.g r10 = this.b;
        if (r10 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        return r10.h(r0);
    L9:
        return null;
    L8:
        return null;
    }

    public final String getCheckSkuCampaignPriceHeader() {
        String[] r0 = this.c;
        if (r0 == null) goto L9;
        cg.g r1 = this.b;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 != null) goto L13;
        return null;
    L13:
        return r11.getCampaignPriceHeader();
    L11:
        return null;
    L9:
        return "";
    }

    public final CarAdaptComponent getCheckSkuCarAdapt() {
        String[] r0 = this.c;
        if (r0 == null) goto L8;
        cg.g r10 = this.b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.e(r0);
    L8:
        return null;
    }

    public final Long getCheckSkuDiscountPrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 != null) goto L13;
        return null;
    L13:
        return r11.getDiscountPrice();
    L11:
        return null;
    L10:
        return 0L;
    }

    public final String getCheckSkuDiscountPriceText() {
        String[] r0 = this.c;
        if (r0 == null) goto L9;
        cg.g r1 = this.b;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 != null) goto L13;
        return null;
    L13:
        return r11.getDiscountPriceText();
    L11:
        return null;
    L9:
        return "";
    }

    public final String getCheckSkuImageUrl() {
        String[] r0 = this.c;
        if (r0 == null) goto L8;
        cg.g r10 = this.b;
        if (r10 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        return r10.j(r0);
    L9:
        return null;
    L8:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SkuLimit getCheckSkuLeastPurchaseCount() {
        cg.g r0 = this.b;
        if (r0 == null) goto L23;
        String[] r10 = this.c;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L8:
        SkuLimit r12 = null;
        if (r11 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L23;
        Intrinsics.checkNotNull(r10);
        SkuLimit r1 = r0.c(r10);
        if (r1 == null) goto L23;
        if (r1.getCount() < 1) goto L18;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L21;
        r12 = r1;
    L21:
        if (r12 == null) goto L23;
        return r12;
    L18:
        r13 = false;
        goto L19
    L7:
        r11 = false;
    L23:
        return new SkuLimit(1, th.a.h(getContext(), 2131914001, new Object[]{1}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SkuLimit getCheckSkuMaxPurchaseCount() {
        cg.g r0 = this.b;
        if (r0 == null) goto L15;
        String[] r10 = this.c;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        Intrinsics.checkNotNull(r10);
        SkuLimit r1 = r0.l(r10);
        if (r1 == null) goto L15;
        return r1;
    L7:
        r11 = false;
    L15:
        return new SkuLimit(Long.MAX_VALUE, th.a.h(getContext(), 2131914000, new Object[]{Long.MAX_VALUE}));
    }

    public final Long getCheckSkuOriginPrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 != null) goto L13;
        return null;
    L13:
        return r11.getMarketPrice();
    L11:
        return null;
    L10:
        return 0L;
    }

    public final Long getCheckSkuPrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L9;
        cg.g r1 = this.b;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        return r1.k(r0);
    L7:
        return null;
    L9:
        return 0L;
    }

    public final Integer getCheckSkuPriceHedaerStyle() {
        String[] r0 = this.c;
        if (r0 == null) goto L9;
        cg.g r1 = this.b;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        return r1.d(r0);
    L7:
        return null;
    L9:
        return -1;
    }

    public final String getCheckedId() {
        String[] r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (this.b == null) goto L7;
        Intrinsics.checkNotNull(r0);
        return cg.g.b(r0);
    }

    public final String getCheckedSkuId() {
        cg.g r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L15;
        String[] r10 = this.c;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L15;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "idArray");
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) r0.a).get(cg.g.i(r10));
        if (r12 == null) goto L15;
        r1 = r12.getId();
        goto L15
    L7:
        r11 = false;
    L15:
        if (r1 != null) goto L18;
        return "";
    L18:
        return r1;
    }

    public final int getCurrentPosition() {
        String[] r0 = this.c;
        if (r0 != null) goto L5;
        return -1;
    L5:
        if (r0[0] != null) goto L7;
        return 0;
    L7:
        List<String> r10 = this.j;
        if (r10 == null) goto L20;
        int r11 = r10.size();
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L21;
        if (TextUtils.equals(r0[0], (CharSequence) ListProtector.get(r10, r12)) == true) goto L14;
        r12 = r12 + 1;
        goto L10
    L14:
        return r12 + 1;
    L21:
        return -1;
    L20:
        return -1;
    }

    public final List<String> getImageUrlList() {
        List<String> r0 = this.h;
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return this.g;
    }

    public final String getLimitText() {
        cg.g r0 = this.b;
        if (r0 == null) goto L26;
        String[] r10 = this.c;
        boolean r11 = false;
        if (r10 == null) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L26;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "idArray");
        SkuItemInfoVO r1 = (SkuItemInfoVO) ((LinkedHashMap) r0.a).get(cg.g.i(r10));
        if (r1 == null) goto L15;
        String r13 = r1.getLimitText();
    L16:
        if (r13 == null) goto L26;
        if (r13.length() <= 0) goto L20;
        r11 = true;
    L20:
        if (r11 == true) goto L23;
        r13 = null;
    L23:
        if (r13 == null) goto L26;
        return r13;
    L15:
        r13 = null;
        goto L16
    L7:
        r12 = false;
    L26:
        cg.g r14 = this.b;
        if (r14 != null) goto L29;
        return null;
    L29:
        return r14.d;
    }

    public final String getNewBonusText() {
        String[] r0 = this.c;
        if (r0 == null) goto L9;
        cg.g r1 = this.b;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 != null) goto L13;
        return null;
    L13:
        return r11.getNewBonusText();
    L11:
        return null;
    L9:
        return "";
    }

    public final Long getRealStock() {
        String[] r0 = this.c;
        if (r0 == null) goto L8;
        cg.g r10 = this.b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f(r0);
    L8:
        return null;
    }

    public final Object getSelectEPInfo() {
        String[] r0 = this.c;
        if (r0 == null) goto L9;
        cg.g r1 = this.b;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 != null) goto L13;
        return null;
    L13:
        return r11.getEpInfo();
    L11:
        return null;
    L9:
        return "";
    }

    public final List<PromotionBenefitLabel> getSkuBenefitLabel() {
        cg.g r0 = this.b;
        if (r0 == null) goto L5;
        String[] r1 = this.c;
        Intrinsics.checkNotNull(r1);
        return r0.g(r1);
    L5:
        return null;
    }

    public final String[] getCheckedIdArray() {
        return this.c;
    }

    public final List<String> getFirstIdList() {
        return this.j;
    }

    public final List<String> getNameList() {
        return this.i;
    }

    public final void setCheckedChangeListener(b r10) {
        Intrinsics.checkNotNullParameter(r10, "checkChangeListener");
        this.f = r10;
    }

    public final void setSpecGroupLogEventLogger(d r10) {
        Intrinsics.checkNotNullParameter(r10, "logger");
        this.k = r10;
    }

    public SpecItemGroupLayout(Context r10, c r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "mSkuStockData");
        super(r10, null, 0);
        this.l = r11;
        this.a = r10;
        setOrientation(1);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
    }
}
