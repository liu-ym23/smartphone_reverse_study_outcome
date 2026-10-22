package com.ss.android.lark.integrator.security.compliance;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/integrator/security/compliance/InitSecurityComplianceTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "runOnUIThread", "", "<init>", "(Z)V", "getRunOnUIThread", "()Z", "execute", "context", "Landroid/content/Context;", "initSecurityTaskOnMainThread", "initSecurityTaskAsync", "Companion", "security-compliance-assembly-officesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitSecurityComplianceTask extends AbstractLaunchTask<Unit> {
    public final boolean c;

    public static final class a {
    }

    static {
    }

    public InitSecurityComplianceTask() {
        this(0);
    }

    public InitSecurityComplianceTask(int r1) {
        this.c = true;
    }

    public final void a(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (this.c == false) goto L5;
        ScsLogger.d("InitSecurityComplianceTask", "execute main");
        CoreThreadPool.getSerialTaskHandler().post(new b(r7));
        return;
    L5:
        ScsLogger.d("InitSecurityComplianceTask", "execute async");
        ScsLogger.d("InitSecurityComplianceTask", "execute serial init settings");
        w4c.c.a();
        ScsLogger.d("InitSecurityComplianceTask", "execute serial init settings done");
        long r2 = System.currentTimeMillis();
        int r0 = com.ss.android.lark.scs.policy.engine.manage.d.c;
        com.ss.android.lark.scs.policy.engine.manage.d.a.a().b();
        com.ss.android.lark.integrator.security.compliance.psda.b.a();
        int r1 = g8b.b.a;
        g8b.b.a.a().init(r7);
        d.a();
        r4c.a.a();
        ScsLogger.d("InitSecurityComplianceTask", "execute finish time in ui thread: " + (System.currentTimeMillis() - r2));
    }
}
