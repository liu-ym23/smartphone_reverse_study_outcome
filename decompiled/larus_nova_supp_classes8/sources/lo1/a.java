package lo1;

import android.content.DialogInterface;
import android.view.KeyEvent;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements DialogInterface.OnKeyListener {
    public final WeakReference<DialogInterface.OnKeyListener> a;

    public a(WeakReference<DialogInterface.OnKeyListener> r2) {
        Intrinsics.checkNotNullParameter(r2, "weakReference");
        this.a = r2;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r2, int r3, KeyEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.a.get() != null) goto L6;
        return false;
    L6:
        DialogInterface.OnKeyListener r0 = this.a.get();
        Intrinsics.checkNotNull(r0);
        return r0.onKey(r2, r3, r4);
    }
}
