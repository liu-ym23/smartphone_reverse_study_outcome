package com.larus.voicecall.impl.component.denoise;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.bmhome.view.screenmenu.n1;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.z0;
import com.larus.platform.service.AccountService;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.component.dialog.RealtimeDialogTriggerTime;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000Ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n*\u0001Y\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u0002:\u0002\u008c\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010[\u001a\u00020TH\u0016J\b\u0010\\\u001a\u00020TH\u0016J\b\u0010]\u001a\u00020TH\u0002J(\u0010^\u001a\u00020T2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020`2\u0006\u0010c\u001a\u00020\nH\u0016J\b\u0010d\u001a\u00020\u001fH\u0002J\b\u0010e\u001a\u00020TH\u0002J\u0010\u0010f\u001a\u00020T2\u0006\u0010g\u001a\u00020hH\u0016J\b\u0010i\u001a\u00020TH\u0002J\u0010\u0010j\u001a\u00020T2\u0006\u0010k\u001a\u00020\u0006H\u0002J$\u0010l\u001a\u00020T2\u0006\u0010m\u001a\u00020\u001f2\u0006\u0010n\u001a\u00020\u001f2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010p\u001a\u00020T2\u0006\u0010m\u001a\u00020\u001f2\u0006\u0010n\u001a\u00020\u001f2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u0010r\u001a\u00020s*\u00020sH\u0002J\b\u0010t\u001a\u00020TH\u0002J\u0016\u0010u\u001a\u00020v2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020T0xH\u0016J\b\u0010y\u001a\u00020TH\u0016J\b\u0010z\u001a\u00020TH\u0016J\u0018\u0010{\u001a\u00020T2\u0006\u0010|\u001a\u00020\u001f2\u0006\u0010k\u001a\u00020\u0006H\u0016J\u0010\u0010}\u001a\u00020T2\u0006\u0010~\u001a\u00020\u0006H\u0002J\u0019\u0010\u007f\u001a\u00020T2\u0006\u0010n\u001a\u00020\u001f2\u0007\u0010\u0080\u0001\u001a\u00020\u001fH\u0002J4\u0010\u0081\u0001\u001a\u00020T2\u0014\u0010\u0082\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0004\u0012\u00020T0R2\u0013\u0010\u0084\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T0RH\u0002J\t\u0010\u0085\u0001\u001a\u00020TH\u0002J\u0014\u0010\u0086\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u0087\u0001\u001a\u00020\nH\u0002J\u0018\u0010\u0088\u0001\u001a\u00020T*\u00020\u00062\t\b\u0002\u0010\u0089\u0001\u001a\u00020sH\u0002J\u0011\u0010\u008a\u0001\u001a\u00020T2\u0006\u0010|\u001a\u00020\u001fH\u0002J\t\u0010\u008b\u0001\u001a\u00020TH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010%8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\"R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010/R\u0016\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020908X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0010\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bH\u0010IR\u0010\u0010K\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010L\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0010\u001a\u0004\bN\u0010OR\u001a\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T0RX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010U\u001a\u00020S2\u0006\u0010\u001e\u001a\u00020S@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bV\u0010WR\u0010\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z¨\u0006\u008d\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/RealtimeDenoiseComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/denoise/IRealtimeDenoiseAbility;", "<init>", "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "getTAG", "()Ljava/lang/String;", "currentUIState", NameKeys.UnloadStrategy_No_Strategy, "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "Lkotlin/Lazy;", "reportJob", "Lkotlinx/coroutines/Job;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "interpretAbility", "Lcom/larus/voicecall/impl/interpret/IRealtimeInterpretAbility;", "getInterpretAbility", "()Lcom/larus/voicecall/impl/interpret/IRealtimeInterpretAbility;", "interpretAbility$delegate", "value", NameKeys.UnloadStrategy_No_Strategy, "hasColdShowAuthDialogInKeva", "getHasColdShowAuthDialogInKeva", "()Z", "setHasColdShowAuthDialogInKeva", "(Z)V", "Lcom/larus/voicecall/impl/component/denoise/DenoiseStatusRes;", "lastVoiceFeatureStatusInKeva", "getLastVoiceFeatureStatusInKeva", "()Lcom/larus/voicecall/impl/component/denoise/DenoiseStatusRes;", "setLastVoiceFeatureStatusInKeva", "(Lcom/larus/voicecall/impl/component/denoise/DenoiseStatusRes;)V", "isDenoiseSwitchClickAble", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "denoisePlugin", "Lcom/larus/voicecall/impl/plugins/IRealtimeDenoiseProvider;", "getDenoisePlugin", "()Lcom/larus/voicecall/impl/plugins/IRealtimeDenoiseProvider;", "hasManualCloseDenoise", "hasSNRNoticed", "asrInfoMap", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "balloon", "Lcom/skydoves/balloon/Balloon;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "firstEnterJob", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "closeDenoiseGuideStateTransfer", "Lkotlin/Function1;", "Lcom/larus/voicecall/impl/component/denoise/snr/RealtimeBaseDenoiseSNRState;", NameKeys.UnloadStrategy_No_Strategy, "closeDenoiseGuideState", "setCloseDenoiseGuideState", "(Lcom/larus/voicecall/impl/component/denoise/snr/RealtimeBaseDenoiseSNRState;)V", "dialogExecutor", "com/larus/voicecall/impl/component/denoise/RealtimeDenoiseComponent$dialogExecutor$1", "Lcom/larus/voicecall/impl/component/denoise/RealtimeDenoiseComponent$dialogExecutor$1;", "onAttach", "onVContextReady", "triggerUpdateAsrInfo", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "canCheckSnr", "storeSNRNoticeShow", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "showDenoiseTips", "showDeNoiseAuthDialog", "source", "mobNoiseFreeSettingResult", "success", "toOpen", "errorMsg", "mobVoiceFeatureAuthResult", "errMsg", "appendBaseParam", "Lorg/json/JSONObject;", "showOpenDenoiseToast", "getDenoiseSwitch", "Lcom/larus/bmhome/view/screenmenu/SwitchMenuV2;", "onSwitchClicked", "Lkotlin/Function0;", "onMenuItemClicked", "onDestroy", "onDenoiseSwitchChanged", "isOpen", "mobNoiseFreeResultToastShow", "toastType", "mobClickNoiseFreeSwitch", "fromOpen", "startAuthAndOpenRequest", "onSuccess", "Lcom/larus/voicecall/impl/component/denoise/DenoiseReportRes;", "onFail", "updateDenoiseGuideStatus", "formatDouBaoString", "target", "mob", "jsonObject", "tryStartChangeDenoiseSwitchRequest", "onFragmentViewDestroyed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeDenoiseComponent extends RealtimeComponent implements g {
    public static final /* synthetic */ int D = 0;
    public final Lazy A;
    public com.larus.voicecall.impl.component.denoise.snr.a B;
    public final RealtimeDenoiseComponent$dialogExecutor$1 C;
    public int n;
    public final Lazy o;
    public Job p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public boolean t;
    public Map<String, ? extends Object> u;
    public Balloon v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public Job z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DenoiseStatusRes.values().length];
            r0[DenoiseStatusRes.FEATURE_ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DenoiseStatusRes.LEARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DenoiseStatusRes.FEATURE_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements w3a.i {
        public final /* synthetic */ RealtimeDenoiseComponent a;

        public c(RealtimeDenoiseComponent r1) {
            this.a = r1;
        }

        @Override // w3a.i
        public final void a(w3a.h r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if ((r2 instanceof w3a.j) == false) goto L6;
            RealtimeDenoiseComponent r3 = this.a;
            int r0 = RealtimeDenoiseComponent.D;
            r3.c4();
            return;
        }
    }

    static {
    }

    public final void A2() {
        RealtimeCallUtil.a.getClass();
        W3(RealtimeCallUtil.t);
    }

    public final e3a.b C3() {
        return (e3a.b) this.x.getValue();
    }

    public final String D3() {
        return "DenoiseComponent_" + C3().a().d;
    }

    @Override // com.larus.voicecall.impl.component.denoise.g
    public final void YY() {
        u3a.a r0 = (u3a.a) this.r.getValue();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), getContext().getResources().getString(2131906751), null, false, 28);
        return;
    L11:
        Z3();
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.G() == false) goto L18;
        if (RealtimeCallUtil.t != DenoiseStatusRes.LEARNING) goto L18;
        t19.s.j(t19.s.a, getContext(), p3(2131911046), null, false, 28);
        G3("still_study");
        E3(false, false);
        return;
    L18:
        if (RealtimeCallUtil.G() == false) goto L27;
        int r3 = b.a[RealtimeCallUtil.t.ordinal()];
        if (r3 != 1) goto L22;
        r1 = false;
    L26:
        V3(r1, "onMenuItemClicked");
        return;
    L22:
        if (r3 == 3) goto L26;
        FLogger.a.e(D3(), "onMenuItemClicked, current status is " + RealtimeCallUtil.t);
        return;
    L27:
        X3("item_click");
        return;
    L5:
        if (r0.YM() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void c4() {
        com.larus.voicecall.impl.component.denoise.snr.a r0 = this.B;
        if (this.n != 3) goto L5;
        boolean r1 = true;
    L6:
        boolean r2 = ((h88.b) C3()).m;
        RealtimeCallUtil.a.getClass();
        r0.e(r1, r2, RealtimeCallUtil.t());
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroy() {
        Job r0 = this.z;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.z = null;
        Balloon r1 = this.v;
        if (r1 == null) goto L8;
        r1.h();
    L8:
        this.B.d();
        Job r2 = this.p;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        this.p = null;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, g.class);
    }

    public final Keva z3() {
        return (Keva) this.q.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.larus.voicecall.impl.component.denoise.RealtimeDenoiseComponent$dialogExecutor$1] */
    public RealtimeDenoiseComponent() {
        this.n = -1;
        this.o = LazyKt.lazy(new h(this));
        this.q = LazyKt.lazy(new s());
        this.r = LazyKt.lazy(new w(this));
        this.s = LazyKt.lazy(new x(this));
        this.u = MapsKt.emptyMap();
        this.w = LazyKt.lazy(new y(this));
        this.x = LazyKt.lazy(new z(this));
        this.y = LazyKt.lazy(new a0(this));
        this.A = LazyKt.lazy(new b0(this));
        this.B = new com.larus.voicecall.impl.component.denoise.snr.c(new c0(this));
        this.C = new RealtimeDenoiseComponent$dialogExecutor$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.larus.voicecall.impl.component.denoise.j] */
    public final void A0() {
        Z3();
        com.larus.voicecall.impl.plugins.t r0 = (com.larus.voicecall.impl.plugins.t) LLMCallController.y(((RealtimeCallService) this.s.getValue()).u, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.t.class));
        if (r0 == 0) goto L5;
        r0.F0(new j(this));
    L5:
        RealtimeDialogTriggerTime r1 = RealtimeDialogTriggerTime.ON_COMMON_AUDIO_CONFIG;
        RealtimeDenoiseComponent$dialogExecutor$1 r2 = this.C;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r1, "triggerTime");
        Intrinsics.checkNotNullParameter(r2, "executor");
        h3a.c r4 = (h3a.c) s1a.d.a(this).a(h3a.c.class);
        if (r4 == null) goto L13;
        Intrinsics.checkNotNullParameter(r1, "triggerTime");
        Intrinsics.checkNotNullParameter(r2, "executor");
        if (((Map) r4.a.getValue()).containsKey(r1) == false) goto L12;
        List r3 = (List) ((Map) r4.a.getValue()).get(r1);
        if (r3 == null) goto L13;
        r3.add(r2);
        goto L13
    L12:
        ((Map) r4.a.getValue()).put(r1, CollectionsKt.mutableListOf(new h3a.a[]{r2}));
    L13:
        ((w3a.k) s1a.d.a(this).f(w3a.k.class)).c(new c(this));
    }

    public final DenoiseStatusRes B3() {
        Keva r0 = z3();
        String r1 = "last_voice_feature_status_".concat(AccountService.a.getSecUserId());
        DenoiseStatusRes r2 = DenoiseStatusRes.UNKNOWN;
        int r3 = r0.getInt(r1, r2.getValue());
        if (r3 != 0) goto L5;
        return r2;
    L5:
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L16;
        return r2;
    L16:
        return DenoiseStatusRes.FEATURE_DISABLED;
    L17:
        return DenoiseStatusRes.FEATURE_ENABLED;
    L14:
        return DenoiseStatusRes.LEARNING;
    }

    public final void Z3() {
        boolean r3 = false;
        if (m3() == false) goto L13;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.t() == true) goto L13;
        if (this.t == true) goto L13;
        if (this.n != 3) goto L13;
        if (RealtimeCallUtil.t == DenoiseStatusRes.LEARNING) goto L13;
        boolean r0 = true;
    L14:
        Pair[] r4 = new Pair[5];
        if (u3a.f.e() == false) goto L17;
        boolean r5 = false;
    L18:
        r4[0] = TuplesKt.to("is_denoise_feature_enable", Boolean.valueOf(r5));
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.t != DenoiseStatusRes.FEATURE_ENABLED) goto L21;
    L22:
        r3 = true;
    L23:
        r4[1] = TuplesKt.to("is_feat_learning_done", Boolean.valueOf(r3));
        r4[2] = TuplesKt.to("is_feat_learning_enable", Boolean.valueOf(RealtimeCallUtil.G()));
        r4[3] = TuplesKt.to("check_audio_snr", Boolean.valueOf(r0));
        r4[4] = TuplesKt.to("too_long_sv", Boolean.valueOf(this.B instanceof com.larus.voicecall.impl.component.denoise.snr.d));
        Map<String, ? extends Object> r1 = MapsKt.mutableMapOf(r4);
        if (Intrinsics.areEqual(r1.toString(), this.u.toString()) == true) goto L26;
        FLogger r2 = FLogger.a;
        r2.i(D3(), "triggerUpdateAsrInfo asr_info change. new=" + r1 + " old=" + this.u + " closeDenoiseGuideState=" + this.B.a() + ' ');
        r2.i(D3(), "triggerUpdateAsrInfo snrCheck=" + r0 + "  hasSNRNoticed=false canCheckSnr=" + m3() + " hasManualCloseDenoise=" + this.t + " currentUIState=" + this.n + " denoiseStatus=" + RealtimeCallUtil.t);
    L26:
        this.u = r1;
        return;
    L21:
        if (RealtimeCallUtil.t != DenoiseStatusRes.FEATURE_DISABLED) goto L23;
    L17:
        RealtimeCallUtil.a.getClass();
        r5 = RealtimeCallUtil.t();
    L13:
        r0 = false;
        goto L14
    }

    public final boolean m3() {
        long r0 = System.currentTimeMillis();
        Keva r2 = z3();
        AccountService r3 = AccountService.a;
        if ((r0 - r2.getLong("KEVA_KEY_SNR_LAST_DATE_".concat(r3.getSecUserId()), 0)) <= 86400000) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L10;
        z3().storeInt("KEVA_KEY_SNR_TIMES_".concat(r3.getSecUserId()), 0);
    L10:
        if (z3().getInt("KEVA_KEY_SNR_TIMES_".concat(r3.getSecUserId()), 0) < 2) goto L14;
        return false;
    L14:
        return true;
    L5:
        r1 = false;
        goto L7
    }

    public static String p3(int r5) {
        int r0 = j0.a;
        String r6 = j0.d(r5);
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, r6, Arrays.copyOf(new Object[]{j0.d(2131907351)}, 1));
    }

    public final void D9(z0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r10, "event");
        if ((r10 instanceof pf9.o) == true) goto L90;
        boolean r1 = true;
        String r3 = null;
        if ((r10 instanceof pf9.l) == false) goto L62;
        pf9.l r11 = (pf9.l) r10;
        int r0 = r11.a;
        VoiceFeatureAuthStatus[] r4 = VoiceFeatureAuthStatus.values();
        int r5 = r4.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L15;
        VoiceFeatureAuthStatus r7 = r4[r6];
        if (r7.getValue() != r0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L16;
        r6 = r6 + 1;
    L16:
        if (r7 != null) goto L18;
        r7 = VoiceFeatureAuthStatus.UNAUTHORIZED;
    L18:
        int r2 = r11.b;
        if (r2 == 0) goto L29;
        if (r2 != 1) goto L22;
        DenoiseStatusRes r9 = DenoiseStatusRes.LEARNING;
    L30:
        FLogger r12 = FLogger.a;
        r12.i(D3(), "onReceiveEvent, FlowLLMAudioConfigEvent voiceFeatureAuthor_value=" + r11.a + "  denoiseStatus_value=" + r11.b + " authStatus=" + r7.getDesc() + " denoiseStatus=" + r9.getDesc());
        RealtimeCallUtil.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        RealtimeCallUtil.t = r9;
        VoiceFeatureAuthStatus r13 = VoiceFeatureAuthStatus.AUTHORIZED;
        if (r7 != r13) goto L33;
        boolean r14 = true;
    L35:
        if (r14 == RealtimeCallUtil.G()) goto L41;
        SettingRepoDelegate r15 = SettingRepoDelegate.b;
        if (r7 != r13) goto L39;
        boolean r16 = true;
    L40:
        r15.k(r16);
        goto L41
    L39:
        r16 = false;
    L41:
        if (r14 == true) goto L43;
    L45:
        r1 = false;
    L46:
        JSONObject r17 = new JSONObject();
        if (r1 == false) goto L49;
        String r18 = "1";
    L50:
        r17.put("is_noise_free", r18);
        Unit r19 = Unit.INSTANCE;
        com.larus.platform.service.o r20 = com.larus.platform.service.o.a;
        h3(r17);
        r20.reportEvent("call_noise_free_result", r17);
        if (B3() != DenoiseStatusRes.LEARNING) goto L56;
        if (r14 == false) goto L56;
        if (r9 != DenoiseStatusRes.FEATURE_ENABLED) goto L56;
        t19.s r110 = t19.s.a;
        Context r21 = getContext();
        r110.getClass();
        t19.s.o(r21, 2131911048, false);
        r12.i(D3(), "notice denoise enable.on FlowLLMAudioConfigEvent");
    L60:
        W3(r9);
        return;
    L56:
        String r22 = D3();
        StringBuilder r23 = new StringBuilder("do not show denoise enable toast. lastVoiceFeatureStatusInKeva=");
        DenoiseStatusRes r24 = B3();
        if (r24 == null) goto L59;
        r3 = r24.getDesc();
    L59:
        r23.append(r3);
        r23.append("  isAuthorize=");
        r23.append(r14);
        r23.append(" denoiseStatus=");
        r23.append(r9.getDesc());
        r12.w(r22, r23.toString());
        goto L60
    L49:
        r18 = "0";
        goto L50
    L43:
        if (r9 != DenoiseStatusRes.FEATURE_ENABLED) goto L45;
    L33:
        r14 = false;
        goto L35
    L22:
        if (r2 != 2) goto L24;
        r9 = DenoiseStatusRes.FEATURE_ENABLED;
        goto L30
    L24:
        if (r2 == 3) goto L26;
        r9 = DenoiseStatusRes.UNKNOWN;
        goto L30
    L26:
        r9 = DenoiseStatusRes.FEATURE_DISABLED;
        goto L30
    L29:
        r9 = DenoiseStatusRes.UNKNOWN;
        goto L30
    L11:
        r8 = false;
        goto L12
    L15:
        r7 = null;
        goto L16
    L62:
        if ((r10 instanceof pf9.c0) == false) goto L74;
        pf9.a r111 = ((pf9.c0) r10).a;
        if (r111 == null) goto L66;
        r3 = r111.a;
    L66:
        if (r3 != null) goto L68;
    L71:
        if (r1 == false) goto L92;
        this.B.c();
        return;
    L92:
        return;
    L68:
        if (r3.length() == 0) goto L71;
        r1 = false;
        goto L71
    L74:
        if ((r10 instanceof pf9.k) == false) goto L81;
        this.B.b();
        FLogger.a.i(D3(), "onReceiveEvent, FlowLLMAsrRejectEvent");
        com.larus.voicecall.impl.component.bottom.b r112 = (com.larus.voicecall.impl.component.bottom.b) this.A.getValue();
        if (r112 == null) goto L94;
        VoiceCallBottomLayout r113 = r112.BT();
        if (r113 == null) goto L95;
        r113.post(new o(this));
        return;
    L95:
        return;
    L94:
        return;
    L81:
        if ((r10 instanceof pf9.j) == false) goto L97;
        FLogger r114 = FLogger.a;
        String r25 = D3();
        StringBuilder r26 = new StringBuilder("onReceiveEvent, FlowLLMAsrNoiseInfoEvent isAdded=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r26.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded());
        r114.i(r25, r26.toString());
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L98;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r115 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r115 == null) goto L99;
        r115.post(new p(this));
        return;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    }

    public final void G3(String r5) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        ((IRealtimeCallTracer) this.y.getValue()).x(com.larus.voicecall.impl.util.d.c(r1));
        h3(r1);
        r1.put("toast_type", r5);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("noise_free_result_toast_show", r1);
    }

    public final void W3(DenoiseStatusRes r4) {
        Keva r0 = z3();
        String r1 = "last_voice_feature_status_".concat(AccountService.a.getSecUserId());
        if (r4 != null) goto L6;
        r4 = DenoiseStatusRes.UNKNOWN;
    L6:
        r0.storeInt(r1, r4.getValue());
    }

    public final void X3(String r6) {
        boolean r2 = true;
        z3().storeBoolean("has_cold_show_auth_dialog", true);
        DeNoiseAuthDialog r0 = new DeNoiseAuthDialog(new d0(this), new i(this));
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "chat");
        r1.put("source", r6);
        r1.put("call_id", C3().a().e);
        r0.f = r1;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        FLogger.a.e(D3(), "showDeNoiseAuthDialog failed. activity is finishing!");
        return;
    L11:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r5 != null) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == false) goto L20;
        FLogger.a.e(D3(), "showDeNoiseAuthDialog failed. activity is isDestroyed!");
        return;
    L20:
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L34;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isDetached() == true) goto L34;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isRemoving() == true) goto L34;
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L32
        FragmentManager r7 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();     // Catch: Throwable -> L32
        String r8 = D3();     // Catch: Throwable -> L32
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L32
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r8, r9);     // Catch: Throwable -> L32
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r0, r9) == true) goto L42;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36 Throwable -> L32
    L30:
        r0.show(r7, r8);     // Catch: Throwable -> L32
        return;
    L42:
        return;
    L32:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        FLogger.a.e(D3(), "showDeNoiseAuthDialog failed. e=" + th);
        return;
    L34:
        FLogger r10 = FLogger.a;
        String r11 = D3();
        StringBuilder r12 = new StringBuilder("isAdded=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r12.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded());
        r12.append("  isDetached=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r12.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isDetached());
        r12.append("  isRemoving=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r12.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isRemoving());
        r10.e(r11, r12.toString());
        return;
    L14:
        if (r5.isDestroyed() != true) goto L16;
    L5:
        if (r3.isFinishing() != true) goto L7;
        r4 = true;
        goto L8
    }

    public final void a4(boolean r9) {
        Job r0 = this.p;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L24;
        Job r3 = this.p;
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == false) goto L24;
        Job r5 = this.p;
        if (r5 != null) goto L19;
    L21:
        if (r1 == false) goto L24;
        t19.s r6 = t19.s.a;
        Context r7 = getContext();
        int r8 = j0.a;
        t19.s.j(r6, r7, j0.d(2131900320), null, false, 28);
        FLogger.a.e(D3(), "onDenoiseSwitchChanged target status is " + r9 + ". but net request is working");
        return;
    L19:
        if (r5.isCancelled() == true) goto L21;
        r1 = true;
        goto L21
    L12:
        if (r3.isCompleted() == true) goto L14;
        r4 = true;
    L24:
        this.p = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new RealtimeDenoiseComponent$tryStartChangeDenoiseSwitchRequest$1(r9, this, null), 2, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void h3(JSONObject r3) {
        r3.put("current_page", "chat");
        r3.put("call_id", C3().a().e);
    }

    @Override // com.larus.voicecall.impl.component.denoise.g
    public final n1 rC(final Function0<Unit> r18) {
        Intrinsics.checkNotNullParameter(r18, "onSwitchClicked");
        int r0 = j0.a;
        String r5 = j0.d(2131911036);
        RealtimeCallUtil.a.getClass();
        boolean r11 = RealtimeCallUtil.t();
        int r6 = 0;
        if (RealtimeCallUtil.t == DenoiseStatusRes.LEARNING) goto L5;
        boolean r1 = true;
    L6:
        boolean r12 = !r1;
        int r3 = v19.c.b(2130971699, null, 2131241176);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L9
        r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getResources().getColor(2131103681);     // Catch: Throwable -> L9
    L15:
        return new n1(4, false, r5, null, Integer.valueOf(r3), Integer.valueOf(r6), false, false, r11, r12, new n(r18, this), null, u3a.f.e());
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Throwable r7 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r7 == null) goto L15;
        FLogger.a.e("RealtimeComponent", "onErr=" + r7 + " color=2131103681 clazz=" + RealtimeDenoiseComponent.class);
        goto L15
    L5:
        r1 = false;
        goto L6
    }

    public static void Q3(RealtimeDenoiseComponent r3, boolean r4) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r3.h3(r1);
        r1.put("scene", "turn_on_voice_feature_auth");
        r1.put("success", 1);
        if (r4 == false) goto L5;
        String r5 = "on";
    L6:
        r1.put("to_status", r5);
        r1.put("error_reason", null);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("voice_feature_auth_setting_result", r1);
        return;
    L5:
        r5 = "off";
        goto L6
    }

    public final void E3(boolean r6, boolean r7) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        ((IRealtimeCallTracer) this.y.getValue()).x(com.larus.voicecall.impl.util.d.c(r1));
        h3(r1);
        String r2 = "on";
        if (r7 == false) goto L5;
        Object r8 = "on";
    L6:
        r1.put("from_status", r8);
        if (r6 == true) goto L10;
        r2 = "off";
    L10:
        r1.put("to_status", r2);
        String r9 = "0";
        if (C3().a().p.q == false) goto L13;
    L16:
        Object r10 = "1";
    L17:
        r1.put("is_continuous_speak", r10);
        if (C3().a().b == false) goto L20;
        r9 = "1";
    L20:
        r1.put("is_obric_continuous_talk", r9);
        Unit r11 = Unit.INSTANCE;
        r0.reportEvent("click_noise_free_switch", r1);
        return;
    L13:
        if (C3().a().a == true) goto L16;
        r10 = "0";
        goto L17
    L5:
        r8 = "off";
        goto L6
    }

    public final void V3(boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.G() == true) goto L7;
        if (r7 == false) goto L7;
        FLogger.a.i(D3(), "onDenoiseSwitchChanged isOpen=" + r7 + ". cur not auth, so show the auth dialog");
        X3("user_initiative_click");
        return;
    L7:
        if (r7 == true) goto L9;
    L14:
        if (r7 == true) goto L16;
    L21:
        if (r7 == false) goto L23;
    L26:
        E3(r7, !r7);
        a4(r7);
        return;
    L23:
        if (RealtimeCallUtil.t() == true) goto L26;
        t19.s r0 = t19.s.a;
        Context r1 = getContext();
        int r9 = j0.a;
        t19.s.j(r0, r1, j0.d(2131911047), null, false, 28);
        FLogger.a.e(D3(), "user hope to close, but already close.");
        return;
    L16:
        if (RealtimeCallUtil.G() == false) goto L21;
        if (RealtimeCallUtil.t != DenoiseStatusRes.LEARNING) goto L21;
        t19.s.j(t19.s.a, getContext(), p3(2131911045), null, false, 28);
        FLogger.a.e(D3(), "user hope to open, but already in learn state.");
        return;
    L9:
        if (RealtimeCallUtil.G() == false) goto L14;
        if (RealtimeCallUtil.t != DenoiseStatusRes.FEATURE_ENABLED) goto L14;
        t19.s r10 = t19.s.a;
        Context r11 = getContext();
        r10.getClass();
        t19.s.o(r11, 2131911048, false);
        FLogger.a.e(D3(), "user hope to open, but already open.");
    }

    public final void H3(boolean r4, boolean r5, String r6) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        h3(r1);
        if (r5 == false) goto L5;
        String r7 = "turn_on_noise_free";
    L6:
        r1.put("scene", r7);
        r1.put("success", r4 ? 1 : 0);
        RealtimeCallUtil.a.getClass();
        r1.put("to_status", RealtimeCallUtil.t.getDesc());
        r1.put("error_reason", r6);
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("noise_free_setting_result", r1);
        return;
    L5:
        r7 = "turn_off_noise_free";
        goto L6
    }

    public final void o1(MajorState r1, int r2, MajorState r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "currentMajorState");
        Intrinsics.checkNotNullParameter(r3, "newMajorState");
        if (r4 != 14) goto L5;
        return;
    L5:
        if (r4 == 15) goto L9;
        this.n = r4;
        Z3();
        c4();
        return;
    }
}
