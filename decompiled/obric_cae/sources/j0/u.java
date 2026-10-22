package j0;

import android.text.TextUtils;
import android.view.View;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class u extends w.b<CharSequence> {
    public u() {
        super(R.id.tag_state_description, CharSequence.class, 64, 30);
    }

    @Override // j0.w.b
    public final CharSequence b(View r8) {
        return w.n.a(r8);
    }

    @Override // j0.w.b
    public final void c(View r8, CharSequence r10) {
        w.n.c(r8, r10);
    }

    @Override // j0.w.b
    public final boolean f(CharSequence r8, CharSequence r10) {
        return !TextUtils.equals(r8, r10);
    }
}
