package com.larus.bot.impl.feature.edit.feature.accesspermission;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bot.impl.databinding.LarusDialogBotAccessPermissionSettingBinding;
import com.larus.bot.impl.feature.edit.view.BotAccessPermissionItem;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\u0017\u0010$\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0018H\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0017\u0010+\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010&J\u0017\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010%\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010-J\u000f\u0010.\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010/R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u00061"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/accesspermission/BotPermissionBSDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "viewModel", "Lcom/larus/bot/impl/feature/edit/feature/accesspermission/BotAccessPermissionViewModel;", "getViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/accesspermission/BotAccessPermissionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/bot/impl/databinding/LarusDialogBotAccessPermissionSettingBinding;", "botId", "", "defaultStatus", "", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "behaviorCallback", "com/larus/bot/impl/feature/edit/feature/accesspermission/BotPermissionBSDialog$behaviorCallback$1", "Lcom/larus/bot/impl/feature/edit/feature/accesspermission/BotPermissionBSDialog$behaviorCallback$1;", "getTheme", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupResultListener", "setupViewModel", "setupPrivateStatusUI", "status", "(I)Lkotlin/Unit;", "setupItemSelectListener", "handleItemSelected", "isItemSelected", "", "showLoading", "isLoading", "(I)Ljava/lang/Boolean;", "hideLoading", "()Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotPermissionBSDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int j = 0;
    public final Lazy d;
    public LarusDialogBotAccessPermissionSettingBinding e;
    public String f;
    public int g;
    public BottomSheetBehavior<View> h;
    public final b i;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ BotPermissionBSDialog a;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(BotPermissionBSDialog r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            if (r3 != 1) goto L8;
            BottomSheetBehavior<View> r4 = this.a.h;
            if (r4 == null) goto L9;
            r4.setState(4);
            return;
        L9:
            return;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(i r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954335;
    }

    public BotPermissionBSDialog() {
        final Function0<Fragment> r0 = new BotPermissionBSDialog$special$$inlined$viewModels$default$1(this);
        this.d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotAccessPermissionViewModel.class), new BotPermissionBSDialog$special$$inlined$viewModels$default$2(r0), new BotPermissionBSDialog$special$$inlined$viewModels$default$3(r0, this));
        this.g = 1;
        this.i = new b(this);
    }

    public static void S90(BotPermissionBSDialog r1) {
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

    public final void T90(int r9) {
        LarusDialogBotAccessPermissionSettingBinding r0 = this.e;
        if (r0 == null) goto L11;
        if (r9 == 1) goto L10;
        if (r9 == 2) goto L9;
        if (r9 != 3) goto L11;
        boolean r1 = r0.e.getItemSelected();
    L12:
        if (r1 == false) goto L15;
        S90(this);
        return;
    L15:
        int r2 = dv8.a.a;
        if (r9 == 1) goto L22;
        if (r9 == 2) goto L21;
        if (r9 != 3) goto L25;
        String r3 = "not_seen";
    L23:
        com.larus.platform.service.o.a.b("change_bot_visible_status", com.larus.utils.f.c(new Pair[]{TuplesKt.to("to_status", r3)}));
    L25:
        if (o0.d(this.f) == false) goto L53;
        LarusDialogBotAccessPermissionSettingBinding r4 = this.e;
        if (r4 == null) goto L42;
        if (r9 == 1) goto L39;
        if (r9 == 2) goto L36;
        if (r9 == 3) goto L33;
    L31:
        boolean r5 = false;
    L41:
        Boolean r6 = Boolean.valueOf(r5);
    L44:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L46;
        return;
    L46:
        if (r9 != 1) goto L52;
        BotPublicPermissionBSDialog r10 = new BotPublicPermissionBSDialog();
        r10.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("public_permission_scene_argument", 2)}));
        FragmentManager r7 = getParentFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "BotPublicPermissionBSDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r10, r8) == true) goto L60;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L51:
        r10.show(r7, "BotPublicPermissionBSDialog");
        return;
    L60:
        return;
    L52:
        V90(r9);
        BotAccessPermissionViewModel r11 = (BotAccessPermissionViewModel) this.d.getValue();
        String r12 = this.f;
        Intrinsics.checkNotNull(r12);
        r11.update(r12, r9);
        return;
    L33:
        if (r4.e.a.d.getVisibility() != 0) goto L31;
    L34:
        r5 = true;
        goto L41
    L36:
        if (r4.b.a.d.getVisibility() != 0) goto L31;
    L39:
        if (r4.c.a.d.getVisibility() != 0) goto L31;
    L42:
        r6 = null;
        goto L44
    L53:
        U90(r9);
        o5.a(this, "access_permission_request", com.larus.utils.f.c(new Pair[]{TuplesKt.to("access_permission_result", Integer.valueOf(r9))}));
        S90(this);
        return;
    L21:
        r3 = "private";
        goto L23
    L22:
        r3 = "public";
        goto L23
    L9:
        r1 = r0.b.getItemSelected();
        goto L12
    L10:
        r1 = r0.c.getItemSelected();
    L11:
        r1 = false;
        goto L12
    }

    public final void U90(int r5) {
        LarusDialogBotAccessPermissionSettingBinding r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 != 1) goto L7;
        r0.c.setItemSelected(true);
        r0.e.setItemSelected(false);
        r0.b.setItemSelected(false);
    L14:
        Unit r6 = Unit.INSTANCE;
        return;
    L7:
        if (r5 != 2) goto L9;
        r0.c.setItemSelected(false);
        r0.e.setItemSelected(false);
        r0.b.setItemSelected(true);
        goto L14
    L9:
        if (r5 != 3) goto L14;
        r0.c.setItemSelected(false);
        r0.e.setItemSelected(true);
        r0.b.setItemSelected(false);
        goto L14
    }

    public final void V90(int r3) {
        LarusDialogBotAccessPermissionSettingBinding r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != 1) goto L7;
        r0.c.S5();
        r0.e.R5();
        r0.b.R5();
    L14:
        Unit r4 = Unit.INSTANCE;
        return;
    L7:
        if (r3 != 2) goto L9;
        r0.c.R5();
        r0.e.R5();
        r0.b.S5();
        goto L14
    L9:
        if (r3 != 3) goto L14;
        r0.c.R5();
        r0.e.S5();
        r0.b.R5();
        goto L14
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        if (getArguments() == null) goto L6;
        this.f = requireArguments().getString("access_permission_bot_id_argument");
        this.g = requireArguments().getInt("access_permission_default_value_argument");
        FLogger.a.d("BotPermissionBSDialog", "onCreate called, botId = " + this.f + ", defaultStatus = " + this.g);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.bot.impl.feature.edit.feature.accesspermission.i] */
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        Dialog r5 = getDialog();
        if (r5 == null) goto L6;
        r5.setOnShowListener(new com.larus.bot.impl.feature.edit.feature.accesspermission.c(this));
    L6:
        if (o0.d(this.f) == false) goto L9;
        o5.b(this, "public_permission_result_request", new g(this));
        o5.b(this, "public_permission_cancel_request", new h(this));
    L9:
        if (o0.d(this.f) == false) goto L11;
        ((BotAccessPermissionViewModel) this.d.getValue()).getUpdate().observe(getViewLifecycleOwner(), new c(new i(this)));
    L11:
        U90(this.g);
        LarusDialogBotAccessPermissionSettingBinding r6 = this.e;
        if (r6 == null) goto L15;
        e1.d(r6.c, new d(this));
        e1.d(r6.e, new e(this));
        e1.d(r6.b, new f(this));
        return;
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562037, r9, false);
        int r12 = 2131374656;
        BotAccessPermissionItem r2 = (BotAccessPermissionItem) ViewBindings.findChildViewById(r11, 2131374656);
        if (r2 == null) goto L15;
        r12 = 2131374657;
        BotAccessPermissionItem r3 = (BotAccessPermissionItem) ViewBindings.findChildViewById(r11, 2131374657);
        if (r3 == null) goto L15;
        r12 = 2131374658;
        View r4 = ViewBindings.findChildViewById(r11, 2131374658);
        if (r4 == null) goto L15;
        r12 = 2131374659;
        BotAccessPermissionItem r5 = (BotAccessPermissionItem) ViewBindings.findChildViewById(r11, 2131374659);
        if (r5 == null) goto L15;
        r12 = 2131374660;
        View r6 = ViewBindings.findChildViewById(r11, 2131374660);
        if (r6 == null) goto L15;
        LinearLayout r13 = (LinearLayout) r11;
        this.e = new LarusDialogBotAccessPermissionSettingBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
