package com.larus.slides.impl.select;

import android.os.Bundle;
import com.larus.slides.impl.select.common.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface o {

    public static final class a implements o {
        public final Bundle a;

        public a(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "bundle");
            this.a = r2;
        }
    }

    public static final class b implements o {
    }

    public static final class c implements o {
    }

    public static final class d implements o {
    }

    public static final class e implements o {
    }

    public static final class f implements o {
        public final String a;

        public f(String r1) {
            this.a = r1;
        }
    }

    public static final class g implements o {
        public final TextRes a;

        public g(TextRes.PlainText r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.a = r2;
        }
    }
}
