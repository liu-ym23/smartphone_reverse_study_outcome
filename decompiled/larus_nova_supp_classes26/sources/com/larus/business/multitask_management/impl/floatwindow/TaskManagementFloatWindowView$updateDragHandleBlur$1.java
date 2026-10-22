package com.larus.business.multitask_management.impl.floatwindow;

import android.graphics.drawable.Drawable;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.floatwindow.TaskManagementFloatWindowView$updateDragHandleBlur$1", f = "TaskManagementFloatWindowView.kt", i = {}, l = {518}, m = "invokeSuspend", n = {}, s = {})
final class TaskManagementFloatWindowView$updateDragHandleBlur$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $blurKey;
    final /* synthetic */ TaskManagementFloatWindowView.b $config;
    final /* synthetic */ long $requestId;
    int label;
    final /* synthetic */ TaskManagementFloatWindowView this$0;

    public TaskManagementFloatWindowView$updateDragHandleBlur$1(long r1, TaskManagementFloatWindowView r3, String r4, TaskManagementFloatWindowView.b r5, Continuation<? super TaskManagementFloatWindowView$updateDragHandleBlur$1> r6) {
        this.$requestId = r1;
        this.this$0 = r3;
        this.$blurKey = r4;
        this.$config = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new TaskManagementFloatWindowView$updateDragHandleBlur$1(this.$requestId, this.this$0, this.$blurKey, this.$config, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 != 0) goto L46;
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Throwable -> L7 CancellationException -> L9
        TaskManagementFloatWindowView$updateDragHandleBlur$1$drawable$1 r5 = new TaskManagementFloatWindowView$updateDragHandleBlur$1$drawable$1(this.$config, this.this$0, null);     // Catch: Throwable -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
        r12 = BuildersKt.withContext(r13, r5, this);     // Catch: Throwable -> L7 CancellationException -> L9
        if (r12 != r3) goto L17;
        return r3;
    L17:
        Drawable r14 = (Drawable) r12;     // Catch: Throwable -> L7 CancellationException -> L9
        long r6 = this.$requestId;     // Catch: Throwable -> L7 CancellationException -> L9
        TaskManagementFloatWindowView r7 = this.this$0;     // Catch: Throwable -> L7 CancellationException -> L9
        long r8 = r7.F;     // Catch: Throwable -> L7 CancellationException -> L9
        if (r6 == r8) goto L24;
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L7 CancellationException -> L9
        if (r6 != r8) goto L23;
        r7.E = null;
        r7.i = null;
    L23:
        return r15;
    L24:
        if (r14 != null) goto L30;
        FLogger.a.e("TaskManagementFloatWindowView", "updateDragHandleBlur bitmap is empty, blurKey: " + this.$blurKey);     // Catch: Throwable -> L7 CancellationException -> L9
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L7 CancellationException -> L9
        long r0 = this.$requestId;
        TaskManagementFloatWindowView r2 = this.this$0;
        if (r0 != r2.F) goto L29;
        r2.E = null;
        r2.i = null;
    L29:
        return r16;
    L30:
        r7.c.setImageDrawable(r14);     // Catch: Throwable -> L7 CancellationException -> L9
        this.this$0.c.setBackgroundColor(0);     // Catch: Throwable -> L7 CancellationException -> L9
        this.this$0.D = this.$blurKey;     // Catch: Throwable -> L7 CancellationException -> L9
        FLogger.a.d("TaskManagementFloatWindowView", "updateDragHandleBlur applied, blurKey: " + this.$blurKey);     // Catch: Throwable -> L7 CancellationException -> L9
        long r1 = this.$requestId;
        TaskManagementFloatWindowView r17 = this.this$0;
        if (r1 != r17.F) goto L39;
    L33:
        r17.E = null;
        r17.i = null;
    L39:
        return Unit.INSTANCE;
    L46:
        if (r4 != 1) goto L12;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L7 CancellationException -> L9
        goto L17
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L41:
        th = move-exception;
        long r9 = this.$requestId;
        TaskManagementFloatWindowView r10 = this.this$0;
        if (r9 != r10.F) goto L45;
        r10.E = null;
        r10.i = null;
    L45:
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L41
    L7:
        th = move-exception;
        FLogger.a.e("TaskManagementFloatWindowView", "updateDragHandleBlur failed, blurKey: " + this.$blurKey + ", error: " + th);     // Catch: Throwable -> L41
        long r11 = this.$requestId;
        r17 = this.this$0;
        if (r11 != r17.F) goto L39;
        goto L33
    }
}
