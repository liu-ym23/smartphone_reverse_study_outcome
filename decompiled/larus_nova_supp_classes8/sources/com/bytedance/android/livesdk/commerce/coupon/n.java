package com.bytedance.android.livesdk.commerce.coupon;

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
public final class n {
    public final ImageView a;
    public final long b;
    public final View c;
    public final TextView d;
    public final TextView e;
    public final LiveAlignTextView f;
    public final Typeface g;

    public static final class a {
    }

    static {
    }

    public static String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
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
        r1.setText(r9.typeString);
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

    public n(long r4, FrameLayout r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        r6.removeAllViews();
        long r5 = r4 % ((long) 10);
        if (r5 != 1) goto L6;
        this.c = LayoutInflater.from(r6.getContext()).inflate(2131568055, r6);
        this.b = 1;
    L11:
        View r7 = this.c;
        LiveAlignTextView r8 = null;
        if (r7 == null) goto L14;
        ImageView r9 = (ImageView) r7.findViewById(2131375091);
    L15:
        this.a = r9;
        View r10 = this.c;
        if (r10 == null) goto L18;
        TextView r11 = (TextView) r10.findViewById(2131368104);
    L19:
        this.d = r11;
        View r12 = this.c;
        if (r12 == null) goto L22;
        TextView r13 = (TextView) r12.findViewById(2131368118);
    L23:
        this.e = r13;
        View r14 = this.c;
        if (r14 == null) goto L26;
        r8 = (LiveAlignTextView) r14.findViewById(2131368072);
    L26:
        this.f = r8;
        this.g = Typeface.DEFAULT_BOLD;
        return;
    L22:
        r13 = null;
        goto L23
    L18:
        r11 = null;
        goto L19
    L14:
        r9 = null;
        goto L15
    L6:
        if (r5 != 2) goto L9;
        this.c = LayoutInflater.from(r6.getContext()).inflate(2131568057, r6);
        this.b = 2;
        goto L11
    L9:
        if (r5 != 3) goto L11;
        this.c = LayoutInflater.from(r6.getContext()).inflate(2131568059, r6);
        this.b = 3;
        goto L11
    }
}
