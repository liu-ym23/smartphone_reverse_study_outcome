package j9b;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;

    public a(View.OnClickListener r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        View.OnClickListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onClick(r2);
        return;
    }
}
