package com.larksuite.component.ui.tag;

import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final f a;
    public final f b;
    public final b c;
    public final f d;
    public final f e;
    public final b f;
    public final b g;
    public final f h;
    public final f i;
    public final b j;
    public final f k;
    public final f l;
    public final f m;
    public final f n;
    public final f o;
    public final b p;
    public final f q;
    public final f r;
    public final f s;
    public final f t;
    public final f u;
    public final b v;
    public final f w;

    public a() {
        this.a = TagProviderKt.i;
        this.b = TagProviderKt.x;
        this.c = TagProviderKt.j;
        this.d = TagProviderKt.k;
        this.e = TagProviderKt.l;
        this.f = TagProviderKt.n;
        this.g = TagProviderKt.m;
        this.h = TagProviderKt.b;
        this.i = TagProviderKt.a;
        this.j = TagProviderKt.o;
        this.k = TagProviderKt.p;
        this.l = TagProviderKt.e;
        f r0 = TagProviderKt.d;
        this.m = r0;
        this.n = TagProviderKt.h;
        this.o = TagProviderKt.t;
        this.p = TagProviderKt.v;
        this.q = TagProviderKt.g;
        this.r = TagProviderKt.f;
        this.s = TagProviderKt.r;
        this.t = r0;
        this.u = TagProviderKt.c;
        this.v = TagProviderKt.u;
        this.w = TagProviderKt.w;
    }

    public final f a(String r3) {
        f r0 = TagProviderKt.a;
        int r1 = f.g;
        f.a r2 = new f.a();
        r2.a = 65573;
        r2.b = 2;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r3 = UIHelper.getString(2131891717);
    L11:
        r2.d = r3;
        r2.e = 2131099817;
        r2.g = 2131099818;
        return r2.a();
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }
}
