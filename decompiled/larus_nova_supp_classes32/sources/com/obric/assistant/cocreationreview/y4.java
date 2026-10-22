package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.view.View;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class y4 {

    public static final class a extends y4 {
        public final String a;
        public final String b;
        public final Function1<Context, View> c;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Custom(label=" + this.a + ", anchor=" + this.b + ", contentBuilder=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r2, String r3, Function1<? super Context, ? extends View> r4) {
            Intrinsics.checkNotNullParameter(r2, "label");
            Intrinsics.checkNotNullParameter(r4, "contentBuilder");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b extends y4 {
        public final String a;
        public final List<com.obric.assistant.cocreationreview.c> b;
        public final List<String> c;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "History(label=" + this.a + ", tags=" + this.b + ", steps=" + this.c + ')';
        }

        public b(List r3, List r4) {
            Intrinsics.checkNotNullParameter("执行历史", "label");
            Intrinsics.checkNotNullParameter(r3, "tags");
            Intrinsics.checkNotNullParameter(r4, "steps");
            this.a = "执行历史";
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c extends y4 {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
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
            return "Message(label=" + this.a + ", text=" + this.b + ')';
        }

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "label");
            Intrinsics.checkNotNullParameter(r3, "text");
            this.a = r2;
            this.b = r3;
        }
    }

    public y4() {
    }
}
