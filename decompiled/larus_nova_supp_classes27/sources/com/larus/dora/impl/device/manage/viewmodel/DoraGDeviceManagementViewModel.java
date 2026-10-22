package com.larus.dora.impl.device.manage.viewmodel;

import a49.h;
import a49.i;
import a49.j;
import android.app.Application;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.avlink.api.IDoraGResourceService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyBindResult;
import com.larus.dora.impl.core.OnlyConnectResult;
import com.larus.dora.impl.device.manage.DeviceMode;
import com.larus.dora.impl.device.manage.DiaryDisplayMode;
import com.larus.dora.impl.device.manage.a1;
import com.larus.dora.impl.device.manage.b1;
import com.larus.dora.impl.device.manage.g;
import com.larus.dora.impl.device.manage.o0;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.device.manage.q0;
import com.larus.dora.impl.device.manage.s0;
import com.larus.dora.impl.device.manage.t0;
import com.larus.dora.impl.device.manage.u0;
import com.larus.dora.impl.device.manage.x0;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.v;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.util.r0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.j0;
import com.larus.utils.l0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&*\u0004=@CF\u0018\u0000 ¡\u00012\u00020\u0001:\b¡\u0001¢\u0001£\u0001¤\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00105\u001a\u000204H\u0002J\b\u00106\u001a\u000204H\u0002J\n\u00107\u001a\u0004\u0018\u000101H\u0002J\b\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u0002042\b\u0010;\u001a\u0004\u0018\u00010\u0017J\b\u0010H\u001a\u000204H\u0002J\u001a\u0010I\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u0017H\u0002J\b\u0010M\u001a\u000204H\u0002J\b\u0010N\u001a\u000204H\u0014J\u0010\u0010O\u001a\u0002042\b\u0010P\u001a\u0004\u0018\u00010)J\u0010\u0010Q\u001a\u0002042\b\u0010P\u001a\u0004\u0018\u00010+J\u0006\u0010R\u001a\u000204J\u0006\u0010S\u001a\u000204J\u0006\u0010T\u001a\u000204J\u001a\u0010U\u001a\u0002042\b\b\u0002\u0010V\u001a\u00020 2\b\b\u0002\u0010W\u001a\u00020 J\b\u0010X\u001a\u00020 H\u0002J\u001e\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010\\\u001a\u00020 H\u0082@¢\u0006\u0004\b]\u0010^J\b\u0010_\u001a\u000204H\u0002J\u000e\u0010`\u001a\u0002042\u0006\u0010;\u001a\u00020\u0017J\u000e\u0010a\u001a\u0002042\u0006\u0010b\u001a\u00020\u0017J \u0010c\u001a\u0002042\b\u0010d\u001a\u0004\u0018\u00010K2\u0006\u0010e\u001a\u00020 H\u0082@¢\u0006\u0002\u0010fJB\u0010g\u001a\u0002042\b\b\u0002\u0010h\u001a\u00020 2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010/2\b\b\u0002\u0010j\u001a\u00020 2\b\b\u0002\u0010k\u001a\u00020 2\b\b\u0002\u0010V\u001a\u00020 H\u0086@¢\u0006\u0002\u0010lJ\u0018\u0010m\u001a\u0002042\b\b\u0002\u0010n\u001a\u00020 H\u0086@¢\u0006\u0002\u0010^J\u000e\u0010o\u001a\u000204H\u0086@¢\u0006\u0002\u0010pJ\u000e\u0010q\u001a\u000204H\u0082@¢\u0006\u0002\u0010pJ\u000e\u0010r\u001a\u000204H\u0082@¢\u0006\u0002\u0010pJ&\u0010s\u001a\u0002042\u0006\u0010h\u001a\u00020 2\u0006\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020 H\u0082@¢\u0006\u0002\u0010tJ\u0010\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020KH\u0002J\u0014\u0010x\u001a\u0004\u0018\u00010y2\b\u0010w\u001a\u0004\u0018\u00010KH\u0002J\u0012\u0010z\u001a\u00020\u00172\b\u0010{\u001a\u0004\u0018\u00010\u0017H\u0002J\u0016\u0010|\u001a\u00020\u001c2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u007f0~H\u0002JT\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~2\u0006\u0010h\u001a\u00020 2\u0006\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020 2\u0007\u0010\u0081\u0001\u001a\u00020 2\u0007\u0010\u0082\u0001\u001a\u00020 2\u0007\u0010\u0083\u0001\u001a\u00020 2\u0007\u0010\u0084\u0001\u001a\u00020 2\u0007\u0010\u0085\u0001\u001a\u00020 H\u0002J\t\u0010\u0086\u0001\u001a\u00020\u0017H\u0002J\u0018\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~2\u0007\u0010\u0088\u0001\u001a\u00020\u0017H\u0002J\t\u0010\u0089\u0001\u001a\u000204H\u0002J\u0018\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~2\u0007\u0010\u008b\u0001\u001a\u00020 H\u0002J\u0018\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~2\u0007\u0010\u0082\u0001\u001a\u00020 H\u0002J\u001e\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020K0~2\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020K0~H\u0002J\u0011\u0010\u008f\u0001\u001a\u0002042\u0006\u0010;\u001a\u00020\u0017H\u0002J\u001a\u0010\u0090\u0001\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0003\u0010\u0091\u0001J\t\u0010\u0092\u0001\u001a\u000204H\u0002J\u0011\u0010\u0093\u0001\u001a\u0002042\b\u0010;\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0094\u0001\u001a\u0002042\u0006\u0010J\u001a\u00020KH\u0082@¢\u0006\u0003\u0010\u0095\u0001J\u001a\u0010\u0096\u0001\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010KH\u0086@¢\u0006\u0003\u0010\u0095\u0001J%\u0010\u0097\u0001\u001a\u0004\u0018\u00010K2\u0006\u0010J\u001a\u00020K2\t\b\u0002\u0010\u0098\u0001\u001a\u00020'H\u0082@¢\u0006\u0003\u0010\u0099\u0001J\u000f\u0010\u009a\u0001\u001a\u0002042\u0006\u0010J\u001a\u00020KJ\u000f\u0010\u009b\u0001\u001a\u0002042\u0006\u0010J\u001a\u00020KJ\r\u0010\u009c\u0001\u001a\u00020 *\u00020KH\u0002J\u001c\u0010\u009d\u0001\u001a\u0002042\u0013\b\u0002\u0010\u009e\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010~J\u0007\u0010\u009f\u0001\u001a\u000204J\u0011\u0010 \u0001\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010KR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u0010\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010AR\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010G¨\u0006¥\u0001"}, d2 = {"Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$UiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_deviceIntentSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/manage/viewmodel/DeviceActionV2;", "deviceIntentSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getDeviceIntentSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_sodaBannerSharedFlow", "Lcom/larus/dora/impl/network/ActivityStatus;", "sodaBannerSharedFlow", "getSodaBannerSharedFlow", "currentDeviceMac", "", "currentBatteryInfo", "", "currentChargeInfo", "lastKnownBindListSize", "", "deviceOrder", "", "isRefreshingLatestCardContent", "", "connectingJob", "Lkotlinx/coroutines/Job;", "connectingDeviceMac", "batteryUpdateJob", "chargeUpdateJob", "debounceDelayMs", "", "deviceSwitchListener", "Lcom/larus/dora/impl/device/manage/OnDeviceSwitchListener;", "connectRequestListener", "Lcom/larus/dora/impl/device/manage/OnConnectRequestListener;", "isFirstLoad", "isFirstEnter", "currentDiaryDisplayMode", "Lcom/larus/dora/impl/device/manage/DiaryDisplayMode;", "registeredAvLinkService", "Lcom/larus/avlink/api/IDoraAVLinkService;", "settingsUpdateListener", "Lkotlin/Function0;", "", "registerAvLinkListeners", "unregisterAvLinkListeners", "currentAvLinkService", "resolveDeviceMode", "Lcom/larus/dora/impl/device/manage/DeviceMode;", "setInitialDeviceMac", "mac", "sceneStateListener", "com/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$sceneStateListener$1", "Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$sceneStateListener$1;", "headphoneModeCallback", "com/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$headphoneModeCallback$1", "Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$headphoneModeCallback$1;", "deviceStateCallback", "com/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$deviceStateCallback$1", "Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$deviceStateCallback$1;", "batteryCallback", "com/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$batteryCallback$1", "Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$batteryCallback$1;", "initializeWithLoadingState", "cacheConnectedDeviceSnapshotIfNeeded", "device", "Lcom/bytedance/dora/device/DoraDevice;", "source", "checkLastConnectedDeviceBindState", "onCleared", "setOnDeviceSwitchListener", "listener", "setOnConnectRequestListener", "resetFirstEnterFlag", "load", "onPageResume", "refreshLatestCardContent", "refreshSodaBanner", "showRefreshAnimation", "isDiaryBetaEnabled", "fetchLatestCardContentInternal", "Lkotlin/Result;", "Lcom/larus/dora/api/entity/LatestCardContentResponse;", "skipDiaryCard", "fetchLatestCardContentInternal-gIAlu-s", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshDeviceList", "switchToDevice", "onDeviceSelected", "option", "performDeviceSwitch", "newDevice", "refreshCardContent", "(Lcom/bytedance/dora/device/DoraDevice;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeviceStatusWithCurrentContent", "showDiaryLoading", "diaryDisplayMode", "isDiaryClickable", "allowAutoSwitch", "(ZLcom/larus/dora/impl/device/manage/DiaryDisplayMode;ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOnlyFirmwareUpdateCard", "hideOnly", "updateOnlySodaBanner", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOnlyDeviceComponentWithoutSoda", "updateOnlyDeviceComponent", "updateDiaryAndQuickNoteComponents", "(ZLcom/larus/dora/impl/device/manage/DiaryDisplayMode;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildDeviceComponentData", "Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$DeviceComponentData;", "selectedDevice", "buildFirmwareUpdateItem", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementFirmwareUpdateItem;", "formatFirmwareUpdateVersion", "version", "findFirmwareUpdateInsertIndex", "items", "", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "buildDiaryComponent", "isBound", "isConnected", "envObserveEnable", "isSodaBannerVisible", "isOtaBannerVisible", "readHealthAgentWebUrl", "buildHealthComponent", "url", "updateHealthComponentFromSettings", "buildQuickNoteComponent", "showQuickNoteLoading", "buildOtherComponents", "sortDeviceList", "devices", "moveDeviceToFront", "isDeviceConnected", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onConnectRequestFailed", "handleConnectRequest", "handleGConnectRequest", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onlyConnect", "scanBleInfo", "timeout", "(Lcom/bytedance/dora/device/DoraDevice;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceBind", "checkBindState", "isV2BleAdvertisementDevice", "checkSodaBanner", "activitiesStatus", "onSodaBannerClosed", "connectAsync", "Companion", "PageState", "UiState", "DeviceComponentData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGDeviceManagementViewModel extends ViewModel {
    private static final a Companion = null;
    public static final String TAG = "DoraGDeviceManagementViewModel";
    private final MutableSharedFlow<com.larus.dora.impl.device.manage.viewmodel.a> _deviceIntentSharedFlow;
    private final MutableSharedFlow<com.larus.dora.impl.network.a> _sodaBannerSharedFlow;
    private final z0<c> _uiState;
    private final DoraGDeviceManagementViewModel$batteryCallback$1 batteryCallback;
    private Job batteryUpdateJob;
    private Job chargeUpdateJob;
    private com.larus.dora.impl.device.manage.z0 connectRequestListener;
    private String connectingDeviceMac;
    private Job connectingJob;
    private int[] currentBatteryInfo;
    private int[] currentChargeInfo;
    private String currentDeviceMac;
    private DiaryDisplayMode currentDiaryDisplayMode;
    private long debounceDelayMs;
    private final d1<com.larus.dora.impl.device.manage.viewmodel.a> deviceIntentSharedFlow;
    private final List<String> deviceOrder;
    private final DoraGDeviceManagementViewModel$deviceStateCallback$1 deviceStateCallback;
    private a1 deviceSwitchListener;
    private final e headphoneModeCallback;
    private boolean isFirstEnter;
    private boolean isFirstLoad;
    private boolean isRefreshingLatestCardContent;
    private int lastKnownBindListSize;
    private IDoraAVLinkService registeredAvLinkService;
    private final DoraGDeviceManagementViewModel$sceneStateListener$1 sceneStateListener;
    private final Function0<Unit> settingsUpdateListener;
    private final d1<com.larus.dora.impl.network.a> sodaBannerSharedFlow;
    private final i1<c> uiState;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/device/manage/viewmodel/DoraGDeviceManagementViewModel$PageState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Content", "Empty", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PageState extends Enum<PageState> {
        public static final PageState Content = null;
        public static final PageState Empty = null;
        public static final PageState Loading = null;
        public static final /* synthetic */ PageState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PageState> getEntries() {
            return b;
        }

        static {
            PageState r0 = new PageState("Loading", 0);
            Loading = r0;
            PageState r1 = new PageState("Content", 1);
            Content = r1;
            PageState r3 = new PageState("Empty", 2);
            Empty = r3;
            PageState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PageState[] values() {
            return (PageState[]) a.clone();
        }

        public static PageState valueOf(String r1) {
            return (PageState) r27.a.a(PageState.class, r1);
        }

        public PageState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final com.larus.dora.impl.device.manage.c a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "DeviceComponentData(deviceItem=" + this.a + ", isConnected=" + this.b + ')';
        }

        public b(com.larus.dora.impl.device.manage.c r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "deviceItem");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final PageState a;
        public final DoraDevice b;
        public final String c;
        public final String d;
        public final String e;
        public final List<String> f;
        public final List<p0> g;
        public final boolean h;
        public final a49.f i;
        public final j j;
        public final boolean k;
        public final boolean l;

        public c() {
            this(null, null, null, null, null, null, false, false, 4095);
        }

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            DoraDevice r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((((((((r0 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
            int r5 = 1231;
            if (this.h == false) goto L9;
            int r6 = 1231;
        L10:
            int r7 = (r4 + r6) * 31;
            a49.f r8 = this.i;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            j r11 = this.j;
            if (r11 == null) goto L18;
            r2 = r11.hashCode();
        L18:
            int r12 = (r10 + r2) * 31;
            if (this.k == false) goto L21;
            int r13 = 1231;
        L22:
            int r14 = (r12 + r13) * 31;
            if (this.l == true) goto L27;
            r5 = 1237;
        L27:
            return r14 + r5;
        L21:
            r13 = 1237;
            goto L22
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = 1237;
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "UiState(pageState=" + this.a + ", selectedDevice=" + this.b + ", selectedDeviceName=" + this.c + ", selectedDeviceMac=" + this.d + ", selectedDeviceStatus=" + this.e + ", deviceOptions=" + this.f + ", items=" + this.g + ", isRefreshing=" + this.h + ", diaryContent=" + this.i + ", quickNoteContent=" + this.j + ", hasBoundDevice=" + this.k + ", isInitialized=" + this.l + ')';
        }

        public /* synthetic */ c(PageState r16, DoraDevice r17, String r18, String r110, List r20, List r21, boolean r22, boolean r23, int r24) {
            if ((r24 & 1) == 0) goto L5;
            PageState r3 = PageState.Loading;
        L7:
            if ((r24 & 2) == 0) goto L9;
            DoraDevice r4 = null;
        L11:
            if ((r24 & 4) == 0) goto L13;
            String r1 = "";
        L15:
            if ((r24 & 8) == 0) goto L17;
            String r6 = "";
        L19:
            if ((r24 & 16) == 0) goto L21;
            String r7 = "";
        L23:
            if ((r24 & 32) == 0) goto L25;
            List r8 = CollectionsKt.emptyList();
        L27:
            if ((r24 & 64) == 0) goto L29;
            List r9 = CollectionsKt.emptyList();
        L31:
            if ((r24 & 1024) == 0) goto L33;
            boolean r13 = false;
        L35:
            if ((r24 & 2048) == 0) goto L37;
            boolean r14 = false;
        L38:
            this(r3, r4, r1, r6, r7, r8, r9, false, null, null, r13, r14);
            return;
        L37:
            r14 = r23;
            goto L38
        L33:
            r13 = r22;
            goto L35
        L29:
            r9 = r21;
            goto L31
        L25:
            r8 = r20;
            goto L27
        L21:
            r7 = null;
            goto L23
        L17:
            r6 = r110;
            goto L19
        L13:
            r1 = r18;
            goto L15
        L9:
            r4 = r17;
            goto L11
        L5:
            r3 = r16;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(PageState r2, DoraDevice r3, String r4, String r5, String r6, List<String> r7, List<? extends p0> r8, boolean r9, a49.f r10, j r11, boolean r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r2, "pageState");
            Intrinsics.checkNotNullParameter(r4, "selectedDeviceName");
            Intrinsics.checkNotNullParameter(r5, "selectedDeviceMac");
            Intrinsics.checkNotNullParameter(r6, "selectedDeviceStatus");
            Intrinsics.checkNotNullParameter(r7, "deviceOptions");
            Intrinsics.checkNotNullParameter(r8, "items");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
        }

        public static c a(c r16, PageState r17, DoraDevice r18, String r110, String r20, List r21, List r22, boolean r23, a49.f r24, j r25, boolean r26, int r27) {
            if ((r27 & 1) == 0) goto L5;
            PageState r4 = r16.a;
        L7:
            if ((r27 & 2) == 0) goto L9;
            DoraDevice r5 = r16.b;
        L11:
            if ((r27 & 4) == 0) goto L13;
            String r6 = r16.c;
        L15:
            if ((r27 & 8) == 0) goto L17;
            String r7 = r16.d;
        L19:
            if ((r27 & 16) == 0) goto L21;
            String r2 = r16.e;
        L22:
            String r8 = r2;
            if ((r27 & 32) == 0) goto L25;
            List r9 = r16.f;
        L27:
            if ((r27 & 64) == 0) goto L29;
            List r10 = r16.g;
        L31:
            if ((r27 & 128) == 0) goto L33;
            boolean r11 = r16.h;
        L35:
            if ((r27 & 256) == 0) goto L37;
            a49.f r12 = r16.i;
        L39:
            if ((r27 & 512) == 0) goto L41;
            j r13 = r16.j;
        L43:
            if ((r27 & 1024) == 0) goto L45;
            boolean r14 = r16.k;
        L47:
            if ((r27 & 2048) == 0) goto L49;
            boolean r15 = r16.l;
        L50:
            r16.getClass();
            Intrinsics.checkNotNullParameter(r4, "pageState");
            Intrinsics.checkNotNullParameter(r6, "selectedDeviceName");
            Intrinsics.checkNotNullParameter(r7, "selectedDeviceMac");
            Intrinsics.checkNotNullParameter(r8, "selectedDeviceStatus");
            Intrinsics.checkNotNullParameter(r9, "deviceOptions");
            Intrinsics.checkNotNullParameter(r10, "items");
            return new c(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        L49:
            r15 = false;
            goto L50
        L45:
            r14 = r26;
            goto L47
        L41:
            r13 = r25;
            goto L43
        L37:
            r12 = r24;
            goto L39
        L33:
            r11 = r23;
            goto L35
        L29:
            r10 = r22;
            goto L31
        L25:
            r9 = r21;
            goto L27
        L21:
            r2 = null;
            goto L22
        L17:
            r7 = r20;
            goto L19
        L13:
            r6 = r110;
            goto L15
        L9:
            r5 = r18;
            goto L11
        L5:
            r4 = r17;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$cacheConnectedDeviceSnapshotIfNeeded$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$cacheConnectedDeviceSnapshotIfNeeded$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        final /* synthetic */ String $source;
        int label;

        public AnonymousClass1(DoraDevice r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$device = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$device, this.$source, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r3);
            if (kj4.a.g().getDoraLinkState(this.$device) != 2) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L11;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "cacheConnectedDeviceSnapshotIfNeeded skip disconnected device, source=" + this.$source);
            return Unit.INSTANCE;
        L11:
            x0 r5 = x0.a;
            DoraDevice r0 = this.$device;
            String r1 = this.$source;
            r5.getClass();
            x0.b(r0, r1);
            return Unit.INSTANCE;
        L7:
            r4 = false;
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$checkBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$checkBindState$1", f = "DoraGDeviceManagementViewModel.kt", i = {1, 2, 3}, l = {1930, 1935, 1940, 1942}, m = "invokeSuspend", n = {"bindData", "bindData", "bindData"}, s = {"L$3", "L$2", "L$2"})
    public static final class C02211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02211(DoraDevice r1, DoraGDeviceManagementViewModel r2, Continuation<? super C02211> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02211(this.$device, this.this$0, r4);
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
            if (r0 == 0) goto L14;
            if (r0 == 1) goto L13;
            if (r0 == 2) goto L12;
            if (r0 == 3) goto L11;
            if (r0 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            com.larus.dora.impl.network.b r1 = (com.larus.dora.impl.network.b) this.L$2;
            DoraGDeviceManagementViewModel r2 = (DoraGDeviceManagementViewModel) this.L$1;
            Object r3 = this.L$0;
            ResultKt.throwOnFailure(r17);
        L46:
            com.larus.dora.impl.network.b r15 = r1;
            DoraGDeviceManagementViewModel r14 = r2;
            Object r12 = r3;
        L47:
            r14.checkSodaBanner(r15.a());
        L48:
            Throwable r4 = Result.exceptionOrNull-impl(r12);
            if (r4 == null) goto L52;
            g49.d.c(DoraGDeviceManagementViewModel.TAG, "checkBindState: failure", r4);
            s r5 = s.a;
            Application r6 = AppHost.a.getApplication();
            r5.getClass();
            s.b(r6, 2131908080, false);
        L52:
            return Unit.INSTANCE;
        L12:
            com.larus.dora.impl.network.b r7 = (com.larus.dora.impl.network.b) this.L$3;
            r2 = (DoraGDeviceManagementViewModel) this.L$2;
            DoraDevice r9 = (DoraDevice) this.L$1;
            Object r10 = this.L$0;
            ResultKt.throwOnFailure(r17);
            r15 = r7;
            Object r11 = r17;
        L33:
            DoraDevice r13 = (DoraDevice) r11;
            if (r13 == null) goto L36;
            r9.mode = r13.mode;
            r9.version = r13.version;
        L36:
            DoraDevice r16 = r9;
            r3 = r10;
        L37:
            r1 = r15;
            MutableSharedFlow r18 = DoraGDeviceManagementViewModel.access$get_deviceIntentSharedFlow$p(r2);
            com.larus.dora.impl.device.manage.viewmodel.a.C0038a r20 = new com.larus.dora.impl.device.manage.viewmodel.a.C0038a(r16);
            this.L$0 = r3;
            this.L$1 = r2;
            this.L$2 = r1;
            this.L$3 = null;
            this.label = 3;
            if (r18.emit(r20, this) != r8) goto L46;
            return r8;
        L13:
            ResultKt.throwOnFailure(r17);
            Object r21 = ((Result) r17).unbox-impl();
        L17:
            r12 = r21;
            r16 = this.$device;
            r14 = this.this$0;
            if (Result.isSuccess-impl(r12) == false) goto L48;
            r15 = (com.larus.dora.impl.network.b) r12;
            Integer r22 = r15.b();
            if (r22 == null) goto L22;
            int r23 = r22.intValue();
        L23:
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "checkBindState: bindCode=" + r23);
            if (r23 == 1) goto L42;
            if (r23 != 2) goto L47;
            if (o59.a.p(r16) == false) goto L38;
            this.L$0 = r12;
            this.L$1 = r16;
            this.L$2 = r14;
            this.L$3 = r15;
            this.label = 2;
            r11 = DoraGDeviceManagementViewModel.scanBleInfo$default(r14, r16, 0, this, 2, null);
            if (r11 != r8) goto L32;
            return r8;
        L32:
            r10 = r12;
            r9 = r16;
            r2 = r14;
            goto L33
        L38:
            r3 = r12;
            r2 = r14;
            goto L37
        L42:
            kj4.a r24 = kj4.a.g();
            this.L$0 = r12;
            this.L$1 = r14;
            this.L$2 = r15;
            this.label = 4;
            if (DoraAdapterExtKt.b(r24) != r8) goto L45;
            return r8;
        L45:
            r3 = r12;
            r2 = r14;
            r1 = r15;
            goto L46
        L22:
            r23 = 0;
            goto L23
        L14:
            ResultKt.throwOnFailure(r17);
            DoraNetworkApi r25 = DoraNetworkApi.a;
            DoraDevice r26 = this.$device;
            this.label = 1;
            r21 = r25.e(r26, true, this);
            if (r21 != r8) goto L17;
            return r8;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$checkLastConnectedDeviceBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$checkLastConnectedDeviceBindState$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02221(DoraGDeviceManagementViewModel r1, Continuation<? super C02221> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02221(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L36;
            ResultKt.throwOnFailure(r6);
            b0.a.getClass();
            DoraSimpleDevice r7 = b0.l();
            Object r0 = null;
            if (r7 == null) goto L7;
            String r1 = r7.getMac();
        L8:
            if (r1 != null) goto L10;
        L13:
            boolean r2 = true;
        L15:
            if (r2 == false) goto L18;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "checkLastConnectedDeviceBindState: no last connected device found");
            return Unit.INSTANCE;
        L18:
            if (r7 == null) goto L20;
            String r8 = r7.getMac();
        L21:
            if (r8 != null) goto L23;
            r8 = "";
        L23:
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "checkLastConnectedDeviceBindState: lastMac=".concat(r8));
            Iterator r3 = DoraAdapterExtKt.k(kj4.a.g()).iterator();
        L25:
            if (r3.hasNext() == false) goto L29;
            Object r4 = r3.next();
            if (Intrinsics.areEqual(((DoraDevice) r4).mac, r8) == false) goto L25;
            r0 = r4;
        L29:
            DoraDevice r5 = (DoraDevice) r0;
            if (r5 == null) goto L32;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "checkLastConnectedDeviceBindState: found device " + o59.a.h(r5) + ", checking bind state");
            this.this$0.checkBindState(r5);
        L34:
            return Unit.INSTANCE;
        L32:
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "checkLastConnectedDeviceBindState: device not in bind list");
            goto L34
        L20:
            r8 = null;
            goto L21
        L10:
            if (r1.length() == 0) goto L13;
            r2 = false;
            goto L15
        L7:
            r1 = null;
            goto L8
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$checkSodaBanner$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$checkSodaBanner$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1968}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02231(DoraGDeviceManagementViewModel r1, Continuation<? super C02231> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02231(this.this$0, r3);
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
            MutableSharedFlow r7 = DoraGDeviceManagementViewModel.access$get_sodaBannerSharedFlow$p(this.this$0);
            com.larus.dora.impl.network.a r3 = new com.larus.dora.impl.network.a(1, false);
            this.label = 1;
            if (r7.emit(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$checkSodaBanner$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$checkSodaBanner$2", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1987}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.dora.impl.network.a $status;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public AnonymousClass2(com.larus.dora.impl.network.a r1, DoraGDeviceManagementViewModel r2, Continuation<? super AnonymousClass2> r3) {
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

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            String r8 = ILoginService.a.getAccountInfo().c;
            b0.a.getClass();
            Intrinsics.checkNotNullParameter(r8, "uid");
            boolean r4 = false;
            boolean r2 = b0.j().getBoolean("dora_soda_banner_user_closed" + r8, false);
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "checkSodaBanner: server isShow=" + this.$status.a() + ", userClosed=" + r2);
            if (r2 == true) goto L12;
            r4 = this.$status.a();
        L12:
            b0.J(r4, r8);
            MutableSharedFlow r9 = DoraGDeviceManagementViewModel.access$get_sodaBannerSharedFlow$p(this.this$0);
            com.larus.dora.impl.network.a r3 = new com.larus.dora.impl.network.a(this.$status.getType(), r4);
            this.label = 1;
            if (r9.emit(r3, this) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$connectAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$connectAsync$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02241(DoraDevice r1, DoraGDeviceManagementViewModel r2, Continuation<? super C02241> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02241(this.$device, this.this$0, r4);
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

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DiaryDisplayMode.values().length];
            r0[DiaryDisplayMode.NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DiaryDisplayMode.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[OnlyConnectResult.values().length];
            r1[OnlyConnectResult.CONNECT_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[OnlyConnectResult.CONNECT_TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[OnlyConnectResult.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final class e extends r0 {
        public final /* synthetic */ DoraGDeviceManagementViewModel a;

        public e(DoraGDeviceManagementViewModel r1) {
            this.a = r1;
        }

        public final void f1(int r3, byte r4) {
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "onDMSHeadphoneModeState: nid=" + r3 + ", mode=" + r4);
            DoraGDeviceManagementViewModel.access$refreshDeviceList(this.a);
        }
    }

    public static final class f extends ScanCallback {
        public final /* synthetic */ CompletableDeferred<Unit> a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> d;

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "connect request, scan failed, err: " + r3);
            this.a.complete(Unit.INSTANCE);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r2, ScanResult r3) {
            if (this.b == false) goto L5;
            DoraDevice r4 = kj4.a.g().convertScanResultToDoraDeviceV2(r3);
        L6:
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "connect request, new scan result: " + r4);
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

        public f(CompletableDeferred<Unit> r1, boolean r2, String r3, Ref.ObjectRef<DoraDevice> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$handleConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$handleConnectRequest$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1718, 1723}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02251(DoraGDeviceManagementViewModel r1, String r2, Continuation<? super C02251> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02251(this.this$0, this.$mac, r4);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ResultKt.throwOnFailure(r9);     // Catch: Exception -> L26
        L29:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r9);     // Catch: Exception -> L26
        L16:
            DoraDevice r10 = (DoraDevice) r9;     // Catch: Exception -> L26
            if (r10 != null) goto L19;
            s r11 = s.a;     // Catch: Exception -> L26
            Application r2 = AppHost.a.getApplication();     // Catch: Exception -> L26
            r11.getClass();     // Catch: Exception -> L26
            s.b(r2, 2131902626, false);     // Catch: Exception -> L26
            DoraGDeviceManagementViewModel.access$onConnectRequestFailed(this.this$0);     // Catch: Exception -> L26
            goto L29
        L19:
            if (o59.a.p(r10) == false) goto L23;
            DoraGDeviceManagementViewModel r3 = this.this$0;     // Catch: Exception -> L26
            this.label = 2;     // Catch: Exception -> L26
            if (DoraGDeviceManagementViewModel.access$handleGConnectRequest(r3, r10, this) != r0) goto L29;
            return r0;
        L23:
            DoraGDeviceManagementViewModel.access$onConnectRequestFailed(this.this$0);     // Catch: Exception -> L26
            goto L29
        L12:
            ResultKt.throwOnFailure(r9);
            CoroutineDispatcher r12 = Dispatchers.getIO();     // Catch: Exception -> L26
            DoraGDeviceManagementViewModel$handleConnectRequest$1$device$1 r4 = new DoraGDeviceManagementViewModel$handleConnectRequest$1$device$1(this.$mac, null);     // Catch: Exception -> L26
            this.label = 1;     // Catch: Exception -> L26
            r9 = BuildersKt.withContext(r12, r4, this);     // Catch: Exception -> L26
            if (r9 != r0) goto L16;
            return r0;
        L26:
            e = move-exception;
            g49.d.b(DoraGDeviceManagementViewModel.TAG, "handleConnectRequest: Exception=" + e);
            s r13 = s.a;
            Application r5 = AppHost.a.getApplication();
            r13.getClass();
            s.b(r5, 2131902626, false);
            DoraGDeviceManagementViewModel.access$onConnectRequestFailed(this.this$0);
            goto L29
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$handleGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {0}, l = {1749, 1772, 1779}, m = "handleGConnectRequest", n = {"device"}, s = {"L$0"})
    public static final class C02261 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02261(DoraGDeviceManagementViewModel r1, Continuation<? super C02261> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraGDeviceManagementViewModel.access$handleGConnectRequest(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$handleGConnectRequest$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$handleGConnectRequest$2", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1780, 1783, 1796, 1805}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02272 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02272(DoraGDeviceManagementViewModel r1, DoraDevice r2, Continuation<? super C02272> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02272(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r13);
        L37:
            DoraGDeviceManagementViewModel.access$onConnectRequestFailed(this.this$0);
        L39:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r13);
        L30:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r13);
        L22:
            DoraGDeviceManagementViewModel.access$onConnectRequestFailed(this.this$0);
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r13);
        L17:
            DoraDevice r14 = (DoraDevice) r13;
            if (r14 != null) goto L24;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "connect request, scan new device info error");
            MutableSharedFlow r15 = DoraGDeviceManagementViewModel.access$get_deviceIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.manage.viewmodel.a.b r2 = new com.larus.dora.impl.device.manage.viewmodel.a.b(this.$device);
            this.label = 2;
            if (r15.emit(r2, this) != r0) goto L22;
            return r0;
        L24:
            DoraDevice r4 = this.$device;
            r4.mode = r14.mode;
            r4.version = r14.version;
            if (o59.a.v(r4) == true) goto L32;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "connect request, this device don't sup factory, connect spp ");
            DoraGDeviceManagementViewModel r16 = this.this$0;
            DoraDevice r3 = this.$device;
            this.label = 3;
            if (r16.onlyConnect(r3, this) != r0) goto L30;
            return r0;
        L32:
            if (this.$device.isFactory() == false) goto L34;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "connect request, device is factory, replace bind it");
            this.this$0.replaceBind(this.$device);
            goto L39
        L34:
            MutableSharedFlow r17 = DoraGDeviceManagementViewModel.access$get_deviceIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.manage.viewmodel.a.C0038a r5 = new com.larus.dora.impl.device.manage.viewmodel.a.C0038a(this.$device);
            this.label = 4;
            if (r17.emit(r5, this) != r0) goto L37;
            return r0;
        L14:
            ResultKt.throwOnFailure(r13);
            DoraGDeviceManagementViewModel r18 = this.this$0;
            DoraDevice r6 = this.$device;
            this.label = 1;
            r13 = DoraGDeviceManagementViewModel.scanBleInfo$default(r18, r6, 0, this, 2, null);
            if (r13 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$initializeWithLoadingState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$initializeWithLoadingState$1", f = "DoraGDeviceManagementViewModel.kt", i = {0}, l = {335}, m = "invokeSuspend", n = {"items"}, s = {"L$0"})
    public static final class C02281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02281(DoraGDeviceManagementViewModel r1, Continuation<? super C02281> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02281(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r30) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            Object r3 = null;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            List r4 = (List) this.L$0;
            ResultKt.throwOnFailure(r30);
            Object r5 = r30;
            List r12 = r4;
        L12:
            List r6 = DoraGDeviceManagementViewModel.access$sortDeviceList(this.this$0, (List) r5);
            List r7 = r6;
            DoraGDeviceManagementViewModel r8 = this.this$0;
            Iterator r9 = r7.iterator();
        L14:
            if (r9.hasNext() == false) goto L18;
            Object r10 = r9.next();
            if (Intrinsics.areEqual(((DoraDevice) r10).mac, DoraGDeviceManagementViewModel.access$getCurrentDeviceMac$p(r8)) == false) goto L14;
            r3 = r10;
        L18:
            DoraDevice r11 = (DoraDevice) r3;
            if (r11 != null) goto L21;
            r11 = (DoraDevice) CollectionsKt.firstOrNull(r6);
        L21:
            ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r14 = r7.iterator();
        L23:
            if (r14.hasNext() == false) goto L29;
            String r15 = ((DoraDevice) r14.next()).name;
            if (r15 != null) goto L27;
            r15 = "Unknown Device";
        L27:
            r13.add(r15);
            goto L23
        L29:
            if (r11 == null) goto L42;
            b r16 = DoraGDeviceManagementViewModel.access$buildDeviceComponentData(this.this$0, r11);
            boolean r17 = r16.b;
            DoraGDeviceManagementViewModel.access$cacheConnectedDeviceSnapshotIfNeeded(this.this$0, r11, "initialize");
            r12.add(r16.a);
            g r18 = DoraGDeviceManagementViewModel.access$buildFirmwareUpdateItem(this.this$0, r11);
            if (r18 == null) goto L33;
            Boxing.boxBoolean(r12.add(r18));
        L33:
            String r20 = ILoginService.a.getAccountInfo().c;
            b0.a.getClass();
            boolean r21 = b0.f(r20);
            if (r21 == false) goto L41;
            if (r17 == false) goto L41;
            if (r18 == null) goto L39;
            boolean r22 = true;
        L40:
            r12.add(new b1(true, r22, 15));
            goto L41
        L39:
            r22 = false;
        L41:
            boolean r110 = r17;
            boolean r111 = r21;
        L44:
            if (r111 == false) goto L47;
            if (r110 == false) goto L47;
            boolean r26 = true;
        L48:
            if (r11 == null) goto L63;
            List r23 = r12;
            if ((r23 instanceof Collection) == true) goto L52;
        L54:
            Iterator r24 = r23.iterator();
        L56:
            if (r24.hasNext() == false) goto L60;
            if ((((p0) r24.next()) instanceof g) == false) goto L56;
            boolean r25 = true;
        L61:
            if (r25 == false) goto L63;
            boolean r27 = true;
        L64:
            r12.add(new com.larus.dora.impl.device.manage.d(null, null, null, null, true, null, null, false, r26, r27, 7423));
            DoraGDeviceManagementViewModel r28 = this.this$0;
            p0 r31 = (p0) CollectionsKt.firstOrNull(DoraGDeviceManagementViewModel.access$buildHealthComponent(r28, DoraGDeviceManagementViewModel.access$readHealthAgentWebUrl(r28)));
            if (r31 == null) goto L67;
            Boxing.boxBoolean(r12.add(r31));
        L67:
            r12.add(new com.larus.dora.impl.device.manage.e(null, null, null, null, null, false, true, 511));
            r12.addAll(CollectionsKt.listOf(new p0[]{new q0(true, 15), new t0(r110, 15), new u0(r110, 31), new com.larus.dora.impl.device.manage.f(0), new s0()}));
            z0 r32 = DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0);
            PageState r33 = PageState.Loading;
            if (r11 == null) goto L73;
            String r34 = r11.name;
            if (r34 == null) goto L73;
            String r35 = r34;
        L74:
            if (r11 == null) goto L79;
            String r36 = r11.mac;
            if (r36 == null) goto L79;
            String r112 = r36;
        L80:
            boolean r37 = r110;
            r32.setValue(new c(r33, r11, r35, r112, r13, r12, !r6.isEmpty(), true, 912));
            StringBuilder r38 = new StringBuilder("initializeWithLoadingState: initialized with complete items, hasDevice=");
            if (r11 == null) goto L83;
            boolean r40 = true;
        L84:
            r38.append(r40);
            r38.append(", sodaBannerVisible=");
            if (r111 == false) goto L88;
            if (r37 == false) goto L88;
            boolean r41 = true;
        L89:
            r38.append(r41);
            g49.d.d(DoraGDeviceManagementViewModel.TAG, r38.toString());
            return Unit.INSTANCE;
        L88:
            r41 = false;
            goto L89
        L83:
            r40 = false;
        L79:
            r112 = "";
        L73:
            r35 = "";
        L60:
            r25 = false;
            goto L61
        L52:
            if (r23.isEmpty() == false) goto L54;
        L63:
            r27 = false;
        L47:
            r26 = false;
            goto L48
        L42:
            r110 = false;
            r111 = false;
            goto L44
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r30);
            ArrayList r42 = new ArrayList();
            CoroutineDispatcher r43 = Dispatchers.getIO();
            DoraGDeviceManagementViewModel$initializeWithLoadingState$1$rawBindList$1 r44 = new DoraGDeviceManagementViewModel$initializeWithLoadingState$1$rawBindList$1(null);
            this.L$0 = r42;
            this.label = 1;
            r5 = BuildersKt.withContext(r43, r44, this);
            if (r5 != r1) goto L11;
            return r1;
        L11:
            r12 = r42;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$isDeviceConnected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1689, 1692}, m = "isDeviceConnected", n = {}, s = {})
    public static final class C02291 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02291(DoraGDeviceManagementViewModel r1, Continuation<? super C02291> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraGDeviceManagementViewModel.access$isDeviceConnected(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$isDeviceConnected$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$isDeviceConnected$2", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;

        public C02302(DoraDevice r1, Continuation<? super C02302> r2) {
            this.$device = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02302(this.$device, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (kj4.a.g().getDoraLinkState(this.$device) != 2) goto L7;
            boolean r3 = true;
        L9:
            return Boxing.boxBoolean(r3);
        L7:
            r3 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$load$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$load$1", f = "DoraGDeviceManagementViewModel.kt", i = {1, 1, 2, 3, 4}, l = {489, 500, 544, 563, 571}, m = "invokeSuspend", n = {"rawBindList", "hasNewDevice", "bindList", "selectedDevice", "selectedDevice"}, s = {"L$0", "I$0", "L$0", "L$0", "L$0"})
    public static final class C02311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02311(DoraGDeviceManagementViewModel r1, Continuation<? super C02311> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02311(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            Object r8 = null;
            if (r0 == 0) goto L16;
            if (r0 == 1) goto L15;
            if (r0 == 2) goto L14;
            if (r0 == 3) goto L13;
            if (r0 == 4) goto L12;
            if (r0 == 5) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            DoraDevice r1 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r18);
            r8 = null;
            boolean r14 = false;
        L144:
            DoraDevice r11 = r1;
        L148:
            if (r11 == null) goto L150;
            this.this$0.checkBindState(r11);
        L150:
            DoraGDeviceManagementViewModel.refreshLatestCardContent$default(this.this$0, r14, r14, 3, r8);
            DoraGDeviceManagementViewModel.access$setFirstLoad$p(this.this$0, r14);
            return Unit.INSTANCE;
        L13:
            List r2 = (List) this.L$0;
            ResultKt.throwOnFailure(r18);
            r14 = false;
        L122:
            DoraGDeviceManagementViewModel r3 = this.this$0;
            Iterator r4 = r2.iterator();
        L124:
            if (r4.hasNext() == false) goto L128;
            Object r9 = r4.next();
            if (Intrinsics.areEqual(((DoraDevice) r9).mac, DoraGDeviceManagementViewModel.access$getCurrentDeviceMac$p(r3)) == false) goto L124;
        L129:
            DoraDevice r12 = (DoraDevice) r9;
            if (r12 != null) goto L132;
            r11 = (DoraDevice) CollectionsKt.firstOrNull(r2);
        L133:
            if (r11 == null) goto L148;
            if (kj4.a.g().getDoraLinkState(r11) != 2) goto L148;
            DoraDevice r5 = DoraAdapterExtKt.i(kj4.a.g(), r14);
            if (r5 != null) goto L139;
        L145:
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "load: forcing initial battery update from bind list device: " + o59.a.h(r11));
            DoraGDeviceManagementViewModel.access$setCurrentBatteryInfo$p(this.this$0, o59.a.a(r11));
            DoraGDeviceManagementViewModel.access$setCurrentChargeInfo$p(this.this$0, o59.a.b(r11));
            DoraGDeviceManagementViewModel r6 = this.this$0;
            this.L$0 = r11;
            this.label = 5;
            if (DoraGDeviceManagementViewModel.updateDeviceStatusWithCurrentContent$default(r6, true, null, false, true, false, this, 22, null) == r10) goto L147;
        L143:
            r1 = r11;
            goto L144
        L147:
            return r10;
        L139:
            if (Intrinsics.areEqual(r5.mac, r11.mac) == false) goto L145;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "load: using active device for initial battery info: " + o59.a.h(r5));
            DoraGDeviceManagementViewModel.access$setCurrentBatteryInfo$p(this.this$0, o59.a.a(r5));
            DoraGDeviceManagementViewModel.access$setCurrentChargeInfo$p(this.this$0, o59.a.b(r5));
            DoraGDeviceManagementViewModel r7 = this.this$0;
            this.L$0 = r11;
            this.label = 4;
            if (DoraGDeviceManagementViewModel.updateDeviceStatusWithCurrentContent$default(r7, true, null, false, true, false, this, 22, null) != r10) goto L143;
            return r10;
        L132:
            r11 = r12;
            goto L133
        L128:
            r9 = r8;
            goto L129
        L14:
            int r13 = this.I$0;
            List r15 = (List) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r16 = r18;
        L30:
            DoraGDeviceManagementViewModel.access$getDeviceOrder$p(this.this$0).clear();
            List r17 = DoraGDeviceManagementViewModel.access$getDeviceOrder$p(this.this$0);
            ArrayList r20 = new ArrayList();
            Iterator r21 = ((List) r16).iterator();
        L32:
            if (r21.hasNext() == false) goto L47;
            Object r22 = r21.next();
            String r23 = (String) r22;
            List r110 = r15;
            if ((r110 instanceof Collection) == true) goto L36;
        L38:
            Iterator r111 = r110.iterator();
        L40:
            if (r111.hasNext() == false) goto L37;
            if (Intrinsics.areEqual(((DoraDevice) r111.next()).mac, r23) == false) goto L40;
            boolean r24 = true;
        L44:
            if (r24 == false) goto L32;
            r20.add(r22);
        L37:
            r24 = false;
            goto L44
        L36:
            if (r110.isEmpty() == false) goto L38;
        L47:
            r17.addAll(r20);
            DoraGDeviceManagementViewModel r25 = this.this$0;
            Iterator r26 = r15.iterator();
        L49:
            if (r26.hasNext() == false) goto L53;
            DoraDevice r27 = (DoraDevice) r26.next();
            if (DoraGDeviceManagementViewModel.access$getDeviceOrder$p(r25).contains(r27.mac) == true) goto L49;
            DoraGDeviceManagementViewModel.access$getDeviceOrder$p(r25).add(r27.mac);
        L53:
            List r112 = DoraGDeviceManagementViewModel.access$sortDeviceList(this.this$0, r15);
            if (r13 == 0) goto L84;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "load: new device detected, switching to connected device");
            DoraDevice r28 = DoraAdapterExtKt.i(kj4.a.g(), false);
            if (r28 == null) goto L70;
            List r30 = r112;
            if ((r30 instanceof Collection) == true) goto L60;
        L62:
            Iterator r31 = r30.iterator();
        L64:
            if (r31.hasNext() == false) goto L61;
            if (Intrinsics.areEqual(((DoraDevice) r31.next()).mac, r28.mac) == false) goto L64;
            boolean r32 = true;
        L68:
            if (r32 == false) goto L70;
        L81:
            if (r28 == null) goto L118;
            DoraGDeviceManagementViewModel.access$setCurrentDeviceMac$p(this.this$0, r28.mac);
            DoraGDeviceManagementViewModel.access$setCurrentBatteryInfo$p(this.this$0, null);
            DoraGDeviceManagementViewModel.access$setCurrentChargeInfo$p(this.this$0, null);
        L118:
            DoraGDeviceManagementViewModel r33 = this.this$0;
            DiaryDisplayMode r34 = DiaryDisplayMode.NORMAL;
            DoraGDeviceManagementViewModel.access$setCurrentDiaryDisplayMode$p(r33, r34);
            DoraGDeviceManagementViewModel r35 = this.this$0;
            this.L$0 = r112;
            this.label = 3;
            r14 = false;
            if (DoraGDeviceManagementViewModel.updateDeviceStatusWithCurrentContent$default(r35, true, r34, false, true, false, this, 20, null) != r10) goto L121;
            return r10;
        L121:
            r2 = r112;
        L61:
            r32 = false;
            goto L68
        L60:
            if (r30.isEmpty() == false) goto L62;
        L70:
            Iterator r36 = r112.iterator();
        L72:
            if (r36.hasNext() == false) goto L79;
            Object r37 = r36.next();
            if (kj4.a.g().getDoraLinkState((DoraDevice) r37) != 2) goto L76;
            boolean r38 = true;
        L77:
            if (r38 == false) goto L72;
        L80:
            r28 = (DoraDevice) r37;
            goto L81
        L76:
            r38 = false;
            goto L77
        L79:
            r37 = null;
            goto L80
        L84:
            if (DoraGDeviceManagementViewModel.access$getCurrentDeviceMac$p(this.this$0) != null) goto L118;
            DoraDevice r40 = DoraAdapterExtKt.i(kj4.a.g(), false);
            if (r40 == null) goto L100;
            List r41 = r112;
            if ((r41 instanceof Collection) == true) goto L90;
        L92:
            Iterator r42 = r41.iterator();
        L94:
            if (r42.hasNext() == false) goto L91;
            if (Intrinsics.areEqual(((DoraDevice) r42.next()).mac, r40.mac) == false) goto L94;
            boolean r43 = true;
        L98:
            if (r43 == false) goto L100;
        L111:
            if (r40 == null) goto L113;
            DoraGDeviceManagementViewModel.access$setCurrentDeviceMac$p(this.this$0, r40.mac);
            goto L118
        L113:
            DoraGDeviceManagementViewModel r44 = this.this$0;
            DoraDevice r45 = (DoraDevice) CollectionsKt.firstOrNull(r112);
            if (r45 == null) goto L116;
            String r46 = r45.mac;
        L117:
            DoraGDeviceManagementViewModel.access$setCurrentDeviceMac$p(r44, r46);
            goto L118
        L116:
            r46 = null;
        L91:
            r43 = false;
            goto L98
        L90:
            if (r41.isEmpty() == false) goto L92;
        L100:
            Iterator r47 = r112.iterator();
        L102:
            if (r47.hasNext() == false) goto L109;
            Object r48 = r47.next();
            if (kj4.a.g().getDoraLinkState((DoraDevice) r48) != 2) goto L106;
            boolean r50 = true;
        L107:
            if (r50 == false) goto L102;
        L110:
            r40 = (DoraDevice) r48;
            goto L111
        L106:
            r50 = false;
            goto L107
        L109:
            r48 = null;
            goto L110
        L15:
            ResultKt.throwOnFailure(r18);
            Object r51 = r18;
        L19:
            r15 = (List) r51;
            if (r15.size() > DoraGDeviceManagementViewModel.access$getLastKnownBindListSize$p(this.this$0)) goto L22;
        L24:
            r13 = 0;
        L25:
            DoraGDeviceManagementViewModel.access$setLastKnownBindListSize$p(this.this$0, r15.size());
            if (DoraGDeviceManagementViewModel.access$getDeviceOrder$p(this.this$0).isEmpty() == false) goto L53;
            CoroutineDispatcher r52 = Dispatchers.getIO();
            DoraGDeviceManagementViewModel$load$1$history$1 r53 = new DoraGDeviceManagementViewModel$load$1$history$1(null);
            this.L$0 = r15;
            this.I$0 = r13;
            this.label = 2;
            r16 = BuildersKt.withContext(r52, r53, this);
            if (r16 != r10) goto L30;
            return r10;
        L22:
            if (DoraGDeviceManagementViewModel.access$getLastKnownBindListSize$p(this.this$0) <= 0) goto L24;
            r13 = 1;
            goto L25
        L16:
            ResultKt.throwOnFailure(r18);
            CoroutineDispatcher r54 = Dispatchers.getIO();
            DoraGDeviceManagementViewModel$load$1$rawBindList$1 r55 = new DoraGDeviceManagementViewModel$load$1$rawBindList$1(null);
            this.label = 1;
            r51 = BuildersKt.withContext(r54, r55, this);
            if (r51 != r10) goto L19;
            return r10;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onConnectRequestFailed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onConnectRequestFailed$1", f = "DoraGDeviceManagementViewModel.kt", i = {0}, l = {1700}, m = "invokeSuspend", n = {"targetMac"}, s = {"L$0"})
    public static final class C02321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02321(DoraGDeviceManagementViewModel r1, Continuation<? super C02321> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02321(this.this$0, r3);
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
            String r2 = (String) this.L$0;
            ResultKt.throwOnFailure(r4);
        L16:
            if (((Boolean) r4).booleanValue() == false) goto L19;
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "onConnectRequestFailed: skip reset because device already connected, mac=" + r2);
            DoraGDeviceManagementViewModel.access$setConnectingDeviceMac$p(this.this$0, null);
            DoraGDeviceManagementViewModel.access$refreshDeviceList(this.this$0);
            return Unit.INSTANCE;
        L19:
            DoraGDeviceManagementViewModel.access$setConnectingDeviceMac$p(this.this$0, null);
            DoraGDeviceManagementViewModel.access$refreshDeviceList(this.this$0);
            com.larus.dora.impl.device.manage.z0 r5 = DoraGDeviceManagementViewModel.access$getConnectRequestListener$p(this.this$0);
            if (r5 == null) goto L23;
            r5.a();
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            String r6 = DoraGDeviceManagementViewModel.access$getConnectingDeviceMac$p(this.this$0);
            if (r6 != null) goto L11;
            r6 = DoraGDeviceManagementViewModel.access$getCurrentDeviceMac$p(this.this$0);
        L11:
            DoraGDeviceManagementViewModel r3 = this.this$0;
            this.L$0 = r6;
            this.label = 1;
            Object r7 = DoraGDeviceManagementViewModel.access$isDeviceConnected(r3, r6, this);
            if (r7 != r0) goto L14;
            return r0;
        L14:
            r2 = r6;
            r4 = r7;
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onDeviceSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onDeviceSelected$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {901, 907, 910}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $option;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02331(DoraGDeviceManagementViewModel r1, String r2, Continuation<? super C02331> r3) {
            this.this$0 = r1;
            this.$option = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02331(this.this$0, this.$option, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Object r2 = null;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r8);
        L34:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r8);
        L29:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r8);
        L15:
            DoraGDeviceManagementViewModel r3 = this.this$0;
            List r9 = DoraGDeviceManagementViewModel.access$sortDeviceList(r3, (List) r8);
            String r4 = this.$option;
            Iterator r10 = r9.iterator();
        L17:
            if (r10.hasNext() == false) goto L21;
            Object r5 = r10.next();
            if (Intrinsics.areEqual(((DoraDevice) r5).name, r4) == false) goto L17;
            r2 = r5;
        L21:
            DoraDevice r6 = (DoraDevice) r2;
            if (r6 != null) goto L24;
        L30:
            DoraGDeviceManagementViewModel r11 = this.this$0;
            this.label = 3;
            if (DoraGDeviceManagementViewModel.access$performDeviceSwitch(r11, r6, false, this) != r0) goto L34;
            return r0;
        L24:
            if (o59.a.p(r6) == true) goto L30;
            MutableSharedFlow r12 = DoraGDeviceManagementViewModel.access$get_deviceIntentSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.manage.viewmodel.a.d r7 = new com.larus.dora.impl.device.manage.viewmodel.a.d(r6);
            this.label = 2;
            if (r12.emit(r7, this) != r0) goto L29;
            return r0;
        L12:
            ResultKt.throwOnFailure(r8);
            CoroutineDispatcher r13 = Dispatchers.getIO();
            DoraGDeviceManagementViewModel$onDeviceSelected$1$rawBindList$1 r14 = new DoraGDeviceManagementViewModel$onDeviceSelected$1$rawBindList$1(null);
            this.label = 1;
            r8 = BuildersKt.withContext(r13, r14, this);
            if (r8 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onPageResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onPageResume$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02341(DoraGDeviceManagementViewModel r1, Continuation<? super C02341> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02341(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            if (DoraGDeviceManagementViewModel.access$isFirstEnter$p(this.this$0) == false) goto L7;
            DoraGDeviceManagementViewModel.refreshLatestCardContent$default(this.this$0, true, false, 2, null);
            DoraGDeviceManagementViewModel.access$setFirstEnter$p(this.this$0, false);
        L9:
            return Unit.INSTANCE;
        L7:
            DoraGDeviceManagementViewModel.refreshLatestCardContent$default(this.this$0, false, false, 2, null);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onSodaBannerClosed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onSodaBannerClosed$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {2000}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02351(DoraGDeviceManagementViewModel r1, Continuation<? super C02351> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02351(this.this$0, r3);
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
            DoraGDeviceManagementViewModel r5 = this.this$0;
            this.label = 1;
            if (r5.updateOnlySodaBanner(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$onlyConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {0}, l = {1828, 1834, 1841}, m = "onlyConnect", n = {"device"}, s = {"L$0"})
    public static final class C02361 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02361(DoraGDeviceManagementViewModel r1, Continuation<? super C02361> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onlyConnect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$performDeviceSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {0, 1, 1}, l = {939, 945}, m = "performDeviceSwitch", n = {"refreshCardContent", "event", "refreshCardContent"}, s = {"Z$0", "L$0", "Z$0"})
    public static final class C02371 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02371(DoraGDeviceManagementViewModel r1, Continuation<? super C02371> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return DoraGDeviceManagementViewModel.access$performDeviceSwitch(this.this$0, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshDeviceList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshDeviceList$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {880}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02381(DoraGDeviceManagementViewModel r1, Continuation<? super C02381> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02381(this.this$0, r3);
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
            DoraGDeviceManagementViewModel r5 = this.this$0;
            this.label = 1;
            if (DoraGDeviceManagementViewModel.access$updateOnlyDeviceComponentWithoutSoda(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshLatestCardContent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$refreshLatestCardContent$1", f = "DoraGDeviceManagementViewModel.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {617, 652, 653, 795, 806, 816}, m = "invokeSuspend", n = {"$this$launch", "betaDeferred", "envObserveEnable", "diaryBetaEnabled", "result", "envObserveEnable", "diaryBetaEnabled"}, s = {"L$0", "L$0", "I$0", "Z$0", "L$0", "I$0", "Z$0"})
    public static final class C02391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $refreshSodaBanner;
        final /* synthetic */ boolean $showRefreshAnimation;
        int I$0;
        private /* synthetic */ Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02391(DoraGDeviceManagementViewModel r1, boolean r2, boolean r3, Continuation<? super C02391> r4) {
            this.this$0 = r1;
            this.$showRefreshAnimation = r2;
            this.$refreshSodaBanner = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C02391 r0 = new C02391(this.this$0, this.$showRefreshAnimation, this.$refreshSodaBanner, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v11 */
        /* JADX WARN: Type inference failed for: r12v12 */
        /* JADX WARN: Type inference failed for: r12v13 */
        /* JADX WARN: Type inference failed for: r12v14 */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v14 */
        /* JADX WARN: Type inference failed for: r4v17 */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v19 */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v20 */
        /* JADX WARN: Type inference failed for: r4v25 */
        /* JADX WARN: Type inference failed for: r4v26 */
        /* JADX WARN: Type inference failed for: r4v27 */
        /* JADX WARN: Type inference failed for: r4v28 */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r4v8 */
        public final Object invokeSuspend(Object r42) {
            String r12 = "refreshLatestCardContent: quickNote=";
            String r9 = "refreshLatestCardContent: failed ";
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r4 = 1;
            switch(this.label) {
                case 0: goto L24;
                case 1: goto L20;
                case 2: goto L17;
                case 3: goto L14;
                case 4: goto L8;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r42);     // Catch: Throwable -> L10
        L359:
            if (this.$showRefreshAnimation == false) goto L361;
        L360:
            DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).setValue(c.a((c) DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).getValue(), null, null, null, null, null, null, false, null, null, false, 3967));
        L361:
            DoraGDeviceManagementViewModel.access$setRefreshingLatestCardContent$p(this.this$0, false);
            return Unit.INSTANCE;
        L8:
            ResultKt.throwOnFailure(r42);     // Catch: Throwable -> L10 Exception -> L12
        L345:
            if (this.$showRefreshAnimation == false) goto L361;
        L14:
            boolean r1 = this.Z$0;
            int r2 = this.I$0;
            Result r3 = (Result) this.L$0;
            ResultKt.throwOnFailure(r42);     // Catch: Throwable -> L10 Exception -> L12
            Result r5 = r3;
            String r28 = DoraGDeviceManagementViewModel.TAG;
            r9 = "refreshLatestCardContent: failed ";
            r12 = "refreshLatestCardContent: quickNote=";
            Object r6 = r42;
            ?? r13 = r2;
            Object r7 = r8;
        L55:
            Result r10 = (Result) r6;     // Catch: Throwable -> L10 Exception -> L57
            boolean r11 = r1;
            Result r14 = r5;
            ?? r15 = r5;
            ?? r16 = r13;
        L372:
            if (r14 != null) goto L62;
        L337:
            String r17 = r28;
            StringBuilder r18 = new StringBuilder(r9);     // Catch: Throwable -> L10 Exception -> L347
            if (r14 == null) goto L340;
            Throwable r20 = Result.exceptionOrNull-impl(r14.unbox-impl());     // Catch: Throwable -> L10 Exception -> L347
        L341:
            r18.append(r20);     // Catch: Throwable -> L10 Exception -> L347
            g49.d.b(r17, r18.toString());     // Catch: Throwable -> L10 Exception -> L347
            DoraGDeviceManagementViewModel r21 = this.this$0;     // Catch: Throwable -> L10 Exception -> L347
            DiaryDisplayMode r22 = DiaryDisplayMode.NETWORK_ERROR;     // Catch: Throwable -> L10 Exception -> L347
            DoraGDeviceManagementViewModel.access$setCurrentDiaryDisplayMode$p(r21, r22);     // Catch: Throwable -> L10 Exception -> L347
            DoraGDeviceManagementViewModel r23 = this.this$0;     // Catch: Throwable -> L10 Exception -> L347
            this.L$0 = null;     // Catch: Throwable -> L10 Exception -> L347
            this.label = 5;     // Catch: Throwable -> L10 Exception -> L347
            if (DoraGDeviceManagementViewModel.access$updateDiaryAndQuickNoteComponents(r23, false, r22, false, this) != r7) goto L345;
            return r7;
        L340:
            r20 = null;
            goto L341
        L62:
            if (Result.isSuccess-impl(r14.unbox-impl()) == false) goto L337;
            Object r24 = r14.unbox-impl();     // Catch: Throwable -> L10 Exception -> L349
            if (Result.isFailure-impl(r24) == false) goto L66;
            r24 = null;
        L66:
            h r25 = (h) r24;     // Catch: Throwable -> L10 Exception -> L349
            String r26 = r28;
            g49.d.d(r26, "refreshLatestCardContent: success response=" + r25);     // Catch: Throwable -> L10 Exception -> L347
            Ref.ObjectRef r27 = new Ref.ObjectRef();     // Catch: Throwable -> L10 Exception -> L347
            Ref.ObjectRef r30 = new Ref.ObjectRef();     // Catch: Throwable -> L10 Exception -> L347
            DiaryDisplayMode r31 = DiaryDisplayMode.NORMAL;     // Catch: Throwable -> L10 Exception -> L347
            if (r25 == null) goto L91;
            a49.a r32 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r32 == null) goto L91;
            a49.e r33 = r32.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r33 == null) goto L91;
            String r110 = r33.g();     // Catch: Throwable -> L10 Exception -> L347
            if (r110 != null) goto L77;
        L80:
            boolean r111 = true;
        L81:
            if (r111 == false) goto L90;
            String r34 = r33.b();     // Catch: Throwable -> L10 Exception -> L347
            if (r34 != null) goto L85;
        L88:
            boolean r35 = true;
        L89:
            if (r35 == true) goto L91;
        L85:
            if (r34.length() == 0) goto L88;
            r35 = false;
        L90:
            boolean r36 = true;
        L92:
            if (r11 == false) goto L94;
            g49.d.d(r26, "refreshLatestCardContent: diary card comes from beta api");     // Catch: Throwable -> L10 Exception -> L347
            Unit r37 = Unit.INSTANCE;     // Catch: Throwable -> L10 Exception -> L347
        L113:
            DiaryDisplayMode r112 = r31;
            boolean r38 = true;
        L240:
            if (r11 == false) goto L315;
            if (r10 == null) goto L246;
            Object r40 = r10.unbox-impl();     // Catch: Throwable -> L10 Exception -> L347
            if (Result.isFailure-impl(r40) == false) goto L245;
            r40 = null;
        L245:
            a49.c r41 = (a49.c) r40;     // Catch: Throwable -> L10 Exception -> L347
        L247:
            if (r10 == null) goto L252;
            if (Result.isSuccess-impl(r10.unbox-impl()) != true) goto L252;
            boolean r113 = true;
        L253:
            if (r113 == false) goto L309;
            if (r41 == null) goto L309;
            a49.d r43 = r41.b();     // Catch: Throwable -> L10 Exception -> L347
            a49.b r44 = r41.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r44 == null) goto L274;
            String r114 = r44.d();     // Catch: Throwable -> L10 Exception -> L347
            if (r114 != null) goto L260;
        L263:
            boolean r115 = true;
        L264:
            if (r115 == false) goto L273;
            String r116 = r44.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r116 != null) goto L268;
        L271:
            boolean r117 = true;
        L272:
            if (r117 == true) goto L274;
        L268:
            if (r116.length() == 0) goto L271;
            r117 = false;
        L273:
            boolean r118 = true;
        L275:
            StringBuilder r119 = new StringBuilder("refreshLatestCardContent: diary beta hasText=");     // Catch: Throwable -> L10 Exception -> L347
            if (r118 == false) goto L278;
            boolean r120 = true;
        L279:
            r119.append(r120);     // Catch: Throwable -> L10 Exception -> L347
            r119.append(" hasWidget=");     // Catch: Throwable -> L10 Exception -> L347
            if (r43 == null) goto L282;
            boolean r121 = true;
        L283:
            r119.append(r121);     // Catch: Throwable -> L10 Exception -> L347
            g49.d.d(r26, r119.toString());     // Catch: Throwable -> L10 Exception -> L347
            if (r118 == false) goto L305;
            if (r44 == null) goto L287;
            String r122 = r44.d();     // Catch: Throwable -> L10 Exception -> L347
        L288:
            if (r44 == null) goto L290;
            String r123 = r44.a();     // Catch: Throwable -> L10 Exception -> L347
        L291:
            if (r44 == null) goto L293;
            String r210 = r44.b();     // Catch: Throwable -> L10 Exception -> L347
        L294:
            if (r44 == null) goto L303;
            String r45 = r44.c();     // Catch: Throwable -> L10 Exception -> L347
            if (r45 == null) goto L303;
            if (r45.length() <= 0) goto L300;
            boolean r124 = true;
        L301:
            if (r124 == false) goto L303;
            String r211 = r45;
        L304:
            r27.element = new a49.f(r122, r123, r210, r211, 966);     // Catch: Throwable -> L10 Exception -> L347
            DiaryDisplayMode r46 = r31;
            boolean r47 = true;
        L314:
            r112 = r46;
            r38 = true;
        L316:
            if (r47 == false) goto L320;
            IDoraGResourceService r48 = (IDoraGResourceService) ServiceManager.get().getService(IDoraGResourceService.class);     // Catch: Throwable -> L10 Exception -> L347
            if (r48 == null) goto L324;
            r48.a(r43);     // Catch: Throwable -> L10 Exception -> L347
            Unit r50 = Unit.INSTANCE;     // Catch: Throwable -> L10 Exception -> L347
        L324:
            if (r25 == null) goto L330;
            a49.a r51 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r51 == null) goto L330;
            i r52 = r51.b();     // Catch: Throwable -> L10 Exception -> L347
            if (r52 == null) goto L330;
            g49.d.d(r26, r12 + r52);     // Catch: Throwable -> L10 Exception -> L347
            r30.element = new j(r52.d(), r52.b(), r52.a(), r52.e(), r52.c());     // Catch: Throwable -> L10 Exception -> L347
            Unit r53 = Unit.INSTANCE;     // Catch: Throwable -> L10 Exception -> L347
        L330:
            DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).setValue(c.a((c) DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).getValue(), null, null, null, null, null, null, false, (a49.f) r27.element, (j) r30.element, false, 3327));     // Catch: Throwable -> L10 Exception -> L347
            DoraGDeviceManagementViewModel.access$setCurrentDiaryDisplayMode$p(this.this$0, r112);     // Catch: Throwable -> L10 Exception -> L347
            DoraGDeviceManagementViewModel r54 = this.this$0;     // Catch: Throwable -> L10 Exception -> L347
            if (r38 == false) goto L333;
            boolean r55 = true;
        L334:
            this.L$0 = null;     // Catch: Throwable -> L10 Exception -> L347
            this.label = 4;     // Catch: Throwable -> L10 Exception -> L347
            if (DoraGDeviceManagementViewModel.access$updateDiaryAndQuickNoteComponents(r54, false, r112, r55, this) != r7) goto L345;
            return r7;
        L333:
            r55 = false;
            goto L334
        L320:
            if (r11 == true) goto L324;
            IDoraGResourceService r56 = (IDoraGResourceService) ServiceManager.get().getService(IDoraGResourceService.class);     // Catch: Throwable -> L10 Exception -> L347
            if (r56 == null) goto L324;
            r56.k(r27.element);     // Catch: Throwable -> L10 Exception -> L347
            Unit r57 = Unit.INSTANCE;     // Catch: Throwable -> L10 Exception -> L347
            goto L324
        L300:
            r124 = false;
        L303:
            r211 = null;
            goto L304
        L293:
            r210 = null;
            goto L294
        L290:
            r123 = null;
            goto L291
        L287:
            r122 = null;
            goto L288
        L305:
            if (r16 != 0) goto L307;
            DiaryDisplayMode r58 = DiaryDisplayMode.ENVIRONMENT_OFF;     // Catch: Throwable -> L10 Exception -> L347
            r27.element = new a49.f(null, null, null, null, 1007);     // Catch: Throwable -> L10 Exception -> L347
        L308:
            r112 = r58;
            r47 = true;
            r38 = false;
            goto L316
        L307:
            r58 = DiaryDisplayMode.NO_CONTENT;     // Catch: Throwable -> L10 Exception -> L347
            r27.element = new a49.f(null, null, null, null, 1007);     // Catch: Throwable -> L10 Exception -> L347
            goto L308
        L282:
            r121 = false;
            goto L283
        L278:
            r120 = false;
            goto L279
        L260:
            if (r114.length() == 0) goto L263;
            r115 = false;
        L274:
            r118 = false;
        L309:
            StringBuilder r60 = new StringBuilder("refreshLatestCardContent: diary beta fetch failed, show network error: ");     // Catch: Throwable -> L10 Exception -> L347
            if (r10 == null) goto L312;
            Throwable r61 = Result.exceptionOrNull-impl(r10.unbox-impl());     // Catch: Throwable -> L10 Exception -> L347
        L313:
            r60.append(r61);     // Catch: Throwable -> L10 Exception -> L347
            g49.d.e(r26, r60.toString());     // Catch: Throwable -> L10 Exception -> L347
            DiaryDisplayMode r62 = DiaryDisplayMode.NETWORK_ERROR;     // Catch: Throwable -> L10 Exception -> L347
            r27.element = null;     // Catch: Throwable -> L10 Exception -> L347
            r46 = r62;
            r43 = null;
            r47 = false;
            goto L314
        L312:
            r61 = null;
        L252:
            r113 = false;
            goto L253
        L246:
            r41 = null;
            goto L247
        L315:
            r43 = null;
            r47 = false;
            goto L316
        L94:
            if (r36 == false) goto L114;
            if (r25 == null) goto L113;
            a49.a r63 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r63 == null) goto L113;
            a49.e r64 = r63.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r64 == null) goto L113;
            g49.d.d(r26, "refreshLatestCardContent: diary=" + r64);     // Catch: Throwable -> L10 Exception -> L347
            Long r125 = r64.f();     // Catch: Throwable -> L10 Exception -> L347
            if (r125 == null) goto L103;
            String r310 = r125.toString();     // Catch: Throwable -> L10 Exception -> L347
        L104:
            String r311 = r64.i();     // Catch: Throwable -> L10 Exception -> L347
            String r312 = r64.d();     // Catch: Throwable -> L10 Exception -> L347
            String r313 = r64.g();     // Catch: Throwable -> L10 Exception -> L347
            String r314 = r64.b();     // Catch: Throwable -> L10 Exception -> L347
            Long r315 = r64.c();     // Catch: Throwable -> L10 Exception -> L347
            a49.g r126 = r64.e();     // Catch: Throwable -> L10 Exception -> L347
            if (r126 == null) goto L107;
            String r316 = r126.a();     // Catch: Throwable -> L10 Exception -> L347
        L108:
            a49.g r127 = r64.e();     // Catch: Throwable -> L10 Exception -> L347
            if (r127 == null) goto L111;
            String r317 = r127.b();     // Catch: Throwable -> L10 Exception -> L347
        L112:
            r27.element = new a49.f(r310, r311, r312, r313, r314, null, r315, r316, r317, null, r64.h());     // Catch: Throwable -> L10 Exception -> L347
            Unit r65 = Unit.INSTANCE;     // Catch: Throwable -> L10 Exception -> L347
            goto L113
        L111:
            r317 = null;
            goto L112
        L107:
            r316 = null;
            goto L108
        L103:
            r310 = null;
            goto L104
        L114:
            if (r16 != 0) goto L173;
            DiaryDisplayMode r66 = DiaryDisplayMode.ENVIRONMENT_OFF;     // Catch: Throwable -> L10 Exception -> L347
            if (r25 == null) goto L124;
            a49.a r128 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r128 == null) goto L124;
            a49.e r129 = r128.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r129 == null) goto L124;
            Long r130 = r129.f();     // Catch: Throwable -> L10 Exception -> L347
            if (r130 == null) goto L124;
            String r318 = r130.toString();     // Catch: Throwable -> L10 Exception -> L347
        L125:
            if (r25 == null) goto L131;
            a49.a r131 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r131 == null) goto L131;
            a49.e r132 = r131.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r132 == null) goto L131;
            String r319 = r132.i();     // Catch: Throwable -> L10 Exception -> L347
        L132:
            if (r25 == null) goto L138;
            a49.a r133 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r133 == null) goto L138;
            a49.e r134 = r133.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r134 == null) goto L138;
            String r320 = r134.d();     // Catch: Throwable -> L10 Exception -> L347
        L139:
            if (r25 == null) goto L145;
            a49.a r135 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r135 == null) goto L145;
            a49.e r136 = r135.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r136 == null) goto L145;
            String r321 = r136.g();     // Catch: Throwable -> L10 Exception -> L347
        L147:
            if (r25 == null) goto L153;
            a49.a r137 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r137 == null) goto L153;
            a49.e r138 = r137.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r138 == null) goto L153;
            Long r322 = r138.c();     // Catch: Throwable -> L10 Exception -> L347
        L154:
            if (r25 == null) goto L162;
            a49.a r139 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r139 == null) goto L162;
            a49.e r140 = r139.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r140 == null) goto L162;
            a49.g r141 = r140.e();     // Catch: Throwable -> L10 Exception -> L347
            if (r141 == null) goto L162;
            String r323 = r141.a();     // Catch: Throwable -> L10 Exception -> L347
        L163:
            if (r25 == null) goto L171;
            a49.a r142 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r142 == null) goto L171;
            a49.e r143 = r142.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r143 == null) goto L171;
            a49.g r144 = r143.e();     // Catch: Throwable -> L10 Exception -> L347
            if (r144 == null) goto L171;
            String r324 = r144.b();     // Catch: Throwable -> L10 Exception -> L347
        L172:
            r27.element = new a49.f(r318, r319, r320, r321, null, null, r322, r323, r324, null, null);     // Catch: Throwable -> L10 Exception -> L347
            Unit r145 = Unit.INSTANCE;     // Catch: Throwable -> L10 Exception -> L347
        L239:
            r112 = r66;
            r38 = false;
        L171:
            r324 = null;
        L162:
            r323 = null;
        L153:
            r322 = null;
        L145:
            r321 = null;
        L138:
            r320 = null;
        L131:
            r319 = null;
        L124:
            r318 = null;
            goto L125
        L173:
            r66 = DiaryDisplayMode.NO_CONTENT;     // Catch: Throwable -> L10 Exception -> L347
            if (r25 == null) goto L182;
            a49.a r146 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r146 == null) goto L182;
            a49.e r147 = r146.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r147 == null) goto L182;
            Long r148 = r147.f();     // Catch: Throwable -> L10 Exception -> L347
            if (r148 == null) goto L182;
            String r325 = r148.toString();     // Catch: Throwable -> L10 Exception -> L347
        L183:
            if (r25 == null) goto L190;
            a49.a r149 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r149 == null) goto L190;
            a49.e r150 = r149.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r150 == null) goto L190;
            String r151 = r150.d();     // Catch: Throwable -> L10 Exception -> L347
            if (r151 == null) goto L190;
        L196:
            String r326 = r151;
        L198:
            if (r25 == null) goto L204;
            a49.a r152 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r152 == null) goto L204;
            a49.e r153 = r152.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r153 == null) goto L204;
            String r327 = r153.d();     // Catch: Throwable -> L10 Exception -> L347
        L205:
            if (r25 == null) goto L211;
            a49.a r154 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r154 == null) goto L211;
            a49.e r155 = r154.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r155 == null) goto L211;
            String r328 = r155.g();     // Catch: Throwable -> L10 Exception -> L347
        L213:
            if (r25 == null) goto L219;
            a49.a r156 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r156 == null) goto L219;
            a49.e r157 = r156.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r157 == null) goto L219;
            Long r329 = r157.c();     // Catch: Throwable -> L10 Exception -> L347
        L220:
            if (r25 == null) goto L228;
            a49.a r158 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r158 == null) goto L228;
            a49.e r159 = r158.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r159 == null) goto L228;
            a49.g r160 = r159.e();     // Catch: Throwable -> L10 Exception -> L347
            if (r160 == null) goto L228;
            String r330 = r160.a();     // Catch: Throwable -> L10 Exception -> L347
        L229:
            if (r25 == null) goto L237;
            a49.a r161 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r161 == null) goto L237;
            a49.e r162 = r161.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r162 == null) goto L237;
            a49.g r163 = r162.e();     // Catch: Throwable -> L10 Exception -> L347
            if (r163 == null) goto L237;
            String r331 = r163.b();     // Catch: Throwable -> L10 Exception -> L347
        L238:
            r27.element = new a49.f(r325, r326, r327, r328, null, null, r329, r330, r331, null, null);     // Catch: Throwable -> L10 Exception -> L347
            Unit r164 = Unit.INSTANCE;     // Catch: Throwable -> L10 Exception -> L347
        L237:
            r331 = null;
        L228:
            r330 = null;
        L219:
            r329 = null;
        L211:
            r328 = null;
        L204:
            r327 = null;
        L190:
            if (r25 == null) goto L197;
            a49.a r165 = r25.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r165 == null) goto L197;
            a49.e r166 = r165.a();     // Catch: Throwable -> L10 Exception -> L347
            if (r166 == null) goto L197;
            r151 = r166.i();     // Catch: Throwable -> L10 Exception -> L347
        L197:
            r326 = null;
        L182:
            r325 = null;
            goto L183
        L77:
            if (r110.length() == 0) goto L80;
            r111 = false;
        L91:
            r36 = false;
        L349:
            e = e;
            r15 = r28;
        L348:
            Exception r67 = e;
            ?? r68 = r15;
        L355:
            g49.d.c(r68, "refreshLatestCardContent: exception", r67);     // Catch: Throwable -> L10
            DoraGDeviceManagementViewModel r70 = this.this$0;     // Catch: Throwable -> L10
            DiaryDisplayMode r71 = DiaryDisplayMode.NETWORK_ERROR;     // Catch: Throwable -> L10
            DoraGDeviceManagementViewModel.access$setCurrentDiaryDisplayMode$p(r70, r71);     // Catch: Throwable -> L10
            DoraGDeviceManagementViewModel r72 = this.this$0;     // Catch: Throwable -> L10
            this.L$0 = null;     // Catch: Throwable -> L10
            this.label = 6;     // Catch: Throwable -> L10
            if (DoraGDeviceManagementViewModel.access$updateDiaryAndQuickNoteComponents(r72, false, r71, false, this) != r7) goto L359;
            return r7;
        L347:
            e = e;
        L57:
            e = move-exception;
            r67 = e;
            r68 = r28;
            goto L355
        L17:
            boolean r73 = this.Z$0;
            int r74 = this.I$0;
            Deferred r75 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r42);     // Catch: Throwable -> L10 Exception -> L12
            r28 = DoraGDeviceManagementViewModel.TAG;
            r9 = "refreshLatestCardContent: failed ";
            r11 = r73;
            ?? r167 = r74;
            r7 = r8;
            Object r76 = r42;
        L49:
            Result r77 = (Result) r76;     // Catch: Throwable -> L10 Exception -> L349
            if (r75 == null) goto L59;
            this.L$0 = r77;     // Catch: Throwable -> L10 Exception -> L57
            this.I$0 = r167 == true ? 1 : 0;     // Catch: Throwable -> L10 Exception -> L57
            this.Z$0 = r11;     // Catch: Throwable -> L10 Exception -> L57
            this.label = 3;     // Catch: Throwable -> L10 Exception -> L57
            r6 = r75.await(this);     // Catch: Throwable -> L10 Exception -> L57
            if (r6 != r7) goto L54;
            return r7;
        L54:
            r5 = r77;
            r1 = r11;
            r13 = r167;
            goto L55
        L59:
            r10 = null;
            r14 = r77;
            r15 = r4;
            r16 = r167;
            goto L372
        L20:
            CoroutineScope r78 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r42);     // Catch: Throwable -> L10 Exception -> L12
            r28 = DoraGDeviceManagementViewModel.TAG;
            r7 = r8;
        L370:
            IDoraPageConfig r80 = (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);     // Catch: Throwable -> L10 Exception -> L349
            if (r80 != null) goto L375;
            boolean r81 = false;
        L40:
            boolean r82 = DoraGDeviceManagementViewModel.access$isDiaryBetaEnabled(this.this$0);     // Catch: Throwable -> L10 Exception -> L349
            CoroutineDispatcher r83 = Dispatchers.getIO();     // Catch: Throwable -> L10 Exception -> L349
            r11 = r82;
            boolean r168 = r81;
            Deferred r84 = BuildersKt.async$default(r78, r83, null, new DoraGDeviceManagementViewModel$refreshLatestCardContent$1$legacyDeferred$1(this.this$0, r82, null), 2, null);     // Catch: Throwable -> L10 Exception -> L349
            if (r11 == false) goto L44;
            CoroutineDispatcher r85 = Dispatchers.getIO();     // Catch: Throwable -> L10 Exception -> L57
            Deferred r86 = BuildersKt.async$default(r78, r85, null, new DoraGDeviceManagementViewModel$refreshLatestCardContent$1$betaDeferred$1(null), 2, null);     // Catch: Throwable -> L10 Exception -> L57
            CoroutineDispatcher r87 = r85;
        L45:
            this.L$0 = r86;     // Catch: Throwable -> L10 Exception -> L349
            this.I$0 = r168 ? 1 : 0;     // Catch: Throwable -> L10 Exception -> L349
            this.Z$0 = r11;     // Catch: Throwable -> L10 Exception -> L349
            this.label = 2;     // Catch: Throwable -> L10 Exception -> L349
            r76 = r84.await(this);     // Catch: Throwable -> L10 Exception -> L349
            if (r76 != r7) goto L48;
            return r7;
        L48:
            r75 = r86;
            r4 = r87;
            r167 = r168;
            goto L49
        L44:
            r86 = null;
            r87 = r83;
            goto L45
        L375:
            r81 = r80.d("dora_g_config_key_env_observe_enable", false);     // Catch: Throwable -> L10 Exception -> L57
            goto L40
        L24:
            ResultKt.throwOnFailure(r42);
            CoroutineScope r88 = (CoroutineScope) this.L$0;
            DoraGDeviceManagementViewModel.access$setRefreshingLatestCardContent$p(this.this$0, true);
            if (this.$showRefreshAnimation == false) goto L27;
            DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).setValue(c.a((c) DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).getValue(), null, null, null, null, null, null, true, null, null, false, 3967));
        L27:
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "refreshLatestCardContent: start, isFirstLoad=" + DoraGDeviceManagementViewModel.access$isFirstLoad$p(this.this$0) + ", refreshSodaBanner=" + this.$refreshSodaBanner);
            DoraGDeviceManagementViewModel r90 = this.this$0;     // Catch: Throwable -> L10 Exception -> L353
            boolean r91 = DoraGDeviceManagementViewModel.access$isFirstLoad$p(r90);     // Catch: Throwable -> L10 Exception -> L353
            boolean r92 = this.$refreshSodaBanner;     // Catch: Throwable -> L10 Exception -> L353
            this.L$0 = r88;     // Catch: Throwable -> L10 Exception -> L353
            this.label = 1;     // Catch: Throwable -> L10 Exception -> L353
            r28 = DoraGDeviceManagementViewModel.TAG;
            Object r93 = DoraGDeviceManagementViewModel.updateDeviceStatusWithCurrentContent$default(r90, r91, null, false, false, r92, this, 14, null);     // Catch: Throwable -> L10 Exception -> L351
            r7 = r8;
            if (r93 != r7) goto L34;
            return r7;
        L34:
            r78 = r88;
        L351:
            e = e;
            r15 = r28;
            r7 = r8;
        L353:
            e = e;
            r15 = DoraGDeviceManagementViewModel.TAG;
            r7 = r8;
            goto L348
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            th = move-exception;
            if (this.$showRefreshAnimation == false) goto L366;
            DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).setValue(c.a((c) DoraGDeviceManagementViewModel.access$get_uiState$p(this.this$0).getValue(), null, null, null, null, null, null, false, null, null, false, 3967));
        L366:
            DoraGDeviceManagementViewModel.access$setRefreshingLatestCardContent$p(this.this$0, false);
            throw th;
        L12:
            e = move-exception;
            r67 = e;
            r68 = DoraGDeviceManagementViewModel.TAG;
            r7 = r8;
            goto L355
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$replaceBind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$replaceBind$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1910, 1914}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        int label;

        public C02401(DoraDevice r1, Continuation<? super C02401> r2) {
            this.$device = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02401(this.$device, r3);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r9);
        L21:
            Object r10 = r2;
        L23:
            Throwable r11 = Result.exceptionOrNull-impl(r10);
            if (r11 == null) goto L27;
            g49.d.c(DoraGDeviceManagementViewModel.TAG, "replaceBind: failure exception", r11);
            s r12 = s.a;
            Application r3 = AppHost.a.getApplication();
            r12.getClass();
            s.b(r3, 2131908080, false);
        L27:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
            r10 = ((Result) r9).unbox-impl();
        L14:
            if (Result.isSuccess-impl(r10) == false) goto L23;
            int r4 = ((Number) r10).intValue();
            g49.d.d(DoraGDeviceManagementViewModel.TAG, "replaceBind: replaceBindCode=" + r4);
            if (r4 != 1) goto L22;
            kj4.a r5 = kj4.a.g();
            this.L$0 = r10;
            this.label = 2;
            if (DoraAdapterExtKt.b(r5) != r0) goto L20;
            return r0;
        L20:
            r2 = r10;
            goto L21
        L22:
            g49.d.b(DoraGDeviceManagementViewModel.TAG, "replaceBind: failure replaceBindCode:" + r4);
            s r6 = s.a;
            Application r7 = AppHost.a.getApplication();
            r6.getClass();
            s.b(r7, 2131904024, false);
            Unit r8 = Unit.INSTANCE;
            goto L23
        L10:
            ResultKt.throwOnFailure(r9);
            DoraNetworkApi r13 = DoraNetworkApi.a;
            DoraDevice r14 = this.$device;
            this.label = 1;
            r10 = r13.w(r14, this);
            if (r10 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$scanBleInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {0, 0, 0}, l = {1902}, m = "scanBleInfo", n = {"newDevice", "scanCallback", "startScanTs"}, s = {"L$0", "L$1", "J$0"})
    public static final class C02411 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02411(DoraGDeviceManagementViewModel r1, Continuation<? super C02411> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return DoraGDeviceManagementViewModel.access$scanBleInfo(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$scanBleInfo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$scanBleInfo$2", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1902}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02422 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $done;
        int label;

        public C02422(CompletableDeferred<Unit> r1, Continuation<? super C02422> r2) {
            this.$done = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02422(this.$done, r3);
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

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$switchToDevice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$switchToDevice$1", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {889, 894}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        int label;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02431(DoraGDeviceManagementViewModel r1, String r2, Continuation<? super C02431> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02431(this.this$0, this.$mac, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Object r2 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L23:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L13:
            DoraGDeviceManagementViewModel r3 = this.this$0;
            List r9 = DoraGDeviceManagementViewModel.access$sortDeviceList(r3, (List) r8);
            String r4 = this.$mac;
            Iterator r10 = r9.iterator();
        L15:
            if (r10.hasNext() == false) goto L19;
            Object r5 = r10.next();
            if (Intrinsics.areEqual(((DoraDevice) r5).mac, r4) == false) goto L15;
            r2 = r5;
        L19:
            DoraGDeviceManagementViewModel r11 = this.this$0;
            this.label = 2;
            if (DoraGDeviceManagementViewModel.access$performDeviceSwitch(r11, (DoraDevice) r2, true, this) != r0) goto L23;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            CoroutineDispatcher r12 = Dispatchers.getIO();
            DoraGDeviceManagementViewModel$switchToDevice$1$rawBindList$1 r6 = new DoraGDeviceManagementViewModel$switchToDevice$1$rawBindList$1(null);
            this.label = 1;
            r8 = BuildersKt.withContext(r12, r6, this);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$updateDeviceStatusWithCurrentContent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {0, 0, 0, 0, 0}, l = {963}, m = "updateDeviceStatusWithCurrentContent", n = {"finalDiaryDisplayMode", "showDiaryLoading", "isDiaryClickable", "allowAutoSwitch", "refreshSodaBanner"}, s = {"L$0", "Z$0", "Z$1", "Z$2", "Z$3"})
    public static final class C02441 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        boolean Z$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02441(DoraGDeviceManagementViewModel r1, Continuation<? super C02441> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateDeviceStatusWithCurrentContent(false, null, false, false, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$updateDiaryAndQuickNoteComponents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {0, 0, 0, 0}, l = {1263, 1316}, m = "updateDiaryAndQuickNoteComponents", n = {"diaryDisplayMode", "currentItems", "showDiaryLoading", "isDiaryClickable"}, s = {"L$0", "L$1", "Z$0", "Z$1"})
    public static final class C02451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02451(DoraGDeviceManagementViewModel r1, Continuation<? super C02451> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return DoraGDeviceManagementViewModel.access$updateDiaryAndQuickNoteComponents(this.this$0, false, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$updateOnlyDeviceComponent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1222, 1250}, m = "updateOnlyDeviceComponent", n = {}, s = {})
    public static final class C02461 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02461(DoraGDeviceManagementViewModel r1, Continuation<? super C02461> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraGDeviceManagementViewModel.access$updateOnlyDeviceComponent(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$updateOnlyDeviceComponentWithoutSoda$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1175}, m = "updateOnlyDeviceComponentWithoutSoda", n = {}, s = {})
    public static final class C02471 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02471(DoraGDeviceManagementViewModel r1, Continuation<? super C02471> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraGDeviceManagementViewModel.access$updateOnlyDeviceComponentWithoutSoda(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$updateOnlySodaBanner$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {}, l = {1123}, m = "updateOnlySodaBanner", n = {}, s = {})
    public static final class C02481 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraGDeviceManagementViewModel this$0;

        public C02481(DoraGDeviceManagementViewModel r1, Continuation<? super C02481> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateOnlySodaBanner(this);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit Mo(DoraGDeviceManagementViewModel r0) {
        return settingsUpdateListener$lambda$0(r0);
    }

    public static /* synthetic */ int No(DoraGDeviceManagementViewModel r0, DoraDevice r1, DoraDevice r2) {
        return sortDeviceList$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ int yo(Function2 r0, Object r1, Object r2) {
        return sortDeviceList$lambda$31(r0, r1, r2);
    }

    private final IDoraAVLinkService currentAvLinkService() {
        IDoraAVLinkService r0 = this.registeredAvLinkService;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
    }

    private final boolean isDiaryBetaEnabled() {
        e10 r0 = e10.a;
        if (e10.K0().length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final String readHealthAgentWebUrl() {
        DoraSetting.a.getClass();     // Catch: Exception -> L5
        return StringsKt.trim((String) l0.a("", new v())).toString();
    L5:
        e = move-exception;
        g49.d.c(TAG, "readHealthAgentWebUrl: failed", e);
        return "";
    }

    private final void registerAvLinkListeners() {
        if (this.registeredAvLinkService == null) goto L5;
        return;
    L5:
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 != null) goto L9;
        g49.d.e(TAG, "AVLink service unavailable, skip state listeners");
        return;
    L9:
        this.registeredAvLinkService = r0;
        r0.S0(this.sceneStateListener);
    }

    private final void unregisterAvLinkListeners() {
        IDoraAVLinkService r0 = this.registeredAvLinkService;
        if (r0 == null) goto L5;
        r0.v0(this.sceneStateListener);
    L5:
        this.registeredAvLinkService = null;
    }

    private final void updateHealthComponentFromSettings() {
        String r1 = readHealthAgentWebUrl();
        p0 r2 = (p0) CollectionsKt.firstOrNull(buildHealthComponent(r1));
        List r10 = CollectionsKt.toMutableList(((c) this._uiState.getValue()).g);
        Iterator r3 = r10.iterator();
        int r4 = 0;
    L3:
        int r6 = -1;
        if (r3.hasNext() == false) goto L9;
        if ((((p0) r3.next()) instanceof o0) == true) goto L10;
        r4 = r4 + 1;
    L10:
        if (r4 < 0) goto L13;
        ListProtector.remove(r10, r4);
    L13:
        if (r2 == null) goto L35;
        Iterator r5 = r10.iterator();
        int r7 = 0;
    L16:
        if (r5.hasNext() == false) goto L21;
        if ((((p0) r5.next()) instanceof com.larus.dora.impl.device.manage.d) == true) goto L22;
        r7 = r7 + 1;
    L22:
        Iterator r8 = r10.iterator();
        int r9 = 0;
    L24:
        if (r8.hasNext() == false) goto L29;
        if ((((p0) r8.next()) instanceof com.larus.dora.impl.device.manage.e) == true) goto L27;
        r9 = r9 + 1;
        goto L24
    L27:
        r6 = r9;
    L29:
        if (r7 < 0) goto L31;
        r6 = r7 + 1;
    L34:
        ListProtector.add(r10, RangesKt.coerceIn(r6, 0, r10.size()), r2);
        goto L35
    L31:
        if (r6 >= 0) goto L34;
        r6 = r10.size();
        goto L34
    L21:
        r7 = -1;
    L35:
        z0<c> r14 = this._uiState;
        r14.setValue(c.a((c) r14.getValue(), null, null, null, null, null, r10, false, null, null, false, 4031));
        StringBuilder r11 = new StringBuilder("updateHealthComponentFromSettings: visible=");
        if (r2 == null) goto L38;
        boolean r15 = true;
    L39:
        r11.append(r15);
        r11.append(", urlEmpty=");
        if (r1.length() != 0) goto L42;
        boolean r16 = true;
    L43:
        r11.append(r16);
        g49.d.d(TAG, r11.toString());
        return;
    L42:
        r16 = false;
        goto L43
    L38:
        r15 = false;
        goto L39
    L9:
        r4 = -1;
        goto L10
    }

    public final void load() {
        g49.d.d(TAG, "load start, isFirstLoad=" + this.isFirstLoad);
        registerAvLinkListeners();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02311(this, null), 3, null);
    }

    public final void onPageResume() {
        g49.d.d(TAG, "onPageResume, isFirstEnter=" + this.isFirstEnter);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02341(this, null), 3, null);
    }

    public final void onSodaBannerClosed() {
        g49.d.d(TAG, "onSodaBannerClosed");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02351(this, null), 3, null);
    }

    public final void resetFirstEnterFlag() {
        g49.d.d(TAG, "resetFirstEnterFlag");
        this.isFirstEnter = true;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$sceneStateListener$1] */
    public DoraGDeviceManagementViewModel() {
        PageState r1 = null;
        StateFlowImpl r0 = j1.a(new c(r1, null, null, null, null, null, false, false, 4095));
        this._uiState = r0;
        this.uiState = r0;
        MutableSharedFlow<com.larus.dora.impl.device.manage.viewmodel.a> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceIntentSharedFlow = r3;
        this.deviceIntentSharedFlow = r3;
        MutableSharedFlow<com.larus.dora.impl.network.a> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._sodaBannerSharedFlow = r2;
        this.sodaBannerSharedFlow = r2;
        this.deviceOrder = new ArrayList();
        this.debounceDelayMs = 300;
        this.isFirstLoad = true;
        this.isFirstEnter = true;
        this.currentDiaryDisplayMode = DiaryDisplayMode.NORMAL;
        Function0<Unit> r4 = new com.larus.dora.impl.device.manage.viewmodel.b(this);
        this.settingsUpdateListener = r4;
        this.sceneStateListener = new DoraGDeviceManagementViewModel$sceneStateListener$1(this);
        e r5 = new e(this);
        this.headphoneModeCallback = r5;
        IDoraLinkCallback r6 = new DoraGDeviceManagementViewModel$deviceStateCallback$1(this);
        this.deviceStateCallback = r6;
        mj4.h r7 = new DoraGDeviceManagementViewModel$batteryCallback$1(this);
        this.batteryCallback = r7;
        g49.d.d(TAG, "DoraGDeviceManagementViewModel.init, register deviceStateCallback at 0 index.");
        kj4.a.g().registerDoraLinkCallback(r6, true);
        kj4.a.g().k(r7);
        kj4.a.g().k(r5);
        registerAvLinkListeners();
        z2.a.i2(r4);
        initializeWithLoadingState();
        checkLastConnectedDeviceBindState();
    }

    private final void checkLastConnectedDeviceBindState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02221(this, null), 2, null);
    }

    private final void initializeWithLoadingState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02281(this, null), 3, null);
    }

    private final void onConnectRequestFailed() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02321(this, null), 3, null);
    }

    private final void refreshDeviceList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02381(this, null), 3, null);
    }

    private final DeviceMode resolveDeviceMode() {
        IDoraAVLinkService r0 = currentAvLinkService();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L28;
        if (r0 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L29;
        if (r0 != null) goto L19;
    L21:
        if (r1 == true) goto L30;
        t69.b r2 = t69.b.a;
        if (t69.b.c != 1) goto L27;
        return DeviceMode.EARPHONE;
    L27:
        return DeviceMode.NORMAL;
    L30:
        return DeviceMode.VIDEO_CALL;
    L19:
        if (r0.c1(1) != true) goto L21;
        r1 = true;
        goto L21
    L29:
        return DeviceMode.INTERPRET;
    L12:
        if (r0.c1(6) != true) goto L14;
        r4 = true;
        goto L15
    L28:
        return DeviceMode.RECORDING;
    L5:
        if (r0.c1(7) != true) goto L7;
        r3 = true;
        goto L8
    }

    public void onCleared() {
        super.onCleared();
        kj4.a.g().unregisterDoraLinkCallback(this.deviceStateCallback);
        kj4.a.g().E(this.batteryCallback);
        kj4.a.g().E(this.headphoneModeCallback);
        unregisterAvLinkListeners();
        z2.a.p3(this.settingsUpdateListener);
    }

    public final d1<com.larus.dora.impl.device.manage.viewmodel.a> getDeviceIntentSharedFlow() {
        return this.deviceIntentSharedFlow;
    }

    public final d1<com.larus.dora.impl.network.a> getSodaBannerSharedFlow() {
        return this.sodaBannerSharedFlow;
    }

    public final i1<c> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ Job access$getBatteryUpdateJob$p(DoraGDeviceManagementViewModel r0) {
        return r0.batteryUpdateJob;
    }

    public static final /* synthetic */ Job access$getChargeUpdateJob$p(DoraGDeviceManagementViewModel r0) {
        return r0.chargeUpdateJob;
    }

    public static final /* synthetic */ com.larus.dora.impl.device.manage.z0 access$getConnectRequestListener$p(DoraGDeviceManagementViewModel r0) {
        return r0.connectRequestListener;
    }

    public static final /* synthetic */ String access$getConnectingDeviceMac$p(DoraGDeviceManagementViewModel r0) {
        return r0.connectingDeviceMac;
    }

    public static final /* synthetic */ String access$getCurrentDeviceMac$p(DoraGDeviceManagementViewModel r0) {
        return r0.currentDeviceMac;
    }

    public static final /* synthetic */ DiaryDisplayMode access$getCurrentDiaryDisplayMode$p(DoraGDeviceManagementViewModel r0) {
        return r0.currentDiaryDisplayMode;
    }

    public static final /* synthetic */ long access$getDebounceDelayMs$p(DoraGDeviceManagementViewModel r2) {
        return r2.debounceDelayMs;
    }

    public static final /* synthetic */ List access$getDeviceOrder$p(DoraGDeviceManagementViewModel r0) {
        return r0.deviceOrder;
    }

    public static final /* synthetic */ a1 access$getDeviceSwitchListener$p(DoraGDeviceManagementViewModel r0) {
        return r0.deviceSwitchListener;
    }

    public static final /* synthetic */ int access$getLastKnownBindListSize$p(DoraGDeviceManagementViewModel r0) {
        return r0.lastKnownBindListSize;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_deviceIntentSharedFlow$p(DoraGDeviceManagementViewModel r0) {
        return r0._deviceIntentSharedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_sodaBannerSharedFlow$p(DoraGDeviceManagementViewModel r0) {
        return r0._sodaBannerSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_uiState$p(DoraGDeviceManagementViewModel r0) {
        return r0._uiState;
    }

    public static final /* synthetic */ boolean access$isDiaryBetaEnabled(DoraGDeviceManagementViewModel r0) {
        return r0.isDiaryBetaEnabled();
    }

    public static final /* synthetic */ boolean access$isFirstEnter$p(DoraGDeviceManagementViewModel r0) {
        return r0.isFirstEnter;
    }

    public static final /* synthetic */ boolean access$isFirstLoad$p(DoraGDeviceManagementViewModel r0) {
        return r0.isFirstLoad;
    }

    public static final /* synthetic */ void access$onConnectRequestFailed(DoraGDeviceManagementViewModel r0) {
        r0.onConnectRequestFailed();
    }

    public static final /* synthetic */ String access$readHealthAgentWebUrl(DoraGDeviceManagementViewModel r0) {
        return r0.readHealthAgentWebUrl();
    }

    public static final /* synthetic */ void access$refreshDeviceList(DoraGDeviceManagementViewModel r0) {
        r0.refreshDeviceList();
    }

    public static final /* synthetic */ void access$updateHealthComponentFromSettings(DoraGDeviceManagementViewModel r0) {
        r0.updateHealthComponentFromSettings();
    }

    private final b buildDeviceComponentData(DoraDevice r20) {
        if (kj4.a.g().getDoraLinkState(r20) != 2) goto L5;
        boolean r2 = true;
    L6:
        int[] r6 = this.currentBatteryInfo;
        if (r6 != null) goto L9;
        r6 = o59.a.a(r20);
    L9:
        int[] r7 = this.currentChargeInfo;
        if (r7 != null) goto L12;
        r7 = o59.a.b(r20);
    L12:
        int r8 = -1;
        if (r2 == false) goto L20;
        if (r6 == null) goto L20;
        Integer r9 = ArraysKt.getOrNull(r6, 0);
        if (r9 == null) goto L18;
        int r10 = r9.intValue();
    L19:
        int r15 = r10;
    L21:
        if (r2 == false) goto L27;
        if (r6 == null) goto L27;
        Integer r11 = ArraysKt.getOrNull(r6, 2);
        if (r11 == null) goto L26;
        r8 = r11.intValue();
    L26:
        int r16 = r8;
    L28:
        if (r2 == false) goto L36;
        if (r7 == null) goto L36;
        Integer r12 = ArraysKt.getOrNull(r7, 0);
        if (r12 == null) goto L36;
        if (r12.intValue() != 1) goto L36;
        boolean r13 = true;
    L37:
        if (r2 == false) goto L45;
        if (r7 == null) goto L45;
        Integer r5 = ArraysKt.getOrNull(r7, 2);
        if (r5 == null) goto L45;
        if (r5.intValue() != 1) goto L45;
        boolean r14 = true;
    L46:
        if (r13 == true) goto L50;
        if (r14 == true) goto L50;
        boolean r17 = false;
    L51:
        if (r2 == false) goto L53;
    L55:
        boolean r18 = false;
    L56:
        DeviceMode r21 = resolveDeviceMode();
        return new b(new com.larus.dora.impl.device.manage.c(r20.name, r20.mac, r21, true, r2, r17, r13, r14, r15, r16, r18, 1), r2);
    L53:
        if (Intrinsics.areEqual(r20.mac, this.connectingDeviceMac) == false) goto L55;
        r18 = true;
    L50:
        r17 = true;
    L45:
        r14 = false;
    L36:
        r13 = false;
    L27:
        r16 = -1;
        goto L28
    L18:
        r10 = -1;
    L20:
        r15 = -1;
        goto L21
    L5:
        r2 = false;
        goto L6
    }

    private final g buildFirmwareUpdateItem(DoraDevice r8) {
        if (r8 == null) goto L5;
        Integer r1 = Integer.valueOf(kj4.a.g().getDoraLinkState(r8));
    L6:
        boolean r2 = false;
        if (r8 == null) goto L47;
        if (r1 == null) goto L47;
        if (r1.intValue() != 2) goto L47;
        com.larus.dora.impl.ota.b r3 = com.larus.dora.impl.ota.b.a;
        String r4 = com.larus.dora.impl.ota.b.a(r8);
        if (r4.length() <= 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L29;
        String r6 = r8.softVersion;
        if (r6 != null) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L29;
        if (Intrinsics.areEqual(r4, r8.softVersion) == true) goto L29;
        boolean r9 = true;
    L30:
        if (r9 == true) goto L42;
        StringBuilder r10 = new StringBuilder("buildFirmwareUpdateItem: hide card, shouldShow=false, hasOtaVersion=");
        if (r4.length() <= 0) goto L34;
        boolean r11 = true;
    L35:
        r10.append(r11);
        r10.append(", hasSoftVersion=");
        String r12 = r8.softVersion;
        if (r12 != null) goto L38;
    L39:
        r2 = true;
    L40:
        r10.append(!r2);
        g49.d.d(TAG, r10.toString());
        return null;
    L38:
        if (r12.length() != 0) goto L40;
    L34:
        r11 = false;
        goto L35
    L42:
        String r13 = formatFirmwareUpdateVersion(r4);
        StringBuilder r0 = new StringBuilder("buildFirmwareUpdateItem: show card, displayVersionEmpty=");
        if (r13.length() != 0) goto L45;
        r2 = true;
    L45:
        r0.append(r2);
        g49.d.d(TAG, r0.toString());
        return new g(r13, 11);
    L21:
        if (r6.length() == 0) goto L24;
        r7 = false;
    L29:
        r9 = false;
        goto L30
    L16:
        r5 = false;
    L47:
        StringBuilder r14 = new StringBuilder("buildFirmwareUpdateItem: hide card, hasSelectedDevice=");
        if (r8 == null) goto L50;
        r2 = true;
    L50:
        r14.append(r2);
        r14.append(", linkState=");
        r14.append(r1);
        g49.d.d(TAG, r14.toString());
        return null;
    L5:
        r1 = null;
        goto L6
    }

    private final List<p0> buildHealthComponent(String r2) {
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return CollectionsKt.listOf(new o0(r2));
    L9:
        return CollectionsKt.emptyList();
    L5:
        r0 = false;
        goto L6
    }

    private final List<p0> buildOtherComponents(boolean r6) {
        return CollectionsKt.listOf(new p0[]{new q0(true, 15), new t0(r6, 15), new u0(r6, 31), new com.larus.dora.impl.device.manage.f(0), new s0()});
    }

    private final List<p0> buildQuickNoteComponent(boolean r32) {
        if (r32 == false) goto L4;
        com.larus.dora.impl.device.manage.e r9 = new com.larus.dora.impl.device.manage.e(null, null, null, null, null, false, true, 511);
    L29:
        return CollectionsKt.listOf(r9);
    L4:
        j r1 = ((c) this._uiState.getValue()).j;
        if (r1 == null) goto L27;
        String r2 = r1.b;
        boolean r3 = true;
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L24;
        String r5 = r1.c;
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L24;
        r3 = false;
        goto L24
    L17:
        if (r5.length() == 0) goto L20;
        r6 = false;
    L24:
        if (r3 == false) goto L26;
        String r7 = r1.b;
        String r8 = r1.c;
        int r10 = j0.a;
        r9 = new com.larus.dora.impl.device.manage.e(r7, r8, j0.d(2131902657), r1.d, r1.e, false, false, 547);
        goto L29
    L26:
        r9 = new com.larus.dora.impl.device.manage.e(null, null, null, null, null, true, false, 767);
        goto L29
    L9:
        if (r2.length() == 0) goto L12;
        r4 = false;
        goto L13
    L27:
        r9 = new com.larus.dora.impl.device.manage.e(null, null, null, null, null, true, false, 767);
        goto L29
    }

    private final int findFirmwareUpdateInsertIndex(List<? extends p0> r4) {
        Iterator<? extends p0> r5 = r4.iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L9;
        if ((r5.next() instanceof com.larus.dora.impl.device.manage.c) == true) goto L10;
        r0 = r0 + 1;
    L10:
        if (r0 != (-1)) goto L12;
        return -1;
    L12:
        return r0 + 1;
    L9:
        r0 = -1;
        goto L10
    }

    private final String formatFirmwareUpdateVersion(String r4) {
        if (r4 == null) goto L4;
        String r5 = StringsKt.trim(r4).toString();
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (r5.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        return "";
    L15:
        if (StringsKt.startsWith(r5, "v", true) == false) goto L18;
        return r5;
    L18:
        return "v".concat(r5);
    L11:
        r1 = false;
        goto L12
    L4:
        r5 = null;
        goto L6
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

    private final void moveDeviceToFront(String r3) {
        this.deviceOrder.remove(r3);
        ListProtector.add(this.deviceOrder, 0, r3);
    }

    private static final Unit settingsUpdateListener$lambda$0(DoraGDeviceManagementViewModel r8) {
        g49.d.d(TAG, "settingsUpdateListener");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(r8), null, null, new DoraGDeviceManagementViewModel$settingsUpdateListener$1$1(r8, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.impl.device.manage.viewmodel.c] */
    private final List<DoraDevice> sortDeviceList(List<? extends DoraDevice> r3) {
        final ?? r0 = new com.larus.dora.impl.device.manage.viewmodel.c(this);
        return CollectionsKt.sortedWith(r3, new com.larus.dora.impl.device.manage.viewmodel.d(r0));
    }

    private final Object updateOnlyDeviceComponent(Continuation<? super Unit> r24) {
        if ((r24 instanceof C02461) == false) goto L7;
        C02461 r1 = (C02461) r24;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        C02461 r6 = r1;
        Object r0 = r6.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        String r4 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L49:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
    L19:
        List r5 = (List) r0;
        Iterator r7 = r5.iterator();
    L21:
        if (r7.hasNext() == false) goto L25;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((DoraDevice) r8).mac, this.currentDeviceMac) == false) goto L21;
    L26:
        DoraDevice r9 = (DoraDevice) r8;
        if (r9 != null) goto L29;
        r9 = (DoraDevice) CollectionsKt.firstOrNull(r5);
    L29:
        if (r9 == null) goto L31;
        List r11 = CollectionsKt.toMutableList(((c) this._uiState.getValue()).g);
        com.larus.dora.impl.device.manage.c r12 = buildDeviceComponentData(r9).a;
        if ((true ^ r11.isEmpty()) == true) goto L35;
    L45:
        g49.d.e(TAG, "updateOnlyDeviceComponent: device component not found, falling back to full update");
        r6.label = 2;
        if (updateDeviceStatusWithCurrentContent$default(this, false, null, false, false, false, r6, 31, null) != r10) goto L49;
        return r10;
    L35:
        if ((ListProtector.get(r11, 0) instanceof com.larus.dora.impl.device.manage.c) == false) goto L45;
        ListProtector.set(r11, 0, r12);
        z0<c> r13 = this._uiState;
        r13.setValue(c.a((c) r13.getValue(), null, null, null, null, null, r11, false, null, null, false, 4031));
        StringBuilder r14 = new StringBuilder("updateOnlyDeviceComponent: only device component updated, battery=");
        int[] r15 = this.currentBatteryInfo;
        if (r15 == null) goto L39;
        String r16 = Arrays.toString(r15);
    L40:
        r14.append(r16);
        r14.append(", charge=");
        int[] r17 = this.currentChargeInfo;
        if (r17 == null) goto L43;
        r4 = Arrays.toString(r17);
    L43:
        r14.append(r4);
        g49.d.d(TAG, r14.toString());
        return Unit.INSTANCE;
    L39:
        r16 = null;
        goto L40
    L31:
        return Unit.INSTANCE;
    L25:
        r8 = null;
        goto L26
    L16:
        ResultKt.throwOnFailure(r0);
        CoroutineDispatcher r18 = Dispatchers.getIO();
        DoraGDeviceManagementViewModel$updateOnlyDeviceComponent$rawBindList$1 r20 = new DoraGDeviceManagementViewModel$updateOnlyDeviceComponent$rawBindList$1(null);
        r6.label = 1;
        r0 = BuildersKt.withContext(r18, r20, r6);
        if (r0 != r10) goto L19;
        return r10;
    L7:
        r1 = new C02461(this, r24);
        goto L8
    }

    private final Object updateOnlyDeviceComponentWithoutSoda(Continuation<? super Unit> r20) {
        if ((r20 instanceof C02471) == false) goto L7;
        C02471 r2 = (C02471) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        Object r6 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L17:
        List<? extends DoraDevice> r7 = (List) r1;
        List<DoraDevice> r8 = sortDeviceList(r7);
        List<DoraDevice> r9 = r8;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L24;
        String r11 = ((DoraDevice) r10.next()).name;
        if (r11 != null) goto L23;
        r11 = "Unknown Device";
    L23:
        r12.add(r11);
        goto L19
    L24:
        Iterator<T> r13 = r9.iterator();
    L26:
        if (r13.hasNext() == false) goto L30;
        Object r14 = r13.next();
        if (Intrinsics.areEqual(((DoraDevice) r14).mac, this.currentDeviceMac) == false) goto L26;
        r6 = r14;
    L30:
        DoraDevice r15 = (DoraDevice) r6;
        if (r15 != null) goto L33;
        DoraDevice r16 = (DoraDevice) CollectionsKt.firstOrNull(r7);
    L34:
        if (r16 == null) goto L36;
        List r17 = CollectionsKt.toMutableList(((c) this._uiState.getValue()).g);
        com.larus.dora.impl.device.manage.c r18 = buildDeviceComponentData(r16).a;
        int r21 = r17.size();
        int r22 = 0;
    L38:
        if (r22 >= r21) goto L43;
        if ((ListProtector.get(r17, r22) instanceof com.larus.dora.impl.device.manage.c) == true) goto L41;
        r22 = r22 + 1;
        goto L38
    L41:
        ListProtector.set(r17, r22, r18);
        boolean r23 = true;
    L44:
        if (r23 == true) goto L46;
        ListProtector.add(r17, 0, r18);
    L46:
        z0<c> r24 = this._uiState;
        c r25 = (c) r24.getValue();
        String r26 = r16.name;
        if (r26 != null) goto L49;
        String r110 = "";
    L50:
        String r27 = r16.mac;
        if (r27 != null) goto L53;
        String r111 = "";
    L54:
        r24.setValue(c.a(r25, null, r16, r110, r111, r12, r17, false, null, null, !r8.isEmpty(), 2961));
        g49.d.d(TAG, "updateOnlyDeviceComponentWithoutSoda: only device component updated");
        return Unit.INSTANCE;
    L53:
        r111 = r27;
        goto L54
    L49:
        r110 = r26;
        goto L50
    L43:
        r23 = false;
        goto L44
    L36:
        return Unit.INSTANCE;
    L33:
        r16 = r15;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        CoroutineDispatcher r28 = Dispatchers.getIO();
        DoraGDeviceManagementViewModel$updateOnlyDeviceComponentWithoutSoda$rawBindList$1 r30 = new DoraGDeviceManagementViewModel$updateOnlyDeviceComponentWithoutSoda$rawBindList$1(null);
        r2.label = 1;
        r1 = BuildersKt.withContext(r28, r30, r2);
        if (r1 != r4) goto L17;
        return r4;
    L7:
        r2 = new C02471(this, r20);
        goto L8
    }

    public final void checkBindState(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02211(r8, this, null), 2, null);
    }

    public final void checkSodaBanner(List<com.larus.dora.impl.network.a> r11) {
        if (r11 != null) goto L6;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02231(this, null), 3, null);
        return;
    L6:
        Iterator<com.larus.dora.impl.network.a> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        com.larus.dora.impl.network.a r1 = r12.next();
        if (r1 == null) goto L8;
        if (r1.getType() != 1) goto L8;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(r1, this, null), 3, null);
        goto L8
    }

    public final void connectAsync(DoraDevice r9) {
        g49.d.d(TAG, "connectAsync: device:" + r9);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02241(r9, this, null), 2, null);
    }

    public final void handleConnectRequest(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.connectingDeviceMac = r10;
        Job r0 = this.connectingJob;
        if (r0 == null) goto L7;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L7:
        this.connectingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02251(this, r10, null), 3, null);
    }

    public final void onDeviceSelected(String r9) {
        Intrinsics.checkNotNullParameter(r9, "option");
        g49.d.d(TAG, "onDeviceSelected option=" + r9);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02331(this, r9, null), 3, null);
    }

    public final void replaceBind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02401(r8, null), 2, null);
    }

    public final void setInitialDeviceMac(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        if (this.currentDeviceMac != null) goto L14;
        g49.d.d(TAG, "setInitialDeviceMac");
        this.currentDeviceMac = r3;
        return;
    L14:
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void setOnConnectRequestListener(com.larus.dora.impl.device.manage.z0 r1) {
        this.connectRequestListener = r1;
    }

    public final void setOnDeviceSwitchListener(a1 r1) {
        this.deviceSwitchListener = r1;
    }

    public final void switchToDevice(String r8) {
        Intrinsics.checkNotNullParameter(r8, "mac");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02431(this, r8, null), 3, null);
    }

    public final Object updateOnlySodaBanner(Continuation<? super Unit> r110) {
        if ((r110 instanceof C02481) == false) goto L7;
        C02481 r2 = (C02481) r110;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        Object r6 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L17:
        List r7 = (List) r1;
        Iterator r8 = r7.iterator();
    L19:
        if (r8.hasNext() == false) goto L23;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((DoraDevice) r9).mac, this.currentDeviceMac) == false) goto L19;
        r6 = r9;
    L23:
        DoraDevice r10 = (DoraDevice) r6;
        if (r10 != null) goto L26;
        r10 = (DoraDevice) CollectionsKt.firstOrNull(r7);
    L26:
        int r11 = 0;
        if (r10 != null) goto L29;
    L31:
        boolean r12 = false;
    L32:
        List r13 = CollectionsKt.toMutableList(((c) this._uiState.getValue()).g);
        String r14 = ILoginService.a.getAccountInfo().c;
        b0.a.getClass();
        if (b0.f(r14) == false) goto L36;
        if (r12 == false) goto L36;
        boolean r15 = true;
    L37:
        int r16 = r13.size();
        int r17 = 0;
    L39:
        if (r17 >= r16) goto L44;
        if ((ListProtector.get(r13, r17) instanceof b1) == true) goto L45;
        r17 = r17 + 1;
    L45:
        if (r15 == false) goto L72;
        List r18 = r13;
        if ((r18 instanceof Collection) == true) goto L49;
    L51:
        Iterator r20 = r18.iterator();
    L53:
        if (r20.hasNext() == false) goto L57;
        if ((((p0) r20.next()) instanceof g) == false) goto L53;
        boolean r21 = true;
    L58:
        b1 r22 = new b1(true, r21, 15);
        if (r17 == (-1)) goto L61;
        ListProtector.set(r13, r17, r22);
    L74:
        z0<c> r23 = this._uiState;
        r23.setValue(c.a((c) r23.getValue(), null, null, null, null, null, r13, false, null, null, false, 4031));
        g49.d.d(TAG, "updateOnlySodaBanner: only soda banner updated");
        return Unit.INSTANCE;
    L61:
        Iterator r24 = r13.iterator();
        int r25 = 0;
    L63:
        if (r24.hasNext() == false) goto L68;
        if ((((p0) r24.next()) instanceof com.larus.dora.impl.device.manage.d) == true) goto L69;
        r25 = r25 + 1;
    L69:
        if (r25 == (-1)) goto L71;
        r11 = r25;
    L71:
        ListProtector.add(r13, r11, r22);
        goto L74
    L68:
        r25 = -1;
    L57:
        r21 = false;
        goto L58
    L49:
        if (r18.isEmpty() == false) goto L51;
    L72:
        if (r17 == (-1)) goto L74;
        ListProtector.remove(r13, r17);
        goto L74
    L44:
        r17 = -1;
    L36:
        r15 = false;
        goto L37
    L29:
        if (kj4.a.g().getDoraLinkState(r10) != 2) goto L31;
        r12 = true;
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        CoroutineDispatcher r26 = Dispatchers.getIO();
        DoraGDeviceManagementViewModel$updateOnlySodaBanner$rawBindList$1 r27 = new DoraGDeviceManagementViewModel$updateOnlySodaBanner$rawBindList$1(null);
        r2.label = 1;
        r1 = BuildersKt.withContext(r26, r27, r2);
        if (r1 != r4) goto L17;
        return r4;
    L7:
        r2 = new C02481(this, r110);
        goto L8
    }

    public static final /* synthetic */ b access$buildDeviceComponentData(DoraGDeviceManagementViewModel r0, DoraDevice r1) {
        return r0.buildDeviceComponentData(r1);
    }

    public static final /* synthetic */ g access$buildFirmwareUpdateItem(DoraGDeviceManagementViewModel r0, DoraDevice r1) {
        return r0.buildFirmwareUpdateItem(r1);
    }

    public static final /* synthetic */ List access$buildHealthComponent(DoraGDeviceManagementViewModel r0, String r1) {
        return r0.buildHealthComponent(r1);
    }

    public static final /* synthetic */ void access$moveDeviceToFront(DoraGDeviceManagementViewModel r0, String r1) {
        r0.moveDeviceToFront(r1);
    }

    public static final /* synthetic */ void access$setBatteryUpdateJob$p(DoraGDeviceManagementViewModel r0, Job r1) {
        r0.batteryUpdateJob = r1;
    }

    public static final /* synthetic */ void access$setChargeUpdateJob$p(DoraGDeviceManagementViewModel r0, Job r1) {
        r0.chargeUpdateJob = r1;
    }

    public static final /* synthetic */ void access$setConnectingDeviceMac$p(DoraGDeviceManagementViewModel r0, String r1) {
        r0.connectingDeviceMac = r1;
    }

    public static final /* synthetic */ void access$setCurrentBatteryInfo$p(DoraGDeviceManagementViewModel r0, int[] r1) {
        r0.currentBatteryInfo = r1;
    }

    public static final /* synthetic */ void access$setCurrentChargeInfo$p(DoraGDeviceManagementViewModel r0, int[] r1) {
        r0.currentChargeInfo = r1;
    }

    public static final /* synthetic */ void access$setCurrentDeviceMac$p(DoraGDeviceManagementViewModel r0, String r1) {
        r0.currentDeviceMac = r1;
    }

    public static final /* synthetic */ void access$setCurrentDiaryDisplayMode$p(DoraGDeviceManagementViewModel r0, DiaryDisplayMode r1) {
        r0.currentDiaryDisplayMode = r1;
    }

    public static final /* synthetic */ void access$setFirstEnter$p(DoraGDeviceManagementViewModel r0, boolean r1) {
        r0.isFirstEnter = r1;
    }

    public static final /* synthetic */ void access$setFirstLoad$p(DoraGDeviceManagementViewModel r0, boolean r1) {
        r0.isFirstLoad = r1;
    }

    public static final /* synthetic */ void access$setLastKnownBindListSize$p(DoraGDeviceManagementViewModel r0, int r1) {
        r0.lastKnownBindListSize = r1;
    }

    public static final /* synthetic */ void access$setRefreshingLatestCardContent$p(DoraGDeviceManagementViewModel r0, boolean r1) {
        r0.isRefreshingLatestCardContent = r1;
    }

    public static final /* synthetic */ List access$sortDeviceList(DoraGDeviceManagementViewModel r0, List r1) {
        return r0.sortDeviceList(r1);
    }

    public static final /* synthetic */ Object access$updateOnlyDeviceComponent(DoraGDeviceManagementViewModel r0, Continuation r1) {
        return r0.updateOnlyDeviceComponent(r1);
    }

    public static final /* synthetic */ Object access$updateOnlyDeviceComponentWithoutSoda(DoraGDeviceManagementViewModel r0, Continuation r1) {
        return r0.updateOnlyDeviceComponentWithoutSoda(r1);
    }

    private final void cacheConnectedDeviceSnapshotIfNeeded(DoraDevice r7, String r8) {
        if (r7 != null) goto L5;
        g49.d.d(TAG, "cacheConnectedDeviceSnapshotIfNeeded skip null device, source=" + r8);
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r7, r8, null), 2, null);
    }

    /* JADX INFO: renamed from: fetchLatestCardContentInternal-gIAlu-s, reason: not valid java name */
    private final Object m66fetchLatestCardContentInternalgIAlus(boolean r110, Continuation<? super Result<h>> r20) {
        if ((r20 instanceof DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$1) == false) goto L7;
        DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$1 r2 = (DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
        return ((Result) r1).unbox-impl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r6 = r2.Z$0;
        ResultKt.throwOnFailure(r1);
    L20:
        DoraDevice r7 = (DoraDevice) r1;
        String r8 = "";
        if (r7 == null) goto L27;
        String r9 = o59.a.A(r7.getSerialNumber(), r7.mac, Boxing.boxInt(r7.productId));
        if (r9 == null) goto L26;
        r8 = r9;
    L26:
        String r10 = String.valueOf(r7.productId);
    L35:
        if (r6 == false) goto L37;
        List<String> r11 = CollectionsKt.listOf("quick_note");
    L38:
        g49.d.d(TAG, "fetchLatestCardContentInternal: wDid=" + r8 + ", productId=" + r10 + ", cardKeys=" + CollectionsKt.joinToString$default(r11, null, null, null, 0, null, null, 63, null));
        DoraNetworkApi r12 = DoraNetworkApi.a;
        r2.label = 2;
        Object r13 = r12.k(r8, r10, r11, r2);
        if (r13 != r4) goto L44;
        return r4;
    L44:
        return r13;
    L37:
        r11 = CollectionsKt.listOf(new String[]{"diary", "quick_note"});
        goto L38
    L27:
        b0.a.getClass();
        DoraSimpleDevice r14 = b0.k();
        if (r14 == null) goto L42;
        String r15 = o59.a.A(r14.getSerialNumber(), r14.getMac(), Boxing.boxInt(r14.getType()));
        if (r15 == null) goto L33;
        r8 = r15;
    L33:
        r10 = String.valueOf(r14.getType());
        goto L35
    L42:
        Result.Companion r16 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new RuntimeException("No selected device")));
    L16:
        ResultKt.throwOnFailure(r1);
        CoroutineDispatcher r17 = Dispatchers.getIO();
        DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$selectedDevice$1 r18 = new DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$selectedDevice$1(this, null);
        r2.Z$0 = r110;
        r2.label = 1;
        r1 = BuildersKt.withContext(r17, r18, r2);
        if (r1 != r4) goto L19;
        return r4;
    L19:
        r6 = r110;
    L7:
        r2 = new DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$1(this, r20);
        goto L8
    }

    private final Object handleGConnectRequest(DoraDevice r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof C02261) == false) goto L7;
        C02261 r0 = (C02261) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L16;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L30
    L48:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L30
    L42:
        return Unit.INSTANCE;
    L19:
        r11 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L30
    L26:
        OnlyBindResult r14 = (OnlyBindResult) r13;     // Catch: Throwable -> L30
        if (CollectionsKt.listOf(new OnlyBindResult[]{OnlyBindResult.SERVER_BIND_NETWORK_ERROR, OnlyBindResult.SERVER_BIND_UNKNOWN}).contains(r14) == false) goto L33;
        s r15 = s.a;     // Catch: Throwable -> L30
        Application r16 = AppHost.a.getApplication();     // Catch: Throwable -> L30
        r15.getClass();     // Catch: Throwable -> L30
        s.b(r16, 2131908080, false);     // Catch: Throwable -> L30
        onConnectRequestFailed();     // Catch: Throwable -> L30
        return Unit.INSTANCE;
    L33:
        if (r14 != OnlyBindResult.SERVER_BIND_FAILED) goto L37;
        s r17 = s.a;     // Catch: Throwable -> L30
        AppHost.Companion r4 = AppHost.a;     // Catch: Throwable -> L30
        Application r5 = r4.getApplication();     // Catch: Throwable -> L30
        String r18 = r4.getApplication().getString(2131903938, new Object[]{o59.a.g(r11)});     // Catch: Throwable -> L30
        r17.getClass();     // Catch: Throwable -> L30
        s.c(r5, r18);     // Catch: Throwable -> L30
        onConnectRequestFailed();     // Catch: Throwable -> L30
        return Unit.INSTANCE;
    L37:
        if (r14 != OnlyBindResult.SUCCESS) goto L43;
        g49.d.d(TAG, "connect request, bind success, connect spp");     // Catch: Throwable -> L30
        r0.L$0 = null;     // Catch: Throwable -> L30
        r0.label = 2;     // Catch: Throwable -> L30
        if (onlyConnect(r11, r0) != r2) goto L42;
        return r2;
    L43:
        g49.d.d(TAG, "cur device need unbind ");     // Catch: Throwable -> L30
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L30
        C02272 r6 = new C02272(this, r11, null);     // Catch: Throwable -> L30
        r0.L$0 = null;     // Catch: Throwable -> L30
        r0.label = 3;     // Catch: Throwable -> L30
        if (BuildersKt.withContext(r110, r6, r0) != r2) goto L48;
        return r2;
    L22:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Throwable -> L30
        DoraGDeviceManagementViewModel$handleGConnectRequest$bindResult$1 r7 = new DoraGDeviceManagementViewModel$handleGConnectRequest$bindResult$1(r11, null);     // Catch: Throwable -> L30
        r0.L$0 = r11;     // Catch: Throwable -> L30
        r0.label = 1;     // Catch: Throwable -> L30
        r13 = BuildersKt.withContext(r111, r7, r0);     // Catch: Throwable -> L30
        if (r13 != r2) goto L26;
        return r2;
    L30:
        th = move-exception;
        g49.d.d(TAG, "handleGConnectRequest: Exception=" + th);
        s r112 = s.a;
        Application r113 = AppHost.a.getApplication();
        r112.getClass();
        s.b(r113, 2131902626, false);
        onConnectRequestFailed();
    L7:
        r0 = new C02261(this, r12);
        goto L8
    }

    private final Object isDeviceConnected(String r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof C02291) == false) goto L7;
        C02291 r0 = (C02291) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L36:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
    L29:
        DoraDevice r11 = (DoraDevice) r10;
        if (r11 == null) goto L32;
        CoroutineDispatcher r12 = Dispatchers.getIO();
        C02302 r4 = new C02302(r11, null);
        r0.label = 2;
        r10 = BuildersKt.withContext(r12, r4, r0);
        if (r10 != r2) goto L36;
        return r2;
    L32:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r10);
        if (r8 != null) goto L19;
    L22:
        boolean r13 = true;
    L23:
        if (r13 == true) goto L25;
        CoroutineDispatcher r14 = Dispatchers.getIO();
        DoraGDeviceManagementViewModel$isDeviceConnected$device$1 r5 = new DoraGDeviceManagementViewModel$isDeviceConnected$device$1(r8, null);
        r0.label = 1;
        r10 = BuildersKt.withContext(r14, r5, r0);
        if (r10 != r2) goto L29;
        return r2;
    L25:
        return Boxing.boxBoolean(false);
    L19:
        if (r8.length() == 0) goto L22;
        r13 = false;
    L7:
        r0 = new C02291(this, r9);
        goto L8
    }

    public final Object onlyConnect(DoraDevice r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof C02361) == false) goto L7;
        C02361 r3 = (C02361) r13;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r14 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L17;
        if (r6 != 3) goto L16;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L30
    L42:
        int r15 = ((Number) r14).intValue();     // Catch: Throwable -> L30
        g49.d.d(TAG, "onlyConnect: state=" + r15);     // Catch: Throwable -> L30
        if (r15 == 2) goto L54;
        onConnectRequestFailed();     // Catch: Throwable -> L30
    L54:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L30
    L50:
        onConnectRequestFailed();     // Catch: Throwable -> L30
        goto L54
    L19:
        r12 = (DoraDevice) r3.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L30
    L35:
        OnlyConnectResult r16 = (OnlyConnectResult) r14;     // Catch: Throwable -> L30
        g49.d.d(TAG, "only connect: " + o59.a.h(r12) + " result = " + r16);     // Catch: Throwable -> L30
        int r17 = d.b[r16.ordinal()];     // Catch: Throwable -> L30
        if (r17 == 1) goto L47;
        if (r17 == 2) goto L47;
        if (r17 != 3) goto L46;
        CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Throwable -> L30
        DoraGDeviceManagementViewModel$onlyConnect$state$1 r1 = new DoraGDeviceManagementViewModel$onlyConnect$state$1(r12, null);     // Catch: Throwable -> L30
        r3.L$0 = null;     // Catch: Throwable -> L30
        r3.label = 3;     // Catch: Throwable -> L30
        r14 = BuildersKt.withContext(r18, r1, r3);     // Catch: Throwable -> L30
        if (r14 != r5) goto L42;
        return r5;
    L46:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L30
    L47:
        MutableSharedFlow<com.larus.dora.impl.device.manage.viewmodel.a> r110 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L30
        com.larus.dora.impl.device.manage.viewmodel.a.b r0 = new com.larus.dora.impl.device.manage.viewmodel.a.b(r12);     // Catch: Throwable -> L30
        r3.L$0 = null;     // Catch: Throwable -> L30
        r3.label = 2;     // Catch: Throwable -> L30
        if (r110.emit(r0, r3) != r5) goto L50;
        return r5;
    L22:
        ResultKt.throwOnFailure(r14);
        StringBuilder r111 = new StringBuilder("start only connect ");     // Catch: Throwable -> L30
        if (r12 == null) goto L26;
        String r2 = o59.a.h(r12);     // Catch: Throwable -> L30
    L27:
        r111.append(r2);     // Catch: Throwable -> L30
        g49.d.d(TAG, r111.toString());     // Catch: Throwable -> L30
        if (r12 != null) goto L32;
        s r112 = s.a;     // Catch: Throwable -> L30
        Application r113 = AppHost.a.getApplication();     // Catch: Throwable -> L30
        r112.getClass();     // Catch: Throwable -> L30
        s.b(r113, 2131902626, false);     // Catch: Throwable -> L30
        onConnectRequestFailed();     // Catch: Throwable -> L30
        goto L54
    L32:
        CoroutineDispatcher r114 = Dispatchers.getIO();     // Catch: Throwable -> L30
        DoraGDeviceManagementViewModel$onlyConnect$connectResult$1 r7 = new DoraGDeviceManagementViewModel$onlyConnect$connectResult$1(r12, null);     // Catch: Throwable -> L30
        r3.L$0 = r12;     // Catch: Throwable -> L30
        r3.label = 1;     // Catch: Throwable -> L30
        r14 = BuildersKt.withContext(r114, r7, r3);     // Catch: Throwable -> L30
        if (r14 != r5) goto L35;
        return r5;
    L26:
        r2 = null;
    L30:
        th = move-exception;
        g49.d.b(TAG, "onlyConnect: exception=" + th);
        onConnectRequestFailed();
    L7:
        r3 = new C02361(this, r13);
        goto L8
    }

    public final void refreshLatestCardContent(boolean r7, boolean r8) {
        if (this.isRefreshingLatestCardContent == false) goto L6;
        g49.d.d(TAG, "refreshLatestCardContent: already in progress, skip");
        return;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02391(this, r8, r7, null), 3, null);
    }

    public final Object updateOnlyFirmwareUpdateCard(boolean r41, Continuation<? super Unit> r42) {
        DoraDevice r2 = ((c) this._uiState.getValue()).b;
        StringBuilder r3 = new StringBuilder("updateOnlyFirmwareUpdateCard: start, hasSelectedDevice=");
        if (r2 == null) goto L5;
        boolean r6 = true;
    L6:
        r3.append(r6);
        r3.append(" thread=");
        r3.append(ThreadMethodProxy.currentThread().getName());
        String r4 = r3.toString();
        String r7 = TAG;
        g49.d.d(TAG, r4);
        List<? extends p0> r13 = CollectionsKt.toMutableList(((c) this._uiState.getValue()).g);
        Iterator<? extends p0> r5 = r13.iterator();
        int r8 = 0;
    L8:
        if (r5.hasNext() == false) goto L13;
        if ((r5.next() instanceof g) == true) goto L14;
        r8 = r8 + 1;
    L14:
        if (r41 == false) goto L16;
        g r15 = null;
    L17:
        if (r15 == null) goto L25;
        if (r8 == (-1)) goto L20;
        ListProtector.set(r13, r8, r15);
    L27:
        boolean r14 = true;
    L29:
        if (r14 == false) goto L68;
        if (r15 == null) goto L32;
        boolean r9 = true;
    L33:
        Iterator<? extends p0> r10 = r13.iterator();
        int r11 = 0;
    L35:
        if (r10.hasNext() == false) goto L40;
        if ((r10.next() instanceof com.larus.dora.impl.device.manage.d) == true) goto L41;
        r11 = r11 + 1;
    L41:
        Object r12 = CollectionsKt.getOrNull(r13, r11);
        if ((r12 instanceof com.larus.dora.impl.device.manage.d) == false) goto L44;
        com.larus.dora.impl.device.manage.d r16 = (com.larus.dora.impl.device.manage.d) r12;
    L46:
        if (r16 != null) goto L48;
    L50:
        boolean r38 = r9;
        List<? extends p0> r0 = r13;
    L51:
        Iterator<? extends p0> r1 = r0.iterator();
        int r17 = 0;
    L53:
        if (r1.hasNext() == false) goto L58;
        if ((r1.next() instanceof b1) == true) goto L56;
        r17 = r17 + 1;
        goto L53
    L56:
        int r18 = r17;
    L59:
        Object r20 = CollectionsKt.getOrNull(r0, r18);
        if ((r20 instanceof b1) == false) goto L62;
        b1 r21 = (b1) r20;
    L63:
        if (r21 == null) goto L67;
        boolean r22 = r38;
        if (r21.f == r22) goto L67;
        String r23 = r21.a;
        String r24 = r21.b;
        String r25 = r21.c;
        int r26 = r21.d;
        boolean r27 = r21.e;
        Intrinsics.checkNotNullParameter(r23, "id");
        Intrinsics.checkNotNullParameter(r24, "title");
        Intrinsics.checkNotNullParameter(r25, "subTitle");
        ListProtector.set(r0, r18, new b1(r23, r24, r25, r26, r27, r22));
    L67:
        z0<c> r28 = this._uiState;
        r28.setValue(c.a((c) r28.getValue(), null, null, null, null, null, r0, false, null, null, false, 4031));
    L69:
        StringBuilder r30 = new StringBuilder("updateOnlyFirmwareUpdateCard: hideOnly=");
        r30.append(r41);
        r30.append(" hasPackage=");
        if (r15 == null) goto L72;
        boolean r31 = true;
    L73:
        r30.append(r31);
        r30.append(" updated=");
        r30.append(r14);
        r30.append(" hasSelectedDevice=");
        if (r2 == null) goto L76;
        boolean r32 = true;
    L77:
        r30.append(r32);
        String r33 = r7;
        g49.d.d(r33, r30.toString());
        return Unit.INSTANCE;
    L76:
        r32 = false;
        goto L77
    L72:
        r31 = false;
        goto L73
    L62:
        r21 = null;
        goto L63
    L58:
        r18 = -1;
        goto L59
    L48:
        if (r16.o == r9) goto L50;
        String r34 = r16.a;
        String r35 = r16.b;
        String r36 = r16.c;
        String r37 = r16.d;
        String r110 = r16.e;
        String r111 = r16.f;
        String r40 = r16.g;
        String r43 = r16.h;
        boolean r44 = r16.i;
        boolean r45 = r16.j;
        int r310 = r11;
        String r112 = r16.k;
        DiaryDisplayMode r113 = r16.l;
        r38 = r9;
        boolean r46 = r16.m;
        boolean r47 = r16.n;
        Intrinsics.checkNotNullParameter(r34, "id");
        Intrinsics.checkNotNullParameter(r35, "title");
        Intrinsics.checkNotNullParameter(r110, "actionText");
        Intrinsics.checkNotNullParameter(r113, "displayMode");
        com.larus.dora.impl.device.manage.d r114 = new com.larus.dora.impl.device.manage.d(r34, r35, r36, r37, r110, r111, r40, r43, r44, r45, r112, r113, r46, r47, r38);
        r0 = r13;
        ListProtector.set(r0, r310, r114);
        goto L51
    L44:
        r16 = null;
        goto L46
    L40:
        r11 = -1;
        goto L41
    L32:
        r9 = false;
        goto L33
    L68:
        r2 = r2;
        r7 = TAG;
        goto L69
    L20:
        int r48 = findFirmwareUpdateInsertIndex(r13);
        if (r48 != (-1)) goto L24;
        g49.d.e(TAG, "updateOnlyFirmwareUpdateCard: device item missing, skip firmware card insert");
        return Unit.INSTANCE;
    L24:
        ListProtector.add(r13, r48, r15);
        goto L27
    L25:
        if (r8 == (-1)) goto L28;
        ListProtector.remove(r13, r8);
        goto L27
    L28:
        r14 = false;
        goto L29
    L16:
        r15 = buildFirmwareUpdateItem(r2);
        goto L17
    L13:
        r8 = -1;
        goto L14
    L5:
        r6 = false;
        goto L6
    }

    public static final /* synthetic */ void access$cacheConnectedDeviceSnapshotIfNeeded(DoraGDeviceManagementViewModel r0, DoraDevice r1, String r2) {
        r0.cacheConnectedDeviceSnapshotIfNeeded(r1, r2);
    }

    /* JADX INFO: renamed from: access$fetchLatestCardContentInternal-gIAlu-s, reason: not valid java name */
    public static final /* synthetic */ Object m65access$fetchLatestCardContentInternalgIAlus(DoraGDeviceManagementViewModel r0, boolean r1, Continuation r2) {
        return r0.m66fetchLatestCardContentInternalgIAlus(r1, r2);
    }

    public static final /* synthetic */ Object access$handleGConnectRequest(DoraGDeviceManagementViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.handleGConnectRequest(r1, r2);
    }

    public static final /* synthetic */ Object access$isDeviceConnected(DoraGDeviceManagementViewModel r0, String r1, Continuation r2) {
        return r0.isDeviceConnected(r1, r2);
    }

    private final Object performDeviceSwitch(DoraDevice r17, boolean r18, Continuation<? super Unit> r110) {
        if ((r110 instanceof C02371) == false) goto L7;
        C02371 r2 = (C02371) r110;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        C02371 r10 = r2;
        Object r1 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r10.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        boolean r0 = r10.Z$0;
        com.larus.dora.impl.device.manage.a r5 = (com.larus.dora.impl.device.manage.a) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L43:
        a1 r6 = this.deviceSwitchListener;
        if (r6 == null) goto L46;
        r6.a(r5);
    L46:
        if (r0 == false) goto L49;
        refreshLatestCardContent$default(this, false, false, 3, null);
    L49:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r7 = r10.Z$0;
        ResultKt.throwOnFailure(r1);
        boolean r15 = r7;
    L35:
        Object r8 = CollectionsKt.firstOrNull(((c) this._uiState.getValue()).g);
        if ((r8 instanceof com.larus.dora.impl.device.manage.c) == false) goto L38;
        com.larus.dora.impl.device.manage.c r9 = (com.larus.dora.impl.device.manage.c) r8;
    L39:
        r5 = new com.larus.dora.impl.device.manage.a(r9);
        r10.L$0 = r5;
        r10.Z$0 = r15;
        r10.label = 2;
        if (DelayKt.delay(50, r10) != r11) goto L42;
        return r11;
    L42:
        r0 = r15;
        goto L43
    L38:
        r9 = null;
        goto L39
    L16:
        ResultKt.throwOnFailure(r1);
        if (r17 == null) goto L49;
        String r12 = r17.mac;
        this.currentDeviceMac = r12;
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        moveDeviceToFront(r12);
        if (kj4.a.g().getDoraLinkState(r17) != 2) goto L24;
        boolean r13 = true;
    L25:
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
        DoraDevice r14 = DoraAdapterExtKt.i(kj4.a.g(), false);
        if (r14 != null) goto L28;
    L30:
        if (r13 == false) goto L32;
        this.currentBatteryInfo = o59.a.a(r17);
        this.currentChargeInfo = o59.a.b(r17);
    L32:
        r15 = r18;
        r10.Z$0 = r15;
        r10.label = 1;
        if (updateDeviceStatusWithCurrentContent$default(this, false, null, false, false, false, r10, 31, null) != r11) goto L35;
        return r11;
    L28:
        if (Intrinsics.areEqual(r14.mac, r17.mac) == false) goto L30;
        this.currentBatteryInfo = o59.a.a(r14);
        this.currentChargeInfo = o59.a.b(r14);
        goto L32
    L24:
        r13 = false;
    L7:
        r2 = new C02371(this, r110);
        goto L8
    }

    private final Object scanBleInfo(DoraDevice r17, long r18, Continuation<? super DoraDevice> r20) {
        if ((r20 instanceof C02411) == false) goto L7;
        C02411 r2 = (C02411) r20;
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
        f r0 = (f) r2.L$1;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L22:
        g49.d.d(TAG, "scan ble info cost: " + (System.currentTimeMillis() - r6));
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
        g49.d.d(TAG, "connect request, start scan ble info, productId=" + r17.productId + ", type=" + r17.type + ", isV2BleDevice=" + r9 + ", scanUuids=" + r10);
        r0 = new f(r12, r9, r8, r13);
        kj4.a.g().scan(r10, r0);
        C02422 r14 = new C02422(r12, null);
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
        r2 = new C02411(this, r20);
        goto L8
    }

    private static final int sortDeviceList$lambda$30(DoraGDeviceManagementViewModel r5, DoraDevice r6, DoraDevice r7) {
        boolean r1 = false;
        if (kj4.a.g().getDoraLinkState(r6) != 2) goto L5;
        boolean r0 = true;
    L7:
        if (kj4.a.g().getDoraLinkState(r7) != 2) goto L9;
        r1 = true;
    L9:
        if (r0 == r1) goto L13;
        if (r0 == false) goto L14;
        return -1;
    L14:
        return 1;
    L13:
        return Intrinsics.compare(r5.deviceOrder.indexOf(r6.mac), r5.deviceOrder.indexOf(r7.mac));
    L5:
        r0 = false;
        goto L7
    }

    private static final int sortDeviceList$lambda$31(Function2 r0, Object r1, Object r2) {
        return ((Number) r0.invoke(r1, r2)).intValue();
    }

    public static final /* synthetic */ Object access$performDeviceSwitch(DoraGDeviceManagementViewModel r0, DoraDevice r1, boolean r2, Continuation r3) {
        return r0.performDeviceSwitch(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$scanBleInfo(DoraGDeviceManagementViewModel r0, DoraDevice r1, long r2, Continuation r4) {
        return r0.scanBleInfo(r1, r2, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkSodaBanner$default(DoraGDeviceManagementViewModel r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.checkSodaBanner(r1);
    }

    private final Object updateDiaryAndQuickNoteComponents(boolean r30, DiaryDisplayMode r31, boolean r32, Continuation<? super Unit> r33) {
        if ((r33 instanceof C02451) == false) goto L7;
        C02451 r1 = (C02451) r33;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        C02451 r10 = r1;
        Object r0 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L85:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r4 = r10.Z$1;
        boolean r5 = r10.Z$0;
        List r6 = (List) r10.L$1;
        DiaryDisplayMode r7 = (DiaryDisplayMode) r10.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r17 = r4;
        boolean r15 = r5;
        List r8 = r6;
        DiaryDisplayMode r16 = r7;
    L20:
        List r9 = (List) r0;
        Iterator r12 = r9.iterator();
    L22:
        if (r12.hasNext() == false) goto L26;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((DoraDevice) r13).mac, this.currentDeviceMac) == false) goto L22;
    L27:
        DoraDevice r14 = (DoraDevice) r13;
        if (r14 != null) goto L30;
        r14 = (DoraDevice) CollectionsKt.firstOrNull(r9);
    L30:
        IDoraPageConfig r18 = (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
        if (r18 == null) goto L33;
        boolean r20 = r18.d("dora_g_config_key_env_observe_enable", false);
    L34:
        if (r14 != null) goto L36;
        boolean r21 = false;
    L41:
        if (r14 == null) goto L46;
        String r22 = ILoginService.a.getAccountInfo().c;
        b0.a.getClass();
        if (b0.f(r22) == false) goto L46;
        if (r21 == false) goto L46;
        boolean r110 = true;
    L47:
        if (r14 == null) goto L49;
        boolean r23 = true;
    L50:
        List r24 = r8;
        if ((r24 instanceof Collection) == true) goto L53;
    L55:
        Iterator r25 = r24.iterator();
    L57:
        if (r25.hasNext() == false) goto L61;
        if ((((p0) r25.next()) instanceof g) == false) goto L57;
        boolean r111 = true;
    L62:
        boolean r26 = false;
        List r112 = r8;
        List<p0> r27 = buildDiaryComponent(r15, r16, r17, r23, r21, r20, r110, r111);
        List<p0> r28 = buildQuickNoteComponent(r15);
        int r34 = r112.size();
        boolean r35 = false;
        int r36 = 0;
    L63:
        if (r36 >= r34) goto L77;
        if (r26 == false) goto L66;
    L68:
        if (r35 == false) goto L70;
    L72:
        if (r26 == false) goto L75;
        if (r35 == true) goto L77;
    L75:
        r36 = r36 + 1;
        goto L63
    L70:
        if ((ListProtector.get(r112, r36) instanceof com.larus.dora.impl.device.manage.e) == false) goto L72;
        ListProtector.set(r112, r36, CollectionsKt.first(r28));
        r35 = true;
        goto L72
    L66:
        if ((ListProtector.get(r112, r36) instanceof com.larus.dora.impl.device.manage.d) == false) goto L68;
        ListProtector.set(r112, r36, CollectionsKt.first(r27));
        r26 = true;
    L77:
        if (r26 == false) goto L81;
        if (r35 == false) goto L81;
        z0<c> r37 = this._uiState;
        r37.setValue(c.a((c) r37.getValue(), null, null, null, null, null, r112, false, null, null, false, 4031));
        g49.d.d(TAG, "updateDiaryAndQuickNoteComponents: both diary and quick note components updated");
        return Unit.INSTANCE;
    L81:
        g49.d.e(TAG, "updateDiaryAndQuickNoteComponents: components not found, falling back to full update");
        r10.L$0 = null;
        r10.L$1 = null;
        r10.label = 2;
        if (updateDeviceStatusWithCurrentContent$default(this, r15, r16, r17, false, false, r10, 24, null) != r11) goto L85;
        return r11;
    L61:
        r111 = false;
        goto L62
    L53:
        if (r24.isEmpty() == false) goto L55;
    L49:
        r23 = false;
    L46:
        r110 = false;
        goto L47
    L36:
        if (kj4.a.g().getDoraLinkState(r14) != 2) goto L38;
        boolean r38 = true;
    L39:
        r21 = r38;
        goto L41
    L38:
        r38 = false;
        goto L39
    L33:
        r20 = false;
        goto L34
    L26:
        r13 = null;
        goto L27
    L16:
        ResultKt.throwOnFailure(r0);
        List r40 = CollectionsKt.toMutableList(((c) this._uiState.getValue()).g);
        CoroutineDispatcher r41 = Dispatchers.getIO();
        DoraGDeviceManagementViewModel$updateDiaryAndQuickNoteComponents$rawBindList$1 r42 = new DoraGDeviceManagementViewModel$updateDiaryAndQuickNoteComponents$rawBindList$1(null);
        r10.L$0 = r31;
        r10.L$1 = r40;
        r10.Z$0 = r30;
        r10.Z$1 = r32;
        r10.label = 1;
        r0 = BuildersKt.withContext(r41, r42, r10);
        if (r0 != r11) goto L19;
        return r11;
    L19:
        r16 = r31;
        r8 = r40;
        r15 = r30;
        r17 = r32;
    L7:
        r1 = new C02451(this, r33);
        goto L8
    }

    public static final /* synthetic */ Object access$updateDiaryAndQuickNoteComponents(DoraGDeviceManagementViewModel r0, boolean r1, DiaryDisplayMode r2, boolean r3, Continuation r4) {
        return r0.updateDiaryAndQuickNoteComponents(r1, r2, r3, r4);
    }

    public static /* synthetic */ void refreshLatestCardContent$default(DoraGDeviceManagementViewModel r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        r0.refreshLatestCardContent(r1, r2);
    }

    public static /* synthetic */ Object updateOnlyFirmwareUpdateCard$default(DoraGDeviceManagementViewModel r0, boolean r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.updateOnlyFirmwareUpdateCard(r1, r2);
    }

    public static /* synthetic */ Object scanBleInfo$default(DoraGDeviceManagementViewModel r0, DoraDevice r1, long r2, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS;
    L6:
        return r0.scanBleInfo(r1, r2, r4);
    }

    public final Object updateDeviceStatusWithCurrentContent(boolean r26, DiaryDisplayMode r27, boolean r28, boolean r210, boolean r30, Continuation<? super Unit> r31) {
        if ((r31 instanceof C02441) == false) goto L7;
        C02441 r1 = (C02441) r31;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        b1 r5 = null;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        boolean r6 = r1.Z$3;
        boolean r7 = r1.Z$2;
        boolean r8 = r1.Z$1;
        boolean r9 = r1.Z$0;
        DiaryDisplayMode r10 = (DiaryDisplayMode) r1.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r11 = r8;
        boolean r12 = r9;
        DiaryDisplayMode r13 = r10;
    L22:
        List<? extends DoraDevice> r14 = (List) r0;
        IDoraPageConfig r15 = (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
        if (r15 == null) goto L25;
        boolean r16 = r15.d("dora_g_config_key_env_observe_enable", false);
    L26:
        List<DoraDevice> r17 = sortDeviceList(r14);
        List<DoraDevice> r18 = r17;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator<T> r20 = r18.iterator();
    L28:
        if (r20.hasNext() == false) goto L33;
        String r111 = ((DoraDevice) r20.next()).name;
        if (r111 != null) goto L32;
        r111 = "Unknown Device";
    L32:
        r110.add(r111);
        goto L28
    L33:
        Iterator<T> r21 = r18.iterator();
    L35:
        if (r21.hasNext() == false) goto L40;
        Object r112 = r21.next();
        if (Intrinsics.areEqual(((DoraDevice) r112).mac, this.currentDeviceMac) == false) goto L35;
    L41:
        DoraDevice r113 = (DoraDevice) r112;
        if (r113 != null) goto L44;
        r113 = (DoraDevice) CollectionsKt.firstOrNull(r17);
    L44:
        if (r7 == false) goto L70;
        Iterator<T> r22 = r18.iterator();
    L47:
        if (r22.hasNext() == false) goto L51;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((DoraDevice) r23).mac, this.currentDeviceMac) == false) goto L47;
    L53:
        if (((DoraDevice) r23) != null) goto L57;
        if (r113 == null) goto L57;
        g49.d.d(TAG, "updateDeviceStatusWithCurrentContent: current device " + this.currentDeviceMac + " not found, switching to " + r113.mac);
        this.currentDeviceMac = r113.mac;
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
    L62:
        Iterator<T> r24 = r18.iterator();
    L64:
        if (r24.hasNext() == false) goto L68;
        Object r25 = r24.next();
        if (Intrinsics.areEqual(((DoraDevice) r25).mac, this.currentDeviceMac) == false) goto L64;
    L69:
        DoraDevice r114 = (DoraDevice) r25;
    L71:
        ArrayList r115 = new ArrayList();
        if ((r18 instanceof Collection) == true) goto L74;
    L76:
        Iterator<T> r32 = r18.iterator();
    L78:
        if (r32.hasNext() == false) goto L85;
        if (kj4.a.g().getDoraLinkState((DoraDevice) r32.next()) != 2) goto L82;
        boolean r33 = true;
    L83:
        if (r33 == false) goto L78;
        boolean r34 = true;
    L86:
        if (r6 == true) goto L97;
        Iterator<T> r35 = ((c) this._uiState.getValue()).g.iterator();
    L89:
        if (r35.hasNext() == false) goto L93;
        Object r36 = r35.next();
        if ((((p0) r36) instanceof b1) == false) goto L89;
    L95:
        if ((r36 instanceof b1) == false) goto L97;
        r5 = (b1) r36;
        goto L97
    L93:
        r36 = null;
    L97:
        if (r114 == null) goto L114;
        b r37 = buildDeviceComponentData(r114);
        boolean r38 = r37.b;
        cacheConnectedDeviceSnapshotIfNeeded(r114, "update_status");
        r115.add(r37.a);
        g r40 = buildFirmwareUpdateItem(r114);
        if (r40 == null) goto L101;
        Boxing.boxBoolean(r115.add(r40));
    L101:
        if (r6 == true) goto L105;
        if (r5 == null) goto L105;
        r115.add(r5);
        boolean r41 = r5.e;
    L115:
        if (r114 == null) goto L117;
        boolean r42 = true;
    L118:
        if (r41 == false) goto L121;
        if (r38 == false) goto L121;
        boolean r116 = true;
    L123:
        if (r115.isEmpty() == true) goto L131;
        Iterator r43 = r115.iterator();
    L127:
        if (r43.hasNext() == false) goto L131;
        if ((((p0) r43.next()) instanceof g) == false) goto L127;
        boolean r117 = true;
    L132:
        r115.addAll(buildDiaryComponent(r12, r13, r11, r42, r34, r16, r116, r117));
        r115.addAll(buildHealthComponent(readHealthAgentWebUrl()));
        r115.addAll(buildQuickNoteComponent(r12));
        r115.addAll(buildOtherComponents(r34));
        z0<c> r44 = this._uiState;
        c r45 = (c) r44.getValue();
        PageState r46 = PageState.Content;
        if (r114 == null) goto L138;
        String r47 = r114.name;
        if (r47 == null) goto L138;
        String r118 = r47;
    L139:
        if (r114 == null) goto L144;
        String r48 = r114.mac;
        if (r48 == null) goto L144;
        String r119 = r48;
    L145:
        r44.setValue(c.a(r45, r46, r114, r118, r119, r110, r115, false, null, null, !r17.isEmpty(), 2960));
        return Unit.INSTANCE;
    L144:
        r119 = "";
    L138:
        r118 = "";
    L131:
        r117 = false;
    L121:
        r116 = false;
        goto L123
    L117:
        r42 = false;
    L105:
        String r50 = ILoginService.a.getAccountInfo().c;
        b0.a.getClass();
        boolean r51 = b0.f(r50);
        if (r51 == false) goto L113;
        if (r38 == false) goto L113;
        if (r40 == null) goto L111;
        boolean r52 = true;
    L112:
        r115.add(new b1(true, r52, 15));
        goto L113
    L111:
        r52 = false;
    L113:
        r41 = r51;
        goto L115
    L114:
        r41 = false;
        r38 = false;
        goto L115
    L82:
        r33 = false;
    L85:
        r34 = false;
        goto L86
    L74:
        if (r18.isEmpty() == false) goto L76;
    L68:
        r25 = null;
    L57:
        if (this.currentDeviceMac != null) goto L62;
        if (r113 == null) goto L60;
        String r53 = r113.mac;
    L61:
        this.currentDeviceMac = r53;
        goto L62
    L60:
        r53 = null;
        goto L61
    L51:
        r23 = null;
        goto L53
    L70:
        r114 = r113;
        goto L71
    L40:
        r112 = null;
        goto L41
    L25:
        r16 = false;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (r27 != null) goto L17;
        DiaryDisplayMode r54 = this.currentDiaryDisplayMode;
    L18:
        CoroutineDispatcher r55 = Dispatchers.getIO();
        DoraGDeviceManagementViewModel$updateDeviceStatusWithCurrentContent$rawBindList$1 r56 = new DoraGDeviceManagementViewModel$updateDeviceStatusWithCurrentContent$rawBindList$1(null);
        r1.L$0 = r54;
        r1.Z$0 = r26;
        r11 = r28;
        r1.Z$1 = r11;
        r1.Z$2 = r210;
        r1.Z$3 = r30;
        r1.label = 1;
        Object r57 = BuildersKt.withContext(r55, r56, r1);
        if (r57 != r3) goto L21;
        return r3;
    L21:
        r13 = r54;
        r0 = r57;
        r7 = r210;
        r6 = r30;
        r12 = r26;
        goto L22
    L17:
        r54 = r27;
    L7:
        r1 = new C02441(this, r31);
        goto L8
    }

    private final List<p0> buildDiaryComponent(boolean r26, DiaryDisplayMode r27, boolean r28, boolean r210, boolean r30, boolean r31, boolean r32, boolean r33) {
        DiaryDisplayMode r1 = r27;
        boolean r5 = false;
        if (r210 == false) goto L6;
        if (r30 == false) goto L6;
        boolean r7 = true;
    L7:
        a49.f r8 = ((c) this._uiState.getValue()).i;
        String r9 = null;
        if (r8 == null) goto L10;
        String r10 = r8.d;
    L11:
        if (r10 != null) goto L13;
    L16:
        boolean r11 = true;
    L17:
        if (r11 == false) goto L31;
        a49.f r12 = ((c) this._uiState.getValue()).i;
        if (r12 == null) goto L21;
        String r13 = r12.e;
    L22:
        if (r13 != null) goto L24;
    L27:
        boolean r14 = true;
    L28:
        if (r14 == false) goto L31;
        boolean r15 = false;
    L33:
        if (r7 == false) goto L43;
        if (r31 == false) goto L43;
        IDoraAVLinkService r16 = currentAvLinkService();
        if (r16 != null) goto L38;
    L40:
        boolean r17 = false;
    L41:
        if (r17 == true) goto L43;
        boolean r18 = true;
    L44:
        StringBuilder r110 = new StringBuilder("buildDiaryComponent: diaryDisplayMode=");
        r110.append(r1);
        r110.append(", isDiaryClickable=");
        boolean r111 = r28;
        r110.append(r111);
        r110.append(", diaryContent=");
        r110.append(((c) this._uiState.getValue()).i);
        r110.append(", isBound=");
        r110.append(r210);
        r110.append(", isConnected=");
        r110.append(r30);
        r110.append(", envObserveEnable=");
        r110.append(r31);
        r110.append(", hasDeviceConnected=");
        r110.append(r7);
        r110.append(", hasDiaryData=");
        r110.append(r15);
        r110.append(", isEnvObservePaused=");
        r110.append(r18);
        g49.d.d(TAG, r110.toString());
        if (r26 == false) goto L48;
        com.larus.dora.impl.device.manage.d r2 = new com.larus.dora.impl.device.manage.d(null, null, null, null, true, null, null, false, r32, r33, 7423);
    L134:
        return CollectionsKt.listOf(r2);
    L48:
        if (r7 == true) goto L63;
        DiaryDisplayMode r4 = DiaryDisplayMode.NETWORK_ERROR;
        if (r1 != r4) goto L52;
        int r20 = j0.a;
        String r3 = j0.d(2131902661);
    L53:
        if (r1 != r4) goto L55;
        r5 = true;
    L55:
        if (r1 == r4) goto L62;
        if (r15 == false) goto L62;
        a49.f r6 = ((c) this._uiState.getValue()).i;
        if (r6 == null) goto L61;
        String r21 = r6.e;
    L104:
        String r112 = r3;
        String r113 = r21;
        boolean r114 = r111;
        DiaryDisplayMode r22 = r1;
    L112:
        StringBuilder r23 = new StringBuilder("buildDiaryComponent: final subtitle=");
        r23.append(r112);
        r23.append(", content=");
        r23.append(r113);
        r23.append(", finalDisplayMode=");
        r23.append(r22);
        r23.append(", thumbnail=");
        a49.f r24 = ((c) this._uiState.getValue()).i;
        if (r24 == null) goto L115;
        String r25 = r24.k;
    L116:
        r23.append(r25);
        g49.d.d(TAG, r23.toString());
        if (r22 != DiaryDisplayMode.ENVIRONMENT_OFF) goto L119;
        String r34 = "";
    L120:
        String r115 = r34;
        DiaryDisplayMode r35 = DiaryDisplayMode.NORMAL;
        if (r22 != r35) goto L126;
        if (r15 == false) goto L126;
        a49.f r36 = ((c) this._uiState.getValue()).i;
        if (r36 == null) goto L126;
        String r116 = r36.a;
    L127:
        if (r22 != r35) goto L132;
        if (r15 == false) goto L132;
        a49.f r37 = ((c) this._uiState.getValue()).i;
        if (r37 == null) goto L132;
        r9 = r37.k;
    L132:
        r2 = new com.larus.dora.impl.device.manage.d(r112, r113, r115, r9, false, r116, r22, r114, r32, r33, 99);
    L126:
        r116 = null;
        goto L127
    L119:
        int r38 = j0.a;
        r34 = j0.d(2131902657);
        goto L120
    L115:
        r25 = null;
        goto L116
    L61:
        r21 = null;
    L62:
        int r40 = j0.a;
        r21 = j0.d(2131902664);
        r111 = r5;
        goto L104
    L52:
        int r41 = j0.a;
        r3 = j0.d(2131902480);
        goto L53
    L63:
        if (r31 == true) goto L73;
        r22 = DiaryDisplayMode.NORMAL;
        if (r1 != r22) goto L72;
        if (r15 == false) goto L72;
        int r42 = j0.a;
        String r43 = j0.d(2131902480);
        a49.f r44 = ((c) this._uiState.getValue()).i;
        if (r44 == null) goto L70;
        String r45 = r44.e;
    L71:
        r112 = r43;
        r113 = r45;
        r114 = r111;
        goto L112
    L70:
        r45 = null;
    L72:
        int r46 = j0.a;
        String r47 = j0.d(2131902646);
        r22 = DiaryDisplayMode.ENVIRONMENT_OFF;
        String r48 = r47;
        String r50 = null;
    L110:
        r112 = r50;
        r113 = r48;
        r114 = false;
        goto L112
    L73:
        int r51 = d.a[r27.ordinal()];
        if (r51 != 1) goto L76;
        int r52 = j0.a;
        String r53 = j0.d(2131902661);
        String r54 = j0.d(2131902664);
        r22 = DiaryDisplayMode.NETWORK_ERROR;
        r112 = r53;
        r113 = r54;
        r114 = true;
        goto L112
    L76:
        if (r51 == 2) goto L81;
        if (r18 == false) goto L79;
        int r55 = j0.a;
        r50 = j0.d(2131902480);
    L80:
        int r56 = j0.a;
        String r57 = j0.d(2131902664);
        DiaryDisplayMode r58 = DiaryDisplayMode.NO_CONTENT;
    L109:
        DiaryDisplayMode r211 = r58;
        r48 = r57;
        r22 = r211;
        goto L110
    L79:
        int r60 = j0.a;
        r50 = j0.d(2131902545);
        goto L80
    L81:
        if (r15 == false) goto L105;
        if (r18 == false) goto L84;
        int r61 = j0.a;
        String r62 = j0.d(2131902480);
    L98:
        r3 = r62;
    L99:
        a49.f r63 = ((c) this._uiState.getValue()).i;
        if (r63 == null) goto L102;
        r21 = r63.e;
    L103:
        r1 = DiaryDisplayMode.NORMAL;
        goto L104
    L102:
        r21 = null;
        goto L103
    L84:
        a49.f r64 = ((c) this._uiState.getValue()).i;
        if (r64 == null) goto L87;
        String r65 = r64.d;
    L88:
        if (r65 != null) goto L90;
    L91:
        r5 = true;
    L92:
        if (r5 == true) goto L97;
        a49.f r66 = ((c) this._uiState.getValue()).i;
        if (r66 == null) goto L96;
        r62 = r66.d;
        goto L98
    L96:
        r3 = null;
        goto L99
    L97:
        int r67 = j0.a;
        r62 = j0.d(2131902545);
        goto L98
    L90:
        if (r65.length() != 0) goto L92;
    L87:
        r65 = null;
        goto L88
    L105:
        if (r18 == false) goto L107;
        int r68 = j0.a;
        r50 = j0.d(2131902480);
    L108:
        int r70 = j0.a;
        r57 = j0.d(2131902664);
        r58 = DiaryDisplayMode.NO_CONTENT;
        goto L109
    L107:
        int r71 = j0.a;
        r50 = j0.d(2131902545);
        goto L108
    L38:
        if (r16.c1(2) != true) goto L40;
        r17 = true;
    L43:
        r18 = false;
        goto L44
    L24:
        if (r13.length() == 0) goto L27;
        r14 = false;
        goto L28
    L21:
        r13 = null;
    L31:
        r15 = true;
        goto L33
    L13:
        if (r10.length() == 0) goto L16;
        r11 = false;
        goto L17
    L10:
        r10 = null;
    L6:
        r7 = false;
        goto L7
    }

    public static /* synthetic */ Object updateDeviceStatusWithCurrentContent$default(DoraGDeviceManagementViewModel r9, boolean r10, DiaryDisplayMode r11, boolean r12, boolean r13, boolean r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r16 & 2) == 0) goto L9;
        DiaryDisplayMode r4 = null;
    L11:
        if ((r16 & 4) == 0) goto L13;
        boolean r5 = true;
    L15:
        if ((r16 & 8) == 0) goto L17;
        boolean r6 = false;
    L19:
        if ((r16 & 16) == 0) goto L21;
        boolean r7 = true;
    L23:
        return r9.updateDeviceStatusWithCurrentContent(r3, r4, r5, r6, r7, r15);
    L21:
        r7 = r14;
        goto L23
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
