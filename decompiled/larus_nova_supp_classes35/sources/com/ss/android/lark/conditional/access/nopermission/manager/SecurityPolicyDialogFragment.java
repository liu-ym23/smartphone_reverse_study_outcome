package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Base64;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.conditional.access.nopermission.ui.PopupWindowActivityV2;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006&"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/manager/SecurityPolicyDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onResume", BuildConfig.FLAVOR, "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "isCancelable", BuildConfig.FLAVOR, "onCreate", "onDestroy", "configDialog", IPortraitService.TYPE, BuildConfig.FLAVOR, Keys.API_PARAM_KEY_ACTION, "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "builder", "Lcom/ss/android/lark/conditional/access/nopermission/ui/ICustomDisplayDialogBuilder;", "configDeviceCertAuthSuccessDialog", "configDeviceCertAuthRetryDialog", "configDeviceCertAuthFailDialog", "configCustomDisplayDialog", "configCustomDisplayTNSDialog", "configCustomDisplayPolicyCenterDialog", "configDowngradeDialog", "configNormalDialog", "configNetworkDialog", "configDeviceOwnershipNoSwitchDialog", "configDeviceOwnershipErrorDialog", "configDeviceCertProcessingDialog", "configDeviceCertSuccessDialog", "configDeviceCertRetryDialog", "configDeviceCertFailDialog", "configLeaveDeviceDeclarePageHintDialog", "Companion", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecurityPolicyDialogFragment extends DialogFragment {

    public static final class a {
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r1) {
            SecurityPolicyDialogActionManager.a.getClass();
            SecurityPolicyDialogActionManager.b();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogFragment$onResume$1", f = "SecurityPolicyDialogFragment.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SecurityPolicyDialogFragment this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.nopermission.manager.SecurityPolicyDialogFragment$onResume$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ SecurityPolicyDialogFragment a;

            public a(SecurityPolicyDialogFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                if (((SecurityPolicyDialogActionManager.a) r1) != null) goto L12;
                this.a.dismiss();     // Catch: Exception -> L7
            L7:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
                Throwable r3 = DialogFragmentLancet.sLastShowStack;
                if (r3 == null) goto L12;
                com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            L12:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(SecurityPolicyDialogFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            SecurityPolicyDialogActionManager.a.getClass();
            b1 r6 = SecurityPolicyDialogActionManager.d;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final boolean isCancelable() {
        return false;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        SecurityPolicyPopupWindowActivity r0 = getActivity();
        if ((r0 instanceof SecurityPolicyPopupWindowActivity) == false) goto L6;
        r0.finish();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new AnonymousClass1(this, null));
    }

    public SecurityPolicyDialogFragment() {
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        SecurityPolicyPopupWindowActivity r6 = getActivity();
        if ((r6 instanceof SecurityPolicyPopupWindowActivity) == false) goto L6;
        int r0 = ScsLogger.a;
        ScsLogger.d("SecurityPolicyDialogFragment", "dialog show on " + r6.getIntent().getLongExtra("mark", -1));
        return;
    }

    public final Dialog onCreateDialog(Bundle r17) {
        FragmentActivity r0 = requireActivity();
        if (w4c.c.a().Q() == false) goto L5;
        com.ss.android.lark.conditional.access.nopermission.ui.q r1 = new com.ss.android.lark.conditional.access.nopermission.ui.custom.a0(r0);
    L7:
        if ((r0 instanceof PopupWindowActivityV2) == false) goto L9;
        r1.style(2131953406);
    L9:
        r1.cancelable(false);
        r1.cancelOnTouchOutside(false);
        r1.onCancelListener(b.a);
        SecurityPolicyDialogActionManager.a.getClass();
        SecurityPolicyDialogActionManager.a r2 = (SecurityPolicyDialogActionManager.a) SecurityPolicyDialogActionManager.d.getValue();
        if (r2 == null) goto L95;
        int r3 = r2.getType();
        InternalSecurityAction r4 = r2.b;
        if (r3 != 0) goto L14;
    L84:
        S90(r1, r4);
    L92:
        return r1.build();
    L14:
        if (r3 == 1) goto L84;
        String r6 = BuildConfig.FLAVOR;
        if (r3 != 5) goto L18;
        ScsLogger.d("SecurityPolicyDialogFragment", "configNetworkDialog()");
        String r5 = r4.getCurrentAction().getParams().get("entity_operation");
        if (r5 == null) goto L83;
        r6 = r5;
    L83:
        r1.title(((Number) SecurityDialogUtil.a(r6).getFirst()).intValue());
        r1.message(2131892746);
        r1.messageGravity(8388611);
        r1.addActionButton(2131391777, 2131890503, b0.a);
        goto L92
    L18:
        if (r3 != 6) goto L20;
        ScsLogger.d("SecurityPolicyDialogFragment", "configDowngradeDialog()");
        r1.title(2131892673);
        r1.message(2131892674);
        r1.messageGravity(8388611);
        r1.addActionButton(2131391777, 2131890503, y.a);
        goto L92
    L20:
        if (r3 == 7) goto L77;
        CustomDisplayTemplate r7 = null;
        if (r3 != 9) goto L24;
        int r8 = ScsLogger.a;
        ScsLogger.d("SecurityPolicyDialogFragment", "configCustomDisplayDialog(), type:" + r4.getCurrentAction().getParams().get("policyType"));
        Object r9 = r4.getInternalParams().get("displayModel");
        if ((r9 instanceof CustomDisplayTemplate) == false) goto L67;
        r7 = (CustomDisplayTemplate) r9;
    L67:
        if (r7 != null) goto L69;
        ScsLogger.c("SecurityPolicyDialogFragment", "template is null");
        FileAuthMonitor.UpdateTrigger[] r10 = FileAuthMonitor.a;
        FileAuthMonitor.e(100, r4.toString());
        S90(r1, r4);
        goto L92
    L69:
        if (Intrinsics.areEqual(r4.getCurrentAction().getParams().get("policyType"), "FILE_PROTECT") == false) goto L75;
        String r11 = r4.getCurrentAction().getParams().get("entity_operation");
        if (r11 == null) goto L74;
        r6 = r11;
    L74:
        CustomDisplayTemplate r12 = r7.newBuilder().title(r1.getActivity().getString(((Number) SecurityDialogUtil.a(r6).getFirst()).intValue())).build();
        Intrinsics.checkNotNull(r12);
        r1.d(r12, r4);
        goto L92
    L75:
        r1.d(r7, r4);
        goto L92
    L24:
        if (r3 != 31) goto L26;
        ScsLogger.d("SecurityPolicyDialogFragment", "configDeviceOwnershipNoSwitchDialog()");
        String r13 = r4.getCurrentAction().getParams().get("entity_operation");
        if (r13 == null) goto L63;
        r6 = r13;
    L63:
        r1.title(((Number) SecurityDialogUtil.a(r6).getFirst()).intValue());
        r1.message(2131890725);
        r1.addActionButton(2131391777, 2131890503, x.a);
        goto L92
    L26:
        if (r3 != 32) goto L28;
        ScsLogger.d("SecurityPolicyDialogFragment", "configDeviceOwnershipErrorDialog()");
        r1.title(2131890724);
        r1.autoDismiss(false);
        r1.a(new v(r4));
        r1.addActionButton(2131391778, 2131890503, w.a);
        goto L92
    L28:
        if (r3 != 91) goto L30;
        ScsLogger.d("SecurityPolicyDialogFragment", "configCustomDisplayTNSDialog()");
        Gson r14 = new GsonBuilder().setFieldNamingStrategy(l.a).create();     // Catch: Exception -> L56
        String r15 = r4.getCurrentAction().getParams().get("securityCustomizedContent");     // Catch: Exception -> L56
        if (r15 == null) goto L54;
        r6 = r15;
    L54:
        CustomDisplayTemplate r16 = (CustomDisplayTemplate) r14.fromJson(new String(Base64.decode(r6, 0), Charsets.UTF_8), CustomDisplayTemplate.class);     // Catch: Exception -> L56
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L56
        r1.d(r16, r4);     // Catch: Exception -> L56
    L56:
        e = move-exception;
        int r18 = ScsLogger.a;
        ScsLogger.c("SecurityPolicyDialogFragment", "configCustomDisplayTNSDialog() error: " + e.getMessage());
        FileAuthMonitor.UpdateTrigger[] r19 = FileAuthMonitor.a;
        FileAuthMonitor.e(100, r4.toString());
        goto L92
    L30:
        if (r3 != 92) goto L32;
        ScsLogger.d("SecurityPolicyDialogFragment", "configCustomDisplayPolicyCenterDialog()");
        Object r20 = r4.getInternalParams().get("displayModel");
        if ((r20 instanceof CustomDisplayTemplate) == false) goto L46;
        r7 = (CustomDisplayTemplate) r20;
    L46:
        if (r7 == null) goto L48;
        r1.d(r7, r4);
        goto L92
    L48:
        ScsLogger.c("SecurityPolicyDialogFragment", "template is null");
        FileAuthMonitor.UpdateTrigger[] r21 = FileAuthMonitor.a;
        FileAuthMonitor.e(100, r4.toString());
        S90(r1, r4);
        goto L92
    L32:
        switch(r3) {
            case 21: goto L39;
            case 22: goto L38;
            case 23: goto L37;
            case 24: goto L36;
            default: goto L34;
        };
    L36:
        ScsLogger.d("SecurityPolicyDialogFragment", "configDeviceCertFailDialog()");
        r1.title(2131892726);
        r1.message(2131892743);
        r1.messageGravity(8388611);
        r1.addActionButton(2131391777, 2131890503, q.a);
        goto L92
    L37:
        ScsLogger.d("SecurityPolicyDialogFragment", "configDeviceCertRetryDialog()");
        r1.title(2131892725);
        r1.actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL);
        r1.addActionButton(2131391777, 2131892732, new s(r4));
        r1.addActionButton(2131391778, 2131890466, t.a);
        goto L92
    L38:
        ScsLogger.d("SecurityPolicyDialogFragment", "configDeviceCertSuccessDialog()");
        r1.title(2131890726);
        r1.message(2131892745);
        r1.messageGravity(8388611);
        r1.addActionButton(2131391777, 2131890503, u.a);
        goto L92
    L39:
        ScsLogger.d("SecurityPolicyDialogFragment", "configDeviceCertProcessingDialog()");
        r1.title(2131890729);
        r1.addActionButton(2131391778, 2131890466, r.a);
        goto L92
    L34:
        switch(r3) {
            case 26: goto L42;
            case 27: goto L41;
            case 28: goto L40;
            default: goto L92;
        };
    L40:
        r1.title(2131890291);
        r1.addActionButton(2131391777, 2131890289, m.a);
        goto L92
    L41:
        r1.title(2131890291);
        r1.addActionButton(2131391778, 2131890289, n.a);
        r1.addActionButton(2131391777, 2131890294, new o(r4));
        goto L92
    L42:
        r1.title(2131890290);
        r1.message(2131890293);
        r1.addActionButton(2131391777, 2131890292, p.a);
        goto L92
    L77:
        ScsLogger.d("SecurityPolicyDialogFragment", "configLeaveDeviceDeclarePageHintDialog()");
        r1.title(2131892744);
        r1.message(2131892741);
        r1.messageGravity(8388611);
        r1.actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL);
        r1.addActionButton(2131391777, 2131890503, z.a);
        r1.addActionButton(2131391778, 2131892747, a0.a);
        goto L92
    L95:
        dismiss();     // Catch: Exception -> L87
    L87:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r22 = DialogFragmentLancet.sLastShowStack;
        if (r22 == null) goto L92;
        com.bytedance.crash.d.d(r22, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L92
    L5:
        r1 = new com.ss.android.lark.conditional.access.nopermission.ui.a0(r0);
        goto L7
    }

    public static void S90(com.ss.android.lark.conditional.access.nopermission.ui.q r2, InternalSecurityAction r3) {
        ScsLogger.d("SecurityPolicyDialogFragment", "configNormalDialog()");
        String r4 = r3.getCurrentAction().getParams().get("entity_operation");
        if (r4 != null) goto L5;
        r4 = BuildConfig.FLAVOR;
    L5:
        Pair r5 = SecurityDialogUtil.a(r4);
        r2.title(((Number) r5.getFirst()).intValue());
        r2.message(((Number) r5.getSecond()).intValue());
        r2.messageGravity(8388611);
        r2.addActionButton(2131391777, 2131890503, c0.a);
    }
}
