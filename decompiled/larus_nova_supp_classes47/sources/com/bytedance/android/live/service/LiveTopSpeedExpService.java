package com.bytedance.android.live.service;

import com.bytedance.android.live.TopSpeedPushHelper;
import com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.base.LivePrefStatus;
import com.bytedance.android.live.room.api.playopt.topspeed.base.LiveRiskStatus;
import com.bytedance.android.livesdk.sharedpref.e;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/service/LiveTopSpeedExpService;", "Lcom/bytedance/android/live/room/api/experience/service/ILiveTopSpeedExpService;", "Ll61/b;", "scene", "Lg61/a;", "listener", "", "registerExpBizListener", "unregisterExpBizListener", "", "isDegradingForScene", "isDegradingForSwitch", "showExpOptDialog", "showTopSpeedGuideDialog", "", "prefCode", "riskCode", "showTopSpeedPush", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveTopSpeedExpService implements ILiveTopSpeedExpService {
    @Override // com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService
    public boolean isDegradingForSwitch() {
        if (TopSpeedModeManager.l.d != 0) goto L5;
    L8:
        return false;
    L5:
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.g.a).booleanValue() == true) goto L8;
        return true;
    }

    public LiveTopSpeedExpService() {
        k.l(ILiveTopSpeedExpService.class, this);
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService
    public void showExpOptDialog() {
        xs2.b.a().post(new h61.a());
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService
    public void showTopSpeedGuideDialog() {
        xs2.b.a().post(new h61.b());
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService
    public boolean isDegradingForScene(l61.b r7) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        TopSpeedModeManager r1 = TopSpeedModeManager.l;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "scene");
        if (r1.d != 0) goto L5;
        return false;
    L5:
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.g.a).booleanValue() == false) goto L8;
        return false;
    L8:
        if (StringsKt.contains$default(r7.getKey(), "live_resource_", false, 2, null) == false) goto L10;
        String r8 = r7.getKey();
    L12:
        return r1.c.contains(r8);
    L10:
        r8 = "live_resource_" + r7.getKey();
        goto L12
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService
    public void registerExpBizListener(l61.b r2, g61.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "listener");
        TopSpeedModeManager r0 = TopSpeedModeManager.l;
        TopSpeedModeManager.l.d(r2, r3);
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService
    public void showTopSpeedPush(int r2, int r3) {
        if (r2 != LivePrefStatus.PREF_NORMAL.getCode()) goto L10;
        if (r3 != LiveRiskStatus.HIGH_RISK.getCode()) goto L10;
        if (TopSpeedModeUtils.d().d() == true) goto L10;
        e r4 = TopSpeedPushHelper.a;
        TopSpeedPushHelper.e();
        return;
    L10:
        if (r2 != LivePrefStatus.PREF_MEDIUM.getCode()) goto L13;
        e r5 = TopSpeedPushHelper.a;
        TopSpeedPushHelper.d();
        return;
    L13:
        if (r2 != LivePrefStatus.PREF_SERIOUS.getCode()) goto L18;
        e r6 = TopSpeedPushHelper.a;
        TopSpeedPushHelper.c();
        return;
    }

    @Override // com.bytedance.android.live.room.api.experience.service.ILiveTopSpeedExpService
    public void unregisterExpBizListener(l61.b r2, g61.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "listener");
        TopSpeedModeManager r0 = TopSpeedModeManager.l;
        TopSpeedModeManager.l.d(r2, r3);
    }
}
