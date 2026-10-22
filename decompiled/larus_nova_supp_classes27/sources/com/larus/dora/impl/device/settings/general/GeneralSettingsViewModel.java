package com.larus.dora.impl.device.settings.general;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyLocalUnbindAndResetResult;
import com.larus.dora.impl.core.UnbindAndResetResult;
import com.larus.dora.impl.core.settingsconfig.DoraMultiDeviceConfig;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.utils.l0;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.KotlinNothingValueException;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0014J\u0006\u0010\"\u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u001a\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00170\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_generalSettingsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsState;", "generalSettingsStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getGeneralSettingsStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "id", "", "flowCompanionDeviceManager", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "getFlowCompanionDeviceManager", "()Lcom/larus/cdm/IFlowCompanionDeviceManager;", "flowCompanionDeviceManager$delegate", "Lkotlin/Lazy;", "isMultiDeviceEnable", "", "_unbindStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "Lcom/larus/dora/impl/device/settings/general/IntentState;", "Lcom/bytedance/dora/device/DoraDevice;", "unbindStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUnbindStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "updateMultiDeviceEnable", "", "updateWearSensorEnable", "enabled", "loadGeneralSettings", "doReboot", "onlyLocalUnbind", "unbind", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeneralSettingsViewModel extends ViewModel {
    public static final b Companion = null;
    private static final String TAG = "GeneralSettingsViewMode";
    private final z0<w> _generalSettingsStateFlow;
    private final MutableSharedFlow<Pair<IntentState, DoraDevice>> _unbindStateFlow;
    private final Lazy flowCompanionDeviceManager$delegate;
    private final i1<w> generalSettingsStateFlow;
    private int id;
    private boolean isMultiDeviceEnable;
    private final d1<Pair<IntentState, DoraDevice>> unbindStateFlow;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$2", f = "GeneralSettingsViewModel.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GeneralSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ GeneralSettingsViewModel a;

            public a(GeneralSettingsViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r9, Continuation r10) {
                Map r11 = (Map) r9;
                w r12 = (w) GeneralSettingsViewModel.access$get_generalSettingsStateFlow$p(this.a).getValue();
                if ((r12 instanceof w.b) == false) goto L15;
                String r0 = (String) CollectionsKt.firstOrNull(r11.keySet());
                if (r0 != null) goto L7;
                r0 = "";
            L7:
                String r13 = (String) r11.get(r0);
                if (r13 != null) goto L10;
                String r6 = "";
            L11:
                w.b r2 = (w.b) r12;
                if (Intrinsics.areEqual(r2.b.sn, r0) == false) goto L15;
                GeneralSettingsViewModel.access$get_generalSettingsStateFlow$p(this.a).setValue(w.b.a(r2, 0, false, false, r6, 15));
                goto L15
            L10:
                r6 = r13;
            L15:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(GeneralSettingsViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            b1 r6 = com.larus.dora.impl.ota.b.c;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$3", f = "GeneralSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GeneralSettingsViewModel this$0;

        public AnonymousClass3(GeneralSettingsViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L35;
            ResultKt.throwOnFailure(r6);
            DoraSetting.a.getClass();
            Integer r0 = null;
            DoraMultiDeviceConfig r7 = (DoraMultiDeviceConfig) l0.a(null, new com.larus.dora.impl.settings.b1());
            boolean r1 = true;
            if (r7 == null) goto L31;
            DoraDevice r2 = kj4.a.g().c();
            if (r2 == null) goto L9;
            r0 = Boxing.boxInt(r2.type);
        L9:
            GeneralSettingsViewModel r3 = this.this$0;
            if (o59.a.n(r0) == false) goto L14;
            Boolean r8 = r7.getDoraG();
            if (r8 == null) goto L30;
            r1 = r8.booleanValue();
        L30:
            GeneralSettingsViewModel.access$setMultiDeviceEnable$p(r3, r1);
        L33:
            return Unit.INSTANCE;
        L14:
            int r4 = ProductNameType.DORA_E.deviceType;
            if (r0 != null) goto L18;
        L22:
            int r5 = ProductNameType.DORA_LITE.deviceType;
            if (r0 == null) goto L30;
            if (r0.intValue() != r5) goto L30;
            Boolean r9 = r7.getDora();
            if (r9 == null) goto L30;
            r1 = r9.booleanValue();
            goto L30
        L18:
            if (r0.intValue() != r4) goto L22;
            Boolean r10 = r7.getDoraE();
            if (r10 == null) goto L30;
            r1 = r10.booleanValue();
            goto L30
        L31:
            GeneralSettingsViewModel.access$setMultiDeviceEnable$p(this.this$0, true);
            goto L33
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements gk4.f {
        public final /* synthetic */ GeneralSettingsViewModel a;

        public final void b(int r1, int r2, int r3) {
        }

        public a(GeneralSettingsViewModel r1) {
            this.a = r1;
        }

        public final void a(String r7, String r8, String r9, int r10) {
            if (o0.d(r8) == false) goto L8;
            w r11 = (w) GeneralSettingsViewModel.access$get_generalSettingsStateFlow$p(this.a).getValue();
            if ((r11 instanceof w.b) == false) goto L9;
            z0 r12 = GeneralSettingsViewModel.access$get_generalSettingsStateFlow$p(this.a);
            w.b r0 = (w.b) r11;
            int r1 = GeneralSettingsViewModel.access$getId$p(this.a);
            GeneralSettingsViewModel.access$setId$p(this.a, r1 + 1);
            r12.setValue(w.b.a(r0, r1, false, false, null, 30));
            return;
        L9:
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$doReboot$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$doReboot$1", f = "GeneralSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            if (DoraAdapterExtKt.g(kj4.a.g()) != 0) goto L7;
            g49.d.d(GeneralSettingsViewModel.TAG, "doReboot: success");
        L9:
            return Unit.INSTANCE;
        L7:
            g49.d.d(GeneralSettingsViewModel.TAG, "doReboot: failure");
            t19.s r4 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r4.getClass();
            t19.s.b(r0, 2131904027, false);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$loadGeneralSettings$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$loadGeneralSettings$1", f = "GeneralSettingsViewModel.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GeneralSettingsViewModel this$0;

        public C02531(GeneralSettingsViewModel r1, Continuation<? super C02531> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02531(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            DoraDevice r5 = DoraAdapterExtKt.h(kj4.a.g());
            g49.d.d(GeneralSettingsViewModel.TAG, "loadGeneralSettings: " + r5);
            if (r5 == null) goto L33;
            w r12 = (w) GeneralSettingsViewModel.access$get_generalSettingsStateFlow$p(this.this$0).getValue();
            int r3 = kj4.a.g().b();
            g49.d.d(GeneralSettingsViewModel.TAG, "loadGeneralSettings: wearSensorState = " + r3);
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L17;
            boolean r7 = true;
        L18:
            mj4.f r4 = kj4.a.g().c;
            int r8 = r4.n;
            if (r8 != (-1)) goto L21;
            r8 = r4.h();
        L21:
            g49.d.d(GeneralSettingsViewModel.TAG, "loadGeneralSettings: budsMultipleState = " + r8);
            if (r8 == (-1)) goto L24;
            if (r8 != 1) goto L28;
            boolean r6 = true;
        L29:
            z0 r13 = GeneralSettingsViewModel.access$get_generalSettingsStateFlow$p(this.this$0);
            int r9 = GeneralSettingsViewModel.access$getId$p(this.this$0);
            GeneralSettingsViewModel.access$setId$p(this.this$0, r9 + 1);
            com.larus.dora.impl.ota.b r10 = com.larus.dora.impl.ota.b.a;
            w.b r2 = new w.b(r9, r5, r6, r7, com.larus.dora.impl.ota.b.a(r5));
            this.label = 1;
            if (r13.emit(r2, this) != r0) goto L33;
            return r0;
        L28:
            r6 = false;
            goto L29
        L24:
            if ((r12 instanceof w.b) == false) goto L28;
            r6 = ((w.b) r12).c;
        L17:
            r7 = false;
            goto L18
        L13:
            if ((r12 instanceof w.b) == false) goto L17;
            r7 = ((w.b) r12).d;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$onlyLocalUnbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$onlyLocalUnbind$1", f = "GeneralSettingsViewModel.kt", i = {1, 2}, l = {198, 202, 204, 213}, m = "invokeSuspend", n = {"device", "device"}, s = {"L$0", "L$0"})
    public static final class C02541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ GeneralSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$onlyLocalUnbind$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[OnlyLocalUnbindAndResetResult.values().length];
                r0[OnlyLocalUnbindAndResetResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[OnlyLocalUnbindAndResetResult.SPP_DISCONNECT_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public C02541(GeneralSettingsViewModel r1, Continuation<? super C02541> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02541(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r10);
        L45:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            DoraDevice r2 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r10);
        L37:
            Intent r11 = new Intent("action.DEVICE_UNBIND");
            if (TextUtils.isEmpty(r2.mac) == true) goto L43;
            String r3 = r2.mac;
            if (r3 != null) goto L42;
            r3 = "";
        L42:
            r11.putExtra("mac", r3);
        L43:
            Boxing.boxBoolean(LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r11));
            goto L45
        L12:
            DoraDevice r4 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r10);
        L25:
            int r12 = a.a[((OnlyLocalUnbindAndResetResult) r10).ordinal()];
            if (r12 == 1) goto L33;
            if (r12 != 2) goto L32;
            MutableSharedFlow r13 = GeneralSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r5 = new Pair(IntentState.ACTION_SPP_DISCONNECT_FAILED, r4);
            this.L$0 = null;
            this.label = 4;
            if (r13.emit(r5, this) != r0) goto L45;
            return r0;
        L32:
            throw new NoWhenBranchMatchedException();
        L33:
            MutableSharedFlow r14 = GeneralSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r6 = new Pair(IntentState.ACTION_UNBIND_SUCCESS, r4);
            this.L$0 = r4;
            this.label = 3;
            if (r14.emit(r6, this) != r0) goto L36;
            return r0;
        L36:
            r2 = r4;
            goto L37
        L13:
            ResultKt.throwOnFailure(r10);
        L20:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r10);
            DoraDevice r15 = DoraAdapterExtKt.h(kj4.a.g());
            if (r15 != null) goto L21;
            MutableSharedFlow r16 = GeneralSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r7 = new Pair(IntentState.ACTION_NO_DEVICE_CONNECTED, null);
            this.label = 1;
            if (r16.emit(r7, this) != r0) goto L20;
            return r0;
        L21:
            kj4.a r8 = kj4.a.g();
            this.L$0 = r15;
            this.label = 2;
            Object r9 = DoraAdapterExtKt.B(r8, r15, this);
            if (r9 != r0) goto L24;
            return r0;
        L24:
            r4 = r15;
            r10 = r9;
            goto L25
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$unbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$unbind$1", f = "GeneralSettingsViewModel.kt", i = {1, 4}, l = {223, 227, 229, 234, 238, 256}, m = "invokeSuspend", n = {"device", "device"}, s = {"L$0", "L$0"})
    public static final class C02551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ GeneralSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$unbind$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UnbindAndResetResult.values().length];
                r0[UnbindAndResetResult.SERVER_UNBIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[UnbindAndResetResult.SERVER_UNBIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[UnbindAndResetResult.SERVER_UNBIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[UnbindAndResetResult.SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[UnbindAndResetResult.SPP_DISCONNECT_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public C02551(GeneralSettingsViewModel r1, Continuation<? super C02551> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02551(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean r3 = true;
            switch(this.label) {
                case 0: goto L10;
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r9);
        L66:
            return Unit.INSTANCE;
        L7:
            DoraDevice r1 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r9);
        L38:
            Intent r10 = new Intent("action.DEVICE_UNBIND");
            if (TextUtils.isEmpty(r1.mac) == true) goto L44;
            String r2 = r1.mac;
            if (r2 != null) goto L43;
            r2 = "";
        L43:
            r10.putExtra("mac", r2);
        L44:
            LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r10);
            if (r1.mac == null) goto L66;
            GeneralSettingsViewModel r11 = this.this$0;
            IFlowCompanionDeviceManager r4 = GeneralSettingsViewModel.access$getFlowCompanionDeviceManager(r11);
            if (r4 != null) goto L49;
        L51:
            r3 = false;
        L52:
            if (r3 == false) goto L66;
            IFlowCompanionDeviceManager r5 = GeneralSettingsViewModel.access$getFlowCompanionDeviceManager(r11);
            if (r5 == null) goto L56;
            r5.a(r1.mac);
        L56:
            IFlowCompanionDeviceManager r12 = GeneralSettingsViewModel.access$getFlowCompanionDeviceManager(r11);
            if (r12 == null) goto L66;
            r12.k(r1.sn);
            goto L66
        L49:
            if (r4.b(r1.mac) != true) goto L51;
        L8:
            DoraDevice r6 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r9);
        L21:
            int r13 = a.a[((UnbindAndResetResult) r9).ordinal()];
            if (r13 != 1) goto L24;
            MutableSharedFlow r14 = GeneralSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r7 = new Pair(IntentState.ACTION_SERVER_UNBIND_NETWORK_ERROR, r6);
            this.L$0 = null;
            this.label = 3;
            if (r14.emit(r7, this) != r0) goto L66;
            return r0;
        L24:
            if (r13 == 2) goto L59;
            if (r13 == 3) goto L59;
            if (r13 == 4) goto L34;
            if (r13 != 5) goto L33;
            MutableSharedFlow r15 = GeneralSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r8 = new Pair(IntentState.ACTION_SPP_DISCONNECT_FAILED, r6);
            this.L$0 = null;
            this.label = 6;
            if (r15.emit(r8, this) != r0) goto L66;
            return r0;
        L33:
            throw new NoWhenBranchMatchedException();
        L34:
            MutableSharedFlow r16 = GeneralSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r17 = new Pair(IntentState.ACTION_UNBIND_SUCCESS, r6);
            this.L$0 = r6;
            this.label = 5;
            if (r16.emit(r17, this) != r0) goto L37;
            return r0;
        L37:
            r1 = r6;
        L59:
            MutableSharedFlow r18 = GeneralSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r20 = new Pair(IntentState.ACTION_SERVER_UNBIND_FAILED, r6);
            this.L$0 = null;
            this.label = 4;
            if (r18.emit(r20, this) != r0) goto L66;
            return r0;
        L9:
            ResultKt.throwOnFailure(r9);
        L16:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r9);
            DoraDevice r21 = DoraAdapterExtKt.h(kj4.a.g());
            if (r21 != null) goto L17;
            MutableSharedFlow r22 = GeneralSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r23 = new Pair(IntentState.ACTION_NO_DEVICE_CONNECTED, null);
            this.label = 1;
            if (r22.emit(r23, this) != r0) goto L16;
            return r0;
        L17:
            kj4.a r24 = kj4.a.g();
            this.L$0 = r21;
            this.label = 2;
            Object r25 = DoraAdapterExtKt.Q(r24, r21, this);
            if (r25 != r0) goto L20;
            return r0;
        L20:
            r6 = r21;
            r9 = r25;
            goto L21
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$updateMultiDeviceEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$updateMultiDeviceEnable$1", f = "GeneralSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GeneralSettingsViewModel this$0;

        public C02561(GeneralSettingsViewModel r1, Continuation<? super C02561> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02561(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r9);
            w r10 = (w) GeneralSettingsViewModel.access$get_generalSettingsStateFlow$p(this.this$0).getValue();
            if ((r10 instanceof w.b) == false) goto L12;
            int r0 = kj4.a.g().c.h();
            z0 r1 = GeneralSettingsViewModel.access$get_generalSettingsStateFlow$p(this.this$0);
            w.b r2 = (w.b) r10;
            if (r0 != 1) goto L9;
            boolean r4 = true;
        L10:
            r1.setValue(w.b.a(r2, 0, r4, false, null, 27));
            DoraSystemInfoManager r11 = DoraSystemInfoManager.a;
            DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("multi_device_connection_switch", String.valueOf(r0))));
            goto L12
        L9:
            r4 = false;
        L12:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$updateWearSensorEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel$updateWearSensorEnable$1", f = "GeneralSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GeneralSettingsViewModel this$0;

        public C02571(GeneralSettingsViewModel r1, Continuation<? super C02571> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02571(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r3);
            GeneralSettingsViewModel r4 = this.this$0;
            boolean r1 = true;
            if (kj4.a.g().e.b() == 1) goto L8;
            r1 = false;
        L8:
            r4.updateWearSensorEnable(r1);
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ IFlowCompanionDeviceManager yo() {
        return flowCompanionDeviceManager_delegate$lambda$0();
    }

    private static final IFlowCompanionDeviceManager flowCompanionDeviceManager_delegate$lambda$0() {
        return (IFlowCompanionDeviceManager) ServiceManager.get().getService(IFlowCompanionDeviceManager.class);
    }

    private final IFlowCompanionDeviceManager getFlowCompanionDeviceManager() {
        return (IFlowCompanionDeviceManager) this.flowCompanionDeviceManager$delegate.getValue();
    }

    public final void doReboot() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(null), 3, null);
    }

    public final void onlyLocalUnbind() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C02541(this, null), 3, null);
    }

    public final void unbind() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C02551(this, null), 3, null);
    }

    public GeneralSettingsViewModel() {
        StateFlowImpl r0 = j1.a(w.a.a);
        this._generalSettingsStateFlow = r0;
        this.generalSettingsStateFlow = r0;
        this.flowCompanionDeviceManager$delegate = LazyKt.lazy(new x());
        this.isMultiDeviceEnable = true;
        MutableSharedFlow<Pair<IntentState, DoraDevice>> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._unbindStateFlow = r1;
        this.unbindStateFlow = r1;
        gk4.e.a.a.a(new a(this));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass3(this, null), 2, null);
    }

    public final void loadGeneralSettings() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02531(this, null), 2, null);
    }

    public final void updateMultiDeviceEnable() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02561(this, null), 2, null);
    }

    public final void updateWearSensorEnable() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02571(this, null), 2, null);
    }

    public final i1<w> getGeneralSettingsStateFlow() {
        return this.generalSettingsStateFlow;
    }

    public final d1<Pair<IntentState, DoraDevice>> getUnbindStateFlow() {
        return this.unbindStateFlow;
    }

    public final boolean isMultiDeviceEnable() {
        return this.isMultiDeviceEnable;
    }

    public static final /* synthetic */ IFlowCompanionDeviceManager access$getFlowCompanionDeviceManager(GeneralSettingsViewModel r0) {
        return r0.getFlowCompanionDeviceManager();
    }

    public static final /* synthetic */ int access$getId$p(GeneralSettingsViewModel r0) {
        return r0.id;
    }

    public static final /* synthetic */ z0 access$get_generalSettingsStateFlow$p(GeneralSettingsViewModel r0) {
        return r0._generalSettingsStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_unbindStateFlow$p(GeneralSettingsViewModel r0) {
        return r0._unbindStateFlow;
    }

    public final void updateWearSensorEnable(boolean r9) {
        w r0 = (w) this._generalSettingsStateFlow.getValue();
        if ((r0 instanceof w.b) == false) goto L6;
        z0<w> r1 = this._generalSettingsStateFlow;
        w.b r2 = (w.b) r0;
        int r3 = this.id;
        this.id = r3 + 1;
        r1.setValue(w.b.a(r2, r3, false, r9, null, 22));
        return;
    }

    public static final /* synthetic */ void access$setId$p(GeneralSettingsViewModel r0, int r1) {
        r0.id = r1;
    }

    public static final /* synthetic */ void access$setMultiDeviceEnable$p(GeneralSettingsViewModel r0, boolean r1) {
        r0.isMultiDeviceEnable = r1;
    }
}
