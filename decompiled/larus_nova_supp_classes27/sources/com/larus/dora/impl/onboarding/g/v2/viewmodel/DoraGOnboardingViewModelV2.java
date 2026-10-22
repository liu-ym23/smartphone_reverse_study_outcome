package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.content.res.AssetFileDescriptor;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.Network;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.camera.model.DoraVisionQueryTrackInfo;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.vision.DoraDataFrame;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.google.gson.reflect.TypeToken;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsState;
import com.larus.business.debug.base.audio.module.TTSModule;
import com.larus.common.apphost.AppHost;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.request.v2.DoraRequestXV2;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.OnboardingVUIMode;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraGOnboardingConfig;
import com.larus.dora.impl.settings.DoraGOnboardingOpenRemark;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.util.g0;
import com.larus.dora.impl.util.r0;
import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import com.larus.dora.impl.wlan.wifi.DoraWifiList;
import com.larus.dora.impl.wlan.wifi.DoraWifiResponse;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.j0;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Ì\u00012\u00020\u0001:\u0002Ì\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020<J\u0006\u0010M\u001a\u00020KJ\u0006\u0010N\u001a\u00020KJ\u0006\u0010O\u001a\u00020KJ\u0010\u0010P\u001a\u00020K2\u0006\u0010Q\u001a\u00020<H\u0002J\u0018\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020\u001dH\u0002J\u0010\u0010U\u001a\u00020K2\u0006\u0010Q\u001a\u00020<H\u0002J\b\u0010V\u001a\u00020KH\u0002J\u0018\u0010W\u001a\u00020K2\u0006\u0010X\u001a\u00020<2\u0006\u0010Y\u001a\u00020<H\u0002J\b\u0010Z\u001a\u00020KH\u0002J\u0007\u0010\u0087\u0001\u001a\u00020KJ\u0007\u0010\u0088\u0001\u001a\u00020KJ\u0007\u0010\u0089\u0001\u001a\u00020KJ\u0012\u0010\u008a\u0001\u001a\u00020K2\u0007\u0010\u008b\u0001\u001a\u00020gH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020K2\u0007\u0010\u008d\u0001\u001a\u00020zH\u0002J\u0010\u0010\u008e\u0001\u001a\u00020K2\u0007\u0010\u008f\u0001\u001a\u00020zJ\u0007\u0010\u0090\u0001\u001a\u00020\u001dJ\u0007\u0010\u0091\u0001\u001a\u00020KJ\t\u0010\u0092\u0001\u001a\u00020KH\u0007J\u0007\u0010\u0093\u0001\u001a\u00020KJ\u001c\u0010\u0094\u0001\u001a\u00020K2\u0007\u0010\u008f\u0001\u001a\u00020z2\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0096\u0001J\u0010\u0010\u0097\u0001\u001a\u00020K2\u0007\u0010\u008f\u0001\u001a\u00020zJ\u0007\u0010\u0098\u0001\u001a\u00020KJ\u0007\u0010\u0099\u0001\u001a\u00020KJ\u0007\u0010\u009a\u0001\u001a\u00020\u001dJ\u0007\u0010\u009b\u0001\u001a\u00020\u001dJ\u0007\u0010\u009c\u0001\u001a\u00020\u001dJ\u0007\u0010\u009d\u0001\u001a\u00020\u001dJ\u0007\u0010\u009e\u0001\u001a\u00020\u001dJ\u0007\u0010\u009f\u0001\u001a\u00020\u001dJ\u0007\u0010 \u0001\u001a\u00020\u001dJ\u0007\u0010¡\u0001\u001a\u00020\u001dJ\u0007\u0010¢\u0001\u001a\u00020\u001dJ\u0011\u0010£\u0001\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020<H\u0002J\t\u0010¤\u0001\u001a\u00020\u001dH\u0002J\u0007\u0010¥\u0001\u001a\u00020\u001dJ\t\u0010¦\u0001\u001a\u00020KH\u0002J\u0016\u0010§\u0001\u001a\u00020K2\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010zH\u0007J\u0007\u0010©\u0001\u001a\u00020KJ\u0007\u0010ª\u0001\u001a\u00020KJ\u0007\u0010«\u0001\u001a\u00020KJ\u0007\u0010¬\u0001\u001a\u00020KJ\u0007\u0010\u00ad\u0001\u001a\u00020KJ\u0007\u0010®\u0001\u001a\u00020KJ\u0007\u0010¯\u0001\u001a\u00020KJ\u0007\u0010°\u0001\u001a\u00020KJ\u0007\u0010±\u0001\u001a\u00020KJ\u0007\u0010²\u0001\u001a\u00020KJ\u0007\u0010³\u0001\u001a\u00020KJ\u0007\u0010´\u0001\u001a\u00020KJ\u0007\u0010µ\u0001\u001a\u00020KJ\u0007\u0010¶\u0001\u001a\u00020KJ\u0007\u0010·\u0001\u001a\u00020KJ\u0007\u0010¸\u0001\u001a\u00020KJ\n\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\t\u0010»\u0001\u001a\u00020<H\u0002J\u001e\u0010¼\u0001\u001a\u00020K2\u0007\u0010½\u0001\u001a\u00020<2\n\b\u0002\u0010¾\u0001\u001a\u00030\u0096\u0001H\u0002J\u001d\u0010¿\u0001\u001a\u00020K2\u0007\u0010½\u0001\u001a\u00020<2\t\b\u0002\u0010À\u0001\u001a\u00020<H\u0002J:\u0010Á\u0001\u001a\u00020K2\u0007\u0010½\u0001\u001a\u00020<2&\u0010Â\u0001\u001a!\u0012\u0016\u0012\u00140\u001d¢\u0006\u000f\bÄ\u0001\u0012\n\bÅ\u0001\u0012\u0005\b\b(Æ\u0001\u0012\u0004\u0012\u00020K0Ã\u0001H\u0002J\u0019\u0010Á\u0001\u001a\u00020\u001d2\u0007\u0010½\u0001\u001a\u00020<H\u0082@¢\u0006\u0003\u0010Ç\u0001J\t\u0010È\u0001\u001a\u00020KH\u0014J\u0019\u0010É\u0001\u001a\u00020\u001d2\u0007\u0010Ê\u0001\u001a\u00020zH\u0096@¢\u0006\u0003\u0010Ë\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u001d\u0010$\u001a\u0004\u0018\u00010%8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u001d\u0010*\u001a\u0004\u0018\u00010+8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b,\u0010-R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0004\n\u0002\u0010=R\u000e\u0010>\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010)\u001a\u0004\bB\u0010CR\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010)\u001a\u0004\bG\u0010HR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0\n¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\fR\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020b0\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010^R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020b0\n¢\u0006\b\n\u0000\u001a\u0004\be\u0010\fR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u000eX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020g0\u0011¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u0013R\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020n0mX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0017\u0010q\u001a\b\u0012\u0004\u0012\u00020n0m¢\u0006\b\n\u0000\u001a\u0004\br\u0010pR\u0010\u0010s\u001a\u0004\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010zX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010{\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020}0|X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u0004\u0018\u00010\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Í\u0001"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingViewModelV2;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseViewModel;", "<init>", "()V", "vuiModeDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "_wearStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingWearState;", "wearStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getWearStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_keyStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingKeyState;", "keyStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getKeyStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_linkStateFlow", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingLinkState;", "linkStateFlow", "getLinkStateFlow", "_networkStateFlow", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingNetworkState;", "networkStateFlow", "getNetworkStateFlow", "_deviceCallStateFlow", "", "deviceCallStateFlow", "getDeviceCallStateFlow", "_actionSharedFlow", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/ActionEventState;", "actionSharedFlow", "getActionSharedFlow", "doraService", "Lcom/larus/dora/api/IDoraService;", "getDoraService", "()Lcom/larus/dora/api/IDoraService;", "doraService$delegate", "Lkotlin/Lazy;", "doraServiceDevice", "Lcom/larus/dora/api/IDoraService$Device;", "getDoraServiceDevice", "()Lcom/larus/dora/api/IDoraService$Device;", "doraServiceDevice$delegate", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "linkCallback", "Lcom/larus/dora/api/IDoraLinkCallback;", "wearListener", "Lcom/larus/dora/api/wrapper/WearStateListener;", "voiceCallback", "Lcom/larus/dora/impl/log/SampleDoraVoiceCallback;", "player", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingBgMusicPlayerV2;", "soundPool", "Landroid/media/SoundPool;", "soundId", "", "Ljava/lang/Integer;", "mConfigLiveAI", "mHasConfigWiFi", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "session", "Lcom/larus/dora/api/IDoraService$Session;", "getSession", "()Lcom/larus/dora/api/IDoraService$Session;", "session$delegate", "fetchConfigLiveAI", "", "repeatCount", "fetchWifiConfig", "fetchLinkState", "fetchWearState", "updateLink", "state", "updateWear", "leftOn", "rightOn", "updateCall", "currentWearState", "keyEvent", "event", "pos", "wearKeyClear", "_avatarUiStateFlow", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/AvatarUiState;", "get_avatarUiStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "avatarUiStateFlow", "getAvatarUiStateFlow", "_wakeupQueryUiStateFlow", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/WakeupQueryUiState;", "get_wakeupQueryUiStateFlow", "wakeupQueryUiStateFlow", "getWakeupQueryUiStateFlow", "_ttsDataSharedFlow", "", "get_ttsDataSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "ttsDataSharedFlow", "getTtsDataSharedFlow", "_llmCallEventSharedFlow", "Lkotlinx/coroutines/channels/Channel;", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/LLMCallEventState;", "get_llmCallEventSharedFlow", "()Lkotlinx/coroutines/channels/Channel;", "llmCallEventSharedFlow", "getLlmCallEventSharedFlow", "mediaManager", "Lcom/larus/call_plugins_doubao_common/manager/DoraRealtimeCallMediaManager;", "mLLmListener", "Lcom/larus/dora/impl/plugin/IDoraLLMListener;", "mCameraListener", "Lcom/bytedance/dora/camera/IDoraCameraCallback;", "mCurQueryId", "", "mQueryImages", "Lcom/bytedance/frameworks/baselib/network/http/util/LRUCache;", "Lcom/bytedance/dora/camera/DoraImageInfo;", "mDoraBudsCallback", "Lcom/larus/dora/impl/util/SampleDoraBudsCallback;", "mPausePlayWelcomeMusic", "Lkotlinx/coroutines/Job;", "mReplayWelcomeMusic", "mVuiMode", "mTtsTaskId", "mTtsEmitJob", "mIsBackground", "playVideoCallTTS", "playWaitWakeUpTTS", "playWakeUpTTS", "emitTtsDataWithDelay", "data", "playTTS", "ttsText", "stopTTS", "reason", "isTTSPlay", "wakeUpClear", "initSuccessSound", "playWelcomeMusic", "pausePlayWelcomeMusic", "ts", "", "replayWelcomeMusic", "stopWelcomeMusic", "playSuccessMusic", "isBackground", "isConnected", "isWearState", "isNetAvailable", "isSupportNewOb", "isLiveAI", "hasConfigWiFi", "isEnvAuth", "isInCall", "isCallingByIdleState", "refreshCurrentDeviceCallState", "canContinue", "stopRecording", "enterOnboarding", "msg", "exitOnboarding", "exitVideoCall", "exitVoiceOnly", "againOnboarding", "retryEnterCurrentMode", "enterCheckWearMode", "enterTakePhotoMode", "enterVideoCallMode", "enterVoiceOnlyMode", "enterMediaControlMode", "forceWakeupState", "forceWaitingState", "invalidWear", "invalidLink", "onStart", "onStop", "getTargetLoudness", "", "getLoudNormAlgoType", "setVUIMode", "mode", "delayTs", "stopVUIMode", "code", "startVUI", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "succ", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "isDoraSupportOnboarding", "caller", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingViewModelV2 extends DoraOnboardingBaseViewModel {
    public static final b Companion = null;
    public static final String TAG = "DoraGOnboardingViewModelV2";
    private MutableSharedFlow<com.larus.dora.impl.onboarding.g.v2.viewmodel.a> _actionSharedFlow;
    private final z0<AvatarUiState> _avatarUiStateFlow;
    private final z0<Boolean> _deviceCallStateFlow;
    private MutableSharedFlow<n> _keyStateFlow;
    private z0<o> _linkStateFlow;
    private final Channel<z> _llmCallEventSharedFlow;
    private z0<Object> _networkStateFlow;
    private final MutableSharedFlow<byte[]> _ttsDataSharedFlow;
    private final z0<a0> _wakeupQueryUiStateFlow;
    private z0<y> _wearStateFlow;
    private final d1<com.larus.dora.impl.onboarding.g.v2.viewmodel.a> actionSharedFlow;
    private final i1<AvatarUiState> avatarUiStateFlow;
    private final i1<Boolean> deviceCallStateFlow;
    private final Lazy doraPageConfig$delegate;
    private final Lazy doraService$delegate;
    private final Lazy doraServiceDevice$delegate;
    private final d1<n> keyStateFlow;
    private t39.n linkCallback;
    private final i1<o> linkStateFlow;
    private final Channel<z> llmCallEventSharedFlow;
    private uj4.h mCameraListener;
    private boolean mConfigLiveAI;
    private String mCurQueryId;
    private r0 mDoraBudsCallback;
    private boolean mHasConfigWiFi;
    private volatile boolean mIsBackground;
    private m69.f mLLmListener;
    private Job mPausePlayWelcomeMusic;
    private final com.bytedance.frameworks.baselib.network.http.util.g<Integer, uj4.g> mQueryImages;
    private Job mReplayWelcomeMusic;
    private Job mTtsEmitJob;
    private String mTtsTaskId;
    private volatile int mVuiMode;
    private com.larus.call_plugins_doubao_common.manager.r mediaManager;
    private ConnectivityManager.NetworkCallback networkCallback;
    private final i1<Object> networkStateFlow;
    private l player;
    private final Lazy session$delegate;
    private Integer soundId;
    private SoundPool soundPool;
    private final d1<byte[]> ttsDataSharedFlow;
    private com.larus.dora.impl.log.q voiceCallback;
    private final ExecutorCoroutineDispatcher vuiModeDispatcher;
    private final i1<a0> wakeupQueryUiStateFlow;
    private h49.m wearListener;
    private final i1<y> wearStateFlow;

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$1$a */
        public static final class a implements t39.n {
            public final /* synthetic */ DoraGOnboardingViewModelV2 a;

            public a(DoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            public final void e(int r1, int r2, String r3, String r4) {
                Intrinsics.checkNotNullParameter(r3, "productName");
                DoraGOnboardingViewModelV2.access$updateLink(this.a, r1);
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$1$b */
        public static final class b implements h49.m {
            public final /* synthetic */ DoraGOnboardingViewModelV2 a;

            public b(DoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            @Override // h49.m
            public final void a(boolean r2, boolean r3) {
                DoraGOnboardingViewModelV2.access$updateWear(this.a, r2, r3);
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$1$c */
        public static final class c extends com.larus.dora.impl.log.q {
            public final /* synthetic */ DoraGOnboardingViewModelV2 a;

            public c(DoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            public final void w(int r3, int r4) {
                g49.d.d(DoraGOnboardingViewModelV2.TAG, "onKeyEvent, value: " + r3 + ", pos: " + r4);
                DoraGOnboardingViewModelV2.access$keyEvent(this.a, r3, r4);
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$1$d */
        public static final class d extends ConnectivityManager.NetworkCallback {
            public final /* synthetic */ DoraGOnboardingViewModelV2 a;

            public d(DoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r3) {
                Intrinsics.checkNotNullParameter(r3, "network");
                super.onAvailable(r3);
                DoraGOnboardingViewModelV2.access$get_networkStateFlow$p(this.a).setValue(new q(true));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r3) {
                Intrinsics.checkNotNullParameter(r3, "network");
                super.onLost(r3);
                DoraGOnboardingViewModelV2.access$get_networkStateFlow$p(this.a).setValue(new q(false));
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$1$e */
        public static final class e extends r0 {
            public final /* synthetic */ DoraGOnboardingViewModelV2 a;

            public e(DoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            public final void a1(DoraDevice r2, mj4.b r3) {
                Intrinsics.checkNotNullParameter(r3, "state");
                DoraGOnboardingViewModelV2.access$updateCall(this.a, r3.a);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                g49.d.c(DoraGOnboardingViewModelV2.TAG, "onidle state change err: ", th);
            }
        }

        public AnonymousClass1(DoraGOnboardingViewModelV2 r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r3);
            DoraGOnboardingViewModelV2.enterOnboarding$default(this.this$0, null, 1, null);
            DoraGOnboardingViewModelV2 r4 = this.this$0;
            a r0 = new a(r4);
            IDoraService r1 = r4.getDoraService();
            if (r1 == null) goto L7;
            r1.G(r0);
        L7:
            DoraGOnboardingViewModelV2.access$setLinkCallback$p(r4, r0);
            DoraGOnboardingViewModelV2 r5 = this.this$0;
            b r2 = new b(r5);
            IDoraService.d r6 = r5.getDoraServiceDevice();
            if (r6 == null) goto L10;
            r6.d(r2);
        L10:
            DoraGOnboardingViewModelV2.access$setWearListener$p(r5, r2);
            DoraGOnboardingViewModelV2 r7 = this.this$0;
            c r8 = new c(r7);
            kj4.a.g().registerDoraVoiceCallback(r8);
            DoraGOnboardingViewModelV2.access$setVoiceCallback$p(r7, r8);
            DoraGOnboardingViewModelV2.access$setNetworkCallback$p(this.this$0, new d(this.this$0));
            DoraGOnboardingViewModelV2 r9 = this.this$0;
            e r10 = new e(r9);
            kj4.a.g().k(r10);
            DoraGOnboardingViewModelV2.access$setMDoraBudsCallback$p(r9, r10);
            this.this$0.fetchLinkState();
            this.this$0.fetchWearState();
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements uj4.h {
        public final /* synthetic */ DoraGOnboardingViewModelV2 a;

        public final void b(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, long r15, int r17, int r18, int r110) {
        }

        public final void d(DoraDataFrame r1) {
        }

        public final void g(DoraVisionQueryTrackInfo r1) {
        }

        public final void j(boolean r1, int r2, byte r3) {
        }

        public a(DoraGOnboardingViewModelV2 r1) {
            this.a = r1;
        }

        public final void e(uj4.g r2, uj4.a r3) {
            Intrinsics.checkNotNullParameter(r2, "doraImageInfo");
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "camera complete image:" + r2.a);
            DoraGOnboardingViewModelV2.access$getMQueryImages$p(this.a).d(Integer.valueOf(r2.a), r2);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements l68.b {
        public final /* synthetic */ DoraGOnboardingViewModelV2 a;

        public final void c(TtsEventEnum r1, String r2, int r3, String r4, Map<String, ? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r1, "event");
            Intrinsics.checkNotNullParameter(r2, "customErrorMsg");
            Intrinsics.checkNotNullParameter(r4, "ext");
            Intrinsics.checkNotNullParameter(r5, "extMap");
        }

        public final void e(TtsLifeState r1, String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "lifeState");
        }

        public c(DoraGOnboardingViewModelV2 r1) {
            this.a = r1;
        }

        public final void a(TtsTracer r2) {
            Intrinsics.checkNotNullParameter(r2, "tracer");
        }

        public final void d(TtsState r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "tts client onState change " + r3 + ", cur wakeup query " + this.a.get_wakeupQueryUiStateFlow().getValue());
            if (r3 != TtsState.TTS_STARTED) goto L8;
            if (this.a.get_avatarUiStateFlow().getValue() != AvatarUiState.WAITING) goto L8;
            this.a.get_avatarUiStateFlow().setValue(AvatarUiState.SPEAKING);
        L8:
            if (r3 == TtsState.TTS_STOPPED) goto L10;
            return;
        L10:
            if (CollectionsKt.listOf(new a0[]{a0.e.a, a0.d.a}).contains(this.a.get_wakeupQueryUiStateFlow().getValue()) == false) goto L14;
            this.a.get_avatarUiStateFlow().setValue(AvatarUiState.WAITING);
            return;
        }

        public final void b(byte[] r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "data");
            if (this.a.get_avatarUiStateFlow().getValue() != AvatarUiState.SPEAKING) goto L6;
            DoraGOnboardingViewModelV2.access$emitTtsDataWithDelay(this.a, r2);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$canContinue$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$canContinue$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {934}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isInCall;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03761(boolean r1, DoraGOnboardingViewModelV2 r2, Continuation<? super C03761> r3) {
            this.$isInCall = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03761(this.$isInCall, this.this$0, r4);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            if (this.$isInCall == false) goto L14;
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "canContinublocke ed by device call, emit dialog action");
            MutableSharedFlow r7 = DoraGOnboardingViewModelV2.access$get_actionSharedFlow$p(this.this$0);
            com.larus.dora.impl.onboarding.g.v2.viewmodel.a.C0088a r2 = new com.larus.dora.impl.onboarding.g.v2.viewmodel.a.C0088a(ActionEvent.DIALOG, 0);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$currentWearState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$currentWearState$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03771(DoraGOnboardingViewModelV2 r1, Continuation<? super C03771> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03771(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r6);
            DoraDevice r7 = kj4.a.g().c();
            if (r7 != null) goto L8;
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "get cur wear state device is null, return");
            return Unit.INSTANCE;
        L8:
            String r1 = r7.mac;
            DoraOnboardingDevice r2 = this.this$0.getDoraOnboardingDevice();
            if (r2 == null) goto L11;
            String r3 = r2.b;
        L13:
            if (Intrinsics.areEqual(r1, r3) == true) goto L16;
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "get cur wear state device mac !=  ob mac");
            return Unit.INSTANCE;
        L16:
            int[] r8 = r7.wearState;
            z0 r0 = DoraGOnboardingViewModelV2.access$get_wearStateFlow$p(this.this$0);
            boolean r4 = false;
            if (r8 == null) goto L24;
            Integer r9 = ArraysKt.getOrNull(r8, 0);
            if (r9 == null) goto L24;
            if (r9.intValue() != 1) goto L24;
            r4 = true;
        L24:
            r0.setValue(new y.b(r4, System.currentTimeMillis()));
            return Unit.INSTANCE;
        L11:
            r3 = null;
            goto L13
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$emitTtsDataWithDelay$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$emitTtsDataWithDelay$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {672, 673, 676}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $data;
        final /* synthetic */ Job $prev;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03781(byte[] r1, Job r2, DoraGOnboardingViewModelV2 r3, Continuation<? super C03781> r4) {
            this.$data = r1;
            this.$prev = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03781(this.$data, this.$prev, this.this$0, r5);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r7);
        L25:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "emit tts data: " + this.$data);
        L27:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r7);
        L20:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "onAudio data try emit , " + this.$data);
            if (this.this$0.get_avatarUiStateFlow().getValue() != AvatarUiState.SPEAKING) goto L27;
            MutableSharedFlow<byte[]> r8 = this.this$0.get_ttsDataSharedFlow();
            byte[] r2 = this.$data;
            this.label = 3;
            if (r8.emit(r2, this) != r0) goto L25;
            return r0;
        L11:
            ResultKt.throwOnFailure(r7);
        L17:
            this.label = 2;
            if (DelayKt.delay(300, this) != r0) goto L20;
            return r0;
        L12:
            ResultKt.throwOnFailure(r7);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "onAudio data start , " + this.$data);
            Job r9 = this.$prev;
            if (r9 == null) goto L17;
            this.label = 1;
            if (r9.join(this) != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$enterOnboarding$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$enterOnboarding$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $msg;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03791(String r1, DoraGOnboardingViewModelV2 r2, Continuation<? super C03791> r3) {
            this.$msg = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03791(this.$msg, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "enter onboarding, due to: " + this.$msg);
            b0.a.getClass();
            b0.j().storeBoolean("dora_need_show_audio_settings_dialog", true);
            DoraGOnboardingViewModelV2.access$startVUI(this.this$0, 4, new x());
            this.this$0.initSuccessSound();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$enterVoiceOnlyMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$enterVoiceOnlyMode$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03801(DoraGOnboardingViewModelV2 r1, Continuation<? super C03801> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03801(this.this$0, r3);
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
            this.this$0.playWaitWakeUpTTS();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$exitOnboarding$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$exitOnboarding$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03811(DoraGOnboardingViewModelV2 r1, Continuation<? super C03811> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03811(this.this$0, r3);
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
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "exit onboarding");
            boolean r3 = com.larus.dora.impl.onboarding.d.a;
            com.larus.dora.impl.onboarding.d.b = false;
            DoraGOnboardingViewModelV2.access$stopRecording(this.this$0);
            this.this$0.stopWelcomeMusic();
            DoraGOnboardingViewModelV2.access$stopVUIMode(this.this$0, OnboardingVUIMode.STOP_ONBOARDING);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$fetchConfigLiveAI$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$fetchConfigLiveAI$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {211, 215}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $repeatCount;
        int I$0;
        int I$1;
        Object L$0;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03821(int r1, DoraGOnboardingViewModelV2 r2, Continuation<? super C03821> r3) {
            this.$repeatCount = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03821(this.$repeatCount, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0057 -> B:22:0x0070). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006d -> B:22:0x0070). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            int r2 = this.I$1;
            int r4 = this.I$0;
            DoraGOnboardingViewModelV2 r5 = (DoraGOnboardingViewModelV2) this.L$0;
            ResultKt.throwOnFailure(r11);
            DoraGOnboardingViewModelV2 r6 = r5;
            C03821 r7 = this;
        L22:
            int r12 = r4;
            int r8 = r2 + 1;
            DoraGOnboardingViewModelV2 r3 = r6;
        L11:
            if (r8 >= r12) goto L23;
            DoraGGestureSettingsRepository r9 = DoraGGestureSettingsRepository.a;
            r7.L$0 = r3;
            r7.I$0 = r12;
            r7.I$1 = r8;
            r7.label = 1;
            Object r10 = r9.d(r7);
            if (r10 != r0) goto L15;
            return r0;
        L15:
            int r13 = r8;
            r4 = r12;
            r11 = r10;
            r6 = r3;
            r2 = r13;
        L16:
            Boolean r14 = (Boolean) r11;
            if (r14 == null) goto L19;
            DoraGOnboardingViewModelV2.access$setMConfigLiveAI$p(r6, r14.booleanValue());
            goto L22
        L19:
            r7.L$0 = r6;
            r7.I$0 = r4;
            r7.I$1 = r2;
            r7.label = 2;
            if (DelayKt.delay(200, r7) != r0) goto L22;
            return r0;
        L23:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "fetch gesture config, cur button config is " + DoraGOnboardingViewModelV2.access$getMConfigLiveAI$p(r7.this$0));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r2 = this.I$1;
            r4 = this.I$0;
            DoraGOnboardingViewModelV2 r15 = (DoraGOnboardingViewModelV2) this.L$0;
            ResultKt.throwOnFailure(r11);
            r6 = r15;
            r7 = this;
            goto L16
        L10:
            ResultKt.throwOnFailure(r11);
            r12 = this.$repeatCount;
            r3 = this.this$0;
            r8 = 0;
            r7 = this;
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$fetchWearState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$fetchWearState$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03831(DoraGOnboardingViewModelV2 r1, Continuation<? super C03831> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03831(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x008f -> B:28:0x0092). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.I$1;
            int r4 = this.I$0;
            DoraGOnboardingViewModelV2 r5 = (DoraGOnboardingViewModelV2) this.L$0;
            ResultKt.throwOnFailure(r12);
            C03831 r13 = this;
        L28:
            r2 = r2 + 1;
        L9:
            if (r2 >= r4) goto L30;
            if (Intrinsics.areEqual(DoraGOnboardingViewModelV2.access$get_wearStateFlow$p(r5).getValue(), y.a.a) == false) goto L25;
            int[] r6 = kj4.a.g().C();
            if (r6.length != 0) goto L15;
            boolean r7 = true;
        L17:
            if ((!r7) == false) goto L25;
            if (r6[0] <= 0) goto L25;
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "take buds wear state: " + r6[0]);
            z0 r8 = DoraGOnboardingViewModelV2.access$get_wearStateFlow$p(r5);
            if (r6[0] != 1) goto L31;
            y.b r9 = new y.b(true, System.currentTimeMillis());
            r8.setValue(r9);
            goto L28
        L31:
            r9 = new y.b(false, System.currentTimeMillis());
            r8.setValue(r9);
            goto L28
        L15:
            r7 = false;
        L25:
            r13.L$0 = r5;
            r13.I$0 = r4;
            r13.I$1 = r2;
            r13.label = 1;
            if (DelayKt.delay(200, r13) != r0) goto L28;
            return r0;
        L30:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            r5 = this.this$0;
            r2 = 0;
            r4 = 2;
            r13 = this;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$fetchWifiConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$fetchWifiConfig$1", f = "DoraGOnboardingViewModelV2.kt", i = {0}, l = {1227}, m = "invokeSuspend", n = {"convertor$iv"}, s = {"L$0"})
    public static final class C03841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$fetchWifiConfig$1$a */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends TypeToken<DoraWifiResponse<DoraWifiList>> {
            public a() {
            }
        }

        public C03841(DoraGOnboardingViewModelV2 r1, Continuation<? super C03841> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03841(this.this$0, r3);
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
            w39.a r2 = (w39.a) this.L$0;
            ResultKt.throwOnFailure(r7);
        L12:
            com.larus.dora.impl.core.request.v2.a r8 = (com.larus.dora.impl.core.request.v2.a) r7;
            if ((r8 instanceof com.larus.dora.impl.core.request.v2.a.b) == true) goto L37;
            g49.d.b("DoraRequestXV2", "request<T>: failed, " + r8);
            Result.Companion r3 = Result.Companion;
            Object r9 = Result.constructor-impl(ResultKt.createFailure(new Exception("Request failed: " + r8)));
        L22:
            DoraGOnboardingViewModelV2 r4 = this.this$0;
            if (Result.isSuccess-impl(r9) == false) goto L32;
            DoraWifiList r5 = (DoraWifiList) ((DoraWifiResponse) r9).getData();
            if (r5 == null) goto L29;
            List<DoraWifiEntity> r6 = r5.getWifiList();
            if (r6 == null) goto L29;
            boolean r10 = !r6.isEmpty();
        L30:
            DoraGOnboardingViewModelV2.access$setMHasConfigWiFi$p(r4, r10);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "fetch wifi config success, cur config wifi: " + DoraGOnboardingViewModelV2.access$getMHasConfigWiFi$p(r4));
        L29:
            r10 = false;
        L32:
            if (Result.exceptionOrNull-impl(r9) == null) goto L35;
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "fetch wifi config failure");
        L35:
            return Unit.INSTANCE;
        L37:
            Type r11 = new a().getType();     // Catch: Throwable -> L19
            byte[] r12 = ((com.larus.dora.impl.core.request.v2.a.b) r8).a;     // Catch: Throwable -> L19
            Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L19
            Object r13 = r2.a(r12, r11);     // Catch: Throwable -> L19
            if (r13 != null) goto L17;
            g49.d.b("DoraRequestXV2", "request<T>: parse error, data is null");     // Catch: Throwable -> L19
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L19
            r9 = Result.constructor-impl(ResultKt.createFailure(new Exception("data is null")));     // Catch: Throwable -> L19
        L36:
            goto L22
        L17:
            r9 = Result.constructor-impl(r13);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            g49.d.c("DoraRequestXV2", "request<T>: parse error", th);
            Result.Companion r15 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            DoraRequestXV2 r16 = DoraRequestXV2.a;
            bl4.c r17 = new bl4.c();
            Lazy<w39.d> r18 = w39.d.b;
            w39.d r20 = w39.d.a.a();
            this.L$0 = r20;
            this.label = 1;
            r7 = r16.a(r17, 3000, this);
            if (r7 != r0) goto L11;
            return r0;
        L11:
            r2 = r20;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$invalidLink$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$invalidLink$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {1048}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03851(DoraGOnboardingViewModelV2 r1, Continuation<? super C03851> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03851(this.this$0, r3);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "invalid link state");
            this.this$0.get_avatarUiStateFlow().setValue(AvatarUiState.WAITING);
            Channel<z> r9 = this.this$0.get_llmCallEventSharedFlow();
            z.a r2 = new z.a(LLMCallEvent.LINK, Boxing.boxInt(100), System.currentTimeMillis());
            this.label = 1;
            if (r9.send(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$invalidWear$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$invalidWear$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {1040}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03861(DoraGOnboardingViewModelV2 r1, Continuation<? super C03861> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03861(this.this$0, r3);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "invalid wear state");
            this.this$0.get_avatarUiStateFlow().setValue(AvatarUiState.WAITING);
            Channel<z> r9 = this.this$0.get_llmCallEventSharedFlow();
            z.a r2 = new z.a(LLMCallEvent.WEAR, Boxing.boxInt(101), System.currentTimeMillis());
            this.label = 1;
            if (r9.send(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$keyEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$keyEvent$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $event;
        final /* synthetic */ int $pos;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03871(DoraGOnboardingViewModelV2 r1, int r2, int r3, Continuation<? super C03871> r4) {
            this.this$0 = r1;
            this.$event = r2;
            this.$pos = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03871(this.this$0, this.$event, this.$pos, r5);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            MutableSharedFlow r9 = DoraGOnboardingViewModelV2.access$get_keyStateFlow$p(this.this$0);
            n.a r2 = new n.a(this.$event, this.$pos, System.currentTimeMillis());
            this.label = 1;
            if (r9.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$pausePlayWelcomeMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$pausePlayWelcomeMusic$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {832}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $reason;
        final /* synthetic */ long $ts;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03881(String r1, DoraGOnboardingViewModelV2 r2, long r3, Continuation<? super C03881> r5) {
            this.$reason = r1;
            this.this$0 = r2;
            this.$ts = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03881(this.$reason, this.this$0, this.$ts, r8);
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
        L11:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "pause welcome music, due to " + this.$reason);
            l r6 = DoraGOnboardingViewModelV2.access$getPlayer$p(this.this$0);
            if (r6 == null) goto L15;
            long r2 = this.$ts;
            int r3 = l.g;
            t0.e(new g(r6, r2, null));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            if (DelayKt.delay(300, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playSuccessMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playSuccessMusic$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03891(DoraGOnboardingViewModelV2 r1, Continuation<? super C03891> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03891(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r9);
            Integer r10 = DoraGOnboardingViewModelV2.access$getSoundId$p(this.this$0);
            if (r10 == null) goto L10;
            DoraGOnboardingViewModelV2 r0 = this.this$0;
            int r2 = r10.intValue();
            SoundPool r1 = DoraGOnboardingViewModelV2.access$getSoundPool$p(r0);
            if (r1 == null) goto L10;
            Boxing.boxInt(r1.play(r2, 1.0f, 1.0f, 1, 0, 1.0f));
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playVideoCallTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playVideoCallTTS$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03901(DoraGOnboardingViewModelV2 r1, Continuation<? super C03901> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03901(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L21;
            ResultKt.throwOnFailure(r3);
            DoraSetting.a.getClass();
            DoraGOnboardingConfig r4 = DoraSetting.c();
            if (r4 == null) goto L9;
            DoraGOnboardingOpenRemark r5 = r4.getOpenRemark();
            if (r5 == null) goto L9;
            String r6 = r5.getAiLiveScene();
        L10:
            if (r6 != null) goto L12;
        L15:
            boolean r0 = true;
        L16:
            if (r0 == false) goto L18;
            int r7 = j0.a;
            r6 = j0.d(2131902823);
        L18:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "play video call tts");
            DoraGOnboardingViewModelV2.access$playTTS(this.this$0, r6);
            return Unit.INSTANCE;
        L12:
            if (r6.length() == 0) goto L15;
            r0 = false;
        L9:
            r6 = null;
            goto L10
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playWaitWakeUpTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playWaitWakeUpTTS$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {644}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03911(DoraGOnboardingViewModelV2 r1, Continuation<? super C03911> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03911(this.this$0, r3);
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
        L15:
            DoraSetting.a.getClass();
            DoraGOnboardingConfig r7 = DoraSetting.c();
            if (r7 == null) goto L20;
            DoraGOnboardingOpenRemark r8 = r7.getOpenRemark();
            if (r8 == null) goto L20;
            String r9 = r8.getQueryScene();
        L21:
            if (r9 != null) goto L23;
        L26:
            if (r2 == false) goto L28;
            int r10 = j0.a;
            r9 = j0.d(2131902821);
        L28:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "play wait wakeup tts");
            DoraGOnboardingViewModelV2.access$playTTS(this.this$0, r9);
            return Unit.INSTANCE;
        L23:
            if (r9.length() == 0) goto L26;
            r2 = false;
        L20:
            r9 = null;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            if (DoraGOnboardingViewModelV2.access$getMConfigLiveAI$p(this.this$0) == false) goto L15;
            if (this.this$0.isTTSPlay() == false) goto L15;
            this.label = 1;
            if (DelayKt.delay(2500, this) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playWakeUpTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playWakeUpTTS$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {657}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03921(DoraGOnboardingViewModelV2 r1, Continuation<? super C03921> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03921(this.this$0, r3);
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
            DoraSetting.a.getClass();
            DoraGOnboardingConfig r7 = DoraSetting.c();
            if (r7 == null) goto L16;
            DoraGOnboardingOpenRemark r8 = r7.getOpenRemark();
            if (r8 == null) goto L16;
            String r9 = r8.getQueryGuide();
        L17:
            if (r9 != null) goto L19;
        L22:
            if (r2 == false) goto L24;
            int r10 = j0.a;
            r9 = j0.d(2131902822);
        L24:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "play wakeup tts");
            DoraGOnboardingViewModelV2.access$playTTS(this.this$0, r9);
            return Unit.INSTANCE;
        L19:
            if (r9.length() == 0) goto L22;
            r2 = false;
        L16:
            r9 = null;
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playWelcomeMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$playWelcomeMusic$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03931(DoraGOnboardingViewModelV2 r1, Continuation<? super C03931> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03931(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "start welcome music");
            l r4 = DoraGOnboardingViewModelV2.access$getPlayer$p(this.this$0);
            if (r4 == null) goto L7;
            int r0 = l.g;
            r4.d(null);
            r4.b();
        L7:
            DoraGOnboardingViewModelV2 r5 = this.this$0;
            l r1 = new l();
            l.c(r1, AppHost.a.getApplication());
            DoraGOnboardingViewModelV2.access$setPlayer$p(r5, r1);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$replayWelcomeMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$replayWelcomeMusic$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {842}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $reason;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03941(DoraGOnboardingViewModelV2 r1, String r2, Continuation<? super C03941> r3) {
            this.this$0 = r1;
            this.$reason = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03941(this.this$0, this.$reason, r4);
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
            if (this.this$0.isBackground() == false) goto L14;
        L23:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "replay welcome no exec, reason = " + this.$reason + ", because isBack: " + this.this$0.isBackground() + ", isConnect: " + this.this$0.isConnected() + ", isInCall:" + this.this$0.isInCall());
            return Unit.INSTANCE;
        L14:
            if (this.this$0.isConnected() == false) goto L23;
            if (this.this$0.isInCall() == true) goto L23;
            l r5 = DoraGOnboardingViewModelV2.access$getPlayer$p(this.this$0);
            if (r5 == null) goto L22;
            l.c(r5, AppHost.a.getApplication());
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            if (DelayKt.delay(1000, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$retryEnterCurrentMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$retryEnterCurrentMode$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {993}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03951(DoraGOnboardingViewModelV2 r1, Continuation<? super C03951> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03951(this.this$0, r3);
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
        L13:
            DoraGOnboardingViewModelV2 r5 = this.this$0;
            DoraGOnboardingViewModelV2.access$setVUIMode(r5, DoraGOnboardingViewModelV2.access$getMVuiMode$p(r5), 400);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            if (DoraGOnboardingViewModelV2.access$getMVuiMode$p(this.this$0) == 0) goto L15;
            this.label = 1;
            if (DelayKt.delay(1200, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$setVUIMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$setVUIMode$1", f = "DoraGOnboardingViewModelV2.kt", i = {0, 1}, l = {1084, 1088, 1091}, m = "invokeSuspend", n = {"setVUIMode", "setVUIMode"}, s = {"L$0", "L$0"})
    public static final class C03961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayTs;
        final /* synthetic */ int $mode;
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C03961(int r1, DoraGOnboardingViewModelV2 r2, long r3, Continuation<? super C03961> r5) {
            this.$mode = r1;
            this.this$0 = r2;
            this.$delayTs = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03961(this.$mode, this.this$0, this.$delayTs, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r15);
            C03961 r10 = this;
        L31:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "set vui mode: " + r10.$mode + " with start ob vui, result: " + ((Boolean) r15).booleanValue());
        L33:
            DoraGOnboardingViewModelV2.access$setMVuiMode$p(r10.this$0, r10.$mode);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r2 = this.I$1;
            long r6 = this.J$0;
            int r8 = this.I$0;
            DoraGOnboardingViewModelV2 r9 = (DoraGOnboardingViewModelV2) this.L$1;
            Ref.BooleanRef r11 = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(r15);
            Ref.BooleanRef r16 = r11;
            r10 = this;
        L25:
            int r12 = r8;
            int r13 = r2 + 1;
            DoraGOnboardingViewModelV2 r3 = r9;
            int r14 = r12;
        L13:
            if (r13 >= r14) goto L27;
            r10.L$0 = r16;
            r10.L$1 = r3;
            r10.I$0 = r14;
            r10.J$0 = r6;
            r10.I$1 = r13;
            r10.label = 1;
            Object r17 = DoraGOnboardingViewModelV2.access$startVUI(r3, 4, r10);
            if (r17 != r0) goto L17;
            return r0;
        L17:
            Ref.BooleanRef r18 = r16;
            r15 = r17;
            int r110 = r14;
            r9 = r3;
            r2 = r13;
            r8 = r110;
        L19:
            if (((Boolean) r15).booleanValue() == false) goto L21;
            r18.element = true;
        L24:
            r16 = r18;
            goto L25
        L21:
            r10.L$0 = r18;
            r10.L$1 = r9;
            r10.I$0 = r8;
            r10.J$0 = r6;
            r10.I$1 = r2;
            r10.label = 2;
            if (DelayKt.delay(r6, r10) != r0) goto L24;
            return r0;
        L35:
            r16 = r18;
            goto L25
        L27:
            if (r16.element == false) goto L32;
            kj4.a r111 = kj4.a.g();
            int r4 = r10.$mode;
            r10.L$0 = null;
            r10.L$1 = null;
            r10.label = 3;
            r15 = DoraAdapterExtKt.L(r111, r4);
            if (r15 != r0) goto L31;
            return r0;
        L32:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "set vui mode " + r10.$mode + " no success, due to start ob failed ");
            goto L33
        L11:
            r2 = this.I$1;
            r6 = this.J$0;
            r8 = this.I$0;
            r9 = (DoraGOnboardingViewModelV2) this.L$1;
            Ref.BooleanRef r112 = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(r15);
            r18 = r112;
            r10 = this;
            goto L19
        L12:
            ResultKt.throwOnFailure(r15);
            r16 = new Ref.BooleanRef();
            r3 = this.this$0;
            r6 = this.$delayTs;
            r13 = 0;
            r10 = this;
            r14 = 3;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$startVUI$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$startVUI$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {1113}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $mode;
        final /* synthetic */ Function1<Boolean, Unit> $onSuccess;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C03971(int r1, Function1<? super Boolean, Unit> r2, Continuation<? super C03971> r3) {
            this.$mode = r1;
            this.$onSuccess = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03971(this.$mode, this.$onSuccess, r4);
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
        L11:
            boolean r5 = ((Boolean) r4).booleanValue();
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "startVUIMode: " + this.$mode + ", result=" + r5);
            this.$onSuccess.invoke(Boxing.boxBoolean(r5));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            kj4.a r6 = kj4.a.g();
            int r2 = this.$mode;
            this.label = 1;
            r4 = DoraAdapterExtKt.N(r6, r2);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$stopRecording$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$stopRecording$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C03981(Continuation<? super C03981> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C03981(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            kj4.a.g().c.d.i(1, 13, new byte[]{4, 1, 1});
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$stopVUIMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$stopVUIMode$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {1106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $code;
        final /* synthetic */ int $mode;
        int label;

        public C03991(int r1, int r2, Continuation<? super C03991> r3) {
            this.$mode = r1;
            this.$code = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03991(this.$mode, this.$code, r4);
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
        L11:
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "stop vui mode: " + this.$mode + ", code: " + this.$code + ", result: " + ((Boolean) r5).booleanValue());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            kj4.a r6 = kj4.a.g();
            int r2 = this.$mode;
            int r3 = this.$code;
            this.label = 1;
            r5 = DoraAdapterExtKt.P(r6, r2, r3);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$updateLink$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$updateLink$1", f = "DoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $state;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C04001(DoraGOnboardingViewModelV2 r1, int r2, Continuation<? super C04001> r3) {
            this.this$0 = r1;
            this.$state = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04001(this.this$0, this.$state, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L37;
            ResultKt.throwOnFailure(r12);
            DoraOnboardingDevice r13 = this.this$0.getDoraOnboardingDevice();
            if (r13 == null) goto L7;
            String r14 = r13.b;
        L8:
            z0 r1 = DoraGOnboardingViewModelV2.access$get_linkStateFlow$p(this.this$0);
            IDoraService r3 = this.this$0.getDoraService();
            if (r3 == null) goto L13;
            DeviceService r4 = r3.device();
            if (r4 == null) goto L13;
            boolean r5 = r4.J();
        L14:
            r1.setValue(new o.b(r5));
            StringBuilder r2 = new StringBuilder("update link: cur mac is empty: ");
            if (r14 != null) goto L17;
            Boolean r15 = null;
        L22:
            r2.append(r15);
            r2.append(", cur link state: ");
            r2.append(this.$state);
            r2.append(", value = ");
            Object r16 = DoraGOnboardingViewModelV2.access$get_linkStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingLinkState.State");
            r2.append(((o.b) r16).a);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, r2.toString());
            Object r17 = DoraGOnboardingViewModelV2.access$get_linkStateFlow$p(this.this$0).getValue();
            if ((r17 instanceof o.b) == false) goto L25;
            o.b r18 = (o.b) r17;
        L26:
            if (r18 != null) goto L28;
        L30:
            boolean r110 = false;
        L31:
            if (r110 == false) goto L33;
            DoraGOnboardingViewModelV2.pausePlayWelcomeMusic$default(this.this$0, "link is disconnect", 0, 2, null);
        L35:
            return Unit.INSTANCE;
        L33:
            DoraGOnboardingViewModelV2.fetchConfigLiveAI$default(this.this$0, 0, 1, null);
            this.this$0.fetchWifiConfig();
            this.this$0.fetchWearState();
            this.this$0.replayWelcomeMusic("link is connected");
            this.this$0.retryEnterCurrentMode();
            goto L35
        L28:
            if (r18.a == true) goto L30;
            r110 = true;
            goto L31
        L25:
            r18 = null;
            goto L26
        L17:
            if (r14.length() != 0) goto L19;
            boolean r111 = true;
        L20:
            r15 = Boxing.boxBoolean(r111);
            goto L22
        L19:
            r111 = false;
        L13:
            r5 = false;
            goto L14
        L7:
            r14 = null;
            goto L8
        L37:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$updateWear$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2$updateWear$1", f = "DoraGOnboardingViewModelV2.kt", i = {1}, l = {289, 293}, m = "invokeSuspend", n = {"wearState"}, s = {"I$0"})
    public static final class C04011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $leftOn;
        final /* synthetic */ boolean $rightOn;
        int I$0;
        int I$1;
        Object L$0;
        int label;
        final /* synthetic */ DoraGOnboardingViewModelV2 this$0;

        public C04011(boolean r1, boolean r2, DoraGOnboardingViewModelV2 r3, Continuation<? super C04011> r4) {
            this.$leftOn = r1;
            this.$rightOn = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04011(this.$leftOn, this.$rightOn, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v10, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0076 -> B:20:0x0079). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = false;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r12);
            C04011 r13 = this;
            ?? r4 = r2;
        L32:
            StringBuilder r5 = new StringBuilder("cur wear state: ");
            if (r4 == 0) goto L35;
            r3 = true;
        L35:
            r5.append(r3);
            r5.append(", value = ");
            Object r14 = DoraGOnboardingViewModelV2.access$get_wearStateFlow$p(r13.this$0).getValue();
            Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingWearState.State");
            r5.append(((y.b) r14).a);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, r5.toString());
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            int r6 = this.I$1;
            int r7 = this.I$0;
            DoraGOnboardingViewModelV2 r8 = (DoraGOnboardingViewModelV2) this.L$0;
            ResultKt.throwOnFailure(r12);
            r13 = this;
        L20:
            r6 = r6 + 1;
        L12:
            if (r6 >= r7) goto L22;
            DoraOnboardingDevice r9 = r8.getDoraOnboardingDevice();
            if (r9 == null) goto L16;
            if (0 != 0) goto L20;
            goto L20
        L16:
            if (r9.b != null) goto L20;
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "cur dora onboarding device mac is null, don't update wear ");
            r13.L$0 = r8;
            r13.I$0 = r7;
            r13.I$1 = r6;
            r13.label = 1;
            if (DelayKt.delay(100, r13) != r0) goto L20;
            return r0;
        L22:
            if (r13.$leftOn == false) goto L24;
        L27:
            ?? r10 = 1;
        L28:
            z0 r11 = DoraGOnboardingViewModelV2.access$get_wearStateFlow$p(r13.this$0);
            y.b r15 = new y.b(r10, System.currentTimeMillis());
            r13.L$0 = null;
            r13.I$0 = r10;
            r13.label = 2;
            if (r11.emit(r15, r13) != r0) goto L31;
            return r0;
        L31:
            r4 = r10;
            goto L32
        L24:
            if (r13.$rightOn == true) goto L27;
            r10 = 0;
            goto L28
        L10:
            ResultKt.throwOnFailure(r12);
            g49.d.d(DoraGOnboardingViewModelV2.TAG, "update wear left: " + this.$leftOn + ", right: " + this.$rightOn);
            r8 = this.this$0;
            r6 = 0;
            r7 = 3;
            r13 = this;
            goto L12
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ Unit No(DoraGOnboardingViewModelV2 r0) {
        return stopWelcomeMusic$lambda$11(r0);
    }

    public static /* synthetic */ IDoraService Oo() {
        return doraService_delegate$lambda$1();
    }

    public static /* synthetic */ IDoraPageConfig Po() {
        return doraPageConfig_delegate$lambda$3();
    }

    public static /* synthetic */ Thread Qo(Runnable r0) {
        return vuiModeDispatcher$lambda$0(r0);
    }

    public static /* synthetic */ IDoraService.h So() {
        return session_delegate$lambda$4();
    }

    public static /* synthetic */ IDoraService.d To(DoraGOnboardingViewModelV2 r0) {
        return doraServiceDevice_delegate$lambda$2(r0);
    }

    private final boolean isCallingByIdleState(int r2) {
        if (((r2 >> 1) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final void wearKeyClear() {
        this.linkCallback = null;
        this.wearListener = null;
        SoundPool r1 = this.soundPool;
        if (r1 == null) goto L5;
        r1.release();
    L5:
        this.soundPool = null;
        this.soundId = null;
    }

    public final void enterMediaControlMode() {
        setVUIMode$default(this, 5, 0, 2, null);
    }

    public final void enterVoiceOnlyMode() {
        setVUIMode$default(this, 6, 0, 2, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C03801(this, null), 2, null);
    }

    public final void exitVideoCall() {
        stopVUIMode$default(this, 3, 0, 2, null);
    }

    public final void exitVoiceOnly() {
        stopVUIMode$default(this, 3, 0, 2, null);
    }

    public final void onStart() {
        this.mIsBackground = false;
        replayWelcomeMusic("onStart");
    }

    public final void onStop() {
        this.mIsBackground = true;
        pausePlayWelcomeMusic("onStop", 600);
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$3() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private static final IDoraService doraService_delegate$lambda$1() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final int getLoudNormAlgoType() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        com.larus.home.impl.sdk.s r2 = r0.s0();
        if (r2 == null) goto L9;
        if (r2.isDoraConnected() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        return 1;
    L12:
        m58.q r4 = m58.h.d;
        if (r4 == null) goto L19;
        TTSModule r5 = r4.d();
        if (r5 == null) goto L19;
        if (r5.e() != true) goto L19;
        r1 = true;
    L19:
        if (r1 == false) goto L22;
        return 1;
    L22:
        return z2.a.getLoudnessConfig().c;
    L9:
        r3 = false;
        goto L10
    }

    private final IDoraService.h getSession() {
        return (IDoraService.h) this.session$delegate.getValue();
    }

    private final float getTargetLoudness() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r1 = false;
        if (r0 == null) goto L9;
        com.larus.home.impl.sdk.s r2 = r0.s0();
        if (r2 == null) goto L9;
        if (r2.isDoraConnected() != true) goto L9;
        boolean r3 = true;
    L10:
        Float r4 = null;
        if (r3 == false) goto L26;
        m58.q r5 = m58.h.d;
        if (r5 == null) goto L25;
        TTSModule r6 = r5.d();
        if (r6 == null) goto L25;
        Float r7 = Float.valueOf(r6.a());
        if (r7.floatValue() != 0.0f) goto L20;
        r1 = true;
    L20:
        if ((!r1) == false) goto L22;
        r4 = r7;
    L22:
        if (r4 == null) goto L25;
        return r4.floatValue();
    L25:
        return z2.a.getLoudnessConfig().b;
    L26:
        m58.q r8 = m58.h.d;
        if (r8 == null) goto L39;
        TTSModule r9 = r8.d();
        if (r9 == null) goto L39;
        Float r10 = Float.valueOf(r9.b());
        if (r10.floatValue() != 0.0f) goto L34;
        r1 = true;
    L34:
        if ((!r1) == false) goto L36;
        r4 = r10;
    L36:
        if (r4 == null) goto L39;
        return r4.floatValue();
    L39:
        return z2.a.getLoudnessConfig().a;
    L9:
        r3 = false;
        goto L10
    }

    private final boolean refreshCurrentDeviceCallState() {
        boolean r0 = ((Boolean) this._deviceCallStateFlow.getValue()).booleanValue();
        DoraDevice r1 = DoraAdapterExtKt.h(kj4.a.g());
        int r2 = 0;
        if (r1 == null) goto L9;
        int[] r3 = r1.idleState;
        if (r3 == null) goto L9;
        Integer r4 = ArraysKt.getOrNull(r3, 0);
        if (r4 == null) goto L9;
        r2 = r4.intValue();
    L9:
        boolean r5 = isCallingByIdleState(r2);
        this._deviceCallStateFlow.setValue(Boolean.valueOf(r5));
        g49.d.d(TAG, "refreshCurrentDeviceCallState idleState=" + r2 + ", binary=" + Integer.toBinaryString(r2) + ", oldCallState=" + r0 + ", refreshedCallState=" + r5);
        return r5;
    }

    private static final IDoraService.h session_delegate$lambda$4() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    private final void stopRecording() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C03981(null), 3, null);
    }

    public final void againOnboarding() {
        this._avatarUiStateFlow.setValue(AvatarUiState.WAITING);
        this._wakeupQueryUiStateFlow.setValue(a0.d.a);
        this.mCurQueryId = null;
        this.mQueryImages.a();
    }

    public final void enterCheckWearMode() {
        setVUIMode$default(this, 12, 0, 2, null);
    }

    public final void enterTakePhotoMode() {
        setVUIMode$default(this, 13, 0, 2, null);
    }

    public final void enterVideoCallMode() {
        setVUIMode$default(this, 14, 0, 2, null);
    }

    public final void exitOnboarding() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C03811(this, null), 3, null);
    }

    public final void fetchLinkState() {
        g49.d.d(TAG, "fetch link state");
        DoraOnboardingDevice r1 = getDoraOnboardingDevice();
        Boolean r2 = null;
        if (r1 == null) goto L6;
        String r3 = r1.b;
        if (r3 == null) goto L6;
    L10:
        z0<o> r4 = this._linkStateFlow;
        IDoraService r5 = getDoraService();
        boolean r6 = false;
        if (r5 == null) goto L15;
        DeviceService r7 = r5.device();
        if (r7 == null) goto L15;
        boolean r8 = r7.J();
    L16:
        r4.setValue(new o.b(r8));
        StringBuilder r9 = new StringBuilder("fetch link state: cur mac is empty: ");
        if (r3 != null) goto L19;
    L22:
        r9.append(r2);
        r9.append(", value = ");
        Object r10 = this._linkStateFlow.getValue();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingLinkState.State");
        r9.append(((o.b) r10).a);
        g49.d.d(TAG, r9.toString());
        return;
    L19:
        if (r3.length() != 0) goto L21;
        r6 = true;
    L21:
        r2 = Boolean.valueOf(r6);
    L15:
        r8 = false;
    L6:
        DoraDevice r11 = kj4.a.g().c();
        if (r11 == null) goto L9;
        r3 = r11.mac;
        goto L10
    L9:
        r3 = null;
        goto L10
    }

    public final void forceWaitingState() {
        this._avatarUiStateFlow.setValue(AvatarUiState.WAITING);
        this._wakeupQueryUiStateFlow.setValue(a0.d.a);
    }

    public final IDoraService getDoraService() {
        return (IDoraService) this.doraService$delegate.getValue();
    }

    public final IDoraService.d getDoraServiceDevice() {
        return (IDoraService.d) this.doraServiceDevice$delegate.getValue();
    }

    public final void initSuccessSound() {
        if (this.soundPool != null) goto L6;
        this.soundPool = new SoundPool.Builder().build();
    L6:
        if (this.soundId != null) goto L20;
        com.larus.dora.impl.util.u.a.getClass();
        AssetFileDescriptor r0 = com.larus.dora.impl.util.u.d();
        if (r0 == null) goto L25;
        SoundPool r1 = this.soundPool;     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        Integer r2 = Integer.valueOf(r1.load(r0, 1));     // Catch: Throwable -> L15
    L13:
        this.soundId = r2;     // Catch: Throwable -> L15
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r0, null);
        return;
    L12:
        r2 = null;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    L25:
        return;
    }

    public final boolean isConnected() {
        Object r0 = this._linkStateFlow.getValue();
        if ((r0 instanceof o.b) == false) goto L5;
        o.b r1 = (o.b) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.a != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isInCall() {
        return ((Boolean) this._deviceCallStateFlow.getValue()).booleanValue();
    }

    public final boolean isNetAvailable() {
        Object r0 = this._networkStateFlow.getValue();
        if ((r0 instanceof q) == false) goto L5;
        q r1 = (q) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.a != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean isTTSPlay() {
        IFlowTtsClientService r0 = (IFlowTtsClientService) ServiceManager.get().getService(IFlowTtsClientService.class);
        if (r0 != null) goto L7;
        g49.d.d(TAG, "is tts playing err, due to tts client is null");
        return true;
    L7:
        return r0.a();
    }

    public final boolean isWearState() {
        Object r0 = this._wearStateFlow.getValue();
        if ((r0 instanceof y.b) == false) goto L5;
        y.b r1 = (y.b) r0;
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L15;
        CopyOnWriteArraySet r3 = t69.g.a;
        if (t69.g.b() == true) goto L15;
        return false;
    L15:
        return true;
    L9:
        if (r1.a != true) goto L11;
        r2 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    public final void stopWelcomeMusic() {
        g49.d.d(TAG, "stop welcome music");
        l r0 = this.player;
        if (r0 == null) goto L6;
        t0.e(new g(r0, 5000, new w(this)));
        return;
    }

    public DoraGOnboardingViewModelV2() {
        this.vuiModeDispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new r()));
        StateFlowImpl r0 = j1.a(y.a.a);
        this._wearStateFlow = r0;
        this.wearStateFlow = r0;
        MutableSharedFlow<n> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._keyStateFlow = r3;
        this.keyStateFlow = r3;
        StateFlowImpl r4 = j1.a(o.a.a);
        this._linkStateFlow = r4;
        this.linkStateFlow = r4;
        StateFlowImpl r5 = j1.a(p.a);
        this._networkStateFlow = r5;
        this.networkStateFlow = r5;
        StateFlowImpl r6 = j1.a(Boolean.FALSE);
        this._deviceCallStateFlow = r6;
        this.deviceCallStateFlow = r6;
        MutableSharedFlow<com.larus.dora.impl.onboarding.g.v2.viewmodel.a> r7 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionSharedFlow = r7;
        this.actionSharedFlow = r7;
        this.doraService$delegate = LazyKt.lazy(new s());
        this.doraServiceDevice$delegate = LazyKt.lazy(new t(this));
        this.mConfigLiveAI = true;
        this.doraPageConfig$delegate = LazyKt.lazy(new u());
        this.session$delegate = LazyKt.lazy(new v());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        StateFlowImpl r8 = j1.a(AvatarUiState.WAITING);
        this._avatarUiStateFlow = r8;
        this.avatarUiStateFlow = r8;
        StateFlowImpl r9 = j1.a(a0.d.a);
        this._wakeupQueryUiStateFlow = r9;
        this.wakeupQueryUiStateFlow = r9;
        MutableSharedFlow<byte[]> r10 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._ttsDataSharedFlow = r10;
        this.ttsDataSharedFlow = r10;
        Channel<z> r1 = ChannelKt.Channel$default(0, null, null, 7, null);
        this._llmCallEventSharedFlow = r1;
        this.llmCallEventSharedFlow = r1;
        this.mQueryImages = new com.bytedance.frameworks.baselib.network.http.util.g(5);
        this.mTtsTaskId = "";
        m69.f r2 = new AnonymousClass2(this);
        m69.c r11 = m69.c.a;
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) m69.c.b).add(r2);
        this.mLLmListener = r2;
        a r12 = new a(this);
        kj4.a.g().d.getClass();
        ((CopyOnWriteArraySet) uj4.b.h.c).add(r12);
        this.mCameraListener = r12;
    }

    private final void currentWearState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03771(this, null), 2, null);
    }

    public final boolean canContinue() {
        boolean r0 = refreshCurrentDeviceCallState();
        StringBuilder r1 = new StringBuilder("canContinue check, isInCall=");
        r1.append(r0);
        r1.append(", onboardingVuiMode=");
        r1.append(this.mVuiMode);
        r1.append(", sessionVuiMode=");
        IDoraService.h r2 = getSession();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.a());
    L6:
        r1.append(r3);
        g49.d.d(TAG, r1.toString());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03761(r0, this, null), 3, null);
        return !r0;
    L5:
        r3 = null;
        goto L6
    }

    public final void fetchWearState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03831(this, null), 2, null);
    }

    public final void fetchWifiConfig() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03841(this, null), 3, null);
    }

    public final void forceWakeupState() {
        stopWelcomeMusic();
        this._avatarUiStateFlow.setValue(AvatarUiState.WAITING);
        this._wakeupQueryUiStateFlow.setValue(a0.e.a);
    }

    public final void invalidLink() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03851(this, null), 3, null);
    }

    public final void invalidWear() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03861(this, null), 3, null);
    }

    public final boolean isEnvAuth() {
        IDoraPageConfig r0 = getDoraPageConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.d("dora_g_config_key_env_observe_enable", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isSupportNewOb() {
        DoraDevice r0 = kj4.a.g().c();
        g49.d.d(TAG, "is support new ob device: " + r0);
        int r1 = g0.a;
        if (r0 == null) goto L6;
        String r2 = r0.softVersion;
        if (r2 == null) goto L6;
    L8:
        if (g0.a(r2, "0.2.7.2420") < 0) goto L10;
        return true;
    L10:
        return false;
    L6:
        r2 = "0.0.0.0";
        goto L8
    }

    public void onCleared() {
        super.onCleared();
        boolean r0 = com.larus.dora.impl.onboarding.d.a;
        com.larus.dora.impl.onboarding.d.a = false;
        exitOnboarding();
        wakeUpClear();
        wearKeyClear();
    }

    public final void playSuccessMusic() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03891(this, null), 3, null);
    }

    public final void playVideoCallTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03901(this, null), 2, null);
    }

    public final void playWaitWakeUpTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03911(this, null), 2, null);
    }

    public final void playWakeUpTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03921(this, null), 2, null);
    }

    public final void playWelcomeMusic() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03931(this, null), 3, null);
    }

    public final void retryEnterCurrentMode() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03951(this, null), 3, null);
    }

    public final void wakeUpClear() {
        if (getDoraOnboardingDevice() == null) goto L11;
        DoraOnboardingDevice r0 = getDoraOnboardingDevice();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L11;
        return;
    L7:
        if (r0.i != 4096) goto L9;
        r1 = true;
    L11:
        g49.d.d(TAG, "dorag viewmodel clear");
        stopTTS("dorag viewmodel clear");
        com.larus.call_plugins_doubao_common.manager.r r2 = this.mediaManager;
        if (r2 == null) goto L14;
        r2.k();
    L14:
        uj4.h r3 = this.mCameraListener;
        if (r3 == null) goto L17;
        kj4.a.g().d.getClass();
        ((CopyOnWriteArraySet) uj4.b.h.c).remove(r3);
    L17:
        this.mCameraListener = null;
        m69.f r4 = this.mLLmListener;
        if (r4 == null) goto L20;
        m69.c r5 = m69.c.a;
        Intrinsics.checkNotNullParameter(r4, "listener");
        ((ArrayList) m69.c.b).remove(r4);
    L20:
        this.mLLmListener = null;
        this.mQueryImages.a();
    }

    public final d1<com.larus.dora.impl.onboarding.g.v2.viewmodel.a> getActionSharedFlow() {
        return this.actionSharedFlow;
    }

    public final i1<AvatarUiState> getAvatarUiStateFlow() {
        return this.avatarUiStateFlow;
    }

    public final i1<Boolean> getDeviceCallStateFlow() {
        return this.deviceCallStateFlow;
    }

    public final d1<n> getKeyStateFlow() {
        return this.keyStateFlow;
    }

    public final i1<o> getLinkStateFlow() {
        return this.linkStateFlow;
    }

    public final Channel<z> getLlmCallEventSharedFlow() {
        return this.llmCallEventSharedFlow;
    }

    public final i1<Object> getNetworkStateFlow() {
        return this.networkStateFlow;
    }

    public final d1<byte[]> getTtsDataSharedFlow() {
        return this.ttsDataSharedFlow;
    }

    public final i1<a0> getWakeupQueryUiStateFlow() {
        return this.wakeupQueryUiStateFlow;
    }

    public final i1<y> getWearStateFlow() {
        return this.wearStateFlow;
    }

    public final z0<AvatarUiState> get_avatarUiStateFlow() {
        return this._avatarUiStateFlow;
    }

    public final Channel<z> get_llmCallEventSharedFlow() {
        return this._llmCallEventSharedFlow;
    }

    public final MutableSharedFlow<byte[]> get_ttsDataSharedFlow() {
        return this._ttsDataSharedFlow;
    }

    public final z0<a0> get_wakeupQueryUiStateFlow() {
        return this._wakeupQueryUiStateFlow;
    }

    public final boolean hasConfigWiFi() {
        return this.mHasConfigWiFi;
    }

    public final boolean isBackground() {
        return this.mIsBackground;
    }

    public final boolean isLiveAI() {
        return this.mConfigLiveAI;
    }

    public static final /* synthetic */ boolean access$getMConfigLiveAI$p(DoraGOnboardingViewModelV2 r0) {
        return r0.mConfigLiveAI;
    }

    public static final /* synthetic */ String access$getMCurQueryId$p(DoraGOnboardingViewModelV2 r0) {
        return r0.mCurQueryId;
    }

    public static final /* synthetic */ boolean access$getMHasConfigWiFi$p(DoraGOnboardingViewModelV2 r0) {
        return r0.mHasConfigWiFi;
    }

    public static final /* synthetic */ com.bytedance.frameworks.baselib.network.http.util.g access$getMQueryImages$p(DoraGOnboardingViewModelV2 r0) {
        return r0.mQueryImages;
    }

    public static final /* synthetic */ int access$getMVuiMode$p(DoraGOnboardingViewModelV2 r0) {
        return r0.mVuiMode;
    }

    public static final /* synthetic */ l access$getPlayer$p(DoraGOnboardingViewModelV2 r0) {
        return r0.player;
    }

    public static final /* synthetic */ IDoraService.h access$getSession(DoraGOnboardingViewModelV2 r0) {
        return r0.getSession();
    }

    public static final /* synthetic */ Integer access$getSoundId$p(DoraGOnboardingViewModelV2 r0) {
        return r0.soundId;
    }

    public static final /* synthetic */ SoundPool access$getSoundPool$p(DoraGOnboardingViewModelV2 r0) {
        return r0.soundPool;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionSharedFlow$p(DoraGOnboardingViewModelV2 r0) {
        return r0._actionSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_deviceCallStateFlow$p(DoraGOnboardingViewModelV2 r0) {
        return r0._deviceCallStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_keyStateFlow$p(DoraGOnboardingViewModelV2 r0) {
        return r0._keyStateFlow;
    }

    public static final /* synthetic */ z0 access$get_linkStateFlow$p(DoraGOnboardingViewModelV2 r0) {
        return r0._linkStateFlow;
    }

    public static final /* synthetic */ z0 access$get_networkStateFlow$p(DoraGOnboardingViewModelV2 r0) {
        return r0._networkStateFlow;
    }

    public static final /* synthetic */ z0 access$get_wearStateFlow$p(DoraGOnboardingViewModelV2 r0) {
        return r0._wearStateFlow;
    }

    public static final /* synthetic */ void access$stopRecording(DoraGOnboardingViewModelV2 r0) {
        r0.stopRecording();
    }

    private static final IDoraService.d doraServiceDevice_delegate$lambda$2(DoraGOnboardingViewModelV2 r0) {
        IDoraService r1 = r0.getDoraService();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.device();
    }

    private final void emitTtsDataWithDelay(byte[] r8) {
        Job r0 = this.mTtsEmitJob;
        this.mTtsEmitJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03781(r8, r0, this, null), 3, null);
    }

    private final void playTTS(String r14) {
        stopWelcomeMusic();
        IFlowTtsClientService r1 = (IFlowTtsClientService) ServiceManager.get().getService(IFlowTtsClientService.class);
        if (r1 != null) goto L6;
        g49.d.d(TAG, "play tts err, due to tts client is null");
        return;
    L6:
        r1.f("onPlayNoticeTTS");
        r1.j(z2.a.J());
        String r2 = "DoraNotice" + System.currentTimeMillis();
        g49.d.d(TAG, "start tts taskId: " + this.mTtsTaskId);
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        String r3 = r0.v0();
    L10:
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L20;
        e10 r5 = e10.a;
        r3 = e10.f().a();
        if (r3 != null) goto L20;
        r3 = "";
    L20:
        String r6 = r3;
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L23;
        String r9 = r7.z();
    L24:
        IFlowTtsClientService.b.a(r1, r2, null, r14, r6, null, null, new c(this), r9, getTargetLoudness(), getLoudNormAlgoType(), 14450);
        return;
    L23:
        r9 = null;
        goto L24
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    L9:
        r3 = null;
        goto L10
    }

    private static final Unit stopWelcomeMusic$lambda$11(DoraGOnboardingViewModelV2 r1) {
        l r0 = r1.player;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        r1.player = null;
        return Unit.INSTANCE;
    }

    private final void updateCall(int r7) {
        boolean r0 = ((Boolean) this._deviceCallStateFlow.getValue()).booleanValue();
        boolean r1 = isCallingByIdleState(r7);
        this._deviceCallStateFlow.setValue(Boolean.valueOf(r1));
        StringBuilder r2 = new StringBuilder("updateCall rawState=");
        r2.append(r7);
        r2.append(", binary=");
        r2.append(Integer.toBinaryString(r7));
        r2.append(", bit2=");
        boolean r3 = true;
        if (((r7 >> 1) & 1) == 1) goto L6;
        r3 = false;
    L6:
        r2.append(r3);
        r2.append(", oldCallState=");
        r2.append(r0);
        r2.append(", newCallState=");
        r2.append(r1);
        r2.append(", currentVuiMode=");
        IDoraService.h r8 = getSession();
        if (r8 == null) goto L9;
        Integer r9 = Integer.valueOf(r8.a());
    L10:
        r2.append(r9);
        r2.append(", onboardingVuiMode=");
        r2.append(this.mVuiMode);
        g49.d.d(TAG, r2.toString());
        if (((Boolean) this._deviceCallStateFlow.getValue()).booleanValue() == false) goto L13;
        pausePlayWelcomeMusic$default(this, "call is donging", 0, 2, null);
        return;
    L13:
        replayWelcomeMusic("call is hang up");
        return;
    L9:
        r9 = null;
        goto L10
    }

    private final void updateLink(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C04001(this, r7, null), 2, null);
    }

    private static final Thread vuiModeDispatcher$lambda$0(Runnable r2) {
        return new PthreadThreadV2(r2, "dora_onboarding_vui_mode");
    }

    public final void enterOnboarding(String r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C03791(r7, this, null), 2, null);
    }

    public final void fetchConfigLiveAI(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03821(r7, this, null), 2, null);
    }

    public final void replayWelcomeMusic(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        g49.d.d(TAG, "replay welcome music, due to " + r10);
        Job r0 = this.mReplayWelcomeMusic;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.mReplayWelcomeMusic = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03941(this, r10, null), 3, null);
    }

    public final void stopTTS(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        g49.d.d(TAG, "stopTTS: reason=" + r5);
        IFlowTtsClientService r0 = (IFlowTtsClientService) ServiceManager.get().getService(IFlowTtsClientService.class);
        if (r0 != null) goto L6;
        g49.d.d(TAG, "play tts err, due to tts client is null");
        return;
    L6:
        g49.d.d(TAG, "stop tts taskId: " + this.mTtsTaskId);
        Job r1 = this.mTtsEmitJob;
        if (r1 == null) goto L9;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L9:
        r0.g(this.mTtsTaskId, false, r5);
    }

    public static final /* synthetic */ void access$emitTtsDataWithDelay(DoraGOnboardingViewModelV2 r0, byte[] r1) {
        r0.emitTtsDataWithDelay(r1);
    }

    public static final /* synthetic */ void access$playTTS(DoraGOnboardingViewModelV2 r0, String r1) {
        r0.playTTS(r1);
    }

    public static final /* synthetic */ void access$setLinkCallback$p(DoraGOnboardingViewModelV2 r0, t39.n r1) {
        r0.linkCallback = r1;
    }

    public static final /* synthetic */ void access$setMConfigLiveAI$p(DoraGOnboardingViewModelV2 r0, boolean r1) {
        r0.mConfigLiveAI = r1;
    }

    public static final /* synthetic */ void access$setMCurQueryId$p(DoraGOnboardingViewModelV2 r0, String r1) {
        r0.mCurQueryId = r1;
    }

    public static final /* synthetic */ void access$setMDoraBudsCallback$p(DoraGOnboardingViewModelV2 r0, r0 r1) {
        r0.mDoraBudsCallback = r1;
    }

    public static final /* synthetic */ void access$setMHasConfigWiFi$p(DoraGOnboardingViewModelV2 r0, boolean r1) {
        r0.mHasConfigWiFi = r1;
    }

    public static final /* synthetic */ void access$setMVuiMode$p(DoraGOnboardingViewModelV2 r0, int r1) {
        r0.mVuiMode = r1;
    }

    public static final /* synthetic */ void access$setNetworkCallback$p(DoraGOnboardingViewModelV2 r0, ConnectivityManager.NetworkCallback r1) {
        r0.networkCallback = r1;
    }

    public static final /* synthetic */ void access$setPlayer$p(DoraGOnboardingViewModelV2 r0, l r1) {
        r0.player = r1;
    }

    public static final /* synthetic */ void access$setVoiceCallback$p(DoraGOnboardingViewModelV2 r0, com.larus.dora.impl.log.q r1) {
        r0.voiceCallback = r1;
    }

    public static final /* synthetic */ void access$setWearListener$p(DoraGOnboardingViewModelV2 r0, h49.m r1) {
        r0.wearListener = r1;
    }

    public static final /* synthetic */ void access$stopVUIMode(DoraGOnboardingViewModelV2 r0, OnboardingVUIMode r1) {
        r0.stopVUIMode(r1);
    }

    public static final /* synthetic */ void access$updateCall(DoraGOnboardingViewModelV2 r0, int r1) {
        r0.updateCall(r1);
    }

    public static final /* synthetic */ void access$updateLink(DoraGOnboardingViewModelV2 r0, int r1) {
        r0.updateLink(r1);
    }

    private final void keyEvent(int r7, int r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03871(this, r7, r8, null), 3, null);
    }

    private final void setVUIMode(int r11, long r12) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C03961(r11, this, r12, null), 2, null);
    }

    private final void startVUI(int r7, Function1<? super Boolean, Unit> r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C03971(r7, r8, null), 2, null);
    }

    private final void stopVUIMode(int r7, int r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C03991(r7, r8, null), 2, null);
    }

    private final void updateWear(boolean r7, boolean r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04011(r7, r8, this, null), 3, null);
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel
    public Object isDoraSupportOnboarding(String r1, Continuation<? super Boolean> r2) {
        return Boxing.boxBoolean(true);
    }

    public final void pausePlayWelcomeMusic(String r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "reason");
        Job r0 = this.mPausePlayWelcomeMusic;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.mPausePlayWelcomeMusic = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03881(r13, this, r14, null), 3, null);
    }

    private final Object startVUI(int r1, Continuation<? super Boolean> r2) {
        return DoraAdapterExtKt.N(kj4.a.g(), r1);
    }

    public static final /* synthetic */ void access$keyEvent(DoraGOnboardingViewModelV2 r0, int r1, int r2) {
        r0.keyEvent(r1, r2);
    }

    public static final /* synthetic */ void access$setVUIMode(DoraGOnboardingViewModelV2 r0, int r1, long r2) {
        r0.setVUIMode(r1, r2);
    }

    public static final /* synthetic */ Object access$startVUI(DoraGOnboardingViewModelV2 r0, int r1, Continuation r2) {
        return r0.startVUI(r1, r2);
    }

    public static final /* synthetic */ void access$updateWear(DoraGOnboardingViewModelV2 r0, boolean r1, boolean r2) {
        r0.updateWear(r1, r2);
    }

    public static final /* synthetic */ void access$startVUI(DoraGOnboardingViewModelV2 r0, int r1, Function1 r2) {
        r0.startVUI(r1, r2);
    }

    public static /* synthetic */ void enterOnboarding$default(DoraGOnboardingViewModelV2 r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.enterOnboarding(r1);
    }

    public static /* synthetic */ void fetchConfigLiveAI$default(DoraGOnboardingViewModelV2 r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 3;
    L5:
        r0.fetchConfigLiveAI(r1);
    }

    public static /* synthetic */ void pausePlayWelcomeMusic$default(DoraGOnboardingViewModelV2 r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 300;
    L5:
        r0.pausePlayWelcomeMusic(r1, r2);
    }

    public static /* synthetic */ void setVUIMode$default(DoraGOnboardingViewModelV2 r0, int r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 100;
    L5:
        r0.setVUIMode(r1, r2);
    }

    public static /* synthetic */ void stopVUIMode$default(DoraGOnboardingViewModelV2 r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = BaiduNaviStatus.WRONG_AK_PARAM;
    L5:
        r0.stopVUIMode(r1, r2);
    }
}
