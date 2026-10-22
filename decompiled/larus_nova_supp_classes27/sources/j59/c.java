package j59;

import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements d {
    public final Keva a;

    public c(Keva r2) {
        Intrinsics.checkNotNullParameter(r2, "keva");
        this.a = r2;
    }

    @Override // j59.d
    public final int getInt(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return this.a.getInt(r3, 0);
    }

    @Override // j59.d
    public final long getLong(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        return this.a.getLong(r4, 0);
    }

    @Override // j59.d
    public final void putInt(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.storeInt(r2, r3);
    }

    @Override // j59.d
    public final void putLong(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.storeLong(r2, r3);
    }
}
