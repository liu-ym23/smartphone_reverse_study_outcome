package com.larus.shortcuts.impl;

import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.shortcuts.impl.ShortcutCommonUtil$downloadImages$2", f = "ShortcutCommonUtil.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class ShortcutCommonUtil$downloadImages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ List<tw9.a> $shortcutInfoList;
    private /* synthetic */ Object L$0;
    int label;

    public ShortcutCommonUtil$downloadImages$2(List<tw9.a> r1, Continuation<? super ShortcutCommonUtil$downloadImages$2> r2) {
        this.$shortcutInfoList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ShortcutCommonUtil$downloadImages$2 r0 = new ShortcutCommonUtil$downloadImages$2(this.$shortcutInfoList, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L15:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        List<tw9.a> r2 = this.$shortcutInfoList;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r9.add(BuildersKt.async$default(r12, null, null, new ShortcutCommonUtil$downloadImages$2$deferredList$1$1((tw9.a) r3.next(), null), 3, null));
        goto L10
    L12:
        this.label = 1;
        r11 = AwaitKt.a(r9, this);
        if (r11 != r0) goto L15;
        return r0;
    }
}
