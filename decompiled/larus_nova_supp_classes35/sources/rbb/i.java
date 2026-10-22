package rbb;

import android.graphics.Bitmap;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements g {

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

    public i() {
    }

    @Override // rbb.g
    public final Bitmap c(obb.b r1, IconShape r2, obb.a r3) {
        return g.a.b(this, r1, r2, r3);
    }

    @Override // rbb.g
    public final Bitmap a(int r4, String r5, IconShape r6, obb.a r7) {
        Intrinsics.checkNotNullParameter(r6, "shape");
        if (r7 == null) goto L5;
        Bitmap r0 = r7.a();
    L7:
        if (r0 == null) goto L10;
        Log.i("DOCS_ICON_WikiIconProducer", "loadShortCutIcon, use default custom icon, shape= " + r6);
        return r0;
    L10:
        Log.i("DOCS_ICON_WikiIconProducer", "loadShortCutIcon " + r6);
        int r1 = a.a[r6.ordinal()];
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L18;
        int r8 = b.d(r4);
        int r9 = rbb.a.a;
        return rbb.a.b(r8, 2131102419);
    L18:
        return rbb.a.e(g.a.c(this, r4, r5, r6, r7));
    L17:
        return rbb.a.e(g.a.a(this, r4, r5, r6, r7));
    L5:
        r0 = null;
        goto L7
    }

    @Override // rbb.g
    public final Bitmap b(int r2, String r3, IconShape r4, obb.a r5) {
        Intrinsics.checkNotNullParameter(r4, "shape");
        if (r5 == null) goto L5;
        Bitmap r6 = r5.a();
    L7:
        if (r6 == null) goto L10;
        Log.i("DOCS_ICON_WikiIconProducer", "loadSquareOutlineIcon, use default custom icon, shape= " + r4);
        return r6;
    L10:
        Log.i("DOCS_ICON_WikiIconProducer", "loadSquareOutlineIcon " + r2);
        int r7 = rbb.a.a;
        return rbb.a.b(2131256245, 2131102419);
    L5:
        r6 = null;
        goto L7
    }

    @Override // rbb.g
    public final Bitmap d(int r1, String r2, IconShape r3, obb.a r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        if (r4 == null) goto L5;
        Bitmap r6 = r4.a();
    L6:
        if (r6 == null) goto L9;
        Log.i("DOCS_ICON_WikiIconProducer", "loadCircleIcon, use default custom icon, shape= " + r3);
        return r6;
    L9:
        int r7 = rbb.a.a;
        return rbb.a.c(2131256223, b.a(sbb.e.e.b, null), null);
    L5:
        r6 = null;
        goto L6
    }

    @Override // rbb.g
    public final Bitmap e(int r1, String r2, IconShape r3, obb.a r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        if (r4 == null) goto L5;
        Bitmap r6 = r4.a();
    L7:
        if (r6 == null) goto L10;
        Log.i("DOCS_ICON_WikiIconProducer", "loadSquareIcon, use default custom icon, shape= " + r3);
        return r6;
    L10:
        Log.i("DOCS_ICON_WikiIconProducer", "loadSquareIcon " + r1);
        return rbb.a.b(2131256223, null);
    L5:
        r6 = null;
        goto L7
    }
}
