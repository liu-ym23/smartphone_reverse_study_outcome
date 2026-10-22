package com.larksuite.component.universe_design.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final Context a;
    public UDTabLayout b;
    public CharSequence c;
    public Drawable d;
    public View e;
    public int f;

    public static final class a {
    }

    static {
    }

    public final TextView a() {
        return (TextView) this.e.findViewById(2131391821);
    }

    public final void c() {
        ImageView r0 = (ImageView) this.e.findViewById(2131391820);
        if (r0 != null) goto L5;
        return;
    L5:
        Drawable r1 = this.d;
        if (r1 != null) goto L8;
        r0.setVisibility(8);
    L9:
        UDTabLayout r2 = this.b;
        if (r2 == null) goto L13;
        r2.invaliIndicator$universe_ui_tab_release();
        return;
    L13:
        return;
    L8:
        r0.setImageDrawable(r1);
        r0.setVisibility(0);
        goto L9
    }

    public final void d() {
        TextView r0 = a();
        if (r0 != null) goto L5;
        return;
    L5:
        TextView r1 = (TextView) this.e.findViewById(2131391822);
        CharSequence r2 = this.c;
        if (r2 != null) goto L10;
        r0.setVisibility(8);
        if (r1 == null) goto L15;
        r1.setVisibility(8);
    L15:
        UDTabLayout r3 = this.b;
        if (r3 == null) goto L19;
        r3.invaliIndicator$universe_ui_tab_release();
        return;
    L19:
        return;
    L10:
        r0.setText(r2);
        r0.setVisibility(0);
        if (r1 == null) goto L13;
        r1.setText(this.c);
    L13:
        if (r1 == null) goto L15;
        r1.setVisibility(4);
        goto L15
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        f r0 = new f(r2);
        r0.setTab$universe_ui_tab_release(this);
        this.e = r0;
        this.f = -1;
    }

    public final void b(CharSequence r1) {
        this.c = r1;
        d();
    }
}
