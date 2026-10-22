package com.larksuite.component.dynamicresources;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static volatile C0033a a;

    /* JADX INFO: renamed from: com.larksuite.component.dynamicresources.a$a, reason: collision with other inner class name */
    public class C0033a {
        public final Map<String, Long> a;

        public C0033a() {
            this.a = new ConcurrentHashMap();
        }
    }

    static {
        a = new C0033a();
    }
}
