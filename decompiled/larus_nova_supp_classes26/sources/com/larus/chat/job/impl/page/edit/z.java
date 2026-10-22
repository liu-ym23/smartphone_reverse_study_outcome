package com.larus.chat.job.impl.page.edit;

import com.larus.bmhome.share.panel.ShareType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class z {

    public static final class a extends z {
        public final String a;
        public final List<a0> b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OptionSection(sectionKey=" + this.a + ", rows=" + this.b + ')';
        }

        public a(String r2, List<a0> r3) {
            Intrinsics.checkNotNullParameter(r2, "sectionKey");
            Intrinsics.checkNotNullParameter(r3, "rows");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends z {
        public final ChatJobEditTextKey a;
        public final String b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "TextInput(key=" + this.a + ", text=" + this.b + ", multiline=" + this.c + ')';
        }

        public b(ChatJobEditTextKey r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public z() {
    }
}
