package com.ss.android.lark.flow.feed.component.title;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.component.title.a$a, reason: collision with other inner class name */
    public static final class C0047a extends a {
        public final Drawable a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0047a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0047a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "DrawableTag(drawable=" + this.a + ')';
        }

        public C0047a(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public final View a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ViewTag(view=" + this.a + ')';
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }
    }

    public a() {
    }
}
