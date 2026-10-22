package n9b;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.externalinvite.OfficeInviteExternalActivity;
import com.ss.android.lark.contact.customized.privatecontact.view.OfficePrivateContactFragment;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ OfficePrivateContactFragment a;

    public b(OfficePrivateContactFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Context r4 = this.a.getContext();
        if (r4 == null) goto L6;
        com.ss.android.lark.contact.customized.common.b.a("contact", "contact");
        Lazy r1 = OfficeContactPageUtils.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        int r2 = OfficeInviteExternalActivity.a;
        OfficeInviteExternalActivity.a.a(r4, "contact");
        return;
    }
}
