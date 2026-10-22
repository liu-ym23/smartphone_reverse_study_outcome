package com.bytedance.android.annie.debug.ui;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public int a;
    public Uri b;
    public String c;
    public String d;

    public static final class a {
    }

    static {
    }

    public g() {
        this.b = UriProtector.parse("");
        this.c = "";
        this.d = "";
    }

    public final int getType() {
        return this.a;
    }
}
