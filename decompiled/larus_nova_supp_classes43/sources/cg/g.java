package cg;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final Map<String, SkuItemInfoVO> a;
    public final Context b;
    public final SkuLimit c;
    public final String d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.b;
    }

    public static String b(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        StringBuilder r0 = new StringBuilder();
        int r1 = r10.length;
        boolean r11 = false;
        int r12 = 0;
    L3:
        if (r12 >= r1) goto L10;
        String r13 = r10[r12];
        if (r13 == null) goto L6;
        r0.append(r13);
        r0.append("_");
        r12 = r12 + 1;
        goto L3
    L6:
        return null;
    L10:
        if (r0.length() <= 0) goto L12;
        r11 = true;
    L12:
        if (r11 == false) goto L15;
        r0.deleteCharAt(r0.length() - 1);
    L15:
        return r0.toString();
    }

    public static String i(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        StringBuilder r0 = new StringBuilder();
        int r1 = r10.length;
        boolean r11 = false;
        int r12 = 0;
    L3:
        if (r12 >= r1) goto L10;
        String r13 = r10[r12];
        if (r13 != null) goto L7;
        r0.append("0");
    L8:
        r0.append("_");
        r12 = r12 + 1;
        goto L3
    L7:
        r0.append(r13);
        goto L8
    L10:
        if (r0.length() <= 0) goto L12;
        r11 = true;
    L12:
        if (r11 == false) goto L15;
        r0.deleteCharAt(r0.length() - 1);
    L15:
        return r0.toString();
    }

    public final boolean a(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 != null) goto L7;
        return false;
    L7:
        return r12.getCanSelect();
    }

    public final SkuLimit c(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L8;
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        SkuLimit r0 = new SkuLimit(r12.getLowerLimit(), r12.getLowerLimitToast());
    L13:
        return r0;
    L8:
        SkuItemInfoVO r13 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r13 == null) goto L15;
        r0 = new SkuLimit(r13.getLowerLimit(), r13.getLowerLimitToast());
        goto L13
    L15:
        return this.c;
    }

    public final Integer d(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r12.getPriceHeaderStyle());
    }

    public final CarAdaptComponent e(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        if (r11 == null) goto L7;
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 == null) goto L7;
        return r12.getCarAdaptComponent();
    L7:
        return null;
    }

    public final Long f(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r12.getStockNum());
    }

    public final List<PromotionBenefitLabel> g(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        if (Intrinsics.areEqual(r11, "0") == false) goto L6;
        return null;
    L6:
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 == null) goto L11;
        List<PromotionBenefitLabel> r13 = r12.getBenefitLabels();
        if (r13 == null) goto L11;
        return r13;
    L11:
        return CollectionsKt.emptyList();
    }

    public final String h(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.getBigImageUrl();
    }

    public final String j(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.getImageUrl();
    }

    public final Long k(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r12.getPrice());
    }

    public final SkuLimit l(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "idArray");
        String r11 = i(r10);
        long r1 = Long.MAX_VALUE;
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L11;
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        Long r13 = r12.getUserLimit();
        if (r13 == null) goto L10;
        r1 = r13.longValue();
    L10:
        SkuLimit r0 = new SkuLimit(r1, r12.getUpperLimitToast());
    L19:
        return r0;
    L11:
        SkuItemInfoVO r14 = (SkuItemInfoVO) ((LinkedHashMap) this.a).get(r11);
        if (r14 == null) goto L21;
        Long r15 = r14.getUserLimit();
        if (r15 == null) goto L17;
        r1 = r15.longValue();
    L17:
        r0 = new SkuLimit(r1, r14.getUpperLimitToast());
        goto L19
    L21:
        return this.c;
    }

    public g(Context r101, Map<String, SkuItemInfoVO> r102, Map<String, String> r103, Map<String, String> r104, SkuLimit r105, SkuLimit r106, String r107) {
        Intrinsics.checkNotNullParameter(r102, "skuInfoMap");
        Intrinsics.checkNotNullParameter(r103, "skuImageMap");
        Intrinsics.checkNotNullParameter(r105, "noSelectedSkuUpperLimit");
        Intrinsics.checkNotNullParameter(r106, "noSelectedSkuLowerLimit");
        this.b = r101;
        this.c = r106;
        this.d = r107;
        int r10 = k.a;
        Intrinsics.checkNotNullParameter(r102, "skuInfoMap");
        Intrinsics.checkNotNullParameter(r103, "skuImageMap");
        Intrinsics.checkNotNullParameter("0", "noneId");
        Intrinsics.checkNotNullParameter("_", "serverLinkSymbol");
        Intrinsics.checkNotNullParameter(r105, "noSkuUpperLimit");
        Intrinsics.checkNotNullParameter(r106, "noSkuLowerLimit");
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Map.Entry<String, SkuItemInfoVO>> r1 = r102.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L59;
        Map.Entry<String, SkuItemInfoVO> r12 = r1.next();
        String r13 = r12.getKey();
        SkuItemInfoVO r14 = r12.getValue();
        List r15 = new Regex("_").split(r13, 0);
        if (r15.isEmpty() == true) goto L16;
        ListIterator r16 = r15.listIterator(r15.size());
    L9:
        if (r16.hasPrevious() == false) goto L16;
        if (((String) r16.previous()).length() != 0) goto L13;
        boolean r17 = true;
    L14:
        if (r17 == true) goto L9;
        List r18 = CollectionsKt.take(r15, r16.nextIndex() + 1);
    L17:
        Object[] r19 = r18.toArray(new String[0]);
        if (r19 == null) goto L58;
        String[] r110 = (String[]) r19;
        int r111 = r110.length;
        int r112 = 1 << r111;
        int r113 = 0;
    L20:
        if (r113 >= r112) goto L4;
        SkuStatusDetail r114 = null;
        String r108 = null;
        String r115 = "";
        int r116 = 0;
    L22:
        if (r116 >= r111) goto L33;
        if (((r113 >> r116) & 1) != 0) goto L28;
        String r20 = r115 + "0_";
        String r117 = r108;
    L26:
        r115 = r20;
        r116 = r116 + 1;
        r1 = r1;
        r108 = r117;
        goto L22
    L28:
        if (r116 != 0) goto L30;
        r117 = r110[0];
    L31:
        r20 = (r115 + r110[r116]) + "_";
        goto L26
    L30:
        r117 = r108;
        goto L31
    L33:
        Iterator<Map.Entry<String, SkuItemInfoVO>> r118 = r1;
        String r21 = r115.substring(0, r115.length() - 1);
        SkuItemInfoVO r119 = (SkuItemInfoVO) r11.get(r21);
        if (r119 == null) goto L46;
        r119.setStockNum(r119.getStockNum() + r14.getStockNum());
        if (r119.getCanSelect() == true) goto L38;
        r119.setCanSelect(r14.getCanSelect());
    L38:
        SkuStatusDetail r22 = r119.getSkuStatusDetail();
        if (r22 == null) goto L44;
        if (r22.equals(r14.getSkuStatusDetail()) != true) goto L44;
        r114 = r119.getSkuStatusDetail();
    L44:
        r119.setSkuStatusDetail(r114);
        Unit r23 = Unit.INSTANCE;
    L56:
        r113 = r113 + 1;
        r112 = r112;
        r1 = r118;
        goto L20
    L46:
        if (TextUtils.equals(r21, r13) == false) goto L48;
        SkuItemInfoVO r120 = r14;
    L50:
        if (TextUtils.isEmpty(r108) == true) goto L55;
        String r121 = r108;
        r120.setImageUrl(r103.get(r121));
        if (r104 == null) goto L54;
        r114 = (String) r104.get(r121);
    L54:
        r120.setBigImageUrl(r114);
    L55:
        r11.put(r21, r120);
        goto L56
    L48:
        r120 = new SkuItemInfoVO("", r14.getStockNum(), null, -1, -1, null, null, Long.valueOf(r105.getCount()), r106.getCount(), r105.getToast(), r106.getToast(), null, 0, null, null, null, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, null, 0, null, 0, null, false, false, null, -1L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1948, -33, 1, null);
        r120.setStockNum(r14.getStockNum());
        r120.setCanSelect(r14.getCanSelect());
        r120.setSkuStatusDetail(r14.getSkuStatusDetail());
        Unit r122 = Unit.INSTANCE;
        goto L50
    L58:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L13:
        r17 = false;
    L16:
        r18 = CollectionsKt.emptyList();
        goto L17
    L59:
        this.a = r11;
    }
}
