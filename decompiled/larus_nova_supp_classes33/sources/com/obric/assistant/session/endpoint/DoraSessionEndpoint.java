package com.obric.assistant.session.endpoint;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAssistActivateOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.singleton.DoraWakeupDetector;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/assistant/session/endpoint/DoraSessionEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IDoraOperation;", "Lcom/obric/assistant/session/singleton/DoraWakeupDetector$DoraActionListener;", "<init>", "()V", "isDoraProxyWakeup", "", "isAutoMicDoraWakeup", "vuiId", "", "Ljava/lang/Integer;", "isDoraPressing", "prepareOrder", "getPrepareOrder", "()I", "processOrder", "getProcessOrder", "onSessionPrepared", "", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "startTouchSpeakTask", "Ljava/lang/Runnable;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVuiId", "()Ljava/lang/Integer;", "setAutoMicDoraWakeup", "enable", "action", "onDoraWakeup", "onDoraRadioStop", "onSessionCompleted", "code", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraSessionEndpoint implements ISessionEndPoint, IDoraOperation, DoraWakeupDetector.a {
    public boolean a;
    public boolean b;
    public volatile Integer c;
    public volatile boolean d;
    public final s0 e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ErrorCode.values().length];
            r0[ErrorCode.QUIT_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ErrorCode.ONLY_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final DoraSessionEndpoint action() {
        return this;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 50;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 90;
    }

    @Override // com.obric.assistant.session.singleton.DoraWakeupDetector.a
    public final void a() {
        FLogger.a.i(ISessionEndPoint.a.b(this), "onDoraRadioStop");
        this.d = false;
        com.larus.utils.y.b().removeCallbacks(this.e);
        ObricInteractDelegate.b.notifyAiKeyEvent(0);
        IAssistActivateOperation r0 = bga.d.a();
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final void e() {
        FLogger.a.i(ISessionEndPoint.a.b(this), "setAutoMicDoraWakeup to true");
        this.b = true;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "DoraSessionEndpoint";
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.assistant.session.endpoint.s0] */
    public DoraSessionEndpoint() {
        this.e = new s0();
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final boolean b() {
        return this.d;
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final boolean c() {
        return this.a;
    }

    @Override // com.obric.assistant.session.model.IDoraOperation
    public final Integer g() {
        return this.c;
    }

    @Override // com.obric.assistant.session.singleton.DoraWakeupDetector.a
    public final void i(Bundle r7) {
        Intrinsics.checkNotNullParameter(r7, "args");
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onDoraWakeup : " + this.b);
        this.a = true;
        if (this.b == false) goto L5;
        r7.putBoolean("AUTO_MIC_REQUEST", true);
        this.b = false;
    L5:
        Lazy r2 = aga.j.a;
        Intrinsics.checkNotNullParameter(r7, "bundle");
        r0.i("AiIsland-SessionUtils", "launchAssistantForDoraWakeup");
        Object r1 = AppHost.a.getApplication().getSystemService("search");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.SearchManager");
        SearchManager r3 = (SearchManager) r1;
        r3.getClass().getMethod("launchAssist", new Class[]{Bundle.class}).invoke(r3, new Object[]{r7});
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r5) {
        Intrinsics.checkNotNullParameter(r5, "code");
        FLogger.a.i(ISessionEndPoint.a.b(this), "onSessionCompleted " + r5);
        if (a.a[r5.ordinal()] == 1) goto L6;
        return;
    L6:
        if (this.a == false) goto L9;
        DoraWakeupDetector r6 = DoraWakeupDetector.a;
        DoraWakeupDetector.f();
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r16, Continuation<? super Pair<? extends ErrorCode, String>> r17) {
        if ((r17 instanceof DoraSessionEndpoint$onSessionProcess$1) == false) goto L7;
        DoraSessionEndpoint$onSessionProcess$1 r2 = (DoraSessionEndpoint$onSessionProcess$1) r17;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Bundle r6 = (Bundle) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Bundle r7 = r6;
    L17:
        String r8 = bga.j.a();
        if (ArraysKt.contains(new String[]{"WAKEUP_SOURCE_DORA_KEY_DOWN", IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_KEY_UP, "WAKEUP_SOURCE_DORA_KEY_CANCEL", IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP}, r8) == false) goto L20;
    L28:
        FLogger r9 = FLogger.a;
        r9.i(ISessionEndPoint.a.b(this), "requestFromStr in dora endpoint -> ".concat(r8));
        switch(r8.hashCode()) {
            case -1093096773: goto L67;
            case 651570445: goto L66;
            case 1003009595: goto L65;
            case 1284758364: goto L61;
            case 1996669219: goto L32;
            default: goto L30;
        };
    L30:
        String r10 = IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC;
    L74:
        if (ArraysKt.contains(new String[]{IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP, r10}, r8) == true) goto L84;
        ILaunchMethodOperation r11 = bga.g.a();
        if (r11 == null) goto L78;
        r11.j();
    L78:
        IObricChatService.a.getClass();
        IObricChatService r12 = IObricChatService.a.a();
        if (r12 == null) goto L82;
        r12.e();
    L82:
        return TuplesKt.to(ErrorCode.ONLY_END, "dora-not-in-wakeup");
    L84:
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L61:
        String r18 = IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC;
        if (r8.equals(IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_KEY_UP) == true) goto L64;
    L63:
        r10 = r18;
        goto L74
    L64:
        r10 = r18;
    L70:
        com.larus.utils.y.b().removeCallbacks(this.e);
        ObricInteractDelegate.b.notifyAiKeyEvent(0);
        IAssistActivateOperation r13 = bga.d.a();
        if (r13 == null) goto L74;
        Boxing.boxBoolean(r13.k());
        goto L74
    L65:
        r10 = IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC;
        r8.equals(r10);
        goto L74
    L66:
        r10 = IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC;
        r8.equals(IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP);
        goto L74
    L67:
        r10 = IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC;
        if (r8.equals("WAKEUP_SOURCE_DORA_KEY_CANCEL") == true) goto L70;
    L32:
        if (r8.equals("WAKEUP_SOURCE_DORA_KEY_DOWN") == false) goto L30;
        long r14 = r7.getLong("android.intent.extra.TIME", -1);
        r18 = IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC;
        long r15 = SystemClock.uptimeMillis();
        long r19 = r7.getLong("android.intent.extra.TIME", -1);
        if (r19 <= 0) goto L37;
        long r20 = RangesKt.coerceAtLeast(r15 - r19, 0);
    L38:
        r9.i(ISessionEndPoint.a.b(this), "doraKeyDown: eventTime=" + r14 + ", currentUptime=" + r15 + ", backtrackDurationMs=" + r20);
        IAssistActivateOperation r21 = bga.d.a();
        if (r21 == null) goto L41;
        Boxing.boxBoolean(r21.e(r7, r20));
    L41:
        ILaunchMethodOperation r22 = bga.g.a();
        if (r22 == null) goto L44;
        ILaunchMethodOperation.a.a(r22, null, "dora_radio", 1);
    L44:
        ILaunchMethodOperation r23 = bga.g.a();
        if (r23 == null) goto L47;
        r23.k("open_radio_mode");
    L47:
        IAssistActivateOperation r24 = bga.d.a();
        if (r24 != null) goto L50;
    L52:
        boolean r25 = false;
    L53:
        if (r25 == false) goto L57;
        IAssistActivateOperation r26 = bga.d.a();
        if (r26 == null) goto L57;
        r26.a();
    L57:
        ObricInteractDelegate.b.notifyAiKeyEvent(1);
        IAssistActivateOperation r27 = bga.d.a();
        if (r27 == null) goto L60;
        Boxing.boxBoolean(IAssistActivateOperation.a.b(r27, null, true, new t0(this), 3));
    L60:
        com.larus.utils.y.b().postDelayed(this.e, 500);
        goto L63
    L50:
        if (r24.j() == true) goto L52;
        r25 = true;
        goto L53
    L37:
        r20 = 100;
        goto L38
    L20:
        if (Intrinsics.areEqual(r8, IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC) == false) goto L84;
        ISessionMaintaining r28 = bga.j.b();
        if (r28 != null) goto L24;
    L26:
        boolean r29 = false;
    L27:
        if (r29 == false) goto L84;
    L24:
        if (r28.g() != true) goto L26;
        r29 = true;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r7 = r16;
        r2.L$0 = r7;
        r2.label = 1;
        if (ISessionEndPoint.a.e(this) != r4) goto L17;
        return r4;
    L7:
        r2 = new DoraSessionEndpoint$onSessionProcess$1(this, r17);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "args");
        ISessionEndPoint.a.d(this, r9, r10);
        String r11 = bga.j.a();
        if (ArraysKt.contains(new String[]{"WAKEUP_SOURCE_DORA_KEY_DOWN", IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_KEY_UP, "WAKEUP_SOURCE_DORA_KEY_CANCEL", IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP}, r11) == false) goto L5;
    L17:
        this.a = true;
        this.c = Integer.valueOf(r10.getInt("DORA_WAKEUP_VUIID"));
        FLogger.a.i(ISessionEndPoint.a.b(this), "dora wakeup, vuiid: " + this.c);
        int r12 = r11.hashCode();
        if (r12 == (-1093096773)) goto L33;
        if (r12 == 1284758364) goto L29;
        if (r12 == 1996669219) goto L25;
        return;
    L25:
        if (r11.equals("WAKEUP_SOURCE_DORA_KEY_DOWN") == false) goto L42;
        this.d = true;
        return;
    L42:
        return;
    L29:
        if (r11.equals(IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_KEY_UP) == false) goto L43;
        this.d = false;
        return;
    L43:
        return;
    L33:
        if (r11.equals("WAKEUP_SOURCE_DORA_KEY_CANCEL") == false) goto L44;
        this.d = false;
        return;
    L44:
        return;
    L5:
        if (Intrinsics.areEqual(r11, IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC) == false) goto L15;
        ISessionMaintaining r0 = bga.j.b();
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
    L9:
        if (r0.g() != true) goto L11;
        r1 = true;
    L15:
        if (this.d == true) goto L37;
        this.a = false;
        this.c = null;
        return;
    }
}
