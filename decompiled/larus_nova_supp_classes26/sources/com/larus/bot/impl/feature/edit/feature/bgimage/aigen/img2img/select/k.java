package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.os.Bundle;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface k {

    public static final class a implements k {
        public final Bundle a;

        public a(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "bundle");
            this.a = r2;
        }
    }

    public static final class b implements k {
        public final Bundle a;

        public b(Bundle r1) {
            this.a = r1;
        }
    }

    public static final class c implements k {
    }

    public static final class d implements k {
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
        public final String k;
        public final String l;

        public d(BotAvatarIconData r2, BgImage r3, String r4, String r5, String r6, String r7, Boolean r8, BotModel r9, String r10, String r11, String r12, String r13) {
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
            this.l = r13;
        }
    }

    public static final class e implements k {
        public final BgSelectViewHolder.a a;
        public final String b;
        public final String c;

        public e(BgSelectViewHolder.a r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "bgSelectItemData");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class f implements k {
        public final boolean a;

        public f() {
            this.a = false;
        }
    }

    public static final class g implements k {
        public final TextRes a;

        public g(TextRes r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.a = r2;
        }
    }
}
