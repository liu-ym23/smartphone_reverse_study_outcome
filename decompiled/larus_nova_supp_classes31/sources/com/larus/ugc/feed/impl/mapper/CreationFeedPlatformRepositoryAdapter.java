package com.larus.ugc.feed.impl.mapper;

import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.larus.ugc.feed.api.model.CreationFeedCacheEntityKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.impl.cache.CreationListCacheDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import m0a.j;
import m0a.l;
import zp9.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationFeedPlatformRepositoryAdapter implements l {
    public final n a;

    @Override // m0a.l
    public final CreationFeedCacheEntityKmp b() {
        CreationFeedCacheEntity r0 = this.a.b();
        CommonCreationFeedDataKmp r1 = null;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        String r3 = r0.getCreationRecommendType();
        zp9.c r4 = r0.getListData();
        if (r4 == null) goto L8;
        r1 = c.a(r4);
    L8:
        return new CreationFeedCacheEntityKmp(r3, r1, r0.getRandomSeed(), r0.getTimeStamp());
    L9:
        return null;
    }

    public CreationFeedPlatformRepositoryAdapter(n r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
    }

    @Override // m0a.l
    public final Object c(CreationFeedCacheEntityKmp r14, Continuation<? super Unit> r15) {
        String r0 = r14.getCreationRecommendType();
        if (r0 != null) goto L7;
        return Unit.INSTANCE;
    L7:
        if (r0.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        CreationListCacheDataSource r2 = CreationListCacheDataSource.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        String r4 = r14.getCreationRecommendType();
        CommonCreationFeedDataKmp r5 = r14.getListData();
        zp9.c r6 = null;
        ArrayList r7 = null;
        if (r5 == null) goto L26;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        boolean r8 = r5.getHasMore();
        Map<String, String> r9 = r5.getTraceMap();
        List<UserCreationKmp> r3 = r5.getCreationList();
        if (r3 == null) goto L18;
        List<UserCreation> r10 = c.e(r3);
    L19:
        List<List<UserCreationKmp>> r11 = r5.getCreationGroupList();
        if (r11 == null) goto L25;
        List<List<UserCreationKmp>> r12 = r11;
        r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        r7.add(c.e((List) r13.next()));
    L25:
        r6 = new zp9.c(r8, r9, r10, r7, r5.getNextCursor());
        goto L26
    L18:
        r10 = null;
    L26:
        Object r16 = r2.b(r0, new CreationFeedCacheEntity(r4, r6, r14.getRandomSeed(), r14.getTimeStamp()), r15);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        return r16;
    L30:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L9:
        r1 = false;
        goto L10
    }

    @Override // m0a.l
    public final Object a(int r8, String r9, Long r10, String r11, Continuation<? super Pair<CommonCreationFeedDataKmp, ? extends j<Unit>>> r12) {
        if ((r12 instanceof CreationFeedPlatformRepositoryAdapter$fetchBatch$1) == false) goto L7;
        CreationFeedPlatformRepositoryAdapter$fetchBatch$1 r0 = (CreationFeedPlatformRepositoryAdapter$fetchBatch$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CreationFeedPlatformRepositoryAdapter$fetchBatch$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        Pair r14 = (Pair) r13;
        zp9.c r15 = (zp9.c) r14.component1();
        dm9.a.a r16 = (dm9.a) r14.component2();
        Object r17 = null;
        if (r15 == null) goto L20;
        CommonCreationFeedDataKmp r18 = c.a(r15);
    L21:
        if (r16 == null) goto L31;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        if ((r16 instanceof dm9.a.b) == false) goto L26;
        r17 = new j.b(Unit.INSTANCE);
        goto L31
    L26:
        if ((r16 instanceof dm9.a.a) == false) goto L29;
        dm9.a.a r19 = r16;
        r17 = new j.a(r19.a, r19.b, r19.c);
        goto L31
    L29:
        throw new NoWhenBranchMatchedException();
    L31:
        return TuplesKt.to(r18, r17);
    L20:
        r18 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        n r4 = this.a;
        r6.label = 1;
        r13 = r4.a(r8, r9, r10, r11, r6);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new CreationFeedPlatformRepositoryAdapter$fetchBatch$1(this, r12);
        goto L8
    }
}
