package com.obric.aee.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.aee.BuildConfig;
import com.obric.aee.PythonException;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.ss.bduploader.BDAbstractUpload;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.da;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\b\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0002J\u0018\u0010#\u001a\u00020$2\u000e\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013H\u0002J\u0012\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'H\u0003J\u0012\u0010(\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0019H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J(\u00102\u001a\u00020-2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u0015H\u0002J)\u00105\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00042\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000107\"\u00020\u0001H\u0002¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0002J\b\u0010;\u001a\u00020<H\u0007J\u0017\u0010=\u001a\b\u0012\u0004\u0012\u00020/0>H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020AH\u0007J\u001f\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002¢\u0006\u0002\u0010DJ\b\u0010E\u001a\u00020CH\u0002J\u001c\u0010F\u001a\u00020G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0013H\u0002J\u0010\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004H\u0003J!\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u00020'H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010NJ\u0012\u0010O\u001a\u0004\u0018\u00010'2\u0006\u0010J\u001a\u00020\u0004H\u0003J\u0012\u0010P\u001a\u0004\u0018\u00010'2\u0006\u0010J\u001a\u00020\u0004H\u0003J\u0012\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010J\u001a\u00020\u0004H\u0003J\u0012\u0010S\u001a\u0004\u0018\u00010'2\u0006\u0010J\u001a\u00020\u0004H\u0003J\u0010\u0010T\u001a\u00020\u00162\u0006\u00106\u001a\u00020'H\u0002J\u0016\u0010U\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0015J\u0010\u0010W\u001a\u00020-2\u0006\u0010+\u001a\u00020\u0019H\u0002J\u001c\u0010X\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040[J\u0016\u0010X\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0004J\u001c\u0010\\\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040[J\u0016\u0010\\\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0004J\u001c\u0010]\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040[J\u0016\u0010]\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0004J\u001c\u0010^\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040[J\u0016\u0010^\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0004J\u001c\u0010_\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040[J\u0016\u0010_\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0004J\u000e\u0010`\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\nJ\u0018\u0010a\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00192\u0006\u0010b\u001a\u00020cH\u0002J\u0019\u0010d\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002J\u0010\u0010g\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\u0015H\u0002J\u0018\u0010h\u001a\u00020\u00162\u0006\u0010i\u001a\u00020\u00042\u0006\u00106\u001a\u00020'H\u0003J\u0018\u0010j\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00042\u0006\u00106\u001a\u00020'H\u0003J\u0012\u0010k\u001a\u0004\u0018\u00010\u001d2\u0006\u0010*\u001a\u00020\u0004H\u0002J\u0011\u0010l\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010?J%\u0010m\u001a\u00020'2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000107\"\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010nJ1\u0010o\u001a\u00020'2\u0006\u0010.\u001a\u00020/2\u0006\u00106\u001a\u00020'2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010p\u001a\u00020'H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010qJK\u0010r\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u00106\u001a\u00020'2\u0006\u0010i\u001a\u00020\u00042\u0006\u0010p\u001a\u00020'2\u0018\u0010s\u001a\u0014\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00160tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010uJ\u0010\u0010v\u001a\u00020\u00162\u0006\u0010w\u001a\u00020\u0004H\u0003J\u0019\u0010x\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010eJ1\u0010y\u001a\u00020-2\u0006\u0010z\u001a\u00020\u00042\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010}J\u0012\u0010~\u001a\u00020\u007f2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002J\u001b\u0010\u0080\u0001\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0081\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0086\u0001"}, d2 = {"Lcom/obric/aee/impl/EngineBridge;", "", "()V", "DEBUG_JSON_TRUNCATED_MARKER", "", "MAX_DEBUG_JSON_ARRAY_ITEMS", "", "MAX_DEBUG_JSON_STRING_LENGTH", "TAG", "_config", "Lcom/obric/aee/impl/EngineConfig;", "get_config", "()Lcom/obric/aee/impl/EngineConfig;", "_config$delegate", "Lkotlin/Lazy;", "_opt_pipe", "_param", "Lcom/obric/aee/impl/EngineBridge$BridgeInitParam;", "_pipeDispatch", "", "Lkotlin/reflect/KFunction1;", "", "", "_serviceInfos", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/aee/impl/EngineBridge$ServiceInfo;", "_serviceLock", "Lkotlinx/coroutines/sync/Mutex;", "_sessionPool", "Lcom/obric/aee/impl/SessionInfo;", "_sessionWatcher", "buildJsonArray", "Lcom/google/gson/JsonArray;", EventBody.KEY_VALUE, "", "buildJsonObject", "Lcom/google/gson/JsonObject;", "bundleToJson", "bundle", "Landroid/os/Bundle;", "bundleToJsonObject", "cancelSession", "sid", "serv", "checkServiceStop", "", "packInfo", "Lcom/obric/aee/res/PackageInfo;", "lastVisit", "Ljava/util/concurrent/atomic/AtomicLong;", "dispatchSession", "session", "payload", "encodeRunArgs", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)[B", "encodeRunPackage", "eventName", "getAeeVersion", "", "getAllServices", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndroidContext", "Landroid/content/Context;", "getAutoCloseDelay", "", "(Lcom/obric/aee/res/PackageInfo;Ljava/util/concurrent/atomic/AtomicLong;)Ljava/lang/Long;", "getCheckDur", "getLowMemConfig", "Lcom/obric/aee/impl/EngineBridge$AutoCloseConfig;", "cfg", "getPackageInfo", "key", "getServiceInner", "pkg", WsConstants.KEY_EXTRA, "(Lcom/obric/aee/res/PackageInfo;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionArgs", "getSessionContext", "getSessionExtra", "Lcom/obric/aee/impl/SafeBundle;", "getSessionRet", "handleLoadFailureExpired", "handlePipeData", "data", "hasRunningSession", "hostLogD", LocationMonitorConst.TAG, Params.CONTENT, "Lkotlin/Function0;", "hostLogE", "hostLogI", "hostLogV", "hostLogW", "initCfg", "invalidateService", "cause", "", "isServiceAlive", "(Lcom/obric/aee/res/PackageInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "limitDebugJsonString", "onEntryFinish", "onGlobalEvent", "event", "onSessionStreamingResult", "removeSession", "requestPythonGc", "runOptFunc", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runPackage", "context", "(Lcom/obric/aee/res/PackageInfo;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runPackageSteaming", "callback", "Lkotlin/Function2;", "(Lcom/obric/aee/res/PackageInfo;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setThreadName", ActivityLifecycle.NAME, "stopService", "stopServiceByName", "serviceName", "expectedGeneration", "expectedFd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toJsonElement", "Lcom/google/gson/JsonElement;", "watchPackageLife", "(Lcom/obric/aee/impl/EngineBridge$ServiceInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AutoCloseConfig", "BridgeInitParam", "ServiceInfo", "ServiceReplacedException", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EngineBridge {
    private static final String DEBUG_JSON_TRUNCATED_MARKER = "...";
    public static final EngineBridge INSTANCE = null;
    private static final int MAX_DEBUG_JSON_ARRAY_ITEMS = 16;
    private static final int MAX_DEBUG_JSON_STRING_LENGTH = 48;
    private static final String TAG = "ExecutionEngine";
    private static final Lazy _config$delegate = null;
    private static final String _opt_pipe = null;
    private static b _param;
    private static final Map<String, KFunction<Unit>> _pipeDispatch = null;
    private static final ConcurrentHashMap<String, c> _serviceInfos = null;
    private static final kotlinx.coroutines.sync.a _serviceLock = null;
    private static final ConcurrentHashMap<String, com.obric.aee.impl.a> _sessionPool = null;
    private static final ConcurrentHashMap<String, String> _sessionWatcher = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/aee/impl/EngineBridge$ServiceReplacedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class ServiceReplacedException extends RuntimeException {
        public ServiceReplacedException() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/aee/impl/EngineBridge$AutoCloseConfig;", "", "enable", "", LocationMonitorConst.TIMEOUT, "", "whiteList", "", "", "(ZJLjava/util/Set;)V", "getEnable", "()Z", "getTimeout", "()J", "getWhiteList", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f5871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f5872b;
        private final Set<String> c;

        public a(boolean r3, long r4, Set<String> r6) {
            Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "whiteList");
            this.f5871a = r3;
            this.f5872b = r4;
            this.c = r7;
        }

        public final boolean a() {
            return this.f5871a;
        }

        public final long b() {
            return this.f5872b;
        }

        public final Set<String> c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (this.f5871a == r10.f5871a) goto L12;
            return false;
        L12:
            if (this.f5872b == r10.f5872b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean r0 = this.f5871a;
            ?? r1 = r0;
            if (r0 == false) goto L6;
            r1 = 1;
        L6:
            return (((r1 * 31) + Long.hashCode(this.f5872b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "AutoCloseConfig(enable=" + this.f5871a + ", timeout=" + this.f5872b + ", whiteList=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/aee/impl/EngineBridge$BridgeInitParam;", "", "cfg", "Lcom/obric/aee/impl/EngineConfig;", "autoCloseConfig", "Lcom/obric/aee/impl/EngineBridge$AutoCloseConfig;", "powerMgr", "Landroid/os/PowerManager;", "(Lcom/obric/aee/impl/EngineConfig;Lcom/obric/aee/impl/EngineBridge$AutoCloseConfig;Landroid/os/PowerManager;)V", "getAutoCloseConfig", "()Lcom/obric/aee/impl/EngineBridge$AutoCloseConfig;", "getCfg", "()Lcom/obric/aee/impl/EngineConfig;", "getPowerMgr", "()Landroid/os/PowerManager;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EngineConfig f5873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f5874b;
        private final PowerManager c;

        public b(EngineConfig r2, a r3, PowerManager r4) {
            Intrinsics.checkNotNullParameter(r2, "cfg");
            Intrinsics.checkNotNullParameter(r3, "autoCloseConfig");
            this.f5873a = r2;
            this.f5874b = r3;
            this.c = r4;
        }

        public final EngineConfig a() {
            return this.f5873a;
        }

        public final a b() {
            return this.f5874b;
        }

        public final PowerManager c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f5873a, r6.f5873a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f5874b, r6.f5874b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f5873a.hashCode() * 31) + this.f5874b.hashCode()) * 31;
            PowerManager r2 = this.c;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "BridgeInitParam(cfg=" + this.f5873a + ", autoCloseConfig=" + this.f5874b + ", powerMgr=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003Ja\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00101\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00065"}, d2 = {"Lcom/obric/aee/impl/EngineBridge$ServiceInfo;", "", "pkg", "Lcom/obric/aee/res/PackageInfo;", "fd", "", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "lastVisit", "Ljava/util/concurrent/atomic/AtomicLong;", "sessionCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "watchSignal", "Lkotlinx/coroutines/channels/Channel;", "", "daemon", "Lkotlinx/coroutines/Job;", "acceptingSessions", "", "(Lcom/obric/aee/res/PackageInfo;ILjava/lang/String;Ljava/util/concurrent/atomic/AtomicLong;Ljava/util/concurrent/atomic/AtomicInteger;Lkotlinx/coroutines/channels/Channel;Lkotlinx/coroutines/Job;Z)V", "getAcceptingSessions", "()Z", "setAcceptingSessions", "(Z)V", "getDaemon", "()Lkotlinx/coroutines/Job;", "setDaemon", "(Lkotlinx/coroutines/Job;)V", "getFd", "()I", "getGeneration", "()Ljava/lang/String;", "getLastVisit", "()Ljava/util/concurrent/atomic/AtomicLong;", "getPkg", "()Lcom/obric/aee/res/PackageInfo;", "getSessionCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "getWatchSignal", "()Lkotlinx/coroutines/channels/Channel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aee.res.b f5875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5876b;
        private final String c;
        private final AtomicLong d;
        private final AtomicInteger e;
        private final i<Unit> f;
        private bx g;
        private boolean h;

        public c(com.obric.aee.res.b r3, int r4, String r5, AtomicLong r6, AtomicInteger r7, i<Unit> r8, bx r9, boolean r10) {
            i<Unit> r11 = (i) ZeusTransformUtils.wrapperContextForParams(r8, i.class, "com.obric.memorydata.plugin");
            bx r12 = (bx) ZeusTransformUtils.wrapperContextForParams(r9, bx.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "pkg");
            Intrinsics.checkNotNullParameter(r5, PendingPersonalInfoNotificationTask.KEY_GENERATION);
            Intrinsics.checkNotNullParameter(r6, "lastVisit");
            Intrinsics.checkNotNullParameter(r7, "sessionCount");
            Intrinsics.checkNotNullParameter(r11, "watchSignal");
            this.f5875a = r3;
            this.f5876b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r11;
            this.g = r12;
            this.h = r10;
        }

        public /* synthetic */ c(com.obric.aee.res.b r13, int r14, String r15, AtomicLong r16, AtomicInteger r17, i r18, bx r19, boolean r20, int r21, DefaultConstructorMarker r22) {
            i r9 = (i) ZeusTransformUtils.wrapperContextForParams(r18, i.class, "com.obric.memorydata.plugin");
            bx r1 = (bx) ZeusTransformUtils.wrapperContextForParams(r19, bx.class, "com.obric.memorydata.plugin");
            if ((r21 & 64) == 0) goto L5;
            r1 = null;
        L5:
            bx r10 = r1;
            if ((r21 & 128) == 0) goto L8;
            boolean r11 = true;
        L9:
            this(r13, r14, r15, r16, r17, r9, r10, r11);
            return;
        L8:
            r11 = r20;
            goto L9
        }

        public final com.obric.aee.res.b a() {
            return this.f5875a;
        }

        public final void a(bx r3) {
            this.g = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        }

        public final void a(boolean r1) {
            this.h = r1;
        }

        public final int b() {
            return this.f5876b;
        }

        public final String c() {
            return this.c;
        }

        public final AtomicLong d() {
            return this.d;
        }

        public final AtomicInteger e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f5875a, r6.f5875a) == true) goto L12;
            return false;
        L12:
            if (this.f5876b == r6.f5876b) goto L15;
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
            if (this.h == r6.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final i<Unit> f() {
            return this.f;
        }

        public final bx g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r0 = ((((((((((this.f5875a.hashCode() * 31) + Integer.hashCode(this.f5876b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            bx r1 = this.g;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            boolean r4 = this.h;
            ?? r5 = r4;
            if (r4 == false) goto L10;
            r5 = 1;
        L10:
            return r3 + r5;
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ServiceInfo(pkg=" + this.f5875a + ", fd=" + this.f5876b + ", generation=" + this.c + ", lastVisit=" + this.d + ", sessionCount=" + this.e + ", watchSignal=" + this.f + ", daemon=" + this.g + ", acceptingSessions=" + this.h + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$getAllServices$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {}, l = {BDAbstractUpload.KeyIsRetryStatesDir}, m = "getAllServices", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        AnonymousClass1(EngineBridge r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getAllServices((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$getServiceInner$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {757, 338}, m = "getServiceInner", n = {"pkg", WsConstants.KEY_EXTRA, "serviceName", "$this$withLock_u24default$iv", "pkg", WsConstants.KEY_EXTRA, "serviceName", "$this$withLock_u24default$iv", PendingPersonalInfoNotificationTask.KEY_GENERATION}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C09831 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C09831(EngineBridge r3, Continuation<? super C09831> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return EngineBridge.access$getServiceInner(this.this$0, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$handleLoadFailureExpired$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge$handleLoadFailureExpired$2", f = "EngineBridge.kt", i = {}, l = {646}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ String $generation;
        final /* synthetic */ Integer $serviceFd;
        final /* synthetic */ String $serviceName;
        int label;

        AnonymousClass2(String r3, String r4, Integer r5, Bundle r6, Continuation<? super AnonymousClass2> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$serviceName = r3;
            this.$generation = r4;
            this.$serviceFd = r5;
            this.$args = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$serviceName, this.$generation, this.$serviceFd, this.$args, r6), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            EngineBridge.access$get_config(EngineBridge.INSTANCE).onGlobalEvent("ServiceLoadFailed", this.$args);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            EngineBridge r9 = EngineBridge.INSTANCE;
            String r2 = this.$serviceName;
            String r3 = this.$generation;
            Integer r4 = this.$serviceFd;
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (EngineBridge.access$stopServiceByName(r9, r2, r3, r4, r5) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$invalidateService$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge$invalidateService$2", f = "EngineBridge.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    static final class C09872 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ c $serv;
        private /* synthetic */ Object L$0;
        int label;

        C09872(c r3, Continuation<? super C09872> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$serv = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            C09872 r0 = new C09872(this.$serv, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C09872) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C09872.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
        L13:
            Object r9 = Result.m1421constructorimpl((Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        L17:
            final c r7 = this.$serv;
            final Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
            if (r10 == null) goto L21;
            EngineBridge.INSTANCE.hostLogD(EngineBridge.TAG, (Function0) ZeusTransformUtils.preCheckCast(new EngineBridge$invalidateService$2$2$1(r7, r10), Function0.class, "com.obric.memorydata.plugin"));
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
            al r11 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            c r12 = this.$serv;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
            EngineBridge r3 = EngineBridge.INSTANCE;     // Catch: Throwable -> L15
            Object[] r4 = {"stop_service", r12.a().g(), r12.c()};     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            r8 = EngineBridge.access$runOptFunc(r3, r4, this);     // Catch: Throwable -> L15
            if (r8 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$isServiceAlive$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {}, l = {420}, m = "isServiceAlive", n = {}, s = {})
    static final class C09881 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C09881(EngineBridge r3, Continuation<? super C09881> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.isServiceAlive(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$runOptFunc$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0}, l = {752}, m = "runOptFunc", n = {"ret", "sid", "buffer"}, s = {"L$0", "L$1", "L$2"})
    static final class C09891 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C09891(EngineBridge r3, Continuation<? super C09891> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return EngineBridge.access$runOptFunc(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$runPackage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {369, 752}, m = "runPackage", n = {"this", "packInfo", "args", "event", "context", "sid", WsConstants.KEY_EXTRA, "ret", "packStartTime", "this", "packInfo", "args", "event", "context", "sid", WsConstants.KEY_EXTRA, "ret", "serv", "packStartTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0"})
    static final class C09901 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C09901(EngineBridge r3, Continuation<? super C09901> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runPackage(null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$runPackageSteaming$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {398, 752}, m = "runPackageSteaming", n = {"this", "packInfo", "args", "event", "context", "callback", "sid", WsConstants.KEY_EXTRA, "ret", "packStartTime", "this", "packInfo", "args", "event", "context", "callback", "sid", WsConstants.KEY_EXTRA, "ret", "serv", "packStartTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "J$0"})
    static final class C09911 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C09911(EngineBridge r3, Continuation<? super C09911> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runPackageSteaming(null, null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$stopServiceByName$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 0}, l = {757, 685}, m = "stopServiceByName", n = {"this", "serviceName", "expectedGeneration", "expectedFd", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C09921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C09921(EngineBridge r3, Continuation<? super C09921> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return EngineBridge.access$stopServiceByName(this.this$0, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$watchPackageLife$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3}, l = {702, TypedValues.TransitionType.TYPE_INTERPOLATOR, 710, 716}, m = "watchPackageLife", n = {"this", "serv", "packInfo", "lastVisit", "watchSignal", "serviceName", "timeoutDur", "this", "serv", "packInfo", "lastVisit", "watchSignal", "serviceName", "timeoutDur", "this", "serv", "pingTime", "packInfo", "lastVisit", "watchSignal", "serviceName", "timeoutDur"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0"})
    static final class C09931 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C09931(EngineBridge r3, Continuation<? super C09931> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return EngineBridge.access$watchPackageLife(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$watchPackageLife$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge$watchPackageLife$3", f = "EngineBridge.kt", i = {}, l = {TypedValues.TransitionType.TYPE_INTERPOLATOR}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ i<Unit> $watchSignal;
        int label;

        AnonymousClass3(i<Unit> r3, Continuation<? super AnonymousClass3> r4) {
            i<Unit> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$watchSignal = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.$watchSignal, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            i<Unit> r6 = this.$watchSignal;
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    static {
        EngineBridge r0 = new EngineBridge();
        INSTANCE = r0;
        _sessionPool = new ConcurrentHashMap();
        _sessionWatcher = new ConcurrentHashMap();
        _serviceInfos = new ConcurrentHashMap();
        _serviceLock = kotlinx.coroutines.sync.c.a(false, 1, null);
        _config$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(EngineBridge$_config$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        _opt_pipe = "opt_entry";
        _pipeDispatch = MapsKt.mapOf(TuplesKt.to("finish_entry", new EngineBridge$_pipeDispatch$1(r0)));
    }

    private EngineBridge() {
    }

    public static final /* synthetic */ void access$cancelSession(EngineBridge r0, String r1, c r2) {
        r0.cancelSession(r1, r2);
    }

    public static final /* synthetic */ boolean access$dispatchSession(EngineBridge r0, String r1, c r2, com.obric.aee.impl.a r3, byte[] r4) {
        return r0.dispatchSession(r1, r2, r3, r4);
    }

    public static final /* synthetic */ byte[] access$encodeRunPackage(EngineBridge r0, String r1, String r2) {
        return r0.encodeRunPackage(r1, r2);
    }

    public static final /* synthetic */ Object access$getServiceInner(EngineBridge r2, com.obric.aee.res.b r3, Bundle r4, Continuation r5) {
        return r2.getServiceInner(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ EngineConfig access$get_config(EngineBridge r0) {
        return r0.get_config();
    }

    public static final /* synthetic */ String access$get_opt_pipe$p() {
        return _opt_pipe;
    }

    public static final /* synthetic */ b access$get_param$p() {
        return _param;
    }

    public static final /* synthetic */ ConcurrentHashMap access$get_sessionPool$p() {
        return _sessionPool;
    }

    public static final /* synthetic */ void access$onEntryFinish(EngineBridge r0, byte[] r1) {
        r0.onEntryFinish(r1);
    }

    public static final /* synthetic */ Object access$runOptFunc(EngineBridge r2, Object[] r3, Continuation r4) {
        return r2.runOptFunc(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$stopServiceByName(EngineBridge r2, String r3, String r4, Integer r5, Continuation r6) {
        return r2.stopServiceByName(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$watchPackageLife(EngineBridge r2, c r3, Continuation r4) {
        return r2.watchPackageLife(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final JsonArray buildJsonArray(Iterable<?> r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        JsonArray r6 = new JsonArray();
        Iterator r7 = r4.iterator();
        int r1 = 0;
    L4:
        if (r1 >= 16) goto L10;
        if (r7.hasNext() == false) goto L7;
        r6.add(INSTANCE.toJsonElement(r7.next()));
        r1 = r1 + 1;
        goto L4
    L7:
        return r6;
    L10:
        if (r7.hasNext() == false) goto L12;
        r6.add((JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(DEBUG_JSON_TRUNCATED_MARKER), JsonElement.class, "com.obric.memorydata.plugin"));
    L12:
        return r6;
    }

    private final JsonObject buildJsonObject(Map<?, ?> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        JsonObject r6 = new JsonObject();
        Iterator r7 = r4.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if (r2 == null) goto L9;
        String r8 = r2.toString();
        if (r8 == null) goto L9;
    L10:
        r6.add(r8, INSTANCE.toJsonElement(r3));
    L9:
        r8 = "null";
        goto L10
    L11:
        return r6;
    }

    private final String bundleToJson(Bundle r1) {
        String r0 = bundleToJsonObject(r1).toString();
        Intrinsics.checkNotNullExpressionValue(r0, "bundleToJsonObject(bundle).toString()");
        return r0;
    }

    private final JsonObject bundleToJsonObject(Bundle r6) {
        JsonObject r0 = new JsonObject();
        if (r6 != null) goto L5;
        return r0;
    L5:
        Iterator<String> r1 = r6.keySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        r0.add(r2, toJsonElement(r6.get(r2)));
        goto L7
    L9:
        return r0;
    }

    private final void cancelSession(final String r4, final c r5) {
        monitor-enter(r5);
        EngineBridge r3 = INSTANCE;     // Catch: Throwable -> L14
        com.obric.aee.impl.a r0 = r3.removeSession(r4);     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        SafeBundle r1 = r0.d();     // Catch: Throwable -> L14
        if (r1 == null) goto L19;
        r1.detach();     // Catch: Throwable -> L14
    L19:
        Long.valueOf(HostExtension.INSTANCE.a(r5.b(), r3.encodeRunPackage(r4, "_CANCEL")));     // Catch: Exception -> L10 Throwable -> L14
    L10:
        e = move-exception;
        INSTANCE.hostLogD(TAG, (Function0) ZeusTransformUtils.preCheckCast(new EngineBridge$cancelSession$1$1$1(r5, r4, e), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r5);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private final boolean checkServiceStop(com.obric.aee.res.b r8, AtomicLong r9) {
        b r7 = _param;
        if (r7 == null) goto L16;
        a r10 = r7.b();
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.a() == true) goto L10;
        return false;
    L10:
        if (r10.c().contains(r8.a()) == true) goto L20;
        long r1 = SystemClock.elapsedRealtime();
        if ((r9.get() + (r10.b() * ((long) 1000))) >= r1) goto L18;
        return true;
    L18:
        return false;
    L20:
        return false;
    L16:
        return false;
    }

    private final boolean dispatchSession(final String r7, final c r8, com.obric.aee.impl.a r9, byte[] r10) {
        monitor-enter(r8);
        boolean r0 = false;
        if (r8.h() == true) goto L11;
        SafeBundle r6 = r9.d();     // Catch: Throwable -> L46
        if (r6 == null) goto L8;
        r6.detach();     // Catch: Throwable -> L46
    L8:
        monitor-exit(r8);
        return false;
    L11:
        if (_sessionPool.putIfAbsent(r7, r9) == null) goto L18;
        SafeBundle r11 = r9.d();     // Catch: Throwable -> L46
        if (r11 == null) goto L15;
        r11.detach();     // Catch: Throwable -> L46
    L15:
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(r9.g(), Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L46
        r12.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Duplicated session id: " + r7), Throwable.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L46
        monitor-exit(r8);
        return true;
    L18:
        r8.e().incrementAndGet();     // Catch: Throwable -> L46
        r8.f().mo54trySendJP2dKIU(Unit.INSTANCE);     // Catch: Throwable -> L46
        r9.g().a((Function1) ZeusTransformUtils.preCheckCast(new EngineBridge$dispatchSession$1$1(r7, r8), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L46
        if (r9.g().a() == true) goto L49;
        monitor-exit(r8);
        return true;
    L49:
        long r2 = HostExtension.INSTANCE.a(r8.b(), r10);     // Catch: Throwable -> L30
        if (r2 != r10.length) goto L25;
        boolean r14 = true;
    L26:
        if (r14 == false) goto L29;
    L44:
        monitor-exit(r8);
        return true;
    L29:
        throw new IllegalStateException(("Incomplete pipe write: " + r2 + '/' + r10.length).toString());     // Catch: Throwable -> L30
    L25:
        r14 = false;
    L30:
        th = move-exception;
        EngineBridge r15 = INSTANCE;     // Catch: Throwable -> L46
        com.obric.aee.impl.a r16 = r15.removeSession(r7);     // Catch: Throwable -> L46
        if (r16 == null) goto L37;
        SafeBundle r17 = r16.d();     // Catch: Throwable -> L46
        if (r17 == null) goto L36;
        r17.detach();     // Catch: Throwable -> L46
    L36:
        Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(r16.g(), Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L46
        r18.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(th)));     // Catch: Throwable -> L46
    L37:
        String r20 = th.getMessage();     // Catch: Throwable -> L46
        if (r20 != null) goto L40;
    L42:
        if (r0 == true) goto L44;
        r15.invalidateService(r8, th);     // Catch: Throwable -> L46
        goto L44
    L40:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("pipe full", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) != true) goto L42;
        r0 = true;
    L46:
        th = move-exception;
        throw th;
    }

    private final byte[] encodeRunArgs(String r5, Object... r6) {
        MessageBufferPacker r4 = MessagePack.newDefaultBufferPacker();
        r4.packArrayHeader(r6.length + 1);
        r4.packString(r5);
        int r7 = r6.length;
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L26;
        Object r1 = r6[r0];
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L8;
        r4.packString((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"));
    L25:
        r0 = r0 + 1;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L11;
        r4.packInt(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L25
    L11:
        if (ZeusTransformUtils.instanceOf(r1, Short.class) == false) goto L14;
        r4.packShort(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).shortValue());
        goto L25
    L14:
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L17;
        r4.packLong(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L25
    L17:
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L20;
        r4.packDouble(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L25
    L20:
        if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L23;
        r4.packBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L25
    L23:
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L25;
        r4.packFloat(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L25
    L26:
        byte[] r8 = r4.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r8, "newDefaultBufferPacker()…}\n        }.toByteArray()");
        return r8;
    }

    private final byte[] encodeRunPackage(String r2, String r3) {
        MessageBufferPacker r1 = MessagePack.newDefaultBufferPacker();
        r1.packArrayHeader(2);
        r1.packString(r2);
        r1.packString(r3);
        byte[] r4 = r1.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r4, "newDefaultBufferPacker()…)\n        }.toByteArray()");
        return r4;
    }

    private final Long getAutoCloseDelay(com.obric.aee.res.b r5, AtomicLong r6) {
        b r4 = _param;
        if (r4 == null) goto L14;
        a r7 = r4.b();
        if (r7 == null) goto L14;
        if (r7.a() == false) goto L14;
        if (r7.c().contains(r5.a()) == true) goto L14;
        return Long.valueOf(RangesKt.coerceAtLeast((r6.get() + (r7.b() * ((long) 1000))) - SystemClock.elapsedRealtime(), 0));
    L14:
        return null;
    }

    private final long getCheckDur() {
        b r2 = _param;
        boolean r0 = true;
        if (r2 == null) goto L9;
        PowerManager r3 = r2.c();
        if (r3 == null) goto L9;
        if (r3.isPowerSaveMode() != true) goto L9;
    L10:
        if (r0 == false) goto L12;
        return 60000;
    L12:
        return 5000;
    L9:
        r0 = false;
        goto L10
    }

    private final a getLowMemConfig(Map<String, String> r14) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r13.getOrDefault("autoclose_mode", ""), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        switch(r15.hashCode()) {
            case -1609594047: goto L21;
            case -1298848381: goto L18;
            case 49: goto L15;
            case 3551: goto L12;
            case 119527: goto L9;
            case 3569038: goto L6;
            default: goto L50;
        };
    L50:
        boolean r16 = false;
    L25:
        Long r2 = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r13.getOrDefault("autoclose_service_timeout", ""), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        if (r2 == null) goto L28;
        long r5 = r2.longValue();
    L29:
        long r6 = RangesKt.coerceAtLeast(r5, 1);
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13.getOrDefault("autoclose_whitelist", ""), CharSequence.class, "com.obric.memorydata.plugin"), new char[]{',', ';', '\n', '\r', '\t'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r17.iterator();
    L31:
        if (r18.hasNext() == false) goto L33;
        r1.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L31
    L33:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r19.iterator();
    L35:
        if (r110.hasNext() == false) goto L43;
        Object r4 = r110.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L39;
        boolean r7 = true;
    L40:
        if (r7 == false) goto L35;
        r3.add(r4);
        goto L35
    L39:
        r7 = false;
        goto L40
    L43:
        return new a(r16, r6, CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
    L28:
        r5 = 300;
        goto L29
    L6:
        if (r15.equals("true") == false) goto L51;
    L23:
        r16 = true;
        goto L25
    L51:
        r16 = false;
        goto L25
    L9:
        if (r15.equals("yes") == true) goto L23;
        r16 = false;
        goto L25
    L12:
        if (r15.equals(f.f) == true) goto L23;
        r16 = false;
        goto L25
    L15:
        if (r15.equals("1") == true) goto L23;
        r16 = false;
        goto L25
    L18:
        if (r15.equals("enable") == true) goto L23;
        r16 = false;
        goto L25
    L21:
        if (r15.equals("enabled") == true) goto L23;
        r16 = false;
        goto L25
    }

    private final String getPackageInfo(String r2) {
        c r1 = (c) ZeusTransformUtils.preCheckCast(_serviceInfos.get(r2), c.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return "{}";
    L6:
        String r3 = new Gson().toJson(r1.a());
        Intrinsics.checkNotNullExpressionValue(r3, "Gson().toJson(info.pkg)");
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private final Object getServiceInner(com.obric.aee.res.b r22, Bundle r23, Continuation<? super c> r24) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, C09831.class) == false) goto L7;
        C09831 r2 = (C09831) ZeusTransformUtils.preCheckCast(r0, C09831.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = r2.label;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.L$4, String.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r2.L$3, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.L$2, String.class, "com.obric.memorydata.plugin");
        Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(r2.L$1, Bundle.class, "com.obric.memorydata.plugin");
        com.obric.aee.res.b r9 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r2.L$0, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L15
        com.obric.aee.res.b r11 = r9;
        String r13 = r5;
        r4 = r6;
    L53:
        int r12 = ((Bundle) ZeusTransformUtils.preCheckCast(r1, Bundle.class, "com.obric.memorydata.plugin")).getInt(IdlKeys.Result, -1);     // Catch: Throwable -> L48
        if (r12 <= 0) goto L45;
        ?? r10 = r4;
        c r14 = new c(r11, r12, r13, new AtomicLong(SystemClock.elapsedRealtime()), new AtomicInteger(0), l.a(-1, null, null, 6, null), null, false, 192, null);     // Catch: Throwable -> L46
        ((Map) ZeusTransformUtils.preCheckCast(_serviceInfos, Map.class, "com.obric.memorydata.plugin")).put(r7, r14);     // Catch: Throwable -> L46
        r14.a(kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new EngineBridge$getServiceInner$2$1(r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));     // Catch: Throwable -> L46
        r8.putLong(ApiPerfDetails.onLoadServiceEnd, SystemClock.elapsedRealtime());     // Catch: Throwable -> L46
        r10.b(null);
        return r14;
    L45:
        throw new Exception("init service failed.");     // Catch: Throwable -> L46
    L46:
        th = th;
        r4 = IdlKeys.Result;
    L50:
        r4.b(null);
        throw th;
    L48:
        th = th;
        goto L50
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r2.L$3, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r2.L$2, String.class, "com.obric.memorydata.plugin");
        Bundle r17 = (Bundle) ZeusTransformUtils.preCheckCast(r2.L$1, Bundle.class, "com.obric.memorydata.plugin");
        com.obric.aee.res.b r18 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r2.L$0, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);
        String r19 = r16;
        kotlinx.coroutines.sync.a r20 = r15;
    L27:
        r17.putBoolean(ApiPerfDetails.FLAG_NEW_SERVICE, true);     // Catch: Throwable -> L15
        r17.putBoolean("track_is_new_service", true);     // Catch: Throwable -> L15
        r17.putLong(ApiPerfDetails.onLoadServiceStart, SystemClock.elapsedRealtime());     // Catch: Throwable -> L15
        c r110 = (c) ZeusTransformUtils.preCheckCast(_serviceInfos.get(r19), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r110 == null) goto L32;
        r17.putLong(ApiPerfDetails.onLoadServiceEnd, SystemClock.elapsedRealtime());     // Catch: Throwable -> L15
        r20.b(null);
        return r110;
    L32:
        String r111 = UUID.randomUUID().toString();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r111, "randomUUID().toString()");     // Catch: Throwable -> L15
        EngineBridge r112 = INSTANCE;     // Catch: Throwable -> L15
        String r113 = new Gson().toJson(r18);     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r113, "Gson().toJson(pkg)");     // Catch: Throwable -> L15
        r2.L$0 = r18;     // Catch: Throwable -> L15
        r2.L$1 = r17;     // Catch: Throwable -> L15
        r2.L$2 = r19;     // Catch: Throwable -> L15
        r2.L$3 = r20;     // Catch: Throwable -> L15
        r2.L$4 = r111;     // Catch: Throwable -> L15
        r2.label = 2;     // Catch: Throwable -> L15
        Object r21 = r112.runOptFunc(new Object[]{"init_service", r19, r111, r113}, r2);     // Catch: Throwable -> L15
        if (r21 != r3) goto L35;
        return r3;
    L35:
        r7 = r19;
        r1 = r21;
        r13 = r111;
        r8 = r17;
        r11 = r18;
        r4 = r20;
        goto L53
    L20:
        ResultKt.throwOnFailure(r1);
        r19 = r22.g();
        c r25 = (c) ZeusTransformUtils.preCheckCast(_serviceInfos.get(r19), c.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L23;
        return r25;
    L23:
        kotlinx.coroutines.sync.a r26 = _serviceLock;
        r2.L$0 = r22;
        r17 = r23;
        r2.L$1 = r17;
        r2.L$2 = r19;
        r2.L$3 = r26;
        r2.label = 1;
        if (r26.a(null, r2) != r3) goto L26;
        return r3;
    L26:
        r18 = r22;
        r20 = r26;
    L15:
        th = th;
    L7:
        r2 = new C09831(this, r0);
        goto L8
    }

    private final Bundle getSessionArgs(String r2) {
        com.obric.aee.impl.a r1 = (com.obric.aee.impl.a) ZeusTransformUtils.preCheckCast(_sessionPool.get(r2), com.obric.aee.impl.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.b();
    }

    private final Bundle getSessionContext(String r2) {
        com.obric.aee.impl.a r1 = (com.obric.aee.impl.a) ZeusTransformUtils.preCheckCast(_sessionPool.get(r2), com.obric.aee.impl.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getContext();
    }

    private final SafeBundle getSessionExtra(String r2) {
        com.obric.aee.impl.a r1 = (com.obric.aee.impl.a) ZeusTransformUtils.preCheckCast(_sessionPool.get(r2), com.obric.aee.impl.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.d();
    }

    private final Bundle getSessionRet(String r2) {
        com.obric.aee.impl.a r1 = (com.obric.aee.impl.a) ZeusTransformUtils.preCheckCast(_sessionPool.get(r2), com.obric.aee.impl.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.c();
    }

    private final EngineConfig get_config() {
        return (EngineConfig) ZeusTransformUtils.preCheckCast(_config$delegate.getValue(), EngineConfig.class, "com.obric.memorydata.plugin");
    }

    private final void handleLoadFailureExpired(Bundle r15) {
        final String r2 = r15.getString("service");
        if (r2 != null) goto L5;
        return;
    L5:
        String r3 = r15.getString(PendingPersonalInfoNotificationTask.KEY_GENERATION);
        Integer r0 = Integer.valueOf(r15.getInt("fd", -1));
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r1 = true;
    L9:
        Integer r4 = null;
        if (r1 == true) goto L13;
        r0 = null;
    L13:
        if (r0 != null) goto L17;
        c r5 = (c) ZeusTransformUtils.preCheckCast(_serviceInfos.get(r2), c.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L18;
        r0 = Integer.valueOf(r5.b());
    L18:
        hostLogW(TAG, (Function0) ZeusTransformUtils.preCheckCast(new C09841(r2), Function0.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r2, r3, r4, r15, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L17:
        r4 = r0;
        goto L18
    L8:
        r1 = false;
        goto L9
    }

    private final boolean hasRunningSession(c r1) {
        if (r1.e().get() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void invalidateService(final c r10, final Throwable r11) {
        r10.a(false);
        if (_serviceInfos.remove(r10.a().g(), r10) == true) goto L5;
        return;
    L5:
        bx r0 = r10.g();
        if (r0 == null) goto L8;
        bx.a.a(r0, null, 1, null);
    L8:
        hostLogW(TAG, (Function0) ZeusTransformUtils.preCheckCast(new C09861(r10, r11), Function0.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C09872(r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final String limitDebugJsonString(String r2) {
        if (r2.length() > 48) goto L6;
        return r2;
    L6:
        return StringsKt.take(r2, 48) + DEBUG_JSON_TRUNCATED_MARKER;
    }

    private final void onEntryFinish(byte[] r13) {
        MessageUnpacker r12 = MessagePack.newDefaultUnpacker(r13);
        int r14 = r12.unpackArrayHeader();
        String r0 = r12.unpackString();
        if (r0 == null) goto L47;
        int r2 = r0.hashCode();
        if (r2 == (-1922171997)) goto L32;
        if (r2 == (-1274442605)) goto L16;
        if (r2 != 3446776) goto L47;
        if (r0.equals("pong") == false) goto L47;
        _sessionWatcher.remove(r12.unpackString());
        return;
    L16:
        if (r0.equals("finish") == false) goto L47;
        final String r15 = r12.unpackString();
        EngineBridge r16 = INSTANCE;
        r16.hostLogD(TAG, (Function0) ZeusTransformUtils.preCheckCast(new EngineBridge$onEntryFinish$1$1(r15), Function0.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r15, "sid");
        com.obric.aee.impl.a r17 = r16.removeSession(r15);
        if (r17 == null) goto L50;
        long r1 = SystemClock.elapsedRealtime();
        c r18 = r17.a();
        if (r18 == null) goto L25;
        AtomicLong r19 = r18.d();
        if (r19 == null) goto L25;
        r19.set(r1);
    L25:
        SafeBundle r110 = r17.d();
        if (r110 == null) goto L30;
        Bundle r111 = r110.detach();
        if (r111 == null) goto L30;
        r111.putLong(ApiPerfDetails.onVmPyStart, r17.e());
        r111.putLong(ApiPerfDetails.onVmPyEnd, r1);
    L30:
        Continuation r112 = (Continuation) ZeusTransformUtils.preCheckCast(r17.g(), Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r113 = Result.Companion;
        r112.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));
        return;
    L50:
        return;
    L32:
        if (r0.equals("finish_exception") == false) goto L47;
        final String r114 = r12.unpackString();
        String r3 = r12.unpackString();
        int r4 = r12.unpackInt();
        final String r5 = r12.unpackString();
        String r115 = r12.unpackString();
        EngineBridge r8 = INSTANCE;
        r8.hostLogD(TAG, (Function0) ZeusTransformUtils.preCheckCast(new EngineBridge$onEntryFinish$1$3(r114, r5), Function0.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r114, "sid");
        com.obric.aee.impl.a r116 = r8.removeSession(r114);
        if (r116 == null) goto L52;
        long r9 = SystemClock.elapsedRealtime();
        c r6 = r116.a();
        if (r6 == null) goto L41;
        AtomicLong r7 = r6.d();
        if (r7 == null) goto L41;
        r7.set(r9);
    L41:
        SafeBundle r10 = r116.d();
        if (r10 == null) goto L46;
        Bundle r11 = r10.detach();
        if (r11 == null) goto L46;
        r11.putLong(ApiPerfDetails.onVmPyStart, r116.e());
        r11.putLong(ApiPerfDetails.onVmPyEnd, r9);
    L46:
        Continuation r117 = (Continuation) ZeusTransformUtils.preCheckCast(r116.g(), Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r20 = Result.Companion;
        Intrinsics.checkNotNullExpressionValue(r3, "exceptType");
        Intrinsics.checkNotNullExpressionValue(r5, "exceptContent");
        Intrinsics.checkNotNullExpressionValue(r115, "trace");
        r117.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new PythonException(r3, r4, r5, r115), Throwable.class, "com.obric.memorydata.plugin"))));
        return;
    L52:
        return;
    L47:
        INSTANCE.hostLogE(TAG, "unsupported finish event : " + r0 + ", len(args) = " + (r14 - 1));
    }

    private final void onGlobalEvent(String r2, Bundle r3) {
        if (Intrinsics.areEqual(r2, "ServiceLoadFailed") == false) goto L6;
        handleLoadFailureExpired(r3);
        return;
    L6:
        get_config().onGlobalEvent(r2, r3);
    }

    private final void onSessionStreamingResult(String r2, Bundle r3) {
        com.obric.aee.impl.a r1 = (com.obric.aee.impl.a) ZeusTransformUtils.preCheckCast(_sessionPool.get(r2), com.obric.aee.impl.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        Function1<Bundle, Unit> r4 = r1.f();
        if (r4 == null) goto L9;
        r4.invoke(r3);
        return;
    L9:
        return;
    }

    private final com.obric.aee.impl.a removeSession(String r2) {
        com.obric.aee.impl.a r1 = (com.obric.aee.impl.a) ZeusTransformUtils.preCheckCast(_sessionPool.remove(r2), com.obric.aee.impl.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        c r3 = r1.a();
        if (r3 == null) goto L11;
        AtomicInteger r4 = r3.e();
        if (r4 == null) goto L11;
        r4.decrementAndGet();
    L11:
        return r1;
    }

    private final Object runOptFunc(Object[] r25, Continuation<? super Bundle> r26) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C09891.class) == false) goto L7;
        C09891 r4 = (C09891) ZeusTransformUtils.preCheckCast(r2, C09891.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r4.L$2, byte[].class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        Bundle r7 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$0, Bundle.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        Bundle r8 = new Bundle();
        final String r15 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r15, "randomUUID().toString()");
        byte[] r9 = encodeRunArgs(r15, Arrays.copyOf(r25, r25.length));
        r4.L$0 = r8;
        r4.L$1 = r15;
        r4.L$2 = r9;
        r4.label = 1;
        o r13 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), 1);
        r13.e();
        n r10 = (n) ZeusTransformUtils.preCheckCast(r13, n.class, "com.obric.memorydata.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(access$get_sessionPool$p(), Map.class, "com.obric.memorydata.plugin")).put(r15, new com.obric.aee.impl.a(null, new Bundle(), r8, new Bundle(), null, null, SystemClock.elapsedRealtime(), null, r10));
        HostExtension.INSTANCE.a(access$get_opt_pipe$p(), r9);     // Catch: Exception -> L23
        r10.a((Function1) ZeusTransformUtils.preCheckCast(new EngineBridge$runOptFunc$2$1(r15), Function1.class, "com.obric.memorydata.plugin"));
        Object r11 = r13.h();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    L19:
        if (r11 != r5) goto L22;
        return r5;
    L22:
        return r8;
    L23:
        e = move-exception;
        access$get_sessionPool$p().remove(r15);
        throw e;
    L7:
        r4 = new C09891(this, r2);
        goto L8
    }

    private final void setThreadName(String r1) {
        Thread.currentThread().setName(r1);
    }

    private final Object stopServiceByName(String r10, String r11, Integer r12, Continuation<? super Boolean> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, C09921.class) == false) goto L7;
        C09921 r0 = (C09921) ZeusTransformUtils.preCheckCast(r14, C09921.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L54:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$4, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r12 = (Integer) ZeusTransformUtils.preCheckCast(r0.L$3, Integer.class, "com.obric.memorydata.plugin");
        r11 = (String) ZeusTransformUtils.preCheckCast(r0.L$2, String.class, "com.obric.memorydata.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
        EngineBridge r3 = (EngineBridge) ZeusTransformUtils.preCheckCast(r0.L$0, EngineBridge.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L63:
        ConcurrentHashMap<String, c> r16 = _serviceInfos;     // Catch: Throwable -> L58
        c r6 = (c) ZeusTransformUtils.preCheckCast(r16.get(r10), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        if (r6 != null) goto L25;
        Boolean r17 = Boxing.boxBoolean(false);     // Catch: Throwable -> L58
        r9.b(null);
        return r17;
    L25:
        Intrinsics.checkNotNullExpressionValue(r6, "_serviceInfos[serviceName] ?: return false");     // Catch: Throwable -> L58
        if (r11 != null) goto L28;
    L32:
        if (r12 != null) goto L34;
    L38:
        monitor-enter(r6);     // Catch: Throwable -> L58
        r6.a(false);     // Catch: Throwable -> L55
        r16.remove(r10, r6);     // Catch: Throwable -> L55
        monitor-exit(r6);     // Catch: Throwable -> L58
        r9.b(null);
        bx r18 = r6.g();
        if (r18 == null) goto L44;
        bx.a.a(r18, null, 1, null);
    L44:
        Set<Map.Entry<String, String>> r19 = _sessionWatcher.entrySet();
        Intrinsics.checkNotNullExpressionValue(r19, "_sessionWatcher.entries");
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L46:
        if (r20.hasNext() == false) goto L50;
        Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r110.getValue(), r6.c()) == false) goto L46;
        _sessionWatcher.remove(r110.getKey(), r110.getValue());
        goto L46
    L50:
        Object[] r21 = {"stop_service", r6.a().g(), r6.c()};
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 2;
        if (r3.runOptFunc(r21, r0) != r1) goto L54;
        return r1;
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L58
    L34:
        if (r6.b() == r12.intValue()) goto L38;
        Boolean r111 = Boxing.boxBoolean(false);     // Catch: Throwable -> L58
        r9.b(null);
        return r111;
    L28:
        if (Intrinsics.areEqual(r6.c(), r11) == true) goto L32;
        Boolean r112 = Boxing.boxBoolean(false);     // Catch: Throwable -> L58
        r9.b(null);
        return r112;
    L58:
        th = move-exception;
        r9.b(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r15);
        kotlinx.coroutines.sync.a r113 = _serviceLock;
        r0.L$0 = this;
        r0.L$1 = r10;
        r0.L$2 = r11;
        r0.L$3 = r12;
        r0.L$4 = r113;
        r0.label = 1;
        if (r113.a(null, r0) != r1) goto L19;
        return r1;
    L19:
        r3 = this;
        r9 = r113;
    L7:
        r0 = new C09921(this, r14);
        goto L8
    }

    static /* synthetic */ Object stopServiceByName$default(EngineBridge r1, String r2, String r3, Integer r4, Continuation r5, int r6, Object r7) {
        Continuation<? super Boolean> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.stopServiceByName(r2, r3, r4, r8);
    }

    private final JsonElement toJsonElement(Object r6) {
        if (r6 != null) goto L8;
        Object r5 = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r5, "INSTANCE");
    L5:
        Object r7 = ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.memorydata.plugin");
    L74:
        return (JsonElement) r7;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, Bundle.class) == false) goto L11;
        r5 = bundleToJsonObject((Bundle) ZeusTransformUtils.preCheckCast(r6, Bundle.class, "com.obric.memorydata.plugin"));
        goto L5
    L11:
        if (ZeusTransformUtils.instanceOf(r6, Boolean.class) == false) goto L14;
        r5 = new JsonPrimitive((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin"));
        goto L5
    L14:
        if (ZeusTransformUtils.instanceOf(r6, Number.class) == false) goto L17;
        r5 = new JsonPrimitive((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin"));
        goto L5
    L17:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L21;
        JsonPrimitive r1 = new JsonPrimitive(limitDebugJsonString((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin")));
    L19:
        r7 = ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin");
        goto L74
    L21:
        if (ZeusTransformUtils.instanceOf(r6, Character.class) == false) goto L24;
        r5 = new JsonPrimitive(String.valueOf(((Character) ZeusTransformUtils.preCheckCast(r6, Character.class, "com.obric.memorydata.plugin")).charValue()));
        goto L5
    L24:
        if (ZeusTransformUtils.instanceOf(r6, CharSequence.class) == false) goto L27;
        r1 = new JsonPrimitive(limitDebugJsonString(r6.toString()));
        goto L19
    L27:
        if ((r6 instanceof boolean[]) == false) goto L31;
        Iterable<?> r8 = ArraysKt.asIterable((boolean[]) ZeusTransformUtils.preCheckCast(r6, boolean[].class, "com.obric.memorydata.plugin"));
    L29:
        r5 = buildJsonArray(r8);
        goto L5
    L31:
        if ((r6 instanceof byte[]) == false) goto L34;
        r8 = ArraysKt.asIterable((byte[]) ZeusTransformUtils.preCheckCast(r6, byte[].class, "com.obric.memorydata.plugin"));
        goto L29
    L34:
        if ((r6 instanceof short[]) == false) goto L37;
        r8 = ArraysKt.asIterable((short[]) ZeusTransformUtils.preCheckCast(r6, short[].class, "com.obric.memorydata.plugin"));
        goto L29
    L37:
        if ((r6 instanceof int[]) == false) goto L40;
        r8 = ArraysKt.asIterable((int[]) ZeusTransformUtils.preCheckCast(r6, int[].class, "com.obric.memorydata.plugin"));
        goto L29
    L40:
        if ((r6 instanceof long[]) == false) goto L43;
        r8 = ArraysKt.asIterable((long[]) ZeusTransformUtils.preCheckCast(r6, long[].class, "com.obric.memorydata.plugin"));
        goto L29
    L43:
        if ((r6 instanceof float[]) == false) goto L46;
        r8 = ArraysKt.asIterable((float[]) ZeusTransformUtils.preCheckCast(r6, float[].class, "com.obric.memorydata.plugin"));
        goto L29
    L46:
        if ((r6 instanceof double[]) == false) goto L48;
        r8 = ArraysKt.asIterable((double[]) ZeusTransformUtils.preCheckCast(r6, double[].class, "com.obric.memorydata.plugin"));
        goto L29
    L48:
        int r2 = 0;
        if ((r6 instanceof char[]) == false) goto L56;
        char[] r9 = (char[]) ZeusTransformUtils.preCheckCast(r6, char[].class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r9.length), Collection.class, "com.obric.memorydata.plugin");
        int r4 = r9.length;
    L51:
        if (r2 >= r4) goto L53;
        r3.add(String.valueOf(r9[r2]));
        r2 = r2 + 1;
        goto L51
    L53:
        Object r10 = ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L54:
        r6 = (List) r10;
    L60:
        r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        goto L29
    L56:
        if ((r6 instanceof Object[]) == false) goto L59;
        r8 = ArraysKt.asIterable((Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.memorydata.plugin"));
        goto L29
    L59:
        if (ZeusTransformUtils.instanceOf(r6, Iterable.class) == true) goto L60;
        if (ZeusTransformUtils.instanceOf(r6, Map.class) == false) goto L65;
        r5 = buildJsonObject((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin"));
        goto L5
    L65:
        if (ZeusTransformUtils.instanceOf(r6, Parcelable.class) == false) goto L68;
        r1 = new JsonPrimitive(limitDebugJsonString(r6.toString()));
        goto L19
    L68:
        if (r6.getClass().isArray() == false) goto L73;
        int r11 = Array.getLength(r6);
        ArrayList r12 = new ArrayList(r11);
    L70:
        if (r2 >= r11) goto L72;
        r12.add(Array.get(r6, r2));
        r2 = r2 + 1;
        goto L70
    L72:
        r10 = ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        goto L54
    L73:
        r1 = new JsonPrimitive(limitDebugJsonString(r6.toString()));
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v27, types: [kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0218 -> B:21:0x0163). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0243 -> B:50:0x0246). Please report as a decompilation issue!!! */
    private final Object watchPackageLife(c r21, Continuation<? super Unit> r22) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C09931.class) == false) goto L7;
        C09931 r3 = (C09931) ZeusTransformUtils.preCheckCast(r1, C09931.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
        EngineBridge r4 = this;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        String r11 = TAG;
        Continuation r12 = null;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        long r13 = r3.J$0;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r3.L$6, String.class, "com.obric.memorydata.plugin");
        i r8 = (i) ZeusTransformUtils.preCheckCast(r3.L$5, i.class, "com.obric.memorydata.plugin");
        AtomicLong r9 = (AtomicLong) ZeusTransformUtils.preCheckCast(r3.L$4, AtomicLong.class, "com.obric.memorydata.plugin");
        final com.obric.aee.res.b r10 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r3.L$3, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        Pair r14 = (Pair) ZeusTransformUtils.preCheckCast(r3.L$2, Pair.class, "com.obric.memorydata.plugin");
        c r15 = (c) ZeusTransformUtils.preCheckCast(r3.L$1, c.class, "com.obric.memorydata.plugin");
        EngineBridge r0 = (EngineBridge) ZeusTransformUtils.preCheckCast(r3.L$0, EngineBridge.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        ?? r16 = r14;
        String r17 = TAG;
        Continuation r18 = null;
        String r19 = r7;
        r4 = r0;
        c r20 = r15;
    L51:
        if (r4.hasRunningSession(r20) == true) goto L53;
        r12 = r18;
        r11 = r17;
    L22:
        if (r4.hasRunningSession(r20) == true) goto L47;
        if (r16 == 0) goto L25;
        String r23 = (String) ZeusTransformUtils.preCheckCast(_sessionWatcher.remove(r16.getFirst()), String.class, "com.obric.memorydata.plugin");
    L25:
        Long r24 = r4.getAutoCloseDelay(r10, r9);
        if (r24 != null) goto L31;
        r3.L$0 = r4;
        r3.L$1 = r20;
        r3.L$2 = r10;
        r3.L$3 = r9;
        r3.L$4 = r8;
        r3.L$5 = r19;
        r3.L$6 = r12;
        r3.J$0 = r13;
        r3.label = 1;
        if (r8.a(r3) == r5) goto L29;
        r16 = r12;
        goto L22
    L29:
        return r5;
    L31:
        String r110 = r11;
        long r111 = r24.longValue();
        Function2 r25 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r8, r12), Function2.class, "com.obric.memorydata.plugin");
        r3.L$0 = r4;
        r3.L$1 = r20;
        r3.L$2 = r10;
        r3.L$3 = r9;
        r3.L$4 = r8;
        r3.L$5 = r19;
        r3.L$6 = null;
        r3.J$0 = r13;
        r3.label = 2;
        r2 = da.b(r111, r25, r3);
        if (r2 != r5) goto L34;
        return r5;
    L34:
        Object r112 = r5;
        AtomicLong r113 = r9;
        C09931 r26 = r3;
        EngineBridge r27 = r4;
        String r28 = r19;
        final AtomicLong r29 = r113;
    L35:
        if (r2 == null) goto L38;
    L36:
        r11 = r110;
        r5 = r112;
        r16 = 0;
        r12 = null;
        String r114 = r28;
        r4 = r27;
        r3 = r26;
        r9 = r29;
        r19 = r114;
        goto L22
    L38:
        if (r27.checkServiceStop(r10, r29) == false) goto L36;
        if (r27.hasRunningSession(r20) == true) goto L36;
        r27.hostLogI(r110, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r10, r29), Function0.class, "com.obric.memorydata.plugin"));
        String r30 = r20.c();
        r26.L$0 = null;
        r26.L$1 = null;
        r26.L$2 = null;
        r26.L$3 = null;
        r26.L$4 = null;
        r26.L$5 = null;
        r26.label = 3;
        if (stopServiceByName$default(r27, r28, r30, null, r26, 4, null) != r112) goto L45;
        return r112;
    L45:
        return Unit.INSTANCE;
    L47:
        r17 = r11;
        r18 = r12;
        long r115 = r4.getCheckDur();
        r3.L$0 = r4;
        r3.L$1 = r20;
        r3.L$2 = r16;
        r3.L$3 = r10;
        r3.L$4 = r9;
        r3.L$5 = r8;
        r3.L$6 = r19;
        r3.J$0 = r13;
        r3.label = 4;
        r16 = r16;
        if (au.a(r115, r3) != r5) goto L51;
        return r5;
    L53:
        if (r16 == 0) goto L61;
        ConcurrentHashMap<String, String> r116 = _sessionWatcher;
        if (r116.get(r16.getFirst()) == null) goto L61;
        final long r117 = SystemClock.elapsedRealtime() - ((Number) ZeusTransformUtils.preCheckCast(r16.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r117 <= r13) goto L59;
        r116.remove(r16.getFirst());
        String r118 = r17;
        r4.get_config().logE(r118, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass5(r10), Function0.class, "com.obric.memorydata.plugin"));
        EngineConfig r31 = r4.get_config();
        Bundle r119 = new Bundle();
        r119.putString("package", r10.h());
        Unit r120 = Unit.INSTANCE;
        r31.onGlobalEvent("ServiceNotResponse", r119);
        String r121 = r118;
        ?? r32 = 0;
    L60:
        r11 = r121;
        r16 = r32;
    L68:
        r12 = null;
        goto L22
    L59:
        r121 = r17;
        r4.get_config().logW(r121, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass7(r10, r117), Function0.class, "com.obric.memorydata.plugin"));
        r32 = r16;
    L61:
        String r122 = r17;
        String r123 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r123, "randomUUID().toString()");
        Pair r33 = new Pair(r123, Boxing.boxLong(SystemClock.elapsedRealtime()));
        ((Map) ZeusTransformUtils.preCheckCast(_sessionWatcher, Map.class, "com.obric.memorydata.plugin")).put(r33.getFirst(), r20.c());
        c r124 = r20;
        HostExtension.INSTANCE.a(r20.b(), r4.encodeRunPackage((String) ZeusTransformUtils.preCheckCast(r33.getFirst(), String.class, "com.obric.memorydata.plugin"), "_PING"));     // Catch: Exception -> L69
        r11 = r122;
        r20 = r124;
        r16 = r33;
    L67:
        _sessionWatcher.remove(r33.getFirst());
        r4.hostLogD(r122, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass8(r10), Function0.class, "com.obric.memorydata.plugin"));
        r11 = r122;
        r20 = r124;
        r16 = 0;
    L66:
        r124 = r20;
        goto L67
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r2);
        goto L45
    L18:
        long r34 = r3.J$0;
        r28 = (String) ZeusTransformUtils.preCheckCast(r3.L$5, String.class, "com.obric.memorydata.plugin");
        i r35 = (i) ZeusTransformUtils.preCheckCast(r3.L$4, i.class, "com.obric.memorydata.plugin");
        r29 = (AtomicLong) ZeusTransformUtils.preCheckCast(r3.L$3, AtomicLong.class, "com.obric.memorydata.plugin");
        com.obric.aee.res.b r125 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r3.L$2, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        c r126 = (c) ZeusTransformUtils.preCheckCast(r3.L$1, c.class, "com.obric.memorydata.plugin");
        EngineBridge r36 = (EngineBridge) ZeusTransformUtils.preCheckCast(r3.L$0, EngineBridge.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        r110 = TAG;
        C09931 r127 = r3;
        r27 = r36;
        r20 = r126;
        r13 = r34;
        r8 = r35;
        r10 = r125;
        r26 = r127;
        r112 = r5;
        goto L35
    L19:
        long r37 = r3.J$0;
        String r38 = (String) ZeusTransformUtils.preCheckCast(r3.L$5, String.class, "com.obric.memorydata.plugin");
        i r39 = (i) ZeusTransformUtils.preCheckCast(r3.L$4, i.class, "com.obric.memorydata.plugin");
        AtomicLong r40 = (AtomicLong) ZeusTransformUtils.preCheckCast(r3.L$3, AtomicLong.class, "com.obric.memorydata.plugin");
        com.obric.aee.res.b r128 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r3.L$2, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        c r129 = (c) ZeusTransformUtils.preCheckCast(r3.L$1, c.class, "com.obric.memorydata.plugin");
        EngineBridge r41 = (EngineBridge) ZeusTransformUtils.preCheckCast(r3.L$0, EngineBridge.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        r4 = r41;
        r20 = r129;
        r13 = r37;
        r8 = r39;
        r9 = r40;
        r10 = r128;
        r19 = r38;
        r16 = 0;
        goto L22
    L20:
        ResultKt.throwOnFailure(r2);
        com.obric.aee.res.b r42 = r21.a();
        r9 = r21.d();
        i<Unit> r43 = r21.f();
        r19 = r42.g();
        r13 = 30000;
        r16 = 0;
        r20 = r21;
        r10 = r42;
        r8 = r43;
    L7:
        r4 = this;
        r3 = new C09931(r4, r1);
        goto L8
    }

    public final int[] getAeeVersion() {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.substringBefore$default(BuildConfig.MyVersion, "-", null, 2, null), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"."}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.add(Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"))));
        goto L4
    L6:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        int[] r2 = new int[4];
        int r4 = 0;
    L7:
        if (r4 >= 4) goto L14;
        if (r4 >= 0) goto L10;
    L12:
        Object r5 = 0;
    L13:
        r2[r4] = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue();
        r4 = r4 + 1;
        goto L7
    L10:
        if (r4 > CollectionsKt.getLastIndex(r10)) goto L12;
        r5 = r10.get(r4);
        goto L13
    L14:
        return r2;
    }

    public final Object getAllServices(Continuation<? super List<com.obric.aee.res.b>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r8, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        Set<String> r6 = ((Bundle) ZeusTransformUtils.preCheckCast(r9, Bundle.class, "com.obric.memorydata.plugin")).keySet();
        Intrinsics.checkNotNullExpressionValue(r6, "runOptFunc(\"get_all_services\").keySet()");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L19:
        if (r12.hasNext() == false) goto L23;
        c r1 = (c) ZeusTransformUtils.preCheckCast(_serviceInfos.get((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L19;
        r11.add(r1);
        goto L19
    L23:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L25:
        if (r15.hasNext() == false) goto L28;
        r14.add(((c) ZeusTransformUtils.preCheckCast(r15.next(), c.class, "com.obric.memorydata.plugin")).a());
        goto L25
    L28:
        return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.label = 1;
        r9 = runOptFunc(new Object[]{"get_all_services"}, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    public final Context getAndroidContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(get_config().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public final void handlePipeData(String r2, byte[] r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "data");
        KFunction r1 = (KFunction) ZeusTransformUtils.preCheckCast(_pipeDispatch.get(r2), KFunction.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        ((Function1) ZeusTransformUtils.preCheckCast(r1, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
        return;
    }

    public final void hostLogD(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        get_config().logD(r2, r3);
    }

    public final void hostLogD(String r3, Function0<String> r4) {
        Function0<String> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        get_config().logD(r3, r5);
    }

    public final void hostLogE(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        get_config().logE(r2, r3);
    }

    public final void hostLogE(String r3, Function0<String> r4) {
        Function0<String> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        get_config().logE(r3, r5);
    }

    public final void hostLogI(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        get_config().logI(r2, r3);
    }

    public final void hostLogI(String r3, Function0<String> r4) {
        Function0<String> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        get_config().logI(r3, r5);
    }

    public final void hostLogV(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        get_config().logV(r2, r3);
    }

    public final void hostLogV(String r3, Function0<String> r4) {
        Function0<String> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        get_config().logV(r3, r5);
    }

    public final void hostLogW(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        get_config().logW(r2, r3);
    }

    public final void hostLogW(String r3, Function0<String> r4) {
        Function0<String> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
        get_config().logW(r3, r5);
    }

    public final void initCfg(EngineConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "cfg");
        Map<String, String> r0 = r5.getGlobalConfig();
        Object r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager r2 = (PowerManager) ZeusTransformUtils.preCheckCast(r1, PowerManager.class, "com.obric.memorydata.plugin");
        _param = new b(r5, getLowMemConfig(r0), r2);
        Iterator<Map.Entry<String, KFunction<Unit>>> r6 = _pipeDispatch.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r3 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");
        HostExtension.INSTANCE.a(r3);
        goto L4
    L6:
        hostLogI(TAG, (Function0) ZeusTransformUtils.preCheckCast(C09852.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public final Object isServiceAlive(com.obric.aee.res.b r7, Continuation<? super Boolean> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C09881.class) == false) goto L7;
        C09881 r0 = (C09881) ZeusTransformUtils.preCheckCast(r9, C09881.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L22:
        return Boxing.boxBoolean(((Bundle) ZeusTransformUtils.preCheckCast(r10, Bundle.class, "com.obric.memorydata.plugin")).getBoolean(IdlKeys.Result, false));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        c r11 = (c) ZeusTransformUtils.preCheckCast(_serviceInfos.get(r7.g()), c.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L17;
        Object[] r12 = {"is_service_alive", r11.a().g(), r11.c()};
        r0.label = 1;
        r10 = runOptFunc(r12, r0);
        if (r10 != r2) goto L22;
        return r2;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r0 = new C09881(this, r9);
        goto L8
    }

    public final Object requestPythonGc(Continuation<? super Unit> r4) {
        Object[] r0 = {"request_manual_gc"};
        Object r3 = runOptFunc(r0, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0249 -> B:50:0x0259). Please report as a decompilation issue!!! */
    public final Object runPackage(com.obric.aee.res.b r30, Bundle r31, String r32, Bundle r33, Continuation<? super Bundle> r34) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r34, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C09901.class) == false) goto L7;
        C09901 r4 = (C09901) ZeusTransformUtils.preCheckCast(r2, C09901.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
        EngineBridge r5 = this;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        int r9 = 1;
        if (r7 == 0) goto L19;
        if (r7 == 1) goto L18;
        if (r7 != 2) goto L17;
        long r10 = r4.J$0;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r4.L$8, c.class, "com.obric.memorydata.plugin");
        Bundle r1 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$7, Bundle.class, "com.obric.memorydata.plugin");
        Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$6, Bundle.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r4.L$5, String.class, "com.obric.memorydata.plugin");
        Bundle r12 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$4, Bundle.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        Bundle r14 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$2, Bundle.class, "com.obric.memorydata.plugin");
        com.obric.aee.res.b r15 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        EngineBridge r16 = (EngineBridge) ZeusTransformUtils.preCheckCast(r4.L$0, EngineBridge.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: ServiceReplacedException -> L15
    L43:
        r8.putLong(ApiPerfDetails.onVmRun, r10);
        r8.putLong(ApiPerfDetails.onVmEnd, SystemClock.elapsedRealtime());
        return r1;
    L15:
        String r17 = r13;
        Bundle r18 = r1;
        com.obric.aee.res.b r19 = r15;
        C09901 r20 = r4;
        Bundle r21 = r12;
        long r110 = r10;
        Object r111 = r6;
        String r22 = r11;
        Bundle r23 = r8;
        r5 = r16;
        Bundle r24 = r14;
    L50:
        r9 = 1;
    L20:
        r20.L$0 = r5;
        r20.L$1 = r19;
        r20.L$2 = r24;
        r20.L$3 = r17;
        r20.L$4 = r21;
        r20.L$5 = r22;
        r20.L$6 = r23;
        r20.L$7 = r18;
        r20.L$8 = null;
        r20.J$0 = r110;
        r20.label = r9;
        Object r112 = r5.getServiceInner(r19, r23, r20);
        if (r112 != r111) goto L23;
        return r111;
    L23:
        com.obric.aee.res.b r113 = r19;
        r1 = r18;
        Bundle r114 = r24;
        EngineBridge r25 = r5;
        r8 = r23;
        String r26 = r22;
        r6 = r111;
        long r115 = r110;
        String r116 = r17;
        r3 = r112;
        C09901 r28 = r20;
        Bundle r27 = r21;
        r4 = r28;
    L24:
        c r29 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
        r4.L$0 = r25;     // Catch: ServiceReplacedException -> L46
        r4.L$1 = r113;     // Catch: ServiceReplacedException -> L46
        r4.L$2 = r114;     // Catch: ServiceReplacedException -> L46
        r4.L$3 = r116;     // Catch: ServiceReplacedException -> L46
        r4.L$4 = r27;     // Catch: ServiceReplacedException -> L46
        r4.L$5 = r26;     // Catch: ServiceReplacedException -> L46
        r4.L$6 = r8;     // Catch: ServiceReplacedException -> L46
        r4.L$7 = r1;     // Catch: ServiceReplacedException -> L46
        r4.L$8 = r29;     // Catch: ServiceReplacedException -> L46
        r4.J$0 = r115;     // Catch: ServiceReplacedException -> L46
        r4.label = 2;     // Catch: ServiceReplacedException -> L45
        EngineBridge r210 = r25;
        o r35 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: ServiceReplacedException -> L53
        r35.e();     // Catch: ServiceReplacedException -> L53
        n r117 = (n) ZeusTransformUtils.preCheckCast(r35, n.class, "com.obric.memorydata.plugin");     // Catch: ServiceReplacedException -> L53
        long r36 = r115;
        com.obric.aee.impl.a r37 = new com.obric.aee.impl.a(r29, r114, r1, r27, new SafeBundle(r8), r113, SystemClock.elapsedRealtime(), null, r117);     // Catch: ServiceReplacedException -> L51
        EngineBridge r118 = INSTANCE;     // Catch: ServiceReplacedException -> L51
        Intrinsics.checkNotNullExpressionValue(r26, "sid");     // Catch: ServiceReplacedException -> L51
        if (access$dispatchSession(r118, r26, r29, r37, access$encodeRunPackage(r118, r26, com.obric.aee.utils.b.f5897a.a(r116))) == true) goto L37;
        Continuation r38 = (Continuation) ZeusTransformUtils.preCheckCast(r117, Continuation.class, "com.obric.memorydata.plugin");     // Catch: ServiceReplacedException -> L51
        Result.Companion r39 = Result.Companion;     // Catch: ServiceReplacedException -> L51
        r38.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new ServiceReplacedException(), Throwable.class, "com.obric.memorydata.plugin"))));     // Catch: ServiceReplacedException -> L51
    L37:
        Object r40 = r35.h();     // Catch: ServiceReplacedException -> L51
        if (r40 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: ServiceReplacedException -> L51
    L40:
        if (r40 != r6) goto L42;
        return r6;
    L42:
        r10 = r36;
    L49:
        r111 = r6;
        r22 = r26;
        r17 = r116;
        r24 = r114;
        r110 = r36;
        r18 = r1;
        r23 = r8;
        r19 = r113;
        r5 = r210;
        Bundle r211 = r27;
        r20 = r4;
        r21 = r211;
    L47:
        r36 = r115;
    L45:
        r210 = r25;
        r36 = r115;
    L46:
        r210 = r25;
        goto L47
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        long r41 = r4.J$0;
        r1 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$7, Bundle.class, "com.obric.memorydata.plugin");
        r8 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$6, Bundle.class, "com.obric.memorydata.plugin");
        String r119 = (String) ZeusTransformUtils.preCheckCast(r4.L$5, String.class, "com.obric.memorydata.plugin");
        Bundle r120 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$4, Bundle.class, "com.obric.memorydata.plugin");
        r116 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        r114 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$2, Bundle.class, "com.obric.memorydata.plugin");
        r113 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r4.L$1, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        r25 = (EngineBridge) ZeusTransformUtils.preCheckCast(r4.L$0, EngineBridge.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r26 = r119;
        r27 = r120;
        r115 = r41;
        goto L24
    L19:
        ResultKt.throwOnFailure(r3);
        String r42 = r33.getString("_session", UUID.randomUUID().toString());
        long r43 = SystemClock.elapsedRealtime();
        Bundle r44 = new Bundle();
        r33.putBundle(WsConstants.KEY_EXTRA, r44);
        r110 = r43;
        r18 = new Bundle();
        r23 = r44;
        r20 = r4;
        r111 = r6;
        r17 = r32;
        r21 = r33;
        r22 = r42;
        r19 = r30;
        r24 = r31;
    L7:
        r5 = this;
        r4 = new C09901(r5, r2);
        goto L8
    }

    public final Object runPackageSteaming(com.obric.aee.res.b r30, Bundle r31, String r32, Bundle r33, Function2<? super Bundle, ? super Boolean, Unit> r34, Continuation<? super Unit> r35) {
        Function2 r2 = (Function2) ZeusTransformUtils.wrapperContextForParams(r34, Function2.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r35, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, C09911.class) == false) goto L7;
        C09911 r5 = (C09911) ZeusTransformUtils.preCheckCast(r4, C09911.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
        EngineBridge r6 = this;
    L8:
        Object r7 = r5.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r5.label;
        if (r9 == 0) goto L19;
        if (r9 == 1) goto L18;
        if (r9 != 2) goto L17;
        long r11 = r5.J$0;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r5.L$9, c.class, "com.obric.memorydata.plugin");
        Bundle r1 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$8, Bundle.class, "com.obric.memorydata.plugin");
        Bundle r3 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$7, Bundle.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.L$6, String.class, "com.obric.memorydata.plugin");
        Function2 r12 = (Function2) ZeusTransformUtils.preCheckCast(r5.L$5, Function2.class, "com.obric.memorydata.plugin");
        Bundle r13 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$4, Bundle.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r5.L$3, String.class, "com.obric.memorydata.plugin");
        Bundle r15 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$2, Bundle.class, "com.obric.memorydata.plugin");
        com.obric.aee.res.b r16 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r5.L$1, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        EngineBridge r17 = (EngineBridge) ZeusTransformUtils.preCheckCast(r5.L$0, EngineBridge.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: ServiceReplacedException -> L15
    L50:
        r3.putLong(ApiPerfDetails.onVmRun, r11);
        r3.putLong(ApiPerfDetails.onVmEnd, SystemClock.elapsedRealtime());
        r12.invoke(r1, Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L15:
        Bundle r18 = r13;
        Bundle r19 = r15;
        Bundle r20 = r3;
        String r21 = r14;
        long r110 = r11;
        Bundle r111 = r1;
        Object r112 = r8;
        Function2 r22 = r12;
        com.obric.aee.res.b r23 = r16;
        C09911 r113 = r5;
        String r24 = r10;
        r6 = r17;
    L63:
        Bundle r25 = r20;
        C09911 r26 = r113;
        Object r114 = r112;
        Bundle r27 = r19;
        Bundle r115 = r111;
        long r116 = r110;
    L20:
        r26.L$0 = r6;
        r26.L$1 = r23;
        r26.L$2 = r27;
        r26.L$3 = r21;
        r26.L$4 = r18;
        r26.L$5 = r22;
        r26.L$6 = r24;
        r26.L$7 = r25;
        r26.L$8 = r115;
        r26.L$9 = null;
        r26.J$0 = r116;
        r26.label = 1;
        Object r117 = r6.getServiceInner(r23, r25, r26);
        if (r117 != r114) goto L23;
        return r114;
    L23:
        com.obric.aee.res.b r118 = r23;
        r1 = r115;
        r19 = r27;
        EngineBridge r28 = r6;
        String r29 = r24;
        r5 = r26;
        long r210 = r116;
        String r119 = r21;
        Bundle r120 = r18;
        Bundle r36 = r25;
        r7 = r117;
        final Function2 r37 = r22;
        r8 = r114;
        long r38 = r210;
    L24:
        c r39 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin");
        r5.L$0 = r28;     // Catch: ServiceReplacedException -> L57
        r5.L$1 = r118;     // Catch: ServiceReplacedException -> L57
        r5.L$2 = r19;     // Catch: ServiceReplacedException -> L57
        r5.L$3 = r119;     // Catch: ServiceReplacedException -> L57
        r5.L$4 = r120;     // Catch: ServiceReplacedException -> L57
        r5.L$5 = r37;     // Catch: ServiceReplacedException -> L57
        r5.L$6 = r29;     // Catch: ServiceReplacedException -> L57
        r5.L$7 = r36;     // Catch: ServiceReplacedException -> L57
        r5.L$8 = r1;     // Catch: ServiceReplacedException -> L57
        r5.L$9 = r39;     // Catch: ServiceReplacedException -> L57
        r5.J$0 = r38;     // Catch: ServiceReplacedException -> L57
        r5.label = 2;     // Catch: ServiceReplacedException -> L55
        EngineBridge r211 = r28;
        long r310 = r38;
        o r40 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: ServiceReplacedException -> L54
        r40.e();     // Catch: ServiceReplacedException -> L52
        n r41 = (n) ZeusTransformUtils.preCheckCast(r40, n.class, "com.obric.memorydata.plugin");     // Catch: ServiceReplacedException -> L52
        Bundle r311 = r36;
        Function2 r312 = r37;
        com.obric.aee.impl.a r121 = new com.obric.aee.impl.a(r39, r19, r1, r120, new SafeBundle(r36), r118, SystemClock.elapsedRealtime(), (Function1) ZeusTransformUtils.preCheckCast(new EngineBridge$runPackageSteaming$2$session$1(r37), Function1.class, "com.obric.memorydata.plugin"), r41);     // Catch: ServiceReplacedException -> L64
        EngineBridge r42 = INSTANCE;     // Catch: ServiceReplacedException -> L64
        Intrinsics.checkNotNullExpressionValue(r29, "sid");     // Catch: ServiceReplacedException -> L64
        if (access$dispatchSession(r42, r29, r39, r121, access$encodeRunPackage(r42, r29, com.obric.aee.utils.b.f5897a.a(r119))) == false) goto L82;
    L44:
        Object r43 = r40.h();     // Catch: ServiceReplacedException -> L64
        if (r43 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L47;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: ServiceReplacedException -> L43
    L43:
        r20 = r311;
        r113 = r5;
        r24 = r29;
        r18 = r120;
        r21 = r119;
        r6 = r211;
        r111 = r1;
        r112 = r8;
        r23 = r118;
        r110 = r310;
        r22 = r312;
    L47:
        if (r43 != r8) goto L49;
        return r8;
    L49:
        r11 = r310;
        r3 = r311;
        r12 = r312;
        goto L50
    L82:
        Continuation r44 = (Continuation) ZeusTransformUtils.preCheckCast(r41, Continuation.class, "com.obric.memorydata.plugin");     // Catch: ServiceReplacedException -> L43
        Result.Companion r45 = Result.Companion;     // Catch: ServiceReplacedException -> L43
        r44.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new ServiceReplacedException(), Throwable.class, "com.obric.memorydata.plugin"))));     // Catch: ServiceReplacedException -> L43
    L61:
        r20 = r311;
        r113 = r5;
        r24 = r29;
        r18 = r120;
        r21 = r119;
        r6 = r211;
        r111 = r1;
        r112 = r8;
        r23 = r118;
        r110 = r310;
        r22 = r312;
    L53:
        r312 = r37;
    L52:
        r311 = r36;
    L54:
        r311 = r36;
        r312 = r37;
    L58:
        r311 = r36;
        r312 = r37;
        r310 = r38;
    L55:
        r211 = r28;
        r311 = r36;
        r312 = r37;
        r310 = r38;
    L57:
        r211 = r28;
        goto L58
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        long r46 = r5.J$0;
        r1 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$8, Bundle.class, "com.obric.memorydata.plugin");
        r36 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$7, Bundle.class, "com.obric.memorydata.plugin");
        r29 = (String) ZeusTransformUtils.preCheckCast(r5.L$6, String.class, "com.obric.memorydata.plugin");
        Function2 r122 = (Function2) ZeusTransformUtils.preCheckCast(r5.L$5, Function2.class, "com.obric.memorydata.plugin");
        r120 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$4, Bundle.class, "com.obric.memorydata.plugin");
        r119 = (String) ZeusTransformUtils.preCheckCast(r5.L$3, String.class, "com.obric.memorydata.plugin");
        r19 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$2, Bundle.class, "com.obric.memorydata.plugin");
        r118 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r5.L$1, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        r28 = (EngineBridge) ZeusTransformUtils.preCheckCast(r5.L$0, EngineBridge.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);
        r37 = r122;
        r38 = r46;
        goto L24
    L19:
        ResultKt.throwOnFailure(r7);
        String r47 = r33.getString("_session", UUID.randomUUID().toString());
        long r48 = SystemClock.elapsedRealtime();
        Bundle r49 = new Bundle();
        r33.putBundle(WsConstants.KEY_EXTRA, r49);
        r33.putBoolean(IdlKeys.Args_StreamingCall, true);
        r116 = r48;
        r115 = new Bundle();
        r25 = r49;
        r26 = r5;
        r114 = r8;
        r18 = r33;
        r24 = r47;
        r22 = r2;
        r23 = r30;
        r27 = r31;
        r21 = r32;
    L7:
        r6 = this;
        r5 = new C09911(r6, r4);
        goto L8
    }

    public final Object stopService(com.obric.aee.res.b r8, Continuation<? super Unit> r9) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        Object r7 = stopServiceByName$default(this, r8.g(), null, null, r4, 6, null);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }
}
