package com.larus.dora.dorag.res;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.Logger;
import com.byted.cast.common.api.CodecType;
import com.byted.cast.common.api.ICastSink;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.config.IInitListener;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.IServer;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.applog.api.IApplog;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.avlink.plugins.u2;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IByteCastManager;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.cast.sink.ByteCastSinkImpl;
import com.ss.cast.sink.api.ByteCastSink;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import t39.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001H\b\u0007\u0018\u0000  \u00012\u00020\u0001:\u0002 \u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010E\u001a\u00020FH\u0016J\b\u0010J\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020FH\u0016J\b\u0010L\u001a\u00020FH\u0002J\b\u0010M\u001a\u00020FH\u0002J\b\u0010N\u001a\u00020FH\u0002J\u0010\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020\nH\u0002J\u0016\u0010Q\u001a\u00020F2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020F0SH\u0002J\u0010\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020\nH\u0002J\u0010\u0010V\u001a\u00020F2\u0006\u0010W\u001a\u00020\u0005H\u0002J\b\u0010X\u001a\u00020FH\u0002J\b\u0010Y\u001a\u00020FH\u0002J\b\u0010Z\u001a\u00020FH\u0016J\b\u0010[\u001a\u00020\nH\u0016J\u0010\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u00020\nH\u0016J\b\u0010^\u001a\u00020\nH\u0016J\b\u0010_\u001a\u00020\nH\u0016J\b\u0010`\u001a\u00020\nH\u0016J\u0010\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0016J\n\u0010c\u001a\u0004\u0018\u00010/H\u0016J\n\u0010d\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010e\u001a\u00020F2\u0006\u0010f\u001a\u00020\u0015H\u0016J\b\u0010g\u001a\u00020FH\u0002J\b\u0010h\u001a\u00020FH\u0002J\u0010\u0010i\u001a\u00020\"2\u0006\u0010j\u001a\u00020%H\u0002J\u001a\u0010k\u001a\u00020F2\b\u0010l\u001a\u0004\u0018\u00010\u00122\u0006\u0010m\u001a\u00020\u0005H\u0002J\b\u0010n\u001a\u00020FH\u0002J\u0012\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010rH\u0002J\b\u0010s\u001a\u00020\"H\u0002J\b\u0010t\u001a\u00020FH\u0002J\u0010\u0010u\u001a\u00020-2\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010x\u001a\u00020F2\u0006\u0010y\u001a\u00020/H\u0002J\b\u0010z\u001a\u00020FH\u0002J\u0010\u0010{\u001a\u00020F2\u0006\u0010|\u001a\u000202H\u0002J\b\u0010}\u001a\u00020FH\u0002J\b\u0010~\u001a\u00020FH\u0002J\u001b\u0010\u007f\u001a\u00020F2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0003\u0010\u0081\u0001J(\u0010\u0082\u0001\u001a\u00020F2\u0007\u0010\u0083\u0001\u001a\u00020\u00052\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0085\u0001H\u0002J\u001e\u0010\u0086\u0001\u001a\u00030\u0087\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u0001042\u0007\u0010\u0089\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010\u008c\u0001\u001a\u00020F2\u0007\u0010\u0089\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u008d\u0001\u001a\u00020FH\u0002J\u0014\u0010\u008e\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010\u008f\u0001\u001a\u00020wH\u0002J\u001e\u0010\u0090\u0001\u001a\u0004\u0018\u00010\"*\u00020w2\u0007\u0010\u0091\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010\u0093\u0001\u001a\u00020F2\u0007\u0010\u0094\u0001\u001a\u00020\bH\u0016J\t\u0010\u0095\u0001\u001a\u00020FH\u0016J\t\u0010\u0096\u0001\u001a\u00020FH\u0016J\u0010\u0010\u0097\u0001\u001a\u00020F2\u0007\u0010\u0098\u0001\u001a\u00020\"J\u001b\u0010\u0099\u0001\u001a\u00020F2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\u0007\u0010\u009c\u0001\u001a\u00020FJ\u001b\u0010\u009d\u0001\u001a\u00020F2\u0007\u0010\u009e\u0001\u001a\u00020\u00052\u0007\u0010\u009f\u0001\u001a\u00020wH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010A\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010I¨\u0006¡\u0001"}, d2 = {"Lcom/larus/dora/dorag/res/DoraByteCastManager;", "Lcom/larus/dora/api/IByteCastManager;", "<init>", "()V", "TAG", "", "VIDEO_DUMP_ENABLE", "dataCallBack", "Lcom/larus/dora/api/IByteCastDataCallBack;", "canSetByteCastRandomPortOption", "", "setByteCastRandomPortLock", "", "byteCastSink", "Lcom/ss/cast/sink/api/ByteCastSink;", "clientId", "videoCodecInfo", "", "", "connectedClientIds", "p2pRTCClientOwnershipVersion", "", "p2pRTCReleaseInProgress", "p2pRTCCompanionRetention", "Ljava/util/concurrent/atomic/AtomicBoolean;", "byteCastThread", "Landroid/os/HandlerThread;", "byteCastHandler", "Landroid/os/Handler;", "getByteCastHandler", "()Landroid/os/Handler;", "byteCastHandler$delegate", "Lkotlin/Lazy;", "transType", "", "byteCastReady", "lastCastInfo", "Lcom/byted/cast/common/sink/CastInfo;", "currentEnableStartUsbServer", "Ljava/lang/Boolean;", "wifiStateReceiver", "Landroid/content/BroadcastReceiver;", "isTransmitting", "()Z", "lastMirrorData", "Lcom/larus/dora/api/MirrorData;", "lastBtMonitorData", "Lcom/larus/dora/api/BluetoothBandwidthMonitorData;", "lastBtMonitorDataTimeMs", "lastBtMonitorSnapshot", "Lcom/larus/dora/api/BluetoothBandwidthMonitorSnapshot;", "lastRtcAverageBitrate", "Lcom/larus/dora/dorag/res/RtcAverageBitrateSample;", "phoneCountRequested", "btRtcNqeEnabled", "mmtTargetBitrateLock", "mmtTargetBitrateSamples", "Ljava/util/ArrayDeque;", "Lcom/larus/dora/dorag/res/TimedMmtTargetBitrate;", "vos", "Ljava/io/FileOutputStream;", "aos", "keva", "Lcom/bytedance/keva/Keva;", "videoDumpEnable", "currentRTCChannelConfigs", "", "Lcom/larus/dora/api/model/DoraRTCChannelConfig;", "callbacksInitialized", "init", "", "doraLinkCallback", "com/larus/dora/dorag/res/DoraByteCastManager$doraLinkCallback$1", "Lcom/larus/dora/dorag/res/DoraByteCastManager$doraLinkCallback$1;", "isInitSuccess", "initAfterAbilityNegotiation", "initAfterAbilityNegotiationInternal", "reRegisterRTCChannel", "registerWifiStateReceiver", "handleWifiStateChanged", "wifiEnabled", "runOnByteCastExecutor", "block", "Lkotlin/Function0;", "initByteCastSink", "enableStartUsbServer", "setByteRandomPortOption", "where", "startServer", "deInitByteCastSink", "finishSession", "getRtcVideoDumpEnable", "syncRtcVideoDumpEnable", "checked", "isBtRtcRunning", "isP2PRTCClientConnected", "invalidateP2PRTCClientOwnership", "updateP2PRTCCompanionRetention", "retain", "getBtBandwidthMonitorData", "getBtBandwidthMonitorSnapshot", "recordMmtTargetBitrate", "targetBitrateBps", "setServerListener", "setMirrorListener", "parseVideoPort", "castInfo", "dumpVideo", "data", "frameType", "closeFile", "getVideoCodecType", "Lcom/larus/im/service/audio/vlm/EncodedVideoCodecType;", "type", "Lcom/byted/cast/common/api/CodecType$VCODEC_ID;", "getVideoRotation", "setMessageListener", "parseMirrorData", "mirrorJson", "Lorg/json/JSONObject;", "handleBtMonitorData", "monitorData", "requestBtConnectedPhoneCount", "reportBtRtcHeartbeat", "snapshot", "clearBtMonitorState", "clearBtMonitorData", "updateBtRtcMetricsState", "forceEnabled", "(Ljava/lang/Boolean;)V", "handleRtcTransferStats", "event", "params", "", "getValidRtcAverageBitrate", "", "sample", "now", "getMmtTargetBitrateSnapshot", "Lcom/larus/dora/dorag/res/MmtTargetBitrateSnapshot;", "trimMmtTargetBitrateSamples", "clearMmtTargetBitrateSamples", "parseBtMonitorData", "monitorJson", "optValidInt", "name", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "setDataCallBack", "callBack", "clearDataCallBack", "requestKeyFrame", "changeFps", "fps", "dispatchVideoFrame", "frame", "Lcom/larus/im/service/audio/vlm/EncodedVideoFrameParam;", "changeEncodedModeToH265", "changeSinkConfig", "cmd", "param", "Companion", "dorag-res_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraByteCastManager implements IByteCastManager {
    public static final /* synthetic */ int D = 0;
    public List<b49.c> A;
    public final AtomicBoolean B;
    public final c C;
    public final String a;
    public t39.g b;
    public boolean c;
    public final Object d;
    public com.ss.cast.sink.api.g e;
    public String f;
    public final Map<String, byte[]> g;
    public final Map<String, Boolean> h;
    public long i;
    public boolean j;
    public final AtomicBoolean k;
    public final PthreadHandlerThreadV2 l;
    public final Lazy m;
    public int n;
    public volatile boolean o;
    public CastInfo p;
    public Boolean q;
    public DoraByteCastManager$registerWifiStateReceiver$receiver$1 r;
    public volatile s s;
    public volatile p t;
    public boolean u;
    public boolean v;
    public final Object w;
    public final ArrayDeque<q> x;
    public PolarisFileOutputStreamWrapper y;
    public final boolean z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CodecType.VCODEC_ID.values().length];
            r0[CodecType.VCODEC_ID.H265.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class c implements t39.n {
        public final /* synthetic */ DoraByteCastManager a;

        public c(DoraByteCastManager r1) {
            this.a = r1;
        }

        public final void e(final int r1, int r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "productName");
            final DoraByteCastManager r5 = this.a;
            DoraByteCastManager.n(r5, new com.larus.dora.dorag.res.f(r5, r1));
        }
    }

    public static final class d implements f49.a {
        public final /* synthetic */ DoraByteCastManager a;

        @Override // f49.a
        public final void a() {
            final DoraByteCastManager r0 = this.a;
            DoraByteCastManager.n(r0, new g(r0));
        }

        public d(DoraByteCastManager r1) {
            this.a = r1;
        }
    }

    public static final class e implements IInitListener {
        public final /* synthetic */ DoraByteCastManager a;

        public final /* synthetic */ void onFail(int r1, String r2, Exception r3) {
            IInitListener.-CC.$default$onFail(this, r1, r2, r3);
        }

        public final void onSuccess() {
            FLogger r0 = FLogger.a;
            r0.i(this.a.a, "onSuccess: ");
            this.a.o = true;
            DoraByteCastManager r1 = this.a;
            r1.getClass();
            r0.i(r1.a, "startServer: byteCastReady: " + r1.o);
            com.ss.cast.sink.api.g r2 = r1.e;
            if (r2 == null) goto L6;
            Dispatcher.getInstance().runOnByteCastThread(new com.ss.cast.sink.api.c(r2));
            return;
        }

        public e(DoraByteCastManager r1) {
            this.a = r1;
        }

        public final void onError(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errMsg");
            FLogger.a.i(this.a.a, "onInitCallback ----------->false");
            this.a.o = false;
            this.a.q = null;
        }
    }

    public static final class f implements ILogger {
        public f() {
        }

        public final void onVerbose(String r1, String r2) {
        }

        public final void onDebug(String r4, String r5) {
            boolean r0 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L18;
            if (r5 != null) goto L12;
        L13:
            r0 = true;
        L14:
            if (r0 == true) goto L19;
            FLogger.a.i(r4, r5);
            return;
        L19:
            return;
        L12:
            if (r5.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public final void onError(String r4, String r5) {
            boolean r0 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L18;
            if (r5 != null) goto L12;
        L13:
            r0 = true;
        L14:
            if (r0 == true) goto L19;
            FLogger.a.e(r4, r5);
            return;
        L19:
            return;
        L12:
            if (r5.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public final void onInfo(String r4, String r5) {
            boolean r0 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L18;
            if (r5 != null) goto L12;
        L13:
            r0 = true;
        L14:
            if (r0 == true) goto L19;
            FLogger.a.i(r4, r5);
            return;
        L19:
            return;
        L12:
            if (r5.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public final void onWarn(String r4, String r5) {
            boolean r0 = false;
            if (r4 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L18;
            if (r5 != null) goto L12;
        L13:
            r0 = true;
        L14:
            if (r0 == true) goto L19;
            FLogger.a.w(r4, r5);
            return;
        L19:
            return;
        L12:
            if (r5.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r2 = false;
            goto L9
        }

        public final void onError(String r3, String r4, Throwable r5) {
            boolean r6 = false;
            if (r3 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L18;
            if (r4 != null) goto L12;
        L13:
            r6 = true;
        L14:
            if (r6 == true) goto L19;
            FLogger.a.e(r3, r4);
            return;
        L19:
            return;
        L12:
            if (r4.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    static {
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void f() {
        this.b = null;
        FLogger.a.i(this.a, "video data callback cleared, subsequent video frames will be dropped");
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean c() {
        Map<String, Boolean> r0 = this.h;
        monitor-enter(r0);
        Collection r1 = ((LinkedHashMap) this.h).values();     // Catch: Throwable -> L17
        boolean r3 = false;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L17
    L10:
        if (r2.hasNext() == false) goto L15;
        if (((Boolean) r2.next()).booleanValue() == false) goto L10;
        r3 = true;
    L15:
        monitor-exit(r0);
        return r3;
    L7:
        if (r1.isEmpty() == false) goto L9;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void c0() {
        FLogger.a.i(this.a, "finishSession: clientId: " + this.f);
        y(Boolean.FALSE);
        this.u = false;
        o();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean h() {
        Map<String, Boolean> r0 = this.h;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.j == false) goto L7;
        boolean r1 = false;
    L10:
        monitor-exit(r0);
        FLogger.a.i(this.a, "invalidateP2PRTCClientOwnership: invalidated=" + r1);
        return r1;
    L7:
        r1 = CollectionsKt.removeAll(((LinkedHashMap) this.h).entrySet(), new com.larus.dora.dorag.res.d());     // Catch: Throwable -> L13
        if (r1 == false) goto L10;
        this.i++;     // Catch: Throwable -> L13
        goto L10
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void init() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.B.compareAndSet(false, true) == true) goto L16;
        return;
    L16:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        r0.o0().n(new d(this));     // Catch: Throwable -> L10
        v();     // Catch: Throwable -> L10
        r0.V0(this.C);     // Catch: Throwable -> L10
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L18;
        this.B.set(false);
        FLogger.a.e(this.a, "init: register callbacks failed", r3);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void o() {
        PolarisFileOutputStreamWrapper r0 = this.y;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        this.y = null;
    }

    public final void p() {
        if (DoraAVLinkDelegate.b.z1() == false) goto L12;
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        AbilityService r1 = r0.o0();
        if (r1 == null) goto L9;
        boolean r2 = r1.k();
    L10:
        q(!r2);
        u();
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void requestKeyFrame() {
        JSONObject r0 = new JSONObject();
        Intrinsics.checkNotNullParameter("requestIDR", "cmd");
        Intrinsics.checkNotNullParameter(r0, "param");
        JSONObject r3 = new JSONObject();
        r3.put("cmd", "requestIDR");
        Iterator<String> r1 = r0.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r3.put(r2, r0.opt(r2));
        goto L4
    L6:
        FLogger.a.i(this.a, "changeSinkConfig: message: " + r3);
        com.ss.cast.sink.api.g r4 = this.e;
        if (r4 == null) goto L17;
        CastInfo r5 = this.p;
        String r6 = r3.toString();
        if (r5 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L21;
        com.ss.cast.sink.j r7 = r4.a;
        r7.getClass();
        Logger.d("ByteCastSinkImpl", "send CastInfo:" + r5 + ", message:" + r6);
        Iterator r8 = ((ConcurrentHashMap) r7.i).keySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L22;
        ((ICastSink) ((ConcurrentHashMap) r7.i).get((String) r8.next())).send(r5, r6, null);
        goto L15
    L22:
        return;
    L21:
        return;
    }

    public final boolean s() {
        Map<String, Boolean> r0 = this.h;
        monitor-enter(r0);
        boolean r1 = !this.h.isEmpty();
        monitor-exit(r0);
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    public final void u() {
        List<b49.c> r0 = this.A;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.isEmpty()) == false) goto L13;
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L14;
        AbilityService r2 = r1.o0();
        if (r2 == null) goto L15;
        r2.o(r0);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void v() {
        if (this.r == null) goto L5;
        return;
    L5:
        DoraByteCastManager$registerWifiStateReceiver$receiver$1 r0 = new DoraByteCastManager$registerWifiStateReceiver$receiver$1(this);
        i(AppHost.a.getApplication().getApplicationContext(), r0, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));     // Catch: Exception -> L8
        this.r = r0;     // Catch: Exception -> L8
        FLogger.a.i(this.a, "registerWifiStateReceiver success");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e(this.a, "registerWifiStateReceiver failed", e);
    }

    public DoraByteCastManager() {
        this.a = "DoraByteCastManager";
        this.c = true;
        this.d = new Object();
        this.f = "";
        this.g = new ConcurrentHashMap();
        this.h = new LinkedHashMap();
        this.k = new AtomicBoolean(false);
        PthreadHandlerThreadV2 r1 = new PthreadHandlerThreadV2("DoraByteCastManager", -2);
        ThreadMethodProxy.start(r1);
        this.l = r1;
        this.m = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.dora.dorag.res.b(this));
        this.w = new Object();
        this.x = new ArrayDeque();
        this.z = Keva.getRepo("dora_byte_cast").getBoolean("video_dump_enable", false);
        this.B = new AtomicBoolean(false);
        this.C = new c(this);
    }

    public final boolean r() {
        if (s() == false) goto L13;
        s r0 = this.s;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.h != 0) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean a() {
        return this.o;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void d() {
        p();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean b(boolean r6) {
        boolean r0 = this.k.getAndSet(r6);
        FLogger.a.i(this.a, "updateP2PRTCCompanionRetention: previous=" + r0 + ", retain=" + r6);
        return r0;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void e(long r7) {
        if (r7 > 0) goto L5;
        return;
    L5:
        if (s() == false) goto L42;
        s r0 = this.s;
        boolean r1 = false;
        if (r0 != null) goto L9;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L43;
        long r3 = SystemClock.elapsedRealtime();
        Object r4 = this.w;
        monitor-enter(r4);
    L36:
        th = move-exception;
        throw th;
    L20:
        if (s() == false) goto L34;
        s r5 = this.s;     // Catch: Throwable -> L36
        if (r5 != null) goto L24;
    L29:
        if (r1 == true) goto L34;
        this.x.addLast(new q(r7, r3));     // Catch: Throwable -> L36
        x(r3);     // Catch: Throwable -> L36
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r4);
        return;
    L24:
        if (r5.h == 0) goto L26;
        boolean r6 = true;
    L27:
        if (r6 != true) goto L29;
        r1 = true;
        goto L29
    L26:
        r6 = false;
    L34:
        monitor-exit(r4);
        return;
    L43:
        return;
    L9:
        if (r0.h == 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 != true) goto L14;
        r2 = true;
        goto L15
    L11:
        r9 = false;
        goto L12
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void g(u2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "callBack");
        this.b = r3;
        FLogger.a.i(this.a, "video data callback registered");
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.dora.dorag.res.c] */
    public final void q(boolean r8) {
        Boolean r0 = this.q;
        if (r0 == null) goto L6;
        FLogger.a.i(this.a, "init: reuse UDP/TCP sink, enableStartUsbServer=" + this.q);
        return;
    L6:
        if (r0 == null) goto L13;
        FLogger.a.i(this.a, "init: reinit for transport switch, from enableStartUsbServer=" + this.q + " to " + r8);
        com.ss.cast.sink.api.g r1 = this.e;
        if (r1 == null) goto L10;
        Dispatcher.getInstance().runOnByteCastThread(new com.ss.cast.sink.api.d(r1));
    L10:
        com.ss.cast.sink.api.g r2 = this.e;
        if (r2 == null) goto L13;
        Dispatcher.getInstance().runOnByteCastThread(new com.ss.cast.sink.api.a(r2));
    L13:
        this.o = false;
        this.q = Boolean.valueOf(r8);
        FLogger r3 = FLogger.a;
        r3.i(this.a, "init: enableStartUsbServer=" + r8);
        Config.Builder r4 = new Config.Builder();
        AppHost.Companion r5 = AppHost.a;
        Config r9 = r4.setAppId(String.valueOf(r5.getAppId())).setProjectId("6b71d18f-1cd1-4399-b411-836187a6c905").setDeviceId(IApplog.a.getDeviceId()).setLicensePath("license/759c752e-b9b6-4339-8364-c53f60b751de.license").setServiceName("PROJECT_W").setLocalProtocols("ByteLink").enableDebug(true).enablePlaying(false).enableCallbackMediaStream(true).enableStartUsbServer(r8).setMonitor(new com.larus.dora.dorag.res.a(new com.larus.dora.dorag.res.c(this))).setLogger(new f()).build();
        this.e = com.ss.cast.sink.api.g.a();
        Object r6 = this.d;
        monitor-enter(r6);
        this.c = false;     // Catch: Throwable -> L60
        com.ss.cast.sink.api.g r7 = this.e;     // Catch: Throwable -> L60
        if (r7 == null) goto L18;
        r7.b(new Object[]{Boolean.TRUE});     // Catch: Throwable -> L60
    L18:
        com.ss.cast.sink.api.g r10 = this.e;     // Catch: Throwable -> L60
        if (r10 == null) goto L21;
        Dispatcher.getInstance().runOnByteCastThread(new com.ss.cast.sink.api.b(r10, r9, r5.getApplication().getApplicationContext(), new e(this)));     // Catch: Throwable -> L60
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L60
    L21:
        monitor-exit(r6);
        r3.i(this.a, "setServerListener: byteCastSink: " + this.e);
        com.ss.cast.sink.api.g r12 = this.e;
        if (r12 == null) goto L39;
        ByteCastSink.3 r13 = new ByteCastSink.3(new m(this));
        com.ss.cast.sink.j r14 = r12.a;
        r14.u = r13;
        com.ss.cast.sink.d r15 = new com.ss.cast.sink.d(r14);
        IServer r16 = r14.h;
        if (r16 == null) goto L27;
        r16.setServerListener(r15);
    L27:
        Iterator r17 = ((ConcurrentHashMap) r14.i).keySet().iterator();
    L29:
        if (r17.hasNext() == false) goto L33;
        ICastSink r18 = (ICastSink) ((ConcurrentHashMap) r14.i).get((String) r17.next());
        if (r18 == null) goto L29;
        r18.setServerListener(r15);
        goto L29
    L33:
        Iterator r20 = ((ConcurrentHashMap) r14.i).keySet().iterator();
    L35:
        if (r20.hasNext() == false) goto L39;
        ICastSink r21 = (ICastSink) ((ConcurrentHashMap) r14.i).get((String) r20.next());
        if (r21 == null) goto L35;
        r21.setServerListener(r13);
    L39:
        FLogger r22 = FLogger.a;
        r22.i(this.a, "setMirrorListener: byteCastSink: " + this.e);
        com.ss.cast.sink.api.g r23 = this.e;
        if (r23 == null) goto L47;
        k r24 = new k(this);
        com.ss.cast.sink.j r25 = r23.a;
        r25.getClass();
        ByteCastSinkImpl.11 r26 = new ByteCastSinkImpl.11(r24);
        r25.v = r26;
        ICastSink r27 = r25.d;
        if (r27 == null) goto L44;
        r27.setMirrorListener(r26);
    L44:
        ICastSink r28 = r25.c;
        if (r28 == null) goto L47;
        r28.setMirrorListener(r26);
    L47:
        r22.i(this.a, "setMessageListener: byteCastSink: " + this.e);
        com.ss.cast.sink.api.g r30 = this.e;
        if (r30 == null) goto L58;
        j r31 = new j(this);
        com.ss.cast.sink.j r32 = r30.a;
        ICastSink r33 = r32.a;
        if (r33 == null) goto L52;
        r33.setMessageListener(r31);
    L52:
        ICastSink r34 = r32.d;
        if (r34 == null) goto L55;
        r34.setMessageListener(r31);
    L55:
        ICastSink r35 = r32.b;
        if (r35 == null) goto L58;
        r35.setMessageListener(r31);
    L58:
        w("initByteCastSink");
        return;
    L60:
        th = move-exception;
        throw th;
    }

    public final void w(String r8) {
        Object r2 = this.d;
        monitor-enter(r2);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.c == true) goto L9;
        FLogger.a.i(this.a, "DoraByteCastManager.setByteRandomPortOption: can't set, ignore: ".concat(r8));     // Catch: Throwable -> L23
        monitor-exit(r2);
        return;
    L9:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L23
        if (r0 == null) goto L16;
        DeviceService r1 = r0.device();     // Catch: Throwable -> L23
        if (r1 == null) goto L16;
        if (r1.n0("bdp") != true) goto L16;
        boolean r3 = true;
    L17:
        com.ss.cast.sink.api.g r5 = this.e;     // Catch: Throwable -> L23
        if (r5 == null) goto L20;
        r5.b(new Object[]{Boolean.valueOf(r3)});     // Catch: Throwable -> L23
    L20:
        FLogger.a.i(this.a, "DoraByteCastManager.setByteRandomPortOption: sink.setOption.enableRandomPort: " + r3 + ", from " + r8);     // Catch: Throwable -> L23
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r2);
        return;
    L16:
        r3 = false;
        goto L17
    }

    public final void x(long r4) {
        long r5 = r4 - 5000;
    L4:
        if (this.x.size() <= 1) goto L9;
        if (((q) CollectionsKt.elementAt(this.x, 1)).b > r5) goto L9;
        this.x.removeFirst();
    L9:
        if (this.x.size() <= 64) goto L11;
        this.x.removeFirst();
        goto L9
    }

    public final void y(Boolean r4) {
        if (r4 == null) goto L4;
        boolean r0 = r4.booleanValue();
    L5:
        if (r0 == true) goto L14;
        Object r1 = this.w;
        monitor-enter(r1);
        this.x.clear();     // Catch: Throwable -> L11
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r1);
        this.t = null;
    L11:
        th = move-exception;
        throw th;
    L14:
        if (r4 == null) goto L16;
    L18:
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L23;
        com.larus.dora.impl.serviceimpl.h r6 = r5.debug();
        if (r6 == null) goto L23;
        r6.k(r0);
    L23:
        this.v = r0;
        return;
    L16:
        if (this.v != r0) goto L18;
        return;
    L4:
        r0 = r();
        goto L5
    }

    public static final void k(DoraByteCastManager r27, t39.a r28) {
        r27.getClass();
        long r2 = SystemClock.elapsedRealtime();
        p r4 = r27.t;
        if (r27.r() == true) goto L5;
        r27.y(null);
        return;
    L5:
        r27.y(null);
        IDoraService r5 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r5 == null) goto L10;
        com.larus.dora.impl.serviceimpl.h r6 = r5.debug();
        if (r6 == null) goto L10;
        r6.j();
    L10:
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L15;
        com.larus.dora.impl.serviceimpl.h r8 = r7.debug();
        if (r8 == null) goto L15;
        t39.o r9 = r8.b();
    L16:
        Object r10 = r27.w;
        monitor-enter(r10);
        r27.x(r2);     // Catch: Throwable -> L124
        if (r27.x.isEmpty() == false) goto L23;
        n r0 = new n(0);     // Catch: Throwable -> L124
        monitor-exit(r10);
        p r25 = r4;
        t39.o r26 = r9;
    L46:
        if (r26 == null) goto L48;
        t39.o r11 = r26;
        long r12 = r11.e;
    L49:
        if (r11 == null) goto L65;
        Integer r13 = Integer.valueOf(r11.d);
        if (r13.intValue() >= 0) goto L53;
    L59:
        boolean r14 = false;
    L60:
        if (r14 == true) goto L63;
        r13 = null;
    L63:
        if (r13 == null) goto L65;
        int r15 = r13.intValue();
    L66:
        int r16 = r28.a;
        int r17 = r28.b;
        int r18 = r28.c;
        int r20 = r28.d;
        if (r11 == null) goto L70;
        String r110 = r11.a;
        if (r110 == null) goto L70;
    L71:
        if (r11 == null) goto L73;
        int r111 = r11.b;
    L74:
        if (r11 == null) goto L76;
        int r112 = r11.c;
    L77:
        if (r25 == null) goto L100;
        t39.o r210 = r11;
        p r113 = r25;
        Double r21 = Double.valueOf(r113.a);
        double r114 = r21.doubleValue();
        if (Double.isInfinite(r114) == false) goto L81;
    L83:
        boolean r22 = false;
    L84:
        if (r22 == true) goto L86;
    L94:
        boolean r3 = false;
    L95:
        if (r3 == true) goto L98;
        r21 = null;
    L98:
        if (r21 == null) goto L101;
        double r23 = r21.doubleValue();
    L102:
        if (r210 == null) goto L104;
        t39.o r24 = r210;
        int r30 = r24.f;
    L105:
        if (r24 == null) goto L107;
        int r31 = r24.g;
    L108:
        double r115 = r0.a;
        double r116 = r23;
        double r1 = r0.b;
        Intrinsics.checkNotNullParameter(r110, "networkStatus");
        IDoraService r32 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r32 == null) goto L134;
        Pair[] r33 = new Pair[13];
        r33[0] = TuplesKt.to("bw_avg_kbps", Integer.valueOf(r16));
        int r34 = 1;
        r33[1] = TuplesKt.to("average_bitrate_kbps", Double.valueOf(r116));
        r33[2] = TuplesKt.to("transport_rtt_avg", Integer.valueOf(r30));
        r33[3] = TuplesKt.to("transport_rtt_max", Integer.valueOf(r31));
        r33[4] = TuplesKt.to("mmt_target_bitrate_avg", Double.valueOf(r115));
        r33[5] = TuplesKt.to("mmt_target_bitrate_min", Double.valueOf(r1));
        r33[6] = TuplesKt.to("est_bw", Integer.valueOf(r17));
        if (r18 <= 0) goto L113;
        int r35 = 1;
    L114:
        r33[7] = TuplesKt.to("is_bluetooth_transmit_failed", Integer.valueOf(r35));
        r33[8] = TuplesKt.to("flow_level", Integer.valueOf(r20));
        r33[9] = TuplesKt.to("phone_network_status", r110);
        r33[10] = TuplesKt.to("is_a2dp_playing", Integer.valueOf(r111));
        if (r15 < 0) goto L119;
        if (r15 >= 2) goto L120;
        r34 = 0;
    L120:
        r33[11] = TuplesKt.to("is_glasses_dual_connected", Integer.valueOf(r34));
        r33[12] = TuplesKt.to("bluetooth_connected_device_count", Integer.valueOf(r112));
        r32.m1("dora_bluetooth_rtc_bandwidth", MapsKt.mapOf(r33));
        return;
    L119:
        r34 = -1;
        goto L120
    L113:
        r35 = 0;
        goto L114
    L134:
        return;
    L107:
        r31 = -1;
        goto L108
    L104:
        r24 = r210;
        r30 = -1;
    L101:
        r23 = -1.0d;
        goto L102
    L86:
        if (r114 < 0.0d) goto L94;
        long r117 = r113.b;
        if (r117 <= 0) goto L94;
        if (r117 > r2) goto L94;
        if ((r2 - r117) > 6000) goto L94;
        r3 = true;
        goto L95
    L81:
        if (Double.isNaN(r114) == true) goto L83;
        r22 = true;
        goto L84
    L100:
        r210 = r11;
        goto L101
    L76:
        r112 = -1;
        goto L77
    L73:
        r111 = -1;
    L70:
        r110 = "unknown";
        goto L71
    L53:
        if (r12 <= 0) goto L59;
        if (r12 > r2) goto L59;
        if ((r2 - r12) > 10000) goto L59;
        r14 = true;
    L65:
        r15 = -1;
        goto L66
    L48:
        r11 = r26;
        r12 = 0;
        goto L49
    L23:
        long r118 = r2 - 5000;
        Iterator<q> r36 = r27.x.iterator();     // Catch: Throwable -> L124
        q r37 = r36.next();     // Catch: Throwable -> L124
        long r38 = Math.max(r118, r37.b);     // Catch: Throwable -> L124
        Object r211 = r10;
        long r40 = Long.MAX_VALUE;
        double r212 = 0.0d;
        long r213 = 0;
    L128:
    L122:
        th = th;
    L126:
        monitor-exit(r211);
        throw th;
    L27:
        if (r36.hasNext() == false) goto L33;
        q r119 = r36.next();     // Catch: Throwable -> L122
        long r120 = Math.min(r2, r119.b);     // Catch: Throwable -> L122
        if (r120 <= r38) goto L32;
        long r121 = r120 - r38;     // Catch: Throwable -> L122
        long r41 = r37.a;     // Catch: Throwable -> L122
        r212 = r212 + (r41 * r121);     // Catch: Throwable -> L122
        r213 = r213 + r121;     // Catch: Throwable -> L122
        r40 = Math.min(r40, r41);     // Catch: Throwable -> L122
    L32:
        r38 = Math.max(r118, r119.b);     // Catch: Throwable -> L122
        r36 = r36;
        r37 = r119;
        r4 = r4;
        r9 = r9;
        goto L128
    L33:
        r25 = r4;
        r26 = r9;
        if (r2 <= r38) goto L36;
        long r42 = r2 - r38;     // Catch: Throwable -> L122
        long r43 = r37.a;     // Catch: Throwable -> L122
        r212 = r212 + (r43 * r42);     // Catch: Throwable -> L122
        r213 = r213 + r42;     // Catch: Throwable -> L122
        r40 = Math.min(r40, r43);     // Catch: Throwable -> L122
    L36:
        long r44 = r213;
        if (r44 > 0) goto L39;
    L44:
        r0 = new n(0);     // Catch: Throwable -> L122
        monitor-exit(r211);
        goto L46
    L39:
        if (r40 == j0.G2_OTA_RECOVERY_BLOCK_FOREVER) goto L44;
        n r45 = new n((r212 / r44) / 1000.0d, r40 / 1000.0d);     // Catch: Throwable -> L122
        monitor-exit(r211);
        r0 = r45;
    L124:
        th = th;
        r211 = r10;
    L15:
        r9 = null;
        goto L16
    }

    public static final void l(DoraByteCastManager r5, boolean r6) {
        if (r5.o == true) goto L5;
        FLogger.a.i(r5.a, "handleWifiStateChanged ignored: not ready, wifiEnabled=" + r6);
        return;
    L5:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L10;
        AbilityService r1 = r0.o0();
        if (r1 == null) goto L10;
        boolean r2 = r1.k();
    L11:
        if (r2 == true) goto L13;
    L15:
        if (r2 == false) goto L17;
    L19:
        FLogger.a.i(r5.a, "handleWifiStateChanged skipped: wifiEnabled=" + r6 + ", willUseP2P=" + r2 + ", currentEnableStartUsbServer=" + r5.q);
        return;
    L17:
        if (Intrinsics.areEqual(r5.q, Boolean.FALSE) == false) goto L19;
        FLogger.a.i(r5.a, "wifi off or non-p2p: reinit TCP -> UDP");
        r5.q(true);
        r5.u();
        return;
    L13:
        if (Intrinsics.areEqual(r5.q, Boolean.TRUE) == false) goto L15;
        FLogger.a.i(r5.a, "wifi on & p2p: reinit UDP -> TCP");
        r5.q(false);
        r5.u();
        return;
    L10:
        r2 = false;
        goto L11
    }

    public static final s m(DoraByteCastManager r9, JSONObject r10) {
        r9.getClass();
        return new s(r10.optInt("bwdl_connect_time", 0), r10.optInt("cast_connect_time", 0), r10.optInt("cast_init_time", 0), r10.optInt("cast_start_mirror_time", 0), r10.optInt("height", 0), r10.optInt("mirror_fps", 0), r10.optInt("width", 0), r10.optInt("trans_type", 0));
    }

    public static final void n(final DoraByteCastManager r2, final Function0 r3) {
        ((Handler) r2.m.getValue()).post(new com.larus.dora.dorag.res.e(r3, r2));
    }

    public static Integer t(JSONObject r7, String r8) {
        Object r9 = r7.opt(r8);
        if ((r9 instanceof Number) == false) goto L5;
        Number r10 = (Number) r9;
    L6:
        if (r10 != null) goto L8;
        return null;
    L8:
        long r1 = r10.longValue();
        Integer r11 = Integer.valueOf((int) r1);
        boolean r5 = false;
        if (r1 == r11.intValue()) goto L11;
    L16:
        if (r5 == true) goto L18;
        return null;
    L18:
        return r11;
    L11:
        if (r10.doubleValue() != r1) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
        r5 = true;
        goto L16
    L13:
        r2 = false;
        goto L14
    L5:
        r10 = null;
        goto L6
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void i(Context r8, DoraByteCastManager$registerWifiStateReceiver$receiver$1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    public static final void j(DoraByteCastManager r4, String r5, tf9.a r6) {
        t39.g r0 = r4.b;
        if (r0 != null) goto L5;
        FLogger.a.w(r4.a, "drop video frame: callback not registered, clientId=" + r5 + ", timestampUs=" + r6.c + ", frameType=" + r6.h + ", codec=" + r6.g + ", dataSize=" + r6.a.length);
        return;
    L5:
        r0.b(r6);
    }
}
