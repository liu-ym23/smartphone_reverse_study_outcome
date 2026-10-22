package q0c;

import android.content.Context;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {

    public interface a {
    }

    void checkImageDownloadAuthorizationAndShowWarningOnFailed(String r1, String r2, String r3, Context r4, Integer r5, AuthorizationServiceV2.b r6);

    a getGuideDependency();

    String getWatermarkResource(String r1, String r2);

    void goImageForwardSelectPage(Context r1, String r2, int r3);

    boolean isAuthorizationPassed(ValidateResult r1);

    boolean isCipherStatusOn();

    boolean isFeatureGatingEnable(String r1);
}
