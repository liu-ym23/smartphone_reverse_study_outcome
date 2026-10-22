package com.bytedance.android.live.liveinteract.plantform.multiroom;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.utils.j;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkMicGameWindowHelper;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h0;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.n;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.revenue.PaidLinkMicPlayModeHandler;
import com.bytedance.android.live.liveinteract.plantform.datamerge.i;
import com.bytedance.android.live.liveinteract.plantform.datamerge.k;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.LinkMicGameWindowHelperV2;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.LinkRoomFightWindowListHelperV2;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.WindowListHelperV2;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.f;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.g;
import com.bytedance.android.live.liveinteract.plantform.datamergev2.l;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.wrdspreload.MultiLinkWRDSPreloadManager;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.multilink.IMultiLinkWRDSPreloadService;
import com.bytedance.android.livesdkapi.multilink.RoomLinkMicSyncDataPreloadBizListener;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yg0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/multiroom/MultiLinkMicSeatDataWidget;", "Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/multiroom/a;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkMicSeatDataWidget extends BaseMultiLinkWidget implements com.bytedance.android.live.liveinteract.plantform.multiroom.a {
    public final String a;
    public final CompositeDisposable b;
    public l c;
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.b d;
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.a e;
    public com.bytedance.android.live.liveinteract.plantform.datamergev2.a f;
    public y g;
    public com.bytedance.android.live.liveinteract.plantform.datamerge.a h;
    public m i;
    public final BehaviorSubject<List<tf0.e>> j;
    public final j k;
    public final MultiLinkWRDSPreloadManager l;
    public final b m;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiLinkMicSeatDataWidget a;

        public a(MultiLinkMicSeatDataWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            MultiLinkMicSeatDataWidget r0 = this.a;
            String r1 = r0.a;
            r0.getMRoom().getId();
            com.bytedance.android.live.liveinteract.plantform.datamerge.a r2 = this.a.h;
            if (r2 == null) goto L5;
            r2.hashCode();
        L5:
            this.a.j.onNext(r4);
        }
    }

    public static final class b implements RoomLinkMicSyncDataPreloadBizListener {
        public final /* synthetic */ MultiLinkMicSeatDataWidget a;

        public b(MultiLinkMicSeatDataWidget r1) {
            this.a = r1;
        }

        public final void receiveWrds(RoomLinkMicSyncData r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            y r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.j(r2);
            return;
        }
    }

    public static final class c implements md0.a.InterfaceC0236a {
        public final /* synthetic */ MultiLinkMicSeatDataWidget a;

        @Override // md0.a.InterfaceC0236a
        public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
        }

        public c(MultiLinkMicSeatDataWidget r1) {
            this.a = r1;
        }

        @Override // md0.a.InterfaceC0236a
        public final void onSeiUpdated(SeiAppData r2) {
            com.bytedance.android.live.liveinteract.plantform.datamergev2.b r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.t0(r2);
        L5:
            com.bytedance.android.live.liveinteract.plantform.datamergev2.a r1 = this.a.e;
            if (r1 == null) goto L8;
            r1.t0(r2);
        L8:
            com.bytedance.android.live.liveinteract.plantform.datamergev2.a r3 = this.a.f;
            if (r3 == null) goto L12;
            r3.t0(r2);
            return;
        }

        @Override // md0.a.InterfaceC0236a
        public final boolean isVersionSupported(int r4, int r5) {
            if (r4 != 9) goto L5;
        L12:
            boolean r0 = true;
        L13:
            if (r0 == false) goto L15;
        L36:
            boolean r6 = true;
        L37:
            if (r6 == true) goto L40;
            ln0.a r7 = h.a;
            if (h.i(r5) == true) goto L40;
            return false;
        L40:
            return true;
        L15:
            if (r4 != 10) goto L17;
        L22:
            boolean r1 = true;
        L23:
            if (r1 == true) goto L36;
            if (r4 != 8) goto L27;
        L30:
            boolean r2 = true;
        L31:
            if (r2 == true) goto L36;
            if (aj0.b.b(Integer.valueOf(r4)) == true) goto L36;
            r6 = false;
            goto L37
        L27:
            if (r4 == 5) goto L30;
            r2 = false;
            goto L31
        L17:
            if (r4 == 12) goto L22;
            if (r4 == 15) goto L22;
            r1 = false;
            goto L23
        L5:
            if (r4 == 11) goto L12;
            if (r4 == 13) goto L12;
            if (r4 == 16) goto L12;
            r0 = false;
            goto L13
        }
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return 0;
    }

    public final void wq() {
        if (g.a(0) == false) goto L13;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r0 = this.d;
        if (r0 == null) goto L7;
        r0.O1();
    L7:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r1 = this.e;
        if (r1 == null) goto L10;
        r1.O1();
    L10:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r2 = this.f;
        if (r2 == null) goto L26;
        r2.O1();
        return;
    L26:
        return;
    L13:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r3 = this.d;
        if ((r3 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L16;
        r3 = null;
    L16:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r4 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r3;
        if (r4 == null) goto L19;
        r4.O1();
    L19:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r5 = this.e;
        if (r5 == null) goto L22;
        r5.O1();
    L22:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r6 = this.f;
        if (r6 == null) goto L28;
        r6.O1();
        return;
    }

    public final IRoom getMRoom() {
        com.bytedance.live.datacontext.m r0 = o3.h(this, ((Widget) this).dataCenter).getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new Room();
    }

    public final boolean isAnchor() {
        Boolean r0 = o3.h(this, ((Widget) this).dataCenter).isAnchor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final hg6.g xq() {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L8;
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRtcManager();
    L8:
        cg6.a r1 = getScopeServiceInMultiLinkRoom(cg6.a.class);
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.getRtcManager();
    }

    public MultiLinkMicSeatDataWidget() {
        this.a = "MultiLinkMicSeatDataWidget";
        this.b = new CompositeDisposable();
        this.j = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.k = new j(new c(this));
        Lazy r0 = MultiLinkWRDSPreloadManager.i;
        this.l = MultiLinkWRDSPreloadManager.a.a();
        this.m = new b(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        int r0 = e.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        Intrinsics.checkNotNullParameter(this, "service");
        r1.put("data_mic_seat_data_service", this);
        this.g = new y(getMRoom(), ((Widget) this).dataCenter);
        int r2 = 0;
        if (g.a(0) == false) goto L5;
        y r6 = this.g;
        Intrinsics.checkNotNull(r6);
        hg6.g r3 = xq();
        this.c = new l(r6, getMRoom(), ((Widget) this).dataCenter, this);
        this.d = new com.bytedance.android.live.liveinteract.plantform.datamergev2.h(this, this.c, new we0.a(), r3, 0, ((Widget) this).dataCenter, this);
        this.e = new f(this, r3, ((Widget) this).dataCenter, 0, this.c);
        this.f = new com.bytedance.android.live.liveinteract.plantform.datamergev2.e(this, r6, r3, ((Widget) this).dataCenter, 0, this.c);
        Pair r4 = com.bytedance.live.datacontext.d.a(MultiLinkMicSeatDataWidget$initLinkUserDataMergeCenterV2$pair$1.INSTANCE);
        LinkUserDataMergeContext r5 = (LinkUserDataMergeContext) r4.getFirst();
        r5.getDataMergeCenter().d(this.d);
        r5.getLinkRoomFightDataMergeCenter().d(this.e);
        r5.share(((Widget) this).dataCenter);
        this.b.add((Disposable) r4.getSecond());
        ((Widget) this).dataCenter.put("data_multi_link_data_merge_center_init", Boolean.TRUE);
    L12:
        wq();
        yq(null, "onCreate");
        this.l.addRoomLinkMicSyncDataBizListener("inner_feed", getMRoom().getId(), this.m);
        RoomLinkMicSyncData r7 = IMultiLinkWRDSPreloadService.DefaultImpls.getRoomLinkMicSyncData$default(this.l, "inner_feed", getMRoom(), false, 4, null);
        if (r7 == null) goto L17;
        y r8 = this.g;
        if (r8 == null) goto L17;
        r8.j(r7);
    L17:
        String r9 = this.a;
        int r10 = hashCode();
        StringBuilder r11 = new StringBuilder("MultiLinkMicSeatDataWidget#onCreate, roomId=");
        r11.append(getMRoom().getId());
        r11.append(", linkUserInfoCenter=");
        r11.append(this.g);
        r11.append('#');
        y r12 = this.g;
        if (r12 == null) goto L20;
        int r13 = r12.hashCode();
    L21:
        r11.append(r13);
        r11.append(", linkUserDataMergeCenter=");
        r11.append(this.d);
        r11.append('#');
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r14 = this.d;
        if (r14 == null) goto L24;
        int r15 = r14.hashCode();
    L25:
        r11.append(r15);
        r11.append(", windowListHelper=");
        r11.append(this.h);
        r11.append('#');
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r16 = this.h;
        if (r16 == null) goto L28;
        r2 = r16.hashCode();
    L28:
        r11.append(r2);
        r11.append(", windowListObservable=");
        r11.append(this.j);
        zq(r9, r10, r11.toString());
        return;
    L24:
        r15 = 0;
        goto L25
    L20:
        r13 = 0;
        goto L21
    L5:
        y r17 = this.g;
        Intrinsics.checkNotNull(r17);
        hg6.g r18 = xq();
        this.d = new com.bytedance.android.live.liveinteract.plantform.datamerge.j(this, r17, new we0.a(), r18, this, ((Widget) this).dataCenter, true);
        this.e = new com.bytedance.android.live.liveinteract.plantform.datamerge.h(this, r17, r18, ((Widget) this).dataCenter);
        this.f = new com.bytedance.android.live.liveinteract.plantform.datamerge.e(this, r17, r18, ((Widget) this).dataCenter);
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d r19 = new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.d();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r20 = this.d;
        if ((r20 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L8;
        r20 = null;
    L8:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r21 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r20;
        if (r21 == null) goto L11;
        r21.M0(r19);
    L11:
        Pair r22 = com.bytedance.live.datacontext.d.a(MultiLinkMicSeatDataWidget$initLinkUserDataMergeCenter$pair$1.INSTANCE);
        LinkUserDataMergeContext r23 = (LinkUserDataMergeContext) r22.getFirst();
        r23.getDataMergeCenter().d(this.d);
        r23.getDynamicHandler().d(r19);
        r23.getLinkRoomFightDataMergeCenter().d(this.e);
        r23.share(((Widget) this).dataCenter);
        this.b.add((Disposable) r22.getSecond());
        ((Widget) this).dataCenter.put("data_multi_link_data_merge_center_init", Boolean.TRUE);
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        this.l.removeRoomLinkMicSyncDataBizListener("inner_feed", getMRoom().getId(), this.m);
        int r0 = e.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        r1.put("data_mic_seat_data_service", null);
        y r2 = this.g;
        if (r2 == null) goto L5;
        r2.l();
    L5:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r3 = this.d;
        if (r3 == null) goto L8;
        r3.detach();
    L8:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r4 = this.e;
        if (r4 == null) goto L11;
        r4.detach();
    L11:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r5 = this.f;
        if (r5 == null) goto L14;
        r5.detach();
    L14:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r6 = this.h;
        if (r6 == null) goto L17;
        r6.d();
    L17:
        this.b.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.a N7() {
        return this.h;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final eh0.b Y3() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final BehaviorSubject<List<tf0.e>> el() {
        return this.j;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final y getLinkUserCenter() {
        return this.g;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d md() {
        return this.d;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final eh0.b p5() {
        return this.e;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final void N1(hg6.g r7) {
        this.l.removeRoomLinkMicSyncDataBizListener("inner_feed", getMRoom().getId(), this.m);
        wq();
        if (g.a(0) == false) goto L26;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r0 = this.d;
        if (r0 == null) goto L7;
        r0.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.f());
    L7:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r1 = this.d;
        if (r1 == null) goto L10;
        r1.g1(new h0(isAnchor(), ((Widget) this).dataCenter));
    L10:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r2 = this.d;
        if (r2 == null) goto L13;
        r2.g1(new n());
    L13:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r3 = this.d;
        if (r3 == null) goto L16;
        r3.M0(new fh0.b(((Widget) this).dataCenter));
    L16:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r4 = this.d;
        if (r4 == null) goto L19;
        y r5 = this.g;
        Intrinsics.checkNotNull(r5);
        r4.M0(new fh0.a(r5, ((Widget) this).dataCenter));
    L19:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r6 = this.d;
        if (r6 == null) goto L22;
        y r8 = this.g;
        Intrinsics.checkNotNull(r8);
        r6.M0(new PaidLinkMicPlayModeHandler(this, r8, ((Widget) this).dataCenter));
    L22:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r9 = this.d;
        if (r9 == null) goto L90;
        r9.M0(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.l(xq(), isAnchor()));
    L90:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r10 = this.d;
        if (r10 == null) goto L93;
        r10.N1(r7);
    L93:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r11 = this.e;
        if (r11 == null) goto L96;
        r11.N1(r7);
    L96:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r12 = this.f;
        if (r12 == null) goto L100;
        r12.N1(r7);
        return;
    L100:
        return;
    L26:
        if (getMRoom().isLiveTypeAudio() == false) goto L28;
        int r13 = 8;
    L29:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r14 = this.d;
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r15 = null;
        if ((r14 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L32;
        r14 = null;
    L32:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r16 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r14;
        if (r16 == null) goto L35;
        r16.g1(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.f());
    L35:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r17 = this.d;
        if ((r17 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L38;
        r17 = null;
    L38:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r18 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r17;
        if (r18 == null) goto L41;
        r18.g1(new h0(isAnchor(), ((Widget) this).dataCenter));
    L41:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r19 = this.d;
        if ((r19 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L44;
        r19 = null;
    L44:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r20 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r19;
        if (r20 == null) goto L47;
        r20.g1(new fh0.e(((Widget) this).dataCenter, r13));
    L47:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r21 = this.d;
        if ((r21 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L50;
        r21 = null;
    L50:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r22 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r21;
        if (r22 == null) goto L53;
        r22.g1(new n());
    L53:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r23 = this.d;
        if ((r23 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L56;
        r23 = null;
    L56:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r24 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r23;
        if (r24 == null) goto L59;
        r24.M0(new fh0.b(((Widget) this).dataCenter));
    L59:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r25 = this.d;
        if ((r25 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L62;
        r25 = null;
    L62:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r26 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r25;
        if (r26 == null) goto L65;
        y r27 = this.g;
        Intrinsics.checkNotNull(r27);
        r26.M0(new fh0.a(r27, ((Widget) this).dataCenter));
    L65:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r28 = this.d;
        if ((r28 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L68;
        r28 = null;
    L68:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r29 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r28;
        if (r29 == null) goto L71;
        r29.M0(new fh0.f(((Widget) this).dataCenter));
    L71:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r30 = this.d;
        if ((r30 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L74;
        r30 = null;
    L74:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r31 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r30;
        if (r31 == null) goto L77;
        r31.M0(new fh0.d(((Widget) this).dataCenter));
    L77:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r32 = this.d;
        if ((r32 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == true) goto L80;
        r32 = null;
    L80:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r33 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r32;
        if (r33 == null) goto L83;
        y r34 = this.g;
        Intrinsics.checkNotNull(r34);
        r33.M0(new PaidLinkMicPlayModeHandler(this, r34, ((Widget) this).dataCenter));
    L83:
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r35 = this.d;
        if ((r35 instanceof com.bytedance.android.live.liveinteract.plantform.datamerge.j) == false) goto L87;
        r15 = r35;
    L87:
        com.bytedance.android.live.liveinteract.plantform.datamerge.j r36 = (com.bytedance.android.live.liveinteract.plantform.datamerge.j) r15;
        if (r36 == null) goto L90;
        r36.M0(new com.bytedance.android.live.liveinteract.plantform.datamerge.handler.l(xq(), isAnchor()));
        goto L90
    L28:
        r13 = 16;
        goto L29
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final void onSeiUpdate(String r2) {
        this.k.d(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.multiroom.a
    public final void qd(m r7) {
        if (r7 == null) goto L50;
        String r0 = this.a;
        int r1 = hashCode();
        StringBuilder r2 = new StringBuilder("realUpdateLayoutConfig source=updateLayoutConfig, windowListHelper=");
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r3 = this.h;
        if (r3 == null) goto L6;
        Integer r4 = Integer.valueOf(r3.hashCode());
    L7:
        r2.append(r4);
        r2.append(", oldLayoutConfig=");
        r2.append(this.i);
        r2.append(" newLayoutConfig=");
        r2.append(r7);
        zq(r0, r1, r2.toString());
        if (this.h == null) goto L44;
        m r5 = this.i;
        int r6 = 0;
        if (r5 == null) goto L34;
        Intrinsics.checkNotNull(r5);
        zq(this.a, hashCode(), "needUpdateWindowListHelper oldUiLayout=" + r5.getUiLayout() + ", newUiLayout=" + r7.getUiLayout());
        if (r5.getUiLayout() == 15) goto L17;
        if (r7.getUiLayout() != 15) goto L17;
    L30:
        boolean r8 = true;
    L32:
        if (r8 == false) goto L34;
    L17:
        if (r5.getUiLayout() != 15) goto L22;
        if (r7.getUiLayout() != 15) goto L30;
    L22:
        if (aj0.b.c(r5.getUiLayout()) == true) goto L27;
        if (aj0.b.c(r7.getUiLayout()) == true) goto L30;
    L27:
        if (aj0.b.c(r5.getUiLayout()) == true) goto L29;
    L31:
        r8 = false;
        goto L32
    L29:
        if (aj0.b.c(r7.getUiLayout()) == true) goto L31;
    L34:
        List<m.d> r9 = r7.h();
        if (r9 == null) goto L37;
        int r10 = r9.size();
    L38:
        List<m.e> r11 = r7.k();
        if (r11 == null) goto L41;
        r6 = r11.size();
    L41:
        k r12 = new k(r10 + r6);
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r13 = this.h;
        if (r13 == null) goto L48;
        r13.w(r12, r7);
    L48:
        this.i = r7;
        return;
    L37:
        r10 = 0;
    L44:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r14 = this.h;
        if (r14 == null) goto L47;
        r14.d();
    L47:
        yq(r7, "updateLayoutConfig");
        goto L48
    L6:
        r4 = null;
        goto L7
    }

    public final void yq(m r12, String r13) {
        Integer r0 = null;
        if (r12 != null) goto L8;
        int r14 = e.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.l r15 = e.d(((Widget) this).dataCenter);
        if (r15 == null) goto L7;
        r12 = r15.getCurrentLayoutConfig();
        goto L8
    L7:
        m r5 = null;
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        int r16 = 0;
        if (g.a(0) == false) goto L28;
        List<m.d> r1 = r5.h();
        if (r1 == null) goto L16;
        int r2 = r1.size();
    L17:
        List<m.e> r3 = r5.k();
        if (r3 == null) goto L20;
        int r4 = r3.size();
    L21:
        k r6 = new k(r2 + r4);
        if (r5.getUiLayout() != 15) goto L25;
        IRoom r7 = getMRoom();
        DataCenter r8 = ((Widget) this).dataCenter;
        boolean r9 = isAnchor();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r10 = this.d;
        Intrinsics.checkNotNull(r10);
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r11 = this.f;
        Intrinsics.checkNotNull(r11);
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r17 = new LinkMicGameWindowHelperV2(r7, r8, r9, r5, r6, r10, r11, 0);
    L43:
        this.h = r17;
        BehaviorSubject<List<tf0.e>> r18 = r17.b;
        if (r18 == null) goto L48;
        Disposable r19 = r18.subscribe(new a(this));
        if (r19 == null) goto L48;
        RxUtilKt.c(r19, this.b);
    L48:
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r20 = this.h;
        if (r20 == null) goto L51;
        r20.b();
    L51:
        String r21 = this.a;
        int r22 = hashCode();
        StringBuilder r23 = new StringBuilder("initWindowListHelper from=");
        r23.append(r13);
        r23.append(", windowListHelper=");
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r110 = this.h;
        if (r110 == null) goto L54;
        r16 = r110.hashCode();
    L54:
        r23.append(r16);
        r23.append(", windowListObservable=");
        com.bytedance.android.live.liveinteract.plantform.datamerge.a r111 = this.h;
        if (r111 == null) goto L59;
        BehaviorSubject<List<tf0.e>> r112 = r111.b;
        if (r112 == null) goto L59;
        r0 = Integer.valueOf(r112.hashCode());
    L59:
        r23.append(r0);
        zq(r21, r22, r23.toString());
        return;
    L25:
        if (aj0.b.c(r5.getUiLayout()) == false) goto L27;
        IRoom r24 = getMRoom();
        DataCenter r25 = ((Widget) this).dataCenter;
        boolean r26 = isAnchor();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r27 = this.d;
        Intrinsics.checkNotNull(r27);
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r28 = this.e;
        Intrinsics.checkNotNull(r28);
        r17 = new LinkRoomFightWindowListHelperV2(r24, r25, r26, r5, r6, r27, r28, 0);
        goto L43
    L27:
        IRoom r29 = getMRoom();
        DataCenter r30 = ((Widget) this).dataCenter;
        boolean r31 = isAnchor();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r32 = this.d;
        Intrinsics.checkNotNull(r32);
        r17 = new WindowListHelperV2(r29, r30, r31, r5, r6, r32, 0);
        goto L43
    L20:
        r4 = 0;
        goto L21
    L16:
        r2 = 0;
        goto L17
    L28:
        List<m.d> r33 = r5.h();
        if (r33 == null) goto L31;
        int r34 = r33.size();
    L32:
        List<m.e> r35 = r5.k();
        if (r35 == null) goto L35;
        int r36 = r35.size();
    L36:
        k r37 = new k(r34 + r36);
        if (r5.getUiLayout() != 15) goto L40;
        IRoom r38 = getMRoom();
        DataCenter r39 = ((Widget) this).dataCenter;
        boolean r40 = isAnchor();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r41 = this.d;
        Intrinsics.checkNotNull(r41);
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r42 = this.f;
        Intrinsics.checkNotNull(r42);
        r17 = new LinkMicGameWindowHelper(r38, r39, r40, r5, r37, r41, r42);
        goto L43
    L40:
        if (aj0.b.c(r5.getUiLayout()) == false) goto L42;
        IRoom r43 = getMRoom();
        DataCenter r44 = ((Widget) this).dataCenter;
        boolean r45 = isAnchor();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r46 = this.d;
        Intrinsics.checkNotNull(r46);
        com.bytedance.android.live.liveinteract.plantform.datamergev2.a r47 = this.e;
        Intrinsics.checkNotNull(r47);
        r17 = new i(r43, r44, r45, r5, r37, r46, r47);
        goto L43
    L42:
        IRoom r48 = getMRoom();
        DataCenter r49 = ((Widget) this).dataCenter;
        boolean r50 = isAnchor();
        com.bytedance.android.live.liveinteract.plantform.datamergev2.b r51 = this.d;
        Intrinsics.checkNotNull(r51);
        r17 = new com.bytedance.android.live.liveinteract.plantform.datamerge.l(r48, r49, r50, r5, r37, r51);
        goto L43
    L35:
        r36 = 0;
        goto L36
    L31:
        r34 = 0;
    L8:
        r5 = r12;
        goto L9
    }

    public final void zq(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "subTag");
        Intrinsics.checkNotNullParameter(r5, "content");
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(((Widget) this).dataCenter, r3 + '#' + r4, r5);
    }
}
