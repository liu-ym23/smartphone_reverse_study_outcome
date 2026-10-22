package com.larksuite.component.card.component.text;

import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.util.TypedValue;
import com.larksuite.component.ui.toast.LKUIToast;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public int a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public Layout.Alignment f;
    public TextUtils.TruncateAt g;
    public float h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        return (((((((((((((((((((((this.a * 31) + (this.c ? 1 : 0)) * 31) + this.d) * 31) + this.f.ordinal()) * 31) + this.e) * 31) + this.g.ordinal()) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + Float.floatToIntBits(this.h)) * 31) + (this.m ? 1 : 0);
    }

    public d() {
        this.a = LKUIToast.DURATION_MAX;
        this.b = LKUIToast.DURATION_MAX;
        Resources r0 = com.larksuite.framework.utils.b.a.getResources();
        this.d = (int) TypedValue.applyDimension(2, 14.0f, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
        this.f = Layout.Alignment.ALIGN_NORMAL;
        this.g = TextUtils.TruncateAt.END;
        Resources r1 = com.larksuite.framework.utils.b.a.getResources();
        this.h = TypedValue.applyDimension(1, 4.0f, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof d) == true) goto L5;
        return false;
    L5:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L8;
        return false;
    L8:
        if (this.c == r6.c) goto L10;
        return false;
    L10:
        if (this.e == r6.e) goto L12;
        return false;
    L12:
        if (this.f == r6.f) goto L14;
        return false;
    L14:
        if (this.g == r6.g) goto L16;
        return false;
    L16:
        if (this.h != r6.h) goto L18;
        boolean r0 = true;
    L19:
        if (r0 == true) goto L21;
        return false;
    L21:
        if (this.i == r6.i) goto L23;
        return false;
    L23:
        if (this.j == r6.j) goto L25;
        return false;
    L25:
        if (this.k == r6.k) goto L27;
        return false;
    L27:
        if (this.l == r6.l) goto L29;
        return false;
    L29:
        if (this.d == r6.d) goto L31;
        return false;
    L31:
        if (this.m != r6.m) goto L45;
        return true;
    L45:
        return false;
    L18:
        r0 = false;
        goto L19
    }
}
