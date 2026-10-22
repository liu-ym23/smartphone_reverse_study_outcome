package c09;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.AuthorizeAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import n38.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends AuthorizeAdapter {
    public final /* synthetic */ l a;

    public c(l r1) {
        this.a = r1;
        super("weixin");
    }

    public final void onAuthError(AuthorizeErrorResponse r3) {
        l r0 = this.a;
        if (r3 == null) goto L6;
        String r4 = r3.platformErrorMsg;
        if (r4 == null) goto L6;
    L7:
        r0.b(r4, null);
        return;
    L6:
        r4 = "";
        goto L7
    }

    public final void onAuthSuccess(Bundle r3) {
        if (r3 == null) goto L5;
        String r4 = r3.getString("auth_code");
    L6:
        if (r4 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        this.a.b("token is empty", null);
        return;
    L14:
        this.a.a(r4, null);
        return;
    L8:
        if (r4.length() == 0) goto L11;
        r1 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }
}
