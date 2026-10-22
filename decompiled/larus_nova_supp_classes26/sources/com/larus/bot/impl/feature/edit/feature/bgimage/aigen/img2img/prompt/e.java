package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface e {

    public static final class a implements e {
        public final String a;

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            this.a = r2;
        }
    }

    public static final class b implements e {
        public final String a;

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "prompt");
            this.a = r2;
        }
    }

    public static final class c implements e {
        public final TextRes a;

        public c(TextRes r2) {
            Intrinsics.checkNotNullParameter(r2, "testRes");
            this.a = r2;
        }
    }
}
