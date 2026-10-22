package ob2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements ek6.b {
    public final String a;

    public final void a() {
    }

    public final String toString() {
        return "LiveLottieResource[" + this.a + ']';
    }

    public e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "assetFilePath");
        this.a = r2;
    }
}
