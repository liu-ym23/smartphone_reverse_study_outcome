package com.obric.assistant.card.utils;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.card.utils.AppEntityEx$getAppEntityList$3", f = "AppEntityEx.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppEntityEx$getAppEntityList$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AppEntity>>, Object> {
    final /* synthetic */ List<AppEntityEx.a> $keyList;
    final /* synthetic */ Map<String, List<String>> $typeAndIdsMap;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements Comparator {
        public final /* synthetic */ List a;

        public a(List r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r5, T r6) {
            AppEntity r7 = (AppEntity) r5;
            AppEntity r8 = (AppEntity) r6;
            return ComparisonsKt.compareValues(Integer.valueOf(this.a.indexOf(r7.getType() + '&' + r7.getId())), Integer.valueOf(this.a.indexOf(r8.getType() + '&' + r8.getId())));
        }
    }

    public AppEntityEx$getAppEntityList$3(List<AppEntityEx.a> r1, Map<String, List<String>> r2, Continuation<? super AppEntityEx$getAppEntityList$3> r3) {
        this.$keyList = r1;
        this.$typeAndIdsMap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AppEntityEx$getAppEntityList$3 r0 = new AppEntityEx$getAppEntityList$3(this.$keyList, this.$typeAndIdsMap, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<? extends AppEntity>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        List<AppEntityEx.a> r10 = this.$keyList;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L15;
        AppEntityEx.a r1 = (AppEntityEx.a) r11.next();
        StringBuilder r2 = new StringBuilder();
        String r3 = r1.getType();
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L10;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        r2.append(r3);
        r2.append('&');
        String r5 = r1.a();
        if (r5 == null) goto L14;
        r4 = r5;
    L14:
        r2.append(r4);
        r0.add(r2.toString());
        goto L6
    L15:
        Map<String, List<String>> r12 = this.$typeAndIdsMap;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L18
        Object r13 = Result.constructor-impl(AppEntityEx.a(r12));     // Catch: Throwable -> L18
    L20:
        Throwable r7 = Result.exceptionOrNull-impl(r13);
        if (r7 == null) goto L23;
        FLogger.a.w("AppEntityEx", "getAppEntityList failed: " + r7.getMessage(), r7);
    L23:
        List<AppEntityEx.a> r14 = this.$keyList;
        if (Result.isSuccess-impl(r13) == false) goto L31;
        List r15 = (List) r13;
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("getAppEntityList success, request size = ");
        r17.append(r14.size());
        r17.append(", response size = ");
        if (r15 == null) goto L28;
        int r18 = r15.size();
    L29:
        r17.append(r18);
        r16.i("AppEntityEx", r17.toString());
        goto L31
    L28:
        r18 = 0;
    L31:
        if (Result.isFailure-impl(r13) == false) goto L33;
        r13 = null;
    L33:
        List r19 = (List) r13;
        if (r19 != null) goto L37;
        r19 = CollectionsKt.emptyList();
    L37:
        return CollectionsKt.sortedWith(CollectionsKt.filterNotNull(r19), new a(r0));
    L18:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
