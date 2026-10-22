package com.larksuite.component.ui.tag;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final /* synthetic */ int e = 0;
    public final a a;
    public final int b;
    public final int c;
    public final Function2<Context, DrawableStateSet, Drawable> d;

    public static final class a {
        public int a;
        public int b;
        public int c;
        public UDTagsDrawable.TagColorSet d;
        public String e;
        public Function2<? super Context, ? super DrawableStateSet, ? extends Drawable> f;

        public final b a() {
            return new b(this);
        }

        public a() {
            this.a = -1;
            this.b = 100;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.ui.tag.b$b, reason: collision with other inner class name */
    public static final class C0037b {
    }

    static {
    }

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
        return "IconTag(bd=" + this.a + ')';
    }

    public b(final a r2) {
        this.a = r2;
        this.b = r2.a;
        this.c = r2.b;
        this.d = new IconTag$Builder$icon$1(r2);
    }
}
