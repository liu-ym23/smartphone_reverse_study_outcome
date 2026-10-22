package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements nj0.c {
    public final /* synthetic */ IAudioSubtitleContent a;
    public final /* synthetic */ RadioSubtitleComponent$startSubTitleWithDependence$1 b;

    public q(IAudioSubtitleContent r1, RadioSubtitleComponent$startSubTitleWithDependence$1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // nj0.c
    public final void a(boolean r3, CustomApiServerException r4) {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] updateSubtitleSetting onResult isSuccess:" + r3);
        if (r3 == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e r5 = b6.p0;
        IAudioSubtitleContent r6 = this.a;
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r6);
        this.b.m387invoke();
        return;
    L5:
        StringBuilder r7 = new StringBuilder("[RadioSubtitleComponent][AudioSubtitle] updateSubtitleSetting error:");
        if (r4 == null) goto L8;
        String r8 = r4.getMessage();
    L9:
        r7.append(r8);
        ALogger.e("RadioStageContainerWidget", r7.toString());
        return;
    L8:
        r8 = null;
        goto L9
    }
}
