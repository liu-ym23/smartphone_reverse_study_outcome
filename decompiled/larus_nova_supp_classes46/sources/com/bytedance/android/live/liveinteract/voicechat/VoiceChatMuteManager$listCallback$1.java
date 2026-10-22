package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class VoiceChatMuteManager$listCallback$1 extends com.bytedance.android.live.liveinteract.plantform.base.i.a<ILinkPlayerInfoBridge> {
    public final /* synthetic */ VoiceChatMuteManager a;

    public VoiceChatMuteManager$listCallback$1(VoiceChatMuteManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r7) {
        if (this.a.p() == true) goto L5;
        return;
    L5:
        if (this.a.t.O5() == true) goto L8;
        return;
    L8:
        if (this.a.o() != 0) goto L12;
        UtilityKotlinExtentionsKt.s(0, false, true, new VoiceChatMuteManager$listCallback$1$onOnlineListChanged$1(this), 3);
        return;
    }
}
