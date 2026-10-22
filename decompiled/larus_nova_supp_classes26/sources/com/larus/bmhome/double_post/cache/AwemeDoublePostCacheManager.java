package com.larus.bmhome.double_post.cache;

import com.bytedance.keva.Keva;
import com.larus.bmhome.video.Content;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.k;
import com.larus.platform.api.r2;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ip8.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AwemeDoublePostCacheManager {
    public static final AwemeDoublePostCacheManager a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final List<Content> d = null;

    public AwemeDoublePostCacheManager() {
    }

    static {
        a = new AwemeDoublePostCacheManager();
        b = LazyKt.lazy(new a());
        c = LazyKt.lazy(new b());
        d = new ArrayList();
    }

    public static Keva b() {
        return (Keva) b.getValue();
    }

    public static void c() {
        ArrayList r0 = (ArrayList) d;
        if ((!r0.isEmpty()) == false) goto L17;
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (d.a((Content) r3) == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AwemeDoublePostCacheManager$doSaveContentList$1(r1, "aweme_double_post_cache_data_".concat(AccountService.a.getUserId()), null), 2, null);
        return;
    }

    public final Object a(Continuation<? super List<Content>> r6) {
        if ((r6 instanceof AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1) == false) goto L7;
        AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1 r0 = (AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L20:
        return (List) r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        String r8 = "aweme_double_post_cache_data_".concat(AccountService.a.getUserId());
        if (b().contains(r8) == false) goto L21;
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1 r4 = new AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1(null);
        r0.label = 1;
        r7 = BuildersKt.withContext(r9, r4, r0);
        if (r7 != r2) goto L20;
        return r2;
    L21:
        return null;
    L7:
        r0 = new AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$1(this, r6);
        goto L8
    }

    public static void d(List r15, String r16, Long r17) {
        if (r15 == null) goto L6;
        List r1 = CollectionsKt.takeLast(r15, 2);
        if (r1 == null) goto L6;
    L7:
        List r2 = r1;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        String r5 = ((Content) r4.next()).getItemId();
        if (r5 == null) goto L9;
        r3.add(r5);
        goto L9
    L14:
        if (r15 == null) goto L18;
        Content r0 = (Content) CollectionsKt.firstOrNull(r15);
        if (r0 == null) goto L18;
        String r6 = r0.getRequestId();
    L20:
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        HashMap r7 = new HashMap();
        Iterator r8 = r3.iterator();
    L24:
        if (r8.hasNext() == false) goto L26;
        r7.put((String) r8.next(), r6);
        goto L24
    L26:
        HashMap r13 = new HashMap();
        Iterator r9 = r2.iterator();
    L27:
        boolean r14 = true;
        if (r9.hasNext() == false) goto L45;
        Content r10 = (Content) r9.next();
        String r11 = r10.getItemId();
        if (r11 == null) goto L27;
        Integer r12 = r10.getRecChannelId();
        if (r12 != null) goto L34;
    L43:
        String r18 = "414";
    L44:
        r13.put(r11, r18);
        goto L27
    L34:
        if (r12.intValue() != 0) goto L37;
        r14 = false;
    L37:
        if (r14 == true) goto L40;
        r12 = null;
    L40:
        if (r12 == null) goto L43;
        r18 = r12.toString();
        if (r18 != null) goto L44;
    L45:
        if (r16 != null) goto L47;
        String r19 = "";
    L48:
        if (r17 == null) goto L50;
        long r20 = r17.longValue();
    L51:
        k r21 = new k(r7, r19, r20, new ArrayList(r3), CachedVideosPreloadFrom.UNLIMITED_FLOW, 1, r13);
        IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r22 == null) goto L68;
        r2 r23 = r22.A0();
        if (r23 == null) goto L69;
        r23.o(r21, true);
        return;
    L69:
        return;
    L68:
        return;
    L50:
        r20 = AppHost.a.getAppClock().currentTimeMillis();
        goto L51
    L47:
        r19 = r16;
    L18:
        r6 = null;
    L6:
        r1 = CollectionsKt.emptyList();
        goto L7
    }
}
