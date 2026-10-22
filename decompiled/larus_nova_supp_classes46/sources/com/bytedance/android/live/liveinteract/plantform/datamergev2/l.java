package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.VideoChatDynamic1V7Info;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements d {
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> a;
    public final IRoom b;
    public final DataCenter c;
    public final j1 d;

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void a() {
    }

    public final void addWRDSListener(IPreviewSyncDataType r1, OnWRDSDataUpdateListener r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void b(int r1) {
    }

    public final <T extends tlc.d> T getLatestWRDSMessage(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "messageMethod");
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final int getShowFrom() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void j(boolean r1) {
    }

    public final void removeWRDSListener(IPreviewSyncDataType r2, OnWRDSDataUpdateListener r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "listener");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final List<ILinkPlayerInfoBridge> c() {
        return this.a.c();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final List<LinkmicPositionItem> d() {
        return this.a.d();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final List<ILinkPlayerInfoBridge> getOnlineList() {
        return this.a.getOnlineUserList();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.m
    public final IRoom getRoom() {
        IRoom r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        com.bytedance.live.datacontext.m r1 = o3.j(this.c).getRoom();
        if (r1 != null) goto L10;
        return null;
    L10:
        return (IRoom) r1.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final boolean n() {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L32;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.c, 0, 2);
        RoomLinkMicSyncData r3 = null;
        if (r0 == null) goto L9;
        n r1 = r0.isRoomVisible();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
    L11:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L18;
        IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r4 != null) goto L15;
        return false;
    L15:
        if (r4.isCurrentMicSeatFold(this.c) != true) goto L39;
        return true;
    L39:
        return false;
    L18:
        IInteractService r5 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r5 == null) goto L23;
        IMultiLinkWRDSPreloadService r6 = r5.getMultiLinkWRDSPreloadService();
        if (r6 == null) goto L23;
        r3 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(r6, "inner_feed", this.b, false, 4, null);
    L23:
        if (r3 == null) goto L40;
        ClientUIInfo r7 = r3.clientUIInfo;
        if (r7 == null) goto L41;
        VideoChatDynamic1V7Info r8 = r7.getVideoChatDynamic1V7Info();
        if (r8 != null) goto L29;
        return false;
    L29:
        if (r8.getStatus() != 2) goto L43;
        return true;
    L43:
        return false;
    L41:
        return false;
    L40:
        return false;
    L9:
        r2 = null;
        goto L11
    L32:
        IInteractService r9 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r9 != null) goto L35;
        return false;
    L35:
        if (r9.isCurrentMicSeatFold(this.c) != true) goto L45;
        return true;
    L45:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void f(com.bytedance.android.live.liveinteract.plantform.base.i.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.Q4(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void k(com.bytedance.android.live.liveinteract.plantform.base.i.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.T4(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final ILivePlayerClient o(DataCenter r3) {
        if (r3 == null) goto L6;
        IRoom r4 = a0.o(r3);
        if (r4 == null) goto L6;
        long r0 = r4.getRoomId();
    L8:
        return LivePlatformPlayerManager.a(r0, false);
    L6:
        r0 = 0;
        goto L8
    }

    public final void addMessageListener(String r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.bytedance.live.datacontext.j r0 = o3.j(this.c).getMessageManager();
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.getValue();
        if (r1 == null) goto L9;
        r1.addMessageListener(r2, r3);
        return;
    L9:
        return;
    }

    public final void removeMessageListener(String r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.bytedance.live.datacontext.j r0 = o3.j(this.c).getMessageManager();
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.getValue();
        if (r1 == null) goto L9;
        r1.removeMessageListener(r2, r3);
        return;
    L9:
        return;
    }

    public final void addMessageListener(int r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.bytedance.live.datacontext.j r0 = o3.j(this.c).getMessageManager();
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.getValue();
        if (r1 == null) goto L9;
        r1.addMessageListener(r2, r3);
        return;
    L9:
        return;
    }

    public final void removeMessageListener(int r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.bytedance.live.datacontext.j r0 = o3.j(this.c).getMessageManager();
        if (r0 == null) goto L8;
        vlc.d r1 = (vlc.d) r0.getValue();
        if (r1 == null) goto L9;
        r1.removeMessageListener(r2, r3);
        return;
    L9:
        return;
    }

    public l(com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2, IRoom r3, DataCenter r4, j1 r5) {
        Intrinsics.checkNotNullParameter(r2, "linkUserCenter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamergev2.d
    public final void m(String r4, int r5, String r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "subTag");
        Intrinsics.checkNotNullParameter(r6, "content");
        if (r7 == false) goto L5;
        ALogger.d("MergeDataCenter", r4 + '#' + r5 + ", content=" + r6);
        return;
    L5:
        if (r8 == false) goto L7;
        ALogger.e("MergeDataCenter", r4 + '#' + r5 + ", content=" + r6);
        return;
    L7:
        ALogger.i("MergeDataCenter", r4 + '#' + r5 + ", content=" + r6);
    }
}
