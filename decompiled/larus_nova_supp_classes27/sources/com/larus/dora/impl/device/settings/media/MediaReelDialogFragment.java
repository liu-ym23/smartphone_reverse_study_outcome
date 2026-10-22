package com.larus.dora.impl.device.settings.media;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.dora.impl.databinding.LarusDoraGEnvObserveTimerDialogBinding;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.ReelPicker$HeightMode;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.views.ReelPickerThreeReels;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.views.WheelView;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J.\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0011J\u0010\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u0007J*\u0010&\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010(2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\"\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020\fH\u0002J\u001a\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\b\b\u0002\u0010-\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/dora/impl/device/settings/media/MediaReelDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGEnvObserveTimerDialogBinding;", "mTitleTxt", "", "mTipTxt", "mEntries", "", "mSelectedIndex", "", "mReelSelectedIndex", "mPicker", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/ReelPicker;", "mReelChangedListener", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/ReelPicker$ReelChangedListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "getTheme", "onViewCreated", "view", "setData", "title", "entries", "selectedIndex", "reelChangedListener", "setTips", "tips", "buildPicker", "context", "Landroid/content/Context;", "onDestroyView", "resolveSelectedIndex", "normalizeSelectedIndex", "index", "entryCount", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaReelDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDoraGEnvObserveTimerDialogBinding d;
    public String e;
    public String f;
    public List<String> g;
    public int h;
    public int i;
    public ReelPickerThreeReels j;
    public t49.c k;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951934;
    }

    public MediaReelDialogFragment() {
        this.e = "";
        this.f = "";
        this.g = CollectionsKt.emptyList();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.j = null;
        this.d = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        BottomSheetBehavior.from(r0.findViewById(2131368870)).setHideable(false);
        r0.findViewById(2131389274).setOnClickListener(new c(this));
        return;
    }

    public static void S90(MediaReelDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r9v14, types: [android.widget.LinearLayout] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        BottomSheetDialog r10 = getDialog();
        ?? r0 = 0;
        if ((r10 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r11 = r10;
    L6:
        if (r11 == null) goto L8;
        View r12 = r11.findViewById(2131368870);
    L9:
        int r13 = m0.a;
        int r14 = m0.a(getContext());
        i0.a.getClass();
        int r15 = ((r14 - i0.g()) - i0.e()) - i5.c0();
        if (r12 == null) goto L12;
        r12.setLayoutParams(r12.getLayoutParams());
        BottomSheetBehavior r2 = BottomSheetBehavior.from(r12);
        r12.setBackgroundResource(R.color.transparent);
        r2.setState(3);
        r2.setPeekHeight(r15);
    L12:
        LarusDoraGEnvObserveTimerDialogBinding r16 = this.d;
        if (r16 == null) goto L18;
        AppCompatTextView r17 = r16.e;
        if (r17 == null) goto L18;
        r17.setText(this.e);
    L18:
        if (this.f.length() != 0) goto L20;
        boolean r18 = true;
    L21:
        if (r18 == false) goto L27;
        LarusDoraGEnvObserveTimerDialogBinding r20 = this.d;
        if (r20 == null) goto L37;
        AppCompatTextView r21 = r20.d;
        if (r21 == null) goto L37;
        e1.o(r21);
    L37:
        int r22 = this.h;
        int r3 = this.g.size();
        if (r3 > 0) goto L40;
        int r23 = 0;
    L41:
        this.i = r23;
        Context r4 = getContext();
        final List<String> r5 = this.g;
        if (r4 != null) goto L45;
        ReelPickerThreeReels r1 = null;
    L56:
        this.j = r1;
        if (r1 == null) goto L61;
        WheelView r6 = r1.V5();
        if (r6 == null) goto L61;
        r6.setCyclic(false);
    L61:
        if (r1 == null) goto L65;
        WheelView r7 = r1.V5();
        if (r7 == null) goto L65;
        r7.b(r23, false);
    L65:
        LarusDoraGEnvObserveTimerDialogBinding r24 = this.d;
        if (r24 == null) goto L72;
        ?? r25 = r24.f;
        if (r25 == 0) goto L72;
        if (r1 == null) goto L71;
        r0 = r1;
    L71:
        r25.addView(r0);
    L72:
        g49.d.d("MediaReelDialogFragment", "dialog shown: title=" + this.e + ", entries=" + this.g.size() + ", initialSelectedIndex=" + r23);
        LarusDoraGEnvObserveTimerDialogBinding r26 = this.d;
        if (r26 == null) goto L77;
        AppCompatTextView r27 = r26.b;
        if (r27 == null) goto L77;
        r27.setOnClickListener(new d(this));
    L77:
        LarusDoraGEnvObserveTimerDialogBinding r28 = this.d;
        if (r28 == null) goto L83;
        AppCompatTextView r30 = r28.c;
        if (r30 == null) goto L84;
        r30.setOnClickListener(new e(this));
        return;
    L84:
        return;
    L83:
        return;
    L45:
        if (r5.isEmpty() == false) goto L47;
    L53:
        float r31 = 112;
        Resources r32 = Resources.getSystem();
        DisplayMetrics r33 = WindowDisplayMetricsOverride.apply(r32, r32.getDisplayMetrics());
    L54:
        int r34 = MathKt.roundToInt(TypedValue.applyDimension(1, r31, r33));
    L55:
        ReelPickerThreeReels.a r35 = new ReelPickerThreeReels.a(r34);
        r35.a(new t49.b(1, r5, r23, new f(this, r5)));
        r1 = r35.b(r4, null, 0);
        goto L56
    L47:
        if (r5.size() < 3) goto L53;
        if (r5.size() >= 4) goto L52;
        r31 = 152;
        Resources r36 = Resources.getSystem();
        r33 = WindowDisplayMetricsOverride.apply(r36, r36.getDisplayMetrics());
        goto L54
    L52:
        r34 = ReelPicker$HeightMode.FIVE_LINES.getHeightInDp();
        goto L55
    L40:
        r23 = RangesKt.coerceIn(r22, 0, r3 - 1);
        goto L41
    L27:
        LarusDoraGEnvObserveTimerDialogBinding r37 = this.d;
        if (r37 == null) goto L32;
        AppCompatTextView r38 = r37.d;
        if (r38 == null) goto L32;
        r38.setText(this.f);
    L32:
        LarusDoraGEnvObserveTimerDialogBinding r40 = this.d;
        if (r40 == null) goto L37;
        AppCompatTextView r41 = r40.d;
        if (r41 == null) goto L37;
        e1.x(r41);
        goto L37
    L20:
        r18 = false;
        goto L21
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraGEnvObserveTimerDialogBinding r4 = LarusDoraGEnvObserveTimerDialogBinding.a(r1, r2);
        this.d = r4;
        return r4.a;
    }

    public final void T90(String r2, List<String> r3, int r4, t49.c r5) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "entries");
        this.e = r2;
        this.g = r3;
        int r6 = r3.size();
        int r7 = 0;
        if (r6 <= 0) goto L6;
        r7 = RangesKt.coerceIn(r4, 0, r6 - 1);
    L6:
        this.h = r7;
        this.i = r7;
        this.k = r5;
    }
}
