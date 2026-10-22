package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View;
import com.bytedance.android.live.liveinteract.plantform.core.l0;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.v;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.drakeet.multitype.MultiTypeAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class InteractAudienceInviteFragment extends InteractAudienceInviteContract$View implements com.bytedance.android.live.liveinteract.component.a<m0>, com.bytedance.android.live.liveinteract.linkpanel.list.o {
    public static final /* synthetic */ int o = 0;
    public RecyclerView g;
    public MultiTypeAdapter h;
    public LinearLayout i;
    public LinearLayout j;
    public final int k;
    public boolean l;
    public boolean m;
    public final a n;

    public class a extends l0 {
        public final /* synthetic */ InteractAudienceInviteFragment a;

        public a(InteractAudienceInviteFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.core.l0, uf0.a
        public final void e6(String r1, IBaseUser r2, v r3) {
            super.e6(r1, r2, r3);
            int r4 = InteractAudienceInviteFragment.o;
            InteractAudienceInviteFragment r5 = this.a;
            int r6 = r5.k;
            ((hf0.b) r5.f).d(r6, "InteractAudienceInviteResult");
        }
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.list.o
    public final void hw(ILinkPlayerInfoBridge r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View
    public final void aa0() {
        this.g.setVisibility(8);
        this.j.setVisibility(8);
        this.i.setVisibility(0);
    }

    public final void ca0() throws JSONException {
        if (this.m == true) goto L5;
        ((ObservableSubscribeProxy) Observable.timer(1000, TimeUnit.MILLISECONDS).as(S90())).subscribe(new k(this));
        return;
    L5:
        JSONObject r0 = new JSONObject();
        MultiTypeAdapter r1 = this.h;
        if (r1 != null) goto L8;
        int r2 = 0;
    L9:
        r0.put("audience", String.valueOf(r2));
        int r3 = jf0.b.a;
        jf0.b.i("invite", this.l, r0);
        return;
    L8:
        r2 = r1.getItemCount();
        goto L9
    }

    public InteractAudienceInviteFragment() {
        this.k = 1;
        this.m = false;
        this.n = new a(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.l == false) goto L9;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L7;
    L14:
        ((com.bytedance.android.livesdk.common.c) ((hf0.b) this.f)).a = null;
        return;
    L7:
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a().X4() == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.base.d.a.a().X4().g(this.n);
        goto L14
    L9:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a() == null) goto L14;
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a().A0() == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.base.c.a.a().A0().g(this.n);
        goto L14
    }

    public final void onResume() {
        super.onResume();
        ((hf0.b) this.f).d(this.k, "InteractAudienceInviteResume");
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.list.o
    public final void Ys(ILinkPlayerInfoBridge r1) {
        this.h.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View
    public final void ba0(List<ILinkPlayerInfoBridge> r7) {
        if (Lists.isEmpty(r7) == true) goto L13;
        Iterator<ILinkPlayerInfoBridge> r0 = r7.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        ILinkPlayerInfoBridge r1 = r0.next();
        String r2 = jc1.k.f(IMiddlewareUserService.class).user().n();
        if (r1.getUser() == null) goto L7;
        if (TextUtils.equals(r1.getUser().getIdString(), r2) == false) goto L7;
        r0.remove();
    L13:
        HashMap r3 = new HashMap();
        r3.put("panel_show", "invite");
        if (CollectionUtils.isEmpty(r7) == false) goto L16;
        String r4 = "0";
    L17:
        r3.put("audience_cnt", r4);
        j0.l().sendLog("livesdk_anchor_double_show", r3, new Object[]{x.class, IRoom.class});
        if (CollectionUtils.isEmpty(r7) == false) goto L20;
        this.g.setVisibility(8);
        this.j.setVisibility(0);
        this.i.setVisibility(8);
    L21:
        this.m = true;
        return;
    L20:
        MultiTypeAdapter r5 = this.h;
        r5.a = r7;
        r5.notifyDataSetChanged();
        this.g.setVisibility(0);
        this.j.setVisibility(8);
        this.i.setVisibility(8);
        goto L21
    L16:
        r4 = String.valueOf(r7.size());
        goto L17
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Room r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        MultiTypeAdapter r0 = new MultiTypeAdapter();
        this.h = r0;
        r0.z2(ILinkPlayerInfoBridge.class, new l(this, this.k));
        kf0.f r1 = new kf0.f(this, r6);
        this.f = r1;
        ((com.bytedance.android.livesdk.common.c) r1).a = this;
    }

    @Override // com.bytedance.android.live.liveinteract.component.a
    public final void run(m0 r3) {
        int r4 = this.k;
        ((hf0.b) this.f).d(r4, "InteractAudienceInviteResult");
    }

    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        RecyclerView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setNestedScrollingEnabled(r2);
        this.g.requestLayout();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131565498, r3, false);
        this.g = r5.findViewById(2131384731);
        this.i = (LinearLayout) r5.findViewById(2131371744);
        this.j = (LinearLayout) r5.findViewById(2131371557);
        LinearLayoutManager r6 = new LinearLayoutManager(getContext());
        this.g.setLayoutManager(r6);
        this.g.setAdapter(this.h);
        if (this.l == false) goto L9;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L7;
    L14:
        return r5;
    L7:
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a().X4() == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.base.d.a.a().X4().a(this.n);
        goto L14
    L9:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a() == null) goto L14;
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a().A0() == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.base.c.a.a().A0().a(this.n);
        goto L14
    }
}
