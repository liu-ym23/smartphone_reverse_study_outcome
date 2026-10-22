package com.larus.bmhome.instruction;

import android.os.Bundle;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionLogicComponent$handleOpenSchema$1", f = "InstructionLogicComponent.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
final class InstructionLogicComponent$handleOpenSchema$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $actionBarItem;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $schemaUrl;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.InstructionLogicComponent$handleOpenSchema$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.instruction.InstructionLogicComponent$handleOpenSchema$1$1", f = "InstructionLogicComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $actionBarItem;
        final /* synthetic */ Bundle $bundle;
        final /* synthetic */ String $schemaUrl;
        int label;

        public AnonymousClass1(String r1, com.larus.bmhome.actionbar.model.z0 r2, Bundle r3, Continuation<? super AnonymousClass1> r4) {
            this.$schemaUrl = r1;
            this.$actionBarItem = r2;
            this.$bundle = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$schemaUrl, this.$actionBarItem, this.$bundle, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r5);
            Iterator<com.larus.bmhome.view.actionbar.custom.router.b> r6 = com.larus.bmhome.view.actionbar.custom.router.c.a.iterator();
        L6:
            if (r6.hasNext() == false) goto L12;
            com.larus.bmhome.view.actionbar.custom.router.b r0 = r6.next();
            if (r0.b(this.$schemaUrl) == false) goto L6;
            if (r0.a(null, this.$schemaUrl, this.$bundle) == false) goto L6;
        L12:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public InstructionLogicComponent$handleOpenSchema$1(String r1, com.larus.bmhome.actionbar.model.z0 r2, Bundle r3, Continuation<? super InstructionLogicComponent$handleOpenSchema$1> r4) {
        this.$schemaUrl = r1;
        this.$actionBarItem = r2;
        this.$bundle = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new InstructionLogicComponent$handleOpenSchema$1(this.$schemaUrl, this.$actionBarItem, this.$bundle, r5);
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
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$schemaUrl, this.$actionBarItem, this.$bundle, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L12;
        return r0;
    }
}
