package com.bytedance.android.ec.core.imagex;

import com.bytedance.keva.Keva;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$saveFirstScreenImageSet$1", f = "FirstScreenStatistic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FirstScreenStatistic$saveFirstScreenImageSet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set $originUrlList;
    private /* synthetic */ Object L$0;
    int label;

    public FirstScreenStatistic$saveFirstScreenImageSet$1(Set r1, Continuation r10) {
        this.$originUrlList = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        FirstScreenStatistic$saveFirstScreenImageSet$1 r0 = new FirstScreenStatistic$saveFirstScreenImageSet$1(this.$originUrlList, r11);
        r0.L$0 = r10;
        return r0;
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Ref.IntRef r12 = new Ref.IntRef();
        r12.element = 0;
        Ref.IntRef r1 = new Ref.IntRef();
        r1.element = 0;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L27
        Set r14 = this.$originUrlList;     // Catch: Throwable -> L27
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));     // Catch: Throwable -> L27
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L27
    L7:
        if (r16.hasNext() == false) goto L9;
        String r17 = (String) r16.next();     // Catch: Throwable -> L27
        FirstScreenStatistic.S.getClass();     // Catch: Throwable -> L27
        r15.add(FirstScreenStatistic.t(r17));     // Catch: Throwable -> L27
        goto L7
    L9:
        Object[] r18 = r15.toArray(new String[0]);     // Catch: Throwable -> L27
        if (r18 == null) goto L26;
        String[] r19 = (String[]) r18;     // Catch: Throwable -> L27
        r12.element = r19.length;     // Catch: Throwable -> L27
        int r20 = this.$originUrlList.size();     // Catch: Throwable -> L27
        r1.element = r20;     // Catch: Throwable -> L27
        int r21 = r12.element;     // Catch: Throwable -> L27
        if (r21 != r20) goto L24;
        if (r21 == 0) goto L22;
        if (r20 == 0) goto L22;
        Keva r22 = Keva.getRepo("legou_mall_first_screen_image_cache_sp", 1);     // Catch: Throwable -> L27
        r22.storeStringArray("first_screen_image_md5s", r19);     // Catch: Throwable -> L27
        Object[] r23 = this.$originUrlList.toArray(new String[0]);     // Catch: Throwable -> L27
        if (r23 == null) goto L20;
        r22.storeStringArray("first_screen_image_urls", (String[]) r23);     // Catch: Throwable -> L27
        FirstScreenStatistic r24 = FirstScreenStatistic.S;     // Catch: Throwable -> L27
        int r25 = r19.length;     // Catch: Throwable -> L27
        int r26 = this.$originUrlList.size();     // Catch: Throwable -> L27
        r24.getClass();     // Catch: Throwable -> L27
        FirstScreenStatistic.p(true, r25, r26);     // Catch: Throwable -> L27
        Object r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r27) == false) goto L33;
        FirstScreenStatistic r28 = FirstScreenStatistic.S;
        int r110 = r12.element;
        int r29 = r1.element;
        r28.getClass();
        FirstScreenStatistic.p(false, r110, r29);
        FirstScreenStatistic.n("saveFirstScreenImageSet", "", Result.exceptionOrNull-impl(r27), null);
    L33:
        return Unit.INSTANCE;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L27
    L22:
        throw new Exception("md5Array or urlArray is empty");     // Catch: Throwable -> L27
    L24:
        throw new Exception("md5Array size not equal to originUrlList size");     // Catch: Throwable -> L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
