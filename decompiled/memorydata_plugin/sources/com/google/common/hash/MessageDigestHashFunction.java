package com.google.common.hash;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class MessageDigestHashFunction extends b implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.MessageDigestHashFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        private SerializedForm(String r1, int r2, String r3) {
            this.algorithmName = r1;
            this.bytes = r2;
            this.toString = r3;
        }

        /* synthetic */ SerializedForm(String r1, int r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }
    }

    private static final class a extends com.google.common.hash.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MessageDigest f4717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4718b;
        private boolean c;

        private a(MessageDigest r1, int r2) {
            this.f4717a = r1;
            this.f4718b = r2;
        }

        /* synthetic */ a(MessageDigest r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private void b() {
            n.b(!this.c, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.g
        public HashCode a() {
            b();
            this.c = true;
            if (this.f4718b != this.f4717a.getDigestLength()) goto L6;
            return HashCode.fromBytesNoCopy(this.f4717a.digest());
        L6:
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.f4717a.digest(), this.f4718b));
        }

        @Override // com.google.common.hash.a
        public void update(byte r1) {
            b();
            this.f4717a.update(r1);
        }

        @Override // com.google.common.hash.a
        public void update(ByteBuffer r1) {
            b();
            this.f4717a.update(r1);
        }

        @Override // com.google.common.hash.a
        public void update(byte[] r1, int r2, int r3) {
            b();
            this.f4717a.update(r1, r2, r3);
        }
    }

    MessageDigestHashFunction(String r3, int r4, String r5) {
        this.toString = (String) ZeusTransformUtils.preCheckCast(n.a(r5), String.class, "com.obric.memorydata.plugin");
        MessageDigest r6 = getMessageDigest(r3);
        this.prototype = r6;
        int r7 = r6.getDigestLength();
        if (r4 < 4) goto L6;
        if (r4 > r7) goto L6;
        boolean r0 = true;
    L7:
        n.a(r0, "bytes (%s) must be >= 4 and < %s", r4, r7);
        this.bytes = r4;
        this.supportsClone = supportsClone(r6);
        return;
    L6:
        r0 = false;
        goto L7
    }

    MessageDigestHashFunction(String r3, String r4) {
        MessageDigest r5 = getMessageDigest(r3);
        this.prototype = r5;
        this.bytes = r5.getDigestLength();
        this.toString = (String) ZeusTransformUtils.preCheckCast(n.a(r4), String.class, "com.obric.memorydata.plugin");
        this.supportsClone = supportsClone(r5);
    }

    private static MessageDigest getMessageDigest(String r1) {
        return MessageDigest.getInstance(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private static boolean supportsClone(MessageDigest r0) {
        r0.clone();     // Catch: CloneNotSupportedException -> L5
        return true;
    L5:
        return false;
    }

    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.f
    public g newHasher() {
        AnonymousClass1 r1 = null;
        if (this.supportsClone == false) goto L7;
        return new a((MessageDigest) ZeusTransformUtils.preCheckCast(this.prototype.clone(), MessageDigest.class, "com.obric.memorydata.plugin"), this.bytes, r1);
    L7:
        return new a(getMessageDigest(this.prototype.getAlgorithm()), this.bytes, r1);
    }

    public String toString() {
        return this.toString;
    }

    Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }
}
