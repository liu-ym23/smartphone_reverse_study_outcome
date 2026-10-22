package com.larus.uaigc.chat.loading;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.creative.messagecard.bean.LoadingInfo;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.uaigc.api.x;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationQueuingTaskViewModel implements zd8.a {
    public static final /* synthetic */ int g = 0;
    public final CoroutineScope a;
    public final ConcurrentHashMap<String, Job> b;
    public final StateFlowImpl c;
    public final b1 d;
    public final MutableSharedFlow<Message> e;
    public final a1 f;

    public static final class a {
    }

    static {
    }

    public final void onClear() {
        Iterator<T> r0 = this.b.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Job) r0.next(), null, 1, null);
        goto L4
    L6:
        this.b.clear();
    }

    public final i1<CreationQueuingTaskUIState> D8() {
        return this.d;
    }

    public final d1<Message> R2() {
        return this.f;
    }

    public CreationQueuingTaskViewModel(CoroutineScope r3) {
        Intrinsics.checkNotNullParameter(r3, "viewModelScope");
        this.a = r3;
        this.b = new ConcurrentHashMap();
        StateFlowImpl r4 = j1.a(new CreationQueuingTaskUIState(null, 1, null));
        this.c = r4;
        this.d = e.b(r4);
        MutableSharedFlow<Message> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.e = r5;
        this.f = e.a(r5);
    }

    public final void C8(List<Message> r9) {
        Intrinsics.checkNotNullParameter(r9, "lastMsgList");
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Message r0 = (Message) r10.next();
        if (d.a0(r0) == false) goto L4;
        BuildersKt.launch$default(this.a, null, null, new CreationQueuingTaskViewModel$onMessageListChanged$1$1(this, r0, null), 3, null);
        goto L4
    }

    public final void B8(boolean r11, Message r12, String r13) {
        BuildersKt.launch$default(this.a, Dispatchers.getIO(), null, new CreationQueuingTaskViewModel$onVideoQueuingViewVisibilityChanged$1(r12, r13, r11, this, null), 2, null);
    }

    public final Object a(Message r29, CreationTask r30, String r31, boolean r32, int r33, Continuation<? super Unit> r34) {
        CreationTask r0 = r30;
        final String r1 = r31;
        if ((r34 instanceof CreationQueuingTaskViewModel$refreshQueuingStatusRegularly$1) == false) goto L7;
        CreationQueuingTaskViewModel$refreshQueuingStatusRegularly$1 r3 = (CreationQueuingTaskViewModel$refreshQueuingStatusRegularly$1) r34;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        CreationQueuingTaskViewModel$refreshQueuingStatusRegularly$1 r6 = r3;
        Object r2 = r6.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r6.label;
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L21;
        if (r7 == 2) goto L20;
        if (r7 == 3) goto L19;
        if (r7 == 4) goto L18;
        if (r7 != 5) goto L17;
        ResultKt.throwOnFailure(r2);
    L164:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r8 = r6.I$0;
        x r9 = (x) r6.L$3;
        String r10 = (String) r6.L$2;
        CreationTask r11 = (CreationTask) r6.L$1;
        Message r12 = (Message) r6.L$0;
        ResultKt.throwOnFailure(r2);
        CreationTask r13 = r11;
        Message r14 = r12;
        String r15 = r10;
        Object r16 = r5;
    L157:
        if (r9 != null) goto L159;
        int r17 = 5;
        int r18 = r8 - 5;
    L160:
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.label = r17;
        Message r19 = r14;
        Object r20 = r16;
        if (a(r19, r13, r15, false, r18, r6) != r20) goto L164;
        return r20;
    L159:
        r17 = 5;
        r18 = r8 - 1;
        goto L160
    L19:
        r8 = r6.I$0;
        r1 = (String) r6.L$2;
        CreationTask r21 = (CreationTask) r6.L$1;
        Message r22 = (Message) r6.L$0;
        ResultKt.throwOnFailure(r2);
        Object r23 = r2;
        r14 = r22;
        int r24 = 1000;
        int r25 = 4;
        CreationTask r26 = r21;
        r16 = r5;
    L118:
        final x r27 = (x) ((com.larus.network.http.a) r23).b;
        FLogger r110 = FLogger.a;
        StringBuilder r111 = new StringBuilder("[getVideoLoadingInfo], loadingText: ");
        if (r27 == null) goto L121;
        String r112 = r27.loadingText;
    L122:
        r111.append(r112);
        r111.append(", refreshTimeSec: ");
        if (r27 == null) goto L125;
        Long r113 = r27.refreshTimeSec;
    L126:
        r111.append(r113);
        r111.append(", waitTimeSec: ");
        if (r27 == null) goto L129;
        Long r114 = r27.waitTimeSec;
    L130:
        r111.append(r114);
        r110.i("CreationQueueHandleViewModel", r111.toString());
        if (r27 == null) goto L133;
        String r115 = r27.loadingText;
    L135:
        if (o0.d(r115) == false) goto L144;
        StateFlowImpl r116 = this.c;
        Map r117 = MapsKt.toMutableMap(((CreationQueuingTaskUIState) r116.getValue()).taskQueuingUIStateMap);
        if (r27 == null) goto L139;
        String r118 = r27.loadingText;
    L140:
        r117.put(r1, new cp8.a(r118));
        r116.setValue(new CreationQueuingTaskUIState(r117));
        IChatRepoService r119 = RepoDispatcherDelegate.b.e();
        String r120 = r14.getMessageId();
        if (r120 != null) goto L143;
        r120 = "";
    L143:
        r119.r1(r120, new com.larus.uaigc.chat.loading.a(r1, r27));
        goto L144
    L139:
        r118 = null;
    L144:
        if (r27 == null) goto L148;
        Long r121 = r27.refreshTimeSec;
        if (r121 == null) goto L148;
        long r122 = r121.longValue();
    L149:
        long r123 = r122 * ((long) r24);
        if (r123 >= 5000) goto L152;
        r123 = 5000;
    L152:
        r6.L$0 = r14;
        r6.L$1 = r26;
        r6.L$2 = r1;
        r6.L$3 = r27;
        r6.I$0 = r8;
        r6.label = r25;
        if (DelayKt.delay(r123, r6) != r16) goto L155;
        return r16;
    L155:
        r15 = r1;
        r13 = r26;
        r9 = r27;
    L148:
        r122 = 300;
        goto L149
    L133:
        r115 = null;
        goto L135
    L129:
        r114 = null;
        goto L130
    L125:
        r113 = null;
        goto L126
    L121:
        r112 = null;
        goto L122
    L20:
        r8 = r6.I$0;
        String r28 = (String) r6.L$3;
        String r35 = (String) r6.L$2;
        CreationTask r124 = (CreationTask) r6.L$1;
        Message r125 = (Message) r6.L$0;
        ResultKt.throwOnFailure(r2);
        Object r36 = r2;
        Message r126 = r125;
        String r37 = r28;
        r1 = r35;
        r16 = r5;
        r26 = r124;
    L80:
        Message r38 = (Message) r36;
        if (r38 == null) goto L92;
        CreationMsgContentData r39 = dp8.e.c(r38);
        if (r39 == null) goto L92;
        CreationInfo r40 = r39.creationInfo;
        if (r40 == null) goto L92;
        Map r41 = r40.taskInfo;
        if (r41 == null) goto L92;
        String r127 = r26.id;
        if (r127 != null) goto L91;
        r127 = "";
    L91:
        CreationTask r42 = (CreationTask) r41.get(r127);
    L93:
        if (r42 == null) goto L100;
        Integer r128 = r42.status;
        if (r128 == null) goto L100;
        if (r128.intValue() != 3) goto L100;
        boolean r129 = true;
    L101:
        if (r129 == true) goto L114;
        long r130 = System.currentTimeMillis() / ((long) 1000);
        if (r42 == null) goto L109;
        LoadingInfo r43 = r42.loadingInfo;
        if (r43 == null) goto L109;
        Long r44 = r43.loadingBeginTimeSec;
        if (r44 == null) goto L109;
        long r45 = r44.longValue();
    L111:
        if ((r130 - r45) <= 21600) goto L114;
        return Unit.INSTANCE;
    L109:
        r45 = 0;
    L114:
        r6.L$0 = r126;
        r6.L$1 = r26;
        r6.L$2 = r1;
        r6.L$3 = null;
        r6.I$0 = r8;
        r6.label = 3;
        JSONObject r131 = new JSONObject();
        r131.put("task_id", r37);
        Unit r46 = Unit.INSTANCE;
        r25 = 4;
        Message r210 = r126;
        r24 = 1000;
        r23 = HttpExtKt.k("Social", x.class, "/creativity/video/get_video_loading", r131, null, null, true, null, null, null, r6, 944);
        if (r23 != r16) goto L117;
        return r16;
    L117:
        r14 = r210;
    L100:
        r129 = false;
    L92:
        r42 = null;
        goto L93
    L21:
        int r47 = r6.I$0;
        r1 = (String) r6.L$2;
        CreationTask r48 = (CreationTask) r6.L$1;
        Message r132 = (Message) r6.L$0;
        ResultKt.throwOnFailure(r2);
        int r49 = r47;
        r0 = r48;
        r16 = r5;
    L61:
        if (r0 == null) goto L63;
        r37 = r0.id;
    L64:
        if (r49 < 0) goto L166;
        if (r37 != null) goto L67;
    L70:
        boolean r50 = true;
    L71:
        if (r50 == true) goto L166;
        IChatRepoService r51 = RepoDispatcherDelegate.b.e();
        String r133 = r132.getMessageId();
        if (r133 != null) goto L76;
        r133 = "";
    L76:
        r6.L$0 = r132;
        r6.L$1 = r0;
        r6.L$2 = r1;
        r6.L$3 = r37;
        r6.I$0 = r49;
        r6.label = 2;
        r36 = r51.E1(r133, r6);
        if (r36 != r16) goto L79;
        return r16;
    L79:
        r126 = r132;
        int r211 = r49;
        r26 = r0;
        r8 = r211;
        goto L80
    L67:
        if (r37.length() == 0) goto L70;
        r50 = false;
    L166:
        return Unit.INSTANCE;
    L63:
        r37 = null;
        goto L64
    L22:
        ResultKt.throwOnFailure(r2);
        if (r32 == false) goto L59;
        Map r52 = r29.getBusinessExt();
        if (r52 == null) goto L27;
        String r53 = (String) r52.get("creation_msg_queuing_status");
    L28:
        x r54 = DataConverterKt.f(r53).get(r1);
        if (r54 != null) goto L48;
        if (r0 == null) goto L32;
        LoadingInfo r55 = r0.loadingInfo;
    L33:
        if (r55 == null) goto L47;
        String r134 = r55.loadingText;
        Long r135 = r55.waitTimeSec;
        if (r135 == null) goto L37;
        long r136 = r135.longValue();
    L38:
        Long r212 = Long.valueOf(r136);
        Long r137 = r55.refreshTimeSec;
        if (r137 == null) goto L41;
        long r138 = r137.longValue();
    L42:
        Long r213 = Long.valueOf(r138);
        Long r56 = r55.loadingBeginTimeSec;
        if (r56 == null) goto L45;
        long r139 = r56.longValue();
    L46:
        r54 = new x(r134, r212, r213, r139 * 1000);
        goto L48
    L45:
        r139 = 0;
        goto L46
    L41:
        r138 = 0;
        goto L42
    L37:
        r136 = 0;
        goto L38
    L47:
        r54 = null;
        goto L48
    L32:
        r55 = null;
    L48:
        if (r54 == null) goto L59;
        StateFlowImpl r57 = this.c;
        Map r140 = MapsKt.toMutableMap(((CreationQueuingTaskUIState) r57.getValue()).taskQueuingUIStateMap);
        r140.put(r1, new cp8.a(r54.loadingText));
        r57.setValue(new CreationQueuingTaskUIState(r140));
        Long r58 = r54.refreshTimeSec;
        if (r58 == null) goto L52;
        long r141 = r58.longValue();
    L53:
        long r59 = (r54.a + (r141 * ((long) 1000))) - System.currentTimeMillis();
        if (r59 <= 0) goto L58;
        Message r60 = r29;
        r6.L$0 = r60;
        r6.L$1 = r0;
        r6.L$2 = r1;
        r49 = r33;
        r6.I$0 = r49;
        r6.label = 1;
        r16 = r5;
        if (DelayKt.delay(r59, r6) != r16) goto L60;
        return r16;
    L60:
        r132 = r60;
        goto L61
    L58:
        r60 = r29;
        r49 = r33;
        r16 = r5;
        goto L60
    L52:
        r141 = 0;
        goto L53
    L27:
        r53 = null;
    L59:
        r60 = r29;
        r16 = r5;
        r49 = r33;
    L7:
        r3 = new CreationQueuingTaskViewModel$refreshQueuingStatusRegularly$1(this, r34);
        goto L8
    }
}
