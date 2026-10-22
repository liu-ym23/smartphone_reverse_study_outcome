package com.ss.android.lark.officesdk;

import com.ss.android.lark.assembly.avatar.officesdk.OfficeInitAvatarLoaderTask;
import com.ss.android.lark.flow.notification.offline.InitFlowReportSameDeviceJudgeTask;
import com.ss.android.lark.flow.notification.online.InitFlowNotificationTask;
import com.ss.android.lark.framework.assembly.emoji_office.UpdateEmojiTask;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import com.ss.android.lark.officesdk.integrator.core.corrupt.InitDbCorruptPushTask;
import com.ss.android.lark.officesdk.integrator.im.InitFullImSdkTask;
import com.ss.android.lark.officesdk.integrator.im.InitMixFeedMoltenCacheTask;
import com.ss.android.lark.officesdk.integrator.im.OfficeInitSDKLanguageTask;
import com.ss.android.lark.officesdk.integrator.im.sdk.service.InitImSdkServiceTask;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImOfficeLoadTaskInjector implements com.ss.android.lark.officesdk.launcher.load.a {
    public final Lazy a;

    @Inject
    public ImOfficeLoadTaskInjector() {
        this.a = LazyKt.lazy(ImOfficeLoadTaskInjector$isLaunchIMEnabled$2.INSTANCE);
    }

    @Override // com.ss.android.lark.officesdk.launcher.load.a
    public final OfficeBizType getBizType() {
        return OfficeBizType.IM;
    }

    @Override // com.ss.android.lark.officesdk.launcher.load.a
    public final void a(com.ss.android.lark.officesdk.launcher.load.c r2) {
        Intrinsics.checkNotNullParameter(r2, "collector");
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        r2.a(new InitDbCorruptPushTask());
        r2.a(new InitImSdkServiceTask());
        r2.a(new InitFullImSdkTask());
        r2.a(new OfficeInitAvatarLoaderTask());
        r2.a(new OfficeInitSDKLanguageTask());
        r2.a(new UpdateEmojiTask());
        r2.a(new InitFlowNotificationTask());
        r2.a(new InitMixFeedMoltenCacheTask());
        r2.a(new InitFlowReportSameDeviceJudgeTask());
    }
}
