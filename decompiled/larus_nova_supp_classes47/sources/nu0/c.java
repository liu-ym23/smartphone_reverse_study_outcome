package nu0;

import android.content.DialogInterface;
import io.reactivex.subjects.SingleSubject;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ SingleSubject a;

    public c(SingleSubject r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        r3.dismiss();
        com.bytedance.tools.kcp.spongepreference.runtime.a r5 = k.b;
        KProperty r6 = k.a[0];
        Boolean r0 = Boolean.TRUE;
        r5.setValue(null, r6, r0);
        this.a.onSuccess(r0);
    }
}
