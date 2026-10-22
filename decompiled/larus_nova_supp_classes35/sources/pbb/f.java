package pbb;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.log.Log;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;
import rbb.g;
import rbb.h;
import rbb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final /* synthetic */ int b = 0;
    public final h a;

    public static final class a {
    }

    static {
    }

    public f() {
        this.a = new h();
    }

    public final Flowable<Bitmap> a(obb.b r5, IconShape r6, obb.a r7) {
        Intrinsics.checkNotNullParameter(r5, "meta");
        Intrinsics.checkNotNullParameter(r6, "shape");
        if (mbb.c.a == true) goto L5;
    L13:
        Log.i("DOCS_ICON_LocalIconExcutor", "load not custom icon,load placeHolder");
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "meta");
        Intrinsics.checkNotNullParameter(r6, "shape");
        Log.i("DOCS_ICON_IconProduceTask", "getIconProducer " + r5.getType());
        int r0 = r5.getType();
        if (r0 != sbb.e.n.b) goto L17;
        g r1 = new i();
    L24:
        return Flowable.just(r1.c(r5, r6, r7));
    L17:
        if (r0 != sbb.e.l.b) goto L20;
        r1 = new rbb.d();
        goto L24
    L20:
        if (r0 != sbb.e.f.b) goto L22;
        r1 = new rbb.f();
        goto L24
    L22:
        r1 = new rbb.c();
        goto L24
    L5:
        if (r5.d == null) goto L13;
        String r2 = r5.e;
        if (r2 == null) goto L13;
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return e.a(r5, r6, r7);
    }
}
