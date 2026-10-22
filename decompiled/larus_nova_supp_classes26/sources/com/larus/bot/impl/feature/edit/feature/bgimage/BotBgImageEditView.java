package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.databinding.LarusLayoutBotEditBgImageBinding;
import com.larus.bot.impl.feature.edit.feature.avatar.dialog.AvatarGenActionSheet;
import com.larus.bot.impl.feature.edit.feature.avatar.dialog.AvatarPromptInputDialog;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.platform.model.EditPos;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotBgImageEditView implements com.larus.bot.impl.feature.edit.feature.avatar.u {
    public static final /* synthetic */ int q = 0;
    public final TraceFragment a;
    public final LarusLayoutBotEditBgImageBinding b;
    public final u c;
    public final dv8.b d;
    public final LifecycleCoroutineScope e;
    public AvatarGenActionSheet f;
    public ActivityResultLauncher<String> g;
    public ActivityResultLauncher<Intent> h;
    public ActivityResultLauncher<Intent> i;
    public String j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public AvatarPromptInputDialog p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.u
    public final void a(EditPos r13) {
        LarusLayoutBotEditBgImageBinding r0 = this.b;
        this.c.dispatchUIAction(new com.larus.bot.impl.feature.edit.feature.bgimage.a.b(this.a.getArguments()));
        this.g = this.a.registerForActivityResult(new ActivityResultContracts.GetContent(), new p(this));
        this.h = this.a.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e(this));
        this.i = this.a.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new f(this));
        e1.d(r0.b, new k(this));
        e1.d(r0.d, new l(this));
        TextView r1 = r0.d;
        CharSequence r2 = r1.getText();
        boolean r3 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if ((!r4) == false) goto L12;
        int r5 = 0;
    L13:
        r1.setVisibility(r5);
        ViewGroup.MarginLayoutParams r6 = null;
        if (r13 == null) goto L38;
        u r7 = this.c;
        if ((r7 instanceof BotBgImageEditViewModel) == false) goto L18;
        BotBgImageEditViewModel r8 = (BotBgImageEditViewModel) r7;
    L19:
        if (r8 == null) goto L38;
        if (r8.getScene() != 1) goto L38;
        r0.b.setClickable(r13.g());
        TextView r9 = r0.d;
        CharSequence r10 = r9.getText();
        if (r10 != null) goto L25;
    L28:
        boolean r11 = true;
    L29:
        if (r11 == false) goto L31;
    L33:
        r3 = false;
    L34:
        if (r3 == false) goto L36;
        int r14 = 0;
    L37:
        r9.setVisibility(r14);
        goto L38
    L36:
        r14 = 8;
        goto L37
    L31:
        if (r13.g() == false) goto L33;
    L25:
        if (StringsKt.isBlank(r10) == true) goto L28;
        r11 = false;
        goto L29
    L18:
        r8 = null;
    L38:
        BuildersKt.launch$default(this.e, null, null, new BotBgImageEditView$bindObservers$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(this.c.getUiEvent(), new BotBgImageEditView$bindObservers$2(this, null)), this.e);
        e10 r15 = e10.a;
        if (e10.D().enableAdvance == false) goto L53;
        ViewGroup.LayoutParams r16 = r0.d.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L43;
        r6 = (ViewGroup.MarginLayoutParams) r16;
    L43:
        if (r6 == null) goto L45;
        r6.topMargin = c7.b(Integer.valueOf(this.n));
    L45:
        if (r6 == null) goto L47;
        r0.d.setLayoutParams(r6);
    L47:
        RoundFrameLayout r17 = r0.e;
        ViewGroup.LayoutParams r12 = r17.getLayoutParams();
        if (r12 == null) goto L51;
        r12.width = c7.b(Integer.valueOf(this.o));
        r12.height = c7.b(Integer.valueOf(this.o));
        r17.setLayoutParams(r12);
        goto L53
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L53:
        if (e10.B0() == false) goto L56;
        r0.d.setVisibility(8);
        r0.b.setEnabled(false);
        r0.e.setEnabled(false);
        return;
    L56:
        return;
    L12:
        r5 = 8;
        goto L13
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r4 = false;
        goto L10
    }

    public final void c(Uri r10) {
        if (r10 == null) goto L9;
        ActivityResultLauncher<Intent> r0 = this.i;
        Job r1 = null;
        if (r0 == null) goto L8;
        FragmentActivity r2 = this.a.getActivity();
        if (r2 == null) goto L8;
        r1 = BuildersKt.launch$default(this.e, null, null, new BotBgImageEditView$handlePhotoPickerResult$1$1$1$1(r2, r10, r0, null), 3, null);
    L8:
        if (r1 == null) goto L9;
        return;
    L9:
        FLogger.a.e("BotBgImageEditView", "pickAvatarLauncher return null");
        Unit r11 = Unit.INSTANCE;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.u
    public final void onResult(int r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        if (r2 != 789) goto L6;
        this.c.dispatchUIAction(new com.larus.bot.impl.feature.edit.feature.bgimage.a.C0057a(r3));
        return;
    }

    public static final void b(BotBgImageEditView r3, boolean r4, b.C0064b r5) {
        AvatarPromptInputDialog r0 = r3.p;
        if (r0 != null) goto L31;
    L10:
        BotAvatarIconData r6 = r5.a;
        String r1 = null;
        if (r6 == null) goto L13;
        String r7 = r6.getPrompt();
    L14:
        AvatarPromptInputDialog r2 = new AvatarPromptInputDialog(r7, new o());
        dv8.b r8 = r3.d;
        if (r8 == null) goto L17;
        String r9 = r8.d();
    L18:
        dv8.b r10 = r3.d;
        if (r10 == null) goto L21;
        r1 = r10.c();
    L21:
        AvatarPromptInputDialog.S90(r2, r4, r9, r1);
        FragmentManager r11 = r3.a.getParentFragmentManager();
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "AvatarPromptInputDialog", r12);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r2, r12) == false) goto L29;
    L26:
        r3.p = r2;
        return;
    L29:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L25:
        r2.show(r11, "AvatarPromptInputDialog");
        goto L26
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L31:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L10;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public BotBgImageEditView(TraceFragment r2, LarusLayoutBotEditBgImageBinding r3, u r4, dv8.b r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = LifecycleOwnerKt.getLifecycleScope(r2.getViewLifecycleOwner());
        e10 r6 = e10.a;
        int r7 = 120;
        if (e10.D().enableAdvance == false) goto L5;
        int r8 = 100;
    L6:
        this.k = r8;
        if (e10.D().enableAdvance == false) goto L9;
        int r9 = 184;
    L10:
        this.l = r9;
        if (e10.D().enableAdvance == false) goto L13;
        r7 = 104;
    L13:
        this.m = r7;
        this.n = 12;
        this.o = 32;
        return;
    L9:
        r9 = 213;
        goto L10
    L5:
        r8 = 120;
        goto L6
    }
}
