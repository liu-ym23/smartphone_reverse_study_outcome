package com.bytedance.android.live.liveinteract.videotalk.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.common.ui.OnlineFriendsCircleContainer;
import com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout;
import com.bytedance.android.live.liveinteract.plantform.model.b1;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.live.liveinteract.videotalk.adapter.VideoRoomAudiencePreApplyViewHolder;
import com.bytedance.android.live.liveinteract.videotalk.contract.VideoRoomPreApplyContract$View;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import yj0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/fragment/VideoRoomPreApplyFragment;", "Lcom/bytedance/android/live/liveinteract/videotalk/contract/VideoRoomPreApplyContract$View;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoRoomPreApplyFragment extends VideoRoomPreApplyContract$View {
    public static final /* synthetic */ int w = 0;
    public BaseRefreshLayout g;
    public final LinkedList<Object> h;
    public View i;
    public RecyclerView j;
    public LinearLayout k;
    public LinearLayout l;
    public TextView m;
    public TextView n;
    public TextView o;
    public OnlineFriendsCircleContainer p;
    public MultiTypeAdapter q;
    public String r;
    public IRoom s;
    public final Handler t;
    public c1 u;
    public final b v;

    public static final class a {
    }

    public static final class b implements VideoRoomAudiencePreApplyViewHolder.a {
        public final /* synthetic */ VideoRoomPreApplyFragment a;

        public b(VideoRoomPreApplyFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.videotalk.adapter.VideoRoomAudiencePreApplyViewHolder.a
        public final void a(c1 r2) {
            Intrinsics.checkNotNullParameter(r2, "prepareApplyUser");
            VideoRoomPreApplyFragment r0 = this.a;
            r0.u = r2;
            vj0.a r1 = (vj0.a) r0.f;
            if (r1 == null) goto L11;
            IBaseUser r3 = r2.f();
            if (r3 == null) goto L8;
            String r4 = r3.getIdString();
            if (r4 == null) goto L8;
        L9:
            r1.d(r4);
            return;
        L8:
            r4 = "";
            goto L9
        }
    }

    public static final class c implements BaseRefreshLayout.c {
        public final /* synthetic */ VideoRoomPreApplyFragment a;

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout.c
        public final void onFinish() {
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout.c
        public final void y0() {
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout.c
        public final void onRefresh() {
            this.a.h.clear();
            vj0.a r0 = (vj0.a) this.a.f;
            if (r0 == null) goto L6;
            vj0.a.f(r0, true, null, 6);
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout.c
        public final void z1() {
            View r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.setVisibility(0);
            return;
        }

        public c(VideoRoomPreApplyFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ VideoRoomPreApplyFragment a;

        public d(VideoRoomPreApplyFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            VideoRoomPreApplyFragment r5 = this.a;
            int r0 = VideoRoomPreApplyFragment.w;
            vj0.a r6 = (vj0.a) r5.f;
            if (r6 == null) goto L6;
            vj0.a.f(r6, true, null, 6);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 240.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.contract.VideoRoomPreApplyContract$View
    public final void ca0() {
        c1 r0 = this.u;
        if (r0 == null) goto L5;
        r0.a = false;
    L5:
        MultiTypeAdapter r1 = this.q;
        if (r1 == null) goto L9;
        r1.notifyDataSetChanged();
        return;
    }

    public VideoRoomPreApplyFragment() {
        this.h = new LinkedList();
        this.r = "";
        this.t = new Handler();
        k.n(IMiddlewareUserService.class).user().c();
        this.v = new b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.t.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.contract.VideoRoomPreApplyContract$View
    public final void aa0(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if (getView() != null) goto L5;
        return;
    L5:
        r2.printStackTrace();
        RecyclerView r3 = this.j;
        if (r3 == null) goto L8;
        r3.setVisibility(8);
    L8:
        LinearLayout r4 = this.k;
        if (r4 == null) goto L11;
        r4.setVisibility(8);
    L11:
        LinearLayout r5 = this.l;
        if (r5 == null) goto L15;
        r5.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.contract.VideoRoomPreApplyContract$View
    public final void da0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uidString");
        c1 r0 = this.u;
        if (r0 == null) goto L5;
        r0.a = true;
    L5:
        MultiTypeAdapter r1 = this.q;
        if (r1 == null) goto L8;
        r1.notifyDataSetChanged();
    L8:
        HashMap r2 = new HashMap();
        r2.put("live_type", "video_live");
        r2.put("applicant_id", r5);
        r2.put("source", "pre_apply");
        r2.put("function_type", "new_audience");
        r2.put("function_type2", "new_audience");
        j0.l().sendLog("livesdk_anchor_audience_connection_pass", r2, new Object[]{IRoom.class});
        xs2.b.a().post(new com.bytedance.android.live.liveinteract.d(4));
        this.d.dismiss();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Room r3 = m.i().getCurrentRoom();
        this.s = r3;
        if (r3 == null) goto L5;
        String r4 = r3.getOwnerUserIdString();
    L6:
        Intrinsics.areEqual(r4, k.n(IMiddlewareUserService.class).user().n());
        e r5 = new e(this.s, this);
        this.f = r5;
        ((com.bytedance.android.livesdk.common.c) r5).a = this;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        RecyclerView r0 = this.j;
        if (r0 == null) goto L5;
        r0.setNestedScrollingEnabled(r2);
    L5:
        RecyclerView r3 = this.j;
        if (r3 == null) goto L9;
        r3.requestLayout();
        return;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        this.g = (BaseRefreshLayout) r3.findViewById(2131392080);
        this.j = r3.findViewById(2131384731);
        this.i = r3.findViewById(2131392077);
        this.k = (LinearLayout) r3.findViewById(2131371557);
        this.l = (LinearLayout) r3.findViewById(2131371744);
        this.m = (TextView) r3.findViewById(2131384133);
        this.n = (TextView) r3.findViewById(2131375618);
        this.o = (TextView) r3.findViewById(2131375606);
        ImageView r5 = (ImageView) r3.findViewById(2131371586);
        this.p = (OnlineFriendsCircleContainer) r3.findViewById(2131373315);
        MultiTypeAdapter r6 = new MultiTypeAdapter();
        this.q = r6;
        RecyclerView r7 = this.j;
        if (r7 == null) goto L5;
        r7.setAdapter(r6);
    L5:
        RecyclerView r8 = this.j;
        if (r8 == null) goto L8;
        r8.setLayoutManager(new LinearLayoutManager(getContext()));
    L8:
        MultiTypeAdapter r9 = this.q;
        if (r9 == null) goto L11;
        r9.z2(zf0.b.a.class, new zf0.b());
    L11:
        MultiTypeAdapter r10 = this.q;
        if (r10 == null) goto L14;
        r10.z2(c1.class, new com.bytedance.android.live.liveinteract.videotalk.adapter.d(this.v));
    L14:
        MultiTypeAdapter r11 = this.q;
        if (r11 == null) goto L17;
        r11.a = this.h;
    L17:
        TextView r12 = this.n;
        if (r12 == null) goto L20;
        r12.setVisibility(8);
    L20:
        OnlineFriendsCircleContainer r13 = this.p;
        if (r13 == null) goto L23;
        r13.setVisibility(8);
    L23:
        BaseRefreshLayout r14 = this.g;
        if (r14 == null) goto L26;
        r14.setmIsDisable(false);
    L26:
        BaseRefreshLayout r15 = this.g;
        if (r15 == null) goto L29;
        r15.setOnRefreshListener(new c(this));
    L29:
        RecyclerView r16 = this.j;
        if (r16 == null) goto L32;
        r16.addOnScrollListener(new AnonymousClass2(this));
    L32:
        TextView r17 = this.m;
        if (r17 == null) goto L35;
        r17.setOnClickListener(new d(this));
    L35:
        b1 r18 = us1.e.d;
        if (r18 == null) goto L41;
        List<c1> r19 = r18.a();
        boolean r0 = r18.c();
        String r20 = r18.d();
        if (r20 != null) goto L40;
        r20 = "";
    L40:
        ba0(r19, r0, r20);
        return;
    L41:
        vj0.a r21 = (vj0.a) this.f;
        if (r21 == null) goto L46;
        vj0.a.f(r21, true, null, 6);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.contract.VideoRoomPreApplyContract$View
    public final void ba0(List r11, boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "cursor");
        boolean r0 = us1.e.a;
        if (r11 == null) goto L6;
        r11.size();
    L6:
        if (getView() != null) goto L8;
        return;
    L8:
        BaseRefreshLayout r1 = this.g;
        if (r1 != null) goto L11;
    L13:
        MultiTypeAdapter r2 = this.q;
        if (r2 == null) goto L57;
        List r3 = r11;
        if (r3 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == false) goto L24;
        LinkedList<Object> r14 = this.h;
    L56:
        r2.a = r14;
        goto L57
    L24:
        zf0.b.a r5 = new zf0.b.a();
        LinkedList r6 = new LinkedList();
        Iterator r15 = r11.iterator();
    L26:
        if (r15.hasNext() == false) goto L47;
        c1 r7 = (c1) r15.next();
        Iterator<Object> r8 = this.h.iterator();
    L29:
        if (r8.hasNext() == false) goto L43;
        Object r9 = r8.next();
        if ((r9 instanceof c1) == false) goto L29;
        IBaseUser r10 = ((c1) r9).b();
        String r16 = null;
        if (r10 == null) goto L35;
        String r17 = r10.getIdString();
    L36:
        if (r7 == null) goto L41;
        IBaseUser r18 = r7.b();
        if (r18 == null) goto L41;
        r16 = r18.getIdString();
    L41:
        if (Intrinsics.areEqual(r17, r16) == false) goto L29;
        boolean r19 = true;
    L44:
        if (r19 == true) goto L26;
        r6.add(r7);
        goto L26
    L35:
        r17 = null;
        goto L36
    L43:
        r19 = false;
        goto L44
    L47:
        if (this.h.size() > 0) goto L49;
    L51:
        this.h.addAll(r6);
        if (r12 == true) goto L54;
        r5.a = 1;
    L55:
        this.h.add(r5);
        r14 = this.h;
        goto L56
    L54:
        r5.a = 0;
        goto L55
    L49:
        if ((this.h.getLast() instanceof zf0.b.a) == false) goto L51;
        this.h.removeLast();
        goto L51
    L18:
        if (r3.isEmpty() == true) goto L21;
        r4 = false;
    L57:
        MultiTypeAdapter r110 = this.q;
        if (r110 == null) goto L61;
        r110.notifyDataSetChanged();
    L61:
        if (Lists.isEmpty(this.h) == false) goto L80;
        RecyclerView r111 = this.j;
        if (r111 == null) goto L65;
        r111.setVisibility(8);
    L65:
        LinearLayout r112 = this.k;
        if (r112 == null) goto L68;
        r112.setVisibility(0);
    L68:
        TextView r113 = this.n;
        if (r113 == null) goto L71;
        r113.setVisibility(8);
    L71:
        OnlineFriendsCircleContainer r114 = this.p;
        if (r114 == null) goto L74;
        r114.setVisibility(8);
    L74:
        TextView r115 = this.o;
        if (r115 == null) goto L77;
        r115.setText(s1.B(2131917984));
    L77:
        LinearLayout r116 = this.l;
        if (r116 == null) goto L89;
        r116.setVisibility(8);
    L89:
        this.r = r13;
        return;
    L80:
        RecyclerView r117 = this.j;
        if (r117 == null) goto L83;
        r117.setVisibility(0);
    L83:
        LinearLayout r118 = this.k;
        if (r118 == null) goto L86;
        r118.setVisibility(8);
    L86:
        LinearLayout r119 = this.l;
        if (r119 == null) goto L89;
        r119.setVisibility(8);
        goto L89
    L11:
        if (r1.e == false) goto L13;
        this.t.postDelayed(new xj0.a(r1), 1000);
        goto L13
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565511, r3, false);
    }
}
