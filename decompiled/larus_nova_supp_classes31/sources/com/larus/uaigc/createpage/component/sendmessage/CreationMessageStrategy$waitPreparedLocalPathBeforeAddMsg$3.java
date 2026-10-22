package com.larus.uaigc.createpage.component.sendmessage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/resource/access/ResourceAccessState;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.sendmessage.CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$3", f = "CreationMessageStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$3 extends SuspendLambda implements Function2<com.larus.bmhome.resource.access.a0, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $preparedPath;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationMessageStrategy this$0;

    public CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$3(Ref.ObjectRef<String> r1, CreationMessageStrategy r2, Continuation<? super CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$3> r3) {
        this.$preparedPath = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$3 r0 = new CreationMessageStrategy$waitPreparedLocalPathBeforeAddMsg$3(this.$preparedPath, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(com.larus.bmhome.resource.access.a0 r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.bmhome.resource.access.a0) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L46;
        ResultKt.throwOnFailure(r5);
        com.larus.bmhome.resource.access.a0.e r6 = (com.larus.bmhome.resource.access.a0) this.L$0;
        Ref.ObjectRef<String> r0 = this.$preparedPath;
        CreationMessageStrategy r1 = this.this$0;
        int r2 = CreationMessageStrategy.e;
        r1.getClass();
        String r3 = null;
        if ((r6 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L15;
        com.larus.bmhome.resource.access.j0.b r4 = r6.c;
        if ((r4 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L9;
        com.larus.bmhome.resource.access.j0.b r7 = r4;
    L10:
        if (r7 == null) goto L12;
        r3 = r7.b;
    L12:
        if (r3 == null) goto L35;
    L36:
        r0.element = CreationMessageStrategy.v(r3);
        if (this.$preparedPath.element == null) goto L39;
    L42:
        boolean r8 = true;
    L44:
        return Boxing.boxBoolean(r8);
    L39:
        if (com.larus.bmhome.resource.access.s.b(r6) == true) goto L42;
        r8 = false;
    L35:
        r3 = "";
        goto L36
    L9:
        r7 = null;
        goto L10
    L15:
        if ((r6 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L25;
        com.larus.bmhome.resource.access.j0.b r9 = ((com.larus.bmhome.resource.access.a0.d) r6).a.b;
        if ((r9 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L19;
        com.larus.bmhome.resource.access.j0.b r10 = r9;
    L20:
        if (r10 == null) goto L22;
        r3 = r10.b;
    L22:
        if (r3 != null) goto L36;
    L19:
        r10 = null;
        goto L20
    L25:
        if (Intrinsics.areEqual(r6, com.larus.bmhome.resource.access.a0.b.a) == true) goto L35;
        if ((r6 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L35;
        if ((r6 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L35;
        if ((r6 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L35;
        throw new NoWhenBranchMatchedException();
    L46:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
