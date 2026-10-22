package com.bytedance.android.livesdk.interactivity.medialink.widget.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.medialink.logs.MediaMultiEnterRoomTracer;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/MediaMultiLinkAudienceControlPresenter;", "Lcom/bytedance/android/livesdk/chatroom/presenter/n;", "Lcom/bytedance/android/livesdk/interactivity/medialink/widget/presenter/IMediaMultiLinkAudienceControlView;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAudienceControlPresenter extends n<IMediaMultiLinkAudienceControlView> implements l, Observer<KVData> {
    public Room e;

    public final void h0() {
        Map r0 = this.e.getLinkMap();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.containsKey(String.valueOf(17)) == false) goto L11;
        Long r1 = (Long) r0.get(String.valueOf(17));
        if (r1 == null) goto L12;
        long r2 = r1.longValue();
        MediaMultiEnterRoomTracer.MultiLoadSource r3 = MediaMultiEnterRoomTracer.MultiLoadSource.RoomEnter;
        MediaMultiEnterRoomTracer.MultiLoadSource r4 = MediaMultiEnterRoomTracer.a;
        Intrinsics.checkNotNullParameter(r3, "source");
        MediaMultiEnterRoomTracer.b = System.currentTimeMillis();
        MediaMultiEnterRoomTracer.a = r3;
        ALogger.w("MediaLinkEnterRoomTracer", "multiLinkStart source=" + r3);
        ((q46.b) this).a.rM(b.C0184b.a, r2);
        return;
    L12:
        return;
    }

    public final void detachView() {
        super.detachView();
        DataCenter r0 = ((n) this).c;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public MediaMultiLinkAudienceControlPresenter(Room r2) {
        Intrinsics.checkNotNullParameter(r2, "mRoom");
        this.e = r2;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IMediaMultiLinkAudienceControlView) r1);
    }

    public final void g0(IMediaMultiLinkAudienceControlView r2) {
        super.c0(r2);
        DataCenter r3 = ((n) this).c;
        if (r3 == null) goto L5;
        r3.observe("data_interact_update_room_done", this);
    L5:
        d r4 = ((n) this).d;
        if (r4 == null) goto L8;
        r4.addMessageListener(MessageType.LINKER.getIntType(), this);
    L8:
        h0();
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == 826318596) goto L12;
        return;
    L12:
        if (r0.equals("data_interact_update_room_done") == false) goto L17;
        Room r6 = (Room) r5.getData();
        if (r6 == null) goto L18;
        this.e = r6;
        h0();
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onMessage(final tlc.d r9) {
        if ((r9 instanceof if) == true) goto L5;
        return;
    L5:
        if r0 = (if) r9;
        if (r0.mScene == 17) goto L9;
        return;
    L9:
        if (r0.getMType() != 6) goto L13;
        UtilityKotlinExtentionsKt.s(0, false, false, new AnonymousClass1(this, r9), 7);
        return;
    }
}
