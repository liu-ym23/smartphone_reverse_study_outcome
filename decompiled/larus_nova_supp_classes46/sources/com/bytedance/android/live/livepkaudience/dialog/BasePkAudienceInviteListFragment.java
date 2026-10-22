package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.live.livepkaudience.list.PkFriendsItemBinder;
import com.bytedance.android.live.livepkaudience.list.PkInviteMoreItemBinder;
import com.bytedance.android.live.livepkaudience.list.PkListTitleItemBinder;
import com.bytedance.android.live.livepkaudience.list.PkRoomInviteAllItemBinder;
import com.bytedance.android.live.livepkaudience.list.PkRoomInviteMoreItemBinder;
import com.bytedance.android.live.livepkaudience.view.PkOnlineFriendsCircleContainer;
import com.bytedance.android.live.livepkaudience.view.PkStickHeaderDecoration;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livehostapi.business.IHostSocial;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.config.oq;
import com.bytedance.android.livesdk.config.yq;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/BasePkAudienceInviteListFragment;", "Lcom/bytedance/android/live/livepkaudience/dialog/BasePkAudienceInviteListContract$View;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePkAudienceInviteListFragment extends BasePkAudienceInviteListContract$View {
    public static final /* synthetic */ int A = 0;
    public RecyclerView g;
    public MultiTypeAdapter h;
    public LinearLayout i;
    public LinearLayout j;
    public final LinkedList<Object> k;
    public Room l;
    public boolean m;
    public final boolean n;
    public View o;
    public TextView p;
    public TextView q;
    public View r;
    public PkOnlineFriendsCircleContainer s;
    public final List<com.bytedance.android.live.livepkaudience.list.e> t;
    public final List<LinkPlayerInfo> u;
    public final List<com.bytedance.android.live.livepkaudience.list.g> v;
    public int w;
    public boolean x;
    public BannerWidget y;
    public final Function1<String, Boolean> z;

    public static final class a {
    }

    public static final class b implements BannerWidget.a {
        public final /* synthetic */ BasePkAudienceInviteListFragment a;

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final void b(boolean r1, Map<String, String> r2) {
        }

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final boolean a() {
            return this.a.getUserVisibleHint();
        }

        public b(BasePkAudienceInviteListFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public String T90() {
        return "";
    }

    public abstract com.bytedance.android.live.livepkaudience.base.i ca0();

    public abstract boolean da0();

    public abstract DataCenter fa0();

    public BasePkAudienceInviteListFragment() {
        this.k = new LinkedList();
        this.n = jc1.k.n(IUserService.class).user().c();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.z = new BasePkAudienceInviteListFragment$userListFilterAction$1(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public float S90() {
        return UtilityKotlinExtentionsKt.j(t6.c(s1.getContext()) * 1.2f) - 48;
    }

    public static final boolean ba0(BasePkAudienceInviteListFragment r2) {
        r2.getClass();
        String r0 = jc1.k.n(IUserService.class).user().b().getIdString();
        com.bytedance.android.live.livepkaudience.base.i r3 = r2.ca0();
        if (r3 == null) goto L19;
        CopyOnWriteArrayList<LinkPlayerInfo> r4 = r3.c;
        if (r4 == null) goto L19;
        if (r4.isEmpty() == true) goto L19;
        Iterator<LinkPlayerInfo> r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L19;
        IBaseUser r1 = r5.next().getUser();
        if (r1 == null) goto L15;
        String r6 = r1.getIdString();
    L17:
        if (Intrinsics.areEqual(r6, r0) == false) goto L11;
        return true;
    L15:
        r6 = null;
    L19:
        return false;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View
    public final void V90(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if (getView() != null) goto L5;
        return;
    L5:
        r2.printStackTrace();
        LinearLayout r3 = this.j;
        if (r3 == null) goto L8;
        r3.setVisibility(8);
    L8:
        RecyclerView r4 = this.g;
        if (r4 == null) goto L11;
        r4.setVisibility(8);
    L11:
        LinearLayout r5 = this.i;
        if (r5 == null) goto L15;
        r5.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View
    public final void W90(List<? extends LinkPlayerInfo> r5) {
        Intrinsics.checkNotNullParameter(r5, "linkPlayerInfos");
        if (getView() != null) goto L5;
        return;
    L5:
        String r0 = jc1.k.n(IUserService.class).user().n();
        ArrayList r1 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        Object r2 = r6.next();
        IBaseUser r3 = ((LinkPlayerInfo) r2).getUser();
        if (r3 == null) goto L11;
        String r4 = r3.getIdString();
    L13:
        if ((!Intrinsics.areEqual(r4, r0)) == false) goto L7;
        r1.add(r2);
        goto L7
    L11:
        r4 = null;
        goto L13
    L16:
        if (Lists.isEmpty(r1) == false) goto L18;
        ((com.bytedance.android.live.livepkaudience.dialog.b) this.f).f();
        return;
    L18:
        this.k.clear();
        this.k.addAll(r1);
        MultiTypeAdapter r7 = this.h;
        if (r7 == null) goto L21;
        r7.notifyDataSetChanged();
    L21:
        RecyclerView r8 = this.g;
        if (r8 == null) goto L24;
        r8.setVisibility(0);
    L24:
        LinearLayout r9 = this.j;
        if (r9 == null) goto L27;
        r9.setVisibility(8);
    L27:
        LinearLayout r10 = this.i;
        if (r10 == null) goto L37;
        r10.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View
    public final void X90(bl0.b r6) {
        Intrinsics.checkNotNullParameter(r6, "body");
        LinearLayout r0 = this.j;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        LinearLayout r1 = this.i;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        RecyclerView r2 = this.g;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        Room r3 = this.l;
        if (r3 == null) goto L18;
        User r4 = r3.getOwner();
        if (r4 == null) goto L18;
        if (r4.getSecret() != 1) goto L18;
    L21:
        View r7 = this.r;
        if (r7 == null) goto L24;
        r7.setVisibility(0);
    L24:
        PkOnlineFriendsCircleContainer r8 = this.s;
        if (r8 == null) goto L60;
        r8.setVisibility(8);
        return;
    L60:
        return;
    L18:
        if (this.m == false) goto L20;
    L28:
        List<bl0.a> r5 = r6.user;
        if (r5 != null) goto L31;
    L50:
        TextView r9 = this.q;
        if (r9 == null) goto L53;
        r9.setText(r6.notice);
    L53:
        TextView r10 = this.p;
        if (r10 == null) goto L56;
        r10.setText(s1.B(2131917671));
    L56:
        TextView r11 = this.p;
        if (r11 == null) goto L61;
        r11.setOnClickListener(x0.a(new BasePkAudienceInviteListFragment$onFetchOnlineFriendsSuccess$2(this)));
        return;
    L61:
        return;
    L31:
        if (Lists.isEmpty(r5) == false) goto L38;
        View r12 = this.r;
        if (r12 == null) goto L35;
        r12.setVisibility(0);
    L35:
        TextView r13 = this.p;
        if (r13 == null) goto L50;
        r13.setText(s1.B(2131917667));
        goto L50
    L38:
        View r14 = this.r;
        if (r14 == null) goto L41;
        r14.setVisibility(8);
    L41:
        PkOnlineFriendsCircleContainer r15 = this.s;
        if (r15 == null) goto L44;
        r15.a(r5);
    L44:
        PkOnlineFriendsCircleContainer r16 = this.s;
        if (r16 == null) goto L47;
        r16.setVisibility(0);
    L47:
        TextView r17 = this.p;
        if (r17 == null) goto L50;
        r17.setText(s1.B(2131917671));
        goto L50
    L20:
        if (this.n == false) goto L28;
        goto L21
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View
    public final void Y90(User r11) {
        Intrinsics.checkNotNullParameter(r11, "user");
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        final Room r1 = this.l;
        if (r1 != null) goto L8;
        return;
    L8:
        jc1.k.n(IHostSocial.class).inviteFriendByIM(r0, r11, new BasePkAudienceInviteListFragment$onInviteFriendSuccess$1(this, r1));
        LinkPlayerInfo r2 = null;
        int r3 = -1;
        if ((!((ArrayList) this.v).isEmpty()) == false) goto L27;
        Iterator<T> r4 = this.k.iterator();
        int r5 = 0;
        LinkPlayerInfo r6 = null;
    L12:
        if (r4.hasNext() == false) goto L26;
        Object r7 = r4.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        if ((r7 instanceof com.bytedance.android.live.livepkaudience.list.g) == false) goto L25;
        com.bytedance.android.live.livepkaudience.list.g r9 = (com.bytedance.android.live.livepkaudience.list.g) r7;
        IBaseUser r10 = r9.a.getUser();
        if (r10 == null) goto L21;
        String r12 = r10.getIdString();
    L23:
        if (Intrinsics.areEqual(r12, r11.getIdString()) == false) goto L25;
        r6 = r9.a;
        r3 = r5;
        goto L25
    L21:
        r12 = null;
    L25:
        r5 = r8;
        goto L12
    L26:
        r2 = r6;
    L27:
        if (r2 != null) goto L29;
    L34:
        MultiTypeAdapter r13 = this.h;
        if (r13 == null) goto L42;
        r13.notifyItemChanged(r3);
        return;
    L42:
        return;
    L29:
        if (r2.isActive == true) goto L31;
    L33:
        r2.lastInvitedTimeMillis = p6.b();
        goto L34
    L31:
        if (r2.listUserType != 2) goto L33;
        r2.isInviting = true;
        goto L33
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View
    public final void Z90(List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r5) {
        Intrinsics.checkNotNullParameter(r5, "invitedList");
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        final Room r1 = this.l;
        if (r1 != null) goto L8;
        return;
    L8:
        jc1.k.n(IHostSocial.class).inviteFriendsByIM(r0, r5, new BasePkAudienceInviteListFragment$onInviteFriendsSuccess$1(this, r1));
        Set r6 = SequencesKt.toSet(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence(r5), BasePkAudienceInviteListFragment$onInviteFriendsSuccess$invitedIds$1.INSTANCE), BasePkAudienceInviteListFragment$onInviteFriendsSuccess$invitedIds$2.INSTANCE));
        Sequence r2 = SequencesKt.filter(CollectionsKt.asSequence(this.k), BasePkAudienceInviteListFragment$onInviteFriendsSuccess$$inlined$filterIsInstance$1.INSTANCE);
        if (r2 == null) goto L25;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L20;
        com.bytedance.android.live.livepkaudience.list.g r4 = (com.bytedance.android.live.livepkaudience.list.g) r3.next();
        IBaseUser r7 = r4.a.getUser();
        if (r7 == null) goto L16;
        String r8 = r7.getIdString();
    L18:
        if (r6.contains(String.valueOf(r8)) == false) goto L12;
        LinkPlayerInfo r9 = r4.a;
        r9.lastInvitedTimeMillis = p6.b();
        goto L12
    L16:
        r8 = null;
        goto L18
    L20:
        MultiTypeAdapter r10 = this.h;
        if (r10 == null) goto L31;
        r10.notifyDataSetChanged();
        return;
    L31:
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListContract$View
    public final void aa0(a1 r7) {
        Intrinsics.checkNotNullParameter(r7, "data");
        if (getView() != null) goto L5;
        return;
    L5:
        List<ILinkPlayerInfoBridge> r0 = r7.getPlayerInfo();
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L25;
        LinearLayout r8 = this.j;
        if (r8 == null) goto L17;
        r8.setVisibility(0);
    L17:
        LinearLayout r9 = this.i;
        if (r9 == null) goto L20;
        r9.setVisibility(8);
    L20:
        RecyclerView r10 = this.g;
        if (r10 == null) goto L96;
        r10.setVisibility(8);
        return;
    L96:
        return;
    L25:
        if (((((ArrayList) this.u).size() + ((ArrayList) this.v).size()) + ((ArrayList) this.t).size()) != jm2.a.a(r7.getPlayerInfo()).size()) goto L27;
        boolean r2 = true;
    L28:
        if (r2 == false) goto L30;
        return;
    L30:
        LinearLayout r3 = this.j;
        if (r3 == null) goto L33;
        r3.setVisibility(8);
    L33:
        LinearLayout r4 = this.i;
        if (r4 == null) goto L36;
        r4.setVisibility(8);
    L36:
        RecyclerView r5 = this.g;
        if (r5 == null) goto L39;
        r5.setVisibility(0);
    L39:
        ((ArrayList) this.t).clear();
        ((ArrayList) this.u).clear();
        ((ArrayList) this.v).clear();
        this.w = 0;
        List<ILinkPlayerInfoBridge> r11 = r7.getPlayerInfo();
        if (r11 != null) goto L42;
        r11 = CollectionsKt.emptyList();
    L42:
        Iterator<T> r12 = r11.iterator();
    L44:
        if (r12.hasNext() == false) goto L55;
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r12.next();
        int r13 = r6.getListUserType();
        if (r13 == 1) goto L47;
        if (r13 != 2) goto L44;
        LinkPlayerInfo r14 = (LinkPlayerInfo) jm2.a.e(r6);
        if (r14 == null) goto L44;
        ((ArrayList) this.v).add(new com.bytedance.android.live.livepkaudience.list.g(r14));
        goto L44
    L47:
        LinkPlayerInfo r15 = (LinkPlayerInfo) jm2.a.e(r6);
        if (r15 == null) goto L44;
        ((ArrayList) this.u).add(r15);
        goto L44
    L55:
        LinkedList<Object> r16 = this.k;
        r16.clear();
        r16.add(com.bytedance.android.live.livepkaudience.list.j.a);
        this.w++;
        if ((!((ArrayList) this.u).isEmpty()) == false) goto L64;
        if (((ArrayList) this.u).size() <= 3) goto L62;
        r16.addAll(((ArrayList) this.u).subList(0, 3));
        this.w += 3;
        r16.add(com.bytedance.android.live.livepkaudience.list.o.a);
        if (this.m == false) goto L64;
        int r17 = al0.d.a;
        al0.d.e(da0());
        goto L64
    L62:
        r16.addAll(this.u);
        this.w += ((ArrayList) this.u).size();
    L64:
        if ((!((ArrayList) this.v).isEmpty()) == false) goto L66;
        r16.addAll(this.v);
    L66:
        MultiTypeAdapter r18 = this.h;
        if (r18 == null) goto L69;
        r18.notifyDataSetChanged();
    L69:
        int r19 = al0.d.a;
        boolean r20 = da0();
        DataCenter r21 = fa0();
        if (r21 == null) goto L72;
        String r22 = (String) r21.get("data_task_name_when_open_invite_panel", "");
    L74:
        if (al0.d.b() == true) goto L97;
        HashMap r23 = new HashMap();
        el0.j.j(r23, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        el0.j.n(r23, Integer.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        if (r20 == false) goto L78;
        String r24 = "voice_live";
    L79:
        r23.put("live_type", r24);
        r23.put("enter_from", "live_detail");
        r23.put("user_type", "link_user");
        if (TextUtils.isEmpty(r22) == true) goto L82;
        r23.put("is_task", "1");
        Intrinsics.checkNotNull(r22);
        r23.put("activity_name", r22);
    L82:
        al0.d.g("livesdk_anchor_connection_invite_show", r23, new Object[0]);
        return;
    L78:
        r24 = "video_live";
        goto L79
    L97:
        return;
    L72:
        r22 = null;
        goto L74
    L27:
        r2 = false;
        goto L28
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L13
    }

    public final void ea0(boolean r4) {
        boolean r0 = this.m;
        boolean r2 = false;
        if (tb1.c.a == true) goto L5;
        boolean r1 = false;
    L8:
        if (r1 == false) goto L15;
        com.bytedance.android.live.livepkaudience.dialog.b r3 = (com.bytedance.android.live.livepkaudience.dialog.b) this.f;
        if (this.m == false) goto L12;
    L13:
        r2 = true;
    L14:
        r3.d(r2, r4);
        return;
    L12:
        if (dl0.n.c() == false) goto L14;
    L15:
        ((com.bytedance.android.live.livepkaudience.dialog.b) this.f).e(false);
        return;
    L5:
        if (r0 == false) goto L7;
        r1 = ((Boolean) oq.a.getValue()).booleanValue();
        goto L8
    L7:
        r1 = ((Boolean) yq.a.getValue()).booleanValue();
        goto L8
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        Room r3 = jc1.k.n(IRoomService.class).getCurrentRoom();
        this.l = r3;
        if (r3 == null) goto L7;
        User r4 = r3.getOwner();
        if (r4 == null) goto L7;
        String r5 = r4.getIdStr();
    L8:
        this.m = Intrinsics.areEqual(r5, jc1.k.n(IUserService.class).user().b().getIdString());
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Deprecated(message = "Deprecated in Java")
    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        RecyclerView r0 = this.g;
        if (r0 == null) goto L5;
        r0.setNestedScrollingEnabled(r2);
    L5:
        RecyclerView r1 = this.g;
        if (r1 == null) goto L8;
        r1.requestLayout();
    L8:
        if (r2 == false) goto L13;
        BannerWidget r3 = this.y;
        if (r3 == null) goto L14;
        r3.wq();
        return;
    L14:
        return;
    }

    public void onViewCreated(final View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        this.g = r8.findViewById(2131384731);
        this.i = (LinearLayout) r8.findViewById(2131371744);
        this.j = (LinearLayout) r8.findViewById(2131371557);
        this.h = new MultiTypeAdapter();
        RecyclerView r10 = this.g;
        if (r10 == null) goto L9;
        r10.setLayoutManager(new LinearLayoutManager(r10.getContext()));
        r10.setAdapter(this.h);
        if (this.m == false) goto L7;
    L8:
        r10.addItemDecoration(new PkStickHeaderDecoration());
        goto L9
    L7:
        if (this.n == true) goto L8;
    L9:
        MultiTypeAdapter r11 = this.h;
        if (r11 == null) goto L12;
        r11.a = this.k;
        r11.z2(com.bytedance.android.live.livepkaudience.list.j.class, new PkInviteMoreItemBinder(da0(), new BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1(this, r8)));
        r11.z2(com.bytedance.android.live.livepkaudience.list.k.class, new PkListTitleItemBinder());
        r11.z2(com.bytedance.android.live.livepkaudience.list.g.class, new PkFriendsItemBinder(da0(), new BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$2(this, r8)));
        r11.z2(com.bytedance.android.live.livepkaudience.list.o.class, new PkRoomInviteMoreItemBinder(new BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$3(this, r8)));
        r11.z2(com.bytedance.android.live.livepkaudience.list.n.class, new PkRoomInviteAllItemBinder(new BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$4(this, r8)));
    L12:
        r8.findViewById(2131384133).setOnClickListener(x0.a(new AnonymousClass3(this)));
        this.o = r8.findViewById(2131392077);
        TextView r12 = (TextView) r8.findViewById(2131375618);
        if (this.m == false) goto L15;
    L17:
        r12.setText(s1.B(2131917667));
        r12.setBackground(ContextCompat.getDrawable(r12.getContext(), 2131249992));
        Unit r0 = Unit.INSTANCE;
        this.p = r12;
        TextView r13 = (TextView) r8.findViewById(2131390740);
        if (HostEnv.b() == false) goto L20;
        String r1 = s1.B(2131918025);
    L21:
        r13.setText(r1);
        this.q = r13;
        this.r = r8.findViewById(2131371586);
        this.s = (PkOnlineFriendsCircleContainer) r8.findViewById(2131373315);
        if (this.x == false) goto L25;
        this.y = new BannerWidget(jc1.k.n(IRoomService.class).getCurrentRoom(), 22, "invite_connection_panel", null, new b(this));
        WidgetManager.of(this, r8).load(2131372686, this.y);
        return;
    L25:
        return;
    L20:
        r1 = s1.B(2131917672);
        goto L21
    L15:
        if (this.n == false) goto L17;
        r12.setVisibility(8);
        goto L17
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565510, r3, false);
    }
}
