package com.larus.community.impl.detail.toptools;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.community.impl.detail.c0;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.e0;
import java.util.Iterator;
import java.util.Set;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.toptools.CreationDetailTopToolsComponent$setCreationPrivacy$1", f = "CreationDetailTopToolsComponent.kt", i = {}, l = {496, 500}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailTopToolsComponent$setCreationPrivacy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $privateStatus;
    int label;
    final /* synthetic */ CreationDetailTopToolsComponent this$0;

    public CreationDetailTopToolsComponent$setCreationPrivacy$1(CreationDetailTopToolsComponent r1, int r2, Continuation<? super CreationDetailTopToolsComponent$setCreationPrivacy$1> r3) {
        this.this$0 = r1;
        this.$privateStatus = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationDetailTopToolsComponent$setCreationPrivacy$1(this.this$0, this.$privateStatus, r4);
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
        String r3 = "";
        boolean r4 = false;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L33:
        Pair r9 = (Pair) r8;
    L34:
        if (r9 != null) goto L36;
    L38:
        if (r4 == false) goto L53;
        t19.s r10 = t19.s.a;
        AppHost.Companion r2 = AppHost.a;
        Application r5 = r2.getApplication();
        String r6 = r2.getApplication().getString(2131900633);
        r10.getClass();
        t19.s.p(r5, r6);
        CreationDetailTopToolsComponent r11 = this.this$0;
        int r7 = CreationDetailTopToolsComponent.w;
        UserCreation r12 = r11.p3();
        if (r12 == null) goto L49;
        Set<zp9.r> r13 = f29.a.a;
        String r14 = r12.a;
        if (r14 == null) goto L45;
        r3 = r14;
    L45:
        Intrinsics.checkNotNullParameter(r3, "creationId");
        Iterator<T> r15 = f29.a.a.iterator();
    L47:
        if (r15.hasNext() == false) goto L49;
        ((zp9.r) r15.next()).X0(r3);
    L49:
        c0 r16 = (c0) this.this$0.o.getValue();
        if (r16 == null) goto L53;
        r16.quit();
    L53:
        return Unit.INSTANCE;
    L36:
        if (((Boolean) r9.getFirst()).booleanValue() != true) goto L38;
        r4 = true;
        goto L38
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L18:
        r9 = (Pair) r8;
        if (r9 != null) goto L21;
    L23:
        boolean r17 = false;
    L24:
        if (r17 == true) goto L34;
        e0 r18 = e0.a;
        CreationDetailTopToolsComponent r20 = this.this$0;
        int r21 = CreationDetailTopToolsComponent.w;
        UserCreation r22 = r20.p3();
        if (r22 == null) goto L29;
        String r23 = r22.a;
        if (r23 == null) goto L29;
    L30:
        int r24 = this.$privateStatus;
        this.label = 2;
        r8 = r18.h(r23, r24, this);
        if (r8 != r0) goto L33;
        return r0;
    L29:
        r23 = "";
        goto L30
    L21:
        if (((Boolean) r9.getFirst()).booleanValue() != true) goto L23;
        r17 = true;
        goto L24
    L10:
        ResultKt.throwOnFailure(r8);
        e0 r25 = e0.a;
        CreationDetailTopToolsComponent r26 = this.this$0;
        int r27 = CreationDetailTopToolsComponent.w;
        UserCreation r28 = r26.p3();
        if (r28 == null) goto L14;
        String r30 = r28.a;
        if (r30 == null) goto L14;
    L15:
        int r31 = this.$privateStatus;
        this.label = 1;
        r8 = r25.h(r30, r31, this);
        if (r8 != r0) goto L18;
        return r0;
    L14:
        r30 = "";
        goto L15
    }
}
