package com.bytedance.android.live.profile.ui.component.view;

import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LivePlayNotifyIntegrateConfig;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ProfilePushView a;
    public final /* synthetic */ NewProfileUser b;

    public c(ProfilePushView r1, NewProfileUser r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (NotificationManagerCompat.from(this.a.getContext()).areNotificationsEnabled() == false) goto L5;
    L15:
        this.a.f(this.b, true);
        return;
    L5:
        if (LivePlayNotifyIntegrateConfig.enableSubscribeUGDialog() == false) goto L15;
        if (this.a.getCurSubscribeStatus() == true) goto L15;
        if (this.a.getUgDialogDataList().contains(this.b) == true) goto L17;
        ProfilePushView r5 = this.a;
        NewProfileUser r0 = this.b;
        Map<String, String> r1 = r5.b(r0);
        if (r5.i == true) goto L13;
        String r6 = "set";
    L14:
        r1.put("status", r6);
        r1.put("event_author_name", r0.getDisplayName());
        r1.put("event_author_id", r0.baseProfileInfo.getIdStr());
        j0.l().sendLog("live_start_notice", r1, new Object[0]);
        this.a.getUgDialogDataList().add(this.b);
        return;
    L13:
        r6 = "not_set";
        goto L14
    }
}
