package i8b;

import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface q extends com.ss.android.lark.conditional.access.auth.v2.handler.c {
    com.ss.android.lark.conditional.access.auth.v2.c a(PolicyModel r1);

    boolean b(PolicyModel r1);

    com.ss.android.lark.conditional.access.auth.v2.c d(PolicyModel r1);

    Object e(List<PolicyModel> r1, FileAuthMonitor.UpdateTrigger r2, Continuation<? super Map<String, b0>> r3);

    boolean f(PolicyModel r1);

    void g(List<PolicyModel> r1, FileAuthMonitor.UpdateTrigger r2);

    boolean h(PolicyModel r1);

    Map<String, com.ss.android.lark.conditional.access.auth.v2.service.i> i();

    com.ss.android.lark.conditional.access.auth.v2.e j(PolicyModel r1, boolean r2);
}
