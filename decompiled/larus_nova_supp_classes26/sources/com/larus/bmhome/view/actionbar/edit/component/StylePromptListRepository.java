package com.larus.bmhome.view.actionbar.edit.component;

import com.bytedance.keva.Keva;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class StylePromptListRepository {
    public static final StylePromptListRepository a = null;
    public static final Set<String> b = null;

    public StylePromptListRepository() {
    }

    static {
        a = new StylePromptListRepository();
        b = new LinkedHashSet();
    }

    public static void d(String r1) {
        Set<String> r0 = b;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c(String r6, List r7) {
        if ((!r7.isEmpty()) == false) goto L13;
        Lazy r0 = n2.a;
        Intrinsics.checkNotNullParameter(r6, "languageCode");
        Intrinsics.checkNotNullParameter(r7, "promptList");
        String r1 = "style_prompt_list_" + r6;
        FLogger.a.i("StylePromptListCacheStore", "storeDisk, cacheKey=" + r1 + " promptListSize=" + r7.size());
        ((Keva) n2.a.getValue()).storeString(r1, HttpExtKt.f.toJson(r7));     // Catch: Exception -> L7
    L9:
        Lazy r8 = n2.a;
        Intrinsics.checkNotNullParameter(r6, "languageCode");
        String r9 = "style_prompt_list_" + r6;
        FLogger.a.i("StylePromptListCacheStore", "clearMemoryCache, cacheKey=" + r9);
        ((ConcurrentHashMap) n2.b.getValue()).remove(r9);
        n2.a(r6);
        return;
    L7:
        e = move-exception;
        FLogger.a.e("StylePromptListCacheStore", "save cache error=" + e.getMessage());
        goto L9
    }

    public final Object a(String r6, Continuation<? super StylePromptListApi.GetStylePromptListData> r7) {
        if ((r7 instanceof StylePromptListRepository$fetchPromptListFromRemote$1) == false) goto L7;
        StylePromptListRepository$fetchPromptListFromRemote$1 r0 = (StylePromptListRepository$fetchPromptListFromRemote$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.b) == false) goto L32;
        dm9.a.b r10 = r9;
        StylePromptListApi.GetStylePromptListData r11 = (StylePromptListApi.GetStylePromptListData) r10.a.getData();
        if (r11 == null) goto L22;
        List<StylePromptListApi.StylePromptInfo> r12 = r11.getPromptList();
    L23:
        List<StylePromptListApi.StylePromptInfo> r13 = r12;
        if (r13 != null) goto L26;
    L29:
        if (r4 == false) goto L42;
        FLogger.a.e("StylePromptListRepository", "fetchPromptListFromRemote success but return empty list");
        return null;
    L42:
        return (StylePromptListApi.GetStylePromptListData) r10.a.getData();
    L26:
        if (r13.isEmpty() == true) goto L29;
        r4 = false;
        goto L29
    L22:
        r12 = null;
        goto L23
    L32:
        FLogger r14 = FLogger.a;
        StringBuilder r5 = new StringBuilder("fetchPromptListFromRemote failed, msg: ");
        if ((r9 instanceof dm9.a.a) == false) goto L35;
        dm9.a.a r15 = (dm9.a.a) r9;
    L36:
        if (r15 == null) goto L38;
        String r16 = r15.b;
    L39:
        r5.append(r16);
        r14.e("StylePromptListRepository", r5.toString());
        return null;
    L38:
        r16 = null;
        goto L39
    L35:
        r15 = null;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        StylePromptListApi.a r17 = StylePromptListApi.a;
        StylePromptListRepository$fetchPromptListFromRemote$resp$1 r18 = new StylePromptListRepository$fetchPromptListFromRemote$resp$1(r6, null);
        r0.label = 1;
        r17.getClass();
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new StylePromptListApi$Companion$safeCall$2(r18, null), r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new StylePromptListRepository$fetchPromptListFromRemote$1(this, r7);
        goto L8
    }

    public final Object b(String r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof StylePromptListRepository$preload$1) == false) goto L7;
        StylePromptListRepository$preload$1 r0 = (StylePromptListRepository$preload$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L14
    L28:
        StylePromptListApi.GetStylePromptListData r8 = (StylePromptListApi.GetStylePromptListData) r7;     // Catch: Throwable -> L14
        if (r8 == null) goto L34;
        List<StylePromptListApi.StylePromptInfo> r9 = r8.getPromptList();     // Catch: Throwable -> L14
        if (r9 != null) goto L33;
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
    L33:
        c(r5, CollectionsKt.filterNotNull(r9));     // Catch: Throwable -> L14
    L34:
        d(r5);
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        n2.a(r5);
        Set<String> r10 = b;
        monitor-enter(r10);
        boolean r4 = r10.add(r5);     // Catch: Throwable -> L38
        monitor-exit(r10);
        if (r4 == false) goto L24;
        r0.L$0 = r5;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        r7 = a(r5, r0);     // Catch: Throwable -> L14
        if (r7 != r2) goto L28;
        return r2;
    L24:
        return Unit.INSTANCE;
    L38:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        d(r5);
        throw th;
    L7:
        r0 = new StylePromptListRepository$preload$1(this, r6);
        goto L8
    }
}
