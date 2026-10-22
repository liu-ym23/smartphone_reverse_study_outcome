package s1b;

import android.content.DialogInterface;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogCloseReason;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Internal$ConfirmDialogShowOptions;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Ipc$ConfirmDialogClosedDetails;
import com.ss.android.lark.chameleonv2.lkapi.widget.IWidget$Ipc$EventType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements DialogInterface.OnCancelListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ IWidget$Internal$ConfirmDialogShowOptions b;
    public final /* synthetic */ IChameleonHandlerContext c;

    public c(a r1, IWidget$Internal$ConfirmDialogShowOptions r2, IChameleonHandlerContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r6) {
        this.a.a.remove(this.b.getId());
        this.c.sendEvent(IWidget$Ipc$EventType.CONFIRM_DIALOG_CLOSED.getValue(), new IWidget$Ipc$ConfirmDialogClosedDetails(this.b.getId(), IWidget$Internal$ConfirmDialogCloseReason.Cancel, BuildConfig.FLAVOR));
    }
}
