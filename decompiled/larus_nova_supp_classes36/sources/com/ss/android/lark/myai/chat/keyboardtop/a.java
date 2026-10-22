package com.ss.android.lark.myai.chat.keyboardtop;

import android.text.SpannableStringBuilder;
import cya.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends h {

    /* JADX INFO: renamed from: com.ss.android.lark.myai.chat.keyboardtop.a$a, reason: collision with other inner class name */
    public static final class C0193a {
    }

    public static final class b {
        public final String a;
        public final boolean b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final CharSequence g;
        public final String h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return ((((((((((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "QuickActionParamState(id=" + this.a + ", needUserConfirm=" + this.b + ", name=" + this.c + ", displayName=" + this.d + ", description=" + this.e + ", displayPlaceHolder=" + this.f + ", userInputParamValue=" + this.g + ", defaultValue=" + this.h + ')';
        }

        public b(String r2, String r3, String r4, String r5, String r6, CharSequence r7, String r8) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "name");
            Intrinsics.checkNotNullParameter(r4, "displayName");
            Intrinsics.checkNotNullParameter(r5, "description");
            Intrinsics.checkNotNullParameter(r6, "displayPlaceHolder");
            Intrinsics.checkNotNullParameter(r7, "userInputParamValue");
            Intrinsics.checkNotNullParameter(r8, "defaultValue");
            this.a = r2;
            this.b = false;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    static {
    }

    public final int a() {
        return 0;
    }

    public final void update(SpannableStringBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "currentEditContent");
        com.ss.android.lark.myai.chat.quickactions.b.a(r2);
        throw null;
    }
}
