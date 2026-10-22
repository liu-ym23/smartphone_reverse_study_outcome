package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface w {

    public static final class a implements w {
        public final boolean a;

        public a(boolean r1) {
            this.a = r1;
        }
    }

    public static final class b implements w {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c implements w {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d implements w {
        public final Bundle a;

        public d(Bundle r1) {
            this.a = r1;
        }
    }

    public static final class e implements w {
        public final boolean a;
        public final Uri b;
        public final String c;

        public /* synthetic */ e(Uri r3) {
            this(false, r3, null);
        }

        public e(boolean r1, Uri r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f implements w {
        public final boolean a;
        public final boolean b;

        public f(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }
}
