package com.larus.audio.audiov3.task.sami.v2.flow;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.audio.audiov3.config.NetworkStatus;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.SAMICoreHostCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import m58.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class FlowMockSamiCore extends com.larus.audio.audiov3.task.sami.v2.flow.a {
    public volatile MockEventType c;
    public volatile long d;
    public final int e;
    public final String f;
    public final String g;
    public volatile long h;
    public final CoroutineScope i;
    public Job j;

    /* JADX INFO: renamed from: com.larus.audio.audiov3.task.sami.v2.flow.FlowMockSamiCore$SAMICoreSetProperty$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.audio.audiov3.task.sami.v2.flow.FlowMockSamiCore$SAMICoreSetProperty$2", f = "FlowMockSamiCore.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowMockSamiCore this$0;

        public AnonymousClass2(FlowMockSamiCore r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            FlowMockSamiCore r5 = this.this$0;
            this.label = 1;
            if (FlowMockSamiCore.j(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MockEventType.values().length];
            r0[MockEventType.TASK_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[MockEventType.SESSION_CANCELED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[MockEventType.SESSION_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[MockEventType.WEB_SOCKET_CHANGE_FAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MockEventType.WEB_SOCKET_CONNECTION_FAIL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[MockEventType.NONE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    public final int SAMICoreCreateHandleByIdentify(SAMICoreIdentify r1, Object r2) {
        return 0;
    }

    public final int SAMICoreGetPropertyById(SAMICorePropertyId r1, SAMICoreProperty r2) {
        return 0;
    }

    public final int SAMICoreProcess(SAMICoreBlock r1, SAMICoreBlock r2) {
        return 0;
    }

    public final int SAMICoreProcessAsync(SAMICoreBlock r1) {
        return 0;
    }

    public final void setEnableSyncInterface(boolean r1) {
    }

    public final void setHostCallBackListener(SAMICoreHostCallBackListener r1) {
    }

    public final int SAMICoreDestroyHandle() {
        this.h = 0;
        Job r0 = this.j;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.j = null;
        return 0;
    }

    public FlowMockSamiCore() {
        this.c = MockEventType.NONE;
        this.d = 1000;
        this.e = -1;
        this.f = "mock error";
        this.g = "mock error message";
        this.h = 1;
        this.i = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public final long getHandle() {
        return this.h;
    }

    public final void k(SAMICoreCallBackEventType r5) {
        SAMICoreServerEvent r0 = new SAMICoreServerEvent();
        r0.statusCode = this.e;
        r0.statusText = this.f;
        r0.textMsg = this.g;
        SAMICoreBlock r1 = new SAMICoreBlock();
        r1.dataType = SAMICoreDataType.SAMICoreDataType_WebSocket_Server_Event;
        r1.numberAudioData = 1;
        r1.audioData = new SAMICoreServerEvent[]{r0};
        Iterator r2 = ((com.larus.audio.audiov3.task.sami.v2.flow.a) this).b.a.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((SAMICoreCallBackListener) r2.next()).onMessageReceived(r5, r1);
        goto L4
    }

    public final void l(int r4) {
        SAMICoreWebSocketConnectionEvent r0 = new SAMICoreWebSocketConnectionEvent();
        r0.state = r4;
        r0.textMsg = this.g;
        SAMICoreBlock r5 = new SAMICoreBlock();
        r5.dataType = SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event;
        r5.numberAudioData = 1;
        r5.audioData = new SAMICoreWebSocketConnectionEvent[]{r0};
        Iterator r1 = ((com.larus.audio.audiov3.task.sami.v2.flow.a) this).b.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((SAMICoreCallBackListener) r1.next()).onMessageReceived(SAMICoreCallBackEventType.WebSocketStateChanged, r5);
        goto L4
    }

    public static final Object j(FlowMockSamiCore r8, Continuation r9) {
        r8.getClass();
        if ((r9 instanceof FlowMockSamiCore$scheduleMockEvent$1) == false) goto L7;
        FlowMockSamiCore$scheduleMockEvent$1 r0 = (FlowMockSamiCore$scheduleMockEvent$1) r9;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L24:
        if (r8.h == 0) goto L38;
        MockEventType r11 = r8.c;
        k r4 = c68.a.a("[fireMockEvent]");
        if (r4 == null) goto L29;
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("mock_event_type", String.valueOf(r8.c.getType()));
        r5.put("mock_delay_ms", String.valueOf(r8.d));
        com.larus.audio.utils.b r6 = (com.larus.audio.utils.b) r4;
        r6.c(r5);
        r6.d("FlowMockSamiCore.fireMockEvent");
        k.a.a(r6);
    L29:
        switch(b.a[r11.ordinal()]) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L38;
            default: goto L31;
        };
    L32:
        r8.l(NetworkStatus.WEB_SOCKET_CONNECTION_FAIL.getCode());
        goto L38
    L33:
        r8.l(NetworkStatus.WEB_SOCKET_CHANGE_FAIL.getCode());
        goto L38
    L34:
        r8.k(SAMICoreCallBackEventType.SessionFailed);
        goto L38
    L35:
        r8.k(SAMICoreCallBackEventType.SessionCanceled);
        goto L38
    L36:
        r8.k(SAMICoreCallBackEventType.TaskFailed);
        goto L38
    L31:
        throw new NoWhenBranchMatchedException();
    L38:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r8.c == MockEventType.NONE) goto L39;
        k r12 = c68.a.a("scheduleMockEvent");
        if (r12 == null) goto L20;
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("mock_event_type", String.valueOf(r8.c.getType()));
        r7.put("mock_delay_ms", String.valueOf(r8.d));
        com.larus.audio.utils.b r13 = (com.larus.audio.utils.b) r12;
        r13.c(r7);
        r13.d("FlowMockSamiCore.scheduleMockEvent");
        k.a.a(r13);
    L20:
        long r14 = r8.d;
        r0.label = 1;
        if (DelayKt.delay(r14, r0) != r2) goto L24;
        return r2;
    L39:
        return Unit.INSTANCE;
    L7:
        r0 = new FlowMockSamiCore$scheduleMockEvent$1(r8, r9);
        goto L8
    }

    public final int SAMICoreSetProperty(SAMICorePropertyId r8, SAMICoreProperty r9) {
        if (r8 == SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant) goto L5;
        return 0;
    L5:
        if (r9 == null) goto L7;
        SAMICorePropertyId r10 = r9.id;
    L9:
        if (r10 != SAMICorePropertyId.SAMICorePropertyId_Voice_Assistant_Start_Session) goto L20;
        Job r11 = this.j;
        if (r11 == null) goto L13;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L13:
        this.j = null;
        k r12 = c68.a.a("on startSession event");
        if (r12 == null) goto L16;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("mock_event_type", String.valueOf(this.c.getType()));
        r0.put("mock_delay_ms", String.valueOf(this.d));
        com.larus.audio.utils.b r13 = (com.larus.audio.utils.b) r12;
        r13.c(r0);
        r13.d("FlowMockSamiCore.MockSAMICoreSetProperty");
        k.a.a(r13);
    L16:
        this.j = BuildersKt.launch$default(this.i, null, null, new AnonymousClass2(this, null), 3, null);
        return 0;
    L20:
        return 0;
    L7:
        r10 = null;
        goto L9
    }
}
