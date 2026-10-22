package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/toolbar/KtToolbarInteractRoomBehavior;", "Lcom/bytedance/android/live/liveinteract/voicechat/toolbar/ToolbarInteractRoomBehavior;", "Lvlc/l;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtToolbarInteractRoomBehavior extends ToolbarInteractRoomBehavior {
    public KtToolbarInteractRoomBehavior() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.toolbar.ToolbarInteractRoomBehavior
    public final void onMessage(tlc.d r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        if ((r3 instanceof LinkMicGuideMessage) == false) goto L6;
        long r0 = ((LinkMicGuideMessage) r3).guidelineType;
        return;
    }
}
