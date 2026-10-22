package com.larksuite.component.card.resources;

import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.resources.CardResourceServiceImpl$preloadResources$1", f = "CardResourceServiceImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class CardResourceServiceImpl$preloadResources$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardData $cardData;
    int label;
    final /* synthetic */ CardResourceServiceImpl this$0;

    public CardResourceServiceImpl$preloadResources$1(CardResourceServiceImpl r1, CardData r2, Continuation<? super CardResourceServiceImpl$preloadResources$1> r3) {
        this.this$0 = r1;
        this.$cardData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CardResourceServiceImpl$preloadResources$1(this.this$0, this.$cardData, r4);
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
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
    L23:
    L22:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r8);
        CardResourceServiceImpl r9 = this.this$0;
        CardAttachment r2 = this.$cardData.getCardContent().getAttachment();
        int r3 = CardResourceServiceImpl.c;
        r9.getClass();
        ArrayList r10 = new ArrayList();
        HashMap<String, AudioInfo> r4 = r2.getAudios();
        if (r4 == null) goto L17;
        Iterator<Map.Entry<String, AudioInfo>> r5 = r4.entrySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        AudioInfo r6 = r5.next().getValue();
        r10.add(new b(CardResource.ResourceType.AUDIO, r6.getKey(), r6.getVisitInfo()));
    L17:
        CardResourceServiceImpl r7 = this.this$0;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r7.m(r10, this) != r0) goto L23;
        return r0;
    L7:
        th = move-exception;
        Log.e("CardResourceService", "preloadResources error", th);
        goto L22
    }
}
