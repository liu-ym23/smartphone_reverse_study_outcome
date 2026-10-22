package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface x {

    public static final class a implements x {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements x {
        public final boolean a;

        public b(boolean r1) {
            this.a = r1;
        }
    }

    public static final class c implements x {
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
        public final Boolean l;
        public final String m;
        public final String n;
        public final String o;
        public final String p;
        public final String q;
        public final boolean r;

        public c(BotAvatarIconData r4, BgImage r5, String r6, String r7, String r8, String r9, Boolean r10, BotModel r11, String r12, String r13, String r14, String r15, String r16, String r17, boolean r18) {
            Intrinsics.checkNotNullParameter(r4, "avatarInfo");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
            this.h = r11;
            this.i = r12;
            this.j = r13;
            this.k = r14;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = r15;
            this.p = r16;
            this.q = r17;
            this.r = r18;
        }
    }

    public static final class d implements x {
        public final BotAvatarIconData a;
        public final BgImageInfo b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final Boolean g;
        public final BotModel h;
        public final String i;

        public d(BotAvatarIconData r1, BgImageInfo r2, String r3, String r4, String r5, String r6, Boolean r7, BotModel r8, String r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }
    }

    public static final class e implements x {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f implements x {
        public final TextRes a;

        public f(TextRes r2) {
            Intrinsics.checkNotNullParameter(r2, "testRes");
            this.a = r2;
        }
    }
}
