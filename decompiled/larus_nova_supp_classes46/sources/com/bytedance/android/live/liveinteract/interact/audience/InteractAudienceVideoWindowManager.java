package com.bytedance.android.live.liveinteract.interact.audience;

import am2.x;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interact.audience.ui.InteractAudienceAlertWindow;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.utils.g0;
import com.bytedance.android.live.liveinteract.plantform.utils.r;
import com.bytedance.android.live.liveinteract.revenue.paid.profilecard.PaidProfileCardContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import uf2.m1;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class InteractAudienceVideoWindowManager extends com.bytedance.android.live.liveinteract.plantform.base.i.d implements md0.a.InterfaceC0236a, fe0.i.a, Observer<KVData> {
    public boolean A;
    public final boolean B;
    public boolean C;
    public boolean D;
    public SeiAppData E;
    public DataCenter F;
    public int G;
    public View H;
    public TextView I;
    public LottieAnimationView J;
    public final LifecycleOwner K;
    public final List<String> L;
    public Disposable M;
    public Disposable N;
    public final Map<String, o> O;
    public final a P;
    public final i Q;
    public final b R;
    public boolean a;
    public final FragmentActivity b;
    public final FrameLayout c;
    public View d;
    public TextView e;
    public List<f> f;
    public final List<InteractAudienceAlertWindow> g;
    public boolean h;
    public boolean i;
    public boolean j;
    public n k;
    public View.OnClickListener l;
    public SurfaceView m;
    public f n;
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> o;
    public final int p;
    public final int q;
    public final int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public final fe0.i x;
    public final com.bytedance.android.live.liveinteract.api.utils.j y;
    public final IRoom z;

    public class a implements com.bytedance.android.livesdk.app.dataholder.Observer<Integer> {
        public final /* synthetic */ InteractAudienceVideoWindowManager a;

        public a(InteractAudienceVideoWindowManager r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            InteractAudienceVideoWindowManager r0 = this.a;
            if (r0.J != null) goto L5;
            return;
        L5:
            if (r0.I != null) goto L8;
            return;
        L8:
            if (r6.intValue() != 1) goto L10;
            long r1 = vm2.d.b().interactIcWaitingId;
            InteractAudienceVideoWindowManager r7 = this.a;
            g0.a(r1, r7.J, r7.K);
            this.a.I.setText(s1.getContext().getText(2131914813));
            r3.c(this.a.H, s1.B(2131914813), true);
            return;
        L10:
            InteractAudienceVideoWindowManager r8 = this.a;
            r8.J.clearAnimation();
            r8.J.setBackgroundResource(0);
            r8.J.setImageResource(2131250848);
            r8.J.setAlpha(1.0f);
            this.a.I.setText(s1.getContext().getText(2131919228));
            r3.c(this.a.H, s1.B(2131919228), true);
        }
    }

    public class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ InteractAudienceVideoWindowManager a;

        public b(InteractAudienceVideoWindowManager r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (r5 == r9) goto L8;
            InteractAudienceVideoWindowManager r10 = this.a;
            SeiAppData r11 = r10.E;
            if (r11 == null) goto L9;
            r10.onSeiUpdated(r11);
            return;
        L9:
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void b(String r1, String r2, boolean r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void g(String r1, long r2, String r4, com.bytedance.android.live.liveinteract.plantform.model.l r5) {
    }

    @Override // md0.a.InterfaceC0236a
    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
    }

    public final void p() {
        this.A = false;
        this.c.removeOnLayoutChangeListener(this.R);
        hd0.c.f().e(this.P);
        fe0.i r1 = this.x;
        r1.b.T4(r1);
        this.c.removeAllViews();
        xs2.b.a().post(new kd0.a(false, 0));
        this.F.put("cmd_interact_player_view_change", new kd0.a(false, 0));
        this.F.removeObserver("data_audio_chat_support_send_gift_to_linker", this.Q);
        this.F.removeObserver("data_intimate_chat_support_send_gift_to_linker", this.Q);
        this.F.removeObserver("data_support_send_gift_to_official_channel_host", this.Q);
        this.F.removeObserver("data_interact_audience_video_translation", this.Q);
        this.G = 0;
        this.F.removeObserver(this);
        PaidProfileCardContext r0 = PaidProfileCardContext.Companion.getContext();
        if (r0 == null) goto L5;
        r0.getPaidProfileCardPosition().setValue(null);
    L5:
        Disposable r2 = this.M;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        Disposable r3 = this.N;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        ((HashMap) this.O).clear();
    }

    private Context getContext() {
        return this.c.getContext();
    }

    public final void B() {
        if (Lists.isEmpty(this.f) == true) goto L5;
    L9:
        int r0 = r();
        r.a("window view change:true , width" + r0);
        this.F.put("cmd_interact_player_view_change", new kd0.a(true, r0));
        return;
    L5:
        if (Lists.isEmpty(this.g) == false) goto L9;
        if (this.i == true) goto L9;
        r.a("window view change:false , width0");
        this.F.put("cmd_interact_player_view_change", new kd0.a(false, 0));
    }

    public final void h() {
        int r1 = ((ArrayList) this.f).size();
        boolean r2 = this.B;
        int r3 = 8388693;
        int r8 = 0;
        if (r2 == true) goto L22;
        boolean r10 = this.C;
        if (r10 == true) goto L22;
        int r4 = m(r2, r10);
        int r11 = ((int) UIUtils.dip2Px(this.b, 14.0f)) + s();
        if (t() == false) goto L10;
        r11 = s1.f(56.0f);
    L10:
        int r12 = 0;
    L12:
        if (r12 >= r1) goto L14;
        f r13 = (f) ListProtector.get(this.f, r12);
        FrameLayout.LayoutParams r14 = (FrameLayout.LayoutParams) r13.getLayoutParams();
        r14.gravity = 83;
        int r15 = this.r;
        int r16 = this.q;
        r14.bottomMargin = ((r15 + r16) * r12) + r4;
        r14.leftMargin = r11;
        r14.width = this.p;
        r14.height = r16;
        r13.setLayoutParams(r14);
        r12 = r12 + 1;
        goto L12
    L14:
        if (r1 < 1) goto L18;
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) ((f) ListProtector.get(this.f, r1 - 1)).getLayoutParams();
        FrameLayout.LayoutParams r18 = (FrameLayout.LayoutParams) this.H.getLayoutParams();
        if (r18 == null) goto L18;
        r18.gravity = 83;
        r18.bottomMargin = (r17.bottomMargin + this.v) + r17.height;
        r18.leftMargin = r17.leftMargin;
        r18.width = this.q - this.w;
        this.H.setLayoutParams(r18);
    L18:
        if (r1 != 0) goto L98;
        n r5 = this.k;
        if (r5 == null) goto L98;
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        r6.gravity = 8388691;
        r6.bottomMargin = r4;
        r6.leftMargin = r11;
        r6.width = this.p;
        r6.height = this.q;
        this.k.setLayoutParams(r6);
    L98:
        if (Lists.isEmpty(this.f) == true) goto L100;
    L104:
        this.F.put("cmd_interact_player_view_change", new kd0.a(true, r()));
    L106:
        if ((com.bytedance.android.live.liveinteract.api.utils.m.i() instanceof com.bytedance.android.livesdk.chatroom.o) == true) goto L108;
        return;
    L108:
        if (this.B == false) goto L110;
    L116:
        int r7 = (int) UIUtils.dip2Px(this.b, 12.0f);
    L117:
        int r9 = m(this.B, this.C);
        PaidProfileCardContext r19 = PaidProfileCardContext.Companion.getContext();
        if (r19 == null) goto L137;
        r19.getPaidProfileCardPosition().setValue(new PaidProfileCardContext.b(r8, r7, r9, r3));
        return;
    L137:
        return;
    L110:
        if (this.C == true) goto L116;
        int r20 = ((int) UIUtils.dip2Px(this.b, 14.0f)) + s();
        if (t() == false) goto L115;
        r20 = s1.f(56.0f);
    L115:
        r8 = r20;
        r7 = 0;
        r3 = 8388691;
        goto L117
    L100:
        if (Lists.isEmpty(this.g) == false) goto L104;
        if (this.i == true) goto L104;
        this.F.put("cmd_interact_player_view_change", new kd0.a(false, 0));
    L22:
        int r21 = m(r2, this.C);
        int r110 = (int) UIUtils.dip2Px(this.b, 12.0f);
        if (((ArrayList) this.f).size() != 2) goto L29;
        ILinkPlayerInfoBridge r111 = ((f) ListProtector.get(this.f, 1)).getPresenter().d();
        if (r111 == null) goto L29;
        if (r111.isHost() == false) goto L29;
        ListProtector.add(this.f, 0, (f) ListProtector.remove(this.f, 1));
    L29:
        int r112 = 0;
    L31:
        if (r112 >= r1) goto L62;
        f r113 = (f) ListProtector.get(this.f, r112);
        FrameLayout.LayoutParams r114 = (FrameLayout.LayoutParams) r113.getLayoutParams();
        r114.gravity = 85;
        int r115 = this.r;
        int r22 = this.q;
        r114.bottomMargin = ((r115 + r22) * r112) + r21;
        r114.rightMargin = r110;
        r114.width = this.p;
        r114.height = r22;
        r113.setLayoutParams(r114);
        if (r113.getPresenter() == null) goto L61;
        o r23 = (o) ((HashMap) this.O).get(r113.getPresenter().c());
        if (r23 == null) goto L61;
        z.a r116 = r23.b;
        if (r23.a == null) goto L61;
        if (r116 == null) goto L61;
        DataCenter r24 = this.F;
        Boolean r117 = Boolean.FALSE;
        boolean r25 = ((Boolean) ((Pair) r24.get("data_broadcast_stream_size_adjusted", Pair.create(r117, r117))).second).booleanValue();
        s1.w();
        s1.w();
        s1.f(8.0f);
        s1.f(36.0f);
        s1.y();
        if (r25 == true) goto L44;
        s1.w();
    L44:
        ILiveWrappedLivePusher.Companion.getClass();
        m1.b r26 = ILiveWrappedLivePusher.a.b().newVideoMixerDescription(null);
        if (r26 == null) goto L61;
        r26.e();
        r26.b();
        r26.c();
        r26.f();
        r26.h();
        r26.i();
        r26.g();
        m1.b r118 = r116.Y();
        if (r118.getLeft() == r26.getLeft()) goto L49;
    L60:
        r116.b();
        goto L61
    L49:
        if (r118.getTop() != r26.getTop()) goto L60;
        if (r118.getRight() != r26.getRight()) goto L60;
        if (r118.getBottom() != r26.getBottom()) goto L60;
        if (r118.isVisible() != r26.isVisible()) goto L60;
        if (r118.getMode() != r26.getMode()) goto L60;
        if (r118.d() != r26.d()) goto L60;
    L61:
        r112 = r112 + 1;
        goto L31
    L62:
        int r27 = Math.min(2 - ((ArrayList) this.f).size(), ((ArrayList) this.g).size());
        if (this.B == true) goto L65;
    L88:
        if (r1 < 1) goto L92;
        FrameLayout.LayoutParams r28 = (FrameLayout.LayoutParams) ((f) ListProtector.get(this.f, r1 - 1)).getLayoutParams();
        FrameLayout.LayoutParams r29 = (FrameLayout.LayoutParams) this.H.getLayoutParams();
        if (r29 == null) goto L92;
        r29.gravity = 85;
        r29.bottomMargin = (r28.bottomMargin + this.v) + r28.height;
        r29.rightMargin = r28.rightMargin;
        r29.width = this.q - this.w;
        this.H.setLayoutParams(r29);
    L92:
        if (r1 != 0) goto L98;
        if (r27 != 0) goto L98;
        n r30 = this.k;
        if (r30 == null) goto L98;
        FrameLayout.LayoutParams r31 = (FrameLayout.LayoutParams) r30.getLayoutParams();
        r31.gravity = 8388693;
        r31.bottomMargin = r21;
        r31.rightMargin = r110;
        r31.width = this.p;
        r31.height = this.q;
        this.k.setLayoutParams(r31);
        goto L98
    L65:
        if (com.bytedance.android.live.liveinteract.utils.r.a() == false) goto L88;
        int r32 = 0;
    L68:
        if (r32 >= ((ArrayList) this.g).size()) goto L81;
        InteractAudienceAlertWindow r119 = (InteractAudienceAlertWindow) ListProtector.get(this.g, r32);
        if (r32 >= r27) goto L77;
        FrameLayout.LayoutParams r120 = (FrameLayout.LayoutParams) r119.getLayoutParams();
        if (r120 != null) goto L74;
        r120 = new FrameLayout.LayoutParams(this.p, this.q);
    L74:
        r120.gravity = 8388693;
        int r121 = this.r;
        int r33 = this.q;
        r120.bottomMargin = ((r32 + r1) * (r121 + r33)) + r21;
        r120.rightMargin = r110;
        r120.width = this.p;
        r120.height = r33;
        r119.setLayoutParams(r120);
        int r34 = -this.p;
        if (r119.c == true) goto L80;
        ValueAnimator r35 = ValueAnimator.ofInt(new int[]{r34, r110}).setDuration(300);
        r35.addUpdateListener(new lf0.b(r119));
        r35.setInterpolator(new com.bytedance.android.live.core.widget.e(0.25f, 0.1f, 0.25f, 0.1f));
        r35.start();
        r119.c = true;
    L80:
        r32 = r32 + 1;
        goto L68
    L77:
        ViewParent r36 = r119.getParent();
        FrameLayout r37 = this.c;
        if (r36 != r37) goto L80;
        r37.removeView(r119);
        goto L80
    L81:
        if (r27 < 0) goto L88;
        if (r27 >= ((ArrayList) this.g).size()) goto L88;
        int r38 = r27;
    L86:
        if (r38 >= ((ArrayList) this.g).size()) goto L88;
        ListProtector.remove(this.g, r38);
        r38 = r38 + 1;
        goto L86
    }

    public final void j() {
        Iterator<f> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        f r1 = r0.next();
        this.c.removeView(r1);
        goto L4
    L6:
        v(null);
        this.f.clear();
        ((HashMap) this.O).clear();
    }

    public final int r() {
        Iterator<f> r0 = this.f.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        f r2 = r0.next();
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2.getLayoutParams();
        if (r3 == null) goto L4;
        int r4 = r3.rightMargin;
        if (r4 != 0) goto L12;
        if (r3.leftMargin == 0) goto L12;
        r1 = Math.max(r1, UIUtils.getScreenWidth(r2.getContext()) - r3.leftMargin);
    L12:
        r1 = Math.max(r1, r3.width + r4);
        goto L4
    L13:
        return r1;
    }

    public final int s() {
        int r1 = 0;
        if (this.s != 0) goto L5;
        return 0;
    L5:
        if (this.t == 0) goto L12;
        int r0 = (s1.w() * this.s) / this.t;
        int r2 = (this.c.getWidth() - r0) / 2;
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(this.c.getContext(), this.C, false) == false) goto L10;
        r1 = s1.A() / 2;
    L10:
        return (r1 * (-1)) + r2;
    L12:
        return 0;
    }

    public final boolean t() {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.H2() == false) goto L9;
        if (this.C == true) goto L9;
        return true;
    }

    public final void A(boolean r2) {
        if (r2 != this.D) goto L5;
        return;
    L5:
        this.D = r2;
        j();
        this.c.removeView(this.m);
        this.c.removeView(this.H);
        this.s = 0;
        this.t = 0;
    }

    public final void f(f r4) {
        DataCenter r0 = this.F;
        if (r0 == null) goto L5;
        r4.setIsOpenSendGift(((Boolean) r0.get("data_intimate_chat_support_send_gift_to_linker", Boolean.FALSE)).booleanValue());
    L5:
        this.c.addView(r4);
        ((ArrayList) this.f).add(r4);
    }

    public final void i(boolean r7) {
        List<f> r0 = this.f;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        List<InteractAudienceAlertWindow> r3 = this.g;
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L17:
        if (this.a == false) goto L41;
        if (r2 == false) goto L41;
        if (r4 == false) goto L41;
        if (this.h == false) goto L41;
        if (this.j == true) goto L41;
        if (this.i == false) goto L27;
    L46:
        r1 = false;
    L47:
        if (r1 == false) goto L51;
        if (r7 == false) goto L52;
        h();
        return;
    L52:
        return;
    L51:
        return;
    L27:
        if (this.k != null) goto L47;
        n r5 = new n(getContext());
        this.k = r5;
        r5.setOnClickListener(new h(this));
        this.c.addView(this.k);
        this.i = true;
        com.bytedance.android.livesdk.chatroom.o r6 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        HashMap r8 = new HashMap();
        r8.put("function_type", ((IInteractService) jc1.k.f(IInteractService.class)).getCurrentFunctionType());
        if (r6 != null) goto L32;
    L39:
        j0.l().sendLog("livesdk_anchor_audience_connection_rechargeable_seat_show", r8, new Object[]{IRoom.class});
        goto L47
    L32:
        if (this.B == false) goto L35;
        String r9 = "anchor";
    L38:
        r8.put("user_type", r9);
        goto L39
    L35:
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() == 0) goto L37;
        r9 = "guest";
        goto L38
    L37:
        r9 = "user";
    L41:
        if (this.i == false) goto L46;
        n r10 = this.k;
        if (r10 == null) goto L47;
        this.c.removeView(r10);
        this.k = null;
        this.i = false;
        goto L47
    L12:
        if (((ArrayList) r3).isEmpty() == true) goto L15;
        r4 = false;
        goto L17
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final f o(String r6) {
        if (TextUtils.isEmpty("") == true) goto L5;
    L8:
        fe0.i r1 = this.x;
        ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r1.b.getGuestInfo("", r6);
        if (r2 != null) goto L11;
        ALogger.e("ttlive_link", "queryOnlineList get null  " + r6);
        r1.b.R4(false);
    L11:
        ge0.b r0 = r1.f("", r6);
        if (r0 != null) goto L14;
        r0 = new ie0.b(r1.a, r6, r2);
        ((ArrayList) r1.d).add(r0);
    L16:
        return new f(this.b, r0, this.F);
    L14:
        r0.i(r2);
        goto L16
    L5:
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return null;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getKey() != null) goto L7;
        return;
    L7:
        if (r5.getData() != null) goto L10;
        return;
    L10:
        if (TextUtils.equals(r5.getKey(), "data_link_state") == false) goto L34;
        int r6 = ((Integer) r5.getData(0)).intValue();
        if (v.a(r6, 4) == false) goto L14;
    L15:
        Iterator r7 = ((ArrayList) this.g).iterator();
    L17:
        if (r7.hasNext() == false) goto L23;
        InteractAudienceAlertWindow r0 = (InteractAudienceAlertWindow) r7.next();
        ViewParent r1 = r0.getParent();
        FrameLayout r2 = this.c;
        if (r1 != r2) goto L17;
        r2.removeView(r0);
        if (r0.getUser() == null) goto L17;
        int r3 = jf0.b.a;
        jf0.b.f(r0.getUser().getIdString(), PbRequest.SwitchType.PK);
        goto L17
    L23:
        ((ArrayList) this.g).clear();
        return;
    L14:
        if (v.a(r6, 64) == true) goto L15;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r7) {
        if (this.D == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<ILinkPlayerInfoBridge> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        ILinkPlayerInfoBridge r1 = r8.next();
        Iterator<f> r2 = this.f.iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        f r3 = r2.next();
        if (TextUtils.equals(r1.getInteractId(), r3.getPresenter().c()) == false) goto L10;
        r3.getPresenter().i(r1);
        r0.add(r3);
        this.f.remove(r3);
        goto L7
    L14:
        r0.addAll(this.f);
        this.f = r0;
        h();
        B();
    }

    @Override // md0.a.InterfaceC0236a
    public final void onSeiUpdated(SeiAppData r32) {
        if (this.D == true) goto L5;
        return;
    L5:
        if (this.A == false) goto L196;
        this.E = r32;
        String r7 = "InteractAudienceVideoWindowManager";
        if (this.z.getStreamType() == LiveMode.THIRD_PARTY) goto L10;
    L49:
        j();
        this.c.removeView(this.H);
        List r0 = r32.getGrids();
        if (r0 != null) goto L52;
    L156:
        this.G = 0;
        B();
        this.F.put("data_interact_audience_video_translation", Boolean.FALSE);
        return;
    L52:
        if (r0.size() < 1) goto L156;
        this.F.put("data_interact_audience_video_translation", Boolean.TRUE);
        int r3 = this.c.getWidth();
        int r8 = this.c.getHeight();
        int r9 = r32.getCanvas().getWidth();
        int r2 = r32.getCanvas().getHeight();
        String r10 = this.o.N4(this.z.getOwnerUserIdString());
        LiveMode r11 = this.z.getStreamType();
        Iterator r12 = r0.iterator();
        InteractAudienceVideoWindowManager r13 = this;
    L56:
        if (r12.hasNext() == false) goto L130;
        SeiRegion r14 = (SeiRegion) r12.next();
        if (r14 == null) goto L128;
        if (TextUtils.equals(r14.getInteractId(), r10) == true) goto L128;
        if (r14.getWidth() >= 1.0d) goto L56;
        if (TextUtils.equals(r14.getInteractId(), tc0.c.h().f) == true) goto L56;
        f r5 = r13.o(r14.getInteractId());
        if (r5 == null) goto L56;
        r13.u(r14.getInteractId(), r5);
        r13.f(r5);
        if (r11 != LiveMode.THIRD_PARTY) goto L115;
        int r15 = r0.indexOf(r14);
        com.bytedance.android.livesdk.chatroom.o r17 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        Rect r4 = new Rect();
        r13.c.getGlobalVisibleRect(r4);
        if (r17 != null) goto L75;
        ALogger.e(r7, "getOBSSeiLayoutParams roomContext is null");
    L81:
        Rect r6 = null;
        int r18 = 0;
    L82:
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(0, 0);
        if (r18 <= 0) goto L95;
        LiveMode r26 = r11;
        if (r13.C == false) goto L97;
        if (TextUtils.equals(r13.z.getAnchorAbValue("live_pc_helper_new_layout"), "1") == false) goto L89;
        int r19 = s1.f(106.0f);
        r16.gravity = 8388693;
        r16.bottomMargin = ((r13.r + s1.f(112.0f)) * r15) + r19;
        r16.rightMargin = s1.f(12.0f);
        r16.width = s1.f(112.0f);
        r16.height = s1.f(112.0f);
        r0 = r0;
        r5 = r5;
    L93:
        f r110 = r5;
    L127:
        f r1 = r110;
        r1.setLayoutParams(r16);
        r1.getPresenter().j(r14.getStatus());
        this.G++;
        r13 = this;
    L129:
        r3 = r3;
        r2 = r2;
        r7 = r7;
        r10 = r10;
        r12 = r12;
        r11 = r26;
        r0 = r0;
        goto L56
    L89:
        float r20 = r9;
        int r21 = (int) ((r3 * r2) / r20);
        float r111 = r3 / r20;
        float r112 = r2;
        float r113 = r21 / r112;
        if (r111 > r113) goto L92;
        r111 = r113;
    L92:
        float r114 = r112 * r111;
        double r115 = r20 * r111;
        r0 = r0;
        int r22 = (int) (r115 * ((1.0d - r14.getX()) - r14.getWidth()));
        double r116 = r114;
        r5 = r5;
        int r23 = (int) (r116 * ((1.0d - r14.getY()) - r14.getHeight()));
        int r24 = (int) ((r115 * r14.getWidth()) + 0.5d);
        int r117 = (int) ((r116 * r14.getHeight()) + 0.5d);
        r16.width = r24;
        r16.height = r117;
        r16.rightMargin = r22;
        r16.bottomMargin = r23 + ((r8 - r21) - r18);
        r16.gravity = 85;
    L97:
        if (r13.C == false) goto L103;
        float r25 = r9;
        float r27 = r3 / r25;
        float r28 = r2;
        float r29 = r8 / r28;
        if (r27 > r29) goto L101;
        r27 = r29;
    L101:
        float r30 = r28 * r27;
        double r31 = r25 * r27;
        int r33 = (int) (((1.0d - r14.getX()) - r14.getWidth()) * r31);
        double r118 = r30;
        int r34 = (int) (r118 * ((1.0d - r14.getY()) - r14.getHeight()));
        int r35 = (int) ((r31 * r14.getWidth()) + 0.5d);
        int r36 = (int) ((r118 * r14.getHeight()) + 0.5d);
        r16.width = r35;
        r16.height = r36;
        r16.rightMargin = r33;
        r16.bottomMargin = r34;
        r16.gravity = 85;
        goto L93
    L103:
        if (TextUtils.equals(r13.z.getAnchorAbValue("live_pc_helper_new_layout"), "1") == false) goto L109;
        int r37 = s1.f(62.0f);
        if (t() == false) goto L107;
        float r38 = 56.0f;
    L108:
        int r39 = s1.f(r38);
        r16.gravity = 8388691;
        r16.bottomMargin = ((r13.r + s1.f(112.0f)) * r15) + r37;
        r16.leftMargin = r39;
        r16.width = s1.f(112.0f);
        r16.height = s1.f(112.0f);
        goto L93
    L107:
        r38 = 85.0f;
        goto L108
    L109:
        int r40 = s1.w();
        double r119 = (int) (((double) (r40 * r9)) / ((double) r2));
        int r41 = (int) (((1.0d - r14.getX()) - r14.getWidth()) * r119);
        double r120 = r40;
        r110 = r5;
        int r42 = (int) (r120 * ((1.0d - r14.getY()) - r14.getHeight()));
        int r43 = (int) ((r119 * r14.getWidth()) + 0.5d);
        int r121 = (int) ((r120 * r14.getHeight()) + 0.5d);
        if (r6 == null) goto L112;
        int r44 = r4.right - r6.right;
    L113:
        r16.width = r43;
        r16.height = r121;
        r16.rightMargin = r41 + r44;
        r16.bottomMargin = r42;
        r16.gravity = 85;
        goto L127
    L112:
        r44 = 0;
        goto L113
    L95:
        r26 = r11;
        goto L97
    L75:
        if (r17.m2() != null) goto L77;
    L79:
        ALogger.e(r7, "getOBSSeiLayoutParams roomUISizeGetter is null");
        goto L81
    L77:
        if (r17.m2().getValue() == null) goto L79;
        m0 r45 = (m0) r17.m2().getValue();
        r18 = r45.b();
        r6 = r45.a();
        goto L82
    L115:
        r0 = r0;
        r110 = r5;
        r7 = r7;
        r26 = r11;
        r16 = new FrameLayout.LayoutParams(0, 0);
        float r46 = r3;
        float r47 = r9;
        float r48 = r46 / r47;
        float r49 = r8;
        float r50 = r2;
        float r122 = r49 / r50;
        if (r48 > r122) goto L118;
        r48 = r122;
    L118:
        float r123 = r47 * r48;
        float r51 = r48 * r50;
        if (PadConfigUtils.c() == true) goto L123;
        if (FoldScreenUtils.e() == true) goto L123;
    L125:
        float r52 = 0.0f;
        r49 = r51;
        float r53 = 0.0f;
    L126:
        double r124 = r123;
        int r54 = (int) ((((1.0d - r14.getX()) - r14.getWidth()) * r124) + ((double) r52));
        double r55 = r49;
        int r56 = (int) (((1.0d - r14.getY()) - r14.getHeight()) * r55);
        int r57 = (int) (((r124 * r14.getWidth()) + 0.5d) + ((double) r53));
        int r58 = (int) ((r55 * r14.getHeight()) + 0.5d);
        r16.width = r57;
        r16.height = r58;
        r16.rightMargin = r54;
        r16.bottomMargin = r56;
        r16.gravity = 85;
    L123:
        if (s1.x() >= s1.z()) goto L125;
        r123 = (r47 * r49) / r50;
        r52 = ((r46 - r123) / 2.0f) - s1.f(7.0f);
        r53 = s1.f(6.0f);
    L128:
        r0 = r0;
        r2 = r2;
        r3 = r3;
        r7 = r7;
        r10 = r10;
        r26 = r11;
        r12 = r12;
        goto L129
    L130:
        List r210 = r0;
        LiveMode r211 = r11;
        Iterator r59 = r210.iterator();
    L132:
        if (r59.hasNext() == false) goto L136;
        if (TextUtils.equals(((SeiRegion) r59.next()).getInteractId(), r13.o.N4(jc1.k.f(IMiddlewareUserService.class).user().n())) == false) goto L132;
        boolean r60 = true;
    L137:
        if (r60 == false) goto L139;
    L150:
        B();
        if (r13.G <= 0) goto L153;
        boolean r61 = true;
        j0.l().sendLog("guest_connection_transform", null, new Object[]{new x(), IRoom.class});
    L154:
        r13.i(r61);
        return;
    L153:
        r61 = true;
        goto L154
    L139:
        if (r210.size() != 1) goto L150;
        if (CollectionUtils.isEmpty(r13.f) == true) goto L150;
        FrameLayout.LayoutParams r62 = (FrameLayout.LayoutParams) ((f) ListProtector.get(r13.f, 0)).getLayoutParams();
        FrameLayout.LayoutParams r63 = new FrameLayout.LayoutParams(0, 0);
        r63.height = r13.v;
        r63.width = r62.width - r13.w;
        if (t() == false) goto L146;
        r63.leftMargin = s1.f(56.0f);
        r63.bottomMargin = (r62.bottomMargin + r13.u) + r62.height;
        r63.gravity = 83;
    L149:
        r13.c.addView(r13.H, r63);
        goto L150
    L146:
        if (r211 != LiveMode.THIRD_PARTY) goto L148;
        r63.rightMargin = r62.rightMargin;
        r63.bottomMargin = (r62.bottomMargin + r13.u) + r62.height;
        r63.gravity = 85;
        goto L149
    L148:
        r63.rightMargin = r62.rightMargin;
        r63.bottomMargin = (r62.bottomMargin + r13.u) + r62.height;
        r63.gravity = 85;
        goto L149
    L136:
        r60 = false;
        goto L137
    L10:
        if (this.z.getStreamUrlExtraSafely().getHeightFlex() >= this.z.getStreamUrlExtraSafely().getWidthFlex()) goto L49;
        if (r32.getGrids().size() != ((ArrayList) this.f).size()) goto L45;
        Iterator r65 = r32.getGrids().iterator();
    L16:
        if (r65.hasNext() == false) goto L46;
        SeiRegion r66 = (SeiRegion) r65.next();
        Iterator r67 = ((ArrayList) this.f).iterator();
    L19:
        if (r67.hasNext() == false) goto L23;
        f r68 = (f) r67.next();
        if (TextUtils.equals(r68.getPresenter().c(), r66.getInteractId()) == false) goto L19;
        boolean r69 = true;
    L24:
        if (r69 == false) goto L45;
        if ((r68.getChildAt(0) instanceof com.bytedance.android.live.liveinteract.widget.widget.f) == false) goto L16;
        if (r66.isTalking() == false) goto L16;
        ILinkPlayerInfoBridge r70 = (ILinkPlayerInfoBridge) this.o.getGuestInfo("", r66.getInteractId());
        if (r70 == null) goto L42;
        if (com.bytedance.android.live.liveinteract.plantform.model.n.f(r70) == false) goto L42;
        ((com.bytedance.android.live.liveinteract.widget.widget.f) r68.getChildAt(0)).c((String) ListProtector.get(r70.getMicDress().getVoiceWave().getMediumImg().getUrls(), 0));     // Catch: Exception -> L35
    L35:
        e = move-exception;
        if ((e instanceof ArrayIndexOutOfBoundsException) == true) goto L38;
        if ((e instanceof NullPointerException) == false) goto L16;
        ALogger.e("InteractAudienceVideoWindowManager", "mediumImg/mUrls is null");
        goto L16
    L38:
        ALogger.e("InteractAudienceVideoWindowManager", "mUrls is empty");
    L42:
        com.bytedance.android.live.liveinteract.widget.widget.f r71 = (com.bytedance.android.live.liveinteract.widget.widget.f) r68.getChildAt(0);
        r71.getClass();
        r71.b = vm2.d.a0().unkownMediaAnim;
        if (r71.a(2131389454).getVisibility() != 8) goto L16;
        r71.a(2131389454).setVisibility(0);
        r71.b(r71.b);
        goto L16
    L23:
        r69 = false;
        r68 = null;
        goto L24
    L46:
        boolean r72 = true;
    L47:
        if (r72 == false) goto L49;
        return;
    L45:
        r72 = false;
        goto L47
    }

    public final void v(String r4) {
        Map r0 = (Map) this.F.get("cmd_interact_link_window_change", new HashMap());
        if (r4 != null) goto L5;
        r0.clear();
    L8:
        this.F.put("cmd_interact_link_window_change", r0);
        return;
    L5:
        IBaseUser r5 = this.o.U4(r4);
        if (r5 == null) goto L8;
        r0.remove(r5.getIdString());
        goto L8
    }

    public final void x(f r2) {
        if (r2 != this.n) goto L5;
        this.n = null;
    L5:
        this.c.removeView(r2);
        this.f.remove(r2);
        h();
        B();
    }

    public final void y(DataCenter r3) {
        this.F = r3;
        if (r3 == null) goto L6;
        r3.observe("data_intimate_chat_support_send_gift_to_linker", this.Q);
        this.F.observe("data_support_send_gift_to_official_channel_host", this.Q);
        this.F.observe("data_interact_audience_video_translation", this.Q);
        this.C = ((Boolean) this.F.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        return;
    }

    public final void z(boolean r7) {
        xs2.b.a().post(new kd0.a(true, r()));
        this.D = r7;
        this.A = true;
        TextView r8 = (TextView) LayoutInflater.from(this.c.getContext()).inflate(2131567726, this.c, false);
        this.e = r8;
        r8.setVisibility(4);
        this.c.addView(this.e);
        fe0.i r9 = this.x;
        r9.b.Q4(r9);
        hd0.c.f().c(this.P);
        B();
        this.c.addOnLayoutChangeListener(this.R);
        this.G = 0;
        this.w = (int) UIUtils.dip2Px(this.c.getContext(), 1.0f);
        this.u = (int) UIUtils.dip2Px(this.c.getContext(), 8.0f);
        this.v = (int) UIUtils.dip2Px(this.c.getContext(), 32.0f);
        this.H = View.inflate(this.c.getContext(), 2131567933, null);
        if (rf2.a.a() == false) goto L5;
        this.H.setVisibility(8);
    L5:
        this.J = this.H.findViewById(2131363184);
        this.I = (TextView) this.H.findViewById(2131363197);
        r3.c(this.H, s1.B(2131919228), true);
        this.H.setOnClickListener(new m());
        this.F.observeForever("data_link_state", this);
        com.bytedance.android.live.core.utils.rxutils.j.a r10 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.M = com.bytedance.android.live.core.utils.rxutils.j.a(0, 1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this));
        this.j = ((Boolean) this.F.get("data_interact_audience_video_translation", Boolean.FALSE)).booleanValue();
        i(true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void a(String r9, String r10) {
        if (this.D == false) goto L5;
        return;
    L5:
        if (this.A == false) goto L51;
        final f r11 = q(r9, r10);
        if (r11 != null) goto L10;
        return;
    L10:
        ((HashMap) this.O).remove(r10);
        String r0 = this.z.getBaseOwner().getIdString();
        if (r11.getPresenter() != null) goto L13;
    L26:
        long r1 = 0;
    L28:
        if (r1 > 0) goto L30;
    L47:
        x(r11);
        i(true);
    L48:
        v(r10);
        return;
    L30:
        if (this.B == false) goto L47;
        HSImageView r2 = r11.h;
        if (r2 == null) goto L34;
        r2.setVisibility(r11.getVisibility());
    L34:
        HSImageView r3 = r11.h;
        ge0.b r4 = r11.s;
        if (r4 == null) goto L39;
        IBaseUser r5 = r4.e();
        if (r5 == null) goto L39;
        py.k r6 = r5.getAvatarMedium();
    L40:
        ImageLoader.bindImage(r3, r6, new l3(15));
        View r7 = r11.g;
        if (r7 == null) goto L43;
        r7.setVisibility(0);
    L43:
        TextView r8 = r11.i;
        if (r8 == null) goto L46;
        r8.setText(String.valueOf(r1));
    L46:
        this.N = Observable.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r11));
    L39:
        r6 = null;
        goto L40
    L13:
        if (r0.equals(r11.getPresenter().f()) == true) goto L26;
        ILinkPlayerInfoBridge r12 = r11.getPresenter().d();
        if (r12 == null) goto L26;
        if (r12.getUser() == null) goto L26;
        if (((ArrayList) this.L).contains(r12.getUser().getIdString()) == false) goto L22;
        ((ArrayList) this.L).clear();
    L25:
        r1 = r12.getPaidCount();
        goto L28
    L22:
        if (r12.isAnonymous() == false) goto L24;
        f2.c(s1.B(2131919225), 0);
        goto L25
    L24:
        FragmentActivity r13 = this.b;
        IESUIUtils.displayToast(r13, r13.getString(2131919329, new Object[]{r12.getUser().getNickName()}));
        goto L25
    }

    @Override // md0.a.InterfaceC0236a
    public final boolean isVersionSupported(int r1, int r2) {
        if (this.D == true) goto L5;
    L7:
        return false;
    L5:
        if (r1 != 1) goto L7;
        return true;
    }

    public final int m(boolean r1, boolean r2) {
        if (r1 == true) goto L8;
        if (r2 == true) goto L8;
        float r3 = UIUtils.dip2Px(this.b, 60.0f);
    L7:
        return (int) r3;
    L8:
        r3 = UIUtils.dip2Px(this.b, 52.0f);
        goto L7
    }

    public final f q(String r4, String r5) {
        Iterator<f> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        f r1 = r0.next();
        if (r4 == null) goto L11;
        if (r4.equals(r1.getPresenter().f()) == false) goto L11;
        return r1;
    L11:
        if (TextUtils.isEmpty(r5) == true) goto L4;
        if (TextUtils.equals(r1.getPresenter().c(), r5) == false) goto L4;
        return r1;
    L15:
        return null;
    }

    public final void u(String r4, f r5) {
        IBaseUser r6 = this.o.U4(r4);
        Map r0 = (Map) this.F.get("cmd_interact_link_window_change", new HashMap());
        if (r6 != null) goto L5;
        String r7 = "";
    L6:
        r0.put(r7, r5);
        this.F.put("cmd_interact_link_window_change", r0);
        return;
    L5:
        r7 = r6.getIdString();
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void n(List<ILinkPlayerInfoBridge> r2, long r3, n0 r5) {
        if (this.B == false) goto L5;
    L6:
        String r4 = "";
        if (Lists.isEmpty(r2) == false) goto L10;
        this.F.put("data_interact_number_dot_show", "");
        return;
    L10:
        if (this.B == false) goto L14;
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() == null) goto L17;
        int r6 = ((ArrayList) com.bytedance.android.live.liveinteract.plantform.base.d.a.a().getLinkUserCenter().V4()).size();
    L19:
        if (r6 > 99) goto L21;
        r6 = r6 + fj0.e.a();
    L21:
        String r0 = String.valueOf(r6);
        if (r6 <= 99) goto L24;
        r0 = "99+";
    L24:
        if (r6 <= 0) goto L27;
        r4 = r0;
    L27:
        this.F.put("data_interact_number_dot_show", r4);
        return;
    L17:
        r6 = 0;
        goto L19
    L14:
        com.bytedance.android.live.liveinteract.plantform.base.c.i0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.c.a.a() == null) goto L17;
        r6 = ((ArrayList) com.bytedance.android.live.liveinteract.plantform.base.c.a.a().getLinkUserCenter().V4()).size();
        goto L19
    L5:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == true) goto L6;
    }

    public final void w(String r8, View r9, int r10, int r11) {
        if (this.D == false) goto L5;
        return;
    L5:
        if (this.A == true) goto L8;
        return;
    L8:
        if (TextUtils.equals(r8, tc0.c.h().e) == false) goto L45;
        this.s = r10;
        this.t = r11;
        if (this.C == false) goto L24;
        if (r11 < r10) goto L15;
        if (this.z.isThirdParty() == true) goto L15;
    L18:
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -1);
    L40:
        r9.setLayoutParams(r12);
        this.c.removeView(this.m);
        if ((r9 instanceof SurfaceView) == false) goto L43;
        SurfaceView r13 = (SurfaceView) r9;
        this.m = r13;
        r13.setZOrderMediaOverlay(false);
    L43:
        this.m.setVisibility(0);
        this.c.addView(this.m, 0);
        this.d = LayoutInflater.from(this.c.getContext()).inflate(2131565142, null);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-1, -1);
        this.d.setLayoutParams(r14);
        this.c.addView(this.d);
        this.d.setVisibility(8);
        return;
    L15:
        if (this.z.isThirdParty() == true) goto L17;
    L19:
        int r15 = s1.y();
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(r15, (r11 * r15) / r10);
        com.bytedance.android.livesdk.chatroom.o r17 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r17 == null) goto L22;
        int r18 = ((m0) r17.m2().getValue()).b();
    L23:
        r16.topMargin = r18;
        r12 = r16;
        goto L40
    L22:
        r18 = 0;
        goto L23
    L17:
        if (this.z.getStreamUrlExtraSafely().getHeightFlex() < this.z.getStreamUrlExtraSafely().getWidthFlex()) goto L19;
    L24:
        int r19 = this.c.getMeasuredWidth();
        int r3 = this.c.getMeasuredHeight();
        if (r3 == 0) goto L39;
        if (r19 == 0) goto L39;
        if (r10 == 0) goto L39;
        if (r11 == 0) goto L39;
        r12 = new FrameLayout.LayoutParams((r3 * r10) / r11, -1);
        r12.gravity = 1;
        if (t() == false) goto L34;
        int r110 = 0;
    L38:
        r12.leftMargin = r110;
        goto L40
    L34:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(this.c.getContext(), this.C, false) == false) goto L36;
        int r111 = s1.A() / 2;
    L37:
        r110 = r111 * (-1);
        goto L38
    L36:
        r111 = 0;
    L39:
        r12 = new FrameLayout.LayoutParams(-1, -1);
        goto L40
    L45:
        f r112 = q("", r8);
        if (r112 == null) goto L48;
        v(r8);
        x(r112);
    L48:
        f r113 = o(r8);
        if (r113 != null) goto L52;
        return;
    L52:
        if (this.B == false) goto L54;
    L56:
        if (r9 == null) goto L61;
        r9.setLayoutParams(new FrameLayout.LayoutParams(this.p, this.q));
        if ((r9 instanceof SurfaceView) == false) goto L60;
        ((SurfaceView) r9).setZOrderMediaOverlay(true);
    L60:
        r113.a(r9);
    L61:
        IBaseUser r20 = this.o.U4(r8);
        Iterator r114 = ((ArrayList) this.g).iterator();
    L63:
        if (r114.hasNext() == false) goto L71;
        InteractAudienceAlertWindow r0 = (InteractAudienceAlertWindow) r114.next();
        if (r20 == null) goto L63;
        if (r0.getUser() == null) goto L63;
        if (r0.getUser().getIdString().equals(r20.getIdString()) == false) goto L63;
        r114.remove();
        r0.b();
        goto L63
    L71:
        u(r8, r113);
        f(r113);
        if (this.B == true) goto L74;
    L76:
        onOnlineListChanged(this.o.getOnlineUserList());
        i(true);
        return;
    L74:
        if (com.bytedance.android.live.liveinteract.utils.r.a() == false) goto L76;
        r113.c();
        goto L76
    L54:
        if (TextUtils.equals(r8, tc0.c.h().f) == false) goto L56;
        this.n = r113;
        goto L56
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.live.liveinteract.interact.audience.i] */
    public InteractAudienceVideoWindowManager(IRoom r4, boolean r5, FrameLayout r6, y r7, FragmentActivity r8, LifecycleOwner r9) {
        this.a = true;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = null;
        this.C = false;
        this.D = true;
        this.G = 0;
        this.L = new ArrayList();
        this.O = new HashMap();
        this.P = new a(this);
        this.Q = new i(this);
        this.R = new b(this);
        this.b = r8;
        this.z = r4;
        this.B = r5;
        this.c = r6;
        this.o = r7;
        r7.Q4(this);
        this.y = new com.bytedance.android.live.liveinteract.api.utils.j(this);
        this.K = r9;
        this.x = new fe0.i(r4, r7, this);
        Resources r10 = r8.getResources();
        this.p = r10.getDimensionPixelSize(2131168809);
        this.q = r10.getDimensionPixelSize(2131168808);
        this.r = (int) UIUtils.dip2Px(r8, 4.0f);
    }
}
