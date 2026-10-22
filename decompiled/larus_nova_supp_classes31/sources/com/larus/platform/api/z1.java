package com.larus.platform.api;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface z1 {
    public static final a a = null;

    public static final class a implements z1 {
        public static final /* synthetic */ a b = null;
        public static final Lazy<z1> c = null;

        public a() {
        }

        static {
            b = new a();
            c = LazyKt.lazy(new y1());
        }

        @Override // com.larus.platform.api.z1
        public final boolean isLogin() {
            z1 r0 = (z1) c.getValue();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isLogin();
        }
    }

    static {
        a = a.b;
    }

    boolean isLogin();
}
