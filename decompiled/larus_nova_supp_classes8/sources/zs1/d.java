package zs1;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ e.a a;

    public d(i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.onClose();
    }
}
