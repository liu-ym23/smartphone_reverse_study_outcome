package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.AnchorInteractSettingContract$View;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomPKAttentionFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.RevScrollListenerView;
import com.bytedance.android.live.revlink.impl.precisefind.MultiPkPreciseFindContext;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/AnchorInteractSettingFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/AnchorInteractSettingContract$View;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Lx31/q;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorInteractSettingFragment extends AnchorInteractSettingContract$View implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, x31.q {
    public static final /* synthetic */ int H0 = 0;
    public boolean A;
    public Switch B;
    public Switch C;
    public ViewGroup D;
    public TextView E;
    public ViewGroup F;
    public ViewGroup G;
    public ViewGroup H;
    public ViewGroup I;
    public Switch J;
    public Switch K;
    public Switch L;
    public Switch M;
    public Switch N;
    public Switch O;
    public Switch P;
    public Switch Q;
    public Switch R;
    public Switch S;
    public boolean T;
    public TextView U;
    public TextView V;
    public ViewGroup W;
    public Switch X;
    public boolean Y;
    public boolean Z;
    public TextView g;
    public ImageView h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public boolean k0;
    public TextView l;
    public ImageView m;
    public ImageView n;
    public ViewGroup o;
    public ViewGroup p;
    public boolean p0;
    public Switch q;
    public ViewGroup r;
    public Switch s;
    public ImageView t;
    public Switch u;
    public Switch v;
    public Switch w;
    public Switch x;
    public Switch y;
    public Switch z;

    public static final class a {
    }

    public static final class a0<T> implements Consumer {
        public static final a0 a = null;

        static {
            a = new a0();
        }

        public a0() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AnchorInteractSettingFragment a;

        public b(AnchorInteractSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            AnchorInteractSettingFragment r3 = this.a;
            int r0 = AnchorInteractSettingFragment.H0;
            r3.d.v0();
        }
    }

    public static final class b0<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public b0(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            l51.a.F(this.a);
            if (this.a == false) goto L6;
            f2.b(2131918717, 0);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class c0<T> implements Consumer {
        public static final c0 a = null;

        static {
            a = new c0();
        }

        public c0() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public d(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.t(this.a);
        }
    }

    public static final class d0<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public d0(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            l51.a.K(this.a);
            if (this.a == true) goto L6;
            f2.b(2131916224, 0);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class e0<T> implements Consumer {
        public static final e0 a = null;

        static {
            a = new e0();
        }

        public e0() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public f(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.w(this.a);
        }
    }

    public static final class f0<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public f0(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            l51.a.L(this.a);
            if (this.a == true) goto L6;
            f2.b(2131916226, 0);
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class g0<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public g0(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            boolean r6 = this.a;
            l51.a.G0.setValue(null, l51.a.a[95], Boolean.valueOf(r6));
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ AnchorInteractSettingFragment a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ IRoom c;

        public h(AnchorInteractSettingFragment r1, boolean r2, IRoom r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            l51.a.P(this.b);
            HashMap r6 = new HashMap();
            r6.put("anchor_id", String.valueOf(this.c.getAnchorId()));
            r6.put("room_id", String.valueOf(this.c.getId()));
            Context r0 = this.a.getContext();
            if (r0 == null) goto L17;
            Object r1 = r0.getSystemService("window");
            if (r1 == null) goto L15;
            int r2 = ((WindowManager) r1).getDefaultDisplay().getRotation();
            if (r2 != 0) goto L9;
        L12:
            boolean r3 = true;
        L13:
            r6.put("room_orientation", String.valueOf(r3));
            goto L17
        L9:
            if (r2 == 2) goto L12;
            r3 = false;
            goto L13
        L15:
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        L17:
            if (this.b == true) goto L19;
            String r7 = "off";
        L20:
            r6.put("gift_guest_switch_type", r7);
            r6.put("send_gift_scene", "video_anchor_pk");
            mz0.n r8 = new mz0.n();
            Map<String, String> r9 = r8.a;
            Intrinsics.checkNotNullParameter(r9, "map");
            Intrinsics.checkNotNullParameter(r6, "map");
            r9.putAll(r6);
            mz0.m r10 = new mz0.m();
            r10.b(LogCommon.PAGE_SOURCE_LOG);
            r10.b(LogCommon.ROOM);
            List<Object> r12 = r8.b;
            ArrayList r13 = (ArrayList) r12;
            r13.addAll(r10.a);
            cy0.e.a.getClass();
            cy0.j r14 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r15);
            ((mz0.i) ((f80.a) r15)).w3("gift_guest_switch", r8.a, r8.b);
            return;
        L19:
            r7 = "on";
            goto L20
        }
    }

    public static final class h0<T> implements Consumer {
        public static final h0 a = null;

        static {
            a = new h0();
        }

        public h0() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class i0<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public i0(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            l51.a.O(this.a);
            if (this.a == true) goto L5;
            ToastUtil.a(2131914759, 0);
        L5:
            HashMap r6 = new HashMap();
            w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r0 == null) goto L8;
            Map<String, String> r1 = r0.f();
        L9:
            r6.putAll(r1);
            if (this.a == false) goto L12;
            String r2 = "on";
        L13:
            r6.put("switch", r2);
            r6.put("setting_partition", "pk");
            r6.put("setting_sub_partition", "egg");
            mz0.n r3 = new mz0.n();
            Map<String, String> r7 = r3.a;
            Intrinsics.checkNotNullParameter(r7, "map");
            Intrinsics.checkNotNullParameter(r6, "map");
            r7.putAll(r6);
            mz0.m r8 = new mz0.m();
            r8.b(LogCommon.PAGE_SOURCE_LOG);
            r8.b(LogCommon.ROOM);
            List<Object> r9 = r3.b;
            ArrayList r10 = (ArrayList) r9;
            r10.addAll(r8.a);
            cy0.e.a.getClass();
            cy0.j r12 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r13);
            ((mz0.i) ((f80.a) r13)).w3("livesdk_anchor_interation_invitation_setting_switch", r3.a, r3.b);
            return;
        L12:
            r2 = "off";
            goto L13
        L8:
            r1 = MapsKt.emptyMap();
            goto L9
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public j(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            boolean r6 = this.a;
            l51.a.g.setValue(null, l51.a.a[6], Boolean.valueOf(r6));
        }
    }

    public static final class j0<T> implements Consumer {
        public static final j0 a = null;

        static {
            a = new j0();
        }

        public j0() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class k<T> implements Consumer {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class k0<T> implements Consumer {
        public static final k0 a = null;

        static {
            a = new k0();
        }

        public k0() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public l(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            boolean r6 = this.a;
            l51.a.h.setValue(null, l51.a.a[7], Boolean.valueOf(r6));
        }
    }

    public static final class l0<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public l0(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.s(this.a);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public m(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.x(this.a);
        }
    }

    public static final class m0<T> implements Consumer {
        public static final m0 a = null;

        static {
            a = new m0();
        }

        public m0() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class n<T> implements Consumer {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class n0<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public n0(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.v(this.a);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public o(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.C(this.a);
        }
    }

    public static final class o0<T> implements Consumer {
        public static final o0 a = null;

        static {
            a = new o0();
        }

        public o0() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class p<T> implements Consumer {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class p0<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public p0(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.u(this.a);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public q(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.A(this.a);
        }
    }

    public static final class q0 implements RevScrollListenerView.a {
        public final /* synthetic */ AnchorInteractSettingFragment a;
        public final /* synthetic */ View b;

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.RevScrollListenerView.a
        public final void a(int r4) {
            AnchorInteractSettingFragment r0 = this.a;
            if (r0.Z == true) goto L12;
            float r5 = r4 + s1.e(r0.U90() - 56);
            AnchorInteractSettingFragment r1 = this.a;
            View r2 = this.b;
            r1.getClass();
            if (r5 <= (r2.findViewById(2131377987).getY() + r2.findViewById(2131372668).getY())) goto L13;
            HashMap r6 = new HashMap();
            w31.c r3 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r3 == null) goto L9;
            Map<String, String> r7 = r3.f();
        L10:
            r6.putAll(r7);
            mz0.n r8 = new mz0.n();
            Map<String, String> r9 = r8.a;
            Intrinsics.checkNotNullParameter(r9, "map");
            Intrinsics.checkNotNullParameter(r6, "map");
            r9.putAll(r6);
            mz0.m r10 = new mz0.m();
            r10.b(LogCommon.PAGE_SOURCE_LOG);
            r10.b(LogCommon.ROOM);
            ((ArrayList) r8.b).addAll(r10.a);
            cy0.e.a.getClass();
            cy0.j r12 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r13);
            ((mz0.i) ((f80.a) r13)).w3("livesdk_connection_default_enlarge_item_show", r8.a, r8.b);
            this.a.Z = true;
            return;
        L9:
            r7 = MapsKt.emptyMap();
            goto L10
        L13:
            return;
        }

        public q0(AnchorInteractSettingFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class r<T> implements Consumer {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class r0 implements Runnable {
        public final /* synthetic */ AnchorInteractSettingFragment a;
        public final /* synthetic */ View b;

        public r0(AnchorInteractSettingFragment r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            y41.d r0 = y41.d.j;
            AnchorInteractSettingFragment r1 = this.a;
            int r2 = AnchorInteractSettingFragment.H0;
            if (r0.a(r1.ja0()) == true) goto L5;
            return;
        L5:
            if (this.a.Z == true) goto L15;
            View r3 = this.b;
            if ((r3.findViewById(2131377987).getY() + r3.findViewById(2131372668).getY()) >= s1.e(this.a.U90())) goto L16;
            HashMap r4 = new HashMap();
            w31.c r5 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r5 == null) goto L11;
            Map<String, String> r6 = r5.f();
        L12:
            r4.putAll(r6);
            mz0.n r7 = new mz0.n();
            Map<String, String> r8 = r7.a;
            Intrinsics.checkNotNullParameter(r8, "map");
            Intrinsics.checkNotNullParameter(r4, "map");
            r8.putAll(r4);
            mz0.m r9 = new mz0.m();
            r9.b(LogCommon.PAGE_SOURCE_LOG);
            r9.b(LogCommon.ROOM);
            List<Object> r10 = r7.b;
            ArrayList r12 = (ArrayList) r10;
            r12.addAll(r9.a);
            cy0.e.a.getClass();
            cy0.j r13 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r14);
            ((mz0.i) ((f80.a) r14)).w3("livesdk_connection_default_enlarge_item_show", r7.a, r7.b);
            this.a.Z = true;
            return;
        L11:
            r6 = MapsKt.emptyMap();
            goto L12
        L16:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public s(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.B(this.a);
        }
    }

    public static final class s0<T> implements Consumer {
        public final /* synthetic */ AnchorInteractSettingFragment a;

        public s0(AnchorInteractSettingFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            ExtraResponse r8 = (ExtraResponse) r7;
            if (r8 == null) goto L5;
            com.bytedance.android.livesdk.link.model.g r1 = (com.bytedance.android.livesdk.link.model.g) r8.data;
        L6:
            if (r1 == null) goto L11;
            com.bytedance.android.livesdk.link.model.h r9 = ((com.bytedance.android.livesdk.link.model.g) r8.data).getAnchorBattleUserSettings();
            if (r9 == null) goto L13;
            l51.a.x(r9.isTurnOn());
            l51.a.K(r9.getAutoStartPropCard());
            l51.a.P(r9.getAllowGiftToOtherAnchorsInPK());
            l51.a.s(r9.getAcceptFollowedInvite());
            l51.a.u(r9.getAcceptPopularityRankInvite());
            l51.a.t(r9.getAcceptHourlyRankInvite());
            l51.a.w(r9.getAcceptNotFollowerInvite());
            String r2 = r9.getInviteRejectTemporaryText();
            com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.C;
            KProperty[] r4 = l51.a.a;
            r3.setValue(null, r4[28], r2);
            l51.a.W.setValue(null, r4[54], Long.valueOf(r9.getInviteRejectTemporary()));
            l51.a.X.setValue(null, r4[55], Long.valueOf(r9.getInviteRejectPermanent()));
            l51.a.G0.setValue(null, r4[95], Boolean.valueOf(r9.getAcceptUnionRecommendInvite()));
            l51.a.z(r9.getAllowGiftToOtherAnchorsInLinkmic());
            RandomCheckDataContext.Companion.c(r9.getPkAutoConfirm(), false);
            goto L11
        L13:
            return;
        L11:
            AnchorInteractSettingFragment r10 = this.a;
            int r0 = AnchorInteractSettingFragment.H0;
            r10.ia0(true);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class t<T> implements Consumer {
        public static final t a = null;

        static {
            a = new t();
        }

        public t() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class t0<T> implements Consumer {
        public static final t0 a = null;

        static {
            a = new t0();
        }

        public t0() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public u(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.D(this.a);
        }
    }

    public static final class u0<T> implements Consumer {
        public final /* synthetic */ AnchorInteractSettingFragment a;

        public u0(AnchorInteractSettingFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            ExtraResponse r8 = (ExtraResponse) r7;
            if (r8 == null) goto L5;
            com.bytedance.android.livesdk.link.model.o r1 = (com.bytedance.android.livesdk.link.model.o) r8.data;
        L7:
            if (r1 == null) goto L18;
            com.bytedance.android.livesdk.link.model.u r2 = ((com.bytedance.android.livesdk.link.model.o) r8.data).getAnchorLinkmicUserSettings();
            if (r2 == null) goto L20;
            Boolean r9 = ((com.bytedance.android.livesdk.link.model.o) r8.data).getSupportAiAssistantCellularEnhancement();
            if (r9 == null) goto L14;
            boolean r10 = r9.booleanValue();
        L15:
            if (r10 == false) goto L17;
            this.a.p0 = true;
        L17:
            boolean r12 = r2.isTurnOn();
            com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.g;
            KProperty[] r4 = l51.a.a;
            r3.setValue(null, r4[6], Boolean.valueOf(r12));
            l51.a.h.setValue(null, r4[7], Boolean.valueOf(r2.getAcceptMultiAnchorLink()));
            l51.a.C(r2.getAcceptNotFollowerInvite());
            l51.a.A(r2.getAcceptFriendInvite());
            l51.a.B(r2.getAcceptHourlyRankInvite());
            l51.a.D(r2.getAcceptPopularityRankInvite());
            l51.a.E(r2.getAcceptRecommendSearchInvite());
            l51.a.L(r2.getAutoStartStealDragon());
            l51.a.v(r2.getAcceptFindPeopleInvite());
            l51.a.O(r2.getAcceptTeamTask());
            goto L18
        L14:
            r10 = false;
            goto L15
        L20:
            return;
        L18:
            AnchorInteractSettingFragment r13 = this.a;
            int r0 = AnchorInteractSettingFragment.H0;
            r13.ha0(true);
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class v<T> implements Consumer {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class v0<T> implements Consumer {
        public static final v0 a = null;

        static {
            a = new v0();
        }

        public v0() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class w<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public w(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ExtraResponse r2 = (ExtraResponse) r1;
            l51.a.E(this.a);
        }
    }

    public static final class x<T> implements Consumer {
        public static final x a = null;

        static {
            a = new x();
        }

        public x() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class y<T> implements Consumer {
        public static final y a = null;

        static {
            a = new y();
        }

        public y() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public static final class z<T> implements Consumer {
        public final /* synthetic */ AnchorInteractSettingFragment a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ IRoom c;

        public z(AnchorInteractSettingFragment r1, boolean r2, IRoom r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            l51.a.z(this.b);
            HashMap r6 = new HashMap();
            r6.put("anchor_id", String.valueOf(this.c.getAnchorId()));
            r6.put("room_id", String.valueOf(this.c.getId()));
            Context r0 = this.a.getContext();
            if (r0 == null) goto L21;
            Object r1 = r0.getSystemService("window");
            if (r1 == null) goto L19;
            WindowManager r2 = (WindowManager) r1;
            boolean r3 = false;
            if (r2.getDefaultDisplay() == null) goto L9;
            int r7 = r2.getDefaultDisplay().getRotation();
        L10:
            if (r7 != 0) goto L12;
        L13:
            r3 = true;
        L14:
            if (r3 == false) goto L16;
            String r8 = DataType.FALSE;
        L17:
            r6.put("room_orientation", r8);
            goto L21
        L16:
            r8 = DataType.TRUE;
            goto L17
        L12:
            if (r7 != 2) goto L14;
        L9:
            r7 = 0;
            goto L10
        L19:
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        L21:
            if (this.b == false) goto L23;
            String r9 = "on";
        L24:
            r6.put("gift_guest_switch_type", r9);
            mz0.n r10 = new mz0.n();
            Map<String, String> r12 = r10.a;
            Intrinsics.checkNotNullParameter(r12, "map");
            Intrinsics.checkNotNullParameter(r6, "map");
            r12.putAll(r6);
            mz0.m r13 = new mz0.m();
            r13.b(LogCommon.PAGE_SOURCE_LOG);
            r13.b(LogCommon.ROOM);
            List<Object> r14 = r10.b;
            ArrayList r15 = (ArrayList) r14;
            r15.addAll(r13.a);
            cy0.e.a.getClass();
            cy0.j r16 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r17);
            ((mz0.i) ((f80.a) r17)).w3("gift_guest_switch", r10.a, r10.b);
            return;
        L23:
            r9 = "off";
            goto L24
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        r11.p r1 = b51.b.c0.j();
        if (r1 != null) goto L5;
        return 432.0f;
    L5:
        if (r1.getEnable() == true) goto L7;
        return 432.0f;
    L7:
        return t6.d(s1.getContext(), t6.b(s1.getContext()) * r11.q.a(r1)) - 48;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final View V90() {
        if (this.k0 == true) goto L6;
        return null;
    L6:
        AutoRTLImageView r1 = new AutoRTLImageView(getContext());
        float r2 = 32;
        r1.setLayoutParams(new RelativeLayout.LayoutParams(s1.f(r2), s1.f(r2)));
        r1.setImageDrawable(s1.m(2131251314));
        r1.setOnClickListener(new b(this));
        r3.c(r1, s1.B(2131918649), true);
        return r1;
    }

    public final Map<String, String> fa0() {
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        HashMap r3 = new HashMap();
        if (r2 == null) goto L10;
        r3.put("anchor_id", String.valueOf(r2.getAnchorId()));
        r3.put("room_id", String.valueOf(r2.getId()));
    L10:
        if (((Boolean) l51.a.D.getValue(null, l51.a.a[29])).booleanValue() == false) goto L12;
        r3.put("best_invite_anchor_recom_status", "on");
    L13:
        return r3;
    L12:
        r3.put("best_invite_anchor_recom_status", "off");
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    @Override // x31.q
    public final void gh() {
        TextView r1 = this.i;
        Intrinsics.checkNotNull(r1);
        r1.setText(ea0(l51.a.c()));
        TextView r2 = this.l;
        Intrinsics.checkNotNull(r2);
        r2.setText(ea0(l51.a.b()));
    }

    public final boolean ja0() {
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 != null) goto L5;
        return false;
    L5:
        IRoom r2 = r1.getRoom();
        if (r2 != null) goto L8;
        return false;
    L8:
        IRoomSpecificSceneTypeInfo r3 = r2.getSceneTypeInfo();
        if (r3 != null) goto L12;
        return false;
    L12:
        if (r3.isLandscapeVerticalRoom() != 1) goto L15;
        return true;
    L15:
        return false;
    }

    public final void ka0() {
        ViewGroup r1 = this.o;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getVisibility() != 0) goto L16;
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = l51.a.v;
        KProperty[] r3 = l51.a.a;
        na0("pk", "manual", ((Boolean) r2.getValue(null, r3[21])).booleanValue());
        na0("pk", "hourly_rank", ((Boolean) l51.a.y.getValue(null, r3[24])).booleanValue());
        na0("pk", "popularly_rank", ((Boolean) l51.a.x.getValue(null, r3[23])).booleanValue());
        na0("pk", "recommend_search", ((Boolean) l51.a.z.getValue(null, r3[25])).booleanValue());
        com.bytedance.android.live.revlink.impl.precisefind.a r4 = MultiPkPreciseFindContext.Companion.a();
        if (r4 == null) goto L12;
        if (r4.Ip() != true) goto L12;
        na0("pk", "pk_circle_select", ((Boolean) l51.a.w.getValue(null, r3[22])).booleanValue());
    L12:
        if (b51.b.c0.f().getShow() == false) goto L17;
        na0("pk", "egg", l51.a.q());
        return;
    L17:
        return;
    }

    public final void la0() {
        ViewGroup r1 = this.F;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getVisibility() != 0) goto L9;
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = l51.a.l;
        KProperty[] r3 = l51.a.a;
        na0("connection", "manual", ((Boolean) r2.getValue(null, r3[11])).booleanValue());
        na0("connection", "hourly_rank", ((Boolean) l51.a.m.getValue(null, r3[12])).booleanValue());
        na0("connection", "popularly_rank", ((Boolean) l51.a.n.getValue(null, r3[13])).booleanValue());
        na0("connection", "recommend_search", ((Boolean) l51.a.o.getValue(null, r3[14])).booleanValue());
        return;
    }

    public AnchorInteractSettingFragment() {
        this.k0 = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        return getString(2131914722);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.AnchorInteractSettingContract$View
    public final void ca0(int r2) {
        if (((BaseFragment) this).mStatusViewValid == true) goto L5;
        return;
    L5:
        TextView r1 = this.g;
        Intrinsics.checkNotNull(r1);
        r1.setText(da0(r2));
    }

    public final String da0(int r4) {
        if (r4 >= 60) goto L7;
        return s1.C(2131917856, new Object[]{Integer.valueOf(r4)});
    L7:
        return s1.C(2131917855, new Object[]{Integer.valueOf(r4 / 60)});
    }

    public final String ea0(long r4) {
        if (r4 <= 99) goto L6;
        return "99+";
    L6:
        return String.valueOf(r4);
    }

    public final void ga0(int r2) {
        ViewGroup r1 = this.F;
        Intrinsics.checkNotNull(r1);
        r1.setVisibility(r2);
        ViewGroup r3 = this.G;
        Intrinsics.checkNotNull(r3);
        r3.setVisibility(8);
    }

    public final void ha0(boolean r10) {
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.g;
        KProperty[] r4 = l51.a.a;
        boolean r5 = false;
        if (((Boolean) r3.getValue(null, r4[6])).booleanValue() == true) goto L12;
        Switch r6 = this.K;
        Intrinsics.checkNotNull(r6);
        r6.setChecked(false);
        if (r10 == false) goto L11;
        na0("connection", "all", false);
    L11:
        ga0(8);
    L17:
        if (this.T == true) goto L20;
        ViewGroup r7 = this.H;
        Intrinsics.checkNotNull(r7);
        r7.setVisibility(8);
    L20:
        if (this.p0 == false) goto L38;
        ViewGroup r8 = this.I;
        if (r8 == null) goto L24;
        r8.setVisibility(0);
    L24:
        HashMap<String, HashMap<String, Integer>> r9 = l51.a.a();
        if (r2 == null) goto L27;
        String r12 = r2.getAnchorId();
    L28:
        HashMap<String, Integer> r13 = r9.get(r12);
        if (r13 != null) goto L31;
        r13 = new HashMap();
    L31:
        Switch r14 = this.J;
        Intrinsics.checkNotNull(r14);
        Integer r15 = r13.get("cellular_open");
        if (r15 != null) goto L35;
    L37:
        r14.setChecked(r5);
        goto L38
    L35:
        if (r15.intValue() != 1) goto L37;
        r5 = true;
        goto L37
    L27:
        r12 = null;
    L38:
        Switch r16 = this.L;
        Intrinsics.checkNotNull(r16);
        r16.setChecked(((Boolean) l51.a.h.getValue(null, r4[7])).booleanValue());
        Switch r17 = this.M;
        Intrinsics.checkNotNull(r17);
        r17.setChecked(((Boolean) l51.a.i.getValue(null, r4[8])).booleanValue());
        Switch r18 = this.N;
        Intrinsics.checkNotNull(r18);
        r18.setChecked(((Boolean) l51.a.j.getValue(null, r4[9])).booleanValue());
        Switch r19 = this.O;
        Intrinsics.checkNotNull(r19);
        r19.setChecked(l51.a.e());
        Switch r20 = this.P;
        Intrinsics.checkNotNull(r20);
        r20.setChecked(((Boolean) l51.a.l.getValue(null, r4[11])).booleanValue());
        Switch r22 = this.Q;
        Intrinsics.checkNotNull(r22);
        r22.setChecked(((Boolean) l51.a.m.getValue(null, r4[12])).booleanValue());
        Switch r23 = this.R;
        Intrinsics.checkNotNull(r23);
        r23.setChecked(((Boolean) l51.a.n.getValue(null, r4[13])).booleanValue());
        Switch r24 = this.S;
        Intrinsics.checkNotNull(r24);
        r24.setChecked(((Boolean) l51.a.o.getValue(null, r4[14])).booleanValue());
        if (r10 == false) goto L42;
        la0();
        return;
    L42:
        return;
    L12:
        Switch r25 = this.K;
        Intrinsics.checkNotNull(r25);
        r25.setChecked(true);
        if (r10 == false) goto L15;
        na0("connection", "all", true);
    L15:
        ga0(0);
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    public final void ia0(boolean r8) {
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = l51.a.p;
        KProperty[] r2 = l51.a.a;
        if (((Boolean) r1.getValue(null, r2[15])).booleanValue() == true) goto L7;
        Switch r3 = this.u;
        Intrinsics.checkNotNull(r3);
        r3.setChecked(false);
        ViewGroup r4 = this.o;
        Intrinsics.checkNotNull(r4);
        r4.setVisibility(8);
        if (r8 == false) goto L11;
        na0("pk", "all", false);
    L11:
        if (this.A == true) goto L13;
        ViewGroup r5 = this.p;
        Intrinsics.checkNotNull(r5);
        r5.setVisibility(8);
    L13:
        Switch r6 = this.v;
        Intrinsics.checkNotNull(r6);
        r6.setChecked(((Boolean) l51.a.G0.getValue(null, r2[95])).booleanValue());
        Switch r7 = this.w;
        Intrinsics.checkNotNull(r7);
        r7.setChecked(((Boolean) l51.a.v.getValue(null, r2[21])).booleanValue());
        Switch r9 = this.X;
        if (r9 == null) goto L16;
        r9.setChecked(((Boolean) l51.a.w.getValue(null, r2[22])).booleanValue());
    L16:
        Switch r10 = this.x;
        Intrinsics.checkNotNull(r10);
        r10.setChecked(((Boolean) l51.a.x.getValue(null, r2[23])).booleanValue());
        Switch r12 = this.y;
        Intrinsics.checkNotNull(r12);
        r12.setChecked(((Boolean) l51.a.y.getValue(null, r2[24])).booleanValue());
        Switch r13 = this.z;
        Intrinsics.checkNotNull(r13);
        r13.setChecked(((Boolean) l51.a.z.getValue(null, r2[25])).booleanValue());
        Switch r14 = this.s;
        Intrinsics.checkNotNull(r14);
        r14.setChecked(l51.a.q());
        Switch r15 = this.q;
        Intrinsics.checkNotNull(r15);
        r15.setChecked(l51.a.r());
        Switch r16 = this.B;
        if (r16 == null) goto L19;
        r16.setChecked(((Boolean) l51.a.t.getValue(null, r2[19])).booleanValue());
    L19:
        Switch r17 = this.C;
        if (r17 == null) goto L22;
        r17.setChecked(((Boolean) l51.a.u.getValue(null, r2[20])).booleanValue());
    L22:
        if (r8 == false) goto L24;
        ka0();
    L24:
        String r18 = (String) l51.a.C.getValue(null, r2[28]);
        Intrinsics.checkNotNull(r18);
        if (TextUtils.isEmpty(r18) == true) goto L27;
        TextView r19 = this.j;
        Intrinsics.checkNotNull(r19);
        r19.setText(r18);
    L27:
        TextView r20 = this.i;
        Intrinsics.checkNotNull(r20);
        r20.setText(ea0(l51.a.c()));
        TextView r22 = this.l;
        Intrinsics.checkNotNull(r22);
        r22.setText(ea0(l51.a.b()));
        return;
    L7:
        Switch r23 = this.u;
        Intrinsics.checkNotNull(r23);
        r23.setChecked(true);
        if (r8 == false) goto L11;
        na0("pk", "all", true);
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        Intrinsics.checkNotNullParameter(r12, "view");
        if (r12.getId() != 2131391589) goto L5;
    L6:
        int r1 = InteractPKTimeDialogFragment.o;
        int r2 = ((x31.a) this.f).f();
        InteractPKTimeDialogFragment r3 = new InteractPKTimeDialogFragment();
        r3.i = this;
        r3.f = r2;
        r3.j = true;
        FragmentActivity r4 = getContext();
        Intrinsics.checkNotNull(r4);
        FragmentManager r5 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "InteractPKTimeDialogFragment", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r3, r6) == true) goto L12;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L10:
        r3.show(r5, "InteractPKTimeDialogFragment");
    L12:
        if (r12.getId() != 2131390205) goto L14;
    L15:
        com.bytedance.android.live.revlink.impl.control.dialog.r r7 = this.d;
        int r8 = InteractPkBanListFragment.p;
        Intrinsics.checkNotNullParameter(r7, "view");
        InteractPkBanListFragment r9 = new InteractPkBanListFragment();
        r9.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.q(r9, 2);
        r9.d = r7;
        r9.h = 2;
        r9.n = this;
        r7.zD(r9);
        Map<String, String> r10 = fa0();
        HashMap r13 = (HashMap) r10;
        r13.put("reject_type", DataType.TRUE);
        r13.put("number", String.valueOf(l51.a.c()));
        mz0.n r14 = new mz0.n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r10, "map");
        r15.putAll(r10);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_reject_pk_anchor_click", r14.a, r14.b);
    L17:
        if (r12.getId() != 2131390204) goto L19;
    L20:
        com.bytedance.android.live.revlink.impl.control.dialog.r r18 = this.d;
        int r19 = InteractPkBanListFragment.p;
        Intrinsics.checkNotNullParameter(r18, "view");
        InteractPkBanListFragment r20 = new InteractPkBanListFragment();
        r20.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.q(r20, 1);
        r20.d = r18;
        r20.h = 1;
        r20.n = this;
        r18.zD(r20);
        Map<String, String> r22 = fa0();
        HashMap r23 = (HashMap) r22;
        r23.put("reject_type", "2");
        r23.put("number", String.valueOf(l51.a.b()));
        mz0.n r24 = new mz0.n();
        Map<String, String> r25 = r24.a;
        Intrinsics.checkNotNullParameter(r25, "map");
        Intrinsics.checkNotNullParameter(r22, "map");
        r25.putAll(r22);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((mz0.i) ((f80.a) r27)).w3("livesdk_reject_pk_anchor_click", r24.a, r24.b);
    L22:
        if (r12.getId() != 2131382367) goto L25;
        Context r28 = getContext();
        Intrinsics.checkNotNull(r28);
        f51.a r29 = f51.a.e;
        r29.getClass();
        zz0.h.b(r28, (String) f51.a.c.getValue(r29, f51.a.a[1]));
        HashMap r30 = new HashMap();
        r30.put("action_from", "setting");
        mz0.n r32 = new mz0.n();
        Map<String, String> r33 = r32.a;
        Intrinsics.checkNotNullParameter(r33, "map");
        Intrinsics.checkNotNullParameter(r30, "map");
        r33.putAll(r30);
        mz0.m r34 = new mz0.m();
        r34.b(LogCommon.ROOM);
        List<Object> r35 = r32.b;
        ArrayList r36 = (ArrayList) r35;
        r36.addAll(r34.a);
        cy0.e.a.getClass();
        cy0.j r37 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r38 = com.bytedance.android.scope.m.b(r37).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r38);
        ((mz0.i) ((f80.a) r38)).w3("livesdk_pk_rule_click", r32.a, r32.b);
    L25:
        if (r12.getId() != 2131376445) goto L32;
        int r39 = RandomPKAttentionFragment.p;
        RandomMatchCheckSource r40 = RandomMatchCheckSource.Setting;
        Intrinsics.checkNotNullParameter(r40, "source");
        RandomPKAttentionFragment r42 = new RandomPKAttentionFragment();
        r42.i = r40;
        r42.o = null;
        FragmentActivity r43 = getContext();
        Intrinsics.checkNotNull(r43);
        FragmentManager r44 = r43.getSupportFragmentManager();
        LandscapeRestrictionOperation r45 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r42, "randon_pk_attention_fragment", r45);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r44, r42, r45) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L30:
        r42.show(r44, "randon_pk_attention_fragment");
    L32:
        if (r12.getId() != 2131376471) goto L43;
        u6 r110 = new u6(b51.b.c0.f().getUrl());
        Context r46 = getContext();
        if (r46 == null) goto L44;
        ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(r46, r110.c(), AnchorInteractSettingFragment$onClick$4$1.INSTANCE);
        return;
    L44:
        return;
    L43:
        return;
    L19:
        if (r12.getId() != 2131376037) goto L22;
    L14:
        if (r12.getId() != 2131376038) goto L17;
    L5:
        if (r12.getId() != 2131376676) goto L12;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.AnchorInteractSettingContract$View
    public final void ba0(int r2, int r3) {
        ((x31.a) this.f).g(r2, r3);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r29, boolean r30) {
        Intrinsics.checkNotNullParameter(r29, "view");
        yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 == null) goto L5;
        IRoom r3 = r2.getRoom();
    L7:
        if (r29.getId() != 2131387842) goto L24;
        HashMap r4 = new HashMap();
        r4.put("is_turn_on", Boolean.valueOf(r30));
        if (r3 == null) goto L19;
        r31.a r12 = r31.b.a(r31.a.a);
        long r13 = r3.getId();
        if (r3.getOwner() == null) goto L13;
        IBaseUser r5 = r3.getOwner();
        Intrinsics.checkNotNull(r5);
        String r15 = com.bytedance.android.live.base.model.user.o.a(r5);
    L14:
        Observable<ExtraResponse<Object, Extra>> r6 = r12.N(r13, r15, 0, r4);
        if (r6 == null) goto L19;
        ObservableSubscribeProxy r7 = (ObservableSubscribeProxy) r6.as(T90());
        if (r7 == null) goto L19;
        r7.subscribe(new m(r30), x.a);
        goto L19
    L13:
        r15 = null;
    L19:
        ViewGroup r8 = this.o;
        Intrinsics.checkNotNull(r8);
        if (r30 == false) goto L22;
        int r9 = 0;
    L23:
        r8.setVisibility(r9);
        ma0("pk", "all", r30);
        ka0();
        return;
    L22:
        r9 = 8;
        goto L23
    L24:
        String r14 = "";
        if (r29.getId() != 2131387843) goto L38;
        HashMap r10 = new HashMap();
        r10.put("accept_union_recommend_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L36;
        r31.a r16 = r31.b.a(r31.a.a);
        long r17 = r3.getId();
        if (r3.getOwner() == null) goto L31;
        IBaseUser r18 = r3.getOwner();
        Intrinsics.checkNotNull(r18);
        r14 = com.bytedance.android.live.base.model.user.o.a(r18);
    L31:
        Observable<ExtraResponse<Object, Extra>> r19 = r16.N(r17, r14, 17, r10);
        if (r19 == null) goto L36;
        ObservableSubscribeProxy r20 = (ObservableSubscribeProxy) r19.as(T90());
        if (r20 == null) goto L36;
        r20.subscribe(new g0(r30), k0.a);
    L36:
        ma0("pk", "agent_recommend", r30);
        return;
    L38:
        if (r29.getId() != 2131387844) goto L52;
        HashMap r22 = new HashMap();
        r22.put("accept_friend_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L50;
        r31.a r110 = r31.b.a(r31.a.a);
        long r111 = r3.getId();
        if (r3.getOwner() == null) goto L44;
        IBaseUser r23 = r3.getOwner();
        Intrinsics.checkNotNull(r23);
        String r112 = com.bytedance.android.live.base.model.user.o.a(r23);
    L45:
        Observable<ExtraResponse<Object, Extra>> r24 = r110.N(r111, r112, 4, r22);
        if (r24 == null) goto L50;
        ObservableSubscribeProxy r25 = (ObservableSubscribeProxy) r24.as(T90());
        if (r25 == null) goto L50;
        r25.subscribe(new l0(r30), m0.a);
        goto L50
    L44:
        r112 = null;
    L50:
        ma0("pk", "manual", r30);
        return;
    L52:
        if (r29.getId() != 2131387847) goto L66;
        HashMap r26 = new HashMap();
        r26.put("accept_find_people_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L64;
        r31.a r113 = r31.b.a(r31.a.a);
        long r114 = r3.getId();
        if (r3.getOwner() == null) goto L58;
        IBaseUser r27 = r3.getOwner();
        Intrinsics.checkNotNull(r27);
        String r115 = com.bytedance.android.live.base.model.user.o.a(r27);
    L59:
        Observable<ExtraResponse<Object, Extra>> r28 = r113.N(r114, r115, 21, r26);
        if (r28 == null) goto L64;
        ObservableSubscribeProxy r32 = (ObservableSubscribeProxy) r28.as(T90());
        if (r32 == null) goto L64;
        r32.subscribe(new n0(r30), o0.a);
        goto L64
    L58:
        r115 = null;
    L64:
        ma0("pk", "pk_circle_select", r30);
        return;
    L66:
        if (r29.getId() != 2131387846) goto L80;
        HashMap r33 = new HashMap();
        r33.put("accept_popularity_rank_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L78;
        r31.a r116 = r31.b.a(r31.a.a);
        long r117 = r3.getId();
        if (r3.getOwner() == null) goto L72;
        IBaseUser r34 = r3.getOwner();
        Intrinsics.checkNotNull(r34);
        String r210 = com.bytedance.android.live.base.model.user.o.a(r34);
    L73:
        Observable<ExtraResponse<Object, Extra>> r35 = r116.N(r117, r210, 9, r33);
        if (r35 == null) goto L78;
        ObservableSubscribeProxy r36 = (ObservableSubscribeProxy) r35.as(T90());
        if (r36 == null) goto L78;
        r36.subscribe(new p0(r30), c.a);
        goto L78
    L72:
        r210 = null;
    L78:
        ma0("pk", "popularly_rank", r30);
        return;
    L80:
        if (r29.getId() != 2131387845) goto L94;
        HashMap r37 = new HashMap();
        r37.put("accept_hourly_rank_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L92;
        r31.a r118 = r31.b.a(r31.a.a);
        long r211 = r3.getId();
        if (r3.getOwner() == null) goto L86;
        IBaseUser r38 = r3.getOwner();
        Intrinsics.checkNotNull(r38);
        String r212 = com.bytedance.android.live.base.model.user.o.a(r38);
    L87:
        Observable<ExtraResponse<Object, Extra>> r39 = r118.N(r211, r212, 5, r37);
        if (r39 == null) goto L92;
        ObservableSubscribeProxy r40 = (ObservableSubscribeProxy) r39.as(T90());
        if (r40 == null) goto L92;
        r40.subscribe(new d(r30), e.a);
        goto L92
    L86:
        r212 = null;
    L92:
        ma0("pk", "hourly_rank", r30);
        return;
    L94:
        if (r29.getId() != 2131387848) goto L108;
        HashMap r42 = new HashMap();
        r42.put("accept_not_follower_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L106;
        r31.a r213 = r31.b.a(r31.a.a);
        long r214 = r3.getId();
        if (r3.getOwner() == null) goto L100;
        IBaseUser r43 = r3.getOwner();
        Intrinsics.checkNotNull(r43);
        String r215 = com.bytedance.android.live.base.model.user.o.a(r43);
    L101:
        Observable<ExtraResponse<Object, Extra>> r44 = r213.N(r214, r215, 1, r42);
        if (r44 == null) goto L106;
        ObservableSubscribeProxy r45 = (ObservableSubscribeProxy) r44.as(T90());
        if (r45 == null) goto L106;
        r45.subscribe(new f(r30), g.a);
        goto L106
    L100:
        r215 = null;
    L106:
        ma0("pk", "recommend_search", r30);
        return;
    L108:
        if (r29.getId() != 2131387868) goto L121;
        HashMap r46 = new HashMap();
        r46.put("allow_gift_to_other_anchors", Boolean.valueOf(r30));
        if (r3 == null) goto L330;
        r31.a r216 = r31.b.a(r31.a.a);
        long r217 = r3.getId();
        if (r3.getOwner() == null) goto L114;
        IBaseUser r47 = r3.getOwner();
        Intrinsics.checkNotNull(r47);
        String r218 = com.bytedance.android.live.base.model.user.o.a(r47);
    L115:
        Observable<ExtraResponse<Object, Extra>> r48 = r216.N(r217, r218, 2, r46);
        if (r48 == null) goto L331;
        ObservableSubscribeProxy r49 = (ObservableSubscribeProxy) r48.as(T90());
        if (r49 == null) goto L332;
        r49.subscribe(new h(this, r30, r3), i.a);
        return;
    L332:
        return;
    L331:
        return;
    L114:
        r218 = null;
        goto L115
    L330:
        return;
    L121:
        if (r29.getId() != 2131387869) goto L138;
        HashMap r50 = new HashMap();
        r50.put("is_turn_on", Boolean.valueOf(r30));
        if (r3 == null) goto L133;
        r31.a r219 = r31.b.a(r31.a.a);
        long r220 = r3.getId();
        if (r3.getOwner() == null) goto L127;
        IBaseUser r52 = r3.getOwner();
        Intrinsics.checkNotNull(r52);
        String r221 = com.bytedance.android.live.base.model.user.o.a(r52);
    L128:
        Observable<ExtraResponse<Object, Extra>> r53 = r219.updateAnchorLinkSetting(r220, r221, 0, r50);
        if (r53 == null) goto L133;
        ObservableSubscribeProxy r54 = (ObservableSubscribeProxy) r53.as(T90());
        if (r54 == null) goto L133;
        r54.subscribe(new j(r30), k.a);
        goto L133
    L127:
        r221 = null;
    L133:
        if (r30 == false) goto L135;
        int r55 = 0;
    L136:
        ga0(r55);
        ma0("connection", "all", r30);
        la0();
        return;
    L135:
        r55 = 8;
        goto L136
    L138:
        if (r29.getId() != 2131387870) goto L151;
        HashMap r56 = new HashMap();
        r56.put("accept_multi_linkmic", Boolean.valueOf(r30));
        if (r3 == null) goto L335;
        r31.a r222 = r31.b.a(r31.a.a);
        long r223 = r3.getId();
        if (r3.getOwner() == null) goto L144;
        IBaseUser r57 = r3.getOwner();
        Intrinsics.checkNotNull(r57);
        String r224 = com.bytedance.android.live.base.model.user.o.a(r57);
    L145:
        Observable<ExtraResponse<Object, Extra>> r58 = r222.updateAnchorLinkSetting(r223, r224, 1, r56);
        if (r58 == null) goto L336;
        ObservableSubscribeProxy r59 = (ObservableSubscribeProxy) r58.as(T90());
        if (r59 == null) goto L337;
        r59.subscribe(new l(r30), n.a);
        return;
    L337:
        return;
    L336:
        return;
    L144:
        r224 = null;
        goto L145
    L335:
        return;
    L151:
        if (r29.getId() != 2131387871) goto L164;
        HashMap r60 = new HashMap();
        r60.put("accept_not_follower_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L339;
        r31.a r225 = r31.b.a(r31.a.a);
        long r226 = r3.getId();
        if (r3.getOwner() == null) goto L157;
        IBaseUser r62 = r3.getOwner();
        Intrinsics.checkNotNull(r62);
        String r227 = com.bytedance.android.live.base.model.user.o.a(r62);
    L158:
        Observable<ExtraResponse<Object, Extra>> r63 = r225.updateAnchorLinkSetting(r226, r227, 2, r60);
        if (r63 == null) goto L340;
        ObservableSubscribeProxy r64 = (ObservableSubscribeProxy) r63.as(T90());
        if (r64 == null) goto L341;
        r64.subscribe(new o(r30), p.a);
        return;
    L341:
        return;
    L340:
        return;
    L157:
        r227 = null;
        goto L158
    L339:
        return;
    L164:
        if (r29.getId() != 2131387838) goto L178;
        HashMap r65 = new HashMap();
        r65.put("accept_friend_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L176;
        r31.a r228 = r31.b.a(r31.a.a);
        long r229 = r3.getId();
        if (r3.getOwner() == null) goto L170;
        IBaseUser r66 = r3.getOwner();
        Intrinsics.checkNotNull(r66);
        String r230 = com.bytedance.android.live.base.model.user.o.a(r66);
    L171:
        Observable<ExtraResponse<Object, Extra>> r67 = r228.updateAnchorLinkSetting(r229, r230, 4, r65);
        if (r67 == null) goto L176;
        ObservableSubscribeProxy r68 = (ObservableSubscribeProxy) r67.as(T90());
        if (r68 == null) goto L176;
        r68.subscribe(new q(r30), r.a);
        goto L176
    L170:
        r230 = null;
    L176:
        ma0("connection", "manual", r30);
        return;
    L178:
        if (r29.getId() != 2131387839) goto L192;
        HashMap r69 = new HashMap();
        r69.put("accept_hourly_rank_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L190;
        r31.a r231 = r31.b.a(r31.a.a);
        long r232 = r3.getId();
        if (r3.getOwner() == null) goto L184;
        IBaseUser r70 = r3.getOwner();
        Intrinsics.checkNotNull(r70);
        String r233 = com.bytedance.android.live.base.model.user.o.a(r70);
    L185:
        Observable<ExtraResponse<Object, Extra>> r72 = r231.updateAnchorLinkSetting(r232, r233, 5, r69);
        if (r72 == null) goto L190;
        ObservableSubscribeProxy r73 = (ObservableSubscribeProxy) r72.as(T90());
        if (r73 == null) goto L190;
        r73.subscribe(new s(r30), t.a);
        goto L190
    L184:
        r233 = null;
    L190:
        ma0("connection", "hourly_rank", r30);
        return;
    L192:
        if (r29.getId() != 2131387840) goto L206;
        HashMap r74 = new HashMap();
        r74.put("accept_popularity_rank_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L204;
        r31.a r234 = r31.b.a(r31.a.a);
        long r235 = r3.getId();
        if (r3.getOwner() == null) goto L198;
        IBaseUser r75 = r3.getOwner();
        Intrinsics.checkNotNull(r75);
        String r236 = com.bytedance.android.live.base.model.user.o.a(r75);
    L199:
        Observable<ExtraResponse<Object, Extra>> r76 = r234.updateAnchorLinkSetting(r235, r236, 6, r74);
        if (r76 == null) goto L204;
        ObservableSubscribeProxy r77 = (ObservableSubscribeProxy) r76.as(T90());
        if (r77 == null) goto L204;
        r77.subscribe(new u(r30), v.a);
        goto L204
    L198:
        r236 = null;
    L204:
        ma0("connection", "popularly_rank", r30);
        return;
    L206:
        if (r29.getId() != 2131387841) goto L220;
        HashMap r78 = new HashMap();
        r78.put("accept_recommend_search_invite", Boolean.valueOf(r30));
        if (r3 == null) goto L218;
        r31.a r237 = r31.b.a(r31.a.a);
        long r238 = r3.getId();
        if (r3.getOwner() == null) goto L212;
        IBaseUser r79 = r3.getOwner();
        Intrinsics.checkNotNull(r79);
        String r239 = com.bytedance.android.live.base.model.user.o.a(r79);
    L213:
        Observable<ExtraResponse<Object, Extra>> r80 = r237.updateAnchorLinkSetting(r238, r239, 7, r78);
        if (r80 == null) goto L218;
        ObservableSubscribeProxy r82 = (ObservableSubscribeProxy) r80.as(T90());
        if (r82 == null) goto L218;
        r82.subscribe(new w(r30), y.a);
        goto L218
    L212:
        r239 = null;
    L218:
        ma0("connection", "recommend_search", r30);
        return;
    L220:
        if (r29.getId() != 2131387863) goto L233;
        HashMap r119 = new HashMap();
        r119.put("allow_gift_to_other_anchors", Boolean.valueOf(r30));
        if (r3 == null) goto L347;
        r31.a r83 = r31.b.a(r31.a.a);
        long r84 = r3.getId();
        if (r3.getOwner() == null) goto L226;
        IBaseUser r85 = r3.getOwner();
        Intrinsics.checkNotNull(r85);
        String r86 = com.bytedance.android.live.base.model.user.o.a(r85);
    L227:
        Observable<ExtraResponse<Object, Extra>> r87 = r83.updateAnchorLinkSetting(r84, r86, 3, r119);
        if (r87 == null) goto L348;
        ObservableSubscribeProxy r88 = (ObservableSubscribeProxy) r87.as(T90());
        if (r88 == null) goto L349;
        r88.subscribe(new z(this, r30, r3), a0.a);
        return;
    L349:
        return;
    L348:
        return;
    L226:
        r86 = null;
        goto L227
    L347:
        return;
    L233:
        if (r29.getId() != 2131387862) goto L254;
        HashMap r120 = new HashMap();
        r120.put("accept_big_small_layout", Boolean.valueOf(r30));
        if (r3 == null) goto L245;
        r31.a r89 = r31.b.a(r31.a.a);
        long r90 = r3.getId();
        if (r3.getOwner() == null) goto L239;
        IBaseUser r92 = r3.getOwner();
        Intrinsics.checkNotNull(r92);
        String r93 = com.bytedance.android.live.base.model.user.o.a(r92);
    L240:
        Observable<ExtraResponse<Object, Extra>> r94 = r89.updateAnchorLinkSetting(r90, r93, 8, r120);
        if (r94 == null) goto L245;
        ObservableSubscribeProxy r95 = (ObservableSubscribeProxy) r94.as(T90());
        if (r95 == null) goto L245;
        r95.subscribe(new b0(r30), c0.a);
        goto L245
    L239:
        r93 = null;
    L245:
        HashMap r96 = new HashMap();
        w31.c r97 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r97 == null) goto L248;
        Map<String, String> r98 = r97.f();
    L249:
        r96.putAll(r98);
        if (r30 == false) goto L252;
        String r1 = "open";
    L253:
        r96.put("click_type", r1);
        mz0.n r99 = new mz0.n();
        Map<String, String> r100 = r99.a;
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r96, "map");
        r100.putAll(r96);
        mz0.m r101 = new mz0.m();
        r101.b(LogCommon.PAGE_SOURCE_LOG);
        r101.b(LogCommon.ROOM);
        List<Object> r102 = r99.b;
        ArrayList r103 = (ArrayList) r102;
        r103.addAll(r101.a);
        cy0.e.a.getClass();
        cy0.j r104 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r105 = com.bytedance.android.scope.m.b(r104).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r105);
        ((mz0.i) ((f80.a) r105)).w3("livesdk_connection_default_enlarge_item_click", r99.a, r99.b);
        return;
    L252:
        r1 = "close";
        goto L253
    L248:
        r98 = MapsKt.emptyMap();
        goto L249
    L254:
        String r106 = "on";
        if (r29.getId() != 2131387860) goto L277;
        HashMap r121 = new HashMap();
        r121.put("auto_start_prop_card", Boolean.valueOf(r30));
        if (r3 == null) goto L267;
        r31.a r107 = r31.b.a(r31.a.a);
        long r122 = r3.getId();
        if (r3.getOwner() == null) goto L261;
        IBaseUser r108 = r3.getOwner();
        Intrinsics.checkNotNull(r108);
        String r123 = com.bytedance.android.live.base.model.user.o.a(r108);
    L262:
        Observable<ExtraResponse<Object, Extra>> r109 = r107.updateAnchorLinkSetting(r122, r123, 9, r121);
        if (r109 == null) goto L267;
        ObservableSubscribeProxy r124 = (ObservableSubscribeProxy) r109.as(T90());
        if (r124 == null) goto L267;
        r124.subscribe(new d0(r30), e0.a);
        goto L267
    L261:
        r123 = null;
    L267:
        HashMap r125 = new HashMap();
        w31.c r126 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r126 == null) goto L270;
        Map<String, String> r127 = r126.f();
    L271:
        r125.putAll(r127);
        if (r30 == true) goto L275;
        r106 = "off";
    L275:
        r125.put("switch", r106);
        mz0.n r128 = new mz0.n();
        Map<String, String> r129 = r128.a;
        Intrinsics.checkNotNullParameter(r129, "map");
        Intrinsics.checkNotNullParameter(r125, "map");
        r129.putAll(r125);
        mz0.m r130 = new mz0.m();
        r130.b(LogCommon.PAGE_SOURCE_LOG);
        r130.b(LogCommon.ROOM);
        List<Object> r131 = r128.b;
        ArrayList r132 = (ArrayList) r131;
        r132.addAll(r130.a);
        cy0.e.a.getClass();
        cy0.j r133 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r134 = com.bytedance.android.scope.m.b(r133).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r134);
        ((mz0.i) ((f80.a) r134)).w3("livesdk_connection_buffer_card_use_setting_click", r128.a, r128.b);
        return;
    L270:
        r127 = MapsKt.emptyMap();
        goto L271
    L277:
        if (r29.getId() != 2131387861) goto L299;
        HashMap r135 = new HashMap();
        r135.put("auto_start_steal_dragon", Boolean.valueOf(r30));
        if (r3 == null) goto L289;
        r31.a r136 = r31.b.a(r31.a.a);
        long r137 = r3.getId();
        if (r3.getOwner() == null) goto L283;
        IBaseUser r138 = r3.getOwner();
        Intrinsics.checkNotNull(r138);
        String r139 = com.bytedance.android.live.base.model.user.o.a(r138);
    L284:
        Observable<ExtraResponse<Object, Extra>> r140 = r136.updateAnchorLinkSetting(r137, r139, 10, r135);
        if (r140 == null) goto L289;
        ObservableSubscribeProxy r141 = (ObservableSubscribeProxy) r140.as(T90());
        if (r141 == null) goto L289;
        r141.subscribe(new f0(r30), h0.a);
        goto L289
    L283:
        r139 = null;
    L289:
        HashMap r142 = new HashMap();
        w31.c r143 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r143 == null) goto L292;
        Map<String, String> r144 = r143.f();
    L293:
        r142.putAll(r144);
        if (r30 == true) goto L297;
        r106 = "off";
    L297:
        r142.put("switch", r106);
        ma0("pk", "pk_dragon", r30);
        return;
    L292:
        r144 = MapsKt.emptyMap();
        goto L293
    L299:
        if (r29.getId() != 2131387858) goto L310;
        if (r3 == null) goto L354;
        HashMap<String, Integer> r145 = l51.a.a().get(r3.getAnchorId());
        if (r145 != null) goto L304;
        r145 = new HashMap();
    L304:
        r145.put("cellular_open", Integer.valueOf(r30 ? 1 : 0));
        HashMap<String, HashMap<String, Integer>> r146 = l51.a.a();
        String r147 = r3.getAnchorId();
        if (r147 != null) goto L307;
        String r148 = "";
    L308:
        r146.put(r148, r145);
        return;
    L307:
        r148 = r147;
        goto L308
    L354:
        return;
    L310:
        if (r29.getId() != 2131387932) goto L356;
        HashMap r149 = new HashMap();
        r149.put("accept_team_task", Boolean.valueOf(r30));
        if (r3 == null) goto L357;
        r31.a r150 = r31.b.a(r31.a.a);
        long r151 = r3.getId();
        if (r3.getOwner() == null) goto L316;
        IBaseUser r152 = r3.getOwner();
        Intrinsics.checkNotNull(r152);
        String r153 = com.bytedance.android.live.base.model.user.o.a(r152);
    L317:
        Observable<ExtraResponse<Object, Extra>> r154 = r150.N(r151, r153, 22, r149);
        if (r154 == null) goto L358;
        ObservableSubscribeProxy r155 = (ObservableSubscribeProxy) r154.as(T90());
        if (r155 == null) goto L359;
        r155.subscribe(new i0(r30), j0.a);
        return;
    L359:
        return;
    L358:
        return;
    L316:
        r153 = null;
        goto L317
    L357:
        return;
    L356:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public static void ma0(String r4, String r5, boolean r6) {
        HashMap r1 = new HashMap();
        yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 == null) goto L5;
        IRoom r3 = r2.getRoom();
    L6:
        if (r3 == null) goto L8;
        r1.put("anchor_id", String.valueOf(r3.getAnchorId()));
        r1.put("room_id", String.valueOf(r3.getId()));
    L8:
        r1.put("setting_partition", r4);
        r1.put("setting_sub_partition", r5);
        if (r6 == false) goto L11;
        String r7 = "on";
    L12:
        r1.put("switch", r7);
        mz0.n r8 = new mz0.n();
        Map<String, String> r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r9.putAll(r1);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.PAGE_SOURCE_LOG);
        r10.b(LogCommon.ROOM);
        List<Object> r12 = r8.b;
        ArrayList r13 = (ArrayList) r12;
        r13.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((mz0.i) ((f80.a) r15)).w3("livesdk_anchor_interation_invitation_setting_switch", r8.a, r8.b);
        return;
    L11:
        r7 = "off";
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public final void na0(String r5, String r6, boolean r7) {
        HashMap r1 = new HashMap();
        yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 == null) goto L5;
        IRoom r3 = r2.getRoom();
    L6:
        if (r3 == null) goto L8;
        r1.put("anchor_id", String.valueOf(r3.getAnchorId()));
        r1.put("room_id", String.valueOf(r3.getId()));
    L8:
        r1.put("setting_partition", r5);
        r1.put("setting_sub_partition", r6);
        if (r7 == false) goto L11;
        String r8 = "on";
    L12:
        r1.put("switch", r8);
        mz0.n r9 = new mz0.n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r10.putAll(r1);
        mz0.m r12 = new mz0.m();
        r12.b(LogCommon.PAGE_SOURCE_LOG);
        r12.b(LogCommon.ROOM);
        List<Object> r13 = r9.b;
        ArrayList r14 = (ArrayList) r13;
        r14.addAll(r12.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((mz0.i) ((f80.a) r16)).w3("livesdk_anchor_interation_invitation_setting_show", r9.a, r9.b);
        return;
    L11:
        r8 = "off";
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r12 = r8.inflate(2131566028, r9, false);
        this.g = (TextView) r12.findViewById(2131391589);
        this.h = (ImageView) r12.findViewById(2131376676);
        this.i = (TextView) r12.findViewById(2131390205);
        this.j = (TextView) r12.findViewById(2131390210);
        this.k = (ImageView) r12.findViewById(2131376038);
        this.l = (TextView) r12.findViewById(2131390204);
        this.m = (ImageView) r12.findViewById(2131376037);
        this.p = (ViewGroup) r12.findViewById(2131372670);
        this.B = (Switch) r12.findViewById(2131387860);
        this.C = (Switch) r12.findViewById(2131387861);
        this.D = (ViewGroup) r12.findViewById(2131372667);
        this.W = (ViewGroup) r12.findViewById(2131372811);
        this.X = (Switch) r12.findViewById(2131387847);
        this.o = (ViewGroup) r12.findViewById(2131378797);
        this.u = (Switch) r12.findViewById(2131387842);
        this.v = (Switch) r12.findViewById(2131387843);
        this.w = (Switch) r12.findViewById(2131387844);
        this.x = (Switch) r12.findViewById(2131387846);
        this.y = (Switch) r12.findViewById(2131387845);
        this.z = (Switch) r12.findViewById(2131387848);
        this.r = (ViewGroup) r12.findViewById(2131372813);
        this.s = (Switch) r12.findViewById(2131387932);
        this.t = (ImageView) r12.findViewById(2131376471);
        this.q = (Switch) r12.findViewById(2131387868);
        this.G = (ViewGroup) r12.findViewById(2131372679);
        this.H = (ViewGroup) r12.findViewById(2131372669);
        this.I = (ViewGroup) r12.findViewById(2131372665);
        this.K = (Switch) r12.findViewById(2131387869);
        this.L = (Switch) r12.findViewById(2131387870);
        this.M = (Switch) r12.findViewById(2131387871);
        this.N = (Switch) r12.findViewById(2131387862);
        this.O = (Switch) r12.findViewById(2131387863);
        this.F = (ViewGroup) r12.findViewById(2131378603);
        this.P = (Switch) r12.findViewById(2131387838);
        this.Q = (Switch) r12.findViewById(2131387839);
        this.R = (Switch) r12.findViewById(2131387840);
        this.S = (Switch) r12.findViewById(2131387841);
        this.J = (Switch) r12.findViewById(2131387858);
        this.V = (TextView) r12.findViewById(2131382367);
        this.n = (ImageView) r12.findViewById(2131376445);
        this.E = (TextView) r12.findViewById(2131390650);
        this.U = (TextView) r12.findViewById(2131390649);
        if (this.Y == false) goto L10;
        TextView r13 = this.E;
        if (r13 == null) goto L7;
        r13.setText(s1.B(2131914715));
    L7:
        TextView r14 = this.U;
        if (r14 == null) goto L16;
        r14.setText(s1.B(2131914698));
    L16:
        this.A = true;
        this.T = true;
        ViewGroup r1 = this.I;
        if (r1 == null) goto L19;
        r1.setVisibility(8);
    L19:
        b51.b r2 = b51.b.c0;
        r2.getClass();
        ReadOnlyProperty r3 = b51.b.Z;
        KProperty[] r4 = b51.b.a;
        if (((Boolean) r3.getValue(r2, r4[50])).booleanValue() == true) goto L25;
        View r5 = r12.findViewById(2131372666);
        if (r5 == null) goto L25;
        r5.setVisibility(8);
    L25:
        if (((Boolean) b51.b.a0.getValue(r2, r4[51])).booleanValue() == true) goto L29;
        View r15 = r12.findViewById(2131372667);
        if (r15 == null) goto L29;
        r15.setVisibility(8);
    L29:
        com.bytedance.android.live.revlink.impl.precisefind.a r16 = MultiPkPreciseFindContext.Companion.a();
        if (r16 != null) goto L32;
    L36:
        ViewGroup r17 = this.W;
        if (r17 == null) goto L40;
        r17.setVisibility(8);
    L40:
        if (y41.d.j.a(ja0()) == false) goto L42;
        r12.findViewById(2131372668).setVisibility(0);
        ((RevScrollListenerView) r12.findViewById(2131385223)).setScrollListener(new q0(this, r12));
    L42:
        r12.post(new r0(this, r12));
        ia0(false);
        ha0(false);
        yz0.k r18 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r18 == null) goto L45;
        IRoom r19 = r18.getRoom();
    L46:
        if (r19 != null) goto L48;
    L62:
        Switch r20 = this.u;
        if (r20 == null) goto L65;
        r20.setOnCheckedChangeListener(this);
    L65:
        Switch r22 = this.v;
        if (r22 == null) goto L68;
        r22.setOnCheckedChangeListener(this);
    L68:
        Switch r23 = this.w;
        if (r23 == null) goto L71;
        r23.setOnCheckedChangeListener(this);
    L71:
        Switch r24 = this.x;
        if (r24 == null) goto L74;
        r24.setOnCheckedChangeListener(this);
    L74:
        Switch r25 = this.y;
        if (r25 == null) goto L77;
        r25.setOnCheckedChangeListener(this);
    L77:
        Switch r26 = this.z;
        if (r26 == null) goto L80;
        r26.setOnCheckedChangeListener(this);
    L80:
        Switch r27 = this.s;
        if (r27 == null) goto L83;
        r27.setOnCheckedChangeListener(this);
    L83:
        Switch r28 = this.q;
        if (r28 == null) goto L86;
        r28.setOnCheckedChangeListener(this);
    L86:
        Switch r29 = this.X;
        if (r29 == null) goto L89;
        r29.setOnCheckedChangeListener(this);
    L89:
        Switch r30 = this.K;
        if (r30 == null) goto L92;
        r30.setOnCheckedChangeListener(this);
    L92:
        Switch r32 = this.L;
        if (r32 == null) goto L95;
        r32.setOnCheckedChangeListener(this);
    L95:
        Switch r33 = this.M;
        if (r33 == null) goto L98;
        r33.setOnCheckedChangeListener(this);
    L98:
        Switch r34 = this.N;
        if (r34 == null) goto L101;
        r34.setOnCheckedChangeListener(this);
    L101:
        Switch r35 = this.O;
        if (r35 == null) goto L104;
        r35.setOnCheckedChangeListener(this);
    L104:
        Switch r36 = this.P;
        if (r36 == null) goto L107;
        r36.setOnCheckedChangeListener(this);
    L107:
        Switch r37 = this.Q;
        if (r37 == null) goto L110;
        r37.setOnCheckedChangeListener(this);
    L110:
        Switch r38 = this.R;
        if (r38 == null) goto L113;
        r38.setOnCheckedChangeListener(this);
    L113:
        Switch r39 = this.S;
        if (r39 == null) goto L116;
        r39.setOnCheckedChangeListener(this);
    L116:
        Switch r40 = this.J;
        if (r40 == null) goto L119;
        r40.setOnCheckedChangeListener(this);
    L119:
        Switch r42 = this.B;
        if (r42 == null) goto L122;
        r42.setOnCheckedChangeListener(this);
    L122:
        Switch r43 = this.C;
        if (r43 == null) goto L125;
        r43.setOnCheckedChangeListener(this);
    L125:
        TextView r44 = this.g;
        if (r44 == null) goto L128;
        r44.setOnClickListener(this);
    L128:
        TextView r45 = this.g;
        if (r45 == null) goto L131;
        r45.setText(da0(((x31.a) this.f).e()));
    L131:
        ImageView r46 = this.h;
        if (r46 == null) goto L134;
        r46.setOnClickListener(this);
    L134:
        TextView r47 = this.i;
        if (r47 == null) goto L137;
        r47.setOnClickListener(this);
    L137:
        ImageView r48 = this.k;
        if (r48 == null) goto L140;
        r48.setOnClickListener(this);
    L140:
        TextView r49 = this.l;
        if (r49 == null) goto L143;
        r49.setOnClickListener(this);
    L143:
        ImageView r50 = this.m;
        if (r50 == null) goto L146;
        r50.setOnClickListener(this);
    L146:
        TextView r52 = this.V;
        if (r52 == null) goto L149;
        r52.setOnClickListener(this);
    L149:
        ImageView r53 = this.n;
        if (r53 == null) goto L152;
        r53.setOnClickListener(this);
    L152:
        ImageView r54 = this.t;
        if (r54 == null) goto L156;
        r54.setOnClickListener(this);
    L156:
        if (r2.f().getShow() == false) goto L163;
        ViewGroup r55 = this.r;
        if (r55 == null) goto L160;
        r55.setVisibility(0);
    L160:
        ViewGroup r56 = this.D;
        if (r56 == null) goto L169;
        r56.setVisibility(8);
    L169:
        TextView r57 = this.i;
        if (r57 == null) goto L172;
        r57.setText(DataType.FALSE);
    L172:
        TextView r58 = this.l;
        if (r58 == null) goto L175;
        r58.setText(DataType.FALSE);
    L175:
        UIUtils.setViewVisibility(this.V, 8);
        mz0.n r59 = new mz0.n();
        Map<String, String> r110 = r59.a;
        Intrinsics.checkNotNullParameter(r110, "map");
        Map<String, String> r6 = fa0();
        Intrinsics.checkNotNullParameter(r6, "map");
        r110.putAll(r6);
        w31.c r7 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r7 == null) goto L178;
        Map<String, String> r60 = r7.f();
    L179:
        Intrinsics.checkNotNullParameter(r60, "map");
        r110.putAll(r60);
        cy0.e.a.getClass();
        cy0.j r111 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r112);
        ((mz0.i) ((f80.a) r112)).w3("livesdk_anchor_interactive_settings_panel_show", r59.a, r59.b);
        return r12;
    L178:
        r60 = MapsKt.emptyMap();
        goto L179
    L163:
        ViewGroup r62 = this.r;
        if (r62 == null) goto L166;
        r62.setVisibility(8);
    L166:
        ViewGroup r63 = this.D;
        if (r63 == null) goto L169;
        r63.setVisibility(0);
        goto L169
    L48:
        if (r19.isLiveTypeAudio() == true) goto L50;
    L52:
        r31.a.C0307a r113 = r31.a.a;
        r31.a r64 = r31.b.a(r113);
        long r65 = r19.getId();
        IBaseUser r66 = r19.getOwner();
        Intrinsics.checkNotNull(r66);
        com.bytedance.android.live.base.model.user.o.a(r66);
        IBaseUser r67 = r19.getOwner();
        Intrinsics.checkNotNull(r67);
        Observable r68 = r64.i(r65, iz.a.a(r67), 0);
        if (r68 == null) goto L57;
        ObservableSubscribeProxy r69 = (ObservableSubscribeProxy) r68.as(T90());
        if (r69 == null) goto L57;
        r69.subscribe(new s0(this), t0.a);
    L57:
        r31.a r114 = r31.b.a(r113);
        long r70 = r19.getId();
        IBaseUser r72 = r19.getOwner();
        Intrinsics.checkNotNull(r72);
        Observable<ExtraResponse<com.bytedance.android.livesdk.link.model.o, Extra>> r73 = r114.getAnchorLinkSetting(r70, com.bytedance.android.live.base.model.user.o.a(r72));
        if (r73 == null) goto L62;
        ObservableSubscribeProxy r74 = (ObservableSubscribeProxy) r73.as(T90());
        if (r74 == null) goto L62;
        r74.subscribe(new u0(this), v0.a);
        goto L62
    L50:
        if (d51.c.A0.d() == true) goto L52;
        r12.findViewById(2131377987).setVisibility(8);
        goto L52
    L45:
        r19 = null;
        goto L46
    L32:
        if (r16.Ip() != true) goto L36;
        ViewGroup r75 = this.W;
        if (r75 == null) goto L40;
        r75.setVisibility(0);
        goto L40
    L10:
        TextView r115 = this.E;
        if (r115 == null) goto L13;
        r115.setText(s1.B(2131914713));
    L13:
        TextView r116 = this.U;
        if (r116 == null) goto L16;
        r116.setText(s1.B(2131914696));
        goto L16
    }
}
