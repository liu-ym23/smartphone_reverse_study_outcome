package ue0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.feed.datamerge.k;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.livesdkapi.service.MessageHub;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends com.bytedance.android.live.liveinteract.feed.datamerge.a implements l {
    public final IRoom b;

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        ALogger.i("RadioStageContainerWidget", "MultiLinkFeedViewRadioGiftMessageHandler atatch:" + c().getShowFrom());
        int r0 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(c().getShowFrom()) == false) goto L14;
        k r1 = this.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L7:
        MessageHub r2 = r1.getMessageHub();
        if ((r2 instanceof xlc.a) == true) goto L10;
        r2 = null;
    L10:
        xlc.a r3 = (xlc.a) r2;
        if (r3 == null) goto L15;
        r3.D(MessageType.GIFT_COMMENT_MESSAGE.getIntType(), this, "MetaSubSyncKey");
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        k r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        MessageHub r1 = r0.getMessageHub();
        if (r1 == null) goto L9;
        r1.removeMessageListener(MessageType.GIFT_COMMENT_MESSAGE.getIntType(), this);
        return;
    }

    public g(IRoom r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.a
    public final void d(k r2) {
        Intrinsics.checkNotNullParameter(r2, "proxy");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void onMessage(tlc.d r3) {
        ALogger.i("RadioStageContainerWidget", "MultiLinkFeedViewRadioGiftMessageHandler onMessage:" + r3);
        if ((r3 instanceof cj) == false) goto L6;
        c().q((cj) r3);
        return;
    }
}
