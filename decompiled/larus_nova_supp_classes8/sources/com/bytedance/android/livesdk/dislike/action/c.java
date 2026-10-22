package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import com.bytedance.android.livesdk.notification.notificationsetting.api.NotificationSettingStatusApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends OptionAction {
    public final ActionsManager e;
    public final String f;
    public final NotificationSettingBottomDialog.b g;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        String r5 = this.f;
        if (r5 == null) goto L6;
        ((NotificationSettingStatusApi) com.bytedance.android.live.network.c.b().e(NotificationSettingStatusApi.class)).updateFollowPushStatus(r5, r5, (int) 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r5), new b(this));
        return;
    }

    public c(ActionsManager r2, String r3, NotificationSettingBottomDialog.b r4) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        super(r2);
        this.e = r2;
        this.f = r3;
        this.g = r4;
    }
}
