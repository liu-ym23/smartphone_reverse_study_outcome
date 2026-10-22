package c19;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends Drawable {
    public final c19.b a;
    public final int b;
    public final int c;
    public final boolean d;
    public final List<b> e;
    public final int[] f;
    public int g;
    public boolean h;
    public final C0003c i;

    public static final class a {
        public static int b(String r5, float r6) {
            Intrinsics.checkNotNullParameter(r5, "hex");
            String r7 = StringsKt.removePrefix(r5, "#");
            int r0 = CastIntegerProtector.parseInt(r7.substring(0, 2), CharsKt.checkRadix(16));
            int r1 = CastIntegerProtector.parseInt(r7.substring(2, 4), CharsKt.checkRadix(16));
            int r8 = CastIntegerProtector.parseInt(r7.substring(4, 6), CharsKt.checkRadix(16));
            return Color.argb((int) (RangesKt.coerceIn(r6, 0.0f, 1.0f) * 255.0f), r0, r1, r8);
        }

        public static float[] a(float[] r5, float r6, float r7) {
            Intrinsics.checkNotNullParameter(r5, "m");
            if (r5.length != 6) goto L6;
            return new float[]{((r5[0] * r6) + (r5[2] * r7)) + r5[4], ((r5[1] * r6) + (r5[3] * r7)) + r5[5]};
        L6:
            return new float[]{r6, r7};
        }
    }

    public static final class b {
        public final Path a;
        public final Paint b;
        public final List<Path> c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Path r2, Paint r3, List<? extends Path> r4) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "paint");
            Intrinsics.checkNotNullParameter(r4, "clips");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    /* JADX INFO: renamed from: c19.c$c, reason: collision with other inner class name */
    public static final class C0003c extends Drawable.ConstantState {
        public final /* synthetic */ c a;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            c r1 = this.a;
            return new c(r1.a, r1.b, r1.c, r1.d);
        }

        public C0003c(c r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        b r0 = (b) CollectionsKt.firstOrNull(this.e);
        if (r0 == null) goto L7;
        Paint r1 = r0.b;
        if (r1 == null) goto L7;
        return r1.getColorFilter();
    L7:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Rect r0 = getBounds();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        int r1 = r7.save();
        r7.translate(r0.left, r0.top);
        r7.scale(r0.width() / 24.0f, r0.height() / 24.0f);
        if (this.h == false) goto L18;
        boolean r2 = true;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        if (getLayoutDirection() == 1) goto L16;
    L15:
        r2 = false;
    L16:
        if (r2 == false) goto L18;
        r7.translate(24.0f, 0.0f);
        r7.scale(-1.0f, 1.0f);
        goto L18
    L13:
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L15;
    L18:
        Iterator r3 = ((ArrayList) this.e).iterator();
    L20:
        if (r3.hasNext() == false) goto L29;
        b r4 = (b) r3.next();
        if (r4.c.isEmpty() == true) goto L23;
        int r5 = r7.save();
        Iterator<Path> r6 = r4.c.iterator();
    L26:
        if (r6.hasNext() == false) goto L28;
        r7.clipPath(r6.next());
        goto L26
    L28:
        r7.drawPath(r4.a, r4.b);
        r7.restoreToCount(r5);
        goto L20
    L23:
        r7.drawPath(r4.a, r4.b);
        goto L20
    L29:
        r7.restoreToCount(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int r1) {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r6) {
        int r0 = 0;
        int r7 = RangesKt.coerceIn(r6, 0, 255);
        if (r7 != this.g) goto L5;
        return;
    L5:
        this.g = r7;
        int r2 = this.e.size();
    L6:
        if (r0 >= r2) goto L8;
        ((b) ListProtector.get(this.e, r0)).b.setAlpha((this.f[r0] * r7) / 255);
        r0 = r0 + 1;
        goto L6
    L8:
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        boolean r3 = false;
    L8:
        if (r3 != this.h) goto L10;
        return;
    L10:
        this.h = r3;
        invalidateSelf();
        return;
    L4:
        if (this.d == false) goto L6;
        r3 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r3) {
        Iterator r0 = ((ArrayList) this.e).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).b.setColorFilter(r3);
        goto L4
    L6:
        invalidateSelf();
    }

    public c(c19.b r24, int r25, int r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r24, "desc");
        this.a = r24;
        this.b = r25;
        this.c = r26;
        this.d = r27;
        List<h> r1 = r24.a;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L3:
        int r4 = 0;
        if (r3.hasNext() == false) goto L39;
        h r5 = (h) r3.next();
        ArrayList r6 = new ArrayList(2);
        d r7 = r5.b;
        if (r7 == null) goto L38;
        Path r9 = r5.a;
        int r10 = this.b;
        Intrinsics.checkNotNullParameter(r7, "fill");
        Paint r12 = new Paint(1);
        r12.setStyle(Paint.Style.FILL);
        Intrinsics.checkNotNullParameter(r12, "paint");
        Intrinsics.checkNotNullParameter(r7, "fill");
        if ((r7 instanceof d.C0004d) == false) goto L11;
        r12.setColor(Color.argb((int) (Color.alpha(r10) * RangesKt.coerceIn(((d.C0004d) r7).a, 0.0f, 1.0f)), Color.red(r10), Color.green(r10), Color.blue(r10)));
    L31:
        r6.add(new b(r9, r12, r5.c));
        goto L38
    L11:
        if ((r7 instanceof d.c) == false) goto L14;
        d.c r8 = (d.c) r7;
        r12.setColor(a.b(r8.a, r8.b));
        goto L31
    L14:
        if ((r7 instanceof d.a) == false) goto L33;
        d.a r11 = (d.a) r7;
        if (r11.f.size() >= 2) goto L22;
        List<j> r13 = r11.f;
        float r14 = r11.g;
        Intrinsics.checkNotNullParameter(r13, "stops");
        if (r13.isEmpty() == true) goto L21;
        r10 = a.b(((j) ListProtector.get(r13, 0)).b, ((j) ListProtector.get(r13, 0)).c * r14);
    L21:
        r12.setColor(r10);
        goto L31
    L22:
        float[] r15 = a.a(r11.e, r11.a, r11.b);
        float[] r16 = a.a(r11.e, r11.c, r11.d);
        float r17 = r15[0];
        float r18 = r15[1];
        float r110 = r16[0];
        float r111 = r16[1];
        List<j> r20 = r11.f;
        float r21 = r11.g;
        Intrinsics.checkNotNullParameter(r20, "stops");
        List<j> r22 = r20;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r23 = r22.iterator();
    L24:
        if (r23.hasNext() == false) goto L26;
        j r113 = (j) r23.next();
        r112.add(Integer.valueOf(a.b(r113.b, r113.c * r21)));
        goto L24
    L26:
        int[] r28 = CollectionsKt.toIntArray(r112);
        List<j> r30 = r11.f;
        Intrinsics.checkNotNullParameter(r30, "stops");
        List<j> r31 = r30;
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));
        Iterator<T> r33 = r31.iterator();
    L28:
        if (r33.hasNext() == false) goto L30;
        r32.add(Float.valueOf(((j) r33.next()).a));
        goto L28
    L30:
        r12.setShader(new LinearGradient(r17, r18, r110, r111, r28, CollectionsKt.toFloatArray(r32), Shader.TileMode.CLAMP));
        goto L31
    L33:
        if ((r7 instanceof d.b) == false) goto L37;
        d.b r34 = (d.b) r7;
        throw null;
    L37:
        throw new NoWhenBranchMatchedException();
    L38:
        CollectionsKt.addAll(r2, r6);
        goto L3
    L39:
        this.e = r2;
        int r35 = r2.size();
        int[] r36 = new int[r35];
    L40:
        if (r4 >= r35) goto L42;
        r36[r4] = ((b) ListProtector.get(this.e, r4)).b.getAlpha();
        r4 = r4 + 1;
        goto L40
    L42:
        this.f = r36;
        this.g = 255;
        this.h = this.d;
        this.i = new C0003c(this);
    }
}
