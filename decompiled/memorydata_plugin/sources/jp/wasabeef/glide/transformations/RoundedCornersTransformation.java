package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes6.dex */
public class RoundedCornersTransformation extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17196b;
    private final int c;
    private final int d;
    private final CornerType e;

    /* JADX INFO: renamed from: jp.wasabeef.glide.transformations.RoundedCornersTransformation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17197a = null;

        static {
            int[] r0 = new int[CornerType.values().length];
            f17197a = r0;
            r0[CornerType.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L54:
            f17197a[CornerType.TOP_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L38:
            f17197a[CornerType.TOP_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L50:
            f17197a[CornerType.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L56:
            f17197a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L40:
            f17197a[CornerType.TOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L44:
            f17197a[CornerType.BOTTOM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L62:
            f17197a[CornerType.LEFT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L34:
            f17197a[CornerType.RIGHT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L58:
            f17197a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L60:
            f17197a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L46:
            f17197a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L52:
            f17197a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L36:
            f17197a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L42:
            f17197a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public static final enum CornerType extends Enum<CornerType> {
        private static final /* synthetic */ CornerType[] $VALUES = null;
        public static final CornerType ALL = null;
        public static final CornerType BOTTOM = null;
        public static final CornerType BOTTOM_LEFT = null;
        public static final CornerType BOTTOM_RIGHT = null;
        public static final CornerType DIAGONAL_FROM_TOP_LEFT = null;
        public static final CornerType DIAGONAL_FROM_TOP_RIGHT = null;
        public static final CornerType LEFT = null;
        public static final CornerType OTHER_BOTTOM_LEFT = null;
        public static final CornerType OTHER_BOTTOM_RIGHT = null;
        public static final CornerType OTHER_TOP_LEFT = null;
        public static final CornerType OTHER_TOP_RIGHT = null;
        public static final CornerType RIGHT = null;
        public static final CornerType TOP = null;
        public static final CornerType TOP_LEFT = null;
        public static final CornerType TOP_RIGHT = null;

        static {
            CornerType r0 = new CornerType("ALL", 0);
            ALL = r0;
            CornerType r1 = new CornerType("TOP_LEFT", 1);
            TOP_LEFT = r1;
            CornerType r3 = new CornerType("TOP_RIGHT", 2);
            TOP_RIGHT = r3;
            CornerType r5 = new CornerType("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r5;
            CornerType r7 = new CornerType("BOTTOM_RIGHT", 4);
            BOTTOM_RIGHT = r7;
            CornerType r9 = new CornerType("TOP", 5);
            TOP = r9;
            CornerType r11 = new CornerType("BOTTOM", 6);
            BOTTOM = r11;
            CornerType r13 = new CornerType("LEFT", 7);
            LEFT = r13;
            CornerType r15 = new CornerType("RIGHT", 8);
            RIGHT = r15;
            CornerType r14 = new CornerType("OTHER_TOP_LEFT", 9);
            OTHER_TOP_LEFT = r14;
            CornerType r12 = new CornerType("OTHER_TOP_RIGHT", 10);
            OTHER_TOP_RIGHT = r12;
            CornerType r10 = new CornerType("OTHER_BOTTOM_LEFT", 11);
            OTHER_BOTTOM_LEFT = r10;
            CornerType r8 = new CornerType("OTHER_BOTTOM_RIGHT", 12);
            OTHER_BOTTOM_RIGHT = r8;
            CornerType r6 = new CornerType("DIAGONAL_FROM_TOP_LEFT", 13);
            DIAGONAL_FROM_TOP_LEFT = r6;
            CornerType r4 = new CornerType("DIAGONAL_FROM_TOP_RIGHT", 14);
            DIAGONAL_FROM_TOP_RIGHT = r4;
            $VALUES = new CornerType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        }

        private CornerType(String r1, int r2) {
            super(r1, r2);
        }

        public static CornerType valueOf(String r2) {
            return (CornerType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CornerType.class, r2), CornerType.class, "com.obric.memorydata.plugin");
        }

        public static CornerType[] values() {
            return (CornerType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CornerType[].class, "com.obric.memorydata.plugin");
        }
    }

    private void a(Canvas r4, Paint r5, float r6, float r7) {
        int r0 = this.d;
        float r8 = r6 - r0;
        float r9 = r7 - r0;
        switch(AnonymousClass1.f17197a[this.e.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L4;
        };
    L4:
        int r1 = this.d;
        RectF r2 = new RectF(r1, r1, r8, r9);
    L20:
        int r3 = this.f17196b;
        r4.drawRoundRect(r2, r3, r3, r5);
        return;
    L5:
        o(r4, r5, r8, r9);
        return;
    L6:
        n(r4, r5, r8, r9);
        return;
    L7:
        m(r4, r5, r8, r9);
        return;
    L8:
        l(r4, r5, r8, r9);
        return;
    L9:
        k(r4, r5, r8, r9);
        return;
    L10:
        j(r4, r5, r8, r9);
        return;
    L11:
        i(r4, r5, r8, r9);
        return;
    L12:
        h(r4, r5, r8, r9);
        return;
    L13:
        g(r4, r5, r8, r9);
        return;
    L14:
        f(r4, r5, r8, r9);
        return;
    L15:
        e(r4, r5, r8, r9);
        return;
    L16:
        d(r4, r5, r8, r9);
        return;
    L17:
        c(r4, r5, r8, r9);
        return;
    L18:
        b(r4, r5, r8, r9);
        return;
    L19:
        int r10 = this.d;
        r2 = new RectF(r10, r10, r8, r9);
        goto L20
    }

    private void b(Canvas r7, Paint r8, float r9, float r10) {
        int r1 = this.d;
        int r4 = this.c;
        RectF r0 = new RectF(r1, r1, r1 + r4, r1 + r4);
        int r2 = this.f17196b;
        r7.drawRoundRect(r0, r2, r2, r8);
        int r3 = this.d;
        int r5 = this.f17196b;
        r7.drawRect(new RectF(r3, r3 + r5, r3 + r5, r10), r8);
        int r6 = this.d;
        r7.drawRect(new RectF(this.f17196b + r6, r6, r9, r10), r8);
    }

    private void c(Canvas r6, Paint r7, float r8, float r9) {
        int r1 = this.c;
        int r3 = this.d;
        RectF r0 = new RectF(r8 - r1, r3, r8, r3 + r1);
        int r2 = this.f17196b;
        r6.drawRoundRect(r0, r2, r2, r7);
        int r4 = this.d;
        r6.drawRect(new RectF(r4, r4, r8 - this.f17196b, r9), r7);
        int r5 = this.f17196b;
        r6.drawRect(new RectF(r8 - r5, this.d + r5, r8, r9), r7);
    }

    private void d(Canvas r6, Paint r7, float r8, float r9) {
        int r1 = this.d;
        int r3 = this.c;
        RectF r0 = new RectF(r1, r9 - r3, r1 + r3, r9);
        int r2 = this.f17196b;
        r6.drawRoundRect(r0, r2, r2, r7);
        int r4 = this.d;
        r6.drawRect(new RectF(r4, r4, r4 + this.c, r9 - this.f17196b), r7);
        int r5 = this.d;
        r6.drawRect(new RectF(this.f17196b + r5, r5, r8, r9), r7);
    }

    private void e(Canvas r5, Paint r6, float r7, float r8) {
        int r1 = this.c;
        RectF r0 = new RectF(r7 - r1, r8 - r1, r7, r8);
        int r2 = this.f17196b;
        r5.drawRoundRect(r0, r2, r2, r6);
        int r3 = this.d;
        r5.drawRect(new RectF(r3, r3, r7 - this.f17196b, r8), r6);
        int r4 = this.f17196b;
        r5.drawRect(new RectF(r7 - r4, this.d, r7, r8 - r4), r6);
    }

    private void f(Canvas r6, Paint r7, float r8, float r9) {
        int r1 = this.d;
        RectF r0 = new RectF(r1, r1, r8, r1 + this.c);
        int r2 = this.f17196b;
        r6.drawRoundRect(r0, r2, r2, r7);
        int r3 = this.d;
        r6.drawRect(new RectF(r3, r3 + this.f17196b, r8, r9), r7);
    }

    private void g(Canvas r4, Paint r5, float r6, float r7) {
        RectF r0 = new RectF(this.d, r7 - this.c, r6, r7);
        int r1 = this.f17196b;
        r4.drawRoundRect(r0, r1, r1, r5);
        int r2 = this.d;
        r4.drawRect(new RectF(r2, r2, r6, r7 - this.f17196b), r5);
    }

    private void h(Canvas r6, Paint r7, float r8, float r9) {
        int r1 = this.d;
        RectF r0 = new RectF(r1, r1, r1 + this.c, r9);
        int r2 = this.f17196b;
        r6.drawRoundRect(r0, r2, r2, r7);
        int r3 = this.d;
        r6.drawRect(new RectF(this.f17196b + r3, r3, r8, r9), r7);
    }

    private void i(Canvas r4, Paint r5, float r6, float r7) {
        RectF r0 = new RectF(r6 - this.c, this.d, r6, r7);
        int r1 = this.f17196b;
        r4.drawRoundRect(r0, r1, r1, r5);
        int r2 = this.d;
        r4.drawRect(new RectF(r2, r2, r6 - this.f17196b, r7), r5);
    }

    private void j(Canvas r5, Paint r6, float r7, float r8) {
        RectF r0 = new RectF(this.d, r8 - this.c, r7, r8);
        int r1 = this.f17196b;
        r5.drawRoundRect(r0, r1, r1, r6);
        RectF r2 = new RectF(r7 - this.c, this.d, r7, r8);
        int r3 = this.f17196b;
        r5.drawRoundRect(r2, r3, r3, r6);
        int r4 = this.d;
        int r9 = this.f17196b;
        r5.drawRect(new RectF(r4, r4, r7 - r9, r8 - r9), r6);
    }

    private void k(Canvas r6, Paint r7, float r8, float r9) {
        int r1 = this.d;
        RectF r0 = new RectF(r1, r1, r1 + this.c, r9);
        int r2 = this.f17196b;
        r6.drawRoundRect(r0, r2, r2, r7);
        RectF r3 = new RectF(this.d, r9 - this.c, r8, r9);
        int r4 = this.f17196b;
        r6.drawRoundRect(r3, r4, r4, r7);
        int r5 = this.d;
        int r10 = this.f17196b;
        r6.drawRect(new RectF(r5 + r10, r5, r8, r9 - r10), r7);
    }

    private void l(Canvas r6, Paint r7, float r8, float r9) {
        int r1 = this.d;
        RectF r0 = new RectF(r1, r1, r8, r1 + this.c);
        int r2 = this.f17196b;
        r6.drawRoundRect(r0, r2, r2, r7);
        RectF r3 = new RectF(r8 - this.c, this.d, r8, r9);
        int r4 = this.f17196b;
        r6.drawRoundRect(r3, r4, r4, r7);
        int r5 = this.d;
        int r10 = this.f17196b;
        r6.drawRect(new RectF(r5, r5 + r10, r8 - r10, r9), r7);
    }

    private void m(Canvas r6, Paint r7, float r8, float r9) {
        int r1 = this.d;
        RectF r0 = new RectF(r1, r1, r8, r1 + this.c);
        int r2 = this.f17196b;
        r6.drawRoundRect(r0, r2, r2, r7);
        int r3 = this.d;
        RectF r4 = new RectF(r3, r3, r3 + this.c, r9);
        int r5 = this.f17196b;
        r6.drawRoundRect(r4, r5, r5, r7);
        int r10 = this.d;
        int r11 = this.f17196b;
        r6.drawRect(new RectF(r10 + r11, r10 + r11, r8, r9), r7);
    }

    private void n(Canvas r7, Paint r8, float r9, float r10) {
        int r1 = this.d;
        int r4 = this.c;
        RectF r0 = new RectF(r1, r1, r1 + r4, r1 + r4);
        int r2 = this.f17196b;
        r7.drawRoundRect(r0, r2, r2, r8);
        int r3 = this.c;
        RectF r5 = new RectF(r9 - r3, r10 - r3, r9, r10);
        int r6 = this.f17196b;
        r7.drawRoundRect(r5, r6, r6, r8);
        int r11 = this.d;
        int r12 = this.f17196b;
        r7.drawRect(new RectF(r11, r11 + r12, r9 - r12, r10), r8);
        int r13 = this.d;
        int r14 = this.f17196b;
        r7.drawRect(new RectF(r13 + r14, r13, r9, r10 - r14), r8);
    }

    private void o(Canvas r6, Paint r7, float r8, float r9) {
        int r1 = this.c;
        int r3 = this.d;
        RectF r0 = new RectF(r8 - r1, r3, r8, r3 + r1);
        int r2 = this.f17196b;
        r6.drawRoundRect(r0, r2, r2, r7);
        int r4 = this.d;
        int r5 = this.c;
        RectF r10 = new RectF(r4, r9 - r5, r4 + r5, r9);
        int r11 = this.f17196b;
        r6.drawRoundRect(r10, r11, r11, r7);
        int r12 = this.d;
        int r13 = this.f17196b;
        r6.drawRect(new RectF(r12, r12, r8 - r13, r9 - r13), r7);
        int r14 = this.d;
        int r15 = this.f17196b;
        r6.drawRect(new RectF(r14 + r15, r14 + r15, r8, r9), r7);
    }

    @Override // jp.wasabeef.glide.transformations.a
    public Bitmap a(Context r5, e r6, Bitmap r7, int r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        e r11 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.memorydata.plugin");
        int r12 = r7.getWidth();
        int r13 = r7.getHeight();
        Bitmap r14 = r11.a(r12, r13, Bitmap.Config.ARGB_8888);
        r14.setHasAlpha(true);
        a(r7, r14);
        Canvas r0 = new Canvas(r14);
        Paint r1 = new Paint();
        r1.setAntiAlias(true);
        r1.setShader(new BitmapShader(r7, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        a(r0, r1, r12, r13);
        return r14;
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r3) {
        r3.update(("jp.wasabeef.glide.transformations.RoundedCornersTransformation.1" + this.f17196b + this.c + this.d + this.e).getBytes(f667a));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, RoundedCornersTransformation.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (((RoundedCornersTransformation) ZeusTransformUtils.preCheckCast(r5, RoundedCornersTransformation.class, "com.obric.memorydata.plugin")).f17196b != this.f17196b) goto L13;
        if (((RoundedCornersTransformation) ZeusTransformUtils.preCheckCast(r5, RoundedCornersTransformation.class, "com.obric.memorydata.plugin")).c != this.c) goto L13;
        if (((RoundedCornersTransformation) ZeusTransformUtils.preCheckCast(r5, RoundedCornersTransformation.class, "com.obric.memorydata.plugin")).d != this.d) goto L13;
        if (((RoundedCornersTransformation) ZeusTransformUtils.preCheckCast(r5, RoundedCornersTransformation.class, "com.obric.memorydata.plugin")).e != this.e) goto L13;
        return true;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (((425235636 + (this.f17196b * 10000)) + (this.c * 1000)) + (this.d * 100)) + (this.e.ordinal() * 10);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.f17196b + ", margin=" + this.d + ", diameter=" + this.c + ", cornerType=" + this.e.name() + ")";
    }
}
