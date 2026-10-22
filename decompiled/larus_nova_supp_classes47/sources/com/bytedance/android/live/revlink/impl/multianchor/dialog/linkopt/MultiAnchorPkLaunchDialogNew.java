package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkLaunchViewModelNew;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.RoundedLabelTitle;
import com.bytedance.android.live.revlink.impl.pk.ui.CustomViewPager;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/MultiAnchorPkLaunchDialogNew;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/a;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPkLaunchDialogNew extends LinkCommonDialogFragment implements com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.a {
    public static final /* synthetic */ int q = 0;
    public Map<Integer, View> e;
    public final Lazy f;
    public IBattleConfigSetting g;
    public String h;
    public final CompositeDisposable i;
    public boolean j;
    public boolean k;
    public Dialog l;
    public PlayMode m;
    public final p21.e n;
    public final b o;
    public final DataCenter p;

    public final class a extends FragmentPagerAdapter {
        public final SparseArray<Fragment> a;
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew b;

        public final int getCount() {
            return 2;
        }

        public final Fragment getItem(int r3) {
            if (r3 != 0) goto L6;
            MultiAnchorPkLaunchDialogNew r0 = this.b;
            MultiAnchorPersonalPkLaunchFragmentNew r4 = new MultiAnchorPersonalPkLaunchFragmentNew(r0.p, r0.n);
            r4.e = this.b;
            return r4;
        L6:
            if (r3 != 1) goto L10;
            MultiAnchorPkLaunchDialogNew r1 = this.b;
            DataCenter r2 = r1.p;
            MultiAnchorTeamPkLaunchFragmentNew r5 = new MultiAnchorTeamPkLaunchFragmentNew(r1.n);
            r5.e = this.b;
            return r5;
        L10:
            return new Fragment();
        }

        public a(MultiAnchorPkLaunchDialogNew r2, FragmentManager r3) {
            Intrinsics.checkNotNullParameter(r3, "fm");
            this.b = r2;
            super(r3);
            this.a = new SparseArray(2);
        }

        public final Object instantiateItem(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "container");
            Object r4 = super.instantiateItem(r2, r3);
            if (r4 == null) goto L7;
            Fragment r5 = (Fragment) r4;
            this.a.put(r3, r5);
            return r5;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        }

        public final void destroyItem(ViewGroup r2, int r3, Object r4) {
            Intrinsics.checkNotNullParameter(r2, "container");
            Intrinsics.checkNotNullParameter(r4, "object");
            super.destroyItem(r2, r3, r4);
            this.a.remove(r3);
        }
    }

    public static final class b extends i11.c.a {
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew a;

        public b(MultiAnchorPkLaunchDialogNew r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void b(int r2, List<? extends com.bytedance.android.livesdk.link.model.p> r3) {
            View r4 = this.a.getView();
            if (r4 == null) goto L5;
            View r5 = r4.findViewById(2131382355);
        L6:
            if (r3 == null) goto L8;
            int r6 = ((ArrayList) r3).size();
        L10:
            if (r6 <= 6) goto L12;
            int r7 = 216;
        L13:
            UIUtils.updateLayout(r5, -3, UtilityKotlinExtentionsKt.i(r7));
            return;
        L12:
            r7 = 124;
            goto L13
        L8:
            r6 = 0;
            goto L10
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew a;

        public c(MultiAnchorPkLaunchDialogNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew a;

        public d(MultiAnchorPkLaunchDialogNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.live.revlink.impl.multianchor.service.c r5 = com.bytedance.android.live.revlink.impl.global.b.y();
            if (r5 == null) goto L5;
            com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r5, 0, 0, null, 7);
        L5:
            MultiAnchorPkLaunchDialogNew r6 = this.a;
            int r0 = MultiAnchorPkLaunchDialogNew.q;
            r6.X90("click", "back");
            this.a.dismiss();     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L15;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements RoundedLabelTitle.c {
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew a;

        public e(MultiAnchorPkLaunchDialogNew r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.RoundedLabelTitle.c
        public final void a(PlayMode r7) {
            Intrinsics.checkNotNullParameter(r7, "playMode");
            MultiAnchorPkLaunchDialogNew r0 = this.a;
            r0.k = true;
            if (r7 != PlayMode.PERSONAL_PK) goto L5;
            String r2 = "one";
        L6:
            r0.X90("click", r2);
            MultiAnchorPkLaunchDialogNew r1 = this.a;
            PlayMode r3 = (PlayMode) r1.V90().getPlayModeLiveData().getValue();
            if (r3 == null) goto L41;
            if (r3 == r7) goto L42;
            jy0.b.d("ttlive_anchor_link_multi_pk", "multiPKLaunchDialog onPlayModeTapped " + r7);
            HashMap r4 = new HashMap();
            String r5 = r1.h;
            if (r5 == null) goto L14;
            r4.put("npk_invite_page_source", r5);
        L14:
            int r6 = y.a[r3.ordinal()];
            if (r6 != 1) goto L17;
            String r8 = "individual_pk";
        L22:
            r4.put("battle_mode", r8);
            d31.d r9 = com.bytedance.android.live.revlink.impl.global.b.c0();
            String r10 = "";
            if (r9 == null) goto L25;
            String r12 = r9.s();
        L26:
            r4.put("room_status", r12);
            d31.d r13 = com.bytedance.android.live.revlink.impl.global.b.c0();
            if (r13 == null) goto L32;
            String r14 = r13.a();
            if (r14 == null) goto L32;
            r10 = r14;
        L32:
            r4.put("anchor_connect_status", r10);
            r4.put("invite_mode", r1.U90());
            mz0.n r15 = new mz0.n();
            Map<String, String> r16 = r15.a;
            Intrinsics.checkNotNullParameter(r16, "map");
            Intrinsics.checkNotNullParameter(r4, "map");
            r16.putAll(r4);
            mz0.m r17 = new mz0.m();
            r17.b(LogCommon.ROOM);
            LinkCrossRoomDataHolder.a r18 = LinkCrossRoomDataHolder.c;
            com.bytedance.android.live.revlink.impl.a.b(r17);
            ((ArrayList) r15.b).addAll(r17.a);
            cy0.e.a.getClass();
            cy0.j r19 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r20);
            ((mz0.i) ((f80.a) r20)).w3("livesdk_npk_invite_page_battle_mode_click", r15.a, r15.b);
            if (r1.V90().getHasApplicant() == false) goto L35;
        L38:
            ToastUtil.a(2131920511, 0);
            return;
        L35:
            if (r1.V90().getHasInvitee() == true) goto L38;
            r1.V90().requestSwitchPlayMode(r7);
            return;
        L25:
            r12 = "";
            goto L26
        L17:
            if (r6 != 2) goto L20;
            r8 = "team_pk";
            goto L22
        L20:
            throw new NoWhenBranchMatchedException();
        L42:
            return;
        L41:
            return;
        L5:
            r2 = "team";
            goto L6
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew a;

        public f(MultiAnchorPkLaunchDialogNew r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ MultiAnchorPkLaunchDialogNew a;

        public g(MultiAnchorPkLaunchDialogNew r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            PlayMode r12 = (PlayMode) r10;
            PlayMode r0 = PlayMode.PERSONAL_PK;
            if (r12 != r0) goto L9;
            ((RoundedLabelTitle) this.a.S90(2131382356)).b(r0);
            ((CustomViewPager) this.a.S90(2131382355)).setCurrentItem(0);
            MultiAnchorPkLaunchDialogNew r3 = this.a;
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b r4 = MultiAnchorPkLaunchDialogNew.T90(r3);
            if (r4 == null) goto L7;
            boolean r5 = r4.qr();
        L8:
            r3.JW(r5, r12);
        L17:
            if (r12 == null) goto L47;
            MultiAnchorPkLaunchDialogNew r6 = this.a;
            if (r6.j == false) goto L47;
            r6.j = true;
            HashMap r7 = new HashMap();
            com.bytedance.android.live.revlink.impl.multianchor.vm.g r8 = com.bytedance.android.live.revlink.impl.global.b.u();
            if (r8 == null) goto L23;
            Long r9 = Long.valueOf(r8.a());
        L24:
            r7.put("channel_id", String.valueOf(r9));
            w31.c r13 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r13 == null) goto L27;
            Long r14 = Long.valueOf(r13.i());
        L28:
            r7.put("pk_id", String.valueOf(r14));
            r7.put("connection_anchor_cnt", String.valueOf(r6.V90().getCurrentAnchorList().size()));
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r15 = com.bytedance.android.live.revlink.impl.global.b.l();
            if (r15 == null) goto L32;
            String r16 = r15.a;
            if (r16 == null) goto L32;
        L33:
            r7.put("source", r16);
            r7.put("is_oncemore", DataType.FALSE);
            if (((PlayMode) r6.V90().getPlayModeLiveData().getValue()) != r0) goto L36;
            String r1 = "individual_pk";
        L37:
            r7.put("battle_mode", r1);
            if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L40;
            String r2 = "pk";
        L41:
            r7.put("room_status", r2);
            d31.d r17 = com.bytedance.android.live.revlink.impl.global.b.c0();
            if (r17 == null) goto L45;
            String r18 = r17.a();
            if (r18 == null) goto L45;
        L46:
            r7.put("anchor_connect_status", r18);
            r7.put("invite_mode", r6.U90());
            mz0.n r19 = new mz0.n();
            Map<String, String> r20 = r19.a;
            Intrinsics.checkNotNullParameter(r20, "map");
            Intrinsics.checkNotNullParameter(r7, "map");
            r20.putAll(r7);
            mz0.m r22 = new mz0.m();
            r22.b(LogCommon.ROOM);
            ((ArrayList) r19.b).addAll(r22.a);
            cy0.e.a.getClass();
            cy0.j r23 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r24);
            ((mz0.i) ((f80.a) r24)).w3("livesdk_npk_gameplay_banner_show", r19.a, r19.b);
        L45:
            r18 = "";
            goto L46
        L40:
            r2 = "connection";
            goto L41
        L36:
            r1 = "team_pk";
        L32:
            r16 = "";
            goto L33
        L27:
            r14 = null;
            goto L28
        L23:
            r9 = null;
        L47:
            if (r12 == null) goto L51;
            MultiAnchorPkLaunchDialogNew r25 = this.a;
            if (r25.k == false) goto L51;
            r25.k = false;
            r25.X90("show", "");
        L51:
            if (r12 == null) goto L82;
            Dialog r26 = this.a.l;
            if (r26 != null) goto L55;
            return;
        L55:
            if (r26.isShowing() != true) goto L84;
            MultiAnchorPkLaunchDialogNew r27 = this.a;
            if (r27.m != r12) goto L85;
            Dialog r110 = r27.l;
            if (r110 == null) goto L77;
            Handler r28 = DialogLancet.resolveDialogHandler(r110);
            if (r28 != null) goto L63;
        L65:
            DialogLancet.beforeDialogDismiss(r110);
            r110.dismiss();     // Catch: Throwable -> L68 Exception -> L70
        L74:
            DialogLancet.afterDialogDismiss(r110);
            goto L77
        L70:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L68
            Throwable r29 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L68
            if (r29 == null) goto L74;
            com.bytedance.crash.d.d(r29, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L68
        L68:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r110);
            throw th;
        L63:
            if (Looper.myLooper() == r28.getLooper()) goto L65;
            r28.post(DialogLancet.createDismissRunnable(r110));
        L77:
            MultiAnchorPkLaunchDialogNew r111 = this.a;
            r111.l = null;
            r111.m = null;
            return;
        L85:
            return;
        L84:
            return;
        L82:
            return;
        L7:
            r5 = true;
            goto L8
        L9:
            PlayMode r30 = PlayMode.TEAM_PK;
            if (r12 != r30) goto L17;
            ((RoundedLabelTitle) this.a.S90(2131382356)).b(r30);
            ((CustomViewPager) this.a.S90(2131382355)).setCurrentItem(1);
            MultiAnchorPkLaunchDialogNew r32 = this.a;
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b r33 = MultiAnchorPkLaunchDialogNew.T90(r32);
            if (r33 == null) goto L14;
            boolean r34 = r33.qr();
        L15:
            r32.JW(r34, r12);
            goto L17
        L14:
            r34 = true;
            goto L15
        }
    }

    public final MultiAnchorPkLaunchViewModelNew V90() {
        return (MultiAnchorPkLaunchViewModelNew) this.f.getValue();
    }

    public final String getDegradeTag() {
        return "anchor_multi_launch";
    }

    public final boolean W90() {
        IBattleConfigSetting r0 = this.g;
        if (r0 == null) goto L7;
        w2 r1 = r0.getShellConfig();
        if (r1 == null) goto L7;
        long r3 = r1.getType();
    L9:
        if (r3 <= 0) goto L19;
        IBattleConfigSetting r2 = this.g;
        if (r2 == null) goto L19;
        w2 r4 = r2.getShellConfig();
        if (r4 == null) goto L19;
        String r5 = r4.getName();
        if (r5 == null) goto L19;
        if ((!StringsKt.isBlank(r5)) != true) goto L19;
        return true;
    L19:
        return false;
    L7:
        r3 = 0;
        goto L9
    }

    public final String U90() {
        if (W90() == false) goto L5;
        return "compete";
    L5:
        IBattleConfigSetting r0 = this.g;
        if (r0 == null) goto L8;
        u2 r1 = r0.getSelfData();
    L9:
        if (r1 == null) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return "customize_pk";
    L14:
        return "routine_pk";
    L11:
        r2 = false;
        goto L12
    L8:
        r1 = null;
        goto L9
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.n.b();
        this.i.dispose();
        i11.b r0 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r0 == null) goto L5;
        r0.l(this.o);
    L5:
        jy0.b.d("ttlive_anchor_link_multi_pk", "multiPKLaunchDialog dismissed");
        ((LinkedHashMap) this.e).clear();
    }

    public static final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b T90(MultiAnchorPkLaunchDialogNew r4) {
        CustomViewPager r1 = (CustomViewPager) r4.S90(2131382355);
        Fragment r2 = null;
        if (r1 == null) goto L5;
        PagerAdapter r3 = r1.getAdapter();
    L7:
        if ((r3 instanceof a) == true) goto L9;
        r3 = null;
    L9:
        a r5 = (a) r3;
        if (r5 == null) goto L12;
        Fragment r6 = r5.a.get(((CustomViewPager) r4.S90(2131382355)).getCurrentItem());
    L14:
        if ((r6 instanceof com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b) == false) goto L18;
        r2 = r6;
    L18:
        return (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.b) r2;
    L12:
        r6 = null;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    public final View S90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void Y90(Integer r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.intValue() != 4017209) goto L15;
        dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L16:
        return;
    }

    public MultiAnchorPkLaunchDialogNew(DataCenter r1, p21.e r2) {
        this.p = r1;
        this.e = new LinkedHashMap();
        this.f = LazyKt.lazy(new MultiAnchorPkLaunchDialogNew$vm$2(this));
        this.i = new CompositeDisposable();
        this.j = true;
        this.k = true;
        if (r2 != null) goto L5;
        r2 = new p21.e(com.bytedance.android.live.revlink.impl.global.b.k());
    L5:
        this.n = r2;
        this.o = new b(this);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.a
    public final void JW(boolean r2, PlayMode r3) {
        Intrinsics.checkNotNullParameter(r3, "playMode");
        if (((PlayMode) V90().getPlayModeLiveData().getValue()) == r3) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        ((TextView) S90(2131387228)).setBackgroundResource(2131249697);
        return;
    L7:
        ((TextView) S90(2131387228)).setBackgroundResource(2131249980);
    }

    public final void X90(String r3, String r4) {
        IBattleConfigSetting r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getModType() != PkBaseDataContext.PKModType.SeasonRank.getType()) goto L14;
        HashMap r1 = new HashMap();
        r1.put("action_type", r3);
        if (((PlayMode) V90().getPlayModeLiveData().getValue()) != PlayMode.PERSONAL_PK) goto L10;
        String r5 = "one";
    L11:
        r1.put("tab_name", r5);
        r1.put("btn_type", r4);
        mz0.n r6 = new mz0.n();
        Map<String, String> r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r7.putAll(r1);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.ROOM);
        List<Object> r2 = r6.b;
        ArrayList r9 = (ArrayList) r2;
        r9.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r12);
        ((mz0.i) ((f80.a) r12)).w3("livesdk_pk_division_season_team_popup_manage", r6.a, r6.b);
        return;
    L10:
        r5 = "team";
        goto L11
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        V90().setBattleConfigSetting(this.g);
        V90().setNpkInvitePageSource(this.h);
        FragmentManager r9 = getChildFragmentManager();
        int r2 = 0;
        ((CustomViewPager) S90(2131382355)).b = false;
        ((CustomViewPager) S90(2131382355)).setAdapter(new a(this, r9));
        PagerAdapter r10 = ((CustomViewPager) S90(2131382355)).getAdapter();
        if (r10 == null) goto L5;
        r10.notifyDataSetChanged();
    L5:
        i11.b r12 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r12 == null) goto L10;
        List<com.bytedance.android.livesdk.link.model.p> r13 = r12.d();
        if (r13 == null) goto L10;
        int r14 = r13.size();
    L11:
        View r15 = r7.findViewById(2131382355);
        if (r14 <= 6) goto L14;
        int r16 = 216;
    L15:
        UIUtils.updateLayout(r15, -3, UtilityKotlinExtentionsKt.i(r16));
        i11.b r17 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r17 == null) goto L18;
        r17.i(this.o);
    L18:
        TextView r18 = (TextView) S90(2131387228);
        Object[] r1 = new Object[1];
        IBattleConfigSetting r3 = this.g;
        Boolean r4 = null;
        if (r3 == null) goto L23;
        w2 r5 = r3.getShellConfig();
        if (r5 == null) goto L23;
        String r6 = r5.getName();
    L24:
        if (r6 != null) goto L26;
    L28:
        IBattleConfigSetting r0 = this.g;
        if (r0 != null) goto L31;
    L33:
        r6 = "PK";
    L34:
        r1[0] = r6;
        r18.setText(s1.C(2131918018, r1));
        ((TextView) S90(2131387228)).setOnClickListener(x0.a(new AnonymousClass2(this)));
        S90(2131381758).setOnClickListener(new c(this));
        ((ImageView) S90(2131363762)).setOnClickListener(new d(this));
        RoundedLabelTitle r19 = (RoundedLabelTitle) S90(2131382356);
        MultiAnchorPkLaunchContext r20 = com.bytedance.android.live.revlink.impl.global.b.x();
        if (r20 == null) goto L42;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g> r22 = r20.getMultiPkModeInfo();
        if (r22 == null) goto L42;
        com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g r23 = (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g) r22.getValue();
        if (r23 == null) goto L42;
        r4 = r23.c;
    L42:
        if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L44;
        r2 = 8;
    L44:
        r19.setVisibility(r2);
        ((RoundedLabelTitle) S90(2131382356)).setOnTapPlayModeListener(new e(this));
        RxUtilKt.c(V90().getOnDismissEvent().subscribe(new f(this)), this.i);
        V90().getPlayModeLiveData().observe(this, new g(this));
        V90().initPage();
        Y90((Integer) V90().getErrorCode().getValue());
        V90().getErrorCode().observe(this, new z(this));
        jy0.b.d("ttlive_anchor_link_multi_pk", "multiPKLaunchDialog show");
        p21.e r24 = this.n;
        r24.getClass();
        i97.a r25 = i97.a.a;
        r24.a = Long.valueOf(System.currentTimeMillis());
        return;
    L31:
        if (r0.getModType() != PkBaseDataContext.PKModType.SeasonRank.getType()) goto L33;
        r6 = s1.B(2131921445);
        goto L34
    L26:
        if ((!StringsKt.isBlank(r6)) != true) goto L28;
    L23:
        r6 = null;
        goto L24
    L14:
        r16 = 124;
    L10:
        r14 = 0;
        goto L11
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131567004, r2);
    }
}
