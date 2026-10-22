package y8b;

import android.content.DialogInterface;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements DialogInterface.OnCancelListener {
    public final /* synthetic */ InviteExternalContactV2Fragment a;

    public f(InviteExternalContactV2Fragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r1) {
        this.a.finish();
    }
}
