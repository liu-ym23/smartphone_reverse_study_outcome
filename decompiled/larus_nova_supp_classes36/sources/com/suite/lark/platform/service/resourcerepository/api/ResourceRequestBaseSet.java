package com.suite.lark.platform.service.resourcerepository.api;

import java.util.HashMap;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ResourceRequestBaseSet {
    public final Type a;
    public final String b;
    public final String c;
    public String d;
    public ByteString e;
    public String f;
    public final String g;
    public a h;

    public static final enum Type extends Enum<Type> {
        public static final Type AVATAR = null;
        public static final Type BASE = null;
        public static final /* synthetic */ Type[] a = null;
        private int value;

        static {
            Type r0 = new Type("BASE", 0, 0);
            BASE = r0;
            Type r1 = new Type("AVATAR", 1, 1);
            AVATAR = r1;
            a = new Type[]{r0, r1};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return BASE;
        L8:
            return AVATAR;
        L10:
            return BASE;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type valueOf(int r0) {
            return forNumber(r0);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class a {
        public int a;
        public int b;
        public String c;
        public long d;
        public String e;
        public Map<String, String> f;
        public Map<String, String> g;

        public a() {
            this.a = 0;
            this.b = 1;
            this.c = "";
            this.d = 0;
            this.e = "";
            this.f = new HashMap();
            this.g = new HashMap();
        }
    }

    public ResourceRequestBaseSet() {
        throw null;
    }

    public Type getType() {
        return this.a;
    }

    public ResourceRequestBaseSet(String r1, String r2, String r3, String r4) {
        this.b = r1;
        this.c = r2;
        this.f = r3;
        this.g = r4;
        this.a = Type.BASE;
    }
}
