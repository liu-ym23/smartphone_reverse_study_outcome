package com.ss.android.lark.officesdk.launcher;

import com.ss.android.lark.app.task.scheduler.AppLauncherTaskScheduler;
import com.ss.android.lark.assembly.avatar.officesdk.OfficeInitAvatarLoaderTask;
import com.ss.android.lark.flow.notification.offline.InitFlowReportSameDeviceJudgeTask;
import com.ss.android.lark.flow.notification.online.InitFlowNotificationTask;
import com.ss.android.lark.framework.assembly.emoji_office.UpdateEmojiTask;
import com.ss.android.lark.officesdk.integrator.core.corrupt.InitDbCorruptPushTask;
import com.ss.android.lark.officesdk.integrator.im.InitMixFeedMoltenCacheTask;
import com.ss.android.lark.officesdk.integrator.im.OfficeInitSDKLanguageTask;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class ImFeedLaunchTaskInjector implements com.ss.android.lark.officesdk.launcher.feed.a {
    public final Lazy a;

    @Inject
    public ImFeedLaunchTaskInjector() {
        this.a = LazyKt.lazy(ImFeedLaunchTaskInjector$isIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.feed.a
    public final void a(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
        if (((Boolean) this.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        r2.a(new OfficeInitAvatarLoaderTask());
        r2.a(new OfficeInitSDKLanguageTask());
        r2.a(new UpdateEmojiTask());
        r2.a(new InitFlowNotificationTask());
        r2.a(new InitMixFeedMoltenCacheTask());
        r2.a(new InitFlowReportSameDeviceJudgeTask());
    }

    @Override // com.ss.android.lark.officesdk.launcher.feed.a
    public final void b(AppLauncherTaskScheduler r2) {
        Intrinsics.checkNotNullParameter(r2, "launcherTaskScheduler");
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L6;
        r2.a(new InitDbCorruptPushTask());
        return;
    }
}
