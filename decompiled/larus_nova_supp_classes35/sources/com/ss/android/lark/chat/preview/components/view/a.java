package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.BorderProperty;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends ImageSpan {
    public final Context a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final Drawable i;
    public final ThemeColor j;
    public boolean k;
    public InterfaceC0108a l;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.components.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC0108a {
        void a();

        void onLoadFailed();
    }

    public static final class b extends SimpleTarget<Drawable> {
        public final WeakReference<a> a;
        public final int b;
        public final int c;

        public final void onLoadFailed(Drawable r5) {
            Intrinsics.checkNotNullParameter(r5, "errorDrawable");
            super.onLoadFailed(r5);
            a r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            r5.setBounds(0, 0, this.b, this.c);
            com.ss.android.lark.image.utils.e.b(r0, "mDrawable", r5);
            com.ss.android.lark.image.utils.e.b(r0, "mDrawableRef", null);
            if (r0.k == true) goto L10;
            InterfaceC0108a r6 = r0.l;
            if (r6 == null) goto L10;
            r6.onLoadFailed();
        L10:
            r0.k = true;
        }

        public final void onResourceReady(Object r11) {
            Drawable r12 = (Drawable) r11;
            Intrinsics.checkNotNullParameter(r12, "resource");
            super.onResourceReady(r12);
            a r0 = this.a.get();
            if (r0 == null) goto L28;
            a r1 = this.a.get();
            if (r1 == null) goto L14;
            ThemeColor r2 = r1.j;
            if (r2 == null) goto L14;
            r12.mutate();
            a r3 = this.a.get();
            if (r3 == null) goto L12;
            Context r4 = r3.getContext();
        L13:
            Intrinsics.checkNotNull(r4);
            r12.setTint(com.ss.android.lark.export.entity.preview.a.a(r2, r4, null));
            goto L14
        L12:
            r4 = null;
        L14:
            a r5 = this.a.get();
            if (r5 == null) goto L23;
            Context r6 = r5.getContext();
            if (r6 == null) goto L23;
            Resources r7 = r6.getResources();
            if (r7 == null) goto L23;
            if ((r12 instanceof BitmapDrawable) == false) goto L23;
            r12 = new e(r7, (BitmapDrawable) r12, new BorderProperty(0, 0, UIHelper.dp2px(2.0f)), this.b, this.c);
        L23:
            r12.setBounds(0, 0, this.b, this.c);
            com.ss.android.lark.image.utils.e.b(r0, "mDrawable", r12);
            com.ss.android.lark.image.utils.e.b(r0, "mDrawableRef", null);
            r0.k = true;
            InterfaceC0108a r13 = r0.l;
            if (r13 == null) goto L27;
            r13.a();
            return;
        L27:
            return;
        }

        public b(WeakReference<a> r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "drawableSpanRef");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        if (TextUtils.isEmpty(this.b) == false) goto L11;
        if (TextUtils.isEmpty(this.c) == false) goto L11;
        if (TextUtils.isEmpty(this.d) == false) goto L11;
        return super.getDrawable();
    L11:
        if (this.k == true) goto L57;
        String r0 = this.d;
        boolean r1 = true;
        if (r0 != null) goto L15;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == true) goto L31;
        int r3 = edb.a.a;
        int r4 = edb.a.a(this.d);
        if (r4 == 0) goto L57;
        Drawable r5 = this.a.getResources().getDrawable(r4, null);
        if (r5 != null) goto L25;
    L27:
        Intrinsics.checkNotNull(r5);
        r5.setBounds(0, 0, this.e, this.f);
        com.ss.android.lark.image.utils.e.b(this, "mDrawable", r5);
        com.ss.android.lark.image.utils.e.b(this, "mDrawableRef", null);
        InterfaceC0108a r6 = this.l;
        if (r6 == null) goto L30;
        r6.a();
    L30:
        this.k = true;
        goto L57
    L25:
        if (this.j == null) goto L27;
        r5.mutate();
        ThemeColor r7 = this.j;
        Intrinsics.checkNotNull(r7);
        r5.setTint(com.ss.android.lark.export.entity.preview.a.a(r7, this.a, null));
        goto L27
    L31:
        IRequestCreator r8 = ImageLoader.with(this.a);
        String r9 = this.b;
        if (r9 != null) goto L34;
    L37:
        boolean r10 = true;
    L38:
        if (r10 == false) goto L52;
        String r11 = this.c;
        if (r11 != null) goto L42;
    L45:
        if (r1 == true) goto L47;
        IRequestCreator r12 = r8.load(this.c).diskCacheStrategy(DiskCacheStrategy.RESULT);
        g6b.a.InterfaceC0223a r13 = g6b.a.a;
        if (r13 == null) goto L51;
        r13.c();
    L51:
        r12.isAsync(false).placeholder(this.i).centerCrop().dontAnimate(false).override(this.e, this.f).into(new b(new WeakReference(this), this.e, this.f));
        goto L57
    L47:
        return super.getDrawable();
    L42:
        if (r11.length() == 0) goto L45;
        r1 = false;
        goto L45
    L52:
        String r14 = this.b;
        Intrinsics.checkNotNull(r14);
        IRequestCreator r15 = r8.load(new EncryptImage(r14));
        g6b.a.InterfaceC0223a r16 = g6b.a.a;
        if (r16 == null) goto L55;
        r16.c();
    L55:
        r15.isAsync(false).placeholder(this.i).centerCrop().dontAnimate(false).override(this.e, this.f).into(new b(new WeakReference(this), this.e, this.f));
        goto L57
    L34:
        if (r9.length() == 0) goto L37;
        r10 = false;
        goto L38
    L15:
        if (r0.length() == 0) goto L18;
        r2 = false;
    L57:
        return super.getDrawable();
    }

    public final Context getContext() {
        return this.a;
    }

    public /* synthetic */ a(Context r8, int r9, int r10, int r11, Drawable r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
        Intrinsics.checkNotNullParameter(r1, "paint");
        Rect r6 = getDrawable().getBounds();
        if (r5 == null) goto L6;
        Paint.FontMetricsInt r7 = r1.getFontMetricsInt();
        int r8 = r7.bottom - r7.top;
        int r9 = (r6.bottom - r6.top) / 2;
        int r10 = r8 / 4;
        int r11 = r9 - r10;
        int r12 = -(r9 + r10);
        r5.ascent = r12;
        r5.top = r12;
        r5.bottom = r11;
        r5.descent = r11;
    L6:
        return (this.g + this.e) + this.h;
    }

    public a(Context r2, int r3, int r4, int r5, Drawable r6, ThemeColor r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "placeHolder");
        super(r6);
        this.a = r2;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = 0;
        this.i = r6;
        this.j = r7;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        float r10 = this.g + r5;
        Paint.FontMetricsInt r11 = r9.getFontMetricsInt();
        int r12 = r8 - r6;
        int r13 = r11.bottom - r11.top;
        if (r12 <= r13) goto L5;
        int r14 = (r12 - r13) / 2;
    L6:
        int r15 = (r6 + r14) + ((r12 - getDrawable().getBounds().height()) / 2);
        r1.save();
        r1.translate(r10, r15);
        getDrawable().draw(r1);
        r1.restore();
        return;
    L5:
        r14 = 0;
        goto L6
    }
}
