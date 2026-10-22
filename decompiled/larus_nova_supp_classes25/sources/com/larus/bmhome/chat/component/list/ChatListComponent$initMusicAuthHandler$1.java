package com.larus.bmhome.chat.component.list;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.music.MusicScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponent$initMusicAuthHandler$1 implements com.larus.platform.api.x {
    public final /* synthetic */ ChatListComponent a;

    public final void b() {
    }

    public ChatListComponent$initMusicAuthHandler$1(ChatListComponent r1) {
        this.a = r1;
    }

    public final void a(com.larus.platform.api.o4 r8) {
        Intrinsics.checkNotNullParameter(r8, "musicAuthResultData");
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        IAiChatOpenDouyinAuthService r2 = r0.V4();
        if (r2 == null) goto L6;
        r2.g();
    L6:
        if (r8.d == false) goto L10;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L10;
        r3.K0();
        com.larus.music.i.a.e(MusicScene.MusicSceneType.getValue(), r8.b);
    L10:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new ChatListComponent$initMusicAuthHandler$1$handleMusicAuthResultFrom$1(r8, this.a, null), 3, null);
    }
}
