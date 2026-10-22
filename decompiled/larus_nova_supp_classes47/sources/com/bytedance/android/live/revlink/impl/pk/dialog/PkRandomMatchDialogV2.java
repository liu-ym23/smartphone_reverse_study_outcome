package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.utils.FixedForAppBarLayoutManager;
import com.bytedance.android.live.revlink.impl.pk.utils.w;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.c0;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import me.drakeet.multitype.MultiTypeAdapter;
import y31.v;
import y31.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/PkRandomMatchDialogV2;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lx31/l;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkRandomMatchDialogV2 extends LinkCommonDialogFragment implements x31.l, AppBarLayout.OnOffsetChangedListener {
    public static final String r = null;
    public Map<Integer, View> e;
    public ValueAnimator f;
    public final CompositeDisposable g;
    public TextView h;
    public PkItemExposeRecyclerView i;
    public MultiTypeAdapter j;
    public List<Object> k;
    public boolean l;
    public View m;
    public DataCenter n;
    public PkAutoMatchDataContext o;
    public long p;
    public final b q;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ PkRandomMatchDialogV2 a;

        public b(PkRandomMatchDialogV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Long r4 = (Long) r3;
            if (r4 == null) goto L6;
            long r0 = r4.longValue();
            this.a.Y90(r0);
            return;
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PkRandomMatchDialogV2 a;

        public c(PkRandomMatchDialogV2 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            PkRandomMatchDialogV2 r4 = this.a;
            String r0 = PkRandomMatchDialogV2.r;
            Dialog r1 = r4.getDialog();
            Context r2 = r4.getContext();
            if (r1 == null) goto L17;
            if (r2 == null) goto L21;
            Dialog r5 = r4.getDialog();
            if (r5 == null) goto L18;
            View r6 = r5.getCurrentFocus();
            if (r6 == null) goto L22;
            InputMethodManager r7 = (InputMethodManager) r2.getSystemService("input_method");
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isActive() == false) goto L20;
            r7.hideSoftInputFromWindow(r6.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ PkRandomMatchDialogV2 a;
        public final /* synthetic */ boolean b;

        public d(PkRandomMatchDialogV2 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        L21:
            return;
        L3:
            if (this.b == false) goto L12;
            View r0 = this.a.m;     // Catch: Throwable -> L14
            if (r0 == null) goto L9;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L14
            if (r1 == null) goto L9;
            r1.height = s1.f(300.0f);     // Catch: Throwable -> L14
        L9:
            View r2 = this.a.m;     // Catch: Throwable -> L14
            if (r2 == null) goto L17;
            r2.requestLayout();     // Catch: Throwable -> L14
            return;
        L17:
            return;
        L12:
            PkRandomMatchDialogV2.T90(this.a, s1.f(300.0f));     // Catch: Throwable -> L14
        }
    }

    public final String getDegradeTag() {
        return "anchor_link_match_panel";
    }

    @Override // x31.l
    public final boolean isRequesting(IRoom r1) {
        return false;
    }

    static {
        StringBuilder r0 = new StringBuilder("https://");
        String r1 = k0.a;
        r0.append(k0.a);
        r0.append("/obj/live-android/pk_random_guest_avatar.webp");
        r = r0.toString();
    }

    public final b0 U90() {
        PkAutoMatchDataContext r0 = this.o;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAutoMatchInfo();
    }

    public final boolean V90() {
        PkAutoMatchDataContext r0 = this.o;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRankRandom() != true) goto L7;
        return true;
    }

    public final boolean W90() {
        PkAutoMatchDataContext r0 = this.o;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getCurrentMatchType() != 12) goto L7;
        return true;
    }

    public PkRandomMatchDialogV2() {
        this.e = new LinkedHashMap();
        this.g = new CompositeDisposable();
        this.l = true;
        this.q = new b(this);
    }

    public final void aa0() {
        if (V90() == false) goto L9;
        TextView r0 = (TextView) S90(2131388772);
        if (r0 == null) goto L22;
        r0.setText(s1.B(2131921494));
        return;
    L22:
        return;
    L9:
        if (this.p > 0) goto L14;
        TextView r1 = (TextView) S90(2131388772);
        if (r1 == null) goto L23;
        r1.setText(s1.B(2131921498));
        return;
    L23:
        return;
    L14:
        if (W90() == false) goto L18;
        TextView r2 = (TextView) S90(2131388772);
        if (r2 == null) goto L25;
        r2.setText(s1.B(2131920581));
        return;
    L25:
        return;
    L18:
        TextView r3 = (TextView) S90(2131388772);
        if (r3 == null) goto L27;
        r3.setText(s1.B(2131921496));
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e.clear();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        CompositeDisposable r0 = this.g;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ValueAnimator r1 = this.f;
        if (r1 == null) goto L8;
        r1.removeAllUpdateListeners();
        r1.removeAllListeners();
        r1.cancel();
    L8:
        PkAutoMatchDataContext r2 = this.o;
        if (r2 == null) goto L14;
        LiveData<Long> r3 = r2.getLeftTime();
        if (r3 == null) goto L15;
        r3.removeObserver(this.q);
        return;
    L15:
        return;
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

    public final void X90(String r9) {
        HashMap r0 = new HashMap();
        long r1 = this.p;
        long r3 = 0;
        if (r1 <= 0) goto L13;
        b0 r5 = U90();
        if (r5 == null) goto L9;
        c0 r6 = r5.getConfig();
        if (r6 == null) goto L9;
        long r7 = r6.getInviteLimitSec();
    L11:
        if (r1 > r7) goto L13;
        int r2 = 0;
    L14:
        r0.put("speedup_status", String.valueOf(r2));
        b0 r4 = U90();
        if (r4 == null) goto L19;
        c0 r8 = r4.getConfig();
        if (r8 == null) goto L19;
        r3 = r8.getPkAutoMatchIndex();
    L19:
        r0.put("pk_automatch_type", String.valueOf(r3));
        r0.put("action", r9);
        mz0.n r10 = new mz0.n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r12.putAll(r0);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.ROOM);
        List<Object> r14 = r10.b;
        ArrayList r15 = (ArrayList) r14;
        r15.addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_pk_match_banner_click", r10.a, r10.b);
        return;
    L9:
        r7 = 10;
    L13:
        r2 = 1;
        goto L14
    }

    public final void Y90(long r12) {
        this.p = r12;
        long r0 = 60;
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        String r1 = String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r12 / r0), Long.valueOf(r12 % r0)}, 2));
        ((TextView) S90(2131390857)).setText(r1);
        ((TextView) S90(2131391640)).setText(r1);
        if (this.p != 0) goto L5;
        ((TextView) S90(2131391640)).setVisibility(8);
        ((TextView) S90(2131391709)).setVisibility(8);
        ((TextView) S90(2131390857)).setVisibility(8);
        ((TextView) S90(2131391714)).setVisibility(0);
    L5:
        aa0();
        if (V90() == false) goto L8;
        ((TextView) S90(2131391114)).setText(s1.B(2131921493));
    L24:
        if (r12 > 0) goto L40;
        if (this.l == true) goto L28;
        return;
    L28:
        this.l = false;
        View r13 = S90(2131383631);
        if (r13 == null) goto L31;
        r13.setVisibility(0);
    L31:
        View r14 = S90(2131383622);
        if (r14 == null) goto L34;
        r14.setVisibility(8);
    L34:
        w.a(S90(2131383626), r);
        IBaseUser r15 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        ImageView r16 = (ImageView) S90(2131383620);
        if (r15 == null) goto L37;
        py.k r17 = r15.getAvatarThumbKt();
    L38:
        ImageUtil.loadRoundImage(r16, r17);
        return;
    L37:
        r17 = null;
        goto L38
    L40:
        if (this.l == false) goto L42;
        return;
    L42:
        this.l = true;
        View r18 = S90(2131383631);
        if (r18 == null) goto L45;
        r18.setVisibility(8);
    L45:
        View r19 = S90(2131383622);
        if (r19 == null) goto L50;
        r19.setVisibility(0);
        return;
    L50:
        return;
    L8:
        long r5 = this.p;
        b0 r2 = U90();
        if (r2 == null) goto L13;
        c0 r3 = r2.getConfig();
        if (r3 == null) goto L13;
        long r9 = r3.getInviteLimitSec();
    L15:
        if (r5 < r9) goto L17;
    L22:
        ((TextView) S90(2131391114)).setText(s1.B(2131921485));
        goto L24
    L17:
        if (this.p <= 0) goto L22;
        if (W90() == false) goto L21;
        ((TextView) S90(2131391114)).setText(s1.B(2131921483));
        goto L24
    L21:
        ((TextView) S90(2131391114)).setText(s1.B(2131921492));
    L13:
        r9 = 10;
        goto L15
    }

    @Override // x31.l
    public final void onCancel(IRoom r2) {
        PkAutoMatchDataContext r3 = this.o;
        if (r3 == null) goto L6;
        r3.cancelInvite(null);
        return;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new c(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public static final void T90(PkRandomMatchDialogV2 r3, int r4) {
        ValueAnimator r0 = r3.f;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
        r0.removeAllListeners();
        r0.cancel();
    L5:
        float r1 = 484.0f;
        if (r4 != s1.f(484.0f)) goto L8;
        r1 = 300.0f;
    L8:
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{s1.f(r1), r4});
        r3.f = r5;
        if (r5 == null) goto L11;
        r5.addUpdateListener(new n(r3));
    L11:
        ValueAnimator r6 = r3.f;
        if (r6 == null) goto L17;
        ValueAnimator r7 = r6.setDuration(80);
        if (r7 == null) goto L18;
        r7.start();
        return;
    L18:
        return;
    }

    public final void Z90(y31.k r4, boolean r5) {
        ArrayList r0 = new ArrayList();
        y.a r1 = new y.a();
        r1.a = s1.B(2131921490);
        r0.add(r1);
        if (r4 == null) goto L5;
        r0.add(r4);
    L5:
        MultiTypeAdapter r6 = this.j;
        if (r6 == null) goto L8;
        r6.a = r0;
    L8:
        View r7 = this.m;
        if (r7 == null) goto L11;
        r7.post(new d(this, r5));
    L11:
        MultiTypeAdapter r8 = this.j;
        if (r8 == null) goto L14;
        r8.notifyDataSetChanged();
    L14:
        S90(2131363087).setExpanded(true);
        PkItemExposeRecyclerView r9 = this.i;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L17:
        r9.scrollToPosition(0);
        final Context r2 = getContext();
        LinearLayoutManager r10 = new PkRandomMatchDialogV2$updateListByInvitingUser$mLinearLayoutManager$1(r2);
        PkItemExposeRecyclerView r3 = this.i;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L20:
        r3.setLayoutManager(r10);
    }

    public final void onOffsetChanged(AppBarLayout r8, int r9) {
        if (r8 == null) goto L5;
        int r10 = r8.getTotalScrollRange();
    L7:
        if (Math.abs(r9 / r10) == 1.0f) goto L9;
    L24:
        aa0();
        TextView r12 = (TextView) S90(2131391640);
        if (r12 == null) goto L32;
        r12.setVisibility(8);
        return;
    L32:
        return;
    L9:
        if (V90() == true) goto L24;
        if (this.p != 0) goto L18;
        TextView r13 = (TextView) S90(2131391640);
        if (r13 == null) goto L15;
        r13.setVisibility(8);
    L15:
        TextView r14 = (TextView) S90(2131388772);
        if (r14 == null) goto L28;
        r14.setText(s1.B(2131921501));
        return;
    L28:
        return;
    L18:
        TextView r15 = (TextView) S90(2131391640);
        if (r15 == null) goto L21;
        r15.setVisibility(0);
    L21:
        TextView r16 = (TextView) S90(2131388772);
        if (r16 == null) goto L30;
        r16.setText(s1.B(2131921497));
        return;
    L30:
        return;
    L5:
        r10 = 0;
        goto L7
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        aa0();
        S90(2131363087).addOnOffsetChangedListener(this);
        PkItemExposeRecyclerView r14 = this.i;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L5:
        r14.setInviteIconPanelType("random_trans_invite");
        PkItemExposeRecyclerView r15 = this.i;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L8:
        r15.setLayoutManager(new FixedForAppBarLayoutManager(getContext()));
        MultiTypeAdapter r16 = new MultiTypeAdapter();
        this.j = r16;
        r16.z2(y.a.class, new y());
        DataCenter r5 = this.n;
        if (r5 == null) goto L13;
        MultiTypeAdapter r17 = this.j;
        if (r17 == null) goto L13;
        r17.z2(y31.k.class, new y31.j(null, this, r5, V90(), 24));
    L13:
        MultiTypeAdapter r18 = this.j;
        if (r18 == null) goto L16;
        r18.z2(v.a.class, new v());
    L16:
        PkItemExposeRecyclerView r19 = this.i;
        if (r19 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L19:
        r19.setAdapter(this.j);
        TextView r110 = this.h;
        if (r110 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mQuit");
    L22:
        r110.setOnClickListener(new i(this));
        Context r111 = getContext();
        if (r111 == null) goto L25;
        ((TextView) S90(2131390857)).setTypeface(Typeface.createFromAsset(r111.getAssets(), "fonts/clarity_mono_bold.otf"));
        ((TextView) S90(2131391640)).setTypeface(Typeface.createFromAsset(r111.getAssets(), "fonts/clarity_mono_bold.otf"));
    L25:
        PkAutoMatchDataContext r112 = this.o;
        long r0 = 0;
        if (r112 == null) goto L31;
        LiveData<Long> r113 = r112.getLeftTime();
        if (r113 == null) goto L31;
        Long r114 = (Long) r113.getValue();
        if (r114 == null) goto L31;
    L32:
        Y90(r114.longValue());
        int r2 = 0;
        if (W90() == false) goto L38;
        RecyclerView r115 = this.i;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L37:
        r115.setVisibility(8);
        a1.k(S90(2131367103), UtilityKotlinExtentionsKt.i(123));
    L75:
        PkAutoMatchDataContext r116 = this.o;
        if (r116 == null) goto L80;
        LiveData<Long> r117 = r116.getLeftTime();
        if (r117 == null) goto L80;
        r117.observeForever(this.q);
    L80:
        HashMap r118 = new HashMap();
        long r4 = this.p;
        if (r4 <= 0) goto L91;
        b0 r119 = U90();
        if (r119 == null) goto L87;
        c0 r120 = r119.getConfig();
        if (r120 == null) goto L87;
        long r6 = r120.getInviteLimitSec();
    L89:
        if (r4 > r6) goto L91;
    L92:
        r118.put("speedup_status", String.valueOf(r2));
        r118.put("match_type", "single");
        b0 r121 = U90();
        if (r121 == null) goto L97;
        c0 r122 = r121.getConfig();
        if (r122 == null) goto L97;
        r0 = r122.getPkAutoMatchIndex();
    L97:
        r118.put("pk_automatch_type", String.valueOf(r0));
        mz0.n r123 = new mz0.n();
        Map<String, String> r1 = r123.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r118, "map");
        r1.putAll(r118);
        mz0.m r124 = new mz0.m();
        r124.b(LogCommon.ROOM);
        ((ArrayList) r123.b).addAll(r124.a);
        cy0.e.a.getClass();
        cy0.j r125 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r126 = com.bytedance.android.scope.m.b(r125).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r126);
        ((mz0.i) ((f80.a) r126)).w3("livesdk_pk_match_banner_show", r123.a, r123.b);
        return;
    L87:
        r6 = 10;
    L91:
        r2 = 1;
        goto L92
    L38:
        a1.k(S90(2131367103), UtilityKotlinExtentionsKt.i(420));
        RecyclerView r127 = this.i;
        if (r127 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L41:
        r127.setVisibility(0);
        if (V90() == false) goto L44;
        int r7 = 6;
    L45:
        PkAutoMatchDataContext r128 = this.o;
        y31.k r129 = null;
        if (r128 == null) goto L50;
        NextLiveData<y31.k> r130 = r128.getMInvitingUserData();
        if (r130 == null) goto L50;
        y31.k r131 = (y31.k) r130.getValue();
    L51:
        if (r131 != null) goto L64;
        r31.a r8 = r31.b.a(r31.a.a);
        PkAutoMatchDataContext r132 = this.o;
        if (r132 == null) goto L56;
        String r133 = r132.getMActivityName();
        if (r133 == null) goto L56;
    L57:
        Observable r134 = r8.c(r7, true, 0, r133, 0, IRivalRankRecommendResponse.LoadType.All.ordinal());
        if (r134 == null) goto L70;
        Observable r135 = r134.compose(RxUtil.rxSchedulerHelper());
        if (r135 == null) goto L70;
        Disposable r136 = r135.subscribe(new j(this), k.a);
        if (r136 == null) goto L70;
        this.g.add(r136);
    L70:
        PkAutoMatchDataContext r137 = this.o;
        if (r137 == null) goto L75;
        NextLiveData<y31.k> r138 = r137.getMInvitingUserData();
        if (r138 == null) goto L75;
        r138.observe(this, new m(this));
    L56:
        r133 = "";
        goto L57
    L64:
        PkAutoMatchDataContext r139 = this.o;
        if (r139 == null) goto L69;
        NextLiveData<y31.k> r140 = r139.getMInvitingUserData();
        if (r140 == null) goto L69;
        r129 = (y31.k) r140.getValue();
    L69:
        Z90(r129, true);
    L50:
        r131 = null;
        goto L51
    L44:
        r7 = 2;
    L31:
        r114 = 0L;
        goto L32
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565700, r3, false);
        this.m = r5;
        if (r5 == null) goto L6;
        TextView r6 = (TextView) r5.findViewById(2131388772);
        this.h = (TextView) r5.findViewById(2131383571);
        this.i = (PkItemExposeRecyclerView) r5.findViewById(2131384076);
    L6:
        return this.m;
    }

    @Override // x31.l
    public final void onInvite(IRoom r12, int r13, IRivalExtraInfo r14, int r15, m2 r16, List r17, int r18, int r19, String r110, HashMap r20, Boolean r22) {
        r22.booleanValue();
        Intrinsics.checkNotNullParameter(r20, "logMap");
        X90("invite_recommend");
        long r1 = 10;
        long r5 = this.p;
        if (1 <= r5) goto L6;
    L8:
        PkAutoMatchDataContext r2 = this.o;
        String r3 = null;
        if (r2 == null) goto L13;
        NextLiveData<y31.k> r4 = r2.getMInvitingUserData();
        if (r4 == null) goto L13;
        y31.k r6 = (y31.k) r4.getValue();
    L14:
        if (r6 != null) goto L39;
        com.bytedance.android.live.revlink.impl.pk.utils.j r7 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r7 == null) goto L40;
        IBaseUser r8 = r12.getOwner();
        if (r8 == null) goto L20;
        String r9 = iz.a.a(r8);
    L22:
        if (r7.c(r13, r9, 0) != true) goto L44;
        com.bytedance.android.live.revlink.impl.pk.utils.j r10 = com.bytedance.android.live.revlink.impl.global.b.O();
        if (r10 == null) goto L41;
        IBaseUser r23 = r12.getOwner();
        if (r23 == null) goto L30;
        r3 = iz.a.a(r23);
    L30:
        if (r10.a(r3, r13) != true) goto L45;
        List<Object> r24 = this.k;
        if (r24 == null) goto L42;
        PkAutoMatchDataContext r25 = this.o;
        if (r25 == null) goto L43;
        r25.inviteWhenMatching(r12, V90(), r13, r16, r15, r24, r110);
        return;
    L43:
        return;
    L42:
        return;
    L45:
        return;
    L41:
        return;
    L44:
        return;
    L20:
        r9 = null;
        goto L22
    L40:
        return;
    L39:
        return;
    L13:
        r6 = null;
        goto L14
    L6:
        if (r1 < r5) goto L8;
        ToastUtil.a(2131921489, 0);
        mz0.n r26 = new mz0.n();
        mz0.m r27 = new mz0.m();
        r27.b(LogCommon.ROOM);
        ((ArrayList) r26.b).addAll(r27.a);
        cy0.e.a.getClass();
        cy0.j r28 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r29 = com.bytedance.android.scope.m.b(r28).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r29);
        ((mz0.i) ((f80.a) r29)).w3("livesdk_pk_unable_invite_toast_show", r26.a, r26.b);
    }
}
