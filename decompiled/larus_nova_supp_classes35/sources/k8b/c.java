package k8b;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.integrator.security.compliance.ConditionalAccessModuleDependency;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import io.reactivex.Single;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c {
    void a(Context r1, String r2);

    void b(Context r1, UserSession r2);

    Single<Boolean> c();

    Single<a> d(String r1, String r2);

    ConditionalAccessModuleDependency.b e();

    List<PolicyModel> f();

    Single<Unit> g();

    ConditionalAccessModuleDependency.passportDependency.1 getPassportDependency();

    Single h(String r1, String r2);

    void i(Activity r1);

    Single<a> j(String r1, String r2);

    void k(Context r1, UserSession r2);

    void l(Context r1);

    void m(FragmentActivity r1, UserSession r2);

    boolean n(Context r1);
}
