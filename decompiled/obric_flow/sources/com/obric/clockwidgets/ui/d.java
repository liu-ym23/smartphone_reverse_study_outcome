package com.obric.clockwidgets.ui;

import android.content.Context;
import android.view.View;
import com.obric.clockwidgets.R$id;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.obric.clockwidgets.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gu.f f11303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f11304c;
    public View d;

    public d(Context r5, gu.f r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "root");
        this.f11302a = r5;
        this.f11303b = r10;
    }

    public final void a(boolean r10) {
        View r5 = this.f11304c;
        gu.f r11 = this.f11303b;
        if (r5 != null) goto L5;
        r5 = r11.findViewById(R$id.widget_real_content);
    L5:
        this.f11304c = r5;
        View r12 = this.d;
        if (r12 != null) goto L8;
        r12 = r11.findViewById(R$id.widget_tip_view);
    L8:
        this.d = r12;
        View r13 = this.f11304c;
        if (r13 == null) goto L51;
        if (r12 == null) goto L52;
        int r14 = r13.getVisibility();
        boolean r15 = true;
        int r16 = 0;
        if (r14 != 0) goto L15;
        boolean r17 = true;
    L16:
        View r18 = this.d;
        if (r18 != null) goto L19;
    L21:
        r15 = false;
    L22:
        if (r10 == true) goto L26;
        View r19 = this.d;
        if (r19 == null) goto L29;
        final int r20 = 0;
        r19.setOnClickListener(new c(this, r20));
    L29:
        if (r10 == false) goto L33;
        if (r17 == false) goto L33;
        if (r15 == true) goto L33;
        return;
    L33:
        if (r10 == true) goto L37;
        if (r17 == true) goto L37;
        if (r15 == false) goto L37;
        return;
    L37:
        View r21 = this.f11304c;
        if (r21 == null) goto L44;
        if (r10 == false) goto L42;
        int r22 = 0;
    L43:
        r21.setVisibility(r22);
        goto L44
    L42:
        r22 = 8;
    L44:
        View r23 = this.d;
        if (r23 == null) goto L53;
        if (r10 == false) goto L49;
        r16 = 8;
    L49:
        r23.setVisibility(r16);
        return;
    L53:
        return;
    L26:
        View r24 = this.f11304c;
        if (r24 == null) goto L29;
        final int r25 = 1;
        r24.setOnClickListener(new c(this, r25));
        goto L29
    L19:
        if (r18.getVisibility() != 0) goto L21;
    L15:
        r17 = false;
        goto L16
    L52:
        return;
    }
}
