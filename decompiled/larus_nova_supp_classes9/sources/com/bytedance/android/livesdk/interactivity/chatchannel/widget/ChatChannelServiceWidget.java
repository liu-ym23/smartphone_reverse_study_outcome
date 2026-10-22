package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelServiceWidget extends RoomRecyclableWidget implements Observer<KVData> {
    public final CompositeDisposable a;

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.a.clear();
    }

    public ChatChannelServiceWidget() {
        this.a = new CompositeDisposable();
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L5;
        String r0 = r7.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == 1396550935) goto L12;
        return;
    L12:
        if (r0.equals("cmd_room_channel_show_invite_dialog") == false) goto L32;
        f62.b r8 = (f62.b) r7.getData();
        if (r8 == null) goto L33;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 != null) goto L19;
        return;
    L19:
        if (com.bytedance.android.live.core.utils.z.m(r1, true) == false) goto L37;
        Context r2 = getContext();
        if (r2 == null) goto L38;
        RoomContext r3 = getRoomContext();
        if (r3 == null) goto L39;
        s22.e r4 = ChatChannelUtils.b(r3);
        if (r4 == null) goto L40;
        s22.a r5 = r8.c;
        n62.h.b(r2, r3, r1, r4).d(r5, r8.b);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L33:
        return;
    L32:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onLoad(Object[] r2) {
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L6;
        r3.observe("cmd_room_channel_show_invite_dialog", this);
        return;
    }
}
