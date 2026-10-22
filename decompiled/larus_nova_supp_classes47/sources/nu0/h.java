package nu0;

import android.content.DialogInterface;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements DialogInterface.OnCancelListener {
    public final /* synthetic */ SingleSubject a;

    public h(SingleSubject r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r2) {
        this.a.onSuccess(Boolean.FALSE);
    }
}
