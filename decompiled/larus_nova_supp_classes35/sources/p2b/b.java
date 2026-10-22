package p2b;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import b3b.f;
import com.ss.android.lark.widget.richtext.Image;
import java.util.List;
import r5b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements r5b.b<v5b.a<?>> {
    public c<v5b.a<?>> a;
    public final q5b.a b;
    public final q5b.b c;

    public b(f r2) {
        this.b = r2;
        if ((r2 instanceof q5b.b) == true) goto L6;
        r2 = null;
    L6:
        this.c = r2;
    }

    @Override // q5b.b
    public final void b(String r2) {
        q5b.b r0 = this.c;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // q5b.a
    public final boolean c(String r2) {
        q5b.a r0 = this.b;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.c(r2);
    }

    @Override // q5b.a
    public final void l(String r2) {
        q5b.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.l(r2);
        return;
    }

    @Override // r5b.c
    public final boolean d(View r2, v5b.c<v5b.a<?>> r3) {
        c<v5b.a<?>> r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.d(r2, r3);
    }

    @Override // q5b.a
    public final void e(int r2, boolean r3) {
        q5b.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @Override // q5b.a
    public final void m(v5b.c r2, AppCompatImageView r3, r5b.a r4) {
        q5b.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.m(r2, r3, r4);
        return;
    }

    @Override // q5b.a
    public final void a(View r2, List<Image> r3, Image r4, String r5) {
        q5b.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4, r5);
        return;
    }
}
