package x9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f13744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f13748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f13749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f13750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f13751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f13752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f13753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f13754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f13755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Typeface f13757n;

    public class a extends z.f.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ android.support.v4.media.a f13758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f13759b;

        public a(d r8, android.support.v4.media.a r10) {
            this.f13759b = r8;
            this.f13758a = r10;
        }

        @Override // z.f.e
        public final void c(int r8) {
            this.f13759b.f13756m = true;
            this.f13758a.q(r8);
        }

        @Override // z.f.e
        public final void d(Typeface r8) {
            d r10 = this.f13759b;
            r10.f13757n = Typeface.create(r8, r10.f13746c);
            r10.f13756m = true;
            Typeface r11 = r10.f13757n;
            this.f13758a.r(r11, false);
        }
    }

    public d(Context r8, int r10) {
        this.f13756m = false;
        TypedArray r11 = r8.obtainStyledAttributes(r10, g9.a.f7785z);
        this.f13754k = r11.getDimension(0, 0.0f);
        this.f13753j = c.a(r8, r11, 3);
        c.a(r8, r11, 4);
        c.a(r8, r11, 5);
        this.f13746c = r11.getInt(2, 0);
        this.f13747d = r11.getInt(1, 1);
        int r12 = 12;
        if (r11.hasValue(12) == true) goto L6;
        r12 = 10;
    L6:
        this.f13755l = r11.getResourceId(r12, 0);
        this.f13745b = r11.getString(r12);
        r11.getBoolean(14, false);
        this.f13744a = c.a(r8, r11, 6);
        this.f13748e = r11.getFloat(7, 0.0f);
        this.f13749f = r11.getFloat(8, 0.0f);
        this.f13750g = r11.getFloat(9, 0.0f);
        r11.recycle();
        TypedArray r13 = r8.obtainStyledAttributes(r10, g9.a.f7777r);
        this.f13751h = r13.hasValue(0);
        this.f13752i = r13.getFloat(0, 0.0f);
        r13.recycle();
    }

    public final void a() {
        Typeface r8 = this.f13757n;
        int r10 = this.f13746c;
        if (r8 != null) goto L8;
        String r11 = this.f13745b;
        if (r11 == null) goto L8;
        this.f13757n = Typeface.create(r11, r10);
    L8:
        if (this.f13757n != null) goto L21;
        int r12 = this.f13747d;
        if (r12 != 1) goto L12;
        Typeface r13 = Typeface.SANS_SERIF;
    L19:
        this.f13757n = r13;
        this.f13757n = Typeface.create(this.f13757n, r10);
        return;
    L12:
        if (r12 != 2) goto L14;
        r13 = Typeface.SERIF;
        goto L19
    L14:
        if (r12 == 3) goto L16;
        r13 = Typeface.DEFAULT;
        goto L19
    L16:
        r13 = Typeface.MONOSPACE;
        goto L19
    }

    public final Typeface b(Context r8) {
        if (this.f13756m == false) goto L7;
        return this.f13757n;
    L7:
        if (r8.isRestricted() == false) goto L17;
    L14:
        a();
        this.f13756m = true;
        return this.f13757n;
    L17:
        Typeface r10 = z.f.a(r8, this.f13755l);     // Catch: Exception -> L12 Throwable -> L16
        this.f13757n = r10;     // Catch: Exception -> L12 Throwable -> L16
        if (r10 == null) goto L14;
        this.f13757n = Typeface.create(r10, this.f13746c);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Log.d("TextAppearance", "Error loading font " + this.f13745b, e);
        goto L14
    }

    public final void c(Context r10, android.support.v4.media.a r11) {
        if (d(r10) == false) goto L5;
        b(r10);
    L6:
        int r8 = this.f13755l;
        if (r8 != 0) goto L10;
        this.f13756m = true;
    L10:
        if (this.f13756m == false) goto L23;
        r11.r(this.f13757n, true);
        return;
    L23:
        a r12 = new a(this, r11);     // Catch: Exception -> L18 Resources.NotFoundException -> L20
        ThreadLocal<TypedValue> r13 = z.f.f14146a;     // Catch: Exception -> L18 Resources.NotFoundException -> L20
        if (r10.isRestricted() == false) goto L16;
        r12.a(-4);     // Catch: Exception -> L18 Resources.NotFoundException -> L20
    L22:
        return;
    L16:
        z.f.b(r10, r8, new TypedValue(), 0, r12, false, false);     // Catch: Exception -> L18 Resources.NotFoundException -> L20
    L20:
        this.f13756m = true;
        r11.q(1);
        return;
    L18:
        e = move-exception;
        Log.d("TextAppearance", "Error loading font " + this.f13745b, e);
        this.f13756m = true;
        r11.q(-3);
        return;
    L5:
        a();
        goto L6
    }

    public final boolean d(Context r8) {
        int r10 = this.f13755l;
        if (r10 == 0) goto L8;
        ThreadLocal<TypedValue> r11 = z.f.f14146a;
        if (r8.isRestricted() == true) goto L8;
        Typeface r12 = z.f.b(r8, r10, new TypedValue(), 0, null, false, true);
    L9:
        if (r12 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r12 = null;
        goto L9
    }

    public final void e(Context r8, TextPaint r10, android.support.v4.media.a r11) {
        f(r8, r10, r11);
        ColorStateList r12 = this.f13753j;
        if (r12 == null) goto L5;
        int r13 = r12.getColorForState(r10.drawableState, r12.getDefaultColor());
    L6:
        r10.setColor(r13);
        ColorStateList r14 = this.f13744a;
        if (r14 == null) goto L9;
        int r15 = r14.getColorForState(r10.drawableState, r14.getDefaultColor());
    L10:
        r10.setShadowLayer(this.f13750g, this.f13748e, this.f13749f, r15);
        return;
    L9:
        r15 = 0;
        goto L10
    L5:
        r13 = -16777216;
        goto L6
    }

    public final void f(Context r8, TextPaint r10, android.support.v4.media.a r11) {
        if (d(r8) == false) goto L5;
        g(r8, r10, b(r8));
        return;
    L5:
        a();
        g(r8, r10, this.f13757n);
        c(r8, new e(this, r8, r10, r11));
    }

    public final void g(Context r8, TextPaint r10, Typeface r11) {
        Typeface r12 = f.a(r8.getResources().getConfiguration(), r11);
        if (r12 == null) goto L5;
        r11 = r12;
    L5:
        r10.setTypeface(r11);
        int r13 = (~r11.getStyle()) & this.f13746c;
        if ((r13 & 1) == 0) goto L8;
        boolean r14 = true;
    L9:
        r10.setFakeBoldText(r14);
        if ((r13 & 2) == 0) goto L12;
        float r15 = -0.25f;
    L13:
        r10.setTextSkewX(r15);
        r10.setTextSize(this.f13754k);
        if (this.f13751h == false) goto L17;
        r10.setLetterSpacing(this.f13752i);
        return;
    L17:
        return;
    L12:
        r15 = 0.0f;
        goto L13
    L8:
        r14 = false;
        goto L9
    }
}
