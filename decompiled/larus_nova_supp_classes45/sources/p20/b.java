package p20;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ ViewGroup a;

    public b(ViewGroup r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        this.a.removeView(r2);
        return true;
    }
}
