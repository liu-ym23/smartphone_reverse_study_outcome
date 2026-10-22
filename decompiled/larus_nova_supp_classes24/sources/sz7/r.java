package sz7;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class r implements l {
    public final /* synthetic */ k a;
    public final /* synthetic */ s b;

    @Override // sz7.l
    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        Drawable r3 = this.b.h;
        if (r3 == null) goto L5;
        k r0 = this.a;
        Intrinsics.checkNotNull(r3);
        r0.setIcon(r3);
    L5:
        this.b.getClass();
    }

    @Override // sz7.l
    public final void onSuccess(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.a.setIcon(r2);
        this.b.getClass();
    }

    public r(o r1, s r2) {
        this.a = r1;
        this.b = r2;
    }
}
