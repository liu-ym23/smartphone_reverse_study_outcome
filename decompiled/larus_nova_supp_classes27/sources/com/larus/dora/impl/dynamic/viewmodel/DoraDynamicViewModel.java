package com.larus.dora.impl.dynamic.viewmodel;

import android.app.Application;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.core.BindAndConnectResult;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyBindResult;
import com.larus.dora.impl.core.OnlyConnectResult;
import com.larus.dora.impl.core.ReplaceBindAndConnectResult;
import com.larus.dora.impl.core.UnbindAndResetResult;
import com.larus.dora.impl.device.settings.general.IntentState;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.dynamic.o1;
import com.larus.dora.impl.dynamic.p1;
import com.larus.dora.impl.feature.DoraFeature;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.util.b0;
import com.larus.network.util.ScreenStateManager;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import d59.j;
import d59.k;
import d59.l;
import d59.m;
import d59.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
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
import org.json.JSONArray;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0004U\\cf\b\u0016\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0010\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0012\u0010h\u001a\u00020X2\b\u0010i\u001a\u0004\u0018\u00010jH\u0002J\u0016\u0010k\u001a\u00020X2\u0006\u0010l\u001a\u00020DH\u0082@¢\u0006\u0002\u0010mJ\u0016\u0010n\u001a\u00020X2\u0006\u0010l\u001a\u00020DH\u0082@¢\u0006\u0002\u0010mJ\"\u0010o\u001a\u0004\u0018\u00010D2\u0006\u0010i\u001a\u00020j2\b\b\u0002\u0010p\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010qJ\u0010\u0010r\u001a\u00020X2\u0006\u0010l\u001a\u00020DH\u0016J\u001a\u0010s\u001a\u00020X2\u0012\b\u0002\u0010t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\nJ\u0010\u0010u\u001a\u00020X2\b\u0010l\u001a\u0004\u0018\u00010DJ\u0018\u0010v\u001a\u00020X2\b\u0010l\u001a\u0004\u0018\u00010DH\u0086@¢\u0006\u0002\u0010mJ\u0018\u0010w\u001a\u00020X2\b\u0010l\u001a\u0004\u0018\u00010DH\u0086@¢\u0006\u0002\u0010mJ\b\u0010x\u001a\u00020XH\u0014J \u0010y\u001a\u00020X2\u0006\u0010z\u001a\u00020_2\u0006\u0010{\u001a\u00020J2\b\u0010|\u001a\u0004\u0018\u00010jJ\b\u0010}\u001a\u00020~H\u0002JJ\u0010\u007f\u001a\u00020X2\u0006\u0010z\u001a\u00020_2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020~0\n2\t\u0010\u0081\u0001\u001a\u0004\u0018\u0001012\u0016\u0010\u0082\u0001\u001a\u0011\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020j\u0018\u00010\u0083\u00012\u0006\u0010{\u001a\u00020JH\u0002J\u0013\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020~J\u0014\u0010\u0087\u0001\u001a\u00020J2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010~H\u0002J\u001c\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020~0\nJ4\u0010\u0089\u0001\u001a\u00020X2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0018\b\u0002\u0010\u0082\u0001\u001a\u0011\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020j\u0018\u00010\u0083\u00012\u0007\u0010\u008c\u0001\u001a\u00020_J\u000f\u0010\u008d\u0001\u001a\u00020X2\u0006\u0010i\u001a\u00020jJ\u000f\u0010\u008e\u0001\u001a\u00020X2\u0006\u0010l\u001a\u00020DJ\u0007\u0010\u008f\u0001\u001a\u00020XJ\u0011\u0010\u0090\u0001\u001a\u00020X2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J\u0011\u0010\u0093\u0001\u001a\u00020X2\b\u0010z\u001a\u0004\u0018\u00010_J\t\u0010\u0094\u0001\u001a\u00020XH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R&\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020 0\u001f0\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020-0)¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\"\u00100\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R%\u00102\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u00020 0\u001f0\"¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00106\u001a\b\u0012\u0004\u0012\u0002050\"¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0014\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u0002090\"¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u001eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020=0\"¢\u0006\b\n\u0000\u001a\u0004\bA\u0010$R\"\u0010B\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020C\u0012\u0006\u0012\u0004\u0018\u00010D0\u001f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010E\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020C\u0012\u0006\u0012\u0004\u0018\u00010D0\u001f0\u0010¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0012R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020JX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0010\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010VR\u0010\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0004\n\u0002\u0010]R\u0016\u0010^\u001a\u0004\u0018\u00010_8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0010\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010dR\u0010\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010g¨\u0006\u009d\u0001"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "deviceStateSeq", "", "mDataList", "", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "_sodaBannerSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/network/ActivityStatus;", "sodaBannerSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getSodaBannerSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_deviceBindStatusFlow", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$DeviceBindAction;", "deviceBindStatusFlow", "getDeviceBindStatusFlow", "_deviceIntentSharedFlow", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$DeviceActionV2;", "get_deviceIntentSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "deviceIntentSharedFlow", "getDeviceIntentSharedFlow", "_itemListData", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "itemListData", "Landroidx/lifecycle/LiveData;", "getItemListData", "()Landroidx/lifecycle/LiveData;", "_deviceStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$DeviceStateV2;", "deviceStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getDeviceStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_deviceBatteryStateFlow", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$BatteryState;", "deviceBatteryStateFlow", "getDeviceBatteryStateFlow", "_navBarData", "Lcom/larus/dora/impl/dynamic/CardConfigJson;", "navBarData", "getNavBarData", "_dialogEvent", "Lcom/larus/dora/impl/dynamic/event/DialogEvent;", "dialogEvent", "getDialogEvent", "_viewHolderEvent", "Lcom/larus/dora/impl/dynamic/event/ViewHolderEvent;", "viewHolderEvent", "getViewHolderEvent", "_connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "get_connectionState", "()Landroidx/lifecycle/MutableLiveData;", "connectionState", "getConnectionState", "_unbindStateFlow", "Lcom/larus/dora/impl/device/settings/general/IntentState;", "Lcom/bytedance/dora/device/DoraDevice;", "unbindStateFlow", "getUnbindStateFlow", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DoraDynamicDataLoader;", "isScreenOn", "", "()Z", "setScreenOn", "(Z)V", "connectingJob", "Lkotlinx/coroutines/Job;", "getConnectingJob", "()Lkotlinx/coroutines/Job;", "setConnectingJob", "(Lkotlinx/coroutines/Job;)V", "boundStateReceiver", "com/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$boundStateReceiver$1", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$boundStateReceiver$1;", "onAction", "", "action", "Lcom/larus/dora/impl/dynamic/event/ViewHolderAction;", "screenListener", "com/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$screenListener$1", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$screenListener$1;", "lastConnectDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "getLastConnectDevice", "()Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "doraBudsCallback", "com/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$doraBudsCallback$1", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$doraBudsCallback$1;", "doraLinkCallback", "com/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$doraLinkCallback$1;", "handleConnectRequest", "mac", "", "handleGConnectRequest", "device", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNotGConnectRequest", "scanBleInfo", "timeout", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkBindState", "checkSodaBanner", "activitiesStatus", "connectAsync", "onlyConnect", "connect", "onCleared", "fetchData", "simpleDevice", "isCurrent", "pageKey", "createFeedbackCard", "Lcom/larus/dora/impl/dynamic/Card;", "sendData", "cardList", "navBar", "starling", "", "parseCardData", "Lcom/larus/dora/impl/dynamic/entity/ICardProtocol;", "card", "checkEmpty", "getData", "updateConnectState", "status", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$ConnectState;", "simpleDoraDevice", "updateRemoveBarData", "replaceBind", "disconnectSpp", "updateUi", "uiState", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModel$UiState;", "unbind", "loadLabSettingConfig", "Companion", "DeviceBindAction", "EventNotification", "BatteryState", "DeviceStateV2", "DeviceActionV2", "UiState", "ConnectState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraDynamicViewModel extends ViewModel implements e59.a {
    public static final b Companion = null;
    public static final String TAG = "DoraDynamicViewModel";
    private final MutableLiveData<e59.b> _connectionState;
    private final z0<a> _deviceBatteryStateFlow;
    private final MutableSharedFlow<Object> _deviceBindStatusFlow;
    private final MutableSharedFlow<Object> _deviceIntentSharedFlow;
    private final z0<d> _deviceStateFlow;
    private final MutableLiveData<e59.d> _dialogEvent;
    private final MutableLiveData<Pair<List<d59.c>, d59.b>> _itemListData;
    private final MutableLiveData<Pair<com.larus.dora.impl.dynamic.e, d59.b>> _navBarData;
    private final MutableSharedFlow<com.larus.dora.impl.network.a> _sodaBannerSharedFlow;
    private final MutableSharedFlow<Pair<IntentState, DoraDevice>> _unbindStateFlow;
    private final MutableLiveData<e59.f> _viewHolderEvent;
    private final DoraDynamicViewModel$boundStateReceiver$1 boundStateReceiver;
    private Job connectingJob;
    private final LiveData<e59.b> connectionState;
    private final com.larus.dora.impl.dynamic.loader.a dataLoader;
    private final i1<a> deviceBatteryStateFlow;
    private final d1<Object> deviceBindStatusFlow;
    private final d1<Object> deviceIntentSharedFlow;
    private final i1<d> deviceStateFlow;
    private long deviceStateSeq;
    private final LiveData<e59.d> dialogEvent;
    private final DoraDynamicViewModel$doraBudsCallback$1 doraBudsCallback;
    private final DoraDynamicViewModel$doraLinkCallback$1 doraLinkCallback;
    private final Gson gson;
    private boolean isScreenOn;
    private final LiveData<Pair<List<d59.c>, d59.b>> itemListData;
    private List<d59.c> mDataList;
    private final LiveData<Pair<com.larus.dora.impl.dynamic.e, d59.b>> navBarData;
    private final i screenListener;
    private final d1<com.larus.dora.impl.network.a> sodaBannerSharedFlow;
    private final d1<Pair<IntentState, DoraDevice>> unbindStateFlow;
    private final LiveData<e59.f> viewHolderEvent;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$1", f = "DoraDynamicViewModel.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DoraDynamicViewModel a;

            public a(DoraDynamicViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                d r5 = (d) r3;
                if (Intrinsics.areEqual(r5, d.C0076d.a) == false) goto L6;
                this.a.get_connectionState().setValue(e59.b.d.a);
            L18:
                return Unit.INSTANCE;
            L6:
                if ((r5 instanceof d.a) == false) goto L8;
                this.a.get_connectionState().setValue(new e59.b.a(((d.a) r5).b.mac));
                goto L18
            L8:
                String r0 = null;
                if ((r5 instanceof d.b) == false) goto L12;
                MutableLiveData<e59.b> r6 = this.a.get_connectionState();
                ((d.b) r5).getClass();
                r6.setValue(new e59.b.C0125b(null));
                goto L18
            L12:
                if ((r5 instanceof d.c) == false) goto L18;
                MutableLiveData<e59.b> r7 = this.a.get_connectionState();
                z49.b r8 = ((d.c) r5).b;
                if (r8 == null) goto L16;
                r0 = r8.c();
            L16:
                r7.setValue(new e59.b.c(r0));
                goto L18
            }
        }

        public AnonymousClass1(DoraDynamicViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            i1<d> r6 = this.this$0.getDeviceStateFlow();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
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
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            DoraDevice r2 = this.b;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r1 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final String toString() {
            return "BatteryState(seq=" + this.a + ", device=" + this.b + ')';
        }

        public a(long r1, DoraDevice r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class b {
        public b() {
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
                return "CONNECTED(mac=" + this.a + ')';
            }

            public a(String r1) {
                this.a = r1;
            }
        }

        public static final class b implements c {
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
                return 0;
            }

            public final String toString() {
                return "CONNECTING(mac=null)";
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$c$c, reason: collision with other inner class name */
        public static final class C0075c implements c {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0075c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0075c) r4).a) == true) goto L11;
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

            public C0075c(String r1) {
                this.a = r1;
            }
        }

        public static final class d implements c {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
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
                return "IDLE(mac=" + this.a + ')';
            }

            public d() {
                this.a = "";
            }
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$checkBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$checkBindState$1", f = "DoraDynamicViewModel.kt", i = {2, 3, 4}, l = {476, 478, 485, 490, 492, 498}, m = "invokeSuspend", n = {"bindData", "bindData", "bindData"}, s = {"L$3", "L$2", "L$2"})
    public static final class C03141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03141(DoraDynamicViewModel r1, DoraDevice r2, Continuation<? super C03141> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03141(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r16);
        L57:
            return Unit.INSTANCE;
        L7:
            com.larus.dora.impl.network.b r0 = (com.larus.dora.impl.network.b) this.L$2;
            DoraDynamicViewModel r1 = (DoraDynamicViewModel) this.L$1;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r16);
        L49:
            com.larus.dora.impl.network.b r14 = r0;
            DoraDynamicViewModel r13 = r1;
            Object r11 = r2;
        L50:
            r13.checkSodaBanner(r14.a());
        L51:
            DoraDynamicViewModel r3 = this.this$0;
            Throwable r4 = Result.exceptionOrNull-impl(r11);
            if (r4 == null) goto L57;
            g49.d.c(DoraDynamicViewModel.TAG, "checkBindState: failure", r4);
            MutableSharedFlow<Object> r5 = r3.get_deviceIntentSharedFlow();
            com.larus.dora.impl.dynamic.viewmodel.d r6 = new com.larus.dora.impl.dynamic.viewmodel.d(AppHost.a.getApplication().getString(2131908080));
            this.L$0 = r11;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 6;
            if (r5.emit(r6, this) != r8) goto L57;
            return r8;
        L8:
            com.larus.dora.impl.network.b r7 = (com.larus.dora.impl.network.b) this.L$3;
            r1 = (DoraDynamicViewModel) this.L$2;
            DoraDevice r9 = (DoraDevice) this.L$1;
            Object r10 = this.L$0;
            ResultKt.throwOnFailure(r16);
            r14 = r7;
            Object r12 = r16;
        L36:
            DoraDevice r15 = (DoraDevice) r12;
            if (r15 == null) goto L39;
            r9.mode = r15.mode;
            r9.version = r15.version;
        L39:
            DoraDevice r17 = r9;
            r2 = r10;
        L40:
            r0 = r14;
            MutableSharedFlow<Object> r18 = r1.get_deviceIntentSharedFlow();
            com.larus.dora.impl.dynamic.viewmodel.b r20 = new com.larus.dora.impl.dynamic.viewmodel.b(r17);
            this.L$0 = r2;
            this.L$1 = r1;
            this.L$2 = r0;
            this.L$3 = null;
            this.label = 4;
            if (r18.emit(r20, this) != r8) goto L49;
            return r8;
        L9:
            ResultKt.throwOnFailure(r16);
            Object r21 = ((Result) r16).unbox-impl();
        L10:
            r11 = r21;
            r17 = this.$device;
            r13 = this.this$0;
            if (Result.isSuccess-impl(r11) == false) goto L51;
            r14 = (com.larus.dora.impl.network.b) r11;
            Integer r22 = r14.b();
            if (r22 == null) goto L25;
            int r23 = r22.intValue();
        L26:
            g49.d.d(DoraDynamicViewModel.TAG, "checkBindState: bindCode=" + r23);
            if (r23 == 1) goto L45;
            if (r23 != 2) goto L50;
            if (o59.a.p(r17) == false) goto L41;
            String r24 = r17.mac;
            this.L$0 = r11;
            this.L$1 = r17;
            this.L$2 = r13;
            this.L$3 = r14;
            this.label = 3;
            r12 = DoraDynamicViewModel.scanBleInfo$default(r13, r24, 0, this, 2, null);
            if (r12 != r8) goto L35;
            return r8;
        L35:
            r10 = r11;
            r9 = r17;
            r1 = r13;
            goto L36
        L41:
            r2 = r11;
            r1 = r13;
            goto L40
        L45:
            kj4.a r25 = kj4.a.g();
            this.L$0 = r11;
            this.L$1 = r13;
            this.L$2 = r14;
            this.label = 5;
            if (DoraAdapterExtKt.b(r25) != r8) goto L48;
            return r8;
        L48:
            r2 = r11;
            r1 = r13;
            r0 = r14;
            goto L49
        L25:
            r23 = 0;
            goto L26
        L11:
            ResultKt.throwOnFailure(r16);
        L17:
            DoraNetworkApi r26 = DoraNetworkApi.a;
            DoraDevice r27 = this.$device;
            this.label = 2;
            r21 = r26.e(r27, true, this);
            if (r21 != r8) goto L10;
            return r8;
        L12:
            ResultKt.throwOnFailure(r16);
            if (this.this$0.isScreenOn() == true) goto L17;
            this.label = 1;
            if (DelayKt.delay(500, this) != r8) goto L17;
            return r8;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$checkSodaBanner$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$checkSodaBanner$1", f = "DoraDynamicViewModel.kt", i = {}, l = {512}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03151(DoraDynamicViewModel r1, Continuation<? super C03151> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03151(this.this$0, r3);
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
            String r6 = ILoginService.a.getAccountInfo().c;
            b0.a.getClass();
            b0.J(false, r6);
            MutableSharedFlow r7 = DoraDynamicViewModel.access$get_sodaBannerSharedFlow$p(this.this$0);
            com.larus.dora.impl.network.a r3 = new com.larus.dora.impl.network.a(1, false);
            this.label = 1;
            if (r7.emit(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$checkSodaBanner$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$checkSodaBanner$2", f = "DoraDynamicViewModel.kt", i = {}, l = {526}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.dora.impl.network.a $status;
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public AnonymousClass2(com.larus.dora.impl.network.a r1, DoraDynamicViewModel r2, Continuation<? super AnonymousClass2> r3) {
            this.$status = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$status, this.this$0, r4);
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
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            String r6 = ILoginService.a.getAccountInfo().c;
            g49.d.d(DoraDynamicViewModel.TAG, "sodaBannerSharedFlow ishow " + this.$status.a());
            if (this.$status.a() == false) goto L11;
            b0.a.getClass();
            b0.J(true, r6);
        L12:
            MutableSharedFlow r7 = DoraDynamicViewModel.access$get_sodaBannerSharedFlow$p(this.this$0);
            com.larus.dora.impl.network.a r2 = this.$status;
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L16;
            return r0;
        L11:
            b0.a.getClass();
            b0.J(false, r6);
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$connect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel", f = "DoraDynamicViewModel.kt", i = {0, 1, 2}, l = {590, 614, 621}, m = "connect", n = {"device", "device", "device"}, s = {"L$0", "L$0", "L$0"})
    public static final class C03161 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03161(DoraDynamicViewModel r1, Continuation<? super C03161> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.connect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$connectAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$connectAsync$1", f = "DoraDynamicViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03171(DoraDevice r1, DoraDynamicViewModel r2, Continuation<? super C03171> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03171(this.$device, this.this$0, r4);
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
            DoraDynamicViewModel.access$handleConnectRequest(this.this$0, r3.mac);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public interface d {

        public static final class a implements d {
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

        public static final class b implements d {
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

        public static final class c implements d {
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

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$d$d, reason: collision with other inner class name */
        public static final class C0076d implements d {
            public static final C0076d a = null;

            static {
                a = new C0076d();
            }

            public C0076d() {
            }
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$disconnectSpp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$disconnectSpp$1", f = "DoraDynamicViewModel.kt", i = {}, l = {969}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03181(DoraDynamicViewModel r1, Continuation<? super C03181> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03181(this.this$0, r3);
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
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            d r5 = (d) DoraDynamicViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r5 instanceof d.a) == false) goto L14;
            kj4.a r2 = kj4.a.g();
            DoraDevice r6 = ((d.a) r5).b;
            this.label = 1;
            if (DoraAdapterExtKt.e(r2, r6) != r0) goto L14;
            return r0;
        }
    }

    public interface e {

        public static final class a implements e {
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
                return 0;
            }

            public final String toString() {
                return "CONNECTED(device=null)";
            }
        }

        public static final class b implements e {
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

        public static final class c implements e {
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

        public static final class d implements e {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }
    }

    public /* synthetic */ class f {
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

    public static final class g implements com.larus.dora.impl.dynamic.loader.a.b {
        public final /* synthetic */ DoraDynamicViewModel a;
        public final /* synthetic */ z49.b b;
        public final /* synthetic */ boolean c;

        @Override // com.larus.dora.impl.dynamic.loader.a.b
        public final void a() {
            FLogger.a.i(DoraDynamicViewModel.TAG, "fetchData card list onEmpty");
        }

        @Override // com.larus.dora.impl.dynamic.loader.a.b
        public final void onFail(String r4) {
            FLogger.a.e(DoraDynamicViewModel.TAG, "fetchData onFail, msg is " + r4);
        }

        public g(DoraDynamicViewModel r1, z49.b r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.larus.dora.impl.dynamic.loader.a.b
        public final void b(List<com.larus.dora.impl.dynamic.d> r8, com.larus.dora.impl.dynamic.e r9, Map<String, String> r10) {
            Intrinsics.checkNotNullParameter(r8, "cardList");
            List r0 = CollectionsKt.toMutableList(r8);
            if (CollectionsKt.listOf(new String[]{"local_test", "debug", "inhouse 3", "dora_g_ut"}).contains(AppHost.a.getBuildChannel()) == false) goto L6;
            r0.add(DoraDynamicViewModel.access$createFeedbackCard(this.a));
        L6:
            if ((!r8.isEmpty()) == false) goto L8;
            DoraDynamicViewModel.access$sendData(this.a, this.b, CollectionsKt.toList(r0), r9, r10, this.c);
            return;
        L8:
            FLogger.a.i(DoraDynamicViewModel.TAG, "fetchData card list is empty.");
        }
    }

    public static final class h extends ScanCallback {
        public final /* synthetic */ CompletableDeferred<Unit> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> c;

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.d(DoraDynamicViewModel.TAG, "connect request, scan failed, err: " + r3);
            this.a.complete(Unit.INSTANCE);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r2, ScanResult r3) {
            DoraDevice r4 = kj4.a.g().convertScanResultToDoraDevice(r3);
            g49.d.d(DoraDynamicViewModel.TAG, "connect request, new scan result: " + r4);
            if (r4 == null) goto L5;
            String r5 = r4.mac;
        L7:
            if (Intrinsics.areEqual(r5, this.b) == false) goto L10;
            this.c.element = r4;
            kj4.a.g().stopScan(this);
            this.a.complete(Unit.INSTANCE);
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L7
        }

        public h(CompletableDeferred<Unit> r1, String r2, Ref.ObjectRef<DoraDevice> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$handleConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$handleConnectRequest$1", f = "DoraDynamicViewModel.kt", i = {}, l = {324, 329, 331}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03191(DoraDynamicViewModel r1, String r2, Continuation<? super C03191> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03191(this.this$0, this.$mac, r4);
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
            s r12 = s.a;     // Catch: Exception -> L29
            Application r2 = AppHost.a.getApplication();     // Catch: Exception -> L29
            r12.getClass();     // Catch: Exception -> L29
            s.b(r2, 2131903672, false);     // Catch: Exception -> L29
            this.this$0.get_connectionState().setValue(new e59.b.c(this.$mac));     // Catch: Exception -> L29
            goto L31
        L20:
            if (o59.a.p(r11) == false) goto L24;
            DoraDynamicViewModel r3 = this.this$0;     // Catch: Exception -> L29
            this.label = 2;     // Catch: Exception -> L29
            if (DoraDynamicViewModel.access$handleGConnectRequest(r3, r11, this) != r0) goto L31;
            return r0;
        L24:
            DoraDynamicViewModel r4 = this.this$0;     // Catch: Exception -> L29
            this.label = 3;     // Catch: Exception -> L29
            if (DoraDynamicViewModel.access$handleNotGConnectRequest(r4, r11, this) != r0) goto L31;
            return r0;
        L13:
            ResultKt.throwOnFailure(r10);
            this.this$0.get_connectionState().setValue(new e59.b.C0125b(this.$mac));
            CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Exception -> L29
            DoraDynamicViewModel$handleConnectRequest$1$device$1 r5 = new DoraDynamicViewModel$handleConnectRequest$1$device$1(this.$mac, null);     // Catch: Exception -> L29
            this.label = 1;     // Catch: Exception -> L29
            r10 = BuildersKt.withContext(r13, r5, this);     // Catch: Exception -> L29
            if (r10 != r0) goto L17;
            return r0;
        L29:
            s r14 = s.a;
            Application r6 = AppHost.a.getApplication();
            r14.getClass();
            s.b(r6, 2131903672, false);
            this.this$0.get_connectionState().setValue(new e59.b.c(this.$mac));
            goto L31
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$handleGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel", f = "DoraDynamicViewModel.kt", i = {0, 1, 2}, l = {355, 380, 387}, m = "handleGConnectRequest", n = {"device", "device", "device"}, s = {"L$0", "L$0", "L$0"})
    public static final class C03201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03201(DoraDynamicViewModel r1, Continuation<? super C03201> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraDynamicViewModel.access$handleGConnectRequest(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$handleGConnectRequest$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$handleGConnectRequest$2", f = "DoraDynamicViewModel.kt", i = {}, l = {388, 401, 410}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03212(DoraDynamicViewModel r1, DoraDevice r2, Continuation<? super C03212> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03212(this.this$0, this.$device, r4);
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
            g49.d.d(DoraDynamicViewModel.TAG, "connect request, scan new device info error");
            return Unit.INSTANCE;
        L19:
            DoraDevice r4 = this.$device;
            r4.mode = r13.mode;
            r4.version = r13.version;
            if (o59.a.v(r4) == true) goto L27;
            g49.d.d(DoraDynamicViewModel.TAG, "connect request, this device don't sup factory, connect spp ");
            DoraDynamicViewModel r14 = this.this$0;
            DoraDevice r2 = this.$device;
            this.label = 2;
            if (r14.onlyConnect(r2, this) != r0) goto L25;
            return r0;
        L27:
            if (this.$device.isFactory() == false) goto L29;
            g49.d.d(DoraDynamicViewModel.TAG, "connect request, device is factory, replace bind it");
            this.this$0.replaceBind(this.$device);
            goto L33
        L29:
            MutableSharedFlow<Object> r15 = this.this$0.get_deviceIntentSharedFlow();
            com.larus.dora.impl.dynamic.viewmodel.b r3 = new com.larus.dora.impl.dynamic.viewmodel.b(this.$device);
            this.label = 3;
            if (r15.emit(r3, this) != r0) goto L33;
            return r0;
        L12:
            ResultKt.throwOnFailure(r12);
            DoraDynamicViewModel r16 = this.this$0;
            String r5 = this.$device.mac;
            this.label = 1;
            r12 = DoraDynamicViewModel.scanBleInfo$default(r16, r5, 0, this, 2, null);
            if (r12 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$handleNotGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel", f = "DoraDynamicViewModel.kt", i = {0}, l = {427}, m = "handleNotGConnectRequest", n = {"device"}, s = {"L$0"})
    public static final class C03221 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03221(DoraDynamicViewModel r1, Continuation<? super C03221> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraDynamicViewModel.access$handleNotGConnectRequest(this.this$0, null, this);
        }
    }

    public static final class i implements ScreenStateManager.b {
        public final /* synthetic */ DoraDynamicViewModel a;

        public final void onScreenOff() {
            g49.d.d(DoraDynamicViewModel.TAG, "onScreenOff");
            this.a.setScreenOn(false);
        }

        public final void onScreenOn() {
            g49.d.d(DoraDynamicViewModel.TAG, "onScreenOn");
            this.a.setScreenOn(true);
        }

        public final void onUserPresent() {
            g49.d.d(DoraDynamicViewModel.TAG, "onUserPresent");
            this.a.setScreenOn(true);
        }

        public i(DoraDynamicViewModel r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$loadLabSettingConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$loadLabSettingConfig$1", f = "DoraDynamicViewModel.kt", i = {}, l = {1030}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C03231(Continuation<? super C03231> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C03231(r2);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$onlyConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel", f = "DoraDynamicViewModel.kt", i = {0, 1}, l = {558, 565}, m = "onlyConnect", n = {"device", "device"}, s = {"L$0", "L$0"})
    public static final class C03241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03241(DoraDynamicViewModel r1, Continuation<? super C03241> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onlyConnect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$replaceBind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$replaceBind$1", f = "DoraDynamicViewModel.kt", i = {}, l = {928, 932, 941, 951}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$replaceBind$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ReplaceBindAndConnectResult.values().length];
                r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[ReplaceBindAndConnectResult.SERVER_REPLACE_BIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[ReplaceBindAndConnectResult.CONNECT_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[ReplaceBindAndConnectResult.CONNECT_TIMEOUT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[ReplaceBindAndConnectResult.SUCCESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public C03251(DoraDevice r1, DoraDynamicViewModel r2, Continuation<? super C03251> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03251(this.$device, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r7);
        L24:
            this.this$0.updateUi(new e.c(this.$device));
        L34:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r7);
        L28:
            this.this$0.updateUi(new e.c(this.$device));
            goto L34
        L12:
            ResultKt.throwOnFailure(r7);
        L32:
            this.this$0.updateUi(new e.c(this.$device));
            goto L34
        L13:
            ResultKt.throwOnFailure(r7);
        L18:
            switch(a.a[((ReplaceBindAndConnectResult) r7).ordinal()]) {
                case 1: goto L29;
                case 2: goto L29;
                case 3: goto L25;
                case 4: goto L21;
                case 5: goto L21;
                case 6: goto L34;
                default: goto L20;
            };
        L21:
            MutableSharedFlow<Object> r8 = this.this$0.get_deviceIntentSharedFlow();
            com.larus.dora.impl.dynamic.viewmodel.c r2 = new com.larus.dora.impl.dynamic.viewmodel.c(this.$device);
            this.label = 4;
            if (r8.emit(r2, this) != r0) goto L24;
            return r0;
        L25:
            MutableSharedFlow<Object> r9 = this.this$0.get_deviceIntentSharedFlow();
            int r3 = j0.a;
            com.larus.dora.impl.dynamic.viewmodel.d r4 = new com.larus.dora.impl.dynamic.viewmodel.d(j0.d(2131904024));
            this.label = 3;
            if (r9.emit(r4, this) != r0) goto L28;
            return r0;
        L29:
            MutableSharedFlow<Object> r10 = this.this$0.get_deviceIntentSharedFlow();
            com.larus.dora.impl.dynamic.viewmodel.d r5 = new com.larus.dora.impl.dynamic.viewmodel.d(AppHost.a.getApplication().getString(2131908080));
            this.label = 2;
            if (r10.emit(r5, this) != r0) goto L32;
            return r0;
        L20:
            throw new NoWhenBranchMatchedException();
        L14:
            ResultKt.throwOnFailure(r7);
            kj4.a r11 = kj4.a.g();
            DoraDevice r6 = this.$device;
            this.label = 1;
            r7 = DoraAdapterExtKt.G(r11, r6, this);
            if (r7 != r0) goto L18;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$scanBleInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel", f = "DoraDynamicViewModel.kt", i = {0, 0, 0}, l = {465}, m = "scanBleInfo", n = {"newDevice", "scanCallback", "startScanTs"}, s = {"L$0", "L$1", "J$0"})
    public static final class C03261 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModel this$0;

        public C03261(DoraDynamicViewModel r1, Continuation<? super C03261> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return DoraDynamicViewModel.access$scanBleInfo(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$scanBleInfo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$scanBleInfo$2", f = "DoraDynamicViewModel.kt", i = {}, l = {465}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03272 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $done;
        int label;

        public C03272(CompletableDeferred<Unit> r1, Continuation<? super C03272> r2) {
            this.$done = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03272(this.$done, r3);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$unbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$unbind$1", f = "DoraDynamicViewModel.kt", i = {1}, l = {999, 1003, 1005, 1014, 1018, 1022}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class C03281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ z49.b $simpleDevice;
        Object L$0;
        int label;
        final /* synthetic */ DoraDynamicViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$unbind$1$a */
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

        public C03281(DoraDynamicViewModel r1, z49.b r2, Continuation<? super C03281> r3) {
            this.this$0 = r1;
            this.$simpleDevice = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03281(this.this$0, this.$simpleDevice, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
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
            ResultKt.throwOnFailure(r10);
        L55:
            return Unit.INSTANCE;
        L7:
            DoraDevice r1 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r10);
        L32:
            int r11 = a.a[((UnbindAndResetResult) r10).ordinal()];
            if (r11 != 1) goto L35;
            MutableSharedFlow r12 = DoraDynamicViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r2 = new Pair(IntentState.ACTION_SERVER_UNBIND_NETWORK_ERROR, r1);
            this.L$0 = null;
            this.label = 3;
            if (r12.emit(r2, this) != r0) goto L55;
            return r0;
        L35:
            if (r11 == 2) goto L48;
            if (r11 == 3) goto L48;
            if (r11 == 4) goto L45;
            if (r11 != 5) goto L44;
            MutableSharedFlow r13 = DoraDynamicViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r3 = new Pair(IntentState.ACTION_SPP_DISCONNECT_FAILED, r1);
            this.L$0 = null;
            this.label = 6;
            if (r13.emit(r3, this) != r0) goto L55;
            return r0;
        L44:
            throw new NoWhenBranchMatchedException();
        L45:
            MutableSharedFlow r14 = DoraDynamicViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r4 = new Pair(IntentState.ACTION_UNBIND_SUCCESS, r1);
            this.L$0 = null;
            this.label = 5;
            if (r14.emit(r4, this) != r0) goto L55;
            return r0;
        L48:
            MutableSharedFlow r15 = DoraDynamicViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r5 = new Pair(IntentState.ACTION_SERVER_UNBIND_FAILED, r1);
            this.L$0 = null;
            this.label = 4;
            if (r15.emit(r5, this) != r0) goto L55;
            return r0;
        L8:
            ResultKt.throwOnFailure(r10);
        L28:
            return Unit.INSTANCE;
        L9:
            ResultKt.throwOnFailure(r10);
            List r16 = kj4.a.g().getDoraBindList();
            if (r16 == null) goto L22;
            z49.b r6 = this.$simpleDevice;
            ArrayList r7 = new ArrayList();
            Iterator r17 = r16.iterator();
        L13:
            if (r17.hasNext() == false) goto L21;
            Object r8 = r17.next();
            String r9 = ((DoraDevice) r8).mac;
            if (r6 == null) goto L17;
            String r18 = r6.c();
        L19:
            if (Intrinsics.areEqual(r9, r18) == false) goto L13;
            r7.add(r8);
            goto L13
        L17:
            r18 = null;
            goto L19
        L21:
            r1 = (DoraDevice) CollectionsKt.firstOrNull(r7);
        L23:
            if (r1 != null) goto L29;
            MutableSharedFlow r110 = DoraDynamicViewModel.access$get_unbindStateFlow$p(this.this$0);
            Pair r20 = new Pair(IntentState.ACTION_NO_DEVICE_CONNECTED, null);
            this.label = 1;
            if (r110.emit(r20, this) != r0) goto L28;
            return r0;
        L29:
            kj4.a r111 = kj4.a.g();
            this.L$0 = r1;
            this.label = 2;
            r10 = DoraAdapterExtKt.C(r111, r1, this);
            if (r10 != r0) goto L32;
            return r0;
        L22:
            r1 = null;
            goto L23
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new b();
    }

    private final com.larus.dora.impl.dynamic.d createFeedbackCard() {
        JSONObject r0 = new JSONObject();
        r0.put("desc", new JSONObject());
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        r3.put("type", "string_type");
        r3.put("value", "dora_g_feedback_title_cn");
        r2.put("title", r3);
        r2.put("action_url", "sslocal://flow/dora_g_feedback");
        r2.put("right_icon", "arrow");
        r1.put(r2);
        r0.put("items", r1);
        r0.put("title", new JSONObject());
        return new com.larus.dora.impl.dynamic.d("dora_g_feedback", "19981114", new com.larus.dora.impl.dynamic.e("feedback", r0.toString()), 8);
    }

    private final z49.b getLastConnectDevice() {
        b0.a.getClass();
        DoraSimpleDevice r0 = b0.l();
        if (r0 == null) goto L5;
        String r2 = r0.getName();
    L7:
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        if (r0 == null) goto L11;
        String r4 = r0.getMac();
    L12:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        if (r0 == null) goto L16;
        String r5 = r0.getSn();
    L17:
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        if (r0 == null) goto L21;
        Integer r1 = Integer.valueOf(r0.getSku());
    L23:
        return new z49.b(r2, r4, r5, r1, 412);
    L21:
        r1 = null;
        goto L23
    L16:
        r5 = null;
        goto L17
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    public final void disconnectSpp() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C03181(this, null), 2, null);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel$boundStateReceiver$1] */
    public DoraDynamicViewModel() {
        this.gson = new Gson();
        this.mDataList = CollectionsKt.emptyList();
        MutableSharedFlow<com.larus.dora.impl.network.a> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._sodaBannerSharedFlow = r3;
        this.sodaBannerSharedFlow = r3;
        MutableSharedFlow<Object> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceBindStatusFlow = r4;
        this.deviceBindStatusFlow = r4;
        MutableSharedFlow<Object> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceIntentSharedFlow = r5;
        this.deviceIntentSharedFlow = r5;
        MutableLiveData<Pair<List<d59.c>, d59.b>> r6 = new MutableLiveData();
        this._itemListData = r6;
        this.itemListData = r6;
        StateFlowImpl r7 = j1.a(d.C0076d.a);
        this._deviceStateFlow = r7;
        this.deviceStateFlow = r7;
        StateFlowImpl r8 = j1.a(new a(0, null));
        this._deviceBatteryStateFlow = r8;
        this.deviceBatteryStateFlow = r8;
        MutableLiveData<Pair<com.larus.dora.impl.dynamic.e, d59.b>> r9 = new MutableLiveData();
        this._navBarData = r9;
        this.navBarData = r9;
        MutableLiveData<e59.d> r10 = new MutableLiveData();
        this._dialogEvent = r10;
        this.dialogEvent = r10;
        MutableLiveData<e59.f> r11 = new MutableLiveData();
        this._viewHolderEvent = r11;
        this.viewHolderEvent = r11;
        MutableLiveData<e59.b> r12 = new MutableLiveData(e59.b.d.a);
        this._connectionState = r12;
        this.connectionState = r12;
        MutableSharedFlow<Pair<IntentState, DoraDevice>> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._unbindStateFlow = r0;
        this.unbindStateFlow = r0;
        this.dataLoader = new com.larus.dora.impl.dynamic.loader.a();
        this.isScreenOn = true;
        this.boundStateReceiver = new DoraDynamicViewModel$boundStateReceiver$1();
        i r1 = new i(this);
        this.screenListener = r1;
        mj4.h r2 = new DoraDynamicViewModel$doraBudsCallback$1(this);
        this.doraBudsCallback = r2;
        IDoraLinkCallback r13 = new DoraDynamicViewModel$doraLinkCallback$1(this);
        this.doraLinkCallback = r13;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        loadLabSettingConfig();
        kj4.a.g().registerDoraLinkCallback(r13);
        kj4.a.g().k(r2);
        ScreenStateManager r14 = ScreenStateManager.a;
        ScreenStateManager.a(r1);
    }

    private final void loadLabSettingConfig() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03231(null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        g49.d.d(TAG, this + " onCleared");
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
        kj4.a.g().E(this.doraBudsCallback);
        ScreenStateManager r0 = ScreenStateManager.a;
        ScreenStateManager.a(this.screenListener);
    }

    public final Job getConnectingJob() {
        return this.connectingJob;
    }

    public final LiveData<e59.b> getConnectionState() {
        return this.connectionState;
    }

    public final i1<a> getDeviceBatteryStateFlow() {
        return this.deviceBatteryStateFlow;
    }

    public final d1<Object> getDeviceBindStatusFlow() {
        return this.deviceBindStatusFlow;
    }

    public final d1<Object> getDeviceIntentSharedFlow() {
        return this.deviceIntentSharedFlow;
    }

    public final i1<d> getDeviceStateFlow() {
        return this.deviceStateFlow;
    }

    public final LiveData<e59.d> getDialogEvent() {
        return this.dialogEvent;
    }

    public final LiveData<Pair<List<d59.c>, d59.b>> getItemListData() {
        return this.itemListData;
    }

    public final LiveData<Pair<com.larus.dora.impl.dynamic.e, d59.b>> getNavBarData() {
        return this.navBarData;
    }

    public final d1<com.larus.dora.impl.network.a> getSodaBannerSharedFlow() {
        return this.sodaBannerSharedFlow;
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

    public final MutableSharedFlow<Object> get_deviceIntentSharedFlow() {
        return this._deviceIntentSharedFlow;
    }

    public final boolean isScreenOn() {
        return this.isScreenOn;
    }

    public static final /* synthetic */ com.larus.dora.impl.dynamic.d access$createFeedbackCard(DoraDynamicViewModel r0) {
        return r0.createFeedbackCard();
    }

    public static final /* synthetic */ long access$getDeviceStateSeq$p(DoraDynamicViewModel r2) {
        return r2.deviceStateSeq;
    }

    public static final /* synthetic */ z0 access$get_deviceBatteryStateFlow$p(DoraDynamicViewModel r0) {
        return r0._deviceBatteryStateFlow;
    }

    public static final /* synthetic */ z0 access$get_deviceStateFlow$p(DoraDynamicViewModel r0) {
        return r0._deviceStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_sodaBannerSharedFlow$p(DoraDynamicViewModel r0) {
        return r0._sodaBannerSharedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_unbindStateFlow$p(DoraDynamicViewModel r0) {
        return r0._unbindStateFlow;
    }

    private final boolean checkEmpty(com.larus.dora.impl.dynamic.d r1) {
        if (r1 == null) goto L6;
        com.larus.dora.impl.dynamic.e r2 = r1.a();
        if (r2 == null) goto L6;
        String r3 = r2.a();
    L7:
        if (r3 != null) goto L9;
        return true;
    L9:
        return false;
    L6:
        r3 = null;
        goto L7
    }

    private final void handleConnectRequest(String r10) {
        Job r0 = this.connectingJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.connectingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03191(this, r10, null), 3, null);
    }

    public void checkBindState(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03141(this, r8, null), 2, null);
    }

    public final void checkSodaBanner(List<com.larus.dora.impl.network.a> r10) {
        if (r10 != null) goto L6;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03151(this, null), 3, null);
        return;
    L6:
        Iterator<com.larus.dora.impl.network.a> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L16;
        com.larus.dora.impl.network.a r1 = r11.next();
        boolean r2 = false;
        if (r1 != null) goto L12;
    L14:
        if (r2 == false) goto L8;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(r1, this, null), 3, null);
        goto L8
    L12:
        if (r1.getType() != 1) goto L14;
        r2 = true;
        goto L14
    }

    public final void connectAsync(DoraDevice r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C03171(r7, this, null), 2, null);
    }

    public final List<d59.c> getData(List<com.larus.dora.impl.dynamic.d> r8) {
        Intrinsics.checkNotNullParameter(r8, "cardList");
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L13;
        com.larus.dora.impl.dynamic.d r1 = (com.larus.dora.impl.dynamic.d) r9.next();
        j r2 = parseCardData(r1);
        d59.c r3 = null;
        String r4 = null;
        if (r2 == null) goto L11;
        FLogger.a.e(TAG, "parsedData, size is " + r2);
        d59.c r5 = new d59.c(0);
        r5.a = r1.d();
        r5.b = r1.c();
        r5.c = r1.b();
        com.larus.dora.impl.dynamic.e r6 = r1.a();
        if (r6 == null) goto L10;
        r4 = r6.b();
    L10:
        r5.d = r4;
        r5.e = r2;
        r3 = r5;
    L11:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L13:
        return r0;
    }

    @Override // e59.a
    public void onAction(e59.e r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        if ((r5 instanceof e59.e.a) == false) goto L6;
        handleConnectRequest(((e59.e.a) r5).a);
        return;
    L6:
        if ((r5 instanceof e59.e.d) == false) goto L9;
        e59.e.d r6 = (e59.e.d) r5;
        this._dialogEvent.setValue(new e59.d.a(r6.a, r6.b, r6.c));
        return;
    L9:
        if ((r5 instanceof e59.e.c) == false) goto L12;
        this._viewHolderEvent.setValue(new e59.f.a(((e59.e.c) r5).a));
        return;
    L12:
        if ((r5 instanceof e59.e.b) == false) goto L15;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final j parseCardData(com.larus.dora.impl.dynamic.d r5) {
        Intrinsics.checkNotNullParameter(r5, "card");
        com.larus.dora.impl.dynamic.e r0 = r5.a();
        if (r0 == null) goto L5;
        String r1 = r0.b();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        switch(r1.hashCode()) {
            case -1828307104: goto L102;
            case -1543071020: goto L95;
            case -1396342996: goto L88;
            case -1225386904: goto L81;
            case -857462632: goto L74;
            case -528855053: goto L67;
            case -191501435: goto L60;
            case -182833806: goto L50;
            case 445790523: goto L43;
            case 448217262: goto L36;
            case 1014244451: goto L29;
            case 1642639251: goto L22;
            case 1678407611: goto L11;
            default: goto L113;
        };
    L113:
        return null;
    L11:
        if (r1.equals("single_device_product_display_v2") == true) goto L14;
        return null;
    L14:
        if (checkEmpty(r5) == false) goto L17;
        return null;
    L17:
        if (Intrinsics.areEqual(r5.a().a(), "") == false) goto L19;
        j r6 = new m();
    L112:
        return r6;
    L19:
        r6 = (m) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), m.class);
        goto L112
    L22:
        if (r1.equals("keep_alive") == true) goto L25;
        return null;
    L25:
        if (checkEmpty(r5) == true) goto L117;
        r6 = (o1) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), o1.class);
        goto L112
    L117:
        return null;
    L29:
        if (r1.equals("product_item") == true) goto L32;
        return null;
    L32:
        if (checkEmpty(r5) == true) goto L119;
        r6 = (com.larus.dora.impl.dynamic.j) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), com.larus.dora.impl.dynamic.j.class);
        goto L112
    L119:
        return null;
    L36:
        if (r1.equals("device_reconnect") == true) goto L39;
        return null;
    L39:
        if (checkEmpty(r5) == true) goto L121;
        r6 = (p1) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), p1.class);
        goto L112
    L121:
        return null;
    L43:
        if (r1.equals("unbind_button") == true) goto L46;
        return null;
    L46:
        if (checkEmpty(r5) == true) goto L123;
        r6 = (n) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), n.class);
        goto L112
    L123:
        return null;
    L50:
        if (r1.equals("product_display") == true) goto L53;
        return null;
    L53:
        if (checkEmpty(r5) == false) goto L56;
        return null;
    L56:
        if (Intrinsics.areEqual(r5.a().a(), "") == false) goto L58;
        r6 = new k();
        goto L112
    L58:
        r6 = (k) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), k.class);
        goto L112
    L60:
        if (r1.equals("feedback") == true) goto L63;
        return null;
    L63:
        if (checkEmpty(r5) == true) goto L127;
        r6 = (o1) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), o1.class);
        goto L112
    L127:
        return null;
    L67:
        if (r1.equals("device_attribute") == true) goto L70;
        return null;
    L70:
        if (checkEmpty(r5) == true) goto L129;
        r6 = (com.larus.dora.impl.dynamic.h) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), com.larus.dora.impl.dynamic.h.class);
        goto L112
    L129:
        return null;
    L74:
        if (r1.equals("bind_device") == true) goto L77;
        return null;
    L77:
        if (checkEmpty(r5) == true) goto L131;
        r6 = (com.larus.dora.impl.device_v2.e) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), com.larus.dora.impl.device_v2.e.class);
        goto L112
    L131:
        return null;
    L81:
        if (r1.equals("general_group") == true) goto L84;
        return null;
    L84:
        if (checkEmpty(r5) == true) goto L133;
        r6 = (o1) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), o1.class);
        goto L112
    L133:
        return null;
    L88:
        if (r1.equals("banner") == true) goto L91;
        return null;
    L91:
        if (checkEmpty(r5) == true) goto L135;
        r6 = (d59.a) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), d59.a.class);
        goto L112
    L135:
        return null;
    L95:
        if (r1.equals("device_name") == true) goto L98;
        return null;
    L98:
        if (checkEmpty(r5) == true) goto L137;
        r6 = (com.larus.dora.impl.dynamic.g) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), com.larus.dora.impl.dynamic.g.class);
        goto L112
    L137:
        return null;
    L102:
        if (r1.equals("single_device_product_display") == true) goto L105;
        return null;
    L105:
        if (checkEmpty(r5) == false) goto L108;
        return null;
    L108:
        if (Intrinsics.areEqual(r5.a().a(), "") == false) goto L110;
        r6 = new l();
        goto L112
    L110:
        r6 = (l) GsonProtectorUtils.fromJson(this.gson, r5.a().a(), l.class);
        goto L112
    L5:
        r1 = null;
        goto L6
    }

    public final void replaceBind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C03251(r8, this, null), 2, null);
    }

    public final void setConnectingJob(Job r1) {
        this.connectingJob = r1;
    }

    public final void setScreenOn(boolean r1) {
        this.isScreenOn = r1;
    }

    public final void unbind(z49.b r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C03281(this, r7, null), 3, null);
    }

    public final void updateRemoveBarData(String r7) {
        Intrinsics.checkNotNullParameter(r7, "mac");
        Pair r0 = (Pair) this.navBarData.getValue();
        if (r0 == null) goto L34;
        d59.b r1 = (d59.b) r0.getSecond();
        List<? extends DoraDevice> r2 = r1.b;
        com.larus.dora.impl.dynamic.e r3 = null;
        if (r2 == null) goto L12;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        Object r6 = r5.next();
        if ((!Intrinsics.areEqual(((DoraDevice) r6).mac, r7)) == false) goto L8;
        r4.add(r6);
    L13:
        List<? extends DoraDevice> r8 = r1.b;
        if (r8 == null) goto L16;
        Integer r9 = Integer.valueOf(r8.size());
    L17:
        if (r4 == null) goto L19;
        Integer r10 = Integer.valueOf(r4.size());
    L21:
        if (Intrinsics.areEqual(r9, r10) == true) goto L35;
        r1.b = r4;
        MutableLiveData<Pair<com.larus.dora.impl.dynamic.e, d59.b>> r11 = this._navBarData;
        LiveData<Pair<com.larus.dora.impl.dynamic.e, d59.b>> r12 = this.navBarData;
        if (r12 == null) goto L27;
        Pair r13 = (Pair) r12.getValue();
        if (r13 == null) goto L27;
        r3 = (com.larus.dora.impl.dynamic.e) r13.getFirst();
    L27:
        r11.postValue(new Pair(r3, r1));
        return;
    L35:
        return;
    L19:
        r10 = null;
        goto L21
    L16:
        r9 = null;
        goto L17
    L12:
        r4 = null;
        goto L13
    }

    public final void updateUi(e r4) {
        Intrinsics.checkNotNullParameter(r4, "uiState");
        String r1 = null;
        if ((r4 instanceof e.b) == false) goto L9;
        MutableLiveData<e59.b> r0 = this._connectionState;
        DoraDevice r5 = ((e.b) r4).a;
        if (r5 == null) goto L7;
        r1 = r5.mac;
    L7:
        r0.postValue(new e59.b.C0125b(r1));
        return;
    L9:
        if ((r4 instanceof e.a) == false) goto L12;
        MutableLiveData<e59.b> r2 = this._connectionState;
        ((e.a) r4).getClass();
        r2.postValue(new e59.b.a(null));
        return;
    L12:
        if ((r4 instanceof e.c) == false) goto L18;
        MutableLiveData<e59.b> r3 = this._connectionState;
        DoraDevice r6 = ((e.c) r4).a;
        if (r6 == null) goto L16;
        r1 = r6.mac;
    L16:
        r3.postValue(new e59.b.c(r1));
        return;
    L18:
        if (Intrinsics.areEqual(r4, e.d.a) == false) goto L22;
        this._connectionState.postValue(e59.b.d.a);
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ void access$handleConnectRequest(DoraDynamicViewModel r0, String r1) {
        r0.handleConnectRequest(r1);
    }

    public static final /* synthetic */ void access$setDeviceStateSeq$p(DoraDynamicViewModel r0, long r1) {
        r0.deviceStateSeq = r1;
    }

    private final Object handleGConnectRequest(DoraDevice r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C03201) == false) goto L7;
        C03201 r0 = (C03201) r11;
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
        s r16 = s.a;     // Catch: Throwable -> L47
        Application r4 = AppHost.a.getApplication();     // Catch: Throwable -> L47
        r16.getClass();     // Catch: Throwable -> L47
        s.b(r4, 2131908080, false);     // Catch: Throwable -> L47
        updateUi(new e.c(r10));     // Catch: Throwable -> L47
        return Unit.INSTANCE;
    L33:
        if (r15 != OnlyBindResult.SERVER_BIND_FAILED) goto L38;
        s r17 = s.a;     // Catch: Throwable -> L47
        AppHost.Companion r5 = AppHost.a;     // Catch: Throwable -> L47
        Application r6 = r5.getApplication();     // Catch: Throwable -> L47
        String r7 = r5.getApplication().getString(2131903938, new Object[]{o59.a.g(r10)});     // Catch: Throwable -> L47
        r17.getClass();     // Catch: Throwable -> L47
        s.c(r6, r7);     // Catch: Throwable -> L47
        updateUi(new e.c(r10));     // Catch: Throwable -> L47
        return Unit.INSTANCE;
    L38:
        if (r15 != OnlyBindResult.SUCCESS) goto L44;
        g49.d.d(TAG, "connect request, bind success, connect spp");     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 2;     // Catch: Throwable -> L47
        if (onlyConnect(r10, r0) != r2) goto L43;
        return r2;
    L44:
        g49.d.d(TAG, "cur device need unbind ");     // Catch: Throwable -> L47
        CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Throwable -> L47
        C03212 r8 = new C03212(this, r10, null);     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 3;     // Catch: Throwable -> L47
        if (BuildersKt.withContext(r18, r8, r0) != r2) goto L49;
        return r2;
    L24:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L47
        DoraDynamicViewModel$handleGConnectRequest$bindResult$1 r9 = new DoraDynamicViewModel$handleGConnectRequest$bindResult$1(r10, null);     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 1;     // Catch: Throwable -> L47
        r12 = BuildersKt.withContext(r110, r9, r0);     // Catch: Throwable -> L47
        if (r12 != r2) goto L28;
        return r2;
    L47:
        s r111 = s.a;
        Application r20 = AppHost.a.getApplication();
        r111.getClass();
        s.b(r20, 2131903672, false);
        this._connectionState.setValue(new e59.b.c(r10.mac));
    L7:
        r0 = new C03201(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object handleNotGConnectRequest(DoraDevice r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof C03221) == false) goto L7;
        C03221 r0 = (C03221) r6;
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
        s r10 = s.a;
        Application r4 = AppHost.a.getApplication();
        r10.getClass();
        s.b(r4, 2131903672, false);
        this._connectionState.setValue(new e59.b.c(r5.mac));
    L7:
        r0 = new C03221(this, r6);
        goto L8
    }

    public final Object connect(DoraDevice r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof C03161) == false) goto L7;
        C03161 r2 = (C03161) r12;
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
        DoraDevice r14 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L49
    L51:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r11 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L49
    L44:
        updateUi(new e.c(r11));     // Catch: Throwable -> L49
        goto L51
    L21:
        r11 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L49
    L35:
        BindAndConnectResult r15 = (BindAndConnectResult) r13;     // Catch: Throwable -> L49
        g49.d.d(TAG, "connect: " + o59.a.h(r11) + " result = " + r15);     // Catch: Throwable -> L49
        switch(f.b[r15.ordinal()]) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L41;
            case 5: goto L41;
            case 6: goto L38;
            case 7: goto L51;
            default: goto L48;
        };     // Catch: Throwable -> L49
    L38:
        MutableSharedFlow<Object> r16 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L49
        com.larus.dora.impl.dynamic.viewmodel.b r0 = new com.larus.dora.impl.dynamic.viewmodel.b(r11);     // Catch: Throwable -> L49
        r2.L$0 = r11;     // Catch: Throwable -> L49
        r2.label = 3;     // Catch: Throwable -> L49
        if (r16.emit(r0, r2) != r4) goto L51;
        return r4;
    L41:
        MutableSharedFlow<Object> r17 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L49
        com.larus.dora.impl.dynamic.viewmodel.c r1 = new com.larus.dora.impl.dynamic.viewmodel.c(r11);     // Catch: Throwable -> L49
        r2.L$0 = r11;     // Catch: Throwable -> L49
        r2.label = 2;     // Catch: Throwable -> L49
        if (r17.emit(r1, r2) != r4) goto L44;
        return r4;
    L45:
        s r18 = s.a;     // Catch: Throwable -> L49
        AppHost.Companion r6 = AppHost.a;     // Catch: Throwable -> L49
        Application r7 = r6.getApplication();     // Catch: Throwable -> L49
        String r8 = r6.getApplication().getString(2131903938, new Object[]{o59.a.g(r11)});     // Catch: Throwable -> L49
        r18.getClass();     // Catch: Throwable -> L49
        s.c(r7, r8);     // Catch: Throwable -> L49
        updateUi(new e.c(r11));     // Catch: Throwable -> L49
        goto L51
    L46:
        s r110 = s.a;     // Catch: Throwable -> L49
        Application r9 = AppHost.a.getApplication();     // Catch: Throwable -> L49
        r110.getClass();     // Catch: Throwable -> L49
        s.b(r9, 2131908080, false);     // Catch: Throwable -> L49
        updateUi(new e.c(r11));     // Catch: Throwable -> L49
        goto L51
    L48:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L49
    L24:
        ResultKt.throwOnFailure(r13);
        updateUi(new e.b(r11));
        StringBuilder r111 = new StringBuilder("start connect ");     // Catch: Throwable -> L49
        if (r11 == null) goto L28;
        String r10 = o59.a.h(r11);     // Catch: Throwable -> L49
    L29:
        r111.append(r10);     // Catch: Throwable -> L49
        g49.d.d(TAG, r111.toString());     // Catch: Throwable -> L49
        if (r11 != null) goto L32;
        s r112 = s.a;     // Catch: Throwable -> L49
        Application r20 = AppHost.a.getApplication();     // Catch: Throwable -> L49
        r112.getClass();     // Catch: Throwable -> L49
        s.b(r20, 2131903672, false);     // Catch: Throwable -> L49
        updateUi(new e.c(r11));     // Catch: Throwable -> L49
        goto L51
    L32:
        CoroutineDispatcher r113 = Dispatchers.getIO();     // Catch: Throwable -> L49
        DoraDynamicViewModel$connect$connectResult$1 r21 = new DoraDynamicViewModel$connect$connectResult$1(r11, null);     // Catch: Throwable -> L49
        r2.L$0 = r11;     // Catch: Throwable -> L49
        r2.label = 1;     // Catch: Throwable -> L49
        r13 = BuildersKt.withContext(r113, r21, r2);     // Catch: Throwable -> L49
        if (r13 != r4) goto L35;
        return r4;
    L28:
        r10 = null;
    L49:
        updateUi(new e.c(r11));
    L7:
        r2 = new C03161(this, r12);
        goto L8
    }

    public final Object onlyConnect(DoraDevice r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof C03241) == false) goto L7;
        C03241 r2 = (C03241) r10;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r11 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L17;
        if (r5 != 2) goto L16;
        r9 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L44
    L42:
        updateUi(new e.c(r9));     // Catch: Throwable -> L44
    L46:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r9 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L44
    L31:
        OnlyConnectResult r12 = (OnlyConnectResult) r11;     // Catch: Throwable -> L44
        g49.d.d(TAG, "connect: " + o59.a.h(r9) + " result = " + r12);     // Catch: Throwable -> L44
        int r13 = f.a[r12.ordinal()];     // Catch: Throwable -> L44
        if (r13 == 1) goto L39;
        if (r13 == 2) goto L39;
        if (r13 == 3) goto L46;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L44
    L39:
        MutableSharedFlow<Object> r14 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L44
        com.larus.dora.impl.dynamic.viewmodel.c r0 = new com.larus.dora.impl.dynamic.viewmodel.c(r9);     // Catch: Throwable -> L44
        r2.L$0 = r9;     // Catch: Throwable -> L44
        r2.label = 2;     // Catch: Throwable -> L44
        if (r14.emit(r0, r2) != r4) goto L42;
        return r4;
    L20:
        ResultKt.throwOnFailure(r11);
        updateUi(new e.b(r9));
        StringBuilder r15 = new StringBuilder("start connect ");     // Catch: Throwable -> L44
        if (r9 == null) goto L24;
        String r6 = o59.a.h(r9);     // Catch: Throwable -> L44
    L25:
        r15.append(r6);     // Catch: Throwable -> L44
        g49.d.d(TAG, r15.toString());     // Catch: Throwable -> L44
        if (r9 != null) goto L28;
        s r16 = s.a;     // Catch: Throwable -> L44
        Application r1 = AppHost.a.getApplication();     // Catch: Throwable -> L44
        r16.getClass();     // Catch: Throwable -> L44
        s.b(r1, 2131903672, false);     // Catch: Throwable -> L44
        updateUi(new e.c(r9));     // Catch: Throwable -> L44
        goto L46
    L28:
        CoroutineDispatcher r17 = Dispatchers.getIO();     // Catch: Throwable -> L44
        DoraDynamicViewModel$onlyConnect$connectResult$1 r7 = new DoraDynamicViewModel$onlyConnect$connectResult$1(r9, null);     // Catch: Throwable -> L44
        r2.L$0 = r9;     // Catch: Throwable -> L44
        r2.label = 1;     // Catch: Throwable -> L44
        r11 = BuildersKt.withContext(r17, r7, r2);     // Catch: Throwable -> L44
        if (r11 != r4) goto L31;
        return r4;
    L24:
        r6 = null;
    L44:
        updateUi(new e.c(r9));
    L7:
        r2 = new C03241(this, r10);
        goto L8
    }

    public static final /* synthetic */ Object access$handleGConnectRequest(DoraDynamicViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.handleGConnectRequest(r1, r2);
    }

    public static final /* synthetic */ Object access$handleNotGConnectRequest(DoraDynamicViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.handleNotGConnectRequest(r1, r2);
    }

    private final Object scanBleInfo(String r10, long r11, Continuation<? super DoraDevice> r13) {
        if ((r13 instanceof C03261) == false) goto L7;
        C03261 r0 = (C03261) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r12 = r0.J$0;
        h r15 = (h) r0.L$1;
        Ref.ObjectRef r4 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        g49.d.d(TAG, "scan ble info cost: " + (System.currentTimeMillis() - r12));
        kj4.a.g().stopScan(r15);
        return r4.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        long r5 = System.currentTimeMillis();
        CompletableDeferred r6 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        h r8 = new h(r6, r10, r7);
        kj4.a.g().scan(CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"}), r8);
        C03272 r16 = new C03272(r6, null);
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.J$0 = r5;
        r0.label = 1;
        if (TimeoutKt.c(r11, r16, r0) != r2) goto L17;
        return r2;
    L17:
        r12 = r5;
        r4 = r7;
        r15 = r8;
    L7:
        r0 = new C03261(this, r13);
        goto L8
    }

    public final synchronized void fetchData(z49.b r8, boolean r9, String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "simpleDevice");     // Catch: Throwable -> L15
        FLogger.a.i(TAG, "fetchData device :" + r8 + ",isCurrent:" + r9 + ",pageKey:" + r10 + ' ');     // Catch: Throwable -> L15
        DoraDevice r0 = r8.a;     // Catch: Throwable -> L15
        if (r0 == null) goto L7;
        Integer r1 = Integer.valueOf(r0.type);     // Catch: Throwable -> L15
    L9:
        if (o59.a.n(r1) == false) goto L11;
        int r2 = ProductNameType.DORA_G.id;     // Catch: Throwable -> L15
    L12:
        this.dataLoader.b(ViewModelKt.getViewModelScope(this), Integer.valueOf(r2), r8.d(), r10, new g(this, r8, r9));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L11:
        r2 = n1.d(r8);     // Catch: Throwable -> L15
        goto L12
    L7:
        r1 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final void updateConnectState(c r13, Map<String, String> r14, z49.b r15) {
        Intrinsics.checkNotNullParameter(r13, "status");
        Intrinsics.checkNotNullParameter(r15, "simpleDoraDevice");
        boolean r0 = r13 instanceof c.a;
        FLogger.a.e(TAG, "updateConnectState, connected is " + r0);
        List<d59.c> r1 = this.mDataList;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r1.iterator();
    L3:
        d59.c r2 = null;
        if (r10.hasNext() == false) goto L17;
        d59.c r3 = (d59.c) r10.next();
        j r4 = r3.e;
        if (r4 == null) goto L8;
        Boolean r5 = Boolean.valueOf(r4.a(r0));
    L10:
        if (Intrinsics.areEqual(r3.d, "feedback") == false) goto L13;
        r5 = Boolean.TRUE;
    L13:
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == true) goto L15;
        String r6 = r3.a;
        String r7 = r3.b;
        String r8 = r3.c;
        String r11 = r3.d;
        j r12 = r3.e;
        Intrinsics.checkNotNullParameter(r13, "connectStatus");
        r2 = new d59.c(r6, r7, r8, r11, r12, r0, r13);
    L15:
        if (r2 == null) goto L3;
        r9.add(r2);
        goto L3
    L8:
        r5 = null;
        goto L10
    L17:
        this._itemListData.postValue(new Pair(r9, new d59.b(r15, kj4.a.g().getDoraBindList(), r14, "")));
        if (r0 == false) goto L21;
        Object r16 = new e59.b.a(((c.a) r13).a);
    L29:
        this._connectionState.postValue(r16);
        return;
    L21:
        if ((r13 instanceof c.b) == false) goto L24;
        ((c.b) r13).getClass();
        r16 = new e59.b.C0125b(null);
        goto L29
    L24:
        if ((r13 instanceof c.C0075c) == false) goto L27;
        r16 = new e59.b.c(((c.C0075c) r13).a);
        goto L29
    L27:
        if ((r13 instanceof c.d) == false) goto L32;
        r16 = e59.b.d.a;
        goto L29
    L32:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Object access$scanBleInfo(DoraDynamicViewModel r0, String r1, long r2, Continuation r4) {
        return r0.scanBleInfo(r1, r2, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkSodaBanner$default(DoraDynamicViewModel r0, List r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.checkSodaBanner(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkSodaBanner");
    }

    private final void sendData(z49.b r5, List<com.larus.dora.impl.dynamic.d> r6, com.larus.dora.impl.dynamic.e r7, Map<String, String> r8, boolean r9) {
        this.mDataList = getData(r6);
        this._navBarData.postValue(new Pair(r7, new d59.b(r5, kj4.a.g().getDoraBindList(), r8, "")));
        String r0 = null;
        if ((this._deviceStateFlow.getValue() instanceof d.a) == false) goto L12;
        Object r10 = this._deviceStateFlow.getValue();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel.DeviceStateV2.Connected");
        DoraDevice r11 = ((d.a) r10).b;
        FLogger.a.e(TAG, "connectDevice: " + r11);
        if (r5 == null) goto L7;
        String r1 = r5.c();
    L9:
        if (Intrinsics.areEqual(r1, r11.mac) == false) goto L12;
        if (r5 == null) goto L12;
        r5.a = r11;
        goto L12
    L7:
        r1 = null;
    L12:
        if (r9 == false) goto L18;
        if (r5 == null) goto L16;
        r0 = r5.c();
    L16:
        updateConnectState(new c.a(r0), r8, r5);
    L21:
        FLogger.a.e(TAG, "dataList, size is " + this.mDataList.size());
        return;
    L18:
        if (r5 == null) goto L20;
        r0 = r5.c();
    L20:
        updateConnectState(new c.C0075c(r0), r8, r5);
        goto L21
    }

    public static final /* synthetic */ void access$sendData(DoraDynamicViewModel r0, z49.b r1, List r2, com.larus.dora.impl.dynamic.e r3, Map r4, boolean r5) {
        r0.sendData(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Object scanBleInfo$default(DoraDynamicViewModel r0, String r1, long r2, Continuation r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 2) == 0) goto L7;
        r2 = 10000;
    L7:
        return r0.scanBleInfo(r1, r2, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scanBleInfo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateConnectState$default(DoraDynamicViewModel r0, c r1, Map r2, z49.b r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L6;
        r2 = MapsKt.emptyMap();
    L6:
        r0.updateConnectState(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateConnectState");
    }
}
