package com.bytedance.android.live.liveinteract.chatroom.chatroom.vm;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.x8;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfoModelExtensionKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00140\u000f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/vm/MicRoomHostViewModel;", "Lcom/bytedance/android/live/core/utils/rxutils/RxViewModel;", "Lvlc/l;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "initViewModel", "onCleared", "Ltlc/d;", MultiLinkOpenSource.MESSAGE, "onMessage", "", "uid", "", "isMicRoomHost", "Landroidx/lifecycle/MutableLiveData;", "hostStats", "Landroidx/lifecycle/MutableLiveData;", "getHostStats", "()Landroidx/lifecycle/MutableLiveData;", "", "hostList", "getHostList", "mDataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lvlc/d;", "messageManager", "Lvlc/d;", "getMessageManager", "()Lvlc/d;", "setMessageManager", "(Lvlc/d;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", PbRequest.SwitchType.ROOM, "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MicRoomHostViewModel extends RxViewModel implements l {
    private final MutableLiveData<List<String>> hostList;
    private final MutableLiveData<Boolean> hostStats;
    private DataCenter mDataCenter;
    private d messageManager;
    private IRoom room;

    public MicRoomHostViewModel() {
        this.hostStats = new MutableLiveData();
        this.hostList = new MutableLiveData();
    }

    public void onCleared() {
        super.onCleared();
        d r0 = this.messageManager;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public final MutableLiveData<List<String>> getHostList() {
        return this.hostList;
    }

    public final MutableLiveData<Boolean> getHostStats() {
        return this.hostStats;
    }

    public final d getMessageManager() {
        return this.messageManager;
    }

    public final IRoom getRoom() {
        return this.room;
    }

    public final void initViewModel(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.mDataCenter = r4;
        this.hostStats.setValue(Boolean.FALSE);
        this.hostList.setValue(CollectionsKt.emptyList());
        DataCenter r0 = this.mDataCenter;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        d r2 = (d) r0.get("data_message_manager");
    L6:
        this.messageManager = r2;
        if (r2 == null) goto L9;
        r2.addMessageListener(MessageType.LINKMIC_HOST_MODIFY.getKey(), this);
    L9:
        DataCenter r3 = this.mDataCenter;
        if (r3 == null) goto L12;
        r1 = (IRoom) r3.get("data_room");
    L12:
        this.room = r1;
        if (r1 == null) goto L18;
        IOfficialChannelInfo r5 = r1.getOfficialChannelInfo();
        if (r5 == null) goto L19;
        this.hostStats.setValue(Boolean.valueOf(r5.getHasHostPermission()));
        this.hostList.setValue(IOfficialChannelInfoModelExtensionKt.getHostUids(r5));
        r4.put("data_microom_host_stats", this.hostStats.getValue());
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean isMicRoomHost(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        List r0 = (List) this.hostList.getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        return StringsKt.contains$default(r0.toString(), r5, false, 2, null);
    }

    public void onMessage(tlc.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        e r1 = r0.user();
        if (r1 == null) goto L9;
        String r2 = r1.n();
    L11:
        if ((r3 instanceof x8) == false) goto L18;
        List r4 = ((x8) r3).getUserIdString();
        if (r4 == null) goto L19;
        this.hostStats.setValue(Boolean.valueOf(r4.contains(r2)));
        this.hostList.setValue(r4);
        DataCenter r5 = this.mDataCenter;
        if (r5 == null) goto L20;
        r5.put("data_microom_host_stats", this.hostStats.getValue());
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L9:
        r2 = null;
        goto L11
    }

    public final void setMessageManager(d r1) {
        this.messageManager = r1;
    }

    public final void setRoom(IRoom r1) {
        this.room = r1;
    }
}
