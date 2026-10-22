package com.bytedance.android.anniex.monitor;

import com.bytedance.android.monitorV2.entity.UnifyErrorDomain;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;

    public b() {
        this.c = "init";
        this.d = "new";
        this.e = "begin";
        this.f = "unknown";
        this.g = UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain();
    }
}
