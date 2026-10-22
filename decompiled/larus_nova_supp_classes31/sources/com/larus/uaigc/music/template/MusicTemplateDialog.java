package com.larus.uaigc.music.template;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.larus.platform.api.g0;
import com.larus.platform.api.g0$a;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jv\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00142>\u0010\u0004\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\u0004\u0018\u0001`\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+H\u0016RF\u0010\u0004\u001a:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\u0004\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/uaigc/music/template/MusicTemplateDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "musicTemplateChoose", "Lkotlin/Function2;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "enterFrom", "", "Lcom/larus/uaigc/music/template/TemplateChooseCallback;", "botId", "chatType", "conversationId", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "model", "Lcom/larus/uaigc/music/template/MusicTemplateModel;", "setUp", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onResume", "onPause", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "generateChatTitle", "Lcom/larus/platform/api/IChatTitle;", "fragment", "Lcom/larus/uaigc/music/template/MusicTemplateListFragment;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicTemplateDialog extends DialogFragment {
    public static final /* synthetic */ int i = 0;
    public Function2<? super bq8.a, ? super String, Unit> d;
    public String e;
    public String f;
    public com.larus.bmhome.view.actionbar.edit.c g;
    public MusicTemplateModel h;

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        com.larus.bmhome.music.player.b.a.getClass();
        com.larus.bmhome.music.player.b.a.i = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        com.larus.bmhome.music.player.b.a.getClass();
        com.larus.bmhome.music.player.b.a.i = false;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setLayout(-1, -1);
    L7:
        Dialog r2 = getDialog();
        if (r2 == null) goto L13;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L14;
        r3.setWindowAnimations(2131954386);
        return;
    L14:
        return;
    }

    public MusicTemplateDialog() {
    }

    public static void S90(MusicTemplateDialog r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(0, 2131953344);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = new Dialog(requireContext(), 2131953344);
        r4.requestWindowFeature(1);
        r4.setCancelable(true);
        r4.setCanceledOnTouchOutside(true);
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        com.larus.bmhome.music.player.f r3 = com.larus.bmhome.music.player.f.a;     // Catch: Throwable -> L7
        com.larus.bmhome.music.player.f.c();     // Catch: Throwable -> L7
        com.larus.bmhome.view.actionbar.edit.c r4 = this.g;     // Catch: Throwable -> L7
        if (r4 == null) goto L5;
        r4.onMusicDetailDialogDismiss();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131561787, r8, false);
        final MusicTemplateListFragment r11 = new MusicTemplateListFragment();
        r11.m = this.h;
        com.larus.bmhome.music.player.f r0 = com.larus.bmhome.music.player.f.a;
        com.larus.bmhome.music.player.f.c();
        r11.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("argBotId", this.e), TuplesKt.to("arg_chat_type", this.f)}));
        Context r1 = getContext();
        if (r1 != null) goto L5;
        g0 r2 = null;
    L22:
        if (r2 == null) goto L24;
        Intrinsics.checkNotNullParameter(r2, "chatTitle");
        r11.r = r2;
    L24:
        r11.d = new g(this);
        if (r9 == null) goto L27;
        S90(this);
    L27:
        FragmentTransaction r12 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r11, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L31;
        r12 = r12.replace(2131373275, r11);
    L31:
        r12.commit();
        return r10;
    L5:
        r2 = IAIChatUgcAIGCService.a.O(r1);
        boolean r3 = r2 instanceof ViewGroup;
        if (r3 == false) goto L8;
        ViewGroup r4 = (ViewGroup) r2;
    L9:
        if (r4 == null) goto L11;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L13:
        if (r5 == null) goto L15;
        r5.width = -1;
        r5.height = -1;
    L21:
        g0$a.b(r2, getResources().getString(2131906382), false, 6);
        r2.setOnBackClickListener(new h(this));
        r2.setOnMainClickListener(new i(r11));
        goto L22
    L15:
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -1);
        if (r3 == false) goto L18;
        ViewGroup r13 = (ViewGroup) r2;
    L19:
        if (r13 == null) goto L21;
        r13.setLayoutParams(r6);
        goto L21
    L18:
        r13 = null;
        goto L19
    L11:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }
}
