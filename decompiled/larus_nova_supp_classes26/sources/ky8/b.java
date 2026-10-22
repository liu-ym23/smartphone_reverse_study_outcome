package ky8;

import android.graphics.Bitmap;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.IGalleryDataSource;
import com.larus.gallery.api.b0;
import com.larus.gallery.api.m;
import com.larus.platform.model.chat.n;
import com.larus.platform.service.z2;
import java.util.List;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements IGalleryDataSource<Object> {
    public final List<a> a;

    public final boolean b() {
        return false;
    }

    public final Object f(Object r1, Continuation<Object> r2) {
        return r1;
    }

    public final boolean h() {
        return true;
    }

    public final int k() {
        return 0;
    }

    public b(List<a> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataList");
        this.a = r2;
    }

    public final Object c(Continuation<? super b0<? extends List<? extends Object>>> r4) {
        return new b0.b(this.a, false, false, 6);
    }

    public final Object d(Object r1, Continuation<? super b0<? extends List<? extends Object>>> r2) {
        return IGalleryDataSource.DefaultImpls.a();
    }

    public final Object e(List<? extends Object> r1, Continuation<? super List<? extends Pair<? extends Object, com.larus.gallery.api.k>>> r2) {
        return IGalleryDataSource.DefaultImpls.c(this, r1, r2);
    }

    public final Object g(Object r1, Continuation<? super b0<? extends List<? extends Object>>> r2) {
        return IGalleryDataSource.DefaultImpls.b();
    }

    public final Object i(Object r17, Continuation<? super com.larus.gallery.api.k> r18) {
        Bitmap.Config r2 = null;
        if ((r17 instanceof a) == false) goto L5;
        a r1 = (a) r17;
    L6:
        if (r1 == null) goto L34;
        GalleryType r4 = GalleryType.Image;
        String r7 = r1.h;
        String r6 = r1.g;
        Integer r8 = r1.i;
        Integer r9 = r1.j;
        z2 r3 = z2.a;
        if (r3.ugcPreviewUseARGB() == false) goto L10;
        r2 = Bitmap.Config.ARGB_8888;
    L10:
        Bitmap.Config r10 = r2;
        boolean r5 = true;
        if (r3.getCreationPreviewPerformanceOptConfig().b == false) goto L22;
        n r11 = r3.getCreationPreviewPerformanceOptConfig();
        if (r11.b == true) goto L15;
    L19:
        boolean r12 = false;
    L20:
        if (r12 == true) goto L22;
        boolean r13 = true;
    L23:
        n r14 = r3.getCreationPreviewPerformanceOptConfig();
        if (r14.b == true) goto L26;
    L30:
        r5 = false;
    L32:
        return new com.larus.gallery.api.k(r4, new m(r6, r7, r8, r9, r10, Boxing.boxBoolean(r13), Boxing.boxBoolean(r5), "common.photo_dialog_preview_v2", Boxing.boxInt(r3.getCreationPreviewPerformanceOptConfig().c)), null, null, null, 28);
    L26:
        if (r14.c <= 0) goto L30;
        if (r3.a2() == false) goto L30;
    L15:
        if (r11.c <= 0) goto L19;
        if (r3.a2() == false) goto L19;
        r12 = true;
    L22:
        r13 = false;
        goto L23
    L34:
        throw new IllegalArgumentException("Unsupported gallery data: ".concat(r17.getClass().getName()));
    L5:
        r1 = null;
        goto L6
    }

    public final boolean j(Object r1, Object r2) {
        return Intrinsics.areEqual(r1, r2);
    }
}
