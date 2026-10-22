package com.larus.common_ui.view;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.larus.common_res.common_ui.databinding.LarusItemSuggestedActionBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class v implements Function1 {
    public final /* synthetic */ SuggestedActionBar a;
    public final /* synthetic */ LarusItemSuggestedActionBinding b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;

    public /* synthetic */ v(SuggestedActionBar r1, LarusItemSuggestedActionBinding r2, int r3, int r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r10) {
        SuggestedActionBar r0 = this.a;
        LarusItemSuggestedActionBinding r1 = this.b;
        int r2 = this.c;
        int r3 = this.d;
        String r4 = this.e;
        int r5 = SuggestedActionBar.t;
        Intrinsics.checkNotNullParameter((LinearLayout) r10, "it");
        boolean r6 = false;
        if (r0.d == false) goto L28;
        ViewParent r11 = r1.a.getParent();
        Integer r7 = null;
        if ((r11 instanceof ViewGroup) == false) goto L7;
        ViewGroup r12 = (ViewGroup) r11;
    L8:
        if (r12 == null) goto L10;
        Object r8 = r12.getTag();
    L12:
        if ((r8 instanceof Integer) == false) goto L14;
        Integer r9 = (Integer) r8;
    L15:
        if (r9 == null) goto L17;
        r2 = r9.intValue();
    L17:
        if (r12 == null) goto L25;
        Integer r13 = Integer.valueOf(r12.indexOfChild(r1.a));
        if (r13.intValue() < 0) goto L21;
        r6 = true;
    L21:
        if (r6 == false) goto L23;
        r7 = r13;
    L23:
        if (r7 == null) goto L25;
        r3 = r7.intValue();
    L25:
        SuggestedActionBar$a r14 = r0.q;
        if (r14 == null) goto L30;
        r14.a(r4, r2, r3, r0.i.contains(r4));
    L30:
        return Unit.INSTANCE;
    L14:
        r9 = null;
        goto L15
    L10:
        r8 = null;
        goto L12
    L7:
        r12 = null;
        goto L8
    L28:
        t19.s.a.g(r0.getContext(), 2131905685, false);
        goto L30
    }
}
