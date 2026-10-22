package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.ui.PkInviteUserListRefreshLayout;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.AnchorLinkmicUserSettings;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.chatroom.interact.model.RivalExtraInfo;
import com.bytedance.android.livesdk.chatroom.interact.model.m0;
import com.bytedance.android.livesdk.config.lh0;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaAnchorLinkExpandViewHolder;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaLinkAnchorItemExposeRecyclerView;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MediaAnchorLinkUserListFragment extends MediaAnchorLinkUserListContract$View implements t82.c, MediaAnchorLinkExpandViewHolder.a {
    public static final /* synthetic */ int A = 0;
    public MediaLinkAnchorItemExposeRecyclerView g;
    public TextView h;
    public PkInviteUserListRefreshLayout i;
    public View j;
    public View k;
    public View l;
    public Boolean m;
    public int n;
    public int o;
    public m0 p;
    public MultiTypeAdapter q;
    public hy.e r;
    public final List<AnchorLinkUser> s;
    public final Room t;
    public ey.k u;
    public boolean v;
    public final Handler w;
    public final nc0.b x;
    public final a y;
    public final b z;

    public class a extends ey.d {
        public final /* synthetic */ MediaAnchorLinkUserListFragment a;

        public a(MediaAnchorLinkUserListFragment r1) {
            this.a = r1;
        }

        public final void Ci(fy.c r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.q.notifyDataSetChanged();
        }

        public final void qe(if r5) {
            Intrinsics.checkNotNullParameter(r5, "linkerMessage");
            Iterator r0 = this.a.r.getInviteeList().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            User r1 = (User) r0.next();
            if (n0.a(r1.getIdStr(), r5.mReply.getToUserId()) == false) goto L4;
            this.a.r.k(r1);
            goto L4
        L8:
            this.a.q.notifyDataSetChanged();
        }

        public final void Th(fy.e r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.q.notifyDataSetChanged();
            if ((r3 instanceof ApiServerException) == true) goto L5;
            return;
        L5:
            if (((ApiServerException) r3).getErrorCode() != 31012) goto L9;
            this.a.d.dismiss();
            return;
        }

        public final void zm(fy.e r1, long r2, LinkInviteResult r4, ey.l r5) {
            super.zm(r1, r2, r4, r5);
            this.a.r.e(r1.h.getBaseOwner());
            this.a.r.b(4, "invite_success_callback");
            this.a.q.notifyDataSetChanged();
            w82.b.e(r1, r1.h);
        }
    }

    public class b extends hy.f.a {
        public final /* synthetic */ MediaAnchorLinkUserListFragment a;

        public b(MediaAnchorLinkUserListFragment r1) {
            this.a = r1;
        }

        public final void b(int r1, List<AnchorLinkUser> r2) {
            ((ArrayList) this.a.s).clear();
            ((ArrayList) this.a.s).addAll(r2);
        }
    }

    public class c implements PkInviteUserListRefreshLayout.k {
        public final /* synthetic */ MediaAnchorLinkUserListFragment a;

        public final void y0() {
        }

        public final void onFinish() {
            MediaAnchorLinkUserListFragment r0 = this.a;
            r0.m = Boolean.TRUE;
            r0.g.r();
        }

        public final void onRefresh() {
            MediaAnchorLinkUserListFragment r0 = this.a;
            int r1 = MediaAnchorLinkUserListFragment.A;
            ((t82.d) r0.f).c(r0.n);
        }

        public final void z1() {
            if (this.a.m.booleanValue() == false) goto L6;
            this.a.j.setVisibility(0);
            MediaAnchorLinkUserListFragment r0 = this.a;
            r0.m = Boolean.FALSE;
            return;
        }

        public c(MediaAnchorLinkUserListFragment r1) {
            this.a = r1;
        }
    }

    public MediaAnchorLinkUserListFragment() {
        this.o = Integer.MAX_VALUE;
        this.s = new ArrayList();
        this.t = jc1.k.f(IRoomService.class).getCurrentRoom();
        this.v = true;
        this.w = new Handler();
        ey.g.a.getClass();
        this.x = ey.g.a.a();
        this.y = new a(this);
        this.z = new b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final float T90() {
        return t6.d(s1.getContext(), t6.c(s1.getContext()) * 1.2f) - 48;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final String V90() {
        return getString(2131920256);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.w.removeCallbacksAndMessages(null);
        ((com.bytedance.android.livesdk.common.c) ((t82.d) this.f)).a = null;
        nc0.b r0 = this.x;
        if (r0 == null) goto L5;
        r0.a(17, this.y);
    L5:
        hy.e r1 = this.r;
        if (r1 == null) goto L9;
        r1.h(this.z);
        return;
    }

    public final void onResume() {
        super.onResume();
        MediaLinkAnchorItemExposeRecyclerView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setNestedScrollingEnabled(true);
        this.g.requestLayout();
    L6:
        if (this.v == false) goto L12;
        hy.e r1 = this.r;
        if (r1 == null) goto L10;
        r1.b(4, "show_link_list_dialog");
    L10:
        ((t82.d) this.f).c(this.n);
        this.v = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View
    public final void Y90(Throwable r2) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        ExceptionUtils.handleException(getContext(), r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View
    public final void Z90(m0 r10) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        int r1 = 0;
        if (r10.a() == null) goto L31;
        if (Lists.isEmpty(r10.a()) == true) goto L31;
        ArrayList r0 = new ArrayList();
        ArrayList r3 = new ArrayList();
        int r4 = 0;
    L11:
        if (r4 >= r10.a().size()) goto L29;
        Room r5 = (Room) ListProtector.get(r10.a(), r4);
        RivalExtraInfo r6 = (RivalExtraInfo) r10.b().get(Long.valueOf(r5.getId()));
        if (r6 == null) goto L20;
        AnchorLinkmicUserSettings r7 = r6.anchorLinkmicUserSettings;
        if (r7 == null) goto L20;
        if (r7.isTurnOn == true) goto L20;
        r3.add(r5);
    L28:
        r4 = r4 + 1;
    L20:
        if (r5.getLinkMicInfo() == null) goto L22;
        r3.add(r5);
        goto L28
    L22:
        Map r8 = r5.getLinkMap();
        if (r8 != null) goto L25;
    L27:
        r0.add(r5);
        goto L28
    L25:
        if (r8.containsKey(String.valueOf(17)) == false) goto L27;
        r3.add(r5);
        goto L28
    L29:
        r10.a().clear();
        r10.a().addAll(r0);
        r10.a().addAll(r3);
    L31:
        if (r10.a() != null) goto L33;
    L58:
        this.p = r10;
        if (this.i.e == false) goto L61;
        new Handler().postDelayed(new h(this), 1000);
    L61:
        this.g.b.clear();
        MultiTypeAdapter r2 = this.q;
        r2.a = aa0(r10);
        this.q.notifyDataSetChanged();
        this.k.setVisibility(8);
        return;
    L33:
        if (Lists.isEmpty(r10.a()) == true) goto L58;
    L35:
        if (r1 >= r10.a().size()) goto L56;
        Room r9 = (Room) ListProtector.get(r10.a(), r1);
        if (r10.b() == null) goto L45;
        RivalExtraInfo r11 = (RivalExtraInfo) r10.b().get(Long.valueOf(r9.getId()));
        if (r11 == null) goto L45;
        AnchorLinkmicUserSettings r13 = r11.anchorLinkmicUserSettings;
        if (r13 == null) goto L45;
        if (r13.isTurnOn == true) goto L45;
        this.o = r1;
    L45:
        if (r9 == null) goto L54;
        if (r9.getLinkMicInfo() != null) goto L48;
        Map r14 = r9.getLinkMap();
        if (r14 == null) goto L54;
        if (r14.containsKey(String.valueOf(17)) == false) goto L54;
        this.o = r1;
        goto L56
    L48:
        this.o = r1;
    L54:
        r1 = r1 + 1;
    L56:
        if (r1 != r10.a().size()) goto L58;
        this.o = r10.a().size();
        goto L58
    }

    public final List<Object> aa0(m0 r9) {
        LinkedList r0 = new LinkedList();
        if (r9.a() == null) goto L17;
        if (r9.a().size() <= 0) goto L7;
        v82.c.a r1 = new v82.c.a();
        r1.a = s1.B(2131920300);
        r0.add(r1);
    L7:
        Iterator r2 = r9.a().iterator();
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L17;
        Room r4 = (Room) r2.next();
        int r5 = this.o;
        if (r3 != r5) goto L15;
        if (r5 >= r9.a().size()) goto L15;
        v82.a.C0289a r6 = new v82.a.C0289a();
        r6.a = s1.C(2131920243, new Object[]{Integer.valueOf(r9.a().size() - r3)});
        r0.add(r6);
    L15:
        Map<Long, RivalExtraInfo> r7 = r9.b();
        v82.d.a r8 = new v82.d.a();
        r8.a = r4;
        r8.c = 1;
        r8.b = r7;
        r0.add(r8);
        r3 = r3 + 1;
    L17:
        if (r0.isEmpty() == false) goto L19;
        this.g.setVisibility(8);
        this.l.setVisibility(0);
        this.i.setVisibility(8);
    L20:
        return r0;
    L19:
        this.g.setVisibility(0);
        this.l.setVisibility(8);
        this.i.setVisibility(0);
        goto L20
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        T r4 = this.f;
        if (r4 == 0) goto L5;
        ((com.bytedance.android.livesdk.common.c) ((t82.d) r4)).a = this;
    L5:
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r5 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if ((r5 instanceof x82.a) == false) goto L12;
        this.u = ((x82.a) r5).getLinkOutManager();
        nc0.b r6 = this.x;
        if (r6 == null) goto L10;
        r6.b(17, this.y);
    L10:
        hy.e r7 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a().Np();
        this.r = r7;
        r7.i(this.z);
        return;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        View r8 = r5.inflate(2131566909, r6, false);
        this.g = (MediaLinkAnchorItemExposeRecyclerView) r8.findViewById(2131384076);
        this.h = (TextView) r8.findViewById(2131383050);
        if (jc1.k.f(IUserService.class).user().b().getSecret() != 1) goto L9;
        this.h.setVisibility(0);
        String r9 = (String) lh0.a.getValue();
        if (TextUtils.isEmpty(r9) == false) goto L7;
    L10:
        PkInviteUserListRefreshLayout r10 = r8.findViewById(2131392080);
        this.i = r10;
        r10.setRecyclerView(this.g);
        this.j = r8.findViewById(2131392078);
        this.k = r8.findViewById(2131382879);
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.l = r8.findViewById(2131390556);
        this.m = Boolean.TRUE;
        this.i.setOnRefreshListener(new c(this));
        this.g.setLayoutManager(new LinearLayoutManager(getContext()));
        MultiTypeAdapter r11 = new MultiTypeAdapter();
        this.q = r11;
        r11.z2(v82.c.a.class, new v82.c());
        this.q.z2(v82.a.C0289a.class, new v82.a(this));
        this.q.z2(v82.d.a.class, new v82.d(this));
        this.i.setmIsDisable(false);
        this.g.setAdapter(this.q);
        return r8;
    L7:
        if (getContext() == null) goto L10;
        this.h.setText(String.format(r9, new Object[]{getContext().getResources().getString(2131918107)}));
        goto L10
    L9:
        this.h.setVisibility(8);
        goto L10
    }
}
