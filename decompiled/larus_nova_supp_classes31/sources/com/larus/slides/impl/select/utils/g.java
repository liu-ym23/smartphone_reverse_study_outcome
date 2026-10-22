package com.larus.slides.impl.select.utils;

import com.larus.slides.impl.select.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements Function1<Boolean, Unit> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1<a, Unit> c;

    public final Object invoke(Object r3) {
        if (((Boolean) r3).booleanValue() == false) goto L6;
        Lazy r4 = ImageSaveUtils.a;
        ImageSaveUtils.a(this.a, this.b, this.c);
    L6:
        return Unit.INSTANCE;
    }

    public g(String r1, String r2, m r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
