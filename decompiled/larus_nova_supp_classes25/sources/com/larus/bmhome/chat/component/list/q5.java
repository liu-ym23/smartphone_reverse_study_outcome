package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.music.MusicScene;
import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallConfigServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ya8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q5 implements a {
    public final /* synthetic */ ChatListComponent a;

    public q5(ChatListComponent r1) {
        this.a = r1;
    }

    @Override // ya8.a
    public final void a(boolean r10, Message r11) {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        IAiChatOpenDouyinAuthService r2 = r0.V4();
        if (r2 == null) goto L5;
        r2.g();
    L5:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("isInRealtimeCall: ");
        r4.append(VoiceCallConfigServiceDelegate.b.l());
        r4.append(", isInDoraCall: ");
        ChatListComponentViewModel r5 = this.a.U5();
        if (r11 == null) goto L8;
        String r6 = d.G(r11);
    L9:
        r4.append(r5.isInDoraCallAndMsgFromVUI(r6));
        r3.i("ChatListComponentViewModel", r4.toString());
        if (r10 == false) goto L14;
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L14;
        r7.K0();
        com.larus.music.i.a.e(MusicScene.MusicSceneType.getValue(), ThirdPartyMusicPlatform.LunaMusicType);
    L14:
        ChatListComponent.C3(this.a, r11, r10, false, ThirdPartyMusicPlatform.LunaMusicType, true);
        return;
    L8:
        r6 = null;
        goto L9
    }
}
