package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkReplyResult;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.lh0;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkInviteContract$View;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaAnchorLinkInfoInviteView;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MediaAnchorLinkInviteFragment extends MediaAnchorLinkInviteContract$View implements View.OnClickListener {
    public static final /* synthetic */ int H = 0;
    public ey.k A;
    public if B;
    public String C;
    public final SparseArray<String> D;
    public final nc0.b E;
    public final a F;
    public final b G;
    public TextView g;
    public TextView h;
    public MediaAnchorLinkInfoInviteView i;
    public MediaAnchorLinkInfoInviteView j;
    public MediaAnchorLinkInfoInviteView k;
    public Animation l;
    public Animation m;
    public Animation n;
    public int o;
    public AnchorLinkUser p;
    public String q;
    public String r;
    public final List<AnchorLinkUser> s;
    public long t;
    public long u;
    public String v;
    public int w;
    public int x;
    public int y;
    public hy.e z;

    public class a extends ey.d {
        public final /* synthetic */ MediaAnchorLinkInviteFragment a;

        public a(MediaAnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        public final void Ah(fy.j r1, LinkReplyResult r2, long r3) {
            super.Ah(r1, r2, r3);
            MediaAnchorLinkInviteFragment r4 = this.a;
            int r5 = MediaAnchorLinkInviteFragment.H;
            t82.f r6 = r4.d;
            if (r6 != null) goto L5;
            return;
        L5:
            if (r1.d == 4) goto L9;
            r6.dismiss();
            return;
        }
    }

    public class b extends hy.f.a {
        public final /* synthetic */ MediaAnchorLinkInviteFragment a;

        public b(MediaAnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        public final void b(int r4, List<AnchorLinkUser> r5) {
            if (ey.c.a(this.a.B) == false) goto L5;
            return;
        L5:
            if (r5 == null) goto L39;
            ArrayList r6 = (ArrayList) r5;
            if (r6.isEmpty() == true) goto L40;
            Iterator r7 = r6.iterator();
        L10:
            if (r7.hasNext() == false) goto L14;
            AnchorLinkUser r0 = (AnchorLinkUser) r7.next();
            if (n0.a(r0.getUser().getIdString(), this.a.q) == false) goto L10;
            this.a.p = r0;
            goto L10
        L14:
            ((ArrayList) this.a.s).clear();
            MediaAnchorLinkInviteFragment r8 = this.a;
            AnchorLinkUser r1 = r8.p;
            if (r1 == null) goto L17;
            ((ArrayList) r8.s).add(r1);
        L17:
            Iterator r9 = r6.iterator();
        L19:
            if (r9.hasNext() == false) goto L25;
            AnchorLinkUser r10 = (AnchorLinkUser) r9.next();
            if (n0.a(r10.getUser().getIdString(), this.a.q) == true) goto L19;
            if (r10.getStatus() != 2) goto L19;
            ((ArrayList) this.a.s).add(r10);
            goto L19
        L25:
            MediaAnchorLinkInviteFragment r11 = this.a;
            r11.aa0(r11.s);
            return;
        L40:
            return;
        }
    }

    public class c implements Animation.AnimationListener {
        public final /* synthetic */ MediaAnchorLinkInviteFragment a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public c(MediaAnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            if (this.a.i.getIvAvatar() == null) goto L8;
            MediaAnchorLinkInviteFragment r3 = this.a;
            if (r3.m == null) goto L9;
            r3.i.getIvAvatar().startAnimation(this.a.m);
            return;
        L9:
            return;
        }
    }

    public class d implements Animation.AnimationListener {
        public final /* synthetic */ MediaAnchorLinkInviteFragment a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public d(MediaAnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            if (this.a.i.getIvAvatar() == null) goto L8;
            MediaAnchorLinkInviteFragment r3 = this.a;
            if (r3.l == null) goto L9;
            r3.i.getIvAvatar().startAnimation(this.a.l);
            return;
        L9:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final float T90() {
        return 251.0f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final String V90() {
        return BuildConfig.FLAVOR;
    }

    public final fy.a Z90() {
        return new fy.a(this.w, this.x, this.y, 0, null, false, !TextUtils.isEmpty(this.C), false, "multiReply", 0, this.q, null);
    }

    public MediaAnchorLinkInviteFragment() {
        this.s = new ArrayList();
        this.C = BuildConfig.FLAVOR;
        this.D = new SparseArray();
        ey.g.a.getClass();
        this.E = ey.g.a.a();
        this.F = new a(this);
        this.G = new b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r0 = (ViewGroup) LayoutInflater.from(getContext()).inflate(2131566914, null);
        ((TextView) r0.findViewById(2131388882)).setText(this.v);
        return r0;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.F4(true);
        nc0.b r0 = this.E;
        if (r0 == null) goto L5;
        r0.a(17, this.F);
    L5:
        hy.e r1 = this.z;
        if (r1 == null) goto L9;
        r1.h(this.G);
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((t82.b) this.f).c();
        this.l.cancel();
        this.m.cancel();
        this.n.cancel();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final int W90(View r1) {
        return s1.f(51.5f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkInviteContract$View
    public final void Y90(int r20) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        this.g.setText(FormatUtils.format(s1.B(2131920249), new Object[]{Integer.valueOf(r20)}));
        if (r20 == 0) goto L8;
        return;
    L8:
        if (this.o != 1) goto L12;
        ey.k r1 = this.A;
        if (r1 == null) goto L12;
        r1.d(new fy.j(17, this.t, this.u, 5, this.q, this.r, Boolean.TRUE, 0, Z90()));
        w82.b.a("reject", this.q, this.t);
    L12:
        this.d.dismiss();
    }

    public final void aa0(List<AnchorLinkUser> r5) {
        AnchorLinkUser r0 = this.p;
        if (r0 == null) goto L16;
        ba0(this.i, r0);
        ArrayList r6 = (ArrayList) r5;
        if (r6.size() > 1) goto L7;
    L14:
        this.i.getIvAvatar().startAnimation(this.l);
        this.i.getViewWave().setVisibility(0);
        this.i.getAnimWave().setVisibility(0);
        this.i.getAnimWave().startAnimation(this.n);
        this.l.setAnimationListener(new c(this));
        this.m.setAnimationListener(new d(this));
        return;
    L7:
        if (this.o != 1) goto L14;
        if (r6.size() != 2) goto L12;
        ba0(this.j, (AnchorLinkUser) ListProtector.get(r6, 1));
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
        r7.leftMargin = s1.f(40.0f);
        r1.rightMargin = s1.f(40.0f);
        this.i.setLayoutParams(r7);
        this.j.setLayoutParams(r1);
        goto L14
    L12:
        if (r6.size() != 3) goto L14;
        ba0(this.j, (AnchorLinkUser) ListProtector.get(r6, 1));
        ba0(this.k, (AnchorLinkUser) ListProtector.get(r6, 2));
        goto L14
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r21) {
        int r1 = r21.getId();
        if (r1 == 2131364592) goto L6;
        if (r1 == 2131364604) goto L6;
        return;
    L6:
        if (this.o != 1) goto L23;
        ey.k r4 = this.A;
        if (r4 == null) goto L14;
        long r10 = this.t;
        long r13 = this.u;
        if (r1 != 2131364604) goto L12;
        int r14 = 2;
    L13:
        r4.d(new fy.j(17, r10, r13, r14, this.q, this.r, Boolean.FALSE, 0, Z90()));
        goto L14
    L12:
        r14 = 1;
    L14:
        if (r1 != 2131364592) goto L21;
        w82.b.a("accept", this.q, this.t);
        VideoPlayDataContext.Companion.getClass();
        VideoPlayDataContext r2 = VideoPlayDataContext.a.a();
        if (r2 == null) goto L23;
        if (((Integer) r2.getPlayState().getValue()).intValue() == 2) goto L23;
        r2.getPlayState().setValue(2);
        f2.c("结束连线状态，可再次使用放映视频", 0);
        goto L23
    L21:
        if (r1 != 2131364604) goto L23;
        w82.b.a("reject", this.q, this.t);
    L23:
        this.d.dismiss();
        ((t82.b) this.f).c();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r5 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r5 != null) goto L5;
    L10:
        this.l = AnimationUtils.loadAnimation(getContext(), 2130772715);
        this.m = AnimationUtils.loadAnimation(getContext(), 2130772716);
        this.n = AnimationUtils.loadAnimation(getContext(), 2130772717);
        this.l.setRepeatCount(-1);
        this.l.setInterpolator(new LinearInterpolator());
        this.n.setInterpolator(new LinearInterpolator());
        this.D.put(101, "mutual_follow");
        this.D.put(102, "recommend");
        return;
    L5:
        if ((r5 instanceof x82.a) == false) goto L10;
        this.A = ((x82.a) r5).getLinkOutManager();
        nc0.b r0 = this.E;
        if (r0 == null) goto L9;
        r0.b(17, this.F);
    L9:
        hy.e r6 = r5.Np();
        this.z = r6;
        r6.i(this.G);
        goto L10
    }

    public static void ba0(MediaAnchorLinkInfoInviteView r7, AnchorLinkUser r8) {
        IBaseUser r9 = r8.getUser();
        a1.x(r7.getIvAvatar(), r9.getAvatarThumbKt(), r7.getIvAvatar().getWidth(), r7.getIvAvatar().getHeight(), 2131250965);
        r7.getTvNickname().setText(r9.getNickName());
        r7.getIvGender().setVisibility(8);
        if (r9.getFollowInfo().getFollowStatus() != 2) goto L5;
        r7.getTvLabelTop().setVisibility(0);
    L5:
        r7.getTvMoney().setVisibility(8);
        r7.getIvLocation().setVisibility(8);
        r7.getTvDistance().setVisibility(0);
        r7.getTvDistance().setText(s1.C(2131920241, new Object[]{IESUIUtils.getDisplayCount(r9.getFollowInfo().getFollowerCount(), "w")}));
        r7.setVisibility(0);
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        View r9 = r6.inflate(2131566908, r7, false);
        this.g = (TextView) r9.findViewById(2131364604);
        this.h = (TextView) r9.findViewById(2131364592);
        this.i = (MediaAnchorLinkInfoInviteView) r9.findViewById(2131377963);
        this.j = (MediaAnchorLinkInfoInviteView) r9.findViewById(2131377964);
        this.k = (MediaAnchorLinkInfoInviteView) r9.findViewById(2131377965);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.h.setTextColor(s1.h(2131107835));
        TextView r10 = (TextView) r9.findViewById(2131383050);
        if (jc1.k.f(IUserService.class).user().b().getSecret() != 1) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L12;
        r10.setVisibility(0);
        String r13 = (String) lh0.a.getValue();
        if (TextUtils.isEmpty(r13) == true) goto L14;
        if (getContext() == null) goto L14;
        r10.setText(String.format(r13, new Object[]{getContext().getResources().getString(2131918107)}));
    L14:
        if (this.o != 1) goto L17;
        this.v = s1.B(2131920250);
    L17:
        if (ey.c.a(this.B) == false) goto L19;
        ((ArrayList) this.s).addAll(this.B.mInvite.mInviterUsers);
        Collections.sort(this.s, new g(this));
        aa0(this.s);
    L22:
        this.d.F4(false);
        ((t82.b) this.f).d(10);
        ALogger.e("ttlive_anchor", "anchor link invite/apply dialog show, type: " + this.o);
        return r9;
    L19:
        hy.e r14 = this.z;
        if (r14 == null) goto L22;
        r14.b(4, "show_be_invited_applied_dialog");
        goto L22
    L12:
        r10.setVisibility(8);
        goto L14
    L5:
        r11 = false;
        goto L6
    }
}
