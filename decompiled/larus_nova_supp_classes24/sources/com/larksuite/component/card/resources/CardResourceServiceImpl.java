package com.larksuite.component.card.resources;

import android.util.LruCache;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.data.media.VisitInfo;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.suite.lark.platform.service.resourcerepository.api.ResourceRequestBaseSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardResourceServiceImpl implements e {
    public static final /* synthetic */ int c = 0;
    public final LruCache<String, CardResource> a;
    public final CoroutineScope b;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
        Log.i("CardResourceService", "destroy");
        CoroutineScopeKt.cancel(this.b, new CancellationException("CardResourceService is destroyed"));
        this.a.evictAll();
    }

    public CardResourceServiceImpl() {
        this.a = new LruCache(100);
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    @Override // com.larksuite.component.card.resources.e
    public final void g(CardData r9) {
        Intrinsics.checkNotNullParameter(r9, "cardData");
        Log.i("CardResourceService", "preload resources, bizID=" + r9.getCardID() + ", uniCardID=" + r9.getUniversalCardID());
        BuildersKt.launch$default(this.b, null, null, new CardResourceServiceImpl$preloadResources$1(this, r9, null), 3, null);
    }

    @Override // com.larksuite.component.card.resources.e
    public final CardResource i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileKey");
        return this.a.get(r2);
    }

    @Override // com.larksuite.component.card.resources.e
    public final Object b(b r5, Continuation<? super CardResource> r6) {
        if ((r6 instanceof CardResourceServiceImpl$forceLoadResource$1) == false) goto L7;
        CardResourceServiceImpl$forceLoadResource$1 r0 = (CardResourceServiceImpl$forceLoadResource$1) r6;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (b) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        List r8 = (List) r7;
        if (r8.isEmpty() == true) goto L24;
        if (Intrinsics.areEqual(((CardResource) ListProtector.get(r8, 0)).b, r5.b) == false) goto L24;
        return ListProtector.get(r8, 0);
    L24:
        throw new RuntimeException("cannot load resource with key: " + r5.b);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        Log.i("CardResourceService", "force load resource with key: " + r5.b);
        List<b> r9 = CollectionsKt.listOf(r5);
        r0.L$0 = r5;
        r0.label = 1;
        r7 = m(r9, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new CardResourceServiceImpl$forceLoadResource$1(this, r6);
        goto L8
    }

    public final Object m(List<b> r23, Continuation<? super List<CardResource>> r24) {
        if ((r24 instanceof CardResourceServiceImpl$doLoadResourceSuspend$1) == false) goto L7;
        CardResourceServiceImpl$doLoadResourceSuspend$1 r2 = (CardResourceServiceImpl$doLoadResourceSuspend$1) r24;
        int r3 = r2.label;
        if ((r3 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r2.label = r3 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        List r6 = (List) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L47:
        List r7 = (List) r1;
        Iterator r8 = r7.iterator();
    L49:
        if (r8.hasNext() == false) goto L52;
        CardResource r9 = (CardResource) r8.next();
        this.a.put(r9.b, r9);
        goto L49
    L52:
        return CollectionsKt.plus(r6, r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        ArrayList r10 = new ArrayList();
        final ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r23.iterator();
    L16:
        if (r12.hasNext() == false) goto L21;
        b r13 = (b) r12.next();
        CardResource r14 = this.a.get(r13.b);
        if (r14 == null) goto L19;
        r10.add(r14);
        goto L16
    L19:
        r11.add(r13);
        goto L16
    L21:
        Log.i("CardResourceService", "hit: " + CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, CardResourceServiceImpl$doLoadResourceSuspend$3.INSTANCE, 30, null) + ", miss: " + CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, CardResourceServiceImpl$doLoadResourceSuspend$4.INSTANCE, 30, null));
        if (r11.isEmpty() == false) goto L24;
        return r10;
    L24:
        r2.L$0 = r10;
        r2.label = 1;
        final j r15 = new j(IntrinsicsKt.intercepted(r2), 1);
        r15.C();
        Log.i("CardResourceService", "mGetResources with keys: " + CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, CardResourceServiceImpl$mGetResourcesSuspend$2$1.INSTANCE, 30, null));
        if (r11.isEmpty() == false) goto L27;
        Result.Companion r16 = Result.Companion;
        r15.resumeWith(Result.constructor-impl(CollectionsKt.emptyList()));
    L41:
        r1 = r15.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L44:
        if (r1 != r4) goto L46;
        return r4;
    L46:
        r6 = r10;
        goto L47
    L27:
        ArrayList r17 = new ArrayList();
        Iterator r19 = r11.iterator();
    L29:
        if (r19.hasNext() == false) goto L40;
        b r20 = (b) r19.next();
        VisitInfo r21 = r20.c;
        ResourceRequestBaseSet r22 = null;
        if (r21 == null) goto L33;
        ResourceRequestBaseSet.a r110 = new ResourceRequestBaseSet.a();
        r110.a = r21.getSceneType();
        r110.b = r21.getEntityType();
        r110.c = r21.getEntityId();
        r110.d = r21.getInnerMsgId();
        r110.e = r21.getAuthFileKey();
        r110.f = r21.getImExt();
        r110.g = r21.getExt();
    L34:
        HashMap<CardResource.ResourceType, String> r25 = com.larksuite.component.card.resources.a.a;
        CardResource.ResourceType r26 = r20.getType();
        Intrinsics.checkNotNullParameter(r26, "type");
        String r27 = com.larksuite.component.card.resources.a.a.get(r26);
        if (r27 == null) goto L38;
        ResourceRequestBaseSet r111 = new ResourceRequestBaseSet(r20.b, r27, null, null);
        r111.h = r110;
        r22 = r111;
    L38:
        if (r22 == null) goto L29;
        r17.add(r22);
        goto L29
    L33:
        r110 = null;
        goto L34
    L40:
        ((qpc.e) ApiUtils.getApi(qpc.e.class)).getResources(r17, 9, new CardResourceServiceImpl$mGetResourcesSuspend$2$2(r11, r15));
    L7:
        r2 = new CardResourceServiceImpl$doLoadResourceSuspend$1(this, r24);
        goto L8
    }
}
