package h7b;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ i.b a;

    public /* synthetic */ d(com.ss.android.lark.share_group.i r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        i.b r3 = this.a;
        if (r3 == null) goto L6;
        r3.onCancel();
        return;
    }
}
