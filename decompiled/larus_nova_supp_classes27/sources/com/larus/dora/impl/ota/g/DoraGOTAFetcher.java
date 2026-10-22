package com.larus.dora.impl.ota.g;

import com.google.gson.reflect.TypeToken;
import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.request.v2.DoraRequestXV2;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraGOTAFetcher {
    public static final DoraGOTAFetcher a = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<h69.a> {
        public a() {
        }
    }

    static {
        a = new DoraGOTAFetcher();
    }

    public DoraGOTAFetcher() {
    }

    public final Object a(Continuation<? super e49.a> r10) {
        if ((r10 instanceof DoraGOTAFetcher$getPeripheralResponse$1) == false) goto L7;
        DoraGOTAFetcher$getPeripheralResponse$1 r0 = (DoraGOTAFetcher$getPeripheralResponse$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        w39.a r4 = (w39.a) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L25:
        com.larus.dora.impl.core.request.v2.a r12 = (com.larus.dora.impl.core.request.v2.a) r11;
        if ((r12 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L100;
        g49.d.b("DoraRequestXV2", "request<T>: failed, " + r12);
        Result.Companion r5 = Result.Companion;
        Object r13 = Result.constructor-impl(ResultKt.createFailure(new Exception("Request failed: " + r12)));
    L36:
        if (Result.isFailure-impl(r13) == false) goto L38;
        r13 = null;
    L38:
        h69.a r14 = (h69.a) r13;
        StringBuilder r6 = new StringBuilder("getPeripheralResponse: status=");
        if (r14 == null) goto L41;
        Integer r7 = r14.c();
    L42:
        r6.append(r7);
        g49.d.d("DoraGOTAFetcher", r6.toString());
        StringBuilder r8 = new StringBuilder("getPeripheralResponse: message=");
        if (r14 == null) goto L45;
        String r9 = r14.b();
    L46:
        r8.append(r9);
        g49.d.d("DoraGOTAFetcher", r8.toString());
        if (r14 == null) goto L51;
        h69.b r15 = r14.a();
        if (r15 == null) goto L51;
        z39.a r16 = r15.a();
    L52:
        StringBuilder r17 = new StringBuilder("getPeripheralResponse: packageCount=");
        if (r16 == null) goto L57;
        List<OTAUpdatePackage> r18 = r16.b();
        if (r18 == null) goto L57;
        int r20 = r18.size();
    L58:
        r17.append(r20);
        r17.append(", hasMeta=");
        if (r16 == null) goto L61;
        OTAUpdateMeta r21 = r16.a();
    L62:
        if (r21 == null) goto L64;
        boolean r22 = true;
    L65:
        r17.append(r22);
        r17.append(", hasTrace=");
        if (r16 == null) goto L68;
        String r23 = r16.d();
    L69:
        if (r23 != null) goto L71;
    L74:
        boolean r24 = true;
    L75:
        r17.append(!r24);
        r17.append(", hasTaskId=");
        if (r16 == null) goto L78;
        String r25 = r16.c();
    L79:
        if (r25 != null) goto L81;
    L84:
        boolean r26 = true;
    L85:
        r17.append(!r26);
        g49.d.d("DoraGOTAFetcher", r17.toString());
        if (r14 == null) goto L93;
        Integer r110 = r14.c();
        if (r110 == null) goto L93;
        if (r110.intValue() != 0) goto L93;
        boolean r111 = true;
    L94:
        if (r111 == false) goto L98;
        if (r16 == null) goto L98;
        return new e49.a(r16, false, true, 2);
    L98:
        return null;
    L93:
        r111 = false;
        goto L94
    L81:
        if (StringsKt.isBlank(r25) == true) goto L84;
        r26 = false;
        goto L85
    L78:
        r25 = null;
        goto L79
    L71:
        if (StringsKt.isBlank(r23) == true) goto L74;
        r24 = false;
        goto L75
    L68:
        r23 = null;
        goto L69
    L64:
        r22 = false;
        goto L65
    L61:
        r21 = null;
    L57:
        r20 = 0;
    L51:
        r16 = null;
        goto L52
    L45:
        r9 = null;
        goto L46
    L41:
        r7 = null;
        goto L42
    L100:
        Type r27 = new a().getType();     // Catch: Throwable -> L32
        byte[] r112 = ((com.larus.dora.impl.core.request.v2.a.b) r12).a;     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r27);     // Catch: Throwable -> L32
        Object r113 = r4.a(r112, r27);     // Catch: Throwable -> L32
        if (r113 != null) goto L30;
        g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L32
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L32
        r13 = Result.constructor-impl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L32
    L99:
        goto L36
    L30:
        r13 = Result.constructor-impl(r113);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        g49.d.c("DoraRequestXV2", "request<T>: parse error", th);
        Result.Companion r28 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
    L20:
        if (((Boolean) r11).booleanValue() == false) goto L98;
        DoraRequestXV2 r115 = DoraRequestXV2.a;
        gk4.a r30 = new gk4.a();
        Lazy<w39.d> r31 = w39.d.b;
        w39.d r32 = w39.d.a.a();
        r0.L$0 = r32;
        r0.label = 2;
        r11 = r115.a(r30, 5000, r0);
        if (r11 != r2) goto L24;
        return r2;
    L24:
        r4 = r32;
        goto L25
    L16:
        ResultKt.throwOnFailure(r11);
        sk4.e r116 = o0.a;
        r0.label = 1;
        r11 = o0.f();
        if (r11 != r2) goto L20;
        return r2;
    L7:
        r0 = new DoraGOTAFetcher$getPeripheralResponse$1(this, r10);
        goto L8
    }
}
