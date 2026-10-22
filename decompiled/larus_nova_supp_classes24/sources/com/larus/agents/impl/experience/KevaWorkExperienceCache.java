package com.larus.agents.impl.experience;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class KevaWorkExperienceCache implements m {
    public static final MutexImpl a = null;

    public static final class a {
    }

    public KevaWorkExperienceCache() {
    }

    static {
        a = kotlinx.coroutines.sync.b.a();
    }

    public static String o(String r2) {
        return "detail_" + r2;
    }

    public static String p(String r2) {
        return "detail_revision_" + r2;
    }

    public static n r(String r5) {
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L25
        JSONObject r4 = new JSONObject(r5);     // Catch: Throwable -> L25
        if (r4.optInt("schema_version") == 1) goto L7;
    L22:
        n r6 = null;
    L23:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L25
    L28:
        if (Result.exceptionOrNull-impl(r7) != null) goto L30;
        r2 = r7;
    L32:
        return (n) r2;
    L30:
        FLogger.a.w("WorkExperienceCache", "discard malformed work experience detail cache");
        goto L32
    L7:
        if (r4.has("details") == false) goto L22;
        if (r4.has("full_content") == false) goto L22;
        if ((r4.opt("details") instanceof String) == false) goto L22;
        if ((r4.opt("full_content") instanceof String) == false) goto L22;
        JSONObject r8 = r4.optJSONObject("summary");     // Catch: Throwable -> L25
        if (r8 == null) goto L22;
        t r9 = w(r8);     // Catch: Throwable -> L25
        if (r9 == null) goto L22;
        r6 = new n(r9, r4.optString("details"), r4.optString("full_content"));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    public static List t(Keva r8) {
        String r2 = r8.getString("detail_index", null);
        if (r2 == null) goto L5;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        JSONArray r4 = new JSONArray(r2);     // Catch: Throwable -> L22
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L22
        int r6 = r4.length();     // Catch: Throwable -> L22
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L20;
        Object r9 = r4.opt(r7);     // Catch: Throwable -> L22
        if ((r9 instanceof String) == false) goto L11;
        String r10 = (String) r9;     // Catch: Throwable -> L22
    L12:
        if (r10 == null) goto L13;
        if ((!StringsKt.isBlank(r10)) == false) goto L19;
        if (r5.contains(r10) == true) goto L19;
        r5.add(r10);     // Catch: Throwable -> L22
    L19:
        r7 = r7 + 1;     // Catch: Throwable -> L22
        goto L7
    L13:
        r5 = new ArrayList();     // Catch: Throwable -> L22
        goto L20
    L11:
        r10 = null;
    L20:
        Object r1 = Result.constructor-impl(r5);     // Catch: Throwable -> L22
    L25:
        if (Result.exceptionOrNull-impl(r1) == null) goto L29;
        r8.erase("detail_index");
        r1 = new ArrayList();
    L29:
        return (List) r1;
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L5:
        return new ArrayList();
    }

    public static JSONObject v(t r4) {
        JSONObject r0 = new JSONObject().put("id", r4.a).put("name", r4.b).put("description", r4.c).put("type", r4.getType()).put("source", r4.e.getValue()).put("created_at", r4.f);
        JSONArray r1 = new JSONArray();
        Iterator<T> r2 = r4.g.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.put((String) r2.next());
        goto L4
    L6:
        Unit r3 = Unit.INSTANCE;
        return r0.put("tags", r1).put("auto_optimize", r4.h).put("updated_at", r4.i);
    }

    public static t w(JSONObject r24) {
        String[] r1 = {"id", "name", "description", "type", "source", "created_at", "tags", "auto_optimize", "updated_at"};
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 9) goto L15;
        String r4 = r1[r3];
        if (r24.has(r4) == true) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L13;
        r3 = r3 + 1;
        goto L4
    L13:
        boolean r6 = true;
    L17:
        if (r6 == false) goto L20;
        return null;
    L20:
        if ((r24.opt("id") instanceof String) == true) goto L22;
    L56:
        return null;
    L22:
        if ((r24.opt("name") instanceof String) == false) goto L56;
        if ((r24.opt("description") instanceof String) == false) goto L56;
        if ((r24.opt("type") instanceof String) == false) goto L56;
        if ((r24.opt("source") instanceof Number) == false) goto L56;
        if ((r24.opt("created_at") instanceof Number) == false) goto L56;
        if ((r24.opt("auto_optimize") instanceof Boolean) == false) goto L56;
        if ((r24.opt("updated_at") instanceof Number) == false) goto L56;
        String r7 = r24.optString("id");
        Intrinsics.checkNotNull(r7);
        if ((true ^ StringsKt.isBlank(r7)) == false) goto L39;
        String r13 = r7;
    L40:
        if (r13 != null) goto L42;
        return null;
    L42:
        JSONArray r8 = r24.optJSONArray("tags");
        if (r8 != null) goto L45;
        return null;
    L45:
        ArrayList r9 = new ArrayList();
        int r12 = r8.length();
    L46:
        if (r2 >= r12) goto L54;
        Object r14 = r8.opt(r2);
        if ((r14 instanceof String) == false) goto L50;
        String r15 = (String) r14;
    L51:
        if (r15 == null) goto L52;
        r9.add(r15);
        r2 = r2 + 1;
        goto L46
    L52:
        return null;
    L50:
        r15 = null;
        goto L51
    L54:
        String r16 = r24.optString("name");
        String r17 = r24.optString("description");
        String r19 = r24.optString("type");
        WorkExperienceSource.a r10 = WorkExperienceSource.Companion;
        Integer r11 = Integer.valueOf(r24.optInt("source"));
        r10.getClass();
        return new t(r13, r16, r17, r19, WorkExperienceSource.a.a(r11), r24.optLong("created_at"), r9, r24.optBoolean("auto_optimize"), r24.optLong("updated_at"));
    L39:
        r13 = null;
        goto L40
    L8:
        if (r24.isNull(r4) == true) goto L11;
        r5 = false;
        goto L12
    L15:
        r6 = false;
        goto L17
    }

    public static final Keva m(KevaWorkExperienceCache r1, String r2) {
        r1.getClass();
        StringBuilder r3 = new StringBuilder();
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        r3.append(r2);
        r3.append("_work_experience_cache");
        return Keva.getRepo(r3.toString(), 0);
    L7:
        throw new IllegalArgumentException("work experience cache requires an account".toString());
    }

    public static void n(Keva r7, String r8) {
        long r0 = r7.getLong(r8, 0);
        long r4 = 1;
        if (r0 == Long.MAX_VALUE) goto L6;
        r4 = 1 + r0;
    L6:
        r7.storeLong(r8, Math.max(r4, System.currentTimeMillis()));
    }

    public static void q(Keva r1, String r2) {
        r1.erase(o(r2));
        n(r1, p(r2));
        List r0 = t(r1);
        if (r0.remove(r2) == false) goto L6;
        u(r1, r0);
        return;
    }

    public static void u(Keva r2, List r3) {
        JSONArray r0 = new JSONArray();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.put((String) r4.next());
        goto L4
    L6:
        Unit r5 = Unit.INSTANCE;
        r2.storeString("detail_index", r0.toString());
    }

    public static void x(Keva r2, String r3) {
        List r0 = t(r2);
        r0.remove(r3);
        r0.add(r3);
    L4:
        if (r0.size() <= 50) goto L6;
        String r4 = (String) ListProtector.remove(r0, 0);
        r2.erase(o(r4));
        n(r2, p(r4));
        goto L4
    L6:
        u(r2, r0);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object g(String r2, Continuation<? super Boolean> r3) {
        return s(r2, new i(), r3);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object h(String r2, Continuation<? super Long> r3) {
        return s(r2, new com.larus.agents.impl.experience.a(), r3);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object i(String r2, Continuation<? super s> r3) {
        return s(r2, new h(this), r3);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object j(String r2, Continuation<? super Unit> r3) {
        Object r4 = y(r2, new b(this), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object k(String r2, Continuation<? super Long> r3) {
        return s(r2, new e(), r3);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object a(String r2, final String r3, Continuation<? super Unit> r4) {
        Object r5 = y(r2, new c(this, r3), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object c(String r2, final String r3, Continuation<? super n> r4) {
        return s(r2, new f(this, r3), r4);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object d(String r2, final String r3, Continuation<? super Long> r4) {
        return s(r2, new g(this, r3), r4);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object f(String r2, final boolean r3, Continuation<? super Unit> r4) {
        Object r5 = y(r2, new k(r3, this), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public final <T> Object s(String r4, Function1<? super Keva, ? extends T> r5, Continuation<? super T> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new KevaWorkExperienceCache$read$2(r5, this, r4, null), r6);
    }

    public final <T> Object y(String r4, Function1<? super Keva, ? extends T> r5, Continuation<? super T> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new KevaWorkExperienceCache$write$2(r5, this, r4, null), r6);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object b(String r2, final n r3, final long r4, Continuation<? super Boolean> r6) {
        return y(r2, new j(this, r3, r4), r6);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object e(String r2, final s r3, final long r4, Continuation<? super Boolean> r6) {
        return y(r2, new l(r4, r3, this), r6);
    }

    @Override // com.larus.agents.impl.experience.m
    public final Object l(String r2, final boolean r3, final long r4, Continuation<? super Boolean> r6) {
        return y(r2, new d(r4, r3), r6);
    }
}
