package com.larus.dora.impl.device.manage.settings;

import android.app.Application;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c59.d0;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.BindAndConnectResult;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyBindResult;
import com.larus.dora.impl.core.OnlyConnectResult;
import com.larus.dora.impl.core.UnbindAndResetResult;
import com.larus.dora.impl.device.settings.general.IntentState;
import com.larus.dora.impl.dynamic.dsl.DslTemplateType;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.feature.DoraFeature;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.network.util.ScreenStateManager;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002LO\b\u0016\u0018\u0000 z2\u00020\u00012\u00020\u0002:\bz{|}~\u007f\u0080\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0016J\u001a\u0010Q\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u0001072\b\b\u0002\u0010S\u001a\u00020\u0006J\u0012\u0010T\u001a\u00020H2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0016\u0010W\u001a\u00020H2\u0006\u0010R\u001a\u000207H\u0082@¢\u0006\u0002\u0010XJ\"\u0010Y\u001a\u0004\u0018\u0001072\u0006\u0010R\u001a\u0002072\b\b\u0002\u0010Z\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010[J\u0016\u0010\\\u001a\u00020H2\u0006\u0010R\u001a\u000207H\u0082@¢\u0006\u0002\u0010XJ\u0010\u0010]\u001a\u00020H2\u0006\u0010R\u001a\u000207H\u0016J\f\u0010^\u001a\u00020=*\u000207H\u0002J\u0010\u0010_\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u000107J\u0018\u0010`\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u000107H\u0086@¢\u0006\u0002\u0010XJ\u0018\u0010a\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u000107H\u0086@¢\u0006\u0002\u0010XJ\b\u0010b\u001a\u00020HH\u0014J/\u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020=2\b\u0010g\u001a\u0004\u0018\u00010h2\b\u0010i\u001a\u0004\u0018\u00010V¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020lH\u0002J\u0010\u0010m\u001a\u00020H2\u0006\u0010d\u001a\u00020eH\u0002J\u000e\u0010n\u001a\u00020H2\u0006\u0010o\u001a\u00020pJ\u000e\u0010q\u001a\u00020H2\u0006\u0010U\u001a\u00020VJ\u000e\u0010r\u001a\u00020H2\u0006\u0010R\u001a\u000207J\u0006\u0010s\u001a\u00020HJ\u000e\u0010t\u001a\u00020H2\u0006\u0010u\u001a\u00020vJ\u0010\u0010w\u001a\u00020H2\b\u0010d\u001a\u0004\u0018\u00010eJ\u0010\u0010x\u001a\u00020H2\b\u0010d\u001a\u0004\u0018\u00010eJ\b\u0010y\u001a\u00020HH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u0018¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u0018¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0015X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020/0\u0018¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001aR\"\u00104\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000206\u0012\u0006\u0012\u0004\u0018\u000107050\bX\u0082\u0004¢\u0006\u0002\n\u0000R%\u00108\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000206\u0012\u0006\u0012\u0004\u0018\u000107050\u000b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\rR\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020=X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010MR\u0010\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0004\n\u0002\u0010P¨\u0006\u0081\u0001"}, d2 = {"Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "<init>", "()V", "deviceStateSeq", "", "_deviceBindStatusFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$DeviceBindAction;", "deviceBindStatusFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getDeviceBindStatusFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_deviceIntentSharedFlow", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$DeviceActionV2;", "get_deviceIntentSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "deviceIntentSharedFlow", "getDeviceIntentSharedFlow", "_pageInfoData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;", "pageInfoData", "Landroidx/lifecycle/LiveData;", "getPageInfoData", "()Landroidx/lifecycle/LiveData;", "_cardContextData", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "cardContextData", "getCardContextData", "_deviceStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$DeviceStateV2;", "deviceStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getDeviceStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_dialogEvent", "Lcom/larus/dora/impl/dynamic/event/DialogEvent;", "dialogEvent", "getDialogEvent", "_viewHolderEvent", "Lcom/larus/dora/impl/dynamic/event/ViewHolderEvent;", "viewHolderEvent", "getViewHolderEvent", "_connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "get_connectionState", "()Landroidx/lifecycle/MutableLiveData;", "connectionState", "getConnectionState", "_unbindStateFlow", "Lkotlin/Pair;", "Lcom/larus/dora/impl/device/settings/general/IntentState;", "Lcom/bytedance/dora/device/DoraDevice;", "unbindStateFlow", "getUnbindStateFlow", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "isScreenOn", "", "()Z", "setScreenOn", "(Z)V", "connectingJob", "Lkotlinx/coroutines/Job;", "getConnectingJob", "()Lkotlinx/coroutines/Job;", "setConnectingJob", "(Lkotlinx/coroutines/Job;)V", "onAction", "", "action", "Lcom/larus/dora/impl/dynamic/event/ViewHolderAction;", "screenListener", "com/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$screenListener$1", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$screenListener$1;", "doraLinkCallback", "com/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$doraLinkCallback$1;", "checkLocalBindState", "device", "delayTime", "handleConnectRequest", "mac", "", "handleGConnectRequest", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanBleInfo", "timeout", "(Lcom/bytedance/dora/device/DoraDevice;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNotGConnectRequest", "checkBindState", "isV2BleAdvertisementDevice", "connectAsync", "onlyConnect", "connect", "onCleared", "fetchData", "simpleDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "isCurrent", "vendorId", "", "pageKey", "(Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;ZLjava/lang/Integer;Ljava/lang/String;)V", "createFeedbackCard", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "updateCardContext", "updateConnectState", "status", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$ConnectState;", "updateRemoveBarData", "replaceBind", "disconnectSpp", "updateUi", "uiState", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel$UiState;", "onlyLocalUnbind", "unbind", "loadLabSettingConfig", "Companion", "DeviceBindAction", "EventNotification", "DeviceStateV2", "DeviceActionV2", "UiState", "ConnectState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraDeviceSettingsViewModel extends ViewModel implements e59.a {
    public static final a Companion = null;
    public static final String LAB_FEATURE_CONFIG_REQUEST = "/alice/w/starweave/feature-visibility/matched";
    public static final String TAG = "DoraDynamicViewModelV2";
    private final MutableLiveData<d59.b> _cardContextData;
    private final MutableLiveData<e59.b> _connectionState;
    private final MutableSharedFlow<d> _deviceBindStatusFlow;
    private final MutableSharedFlow<c> _deviceIntentSharedFlow;
    private final z0<e> _deviceStateFlow;
    private final MutableLiveData<e59.d> _dialogEvent;
    private final MutableLiveData<c59.m> _pageInfoData;
    private final MutableSharedFlow<Pair<IntentState, DoraDevice>> _unbindStateFlow;
    private final MutableLiveData<e59.f> _viewHolderEvent;
    private final LiveData<d59.b> cardContextData;
    private Job connectingJob;
    private final LiveData<e59.b> connectionState;
    private final com.larus.dora.impl.dynamic.loader.d dataLoader;
    private final d1<d> deviceBindStatusFlow;
    private final d1<c> deviceIntentSharedFlow;
    private final i1<e> deviceStateFlow;
    private long deviceStateSeq;
    private final LiveData<e59.d> dialogEvent;
    private final DoraDeviceSettingsViewModel$doraLinkCallback$1 doraLinkCallback;
    private boolean isScreenOn;
    private final LiveData<c59.m> pageInfoData;
    private final j screenListener;
    private final d1<Pair<IntentState, DoraDevice>> unbindStateFlow;
    private final LiveData<e59.f> viewHolderEvent;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DoraDeviceSettingsViewModel a;

            public a(DoraDeviceSettingsViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                e r5 = (e) r3;
                if (Intrinsics.areEqual(r5, e.d.a) == false) goto L6;
                this.a.get_connectionState().setValue(e59.b.d.a);
            L18:
                return Unit.INSTANCE;
            L6:
                if ((r5 instanceof e.a) == false) goto L8;
                this.a.get_connectionState().setValue(new e59.b.a(((e.a) r5).b.mac));
                goto L18
            L8:
                String r0 = null;
                if ((r5 instanceof e.b) == false) goto L12;
                MutableLiveData<e59.b> r6 = this.a.get_connectionState();
                ((e.b) r5).getClass();
                r6.setValue(new e59.b.C0125b(null));
                goto L18
            L12:
                if ((r5 instanceof e.c) == false) goto L18;
                MutableLiveData<e59.b> r7 = this.a.get_connectionState();
                z49.b r8 = ((e.c) r5).b;
                if (r8 == null) goto L16;
                r0 = r8.c();
            L16:
                r7.setValue(new e59.b.c(r0));
                goto L18
            }
        }

        public AnonymousClass1(DoraDeviceSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            i1<e> r6 = this.this$0.getDeviceStateFlow();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public interface b {

        public static final class a implements b {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                String r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "CONNECTED(mac=" + this.a + ')';
            }

            public a(String r1) {
                this.a = r1;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$b$b, reason: collision with other inner class name */
        public static final class C0035b implements b {
            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0035b) == true) goto L8;
                return false;
            L8:
                ((C0035b) r4).getClass();
                if (Intrinsics.areEqual(null, null) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                return "CONNECTING(mac=null)";
            }
        }

        public static final class c implements b {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                String r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "DISCONNECTED(mac=" + this.a + ')';
            }

            public c(String r1) {
                this.a = r1;
            }
        }
    }

    public interface c {

        public static final class a implements c {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                String r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "CheckBluetoothPermissionAndConnect(mac=" + this.a + ')';
            }

            public a(String r1) {
                this.a = r1;
            }
        }

        public static final class b implements c {
            public final DoraDevice a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "NeedUnbind(device=" + this.a + ')';
            }

            public b(DoraDevice r2) {
                Intrinsics.checkNotNullParameter(r2, "device");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$c$c, reason: collision with other inner class name */
        public static final class C0036c implements c {
            public final DoraDevice a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0036c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0036c) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "ShowDisconnectFailedDialog(device=" + this.a + ')';
            }

            public C0036c(DoraDevice r2) {
                Intrinsics.checkNotNullParameter(r2, "device");
                this.a = r2;
            }
        }

        public static final class d implements c {
            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof d) == true) goto L8;
                return false;
            L8:
                ((d) r4).getClass();
                if (Intrinsics.areEqual(null, null) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                throw null;
            }

            public final String toString() {
                return "ShowFailureToast(text=null)";
            }
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$checkBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$checkBindState$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {509, 511, 518, 523, 525}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02031(DoraDeviceSettingsViewModel r1, DoraDevice r2, Continuation<? super C02031> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02031(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L16;
            if (r0 == 1) goto L15;
            if (r0 == 2) goto L14;
            if (r0 == 3) goto L13;
            if (r0 == 4) goto L12;
            if (r0 == 5) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            Object r1 = this.L$0;
            ResultKt.throwOnFailure(r16);
        L52:
            Object r12 = r1;
        L53:
            Throwable r2 = Result.exceptionOrNull-impl(r12);
            if (r2 == null) goto L57;
            g49.d.c("DoraDynamicViewModelV2", "checkBindState: failure", r2);
            t19.s r3 = t19.s.a;
            Application r4 = AppHost.a.getApplication();
            r3.getClass();
            t19.s.b(r4, 2131908080, false);
        L57:
            return Unit.INSTANCE;
        L13:
            DoraDeviceSettingsViewModel r5 = (DoraDeviceSettingsViewModel) this.L$2;
            DoraDevice r6 = (DoraDevice) this.L$1;
            Object r7 = this.L$0;
            ResultKt.throwOnFailure(r16);
            DoraDeviceSettingsViewModel r14 = r5;
            Object r9 = r16;
        L40:
            DoraDevice r10 = (DoraDevice) r9;
            if (r10 == null) goto L43;
            r6.mode = r10.mode;
            r6.version = r10.version;
        L43:
            DoraDevice r13 = r6;
            r1 = r7;
        L45:
            MutableSharedFlow<c> r11 = r14.get_deviceIntentSharedFlow();
            c.b r15 = new c.b(r13);
            this.L$0 = r1;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 4;
            if (r11.emit(r15, this) != r8) goto L52;
            return r8;
        L14:
            ResultKt.throwOnFailure(r16);
            Object r17 = ((Result) r16).unbox-impl();
        L24:
            r12 = r17;
            r13 = this.$device;
            r14 = this.this$0;
            if (Result.isSuccess-impl(r12) == false) goto L53;
            Integer r18 = ((com.larus.dora.impl.network.b) r12).b();
            if (r18 == null) goto L29;
            int r20 = r18.intValue();
        L30:
            g49.d.d("DoraDynamicViewModelV2", "checkBindState: bindCode=" + r20);
            if (r20 == 1) goto L48;
            if (r20 != 2) goto L53;
            if (o59.a.p(r13) == false) goto L44;
            this.L$0 = r12;
            this.L$1 = r13;
            this.L$2 = r14;
            this.label = 3;
            r9 = DoraDeviceSettingsViewModel.scanBleInfo$default(r14, r13, 0, this, 2, null);
            if (r9 != r8) goto L39;
            return r8;
        L39:
            r7 = r12;
            r6 = r13;
            goto L40
        L44:
            r1 = r12;
            goto L45
        L48:
            kj4.a r21 = kj4.a.g();
            this.L$0 = r12;
            this.label = 5;
            if (DoraAdapterExtKt.b(r21) != r8) goto L51;
            return r8;
        L51:
            r1 = r12;
            goto L52
        L29:
            r20 = 0;
            goto L30
        L15:
            ResultKt.throwOnFailure(r16);
        L21:
            DoraNetworkApi r22 = DoraNetworkApi.a;
            DoraDevice r23 = this.$device;
            this.label = 2;
            r17 = r22.e(r23, true, this);
            if (r17 != r8) goto L24;
            return r8;
        L16:
            ResultKt.throwOnFailure(r16);
            if (this.this$0.isScreenOn() == true) goto L21;
            this.label = 1;
            if (DelayKt.delay(500, this) != r8) goto L21;
            return r8;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$checkLocalBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$checkLocalBindState$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayTime;
        final /* synthetic */ DoraDevice $device;
        int label;

        public C02041(long r1, DoraDevice r3, Continuation<? super C02041> r4) {
            this.$delayTime = r1;
            this.$device = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02041(this.$delayTime, this.$device, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            List r7 = DoraAdapterExtKt.k(kj4.a.g());
            DoraDevice r3 = this.$device;
            if ((r7 instanceof Collection) == true) goto L14;
        L16:
            Iterator r8 = r7.iterator();
        L18:
            if (r8.hasNext() == false) goto L15;
            if (Intrinsics.areEqual(((DoraDevice) r8.next()).mac, r3.mac) == false) goto L18;
        L21:
            if (r2 == true) goto L30;
            g49.d.d("DoraDynamicViewModelV2", "checkLocalBindState: unbind device " + this.$device);
            Intent r9 = new Intent("action.DEVICE_UNBIND");
            if (TextUtils.isEmpty(this.$device.mac) == true) goto L28;
            String r4 = this.$device.mac;
            if (r4 != null) goto L27;
            r4 = "";
        L27:
            r9.putExtra("mac", r4);
        L28:
            LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r9);
        L30:
            return Unit.INSTANCE;
        L15:
            r2 = false;
            goto L21
        L14:
            if (r7.isEmpty() == false) goto L16;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r5 = this.$delayTime;
            this.label = 1;
            if (DelayKt.delay(r5, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$connect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel", f = "DoraDeviceSettingsViewModel.kt", i = {0, 1, 2}, l = {634, 663, 667}, m = "connect", n = {"device", "device", "device"}, s = {"L$0", "L$0", "L$0"})
    public static final class C02051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02051(DoraDeviceSettingsViewModel r1, Continuation<? super C02051> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.connect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$connectAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$connectAsync$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02061(DoraDevice r1, DoraDeviceSettingsViewModel r2, Continuation<? super C02061> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02061(this.$device, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            DoraDevice r3 = this.$device;
            if (r3 == null) goto L8;
            this.this$0.handleConnectRequest(r3.mac);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public interface d {

        public static final class a implements d {
            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L8;
                return false;
            L8:
                ((a) r4).getClass();
                if (Intrinsics.areEqual(null, null) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                throw null;
            }

            public final String toString() {
                return "BindAndConnectStatus(result=null, device=null)";
            }
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$disconnectSpp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$disconnectSpp$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {843, 846}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02071(DoraDeviceSettingsViewModel r1, Continuation<? super C02071> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02071(this.this$0, r3);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L20:
            Unit r6 = Unit.INSTANCE;
        L22:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            goto L22
        L10:
            ResultKt.throwOnFailure(r5);
            e r7 = (e) DoraDeviceSettingsViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r7 instanceof e.a) == false) goto L15;
            kj4.a r2 = kj4.a.g();
            DoraDevice r8 = ((e.a) r7).b;
            this.label = 1;
            if (DoraAdapterExtKt.e(r2, r8) != r0) goto L22;
            return r0;
        L15:
            DoraDevice r9 = DoraAdapterExtKt.h(kj4.a.g());
            if (r9 == null) goto L22;
            kj4.a r3 = kj4.a.g();
            this.label = 2;
            if (DoraAdapterExtKt.e(r3, r9) != r0) goto L20;
            return r0;
        }
    }

    public interface e {

        public static final class a implements e {
            public final long a;
            public final DoraDevice b;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof a) == true) goto L8;
                return false;
            L8:
                a r9 = (a) r8;
                if (this.a == r9.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Connected(seq=" + this.a + ", device=" + this.b + ')';
            }

            public a(long r2, DoraDevice r4) {
                Intrinsics.checkNotNullParameter(r4, "device");
                this.a = r2;
                this.b = r4;
            }
        }

        public static final class b implements e {
            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L8;
                return false;
            L8:
                ((b) r4).getClass();
                if (Intrinsics.areEqual(null, null) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return 38347;
            }

            public final String toString() {
                return "Connecting(isRetrying=false, lastConnectedDevice=null)";
            }
        }

        public static final class c implements e {
            public final boolean a;
            public final z49.b b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                if (this.a == false) goto L5;
                int r0 = 1231;
            L6:
                int r1 = r0 * 31;
                z49.b r2 = this.b;
                if (r2 != null) goto L9;
                int r3 = 0;
            L11:
                return r1 + r3;
            L9:
                r3 = r2.hashCode();
                goto L11
            L5:
                r0 = 1237;
                goto L6
            }

            public final String toString() {
                return "Disconnected(isRetrying=" + this.a + ", lastConnectedDevice=" + this.b + ')';
            }

            public c(z49.b r2) {
                this.a = false;
                this.b = r2;
            }
        }

        public static final class d implements e {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }
    }

    public interface f {

        public static final class a implements f {
            public final DoraDevice a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                DoraDevice r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "CONNECTED(device=" + this.a + ')';
            }

            public a(DoraDevice r1) {
                this.a = r1;
            }
        }

        public static final class b implements f {
            public final DoraDevice a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                DoraDevice r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "CONNECTING(device=" + this.a + ')';
            }

            public b(DoraDevice r1) {
                this.a = r1;
            }
        }

        public static final class c implements f {
            public final DoraDevice a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                DoraDevice r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "DISCONNECTED(device=" + this.a + ')';
            }

            public c(DoraDevice r1) {
                this.a = r1;
            }
        }

        public static final class d implements f {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OnlyConnectResult.values().length];
            r0[OnlyConnectResult.CONNECT_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r0[OnlyConnectResult.CONNECT_TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L42:
            r0[OnlyConnectResult.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L8:
            a = r0;
            int[] r1 = new int[BindAndConnectResult.values().length];
            r1[BindAndConnectResult.SERVER_BIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L34:
            r1[BindAndConnectResult.SERVER_BIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            r1[BindAndConnectResult.SERVER_BIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L28:
            r1[BindAndConnectResult.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L36:
            r1[BindAndConnectResult.CONNECT_TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L30:
            r1[BindAndConnectResult.SERVER_BIND_NEED_UNBIND.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L38:
            r1[BindAndConnectResult.SUCCESS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L16:
            b = r1;
        }
    }

    public static final class h implements com.larus.dora.impl.dynamic.loader.d.b {
        public final /* synthetic */ DoraDeviceSettingsViewModel a;
        public final /* synthetic */ z49.b b;
        public final /* synthetic */ boolean c;

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void a() {
            FLogger.a.i("DoraDynamicViewModelV2", "fetchData card list onInvalid");
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void b(c59.z r4) {
            Intrinsics.checkNotNullParameter(r4, "pageNode");
            DoraDeviceSettingsViewModel.access$get_pageInfoData$p(this.a).postValue(c59.a0.b(r4));     // Catch: Throwable -> L9
            DoraDeviceSettingsViewModel.access$updateCardContext(this.a, this.b);     // Catch: Throwable -> L9
            DoraDeviceSettingsViewModel r5 = this.a;     // Catch: Throwable -> L9
            if (this.c == false) goto L6;
            b r0 = new b.a(this.b.c());     // Catch: Throwable -> L9
        L7:
            r5.updateConnectState(r0);     // Catch: Throwable -> L9
            return;
        L6:
            r0 = new b.c(this.b.c());     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            FLogger.a.e("DoraDynamicViewModelV2", "fetchData onSuccess, error is " + th.getMessage());
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void onFail(String r4) {
            FLogger.a.e("DoraDynamicViewModelV2", "fetchData onFail, msg is " + r4);
        }

        public h(DoraDeviceSettingsViewModel r1, z49.b r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$handleConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$handleConnectRequest$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {343, 348, 350}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02081(DoraDeviceSettingsViewModel r1, String r2, Continuation<? super C02081> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02081(this.this$0, this.$mac, r4);
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
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L29
        L31:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L29
        L17:
            DoraDevice r11 = (DoraDevice) r10;     // Catch: Exception -> L29
            if (r11 != null) goto L20;
            t19.s r12 = t19.s.a;     // Catch: Exception -> L29
            Application r2 = AppHost.a.getApplication();     // Catch: Exception -> L29
            r12.getClass();     // Catch: Exception -> L29
            t19.s.b(r2, 2131903672, false);     // Catch: Exception -> L29
            this.this$0.get_connectionState().setValue(new e59.b.c(this.$mac));     // Catch: Exception -> L29
            goto L31
        L20:
            if (o59.a.p(r11) == false) goto L24;
            DoraDeviceSettingsViewModel r3 = this.this$0;     // Catch: Exception -> L29
            this.label = 2;     // Catch: Exception -> L29
            if (DoraDeviceSettingsViewModel.access$handleGConnectRequest(r3, r11, this) != r0) goto L31;
            return r0;
        L24:
            DoraDeviceSettingsViewModel r4 = this.this$0;     // Catch: Exception -> L29
            this.label = 3;     // Catch: Exception -> L29
            if (DoraDeviceSettingsViewModel.access$handleNotGConnectRequest(r4, r11, this) != r0) goto L31;
            return r0;
        L13:
            ResultKt.throwOnFailure(r10);
            this.this$0.get_connectionState().setValue(new e59.b.C0125b(this.$mac));
            CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Exception -> L29
            DoraDeviceSettingsViewModel$handleConnectRequest$1$device$1 r5 = new DoraDeviceSettingsViewModel$handleConnectRequest$1$device$1(this.$mac, null);     // Catch: Exception -> L29
            this.label = 1;     // Catch: Exception -> L29
            r10 = BuildersKt.withContext(r13, r5, this);     // Catch: Exception -> L29
            if (r10 != r0) goto L17;
            return r0;
        L29:
            t19.s r14 = t19.s.a;
            Application r6 = AppHost.a.getApplication();
            r14.getClass();
            t19.s.b(r6, 2131903672, false);
            this.this$0.get_connectionState().setValue(new e59.b.c(this.$mac));
            goto L31
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$handleGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel", f = "DoraDeviceSettingsViewModel.kt", i = {0, 1, 2}, l = {373, 398, 405}, m = "handleGConnectRequest", n = {"device", "device", "device"}, s = {"L$0", "L$0", "L$0"})
    public static final class C02091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02091(DoraDeviceSettingsViewModel r1, Continuation<? super C02091> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraDeviceSettingsViewModel.access$handleGConnectRequest(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$handleGConnectRequest$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$handleGConnectRequest$2", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {406, 419, 428}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public AnonymousClass2(DoraDeviceSettingsViewModel r1, DoraDevice r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r12);
        L33:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r12);
        L25:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r12);
        L15:
            DoraDevice r13 = (DoraDevice) r12;
            if (r13 != null) goto L19;
            g49.d.d("DoraDynamicViewModelV2", "connect request, scan new device info error");
            return Unit.INSTANCE;
        L19:
            DoraDevice r4 = this.$device;
            r4.mode = r13.mode;
            r4.version = r13.version;
            if (o59.a.v(r4) == true) goto L27;
            g49.d.d("DoraDynamicViewModelV2", "connect request, this device don't sup factory, connect spp ");
            DoraDeviceSettingsViewModel r14 = this.this$0;
            DoraDevice r2 = this.$device;
            this.label = 2;
            if (r14.onlyConnect(r2, this) != r0) goto L25;
            return r0;
        L27:
            if (this.$device.isFactory() == false) goto L29;
            g49.d.d("DoraDynamicViewModelV2", "connect request, device is factory, replace bind it");
            this.this$0.replaceBind(this.$device);
            goto L33
        L29:
            MutableSharedFlow<c> r15 = this.this$0.get_deviceIntentSharedFlow();
            c.b r3 = new c.b(this.$device);
            this.label = 3;
            if (r15.emit(r3, this) != r0) goto L33;
            return r0;
        L12:
            ResultKt.throwOnFailure(r12);
            DoraDeviceSettingsViewModel r16 = this.this$0;
            DoraDevice r5 = this.$device;
            this.label = 1;
            r12 = DoraDeviceSettingsViewModel.scanBleInfo$default(r16, r5, 0, this, 2, null);
            if (r12 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$handleNotGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel", f = "DoraDeviceSettingsViewModel.kt", i = {0}, l = {493}, m = "handleNotGConnectRequest", n = {"device"}, s = {"L$0"})
    public static final class C02101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02101(DoraDeviceSettingsViewModel r1, Continuation<? super C02101> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraDeviceSettingsViewModel.access$handleNotGConnectRequest(this.this$0, null, this);
        }
    }

    public static final class i extends ScanCallback {
        public final /* synthetic */ CompletableDeferred<Unit> a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> d;

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.d("DoraDynamicViewModelV2", "connect request, scan failed, err: " + r3);
            this.a.complete(Unit.INSTANCE);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r2, ScanResult r3) {
            if (this.b == false) goto L5;
            DoraDevice r4 = kj4.a.g().convertScanResultToDoraDeviceV2(r3);
        L6:
            g49.d.d("DoraDynamicViewModelV2", "connect request, new scan result: " + r4);
            if (r4 == null) goto L9;
            String r5 = r4.mac;
        L11:
            if (Intrinsics.areEqual(r5, this.c) == false) goto L14;
            this.d.element = r4;
            kj4.a.g().stopScan(this);
            this.a.complete(Unit.INSTANCE);
            return;
        L14:
            return;
        L9:
            r5 = null;
            goto L11
        L5:
            r4 = kj4.a.g().convertScanResultToDoraDevice(r3);
            goto L6
        }

        public i(CompletableDeferred<Unit> r1, boolean r2, String r3, Ref.ObjectRef<DoraDevice> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class j implements ScreenStateManager.b {
        public final /* synthetic */ DoraDeviceSettingsViewModel a;

        public final void onScreenOff() {
            g49.d.d("DoraDynamicViewModelV2", "onScreenOff");
            this.a.setScreenOn(false);
        }

        public final void onScreenOn() {
            g49.d.d("DoraDynamicViewModelV2", "onScreenOn");
            this.a.setScreenOn(true);
        }

        public final void onUserPresent() {
            g49.d.d("DoraDynamicViewModelV2", "onUserPresent");
            this.a.setScreenOn(true);
        }

        public j(DoraDeviceSettingsViewModel r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$loadLabSettingConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$loadLabSettingConfig$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {932}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C02111(Continuation<? super C02111> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02111(r2);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            DoraFeature r5 = DoraFeature.a;
            this.label = 1;
            if (r5.b(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$onAction$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$onAction$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e59.e $action;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02121(DoraDeviceSettingsViewModel r1, e59.e r2, Continuation<? super C02121> r3) {
            this.this$0 = r1;
            this.$action = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02121(this.this$0, this.$action, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableSharedFlow<c> r6 = this.this$0.get_deviceIntentSharedFlow();
            c.a r2 = new c.a(((e59.e.a) this.$action).a);
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$onlyConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel", f = "DoraDeviceSettingsViewModel.kt", i = {0, 1, 2}, l = {595, 602, 609}, m = "onlyConnect", n = {"device", "device", "device"}, s = {"L$0", "L$0", "L$0"})
    public static final class C02131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02131(DoraDeviceSettingsViewModel r1, Continuation<? super C02131> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onlyConnect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$onlyLocalUnbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$onlyLocalUnbind$1", f = "DoraDeviceSettingsViewModel.kt", i = {2}, l = {877, 882, 886, 892}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class C02141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ z49.b $simpleDevice;
        Object L$0;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$onlyLocalUnbind$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$onlyLocalUnbind$1$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {887}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            final /* synthetic */ DoraDevice $device;
            int label;

            public C00371(DoraDevice r1, Continuation<? super C00371> r2) {
                this.$device = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00371(this.$device, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L11:
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                kj4.a r5 = kj4.a.g();
                DoraDevice r2 = this.$device;
                this.label = 1;
                r4 = DoraAdapterExtKt.f(r5, r2);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        public C02141(DoraDeviceSettingsViewModel r1, z49.b r2, Continuation<? super C02141> r3) {
            this.this$0 = r1;
            this.$simpleDevice = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02141(this.this$0, this.$simpleDevice, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r9);
        L31:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            DoraDevice r2 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r9);
        L27:
            MutableSharedFlow r10 = DoraDeviceSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r3 = new Pair(IntentState.ACTION_UNBIND_SUCCESS, r2);
            this.L$0 = null;
            this.label = 4;
            if (r10.emit(r3, this) != r0) goto L31;
            return r0;
        L12:
            ResultKt.throwOnFailure(r9);
        L22:
            g49.d.d("DoraDynamicViewModelV2", "onlyLocalUnbind device is null, nothing todo, return");
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r9);
        L17:
            r2 = (DoraDevice) r9;
            if (r2 != null) goto L24;
            MutableSharedFlow r11 = DoraDeviceSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r4 = new Pair(IntentState.ACTION_NO_DEVICE_CONNECTED, null);
            this.label = 2;
            if (r11.emit(r4, this) != r0) goto L22;
            return r0;
        L24:
            CoroutineDispatcher r12 = Dispatchers.getIO();
            C00371 r5 = new C00371(r2, null);
            this.L$0 = r2;
            this.label = 3;
            if (BuildersKt.withContext(r12, r5, this) != r0) goto L27;
            return r0;
        L14:
            ResultKt.throwOnFailure(r9);
            CoroutineDispatcher r13 = Dispatchers.getIO();
            DoraDeviceSettingsViewModel$onlyLocalUnbind$1$device$1 r6 = new DoraDeviceSettingsViewModel$onlyLocalUnbind$1$device$1(this.$simpleDevice, null);
            this.label = 1;
            r9 = BuildersKt.withContext(r13, r6, this);
            if (r9 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$replaceBind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$replaceBind$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {819, 823}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02151(DoraDevice r1, DoraDeviceSettingsViewModel r2, Continuation<? super C02151> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02151(this.$device, this.this$0, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r11);
        L23:
            Object r12 = r2;
        L25:
            DoraDeviceSettingsViewModel r3 = this.this$0;
            DoraDevice r4 = this.$device;
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L29;
            g49.d.c("DoraDynamicViewModelV2", "replaceBind: failure exception", r13);
            r3.updateUi(new f.c(r4));
            t19.s r14 = t19.s.a;
            Application r5 = AppHost.a.getApplication();
            r14.getClass();
            t19.s.b(r5, 2131908080, false);
        L29:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
            r12 = ((Result) r11).unbox-impl();
        L13:
            DoraDeviceSettingsViewModel r6 = this.this$0;
            DoraDevice r7 = this.$device;
            if (Result.isSuccess-impl(r12) == false) goto L25;
            int r8 = ((Number) r12).intValue();
            g49.d.d("DoraDynamicViewModelV2", "replaceBind: replaceBindCode=" + r8);
            Object r9 = DoraDeviceSettingsViewModel.access$get_deviceStateFlow$p(r6).getValue();
            if ((r9 instanceof e.a) == false) goto L18;
            e.a r10 = (e.a) r9;
        L18:
            if (r8 != 1) goto L24;
            kj4.a r15 = kj4.a.g();
            this.L$0 = r12;
            this.label = 2;
            if (DoraAdapterExtKt.b(r15) != r0) goto L22;
            return r0;
        L22:
            r2 = r12;
            goto L23
        L24:
            g49.d.b("DoraDynamicViewModelV2", "replaceBind: failure replaceBindCode:" + r8);
            r6.updateUi(new f.c(r7));
            t19.s r16 = t19.s.a;
            Application r17 = AppHost.a.getApplication();
            r16.getClass();
            t19.s.b(r17, 2131904024, false);
            Unit r18 = Unit.INSTANCE;
            goto L25
        L10:
            ResultKt.throwOnFailure(r11);
            DoraNetworkApi r110 = DoraNetworkApi.a;
            DoraDevice r20 = this.$device;
            this.label = 1;
            r12 = r110.w(r20, this);
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$scanBleInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel", f = "DoraDeviceSettingsViewModel.kt", i = {0, 0, 0}, l = {485}, m = "scanBleInfo", n = {"newDevice", "scanCallback", "startScanTs"}, s = {"L$0", "L$1", "J$0"})
    public static final class C02161 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02161(DoraDeviceSettingsViewModel r1, Continuation<? super C02161> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return DoraDeviceSettingsViewModel.access$scanBleInfo(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$scanBleInfo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$scanBleInfo$2", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {485}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $done;
        int label;

        public C02172(CompletableDeferred<Unit> r1, Continuation<? super C02172> r2) {
            this.$done = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02172(this.$done, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CompletableDeferred<Unit> r5 = this.$done;
            this.label = 1;
            if (r5.await(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$unbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$unbind$1", f = "DoraDeviceSettingsViewModel.kt", i = {1}, l = {901, 905, 907, 916, 920, 924}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class C02181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ z49.b $simpleDevice;
        Object L$0;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$unbind$1$a */
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

        public C02181(DoraDeviceSettingsViewModel r1, z49.b r2, Continuation<? super C02181> r3) {
            this.this$0 = r1;
            this.$simpleDevice = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02181(this.this$0, this.$simpleDevice, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L9;
                case 1: goto L8;
                case 2: goto L7;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r9);
        L53:
            return Unit.INSTANCE;
        L7:
            DoraDevice r1 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r9);
        L30:
            int r10 = a.a[((UnbindAndResetResult) r9).ordinal()];
            if (r10 != 1) goto L33;
            MutableSharedFlow r11 = DoraDeviceSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r2 = new Pair(IntentState.ACTION_SERVER_UNBIND_NETWORK_ERROR, r1);
            this.L$0 = null;
            this.label = 3;
            if (r11.emit(r2, this) != r0) goto L53;
            return r0;
        L33:
            if (r10 == 2) goto L46;
            if (r10 == 3) goto L46;
            if (r10 == 4) goto L43;
            if (r10 != 5) goto L42;
            MutableSharedFlow r12 = DoraDeviceSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r3 = new Pair(IntentState.ACTION_SPP_DISCONNECT_FAILED, r1);
            this.L$0 = null;
            this.label = 6;
            if (r12.emit(r3, this) != r0) goto L53;
            return r0;
        L42:
            throw new NoWhenBranchMatchedException();
        L43:
            MutableSharedFlow r13 = DoraDeviceSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r4 = new Pair(IntentState.ACTION_UNBIND_SUCCESS, r1);
            this.L$0 = null;
            this.label = 5;
            if (r13.emit(r4, this) != r0) goto L53;
            return r0;
        L46:
            MutableSharedFlow r14 = DoraDeviceSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r5 = new Pair(IntentState.ACTION_SERVER_UNBIND_FAILED, r1);
            this.L$0 = null;
            this.label = 4;
            if (r14.emit(r5, this) != r0) goto L53;
            return r0;
        L8:
            ResultKt.throwOnFailure(r9);
        L26:
            return Unit.INSTANCE;
        L9:
            ResultKt.throwOnFailure(r9);
            List r15 = DoraAdapterExtKt.k(kj4.a.g());
            z49.b r6 = this.$simpleDevice;
            Iterator r16 = r15.iterator();
        L11:
            if (r16.hasNext() == false) goto L19;
            Object r7 = r16.next();
            String r8 = ((DoraDevice) r7).mac;
            if (r6 == null) goto L15;
            String r17 = r6.c();
        L17:
            if (Intrinsics.areEqual(r8, r17) == false) goto L11;
        L20:
            r1 = (DoraDevice) r7;
            if (r1 != null) goto L27;
            MutableSharedFlow r18 = DoraDeviceSettingsViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r20 = new Pair(IntentState.ACTION_NO_DEVICE_CONNECTED, null);
            this.label = 1;
            if (r18.emit(r20, this) != r0) goto L26;
            return r0;
        L27:
            kj4.a r21 = kj4.a.g();
            this.L$0 = r1;
            this.label = 2;
            r9 = DoraAdapterExtKt.C(r21, r1, this);
            if (r9 != r0) goto L30;
            return r0;
        L15:
            r17 = null;
            goto L17
        L19:
            r7 = null;
            goto L20
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$updateConnectState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$updateConnectState$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e59.b $connectionState;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02191(DoraDeviceSettingsViewModel r1, e59.b r2, Continuation<? super C02191> r3) {
            this.this$0 = r1;
            this.$connectionState = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02191(this.this$0, this.$connectionState, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.get_connectionState().setValue(this.$connectionState);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$updateUi$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel$updateUi$1", f = "DoraDeviceSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ f $uiState;
        int label;
        final /* synthetic */ DoraDeviceSettingsViewModel this$0;

        public C02201(f r1, DoraDeviceSettingsViewModel r2, Continuation<? super C02201> r3) {
            this.$uiState = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02201(this.$uiState, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r4);
            f r5 = this.$uiState;
            String r1 = null;
            if ((r5 instanceof f.b) == false) goto L11;
            MutableLiveData<e59.b> r6 = this.this$0.get_connectionState();
            DoraDevice r2 = ((f.b) this.$uiState).a;
            if (r2 == null) goto L9;
            r1 = r2.mac;
        L9:
            r6.setValue(new e59.b.C0125b(r1));
        L26:
            return Unit.INSTANCE;
        L11:
            if ((r5 instanceof f.a) == false) goto L17;
            MutableLiveData<e59.b> r7 = this.this$0.get_connectionState();
            DoraDevice r3 = ((f.a) this.$uiState).a;
            if (r3 == null) goto L15;
            r1 = r3.mac;
        L15:
            r7.setValue(new e59.b.a(r1));
            goto L26
        L17:
            if ((r5 instanceof f.c) == false) goto L23;
            MutableLiveData<e59.b> r8 = this.this$0.get_connectionState();
            DoraDevice r9 = ((f.c) this.$uiState).a;
            if (r9 == null) goto L21;
            r1 = r9.mac;
        L21:
            r8.setValue(new e59.b.c(r1));
            goto L26
        L23:
            if (Intrinsics.areEqual(r5, f.d.a) == false) goto L28;
            this.this$0.get_connectionState().setValue(e59.b.d.a);
            goto L26
        L28:
            throw new NoWhenBranchMatchedException();
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    private final c59.i createFeedbackCard() {
        return new c59.i(DslTemplateType.GENERAL_GROUP, MapsKt.mapOf(TuplesKt.to("items", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("title", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "string_type"), TuplesKt.to("value", "dora_g_feedback_title_cn")})), TuplesKt.to("action", MapsKt.mapOf(new Pair[]{TuplesKt.to("action_url", "sslocal://flow/dora_g_feedback"), TuplesKt.to("action_type", "internal_jump")})), TuplesKt.to("right_icon", "arrow")})))));
    }

    public final void disconnectSpp() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C02071(this, null), 2, null);
    }

    public DoraDeviceSettingsViewModel() {
        MutableSharedFlow<d> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceBindStatusFlow = r3;
        this.deviceBindStatusFlow = r3;
        MutableSharedFlow<c> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceIntentSharedFlow = r4;
        this.deviceIntentSharedFlow = r4;
        MutableLiveData<c59.m> r5 = new MutableLiveData();
        this._pageInfoData = r5;
        this.pageInfoData = r5;
        MutableLiveData<d59.b> r6 = new MutableLiveData();
        this._cardContextData = r6;
        this.cardContextData = r6;
        StateFlowImpl r7 = j1.a(e.d.a);
        this._deviceStateFlow = r7;
        this.deviceStateFlow = r7;
        MutableLiveData<e59.d> r8 = new MutableLiveData();
        this._dialogEvent = r8;
        this.dialogEvent = r8;
        MutableLiveData<e59.f> r9 = new MutableLiveData();
        this._viewHolderEvent = r9;
        this.viewHolderEvent = r9;
        MutableLiveData<e59.b> r10 = new MutableLiveData(e59.b.d.a);
        this._connectionState = r10;
        this.connectionState = r10;
        MutableSharedFlow<Pair<IntentState, DoraDevice>> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._unbindStateFlow = r0;
        this.unbindStateFlow = r0;
        this.dataLoader = new com.larus.dora.impl.dynamic.loader.d();
        this.isScreenOn = true;
        j r1 = new j(this);
        this.screenListener = r1;
        IDoraLinkCallback r2 = new DoraDeviceSettingsViewModel$doraLinkCallback$1(this);
        this.doraLinkCallback = r2;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        DoraDevice r11 = DoraAdapterExtKt.h(kj4.a.g());
        if (r11 == null) goto L5;
        checkBindState(r11);
    L5:
        loadLabSettingConfig();
        kj4.a.g().registerDoraLinkCallback(r2);
        ScreenStateManager r12 = ScreenStateManager.a;
        ScreenStateManager.a(r1);
    }

    private final void loadLabSettingConfig() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02111(null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        g49.d.d("DoraDynamicViewModelV2", this + " onCleared");
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
        ScreenStateManager r0 = ScreenStateManager.a;
        ScreenStateManager.a(this.screenListener);
    }

    public final LiveData<d59.b> getCardContextData() {
        return this.cardContextData;
    }

    public final Job getConnectingJob() {
        return this.connectingJob;
    }

    public final LiveData<e59.b> getConnectionState() {
        return this.connectionState;
    }

    public final d1<d> getDeviceBindStatusFlow() {
        return this.deviceBindStatusFlow;
    }

    public final d1<c> getDeviceIntentSharedFlow() {
        return this.deviceIntentSharedFlow;
    }

    public final i1<e> getDeviceStateFlow() {
        return this.deviceStateFlow;
    }

    public final LiveData<e59.d> getDialogEvent() {
        return this.dialogEvent;
    }

    public final LiveData<c59.m> getPageInfoData() {
        return this.pageInfoData;
    }

    public final d1<Pair<IntentState, DoraDevice>> getUnbindStateFlow() {
        return this.unbindStateFlow;
    }

    public final LiveData<e59.f> getViewHolderEvent() {
        return this.viewHolderEvent;
    }

    public final MutableLiveData<e59.b> get_connectionState() {
        return this._connectionState;
    }

    public final MutableSharedFlow<c> get_deviceIntentSharedFlow() {
        return this._deviceIntentSharedFlow;
    }

    public final boolean isScreenOn() {
        return this.isScreenOn;
    }

    public static final /* synthetic */ long access$getDeviceStateSeq$p(DoraDeviceSettingsViewModel r2) {
        return r2.deviceStateSeq;
    }

    public static final /* synthetic */ z0 access$get_deviceStateFlow$p(DoraDeviceSettingsViewModel r0) {
        return r0._deviceStateFlow;
    }

    public static final /* synthetic */ MutableLiveData access$get_pageInfoData$p(DoraDeviceSettingsViewModel r0) {
        return r0._pageInfoData;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_unbindStateFlow$p(DoraDeviceSettingsViewModel r0) {
        return r0._unbindStateFlow;
    }

    private final boolean isV2BleAdvertisementDevice(DoraDevice r3) {
        int r0 = r3.productId;
        if (r0 != ProductNameType.DORA_G2.id) goto L5;
    L12:
        return true;
    L5:
        if (r0 == ProductNameType.DORA_G_AIR.id) goto L12;
        int r4 = r3.type;
        if (r4 == 17) goto L12;
        if (r4 == 18) goto L12;
        return false;
    }

    private final void updateCardContext(z49.b r6) {
        DoraDevice r0 = DoraAdapterExtKt.i(kj4.a.g(), false);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("updateCardContext: simpleMac=");
        r2.append(r6.c());
        r2.append(", currentMac=");
        String r3 = null;
        if (r0 == null) goto L5;
        String r4 = r0.mac;
    L6:
        r2.append(r4);
        r2.append(", simpleAndroidOSVersion=");
        DoraDevice r5 = r6.a;
        if (r5 == null) goto L9;
        String r7 = r5.androidOSVersion;
    L10:
        r2.append(r7);
        r2.append(", currentAndroidOSVersion=");
        if (r0 == null) goto L13;
        String r8 = r0.androidOSVersion;
    L14:
        r2.append(r8);
        r1.i("DoraDynamicViewModelV2", r2.toString());
        if (r0 == null) goto L18;
        r3 = r0.mac;
    L18:
        if (Intrinsics.areEqual(r3, r6.c()) == false) goto L21;
        r6 = z49.b.a(r6, r0);
    L25:
        this._cardContextData.postValue(new d59.b(r6, DoraAdapterExtKt.k(kj4.a.g()), d0.a(), ""));
        return;
    L21:
        if ((this._deviceStateFlow.getValue() instanceof e.a) == false) goto L25;
        Object r9 = this._deviceStateFlow.getValue();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsViewModel.DeviceStateV2.Connected");
        DoraDevice r10 = ((e.a) r9).b;
        r1.e("DoraDynamicViewModelV2", "connectDevice: " + r10);
        if (Intrinsics.areEqual(r6.c(), r10.mac) == false) goto L25;
        r6 = z49.b.a(r6, r10);
        goto L25
    L13:
        r8 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public void checkBindState(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02031(this, r8, null), 2, null);
    }

    public final void connectAsync(DoraDevice r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C02061(r7, this, null), 2, null);
    }

    public void handleConnectRequest(String r10) {
        Job r0 = this.connectingJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.connectingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02081(this, r10, null), 3, null);
    }

    @Override // e59.a
    public void onAction(e59.e r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        if ((r8 instanceof e59.e.a) == false) goto L6;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02121(this, r8, null), 3, null);
        return;
    L6:
        if ((r8 instanceof e59.e.d) == false) goto L9;
        e59.e.d r9 = (e59.e.d) r8;
        this._dialogEvent.setValue(new e59.d.a(r9.a, r9.b, r9.c));
        return;
    L9:
        if ((r8 instanceof e59.e.c) == false) goto L12;
        this._viewHolderEvent.setValue(new e59.f.a(((e59.e.c) r8).a));
        return;
    L12:
        if ((r8 instanceof e59.e.b) == false) goto L16;
        MutableLiveData<e59.b> r10 = this._connectionState;
        r10.postValue(r10.getValue());
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void onlyLocalUnbind(z49.b r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02141(this, r7, null), 3, null);
    }

    public final void replaceBind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C02151(r8, this, null), 2, null);
    }

    public final void setConnectingJob(Job r1) {
        this.connectingJob = r1;
    }

    public final void setScreenOn(boolean r1) {
        this.isScreenOn = r1;
    }

    public final void unbind(z49.b r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C02181(this, r7, null), 2, null);
    }

    public final void updateConnectState(b r9) {
        Intrinsics.checkNotNullParameter(r9, "status");
        boolean r0 = r9 instanceof b.a;
        FLogger.a.e("DoraDynamicViewModelV2", "updateConnectState, connected is " + r0);
        if (r0 == false) goto L6;
        e59.b r1 = new e59.b.a(((b.a) r9).a);
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02191(this, r1, null), 3, null);
        return;
    L6:
        if ((r9 instanceof b.C0035b) == false) goto L9;
        ((b.C0035b) r9).getClass();
        r1 = new e59.b.C0125b(null);
        goto L11
    L9:
        if ((r9 instanceof b.c) == false) goto L14;
        r1 = new e59.b.c(((b.c) r9).a);
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void updateRemoveBarData(String r7) {
        Intrinsics.checkNotNullParameter(r7, "mac");
        d59.b r0 = (d59.b) this.cardContextData.getValue();
        if (r0 == null) goto L28;
        List<? extends DoraDevice> r1 = r0.b;
        Integer r2 = null;
        if (r1 == null) goto L12;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        Object r5 = r4.next();
        if ((!Intrinsics.areEqual(((DoraDevice) r5).mac, r7)) == false) goto L8;
        r3.add(r5);
    L13:
        List<? extends DoraDevice> r8 = r0.b;
        if (r8 == null) goto L16;
        Integer r9 = Integer.valueOf(r8.size());
    L17:
        if (r3 == null) goto L20;
        r2 = Integer.valueOf(r3.size());
    L20:
        if (Intrinsics.areEqual(r9, r2) == true) goto L29;
        this._cardContextData.postValue(d59.b.a(r0, r3));
        return;
    L29:
        return;
    L16:
        r9 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    }

    public final void updateUi(f r8) {
        Intrinsics.checkNotNullParameter(r8, "uiState");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02201(r8, this, null), 3, null);
    }

    public static final /* synthetic */ void access$setDeviceStateSeq$p(DoraDeviceSettingsViewModel r0, long r1) {
        r0.deviceStateSeq = r1;
    }

    public static final /* synthetic */ void access$updateCardContext(DoraDeviceSettingsViewModel r0, z49.b r1) {
        r0.updateCardContext(r1);
    }

    private final Object handleGConnectRequest(DoraDevice r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C02091) == false) goto L7;
        C02091 r0 = (C02091) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L18;
        if (r3 != 3) goto L17;
        DoraDevice r13 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L47
    L49:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        DoraDevice r14 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L47
    L43:
        return Unit.INSTANCE;
    L21:
        r10 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L47
    L28:
        OnlyBindResult r15 = (OnlyBindResult) r12;     // Catch: Throwable -> L47
        if (CollectionsKt.listOf(new OnlyBindResult[]{OnlyBindResult.SERVER_BIND_NETWORK_ERROR, OnlyBindResult.SERVER_BIND_UNKNOWN}).contains(r15) == false) goto L33;
        t19.s r16 = t19.s.a;     // Catch: Throwable -> L47
        Application r4 = AppHost.a.getApplication();     // Catch: Throwable -> L47
        r16.getClass();     // Catch: Throwable -> L47
        t19.s.b(r4, 2131908080, false);     // Catch: Throwable -> L47
        updateUi(new f.c(r10));     // Catch: Throwable -> L47
        return Unit.INSTANCE;
    L33:
        if (r15 != OnlyBindResult.SERVER_BIND_FAILED) goto L38;
        t19.s r17 = t19.s.a;     // Catch: Throwable -> L47
        AppHost.Companion r5 = AppHost.a;     // Catch: Throwable -> L47
        Application r6 = r5.getApplication();     // Catch: Throwable -> L47
        String r7 = r5.getApplication().getString(2131903938, new Object[]{o59.a.g(r10)});     // Catch: Throwable -> L47
        r17.getClass();     // Catch: Throwable -> L47
        t19.s.c(r6, r7);     // Catch: Throwable -> L47
        updateUi(new f.c(r10));     // Catch: Throwable -> L47
        return Unit.INSTANCE;
    L38:
        if (r15 != OnlyBindResult.SUCCESS) goto L44;
        g49.d.d("DoraDynamicViewModelV2", "connect request, bind success, connect spp");     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 2;     // Catch: Throwable -> L47
        if (onlyConnect(r10, r0) != r2) goto L43;
        return r2;
    L44:
        g49.d.d("DoraDynamicViewModelV2", "cur device need unbind ");     // Catch: Throwable -> L47
        CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Throwable -> L47
        AnonymousClass2 r8 = new AnonymousClass2(this, r10, null);     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 3;     // Catch: Throwable -> L47
        if (BuildersKt.withContext(r18, r8, r0) != r2) goto L49;
        return r2;
    L24:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L47
        DoraDeviceSettingsViewModel$handleGConnectRequest$bindResult$1 r9 = new DoraDeviceSettingsViewModel$handleGConnectRequest$bindResult$1(r10, null);     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 1;     // Catch: Throwable -> L47
        r12 = BuildersKt.withContext(r110, r9, r0);     // Catch: Throwable -> L47
        if (r12 != r2) goto L28;
        return r2;
    L47:
        t19.s r111 = t19.s.a;
        Application r20 = AppHost.a.getApplication();
        r111.getClass();
        t19.s.b(r20, 2131903672, false);
        this._connectionState.setValue(new e59.b.c(r10.mac));
    L7:
        r0 = new C02091(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object handleNotGConnectRequest(DoraDevice r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof C02101) == false) goto L7;
        C02101 r0 = (C02101) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        DoraDevice r8 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L20
        r5 = r8;
    L23:
    L22:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r5;     // Catch: Exception -> L20
        r0.label = 1;     // Catch: Exception -> L20
        Object r9 = connect(r5, r0);     // Catch: Exception -> L20
        r5 = r9;
        if (r9 != r2) goto L23;
        return r2;
    L20:
        t19.s r10 = t19.s.a;
        Application r4 = AppHost.a.getApplication();
        r10.getClass();
        t19.s.b(r4, 2131903672, false);
        this._connectionState.setValue(new e59.b.c(r5.mac));
    L7:
        r0 = new C02101(this, r6);
        goto L8
    }

    public final void checkLocalBindState(DoraDevice r7, long r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02041(r8, r7, null), 2, null);
    }

    public final Object connect(DoraDevice r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof C02051) == false) goto L7;
        C02051 r2 = (C02051) r14;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r15 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L17;
        r13 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L52
    L42:
        if (((Number) r15).intValue() != 2) goto L54;
        updateUi(new f.a(r13));     // Catch: Throwable -> L52
    L54:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        DoraDevice r16 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L52
        goto L54
    L21:
        r13 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L52
    L35:
        BindAndConnectResult r17 = (BindAndConnectResult) r15;     // Catch: Throwable -> L52
        g49.d.d("DoraDynamicViewModelV2", "connect: " + o59.a.h(r13) + " result = " + r17);     // Catch: Throwable -> L52
        switch(g.b[r17.ordinal()]) {
            case 1: goto L49;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L47;
            case 6: goto L44;
            case 7: goto L38;
            default: goto L51;
        };     // Catch: Throwable -> L52
    L38:
        CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Throwable -> L52
        DoraDeviceSettingsViewModel$connect$state$1 r0 = new DoraDeviceSettingsViewModel$connect$state$1(r13, null);     // Catch: Throwable -> L52
        r2.L$0 = r13;     // Catch: Throwable -> L52
        r2.label = 3;     // Catch: Throwable -> L52
        r15 = BuildersKt.withContext(r18, r0, r2);     // Catch: Throwable -> L52
        if (r15 != r4) goto L42;
        return r4;
    L44:
        MutableSharedFlow<c> r110 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L52
        c.b r1 = new c.b(r13);     // Catch: Throwable -> L52
        r2.L$0 = r13;     // Catch: Throwable -> L52
        r2.label = 2;     // Catch: Throwable -> L52
        if (r110.emit(r1, r2) != r4) goto L54;
        return r4;
    L47:
        t19.s r111 = t19.s.a;     // Catch: Throwable -> L52
        Application r6 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r111.getClass();     // Catch: Throwable -> L52
        t19.s.b(r6, 2131903672, false);     // Catch: Throwable -> L52
        updateUi(new f.c(r13));     // Catch: Throwable -> L52
        goto L54
    L48:
        t19.s r112 = t19.s.a;     // Catch: Throwable -> L52
        Application r7 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r112.getClass();     // Catch: Throwable -> L52
        t19.s.b(r7, 2131904024, false);     // Catch: Throwable -> L52
        updateUi(new f.c(r13));     // Catch: Throwable -> L52
        goto L54
    L49:
        t19.s r113 = t19.s.a;     // Catch: Throwable -> L52
        Application r8 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r113.getClass();     // Catch: Throwable -> L52
        t19.s.b(r8, 2131908080, false);     // Catch: Throwable -> L52
        updateUi(new f.c(r13));     // Catch: Throwable -> L52
        goto L54
    L51:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L52
    L24:
        ResultKt.throwOnFailure(r15);
        updateUi(new f.b(r13));
        StringBuilder r114 = new StringBuilder("start connect ");     // Catch: Throwable -> L52
        if (r13 == null) goto L28;
        String r9 = o59.a.h(r13);     // Catch: Throwable -> L52
    L29:
        r114.append(r9);     // Catch: Throwable -> L52
        g49.d.d("DoraDynamicViewModelV2", r114.toString());     // Catch: Throwable -> L52
        if (r13 != null) goto L32;
        t19.s r115 = t19.s.a;     // Catch: Throwable -> L52
        Application r10 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r115.getClass();     // Catch: Throwable -> L52
        t19.s.b(r10, 2131903672, false);     // Catch: Throwable -> L52
        updateUi(new f.c(r13));     // Catch: Throwable -> L52
        goto L54
    L32:
        CoroutineDispatcher r116 = Dispatchers.getIO();     // Catch: Throwable -> L52
        DoraDeviceSettingsViewModel$connect$connectResult$1 r11 = new DoraDeviceSettingsViewModel$connect$connectResult$1(r13, null);     // Catch: Throwable -> L52
        r2.L$0 = r13;     // Catch: Throwable -> L52
        r2.label = 1;     // Catch: Throwable -> L52
        r15 = BuildersKt.withContext(r116, r11, r2);     // Catch: Throwable -> L52
        if (r15 != r4) goto L35;
        return r4;
    L28:
        r9 = null;
    L52:
        updateUi(new f.c(r13));
    L7:
        r2 = new C02051(this, r14);
        goto L8
    }

    public final Object onlyConnect(DoraDevice r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof C02131) == false) goto L7;
        C02131 r2 = (C02131) r12;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r13 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L18;
        if (r5 != 3) goto L17;
        r11 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L52
    L43:
        if (((Number) r13).intValue() != 2) goto L54;
        updateUi(new f.a(r11));     // Catch: Throwable -> L52
    L54:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r11 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L52
    L50:
        updateUi(new f.c(r11));     // Catch: Throwable -> L52
        goto L54
    L21:
        r11 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L52
    L35:
        OnlyConnectResult r14 = (OnlyConnectResult) r13;     // Catch: Throwable -> L52
        g49.d.d("DoraDynamicViewModelV2", "only connect: " + o59.a.h(r11) + " result = " + r14);     // Catch: Throwable -> L52
        int r15 = g.a[r14.ordinal()];     // Catch: Throwable -> L52
        if (r15 == 1) goto L47;
        if (r15 == 2) goto L47;
        if (r15 != 3) goto L46;
        CoroutineDispatcher r16 = Dispatchers.getIO();     // Catch: Throwable -> L52
        DoraDeviceSettingsViewModel$onlyConnect$state$1 r0 = new DoraDeviceSettingsViewModel$onlyConnect$state$1(r11, null);     // Catch: Throwable -> L52
        r2.L$0 = r11;     // Catch: Throwable -> L52
        r2.label = 3;     // Catch: Throwable -> L52
        r13 = BuildersKt.withContext(r16, r0, r2);     // Catch: Throwable -> L52
        if (r13 != r4) goto L43;
        return r4;
    L46:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L52
    L47:
        MutableSharedFlow<c> r17 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L52
        c.C0036c r1 = new c.C0036c(r11);     // Catch: Throwable -> L52
        r2.L$0 = r11;     // Catch: Throwable -> L52
        r2.label = 2;     // Catch: Throwable -> L52
        if (r17.emit(r1, r2) != r4) goto L50;
        return r4;
    L24:
        ResultKt.throwOnFailure(r13);
        updateUi(new f.b(r11));
        StringBuilder r18 = new StringBuilder("start only connect ");     // Catch: Throwable -> L52
        if (r11 == null) goto L28;
        String r6 = o59.a.h(r11);     // Catch: Throwable -> L52
    L29:
        r18.append(r6);     // Catch: Throwable -> L52
        g49.d.d("DoraDynamicViewModelV2", r18.toString());     // Catch: Throwable -> L52
        if (r11 != null) goto L32;
        t19.s r110 = t19.s.a;     // Catch: Throwable -> L52
        Application r7 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r110.getClass();     // Catch: Throwable -> L52
        t19.s.b(r7, 2131903672, false);     // Catch: Throwable -> L52
        updateUi(new f.c(r11));     // Catch: Throwable -> L52
        goto L54
    L32:
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Throwable -> L52
        DoraDeviceSettingsViewModel$onlyConnect$connectResult$1 r8 = new DoraDeviceSettingsViewModel$onlyConnect$connectResult$1(r11, null);     // Catch: Throwable -> L52
        r2.L$0 = r11;     // Catch: Throwable -> L52
        r2.label = 1;     // Catch: Throwable -> L52
        r13 = BuildersKt.withContext(r111, r8, r2);     // Catch: Throwable -> L52
        if (r13 != r4) goto L35;
        return r4;
    L28:
        r6 = null;
    L52:
        updateUi(new f.c(r11));
    L7:
        r2 = new C02131(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object access$handleGConnectRequest(DoraDeviceSettingsViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.handleGConnectRequest(r1, r2);
    }

    public static final /* synthetic */ Object access$handleNotGConnectRequest(DoraDeviceSettingsViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.handleNotGConnectRequest(r1, r2);
    }

    private final Object scanBleInfo(DoraDevice r17, long r18, Continuation<? super DoraDevice> r20) {
        if ((r20 instanceof C02161) == false) goto L7;
        C02161 r2 = (C02161) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r6 = r2.J$0;
        i r0 = (i) r2.L$1;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L22:
        g49.d.d("DoraDynamicViewModelV2", "scan ble info cost: " + (System.currentTimeMillis() - r6));
        kj4.a.g().stopScan(r0);
        return r7.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r8 = r17.mac;
        boolean r9 = isV2BleAdvertisementDevice(r17);
        if (r9 == false) goto L17;
        List r10 = CollectionsKt.mutableListOf(new String[]{"00002010-0000-1000-8000-00805F9B34FB"});
    L18:
        long r11 = System.currentTimeMillis();
        CompletableDeferred r12 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        g49.d.d("DoraDynamicViewModelV2", "connect request, start scan ble info, productId=" + r17.productId + ", type=" + r17.type + ", isV2BleDevice=" + r9 + ", scanUuids=" + r10);
        r0 = new i(r12, r9, r8, r13);
        kj4.a.g().scan(r10, r0);
        C02172 r14 = new C02172(r12, null);
        r2.L$0 = r13;
        r2.L$1 = r0;
        r2.J$0 = r11;
        r2.label = 1;
        if (TimeoutKt.c(r18, r14, r2) != r4) goto L21;
        return r4;
    L21:
        r6 = r11;
        r7 = r13;
        goto L22
    L17:
        r10 = CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"});
    L7:
        r2 = new C02161(this, r20);
        goto L8
    }

    public static final /* synthetic */ Object access$scanBleInfo(DoraDeviceSettingsViewModel r0, DoraDevice r1, long r2, Continuation r4) {
        return r0.scanBleInfo(r1, r2, r4);
    }

    public final synchronized void fetchData(z49.b r11, boolean r12, Integer r13, String r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "simpleDevice");     // Catch: Throwable -> L14
        FLogger.a.i("DoraDynamicViewModelV2", "fetchData device :" + r11 + ",isCurrent:" + r12 + ",pageKey:" + r14 + ' ');     // Catch: Throwable -> L14
        com.larus.dora.impl.dynamic.loader.d r3 = this.dataLoader;     // Catch: Throwable -> L14
        CoroutineScope r4 = ViewModelKt.getViewModelScope(this);     // Catch: Throwable -> L14
        if (r13 != null) goto L8;
    L10:
        int r0 = n1.d(r11);     // Catch: Throwable -> L14
    L11:
        com.larus.dora.impl.dynamic.loader.d.b(r3, r4, r13, Integer.valueOf(r0), r11.d(), r14, new h(this, r11, r12));     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        if (r13.intValue() != 4096) goto L10;
        r0 = -1;
    L14:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void checkLocalBindState$default(DoraDeviceSettingsViewModel r0, DoraDevice r1, long r2, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L6;
        r2 = 500;
    L6:
        r0.checkLocalBindState(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkLocalBindState");
    }

    public static /* synthetic */ Object scanBleInfo$default(DoraDeviceSettingsViewModel r0, DoraDevice r1, long r2, Continuation r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 2) == 0) goto L7;
        r2 = 10000;
    L7:
        return r0.scanBleInfo(r1, r2, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scanBleInfo");
    }
}
