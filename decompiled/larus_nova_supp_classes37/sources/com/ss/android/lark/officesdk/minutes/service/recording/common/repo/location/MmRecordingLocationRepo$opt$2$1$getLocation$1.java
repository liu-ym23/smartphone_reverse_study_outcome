package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.IOfficeSDKAuthorizeService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$opt$2$1$getLocation$1", f = "MmRecordingLocationRepo.kt", i = {0, 0, 1, 1}, l = {115, 139, 151}, m = "invokeSuspend", n = {"authorizeService", "scope", "authorizeService", "hasSystemPermission"}, s = {"L$0", "L$1", "L$0", "Z$0"})
public final class MmRecordingLocationRepo$opt$2$1$getLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingLocationRepo this$0;
    final /* synthetic */ MmRecordingLocationRepo$opt$2.AnonymousClass1 this$1;

    public MmRecordingLocationRepo$opt$2$1$getLocation$1(MmRecordingLocationRepo r1, MmRecordingLocationRepo$opt$2.AnonymousClass1 r2, Continuation<? super MmRecordingLocationRepo$opt$2$1$getLocation$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingLocationRepo$opt$2$1$getLocation$1(this.this$0, this.this$1, r4);
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
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r13);
    L49:
        IOfficeSDKAuthorizeService.a r14 = (IOfficeSDKAuthorizeService.a) r13;
        if (r14.a == true) goto L53;
        lvb.a.e(this.this$0.l, "[getLocation] system permission denied: " + r14.b);
        return Unit.INSTANCE;
    L53:
        MmRecordingLocationRepo r15 = this.this$0;
        int r2 = MmRecordingLocationRepo.s;
        r15.getClass();
        MmRecordingLocationRepo$opt$2.AnonymousClass1.T0(this.this$1);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        boolean r3 = this.Z$0;
        IOfficeSDKAuthorizeService r4 = (IOfficeSDKAuthorizeService) this.L$0;
        ResultKt.throwOnFailure(r13);
    L37:
        IOfficeSDKAuthorizeService.a r16 = (IOfficeSDKAuthorizeService.a) r13;
        if (r16.a == true) goto L44;
        lvb.a.e(this.this$0.l, "[getLocation] applet permission denied: " + r16.b);
        if (Intrinsics.areEqual(r16.b, "applet_permission_denied") == false) goto L43;
        this.this$0.k.H().putBoolean("mm_recording_key_location_permission_denied", true);
    L43:
        return Unit.INSTANCE;
    L44:
        boolean r8 = r3;
        IOfficeSDKAuthorizeService r7 = r4;
    L45:
        if (r8 == true) goto L53;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        r13 = r7.e0(null, this);
        if (r13 != r0) goto L49;
        return r0;
    L11:
        IOfficeSDKAuthorizeService.Scope r5 = (IOfficeSDKAuthorizeService.Scope) this.L$1;
        r7 = (IOfficeSDKAuthorizeService) this.L$0;
        ResultKt.throwOnFailure(r13);
    L20:
        boolean r17 = ((Boolean) r13).booleanValue();
        r8 = r7.Q0();
        if (r17 == false) goto L25;
        if (r8 == false) goto L25;
        lvb.a.e(this.this$0.l, "[getLocation] both permissions granted, get location directly");
        this.this$0.getClass();
        MmRecordingLocationRepo$opt$2.AnonymousClass1.T0(this.this$1);
        return Unit.INSTANCE;
    L25:
        boolean r10 = false;
        boolean r9 = this.this$0.k.H().getBoolean("mm_recording_key_location_permission_denied", false);
        if (r17 == true) goto L29;
        if (r9 == false) goto L29;
        r10 = true;
    L29:
        if (r10 == false) goto L32;
        lvb.a.e(this.this$0.l, "[getLocation] applet permission permanently denied, skip");
        return Unit.INSTANCE;
    L32:
        if (r17 == true) goto L45;
        this.L$0 = r7;
        this.L$1 = null;
        this.Z$0 = r8;
        this.label = 2;
        r13 = r7.c1(r5, this);
        if (r13 != r0) goto L36;
        return r0;
    L36:
        r4 = r7;
        r3 = r8;
        goto L37
    L12:
        ResultKt.throwOnFailure(r13);
        IOfficeSDKAuthorizeService r18 = (IOfficeSDKAuthorizeService) this.this$0.k.u(IOfficeSDKAuthorizeService.class);
        if (r18 != null) goto L16;
        lvb.a.b(this.this$0.l, "[getLocation] authorizeService is null, authorize failed");
        return Unit.INSTANCE;
    L16:
        r5 = IOfficeSDKAuthorizeService.Scope.USER_LOCATION;
        this.L$0 = r18;
        this.L$1 = r5;
        this.label = 1;
        Object r11 = r18.S1(r5, this);
        if (r11 != r0) goto L19;
        return r0;
    L19:
        r7 = r18;
        r13 = r11;
        goto L20
    }
}
