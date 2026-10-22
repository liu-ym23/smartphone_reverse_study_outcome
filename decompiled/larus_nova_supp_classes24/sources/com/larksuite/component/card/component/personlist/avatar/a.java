package com.larksuite.component.card.component.personlist.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends ImageSpan implements com.larksuite.component.card.component.personlist.avatar.c {
    public final Context a;
    public final Drawable b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public String h;
    public final String i;
    public final boolean j;
    public final int k;
    public AvatarImage l;
    public boolean m;

    /* JADX INFO: renamed from: com.larksuite.component.card.component.personlist.avatar.a$a, reason: collision with other inner class name */
    public static final class C0021a extends Drawable {
        public final Drawable a;
        public final Drawable b;
        public final Path c;
        public final RectF d;
        public final Paint e;

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

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r6) {
            Intrinsics.checkNotNullParameter(r6, "canvas");
            Drawable r0 = this.a;
            if ((r0 instanceof BitmapDrawable) == true) goto L5;
            return;
        L5:
            Bitmap r1 = ((BitmapDrawable) r0).getBitmap();
            if (r1 != null) goto L8;
        L12:
            this.b.draw(r6);
            return;
        L8:
            if (r1.isRecycled() == true) goto L12;
            int r2 = r6.getSaveCount();
            r6.save();
            this.c.reset();
            this.c.addOval(this.d, Path.Direction.CW);
            r6.clipPath(this.c);
            r6.drawBitmap(r1, null, this.d, this.e);
            r6.restoreToCount(r2);
        }

        public C0021a(Drawable r2, Drawable r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "srcDrawable");
            Intrinsics.checkNotNullParameter(r3, "placeHolder");
            this.a = r2;
            this.b = r3;
            this.c = new Path();
            this.d = new RectF(0.0f, 0.0f, r4, r4);
            this.e = new Paint(2);
        }
    }

    public static final class b {
    }

    public final class c extends SimpleTarget<Drawable> {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void onLoadFailed(Drawable r2) {
            super.onLoadFailed(r2);
            this.a.m = true;
        }

        public final void onResourceReady(Object r4) {
            Drawable r5 = (Drawable) r4;
            super.onResourceReady(r5);
            if (r5 == null) goto L5;
            a r1 = this.a;
            C0021a r0 = new C0021a(r5, r1.b, r1.c);
            int r6 = this.a.c;
            r0.setBounds(0, 0, r6, r6);
            com.ss.android.lark.image.utils.e.b(this.a, "mDrawable", r0);
            com.ss.android.lark.image.utils.e.b(this.a, "mDrawableRef", null);
        L5:
            this.a.m = true;
            Lazy<SimpleUserLoader> r7 = SimpleUserLoader.d;
            SimpleUserLoader r8 = SimpleUserLoader.a.a();
            String r2 = this.a.h;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r2, "avatarKey");
            ArrayList r9 = (ArrayList) ((LinkedHashMap) r8.b).get(r2);
            if (r9 == null) goto L13;
            Iterator r10 = r9.iterator();
        L9:
            if (r10.hasNext() == false) goto L19;
            com.larksuite.component.card.component.personlist.avatar.b r3 = (com.larksuite.component.card.component.personlist.avatar.b) ((WeakReference) r10.next()).get();
            if (r3 == null) goto L9;
            r3.a();
            goto L9
        L19:
            return;
        }
    }

    static {
    }

    public final void b() {
        if (TextUtils.isEmpty(this.h) == false) goto L6;
        return;
    L6:
        if (this.l != null) goto L8;
        String r0 = this.h;
        String r1 = this.i;
        int r2 = this.c;
        this.l = AvatarImage.Builder.obtain(r0, r1, r2, r2).build();
    L8:
        AvatarImage r3 = this.l;
        if (r3 == null) goto L12;
        ImageLoader.with(this.a).load(r3).placeholder(this.b).asDrawable().into(new c(this));
        return;
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        if (this.h.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return super.getDrawable();
    L10:
        if (this.m == true) goto L13;
        b();
    L13:
        return super.getDrawable();
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larksuite.component.card.component.personlist.avatar.c
    public final void a(String r2, wy7.c r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "simpleUser");
        if (Intrinsics.areEqual(r2, this.i) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.h) == false) goto L11;
        String r4 = r3.a;
        if (r4 == null) goto L12;
        this.h = r4;
        b();
        return;
    L12:
        return;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r4, CharSequence r5, int r6, int r7, Paint.FontMetricsInt r8) {
        Intrinsics.checkNotNullParameter(r4, "paint");
        Rect r9 = getDrawable().getBounds();
        if (r8 == null) goto L6;
        Paint.FontMetricsInt r10 = r4.getFontMetricsInt();
        int r11 = r10.bottom;
        int r12 = r10.top;
        int r0 = r11 - r12;
        int r1 = r10.ascent;
        int r13 = r12 - r1;
        int r14 = r11 - r10.descent;
        int r2 = r1 + (r0 / 2);
        int r15 = (r9.bottom - r9.top) / 2;
        int r3 = (r2 - r15) - this.g;
        r8.ascent = r3;
        r8.top = r3 + r13;
        int r16 = r2 + r15;
        r8.descent = r16;
        r8.bottom = r16 + r14;
    L6:
        return (this.e + r9.right) + this.f;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r13, CharSequence r14, int r15, int r16, float r17, int r19, int r110, int r20, Paint r21) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        Intrinsics.checkNotNullParameter(r14, "text");
        Intrinsics.checkNotNullParameter(r21, "paint");
        Drawable r2 = getDrawable();
        r13.save();
        Paint.FontMetricsInt r6 = r21.getFontMetricsInt();
        int r9 = r6.descent;
        int r10 = (r9 + r110) - ((r9 - r6.ascent) / 2);
        r13.translate(r17 + this.e, r10 - ((r2.getBounds().bottom - r2.getBounds().top) / 2));
        r2.draw(r13);
        r13.restore();
        if (this.j == false) goto L14;
        if (r15 < 0) goto L15;
        if (r16 < 0) goto L16;
        if (r15 <= r16) goto L8;
        return;
    L8:
        if (r16 > r14.length()) goto L18;
        r13.save();
        int r7 = this.d;
        if (r7 <= 0) goto L12;
        r21.setTextSize(r7);
    L12:
        float r3 = ((r2.getBounds().right - r2.getBounds().left) / 2) - (r21.measureText(r14.subSequence(r15, r16).toString()) / 2);
        Paint.FontMetricsInt r8 = r21.getFontMetricsInt();
        int r11 = r8.descent;
        r13.translate(this.e + r3, (r10 - r110) - (r11 - ((r11 - r8.ascent) / 2)));
        r21.setColor(this.k);
        r13.drawText(r14, r15, r16, r17, r110, r21);
        r13.restore();
        return;
    L18:
        return;
    L16:
        return;
    L15:
        return;
    }

    public a(Context r2, Drawable r3, int r4, int r5, int r6, int r7, int r8, String r9, String r10, boolean r11, int r12) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "placeHolder");
        Intrinsics.checkNotNullParameter(r9, "avatarKey");
        super(r3);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        r3.setBounds(0, 0, r4, r4);
    }
}
