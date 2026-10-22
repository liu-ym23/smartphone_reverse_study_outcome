package com.obric.assistant.remote_card_container.cache;

import com.obric.assistant.remote_card_container.manager.RemoteCardManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import p9a.e;
import sfa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.cache.CardCacheManager$checkRemoveInvalidCaches$1$1", f = "CardCacheManager.kt", i = {0, 0, 0}, l = {64}, m = "invokeSuspend", n = {"destination$iv$iv", "element$iv$iv", "element$iv"}, s = {"L$0", "L$2", "L$4"})
final class CardCacheManager$checkRemoveInvalidCaches$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<j> $cardInfos;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public CardCacheManager$checkRemoveInvalidCaches$1$1(List<j> r1, Continuation<? super CardCacheManager$checkRemoveInvalidCaches$1$1> r2) {
        this.$cardInfos = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CardCacheManager$checkRemoveInvalidCaches$1$1(this.$cardInfos, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0055 -> B:14:0x0060). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0084 -> B:22:0x008d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b0 -> B:32:0x00b2). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Object r2 = this.L$4;
        Iterator r5 = (Iterator) this.L$3;
        Object r6 = this.L$2;
        Iterator r7 = (Iterator) this.L$1;
        Collection r8 = (Collection) this.L$0;
        ResultKt.throwOnFailure(r13);
        Collection r9 = r8;
        Iterator r10 = r7;
        Object r11 = r6;
        Iterator r12 = r5;
        Object r14 = r2;
        Object r3 = r0;
        CardCacheManager$checkRemoveInvalidCaches$1$1 r4 = this;
    L23:
        if (((Boolean) r13).booleanValue() != true) goto L25;
        CardCacheManager$checkRemoveInvalidCaches$1$1 r15 = r4;
        r0 = r3;
        Object r16 = r14;
        Iterator r17 = r12;
        Object r18 = r11;
        Iterator r19 = r10;
        Collection r20 = r9;
        boolean r21 = true;
    L27:
        if (r21 == false) goto L15;
        CardCacheManager$checkRemoveInvalidCaches$1$1 r22 = r15;
    L30:
        String r23 = (String) r16;
        Iterator r110 = r19;
    L32:
        if (r23 != null) goto L34;
        boolean r24 = true;
    L35:
        if (r24 == false) goto L37;
        r20.add(r18);
    L37:
        Collection r25 = r20;
    L10:
        if (r110.hasNext() == false) goto L38;
        r18 = r110.next();
        Set r26 = ((j) r18).g();
        if (r26 == null) goto L31;
        Iterator r27 = r26.iterator();
        r20 = r25;
        r19 = r110;
        r15 = r22;
        r17 = r27;
        goto L15
    L31:
        r20 = r25;
        r23 = null;
        goto L32
    L38:
        Iterator r111 = ((List) r25).iterator();
    L40:
        if (r111.hasNext() == false) goto L46;
        j r28 = (j) r111.next();
        e r29 = p9a.b.a;
        p9a.b.a("CardCacheManager", r28.c() + " has no msg bound, delete it");
        CardCacheManager r30 = CardCacheManager.a;
        String r31 = r28.c();
        if (r31 != null) goto L44;
        r31 = "";
    L44:
        Intrinsics.checkNotNullParameter(r31, "cardUri");
        CardCacheManager.b(new d(r31));
        goto L40
    L46:
        return Unit.INSTANCE;
    L34:
        r24 = false;
    L15:
        if (r17.hasNext() == false) goto L29;
        r16 = r17.next();
        String r32 = (String) r16;
        a r112 = RemoteCardManager.d;
        if (r112 == null) goto L26;
        r15.L$0 = r20;
        r15.L$1 = r19;
        r15.L$2 = r18;
        r15.L$3 = r17;
        r15.L$4 = r16;
        r15.label = 1;
        Object r33 = r112.b(r32, r15);
        if (r33 != r0) goto L21;
        return r0;
    L21:
        Object r113 = r0;
        r4 = r15;
        r13 = r33;
        r9 = r20;
        r10 = r19;
        r11 = r18;
        r12 = r17;
        r14 = r16;
        r3 = r113;
        goto L23
    L26:
        r21 = false;
        goto L27
    L29:
        r22 = r15;
        r16 = null;
        goto L30
    L25:
        r15 = r4;
        r0 = r3;
        r16 = r14;
        r17 = r12;
        r18 = r11;
        r19 = r10;
        r20 = r9;
        r21 = false;
        goto L27
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        List<j> r114 = this.$cardInfos;
        r25 = new ArrayList();
        r110 = r114.iterator();
        r22 = this;
        goto L10
    }
}
