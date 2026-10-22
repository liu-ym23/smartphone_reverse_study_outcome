package com.larus.bot.impl.feature.edit.feature.bgimage;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
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

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.b$b, reason: collision with other inner class name */
    public static final class C0064b implements b {
        public final BotAvatarIconData a;
        public final BgImageInfo b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;

        public C0064b(BotAvatarIconData r1, BgImageInfo r2, String r3, String r4, String r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = "click_ai_button";
        }
    }

    public static final class c implements b {
        public final String a;
        public final String b;

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "userBotGender");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d implements b {
        public final BotAvatarIconData a;
        public final BgImage b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final Boolean i;
        public final String j;
        public final boolean k;
        public final String l;

        public d(BotAvatarIconData r2, BgImage r3, String r4, String r5, String r6, String r7, String r8, String r9, Boolean r10, String r11, boolean r12, String r13) {
            Intrinsics.checkNotNullParameter(r2, "avatarInfo");
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

    public static final class e implements b {
        public final String a;

        public e() {
            this.a = null;
        }
    }

    public static final class f implements b {
        public final boolean a;
        public final BotAvatarIconData b;
        public final BgImageInfo c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;

        public f(boolean r1, BotAvatarIconData r2, BgImageInfo r3, String r4, String r5, String r6, String r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    public static final class g implements b {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }
    }

    public static final class h implements b {
        public final TextRes a;

        public h(TextRes r2) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            this.a = r2;
        }
    }
}
