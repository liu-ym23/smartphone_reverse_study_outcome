package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.connect.MultiAnchorRelinkService;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkInviteContract$View;
import com.bytedance.android.live.revlink.impl.multianchor.ui.AnchorLinkInfoInviteView;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.a5;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IListUserLinkmicContent;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.f6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w6;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/fragment/AnchorLinkInviteFragment;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/contract/AnchorLinkInviteContract$View;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkInviteFragment extends AnchorLinkInviteContract$View implements View.OnClickListener {
    public static final /* synthetic */ int W = 0;
    public x0 A;
    public i11.b B;
    public com.bytedance.android.live.revenuelink.connect.n C;
    public i6 D;
    public e6 E;
    public String F;
    public String G;
    public String H;
    public final HashMap<Integer, String> I;
    public com.bytedance.android.livesdk.link.model.p J;
    public final com.bytedance.android.live.revenuelink.connect.f K;
    public MultiAnchorRelinkService L;
    public IBattleConfigSetting M;
    public boolean N;
    public String O;
    public View P;
    public boolean Q;
    public Integer R;
    public final o S;
    public final c T;
    public final long U;
    public final b V;
    public TextView g;
    public TextView h;
    public AnchorLinkInfoInviteView i;
    public AnchorLinkInfoInviteView j;
    public AnchorLinkInfoInviteView k;
    public Animation l;
    public Animation m;
    public Animation n;
    public boolean o;
    public int p;
    public com.bytedance.android.livesdk.link.model.p q;
    public String r;
    public String s;
    public final List<com.bytedance.android.livesdk.link.model.p> t;
    public long u;
    public long v;
    public CharSequence w;
    public int x;
    public int y;
    public int z;

    public static final class a {
    }

    public static final class b extends i11.c.a {
        public final /* synthetic */ AnchorLinkInviteFragment a;

        public b(AnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void b(int r4, List<? extends com.bytedance.android.livesdk.link.model.p> r5) {
            if (com.bytedance.android.live.revenuelink.connect.b.a(this.a.D) == false) goto L6;
            return;
        L6:
            if (this.a.E == null) goto L8;
            return;
        L8:
            if (r5 == null) goto L55;
            ArrayList r6 = (ArrayList) r5;
            if (r6.isEmpty() == true) goto L56;
            Iterator r7 = r6.iterator();
        L12:
            String r1 = null;
            if (r7.hasNext() == false) goto L20;
            com.bytedance.android.livesdk.link.model.p r0 = (com.bytedance.android.livesdk.link.model.p) r7.next();
            IBaseUser r2 = r0.getUser();
            if (r2 == null) goto L18;
            r1 = r2.getIdString();
        L18:
            if (TextUtils.equals(r1, this.a.r) == false) goto L12;
            this.a.q = r0;
            goto L12
        L20:
            List<com.bytedance.android.livesdk.link.model.p> r8 = this.a.t;
            Intrinsics.checkNotNull(r8);
            ((ArrayList) r8).clear();
            AnchorLinkInviteFragment r9 = this.a;
            com.bytedance.android.livesdk.link.model.p r3 = r9.q;
            if (r3 == null) goto L23;
            ((ArrayList) r9.t).add(r3);
        L23:
            Iterator r10 = r6.iterator();
        L25:
            if (r10.hasNext() == false) goto L35;
            com.bytedance.android.livesdk.link.model.p r12 = (com.bytedance.android.livesdk.link.model.p) r10.next();
            IBaseUser r13 = r12.getUser();
            if (r13 == null) goto L29;
            String r14 = r13.getIdString();
        L31:
            if (TextUtils.equals(r14, this.a.r) == true) goto L25;
            if (r12.getStatus() != 2) goto L25;
            ((ArrayList) this.a.t).add(r12);
            goto L25
        L29:
            r14 = null;
            goto L31
        L35:
            AnchorLinkInviteFragment r15 = this.a;
            if (r15.N == false) goto L38;
            r15.la0(r15.P);
            return;
        L38:
            if (((ArrayList) r15.t).size() <= 1) goto L40;
            ArrayList r16 = (ArrayList) this.a.t;
            r16.subList(1, r16.size()).clear();
            this.a.o = true;
        L40:
            AnchorLinkInviteFragment r17 = this.a;
            r17.ja0(r17.t);
            return;
        L56:
            return;
        }
    }

    public static final class c extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ AnchorLinkInviteFragment a;

        public c(AnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void nf(d11.g r1, q5 r2, long r3, ey.l r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r2, "replyResult");
            AnchorLinkInviteFragment r4 = this.a;
            int r6 = AnchorLinkInviteFragment.W;
            com.bytedance.android.live.revlink.impl.control.dialog.r r7 = r4.d;
            if (r7 != null) goto L5;
            return;
        L5:
            if (r1.e == 4) goto L9;
            r7.dismiss();
            return;
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ AnchorLinkInviteFragment a;

        public d(AnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r23, int r24) {
            Intrinsics.checkNotNullParameter(r23, "dialog");
            r23.dismiss();
            int r1 = this.a.p;
            if (r1 != 1) goto L6;
            int r7 = BizType.AnchorLink.ordinal();
            AnchorLinkInviteFragment r3 = this.a;
            long r8 = r3.u;
            long r10 = r3.v;
            String r13 = r3.r;
            String r14 = r3.s;
            Boolean r15 = Boolean.FALSE;
            Integer r16 = Integer.valueOf(r3.ea0());
            d11.a r17 = this.a.fa0();
            AnchorLinkInviteFragment r4 = this.a;
            d11.g r2 = new d11.g(7, r7, r8, r10, 2, r13, r14, r15, r16, r17, r4.F, "", r4.G, null);
            com.bytedance.android.live.revenuelink.connect.n r5 = this.a.C;
            Intrinsics.checkNotNull(r5);
            r5.h(r2, null);
            AnchorLinkInviteFragment.oa0(this.a, "reject");
        L20:
            this.a.d.dismiss();
            ((i21.a) this.a.f).e();
            AnchorLinkInviteFragment.ca0(this.a, false);
            return;
        L6:
            if (r1 != 2) goto L20;
            LinkCrossRoomDataHolder r6 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r6 == null) goto L10;
            long r9 = r6.c();
        L11:
            long r12 = r9;
            AnchorLinkInviteFragment r18 = this.a;
            long r19 = r18.v;
            String r110 = r18.r;
            String r111 = r18.s;
            i6 r20 = r18.D;
            if (r20 == null) goto L18;
            e6 r22 = r20.getInvite();
            if (r22 == null) goto L18;
            j5 r25 = r22.getFromLinkMicInfo();
            if (r25 == null) goto L18;
            String r112 = r25.getInteractIdStr();
        L19:
            d11.f r26 = new d11.f(7, r12, 2, r19, r110, r111, r112);
            com.bytedance.android.live.revenuelink.connect.n r27 = this.a.C;
            Intrinsics.checkNotNull(r27);
            r27.k(r26, null);
            AnchorLinkInviteFragment.oa0(this.a, "reject");
            this.a.na0("2");
        L18:
            r112 = null;
            goto L19
        L10:
            r9 = 0;
            goto L11
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ AnchorLinkInviteFragment a;

        public e(AnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r24, int r25) {
            Intrinsics.checkNotNullParameter(r24, "dialog");
            com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.broadcast.a.class).stopGameCastToAudience();
            com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.broadcast.a.class).hidePlugin(true);
            r24.dismiss();
            AnchorLinkInviteFragment r1 = this.a;
            int r2 = r1.p;
            if (r2 != 1) goto L6;
            com.bytedance.android.live.revenuelink.connect.n r3 = r1.C;
            Intrinsics.checkNotNull(r3);
            int r8 = BizType.AnchorLink.ordinal();
            AnchorLinkInviteFragment r15 = this.a;
            long r9 = r15.u;
            long r12 = r15.v;
            String r14 = r15.r;
            String r4 = r15.s;
            Boolean r16 = Boolean.FALSE;
            Integer r17 = Integer.valueOf(r15.ea0());
            d11.a r18 = this.a.fa0();
            AnchorLinkInviteFragment r5 = this.a;
            r3.h(new d11.g(7, r8, r9, r12, 1, r14, r4, r16, r17, r18, r5.F, "", r5.G, null), null);
            AnchorLinkInviteFragment.oa0(this.a, "accept");
        L20:
            this.a.d.dismiss();
            ((i21.a) this.a.f).e();
            AnchorLinkInviteFragment.ca0(this.a, true);
            return;
        L6:
            if (r2 != 2) goto L20;
            com.bytedance.android.live.revenuelink.connect.n r6 = r1.C;
            Intrinsics.checkNotNull(r6);
            LinkCrossRoomDataHolder r7 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r7 == null) goto L10;
            long r10 = r7.c();
        L11:
            AnchorLinkInviteFragment r13 = this.a;
            long r19 = r13.v;
            String r110 = r13.r;
            String r111 = r13.s;
            i6 r20 = r13.D;
            if (r20 == null) goto L18;
            e6 r22 = r20.getInvite();
            if (r22 == null) goto L18;
            j5 r23 = r22.getFromLinkMicInfo();
            if (r23 == null) goto L18;
            String r112 = r23.getInteractIdStr();
        L19:
            r6.k(new d11.f(7, r10, 1, r19, r110, r111, r112), null);
            AnchorLinkInviteFragment.oa0(this.a, "accept");
            this.a.na0(DataType.TRUE);
        L18:
            r112 = null;
            goto L19
        L10:
            r10 = 0;
            goto L11
        }
    }

    public static final class f<T> implements Comparator {
        public final /* synthetic */ AnchorLinkInviteFragment a;

        public f(AnchorLinkInviteFragment r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(Object r2, Object r3) {
            com.bytedance.android.livesdk.link.model.p r4 = (com.bytedance.android.livesdk.link.model.p) r2;
            com.bytedance.android.livesdk.link.model.p r5 = (com.bytedance.android.livesdk.link.model.p) r3;
            if (this.a.q == null) goto L18;
            String r6 = null;
            if (r4 == null) goto L9;
            IBaseUser r7 = r4.getUser();
            if (r7 == null) goto L9;
            String r8 = r7.getIdString();
        L10:
            com.bytedance.android.livesdk.link.model.p r0 = this.a.q;
            if (r0 == null) goto L16;
            IBaseUser r1 = r0.getUser();
            if (r1 == null) goto L16;
            r6 = r1.getIdString();
        L16:
            if (Intrinsics.areEqual(r8, r6) == false) goto L18;
            return -1;
        L9:
            r8 = null;
        L18:
            return 0;
        }
    }

    public static final class g implements Animation.AnimationListener {
        public final /* synthetic */ AnchorLinkInviteFragment a;
        public final /* synthetic */ AnchorLinkInfoInviteView b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b.getIvAvatar() != null) goto L5;
            return;
        L5:
            if (this.a.m == null) goto L9;
            this.b.getIvAvatar().startAnimation(this.a.m);
            return;
        }

        public g(AnchorLinkInviteFragment r1, AnchorLinkInfoInviteView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h implements Animation.AnimationListener {
        public final /* synthetic */ AnchorLinkInviteFragment a;
        public final /* synthetic */ AnchorLinkInfoInviteView b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b.getIvAvatar() != null) goto L5;
            return;
        L5:
            if (this.a.l == null) goto L9;
            this.b.getIvAvatar().startAnimation(this.a.l);
            return;
        }

        public h(AnchorLinkInviteFragment r1, AnchorLinkInfoInviteView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return "";
    }

    public static boolean ia0() {
        if (Intrinsics.areEqual(a5.a.getValue(), Boolean.FALSE) == false) goto L19;
        return false;
    L19:
        com.bytedance.android.livesdk.revenue.service.room.c r0 = com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);     // Catch: Exception -> L18
        com.bytedance.live.datacontext.m r2 = null;
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();     // Catch: Exception -> L18
    L9:
        if (r1 == null) goto L11;
        r2 = r1.getRoom();     // Catch: Exception -> L18
    L11:
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r1.getRoom().getValue() == null) goto L22;
        if (((IRoom) r1.getRoom().getValue()).getStreamType() != LiveMode.SCREEN_RECORD) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L8:
        r1 = null;
    L24:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        if (this.N == false) goto L7;
        int r0 = 190;
    L6:
        return r0;
    L7:
        o r1 = this.S;
        i6 r2 = this.D;
        r1.getClass();
        boolean r3 = false;
        if (r2 == null) goto L20;
        IBattleLinkerInviteMessageExtra r4 = j6.a(r2);
        if (r4 == null) goto L13;
        List r5 = r4.getMatchTags();
    L14:
        List r6 = r5;
        if (r6 != null) goto L17;
    L18:
        r3 = true;
    L19:
        r3 = !r3;
        goto L20
    L17:
        if (r6.isEmpty() == false) goto L19;
    L13:
        r5 = null;
    L20:
        if (r3 == false) goto L22;
        r0 = 275;
        goto L6
    L22:
        r0 = 251;
        goto L6
    }

    public final int ea0() {
        i6 r0 = this.D;
        Intrinsics.checkNotNull(r0);
        if (r0.getInvite() != null) goto L6;
        return 0;
    L6:
        i6 r1 = this.D;
        Intrinsics.checkNotNull(r1);
        e6 r2 = r1.getInvite();
        Intrinsics.checkNotNull(r2);
        return r2.getMultiPkMode();
    }

    public final d11.a fa0() {
        boolean r7 = !TextUtils.isEmpty(this.H);
        if (r7 == false) goto L7;
        String r0 = "multiReply";
    L5:
        String r9 = r0;
        int r2 = this.y;
        int r3 = this.x;
        int r4 = this.z;
        IBattleConfigSetting r5 = this.M;
        boolean r6 = ha0();
        String r12 = this.r;
        i6 r1 = this.D;
        Intrinsics.checkNotNull(r1);
        return new d11.a(r2, r3, r4, r5, r6, r7, false, r9, 0, r12, r1.getInvite(), null, 2048);
    L7:
        if (ha0() == false) goto L9;
        r0 = "npkInvite";
        goto L5
    L9:
        r0 = DataType.Normal;
        goto L5
    }

    public final boolean ha0() {
        i6 r0 = this.D;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        if (r0.getInvite() == null) goto L9;
        i6 r1 = this.D;
        Intrinsics.checkNotNull(r1);
        e6 r2 = r1.getInvite();
        Intrinsics.checkNotNull(r2);
        if (r2.getInviteSource() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean ra0() {
        i6 r0 = this.D;
        Intrinsics.checkNotNull(r0);
        if (r0.getInvite() != null) goto L6;
        return false;
    L6:
        i6 r1 = this.D;
        Intrinsics.checkNotNull(r1);
        e6 r2 = r1.getInvite();
        Intrinsics.checkNotNull(r2);
        return r2.getSupportMultiPkTeamMode();
    }

    public AnchorLinkInviteFragment() {
        this.t = new ArrayList();
        this.H = "";
        this.I = new HashMap();
        this.K = com.bytedance.android.live.revlink.impl.global.b.a();
        this.O = "";
        this.R = 0;
        this.S = new o(this);
        this.T = new c(this);
        this.U = System.currentTimeMillis();
        this.V = new b(this);
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final <S> AutoDisposeConverter<S> S90() {
        return super.S90();
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final ViewGroup Z90() {
        int r0 = ea0();
        com.bytedance.android.livesdk.revenue.service.room.c r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L10;
        IRoom r4 = (IRoom) r3.getValue();
    L10:
        if (this.p != 2) goto L27;
        if (r0 != 2) goto L27;
        if (ra0() == true) goto L27;
        View r5 = LayoutInflater.from(getContext()).inflate(2131566999, null);
        if (r5 == null) goto L26;
        ViewGroup r6 = (ViewGroup) r5;
        ((TextView) r6.findViewById(2131388772)).setText(this.w);
        if (ra0() == true) goto L20;
        ((TextView) r6.findViewById(2131362594)).setText(2131920502);
    L20:
        if (this.N == false) goto L22;
    L23:
        ((TextView) r6.findViewById(2131362594)).setVisibility(8);
    L24:
        return r6;
    L22:
        if (ia0() == false) goto L24;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L27:
        View r7 = LayoutInflater.from(getContext()).inflate(2131567000, null);
        if (r7 == null) goto L43;
        ViewGroup r8 = (ViewGroup) r7;
        View r9 = r8.findViewById(2131362594);
        if (this.p == 1) goto L32;
    L34:
        int r10 = 8;
    L35:
        r9.setVisibility(r10);
        ((TextView) r8.findViewById(2131388882)).setText(this.w);
        if (ia0() == false) goto L39;
        r8.findViewById(2131362594).setVisibility(8);
    L39:
        if (this.p != 3) goto L41;
        r8.findViewById(2131362594).setVisibility(8);
        ((TextView) r8.findViewById(2131388882)).setTypeface(Typeface.DEFAULT);
    L41:
        return r8;
    L32:
        if (this.N == true) goto L34;
        r10 = 0;
        goto L35
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.F4(true);
        com.bytedance.android.live.revenuelink.connect.f r0 = this.K;
        if (r0 == null) goto L5;
        r0.removeLinkOutListener(7, this.T);
    L5:
        i11.b r1 = this.B;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r1);
        r1.l(this.V);
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((i21.a) this.f).e();
        Animation r0 = this.l;
        Intrinsics.checkNotNull(r0);
        r0.cancel();
        Animation r1 = this.m;
        Intrinsics.checkNotNull(r1);
        r1.cancel();
        Animation r2 = this.n;
        Intrinsics.checkNotNull(r2);
        r2.cancel();
        i6 r3 = this.D;
        if (r3 == null) goto L5;
        boolean r4 = com.bytedance.android.live.revenuelink.connect.b.a(r3);
    L6:
        if (r4 == true) goto L10;
        p11.d r5 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r5 == null) goto L10;
        r5.g();
    L10:
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.a.class).checkRecoverForNative("anchor_invited_panel", "dismiss");
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final int Y90(View r4) {
        Intrinsics.checkNotNullParameter(r4, "topView");
        int r0 = ea0();
        if (this.p != 2) goto L10;
        if (r0 != 2) goto L10;
        if (ra0() == true) goto L10;
        r4.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r4.getMeasuredHeight();
    L10:
        return super.Y90(r4);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.contract.AnchorLinkInviteContract$View
    public final void ba0(int r23) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        TextView r0 = this.g;
        Intrinsics.checkNotNull(r0);
        r0.setText(FormatUtils.format(getString(2131914778), new Object[]{Integer.valueOf(r23)}));
        if (r23 != 0) goto L55;
        x0 r1 = this.A;
        if (r1 == null) goto L29;
        Intrinsics.checkNotNull(r1);
        if (r1.isShowing() == false) goto L29;
        x0 r2 = this.A;
        Intrinsics.checkNotNull(r2);
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L26:
        DialogLancet.afterDialogDismiss(r2);
        goto L29
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r4 == null) goto L26;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L14:
        if (Looper.myLooper() == r3.getLooper()) goto L16;
        r3.post(DialogLancet.createDismissRunnable(r2));
    L29:
        int r5 = this.p;
        if (r5 != 1) goto L33;
        d11.g r6 = new d11.g(7, BizType.AnchorLink.ordinal(), this.u, this.v, 5, this.r, this.s, Boolean.TRUE, Integer.valueOf(ea0()), fa0(), this.F, "", this.G, null);
        com.bytedance.android.live.revenuelink.connect.n r7 = this.C;
        Intrinsics.checkNotNull(r7);
        r7.h(r6, null);
        oa0(this, "overtime");
    L50:
        this.d.dismiss();
        return;
    L33:
        if (r5 != 2) goto L48;
        LinkCrossRoomDataHolder r8 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r8 == null) goto L37;
        long r9 = r8.c();
    L38:
        long r10 = this.v;
        String r12 = this.r;
        String r13 = this.s;
        i6 r14 = this.D;
        if (r14 == null) goto L45;
        e6 r15 = r14.getInvite();
        if (r15 == null) goto L45;
        j5 r16 = r15.getFromLinkMicInfo();
        if (r16 == null) goto L45;
        String r17 = r16.getInteractIdStr();
    L46:
        d11.f r18 = new d11.f(7, r9, 5, r10, r12, r13, r17);
        com.bytedance.android.live.revenuelink.connect.n r19 = this.C;
        Intrinsics.checkNotNull(r19);
        r19.k(r18, null);
        oa0(this, "overtime");
        na0("2");
    L45:
        r17 = null;
        goto L46
    L37:
        r9 = 0;
        goto L38
    L48:
        if (r5 != 3) goto L50;
        pa0(5);
        oa0(this, "overtime");
        goto L50
    }

    public final String ga0(com.bytedance.android.livesdk.link.model.p r5) {
        String r0 = null;
        if (r5 == null) goto L5;
        IBaseUser r1 = r5.getUser();
    L7:
        if (r1 == null) goto L34;
        IBaseUser r2 = r5.getUser();
        if (r2 == null) goto L11;
        String r3 = r2.getNickName();
    L12:
        if (r3 == null) goto L34;
        IBaseUser r4 = r5.getUser();
        if (r4 == null) goto L17;
        r0 = r4.getIdString();
    L17:
        if (Intrinsics.areEqual(r0, com.bytedance.android.live.revlink.impl.utils.u.e()) == true) goto L34;
        IBaseUser r6 = r5.getUser();
        if (r6 == null) goto L23;
        String r7 = r6.getNickName();
        if (r7 == null) goto L23;
    L25:
        if (r7.length() <= 7) goto L28;
        r7 = r7.substring(0, 6) + "...";
    L28:
        if (this.N == false) goto L32;
        return s1.C(2131920534, new Object[]{r7});
    L32:
        return s1.C(2131920533, new Object[]{r7});
    L23:
        r7 = "";
        goto L25
    L11:
        r3 = null;
    L34:
        if (TextUtils.isEmpty(this.O) == true) goto L39;
        if (this.N == false) goto L39;
        return s1.C(2131920517, new Object[]{da0(this.O, 5)});
    L39:
        return s1.B(2131914728);
    L5:
        r1 = null;
        goto L7
    }

    public final void ja0(List<? extends com.bytedance.android.livesdk.link.model.p> r7) {
        com.bytedance.android.livesdk.link.model.p r0 = this.q;
        if (r0 == null) goto L30;
        ma0(this.i, r0);
        Intrinsics.checkNotNull(r7);
        ArrayList r8 = (ArrayList) r7;
        if (r8.size() <= 1) goto L24;
        int r1 = this.p;
        if (r1 == 1) goto L10;
        if (r1 != 3) goto L24;
    L10:
        if (r8.size() != 2) goto L21;
        ma0(this.j, (com.bytedance.android.livesdk.link.model.p) ListProtector.get(r8, 1));
        AnchorLinkInfoInviteView r2 = this.i;
        Intrinsics.checkNotNull(r2);
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L19;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        AnchorLinkInfoInviteView r5 = this.j;
        Intrinsics.checkNotNull(r5);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L17;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r6;
        r4.leftMargin = s1.f(40.0f);
        r9.rightMargin = s1.f(40.0f);
        AnchorLinkInfoInviteView r10 = this.i;
        Intrinsics.checkNotNull(r10);
        r10.setLayoutParams(r4);
        AnchorLinkInfoInviteView r12 = this.j;
        Intrinsics.checkNotNull(r12);
        r12.setLayoutParams(r9);
        goto L24
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L21:
        if (r8.size() != 3) goto L24;
        ma0(this.j, (com.bytedance.android.livesdk.link.model.p) ListProtector.get(r8, 1));
        ma0(this.k, (com.bytedance.android.livesdk.link.model.p) ListProtector.get(r8, 2));
    L24:
        if (this.p == 3) goto L26;
        qa0(this.i);
        return;
    L26:
        if (r8.size() != 2) goto L31;
        qa0(this.j);
        return;
    L31:
        return;
    }

    public final void ka0(View r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        ForegroundColorSpan r0 = new ForegroundColorSpan(s1.h(2131108410));
        ForegroundColorSpan r1 = new ForegroundColorSpan(s1.h(2131108403));
        SpannableStringBuilder r2 = new SpannableStringBuilder(s1.B(2131920524));
        List<com.bytedance.android.livesdk.link.model.p> r3 = this.t;
        Intrinsics.checkNotNull(r3);
        Iterator r4 = ((ArrayList) r3).iterator();
        int r5 = 0;
    L6:
        if (r4.hasNext() == false) goto L28;
        com.bytedance.android.livesdk.link.model.p r6 = (com.bytedance.android.livesdk.link.model.p) r4.next();
        Intrinsics.checkNotNull(r6);
        if (r6.getUser() == null) goto L20;
        IBaseUser r7 = r6.getUser();
        String r8 = null;
        if (r7 == null) goto L12;
        String r9 = r7.getIdString();
    L13:
        i6 r10 = this.D;
        if (r10 == null) goto L19;
        g1 r13 = r10.getInvite();
        if (r13 == null) goto L19;
        g1 r14 = r13;
        Intrinsics.checkNotNullParameter(r14, "$this$fromUid");
        r8 = r14.get_fromUid();
    L19:
        if (TextUtils.equals(r9, r8) == true) goto L6;
    L12:
        r9 = null;
    L20:
        IBaseUser r15 = r6.getUser();
        if (r15 == null) goto L24;
        String r16 = r15.getNickName();
        if (r16 == null) goto L24;
    L25:
        r2.append(da0(r16, 7));
        r5 = r5 + 1;
        if (r5 == (((ArrayList) this.t).size() - 1)) goto L6;
        r2.append("、");
    L24:
        r16 = "";
        goto L25
    L28:
        r2.setSpan(r0, 0, 6, 33);
        r2.setSpan(r1, 6, r2.length(), 33);
        View r17 = r12.findViewById(2131375599);
        if (r17 == null) goto L33;
        ((TextView) r17).setText(r2);
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void la0(View r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (this.Q == false) goto L9;
        ka0(r7);
        return;
    L9:
        if (this.q == null) goto L45;
        ImageView r1 = (ImageView) r7.findViewById(2131376019);
        com.bytedance.android.livesdk.link.model.p r2 = this.q;
        Intrinsics.checkNotNull(r2);
        IBaseUser r3 = r2.getUser();
        Intrinsics.checkNotNull(r3);
        a1.x(r1, r3.getAvatarThumbKt(), r7.findViewById(2131376019).getWidth(), r7.findViewById(2131376019).getHeight(), 2131250965);
        r7.findViewById(2131376019).startAnimation(this.l);
        r7.findViewById(2131392617).setVisibility(0);
        r7.findViewById(2131362947).setVisibility(0);
        r7.findViewById(2131362947).startAnimation(this.n);
        VHeadView r0 = r7.findViewById(2131376272);
        com.bytedance.android.livesdk.link.model.p r4 = this.q;
        Intrinsics.checkNotNull(r4);
        IBaseUser r5 = r4.getUser();
        Intrinsics.checkNotNull(r5);
        if (r5.getGender() != 1) goto L13;
        r0.setImageResource(2131250688);
        r0.setVisibility(0);
    L17:
        TextView r6 = (TextView) r7.findViewById(2131376424);
        com.bytedance.android.livesdk.link.model.p r8 = this.q;
        if (r8 == null) goto L23;
        IBaseUser r9 = r8.getUser();
        if (r9 == null) goto L23;
        String r10 = r9.getNickName();
        if (r10 == null) goto L23;
    L24:
        r6.setText(da0(r10, 7));
        Integer r12 = this.R;
        int r13 = IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusUnknown.ordinal();
        if (r12 == null) goto L30;
        if (r12.intValue() != r13) goto L30;
    L39:
        ViewGroup.LayoutParams r14 = r6.getLayoutParams();
        if (r14 == null) goto L44;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        r15.setMargins(s1.f(92.0f), s1.f(50.0f), 0, 0);
        r6.setLayoutParams(r15);
        r7.findViewById(2131375599).setVisibility(8);
    L42:
        r7.findViewById(2131375616).setVisibility(0);
        return;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L30:
        if (this.p == 2) goto L39;
        if (this.Q == false) goto L35;
    L38:
        ka0(r7);
        goto L42
    L35:
        if (com.bytedance.android.live.revenuelink.connect.b.a(this.D) == true) goto L38;
        i6 r16 = this.D;
        Intrinsics.checkNotNull(r16);
        e6 r17 = r16.getInvite();
        Intrinsics.checkNotNull(r17);
        if (r17.getInviteUser() != null) goto L42;
    L23:
        r10 = "";
        goto L24
    L13:
        com.bytedance.android.livesdk.link.model.p r18 = this.q;
        Intrinsics.checkNotNull(r18);
        IBaseUser r19 = r18.getUser();
        Intrinsics.checkNotNull(r19);
        if (r19.getGender() != 2) goto L16;
        r0.setImageResource(2131250687);
        r0.setVisibility(0);
        goto L17
    L16:
        r0.setVisibility(8);
        goto L17
    }

    public final void na0(String r4) {
        HashMap r0 = new HashMap();
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L11;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r1 == null) goto L9;
        i11.b r2 = r1.getLinkUserCenter();
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.c());
    L10:
        r0.put("anchor_connect_status", String.valueOf(r3));
    L9:
        r3 = null;
    L11:
        r0.put("connection_type", "anchor");
        r0.put("applicant_id", String.valueOf(this.r));
        r0.put("connectapplieddecision", r4);
        int r5 = this.x;
        if (r5 != 1) goto L15;
        r0.put("invitee_list", "mutual_follow");
    L20:
        r0.put("channel_id", String.valueOf(this.u));
        mz0.n r6 = new mz0.n();
        Map<String, String> r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        mz0.m r8 = new mz0.m();
        LinkCrossRoomDataHolder.a r9 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.a(r8);
        r8.b(LogCommon.ROOM);
        List<Object> r10 = r6.b;
        ArrayList r12 = (ArrayList) r10;
        r12.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_connectapplied_click", r6.a, r6.b);
        return;
    L15:
        if (r5 != 2) goto L18;
        r0.put("invitee_list", "recommend");
        goto L20
    L18:
        if (r5 != 9) goto L20;
        r0.put("invitee_list", "campaign");
        goto L20
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r30) {
        Intrinsics.checkNotNullParameter(r30, "view");
        int r2 = r30.getId();
        if (r2 == 2131364592) goto L5;
        if (r2 == 2131364604) goto L5;
        return;
    L5:
        int r0 = 1;
        if (r2 == 2131364592) goto L8;
    L19:
        int r6 = this.p;
        if (r6 != 1) goto L78;
        com.bytedance.android.live.revenuelink.connect.n r7 = this.C;
        if (r7 == null) goto L69;
        Intrinsics.checkNotNull(r7);
        int r13 = BizType.AnchorLink.ordinal();
        long r12 = this.u;
        long r4 = this.v;
        if (r2 != 2131364604) goto L26;
        int r18 = 2;
    L27:
        String r9 = this.r;
        String r15 = this.s;
        Boolean r22 = Boolean.FALSE;
        Integer r23 = Integer.valueOf(ea0());
        d11.a r24 = fa0();
        String r3 = this.F;
        String r10 = this.G;
        long r16 = r12;
        com.bytedance.android.livesdk.revenue.service.room.c r1 = com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);     // Catch: Exception -> L60
        if (r1 == null) goto L33;
        com.bytedance.android.livesdk.revenue.room.a r5 = r1.getRoomContext();     // Catch: Exception -> L60
    L35:
        if (ia0() == true) goto L37;
        r15 = r15;
    L66:
        d11.m r27 = null;
    L67:
        r7.h(new d11.g(7, r13, r16, r4, r18, r9, r15, r22, r23, r24, r3, "", r10, r27), null);
        goto L69
    L37:
        if (r5 == null) goto L45;
        com.bytedance.live.datacontext.j r8 = r5.getLiveStream();     // Catch: Exception -> L60
        if (r8 == null) goto L45;
        com.bytedance.android.livesdk.revenue.pushstream.a r14 = (com.bytedance.android.livesdk.revenue.pushstream.a) r8.getValue();     // Catch: Exception -> L60
        if (r14 == null) goto L45;
        uf2.d0 r17 = r14.A();     // Catch: Exception -> L60
        if (r17 == null) goto L45;
        uf2.d0.a r19 = r17.getBuilder();     // Catch: Exception -> L60
    L46:
        if (r19 == null) goto L48;
        int r110 = r19.getVideoWidth();     // Catch: Exception -> L60
    L49:
        if (r19 == null) goto L51;
        int r111 = r19.getVideoHeight();     // Catch: Exception -> L60
    L52:
        if (r19 == null) goto L55;
        int r20 = r19.U();     // Catch: Exception -> L60
    L115:
        r27 = new d11.m(Integer.valueOf(r20), Integer.valueOf(r110), Integer.valueOf(r111));     // Catch: Exception -> L58
    L58:
        e = e;
    L65:
        ALogger.d("AnchorLinkInviteFragment", e.toString());
        goto L66
    L55:
        r20 = 0;
        goto L115
    L51:
        r111 = 0;
        goto L52
    L48:
        r110 = 0;
    L45:
        r19 = null;
        goto L46
    L33:
        r5 = null;
    L60:
        e = e;
    L64:
        r15 = r15;
    L62:
        e = e;
        r16 = r12;
        goto L64
    L26:
        r18 = 1;
    L69:
        if (r2 != 2131364592) goto L76;
        oa0(this, "accept");
        com.bytedance.android.livesdk.revenue.service.room.c r25 = com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        Intrinsics.checkNotNull(r25);
        com.bytedance.android.livesdk.revenue.room.a r26 = r25.getRoomContext();
        if (r26 != null) goto L73;
    L113:
        this.d.dismiss();
        ((i21.a) this.f).e();
        return;
    L73:
        if (r26.isInVideoPlay() == false) goto L113;
        r26.resetVideoPlayState();
        ToastUtil.b("结束连线状态，可再次使用放映视频", 0);
        goto L113
    L76:
        if (r2 != 2131364604) goto L113;
        oa0(this, "reject");
        goto L113
    L78:
        if (r6 != 2) goto L105;
        com.bytedance.android.live.revenuelink.connect.n r28 = this.C;
        if (r28 == null) goto L99;
        Intrinsics.checkNotNull(r28);
        LinkCrossRoomDataHolder r29 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r29 == null) goto L84;
        long r32 = r29.c();
    L85:
        long r112 = r32;
        if (r2 != 2131364604) goto L88;
        int r113 = 2;
    L89:
        long r33 = this.v;
        String r34 = this.r;
        String r35 = this.s;
        i6 r114 = this.D;
        if (r114 == null) goto L96;
        e6 r115 = r114.getInvite();
        if (r115 == null) goto L96;
        j5 r116 = r115.getFromLinkMicInfo();
        if (r116 == null) goto L96;
        String r117 = r116.getInteractIdStr();
    L97:
        r28.k(new d11.f(7, r112, r113, r33, r34, r35, r117), null);
    L96:
        r117 = null;
        goto L97
    L88:
        r113 = 1;
        goto L89
    L84:
        r32 = 0;
    L99:
        if (r2 != 2131364592) goto L102;
        oa0(this, "accept");
        na0(DataType.TRUE);
        goto L113
    L102:
        if (r2 != 2131364604) goto L113;
        oa0(this, "reject");
        na0("2");
        goto L113
    L105:
        if (r6 != 3) goto L113;
        if (r2 != 2131364604) goto L108;
        r0 = 2;
    L108:
        pa0(r0);
        if (r2 != 2131364592) goto L111;
        oa0(this, "accept");
        goto L113
    L111:
        if (r2 != 2131364604) goto L113;
        oa0(this, "reject");
        goto L113
    L8:
        if (wq2.e.b().d() <= 0) goto L10;
    L11:
        Context r36 = getContext();
        x0.d r37 = new x0.d();
        r37.b = r36;
        r37.a = 4;
        r37.k = false;
        r37.d = r37.b.getText(2131921454);
        d r38 = new d(this);
        x0.c[] r39 = r37.g;
        x0.c r40 = r39[1];
        if (r40 != null) goto L14;
        r40 = new x0.c();
        r39[1] = r40;
    L14:
        r40.a = "取消";
        r40.b = r38;
        e r42 = new e(this);
        x0.c[] r43 = r37.g;
        x0.c r44 = r43[0];
        if (r44 != null) goto L17;
        r44 = new x0.c();
        r43[0] = r44;
    L17:
        r44.a = "确认";
        r44.b = r42;
        x0 r45 = new x0(r37.b, r37);
        x0.b.g(r45);
        this.A = r45;
        return;
    L10:
        if (wq2.e.b().b() == false) goto L19;
        goto L11
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (com.bytedance.android.live.revlink.impl.global.b.t() == null) goto L22;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r5 = com.bytedance.android.live.revlink.impl.global.b.t();
        MultiAnchorRelinkService r0 = null;
        if (r5 == null) goto L7;
        com.bytedance.android.live.revenuelink.connect.n r6 = r5.getLinkOutManagerFn();
    L8:
        this.C = r6;
        com.bytedance.android.live.revenuelink.connect.f r7 = this.K;
        if (r7 == null) goto L11;
        r7.addLinkOutListener(7, this.T);
    L11:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r8 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r8 == null) goto L14;
        i11.b r9 = r8.getLinkUserCenter();
    L15:
        this.B = r9;
        if (r9 == null) goto L18;
        r9.i(this.V);
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r10 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r10 == null) goto L21;
        r0 = r10.Fa();
    L21:
        this.L = r0;
        goto L22
    L14:
        r9 = null;
        goto L15
    L7:
        r6 = null;
    L22:
        this.l = AnimationUtils.loadAnimation(getContext(), 2130772672);
        this.m = AnimationUtils.loadAnimation(getContext(), 2130772673);
        this.n = AnimationUtils.loadAnimation(getContext(), 2130772674);
        Animation r12 = this.l;
        if (r12 == null) goto L25;
        r12.setRepeatCount(-1);
    L25:
        Animation r13 = this.l;
        if (r13 == null) goto L28;
        r13.setInterpolator(new LinearInterpolator());
    L28:
        Animation r14 = this.n;
        if (r14 == null) goto L31;
        r14.setInterpolator(new LinearInterpolator());
    L31:
        this.I.put(101, "mutual_follow");
        this.I.put(102, "recommend");
    }

    public final void pa0(int r10) {
        MultiAnchorRelinkService r0 = this.L;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.E == null) goto L9;
        Intrinsics.checkNotNull(r0);
        String r2 = this.r;
        Intrinsics.checkNotNull(r2);
        e6 r1 = this.E;
        Intrinsics.checkNotNull(r1);
        long r3 = r1.getFromRoomId();
        e6 r4 = this.E;
        Intrinsics.checkNotNull(r4);
        r0.s(r10, r2, r3, r4.getToJoinChannelId(), this.y, this.x);
        return;
    }

    public final void qa0(AnchorLinkInfoInviteView r3) {
        Intrinsics.checkNotNull(r3);
        r3.getIvAvatar().startAnimation(this.l);
        r3.getViewWave().setVisibility(0);
        r3.getAnimWave().setVisibility(0);
        r3.getAnimWave().startAnimation(this.n);
        Animation r0 = this.l;
        Intrinsics.checkNotNull(r0);
        r0.setAnimationListener(new g(this, r3));
        Animation r1 = this.m;
        Intrinsics.checkNotNull(r1);
        r1.setAnimationListener(new h(this, r3));
    }

    public static final void ca0(AnchorLinkInviteFragment r2, boolean r3) {
        r2.getClass();
        HashMap r4 = new HashMap();
        if (r3 == false) goto L5;
        String r5 = "confirm";
    L6:
        r4.put("button_clicked", r5);
        r4.put("end_reason", "anchor_interact");
        mz0.n r6 = new mz0.n();
        Map<String, String> r0 = r6.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r0.putAll(r4);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        r7.b(LogCommon.GAME_PARAM_ITEM);
        List<Object> r1 = r6.b;
        ArrayList r8 = (ArrayList) r1;
        r8.addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((mz0.i) ((f80.a) r10)).w3("livesdk_little_game_share_screen_switch_to_interact", r6.a, r6.b);
        return;
    L5:
        r5 = "cancel";
        goto L6
    }

    public static String da0(String r2, int r3) {
        if (r2.length() > r3) goto L5;
        return r2;
    L5:
        return r2.substring(0, r3 - 1) + "...";
    }

    public static void oa0(AnchorLinkInviteFragment r12, String r13) {
        v3 r0 = e21.e.c(r12.D);
        p0 r1 = e21.c.a(r12.D);
        r12.getClass();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("inviter_id", String.valueOf(r12.r));
        IBaseUser r3 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        String r4 = "";
        if (r3 == null) goto L6;
        String r5 = r3.getIdString();
        if (r5 == null) goto L6;
    L7:
        r2.put("invitee_id", r5);
        r2.put("selection", r13);
        int r14 = UserListInviteType.a;
        int r15 = r12.x;
        HashMap<Integer, String> r6 = r12.I;
        Intrinsics.checkNotNullParameter(r6, "inviteTypeToListType");
        r2.put("invitee_list", UserListInviteType.a(r15, r6));
        r2.put("channel_id", String.valueOf(r12.u));
        int r16 = r12.ea0();
        if (r16 != 1) goto L10;
        r2.put("battle_mode", "individual_pk");
    L12:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r17 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r17 == null) goto L19;
        i6 r7 = r12.D;
        if (r7 == null) goto L17;
        boolean r8 = com.bytedance.android.live.revenuelink.connect.b.a(r7);
    L18:
        String r18 = com.bytedance.android.live.revlink.impl.multianchor.utils.q.E(r17, r8, 0, 6);
    L20:
        r2.put("npk_link_type", r18);
        r2.put("if_strategy_invite", DataType.FALSE);
        int r19 = r12.p;
        if (r19 == 3) goto L23;
    L25:
        if (r19 != 3) goto L30;
        if (r12.y != 20) goto L30;
        String r110 = "relink_team";
    L36:
        r2.put("connection_type", r110);
        List<com.bytedance.android.livesdk.link.model.p> r111 = r12.t;
        Intrinsics.checkNotNull(r111);
        if (((ArrayList) r111).size() < 2) goto L39;
    L42:
        String r112 = "manual_nlink";
    L43:
        r2.put("connection_sub_type", r112);
        r2.put("audience_connect_cnt", DataType.FALSE);
        d31.d r113 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r113 == null) goto L47;
        String r114 = r113.a();
        if (r114 == null) goto L47;
    L48:
        r2.put("anchor_connect_status", r114);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r115 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r115 == null) goto L51;
        String r116 = r115.p();
    L52:
        r2.put("invitee_connection_status", r116);
        if (r12.J != null) goto L55;
        r2.put("anchor_connection_type", "invite");
    L56:
        r2.put("is_oncemore", DataType.FALSE);
        r2.put("invite_mode", "connection");
        r2.put("invite_type", "anchor");
        d31.d r117 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r117 == null) goto L59;
        String r118 = r117.s();
    L60:
        r2.put("room_status", r118);
        if (j6.a(r12.D) == null) goto L104;
        IBattleLinkerInviteMessageExtra r119 = j6.a(r12.D);
        List r9 = null;
        if (r119 == null) goto L65;
        List r120 = r119.getInviterFollowIds();
    L67:
        if (r120 == null) goto L78;
        IBattleLinkerInviteMessageExtra r121 = j6.a(r12.D);
        if (r121 == null) goto L71;
        List r122 = r121.getInviterFollowIds();
    L72:
        Intrinsics.checkNotNull(r122);
        if (r122.size() <= 0) goto L78;
        IBattleLinkerInviteMessageExtra r123 = j6.a(r12.D);
        if (r123 == null) goto L77;
        r9 = r123.getInviterFollowIds();
    L77:
        Intrinsics.checkNotNull(r9);
        r2.put("inviter_connect_cnt", String.valueOf(r9.size() + 1));
    L79:
        Integer r124 = r12.R;
        if (r124 != null) goto L83;
        r2.put("inviter_room_status", "live");
    L93:
        if (r12.p != 3) goto L104;
        d31.d r125 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r125 == null) goto L97;
        String r126 = r125.s();
    L98:
        r2.put("inviter_room_status", r126);
        d31.d r127 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r127 == null) goto L102;
        String r128 = r127.a();
        if (r128 == null) goto L102;
    L103:
        r2.put("inviter_connect_cnt", r128);
    L102:
        r128 = "";
        goto L103
    L97:
        r126 = "";
        goto L98
    L83:
        if (r124.intValue() != IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusInPK.ordinal()) goto L85;
        r2.put("inviter_room_status", "pk");
        goto L93
    L85:
        Integer r129 = r12.R;
        int r10 = IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusInLinkMic.ordinal();
        if (r129 != null) goto L89;
    L91:
        r2.put("inviter_room_status", "live");
        goto L93
    L89:
        if (r129.intValue() != r10) goto L91;
        r2.put("inviter_room_status", "connection");
        goto L93
    L71:
        r122 = null;
    L78:
        r2.put("inviter_connect_cnt", DataType.FALSE);
        goto L79
    L65:
        r120 = null;
    L104:
        d31.d r130 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r130 == null) goto L107;
        String r131 = r130.s();
    L108:
        r2.put("from_room_status", r131);
        d31.d r132 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r132 == null) goto L111;
        r4 = r132.s();
    L111:
        r2.put("room_status", r4);
        i6 r133 = r12.D;
        if (r133 == null) goto L116;
        Intrinsics.checkNotNull(r133);
        if (r133.getInvite() == null) goto L116;
        i6 r134 = r12.D;
        Intrinsics.checkNotNull(r134);
        e6 r135 = r134.getInvite();
        Intrinsics.checkNotNull(r135);
        r2.put("inviter_room_id", String.valueOf(r135.getFromRoomId()));
    L116:
        r2.put("spend_time", String.valueOf(System.currentTimeMillis() - r12.U));
        mz0.n r136 = new mz0.n();
        mz0.o r137 = new mz0.o(r136.a);
        r137.b(r2);
        e21.e.d(r137, r0);
        e21.c.e(r137, r1);
        mz0.m r138 = new mz0.m();
        LinkCrossRoomDataHolder.a r20 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.a(r138);
        r138.b(LogCommon.ROOM);
        ((ArrayList) r136.b).addAll(r138.a);
        cy0.e.a.getClass();
        cy0.j r139 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r140 = com.bytedance.android.scope.m.b(r139).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r140);
        ((mz0.i) ((f80.a) r140)).w3("livesdk_connection_invited", r136.a, r136.b);
        return;
    L107:
        r131 = "";
        goto L108
    L59:
        r118 = "";
        goto L60
    L55:
        r2.put("anchor_connection_type", "apply");
        goto L56
    L51:
        r116 = "";
    L47:
        r114 = "";
        goto L48
    L39:
        if (r12.o == true) goto L42;
        r112 = "";
    L30:
        if (com.bytedance.android.live.revlink.impl.multianchor.utils.y.b() == false) goto L35;
        d31.d r141 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r141 == null) goto L34;
        r110 = r141.c();
        goto L36
    L34:
        r110 = "";
        goto L36
    L35:
        r110 = "manual_link";
        goto L36
    L23:
        if (r12.y != 21) goto L25;
        r110 = "relink_player";
        goto L36
    L17:
        r8 = false;
        goto L18
    L19:
        r18 = "";
        goto L20
    L10:
        if (r16 != 2) goto L12;
        r2.put("battle_mode", "team_pk");
    L6:
        r5 = "";
        goto L7
    }

    public final void ma0(AnchorLinkInfoInviteView r9, com.bytedance.android.livesdk.link.model.p r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNull(r10);
        IBaseUser r0 = r10.getUser();
        if (r0 != null) goto L7;
        return;
    L7:
        a1.x(r9.getIvAvatar(), r0.getAvatarThumbKt(), r9.getIvAvatar().getWidth(), r9.getIvAvatar().getHeight(), 2131250965);
        r9.getTvNickname().setText(r0.getNickName());
        if (r0.getGender() != 1) goto L11;
        r9.getIvGender().setImageResource(2131250688);
        r9.getIvGender().setVisibility(0);
    L15:
        if (r0.getFollowInfo() == null) goto L22;
        py.j r1 = r0.getFollowInfo();
        if (r1 == null) goto L22;
        if (r1.getFollowStatus() != 2) goto L22;
        r9.getTvLabelTop().setVisibility(0);
    L22:
        if (ha0() == false) goto L30;
        r9.getTvDistance().setVisibility(0);
        if (com.bytedance.android.livesdk.link.model.q.c(r10) == null) goto L38;
        if (w6.a(com.bytedance.android.livesdk.link.model.q.c(r10)) == null) goto L38;
        IListUserLinkmicContent r2 = w6.a(com.bytedance.android.livesdk.link.model.q.c(r10));
        if (r2 == null) goto L38;
        r9.getTvDistance().setText(r2.getFanTicket());
    L38:
        if (this.p == 3) goto L40;
    L42:
        r9.setVisibility(0);
        return;
    L40:
        if (r10 != this.q) goto L42;
        r9.getTvLabelBottom().setVisibility(0);
        r9.getTvLabelBottom().setText("发起者");
        r9.getTvLabelBottom().setTextSize(1, 10.0f);
        r9.getTvLabelBottom().setBackgroundResource(2131248801);
        UIUtils.updateLayout(r9.getTvLabelBottom(), s1.f(36.0f), s1.f(14.0f));
        goto L42
    L30:
        r9.getTvDistance().setVisibility(0);
        if (r0.getFollowInfo() == null) goto L38;
        TextView r3 = r9.getTvDistance();
        Object[] r4 = new Object[1];
        py.j r5 = r0.getFollowInfo();
        if (r5 == null) goto L35;
        long r6 = r5.getFollowerCount();
    L36:
        r4[0] = IESUIUtils.getDisplayCount(r6, "w");
        r3.setText(s1.C(2131914749, r4));
        goto L38
    L35:
        r6 = 0;
        goto L36
    L11:
        if (r0.getGender() != 2) goto L13;
        r9.getIvGender().setImageResource(2131250687);
        r9.getIvGender().setVisibility(0);
        goto L15
    L13:
        r9.getIvGender().setVisibility(8);
        goto L15
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.a.class).checkDegradeForNative("anchor_invited_panel");
        com.bytedance.android.live.revenuelink.connect.f r4 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r4 == null) goto L5;
        LiveData<ey.f> r5 = r4.connectState();
    L6:
        if (r5 == null) goto L15;
        ey.f r6 = (ey.f) r5.getValue();
        if (r6 == null) goto L12;
        if (r6.d != 2) goto L12;
        return;
    L12:
        if (ia0() == false) goto L17;
        this.d.dismiss();
        return;
    L17:
        return;
    L15:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r32, ViewGroup r33, Bundle r34) {
        Intrinsics.checkNotNullParameter(r32, "inflater");
        boolean r4 = false;
        if (this.N == false) goto L5;
        View r1 = r32.inflate(2131566030, r33, false);
    L6:
        this.P = r1;
        if (this.N == false) goto L14;
        this.h = (TextView) r1.findViewById(2131380707);
        this.g = (TextView) r1.findViewById(2131380708);
        TextView r2 = this.h;
        if (r2 == null) goto L11;
        r2.setId(2131364592);
    L11:
        TextView r3 = this.g;
        if (r3 == null) goto L17;
        r3.setId(2131364604);
    L17:
        TextView r5 = this.g;
        if (r5 == null) goto L20;
        r5.setOnClickListener(this);
    L20:
        TextView r6 = this.h;
        if (r6 == null) goto L24;
        r6.setOnClickListener(this);
    L24:
        if (this.N == false) goto L26;
        View r7 = r1.findViewById(2131383051);
    L27:
        TextView r8 = (TextView) r7;
        IBaseUser r9 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r9 != null) goto L30;
    L32:
        boolean r10 = false;
    L34:
        if (r10 == true) goto L36;
    L41:
        r8.setVisibility(8);
    L42:
        int r12 = this.p;
        int r13 = 3;
        AttributeSet r14 = null;
        if (r12 != 1) goto L45;
        this.w = s1.B(2131914779);
    L88:
        if (this.N == false) goto L220;
        i6 r15 = this.D;
        Intrinsics.checkNotNull(r15);
        e6 r16 = r15.getInvite();
        Intrinsics.checkNotNull(r16);
        if (r16.getTags() == null) goto L119;
        i6 r17 = this.D;
        Intrinsics.checkNotNull(r17);
        e6 r18 = r17.getInvite();
        Intrinsics.checkNotNull(r18);
        List r19 = r18.getTags();
        Intrinsics.checkNotNull(r19);
        if (r19.size() <= 0) goto L119;
        i6 r20 = this.D;
        Intrinsics.checkNotNull(r20);
        e6 r22 = r20.getInvite();
        Intrinsics.checkNotNull(r22);
        List r23 = r22.getTags();
        LinearLayout r110 = (LinearLayout) r1.findViewById(2131375616);
        int r24 = 0;
        int r25 = 0;
        int r111 = 0;
    L95:
        if (r25 >= r13) goto L115;
        PkTagsContainerView r26 = new PkTagsContainerView(r1.getContext(), r14, 6, r4 ? 1 : 0);
        if (r23 != null) goto L100;
    L101:
        int r112 = -1;
    L113:
        if ((r112 - r24) < 1) goto L115;
        r110.addView(r26);
        r111 = r111 + 1;
        r25 = r25 + 1;
        r24 = r112;
        r4 = false;
        r13 = 3;
        r14 = null;
        goto L95
    L100:
        if (r24 >= r23.size()) goto L101;
        r26.b = s1.f(230.0f);
        r26.removeAllViews();
        int r27 = r23.size();
        r112 = r24;
    L103:
        if (r112 >= r27) goto L111;
        View r113 = r26.b((IBattleRivalTag) ListProtector.get(r23, r112), true, r4);
        if ((PkTagsContainerView.c(r113) + s1.f(4.0f)) >= r26.b) goto L107;
        r26.addView(r113);
        r26.b -= PkTagsContainerView.c(r113) + s1.f(4.0f);
        boolean r28 = true;
    L108:
        if (r28 == false) goto L113;
        r112 = r112 + 1;
        r4 = false;
        goto L103
    L107:
        r28 = false;
        goto L108
    L111:
        r112 = r23.size();
    L115:
        ((TextView) r1.findViewById(2131376424)).setPadding(0, s1.f((r111 - 1) * 10), 0, 0);
        if (this.q != null) goto L119;
        r1.findViewById(2131375616).setVisibility(4);
    L119:
        if (this.p != 2) goto L134;
        if (ea0() != 2) goto L134;
        if (ra0() == true) goto L134;
        TextView r29 = (TextView) r1.findViewById(2131383051);
        IBaseUser r30 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r30 != null) goto L127;
    L129:
        boolean r35 = false;
    L130:
        if (r35 == true) goto L132;
        r29.setText(s1.B(2131920502));
    L132:
        r29.setVisibility(0);
        goto L134
    L127:
        if (r30.getSecret() != 1) goto L129;
        r35 = true;
    L134:
        if (com.bytedance.android.live.revenuelink.connect.b.a(this.D) == true) goto L141;
        i6 r36 = this.D;
        Intrinsics.checkNotNull(r36);
        e6 r37 = r36.getInvite();
        Intrinsics.checkNotNull(r37);
        if (r37.getInviteUser() != null) goto L141;
        i11.b r38 = this.B;
        if (r38 == null) goto L162;
        Intrinsics.checkNotNull(r38);
        r38.b(4, "show_be_invited_applied_dialog");
    L162:
        i6 r39 = this.D;
        if (r39 != null) goto L165;
    L198:
        i6 r40 = this.D;
        if (r40 != null) goto L201;
    L203:
        String r42 = s1.B(2131914779);
    L204:
        this.w = r42;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r43 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r43 == null) goto L207;
        int r44 = r43.h();
    L208:
        if (r44 <= 0) goto L259;
        com.bytedance.android.livesdk.link.model.p r45 = this.q;
        if (r45 == null) goto L259;
        Intrinsics.checkNotNull(r45);
        if (r45.getUser() == null) goto L259;
        List<com.bytedance.android.livesdk.link.model.p> r46 = this.t;
        if (r46 == null) goto L259;
        if (((ArrayList) r46).size() <= 0) goto L259;
        TextView r47 = this.h;
        if (r47 == null) goto L259;
        r47.setText(s1.B(2131920525));
    L259:
        o r48 = this.S;
        i6 r49 = this.D;
        r48.getClass();
        if (r49 == null) goto L306;
        if (r1 == null) goto L306;
        Context r50 = r1.getContext();
        if (r50 == null) goto L306;
        IBattleLinkerInviteMessageExtra r52 = j6.a(r49);
        if (r52 == null) goto L270;
        List r53 = r52.getMatchTags();
    L271:
        List r54 = r53;
        if (r54 != null) goto L274;
    L277:
        boolean r55 = true;
    L278:
        boolean r56 = !r55;
        ViewGroup.LayoutParams r57 = r1.getLayoutParams();
        if (r57 == null) goto L285;
        int r58 = com.bytedance.android.live.revenue.common.i.b(236);
        if (r56 == false) goto L283;
        int r114 = com.bytedance.android.live.revenue.common.i.b(24);
    L284:
        r57.height = r58 + r114;
        Unit r59 = Unit.INSTANCE;
    L286:
        r1.setLayoutParams(r57);
        LinearLayout r60 = (LinearLayout) r1.findViewById(2131362586);
        if (r56 == false) goto L289;
        int r62 = 0;
    L290:
        r60.setVisibility(r62);
        if (r53 == null) goto L306;
        Iterator r63 = r53.iterator();
    L294:
        if (r63.hasNext() == false) goto L306;
        IBattleRivalTag r64 = (IBattleRivalTag) r63.next();
        LinearLayout r65 = (LinearLayout) r1.findViewById(2131362586);
        if (r65 == null) goto L294;
        View r115 = LayoutInflater.from(r50).inflate(2131566714, null);
        if (r115 == null) goto L305;
        TextView r116 = (TextView) r115;
        r116.setText(r64.getContent());
        r116.setTextColor(Color.parseColor(r64.getFontColor()));     // Catch: Exception -> L302
    L303:
        ((ObservableSubscribeProxy) a1.k(r64.getBackgroundImage()).compose(RxUtil.rxSchedulerHelper()).as(super.S90())).subscribe(new p(r116));
        LinearLayout.LayoutParams r66 = new LinearLayout.LayoutParams(-2, com.bytedance.android.live.revenue.common.i.b(20));
        r66.rightMargin = com.bytedance.android.live.revenue.common.i.b(4);
        Unit r117 = Unit.INSTANCE;
        r65.addView(r116, r66);
    L302:
        r116.setTextColor(ColorProtector.parseColor("#ff3b61"));
        goto L303
    L305:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L289:
        r62 = 8;
        goto L290
    L283:
        r114 = 0;
        goto L284
    L285:
        r57 = null;
        goto L286
    L274:
        if (r54.isEmpty() == true) goto L277;
        r55 = false;
        goto L278
    L270:
        r53 = null;
    L306:
        boolean r67 = false;
        this.d.F4(false);
        i6 r68 = this.D;
        Intrinsics.checkNotNull(r68);
        g1 r69 = r68.getInvite();
        if (r69 != null) goto L309;
    L311:
        e6 r70 = this.E;
        if (r70 == null) goto L316;
        Intrinsics.checkNotNull(r70);
        if (r70.getWaitSec() <= 0) goto L316;
        i21.a r72 = (i21.a) this.f;
        e6 r73 = this.E;
        Intrinsics.checkNotNull(r73);
        r72.f((int) r73.getWaitSec());
    L317:
        if (r69 == null) goto L319;
        g1 r74 = r69;
        Intrinsics.checkNotNullParameter(r74, "$this$fromUid");
        String r210 = r74.get_fromUid();
        String r211 = String.valueOf(r69.getFromRoomId());
    L320:
        jy0.b.d("ttlive_anchor_link_panel", "anchor link invite/apply dialog show, type: " + this.p);
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r118 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r118 == null) goto L335;
        int r75 = this.x;
        i6 r76 = this.D;
        if (r76 == null) goto L325;
        boolean r212 = com.bytedance.android.live.revenuelink.connect.b.a(r76);
    L326:
        boolean r213 = ha0();
        List<com.bytedance.android.livesdk.link.model.p> r77 = this.t;
        Intrinsics.checkNotNull(r77);
        int r214 = ((ArrayList) r77).size();
        if (this.p != 2) goto L329;
        boolean r215 = true;
    L330:
        int r78 = this.y;
        v3 r216 = e21.e.c(this.D);
        if (r69 == null) goto L333;
        String r217 = r69.getEventTrackingInfo();
    L334:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q.o(r118, r75, r212, r213, r214, r215, r78, r210, r211, r216, null, r217, 512);
        goto L335
    L333:
        r217 = null;
        goto L334
    L329:
        r215 = false;
        goto L330
    L325:
        r212 = false;
    L335:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r79 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r79 == null) goto L338;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r79.c = "";
    L338:
        i6 r80 = this.D;
        if (r80 == null) goto L341;
        r67 = com.bytedance.android.live.revenuelink.connect.b.a(r80);
    L341:
        if (r67 == true) goto L345;
        p11.d r82 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r82 == null) goto L345;
        r82.b();
    L345:
        return r1;
    L319:
        r210 = null;
        r211 = null;
    L316:
        ((i21.a) this.f).f(10);
        goto L317
    L309:
        if (r69.getWaitSec() <= 0) goto L311;
        i21.a r83 = (i21.a) this.f;
        i6 r84 = this.D;
        Intrinsics.checkNotNull(r84);
        e6 r85 = r84.getInvite();
        Intrinsics.checkNotNull(r85);
        r83.f((int) r85.getWaitSec());
        goto L317
    L207:
        r44 = 0;
        goto L208
    L201:
        if (((int) r40.getType2()) != 4) goto L203;
        r42 = ga0(this.J);
        goto L204
    L165:
        if (((int) r39.getType2()) != 3) goto L198;
        if (TextUtils.isEmpty(this.O) == true) goto L198;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r86 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r86 == null) goto L171;
        int r87 = r86.h();
    L173:
        if (r87 <= 0) goto L184;
        com.bytedance.android.livesdk.link.model.p r88 = this.q;
        if (r88 == null) goto L184;
        Intrinsics.checkNotNull(r88);
        if (r88.getUser() == null) goto L184;
        List<com.bytedance.android.livesdk.link.model.p> r89 = this.t;
        if (r89 == null) goto L184;
        if (((ArrayList) r89).size() <= 0) goto L184;
        r42 = s1.C(2131920527, new Object[]{da0(this.O, 5)});
    L184:
        if (TextUtils.isEmpty(this.O) == true) goto L203;
        Integer r90 = this.R;
        int r92 = IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusInPK.ordinal();
        if (r90 != null) goto L189;
    L190:
        Integer r93 = this.R;
        int r94 = IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusInLinkMic.ordinal();
        if (r93 != null) goto L194;
    L196:
        r42 = s1.C(2131920528, new Object[]{da0(this.O, 5)});
        goto L204
    L194:
        if (r93.intValue() != r94) goto L196;
    L197:
        r42 = s1.C(2131920526, new Object[]{da0(this.O, 5)});
        goto L204
    L189:
        if (r90.intValue() == r92) goto L197;
    L171:
        r87 = 0;
    L141:
        i6 r95 = this.D;
        Intrinsics.checkNotNull(r95);
        e6 r96 = r95.getInvite();
        if (r96 == null) goto L146;
        List r97 = f6.b(r96);
        if (r97 == null) goto L146;
        List<com.bytedance.android.livesdk.link.model.p> r98 = this.t;
        Intrinsics.checkNotNull(r98);
        ((ArrayList) r98).addAll(r97);
    L146:
        i6 r99 = this.D;
        Intrinsics.checkNotNull(r99);
        e6 r100 = r99.getInvite();
        Intrinsics.checkNotNull(r100);
        if (r100.getInviteUser() == null) goto L149;
        i6 r101 = this.D;
        Intrinsics.checkNotNull(r101);
        e6 r102 = r101.getInvite();
        Intrinsics.checkNotNull(r102);
        this.q = r102.getInviteUser();
    L149:
        Integer r103 = this.R;
        int r104 = IBattleLinkerInviteMessageExtra.InviteStatus.InviteStatusUnknown.ordinal();
        if (r103 == null) goto L155;
        if (r103.intValue() != r104) goto L155;
    L161:
        la0(r1);
    L155:
        if (this.p == 2) goto L161;
        if (com.bytedance.android.live.revenuelink.connect.b.a(this.D) == true) goto L161;
        la0(r1);
        this.Q = true;
        i11.b r105 = this.B;
        if (r105 == null) goto L162;
        Intrinsics.checkNotNull(r105);
        r105.b(4, "show_be_invited_applied_dialog");
        goto L162
    L220:
        i6 r106 = this.D;
        if (r106 == null) goto L225;
        e6 r107 = r106.getInvite();
        if (r107 == null) goto L225;
        String r108 = r107.getPeerDesc();
    L227:
        if (TextUtils.isEmpty(r108) == true) goto L236;
        ((TextView) r1.findViewById(2131382096)).setVisibility(0);
        TextView r109 = (TextView) r1.findViewById(2131382096);
        i6 r119 = this.D;
        if (r119 == null) goto L233;
        e6 r120 = r119.getInvite();
        if (r120 == null) goto L233;
        CharSequence r121 = r120.getPeerDesc();
    L234:
        r109.setText(r121);
    L233:
        r121 = null;
    L236:
        if (com.bytedance.android.live.revenuelink.connect.b.a(this.D) == false) goto L238;
    L243:
        i6 r122 = this.D;
        Intrinsics.checkNotNull(r122);
        e6 r123 = r122.getInvite();
        if (r123 == null) goto L249;
        List r124 = f6.b(r123);
        if (r124 == null) goto L253;
        List<com.bytedance.android.livesdk.link.model.p> r125 = this.t;
        Intrinsics.checkNotNull(r125);
        ((ArrayList) r125).addAll(r124);
    L253:
        Collections.sort(this.t, new f(this));
        List<com.bytedance.android.livesdk.link.model.p> r126 = this.t;
        if (r126 != null) goto L256;
    L258:
        ja0(this.t);
        goto L259
    L256:
        if (((ArrayList) r126).size() <= 1) goto L258;
        ArrayList r127 = (ArrayList) this.t;
        r127.subList(1, r127.size()).clear();
        goto L258
    L249:
        if (this.E == null) goto L253;
        List<com.bytedance.android.livesdk.link.model.p> r128 = this.t;
        Intrinsics.checkNotNull(r128);
        ((ArrayList) r128).add(this.q);
        List r129 = f6.a(this.E);
        if (r129 == null) goto L253;
        ((ArrayList) this.t).addAll(r129);
        goto L253
    L238:
        if (this.E != null) goto L243;
        i11.b r130 = this.B;
        if (r130 == null) goto L259;
        Intrinsics.checkNotNull(r130);
        r130.b(4, "show_be_invited_applied_dialog");
    L225:
        r108 = null;
        goto L227
    L45:
        if (r12 != 2) goto L47;
        this.w = ga0(this.J);
        goto L88
    L47:
        if (r12 != 3) goto L88;
        com.bytedance.android.livesdk.link.model.p r131 = this.q;
        List r132 = f6.a(this.E);
        int r133 = n.a;
        if (r131 == null) goto L54;
        IBaseUser r134 = r131.getUser();
        if (r134 == null) goto L54;
        String r135 = r134.getNickName();
        if (r135 == null) goto L54;
    L55:
        if (r132 == null) goto L79;
        Iterator r136 = r132.iterator();
    L58:
        if (r136.hasNext() == false) goto L72;
        Object r137 = r136.next();
        IBaseUser r138 = ((com.bytedance.android.livesdk.link.model.p) r137).getUser();
        if (r138 == null) goto L62;
        String r139 = r138.getIdString();
    L63:
        if (r131 == null) goto L67;
        IBaseUser r140 = r131.getUser();
        if (r140 == null) goto L67;
        String r141 = r140.getIdString();
    L69:
        if ((!Intrinsics.areEqual(r139, r141)) == false) goto L58;
    L73:
        com.bytedance.android.livesdk.link.model.p r142 = (com.bytedance.android.livesdk.link.model.p) r137;
        if (r142 == null) goto L79;
        IBaseUser r143 = r142.getUser();
        if (r143 == null) goto L79;
        String r144 = r143.getNickName();
        if (r144 == null) goto L79;
    L80:
        SpannableStringBuilder r145 = new SpannableStringBuilder();
        r145.append(n.a(r135));
        r145.setSpan(new StyleSpan(1), 0, r145.length(), 33);
        r145.append("邀请");
        int r146 = r145.length();
        r145.append("你");
        r145.setSpan(new StyleSpan(1), r146, r145.length(), 33);
        if (r144.length() <= 0) goto L83;
        boolean r147 = true;
    L84:
        if (r147 == false) goto L86;
        r145.append("与");
        int r148 = r145.length();
        r145.append(n.a(r144));
        r145.setSpan(new StyleSpan(1), r148, r145.length(), 33);
    L86:
        r145.append("退出当前局重新连线");
        this.w = r145;
        goto L88
    L83:
        r147 = false;
    L67:
        r141 = null;
        goto L69
    L62:
        r139 = null;
        goto L63
    L72:
        r137 = null;
    L79:
        r144 = "";
    L54:
        r135 = "";
        goto L55
    L36:
        if (this.p == 2) goto L41;
        r8.setVisibility(0);
        String r149 = f51.a.e.a();
        Context r150 = getContext();
        if (TextUtils.isEmpty(r149) == true) goto L42;
        if (r150 == null) goto L42;
        StringCompanionObject r151 = StringCompanionObject.INSTANCE;
        r8.setText(String.format(r149, Arrays.copyOf(new Object[]{r150.getResources().getString(2131918107)}, 1)));
        goto L42
    L30:
        if (r9.getSecret() != 1) goto L32;
        r10 = true;
        goto L34
    L26:
        r7 = r1.findViewById(2131383050);
        goto L27
    L14:
        this.g = (TextView) r1.findViewById(2131364604);
        this.h = (TextView) r1.findViewById(2131364592);
        this.i = (AnchorLinkInfoInviteView) r1.findViewById(2131377963);
        this.j = (AnchorLinkInfoInviteView) r1.findViewById(2131377964);
        this.k = (AnchorLinkInfoInviteView) r1.findViewById(2131377965);
        TextView r152 = this.h;
        if (r152 == null) goto L17;
        r152.setTextColor(s1.h(2131106807));
        goto L17
    L5:
        r1 = r32.inflate(2131566029, r33, false);
        goto L6
    }
}
