package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.ClothesSizeAssistantStruct;
import com.bytedance.android.ec.common.impl.sku.model.ExtraAttribute;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuLimit;
import com.bytedance.android.ec.common.impl.sku.model.SpecChartStruct;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfoItem;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0005FGHIJJ\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0017\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001e\u0010\u001bJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001f\u0010\u001bJ\u000f\u0010 \u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b \u0010\u001bJ\b\u0010!\u001a\u0004\u0018\u00010\u0003J\b\u0010#\u001a\u0004\u0018\u00010\"J\b\u0010$\u001a\u0004\u0018\u00010\u0003J\u000f\u0010%\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u0004\u0018\u00010\u0003J\u000f\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b)\u0010*J\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+J\u000f\u0010.\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b.\u0010\u001bJ\b\u0010/\u001a\u0004\u0018\u00010\u0003J\b\u00100\u001a\u0004\u0018\u00010\u0003J\b\u00101\u001a\u0004\u0018\u00010\u0003J\b\u00102\u001a\u0004\u0018\u00010\u0003J\b\u00103\u001a\u0004\u0018\u00010\u0003J\u000f\u00104\u001a\u0004\u0018\u00010(¢\u0006\u0004\b4\u0010*J\u000f\u00105\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b5\u0010\u001bJ\b\u00106\u001a\u0004\u0018\u00010\u0003J\b\u00107\u001a\u0004\u0018\u00010\u0003J\u000f\u00108\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b8\u0010\u001bJ\u000f\u00109\u001a\u0004\u0018\u00010(¢\u0006\u0004\b9\u0010*J\u000f\u0010:\u001a\u0004\u0018\u00010(¢\u0006\u0004\b:\u0010*J\u000f\u0010;\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b;\u0010\u001bJ\b\u0010<\u001a\u0004\u0018\u00010\u0003J\b\u0010=\u001a\u0004\u0018\u00010\u0003J\u000f\u0010>\u001a\u0004\u0018\u00010(¢\u0006\u0004\b>\u0010*J\u000f\u0010?\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b?\u0010\u001bJ\u000f\u0010@\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b@\u0010\u001bJ\u000f\u0010A\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bA\u0010&J\u000e\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020BJ\u0006\u0010E\u001a\u00020\u0007¨\u0006K"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemOptimizeGroupLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "", "getImageUrlList", "getNameList", "getFirstIdList", "", "getCurrentPosition", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemOptimizeGroupLayout$b;", "checkChangeListener", "", "setCheckedChangeListener", "", "getCheckedIdArray", "()[Ljava/lang/String;", "getCheckedId", "getCheckedSkuId", "getCheckSkuImageUrl", "getCheckSkuBigImageUrl", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "getCheckSkuMaxPurchaseCount", "getCheckSkuLeastPurchaseCount", "getLimitText", "getStockDesc", "", "getRealStock", "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getCheckSkuCarAdapt", "getCheckSkuPrice", "getCheckSkuOriginPrice", "getCheckSkuDiscountPrice", "getCheckSkuDiscountPriceText", "", "getSelectEPInfo", "getCheckSkuCampaignPriceHeader", "getCheckSkuPriceHedaerStyle", "()Ljava/lang/Integer;", "getNewBonusText", "", "getCanAddCart", "()Ljava/lang/Boolean;", "", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "getSkuBenefitLabel", "getCheckSkuFirstPrice", "getCheckSkuFirstPricePrefix", "getCheckSkuFirstPriceSuffix", "getCheckSkuFirstPriceSpecDesc", "getCheckSkuSecondPriceSpecDesc", "getCheckSkuRegularPriceSpecDesc", "getCheckSkuFirstPriceIsUnderline", "getCheckSkuSecondPrice", "getCheckSkuSecondPricePrefix", "getCheckSkuSecondPriceSuffix", "getCheckSkuPriceType", "getCheckSkuSecondPriceIsUnderline", "getCheckSkuSecondPriceIsReducePrice", "getCheckSkuRegularPrice", "getCheckSkuRegularPricePrefix", "getCheckSkuRegularPriceSuffix", "getCheckSkuRegularPriceIsUnderline", "getCheckSkuHotMinPrice", "getCheckSkuHotMaxPrice", "getCheckSkuAtmosphereStyle", "Lcom/bytedance/android/ec/common/impl/sku/view/SpecItemOptimizeGroupLayout$d;", "logger", "setSpecGroupLogEventLogger", "getUncheckSpecOffset", "a", "b", "c", "d", "e", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SpecItemOptimizeGroupLayout extends LinearLayoutCompat {
    public Context a;
    public cg.g b;
    public String[] c;
    public boolean d;
    public final List<s> e;
    public final List<LinearLayout> f;
    public b g;
    public final List<String> h;
    public final List<String> i;
    public final List<String> j;
    public final List<String> k;
    public d l;

    public static final class a {
    }

    public interface b {
        void a(String[] r1, boolean r10);
    }

    public interface c {
    }

    public interface d {
        void a(int r1);

        void b();
    }

    public interface e {
        s.c getCheckedItemViewInfo();
    }

    public static final class f implements s.a {
        public final /* synthetic */ SpecItemOptimizeGroupLayout a;
        public final /* synthetic */ SkuInfoVO b;

        @Override // com.bytedance.android.ec.common.impl.sku.view.s.a
        public final void a() {
            String[] r0 = this.a.c;
            if (r0 != null) goto L5;
            return;
        L5:
            List<SpecInfo> r1 = this.b.getSpecInfoList();
            ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r11 = r1.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            r10.add(((SpecInfo) r11.next()).getDefaultSelect());
            goto L7
        L9:
            int r12 = r0.length;
            int r13 = 0;
        L11:
            if (r13 >= r12) goto L18;
            if (ArraysKt.getOrNull(r0, r13) != null) goto L17;
            if (Intrinsics.areEqual((Boolean) CollectionsKt.getOrNull(r10, r13), Boolean.TRUE) == false) goto L17;
            boolean r14 = true;
        L19:
            if (r14 == false) goto L57;
            List<s> r15 = this.a.e;
            ArrayList r16 = new ArrayList();
            Iterator r17 = ((ArrayList) r15).iterator();
            int r18 = 0;
        L22:
            if (r17.hasNext() == false) goto L30;
            Object r19 = r17.next();
            int r20 = r18 + 1;
            if (r18 >= 0) goto L26;
            CollectionsKt.throwIndexOverflow();
        L26:
            s r21 = (s) r19;
            if (Intrinsics.areEqual((Boolean) CollectionsKt.getOrNull(r10, r18), Boolean.TRUE) == false) goto L29;
            r16.add(r19);
        L29:
            r18 = r20;
            goto L22
        L30:
            Iterator r22 = r16.iterator();
        L32:
            if (r22.hasNext() == false) goto L82;
            s r23 = (s) r22.next();
            if (r23.f == true) goto L32;
            int r24 = r23.d.size();
            int r25 = 0;
        L38:
            if (r25 >= r24) goto L45;
            s.c r26 = (s.c) ListProtector.get(r23.d, r25);
            r25 = r25 + 1;
            Object r27 = r23.getChildAt(r25);
            if ((r27 instanceof SpecItemOptimizeView) == true) goto L42;
            r27 = null;
        L42:
            SpecItemOptimizeView r28 = (SpecItemOptimizeView) r27;
            if (r26.a == false) goto L38;
        L46:
            if (r26 == null) goto L32;
            if (r28 == null) goto L32;
            String r29 = r26.c;
            s.c r30 = r23.e;
            if (r30 == null) goto L51;
            String r31 = r30.c;
        L53:
            if ((!Intrinsics.areEqual(r29, r31)) == false) goto L32;
            r23.c(null);
            r23.e = r26;
            r23.f = false;
            r28.S5(r26, r26.c);
            s.a r32 = r23.j;
            if (r32 == null) goto L32;
            r32.d(r23.h, r23.e, false);
            goto L32
        L51:
            r31 = null;
            goto L53
        L45:
            r26 = null;
            r28 = null;
            goto L46
        L82:
            return;
        L57:
            return;
        L17:
            r13 = r13 + 1;
            goto L11
        L18:
            r14 = false;
            goto L19
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.s.a
        public final void c() {
            Iterator r0 = ((ArrayList) this.a.e).iterator();
            int r10 = 0;
        L4:
            if (r0.hasNext() == false) goto L26;
            Object r11 = r0.next();
            int r12 = r10 + 1;
            if (r10 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            s r13 = (s) r11;
            SpecInfo r14 = (SpecInfo) CollectionsKt.getOrNull(this.b.getSpecInfoList(), r10);
            if (r14 == null) goto L11;
            Boolean r15 = r14.getDefaultSelect();
        L12:
            Boolean r16 = Boolean.TRUE;
            if (Intrinsics.areEqual(r15, r16) == false) goto L25;
            if (r14 == null) goto L16;
            Boolean r17 = r14.getHideSpec();
        L18:
            if (Intrinsics.areEqual(r17, r16) == false) goto L25;
            if (r13.e == null) goto L25;
            r13.e = null;
            r13.f = false;
            r13.c(null);
            s.a r18 = r13.j;
            if (r18 == null) goto L25;
            r18.d(r13.h, r13.e, false);
            goto L25
        L16:
            r17 = null;
        L25:
            r10 = r12;
            goto L4
        L11:
            r15 = null;
            goto L12
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.s.a
        public final void b(int r10) {
            d r0 = this.a.l;
            if (r0 == null) goto L6;
            r0.a(r10);
            return;
        }

        public f(SpecItemOptimizeGroupLayout r1, SkuInfoVO r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // com.bytedance.android.ec.common.impl.sku.view.s.a
        public final void d(int r13, s.c r14, boolean r15) {
            SpecItemOptimizeGroupLayout r0 = this.a;
            String[] r1 = r0.c;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r14 == null) goto L7;
            String r16 = r14.c;
        L8:
            r1[r13] = r16;
            s r17 = (s) CollectionsKt.getOrNull(r0.e, r13);
            if (r17 != null) goto L11;
        L49:
            SpecItemOptimizeGroupLayout r18 = this.a;
            if (r18.d == false) goto L63;
            b r19 = r18.g;
            if (r19 == null) goto L64;
            r19.a(r1, r15);
            return;
        L64:
            return;
        L63:
            return;
        L11:
            if (r17.getVisibility() != 0) goto L13;
            boolean r110 = true;
        L14:
            if (r110 != true) goto L49;
            Iterator r111 = ((ArrayList) this.a.e).iterator();
            int r10 = 0;
        L17:
            if (r111.hasNext() == false) goto L49;
            Object r11 = r111.next();
            int r12 = r10 + 1;
            if (r10 >= 0) goto L21;
            CollectionsKt.throwIndexOverflow();
        L21:
            s r20 = (s) r11;
            if (r10 == r13) goto L48;
            cg.g r21 = this.a.b;
            r20.getClass();
            Intrinsics.checkNotNullParameter(r1, "checkIdArray");
            String[] r22 = (String[]) Arrays.copyOf(r1, r1.length);
            int r23 = r20.getChildCount();
            int r24 = r20.g;
        L24:
            if (r24 >= r23) goto L48;
            int r25 = r24 - r20.g;
            if (r21 == null) goto L47;
            if (r25 >= r20.d.size()) goto L47;
            s.c r26 = (s.c) ListProtector.get(r20.d, r25);
            r22[r20.h] = r26.c;
            r26.a = r21.a(r22);
            Intrinsics.checkNotNullParameter(r22, "idArray");
            SkuItemInfoVO r112 = (SkuItemInfoVO) ((LinkedHashMap) r21.a).get(cg.g.i(r22));
            if (r112 == null) goto L32;
            SkuStatusDetail r113 = r112.getSkuStatusDetail();
        L33:
            r26.b = r113;
            if (TextUtils.equals(r1[r20.h], r26.c) == true) goto L36;
        L38:
            Object r114 = r20.getChildAt(r24);
            if (r114 == null) goto L46;
            SpecItemOptimizeView r115 = (SpecItemOptimizeView) r114;
            s.c r116 = r20.e;
            if (r116 == null) goto L43;
            String r117 = r116.c;
        L44:
            r115.S5(r26, r117);
            goto L47
        L43:
            r117 = null;
            goto L44
        L46:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeView");
        L36:
            if (r26.a == true) goto L38;
            r20.e = null;
            r20.f = false;
            goto L38
        L32:
            r113 = null;
        L47:
            r24 = r24 + 1;
        L48:
            r10 = r12;
            goto L17
        L13:
            r110 = false;
            goto L14
        L7:
            r16 = null;
            goto L8
        }
    }

    static {
    }

    public final Boolean getCanAddCart() {
        String[] r0 = this.c;
        if (r0 == null) goto L9;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getCanAddCart();
    L9:
        return null;
    }

    public final Integer getCheckSkuAtmosphereStyle() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getAtmosphereStyle();
    L9:
        return null;
    L11:
        return 0;
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

    public final Long getCheckSkuFirstPrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getFirstPrice();
    L9:
        return null;
    L11:
        return 0L;
    }

    public final Boolean getCheckSkuFirstPriceIsUnderline() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getFirstPriceIsUnderline();
    L9:
        return null;
    L11:
        return Boolean.FALSE;
    }

    public final String getCheckSkuFirstPricePrefix() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getFirstPricePrefix();
    L9:
        return null;
    L10:
        return "";
    }

    public final String getCheckSkuFirstPriceSpecDesc() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getFirstPriceSupplement();
    L9:
        return null;
    L10:
        return "";
    }

    public final String getCheckSkuFirstPriceSuffix() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getFirstPriceSuffix();
    L9:
        return null;
    L10:
        return "";
    }

    public final Long getCheckSkuHotMaxPrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getHotMaxPrice();
    L9:
        return null;
    L11:
        return 0L;
    }

    public final Long getCheckSkuHotMinPrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getHotMinPrice();
    L9:
        return null;
    L11:
        return 0L;
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

    public final Long getCheckSkuPriceType() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getPriceType();
    L9:
        return null;
    L11:
        return -1L;
    }

    public final Long getCheckSkuRegularPrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getRegularPrice();
    L9:
        return null;
    L11:
        return 0L;
    }

    public final Boolean getCheckSkuRegularPriceIsUnderline() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getRegularPriceIsUnderline();
    L9:
        return null;
    L11:
        return Boolean.FALSE;
    }

    public final String getCheckSkuRegularPricePrefix() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getRegularPricePrefix();
    L9:
        return null;
    L10:
        return "";
    }

    public final String getCheckSkuRegularPriceSpecDesc() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getRegularPriceSupplement();
    L9:
        return null;
    L10:
        return "";
    }

    public final String getCheckSkuRegularPriceSuffix() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getRegularPriceSuffix();
    L9:
        return null;
    L10:
        return "";
    }

    public final Long getCheckSkuSecondPrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getSecondPrice();
    L9:
        return null;
    L11:
        return 0L;
    }

    public final Boolean getCheckSkuSecondPriceIsReducePrice() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getSecondPriceIsReducePrice();
    L9:
        return null;
    L11:
        return Boolean.FALSE;
    }

    public final Boolean getCheckSkuSecondPriceIsUnderline() {
        String[] r0 = this.c;
        if (r0 == null) goto L11;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getSecondPriceIsUnderline();
    L9:
        return null;
    L11:
        return Boolean.FALSE;
    }

    public final String getCheckSkuSecondPricePrefix() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getSecondPricePrefix();
    L9:
        return null;
    L10:
        return "";
    }

    public final String getCheckSkuSecondPriceSpecDesc() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getSecondPriceSupplement();
    L9:
        return null;
    L10:
        return "";
    }

    public final String getCheckSkuSecondPriceSuffix() {
        String[] r0 = this.c;
        if (r0 == null) goto L10;
        cg.g r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "idArray");
        String r10 = cg.g.i(r0);
        SkuItemInfoVO r11 = (SkuItemInfoVO) ((LinkedHashMap) r1.a).get(r10);
        if (r11 == null) goto L9;
        return r11.getSecondPriceSuffix();
    L9:
        return null;
    L10:
        return "";
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
        List<String> r10 = this.k;
        if (r10 == null) goto L20;
        int r11 = ((ArrayList) r10).size();
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
        List<String> r0 = this.i;
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return this.h;
    }

    public final String getLimitText() {
        cg.g r0 = this.b;
        if (r0 == null) goto L24;
        String[] r1 = this.c;
        boolean r10 = false;
        if (r1 == null) goto L7;
        boolean r11 = true;
    L8:
        String r12 = null;
        if (r11 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L24;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r1, "idArray");
        SkuItemInfoVO r13 = (SkuItemInfoVO) ((LinkedHashMap) r0.a).get(cg.g.i(r1));
        if (r13 == null) goto L16;
        String r14 = r13.getLimitText();
    L17:
        if (r14 == null) goto L24;
        if (r14.length() <= 0) goto L21;
        r10 = true;
    L21:
        if (r10 == false) goto L23;
        r12 = r14;
    L23:
        if (r12 == null) goto L24;
        return r12;
    L16:
        r14 = null;
        goto L17
    L7:
        r11 = false;
    L24:
        return "";
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

    public final String getStockDesc() {
        cg.g r0 = this.b;
        if (r0 == null) goto L17;
        String[] r1 = this.c;
        if (r1 == null) goto L7;
        boolean r10 = true;
    L8:
        String r11 = null;
        if (r10 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L17;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r1, "idArray");
        SkuItemInfoVO r12 = (SkuItemInfoVO) ((LinkedHashMap) r0.a).get(cg.g.i(r1));
        if (r12 == null) goto L16;
        r11 = r12.getStockDesc();
    L16:
        if (r11 == null) goto L17;
        return r11;
    L7:
        r10 = false;
    L17:
        return "";
    }

    public final int getUncheckSpecOffset() {
        String[] r0 = this.c;
        if (r0 == null) goto L17;
        int r10 = r0.length;
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L16;
        String r12 = r0[r11];
        if (r12 != null) goto L9;
    L12:
        boolean r13 = true;
    L13:
        if (r13 == true) goto L18;
        r11 = r11 + 1;
    L18:
        LinearLayout r1 = (LinearLayout) CollectionsKt.getOrNull(this.f, r11);
        if (r1 != null) goto L21;
        return 0;
    L21:
        return r1.getTop();
    L9:
        if (r12.length() == 0) goto L12;
        r13 = false;
        goto L13
    L16:
        r11 = -1;
        goto L18
    L17:
        r11 = 0;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SkuLimit getCheckSkuLeastPurchaseCount() {
        SkuLimit r1 = null;
        boolean r10 = false;
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L14;
        cg.g r0 = this.b;
        if (r0 == null) goto L35;
        String[] r11 = this.c;
        if (r11 == null) goto L9;
        r10 = true;
    L9:
        if (r10 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L36;
        Intrinsics.checkNotNull(r11);
        return r0.c(r11);
    L36:
        return null;
    L35:
        return null;
    L14:
        cg.g r12 = this.b;
        if (r12 == null) goto L34;
        String[] r13 = this.c;
        if (r13 == null) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L34;
        Intrinsics.checkNotNull(r13);
        SkuLimit r15 = r12.c(r13);
        if (r15 == null) goto L34;
        if (r15.getCount() < 1) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L32;
        r1 = r15;
    L32:
        if (r1 == null) goto L34;
        return r1;
    L29:
        r16 = false;
        goto L30
    L19:
        r14 = false;
    L34:
        return new SkuLimit(1, th.a.h(getContext(), 2131914001, new Object[]{1}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SkuLimit getCheckSkuMaxPurchaseCount() {
        cg.g r1 = null;
        boolean r10 = false;
        if (com.bytedance.android.ec.core.abtest.d.E() == false) goto L14;
        cg.g r0 = this.b;
        if (r0 == null) goto L27;
        String[] r11 = this.c;
        if (r11 == null) goto L9;
        r10 = true;
    L9:
        if (r10 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L28;
        Intrinsics.checkNotNull(r11);
        return r0.l(r11);
    L28:
        return null;
    L27:
        return null;
    L14:
        cg.g r12 = this.b;
        if (r12 == null) goto L26;
        String[] r13 = this.c;
        if (r13 == null) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L22;
        r1 = r12;
    L22:
        if (r1 == null) goto L26;
        Intrinsics.checkNotNull(r13);
        SkuLimit r15 = r1.l(r13);
        if (r15 == null) goto L26;
        return r15;
    L19:
        r14 = false;
    L26:
        return new SkuLimit(Long.MAX_VALUE, th.a.h(getContext(), 2131914000, new Object[]{Long.MAX_VALUE}));
    }

    public final String[] getCheckedIdArray() {
        return this.c;
    }

    public final List<String> getFirstIdList() {
        return this.k;
    }

    public final List<String> getNameList() {
        return this.j;
    }

    public final void setCheckedChangeListener(b r10) {
        Intrinsics.checkNotNullParameter(r10, "checkChangeListener");
        this.g = r10;
    }

    public final void setSpecGroupLogEventLogger(d r10) {
        Intrinsics.checkNotNullParameter(r10, "logger");
        this.l = r10;
    }

    public SpecItemOptimizeGroupLayout(Context r10, c r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "mSkuStockData");
        super(r10, null, 0);
        this.a = r10;
        setOrientation(1);
        this.e = new ArrayList();
        this.f = new ArrayList();
        new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.view.View, android.widget.FrameLayout, com.bytedance.android.ec.common.impl.sku.view.r, com.bytedance.android.ec.common.impl.sku.view.s, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v32, types: [android.view.View, android.widget.LinearLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r35v0, types: [android.view.ViewGroup, com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout] */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32, types: [com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeView] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v77 */
    /* JADX WARN: Type inference failed for: r5v78 */
    /* JADX WARN: Type inference failed for: r5v79 */
    /* JADX WARN: Type inference failed for: r9v11, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeView] */
    public final void d(SkuInfoVO r36, String[] r37, int r38, String r39, final SkuViewModel r40, Integer r41) {
        SkuInfoVO r1 = r36;
        String r10 = r39;
        Intrinsics.checkNotNullParameter(r10, "baseParamsJson");
        Intrinsics.checkNotNullParameter(r40, "viewModel");
        if (r1 == null) goto L424;
        List<SpecInfo> r11 = r36.getSpecInfoList();
        if (r11 != null) goto L7;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L426;
        int r13 = r36.getSpecInfoList().size();
        this.c = new String[r13];
        if (r36.getPictureMap() == null) goto L425;
        this.b = new cg.g(getContext(), r36.getSkuList(), r36.getPictureMap(), r36.getBigPicMap(), r36.getUpperLimit(), r36.getLowerLimit(), r36.getLimitText());
        List<SpecInfo> r14 = r36.getSpecInfoList();
        Map<String, String> r15 = r36.getPictureMap();
        List<SpecInfo> r16 = r14;
        if (r16 != null) goto L18;
    L21:
        boolean r17 = true;
    L22:
        if (r17 == true) goto L86;
        ((ArrayList) this.k).clear();
        ((ArrayList) this.h).clear();
        ((ArrayList) this.i).clear();
        ((ArrayList) this.j).clear();
        ((ArrayList) this.j).add("默认");
        String[] r18 = new String[r14.size()];
        List<String> r19 = this.h;
        cg.g r110 = this.b;
        if (r110 == null) goto L27;
        String r111 = r110.j(r18);
    L28:
        ((ArrayList) r19).add(r111);
        List<String> r20 = this.i;
        cg.g r112 = this.b;
        if (r112 == null) goto L31;
        String r113 = r112.h(r18);
    L32:
        ((ArrayList) r20).add(r113);
        List<SpecInfoItem> r21 = ((SpecInfo) ListProtector.get(r14, 0)).getSpecItems();
        if (r15 != null) goto L35;
    L36:
        Iterator r22 = r21.iterator();
    L38:
        if (r22.hasNext() == false) goto L78;
        SpecInfoItem r23 = (SpecInfoItem) r22.next();
        r18[0] = r23.getId();
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L50;
        ((ArrayList) this.k).add(r23.getId());
        ((ArrayList) this.j).add(r23.getName());
        List<String> r24 = this.h;
        cg.g r114 = this.b;
        if (r114 == null) goto L44;
        String r115 = r114.j(r18);
    L45:
        ((ArrayList) r24).add(r115);
        List<String> r25 = this.i;
        cg.g r116 = this.b;
        if (r116 == null) goto L48;
        String r117 = r116.h(r18);
    L49:
        ((ArrayList) r25).add(r117);
        goto L50
    L48:
        r117 = null;
        goto L49
    L44:
        r115 = null;
    L50:
        cg.g r26 = this.b;
        if (r26 == null) goto L53;
        boolean r27 = r26.a(r18);
    L54:
        if (r27 == false) goto L61;
        cg.g r28 = this.b;
        if (r28 == null) goto L58;
        String r29 = r28.j(r18);
    L59:
        if (r29 == null) goto L61;
        boolean r30 = true;
    L62:
        if (r30 == false) goto L64;
        String[] r31 = r18;
    L65:
        if (r31 == null) goto L38;
        if (com.bytedance.android.ec.core.abtest.d.k() == true) goto L38;
        ((ArrayList) this.k).add(r23.getId());
        ((ArrayList) this.j).add(r23.getName());
        List<String> r32 = this.h;
        cg.g r33 = this.b;
        if (r33 == null) goto L71;
        String r34 = r33.j(r18);
    L72:
        ((ArrayList) r32).add(r34);
        List<String> r35 = this.i;
        cg.g r42 = this.b;
        if (r42 == null) goto L75;
        String r43 = r42.h(r18);
    L76:
        ((ArrayList) r35).add(r43);
        goto L38
    L75:
        r43 = null;
        goto L76
    L71:
        r34 = null;
        goto L72
    L64:
        r31 = null;
        goto L65
    L58:
        r29 = null;
    L61:
        r30 = false;
        goto L62
    L53:
        r27 = false;
    L78:
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L86;
        if (((ArrayList) this.j).size() != 1) goto L82;
        String r44 = th.a.g(getContext(), 2131897068);
    L84:
        if (((ArrayList) this.j).size() <= 0) goto L86;
        ListProtector.set(this.j, 0, r44);
        goto L86
    L82:
        r44 = th.a.g(getContext(), 2131897067);
        goto L84
    L35:
        if (r15.size() == 0) goto L78;
    L31:
        r113 = null;
        goto L32
    L27:
        r111 = null;
    L86:
        List<SpecInfo> r45 = r36.getSpecInfoList();
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r45, 10));
        Iterator r119 = r45.iterator();
        int r46 = 0;
    L88:
        if (r119.hasNext() == false) goto L289;
        Object r47 = r119.next();
        int r120 = r46 + 1;
        if (r46 >= 0) goto L92;
        CollectionsKt.throwIndexOverflow();
    L92:
        SpecInfo r210 = (SpecInfo) r47;
        ArrayList r48 = new ArrayList();
        Iterator<SpecInfoItem> r49 = r210.getSpecItems().iterator();
    L94:
        if (r49.hasNext() == false) goto L130;
        SpecInfoItem r211 = r49.next();
        if (r211.getId() != null) goto L98;
    L128:
        Iterator<SpecInfoItem> r212 = r49;
        ArrayList r213 = r48;
        int r214 = r13;
        ArrayList r215 = r118;
    L129:
        r49 = r212;
        r118 = r215;
        r13 = r214;
        r48 = r213;
        goto L94
    L98:
        if (r211.getName() == null) goto L128;
        String r216 = r211.getId();
        Intrinsics.checkNotNull(r216);
        String r217 = r211.getName();
        Intrinsics.checkNotNull(r217);
        s.c r50 = new s.c(r216, r217, r211.getPrice(), r211.getDefaultSelect(), r211.getIcon(), r36.getSmallPicMap(), r36.getPictureMap());
        String[] r121 = new String[r13];
        r121[r46] = r211.getId();
        r212 = r49;
        cg.g r51 = this.b;
        if (r51 == null) goto L102;
        boolean r52 = r51.a(r121);
    L103:
        r50.a = r52;
        cg.g r53 = this.b;
        r215 = r118;
        if (r53 == null) goto L108;
        Intrinsics.checkNotNullParameter(r121, "idArray");
        SkuItemInfoVO r54 = (SkuItemInfoVO) ((LinkedHashMap) r53.a).get(cg.g.i(r121));
        if (r54 == null) goto L108;
        SkuStatusDetail r55 = r54.getSkuStatusDetail();
    L109:
        r50.b = r55;
        r48.add(r50);
        if (r37 == 0) goto L112;
        Integer r56 = Integer.valueOf(r37.length);
    L113:
        if (r56 != null) goto L116;
    L127:
        r213 = r48;
        r214 = r13;
        goto L129
    L116:
        if (r13 != r56.intValue()) goto L127;
        r213 = r48;
        r214 = r13;
        if (StringsKt.equals$default(r211.getId(), r37[r46], false, 2, null) == false) goto L129;
        if (r50.a == false) goto L126;
        String[] r57 = this.c;
        Intrinsics.checkNotNull(r57);
        r57[r46] = r211.getId();
        cg.g r58 = this.b;
        if (r58 == null) goto L129;
        String[] r59 = this.c;
        Intrinsics.checkNotNull(r59);
        if (r58.a(r59) == true) goto L129;
        String[] r60 = this.c;
        Intrinsics.checkNotNull(r60);
        r60[r46] = null;
        r37[r46] = 0;
        goto L129
    L126:
        r37[r46] = 0;
        goto L129
    L112:
        r56 = null;
    L108:
        r55 = null;
        goto L109
    L102:
        r52 = false;
        goto L103
    L130:
        ArrayList r218 = r48;
        int r219 = r13;
        ArrayList r220 = r118;
        Context r61 = this.a;
        Intrinsics.checkNotNull(r61);
        if (r36.getStatus() != 2) goto L133;
        boolean r62 = true;
    L134:
        final ?? r122 = new s(r61, r62);
        r122.setOnItemCheckedListener(new f(this, r1));
        String r63 = r210.getName();
        Context r64 = getContext();
        Intrinsics.checkNotNullParameter(r1, "$this$transformToGroupTitleOptimizeVO");
        Intrinsics.checkNotNullParameter(r64, "context");
        Intrinsics.checkNotNullParameter(r10, "baseParamsJson");
        SpecInfo r65 = (SpecInfo) ListProtector.get(r36.getSpecInfoList(), r46);
        String r123 = r65.getName();
        ExtraAttribute r221 = r65.getExtraAttribute();
        if (r221 == null) goto L137;
        String r66 = r221.getUserDeviceName();
    L138:
        cg.i r67 = new cg.i(r123, r66);
        ClothesSizeAssistantStruct r68 = r36.getClothesSizeAssistant();
        if (r68 == null) goto L141;
        Integer r69 = r68.getSpecLocation();
    L142:
        if (r69 != null) goto L145;
    L222:
        cg.b r70 = null;
    L223:
        Boolean r71 = r65.getShowBigPic();
        if (r71 == null) goto L226;
        boolean r72 = r71.booleanValue();
    L227:
        Boolean r73 = r65.getShowSmallPic();
        if (r73 == null) goto L230;
        boolean r74 = r73.booleanValue();
    L231:
        cg.d r75 = new cg.d(r67, r70, new cg.l(r72, r74));
        d r76 = this.l;
        if (r37 == 0) goto L234;
        String r77 = (String) ArraysKt.getOrNull(r37, r46);
    L235:
        Intrinsics.checkNotNullParameter(r63, "specTitle");
        Intrinsics.checkNotNullParameter(r75, "groupTitleVO");
        Intrinsics.checkNotNullParameter(r40, "viewModel");
        if (r122.getContext() != null) goto L238;
    L275:
        int r78 = r46;
        int r222 = r219;
        ViewGroup.LayoutParams r79 = null;
    L277:
        if (Intrinsics.areEqual(r210.getHideSpec(), Boolean.TRUE) == false) goto L279;
        r122.setVisibility(8);
    L279:
        ((ArrayList) this.e).add(r122);
        LinearLayoutCompat.LayoutParams r80 = new LinearLayoutCompat.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams) r80).topMargin = (int) UIUtils.dip2Px(getContext(), 0.0f);
        r122.setLayoutParams(r80);
        ?? r81 = new LinearLayout(getContext());
        r81.setOrientation(1);
        ViewGroup.LayoutParams r82 = r122.getLayoutParams();
        if ((r82 instanceof ViewGroup.MarginLayoutParams) == true) goto L282;
        r82 = r79;
    L282:
        ViewGroup.MarginLayoutParams r83 = (ViewGroup.MarginLayoutParams) r82;
        if (r83 == null) goto L285;
        r83.leftMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r83.rightMargin = com.bytedance.android.shopping.extensions.b.b(8);
        r122.setLayoutParams(r83);
    L285:
        Unit r84 = Unit.INSTANCE;
        r81.addView(r122);
        if (r78 >= (r36.getSpecInfoList().size() - 1)) goto L288;
        View r85 = new View(getContext());
        LinearLayoutCompat.LayoutParams r86 = new LinearLayoutCompat.LayoutParams(-1, 1);
        ((LinearLayout.LayoutParams) r86).topMargin = (int) UIUtils.dip2Px(r85.getContext(), 12.0f);
        r85.setLayoutParams(r86);
        r81.addView(r85);
    L288:
        ((ArrayList) this.f).add(r81);
        addView(r81);
        r220.add(Unit.INSTANCE);
        r1 = r36;
        r10 = r39;
        r118 = r220;
        r46 = r120;
        r13 = r222;
        goto L88
    L238:
        if (r218.isEmpty() == true) goto L275;
        ArrayList r87 = r218;
        r122.d = r87;
        r122.h = r46;
        r122.g = 1;
        GroupTitleOptimizeLayout r88 = new GroupTitleOptimizeLayout(r122.getContext(), null, 6, 0);
        int r124 = r46;
        r222 = r219;
        r88.a(r75, r46, r76, r40, new t(r122, r76));
        Unit r89 = Unit.INSTANCE;
        r122.i = r88;
        r122.addView(r88);
        int r90 = r87.size();
        ?? r91 = 0;
        int r92 = 0;
        s.c r93 = null;
        int r125 = 0;
    L241:
        if (r125 >= r90) goto L266;
        s.c r94 = (s.c) ListProtector.get(r87, r125);
        ?? r95 = new SpecItemOptimizeView(r122.getContext(), r122);
        ArrayList r223 = r87;
        r95.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        boolean r96 = r122.m;
        u r97 = new u(r40);
        int r224 = r90;
        Function1<Integer, Unit> r98 = new SpecItemOptimizeLayout$setSpecItemInfo$3(r122);
        Intrinsics.checkNotNullParameter(r94, "itemInfo");
        Intrinsics.checkNotNullParameter(r40, "viewModel");
        Intrinsics.checkNotNullParameter(r97, "onPageSelected");
        Intrinsics.checkNotNullParameter(r98, "onGalleryChange");
        r95.b = r94.a();
        r95.a = r96;
        r95.o = r40;
        r95.p = r125;
        int r99 = r124;
        if (r99 != 0) goto L246;
        if (r40 == null) goto L246;
        boolean r100 = r40.getCurrentSpecShowBigPicMode();
    L247:
        r95.d = r100;
        r95.b6(r94);
        r95.Z5();
        if (r125 != 0) goto L252;
        SkuViewModel r101 = r95.o;
        if (r101 == null) goto L252;
        r101.setCurrentSpecHasPrice(a2.b(r94.e));
    L252:
        r95.T5(r125, r94);
        r95.q = r98;
        r122.addView(r95);
        r95.S5(r94, null);
        r95.setItemClickListener(r122);
        ?? r102 = r91;
        if (r94.a == false) goto L258;
        r92 = r92 + 1;
        r102 = r91;
        if (r93 != null) goto L258;
        r93 = r94;
        r102 = r95;
    L258:
        if (r94.f == false) goto L265;
        if (r122.e != null) goto L265;
        if (r77 != null) goto L265;
        r122.e = r94;
        r95.S5(r94, r94.c);
        s.a r103 = r122.j;
        if (r103 == null) goto L265;
        r103.d(r99, r94, false);
    L265:
        r125 = r125 + 1;
        r124 = r99;
        r90 = r224;
        r87 = r223;
        r91 = r102;
    L246:
        r100 = false;
        goto L247
    L266:
        r78 = r124;
        r79 = null;
        if (r122.e != null) goto L277;
        if (r92 != 1) goto L277;
        if (r93 == null) goto L277;
        if (r91 == 0) goto L277;
        r122.e = r93;
        r122.f = false;
        r91.S5(r93, r93.c);
        s.a r104 = r122.j;
        if (r104 == null) goto L277;
        r104.d(r122.h, r122.e, false);
        goto L277
    L234:
        r77 = null;
        goto L235
    L230:
        r74 = false;
        goto L231
    L226:
        r72 = false;
        goto L227
    L145:
        if (r69.intValue() != r46) goto L222;
        String r105 = r36.getClothesSizeAssistant().getRecommendClothesSize();
        if (r105 != null) goto L150;
    L153:
        boolean r106 = true;
    L154:
        if (r106 == false) goto L156;
        String r107 = th.a.g(r64, 2131914099);
    L157:
        String r310 = r107;
        String r108 = r36.getClothesSizeAssistant().getLinkSchema();
        if (r108 != null) goto L160;
    L162:
        boolean r109 = false;
    L163:
        String r126 = "";
        if (r38 != 101(0x65, float:1.42E-43)) goto L166;
    L177:
        String r127 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    L179:
        if (r39.length() != 0) goto L181;
        boolean r225 = true;
    L182:
        if (r225 == false) goto L184;
        JSONObject r128 = new JSONObject();
    L185:
        r128.put("sku_from", r127);
        r128.put(com.bytedance.android.ec.core.event.a.KEY_AUTHOR_ID, r128.optString(com.bytedance.android.ec.core.event.a.KEY_ANCHOR_ID));
        Unit r129 = Unit.INSTANCE;
        String r130 = r128.toString();
        if (r109 == false) goto L222;
        SpecChartStruct r131 = r36.getClothesSizeAssistant().getSizeComponent();
        if (r131 == null) goto L192;
        Integer r132 = r131.getWidth();
        if (r132 == null) goto L192;
        int r311 = r132.intValue();
    L193:
        SpecChartStruct r133 = r36.getClothesSizeAssistant().getSizeComponent();
        if (r133 == null) goto L198;
        Integer r134 = r133.getHeight();
        if (r134 == null) goto L198;
        int r312 = r134.intValue();
    L199:
        Integer r135 = r36.getClothesSizeAssistant().getAbTest();
        if (r135 != null) goto L203;
    L211:
        String r136 = r36.getClothesSizeAssistant().getLinkSchema();
        if (r136 == null) goto L215;
        r126 = r136;
    L215:
        SpecChartStruct r137 = r36.getClothesSizeAssistant().getSizeComponent();
        if (r137 == null) goto L219;
        List<ECUrlModel> r138 = r137.getImages();
        if (r138 == null) goto L219;
    L220:
        String r139 = cg.f.a(cg.f.b(1, r126, r138, r130), r41);
    L221:
        r70 = new cg.b(r310, r311, r312, r139, r36.getClothesSizeAssistant().getRecommendText());
    L219:
        r138 = CollectionsKt.emptyList();
        goto L220
    L203:
        if (r135.intValue() != 1) goto L211;
        ECSettingKeys.j.getClass();
        String r140 = ECSettingKeys.r0();
        SpecChartStruct r141 = r36.getClothesSizeAssistant().getSizeComponent();
        if (r141 == null) goto L208;
        List<ECUrlModel> r142 = r141.getImages();
        if (r142 == null) goto L208;
    L209:
        r139 = cg.f.a(cg.f.b(0, r140, r142, null), r41);
    L208:
        r142 = CollectionsKt.emptyList();
    L198:
        r312 = -2;
    L192:
        r311 = -2;
        goto L193
    L184:
        r128 = new JSONObject(r10);
        goto L185
    L181:
        r225 = false;
        goto L182
    L166:
        if (r38 == 102(0x66, float:1.43E-43)) goto L177;
        if (r38 != 201(0xc9, float:2.82E-43)) goto L170;
        r127 = "live";
        goto L179
    L170:
        if (r38 != 901(0x385, float:1.263E-42)) goto L172;
        r127 = "cart";
        goto L179
    L172:
        if (r38 == 1001) goto L174;
        r127 = "";
        goto L179
    L174:
        r127 = "exchange";
        goto L179
    L160:
        if (jg.g.a(r108) != true) goto L162;
        r109 = true;
        goto L163
    L156:
        r107 = th.a.g(r64, 2131914100) + ' ' + r36.getClothesSizeAssistant().getRecommendClothesSize();
        goto L157
    L150:
        if (r105.length() == 0) goto L153;
        r106 = false;
        goto L154
    L141:
        r69 = null;
        goto L142
    L137:
        r66 = null;
        goto L138
    L133:
        r62 = false;
        goto L134
    L289:
        String[] r143 = this.c;
        if (r143 != null) goto L292;
    L330:
        List<SpecInfo> r144 = r36.getSpecInfoList();
        if ((r144 instanceof Collection) == true) goto L333;
    L335:
        Iterator r145 = r144.iterator();
    L337:
        if (r145.hasNext() == false) goto L344;
        if (((SpecInfo) r145.next()).getSpecType() != 1) goto L341;
        boolean r146 = true;
    L342:
        if (r146 == true) goto L337;
        boolean r147 = false;
    L345:
        if (r147 == false) goto L351;
        s r148 = (s) CollectionsKt.firstOrNull(this.e);
        if (r148 == null) goto L351;
        s.a r149 = r148.j;
        if (r149 == null) goto L351;
        r149.a();
    L351:
        Iterator r150 = r36.getSpecInfoList().iterator();
        final int r151 = 0;
    L353:
        if (r150.hasNext() == false) goto L374;
        Object r152 = r150.next();
        int r153 = r151 + 1;
        if (r151 >= 0) goto L357;
        CollectionsKt.throwIndexOverflow();
    L357:
        final SpecInfo r154 = (SpecInfo) r152;
        ExtraAttribute r155 = r154.getExtraAttribute();
        if (r155 == null) goto L373;
        String r156 = r155.getMatchSpecId();
        if (r156 == null) goto L373;
        String r157 = a2.d(r156);
        if (r157 == null) goto L373;
        s r158 = (s) ListProtector.get(this.e, r151);
        Function0<Unit> r159 = new SpecItemOptimizeGroupLayout$setSpecItemGroupList$$inlined$forEachIndexed$lambda$1(r151, r154, this, r40);
        r158.getClass();
        Intrinsics.checkNotNullParameter(r157, "matchSpecId");
        Intrinsics.checkNotNullParameter(r159, "showEvent");
        s.c r160 = r158.e;
        if (r160 == null) goto L366;
        String r161 = r160.c;
    L368:
        if (Intrinsics.areEqual(r161, r157) == false) goto L373;
        GroupTitleOptimizeLayout r162 = r158.i;
        if (r162 == null) goto L372;
        r162.f.setVisibility(0);
    L372:
        r159.invoke();
        goto L373
    L366:
        r161 = null;
    L373:
        r151 = r153;
        goto L353
    L374:
        String[] r163 = this.c;
        if (r163 == null) goto L379;
        b r164 = this.g;
        if (r164 == null) goto L379;
        r164.a(r163, false);
    L379:
        this.d = true;
        return;
    L341:
        r146 = false;
    L344:
        r147 = true;
        goto L345
    L333:
        if (r144.isEmpty() == false) goto L335;
    L292:
        if (r143.length < r36.getSpecInfoList().size()) goto L294;
        boolean r165 = true;
    L295:
        if (r165 == true) goto L298;
        r143 = null;
    L298:
        if (r143 == null) goto L330;
        List<SpecInfo> r166 = r36.getSpecInfoList();
        if (r166 == null) goto L330;
        List<SpecInfo> r167 = r166;
        ArrayList r168 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r167, 10));
        Iterator r169 = r167.iterator();
        int r170 = 0;
    L303:
        if (r169.hasNext() == false) goto L330;
        Object r171 = r169.next();
        int r172 = r170 + 1;
        if (r170 >= 0) goto L307;
        CollectionsKt.throwIndexOverflow();
    L307:
        SpecInfo r173 = (SpecInfo) r171;
        String r174 = r143[r170];
        s r175 = (s) ListProtector.get(this.e, r170);
        int r176 = r175.d.size();
        int r177 = 0;
    L308:
        if (r177 >= r176) goto L329;
        s.c r178 = (s.c) ListProtector.get(r175.d, r177);
        if (TextUtils.equals(r174, r178.c) == false) goto L328;
        boolean r179 = r178.a;
        if (r179 == false) goto L328;
        if (r175.m == false) goto L329;
        if (r179 == false) goto L329;
        s.c r180 = r175.e;
        if (r180 == null) goto L322;
        Intrinsics.checkNotNull(r180);
        if (TextUtils.equals(r180.c, r178.c) == false) goto L322;
    L324:
        boolean r181 = true;
    L325:
        s.a r182 = r175.j;
        if (r182 == null) goto L328;
        Intrinsics.checkNotNull(r182);
        r182.d(r170, r175.e, r181);
    L322:
        if (r178.a == false) goto L324;
        r175.e = r178;
        r181 = true;
        r175.f = true;
        Intrinsics.checkNotNull(r178);
        r175.c(r178.c);
    L328:
        r177 = r177 + 1;
    L329:
        r168.add(Unit.INSTANCE);
        r170 = r172;
        goto L303
    L294:
        r165 = false;
        goto L295
    L18:
        if (r16.isEmpty() == true) goto L21;
        r17 = false;
        goto L22
    L425:
        return;
    L426:
        return;
    L7:
        if (r11.isEmpty() == true) goto L10;
        r12 = false;
        goto L11
    }
}
