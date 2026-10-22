package yz8;

import android.app.Application;
import com.bytedance.sdk.account.platform.ValidateMobileLoginAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.larus.account.base.impl.q;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.phone.PhoneLogin;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f extends ValidateMobileLoginAdapter {
    public final /* synthetic */ PhoneLogin a;
    public final /* synthetic */ n38.h b;
    public final /* synthetic */ String c;

    public final void onLoginError(AuthorizeErrorResponse r13) {
        Intrinsics.checkNotNullParameter(r13, "response");
        FLogger.a.w(this.a.a, "phoneValidateOneKeyLogin onLoginError: " + r13);
        if ((r13 instanceof OnekeyLoginErrorResponse) == false) goto L6;
        int r0 = ((OnekeyLoginErrorResponse) r13).errorType;
        String r1 = r13.platformErrorMsg;
        n38.h.a.a(this.b, LoginPlatform.PHONE, ((OnekeyLoginErrorResponse) r13).error, r1 + "errType:" + r0, this.c, null, null, null, null, 480);
        return;
    }

    public final void onLoginSuccess(ua7.h r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        FLogger.a.i(this.a.a, "phoneValidateOneKeyLoginonLoginSuccess : " + r5);
        this.b.b(LoginPlatform.PHONE, this.c, Boolean.valueOf(((sc7.a) r5.p).g));
    }

    public f(String r1, String r2, PhoneLogin r3, q r4, Application r5) {
        this.a = r3;
        this.b = r4;
        this.c = "phone_one_key";
        super(r5, r1, r2);
    }
}
