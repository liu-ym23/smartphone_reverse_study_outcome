package com.squareup.javapoet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.lang.model.type.ArrayType;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends x {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f14957x = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final x f14958w;

    public c(x r5) {
        super(null, new ArrayList());
        com.bytedance.android.anniex.base.service.f.s(r5, "rawType == null", new Object[0]);
        this.f14958w = r5;
    }

    public static c q(ArrayType r5, LinkedHashMap r10) {
        return new c(x.h(r5.getComponentType(), r10));
    }

    @Override // com.squareup.javapoet.x
    public final k c(k r5) {
        return n(r5, false);
    }

    public final k n(k r5, boolean r10) {
        p(r5);
        return o(r5, r10);
    }

    public final k o(k r5, boolean r10) {
        if (i() == false) goto L5;
        r5.e(" ");
        d(r5);
    L5:
        x r11 = this.f14958w;
        String r12 = "[]";
        if (x.a(r11) != null) goto L11;
        if (r10 == false) goto L9;
        r12 = "...";
    L9:
        r5.e(r12);
        return r5;
    L11:
        r5.e("[]");
        return x.a(r11).o(r5, r10);
    }

    public final k p(k r5) {
        x r10 = this.f14958w;
        if (x.a(r10) == null) goto L7;
        return x.a(r10).p(r5);
    L7:
        return r10.c(r5);
    }
}
