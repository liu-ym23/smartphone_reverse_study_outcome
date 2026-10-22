package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes6.dex */
public class CropTransformation extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17194b;
    private int c;
    private CropType d;

    /* JADX INFO: renamed from: jp.wasabeef.glide.transformations.CropTransformation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17195a = null;

        static {
            int[] r0 = new int[CropType.values().length];
            f17195a = r0;
            r0[CropType.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f17195a[CropType.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f17195a[CropType.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum CropType extends Enum<CropType> {
        private static final /* synthetic */ CropType[] $VALUES = null;
        public static final CropType BOTTOM = null;
        public static final CropType CENTER = null;
        public static final CropType TOP = null;

        static {
            CropType r0 = new CropType("TOP", 0);
            TOP = r0;
            CropType r1 = new CropType("CENTER", 1);
            CENTER = r1;
            CropType r3 = new CropType("BOTTOM", 2);
            BOTTOM = r3;
            $VALUES = new CropType[]{r0, r1, r3};
        }

        private CropType(String r1, int r2) {
            super(r1, r2);
        }

        public static CropType valueOf(String r2) {
            return (CropType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CropType.class, r2), CropType.class, "com.obric.memorydata.plugin");
        }

        public static CropType[] values() {
            return (CropType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CropType[].class, "com.obric.memorydata.plugin");
        }
    }

    private float a(float r3) {
        int r0 = AnonymousClass1.f17195a[this.d.ordinal()];
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L9;
        return 0.0f;
    L9:
        return this.c - r3;
    L11:
        return (this.c - r3) / 2.0f;
    }

    @Override // jp.wasabeef.glide.transformations.a
    public Bitmap a(Context r3, e r4, Bitmap r5, int r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        e r9 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        int r10 = this.f17194b;
        if (r10 != 0) goto L5;
        r10 = r5.getWidth();
    L5:
        this.f17194b = r10;
        int r11 = this.c;
        if (r11 != 0) goto L8;
        r11 = r5.getHeight();
    L8:
        this.c = r11;
        if (r5.getConfig() == null) goto L11;
        Bitmap.Config r12 = r5.getConfig();
    L12:
        Bitmap r13 = r9.a(this.f17194b, this.c, r12);
        r13.setHasAlpha(true);
        float r14 = Math.max(this.f17194b / r5.getWidth(), this.c / r5.getHeight());
        float r15 = r5.getWidth() * r14;
        float r16 = r14 * r5.getHeight();
        float r17 = (this.f17194b - r15) / 2.0f;
        float r0 = a(r16);
        RectF r1 = new RectF(r17, r0, r15 + r17, r16 + r0);
        a(r5, r13);
        new Canvas(r13).drawBitmap(r5, null, r1, null);
        return r13;
    L11:
        r12 = Bitmap.Config.ARGB_8888;
        goto L12
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest r3) {
        r3.update(("jp.wasabeef.glide.transformations.CropTransformation.1" + this.f17194b + this.c + this.d).getBytes(f667a));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, CropTransformation.class) == true) goto L5;
    L11:
        return false;
    L5:
        if (((CropTransformation) ZeusTransformUtils.preCheckCast(r5, CropTransformation.class, "com.obric.memorydata.plugin")).f17194b != this.f17194b) goto L11;
        if (((CropTransformation) ZeusTransformUtils.preCheckCast(r5, CropTransformation.class, "com.obric.memorydata.plugin")).c != this.c) goto L11;
        if (((CropTransformation) ZeusTransformUtils.preCheckCast(r5, CropTransformation.class, "com.obric.memorydata.plugin")).d != this.d) goto L11;
        return true;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (((-1462327117) + (this.f17194b * 100000)) + (this.c * 1000)) + (this.d.ordinal() * 10);
    }

    public String toString() {
        return "CropTransformation(width=" + this.f17194b + ", height=" + this.c + ", cropType=" + this.d + ")";
    }
}
