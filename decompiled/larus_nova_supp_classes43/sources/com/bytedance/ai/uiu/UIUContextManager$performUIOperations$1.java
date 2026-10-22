package com.bytedance.ai.uiu;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$performUIOperations$1", f = "UIUContextManager.kt", i = {0, 0, 0}, l = {151}, m = "invokeSuspend", n = {AIStateLogRequest.SOURCE_PAGE, "atomResult", "uiOperation"}, s = {"L$1", "L$2", "L$4"})
final class UIUContextManager$performUIOperations$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ List<u5.a> $uiOperations;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public UIUContextManager$performUIOperations$1(Function1<? super Boolean, Unit> r1, List<u5.a> r10, Continuation<? super UIUContextManager$performUIOperations$1> r11) {
        this.$callback = r1;
        this.$uiOperations = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UIUContextManager$performUIOperations$1(this.$callback, this.$uiOperations, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0096 -> B:21:0x00a0). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        boolean r10 = this.Z$0;
        Ref.BooleanRef r11 = (Ref.BooleanRef) this.L$5;
        u5.a r13 = (u5.a) this.L$4;
        Iterator r14 = (Iterator) this.L$3;
        Ref.BooleanRef r15 = (Ref.BooleanRef) this.L$2;
        com.bytedance.ai.model.widgets.c r16 = (com.bytedance.ai.model.widgets.c) this.L$1;
        Function1<Boolean, Unit> r17 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r12);
        Function1<Boolean, Unit> r18 = r17;
        com.bytedance.ai.model.widgets.c r19 = r16;
        Iterator r20 = r14;
        u5.a r21 = r13;
        Ref.BooleanRef r22 = r11;
        boolean r23 = r10;
        Object r24 = r0;
        UIUContextManager$performUIOperations$1 r25 = this;
    L21:
        r22.element = ((Boolean) r12).booleanValue() & r23;
        if (r15.element == true) goto L24;
        com.bytedance.ai.utils.g.a.d(a.b, "TopPage performUiOperations error for:" + r21);
    L24:
        UIUContextManager$performUIOperations$1 r110 = r25;
        r0 = r24;
        Ref.BooleanRef r26 = r15;
        Iterator r27 = r20;
        com.bytedance.ai.model.widgets.c r28 = r19;
        Function1<Boolean, Unit> r29 = r18;
    L12:
        if (r27.hasNext() == false) goto L25;
        u5.a r30 = (u5.a) r27.next();
        boolean r31 = r26.element;
        a r32 = a.a;
        View r33 = r28.engineView();
        if ((r33 instanceof WebView) == false) goto L16;
        WebView r34 = (WebView) r33;
    L17:
        List r111 = CollectionsKt.listOf(r30);
        r110.L$0 = r29;
        r110.L$1 = r28;
        r110.L$2 = r26;
        r110.L$3 = r27;
        r110.L$4 = r30;
        r110.L$5 = r26;
        r110.Z$0 = r31;
        r110.label = 1;
        Object r35 = a.d(r32, r34, r111, r110);
        if (r35 != r0) goto L20;
        return r0;
    L20:
        r18 = r29;
        r19 = r28;
        r20 = r27;
        r21 = r30;
        r22 = r26;
        r23 = r31;
        r24 = r0;
        r25 = r110;
        r12 = r35;
        r15 = r22;
        goto L21
    L16:
        r34 = null;
        goto L17
    L25:
        Unit r112 = Unit.INSTANCE;
        r29.invoke(Boxing.boxBoolean(r26.element));
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        AppletRuntimeManager.INSTANCE.getClass();
        com.bytedance.ai.model.widgets.c r113 = AppletRuntimeManager.c();
        if (r113 == null) goto L26;
        List<u5.a> r36 = this.$uiOperations;
        Function1<Boolean, Unit> r37 = this.$callback;
        Ref.BooleanRef r38 = new Ref.BooleanRef();
        r38.element = true;
        r28 = r113;
        r27 = r36.iterator();
        r29 = r37;
        r26 = r38;
        r110 = this;
        goto L12
    L26:
        this.$callback.invoke(Boxing.boxBoolean(false));
        goto L28
    }
}
