package com.larus.canvas.feature.component.title;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface l extends com.larus.canvas.feature.component.base.b {

    public static final class a implements l {
        public final com.larus.canvas.feature.component.title.a a;

        public a(com.larus.canvas.feature.component.title.a r2) {
            Intrinsics.checkNotNullParameter(r2, "clickItem");
            this.a = r2;
        }
    }

    public static final class b implements l {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }
}
