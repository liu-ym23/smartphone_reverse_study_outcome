package com.larus.community.impl.detail.toptools;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.ICommunityService;
import com.larus.community.impl.detail.c0;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.e0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.e2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.toptools.CreationDetailTopToolsComponent$deleteCreation$1", f = "CreationDetailTopToolsComponent.kt", i = {}, l = {532}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailTopToolsComponent$deleteCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationDetailTopToolsComponent this$0;

    public CreationDetailTopToolsComponent$deleteCreation$1(CreationDetailTopToolsComponent r1, Continuation<? super CreationDetailTopToolsComponent$deleteCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDetailTopToolsComponent$deleteCreation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L68:
        Pair r16 = (Pair) r15;
        if (r16 != null) goto L71;
    L73:
        if (r2 == false) goto L78;
        t19.s r17 = t19.s.a;
        AppHost.Companion r3 = AppHost.a;
        Application r4 = r3.getApplication();
        String r5 = r3.getApplication().getString(2131900648);
        r17.getClass();
        t19.s.p(r4, r5);
        CreationDetailTopToolsComponent r18 = this.this$0;
        int r6 = CreationDetailTopToolsComponent.w;
        c0 r110 = (c0) r18.o.getValue();
        if (r110 == null) goto L78;
        r110.quit();
    L78:
        return Unit.INSTANCE;
    L71:
        if (((Boolean) r16.getFirst()).booleanValue() != true) goto L73;
        r2 = true;
        goto L73
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CreationDetailTopToolsComponent r7 = this.this$0;
        int r8 = CreationDetailTopToolsComponent.w;
        j29.a r9 = r7.m3();
        if (r9 == null) goto L13;
        zp9.g r10 = r9.a;
        if (r10 == null) goto L13;
        String r11 = r10.h;
    L14:
        j29.a r12 = this.this$0.m3();
        if (r12 == null) goto L19;
        zp9.g r13 = r12.a;
        if (r13 == null) goto L19;
        String r14 = r13.a;
    L20:
        UserCreation r20 = this.this$0.p3();
        if (r20 == null) goto L23;
        String r21 = r20.a;
    L24:
        UserCreation r22 = this.this$0.p3();
        if (r22 == null) goto L27;
        String r23 = zp9.d.d(r22);
    L28:
        UserCreation r24 = this.this$0.p3();
        if (r24 == null) goto L36;
        Integer r25 = r24.d;
        if (r25 == null) goto L36;
        if (r25.intValue() != 2) goto L36;
        boolean r26 = true;
    L37:
        if (r26 == false) goto L39;
        String r27 = "0";
    L40:
        String r111 = r27;
        j29.a r28 = this.this$0.m3();
        if (r28 == null) goto L45;
        zp9.g r30 = r28.a;
        if (r30 == null) goto L45;
        String r112 = r30.j;
    L46:
        e2.a.b(new tx9.u(r11, r14, "1", r21, r23, r111, r112, 1), null, 3);
        ICommunityService.Companion r113 = ICommunityService.a;
        UserCreation r31 = this.this$0.p3();
        if (r31 == null) goto L50;
        String r32 = r31.a;
        if (r32 == null) goto L50;
    L51:
        r113.X0(r32);
        UserCreation r114 = this.this$0.p3();
        if (r114 == null) goto L80;
        String r115 = r114.a;
        if (r115 == null) goto L80;
        e0 r33 = e0.a;
        UserCreation r34 = this.this$0.p3();
        if (r34 == null) goto L64;
        Integer r35 = r34.d;
        if (r35 == null) goto L64;
        if (r35.intValue() != 1) goto L64;
        boolean r36 = true;
    L65:
        this.label = 1;
        r15 = r33.b(r115, r36, this);
        if (r15 != r0) goto L68;
        return r0;
    L64:
        r36 = false;
    L80:
        return Unit.INSTANCE;
    L50:
        r32 = "";
    L45:
        r112 = null;
        goto L46
    L39:
        r27 = "1";
    L36:
        r26 = false;
        goto L37
    L27:
        r23 = null;
        goto L28
    L23:
        r21 = null;
    L19:
        r14 = null;
    L13:
        r11 = null;
        goto L14
    }
}
