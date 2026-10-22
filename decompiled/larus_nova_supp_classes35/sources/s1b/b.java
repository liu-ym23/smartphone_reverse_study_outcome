package s1b;

import android.content.DialogInterface;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogAction;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogCloseReason;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogShowOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Ipc$ConfirmDialogClosedDetails;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Ipc$EventType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements DialogInterface.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ IWidget$Internal$ConfirmDialogShowOptions b;
    public final /* synthetic */ IChameleonHandlerContext c;
    public final /* synthetic */ IWidget$Internal$ConfirmDialogAction d;

    public b(a r1, IWidget$Internal$ConfirmDialogShowOptions r2, IChameleonHandlerContext r3, IWidget$Internal$ConfirmDialogAction r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        this.a.a.remove(this.b.getId());
        IChameleonHandlerContext r7 = this.c;
        String r8 = IWidget$Ipc$EventType.CONFIRM_DIALOG_CLOSED.getValue();
        String r0 = this.b.getId();
        String r1 = this.d.getKey();
        r7.sendEvent(r8, new IWidget$Ipc$ConfirmDialogClosedDetails(r0, IWidget$Internal$ConfirmDialogCloseReason.Action, r1));
    }
}
