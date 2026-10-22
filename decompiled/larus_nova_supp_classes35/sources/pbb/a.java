package pbb;

import com.ss.android.lark.larkicon.IconScene;
import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ obb.a a;
    public final /* synthetic */ obb.b b;
    public final /* synthetic */ long c;

    public a(obb.a r1, obb.b r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r9) {
        Throwable r10 = (Throwable) r9;
        DecimalFormat r0 = vpb.f.a;
        obb.a r1 = this.a;
        if (r1 == null) goto L5;
        IconScene r2 = r1.e;
    L6:
        IconScene r3 = r2;
        Integer r4 = this.b.d;
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L10:
        vpb.f.a("fetch_icon_info", r3, r5, false, System.nanoTime() - this.c, r10.getMessage());
        return;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
