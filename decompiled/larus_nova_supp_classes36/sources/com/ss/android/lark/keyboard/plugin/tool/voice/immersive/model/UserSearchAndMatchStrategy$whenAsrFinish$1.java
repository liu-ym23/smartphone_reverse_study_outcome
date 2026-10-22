package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$whenAsrFinish$1", f = "UserSearchAndMatchStrategy.kt", i = {0}, l = {134}, m = "invokeSuspend", n = {"updateIfNeed"}, s = {"L$0"})
final class UserSearchAndMatchStrategy$whenAsrFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $afterSearchTaskFinis;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ UserSearchAndMatchStrategy this$0;

    public UserSearchAndMatchStrategy$whenAsrFinish$1(UserSearchAndMatchStrategy r1, Function0<Unit> r2, Continuation<? super UserSearchAndMatchStrategy$whenAsrFinish$1> r3) {
        this.this$0 = r1;
        this.$afterSearchTaskFinis = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        UserSearchAndMatchStrategy$whenAsrFinish$1 r0 = new UserSearchAndMatchStrategy$whenAsrFinish$1(this.this$0, this.$afterSearchTaskFinis, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:31:0x00aa). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$2;
        UserSearchAndMatchStrategy r3 = (UserSearchAndMatchStrategy) this.L$1;
        Function0<Unit> r4 = (Function0) this.L$0;
        ResultKt.throwOnFailure(r11);
        UserSearchAndMatchStrategy$whenAsrFinish$1 r12 = this;
    L31:
        r4.invoke();
    L10:
        if (r2.hasNext() == false) goto L36;
        UserSearchAndMatchStrategy.b r5 = (UserSearchAndMatchStrategy.b) r2.next();
        monitor-enter(r5);
        UserSearchAndMatchStrategy.BaseSearchStrategy r6 = r5.b;     // Catch: Throwable -> L32
        if (r6 == null) goto L17;
        boolean r7 = r6.d();     // Catch: Throwable -> L32
    L18:
        monitor-exit(r5);
        Log.i(r3.i, "[whenAsrFinish]search requestId:" + r5.a.d + " hasSearchFinish:" + r7);
        if (r7 == false) goto L22;
        r4.invoke();
        goto L10
    L22:
        r12.L$0 = r4;
        r12.L$1 = r3;
        r12.L$2 = r2;
        r12.label = 1;
        UserSearchAndMatchStrategy.BaseSearchStrategy r8 = r5.b;
        if (r8 == null) goto L28;
        Object r9 = r8.a(r12);
        if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        r9 = Unit.INSTANCE;
    L29:
        if (r9 != r0) goto L31;
        return r0;
    L28:
        r9 = Unit.INSTANCE;
        goto L29
    L17:
        r7 = false;
    L32:
        th = move-exception;
        throw th;
    L36:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        final CoroutineScope r13 = (CoroutineScope) this.L$0;
        final Ref.IntRef r10 = new Ref.IntRef();
        final UserSearchAndMatchStrategy r14 = this.this$0;
        final Function0<Unit> r15 = this.$afterSearchTaskFinis;
        Function0<Unit> r16 = new UserSearchAndMatchStrategy$whenAsrFinish$1$updateIfNeed$1(r10, r14, r13, r15);
        Collection<UserSearchAndMatchStrategy.b> r17 = this.this$0.j.values();
        r4 = r16;
        r3 = this.this$0;
        r2 = r17.iterator();
        r12 = this;
        goto L10
    }
}
