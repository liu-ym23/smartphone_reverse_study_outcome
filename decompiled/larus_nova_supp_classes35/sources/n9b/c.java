package n9b;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.privatecontact.view.OfficePrivateContactFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ OfficePrivateContactFragment a;

    public c(OfficePrivateContactFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Context r2 = this.a.getContext();
        if (r2 == null) goto L6;
        OfficeContactPageUtils.a(r2);
        return;
    }
}
