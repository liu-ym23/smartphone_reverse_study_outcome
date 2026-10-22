package s9a;

import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.obric.aiagent.runtime.TraceDependImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;
import r9a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Function0 {
    public /* synthetic */ d() {
    }

    public final Object invoke() {
        ITraceDepend.Companion r0 = ITraceDepend.Companion.b;
        IAIAgentPlatform r1 = a.a();
        if (r1 == null) goto L7;
        TraceDependImpl r2 = r1.e();
        if (r2 == null) goto L7;
        return r2;
    L7:
        return (ITraceDepend) ServiceManager.get().getService(ITraceDepend.class);
    }
}
