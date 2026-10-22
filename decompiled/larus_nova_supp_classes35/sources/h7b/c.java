package h7b;

import android.content.DialogInterface;
import android.view.View;
import com.ss.android.lark.statistics.message.MessageHitPoint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;

    public /* synthetic */ c(com.ss.android.lark.flow.chat.multi_select.a.b.a r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        View.OnClickListener r4 = this.a;
        if (r3 == 0) goto L6;
        return;
    L6:
        if (r4 == null) goto L8;
        r4.onClick(null);
    L8:
        MessageHitPoint.a.a().sendEvent("message_delete_confirm", null);
    }
}
