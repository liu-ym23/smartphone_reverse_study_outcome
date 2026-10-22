package j0;

import android.view.View;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class s extends w.b<Boolean> {
    public s() {
        super(R.id.tag_screen_reader_focusable, Boolean.class, 0, 28);
    }

    @Override // j0.w.b
    public final Boolean b(View r8) {
        return Boolean.valueOf(w.l.d(r8));
    }

    @Override // j0.w.b
    public final void c(View r8, Boolean r10) {
        w.l.i(r8, r10.booleanValue());
    }

    @Override // j0.w.b
    public final boolean f(Boolean r8, Boolean r10) {
        return !w.b.a(r8, r10);
    }
}
