package rbb;

import android.graphics.Bitmap;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements g {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IconShape.values().length];
            r0[IconShape.CIRCLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[IconShape.SQUARE_OUTLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public c() {
    }

    @Override // rbb.g
    public final Bitmap c(obb.b r1, IconShape r2, obb.a r3) {
        return g.a.b(this, r1, r2, r3);
    }

    @Override // rbb.g
    public final Bitmap a(int r3, String r4, IconShape r5, obb.a r6) {
        Intrinsics.checkNotNullParameter(r5, "shape");
        Log.i("DOCS_ICON_DocsIconProducer", "loadShortCutIcon " + r5);
        int r0 = a.a[r5.ordinal()];
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L10;
        int r7 = b.d(r3);
        int r8 = rbb.a.a;
        return rbb.a.b(r7, 2131102419);
    L10:
        return rbb.a.e(g.a.c(this, r3, r4, r5, r6));
    L9:
        return rbb.a.e(g.a.a(this, r3, r4, r5, r6));
    }

    @Override // rbb.g
    public final Bitmap b(int r1, String r2, IconShape r3, obb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        Log.i("DOCS_ICON_DocsIconProducer", "loadSquareOutlineIcon " + r1);
        mbb.e r5 = mbb.c.e;
        if (r5 == null) goto L7;
        Integer r6 = r5.a(r1);
        if (r6 == null) goto L7;
        Integer r7 = Integer.valueOf(kac.a.b(r6.intValue()));
    L8:
        if (r7 == null) goto L13;
        if (r7.intValue() == 0) goto L13;
        int r8 = r7.intValue();
    L40:
        int r9 = rbb.a.a;
        if (r4 == null) goto L45;
        Integer r10 = r4.d;
        if (r10 == null) goto L45;
        int r11 = r10.intValue();
    L47:
        return rbb.a.b(r8, Integer.valueOf(r11));
    L45:
        r11 = 2131102419;
    L13:
        if (r1 != sbb.e.g.b) goto L16;
        r8 = kac.a.b(2131254550);
        goto L40
    L16:
        if (r1 != sbb.e.h.b) goto L19;
        r8 = kac.a.b(2131254526);
        goto L40
    L19:
        if (r1 != sbb.e.i.b) goto L22;
        r8 = kac.a.b(2131254491);
        goto L40
    L22:
        if (r1 != sbb.e.k.b) goto L25;
        r8 = kac.a.b(2131254513);
        goto L40
    L25:
        if (r1 != sbb.e.m.b) goto L28;
        r8 = kac.a.b(2131254533);
        goto L40
    L28:
        if (r1 != sbb.e.o.b) goto L31;
        r8 = kac.a.b(2131254502);
        goto L40
    L31:
        if (r1 != sbb.e.p.b) goto L34;
        r8 = 2131256118;
        goto L40
    L34:
        if (r1 != sbb.e.t.b) goto L36;
    L39:
        r8 = kac.a.b(2131254512);
        goto L40
    L36:
        if (r1 == sbb.e.u.b) goto L39;
        r8 = kac.a.b(2131254538);
    L7:
        r7 = null;
        goto L8
    }

    @Override // rbb.g
    public final Bitmap d(int r1, String r2, IconShape r3, obb.a r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        int r6 = b.c(r1, r5);
        int r7 = rbb.a.a;
        return rbb.a.c(r6, b.a(r1, r5), null);
    }

    @Override // rbb.g
    public final Bitmap e(int r1, String r2, IconShape r3, obb.a r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        Log.i("DOCS_ICON_DocsIconProducer", "loadSquareIcon " + r1 + ", objSubType " + r5);
        return rbb.a.b(b.c(r1, r5), null);
    }
}
