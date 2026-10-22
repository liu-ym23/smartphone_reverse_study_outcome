package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import am2.x;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceApplyContract$View;
import com.bytedance.android.live.liveinteract.plantform.core.l0;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/InteractAudienceApplyFragment;", "Lcom/bytedance/android/live/liveinteract/interact/audience/contract/InteractAudienceApplyContract$View;", "Lcom/bytedance/android/live/liveinteract/linkpanel/list/o;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceApplyFragment extends InteractAudienceApplyContract$View implements com.bytedance.android.live.liveinteract.linkpanel.list.o {
    public static final /* synthetic */ int m = 0;
    public Map<Integer, View> g;
    public IRoom h;
    public boolean i;
    public final d j;
    public MultiTypeAdapter k;
    public l0 l;

    public static final class a {
    }

    public static final class b extends l0 {
        public final /* synthetic */ InteractAudienceApplyFragment a;
        public final /* synthetic */ ILinkPlayerInfoBridge b;

        @Override // com.bytedance.android.live.liveinteract.plantform.core.l0, uf0.a
        public final void onPermitSuccess(String r2) {
            this.b.setHasApplied(true);
            InteractAudienceApplyFragment r3 = this.a;
            IBaseUser r0 = this.b.getUser();
            Intrinsics.checkNotNull(r0);
            r3.da0(r0.getIdString());
        }

        public b(InteractAudienceApplyFragment r1, ILinkPlayerInfoBridge r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.l0, uf0.a
        public final void l(String r1, Throwable r2) {
            this.b.setHasApplied(false);
        }
    }

    public static final class c extends l0 {
        public final /* synthetic */ InteractAudienceApplyFragment a;
        public final /* synthetic */ ILinkPlayerInfoBridge b;

        @Override // com.bytedance.android.live.liveinteract.plantform.core.l0, uf0.a
        public final void onPermitSuccess(String r2) {
            this.b.setHasApplied(true);
            InteractAudienceApplyFragment r3 = this.a;
            IBaseUser r0 = this.b.getUser();
            Intrinsics.checkNotNull(r0);
            r3.da0(r0.getIdString());
        }

        public c(InteractAudienceApplyFragment r1, ILinkPlayerInfoBridge r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.l0, uf0.a
        public final void l(String r1, Throwable r2) {
            this.b.setHasApplied(false);
        }
    }

    public static final class d extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
        public final /* synthetic */ InteractAudienceApplyFragment a;

        public d(InteractAudienceApplyFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void n(List<ILinkPlayerInfoBridge> r1, long r2, n0 r4) {
            Intrinsics.checkNotNullParameter(r1, "list");
            this.a.ba0(r1);
        }
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.list.o
    public final void Ys(ILinkPlayerInfoBridge r2) {
        Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
    }

    static {
    }

    public final void ca0() {
        JSONObject r0 = new JSONObject();
        if (this.i == false) goto L11;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r1 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r1 == null) goto L18;
        y r2 = r1.getLinkUserCenter();
        if (r2 == null) goto L18;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r3 = r2.f;
        if (r3 == null) goto L18;
        int r4 = r3.size();
    L19:
        r0.put("applicant", String.valueOf(r4));
        int r5 = jf0.b.a;
        jf0.b.i("apply", this.i, r0);
        return;
    L18:
        r4 = 0;
        goto L19
    L11:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r6 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r6 == null) goto L18;
        y r7 = r6.getLinkUserCenter();
        if (r7 == null) goto L18;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r8 = r7.f;
        if (r8 == null) goto L18;
        r4 = r8.size();
        goto L19
    }

    public InteractAudienceApplyFragment() {
        this.g = new LinkedHashMap();
        this.j = new d(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return UtilityKotlinExtentionsKt.j(t6.c(s1.getContext()) * 1.2f) - 48;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return s1.B(2131917523);
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceApplyContract$View
    public final void aa0() {
        View r0 = getView();
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(2131373955);
    L6:
        LinearLayout r3 = (LinearLayout) r2;
        if (r3 == null) goto L9;
        r3.setVisibility(0);
    L9:
        View r4 = getView();
        if (r4 == null) goto L12;
        r1 = r4.findViewById(2131373971);
    L12:
        LinearLayout r5 = (LinearLayout) r1;
        if (r5 == null) goto L16;
        r5.setVisibility(8);
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.i == false) goto L16;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r0 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r0 == null) goto L9;
        y r1 = r0.getLinkUserCenter();
        if (r1 == null) goto L9;
        r1.T4(this.j);
    L9:
        l0 r2 = this.l;
        if (r2 == null) goto L29;
        com.bytedance.android.live.liveinteract.plantform.base.d r3 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r3 == null) goto L30;
        com.bytedance.android.live.liveinteract.plantform.core.f r4 = r3.X4();
        if (r4 == null) goto L31;
        r4.g(r2);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L16:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r5 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r5 == null) goto L21;
        y r6 = r5.getLinkUserCenter();
        if (r6 == null) goto L21;
        r6.T4(this.j);
    L21:
        l0 r7 = this.l;
        if (r7 == null) goto L33;
        com.bytedance.android.live.liveinteract.plantform.base.c r8 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r8 == null) goto L34;
        com.bytedance.android.live.liveinteract.plantform.core.e r9 = r8.A0();
        if (r9 == null) goto L35;
        r9.g(r7);
        return;
    L35:
        return;
    L34:
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.g.clear();
    }

    public final void onResume() {
        super.onResume();
        IRoom r0 = this.h;
        if (r0 == null) goto L6;
        ((hf0.a) this.f).d(r0.getId(), r0.getOwnerUserIdString());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceApplyContract$View
    public final void ba0(List<? extends ILinkPlayerInfoBridge> r7) {
        Intrinsics.checkNotNullParameter(r7, "playerInfoList");
        HashMap r0 = new HashMap();
        r0.put("panel_show", "apply");
        if (CollectionUtils.isEmpty(r7) == false) goto L5;
        String r1 = "0";
    L6:
        r0.put("audience_cnt", r1);
        j0.l().sendLog("livesdk_anchor_double_show", r0, new Object[]{x.class, IRoom.class});
        View r5 = null;
        if (Lists.isEmpty(r7) == false) goto L21;
        View r8 = getView();
        if (r8 == null) goto L11;
        View r9 = r8.findViewById(2131373955);
    L12:
        LinearLayout r10 = (LinearLayout) r9;
        if (r10 == null) goto L15;
        r10.setVisibility(0);
    L15:
        View r11 = getView();
        if (r11 == null) goto L18;
        r5 = r11.findViewById(2131373971);
    L18:
        LinearLayout r6 = (LinearLayout) r5;
        if (r6 == null) goto L40;
        r6.setVisibility(8);
        return;
    L40:
        return;
    L11:
        r9 = null;
        goto L12
    L21:
        View r2 = getView();
        if (r2 == null) goto L24;
        View r3 = r2.findViewById(2131373955);
    L25:
        LinearLayout r4 = (LinearLayout) r3;
        if (r4 == null) goto L28;
        r4.setVisibility(8);
    L28:
        View r12 = getView();
        if (r12 == null) goto L31;
        r5 = r12.findViewById(2131373971);
    L31:
        LinearLayout r13 = (LinearLayout) r5;
        if (r13 == null) goto L34;
        r13.setVisibility(0);
    L34:
        MultiTypeAdapter r14 = this.k;
        if (r14 == null) goto L37;
        r14.a = r7;
    L37:
        if (r14 == null) goto L42;
        r14.notifyDataSetChanged();
        return;
    L42:
        return;
    L24:
        r3 = null;
        goto L25
    L5:
        r1 = String.valueOf(r7.size());
        goto L6
    }

    public final void da0(String r8) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        MultiTypeAdapter r0 = this.k;
        if (r0 == null) goto L5;
        List r1 = r0.a;
    L6:
        List r2 = r1;
        int r3 = 0;
        if (r2 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
        return;
    L15:
        int r4 = r2.size();
    L16:
        if (r3 >= r4) goto L27;
        Object r6 = ListProtector.get(r1, r3);
        if ((r6 instanceof ILinkPlayerInfoBridge) == false) goto L26;
        IBaseUser r7 = ((ILinkPlayerInfoBridge) r6).getUser();
        if (r7 == null) goto L22;
        String r9 = r7.getIdString();
    L24:
        if (Intrinsics.areEqual(r9, r8) == false) goto L26;
    L28:
        if (r3 >= 0) goto L30;
        return;
    L30:
        if (r3 >= r1.size()) goto L45;
        Object r10 = ListProtector.get(r1, r3);
        if ((r10 instanceof ILinkPlayerInfoBridge) == false) goto L35;
        ((ILinkPlayerInfoBridge) r10).setHasApplied(true);
    L35:
        MultiTypeAdapter r11 = this.k;
        if (r11 == null) goto L44;
        r11.notifyItemChanged(r3);
        return;
    L44:
        return;
    L45:
        return;
    L22:
        r9 = null;
    L26:
        r3 = r3 + 1;
        goto L16
    L27:
        r3 = -1;
        goto L28
    L9:
        if (r2.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (this.i == false) goto L9;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r3 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r3 == null) goto L15;
        y r4 = r3.getLinkUserCenter();
        if (r4 == null) goto L16;
        r4.Q4(this.j);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r5 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r5 == null) goto L18;
        y r6 = r5.getLinkUserCenter();
        if (r6 == null) goto L19;
        r6.Q4(this.j);
        return;
    L19:
        return;
    }

    public final void setUserVisibleHint(boolean r4) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r4);
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(2131384731);
        if (r0 != null) goto L13;
        View r1 = getView();
        if (r1 == null) goto L12;
        r0 = r1.findViewById(2131384731);
        if (r0 == null) goto L12;
        this.g.put(2131384731, r0);
    L12:
        r0 = null;
    L13:
        RecyclerView r2 = (RecyclerView) r0;
        if (r2 == null) goto L16;
        r2.setNestedScrollingEnabled(r4);
    L16:
        View r5 = getView();
        if (r5 == null) goto L20;
        r5.requestLayout();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.list.o
    public final void hw(ILinkPlayerInfoBridge r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "info");
        if (jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().isMatching() == false) goto L6;
        f2.b(2131917544, 0);
        return;
    L6:
        com.bytedance.android.live.liveinteract.plantform.utils.r.b("accept", GsonProtectorUtils.toJson(GsonHelper.get(), r6));
        HashMap r8 = new HashMap();
        if (r6.getLinkType() != 2) goto L9;
        r8.put("guest_connection_type", "voice");
    L10:
        r8.put("type", "apply");
        if (this.i == false) goto L13;
        String r1 = "anchor";
    L14:
        r8.put("invite_type", r1);
        j0.l().sendLog("livesdk_guest_connection_success_anchor", r8, new Object[]{IRoom.class, com.bytedance.android.live.broadcastgame.api.c.class});
        if (this.i == false) goto L31;
        this.l = new b(this, r6);
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r9 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r9 == null) goto L25;
        com.bytedance.android.live.liveinteract.plantform.core.f r10 = r9.X4();
        if (r10 == null) goto L25;
        l0 r0 = this.l;
        if (r0 == null) goto L24;
        r10.a(r0);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.core.SimpleAnchorLinkListener");
    L25:
        IBaseUser r11 = r6.getUser();
        if (r11 == null) goto L50;
        com.bytedance.android.live.liveinteract.plantform.base.d r12 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r12 == null) goto L51;
        r12.g0(r11);
        return;
    L51:
        return;
    L50:
        return;
    L31:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L45;
        this.l = new c(this, r6);
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r13 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r13 == null) goto L41;
        com.bytedance.android.live.liveinteract.plantform.core.e r14 = r13.A0();
        if (r14 == null) goto L41;
        l0 r2 = this.l;
        if (r2 == null) goto L40;
        r14.a(r2);
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.core.SimpleAnchorLinkListener");
    L41:
        com.bytedance.android.live.liveinteract.plantform.base.c r15 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r15 == null) goto L53;
        r15.permit(r6);
        return;
    L53:
        return;
    L45:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L47;
        f2.b(2131914522, 0);
    L48:
        com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.PERMIT);
        return;
    L47:
        f2.b(2131917298, 0);
        goto L48
    L13:
        r1 = "administrator";
        goto L14
    L9:
        r8.put("guest_connection_type", "video");
        goto L10
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131566050, r4, false);
        MultiTypeAdapter r7 = new MultiTypeAdapter();
        this.k = r7;
        r7.z2(ILinkPlayerInfoBridge.class, new l(this, 0));
        r6.findViewById(2131384731).setLayoutManager(new LinearLayoutManager(getContext()));
        r6.findViewById(2131384731).setAdapter(this.k);
        ((LinearLayout) r6.findViewById(2131373955)).setVisibility(8);
        return r6;
    }
}
