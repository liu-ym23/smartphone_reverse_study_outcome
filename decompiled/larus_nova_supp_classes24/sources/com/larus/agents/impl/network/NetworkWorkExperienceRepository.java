package com.larus.agents.impl.network;

import com.bytedance.retrofit2.SsResponse;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.experience.o;
import com.larus.agents.impl.experience.p;
import com.larus.agents.impl.experience.r;
import com.larus.agents.impl.experience.s;
import com.larus.agents.impl.experience.t;
import com.larus.agents.impl.experience.u;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class NetworkWorkExperienceRepository implements m {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public NetworkWorkExperienceRepository() {
    }

    public static boolean f(BizResponse r4) {
        SsResponse r5 = r4.getSSResponse();
        if (r5 == null) goto L5;
        String r6 = (String) r5.body();
    L6:
        boolean r1 = false;
        if (r6 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L30;
        return true;
    L30:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L22
        JSONObject r8 = new JSONObject(r6);     // Catch: Throwable -> L22
        if (r8.has("error") == true) goto L18;
    L20:
        Object r9 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L22
    L25:
        if (Result.exceptionOrNull-impl(r9) == null) goto L29;
        FLogger.a.w("WorkExperienceRemote", "parse experience response envelope failed");
        r9 = Boolean.TRUE;
    L29:
        return ((Boolean) r9).booleanValue();
    L18:
        if (r8.isNull("error") == true) goto L20;
        r1 = true;
    L22:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L9:
        if (StringsKt.isBlank(r6) == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    public static JSONObject j(p r3) {
        return new JSONObject().put("name", r3.a).put("description", r3.b).put("details", r3.c).put("auto_optimize", r3.d);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object e(Continuation<? super Result<Boolean>> r6) {
        if ((r6 instanceof NetworkWorkExperienceRepository$getEnabled$1) == false) goto L7;
        NetworkWorkExperienceRepository$getEnabled$1 r0 = (NetworkWorkExperienceRepository$getEnabled$1) r6;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        dm9.a.b r8 = (dm9.a) r7;
        if ((r8 instanceof dm9.a.b) == false) goto L36;
        BizResponse r9 = r8.a;
        k r5 = (k) r9.getData();
        if (r5 == null) goto L24;
        n r10 = r5.a();
        if (r10 == null) goto L24;
        Boolean r11 = r10.a();
    L26:
        if (f(r9) == false) goto L28;
    L30:
        r4 = false;
    L31:
        if (r4 == false) goto L34;
        if (r11 == null) goto L34;
        return Result.constructor-impl(r11);
    L34:
        g("get settings", r9.getCode());
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("get experience settings failed")));
    L28:
        if (r9.isSuccess() == false) goto L30;
    L24:
        r11 = null;
        goto L26
    L36:
        if ((r8 instanceof dm9.a.a) == false) goto L40;
        return i((dm9.a.a) r8, "get experience settings");
    L40:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        int r13 = l.a;
        JSONObject r14 = new JSONObject();
        r0.label = 1;
        r7 = l.a("/alice/office/experience/manage/get_settings", k.class, r14, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new NetworkWorkExperienceRepository$getEnabled$1(this, r6);
        goto L8
    }

    public static void g(String r2, long r3) {
        FLogger.a.w("WorkExperienceRemote", r2 + " experience failed, code=" + r3);
    }

    public static Object i(dm9.a.a r3, String r4) {
        FLogger.a.w("WorkExperienceRemote", r4 + " request error, code=" + r3.a);
        Result.Companion r0 = Result.Companion;
        Throwable r5 = r3.c;
        if (r5 != null) goto L6;
        r5 = new IllegalStateException(r4.concat(" request error"));
    L6:
        return Result.constructor-impl(ResultKt.createFailure(r5));
    }

    @Override // com.larus.agents.impl.network.m
    public final Object a(p r8, Continuation<? super WorkExperienceMutationResult> r9) {
        return h("/alice/office/experience/manage/create", "create", c.class, j(r8), new g(), r9);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object b(final boolean r8, Continuation<? super WorkExperienceMutationResult> r9) {
        return h("/alice/office/experience/manage/update_settings", "update settings", k.class, new JSONObject().put("enabled", r8), new h(r8), r9);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object c(String r6, Continuation<? super Result<com.larus.agents.impl.experience.n>> r7) {
        if ((r7 instanceof NetworkWorkExperienceRepository$getDetail$1) == false) goto L7;
        NetworkWorkExperienceRepository$getDetail$1 r0 = (NetworkWorkExperienceRepository$getDetail$1) r7;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
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
        if ((r9 instanceof dm9.a.b) == false) goto L48;
        BizResponse r10 = r9.a;
        if (f(r10) == false) goto L22;
    L24:
        r4 = false;
    L25:
        if (r4 == false) goto L46;
        c r11 = (c) r10.getData();
        if (r11 == null) goto L42;
        o r12 = r11.a();
        if (r12 == null) goto L42;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        u r13 = r12.c();
        if (r13 == null) goto L42;
        t r14 = r.a(r13);
        if (r14 == null) goto L42;
        String r5 = r12.a();
        if (r5 == null) goto L42;
        String r15 = r12.b();
        if (r15 != null) goto L41;
        r15 = "";
    L41:
        com.larus.agents.impl.experience.n r16 = new com.larus.agents.impl.experience.n(r14, r5, r15);
    L43:
        if (r16 != null) goto L53;
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("experience detail is empty")));
    L53:
        return Result.constructor-impl(r16);
    L42:
        r16 = null;
        goto L43
    L46:
        g("get detail", r10.getCode());
        Result.Companion r19 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("get experience detail failed")));
    L22:
        if (r10.isSuccess() == false) goto L24;
    L48:
        if ((r9 instanceof dm9.a.a) == false) goto L52;
        return i((dm9.a.a) r9, "get experience detail");
    L52:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        int r20 = l.a;
        JSONObject r21 = new JSONObject().put("experience_id", r6);
        r0.label = 1;
        r8 = l.a("/alice/office/experience/manage/get_detail", c.class, r21, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new NetworkWorkExperienceRepository$getDetail$1(this, r7);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public Object delete(String r8, Continuation<? super WorkExperienceMutationResult> r9) {
        return h("/alice/office/experience/manage/delete", "delete", b.class, new JSONObject().put("experience_id", r8), new f(), r9);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object d(int r6, String r7, Continuation<? super Result<s>> r8) {
        if ((r8 instanceof NetworkWorkExperienceRepository$list$1) == false) goto L7;
        NetworkWorkExperienceRepository$list$1 r0 = (NetworkWorkExperienceRepository$list$1) r8;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L25:
        dm9.a.b r10 = (dm9.a) r9;
        if ((r10 instanceof dm9.a.b) == false) goto L61;
        BizResponse r11 = r10.a;
        e r12 = (e) r11.getData();
        if (f(r11) == false) goto L30;
    L32:
        boolean r13 = false;
    L33:
        if (r13 == false) goto L59;
        if (r12 == null) goto L36;
        List<u> r14 = r12.b();
    L37:
        if (r14 == null) goto L59;
        if (r12.a() == null) goto L59;
        List<u> r15 = r12.b();
        ArrayList r5 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L42:
        if (r16.hasNext() == false) goto L50;
        u r17 = (u) r16.next();
        if (r17 == null) goto L46;
        t r19 = r.a(r17);
    L47:
        if (r19 == null) goto L42;
        r5.add(r19);
        goto L42
    L46:
        r19 = null;
        goto L47
    L50:
        if (r5.size() == r12.b().size()) goto L53;
        g("list malformed item", r11.getCode());
        Result.Companion r20 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("list experiences contains malformed item")));
    L53:
        Result.Companion r21 = Result.Companion;
        String r22 = r12.c();
        if (r22 == null) goto L71;
        if ((!StringsKt.isBlank(r22)) == false) goto L71;
        r4 = r22;
    L71:
        return Result.constructor-impl(new s(r5, r4, r12.a().booleanValue()));
    L36:
        r14 = null;
    L59:
        g("list", r11.getCode());
        Result.Companion r23 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("list experiences failed")));
    L30:
        if (r11.isSuccess() == false) goto L32;
        r13 = true;
        goto L33
    L61:
        if ((r10 instanceof dm9.a.a) == false) goto L65;
        return i((dm9.a.a) r10, "list experiences");
    L65:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        JSONObject r24 = new JSONObject().put("page_size", RangesKt.coerceIn(r6, 1, 100));
        if (r7 != null) goto L17;
    L22:
        int r25 = l.a;
        Intrinsics.checkNotNull(r24);
        r0.label = 1;
        r9 = l.a("/alice/office/experience/manage/list", e.class, r24, r0);
        if (r9 != r2) goto L25;
        return r2;
    L17:
        if ((!StringsKt.isBlank(r7)) == true) goto L20;
        r7 = null;
    L20:
        if (r7 == null) goto L22;
        r24.put("page_token", r7);
    L7:
        r0 = new NetworkWorkExperienceRepository$list$1(this, r8);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public Object update(String r8, p r9, Continuation<? super WorkExperienceMutationResult> r10) {
        return h("/alice/office/experience/manage/update", "update", c.class, j(r9).put("experience_id", r8), new i(), r10);
    }

    public final <T> Object h(String r5, String r6, Class<T> r7, JSONObject r8, Function1<? super T, Boolean> r9, Continuation<? super WorkExperienceMutationResult> r10) {
        if ((r10 instanceof NetworkWorkExperienceRepository$mutation$1) == false) goto L7;
        NetworkWorkExperienceRepository$mutation$1 r0 = (NetworkWorkExperienceRepository$mutation$1) r10;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (Function1) r0.L$1;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L17:
        dm9.a.b r12 = (dm9.a) r11;
        if ((r12 instanceof dm9.a.b) == false) goto L43;
        BizResponse r13 = r12.a;
        if (r13.getCode() == 0) goto L32;
        long r14 = r13.getCode();
        if (r14 != 0) goto L25;
        WorkExperienceMutationResult r15 = WorkExperienceMutationResult.SUCCESS;
    L35:
        WorkExperienceMutationResult r16 = WorkExperienceMutationResult.SUCCESS;
        if (r15 == r16) goto L38;
    L40:
        if (r15 == r16) goto L48;
        g(r6, r13.getCode());
        return r15;
    L48:
        return r15;
    L38:
        if (((Boolean) r9.invoke(r13.getData())).booleanValue() == true) goto L40;
        r15 = WorkExperienceMutationResult.FAILURE;
        goto L40
    L25:
        if (r14 != 671020000) goto L28;
        r15 = WorkExperienceMutationResult.SECURITY_RISK;
        goto L35
    L28:
        if (r14 != 671000006) goto L30;
        r15 = WorkExperienceMutationResult.DUPLICATE_NAME;
        goto L35
    L30:
        r15 = WorkExperienceMutationResult.FAILURE;
        goto L35
    L32:
        if (f(r13) == false) goto L34;
        r15 = WorkExperienceMutationResult.FAILURE;
        goto L35
    L34:
        r15 = WorkExperienceMutationResult.SUCCESS;
        goto L35
    L43:
        if ((r12 instanceof dm9.a.a) == false) goto L47;
        FLogger.a.w("WorkExperienceRemote", r6 + " experience request error, code=" + ((dm9.a.a) r12).a);
        return WorkExperienceMutationResult.FAILURE;
    L47:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        int r17 = l.a;
        r0.L$0 = r6;
        r0.L$1 = r9;
        r0.label = 1;
        r11 = l.a(r5, r7, r8, r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new NetworkWorkExperienceRepository$mutation$1(this, r10);
        goto L8
    }
}
