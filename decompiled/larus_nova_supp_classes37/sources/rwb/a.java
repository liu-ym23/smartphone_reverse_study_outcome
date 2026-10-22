package rwb;

import com.ss.android.lark.integrator.security.compliance.ConditionalAccessModuleDependency;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends IOfficeSDKProtocol {

    /* JADX INFO: renamed from: rwb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0189a {
        void onError(int r1, String r2);

        void onSuccess();
    }

    void T0(ConditionalAccessModuleDependency.c.a r1);
}
