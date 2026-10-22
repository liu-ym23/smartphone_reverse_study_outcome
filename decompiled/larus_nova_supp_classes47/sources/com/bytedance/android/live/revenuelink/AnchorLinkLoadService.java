package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.revenuelink.connect.ConnectDataContext;
import com.bytedance.android.live.revenuelink.rtc.AnchorRtcManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001-B/\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/bytedance/android/live/revenuelink/AnchorLinkLoadService;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/tools/kcp/kmpscope/runtime/ScopeService;", "Lcom/bytedance/live/datacontext/DataContext;", "", "onStart", "onStop", "Lcom/bytedance/android/live/revenuelink/connect/ConnectDataContext;", "connectDataContext", "Lcom/bytedance/android/live/revenuelink/connect/ConnectDataContext;", "getConnectDataContext", "()Lcom/bytedance/android/live/revenuelink/connect/ConnectDataContext;", "setConnectDataContext", "(Lcom/bytedance/android/live/revenuelink/connect/ConnectDataContext;)V", "Lcom/bytedance/android/live/revenuelink/rtc/AnchorRtcManager;", "anchorRtcManager", "Lcom/bytedance/android/live/revenuelink/rtc/AnchorRtcManager;", "getAnchorRtcManager", "()Lcom/bytedance/android/live/revenuelink/rtc/AnchorRtcManager;", "setAnchorRtcManager", "(Lcom/bytedance/android/live/revenuelink/rtc/AnchorRtcManager;)V", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/android/live/revenuelink/withroom/a;", "linkStoreService", "Lcom/bytedance/android/live/revenuelink/withroom/a;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lyz0/g;", "roomDataService", "Lyz0/g;", "Lp11/c;", "pkService", "Lp11/c;", "getPkService", "()Lp11/c;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "revRoomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "<init>", "(Lcom/bytedance/android/live/revenuelink/withroom/a;Lyz0/f;Lyz0/g;Lp11/c;Lcom/bytedance/android/livesdk/revenue/service/room/c;)V", "Companion", "a", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkLoadService extends DataContext implements o {
    public static final a Companion = null;
    public static final String TAG = "AnchorLinkLoadService";
    private AnchorRtcManager anchorRtcManager;
    private ConnectDataContext connectDataContext;
    private Disposable disposable;
    private final com.bytedance.android.live.revenuelink.withroom.a linkStoreService;
    private final yz0.f messageService;
    private final p11.c pkService;
    private final com.bytedance.android.livesdk.revenue.service.room.c revRoomService;
    private final yz0.g roomDataService;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public void onStart() {
        this.disposable = (Disposable) com.bytedance.live.datacontext.d.a(new AnonymousClass1(this)).getSecond();
        if (this.roomDataService.isAnchor() == false) goto L11;
        this.connectDataContext = new ConnectDataContext(this.linkStoreService, this.messageService, this.roomDataService);
        IRoom r1 = this.roomDataService.mo444getRoom();
        if (r1 == null) goto L10;
        this.anchorRtcManager = new AnchorRtcManager(r1, this.linkStoreService, this.pkService, this.roomDataService);
        if (((Boolean) com.bytedance.android.live.revenuelink.a.b.getValue(null, com.bytedance.android.live.revenuelink.a.a[0])).booleanValue() == false) goto L12;
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.revRoomService;
        Intrinsics.checkNotNullParameter(r0, "revRoomService");
        r0.getRoomContext().setRevnueLinkHasLoad(true);
        return;
    L12:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoomKt /* = com.bytedance.android.livesdkapi.depend.model.live.IRoom */");
    }

    public void onStop() {
        ConnectDataContext r0 = this.connectDataContext;
        if (r0 == null) goto L5;
        r0.onStop();
    L5:
        AnchorRtcManager r1 = this.anchorRtcManager;
        if (r1 == null) goto L8;
        r1.t();
    L8:
        Disposable r2 = this.disposable;
        if (r2 == null) goto L12;
        r2.dispose();
        return;
    }

    public final AnchorRtcManager getAnchorRtcManager() {
        return this.anchorRtcManager;
    }

    public final ConnectDataContext getConnectDataContext() {
        return this.connectDataContext;
    }

    public final p11.c getPkService() {
        return this.pkService;
    }

    public final void setAnchorRtcManager(AnchorRtcManager r1) {
        this.anchorRtcManager = r1;
    }

    public final void setConnectDataContext(ConnectDataContext r1) {
        this.connectDataContext = r1;
    }

    public AnchorLinkLoadService(com.bytedance.android.live.revenuelink.withroom.a r2, yz0.f r3, yz0.g r4, p11.c r5, com.bytedance.android.livesdk.revenue.service.room.c r6) {
        Intrinsics.checkNotNullParameter(r2, "linkStoreService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        Intrinsics.checkNotNullParameter(r5, "pkService");
        Intrinsics.checkNotNullParameter(r6, "revRoomService");
        this.linkStoreService = r2;
        this.messageService = r3;
        this.roomDataService = r4;
        this.pkService = r5;
        this.revRoomService = r6;
    }
}
