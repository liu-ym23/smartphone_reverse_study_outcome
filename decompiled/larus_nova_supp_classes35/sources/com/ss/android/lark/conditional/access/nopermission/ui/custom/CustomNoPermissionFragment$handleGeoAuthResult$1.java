package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.endpoint.security.detection.factor.EndpointSecurityFactorReportError;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomNoPermissionFragment$handleGeoAuthResult$1", f = "CustomNoPermissionFragment.kt", i = {}, l = {1796}, m = "invokeSuspend", n = {}, s = {})
final class CustomNoPermissionFragment$handleGeoAuthResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $durationMs;
    final /* synthetic */ Object $result;
    Object L$0;
    int label;
    final /* synthetic */ CustomNoPermissionFragment this$0;

    public CustomNoPermissionFragment$handleGeoAuthResult$1(Object r1, long r2, CustomNoPermissionFragment r4, Continuation<? super CustomNoPermissionFragment$handleGeoAuthResult$1> r5) {
        this.$result = r1;
        this.$durationMs = r2;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CustomNoPermissionFragment$handleGeoAuthResult$1(this.$result, this.$durationMs, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CustomNoPermissionFragment r2 = (CustomNoPermissionFragment) this.L$0;
        ResultKt.throwOnFailure(r13);
    L15:
        if (r2.isAdded() == false) goto L17;
        r2.aa0("geoAuth");
    L81:
        return Unit.INSTANCE;
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        Object r14 = this.$result;
        long r8 = this.$durationMs;
        CustomNoPermissionFragment r3 = this.this$0;
        Throwable r11 = Result.exceptionOrNull-impl(r14);
        if (r11 != null) goto L19;
        ((scb.a) r14).getClass();
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "onGeoAuthButtonClick: report success");
        int r15 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.e("geo_auth", true, 0, "ok", r8, r3.i);
        this.L$0 = r3;
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L13;
        return r0;
    L13:
        r2 = r3;
        goto L15
    L19:
        int r16 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_CustomNoPermissionFragment", "onGeoAuthButtonClick: report failed: " + r11.getMessage());
        int r17 = com.ss.android.lark.conditional.access.utils.a.a;
        boolean r18 = r11 instanceof EndpointSecurityFactorReportError.LocationPermissionDenied;
        if (r18 == false) goto L24;
        String r4 = "perm_denied";
    L33:
        com.ss.android.lark.conditional.access.utils.a.e("geo_auth", false, -1, r4, r8, r3.i);
        if (r18 == true) goto L81;
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationPermissionDeniedBefore) == false) goto L42;
        if (r3.isAdded() == false) goto L81;
        new UDDialogBuilder(r3.requireContext()).title(2131890254).message(UIHelper.mustacheFormat(2131890252, "APP_DISPLAY_NAME", UIHelper.getAppName())).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).addActionButton(2131391778, 2131890466, new u(r3)).addActionButton(2131391777, 2131890258, new v(r3)).show();
        com.ss.android.lark.conditional.access.utils.a.d("show", r3.i);
        goto L81
    L42:
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationServicesDisabled) == true) goto L44;
        Object r19 = Result.constructor-impl(Boolean.valueOf(w4c.c.a().F()));     // Catch: Throwable -> L49
    L51:
        Boolean r5 = Boolean.TRUE;
        if (Result.isFailure-impl(r19) == false) goto L54;
        r19 = r5;
    L54:
        int r6 = 2131890269;
        if (((Boolean) r19).booleanValue() == false) goto L78;
        r3.requireContext();
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationRiskOfFakeLocation) == false) goto L59;
    L76:
        r6 = 2131890264;
    L77:
        String r110 = UIHelper.mustacheFormat(r6, "APP_DISPLAY_NAME", UIHelper.getAppName());
    L79:
        UDToast.show(r3.requireContext(), r110, 2131255144);
        goto L81
    L59:
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationUnknown) == true) goto L76;
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationAdminDisabledGPS) == false) goto L65;
        r6 = 2131890267;
        goto L77
    L65:
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationPSDARestricted) == false) goto L68;
        r6 = 2131890256;
        goto L77
    L68:
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationNotAuthorizedAlways) == false) goto L71;
        r6 = 2131890262;
        goto L77
    L71:
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationTimeout) == false) goto L74;
        r6 = 2131890263;
        goto L77
    L74:
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationNetwork) == false) goto L77;
        r6 = 2131890266;
        goto L77
    L78:
        r110 = r3.requireContext().getString(2131890269);
        Intrinsics.checkNotNull(r110);
    L49:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L44:
        if (r3.isAdded() == false) goto L81;
        new UDDialogBuilder(r3.requireContext()).title(2131890254).message(r3.getString(2131890253)).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).addActionButton(2131391778, 2131890466, new w(r3)).addActionButton(2131391777, 2131890258, new x(r3)).show();
        com.ss.android.lark.conditional.access.utils.a.d("show", r3.i);
        goto L81
    L24:
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationPermissionDeniedBefore) == false) goto L27;
        r4 = "perm_denied_before";
        goto L33
    L27:
        if ((r11 instanceof EndpointSecurityFactorReportError.LocationServicesDisabled) == false) goto L30;
        r4 = "location_services_disabled";
        goto L33
    L30:
        if ((r11 instanceof EndpointSecurityFactorReportError.PayloadEncodeFailed) == false) goto L32;
        r4 = "payload_encode_failed";
        goto L33
    L32:
        r4 = "system_error";
        goto L33
    }
}
