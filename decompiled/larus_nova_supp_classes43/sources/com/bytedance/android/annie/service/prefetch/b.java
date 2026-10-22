package com.bytedance.android.annie.service.prefetch;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends AbsAnnieGeckoResLoader {
    public final Context c;
    public final String d;
    public final String e;

    public b() {
        this(0);
    }

    @Override // com.bytedance.android.annie.service.prefetch.AbsAnnieGeckoResLoader, com.bytedance.android.annie.service.prefetch.n
    public Context getContext() {
        return this.c;
    }

    public b(int r10) {
        Application r11 = com.bytedance.android.annie.ng.g.a();
        String r0 = com.bytedance.android.annie.resource.m.a(null);
        String r1 = com.bytedance.android.annie.resource.m.c();
        this.c = r11;
        this.d = r0;
        this.e = r1;
    }
}
