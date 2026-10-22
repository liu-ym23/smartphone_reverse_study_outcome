package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.content.DialogInterface;
import com.bytedance.android.live.liveinteract.voicechat.util.VoiceInteractSceneUtil;
import com.bytedance.android.live.multilink.impl.LinkMultiControlWidget;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ jk0.a a;

    public i(LinkMultiControlWidget.f r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        LinkMultiControlWidget.f r7 = (LinkMultiControlWidget.f) this.a;
        r7.getClass();
        VoiceInteractSceneUtil.a.i(r7.a, ((Widget) r7.b).context.getSupportFragmentManager(), ((Widget) r7.b).context, null);
        r5.dismiss();
    }
}
