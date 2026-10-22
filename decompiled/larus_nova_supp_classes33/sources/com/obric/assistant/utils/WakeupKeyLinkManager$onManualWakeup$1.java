package com.obric.assistant.utils;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.utils.WakeupKeyLinkManager$onManualWakeup$1", f = "WakeupKeyLinkManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupKeyLinkManager$onManualWakeup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public WakeupKeyLinkManager$onManualWakeup$1(Continuation<? super WakeupKeyLinkManager$onManualWakeup$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new WakeupKeyLinkManager$onManualWakeup$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L50;
        ResultKt.throwOnFailure(r17);
        FLogger r5 = FLogger.a;
        r5.i("WakeupKeyLinkManager", "onManualWakeup");
        String r7 = rna.b.a;
        sna.h r8 = sna.h.a;
        long r9 = sna.h.a().getLong("voiceprint_fail_time", 0);
        if (r9 > 0) goto L7;
        sna.h.b("getVoiceprintFailRecord cache miss");
        sna.h.b r12 = null;
    L12:
        if (r12 == null) goto L14;
        rna.b.c r10 = new rna.b.c(r12.a, r12.b);
    L15:
        if (r10 != null) goto L18;
        r5.i("WakeupKeyLinkManager", "onManualWakeup: no pending voiceprint fail record");
        return Unit.INSTANCE;
    L18:
        long r13 = r10.a;
        String r11 = r10.b;
        long r14 = System.currentTimeMillis();
        r5.i("WakeupKeyLinkManager", "onManualWakeup: t2=" + r14 + ", record=" + r13 + ", wakeupId=" + r11);
        long r15 = r14 - r13;
        if (0 <= r15) goto L21;
    L23:
        boolean r16 = false;
    L53:
        if (r16 == false) goto L29;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L27
        r3.put("delta_ms", r15);     // Catch: Throwable -> L27
        r3.put("wakeup_fail_timestamp", r13);     // Catch: Throwable -> L27
        r3.put("wakeup_id", r11);     // Catch: Throwable -> L27
        r3.put("key_press_settings", ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS);     // Catch: Throwable -> L27
        by7.a r18 = new by7.a("wakeup_keypress_link");     // Catch: Throwable -> L27
        r18.a.merge(new TrackParams().merge(r3));     // Catch: Throwable -> L27
        r18.b();     // Catch: Throwable -> L27
        g.a.monitorEventForSlardar("wakeup_keypress_link", r3, null, null);     // Catch: Throwable -> L27
        r5.i("WakeupKeyLinkManager", "report wakeup_keypress_link: deltaMs=" + r15 + ", wakeupId=" + r11);     // Catch: Throwable -> L27
    L57:
        WakeupKeyLinkManager.a();     // Catch: Throwable -> L32
    L41:
        return Unit.INSTANCE;
    L32:
        th = th;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("clear repository fail: ");
    L39:
        r2.append(th.getMessage());
        r1.w("WakeupKeyLinkManager", r2.toString());
        goto L41
    L29:
        r5.i("WakeupKeyLinkManager", "skip report, out of window: deltaMs=" + r15 + ", wakeupId=" + r11);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        FLogger.a.w("WakeupKeyLinkManager", "report fail: " + th.getMessage());     // Catch: Throwable -> L42
        WakeupKeyLinkManager.a();     // Catch: Throwable -> L37
    L37:
        th = th;
        r1 = FLogger.a;
        r2 = new StringBuilder("clear repository fail: ");
    L42:
        th = move-exception;
        WakeupKeyLinkManager.a();     // Catch: Throwable -> L46
        throw th;
    L46:
        th = move-exception;
        FLogger.a.w("WakeupKeyLinkManager", "clear repository fail: " + th.getMessage());
        throw th;
    L21:
        if (r15 >= 10001) goto L23;
        r16 = true;
        goto L53
    L14:
        r10 = null;
        goto L15
    L7:
        String r19 = "";
        String r110 = sna.h.a().getString("voiceprint_fail_wakeup_id", "");
        if (r110 == null) goto L11;
        r19 = r110;
    L11:
        r12 = new sna.h.b(r9, r19);
        sna.h.b("getVoiceprintFailRecord success, failTime=" + r12.a + ", wakeupIdLength=" + r12.b.length());
        goto L12
    L50:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
