package com.google.common.hash;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes2.dex */
final class ChecksumHashFunction extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final h<? extends Checksum> checksumSupplier;
    private final String toString;

    /* JADX INFO: renamed from: com.google.common.hash.ChecksumHashFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class a extends com.google.common.hash.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChecksumHashFunction f4711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Checksum f4712b;

        private a(ChecksumHashFunction r3, Checksum r4) {
            Checksum r5 = (Checksum) ZeusTransformUtils.wrapperContextForParams(r4, Checksum.class, "com.obric.memorydata.plugin");
            this.f4711a = r3;
            this.f4712b = (Checksum) ZeusTransformUtils.preCheckCast(n.a(r5), Checksum.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ a(ChecksumHashFunction r2, Checksum r3, AnonymousClass1 r4) {
            this(r2, (Checksum) ZeusTransformUtils.wrapperContextForParams(r3, Checksum.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.hash.g
        public HashCode a() {
            long r0 = this.f4712b.getValue();
            if (ChecksumHashFunction.access$100(this.f4711a) != 32) goto L7;
            return HashCode.fromInt((int) r0);
        L7:
            return HashCode.fromLong(r0);
        }

        @Override // com.google.common.hash.a
        public void update(byte r1) {
            this.f4712b.update(r1);
        }

        @Override // com.google.common.hash.a
        public void update(byte[] r1, int r2, int r3) {
            this.f4712b.update(r1, r2, r3);
        }
    }

    ChecksumHashFunction(h<? extends Checksum> r3, int r4, String r5) {
        this.checksumSupplier = (h) ZeusTransformUtils.preCheckCast(n.a((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin")), h.class, "com.obric.memorydata.plugin");
        if (r4 != 32) goto L5;
    L8:
        boolean r6 = true;
    L9:
        n.a(r6, "bits (%s) must be either 32 or 64", r4);
        this.bits = r4;
        this.toString = (String) ZeusTransformUtils.preCheckCast(n.a(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L5:
        if (r4 == 64) goto L8;
        r6 = false;
        goto L9
    }

    static /* synthetic */ int access$100(ChecksumHashFunction r0) {
        return r0.bits;
    }

    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.f
    public g newHasher() {
        return new a(this, (Checksum) ZeusTransformUtils.preCheckCast(this.checksumSupplier.get(), Checksum.class, "com.obric.memorydata.plugin"), null);
    }

    public String toString() {
        return this.toString;
    }
}
