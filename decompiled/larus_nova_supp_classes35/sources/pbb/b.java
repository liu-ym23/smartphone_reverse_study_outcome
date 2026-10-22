package pbb;

import android.graphics.Bitmap;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ obb.b b;
    public final /* synthetic */ obb.a c;
    public final /* synthetic */ IconShape d;

    public b(String r1, obb.b r2, obb.a r3, IconShape r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object apply(Object r5) {
        obb.b r6 = (obb.b) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        com.ss.android.lark.storage.a r0 = nbb.b.a;
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = this.b.b;
    L5:
        obb.a r2 = this.c;
        if (r2 == null) goto L8;
        UserSession r3 = r2.g;
    L9:
        nbb.b.c(r1, r6, r3);
        f r4 = new f();
        obb.b r7 = d.d(r6);
        Flowable<Bitmap> r8 = r4.a(r7, this.d, this.c);
        IconShape r9 = this.d;
        obb.a r10 = this.c;
        Intrinsics.checkNotNullParameter(r7, "meta");
        Intrinsics.checkNotNullParameter(r9, "shape");
        if (mbb.c.a == true) goto L12;
        Flowable r11 = Flowable.empty();
    L14:
        return Flowable.merge(r8, r11);
    L12:
        r11 = e.a(r7, r9, r10);
        goto L14
    L8:
        r3 = null;
        goto L9
    }
}
