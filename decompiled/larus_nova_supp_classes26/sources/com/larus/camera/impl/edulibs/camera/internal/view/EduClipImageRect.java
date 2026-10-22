package com.larus.camera.impl.edulibs.camera.internal.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class EduClipImageRect {
    public final mx8.a a;
    public final b b;
    public final Paint c;
    public final Paint d;
    public int e;
    public a f;
    public final List<a> g;
    public boolean h;
    public final Bitmap[] i;
    public c j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipImageRect$Location;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_RIGHT", "BOTTOM_LEFT", "LEFT", "TOP", "RIGHT", "BOTTOM", "CENTER", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Location extends Enum<Location> {
        public static final Location BOTTOM = null;
        public static final Location BOTTOM_LEFT = null;
        public static final Location BOTTOM_RIGHT = null;
        public static final Location CENTER = null;
        public static final a Companion = null;
        public static final Location LEFT = null;
        public static final Location RIGHT = null;
        public static final Location TOP = null;
        public static final Location TOP_LEFT = null;
        public static final Location TOP_RIGHT = null;
        public static final /* synthetic */ Location[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Location> getEntries() {
            return b;
        }

        static {
            Location r0 = new Location("TOP_LEFT", 0);
            TOP_LEFT = r0;
            Location r1 = new Location("TOP_RIGHT", 1);
            TOP_RIGHT = r1;
            Location r3 = new Location("BOTTOM_RIGHT", 2);
            BOTTOM_RIGHT = r3;
            Location r5 = new Location("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r5;
            Location r7 = new Location("LEFT", 4);
            LEFT = r7;
            Location r9 = new Location("TOP", 5);
            TOP = r9;
            Location r11 = new Location("RIGHT", 6);
            RIGHT = r11;
            Location r13 = new Location("BOTTOM", 7);
            BOTTOM = r13;
            Location r15 = new Location("CENTER", 8);
            CENTER = r15;
            Location[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
            a = r14;
            b = EnumEntriesKt.enumEntries(r14);
            Companion = new a();
        }

        public static Location[] values() {
            return (Location[]) a.clone();
        }

        public static Location valueOf(String r1) {
            return (Location) r27.a.a(Location.class, r1);
        }

        public Location(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final float a;
        public final float b;
        public final float c;
        public final RectF d;
        public final RectF e;
        public final RectF f;
        public final RectF[] g;
        public final RectF[] h;
        public final Path i;
        public final Path j;
        public final RectF k;
        public final Matrix[] l;
        public boolean m;

        public final void b(Matrix r8) {
            Intrinsics.checkNotNullParameter(r8, "matrix");
            r8.mapRect(this.e, this.d);
            this.f.set(this.e);
            RectF r9 = this.f;
            float r0 = -this.b;
            r9.inset(r0, r0);
            int r10 = this.g.length;
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r10) goto L13;
            if ((r2 % 3) != 0) goto L8;
            float r3 = this.f.left;
        L9:
            if (r2 > 1) goto L11;
            float r4 = this.f.top;
        L12:
            RectF r5 = this.g[r2];
            float r6 = this.a;
            r5.set(r3, r4, r3 + r6, r6 + r4);
            r2 = r2 + 1;
            goto L4
        L11:
            r4 = this.f.bottom - this.a;
            goto L12
        L8:
            r3 = this.f.right - this.a;
            goto L9
        L13:
            int r11 = this.h.length;
        L14:
            if (r1 >= r11) goto L27;
            RectF r7 = this.h[r1];
            r7.set(this.e);
            if (r1 == 0) goto L25;
            if (r1 == 1) goto L24;
            if (r1 != 2) goto L20;
            r7.left = r7.right;
            r7.inset((-this.c) / 2, 0.0f);
        L26:
            r1 = r1 + 1;
            goto L14
        L20:
            if (r1 != 3) goto L26;
            r7.top = r7.bottom;
            r7.inset(0.0f, (-this.c) / 2);
            goto L26
        L24:
            r7.bottom = r7.top;
            r7.inset(0.0f, (-this.c) / 2);
            goto L26
        L25:
            r7.right = r7.left;
            r7.inset((-this.c) / 2, 0.0f);
            goto L26
        }

        public final Location a(float r10, float r11) {
            RectF[] r0 = this.g;
            int r1 = r0.length;
            boolean r2 = false;
            int r3 = 0;
        L3:
            int r4 = -1;
            if (r3 >= r1) goto L9;
            if (r0[r3].contains(r10, r11) == true) goto L10;
            r3 = r3 + 1;
        L10:
            Integer r5 = Integer.valueOf(r3);
            if (r5.intValue() < 0) goto L13;
            boolean r6 = true;
        L14:
            Location r7 = null;
            if (r6 == true) goto L18;
            r5 = null;
        L18:
            if (r5 != null) goto L33;
            RectF[] r8 = this.h;
            int r9 = r8.length;
            int r12 = 0;
        L20:
            if (r12 >= r9) goto L25;
            if (r8[r12].contains(r10, r11) == true) goto L23;
            r12 = r12 + 1;
            goto L20
        L23:
            r4 = r12;
        L25:
            Integer r13 = Integer.valueOf(r4);
            if (r13.intValue() < 0) goto L28;
            r2 = true;
        L28:
            if (r2 == true) goto L31;
            r13 = null;
        L31:
            if (r13 == null) goto L33;
            r5 = Integer.valueOf(r13.intValue() + this.g.length);
        L33:
            if (r5 == null) goto L35;
        L37:
            Location.Companion.getClass();
            if (r5 == null) goto L44;
            Location r14 = (Location) ArraysKt.getOrNull(Location.values(), r5.intValue());
            if (r14 == null) goto L44;
            r7 = r14;
        L44:
            return r7;
        L35:
            if (this.e.contains(r10, r11) == false) goto L37;
            return Location.CENTER;
        L13:
            r6 = false;
            goto L14
        L9:
            r3 = -1;
            goto L10
        }

        public a(float r3, float r4, float r5) {
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = new RectF();
            this.e = new RectF();
            this.f = new RectF();
            RectF[] r6 = new RectF[4];
            int r7 = 0;
            int r0 = 0;
        L3:
            if (r0 >= 4) goto L5;
            r6[r0] = new RectF();
            r0 = r0 + 1;
            goto L3
        L5:
            this.g = r6;
            RectF[] r8 = new RectF[4];
            int r1 = 0;
        L6:
            if (r1 >= 4) goto L8;
            r8[r1] = new RectF();
            r1 = r1 + 1;
            goto L6
        L8:
            this.h = r8;
            this.i = new Path();
            this.j = new Path();
            this.k = new RectF();
            Matrix[] r9 = new Matrix[4];
        L9:
            if (r7 >= 4) goto L11;
            r9[r7] = new Matrix();
            r7 = r7 + 1;
            goto L9
        L11:
            this.l = r9;
        }
    }

    public static final class b {
        public final Bitmap a;
        public float b;
        public final int c;
        public final int d;
        public final float e;
        public final float f;
        public final float g;
        public final float h;
        public final float i;
        public final int j;

        public b(Bitmap r1, float r2, int r3, int r4, float r5, float r6, float r7, float r8, float r9, int r10) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }
    }

    public static final class c {
        public final Location a;
        public final float b;
        public final a c;
        public final RectF d;
        public float e;
        public float f;
        public final RectF g;
        public final RectF h;

        public c(Location r2, float r3, a r4, RectF r5, float r6, float r7) {
            Intrinsics.checkNotNullParameter(r2, "moveType");
            Intrinsics.checkNotNullParameter(r4, "rectHolder");
            Intrinsics.checkNotNullParameter(r5, "bound");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r4.e;
            this.h = new RectF();
        }
    }

    public final void a(Function1<? super a, Unit> r3) {
        if (this.h == false) goto L8;
        Iterator r0 = ((ArrayList) this.g).iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        r3.invoke((a) r0.next());
        goto L6
    L14:
        return;
    L8:
        a r1 = this.f;
        if (r1 == null) goto L13;
        r3.invoke(r1);
        return;
    }

    public final void c(boolean r14) {
        Matrix r0 = this.a.d;
        Iterator r1 = ((ArrayList) this.g).iterator();
    L4:
        if (r1.hasNext() == false) goto L20;
        a r2 = (a) r1.next();
        r2.b(r0);
        RectF r3 = b(this, r2.e, r14);
        if (Intrinsics.areEqual(r2.e, r3) == true) goto L8;
        r2.e.set(r3);
        Matrix r4 = this.a.e;
        Intrinsics.checkNotNullParameter(r4, "invertMatrix");
        r4.mapRect(r2.d, r2.e);
    L8:
        Matrix r5 = new Matrix();
        r2.i.reset();
        r2.j.reset();
        RectF r6 = new RectF(r2.d);
        r5.reset();
        mx8.a r7 = this.a;
        float r8 = r7.j / 2.0f;
        float r9 = r7.k / 2.0f;
        float r10 = r7.b;
        r5.postScale(r10, r10, r8, r9);
        r5.postTranslate((r7.h / 2.0f) - r8, (r7.i / 2.0f) - r9);
        r5.mapRect(r6);
        Path r11 = r2.i;
        float r12 = this.b.b;
        r11.addRoundRect(r6, r12, r12, Path.Direction.CW);
        float r13 = this.b.i / 2.0f;
        r6.inset(Math.min(r6.width() / 2.0f, r13), Math.min(r6.height() / 2.0f, r13));
        Path r15 = r2.j;
        float r16 = this.b.b;
        r15.addRoundRect(r6, r16, r16, Path.Direction.CW);
        r5.reset();
        mx8.a r17 = this.a;
        r5.postRotate(r17.c, r17.h / 2.0f, r17.i / 2.0f);
        r2.i.transform(r5);
        r2.j.transform(r5);
        Bitmap[] r18 = this.i;
        if (r18 != null) goto L11;
    L17:
        boolean r19 = true;
    L18:
        if (r19 == true) goto L4;
        int r20 = r18[0].getWidth();
        int r21 = this.i[0].getHeight();
        r2.k.set(r2.d);
        r5.reset();
        mx8.a r22 = this.a;
        float r110 = r22.j / 2.0f;
        float r111 = r22.k / 2.0f;
        float r112 = r22.b;
        r5.postScale(r112, r112, r110, r111);
        r5.postTranslate((r22.h / 2.0f) - r110, (r22.i / 2.0f) - r111);
        r5.mapRect(r2.k);
        RectF r23 = r2.k;
        float r24 = -this.b.c;
        r23.inset(r24, r24);
        RectF r25 = r2.k;
        r25.right -= r20;
        r25.bottom -= r21;
        Matrix r26 = r2.l[0];
        r26.reset();
        RectF r27 = r2.k;
        r26.setTranslate(r27.left, r27.top);
        mx8.a r28 = this.a;
        r26.postRotate(r28.c, r28.h / 2.0f, r28.i / 2.0f);
        Matrix r29 = r2.l[1];
        r29.reset();
        RectF r30 = r2.k;
        r29.setTranslate(r30.right, r30.top);
        mx8.a r31 = this.a;
        r29.postRotate(r31.c, r31.h / 2.0f, r31.i / 2.0f);
        Matrix r32 = r2.l[2];
        r32.reset();
        RectF r33 = r2.k;
        r32.setTranslate(r33.right, r33.bottom);
        mx8.a r34 = this.a;
        r32.postRotate(r34.c, r34.h / 2.0f, r34.i / 2.0f);
        Matrix r35 = r2.l[3];
        r35.reset();
        RectF r36 = r2.k;
        r35.setTranslate(r36.left, r36.bottom);
        mx8.a r37 = this.a;
        r35.postRotate(r37.c, r37.h / 2.0f, r37.i / 2.0f);
        goto L4
    L11:
        if (r18.length != 0) goto L13;
        boolean r38 = true;
    L14:
        if (r38 == true) goto L17;
        r19 = false;
        goto L18
    L13:
        r38 = false;
        goto L14
    }

    public EduClipImageRect(mx8.a r11, b r12) {
        Intrinsics.checkNotNullParameter(r11, "drawHelper");
        Intrinsics.checkNotNullParameter(r12, "config");
        this.a = r11;
        this.b = r12;
        Paint r13 = new Paint();
        r13.setAlpha(255);
        this.c = r13;
        Paint r14 = new Paint();
        r14.setStrokeWidth(r12.i);
        r14.setColor(r12.j);
        this.d = r14;
        this.e = r12.d;
        this.g = new ArrayList();
        Matrix r15 = new Matrix();
        Bitmap r16 = r12.a;
        if (r16 == null) goto L10;
        Bitmap[] r8 = new Bitmap[4];
        int r9 = 0;
    L5:
        if (r9 >= 4) goto L11;
        if (r9 != 0) goto L8;
        Bitmap r0 = r16;
    L9:
        r8[r9] = r0;
        r9 = r9 + 1;
        goto L5
    L8:
        r15.postRotate(90.0f);
        r0 = Bitmap.createBitmap(r16, 0, 0, r16.getWidth(), r16.getHeight(), r15, true);
        Intrinsics.checkNotNull(r0);
    L11:
        this.i = r8;
        return;
    L10:
        r8 = null;
        goto L11
    }

    public static RectF b(EduClipImageRect r4, RectF r5, boolean r6) {
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "showedRect");
        RectF r0 = new RectF();
        r0.set(r5);
        if (r0.width() >= r4.b.h) goto L6;
        r0.inset((r0.width() - r4.b.h) / 2, 0.0f);
    L6:
        if (r0.height() >= r4.b.h) goto L8;
        r0.inset(0.0f, (r0.height() - r4.b.h) / 2);
    L8:
        if (r6 == false) goto L21;
        RectF r7 = new RectF(r4.a.g);
        float r8 = r4.b.c;
        r7.inset(r8, r8);
        float r9 = r0.left;
        float r10 = r7.left;
        if (r9 >= r10) goto L12;
        r0.left = r10;
    L12:
        float r11 = r0.right;
        float r12 = r7.right;
        if (r11 <= r12) goto L15;
        r0.right = r12;
    L15:
        float r13 = r0.top;
        float r14 = r7.top;
        if (r13 >= r14) goto L18;
        r0.top = r14;
    L18:
        float r15 = r0.bottom;
        float r16 = r7.bottom;
        if (r15 <= r16) goto L21;
        r0.bottom = r16;
    L21:
        return r0;
    }
}
