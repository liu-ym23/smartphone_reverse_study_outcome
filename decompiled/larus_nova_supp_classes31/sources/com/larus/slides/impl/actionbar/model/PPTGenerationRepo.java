package com.larus.slides.impl.actionbar.model;

import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class PPTGenerationRepo {
    public static final PPTGenerationRepo a = null;

    static {
        a = new PPTGenerationRepo();
    }

    public PPTGenerationRepo() {
    }

    public final Object a(int r16, int r17, Continuation<? super com.larus.network.http.a<d>> r18) {
        if ((r18 instanceof PPTGenerationRepo$getPPTTemplateListData$1) == false) goto L7;
        PPTGenerationRepo$getPPTTemplateListData$1 r1 = (PPTGenerationRepo$getPPTTemplateListData$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        PPTGenerationRepo$getPPTTemplateListData$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L28:
        com.larus.network.http.a r5 = (com.larus.network.http.a) r0;
        FLogger.a.i("PPTGenerationRepo", "getPPTTemplateListData end");
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("PPTGenerationRepo", "getPPTTemplateListData start");
        b.a r6 = b.a;
        if (b.b != null) goto L25;
        monitor-enter(r6);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (b.b != null) goto L20;
        b.b = new b();     // Catch: Throwable -> L22
    L20:
        monitor-exit(r6);
    L25:
        r13.label = 1;
        JSONObject r7 = new JSONObject();
        r7.put("cursor", r16);
        r7.put("page_size", r17);
        Unit r8 = Unit.INSTANCE;
        r0 = HttpExtKt.k("Basic", d.class, "/alice/aippt/template_list", r7, null, null, true, null, null, null, r13, 944);
        if (r0 != r3) goto L28;
        return r3;
    L7:
        r1 = new PPTGenerationRepo$getPPTTemplateListData$1(this, r18);
        goto L8
    }
}
