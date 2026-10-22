package com.bytedance.android.live.ktv.common.tuningpanel.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view.TuningMusicControlContainer;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/view/TuningPanelDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningPanelDialog extends DialogFragment {
    public static final /* synthetic */ int m = 0;
    public View d;
    public View e;
    public LinearLayout f;
    public FrameLayout g;
    public View h;
    public FrameLayout i;
    public FrameLayout j;
    public long k;
    public final ac0.b l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnShowListener {
        public final /* synthetic */ TuningPanelDialog a;

        public b(TuningPanelDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r2) {
            int[] r3 = new int[2];
            LinearLayout r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.getLocationOnScreen(r3);
        L5:
            zb0.a r1 = this.a.l.e;
            if (r1 == null) goto L9;
            r1.e(r3);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ TuningPanelDialog a;

        public c(TuningPanelDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L12;
            return;
        L12:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L15;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ TuningPanelDialog a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            LinearLayout r0 = this.a.f;
            if (r0 == null) goto L7;
            ViewTreeObserver r1 = r0.getViewTreeObserver();
            if (r1 == null) goto L7;
            r1.removeOnGlobalLayoutListener(this);
        L7:
            TuningPanelDialog r2 = this.a;
            zb0.a r3 = r2.l.e;
            if (r3 == null) goto L10;
            r3.b(r2.k);
        L11:
            this.a.k = 0;
            return;
        L10:
            mb0.c r4 = mb0.d.a;
            mb0.d.f("adjust_music", System.currentTimeMillis() - this.a.k);
            goto L11
        }

        public d(TuningPanelDialog r1) {
            this.a = r1;
        }
    }

    static {
    }

    public TuningPanelDialog() {
        this(new ac0.b(false, null, null, null, null, null, null, null, null, false, 14335));
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        zb0.a r0 = this.l.e;
        if (r0 == null) goto L5;
        r0.clearData();
    L5:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = this.l.k;
        if (r1 == null) goto L8;
        r1.o();
    L8:
        ec0.a r2 = this.l.l;
        if (r2 == null) goto L12;
        r2.clearData();
        return;
    }

    public final void onStop() {
        super.onStop();
        zb0.a r0 = this.l.e;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public TuningPanelDialog(ac0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.l = r2;
    }

    public final void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        Dialog r7 = getDialog();
        if (r7 == null) goto L18;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L18;
        if (PadConfigUtils.c() == false) goto L9;
    L12:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L16;
        int r2 = Math.min(Math.min(s1.y(), s1.w()), s1.f(384.0f));
    L17:
        r8.setLayout(r2, -1);
        goto L18
    L16:
        r2 = -1;
        goto L17
    L9:
        if (FoldScreenUtils.f() == true) goto L12;
        r1 = false;
    L18:
        Dialog r9 = getDialog();
        if (r9 == null) goto L29;
        Window r11 = r9.getWindow();
        if (r11 == null) goto L30;
        View r3 = r11.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L27;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L27;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L27:
        r3.setPadding(0, 0, 0, 0);
        r11.setGravity(85);
        r11.setBackgroundDrawable(new ColorDrawable(0));
        r11.setSoftInputMode(48);
        return;
    L30:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        this.k = System.currentTimeMillis();
        setStyle(1, 2131954719);
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L5;
        r6.setOnShowListener(new b(this));
    L5:
        zb0.a r7 = this.l.e;
        if (r7 == null) goto L9;
        r7.a(this, new c(this));
    L9:
        if (this.k == 0) goto L16;
        LinearLayout r8 = this.f;
        if (r8 == null) goto L17;
        ViewTreeObserver r9 = r8.getViewTreeObserver();
        if (r9 == null) goto L18;
        r9.addOnGlobalLayoutListener(new d(this));
        return;
    L18:
        return;
    L17:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566540, r3, false);
        this.d = r5;
        if (this.l.m == false) goto L8;
        if (r5 == null) goto L8;
        TextView r6 = (TextView) r5.findViewById(2131388367);
        if (r6 == null) goto L8;
        r6.setTextSize(16.0f);
    L8:
        View r7 = this.d;
        FrameLayout r8 = null;
        if (r7 == null) goto L11;
        View r9 = r7.findViewById(2131381758);
    L12:
        this.e = r9;
        View r11 = this.d;
        if (r11 == null) goto L15;
        LinearLayout r12 = (LinearLayout) r11.findViewById(2131367773);
    L16:
        this.f = r12;
        if (r12 == null) goto L19;
        KtvOrderSongThemeManager.c(r12, IQRCodeService.CAMERA_PERMISSION_REQ_CODE);
    L19:
        View r13 = this.d;
        if (r13 == null) goto L22;
        FrameLayout r14 = (FrameLayout) r13.findViewById(2131388798);
    L23:
        this.g = r14;
        View r15 = this.d;
        if (r15 == null) goto L26;
        View r16 = r15.findViewById(2131370352);
    L27:
        this.h = r16;
        View r17 = this.d;
        if (r17 == null) goto L30;
        FrameLayout r18 = (FrameLayout) r17.findViewById(2131362283);
    L31:
        this.i = r18;
        View r19 = this.d;
        if (r19 == null) goto L34;
        r8 = (FrameLayout) r19.findViewById(2131362286);
    L34:
        this.j = r8;
        FrameLayout r21 = this.i;
        if (getContext() == null) goto L42;
        if (r21 == null) goto L39;
        r21.removeAllViews();
    L39:
        if (r21 == null) goto L42;
        r21.addView(new com.bytedance.android.live.ktv.common.tuningpanel.view.a(this.l, requireContext()));
    L42:
        if (this.l.a == false) goto L50;
        FrameLayout r22 = this.j;
        if (getContext() == null) goto L50;
        if (r22 == null) goto L48;
        r22.removeAllViews();
    L48:
        if (r22 == null) goto L50;
        r22.addView(new TuningMusicControlContainer(this.l, requireContext()));
    L50:
        View r23 = this.e;
        if (r23 == null) goto L54;
        r23.setOnClickListener(x0.a(new AnonymousClass1(this)));
    L54:
        return this.d;
    L30:
        r18 = null;
        goto L31
    L26:
        r16 = null;
        goto L27
    L22:
        r14 = null;
        goto L23
    L15:
        r12 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    }
}
