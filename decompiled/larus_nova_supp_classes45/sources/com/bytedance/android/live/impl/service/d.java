package com.bytedance.android.live.impl.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.feature.api.FeatureType;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;
import py.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements Runnable {
    public final /* synthetic */ UserEvent a;

    public d(UserEvent r1) {
        this.a = r1;
    }

    public final void a() {
        FeatureManager r0 = FeatureManager.u;
        UserEvent r1 = this.a;
        Long r2 = null;
        if (r1 == null) goto L5;
        IBaseUser.Status r3 = r1.getStatus();
    L7:
        if (r3 != IBaseUser.Status.Login) goto L9;
        int r4 = 0;
    L24:
        r0.i("user_login_status", Integer.valueOf(r4), FeatureType.MONITOR);
        IBaseUser r5 = this.a.getUser();
        if (r5 == null) goto L36;
        JSONObject r6 = new JSONObject().putOpt("user_gender", Integer.valueOf(r5.getGender())).putOpt("user_city", r5.getCity()).putOpt("user_location_city", r5.getLocationCity());
        j r7 = r5.getFollowInfo();
        if (r7 == null) goto L30;
        Long r8 = Long.valueOf(r7.getFollowerCount());
    L31:
        JSONObject r9 = r6.putOpt("user_fans_count", r8);
        j r11 = r5.getFollowInfo();
        if (r11 == null) goto L34;
        r2 = Long.valueOf(r11.getFollowingCount());
    L34:
        JSONObject r12 = r9.putOpt("user_follow_count", r2).putOpt("user_age_range", Integer.valueOf(r5.getAgeRange())).putOpt("user_level", Integer.valueOf(r5.getLevel())).putOpt("user_pay_scores", Long.valueOf(r5.getPayScores())).putOpt("user_secret", Integer.valueOf(r5.getSecret()));
        FeatureManager.r("user_features", r12);
        FeatureManager.q.f("user_features", r12);
        return;
    L30:
        r8 = null;
        goto L31
    L36:
        return;
    L9:
        UserEvent r13 = this.a;
        if (r13 == null) goto L12;
        IBaseUser.Status r14 = r13.getStatus();
    L14:
        if (r14 != IBaseUser.Status.Logout) goto L16;
        r4 = 1;
        goto L24
    L16:
        UserEvent r15 = this.a;
        if (r15 == null) goto L19;
        IBaseUser.Status r16 = r15.getStatus();
    L21:
        if (r16 != IBaseUser.Status.Update) goto L23;
        r4 = 2;
        goto L24
    L23:
        r4 = -1;
        goto L24
    L19:
        r16 = null;
        goto L21
    L12:
        r14 = null;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
