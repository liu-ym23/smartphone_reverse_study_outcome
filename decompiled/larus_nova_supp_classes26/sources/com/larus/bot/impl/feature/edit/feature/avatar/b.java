package com.larus.bot.impl.feature.edit.feature.avatar;

import com.larus.bot.impl.common.propertyconfig.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface b {

    public static final class a implements b {
        public final String a;
        public final String b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "avatarUrl");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.avatar.b$b, reason: collision with other inner class name */
    public static final class C0056b implements b {
        public final String a;

        public C0056b(String r1) {
            this.a = r1;
        }
    }

    public static final class c implements b {
        public final String a;
        public final String b;

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "clickFrom");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d implements b {
        public final TextRes a;

        public d(TextRes r2) {
            Intrinsics.checkNotNullParameter(r2, "testRes");
            this.a = r2;
        }
    }
}
