package com.larus.ugc.perf.impl.genimg;

import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
@DebugMetadata(c = "com.larus.ugc.perf.impl.genimg.UgcCreationBlockMsgPerfMonitor$reportCreationTaskShow$1", f = "UgcCreationBlockMsgPerfMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UgcCreationBlockMsgPerfMonitor$reportCreationTaskShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.ugc.perf.impl.e $source;
    int label;

    public UgcCreationBlockMsgPerfMonitor$reportCreationTaskShow$1(com.larus.ugc.perf.impl.e r1, Continuation<? super UgcCreationBlockMsgPerfMonitor$reportCreationTaskShow$1> r2) {
        this.$source = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcCreationBlockMsgPerfMonitor$reportCreationTaskShow$1(this.$source, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L92;
        ResultKt.throwOnFailure(r21);
        Message r0 = this.$source.a;
        if (r0 == null) goto L90;
        List r1 = com.larus.im.bean.message.a.l(r0);
        com.larus.ugc.perf.impl.e r2 = this.$source;
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L90;
        CreationItem r4 = (CreationItem) r3.next();
        Integer r5 = r4.type;
        Integer r18 = null;
        if (r5 != null) goto L13;
    L49:
        Iterator r19 = r3;
        if (r5 == null) goto L88;
        if (r5.intValue() != 2) goto L88;
        List r6 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(3), Boxing.boxInt(4)});
        VideoData r7 = r4.video;
        if (r7 == null) goto L57;
        Integer r8 = r7.status;
    L59:
        if (CollectionsKt.contains(r6, r8) == false) goto L88;
        if (CollectionsKt.contains(r6, r2.b.get("creation_task_show" + r4.id)) == true) goto L88;
        HashMap<String, Object> r9 = r2.b;
        String r10 = "creation_task_show" + r4.id;
        VideoData r11 = r4.video;
        if (r11 == null) goto L67;
        Integer r12 = r11.status;
        if (r12 == null) goto L67;
        int r13 = r12.intValue();
    L68:
        r9.put(r10, Boxing.boxInt(r13));
        JSONObject r14 = new JSONObject();
        Message r15 = r2.a;
        if (r15 == null) goto L71;
        String r16 = r15.getMessageId();
    L72:
        r14.putOpt("message_id", r16);
        r14.putOpt("id", r4.id);
        VideoData r17 = r4.video;
        if (r17 == null) goto L75;
        Integer r20 = r17.status;
    L76:
        r14.putOpt("status", r20);
        CreationGenDetail r22 = r4.genDetail;
        if (r22 == null) goto L79;
        Integer r23 = r22.taskType;
    L80:
        r14.putOpt("task_type", r23);
        Message r24 = r2.a;
        if (r24 == null) goto L83;
        r18 = Boxing.boxInt(r24.getContentType());
    L83:
        r14.putOpt("content_type", r18);
        r14.putOpt("asset_type", r4.type);
        o.a.reportEvent("creation_task_show", r14);     // Catch: Exception -> L86
        FLogger.a.i("UgcCreationBlockMsgPerfMonitor", "creation_task_show: " + r14);     // Catch: Exception -> L86
    L86:
        e = move-exception;
        FLogger.a.e("UgcCreationBlockMsgPerfMonitor", "reportEvent error", e);
        goto L88
    L79:
        r23 = null;
        goto L80
    L75:
        r20 = null;
        goto L76
    L71:
        r16 = null;
    L67:
        r13 = 3;
        goto L68
    L57:
        r8 = null;
    L88:
        r3 = r19;
        goto L8
    L13:
        if (r5.intValue() != 1) goto L49;
        List r25 = CollectionsKt.listOf(new Integer[]{Boxing.boxInt(2), Boxing.boxInt(4)});
        ImageData r26 = r4.image;
        if (r26 == null) goto L17;
        Integer r27 = r26.status;
    L19:
        if (CollectionsKt.contains(r25, r27) == false) goto L48;
        HashMap<String, Object> r28 = r2.b;
        StringBuilder r110 = new StringBuilder("creation_task_show");
        r19 = r3;
        r110.append(r4.id);
        if (CollectionsKt.contains(r25, r28.get(r110.toString())) == true) goto L88;
        HashMap<String, Object> r29 = r2.b;
        String r30 = "creation_task_show" + r4.id;
        ImageData r31 = r4.image;
        if (r31 == null) goto L27;
        Integer r32 = r31.status;
        if (r32 == null) goto L27;
        int r111 = r32.intValue();
    L28:
        r29.put(r30, Boxing.boxInt(r111));
        JSONObject r33 = new JSONObject();
        Message r34 = r2.a;
        if (r34 == null) goto L31;
        String r35 = r34.getMessageId();
    L32:
        r33.putOpt("message_id", r35);
        r33.putOpt("id", r4.id);
        ImageData r36 = r4.image;
        if (r36 == null) goto L35;
        Integer r37 = r36.status;
    L36:
        r33.putOpt("status", r37);
        CreationGenDetail r38 = r4.genDetail;
        if (r38 == null) goto L39;
        Integer r39 = r38.taskType;
    L40:
        r33.putOpt("task_type", r39);
        Message r40 = r2.a;
        if (r40 == null) goto L43;
        r18 = Boxing.boxInt(r40.getContentType());
    L43:
        r33.putOpt("content_type", r18);
        r33.putOpt("asset_type", r4.type);
        o.a.reportEvent("creation_task_show", r33);     // Catch: Exception -> L46
        FLogger.a.i("UgcCreationBlockMsgPerfMonitor", "creation_task_show: " + r33);     // Catch: Exception -> L46
    L46:
        e = move-exception;
        FLogger.a.e("UgcCreationBlockMsgPerfMonitor", "reportEvent error", e);
        goto L88
    L39:
        r39 = null;
        goto L40
    L35:
        r37 = null;
        goto L36
    L31:
        r35 = null;
    L27:
        r111 = 2;
        goto L28
    L48:
        r19 = r3;
        goto L88
    L17:
        r27 = null;
    L90:
        return Unit.INSTANCE;
    L92:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
