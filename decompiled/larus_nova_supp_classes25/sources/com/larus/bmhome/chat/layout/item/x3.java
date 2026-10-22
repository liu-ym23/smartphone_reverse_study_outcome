package com.larus.bmhome.chat.layout.item;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x3 extends LinearLayout {
    public RecyclerView a;
    public boolean b;
    public boolean c;
    public int d;
    public final LinearLayout e;
    public Function0<Unit> f;
    public Function0<Unit> g;

    public final boolean getHasReport() {
        return this.c;
    }

    public x3(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.b = true;
        RecyclerView r1 = this.a;
        if (r1 == null) goto L5;
        int r2 = r1.getMeasuredHeight();
    L6:
        this.d = r2;
        setOrientation(1);
        View r7 = LayoutInflater.from(r6).inflate(2131562646, null);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r8 = (LinearLayout) r7;
        this.e = r8;
        Resources r3 = AppHost.a.getApplication().getResources();
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - i5.l0(), -2);
        r0.setMargins(i5.h(), i5.h(), i5.h(), 0);
        if (r8 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r8.findViewById(2131385370);
    L9:
        setPadding(0, 0, i5.b(), i5.h());
        if (r8 == null) goto L12;
        r8.setLayoutParams(r0);
    L12:
        if (r8 == null) goto L14;
        r8.setOnClickListener(new v3(this));
    L14:
        addView(r8);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void a(boolean r5) {
        if (this.d != 0) goto L9;
        RecyclerView r0 = this.a;
        if (r0 == null) goto L7;
        int r1 = r0.getMeasuredHeight();
    L8:
        this.d = r1;
        goto L9
    L7:
        r1 = 0;
    L9:
        RecyclerView r2 = this.a;
        if (r2 != null) goto L12;
        return;
    L12:
        if (this.b == false) goto L14;
        int r3 = 0;
    L15:
        ValueAnimator r4 = ValueAnimator.ofInt(new int[]{r2.getHeight(), r3});
        r4.addUpdateListener(new w3(this));
        r4.setDuration(330);
        r4.start();
        r4.setupEndValues();
        this.b = true ^ this.b;
        if (r5 == true) goto L22;
        Function0<Unit> r6 = this.f;
        if (r6 == null) goto L23;
        r6.invoke();
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r3 = this.d;
        goto L15
    }

    public final void setExpanded(boolean r1) {
        this.b = r1;
    }

    public final void setHasReport(boolean r1) {
        this.c = r1;
    }

    public final void setOnClickMob(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.f = r2;
    }

    public final void setOnShowMob(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.g = r2;
    }

    public final void setRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        r3.setTag("search_list_recycler_view");
        this.a = r3;
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        r1.removeView(r3);
    L8:
        LinearLayout r2 = this.e;
        if (r2 == null) goto L12;
        r2.addView(r3);
    L12:
        if (this.c == true) goto L18;
        Function0<Unit> r4 = this.g;
        if (r4 == null) goto L16;
        r4.invoke();
    L16:
        this.c = true;
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
