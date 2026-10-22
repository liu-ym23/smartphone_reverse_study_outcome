package com.bytedance.android.live.livepkaudience.window;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.live.livepkaudience.base.i;
import com.bytedance.android.live.livepkaudience.base.y;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.seat.PkSeatAnimationView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.config.bh0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import el0.f;
import el0.g;
import gd0.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import nc0.r;
import nc0.s;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001\bR$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/window/LinkPkInteractAnchorWindowManagerV2;", "Lcom/bytedance/android/live/livepkaudience/base/y;", "Lel0/a$a;", "Lel0/f$a;", "Lcom/bytedance/android/live/liveinteract/animation/e;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "activity", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LinkPkInteractAnchorWindowManagerV2 extends y implements el0.a.InterfaceC0204a, f.a, com.bytedance.android.live.liveinteract.animation.e, Observer<KVData> {
    public static final /* synthetic */ int G = 0;
    public final d A;
    public final e B;
    public final FrameLayout C;
    public final LifecycleOwner D;
    public final View E;
    public final LinkPkInteractGuestDataContext F;
    public final FragmentActivity a;
    public final FrameLayout b;
    public List<el0.a> c;
    public final List<el0.a> d;
    public final i e;
    public View.OnClickListener f;
    public String g;
    public final f h;
    public final Room i;
    public boolean j;
    public boolean k;
    public DataCenter l;
    public com.bytedance.android.live.livepkaudience.rtc.d m;
    public d0 n;
    public int o;
    public int p;
    public int q;
    public gy.f r;
    public String s;
    public String t;
    public int u;
    public int v;
    public final com.bytedance.android.live.livepkaudience.seat.f w;
    public final lc0.c x;
    public final lc0.d y;
    public final c z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LinkPkInteractAnchorWindowManagerV2 a;

        public b(LinkPkInteractAnchorWindowManagerV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            View.OnClickListener r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAnchorWindowManagerV2 a;

        public c(LinkPkInteractAnchorWindowManagerV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            KVData r7 = (KVData) r6;
            LinkPkInteractAnchorWindowManagerV2 r0 = this.a;
            r0.getClass();
            int r1 = ((IInteractService) k.n(IInteractService.class)).getLinkMode();
            Boolean r2 = null;
            if (r7 == null) goto L5;
            String r3 = r7.getKey();
        L7:
            if (Intrinsics.areEqual("data_intimate_chat_support_send_gift_to_linker", r3) == true) goto L9;
        L10:
            if (r7 == null) goto L12;
            String r4 = r7.getKey();
        L14:
            if (Intrinsics.areEqual("data_big_party_support_send_gift_to_linker", r4) == true) goto L16;
            return;
        L16:
            if (v.a(r1, 32) == false) goto L25;
        L17:
            if (r7 == null) goto L19;
            r2 = (Boolean) r7.getData(Boolean.FALSE);
        L19:
            boolean r8 = Intrinsics.areEqual(r2, Boolean.TRUE);
            Iterator<el0.a> r5 = r0.c.iterator();
        L21:
            if (r5.hasNext() == false) goto L26;
            r5.next().setIsOpenSendGift(r8);
            goto L21
        L26:
            return;
        L25:
            return;
        L12:
            r4 = null;
            goto L14
        L9:
            if (v.a(r1, 2) == true) goto L17;
        L5:
            r3 = null;
            goto L7
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAnchorWindowManagerV2 a;

        public d(LinkPkInteractAnchorWindowManagerV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            RevPkState r8 = (RevPkState) r7;
            LinkPkInteractAnchorWindowManagerV2 r0 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r8, "state");
            if (r8 != RevPkState.PK) goto L16;
            LinkPkInteractGuestDataContext r9 = r0.F;
            if (r9 == null) goto L10;
            m<Long> r10 = r9.getHasAudienceOnlineTime();
            if (r10 == null) goto L10;
            if (((Number) r10.getValue()).longValue() != 0) goto L10;
            return;
        L10:
            LinkPkInteractGuestDataContext r11 = r0.F;
            if (r11 == null) goto L36;
            m<Long> r12 = r11.getHasAudienceOnlineTime();
            if (r12 == null) goto L37;
            r12.setValue(Long.valueOf(System.currentTimeMillis()));
            return;
        L37:
            return;
        L36:
            return;
        L16:
            if (r8 != RevPkState.PENAL) goto L29;
            LinkPkInteractGuestDataContext r13 = r0.F;
            if (r13 == null) goto L23;
            m<Long> r14 = r13.getHasAudienceOnlineTime();
            if (r14 == null) goto L23;
            if (((Number) r14.getValue()).longValue() != 0) goto L23;
            return;
        L23:
            LinkPkInteractGuestDataContext r15 = r0.F;
            if (r15 == null) goto L40;
            m<Long> r16 = r15.getHasAudienceOnlineTime();
            if (r16 == null) goto L41;
            r16.setValue(Long.valueOf(System.currentTimeMillis()));
            return;
        L41:
            return;
        L40:
            return;
        L29:
            if (r8 != RevPkState.DISABLE) goto L43;
            com.bytedance.android.live.livepkaudience.rtc.d r17 = r0.m;
            if (r17 == null) goto L33;
            r17.c();
        L33:
            r0.m = null;
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAnchorWindowManagerV2 a;

        public e(LinkPkInteractAnchorWindowManagerV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            Long r10 = (Long) r9;
            LinkPkInteractAnchorWindowManagerV2 r0 = this.a;
            r0.getClass();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.longValue() != 1) goto L45;
            int r11 = el0.c.a[r0.y.d().ordinal()];
            Long r3 = null;
            if (r11 != 1) goto L9;
            LinkPkInteractGuestDataContext r12 = r0.F;
            if (r12 == null) goto L32;
            m<Long> r13 = r12.getHasAudienceOnlineTime4Pk();
            if (r13 == null) goto L32;
            Long r14 = (Long) r13.getValue();
        L33:
            long r4 = r14.longValue();
            LinkPkInteractGuestDataContext r15 = r0.F;
            if (r15 == null) goto L49;
            m<Long> r16 = r15.getHasAudienceOnlineTime4Pk();
            if (r16 == null) goto L50;
            long r5 = r4 + System.currentTimeMillis();
            LinkPkInteractGuestDataContext r1 = r0.F;
            if (r1 == null) goto L42;
            m<Long> r2 = r1.getHasAudienceOnlineTime();
            if (r2 == null) goto L42;
            r3 = (Long) r2.getValue();
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
            LinkPkInteractGuestDataContext r17 = r0.F;
            if (r17 == null) goto L16;
            m<Long> r18 = r17.getHasAudienceOnlineTime4Penalty();
            if (r18 == null) goto L16;
            Long r19 = (Long) r18.getValue();
        L17:
            long r6 = r19.longValue();
            LinkPkInteractGuestDataContext r20 = r0.F;
            if (r20 == null) goto L46;
            m<Long> r21 = r20.getHasAudienceOnlineTime4Penalty();
            if (r21 == null) goto L47;
            long r7 = r6 + System.currentTimeMillis();
            LinkPkInteractGuestDataContext r8 = r0.F;
            if (r8 == null) goto L26;
            m<Long> r22 = r8.getHasAudienceOnlineTime();
            if (r22 == null) goto L26;
            r3 = (Long) r22.getValue();
        L26:
            r21.setValue(Long.valueOf((r7 - r3.longValue()) / ((long) 1000)));
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

    public final void h() {
        int r0 = ((ArrayList) this.c).size();
        if (this.k == false) goto L73;
        s1.f(52);
        s1.f(12);
        j();
        DataCenter r1 = this.l;
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.get("data_pk_ui_change", 0);
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        int r4 = 0;
    L11:
        if (r4 >= r0) goto L62;
        el0.a r5 = (el0.a) ListProtector.get(this.c, r4);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L61;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        r7.gravity = 48;
        r7.topMargin = (this.p + this.o) - (this.q / 2);
        g r8 = r5.getPresenter();
        if (r8 == null) goto L18;
        String r9 = r8.c();
        if (r9 == null) goto L18;
    L19:
        i r10 = this.e;
        if ((r10 instanceof i) == true) goto L22;
        int r11 = 0;
    L47:
        r7.leftMargin = ((this.q / 2) * r11) + Math.max(0, r3);
        if (this.m == null) goto L50;
        com.bytedance.android.live.livepkaudience.rtc.d.d(r11);
    L50:
        int r12 = this.q / 2;
        r7.width = r12;
        r7.height = r12;
        r5.setLayoutParams(r7);
        gy.f r13 = this.r;
        if (r13 == null) goto L59;
        s r14 = r13.L();
        if (r14 == null) goto L59;
        r r15 = r14.e(r9);
        if (r15 == null) goto L59;
        Pair r16 = r15.a.i;
        if (r16 == null) goto L59;
        r5.setDebugText(((Number) r16.getFirst()).intValue() + " x " + ((Number) r16.getSecond()).intValue());
    L59:
        r4 = r4 + 1;
        goto L11
    L22:
        if (r10 == null) goto L45;
        LinkPlayerInfo r17 = r10.o("0", r9);
        i r18 = this.e;
        if (r18 == null) goto L43;
        boolean r19 = r18.v(r9);
        i r110 = this.e;
        if (r110 == null) goto L41;
        String r111 = r110.r(r9);
        i r112 = this.e;
        if (r112 == null) goto L39;
        int r20 = r112.O4(r111);
        if (r19 == false) goto L32;
        r11 = r20 + 1;
    L33:
        if (r17 == null) goto L37;
        boolean r113 = r5.getMIsBackGround();
        boolean r114 = r17.isBackground;
        if (r113 == r114) goto L37;
        r5.B3(!r114);
        r5.setMIsBackGround(r17.isBackground);
    L37:
        r5.setIsSelfRoomWindow(!r19);
        goto L47
    L32:
        r11 = r20 - 1;
        goto L33
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L43:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L18:
        r9 = "";
        goto L19
    L61:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L62:
        int r21 = ((ArrayList) this.d).size();
        int r22 = 0;
    L63:
        if (r22 >= r21) goto L73;
        el0.a r23 = (el0.a) ListProtector.get(this.d, r22);
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if ((r24 instanceof FrameLayout.LayoutParams) == true) goto L67;
        r24 = null;
    L67:
        FrameLayout.LayoutParams r25 = (FrameLayout.LayoutParams) r24;
        if (r25 == null) goto L70;
        r25.topMargin = (this.p + this.o) - (this.q / 2);
    L70:
        if (r25 == null) goto L72;
        r23.setLayoutParams(r25);
    L72:
        r22 = r22 + 1;
    L9:
        r3 = 0;
    L73:
        DataCenter r26 = this.l;
        if (r26 == null) goto L91;
        r26.put("cmd_interact_player_view_change", new kd0.a(false, 0));
        return;
    }

    public final void j() {
        this.p = k.n(ILinkServiceExternal.class).getPkService().G().a;
        this.o = k.n(ILinkServiceExternal.class).getPkService().G().c;
        this.q = k.n(ILinkServiceExternal.class).getPkService().G().b;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final FrameLayout vj() {
        View r0 = this.E;
        if (r0 == null) goto L7;
        return (FrameLayout) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final FragmentActivity getActivity() {
        return this.a;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final void Bn(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        com.bytedance.android.live.livepkaudience.seat.f r0 = this.w;
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
        return l(r3);
    }

    public final EPointF l(int r4) {
        j();
        int r0 = this.p + ((this.o - (this.q / 2)) / 2);
        if (r4 != 0) goto L6;
        return k(null, new Point(s1.y() / 4, r0));
    L6:
        return k(i(this.g, ""), null);
    }

    public final void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
        if (r2 == null) goto L6;
        r2.getData();
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        Iterator<? extends LinkPlayerInfo> r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L15;
        LinkPlayerInfo r1 = r15.next();
        Iterator r2 = ((ArrayList) this.c).iterator();
    L9:
        if (r2.hasNext() == false) goto L6;
        el0.a r3 = (el0.a) r2.next();
        if (r3.getPresenter() == null) goto L9;
        if (TextUtils.equals(r1.getInteractId(), r3.getPresenter().c()) == false) goto L9;
        r3.getPresenter().g(r1);
        r0.add(r3);
        ((ArrayList) this.c).remove(r3);
        goto L6
    L15:
        r0.addAll(this.c);
        this.c = r0;
        h();
        boolean r4 = false;
        if (((Boolean) bh0.a.getValue()).booleanValue() == false) goto L119;
        DataCenter r16 = this.l;
        if (r16 == null) goto L23;
        Boolean r17 = (Boolean) r16.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r17 == null) goto L23;
        boolean r18 = r17.booleanValue();
    L24:
        DataCenter r5 = this.l;
        if (r5 == null) goto L29;
        Boolean r6 = (Boolean) r5.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r6 == null) goto L29;
        boolean r7 = r6.booleanValue();
    L30:
        gy.c.c2.getClass();
        gy.c r8 = gy.c.a.a();
        gy.f r9 = this.r;
        if (r9 == null) goto L55;
        s r10 = r9.L();
        if (r10 == null) goto L55;
        Iterator r11 = ((HashMap) r10.c()).keySet().iterator();
        int r12 = 0;
        int r13 = 0;
    L36:
        if (r11.hasNext() == false) goto L56;
        String r19 = (String) r11.next();
        i r110 = this.e;
        if (r110 == null) goto L46;
        if (r110.v(r19) != true) goto L46;
        r13 = r13 + 1;
        if (r13 == 1) goto L45;
        r19 = "";
    L45:
        this.t = r19;
    L46:
        i r111 = this.e;
        if (r111 == null) goto L36;
        if (r111.z(r19) != true) goto L36;
        r12 = r12 + 1;
        if (r12 == 1) goto L54;
        r19 = "";
    L54:
        this.s = r19;
    L56:
        if (r12 <= 0) goto L70;
        LinkPkInteractGuestDataContext r20 = this.F;
        if (r20 == null) goto L70;
        m<Long> r21 = r20.getHasAudienceOnlineTime();
        if (r21 == null) goto L70;
        if (((Number) r21.getValue()).longValue() != 0) goto L70;
        LinkPkInteractGuestDataContext r22 = this.F;
        if (r22 == null) goto L68;
        m<Long> r23 = r22.getHasAudienceOnlineTime();
        if (r23 == null) goto L68;
        r23.setValue(Long.valueOf(System.currentTimeMillis()));
    L68:
        this.y.a(this.A);
        this.y.E(this.B);
    L70:
        if (r12 <= 0) goto L86;
        if (r18 == true) goto L86;
        DataCenter r24 = this.l;
        if (r24 == null) goto L80;
        if (r8 == null) goto L78;
        gy.f r25 = r8.getRtcManager();
        if (r25 == null) goto L78;
        boolean r26 = r25.G();
    L79:
        r24.put("cmd_what_is_single_view_mode", Boolean.valueOf(r26));
    L78:
        r26 = false;
    L80:
        DataCenter r27 = this.l;
        if (r27 == null) goto L83;
        r27.put("cmd_what_audience_join_self_link", Boolean.TRUE);
    L83:
        ILinkServiceExternal r28 = k.f(ILinkServiceExternal.class);
        if (r28 == null) goto L102;
        r28.onAudienceJoinSelfLink(true);
    L102:
        if (r13 <= 0) goto L110;
        if (r7 == true) goto L110;
        DataCenter r29 = this.l;
        if (r29 == null) goto L107;
        r29.put("cmd_what_audience_join_guest_link", Boolean.TRUE);
    L107:
        ILinkServiceExternal r30 = k.f(ILinkServiceExternal.class);
        if (r30 == null) goto L118;
        r30.onAudienceJoinGuestLink(true);
    L118:
        m(r12, r18, r13, r7);
    L110:
        if (r13 != 0) goto L118;
        if (r7 == false) goto L118;
        DataCenter r31 = this.l;
        if (r31 == null) goto L115;
        r31.put("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L115:
        ILinkServiceExternal r32 = k.f(ILinkServiceExternal.class);
        if (r32 == null) goto L118;
        r32.onAudienceJoinGuestLink(false);
    L86:
        if (r12 != 0) goto L102;
        if (r18 == false) goto L102;
        DataCenter r33 = this.l;
        if (r33 == null) goto L96;
        if (r8 == null) goto L94;
        gy.f r34 = r8.getRtcManager();
        if (r34 == null) goto L94;
        boolean r35 = r34.G();
    L95:
        r33.put("cmd_what_is_single_view_mode", Boolean.valueOf(r35));
    L94:
        r35 = false;
    L96:
        DataCenter r36 = this.l;
        if (r36 == null) goto L99;
        r36.put("cmd_what_audience_join_self_link", Boolean.FALSE);
    L99:
        ILinkServiceExternal r37 = k.f(ILinkServiceExternal.class);
        if (r37 == null) goto L102;
        r37.onAudienceJoinSelfLink(false);
    L55:
        r12 = 0;
        r13 = 0;
    L29:
        r7 = false;
    L23:
        r18 = false;
    L119:
        ILinkServiceExternal r112 = k.f(ILinkServiceExternal.class);
        if (r112 != null) goto L122;
        return;
    L122:
        if (r112.isSpatialAudioEnable(4) != true) goto L164;
        i r113 = this.e;
        List<LinkPlayerInfo> r38 = null;
        if ((r113 instanceof i) == true) goto L126;
        r113 = null;
    L126:
        if (r113 == null) goto L128;
        r38 = r113.h();
    L128:
        DataCenter r114 = this.l;
        if (r114 == null) goto L133;
        Boolean r115 = (Boolean) r114.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r115 == null) goto L133;
        boolean r116 = r115.booleanValue();
    L134:
        DataCenter r39 = this.l;
        if (r39 == null) goto L139;
        Boolean r40 = (Boolean) r39.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r40 == null) goto L139;
        r4 = r40.booleanValue();
    L139:
        if (r116 == true) goto L141;
        if (r4 == true) goto L141;
        return;
    L141:
        k.n(ILinkServiceExternal.class).getPkServiceExternal().h(true, Boolean.FALSE, r38, "LinkPkInteractAnchorWindowManagerV2");
        return;
    L133:
        r116 = false;
        goto L134
    }

    public final void p(el0.a r2) {
        this.b.removeView(r2);
        List<el0.a> r0 = this.c;
        if (r0 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r0).remove(r2);
        h();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public final void q(boolean r5) {
        Iterator<el0.a> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        el0.a r1 = r0.next();
        if (r1.getPresenter() == null) goto L4;
        i r2 = this.e;
        if ((r2 instanceof i) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L4;
        if (r2.v(r1.getPresenter().c()) != true) goto L4;
        r1.e(r5);
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int qq(int r1) {
        return s1.j(2131169230);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean wc(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        com.bytedance.android.live.livepkaudience.seat.f r0 = this.w;
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
        this.g = r3;
        i r2 = this.e;
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
        return l(r1);
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final boolean K5(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "fromUserId");
        Intrinsics.checkNotNullParameter(r6, "toUSerId");
        Room r2 = this.i;
        if (r2 == null) goto L5;
        String r3 = r2.getOwnerUserIdString();
    L7:
        if ((!Intrinsics.areEqual(r5, r3)) == false) goto L10;
        return false;
    L10:
        Intrinsics.checkNotNullParameter(r5, "fromUserId");
        Intrinsics.checkNotNullParameter(r6, "toUSerId");
        return true;
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final EPointF Kl(int r1, int r2) {
        return l(r2);
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
    public final void a(String r23, String r24) {
        Intrinsics.checkNotNullParameter(r23, "userId");
        DataCenter r3 = this.l;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r4 == null) goto L7;
        boolean r5 = r4.booleanValue();
    L8:
        DataCenter r6 = this.l;
        if (r6 == null) goto L13;
        Boolean r7 = (Boolean) r6.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r7 == null) goto L13;
        boolean r8 = r7.booleanValue();
    L14:
        gy.c.c2.getClass();
        gy.c r9 = gy.c.a.a();
        gy.f r10 = this.r;
        String r12 = "";
        if (r10 == null) goto L97;
        s r11 = r10.L();
        if (r11 == null) goto L19;
        Map r13 = r11.c();
    L20:
        if (r13 == null) goto L46;
        Iterator r14 = r13.keySet().iterator();
        int r15 = 0;
        int r16 = 0;
    L23:
        if (r14.hasNext() == false) goto L47;
        String r17 = (String) r14.next();
        i r18 = this.e;
        if ((r18 instanceof i) == true) goto L27;
        r18 = null;
    L27:
        if (r18 == null) goto L35;
        if (r18.v(r17) != true) goto L35;
        r16 = r16 + 1;
        if (r16 == 1) goto L34;
        r17 = "";
    L34:
        this.t = r17;
    L35:
        i r19 = this.e;
        if ((r19 instanceof i) == true) goto L38;
        r19 = null;
    L38:
        if (r19 == null) goto L23;
        if (r19.z(r17) != true) goto L23;
        r15 = r15 + 1;
        if (r15 == 1) goto L45;
        r17 = "";
    L45:
        this.s = r17;
    L47:
        if (r15 != 0) goto L98;
        LinkPkInteractGuestDataContext r20 = this.F;
        if (r20 == null) goto L55;
        m<Long> r21 = r20.getHasAudienceOnlineTime();
        if (r21 == null) goto L55;
        if (((Number) r21.getValue()).longValue() == 0) goto L98;
    L55:
        if (this.y.d() != RevPkState.PK) goto L74;
        LinkPkInteractGuestDataContext r22 = this.F;
        if (r22 == null) goto L61;
        m<Long> r25 = r22.getHasAudienceOnlineTime4Pk();
        if (r25 == null) goto L61;
        Long r26 = (Long) r25.getValue();
    L62:
        long r110 = r26.longValue();
        LinkPkInteractGuestDataContext r27 = this.F;
        if (r27 == null) goto L92;
        m<Long> r28 = r27.getHasAudienceOnlineTime4Pk();
        if (r28 == null) goto L92;
        long r111 = r110 + System.currentTimeMillis();
        LinkPkInteractGuestDataContext r29 = this.F;
        if (r29 == null) goto L71;
        m<Long> r30 = r29.getHasAudienceOnlineTime();
        if (r30 == null) goto L71;
        Long r31 = (Long) r30.getValue();
    L72:
        r28.setValue(Long.valueOf((r111 - r31.longValue()) / ((long) 1000)));
    L71:
        r31 = null;
    L92:
        LinkPkInteractGuestDataContext r32 = this.F;
        if (r32 == null) goto L98;
        m<Long> r33 = r32.getHasAudienceOnlineTime();
        if (r33 == null) goto L98;
        r33.setValue(0L);
    L61:
        r26 = null;
        goto L62
    L74:
        if (this.y.d() != RevPkState.PENAL) goto L92;
        LinkPkInteractGuestDataContext r34 = this.F;
        if (r34 == null) goto L80;
        m<Long> r35 = r34.getHasAudienceOnlineTime4Penalty();
        if (r35 == null) goto L80;
        Long r36 = (Long) r35.getValue();
    L81:
        long r112 = r36.longValue();
        LinkPkInteractGuestDataContext r37 = this.F;
        if (r37 == null) goto L92;
        m<Long> r38 = r37.getHasAudienceOnlineTime4Penalty();
        if (r38 == null) goto L92;
        long r113 = r112 + System.currentTimeMillis();
        LinkPkInteractGuestDataContext r114 = this.F;
        if (r114 == null) goto L90;
        m<Long> r115 = r114.getHasAudienceOnlineTime();
        if (r115 == null) goto L90;
        Long r116 = (Long) r115.getValue();
    L91:
        r38.setValue(Long.valueOf((r113 - r116.longValue()) / ((long) 1000)));
    L90:
        r116 = null;
    L80:
        r36 = null;
    L98:
        if (r15 != 0) goto L114;
        if (r5 == false) goto L114;
        DataCenter r39 = this.l;
        if (r39 == null) goto L108;
        if (r9 == null) goto L106;
        gy.f r40 = r9.getRtcManager();
        if (r40 == null) goto L106;
        boolean r41 = r40.G();
    L107:
        r39.put("cmd_what_is_single_view_mode", Boolean.valueOf(r41));
    L106:
        r41 = false;
    L108:
        DataCenter r42 = this.l;
        if (r42 == null) goto L111;
        r42.put("cmd_what_audience_join_self_link", Boolean.FALSE);
    L111:
        ILinkServiceExternal r43 = k.f(ILinkServiceExternal.class);
        if (r43 == null) goto L114;
        r43.onAudienceJoinSelfLink(false);
    L114:
        if (r16 != 0) goto L122;
        if (r8 == false) goto L122;
        DataCenter r44 = this.l;
        if (r44 == null) goto L119;
        r44.put("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L119:
        ILinkServiceExternal r45 = k.f(ILinkServiceExternal.class);
        if (r45 == null) goto L122;
        r45.onAudienceJoinGuestLink(false);
    L122:
        String r46 = "WindowManager onUserLeaved selfOnlineCount = " + r15 + ", selfHasAudienceJoin = " + r5 + ", guestOnlineCount = " + r16 + ", guestHasAudienceJoin = " + r8;
        ALogger.w("LinkPkInteractAnchorWindowManagerV2", r46);
        dl0.m.a.getClass();
        dl0.m.C("LinkPkInteractAnchorWindowManagerV2_onUserLeaved", r46);
        m(r15, r5, r16, r8);
        if (this.j == true) goto L125;
        return;
    L125:
        el0.a r47 = i(r23, r24);
        if (r47 != null) goto L128;
        return;
    L128:
        Room r48 = this.i;
        if (r48 == null) goto L133;
        User r49 = r48.getOwner();
        if (r49 == null) goto L133;
        String r117 = r49.getIdStr();
    L134:
        i r50 = this.e;
        if (r50 == null) goto L137;
        boolean r51 = r50.u(r24);
    L139:
        if (r47.getPresenter() != null) goto L141;
    L154:
        p(r47);
        f r52 = this.h;
        if (r52 == null) goto L169;
        r52.a(r23, r24);
        return;
    L169:
        return;
    L141:
        if ((!Intrinsics.areEqual(r47.getPresenter().f(), r117)) == false) goto L154;
        if (r51 == true) goto L154;
        LinkPlayerInfo r53 = r47.getPresenter().d();
        FragmentActivity r54 = this.a;
        if (r54 == null) goto L154;
        Object[] r55 = new Object[1];
        if (r53 == null) goto L153;
        IBaseUser r56 = r53.getUser();
        if (r56 == null) goto L153;
        String r57 = r56.getNickName();
        if (r57 == null) goto L153;
        r12 = r57;
    L153:
        r55[0] = r12;
        IESUIUtils.displayToast(r54, r54.getString(2131919329, r55));
        goto L154
    L137:
        r51 = false;
    L133:
        r117 = null;
        goto L134
    L46:
        r15 = 0;
        r16 = 0;
        goto L47
    L19:
        r13 = null;
        goto L20
    L97:
        r15 = 0;
        r16 = 0;
    L13:
        r8 = false;
    L7:
        r5 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void e(List r4, WaitingListUser r5) {
        String r6 = "";
        if (Lists.isEmpty(r4) == false) goto L7;
        DataCenter r7 = this.l;
        if (r7 == null) goto L23;
        r7.put("data_interact_number_dot_show", "");
        return;
    L23:
        return;
    L7:
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r8 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r8 == null) goto L12;
        i r9 = r8.getLinkUserCenter();
        if (r9 == null) goto L12;
        int r10 = ((ArrayList) r9.p()).size();
    L13:
        String r1 = String.valueOf(r10);
        if (r10 <= 99) goto L16;
        r1 = "99+";
    L16:
        if (r10 <= 0) goto L19;
        r6 = r1;
    L19:
        DataCenter r11 = this.l;
        if (r11 == null) goto L25;
        r11.put("data_interact_number_dot_show", r6);
        return;
    L25:
        return;
    L12:
        r10 = 0;
        goto L13
    }

    public final void g(boolean r7, int r8) {
        if (((ArrayList) this.d).size() > 1) goto L5;
        return;
    L5:
        el0.a r0 = (el0.a) ListProtector.get(this.d, !r7 ? 1 : 0);
        this.b.addView(r0);
        if (r7 == false) goto L8;
        r0.setOnClickListener(new b(this));
    L8:
        j();
        r0.d(false, r7);
        ViewGroup.LayoutParams r9 = r0.getLayoutParams();
        if (r9 == null) goto L32;
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r9;
        DataCenter r2 = this.l;
        if (r2 == null) goto L15;
        Integer r3 = (Integer) r2.get("data_pk_ui_change", 0);
        if (r3 == null) goto L15;
        int r4 = r3.intValue();
    L16:
        r10.gravity = 48;
        int r5 = this.p + this.o;
        int r6 = this.q / 2;
        r10.topMargin = r5 - r6;
        r10.leftMargin = (r6 * r8) + Math.max(0, r4);
        int r11 = this.q / 2;
        r10.width = r11;
        r10.height = r11;
        r0.setLayoutParams(r10);
        if (this.n != null) goto L19;
    L21:
        com.bytedance.android.live.livepkaudience.rtc.d r12 = this.m;
        if (r12 == null) goto L33;
        Bitmap r1 = r12.c.get(com.bytedance.android.live.livepkaudience.rtc.d.a(r8));
        if (r1 == null) goto L26;
        com.bytedance.android.live.livepkaudience.rtc.d.b(r1, r8);
        return;
    L26:
        if (r8 >= 2) goto L28;
        Bitmap r13 = r12.b;
    L29:
        com.bytedance.android.live.livepkaudience.rtc.d.a r14 = r12.e;
        int r15 = r14.a;
        int r16 = r14.b;
        Bitmap r17 = Bitmap.createScaledBitmap(r13, r15 - (r15 % 16), r16 - (r16 % 16), false);
        r12.c.put(com.bytedance.android.live.livepkaudience.rtc.d.a(r8), r17);
        com.bytedance.android.live.livepkaudience.rtc.d.b(r17, r8);
        return;
    L28:
        r13 = r12.a;
        goto L29
    L33:
        return;
    L19:
        if (this.m != null) goto L21;
        this.m = new com.bytedance.android.live.livepkaudience.rtc.d();
    L15:
        r4 = 0;
        goto L16
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final el0.a i(String r4, String r5) {
        Iterator<el0.a> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        el0.a r1 = r0.next();
        if (py.v.a(r4) == false) goto L13;
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

    public final EPointF k(el0.a r4, Point r5) {
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

    @Override // com.bytedance.android.live.liveinteract.animation.e
    public final int ma(int r1, int r2) {
        return s1.j(2131169229);
    }

    public final void n(String r22, View r23) {
        Intrinsics.checkNotNullParameter(r22, "interactId");
        String r0 = this.x.y();
        String r2 = "0";
        String r3 = "";
        if (TextUtils.isEmpty(r0) == false) goto L19;
        i r1 = this.e;
        if (r1 == null) goto L17;
        String r4 = this.x.a();
        if (r4 != null) goto L16;
        lc0.d r5 = k.n(ILinkServiceExternal.class).getPkService();
        if (r5 == null) goto L11;
        User r6 = r5.C();
    L12:
        if (r6 == null) goto L15;
        r4 = r6.getIdStr();
        if (r4 != null) goto L16;
    L15:
        r4 = "0";
        goto L16
    L11:
        r6 = null;
    L16:
        r0 = r1.m(r4);
        goto L19
    L17:
        r0 = "";
    L19:
        if (TextUtils.equals(r22, r0) == false) goto L21;
        return;
    L21:
        Room r7 = this.i;
        if (r7 == null) goto L26;
        User r8 = r7.getOwner();
        if (r8 == null) goto L26;
        String r9 = r8.getIdStr();
    L27:
        i r10 = this.e;
        if (r10 == null) goto L30;
        User r11 = r10.t(r22);
    L31:
        if (r11 == null) goto L33;
        String r12 = r11.getIdStr();
    L34:
        String r13 = this.x.a();
        String r14 = this.x.u();
        DataCenter r15 = this.l;
        if (r15 == null) goto L39;
        Boolean r16 = (Boolean) r15.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r16 == null) goto L39;
        boolean r17 = r16.booleanValue();
    L40:
        DataCenter r18 = this.l;
        if (r18 == null) goto L45;
        Boolean r19 = (Boolean) r18.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r19 == null) goto L45;
        boolean r20 = r19.booleanValue();
    L46:
        gy.c.c2.getClass();
        gy.c r110 = gy.c.a.a();
        gy.f r111 = this.r;
        if (r111 == null) goto L77;
        s r112 = r111.L();
        if (r112 == null) goto L77;
        Iterator r113 = ((HashMap) r112.c()).keySet().iterator();
        int r114 = 0;
        int r115 = 0;
    L52:
        if (r113.hasNext() == false) goto L76;
        String r21 = (String) r113.next();
        String r116 = r3;
        i r24 = this.e;
        Iterator r117 = r113;
        if ((r24 instanceof i) == true) goto L56;
        r24 = null;
    L56:
        if (r24 != null) goto L58;
    L64:
        i r25 = this.e;
        if ((r25 instanceof i) == true) goto L67;
        r25 = null;
    L67:
        if (r25 == null) goto L75;
        if (r25.z(r21) != true) goto L75;
        int r26 = r114 + 1;
        if (r26 == 1) goto L74;
        r21 = r116;
    L74:
        this.s = r21;
        r114 = r26;
    L75:
        r3 = r116;
        r113 = r117;
        goto L52
    L58:
        if (r24.v(r21) != true) goto L64;
        int r27 = r115 + 1;
        if (r27 == 1) goto L63;
        r21 = r116;
    L63:
        this.t = r21;
        r115 = r27;
        goto L75
    L76:
        int r28 = r114;
        int r29 = r115;
    L78:
        if (r28 <= 0) goto L92;
        LinkPkInteractGuestDataContext r118 = this.F;
        if (r118 == null) goto L92;
        m<Long> r119 = r118.getHasAudienceOnlineTime();
        if (r119 == null) goto L92;
        if (((Number) r119.getValue()).longValue() != 0) goto L92;
        LinkPkInteractGuestDataContext r120 = this.F;
        if (r120 == null) goto L91;
        m<Long> r121 = r120.getHasAudienceOnlineTime();
        if (r121 == null) goto L91;
        r121.setValue(Long.valueOf(System.currentTimeMillis()));
    L91:
        this.y.a(this.A);
        this.y.E(this.B);
    L94:
        if (r28 <= 0) goto L110;
        if (r17 == true) goto L110;
        DataCenter r122 = this.l;
        if (r122 == null) goto L104;
        if (r110 == null) goto L102;
        gy.f r123 = r110.getRtcManager();
        if (r123 == null) goto L102;
        boolean r124 = r123.G();
    L103:
        r122.put("cmd_what_is_single_view_mode", Boolean.valueOf(r124));
    L102:
        r124 = false;
    L104:
        DataCenter r30 = this.l;
        if (r30 == null) goto L107;
        r30.put("cmd_what_audience_join_self_link", Boolean.TRUE);
    L107:
        ILinkServiceExternal r31 = k.f(ILinkServiceExternal.class);
        if (r31 == null) goto L126;
        r31.onAudienceJoinSelfLink(true);
    L126:
        if (r29 <= 0) goto L134;
        if (r20 == true) goto L134;
        DataCenter r32 = this.l;
        if (r32 == null) goto L131;
        r32.put("cmd_what_audience_join_guest_link", Boolean.TRUE);
    L131:
        ILinkServiceExternal r33 = k.f(ILinkServiceExternal.class);
        if (r33 == null) goto L142;
        r33.onAudienceJoinGuestLink(true);
    L142:
        m(r28, r17, r29, r20);
        if (this.j == true) goto L146;
        return;
    L146:
        if (Intrinsics.areEqual(r12, r9) == false) goto L148;
        return;
    L148:
        if (Intrinsics.areEqual(r12, r13) == false) goto L150;
        return;
    L150:
        if (TextUtils.equals(r22, r0) == false) goto L152;
        return;
    L152:
        if (TextUtils.equals(r22, r14) == true) goto L219;
        String r34 = r2;
        el0.a r35 = i(r34, r22);
        if (r35 == null) goto L158;
        p(r35);
    L158:
        if (q0.a(r34) == false) goto L160;
    L162:
        f r36 = this.h;
        if (r36 == null) goto L165;
        g r37 = r36.g(r22);
    L166:
        FragmentActivity r38 = this.a;
        if (r38 == null) goto L175;
        el0.a r39 = new el0.a(r38, r37, this, this.l, this.w);
        i r40 = this.e;
        if ((r40 instanceof i) == true) goto L171;
        r40 = null;
    L171:
        if (r40 == null) goto L173;
        boolean r125 = r40.v(r22);
    L174:
        r39.setIsSelfRoomWindow(!r125);
    L176:
        if (r39 != null) goto L179;
        return;
    L179:
        if (r23 != null) goto L181;
    L184:
        int r41 = ((IInteractService) k.n(IInteractService.class)).getLinkMode();
        if (v.a(r41, 2) == false) goto L190;
        DataCenter r42 = this.l;
        if (r42 == null) goto L194;
        Boolean r43 = (Boolean) r42.get("data_intimate_chat_support_send_gift_to_linker", Boolean.FALSE);
    L196:
        if (r43 == null) goto L198;
        boolean r126 = r43.booleanValue();
    L199:
        r39.setIsOpenSendGift(r126);
        this.b.addView(r39, 0);
        ((ArrayList) this.c).add(r39);
        if (com.bytedance.android.live.liveinteract.utils.r.a() == true) goto L202;
    L205:
        i r44 = this.e;
        if (r44 == null) goto L208;
        CopyOnWriteArrayList<LinkPlayerInfo> r45 = r44.c;
    L209:
        onOnlineListChanged(r45);
        return;
    L208:
        r45 = null;
        goto L209
    L202:
        if (r39.l == true) goto L205;
        r39.l = true;
        ValueAnimator r46 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        r46.addUpdateListener(new el0.b(r39));
        r46.setInterpolator(new com.bytedance.android.live.core.widget.e(0.0f, 0.0f, 0.58f, 1.0f));
        r46.start();
        goto L205
    L198:
        r126 = false;
    L194:
        r43 = null;
        goto L196
    L190:
        if (v.a(r41, 32) == false) goto L195;
        DataCenter r47 = this.l;
        if (r47 == null) goto L194;
        r43 = (Boolean) r47.get("data_big_party_support_send_gift_to_linker", Boolean.FALSE);
        goto L196
    L195:
        r43 = Boolean.FALSE;
        goto L196
    L181:
        if ((r23 instanceof SurfaceView) == false) goto L183;
        ((SurfaceView) r23).setZOrderMediaOverlay(true);
    L183:
        r39.a(r23);
        goto L184
    L173:
        r125 = false;
    L175:
        r39 = null;
        goto L176
    L165:
        r37 = null;
        goto L166
    L160:
        if (TextUtils.isEmpty(r22) == false) goto L162;
    L219:
        return;
    L134:
        if (r29 != 0) goto L142;
        if (r20 == false) goto L142;
        DataCenter r48 = this.l;
        if (r48 == null) goto L139;
        r48.put("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L139:
        ILinkServiceExternal r49 = k.f(ILinkServiceExternal.class);
        if (r49 == null) goto L142;
        r49.onAudienceJoinGuestLink(false);
    L110:
        if (r28 != 0) goto L126;
        if (r17 == false) goto L126;
        DataCenter r127 = this.l;
        if (r127 == null) goto L120;
        if (r110 == null) goto L118;
        gy.f r128 = r110.getRtcManager();
        if (r128 == null) goto L118;
        boolean r129 = r128.G();
    L119:
        r127.put("cmd_what_is_single_view_mode", Boolean.valueOf(r129));
    L118:
        r129 = false;
    L120:
        DataCenter r50 = this.l;
        if (r50 == null) goto L123;
        r50.put("cmd_what_audience_join_self_link", Boolean.FALSE);
    L123:
        ILinkServiceExternal r51 = k.f(ILinkServiceExternal.class);
        if (r51 == null) goto L126;
        r51.onAudienceJoinSelfLink(false);
    L92:
        r2 = "0";
    L77:
        r28 = 0;
        r29 = 0;
    L45:
        r20 = false;
    L39:
        r17 = false;
        goto L40
    L33:
        r12 = null;
        goto L34
    L30:
        r11 = null;
    L26:
        r9 = null;
        goto L27
    }

    public final void o(boolean r5, boolean r6) {
        if (((ArrayList) this.d).size() > 1) goto L5;
        return;
    L5:
        this.b.removeView((View) ListProtector.get(this.d, !r5 ? 1 : 0));
        if (this.m == null) goto L16;
        if (r6 == false) goto L17;
        if (r5 == false) goto L12;
        com.bytedance.android.live.livepkaudience.rtc.d.d(0);
        if (this.m == null) goto L18;
        com.bytedance.android.live.livepkaudience.rtc.d.d(1);
        return;
    L18:
        return;
    L12:
        com.bytedance.android.live.livepkaudience.rtc.d.d(2);
        if (this.m == null) goto L20;
        com.bytedance.android.live.livepkaudience.rtc.d.d(3);
        return;
    L20:
        return;
    L17:
        return;
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

    public final void m(int r6, boolean r7, int r8, boolean r9) {
        int r0 = -2;
        int r1 = 2;
        if (r6 != 0) goto L5;
        if (r7 == false) goto L5;
    L6:
        o(true, true);
        this.u = -2;
    L8:
        if (r8 != 0) goto L10;
        if (r9 == false) goto L10;
    L11:
        o(false, true);
        this.v = -2;
    L12:
        i r3 = null;
        if (r6 != 1) goto L29;
        i r10 = this.e;
        if ((r10 instanceof i) == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L19;
        int r11 = r10.s(this.s);
    L21:
        if (this.u == r11) goto L29;
        o(true, false);
        this.u = r11;
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
        i r13 = this.e;
        if ((r13 instanceof i) == false) goto L34;
        r3 = r13;
    L34:
        if (r3 == null) goto L37;
        r0 = r3.s(this.t);
    L37:
        if (this.v == r0) goto L46;
        this.v = r0;
        o(false, false);
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

    public LinkPkInteractAnchorWindowManagerV2(Room r2, FrameLayout r3, i r4, FragmentActivity r5, LifecycleOwner r6, View r7, LinkPkInteractGuestDataContext r8) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r7, "interactEmojiLayout");
        Intrinsics.checkNotNullParameter(r8, "linkPkInteractDataContext");
        this.C = r3;
        this.D = r6;
        this.E = r7;
        this.F = r8;
        this.a = r5;
        this.b = r3;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = r4;
        this.g = "0";
        this.i = r2;
        this.s = "";
        this.t = "";
        this.u = -2;
        this.v = -2;
        this.x = k.n(ILinkServiceExternal.class).getMultiDataHolder();
        this.y = k.n(ILinkServiceExternal.class).getPkServiceExternal();
        this.z = new c(this);
        this.A = new d(this);
        this.B = new e(this);
        if ((r4 instanceof i) == true) goto L5;
        i r9 = null;
    L6:
        if (r9 == null) goto L8;
        r9.c(this);
    L8:
        this.h = new f(r2, r4, this);
        s1.f(4.0f);
        this.w = new com.bytedance.android.live.livepkaudience.seat.f();
        return;
    L5:
        r9 = r4;
        goto L6
    }
}
