package dc;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f7040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f7041b;

    public b(a r8, DialogInterface.OnClickListener r10) {
        this.f7040a = r8;
        this.f7041b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        a r10 = this.f7040a;
        DialogInterface.OnClickListener r11 = this.f7041b;
        if (r11 == null) goto L5;
        r11.onClick(r10.f7035d, -2);
    L5:
        e r12 = r10.f7035d;
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
