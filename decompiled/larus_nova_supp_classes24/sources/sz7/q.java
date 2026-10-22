package sz7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q extends Drawable {
    public final Context a;
    public final boolean b;
    public final Object c;
    public Drawable d;
    public int e;
    public int f;
    public ColorFilter g;
    public boolean h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public final int m;

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable r0 = this.d;
        if (this.e > 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L14;
        if (r0 == null) goto L13;
        return r0.getIntrinsicHeight();
    L13:
        return super.getIntrinsicHeight();
    L14:
        return this.f;
    L5:
        if (this.f <= 0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable r0 = this.d;
        int r1 = this.e;
        if (r1 > 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L15;
        if (r0 == null) goto L13;
        return r0.getIntrinsicWidth();
    L13:
        return super.getIntrinsicWidth();
    L15:
        return r1;
    L5:
        if (this.f <= 0) goto L7;
        r2 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable r0 = this.d;
        if (r0 != null) goto L7;
        return -3;
    L7:
        return r0.getOpacity();
    }

    public final int hashCode() {
        int r0 = (((this.e + 31) * 31) + this.f) * 31;
        ColorFilter r2 = this.g;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L6:
        int r1 = (r0 + r3) * 31;
        int r4 = 1231;
        if (this.h == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (((((r1 + r5) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        if (this.k == true) goto L15;
        r4 = 1237;
    L15:
        return r6 + r4;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final Context getContext() {
        return this.a;
    }

    public q(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, false);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        if (this.b == false) goto L17;
        Object r0 = this.c;
        monitor-enter(r0);
        Drawable r1 = this.d;     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        r1.setBounds(getBounds());     // Catch: Throwable -> L14
    L9:
        Drawable r2 = this.d;     // Catch: Throwable -> L14
        if (r2 == null) goto L12;
        r2.draw(r4);     // Catch: Throwable -> L14
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        Drawable r3 = this.d;
        if (r3 == null) goto L20;
        r3.setBounds(getBounds());
    L20:
        Drawable r6 = this.d;
        if (r6 == null) goto L26;
        r6.draw(r4);
        return;
    }

    public final void e(Drawable r4) {
        if (this.b == false) goto L30;
        Object r0 = this.c;
        monitor-enter(r0);
    L26:
        th = move-exception;
        throw th;
    L7:
        if ((r4 instanceof BitmapDrawable) == true) goto L9;
    L13:
        this.d = r4;     // Catch: Throwable -> L26
    L14:
        Drawable r5 = this.d;     // Catch: Throwable -> L26
        if (r5 == null) goto L17;
        r5.setColorFilter(this.g);     // Catch: Throwable -> L26
    L17:
        Drawable r6 = this.d;     // Catch: Throwable -> L26
        if (r6 == null) goto L20;
        r6.setCallback(getCallback());     // Catch: Throwable -> L26
    L20:
        Drawable r7 = this.d;     // Catch: Throwable -> L26
        if (r7 == null) goto L23;
        r7.invalidateSelf();     // Catch: Throwable -> L26
    L23:
        invalidateSelf();     // Catch: Throwable -> L26
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r0);
        return;
    L9:
        if ((r4 instanceof RoundedBitmapDrawable) == true) goto L13;
        if (this.h == false) goto L13;
        RoundedBitmapDrawable r9 = RoundedBitmapDrawableFactory.create(this.a.getResources(), ((BitmapDrawable) r4).getBitmap());     // Catch: Throwable -> L26
        r9.setCircular(true);     // Catch: Throwable -> L26
        this.d = r9;     // Catch: Throwable -> L26
        goto L14
    L30:
        if ((r4 instanceof BitmapDrawable) == true) goto L32;
    L36:
        this.d = r4;
    L37:
        Drawable r10 = this.d;
        if (r10 == null) goto L40;
        r10.setColorFilter(this.g);
    L40:
        Drawable r11 = this.d;
        if (r11 == null) goto L43;
        r11.setCallback(getCallback());
    L43:
        Drawable r12 = this.d;
        if (r12 == null) goto L46;
        r12.invalidateSelf();
    L46:
        invalidateSelf();
        return;
    L32:
        if ((r4 instanceof RoundedBitmapDrawable) == true) goto L36;
        if (this.h == false) goto L36;
        RoundedBitmapDrawable r13 = RoundedBitmapDrawableFactory.create(this.a.getResources(), ((BitmapDrawable) r4).getBitmap());
        r13.setCircular(true);
        this.d = r13;
        goto L37
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(q.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.avatar.IconKeyDrawable");
        q r6 = (q) r5;
        if (this.e == r6.e) goto L16;
        return false;
    L16:
        if (this.f == r6.f) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L22;
        return false;
    L22:
        if (this.h == r6.h) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L31;
        return false;
    L31:
        if (this.k == r6.k) goto L33;
        return false;
    L33:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        Drawable r0 = this.d;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "bounds");
        if (this.b == false) goto L15;
        Object r0 = this.c;
        monitor-enter(r0);
        super.setBounds(r3);     // Catch: Throwable -> L12
        Drawable r1 = this.d;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.setBounds(r3);     // Catch: Throwable -> L12
    L9:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        super.setBounds(r3);
        Drawable r2 = this.d;
        if (r2 == null) goto L21;
        r2.setBounds(r3);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
        this.g = r1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r2) {
        super.setTintList(r2);
        Drawable r0 = this.d;
        if (r0 == null) goto L6;
        r0.setTintList(r2);
        return;
    }

    public q(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.c = new Object();
        this.e = -1;
        this.f = -1;
        this.i = "";
        this.j = "";
        this.m = UIHelper.dp2px(2.0f);
    }

    public static final Drawable a(q r0, Drawable r1, Drawable r2) {
        if (r1 == null) goto L4;
        r0.getClass();
        return r1;
    L4:
        if (r0.l == true) goto L9;
        return null;
    L9:
        return r2;
    }

    public final void b(String r3, int r4, int r5, Drawable r6, boolean r7, Integer r8) {
        this.e = r4;
        this.f = r5;
        String r0 = this.i;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.i = r0;
        String r2 = this.j;
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        this.j = r1;
        this.k = r7;
        if (r3 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        boolean r10 = true ^ r9;
        if (this.l == false) goto L20;
        if (r10 == false) goto L20;
        Drawable r11 = null;
    L21:
        e(r11);
        if (r3 == null) goto L25;
        ImageLoader.with(this.a).load(r3).override(r4, r5).asDrawable().into(new p(r8, this, r6));
        return;
    L25:
        return;
    L20:
        r11 = r6;
        goto L21
    L12:
        if (r3.length() == 0) goto L15;
        r9 = false;
        goto L16
    }

    public static /* synthetic */ void d(q r10, String r11, String r12, int r13, int r14, Drawable r15, boolean r16, Integer r17) {
        r10.c(r11, r12, r13, r14, r15, r16, r17, false, null);
    }

    public final void c(String r15, String r16, int r17, int r19, Drawable r110, boolean r20, Integer r21, boolean r22, Integer r23) {
        this.e = r17;
        this.f = r19;
        if (r15 != null) goto L5;
        String r10 = "";
    L6:
        this.i = r10;
        if (r16 != null) goto L9;
        String r11 = "";
    L10:
        this.j = r11;
        this.k = r20;
        boolean r12 = false;
        if (r22 == true) goto L21;
        if (r15 != null) goto L14;
    L17:
        boolean r13 = true;
    L18:
        if (r13 == false) goto L21;
        boolean r14 = false;
    L23:
        if (this.l == false) goto L26;
        if (r14 == false) goto L26;
        Drawable r111 = null;
    L27:
        e(r111);
        if (r22 != true) goto L30;
        ImageLoader.with(this.a).load(r23).asDrawable().into(new m(r21, this, r110));
        return;
    L30:
        if (r15 != null) goto L32;
        return;
    L32:
        if (r15.length() != 0) goto L34;
        boolean r8 = true;
    L35:
        if (r8 == true) goto L59;
        if (r20 == true) goto L39;
        ImageLoader.with(this.a).load(new EncryptImage(r15)).asDrawable().into(new n(r21, this, r110));
        return;
    L39:
        boolean r6 = v.a;
        if (v.a.a() == false) goto L50;
        int r7 = t.a;
        s r9 = t.a.a(this.a);
        r9.e = r15;
        r9.f = "";
        r9.g = r16;
        r9.c = r17;
        r9.d = r19;
        r9.h = r110;
        o r1 = new o(r21, this, r110);
        Intrinsics.checkNotNullParameter(r1, "target");
        String r2 = r9.e;
        if (r2 != null) goto L44;
    L45:
        r12 = true;
    L46:
        if (r12 == false) goto L48;
        r1.setIcon(r9.h);
        return;
    L48:
        r9.b.b(r9.a, r2, r9.f, r9.g, r9.c, r9.d, new r(r1, r9));
        return;
    L44:
        if (r2.length() != 0) goto L46;
    L50:
        if (this.l == false) goto L58;
        e(r110);
        return;
    L58:
        return;
    L59:
        return;
    L34:
        r8 = false;
    L26:
        r111 = r110;
        goto L27
    L14:
        if (r15.length() == 0) goto L17;
        r13 = false;
    L21:
        r14 = true;
        goto L23
    L9:
        r11 = r16;
        goto L10
    L5:
        r10 = r15;
        goto L6
    }
}
