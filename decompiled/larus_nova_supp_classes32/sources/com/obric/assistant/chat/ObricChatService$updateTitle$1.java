package com.obric.assistant.chat;

import com.larus.platform.api.g0;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
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
import s1a.d;
import u29.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.ObricChatService$updateTitle$1", f = "ObricChatService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricChatService$updateTitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricChatService this$0;

    public ObricChatService$updateTitle$1(ObricChatService r1, Continuation<? super ObricChatService$updateTitle$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricChatService$updateTitle$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r4);
        CopyOnWriteArraySet r5 = this.this$0.d;
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        ComponentFeature r1 = (ComponentFeature) r6.next();
        Intrinsics.checkNotNull(r1);
        a r2 = d.a(r1).getAbility(a.class);
        if (r2 == null) goto L10;
        g0 r3 = r2.C5();
    L11:
        if (r3 == null) goto L6;
        r0.add(r3);
        goto L6
    L10:
        r3 = null;
        goto L11
    L13:
        List r7 = CollectionsKt.distinct(r0);
        FLogger.a.i("ObricChatService", "updateTitle chatTitleCount " + r7.size());
        Iterator r8 = r7.iterator();
    L15:
        if (r8.hasNext() == false) goto L18;
        ((g0) r8.next()).refresh();
        goto L15
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
