package org.bouncycastle.crypto.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
class DerUtil {

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.DerUtil$1, reason: invalid class name */
    static class AnonymousClass1 extends IllegalStateException {
        final /* synthetic */ IOException val$e;

        AnonymousClass1(String r1, IOException r2) {
            this.val$e = r2;
            super(r1);
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.val$e;
        }
    }
}
