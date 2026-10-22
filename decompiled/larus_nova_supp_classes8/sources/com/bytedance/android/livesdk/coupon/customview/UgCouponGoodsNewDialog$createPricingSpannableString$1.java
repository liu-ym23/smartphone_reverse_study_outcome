package com.bytedance.android.livesdk.coupon.customview;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"indexOfRange", "Lkotlin/Pair;", "", "", "that", "invoke"}, k = 3, mv = {1, 4, 3})
public final class UgCouponGoodsNewDialog$createPricingSpannableString$1 extends Lambda implements Function2<String, String, Pair<? extends Integer, ? extends Integer>> {
    public static final UgCouponGoodsNewDialog$createPricingSpannableString$1 INSTANCE = null;

    static {
        INSTANCE = new UgCouponGoodsNewDialog$createPricingSpannableString$1();
    }

    public UgCouponGoodsNewDialog$createPricingSpannableString$1() {
        super(2);
    }

    public final Pair<Integer, Integer> invoke(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$indexOfRange");
        Intrinsics.checkNotNullParameter(r9, "that");
        int r0 = StringsKt.indexOf$default(r8, r9, 0, false, 6, null);
        int r1 = r8.length();
        if (r0 < 0) goto L15;
        if (r1 <= r0) goto L12;
        int r10 = r8.length();
        int r2 = (r9.length() + r0) - 1;
        if (r2 < 0) goto L14;
        if (r10 > r2) goto L11;
        return null;
    L11:
        return TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r0 + r9.length()));
    L14:
        return null;
    L12:
        return null;
    L15:
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (String) r2);
    }
}
