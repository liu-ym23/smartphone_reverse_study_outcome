package com.larus.ugc.perf.impl.genimg;

import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.perf.impl.genimg.UgcCreationMsgGenImgPerfMonitor$reportCreationTaskShow$1", f = "UgcCreationMsgGenImgPerfMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UgcCreationMsgGenImgPerfMonitor$reportCreationTaskShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationInfo $creationInfo;
    final /* synthetic */ com.larus.ugc.perf.impl.e $source;
    int label;

    public UgcCreationMsgGenImgPerfMonitor$reportCreationTaskShow$1(CreationInfo r1, com.larus.ugc.perf.impl.e r2, Continuation<? super UgcCreationMsgGenImgPerfMonitor$reportCreationTaskShow$1> r3) {
        this.$creationInfo = r1;
        this.$source = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UgcCreationMsgGenImgPerfMonitor$reportCreationTaskShow$1(this.$creationInfo, this.$source, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L60;
        ResultKt.throwOnFailure(r12);
        List r13 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(4), Boxing.boxInt(5)});
        Map r1 = this.$creationInfo.taskInfo;
        if (r1 == null) goto L58;
        com.larus.ugc.perf.impl.e r3 = this.$source;
        Iterator r2 = r1.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L58;
        Map.Entry r4 = (Map.Entry) r2.next();
        List r5 = r13;
        CreationTask r6 = (CreationTask) r4.getValue();
        Integer r7 = null;
        if (r6 == null) goto L12;
        Integer r8 = r6.status;
    L14:
        if (CollectionsKt.contains(r5, r8) == false) goto L8;
        if (CollectionsKt.contains(r5, r3.b.get("creation_task_show" + ((String) r4.getKey()))) == true) goto L8;
        HashMap<String, Object> r9 = r3.b;
        String r10 = "creation_task_show" + ((String) r4.getKey());
        CreationTask r11 = (CreationTask) r4.getValue();
        if (r11 == null) goto L22;
        Integer r14 = r11.status;
        if (r14 == null) goto L22;
        int r15 = r14.intValue();
    L23:
        r9.put(r10, Boxing.boxInt(r15));
        JSONObject r16 = new JSONObject();
        Message r17 = r3.a;
        if (r17 == null) goto L26;
        String r18 = r17.getMessageId();
    L27:
        r16.putOpt("message_id", r18);
        CreationTask r19 = (CreationTask) r4.getValue();
        if (r19 == null) goto L30;
        String r20 = r19.id;
    L31:
        r16.putOpt("id", r20);
        CreationTask r21 = (CreationTask) r4.getValue();
        if (r21 == null) goto L34;
        Integer r22 = r21.status;
    L35:
        r16.putOpt("status", r22);
        CreationTask r23 = (CreationTask) r4.getValue();
        if (r23 == null) goto L38;
        Integer r24 = r23.index;
    L39:
        r16.putOpt("index", r24);
        CreationTask r25 = (CreationTask) r4.getValue();
        if (r25 == null) goto L42;
        Integer r26 = r25.taskType;
    L43:
        r16.putOpt("task_type", r26);
        CreationTask r27 = (CreationTask) r4.getValue();
        if (r27 == null) goto L48;
        CreationAsset r28 = r27.asset;
        if (r28 == null) goto L48;
        Integer r29 = r28.assetType;
    L49:
        r16.putOpt("asset_type", r29);
        Message r30 = r3.a;
        if (r30 == null) goto L52;
        r7 = Boxing.boxInt(r30.getContentType());
    L52:
        r16.putOpt("content_type", r7);
        o.a.reportEvent("creation_task_show", r16);     // Catch: Exception -> L55
        FLogger.a.i("UgcCreationMsgGenImgPerfMonitor", "creation_task_show: " + r16);     // Catch: Exception -> L55
    L55:
        e = move-exception;
        FLogger.a.e("UgcCreationMsgGenImgPerfMonitor", "reportEvent error", e);
    L48:
        r29 = null;
        goto L49
    L42:
        r26 = null;
        goto L43
    L38:
        r24 = null;
        goto L39
    L34:
        r22 = null;
        goto L35
    L30:
        r20 = null;
        goto L31
    L26:
        r18 = null;
    L22:
        r15 = 4;
        goto L23
    L12:
        r8 = null;
    L58:
        return Unit.INSTANCE;
    L60:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
