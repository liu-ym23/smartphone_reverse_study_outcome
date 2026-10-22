package com.larus.dora.impl.device.settings.rename;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.l0;
import com.larus.dora.impl.databinding.LarusDoraPageRenameSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.util.o;
import com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/device/settings/rename/RenameSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageRenameSettingsBinding;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "deviceName", "", "doubleConfirm", "", "textWatcher", "Landroid/text/TextWatcher;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "getPageMaskView", "onBackPressed", "saveBudsNameWithConfirm", "updateSaveButtonState", "editable", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenameSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDoraPageRenameSettingsBinding f;
    public final CoroutineScope g;
    public String h;
    public boolean i;
    public b j;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ RenameSettingsFragment a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(RenameSettingsFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            RenameSettingsFragment r5 = this.a;
            int r6 = RenameSettingsFragment.k;
            r5.W90(r1);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.rename.RenameSettingsFragment$onBackPressed$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.rename.RenameSettingsFragment$onBackPressed$1", f = "RenameSettingsFragment.kt", i = {0, 0}, l = {161}, m = "invokeSuspend", n = {"macAddress", "newDeviceName"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RenameSettingsFragment this$0;

        public AnonymousClass1(RenameSettingsFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r2 = (String) this.L$1;
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r8);
        L46:
            int r9 = ((Number) r8).intValue();
            g49.d.d("DeviceNameSettings", "syncBudsName " + r2 + ", ret = " + r9);
            t39.c r4 = j49.b.a;
            j49.b.f(this.this$0.h, r2, r9);
            if (r9 != 0) goto L49;
            l0.a(r3, r2);
            Intent r10 = new Intent("action.DEVICE_UPDATE_NAME");
            r10.putExtra("mac", r3);
            Boxing.boxBoolean(LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r10));
        L50:
            LocalBroadcastManager r11 = LocalBroadcastManager.getInstance(AppHost.a.getApplication());
            Intent r5 = new Intent("action.DEVICE_UPDATE_NAME");
            r5.putExtra("mac", r3);
            r11.sendBroadcast(r5);
            FragmentActivity r12 = this.this$0.getActivity();
            if (r12 == null) goto L54;
            r12.finish();
        L54:
            return Unit.INSTANCE;
        L49:
            s r13 = s.a;
            Application r6 = AppHost.a.getApplication();
            r13.getClass();
            s.b(r6, 2131904037, false);
            goto L50
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            Bundle r14 = this.this$0.getArguments();
            if (r14 == null) goto L56;
            r3 = r14.getString(DoraObricDeviceNameViewModel.KEY_MAC_ADDRESS);
            if (r3 == null) goto L56;
            LarusDoraPageRenameSettingsBinding r15 = this.this$0.f;
            if (r15 == null) goto L22;
            AppCompatEditText r16 = r15.c;
            if (r16 == null) goto L22;
            Editable r17 = r16.getText();
            if (r17 == null) goto L22;
            String r18 = r17.toString();
            if (r18 == null) goto L22;
            String r20 = StringsKt.trim(r18).toString();
        L23:
            if (r20 != null) goto L25;
        L28:
            boolean r7 = true;
        L29:
            if (r7 == false) goto L36;
            s r21 = s.a;
            Application r22 = AppHost.a.getApplication();
            r21.getClass();
            s.b(r22, 2131904032, false);
            FragmentActivity r23 = this.this$0.getActivity();
            if (r23 == null) goto L34;
            r23.finish();
        L34:
            return Unit.INSTANCE;
        L36:
            if (Intrinsics.areEqual(r20, this.this$0.h) == false) goto L42;
            FragmentActivity r24 = this.this$0.getActivity();
            if (r24 == null) goto L41;
            r24.finish();
        L41:
            return Unit.INSTANCE;
        L42:
            CoroutineDispatcher r25 = Dispatchers.getIO();
            RenameSettingsFragment$onBackPressed$1$ret$1 r26 = new RenameSettingsFragment$onBackPressed$1$ret$1(r20, null);
            this.L$0 = r3;
            this.L$1 = r20;
            this.label = 1;
            Object r27 = BuildersKt.withContext(r25, r26, this);
            if (r27 != r0) goto L45;
            return r0;
        L45:
            r2 = r20;
            r8 = r27;
            goto L46
        L25:
            if (r20.length() == 0) goto L28;
            r7 = false;
        L22:
            r20 = null;
        L56:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "device_management_name";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageRenameSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final void onBackPressed() {
        if (this.i == false) goto L7;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        r0.finish();
        return;
    L9:
        return;
    L7:
        BuildersKt.launch$default(this.g, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onDestroyView() {
        b r0 = this.j;
        if (r0 == null) goto L9;
        LarusDoraPageRenameSettingsBinding r1 = this.f;
        if (r1 == null) goto L9;
        AppCompatEditText r2 = r1.c;
        if (r2 == null) goto L9;
        r2.removeTextChangedListener(r0);
    L9:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public RenameSettingsFragment() {
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.h = "";
    }

    public final void W90(CharSequence r5) {
        if (this.i == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L9;
        String r6 = r5.toString();
        if (r6 == null) goto L9;
        String r7 = StringsKt.trim(r6).toString();
    L10:
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        LarusDoraPageRenameSettingsBinding r0 = this.f;
        if (r0 == null) goto L27;
        NovaTitleBarEx r1 = r0.f;
        if (r1 == null) goto L28;
        boolean r2 = true;
        if (r7.length() <= 0) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == true) goto L22;
    L24:
        r2 = false;
    L25:
        r1.setRightTextEnable(r2);
        return;
    L22:
        if (Intrinsics.areEqual(r7, this.h) == true) goto L24;
    L19:
        r3 = false;
        goto L20
    L28:
        return;
    L27:
        return;
    L9:
        r7 = null;
        goto L10
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        FragmentActivity r14 = getActivity();
        if (r14 != null) goto L5;
        return;
    L5:
        Bundle r15 = getArguments();
        if (r15 == null) goto L44;
        String r16 = r15.getString(DoraObricDeviceNameViewModel.KEY_DEVICE_NAME);
        if (r16 == null) goto L47;
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 == null) goto L13;
        String r2 = r0.getString(DoraObricDeviceNameViewModel.KEY_MAC_ADDRESS);
    L14:
        this.h = o.b(r2, r16);
        Bundle r17 = getArguments();
        if (r17 == null) goto L17;
        boolean r18 = r17.getBoolean(DoraObricDeviceNameViewModel.KEY_DOUBLE_CONFIRM);
    L18:
        this.i = r18;
        final LarusDoraPageRenameSettingsBinding r110 = this.f;
        if (r110 == null) goto L38;
        NovaTitleBarEx r10 = r110.f;
        NovaTitleBarEx.Y5(r10, getString(2131902445), null, null, 6);
        NovaTitleBarEx.b6(r10, 2131240517, false, null, null, new com.larus.dora.impl.device.settings.rename.b(this), 14);
        if (this.i == false) goto L23;
        NovaTitleBarEx.o6(r10, getString(2131903980), new c(this));
        b r3 = new b(this);
        this.j = r3;
        r110.c.addTextChangedListener(r3);
    L23:
        Bundle r4 = getArguments();
        if (r4 == null) goto L26;
        r1 = r4.getString(DoraObricDeviceNameViewModel.KEY_MAC_ADDRESS);
    L26:
        AppCompatEditText r5 = r110.c;
        if (r1 == null) goto L30;
        String r6 = o.b(r1, this.h);
        if (r6 == null) goto L30;
    L31:
        r5.setText(r6);
        AppCompatEditText r7 = r110.c;
        if (this.i == false) goto L34;
        com.larus.dora.impl.device.settings.rename.a[] r8 = {new com.larus.dora.impl.device.settings.rename.a()};
    L35:
        r7.setFilters(r8);
        r110.c.requestFocus();
        Object r111 = ContextCompat.getSystemService(r14, InputMethodManager.class);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r111).showSoftInput(r110.c, 1);
        e1.d(r110.b, new d(r110));
        if (this.i == false) goto L38;
        r110.d.setText(getString(2131902507));
        W90(r110.c.getText());
        goto L38
    L34:
        r8 = new InputFilter[]{new com.larus.dora.impl.device.settings.rename.a(), new InputFilter.LengthFilter(20)};
    L30:
        r6 = this.h;
    L38:
        FragmentActivity r112 = getActivity();
        if (r112 == null) goto L45;
        OnBackPressedDispatcher r9 = r112.getOnBackPressedDispatcher();
        if (r9 == null) goto L46;
        OnBackPressedDispatcherKt.addCallback$default(r9, null, false, new e(this), 3, null);
        return;
    L46:
        return;
    L45:
        return;
    L17:
        r18 = false;
        goto L18
    L13:
        r2 = null;
        goto L14
    L47:
        return;
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562290, r9, false);
        int r12 = 2131369495;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r11, 2131369495);
        if (r2 == null) goto L17;
        r12 = 2131369496;
        AppCompatEditText r3 = ViewBindings.findChildViewById(r11, 2131369496);
        if (r3 == null) goto L17;
        r12 = 2131369497;
        if (ViewBindings.findChildViewById(r11, 2131369497) == null) goto L17;
        r12 = 2131369499;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r11, 2131369499);
        if (r4 == null) goto L17;
        r12 = 2131369962;
        View r5 = ViewBindings.findChildViewById(r11, 2131369962);
        if (r5 == null) goto L17;
        r12 = 2131388772;
        NovaTitleBarEx r6 = ViewBindings.findChildViewById(r11, 2131388772);
        if (r6 == null) goto L17;
        ConstraintLayout r13 = r11;
        this.f = new LarusDoraPageRenameSettingsBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
