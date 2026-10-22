package com.ss.android.lark.inline.ai.logic;

import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface j {

    public static final class a implements j {
        public final String a;

        public final String toString() {
            return "NormalText(text=" + this.a + ')';
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.a = r2;
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if (r4 == null) goto L8;
            Class<?> r2 = r4.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.logic.UserInputText.NormalText");
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L15;
            return false;
        L15:
            return true;
        L8:
            r2 = null;
            goto L10
        }
    }

    public static final class b implements j {
        public final String a;
        public final List<a> b;
        public final String c;

        public static final class a {
            public final String a;
            public final String b;
            public final String c;
            public final String d;

            public final String toString() {
                return "Template(key=" + this.a + ", name=" + this.b + ", placeHolder=" + this.c + ", userInput=" + this.d + ')';
            }

            public a() {
                this("", "", "", "");
            }

            public final int hashCode() {
                int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
                String r1 = this.c;
                if (r1 == null) goto L5;
                int r2 = r1.hashCode();
            L7:
                return ((r0 + r2) * 31) + this.d.hashCode();
            L5:
                r2 = 0;
                goto L7
            }

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (r5 == null) goto L8;
                Class<?> r2 = r5.getClass();
            L10:
                if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
                return false;
            L12:
                Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.logic.UserInputText.TemplateText.Template");
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L19;
                return false;
            L19:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L22;
                return false;
            L22:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L24;
                return false;
            L24:
                return true;
            L8:
                r2 = null;
                goto L10
            }

            public a(String r2, String r3, String r4, String r5) {
                Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
                Intrinsics.checkNotNullParameter(r3, "name");
                Intrinsics.checkNotNullParameter(r5, "userInput");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
            }
        }

        public final String toString() {
            return "TemplateText(templatePrefix=" + this.a + ", templateList=" + this.b + ", displayContent=" + this.c + ')';
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.logic.UserInputText.TemplateText");
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public b(String r2, List<a> r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "templatePrefix");
            Intrinsics.checkNotNullParameter(r3, "templateList");
            Intrinsics.checkNotNullParameter(r4, "displayContent");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }
}
