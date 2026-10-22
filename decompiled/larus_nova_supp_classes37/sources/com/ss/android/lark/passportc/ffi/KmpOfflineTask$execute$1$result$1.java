package com.ss.android.lark.passportc.ffi;

import com.lark.kmp.basic.Scene;
import com.lark.kmp.impl.CompositeTask;
import com.ss.android.lark.picker.base.view.ItemViewType;
import gy7.k;
import gy7.o;
import gy7.p;
import gy7.q;
import gy7.s;
import gy7.w;
import j0c.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lark/kmp/basic/TaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passportc.ffi.KmpOfflineTask$execute$1$result$1", f = "KmpOfflineTask.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class KmpOfflineTask$execute$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o>, Object> {
    final /* synthetic */ e $context;
    final /* synthetic */ w $taskExecutor;
    final /* synthetic */ p $userPayload;
    final /* synthetic */ q $userSession;
    int label;

    public KmpOfflineTask$execute$1$result$1(w r1, q r2, p r3, e r4, Continuation<? super KmpOfflineTask$execute$1$result$1> r5) {
        this.$taskExecutor = r1;
        this.$userSession = r2;
        this.$userPayload = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new KmpOfflineTask$execute$1$result$1(this.$taskExecutor, this.$userSession, this.$userPayload, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super o> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L20:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        w r8 = this.$taskExecutor;
        q r2 = this.$userSession;
        p r3 = this.$userPayload;
        int r4 = b.a;
        Scene r5 = b.a(this.$context.b);
        this.label = 1;
        r8.getClass();
        ArrayList r6 = new ArrayList();
        r6.addAll(r8.a.b(Reflection.getOrCreateKotlinClass(k.class)));
        q r9 = s.a(r2);
        if (r9 == null) goto L12;
        r2 = r9;
    L12:
        Map r10 = com.lark.kmp.containerization.a.a;
        com.lark.kmp.containerization.b r11 = com.lark.kmp.containerization.a.a(iy7.b.b).a(r2);
        if (r11 == null) goto L17;
        List r12 = r11.b(Reflection.getOrCreateKotlinClass(k.class));
        if (r12 == null) goto L17;
        r6.addAll(r12);
    L17:
        r7 = new CompositeTask(r6).a(r3, r5, this);
        if (r7 != r0) goto L20;
        return r0;
    }
}
