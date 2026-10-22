package com.obric.assistant.performance;

import android.app.Activity;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryReportServiceImpl$reportAsync$1", f = "ObricMemoryReportServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricMemoryReportServiceImpl$reportAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ JSONObject $json;
    int label;
    final /* synthetic */ ObricMemoryReportServiceImpl this$0;

    public ObricMemoryReportServiceImpl$reportAsync$1(JSONObject r1, String r2, ObricMemoryReportServiceImpl r3, Continuation<? super ObricMemoryReportServiceImpl$reportAsync$1> r4) {
        this.$json = r1;
        this.$eventName = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricMemoryReportServiceImpl$reportAsync$1(this.$json, this.$eventName, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r7);
        JSONObject r3 = this.$json;     // Catch: Exception -> L14
        ObricMemoryReportServiceImpl r4 = this.this$0;     // Catch: Exception -> L14
        if (r3.has("scene") == true) goto L8;
        r3.put("scene", r4.d);     // Catch: Exception -> L14
    L8:
        int r5 = ObricMemoryReportServiceImpl.j;     // Catch: Exception -> L14
        r4.getClass();     // Catch: Exception -> L14
        AppHost.Companion r6 = AppHost.a;     // Catch: Exception -> L14
        r3.put("is_background", r6.a().isAppBackground());     // Catch: Exception -> L14
        Activity r8 = r6.a().getCurrentActivity();     // Catch: Exception -> L14
        if (r8 == null) goto L11;
        String r9 = r8.getClass().getName();     // Catch: Exception -> L14
    L12:
        r3.put("current_activity", r9);     // Catch: Exception -> L14
        IApplog.a.reportEvent(this.$eventName, this.$json);     // Catch: Exception -> L14
        FLogger.a.d("ObricMemoryReportService", "reportAsync " + this.$eventName + ' ' + this.$json);     // Catch: Exception -> L14
    L17:
        return Unit.INSTANCE;
    L11:
        r9 = null;
    L14:
        e = move-exception;
        FLogger.a.e("ObricMemoryReportService", "report async error, " + this.$eventName + ' ' + e);
        goto L17
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
