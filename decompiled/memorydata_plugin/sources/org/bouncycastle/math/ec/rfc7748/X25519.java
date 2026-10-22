package org.bouncycastle.math.ec.rfc7748;

import org.bouncycastle.math.ec.rfc8032.Ed25519;

/* JADX INFO: loaded from: classes7.dex */
public abstract class X25519 {

    private static class F extends X25519Field {
    }

    public static class Friend {
        private static final Friend INSTANCE = null;

        static {
            INSTANCE = new Friend();
        }

        private Friend() {
        }

        static /* synthetic */ Friend access$000() {
            return INSTANCE;
        }
    }

    public static void generatePublicKey(byte[] r0, int r1, byte[] r2, int r3) {
        scalarMultBase(r0, r1, r2, r3);
    }

    public static void scalarMultBase(byte[] r3, int r4, byte[] r5, int r6) {
        int[] r0 = F.create();
        int[] r1 = F.create();
        Ed25519.scalarMultBaseYZ(Friend.access$000(), r3, r4, r0, r1);
        F.apm(r1, r0, r0, r1);
        F.inv(r1, r1);
        F.mul(r0, r1, r0);
        F.normalize(r0);
        F.encode(r0, r5, r6);
    }
}
