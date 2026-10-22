package com.obric.assistant.performance;

import android.os.Process;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricSettingsChangeMonitor$doSettingsChangeKill$1", f = "ObricSettingsChangeMonitor.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
final class ObricSettingsChangeMonitor$doSettingsChangeKill$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $newVersion;
    final /* synthetic */ int $oldVersion;
    int label;

    public ObricSettingsChangeMonitor$doSettingsChangeKill$1(int r1, int r2, Continuation<? super ObricSettingsChangeMonitor$doSettingsChangeKill$1> r3) {
        this.$oldVersion = r1;
        this.$newVersion = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricSettingsChangeMonitor$doSettingsChangeKill$1(this.$oldVersion, this.$newVersion, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L17:
        FLogger.a.i("ObricPerformanceMonitor", "doSettingsChangeKill: kill self process, pid=" + Process.myPid());
        Process.killProcess(Process.myPid());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        Lazy r10 = ObricSettingsChangeMonitor.a;
        int r11 = this.$oldVersion;
        int r2 = this.$newVersion;
        if (r2 == r11) goto L14;
        if (r2 <= r11) goto L12;
        String r4 = "settings_version_increase";
    L13:
        FLogger.a.i("ObricPerformanceMonitor", "reportSettingsChange, lastVersion=" + r11 + ", newVersion=" + r2 + ", reason=" + r4 + "，monitorTiming=" + ObricSettingsChangeMonitor.c + ", monitorMode=" + ObricSettingsChangeMonitor.d);
        JSONObject r5 = new JSONObject();
        r5.put(WindowEvent.Params.REASON, r4);
        r5.put("oldVersion", r11);
        r5.put("newVersion", r2);
        r5.put("monitorTiming", ObricSettingsChangeMonitor.c.toString());
        r5.put("monitorMode", ObricSettingsChangeMonitor.d.toString());
        r5.put("updateWaitTimeMillis", ObricSettingsChangeMonitor.e);
        o.a.reportEvent("obric_settings_version_change", r5);
        goto L14
    L12:
        r4 = "settings_version_decrease";
    L14:
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L17;
        return r0;
    }
}
