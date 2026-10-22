package com.lynx.jsbridge;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class f {
    public String a;
    public Class<? extends LynxModule> b;
    public Object c;

    public f() {
    }

    public final String toString() {
        return "[" + this.b.getSimpleName() + " - " + this.a + "]";
    }

    public Class<? extends LynxModule> a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public Object c() {
        return this.c;
    }
}
