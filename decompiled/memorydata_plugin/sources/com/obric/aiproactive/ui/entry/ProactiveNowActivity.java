package com.obric.aiproactive.ui.entry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.api.IProactiveShortcutService;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011*\u0001\u0019\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001fH\u0014J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020\u001fH\u0014J\b\u0010,\u001a\u00020\u001fH\u0014J\b\u0010-\u001a\u00020\u001fH\u0014J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u0002032\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00104\u001a\u00020\u001f2\u0006\u00102\u001a\u0002032\u0006\u00105\u001a\u00020\u001cH\u0016J\u0010\u00106\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0016J\b\u00107\u001a\u000200H\u0016J0\u00108\u001a\u00020\u001f2\b\b\u0002\u00109\u001a\u00020\u001c2\b\b\u0002\u0010:\u001a\u00020\u001c2\b\b\u0002\u0010;\u001a\u00020\u001c2\b\b\u0002\u0010<\u001a\u00020\u001cH\u0002J\u0010\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u0017H\u0002J\b\u0010?\u001a\u00020\u001fH\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u000200H\u0002J\u0012\u0010B\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006D"}, d2 = {"Lcom/obric/aiproactive/ui/entry/ProactiveNowActivity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "Lcom/obric/aiproactive/ui/entry/HomeEnterPageExposureHost;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "startupCoordinatorViewModel", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorViewModel;", "getStartupCoordinatorViewModel", "()Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorViewModel;", "startupCoordinatorViewModel$delegate", "Lkotlin/Lazy;", "homeEnterPageCoordinator", "Lcom/obric/aiproactive/ui/entry/HomeEnterPageExposureCoordinator;", "getHomeEnterPageCoordinator", "()Lcom/obric/aiproactive/ui/entry/HomeEnterPageExposureCoordinator;", "homeEnterPageCoordinator$delegate", "defaultShortcutCheck", "Lkotlinx/coroutines/Job;", "defaultShortcutState", "Lcom/obric/aiproactive/ui/entry/DefaultShortcutHomeInteractionState;", "homeLifecycleCallbacks", "com/obric/aiproactive/ui/entry/ProactiveNowActivity$homeLifecycleCallbacks$1", "Lcom/obric/aiproactive/ui/entry/ProactiveNowActivity$homeLifecycleCallbacks$1;", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onPostResume", "onWindowFocusChanged", "hasFocus", "onPause", "onStop", "onDestroy", "onHomeChildPageOpened", "previousPage", "", "onHomeCoveringSheetShown", "sheetToken", "", "onHomeCoveringSheetDismissed", "releasesStartupDetailSuppression", "onHomeCoveringSheetAbandoned", "currentHomeEnterFrom", "updateDefaultShortcutState", "homeFragmentResumed", "windowFocused", "activityAlive", "homeChildPageActive", "reduceDefaultShortcutState", "nextState", "cancelDefaultShortcutCheck", "reportHomeEnterPage", "enterFrom", "handleStartupIntent", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveNowActivity extends BaseProactiveActivity implements i {
    public static final a Companion = null;
    private static final String EXTRA_INSPIRATION_ID = "inspirationId";
    private static final String TAG = "ProactiveNowActivity";
    private bx defaultShortcutCheck;
    private f defaultShortcutState;
    private final Lazy homeEnterPageCoordinator$delegate;
    private final ProactiveNowActivity$homeLifecycleCallbacks$1 homeLifecycleCallbacks;
    private final NavigationBarScheme navigationBarScheme;
    private final Lazy startupCoordinatorViewModel$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/entry/ProactiveNowActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_INSPIRATION_ID", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.ProactiveNowActivity$onHomeCoveringSheetDismissed$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
        AnonymousClass1(Object r8) {
            super(1, r8, ProactiveNowActivity.class, "reportHomeEnterPage", "reportHomeEnterPage(Ljava/lang/String;)Z", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(String r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            return Boolean.valueOf(ProactiveNowActivity.access$reportHomeEnterPage((ProactiveNowActivity) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveNowActivity.class, "com.obric.memorydata.plugin"), r3));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Boolean invoke(String r3) {
            return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.ProactiveNowActivity$onNewIntent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C10631 extends FunctionReferenceImpl implements Function1<String, Boolean> {
        C10631(Object r8) {
            super(1, r8, ProactiveNowActivity.class, "reportHomeEnterPage", "reportHomeEnterPage(Ljava/lang/String;)Z", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(String r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            return Boolean.valueOf(ProactiveNowActivity.access$reportHomeEnterPage((ProactiveNowActivity) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveNowActivity.class, "com.obric.memorydata.plugin"), r3));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Boolean invoke(String r3) {
            return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.ProactiveNowActivity$onPostResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C10641 extends FunctionReferenceImpl implements Function1<String, Boolean> {
        C10641(Object r8) {
            super(1, r8, ProactiveNowActivity.class, "reportHomeEnterPage", "reportHomeEnterPage(Ljava/lang/String;)Z", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(String r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            return Boolean.valueOf(ProactiveNowActivity.access$reportHomeEnterPage((ProactiveNowActivity) ZeusTransformUtils.preCheckCast(this.receiver, ProactiveNowActivity.class, "com.obric.memorydata.plugin"), r3));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Boolean invoke(String r3) {
            return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.ProactiveNowActivity$reduceDefaultShortcutState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.ProactiveNowActivity$reduceDefaultShortcutState$1", f = "ProactiveNowActivity.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
    static final class C10651 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ProactiveNowActivity this$0;

        C10651(ProactiveNowActivity r3, Continuation<? super C10651> r4) {
            ProactiveNowActivity r5 = (ProactiveNowActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveNowActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10651(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10651) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10651.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            IProactiveShortcutService r7 = (IProactiveShortcutService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IProactiveShortcutService.class), IProactiveShortcutService.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L14;
            Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(this.this$0, Activity.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.initializeDefaultOnHome(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.aiproactive.ui.entry.ProactiveNowActivity$homeLifecycleCallbacks$1] */
    public ProactiveNowActivity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        this.startupCoordinatorViewModel$delegate = LazyKt.lazy(new $$Lambda$ProactiveNowActivity$p8ak01gw0875stbhkqhSWKSXGY(this));
        this.homeEnterPageCoordinator$delegate = LazyKt.lazy(new $$Lambda$ProactiveNowActivity$4w2lzJzOrNPP_VmfQL6K03dXUD8(this));
        this.defaultShortcutState = new f(false, false, false, false, false, false, false, 127, null);
        this.homeLifecycleCallbacks = new ProactiveNowActivity$homeLifecycleCallbacks$1(this);
    }

    public static final /* synthetic */ boolean access$reportHomeEnterPage(ProactiveNowActivity r2, String r3) {
        return ((ProactiveNowActivity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveNowActivity.class, "com.obric.memorydata.plugin")).reportHomeEnterPage(r3);
    }

    private final void cancelDefaultShortcutCheck() {
        bx r0 = this.defaultShortcutCheck;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.defaultShortcutCheck = null;
    }

    private final h getHomeEnterPageCoordinator() {
        return (h) ZeusTransformUtils.preCheckCast(this.homeEnterPageCoordinator$delegate.getValue(), h.class, "com.obric.memorydata.plugin");
    }

    private final StartupInspirationCoordinatorViewModel getStartupCoordinatorViewModel() {
        return (StartupInspirationCoordinatorViewModel) ZeusTransformUtils.preCheckCast(this.startupCoordinatorViewModel$delegate.getValue(), StartupInspirationCoordinatorViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void handleStartupIntent(Intent r10) {
        String r0 = null;
        if (r10 == null) goto L5;
        String r1 = r10.getStringExtra(EXTRA_INSPIRATION_ID);
    L6:
        if (r10 == null) goto L8;
        r0 = r10.getStringExtra("enter_from");
    L8:
        String r2 = com.obric.aiproactive.ui.util.n.a(r0, r1);
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder().append("[StartupFlow] nowShortcut handleStartupIntent inspirationId=").append(r1).append(" enterFrom=").append(r2).append(" hasIntent=");
        if (r10 == null) goto L11;
        boolean r11 = true;
    L12:
        IRunLog.a.a(r3, TAG, r4.append(r11).toString(), false, 4, null);
        getStartupCoordinatorViewModel().updatePendingInspirationId(r1);
        return;
    L11:
        r11 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private static final h homeEnterPageCoordinator_delegate$lambda$1(ProactiveNowActivity r3) {
        return ((HomeEnterPageExposureViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast((ProactiveNowActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveNowActivity.class, "com.obric.memorydata.plugin"), ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(HomeEnterPageExposureViewModel.class), HomeEnterPageExposureViewModel.class, "com.obric.memorydata.plugin")).getCoordinator();
    }

    public static /* synthetic */ h lambda$4w2lzJzOrNPP_VmfQL6K03dXUD8(ProactiveNowActivity r0) {
        return homeEnterPageCoordinator_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$p8ak01gw087-5stbhkqhSWKSXGY, reason: not valid java name */
    public static /* synthetic */ StartupInspirationCoordinatorViewModel m291lambda$p8ak01gw0875stbhkqhSWKSXGY(ProactiveNowActivity r0) {
        return startupCoordinatorViewModel_delegate$lambda$0(r0);
    }

    private final void reduceDefaultShortcutState(f r8) {
        this.defaultShortcutState = r8;
        if (r8.c() == true) goto L7;
        cancelDefaultShortcutCheck();
        return;
    L7:
        if (this.defaultShortcutCheck == null) goto L9;
        return;
    L9:
        this.defaultShortcutCheck = kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10651(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final boolean reportHomeEnterPage(String r4) {
        if (isFinishing() == false) goto L5;
        return false;
    L5:
        if (isDestroyed() == true) goto L11;
        com.obric.aiproactive.ui.util.h.f6884a.b("home", getHomeEnterPageCoordinator().d(), r4, "click");
        return true;
    L11:
        return false;
    }

    private static final StartupInspirationCoordinatorViewModel startupCoordinatorViewModel_delegate$lambda$0(ProactiveNowActivity r3) {
        return (StartupInspirationCoordinatorViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast((ProactiveNowActivity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveNowActivity.class, "com.obric.memorydata.plugin"), ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(StartupInspirationCoordinatorViewModel.class), StartupInspirationCoordinatorViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void updateDefaultShortcutState(boolean r12, boolean r13, boolean r14, boolean r15) {
        PowerManager r0 = (PowerManager) ZeusTransformUtils.preCheckCast(ContextCompat.getSystemService((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), PowerManager.class), PowerManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        reduceDefaultShortcutState(new f(r12, getHomeEnterPageCoordinator().a(), r13, r14, r8, !ba.f(), r15));
        return;
    L5:
        if (r0.isInteractive() != true) goto L7;
        r8 = true;
        goto L8
    }

    static /* synthetic */ void updateDefaultShortcutState$default(ProactiveNowActivity r1, boolean r2, boolean r3, boolean r4, boolean r5, int r6, Object r7) {
        ProactiveNowActivity r8 = (ProactiveNowActivity) ZeusTransformUtils.wrapperContextForParams(r1, ProactiveNowActivity.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r8.defaultShortcutState.a();
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r8.hasWindowFocus();
    L9:
        if ((r6 & 4) == 0) goto L17;
        if (r8.isFinishing() == false) goto L13;
    L15:
        r4 = false;
        goto L17
    L13:
        if (r8.isDestroyed() == true) goto L15;
        r4 = true;
    L17:
        if ((r6 & 8) == 0) goto L19;
        r5 = r8.defaultShortcutState.b();
    L19:
        r8.updateDefaultShortcutState(r2, r3, r4, r5);
    }

    @Override // com.obric.aiproactive.ui.entry.i
    public String currentHomeEnterFrom() {
        return getHomeEnterPageCoordinator().c();
    }

    public boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getActionMasked() != 0) goto L11;
        Fragment r0 = getSupportFragmentManager().findFragmentById(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"));
        if (ZeusTransformUtils.instanceOf(r0, NowFeedPageFragment.class) == false) goto L7;
        NowFeedPageFragment r1 = (NowFeedPageFragment) ZeusTransformUtils.preCheckCast(r0, NowFeedPageFragment.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L11;
        r1.dismissUserRequirementImeIfTouchOutside(r5.getRawX(), r5.getRawY());
        goto L11
    L7:
        r1 = null;
    L11:
        return super.dispatchTouchEvent(r5);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onCreateChecked(Bundle r14) {
        boolean r2 = false;
        getSupportFragmentManager().registerFragmentLifecycleCallbacks((FragmentManager.FragmentLifecycleCallbacks) ZeusTransformUtils.preCheckCast(this.homeLifecycleCallbacks, FragmentManager.FragmentLifecycleCallbacks.class, "com.obric.memorydata.plugin"), false);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setSoftInputMode(48);
        getWindow().setStatusBarColor(0);
        AiProactiveUiModeController r0 = AiProactiveUiModeController.f6869a;
        Configuration r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r1, "getConfiguration(...)");
        boolean r3 = !r0.b(r1);
        WindowInsetsControllerCompat r4 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        r4.setAppearanceLightStatusBars(r3);
        r4.setAppearanceLightNavigationBars(r3);
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_proactive_now, "layout", "activity_proactive_now"));
        Fragment r5 = getSupportFragmentManager().findFragmentById(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"));
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder().append("onCreate savedInstanceState=");
        if (r14 == null) goto L5;
        r2 = true;
    L5:
        StringBuilder r15 = r6.append(r2).append(", existingFragment=");
        String r8 = null;
        if (r5 == null) goto L10;
        Class<?> r9 = r5.getClass();
        if (r9 == null) goto L10;
        String r10 = r9.getName();
    L11:
        StringBuilder r16 = r15.append(r10).append(", uiMode=").append(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode).append(", flags=");
        Intent r11 = getIntent();
        if (r11 == null) goto L14;
        Integer r12 = Integer.valueOf(r11.getFlags());
    L15:
        IRunLog.a.a(r7, TAG, r16.append(r12).toString(), false, 4, null);
        if (r5 != null) goto L18;
        getSupportFragmentManager().beginTransaction().replace(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"), (Fragment) ZeusTransformUtils.preCheckCast(new NowFeedPageFragment(), Fragment.class, "com.obric.memorydata.plugin")).commitNowAllowingStateLoss();
    L18:
        h r17 = getHomeEnterPageCoordinator();
        Intent r13 = getIntent();
        if (r13 == null) goto L21;
        String r18 = r13.getStringExtra("enter_from");
    L22:
        Intent r19 = getIntent();
        if (r19 == null) goto L25;
        r8 = r19.getStringExtra(EXTRA_INSPIRATION_ID);
    L25:
        r17.a(r18, r8);
        handleStartupIntent(getIntent());
        return;
    L21:
        r18 = null;
        goto L22
    L14:
        r12 = null;
    L10:
        r10 = null;
        goto L11
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        getSupportFragmentManager().unregisterFragmentLifecycleCallbacks((FragmentManager.FragmentLifecycleCallbacks) ZeusTransformUtils.preCheckCast(this.homeLifecycleCallbacks, FragmentManager.FragmentLifecycleCallbacks.class, "com.obric.memorydata.plugin"));
        updateDefaultShortcutState$default(this, false, false, false, false, 11, null);
        super.onDestroy();
    }

    @Override // com.obric.aiproactive.ui.entry.i
    public void onHomeChildPageOpened(String r10) {
        Intrinsics.checkNotNullParameter(r10, "previousPage");
        getHomeEnterPageCoordinator().a(r10, Intrinsics.areEqual(r10, "proactive_card_detail"));
        updateDefaultShortcutState$default(this, false, false, false, true, 7, null);
    }

    public void onHomeCoveringSheetAbandoned(Object r9) {
        Intrinsics.checkNotNullParameter(r9, "sheetToken");
        getHomeEnterPageCoordinator().a(r9);
        updateDefaultShortcutState$default(this, false, false, false, false, 15, null);
    }

    public void onHomeCoveringSheetDismissed(Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "sheetToken");
        getHomeEnterPageCoordinator().a(r10, r11, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function1.class, "com.obric.memorydata.plugin"));
        updateDefaultShortcutState$default(this, false, false, false, false, 15, null);
    }

    public void onHomeCoveringSheetShown(Object r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "sheetToken");
        Intrinsics.checkNotNullParameter(r10, "previousPage");
        getHomeEnterPageCoordinator().a(r9, r10);
        updateDefaultShortcutState$default(this, false, false, false, false, 15, null);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r12) {
        Intrinsics.checkNotNullParameter(r12, MemorySourceLinkType.INTENT);
        super.onNewIntent(r12);
        setIntent(r12);
        getHomeEnterPageCoordinator().a(r12.getStringExtra("enter_from"), r12.getStringExtra(EXTRA_INSPIRATION_ID), (Function1) ZeusTransformUtils.preCheckCast(new C10631(this), Function1.class, "com.obric.memorydata.plugin"));
        handleStartupIntent(r12);
        updateDefaultShortcutState$default(this, false, false, false, false, 7, null);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        getHomeEnterPageCoordinator().b();
        updateDefaultShortcutState$default(this, false, false, false, false, 15, null);
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        getHomeEnterPageCoordinator().a((Function1) ZeusTransformUtils.preCheckCast(new C10641(this), Function1.class, "com.obric.memorydata.plugin"));
        updateDefaultShortcutState$default(this, false, false, false, false, 7, null);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        getHomeEnterPageCoordinator().a(isChangingConfigurations());
        super.onStop();
    }

    public void onWindowFocusChanged(boolean r8) {
        super.onWindowFocusChanged(r8);
        updateDefaultShortcutState$default(this, false, r8, false, false, 13, null);
    }
}
