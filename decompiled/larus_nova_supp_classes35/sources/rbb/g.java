package rbb;

import android.graphics.Bitmap;
import com.ss.android.lark.docs.icon.entity.IconShape;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface g {

    public static final class a {
        public static Bitmap b(g r7, obb.b r8, IconShape r9, obb.a r10) {
            Intrinsics.checkNotNullParameter(r8, "meta");
            Intrinsics.checkNotNullParameter(r9, "shape");
            if (r10 == null) goto L5;
            boolean r0 = Intrinsics.areEqual(r10.a, Boolean.TRUE);
        L6:
            if (r0 == false) goto L9;
            return r7.a(r8.getType(), r8.c, r9, r10);
        L9:
            if (r9 != IconShape.CIRCLE) goto L12;
            return r7.d(r8.getType(), r8.c, r9, r10, r8.i);
        L12:
            if (r9 != IconShape.SQUARE) goto L15;
            return r7.e(r8.getType(), r8.c, r9, r10, r8.i);
        L15:
            return r7.b(r8.getType(), r8.c, r9, r10);
        L5:
            r0 = false;
            goto L6
        }

        public static /* synthetic */ Bitmap a(g r6, int r7, String r8, IconShape r9, obb.a r10) {
            return r6.d(r7, r8, r9, r10, null);
        }

        public static /* synthetic */ Bitmap c(g r6, int r7, String r8, IconShape r9, obb.a r10) {
            return r6.e(r7, r8, r9, r10, null);
        }
    }

    Bitmap a(int r1, String r2, IconShape r3, obb.a r4);

    Bitmap b(int r1, String r2, IconShape r3, obb.a r4);

    Bitmap c(obb.b r1, IconShape r2, obb.a r3);

    Bitmap d(int r1, String r2, IconShape r3, obb.a r4, Long r5);

    Bitmap e(int r1, String r2, IconShape r3, obb.a r4, Long r5);
}
