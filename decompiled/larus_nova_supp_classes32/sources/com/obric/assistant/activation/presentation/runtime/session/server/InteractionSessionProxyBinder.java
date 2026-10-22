package com.obric.assistant.activation.presentation.runtime.session.server;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy;
import com.obric.assistant.activation.presentation.contract.ipc.VoiceInteractionSessionController;
import com.obric.assistant.activation.presentation.contract.session.VoiceInteractionProxySessionFactory;
import com.obric.assistant.session.AiIslandVoiceInteractionSession;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gba.b;
import gba.c;
import gba.d;
import gba.e;
import gba.f;
import gba.g;
import gba.h;
import gba.i;
import gba.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016JF\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\"\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u001c2\u0006\u0010&\u001a\u00020\u0017H\u0016J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0006\u0010(\u001a\u00020\u0012J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020\nH\u0002J\u0016\u00101\u001a\u00020\u00122\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001203H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/session/server/InteractionSessionProxyBinder;", "Lcom/obric/assistant/activation/presentation/contract/ipc/IInteractionSessionProxy$Stub;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mainHandler", "Landroid/os/Handler;", "sessionOwner", "Lcom/obric/assistant/activation/presentation/runtime/session/server/InteractionSessionOwner;", "Lcom/obric/assistant/activation/presentation/contract/session/VoiceInteractionProxySession;", "sessionController", "Lcom/obric/assistant/activation/presentation/contract/ipc/VoiceInteractionSessionController;", "sessionId", NameKeys.UnloadStrategy_No_Strategy, "sessionControllerDeathRecipient", "Landroid/os/IBinder$DeathRecipient;", "onSessionCreated", NameKeys.UnloadStrategy_No_Strategy, "incomingSessionId", "controller", "onHandleAssist", "assistStateIndex", NameKeys.UnloadStrategy_No_Strategy, "assistStateCount", "assistStateIsFocused", NameKeys.UnloadStrategy_No_Strategy, "assistStateData", "Landroid/os/Bundle;", "assistStateStructure", "Landroid/app/assist/AssistStructure;", "assistStateContent", "Landroid/app/assist/AssistContent;", "onHandleScreenshot", "screenshot", "Landroid/graphics/Bitmap;", "onShow", "args", "showFlags", "onSessionDestroyed", "release", "activateSession", "clearSession", "expectedSessionId", "reason", NameKeys.UnloadStrategy_No_Strategy, "currentSession", "eventName", "createProxySession", "onMain", "block", "Lkotlin/Function0;", "Companion", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionSessionProxyBinder extends IInteractionSessionProxy.Stub {
    private static final a Companion = null;
    private static final long NO_SESSION = -1;
    private static final String TAG = "InteractionSessionPB";
    private final Context context;
    private final Handler mainHandler;
    private VoiceInteractionSessionController sessionController;
    private IBinder.DeathRecipient sessionControllerDeathRecipient;
    private long sessionId;
    private final gba.a<zaa.a> sessionOwner;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit a(long r0, int r2, int r3, boolean r4, Bundle r5, AssistStructure r6, AssistContent r7, InteractionSessionProxyBinder r8) {
        return onHandleAssist$lambda$1(r0, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void b(Function0 r0) {
        onMain$lambda$10(r0);
    }

    public static /* synthetic */ Unit c(InteractionSessionProxyBinder r0, long r1) {
        return activateSession$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit d(long r0, InteractionSessionProxyBinder r2) {
        return onSessionDestroyed$lambda$4(r0, r2);
    }

    public static /* synthetic */ Unit e(InteractionSessionProxyBinder r0, long r1, VoiceInteractionSessionController r3) {
        return onSessionCreated$lambda$0(r0, r1, r3);
    }

    public static /* synthetic */ Unit f(InteractionSessionProxyBinder r0) {
        return release$lambda$5(r0);
    }

    public static /* synthetic */ Unit g(long r0, int r2, Bundle r3, InteractionSessionProxyBinder r4) {
        return onShow$lambda$3(r0, r2, r3, r4);
    }

    public static /* synthetic */ void h(long r0, InteractionSessionProxyBinder r2) {
        activateSession$lambda$7(r0, r2);
    }

    public static /* synthetic */ Unit i(long r0, Bitmap r2, InteractionSessionProxyBinder r3) {
        return onHandleScreenshot$lambda$2(r0, r2, r3);
    }

    public final void release() {
        onMain(new d(this));
    }

    private final zaa.a createProxySession() {
        VoiceInteractionProxySessionFactory r0 = (VoiceInteractionProxySessionFactory) ServiceManager.get().getServiceForReal(VoiceInteractionProxySessionFactory.class);
        if (r0 == null) goto L6;
        AiIslandVoiceInteractionSession r1 = r0.create(this.context);
        FLogger.a.i(TAG, "business proxy session created, type=".concat(r1.getClass().getSimpleName()));
        return r1;
    L6:
        FLogger.a.e(TAG, "cannot create proxy session: factory is unavailable");
        throw new IllegalStateException("VoiceInteractionProxySessionFactory is unavailable".toString());
    }

    public InteractionSessionProxyBinder(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.context = r3;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.sessionOwner = new gba.a();
        this.sessionId = -1;
        FLogger.a.i(TAG, "created, context=".concat(r3.getClass().getSimpleName()));
    }

    private final void onMain(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.mainHandler.post(new j(r3));
    }

    private static final void onMain$lambda$10(Function0 r0) {
        r0.invoke();
    }

    private static final Unit release$lambda$5(InteractionSessionProxyBinder r4) {
        FLogger.a.i(TAG, "release, currentSessionId=" + r4.sessionId);
        r4.clearSession(r4.sessionId, "service destroyed");
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
    public void onSessionDestroyed(final long r2) {
        onMain(new g(r2, this));
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, zaa.a] */
    private final void activateSession(final long r8, VoiceInteractionSessionController r10) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "activateSession start, incoming=" + r8 + ", current=" + this.sessionId + ", controllerAlive=" + r10.asBinder().isBinderAlive());
        if (this.sessionId != r8) goto L17;
        gba.a<zaa.a> r3 = this.sessionOwner;
        zaa.a r4 = r3.b;
        Long r5 = r3.a;
        if (r5 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == true) goto L14;
        r4 = null;
    L14:
        if (r4 == null) goto L17;
        r0.i(TAG, "ignore duplicate session handshake, id=" + r8);
        return;
    L8:
        if (r5.longValue() != r8) goto L10;
        r6 = true;
    L17:
        clearSession(this.sessionId, "session replaced by " + r8);
        ?? r7 = createProxySession();
        this.sessionId = r8;
        gba.a<zaa.a> r9 = this.sessionOwner;
        zaa.a r11 = r9.b;
        r9.a = Long.valueOf(r8);
        r9.b = r7;
        this.sessionController = r10;
        IBinder r12 = r10.asBinder();
        IBinder.DeathRecipient r13 = new b(r8, this);
        this.sessionControllerDeathRecipient = r13;
        r12.linkToDeath(r13, 0);     // Catch: RemoteException -> L21
        r7.b(r8, r10);
        r0.i(TAG, "proxy session activated, id=" + r8);
        return;
    L21:
        e = move-exception;
        FLogger.a.w(TAG, "controller already dead, id=" + r8, e);
        clearSession(r8, "controller already dead");
    }

    private static final void activateSession$lambda$7(final long r3, final InteractionSessionProxyBinder r5) {
        FLogger.a.w(TAG, "session controller died, id=" + r3);
        r5.onMain(new i(r5, r3));
    }

    private static final Unit activateSession$lambda$7$lambda$6(InteractionSessionProxyBinder r1, long r2) {
        r1.clearSession(r2, "controller died");
        return Unit.INSTANCE;
    }

    private final void clearSession(long r9, String r11) {
        gba.a<zaa.a> r0 = this.sessionOwner;
        Long r1 = r0.a;
        if (r1 != null) goto L6;
    L7:
        zaa.a r2 = null;
    L9:
        zaa.a r3 = r2;
        if (r3 == null) goto L12;
        VoiceInteractionSessionController r6 = this.sessionController;
        IBinder.DeathRecipient r7 = this.sessionControllerDeathRecipient;
        this.sessionController = null;
        this.sessionControllerDeathRecipient = null;
        this.sessionId = -1;
        if (r6 == null) goto L19;
        if (r7 == null) goto L19;
        boolean r4 = r6.asBinder().unlinkToDeath(r7, 0);
        FLogger.a.i(TAG, "controller death recipient removed, id=" + r9 + ", unlinked=" + r4);
    L19:
        r3.e(r9);
        FLogger.a.i(TAG, "proxy session cleared, id=" + r9 + ", reason=" + r11);
        return;
    L12:
        if (r9 == (-1)) goto L21;
        FLogger.a.i(TAG, "ignore stale session clear, expected=" + r9 + ", current=" + this.sessionId + ", reason=" + r11);
        return;
    L21:
        return;
    L6:
        if (r1.longValue() != r9) goto L7;
        r2 = r0.b;
        r0.a = null;
        r0.b = null;
        goto L9
    }

    private final zaa.a currentSession(long r5, String r7) {
        gba.a<zaa.a> r0 = this.sessionOwner;
        zaa.a r1 = r0.b;
        Long r2 = r0.a;
        if (r2 != null) goto L6;
    L8:
        boolean r3 = false;
    L9:
        if (r3 == true) goto L12;
        r1 = null;
    L12:
        zaa.a r4 = r1;
        if (r4 != null) goto L15;
        FLogger.a.w(TAG, "drop stale " + r7 + ", incoming=" + r5 + ", current=" + this.sessionId);
    L15:
        return r4;
    L6:
        if (r2.longValue() != r5) goto L8;
        r3 = true;
        goto L9
    }

    private static final Unit onSessionDestroyed$lambda$4(long r4, InteractionSessionProxyBinder r6) {
        FLogger.a.i(TAG, "onSessionDestroyed received, incoming=" + r4 + ", current=" + r6.sessionId);
        r6.clearSession(r4, "session destroyed");
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
    public void onHandleScreenshot(final long r2, final Bitmap r4) {
        onMain(new f(r2, r4, this));
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
    public void onSessionCreated(final long r5, final VoiceInteractionSessionController r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onSessionCreated received, incoming=");
        r1.append(r5);
        r1.append(", current=");
        r1.append(this.sessionId);
        r1.append(", hasController=");
        if (r7 == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i(TAG, r1.toString());
        if (r7 != null) goto L10;
        r0.w(TAG, "ignore session without controller, id=" + r5);
        return;
    L10:
        onMain(new c(this, r5, r7));
        return;
    L5:
        r2 = false;
        goto L6
    }

    private static final Unit onHandleScreenshot$lambda$2(long r3, Bitmap r5, InteractionSessionProxyBinder r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onHandleScreenshot received, id=");
        r1.append(r3);
        r1.append(", hasScreenshot=");
        if (r5 == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i(TAG, r1.toString());
        zaa.a r4 = r6.currentSession(r3, "onHandleScreenshot");
        if (r4 == null) goto L10;
        r4.c(r5);
    L10:
        return Unit.INSTANCE;
    L5:
        r2 = false;
        goto L6
    }

    private static final Unit onSessionCreated$lambda$0(InteractionSessionProxyBinder r0, long r1, VoiceInteractionSessionController r3) {
        r0.activateSession(r1, r3);
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
    public void onShow(final long r8, final Bundle r10, final int r11) {
        onMain(new h(r8, r11, r10, this));
    }

    private static final Unit onShow$lambda$3(long r3, int r5, Bundle r6, InteractionSessionProxyBinder r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onShow received, id=");
        r1.append(r3);
        r1.append(", showFlags=");
        r1.append(r5);
        r1.append(", hasArgs=");
        if (r6 == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i(TAG, r1.toString());
        zaa.a r4 = r7.currentSession(r3, "onShow");
        if (r4 == null) goto L10;
        r4.d(r6, r5);
    L10:
        return Unit.INSTANCE;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy
    public void onHandleAssist(final long r12, final int r14, final int r15, final boolean r16, final Bundle r17, final AssistStructure r18, final AssistContent r19) {
        onMain(new e(r12, r14, r15, r16, r17, r18, r19, this));
    }

    private static final Unit onHandleAssist$lambda$1(long r6, int r8, int r9, boolean r10, Bundle r11, AssistStructure r12, AssistContent r13, InteractionSessionProxyBinder r14) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onHandleAssist received, id=");
        r1.append(r6);
        r1.append(", index=");
        r1.append(r8);
        r1.append(", count=");
        r1.append(r9);
        r1.append(", focused=");
        r1.append(r10);
        r1.append(", hasData=");
        boolean r2 = false;
        if (r11 == null) goto L5;
        boolean r15 = true;
    L6:
        r1.append(r15);
        r1.append(", hasStructure=");
        if (r12 == null) goto L9;
        boolean r16 = true;
    L10:
        r1.append(r16);
        r1.append(", hasContent=");
        if (r13 == null) goto L13;
        r2 = true;
    L13:
        r1.append(r2);
        r0.i(TAG, r1.toString());
        zaa.a r3 = r14.currentSession(r6, "onHandleAssist");
        if (r3 == null) goto L17;
        r3.a(r8, r9, r10, r12, r13);
    L17:
        return Unit.INSTANCE;
    L9:
        r16 = false;
        goto L10
    L5:
        r15 = false;
        goto L6
    }
}
