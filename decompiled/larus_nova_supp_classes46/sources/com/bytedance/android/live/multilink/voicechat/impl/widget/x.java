package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.wm.VoiceCommonMultiLinkWindowManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatRoomGuestWidget a;

    public x(MultiLinkVoiceChatRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        tf0.o r4 = this.a.Z;
        if ((r4 instanceof VoiceCommonMultiLinkWindowManager) == true) goto L5;
        r4 = null;
    L5:
        VoiceCommonMultiLinkWindowManager r5 = (VoiceCommonMultiLinkWindowManager) r4;
        if (r5 == null) goto L9;
        int r0 = VoiceCommonMultiLinkWindowManager.k0;
        r5.i1(false);
        return;
    }
}
