package com.obric.memorydata.memory.ui.settings;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.memory.AutoMemoryConfig;
import com.obric.memorydata.memory.y;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.utils.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000f\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0007H\u0003J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0017\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\rH\u0002J\u001f\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\rH\u0002J\u0006\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\u0012J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u0012H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006,"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "wasStopped", "", "settingsListener", "com/obric/memorydata/memory/ui/settings/SmartMemorySettingsViewModel$settingsListener$1", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsViewModel$settingsListener$1;", "onCleared", "", "processIntent", MemorySourceLinkType.INTENT, "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsIntent;", "initializeMemorySettingsState", "updateSmartMemory", "enable", "setPendingSmartMemory", "pendingEnabled", "(Ljava/lang/Boolean;)V", "updateConfirmedSmartMemory", "confirmed", "setPendingAppSetting", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "updateAppSetting", "enabled", "hasInstalledAppsRequiringAccessibility", "disableAppsRequiringAccessibility", "onPause", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStart", "updateMemorySettingsState", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SmartMemorySettingsViewModel extends ViewModel implements DefaultLifecycleObserver {
    public static final a Companion = null;
    private static final String KEY_COUNT = "count";
    public static final String STORE_PACKAGE_NAME = "com.obric.appstore";
    private static final String TAG = "MemorySettings";
    private final ae<x> _state;
    private final b settingsListener;
    private final ar<x> state;
    private boolean wasStopped;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.SmartMemorySettingsViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.SmartMemorySettingsViewModel$1", f = "SmartMemorySettingsViewModel.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SmartMemorySettingsViewModel this$0;

        AnonymousClass1(SmartMemorySettingsViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(DeviceInfoState.INSTANCE.getVlmSupportState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"));
            final SmartMemorySettingsViewModel r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C06191(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.SmartMemorySettingsViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.SmartMemorySettingsViewModel$2", f = "SmartMemorySettingsViewModel.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SmartMemorySettingsViewModel this$0;

        AnonymousClass2(SmartMemorySettingsViewModel r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<Set<String>> r7 = l.f11479a.a().i();
            final SmartMemorySettingsViewModel r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Set<String>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsViewModel$Companion;", "", "<init>", "()V", "TAG", "", "STORE_PACKAGE_NAME", "KEY_COUNT", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/settings/SmartMemorySettingsViewModel$settingsListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements SettingsChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmartMemorySettingsViewModel f11427a;

        b(SmartMemorySettingsViewModel r1) {
            this.f11427a = r1;
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r9) {
            Intrinsics.checkNotNullParameter(r9, "key");
            kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this.f11427a, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new SmartMemorySettingsViewModel$settingsListener$1$onSettingsChanged$1(this.f11427a, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }
    }

    static {
        Companion = new a(null);
    }

    public SmartMemorySettingsViewModel() {
        ae<x> r0 = at.a(initializeMemorySettingsState());
        this._state = r0;
        this.state = kotlinx.coroutines.flow.k.a(r0);
        b r1 = new b(this);
        this.settingsListener = r1;
        SettingsManager.INSTANCE.registerChangeListener("app_auto_memory_config", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(r1, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ ae access$get_state$p(SmartMemorySettingsViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ void access$updateMemorySettingsState(SmartMemorySettingsViewModel r0) {
        r0.updateMemorySettingsState();
    }

    private final x initializeMemorySettingsState() {
        y.a(y.f11594a, null, false, 3, null);
        l.f11479a.a().w();
        AutoMemoryConfig.AppAutoMemoryConfig r0 = y.f11594a.a();
        Set r1 = (Set) ZeusTransformUtils.preCheckCast(l.f11479a.a().i().c(), Set.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "enabledApps: " + r1, false, 4, null);
        ArrayList r2 = new ArrayList();
        Set r10 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.getSmartMemoryPackages(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        AutoMemoryConfig.SmartMemoryPackage r4 = (AutoMemoryConfig.SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r3.next(), AutoMemoryConfig.SmartMemoryPackage.class, "com.obric.memorydata.plugin");
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == true) goto L10;
        if (Intrinsics.areEqual(r4.getPackageName(), "com.obric.browser") == true) goto L4;
    L10:
        boolean r5 = r1.contains(r4.getPackageName());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "autoMemoryPackages: " + r4 + " selected: " + r5, false, 4, null);
        r2.add(new c(r4.getAppName(), r4.getPackageName(), r4.getDescription(), ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5, com.obric.memorydata.utils.c.f13193a.a(r4.getPackageName()), null, 64, null));
        if (r4.getNoNeedA11y() == false) goto L4;
        r10.add(r4.getPackageName());
        goto L4
    L14:
        return new x(((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(l.f11479a.a().a().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), null, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), r10, 0, 36, null);
    }

    private final void setPendingAppSetting(String r19, Boolean r20) {
        ae<x> r1 = this._state;
    L3:
        x r2 = r1.c();
        x r5 = (x) ZeusTransformUtils.preCheckCast(r2, x.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r5.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L5:
        if (r4.hasNext() == false) goto L10;
        c r8 = (c) ZeusTransformUtils.preCheckCast(r4.next(), c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r8.b(), r19) == false) goto L9;
        r8 = c.a(r8, null, null, null, false, false, false, r20, 63, null);
    L9:
        r6.add(r8);
        goto L5
    L10:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "setPendingAppSetting: " + r19 + ", pending=" + r20, false, 4, null);
        if (r1.a(r2, x.a(r5, false, false, null, r9, null, r5.e() + 1, 23, null)) == false) goto L3;
    }

    private final void setPendingSmartMemory(Boolean r12) {
        ae<x> r11 = this._state;
    L3:
        x r0 = r11.c();
        x r2 = (x) ZeusTransformUtils.preCheckCast(r0, x.class, "com.obric.memorydata.plugin");
        if (r11.a(r0, x.a(r2, false, false, r12, null, null, r2.e() + 1, 27, null)) == false) goto L3;
    }

    private final void updateAppSetting(String r23, boolean r24) {
        ae<x> r12 = this._state;
    L3:
        x r13 = r12.c();
        x r15 = (x) ZeusTransformUtils.preCheckCast(r13, x.class, "com.obric.memorydata.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r15.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r1.iterator();
    L5:
        if (r16.hasNext() == false) goto L11;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r16.next(), c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r2.b(), r23) == false) goto L10;
        r2 = c.a(r2, null, null, null, false, r24, false, null, 47, null);
    L10:
        r10.add(r2);
        r10 = r10;
        r12 = r12;
        goto L5
    L11:
        ae<x> r22 = r12;
        List r6 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "updateAppSetting: " + r23 + ", " + r24, false, 4, null);
        Set<String> r3 = CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast(l.f11479a.a().i().c(), Iterable.class, "com.obric.memorydata.plugin"));
        if (r24 == false) goto L14;
        r3.add(r23);
    L15:
        l.f11479a.a().a(r3);
        DevTrackerEventId r4 = DevTrackerEventId.ON_SMART_MEMORY_SWITCH_COUNT_CHANGE_EVENT;
        JSONObject r5 = new JSONObject();
        r5.put("count", ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).size());
        ah.a(r4, r5);
        if (r22.a(r13, x.a(r15, false, false, null, r6, null, r15.e() + 1, 23, null)) == true) goto L17;
        r12 = r22;
        goto L3
    L17:
        return;
    L14:
        r3.remove(r23);
        goto L15
    }

    private final void updateConfirmedSmartMemory(boolean r12) {
        l.a(l.f11479a.a(), false, 1, null);
        ae<x> r11 = this._state;
    L3:
        x r0 = r11.c();
        if (r11.a(r0, x.a((x) ZeusTransformUtils.preCheckCast(r0, x.class, "com.obric.memorydata.plugin"), r12, false, null, null, null, 0, 62, null)) == false) goto L3;
    }

    private final void updateMemorySettingsState() {
        ae<x> r1 = this._state;
    L3:
        x r2 = r1.c();
        x r3 = (x) ZeusTransformUtils.preCheckCast(r2, x.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3.c(), Iterable.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L7;
        c r8 = (c) ZeusTransformUtils.preCheckCast(r6.next(), c.class, "com.obric.memorydata.plugin");
        Pair r9 = TuplesKt.to(r8.b(), r8.g());
        r7.put(r9.getFirst(), r9.getSecond());
        goto L5
    L7:
        x r10 = initializeMemorySettingsState();
        Boolean r13 = r3.b();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r10.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r4.iterator();
    L9:
        if (r12.hasNext() == false) goto L12;
        c r14 = (c) ZeusTransformUtils.preCheckCast(r12.next(), c.class, "com.obric.memorydata.plugin");
        r11.add(c.a(r14, null, null, null, false, false, false, (Boolean) ZeusTransformUtils.preCheckCast(r7.get(r14.b()), Boolean.class, "com.obric.memorydata.plugin"), 63, null));
        goto L9
    L12:
        if (r1.a(r2, x.a(r10, false, false, r13, (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), null, 0, 51, null)) == false) goto L3;
    }

    private final void updateSmartMemory(boolean r18) {
        l.f11479a.a().a(r18);
        if (r18 == false) goto L5;
        l.f11479a.a().h();
    L5:
        DevTrackerEventId r1 = DevTrackerEventId.ON_SMART_MEMORY_SWITCH_COUNT_CHANGE_EVENT;
        JSONObject r2 = new JSONObject();
        if (r18 == false) goto L8;
        int r3 = ((Collection) ZeusTransformUtils.preCheckCast(((x) ZeusTransformUtils.preCheckCast(this._state.c(), x.class, "com.obric.memorydata.plugin")).c(), Collection.class, "com.obric.memorydata.plugin")).size();
    L9:
        r2.put("count", r3);
        ah.a(r1, r2);
        ae<x> r12 = this._state;
    L10:
        x r13 = r12.c();
        x r14 = (x) ZeusTransformUtils.preCheckCast(r13, x.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r14.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r0.iterator();
    L12:
        if (r16.hasNext() == false) goto L15;
        r15.add(c.a((c) ZeusTransformUtils.preCheckCast(r16.next(), c.class, "com.obric.memorydata.plugin"), null, null, null, r18, false, false, null, IdlErrors.E_RejectInferDeviceOverheat, null));
        goto L12
    L15:
        if (r12.a(r13, x.a(r14, false, r18, null, (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), null, r14.e() + 1, 17, null)) == false) goto L10;
        return;
    L8:
        r3 = 0;
        goto L9
    }

    public final void disableAppsRequiringAccessibility() {
        if (com.obric.memorydata.memory.b.f10076a.b() == true) goto L5;
        return;
    L5:
        l.f11479a.a().v();
        ae<x> r0 = this._state;
    L6:
        x r1 = r0.c();
        x r4 = (x) ZeusTransformUtils.preCheckCast(r1, x.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r4.c(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r7 = false;
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L9;
    L11:
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L22;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.memorydata.plugin");
        if (r5.e() == true) goto L17;
    L19:
        boolean r6 = false;
    L20:
        if (r6 == false) goto L13;
        r7 = true;
        goto L22
    L17:
        if (r4.d().contains(r5.b()) == true) goto L19;
        r6 = true;
    L22:
        if (r7 == false) goto L33;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L26:
        if (r10.hasNext() == false) goto L31;
        c r11 = (c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.memorydata.plugin");
        if (r4.d().contains(r11.b()) == true) goto L30;
        r11 = c.a(r11, null, null, null, false, false, false, null, 111, null);
    L30:
        r9.add(r11);
        goto L26
    L31:
        r4 = x.a(r4, false, false, null, (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), null, r4.e() + 1, 23, null);
    L33:
        if (r0.a(r1, r4) == false) goto L6;
        return;
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
        goto L11
    }

    public final ar<x> getState() {
        return this.state;
    }

    public final boolean hasInstalledAppsRequiringAccessibility() {
        if (com.obric.memorydata.memory.b.f10076a.c() == true) goto L5;
        return false;
    L5:
        x r7 = (x) ZeusTransformUtils.preCheckCast(this._state.c(), x.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7.c(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L8;
    L10:
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L30;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.memorydata.plugin");
        if (r7.d().contains(r3.b()) == false) goto L16;
    L20:
        boolean r4 = false;
    L21:
        if (r4 == false) goto L12;
        return true;
    L16:
        if (r3.f() == false) goto L18;
    L19:
        r4 = true;
        goto L21
    L18:
        if (com.obric.memorydata.utils.c.f13193a.a(r3.b()) == false) goto L20;
    L30:
        return false;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        return false;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        SettingsManager.INSTANCE.unregisterChangeListener("app_auto_memory_config", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(this.settingsListener, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        super.onCleared();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner r3) {
        LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "owner");
        super.onPause(r4);
        this.wasStopped = true;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner r3) {
        LifecycleOwner r4 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r3, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "owner");
        super.onStart(r4);
        if (this.wasStopped == false) goto L6;
        this.wasStopped = false;
        updateMemorySettingsState();
        return;
    }

    public final void processIntent(w r4) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        if (ZeusTransformUtils.instanceOf(r4, w.e.class) == false) goto L6;
        updateSmartMemory(((w.e) ZeusTransformUtils.preCheckCast(r4, w.e.class, "com.obric.memorydata.plugin")).a());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, w.b.class) == false) goto L9;
        setPendingSmartMemory(((w.b) ZeusTransformUtils.preCheckCast(r4, w.b.class, "com.obric.memorydata.plugin")).a());
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, w.d.class) == false) goto L12;
        updateConfirmedSmartMemory(((w.d) ZeusTransformUtils.preCheckCast(r4, w.d.class, "com.obric.memorydata.plugin")).a());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, w.c.class) == false) goto L15;
        updateAppSetting(((w.c) ZeusTransformUtils.preCheckCast(r4, w.c.class, "com.obric.memorydata.plugin")).a(), ((w.c) ZeusTransformUtils.preCheckCast(r4, w.c.class, "com.obric.memorydata.plugin")).b());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, w.a.class) == false) goto L19;
        setPendingAppSetting(((w.a) ZeusTransformUtils.preCheckCast(r4, w.a.class, "com.obric.memorydata.plugin")).a(), ((w.a) ZeusTransformUtils.preCheckCast(r4, w.a.class, "com.obric.memorydata.plugin")).b());
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    }
}
