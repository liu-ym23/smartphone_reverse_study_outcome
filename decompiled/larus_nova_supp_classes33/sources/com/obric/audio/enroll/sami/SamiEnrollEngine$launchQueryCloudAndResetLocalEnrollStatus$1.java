package com.obric.audio.enroll.sami;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.sami.SamiEnrollEngine$launchQueryCloudAndResetLocalEnrollStatus$1", f = "SamiEnrollEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SamiEnrollEngine$launchQueryCloudAndResetLocalEnrollStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public SamiEnrollEngine$launchQueryCloudAndResetLocalEnrollStatus$1(Continuation<? super SamiEnrollEngine$launchQueryCloudAndResetLocalEnrollStatus$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        SamiEnrollEngine$launchQueryCloudAndResetLocalEnrollStatus$1 r0 = new SamiEnrollEngine$launchQueryCloudAndResetLocalEnrollStatus$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L90;
        ResultKt.throwOnFailure(r17);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L82
        sia.b r2 = sia.b.a;     // Catch: Throwable -> L82
        AppHost.Companion r6 = AppHost.a;     // Catch: Throwable -> L82
        Application r7 = r6.getApplication();     // Catch: Throwable -> L82
        r2.getClass();     // Catch: Throwable -> L82
        String r8 = sia.b.c(r7);     // Catch: Throwable -> L82
        String r9 = sia.b.a(r6.getApplication());     // Catch: Throwable -> L82
        pia.b r3 = pia.b.a;     // Catch: Throwable -> L82
        String r4 = pia.b.b("sva_bt_headset_voiceprint_devices_v1");     // Catch: Throwable -> L82
        if (StringsKt.isBlank(r4) == false) goto L95;
        if (r8 != null) goto L10;
        FLogger.a.i("SamiEnrollEngine", "resetLocalEnrollStatus ignored: local empty");     // Catch: Throwable -> L82
    L80:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L82
    L84:
        Throwable r10 = Result.exceptionOrNull-impl(r5);
        if (r10 == null) goto L88;
        FLogger.a.e("SamiEnrollEngine", "resetLocalEnrollStatus failed: " + r10.getMessage());
    L88:
        return Unit.INSTANCE;
    L10:
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L82
        r11.put("version", 1);     // Catch: Throwable -> L82
        r11.put("devices", new JSONObject());     // Catch: Throwable -> L82
    L11:
        JSONObject r12 = r11;
        JSONObject r13 = r12.optJSONObject("devices");     // Catch: Throwable -> L82
        if (r13 != null) goto L28;
        r13 = new JSONObject();     // Catch: Throwable -> L82
        r12.put("devices", r13);     // Catch: Throwable -> L82
    L28:
        JSONObject r14 = r13;
        if (r8 == null) goto L40;
        JSONObject r15 = r14.optJSONObject(r8);     // Catch: Throwable -> L82
        if (r15 != null) goto L33;
        r15 = new JSONObject();     // Catch: Throwable -> L82
        r14.put(r8, r15);     // Catch: Throwable -> L82
    L33:
        r15.put("enrolled", false);     // Catch: Throwable -> L82
        if (r9 == null) goto L38;
        r15.put("name", r9);     // Catch: Throwable -> L82
        goto L40
    L38:
        if (r15.has("name") == true) goto L40;
        r15.put("name", "");     // Catch: Throwable -> L82
    L40:
        Iterator<String> r16 = r14.keys();     // Catch: Throwable -> L82
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L82
    L42:
        if (r16.hasNext() == false) goto L48;
        String r19 = r16.next();     // Catch: Throwable -> L82
        if (r14.optJSONObject(r19) == null) goto L42;
        r18.add(r19);     // Catch: Throwable -> L82
        goto L42
    L48:
        if (r18.isEmpty() == false) goto L50;
        FLogger.a.i("SamiEnrollEngine", "resetLocalEnrollStatus ignored: no enrolled devices");     // Catch: Throwable -> L82
        goto L80
    L50:
        Iterator r20 = r18.iterator();     // Catch: Throwable -> L82
    L52:
        if (r20.hasNext() == false) goto L79;
        String r21 = (String) r20.next();     // Catch: Throwable -> L82
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L56
        Object r23 = Result.constructor-impl(Boxing.boxBoolean(SamiEnrollEngine.a.query(r21)));     // Catch: Throwable -> L56
    L58:
        Throwable r110 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L82
        if (r110 == null) goto L62;
        FLogger.a.e("SamiEnrollEngine", "resetLocalEnrollStatus query failed sn=" + r21 + ' ' + r110.getMessage());     // Catch: Throwable -> L82
    L62:
        if (Result.isFailure-impl(r23) == false) goto L64;
        r23 = null;
    L64:
        Boolean r24 = (Boolean) r23;     // Catch: Throwable -> L82
        if (r24 == null) goto L67;
        boolean r25 = r24.booleanValue();     // Catch: Throwable -> L82
    L68:
        JSONObject r26 = r14.optJSONObject(r21);     // Catch: Throwable -> L82
        if (r26 == null) goto L52;
        if (r25 == false) goto L73;
        boolean r111 = true;
    L74:
        r26.put("enrolled", r111);     // Catch: Throwable -> L82
        FLogger r27 = FLogger.a;     // Catch: Throwable -> L82
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L82
        r112.append("resetLocalEnrollStatus sn=");     // Catch: Throwable -> L82
        r112.append(r21);     // Catch: Throwable -> L82
        r112.append(" cloudExisted=");     // Catch: Throwable -> L82
        if (r25 == false) goto L77;
        boolean r28 = true;
    L78:
        r112.append(r28);     // Catch: Throwable -> L82
        r27.i("SamiEnrollEngine", r112.toString());     // Catch: Throwable -> L82
        goto L52
    L77:
        r28 = false;
        goto L78
    L73:
        r111 = false;
        goto L74
    L67:
        r25 = false;
        goto L68
    L56:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L82
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L82
        goto L58
    L79:
        pia.b r29 = pia.b.a;     // Catch: Throwable -> L82
        pia.b.c("sva_bt_headset_voiceprint_devices_v1", r12.toString());     // Catch: Throwable -> L82
        FLogger.a.i("SamiEnrollEngine", "resetLocalEnrollStatus done size=" + r18.size());     // Catch: Throwable -> L82
        goto L80
    L95:
        Object r30 = Result.constructor-impl(new JSONObject(r4));     // Catch: Throwable -> L14
    L16:
        Throwable r31 = Result.exceptionOrNull-impl(r30);     // Catch: Throwable -> L82
        if (r31 == null) goto L20;
        FLogger.a.e("SamiEnrollEngine", "resetLocalEnrollStatus parse failed: " + r31.getMessage());     // Catch: Throwable -> L82
    L20:
        if (Result.isFailure-impl(r30) == false) goto L22;
        r30 = null;
    L22:
        r11 = (JSONObject) r30;     // Catch: Throwable -> L82
        if (r11 != null) goto L11;
    L14:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L82
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L84
    L90:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
