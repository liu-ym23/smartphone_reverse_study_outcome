package y8b;

import android.view.View;
import com.ss.android.lark.contact.base.common_ui.SearchEditText;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment;
import com.ss.android.lark.contact.base.databinding.InvInviteExternalContactV2ViewBinding;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ InviteExternalContactV2Fragment a;

    public e(InviteExternalContactV2Fragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        InvInviteExternalContactV2ViewBinding r3 = this.a.i;
        if (r3 == null) goto L8;
        SearchEditText r4 = r3.e;
        if (r4 == null) goto L9;
        r4.setText(BuildConfig.FLAVOR);
        return;
    L9:
        return;
    }
}
