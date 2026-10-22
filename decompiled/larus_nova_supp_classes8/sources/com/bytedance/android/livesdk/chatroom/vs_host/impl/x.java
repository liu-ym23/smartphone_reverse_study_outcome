package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.live.ISessionRecordService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x implements com.bytedance.android.scope.o, vr1.t {
    public x() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.t
    public final Intent getRecordPermissionIntent() {
        return com.bytedance.android.livesdk.service.l.d().e().getRecordPermissionIntent();
    }

    @Override // vr1.t
    public final boolean f(DataCenter r1) {
        return com.bytedance.android.livesdk.chatroom.record.u.d(r1);
    }

    @Override // vr1.t
    public final boolean isRecording(DataCenter r2) {
        if (r2 == null) goto L10;
        IAbilityCenter r3 = com.bytedance.android.live.core.utils.a0.a(r2);
        if (r3 == null) goto L10;
        IRoomRecordService r4 = r3.getAbility(IRoomRecordService.class);
        if (r4 == null) goto L10;
        if (r4.isRecording() != true) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // vr1.t
    public final void saveRecordPermissionIntent(Intent r2) {
        com.bytedance.android.livesdk.service.l.d().e().saveRecordPermissionIntent(r2);
    }

    @Override // vr1.t
    public final void setClearScreen(boolean r2) {
        com.bytedance.android.livesdk.service.l.d().e().setClearScreen(r2);
    }

    @Override // vr1.t
    public final String a(Context r1, String r2) {
        return com.bytedance.android.livesdk.chatroom.record.u.c(r1, r2);
    }

    @Override // vr1.t
    public final com.bytedance.android.livesdk.chatroom.ui.record.e c(Activity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "ownerDisplayName");
        return new com.bytedance.android.livesdk.chatroom.ui.record.e(r2, r3);
    }

    @Override // vr1.t
    public final void d(ILiveRecordService.RecordStatus r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "recording");
        if (r4 != null) goto L5;
    L17:
        com.bytedance.android.livesdk.service.l.d().e().setRecordStatus(r3);
        return;
    L5:
        if (com.bytedance.android.live.core.utils.a0.a(r4) == null) goto L17;
        IAbilityCenter r0 = com.bytedance.android.live.core.utils.a0.a(r4);
        if (r0 == null) goto L11;
        IRoomRecordService r1 = r0.getAbility(IRoomRecordService.class);
        if (r1 == null) goto L11;
        r1.setRecordStatus(r3);
    L11:
        IAbilityCenter r5 = com.bytedance.android.live.core.utils.a0.b(r4);
        if (r5 == null) goto L19;
        ISessionRecordService r6 = r5.getAbility(ISessionRecordService.class);
        if (r6 == null) goto L20;
        r6.callRecordStatsChangeListener(r3);
        return;
    L20:
        return;
    }
}
