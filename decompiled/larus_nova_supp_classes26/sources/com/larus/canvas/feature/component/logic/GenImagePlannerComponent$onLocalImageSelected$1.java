package com.larus.canvas.feature.component.logic;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$onLocalImageSelected$1", f = "GenImagePlannerComponent.kt", i = {}, l = {534}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$onLocalImageSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.j $imageInfo;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$onLocalImageSelected$1(ky8.j r1, GenImagePlannerComponent r2, Continuation<? super GenImagePlannerComponent$onLocalImageSelected$1> r3) {
        this.$imageInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GenImagePlannerComponent$onLocalImageSelected$1(this.$imageInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L44:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        if (com.larus.utils.o0.d(this.$imageInfo.a) == false) goto L20;
        Integer r12 = this.$imageInfo.d;
        int r2 = 0;
        if (r12 == null) goto L13;
        int r13 = r12.intValue();
    L14:
        if (r13 <= 0) goto L20;
        Integer r14 = this.$imageInfo.c;
        if (r14 == null) goto L18;
        r2 = r14.intValue();
    L18:
        if (r2 <= 0) goto L20;
        StateFlowImpl r15 = this.this$0.m;
        final ky8.j r3 = this.$imageInfo;
        com.larus.canvas.feature.component.logic.helper.f.a(r15, new n1(r3));
        goto L44
    L13:
        r13 = 0;
    L20:
        String r16 = this.$imageInfo.e;
        if (r16 != null) goto L23;
        r16 = "";
    L23:
        String r17 = UriProtector.parse(com.larus.canvas.feature.component.logic.helper.a.a(r16)).getPath();
        if (r17 != null) goto L26;
        r17 = "";
    L26:
        Intrinsics.checkNotNullParameter(r17, "filePath");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L29
        Uri r18 = Uri.fromFile(new PolarisFileWrapper(r17));     // Catch: Throwable -> L29
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L29
        Object r19 = Result.constructor-impl(com.larus.canvas.feature.component.logic.helper.g.c(r18));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r19) == false) goto L34;
        r19 = null;
    L34:
        final Pair r110 = (Pair) r19;
        final GenImagePlannerComponent r5 = this.this$0;
        StateFlowImpl r6 = r5.m;
        final ky8.j r7 = this.$imageInfo;
        com.larus.canvas.feature.component.logic.helper.f.a(r6, new o1(r5, r110, r7));
        String r111 = this.$imageInfo.e;
        if (r111 != null) goto L37;
        r111 = "";
    L37:
        GenImagePlannerComponent r8 = this.this$0;
        com.larus.bmhome.resource.access.j0.b r9 = new com.larus.bmhome.resource.access.j0.b(r111, null, null, null, 30);
        this.label = 1;
        Object r112 = r8.V4(r111, r9, null, true, this);
        if (r112 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        r112 = Unit.INSTANCE;
    L41:
        if (r112 != r0) goto L44;
        return r0;
    L29:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }
}
