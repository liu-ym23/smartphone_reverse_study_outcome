package com.larus.profile.impl.creation.repository;

import com.larus.network.http.y;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationGroup;
import com.larus.profile.api.bean.UserCreationGroupListResponse;
import com.larus.profile.impl.ProfileRepo;
import dm9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import zp9.c;
import zp9.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ProfileCreationFeedPrivateTabRepository implements n {
    public final int a;
    public final String b;
    public final ProfileRepo c;

    @Override // zp9.n
    public final CreationFeedCacheEntity b() {
        return null;
    }

    public ProfileCreationFeedPrivateTabRepository(String r2) {
        this.a = 20;
        this.b = r2;
        Lazy<ProfileRepo> r3 = ProfileRepo.b;
        this.c = ProfileRepo.a.a();
    }

    @Override // zp9.n
    public final Object a(int r8, String r9, Long r10, String r11, Continuation<? super Pair<c, ? extends a<?>>> r12) {
        if ((r12 instanceof ProfileCreationFeedPrivateTabRepository$fetchBatch$1) == false) goto L7;
        ProfileCreationFeedPrivateTabRepository$fetchBatch$1 r13 = (ProfileCreationFeedPrivateTabRepository$fetchBatch$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = r13.label;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L20:
        y r17 = (com.larus.network.http.a) r15;
        if ((r17 instanceof y) == false) goto L53;
        y r18 = r17;
        UserCreationGroupListResponse r19 = (UserCreationGroupListResponse) ((com.larus.network.http.a) r18).b;
        if (r19 == null) goto L25;
        List<UserCreationGroup> r20 = r19.a();
    L26:
        UserCreationGroupListResponse r110 = (UserCreationGroupListResponse) ((com.larus.network.http.a) r18).b;
        if (r110 == null) goto L29;
        String r111 = r110.c();
    L30:
        String r5 = String.valueOf(r111);
        UserCreationGroupListResponse r112 = (UserCreationGroupListResponse) ((com.larus.network.http.a) r18).b;
        if (r112 == null) goto L33;
        boolean r1 = r112.b();
    L34:
        if (r20 == null) goto L49;
        ArrayList r113 = new ArrayList();
        Iterator<T> r21 = r20.iterator();
    L37:
        if (r21.hasNext() == false) goto L48;
        UserCreationGroup r114 = (UserCreationGroup) r21.next();
        if (r114 != null) goto L41;
        r114 = null;
    L41:
        if (r114 == null) goto L45;
        List<UserCreation> r115 = r114.a();
        if (r115 == null) goto L45;
        List r116 = CollectionsKt.filterNotNull(r115);
    L46:
        if (r116 == null) goto L37;
        r113.add(r116);
    L45:
        r116 = null;
        goto L46
    L48:
        ArrayList r4 = r113;
    L51:
        return TuplesKt.to(new c(r1, null, null, r4, r5, 6), null);
    L49:
        r4 = null;
        goto L51
    L33:
        r1 = false;
        goto L34
    L29:
        r111 = null;
        goto L30
    L25:
        r20 = null;
        goto L26
    L53:
        return TuplesKt.to(null, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        ProfileRepo r117 = this.c;
        int r2 = this.a;
        String r3 = this.b;
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        r13.label = 1;
        r117.getClass();
        r15 = ProfileRepo.b(r2, r3, r9, r11, r13);
        if (r15 != r16) goto L20;
        return r16;
    L7:
        r13 = new ProfileCreationFeedPrivateTabRepository$fetchBatch$1(this, r12);
        goto L8
    }
}
