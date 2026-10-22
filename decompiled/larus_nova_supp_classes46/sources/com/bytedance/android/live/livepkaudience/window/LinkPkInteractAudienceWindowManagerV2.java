package com.bytedance.android.live.livepkaudience.window;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.base.j;
import com.bytedance.android.live.livepkaudience.base.q;
import com.bytedance.android.live.livepkaudience.base.w;
import com.bytedance.android.live.livepkaudience.base.y;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.seat.PkSeatAnimationView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.hh0;
import com.bytedance.android.livesdk.config.jh0;
import com.bytedance.android.livesdk.config.vh0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.n7;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import dl0.n;
import el0.g;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import uf2.d0;
import uf2.m1;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006:\u0001\tR$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/window/LinkPkInteractAudienceWindowManagerV2;", "Lcom/bytedance/android/live/livepkaudience/base/y;", "Lcom/bytedance/android/live/livepkaudience/base/j;", "Lel0/a$a;", "Lel0/f$a;", "Lcom/bytedance/android/live/liveinteract/animation/e;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "activity", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LinkPkInteractAudienceWindowManagerV2 extends y implements j, el0.a.InterfaceC0204a, el0.f.a, com.bytedance.android.live.liveinteract.animation.e, Observer<KVData> {
    public static final /* synthetic */ int T = 0;
    public com.bytedance.android.live.livepkaudience.rtc.a A;
    public String B;
    public String C;
    public int D;
    public int E;
    public final com.bytedance.android.live.livepkaudience.seat.f F;
    public final lc0.d G;
    public final lc0.c H;
    public final d I;
    public final c J;
    public final e K;
    public final f L;
    public final FrameLayout M;
    public final i N;
    public final LifecycleOwner O;
    public final View P;
    public final xk0.b Q;
    public final q R;
    public final LinkPkInteractGuestDataContext S;
    public final FragmentActivity a;
    public final FrameLayout b;
    public List<el0.a> c;
    public final List<el0.a> d;
    public final List<View> e;
    public final List<z.a> f;
    public el0.a g;
    public final i h;
    public Room i;
    public boolean j;
    public View.OnClickListener k;
    public String l;
    public final Map<String, z.a> m;
    public el0.f n;
    public final w o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public SeiAppData t;
    public DataCenter u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LinkPkInteractAudienceWindowManagerV2 a;

        public b(LinkPkInteractAudienceWindowManagerV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            View.OnClickListener r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAudienceWindowManagerV2 a;

        public c(LinkPkInteractAudienceWindowManagerV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            KVData r7 = (KVData) r6;
            LinkPkInteractAudienceWindowManagerV2 r0 = this.a;
            int r1 = LinkPkInteractAudienceWindowManagerV2.T;
            r0.getClass();
            int r2 = ((IInteractService) k.n(IInteractService.class)).getLinkMode();
            Boolean r3 = null;
            if (r7 == null) goto L5;
            String r4 = r7.getKey();
        L7:
            if (Intrinsics.areEqual("data_intimate_chat_support_send_gift_to_linker", r4) == true) goto L9;
        L10:
            if (r7 == null) goto L12;
            String r5 = r7.getKey();
        L14:
            if (Intrinsics.areEqual("data_big_party_support_send_gift_to_linker", r5) == true) goto L16;
            return;
        L16:
            if (v.a(r2, 32) == false) goto L25;
        L17:
            if (r7 == null) goto L19;
            r3 = (Boolean) r7.getData(Boolean.FALSE);
        L19:
            boolean r8 = Intrinsics.areEqual(r3, Boolean.TRUE);
            Iterator<el0.a> r9 = r0.c.iterator();
        L21:
            if (r9.hasNext() == false) goto L26;
            r9.next().setIsOpenSendGift(r8);
            goto L21
        L26:
            return;
        L25:
            return;
        L12:
            r5 = null;
            goto L14
        L9:
            if (v.a(r2, 2) == true) goto L17;
        L5:
            r4 = null;
            goto L7
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ LinkPkInteractAudienceWindowManagerV2 a;

        public d(LinkPkInteractAudienceWindowManagerV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (r5 == r9) goto L9;
            LinkPkInteractAudienceWindowManagerV2 r10 = this.a;
            SeiAppData r11 = r10.t;
            if (r11 == null) goto L11;
            if (r11 == null) goto L10;
            r10.onSeiUpdated(r11);
            return;
        L10:
            return;
        L11:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAudienceWindowManagerV2 a;

        public e(LinkPkInteractAudienceWindowManagerV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            RevPkState r8 = (RevPkState) r7;
            LinkPkInteractAudienceWindowManagerV2 r0 = this.a;
            int r1 = LinkPkInteractAudienceWindowManagerV2.T;
            r0.getClass();
            if (r8 != RevPkState.PK) goto L16;
            LinkPkInteractGuestDataContext r9 = r0.S;
            if (r9 == null) goto L10;
            m<Long> r10 = r9.getHasAudienceOnlineTime();
            if (r10 == null) goto L10;
            if (((Number) r10.getValue()).longValue() != 0) goto L10;
            return;
        L10:
            LinkPkInteractGuestDataContext r11 = r0.S;
            if (r11 == null) goto L30;
            m<Long> r12 = r11.getHasAudienceOnlineTime();
            if (r12 == null) goto L31;
            r12.setValue(Long.valueOf(System.currentTimeMillis()));
            return;
        L31:
            return;
        L30:
            return;
        L16:
            if (r8 != RevPkState.PENAL) goto L33;
            LinkPkInteractGuestDataContext r13 = r0.S;
            if (r13 == null) goto L23;
            m<Long> r14 = r13.getHasAudienceOnlineTime();
            if (r14 == null) goto L23;
            if (((Number) r14.getValue()).longValue() != 0) goto L23;
            return;
        L23:
            LinkPkInteractGuestDataContext r15 = r0.S;
            if (r15 == null) goto L35;
            m<Long> r16 = r15.getHasAudienceOnlineTime();
            if (r16 == null) goto L36;
            r16.setValue(Long.valueOf(System.currentTimeMillis()));
            return;
        L36:
            return;
        L35:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAudienceWindowManagerV2 a;

        public f(LinkPkInteractAudienceWindowManagerV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            Long r10 = (Long) r9;
            LinkPkInteractAudienceWindowManagerV2 r0 = this.a;
            int r1 = LinkPkInteractAudienceWindowManagerV2.T;
            r0.getClass();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.longValue() != 1) goto L45;
            int r11 = el0.d.a[r0.G.d().ordinal()];
            Long r3 = null;
            if (r11 != 1) goto L9;
            LinkPkInteractGuestDataContext r12 = r0.S;
            if (r12 == null) goto L32;
            m<Long> r13 = r12.getHasAudienceOnlineTime4Pk();
            if (r13 == null) goto L32;
            Long r14 = (Long) r13.getValue();
        L33:
            long r4 = r14.longValue();
            LinkPkInteractGuestDataContext r15 = r0.S;
            if (r15 == null) goto L49;
            m<Long> r16 = r15.getHasAudienceOnlineTime4Pk();
            if (r16 == null) goto L50;
            long r5 = r4 + System.currentTimeMillis();
            LinkPkInteractGuestDataContext r2 = r0.S;
            if (r2 == null) goto L42;
            m<Long> r6 = r2.getHasAudienceOnlineTime();
            if (r6 == null) goto L42;
            r3 = (Long) r6.getValue();
        L42:
            r16.setValue(Long.valueOf((r5 - r3.longValue()) / ((long) 1000)));
            return;
        L50:
            return;
        L49:
            return;
        L32:
            r14 = null;
            goto L33
        L9:
            if (r11 != 2) goto L51;
            LinkPkInteractGuestDataContext r17 = r0.S;
            if (r17 == null) goto L16;
            m<Long> r18 = r17.getHasAudienceOnlineTime4Penalty();
            if (r18 == null) goto L16;
            Long r19 = (Long) r18.getValue();
        L17:
            long r7 = r19.longValue();
            LinkPkInteractGuestDataContext r20 = r0.S;
            if (r20 == null) goto L46;
            m<Long> r21 = r20.getHasAudienceOnlineTime4Penalty();
            if (r21 == null) goto L47;
            long r8 = r7 + System.currentTimeMillis();
            LinkPkInteractGuestDataContext r22 = r0.S;
            if (r22 == null) goto L26;
            m<Long> r23 = r22.getHasAudienceOnlineTime();
            if (r23 == null) goto L26;
            r3 = (Long) r23.getValue();
        L26:
            r21.setValue(Long.valueOf((r8 - r3.longValue()) / ((long) 1000)));
            return;
        L47:
            return;
        L46:
            return;
        L16:
            r19 = null;
            goto L17
        L51:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Ed(int r1) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final ArrayList Ka(int r1, float r2) {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Pf(int r1) {
        return true;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void b(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "userId");
    }

    @Override // el0.f.a
    public final void d() {
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final ArrayList dm(int r1) {
        return null;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void f(String r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r1, "userId");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final q50.b jq() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean lo(int r1) {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean si() {
        return false;
    }

    public final void B() {
        SurfaceView r0 = this.Q.q1();
        if (r0 != null) goto L5;
        return;
    L5:
        FrameLayout r1 = this.b;
        if (r1 != null) goto L8;
    L9:
        FrameLayout r2 = this.b;
        if (r2 == null) goto L14;
        r2.removeView(r0);
        return;
    L14:
        return;
    L8:
        if (r1.indexOfChild(r0) != (-1)) goto L9;
    }

    public final void l() {
        int r0 = ((ArrayList) this.c).size();
        if (this.q == false) goto L86;
        q();
        DataCenter r1 = this.u;
        int r2 = 0;
        if (r1 == null) goto L9;
        Integer r3 = (Integer) r1.get("data_pk_ui_change", 0);
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        int r5 = 0;
        int r6 = 0;
    L11:
        boolean r7 = true;
        String r8 = null;
        if (r5 >= r0) goto L60;
        el0.a r9 = (el0.a) ListProtector.get(this.c, r5);
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L58;
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10;
        r11.gravity = 48;
        int r12 = this.x + this.v;
        if (this.s == false) goto L18;
        int r13 = this.w;
    L19:
        r11.topMargin = r12 - r13;
        g r14 = r9.getPresenter();
        if (r14 == null) goto L23;
        String r15 = r14.c();
        if (r15 == null) goto L23;
    L24:
        i r16 = this.h;
        if ((r16 instanceof i) == false) goto L52;
        String r17 = "0";
        if (r16 == null) goto L29;
        LinkPlayerInfo r18 = r16.o("0", r15);
    L30:
        i r19 = this.h;
        if (r19 == null) goto L33;
        r7 = r19.v(r15);
    L33:
        i r110 = this.h;
        if (r110 == null) goto L36;
        r8 = r110.r(r15);
    L36:
        i r20 = this.h;
        if (r20 == null) goto L51;
        if (r8 == null) goto L41;
        r17 = r8;
    L41:
        int r21 = r20.O4(r17);
        if (r7 == false) goto L44;
        int r22 = r21 + 1;
        r6 = r6 + 1;
    L45:
        if (r18 == null) goto L49;
        boolean r23 = r9.getMIsBackGround();
        boolean r111 = r18.isBackground;
        if (r23 == r111) goto L49;
        r9.B3(!r111);
        r9.setMIsBackGround(r18.isBackground);
    L49:
        r9.setIsSelfRoomWindow(!r7);
    L53:
        r11.leftMargin = ((this.y / 2) * r22) + Math.max(0, r4);
        int r24 = this.y / 2;
        r11.width = r24;
        if (this.s == false) goto L56;
        r24 = this.w;
    L56:
        r11.height = r24;
        r9.setLayoutParams(r11);
        r5 = r5 + 1;
        goto L11
    L44:
        r22 = r21 - 1;
        goto L45
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L29:
        r18 = null;
        goto L30
    L52:
        r22 = 0;
    L23:
        r15 = "";
        goto L24
    L18:
        r13 = this.y / 2;
        goto L19
    L58:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L60:
        if (this.s == false) goto L62;
    L71:
        int r25 = ((ArrayList) this.d).size();
    L72:
        if (r2 >= r25) goto L95;
        el0.a r26 = (el0.a) ListProtector.get(this.d, r2);
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if ((r27 instanceof FrameLayout.LayoutParams) == true) goto L76;
        r27 = null;
    L76:
        FrameLayout.LayoutParams r28 = (FrameLayout.LayoutParams) r27;
        if (r28 == null) goto L83;
        int r29 = this.x + this.v;
        if (this.s == false) goto L81;
        int r30 = this.w;
    L82:
        r28.topMargin = r29 - r30;
        goto L83
    L81:
        r30 = this.y / 2;
    L83:
        if (r28 == null) goto L85;
        r26.setLayoutParams(r28);
    L85:
        r2 = r2 + 1;
        goto L72
    L95:
        return;
    L62:
        if (n.b() == false) goto L67;
        if (r6 == 0) goto L66;
        r7 = false;
    L66:
        i(r7, "adjustGuestWindow");
        goto L71
    L67:
        if (r6 == 0) goto L70;
        r7 = false;
    L70:
        j(r7);
    L9:
        r4 = 0;
        goto L10
    }

    public final void m() {
        Iterator<el0.a> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        el0.a r1 = r0.next();
        this.b.removeView(r1);
        goto L4
    L6:
        Iterator r2 = ((ArrayList) this.e).iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        View r3 = (View) r2.next();
        ViewParent r4 = this.b.getParent();
        if ((r4 instanceof ViewGroup) == true) goto L12;
        r4 = null;
    L12:
        ViewGroup r5 = (ViewGroup) r4;
        if (r5 == null) goto L8;
        r5.removeView(r3);
        goto L8
    L15:
        ((ArrayList) this.e).clear();
        ((ArrayList) this.f).clear();
        this.c.clear();
        ((LinkedHashMap) this.m).clear();
    }

    public final String p() {
        String r0 = this.H.a();
        if (q0.a(r0) == true) goto L13;
        lc0.d r1 = k.n(ILinkServiceExternal.class).getPkService();
        String r2 = null;
        if (r1 == null) goto L7;
        User r3 = r1.C();
    L8:
        o0.a r4 = o0.a;
        if (r3 == null) goto L11;
        r2 = r3.getIdStr();
    L11:
        r4.getClass();
        return o0.a.i(r2);
    L7:
        r3 = null;
        goto L8
    L13:
        return r0;
    }

    public final void q() {
        oq2.d r0 = k.n(ILinkServiceExternal.class).getPkService().G();
        this.x = r0.a;
        this.v = r0.c;
        this.y = r0.b;
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L12;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L12;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L12;
        if (LiveInitSettingKeys.get_LIVE_PLAYER_LAYOUT_V1_ENABLE() == true) goto L12;
        this.x -= StatusBarUtil.getStatusBarHeight(this.M.getContext());
    L12:
        if (this.s == false) goto L14;
        return;
    L14:
        if (n.b() == false) goto L36;
        SurfaceView r1 = this.Q.q1();
        Integer r2 = null;
        if (r1 == null) goto L18;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L20:
        if ((r3 instanceof FrameLayout.LayoutParams) == true) goto L22;
        r3 = null;
    L22:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        StringBuilder r5 = new StringBuilder("WindowManagerV2 getPkVideoParams videoWidth = ");
        r5.append(this.y);
        r5.append(", videoHeight = ");
        r5.append(this.v);
        r5.append(", videoTop = ");
        r5.append(this.x);
        r5.append(", params.width = ");
        if (r4 == null) goto L25;
        Integer r6 = Integer.valueOf(r4.width);
    L26:
        r5.append(r6);
        r5.append(", params.height = ");
        if (r4 == null) goto L29;
        Integer r7 = Integer.valueOf(r4.height);
    L30:
        r5.append(r7);
        r5.append(", topMargin = ");
        if (r4 == null) goto L33;
        r2 = Integer.valueOf(r4.topMargin);
    L33:
        r5.append(r2);
        String r8 = r5.toString();
        ALogger.w("LinkPkInteractAudienceWindowManagerV2", r8);
        dl0.m.a.getClass();
        dl0.m.C("LinkPkInteractAudienceWindowManagerV2_getPkVideoParams", r8);
        return;
    L29:
        r7 = null;
        goto L30
    L25:
        r6 = null;
        goto L26
    L18:
        r3 = null;
        goto L20
    }

    public final int v() {
        int r0 = this.b.getHeight();
        if (r0 > 0) goto L37;
        int r1 = x1.f();
        FragmentActivity r2 = this.a;
        int r3 = 0;
        if (r2 == null) goto L7;
        boolean r4 = x1.l(r2);
    L9:
        if (((Boolean) n7.a.getValue()).booleanValue() == true) goto L11;
        int r5 = s1.w();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L36;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L36;
        if (this.M.getContext() == null) goto L36;
        r3 = StatusBarUtil.getStatusBarHeight(this.M.getContext());
    L36:
        return r5 - r3;
    L11:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L13;
    L20:
        Context r6 = this.M.getContext();
        if (r6 == null) goto L24;
        r3 = x1.i(ContextUtil.contextToActivity(r6)).heightPixels;
    L24:
        r3 = r3 - StatusBarUtil.getStatusBarHeight(this.M.getContext());
    L25:
        if (r4 == false) goto L39;
        return r3 - r1;
    L39:
        return r3;
    L13:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L20;
        if (this.M.getContext() == null) goto L20;
        Context r7 = this.M.getContext();
        if (r7 == null) goto L25;
        r3 = x1.i(ContextUtil.contextToActivity(r7)).heightPixels;
        goto L25
    L7:
        r4 = false;
        goto L9
    L37:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final FrameLayout vj() {
        View r0 = this.P;
        if (r0 == null) goto L7;
        return (FrameLayout) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final void A() {
        if (n.b() == true) goto L5;
        return;
    L5:
        SurfaceView r0 = this.Q.q1();
        if (r0 == null) goto L8;
        r0.setVisibility(8);
    L8:
        FrameLayout r1 = this.b;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.indexOfChild(r0) != (-1)) goto L15;
        r1.addView(r0, 0);
        return;
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final void Bn(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        com.bytedance.android.live.livepkaudience.seat.f r0 = this.F;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "userId");
        PkSeatAnimationView r4 = (PkSeatAnimationView) ((LinkedHashMap) r0.a).get(r3);
        if (r4 == null) goto L13;
        DynamicEmojiView r5 = r4.c;
        if (r5 == null) goto L14;
        wj0.b r1 = r5.b.a();
        if (r1 == null) goto L15;
        r5.b.b(new wj0.a.C0287a(r1));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Mj(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        int r3 = zl(r2);
        if (r3 >= 0) goto L7;
        return null;
    L7:
        return s(r3);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.j
    public final boolean c(int r2) {
        if (this.s == true) goto L5;
    L7:
        return false;
    L5:
        if (r2 != 2) goto L7;
        return true;
    }

    public final void h(el0.a r4) {
        if (this.u == null) goto L20;
        int r0 = ((IInteractService) k.n(IInteractService.class)).getLinkMode();
        if (v.a(r0, 2) == false) goto L10;
        DataCenter r1 = this.u;
        if (r1 == null) goto L14;
        Boolean r2 = (Boolean) r1.get("data_intimate_chat_support_send_gift_to_linker", Boolean.FALSE);
    L16:
        if (r2 == null) goto L18;
        boolean r3 = r2.booleanValue();
    L19:
        r4.setIsOpenSendGift(r3);
        goto L20
    L18:
        r3 = false;
    L14:
        r2 = null;
        goto L16
    L10:
        if (v.a(r0, 32) == false) goto L15;
        DataCenter r5 = this.u;
        if (r5 == null) goto L14;
        r2 = (Boolean) r5.get("data_big_party_support_send_gift_to_linker", Boolean.FALSE);
        goto L16
    L15:
        r2 = Boolean.FALSE;
    L20:
        this.b.addView(r4);
        ((ArrayList) this.c).add(r4);
    }

    public final void j(boolean r7) {
        DataCenter r0 = this.u;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L9:
        if (((ArrayList) this.e).size() <= 1) goto L27;
        q();
        View r3 = (View) ListProtector.get(this.e, 0);
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L26;
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r4;
        if (r2 == false) goto L15;
        int r6 = this.v - (this.y / 2);
    L16:
        r5.height = r6;
        r5.topMargin = this.x;
        r3.setLayoutParams(r5);
        View r8 = (View) ListProtector.get(this.e, 1);
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L24;
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r9;
        if (r7 == true) goto L21;
        int r11 = this.v - (this.y / 2);
    L22:
        r10.height = r11;
        r10.topMargin = this.x;
        r8.setLayoutParams(r10);
        return;
    L21:
        r11 = this.v;
        goto L22
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L15:
        r6 = this.v;
        goto L16
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L27:
        return;
    L7:
        r2 = false;
        goto L9
    }

    public final el0.a n(String r9) {
        i r1 = null;
        if (q0.a("0") == false) goto L5;
    L7:
        el0.f r0 = this.n;
        if (r0 == null) goto L10;
        g r4 = r0.g(r9);
    L11:
        FragmentActivity r3 = this.a;
        if (r3 == null) goto L22;
        el0.a r2 = new el0.a(r3, r4, this, this.u, this.F);
        i r5 = this.h;
        if ((r5 instanceof i) == false) goto L17;
        r1 = r5;
    L17:
        if (r1 == null) goto L19;
        boolean r10 = r1.v(r9);
    L20:
        r2.setIsSelfRoomWindow(!r10);
        return r2;
    L19:
        r10 = false;
        goto L20
    L22:
        return null;
    L10:
        r4 = null;
        goto L11
    L5:
        if (TextUtils.isEmpty(r9) == false) goto L7;
        return null;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getData() != null) goto L8;
        return;
    L8:
        if (TextUtils.equals(r7.getKey(), "cmd_what_adjust_guest_window_by_sei") == false) goto L17;
        l();
        Map<String, z.a> r8 = this.m;
        if (r8 == null) goto L18;
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r8.size()));
        Iterator r9 = ((LinkedHashMap) r8).entrySet().iterator();
    L13:
        if (r9.hasNext() == false) goto L20;
        Map.Entry r1 = (Map.Entry) r9.next();
        k((String) r1.getKey(), (z.a) r1.getValue(), "bysei");
        r0.put(Unit.INSTANCE, r1.getValue());
        goto L13
    L20:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        DataCenter r0 = this.u;
        if (r0 == null) goto L9;
        Boolean r1 = (Boolean) r0.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r1 == null) goto L9;
        boolean r2 = r1.booleanValue();
    L10:
        DataCenter r3 = this.u;
        if (r3 == null) goto L15;
        Boolean r4 = (Boolean) r3.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r4 == null) goto L15;
        boolean r5 = r4.booleanValue();
    L17:
        if (this.s == true) goto L19;
        ArrayList r6 = new ArrayList();
        Iterator<? extends LinkPlayerInfo> r15 = r14.iterator();
    L29:
        if (r15.hasNext() == false) goto L38;
        LinkPlayerInfo r7 = r15.next();
        Iterator r8 = ((ArrayList) this.c).iterator();
    L32:
        if (r8.hasNext() == false) goto L29;
        el0.a r9 = (el0.a) r8.next();
        if (r9.getPresenter() == null) goto L32;
        if (TextUtils.equals(r7.getInteractId(), r9.getPresenter().c()) == false) goto L32;
        r9.getPresenter().g(r7);
        r6.add(r9);
        ((ArrayList) this.c).remove(r9);
        goto L29
    L38:
        r6.addAll(this.c);
        this.c = r6;
        com.bytedance.android.live.livepkaudience.rtc.a r16 = this.A;
        List<LinkPlayerInfo> r10 = null;
        if (r16 == null) goto L68;
        Map<String, Object> r17 = r16.s;
        if (r17 == null) goto L68;
        Iterator<String> r18 = r17.keySet().iterator();
        int r11 = 0;
        int r12 = 0;
    L44:
        if (r18.hasNext() == false) goto L69;
        String r13 = r18.next();
        i r19 = this.h;
        if ((r19 instanceof i) == true) goto L49;
        r19 = null;
    L49:
        if (r19 == null) goto L57;
        if (r19.v(r13) != true) goto L57;
        r12 = r12 + 1;
        if (r12 == 1) goto L56;
        r13 = "";
    L56:
        this.C = r13;
    L57:
        i r110 = this.h;
        if ((r110 instanceof i) == true) goto L60;
        r110 = null;
    L60:
        if (r110 == null) goto L44;
        if (r110.z(r13) != true) goto L44;
        r11 = r11 + 1;
        if (r11 == 1) goto L67;
        r13 = "";
    L67:
        this.B = r13;
    L69:
        if (r11 <= 0) goto L77;
        if (r2 == true) goto L77;
        DataCenter r111 = this.u;
        if (r111 == null) goto L74;
        r111.put("cmd_what_audience_join_self_link", Boolean.TRUE);
    L74:
        ILinkServiceExternal r112 = k.f(ILinkServiceExternal.class);
        if (r112 == null) goto L85;
        r112.onAudienceJoinSelfLink(true);
    L85:
        if (r12 <= 0) goto L93;
        if (r5 == true) goto L93;
        DataCenter r113 = this.u;
        if (r113 == null) goto L90;
        r113.put("cmd_what_audience_join_guest_link", Boolean.TRUE);
    L90:
        ILinkServiceExternal r114 = k.f(ILinkServiceExternal.class);
        if (r114 == null) goto L101;
        r114.onAudienceJoinGuestLink(true);
    L101:
        DataCenter r115 = this.u;
        if (r115 == null) goto L106;
        Boolean r116 = (Boolean) r115.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r116 == null) goto L106;
        boolean r117 = r116.booleanValue();
    L107:
        DataCenter r20 = this.u;
        if (r20 == null) goto L112;
        Boolean r21 = (Boolean) r20.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r21 == null) goto L112;
        boolean r22 = r21.booleanValue();
    L114:
        if (n.b() == false) goto L119;
        if (r12 != 0) goto L117;
        boolean r23 = true;
    L118:
        i(r23, "onOnlineListChanged");
    L123:
        t(r11, r117, r12, r22);
        l();
        ILinkServiceExternal r118 = k.f(ILinkServiceExternal.class);
        if (r118 != null) goto L126;
        return;
    L126:
        if (r118.isSpatialAudioEnable(4) != true) goto L155;
        lc0.d r119 = k.n(ILinkServiceExternal.class).getPkServiceExternal();
        Boolean r24 = Boolean.TRUE;
        i r25 = this.h;
        if ((r25 instanceof i) == true) goto L130;
        r25 = null;
    L130:
        if (r25 == null) goto L132;
        r10 = r25.h();
    L132:
        r119.h(false, r24, r10, "LinkPkInteractAudienceWindowManagerV2");
        return;
    L155:
        return;
    L117:
        r23 = false;
        goto L118
    L119:
        if (r12 != 0) goto L121;
        boolean r26 = true;
    L122:
        j(r26);
        goto L123
    L121:
        r26 = false;
    L112:
        r22 = false;
    L106:
        r117 = false;
    L93:
        if (r12 != 0) goto L101;
        if (r5 == false) goto L101;
        DataCenter r120 = this.u;
        if (r120 == null) goto L98;
        r120.put("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L98:
        ILinkServiceExternal r121 = k.f(ILinkServiceExternal.class);
        if (r121 == null) goto L101;
        r121.onAudienceJoinGuestLink(false);
    L77:
        if (r11 != 0) goto L85;
        if (r2 == false) goto L85;
        DataCenter r122 = this.u;
        if (r122 == null) goto L82;
        r122.put("cmd_what_audience_join_self_link", Boolean.FALSE);
    L82:
        ILinkServiceExternal r123 = k.f(ILinkServiceExternal.class);
        if (r123 == null) goto L85;
        r123.onAudienceJoinSelfLink(false);
    L68:
        r11 = 0;
        r12 = 0;
        goto L69
    L19:
        if (r14.size() < 2) goto L25;
        if (r5 == true) goto L25;
        if (r2 == true) goto L25;
        SeiAppData r124 = this.t;
        if (r124 == null) goto L25;
        Intrinsics.checkNotNull(r124);
        onSeiUpdated(r124);
    L25:
        l();
        return;
    L15:
        r5 = false;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.livepkaudience.base.j
    public final void onSeiUpdated(SeiAppData r22) {
        Intrinsics.checkNotNullParameter(r22, "sei");
        if (this.s == true) goto L5;
        return;
    L5:
        if (this.p == false) goto L255;
        this.t = r22;
        m();
        List r2 = r22.getGrids();
        if (r2 == null) goto L254;
        int r4 = 1;
        if (r2.size() < 1) goto L256;
        int r5 = 2;
        String r6 = null;
        if (r22.getVersion() == 2) goto L15;
    L49:
        i r3 = this.h;
        if (r3 == null) goto L59;
        Room r9 = this.i;
        if (r9 == null) goto L57;
        User r10 = r9.getOwner();
        if (r10 == null) goto L57;
        String r11 = r10.getIdStr();
        if (r11 == null) goto L57;
    L58:
        String r7 = r3.m(r11);
    L60:
        i r12 = this.h;
        if (r12 == null) goto L63;
        String r13 = r12.m(p());
    L65:
        if (this.H.getChannelId() == 0) goto L69;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r14 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r14 == null) goto L69;
        r14.setGuestAnchorLinkMicId(r13, "onSeiUpdated fir");
    L69:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r15 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r15 == null) goto L72;
        String r16 = r15.getGuestAnchorLinkMicId();
    L74:
        if (TextUtils.isEmpty(r16) == false) goto L78;
        LinkPkInteractGuestDataContext r17 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r17 == null) goto L78;
        r17.setGuestAnchorLinkMicId(((SeiRegion) ListProtector.get(r2, 0)).getInteractId(), "onSeiUpdated sec");
    L78:
        LinkPkInteractGuestDataContext r18 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r18 == null) goto L81;
        String r19 = r18.getGuestAnchorLinkMicId();
    L83:
        if (TextUtils.isEmpty(r19) == false) goto L85;
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", "onSeiUpdated getChannelId = " + this.H.getChannelId() + ", seiId = " + ((SeiRegion) ListProtector.get(r2, 0)).getInteractId() + ", guestAnchorInteractId = " + r13);
    L85:
        this.y = k.n(ILinkServiceExternal.class).getPkService().G().b;
        if (r2.size() <= 1) goto L88;
        SeiRegion r20 = (SeiRegion) ListProtector.get(r2, 1);
        SeiCanvas r1 = r22.getCanvas();
        this.w = (int) ((r20.getHeight() * ((double) r1.getHeight())) * ((double) (((this.y * 2) * 1.0f) / r1.getWidth())));
    L88:
        Iterator r8 = r2.iterator();
        int r21 = 0;
        int r110 = 0;
    L90:
        if (r8.hasNext() == false) goto L166;
        SeiRegion r111 = (SeiRegion) r8.next();
        if (r111 == null) goto L164;
        if (TextUtils.equals(r111.getInteractId(), r7) == true) goto L164;
        if (r7 != null) goto L97;
    L99:
        String r112 = r111.getInteractId();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r113 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r113 == null) goto L103;
        r6 = r113.getGuestAnchorLinkMicId();
    L103:
        if (TextUtils.equals(r112, r6) == true) goto L164;
        if (r111.getWidth() >= 1.0d) goto L164;
        if (r2.size() <= r4) goto L164;
        if (TextUtils.equals(r111.getInteractId(), tc0.c.h().f) == true) goto L164;
        i r23 = this.h;
        if ((r23 instanceof i) == true) goto L116;
        r23 = null;
    L116:
        if (r23 != null) goto L118;
    L124:
        i r24 = this.h;
        if ((r24 instanceof i) == true) goto L127;
        r24 = null;
    L127:
        if (r24 != null) goto L129;
    L135:
        el0.a r25 = n(r111.getInteractId());
        if (r25 == null) goto L164;
        h(r25);
        String r114 = r111.getInteractId();
        FrameLayout.LayoutParams r26 = new FrameLayout.LayoutParams(0, 0);
        q();
        DataCenter r27 = this.u;
        if (r27 == null) goto L143;
        Integer r28 = (Integer) r27.get("data_pk_ui_change", 0);
        if (r28 == null) goto L143;
        int r29 = r28.intValue();
    L144:
        i r115 = this.h;
        if (r115 == null) goto L147;
        boolean r116 = r115.v(r114);
    L148:
        i r117 = this.h;
        if (r117 == null) goto L151;
        String r118 = r117.r(r114);
    L152:
        i r119 = this.h;
        if (r119 == null) goto L157;
        if (r118 != null) goto L156;
        r118 = "0";
    L156:
        int r120 = r119.O4(r118);
    L158:
        if (r116 == false) goto L160;
        int r121 = r120 + 1;
    L161:
        r26.gravity = 48;
        r26.topMargin = (this.x + this.v) - this.w;
        r26.leftMargin = ((this.y / 2) * r121) + Math.max(0, r29);
        r26.width = this.y / 2;
        r26.height = this.w;
        r25.setLayoutParams(r26);
        g r30 = r25.getPresenter();
        if (r30 == null) goto L164;
        r30.h(r111.getStatus());
        goto L164
    L160:
        r121 = r120 - 1;
        goto L161
    L157:
        r120 = -1;
        goto L158
    L151:
        r118 = null;
        goto L152
    L147:
        r116 = false;
    L143:
        r29 = 0;
        goto L144
    L129:
        if (r24.z(r111.getInteractId()) != r4) goto L135;
        r21 = r21 + 1;
        if (r21 != r4) goto L133;
        String r31 = r111.getInteractId();
    L134:
        this.B = r31;
        goto L135
    L133:
        r31 = "";
        goto L134
    L118:
        if (r23.v(r111.getInteractId()) != r4) goto L124;
        r110 = r110 + 1;
        if (r110 != r4) goto L122;
        String r32 = r111.getInteractId();
    L123:
        this.C = r32;
        goto L135
    L122:
        r32 = "";
        goto L123
    L97:
        if (StringsKt.startsWith$default(r7, r111.getInteractId(), false, r5, r6) == false) goto L99;
    L164:
        r4 = 1;
        r5 = 2;
        r6 = null;
        goto L90
    L166:
        if (r2.size() <= 1) goto L193;
        int r33 = ((ArrayList) this.d).size();
        q();
        DataCenter r34 = this.u;
        if (r34 == null) goto L172;
        Integer r35 = (Integer) r34.get("data_pk_ui_change", 0);
        if (r35 == null) goto L172;
        int r36 = r35.intValue();
    L173:
        if (r36 <= 0) goto L175;
        this.z = r36;
    L175:
        int r37 = 0;
    L176:
        if (r37 >= r33) goto L193;
        el0.a r38 = (el0.a) ListProtector.get(this.d, r37);
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
        if ((r39 instanceof FrameLayout.LayoutParams) == true) goto L180;
        r39 = null;
    L180:
        FrameLayout.LayoutParams r40 = (FrameLayout.LayoutParams) r39;
        if (r40 == null) goto L192;
        r40.gravity = 48;
        r40.topMargin = (this.x + this.v) - this.w;
        if (PadConfigUtils.c() == false) goto L190;
        if (this.r == false) goto L187;
        r40.leftMargin -= this.z;
        this.z = 0;
    L188:
        int r41 = this.y / 2;
        r40.width = r41;
        r40.height = r41;
        goto L190
    L187:
        r40.leftMargin += Math.max(0, r36);
    L190:
        r38.setLayoutParams(r40);
    L192:
        r37 = r37 + 1;
    L172:
        r36 = 0;
    L193:
        DataCenter r42 = this.u;
        if (r42 == null) goto L198;
        Boolean r43 = (Boolean) r42.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r43 == null) goto L198;
        boolean r44 = r43.booleanValue();
    L199:
        DataCenter r45 = this.u;
        if (r45 == null) goto L204;
        Boolean r46 = (Boolean) r45.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r46 == null) goto L204;
        boolean r47 = r46.booleanValue();
    L205:
        if (r21 <= 0) goto L213;
        if (r44 == true) goto L213;
        DataCenter r48 = this.u;
        if (r48 == null) goto L210;
        r48.put("cmd_what_audience_join_self_link", Boolean.TRUE);
    L210:
        ILinkServiceExternal r49 = k.f(ILinkServiceExternal.class);
        if (r49 == null) goto L221;
        r49.onAudienceJoinSelfLink(true);
    L221:
        if (r110 <= 0) goto L229;
        if (r47 == true) goto L229;
        DataCenter r50 = this.u;
        if (r50 == null) goto L226;
        r50.put("cmd_what_audience_join_guest_link", Boolean.TRUE);
    L226:
        ILinkServiceExternal r51 = k.f(ILinkServiceExternal.class);
        if (r51 == null) goto L237;
        r51.onAudienceJoinGuestLink(true);
    L237:
        t(r21, r44, r110, r47);
        return;
    L229:
        if (r110 != 0) goto L237;
        if (r47 == false) goto L237;
        DataCenter r52 = this.u;
        if (r52 == null) goto L234;
        r52.put("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L234:
        ILinkServiceExternal r53 = k.f(ILinkServiceExternal.class);
        if (r53 == null) goto L237;
        r53.onAudienceJoinGuestLink(false);
    L213:
        if (r21 != 0) goto L221;
        if (r44 == false) goto L221;
        DataCenter r54 = this.u;
        if (r54 == null) goto L218;
        r54.put("cmd_what_audience_join_self_link", Boolean.FALSE);
    L218:
        ILinkServiceExternal r55 = k.f(ILinkServiceExternal.class);
        if (r55 == null) goto L221;
        r55.onAudienceJoinSelfLink(false);
    L204:
        r47 = false;
    L198:
        r44 = false;
        goto L199
    L81:
        r19 = null;
        goto L83
    L72:
        r16 = null;
        goto L74
    L63:
        r13 = "";
    L57:
        r11 = "0";
        goto L58
    L59:
        r7 = null;
        goto L60
    L15:
        if (r22.getGrids().size() > 1) goto L38;
        if (((Boolean) vh0.a.getValue()).booleanValue() == false) goto L34;
        Room r56 = this.i;
        if (r56 == null) goto L24;
        z5 r57 = r56.getLinkerDetail();
        if (r57 == null) goto L24;
        String r58 = r57.getInitSource();
    L26:
        if (Intrinsics.areEqual(r58, "chat_room_in_pk") == true) goto L35;
        Room r59 = this.i;
        if (r59 == null) goto L34;
        z5 r60 = r59.getLinkerDetail();
        if (r60 == null) goto L34;
        if (r60.getUiLayout() != 52) goto L34;
    L35:
        boolean r61 = true;
    L36:
        if (r61 == false) goto L49;
    L24:
        r58 = null;
    L34:
        r61 = false;
    L38:
        if (this.j == true) goto L49;
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r62 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r62 == null) goto L42;
        i r63 = r62.getLinkUserCenter();
    L44:
        if ((r63 instanceof i) == true) goto L46;
        r63 = null;
    L46:
        if (r63 == null) goto L48;
        r63.G(this.H.getChannelId());
    L48:
        this.j = true;
        goto L49
    L42:
        r63 = null;
        goto L44
    L256:
        return;
    L254:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int qq(int r1) {
        return s1.j(2131169230);
    }

    public final EPointF s(int r4) {
        q();
        int r0 = this.x;
        int r1 = this.v;
        if (this.s == false) goto L5;
        int r2 = this.w;
    L6:
        int r3 = r0 + ((r1 - r2) / 2);
        if (r4 != 0) goto L10;
        return r(null, new Point(s1.y() / 4, r3));
    L10:
        return r(o(this.l, ""), null);
    L5:
        r2 = this.y / 2;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean wc(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        com.bytedance.android.live.livepkaudience.seat.f r0 = this.F;
        if (r0 == null) goto L12;
        if (r3 == null) goto L15;
        PkSeatAnimationView r4 = (PkSeatAnimationView) ((LinkedHashMap) r0.a).get(r3);
        if (r4 == null) goto L13;
        DynamicEmojiView r5 = r4.c;
        if (r5 != null) goto L11;
        return false;
    L11:
        return !(r5.b.a instanceof wj0.c.b);
    L13:
        return false;
    L15:
        return false;
    L12:
        return false;
    }

    public final void y(el0.a r2) {
        if (Intrinsics.areEqual(r2, this.g) == false) goto L5;
        this.g = null;
    L5:
        this.b.removeView(r2);
        List<el0.a> r0 = this.c;
        if (r0 == null) goto L10;
        TypeIntrinsics.asMutableCollection(r0).remove(r2);
        l();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public final void z(boolean r3) {
        if (r3 != this.s) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        B();
    L7:
        this.s = r3;
        m();
        Iterator r4 = ((ArrayList) this.d).iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        el0.a r0 = (el0.a) r4.next();
        this.b.removeView(r0);
        goto L9
    L11:
        this.D = -2;
        this.E = -2;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int zl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        Room r0 = this.i;
        if (r0 == null) goto L5;
        String r1 = r0.getOwnerUserIdString();
    L7:
        if (Intrinsics.areEqual(r3, r1) == false) goto L9;
        return 0;
    L9:
        this.l = r3;
        i r2 = this.h;
        if (r2 != null) goto L12;
        return 0;
    L12:
        return r2.O4(r3);
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF C7(int r1, int r2) {
        return s(r1);
    }

    public final boolean D(String r3, RectF r4) {
        Intrinsics.checkNotNullParameter(r4, "rect");
        if (r3 != null) goto L5;
        return false;
    L5:
        ILinkServiceExternal r1 = k.f(ILinkServiceExternal.class);
        if (r1 == null) goto L11;
        kc0.i r2 = r1.getRegionService();
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.updateStreamRegion(r3, r4);
    L11:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean K5(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fromUserId");
        Intrinsics.checkNotNullParameter(r4, "toUSerId");
        Intrinsics.checkNotNullParameter(r3, "fromUserId");
        Intrinsics.checkNotNullParameter(r4, "toUSerId");
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Kl(int r1, int r2) {
        return s(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean W7(EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        return true;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void a(String r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "userId");
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r2 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r2 == null) goto L5;
        String r3 = r2.getSelfAnchorLinkMicId();
    L7:
        if (TextUtils.equals(r18, r3) == true) goto L16;
        LinkPkInteractGuestDataContext r4 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r4 == null) goto L11;
        String r5 = r4.getGuestAnchorLinkMicId();
    L13:
        if (TextUtils.equals(r18, r5) == true) goto L16;
        boolean r6 = false;
    L17:
        String r8 = "";
        if (this.s == true) goto L87;
        Map<String, z.a> r7 = this.m;
        if (r7 == null) goto L85;
        TypeIntrinsics.asMutableMap(r7).remove(r18);
        DataCenter r9 = this.u;
        if (r9 == null) goto L26;
        Boolean r10 = (Boolean) r9.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r10 == null) goto L26;
        boolean r11 = r10.booleanValue();
    L27:
        DataCenter r12 = this.u;
        if (r12 == null) goto L32;
        Boolean r13 = (Boolean) r12.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r13 == null) goto L32;
        boolean r14 = r13.booleanValue();
    L33:
        com.bytedance.android.live.livepkaudience.rtc.a r15 = this.A;
        if (r15 == null) goto L62;
        Map<String, Object> r16 = r15.s;
        if (r16 == null) goto L62;
        Iterator<String> r19 = r16.keySet().iterator();
        int r110 = 0;
        int r111 = 0;
    L39:
        if (r19.hasNext() == false) goto L63;
        String r112 = r19.next();
        i r20 = this.h;
        if ((r20 instanceof i) == true) goto L43;
        r20 = null;
    L43:
        if (r20 == null) goto L51;
        if (r20.v(r112) != true) goto L51;
        r111 = r111 + 1;
        if (r111 == 1) goto L50;
        r112 = "";
    L50:
        this.C = r112;
    L51:
        i r21 = this.h;
        if ((r21 instanceof i) == true) goto L54;
        r21 = null;
    L54:
        if (r21 == null) goto L39;
        if (r21.z(r112) != true) goto L39;
        r110 = r110 + 1;
        if (r110 == 1) goto L61;
        r112 = "";
    L61:
        this.B = r112;
    L63:
        if (r110 != 0) goto L71;
        if (r11 == false) goto L71;
        DataCenter r22 = this.u;
        if (r22 == null) goto L68;
        r22.put("cmd_what_audience_join_self_link", Boolean.FALSE);
    L68:
        ILinkServiceExternal r23 = k.f(ILinkServiceExternal.class);
        if (r23 == null) goto L71;
        r23.onAudienceJoinSelfLink(false);
    L71:
        if (r111 != 0) goto L83;
        if (r14 == false) goto L83;
        DataCenter r24 = this.u;
        if (r24 == null) goto L76;
        r24.put("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L76:
        ILinkServiceExternal r25 = k.f(ILinkServiceExternal.class);
        if (r25 == null) goto L80;
        r25.onAudienceJoinGuestLink(false);
    L80:
        if (n.b() == false) goto L82;
        i(true, "");
        goto L83
    L82:
        j(true);
    L83:
        t(r110, r11, r111, r14);
    L62:
        r110 = 0;
        r111 = 0;
    L32:
        r14 = false;
    L26:
        r11 = false;
        goto L27
    L85:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L87:
        if (this.s == false) goto L89;
        return;
    L89:
        if (this.p == false) goto L141;
        if (r6 == false) goto L96;
        ILinkServiceExternal r26 = k.f(ILinkServiceExternal.class);
        if (r26 == null) goto L95;
        r26.notifyPkAudienceUnload();
    L95:
        com.bytedance.android.live.core.performance.a r27 = com.bytedance.android.live.core.performance.a.a;
        TimeCostUtil.Tag.LivePk.name();
        TimeCostUtil.a("isAnchor", "false");
        r27.getClass();
        ALogger.w("ttlive_pk", "LinkCrossRoomDataHolder.unloadModule", new IllegalStateException());
    L96:
        el0.a r28 = o(r17, r18);
        if (r28 != null) goto L99;
        return;
    L99:
        Room r29 = this.i;
        if (r29 == null) goto L104;
        User r30 = r29.getOwner();
        if (r30 == null) goto L104;
        String r31 = r30.getIdStr();
    L105:
        i r32 = this.h;
        if ((r32 instanceof i) == true) goto L108;
        r32 = null;
    L108:
        if (r32 == null) goto L110;
        boolean r33 = r32.u(r18);
    L112:
        if (r28.getPresenter() != null) goto L114;
    L127:
        y(r28);
        return;
    L114:
        if ((!Intrinsics.areEqual(r28.getPresenter().f(), r31)) == false) goto L127;
        if (r33 == true) goto L127;
        LinkPlayerInfo r1 = r28.getPresenter().d();
        FragmentActivity r34 = this.a;
        if (r34 == null) goto L127;
        Object[] r35 = new Object[1];
        if (r1 == null) goto L126;
        IBaseUser r36 = r1.getUser();
        if (r36 == null) goto L126;
        String r37 = r36.getNickName();
        if (r37 == null) goto L126;
        r8 = r37;
    L126:
        r35[0] = r8;
        IESUIUtils.displayToast(r34, r34.getString(2131919329, r35));
        goto L127
    L110:
        r33 = false;
    L104:
        r31 = null;
        goto L105
    L141:
        return;
    L11:
        r5 = null;
    L16:
        r6 = true;
        goto L17
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void e(List r4, WaitingListUser r5) {
        if (k.n(IUserService.class).user().c() == false) goto L25;
        String r6 = "";
        if (Lists.isEmpty(r4) == false) goto L9;
        DataCenter r7 = this.u;
        if (r7 == null) goto L26;
        r7.put("data_interact_number_dot_show", "");
        return;
    L26:
        return;
    L9:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r8 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r8 == null) goto L14;
        i r9 = r8.getLinkUserCenter();
        if (r9 == null) goto L14;
        int r10 = ((ArrayList) r9.p()).size();
    L15:
        String r1 = String.valueOf(r10);
        if (r10 <= 99) goto L18;
        r1 = "99+";
    L18:
        if (r10 <= 0) goto L21;
        r6 = r1;
    L21:
        DataCenter r11 = this.u;
        if (r11 == null) goto L28;
        r11.put("data_interact_number_dot_show", r6);
        return;
    L28:
        return;
    L14:
        r10 = 0;
        goto L15
    }

    public final void g(boolean r6, int r7) {
        if (((ArrayList) this.d).size() > 1) goto L5;
        return;
    L5:
        el0.a r0 = (el0.a) ListProtector.get(this.d, !r6 ? 1 : 0);
        this.b.addView(r0);
        if (r6 == false) goto L8;
        r0.setOnClickListener(new b(this));
    L8:
        q();
        r0.d(this.s, r6);
        ViewGroup.LayoutParams r8 = r0.getLayoutParams();
        if (r8 == null) goto L26;
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        DataCenter r1 = this.u;
        if (r1 == null) goto L15;
        Integer r2 = (Integer) r1.get("data_pk_ui_change", 0);
        if (r2 == null) goto L15;
        int r3 = r2.intValue();
    L16:
        r9.gravity = 48;
        int r4 = this.x + this.v;
        if (this.s == false) goto L19;
        int r5 = this.w;
    L20:
        r9.topMargin = r4 - r5;
        r9.leftMargin = ((this.y / 2) * r7) + Math.max(0, r3);
        int r10 = this.y / 2;
        r9.width = r10;
        if (this.s == false) goto L23;
        r10 = this.w;
    L23:
        r9.height = r10;
        r0.setLayoutParams(r9);
        return;
    L19:
        r5 = this.y / 2;
    L15:
        r3 = 0;
        goto L16
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void i(boolean r6, String r7) {
        DataCenter r0 = this.u;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        String r8 = "adjustAnchorLayer src = " + r7 + ", selfHasAudienceOnline = " + r2 + ", size = " + ((ArrayList) this.f).size() + ", isAllLeave = " + r6;
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", r8);
        dl0.m.a.getClass();
        dl0.m.C("LinkPkInteractAudienceWindowManagerV2_adjustAnchorLayer", r8);
        if (((ArrayList) this.f).size() <= 1) goto L35;
        z.a r9 = (z.a) ListProtector.get(this.f, 0);
        RectF r3 = u(0, r2);
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", "adjustAnchorLayer selfAnchorLayer = " + r9 + ", rect = " + r3);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r4 = ILiveWrappedLivePusher.a.b();
        m1.b r5 = null;
        if (r4 == null) goto L15;
        m1.b r10 = r4.newVideoMixerDescription(null);
        if (r10 == null) goto L15;
        r10.e();
        r10.b();
        r10.c();
        r10.f();
        r10.h();
        r10.i();
        r10.g();
    L16:
        C(r9, r10, "");
        z.a r11 = (z.a) ListProtector.get(this.f, 1);
        RectF r12 = u(1, !r6);
        ILiveWrappedLivePusher r13 = ILiveWrappedLivePusher.a.b();
        if (r13 == null) goto L21;
        m1.b r14 = r13.newVideoMixerDescription(null);
        if (r14 == null) goto L21;
        r14.e();
        r14.b();
        r14.c();
        r14.f();
        r14.h();
        r14.i();
        r14.g();
        r5 = r14;
    L21:
        C(r11, r5, "");
        ILinkServiceExternal r15 = k.f(ILinkServiceExternal.class);
        if (r15 == null) goto L26;
        kc0.i r16 = r15.getRegionService();
        if (r16 == null) goto L26;
        r16.clearStreamRegion();
    L26:
        boolean r17 = D(r9.name(), r3);
        boolean r18 = D(r11.name(), r12);
        if (r17 == true) goto L29;
        if (r18 == true) goto L29;
        return;
    L29:
        ILinkServiceExternal r19 = k.f(ILinkServiceExternal.class);
        if (r19 == null) goto L37;
        kc0.i r20 = r19.getRegionService();
        if (r20 == null) goto L38;
        r20.notifyStreamRegionUpdate();
        return;
    L38:
        return;
    L37:
        return;
    L15:
        r10 = null;
        goto L16
    L35:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int ma(int r1, int r2) {
        return s1.j(2131169229);
    }

    public final el0.a o(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Iterator<el0.a> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        el0.a r1 = r0.next();
        if (q0.a(r4) == false) goto L13;
        if (r1.getPresenter() == null) goto L13;
        if (Intrinsics.areEqual(r1.getPresenter().f(), r4) == false) goto L13;
        return r1;
    L13:
        if (TextUtils.isEmpty(r5) == true) goto L4;
        if (r1.getPresenter() == null) goto L4;
        if (TextUtils.equals(r1.getPresenter().c(), r5) == false) goto L4;
        return r1;
    L19:
        return null;
    }

    public final EPointF r(el0.a r4, Point r5) {
        Rect r0 = new Rect();
        if (r4 == null) goto L5;
        r4.getGlobalVisibleRect(r0);
    L5:
        EPointF r6 = new EPointF();
        ((PointF) r6).x = r0.centerX();
        float r1 = r0.centerY();
        ((PointF) r6).y = r1;
        if (r5 == null) goto L8;
        ((PointF) r6).x += r5.x;
        ((PointF) r6).y = r1 + r5.y;
    L8:
        return r6;
    }

    public final RectF u(int r5, boolean r6) {
        int r0 = v();
        if (r6 == false) goto L9;
        int r7 = this.v + this.x;
        if (this.s == false) goto L7;
        int r1 = this.w;
    L8:
        int r8 = r7 - r1;
    L10:
        float r2 = r0;
        return new RectF(r5 * 0.5f, this.x / r2, (r5 + 1) * 0.5f, r8 / r2);
    L7:
        r1 = this.y / 2;
        goto L8
    L9:
        r8 = this.v + this.x;
        goto L10
    }

    public final void x(boolean r3, boolean r4) {
        if (((ArrayList) this.d).size() > 1) goto L5;
        return;
    L5:
        this.b.removeView((View) ListProtector.get(this.d, !r3 ? 1 : 0));
    }

    public final void C(z.a r5, m1.b r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "targetLayer");
        Intrinsics.checkNotNullParameter(r7, "linkId");
        if (r6 != null) goto L5;
        return;
    L5:
        String r0 = "tryUpdateLayerDescription linkId = " + r7 + ", top = " + r6.getTop() + ", botoom = " + r6.getBottom() + ", left = " + r6.getLeft() + ", surfaceHeight: " + v() + ", ";
        ALogger.e("LinkPkInteractAudienceWindowManagerV2", r0);
        dl0.m.a.getClass();
        dl0.m.C("LinkPkInteractAudienceWindowManagerV2_tryUpdateLayerDescription", r0);
        m1.b r1 = r5.Y();
        if (r1 != null) goto L8;
    L21:
        dl0.m.C("LinkPkInteractAudienceWindowManagerV2_tryUpdateLayerDescription", "real update mIsNormalAudience = " + this.s);
        r5.b();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r8 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        String r9 = null;
        if (r8 == null) goto L24;
        String r10 = r8.getAudienceSelfLinkMicId();
    L26:
        if (TextUtils.equals(r7, r10) == false) goto L60;
        com.bytedance.android.live.livepkaudience.rtc.a r11 = this.A;
        if (r11 == null) goto L61;
        q r12 = this.R;
        if (r12 == null) goto L32;
        r9 = r12.d;
    L32:
        int r13 = com.bytedance.android.live.livepkaudience.rtc.a.x;
        Intrinsics.checkNotNullParameter("guestAdjustSelfLayer", "src");
        if (((Boolean) hh0.a.getValue()).booleanValue() == false) goto L65;
        int r2 = 0;
        if (n.b() == true) goto L40;
        gy.a r14 = r11.r;
        if (r14 == null) goto L62;
        gy.a.b(r14, r9, "guestAdjustSelfLayer", 0, 0);
        return;
    L62:
        return;
    L40:
        gy.a r15 = r11.r;
        if (r15 == null) goto L64;
        d0 r3 = r11.b;
        if (r3 == null) goto L49;
        z r4 = r3.C();
        if (r4 == null) goto L49;
        z.a r16 = r4.K0();
        if (r16 == null) goto L49;
        int r17 = r16.getWidth();
    L50:
        d0 r18 = r11.b;
        if (r18 == null) goto L57;
        z r19 = r18.C();
        if (r19 == null) goto L57;
        z.a r20 = r19.K0();
        if (r20 == null) goto L57;
        r2 = r20.getHeight();
    L57:
        gy.a.b(r15, r9, "guestAdjustSelfLayer", r17, r2);
        return;
    L49:
        r17 = 0;
        goto L50
    L64:
        return;
    L65:
        return;
    L61:
        return;
    L60:
        return;
    L24:
        r10 = null;
        goto L26
    L8:
        if (r1.getLeft() != r6.getLeft()) goto L21;
        if (r1.getTop() != r6.getTop()) goto L21;
        if (r1.getRight() != r6.getRight()) goto L21;
        if (r1.getBottom() != r6.getBottom()) goto L21;
        if (r1.isVisible() != r6.isVisible()) goto L21;
        if (r1.getMode() != r6.getMode()) goto L21;
        if (r1.d() != r6.d()) goto L21;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final void Mb(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "url");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean Mk(EPointF r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        com.bytedance.android.live.liveinteract.animation.e.a.a(r2, r3, r4);
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean ha(EPointF r2, EPointF r3, EPointF r4) {
        Intrinsics.checkNotNullParameter(r2, "currentPoint");
        Intrinsics.checkNotNullParameter(r3, "startPoint");
        Intrinsics.checkNotNullParameter(r4, "endPoint");
        com.bytedance.android.live.liveinteract.animation.e.a.b(r2, r3, r4);
        return false;
    }

    public final void k(String r7, z.a r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "linkId");
        Intrinsics.checkNotNullParameter(r9, "source");
        i r0 = this.h;
        if (r0 == null) goto L30;
        boolean r1 = r0.v(r7);
        i r2 = this.h;
        if (r2 == null) goto L28;
        String r3 = r2.r(r7);
        i r4 = this.h;
        if (r4 == null) goto L26;
        int r5 = r4.O4(r3);
        if (r1 == false) goto L11;
        int r6 = r5 + 1;
    L12:
        q();
        String r10 = "adjustGuestLayer source = " + r9 + ", linkId = " + r7 + ", videoHeight = " + this.v + ", isNotSelfGuest = " + r1 + ", guestPos = " + r5 + ", realPos = " + r6;
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", r10);
        dl0.m.a.getClass();
        dl0.m.C("LinkPkInteractAudienceWindowManagerV2_adjustGuestLayer", r10);
        float r11 = v();
        float r12 = (this.v + this.x) / r11;
        if (this.s == false) goto L15;
        int r13 = this.w;
    L16:
        new RectF(r6 * 0.25f, r12 - (r13 / r11), (r6 + 1) * 0.25f, r12);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r14 = ILiveWrappedLivePusher.a.b();
        m1.b r15 = null;
        if (r14 == null) goto L21;
        m1.b r16 = r14.newVideoMixerDescription(null);
        if (r16 == null) goto L21;
        r16.e();
        r16.b();
        r16.c();
        r16.f();
        r16.h();
        r16.i();
        r16.g();
        r15 = r16;
    L21:
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", "adjustGuestLayer layerDescription = " + String.valueOf(r15) + ' ');
        if (r8 == null) goto L31;
        C(r8, r15, r7);
        return;
    L31:
        return;
    L15:
        r13 = this.y / 2;
        goto L16
    L11:
        r6 = r5 - 1;
        goto L12
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Se(int r2, int r3, EPointF r4, EPointF r5) {
        Intrinsics.checkNotNullParameter(r4, "startPoint");
        Intrinsics.checkNotNullParameter(r5, "endPoint");
        if (r2 != 0) goto L5;
        EPointF r6 = new EPointF();
        ((PointF) r6).x = ((PointF) r5).x - s1.e(30.0f);
        ((PointF) r6).y = ((PointF) r5).y - s1.e(30.0f);
        return r6;
    L5:
        if (r3 != 0) goto L7;
        EPointF r7 = new EPointF();
        ((PointF) r7).x = ((PointF) r5).x - s1.e(30.0f);
        ((PointF) r7).y = ((PointF) r5).y - s1.e(30.0f);
        return r7;
    L7:
        EPointF r8 = new EPointF();
        float r0 = 2;
        ((PointF) r8).x = (((PointF) r5).x + ((PointF) r4).x) / r0;
        ((PointF) r8).y = (((PointF) r5).y + ((PointF) r4).y) / r0;
        return r8;
    }

    public final void t(int r6, boolean r7, int r8, boolean r9) {
        int r0 = -2;
        int r1 = 2;
        if (r6 != 0) goto L5;
        if (r7 == false) goto L5;
    L6:
        x(true, true);
        this.D = -2;
    L8:
        if (r8 != 0) goto L10;
        if (r9 == false) goto L10;
    L11:
        x(false, true);
        this.E = -2;
    L12:
        i r3 = null;
        if (r6 != 1) goto L29;
        i r10 = this.h;
        if ((r10 instanceof i) == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L19;
        int r11 = r10.s(this.B);
    L21:
        if (this.D == r11) goto L29;
        x(true, false);
        this.D = r11;
        if (r11 == 1) goto L27;
        if (r11 == 2) goto L26;
        int r12 = -1;
    L28:
        g(true, r12);
        goto L29
    L26:
        r12 = 0;
        goto L28
    L27:
        r12 = 1;
        goto L28
    L19:
        r11 = -2;
    L29:
        if (r8 != 1) goto L45;
        i r13 = this.h;
        if ((r13 instanceof i) == false) goto L34;
        r3 = r13;
    L34:
        if (r3 == null) goto L37;
        r0 = r3.s(this.C);
    L37:
        if (this.E == r0) goto L46;
        this.E = r0;
        x(false, false);
        if (r0 == 1) goto L42;
        if (r0 == 2) goto L43;
        r1 = -1;
    L43:
        g(false, r1);
        return;
    L42:
        r1 = 3;
        goto L43
    L46:
        return;
    L45:
        return;
    L10:
        if (r8 != 2) goto L12;
    L5:
        if (r6 != 2) goto L8;
        goto L6
    }

    public static void w(LinkPkInteractAudienceWindowManagerV2 r20, String r21, View r22, z.a r23, int r24) {
        if ((r24 & 2) == 0) goto L5;
        View r2 = null;
    L7:
        if ((r24 & 4) == 0) goto L9;
        z.a r4 = null;
    L10:
        Intrinsics.checkNotNullParameter(r21, "interactId");
        if (n.b() == false) goto L17;
        xk0.b r5 = r20.Q;
        if (r5 == null) goto L17;
        SurfaceView r6 = r5.q1();
        if (r6 == null) goto L17;
        r6.setVisibility(0);
    L17:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r7 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r7 == null) goto L20;
        String r8 = r7.getGuestAnchorLinkMicId();
    L21:
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", "onUserJoined guestAnchorLinkId = " + r8 + ", ");
        if (TextUtils.isEmpty(r8) == false) goto L39;
        i r9 = r20.h;
        if (r9 == null) goto L26;
        r8 = r9.m(r20.p());
    L27:
        LinkPkInteractGuestDataContext r10 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r10 == null) goto L31;
        r10.setGuestAnchorLinkMicId(r8, "onUserJoined");
    L31:
        if (TextUtils.isEmpty(r8) == false) goto L39;
        StringBuilder r11 = new StringBuilder("onUserJoined getGuestAnchorId = ");
        r11.append(r20.p());
        r11.append(", onlineUserList = ");
        i r14 = r20.h;
        if (r14 == null) goto L37;
        CopyOnWriteArrayList<LinkPlayerInfo> r15 = r14.c;
        if (r15 == null) goto L37;
        Integer r16 = Integer.valueOf(r15.size());
    L38:
        r11.append(r16);
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", r11.toString());
    L37:
        r16 = null;
        goto L38
    L26:
        r8 = "";
    L39:
        LinkPkInteractGuestDataContext r12 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r12 == null) goto L42;
        String r13 = r12.getSelfAnchorLinkMicId();
    L43:
        DataCenter r17 = r20.u;
        if (r17 == null) goto L48;
        Boolean r3 = (Boolean) r17.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r3 == null) goto L48;
        boolean r18 = r3.booleanValue();
    L49:
        DataCenter r19 = r20.u;
        if (r19 == null) goto L54;
        Boolean r110 = (Boolean) r19.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r110 == null) goto L54;
        boolean r111 = r110.booleanValue();
    L56:
        if (r20.s == false) goto L58;
    L112:
        View r112 = r2;
        z.a r113 = r4;
        int r25 = 0;
        int r114 = 0;
    L113:
        if (r114 <= 0) goto L121;
        if (r18 == true) goto L121;
        DataCenter r26 = r20.u;
        if (r26 == null) goto L118;
        r26.put("cmd_what_audience_join_self_link", Boolean.TRUE);
    L118:
        ILinkServiceExternal r27 = k.f(ILinkServiceExternal.class);
        if (r27 == null) goto L129;
        r27.onAudienceJoinSelfLink(true);
    L129:
        if (r25 <= 0) goto L137;
        if (r111 == true) goto L137;
        DataCenter r28 = r20.u;
        if (r28 == null) goto L134;
        r28.put("cmd_what_audience_join_guest_link", Boolean.TRUE);
    L134:
        ILinkServiceExternal r29 = k.f(ILinkServiceExternal.class);
        if (r29 == null) goto L145;
        r29.onAudienceJoinGuestLink(true);
    L145:
        ALogger.w("LinkPkInteractAudienceWindowManagerV2", "onUserJoined selfOnlineCount = " + r114 + ", selfHasAudienceJoin = " + r18 + ", guestOnlineCount = " + r25 + ", guestHasAudienceJoin = " + r111 + ", anchorLinkId = " + r13 + ", mIsNormalAudienceJ = " + r20.s + ", ");
        if (n.b() == false) goto L151;
        if (r25 != 0) goto L149;
        boolean r30 = true;
    L150:
        r20.i(r30, "onUserJoined");
    L155:
        r20.t(r114, r18, r25, r111);
        if (r20.s == false) goto L158;
        return;
    L158:
        if (r20.p == false) goto L303;
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", "onUserJoined guestAnchorLinkId = " + r8 + ", interactId = " + r21 + ", anchorLinkId = " + r13);
        if (TextUtils.equals(r21, r8) == false) goto L163;
    L188:
        View r31 = r112;
        z.a r32 = r113;
        if (r32 != null) goto L191;
    L211:
        if (r31 == null) goto L305;
        r20.q();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r33 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r33 == null) goto L216;
        String r34 = r33.getGuestAnchorLinkMicId();
    L218:
        if (TextUtils.isEmpty(r34) == false) goto L235;
        i r35 = r20.h;
        if (r35 == null) goto L222;
        String r36 = r35.m(r20.p());
    L223:
        LinkPkInteractGuestDataContext r37 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r37 == null) goto L227;
        r37.setGuestAnchorLinkMicId(r36, "");
    L227:
        if (TextUtils.isEmpty(r36) == false) goto L235;
        StringBuilder r38 = new StringBuilder("addAnchorSurfaceView getGuestAnchorId = ");
        r38.append(r20.p());
        r38.append(", onlineUserList = ");
        i r39 = r20.h;
        if (r39 == null) goto L233;
        CopyOnWriteArrayList<LinkPlayerInfo> r40 = r39.c;
        if (r40 == null) goto L233;
        Integer r41 = Integer.valueOf(r40.size());
    L234:
        r38.append(r41);
        ALogger.i("LinkPkInteractAudienceWindowManagerV2", r38.toString());
    L233:
        r41 = null;
        goto L234
    L222:
        r36 = "";
    L235:
        FrameLayout.LayoutParams r42 = new FrameLayout.LayoutParams(r20.y, r20.v);
        r42.topMargin = r20.x;
        LinkPkInteractGuestDataContext r43 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r43 == null) goto L238;
        String r44 = r43.getSelfAnchorLinkMicId();
    L240:
        if (TextUtils.equals(r21, r44) == false) goto L242;
        int r115 = 0;
    L243:
        r42.leftMargin = r115;
        if (TextUtils.equals(r21, r44) == false) goto L246;
        int r45 = r20.v - (r20.y / 2);
    L247:
        r42.height = r45;
        if (FoldScreenUtils.f() == false) goto L253;
        if (FoldScreenUtils.a() != 0) goto L253;
        int r46 = s1.y();
        int r47 = r20.y;
        r42.leftMargin = ((r46 - (r47 * 2)) / 2) + r47;
    L253:
        if ((r31 instanceof SurfaceView) == false) goto L255;
        ((SurfaceView) r31).setZOrderMediaOverlay(true);
    L255:
        r31.setLayoutParams(r42);
        if (r31.getParent() == null) goto L265;
        if (r31.getParent() == r20.b) goto L265;
        ViewParent r48 = r31.getParent();
        if (r48 == null) goto L263;
        ((ViewGroup) r48).removeView(r31);
        goto L265
    L263:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L265:
        if (r20.b.getParent() == null) goto L271;
        ViewParent r49 = r20.b.getParent();
        if (r49 == null) goto L270;
        ((ViewGroup) r49).removeView(r31);
        goto L271
    L270:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L271:
        ((ArrayList) r20.e).remove(r31);
        if (r20.b.getParent() == null) goto L278;
        ViewParent r50 = r20.b.getParent();
        if (r50 == null) goto L277;
        int r51 = 0;
        ((ViewGroup) r50).addView(r31, 0);
    L280:
        if (TextUtils.equals(r21, r44) == false) goto L282;
        ListProtector.add(r20.e, r51, r31);
    L284:
        if (((ArrayList) r20.e).size() <= 1) goto L302;
        DataCenter r1 = r20.u;
        if (r1 == null) goto L290;
        Boolean r52 = (Boolean) r1.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r52 == null) goto L290;
        boolean r53 = r52.booleanValue();
        boolean r54 = true;
    L291:
        r20.j(r54 ^ r53);
        return;
    L290:
        r54 = true;
        r53 = false;
        goto L291
    L302:
        return;
    L282:
        ((ArrayList) r20.e).add(r31);
        goto L284
    L277:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L278:
        r51 = 0;
        goto L280
    L246:
        r45 = r20.v;
        goto L247
    L242:
        r115 = r20.y;
        goto L243
    L238:
        r44 = null;
        goto L240
    L216:
        r34 = null;
        goto L218
    L305:
        return;
    L191:
        if (n.b() == false) goto L211;
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r55 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r55 == null) goto L195;
        String r56 = r55.getSelfAnchorLinkMicId();
    L197:
        if (((ArrayList) r20.f).contains(r32) == true) goto L203;
        if (TextUtils.equals(r21, r56) == false) goto L201;
        ListProtector.add(r20.f, 0, r32);
        goto L203
    L201:
        ((ArrayList) r20.f).add(r32);
    L203:
        if (((ArrayList) r20.f).size() <= 1) goto L300;
        DataCenter r57 = r20.u;
        if (r57 == null) goto L209;
        Boolean r58 = (Boolean) r57.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r58 == null) goto L209;
        boolean r59 = r58.booleanValue();
        boolean r60 = true;
    L210:
        r20.i(r60 ^ r59, "addAnchorLayers");
        return;
    L209:
        r60 = true;
        r59 = false;
        goto L210
    L300:
        return;
    L195:
        r56 = null;
        goto L197
    L163:
        if (TextUtils.equals(r21, r13) == true) goto L188;
        if (r113 != null) goto L167;
    L169:
        el0.a r61 = r20.o("0", r21);
        if (r61 == null) goto L172;
        r20.y(r61);
    L172:
        el0.a r62 = r20.n(r21);
        if (r62 != null) goto L176;
        return;
    L176:
        if (TextUtils.equals(r21, tc0.c.h().f) == false) goto L178;
        r20.g = r62;
    L178:
        if (r112 == null) goto L183;
        View r63 = r112;
        if ((r63 instanceof SurfaceView) == false) goto L182;
        ((SurfaceView) r63).setZOrderMediaOverlay(true);
    L182:
        r62.a(r63);
    L183:
        r20.h(r62);
        i r65 = r20.h;
        if (r65 == null) goto L186;
        CopyOnWriteArrayList<LinkPlayerInfo> r66 = r65.c;
    L187:
        r20.onOnlineListChanged(r66);
        return;
    L186:
        r66 = null;
        goto L187
    L167:
        if (n.b() == false) goto L169;
        z.a r67 = r113;
        r20.m.put(r21, r67);
        r20.k(r21, r67, "onuserJoin interactId = ".concat(r21));
        goto L169
    L303:
        return;
    L149:
        r30 = false;
        goto L150
    L151:
        if (r25 != 0) goto L153;
        boolean r68 = true;
    L154:
        r20.j(r68);
        goto L155
    L153:
        r68 = false;
    L137:
        if (r25 != 0) goto L145;
        if (r111 == false) goto L145;
        DataCenter r69 = r20.u;
        if (r69 == null) goto L142;
        r69.put("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L142:
        ILinkServiceExternal r70 = k.f(ILinkServiceExternal.class);
        if (r70 == null) goto L145;
        r70.onAudienceJoinGuestLink(false);
    L121:
        if (r114 != 0) goto L129;
        if (r18 == false) goto L129;
        DataCenter r71 = r20.u;
        if (r71 == null) goto L126;
        r71.put("cmd_what_audience_join_self_link", Boolean.FALSE);
    L126:
        ILinkServiceExternal r72 = k.f(ILinkServiceExternal.class);
        if (r72 == null) goto L129;
        r72.onAudienceJoinSelfLink(false);
        goto L129
    L58:
        if (r20.A == null) goto L112;
        if (r2 != null) goto L61;
        if (r4 == null) goto L112;
    L61:
        LinkPkInteractGuestDataContext r116 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r116 == null) goto L64;
        String r117 = r116.getAudienceSelfLinkMicId();
    L66:
        if (TextUtils.equals(r21, r117) == false) goto L81;
        com.bytedance.android.live.livepkaudience.rtc.a r118 = r20.A;
        if (r118 == null) goto L81;
        Map<String, Object> r119 = r118.s;
        if (r119 == null) goto L81;
        if (r119.containsKey(r21) == true) goto L81;
        com.bytedance.android.live.livepkaudience.rtc.a r120 = r20.A;
        if (r120 == null) goto L81;
        Map<String, Object> r121 = r120.s;
        if (r121 == null) goto L81;
        if (r4 != null) goto L79;
        Intrinsics.checkNotNull(r2);
        z.a r122 = r2;
    L80:
        r121.put(r21, r122);
        goto L81
    L79:
        r122 = r4;
    L81:
        com.bytedance.android.live.livepkaudience.rtc.a r123 = r20.A;
        if (r123 == null) goto L112;
        Map<String, Object> r124 = r123.s;
        if (r124 == null) goto L112;
        Iterator<String> r125 = r124.keySet().iterator();
        r114 = 0;
        int r126 = 0;
    L87:
        if (r125.hasNext() == false) goto L111;
        Iterator<String> r127 = r125;
        String r128 = r125.next();
        View r129 = r2;
        z.a r130 = r4;
        ALogger.w("LinkPkInteractAudienceWindowManagerV2", "onUserJoined guestRtcManager map key = " + r128);
        i r73 = r20.h;
        if ((r73 instanceof i) == true) goto L91;
        r73 = null;
    L91:
        if (r73 != null) goto L93;
    L99:
        i r74 = r20.h;
        if ((r74 instanceof i) == true) goto L102;
        r74 = null;
    L102:
        if (r74 == null) goto L110;
        if (r74.z(r128) != true) goto L110;
        r114 = r114 + 1;
        if (r114 == 1) goto L109;
        r128 = "";
    L109:
        r20.B = r128;
    L110:
        r2 = r129;
        r125 = r127;
        r4 = r130;
        goto L87
    L93:
        if (r73.v(r128) != true) goto L99;
        int r75 = r126 + 1;
        if (r75 == 1) goto L98;
        r128 = "";
    L98:
        r20.C = r128;
        r126 = r75;
        goto L110
    L111:
        r112 = r2;
        r113 = r4;
        r25 = r126;
        goto L113
    L64:
        r117 = null;
    L54:
        r111 = false;
    L48:
        r18 = false;
        goto L49
    L42:
        r13 = null;
        goto L43
    L20:
        r8 = null;
        goto L21
    L9:
        r4 = r23;
        goto L10
    L5:
        r2 = r22;
        goto L7
    }

    public LinkPkInteractAudienceWindowManagerV2(FrameLayout r2, i r3, FragmentActivity r4, LifecycleOwner r5, View r6, xk0.b r7, q r8, LinkPkInteractGuestDataContext r9) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r6, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r7, "callBack");
        Intrinsics.checkNotNullParameter(r9, "linkPkInteractDataContext");
        this.M = r2;
        this.N = r3;
        this.O = r5;
        this.P = r6;
        this.Q = r7;
        this.R = r8;
        this.S = r9;
        this.a = r4;
        this.b = r2;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.h = r3;
        this.l = "0";
        this.m = new LinkedHashMap();
        this.s = true;
        this.B = "";
        this.C = "";
        this.D = -2;
        this.E = -2;
        RevPkState r10 = RevPkState.DISABLE;
        this.G = k.n(ILinkServiceExternal.class).getPkServiceExternal();
        this.H = k.n(ILinkServiceExternal.class).getMultiDataHolderExternal();
        this.I = new d(this);
        this.J = new c(this);
        this.K = new e(this);
        this.L = new f(this);
        if (r3 == null) goto L5;
        r3.c(this);
    L5:
        this.o = new w(this);
        s1.f(4.0f);
        this.F = new com.bytedance.android.live.livepkaudience.seat.f();
        if (((Boolean) jh0.a.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        if (us1.b.c() == false) goto L12;
        r2.setVisibility(8);
        return;
    }
}
