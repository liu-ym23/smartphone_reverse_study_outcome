package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.NestedScrollingParent2;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkUserListContract$View;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkExpandViewHolder;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.TabFragment;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiInviteLogDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKSearchFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerViewOpt;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTopTipView;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.live.ui.PkInviteUserListRefreshLayout;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.d6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.k8;
import com.bytedance.android.livesdk.link.model.l8;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.link.model.v7;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdk.link.model.y7;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorLinkUserListFragment;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/contract/AnchorLinkUserListContract$View;", "Li21/b;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkExpandViewHolder$b;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkUserListFragment extends AnchorLinkUserListContract$View implements i21.b, AnchorLinkExpandViewHolder.b {
    public static final /* synthetic */ int b1 = 0;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public IRivalRankRecommendResponse E;
    public MultiTypeAdapter F;
    public final ArrayList<TabFragment> G;
    public i11.b H;
    public final ArrayList<Integer> H0;
    public final IRoom I;
    public com.bytedance.android.live.revenuelink.connect.n J;
    public boolean K;
    public final Handler L;
    public CharSequence L0;
    public boolean M;
    public AnchorInteractContainerFragment.c N;
    public AnchorInteractContainerFragment.b O;
    public boolean P;
    public final c P0;
    public boolean Q;
    public final boolean R;
    public IRivalExtraInfo S;
    public final LinkCrossRoomDataHolder T;
    public final p21.a U;
    public final com.bytedance.android.live.revenuelink.connect.f V;
    public final b V0;
    public boolean W;
    public com.bytedance.android.live.revlink.impl.pk.utils.k X;
    public FrameLayout Y;
    public FrameLayout Z;
    public PkItemExposeRecyclerViewOpt g;
    public TextView h;
    public PkInviteUserListRefreshLayout i;
    public PkTopTipView j;
    public View k;
    public zy0.b k0;
    public View l;
    public View m;
    public View n;
    public String o;
    public TextView p;
    public boolean p0;
    public FrameLayout q;
    public Map<String, String> r;
    public ImageView s;
    public boolean t;
    public DataCenter u;
    public String v;
    public String w;
    public String x;
    public boolean y;
    public Boolean z;

    public static final class a {
    }

    public static final class b extends i11.c.a {
        public b() {
        }
    }

    public static final class c extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ AnchorLinkUserListFragment a;

        public c(AnchorLinkUserListFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Tg(int r4, i6 r5, ey.l r6) {
            Intrinsics.checkNotNullParameter(r5, "_linkerMessage");
            Intrinsics.checkNotNullParameter(r5, "linkerMessage");
            i6 r7 = r5.castTo(i6.class);
            i11.b r8 = this.a.H;
            if (r8 == null) goto L6;
            List<IBaseUser> r9 = r8.getInviteeList();
            if (r9 == null) goto L6;
        L7:
            Iterator<IBaseUser> r10 = r9.iterator();
        L8:
            String r0 = null;
            if (r10.hasNext() == false) goto L18;
            IBaseUser r12 = r10.next();
            String r1 = iz.a.a(r12);
            k6 r2 = r7.getReply();
            if (r2 == null) goto L14;
            r0 = r2.getToUid();
        L14:
            if (TextUtils.equals(r1, r0) == false) goto L8;
            i11.b r3 = this.a.H;
            if (r3 == null) goto L8;
            r3.r(r12);
            goto L8
        L18:
            i11.b r13 = this.a.H;
            if (r13 == null) goto L22;
            List<IBaseUser> r14 = r13.n();
            if (r14 == null) goto L22;
        L23:
            Iterator<IBaseUser> r15 = r14.iterator();
        L25:
            if (r15.hasNext() == false) goto L35;
            IBaseUser r16 = r15.next();
            String r17 = iz.a.a(r16);
            k6 r18 = r7.getReply();
            if (r18 == null) goto L29;
            String r19 = r18.getToUid();
        L31:
            if (TextUtils.equals(r17, r19) == false) goto L25;
            i11.b r20 = this.a.H;
            if (r20 == null) goto L25;
            r20.t(r16);
            goto L25
        L29:
            r19 = null;
            goto L31
        L35:
            MultiTypeAdapter r22 = this.a.F;
            Intrinsics.checkNotNull(r22);
            r22.notifyDataSetChanged();
            return;
        L22:
            r14 = CollectionsKt.emptyList();
        L6:
            r9 = CollectionsKt.emptyList();
            goto L7
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void q9(d11.c r1, long r2, ey.l r4) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            MultiTypeAdapter r3 = this.a.F;
            Intrinsics.checkNotNull(r3);
            r3.notifyDataSetChanged();
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void O8(d11.b r8, com.bytedance.android.livesdk.link.model.f r9, long r10, ey.l r12) {
            Intrinsics.checkNotNullParameter(r8, "applyParams");
            Intrinsics.checkNotNullParameter(r9, "applyResult");
            super.O8(r8, r9, r10, r12);
            AnchorLinkUserListFragment r13 = this.a;
            r13.W = false;
            i11.b r14 = r13.H;
            if (r14 == null) goto L5;
            IBaseUser r15 = r8.h.getOwner();
            Intrinsics.checkNotNull(r15);
            r14.q(r15);
        L5:
            i11.b r16 = this.a.H;
            if (r16 == null) goto L8;
            r16.b(4, "apply_success_callback");
        L8:
            MultiTypeAdapter r17 = this.a.F;
            Intrinsics.checkNotNull(r17);
            r17.notifyDataSetChanged();
            int r18 = UserListInviteType.a;
            Long r19 = null;
            String r110 = UserListInviteType.a(r8.d, null);
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r0 = com.bytedance.android.live.revlink.impl.global.b.l();
            if (r0 == null) goto L11;
            Intrinsics.checkNotNullParameter("link_banner", "<set-?>");
            r0.c = "link_banner";
        L11:
            LinkedHashMap r1 = new LinkedHashMap();
            IBaseUser r2 = r8.h.getOwner();
            String r3 = "";
            if (r2 == null) goto L15;
            String r4 = r2.getIdString();
            if (r4 == null) goto L15;
        L16:
            MultiLinkAnchorControlContext r5 = com.bytedance.android.live.revlink.impl.global.b.B();
            if (r5 == null) goto L23;
            MultiInviteLogDataContext r6 = r5.getInviteLogContext();
            if (r6 == null) goto L23;
            IRivalExtraInfo r7 = this.a.S;
            if (r7 == null) goto L23;
            ((Map) r6.a.getValue()).put(r4, r7);
        L23:
            d31.d r20 = com.bytedance.android.live.revlink.impl.global.b.c0();
            if (r20 == null) goto L27;
            String r22 = r20.a();
            if (r22 == null) goto L27;
        L28:
            r1.put("anchor_connect_status", r22);
            r1.put("invitee_id", r4);
            r1.put("invitee_status", DataType.FALSE);
            r1.put("invitee_list", r110);
            r1.put("anchor_connection_type", "apply");
            r1.put("source", "link_banner");
            int r111 = com.bytedance.android.live.revlink.impl.utils.f.a;
            if (this.a.A != 3) goto L31;
            int r112 = 14;
        L32:
            r1.put("connection_type", com.bytedance.android.live.revlink.impl.utils.f.a(r112));
            r1.put("connection_sub_type", "manual_nlink");
            r1.put("invitee_room_id", String.valueOf(r8.b));
            if (com.bytedance.android.live.revlink.impl.global.b.h() == null) goto L35;
            v3 r113 = e21.b.c(r8.j);
        L36:
            if (r113 == null) goto L41;
            String r114 = r113.getImprId();
            if (r114 == null) goto L41;
            r3 = r114;
        L41:
            com.bytedance.android.live.revlink.impl.control.d r115 = com.bytedance.android.live.revlink.impl.global.b.f();
            if (r115 == null) goto L44;
            r115.setRequestId(r3);
        L44:
            r1.put("request_id", r3);
            LinkCrossRoomDataHolder r116 = this.a.T;
            if (r116 == null) goto L47;
            r19 = Long.valueOf(r116.c());
        L47:
            r1.put("channel_id", String.valueOf(r19));
            r1.put("is_oncemore", DataType.FALSE);
            r1.put("invitee_connection_status", "live");
            r1.put("from_room_status", "live");
            r1.put("room_status", "live");
            r1.put("invite_mode", "connection");
            r1.put("list_num", String.valueOf(r8.i + 1));
            r1.put("stay_time", String.valueOf(this.a.X.a() / 1000));
            AnchorLinkUserListFragment.da0(this.a, r1);
            int r23 = r8.d;
            if (r23 != 1) goto L50;
        L60:
            com.bytedance.android.livesdk.link.model.f r24 = r9.castTo(com.bytedance.android.livesdk.link.model.f.class);
            if (r24 == null) goto L67;
            String r25 = r24.getEventTrackingInfo();
            if (r25 == null) goto L67;
            Map<String, String> r26 = h41.h.a(r25);
            if (r26 == null) goto L67;
            r1.putAll(r26);
        L67:
            mz0.n r27 = new mz0.n();
            Map<String, String> r28 = r27.a;
            Intrinsics.checkNotNullParameter(r28, "map");
            Intrinsics.checkNotNullParameter(r1, "map");
            r28.putAll(r1);
            mz0.m r29 = new mz0.m();
            LinkCrossRoomDataHolder.a r117 = LinkCrossRoomDataHolder.c;
            com.bytedance.android.live.revlink.impl.a.a(r29);
            r29.b(LogCommon.ROOM);
            ((ArrayList) r27.b).addAll(r29.a);
            cy0.e.a.getClass();
            cy0.j r30 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r32 = com.bytedance.android.scope.m.b(r30).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r32);
            ((mz0.i) ((f80.a) r32)).w3("livesdk_connection_invite", r27.a, r27.b);
            return;
        L50:
            if (r23 == 2) goto L60;
            if (r23 == 3) goto L60;
            if (r23 == 4) goto L60;
            if (r23 == 9) goto L60;
            if (r23 == 105) goto L60;
            if (this.a.H0.contains(Integer.valueOf(r23)) == true) goto L60;
            return;
        L35:
            r113 = null;
            goto L36
        L31:
            r112 = 7;
        L27:
            r22 = "";
        L15:
            r4 = "";
            goto L16
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Vc(d11.b r1, Throwable r2, long r3, ey.l.b r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            AnchorLinkUserListFragment r4 = this.a;
            r4.W = false;
            MultiTypeAdapter r6 = r4.F;
            if (r6 == null) goto L6;
            r6.notifyDataSetChanged();
        L6:
            if ((r2 instanceof ApiServerException) == true) goto L8;
            return;
        L8:
            if (((ApiServerException) r2).getErrorCode() != 31012) goto L12;
            this.a.d.dismiss();
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void hl(d11.d r9, long r10, v4 r12, ey.l r13) {
            Intrinsics.checkNotNullParameter(r9, "params");
            Intrinsics.checkNotNullParameter(r12, "inviteResult");
            if (e21.a.a(r9.i) == false) goto L5;
            return;
        L5:
            super.hl(r9, r10, r12, r13);
            IRoom r14 = r9.h;
            if (r14 != null) goto L8;
        L12:
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r15 = com.bytedance.android.live.revlink.impl.global.b.l();
            if (r15 == null) goto L15;
            Intrinsics.checkNotNullParameter("link_banner", "<set-?>");
            r15.c = "link_banner";
        L15:
            i11.b r16 = this.a.H;
            if (r16 == null) goto L18;
            r16.b(4, "invite_success_callback");
        L18:
            MultiTypeAdapter r17 = this.a.F;
            Intrinsics.checkNotNull(r17);
            r17.notifyDataSetChanged();
            int r18 = UserListInviteType.a;
            Long r1 = null;
            String r19 = UserListInviteType.a(r9.d, null);
            LinkedHashMap r2 = new LinkedHashMap();
            if (r14 == null) goto L21;
            r2.put("invitee_room_id", String.valueOf(r14.getRoomId()));
        L21:
            d31.d r3 = com.bytedance.android.live.revlink.impl.global.b.c0();
            if (r3 == null) goto L25;
            String r4 = r3.a();
            if (r4 == null) goto L25;
        L26:
            r2.put("anchor_connect_status", r4);
            int r5 = com.bytedance.android.live.revlink.impl.utils.f.a;
            if (this.a.A != 3) goto L29;
            int r6 = 14;
        L30:
            r2.put("connection_type", com.bytedance.android.live.revlink.impl.utils.f.a(r6));
            if (r14 == null) goto L33;
            IBaseUser r110 = r14.getOwner();
        L34:
            String r111 = iz.a.a(r110);
            if (r111 != null) goto L37;
            r111 = "";
        L37:
            MultiLinkAnchorControlContext r7 = com.bytedance.android.live.revlink.impl.global.b.B();
            if (r7 == null) goto L44;
            MultiInviteLogDataContext r8 = r7.getInviteLogContext();
            if (r8 == null) goto L44;
            IRivalExtraInfo r20 = this.a.S;
            if (r20 == null) goto L44;
            ((Map) r8.a.getValue()).put(r111, r20);
        L44:
            r2.put("invitee_id", r111);
            r2.put("invitee_status", DataType.FALSE);
            r2.put("invitee_list", r19);
            if (com.bytedance.android.live.revlink.impl.global.b.h() == null) goto L47;
            v3 r112 = e21.b.c(r9.y);
        L48:
            if (r112 == null) goto L51;
            String r113 = r112.getImprId();
            if (r113 == null) goto L51;
        L52:
            com.bytedance.android.live.revlink.impl.control.d r114 = com.bytedance.android.live.revlink.impl.global.b.f();
            if (r114 == null) goto L55;
            r114.setRequestId(r113);
        L55:
            r2.put("request_id", r113);
            LinkCrossRoomDataHolder r115 = this.a.T;
            if (r115 == null) goto L58;
            r1 = Long.valueOf(r115.c());
        L58:
            r2.put("channel_id", String.valueOf(r1));
            r2.put("is_oncemore", DataType.FALSE);
            r2.put("source", "link_banner");
            r2.put("anchor_connection_type", "invite");
            r2.put("from_room_status", "live");
            r2.put("connection_sub_type", "");
            r2.put("room_status", "live");
            r2.put("invitee_connection_status", "live");
            r2.put("invite_mode", "connection");
            AnchorLinkUserListFragment.da0(this.a, r2);
            r2.put("npk_link_type", "single");
            r2.put("invited_cnt", DataType.TRUE);
            r2.put("list_num", String.valueOf(r9.v + 1));
            r2.put("stay_time", String.valueOf(this.a.X.a() / 1000));
            int r22 = r9.d;
            if (r22 != 1) goto L61;
        L71:
            v4 r23 = r12.castTo(v4.class);
            if (r23 == null) goto L78;
            String r24 = r23.getEventTrackingInfo();
            if (r24 == null) goto L78;
            Map<String, String> r25 = h41.h.a(r24);
            if (r25 == null) goto L78;
            r2.putAll(r25);
        L78:
            mz0.n r26 = new mz0.n();
            Map<String, String> r116 = r26.a;
            Intrinsics.checkNotNullParameter(r116, "map");
            Intrinsics.checkNotNullParameter(r2, "map");
            r116.putAll(r2);
            mz0.m r117 = new mz0.m();
            LinkCrossRoomDataHolder.a r118 = LinkCrossRoomDataHolder.c;
            com.bytedance.android.live.revlink.impl.a.a(r117);
            r117.b(LogCommon.ROOM);
            ((ArrayList) r26.b).addAll(r117.a);
            cy0.e.a.getClass();
            cy0.j r119 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r120 = com.bytedance.android.scope.m.b(r119).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r120);
            ((mz0.i) ((f80.a) r120)).w3("livesdk_connection_invite", r26.a, r26.b);
            return;
        L61:
            if (r22 == 2) goto L71;
            if (r22 == 3) goto L71;
            if (r22 == 4) goto L71;
            if (r22 == 9) goto L71;
            if (r22 == 105) goto L71;
            if (this.a.H0.contains(Integer.valueOf(r22)) == true) goto L71;
            return;
        L51:
            r113 = "";
            goto L52
        L47:
            r112 = null;
            goto L48
        L33:
            r110 = null;
            goto L34
        L29:
            r6 = 7;
        L25:
            r4 = "";
            goto L26
        L8:
            if (r14.getOwner() == null) goto L12;
            i11.b r121 = this.a.H;
            if (r121 == null) goto L12;
            IBaseUser r122 = r14.getOwner();
            Intrinsics.checkNotNull(r122);
            r121.y(r122);
            goto L12
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void rp(d11.d r1, Throwable r2, long r3, ey.l.b r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            if (e21.a.a(r1.i) == false) goto L5;
            return;
        L5:
            Intrinsics.checkNotNullParameter(r1, "params");
            MultiTypeAdapter r4 = this.a.F;
            Intrinsics.checkNotNull(r4);
            r4.notifyDataSetChanged();
            if ((r2 instanceof ApiServerException) == true) goto L8;
            return;
        L8:
            if (((ApiServerException) r2).getErrorCode() != 31012) goto L12;
            this.a.d.dismiss();
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AnchorLinkUserListFragment a;

        public d(AnchorLinkUserListFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            AnchorLinkUserListFragment r10 = this.a;
            int r0 = AnchorLinkUserListFragment.b1;
            com.bytedance.android.live.revlink.impl.control.dialog.r r1 = r10.d;
            int r2 = InteractPKSearchFragment.n;
            DataCenter r3 = r10.u;
            TextView r12 = r10.p;
            Intrinsics.checkNotNull(r12);
            r1.zD(InteractPKSearchFragment.a.a(r1, r3, r12.getText().toString(), this.a.t, false, new com.bytedance.android.live.revlink.impl.pk.utils.u(SearchSourceFlag.MAIN_LINK, "link_banner")));
            HashMap r13 = new HashMap();
            r13.put("source", "link_banner");
            mz0.n r4 = new mz0.n();
            Map<String, String> r5 = r4.a;
            Intrinsics.checkNotNullParameter(r5, "map");
            Intrinsics.checkNotNullParameter(r13, "map");
            r5.putAll(r13);
            mz0.m r14 = new mz0.m();
            r14.b(LogCommon.ROOM);
            r14.b(LogCommon.PAGE_SOURCE_LOG);
            List<Object> r6 = r4.b;
            ArrayList r7 = (ArrayList) r6;
            r7.addAll(r14.a);
            cy0.e.a.getClass();
            cy0.j r15 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r16);
            ((mz0.i) ((f80.a) r16)).w3("livesdk_connection_tab_search_click", r4.a, r4.b);
        }
    }

    public static final class e implements PkInviteUserListRefreshLayout.k {
        public final /* synthetic */ AnchorLinkUserListFragment a;

        public final void y0() {
        }

        public final void onFinish() {
            AnchorLinkUserListFragment r0 = this.a;
            r0.z = Boolean.TRUE;
            PkItemExposeRecyclerViewOpt r1 = r0.g;
            if (r1 == null) goto L6;
            r1.r();
            return;
        }

        public final void onRefresh() {
            AnchorLinkUserListFragment r0 = this.a;
            int r1 = AnchorLinkUserListFragment.b1;
            ((i21.c) r0.f).e(r0.A);
        }

        public final void z1() {
            Boolean r0 = this.a.z;
            Intrinsics.checkNotNull(r0);
            if (r0.booleanValue() == false) goto L9;
            View r1 = this.a.k;
            if (r1 == null) goto L7;
            r1.setVisibility(0);
        L7:
            AnchorLinkUserListFragment r2 = this.a;
            r2.z = Boolean.FALSE;
            return;
        }

        public e(AnchorLinkUserListFragment r1) {
            this.a = r1;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ AnchorLinkUserListFragment a;

        public f(AnchorLinkUserListFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PkInviteUserListRefreshLayout r0 = this.a.i;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.g();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ AnchorLinkUserListFragment a;

        public g(AnchorLinkUserListFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PkInviteUserListRefreshLayout r0 = this.a.i;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.g();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ AnchorLinkUserListFragment a;

        public h(AnchorLinkUserListFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i11.b r0 = this.a.H;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.b(4, "show_link_list_dialog");     // Catch: Throwable -> L7
        L5:
            AnchorLinkUserListFragment r1 = this.a;     // Catch: Throwable -> L7
            ((i21.c) r1.f).e(r1.A);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ AnchorLinkUserListFragment a;

        public i(AnchorLinkUserListFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i11.b r0 = this.a.H;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.b(4, "show_link_list_dialog");     // Catch: Throwable -> L7
        L5:
            AnchorLinkUserListFragment r1 = this.a;     // Catch: Throwable -> L7
            ((i21.c) r1.f).e(r1.A);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        if (this.A != 3) goto L7;
        return getString(2131914809);
    L7:
        return getString(2131914808);
    }

    public final boolean ga0() {
        Map<String, String> r0 = this.r;
        if (r0 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNull(r0);
        if (r0.get("linkmic_panel") == null) goto L11;
        Map<String, String> r1 = this.r;
        Intrinsics.checkNotNull(r1);
        if (Intrinsics.areEqual(r1.get("linkmic_panel"), DataType.TRUE) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public AnchorLinkUserListFragment() {
        this.B = Integer.MAX_VALUE;
        this.G = new ArrayList();
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        this.I = r2;
        this.K = true;
        this.L = new Handler();
        this.M = true;
        this.Q = true;
        this.R = b51.c.a((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
        this.T = com.bytedance.android.live.revlink.impl.global.b.j();
        this.U = new p21.a();
        this.V = com.bytedance.android.live.revlink.impl.global.b.a();
        this.X = new com.bytedance.android.live.revlink.impl.pk.utils.k(com.bytedance.android.live.revlink.impl.global.b.k(), "multi_invite");
        this.H0 = new ArrayList();
        this.P0 = new c(this);
        this.V0 = new b();
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        return t6.d(s1.getContext(), t6.c(s1.getContext()) * 1.2f) - 48;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.X.c();
        this.X.b();
        this.W = false;
        this.L.removeCallbacksAndMessages(null);
        ((com.bytedance.android.livesdk.common.c) ((i21.c) this.f)).a = null;
        zy0.b r0 = this.k0;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.dispose();
    L5:
        com.bytedance.android.live.revenuelink.connect.f r1 = this.V;
        if (r1 == null) goto L8;
        r1.removeLinkOutListener(7, this.P0);
    L8:
        i11.b r2 = this.H;
        if (r2 == null) goto L12;
        r2.l(this.V0);
        return;
    }

    public final void onPause() {
        super.onPause();
        PkItemExposeRecyclerViewOpt r0 = this.g;
        if ((r0 instanceof PkItemExposeRecyclerViewOpt) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L7;
        r0.setNestedScrollingEnabled(false);
        r0.requestLayout();
    L7:
        this.X.c();
    }

    public final void onResume() {
        super.onResume();
        b51.b r0 = b51.b.c0;
        if (r0.b() == false) goto L5;
    L7:
        i11.b r1 = this.H;
        if (r1 == null) goto L10;
        r1.b(4, "show_link_list_dialog");
    L10:
        ((i21.c) this.f).e(this.A);
    L11:
        PkItemExposeRecyclerViewOpt r2 = this.g;
        if ((r2 instanceof PkItemExposeRecyclerViewOpt) == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L18;
        r2.setNestedScrollingEnabled(true);
        r2.requestLayout();
    L18:
        if (this.K == true) goto L20;
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r3 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r3 == null) goto L30;
        Intrinsics.checkNotNullParameter("link_banner", "<set-?>");
        r3.a = "link_banner";
    L30:
        this.X.e();
        return;
    L20:
        if (r0.b() == true) goto L22;
        this.L.post(new h(this));
    L26:
        this.K = false;
        goto L27
    L22:
        IRivalRankRecommendResponse r4 = this.E;
        if (r4 == null) goto L25;
        ja0(r4, false);
        goto L26
    L25:
        this.P = true;
        goto L26
    L5:
        if (this.y == true) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkExpandViewHolder.b
    public final void P40(boolean r8) {
        HashMap r0 = new HashMap();
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L7:
        if (r2 == null) goto L12;
        r0.put("room_id", String.valueOf(r2.getRoomId()));
        String r3 = iz.a.a(r2.getOwner());
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r0.put("anchor_id", r3);
    L12:
        d31.d r4 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r4 == null) goto L15;
        String r5 = r4.s();
    L16:
        r0.put("room_status", r5);
        r0.put("anchor_connect_status", DataType.FALSE);
        if (r8 == false) goto L19;
        r0.put("click_type", "show");
    L20:
        d31.d r6 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r6 == null) goto L23;
        String r7 = r6.c();
    L24:
        r0.put("connection_type", r7);
        d31.d r9 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r9 == null) goto L27;
        String r10 = r9.b();
    L28:
        r0.put("connection_sub_type", r10);
        r0.put("invite_mode", "");
        r0.put("source", "link_banner");
        mz0.n r12 = new mz0.n();
        Map<String, String> r13 = r12.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r13.putAll(r0);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_anchor_list_fold_click", r12.a, r12.b);
        mz0.n r16 = new mz0.n();
        Map<String, String> r17 = r16.a;
        Intrinsics.checkNotNullParameter(r17, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r17.putAll(r0);
        Object r18 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_pk_more_mutual_click", r16.a, r16.b);
        if (r8 == false) goto L39;
        IRivalRankRecommendResponse r19 = this.E;
        if (r19 == null) goto L43;
        Intrinsics.checkNotNull(r19);
        if (r19.getTabRivals() == null) goto L43;
        IRivalRankRecommendResponse r20 = this.E;
        Intrinsics.checkNotNull(r20);
        s2 r22 = r20.getTabRivals();
        Intrinsics.checkNotNull(r22);
        if (r22.getGroupRivals() == null) goto L43;
        IRivalRankRecommendResponse r23 = this.E;
        Intrinsics.checkNotNull(r23);
        s2 r24 = r23.getTabRivals();
        Intrinsics.checkNotNull(r24);
        Map r25 = r24.getGroupRivals();
        Intrinsics.checkNotNull(r25);
        IGroupRivals.GroupType r26 = IGroupRivals.GroupType.GroupFeedFollowed;
        if (r25.get(Long.valueOf(r26.ordinal())) == null) goto L43;
        IRivalRankRecommendResponse r27 = this.E;
        Intrinsics.checkNotNull(r27);
        s2 r28 = r27.getTabRivals();
        Intrinsics.checkNotNull(r28);
        Map r29 = r28.getGroupRivals();
        Intrinsics.checkNotNull(r29);
        Object r30 = r29.get(Long.valueOf(r26.ordinal()));
        Intrinsics.checkNotNull(r30);
        List r32 = ((IGroupRivals) r30).getRivals();
        Intrinsics.checkNotNull(r32);
        this.B = r32.size();
    L43:
        if (this.E == null) goto L45;
        MultiTypeAdapter r33 = this.F;
        Intrinsics.checkNotNull(r33);
        IRivalRankRecommendResponse r34 = this.E;
        Intrinsics.checkNotNull(r34);
        r33.a = la0(r34, r8, false);
    L45:
        MultiTypeAdapter r35 = this.F;
        Intrinsics.checkNotNull(r35);
        r35.notifyDataSetChanged();
        return;
    L39:
        IRivalRankRecommendResponse r36 = this.E;
        if (r36 == null) goto L43;
        Intrinsics.checkNotNull(r36);
        ka0(r36);
        goto L43
    L27:
        r10 = "";
        goto L28
    L23:
        r7 = "";
        goto L24
    L19:
        r0.put("click_type", "fold");
        goto L20
    L15:
        r5 = "";
        goto L16
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkUserListContract$View
    public final void ba0(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        com.bytedance.android.live.revenue.common.k.d(r4, com.bytedance.live.kmp.util.c.a(2131917879, new Object[0]));
        b51.b r5 = b51.b.c0;
        r5.getClass();
        if (((Boolean) b51.b.P.getValue(r5, b51.b.a[40])).booleanValue() == false) goto L14;
        PkInviteUserListRefreshLayout r6 = this.i;
        if (r6 != null) goto L10;
    L12:
        View r7 = this.l;
        Intrinsics.checkNotNull(r7);
        r7.setVisibility(8);
        NestedScrollingParent2 r8 = this.g;
        Intrinsics.checkNotNull(r8);
        r8.setVisibility(8);
        return;
    L10:
        if (r6.e != true) goto L12;
        new Handler().postDelayed(new f(this), 1000);
        goto L12
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkUserListContract$View
    public final void ca0(IRivalRankRecommendResponse r10) {
        Intrinsics.checkNotNullParameter(r10, Constants.Keys.DATA);
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        this.r = r10.getListAbValueMap();
        if (this.Q == true) goto L8;
    L13:
        PkTopTipView r0 = this.j;
        if (r0 == null) goto L16;
        r0.setData(r10.getTopTip());
    L16:
        ka0(r10);
        this.E = r10;
        PkInviteUserListRefreshLayout r1 = this.i;
        if (r1 == null) goto L19;
        boolean r3 = r1.e;
    L20:
        if (r1 != null) goto L22;
    L24:
        FrameLayout r2 = this.Y;
        Intrinsics.checkNotNull(r2);
        r2.setVisibility(8);
        if (r10.getAutoMatchInfo() == null) goto L30;
        j8 r4 = r10.getAutoMatchInfo();
        if (r4 != null) goto L29;
        FrameLayout r5 = this.Y;
        Intrinsics.checkNotNull(r5);
        r5.setVisibility(8);
        goto L30
    L29:
        FrameLayout r6 = this.Y;
        Intrinsics.checkNotNull(r6);
        r6.setVisibility(0);
        ia0(r4, r10);
    L30:
        this.H0.clear();
        PkItemExposeRecyclerViewOpt r7 = this.g;
        Intrinsics.checkNotNull(r7);
        r7.c.clear();
        Iterator<TabFragment> r8 = this.G.iterator();
    L32:
        if (r8.hasNext() == false) goto L36;
        PkItemExposeRecyclerView r9 = r8.next().d;
        if (r9 == null) goto L32;
        r9.r();
        goto L32
    L36:
        MultiTypeAdapter r12 = this.F;
        Intrinsics.checkNotNull(r12);
        r12.a = la0(r10, false, true);
        MultiTypeAdapter r13 = this.F;
        Intrinsics.checkNotNull(r13);
        r13.notifyDataSetChanged();
        View r14 = this.l;
        Intrinsics.checkNotNull(r14);
        r14.setVisibility(8);
        if (this.A != 3) goto L39;
    L41:
        View r15 = this.n;
        Intrinsics.checkNotNull(r15);
        r15.setVisibility(8);
    L43:
        if (r10.getSearchBar() == null) goto L55;
        l8 r16 = r10.getSearchBar();
        Intrinsics.checkNotNull(r16);
        if (r16.getContent().length() != 0) goto L47;
        boolean r17 = true;
    L48:
        if (r17 == true) goto L50;
        l8 r18 = r10.getSearchBar();
        Intrinsics.checkNotNull(r18);
        this.o = r18.getContent();
        TextView r19 = this.p;
        Intrinsics.checkNotNull(r19);
        l8 r20 = r10.getSearchBar();
        Intrinsics.checkNotNull(r20);
        r19.setText(r20.getContent());
    L50:
        l8 r22 = r10.getSearchBar();
        Intrinsics.checkNotNull(r22);
        if (r22.getBackgroundImage() == null) goto L55;
        l8 r23 = r10.getSearchBar();
        Intrinsics.checkNotNull(r23);
        py.k r24 = r23.getBackgroundImage();
        Intrinsics.checkNotNull(r24);
        if (r24.isValid() == false) goto L55;
        this.t = true;
        View r25 = this.n;
        l8 r26 = r10.getSearchBar();
        Intrinsics.checkNotNull(r26);
        ((ObservableSubscribeProxy) a1.k(r26.getBackgroundImage()).compose(RxUtil.rxSchedulerHelper()).as(S90())).subscribe(new t(r25), u.a);
        TextView r27 = this.p;
        Intrinsics.checkNotNull(r27);
        r27.setTextColor(ColorProtector.parseColor("#809C4800"));
        ImageView r28 = this.s;
        Intrinsics.checkNotNull(r28);
        r28.setImageDrawable(s1.m(2131251336));
        goto L55
    L47:
        r17 = false;
    L55:
        b51.b r29 = b51.b.c0;
        if (r29.b() == true) goto L58;
    L60:
        ja0(r10, false);
    L61:
        this.X.f(new com.bytedance.android.live.revlink.impl.pk.utils.i(this.C, com.bytedance.android.live.revlink.impl.pk.utils.t.c(r10), com.bytedance.android.live.revlink.impl.pk.utils.t.b(r10), r3));
        if (r10.getCommonBanner() == null) goto L98;
        IRoom r30 = this.I;
        if (r30 != null) goto L66;
    L68:
        v7 r32 = r10.getCommonBanner();
        Intrinsics.checkNotNull(r32);
        String r33 = r32.getBannerInfo();
        v7 r110 = r10.getCommonBanner();
        Intrinsics.checkNotNull(r110);
        String r111 = r110.getBannerArea();
        if (TextUtils.isEmpty(r33) == true) goto L71;
    L72:
        ReadOnlyProperty r34 = b51.b.h;
        KProperty[] r35 = b51.b.a;
        if (TextUtils.isEmpty((String) r34.getValue(r29, r35[6])) == true) goto L91;
        FrameLayout r36 = this.q;
        Intrinsics.checkNotNull(r36);
        r36.setVisibility(0);
        if (getContext() == null) goto L101;
        final String r37 = (String) r34.getValue(r29, r35[6]);
        Context r38 = getContext();
        xy0.a<?> r39 = null;
        if (r38 == null) goto L80;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r40 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r38, null, new AnchorLinkUserListFragment$loadTopBanner$$inlined$let$lambda$1(r37));
    L81:
        FrameLayout r42 = this.q;
        Intrinsics.checkNotNull(r42);
        r42.removeAllViews();
        if (r40 == null) goto L84;
        FrameLayout r43 = this.q;
        Intrinsics.checkNotNull(r43);
        r43.addView(r40.d, new ViewGroup.LayoutParams(-1, -1));
    L84:
        HashMap r44 = new HashMap();
        r44.put("banner_info", r33);
        r44.put("banner_area", r111);
        r44.put("from_panel", 1);
        r44.put("source", this.x);
        if (TextUtils.isEmpty(this.v) == true) goto L87;
        r44.put("source", "guide");
        r44.put("guide_type", this.v);
    L87:
        r44.put("to_user_group", this.w);
        if (r40 == null) goto L90;
        r39 = r40.g();
    L90:
        Intrinsics.checkNotNull(r39);
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r39).load(r37, r44);
        return;
    L80:
        r40 = null;
        goto L81
    L101:
        return;
    L91:
        FrameLayout r112 = this.q;
        Intrinsics.checkNotNull(r112);
        r112.setVisibility(8);
        return;
    L71:
        if (TextUtils.isEmpty(r111) == true) goto L91;
    L66:
        if (r30.getStreamType() != LiveMode.SCREEN_RECORD) goto L68;
        return;
    L98:
        return;
    L58:
        if (this.P == true) goto L60;
        if (r3 == false) goto L61;
    L39:
        if (this.R == true) goto L41;
        View r45 = this.n;
        Intrinsics.checkNotNull(r45);
        r45.setVisibility(0);
        goto L43
    L22:
        if (r1.e != true) goto L24;
        new Handler().postDelayed(new g(this), 1000);
        goto L24
    L19:
        r3 = false;
        goto L20
    L8:
        if (r10.getTabLocate() != 1) goto L13;
        AnchorInteractContainerFragment.b r46 = this.O;
        if (r46 == null) goto L12;
        KProperty[] r47 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        r46.onUpdate(1);
    L12:
        this.Q = false;
        goto L13
    }

    public final void ka0(IRivalRankRecommendResponse r12) {
        if (r12.getTabRivals() == null) goto L100;
        s2 r0 = r12.getTabRivals();
        Intrinsics.checkNotNull(r0);
        if (r0.getGroupRivals() == null) goto L101;
        s2 r1 = r12.getTabRivals();
        Intrinsics.checkNotNull(r1);
        Map r2 = r1.getGroupRivals();
        Intrinsics.checkNotNull(r2);
        IGroupRivals.GroupType r3 = IGroupRivals.GroupType.GroupFeedFollowed;
        if (r2.get(Long.valueOf(r3.ordinal())) == null) goto L102;
        s2 r13 = r12.getTabRivals();
        Intrinsics.checkNotNull(r13);
        Map r14 = r13.getGroupRivals();
        Intrinsics.checkNotNull(r14);
        IGroupRivals r15 = (IGroupRivals) r14.get(Long.valueOf(r3.ordinal()));
        p21.a r4 = this.U;
        Intrinsics.checkNotNull(r15);
        List r5 = r15.getRivals();
        Intrinsics.checkNotNull(r5);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "list");
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L11:
        if (r8.hasNext() == false) goto L88;
        m2 r9 = (m2) r8.next();
        IRivalExtraInfo r10 = r9.getRivalExtraInfo();
        IRoom r16 = r9.getRoom();
        if (r16 == null) goto L11;
        boolean r17 = true;
        if (r10 == null) goto L29;
        Intrinsics.checkNotNullParameter(r10, "$this$anchorFolding");
        String r18 = r10.getRecommendInfo();
        if (r18 != null) goto L90;
    L25:
        boolean r19 = false;
    L26:
        if (r19 != true) goto L29;
    L85:
        if (r17 == true) goto L86;
        r6.add(r9);
        goto L11
    L86:
        r7.add(r9);
        goto L11
    L90:
        JsonElement r20 = ((JsonObject) l97.a.a.fromJson(r18, TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)))).get("anchor_folding");     // Catch: Exception -> L24
        if (r20 == null) goto L25;
        r19 = r20.getAsBoolean();     // Catch: Exception -> L24
    L29:
        if (TextUtils.isEmpty(r9.getLinkText()) == false) goto L85;
        if (r10 == null) goto L35;
        com.bytedance.android.livesdk.link.model.u r22 = r10.getAnchorLinkmicUserSettings();
        if (r22 == null) goto L35;
        boolean r23 = r22.isTurnOn();
    L36:
        if (r23 == false) goto L85;
        if (((IRoomLinkExt) r16.castTo(IRoomLinkExt.class)).getLinkMicInfo() == null) goto L41;
        boolean r24 = true;
    L42:
        if (r24 == true) goto L85;
        Map r25 = r16.getLinkMap();
        if (r25 == null) goto L58;
        if (r10 == null) goto L58;
        d6 r26 = r10.getLinkerInfo();
        if (r26 == null) goto L58;
        List r27 = r26.getLinkedUserInfos();
        if (r27 == null) goto L58;
        if (r25.containsKey(String.valueOf(7)) == false) goto L58;
        if (r27.size() != r41.f.b) goto L58;
        boolean r28 = true;
    L59:
        if (r28 == true) goto L85;
        z5 r29 = ((IRoomLinkExt) r16.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r29 == null) goto L68;
        List r30 = r29.getPlayModes();
        if (r30 == null) goto L68;
        if (r30.contains(3L) != true) goto L68;
        boolean r32 = true;
    L69:
        if (r32 == true) goto L85;
        Map r33 = r16.getLinkMap();
        if (r33 != null) goto L74;
        boolean r34 = false;
    L75:
        if (r34 == false) goto L84;
        z5 r35 = ((IRoomLinkExt) r16.castTo(IRoomLinkExt.class)).getLinkerDetail();
        if (r35 == null) goto L80;
        String r36 = r35.getFunctionType2();
        if (r36 == null) goto L80;
    L82:
        if (TextUtils.equals(r36, "new_audience") == true) goto L84;
    L80:
        r36 = "";
    L84:
        r17 = false;
        goto L85
    L74:
        r34 = r33.containsKey(String.valueOf(8));
    L68:
        r32 = false;
    L58:
        r28 = false;
        goto L59
    L41:
        r24 = false;
    L35:
        r23 = true;
        goto L36
    L88:
        List r37 = CollectionsKt.plus(r6, r7);
        int r38 = r6.size();
        Intrinsics.checkNotNullParameter(r37, "sortRivals");
        this.B = r38;
        this.C = r38;
        r15.setSortRivals(r37);
        return;
    L102:
        return;
    L101:
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        T r5 = this.f;
        if (r5 == 0) goto L6;
        ((com.bytedance.android.livesdk.common.c) ((i21.c) r5)).a = this;
    L6:
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L27;
        i11.b r0 = null;
        if (com.bytedance.android.live.revlink.impl.global.b.t() == null) goto L12;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r6 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r6 == null) goto L12;
        com.bytedance.android.live.revenuelink.connect.n r7 = r6.getLinkOutManagerFn();
    L13:
        this.J = r7;
        com.bytedance.android.live.revenuelink.connect.f r8 = this.V;
        if (r8 == null) goto L17;
        r8.addLinkOutListener(7, this.P0);
    L17:
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L23;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r9 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r9 == null) goto L23;
        i11.b r10 = r9.getLinkUserCenter();
        if (r10 == null) goto L23;
        r0 = r10;
    L23:
        this.H = r0;
        if (r0 == null) goto L28;
        r0.i(this.V0);
        return;
    L28:
        return;
    L12:
        r7 = null;
        goto L13
    }

    public final void setUserVisibleHint(boolean r4) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r4);
        PkItemExposeRecyclerViewOpt r0 = this.g;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.setNestedScrollingEnabled(r4);
        PkItemExposeRecyclerViewOpt r1 = this.g;
        Intrinsics.checkNotNull(r1);
        r1.requestLayout();
    L6:
        if (this.K == false) goto L16;
        if (r4 == false) goto L16;
        if (b51.b.c0.b() == true) goto L11;
        this.L.post(new i(this));
    L15:
        this.K = false;
        goto L16
    L11:
        IRivalRankRecommendResponse r2 = this.E;
        if (r2 == null) goto L14;
        ja0(r2, false);
        goto L15
    L14:
        this.P = true;
    L16:
        if (r4 == false) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r5 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r5 == null) goto L20;
        Intrinsics.checkNotNullParameter("link_banner", "<set-?>");
        r5.a = "link_banner";
    L20:
        this.X.e();
        return;
    L21:
        this.X.c();
    }

    public static final void da0(AnchorLinkUserListFragment r5, Map r6) {
        r5.getClass();
        r6.put("invite_type", "anchor");
        d31.d r0 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L7:
        r6.put("anchor_connect_status", r1);
        r6.put("invitee_connect_cnt", DataType.FALSE);
        r6.put("invitee_room_status", "live");
        IRivalExtraInfo r2 = r5.S;
        if (r2 == null) goto L17;
        Intrinsics.checkNotNull(r2);
        d6 r3 = r2.getLinkerInfo();
        if (r3 == null) goto L12;
        List r4 = r3.getLinkedUserInfos();
    L13:
        if (r4 == null) goto L17;
        IRivalExtraInfo r7 = r5.S;
        Intrinsics.checkNotNull(r7);
        d6 r8 = r7.getLinkerInfo();
        Intrinsics.checkNotNull(r8);
        List r9 = r8.getLinkedUserInfos();
        Intrinsics.checkNotNull(r9);
        if (r9.size() <= 0) goto L17;
        r6.put("connection_sub_type", "manual_nlink");
        IRivalExtraInfo r10 = r5.S;
        Intrinsics.checkNotNull(r10);
        d6 r12 = r10.getLinkerInfo();
        Intrinsics.checkNotNull(r12);
        List r13 = r12.getLinkedUserInfos();
        Intrinsics.checkNotNull(r13);
        r6.put("invitee_connect_cnt", String.valueOf(r13.size()));
        r6.put("invitee_room_status", "connection");
        goto L17
    L12:
        r4 = null;
    L17:
        r6.put("audience_connect_cnt", DataType.FALSE);
        return;
    L6:
        r1 = "";
        goto L7
    }

    public static boolean ha0(IRivalRankRecommendResponse r2, long r3) {
        if (r2.getTabRivals() == null) goto L9;
        s2 r0 = r2.getTabRivals();
        Intrinsics.checkNotNull(r0);
        if (r0.getGroupRivals() == null) goto L9;
        s2 r1 = r2.getTabRivals();
        Intrinsics.checkNotNull(r1);
        Map r4 = r1.getGroupRivals();
        Intrinsics.checkNotNull(r4);
        if (r4.get(Long.valueOf(r3)) == null) goto L9;
        s2 r5 = r2.getTabRivals();
        Intrinsics.checkNotNull(r5);
        Map r6 = r5.getGroupRivals();
        Intrinsics.checkNotNull(r6);
        Object r7 = r6.get(Long.valueOf(r3));
        Intrinsics.checkNotNull(r7);
        List r8 = ((IGroupRivals) r7).getRivals();
    L10:
        if (r8 != null) goto L12;
    L14:
        return false;
    L12:
        if (r8.isEmpty() == true) goto L14;
        return true;
    L9:
        r8 = null;
        goto L10
    }

    @Override // i21.b
    public final void ZY(IRoom r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, "targetRoom");
        com.bytedance.android.live.revenuelink.connect.n r0 = this.J;
        Intrinsics.checkNotNull(r0);
        LinkCrossRoomDataHolder r1 = this.T;
        if (r1 == null) goto L5;
        long r3 = r1.c();
    L6:
        long r5 = r14.getId();
        String r7 = iz.a.a(r14.getOwner());
        IBaseUser r16 = r14.getOwner();
        String r12 = "";
        if (r16 == null) goto L12;
        Intrinsics.checkNotNullParameter(r16, "$this$secUidExt");
        String r17 = r16.getCastSecUid();
        if (r17 == null) goto L12;
        String r8 = r17;
    L13:
        Long r18 = null;
        r0.e(new d11.c(7, r3, r5, r7, r8, r15, "click_item_cancel"), null);
        HashMap r2 = new HashMap();
        if (com.bytedance.android.live.revlink.impl.global.b.z() != null) goto L16;
    L27:
        r2.put("connection_type", "anchor");
        LinkCrossRoomDataHolder r4 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r4 == null) goto L30;
        r18 = Long.valueOf(r4.c());
    L30:
        r2.put("channel_id", String.valueOf(r18));
        if (r15 != 0) goto L36;
        LinkCrossRoomDataHolder r19 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r19 == null) goto L35;
        r12 = com.bytedance.android.live.revlink.impl.multianchor.utils.x.f(r19.i());
    L35:
        r2.put("match_type", r12);
    L36:
        if (r15 != 0) goto L38;
        String r110 = "livesdk_match_cancel_click";
    L39:
        mz0.n r111 = new mz0.n();
        mz0.o r6 = new mz0.o(r111.a);
        e21.c.d(r6, com.bytedance.android.live.revlink.impl.global.b.G());
        r6.b(r2);
        mz0.m r9 = new mz0.m();
        LinkCrossRoomDataHolder.a r10 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.a(r9);
        r9.b(LogCommon.ROOM);
        ((ArrayList) r111.b).addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((mz0.i) ((f80.a) r20)).w3(r110, r111.a, r111.b);
        return;
    L38:
        r110 = "livesdk_connectapplycancel_click";
        goto L39
    L16:
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L22;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r22 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r22 == null) goto L22;
        i11.b r23 = r22.getLinkUserCenter();
        if (r23 == null) goto L22;
    L23:
        if (r23 == null) goto L25;
        Integer r24 = Integer.valueOf(r23.c());
    L26:
        r2.put("anchor_connect_status", String.valueOf(r24));
        goto L27
    L25:
        r24 = null;
    L22:
        r23 = null;
    L12:
        r8 = "";
        goto L13
    L5:
        r3 = 0;
        goto L6
    }

    public final void ia0(j8 r10, IRivalRankRecommendResponse r12) {
        if (getContext() != null) goto L5;
        return;
    L5:
        b51.b r0 = b51.b.c0;
        r0.getClass();
        ReadOnlyProperty r1 = b51.b.U;
        KProperty[] r2 = b51.b.a;
        if (((Boolean) r1.getValue(r0, r2[45])).booleanValue() == true) goto L9;
        FrameLayout r13 = this.Y;
        Intrinsics.checkNotNull(r13);
        r13.setVisibility(8);
        return;
    L9:
        LiveMode r3 = null;
        if (r12 == null) goto L12;
        s2 r4 = r12.getTabRivals();
    L13:
        String r5 = DataType.TRUE;
        if (r4 == null) goto L24;
        s2 r6 = r12.getTabRivals();
        Intrinsics.checkNotNull(r6);
        if (r6.getGroupRivals() == null) goto L24;
        s2 r7 = r12.getTabRivals();
        Intrinsics.checkNotNull(r7);
        Map r8 = r7.getGroupRivals();
        Intrinsics.checkNotNull(r8);
        IGroupRivals.GroupType r9 = IGroupRivals.GroupType.GroupFeedFollowed;
        if (r8.get(Long.valueOf(r9.ordinal())) == null) goto L24;
        s2 r14 = r12.getTabRivals();
        Intrinsics.checkNotNull(r14);
        Map r15 = r14.getGroupRivals();
        Intrinsics.checkNotNull(r15);
        Object r16 = r15.get(Long.valueOf(r9.ordinal()));
        Intrinsics.checkNotNull(r16);
        List r17 = ((IGroupRivals) r16).getSortRivals();
        if (r17 == null) goto L24;
        if (r17.size() <= 0) goto L24;
        Object r18 = DataType.TRUE;
    L25:
        final String r19 = (String) b51.b.S.getValue(r0, r2[43]);
        Context r20 = getContext();
        if (r20 == null) goto L28;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r22 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r20, null, new AnchorLinkUserListFragment$loadRandomLinkView$$inlined$let$lambda$1(r19));
    L29:
        this.k0 = r22;
        FrameLayout r23 = this.Y;
        Intrinsics.checkNotNull(r23);
        r23.removeAllViews();
        FrameLayout r24 = this.Y;
        Intrinsics.checkNotNull(r24);
        zy0.b r25 = this.k0;
        Intrinsics.checkNotNull(r25);
        r24.addView(r25.c(), new ViewGroup.LayoutParams(-1, -1));
        IBaseUser r26 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();     // Catch: Exception -> L39
        if (r26 == null) goto L41;
        py.k r27 = r26.getAvatarThumbKt();     // Catch: Exception -> L39
        if (r27 == null) goto L41;
        List r28 = r27.getUrls();     // Catch: Exception -> L39
        if (r28 == null) goto L41;
        String r29 = (String) ListProtector.get(r28, 0);     // Catch: Exception -> L39
        if (r29 == null) goto L41;
    L42:
        HashMap r30 = new HashMap();
        r30.put("random_info", com.bytedance.android.live.revlink.impl.utils.e.b(r10));
        r30.put("anchor_avatar", r29);
        r30.put("if_mutual_online", r18);
        IRoom r110 = this.I;
        if (r110 == null) goto L46;
        r3 = r110.getStreamType();
    L46:
        if (r3 == LiveMode.SCREEN_RECORD) goto L49;
        r5 = DataType.FALSE;
    L49:
        r30.put("is_record", r5);
        if (r22 == null) goto L55;
        xy0.a<?> r111 = r22.g();
        Intrinsics.checkNotNull(r111);
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r111).load(r19, r30);
        return;
    L55:
        return;
    L41:
        r29 = "";
    L39:
        e = move-exception;
        ALogger.e("anchor_link_user_list_random_link", e);
        goto L41
    L28:
        r22 = null;
    L24:
        r18 = DataType.FALSE;
        goto L25
    L12:
        r4 = null;
        goto L13
    }

    public final void ja0(IRivalRankRecommendResponse r6, boolean r7) {
        Intrinsics.checkNotNull(r6);
        if (r6.getTabRivals() == null) goto L15;
        s2 r0 = r6.getTabRivals();
        Intrinsics.checkNotNull(r0);
        if (r0.getGroupRivals() == null) goto L15;
        s2 r1 = r6.getTabRivals();
        Intrinsics.checkNotNull(r1);
        Map r2 = r1.getGroupRivals();
        Intrinsics.checkNotNull(r2);
        IGroupRivals.GroupType r3 = IGroupRivals.GroupType.GroupRivalsActivity;
        if (r2.get(Long.valueOf(r3.ordinal())) == null) goto L15;
        s2 r4 = r6.getTabRivals();
        Intrinsics.checkNotNull(r4);
        Map r5 = r4.getGroupRivals();
        Intrinsics.checkNotNull(r5);
        Object r8 = r5.get(Long.valueOf(r3.ordinal()));
        Intrinsics.checkNotNull(r8);
        List r9 = ((IGroupRivals) r8).getRivals();
        if (r9 == null) goto L15;
        if (r9.size() <= 0) goto L15;
        if (this.M == false) goto L15;
        mz0.n r10 = new mz0.n();
        mz0.m r12 = new mz0.m();
        r12.b(LogCommon.ROOM);
        r12.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r10.b).addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_connection_campaign_banner_show", r10.a, r10.b);
        this.M = false;
    L15:
        mz0.n r15 = new mz0.n();
        mz0.o r16 = new mz0.o(r15.a);
        if (r7 == false) goto L18;
        String r17 = DataType.TRUE;
    L19:
        r16.a("is_switch", r17);
        r16.a("friends_cnt", String.valueOf(this.C));
        r16.a("total_friends_num", String.valueOf(com.bytedance.android.live.revlink.impl.pk.utils.t.c(r6)));
        r16.a("source", "live_pk_icon");
        if (this.D == true) goto L22;
        r16.a("source", "tab_click");
    L22:
        this.D = false;
        String r18 = this.v;
        if (TextUtils.isEmpty(r18) == true) goto L27;
        if (r18 != null) goto L26;
        r18 = "";
    L26:
        r16.a("guide_type", r18);
        r16.a("source", "guide");
    L27:
        r16.a("room_status", "live");
        r16.a("anchor_connect_status", DataType.FALSE);
        r16.a("channel_id", DataType.FALSE);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        r19.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r15.b).addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_connection_tab_show", r15.a, r15.b);
        return;
    L18:
        r17 = DataType.FALSE;
        goto L19
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(requireView(), r4);
        AnchorInteractContainerFragment.c r5 = this.N;
        if (r5 == null) goto L5;
        Intrinsics.checkNotNull(r5);
        r5.d(this.R);
    L5:
        j8 r6 = (j8) vh7.f.c(j8.class);
        r6.set_matchText((a5) GsonProtectorUtils.fromJson(l97.a.a, s1.B(2131921464), TypesJVMKt.getJavaType(Reflection.typeOf(Text.class))));
        r6.setAccelerateLimit(15);
        r6.setDefaultWaitLimit(60);
        r6.setMainTitle("随机PK");
        r6.setSubTitle("为你寻找PK值相近对手");
        r6.setWaitSec(9);
        k8 r7 = vh7.f.c(k8.class);
        r7.setInviteLimitSec(10);
        r7.setPkAutoMatchIndex(1);
        Unit r0 = Unit.INSTANCE;
        r6.setConfig(r7);
        FrameLayout r8 = this.Y;
        Intrinsics.checkNotNull(r8);
        r8.setVisibility(0);
        ia0(r6, null);
        PkInviteUserListRefreshLayout r9 = this.i;
        Intrinsics.checkNotNull(r9);
        r9.setVisibility(0);
    }

    public final List<Object> fa0(IRivalRankRecommendResponse r4, long r5, int r7) {
        ArrayList r0 = new ArrayList();
        if (ha0(r4, IGroupRivals.GroupType.GroupFeedRecommend.ordinal()) == true) goto L5;
    L7:
        List r1 = null;
        String r6 = null;
    L8:
        if (r1 == null) goto L14;
        Iterator r8 = r1.iterator();
        int r9 = 0;
    L11:
        if (r8.hasNext() == false) goto L13;
        r0.add(ea0((m2) r8.next(), r7, r6, r9));
        r9 = r9 + 1;
        goto L11
    L13:
        r0.add(new q21.b.a());
    L14:
        return r0;
    L5:
        if (ha0(r4, r5) == false) goto L7;
        s2 r2 = r4.getTabRivals();
        Intrinsics.checkNotNull(r2);
        Map r3 = r2.getGroupRivals();
        Intrinsics.checkNotNull(r3);
        Object r10 = r3.get(Long.valueOf(r5));
        Intrinsics.checkNotNull(r10);
        r1 = ((IGroupRivals) r10).getRivals();
        s2 r12 = r4.getTabRivals();
        Intrinsics.checkNotNull(r12);
        Map r13 = r12.getGroupRivals();
        Intrinsics.checkNotNull(r13);
        Object r14 = r13.get(Long.valueOf(r5));
        Intrinsics.checkNotNull(r14);
        r6 = ((IGroupRivals) r14).getImprId();
        goto L8
    }

    public final List<Object> la0(IRivalRankRecommendResponse r13, boolean r14, boolean r15) {
        LinkedList r0 = new LinkedList();
        if (r13.getTabRivals() == null) goto L20;
        s2 r1 = r13.getTabRivals();
        Intrinsics.checkNotNull(r1);
        if (r1.getGroupRivals() == null) goto L20;
        s2 r2 = r13.getTabRivals();
        Intrinsics.checkNotNull(r2);
        Map r3 = r2.getGroupRivals();
        Intrinsics.checkNotNull(r3);
        IGroupRivals.GroupType r4 = IGroupRivals.GroupType.GroupRivalsActivity;
        if (r3.get(Long.valueOf(r4.ordinal())) == null) goto L20;
        s2 r5 = r13.getTabRivals();
        Intrinsics.checkNotNull(r5);
        Map r6 = r5.getGroupRivals();
        Intrinsics.checkNotNull(r6);
        Object r7 = r6.get(Long.valueOf(r4.ordinal()));
        Intrinsics.checkNotNull(r7);
        List r8 = ((IGroupRivals) r7).getRivals();
        s2 r9 = r13.getTabRivals();
        Intrinsics.checkNotNull(r9);
        Map r10 = r9.getGroupRivals();
        Intrinsics.checkNotNull(r10);
        Object r12 = r10.get(Long.valueOf(r4.ordinal()));
        Intrinsics.checkNotNull(r12);
        String r16 = ((IGroupRivals) r12).getImprId();
        s2 r17 = r13.getTabRivals();
        Intrinsics.checkNotNull(r17);
        Map r18 = r17.getGroupRivals();
        Intrinsics.checkNotNull(r18);
        Object r19 = r18.get(Long.valueOf(r4.ordinal()));
        Intrinsics.checkNotNull(r19);
        if (TextUtils.isEmpty(((IGroupRivals) r19).getGroupName()) == false) goto L11;
        String r20 = s1.B(2131917806);
    L12:
        if (r8 == null) goto L20;
        if (r8.size() <= 0) goto L16;
        q21.f.a r22 = new q21.f.a();
        r22.a = r20;
        r0.add(r22);
    L16:
        Iterator r23 = r8.iterator();
        int r24 = 0;
    L18:
        if (r23.hasNext() == false) goto L20;
        r0.add(ea0((m2) r23.next(), 9, r16, r24));
        r24 = r24 + 1;
        goto L18
    L11:
        s2 r25 = r13.getTabRivals();
        Intrinsics.checkNotNull(r25);
        Map r26 = r25.getGroupRivals();
        Intrinsics.checkNotNull(r26);
        Object r27 = r26.get(Long.valueOf(r4.ordinal()));
        Intrinsics.checkNotNull(r27);
        r20 = ((IGroupRivals) r27).getGroupName();
    L20:
        q21.f.a r28 = null;
        if (r13.getTabRivals() == null) goto L34;
        s2 r29 = r13.getTabRivals();
        Intrinsics.checkNotNull(r29);
        if (r29.getGroupRivals() == null) goto L34;
        s2 r30 = r13.getTabRivals();
        Intrinsics.checkNotNull(r30);
        Map r32 = r30.getGroupRivals();
        Intrinsics.checkNotNull(r32);
        IGroupRivals.GroupType r33 = IGroupRivals.GroupType.GroupFeedFollowed;
        if (r32.get(Long.valueOf(r33.ordinal())) == null) goto L34;
        s2 r34 = r13.getTabRivals();
        Intrinsics.checkNotNull(r34);
        Map r35 = r34.getGroupRivals();
        Intrinsics.checkNotNull(r35);
        Object r36 = r35.get(Long.valueOf(r33.ordinal()));
        Intrinsics.checkNotNull(r36);
        List r37 = ((IGroupRivals) r36).getSortRivals();
        s2 r38 = r13.getTabRivals();
        Intrinsics.checkNotNull(r38);
        Map r39 = r38.getGroupRivals();
        Intrinsics.checkNotNull(r39);
        Object r40 = r39.get(Long.valueOf(r33.ordinal()));
        Intrinsics.checkNotNull(r40);
        String r42 = ((IGroupRivals) r40).getImprId();
        s2 r43 = r13.getTabRivals();
        Intrinsics.checkNotNull(r43);
        Map r44 = r43.getGroupRivals();
        Intrinsics.checkNotNull(r44);
        Object r45 = r44.get(Long.valueOf(r33.ordinal()));
        Intrinsics.checkNotNull(r45);
        if (TextUtils.isEmpty(((IGroupRivals) r45).getGroupName()) == true) goto L29;
        s2 r46 = r13.getTabRivals();
        Intrinsics.checkNotNull(r46);
        Map r47 = r46.getGroupRivals();
        Intrinsics.checkNotNull(r47);
        Object r48 = r47.get(Long.valueOf(r33.ordinal()));
        Intrinsics.checkNotNull(r48);
        String r49 = ((IGroupRivals) r48).getGroupName();
    L35:
        if (r37 != null) goto L37;
    L70:
        IGroupRivals.GroupType r110 = IGroupRivals.GroupType.GroupFeedRecommend;
        if (ha0(r13, r110.ordinal()) == true) goto L73;
    L139:
        NestedScrollingParent2 r111 = this.g;
        Intrinsics.checkNotNull(r111);
        r111.setVisibility(0);
        View r112 = this.m;
        Intrinsics.checkNotNull(r112);
        r112.setVisibility(8);
        PkInviteUserListRefreshLayout r113 = this.i;
        Intrinsics.checkNotNull(r113);
        r113.setVisibility(0);
        return r0;
    L73:
        if (this.R == false) goto L110;
        if (ha0(r13, r110.ordinal()) == false) goto L81;
        s2 r114 = r13.getTabRivals();
        Intrinsics.checkNotNull(r114);
        Map r115 = r114.getGroupRivals();
        Intrinsics.checkNotNull(r115);
        IGroupRivals r116 = (IGroupRivals) r115.get(Long.valueOf(r110.ordinal()));
        if (r116 == null) goto L79;
        List r117 = r116.getRivals();
    L80:
        s2 r118 = r13.getTabRivals();
        Intrinsics.checkNotNull(r118);
        String r119 = r118.getSubRecommendTitle();
    L82:
        if (r117 != null) goto L84;
    L86:
        CharSequence r120 = this.L0;
        ArrayList r121 = new ArrayList();
        ArrayList r50 = new ArrayList();
        ArrayList r52 = new ArrayList();
        List r53 = r13.getSubTabs();
        if (r53 == null) goto L102;
        Iterator r54 = r53.iterator();
    L90:
        if (r54.hasNext() == false) goto L102;
        y7 r55 = (y7) r54.next();
        IPkSubTabKey r56 = r55.getKey();
        if (r56 == null) goto L90;
        int r57 = r56.getGroupRivalsType();
        if (r57 == IGroupRivals.GroupType.GroupFeedFollowed.ordinal()) goto L90;
        int r58 = r56.getInviteType();
        String r59 = r55.getName();
        List<Object> r122 = fa0(r13, r57, r58);
        r121.add(Integer.valueOf(r57));
        Intrinsics.checkNotNull(r59);
        r50.add(r59);
        Intrinsics.checkNotNull(r122);
        r52.add(r122);
        if (TextUtils.isEmpty(r120) == true) goto L99;
    L101:
        this.H0.add(Integer.valueOf(r58));
        goto L90
    L99:
        if (r55.getSelected() == false) goto L101;
        r120 = r59;
    L102:
        this.L0 = r120;
        ArrayList r123 = new ArrayList();
        int r60 = r52.size();
        int r62 = 0;
    L103:
        if (r62 >= r60) goto L105;
        r123.add(new q21.d.b(((Number) ListProtector.get(r121, r62)).intValue(), (List) ListProtector.get(r52, r62)));
        r62 = r62 + 1;
        goto L103
    L105:
        int r124 = CollectionsKt.indexOf(r50, r120);
        if (r124 >= 0) goto L108;
        r124 = 0;
    L108:
        MutableLiveData r125 = new MutableLiveData(Integer.valueOf(r124));
        q21.e.a r126 = new q21.e.a(r50, r125);
        q21.d.a r63 = new q21.d.a(r123, r125);
        r125.observe(this, new v(this, r50));
        Intrinsics.checkNotNull(r28);
        r0.add(r28);
        r0.add(r126);
        r0.add(r63);
        goto L139
    L84:
        if (r117.size() <= 0) goto L86;
        r28 = new q21.f.a();
        r28.a = r119;
        goto L86
    L79:
        r117 = null;
        goto L80
    L81:
        r117 = null;
        r119 = null;
        goto L82
    L110:
        if (ha0(r13, r110.ordinal()) == false) goto L131;
        s2 r127 = r13.getTabRivals();
        Intrinsics.checkNotNull(r127);
        Map r128 = r127.getGroupRivals();
        Intrinsics.checkNotNull(r128);
        IGroupRivals r129 = (IGroupRivals) r128.get(Long.valueOf(r110.ordinal()));
        if (r129 == null) goto L114;
        List r130 = r129.getRivals();
    L115:
        s2 r64 = r13.getTabRivals();
        Intrinsics.checkNotNull(r64);
        Map r65 = r64.getGroupRivals();
        Intrinsics.checkNotNull(r65);
        IGroupRivals r66 = (IGroupRivals) r65.get(Long.valueOf(r110.ordinal()));
        if (r66 == null) goto L118;
        String r67 = r66.getGroupName();
    L120:
        if (TextUtils.isEmpty(r67) == false) goto L127;
        if (r37 != null) goto L123;
    L126:
        String r68 = s1.B(2131917923);
    L132:
        if (r130 != null) goto L134;
    L136:
        if (r28 == null) goto L138;
        r0.add(r28);
    L138:
        r0.addAll(fa0(r13, r110.ordinal(), 2));
        goto L139
    L134:
        if (r130.size() <= 0) goto L136;
        r28 = new q21.f.a();
        r28.a = r68;
        goto L136
    L123:
        if (r37.size() == 0) goto L126;
        r68 = s1.B(2131917922);
        goto L132
    L127:
        s2 r69 = r13.getTabRivals();
        Intrinsics.checkNotNull(r69);
        Map r70 = r69.getGroupRivals();
        Intrinsics.checkNotNull(r70);
        IGroupRivals r72 = (IGroupRivals) r70.get(Long.valueOf(r110.ordinal()));
        if (r72 == null) goto L130;
        r68 = r72.getGroupName();
        goto L132
    L130:
        r68 = null;
        goto L132
    L118:
        r67 = null;
        goto L120
    L114:
        r130 = null;
        goto L115
    L131:
        r130 = null;
        r68 = null;
        goto L132
    L37:
        if (r37.size() <= 0) goto L39;
        q21.f.a r73 = new q21.f.a();
        r73.a = r49;
        r0.add(r73);
        boolean r74 = true;
    L41:
        if (ga0() == false) goto L52;
        s2 r75 = r13.getTabRivals();
        Intrinsics.checkNotNull(r75);
        Map r76 = r75.getGroupRivals();
        Intrinsics.checkNotNull(r76);
        IGroupRivals.GroupType r77 = IGroupRivals.GroupType.GroupFeedFollowed;
        Object r78 = r76.get(Long.valueOf(r77.ordinal()));
        Intrinsics.checkNotNull(r78);
        if (((IGroupRivals) r78).getGroupInfo() == null) goto L52;
        if (r37.size() <= 0) goto L52;
        s2 r79 = r13.getTabRivals();
        Intrinsics.checkNotNull(r79);
        Map r80 = r79.getGroupRivals();
        Intrinsics.checkNotNull(r80);
        Object r82 = r80.get(Long.valueOf(r77.ordinal()));
        Intrinsics.checkNotNull(r82);
        a5 r83 = ((IGroupRivals) r82).getGroupInfo();
        ur2.a r84 = com.bytedance.android.live.revenue.core.util.e.a(ur2.a.class);
        Intrinsics.checkNotNull(r83);
        CharSequence r85 = r84.Q9(r83);
        if (r85 != null) goto L49;
        r85 = "";
    L49:
        if (r74 == false) goto L51;
        ListProtector.remove(r0, r0.size() - 1);
    L51:
        q21.f.a r86 = new q21.f.a();
        r86.b = r85;
        r0.add(r86);
    L52:
        String r87 = s1.B(2131914762);
        if (ga0() == false) goto L55;
        r87 = "更多好友";
    L55:
        Iterator r88 = r37.iterator();
        int r89 = 0;
    L57:
        if (r88.hasNext() == false) goto L68;
        m2 r90 = (m2) r88.next();
        int r131 = this.B;
        if (r89 == r131) goto L61;
    L63:
        int r132 = 105;
        if (r90.getServerInviteType() == 105) goto L67;
        r132 = 1;
    L67:
        q21.g.a r92 = ea0(r90, r132, r42, r89);
        r92.j = r37.size();
        r0.add(r92);
        r89 = r89 + 1;
        goto L57
    L61:
        if (r131 >= r37.size()) goto L63;
        q21.a.C0297a r93 = new q21.a.C0297a();
        r93.a = r87;
        r93.c = r15;
        r0.add(r93);
    L68:
        if (r14 == false) goto L70;
        q21.a.C0297a r133 = new q21.a.C0297a();
        r133.a = s1.B(2131920052);
        r133.b = true;
        r0.add(r133);
        goto L70
    L39:
        r74 = false;
        goto L41
    L29:
        if (this.A != 3) goto L31;
        int r94 = 2131922352;
    L32:
        r49 = s1.B(r94);
        goto L35
    L31:
        r94 = 2131914804;
    L34:
        r37 = null;
        r49 = null;
        r42 = null;
        goto L35
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131566033, r8, false);
        PkItemExposeRecyclerViewOpt r12 = (PkItemExposeRecyclerViewOpt) r10.findViewById(2131384076);
        this.g = r12;
        if (r12 == null) goto L5;
        r12.setInviteIconPanelType("anchor");
    L5:
        this.h = (TextView) r10.findViewById(2131383050);
        IBaseUser r13 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r13 == null) goto L8;
        int r14 = r13.getSecret();
    L9:
        int r1 = 1;
        if (r14 != 1) goto L15;
        TextView r15 = this.h;
        Intrinsics.checkNotNull(r15);
        r15.setVisibility(0);
        String r16 = f51.a.e.a();
        Context r2 = getContext();
        if (TextUtils.isEmpty(r16) == true) goto L16;
        if (r2 == null) goto L16;
        TextView r3 = this.h;
        Intrinsics.checkNotNull(r3);
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        r3.setText(String.format(r16, Arrays.copyOf(new Object[]{r2.getResources().getString(2131918107)}, 1)));
    L16:
        PkInviteUserListRefreshLayout r17 = r10.findViewById(2131392080);
        this.i = r17;
        if (r17 == null) goto L19;
        r17.setRecyclerView(this.g);
    L19:
        PkInviteUserListRefreshLayout r18 = this.i;
        if (r18 == null) goto L22;
        r18.setFirstView(r10.findViewById(2131363087));
    L22:
        this.j = (PkTopTipView) r10.findViewById(2131389231);
        this.q = (FrameLayout) r10.findViewById(2131389115);
        KmpEnv r19 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L25;
        this.k = r10.findViewById(2131392078);
        this.l = r10.findViewById(2131382879);
    L26:
        View r20 = this.k;
        if (r20 == null) goto L29;
        r20.setVisibility(4);
    L29:
        View r22 = this.l;
        if (r22 == null) goto L32;
        r22.setVisibility(0);
    L32:
        this.m = r10.findViewById(2131390556);
        this.Y = (FrameLayout) r10.findViewById(2131378001);
        FrameLayout r23 = (FrameLayout) r10.findViewById(2131388059);
        this.Z = r23;
        PkItemExposeRecyclerViewOpt r5 = this.g;
        if (r5 == null) goto L35;
        r5.setTabTitlePlace(r23);
    L35:
        View r24 = r10.findViewById(2131385355);
        this.n = r24;
        if (r24 == null) goto L38;
        r24.setVisibility(8);
    L38:
        View r25 = this.n;
        if (r25 == null) goto L41;
        r25.setOnClickListener(new d(this));
    L41:
        this.p = (TextView) r10.findViewById(2131391355);
        this.s = (ImageView) r10.findViewById(2131376580);
        TextView r26 = (TextView) r10.findViewById(2131392041);
        if (this.A != 3) goto L44;
        int r27 = 2131919452;
    L45:
        r26.setText(getText(r27));
        this.z = Boolean.TRUE;
        PkInviteUserListRefreshLayout r28 = this.i;
        if (r28 == null) goto L48;
        r28.setOnRefreshListener(new e(this));
    L48:
        PkItemExposeRecyclerViewOpt r29 = this.g;
        if (r29 == null) goto L51;
        r29.setLayoutManager(new LinearLayoutManager(getContext()));
    L51:
        MultiTypeAdapter r30 = new MultiTypeAdapter();
        this.F = r30;
        Intrinsics.checkNotNull(r30);
        r30.z2(q21.f.a.class, new q21.f());
        MultiTypeAdapter r32 = this.F;
        Intrinsics.checkNotNull(r32);
        r32.z2(q21.b.a.class, new q21.b());
        MultiTypeAdapter r33 = this.F;
        Intrinsics.checkNotNull(r33);
        r33.z2(q21.c.a.class, new q21.c());
        MultiTypeAdapter r34 = this.F;
        Intrinsics.checkNotNull(r34);
        r34.z2(q21.a.C0297a.class, new q21.a(this));
        MultiTypeAdapter r35 = this.F;
        Intrinsics.checkNotNull(r35);
        if (this.R == false) goto L54;
        r1 = 2;
    L54:
        r35.z2(q21.g.a.class, new q21.g(r1, this));
        MultiTypeAdapter r36 = this.F;
        Intrinsics.checkNotNull(r36);
        r36.z2(q21.e.a.class, new q21.e());
        MultiTypeAdapter r37 = this.F;
        Intrinsics.checkNotNull(r37);
        FragmentManager r6 = getChildFragmentManager();
        ArrayList<TabFragment> r38 = this.G;
        MultiTypeAdapter r39 = this.F;
        Intrinsics.checkNotNull(r39);
        r37.z2(q21.d.a.class, new q21.d(r6, r38, r39.b));
        PkInviteUserListRefreshLayout r40 = this.i;
        if (r40 == null) goto L57;
        r40.setmIsDisable(false);
    L57:
        PkItemExposeRecyclerViewOpt r42 = this.g;
        if (r42 == null) goto L60;
        r42.setAdapter(this.F);
    L60:
        PkItemExposeRecyclerViewOpt r43 = this.g;
        if (r43 == null) goto L63;
        r43.addOnScrollListener(new AnonymousClass3(this));
    L63:
        return r10;
    L44:
        r27 = 2131919451;
        goto L45
    L25:
        this.k = r10.findViewById(2131392079);
        this.l = r10.findViewById(2131382880);
        goto L26
    L15:
        TextView r44 = this.h;
        Intrinsics.checkNotNull(r44);
        r44.setVisibility(8);
        goto L16
    L8:
        r14 = 0;
        goto L9
    }

    public final q21.g.a ea0(m2 r3, int r4, String r5, int r6) {
        q21.g.a r0 = new q21.g.a();
        r0.a = r3.getRoom();
        r0.e = r3;
        r0.c = r4;
        r0.b = r3.getRivalExtraInfo();
        r0.d = r3.getBattleRivalTagList();
        r0.f = r6;
        r0.g = r5;
        r0.i = ga0();
        return r0;
    }

    @Override // i21.b
    public final void a10(IRoom r25, int r26, IRivalExtraInfo r27, int r28, String r29) {
        Intrinsics.checkNotNullParameter(r25, "targetRoom");
        Intrinsics.checkNotNullParameter(r27, "rivalExtraInfo");
        Intrinsics.checkNotNullParameter(r29, "imprId");
        if (this.W == false) goto L9;
        if (((Boolean) b51.b.o.getValue(b51.b.c0, b51.b.a[13])).booleanValue() == false) goto L9;
        ToastUtil.a(2131918890, 0);
        return;
    L9:
        if (r25.getLinkMap() != null) goto L11;
        return;
    L11:
        if (r25.getLinkMap().get(String.valueOf(7)) == null) goto L36;
        Object r2 = r25.getLinkMap().get(String.valueOf(7));
        Intrinsics.checkNotNull(r2);
        long r12 = ((Number) r2).longValue();
        if (this.I == null) goto L33;
        this.W = true;
        com.bytedance.android.live.revenuelink.connect.n r3 = this.J;
        Intrinsics.checkNotNull(r3);
        long r16 = this.I.getId();
        long r18 = r25.getId();
        IBaseUser r4 = r25.getOwner();
        if (r4 == null) goto L20;
        Intrinsics.checkNotNullParameter(r4, "$this$secUidExt");
        String r5 = r4.getCastSecUid();
        if (r5 == null) goto L20;
        String r20 = r5;
    L21:
        IBaseUser r6 = r25.getOwner();
        if (r6 == null) goto L27;
        String r7 = r6.getUserId();
        if (r7 == null) goto L27;
        String r22 = r7;
    L28:
        e21.b r8 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r8 == null) goto L31;
        int r9 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        String r23 = w3.a(e21.b.b(r8, com.bytedance.android.live.revlink.impl.pk.utils.l.d.c, "connection", r29, String.valueOf(r28 + 1), null, null, 112));
    L32:
        r3.g(new d11.b(7, r16, r18, r26, r20, r22, r12, r25, r28, r23), null);
        goto L33
    L31:
        r23 = "";
    L27:
        r22 = "";
    L20:
        r20 = "";
    L33:
        this.S = r27;
        return;
    }

    @Override // i21.b
    public final void lz(IRoom r52, int r53, IRivalExtraInfo r54, int r55, String r56) {
        Intrinsics.checkNotNullParameter(r52, "targetRoom");
        Intrinsics.checkNotNullParameter(r54, "rivalExtraInfo");
        Intrinsics.checkNotNullParameter(r56, "imprId");
        if (this.I == null) goto L76;
        int r0 = com.bytedance.android.live.revlink.impl.pk.utils.l.b;
        com.bytedance.android.live.revlink.impl.pk.utils.l.d r3 = com.bytedance.android.live.revlink.impl.pk.utils.l.d.c;
        e21.b r2 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r2 == null) goto L7;
        v3 r1 = e21.b.b(r2, r3, "connection", r56, String.valueOf(r55 + 1), null, null, 112);
    L8:
        long r4 = this.I.getId();
        long r6 = r52.getId();
        IBaseUser r5 = r52.getOwner();
        if (r5 == null) goto L11;
        String r10 = r5.getIdString();
    L12:
        IBaseUser r7 = r52.getOwner();
        if (r7 == null) goto L15;
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        String r16 = r7.getCastSecUid();
    L16:
        BizType r37 = BizType.AnchorLink;
        int r17 = r37.ordinal();
        if (this.A != 3) goto L19;
        long r28 = 1;
    L20:
        long r42 = this.X.a();
        if (r1 == null) goto L23;
        String r8 = w3.a(r1);
    L24:
        Intrinsics.checkNotNullParameter(r52, "targetRoom");
        Intrinsics.checkNotNullParameter("", "activityName");
        Intrinsics.checkNotNullParameter(r8, "clientAttachedInfo");
        d11.d r36 = new d11.d(7, r4, r6, r53, 0, r10, r16, r52, r17, "", 0, "", r28, 0, null, 0, null, "", null, null, 0, r55, r42, null, r8, null, null, null, 513540096);
        if (this.I.getStreamType() != LiveMode.SCREEN_RECORD) goto L69;
        long r9 = this.I.getId();
        long r12 = r52.getId();
        IBaseUser r13 = r52.getOwner();
        if (r13 == null) goto L29;
        String r14 = r13.getIdString();
    L30:
        IBaseUser r15 = r52.getOwner();
        if (r15 == null) goto L33;
        Intrinsics.checkNotNullParameter(r15, "$this$secUidExt");
        String r18 = r15.getCastSecUid();
    L34:
        int r19 = r37.ordinal();
        if (this.A != 3) goto L37;
        long r110 = 1;
    L38:
        long r29 = this.X.a();
        if (r1 == null) goto L41;
        String r20 = w3.a(r1);
    L78:
        com.bytedance.android.livesdk.revenue.service.room.c r22 = com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);     // Catch: Exception -> L66
        if (r22 == null) goto L45;
        com.bytedance.android.livesdk.revenue.room.a r23 = r22.getRoomContext();     // Catch: Exception -> L66
    L46:
        if (r23 == null) goto L54;
        com.bytedance.live.datacontext.j r24 = r23.getLiveStream();     // Catch: Exception -> L66
        if (r24 == null) goto L54;
        com.bytedance.android.livesdk.revenue.pushstream.a r25 = (com.bytedance.android.livesdk.revenue.pushstream.a) r24.getValue();     // Catch: Exception -> L66
        if (r25 == null) goto L54;
        uf2.d0 r26 = r25.A();     // Catch: Exception -> L66
        if (r26 == null) goto L54;
        uf2.d0.a r27 = r26.getBuilder();     // Catch: Exception -> L66
    L55:
        if (r27 == null) goto L57;
        int r30 = r27.getVideoWidth();     // Catch: Exception -> L66
    L58:
        if (r27 == null) goto L60;
        int r32 = r27.getVideoHeight();     // Catch: Exception -> L66
    L61:
        if (r27 == null) goto L63;
        int r33 = r27.U();     // Catch: Exception -> L66
    L64:
        d11.m r34 = new d11.m(Integer.valueOf(r33), Integer.valueOf(r30), Integer.valueOf(r32));     // Catch: Exception -> L66
    L68:
        Intrinsics.checkNotNullParameter(r52, "targetRoom");
        Intrinsics.checkNotNullParameter("", "activityName");
        Intrinsics.checkNotNullParameter(r20, "clientAttachedInfo");
        r36 = new d11.d(7, r9, r12, r53, 0, r14, r18, r52, r19, "", 0, "", r110, 0, null, 0, null, "", null, null, 0, r55, r29, null, r20, null, null, r34, 245104640);
        goto L69
    L63:
        r33 = 0;
        goto L64
    L60:
        r32 = 0;
        goto L61
    L57:
        r30 = 0;
    L54:
        r27 = null;
        goto L55
    L45:
        r23 = null;
    L66:
        e = move-exception;
        ALogger.d("AnchorLinkUserListFragment", e.toString());
        r34 = null;
        goto L68
    L41:
        r20 = "";
        goto L78
    L37:
        r110 = 0;
        goto L38
    L33:
        r18 = null;
        goto L34
    L29:
        r14 = null;
    L69:
        d11.d r35 = r36;
        if (r41.f.a == false) goto L74;
        com.bytedance.tools.kcp.spongepreference.runtime.a r38 = l51.a.k0;
        KProperty[] r39 = l51.a.a;
        Map<String, String> r40 = null;
        if (((Boolean) r38.getValue(null, r39[72])).booleanValue() == true) goto L75;
        ToastUtil.a(2131914800, 0);
        r38.setValue(null, r39[72], Boolean.TRUE);
    L75:
        com.bytedance.android.live.revenuelink.connect.n r43 = this.J;
        Intrinsics.checkNotNull(r43);
        r43.d(r35, r40);
        goto L76
    L74:
        r40 = null;
        goto L75
    L23:
        r8 = "";
        goto L24
    L19:
        r28 = 0;
        goto L20
    L15:
        r16 = null;
        goto L16
    L11:
        r10 = null;
        goto L12
    L7:
        r1 = null;
    L76:
        com.bytedance.android.live.revlink.impl.utils.x.b("live_link_last_invite_source", "link_banner");
        this.S = r54;
    }
}
