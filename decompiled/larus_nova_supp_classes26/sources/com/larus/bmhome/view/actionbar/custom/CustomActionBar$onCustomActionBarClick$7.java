package com.larus.bmhome.view.actionbar.custom;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$7", f = "CustomActionBar.kt", i = {}, l = {1691, 1701}, m = "invokeSuspend", n = {}, s = {})
public final class CustomActionBar$onCustomActionBarClick$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bizArgs;
    final /* synthetic */ aq8.e $instructionExtraData;
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
    final /* synthetic */ int $openFrom;
    int label;
    final /* synthetic */ CustomActionBar this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$7$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$onCustomActionBarClick$7$2", f = "CustomActionBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $bizArgs;
        final /* synthetic */ aq8.e $instructionExtraData;
        final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
        final /* synthetic */ int $openFrom;
        int label;
        final /* synthetic */ CustomActionBar this$0;

        public AnonymousClass2(CustomActionBar r1, com.larus.bmhome.actionbar.model.z0 r2, int r3, aq8.e r4, Bundle r5, Continuation<? super AnonymousClass2> r6) {
            this.this$0 = r1;
            this.$item = r2;
            this.$openFrom = r3;
            this.$instructionExtraData = r4;
            this.$bizArgs = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass2(this.this$0, this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            CustomActionBar.r(this.this$0, this.$item, null, this.$openFrom, null, this.$instructionExtraData, this.$bizArgs, 8);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CustomActionBar$onCustomActionBarClick$7(com.larus.bmhome.actionbar.model.z0 r1, CustomActionBar r2, int r3, aq8.e r4, Bundle r5, Continuation<? super CustomActionBar$onCustomActionBarClick$7> r6) {
        this.$item = r1;
        this.this$0 = r2;
        this.$openFrom = r3;
        this.$instructionExtraData = r4;
        this.$bizArgs = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CustomActionBar$onCustomActionBarClick$7(this.$item, this.this$0, this.$openFrom, this.$instructionExtraData, this.$bizArgs, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L34:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L28
    L23:
        boolean r13 = ((Boolean) r12).booleanValue();     // Catch: Throwable -> L28
    L25:
        if (r13 == true) goto L30;
        FLogger.a.d("CustomActionBar", "reject jump! check remote conv failed!");     // Catch: Throwable -> L28
        return Unit.INSTANCE;
    L30:
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        AnonymousClass2 r2 = new AnonymousClass2(this.this$0, this.$item, this.$openFrom, this.$instructionExtraData, this.$bizArgs, null);
        this.label = 2;
        if (BuildersKt.withContext(r14, r2, this) != r0) goto L34;
        return r0;
    L11:
        ResultKt.throwOnFailure(r12);
        com.larus.bmhome.actionbar.model.e0 r15 = this.$item.m;     // Catch: Throwable -> L28
        if (r15 == null) goto L30;
        String r16 = r15.a;     // Catch: Throwable -> L28
        if (r16 == null) goto L30;
        CustomActionBar r3 = this.this$0;     // Catch: Throwable -> L28
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r16), "force_create_coo_sub"), "true") == false) goto L30;
        CustomActionBarViewModel r17 = r3.o;     // Catch: Throwable -> L28
        if (r17 == null) goto L24;
        this.label = 1;     // Catch: Throwable -> L28
        r12 = r17.checkCoCoCOnvRemote(this);     // Catch: Throwable -> L28
        if (r12 != r0) goto L23;
        return r0;
    L24:
        r13 = false;
    L28:
        th = move-exception;
        FLogger.a.e("CustomActionBar", "check schema err! msg=" + th.getMessage());
        goto L30
    }
}
