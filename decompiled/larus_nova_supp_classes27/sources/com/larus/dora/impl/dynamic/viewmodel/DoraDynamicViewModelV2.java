package com.larus.dora.impl.dynamic.viewmodel;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c59.a0;
import c59.d0;
import c59.m;
import c59.n;
import c59.z;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.DoraSimpleDevice;
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
import com.larus.dora.impl.network.e0;
import com.larus.dora.impl.network.w;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.util.b0;
import com.larus.im.bean.bot.BotModel;
import com.larus.network.util.ScreenStateManager;
import com.larus.platform.model.NewcomerGuideItem;
import com.larus.settings.value.e10;
import com.larus.settings.value.yh;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r*\u0004ipsy\b\u0016\u0018\u0000 ¨\u00012\u00020\u00012\u00020\u0002:\u0010¨\u0001©\u0001ª\u0001«\u0001¬\u0001\u00ad\u0001®\u0001¯\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010P\u001a\u00020Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020I0HJ\u0010\u0010e\u001a\u00020Q2\u0006\u0010f\u001a\u00020gH\u0016J\u001a\u0010u\u001a\u00020Q2\b\u0010v\u001a\u0004\u0018\u00010V2\b\b\u0002\u0010w\u001a\u00020\u0006J\u0006\u0010{\u001a\u00020QJ\u0012\u0010|\u001a\u00020Q2\b\u0010}\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010~\u001a\u00020/2\b\u0010}\u001a\u0004\u0018\u00010MH\u0094@¢\u0006\u0002\u0010\u007fJ\u0018\u0010\u0080\u0001\u001a\u00020Q2\u0006\u0010v\u001a\u00020VH\u0082@¢\u0006\u0003\u0010\u0081\u0001J%\u0010\u0082\u0001\u001a\u0004\u0018\u00010V2\u0006\u0010}\u001a\u00020M2\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u0006H\u0082@¢\u0006\u0003\u0010\u0084\u0001J\u0018\u0010\u0085\u0001\u001a\u00020Q2\u0006\u0010v\u001a\u00020VH\u0082@¢\u0006\u0003\u0010\u0081\u0001J\u0011\u0010\u0086\u0001\u001a\u00020Q2\u0006\u0010v\u001a\u00020VH\u0016J\u001c\u0010\u0087\u0001\u001a\u00020Q2\u0013\b\u0002\u0010\u0088\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010HJ\u0011\u0010\u0089\u0001\u001a\u00020Q2\b\u0010v\u001a\u0004\u0018\u00010VJ\u001a\u0010\u008a\u0001\u001a\u00020Q2\b\u0010v\u001a\u0004\u0018\u00010VH\u0086@¢\u0006\u0003\u0010\u0081\u0001J\u001a\u0010\u008b\u0001\u001a\u00020Q2\b\u0010v\u001a\u0004\u0018\u00010VH\u0086@¢\u0006\u0003\u0010\u0081\u0001J\t\u0010\u008c\u0001\u001a\u00020QH\u0014J6\u0010\u008d\u0001\u001a\u00020Q2\u0007\u0010\u008e\u0001\u001a\u00020l2\u0007\u0010\u008f\u0001\u001a\u00020/2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010M¢\u0006\u0003\u0010\u0093\u0001J\u0019\u0010\u0094\u0001\u001a\u00020Q2\u0007\u0010\u0095\u0001\u001a\u00020M2\u0007\u0010\u0096\u0001\u001a\u00020MJ\u0007\u0010\u0097\u0001\u001a\u00020QJ\n\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0002J\u0012\u0010\u009a\u0001\u001a\u00020Q2\u0007\u0010\u008e\u0001\u001a\u00020lH\u0002J\u0011\u0010\u009b\u0001\u001a\u00020Q2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001J\u000f\u0010\u009e\u0001\u001a\u00020Q2\u0006\u0010}\u001a\u00020MJ\u000f\u0010\u009f\u0001\u001a\u00020Q2\u0006\u0010v\u001a\u00020VJ\u0007\u0010 \u0001\u001a\u00020QJ\u0011\u0010¡\u0001\u001a\u00020Q2\b\u0010¢\u0001\u001a\u00030£\u0001J\u0012\u0010¤\u0001\u001a\u00020Q2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010lJ\u0012\u0010¥\u0001\u001a\u00020Q2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010lJ\t\u0010¦\u0001\u001a\u00020QH\u0002J\t\u0010§\u0001\u001a\u00020QH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020+0'¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020/0'¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0014\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u0002030\u001c¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001eR\u0014\u00106\u001a\b\u0012\u0004\u0012\u0002070\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00108\u001a\b\u0012\u0004\u0012\u0002070\u001c¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001eR\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020/0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020/0\u001c¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001eR\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u0019X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\u001c¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001eR\u0016\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0'¢\u0006\b\n\u0000\u001a\u0004\bF\u0010)R\u001a\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0H0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0H0'¢\u0006\b\n\u0000\u001a\u0004\bK\u0010)R\u0016\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0'¢\u0006\b\n\u0000\u001a\u0004\bO\u0010)R\"\u0010S\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020U\u0012\u0006\u0012\u0004\u0018\u00010V0T0\bX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010W\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020U\u0012\u0006\u0012\u0004\u0018\u00010V0T0\u000b¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\rR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020/X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0010\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0004\n\u0002\u0010jR\u0016\u0010k\u001a\u0004\u0018\u00010l8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0010\u0010o\u001a\u00020pX\u0082\u0004¢\u0006\u0004\n\u0002\u0010qR\u0010\u0010r\u001a\u00020sX\u0082\u0004¢\u0006\u0004\n\u0002\u0010tR\u0010\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0004\n\u0002\u0010z¨\u0006°\u0001"}, d2 = {"Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "Landroidx/lifecycle/ViewModel;", "Lcom/larus/dora/impl/dynamic/event/ActionHandler;", "<init>", "()V", "deviceStateSeq", "", "_sodaBannerSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/network/ActivityStatus;", "sodaBannerSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getSodaBannerSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_deviceBindStatusFlow", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$DeviceBindAction;", "deviceBindStatusFlow", "getDeviceBindStatusFlow", "_deviceIntentSharedFlow", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$DeviceActionV2;", "get_deviceIntentSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "deviceIntentSharedFlow", "getDeviceIntentSharedFlow", "_pageInfoData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;", "pageInfoData", "Landroidx/lifecycle/LiveData;", "getPageInfoData", "()Landroidx/lifecycle/LiveData;", "_cardContextData", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "cardContextData", "getCardContextData", "_deviceStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$DeviceStateV2;", "deviceStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getDeviceStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_deviceBatteryStateFlow", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$BatteryState;", "deviceBatteryStateFlow", "getDeviceBatteryStateFlow", "_headphoneModeStateFlow", "", "headphoneModeStateFlow", "getHeadphoneModeStateFlow", "_dialogEvent", "Lcom/larus/dora/impl/dynamic/event/DialogEvent;", "dialogEvent", "getDialogEvent", "_viewHolderEvent", "Lcom/larus/dora/impl/dynamic/event/ViewHolderEvent;", "viewHolderEvent", "getViewHolderEvent", "_showProactiveEntryLiveData", "showProactiveEntryLiveData", "getShowProactiveEntryLiveData", "_connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "get_connectionState", "()Landroidx/lifecycle/MutableLiveData;", "connectionState", "getConnectionState", "_onboardingStatusFlow", "Lcom/larus/dora/impl/network/OnboardingStatus;", "onboardingStatusFlow", "getOnboardingStatusFlow", "_newcomerGuideConfigFlow", "", "Lcom/larus/platform/model/NewcomerGuideItem;", "newcomerGuideConfigFlow", "getNewcomerGuideConfigFlow", "_avatarUrlFlow", "", "avatarUrlFlow", "getAvatarUrlFlow", "updateNewcomerGuideConfig", "", "items", "_unbindStateFlow", "Lkotlin/Pair;", "Lcom/larus/dora/impl/device/settings/general/IntentState;", "Lcom/bytedance/dora/device/DoraDevice;", "unbindStateFlow", "getUnbindStateFlow", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "isScreenOn", "()Z", "setScreenOn", "(Z)V", "connectingJob", "Lkotlinx/coroutines/Job;", "getConnectingJob", "()Lkotlinx/coroutines/Job;", "setConnectingJob", "(Lkotlinx/coroutines/Job;)V", "onAction", "action", "Lcom/larus/dora/impl/dynamic/event/ViewHolderAction;", "screenListener", "com/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$screenListener$1", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$screenListener$1;", "lastConnectDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "getLastConnectDevice", "()Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "doraBudsCallback", "com/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$doraBudsCallback$1", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$doraBudsCallback$1;", "doraLinkCallback", "com/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$doraLinkCallback$1", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$doraLinkCallback$1;", "checkLocalBindState", "device", "delayTime", "doraHeadphoneModeCallback", "com/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$doraHeadphoneModeCallback$1", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$doraHeadphoneModeCallback$1;", "loadDeviceFeature", "handleConnectRequest", "mac", "isBluetoothConnectedForReconnect", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleGConnectRequest", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanBleInfo", "timeout", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNotGConnectRequest", "checkBindState", "checkSodaBanner", "activitiesStatus", "connectAsync", "onlyConnect", "connect", "onCleared", "fetchData", "simpleDevice", "isCurrent", "vendorId", "", "pageKey", "(Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;ZLjava/lang/Integer;Ljava/lang/String;)V", "fetchOnboardingStatus", "productId", "wdid", "fetchNewcomerGuideConfig", "createFeedbackCard", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "updateCardContext", "updateConnectState", "status", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$ConnectState;", "updateRemoveBarData", "replaceBind", "disconnectSpp", "updateUi", "uiState", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2$UiState;", "onlyLocalUnbind", "unbind", "loadLabSettingConfig", "loadHeadphoneMode", "Companion", "DeviceBindAction", "EventNotification", "BatteryState", "DeviceStateV2", "DeviceActionV2", "UiState", "ConnectState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraDynamicViewModelV2 extends ViewModel implements e59.a {
    public static final b Companion = null;
    public static final String LAB_FEATURE_CONFIG_REQUEST = "/alice/w/starweave/feature-visibility/matched";
    public static final String TAG = "DoraDynamicViewModelV2";
    private final z0<String> _avatarUrlFlow;
    private final MutableLiveData<d59.b> _cardContextData;
    private final MutableLiveData<e59.b> _connectionState;
    private final z0<a> _deviceBatteryStateFlow;
    private final MutableSharedFlow<e> _deviceBindStatusFlow;
    private final MutableSharedFlow<d> _deviceIntentSharedFlow;
    private final z0<f> _deviceStateFlow;
    private final MutableLiveData<e59.d> _dialogEvent;
    private final z0<Boolean> _headphoneModeStateFlow;
    private final z0<List<NewcomerGuideItem>> _newcomerGuideConfigFlow;
    private final z0<w> _onboardingStatusFlow;
    private final MutableLiveData<m> _pageInfoData;
    private final MutableLiveData<Boolean> _showProactiveEntryLiveData;
    private final MutableSharedFlow<com.larus.dora.impl.network.a> _sodaBannerSharedFlow;
    private final MutableSharedFlow<Pair<IntentState, DoraDevice>> _unbindStateFlow;
    private final MutableLiveData<e59.f> _viewHolderEvent;
    private final i1<String> avatarUrlFlow;
    private final LiveData<d59.b> cardContextData;
    private Job connectingJob;
    private final LiveData<e59.b> connectionState;
    private final com.larus.dora.impl.dynamic.loader.d dataLoader;
    private final i1<a> deviceBatteryStateFlow;
    private final d1<e> deviceBindStatusFlow;
    private final d1<d> deviceIntentSharedFlow;
    private final i1<f> deviceStateFlow;
    private long deviceStateSeq;
    private final LiveData<e59.d> dialogEvent;
    private final DoraDynamicViewModelV2$doraBudsCallback$1 doraBudsCallback;
    private final DoraDynamicViewModelV2$doraHeadphoneModeCallback$1 doraHeadphoneModeCallback;
    private final DoraDynamicViewModelV2$doraLinkCallback$1 doraLinkCallback;
    private final i1<Boolean> headphoneModeStateFlow;
    private boolean isScreenOn;
    private final i1<List<NewcomerGuideItem>> newcomerGuideConfigFlow;
    private final i1<w> onboardingStatusFlow;
    private final LiveData<m> pageInfoData;
    private final k screenListener;
    private final LiveData<Boolean> showProactiveEntryLiveData;
    private final d1<com.larus.dora.impl.network.a> sodaBannerSharedFlow;
    private final d1<Pair<IntentState, DoraDevice>> unbindStateFlow;
    private final LiveData<e59.f> viewHolderEvent;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {319}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DoraDynamicViewModelV2 a;

            public a(DoraDynamicViewModelV2 r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                f r5 = (f) r3;
                String r0 = null;
                if (Intrinsics.areEqual(r5, f.d.a) == false) goto L15;
                DoraDevice r6 = DoraAdapterExtKt.h(kj4.a.g());
                if (kj4.a.g().getDoraState() != 2) goto L10;
                MutableLiveData<e59.b> r7 = this.a.get_connectionState();
                if (r6 == null) goto L9;
                r0 = r6.mac;
            L9:
                r7.setValue(new e59.b.a(r0));
            L27:
                return Unit.INSTANCE;
            L10:
                MutableLiveData<e59.b> r8 = this.a.get_connectionState();
                if (r6 == null) goto L13;
                r0 = r6.mac;
            L13:
                r8.setValue(new e59.b.c(r0));
                goto L27
            L15:
                if ((r5 instanceof f.a) == false) goto L18;
                this.a.get_connectionState().setValue(new e59.b.a(((f.a) r5).b.mac));
                goto L27
            L18:
                if ((r5 instanceof f.b) == false) goto L21;
                MutableLiveData<e59.b> r9 = this.a.get_connectionState();
                ((f.b) r5).getClass();
                r9.setValue(new e59.b.C0125b(null));
                goto L27
            L21:
                if ((r5 instanceof f.c) == false) goto L27;
                MutableLiveData<e59.b> r10 = this.a.get_connectionState();
                z49.b r11 = ((f.c) r5).b;
                if (r11 == null) goto L25;
                r0 = r11.c();
            L25:
                r10.setValue(new e59.b.c(r0));
                goto L27
            }
        }

        public AnonymousClass1(DoraDynamicViewModelV2 r1, Continuation<? super AnonymousClass1> r2) {
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
            i1<f> r6 = this.this$0.getDeviceStateFlow();
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

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$c$c, reason: collision with other inner class name */
        public static final class C0077c implements c {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0077c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0077c) r4).a) == true) goto L11;
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

            public C0077c(String r1) {
                this.a = r1;
            }
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$checkBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$checkBindState$1", f = "DoraDynamicViewModelV2.kt", i = {2, 3, 4}, l = {572, 574, 581, 586, 588}, m = "invokeSuspend", n = {"bindData", "bindData", "bindData"}, s = {"L$3", "L$2", "L$2"})
    public static final class C03291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03291(DoraDynamicViewModelV2 r1, DoraDevice r2, Continuation<? super C03291> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03291(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r17) {
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
            com.larus.dora.impl.network.b r1 = (com.larus.dora.impl.network.b) this.L$2;
            DoraDynamicViewModelV2 r2 = (DoraDynamicViewModelV2) this.L$1;
            Object r3 = this.L$0;
            ResultKt.throwOnFailure(r17);
        L53:
            com.larus.dora.impl.network.b r15 = r1;
            DoraDynamicViewModelV2 r14 = r2;
            Object r12 = r3;
        L54:
            r14.checkSodaBanner(r15.a());
        L55:
            Throwable r4 = Result.exceptionOrNull-impl(r12);
            if (r4 == null) goto L59;
            g49.d.c("DoraDynamicViewModelV2", "checkBindState: failure", r4);
            s r5 = s.a;
            Application r6 = AppHost.a.getApplication();
            r5.getClass();
            s.b(r6, 2131908080, false);
        L59:
            return Unit.INSTANCE;
        L13:
            com.larus.dora.impl.network.b r7 = (com.larus.dora.impl.network.b) this.L$3;
            r2 = (DoraDynamicViewModelV2) this.L$2;
            DoraDevice r9 = (DoraDevice) this.L$1;
            Object r10 = this.L$0;
            ResultKt.throwOnFailure(r17);
            r15 = r7;
            Object r11 = r17;
        L40:
            DoraDevice r13 = (DoraDevice) r11;
            if (r13 == null) goto L43;
            r9.mode = r13.mode;
            r9.version = r13.version;
        L43:
            DoraDevice r16 = r9;
            r3 = r10;
        L44:
            r1 = r15;
            MutableSharedFlow<d> r18 = r2.get_deviceIntentSharedFlow();
            d.a r20 = new d.a(r16);
            this.L$0 = r3;
            this.L$1 = r2;
            this.L$2 = r1;
            this.L$3 = null;
            this.label = 4;
            if (r18.emit(r20, this) != r8) goto L53;
            return r8;
        L14:
            ResultKt.throwOnFailure(r17);
            Object r21 = ((Result) r17).unbox-impl();
        L24:
            r12 = r21;
            r16 = this.$device;
            r14 = this.this$0;
            if (Result.isSuccess-impl(r12) == false) goto L55;
            r15 = (com.larus.dora.impl.network.b) r12;
            Integer r22 = r15.b();
            if (r22 == null) goto L29;
            int r23 = r22.intValue();
        L30:
            g49.d.d("DoraDynamicViewModelV2", "checkBindState: bindCode=" + r23);
            if (r23 == 1) goto L49;
            if (r23 != 2) goto L54;
            if (o59.a.p(r16) == false) goto L45;
            String r24 = r16.mac;
            this.L$0 = r12;
            this.L$1 = r16;
            this.L$2 = r14;
            this.L$3 = r15;
            this.label = 3;
            r11 = DoraDynamicViewModelV2.scanBleInfo$default(r14, r24, 0, this, 2, null);
            if (r11 != r8) goto L39;
            return r8;
        L39:
            r10 = r12;
            r9 = r16;
            r2 = r14;
            goto L40
        L45:
            r3 = r12;
            r2 = r14;
            goto L44
        L49:
            kj4.a r25 = kj4.a.g();
            this.L$0 = r12;
            this.L$1 = r14;
            this.L$2 = r15;
            this.label = 5;
            if (DoraAdapterExtKt.b(r25) != r8) goto L52;
            return r8;
        L52:
            r3 = r12;
            r2 = r14;
            r1 = r15;
            goto L53
        L29:
            r23 = 0;
            goto L30
        L15:
            ResultKt.throwOnFailure(r17);
        L21:
            DoraNetworkApi r26 = DoraNetworkApi.a;
            DoraDevice r27 = this.$device;
            this.label = 2;
            r21 = r26.e(r27, true, this);
            if (r21 != r8) goto L24;
            return r8;
        L16:
            ResultKt.throwOnFailure(r17);
            if (this.this$0.isScreenOn() == true) goto L21;
            this.label = 1;
            if (DelayKt.delay(500, this) != r8) goto L21;
            return r8;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$checkLocalBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$checkLocalBindState$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayTime;
        final /* synthetic */ DoraDevice $device;
        int label;

        public C03301(long r1, DoraDevice r3, Continuation<? super C03301> r4) {
            this.$delayTime = r1;
            this.$device = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03301(this.$delayTime, this.$device, r5);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$checkSodaBanner$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$checkSodaBanner$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {604}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03311(DoraDynamicViewModelV2 r1, Continuation<? super C03311> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03311(this.this$0, r3);
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
            MutableSharedFlow r7 = DoraDynamicViewModelV2.access$get_sodaBannerSharedFlow$p(this.this$0);
            com.larus.dora.impl.network.a r3 = new com.larus.dora.impl.network.a(1, false);
            this.label = 1;
            if (r7.emit(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$checkSodaBanner$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$checkSodaBanner$2", f = "DoraDynamicViewModelV2.kt", i = {}, l = {619}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.dora.impl.network.a $status;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public AnonymousClass2(com.larus.dora.impl.network.a r1, DoraDynamicViewModelV2 r2, Continuation<? super AnonymousClass2> r3) {
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
            g49.d.d("DoraDynamicViewModelV2", "sodaBannerSharedFlow ishow " + this.$status.a());
            if (this.$status.a() == false) goto L11;
            b0.a.getClass();
            b0.J(true, r6);
        L12:
            MutableSharedFlow r7 = DoraDynamicViewModelV2.access$get_sodaBannerSharedFlow$p(this.this$0);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$connect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2", f = "DoraDynamicViewModelV2.kt", i = {0, 1, 2}, l = {691, 720, 724}, m = "connect", n = {"device", "device", "device"}, s = {"L$0", "L$0", "L$0"})
    public static final class C03321 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03321(DoraDynamicViewModelV2 r1, Continuation<? super C03321> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.connect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$connectAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$connectAsync$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03331(DoraDevice r1, DoraDynamicViewModelV2 r2, Continuation<? super C03331> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03331(this.$device, this.this$0, r4);
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
                return this.a.hashCode();
            }

            public final String toString() {
                return "NeedUnbind(device=" + this.a + ')';
            }

            public a(DoraDevice r2) {
                Intrinsics.checkNotNullParameter(r2, "device");
                this.a = r2;
            }
        }

        public static final class b implements d {
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
                return "ShowDisconnectFailedDialog(device=" + this.a + ')';
            }

            public b(DoraDevice r2) {
                Intrinsics.checkNotNullParameter(r2, "device");
                this.a = r2;
            }
        }

        public static final class c implements d {
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
                return this.a.hashCode();
            }

            public final String toString() {
                return "ShowFailureToast(text=" + this.a + ')';
            }

            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "text");
                this.a = r2;
            }
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$disconnectSpp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$disconnectSpp$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {943, 946}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03341(DoraDynamicViewModelV2 r1, Continuation<? super C03341> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03341(this.this$0, r3);
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
            f r7 = (f) DoraDynamicViewModelV2.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r7 instanceof f.a) == false) goto L15;
            kj4.a r2 = kj4.a.g();
            DoraDevice r8 = ((f.a) r7).b;
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

    public interface f {

        public static final class a implements f {
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

        public static final class b implements f {
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

        public static final class c implements f {
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

        public static final class d implements f {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$fetchOnboardingStatus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$fetchOnboardingStatus$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {831}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $productId;
        final /* synthetic */ String $wdid;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$fetchOnboardingStatus$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$fetchOnboardingStatus$1$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DoraDynamicViewModelV2 this$0;

            public C00781(DoraDynamicViewModelV2 r1, Continuation<? super C00781> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00781(this.this$0, r3);
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
                this.this$0.fetchNewcomerGuideConfig();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$fetchOnboardingStatus$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$fetchOnboardingStatus$1$2", f = "DoraDynamicViewModelV2.kt", i = {}, l = {811}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DoraDynamicViewModelV2 this$0;

            public AnonymousClass2(DoraDynamicViewModelV2 r1, Continuation<? super AnonymousClass2> r2) {
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

            public final Object invokeSuspend(Object r11) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                boolean r2 = true;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r11);
                Object r12 = ((Result) r11).unbox-impl();
            L11:
                DoraDynamicViewModelV2 r3 = this.this$0;
                if (Result.isSuccess-impl(r12) == false) goto L63;
                e0 r4 = (e0) r12;
                StringBuilder r5 = new StringBuilder("userLaunch success: ");
                List<com.larus.dora.impl.network.c> r6 = r4.a();
                String r7 = null;
                if (r6 == null) goto L16;
                Integer r8 = Boxing.boxInt(r6.size());
            L17:
                r5.append(r8);
                g49.d.d("DoraDynamicViewModelV2", r5.toString());
                Object r9 = ServiceManager.get().getService(IDoraService.class);
                if ((r9 instanceof DoraServiceImpl) == false) goto L20;
                DoraServiceImpl r10 = (DoraServiceImpl) r9;
            L21:
                if (r10 == null) goto L23;
                BotModel r13 = r10.F;
            L24:
                if (r13 == null) goto L30;
                String r14 = r13.getBotIconMappedAppIcon();
                if (r14 == null) goto L30;
                Integer r15 = StringsKt.toIntOrNull(r14);
                if (r15 == null) goto L30;
                int r16 = r15.intValue();
            L31:
                List<com.larus.dora.impl.network.c> r17 = r4.a();
                if (r17 == null) goto L50;
                Iterator<T> r18 = r17.iterator();
            L35:
                if (r18.hasNext() == false) goto L47;
                Object r20 = r18.next();
                com.larus.dora.impl.network.c r21 = (com.larus.dora.impl.network.c) r20;
                if (r21 == null) goto L44;
                Integer r22 = r21.a();
                if (r22 == null) goto L44;
                if (r22.intValue() != r16) goto L44;
                boolean r23 = true;
            L45:
                if (r23 == false) goto L35;
            L48:
                com.larus.dora.impl.network.c r24 = (com.larus.dora.impl.network.c) r20;
                if (r24 == null) goto L50;
            L54:
                if (r24 == null) goto L56;
                r7 = r24.b();
            L56:
                if (r7 != null) goto L58;
            L61:
                if (r2 == true) goto L63;
                DoraDynamicViewModelV2.access$get_avatarUrlFlow$p(r3).setValue(r7);
                goto L63
            L58:
                if (r7.length() == 0) goto L61;
                r2 = false;
            L44:
                r23 = false;
                goto L45
            L47:
                r20 = null;
            L50:
                List<com.larus.dora.impl.network.c> r25 = r4.a();
                if (r25 == null) goto L53;
                r24 = (com.larus.dora.impl.network.c) CollectionsKt.firstOrNull(r25);
                goto L54
            L53:
                r24 = null;
            L30:
                r16 = 1;
                goto L31
            L23:
                r13 = null;
                goto L24
            L20:
                r10 = null;
                goto L21
            L16:
                r8 = null;
            L63:
                Throwable r110 = Result.exceptionOrNull-impl(r12);
                if (r110 == null) goto L67;
                g49.d.c("DoraDynamicViewModelV2", "userLaunch failure", r110);
            L67:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r11);
                DoraNetworkApi r111 = DoraNetworkApi.a;
                this.label = 1;
                r12 = r111.M(this);
                if (r12 != r0) goto L11;
                return r0;
            }
        }

        public C03351(String r1, String r2, DoraDynamicViewModelV2 r3, Continuation<? super C03351> r4) {
            this.$productId = r1;
            this.$wdid = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C03351 r0 = new C03351(this.$productId, this.$wdid, this.this$0, r6);
            r0.L$0 = r5;
            return r0;
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
            Object r12 = ((Result) r11).unbox-impl();
        L11:
            DoraDynamicViewModelV2 r2 = this.this$0;
            if (Result.isSuccess-impl(r12) == false) goto L14;
            w r3 = (w) r12;
            g49.d.d("DoraDynamicViewModelV2", "fetchOnboardingStatus success: " + r3);
            boolean r4 = com.larus.dora.impl.onboarding.d.a;
            r3.b();
            com.larus.dora.impl.onboarding.d.c = r3.a();
            DoraDynamicViewModelV2.access$get_onboardingStatusFlow$p(r2).setValue(r3);
        L14:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L18;
            g49.d.c("DoraDynamicViewModelV2", "fetchOnboardingStatus failure", r13);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r14, null, null, new C00781(this.this$0, null), 3, null);
            BuildersKt.launch$default(r14, null, null, new AnonymousClass2(this.this$0, null), 3, null);
            DoraNetworkApi r15 = DoraNetworkApi.a;
            String r5 = this.$productId;
            String r6 = this.$wdid;
            this.label = 1;
            r12 = r15.g(r5, r6, this);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    public interface g {

        public static final class a implements g {
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

        public static final class b implements g {
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

        public static final class c implements g {
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

        public static final class d implements g {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }
    }

    public /* synthetic */ class h {
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$handleConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$handleConnectRequest$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {380, 392, 397, 399}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03361(DoraDynamicViewModelV2 r1, String r2, Continuation<? super C03361> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03361(this.this$0, this.$mac, r4);
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
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L38
        L40:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L38
        L26:
            DoraDevice r11 = (DoraDevice) r10;     // Catch: Exception -> L38
            if (r11 != null) goto L29;
            s r12 = s.a;     // Catch: Exception -> L38
            Application r2 = AppHost.a.getApplication();     // Catch: Exception -> L38
            r12.getClass();     // Catch: Exception -> L38
            s.b(r2, 2131903672, false);     // Catch: Exception -> L38
            this.this$0.get_connectionState().setValue(new e59.b.c(this.$mac));     // Catch: Exception -> L38
            goto L40
        L29:
            if (o59.a.p(r11) == false) goto L33;
            DoraDynamicViewModelV2 r3 = this.this$0;     // Catch: Exception -> L38
            this.label = 3;     // Catch: Exception -> L38
            if (DoraDynamicViewModelV2.access$handleGConnectRequest(r3, r11, this) != r0) goto L40;
            return r0;
        L33:
            DoraDynamicViewModelV2 r4 = this.this$0;     // Catch: Exception -> L38
            this.label = 4;     // Catch: Exception -> L38
            if (DoraDynamicViewModelV2.access$handleNotGConnectRequest(r4, r11, this) != r0) goto L40;
            return r0;
        L14:
            ResultKt.throwOnFailure(r10);
        L19:
            if (((Boolean) r10).booleanValue() == true) goto L22;
            s r13 = s.a;
            Application r5 = AppHost.a.getApplication();
            r13.getClass();
            s.b(r5, 2131903672, false);
            this.this$0.get_connectionState().setValue(new e59.b.c(this.$mac));
            return Unit.INSTANCE;
        L22:
            this.this$0.get_connectionState().setValue(new e59.b.C0125b(this.$mac));
            CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Exception -> L38
            DoraDynamicViewModelV2$handleConnectRequest$1$device$1 r6 = new DoraDynamicViewModelV2$handleConnectRequest$1$device$1(this.$mac, null);     // Catch: Exception -> L38
            this.label = 2;     // Catch: Exception -> L38
            r10 = BuildersKt.withContext(r14, r6, this);     // Catch: Exception -> L38
            if (r10 != r0) goto L26;
            return r0;
        L15:
            ResultKt.throwOnFailure(r10);
            DoraDynamicViewModelV2 r15 = this.this$0;
            String r7 = this.$mac;
            this.label = 1;
            r10 = r15.isBluetoothConnectedForReconnect(r7, this);
            if (r10 != r0) goto L19;
            return r0;
        L38:
            s r16 = s.a;
            Application r8 = AppHost.a.getApplication();
            r16.getClass();
            s.b(r8, 2131903672, false);
            this.this$0.get_connectionState().setValue(new e59.b.c(this.$mac));
            goto L40
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$handleGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2", f = "DoraDynamicViewModelV2.kt", i = {0, 1, 2}, l = {444, 477, 484}, m = "handleGConnectRequest", n = {"device", "device", "device"}, s = {"L$0", "L$0", "L$0"})
    public static final class C03371 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03371(DoraDynamicViewModelV2 r1, Continuation<? super C03371> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraDynamicViewModelV2.access$handleGConnectRequest(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$handleGConnectRequest$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$handleGConnectRequest$2", f = "DoraDynamicViewModelV2.kt", i = {}, l = {485, 498, 507}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03382(DoraDynamicViewModelV2 r1, DoraDevice r2, Continuation<? super C03382> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03382(this.this$0, this.$device, r4);
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
            DoraDynamicViewModelV2 r14 = this.this$0;
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
            MutableSharedFlow<d> r15 = this.this$0.get_deviceIntentSharedFlow();
            d.a r3 = new d.a(this.$device);
            this.label = 3;
            if (r15.emit(r3, this) != r0) goto L33;
            return r0;
        L12:
            ResultKt.throwOnFailure(r12);
            DoraDynamicViewModelV2 r16 = this.this$0;
            String r5 = this.$device.mac;
            this.label = 1;
            r12 = DoraDynamicViewModelV2.scanBleInfo$default(r16, r5, 0, this, 2, null);
            if (r12 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$handleNotGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2", f = "DoraDynamicViewModelV2.kt", i = {0}, l = {556}, m = "handleNotGConnectRequest", n = {"device"}, s = {"L$0"})
    public static final class C03391 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03391(DoraDynamicViewModelV2 r1, Continuation<? super C03391> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraDynamicViewModelV2.access$handleNotGConnectRequest(this.this$0, null, this);
        }
    }

    public static final class i implements com.larus.dora.impl.dynamic.loader.d.b {
        public final /* synthetic */ z49.b a;
        public final /* synthetic */ DoraDynamicViewModelV2 b;
        public final /* synthetic */ boolean c;

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void a() {
            FLogger.a.i("DoraDynamicViewModelV2", "fetchData card list onInvalid");
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void b(z r6) {
            Intrinsics.checkNotNullParameter(r6, "pageNode");
            m r7 = a0.b(r6);     // Catch: Throwable -> L28
            if (o59.a.o(this.a.f()) == false) goto L22;
            int r1 = 0;
            n r0 = (n) CollectionsKt.getOrNull(r7.b, 0);     // Catch: Throwable -> L28
            if (r0 == null) goto L12;
            DoraDynamicViewModelV2 r3 = this.b;     // Catch: Throwable -> L28
            c59.e0 r2 = (c59.e0) CollectionsKt.getOrNull(r0.b, 1);     // Catch: Throwable -> L28
            if (r2 == null) goto L12;
            List<c59.i> r4 = r2.b;     // Catch: Throwable -> L28
            if (r4 == null) goto L12;
            ((ArrayList) r4).add(DoraDynamicViewModelV2.access$createFeedbackCard(r3));     // Catch: Throwable -> L28
        L12:
            n r5 = (n) CollectionsKt.getOrNull(r7.b, 1);     // Catch: Throwable -> L28
            if (r5 == null) goto L22;
            DoraDynamicViewModelV2 r8 = this.b;     // Catch: Throwable -> L28
            c59.e0 r9 = (c59.e0) CollectionsKt.getOrNull(r5.b, 1);     // Catch: Throwable -> L28
            if (r9 == null) goto L22;
            List<c59.i> r10 = r9.b;     // Catch: Throwable -> L28
            if (r10 == null) goto L22;
            if ((!((ArrayList) r10).isEmpty()) == false) goto L21;
            r1 = ((ArrayList) r10).size() - 1;     // Catch: Throwable -> L28
        L21:
            ListProtector.add(r10, r1, DoraDynamicViewModelV2.access$createFeedbackCard(r8));     // Catch: Throwable -> L28
        L22:
            DoraDynamicViewModelV2.access$get_pageInfoData$p(this.b).postValue(r7);     // Catch: Throwable -> L28
            DoraDynamicViewModelV2.access$updateCardContext(this.b, this.a);     // Catch: Throwable -> L28
            DoraDynamicViewModelV2 r11 = this.b;     // Catch: Throwable -> L28
            if (this.c == false) goto L25;
            c r12 = new c.a(this.a.c());     // Catch: Throwable -> L28
        L26:
            r11.updateConnectState(r12);     // Catch: Throwable -> L28
            return;
        L25:
            r12 = new c.C0077c(this.a.c());     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            FLogger.a.e("DoraDynamicViewModelV2", "fetchData onSuccess, error is " + th.getMessage());
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void onFail(String r4) {
            FLogger.a.e("DoraDynamicViewModelV2", "fetchData onFail, msg is " + r4);
        }

        public i(z49.b r1, DoraDynamicViewModelV2 r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$isBluetoothConnectedForReconnect$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$isBluetoothConnectedForReconnect$2", f = "DoraDynamicViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03402 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $mac;
        private /* synthetic */ Object L$0;
        int label;

        public C03402(String r1, Continuation<? super C03402> r2) {
            this.$mac = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C03402 r0 = new C03402(this.$mac, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L38;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            String r9 = this.$mac;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L30
            BluetoothAdapter r3 = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L30
            if (r3 == null) goto L8;
            BluetoothDevice r4 = r3.getRemoteDevice(r9);     // Catch: Throwable -> L30
            if (r4 == null) goto L12;
            Iterator r5 = DoraAdapterExtKt.k(kj4.a.g()).iterator();     // Catch: Throwable -> L30
        L15:
            if (r5.hasNext() == false) goto L19;
            Object r6 = r5.next();     // Catch: Throwable -> L30
            if (Intrinsics.areEqual(((DoraDevice) r6).mac, r9) == false) goto L15;
        L20:
            boolean r10 = com.larus.dora.impl.core.j.b(r4);     // Catch: Throwable -> L30
            StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L30
            r11.append("isBluetoothConnectedForReconnect: device=");     // Catch: Throwable -> L30
            r11.append(o59.a.h((DoraDevice) r6));     // Catch: Throwable -> L30
            r11.append(", isConnected=");     // Catch: Throwable -> L30
            boolean r12 = true;
            if (r10 == false) goto L23;
            boolean r13 = true;
        L24:
            r11.append(r13);     // Catch: Throwable -> L30
            g49.d.d("DoraDynamicViewModelV2", r11.toString());     // Catch: Throwable -> L30
            if (r10 == true) goto L28;
            r12 = false;
        L28:
            Object r14 = Result.constructor-impl(Boxing.boxBoolean(r12));     // Catch: Throwable -> L30
        L32:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L43;
            g49.d.c("DoraDynamicViewModelV2", "isBluetoothConnectedForReconnect error", r15);
            return Boxing.boxBoolean(false);
        L43:
            return r14;
        L23:
            r13 = false;
            goto L24
        L19:
            r6 = null;
            goto L20
        L12:
            return Boxing.boxBoolean(false);
        L8:
            return Boxing.boxBoolean(false);
        L30:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L32
        L38:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class j extends ScanCallback {
        public final /* synthetic */ CompletableDeferred<Unit> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> c;

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.d("DoraDynamicViewModelV2", "connect request, scan failed, err: " + r3);
            this.a.complete(Unit.INSTANCE);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r2, ScanResult r3) {
            DoraDevice r4 = kj4.a.g().convertScanResultToDoraDevice(r3);
            g49.d.d("DoraDynamicViewModelV2", "connect request, new scan result: " + r4);
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

        public j(CompletableDeferred<Unit> r1, String r2, Ref.ObjectRef<DoraDevice> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class k implements ScreenStateManager.b {
        public final /* synthetic */ DoraDynamicViewModelV2 a;

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

        public k(DoraDynamicViewModelV2 r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$loadDeviceFeature$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$loadDeviceFeature$1", f = "DoraDynamicViewModelV2.kt", i = {0, 0}, l = {371}, m = "invokeSuspend", n = {"proactiveSettings", "i"}, s = {"L$0", "I$0"})
    public static final class C03411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03411(DoraDynamicViewModelV2 r1, Continuation<? super C03411> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03411(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0089 -> B:24:0x008c). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r3 = this.I$0;
            DoraPushSummaryConfig r4 = (DoraPushSummaryConfig) this.L$0;
            ResultKt.throwOnFailure(r9);
            C03411 r10 = this;
        L24:
            r3 = r3 + 1;
        L10:
            if (r3 >= 3) goto L26;
            sk4.e r5 = kj4.a.g().requestProtocolInfo();
            g49.d.d("DoraDynamicViewModelV2", "loadDeviceFeature: tryCount=" + r3 + ", " + r5);
            if (r5 != null) goto L14;
            r10.L$0 = r4;
            r10.I$0 = r3;
            r10.label = 1;
            if (DelayKt.delay(1000, r10) != r0) goto L24;
            return r0;
        L14:
            if (r4.getNotificationSummary() == true) goto L18;
            if (r4.getProactiveMessage() == true) goto L18;
        L20:
            c59.k.a = r2;
            DoraDynamicViewModelV2.access$get_showProactiveEntryLiveData$p(r10.this$0).postValue(Boxing.boxBoolean(r2));
        L18:
            if (r5.b("startVUI") == false) goto L20;
            r2 = true;
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            DoraSetting.a.getClass();
            r4 = DoraSetting.e();
            r3 = 0;
            r10 = this;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$loadHeadphoneMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$loadHeadphoneMode$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03421(DoraDynamicViewModelV2 r1, Continuation<? super C03421> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03421(this.this$0, r3);
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
            z0 r4 = DoraDynamicViewModelV2.access$get_headphoneModeStateFlow$p(this.this$0);
            t69.b r0 = t69.b.a;
            boolean r1 = true;
            if (t69.b.c == 1) goto L8;
            r1 = false;
        L8:
            r4.setValue(Boxing.boxBoolean(r1));
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$loadLabSettingConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$loadLabSettingConfig$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {1028}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C03431(Continuation<? super C03431> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C03431(r2);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$onlyConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2", f = "DoraDynamicViewModelV2.kt", i = {0, 1, 2}, l = {652, 659, 666}, m = "onlyConnect", n = {"device", "device", "device"}, s = {"L$0", "L$0", "L$0"})
    public static final class C03441 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03441(DoraDynamicViewModelV2 r1, Continuation<? super C03441> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onlyConnect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$onlyLocalUnbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$onlyLocalUnbind$1", f = "DoraDynamicViewModelV2.kt", i = {1}, l = {980, 984, 988}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class C03451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ z49.b $simpleDevice;
        Object L$0;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03451(DoraDynamicViewModelV2 r1, z49.b r2, Continuation<? super C03451> r3) {
            this.this$0 = r1;
            this.$simpleDevice = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03451(this.this$0, this.$simpleDevice, r4);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
        L37:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            DoraDevice r2 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r10);
        L33:
            MutableSharedFlow r11 = DoraDynamicViewModelV2.access$get_unbindStateFlow$p(this.this$0);
            Pair r3 = new Pair(IntentState.ACTION_UNBIND_SUCCESS, r2);
            this.L$0 = null;
            this.label = 3;
            if (r11.emit(r3, this) != r0) goto L37;
            return r0;
        L11:
            ResultKt.throwOnFailure(r10);
        L28:
            g49.d.d("DoraDynamicViewModelV2", "onlyLocalUnbind device is null, nothing todo, return");
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r10);
            List r12 = DoraAdapterExtKt.k(kj4.a.g());
            z49.b r4 = this.$simpleDevice;
            Iterator r13 = r12.iterator();
        L14:
            if (r13.hasNext() == false) goto L22;
            Object r6 = r13.next();
            String r7 = ((DoraDevice) r6).mac;
            if (r4 == null) goto L18;
            String r8 = r4.c();
        L20:
            if (Intrinsics.areEqual(r7, r8) == false) goto L14;
        L23:
            r2 = (DoraDevice) r6;
            if (r2 != null) goto L30;
            MutableSharedFlow r14 = DoraDynamicViewModelV2.access$get_unbindStateFlow$p(this.this$0);
            Pair r5 = new Pair(IntentState.ACTION_NO_DEVICE_CONNECTED, null);
            this.label = 1;
            if (r14.emit(r5, this) != r0) goto L28;
            return r0;
        L30:
            kj4.a r15 = kj4.a.g();
            this.L$0 = r2;
            this.label = 2;
            if (DoraAdapterExtKt.f(r15, r2) != r0) goto L33;
            return r0;
        L18:
            r8 = null;
            goto L20
        L22:
            r6 = null;
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$replaceBind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$replaceBind$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {919, 923}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03461(DoraDevice r1, DoraDynamicViewModelV2 r2, Continuation<? super C03461> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03461(this.$device, this.this$0, r4);
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
            DoraDynamicViewModelV2 r3 = this.this$0;
            DoraDevice r4 = this.$device;
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L29;
            g49.d.c("DoraDynamicViewModelV2", "replaceBind: failure exception", r13);
            r3.updateUi(new g.c(r4));
            s r14 = s.a;
            Application r5 = AppHost.a.getApplication();
            r14.getClass();
            s.b(r5, 2131908080, false);
        L29:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
            r12 = ((Result) r11).unbox-impl();
        L13:
            DoraDynamicViewModelV2 r6 = this.this$0;
            DoraDevice r7 = this.$device;
            if (Result.isSuccess-impl(r12) == false) goto L25;
            int r8 = ((Number) r12).intValue();
            g49.d.d("DoraDynamicViewModelV2", "replaceBind: replaceBindCode=" + r8);
            Object r9 = DoraDynamicViewModelV2.access$get_deviceStateFlow$p(r6).getValue();
            if ((r9 instanceof f.a) == false) goto L18;
            f.a r10 = (f.a) r9;
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
            r6.updateUi(new g.c(r7));
            s r16 = s.a;
            Application r17 = AppHost.a.getApplication();
            r16.getClass();
            s.b(r17, 2131904024, false);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$scanBleInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2", f = "DoraDynamicViewModelV2.kt", i = {0, 0, 0}, l = {548}, m = "scanBleInfo", n = {"newDevice", "scanCallback", "startScanTs"}, s = {"L$0", "L$1", "J$0"})
    public static final class C03471 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03471(DoraDynamicViewModelV2 r1, Continuation<? super C03471> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return DoraDynamicViewModelV2.access$scanBleInfo(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$scanBleInfo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$scanBleInfo$2", f = "DoraDynamicViewModelV2.kt", i = {}, l = {548}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03482 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $done;
        int label;

        public C03482(CompletableDeferred<Unit> r1, Continuation<? super C03482> r2) {
            this.$done = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03482(this.$done, r3);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$unbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$unbind$1", f = "DoraDynamicViewModelV2.kt", i = {1}, l = {997, 1001, 1003, 1012, 1016, 1020}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class C03491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ z49.b $simpleDevice;
        Object L$0;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$unbind$1$a */
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

        public C03491(DoraDynamicViewModelV2 r1, z49.b r2, Continuation<? super C03491> r3) {
            this.this$0 = r1;
            this.$simpleDevice = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03491(this.this$0, this.$simpleDevice, r4);
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
            MutableSharedFlow r11 = DoraDynamicViewModelV2.access$get_unbindStateFlow$p(this.this$0);
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
            MutableSharedFlow r12 = DoraDynamicViewModelV2.access$get_unbindStateFlow$p(this.this$0);
            Pair r3 = new Pair(IntentState.ACTION_SPP_DISCONNECT_FAILED, r1);
            this.L$0 = null;
            this.label = 6;
            if (r12.emit(r3, this) != r0) goto L53;
            return r0;
        L42:
            throw new NoWhenBranchMatchedException();
        L43:
            MutableSharedFlow r13 = DoraDynamicViewModelV2.access$get_unbindStateFlow$p(this.this$0);
            Pair r4 = new Pair(IntentState.ACTION_UNBIND_SUCCESS, r1);
            this.L$0 = null;
            this.label = 5;
            if (r13.emit(r4, this) != r0) goto L53;
            return r0;
        L46:
            MutableSharedFlow r14 = DoraDynamicViewModelV2.access$get_unbindStateFlow$p(this.this$0);
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
            MutableSharedFlow r18 = DoraDynamicViewModelV2.access$get_unbindStateFlow$p(this.this$0);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$updateConnectState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$updateConnectState$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e59.b $connectionState;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03501(DoraDynamicViewModelV2 r1, e59.b r2, Continuation<? super C03501> r3) {
            this.this$0 = r1;
            this.$connectionState = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03501(this.this$0, this.$connectionState, r4);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$updateUi$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$updateUi$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $uiState;
        int label;
        final /* synthetic */ DoraDynamicViewModelV2 this$0;

        public C03511(g r1, DoraDynamicViewModelV2 r2, Continuation<? super C03511> r3) {
            this.$uiState = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03511(this.$uiState, this.this$0, r4);
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
            g r5 = this.$uiState;
            String r1 = null;
            if ((r5 instanceof g.b) == false) goto L11;
            MutableLiveData<e59.b> r6 = this.this$0.get_connectionState();
            DoraDevice r2 = ((g.b) this.$uiState).a;
            if (r2 == null) goto L9;
            r1 = r2.mac;
        L9:
            r6.setValue(new e59.b.C0125b(r1));
        L26:
            return Unit.INSTANCE;
        L11:
            if ((r5 instanceof g.a) == false) goto L17;
            MutableLiveData<e59.b> r7 = this.this$0.get_connectionState();
            DoraDevice r3 = ((g.a) this.$uiState).a;
            if (r3 == null) goto L15;
            r1 = r3.mac;
        L15:
            r7.setValue(new e59.b.a(r1));
            goto L26
        L17:
            if ((r5 instanceof g.c) == false) goto L23;
            MutableLiveData<e59.b> r8 = this.this$0.get_connectionState();
            DoraDevice r9 = ((g.c) this.$uiState).a;
            if (r9 == null) goto L21;
            r1 = r9.mac;
        L21:
            r8.setValue(new e59.b.c(r1));
            goto L26
        L23:
            if (Intrinsics.areEqual(r5, g.d.a) == false) goto L28;
            this.this$0.get_connectionState().setValue(e59.b.d.a);
            goto L26
        L28:
            throw new NoWhenBranchMatchedException();
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new b();
    }

    public Object isBluetoothConnectedForReconnect(String r1, Continuation<? super Boolean> r2) {
        return isBluetoothConnectedForReconnect$suspendImpl(this, r1, r2);
    }

    private final c59.i createFeedbackCard() {
        return new c59.i(DslTemplateType.GENERAL_GROUP, MapsKt.mapOf(TuplesKt.to("items", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("title", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "string_type"), TuplesKt.to("value", "dora_g_feedback_title_cn")})), TuplesKt.to("action", MapsKt.mapOf(new Pair[]{TuplesKt.to("action_url", "sslocal://flow/dora_g_feedback"), TuplesKt.to("action_type", "internal_jump")})), TuplesKt.to("right_icon", "arrow")})))));
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
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C03341(this, null), 2, null);
    }

    public final void fetchNewcomerGuideConfig() {
        z0<List<NewcomerGuideItem>> r0 = this._newcomerGuideConfigFlow;
        e10 r1 = e10.a;
        int r2 = l0.a;
        r0.setValue((List) l0.a(CollectionsKt.emptyList(), new yh()));
    }

    public DoraDynamicViewModelV2() {
        MutableSharedFlow<com.larus.dora.impl.network.a> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._sodaBannerSharedFlow = r3;
        this.sodaBannerSharedFlow = r3;
        MutableSharedFlow<e> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceBindStatusFlow = r4;
        this.deviceBindStatusFlow = r4;
        MutableSharedFlow<d> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceIntentSharedFlow = r5;
        this.deviceIntentSharedFlow = r5;
        MutableLiveData<m> r6 = new MutableLiveData();
        this._pageInfoData = r6;
        this.pageInfoData = r6;
        MutableLiveData<d59.b> r7 = new MutableLiveData();
        this._cardContextData = r7;
        this.cardContextData = r7;
        StateFlowImpl r8 = j1.a(f.d.a);
        this._deviceStateFlow = r8;
        this.deviceStateFlow = r8;
        StateFlowImpl r9 = j1.a(new a(0, null));
        this._deviceBatteryStateFlow = r9;
        this.deviceBatteryStateFlow = r9;
        StateFlowImpl r10 = j1.a(Boolean.FALSE);
        this._headphoneModeStateFlow = r10;
        this.headphoneModeStateFlow = r10;
        MutableLiveData<e59.d> r11 = new MutableLiveData();
        this._dialogEvent = r11;
        this.dialogEvent = r11;
        MutableLiveData<e59.f> r12 = new MutableLiveData();
        this._viewHolderEvent = r12;
        this.viewHolderEvent = r12;
        MutableLiveData<Boolean> r13 = new MutableLiveData();
        this._showProactiveEntryLiveData = r13;
        this.showProactiveEntryLiveData = r13;
        MutableLiveData<e59.b> r14 = new MutableLiveData(e59.b.d.a);
        this._connectionState = r14;
        this.connectionState = r14;
        StateFlowImpl r15 = j1.a(null);
        this._onboardingStatusFlow = r15;
        this.onboardingStatusFlow = kotlinx.coroutines.flow.e.b(r15);
        StateFlowImpl r16 = j1.a(CollectionsKt.emptyList());
        this._newcomerGuideConfigFlow = r16;
        this.newcomerGuideConfigFlow = kotlinx.coroutines.flow.e.b(r16);
        StateFlowImpl r17 = j1.a(null);
        this._avatarUrlFlow = r17;
        this.avatarUrlFlow = kotlinx.coroutines.flow.e.b(r17);
        MutableSharedFlow<Pair<IntentState, DoraDevice>> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._unbindStateFlow = r0;
        this.unbindStateFlow = r0;
        this.dataLoader = new com.larus.dora.impl.dynamic.loader.d();
        this.isScreenOn = true;
        k r1 = new k(this);
        this.screenListener = r1;
        mj4.h r2 = new DoraDynamicViewModelV2$doraBudsCallback$1(this);
        this.doraBudsCallback = r2;
        IDoraLinkCallback r18 = new DoraDynamicViewModelV2$doraLinkCallback$1(this);
        this.doraLinkCallback = r18;
        mj4.h r20 = new DoraDynamicViewModelV2$doraHeadphoneModeCallback$1(this);
        this.doraHeadphoneModeCallback = r20;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        DoraDevice r21 = DoraAdapterExtKt.h(kj4.a.g());
        if (r21 == null) goto L5;
        checkBindState(r21);
    L5:
        loadLabSettingConfig();
        loadHeadphoneMode();
        kj4.a.g().registerDoraLinkCallback(r18);
        kj4.a.g().k(r2);
        kj4.a.g().k(r20);
        ScreenStateManager r22 = ScreenStateManager.a;
        ScreenStateManager.a(r1);
    }

    private final void loadHeadphoneMode() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03421(this, null), 2, null);
    }

    private final void loadLabSettingConfig() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03431(null), 2, null);
    }

    public final void loadDeviceFeature() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03411(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        g49.d.d("DoraDynamicViewModelV2", this + " onCleared");
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
        kj4.a.g().E(this.doraBudsCallback);
        kj4.a.g().E(this.doraHeadphoneModeCallback);
        ScreenStateManager r0 = ScreenStateManager.a;
        ScreenStateManager.a(this.screenListener);
    }

    public final i1<String> getAvatarUrlFlow() {
        return this.avatarUrlFlow;
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

    public final i1<a> getDeviceBatteryStateFlow() {
        return this.deviceBatteryStateFlow;
    }

    public final d1<e> getDeviceBindStatusFlow() {
        return this.deviceBindStatusFlow;
    }

    public final d1<d> getDeviceIntentSharedFlow() {
        return this.deviceIntentSharedFlow;
    }

    public final i1<f> getDeviceStateFlow() {
        return this.deviceStateFlow;
    }

    public final LiveData<e59.d> getDialogEvent() {
        return this.dialogEvent;
    }

    public final i1<Boolean> getHeadphoneModeStateFlow() {
        return this.headphoneModeStateFlow;
    }

    public final i1<List<NewcomerGuideItem>> getNewcomerGuideConfigFlow() {
        return this.newcomerGuideConfigFlow;
    }

    public final i1<w> getOnboardingStatusFlow() {
        return this.onboardingStatusFlow;
    }

    public final LiveData<m> getPageInfoData() {
        return this.pageInfoData;
    }

    public final LiveData<Boolean> getShowProactiveEntryLiveData() {
        return this.showProactiveEntryLiveData;
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

    public final MutableSharedFlow<d> get_deviceIntentSharedFlow() {
        return this._deviceIntentSharedFlow;
    }

    public final boolean isScreenOn() {
        return this.isScreenOn;
    }

    public static final /* synthetic */ c59.i access$createFeedbackCard(DoraDynamicViewModelV2 r0) {
        return r0.createFeedbackCard();
    }

    public static final /* synthetic */ long access$getDeviceStateSeq$p(DoraDynamicViewModelV2 r2) {
        return r2.deviceStateSeq;
    }

    public static final /* synthetic */ z0 access$get_avatarUrlFlow$p(DoraDynamicViewModelV2 r0) {
        return r0._avatarUrlFlow;
    }

    public static final /* synthetic */ z0 access$get_deviceBatteryStateFlow$p(DoraDynamicViewModelV2 r0) {
        return r0._deviceBatteryStateFlow;
    }

    public static final /* synthetic */ z0 access$get_deviceStateFlow$p(DoraDynamicViewModelV2 r0) {
        return r0._deviceStateFlow;
    }

    public static final /* synthetic */ z0 access$get_headphoneModeStateFlow$p(DoraDynamicViewModelV2 r0) {
        return r0._headphoneModeStateFlow;
    }

    public static final /* synthetic */ z0 access$get_onboardingStatusFlow$p(DoraDynamicViewModelV2 r0) {
        return r0._onboardingStatusFlow;
    }

    public static final /* synthetic */ MutableLiveData access$get_pageInfoData$p(DoraDynamicViewModelV2 r0) {
        return r0._pageInfoData;
    }

    public static final /* synthetic */ MutableLiveData access$get_showProactiveEntryLiveData$p(DoraDynamicViewModelV2 r0) {
        return r0._showProactiveEntryLiveData;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_sodaBannerSharedFlow$p(DoraDynamicViewModelV2 r0) {
        return r0._sodaBannerSharedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_unbindStateFlow$p(DoraDynamicViewModelV2 r0) {
        return r0._unbindStateFlow;
    }

    private final void updateCardContext(z49.b r6) {
        if ((this._deviceStateFlow.getValue() instanceof f.a) == false) goto L11;
        Object r0 = this._deviceStateFlow.getValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2.DeviceStateV2.Connected");
        DoraDevice r1 = ((f.a) r0).b;
        FLogger.a.e("DoraDynamicViewModelV2", "connectDevice: " + r1);
        if (r6 == null) goto L7;
        String r2 = r6.c();
    L9:
        if (Intrinsics.areEqual(r2, r1.mac) == false) goto L11;
        r6 = z49.b.a(r6, r1);
        goto L11
    L7:
        r2 = null;
    L11:
        this._cardContextData.postValue(new d59.b(r6, DoraAdapterExtKt.k(kj4.a.g()), d0.a(), ""));
    }

    public void checkBindState(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03291(this, r8, null), 2, null);
    }

    public final void checkSodaBanner(List<com.larus.dora.impl.network.a> r11) {
        List<com.larus.dora.impl.network.a> r0 = r11;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03311(this, null), 3, null);
        return;
    L13:
        Iterator<com.larus.dora.impl.network.a> r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L21;
        com.larus.dora.impl.network.a r2 = r12.next();
        if (r2 == null) goto L15;
        if (r2.getType() != 1) goto L15;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(r2, this, null), 3, null);
        goto L15
    L21:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public final void connectAsync(DoraDevice r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C03331(r7, this, null), 2, null);
    }

    public void handleConnectRequest(String r10) {
        Job r0 = this.connectingJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.connectingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03361(this, r10, null), 3, null);
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
        if ((r5 instanceof e59.e.b) == false) goto L16;
        MutableLiveData<e59.b> r7 = this._connectionState;
        r7.postValue(r7.getValue());
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    public final void onlyLocalUnbind(z49.b r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C03451(this, r7, null), 3, null);
    }

    public final void replaceBind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C03461(r8, this, null), 2, null);
    }

    public final void setConnectingJob(Job r1) {
        this.connectingJob = r1;
    }

    public final void setScreenOn(boolean r1) {
        this.isScreenOn = r1;
    }

    public final void unbind(z49.b r7) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C03491(this, r7, null), 2, null);
    }

    public final void updateConnectState(c r9) {
        Intrinsics.checkNotNullParameter(r9, "status");
        boolean r0 = r9 instanceof c.a;
        FLogger.a.e("DoraDynamicViewModelV2", "updateConnectState, connected is " + r0);
        if (r0 == false) goto L6;
        e59.b r1 = new e59.b.a(((c.a) r9).a);
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03501(this, r1, null), 3, null);
        return;
    L6:
        if ((r9 instanceof c.b) == false) goto L9;
        ((c.b) r9).getClass();
        r1 = new e59.b.C0125b(null);
        goto L11
    L9:
        if ((r9 instanceof c.C0077c) == false) goto L14;
        r1 = new e59.b.c(((c.C0077c) r9).a);
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void updateNewcomerGuideConfig(List<NewcomerGuideItem> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this._newcomerGuideConfigFlow.setValue(r2);
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

    public final void updateUi(g r8) {
        Intrinsics.checkNotNullParameter(r8, "uiState");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03511(r8, this, null), 3, null);
    }

    public static final /* synthetic */ void access$setDeviceStateSeq$p(DoraDynamicViewModelV2 r0, long r1) {
        r0.deviceStateSeq = r1;
    }

    public static final /* synthetic */ void access$updateCardContext(DoraDynamicViewModelV2 r0, z49.b r1) {
        r0.updateCardContext(r1);
    }

    private final Object handleGConnectRequest(DoraDevice r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C03371) == false) goto L7;
        C03371 r0 = (C03371) r11;
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
        updateUi(new g.c(r10));     // Catch: Throwable -> L47
        return Unit.INSTANCE;
    L33:
        if (r15 != OnlyBindResult.SERVER_BIND_FAILED) goto L38;
        s r17 = s.a;     // Catch: Throwable -> L47
        AppHost.Companion r5 = AppHost.a;     // Catch: Throwable -> L47
        Application r6 = r5.getApplication();     // Catch: Throwable -> L47
        String r7 = r5.getApplication().getString(2131903938, new Object[]{o59.a.g(r10)});     // Catch: Throwable -> L47
        r17.getClass();     // Catch: Throwable -> L47
        s.c(r6, r7);     // Catch: Throwable -> L47
        updateUi(new g.c(r10));     // Catch: Throwable -> L47
        return Unit.INSTANCE;
    L38:
        if (r15 != OnlyBindResult.SUCCESS) goto L44;
        g49.d.d("DoraDynamicViewModelV2", "connect request, bind success, connect spp");     // Catch: Throwable -> L47
        b0 r18 = b0.a;     // Catch: Throwable -> L47
        String r8 = ILoginService.a.getAccountInfo().c;     // Catch: Throwable -> L47
        String r9 = r10.mac;     // Catch: Throwable -> L47
        r18.getClass();     // Catch: Throwable -> L47
        b0.C(r8, r9);     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 2;     // Catch: Throwable -> L47
        if (onlyConnect(r10, r0) != r2) goto L43;
        return r2;
    L44:
        g49.d.d("DoraDynamicViewModelV2", "cur device need unbind ");     // Catch: Throwable -> L47
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L47
        C03382 r20 = new C03382(this, r10, null);     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 3;     // Catch: Throwable -> L47
        if (BuildersKt.withContext(r110, r20, r0) != r2) goto L49;
        return r2;
    L24:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Throwable -> L47
        DoraDynamicViewModelV2$handleGConnectRequest$bindResult$1 r21 = new DoraDynamicViewModelV2$handleGConnectRequest$bindResult$1(r10, null);     // Catch: Throwable -> L47
        r0.L$0 = r10;     // Catch: Throwable -> L47
        r0.label = 1;     // Catch: Throwable -> L47
        r12 = BuildersKt.withContext(r111, r21, r0);     // Catch: Throwable -> L47
        if (r12 != r2) goto L28;
        return r2;
    L47:
        s r112 = s.a;
        Application r22 = AppHost.a.getApplication();
        r112.getClass();
        s.b(r22, 2131903672, false);
        this._connectionState.setValue(new e59.b.c(r10.mac));
    L7:
        r0 = new C03371(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object handleNotGConnectRequest(DoraDevice r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof C03391) == false) goto L7;
        C03391 r0 = (C03391) r6;
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
        r0 = new C03391(this, r6);
        goto L8
    }

    public final void checkLocalBindState(DoraDevice r7, long r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03301(r8, r7, null), 2, null);
    }

    public final Object connect(DoraDevice r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof C03321) == false) goto L7;
        C03321 r2 = (C03321) r14;
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
        updateUi(new g.a(r13));     // Catch: Throwable -> L52
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
        switch(h.b[r17.ordinal()]) {
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
        DoraDynamicViewModelV2$connect$state$1 r0 = new DoraDynamicViewModelV2$connect$state$1(r13, null);     // Catch: Throwable -> L52
        r2.L$0 = r13;     // Catch: Throwable -> L52
        r2.label = 3;     // Catch: Throwable -> L52
        r15 = BuildersKt.withContext(r18, r0, r2);     // Catch: Throwable -> L52
        if (r15 != r4) goto L42;
        return r4;
    L44:
        MutableSharedFlow<d> r110 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L52
        d.a r1 = new d.a(r13);     // Catch: Throwable -> L52
        r2.L$0 = r13;     // Catch: Throwable -> L52
        r2.label = 2;     // Catch: Throwable -> L52
        if (r110.emit(r1, r2) != r4) goto L54;
        return r4;
    L47:
        s r111 = s.a;     // Catch: Throwable -> L52
        Application r6 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r111.getClass();     // Catch: Throwable -> L52
        s.b(r6, 2131903672, false);     // Catch: Throwable -> L52
        updateUi(new g.c(r13));     // Catch: Throwable -> L52
        goto L54
    L48:
        s r112 = s.a;     // Catch: Throwable -> L52
        Application r7 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r112.getClass();     // Catch: Throwable -> L52
        s.b(r7, 2131904024, false);     // Catch: Throwable -> L52
        updateUi(new g.c(r13));     // Catch: Throwable -> L52
        goto L54
    L49:
        s r113 = s.a;     // Catch: Throwable -> L52
        Application r8 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r113.getClass();     // Catch: Throwable -> L52
        s.b(r8, 2131908080, false);     // Catch: Throwable -> L52
        updateUi(new g.c(r13));     // Catch: Throwable -> L52
        goto L54
    L51:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L52
    L24:
        ResultKt.throwOnFailure(r15);
        updateUi(new g.b(r13));
        StringBuilder r114 = new StringBuilder("start connect ");     // Catch: Throwable -> L52
        if (r13 == null) goto L28;
        String r9 = o59.a.h(r13);     // Catch: Throwable -> L52
    L29:
        r114.append(r9);     // Catch: Throwable -> L52
        g49.d.d("DoraDynamicViewModelV2", r114.toString());     // Catch: Throwable -> L52
        if (r13 != null) goto L32;
        s r115 = s.a;     // Catch: Throwable -> L52
        Application r10 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r115.getClass();     // Catch: Throwable -> L52
        s.b(r10, 2131903672, false);     // Catch: Throwable -> L52
        updateUi(new g.c(r13));     // Catch: Throwable -> L52
        goto L54
    L32:
        CoroutineDispatcher r116 = Dispatchers.getIO();     // Catch: Throwable -> L52
        DoraDynamicViewModelV2$connect$connectResult$1 r11 = new DoraDynamicViewModelV2$connect$connectResult$1(r13, null);     // Catch: Throwable -> L52
        r2.L$0 = r13;     // Catch: Throwable -> L52
        r2.label = 1;     // Catch: Throwable -> L52
        r15 = BuildersKt.withContext(r116, r11, r2);     // Catch: Throwable -> L52
        if (r15 != r4) goto L35;
        return r4;
    L28:
        r9 = null;
    L52:
        updateUi(new g.c(r13));
    L7:
        r2 = new C03321(this, r14);
        goto L8
    }

    public final void fetchOnboardingStatus(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "productId");
        Intrinsics.checkNotNullParameter(r9, "wdid");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03351(r8, r9, this, null), 2, null);
    }

    public final Object onlyConnect(DoraDevice r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof C03441) == false) goto L7;
        C03441 r2 = (C03441) r12;
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
        updateUi(new g.a(r11));     // Catch: Throwable -> L52
    L54:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r11 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L52
    L50:
        updateUi(new g.c(r11));     // Catch: Throwable -> L52
        goto L54
    L21:
        r11 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L52
    L35:
        OnlyConnectResult r14 = (OnlyConnectResult) r13;     // Catch: Throwable -> L52
        g49.d.d("DoraDynamicViewModelV2", "only connect: " + o59.a.h(r11) + " result = " + r14);     // Catch: Throwable -> L52
        int r15 = h.a[r14.ordinal()];     // Catch: Throwable -> L52
        if (r15 == 1) goto L47;
        if (r15 == 2) goto L47;
        if (r15 != 3) goto L46;
        CoroutineDispatcher r16 = Dispatchers.getIO();     // Catch: Throwable -> L52
        DoraDynamicViewModelV2$onlyConnect$state$1 r0 = new DoraDynamicViewModelV2$onlyConnect$state$1(r11, null);     // Catch: Throwable -> L52
        r2.L$0 = r11;     // Catch: Throwable -> L52
        r2.label = 3;     // Catch: Throwable -> L52
        r13 = BuildersKt.withContext(r16, r0, r2);     // Catch: Throwable -> L52
        if (r13 != r4) goto L43;
        return r4;
    L46:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L52
    L47:
        MutableSharedFlow<d> r17 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L52
        d.b r1 = new d.b(r11);     // Catch: Throwable -> L52
        r2.L$0 = r11;     // Catch: Throwable -> L52
        r2.label = 2;     // Catch: Throwable -> L52
        if (r17.emit(r1, r2) != r4) goto L50;
        return r4;
    L24:
        ResultKt.throwOnFailure(r13);
        updateUi(new g.b(r11));
        StringBuilder r18 = new StringBuilder("start only connect ");     // Catch: Throwable -> L52
        if (r11 == null) goto L28;
        String r6 = o59.a.h(r11);     // Catch: Throwable -> L52
    L29:
        r18.append(r6);     // Catch: Throwable -> L52
        g49.d.d("DoraDynamicViewModelV2", r18.toString());     // Catch: Throwable -> L52
        if (r11 != null) goto L32;
        s r110 = s.a;     // Catch: Throwable -> L52
        Application r7 = AppHost.a.getApplication();     // Catch: Throwable -> L52
        r110.getClass();     // Catch: Throwable -> L52
        s.b(r7, 2131903672, false);     // Catch: Throwable -> L52
        updateUi(new g.c(r11));     // Catch: Throwable -> L52
        goto L54
    L32:
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Throwable -> L52
        DoraDynamicViewModelV2$onlyConnect$connectResult$1 r8 = new DoraDynamicViewModelV2$onlyConnect$connectResult$1(r11, null);     // Catch: Throwable -> L52
        r2.L$0 = r11;     // Catch: Throwable -> L52
        r2.label = 1;     // Catch: Throwable -> L52
        r13 = BuildersKt.withContext(r111, r8, r2);     // Catch: Throwable -> L52
        if (r13 != r4) goto L35;
        return r4;
    L28:
        r6 = null;
    L52:
        updateUi(new g.c(r11));
    L7:
        r2 = new C03441(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object access$handleGConnectRequest(DoraDynamicViewModelV2 r0, DoraDevice r1, Continuation r2) {
        return r0.handleGConnectRequest(r1, r2);
    }

    public static final /* synthetic */ Object access$handleNotGConnectRequest(DoraDynamicViewModelV2 r0, DoraDevice r1, Continuation r2) {
        return r0.handleNotGConnectRequest(r1, r2);
    }

    public static /* synthetic */ Object isBluetoothConnectedForReconnect$suspendImpl(DoraDynamicViewModelV2 r2, String r3, Continuation<? super Boolean> r4) {
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        return Boxing.boxBoolean(false);
    L13:
        return BuildersKt.withContext(Dispatchers.getIO(), new C03402(r3, null), r4);
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    private final Object scanBleInfo(String r10, long r11, Continuation<? super DoraDevice> r13) {
        if ((r13 instanceof C03471) == false) goto L7;
        C03471 r0 = (C03471) r13;
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
        j r15 = (j) r0.L$1;
        Ref.ObjectRef r4 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        g49.d.d("DoraDynamicViewModelV2", "scan ble info cost: " + (System.currentTimeMillis() - r12));
        kj4.a.g().stopScan(r15);
        return r4.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        long r5 = System.currentTimeMillis();
        CompletableDeferred r6 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        j r8 = new j(r6, r10, r7);
        kj4.a.g().scan(CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"}), r8);
        C03482 r16 = new C03482(r6, null);
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
        r0 = new C03471(this, r13);
        goto L8
    }

    public static final /* synthetic */ Object access$scanBleInfo(DoraDynamicViewModelV2 r0, String r1, long r2, Continuation r4) {
        return r0.scanBleInfo(r1, r2, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkSodaBanner$default(DoraDynamicViewModelV2 r0, List r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.checkSodaBanner(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkSodaBanner");
    }

    public final synchronized void fetchData(z49.b r10, boolean r11, Integer r12, String r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "simpleDevice");     // Catch: Throwable -> L17
        g49.d.d("DoraDynamicViewModelV2", "fetchData, simpleDevice mac: " + r10.c() + ", isCurrent: " + r11 + ", vendorId: " + r12 + ", pageKey: " + r13);     // Catch: Throwable -> L17
        String r0 = String.valueOf(r10.f());     // Catch: Throwable -> L17
        String r1 = z49.a.a(r10).getSerialNumber();     // Catch: Throwable -> L17
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        fetchOnboardingStatus(r0, r1);     // Catch: Throwable -> L17
        com.larus.dora.impl.dynamic.loader.d r2 = this.dataLoader;     // Catch: Throwable -> L17
        CoroutineScope r3 = ViewModelKt.getViewModelScope(this);     // Catch: Throwable -> L17
        if (r12 != null) goto L11;
    L13:
        int r4 = n1.d(r10);     // Catch: Throwable -> L17
    L14:
        com.larus.dora.impl.dynamic.loader.d.b(r2, r3, r12, Integer.valueOf(r4), r10.d(), r13, new i(r10, this, r11));     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L11:
        if (r12.intValue() != 4096) goto L13;
        r4 = -1;
    L17:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void checkLocalBindState$default(DoraDynamicViewModelV2 r0, DoraDevice r1, long r2, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L6;
        r2 = 500;
    L6:
        r0.checkLocalBindState(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkLocalBindState");
    }

    public static /* synthetic */ Object scanBleInfo$default(DoraDynamicViewModelV2 r0, String r1, long r2, Continuation r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 2) == 0) goto L7;
        r2 = 10000;
    L7:
        return r0.scanBleInfo(r1, r2, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scanBleInfo");
    }
}
