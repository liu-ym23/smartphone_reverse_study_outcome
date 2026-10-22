package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 extends d {
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d
    public final void d0(r1 r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        f2.b(2131919297, 0);
        if (this.g == false) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r1 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r1 == null) goto L10;
        r1.switchAudioByClient(true, r10.getLinkedUsers(), r10.getClientUiInfo(), r10.getVersion(), r10.getLinkerContentMap(), "self_panel");
    L10:
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L19;
        List r0 = r10.getLinkedUsers();
        if (r0 == null) goto L16;
        List r3 = CollectionsKt.toMutableList(r0);
        if (r3 == null) goto L16;
    L17:
        r2.switchAudioByClient(true, r3, r10.getClientUiInfo(), r10.getVersion(), r10.getLinkerContentMap(), "self_panel");
        return;
    L16:
        r3 = new ArrayList();
        goto L17
    L19:
        return;
    L7:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r4 = IVoiceChatGuestService.a.a();
        if (r4 == null) goto L10;
        r4.switchAudioByClient(true, r10.getLinkedUsers(), r10.getClientUiInfo(), r10.getVersion(), r10.getLinkerContentMap(), "self_panel");
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d
    public final void e0(c2 r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        f2.c(s1.B(2131923173), 0);
        if (this.g == false) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r1 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r1 == null) goto L10;
        r1.switchAudioByClient(false, r10.getLinkedUsers(), r10.getClientUiInfo(), r10.getVersion(), r10.getLinkerContentMap(), "self_panel");
    L10:
        IKtvService r2 = jc1.k.f(IKtvService.class);
        if (r2 == null) goto L19;
        List r0 = r10.getLinkedUsers();
        if (r0 == null) goto L16;
        List r3 = CollectionsKt.toMutableList(r0);
        if (r3 == null) goto L16;
    L17:
        r2.switchAudioByClient(false, r3, r10.getClientUiInfo(), r10.getVersion(), r10.getLinkerContentMap(), "self_panel");
        return;
    L16:
        r3 = new ArrayList();
        goto L17
    L19:
        return;
    L7:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r4 = IVoiceChatGuestService.a.a();
        if (r4 == null) goto L10;
        r4.switchAudioByClient(false, r10.getLinkedUsers(), r10.getClientUiInfo(), r10.getVersion(), r10.getLinkerContentMap(), "self_panel");
        goto L10
    }

    public f0(boolean r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3);
    }
}
