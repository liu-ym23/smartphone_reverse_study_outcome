package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class PlatformRandom extends AbstractPlatformRandom implements Serializable {
    private static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private final java.util.Random impl;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PlatformRandom(java.util.Random r10) {
        Intrinsics.checkNotNullParameter(r10, "impl");
        this.impl = r10;
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public java.util.Random getImpl() {
        return this.impl;
    }
}
