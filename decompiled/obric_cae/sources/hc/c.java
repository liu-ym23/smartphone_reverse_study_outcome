package hc;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f8040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f8041b;

    public c(b r8) {
        this.f8040a = r8;
        this.f8041b = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        b r10 = this.f8040a;
        DialogInterface.OnClickListener r11 = this.f8041b;
        if (r11 == null) goto L5;
        r11.onClick(r10.f8032d, -3);
    L5:
        fc.a r12 = r10.f8032d;
        if (r12 != null) goto L8;
    L10:
        if (r12 == null) goto L13;
        r12.dismiss();
        return;
    L13:
        return;
    L8:
        if (r12.f7365r == true) goto L10;
    }
}
