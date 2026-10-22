package com.lynx.tasm;

import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s0 {
    public final String a;
    public byte[] b;
    public ByteBuffer c;
    public TemplateBundle d;
    public TemplateData e;
    public final TemplateData f;
    public final LynxLoadMode g;
    public final int h;
    public final Map<String, String> i;

    public static class a {
        public String a;
        public byte[] b;
        public TemplateBundle c;
        public TemplateData d;
        public TemplateData e;
        public LynxLoadMode f;
        public int g;
        public ByteBuffer h;
        public Map<String, String> i;

        public final s0 b() {
            return new s0(this.a, this.b, this.h, this.c, this.d, this.e, this.f, this.g, this.i);
        }

        public a() {
            this.g = 0;
        }

        public final void a(LynxLoadOption r2) {
            int r0 = this.g;
            this.g = r2.id() | r0;
        }
    }

    public s0(String r1, byte[] r2, ByteBuffer r3, TemplateBundle r4, TemplateData r5, TemplateData r6, LynxLoadMode r7, int r8, Map r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
