package yz8;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.larus.account.base.impl.m;
import com.larus.account.base.model.PhoneOneKeyPlatform;
import n38.c0;
import n38.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements AuthorizeCallback {
    public final /* synthetic */ IOnekeyLoginService a;
    public final /* synthetic */ y b;

    public final void onError(AuthorizeErrorResponse r3) {
        y r0 = this.b;
        if (r3 == null) goto L6;
        String r1 = r3.platformErrorCode;
        if (r1 == null) goto L6;
    L7:
        if (r3 == null) goto L10;
        String r4 = r3.platformErrorMsg;
        if (r4 == null) goto L10;
    L11:
        r0.a(r1, r4);
        return;
    L10:
        r4 = "";
    L6:
        r1 = "-1";
        goto L7
    }

    public final void onSuccess(Bundle r4) {
        if (r4 == null) goto L4;
        String r5 = r4.getString("security_phone");
    L5:
        String r0 = this.a.getCarrier();
        if (r0 == null) goto L26;
        int r1 = r0.hashCode();
        if (r1 == (-1429363305)) goto L23;
        if (r1 == (-1068855134)) goto L19;
        if (r1 != (-840542575)) goto L26;
        if (r0.equals("unicom") == false) goto L26;
        PhoneOneKeyPlatform r2 = PhoneOneKeyPlatform.UNICOM;
    L27:
        this.b.b(new c0(r5, r2));
        return;
    L19:
        if (r0.equals("mobile") == false) goto L26;
        r2 = PhoneOneKeyPlatform.MOBILE;
        goto L27
    L23:
        if (r0.equals("telecom") == false) goto L26;
        r2 = PhoneOneKeyPlatform.TELECOM;
    L26:
        r2 = PhoneOneKeyPlatform.UNKNOWN;
        goto L27
    L4:
        r5 = null;
        goto L5
    }

    public b(IOnekeyLoginService r1, m r2) {
        this.a = r1;
        this.b = r2;
    }
}
