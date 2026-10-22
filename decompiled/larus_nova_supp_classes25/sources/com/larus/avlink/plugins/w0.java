package com.larus.avlink.plugins;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.music.MusicScene;
import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import com.larus.voicecall.api.bean.ChatParam;
import com.larus.voicecall.api.bean.CommandType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w0 implements com.larus.platform.api.x {
    public final /* synthetic */ DoraFirstPartyAuthPlugin a;

    public final void b() {
        this.a.getClass();
    }

    public w0(DoraFirstPartyAuthPlugin r1) {
        this.a = r1;
    }

    public final void a(com.larus.platform.api.o4 r7) {
        Intrinsics.checkNotNullParameter(r7, "musicAuthResultData");
        this.a.getClass();
        IAiChatOpenDouyinAuthService r0 = this.a.o3();
        if (r0 == null) goto L6;
        r0.g();
    L6:
        if (r7.d == false) goto L14;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L11;
        r1.K0();
        com.larus.music.i.a.e(MusicScene.MusicSceneType.getValue(), r7.b);
    L11:
        if (r7.b != ThirdPartyMusicPlatform.LunaMusicType) goto L40;
        DoraFirstPartyAuthPlugin.k3(this.a);
    L40:
        DoraFirstPartyAuthPlugin r8 = this.a;
        r8.h = null;
        r8.g = false;
        if (r8.i3() == true) goto L44;
        this.a.v3();
        return;
    L44:
        return;
    L14:
        if (r7.a == false) goto L40;
        DoraFirstPartyAuthPlugin r2 = this.a;
        ThirdPartyMusicPlatform r9 = r7.b;
        com.larus.avlink.n1.d(r2.f, "requestAuthCard");
        CommandType r3 = r2.j;
        if (r3 == null) goto L40;
        IAiChatOpenDouyinAuthService r4 = (IAiChatOpenDouyinAuthService) ServiceManager.get().getService(IAiChatOpenDouyinAuthService.class);
        if (r4 == null) goto L40;
        ChatParam r5 = r3.getParam();
        if (r5 == null) goto L22;
        String r6 = r5.getQuestionId();
    L23:
        String r10 = "";
        if (r6 != null) goto L26;
        r6 = "";
    L26:
        String r11 = r9.getValue();
        ChatParam r12 = r3.getParam();
        if (r12 == null) goto L29;
        String r13 = r12.getCvsId();
    L30:
        if (r13 != null) goto L32;
        r13 = "";
    L32:
        ChatParam r14 = r3.getParam();
        if (r14 == null) goto L35;
        String r15 = r14.getBotId();
    L36:
        if (r15 == null) goto L39;
        r10 = r15;
    L39:
        r4.k(r6, r11, r13, r10);
        goto L40
    L35:
        r15 = null;
        goto L36
    L29:
        r13 = null;
        goto L30
    L22:
        r6 = null;
        goto L23
    }
}
