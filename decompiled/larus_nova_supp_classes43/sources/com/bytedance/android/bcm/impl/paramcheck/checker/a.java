package com.bytedance.android.bcm.impl.paramcheck.checker;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.android.bcm.impl.paramcheck.checker.a$a, reason: collision with other inner class name */
    public static final class C0106a extends a {
        public final String a;

        public C0106a(String r1) {
            this.a = r1;
        }
    }

    public static class b extends a {
        public final String a;
        public final BcmCheckErrorType b;
        public final Map<String, Object> c;

        public b(String r1, BcmCheckErrorType r10, Map<String, ? extends Object> r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public a() {
    }
}
