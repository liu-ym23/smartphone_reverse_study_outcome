package com.obric.aiproactive.impl.spell;

import android.os.Bundle;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/impl/spell/SpellProactiveTaskExecutor;", "", "<init>", "()V", "TAG", "", "execute", "Lcom/obric/memorydata/task/impl/TaskResult;", "operation", "extras", "Landroid/os/Bundle;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f6520a = null;

    static {
        f6520a = new d();
    }

    private d() {
    }

    public final TaskResult a(String r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "operation");
        Intrinsics.checkNotNullParameter(r8, "extras");
        TaskResult r6 = c.f6519a.a(r7, r8).execute();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SpellProactiveTaskExecutor", "execute operation=" + r7 + " code=" + r6.getCode() + " msg=" + r6.getMsg(), false, 4, null);
        return r6;
    }
}
