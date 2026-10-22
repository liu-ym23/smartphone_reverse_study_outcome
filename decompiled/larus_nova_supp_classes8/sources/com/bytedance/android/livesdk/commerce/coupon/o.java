package com.bytedance.android.livesdk.commerce.coupon;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o {
    public final ImageView a;
    public final Context b;
    public final long c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final LiveCouponPriceView g;
    public final TextView h;

    public static final class a {
    }

    static {
    }

    public static String a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        if (r4.length() > 2) goto L8;
        return r4;
    L8:
        if (StringsKt.contains$default(r4, '.', false, 2, null) == true) goto L11;
        return r4;
    L11:
        if ('0' == r4.charAt(r4.length() - 1)) goto L13;
        return r4;
    L13:
        return r4.substring(0, r4.length() - 2);
    }

    public final void b(d r9) {
        Long r0 = Long.valueOf(r9.periodType);
        if (r0 != null) goto L6;
    L10:
        if (r0 != null) goto L13;
    L17:
        TextView r1 = this.e;
        if (r1 == null) goto L25;
        r1.setText(s1.C(2131918848, new Object[]{r9.startTime, r9.expireTime}));
        return;
    L25:
        return;
    L13:
        if (r0.longValue() != 2) goto L17;
        TextView r2 = this.e;
        if (r2 == null) goto L23;
        r2.setText(s1.C(2131918943, new Object[]{Long.valueOf(r9.validPeriod)}));
        return;
    L23:
        return;
    L6:
        if (r0.longValue() != 1) goto L10;
        TextView r3 = this.e;
        if (r3 == null) goto L21;
        r3.setText(s1.C(2131918945, new Object[]{r9.expireTime}));
        return;
    }

    public o(long r7, FrameLayout r9) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        this.b = r9.getContext();
        r9.removeAllViews();
        long r8 = r7 % ((long) 10);
        TextView r0 = null;
        if (r8 != 1) goto L10;
        View r10 = LayoutInflater.from(r9.getContext()).inflate(2131568056, r9);
        this.d = r10;
        if (r10 == null) goto L7;
        TextView r11 = (TextView) r10.findViewById(2131368101);
    L8:
        this.h = r11;
        this.c = 1;
    L23:
        View r12 = this.d;
        if (r12 == null) goto L26;
        ImageView r13 = (ImageView) r12.findViewById(2131375091);
    L27:
        this.a = r13;
        View r14 = this.d;
        if (r14 == null) goto L30;
        TextView r15 = (TextView) r14.findViewById(2131368118);
    L31:
        this.e = r15;
        View r16 = this.d;
        if (r16 == null) goto L34;
        r0 = (TextView) r16.findViewById(2131391975);
    L34:
        this.f = r0;
        Typeface r17 = Typeface.DEFAULT_BOLD;
        return;
    L30:
        r15 = null;
        goto L31
    L26:
        r13 = null;
        goto L27
    L7:
        r11 = null;
        goto L8
    L10:
        if (r8 != 2) goto L17;
        View r18 = LayoutInflater.from(r9.getContext()).inflate(2131568058, r9);
        this.d = r18;
        if (r18 == null) goto L14;
        LiveCouponPriceView r19 = (LiveCouponPriceView) r18.findViewById(2131368100);
    L15:
        this.g = r19;
        this.c = 2;
        goto L23
    L14:
        r19 = null;
        goto L15
    L17:
        if (r8 != 3) goto L23;
        View r20 = LayoutInflater.from(r9.getContext()).inflate(2131568058, r9);
        this.d = r20;
        if (r20 == null) goto L21;
        LiveCouponPriceView r21 = (LiveCouponPriceView) r20.findViewById(2131368100);
    L22:
        this.g = r21;
        this.c = 3;
        goto L23
    L21:
        r21 = null;
        goto L22
    }
}
