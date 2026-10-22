package com.google.common.hash;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
final class MessageDigestHashFunction extends b implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        public SerializedForm(String r5, int r10, String r11, v r12) {
            this.algorithmName = r5;
            this.bytes = r10;
            this.toString = r11;
        }

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }
    }

    public MessageDigestHashFunction(String r5, String r10) {
        MessageDigest r11 = MessageDigest.getInstance(r5);     // Catch: NoSuchAlgorithmException -> L10
        this.prototype = r11;
        this.bytes = r11.getDigestLength();
        r10.getClass();
        this.toString = r10;
        r11.clone();     // Catch: CloneNotSupportedException -> L7
        boolean r12 = true;
    L8:
        this.supportsClone = r12;
        return;
    L7:
        r12 = false;
    L10:
        e = move-exception;
        throw new AssertionError(e);
    }

    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.k
    public l newHasher() {
        if (this.supportsClone == false) goto L14;
        return new w((MessageDigest) this.prototype.clone(), this.bytes);
    L14:
        MessageDigest r5 = MessageDigest.getInstance(this.prototype.getAlgorithm());     // Catch: NoSuchAlgorithmException -> L10
        return new w(r5, this.bytes);
    L10:
        e = move-exception;
        throw new AssertionError(e);
    }

    public String toString() {
        return this.toString;
    }

    public Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }

    public MessageDigestHashFunction(String r5, int r10, String r11) {
        r11.getClass();
        this.toString = r11;
        MessageDigest r12 = MessageDigest.getInstance(r5);     // Catch: NoSuchAlgorithmException -> L14
        this.prototype = r12;
        int r13 = r12.getDigestLength();
        boolean r14 = false;
        if (r10 < 4) goto L8;
        if (r10 > r13) goto L8;
        boolean r15 = true;
    L9:
        com.google.common.base.b0.e("bytes (%s) must be >= 4 and < %s", r10, r13, r15);
        this.bytes = r10;
        r12.clone();     // Catch: CloneNotSupportedException -> L17
        r14 = true;
    L12:
        this.supportsClone = r14;
        return;
    L8:
        r15 = false;
    L14:
        e = move-exception;
        throw new AssertionError(e);
    }
}
