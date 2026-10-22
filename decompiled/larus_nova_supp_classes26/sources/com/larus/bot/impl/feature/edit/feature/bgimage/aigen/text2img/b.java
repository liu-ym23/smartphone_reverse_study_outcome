package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BotModel;
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

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.b$b, reason: collision with other inner class name */
    public static final class C0063b implements b {
        public final BotAvatarIconData a;
        public final BgImage b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final Boolean g;
        public final BotModel h;
        public final String i;
        public final String j;
        public final boolean k;

        public C0063b(BotAvatarIconData r2, BgImage r3, String r4, String r5, String r6, String r7, Boolean r8, BotModel r9, String r10, String r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r2, "avatarInfo");
            Intrinsics.checkNotNullParameter(r3, "bgImage");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
        }
    }

    public static final class c implements b {
    }

    public static final class d implements b {
        public d() {
        }
    }

    public static final class e implements b {
        public final TextRes a;

        public e(TextRes.StringResId r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.a = r2;
        }
    }
}
