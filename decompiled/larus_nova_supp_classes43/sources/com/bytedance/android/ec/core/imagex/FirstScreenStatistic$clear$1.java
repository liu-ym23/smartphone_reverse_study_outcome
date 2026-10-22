package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.monitor.ECMonitorService;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.imagex.FirstScreenStatistic$clear$1", f = "FirstScreenStatistic.kt", i = {}, l = {855}, m = "invokeSuspend", n = {}, s = {})
public final class FirstScreenStatistic$clear$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public FirstScreenStatistic$clear$1(Continuation r10) {
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        return new FirstScreenStatistic$clear$1(r10);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        Collection<String> r16 = FirstScreenStatistic.L.values();
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L13:
        if (r17.hasNext() == false) goto L15;
        String r11 = (String) r17.next();
        FirstScreenStatistic.S.getClass();
        r10.add(FirstScreenStatistic.t(r11));
        goto L13
    L15:
        Set r18 = CollectionsKt.toSet(r10);
        Ref.LongRef r12 = new Ref.LongRef();
        r12.element = 0;
        Ref.IntRef r13 = new Ref.IntRef();
        int r14 = 0;
        r13.element = 0;
        Ref.IntRef r19 = new Ref.IntRef();
        r19.element = 0;
        FirstScreenStatistic.S.getClass();
        File r20 = (File) FirstScreenStatistic.R.getValue();
        if (r20 == null) goto L31;
        File[] r21 = r20.listFiles();
        if (r21 == null) goto L31;
        int r22 = r21.length;
    L20:
        if (r14 >= r22) goto L31;
        File r23 = r21[r14];
        if (r23.isFile() == false) goto L30;
        if (r18.contains(StringsKt.substringBefore$default(r23.getName(), "###", null, 2, null)) == false) goto L36;
        r19.element++;
        r12.element += r23.length();
        goto L30
    L36:
        r23.delete();     // Catch: Exception -> L27
        r13.element++;     // Catch: Exception -> L27
        dm.a.a("FirstScreenStatistic").a("Deleted cache file: " + r23.getName());     // Catch: Exception -> L27
    L27:
        e = move-exception;
        dm.a.a("FirstScreenStatistic").b("Failed to delete cache file: " + r23.getName(), e);
    L30:
        r14 = r14 + 1;
    L31:
        dm.a.a("FirstScreenStatistic").a("cleared " + r13.element + " files, cacheSize " + ((r12.element / 1024.0f) / 1024.0f) + "M cacheFileCount " + r19.element);
        FirstScreenStatistic r110 = FirstScreenStatistic.S;
        if (FirstScreenStatistic.b == false) goto L34;
        FirstScreenStatistic.f.clear();
        FirstScreenStatistic.g.clear();
        FirstScreenStatistic.i.clear();
        FirstScreenStatistic.K.clear();
        FirstScreenStatistic.J.clear();
        FirstScreenStatistic.P.clear();
        FirstScreenStatistic.N.clear();
        FirstScreenStatistic.O.clear();
        FirstScreenStatistic.q.clear();
    L34:
        r110.getClass();
        FirstScreenStatistic.o(3);
        float r111 = (r12.element / 1024.0f) / 1024.0f;
        int r24 = r19.element;
        JSONObject r25 = new JSONObject();
        r25.put("cacheSize", Float.valueOf(r111));
        r25.put("cacheCount", r24);
        int r112 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_cache_size", r25, null, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        this.label = 1;
        if (DelayKt.delay(3000, this) != r0) goto L11;
        return r0;
    }
}
