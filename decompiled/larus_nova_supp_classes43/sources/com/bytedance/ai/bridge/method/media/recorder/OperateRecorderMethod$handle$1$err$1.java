package com.bytedance.ai.bridge.method.media.recorder;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Build;
import com.bytedance.ai.bridge.doubao.recorder.AbsOperateRecorderMethodIDL;
import com.bytedance.ai.utils.g;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.media.recorder.OperateRecorderMethod$handle$1$err$1", f = "OperateRecorderMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OperateRecorderMethod$handle$1$err$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f3.a>, Object> {
    final /* synthetic */ e3.d $bridgeContext;
    final /* synthetic */ AbsOperateRecorderMethodIDL.b $params;
    int label;

    public OperateRecorderMethod$handle$1$err$1(AbsOperateRecorderMethodIDL.b r1, e3.d r10, Continuation<? super OperateRecorderMethod$handle$1$err$1> r11) {
        this.$params = r1;
        this.$bridgeContext = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new OperateRecorderMethod$handle$1$err$1(this.$params, this.$bridgeContext, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super f3.a> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L60;
        ResultKt.throwOnFailure(r10);
        String r11 = this.$params.getOperationType();
        switch(r11.hashCode()) {
            case -934426579: goto L20;
            case 3540994: goto L16;
            case 106440182: goto L12;
            case 109757538: goto L8;
            default: goto L57;
        };
    L57:
        g r12 = g.a;
        StringBuilder r1 = new StringBuilder("unknown operationType=");
        r1.append(this.$params.getOperationType());
        r1.append(", errNo=");
        f3.a r13 = f3.a.h;
        r1.append(r13.a);
        r12.e("AISDK_JSB_OperateRecorderMethod", r1.toString());
        return r13;
    L8:
        if (r11.equals("start") == false) goto L57;
        return f.a(this.$bridgeContext).m(this.$params);
    L12:
        if (r11.equals("pause") == false) goto L57;
        return f.a(this.$bridgeContext).k();
    L16:
        if (r11.equals("stop") == false) goto L57;
        return f.a(this.$bridgeContext).p();
    L20:
        if (r11.equals("resume") == false) goto L57;
        RecorderManager r14 = f.a(this.$bridgeContext);
        g r15 = g.a;
        r15.i("AISDK_JSB_RecorderManager", "resume called");
        if (r14.k == 0) goto L25;
    L27:
        Object r16 = r14.b;
        monitor-enter(r16);
    L54:
        th = move-exception;
        throw th;
    L30:
        if (r14.c == RecorderManager.State.PAUSED) goto L62;
        StringBuilder r0 = new StringBuilder("resume failed, errNo=");     // Catch: Throwable -> L54
        f3.a.C0156a r17 = f3.a.c;     // Catch: Throwable -> L54
        f3.a r18 = f3.b.a;     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r17, "<this>");     // Catch: Throwable -> L54
        f3.a r19 = f3.b.p;     // Catch: Throwable -> L54
        r0.append(r19.a);     // Catch: Throwable -> L54
        r0.append(", msg=recorder not paused");     // Catch: Throwable -> L54
        r15.e("AISDK_JSB_RecorderManager", r0.toString());     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r17, "<this>");     // Catch: Throwable -> L54
        monitor-exit(r16);
        return r19;
    L62:
    L41:
        e = move-exception;
        g r20 = g.a;     // Catch: Throwable -> L54
        StringBuilder r21 = new StringBuilder("resume failed, errNo=");     // Catch: Throwable -> L54
        f3.a r22 = f3.a.f;     // Catch: Throwable -> L54
        r21.append(r22.a);     // Catch: Throwable -> L54
        r21.append(", msg=");     // Catch: Throwable -> L54
        r21.append(e.getMessage());     // Catch: Throwable -> L54
        r20.e("AISDK_JSB_RecorderManager", r21.toString());     // Catch: Throwable -> L54
        return r22;
    L35:
        if (r14.k <= 0) goto L44;
        AudioRecord r23 = r14.i;     // Catch: Exception -> L41 Throwable -> L54
        if (r23 != null) goto L39;
    L47:
        r14.c = RecorderManager.State.STARTED;     // Catch: Exception -> L41 Throwable -> L54
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L54
        monitor-exit(r16);
        r15.i("AISDK_JSB_RecorderManager", "recorder resumed successfully");
        JsonObject r25 = new JsonObject();
        r25.addProperty("state", "resume");
        r14.l(r25);
        return null;
    L39:
        if (fna.g.d() == true) goto L43;
        RecorderManager.d(r23);     // Catch: Exception -> L41 Throwable -> L54
        goto L47
    L43:
        RecorderManager.d(r23);     // Catch: Exception -> L41 Throwable -> L54
        hna.a.b(r23.hashCode());     // Catch: Exception -> L41 Throwable -> L54
        goto L47
    L44:
        MediaRecorder r26 = r14.f;     // Catch: Exception -> L41 Throwable -> L54
        if (r26 == null) goto L47;
        r26.resume();     // Catch: Exception -> L41 Throwable -> L54
        goto L47
    L25:
        if (Build.VERSION.SDK_INT >= 24) goto L27;
        StringBuilder r27 = new StringBuilder("resume failed, errNo=");
        f3.a r28 = f3.a.g;
        r27.append(r28.a);
        r27.append(", msg=resume not supported below Android N");
        r15.e("AISDK_JSB_RecorderManager", r27.toString());
        return r28;
    L60:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
