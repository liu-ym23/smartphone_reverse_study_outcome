package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.videochat.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface d {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements d {
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final Image f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            Image r1 = this.f;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Lark(id=" + this.b + ", name=" + this.c + ", department=" + this.d + ", avatarKey=" + this.e + ", image=" + this.f + ')';
        }

        public b(String r2, String r3, String r4, String r5, Image r6) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_Meta.NAME);
            Intrinsics.checkNotNullParameter(r4, "department");
            Intrinsics.checkNotNullParameter(r5, "avatarKey");
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class c implements d {
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "NonLark(id=" + this.b + ", name=" + this.c + ", avatarUrl=" + this.d + ')';
        }

        public c(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_Meta.NAME);
            Intrinsics.checkNotNullParameter(r4, "avatarUrl");
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
        a = a.a;
    }
}
