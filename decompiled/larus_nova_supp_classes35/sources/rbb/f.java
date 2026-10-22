package rbb;

import android.graphics.Bitmap;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements g {
    public f() {
    }

    @Override // rbb.g
    public final Bitmap c(obb.b r3, IconShape r4, obb.a r5) {
        Intrinsics.checkNotNullParameter(r3, "meta");
        Intrinsics.checkNotNullParameter(r4, "shape");
        StringBuilder r6 = new StringBuilder("loadIcon ");
        if (r5 == null) goto L5;
        Boolean r0 = r5.a;
    L6:
        r6.append(r0);
        r6.append("  ");
        if (r5 == null) goto L9;
        Boolean r1 = r5.b;
    L10:
        r6.append(r1);
        Log.i("DOCS_ICON_FolderIconProducer", r6.toString());
        boolean r7 = false;
        if (r5 == null) goto L13;
        boolean r2 = Intrinsics.areEqual(r5.a, Boolean.TRUE);
    L14:
        if (r2 == true) goto L21;
        if (r5 == null) goto L17;
        r7 = Intrinsics.areEqual(r5.b, Boolean.TRUE);
    L17:
        if (r7 == true) goto L21;
        boolean r8 = mbb.c.a;
        return a.b(kac.a.b(2131254455), null);
    L21:
        return a.b(b.g(), null);
    L13:
        r2 = false;
        goto L14
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    @Override // rbb.g
    public final Bitmap a(int r1, String r2, IconShape r3, obb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        return a.a();
    }

    @Override // rbb.g
    public final Bitmap b(int r1, String r2, IconShape r3, obb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        return a.a();
    }

    @Override // rbb.g
    public final Bitmap d(int r1, String r2, IconShape r3, obb.a r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        return a.a();
    }

    @Override // rbb.g
    public final Bitmap e(int r1, String r2, IconShape r3, obb.a r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "shape");
        return a.a();
    }
}
