package com.larus.uaigc.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.api.x;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class DataConverterKt {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((String) r1, (String) r2);
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues((String) r1, (String) r2);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class c extends TypeToken<Map<String, ? extends x>> {
        public c() {
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            CreationTask r4 = (CreationTask) r2;
            int r0 = 0;
            if (r4 == null) goto L7;
            Integer r5 = r4.index;
            if (r5 == null) goto L7;
            int r6 = r5.intValue();
        L8:
            Integer r7 = Integer.valueOf(r6);
            CreationTask r8 = (CreationTask) r3;
            if (r8 == null) goto L14;
            Integer r9 = r8.index;
            if (r9 == null) goto L14;
            r0 = r9.intValue();
        L14:
            return ComparisonsKt.compareValues(r7, Integer.valueOf(r0));
        L7:
            r6 = 0;
            goto L8
        }
    }

    public static final String h(int r1) {
        if (r1 != 1) goto L5;
        return "image";
    L5:
        if (r1 != 2) goto L7;
        return "image2image";
    L7:
        if (r1 != 4) goto L9;
        return "music";
    L9:
        if (r1 != 5) goto L11;
        return "avatar_image";
    L11:
        if (r1 != 6) goto L13;
        return "video";
    L13:
        if (r1 == 7) goto L15;
        return "";
    L15:
        return "ai_beautify_image";
    }

    public static final String b(BotModel r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Integer r0 = r3.getBotType();
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L20:
        return "other_default";
    L11:
        if (r0.intValue() != 0) goto L20;
        BotCreatorInfo r4 = r3.getBotCreatorInfo();
        if (r4 == null) goto L15;
        String r5 = r4.getId();
    L17:
        if (Intrinsics.areEqual(r5, AccountService.a.getUserId()) == false) goto L19;
        return "self_created";
    L19:
        return "others_created";
    L15:
        r5 = null;
        goto L17
    L6:
        if (r0.intValue() != 1) goto L8;
        return "default";
    }

    public static final Map<String, UserCreationFromIM> d(String r14) {
        Intrinsics.checkNotNullParameter(r14, "creationStatusInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        JSONObject r1 = new JSONObject(r14);     // Catch: Exception -> L27
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L27
        Iterator<String> r2 = r1.keys();     // Catch: Exception -> L27
    L5:
        if (r2.hasNext() == false) goto L8;
        r15.add(r2.next());     // Catch: Exception -> L27
        goto L5
    L8:
        if (r15.size() <= 1) goto L10;
        CollectionsKt.sortWith(r15, new b());     // Catch: Exception -> L27
    L10:
        Iterator r16 = r15.iterator();     // Catch: Exception -> L27
    L11:
        if (r16.hasNext() == false) goto L26;
        String r3 = (String) r16.next();     // Catch: Exception -> L27
        String r4 = r1.optString(r3);     // Catch: Exception -> L27
        Gson r5 = new Gson();     // Catch: Exception -> L27
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        Object r7 = Result.constructor-impl((UserCreationFromIM) r5.fromJson(r4, UserCreationFromIM.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r7) == false) goto L21;
        r7 = null;
    L21:
        UserCreationFromIM r8 = (UserCreationFromIM) r7;     // Catch: Exception -> L27
        if (r8 != null) goto L24;
        r8 = new UserCreationFromIM(null, null, null, null, null, null, null, 127, null);     // Catch: Exception -> L27
    L24:
        r0.put(r3, r8);     // Catch: Exception -> L27
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;     // Catch: Exception -> L27
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L27
        goto L19
    L26:
        return r0;
    L27:
        e = move-exception;
        FLogger.a.e("ChatCreationPagerFragment", "There have something wrong when parse!!!e=" + e.getMessage());
        return new LinkedHashMap();
    }

    public static final Map<String, x> f(String r7) {
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        Object r3 = null;
        if (r7 == null) goto L20;
        h r4 = h.a;     // Catch: Throwable -> L22
        if (StringsKt.isBlank(r7) == false) goto L30;
    L19:
        r3 = (Map) r3;     // Catch: Throwable -> L22
        goto L20
    L30:
        r4.getClass();     // Catch: Throwable -> L10
        Object r8 = Result.constructor-impl(h.b.fromJson(r7, new c().getType()));     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L22
        if (r5 == null) goto L16;
        c0 r6 = c0.b;     // Catch: Throwable -> L22
        StringBuilder r9 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Throwable -> L22
        r9.append(ExceptionsKt.stackTraceToString(r5));     // Catch: Throwable -> L22
        r6.e("GsonHolder", r9.toString());     // Catch: Throwable -> L22
    L16:
        if (Result.isFailure-impl(r8) == true) goto L19;
        r3 = r8;
        goto L19
    L10:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L22
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
    L20:
        r1.element = r3;     // Catch: Throwable -> L22
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Map<String, x> r11 = (Map) r1.element;
        if (r11 == null) goto L27;
        return r11;
    L27:
        return MapsKt.emptyMap();
    L22:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public static final Map<String, CreationTask> g(CreationMsgContentData r5) {
        if (r5 == null) goto L22;
        CreationInfo r6 = r5.creationInfo;
        if (r6 == null) goto L22;
        Map r7 = r6.taskInfo;
        if (r7 == null) goto L22;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r8 = r7.entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L23;
        Map.Entry r2 = (Map.Entry) r8.next();
        CreationTask r3 = (CreationTask) r2.getValue();
        if (r3 == null) goto L19;
        Integer r4 = r3.status;
        if (r4 == null) goto L19;
        if (r4.intValue() != 4) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L10;
        r1.put(r2.getKey(), r2.getValue());
    L19:
        r9 = false;
    L23:
        if (r1 == null) goto L48;
        Collection r10 = r1.values();
        if (r10 == null) goto L49;
        List r11 = CollectionsKt.toList(r10);
        if (r11 == null) goto L50;
        List r12 = CollectionsKt.sortedWith(r11, new d());
        if (r12 == null) goto L51;
        List r13 = r12;
        LinkedHashMap r14 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r13, 10)), 16));
        Iterator r15 = r13.iterator();
    L32:
        if (r15.hasNext() == false) goto L39;
        Object r16 = r15.next();
        CreationTask r17 = (CreationTask) r16;
        if (r17 == null) goto L36;
        String r18 = r17.id;
    L37:
        r14.put(r18, r16);
        goto L32
    L36:
        r18 = null;
        goto L37
    L39:
        return r14;
    L51:
        return null;
    L50:
        return null;
    L49:
        return null;
    L48:
        return null;
    L22:
        r1 = null;
        goto L23
    }

    public static final String a(String r2, String r3) {
        StringBuilder r0 = new StringBuilder();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.append(r2);
        r0.append('-');
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.append(r3);
        return r0.toString();
    }

    public static final Map<String, UserCreationFromIM> c(String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "creationStatusInfo");
        Intrinsics.checkNotNullParameter(r15, "messageId");
        LinkedHashMap r0 = new LinkedHashMap();
        JSONObject r1 = new JSONObject(r14);     // Catch: Exception -> L27
        ArrayList r16 = new ArrayList();     // Catch: Exception -> L27
        Iterator<String> r2 = r1.keys();     // Catch: Exception -> L27
    L5:
        if (r2.hasNext() == false) goto L8;
        r16.add(r2.next());     // Catch: Exception -> L27
        goto L5
    L8:
        if (r16.size() <= 1) goto L10;
        CollectionsKt.sortWith(r16, new a());     // Catch: Exception -> L27
    L10:
        Iterator r17 = r16.iterator();     // Catch: Exception -> L27
    L11:
        if (r17.hasNext() == false) goto L26;
        String r3 = (String) r17.next();     // Catch: Exception -> L27
        String r4 = r15 + '_' + r3;     // Catch: Exception -> L27
        String r5 = r1.optString(r3);     // Catch: Exception -> L27
        Gson r6 = new Gson();     // Catch: Exception -> L27
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L16
        Object r8 = Result.constructor-impl((UserCreationFromIM) r6.fromJson(r5, UserCreationFromIM.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r8) == false) goto L21;
        r8 = null;
    L21:
        UserCreationFromIM r9 = (UserCreationFromIM) r8;     // Catch: Exception -> L27
        if (r9 != null) goto L24;
        r9 = new UserCreationFromIM(null, null, null, null, null, null, null, 127, null);     // Catch: Exception -> L27
    L24:
        r0.put(r4, r9);     // Catch: Exception -> L27
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Exception -> L27
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L27
        goto L19
    L26:
        return r0;
    L27:
        e = move-exception;
        FLogger.a.e("ChatCreationPagerFragment", "There have something wrong when parse!!!e=" + e.getMessage());
        return r0;
    }

    public static final Object e(String r5, String r6, Continuation<? super UserCreationFromIM> r7) {
        if ((r7 instanceof DataConverterKt$getLatestPublishCreation$1) == false) goto L7;
        DataConverterKt$getLatestPublishCreation$1 r0 = (DataConverterKt$getLatestPublishCreation$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = "";
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L30:
        String r9 = (String) r8;
        if (r9 != null) goto L33;
        r9 = "";
    L33:
        Map<String, UserCreationFromIM> r10 = d(r9);
        if (r6 == null) goto L38;
        r4 = r6;
    L38:
        return ((LinkedHashMap) r10).get(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r5 != null) goto L17;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == false) goto L24;
        return null;
    L24:
        IChatRepoService r12 = RepoDispatcherDelegate.b.e();
        if (r5 != null) goto L27;
        r5 = "";
    L27:
        r0.L$0 = r6;
        r0.label = 1;
        r8 = r12.w1(r5, r0);
        if (r8 != r2) goto L30;
        return r2;
    L17:
        if (r5.length() == 0) goto L20;
        r11 = false;
    L7:
        r0 = new DataConverterKt$getLatestPublishCreation$1(r7);
        goto L8
    }
}
