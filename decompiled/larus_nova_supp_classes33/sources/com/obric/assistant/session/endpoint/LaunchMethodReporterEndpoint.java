package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.session.bean.ActivateEventType;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IApplicationActivityOperation;
import com.obric.assistant.session.model.IAutoMicOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.voice.ContentScene;
import com.obric.capabilitykit.common.UiType;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\u001c\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0016J'\u0010+\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0002\u0010/R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/session/endpoint/LaunchMethodReporterEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/ILaunchMethodOperation;", "<init>", "()V", "mCurLaunchMethod", "Ljava/util/concurrent/atomic/AtomicReference;", "", "mIsAIPowerKeyExchange", "", "processOrder", "", "getProcessOrder", "()I", "isAppBackgroundWhenAiKeyDown", "onSessionPrepared", "", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisableScreenShot", "foreGroundAppPackageName", "foreGroundActivityName", "getDefaultLauncherPackageName", "updateLaunchReportParams", "launchService", "launchMethod", "onAiKeyDown", "updateWakeupSource", "updateLaunchMethod", "eventType", "Lcom/obric/assistant/session/bean/ActivateEventType;", "rawLaunchMethod", "getLaunchMethod", "reportAiKeyPressDuration", "duration", "payload", "Lorg/json/JSONObject;", "reportAiKeyWakeupDuration", "systemKeyToWakeupDuration", "wakeupTimeMillis", "", "(ILjava/lang/Integer;J)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchMethodReporterEndpoint implements ISessionEndPoint, ILaunchMethodOperation {
    public final AtomicReference<String> a;
    public volatile boolean b;
    public volatile boolean c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ContentScene.values().length];
            r0[ContentScene.OAUTO_CALL_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ContentScene.PRIORITY_NOTIFICATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            a = r0;
            int[] r1 = new int[ActivateEventType.values().length];
            r1[ActivateEventType.SinglePress.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r1[ActivateEventType.DoublePress.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r1[ActivateEventType.LongPress.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[ActivateEventType.Other.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 40;
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final String a() {
        return this.a.get();
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void g() {
        this.c = AppHost.a.a().isAppBackground();
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "LaunchMethodReporterEndpoint";
    }

    public LaunchMethodReporterEndpoint() {
        this.a = new AtomicReference(IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void j() {
        IDoraOperation r0 = bga.f.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.c();
    L6:
        FLogger.a.i(ISessionEndPoint.a.b(this), "updateWakeupSource with requestFrom " + bga.j.a() + " and session " + bga.j.c() + " doraProxyWakeup " + r1 + ' ');
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L13;
        if (Intrinsics.areEqual(bga.j.c(), "VOICE") == false) goto L11;
        String r2 = "voice.wakeup";
    L23:
        if (Intrinsics.areEqual(IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP, bga.j.a()) == false) goto L26;
        if (r1 == false) goto L26;
        r2 = "dora.wakeup";
    L26:
        IObricReporter.a.getClass();
        IObricReporter r3 = IObricReporter.a.a();
        if (r3 == null) goto L30;
        r3.p(r2);
        return;
    L30:
        return;
    L11:
        r2 = "voice.breath";
        goto L23
    L13:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKE_UP_SOURCE_BLUETOOTH) == false) goto L16;
        r2 = "voice.bluetooth";
        goto L23
    L16:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_DORA_KEY_DOWN") == false) goto L18;
    L21:
        r2 = "dora.bluetooth";
        goto L23
    L18:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_KEY_UP) == true) goto L21;
        r2 = "voice.other";
        goto L23
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final String b(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.addCategory("android.intent.category.HOME");
        ResolveInfo r4 = r3.getPackageManager().resolveActivity(r0, UiType.FLAG_ALARM_CLOCK_CARD);
        if (r4 == null) goto L7;
        ActivityInfo r5 = r4.activityInfo;
        if (r5 == null) goto L7;
        return r5.packageName;
    L7:
        return null;
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void k(String r4) {
        Intrinsics.checkNotNullParameter(r4, "launchService");
        String r0 = this.a.get();
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        r4 = "open_doubao";
    L6:
        IObricReporter.a.getClass();
        IObricReporter r1 = IObricReporter.a.a();
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.c == true) goto L11;
    L13:
        boolean r2 = false;
    L14:
        r1.n(r0, r4, r2);
        return;
    L11:
        if (Intrinsics.areEqual(r0, "long_press_ai_button") == false) goto L13;
        r2 = true;
        goto L14
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r1) {
        ISessionEndPoint.a.c(this, r1);
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void c(int r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "payload");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LaunchMethodReporterEndpoint$reportAiKeyPressDuration$1(r9, r8, this, null), 3, null);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r5, Continuation<? super Pair<? extends ErrorCode, String>> r6) {
        if ((r6 instanceof LaunchMethodReporterEndpoint$onSessionProcess$1) == false) goto L7;
        LaunchMethodReporterEndpoint$onSessionProcess$1 r7 = (LaunchMethodReporterEndpoint$onSessionProcess$1) r6;
        int r0 = r7.label;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r7.label = r0 - Integer.MIN_VALUE;
    L8:
        Object r8 = r7.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r7.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        j();
        String r9 = bga.j.a();
        switch(r9.hashCode()) {
            case -263612710: goto L51;
            case 651570445: goto L47;
            case 1003009595: goto L29;
            case 1284758364: goto L25;
            case 1306767466: goto L21;
            default: goto L57;
        };
    L57:
        String r10 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
    L58:
        ILaunchMethodOperation.a.a(this, null, r10, 1);
        IInteractionStateService r11 = IAssistantInteractionServiceKt.getInteractionStateService();
        IApplicationActivityOperation r12 = bga.c.a();
        if (r12 == null) goto L62;
        String r13 = r12.c();
        if (r13 == null) goto L62;
    L63:
        r11.setWakeUpAppPkg(r13, "LaunchMethodReporter onSessionProcess");
        IApplicationActivityOperation r14 = bga.c.a();
        if (r14 == null) goto L67;
        String r15 = r14.c();
        if (r15 == null) goto L67;
    L68:
        IApplicationActivityOperation r16 = bga.c.a();
        if (r16 == null) goto L72;
        String r17 = r16.a();
        if (r17 == null) goto L72;
    L73:
        boolean r18 = l(r15, r17);
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L76;
    L77:
        j();
    L78:
        Boolean r19 = Boxing.boxBoolean(r18);
        Intrinsics.checkNotNullParameter("disableScreenShot", "key");
        Intrinsics.checkNotNullParameter(r19, "value");
        ISessionMaintaining r3 = bga.j.b();
        if (r3 == null) goto L82;
        r3.h("disableScreenShot", r19);
        Unit r20 = Unit.INSTANCE;
    L82:
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L76:
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP) == false) goto L78;
    L72:
        r17 = "";
    L67:
        r15 = "";
    L62:
        r13 = "";
        goto L63
    L21:
        if (r9.equals(IInteractionStateService$Companion.WAKE_UP_SOURCE_BLUETOOTH) == false) goto L57;
        r10 = "third_party_gesture";
        goto L58
    L25:
        if (r9.equals(IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_KEY_UP) == false) goto L57;
        r10 = "dora_radio";
        goto L58
    L29:
        if (r9.equals(IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC) == false) goto L57;
        IAutoMicOperation r21 = bga.e.a();
        if (r21 == null) goto L36;
        zfa.a r22 = r21.getToken();
        if (r22 == null) goto L36;
        ContentScene r23 = r22.a;
    L37:
        if (r23 != null) goto L39;
        int r24 = -1;
    L40:
        if (r24 != 1) goto L42;
        r10 = "oauto_automic";
        goto L58
    L42:
        if (r24 != 2) goto L57;
        r10 = "high_priority_notification";
        goto L58
    L39:
        r24 = a.a[r23.ordinal()];
    L36:
        r23 = null;
        goto L37
    L47:
        if (r9.equals(IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP) == false) goto L57;
        r10 = "dora_call";
        goto L58
    L51:
        if (r9.equals(IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L57;
        if (Intrinsics.areEqual(bga.j.c(), "BREATH") == false) goto L56;
        r10 = "speak_nearby";
        goto L58
    L56:
        r10 = "audio";
        goto L58
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r7.label = 1;
        if (ISessionEndPoint.a.e(this) != r1) goto L17;
        return r1;
    L7:
        r7 = new LaunchMethodReporterEndpoint$onSessionProcess$1(this, r6);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void e(ActivateEventType r4, String r5) {
        if (com.larus.utils.o0.d(r5) == false) goto L6;
        this.a.set(r5);
        return;
    L6:
        String r6 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
        if (r4 != null) goto L10;
        this.a.set(IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);
        return;
    L10:
        boolean r0 = this.b;
        int r7 = a.b[r4.ordinal()];
        if (r7 != 1) goto L13;
        if (r0 == true) goto L29;
        r6 = "single_click_ai_button";
    L30:
        this.a.set(r6);
        FLogger.a.i(ISessionEndPoint.a.b(this), "onShow login, the launch method is : [ " + r6 + " ]");
        return;
    L29:
        r6 = "single_click_power_button";
        goto L30
    L13:
        if (r7 != 2) goto L15;
        if (r0 == true) goto L26;
        r6 = "double_click_ai_button";
        goto L30
    L26:
        r6 = "double_click_power_button";
        goto L30
    L15:
        if (r7 != 3) goto L17;
        if (r0 == true) goto L23;
        r6 = "long_press_ai_button";
        goto L30
    L23:
        r6 = "long_press_power_button";
        goto L30
    L17:
        if (r7 == 4) goto L30;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final boolean l(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "foreGroundAppPackageName");
        Intrinsics.checkNotNullParameter(r6, "foreGroundActivityName");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r5, getContext().getPackageName()) == false) goto L9;
        if (StringsKt.contains$default(r6, "com.obric.miniapp", false, 2, null) == true) goto L9;
    L10:
        return true;
    L9:
        if (Intrinsics.areEqual(r5, b(getContext())) == true) goto L10;
        return false;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "args");
        ISessionEndPoint.a.d(this, r2, r3);
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER) == true) goto L10;
        boolean r4 = r3.getBoolean("toggle_ai_button");
        boolean r5 = true;
        if (r4 == true) goto L8;
        r5 = false;
    L8:
        this.b = r5;
        return;
    }

    @Override // com.obric.assistant.session.model.ILaunchMethodOperation
    public final void i(int r12, Integer r13, long r14) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LaunchMethodReporterEndpoint$reportAiKeyWakeupDuration$1(r12, r13, this, r14, null), 3, null);
    }
}
