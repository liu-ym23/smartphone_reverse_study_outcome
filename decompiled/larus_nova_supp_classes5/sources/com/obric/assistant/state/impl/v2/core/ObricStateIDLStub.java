package com.obric.assistant.state.impl.v2.core;

import android.os.IBinder;
import android.os.RemoteCallbackList;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowAssistantActiveStateListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowAssistantStateIDLSPI;
import com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowBackgroundInterceptStateListenerIDL;
import com.obric.aiagent.assistant.idl.IFlowNightModeChangeListenerIDL;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.v2.core.bean.ObricTtsInfo;
import hm9.j;
import hm9.w;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0003¨\u0006%"}, d2 = {"Lcom/obric/assistant/state/impl/v2/core/ObricStateIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantStateIDLSPI;", "<init>", "()V", "stateCallbackList", "Landroid/os/RemoteCallbackList;", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantActiveStateListenerIDL;", "ttsStateCallbackList", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantTTSStateListenerIDL;", "interceptingStateCallbackList", "Lcom/obric/aiagent/assistant/idl/IFlowBackgroundInterceptStateListenerIDL;", "nightModeCallbackList", "Lcom/obric/aiagent/assistant/idl/IFlowNightModeChangeListenerIDL;", "obricAssistantDeactive", "", "getObricAssistantDeactive$annotations", "isActive", "registerActiveStateListener", "", "listener", "unregisterActiveStateListener", "registerTTSStateListener", "unregisterTTSStateListener", "isBackgroundIntercepting", "registerBackgroundInterceptingListener", "unregisterBackgroundInterceptingListener", "registerBackgroundInterceptingStateListener", "getCurrentNightMode", "", "registerNightModeListener", "unregisterNightModeListener", "registerNightModeStateListener", "registerAssistantStateListener", "updateAssistantState", "deactive", "registerObricTtsStateListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStateIDLStub implements IFlowAssistantStateIDLSPI {
    public static final b Companion = null;
    private static final String TAG = "ObricStateIDLStub";
    private final RemoteCallbackList<IFlowBackgroundInterceptStateListenerIDL> interceptingStateCallbackList;
    private final RemoteCallbackList<IFlowNightModeChangeListenerIDL> nightModeCallbackList;
    private boolean obricAssistantDeactive;
    private final RemoteCallbackList<IFlowAssistantActiveStateListenerIDL> stateCallbackList;
    private final RemoteCallbackList<IFlowAssistantTTSStateListenerIDL> ttsStateCallbackList;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            IAgentAppIntentIDL r3 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
            if (r3 == null) goto L6;
            r3.onLoginStateChange(true);
            return;
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            IAgentAppIntentIDL r3 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
            if (r3 == null) goto L6;
            r3.onLoginStateChange(false);
            return;
        }
    }

    public static final class c implements w {
        public final /* synthetic */ ObricStateIDLStub a;

        public c(ObricStateIDLStub r1) {
            this.a = r1;
        }

        public final void a(final boolean r3) {
            com.obric.aiagent.ipc.utils.d.a(ObricStateIDLStub.access$getInterceptingStateCallbackList$p(this.a), new e(r3));
        }
    }

    public static final class d implements cha.a {
        public final /* synthetic */ ObricStateIDLStub a;

        public d(ObricStateIDLStub r1) {
            this.a = r1;
        }

        public final void b(ObricTtsInfo r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "ttsInfo");
            com.obric.aiagent.ipc.utils.d.a(ObricStateIDLStub.access$getTtsStateCallbackList$p(this.a), new f(r3, r4));
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ void a(ObricStateIDLStub r0, zga.b r1) {
        registerAssistantStateListener$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit b(ObricStateIDLStub r0, IFlowAssistantActiveStateListenerIDL r1) {
        return updateAssistantState$lambda$3(r0, r1);
    }

    public static /* synthetic */ void c(ObricStateIDLStub r0, int r1) {
        registerNightModeStateListener$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit d(int r0, IFlowNightModeChangeListenerIDL r1) {
        return registerNightModeStateListener$lambda$1$lambda$0(r0, r1);
    }

    @Deprecated(message = "use new state api")
    private static /* synthetic */ void getObricAssistantDeactive$annotations() {
    }

    public IBinder asBinder() {
        return null;
    }

    private final void registerAssistantStateListener() {
        ObricInteractionProjectionDelegate.b.b(null, new b(this));
    }

    private final void registerBackgroundInterceptingStateListener() {
        j r0 = j.a;
        c r1 = new c(this);
        Intrinsics.checkNotNullParameter(r1, "callback");
        j.g.addIfAbsent(r1);
        r1.a(j.h.B);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private final void registerNightModeStateListener() {
        Lazy r0 = we8.j.a;
        we8.j.a r1 = new com.obric.assistant.state.impl.v2.core.d(this);
        Intrinsics.checkNotNullParameter(r1, "observer");
        we8.j.b.addIfAbsent(r1);
    }

    private final void registerObricTtsStateListener() {
        ObricStateDispatcher r0 = ObricStateDispatcher.a;
        d r1 = new d(this);
        Intrinsics.checkNotNullParameter(r1, "observer");
        ObricStateDispatcher.e.add(r1);
    }

    public int getCurrentNightMode() {
        Lazy r0 = we8.j.a;
        return we8.j.c;
    }

    public boolean isActive() {
        return !this.obricAssistantDeactive;
    }

    public boolean isBackgroundIntercepting() {
        j r0 = j.a;
        return j.h.B;
    }

    public ObricStateIDLStub() {
        this.stateCallbackList = new RemoteCallbackList();
        this.ttsStateCallbackList = new RemoteCallbackList();
        this.interceptingStateCallbackList = new RemoteCallbackList();
        this.nightModeCallbackList = new RemoteCallbackList();
        this.obricAssistantDeactive = true;
        registerAssistantStateListener();
        registerObricTtsStateListener();
        registerBackgroundInterceptingStateListener();
        registerNightModeStateListener();
        AccountService.a.E(new a());
    }

    public static final /* synthetic */ RemoteCallbackList access$getInterceptingStateCallbackList$p(ObricStateIDLStub r0) {
        return r0.interceptingStateCallbackList;
    }

    public static final /* synthetic */ RemoteCallbackList access$getTtsStateCallbackList$p(ObricStateIDLStub r0) {
        return r0.ttsStateCallbackList;
    }

    private final void updateAssistantState(boolean r2) {
        if (this.obricAssistantDeactive != r2) goto L5;
        return;
    L5:
        this.obricAssistantDeactive = r2;
        com.obric.aiagent.ipc.utils.d.a(this.stateCallbackList, new com.obric.assistant.state.impl.v2.core.c(this));
    }

    public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.stateCallbackList.register(r2);
    }

    public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.interceptingStateCallbackList.register(r4);
        j r0 = j.a;     // Catch: Exception -> L7
        r4.onChanged(j.h.B);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.a.e(TAG, "registerBackgroundInterceptingListener initial callback failed", e);
    }

    public void registerNightModeListener(IFlowNightModeChangeListenerIDL r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.nightModeCallbackList.register(r4);
        Lazy r0 = we8.j.a;     // Catch: Exception -> L7
        r4.onChanged(we8.j.c);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.a.e(TAG, "registerNightModeListener initial callback failed", e);
    }

    public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r2) {
        this.ttsStateCallbackList.register(r2);
    }

    public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.stateCallbackList.unregister(r2);
    }

    public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.interceptingStateCallbackList.unregister(r2);
    }

    public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.nightModeCallbackList.unregister(r2);
    }

    public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r2) {
        this.ttsStateCallbackList.unregister(r2);
    }

    private static final void registerAssistantStateListener$lambda$2(ObricStateIDLStub r1, zga.b r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        ForegroundInteractionPhase r3 = r2.e;
        if (r3 != ForegroundInteractionPhase.Idle) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r1.updateAssistantState(r4);
        return;
    L5:
        if (r3 == ForegroundInteractionPhase.Generated) goto L8;
        r4 = false;
        goto L9
    }

    private static final void registerNightModeStateListener$lambda$1(ObricStateIDLStub r1, int r2) {
        com.obric.aiagent.ipc.utils.d.a(r1.nightModeCallbackList, new com.obric.assistant.state.impl.v2.core.a(r2));
    }

    private static final Unit registerNightModeStateListener$lambda$1$lambda$0(int r1, IFlowNightModeChangeListenerIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.onChanged(r1);
        return Unit.INSTANCE;
    }

    private static final Unit updateAssistantState$lambda$3(ObricStateIDLStub r1, IFlowAssistantActiveStateListenerIDL r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.onChanged(!r1.obricAssistantDeactive);
        return Unit.INSTANCE;
    }
}
