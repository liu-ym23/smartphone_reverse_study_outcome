package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.PKListItemShadowView;
import com.bytedance.android.live.revlink.impl.pk.utils.w;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.e0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorTeamPkMatchingDialog;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorTeamPkMatchingDialog extends LinkCommonDialogFragment {
    public static final /* synthetic */ int i = 0;
    public Map<Integer, View> e;
    public final String f;
    public final CompositeDisposable g;
    public long h;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ MultiAnchorTeamPkMatchingDialog a;

        public b(MultiAnchorTeamPkMatchingDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r3) {
            MultiAnchorTeamPkMatchingDialog r4 = this.a;
            int r0 = MultiAnchorTeamPkMatchingDialog.i;
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

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiAnchorTeamPkMatchingDialog a;

        public c(MultiAnchorTeamPkMatchingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.W90(((Long) r4).longValue());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiAnchorTeamPkMatchingDialog a;

        public d(MultiAnchorTeamPkMatchingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.revlink.impl.multianchor.match.c r3 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r2;
            r3.getClass();
            if ((r3 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c) == true) goto L12;
            return;
        L12:
            this.a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L15;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ MultiAnchorTeamPkMatchingDialog a;

        public e(MultiAnchorTeamPkMatchingDialog r1) {
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

    static {
    }

    public final String getDegradeTag() {
        return "anchor_link_match_panel";
    }

    /* JADX WARN: Type inference failed for: r0v35, types: [android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.live.revlink.impl.pk.ui.PKListItemShadowView] */
    public final void X90() {
        long r0 = this.h;
        b0 r2 = T90();
        if (r2 == null) goto L5;
        long r3 = e0.a(r2);
    L7:
        if (r0 >= r3) goto L21;
        if (this.h <= 0) goto L21;
        if (U90().c == false) goto L16;
        if (S90(2131376728).getVisibility() == 0) goto L16;
        S90(2131376728).setVisibility(0);
        w.a(S90(2131376728), this.f);
        ((TextView) S90(2131388772)).setText(s1.B(2131921495));
    L30:
        V90();
        return;
    L16:
        if (U90().c == true) goto L30;
        if (S90(2131376728).getVisibility() == 8) goto L30;
        S90(2131376728).setVisibility(8);
        ((TextView) S90(2131388772)).setText(s1.B(2131920636));
    L21:
        if (U90().c == false) goto L26;
        if (((LinearLayout) S90(2131378887)).getVisibility() == 0) goto L26;
        ((LinearLayout) S90(2131378886)).setVisibility(8);
        ((LinearLayout) S90(2131378887)).setVisibility(0);
        ((TextView) S90(2131391114)).setVisibility(8);
        ((TextView) S90(2131388772)).setText(s1.B(2131921495));
        S90(2131376728).setVisibility(0);
        w.a(S90(2131376728), this.f);
        ?? r1 = (PKListItemShadowView) S90(2131386044);
        r1.a = -1;
        r1.k = true;
        r1.requestLayout();
        r1.invalidate();
    L26:
        if (U90().c == true) goto L30;
        if (((LinearLayout) S90(2131378886)).getVisibility() == 0) goto L30;
        ((LinearLayout) S90(2131378886)).setVisibility(0);
        ((LinearLayout) S90(2131378887)).setVisibility(8);
        ((TextView) S90(2131391114)).setVisibility(8);
        ((TextView) S90(2131388772)).setText(s1.B(2131920636));
        S90(2131376728).setVisibility(8);
        goto L30
    L5:
        r3 = 10;
        goto L7
    }

    public MultiAnchorTeamPkMatchingDialog() {
        this.e = new LinkedHashMap();
        StringBuilder r0 = new StringBuilder("https://");
        String r1 = k0.a;
        r0.append(k0.a);
        r0.append("/obj/live-android/ttlive_pk_auto_match_speed_up.webp");
        this.f = r0.toString();
        this.g = new CompositeDisposable();
    }

    public final b0 T90() {
        if ((U90() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.d) == false) goto L9;
        MultiPkMatchContext r0 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.n<b0> r1 = r0.getPassiveAutoMatchInfo();
        if (r1 != null) goto L17;
        return null;
    L17:
        return (b0) r1.getValue();
    L15:
        return null;
    L9:
        MultiPkMatchContext r2 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r2 == null) goto L18;
        com.bytedance.live.datacontext.n<b0> r3 = r2.getSelfAutoMatchInfo();
        if (r3 != null) goto L14;
        return null;
    L14:
        return (b0) r3.getValue();
    L18:
        return null;
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.match.c U90() {
        MultiPkMatchContext r0 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r1 = r0.getMatchStatus();
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r2 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r1.getValue();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c();
    }

    public final void V90() {
        if ((U90() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.d) == false) goto L15;
        ((LinearLayout) S90(2131378886)).setVisibility(8);
        ((TextView) S90(2131391114)).setVisibility(0);
        long r1 = this.h;
        b0 r3 = T90();
        if (r3 == null) goto L7;
        long r4 = e0.a(r3);
    L9:
        if (r1 < r4) goto L11;
    L13:
        ((TextView) S90(2131391114)).setText(s1.B(2131920635));
        return;
    L11:
        if (this.h <= 0) goto L13;
        ((TextView) S90(2131391114)).setText(s1.B(2131921492));
        return;
    L7:
        r4 = 10;
        goto L9
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e.clear();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        this.g.dispose();
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

    public final void W90(long r9) {
        this.h = r9;
        long r0 = 60;
        long r2 = r9 / r0;
        long r10 = r9 % r0;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        ((TextView) S90(2131390857)).setText(String.format(Locale.CHINA, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r2), Long.valueOf(r10)}, 2)));
        long r3 = this.h;
        b0 r12 = T90();
        if (r12 == null) goto L5;
        long r4 = e0.a(r12);
    L7:
        if (r3 >= r4) goto L12;
        if (this.h <= 0) goto L12;
        ((LinearLayout) S90(2131378886)).setVisibility(8);
        ((LinearLayout) S90(2131378887)).setVisibility(8);
        ((TextView) S90(2131391114)).setVisibility(0);
        ((TextView) S90(2131391114)).setText(s1.B(2131921492));
        X90();
    L22:
        V90();
        return;
    L12:
        if (this.h != 0) goto L22;
        ((TextView) S90(2131391709)).setVisibility(8);
        ((TextView) S90(2131390857)).setVisibility(8);
        ((TextView) S90(2131391711)).setVisibility(0);
        ViewGroup.LayoutParams r13 = ((LinearLayout) S90(2131378884)).getLayoutParams();
        if ((r13 instanceof LinearLayout.LayoutParams) == true) goto L16;
        r13 = null;
    L16:
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) r13;
        if (r14 == null) goto L19;
        r14.topMargin = s1.f(17.0f);
    L19:
        X90();
        if (U90().c == true) goto L22;
        ((TextView) S90(2131388772)).setText(s1.B(2131920634));
        goto L22
    L5:
        r4 = 10;
        goto L7
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnCancelListener(new b(this));
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        ((LinearLayout) S90(2131378886)).setOnClickListener(new com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.c(this));
        ((TextView) S90(2131365128)).setOnClickListener(x0.a(new MultiAnchorTeamPkMatchingDialog$initView$2(this)));
        Context r5 = getContext();
        if (r5 == null) goto L5;
        ((TextView) S90(2131390857)).setTypeface(Typeface.createFromAsset(r5.getAssets(), "fonts/clarity_mono_bold.otf"));
    L5:
        X90();
        MultiPkMatchContext r6 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r6 == null) goto L14;
        com.bytedance.live.datacontext.m<Long> r7 = r6.getCountDownTime();
        if (r7 == null) goto L14;
        Observable r8 = r7.a();
        if (r8 == null) goto L14;
        Disposable r9 = r8.subscribe(new c(this));
        if (r9 == null) goto L14;
        this.g.add(r9);
    L14:
        MultiPkMatchContext r10 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r10 == null) goto L23;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r12 = r10.getMatchStatus();
        if (r12 == null) goto L23;
        Observable r13 = r12.a();
        if (r13 == null) goto L23;
        Disposable r14 = r13.subscribe(new d(this));
        if (r14 == null) goto L23;
        this.g.add(r14);
    L23:
        S90(2131381758).setOnClickListener(new e(this));
        MultiPkMatchContext r15 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r15 == null) goto L30;
        com.bytedance.live.datacontext.m<Long> r16 = r15.getCountDownTime();
        if (r16 == null) goto L30;
        Long r17 = (Long) r16.getValue();
        if (r17 == null) goto L30;
        long r18 = r17.longValue();
    L31:
        W90(r18);
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("match_type", "team_double");
        mz0.n r20 = new mz0.n();
        Map<String, String> r0 = r20.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        Intrinsics.checkNotNullParameter(r19, "map");
        r0.putAll(r19);
        mz0.m r22 = new mz0.m();
        r22.b(LogCommon.ROOM);
        List<Object> r1 = r20.b;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(r22.a);
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("livesdk_pk_match_banner_show", r20.a, r20.b);
        return;
    L30:
        r18 = 0;
        goto L31
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565658, r3, false);
    }
}
