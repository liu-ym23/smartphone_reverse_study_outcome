package com.ss.ugc.effectplatform.algorithm;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface f {

    public static final class a implements f {
        public static final a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @Override // com.ss.ugc.effectplatform.algorithm.f
        public final void loadLibrary(String r4) {
            Intrinsics.checkNotNullParameter(r4, "libName");
            FLogger r0 = FLogger.a;
            r0.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r4));
            com.bytedance.librarian.a.c(r4);
            r0.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r4));
        }
    }

    void loadLibrary(String r1);
}
