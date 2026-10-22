package com.bytedance.android.livesdk.interactivity.medialink.widget.presenter;

import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ey.g;
import ey.k;
import fy.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/MediaMultiLinkAnchorControlPresenter;", "Lcom/bytedance/android/livesdk/chatroom/presenter/n;", "Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/IMediaMultiLinkAnchorControlView;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAnchorControlPresenter extends n<IMediaMultiLinkAnchorControlView> implements Observer<KVData>, l {
    public final nc0.b e;
    public final Room f;
    public final k g;

    public final void detachView() {
        super.detachView();
        DataCenter r0 = ((n) this).c;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        d r1 = ((n) this).d;
        if (r1 == null) goto L9;
        r1.removeMessageListener(this);
        return;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IMediaMultiLinkAnchorControlView) r1);
    }

    public final void g0(IMediaMultiLinkAnchorControlView r2) {
        super.c0(r2);
        DataCenter r3 = ((n) this).c;
        if (r3 == null) goto L5;
        r3.observe("data_interact_update_room_done", this);
    L5:
        d r4 = ((n) this).d;
        if (r4 == null) goto L9;
        r4.addMessageListener(MessageType.ANCHOR_LINK_MIC_BACKSTAGE_INVITE_MESSAGE.getIntType(), this);
        return;
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }

    public final void onMessage(tlc.d r29) {
        if (r29 != null) goto L6;
        return;
    L6:
        if ((r29 instanceof com.bytedance.android.livesdk.link.model.bridge.l) == false) goto L13;
        com.bytedance.android.livesdk.link.model.bridge.l r1 = (com.bytedance.android.livesdk.link.model.bridge.l) r29;
        if (r1.getScene() != 17) goto L14;
        k r2 = this.g;
        if (r2 == null) goto L15;
        int r4 = r1.getScene();
        long r5 = this.f.getRoomId();
        long r7 = CastLongProtector.parseLong(r1.getToRoomId());
        int r9 = r1.getInviteType();
        int r10 = r1.getMatchType();
        String r11 = r1.getToRevUid();
        Room r13 = new Room();
        int r16 = r1.getInviteSource();
        Intrinsics.checkNotNullParameter(r1, "$this$inviteeUserIds");
        r2.b(new e(r4, r5, r7, r9, r10, r11, BuildConfig.FLAVOR, r13, null, null, r16, StringsKt.split$default(r1.getToRevInviteeFollowedUserIds(), new String[]{","}, false, 0, 6, null), null, null, 8351488));
        return;
    L15:
        return;
    L14:
        return;
    }

    public MediaMultiLinkAnchorControlPresenter(Room r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "mRoom");
        this.f = r2;
        this.g = r3;
        g.a.getClass();
        this.e = g.a.a();
    }
}
