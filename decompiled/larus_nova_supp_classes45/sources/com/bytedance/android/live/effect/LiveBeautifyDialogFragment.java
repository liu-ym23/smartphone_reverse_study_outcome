package com.bytedance.android.live.effect;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/LiveBeautifyDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautifyDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> d;
    public final LiveEffectContextFactoryDelegate$Type e;
    public final Lazy f;
    public final String g;
    public boolean h;
    public final b i;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveBeautifyDialogFragment a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
            LoadingStatusView r0 = this.a.S90(2131387318);
            if (r0 == null) goto L5;
            r0.reset();
        L5:
            View r1 = this.a.S90(2131386044);
            if (r1 == null) goto L9;
            r1.performClick();
            return;
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            TextView r0 = (TextView) this.a.S90(2131390218);
            if (r0 == null) goto L5;
            r0.setText((CharSequence) m90.b.F.c(this.a.e).second);
        L5:
            LoadingStatusView r1 = this.a.S90(2131387318);
            if (r1 == null) goto L9;
            r1.showLoading();
            return;
        }

        public b(LiveBeautifyDialogFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    static {
    }

    public LiveBeautifyDialogFragment() {
        this.d = new LinkedHashMap();
        this.e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f = LazyKt.lazy(new LiveBeautifyDialogFragment$beautyModeManager$2(this));
        this.g = "";
        this.h = LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().a();
        LiveEffectSettings.LIVE_ANCHOR_BEAUTY_PANEL_UI_OPT.getValue().booleanValue();
        this.i = new b(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L7;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L7;
        r4.setLayout(-1, -1);
    L7:
        Dialog r5 = getDialog();
        if (r5 == null) goto L12;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L12;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r6.addFlags(Integer.MIN_VALUE);
    L12:
        Dialog r7 = getDialog();
        if (r7 == null) goto L18;
        Window r8 = r7.getWindow();
        if (r8 == null) goto L18;
        r8.setStatusBarColor(0);
    L18:
        if (this.h == false) goto L24;
        Dialog r9 = getDialog();
        if (r9 == null) goto L24;
        Window r11 = r9.getWindow();
        if (r11 == null) goto L24;
        r11.setNavigationBarColor(-16777216);
    L24:
        Dialog r12 = getDialog();
        if (r12 == null) goto L30;
        View r13 = r12.findViewById(2131389843);
        if (r13 == null) goto L31;
        r13.setVisibility(8);
        return;
    L31:
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (this.e != LiveEffectContextFactoryDelegate$Type.DEFAULT) goto L5;
        boolean r4 = true;
    L6:
        this.h = r4;
        setStyle(1, 2131954665);
        setCancelable(true);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super.onCreateDialog(r4);
        if (r5 == null) goto L5;
        r5.setCanceledOnTouchOutside(true);
    L5:
        r5.requestWindowFeature(1);
        Window r0 = r5.getWindow();
        if (r0 == null) goto L8;
        r0.setGravity(80);
        r0.setLayout(-1, -1);
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.setSoftInputMode(3);
    L8:
        return r5;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        Dialog r7 = getDialog();
        boolean r8 = true;
        if (r7 == null) goto L8;
        View r9 = r7.findViewById(2131369151);
        if (r9 == null) goto L8;
        r9.setFocusable(true);
        r9.setImportantForAccessibility(1);
        r9.setOnClickListener(new d(r9, this));
    L8:
        if (((com.bytedance.android.live.effect.sticker.presenter.n) this.f.getValue()).c() == true) goto L10;
    L12:
        r8 = false;
    L13:
        if (r8 == false) goto L36;
        ConstraintLayout r11 = S90(2131378622);
        if (r11 == null) goto L18;
        r11.postDelayed(new e(this), 500);
    L18:
        if (((com.bytedance.android.live.effect.sticker.presenter.n) this.f.getValue()).e() == false) goto L20;
        f2.c(((com.bytedance.android.live.effect.sticker.presenter.n) this.f.getValue()).g() + "测试已结束", 0);
    L20:
        com.bytedance.android.live.effect.sticker.presenter.n.b.a((com.bytedance.android.live.effect.sticker.presenter.n) this.f.getValue(), this.i);
        TextView r12 = (TextView) S90(2131390218);
        if (r12 == null) goto L23;
        r12.setText((CharSequence) m90.b.F.c(this.e).second);
    L23:
        ConstraintLayout r13 = S90(2131378622);
        if (r13 == null) goto L26;
        r13.setOnClickListener(new f(this));
    L26:
        View r14 = S90(2131386044);
        if (r14 == null) goto L29;
        r14.setOnClickListener(new g(this));
    L29:
        Context r15 = getContext();
        if (r15 == null) goto L32;
        FrameLayout r16 = new LiveDoubleColorBallAnimationView(r15);
        int r17 = r16.getResources().getDimensionPixelSize(2131168603);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r17, r17);
        r0.gravity = 17;
        r16.setLayoutParams(r0);
    L33:
        LoadingStatusView r18 = S90(2131387318);
        if (r18 == null) goto L36;
        r18.setBuilder(LoadingStatusView.Builder.createDefaultBuilder(r18.getContext()).setLoadingView(r16));
        goto L36
    L32:
        r16 = null;
    L36:
        setBottomSheetSlideProcessor(c.a);
        return;
    L10:
        if (Intrinsics.areEqual(this.g, "live_take_page") == false) goto L12;
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565854, r3, false);
    }
}
