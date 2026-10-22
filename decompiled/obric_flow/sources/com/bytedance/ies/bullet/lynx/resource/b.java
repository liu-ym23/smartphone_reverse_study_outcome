package com.bytedance.ies.bullet.lynx.resource;

import ai.j0;
import android.net.Uri;
import com.bytedance.ies.bullet.service.base.a0;
import com.google.common.reflect.w;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5721c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public b(com.bytedance.ies.bullet.lynx.resource.forest.h r5, com.bytedance.forest.postprocessor.g r10, go.a r11, LynxResourceRequest$LynxResourceType r12) {
        this.f5719a = 1;
        this.d = r5;
        this.e = r10;
        this.f5720b = r11;
        this.f5721c = r12;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String r5 = null;
        Object r10 = this.e;
        Object r11 = this.f5720b;
        Object r12 = this.f5721c;
        Object r13 = this.d;
        switch(this.f5719a) {
            case 0: goto L45;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        a0 r14 = (a0) r13;
        ug.d r15 = r14.f5950x;
        JSONObject r16 = new JSONObject();
        Uri r17 = r14.f5932a;
        r16.put("res_url", r17.toString());
        r16.put("res_state", (String) r12);
        r16.put("preload", "0");
        r15.f = r16;
        ug.d r18 = r14.f5950x;
        if (((JSONObject) r18.d) == null) goto L8;
        wc.e r19 = (wc.e) r11;
        gc.a r20 = r19.f22834m;
        ArrayList r21 = gc.e.f17086a;
        r18.e = Boolean.valueOf(gc.e.b(r17.toString(), r19));
        Unit r22 = Unit.INSTANCE;
        r20.e((wc.g) r10, r18);
    L8:
        return Unit.INSTANCE;
    L9:
        com.bytedance.ies.bullet.lynx.resource.forest.h r23 = (com.bytedance.ies.bullet.lynx.resource.forest.h) r13;
        com.bytedance.forest.postprocessor.g r24 = (com.bytedance.forest.postprocessor.g) r10;
        go.a r25 = (go.a) r11;
        LynxResourceRequest$LynxResourceType r26 = (LynxResourceRequest$LynxResourceType) r12;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L13
        r23.getClass();     // Catch: Throwable -> L13
        com.bytedance.forest.postprocessor.g r28 = u8.a.a(r24);     // Catch: Throwable -> L13
        if (r28 == null) goto L15;
        TemplateBundle r29 = (TemplateBundle) r28.o();     // Catch: Throwable -> L13
    L16:
        if (r29 == null) goto L19;
        if (r25 == null) goto L32;
        jo.a r30 = new jo.a();     // Catch: Throwable -> L13
        r30.f18401b = r29;     // Catch: Throwable -> L13
        r25.f(w.a(r30));     // Catch: Throwable -> L13
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L33:
        Object r32 = Result.m124constructorimpl(r31);     // Catch: Throwable -> L13
    L36:
        Throwable r33 = Result.m127exceptionOrNullimpl(r32);
        if (r33 == null) goto L44;
        if (r25 == null) goto L44;
        StringBuilder r34 = new StringBuilder();
        if (r26 == null) goto L42;
        r5 = r26.name();
    L42:
        r34.append(r5);
        r34.append(" load error, ");
        r34.append(r33.getMessage());
        r25.f(w.b(new Error(r34.toString())));
    L44:
        return Result.m123boximpl(r32);
    L32:
        r31 = null;
        goto L33
    L19:
        byte[] r35 = r24.k();     // Catch: Throwable -> L13
        if (r35 == null) goto L22;
        int r36 = r35.length;     // Catch: Throwable -> L13
    L23:
        if (r36 <= 0) goto L26;
        if (r25 == null) goto L32;
        jo.a r37 = new jo.a();     // Catch: Throwable -> L13
        r37.f18400a = r35;     // Catch: Throwable -> L13
        r25.f(w.a(r37));     // Catch: Throwable -> L13
        r31 = Unit.INSTANCE;     // Catch: Throwable -> L13
        goto L33
    L26:
        if (r25 == null) goto L32;
        StringBuilder r38 = new StringBuilder();     // Catch: Throwable -> L13
        if (r26 == null) goto L30;
        String r39 = r26.name();     // Catch: Throwable -> L13
    L31:
        r38.append(r39);     // Catch: Throwable -> L13
        r38.append(" load error, bytes is empty");     // Catch: Throwable -> L13
        r25.f(w.b(new Error(r38.toString())));     // Catch: Throwable -> L13
        r31 = Unit.INSTANCE;     // Catch: Throwable -> L13
        goto L33
    L30:
        r39 = null;
        goto L31
    L22:
        r36 = -1;
        goto L23
    L15:
        r29 = null;
    L13:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r32 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L36
    L45:
        byte[] r41 = ((a0) r13).b();
        LynxResourceRequest$LynxResourceType r42 = (LynxResourceRequest$LynxResourceType) r12;
        c r43 = (c) r10;
        go.a r44 = (go.a) r11;
        if (r41 != null) goto L48;
    L58:
        w r45 = w.b(new Error("InputStream is null"));
        Intrinsics.checkNotNull(r45, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<kotlin.ByteArray>");
        r44.f(r45);
        int r46 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        r43.getClass();
        StringBuilder r47 = new StringBuilder("get ");
        if (r42 == null) goto L61;
        String r48 = r42.name();
    L62:
        com.bytedance.ies.bullet.base.utils.logger.a.d("DefaultLynxGenericResourceProvider", j0.q(r47, r48, " resource failed: InputStream is null"), null, 12);
    L64:
        return Unit.INSTANCE;
    L61:
        r48 = null;
        goto L62
    L48:
        if (r41.length != 0) goto L50;
        boolean r49 = true;
    L52:
        if ((!r49) != true) goto L58;
        r44.f(w.a(r41));
        int r50 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        r43.getClass();
        StringBuilder r51 = new StringBuilder("get ");
        if (r42 == null) goto L56;
        String r52 = r42.name();
    L57:
        com.bytedance.ies.bullet.base.utils.logger.a.g("DefaultLynxGenericResourceProvider", j0.q(r51, r52, " resource success"), null, 12);
        goto L64
    L56:
        r52 = null;
        goto L57
    L50:
        r49 = false;
        goto L52
    }

    public /* synthetic */ b(a0 r5, Object r10, Object r11, Object r12, int r13) {
        this.f5719a = r13;
        this.d = r5;
        this.f5720b = r10;
        this.e = r11;
        this.f5721c = r12;
    }
}
