package a81;

import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {

    public static class a implements b {
        public a() {
        }

        @Override // a81.b
        public final void a(Configuration r2) {
            Intrinsics.checkNotNullParameter(r2, "newConfig");
        }
    }

    void a(Configuration r1);

    void b(int r1);
}
