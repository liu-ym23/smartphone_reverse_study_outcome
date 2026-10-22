package b4b;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements DialogInterface.OnKeyListener {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
        if (r2 != 4) goto L7;
        this.a.b.invoke();
        return true;
    L7:
        return true;
    }
}
