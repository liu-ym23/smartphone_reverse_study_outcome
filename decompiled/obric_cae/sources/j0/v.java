package j0;

import android.view.View;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class v extends w.b<Boolean> {
    public v() {
        super(R.id.tag_accessibility_heading, Boolean.class, 0, 28);
    }

    @Override // j0.w.b
    public final Boolean b(View r8) {
        return Boolean.valueOf(w.l.c(r8));
    }

    @Override // j0.w.b
    public final void c(View r8, Boolean r10) {
        w.l.g(r8, r10.booleanValue());
    }

    @Override // j0.w.b
    public final boolean f(Boolean r8, Boolean r10) {
        return !w.b.a(r8, r10);
    }
}
