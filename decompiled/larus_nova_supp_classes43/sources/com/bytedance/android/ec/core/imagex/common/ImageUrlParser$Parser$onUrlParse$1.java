package com.bytedance.android.ec.core.imagex.common;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ImageUrlParser$Parser$onUrlParse$1 implements com.bytedance.android.shopping.api.image.t {
    public final String a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final String e;
    public final Lazy f;
    public final /* synthetic */ ImageUrlParser.c g;

    public final String c() {
        return this.e;
    }

    public final String getDomain() {
        return this.b;
    }

    public final String l() {
        return this.c;
    }

    public ImageUrlParser$Parser$onUrlParse$1(ImageUrlParser.c r10) {
        this.g = r10;
        ImageUrlParser r0 = r10.j;
        this.a = r0.x;
        String r1 = r0.e;
        this.b = r0.f;
        this.c = r0.m;
        this.d = r0.n;
        Integer r11 = r0.j;
        if (r11 == null) goto L5;
        r11.intValue();
    L5:
        Integer r12 = r10.j.k;
        if (r12 == null) goto L8;
        r12.intValue();
    L8:
        this.e = r10.j.i;
        this.f = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ImageUrlParser$Parser$onUrlParse$1$domainAfterContent$2(this));
    }
}
