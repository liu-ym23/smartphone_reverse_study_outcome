package dc;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f7044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f7045b;

    public d(a r8, DialogInterface.OnClickListener r10) {
        this.f7044a = r8;
        this.f7045b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        a r10 = this.f7044a;
        DialogInterface.OnClickListener r11 = this.f7045b;
        if (r11 == null) goto L5;
        r11.onClick(r10.f7035d, -1);
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
