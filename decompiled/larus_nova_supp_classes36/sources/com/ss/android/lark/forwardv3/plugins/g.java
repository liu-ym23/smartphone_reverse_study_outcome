package com.ss.android.lark.forwardv3.plugins;

import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface g {

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final boolean d;
        public final boolean e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            int r2 = 1231;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.e == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "ChatterInfo(chatterId=" + this.a + ", displayName=" + this.b + ", originName=" + this.c + ", isOutChatUser=" + this.d + ", isAnonymous=" + this.e + ')';
        }

        public a(String r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "chatterId");
            Intrinsics.checkNotNullParameter(r4, "displayName");
            Intrinsics.checkNotNullParameter("", "originName");
            this.a = r3;
            this.b = r4;
            this.c = "";
            this.d = r5;
            this.e = false;
        }
    }

    public interface b {
        List<SearchBaseInfo> a();
    }

    void a();
}
