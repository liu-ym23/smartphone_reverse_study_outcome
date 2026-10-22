package com.larksuite.component.ui.tag;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class TagsDrawable extends Drawable {
    public static final /* synthetic */ int j = 0;
    public final a a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final Lazy g;
    public final List<d> h;
    public final HashMap<d, Rect> i;

    public static final class a {
        public final Context a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final float f;
        public final List<d> g;
        public final ArrayList<HashSet<Integer>> h;

        public final int hashCode() {
            return ((((((((((0 + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.g.hashCode()) * 31) + Float.floatToIntBits(this.f);
        }

        public final Context getContext() {
            return this.a;
        }

        public a(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            this.a = r4;
            int r0 = TagsDrawable.j;
            this.b = b.a(r4, 12.0f);
            this.c = b.a(r4, 4.0f);
            this.d = b.a(r4, 18.0f);
            this.e = b.a(r4, 4.0f);
            this.f = b.a(r4, 12.0f);
            this.g = new ArrayList(2);
            this.h = new ArrayList();
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
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.tag.TagsDrawable.Builder");
            a r6 = (a) r5;
            if (this.b != r6.b) goto L15;
            boolean r1 = true;
        L16:
            if (r1 == true) goto L19;
            return false;
        L19:
            if (this.c != r6.c) goto L21;
            boolean r3 = true;
        L22:
            if (r3 == true) goto L25;
            return false;
        L25:
            if (this.d != r6.d) goto L27;
            boolean r4 = true;
        L28:
            if (r4 == true) goto L31;
            return false;
        L31:
            if (this.e != r6.e) goto L33;
            boolean r7 = true;
        L34:
            if (r7 == true) goto L37;
            return false;
        L37:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L40;
            return false;
        L40:
            if (this.f != r6.f) goto L42;
            boolean r8 = true;
        L43:
            if (r8 == true) goto L45;
            return false;
        L45:
            return true;
        L42:
            r8 = false;
            goto L43
        L33:
            r7 = false;
            goto L34
        L27:
            r4 = false;
            goto L28
        L21:
            r3 = false;
            goto L22
        L15:
            r1 = false;
            goto L16
        L8:
            r2 = null;
            goto L10
        }
    }

    public static final class b {
        public static float a(Context r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Resources r3 = r1.getResources();
            return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
        }
    }

    public static final class c extends Drawable {
        public final Drawable a;
        public int b;
        public int c;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return this.a.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            return this.c;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            return this.b;
        }

        public c(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "origin");
            this.a = r2;
            this.b = r2.getIntrinsicWidth();
            this.c = r2.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r5) {
            Intrinsics.checkNotNullParameter(r5, "canvas");
            r5.save();
            r5.scale(this.b / this.a.getIntrinsicWidth(), this.c / this.a.getIntrinsicHeight(), getBounds().left, getBounds().top);
            this.a.draw(r5);
            r5.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r2) {
            this.a.setAlpha(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r2) {
            this.a.setColorFilter(r2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(int r2, int r3, int r4, int r5) {
            super.setBounds(r2, r3, r4, r5);
            Drawable r6 = this.a;
            r6.setBounds(r2, r3, r6.getIntrinsicWidth() + r2, this.a.getIntrinsicHeight() + r3);
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final int c;
        public final Drawable d;

        public static final class a {
            public final Context a;
            public final int b;
            public int c;
            public final int d;
            public Drawable e;

            public final Context getContext() {
                return this.a;
            }

            public a(Context r2) {
                Intrinsics.checkNotNullParameter(r2, "context");
                this.a = r2;
                this.b = -1;
                this.c = 10;
                this.d = -1;
            }
        }

        public final int hashCode() {
            int r0 = ((((this.b * 31) + 0) * 31) + this.c) * 31;
            Drawable r2 = this.d;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return ((r0 + r3) * 31) + 0;
        L5:
            r3 = 0;
            goto L7
        }

        public d(a r2) {
            Intrinsics.checkNotNullParameter(r2, "builder");
            this.a = r2.b;
            this.b = r2.c;
            this.c = r2.d;
            this.d = r2.e;
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if (r6 == null) goto L8;
            Class<?> r3 = r6.getClass();
        L10:
            if (Intrinsics.areEqual(d.class, r3) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.larksuite.component.ui.tag.TagsDrawable.TagModel");
            d r7 = (d) r6;
            if (this.b == r7.b) goto L15;
            return false;
        L15:
            r7.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L19;
            return false;
        L19:
            if (this.c == r7.c) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.d, r7.d) == true) goto L24;
            return false;
        L24:
            r7.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L27;
            return false;
        L27:
            return true;
        L8:
            r3 = null;
            goto L10
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return getBounds().width();
    }

    public TagsDrawable(a r15) {
        this.a = r15;
        Lazy r0 = LazyKt.lazy(new TagsDrawable$textPaint$2(this));
        this.g = r0;
        this.i = new HashMap(2);
        float r1 = r15.b;
        this.b = r1;
        this.c = r15.c;
        this.d = r15.d;
        this.e = r15.e;
        this.f = r15.f;
        List<d> r16 = r15.g;
        this.h = r16;
        ((TextPaint) r0.getValue()).setTextSize(r1);
        if (r16 == null) goto L18;
        Iterator r17 = ((ArrayList) r16).iterator();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r17.hasNext() == false) goto L19;
        d r5 = (d) r17.next();
        if (this.i.containsKey(r5) == true) goto L6;
        Rect r6 = new Rect(r4, 0, 0, 0);
        r5.getClass();
        Drawable r7 = r5.d;
        if (r7 == null) goto L17;
        float r8 = this.d;
        if ((r7 instanceof c) == false) goto L16;
        c r9 = (c) r7;
        float r10 = this.f;
        float r11 = r10 / r9.a.getIntrinsicHeight();
        r9.c = (int) r10;
        r9.b = (int) (r9.a.getIntrinsicWidth() * r11);
    L16:
        int r12 = r7.getIntrinsicWidth();
        int r13 = r7.getIntrinsicHeight();
        float r14 = r12;
        float r19 = Math.max(r14, 0.0f);
        float r20 = r13;
        float r21 = Math.max(r20, r8);
        int r110 = r6.left;
        int r111 = r6.top;
        r6.set(r110, r111, ((int) r19) + r110, ((int) r21) + r111);
        float r22 = r19 - r14;
        float r23 = 2;
        int r24 = (int) (r22 / r23);
        int r25 = (int) ((r21 - r20) / r23);
        r7.setBounds(r6.left + r24, r6.top + r25, r6.right - r24, r6.bottom - r25);
    L17:
        this.i.put(r5, r6);
        int r26 = r6.right;
        int r27 = (int) (r26 + this.e);
        r3 = Math.max(r3, r6.bottom);
        r2 = r26;
        r4 = r27;
    L19:
        setBounds(0, 0, r2, r3);
        invalidateSelf();
        return;
    L18:
        r2 = 0;
        r3 = 0;
        goto L19
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        List<d> r0 = this.h;
        if (r0 == null) goto L15;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L26;
        d r2 = (d) r1.next();
        if (this.i.get(r2) == null) goto L6;
        r2.getClass();
        Drawable r3 = r2.d;
        if ((r3 instanceof UDTagsDrawable) == true) goto L12;
        if (r3 == null) goto L6;
        r3.draw(r5);
        goto L6
    L12:
        r5.save();
        r5.translate(((UDTagsDrawable) r2.d).getBounds().left, 0.0f);
        ((UDTagsDrawable) r2.d).draw(r5);
        r5.restore();
        goto L6
    L26:
        return;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(TagsDrawable.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.tag.TagsDrawable");
        TagsDrawable r6 = (TagsDrawable) r5;
        if (this.b != r6.b) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == true) goto L19;
        return false;
    L19:
        if (this.c != r6.c) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == true) goto L25;
        return false;
    L25:
        if (this.d != r6.d) goto L27;
        boolean r4 = true;
    L28:
        if (r4 == true) goto L31;
        return false;
    L31:
        if (this.e != r6.e) goto L33;
        boolean r7 = true;
    L34:
        if (r7 == true) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L39;
        return false;
    L39:
        return true;
    L33:
        r7 = false;
        goto L34
    L27:
        r4 = false;
        goto L28
    L21:
        r3 = false;
        goto L22
    L15:
        r1 = false;
        goto L16
    L8:
        r2 = null;
        goto L10
    }
}
