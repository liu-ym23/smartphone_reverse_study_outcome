package com.ss.android.lark.officesdk.minutes.ui.record.panel;

import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import bwb.b;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qub.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingPanelFactory {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(FragmentManager r5, String r6) {
        DialogFragment r0 = r5.findFragmentByTag(r6);
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isAdded() == true) goto L30;
        int r7 = b.a;
        b.b(MmUiLogScene.OVERLAY, "dismissPanel", "dismissPanel: fragment not added, skip, tag=".concat(r6), null, 8);
        return;
    L30:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L22
        if ((r0 instanceof DialogFragment) == true) goto L28;
        Unit r8 = Integer.valueOf(r5.beginTransaction().remove(r0).commitAllowingStateLoss());     // Catch: Throwable -> L22
    L20:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L22
    L24:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L32;
        int r2 = b.a;
        b.d(MmUiLogScene.OVERLAY, "dismissPanel", "dismissPanel failed, tag=" + r6 + ", e=" + r10, null);
        return;
    L32:
        return;
    L28:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L14 Throwable -> L22
    L18:
        r8 = Unit.INSTANCE;     // Catch: Throwable -> L22
        goto L20
    L14:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L22
        Throwable r11 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L22
        if (r11 == null) goto L18;
        d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public static boolean b(FragmentManager r0, String r1) {
        DialogFragment r2 = r0.findFragmentByTag(r1);
        if ((r2 instanceof DialogFragment) == false) goto L9;
        Dialog r3 = r2.getDialog();
        if (r3 != null) goto L7;
    L11:
        return false;
    L7:
        if (r3.isShowing() != true) goto L11;
        return true;
    L9:
        if (r2 == null) goto L11;
        return r2.isAdded();
    }

    public static void d(Fragment r11, final MmRecordingViewModel r12) {
        Intrinsics.checkNotNullParameter(r11, "fragment");
        Intrinsics.checkNotNullParameter(r12, "viewModel");
        e r0 = r12.getUiProviders().b();
        final FragmentManager r13 = r11.getChildFragmentManager();
        if (b(r13, "MmAudioSaveDialog") == false) goto L6;
        int r14 = b.a;
        b.b(MmUiLogScene.OVERLAY, "showAudioSaveSetting", "showAudioSaveSetting: panel already showing, skip", null, 8);
        return;
    L6:
        r0.w(r13, new rub.d("MmAudioSaveDialog", new MmRecordingPanelFactory$showAudioSaveSetting$config$1(r12, r13), null, r12.getUiLaunchMode(), null, false, 7930));
    }

    public static void g(Fragment r11, final MmRecordingViewModel r12) {
        Intrinsics.checkNotNullParameter(r11, "fragment");
        Intrinsics.checkNotNullParameter(r12, "viewModel");
        e r0 = r12.getUiProviders().b();
        final FragmentManager r13 = r11.getChildFragmentManager();
        if (b(r13, "MmSpokenLanguageDialog") == false) goto L6;
        int r14 = b.a;
        b.b(MmUiLogScene.OVERLAY, "showSpokenSelection", "showSpokenSelection: panel already showing, skip", null, 8);
        return;
    L6:
        r0.w(r13, new rub.d("MmSpokenLanguageDialog", new MmRecordingPanelFactory$showSpokenSelection$config$1(r12, r13), null, r12.getUiLaunchMode(), null, false, 7930));
    }

    public static void h(Fragment r11, final MmRecordingViewModel r12) {
        Intrinsics.checkNotNullParameter(r11, "fragment");
        Intrinsics.checkNotNullParameter(r12, "viewModel");
        e r0 = r12.getUiProviders().b();
        final FragmentManager r13 = r11.getChildFragmentManager();
        if (b(r13, "MmTranslateLanguageDialog") == false) goto L6;
        int r14 = b.a;
        b.b(MmUiLogScene.OVERLAY, "showTranslateSelection", "showTranslateSelection: panel already showing, skip", null, 8);
        return;
    L6:
        r0.w(r13, new rub.d("MmTranslateLanguageDialog", new MmRecordingPanelFactory$showTranslateSelection$config$1(r12, r13), null, r12.getUiLaunchMode(), null, false, 7930));
    }

    public static void c(Fragment r10, final MmRecordingViewModel r11, final Function0 r12) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "viewModel");
        e r0 = r11.getUiProviders().b();
        final FragmentManager r13 = r10.getChildFragmentManager();
        if (b(r13, "MmAIInterpretationDialog") == false) goto L6;
        int r14 = b.a;
        b.b(MmUiLogScene.OVERLAY, "showAIInterpretation", "showAIInterpretation: panel already showing, skip", null, 8);
        return;
    L6:
        int r1 = b.a;
        b.g(MmUiLogScene.OVERLAY, "showAIInterpretation", null, null, 12);
        r11.trackAIInterpretationView(r11.getState().v);
        r0.w(r13, new rub.d("MmAIInterpretationDialog", new MmRecordingPanelFactory$showAIInterpretation$config$1(r11, r12, r13), null, r11.getUiLaunchMode(), null, false, 7930));
    }

    public static void e(Fragment r10, final MmRecordingViewModel r11, final MmRecordingUILaunchMode r12) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "viewModel");
        Intrinsics.checkNotNullParameter(r12, "uiLaunchMode");
        e r0 = r11.getUiProviders().b();
        final FragmentManager r13 = r10.getChildFragmentManager();
        if (b(r13, "MmLanguageChooseDialog") == false) goto L6;
        int r14 = b.a;
        b.b(MmUiLogScene.OVERLAY, "showLanguageSetting", "showLanguageSetting: panel already showing, skip", null, 8);
        return;
    L6:
        r0.w(r13, new rub.d("MmLanguageChooseDialog", new MmRecordingPanelFactory$showLanguageSetting$config$1(r11, r12, r13), null, r12, null, false, 7930));
    }

    public static void f(Fragment r9, e r10, final String r11, final Function1 r12, final MmRecordingUILaunchMode r13) {
        Intrinsics.checkNotNullParameter(r9, "fragment");
        Intrinsics.checkNotNullParameter(r10, "panelProvider");
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "onFeedbackClick");
        Intrinsics.checkNotNullParameter(r13, "uiLaunchMode");
        final FragmentManager r14 = r9.getChildFragmentManager();
        if (b(r14, "MmMoreActionDialog") == false) goto L6;
        int r15 = b.a;
        b.b(MmUiLogScene.OVERLAY, "showMoreActionPanel", "showMoreActionPanel: panel already showing, skip", null, 8);
        return;
    L6:
        r10.w(r14, new rub.d("MmMoreActionDialog", new MmRecordingPanelFactory$showMoreActionPanel$config$1(r13, r11, r14, r12), null, r13, null, false, 7930));
    }
}
