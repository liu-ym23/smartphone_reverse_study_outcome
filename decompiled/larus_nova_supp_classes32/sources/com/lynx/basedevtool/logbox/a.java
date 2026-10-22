package com.lynx.basedevtool.logbox;

import a5a.c;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final Map<String, InterfaceC0031a> a;

    /* JADX INFO: renamed from: com.lynx.basedevtool.logbox.a$a, reason: collision with other inner class name */
    public interface InterfaceC0031a {
        void a(Context r1, c r2);
    }

    public static class b {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new HashMap();
    }
}
