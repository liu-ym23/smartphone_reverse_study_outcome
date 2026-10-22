package com.larksuite.framework.apiplugin.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKPluginHandleResult extends LKBasePluginResult {
    public static final LKPluginHandleResult g = null;

    public static class a extends LKBasePluginResult.b<a> {
        public boolean e;

        public a() {
            this.e = false;
        }
    }

    static {
        g = new LKPluginHandleResult(new a());
    }

    public LKPluginHandleResult(a r7) {
        super(r7.e, r7.a, r7.b, r7.c, r7.d);
    }
}
