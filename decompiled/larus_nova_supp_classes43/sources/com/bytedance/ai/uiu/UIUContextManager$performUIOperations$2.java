package com.bytedance.ai.uiu;

import android.webkit.WebView;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.widget.WidgetManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$performUIOperations$2", f = "UIUContextManager.kt", i = {0, 0, 0}, l = {196}, m = "invokeSuspend", n = {"webView", "atomResult", "uiOperation"}, s = {"L$0", "L$3", "L$5"})
final class UIUContextManager$performUIOperations$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $cardId;
    final /* synthetic */ List<u5.a> $uiOperations;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public UIUContextManager$performUIOperations$2(Function1<? super Boolean, Unit> r1, String r10, List<u5.a> r11, Continuation<? super UIUContextManager$performUIOperations$2> r12) {
        this.$callback = r1;
        this.$cardId = r10;
        this.$uiOperations = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UIUContextManager$performUIOperations$2(this.$callback, this.$cardId, this.$uiOperations, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0106 -> B:36:0x0111). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        boolean r10 = this.Z$0;
        Ref.BooleanRef r11 = (Ref.BooleanRef) this.L$6;
        u5.a r12 = (u5.a) this.L$5;
        Iterator r14 = (Iterator) this.L$4;
        Ref.BooleanRef r15 = (Ref.BooleanRef) this.L$3;
        Function1<Boolean, Unit> r16 = (Function1) this.L$2;
        String r17 = (String) this.L$1;
        WebView r18 = (WebView) this.L$0;
        ResultKt.throwOnFailure(r13);
        WebView r19 = r18;
        String r20 = r17;
        Function1<Boolean, Unit> r21 = r16;
        Iterator r22 = r14;
        u5.a r23 = r12;
        Ref.BooleanRef r24 = r11;
        boolean r25 = r10;
        Object r26 = r0;
        UIUContextManager$performUIOperations$2 r27 = this;
    L36:
        r24.element = ((Boolean) r13).booleanValue() & r25;
        if (r15.element == true) goto L39;
        com.bytedance.ai.utils.g.a.d(a.b, "Page " + r20 + " performUiOperations error: " + r23);
    L39:
        UIUContextManager$performUIOperations$2 r110 = r27;
        r0 = r26;
        Ref.BooleanRef r28 = r15;
        Iterator r29 = r22;
        Function1<Boolean, Unit> r30 = r21;
        String r31 = r20;
        WebView r32 = r19;
    L31:
        if (r29.hasNext() == false) goto L40;
        u5.a r33 = (u5.a) r29.next();
        boolean r34 = r28.element;
        a r35 = a.a;
        List r111 = CollectionsKt.listOf(r33);
        r110.L$0 = r32;
        r110.L$1 = r31;
        r110.L$2 = r30;
        r110.L$3 = r28;
        r110.L$4 = r29;
        r110.L$5 = r33;
        r110.L$6 = r28;
        r110.Z$0 = r34;
        r110.label = 1;
        Object r36 = a.d(r35, r32, r111, r110);
        if (r36 != r0) goto L35;
        return r0;
    L35:
        r19 = r32;
        r20 = r31;
        r21 = r30;
        r22 = r29;
        r23 = r33;
        r24 = r28;
        r25 = r34;
        r26 = r0;
        r27 = r110;
        r13 = r36;
        r15 = r24;
        goto L36
    L40:
        Unit r112 = Unit.INSTANCE;
        r30.invoke(Boxing.boxBoolean(r28.element));
    L43:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        AppletRuntimeManager.INSTANCE.getClass();
        LinkedHashMap<String, com.bytedance.ai.model.widgets.c> r113 = AppletRuntimeManager.b;
        WidgetManager r37 = WidgetManager.h.b();
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type com.bytedance.ai.widget.WidgetManager");
        Set r114 = CollectionsKt.union(r113.values(), r37.a.keySet());
        String r38 = this.$cardId;
        Iterator r115 = r114.iterator();
    L9:
        WebView r39 = null;
        if (r115.hasNext() == false) goto L24;
        Object r40 = r115.next();
        k2.i r41 = (k2.i) r40;
        a r42 = a.a;
        if ((r41 instanceof k2.j) == false) goto L19;
        k2.j r43 = (k2.j) r41;
        if (Intrinsics.areEqual(r43.getPageInfo().getMessageId(), r38) == false) goto L16;
    L17:
        boolean r44 = true;
    L22:
        if (r44 == false) goto L9;
    L25:
        k2.i r45 = (k2.i) r40;
        if (r45 == null) goto L28;
        r39 = a.c(r45);
    L28:
        if (r39 == null) goto L41;
        List<u5.a> r116 = this.$uiOperations;
        String r46 = this.$cardId;
        Function1<Boolean, Unit> r47 = this.$callback;
        Ref.BooleanRef r48 = new Ref.BooleanRef();
        r48.element = true;
        r31 = r46;
        r30 = r47;
        r28 = r48;
        r32 = r39;
        r29 = r116.iterator();
        r110 = this;
        goto L31
    L41:
        this.$callback.invoke(Boxing.boxBoolean(false));
        goto L43
    L16:
        if (Intrinsics.areEqual(r43.getPageInfo().getPageId(), r38) == true) goto L17;
    L21:
        r44 = false;
        goto L22
    L19:
        if ((r41 instanceof WidgetContainer) == false) goto L21;
        r44 = Intrinsics.areEqual(((WidgetContainer) r41).f, r38);
        goto L22
    L24:
        r40 = null;
        goto L25
    }
}
