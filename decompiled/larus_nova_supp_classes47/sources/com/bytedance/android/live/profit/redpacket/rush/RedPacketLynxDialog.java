package com.bytedance.android.live.profit.redpacket.rush;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.util.JavaCalls;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;
import zy0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/rush/RedPacketLynxDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RedPacketLynxDialog extends DialogFragment {
    public boolean d;
    public b e;
    public Function0<Unit> f;
    public Function0<Unit> g;

    public final void S90() {
        if (this.e != null) goto L5;
        return;
    L5:
        if (getContext() == null) goto L22;
        View r0 = getView();
        View r2 = null;
        if ((r0 instanceof ViewGroup) == true) goto L9;
        r0 = null;
    L9:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L12;
        r1.removeAllViews();
    L12:
        if (r1 == null) goto L17;
        b r3 = this.e;
        if (r3 == null) goto L16;
        r2 = r3.c();
    L16:
        r1.addView(r2);
    L17:
        Function0<Unit> r4 = this.g;
        if (r4 == null) goto L23;
        Unit r5 = (Unit) r4.invoke();
        return;
    L23:
        return;
    }

    public final boolean isShowing() {
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() != true) goto L7;
        return true;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Function0<Unit> r0 = this.f;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke();
    L5:
        this.d = false;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        View r0 = getView();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L9;
        r1.removeAllViews();
        return;
    }

    public RedPacketLynxDialog() {
    }

    public final void onActivityCreated(Bundle r4) {
        super.onActivityCreated(r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L9;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L9;
        WindowManager.LayoutParams r7 = r6.getAttributes();
        if (r7 == null) goto L9;
        r7.width = s1.y();
    L9:
        Dialog r8 = getDialog();
        if (r8 == null) goto L16;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L16;
        WindowManager.LayoutParams r10 = r9.getAttributes();
        if (r10 == null) goto L16;
        r10.height = (int) (s1.w() * 0.7f);
    L16:
        Dialog r12 = getDialog();
        if (r12 == null) goto L23;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L23;
        WindowManager.LayoutParams r14 = r13.getAttributes();
        if (r14 == null) goto L23;
        r14.windowAnimations = 2131954081;
    L23:
        View r15 = getView();
        if (r15 == null) goto L41;
        Dialog r0 = getDialog();
        if (r0 == null) goto L28;
        Window r1 = r0.getWindow();
    L29:
        k r2 = (k) f.d(j.C0.a(), k.class);
        if (r2 == null) goto L41;
        if (r2.isPortraitInteraction() == true) goto L41;
        r15.setScaleX(0.8f);
        r15.setScaleY(0.8f);
        if (r1 == null) goto L36;
        r1.setLayout((int) (s1.w() * 0.8f), -2);
    L36:
        if (r1 == null) goto L41;
        WindowManager.LayoutParams r16 = r1.getAttributes();
        if (r16 == null) goto L41;
        r16.gravity = 5;
        goto L41
    L28:
        r1 = null;
    L41:
        if (PadConfigUtils.a() == false) goto L57;
        Dialog r17 = getDialog();
        if (r17 == null) goto L49;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L49;
        WindowManager.LayoutParams r19 = r18.getAttributes();
        if (r19 == null) goto L49;
        r19.width = s1.f(375.0f);
    L49:
        Dialog r20 = getDialog();
        if (r20 == null) goto L57;
        Window r22 = r20.getWindow();
        if (r22 == null) goto L57;
        WindowManager.LayoutParams r23 = r22.getAttributes();
        if (r23 == null) goto L57;
        r23.gravity = 85;
    L57:
        if (FoldScreenUtils.e() == false) goto L80;
        Dialog r24 = getDialog();
        if (r24 == null) goto L65;
        Window r25 = r24.getWindow();
        if (r25 == null) goto L65;
        WindowManager.LayoutParams r26 = r25.getAttributes();
        if (r26 == null) goto L65;
        r26.width = s1.f(375.0f);
    L65:
        Dialog r27 = getDialog();
        if (r27 == null) goto L72;
        Window r28 = r27.getWindow();
        if (r28 == null) goto L72;
        WindowManager.LayoutParams r29 = r28.getAttributes();
        if (r29 == null) goto L72;
        r29.height = s1.f(568.0f);
    L72:
        Dialog r30 = getDialog();
        if (r30 == null) goto L81;
        Window r32 = r30.getWindow();
        if (r32 == null) goto L82;
        WindowManager.LayoutParams r33 = r32.getAttributes();
        if (r33 == null) goto L83;
        r33.gravity = 17;
        return;
    L83:
        return;
    L82:
        return;
    L81:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954779);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        if (this.e != null) goto L5;
        return;
    L5:
        if (this.d == false) goto L9;
        S90();
        return;
    }

    public final void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        if (isAdded() == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.f.d().a();
        JavaCalls.setField(this, "mDismissed", Boolean.FALSE);
        JavaCalls.setField(this, "mShownByMe", Boolean.TRUE);
        FragmentTransaction r5 = r3.beginTransaction();
        if (r5 != null) goto L9;
        return;
    L9:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == true) goto L12;
        r5.add(this, r4);
    L12:
        r5.commitNowAllowingStateLoss();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567283, r3, false);
    }

    public final void T90(FragmentManager r3, b r4, Function0 r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        Intrinsics.checkNotNullParameter("RedPacketHybridService", "tag");
        Intrinsics.checkNotNullParameter(r5, "onDismissListener");
        Intrinsics.checkNotNullParameter(r6, "afterAddView");
        if (isAdded() == false) goto L5;
        return;
    L5:
        this.d = true;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        S90();
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "RedPacketHybridService", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r7) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        showNow(r3, "RedPacketHybridService");
        return;
    }
}
