package com.larus.dora.impl.wlan.wifi.add;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.dora.impl.databinding.LarusDoraWifiAddDialogLayoutBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.j0;
import com.larus.utils.m0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0017\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiAddDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraWifiAddDialogLayoutBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiScanListViewModel;", "getModel", "()Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiScanListViewModel;", "model$delegate", "Lkotlin/Lazy;", "wifiEntity", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "isConnecting", "", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "updatePasswordVisible", "isPasswordVisible", "(Z)Lkotlin/Unit;", "onStart", "onResume", "showAddWifiFailedDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiAddDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraWifiAddDialogLayoutBinding d;
    public final Lazy e;
    public DoraWifiEntity f;
    public boolean g;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraWifiAddDialog a;

        public b(DoraWifiAddDialog r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            h r9 = (h) r7;
            if (Intrinsics.areEqual(r9, h.c.a) == false) goto L8;
            DoraWifiAddDialog r10 = this.a;
            r10.g = true;
            LarusDoraWifiAddDialogLayoutBinding r11 = r10.d;
            if (r11 == null) goto L30;
            e1.o(r11.b);
            e1.x(r11.d);
            r11.c.setEnabled(false);
        L30:
            return Unit.INSTANCE;
        L8:
            if (Intrinsics.areEqual(r9, h.b.a) == false) goto L17;
            DoraWifiAddDialog r12 = this.a;
            r12.g = false;
            o5.a(r12, "FRAGMENT_REQUEST_KEY_FINISH", com.larus.utils.f.c(new Pair[0]));
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L12
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r13 = DialogFragmentLancet.sLastShowStack;
            if (r13 == null) goto L30;
            com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L30
        L17:
            if ((r9 instanceof h.a) == false) goto L32;
            DoraWifiAddDialog r14 = this.a;
            r14.g = false;
            LarusDoraWifiAddDialogLayoutBinding r15 = r14.d;
            if (r15 == null) goto L21;
            e1.x(r15.b);
            e1.o(r15.d);
            r15.c.setEnabled(true);
        L21:
            DoraWifiAddDialog r16 = this.a;
            Context r17 = r16.getContext();
            if (r17 == null) goto L30;
            CommonDialog.a r2 = new CommonDialog.a();
            int r3 = j0.a;
            r2.i(j0.d(2131904079));
            r2.g(j0.d(2131904078));
            CommonDialog.a.f(r2, new f(), r16.getString(2131902466), false, 12);
            f0 r1 = new f0(null, Integer.valueOf(ContextCompat.getColor(r17, v19.c.b(2130972123, r16.getContext(), 2131103203))), Typeface.DEFAULT_BOLD, 1);
            Intrinsics.checkNotNullParameter(r1, "commonDialogTextStyleConfig");
            r2.D = r1;
            CommonDialog r18 = r2.a();
            FragmentManager r20 = r16.getChildFragmentManager();
            LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, "AddWifiFailedDialog", r0);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r20, r18, r0) == true) goto L30;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
        L28:
            r18.show(r20, "AddWifiFailedDialog");
            goto L30
        L32:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ LarusDoraWifiAddDialogLayoutBinding a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(LarusDoraWifiAddDialogLayoutBinding r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            AppCompatTextView r5 = this.a.b;
            if (r1 != null) goto L5;
        L8:
            boolean r6 = true;
        L9:
            r5.setEnabled(!r6);
            return;
        L5:
            if (r1.length() == 0) goto L8;
            r6 = false;
            goto L9
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951937;
    }

    public DoraWifiAddDialog() {
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraWifiScanListViewModel.class), new DoraWifiAddDialog$special$$inlined$activityViewModels$default$1(this), new DoraWifiAddDialog$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        r0.setOnKeyListener(new com.larus.dora.impl.wlan.wifi.add.a(this));
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        BottomSheetBehavior.from(r0.findViewById(2131368870)).setHideable(false);
        r0.findViewById(2131389274).setOnClickListener(new e(this));
        return;
    }

    public final void S90(boolean r3) {
        LarusDoraWifiAddDialogLayoutBinding r0 = this.d;
        if (r0 == null) goto L9;
        if (r3 == false) goto L6;
        r0.e.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        r0.f.setImageResource(2131240666);
    L7:
        Unit r4 = Unit.INSTANCE;
        return;
    L6:
        r0.e.setTransformationMethod(PasswordTransformationMethod.getInstance());
        r0.f.setImageResource(2131240665);
        goto L7
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        DoraWifiEntity r4 = (DoraWifiEntity) r3.getParcelable("dora_wifi_entity");
    L6:
        this.f = r4;
        g49.d.d("DoraWifiAddDialog", "onCreate: " + this.f);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        BottomSheetDialog r10 = getDialog();
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
        BottomSheetBehavior r1 = BottomSheetBehavior.from(r12);
        r12.setBackgroundResource(R.color.transparent);
        r1.setState(3);
        r1.setPeekHeight(r15);
    L12:
        final LarusDoraWifiAddDialogLayoutBinding r16 = this.d;
        if (r16 == null) goto L19;
        final Ref.BooleanRef r17 = new Ref.BooleanRef();
        S90(false);
        r16.f.setOnClickListener(new com.larus.dora.impl.wlan.wifi.add.b(r17, this, r16));
        ItemGroupTitle r18 = r16.g;
        DoraWifiEntity r2 = this.f;
        if (r2 == null) goto L17;
        String r3 = r2.c();
    L18:
        r18.setText(r3);
        e1.d(r16.c, new com.larus.dora.impl.wlan.wifi.add.c(this));
        e1.d(r16.b, new d(this, r16));
        r16.b.setEnabled(false);
        r16.e.addTextChangedListener(new c(r16));
        e1.x(r16.b);
        e1.o(r16.d);
        r16.c.setEnabled(true);
        goto L19
    L17:
        r3 = null;
    L19:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraWifiAddDialog$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        return;
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562312, r10, false);
        int r13 = 2131370051;
        DoraTextView r2 = (DoraTextView) ViewBindings.findChildViewById(r12, 2131370051);
        if (r2 == null) goto L25;
        r13 = 2131370052;
        DoraTextView r3 = (DoraTextView) ViewBindings.findChildViewById(r12, 2131370052);
        if (r3 == null) goto L25;
        r13 = 2131370053;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r12, 2131370053);
        if (r4 == null) goto L25;
        r13 = 2131370054;
        if (((DoraTextView) ViewBindings.findChildViewById(r12, 2131370054)) == null) goto L25;
        r13 = 2131370055;
        if (ViewBindings.findChildViewById(r12, 2131370055) == null) goto L25;
        r13 = 2131370065;
        AppCompatEditText r5 = ViewBindings.findChildViewById(r12, 2131370065);
        if (r5 == null) goto L25;
        r13 = 2131370066;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, 2131370066);
        if (r6 == null) goto L25;
        r13 = 2131370067;
        if (((DoraTextView) ViewBindings.findChildViewById(r12, 2131370067)) == null) goto L25;
        r13 = 2131370068;
        if (ViewBindings.findChildViewById(r12, 2131370068) == null) goto L25;
        r13 = 2131370071;
        ItemGroupTitle r7 = ViewBindings.findChildViewById(r12, 2131370071);
        if (r7 == null) goto L25;
        LinearLayout r14 = (LinearLayout) r12;
        this.d = new LarusDoraWifiAddDialogLayoutBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
