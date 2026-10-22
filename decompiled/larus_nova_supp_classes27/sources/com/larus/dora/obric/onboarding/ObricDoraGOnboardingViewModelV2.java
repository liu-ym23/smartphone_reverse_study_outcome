package com.larus.dora.obric.onboarding;

import android.app.Application;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.SoundPool;
import android.net.ConnectivityManager;
import android.net.Network;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.crash.Npth;
import com.bytedance.dora.camera.model.DoraVisionQueryTrackInfo;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.vision.DoraDataFrame;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.reflect.TypeToken;
import com.larus.audio.IFlowTtsClientService;
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
import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import com.larus.dora.impl.wlan.wifi.DoraWifiList;
import com.larus.dora.impl.wlan.wifi.DoraWifiResponse;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ð\u00012\u00020\u0001:\u0002ð\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020=J\u0006\u0010N\u001a\u00020LJ\u0006\u0010O\u001a\u00020LJ\u0006\u0010P\u001a\u00020LJ\u0010\u0010Q\u001a\u00020L2\u0006\u0010R\u001a\u00020=H\u0002J\u0018\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\u0003H\u0002J\u0010\u0010V\u001a\u00020L2\u0006\u0010R\u001a\u00020=H\u0002J\b\u0010W\u001a\u00020LH\u0002J\u0018\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020=H\u0002J\b\u0010[\u001a\u00020LH\u0002J\u0007\u0010\u0092\u0001\u001a\u00020LJ\u0007\u0010\u0093\u0001\u001a\u00020LJ\u0007\u0010\u0094\u0001\u001a\u00020LJ\u0012\u0010\u0095\u0001\u001a\u00020L2\u0007\u0010\u0096\u0001\u001a\u00020hH\u0002J$\u0010\u0097\u0001\u001a\u00020L2\u0007\u0010\u0098\u0001\u001a\u00020\u007f2\u0012\b\u0002\u0010\u0099\u0001\u001a\u000b\u0012\u0004\u0012\u00020L\u0018\u00010\u009a\u0001J$\u0010\u009b\u0001\u001a\u00020L2\u0007\u0010\u0098\u0001\u001a\u00020\u007f2\u0012\b\u0002\u0010\u0099\u0001\u001a\u000b\u0012\u0004\u0012\u00020L\u0018\u00010\u009a\u0001J\u0010\u0010\u009c\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020\u007fJ\u0010\u0010\u009e\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020\u007fJ\u0007\u0010\u009f\u0001\u001a\u00020\u0003J\u0007\u0010 \u0001\u001a\u00020LJ\t\u0010¡\u0001\u001a\u00020LH\u0007J\u0007\u0010¢\u0001\u001a\u00020LJ\u001c\u0010£\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020\u007f2\n\b\u0002\u0010¤\u0001\u001a\u00030¥\u0001J\u0010\u0010¦\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020\u007fJ\u0019\u0010§\u0001\u001a\u00020L2\u0007\u0010¨\u0001\u001a\u00020\u00032\u0007\u0010\u009d\u0001\u001a\u00020\u007fJ\u0007\u0010©\u0001\u001a\u00020LJ$\u0010ª\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020\u007f2\t\b\u0002\u0010«\u0001\u001a\u00020\u0003H\u0082@¢\u0006\u0003\u0010¬\u0001J\u001b\u0010\u00ad\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020\u007f2\u0007\u0010«\u0001\u001a\u00020\u0003H\u0002J\u0019\u0010®\u0001\u001a\u00020\u00032\u0007\u0010\u009d\u0001\u001a\u00020\u007fH\u0082@¢\u0006\u0003\u0010¯\u0001J\f\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0002J\u001a\u0010²\u0001\u001a\u00020\u00032\b\u0010³\u0001\u001a\u00030±\u0001H\u0082@¢\u0006\u0003\u0010´\u0001J\u0013\u0010µ\u0001\u001a\u00020L2\b\u0010³\u0001\u001a\u00030±\u0001H\u0002J\t\u0010¶\u0001\u001a\u00020LH\u0002J\t\u0010·\u0001\u001a\u00020LH\u0002J\u0015\u0010¸\u0001\u001a\u00020L2\n\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001H\u0002J\u0012\u0010»\u0001\u001a\u00020L2\u0007\u0010\u009d\u0001\u001a\u00020\u007fH\u0002J\u0007\u0010¼\u0001\u001a\u00020LJ\u0007\u0010½\u0001\u001a\u00020\u0003J\u0007\u0010¾\u0001\u001a\u00020\u0003J\u0007\u0010¿\u0001\u001a\u00020\u0003J\u0007\u0010À\u0001\u001a\u00020\u0003J\u0007\u0010Á\u0001\u001a\u00020\u0003J\u0007\u0010Â\u0001\u001a\u00020\u0003J\u0006\u0010@\u001a\u00020\u0003J\u0007\u0010Ã\u0001\u001a\u00020\u0003J\u0007\u0010Ä\u0001\u001a\u00020\u0003J\u0011\u0010Å\u0001\u001a\u00020\u00032\u0006\u0010R\u001a\u00020=H\u0002J\t\u0010Æ\u0001\u001a\u00020\u0003H\u0002J\u0007\u0010Ç\u0001\u001a\u00020\u0003J\t\u0010È\u0001\u001a\u00020LH\u0002J\u0016\u0010É\u0001\u001a\u00020L2\u000b\b\u0002\u0010Ê\u0001\u001a\u0004\u0018\u00010\u007fH\u0007J\u0007\u0010Ë\u0001\u001a\u00020LJ\u0007\u0010Ì\u0001\u001a\u00020LJ\u0007\u0010Í\u0001\u001a\u00020LJ\u0007\u0010Î\u0001\u001a\u00020LJ\u0007\u0010Ï\u0001\u001a\u00020LJ\u0007\u0010Ð\u0001\u001a\u00020LJ\u0007\u0010Ñ\u0001\u001a\u00020LJ\u0007\u0010Ò\u0001\u001a\u00020LJ\u001d\u0010Ó\u0001\u001a\u00020L2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u00032\t\b\u0002\u0010Ô\u0001\u001a\u00020\u0003J\u0007\u0010Õ\u0001\u001a\u00020LJ\u0007\u0010Ö\u0001\u001a\u00020LJ\u0007\u0010×\u0001\u001a\u00020LJ\u0007\u0010Ø\u0001\u001a\u00020LJ\u0007\u0010Ù\u0001\u001a\u00020LJ\u0007\u0010Ú\u0001\u001a\u00020LJ\u0007\u0010Û\u0001\u001a\u00020LJ\u0007\u0010Ü\u0001\u001a\u00020LJ\u0007\u0010Ý\u0001\u001a\u00020LJ\n\u0010Þ\u0001\u001a\u00030ß\u0001H\u0002J\t\u0010à\u0001\u001a\u00020=H\u0002J\u001e\u0010á\u0001\u001a\u00020L2\u0007\u0010â\u0001\u001a\u00020=2\n\b\u0002\u0010ã\u0001\u001a\u00030¥\u0001H\u0002J\u001d\u0010ä\u0001\u001a\u00020L2\u0007\u0010â\u0001\u001a\u00020=2\t\b\u0002\u0010å\u0001\u001a\u00020=H\u0002J:\u0010æ\u0001\u001a\u00020L2\u0007\u0010â\u0001\u001a\u00020=2&\u0010ç\u0001\u001a!\u0012\u0016\u0012\u00140\u0003¢\u0006\u000f\bé\u0001\u0012\n\bê\u0001\u0012\u0005\b\b(ë\u0001\u0012\u0004\u0012\u00020L0è\u0001H\u0002J\u0019\u0010æ\u0001\u001a\u00020\u00032\u0007\u0010â\u0001\u001a\u00020=H\u0082@¢\u0006\u0003\u0010ì\u0001J\t\u0010í\u0001\u001a\u00020LH\u0014J\u0019\u0010î\u0001\u001a\u00020\u00032\u0007\u0010ï\u0001\u001a\u00020\u007fH\u0096@¢\u0006\u0003\u0010¯\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u001d\u0010%\u001a\u0004\u0018\u00010&8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001d\u0010+\u001a\u0004\u0018\u00010,8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010.R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010*\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010*\u001a\u0004\bH\u0010IR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0017\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\f¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u000eR\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010_R\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020c0\f¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u000eR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020h0\u0013¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\u0015R\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020o0nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0017\u0010r\u001a\b\u0012\u0004\u0012\u00020o0n¢\u0006\b\n\u0000\u001a\u0004\bs\u0010qR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020L0\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010jR\u0017\u0010v\u001a\b\u0012\u0004\u0012\u00020L0\u0013¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\u0015R\u0010\u0010x\u001a\u0004\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u0004\u0018\u00010\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0080\u0001\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ñ\u0001"}, d2 = {"Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingViewModelV2;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseViewModel;", "shouldManageOnboardingVui", "", "<init>", "(Z)V", "vuiModeDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "_wearStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/obric/onboarding/DoraGOnboardingWearState;", "wearStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getWearStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_keyStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/obric/onboarding/DoraGOnboardingKeyState;", "keyStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getKeyStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_linkStateFlow", "Lcom/larus/dora/obric/onboarding/DoraGOnboardingLinkState;", "linkStateFlow", "getLinkStateFlow", "_networkStateFlow", "Lcom/larus/dora/obric/onboarding/DoraGOnboardingNetworkState;", "networkStateFlow", "getNetworkStateFlow", "_deviceCallStateFlow", "deviceCallStateFlow", "getDeviceCallStateFlow", "_actionSharedFlow", "Lcom/larus/dora/obric/onboarding/ActionEventState;", "actionSharedFlow", "getActionSharedFlow", "doraService", "Lcom/larus/dora/api/IDoraService;", "getDoraService", "()Lcom/larus/dora/api/IDoraService;", "doraService$delegate", "Lkotlin/Lazy;", "doraServiceDevice", "Lcom/larus/dora/api/IDoraService$Device;", "getDoraServiceDevice", "()Lcom/larus/dora/api/IDoraService$Device;", "doraServiceDevice$delegate", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "linkCallback", "Lcom/larus/dora/api/IDoraLinkCallback;", "wearListener", "Lcom/larus/dora/api/wrapper/WearStateListener;", "voiceCallback", "Lcom/larus/dora/impl/log/SampleDoraVoiceCallback;", "player", "Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/DoraGOnboardingBgMusicPlayerV2;", "soundPool", "Landroid/media/SoundPool;", "soundId", "", "Ljava/lang/Integer;", "configLiveAI", "hasConfigWiFi", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "session", "Lcom/larus/dora/api/IDoraService$Session;", "getSession", "()Lcom/larus/dora/api/IDoraService$Session;", "session$delegate", "fetchConfigLiveAI", "", "repeatCount", "fetchWifiConfig", "fetchLinkState", "fetchWearState", "updateLink", "state", "updateWear", "leftOn", "rightOn", "updateCall", "currentWearState", "keyEvent", "event", "pos", "wearKeyClear", "_avatarUiStateFlow", "Lcom/larus/dora/obric/onboarding/AvatarUiState;", "get_avatarUiStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "avatarUiStateFlow", "getAvatarUiStateFlow", "_wakeupQueryUiStateFlow", "Lcom/larus/dora/obric/onboarding/WakeupQueryUiState;", "get_wakeupQueryUiStateFlow", "wakeupQueryUiStateFlow", "getWakeupQueryUiStateFlow", "_ttsDataSharedFlow", "", "get_ttsDataSharedFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "ttsDataSharedFlow", "getTtsDataSharedFlow", "_llmCallEventSharedFlow", "Lkotlinx/coroutines/channels/Channel;", "Lcom/larus/dora/obric/onboarding/LLMCallEventState;", "get_llmCallEventSharedFlow", "()Lkotlinx/coroutines/channels/Channel;", "llmCallEventSharedFlow", "getLlmCallEventSharedFlow", "_llmCallStartedSharedFlow", "get_llmCallStartedSharedFlow", "llmCallStartedSharedFlow", "getLlmCallStartedSharedFlow", "mediaManager", "Lcom/larus/call_plugins_doubao_common/manager/DoraRealtimeCallMediaManager;", "llmListener", "Lcom/larus/dora/impl/plugin/IDoraLLMListener;", "cameraListener", "Lcom/bytedance/dora/camera/IDoraCameraCallback;", "currentQueryId", "", "queryImages", "Lcom/bytedance/frameworks/baselib/network/http/util/LRUCache;", "Lcom/bytedance/dora/camera/DoraImageInfo;", "doraBudsCallback", "Lcom/larus/dora/impl/util/SampleDoraBudsCallback;", "pausePlayWelcomeMusicJob", "Lkotlinx/coroutines/Job;", "replayWelcomeMusicJob", "pendingWelcomeMusicPlay", "isWelcomeMusicBluetoothReceiverRegistered", "isWelcomeMusicAllowed", "bluetoothStateReceiver", "Landroid/content/BroadcastReceiver;", "vuiMode", "shouldPlayWakeUpTTSOnLlmCallStarted", "ttsTaskId", "ttsEmitJob", "isInBackground", "playVideoCallTTS", "playWaitWakeUpTTS", "playWakeUpTTS", "emitTtsDataWithDelay", "data", "playTTS", "ttsText", "onFinished", "Lkotlin/Function0;", "playTTSAfterVuiModeReady", "stopTTS", "reason", "stopAllTTS", "isTTSPlay", "wakeUpClear", "initSuccessSound", "playWelcomeMusic", "pausePlayWelcomeMusic", "ts", "", "replayWelcomeMusic", "setWelcomeMusicAllowed", "allowed", "stopWelcomeMusic", "playWelcomeMusicWhenA2dpReady", "restart", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWelcomeMusicInternal", "ensureWelcomeMusicA2dpReady", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWelcomeMusicBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "isA2dpConnected", "device", "(Landroid/bluetooth/BluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectAllEnabledProfiles", "registerWelcomeMusicBluetoothReceiver", "unregisterWelcomeMusicBluetoothReceiver", "handleWelcomeMusicBluetoothEvent", "intent", "Landroid/content/Intent;", "maybeStartPendingWelcomeMusic", "playSuccessMusic", "isBackground", "isConnected", "isWearState", "isNetAvailable", "isSupportNewOb", "isLiveAI", "isEnvAuth", "isInCall", "isCallingByIdleState", "refreshCurrentDeviceCallState", "canContinue", "stopRecording", "enterOnboarding", "msg", "exitOnboarding", "exitVideoCall", "exitVoiceOnly", "againOnboarding", "retryEnterCurrentMode", "enterCheckWearMode", "enterTakePhotoMode", "enterVideoCallMode", "enterVoiceOnlyMode", "playWakeUpTTSOnLlmCallStarted", "enterMediaControlMode", "enterKeyReportMode", "enterLongPressWakeupMode", "forceWakeupState", "forceWaitingState", "invalidWear", "invalidLink", "onStart", "onStop", "getTargetLoudness", "", "getLoudNormAlgoType", "setVUIMode", "mode", "delayTs", "stopVUIMode", "code", "startVUI", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "succ", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "isDoraSupportOnboarding", "caller", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraGOnboardingViewModelV2 extends DoraOnboardingBaseViewModel {
    private static final long A2DP_STATE_QUERY_TIMEOUT_MS = 500;
    public static final b Companion = null;
    private static final int KEY_REPORT_MODE = 16;
    private static final int LONG_PRESS_WAKEUP_MODE = 17;
    public static final String TAG = "ObricDoraGOnboardingViewModelV2";
    private MutableSharedFlow<com.larus.dora.obric.onboarding.a> _actionSharedFlow;
    private final kotlinx.coroutines.flow.z0<AvatarUiState> _avatarUiStateFlow;
    private final kotlinx.coroutines.flow.z0<Boolean> _deviceCallStateFlow;
    private MutableSharedFlow<com.larus.dora.obric.onboarding.b> _keyStateFlow;
    private kotlinx.coroutines.flow.z0<c> _linkStateFlow;
    private final Channel<g> _llmCallEventSharedFlow;
    private final MutableSharedFlow<Unit> _llmCallStartedSharedFlow;
    private kotlinx.coroutines.flow.z0<Object> _networkStateFlow;
    private final MutableSharedFlow<byte[]> _ttsDataSharedFlow;
    private final kotlinx.coroutines.flow.z0<c2> _wakeupQueryUiStateFlow;
    private kotlinx.coroutines.flow.z0<f> _wearStateFlow;
    private final kotlinx.coroutines.flow.d1<com.larus.dora.obric.onboarding.a> actionSharedFlow;
    private final kotlinx.coroutines.flow.i1<AvatarUiState> avatarUiStateFlow;
    private BroadcastReceiver bluetoothStateReceiver;
    private uj4.h cameraListener;
    private boolean configLiveAI;
    private String currentQueryId;
    private final kotlinx.coroutines.flow.i1<Boolean> deviceCallStateFlow;
    private com.larus.dora.impl.util.r0 doraBudsCallback;
    private final Lazy doraPageConfig$delegate;
    private final Lazy doraService$delegate;
    private final Lazy doraServiceDevice$delegate;
    private boolean hasConfigWiFi;
    private volatile boolean isInBackground;
    private boolean isWelcomeMusicAllowed;
    private boolean isWelcomeMusicBluetoothReceiverRegistered;
    private final kotlinx.coroutines.flow.d1<com.larus.dora.obric.onboarding.b> keyStateFlow;
    private t39.n linkCallback;
    private final kotlinx.coroutines.flow.i1<c> linkStateFlow;
    private final Channel<g> llmCallEventSharedFlow;
    private final kotlinx.coroutines.flow.d1<Unit> llmCallStartedSharedFlow;
    private m69.f llmListener;
    private com.larus.call_plugins_doubao_common.manager.r mediaManager;
    private ConnectivityManager.NetworkCallback networkCallback;
    private final kotlinx.coroutines.flow.i1<Object> networkStateFlow;
    private Job pausePlayWelcomeMusicJob;
    private boolean pendingWelcomeMusicPlay;
    private com.larus.dora.impl.onboarding.g.v2.viewmodel.l player;
    private final com.bytedance.frameworks.baselib.network.http.util.g<Integer, uj4.g> queryImages;
    private Job replayWelcomeMusicJob;
    private final Lazy session$delegate;
    private final boolean shouldManageOnboardingVui;
    private volatile boolean shouldPlayWakeUpTTSOnLlmCallStarted;
    private Integer soundId;
    private SoundPool soundPool;
    private final kotlinx.coroutines.flow.d1<byte[]> ttsDataSharedFlow;
    private Job ttsEmitJob;
    private String ttsTaskId;
    private com.larus.dora.impl.log.q voiceCallback;
    private volatile int vuiMode;
    private final ExecutorCoroutineDispatcher vuiModeDispatcher;
    private final kotlinx.coroutines.flow.i1<c2> wakeupQueryUiStateFlow;
    private h49.m wearListener;
    private final kotlinx.coroutines.flow.i1<f> wearStateFlow;

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$1$a */
        public static final class a implements t39.n {
            public final /* synthetic */ ObricDoraGOnboardingViewModelV2 a;

            public a(ObricDoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            public final void e(int r1, int r2, String r3, String r4) {
                Intrinsics.checkNotNullParameter(r3, "productName");
                ObricDoraGOnboardingViewModelV2.access$updateLink(this.a, r1);
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$1$b */
        public static final class b implements h49.m {
            public final /* synthetic */ ObricDoraGOnboardingViewModelV2 a;

            public b(ObricDoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            @Override // h49.m
            public final void a(boolean r2, boolean r3) {
                ObricDoraGOnboardingViewModelV2.access$updateWear(this.a, r2, r3);
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$1$c */
        public static final class c extends com.larus.dora.impl.log.q {
            public final /* synthetic */ ObricDoraGOnboardingViewModelV2 a;

            public c(ObricDoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            public final void w(int r3, int r4) {
                g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "onKeyEvent, value: " + r3 + ", pos: " + r4);
                ObricDoraGOnboardingViewModelV2.access$keyEvent(this.a, r3, r4);
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$1$d */
        public static final class d extends ConnectivityManager.NetworkCallback {
            public final /* synthetic */ ObricDoraGOnboardingViewModelV2 a;

            public d(ObricDoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r3) {
                Intrinsics.checkNotNullParameter(r3, "network");
                super.onAvailable(r3);
                ObricDoraGOnboardingViewModelV2.access$get_networkStateFlow$p(this.a).setValue(new com.larus.dora.obric.onboarding.e(true));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r3) {
                Intrinsics.checkNotNullParameter(r3, "network");
                super.onLost(r3);
                ObricDoraGOnboardingViewModelV2.access$get_networkStateFlow$p(this.a).setValue(new com.larus.dora.obric.onboarding.e(false));
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$1$e */
        public static final class e extends com.larus.dora.impl.util.r0 {
            public final /* synthetic */ ObricDoraGOnboardingViewModelV2 a;

            public e(ObricDoraGOnboardingViewModelV2 r1) {
                this.a = r1;
            }

            public final void a1(DoraDevice r2, mj4.b r3) {
                Intrinsics.checkNotNullParameter(r3, "state");
                ObricDoraGOnboardingViewModelV2.access$updateCall(this.a, r3.a);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                g49.d.c(ObricDoraGOnboardingViewModelV2.TAG, "onidle state change err: ", th);
            }
        }

        public AnonymousClass1(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super AnonymousClass1> r2) {
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
            ObricDoraGOnboardingViewModelV2.enterOnboarding$default(this.this$0, null, 1, null);
            ObricDoraGOnboardingViewModelV2 r4 = this.this$0;
            a r0 = new a(r4);
            IDoraService r1 = r4.getDoraService();
            if (r1 == null) goto L7;
            r1.G(r0);
        L7:
            ObricDoraGOnboardingViewModelV2.access$setLinkCallback$p(r4, r0);
            ObricDoraGOnboardingViewModelV2 r5 = this.this$0;
            b r2 = new b(r5);
            IDoraService.d r6 = r5.getDoraServiceDevice();
            if (r6 == null) goto L10;
            r6.d(r2);
        L10:
            ObricDoraGOnboardingViewModelV2.access$setWearListener$p(r5, r2);
            ObricDoraGOnboardingViewModelV2 r7 = this.this$0;
            c r8 = new c(r7);
            kj4.a.g().registerDoraVoiceCallback(r8);
            ObricDoraGOnboardingViewModelV2.access$setVoiceCallback$p(r7, r8);
            ObricDoraGOnboardingViewModelV2.access$setNetworkCallback$p(this.this$0, new d(this.this$0));
            ObricDoraGOnboardingViewModelV2 r9 = this.this$0;
            e r10 = new e(r9);
            kj4.a.g().k(r10);
            ObricDoraGOnboardingViewModelV2.access$setDoraBudsCallback$p(r9, r10);
            this.this$0.fetchLinkState();
            this.this$0.fetchWearState();
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements uj4.h {
        public final /* synthetic */ ObricDoraGOnboardingViewModelV2 a;

        public final void b(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, long r15, int r17, int r18, int r110) {
        }

        public final void d(DoraDataFrame r1) {
        }

        public final void g(DoraVisionQueryTrackInfo r1) {
        }

        public final void j(boolean r1, int r2, byte r3) {
        }

        public a(ObricDoraGOnboardingViewModelV2 r1) {
            this.a = r1;
        }

        public final void e(uj4.g r2, uj4.a r3) {
            Intrinsics.checkNotNullParameter(r2, "doraImageInfo");
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "camera complete image:" + r2.a);
            ObricDoraGOnboardingViewModelV2.access$getQueryImages$p(this.a).d(Integer.valueOf(r2.a), r2);
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$canContinue$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$canContinue$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {1279}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isInCall;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05041(boolean r1, ObricDoraGOnboardingViewModelV2 r2, Continuation<? super C05041> r3) {
            this.$isInCall = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05041(this.$isInCall, this.this$0, r4);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "canContinue blocked by device call, emit dialog action");
            MutableSharedFlow r7 = ObricDoraGOnboardingViewModelV2.access$get_actionSharedFlow$p(this.this$0);
            com.larus.dora.obric.onboarding.a.C0108a r2 = new com.larus.dora.obric.onboarding.a.C0108a(ActionEvent.DIALOG, 0);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$currentWearState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$currentWearState$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05051(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05051> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05051(this.this$0, r3);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "get cur wear state device is null, return");
            return Unit.INSTANCE;
        L8:
            String r1 = r7.mac;
            DoraOnboardingDevice r2 = this.this$0.getDoraOnboardingDevice();
            if (r2 == null) goto L11;
            String r3 = r2.b;
        L13:
            if (Intrinsics.areEqual(r1, r3) == true) goto L16;
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "get cur wear state device mac !=  ob mac");
            return Unit.INSTANCE;
        L16:
            int[] r8 = r7.wearState;
            kotlinx.coroutines.flow.z0 r0 = ObricDoraGOnboardingViewModelV2.access$get_wearStateFlow$p(this.this$0);
            boolean r4 = false;
            if (r8 == null) goto L24;
            Integer r9 = ArraysKt.getOrNull(r8, 0);
            if (r9 == null) goto L24;
            if (r9.intValue() != 1) goto L24;
            r4 = true;
        L24:
            r0.setValue(new f.b(r4, System.currentTimeMillis()));
            return Unit.INSTANCE;
        L11:
            r3 = null;
            goto L13
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$emitTtsDataWithDelay$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$emitTtsDataWithDelay$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {751, 752, 755}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $data;
        final /* synthetic */ Job $prev;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05061(byte[] r1, Job r2, ObricDoraGOnboardingViewModelV2 r3, Continuation<? super C05061> r4) {
            this.$data = r1;
            this.$prev = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C05061(this.$data, this.$prev, this.this$0, r5);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "emit tts data: " + this.$data);
        L27:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r7);
        L20:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "onAudio data try emit , " + this.$data);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "onAudio data start , " + this.$data);
            Job r9 = this.$prev;
            if (r9 == null) goto L17;
            this.label = 1;
            if (r9.join(this) != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$ensureWelcomeMusicA2dpReady$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2", f = "ObricDoraGOnboardingViewModelV2.kt", i = {0, 0}, l = {1018}, m = "ensureWelcomeMusicA2dpReady", n = {"reason", "bluetoothDevice"}, s = {"L$0", "L$1"})
    public static final class C05071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05071(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05071> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ObricDoraGOnboardingViewModelV2.access$ensureWelcomeMusicA2dpReady(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$enterOnboarding$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$enterOnboarding$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $msg;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05081(String r1, ObricDoraGOnboardingViewModelV2 r2, Continuation<? super C05081> r3) {
            this.$msg = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05081(this.$msg, this.this$0, r4);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "enter onboarding, due to: " + this.$msg);
            com.larus.dora.impl.util.b0.a.getClass();
            com.larus.dora.impl.util.b0.j().storeBoolean("dora_need_show_audio_settings_dialog", true);
            ObricDoraGOnboardingViewModelV2.access$startVUI(this.this$0, 4, new s0());
            this.this$0.initSuccessSound();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$enterVoiceOnlyMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$enterVoiceOnlyMode$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05091(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05091> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05091(this.this$0, r3);
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$exitOnboarding$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$exitOnboarding$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05101(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05101> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05101(this.this$0, r3);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "exit onboarding");
            boolean r3 = com.larus.dora.impl.onboarding.d.a;
            com.larus.dora.impl.onboarding.d.b = false;
            ObricDoraGOnboardingViewModelV2.access$stopRecording(this.this$0);
            this.this$0.stopWelcomeMusic();
            ObricDoraGOnboardingViewModelV2.access$stopVUIMode(this.this$0, OnboardingVUIMode.STOP_ONBOARDING);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$fetchConfigLiveAI$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$fetchConfigLiveAI$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {226, 230}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $repeatCount;
        int I$0;
        int I$1;
        Object L$0;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05111(int r1, ObricDoraGOnboardingViewModelV2 r2, Continuation<? super C05111> r3) {
            this.$repeatCount = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05111(this.$repeatCount, this.this$0, r4);
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
            ObricDoraGOnboardingViewModelV2 r5 = (ObricDoraGOnboardingViewModelV2) this.L$0;
            ResultKt.throwOnFailure(r11);
            ObricDoraGOnboardingViewModelV2 r6 = r5;
            C05111 r7 = this;
        L22:
            int r12 = r4;
            int r8 = r2 + 1;
            ObricDoraGOnboardingViewModelV2 r3 = r6;
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
            ObricDoraGOnboardingViewModelV2.access$setConfigLiveAI$p(r6, r14.booleanValue());
            goto L22
        L19:
            r7.L$0 = r6;
            r7.I$0 = r4;
            r7.I$1 = r2;
            r7.label = 2;
            if (DelayKt.delay(200, r7) != r0) goto L22;
            return r0;
        L23:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "fetch gesture config, cur button config is " + ObricDoraGOnboardingViewModelV2.access$getConfigLiveAI$p(r7.this$0));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r2 = this.I$1;
            r4 = this.I$0;
            ObricDoraGOnboardingViewModelV2 r15 = (ObricDoraGOnboardingViewModelV2) this.L$0;
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$fetchWearState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$fetchWearState$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05121(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05121> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05121(this.this$0, r3);
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
            ObricDoraGOnboardingViewModelV2 r5 = (ObricDoraGOnboardingViewModelV2) this.L$0;
            ResultKt.throwOnFailure(r12);
            C05121 r13 = this;
        L28:
            r2 = r2 + 1;
        L9:
            if (r2 >= r4) goto L30;
            if (Intrinsics.areEqual(ObricDoraGOnboardingViewModelV2.access$get_wearStateFlow$p(r5).getValue(), f.a.a) == false) goto L25;
            int[] r6 = kj4.a.g().C();
            if (r6.length != 0) goto L15;
            boolean r7 = true;
        L17:
            if ((!r7) == false) goto L25;
            if (r6[0] <= 0) goto L25;
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "take buds wear state: " + r6[0]);
            kotlinx.coroutines.flow.z0 r8 = ObricDoraGOnboardingViewModelV2.access$get_wearStateFlow$p(r5);
            if (r6[0] != 1) goto L31;
            f.b r9 = new f.b(true, System.currentTimeMillis());
            r8.setValue(r9);
            goto L28
        L31:
            r9 = new f.b(false, System.currentTimeMillis());
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$fetchWifiConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$fetchWifiConfig$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {0}, l = {1608}, m = "invokeSuspend", n = {"convertor$iv"}, s = {"L$0"})
    public static final class C05131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$fetchWifiConfig$1$a */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/dora/impl/core/request/v2/DoraRequestXV2$request$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends TypeToken<DoraWifiResponse<DoraWifiList>> {
            public a() {
            }
        }

        public C05131(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05131> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05131(this.this$0, r3);
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
            ObricDoraGOnboardingViewModelV2 r4 = this.this$0;
            if (Result.isSuccess-impl(r9) == false) goto L32;
            DoraWifiList r5 = (DoraWifiList) ((DoraWifiResponse) r9).getData();
            if (r5 == null) goto L29;
            List<DoraWifiEntity> r6 = r5.getWifiList();
            if (r6 == null) goto L29;
            boolean r10 = !r6.isEmpty();
        L30:
            ObricDoraGOnboardingViewModelV2.access$setHasConfigWiFi$p(r4, r10);
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "fetch wifi config success, cur config wifi: " + ObricDoraGOnboardingViewModelV2.access$getHasConfigWiFi$p(r4));
        L29:
            r10 = false;
        L32:
            if (Result.exceptionOrNull-impl(r9) == null) goto L35;
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "fetch wifi config failure");
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$invalidLink$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$invalidLink$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {1422}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05141(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05141> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05141(this.this$0, r3);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "invalid link state");
            this.this$0.get_avatarUiStateFlow().setValue(AvatarUiState.WAITING);
            Channel<g> r9 = this.this$0.get_llmCallEventSharedFlow();
            g.a r2 = new g.a(LLMCallEvent.LINK, Boxing.boxInt(100), System.currentTimeMillis());
            this.label = 1;
            if (r9.send(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$invalidWear$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$invalidWear$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {1414}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05151(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05151> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05151(this.this$0, r3);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "invalid wear state");
            this.this$0.get_avatarUiStateFlow().setValue(AvatarUiState.WAITING);
            Channel<g> r9 = this.this$0.get_llmCallEventSharedFlow();
            g.a r2 = new g.a(LLMCallEvent.WEAR, Boxing.boxInt(101), System.currentTimeMillis());
            this.label = 1;
            if (r9.send(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$isA2dpConnected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {1051}, m = "isA2dpConnected", n = {}, s = {})
    public static final class C05161 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05161(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05161> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ObricDoraGOnboardingViewModelV2.access$isA2dpConnected(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$isA2dpConnected$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$isA2dpConnected$2", f = "ObricDoraGOnboardingViewModelV2.kt", i = {0}, l = {1603}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
    public static final class C05172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ BluetoothAdapter $adapter;
        final /* synthetic */ BluetoothDevice $device;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$isA2dpConnected$2$a */
        public static final class a implements Function1<Throwable, Unit> {
            public final /* synthetic */ CoroutineScope a;

            public a(CoroutineScope r1) {
                this.a = r1;
            }

            public final Object invoke(Object r2) {
                Throwable r3 = (Throwable) r2;
                Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
                Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
            L8:
                return Unit.INSTANCE;
            L5:
                th = move-exception;
                Result.Companion r0 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                goto L8
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$isA2dpConnected$2$b */
        public static final class b implements BluetoothProfile.ServiceListener {
            public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;
            public final /* synthetic */ BluetoothDevice b;
            public final /* synthetic */ BluetoothAdapter c;

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public final void onServiceDisconnected(int r2) {
                if (this.a.isActive() == false) goto L6;
                kotlinx.coroutines.i<Boolean> r3 = this.a;
                Result.Companion r0 = Result.Companion;
                r3.resumeWith(Result.constructor-impl(Boolean.FALSE));
                return;
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public final void onServiceConnected(int r6, BluetoothProfile r7) {
                BluetoothDevice r8 = this.b;
                Unit r1 = null;
                Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
                if ((r7 instanceof BluetoothA2dp) == false) goto L6;
                BluetoothA2dp r3 = (BluetoothA2dp) r7;     // Catch: Throwable -> L14
            L7:
                boolean r4 = false;
                if (r3 != null) goto L10;
            L12:
                Object r9 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L14
            L16:
                Throwable r5 = Result.exceptionOrNull-impl(r9);
                if (r5 == null) goto L19;
                g49.d.c(ObricDoraGOnboardingViewModelV2.TAG, "query A2DP connection state failed", r5);
            L19:
                Boolean r10 = Boolean.FALSE;
                if (Result.isFailure-impl(r9) == false) goto L22;
                r9 = r10;
            L22:
                boolean r11 = ((Boolean) r9).booleanValue();
                BluetoothAdapter r12 = this.c;
                if (r7 != null) goto L36;
            L27:
                Result.constructor-impl(r1);     // Catch: Throwable -> L25
            L31:
                if (this.a.isActive() == false) goto L38;
                this.a.resumeWith(Result.constructor-impl(Boolean.valueOf(r11)));
                return;
            L38:
                return;
            L25:
                th = move-exception;
                Result.Companion r0 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                goto L31
            L36:
                r12.closeProfileProxy(2, r7);     // Catch: Throwable -> L25
                r1 = Unit.INSTANCE;     // Catch: Throwable -> L25
                goto L27
            L10:
                if (r3.getConnectionState(r8) != 2) goto L12;
                r4 = true;
                goto L12
            L6:
                r3 = null;
            L14:
                th = move-exception;
                Result.Companion r13 = Result.Companion;
                r9 = Result.constructor-impl(ResultKt.createFailure(th));
                goto L16
            }

            public b(kotlinx.coroutines.j r1, BluetoothDevice r2, BluetoothAdapter r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        public C05172(BluetoothDevice r1, BluetoothAdapter r2, Continuation<? super C05172> r3) {
            this.$device = r1;
            this.$adapter = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C05172 r0 = new C05172(this.$device, this.$adapter, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            BluetoothAdapter r2 = (BluetoothAdapter) this.L$2;
            BluetoothDevice r3 = (BluetoothDevice) this.L$1;
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r7);
        L29:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            BluetoothDevice r5 = this.$device;
            BluetoothAdapter r6 = this.$adapter;
            this.L$0 = r8;
            this.L$1 = r5;
            this.L$2 = r6;
            this.label = 1;
            kotlinx.coroutines.j r9 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r9.C();
            b r10 = new b(r9, r5, r6);
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L11
            Object r12 = Result.constructor-impl(Boxing.boxBoolean(r6.getProfileProxy(AppHost.a.getApplication(), r10, 2)));     // Catch: Throwable -> L11
        L13:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L16;
            g49.d.c(ObricDoraGOnboardingViewModelV2.TAG, "get A2DP profile proxy failed", r13);
        L16:
            Boolean r14 = Boxing.boxBoolean(false);
            if (Result.isFailure-impl(r12) == false) goto L20;
            r12 = r14;
        L20:
            if (((Boolean) r12).booleanValue() == false) goto L22;
        L24:
            r9.i(new a(r8));
            r7 = r9.B();
            if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
            DebugProbesKt.probeCoroutineSuspended(this);
        L27:
            if (r7 != r0) goto L29;
            return r0;
        L22:
            if (r9.isActive() == false) goto L24;
            r9.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        L11:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$keyEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$keyEvent$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $event;
        final /* synthetic */ int $pos;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05181(int r1, int r2, ObricDoraGOnboardingViewModelV2 r3, Continuation<? super C05181> r4) {
            this.$event = r1;
            this.$pos = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C05181(this.$event, this.$pos, this.this$0, r5);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "emit key state, event=" + this.$event + ", pos=" + this.$pos);
            MutableSharedFlow r9 = ObricDoraGOnboardingViewModelV2.access$get_keyStateFlow$p(this.this$0);
            com.larus.dora.obric.onboarding.b.a r2 = new com.larus.dora.obric.onboarding.b.a(this.$event, this.$pos, System.currentTimeMillis());
            this.label = 1;
            if (r9.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$maybeStartPendingWelcomeMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$maybeStartPendingWelcomeMusic$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {1189}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $reason;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05191(ObricDoraGOnboardingViewModelV2 r1, String r2, Continuation<? super C05191> r3) {
            this.this$0 = r1;
            this.$reason = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05191(this.this$0, this.$reason, r4);
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
            boolean r3 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L22:
            if (((Boolean) r8).booleanValue() == true) goto L25;
        L38:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "pending welcome music not ready, reason=" + this.$reason);
            return Unit.INSTANCE;
        L25:
            if (this.this$0.isBackground() == false) goto L27;
        L36:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "pending welcome music skipped, reason=" + this.$reason + ", isBack=" + this.this$0.isBackground() + ", isConnect=" + this.this$0.isConnected() + ", isInCall=" + this.this$0.isInCall());
            return Unit.INSTANCE;
        L27:
            if (this.this$0.isConnected() == false) goto L36;
            if (this.this$0.isInCall() == true) goto L36;
            ObricDoraGOnboardingViewModelV2 r9 = this.this$0;
            String r2 = this.$reason;
            if (ObricDoraGOnboardingViewModelV2.access$getPlayer$p(r9) != null) goto L34;
            r3 = true;
        L34:
            ObricDoraGOnboardingViewModelV2.access$startWelcomeMusicInternal(r9, r2, r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            if (ObricDoraGOnboardingViewModelV2.access$isWelcomeMusicAllowed$p(this.this$0) == true) goto L12;
            ObricDoraGOnboardingViewModelV2.access$setPendingWelcomeMusicPlay$p(this.this$0, false);
            ObricDoraGOnboardingViewModelV2.access$unregisterWelcomeMusicBluetoothReceiver(this.this$0);
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "pending welcome music skipped, reason=" + this.$reason + ", welcome music is not allowed");
            return Unit.INSTANCE;
        L12:
            BluetoothDevice r10 = ObricDoraGOnboardingViewModelV2.access$getWelcomeMusicBluetoothDevice(this.this$0);
            if (r10 != null) goto L17;
            return Unit.INSTANCE;
        L17:
            if (r10.getBondState() != 12) goto L38;
            ObricDoraGOnboardingViewModelV2 r4 = this.this$0;
            this.label = 1;
            r8 = ObricDoraGOnboardingViewModelV2.access$isA2dpConnected(r4, r10, this);
            if (r8 != r0) goto L22;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$pausePlayWelcomeMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$pausePlayWelcomeMusic$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {921}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $reason;
        final /* synthetic */ long $ts;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05201(String r1, ObricDoraGOnboardingViewModelV2 r2, long r3, Continuation<? super C05201> r5) {
            this.$reason = r1;
            this.this$0 = r2;
            this.$ts = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C05201(this.$reason, this.this$0, this.$ts, r8);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "pause welcome music, due to " + this.$reason);
            ObricDoraGOnboardingViewModelV2.access$setPendingWelcomeMusicPlay$p(this.this$0, false);
            ObricDoraGOnboardingViewModelV2.access$unregisterWelcomeMusicBluetoothReceiver(this.this$0);
            com.larus.dora.impl.onboarding.g.v2.viewmodel.l r6 = ObricDoraGOnboardingViewModelV2.access$getPlayer$p(this.this$0);
            if (r6 == null) goto L15;
            long r2 = this.$ts;
            int r3 = com.larus.dora.impl.onboarding.g.v2.viewmodel.l.g;
            com.larus.utils.t0.e(new com.larus.dora.impl.onboarding.g.v2.viewmodel.g(r6, r2, null));
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playSuccessMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playSuccessMusic$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05211(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05211> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05211(this.this$0, r3);
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
            Integer r10 = ObricDoraGOnboardingViewModelV2.access$getSoundId$p(this.this$0);
            if (r10 == null) goto L10;
            ObricDoraGOnboardingViewModelV2 r0 = this.this$0;
            int r2 = r10.intValue();
            SoundPool r1 = ObricDoraGOnboardingViewModelV2.access$getSoundPool$p(r0);
            if (r1 == null) goto L10;
            Boxing.boxInt(r1.play(r2, 1.0f, 1.0f, 1, 0, 1.0f));
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playTTSAfterVuiModeReady$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playTTSAfterVuiModeReady$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onFinished;
        final /* synthetic */ String $ttsText;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05221(String r1, ObricDoraGOnboardingViewModelV2 r2, Function0<Unit> r3, Continuation<? super C05221> r4) {
            this.$ttsText = r1;
            this.this$0 = r2;
            this.$onFinished = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C05221(this.$ttsText, this.this$0, this.$onFinished, r5);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "run playTTS after vui mode ready: text=" + this.$ttsText);
            this.this$0.playTTS(this.$ttsText, this.$onFinished);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playVideoCallTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playVideoCallTTS$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05231(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05231> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05231(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L21;
            ResultKt.throwOnFailure(r4);
            DoraSetting.a.getClass();
            DoraGOnboardingConfig r5 = DoraSetting.c();
            if (r5 == null) goto L9;
            DoraGOnboardingOpenRemark r6 = r5.getOpenRemark();
            if (r6 == null) goto L9;
            String r7 = r6.getAiLiveScene();
        L10:
            if (r7 != null) goto L12;
        L15:
            boolean r1 = true;
        L16:
            if (r1 == false) goto L18;
            int r8 = com.larus.utils.j0.a;
            r7 = com.larus.utils.j0.d(2131902823);
        L18:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "play video call tts");
            ObricDoraGOnboardingViewModelV2.playTTS$default(this.this$0, r7, null, 2, null);
            return Unit.INSTANCE;
        L12:
            if (r7.length() == 0) goto L15;
            r1 = false;
        L9:
            r7 = null;
            goto L10
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playWaitWakeUpTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playWaitWakeUpTTS$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {723}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05241(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05241> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05241(this.this$0, r3);
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
            int r10 = com.larus.utils.j0.a;
            r9 = com.larus.utils.j0.d(2131902821);
        L28:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "play wait wakeup tts");
            ObricDoraGOnboardingViewModelV2.playTTS$default(this.this$0, r9, null, 2, null);
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
            if (ObricDoraGOnboardingViewModelV2.access$getConfigLiveAI$p(this.this$0) == false) goto L15;
            if (this.this$0.isTTSPlay() == false) goto L15;
            this.label = 1;
            if (DelayKt.delay(2500, this) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playWakeUpTTS$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playWakeUpTTS$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {736}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05251(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05251> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05251(this.this$0, r3);
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
            int r10 = com.larus.utils.j0.a;
            r9 = com.larus.utils.j0.d(2131902822);
        L24:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "play wakeup tts");
            ObricDoraGOnboardingViewModelV2.playTTS$default(this.this$0, r9, null, 2, null);
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
            if (DelayKt.delay(ObricDoraGOnboardingViewModelV2.A2DP_STATE_QUERY_TIMEOUT_MS, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playWelcomeMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playWelcomeMusic$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {914}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05261(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05261> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05261(this.this$0, r3);
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
            ObricDoraGOnboardingViewModelV2 r2 = this.this$0;
            this.label = 1;
            if (ObricDoraGOnboardingViewModelV2.playWelcomeMusicWhenA2dpReady$default(r2, "playWelcomeMusic", false, this, 2, null) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$playWelcomeMusicWhenA2dpReady$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2", f = "ObricDoraGOnboardingViewModelV2.kt", i = {0, 0}, l = {982}, m = "playWelcomeMusicWhenA2dpReady", n = {"reason", "restart"}, s = {"L$0", "Z$0"})
    public static final class C05271 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05271(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05271> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return ObricDoraGOnboardingViewModelV2.access$playWelcomeMusicWhenA2dpReady(this.this$0, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$replayWelcomeMusic$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$replayWelcomeMusic$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {933, 942}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $reason;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05281(ObricDoraGOnboardingViewModelV2 r1, String r2, Continuation<? super C05281> r3) {
            this.this$0 = r1;
            this.$reason = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05281(this.this$0, this.$reason, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L28:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L14:
            if (ObricDoraGOnboardingViewModelV2.access$isWelcomeMusicAllowed$p(this.this$0) == true) goto L18;
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "replay welcome no exec, reason = " + this.$reason + ", welcome music is not allowed");
            return Unit.INSTANCE;
        L18:
            if (this.this$0.isBackground() == false) goto L20;
        L29:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "replay welcome no exec, reason = " + this.$reason + ", because isBack: " + this.this$0.isBackground() + ", isConnect: " + this.this$0.isConnected() + ", isInCall:" + this.this$0.isInCall());
            return Unit.INSTANCE;
        L20:
            if (this.this$0.isConnected() == false) goto L29;
            if (this.this$0.isInCall() == true) goto L29;
            ObricDoraGOnboardingViewModelV2 r7 = this.this$0;
            String r2 = "replayWelcomeMusic:" + this.$reason;
            this.label = 2;
            if (ObricDoraGOnboardingViewModelV2.access$playWelcomeMusicWhenA2dpReady(r7, r2, false, this) != r0) goto L28;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(1000, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$retryEnterCurrentMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$retryEnterCurrentMode$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {1346}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05291(ObricDoraGOnboardingViewModelV2 r1, Continuation<? super C05291> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05291(this.this$0, r3);
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
            ObricDoraGOnboardingViewModelV2 r5 = this.this$0;
            ObricDoraGOnboardingViewModelV2.access$setVUIMode(r5, ObricDoraGOnboardingViewModelV2.access$getVuiMode$p(r5), 400);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            if (ObricDoraGOnboardingViewModelV2.access$getVuiMode$p(this.this$0) == 0) goto L15;
            this.label = 1;
            if (DelayKt.delay(1200, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$setVUIMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$setVUIMode$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {0, 1}, l = {1458, 1462, 1465}, m = "invokeSuspend", n = {"setVUIMode", "setVUIMode"}, s = {"L$0", "L$0"})
    public static final class C05301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayTs;
        final /* synthetic */ int $mode;
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05301(int r1, ObricDoraGOnboardingViewModelV2 r2, long r3, Continuation<? super C05301> r5) {
            this.$mode = r1;
            this.this$0 = r2;
            this.$delayTs = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C05301(this.$mode, this.this$0, this.$delayTs, r8);
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
            C05301 r10 = this;
        L31:
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "set vui mode: " + r10.$mode + " with start ob vui, result: " + ((Boolean) r15).booleanValue());
        L33:
            ObricDoraGOnboardingViewModelV2.access$setVuiMode$p(r10.this$0, r10.$mode);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r2 = this.I$1;
            long r6 = this.J$0;
            int r8 = this.I$0;
            ObricDoraGOnboardingViewModelV2 r9 = (ObricDoraGOnboardingViewModelV2) this.L$1;
            Ref.BooleanRef r11 = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(r15);
            Ref.BooleanRef r16 = r11;
            r10 = this;
        L25:
            int r12 = r8;
            int r13 = r2 + 1;
            ObricDoraGOnboardingViewModelV2 r3 = r9;
            int r14 = r12;
        L13:
            if (r13 >= r14) goto L27;
            r10.L$0 = r16;
            r10.L$1 = r3;
            r10.I$0 = r14;
            r10.J$0 = r6;
            r10.I$1 = r13;
            r10.label = 1;
            Object r17 = ObricDoraGOnboardingViewModelV2.access$startVUI(r3, 4, r10);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "set vui mode " + r10.$mode + " no success, due to start ob failed ");
            goto L33
        L11:
            r2 = this.I$1;
            r6 = this.J$0;
            r8 = this.I$0;
            r9 = (ObricDoraGOnboardingViewModelV2) this.L$1;
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$startVUI$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$startVUI$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {1487}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $mode;
        final /* synthetic */ Function1<Boolean, Unit> $onSuccess;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C05311(int r1, Function1<? super Boolean, Unit> r2, Continuation<? super C05311> r3) {
            this.$mode = r1;
            this.$onSuccess = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05311(this.$mode, this.$onSuccess, r4);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "startVUIMode: " + this.$mode + ", result=" + r5);
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$stopRecording$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$stopRecording$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C05321(Continuation<? super C05321> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C05321(r2);
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$stopVUIMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$stopVUIMode$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {1480}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $code;
        final /* synthetic */ int $mode;
        int label;

        public C05331(int r1, int r2, Continuation<? super C05331> r3) {
            this.$mode = r1;
            this.$code = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05331(this.$mode, this.$code, r4);
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "stop vui mode: " + this.$mode + ", code: " + this.$code + ", result: " + ((Boolean) r5).booleanValue());
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$updateLink$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$updateLink$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $state;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05341(ObricDoraGOnboardingViewModelV2 r1, int r2, Continuation<? super C05341> r3) {
            this.this$0 = r1;
            this.$state = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05341(this.this$0, this.$state, r4);
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
            kotlinx.coroutines.flow.z0 r1 = ObricDoraGOnboardingViewModelV2.access$get_linkStateFlow$p(this.this$0);
            IDoraService r3 = this.this$0.getDoraService();
            if (r3 == null) goto L13;
            DeviceService r4 = r3.device();
            if (r4 == null) goto L13;
            boolean r5 = r4.J();
        L14:
            r1.setValue(new c.b(r5));
            StringBuilder r2 = new StringBuilder("update link: cur mac is empty: ");
            if (r14 != null) goto L17;
            Boolean r15 = null;
        L22:
            r2.append(r15);
            r2.append(", cur link state: ");
            r2.append(this.$state);
            r2.append(", value = ");
            Object r16 = ObricDoraGOnboardingViewModelV2.access$get_linkStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.larus.dora.obric.onboarding.DoraGOnboardingLinkState.State");
            r2.append(((c.b) r16).a);
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, r2.toString());
            Object r17 = ObricDoraGOnboardingViewModelV2.access$get_linkStateFlow$p(this.this$0).getValue();
            if ((r17 instanceof c.b) == false) goto L25;
            c.b r18 = (c.b) r17;
        L26:
            if (r18 != null) goto L28;
        L30:
            boolean r110 = false;
        L31:
            if (r110 == false) goto L33;
            ObricDoraGOnboardingViewModelV2.pausePlayWelcomeMusic$default(this.this$0, "link is disconnect", 0, 2, null);
        L35:
            return Unit.INSTANCE;
        L33:
            ObricDoraGOnboardingViewModelV2.fetchConfigLiveAI$default(this.this$0, 0, 1, null);
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

    /* JADX INFO: renamed from: com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$updateWear$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingViewModelV2$updateWear$1", f = "ObricDoraGOnboardingViewModelV2.kt", i = {1}, l = {304, 308}, m = "invokeSuspend", n = {"wearState"}, s = {"I$0"})
    public static final class C05351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $leftOn;
        final /* synthetic */ boolean $rightOn;
        int I$0;
        int I$1;
        Object L$0;
        int label;
        final /* synthetic */ ObricDoraGOnboardingViewModelV2 this$0;

        public C05351(boolean r1, boolean r2, ObricDoraGOnboardingViewModelV2 r3, Continuation<? super C05351> r4) {
            this.$leftOn = r1;
            this.$rightOn = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C05351(this.$leftOn, this.$rightOn, this.this$0, r5);
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
            C05351 r13 = this;
            ?? r4 = r2;
        L32:
            StringBuilder r5 = new StringBuilder("cur wear state: ");
            if (r4 == 0) goto L35;
            r3 = true;
        L35:
            r5.append(r3);
            r5.append(", value = ");
            Object r14 = ObricDoraGOnboardingViewModelV2.access$get_wearStateFlow$p(r13.this$0).getValue();
            Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.larus.dora.obric.onboarding.DoraGOnboardingWearState.State");
            r5.append(((f.b) r14).a);
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, r5.toString());
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            int r6 = this.I$1;
            int r7 = this.I$0;
            ObricDoraGOnboardingViewModelV2 r8 = (ObricDoraGOnboardingViewModelV2) this.L$0;
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "cur dora onboarding device mac is null, don't update wear ");
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
            kotlinx.coroutines.flow.z0 r11 = ObricDoraGOnboardingViewModelV2.access$get_wearStateFlow$p(r13.this$0);
            f.b r15 = new f.b(r10, System.currentTimeMillis());
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
            g49.d.d(ObricDoraGOnboardingViewModelV2.TAG, "update wear left: " + this.$leftOn + ", right: " + this.$rightOn);
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

    public ObricDoraGOnboardingViewModelV2() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ IDoraService.h No() {
        return session_delegate$lambda$4();
    }

    public static /* synthetic */ Unit Oo(ObricDoraGOnboardingViewModelV2 r0) {
        return stopWelcomeMusic$lambda$23(r0);
    }

    public static /* synthetic */ Thread Po(Runnable r0) {
        return vuiModeDispatcher$lambda$0(r0);
    }

    public static /* synthetic */ IDoraService Qo() {
        return doraService_delegate$lambda$1();
    }

    public static /* synthetic */ IDoraPageConfig So() {
        return doraPageConfig_delegate$lambda$3();
    }

    public static /* synthetic */ IDoraService.d To(ObricDoraGOnboardingViewModelV2 r0) {
        return doraServiceDevice_delegate$lambda$2(r0);
    }

    private final boolean isCallingByIdleState(int r2) {
        if (((r2 >> 1) & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void enterMediaControlMode() {
        setVUIMode$default(this, 5, 0, 2, null);
    }

    public final void exitVideoCall() {
        stopVUIMode$default(this, 3, 0, 2, null);
    }

    public final void exitVoiceOnly() {
        stopVUIMode$default(this, 3, 0, 2, null);
    }

    public final void onStart() {
        this.isInBackground = false;
        replayWelcomeMusic("onStart");
    }

    public final void onStop() {
        this.isInBackground = true;
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

    private final BluetoothDevice getWelcomeMusicBluetoothDevice() {
        Object r2 = null;
        if (l69.a.a(TAG) == true) goto L6;
        g49.d.e(TAG, "getWelcomeMusicBluetoothDevice failed: bluetooth connect permission not granted");
        return null;
    L6:
        DoraOnboardingDevice r1 = getDoraOnboardingDevice();
        if (r1 == null) goto L10;
        String r3 = r1.b;
        if (r3 == null) goto L10;
    L14:
        if (r3 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L40;
        g49.d.e(TAG, "getWelcomeMusicBluetoothDevice failed: mac is empty");
        return null;
    L40:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L29
        BluetoothAdapter r6 = BluetoothAdapter.getDefaultAdapter();     // Catch: Throwable -> L29
        if (r6 == null) goto L26;
        BluetoothDevice r7 = r6.getRemoteDevice(r3);     // Catch: Throwable -> L29
    L27:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L29
    L31:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L35;
        g49.d.c(TAG, "getWelcomeMusicBluetoothDevice failed", r9);
    L35:
        if (Result.isFailure-impl(r8) == true) goto L39;
        r2 = r8;
    L39:
        return (BluetoothDevice) r2;
    L26:
        r7 = null;
    L29:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L16:
        if (r3.length() == 0) goto L19;
        r4 = false;
    L10:
        DoraDevice r11 = DoraAdapterExtKt.h(kj4.a.g());
        if (r11 == null) goto L13;
        r3 = r11.mac;
        goto L14
    L13:
        r3 = null;
        goto L14
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

    private final void registerWelcomeMusicBluetoothReceiver() {
        if (this.isWelcomeMusicBluetoothReceiverRegistered == false) goto L5;
        return;
    L5:
        BroadcastReceiver r1 = this.bluetoothStateReceiver;
        if (r1 != null) goto L8;
        r1 = new ObricDoraGOnboardingViewModelV2$registerWelcomeMusicBluetoothReceiver$receiver$1(this);
        this.bluetoothStateReceiver = r1;
    L8:
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        r2.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        INVOKEVIRTUAL_com_larus_dora_obric_onboarding_ObricDoraGOnboardingViewModelV2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(AppHost.a.getApplication(), r1, r2);     // Catch: Throwable -> L11
        this.isWelcomeMusicBluetoothReceiverRegistered = true;     // Catch: Throwable -> L11
        g49.d.d(TAG, "registerWelcomeMusicBluetoothReceiver");     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L19;
        g49.d.c(TAG, "registerWelcomeMusicBluetoothReceiver failed", r5);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    private static final IDoraService.h session_delegate$lambda$4() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    private final void stopRecording() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C05321(null), 3, null);
    }

    private final void unregisterWelcomeMusicBluetoothReceiver() {
        if (this.isWelcomeMusicBluetoothReceiverRegistered == true) goto L5;
        return;
    L5:
        BroadcastReceiver r0 = this.bluetoothStateReceiver;
        if (r0 != null) goto L17;
    L15:
        this.isWelcomeMusicBluetoothReceiverRegistered = false;
        g49.d.d(TAG, "unregisterWelcomeMusicBluetoothReceiver");
        return;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        INVOKEVIRTUAL_com_larus_dora_obric_onboarding_ObricDoraGOnboardingViewModelV2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(AppHost.a.getApplication(), r0);     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.exceptionOrNull-impl(r1);
        if (r3 == null) goto L14;
        g49.d.c(TAG, "unregisterWelcomeMusicBluetoothReceiver failed", r3);
    L14:
        Result.box-impl(r1);
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    private final void wearKeyClear() {
        t39.n r0 = this.linkCallback;
        if (r0 != null) goto L55;
    L16:
        this.linkCallback = null;
        h49.m r1 = this.wearListener;
        if (r1 != null) goto L61;
    L30:
        this.wearListener = null;
        com.larus.dora.impl.log.q r2 = this.voiceCallback;
        if (r2 != null) goto L59;
    L40:
        this.voiceCallback = null;
        com.larus.dora.impl.util.r0 r3 = this.doraBudsCallback;
        if (r3 != null) goto L57;
    L50:
        this.doraBudsCallback = null;
        SoundPool r4 = this.soundPool;
        if (r4 == null) goto L53;
        r4.release();
    L53:
        this.soundPool = null;
        this.soundId = null;
        return;
    L57:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L44
        kj4.a.g().E(r3);     // Catch: Throwable -> L44
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L49;
        g49.d.c(TAG, "unregister Dora buds callback failed", r7);
    L49:
        Result.box-impl(r6);
    L44:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L59:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L34
        kj4.a.g().unRegisterDoraVoiceCallback(r2);     // Catch: Throwable -> L34
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L39;
        g49.d.c(TAG, "unregister Dora voice callback failed", r11);
    L39:
        Result.box-impl(r10);
    L34:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L61:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L24
        IDoraService.d r14 = getDoraServiceDevice();     // Catch: Throwable -> L24
        if (r14 == null) goto L21;
        r14.c(r1);     // Catch: Throwable -> L24
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L24
    L26:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L29;
        g49.d.c(TAG, "remove wear state listener failed", r17);
    L29:
        Result.box-impl(r16);
        goto L30
    L21:
        r15 = null;
    L24:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L55:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L10
        IDoraService r21 = getDoraService();     // Catch: Throwable -> L10
        if (r21 == null) goto L7;
        r21.q0(r0);     // Catch: Throwable -> L10
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L10
    L12:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L15;
        g49.d.c(TAG, "unregister Dora link callback failed", r24);
    L15:
        Result.box-impl(r23);
        goto L16
    L7:
        r22 = null;
    L10:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void againOnboarding() {
        this._avatarUiStateFlow.setValue(AvatarUiState.WAITING);
        this._wakeupQueryUiStateFlow.setValue(c2.d.a);
        this.currentQueryId = null;
        this.queryImages.a();
    }

    public final void enterCheckWearMode() {
        setVUIMode$default(this, 12, 0, 2, null);
    }

    public final void enterKeyReportMode() {
        setVUIMode$default(this, 16, 0, 2, null);
    }

    public final void enterLongPressWakeupMode() {
        setVUIMode$default(this, 17, 0, 2, null);
    }

    public final void enterTakePhotoMode() {
        setVUIMode$default(this, 13, 0, 2, null);
    }

    public final void enterVideoCallMode() {
        setVUIMode$default(this, 14, 0, 2, null);
    }

    public final void exitOnboarding() {
        if (this.shouldManageOnboardingVui == true) goto L6;
        g49.d.d(TAG, "skip exit onboarding for direct diary entry");
        return;
    L6:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C05101(this, null), 3, null);
    }

    public final void fetchLinkState() {
        g49.d.d(TAG, "fetch link state");
        DoraOnboardingDevice r1 = getDoraOnboardingDevice();
        Boolean r2 = null;
        if (r1 == null) goto L6;
        String r3 = r1.b;
        if (r3 == null) goto L6;
    L10:
        kotlinx.coroutines.flow.z0<c> r4 = this._linkStateFlow;
        IDoraService r5 = getDoraService();
        boolean r6 = false;
        if (r5 == null) goto L15;
        DeviceService r7 = r5.device();
        if (r7 == null) goto L15;
        boolean r8 = r7.J();
    L16:
        r4.setValue(new c.b(r8));
        StringBuilder r9 = new StringBuilder("fetch link state: cur mac is empty: ");
        if (r3 != null) goto L19;
    L22:
        r9.append(r2);
        r9.append(", value = ");
        Object r10 = this._linkStateFlow.getValue();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.dora.obric.onboarding.DoraGOnboardingLinkState.State");
        r9.append(((c.b) r10).a);
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
        this._wakeupQueryUiStateFlow.setValue(c2.d.a);
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
        if ((r0 instanceof c.b) == false) goto L5;
        c.b r1 = (c.b) r0;
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
        if ((r0 instanceof e) == false) goto L5;
        e r1 = (e) r0;
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
        IFlowTtsClientService.a.getClass();
        return IFlowTtsClientService.a.a().a();
    }

    public final boolean isWearState() {
        Object r0 = this._wearStateFlow.getValue();
        if ((r0 instanceof f.b) == false) goto L5;
        f.b r1 = (f.b) r0;
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
        this.pendingWelcomeMusicPlay = false;
        unregisterWelcomeMusicBluetoothReceiver();
        com.larus.dora.impl.onboarding.g.v2.viewmodel.l r0 = this.player;
        if (r0 == null) goto L6;
        com.larus.utils.t0.e(new com.larus.dora.impl.onboarding.g.v2.viewmodel.g(r0, 5000, new m0(this)));
        return;
    }

    private final void currentWearState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05051(this, null), 2, null);
    }

    public final boolean canContinue() {
        boolean r0 = refreshCurrentDeviceCallState();
        StringBuilder r1 = new StringBuilder("canContinue check, isInCall=");
        r1.append(r0);
        r1.append(", onboardingVuiMode=");
        r1.append(this.vuiMode);
        r1.append(", sessionVuiMode=");
        IDoraService.h r2 = getSession();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.a());
    L6:
        r1.append(r3);
        g49.d.d(TAG, r1.toString());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05041(r0, this, null), 3, null);
        return !r0;
    L5:
        r3 = null;
        goto L6
    }

    public final void fetchWearState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05121(this, null), 2, null);
    }

    public final void fetchWifiConfig() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05131(this, null), 3, null);
    }

    public final void forceWakeupState() {
        stopWelcomeMusic();
        this._avatarUiStateFlow.setValue(AvatarUiState.WAITING);
        this._wakeupQueryUiStateFlow.setValue(c2.e.a);
    }

    public final void invalidLink() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05141(this, null), 3, null);
    }

    public final void invalidWear() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05151(this, null), 3, null);
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
        int r1 = com.larus.dora.impl.util.g0.a;
        if (r0 == null) goto L6;
        String r2 = r0.softVersion;
        if (r2 == null) goto L6;
    L8:
        if (com.larus.dora.impl.util.g0.a(r2, "0.2.7.2420") < 0) goto L10;
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
        this.pendingWelcomeMusicPlay = false;
        unregisterWelcomeMusicBluetoothReceiver();
        this.vuiModeDispatcher.close();
    }

    public final void playSuccessMusic() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05211(this, null), 3, null);
    }

    public final void playVideoCallTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05231(this, null), 2, null);
    }

    public final void playWaitWakeUpTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05241(this, null), 2, null);
    }

    public final void playWakeUpTTS() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05251(this, null), 2, null);
    }

    public final void playWelcomeMusic() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05261(this, null), 3, null);
    }

    public final void retryEnterCurrentMode() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05291(this, null), 3, null);
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
        uj4.h r3 = this.cameraListener;
        if (r3 == null) goto L17;
        kj4.a.g().d.getClass();
        ((CopyOnWriteArraySet) uj4.b.h.c).remove(r3);
    L17:
        this.cameraListener = null;
        m69.f r4 = this.llmListener;
        if (r4 == null) goto L20;
        m69.c r5 = m69.c.a;
        Intrinsics.checkNotNullParameter(r4, "listener");
        ((ArrayList) m69.c.b).remove(r4);
    L20:
        this.llmListener = null;
        this.queryImages.a();
    }

    public final kotlinx.coroutines.flow.d1<com.larus.dora.obric.onboarding.a> getActionSharedFlow() {
        return this.actionSharedFlow;
    }

    public final kotlinx.coroutines.flow.i1<AvatarUiState> getAvatarUiStateFlow() {
        return this.avatarUiStateFlow;
    }

    public final kotlinx.coroutines.flow.i1<Boolean> getDeviceCallStateFlow() {
        return this.deviceCallStateFlow;
    }

    public final kotlinx.coroutines.flow.d1<com.larus.dora.obric.onboarding.b> getKeyStateFlow() {
        return this.keyStateFlow;
    }

    public final kotlinx.coroutines.flow.i1<c> getLinkStateFlow() {
        return this.linkStateFlow;
    }

    public final Channel<g> getLlmCallEventSharedFlow() {
        return this.llmCallEventSharedFlow;
    }

    public final kotlinx.coroutines.flow.d1<Unit> getLlmCallStartedSharedFlow() {
        return this.llmCallStartedSharedFlow;
    }

    public final kotlinx.coroutines.flow.i1<Object> getNetworkStateFlow() {
        return this.networkStateFlow;
    }

    public final kotlinx.coroutines.flow.d1<byte[]> getTtsDataSharedFlow() {
        return this.ttsDataSharedFlow;
    }

    public final kotlinx.coroutines.flow.i1<c2> getWakeupQueryUiStateFlow() {
        return this.wakeupQueryUiStateFlow;
    }

    public final kotlinx.coroutines.flow.i1<f> getWearStateFlow() {
        return this.wearStateFlow;
    }

    public final kotlinx.coroutines.flow.z0<AvatarUiState> get_avatarUiStateFlow() {
        return this._avatarUiStateFlow;
    }

    public final Channel<g> get_llmCallEventSharedFlow() {
        return this._llmCallEventSharedFlow;
    }

    public final MutableSharedFlow<Unit> get_llmCallStartedSharedFlow() {
        return this._llmCallStartedSharedFlow;
    }

    public final MutableSharedFlow<byte[]> get_ttsDataSharedFlow() {
        return this._ttsDataSharedFlow;
    }

    public final kotlinx.coroutines.flow.z0<c2> get_wakeupQueryUiStateFlow() {
        return this._wakeupQueryUiStateFlow;
    }

    public final boolean hasConfigWiFi() {
        return this.hasConfigWiFi;
    }

    public final boolean isBackground() {
        return this.isInBackground;
    }

    public final boolean isLiveAI() {
        return this.configLiveAI;
    }

    public ObricDoraGOnboardingViewModelV2(boolean r11) {
        this.shouldManageOnboardingVui = r11;
        this.vuiModeDispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new n0()));
        StateFlowImpl r12 = kotlinx.coroutines.flow.j1.a(f.a.a);
        this._wearStateFlow = r12;
        this.wearStateFlow = r12;
        MutableSharedFlow<com.larus.dora.obric.onboarding.b> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._keyStateFlow = r2;
        this.keyStateFlow = r2;
        StateFlowImpl r3 = kotlinx.coroutines.flow.j1.a(c.a.a);
        this._linkStateFlow = r3;
        this.linkStateFlow = r3;
        StateFlowImpl r4 = kotlinx.coroutines.flow.j1.a(d.a);
        this._networkStateFlow = r4;
        this.networkStateFlow = r4;
        StateFlowImpl r5 = kotlinx.coroutines.flow.j1.a(Boolean.FALSE);
        this._deviceCallStateFlow = r5;
        this.deviceCallStateFlow = r5;
        MutableSharedFlow<com.larus.dora.obric.onboarding.a> r6 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionSharedFlow = r6;
        this.actionSharedFlow = r6;
        this.doraService$delegate = LazyKt.lazy(new o0());
        this.doraServiceDevice$delegate = LazyKt.lazy(new p0(this));
        this.configLiveAI = true;
        this.doraPageConfig$delegate = LazyKt.lazy(new q0());
        this.session$delegate = LazyKt.lazy(new r0());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        StateFlowImpl r7 = kotlinx.coroutines.flow.j1.a(AvatarUiState.WAITING);
        this._avatarUiStateFlow = r7;
        this.avatarUiStateFlow = r7;
        StateFlowImpl r8 = kotlinx.coroutines.flow.j1.a(c2.d.a);
        this._wakeupQueryUiStateFlow = r8;
        this.wakeupQueryUiStateFlow = r8;
        MutableSharedFlow<byte[]> r9 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._ttsDataSharedFlow = r9;
        this.ttsDataSharedFlow = r9;
        Channel<g> r10 = ChannelKt.Channel$default(0, null, null, 7, null);
        this._llmCallEventSharedFlow = r10;
        this.llmCallEventSharedFlow = r10;
        MutableSharedFlow<Unit> r13 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._llmCallStartedSharedFlow = r13;
        this.llmCallStartedSharedFlow = r13;
        this.queryImages = new com.bytedance.frameworks.baselib.network.http.util.g(5);
        this.isWelcomeMusicAllowed = true;
        this.shouldPlayWakeUpTTSOnLlmCallStarted = true;
        this.ttsTaskId = "";
        m69.f r14 = new AnonymousClass2(this);
        m69.c r0 = m69.c.a;
        Intrinsics.checkNotNullParameter(r14, "listener");
        ((ArrayList) m69.c.b).add(r14);
        this.llmListener = r14;
        a r15 = new a(this);
        kj4.a.g().d.getClass();
        ((CopyOnWriteArraySet) uj4.b.h.c).add(r15);
        this.cameraListener = r15;
    }

    public static final /* synthetic */ boolean access$getConfigLiveAI$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.configLiveAI;
    }

    public static final /* synthetic */ String access$getCurrentQueryId$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.currentQueryId;
    }

    public static final /* synthetic */ boolean access$getHasConfigWiFi$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.hasConfigWiFi;
    }

    public static final /* synthetic */ com.larus.dora.impl.onboarding.g.v2.viewmodel.l access$getPlayer$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.player;
    }

    public static final /* synthetic */ com.bytedance.frameworks.baselib.network.http.util.g access$getQueryImages$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.queryImages;
    }

    public static final /* synthetic */ IDoraService.h access$getSession(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.getSession();
    }

    public static final /* synthetic */ boolean access$getShouldPlayWakeUpTTSOnLlmCallStarted$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.shouldPlayWakeUpTTSOnLlmCallStarted;
    }

    public static final /* synthetic */ Integer access$getSoundId$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.soundId;
    }

    public static final /* synthetic */ SoundPool access$getSoundPool$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.soundPool;
    }

    public static final /* synthetic */ int access$getVuiMode$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.vuiMode;
    }

    public static final /* synthetic */ BluetoothDevice access$getWelcomeMusicBluetoothDevice(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.getWelcomeMusicBluetoothDevice();
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionSharedFlow$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0._actionSharedFlow;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_deviceCallStateFlow$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0._deviceCallStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_keyStateFlow$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0._keyStateFlow;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_linkStateFlow$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0._linkStateFlow;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_networkStateFlow$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0._networkStateFlow;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_wearStateFlow$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0._wearStateFlow;
    }

    public static final /* synthetic */ boolean access$isWelcomeMusicAllowed$p(ObricDoraGOnboardingViewModelV2 r0) {
        return r0.isWelcomeMusicAllowed;
    }

    public static final /* synthetic */ void access$stopRecording(ObricDoraGOnboardingViewModelV2 r0) {
        r0.stopRecording();
    }

    public static final /* synthetic */ void access$unregisterWelcomeMusicBluetoothReceiver(ObricDoraGOnboardingViewModelV2 r0) {
        r0.unregisterWelcomeMusicBluetoothReceiver();
    }

    private final void connectAllEnabledProfiles(BluetoothDevice r7) {
        if (l69.a.a(TAG) == true) goto L14;
        g49.d.e(TAG, "connectAllEnabledProfiles skipped: bluetooth connect permission not granted");
        return;
    L14:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Method r3 = BluetoothDevice.class.getDeclaredMethod("connectAllEnabledProfiles", new Class[0]);     // Catch: Throwable -> L8
        r3.setAccessible(true);     // Catch: Throwable -> L8
        g49.d.d(TAG, "connectAllEnabledProfiles invoked, device=" + r7.getAddress() + ", ret=" + r3.invoke(r7, new Object[0]));     // Catch: Throwable -> L8
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L16;
        g49.d.c(TAG, "connectAllEnabledProfiles failed, device=" + r7.getAddress(), r1);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private static final IDoraService.d doraServiceDevice_delegate$lambda$2(ObricDoraGOnboardingViewModelV2 r0) {
        IDoraService r1 = r0.getDoraService();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.device();
    }

    private final void emitTtsDataWithDelay(byte[] r8) {
        Job r0 = this.ttsEmitJob;
        this.ttsEmitJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05061(r8, r0, this, null), 3, null);
    }

    private final void handleWelcomeMusicBluetoothEvent(Intent r5) {
        if (r5 == null) goto L35;
        String r0 = r5.getAction();
        if (r0 == null) goto L40;
        BluetoothDevice r1 = (BluetoothDevice) r5.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        BluetoothDevice r2 = getWelcomeMusicBluetoothDevice();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r1 == null) goto L11;
        String r3 = r1.getAddress();
    L13:
        if (Intrinsics.areEqual(r3, r2.getAddress()) == true) goto L17;
        g49.d.d(TAG, "ignore bluetooth event for non target device, action=".concat(r0));
        return;
    L17:
        if (Intrinsics.areEqual(r0, "android.bluetooth.device.action.BOND_STATE_CHANGED") == false) goto L26;
        int r6 = r5.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
        g49.d.d(TAG, "welcome music bond state changed, bondState=" + r6);
        if (r6 == 12) goto L21;
    L23:
        if (r6 != 12) goto L36;
        connectAllEnabledProfiles(r2);
        return;
    L36:
        return;
    L21:
        if (this.pendingWelcomeMusicPlay == true) goto L23;
        return;
    L26:
        if (Intrinsics.areEqual(r0, "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED") == false) goto L38;
        int r7 = r5.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        g49.d.d(TAG, "welcome music A2DP state changed, state=" + r7 + ", pending=" + this.pendingWelcomeMusicPlay);
        if (r7 != 0) goto L30;
        this.pendingWelcomeMusicPlay = true;
        return;
    L30:
        if (r7 != 2) goto L41;
        maybeStartPendingWelcomeMusic("A2DP_CONNECTED");
        return;
    L41:
        return;
    L38:
        return;
    L11:
        r3 = null;
        goto L13
    L40:
        return;
    }

    private final void maybeStartPendingWelcomeMusic(String r8) {
        if (this.pendingWelcomeMusicPlay == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05191(this, r8, null), 3, null);
    }

    private static final Unit stopWelcomeMusic$lambda$23(ObricDoraGOnboardingViewModelV2 r1) {
        com.larus.dora.impl.onboarding.g.v2.viewmodel.l r0 = r1.player;
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
        r2.append(this.vuiMode);
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
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C05341(this, r7, null), 2, null);
    }

    private static final Thread vuiModeDispatcher$lambda$0(Runnable r2) {
        return new PthreadThreadV2(r2, "dora_onboarding_vui_mode");
    }

    public final void enterOnboarding(String r8) {
        if (this.shouldManageOnboardingVui == true) goto L6;
        g49.d.d(TAG, "skip enter onboarding for direct diary entry");
        return;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C05081(r8, this, null), 2, null);
    }

    public final void fetchConfigLiveAI(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C05111(r7, this, null), 2, null);
    }

    public final void replayWelcomeMusic(String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        g49.d.d(TAG, "replay welcome music, due to " + r10);
        Job r0 = this.replayWelcomeMusicJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.replayWelcomeMusicJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05281(this, r10, null), 3, null);
    }

    public final void stopAllTTS(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        g49.d.d(TAG, "stopAllTTS: reason=" + r4);
        Job r0 = this.ttsEmitJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().f(r4);
    }

    public final void stopTTS(String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        g49.d.d(TAG, "stopTTS: reason=" + r5);
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService r0 = IFlowTtsClientService.a.a();
        g49.d.d(TAG, "stop tts taskId: " + this.ttsTaskId);
        Job r1 = this.ttsEmitJob;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        r0.g(this.ttsTaskId, false, r5);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_larus_dora_obric_onboarding_ObricDoraGOnboardingViewModelV2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Application r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static final /* synthetic */ void access$emitTtsDataWithDelay(ObricDoraGOnboardingViewModelV2 r0, byte[] r1) {
        r0.emitTtsDataWithDelay(r1);
    }

    public static final /* synthetic */ void access$handleWelcomeMusicBluetoothEvent(ObricDoraGOnboardingViewModelV2 r0, Intent r1) {
        r0.handleWelcomeMusicBluetoothEvent(r1);
    }

    public static final /* synthetic */ void access$setConfigLiveAI$p(ObricDoraGOnboardingViewModelV2 r0, boolean r1) {
        r0.configLiveAI = r1;
    }

    public static final /* synthetic */ void access$setCurrentQueryId$p(ObricDoraGOnboardingViewModelV2 r0, String r1) {
        r0.currentQueryId = r1;
    }

    public static final /* synthetic */ void access$setDoraBudsCallback$p(ObricDoraGOnboardingViewModelV2 r0, com.larus.dora.impl.util.r0 r1) {
        r0.doraBudsCallback = r1;
    }

    public static final /* synthetic */ void access$setHasConfigWiFi$p(ObricDoraGOnboardingViewModelV2 r0, boolean r1) {
        r0.hasConfigWiFi = r1;
    }

    public static final /* synthetic */ void access$setLinkCallback$p(ObricDoraGOnboardingViewModelV2 r0, t39.n r1) {
        r0.linkCallback = r1;
    }

    public static final /* synthetic */ void access$setNetworkCallback$p(ObricDoraGOnboardingViewModelV2 r0, ConnectivityManager.NetworkCallback r1) {
        r0.networkCallback = r1;
    }

    public static final /* synthetic */ void access$setPendingWelcomeMusicPlay$p(ObricDoraGOnboardingViewModelV2 r0, boolean r1) {
        r0.pendingWelcomeMusicPlay = r1;
    }

    public static final /* synthetic */ void access$setVoiceCallback$p(ObricDoraGOnboardingViewModelV2 r0, com.larus.dora.impl.log.q r1) {
        r0.voiceCallback = r1;
    }

    public static final /* synthetic */ void access$setVuiMode$p(ObricDoraGOnboardingViewModelV2 r0, int r1) {
        r0.vuiMode = r1;
    }

    public static final /* synthetic */ void access$setWearListener$p(ObricDoraGOnboardingViewModelV2 r0, h49.m r1) {
        r0.wearListener = r1;
    }

    public static final /* synthetic */ void access$stopVUIMode(ObricDoraGOnboardingViewModelV2 r0, OnboardingVUIMode r1) {
        r0.stopVUIMode(r1);
    }

    public static final /* synthetic */ void access$updateCall(ObricDoraGOnboardingViewModelV2 r0, int r1) {
        r0.updateCall(r1);
    }

    public static final /* synthetic */ void access$updateLink(ObricDoraGOnboardingViewModelV2 r0, int r1) {
        r0.updateLink(r1);
    }

    private final Object ensureWelcomeMusicA2dpReady(String r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof C05071) == false) goto L7;
        C05071 r0 = (C05071) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        BluetoothDevice r12 = (BluetoothDevice) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L27:
        if (((Boolean) r11).booleanValue() == false) goto L30;
        g49.d.d(TAG, "A2DP already connected before welcome music, reason=" + r4);
        return Boxing.boxBoolean(true);
    L30:
        this.pendingWelcomeMusicPlay = true;
        registerWelcomeMusicBluetoothReceiver();
        connectAllEnabledProfiles(r12);
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        BluetoothDevice r13 = getWelcomeMusicBluetoothDevice();
        if (r13 != null) goto L19;
        g49.d.e(TAG, "ensureWelcomeMusicA2dpReady failed: bluetoothDevice is null, reason=" + r9);
        return Boxing.boxBoolean(false);
    L19:
        if (r13.getBondState() == 12) goto L22;
        g49.d.d(TAG, "wait G bluetooth bonded before welcome music, reason=" + r9 + ", bondState=" + r13.getBondState());
        this.pendingWelcomeMusicPlay = true;
        registerWelcomeMusicBluetoothReceiver();
        return Boxing.boxBoolean(false);
    L22:
        r0.L$0 = r9;
        r0.L$1 = r13;
        r0.label = 1;
        Object r5 = isA2dpConnected(r13, r0);
        if (r5 != r2) goto L25;
        return r2;
    L25:
        r4 = r9;
        r12 = r13;
        r11 = r5;
    L7:
        r0 = new C05071(this, r10);
        goto L8
    }

    private final Object isA2dpConnected(BluetoothDevice r7, Continuation<? super Boolean> r8) {
        if ((r8 instanceof C05161) == false) goto L7;
        C05161 r0 = (C05161) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L25:
        Boolean r10 = (Boolean) r9;
        if (r10 == null) goto L29;
        r4 = r10.booleanValue();
    L29:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (l69.a.a(TAG) == true) goto L18;
        g49.d.e(TAG, "isA2dpConnected failed: bluetooth connect permission not granted");
        return Boxing.boxBoolean(false);
    L18:
        BluetoothAdapter r11 = BluetoothAdapter.getDefaultAdapter();
        if (r11 == null) goto L21;
        C05172 r5 = new C05172(r7, r11, null);
        r0.label = 1;
        r9 = TimeoutKt.c(A2DP_STATE_QUERY_TIMEOUT_MS, r5, r0);
        if (r9 != r2) goto L25;
        return r2;
    L21:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new C05161(this, r8);
        goto L8
    }

    private final void keyEvent(int r7, int r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05181(r7, r8, this, null), 3, null);
    }

    private final void setVUIMode(int r11, long r12) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C05301(r11, this, r12, null), 2, null);
    }

    private final void startVUI(int r7, Function1<? super Boolean, Unit> r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C05311(r7, r8, null), 2, null);
    }

    private final void startWelcomeMusicInternal(String r4, boolean r5) {
        if (this.isWelcomeMusicAllowed == true) goto L6;
        g49.d.d(TAG, "start welcome music skipped, reason=" + r4 + ", welcome music is not allowed");
        return;
    L6:
        this.pendingWelcomeMusicPlay = false;
        unregisterWelcomeMusicBluetoothReceiver();
        g49.d.d(TAG, "start welcome music, reason=" + r4 + ", restart=" + r5);
        if (r5 == false) goto L12;
        com.larus.dora.impl.onboarding.g.v2.viewmodel.l r6 = this.player;
        if (r6 == null) goto L11;
        int r7 = com.larus.dora.impl.onboarding.g.v2.viewmodel.l.g;
        r6.d(null);
        r6.b();
    L11:
        this.player = new com.larus.dora.impl.onboarding.g.v2.viewmodel.l();
    L12:
        com.larus.dora.impl.onboarding.g.v2.viewmodel.l r8 = this.player;
        if (r8 != null) goto L15;
        r8 = new com.larus.dora.impl.onboarding.g.v2.viewmodel.l();
        this.player = r8;
    L15:
        com.larus.dora.impl.onboarding.g.v2.viewmodel.l.c(r8, AppHost.a.getApplication());
    }

    private final void stopVUIMode(int r7, int r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C05331(r7, r8, null), 2, null);
    }

    private final void updateWear(boolean r7, boolean r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05351(r7, r8, this, null), 3, null);
    }

    public final void enterVoiceOnlyMode(boolean r13, boolean r14) {
        this.shouldPlayWakeUpTTSOnLlmCallStarted = r14;
        setVUIMode$default(this, 6, 0, 2, null);
        if (r13 == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C05091(this, null), 2, null);
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel
    public Object isDoraSupportOnboarding(String r1, Continuation<? super Boolean> r2) {
        return Boxing.boxBoolean(true);
    }

    public final void pausePlayWelcomeMusic(String r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "reason");
        Job r0 = this.pausePlayWelcomeMusicJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.pausePlayWelcomeMusicJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05201(r13, this, r14, null), 3, null);
    }

    public final void playTTS(String r15, final Function0<Unit> r16) {
        Intrinsics.checkNotNullParameter(r15, "ttsText");
        if (StringsKt.isBlank(r15) == false) goto L6;
        g49.d.b(TAG, "playTTS skipped: ttsText is blank");
        return;
    L6:
        stopWelcomeMusic();
        g49.d.d(TAG, "playTTS request: text=" + r15);
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService r1 = IFlowTtsClientService.a.a();
        g49.d.d(TAG, "playTTS resolved service=".concat(r1.getClass().getName()));
        r1.f("onPlayNoticeTTS");
        r1.j(z2.a.J());
        String r3 = "DoraNotice" + System.currentTimeMillis();
        this.ttsTaskId = r3;
        g49.d.d(TAG, "start tts taskId: " + this.ttsTaskId + ", text=" + r15);
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L9;
        String r4 = r2.v0();
    L10:
        if (r4 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == false) goto L20;
        e10 r5 = e10.a;
        r4 = e10.f().a();
        if (r4 != null) goto L20;
        r4 = "";
    L20:
        String r7 = r4;
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L23;
        String r9 = r8.z();
    L24:
        IFlowTtsClientService.b.a(r1, r3, null, r15, r7, null, null, new ObricDoraGOnboardingViewModelV2$playTTS$1$1(this, r16), r9, getTargetLoudness(), getLoudNormAlgoType(), 14450);
        return;
    L23:
        r9 = null;
        goto L24
    L12:
        if (r4.length() == 0) goto L15;
        r6 = false;
        goto L16
    L9:
        r4 = null;
        goto L10
    }

    public final void playTTSAfterVuiModeReady(String r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "ttsText");
        g49.d.d(TAG, "schedule playTTS after vui mode ready: text=" + r9);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.vuiModeDispatcher, null, new C05221(r9, this, r10, null), 2, null);
    }

    public final void setWelcomeMusicAllowed(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (this.isWelcomeMusicAllowed != r3) goto L5;
        return;
    L5:
        this.isWelcomeMusicAllowed = r3;
        g49.d.d(TAG, "set welcome music allowed=" + r3 + ", reason=" + r4);
        if (r3 == true) goto L9;
        this.pendingWelcomeMusicPlay = false;
        unregisterWelcomeMusicBluetoothReceiver();
        return;
    }

    private final Object startVUI(int r1, Continuation<? super Boolean> r2) {
        return DoraAdapterExtKt.N(kj4.a.g(), r1);
    }

    public /* synthetic */ ObricDoraGOnboardingViewModelV2(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_larus_dora_obric_onboarding_ObricDoraGOnboardingViewModelV2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Application r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    public static final /* synthetic */ Object access$ensureWelcomeMusicA2dpReady(ObricDoraGOnboardingViewModelV2 r0, String r1, Continuation r2) {
        return r0.ensureWelcomeMusicA2dpReady(r1, r2);
    }

    public static final /* synthetic */ Object access$isA2dpConnected(ObricDoraGOnboardingViewModelV2 r0, BluetoothDevice r1, Continuation r2) {
        return r0.isA2dpConnected(r1, r2);
    }

    public static final /* synthetic */ void access$keyEvent(ObricDoraGOnboardingViewModelV2 r0, int r1, int r2) {
        r0.keyEvent(r1, r2);
    }

    public static final /* synthetic */ void access$setVUIMode(ObricDoraGOnboardingViewModelV2 r0, int r1, long r2) {
        r0.setVUIMode(r1, r2);
    }

    public static final /* synthetic */ Object access$startVUI(ObricDoraGOnboardingViewModelV2 r0, int r1, Continuation r2) {
        return r0.startVUI(r1, r2);
    }

    public static final /* synthetic */ void access$startWelcomeMusicInternal(ObricDoraGOnboardingViewModelV2 r0, String r1, boolean r2) {
        r0.startWelcomeMusicInternal(r1, r2);
    }

    public static final /* synthetic */ void access$updateWear(ObricDoraGOnboardingViewModelV2 r0, boolean r1, boolean r2) {
        r0.updateWear(r1, r2);
    }

    private final Object playWelcomeMusicWhenA2dpReady(String r6, boolean r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof C05271) == false) goto L7;
        C05271 r0 = (C05271) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = r0.Z$0;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L29:
        if (((Boolean) r9).booleanValue() == false) goto L32;
        startWelcomeMusicInternal(r6, r7);
    L32:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        g49.d.d(TAG, "prepare welcome music, reason=" + r6);
        if (this.isWelcomeMusicAllowed == true) goto L19;
        g49.d.d(TAG, "prepare welcome music skipped, reason=" + r6 + ", welcome music is not allowed");
        return Unit.INSTANCE;
    L19:
        if (isBackground() == false) goto L21;
    L33:
        g49.d.d(TAG, "prepare welcome music skipped, reason=" + r6 + ", isBack=" + isBackground() + ", isConnect=" + isConnected() + ", isInCall=" + isInCall());
        return Unit.INSTANCE;
    L21:
        if (isConnected() == false) goto L33;
        if (isInCall() == true) goto L33;
        r0.L$0 = r6;
        r0.Z$0 = r7;
        r0.label = 1;
        r9 = ensureWelcomeMusicA2dpReady(r6, r0);
        if (r9 != r2) goto L29;
        return r2;
    L7:
        r0 = new C05271(this, r8);
        goto L8
    }

    public static final /* synthetic */ void access$startVUI(ObricDoraGOnboardingViewModelV2 r0, int r1, Function1 r2) {
        r0.startVUI(r1, r2);
    }

    public static final /* synthetic */ Object access$playWelcomeMusicWhenA2dpReady(ObricDoraGOnboardingViewModelV2 r0, String r1, boolean r2, Continuation r3) {
        return r0.playWelcomeMusicWhenA2dpReady(r1, r2, r3);
    }

    public static /* synthetic */ void enterOnboarding$default(ObricDoraGOnboardingViewModelV2 r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.enterOnboarding(r1);
    }

    public static /* synthetic */ void fetchConfigLiveAI$default(ObricDoraGOnboardingViewModelV2 r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 3;
    L5:
        r0.fetchConfigLiveAI(r1);
    }

    public static /* synthetic */ void enterVoiceOnlyMode$default(ObricDoraGOnboardingViewModelV2 r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        r1.enterVoiceOnlyMode(r2, r3);
    }

    public static /* synthetic */ void pausePlayWelcomeMusic$default(ObricDoraGOnboardingViewModelV2 r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 300;
    L5:
        r0.pausePlayWelcomeMusic(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playTTS$default(ObricDoraGOnboardingViewModelV2 r0, String r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.playTTS(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void playTTSAfterVuiModeReady$default(ObricDoraGOnboardingViewModelV2 r0, String r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.playTTSAfterVuiModeReady(r1, r2);
    }

    public static /* synthetic */ void setVUIMode$default(ObricDoraGOnboardingViewModelV2 r0, int r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 100;
    L5:
        r0.setVUIMode(r1, r2);
    }

    public static /* synthetic */ void stopVUIMode$default(ObricDoraGOnboardingViewModelV2 r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = BaiduNaviStatus.WRONG_AK_PARAM;
    L5:
        r0.stopVUIMode(r1, r2);
    }

    public static /* synthetic */ Object playWelcomeMusicWhenA2dpReady$default(ObricDoraGOnboardingViewModelV2 r0, String r1, boolean r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.playWelcomeMusicWhenA2dpReady(r1, r2, r3);
    }
}
