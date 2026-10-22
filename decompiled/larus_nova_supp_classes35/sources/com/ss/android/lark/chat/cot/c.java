package com.ss.android.lark.chat.cot;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class c {

    public static final class a extends c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "BuiltIn(name=" + this.a + ')';
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
            this.a = r2;
        }
    }

    public static final class b extends c {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.c$c, reason: collision with other inner class name */
    public static final class C0087c extends c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0087c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0087c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ImageKey(key=" + this.a + ')';
        }

        public C0087c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "key");
            this.a = r2;
        }
    }

    public static final class d extends c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ImageUrl(url=" + this.a + ')';
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }

    public static final class e extends c {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f extends c {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "UdToken(token=" + this.a + ')';
        }

        public f(String r2) {
            Intrinsics.checkNotNullParameter(r2, "token");
            this.a = r2;
        }
    }

    public c() {
    }
}
