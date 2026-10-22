package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberNonDirectionalPage$Param$Type;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {

    public static final class a {
        public final n a;
        public final int b;
        public final int c;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "ParsedLink(link=" + this.a + ", start=" + this.b + ", end=" + this.c + ')';
        }

        public a(n r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    List<a> a(int r1, int r2, CharSequence r3);
}
