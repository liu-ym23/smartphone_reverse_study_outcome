package com.obric.audio.enroll;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.VoiceEnrollServiceImpl$tryDeleteBtAndDoraVoicePrintOnce$1", f = "VoiceEnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceEnrollServiceImpl$tryDeleteBtAndDoraVoicePrintOnce$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VoiceEnrollServiceImpl this$0;

    public VoiceEnrollServiceImpl$tryDeleteBtAndDoraVoicePrintOnce$1(VoiceEnrollServiceImpl r1, Continuation<? super VoiceEnrollServiceImpl$tryDeleteBtAndDoraVoicePrintOnce$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        VoiceEnrollServiceImpl$tryDeleteBtAndDoraVoicePrintOnce$1 r0 = new VoiceEnrollServiceImpl$tryDeleteBtAndDoraVoicePrintOnce$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L72;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        AppHost.Companion r14 = AppHost.a;
        if (sia.e.a(r14.getApplication()) == true) goto L73;
        FLogger.a.i("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce skip: network unavailable");
        this.this$0.f.set(false);
        return Unit.INSTANCE;
    L73:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        nia.a.a.i(r14.getApplication());     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L77:
        nia.a.a.getClass();     // Catch: Throwable -> L14
        Object r15 = Result.constructor-impl(nia.a.f());     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r15) == false) goto L19;
        r15 = null;
    L19:
        String r16 = (String) r15;
        if (r16 != null) goto L23;
        r16 = "";
    L23:
        if (StringsKt.isBlank(r16) == false) goto L26;
        FLogger.a.i("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce skip: sami token not ready");
        this.this$0.f.set(false);
        return Unit.INSTANCE;
    L26:
        VoiceEnrollServiceImpl.a r17 = this.this$0.e;
        Object r1 = r17.a;
        monitor-enter(r1);
        JSONObject r18 = r17.e().optJSONObject("devices");     // Catch: Throwable -> L68
        if (r18 != null) goto L31;
        r18 = new JSONObject();     // Catch: Throwable -> L68
    L31:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L68
        Iterator<String> r19 = r18.keys();     // Catch: Throwable -> L68
    L33:
        if (r19.hasNext() == false) goto L35;
        r2.add(r19.next());     // Catch: Throwable -> L68
        goto L33
    L35:
        CollectionsKt.sort(r2);     // Catch: Throwable -> L68
        FLogger r110 = FLogger.a;     // Catch: Throwable -> L68
        r110.i("BluetoothDeviceStore", "getAllDeviceSns size=" + r2.size());     // Catch: Throwable -> L68
        monitor-exit(r1);
        r110.i("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce start size=" + r2.size());
        Ref.BooleanRef r111 = new Ref.BooleanRef();
        r111.element = true;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L57
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L57
    L40:
        if (r4.hasNext() == false) goto L55;
        String r5 = (String) r4.next();     // Catch: Throwable -> L57
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L44
        Object r7 = Result.constructor-impl(Boxing.boxBoolean(SamiEnrollEngine.a.k(r5)));     // Catch: Throwable -> L44
    L46:
        Throwable r8 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L57
        if (r8 == null) goto L49;
        FLogger.a.e("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce delete failed sn=" + r5 + ' ' + r8.getMessage());     // Catch: Throwable -> L57
    L49:
        Boolean r9 = Boxing.boxBoolean(false);     // Catch: Throwable -> L57
        if (Result.isFailure-impl(r7) == false) goto L53;
        r7 = r9;
    L53:
        if (((Boolean) r7).booleanValue() == true) goto L40;
        r111.element = false;     // Catch: Throwable -> L57
        goto L40
    L44:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L57
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L46
    L55:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L57
    L59:
        Throwable r20 = Result.exceptionOrNull-impl(r11);
        if (r20 == null) goto L63;
        FLogger.a.e("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce failed: " + r20.getMessage());
        r111.element = false;
    L63:
        if (r111.element == false) goto L65;
        this.this$0.e.a();
        pia.b r112 = pia.b.a;
        Intrinsics.checkNotNullParameter("sva_bt_dora_voiceprint_delete_once_v1", "key");
        pia.b.a().storeBoolean("sva_bt_dora_voiceprint_delete_once_v1", true);
        FLogger.a.i("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce marked executed size=" + r2.size());
    L67:
        return Unit.INSTANCE;
    L65:
        this.this$0.f.set(false);
        FLogger.a.i("VoiceEnrollServiceImpl", "tryDeleteBtAndDoraVoicePrintOnce keep for retry size=" + r2.size());
    L57:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L68:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L72:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
