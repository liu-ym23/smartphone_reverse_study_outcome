package com.bytedance.android.ec.common.impl.sku.utils;

import android.util.LruCache;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final a a = null;

    public static final class a extends LruCache<String, l> {
        public a() {
            super(10);
        }
    }

    static {
        a = new a();
    }
}
