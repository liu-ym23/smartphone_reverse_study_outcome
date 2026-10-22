package com.larus.bot.impl.feature.edit.feature.autofill;

import com.larus.bot.impl.common.propertyconfig.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface b {

    public static final class a implements b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.autofill.b$b, reason: collision with other inner class name */
    public static final class C0054b implements b {
        public final TextRes a;

        public C0054b(TextRes r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.a = r2;
        }
    }
}
