package nu0;

import android.content.DialogInterface;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ SingleSubject a;

    public f(SingleSubject r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        this.a.onSuccess(Boolean.FALSE);
    }
}
