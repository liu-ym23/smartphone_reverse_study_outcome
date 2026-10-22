package com.larus.bot.impl.feature.edit;

import com.larus.bot.impl.bean.ContentType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface e0 {

    public static final class a implements e0 {
        public final boolean a;
        public final ContentType b;

        public a(boolean r2, ContentType r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements e0 {
        public final wu8.c a;

        public b(wu8.c r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }
    }

    public static final class c implements e0 {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }
}
