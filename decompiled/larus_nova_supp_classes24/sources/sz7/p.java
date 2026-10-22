package sz7;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.larksuite.component.ui.avatar.BorderProperty;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p extends SimpleTarget<Drawable> {
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

    public final void onResourceReady(Object r6) {
        Drawable r7 = (Drawable) r6;
        Integer r0 = this.a;
        if (r0 == null) goto L11;
        if (r0.intValue() == 0) goto L11;
        if (r7 == null) goto L8;
        r7.mutate();
    L8:
        if (r7 == null) goto L11;
        r7.setTint(this.a.intValue());
    L11:
        if ((r7 instanceof BitmapDrawable) == false) goto L13;
        this.b.getClass();
        this.b.getClass();
        r7 = new y(this.b.getContext().getResources(), (BitmapDrawable) r7, new BorderProperty(0, 0, this.b.m));
    L13:
        q r1 = this.b;
        r1.e(q.a(r1, r7, this.c));
    }

    public p(Integer r1, q r2, Drawable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
