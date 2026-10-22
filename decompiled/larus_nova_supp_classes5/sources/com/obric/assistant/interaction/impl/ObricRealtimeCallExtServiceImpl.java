package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.camera.api.IFlowCamera;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.home.impl.utils.c;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.larus.voicecall.api.IVoiceCallService;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IObricShowOnLockedService;
import com.obric.assistant.interaction.impl.receiver.RealtimeCallNotificationForwardReceiver;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.spi.audio.CallType;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.utils.e;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import laa.d;
import naa.a;
import t19.s;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\"\u0010'\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010)\u001a\u00020*H\u0016J$\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\tH\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020\u001aH\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\u0018\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u0002062\u0006\u00109\u001a\u000206H\u0016J6\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020?2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010AH\u0096@¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020\u0005H\u0016J\f\u0010D\u001a\u00020\u0005*\u00020\rH\u0002J\f\u00101\u001a\u00020\u0005*\u00020\rH\u0002J\u0010\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u000fH\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HH\u0002J\b\u0010J\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricRealtimeCallExtServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "<init>", "()V", "isInited", "", "realtimeCallActivityIntents", "Ljava/util/WeakHashMap;", "Landroidx/fragment/app/FragmentActivity;", "Landroid/content/Intent;", "actionToExecuteOnDestroy", "Ljava/lang/Runnable;", "isAppInBackgroundWhenStart", "Landroid/app/Activity;", "startupReadyBoundActivities", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "obricShowOnLockedService", "Lcom/obric/assistant/interaction/api/service/IObricShowOnLockedService;", "getObricShowOnLockedService", "()Lcom/obric/assistant/interaction/api/service/IObricShowOnLockedService;", "obricShowOnLockedService$delegate", "Lkotlin/Lazy;", "DOUBLE_CLICK_AI_KEY", "init", "", "onRealtimeCallActivityCreated", "activity", "savedInstanceState", "Landroid/os/Bundle;", "bindRealtimeCallStartupReadyIfNeeded", "removeRealtimeCallPreDrawListener", "observer", "Landroid/view/ViewTreeObserver;", "listener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onRealtimeCallActivityDestroy", "onRealtimeCallActivityFinish", "onRealtimeCallActivityOnNewIntent", "newIntent", "fragment", "Landroidx/fragment/app/Fragment;", "getNotificationPendingIntent", "Landroid/app/PendingIntent;", "packageContext", "Landroid/content/Context;", "isGoToChatPage", "currentContext", "isRealtimeCallActivity", "intent", "hasRealtimeCallActivity", "setShowWhenLockedForExistingRealtimeCallActivity", "getCurrentCallType", "Lcom/obric/assistant/spi/audio/CallType;", "changeCallType", "currentCallType", "targetCallType", "launchRealtimeCall", "Lcom/obric/assistant/spi/audio/LaunchRealtimeCallResult;", "callType", "from", "delayJumpMS", "", "onPreJump", "Lkotlin/Function0;", "(Lcom/obric/assistant/spi/audio/CallType;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAssistantListening", "isAlive", "isMainRtcAlive", "mainConversationId", "finishUnrelatedVideoPages", "", "Landroidx/activity/ComponentActivity;", "isChatWindowDismiss", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRealtimeCallExtServiceImpl implements IObricRealtimeCallExtService {
    public static final Companion Companion = null;
    private static final long MAX_RTC_READY_BIND_DURATION_MS = 15000;
    private static final int MAX_RTC_READY_REPORT_ATTEMPTS = 3;
    private static final String TAG = "ObricRealtimeCallExtServiceImpl";
    private final String DOUBLE_CLICK_AI_KEY;
    private final WeakHashMap<FragmentActivity, Runnable> actionToExecuteOnDestroy;
    private final WeakHashMap<Activity, Boolean> isAppInBackgroundWhenStart;
    private boolean isInited;
    private final CoroutineScope mainScope;
    private final Lazy obricShowOnLockedService$delegate;
    private final WeakHashMap<FragmentActivity, Intent> realtimeCallActivityIntents;
    private final WeakHashMap<Activity, String> startupReadyBoundActivities;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ boolean a(Intent r0) {
        return init$lambda$1(r0);
    }

    public static /* synthetic */ void b(FragmentActivity r0, Intent r1) {
        onRealtimeCallActivityOnNewIntent$lambda$4(r0, r1);
    }

    public static /* synthetic */ void c(ObricRealtimeCallExtServiceImpl r0, ViewTreeObserver r1, bindRealtimeCallStartupReadyIfNeeded.listener.1 r2) {
        bindRealtimeCallStartupReadyIfNeeded$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ IObricShowOnLockedService d() {
        return obricShowOnLockedService_delegate$lambda$0();
    }

    public static /* synthetic */ void e() {
        launchRealtimeCall$lambda$15();
    }

    public synchronized void init() {
        monitor-enter(this);
        FLogger.a.i(TAG, "init");     // Catch: Throwable -> L14
        if (this.isInited == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isInited = true;     // Catch: Throwable -> L14
        IObricShowOnLockedService r0 = (IObricShowOnLockedService) ServiceManager.get().getService(IObricShowOnLockedService.class);     // Catch: Throwable -> L14
        if (r0 == null) goto L11;
        r0.addShowOnLockedClazz(ObricRealtimeCallServiceDelegate.b.u(), false, new a0());     // Catch: Throwable -> L14
    L11:
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(new init.2(this));     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private final List<ComponentActivity> finishUnrelatedVideoPages() {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 != null) goto L8;
        int r1 = e.a;
        r0 = (Activity) e.a(Activity.class);
        if (r0 != null) goto L8;
        FLogger.a.i(TAG, "finishUnrelatedVideoPages: no last activity");
        return CollectionsKt.emptyList();
    L8:
        FLogger r2 = FLogger.a;
        r2.i(TAG, "finishUnrelatedVideoPages: lastActivity = " + r0);
        if (r0.isFinishing() == false) goto L11;
    L25:
        r2.i(TAG, "finishUnrelatedVideoPages: " + r0 + " is already finishing or destroyed");
        return CollectionsKt.emptyList();
    L11:
        if (r0.isDestroyed() == true) goto L25;
        IFlowCamera r3 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r3 == null) goto L16;
        List r4 = r3.i();
    L17:
        if (r4 != null) goto L19;
        r4 = CollectionsKt.emptyList();
    L19:
        r2.i(TAG, "finishUnrelatedVideoPages: cameraCaptureActivityClassNames = " + r4);
        ArrayList r5 = new ArrayList();
        if (r4.contains(r0.getClass().getName()) == false) goto L24;
        r2.i(TAG, "finishUnrelatedVideoPages: finish " + r0);
        r0.finish();
        if ((r0 instanceof ComponentActivity) == false) goto L24;
        r5.add(r0);
    L24:
        return r5;
    L16:
        r4 = null;
        goto L17
    }

    private final IObricShowOnLockedService getObricShowOnLockedService() {
        return (IObricShowOnLockedService) this.obricShowOnLockedService$delegate.getValue();
    }

    private final boolean isChatWindowDismiss() {
        b r0 = IObricChatContextService.a.a(ObricChatContextServiceDelegate.b);
        if (r0 != null) goto L6;
        FLogger.a.i(TAG, "isChatWindowDismiss: not found chat vContext");
        return false;
    L6:
        d r1 = r0.getAbility(d.class);
        if (r1 != null) goto L10;
        FLogger.a.i(TAG, "isChatWindowDismiss: not found chatPageStateAbility");
        return false;
    L10:
        ObricFloatChatPageState r2 = r1.getPageState();
        FLogger.a.i(TAG, "isChatWindowDismiss: pageState = " + r2);
        return r1.getPageState() instanceof vda.b;
    }

    private static final void launchRealtimeCall$lambda$15() {
        AppHost.Companion r0 = AppHost.a;
        Toast.makeText(r0.getApplication(), r0.getApplication().getString(2131898479), 0).show();
    }

    private static final IObricShowOnLockedService obricShowOnLockedService_delegate$lambda$0() {
        return (IObricShowOnLockedService) ServiceManager.get().getService(IObricShowOnLockedService.class);
    }

    public CallType getCurrentCallType() {
        List r0 = AppHost.a.a().g();
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        Object r2 = r1.previous();
        if (isRealtimeCallActivity((Activity) r2) == false) goto L4;
    L10:
        if ((r2 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r3 = (FragmentActivity) r2;
    L14:
        if (r3 != null) goto L17;
        FLogger.a.i(TAG, "getCurrentCallType: curRealtimeActivity is null");
        return null;
    L17:
        Fragment r4 = ObricRealtimeCallServiceDelegate.b.p(r3);
        if (r4 != null) goto L21;
        FLogger.a.i(TAG, "getCurrentCallType: realtimeCallFragment is null");
        return null;
    L21:
        a r5 = s1a.a.g(r4).getAbility(a.class);
        if (r5 != null) goto L24;
    L27:
        naa.b r6 = s1a.a.g(r4).getAbility(naa.b.class);
        if (r6 != null) goto L30;
    L35:
        FLogger.a.i(TAG, "getCurrentCallType: Audio");
        return CallType.Audio;
    L30:
        if (r6.s6() == false) goto L32;
    L33:
        FLogger.a.i(TAG, "getCurrentCallType: Video");
        return CallType.Video;
    L32:
        if (r6.DZ() == false) goto L35;
    L24:
        if (r5.mu() == false) goto L27;
        FLogger.a.i(TAG, "getCurrentCallType: ScreenShare");
        return CallType.ScreenShare;
    L12:
        r3 = null;
        goto L14
    L8:
        r2 = null;
        goto L10
    }

    public boolean hasRealtimeCallActivity() {
        return !this.realtimeCallActivityIntents.isEmpty();
    }

    public boolean isAssistantListening() {
        return ObricInteractionProjectionDelegate.b.a(null).b();
    }

    public void setShowWhenLockedForExistingRealtimeCallActivity() {
        Set<FragmentActivity> r0 = this.realtimeCallActivityIntents.keySet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        FragmentActivity r4 = (FragmentActivity) r3;
        Intrinsics.checkNotNull(r4);
        if (isAlive(r4) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        FragmentActivity r6 = (FragmentActivity) r5.next();
        IObricShowOnLockedService r7 = getObricShowOnLockedService();
        if (r7 == null) goto L10;
        Intrinsics.checkNotNull(r6);
        r7.setShowOnLocked(r6);
        goto L10
    }

    public ObricRealtimeCallExtServiceImpl() {
        this.realtimeCallActivityIntents = new WeakHashMap();
        this.actionToExecuteOnDestroy = new WeakHashMap();
        this.isAppInBackgroundWhenStart = new WeakHashMap();
        this.startupReadyBoundActivities = new WeakHashMap();
        this.mainScope = CoroutineScopeKt.MainScope();
        this.obricShowOnLockedService$delegate = LazyKt.lazy(new e0());
        this.DOUBLE_CLICK_AI_KEY = "obricDoubleClickAiKey";
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_ObricRealtimeCallExtServiceImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ List access$finishUnrelatedVideoPages(ObricRealtimeCallExtServiceImpl r0) {
        return r0.finishUnrelatedVideoPages();
    }

    public static final /* synthetic */ WeakHashMap access$getActionToExecuteOnDestroy$p(ObricRealtimeCallExtServiceImpl r0) {
        return r0.actionToExecuteOnDestroy;
    }

    public static final /* synthetic */ WeakHashMap access$getRealtimeCallActivityIntents$p(ObricRealtimeCallExtServiceImpl r0) {
        return r0.realtimeCallActivityIntents;
    }

    public static final /* synthetic */ WeakHashMap access$isAppInBackgroundWhenStart$p(ObricRealtimeCallExtServiceImpl r0) {
        return r0.isAppInBackgroundWhenStart;
    }

    private final void bindRealtimeCallStartupReadyIfNeeded(Activity r10) {
        Intent r0 = this.realtimeCallActivityIntents.get(r10);
        if (r0 != null) goto L5;
        r0 = r10.getIntent();
    L5:
        String r1 = r0.getStringExtra("obric_startup_attempt_id");
        if (r1 != null) goto L8;
        return;
    L8:
        if ((!StringsKt.isBlank(r1)) == true) goto L11;
        r1 = null;
    L11:
        String r4 = r1;
        if (r4 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.i("rtc_call_content_ready"), r4) == true) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(this.startupReadyBoundActivities.get(r10), r4) == false) goto L19;
        return;
    L19:
        Window r2 = r10.getWindow();
        if (r2 == null) goto L31;
        View r3 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_ObricRealtimeCallExtServiceImpl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2);
        if (r3 == null) goto L32;
        ViewTreeObserver r8 = r3.getViewTreeObserver();
        if (r8.isAlive() == true) goto L27;
        return;
    L27:
        this.startupReadyBoundActivities.put(r10, r4);
        bindRealtimeCallStartupReadyIfNeeded.listener.1 r11 = new bindRealtimeCallStartupReadyIfNeeded.listener.1(r3, new Ref$BooleanRef(), r4, this, r8, new Ref$IntRef());
        r8.addOnPreDrawListener(r11);
        r3.postInvalidateOnAnimation();
        r3.postDelayed(new c0(this, r8, r11), MAX_RTC_READY_BIND_DURATION_MS);
        return;
    L32:
        return;
    }

    private static final boolean init$lambda$1(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        FLogger.a.i(TAG, "addShowOnLockedClazz " + r3);
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L5;
        return true;
    L5:
        r3.putExtra("obric_need_activity_auth_on_lock", true);
        return false;
    }

    private final boolean isAlive(Activity r2) {
        if (r2.isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.isDestroyed() == true) goto L7;
        return true;
    }

    private final boolean isMainRtcAlive(String r6) {
        FLogger.a.i(TAG, "isMainRtcAlive: mainConversationId = " + r6);
        Iterator<T> r0 = this.realtimeCallActivityIntents.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        FragmentActivity r3 = (FragmentActivity) r1;
        Intrinsics.checkNotNull(r3);
        if (isAlive(r3) == false) goto L4;
    L9:
        FragmentActivity r2 = (FragmentActivity) r1;
        if (r2 != null) goto L13;
        FLogger.a.i(TAG, "isMainRtcAlive: no call activity");
        return false;
    L13:
        ObricRealtimeCallServiceDelegate r4 = ObricRealtimeCallServiceDelegate.b;
        Fragment r5 = r4.p(r2);
        if (r5 != null) goto L17;
        FLogger.a.i(TAG, "isMainRtcAlive: no call fragment");
        return false;
    L17:
        String r7 = (String) r4.j(r5).component1();
        FLogger.a.i(TAG, "isMainRtcAlive: curConversationId = " + r7);
        return Intrinsics.areEqual(r7, r6);
    L8:
        r1 = null;
        goto L9
    }

    private final void onRealtimeCallActivityDestroy(Activity r2) {
        TypeIntrinsics.asMutableMap(this.realtimeCallActivityIntents).remove(r2);
        Runnable r0 = (Runnable) TypeIntrinsics.asMutableMap(this.actionToExecuteOnDestroy).remove(r2);
        if (r0 == null) goto L5;
        r0.run();
    L5:
        this.isAppInBackgroundWhenStart.remove(r2);
        this.startupReadyBoundActivities.remove(r2);
    }

    public boolean isRealtimeCallActivity(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        ComponentName r3 = r2.getComponent();
        if (r3 == null) goto L5;
        String r4 = r3.getClassName();
    L7:
        return Intrinsics.areEqual(r4, ObricRealtimeCallServiceDelegate.b.u());
    L5:
        r4 = null;
        goto L7
    }

    public void onRealtimeCallActivityFinish(FragmentActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        FLogger r0 = FLogger.a;
        r0.i(TAG, r5 + ".onFinish");
        if (r5.isTaskRoot() == false) goto L6;
        r0.i(TAG, "finishAndRemoveTask");
        r5.finishAndRemoveTask();
        return;
    L6:
        if (Intrinsics.areEqual(this.isAppInBackgroundWhenStart.get(r5), Boolean.TRUE) == true) goto L8;
        return;
    L8:
        if (isChatWindowDismiss() == false) goto L13;
        r0.i(TAG, "moveTaskToBack because is exclude from recent tasks");
        r5.moveTaskToBack(true);
        return;
    }

    private final boolean isRealtimeCallActivity(Activity r2) {
        return ObricRealtimeCallServiceDelegate.b.s(r2);
    }

    public static final /* synthetic */ void access$bindRealtimeCallStartupReadyIfNeeded(ObricRealtimeCallExtServiceImpl r0, Activity r1) {
        r0.bindRealtimeCallStartupReadyIfNeeded(r1);
    }

    public static final /* synthetic */ boolean access$isMainRtcAlive(ObricRealtimeCallExtServiceImpl r0, String r1) {
        return r0.isMainRtcAlive(r1);
    }

    public static final /* synthetic */ boolean access$isRealtimeCallActivity(ObricRealtimeCallExtServiceImpl r0, Activity r1) {
        return r0.isRealtimeCallActivity(r1);
    }

    public static final /* synthetic */ void access$onRealtimeCallActivityDestroy(ObricRealtimeCallExtServiceImpl r0, Activity r1) {
        r0.onRealtimeCallActivityDestroy(r1);
    }

    private final void onRealtimeCallActivityCreated(Activity r3, Bundle r4) {
        FLogger r5 = FLogger.a;
        r5.i(TAG, r3 + ".onCreate");
        if ((r3 instanceof FragmentActivity) == true) goto L6;
        r5.w(TAG, "is not FragmentActivity");
        return;
    L6:
        this.realtimeCallActivityIntents.put(r3, ((FragmentActivity) r3).getIntent());
    }

    private static final void onRealtimeCallActivityOnNewIntent$lambda$4(FragmentActivity r3, Intent r4) {
        FLogger.a.i(TAG, "start activity after destroy: " + r3);
        r3.startActivity(r4);
    }

    private final void removeRealtimeCallPreDrawListener(ViewTreeObserver r2, ViewTreeObserver.OnPreDrawListener r3) {
        if (r2.isAlive() == false) goto L6;
        r2.removeOnPreDrawListener(r3);
        return;
    }

    public void changeCallType(CallType r12, CallType r13) {
        Intrinsics.checkNotNullParameter(r12, "currentCallType");
        Intrinsics.checkNotNullParameter(r13, "targetCallType");
        FLogger.a.i(TAG, "changeCallType: currentCallType=" + r12 + ", targetCallType=" + r13);
        if (r12 != r13) goto L5;
        return;
    L5:
        List r0 = AppHost.a.a().g();
        ListIterator r1 = r0.listIterator(r0.size());
    L7:
        if (r1.hasPrevious() == false) goto L11;
        Object r2 = r1.previous();
        if (isRealtimeCallActivity((Activity) r2) == false) goto L7;
    L13:
        if ((r2 instanceof FragmentActivity) == false) goto L15;
        FragmentActivity r3 = (FragmentActivity) r2;
    L16:
        if (r3 != null) goto L19;
        FLogger.a.i(TAG, "changeCallType: curRealtimeActivity is null");
        return;
    L19:
        Fragment r4 = ObricRealtimeCallServiceDelegate.b.p(r3);
        if (r4 != null) goto L23;
        FLogger.a.i(TAG, "changeCallType: realtimeCallFragment is null");
        return;
    L23:
        a r5 = s1a.a.g(r4).getAbility(a.class);
        if (r5 == null) goto L31;
        CallType r6 = CallType.ScreenShare;
        if (r12 != r6) goto L28;
        FLogger.a.i(TAG, "changeCallType: exit ScreenShare");
        r5.Wf(this.DOUBLE_CLICK_AI_KEY);
    L28:
        if (r13 != r6) goto L31;
        FLogger.a.i(TAG, "changeCallType: enter ScreenShare");
        r5.P6(this.DOUBLE_CLICK_AI_KEY);
        return;
    L31:
        CallType r14 = getCurrentCallType();
        FLogger r7 = FLogger.a;
        r7.i(TAG, "changeCallType: nowCallType=" + r14);
        naa.b r8 = s1a.a.g(r4).getAbility(naa.b.class);
        if (r8 == null) goto L57;
        CallType r9 = CallType.Video;
        if (r13 != r9) goto L48;
        if (r14 == r9) goto L48;
        r7.i(TAG, "changeCallType: enter Video");
        IVoiceCallService r15 = (IVoiceCallService) ServiceManager.get().getService(IVoiceCallService.class);
        if (r15 == null) goto L43;
        String r16 = r15.s();
        if (r16 == null) goto L43;
        boolean r10 = true;
        if (StringsKt.startsWith$default(r16, "interpret", false, 2, null) != true) goto L43;
    L44:
        if (r10 == false) goto L46;
        s.j(s.a, r4.getActivity(), AppHost.a.getApplication().getString(2131912199), 0, false, 24);
        return;
    L46:
        r8.ju();
        return;
    L43:
        r10 = false;
    L48:
        CallType r11 = CallType.Audio;
        if (r13 != r11) goto L58;
        if (r14 == r11) goto L59;
        r7.i(TAG, "changeCallType: exit Video, enter Audio");
        r8.PW(this.DOUBLE_CLICK_AI_KEY);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L15:
        r3 = null;
        goto L16
    L11:
        r2 = null;
        goto L13
    }

    public static final /* synthetic */ void access$onRealtimeCallActivityCreated(ObricRealtimeCallExtServiceImpl r0, Activity r1, Bundle r2) {
        r0.onRealtimeCallActivityCreated(r1, r2);
    }

    public static final /* synthetic */ void access$removeRealtimeCallPreDrawListener(ObricRealtimeCallExtServiceImpl r0, ViewTreeObserver r1, ViewTreeObserver.OnPreDrawListener r2) {
        r0.removeRealtimeCallPreDrawListener(r1, r2);
    }

    private static final void bindRealtimeCallStartupReadyIfNeeded$lambda$3(ObricRealtimeCallExtServiceImpl r0, ViewTreeObserver r1, bindRealtimeCallStartupReadyIfNeeded.listener.1 r2) {
        Intrinsics.checkNotNull(r1);
        r0.removeRealtimeCallPreDrawListener(r1, r2);
    }

    public PendingIntent getNotificationPendingIntent(Context r3, boolean r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "packageContext");
        Intent r6 = new Intent();
        r6.setComponent(new ComponentName(r3.getPackageName(), RealtimeCallNotificationForwardReceiver.class.getName()));
        Unit r7 = Unit.INSTANCE;
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r8 = 201326592;
    L7:
        return PendingIntent.getBroadcast(r3, 0, r6, r8);
    L5:
        r8 = 134217728;
        goto L7
    }

    public void onRealtimeCallActivityOnNewIntent(FragmentActivity r7, Intent r8, Fragment r9) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r9, "fragment");
        FLogger r0 = FLogger.a;
        r0.i(TAG, r7 + ".onNewIntent");
        if (r8 != null) goto L5;
        return;
    L5:
        this.realtimeCallActivityIntents.put(r7, r8);
        Bundle r1 = r8.getExtras();
        String r3 = null;
        if (r1 == null) goto L8;
        String r2 = r1.getString("conversation_id");
    L9:
        String r4 = "";
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        Bundle r5 = r8.getExtras();
        if (r5 == null) goto L15;
        r3 = r5.getString("bot_id");
    L15:
        if (r3 == null) goto L19;
        r4 = r3;
    L19:
        if (o0.d(r2) == true) goto L21;
    L28:
        bindRealtimeCallStartupReadyIfNeeded(r7);
        IObricShowOnLockedService r10 = getObricShowOnLockedService();
        if (r10 == null) goto L32;
        r10.setShowOnLocked(r7);
        return;
    L32:
        return;
    L21:
        if (o0.d(r4) == false) goto L28;
        ObricRealtimeCallServiceDelegate r6 = ObricRealtimeCallServiceDelegate.b;
        Pair r11 = r6.j(r9);
        String r12 = (String) r11.component1();
        String r13 = (String) r11.component2();
        if (Intrinsics.areEqual(r12, r2) == true) goto L25;
    L26:
        r0.i(TAG, "conversationId or botId changed, finish current activity");
        r8.setComponent(new ComponentName(r7.getPackageName(), r6.u()));
        this.actionToExecuteOnDestroy.put(r7, new d0(r7, r8));
        r7.finish();
        return;
    L25:
        if (Intrinsics.areEqual(r13, r4) == true) goto L28;
    L8:
        r2 = null;
        goto L9
    }

    public Object launchRealtimeCall(CallType r25, String r26, long r27, Function0<Unit> r29, Continuation<? super com.obric.assistant.spi.audio.a> r30) {
        if ((r30 instanceof launchRealtimeCall.1) == false) goto L7;
        launchRealtimeCall.1 r5 = (launchRealtimeCall.1) r30;
        int r6 = r5.label;
        if ((r6 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        String r10 = null;
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        long r0 = r5.J$0;
        String r2 = (String) r5.L$3;
        Function0<Unit> r3 = (Function0) r5.L$2;
        String r9 = (String) r5.L$1;
        CallType r11 = (CallType) r5.L$0;
        ResultKt.throwOnFailure(r4);
        CallType r12 = r11;
        String r13 = r9;
        int r14 = 1;
        String r15 = r2;
        Function0<Unit> r16 = r3;
        long r1 = r0;
    L45:
        List r17 = (List) r4;
        boolean r18 = false;
        Pair r19 = TuplesKt.to((BotModel) ListProtector.get(r17, 0), (wc9.e) ListProtector.get(r17, r14));
        BotModel r20 = (BotModel) r19.component1();
        wc9.e r21 = (wc9.e) r19.component2();
        if (r20 != null) goto L57;
        FLogger.a.w(TAG, "mainBot is null");
        IObricNetworkService r22 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r22 != null) goto L50;
    L52:
        boolean r23 = false;
    L53:
        if (r23 == false) goto L56;
        return new com.obric.assistant.spi.audio.a.f();
    L56:
        return new com.obric.assistant.spi.audio.a.b();
    L50:
        if (r22.isNetworkAvailable() != true) goto L52;
        r23 = true;
        goto L53
    L57:
        if (r21 != null) goto L69;
        FLogger.a.w(TAG, "mainConversation is null");
        IObricNetworkService r24 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r24 != null) goto L61;
    L63:
        boolean r28 = false;
    L64:
        if (r28 == false) goto L67;
        return new com.obric.assistant.spi.audio.a.f();
    L67:
        return new com.obric.assistant.spi.audio.a.b();
    L61:
        if (r24.isNetworkAvailable() != true) goto L63;
        r28 = true;
        goto L64
    L69:
        if (r21.a.length() != 0) goto L71;
        boolean r31 = true;
    L72:
        if (r31 == false) goto L83;
        FLogger.a.w(TAG, "mainConversation.conversationId is null or empty");
        IObricNetworkService r32 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r32 != null) goto L76;
    L78:
        boolean r33 = false;
    L79:
        if (r33 == false) goto L82;
        return new com.obric.assistant.spi.audio.a.f();
    L82:
        return new com.obric.assistant.spi.audio.a.b();
    L76:
        if (r32.isNetworkAvailable() != true) goto L78;
        r33 = true;
        goto L79
    L83:
        SpeakerVoice r110 = r20.getVoiceType();
        if (r110 == null) goto L86;
        r10 = r110.getStyleId();
    L86:
        if (r10 != null) goto L88;
    L89:
        r18 = true;
    L90:
        if (r18 == false) goto L92;
    L96:
        t0.e(new b0());
        return new com.obric.assistant.spi.audio.a.e();
    L92:
        if (r20.getMuted() == true) goto L96;
        BuildersKt.launch$default(this.mainScope, null, null, new launchRealtimeCall.4(r1, this, r21, r15, r16, r12, r13, r20, null), 3, null);
        return new com.obric.assistant.spi.audio.a.d();
    L88:
        if (r10.length() != 0) goto L90;
    L71:
        r31 = false;
        goto L72
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        uga.d r34 = r5.getContext().get(uga.d.b);
        if (r34 == null) goto L17;
        String r35 = r34.a;
    L18:
        FLogger r36 = FLogger.a;
        r36.i(TAG, "launchRealtimeCall: callType=" + r25 + ", from=" + r26 + ", delayJumpMS=" + r27);
        VoiceCallServiceDelegate r111 = VoiceCallServiceDelegate.a;
        int r112 = WhenMappings.$EnumSwitchMapping$0[r25.ordinal()];
        if (r112 == 1) goto L27;
        if (r112 != 2) goto L22;
    L26:
        String r37 = "video_call";
    L28:
        Pair r38 = r111.A(r37);
        boolean r113 = ((Boolean) r38.component1()).booleanValue();
        String r39 = (String) r38.component2();
        if (r113 == false) goto L36;
        r36.w(TAG, "realtimeCallDowngradeHookClick: isDowngrade, downloadMessage=" + r39);
        if (AppHost.a.a().isAppBackground() == false) goto L34;
        r36.i(TAG, "launchRealtimeCall: isAppBackground, request degrade config");
        r111.w("obric");
    L34:
        return new com.obric.assistant.spi.audio.a.a(r39);
    L36:
        if (r25 == CallType.ScreenShare) goto L38;
    L41:
        r14 = 1;
        Deferred[] r40 = {BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new launchRealtimeCall.mainBotJob.1(DoraConfig.g(), null), 3, null), BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new launchRealtimeCall.mainConversationJob.1(null), 3, null)};
        r5.L$0 = r25;
        r5.L$1 = r26;
        r5.L$2 = r29;
        r5.L$3 = r35;
        r5.J$0 = r27;
        r5.label = 1;
        Object r41 = AwaitKt.b(r40, r5);
        if (r41 != r7) goto L44;
        return r7;
    L44:
        r13 = r26;
        r1 = r27;
        r16 = r29;
        r12 = r25;
        r15 = r35;
        r4 = r41;
        goto L45
    L38:
        if (ObricRealtimeCallServiceDelegate.b.g() == true) goto L41;
        r36.i(TAG, "ScreenShare not enable");
        return new com.obric.assistant.spi.audio.a.c();
    L22:
        if (r112 == 3) goto L26;
        throw new NoWhenBranchMatchedException();
    L27:
        r37 = "voice_call";
        goto L28
    L17:
        r35 = null;
    L7:
        r5 = new launchRealtimeCall.1(this, r30);
        goto L8
    }
}
