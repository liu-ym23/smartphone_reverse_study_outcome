package com.larus.profile.impl.creation.repository;

import androidx.lifecycle.MutableLiveData;
import com.larus.network.http.y;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.impl.ProfileRepo;
import dm9.a;
import fs9.b0;
import fs9.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import zp9.c;
import zp9.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ProfileCreationFeedRepository implements n {
    public final int a;
    public final String b;
    public final ProfileRepo c;
    public final MutableLiveData<Integer> d;
    public final MutableLiveData e;

    @Override // zp9.n
    public final CreationFeedCacheEntity b() {
        return null;
    }

    public ProfileCreationFeedRepository(String r2) {
        this.a = 20;
        this.b = r2;
        Lazy<ProfileRepo> r3 = ProfileRepo.b;
        this.c = ProfileRepo.a.a();
        MutableLiveData<Integer> r4 = new MutableLiveData();
        this.d = r4;
        this.e = r4;
    }

    @Override // zp9.n
    public final Object a(int r16, String r17, Long r18, String r19, Continuation<? super Pair<c, ? extends a<?>>> r20) {
        if ((r20 instanceof ProfileCreationFeedRepository$fetchBatch$1) == false) goto L7;
        ProfileCreationFeedRepository$fetchBatch$1 r2 = (ProfileCreationFeedRepository$fetchBatch$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L21:
        y r6 = (com.larus.network.http.a) r1;
        if ((r6 instanceof y) == false) goto L46;
        y r7 = r6;
        b0 r8 = (b0) ((com.larus.network.http.a) r7).b;
        if (r8 == null) goto L29;
        List<UserCreation> r9 = r8.a();
        if (r9 == null) goto L29;
        List r10 = CollectionsKt.filterNotNull(r9);
        if (r10 == null) goto L29;
    L30:
        List r11 = r10;
        b0 r12 = (b0) ((com.larus.network.http.a) r7).b;
        if (r12 == null) goto L33;
        String r13 = r12.c();
    L34:
        String r14 = String.valueOf(r13);
        b0 r15 = (b0) ((com.larus.network.http.a) r7).b;
        int r21 = 0;
        if (r15 == null) goto L37;
        boolean r22 = r15.b();
    L38:
        MutableLiveData<Integer> r23 = this.d;
        b0 r24 = (b0) ((com.larus.network.http.a) r7).b;
        if (r24 == null) goto L43;
        Integer r25 = r24.d();
        if (r25 == null) goto L43;
        r21 = r25.intValue();
    L43:
        r23.postValue(Boxing.boxInt(r21));
        return TuplesKt.to(new c(r22, null, r11, null, r14, 10), null);
    L37:
        r22 = false;
        goto L38
    L33:
        r13 = null;
    L29:
        r10 = new ArrayList();
        goto L30
    L46:
        return TuplesKt.to(null, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        ProfileRepo r26 = this.c;
        int r27 = this.a;
        String r28 = this.b;
        if (r17 != null) goto L17;
        String r29 = "";
    L18:
        x r30 = new x(r27, r28, r29, Boxing.boxInt(1), r19, null, null, 96);
        r2.label = 1;
        r26.getClass();
        r1 = ProfileRepo.d(r30, r2);
        if (r1 != r4) goto L21;
        return r4;
    L17:
        r29 = r17;
    L7:
        r2 = new ProfileCreationFeedRepository$fetchBatch$1(this, r20);
        goto L8
    }
}
