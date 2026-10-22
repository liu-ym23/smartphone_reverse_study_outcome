package loc;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ String a;

    public a(String r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        joc.c r3 = e.a;
        joc.b r4 = e.b;
        if (r4 == null) goto L6;
        r4.a(this.a);
        return;
    }
}
