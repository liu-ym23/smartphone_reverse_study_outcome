package mfa;

import android.content.DialogInterface;
import com.larus.permission.api.IPermissionX;
import com.obric.assistant.permission.IObricPermissionServiceImpl$d;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements DialogInterface.OnDismissListener {
    public boolean a;
    public final /* synthetic */ IPermissionX.c b;
    public final /* synthetic */ Ref.BooleanRef c;

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r3) {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        IPermissionX.c r4 = this.b;
        if (r4 == null) goto L9;
        r4.a(this.c.element, null);
        return;
    }

    public g(IObricPermissionServiceImpl$d r1, Ref.BooleanRef r2) {
        this.b = r1;
        this.c = r2;
    }
}
