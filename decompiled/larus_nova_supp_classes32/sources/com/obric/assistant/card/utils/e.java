package com.obric.assistant.card.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a extends DynamicDrawableSpan {
        public final Drawable a;

        @Override // android.text.style.DynamicDrawableSpan
        public final Drawable getDrawable() {
            return this.a;
        }

        public a(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "mDrawable");
            this.a = r2;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r9, "paint");
            r1.save();
            r1.translate(r5, (r6 + ((r8 - r6) / 2)) - (this.a.getBounds().height() / 2));
            this.a.draw(r1);
            r1.restore();
        }
    }

    public static final class b extends ReplacementSpan {
        public final int a;

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r9, "paint");
        }

        public b(int r1) {
            this.a = r1;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
            Intrinsics.checkNotNullParameter(r1, "paint");
            Intrinsics.checkNotNullParameter(r2, "text");
            return this.a;
        }
    }

    static {
    }

    public static CharSequence a(Context r12, List r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "textList");
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        ArrayList r2 = new ArrayList();
        Iterator r14 = r13.iterator();
    L3:
        boolean r4 = false;
        if (r14.hasNext() == false) goto L10;
        Object r3 = r14.next();
        if (((String) r3).length() <= 0) goto L8;
        r4 = true;
    L8:
        if (r4 == false) goto L3;
        r2.add(r3);
        goto L3
    L10:
        Iterator r15 = r2.iterator();
        int r5 = 0;
    L12:
        if (r15.hasNext() == false) goto L23;
        Object r6 = r15.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r0.append((String) r6);
        if (r5 >= (r2.size() - 1)) goto L22;
        if (r1.element != null) goto L21;
        ColorDrawable r8 = new ColorDrawable(ContextCompat.getColor(r12, 2131103686));
        r8.setBounds(0, 0, r12.getResources().getDimensionPixelSize(2131165850), r12.getResources().getDimensionPixelSize(2131165852));
        r1.element = r8;
    L21:
        r0.append("X");
        r0.setSpan(new b(r12.getResources().getDimensionPixelSize(2131166264)), r0.length() - 1, r0.length(), 33);
        r0.append("X");
        Object r9 = r1.element;
        Intrinsics.checkNotNull(r9);
        r0.setSpan(new a((Drawable) r9), r0.length() - 1, r0.length(), 33);
        r0.append("X");
        r0.setSpan(new b(r12.getResources().getDimensionPixelSize(2131166264)), r0.length() - 1, r0.length(), 33);
    L22:
        r5 = r7;
        goto L12
    L23:
        return r0;
    }
}
