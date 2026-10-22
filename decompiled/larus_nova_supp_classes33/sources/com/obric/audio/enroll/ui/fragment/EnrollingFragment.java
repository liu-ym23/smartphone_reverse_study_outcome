package com.obric.audio.enroll.ui.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.base.BaseFragment;
import com.obric.audio.enroll.model.TipsCode;
import com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr;
import com.obric.audio.enroll.view.EnrollStageView;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaEnrollingFragmentBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00040123B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\fH\u0002J\u0016\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0082@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0002J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020\u0014H\u0002J\b\u0010)\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/audio/enroll/ui/fragment/EnrollingFragment;", "Lcom/obric/audio/enroll/base/BaseFragment;", "<init>", "()V", "_realBinding", "Lcom/obric/audio/impl/databinding/SvaEnrollingFragmentBinding;", "binding", "getBinding", "()Lcom/obric/audio/impl/databinding/SvaEnrollingFragmentBinding;", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "animationPlaying", "", "tipThread", "Landroid/os/HandlerThread;", "tipHandler", "Landroid/os/Handler;", "tipState", "Lcom/obric/audio/enroll/ui/fragment/EnrollingFragment$TipState;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "observe", "fasterSpeedText", "handleTipsBlocking", "ev", "Lcom/obric/audio/enroll/model/TipTextEvent;", "(Lcom/obric/audio/enroll/model/TipTextEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateToTimeout", "showTip", "event", "navigateToResult", "onDestroyView", "showRippleOnce", "index", "", "playSuccessTone", "vibrateSuccessEffect", "requestRecordPermission", "Companion", "DoraLinkStateObserver", "NetworkStateObserver", "TipState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollingFragment extends BaseFragment {
    public static final /* synthetic */ int k = 0;
    public SvaEnrollingFragmentBinding e;
    public EnrollViewModel f;
    public boolean g;
    public final PthreadHandlerThreadV2 h;
    public Handler i;
    public volatile TipState j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/audio/enroll/ui/fragment/EnrollingFragment$TipState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "NORMAL", "ERROR", "CHANGING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TipState extends Enum<TipState> {
        public static final TipState CHANGING = null;
        public static final TipState ERROR = null;
        public static final TipState NA = null;
        public static final TipState NORMAL = null;
        public static final /* synthetic */ TipState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TipState> getEntries() {
            return b;
        }

        static {
            TipState r0 = new TipState("NA", 0);
            NA = r0;
            TipState r1 = new TipState("NORMAL", 1);
            NORMAL = r1;
            TipState r3 = new TipState("ERROR", 2);
            ERROR = r3;
            TipState r5 = new TipState("CHANGING", 3);
            CHANGING = r5;
            TipState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static TipState[] values() {
            return (TipState[]) a.clone();
        }

        public static TipState valueOf(String r1) {
            return (TipState) r27.a.a(TipState.class, r1);
        }

        public TipState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public static final b a = null;
        public static final CopyOnWriteArraySet<Function1<Integer, Unit>> b = null;
        public static volatile int c;
        public static final a d = null;
        public static volatile boolean e;

        public static final class a implements t39.n {
            public a() {
            }

            public final void e(int r2, int r3, String r4, String r5) {
                Intrinsics.checkNotNullParameter(r4, "productName");
                if (r2 == b.c) goto L5;
                b r6 = b.a;
                b.c = r2;
                FLogger.a.i("EnrollingFragment", "onDoraLinkChanged state=" + r2 + " productId=" + r3);
            L5:
                Iterator<Function1<Integer, Unit>> r7 = b.b.iterator();
            L7:
                if (r7.hasNext() == false) goto L9;
                r7.next().invoke(Integer.valueOf(r2));
                goto L7
            }
        }

        public b() {
        }

        static {
            a = new b();
            b = new CopyOnWriteArraySet();
            c = Integer.MIN_VALUE;
            d = new a();
        }

        public final void a(z r6) {
            Intrinsics.checkNotNullParameter(r6, "listener");
            if (e == true) goto L16;
            monitor-enter(this);
        L22:
            th = move-exception;
            throw th;
        L7:
            if (e == false) goto L10;
            monitor-exit(this);
            goto L16
        L10:
            IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L22
            if (r0 != null) goto L14;
            monitor-exit(this);
            goto L16
        L14:
            r0.G(d);     // Catch: Throwable -> L22
            e = true;     // Catch: Throwable -> L22
            FLogger.a.i("EnrollingFragment", "registerDoraLinkCallback done");     // Catch: Throwable -> L22
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(this);
        L16:
            CopyOnWriteArraySet<Function1<Integer, Unit>> r2 = b;
            r2.add(r6);
            FLogger r3 = FLogger.a;
            r3.i("EnrollingFragment", "addListener size=" + r2.size());
            IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r4 == null) goto L27;
            DeviceService r5 = r4.device();
            if (r5 == null) goto L28;
            int r7 = r5.u();
            r3.i("EnrollingFragment", "addListener emit currentState=" + r7);
            r6.invoke(Integer.valueOf(r7));
            return;
        L28:
            return;
        }
    }

    public static final class c {
        public static final c a = null;
        public static final CopyOnWriteArraySet<Function1<Boolean, Unit>> b = null;
        public static volatile Boolean c;
        public static volatile boolean d;
        public static volatile Context e;
        public static final a f = null;

        public static final class a extends ConnectivityManager.NetworkCallback {
            public a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r2) {
                Intrinsics.checkNotNullParameter(r2, "network");
                c r3 = c.a;
                c.b();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r2) {
                Intrinsics.checkNotNullParameter(r2, "network");
                c r3 = c.a;
                c.b();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onCapabilitiesChanged(Network r2, NetworkCapabilities r3) {
                Intrinsics.checkNotNullParameter(r2, "network");
                Intrinsics.checkNotNullParameter(r3, "networkCapabilities");
                c r4 = c.a;
                c.b();
            }
        }

        public c() {
        }

        static {
            a = new c();
            b = new CopyOnWriteArraySet();
            f = new a();
        }

        public static void b() {
            Context r0 = e;
            if (r0 != null) goto L5;
            return;
        L5:
            boolean r1 = sia.e.a(r0);
            if (Intrinsics.areEqual(Boolean.valueOf(r1), c) == true) goto L8;
            c = Boolean.valueOf(r1);
            FLogger.a.i("EnrollingFragment", "networkState available=" + r1);
        L8:
            Iterator<Function1<Boolean, Unit>> r2 = b.iterator();
        L10:
            if (r2.hasNext() == false) goto L12;
            r2.next().invoke(Boolean.valueOf(r1));
            goto L10
        }

        public final void a(Context r7, Function1<? super Boolean, Unit> r8) {
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r8, "listener");
            FLogger.a.i("EnrollingFragment", "NetworkStateObserver.addListener sizeBefore=" + b.size());
            Context r0 = r7.getApplicationContext();
            if (d == true) goto L40;
            monitor-enter(this);
        L42:
            th = move-exception;
            throw th;
        L7:
            if (d == false) goto L10;
            monitor-exit(this);
            goto L40
        L10:
            Object r2 = r0.getSystemService("connectivity");     // Catch: Throwable -> L42
            if ((r2 instanceof ConnectivityManager) == false) goto L14;
            ConnectivityManager r3 = (ConnectivityManager) r2;     // Catch: Throwable -> L42
        L15:
            if (r3 != null) goto L18;
            monitor-exit(this);
            goto L40
        L18:
            e = r0;     // Catch: Throwable -> L42
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L25
            if (Build.VERSION.SDK_INT < 24) goto L22;
            r3.registerDefaultNetworkCallback(f);     // Catch: Throwable -> L25
        L23:
            Object r4 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L25
        L27:
            Throwable r5 = Result.exceptionOrNull-impl(r4);     // Catch: Throwable -> L42
            if (r5 == null) goto L30;
            FLogger.a.e("EnrollingFragment", "NetworkStateObserver register failed: " + r5.getMessage());     // Catch: Throwable -> L42
        L30:
            Boolean r6 = Boolean.FALSE;     // Catch: Throwable -> L42
            if (Result.isFailure-impl(r4) == false) goto L34;
            r4 = r6;
        L34:
            if (((Boolean) r4).booleanValue() == true) goto L38;
            monitor-exit(this);
            goto L40
        L38:
            d = true;     // Catch: Throwable -> L42
            b();     // Catch: Throwable -> L42
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L42
            monitor-exit(this);
            goto L40
        L22:
            r3.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), f);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L42
            r4 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L42
            goto L27
        L14:
            r3 = null;
        L40:
            b.add(r8);
            r8.invoke(Boolean.valueOf(sia.e.a(r7.getApplicationContext())));
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TipsCode.values().length];
            r0[TipsCode.TIPS_CODE_SAY_it.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r0[TipsCode.TIPS_CODE_FASTER_SAY_it.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r0[TipsCode.TIPS_CODE_CHECK_SENTENCE_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[TipsCode.TIPS_CODE_CHECK_SENTENCE_NETWORK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[TipsCode.TIPS_CODE_ERROR_TEXT_SIMILARITY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r0[TipsCode.TIPS_CODE_CHECKING_ENROLL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r0[TipsCode.TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[TipsCode.TIPS_CODE_ASR_TASK_START_FAILED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[TipsCode.TIPS_CODE_ASR_SESSION_START_FAILED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[TipsCode.TIPS_CODE_ASR_NETWORK_ERROR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r0[TipsCode.TIPS_CODE_ASR_TIMEOUT_RETRY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollingFragment$onDestroyView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$onDestroyView$1", f = "EnrollingFragment.kt", i = {}, l = {756}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EnrollingFragment this$0;

        public C00871(EnrollingFragment r1, Continuation<? super C00871> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00871(this.this$0, r3);
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
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            EnrollViewModel r5 = this.this$0.f;
            if (r5 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r5 = null;
        L11:
            VoicePrintEnrollRecordingsMgr r6 = r5.getRecordingManager();
            this.label = 1;
            if (r6.d(this) != r0) goto L15;
            return r0;
        }
    }

    static {
    }

    public final void onDestroyView() {
        FLogger.a.i("EnrollingFragment", "onDestroyView ..");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate())), null, null, new C00871(this, null), 3, null);
        super.onDestroyView();
        SvaEnrollingFragmentBinding r0 = this.e;
        Intrinsics.checkNotNull(r0);
        r0.j.cancelAnimation();
        this.e = null;
    }

    public EnrollingFragment() {
        this.h = new PthreadHandlerThreadV2("tipThread");
        this.j = TipState.NA;
    }

    @Override // com.obric.audio.enroll.base.BaseFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.f = (EnrollViewModel) new ViewModelProvider(requireActivity()).get(EnrollViewModel.class);
    }

    /* JADX WARN: Type inference failed for: r11v13, types: [com.obric.audio.enroll.ui.fragment.t] */
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        EnrollViewModel r12 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new EnrollingFragment$observe$1(this, null), 3, null);
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new EnrollingFragment$observe$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new EnrollingFragment$observe$3(this, null));
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new EnrollingFragment$observe$4(this, null));
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new EnrollingFragment$observe$5(this, null));
        SvaEnrollingFragmentBinding r13 = this.e;
        Intrinsics.checkNotNull(r13);
        r13.e.U5(getViewLifecycleOwner());
        if (t9a.b.a().b() == true) goto L9;
        SvaEnrollingFragmentBinding r14 = this.e;
        if (r14 == null) goto L9;
        Guideline r15 = r14.f;
        if (r15 == null) goto L9;
        r15.setGuidelinePercent(0.85f);
    L9:
        final ?? r16 = new t(this);
        if (t9a.b.a().b() == true) goto L18;
        EnrollViewModel r0 = this.f;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L15:
        if (Intrinsics.areEqual(r0.getStartFrom(), EnrollViewModel.DOUBAO_GUIDE) == false) goto L18;
        int r1 = rda.a.a;
        SvaEnrollingFragmentBinding r2 = this.e;
        Intrinsics.checkNotNull(r2);
        NovaTitleBarEx.b6(rda.a.b(r2.h), 2131241477, false, null, null, new v(r16), 14);
    L19:
        EnrollViewModel r17 = this.f;
        if (r17 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        r12.setAlreadyEnroll(false);
        return;
    L22:
        r12 = r17;
    L18:
        SvaEnrollingFragmentBinding r3 = this.e;
        Intrinsics.checkNotNull(r3);
        OFloatingTitleBar.i(r3.h, 2131244127, new u(r16));
        goto L19
    }

    public static final Object T90(EnrollingFragment r13, qia.q r14, Continuation r15) {
        r13.getClass();
        if ((r15 instanceof EnrollingFragment$handleTipsBlocking$1) == false) goto L7;
        EnrollingFragment$handleTipsBlocking$1 r1 = (EnrollingFragment$handleTipsBlocking$1) r15;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        qia.q r5 = (qia.q) r1.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
    L25:
        Object r6 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r0).booleanValue()));     // Catch: Throwable -> L14
    L31:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L35;
        FLogger.a.i("EnrollingFragment", "handleTipsBlocking failed : " + r7);
    L35:
        if (Result.isSuccess-impl(r6) == false) goto L38;
        ((Boolean) r6).booleanValue();
        FLogger.a.i("EnrollingFragment", "handleTipsBlocking success : " + r5.a);
    L38:
        if (r13.isAdded() == false) goto L65;
        Ref.BooleanRef r8 = new Ref.BooleanRef();
        FLogger r9 = FLogger.a;
        r9.i("EnrollingFragment", "showTip: " + r5.a);
        boolean r10 = false;
        if (r5.a.getV() >= 0) goto L43;
        boolean r11 = true;
    L44:
        r8.element = r11;
        switch(d.a[r5.a.ordinal()]) {
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L55;
            case 4: goto L54;
            case 5: goto L53;
            case 6: goto L52;
            case 7: goto L51;
            case 8: goto L50;
            case 9: goto L50;
            case 10: goto L49;
            case 11: goto L48;
            default: goto L47;
        };
    L48:
        String r12 = r13.getResources().getString(2131914202);
    L58:
        Intrinsics.checkNotNull(r12);
        if (r12.length() != 0) goto L61;
        r10 = true;
    L61:
        if (r10 == true) goto L65;
        r9.i("EnrollingFragment", "updateTip state : " + r13.j + " , content " + r5.a);
        CountDownLatch r16 = new CountDownLatch(1);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13.getViewLifecycleOwner()), null, null, new EnrollingFragment$showTip$1(r8, r13, r12, r16, null), 3, null);
        r16.await(3, TimeUnit.SECONDS);
        goto L65
    L49:
        r12 = r13.getResources().getString(2131914200);
        goto L58
    L50:
        r12 = r13.getResources().getString(2131914201);
        goto L58
    L51:
        r12 = r13.getResources().getString(2131914214);
        goto L58
    L52:
        r12 = r13.getResources().getString(2131914205);
        goto L58
    L53:
        r12 = r13.getResources().getString(2131914208);
        goto L58
    L54:
        r12 = r13.getResources().getString(2131914204);
        goto L58
    L55:
        r12 = r13.getResources().getString(2131914203);
        goto L58
    L56:
        r12 = r13.getResources().getString(2131914216);
        goto L58
    L57:
        r12 = r13.getResources().getString(2131914230);
        goto L58
    L47:
        throw new NoWhenBranchMatchedException();
    L43:
        r11 = false;
    L65:
        return Unit.INSTANCE;
    L14:
        th = th;
        qia.q r17 = r5;
    L30:
        Result.Companion r18 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        r5 = r17;
        goto L31
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        if (r13.isAdded() == false) goto L70;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L28
        EnrollingFragment$handleTipsBlocking$2$1 r20 = new EnrollingFragment$handleTipsBlocking$2$1(r13, null);     // Catch: Throwable -> L28
        r1.L$0 = r14;     // Catch: Throwable -> L28
        r1.label = 1;     // Catch: Throwable -> L28
        r0 = TimeoutKt.b(3000, r20, r1);     // Catch: Throwable -> L28
        if (r0 == r3) goto L71;
        r5 = r14;
        goto L25
    L71:
        return r3;
    L28:
        th = th;
        r17 = r14;
        goto L30
    L70:
        return Unit.INSTANCE;
    L7:
        r1 = new EnrollingFragment$handleTipsBlocking$1(r13, r15);
        goto L8
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        FLogger.a.i("EnrollingFragment", "onCreateView ..");
        View r15 = r12.inflate(2131564916, r13, false);
        int r16 = 2131371679;
        if (ViewBindings.findChildViewById(r15, 2131371679) == null) goto L37;
        r16 = 2131371774;
        AppCompatTextView r2 = ViewBindings.findChildViewById(r15, 2131371774);
        if (r2 == null) goto L37;
        r16 = 2131374141;
        if (ViewBindings.findChildViewById(r15, 2131374141) == null) goto L37;
        r16 = 2131375224;
        AppCompatTextView r3 = ViewBindings.findChildViewById(r15, 2131375224);
        if (r3 == null) goto L37;
        r16 = 2131384649;
        View r4 = ViewBindings.findChildViewById(r15, 2131384649);
        if (r4 == null) goto L37;
        r16 = 2131387165;
        EnrollStageView r5 = (EnrollStageView) ViewBindings.findChildViewById(r15, 2131387165);
        if (r5 == null) goto L37;
        r16 = 2131387166;
        if (ViewBindings.findChildViewById(r15, 2131387166) == null) goto L37;
        r16 = 2131387171;
        Guideline r6 = ViewBindings.findChildViewById(r15, 2131387171);
        if (r6 == null) goto L37;
        r16 = 2131387173;
        if (ViewBindings.findChildViewById(r15, 2131387173) == null) goto L37;
        r16 = 2131387175;
        if (ViewBindings.findChildViewById(r15, 2131387175) == null) goto L37;
        r16 = 2131387179;
        if (ViewBindings.findChildViewById(r15, 2131387179) == null) goto L37;
        r16 = 2131388739;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r15, 2131388739);
        if (r7 == null) goto L37;
        r16 = 2131388807;
        OFloatingTitleBar r8 = ViewBindings.findChildViewById(r15, 2131388807);
        if (r8 == null) goto L37;
        r16 = 2131388815;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r15, 2131388815);
        if (r9 == null) goto L37;
        r16 = 2131389245;
        if (ViewBindings.findChildViewById(r15, 2131389245) == null) goto L37;
        r16 = 2131392774;
        LottieAnimationView r10 = ViewBindings.findChildViewById(r15, 2131392774);
        if (r10 == null) goto L37;
        this.e = new SvaEnrollingFragmentBinding((LinearLayout) r15, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        getLifecycle().addObserver(new AnonymousClass1());
        ThreadMethodProxy.start(this.h);
        this.i = new Handler(this.h.getLooper(), new y(this));
        SvaEnrollingFragmentBinding r17 = this.e;
        Intrinsics.checkNotNull(r17);
        return r17.a;
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }
}
