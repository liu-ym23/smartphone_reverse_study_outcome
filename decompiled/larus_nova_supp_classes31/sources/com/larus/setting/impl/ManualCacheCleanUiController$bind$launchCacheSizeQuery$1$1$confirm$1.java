package com.larus.setting.impl;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController$bind$launchCacheSizeQuery$1$1$confirm$1", f = "ManualCacheCleanUiController.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
public final class ManualCacheCleanUiController$bind$launchCacheSizeQuery$1$1$confirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $cacheSize;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ Function1<Long, String> $formatSize;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ ItemTextArrow $item;
    final /* synthetic */ String $operationId;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ManualCacheCleanUiController$bind$launchCacheSizeQuery$1$1$confirm$1(Fragment r1, ItemTextArrow r2, Long r3, String r4, String r5, Function1<? super Long, String> r6, Continuation<? super ManualCacheCleanUiController$bind$launchCacheSizeQuery$1$1$confirm$1> r7) {
        this.$fragment = r1;
        this.$item = r2;
        this.$cacheSize = r3;
        this.$operationId = r4;
        this.$currentPage = r5;
        this.$formatSize = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ManualCacheCleanUiController$bind$launchCacheSizeQuery$1$1$confirm$1(this.$fragment, this.$item, this.$cacheSize, this.$operationId, this.$currentPage, this.$formatSize, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ManualCacheCleanUiController r2 = ManualCacheCleanUiController.a;
        Fragment r12 = this.$fragment;
        ItemTextArrow r3 = this.$item;
        long r4 = this.$cacheSize.longValue();
        String r6 = this.$operationId;
        String r7 = this.$currentPage;
        Function1<Long, String> r8 = this.$formatSize;
        this.label = 1;
        if (ManualCacheCleanUiController.a(r2, r12, r3, r4, r6, r7, r8, this) != r0) goto L12;
        return r0;
    }
}
