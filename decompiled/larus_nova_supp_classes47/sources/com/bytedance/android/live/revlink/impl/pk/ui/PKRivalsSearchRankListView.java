package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000b\u0010\u000fB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchRankListView;", "Landroid/widget/FrameLayout;", "Lx31/h;", "", "getLogSource", "Lcom/bytedance/android/livesdk/link/model/IGroupRivals;", "groupRivals", "", "update", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsSearchRankListView extends FrameLayout implements x31.h {
    public Map<Integer, View> a;
    public View b;
    public PkItemExposeRecyclerView c;
    public com.bytedance.android.live.revlink.impl.pk.utils.m d;
    public MultiTypeAdapter e;
    public DataCenter f;
    public com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j g;
    public IGroupRivals.GroupType h;
    public SearchSourceFlag i;
    public boolean j;
    public boolean k;
    public IGroupRivals l;
    public boolean m;
    public boolean n;

    public static final class a {
    }

    static {
    }

    private final String getLogSource() {
        SearchSourceFlag r0 = this.i;
        int r1 = n.d[r0.ordinal()];
        if (r1 != 1) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r2 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r2 == null) goto L12;
        String r3 = r2.a;
        if (r3 == null) goto L12;
        return r3;
    L12:
        return "";
    L5:
        if (r1 == 2) goto L7;
        return "pk_banner";
    L7:
        return "link_banner";
    }

    public final void e() {
        int r0 = getVisibility();
        boolean r1 = this.k;
        IGroupRivals r2 = this.l;
        if (this.m == false) goto L7;
        if (r0 != 0) goto L7;
        if (r1 == false) goto L7;
        boolean r3 = true;
    L9:
        if (r3 == this.j) goto L67;
        this.j = r3;
        if (this.n == true) goto L68;
        if (r3 == false) goto L66;
        HashMap r4 = new HashMap();
        Integer r5 = null;
        if (r2 == null) goto L18;
        String r6 = r2.getDetailType();
    L19:
        String r7 = "hourly_rank";
        if (TextUtils.isEmpty(r6) == false) goto L31;
        IGroupRivals.GroupType r8 = this.h;
        if (r8 == null) goto L28;
        int r9 = n.c[r8.ordinal()];
        if (r9 != 1) goto L27;
        r7 = "fansrank";
    L30:
        r4.put("rectab_name", r7);
    L49:
        if (r2 == null) goto L51;
        List r10 = r2.getRivals();
    L52:
        if (r10 == null) goto L58;
        List r12 = r2.getRivals();
        if (r12 == null) goto L58;
        if ((!r12.isEmpty()) != true) goto L58;
        String r13 = DataType.TRUE;
    L59:
        r4.put("is_anchor_existed", r13);
        if (r2 == null) goto L64;
        List r14 = r2.getRivals();
        if (r14 == null) goto L64;
        r5 = Integer.valueOf(r14.size());
    L64:
        r4.put("rank_anchor_cnt", String.valueOf(r5));
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r16.putAll(r4);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.PAGE_SOURCE_LOG);
        r17.b(LogCommon.ROOM);
        ((ArrayList) r15.b).addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((mz0.i) ((f80.a) r19)).w3("livesdk_pksearch_rectab_show", r15.a, r15.b);
        this.n = true;
        return;
    L58:
        r13 = DataType.FALSE;
        goto L59
    L51:
        r10 = null;
        goto L52
    L27:
        if (r9 == 2) goto L30;
    L28:
        r7 = "";
        goto L30
    L31:
        if (r2 == null) goto L33;
        String r20 = r2.getDetailType();
    L35:
        if (TextUtils.equals(r20, "hourly_rank_global") == false) goto L37;
        r4.put("rectab_name", "hourly_rank");
        goto L49
    L37:
        if (r2 == null) goto L39;
        String r22 = r2.getDetailType();
    L41:
        if (TextUtils.equals(r22, "hourly_rank_region") == false) goto L43;
        r4.put("rectab_name", "regional_rank");
        goto L49
    L43:
        if (r2 == null) goto L45;
        String r23 = r2.getDetailType();
    L47:
        if (TextUtils.equals(r23, "popularity_rank") == false) goto L49;
        r4.put("rectab_name", "popularity_rank");
        goto L49
    L45:
        r23 = null;
        goto L47
    L39:
        r22 = null;
        goto L41
    L33:
        r20 = null;
        goto L35
    L18:
        r6 = null;
        goto L19
    L66:
        return;
    L68:
        return;
    L67:
        return;
    L7:
        r3 = false;
        goto L9
    }

    public final void f() {
        LayoutInflater.from(getContext()).inflate(2131567808, this);
        this.b = findViewById(2131381743);
        PkItemExposeRecyclerView r0 = (PkItemExposeRecyclerView) findViewById(2131383669);
        this.c = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L5:
        r0.setLayoutManager(new SSLinearLayoutManager(getContext(), 1));
        this.e = new MultiTypeAdapter();
    }

    public PKRivalsSearchRankListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        this.i = SearchSourceFlag.UNDEFINE;
        f();
    }

    public final View d(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void update(IGroupRivals r10) {
        this.m = true;
        int r1 = 0;
        this.n = false;
        this.l = r10;
        e();
        if (r10 == null) goto L5;
        List r2 = r10.getRivals();
    L7:
        if (r2 == null) goto L54;
        List r3 = r10.getRivals();
        if (r3 != null) goto L11;
    L13:
        ((LinearLayout) d(2131381743)).setVisibility(8);
        ((PkItemExposeRecyclerView) d(2131383669)).setVisibility(0);
        MultiTypeAdapter r0 = this.e;
        if (r0 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L16:
        int r5 = 6;
        if (r10.getGroupType() != IGroupRivals.GroupType.GroupRivalsSearchPopularityRank.ordinal()) goto L19;
        int r4 = 10;
    L21:
        if (TextUtils.isEmpty(r10.getDetailType()) == true) goto L40;
        String r6 = r10.getDetailType();
        int r7 = r6.hashCode();
        if (r7 == (-351423754)) goto L36;
        if (r7 == 641745480) goto L33;
        if (r7 == 949970329) goto L30;
    L38:
        r5 = r4;
    L39:
        r4 = r5;
        goto L40
    L30:
        if (r6.equals("hourly_rank_region") == false) goto L38;
        r5 = 7;
        goto L39
    L33:
        if (r6.equals("hourly_rank_global") == false) goto L38;
    L36:
        if (r6.equals("popularity_rank") == false) goto L38;
        r5 = 10;
    L40:
        LinkedList r8 = new LinkedList();
        List r12 = r10.getRivals();
        if (r12 == null) goto L49;
        Iterator r13 = r12.iterator();
    L44:
        if (r13.hasNext() == false) goto L49;
        Object r9 = r13.next();
        int r14 = r1 + 1;
        if (r1 >= 0) goto L48;
        CollectionsKt.throwIndexOverflow();
    L48:
        y31.o.a r15 = new y31.o.a();
        r15.a = r4;
        r15.b = (m2) r9;
        SearchSourceFlag r16 = this.i;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.c = r16;
        r15.d = r1;
        r8.add(r15);
        r1 = r14;
    L49:
        r0.a = r8;
        MultiTypeAdapter r17 = this.e;
        if (r17 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L52:
        r17.notifyDataSetChanged();
        return;
    L19:
        IGroupRivals.GroupType.GroupRivalsSearchHourlyRank.ordinal();
        r4 = 6;
        goto L21
    L11:
        if (r3.isEmpty() != true) goto L13;
    L54:
        ((LinearLayout) d(2131381743)).setVisibility(0);
        ((PkItemExposeRecyclerView) d(2131383669)).setVisibility(8);
        return;
    L5:
        r2 = null;
        goto L7
    }

    public PKRivalsSearchRankListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        this.i = SearchSourceFlag.UNDEFINE;
        f();
    }

    @Override // x31.h
    public final void a(m2 r19, int r20) {
        if (r19 == null) goto L61;
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r4 = this.g;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L7:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r19, "battleRival");
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L10;
        long r6 = r5.c();
    L11:
        long r9 = r6;
        if (r19.getRoom() == null) goto L61;
        com.bytedance.android.live.revlink.impl.service.internal.a r7 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r7 == null) goto L17;
        int r8 = r7.getCurrentMode();
    L19:
        if (gd0.v.a(r8, 64) == true) goto L42;
        if (r4.v != SearchSourceFlag.MAIN_LINK) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == true) goto L42;
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L61;
        com.bytedance.android.live.revlink.impl.pk.service.b r12 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r12);
        if (r12.getLinkOutManagerFn() == null) goto L61;
        com.bytedance.android.live.revlink.impl.pk.service.b r13 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r13);
        com.bytedance.android.live.revenuelink.connect.n r14 = r13.getLinkOutManagerFn();
        if (r14 == null) goto L61;
        long r15 = r19.getRoom().getId();
        IBaseUser r16 = r19.getRoom().getOwner();
        if (r16 == null) goto L35;
        String r17 = r16.getIdString();
    L36:
        IBaseUser r0 = r19.getRoom().getOwner();
        if (r0 == null) goto L39;
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        String r18 = r0.getCastSecUid();
    L40:
        r14.e(new d11.c(1, r9, r15, r17, r18, 0, "click_item_cancel", ""), null);
        goto L61
    L39:
        r18 = null;
        goto L40
    L35:
        r17 = null;
        goto L36
    L23:
        r10 = false;
    L42:
        if (com.bytedance.android.live.revlink.impl.global.b.t() == null) goto L61;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r22 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r22 == null) goto L46;
        com.bytedance.android.live.revenuelink.connect.n r23 = r22.getLinkOutManagerFn();
    L47:
        if (r23 == null) goto L61;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r24 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r24 == null) goto L61;
        com.bytedance.android.live.revenuelink.connect.n r25 = r24.getLinkOutManagerFn();
        if (r25 == null) goto L61;
        long r110 = r19.getRoom().getId();
        IBaseUser r111 = r19.getRoom().getOwner();
        if (r111 == null) goto L55;
        String r112 = r111.getIdString();
    L56:
        IBaseUser r1 = r19.getRoom().getOwner();
        if (r1 == null) goto L59;
        Intrinsics.checkNotNullParameter(r1, "$this$secUidExt");
        String r113 = r1.getCastSecUid();
    L60:
        r25.e(new d11.c(7, r9, r110, r112, r113, r20, "click_item_cancel", ""), null);
        goto L61
    L59:
        r113 = null;
        goto L60
    L55:
        r112 = null;
        goto L56
    L46:
        r23 = null;
        goto L47
    L17:
        r8 = 0;
        goto L19
    L10:
        r6 = 0;
    L61:
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r2 == null) goto L64;
        int r3 = r2.getCurrentMode();
    L66:
        if (gd0.v.a(r3, 64) == true) goto L73;
        ld.a r26 = ld.d.a();
        if (r26 == null) goto L74;
        NextLiveData r27 = r26.ke();
        if (r27 == null) goto L75;
        r27.setValue(0);
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L64:
        r3 = 0;
        goto L66
    }

    @Override // x31.h
    public final void b(int r22, m2 r23) {
        String r2 = null;
        if (r23 == null) goto L5;
        IRoom r3 = r23.getRoom();
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r23.getRoom().getLinkMap() == null) goto L87;
        Long r4 = (Long) r23.getRoom().getLinkMap().get(String.valueOf(7));
        if (r4 == null) goto L12;
        long r5 = r4.longValue();
    L13:
        long r14 = r5;
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r6 = this.g;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L16:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r23, "battleRival");
        yz0.k r7 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r7 == null) goto L19;
        IRoom r8 = r7.getRoom();
    L21:
        if (r23.getRivalExtraInfo() == null) goto L24;
        r6.l = r23.getRivalExtraInfo();
    L24:
        if (r6.u == true) goto L26;
    L55:
        HashMap r9 = new HashMap();
        r9.put("is_oncemore", DataType.FALSE);
        r9.put("invitee_list", UserListInviteType.a(r22, null));
        r9.put("is_recommend_list", DataType.FALSE);
        r9.put("anchor_connection_type", "apply");
        r9.put("connection_type", "manual_link");
        r9.put("source", getLogSource());
        IBaseUser r10 = r23.getRoom().getOwner();
        if (r10 == null) goto L58;
        r2 = iz.a.a(r10);
    L58:
        r9.put("invitee_id", String.valueOf(r2));
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r12 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r12 == null) goto L61;
        String r13 = r12.a();
    L62:
        r9.put("from_room_status", r13);
        SearchSourceFlag r15 = this.i;
        if (r15 != SearchSourceFlag.INVITE_LINKING) goto L65;
    L68:
        r9.put("invite_mode", "connection");
    L69:
        r9.put("room_status", "live");
        r9.put("anchor_connect_status", DataType.FALSE);
        r9.put("audience_connect_cnt", DataType.FALSE);
        r9.put("invite_type", "anchor");
        IBaseUser r16 = r23.getRoom().getOwner();
        if (r16 == null) goto L74;
        String r17 = iz.a.a(r16);
        if (r17 == null) goto L74;
    L75:
        r9.put("invitee_id", r17);
        r9.put("invitee_room_status", "connection");
        IRivalExtraInfo r1 = r23.getRivalExtraInfo();
        if (r1 == null) goto L83;
        d6 r18 = r1.getLinkerInfo();
        if (r18 == null) goto L83;
        List r19 = r18.getLinkedUserInfos();
        if (r19 == null) goto L83;
        String r20 = String.valueOf(r19.size());
        if (r20 == null) goto L83;
    L84:
        r9.put("invitee_connect_cnt", r20);
        r9.put("connection_sub_type", "manual_nlink");
        mz0.n r24 = new mz0.n();
        Map<String, String> r25 = r24.a;
        Intrinsics.checkNotNullParameter(r25, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r25.putAll(r9);
        mz0.m r26 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r27 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r27, "linkInfoLog");
        am2.m r28 = r27.a;
        r28.i = 300;
        ((ArrayList) r26.a).add(r28);
        LinkCrossRoomDataHolder.a r29 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r26);
        r26.b(LogCommon.ROOM);
        ((ArrayList) r24.b).addAll(r26.a);
        cy0.e.a.getClass();
        cy0.j r30 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r32 = com.bytedance.android.scope.m.b(r30).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r32);
        ((mz0.i) ((f80.a) r32)).w3("connection_invite", r24.a, r24.b);
        return;
    L83:
        r20 = "2";
    L74:
        r17 = "";
        goto L75
    L65:
        if (r15 == SearchSourceFlag.MAIN_LINK) goto L68;
        r9.put("invite_mode", "routine_pk");
        goto L69
    L61:
        r13 = "";
        goto L62
    L26:
        if (com.bytedance.android.live.revlink.impl.global.b.t() == null) goto L55;
        if (r8 == null) goto L55;
        if (r23.getRoom() == null) goto L55;
        e21.b r33 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r33 == null) goto L33;
        int r34 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        v3 r35 = e21.b.b(r33, com.bytedance.android.live.revlink.impl.pk.utils.l.d.c, null, null, null, null, null, 124);
    L34:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r36 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r36 == null) goto L55;
        com.bytedance.android.live.revenuelink.connect.n r110 = r36.getLinkOutManagerFn();
        if (r110 == null) goto L55;
        long r37 = r8.getId();
        long r38 = r23.getRoom().getId();
        IBaseUser r39 = r23.getRoom().getOwner();
        if (r39 == null) goto L42;
        Intrinsics.checkNotNullParameter(r39, "$this$secUidExt");
        String r40 = r39.getCastSecUid();
        if (r40 == null) goto L42;
    L43:
        IBaseUser r42 = r23.getRoom().getOwner();
        if (r42 == null) goto L49;
        String r43 = r42.getUserId();
        if (r43 == null) goto L49;
        String r111 = r43;
    L50:
        IRoom r112 = r23.getRoom();
        if (r35 == null) goto L53;
        String r44 = w3.a(r35);
    L54:
        r110.g(new d11.b(7, r37, r38, r22, r40, r111, r14, r112, 0, r44), null);
        goto L55
    L53:
        r44 = "";
    L49:
        r111 = "";
    L42:
        r40 = "";
        goto L43
    L33:
        r35 = null;
        goto L34
    L19:
        r8 = null;
        goto L21
    L12:
        r5 = 0;
        goto L13
    L87:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // x31.h
    public final void c(int r46, m2 r47) {
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L104;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L115;
        com.bytedance.android.live.revlink.impl.pk.utils.j r3 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r3 == null) goto L105;
        IBaseUser r4 = r2.getOwner();
        v3 r15 = null;
        if (r4 == null) goto L12;
        String r5 = iz.a.a(r4);
    L13:
        boolean r6 = false;
        boolean r7 = r3.c(r46, r5, 0);
        boolean r8 = true;
        if (r7 != true) goto L116;
        com.bytedance.android.live.revlink.impl.pk.utils.j r9 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r9 == null) goto L106;
        IBaseUser r10 = r2.getOwner();
        if (r10 == null) goto L21;
        String r12 = iz.a.a(r10);
    L23:
        if (r9.a(r12, r46) != true) goto L117;
        if (r47 == null) goto L107;
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r13 = this.g;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L29:
        long r14 = r2.getId();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r47, "battleRival");
        Intrinsics.checkNotNullParameter("", "activityName");
        if (r13.y == true) goto L118;
        r13.y = true;
        if (r47.getRivalExtraInfo() == null) goto L35;
        r13.l = r47.getRivalExtraInfo();
    L35:
        com.bytedance.android.live.revlink.impl.service.internal.a r16 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r16 == null) goto L38;
        int r17 = r16.getCurrentMode();
    L40:
        if (gd0.v.a(r17, 64) == false) goto L42;
    L68:
        int r18 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        com.bytedance.android.live.revlink.impl.pk.utils.l r19 = com.bytedance.android.live.revlink.impl.pk.utils.l.e.c;
        if (r13.v == SearchSourceFlag.INVITE_LINKING) goto L72;
        r8 = false;
    L72:
        if (r8 == false) goto L74;
        r19 = com.bytedance.android.live.revlink.impl.pk.utils.l.c.c;
    L74:
        com.bytedance.android.live.revlink.impl.pk.utils.l r110 = r19;
        if (com.bytedance.android.live.revlink.impl.global.b.t() != null) goto L77;
        return;
    L77:
        if (r47.getRoom() == null) goto L112;
        e21.b r111 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r111 == null) goto L81;
        v3 r20 = e21.b.b(r111, r110, null, null, null, null, null, 124);
    L82:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r22 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r22 == null) goto L113;
        com.bytedance.android.live.revenuelink.connect.n r112 = r22.getLinkOutManagerFn();
        if (r112 == null) goto L114;
        long r23 = r47.getRoom().getId();
        IBaseUser r113 = r47.getRoom().getOwner();
        if (r113 == null) goto L89;
        String r114 = r113.getIdString();
    L90:
        IBaseUser r24 = r47.getRoom().getOwner();
        if (r24 == null) goto L93;
        Intrinsics.checkNotNullParameter(r24, "$this$secUidExt");
        String r115 = r24.getCastSecUid();
    L94:
        IRoom r25 = r47.getRoom();
        int r26 = BizType.AnchorLink.ordinal();
        int r27 = r13.g();
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L97;
        int r38 = r0.d();
    L99:
        if (r20 == null) goto L101;
        String r28 = w3.a(r20);
    L102:
        r112.d(new d11.d(7, r14, r23, r46, 0, r114, r115, r25, r26, "", 0, "", 0, r27, null, 0, null, "", "", "", r38, 0, 0, r28, "", null, null, null, 503316480), null);
        return;
    L101:
        r28 = "";
        goto L102
    L97:
        r38 = 0;
        goto L99
    L93:
        r115 = null;
        goto L94
    L89:
        r114 = null;
        goto L90
    L114:
        return;
    L113:
        return;
    L81:
        r20 = null;
        goto L82
    L112:
        return;
    L42:
        if (r13.v != SearchSourceFlag.MAIN_LINK) goto L44;
        boolean r29 = true;
    L45:
        if (r29 == true) goto L68;
        if (com.bytedance.android.live.revlink.impl.global.b.P() != null) goto L50;
        return;
    L50:
        if (r47.getRoom() == null) goto L109;
        int r30 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        com.bytedance.android.live.revlink.impl.pk.utils.l r32 = com.bytedance.android.live.revlink.impl.pk.utils.l.h.c;
        if (r13.v != SearchSourceFlag.INVITE_LINKING) goto L54;
        r6 = true;
    L54:
        if (r6 == false) goto L56;
        r32 = com.bytedance.android.live.revlink.impl.pk.utils.l.f.c;
    L56:
        com.bytedance.android.live.revlink.impl.pk.utils.l r116 = r32;
        IPKLinkBizDataService r33 = com.bytedance.android.live.revlink.impl.global.b.P();
        Intrinsics.checkNotNull(r33);
        IRoom r34 = r47.getRoom();
        long r35 = r47.getRoom().getId();
        IBaseUser r36 = r47.getRoom().getOwner();
        if (r36 == null) goto L59;
        String r37 = r36.getIdString();
    L60:
        IBaseUser r39 = r47.getRoom().getOwner();
        if (r39 == null) goto L63;
        Intrinsics.checkNotNullParameter(r39, "$this$secUidExt");
        String r40 = r39.getCastSecUid();
    L64:
        String r117 = l51.a.m();
        int r210 = l51.a.j();
        int r42 = r13.g();
        String r43 = r47.getBattleAttachedInfo();
        e21.b r118 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r118 == null) goto L67;
        r15 = e21.b.b(r118, r116, null, null, null, null, null, 120);
    L67:
        IPKLinkBizDataService.b.b(r33, r34, r35, r37, r40, 0, r46, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, r117, r210, "", r42, null, r43, 0, 0, r15, null, null, 6144));
        return;
    L63:
        r40 = null;
        goto L64
    L59:
        r37 = null;
        goto L60
    L109:
        return;
    L44:
        r29 = false;
        goto L45
    L38:
        r17 = 0;
        goto L40
    L118:
        return;
    L107:
        return;
    L117:
        return;
    L21:
        r12 = null;
        goto L23
    L106:
        return;
    L116:
        return;
    L12:
        r5 = null;
        goto L13
    L105:
        return;
    L115:
        return;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        e();
    }

    public PKRivalsSearchRankListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.i = SearchSourceFlag.UNDEFINE;
        f();
    }

    public final void g(DataCenter r5, IGroupRivals.GroupType r6, com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r7, SearchSourceFlag r8) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "groupType");
        Intrinsics.checkNotNullParameter(r7, "presenter");
        Intrinsics.checkNotNullParameter(r8, "searchSourceFlag");
        this.f = r5;
        this.h = r6;
        this.g = r7;
        this.d = new com.bytedance.android.live.revlink.impl.pk.utils.m();
        if (r8 == SearchSourceFlag.INVITE_LINKING) goto L5;
        SearchSourceFlag r9 = SearchSourceFlag.MAIN_LINK;
    L5:
        this.i = r8;
        MultiTypeAdapter r10 = this.e;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L8:
        com.bytedance.android.live.revlink.impl.pk.utils.m r1 = this.d;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInviteListMonitor");
    L11:
        DataCenter r2 = this.f;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDataCenter");
    L14:
        r10.z2(y31.o.a.class, new y31.o(r1, this, r2));
        TextView r12 = (TextView) d(2131381742);
        String r13 = "";
        if (r12 == null) goto L26;
        IGroupRivals.GroupType r3 = this.h;
        if (r3 == null) goto L22;
        int r4 = n.a[r3.ordinal()];
        if (r4 == 1) goto L24;
        if (r4 != 2) goto L22;
        String r14 = getResources().getString(2131917876);
    L25:
        r12.setText(r14);
        goto L26
    L24:
        r14 = getResources().getString(2131917877);
    L22:
        r14 = "";
    L26:
        PkItemExposeRecyclerView r15 = this.c;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L29:
        MultiTypeAdapter r16 = this.e;
        if (r16 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L32:
        r15.setAdapter(r16);
        PkItemExposeRecyclerView r17 = this.c;
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mListView");
    L35:
        int r18 = n.b[r6.ordinal()];
        if (r18 == 1) goto L40;
        if (r18 != 2) goto L41;
        r13 = "hourly_rank";
    L41:
        r17.setInviteIconPanelType(r13);
        return;
    L40:
        r13 = "popularity_rank";
        goto L41
    }
}
