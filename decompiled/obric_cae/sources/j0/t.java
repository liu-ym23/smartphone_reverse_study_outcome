package j0;

import android.text.TextUtils;
import android.view.View;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class t extends w.b<CharSequence> {
    public t() {
        super(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    @Override // j0.w.b
    public final CharSequence b(View r8) {
        return w.l.b(r8);
    }

    @Override // j0.w.b
    public final void c(View r8, CharSequence r10) {
        w.l.h(r8, r10);
    }

    @Override // j0.w.b
    public final boolean f(CharSequence r8, CharSequence r10) {
        return !TextUtils.equals(r8, r10);
    }
}
