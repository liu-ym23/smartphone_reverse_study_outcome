package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.net.Uri;
import android.os.Bundle;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface c {

    public static final class a implements c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements c {
        public final Bundle a;

        public b(Bundle r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.c$c, reason: collision with other inner class name */
    public static final class C0059c implements c {
        public final BgImageInfo a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final Boolean f;
        public final BotModel g;
        public final String h;
        public final String i;
        public final Boolean j;
        public final String k;
        public final String l;
        public final String m;
        public final boolean n;

        public C0059c(BgImageInfo r1, String r2, String r3, String r4, String r5, Boolean r6, BotModel r7, String r8, String r9, Boolean r10, String r11, String r12, String r13, boolean r14) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
            this.m = r13;
            this.n = r14;
        }
    }

    public static final class d implements c {
        public final boolean a;

        public d(boolean r1) {
            this.a = r1;
        }
    }

    public static final class e implements c {
        public final Uri a;

        public e(Uri r1) {
            this.a = r1;
        }
    }

    public static final class f implements c {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    public static final class g implements c {
        public final TextRes a;

        public g(TextRes r2) {
            Intrinsics.checkNotNullParameter(r2, "testRes");
            this.a = r2;
        }
    }

    public static final class h implements c {
        public final TextRes a;

        public h(TextRes.StringResId r2) {
            Intrinsics.checkNotNullParameter(r2, "testRes");
            this.a = r2;
        }
    }
}
