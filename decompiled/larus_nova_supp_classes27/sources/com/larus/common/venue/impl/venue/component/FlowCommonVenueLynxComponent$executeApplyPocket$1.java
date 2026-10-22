package com.larus.common.venue.impl.venue.component;

import com.larus.common.venue.impl.venue.api.Pocket;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.venue.impl.venue.component.FlowCommonVenueLynxComponent$executeApplyPocket$1", f = "FlowCommonVenueLynxComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowCommonVenueLynxComponent$executeApplyPocket$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $extra;
    final /* synthetic */ boolean $isFromAvatarResult;
    final /* synthetic */ Map<String, Object> $originData;
    int label;
    final /* synthetic */ FlowCommonVenueLynxComponent this$0;

    public FlowCommonVenueLynxComponent$executeApplyPocket$1(Map<String, ? extends Object> r1, FlowCommonVenueLynxComponent r2, Map<String, ? extends Object> r3, boolean r4, Continuation<? super FlowCommonVenueLynxComponent$executeApplyPocket$1> r5) {
        this.$originData = r1;
        this.this$0 = r2;
        this.$extra = r3;
        this.$isFromAvatarResult = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowCommonVenueLynxComponent$executeApplyPocket$1(this.$originData, this.this$0, this.$extra, this.$isFromAvatarResult, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L53;
        ResultKt.throwOnFailure(r12);
        Map<String, Object> r13 = this.$originData;
        FlowCommonVenueLynxComponent r2 = this.this$0;
        Map<String, Object> r3 = this.$extra;
        boolean r4 = this.$isFromAvatarResult;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L35
        Pocket r7 = w09.a.c(r13);     // Catch: Throwable -> L35
        int r8 = FlowCommonVenueLynxComponent.K;     // Catch: Throwable -> L35
        r2.getClass();     // Catch: Throwable -> L35
        FLogger r9 = FLogger.a;     // Catch: Throwable -> L35
        r9.i("FlowCommonVenueComponent", "[clearAlbumClickPocketInfo] finish, currClickPocketInfo = null");     // Catch: Throwable -> L35
        r9.i("FlowCommonVenueComponent", "[executeApplyPocket] pocketId = " + r7.getPocketId() + ", pocketType = " + r7.getPocketType());     // Catch: Throwable -> L35
        Integer r1 = r7.getPocketType();     // Catch: Throwable -> L35
        boolean r10 = true;
        if (r1 != null) goto L9;
    L15:
        if (r1 != null) goto L18;
    L23:
        if (r1 != null) goto L26;
    L28:
        if (r1 != null) goto L31;
    L33:
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        FlowCommonVenueLynxComponent r0 = this.this$0;
        Map<String, Object> r5 = this.$originData;
        if (Result.exceptionOrNull-impl(r14) == null) goto L51;
        int r15 = FlowCommonVenueLynxComponent.K;
        v09.c r16 = r0.Q3();
        if (r16 == null) goto L51;
        Object r11 = r5.get("pocket_id");
        if (r11 == null) goto L45;
        String r17 = r11.toString();
        if (r17 == null) goto L45;
    L46:
        Object r18 = r5.get("pocket_type");
        int r20 = -1;
        if (r18 == null) goto L49;
        r20 = l3.e(r18, -1);
    L49:
        r16.W7(r17, 0, r20, "invalid_data");
    L45:
        r17 = "";
    L51:
        return Unit.INSTANCE;
    L31:
        if (r1.intValue() != 4) goto L33;
        FlowCommonVenueLynxComponent.h3(r2, r7, r13, r3);     // Catch: Throwable -> L35
        goto L33
    L26:
        if (r1.intValue() != 3) goto L28;
        r9.i("FlowCommonVenueComponent", "[pocketUploadInput] pocketUploadInput = " + r7.getUploadInputPocket());     // Catch: Throwable -> L35
        goto L33
    L18:
        if (r1.intValue() != 2) goto L23;
        if (r4 == true) goto L22;
        r10 = false;
    L22:
        FlowCommonVenueLynxComponent.m3(r2, r7, r13, r3, r10);     // Catch: Throwable -> L35
        goto L33
    L9:
        if (r1.intValue() != 1) goto L15;
        r2.z3();     // Catch: Throwable -> L35
        if (r4 == true) goto L14;
        r10 = false;
    L14:
        FlowCommonVenueLynxComponent.p3(r2, r7, r13, r3, r10);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L53:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
