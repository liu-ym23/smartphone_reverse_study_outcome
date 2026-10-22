package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.framework.assembly.emoji_office.UpdateEmojiTask;
import com.ss.android.lark.utils.LarkContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class DocsLaunchTaskInjector implements b {
    public final OfficeLaunchSchedulerType a;
    public final Lazy b;

    @Inject
    public DocsLaunchTaskInjector() {
        this.a = OfficeLaunchSchedulerType.V1;
        this.b = LazyKt.lazy(DocsLaunchTaskInjector$isIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final OfficeLaunchSchedulerType c() {
        return this.a;
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void a(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
        if (((Boolean) this.b.getValue()).booleanValue() == true) goto L5;
        r2.a(new UpdateEmojiTask());
    L5:
        kmb.c.a.a(LarkContext.getApplication());
    }

    @Override // com.ss.android.lark.officesdk.launcher.b
    public final void b(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
    }
}
