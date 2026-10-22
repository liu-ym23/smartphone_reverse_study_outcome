package com.obric.dejavu.library.cipher;

import com.obric.dejavu.library.DbStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherUtils;", "", "()V", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7886a = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/dejavu/library/cipher/DbCipherUtils$Companion;", "", "()V", "checkCryptoOptions", "Lcom/obric/dejavu/library/DbStatus;", "cryptoOpt", "Lcom/obric/dejavu/library/cipher/CryptoOptions;", "generateRandomSeed", "", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final DbStatus a(com.obric.dejavu.library.cipher.a r2) {
            Intrinsics.checkNotNullParameter(r2, "cryptoOpt");
            if (r2.b().length() >= 64) goto L6;
            return b.f7881a.b();
        L6:
            if (r2.b().length() <= 128) goto L9;
            return b.f7881a.c();
        L9:
            return DbStatus.f7870a.a();
        }
    }

    static {
        f7886a = new a(null);
    }
}
