package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.t5;
import com.bytedance.android.livesdk.link.model.u6;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;
import y31.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/PKRivalsPanelListWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lx31/g;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsPanelListWidget extends LiveRecyclableWidget implements x31.g {
    public static final /* synthetic */ int h = 0;
    public PkItemExposeRecyclerView a;
    public com.bytedance.android.live.revlink.impl.pk.utils.m b;
    public MultiTypeAdapter c;
    public LinkedList<Object> d;
    public final com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j e;
    public final String f;
    public final SearchSourceFlag g;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelListWidget a;

        public b(PKRivalsPanelListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            Intrinsics.checkNotNull(r4);
            if (r4.booleanValue() == false) goto L12;
            PKRivalsPanelListWidget.wq(this.a).clear();
            PkItemExposeRecyclerView r5 = this.a.a;
            if (r5 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
        L7:
            r5.scrollToPosition(0);
            PkItemExposeRecyclerView r6 = this.a.a;
            if (r6 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mListView");
        L10:
            r6.r();
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelListWidget a;

        public c(PKRivalsPanelListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            u6 r14 = (u6) r13;
            PKRivalsPanelListWidget r0 = this.a;
            if (r14 == null) goto L46;
            MultiTypeAdapter r1 = r0.c;
            if (r1 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L7:
            y31.p.a r3 = new y31.p.a();
            List r4 = r14.getAnchorInfo();
            if (r4 == null) goto L30;
            Iterator<T> r5 = r4.iterator();
            int r7 = 0;
        L11:
            if (r5.hasNext() == false) goto L30;
            T r8 = r5.next();
            int r9 = r7 + 1;
            if (r7 >= 0) goto L15;
            CollectionsKt.throwIndexOverflow();
        L15:
            x8 r10 = (x8) r8;
            SearchSourceFlag r12 = r0.g;
            if (r12 != SearchSourceFlag.INVITE_LINKING) goto L18;
        L24:
            q21.j.a r15 = new q21.j.a();
            r15.a = r10;
            r15.b = r7;
            LinkedList<Object> r16 = r0.d;
            if (r16 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("list");
        L27:
            r16.add(r15);
        L28:
            r7 = r9;
            goto L11
        L18:
            if (r12 == SearchSourceFlag.MAIN_LINK) goto L24;
            q.a r17 = new q.a();
            r17.a = r10;
            String r18 = r0.f;
            Intrinsics.checkNotNullParameter(r18, "<set-?>");
            r17.b = r18;
            r17.c = r14.getActivityPKConfig();
            LinkedList<Object> r19 = r0.d;
            if (r19 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("list");
        L23:
            r19.add(r17);
        L30:
            if (r14.getHasMore() == true) goto L35;
            r3.a = 1;
            LinkedList<Object> r110 = r0.d;
            if (r110 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("list");
        L34:
            r110.add(r3);
        L39:
            LinkedList<Object> r111 = r0.d;
            if (r111 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("list");
        L42:
            r1.a = r111;
            MultiTypeAdapter r112 = r0.c;
            if (r112 != null) goto L45;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L45:
            r112.notifyDataSetChanged();
            return;
        L35:
            r3.a = 0;
            LinkedList<Object> r113 = r0.d;
            if (r113 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("list");
        L38:
            r113.add(r3);
            goto L39
        L46:
            int r114 = PKRivalsPanelListWidget.h;
            r0.getClass();
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelListWidget a;

        public d(PKRivalsPanelListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            Intrinsics.checkNotNull(r3);
            if (r3.booleanValue() == true) goto L5;
            return;
        L5:
            if (PKRivalsPanelListWidget.wq(this.a).isEmpty() == false) goto L7;
            return;
        L7:
            if ((ListProtector.get(PKRivalsPanelListWidget.wq(this.a), PKRivalsPanelListWidget.wq(this.a).size() - 1) instanceof y31.p.a) == false) goto L15;
            PKRivalsPanelListWidget.wq(this.a).removeLast();
            MultiTypeAdapter r4 = this.a.c;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L11:
            r4.notifyItemRemoved(PKRivalsPanelListWidget.wq(this.a).size() - 1);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelListWidget a;

        public e(PKRivalsPanelListWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L9;
            MultiTypeAdapter r3 = this.a.c;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L7:
            r3.notifyDataSetChanged();
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566744;
    }

    public final void onUnload() {
        this.e.i(this);
    }

    public static final /* synthetic */ LinkedList wq(PKRivalsPanelListWidget r1) {
        LinkedList<Object> r2 = r1.d;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("list");
    L5:
        return r2;
    }

    public final void onInit(Object[] r7) {
        this.a = (PkItemExposeRecyclerView) findViewById(2131378057);
        this.b = new com.bytedance.android.live.revlink.impl.pk.utils.m();
        this.c = new MultiTypeAdapter();
        this.d = new LinkedList();
        MultiTypeAdapter r8 = this.c;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L5:
        com.bytedance.android.live.revlink.impl.pk.utils.m r3 = this.b;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L8:
        r8.z2(q.a.class, new q(r3, this, ((Widget) this).dataCenter));
        MultiTypeAdapter r9 = this.c;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L11:
        com.bytedance.android.live.revlink.impl.pk.utils.m r4 = this.b;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L14:
        r9.z2(q21.j.a.class, new q21.j(r4, this, ((Widget) this).dataCenter, this.g));
        MultiTypeAdapter r10 = this.c;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L17:
        r10.z2(y31.p.a.class, new y31.p());
        PkItemExposeRecyclerView r12 = this.a;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L20:
        r12.setInviteIconPanelType("search");
        PkItemExposeRecyclerView r13 = this.a;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L23:
        MultiTypeAdapter r2 = this.c;
        if (r2 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L26:
        r13.setAdapter(r2);
        PkItemExposeRecyclerView r14 = this.a;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L29:
        r14.setLayoutManager(new SSLinearLayoutManager(((Widget) this).context, 1));
        PkItemExposeRecyclerView r15 = this.a;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L32:
        r15.setItemViewCacheSize(8);
        PkItemExposeRecyclerView r16 = this.a;
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L35:
        r16.setItemAnimator(null);
        PkItemExposeRecyclerView r17 = this.a;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L38:
        r17.addOnScrollListener(new AnonymousClass1(this));
    }

    public final void onLoad(Object[] r2) {
        this.e.p.observe(this, new b(this));
        this.e.f.observe(this, new c(this));
        this.e.q.observe(this, new d(this));
        this.e.h.observe(this, new e(this));
    }

    @Override // x31.g
    public final void Ko(int r44, x8 r45) {
        Intrinsics.checkNotNullParameter(r45, "searchAnchorInfo");
        yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 == null) goto L116;
        IRoom r3 = r2.getRoom();
        if (r3 == null) goto L126;
        com.bytedance.android.live.revlink.impl.pk.utils.j r4 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r4 == null) goto L117;
        boolean r5 = false;
        boolean r6 = true;
        if (r4.c(r44, iz.a.a(r3.getOwner()), 0) != true) goto L127;
        com.bytedance.android.live.revlink.impl.pk.utils.j r7 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r7 != null) goto L15;
        return;
    L15:
        if (r7.a(iz.a.a(r3.getOwner()), r44) != true) goto L128;
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r8 = this.e;
        long r9 = r3.getId();
        String r15 = this.f;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r15, "activityName");
        if (r8.y == true) goto L129;
        r8.y = true;
        if (r45 == null) goto L23;
        IRivalExtraInfo r10 = r45.getRivalExtraInfo();
    L24:
        if (r10 == null) goto L26;
        r8.l = r45.getRivalExtraInfo();
    L26:
        int r12 = r8.g();
        if (r45 == null) goto L37;
        IRoom r13 = r45.getRoom();
        if (r13 == null) goto L37;
        Map r14 = r13.getLinkMap();
        if (r14 == null) goto L37;
        if (r14.containsKey(String.valueOf(7)) != true) goto L37;
        if (r8.v != SearchSourceFlag.INVITE_LINKING) goto L37;
        int r18 = 2;
    L38:
        if (r45 == null) goto L52;
        IRivalExtraInfo r16 = r45.getRivalExtraInfo();
        if (r16 == null) goto L52;
        d6 r17 = r16.getLinkerInfo();
        if (r17 == null) goto L52;
        List r19 = r17.getLinkedUserInfos();
        if (r19 == null) goto L52;
        ArrayList r20 = new ArrayList();
        Iterator r22 = r19.iterator();
    L47:
        if (r22.hasNext() == false) goto L51;
        String r110 = ((t5) r22.next()).getUserId();
        if (r110 == null) goto L47;
        r20.add(r110);
        goto L47
    L51:
        ArrayList r23 = r20;
    L53:
        com.bytedance.android.live.revlink.impl.service.internal.a r24 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r24 == null) goto L56;
        int r25 = r24.getCurrentMode();
    L58:
        if (v.a(r25, 64) == true) goto L82;
        if (r8.v != SearchSourceFlag.MAIN_LINK) goto L62;
        boolean r26 = true;
    L63:
        if (r26 == true) goto L82;
        if (com.bytedance.android.live.revlink.impl.global.b.P() == null) goto L119;
        if (r45 == null) goto L69;
        IRoom r27 = r45.getRoom();
    L70:
        if (r27 == null) goto L120;
        int r28 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        com.bytedance.android.live.revlink.impl.pk.utils.l r29 = com.bytedance.android.live.revlink.impl.pk.utils.l.h.c;
        if (r8.v != SearchSourceFlag.INVITE_LINKING) goto L74;
        r5 = true;
    L74:
        if (r5 == false) goto L76;
        r29 = com.bytedance.android.live.revlink.impl.pk.utils.l.f.c;
    L76:
        com.bytedance.android.live.revlink.impl.pk.utils.l r111 = r29;
        IPKLinkBizDataService r30 = com.bytedance.android.live.revlink.impl.global.b.P();
        Intrinsics.checkNotNull(r30);
        IRoom r32 = r45.getRoom();
        long r33 = r45.getRoomId();
        String r34 = r45.getUserId();
        String r210 = r45.getSecUid();
        String r112 = l51.a.m();
        int r113 = l51.a.j();
        int r35 = r8.g();
        String r1 = r45.getBattleAttachedInfo();
        e21.b r114 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r114 == null) goto L79;
        v3 r211 = e21.b.b(r114, r111, null, null, null, null, null, 120);
    L80:
        IPKLinkBizDataService.b.b(r30, r32, r33, r34, r210, 0, r44, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, r112, r113, r15, r35, null, r1, 0, 0, r211, null, null, 6144));
        return;
    L79:
        r211 = null;
        goto L80
    L120:
        return;
    L69:
        r27 = null;
        goto L70
    L119:
        return;
    L62:
        r26 = false;
    L82:
        if (com.bytedance.android.live.revlink.impl.global.b.t() == null) goto L122;
        if (r45 == null) goto L85;
        IRoom r36 = r45.getRoom();
    L86:
        if (r36 == null) goto L123;
        int r37 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        com.bytedance.android.live.revlink.impl.pk.utils.l r38 = com.bytedance.android.live.revlink.impl.pk.utils.l.e.c;
        if (r8.v == SearchSourceFlag.INVITE_LINKING) goto L91;
        r6 = false;
    L91:
        if (r6 == false) goto L93;
        r38 = com.bytedance.android.live.revlink.impl.pk.utils.l.c.c;
    L93:
        com.bytedance.android.live.revlink.impl.pk.utils.l r212 = r38;
        e21.b r213 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r213 == null) goto L96;
        v3 r39 = e21.b.b(r213, r212, null, null, null, null, null, 124);
    L97:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r40 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r40 == null) goto L124;
        com.bytedance.android.live.revenuelink.connect.n r115 = r40.getLinkOutManagerFn();
        if (r115 == null) goto L125;
        long r42 = r45.getRoomId();
        String r116 = r45.getUserId();
        String r117 = r45.getSecUid();
        IRoom r118 = r45.getRoom();
        int r214 = BizType.AnchorLink.ordinal();
        w31.c r43 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r43 == null) goto L104;
        int r310 = r43.d();
    L106:
        if (r39 == null) goto L108;
        String r46 = w3.a(r39);
    L109:
        r115.d(new d11.d(7, r9, r42, r44, 0, r116, r117, r118, r214, "", 0, r15, 0, r18, null, 0, r23, "", "", "", r310, 0, 0, r46, "", null, null, null, 503316480), null);
        return;
    L108:
        r46 = "";
        goto L109
    L104:
        r310 = 0;
        goto L106
    L125:
        return;
    L124:
        return;
    L96:
        r39 = null;
        goto L97
    L123:
        return;
    L85:
        r36 = null;
        goto L86
    L122:
        return;
    L56:
        r25 = 0;
    L52:
        r23 = null;
    L37:
        r18 = r12;
        goto L38
    L23:
        r10 = null;
        goto L24
    L129:
        return;
    L128:
        return;
    L127:
        return;
    L117:
        return;
    L126:
        return;
    }

    @Override // x31.g
    public final void jm(x8 r20, int r22) {
        Intrinsics.checkNotNullParameter(r20, "searchAnchorInfo");
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r3 = this.e;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r20, "searchAnchorInfo");
        LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r2 == null) goto L5;
        long r4 = r2.c();
    L6:
        long r8 = r4;
        com.bytedance.android.live.revlink.impl.service.internal.a r5 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r5 == null) goto L9;
        int r6 = r5.getCurrentMode();
    L11:
        if (v.a(r6, 64) == true) goto L26;
        if (r3.v != SearchSourceFlag.MAIN_LINK) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == true) goto L26;
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L37;
        com.bytedance.android.live.revlink.impl.pk.service.b r9 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r9);
        if (r9.getLinkOutManagerFn() == null) goto L37;
        com.bytedance.android.live.revlink.impl.pk.service.b r10 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r10);
        com.bytedance.android.live.revenuelink.connect.n r12 = r10.getLinkOutManagerFn();
        if (r12 == null) goto L37;
        r12.e(new d11.c(1, r8, r20.getRoomId(), r20.getUserId(), r20.getSecUid(), 0, "click_item_cancel", ""), null);
    L37:
        com.bytedance.android.live.revlink.impl.service.internal.a r13 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r13 == null) goto L40;
        int r14 = r13.getCurrentMode();
    L42:
        if (v.a(r14, 64) == true) goto L49;
        ld.a r15 = ld.d.a();
        if (r15 == null) goto L49;
        NextLiveData r16 = r15.ke();
        if (r16 == null) goto L49;
        r16.setValue(0);
    L49:
        HashMap r17 = new HashMap();
        r17.put("is_oncemore", DataType.FALSE);
        r17.put("invitee_list", "search");
        r17.put("is_recommend_list", DataType.FALSE);
        if (this.f.length() <= 0) goto L52;
        boolean r18 = true;
    L53:
        if (r18 == false) goto L55;
        String r19 = "activity";
    L56:
        r17.put("pk_description", r19);
        r17.put("pk_activity_type", this.f);
        SearchSourceFlag r23 = this.g;
        if (r23 != SearchSourceFlag.INVITE_LINKING) goto L65;
        r17.put("anchor_connection_type", "invite");
        r17.put("connection_type", "manual_link");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r24 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r24 == null) goto L62;
        String r25 = r24.a;
        if (r25 == null) goto L62;
    L63:
        r17.put("source", r25);
    L68:
        r17.put("invitee_id", r20.getUserId().toString());
        mz0.n r1 = new mz0.n();
        Map<String, String> r26 = r1.a;
        Intrinsics.checkNotNullParameter(r26, "map");
        Intrinsics.checkNotNullParameter(r17, "map");
        r26.putAll(r17);
        mz0.m r27 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r28 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r28, "linkInfoLog");
        am2.m r29 = r28.a;
        r29.i = 300;
        ((ArrayList) r27.a).add(r29);
        LinkCrossRoomDataHolder.a r30 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r27);
        r27.b(LogCommon.ROOM);
        ((ArrayList) r1.b).addAll(r27.a);
        cy0.e.a.getClass();
        cy0.j r32 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r33 = com.bytedance.android.scope.m.b(r32).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r33);
        ((mz0.i) ((f80.a) r33)).w3("livesdk_connection_invite_cancel", r1.a, r1.b);
        return;
    L62:
        r25 = "";
        goto L63
    L65:
        if (r23 != SearchSourceFlag.MAIN_LINK) goto L67;
        r17.put("anchor_connection_type", "invite");
        r17.put("connection_type", "manual_link");
        r17.put("source", "link_banner");
        goto L68
    L67:
        r17.put("source", "pk_banner");
        goto L68
    L55:
        r19 = "routine";
        goto L56
    L52:
        r18 = false;
        goto L53
    L40:
        r14 = 0;
        goto L42
    L15:
        r7 = false;
    L26:
        if (com.bytedance.android.live.revlink.impl.global.b.t() == null) goto L37;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r34 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r34 == null) goto L30;
        com.bytedance.android.live.revenuelink.connect.n r110 = r34.getLinkOutManagerFn();
    L31:
        if (r110 == null) goto L37;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r35 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r35 == null) goto L37;
        com.bytedance.android.live.revenuelink.connect.n r36 = r35.getLinkOutManagerFn();
        if (r36 == null) goto L37;
        r36.e(new d11.c(7, r8, r20.getRoomId(), r20.getUserId(), r20.getSecUid(), r22, "click_item_cancel", ""), null);
        goto L37
    L30:
        r110 = null;
        goto L31
    L9:
        r6 = 0;
        goto L11
    L5:
        r4 = 0;
        goto L6
    }

    public PKRivalsPanelListWidget(com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r2, String r3, SearchSourceFlag r4) {
        Intrinsics.checkNotNullParameter(r2, "mPresenter");
        Intrinsics.checkNotNullParameter(r3, "mActivityName");
        Intrinsics.checkNotNullParameter(r4, "searchSourceFlag");
        this.e = r2;
        this.f = r3;
        this.g = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x31.g
    public final void v6(int r22, x8 r23, int r24) {
        if (r23 != null) goto L5;
        return;
    L5:
        if (r23.getRoom() != null) goto L7;
        return;
    L7:
        if (r23.getRoom().getLinkMap() == null) goto L103;
        Long r2 = (Long) r23.getRoom().getLinkMap().get(String.valueOf(7));
        if (r2 == null) goto L11;
        long r3 = r2.longValue();
    L12:
        long r13 = r3;
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r4 = this.e;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r23, "searchAnchorInfo");
        yz0.k r5 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r5 == null) goto L15;
        IRoom r6 = r5.getRoom();
    L17:
        if (r23.getRivalExtraInfo() == null) goto L20;
        r4.l = r23.getRivalExtraInfo();
    L20:
        if (r4.u == true) goto L22;
    L39:
        Integer r7 = null;
    L40:
        HashMap r8 = new HashMap();
        String r9 = DataType.FALSE;
        r8.put("is_oncemore", DataType.FALSE);
        r8.put("invitee_list", "search");
        r8.put("is_recommend_list", DataType.FALSE);
        r8.put("anchor_connection_type", "apply");
        r8.put("connection_type", "manual_link");
        r8.put("source", "link_banner");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r10 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r10 == null) goto L43;
        String r12 = r10.a();
    L44:
        r8.put("from_room_status", r12);
        SearchSourceFlag r14 = this.g;
        if (r14 != SearchSourceFlag.INVITE_LINKING) goto L53;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r15 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r15 == null) goto L50;
        String r16 = r15.a;
        if (r16 == null) goto L50;
    L51:
        r8.put("source", r16);
        r8.put("invite_mode", "connection");
    L56:
        r8.put("invite_type", "anchor");
        i11.b r17 = y.a();
        if (r17 == null) goto L59;
        Integer r18 = Integer.valueOf(r17.c());
    L60:
        int r19 = 0;
        if (r18 == null) goto L63;
        int r20 = r18.intValue();
    L65:
        if (r20 <= 1) goto L67;
        String r25 = String.valueOf(r18);
    L68:
        r8.put("anchor_connect_status", r25);
        IRoom r26 = r23.getRoom();
        if (r26 == null) goto L71;
        Long r110 = Long.valueOf(r26.getRoomId());
    L72:
        r8.put("invitee_room_id", String.valueOf(r110.longValue()));
        d31.d r27 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r27 == null) goto L75;
        String r111 = r27.s();
    L76:
        r8.put("room_status", r111);
        if (com.bytedance.android.live.revlink.impl.global.b.c0() == null) goto L79;
        Integer r112 = Integer.valueOf(n41.a.b());
    L80:
        r8.put("audience_connect_cnt", String.valueOf(r112));
        r8.put("invitee_id", r23.getUserId().toString());
        r8.put("invitee_room_status", "live");
        r8.put("invitee_connect_cnt", DataType.FALSE);
        r8.put("connection_sub_type", r12);
        r8.put("list_num", String.valueOf(r24 + 1));
        IRivalExtraInfo r28 = r23.getRivalExtraInfo();
        if (r28 == null) goto L87;
        d6 r29 = r28.getLinkerInfo();
        if (r29 == null) goto L87;
        List r30 = r29.getLinkedUserInfos();
        if (r30 == null) goto L87;
        r19 = r30.size();
    L87:
        if (r19 <= 0) goto L99;
        r8.put("connection_sub_type", "manual_nlink");
        r8.put("invitee_room_status", "connection");
        IRivalExtraInfo r1 = r23.getRivalExtraInfo();
        if (r1 == null) goto L98;
        d6 r32 = r1.getLinkerInfo();
        if (r32 == null) goto L98;
        List r33 = r32.getLinkedUserInfos();
        if (r33 == null) goto L98;
        String r34 = String.valueOf(r33.size());
        if (r34 == null) goto L98;
        r9 = r34;
    L98:
        r8.put("invitee_connect_cnt", r9);
    L99:
        mz0.n r35 = new mz0.n();
        Map<String, String> r36 = r35.a;
        Intrinsics.checkNotNullParameter(r36, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r36.putAll(r8);
        mz0.m r37 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r38 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r38, "linkInfoLog");
        am2.m r39 = r38.a;
        r39.i = 300;
        ((ArrayList) r37.a).add(r39);
        LinkCrossRoomDataHolder.a r40 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r37);
        r37.b(LogCommon.ROOM);
        ((ArrayList) r35.b).addAll(r37.a);
        cy0.e.a.getClass();
        cy0.j r42 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r43 = com.bytedance.android.scope.m.b(r42).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r43);
        ((mz0.i) ((f80.a) r43)).w3("connection_invite", r35.a, r35.b);
        return;
    L79:
        r112 = r7;
        goto L80
    L75:
        r111 = r12;
        goto L76
    L71:
        r110 = r7;
        goto L72
    L67:
        r25 = DataType.FALSE;
        goto L68
    L63:
        r20 = 0;
        goto L65
    L59:
        r18 = r7;
    L50:
        r16 = "";
        goto L51
    L53:
        if (r14 != SearchSourceFlag.MAIN_LINK) goto L55;
        r8.put("source", "link_banner");
        r8.put("invite_mode", "connection");
        goto L56
    L55:
        r8.put("source", "pk_banner");
        r8.put("invite_mode", "routine_pk");
        goto L56
    L43:
        r12 = r12;
        goto L44
    L22:
        if (com.bytedance.android.live.revlink.impl.global.b.t() == null) goto L39;
        if (r6 == null) goto L39;
        if (r23.getRoom() == null) goto L39;
        e21.b r44 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r44 == null) goto L29;
        int r45 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        v3 r46 = e21.b.b(r44, com.bytedance.android.live.revlink.impl.pk.utils.l.d.c, null, null, null, null, null, 124);
    L30:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r47 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r47 == null) goto L39;
        com.bytedance.android.live.revenuelink.connect.n r113 = r47.getLinkOutManagerFn();
        if (r113 == null) goto L39;
        long r48 = r6.getId();
        long r49 = r23.getRoomId();
        String r50 = r23.getSecUid();
        Intrinsics.checkNotNull(r50);
        String r114 = r23.getUserId();
        IRoom r115 = r23.getRoom();
        if (r46 == null) goto L37;
        String r52 = w3.a(r46);
    L38:
        r7 = null;
        r113.g(new d11.b(7, r48, r49, r22, r50, r114, r13, r115, 0, r52), null);
        goto L40
    L37:
        r52 = "";
        goto L38
    L29:
        r46 = null;
        goto L30
    L15:
        r6 = null;
        goto L17
    L11:
        r3 = 0;
        goto L12
    }
}
