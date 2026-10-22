package sz7;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n extends SimpleTarget<Drawable> {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ q b;
    public final /* synthetic */ Drawable c;

    public final void onLoadCleared(Drawable r2) {
        q r3 = this.b;
        if (r3.l == false) goto L6;
        r3.e(this.c);
        return;
    }

    public final void onLoadFailed(Drawable r2) {
        q r3 = this.b;
        if (r3.l == false) goto L6;
        r3.e(this.c);
        return;
    }

    public final void onResourceReady(Object r3) {
        Drawable r4 = (Drawable) r3;
        Integer r0 = this.a;
        if (r0 != null) goto L5;
    L10:
        q r1 = this.b;
        r1.e(q.a(r1, r4, this.c));
        return;
    L5:
        if (r0.intValue() == 0) goto L10;
        if (r4 == null) goto L8;
        r4.mutate();
    L8:
        if (r4 == null) goto L10;
        r4.setTint(this.a.intValue());
        goto L10
    }

    public n(Integer r1, q r2, Drawable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
