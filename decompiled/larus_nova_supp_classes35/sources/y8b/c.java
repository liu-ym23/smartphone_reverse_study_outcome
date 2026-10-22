package y8b;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.ss.android.lark.contact.base.contact_mobile_invite.InviteExternalContactV2Fragment;
import com.ss.android.lark.contact.base.databinding.InvInviteExternalContactV2ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements TextWatcher {
    public final /* synthetic */ InviteExternalContactV2Fragment a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public c(InviteExternalContactV2Fragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        InvInviteExternalContactV2ViewBinding r0 = this.a.i;
        if (r0 == null) goto L14;
        ImageView r1 = r0.d;
        if (r1 == null) goto L15;
        int r2 = 0;
        if (String.valueOf(r3).length() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        r2 = 8;
    L12:
        r1.setVisibility(r2);
        return;
    L9:
        r4 = false;
        goto L10
    L15:
        return;
    }
}
