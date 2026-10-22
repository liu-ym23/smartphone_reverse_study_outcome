package com.larus.slides.impl.select;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface n {

    public static final class a implements n {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements n {
        public final Bundle a;

        public b(Bundle r1) {
            this.a = r1;
        }
    }

    public static final class c implements n {
        public final int a;

        public c(int r1) {
            this.a = r1;
        }
    }

    public static final class d implements n {
        public final int a;

        public d(int r1) {
            this.a = r1;
        }
    }

    public static final class e implements n {
        public final int a;

        public e(int r1) {
            this.a = r1;
        }
    }

    public static final class f implements n {
        public final Bundle a;

        public f(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }
}
