package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements jk0.e {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    @Override // jk0.e
    public final void onStop() {
        int r0 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.b(Integer.valueOf(this.a.v)) == false) goto L15;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r1 = this.a.getDynamicWidget();
        if (r1 == null) goto L11;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r2 = this.a.x1;
        if (r2 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r3 = r2.b;
    L10:
        r1.Tl(r3);
        goto L11
    L9:
        r3 = null;
    L11:
        JsonObject r4 = new JsonObject();
        r4.addProperty("state", Boolean.FALSE);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r5 = this.a.getDynamicWidget();
        if (r5 == null) goto L16;
        r5.Dk("root", "radio_stage_state", r4, false);
        return;
    L16:
        return;
    }

    public v(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    @Override // jk0.e
    public final void onStart(String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        int r6 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.b(Integer.valueOf(this.a.v)) == false) goto L15;
        JsonObject r7 = new JsonObject();
        r7.addProperty("state", Boolean.TRUE);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r0 = this.a.getDynamicWidget();
        if (r0 == null) goto L7;
        r0.Dk("root", "radio_stage_state", r7, false);
    L7:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r8 = this.a.getDynamicWidget();
        if (r8 == null) goto L16;
        com.bytedance.android.live.liveinteract.voicechat.radio.k r1 = this.a.x1;
        if (r1 == null) goto L12;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r2 = r1.b;
    L13:
        r8.Gb("radio_stage", r2);
        return;
    L12:
        r2 = null;
        goto L13
    L16:
        return;
    }
}
