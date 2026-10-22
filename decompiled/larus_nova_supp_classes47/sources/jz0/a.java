package jz0;

import com.bytedance.android.scope.o;
import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements iz0.b, o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // iz0.b
    public final b p0(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        return new b(Keva.getRepo(r2, r3));
    }
}
