package gc;

import android.content.DialogInterface;
import ge.p;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f7812a;

    public g(cd.b.C0043b r8) {
        this.f7812a = r8;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        he.i.e(r8, "dialog");
        Integer r11 = Integer.valueOf(r10);
        this.f7812a.invoke(r8, r11);
    }
}
