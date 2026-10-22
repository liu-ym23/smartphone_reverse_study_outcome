package com.google.crypto.tink.shaded.protobuf;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f4937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Charset f4938b = null;
    static final Charset c = null;
    public static final byte[] d = null;
    public static final ByteBuffer e = null;
    public static final k f = null;

    public interface a extends i<Boolean> {
        a a(int r1);

        @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
        /* synthetic */ default i<Boolean> e(int r1) {
            return a(r1);
        }
    }

    public interface b extends i<Double> {
        b a(int r1);

        @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
        /* synthetic */ default i<Double> e(int r1) {
            return a(r1);
        }
    }

    public interface c {
        int getNumber();
    }

    public interface d<T extends c> {
        T b(int r1);
    }

    public interface e {
        boolean a(int r1);
    }

    public interface f extends i<Float> {
        f a(int r1);

        @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
        /* synthetic */ default i<Float> e(int r1) {
            return a(r1);
        }
    }

    public interface g extends i<Integer> {
        g a(int r1);

        @Override // 
        /* synthetic */ default i<Integer> e(int r1) {
            return a(r1);
        }
    }

    public interface h extends i<Long> {
        h a(int r1);

        @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
        /* synthetic */ default i<Long> e(int r1) {
            return a(r1);
        }
    }

    public interface i<E> extends List<E>, RandomAccess {
        boolean a();

        void b();

        i<E> e(int r1);
    }

    static {
        f4937a = Charset.forName("US-ASCII");
        f4938b = Charset.forName(RpcUtils.CHARSET_UTF8);
        c = Charset.forName("ISO-8859-1");
        byte[] r0 = new byte[0];
        d = r0;
        e = ByteBuffer.wrap(r0);
        f = k.a(r0);
    }

    static int a(int r2, byte[] r3, int r4, int r5) {
        int r0 = r4;
    L4:
        if (r0 >= (r4 + r5)) goto L6;
        r2 = (r2 * 31) + r3[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        return r2;
    }

    public static int a(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    public static int a(boolean r0) {
        if (r0 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    static int a(byte[] r0, int r1, int r2) {
        int r3 = a(r2, r0, r1, r2);
        if (r3 != 0) goto L6;
        return 1;
    L6:
        return r3;
    }

    static <T> T a(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    static Object a(Object r2, Object r3) {
        return ((at) ZeusTransformUtils.preCheckCast(r2, at.class, "com.obric.memorydata.plugin")).toBuilder().a((at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.memorydata.plugin")).b();
    }

    static <T> T a(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    public static boolean a(byte[] r0) {
        return Utf8.a(r0);
    }

    public static String b(byte[] r2) {
        return new String(r2, f4938b);
    }

    public static int c(byte[] r2) {
        return a(r2, 0, r2.length);
    }
}
