package com.bytedance.ai.model.clienttool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.clienttool.ClientToolRunner$onPackageInvalid$1", f = "ClientToolRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ClientToolRunner$onPackageInvalid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $packageName;
    int label;

    public ClientToolRunner$onPackageInvalid$1(String r1, Continuation<? super ClientToolRunner$onPackageInvalid$1> r10) {
        this.$packageName = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ClientToolRunner$onPackageInvalid$1(this.$packageName, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        ClientToolRunner r11 = ClientToolRunner.a;
        String r0 = this.$packageName;
        r11.getClass();
        Collection<ClientToolRuntime> r12 = ClientToolRunner.c.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((ClientToolRuntime) r14).d, r0) == false) goto L6;
        r1.add(r14);
        goto L6
    L10:
        Iterator r15 = CollectionsKt.toList(r1).iterator();
    L12:
        if (r15.hasNext() == false) goto L15;
        ClientToolRuntime r16 = (ClientToolRuntime) r15.next();
        ClientToolRunner r17 = ClientToolRunner.a;
        Intrinsics.checkNotNull(r16);
        r17.getClass();
        ClientToolRunner.e(r16, "package invalid");
        goto L12
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
