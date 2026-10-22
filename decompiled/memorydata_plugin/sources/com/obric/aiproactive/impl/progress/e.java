package com.obric.aiproactive.impl.progress;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.obric.aiproactive.api.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/impl/progress/ProactiveAgentRunControlService;", "", "<init>", "()V", "getControlState", "Lcom/obric/aiproactive/api/AiProactiveAgentRunControlState;", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "executionId", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f6504a = null;

    static {
        f6504a = new e();
    }

    private e() {
    }

    public final com.obric.aiproactive.api.e a(g r4) {
        Intrinsics.checkNotNullParameter(r4, "run");
        boolean r0 = false;
        if (Intrinsics.areEqual(r4.c(), "running") == false) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L15;
        if (com.obric.memorydata.task.e.f12914a.b(r4.a()) == false) goto L15;
        r0 = true;
    L15:
        return new com.obric.aiproactive.api.e("豆包手机助手", r0);
    L5:
        if (Intrinsics.areEqual(r4.c(), "waiting") == true) goto L8;
        r3 = false;
        goto L10
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "executionId");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return false;
    L7:
        if (com.obric.memorydata.task.scheduler.impl.c.f12961a.d().f(r2) == false) goto L11;
        c.f6499a.c(r2);
        return true;
    L11:
        return c.f6499a.b(r2);
    }
}
