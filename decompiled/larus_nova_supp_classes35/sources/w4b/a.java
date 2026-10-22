package w4b;

import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    void a(ValidateResult r1, AuthorizationServiceV2.AuthorizationType r2);

    void auditLinkEvent(String r1, String r2);

    boolean b();

    void c(String r1, String r2);

    ValidateResult d();

    void e(String r1, String r2, String r3, String r4);

    void f(String r1, String r2);

    AuthorizationServiceV2 g();

    String getUploadAuthorizationTip();

    boolean isAuthorizationPassed(ValidateResult r1);
}
