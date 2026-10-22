package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class JournalingSecureRandom extends SecureRandom {
    private static byte[] EMPTY_TRANSCRIPT;
    private final SecureRandom base;
    private int index;
    private TranscriptStream tOut;
    private byte[] transcript;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.JournalingSecureRandom$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class TranscriptStream extends ByteArrayOutputStream {
        private TranscriptStream() {
        }

        /* synthetic */ TranscriptStream(AnonymousClass1 r1) {
            this();
        }

        public void clear() {
            Arrays.fill(this.buf, (byte) 0);
        }
    }

    static {
        EMPTY_TRANSCRIPT = new byte[0];
    }

    public JournalingSecureRandom() {
        this(CryptoServicesRegistrar.getSecureRandom());
    }

    public JournalingSecureRandom(SecureRandom r3) {
        this.tOut = new TranscriptStream(null);
        this.index = 0;
        this.base = r3;
        this.transcript = EMPTY_TRANSCRIPT;
    }

    public JournalingSecureRandom(byte[] r3, SecureRandom r4) {
        this.tOut = new TranscriptStream(null);
        this.index = 0;
        this.base = r4;
        this.transcript = Arrays.clone(r3);
    }

    public void clear() {
        Arrays.fill(this.transcript, (byte) 0);
        this.tOut.clear();
    }

    public byte[] getFullTranscript() {
        int r0 = this.index;
        byte[] r1 = this.transcript;
        if (r0 != r1.length) goto L7;
        return this.tOut.toByteArray();
    L7:
        return Arrays.clone(r1);
    }

    public byte[] getTranscript() {
        return this.tOut.toByteArray();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public final void nextBytes(byte[] r6) {
        if (this.index < this.transcript.length) goto L5;
        this.base.nextBytes(r6);
    L19:
        this.tOut.write(r6);     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        throw new IllegalStateException("unable to record transcript: " + e.getMessage());
    L5:
        int r1 = 0;
    L7:
        if (r1 == r6.length) goto L12;
        int r2 = this.index;
        byte[] r3 = this.transcript;
        if (r2 >= r3.length) goto L12;
        this.index = r2 + 1;
        r6[r1] = r3[r2];
        r1 = r1 + 1;
    L12:
        if (r1 == r6.length) goto L19;
        int r4 = r6.length - r1;
        byte[] r5 = new byte[r4];
        this.base.nextBytes(r5);
        System.arraycopy(r5, 0, r6, r1, r4);
        goto L19
    }

    public void reset() {
        this.index = 0;
        if (0 != this.transcript.length) goto L5;
        this.transcript = this.tOut.toByteArray();
    L5:
        this.tOut.reset();
    }
}
