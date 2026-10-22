package com.larus.dora.impl.device.settings.rename;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.core.l0;
import com.larus.dora.impl.databinding.LarusDoraPageRenameSettingsBinding;
import com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.rename.RenameSettingsFragment$saveBudsNameWithConfirm$1", f = "RenameSettingsFragment.kt", i = {0, 0, 0}, l = {220}, m = "invokeSuspend", n = {"macAddress", "newDeviceName", "ret"}, s = {"L$0", "L$1", "L$2"})
final class RenameSettingsFragment$saveBudsNameWithConfirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RenameSettingsFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.rename.RenameSettingsFragment$saveBudsNameWithConfirm$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.rename.RenameSettingsFragment$saveBudsNameWithConfirm$1$2", f = "RenameSettingsFragment.kt", i = {0}, l = {226}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newDeviceName;
        final /* synthetic */ Ref.IntRef $ret;
        int I$0;
        int label;

        public AnonymousClass2(Ref.IntRef r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.$ret = r1;
            this.$newDeviceName = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$ret, this.$newDeviceName, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0042 -> B:17:0x0045). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r7);
            AnonymousClass2 r8 = this;
        L17:
            r2 = r2 + 1;
        L10:
            if (r2 >= 3) goto L19;
            Ref.IntRef r3 = r8.$ret;
            r3.element = kj4.a.g().q(r8.$newDeviceName);
            if (r8.$ret.element == 0) goto L19;
            r8.I$0 = r2;
            r8.label = 1;
            if (DelayKt.delay(100, r8) != r0) goto L17;
            return r0;
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            r8 = this;
            r2 = 0;
            goto L10
        }
    }

    public static final class a implements p0 {
        public a() {
        }

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
        }
    }

    public RenameSettingsFragment$saveBudsNameWithConfirm$1(RenameSettingsFragment r1, Continuation<? super RenameSettingsFragment$saveBudsNameWithConfirm$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RenameSettingsFragment$saveBudsNameWithConfirm$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.IntRef r2 = (Ref.IntRef) this.L$2;
        String r3 = (String) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r9);
    L40:
        g49.d.d("DeviceNameSettings", "syncBudsName " + r3 + ", ret = " + r2.element);
        t39.c r10 = j49.b.a;
        j49.b.f(this.this$0.h, r3, r2.element);
        if (r2.element != 0) goto L45;
        l0.a(r4, r3);
        Intent r11 = new Intent("action.DEVICE_UPDATE_NAME");
        r11.putExtra("mac", r4);
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r11);
        FragmentActivity r12 = this.this$0.getActivity();
        if (r12 == null) goto L47;
        r12.finish();
    L47:
        return Unit.INSTANCE;
    L45:
        s r13 = s.a;
        Application r5 = AppHost.a.getApplication();
        r13.getClass();
        s.b(r5, 2131904037, false);
        goto L47
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        Bundle r14 = this.this$0.getArguments();
        if (r14 == null) goto L49;
        String r15 = r14.getString(DoraObricDeviceNameViewModel.KEY_MAC_ADDRESS);
        if (r15 == null) goto L49;
        LarusDoraPageRenameSettingsBinding r6 = this.this$0.f;
        if (r6 == null) goto L22;
        AppCompatEditText r7 = r6.c;
        if (r7 == null) goto L22;
        Editable r8 = r7.getText();
        if (r8 == null) goto L22;
        String r16 = r8.toString();
        if (r16 == null) goto L22;
        r3 = StringsKt.trim(r16).toString();
    L23:
        if (r3 != null) goto L25;
    L28:
        boolean r17 = true;
    L29:
        if (r17 == false) goto L33;
        s r18 = s.a;
        Application r20 = AppHost.a.getApplication();
        r18.getClass();
        s.b(r20, 2131904032, false);
        return Unit.INSTANCE;
    L33:
        if (r3.getBytes(Charsets.UTF_8).length <= 20) goto L36;
        CommonDialog.a r21 = new CommonDialog.a();
        r21.i(this.this$0.getString(2131903979));
        r21.g(this.this$0.getString(2131902507));
        r21.h(ContextCompat.getColor(this.this$0.requireContext(), 2131103143));
        CommonDialog.a.f(r21, new a(), this.this$0.getResources().getString(2131902173), false, 12);
        r21.w = true;
        INVOKEVIRTUAL_com_larus_dora_impl_device_settings_rename_RenameSettingsFragment$saveBudsNameWithConfirm$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r21.b(ContextCompat.getColor(this.this$0.requireContext(), 2131103146)), this.this$0.getChildFragmentManager(), null);
        return Unit.INSTANCE;
    L36:
        Ref.IntRef r22 = new Ref.IntRef();
        CoroutineDispatcher r23 = Dispatchers.getIO();
        AnonymousClass2 r24 = new AnonymousClass2(r22, r3, null);
        this.L$0 = r15;
        this.L$1 = r3;
        this.L$2 = r22;
        this.label = 1;
        if (BuildersKt.withContext(r23, r24, this) != r0) goto L39;
        return r0;
    L39:
        r4 = r15;
        r2 = r22;
        goto L40
    L25:
        if (r3.length() == 0) goto L28;
        r17 = false;
    L22:
        r3 = null;
    L49:
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_larus_dora_impl_device_settings_rename_RenameSettingsFragment$saveBudsNameWithConfirm$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        CommonDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
