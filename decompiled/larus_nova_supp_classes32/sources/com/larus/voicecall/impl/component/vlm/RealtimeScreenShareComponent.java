package com.larus.voicecall.impl.component.vlm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.bean.RealtimeVlmLimitStatus;
import com.larus.voicecall.impl.degrade.RealtimeCallDegradeManager;
import com.larus.voicecall.impl.plugins.u2;
import com.larus.voicecall.impl.subtitle.RealtimeCallScreenShareLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeNoticeDialogHelper;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import hq9.z3;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0082\u0001\u0083\u0001\u0084\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020PH\u0016J\b\u0010R\u001a\u00020PH\u0002J\b\u0010S\u001a\u00020PH\u0002J\u0010\u0010T\u001a\u00020P2\u0006\u0010U\u001a\u00020VH\u0016J\u001a\u0010W\u001a\u00020P2\u0006\u0010X\u001a\u00020\t2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J,\u0010[\u001a\u00020P2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u000b2\b\b\u0002\u0010^\u001a\u00020=2\b\b\u0002\u0010_\u001a\u00020\tH\u0002J\b\u0010`\u001a\u00020PH\u0016J\"\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020\u000b2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0010\u0010f\u001a\u00020P2\u0006\u0010X\u001a\u00020gH\u0016J\u0010\u0010h\u001a\u00020P2\u0006\u0010i\u001a\u00020HH\u0016J\"\u0010j\u001a\u00020P2\u0006\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020m2\b\b\u0002\u0010n\u001a\u00020=H\u0002J\u0012\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010q\u001a\u00020\u000bH\u0016J\b\u0010r\u001a\u00020=H\u0002J\u0018\u0010s\u001a\u00020P2\u0006\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020\tH\u0016J\b\u0010v\u001a\u00020=H\u0016J(\u0010w\u001a\u00020P2\u0006\u0010k\u001a\u00020\t2\u0006\u0010x\u001a\u00020m2\u0006\u0010M\u001a\u00020=2\u0006\u0010n\u001a\u00020=H\u0016J\b\u0010y\u001a\u00020=H\u0016J \u0010w\u001a\u00020P2\u0006\u0010k\u001a\u00020\t2\u0006\u0010M\u001a\u00020=2\u0006\u0010n\u001a\u00020=H\u0016J\u0012\u0010z\u001a\u00020P2\b\u0010N\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010{\u001a\u00020P2\u0006\u0010|\u001a\u00020\tH\u0002J\b\u0010}\u001a\u00020PH\u0002J\u0010\u0010~\u001a\u00020P2\u0006\u0010\u007f\u001a\u00020\tH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020P2\u0006\u0010N\u001a\u00020\tH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020P2\b\b\u0002\u0010N\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0015\u001a\u0004\b:\u0010-R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0015\u001a\u0004\b>\u0010?R\u000e\u0010A\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010D\u001a\u0004\u0018\u00010C2\b\u0010B\u001a\u0004\u0018\u00010C@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010J\u001a\u00020I2\u0006\u0010B\u001a\u00020I@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeScreenShareAbility;", "Lcom/obric/assistant/ability/call/IObricRealtimeScreenShareAbility;", "<init>", "()V", "formatLogger", "Lcom/larus/utils/logger/FlowFormatLogger;", "currentCallIdForLog", NameKeys.UnloadStrategy_No_Strategy, "topPadding", NameKeys.UnloadStrategy_No_Strategy, "getTopPadding", "()I", "setTopPadding", "(I)V", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "Lkotlin/Lazy;", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "screenShareApi", "Lcom/larus/voicecall/impl/plugins/RealtimeScreenSharePluginProvider;", "getScreenShareApi", "()Lcom/larus/voicecall/impl/plugins/RealtimeScreenSharePluginProvider;", "screenShareApi$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "stateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "stateManager$delegate", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "viewStateManager", "getViewStateManager", "viewStateManager$delegate", "enableShareScreenToChildThread", NameKeys.UnloadStrategy_No_Strategy, "getEnableShareScreenToChildThread", "()Z", "enableShareScreenToChildThread$delegate", "needHalf", "value", "Lkotlinx/coroutines/Job;", "startScreenShareJob", "setStartScreenShareJob", "(Lkotlinx/coroutines/Job;)V", "curConnectState", "Lcom/larus/im/internal/audio/context/SessionState;", "Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent$ScreenShareState;", "curState", "setCurState", "(Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent$ScreenShareState;)V", "skipEnterView", "enterMethod", "onVContextReady", NameKeys.UnloadStrategy_No_Strategy, "onAttach", "onScreenShareStopped", "onScreenShareStaring", "onViewCreated", "view", "Landroid/view/View;", "otherEvent", "event", LynxAccessibilityModule.MSG_CONTENT, NameKeys.UnloadStrategy_No_Strategy, "mobVideoError", "deviceState", "deviceError", "isCheckoutModalError", "errorMsg", "onDestroy", "onActivityResult", "requestCode", "resultCode", LynxResourceModule.DATA_KEY, "Landroid/content/Intent;", "onReceiveEvent", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "onConnectionStateChanged", "state", "exitScreenShareMode", "endMethod", "exitChannel", "Lcom/larus/voicecall/impl/component/vlm/ExitScreenShareReason;", "needSwitchModal", "screenShareMenuItem", "Lcom/larus/bmhome/view/screenmenu/MenuItem;", "menuId", "shouldGrayScreenShareMenuItemByBottomRule", "handleScreenShareClick", "isScreenShareSelected", "clickMethod", "shouldHideScreenShareMenuItem", "tryExitScreenShareMode", "endChannel", "isScreenShareMode", "tryEnterScreenShareMode", "showToast", "txt", "enterScreenShareMode", "mobLeaveScreenShare", "leaveMethod", "mobClickScreenShare", "mobEnterScreenShare", "ScreenShareState", "ScreenShareEnterBlockReason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeScreenShareComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.vlm.a, naa.a {
    public static final /* synthetic */ int F = 0;
    public Job A;
    public jd9.c B;
    public ScreenShareState C;
    public boolean D;
    public String E;
    public final f2a.d n;
    public int o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent$ScreenShareEnterBlockReason;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "DOWNGRADE", "LIMITED", "SCENE_MODE", "NOT_CONNECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScreenShareEnterBlockReason extends Enum<ScreenShareEnterBlockReason> {
        public static final ScreenShareEnterBlockReason DOWNGRADE = null;
        public static final ScreenShareEnterBlockReason LIMITED = null;
        public static final ScreenShareEnterBlockReason NOT_CONNECTED = null;
        public static final ScreenShareEnterBlockReason SCENE_MODE = null;
        public static final /* synthetic */ ScreenShareEnterBlockReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScreenShareEnterBlockReason> getEntries() {
            return b;
        }

        static {
            ScreenShareEnterBlockReason r0 = new ScreenShareEnterBlockReason("DOWNGRADE", 0);
            DOWNGRADE = r0;
            ScreenShareEnterBlockReason r1 = new ScreenShareEnterBlockReason("LIMITED", 1);
            LIMITED = r1;
            ScreenShareEnterBlockReason r3 = new ScreenShareEnterBlockReason("SCENE_MODE", 2);
            SCENE_MODE = r3;
            ScreenShareEnterBlockReason r5 = new ScreenShareEnterBlockReason("NOT_CONNECTED", 3);
            NOT_CONNECTED = r5;
            ScreenShareEnterBlockReason[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static ScreenShareEnterBlockReason[] values() {
            return (ScreenShareEnterBlockReason[]) a.clone();
        }

        public static ScreenShareEnterBlockReason valueOf(String r1) {
            return (ScreenShareEnterBlockReason) r27.a.a(ScreenShareEnterBlockReason.class, r1);
        }

        public ScreenShareEnterBlockReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeScreenShareComponent$ScreenShareState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "CLOSE", "SHARING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScreenShareState extends Enum<ScreenShareState> {
        public static final ScreenShareState CLOSE = null;
        public static final ScreenShareState SHARING = null;
        public static final /* synthetic */ ScreenShareState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScreenShareState> getEntries() {
            return b;
        }

        static {
            ScreenShareState r0 = new ScreenShareState("CLOSE", 0);
            CLOSE = r0;
            ScreenShareState r1 = new ScreenShareState("SHARING", 1);
            SHARING = r1;
            ScreenShareState[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ScreenShareState[] values() {
            return (ScreenShareState[]) a.clone();
        }

        public static ScreenShareState valueOf(String r1) {
            return (ScreenShareState) r27.a.a(ScreenShareState.class, r1);
        }

        public ScreenShareState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements w3a.i {
        public final /* synthetic */ RealtimeScreenShareComponent a;

        public b(RealtimeScreenShareComponent r1) {
            this.a = r1;
        }

        @Override // w3a.i
        public final void a(w3a.h r9) {
            Intrinsics.checkNotNullParameter(r9, "event");
            if ((r9 instanceof w3a.j) == false) goto L8;
            RealtimeScreenShareComponent r0 = this.a;
            if (r0.C != ScreenShareState.SHARING) goto L18;
            int r1 = com.larus.voicecall.impl.util.x0.a;
            String r2 = r0.E;
            RealtimeCallParam r3 = r0.B3().a();
            e3a.a r4 = this.a.z3();
            boolean r5 = ((w3a.j) r9).a;
            RealtimeCallUtil.a.getClass();
            com.larus.voicecall.impl.util.x0.b(r2, r3, r4, r5, RealtimeCallUtil.z, "microphone");
            return;
        L18:
            return;
        L8:
            if ((r9 instanceof w3a.m) == false) goto L13;
            RealtimeScreenShareComponent r6 = this.a;
            if (r6.C != ScreenShareState.SHARING) goto L20;
            int r7 = com.larus.voicecall.impl.util.x0.a;
            com.larus.voicecall.impl.util.x0.b(r6.E, r6.B3().a(), this.a.z3(), ((h88.b) this.a.B3()).m, ((w3a.m) r9).a, "subtitle");
            return;
        L20:
            return;
        L13:
            if ((r9 instanceof w3a.n) == false) goto L22;
            RealtimeScreenShareComponent r10 = this.a;
            if (r10.C != ScreenShareState.SHARING) goto L23;
            int r8 = com.larus.voicecall.impl.util.x0.a;
            String r11 = r10.E;
            RealtimeCallParam r12 = r10.B3().a();
            e3a.a r13 = this.a.z3();
            boolean r14 = ((h88.b) this.a.B3()).m;
            RealtimeCallUtil.a.getClass();
            com.larus.voicecall.impl.util.x0.b(r11, r12, r13, r14, RealtimeCallUtil.z, "break");
            return;
        L23:
            return;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(s r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.vlm.RealtimeScreenShareComponent$onActivityResult$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.vlm.RealtimeScreenShareComponent$onActivityResult$9", f = "RealtimeScreenShareComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.im.service.audio.f1 $config;
        int label;
        final /* synthetic */ RealtimeScreenShareComponent this$0;

        public AnonymousClass9(RealtimeScreenShareComponent r1, com.larus.im.service.audio.f1 r2, Continuation<? super AnonymousClass9> r3) {
            this.this$0 = r1;
            this.$config = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass9(this.this$0, this.$config, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r4);
            RealtimeScreenShareComponent r5 = this.this$0;
            com.larus.im.service.audio.f1 r0 = this.$config;
            int r1 = RealtimeScreenShareComponent.F;
            u2 r6 = r5.C3();
            if (r6 == null) goto L7;
            r6.n(r0);
        L7:
            RealtimeScreenShareComponent r7 = this.this$0;
            Job r2 = r7.A;
            if (r2 == null) goto L10;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
        L10:
            r7.A = null;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final e3a.b B3() {
        return (e3a.b) this.w.getValue();
    }

    public final u2 C3() {
        return (u2) this.s.getValue();
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final boolean H80() {
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L7;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.C() == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // naa.a
    public final boolean mu() {
        if (this.C != ScreenShareState.SHARING) goto L5;
        return true;
    L5:
        return false;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.vlm.a.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, naa.a.class);
    }

    public final e3a.a z3() {
        return (e3a.a) this.v.getValue();
    }

    public RealtimeScreenShareComponent() {
        this.n = new f2a.d("ScreenShare", "FlowCallUI");
        this.p = LazyKt.lazy(new com.larus.voicecall.impl.component.vlm.c(this));
        this.q = LazyKt.lazy(new n(this));
        this.r = LazyKt.lazy(new y(this));
        this.s = LazyKt.lazy(new z(this));
        this.t = LazyKt.lazy(new a0(this));
        this.u = LazyKt.lazy(new b0(this));
        this.v = LazyKt.lazy(new c0(this));
        this.w = LazyKt.lazy(new d0(this));
        this.x = LazyKt.lazy(new e0(this));
        this.y = LazyKt.lazy(new f0());
        this.z = true;
        this.B = jd9.c.f.c;
        this.C = ScreenShareState.CLOSE;
        this.E = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void A0() {
        B3();
        RealtimeCallService r0 = (RealtimeCallService) this.r.getValue();
        C3();
        IRealtimeCallTracer r1 = (IRealtimeCallTracer) this.t.getValue();
        w3a.k r2 = (w3a.k) this.u.getValue();
    }

    public final String m3() {
        String r0 = z3().v1;
        if (StringsKt.isBlank(r0) == true) goto L5;
        return r0;
    L5:
        return ((h88.b) B3()).a;
    }

    public final void onDestroy() {
        u2 r0 = C3();
        if (r0 == null) goto L5;
        r0.Y0(null);
    L5:
        u2 r1 = C3();
        if (r1 == null) goto L8;
        r1.A1(null);
    L8:
        u2 r2 = C3();
        if (r2 == null) goto L11;
        r2.z0(null);
    L11:
        FLogger.a.i("RealtimeScreenShareComponent", "onDestroy curState=" + this.C + '.');
        if (this.C != ScreenShareState.SHARING) goto L27;
        final boolean r3 = AppHost.a.a().isAppBackground();
        final Ref.ObjectRef r4 = new Ref.ObjectRef();
        String r5 = B3().a().H;
        if (StringsKt.isBlank(r5) == false) goto L16;
        r5 = "end_call";
    L16:
        r4.element = r5;
        if (r3 == true) goto L19;
    L21:
        f2a.c r6 = this.n.b("ScreenShareExitFragmentDestroy");
        r6.c.d = "RealtimeScreenShareComponent.onDestroy";
        String r7 = m3();
        if ((!StringsKt.isBlank(r7)) == true) goto L25;
        r7 = null;
    L25:
        r6.c.b = CollectionsKt.listOfNotNull(r7);
        r6.f(new k(r4, r3));
        f2a.c.c(r6, null, 15);
        p3((String) r4.element, ExitScreenShareReason.FRAGMENT_DESTROY, true);
        return;
    L19:
        if (Intrinsics.areEqual(r5, "end_call") == false) goto L21;
        r4.element = "end_share_screen_out_of_app";
        goto L21
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final int Li() {
        return this.o;
    }

    public static Intent h3(MediaProjectionManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102100);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102100, "android/media/projection/MediaProjectionManager", "createScreenCaptureIntent", r18, r10, "android.content.Intent", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (Intent) r4.b;
    L21:
        return r18.createScreenCaptureIntent();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final void D9(com.larus.im.service.audio.z0.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof pf9.o0) == false) goto L12;
        ScreenShareState r0 = this.C;
        ScreenShareState r1 = ScreenShareState.SHARING;
        if (r0 == r1) goto L7;
    L9:
        if (r0 != r1) goto L14;
        StringBuilder r2 = new StringBuilder("event.isSuccess=");
        pf9.o0 r6 = (pf9.o0) r5;
        r2.append(r6.a);
        r2.append(" curState=");
        r2.append(this.C);
        D3(-1, -1, true, r2.toString());
        FLogger.a.e("RealtimeScreenShareComponent", "server enter screen share failed! event.isSuccess=" + r6.a + " curState=" + this.C);
        return;
    L14:
        return;
    L7:
        if (((pf9.o0) r5).a == false) goto L9;
        String r7 = this.E;
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        int r8 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.a(r4, B3().a(), z3());
        r4.put("enter_method", r7);
        r4.put("current_page", "chat");
        Unit r9 = Unit.INSTANCE;
        r3.reportEvent("enter_share_screen", r4);
        return;
    }

    public final void E3(ScreenShareState r11) {
        com.larus.av_call.view.c r3 = null;
        boolean r4 = false;
        if (r11 != ScreenShareState.SHARING) goto L41;
        if (this.o <= 0) goto L9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r0 == null) goto L9;
        int r6 = this.o;
        r0.setPadding(r0.getPaddingLeft(), r6, r0.getPaddingRight(), r0.getPaddingBottom());
    L9:
        ((h88.b) B3()).t = true;
        com.larus.voicecall.impl.component.vlm.b r1 = (com.larus.voicecall.impl.component.vlm.b) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.vlm.b.class);
        if (r1 == null) goto L12;
        r1.c30(ExitVideoModalReason.OPEN_SHARE_SCREEN, false);
    L12:
        com.larus.voicecall.impl.component.subtitle.a r2 = (com.larus.voicecall.impl.component.subtitle.a) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.subtitle.a.class);
        if (r2 == null) goto L15;
        r2.Zk("open_screen_share");
    L15:
        com.larus.voicecall.impl.component.bottom.b r5 = (com.larus.voicecall.impl.component.bottom.b) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.bottom.b.class);
        if (r5 == null) goto L37;
        VoiceCallBottomLayout r7 = r5.BT();
        if (r7 == null) goto L37;
        com.larus.av_call.view.c r8 = r7.a;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L23:
        View r9 = r3.h();
        if (r9 == null) goto L36;
        r9.setSelected(true);
        Application r10 = i88.e.a;
        ThemeType r12 = r7.i;
        boolean r13 = r7.m;
        h88.b r14 = r7.f;
        if (r14 != null) goto L28;
    L30:
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r12, "themeType");
        if (r4 == true) goto L35;
        if (r13 == true) goto L35;
        i88.e.o(r12);
    L35:
        r9.setBackgroundResource(2131242333);
        goto L36
    L28:
        if (r14.r != true) goto L30;
        r4 = true;
    L36:
        r7.u9(true);
        r7.c6();
        goto L37
    L22:
        r3 = r8;
    L37:
        ((IRealtimeCallTracer) this.t.getValue()).B(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_START_TIME, true);
        ((w3a.k) this.u.getValue()).a(w3a.e.a);
        w3a.k r15 = (w3a.k) this.x.getValue();
        if (r15 == null) goto L79;
        r15.d(new w3a.l(true));
    L79:
        this.C = r11;
        return;
    L41:
        if (this.o > 0) goto L43;
    L47:
        ((h88.b) B3()).t = false;
        ((IRealtimeCallTracer) this.t.getValue()).B(IRealtimeCallTracer.TotalTimeType.SCREEN_SHARE_START_TIME, false);
        if (this.D == true) goto L50;
        ((w3a.k) this.u.getValue()).a(w3a.b.a);
    L50:
        this.D = false;
        Lazy r16 = RealtimeNoticeDialogHelper.a;
        com.larus.voicecall.impl.component.bottom.b r17 = (com.larus.voicecall.impl.component.bottom.b) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.bottom.b.class);
        if (r17 == null) goto L68;
        VoiceCallBottomLayout r18 = r17.BT();
        if (r18 == null) goto L68;
        com.larus.av_call.view.c r19 = r18.a;
        if (r19 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L58:
        View r20 = r3.h();
        if (r20 == null) goto L67;
        r20.setSelected(false);
        Application r21 = i88.e.a;
        ThemeType r22 = r18.i;
        boolean r23 = r18.m;
        h88.b r24 = r18.f;
        if (r24 != null) goto L63;
    L65:
        boolean r25 = false;
    L66:
        i88.e.i(r20, r22, r23, r25);
        goto L67
    L63:
        if (r24.r != true) goto L65;
        r25 = true;
    L67:
        r18.u9(false);
        r18.c6();
        goto L68
    L57:
        r3 = r19;
    L68:
        w3a.k r26 = (w3a.k) this.x.getValue();
        if (r26 == null) goto L72;
        r26.d(new w3a.l(false));
    L72:
        if (((h88.a) z3()).k0 == false) goto L79;
        if (this.z == false) goto L78;
        w3a.k r27 = (w3a.k) this.x.getValue();
        if (r27 == null) goto L78;
        RealtimePageMode r28 = RealtimePageMode.HALF_SCREEN;
        int r29 = w3a.k.g;
        r27.b(r28, 0);
    L78:
        this.z = true;
        goto L79
    L43:
        if (((h88.a) z3()).k0 == false) goto L47;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r30 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r30 == null) goto L47;
        r30.setPadding(r30.getPaddingLeft(), 0, r30.getPaddingRight(), r30.getPaddingBottom());
        goto L47
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final com.larus.bmhome.view.screenmenu.l0 EY(int r44) {
        String r5 = Y2(2131900522);
        if (((h88.b) B3()).t == true) goto L29;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r2 == null) goto L7;
        Pair<Boolean, Boolean> r14 = com.larus.voicecall.impl.l.i;
        boolean r3 = com.larus.voicecall.impl.l.a.b(r2);
    L8:
        com.larus.voicecall.impl.component.scene.a r4 = (com.larus.voicecall.impl.component.scene.a) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.scene.a.class);
        if (r4 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r3 == true) goto L16;
    L26:
        boolean r7 = true;
    L27:
        if (r7 == false) goto L29;
        boolean r18 = true;
    L30:
        boolean r8 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L33;
        Integer r9 = -1;
    L35:
        return new com.larus.bmhome.view.screenmenu.l0(r44, 0, r5, null, null, null, null, null, null, false, false, null, 2131241806, null, false, r18, r9, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -200710, 127);
    L33:
        r9 = null;
        goto L35
    L16:
        if (((h88.b) B3()).d == false) goto L26;
        if (r6 == false) goto L21;
        if (((h88.a) z3()).k0 == false) goto L26;
    L21:
        if (((h88.b) B3()).k == 6) goto L26;
        if (((h88.b) B3()).k == 7) goto L26;
        r7 = false;
        goto L27
    L11:
        if (r4.oY() != true) goto L13;
        r6 = true;
        goto L14
    L7:
        r3 = true;
    L29:
        r18 = false;
        goto L30
    }

    public final void I6(jd9.c r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        this.B = r3;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.B() == true) goto L5;
        return;
    L5:
        if ((r3 instanceof jd9.c.d) == true) goto L7;
        return;
    L7:
        if (this.C != ScreenShareState.SHARING) goto L12;
        p3("lose_internet_connection", ExitScreenShareReason.SESSION_DISCONNECT, true);
        return;
    }

    @Override // com.larus.voicecall.impl.component.vlm.a, naa.a
    public final void P6(String r15) {
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        if (r15 != null) goto L5;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        this.E = r15;
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r2 = new JSONObject();
        int r3 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.a(r2, B3().a(), z3());
        r2.put("enter_method", r15);
        r2.put("current_page", "chat");
        Unit r16 = Unit.INSTANCE;
        r1.reportEvent("click_share_screen", r2);
        f2a.c r17 = this.n.b("ScreenShareEnterRequest");
        r17.c.d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r4 = m3();
        if ((!StringsKt.isBlank(r4)) == true) goto L9;
        r4 = null;
    L9:
        r17.c.b = CollectionsKt.listOfNotNull(r4);
        r17.f(new l(this));
        f2a.c.c(r17, null, 15);
        u2 r18 = C3();
        if (r18 == null) goto L12;
        RealtimeVlmLimitStatus r19 = r18.W1();
    L14:
        if (r19 == RealtimeVlmLimitStatus.DOWNGRADE) goto L16;
    L23:
        u2 r110 = C3();
        if (r110 == null) goto L26;
        RealtimeVlmLimitStatus r111 = r110.W1();
    L28:
        if (r111 == RealtimeVlmLimitStatus.NOT_LIMIT) goto L35;
        Lazy r112 = RealtimeNoticeDialogHelper.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        RealtimeNoticeDialogHelper.a(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        FLogger.a.i("RealtimeScreenShareComponent", "can not screen share, because of limited!");
        f2a.c r113 = this.n.c("ScreenShareEnterBlockedLimited");
        r113.c.d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r5 = m3();
        if ((!StringsKt.isBlank(r5)) == true) goto L33;
        r5 = null;
    L33:
        r113.c.b = CollectionsKt.listOfNotNull(r5);
        f2a.c.c(r113, null, 15);
        return;
    L35:
        com.larus.voicecall.impl.component.scene.a r114 = (com.larus.voicecall.impl.component.scene.a) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.scene.a.class);
        if (r114 != null) goto L38;
    L40:
        boolean r115 = false;
    L41:
        if (r115 == false) goto L52;
        String r10 = Y2(2131900523);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r9 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r9 == null) goto L45;
        t19.s.j(t19.s.a, r9, r10, 0, false, 24);
    L45:
        f2a.c r116 = this.n.c("ScreenShareEnterBlockedSceneMode");
        r116.c.d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r6 = m3();
        if ((!StringsKt.isBlank(r6)) == true) goto L49;
        r6 = null;
    L49:
        r116.c.b = CollectionsKt.listOfNotNull(r6);
        f2a.c.c(r116, null, 15);
        return;
    L52:
        if ((this.B instanceof jd9.c.a) == true) goto L96;
        FLogger.a.e("RealtimeScreenShareComponent", "curConnectState is " + this.B + ", so cannot connect");
        f2a.c r117 = this.n.c("ScreenShareEnterBlockedNotConnected");
        r117.c.d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r7 = m3();
        if ((!StringsKt.isBlank(r7)) == true) goto L57;
        r7 = null;
    L57:
        r117.c.b = CollectionsKt.listOfNotNull(r7);
        r117.f(new m(this));
        f2a.c.c(r117, null, 15);
        return;
    L96:
        Object r8 = AppHost.a.getApplication().getSystemService("media_projection");     // Catch: Throwable -> L89
        if ((r8 instanceof MediaProjectionManager) == false) goto L63;
        MediaProjectionManager r11 = (MediaProjectionManager) r8;     // Catch: Throwable -> L89
    L64:
        if (r11 == null) goto L83;
        z68.c r12 = z68.c.a;     // Catch: Throwable -> L89
        String r13 = this.E;     // Catch: Throwable -> L89
        r12.getClass();     // Catch: Throwable -> L89
        if (r13 == null) goto L69;
        r0 = r13;
    L69:
        String r14 = r0.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L89
        if (StringsKt.contains$default(r14, "resume", false, 2, null) == false) goto L73;
        String r20 = "auto_resume";
    L76:
        z68.c.i(r20);     // Catch: Throwable -> L89
        f2a.c r21 = this.n.b("ScreenSharePermissionRequestStart");     // Catch: Throwable -> L89
        r21.c.d = "RealtimeScreenShareComponent.enterScreenShareMode";     // Catch: Throwable -> L89
        String r22 = m3();     // Catch: Throwable -> L89
        if ((!StringsKt.isBlank(r22)) == true) goto L80;
        r22 = null;
    L80:
        r21.c.b = CollectionsKt.listOfNotNull(r22);     // Catch: Throwable -> L89
        f2a.c.c(r21, null, 15);     // Catch: Throwable -> L89
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L89
        FragmentActivity r23 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();     // Catch: Throwable -> L89
        if (r23 == null) goto L97;
        r23.startActivityForResult(h3(r11), 101);     // Catch: Throwable -> L89
        return;
    L97:
        return;
    L73:
        if (StringsKt.contains$default(r14, "retry", false, 2, null) == false) goto L75;
        r20 = "system_retry";
        goto L76
    L75:
        r20 = "user_click";
        goto L76
    L83:
        FLogger.a.e("RealtimeScreenShareComponent", "current os version too low，do not support screen share!");     // Catch: Throwable -> L89
        z68.c r24 = z68.c.a;     // Catch: Throwable -> L89
        RealtimeCallUtil.a.getClass();     // Catch: Throwable -> L89
        int r25 = RealtimeCallUtil.q().b();     // Catch: Throwable -> L89
        int r26 = RealtimeCallUtil.q().a();     // Catch: Throwable -> L89
        int r118 = RealtimeCallUtil.q().c();     // Catch: Throwable -> L89
        r24.getClass();     // Catch: Throwable -> L89
        z68.c.j(false, r25, r26, r118, new da9.e(0), "runtime_error", "projection_manager_null");     // Catch: Throwable -> L89
        f2a.c r27 = this.n.a("ScreenSharePermissionRequestNoProjectionManager");     // Catch: Throwable -> L89
        r27.c.d = "RealtimeScreenShareComponent.enterScreenShareMode";     // Catch: Throwable -> L89
        String r28 = m3();     // Catch: Throwable -> L89
        if ((!StringsKt.isBlank(r28)) == true) goto L87;
        r28 = null;
    L87:
        r27.c.b = CollectionsKt.listOfNotNull(r28);     // Catch: Throwable -> L89
        f2a.c.c(r27, null, 15);     // Catch: Throwable -> L89
        return;
    L63:
        r11 = null;
    L89:
        th = move-exception;
        FLogger.a.e("RealtimeScreenShareComponent", "enterScreenShareMode on err! msg=" + th);
        z68.c r29 = z68.c.a;
        RealtimeCallUtil.a.getClass();
        int r30 = RealtimeCallUtil.q().b();
        int r31 = RealtimeCallUtil.q().a();
        int r119 = RealtimeCallUtil.q().c();
        String r120 = th.getClass().getSimpleName();
        r29.getClass();
        z68.c.j(false, r30, r31, r119, new da9.e(0), "runtime_error", r120);
        f2a.c r32 = this.n.a("ScreenSharePermissionRequestException");
        r32.c.d = "RealtimeScreenShareComponent.enterScreenShareMode";
        String r121 = m3();
        if ((!StringsKt.isBlank(r121)) == true) goto L94;
        r121 = null;
    L94:
        r32.c.b = CollectionsKt.listOfNotNull(r121);
        r32.f(new w(th));
        f2a.c.c(r32, null, 15);
        EnsureManager.ensureNotReachHere(th, "enterScreenShareMode failed!");
        return;
    L38:
        if (r114.oY() != true) goto L40;
        r115 = true;
        goto L41
    L26:
        r111 = null;
        goto L28
    L16:
        if ((!StringsKt.isBlank(RealtimeNoticeDialogHelper.c)) == false) goto L23;
        Context r33 = getContext();
        Intrinsics.checkNotNullParameter(r33, "ctx");
        t19.s.j(t19.s.a, r33, RealtimeNoticeDialogHelper.c, null, false, 28);
        FLogger.a.e("RealtimeScreenShareComponent", "can not screen share, because of downgrade!");
        f2a.c r122 = this.n.c("ScreenShareEnterBlockedDowngrade");
        r122.c.d = "RealtimeScreenShareComponent.tryEnterScreenShareMode";
        String r34 = m3();
        if ((!StringsKt.isBlank(r34)) == true) goto L21;
        r34 = null;
    L21:
        r122.c.b = CollectionsKt.listOfNotNull(r34);
        f2a.c.c(r122, null, 15);
        return;
    L12:
        r19 = null;
        goto L14
    }

    @Override // naa.a
    public final void Wf(String r3) {
        Intrinsics.checkNotNullParameter(r3, "endMethod");
        if (this.C != ScreenShareState.SHARING) goto L6;
        this.D = false;
        p3(r3, ExitScreenShareReason.O_EXIT_SCREEN_SHARE, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.voicecall.impl.component.vlm.q] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.voicecall.impl.component.vlm.p] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.voicecall.impl.component.vlm.s] */
    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        g3a.a r5 = (g3a.a) this.p.getValue();
        if (r5 == null) goto L7;
        RealtimeCallScreenShareLayout r6 = r5.Df();
        if (r6 == null) goto L7;
        r6.setScreenShareExitClickListener(new o(this));
    L7:
        u2 r7 = C3();
        if (r7 == 0) goto L10;
        r7.z0(new p(this));
    L10:
        u2 r8 = C3();
        if (r8 == 0) goto L13;
        r8.Y0(new q(this));
    L13:
        u2 r9 = C3();
        if (r9 == null) goto L16;
        r9.A1(new r(this));
    L16:
        MutableLiveData r10 = b19.b.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r10.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this), new c(new s(this)));
        ((w3a.k) this.u.getValue()).c(new b(this));
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final void setTopPadding(int r1) {
        this.o = r1;
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final void Yh(boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "clickMethod");
        FLogger r0 = FLogger.a;
        r0.i("RealtimeScreenShareComponent", "click share screen btn. isSelected=" + r6 + ", room_id=" + ((h88.b) B3()).c);
        Keva r1 = RealtimeCallDegradeManager.a;
        if (RealtimeCallDegradeManager.h("video_call", "video_button", true) == false) goto L6;
        r0.e("RealtimeScreenShareComponent", "share screen is not available, because of downgrade!");
        return;
    L6:
        if (r6 == true) goto L8;
        P6(r7);
        return;
    L8:
        Intrinsics.checkNotNullParameter("voice_call", "scene");
        if (((Boolean) RealtimeCallDegradeManager.g("voice_call", true).getFirst()).booleanValue() == false) goto L12;
        r0.e("RealtimeScreenShareComponent", "voice call is not available, because of time limit downgrade!");
        return;
    L12:
        DW(r7, ExitScreenShareReason.USER_CLICK, false, true);
    }

    public final void z2(String r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r8, "event");
        if (Intrinsics.areEqual(r8, "OTHER_EVENT_RTC_END_SCREEN_SHARE") == false) goto L28;
        FLogger r1 = FLogger.a;
        r1.i("RealtimeScreenShareComponent", "otherEvent event=".concat(r8));
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        boolean r11 = z2.a.V0();     // Catch: Throwable -> L19
        if (this.C != ScreenShareState.SHARING) goto L17;
        if (r11 == false) goto L17;
        if ((r9 instanceof String) == false) goto L12;
        String r12 = (String) r9;     // Catch: Throwable -> L19
    L14:
        if (r12 != null) goto L16;
        r12 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        JSONObject r4 = new JSONObject(r12);     // Catch: Throwable -> L19
        D3(r4.optInt("device_state", -1), r4.optInt("device_error", -1), false, NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L19
        r1.e("RealtimeScreenShareComponent", "exit screen share for error. content=" + r9);     // Catch: Throwable -> L19
        DW("on_error_from_rtc", ExitScreenShareReason.EXIT_FOR_RTC_ERROR, false, true);     // Catch: Throwable -> L19
        goto L17
    L12:
        r12 = null;
    L17:
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L29;
        FLogger.a.e("RealtimeScreenShareComponent", "otherEvent  OTHER_EVENT_RTC_END_SCREEN_SHARE error. error=" + r14 + " , content=" + r9);
        return;
    L29:
        return;
    L19:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public final void onActivityResult(final int r17, final int r18, Intent r19) {
        if (r19 != null) goto L10;
        FLogger.a.e("RealtimeScreenShareComponent", "onActivityResult on err. data is empty!");
        f2a.c r6 = this.n.a("ScreenSharePermissionResultMissingData");
        r6.c.d = "RealtimeScreenShareComponent.onActivityResult";
        String r7 = m3();
        if ((true ^ StringsKt.isBlank(r7)) == true) goto L8;
        r7 = null;
    L8:
        r6.c.b = CollectionsKt.listOfNotNull(r7);
        r6.f(new d(r17, r18));
        f2a.c.c(r6, null, 15);
        return;
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r8 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r8 == null) goto L13;
        String r9 = r8.getClass().getCanonicalName();
    L14:
        if (r9 != null) goto L16;
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        String r14 = r9;
        if (StringsKt.isBlank(r14) == false) goto L25;
        FLogger.a.e("RealtimeScreenShareComponent", "activity name is empty");
        f2a.c r10 = this.n.a("ScreenSharePermissionResultActivityNameEmpty");
        r10.c.d = "RealtimeScreenShareComponent.onActivityResult";
        String r11 = m3();
        if ((true ^ StringsKt.isBlank(r11)) == true) goto L22;
        r11 = null;
    L22:
        r10.c.b = CollectionsKt.listOfNotNull(r11);
        r10.f(new e(r17, r18));
        f2a.c.c(r10, null, 15);
        return;
    L25:
        if (r17 == 101) goto L27;
    L61:
        z68.c.a.getClass();
        Object r12 = z68.c.b;
        monitor-enter(r12);
        z68.b r13 = z68.c.c;     // Catch: Throwable -> L80
        monitor-exit(r12);
        if (r13 == null) goto L71;
        da9.e r15 = r13.c;
        da9.c r16 = r15.e;
        da9.c r110 = r13.c.e;
        z68.c.g("flow_screen_share_start_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", "fail"), TuplesKt.to("reason", "permission_denied"), TuplesKt.to("error_code", "permission_denied"), TuplesKt.to("start_cost_ms", Integer.valueOf((int) (SystemClock.elapsedRealtime() - r13.a))), TuplesKt.to("profile", z68.c.e(r16.b, r16.c, r15.b)), TuplesKt.to("resolution", z68.c.k(r110.b, r110.c)), TuplesKt.to("target_fps", Integer.valueOf(r13.c.b))}));
        monitor-enter(r12);
        z68.c.c = null;     // Catch: Throwable -> L77
        z68.c.d = null;     // Catch: Throwable -> L77
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r12);
    L77:
        th = move-exception;
        throw th;
    L71:
        f2a.c r21 = this.n.c("ScreenSharePermissionResultDeniedOrOther");
        r21.c.d = "RealtimeScreenShareComponent.onActivityResult";
        String r22 = m3();
        if ((true ^ StringsKt.isBlank(r22)) == true) goto L75;
        r22 = null;
    L75:
        r21.c.b = CollectionsKt.listOfNotNull(r22);
        r21.f(new i(r17, r18));
        f2a.c.c(r21, null, 15);
        return;
    L80:
        th = move-exception;
        throw th;
    L27:
        if (r18 != (-1)) goto L61;
        f2a.c r23 = this.n.b("ScreenSharePermissionResultGranted");
        r23.c.d = "RealtimeScreenShareComponent.onActivityResult";
        String r24 = m3();
        if ((!StringsKt.isBlank(r24)) == true) goto L32;
        r24 = null;
    L32:
        r23.c.b = CollectionsKt.listOfNotNull(r24);
        r23.f(new f(r17, r18));
        f2a.c.c(r23, null, 15);
        E3(ScreenShareState.SHARING);
        boolean r0 = com.larus.im.a.a().c().shareScreenUseSoftAec();
        z2 r2 = z2.a;
        boolean r25 = r2.shareScreenEnableDualAec();
        FLogger r111 = FLogger.a;
        r111.i("RealtimeScreenShareComponent", "onActivityResult shareScreenUseSoftAec=" + r0 + " shareScreenEnableDualAec=" + r25);
        z3 r3 = r2.v3();
        if (r25 == false) goto L36;
        boolean r1 = r3.c();
    L40:
        if (r1 == false) goto L44;
        com.larus.voicecall.impl.component.core.a r4 = (com.larus.voicecall.impl.component.core.a) this.q.getValue();
        if (r4 == null) goto L44;
        r4.UQ();
    L44:
        RealtimeCallUtil.a.getClass();
        final com.larus.im.service.audio.f1 r5 = new com.larus.im.service.audio.f1(r14, Y2(2131900518), r19, RealtimeCallUtil.q().c(), RealtimeCallUtil.q().b(), RealtimeCallUtil.q().a(), r1);
        r111.i("RealtimeScreenShareComponent", "startScreenShare encoderFrameRate=" + RealtimeCallUtil.q().c() + " activityCanonicalName=" + r14 + " needCheckToCallMode=" + r1 + " encoderWidth=" + RealtimeCallUtil.q().b() + " encoderHeight=" + RealtimeCallUtil.q().a());
        f2a.c r26 = this.n.b("ScreenShareStartInvoke");
        r26.c.d = "RealtimeScreenShareComponent.onActivityResult";
        String r27 = m3();
        if ((!StringsKt.isBlank(r27)) == true) goto L48;
        r27 = null;
    L48:
        r26.c.b = CollectionsKt.listOfNotNull(r27);
        r26.f(new g(r5, this));
        f2a.c.c(r26, null, 15);
        if (((Boolean) this.y.getValue()).booleanValue() == false) goto L54;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Job r28 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), Dispatchers.getIO(), null, new AnonymousClass9(this, r5, null), 2, null);
        Job r29 = this.A;
        if (r29 == null) goto L53;
        Job.DefaultImpls.cancel$default(r29, null, 1, null);
    L53:
        this.A = r28;
    L57:
        if (r1 == false) goto L88;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r30 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r30 == null) goto L89;
        r30.postDelayed(new h(this), 500);
        return;
    L89:
        return;
    L88:
        return;
    L54:
        u2 r31 = C3();
        if (r31 == null) goto L57;
        r31.n(r5);
        goto L57
    L36:
        if (r3.c() == false) goto L39;
        if (r0 == true) goto L39;
        r1 = true;
    L39:
        r1 = false;
        goto L40
    L13:
        r9 = null;
        goto L14
    }

    public final void p3(final String r6, final ExitScreenShareReason r7, final boolean r8) {
        if (r7 == ExitScreenShareReason.ENTER_VIDEO_CALL) goto L5;
    L7:
        FLogger.a.i("RealtimeScreenShareComponent", "exitScreenShareMode  endMethod=" + r6);
        f2a.c r0 = this.n.b("ScreenShareStopInvoke");
        r0.c.d = "RealtimeScreenShareComponent.exitScreenShareMode";
        String r1 = m3();
        if ((!StringsKt.isBlank(r1)) == true) goto L11;
        r1 = null;
    L11:
        r0.c.b = CollectionsKt.listOfNotNull(r1);
        r0.f(new j(r6, r7, r8));
        f2a.c.c(r0, null, 15);
        ((IRealtimeCallTracer) this.t.getValue()).e0(this.E, r6, B3().a(), z3());
        com.larus.im.service.audio.e1 r9 = new com.larus.im.service.audio.e1(z2.a.v3().c());
        Job r10 = this.A;
        if (r10 == null) goto L14;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L14:
        this.A = null;
        u2 r11 = C3();
        if (r11 == null) goto L17;
        r11.n0(r8, r9);
    L17:
        E3(ScreenShareState.CLOSE);
        return;
    L5:
        if (((h88.a) z3()).k0 == false) goto L7;
        this.z = false;
        FLogger.a.i("RealtimeScreenShareComponent", "exitScreenShareMode  endMethod=" + r6 + " exitChannel=" + r7);
        goto L7
    }

    public final void D3(int r4, int r5, boolean r6, String r7) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("is_checkout_modal_error", r6);
        r1.put("error_msg", r7);
        r1.put("device_state", r4);
        r1.put("device_error", r5);
        r1.put("modal_type", "screen_share");
        int r8 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.a(r1, B3().a(), z3());
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("realtime_vlm_call_error", r1);
    }

    @Override // com.larus.voicecall.impl.component.vlm.a
    public final void DW(String r3, ExitScreenShareReason r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "endMethod");
        Intrinsics.checkNotNullParameter(r4, "endChannel");
        if (this.C != ScreenShareState.SHARING) goto L6;
        this.D = r5;
        p3(r3, r4, r6);
        return;
    }
}
