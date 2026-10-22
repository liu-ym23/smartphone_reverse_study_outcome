package com.lynx.animax.loader;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AnimaXLoaderResponse<T> {
    public final Type a;
    public final T b;

    public static final enum Type extends Enum<Type> {
        public static final Type BITMAP = null;
        public static final Type BYTE_ARRAY = null;
        public static final Type ERROR = null;
        public static final Type STRING_FILE_PATH = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("STRING_FILE_PATH", 0);
            STRING_FILE_PATH = r0;
            Type r1 = new Type("BYTE_ARRAY", 1);
            BYTE_ARRAY = r1;
            Type r3 = new Type("BITMAP", 2);
            BITMAP = r3;
            Type r5 = new Type("ERROR", 3);
            ERROR = r5;
            a = new Type[]{r0, r1, r3, r5};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public Type getType() {
        return this.a;
    }

    public static AnimaXLoaderResponse<byte[]> a(byte[] r2) {
        return new AnimaXLoaderResponse(Type.BYTE_ARRAY, r2);
    }

    public static AnimaXLoaderResponse<Throwable> b(Throwable r2) {
        return new AnimaXLoaderResponse(Type.ERROR, r2);
    }

    public AnimaXLoaderResponse(Type r1, T r2) {
        this.a = r1;
        this.b = r2;
    }
}
