package com.obric.aikernel.runtime;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.update.UpdateResult;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\u0010&\u0018\u0000 ¯\u00012\u00020\u0001:\u0010®\u0001¯\u0001°\u0001±\u0001²\u0001³\u0001´\u0001µ\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u00104\u001a\u00020\n2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u00142\u0006\u00105\u001a\u000206H\u0002J!\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010>J$\u0010?\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010D\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J$\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\t0KJ\u0010\u0010L\u001a\u00020\u00142\u0006\u0010H\u001a\u00020IH\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010\n2\u0006\u0010<\u001a\u00020\tH\u0002J\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020O0KH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u0004\u0018\u0001062\u0006\u0010<\u001a\u00020\tJ\f\u0010R\u001a\b\u0012\u0004\u0012\u00020S0KJ\f\u0010T\u001a\b\u0012\u0004\u0012\u0002060UJ\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0W2\u0006\u0010X\u001a\u000206H\u0002J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0W2\u0006\u0010X\u001a\u000208H\u0002J\u0011\u0010Y\u001a\u00020;H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0018\u0010Z\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0007J!\u0010[\u001a\u00020A2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010>J\"\u0010\\\u001a\u0004\u0018\u00010\n2\u0006\u0010]\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010^\u001a\u00020\tH\u0002J\u001b\u0010_\u001a\u0004\u0018\u00010A2\u0006\u0010<\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u001b\u0010a\u001a\u0004\u0018\u00010O2\u0006\u0010<\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J-\u0010b\u001a\u0004\u0018\u00010\n2\u0006\u0010c\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\t2\u0006\u0010d\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0019\u0010f\u001a\u00020g2\u0006\u0010<\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J%\u0010h\u001a\u0004\u0018\u00010\n2\u0006\u0010c\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010>J\u001b\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010`J1\u0010l\u001a\u0004\u0018\u00010\n2\u0006\u0010<\u001a\u00020\t2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010^\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010mJ(\u0010n\u001a\u0004\u0018\u00010\n2\u0006\u0010<\u001a\u00020\t2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010^\u001a\u00020\tH\u0002J\u001d\u0010o\u001a\u00020\u00142\u0006\u00105\u001a\u00020\t2\u0006\u0010p\u001a\u00020\tH\u0000¢\u0006\u0002\bqJ'\u0010r\u001a\u00020\u00142\u0006\u00105\u001a\u00020\t2\u0006\u0010p\u001a\u00020\t2\b\b\u0002\u0010s\u001a\u00020\u0019H\u0000¢\u0006\u0002\btJ\u0011\u0010u\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJM\u0010v\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00190w\u0018\u00010K2\u0006\u0010c\u001a\u00020\t2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010x\u001a\u00020\u00192\b\b\u0002\u0010y\u001a\u00020zH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010{JJ\u0010|\u001a\u00020\u00192\u001e\u0010}\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u007f\u0012\u0006\u0012\u0004\u0018\u00010\u00010~2\u0006\u0010k\u001a\u00020\t2\u0006\u0010y\u001a\u00020z2\u0006\u0010x\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0080\u0001J\u001b\u0010\u0081\u0001\u001a\u00020\u00142\u0006\u0010X\u001a\u00020;H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0082\u0001J\u0011\u0010\u0083\u0001\u001a\u00020\u00142\u0006\u00105\u001a\u000206H\u0002J\u001b\u0010\u0084\u0001\u001a\u00020\u00142\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J\u0011\u0010\u0086\u0001\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\tH\u0002J\u0011\u0010\u0087\u0001\u001a\u00020\u00142\u0006\u00105\u001a\u000206H\u0002J\u0011\u0010\u0087\u0001\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\tH\u0002J\u001a\u0010\u0088\u0001\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010`J-\u0010\u0089\u0001\u001a\u00020\u00142\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\t0K2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u0002060KH\u0000¢\u0006\u0003\b\u008c\u0001J\u001f\u0010\u008d\u0001\u001a\u00020\t2\u0014\u0010\u008e\u0001\u001a\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020C0\u008f\u0001H\u0002J%\u0010\u0090\u0001\u001a\u00020\u00142\u0006\u0010k\u001a\u00020\t2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0093\u0001J\u0011\u0010\u0094\u0001\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0002J\u0011\u0010\u0095\u0001\u001a\u00020\n2\u0006\u00105\u001a\u000206H\u0002J6\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020C0\u008f\u00012\t\b\u0002\u0010\u0097\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0098\u0001\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u0099\u0001J9\u0010\u009a\u0001\u001a\u00020A2\u0006\u0010<\u001a\u00020\t2\u0007\u0010\u0097\u0001\u001a\u00020\t2\t\b\u0002\u0010\u009b\u0001\u001a\u00020\u00192\b\b\u0002\u0010=\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0003\u0010\u009c\u0001J2\u0010\u009d\u0001\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\t2\u0007\u0010\u0097\u0001\u001a\u00020\t2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\tH\u0080@ø\u0001\u0000¢\u0006\u0005\b\u009e\u0001\u0010mJB\u0010\u009f\u0001\u001a\u00020A2\u0006\u0010<\u001a\u00020\t2\u0007\u0010\u0097\u0001\u001a\u00020\t2\t\b\u0002\u0010\u009b\u0001\u001a\u00020\u00192\b\b\u0002\u0010=\u001a\u00020\t2\u0007\u0010\u0098\u0001\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010 \u0001JC\u0010¡\u0001\u001a\u00020\u00142\u0006\u0010c\u001a\u00020\t2\u0006\u0010y\u001a\u00020z2\b\b\u0002\u0010^\u001a\u00020\t2\u0014\u0010¢\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0092\u0001\u0012\u0004\u0012\u00020\u00140~H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010£\u0001J8\u0010¡\u0001\u001a\u00030\u0092\u00012\u0006\u0010c\u001a\u00020\t2\u0006\u0010y\u001a\u00020z2\b\b\u0002\u0010^\u001a\u00020\t2\b\u0010¢\u0001\u001a\u00030¤\u0001H\u0086@ø\u0001\u0000¢\u0006\u0003\u0010¥\u0001J\u0012\u0010¦\u0001\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0017\u0010§\u0001\u001a\u00020S*\u000206H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010¨\u0001J\r\u0010©\u0001\u001a\u00020\t*\u00020AH\u0002J\u0016\u0010d\u001a\u00020\u0014*\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0003\u0010ª\u0001J\u000e\u0010«\u0001\u001a\u00020A*\u00030¬\u0001H\u0002J\r\u0010«\u0001\u001a\u00020A*\u000206H\u0002J!\u0010«\u0001\u001a\u00020A*\u0004\u0018\u0001082\u0006\u0010=\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u00ad\u0001R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010,\u001a\u0004\u0018\u00010+2\b\u0010*\u001a\u0004\u0018\u00010+@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006¶\u0001²\u0006'\u0010·\u0001\u001a\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0013\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010z0\u00130wX\u008a\u0084\u0002"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime;", "", "config", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config;", "(Lcom/obric/aikernel/runtime/AIInferRuntime$Config;)V", "aikPms", "Lcom/obric/aikernel/res/PackageResourceManager;", "availPackages", "", "", "Lcom/obric/aikernel/runtime/AIInferRuntime$PackageWrapper;", "getConfig", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Config;", "encryptResRoot", "Ljava/io/File;", "engineCallback", "com/obric/aikernel/runtime/AIInferRuntime$engineCallback$1", "Lcom/obric/aikernel/runtime/AIInferRuntime$engineCallback$1;", "initJob", "Lkotlinx/coroutines/Deferred;", "", "loras", "mainHost", "Lcom/obric/aikernel/runtime/subproc/MainHost;", "preInitAppJob", "", "preInitAppJobTimeStamp", "", "prepareDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "prepareScheduleState", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/aikernel/runtime/AIInferRuntime$PrepareScheduleState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$infer_runtime_release", "()Lkotlinx/coroutines/CoroutineScope;", "screenOffListener", "com/obric/aikernel/runtime/AIInferRuntime$screenOffListener$1", "Lcom/obric/aikernel/runtime/AIInferRuntime$screenOffListener$1;", "screenOffUsageFlushJob", "Lkotlinx/coroutines/Job;", "<set-?>", "Lcom/obric/aikernel/runtime/subproc/SubProcHost;", "subProcHost", "getSubProcHost", "()Lcom/obric/aikernel/runtime/subproc/SubProcHost;", "unNamedExceptionStrategy", "Lcom/obric/aikernel/model/device/UnNamedExceptionStrategy;", "vmEngine", "Lcom/obric/aikernel/runtime/VmEngine;", "vmPkgBuildDispatcher", "addLoraPackageInfo", "pkg", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "lora", "Lcom/obric/aikernel/res/metadata/data/Lora;", "addPackage", "buildDownloadStatus", "Lcom/google/gson/JsonObject;", ActivityLifecycle.NAME, Params.LORA_TYPE, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "describeLoraDownloadReasonForLog", "loraRes", "Lcom/obric/aikernel/sdk/data/PackageResource;", "updateInfo", "Lcom/obric/aikernel/res/update/UpdateResult;", "describeUpdateInfoForLog", "dump", "fd", "Ljava/io/FileDescriptor;", "fout", "Ljava/io/PrintWriter;", "args", "", "dumpAllAvailPackages", "fetchPackageWrapper", "getAllPackageConfigs", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvailPackage", "getAvailPackageInfos", "Lcom/obric/aee/res/PackageInfo;", "getAvailPackages", "", "getDepsQueryKey", "", "info", "getDownloadingSummary", "getDynamicPackageResources", "getLoraPackage", "getLoraPackageInfo", "pkgName", "event", "getPackage", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackageConfig", "getPackageInfo", "biz", CommonConsts.APM_INNER_EVENT_COST_INIT, "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackageUpdateProgress", "", "getSubProcPackageInfo", "getSubProcProxy", "Lcom/obric/aikernel/runtime/subproc/SubProcHost$Proxy;", "proc", "getVmPackageWrapper", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVmPackageWrapperInternal", "notePackageCorrupt", "version", "notePackageCorrupt$infer_runtime_release", "notePackageCorruptCompat", "restart", "notePackageCorruptCompat$infer_runtime_release", "preInitApp", "preparePackage", "Lkotlin/Pair;", com.obric.memorydata.BuildConfig.CHANNEL, TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareSubProcessPackageInfo", "getWrapper", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushDebugDistributeInfo", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removePackage", "resumeBlockedUpdateTasksIfNeed", "trigger", "schedulePreparePackage", "scheduleRestartByPackage", "stopVmPackage", "subProcAddPackageInfo", "infos", "pkgs", "subProcAddPackageInfo$infer_runtime_release", "summarizeUpdateResults", "results", "", "syncNativeLibInfo", "subProcInfo", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transferLibName", "transferPackage", "updateAll", "caller", TraceCons.METRIC_BACKGROUND, "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", "force", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackageCompat", "updatePackageCompat$infer_runtime_release", "updatePackageInternal", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vmExecute", "callback", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/obric/aikernel/AIKListener;", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Ljava/lang/String;Lcom/obric/aikernel/AIKListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitLocalInit", "buildPackageInfo", "(Lcom/obric/aikernel/res/metadata/data/AIPackage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "describeSelfStateForLog", "(Lcom/obric/aikernel/runtime/AIInferRuntime$PackageWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toPackageResource", "Lcom/obric/aikernel/res/metadata/data/AIModel;", "(Lcom/obric/aikernel/res/metadata/data/Lora;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Callback", "Companion", "Config", "KernelSessionLifeCycle", "MultiProcessConfig", "PackageWrapper", "PrepareScheduleState", "VmExecuteController", "infer_runtime_release", "initParams"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIInferRuntime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6160a = null;
    private static final Set<String> u = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f6161b;
    private final al c;
    private final File d;
    private final com.obric.aikernel.model.device.a e;
    private com.obric.aikernel.runtime.subproc.a f;
    private com.obric.aikernel.runtime.subproc.b g;
    private final PackageResourceManager h;
    private final com.obric.aikernel.runtime.e i;
    private final Map<String, g> j;
    private final Map<String, g> k;
    private final ah l;
    private final ah m;
    private final ConcurrentHashMap<String, h> n;
    private bx o;
    private final k p;
    private final j q;
    private final ar<Unit> r;
    private ar<Boolean> s;
    private long t;

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.AIInferRuntime$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "installDetails", "", "Lcom/obric/aikernel/res/installer/IInstaller$InstallDetails;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$3", f = "AIInferRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<List<? extends Object>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AIInferRuntime this$0;

        AnonymousClass3(AIInferRuntime r3, Continuation<? super AnonymousClass3> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(List<? extends Object> r3, Continuation<? super Unit> r4) {
            return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<Object> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            List<Object> r4 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
            b r2 = this.this$0.a().d();
            if (r2 == null) goto L8;
            r2.a(r4);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"com/obric/aikernel/runtime/AIInferRuntime$5$1", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$INativeLibraryNotifier;", "onSubprocessNativeLibUpdated", "", "proc", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushDebugPackages", "packages", "", "syncNativeLibInfo", "Lkotlinx/coroutines/Deferred;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements PackageResourceManager.PresmConfig.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ar<Unit> f6163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIInferRuntime f6164b;

        a(ar<Unit> r3, AIInferRuntime r4) {
            this.f6163a = (ar) ZeusTransformUtils.wrapperContextForParams(r3, ar.class, "com.obric.memorydata.plugin");
            this.f6164b = r4;
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public Object a(String r3, Continuation<? super Unit> r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f6164b.a().j().a(SetsKt.setOf(r3), r5);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public ar<Unit> a() {
            return this.f6163a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.b
        public void a(List<String> r9) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "packages");
            Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
            Map<String, d.e> r2 = this.f6164b.a().m().c();
            if (r2 == null) goto L13;
            Iterator<Map.Entry<String, d.e>> r3 = r2.entrySet().iterator();
        L6:
            if (r3.hasNext() == false) goto L14;
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L9:
            if (r5.hasNext() == false) goto L6;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
            if (((d.e) ZeusTransformUtils.preCheckCast(r4.getValue(), d.e.class, "com.obric.memorydata.plugin")).a(r6) == false) goto L9;
            r0.add(r4.getKey());
        L14:
            this.f6164b.a().j().a(r0);
            return;
        L13:
            AIInferRuntime r11 = this.f6164b;
            a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
            r0.add(r11.a().l());
            goto L14
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0011\u0010\u0019\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00122\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J8\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020!H\u0016J \u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020(H\u0016J\u0011\u0010+\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0018\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020!H\u0016J\u0011\u0010/\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;", "", "compensateAcceptedRequestCount", "", "pkg", "Lcom/obric/aee/res/PackageInfo;", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "additionalCount", "(Lcom/obric/aee/res/PackageInfo;Lcom/obric/aikernel/sdk/config/RequestParams;I)Ljava/lang/Integer;", "getKernelSessionLifeCycle", "Lcom/obric/aikernel/runtime/AIInferRuntime$KernelSessionLifeCycle;", "getVmExecuteController", "Lcom/obric/aikernel/runtime/AIInferRuntime$VmExecuteController;", "interceptInferRequest", "Lkotlin/Pair;", "Landroid/os/Bundle;", "notePythonVmWontInit", "", "noteResourceManagerWontInit", "notifyVMExecuteBegin", "vmContext", "notifyVMExecuteEnd", "onBuildPackageInfo", "onInferNotResponse", "onPreVmInit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onResInitFinished", "installedDetails", "", "Lcom/obric/aikernel/res/installer/IInstaller$InstallDetails;", "onVmException", "type", "", "code", NotificationCompat.CATEGORY_MESSAGE, "trace", "callerPkgName", "onVmGilHoldTooLong", "threadId", "", "threadName", "holdTimeMs", "onVmInitFinished", "onVmNoResponse", "serviceName", "fullStack", "waitLocalInit", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a {
            public static Integer a(b r1, com.obric.aee.res.b r2, RequestParams r3, int r4) {
                b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r1, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "pkg");
                Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
                return null;
            }

            public static Object a(b r2, Continuation<? super Unit> r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return Unit.INSTANCE;
            }

            public static Pair<Integer, Bundle> a(b r2, com.obric.aee.res.b r3, RequestParams r4) {
                b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "pkg");
                Intrinsics.checkNotNullParameter(r4, TrackerImpl.PARAMS);
                return new Pair(1, null);
            }

            public static void a(b r2) {
                b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            }

            public static void a(b r2, com.obric.aee.res.b r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "pkg");
            }

            public static void a(b r2, RequestParams r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
            }

            public static void a(b r2, RequestParams r3, Bundle r4) {
                b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
                Intrinsics.checkNotNullParameter(r4, "vmContext");
            }

            public static void a(b r1, String r2, int r3, String r4, String r5, com.obric.aee.res.b r6, String r7) {
                b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r1, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "type");
                Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
                Intrinsics.checkNotNullParameter(r5, "trace");
                Intrinsics.checkNotNullParameter(r6, "pkg");
                Intrinsics.checkNotNullParameter(r7, "callerPkgName");
            }

            public static void a(b r2, String r3, String r4) {
                b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "serviceName");
                Intrinsics.checkNotNullParameter(r4, "fullStack");
            }

            public static void a(b r2, List<Object> r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            }

            public static Object b(b r2, Continuation<? super Unit> r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return Unit.INSTANCE;
            }

            public static void b(b r2) {
                b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            }

            public static void b(b r2, RequestParams r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, TrackerImpl.PARAMS);
            }

            public static e c(b r2) {
                b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                return null;
            }

            public static Object c(b r2, Continuation<? super Unit> r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return Unit.INSTANCE;
            }

            public static i d(b r2) {
                b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
                return null;
            }
        }

        Integer a(com.obric.aee.res.b r1, RequestParams r2, int r3);

        Object a(Continuation<? super Unit> r1);

        Pair<Integer, Bundle> a(com.obric.aee.res.b r1, RequestParams r2);

        void a();

        void a(long r1, String r3, long r4);

        void a(com.obric.aee.res.b r1);

        void a(RequestParams r1);

        void a(RequestParams r1, Bundle r2);

        void a(String r1, int r2, String r3, String r4, com.obric.aee.res.b r5, String r6);

        void a(String r1, String r2);

        void a(List<Object> r1);

        Object b(Continuation<? super Unit> r1);

        void b();

        void b(RequestParams r1);

        e c();

        Object c(Continuation<? super Unit> r1);

        i d();
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u001c\u0010\u001f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0!\u0012\u0006\u0012\u0004\u0018\u00010\u00010 2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010 H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b+J\f\u0010,\u001a\u0004\u0018\u00010-*\u00020.J\f\u0010,\u001a\u0004\u0018\u00010-*\u00020/J\f\u00100\u001a\u0004\u0018\u00010\u0004*\u00020*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Companion;", "", "()V", "AEE_EVENT_KEY_CACHE_TTL_MS", "", "AEE_EVENT_KEY_ERROR_MESSAGE", "AEE_EVENT_KEY_ERROR_TYPE", "AEE_EVENT_KEY_FD", "AEE_EVENT_KEY_GIL_HOLD_TIME_MS", "AEE_EVENT_KEY_GIL_THREAD_ID", "AEE_EVENT_KEY_GIL_THREAD_NAME", "AEE_EVENT_KEY_PACKAGE", "AEE_EVENT_KEY_SERVICE", "AEE_EVENT_KEY_TRACE", "AEE_EVENT_KEY_VERSION", "EVENT_LOAD", "EVENT_UNLOAD", "INFER_POWER_REJECT", "", "INFER_QUOTA_ALLOWED", "INFER_QUOTA_REJECT", "INFER_QUOTA_WARNING", "MAX_PREPARE_PARALLELISM", "MAX_VM_PKG_BUILD_PARALLELISM", "TAG", "transparentKeySet", "", "getTransparentKeySet", "()Ljava/util/Set;", "measureElapseTime", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "accept", "", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyVmGilHoldTooLong", "callback", "Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;", "args", "Landroid/os/Bundle;", "notifyVmGilHoldTooLong$infer_runtime_release", "getExtraConfig", "Lcom/google/gson/JsonObject;", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "getLoraType", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker r1) {
            this();
        }

        public final JsonObject a(com.obric.aikernel.res.metadata.config.i r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            return r1.b().getAsJsonObject(WsConstants.KEY_EXTRA);
        }

        public final <T> Object a(Function1<? super Continuation<? super T>, ? extends Object> r5, Function1<? super Long, Unit> r6, Continuation<? super T> r7) {
            Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, AIInferRuntime$Companion$measureElapseTime$1.class) == false) goto L7;
            AIInferRuntime$Companion$measureElapseTime$1 r0 = (AIInferRuntime$Companion$measureElapseTime$1) ZeusTransformUtils.preCheckCast(r10, AIInferRuntime$Companion$measureElapseTime$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r4 = r0.result;
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            long r12 = r0.J$0;
            Function1 r13 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$0, Function1.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r4);
        L18:
            if (r13 == null) goto L20;
            r13.invoke(Boxing.boxLong(SystemClock.elapsedRealtime() - r12));
        L20:
            return r4;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r4);
            long r1 = SystemClock.elapsedRealtime();
            r0.L$0 = r9;
            r0.J$0 = r1;
            r0.label = 1;
            r4 = r8.invoke(r0);
            if (r4 != r11) goto L17;
            return r11;
        L17:
            r13 = r9;
            r12 = r1;
        L7:
            r0 = new AIInferRuntime$Companion$measureElapseTime$1(this, r10);
            goto L8
        }

        public final String a(Bundle r1) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            return r1.getString(Params.LORA_TYPE);
        }

        public final Set<String> a() {
            return AIInferRuntime.c();
        }

        public final void a(b r7, Bundle r8) {
            b r0 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "args");
            if (r0 == null) goto L9;
            long r1 = r8.getLong("thread_id");
            String r6 = r8.getString(LBSLightLocationTraceLogger.THREAD_NAME);
            if (r6 != null) goto L7;
            r6 = "";
        L7:
            r0.a(r1, r6, r8.getLong("hold_time_ms"));
            return;
        }
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0005>?@ABBµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b¢\u0006\u0002\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R%\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u001f\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Config;", "", "context", "Landroid/content/Context;", "corruptExceptionThreshold", "", "enableDebug", "", "pythonExtensionInfo", "", "Lkotlin/Pair;", "", "callback", "Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;", "inferNotResponseTimeMills", "Lkotlin/Function0;", "", "updateInterval", "presmConfig", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "runtimeLoggerWrapper", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config$RuntimeLoggerWrapper;", "subProcProxy", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config$ISubProcessProxy;", "processLifeCycle", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config$IProcessLifeCycle;", "vmPackageSettings", "", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config$VmPackageSettings;", "vmExternalEnv", "(Landroid/content/Context;IZLjava/util/List;Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;Lcom/obric/aikernel/runtime/AIInferRuntime$Config$RuntimeLoggerWrapper;Lcom/obric/aikernel/runtime/AIInferRuntime$Config$ISubProcessProxy;Lcom/obric/aikernel/runtime/AIInferRuntime$Config$IProcessLifeCycle;Ljava/util/Map;Ljava/util/Map;)V", "getCallback", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;", "getContext", "()Landroid/content/Context;", "getCorruptExceptionThreshold", "()I", "getEnableDebug", "()Z", "getInferNotResponseTimeMills", "()Lkotlin/jvm/functions/Function0;", "isInferProcess", "multiProcessConfig", "Lcom/obric/aikernel/runtime/AIInferRuntime$MultiProcessConfig;", "getMultiProcessConfig", "()Lcom/obric/aikernel/runtime/AIInferRuntime$MultiProcessConfig;", "myProcessName", "getMyProcessName", "()Ljava/lang/String;", "getPresmConfig", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "getProcessLifeCycle", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Config$IProcessLifeCycle;", "getPythonExtensionInfo", "()Ljava/util/List;", "getRuntimeLoggerWrapper", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Config$RuntimeLoggerWrapper;", "getSubProcProxy", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Config$ISubProcessProxy;", "getUpdateInterval", "getVmExternalEnv", "()Ljava/util/Map;", "AeeLogForwardingPolicy", "IProcessLifeCycle", "ISubProcessProxy", "RuntimeLoggerWrapper", "VmPackageSettings", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f6165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6166b;
        private final boolean c;
        private final List<Pair<String, Object>> d;
        private final b e;
        private final Function0<Long> f;
        private final Function0<Long> g;
        private final PackageResourceManager.PresmConfig h;
        private final C0273d i;
        private final c j;
        private final b k;
        private final Map<String, String> l;
        private final String m;
        private final f n;
        private final boolean o;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Config$AeeLogForwardingPolicy;", "", "forwardAeeLogDirectly", "", "getForwardAeeLogDirectly", "()Z", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public interface a {
            boolean a();
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001f\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Config$IProcessLifeCycle;", "", "restartByDebugDistribute", "", "procs", "", "", "scheduleRestartProcess", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public interface b {
            Object a(Set<String> r1, Continuation<? super Unit> r2);

            void a(Set<String> r1);
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Config$ISubProcessProxy;", "", "getSubProcProxyInfo", "Landroid/os/Bundle;", "proc", "", "isAlive", "", "Companion", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public interface c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f6167a = null;

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Config$ISubProcessProxy$Companion;", "", "()V", "KEY_NATIVE_LIB", "", "KEY_SUB_HOST", "KEY_VLM_LOCAL_VERSION", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                static final /* synthetic */ a f6168a = null;

                static {
                    f6168a = new a();
                }

                private a() {
                }
            }

            static {
                f6167a = a.f6168a;
            }

            boolean a(String r1);

            Bundle b(String r1);
        }

        /* JADX INFO: renamed from: com.obric.aikernel.runtime.AIInferRuntime$d$d, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J \u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Config$RuntimeLoggerWrapper;", "Lcom/obric/aikernel/runtime/utils/ILogger;", "origin", "(Lcom/obric/aikernel/runtime/utils/ILogger;)V", "aeeLogFlushJob", "Lkotlinx/coroutines/Job;", "aeeLogFlushScope", "Lkotlinx/coroutines/CoroutineScope;", "forwardAeeLogDirectly", "", "mainHost", "Lcom/obric/aikernel/runtime/subproc/MainHost$Proxy;", "getMainHost", "()Lcom/obric/aikernel/runtime/subproc/MainHost$Proxy;", "setMainHost", "(Lcom/obric/aikernel/runtime/subproc/MainHost$Proxy;)V", "getOrigin", "()Lcom/obric/aikernel/runtime/utils/ILogger;", "pendingAeeLogs", "", "Lcom/obric/aikernel/runtime/subproc/MainHost$AeeLogEntry;", "pendingAeeLogsLock", "", "aeeLog", "", "priority", "", LocationMonitorConst.TAG, "", Params.CONTENT, "enqueueMainHostLog", "log", "flushMainHostLogs", "forwardMainHostLog", "message", "level", "scheduleMainHostLogFlushLocked", "tracking", "key", "data", "Lorg/json/JSONObject;", "Companion", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class C0273d implements com.obric.aikernel.runtime.utils.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a f6169a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final com.obric.aikernel.runtime.utils.c f6170b;
            private com.obric.aikernel.runtime.subproc.a.c c;
            private final boolean d;
            private final List<com.obric.aikernel.runtime.subproc.a.C0277a> e;
            private final Object f;
            private bx g;
            private final al h;

            /* JADX INFO: renamed from: com.obric.aikernel.runtime.AIInferRuntime$d$d$a */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Config$RuntimeLoggerWrapper$Companion;", "", "()V", "AEE_LOG_FORWARD_FLUSH_INTERVAL_MS", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
            private static final class a {
                private a() {
                }

                public /* synthetic */ a(DefaultConstructorMarker r1) {
                    this();
                }
            }

            static {
                f6169a = new a(null);
            }

            public C0273d(com.obric.aikernel.runtime.utils.c r6) {
                com.obric.aikernel.runtime.utils.c r7 = (com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r7, "origin");
                this.f6170b = r7;
                if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L5;
                a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            L6:
                boolean r0 = false;
                if (r8 != null) goto L9;
            L11:
                this.d = r0;
                this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
                this.f = new Object();
                this.h = am.a(new ak("AeeMainHostLogFlush").plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")));
                return;
            L9:
                if (r8.a() != true) goto L11;
                r0 = true;
                goto L11
            L5:
                r8 = null;
                goto L6
            }

            private final void a() {
                bx r0 = this.g;
                boolean r1 = true;
                if (r0 != null) goto L5;
            L7:
                r1 = false;
            L8:
                if (r1 == false) goto L10;
                return;
            L10:
                this.g = kotlinx.coroutines.i.a(this.h, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$Config$RuntimeLoggerWrapper$scheduleMainHostLogFlushLocked$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
                return;
            L5:
                if (r0.a() != true) goto L7;
                goto L7
            }

            public static final /* synthetic */ void a(C0273d r0) {
                r0.b();
            }

            private final void a(com.obric.aikernel.runtime.subproc.a.C0277a r3) {
                if (this.d == false) goto L8;
                com.obric.aikernel.runtime.subproc.a.c r2 = this.c;
                if (r2 == null) goto L10;
                r2.a(r3.a(), r3.b(), r3.c());
                return;
            L10:
                return;
            L8:
                b(r3);
            }

            private final void b() {
                Object r0 = this.f;
                monitor-enter(r0);
            L25:
                th = move-exception;
                throw th;
            L5:
                if (this.e.isEmpty() == false) goto L9;
                this.g = null;     // Catch: Throwable -> L25
                monitor-exit(r0);
                return;
            L9:
                List<com.obric.aikernel.runtime.subproc.a.C0277a> r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.e, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
                this.e.clear();     // Catch: Throwable -> L25
                monitor-exit(r0);
                com.obric.aikernel.runtime.subproc.a.c r2 = this.c;
                if (r2 != null) goto L14;
                return;
            L14:
                r2.a(r1);
                Object r3 = this.f;
                monitor-enter(r3);
                this.g = null;     // Catch: Throwable -> L22
                if ((!((Collection) ZeusTransformUtils.preCheckCast(this.e, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
                a();     // Catch: Throwable -> L22
            L19:
                Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L22
                monitor-exit(r3);
                return;
            L22:
                th = move-exception;
                throw th;
            }

            private final void b(com.obric.aikernel.runtime.subproc.a.C0277a r3) {
                if (this.c != null) goto L5;
                return;
            L5:
                Object r0 = this.f;
                monitor-enter(r0);
                this.e.add(r3);     // Catch: Throwable -> L10
                a();     // Catch: Throwable -> L10
                Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
                monitor-exit(r0);
                return;
            L10:
                th = move-exception;
                throw th;
            }

            @Override // com.obric.aikernel.runtime.utils.c
            public void a(int r2, String r3, String r4) {
                Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
                Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
                this.f6170b.a(r2, r3, r4);
                a(new com.obric.aikernel.runtime.subproc.a.C0277a(r2, r3, r4));
            }

            public final void a(com.obric.aikernel.runtime.subproc.a.c r1) {
                this.c = r1;
            }

            @Override // com.obric.aikernel.runtime.utils.c
            public void a(String r2, String r3, int r4) {
                Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
                Intrinsics.checkNotNullParameter(r3, "message");
                this.f6170b.a(r2, r3, r4);
            }

            @Override // com.obric.aikernel.runtime.utils.c
            public void a(String r2, JSONObject r3) {
                Intrinsics.checkNotNullParameter(r2, "key");
                Intrinsics.checkNotNullParameter(r3, "data");
                this.f6170b.a(r2, r3);
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\r"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$Config$VmPackageSettings;", "", "whiteList", "", "", "blackList", "(Ljava/util/Set;Ljava/util/Set;)V", "getBlackList", "()Ljava/util/Set;", "getWhiteList", "canRunPackage", "", "pkg", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Set<String> f6171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Set<String> f6172b;

            /* JADX WARN: Multi-variable type inference failed */
            public e() {
                Object[] r0 = 0 == true ? 1 : 0;
                this(null, r0, 3, 0 == true ? 1 : 0);
            }

            public e(Set<String> r3, Set<String> r4) {
                Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
                Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
                this.f6171a = r5;
                this.f6172b = r6;
            }

            public /* synthetic */ e(Set r2, Set r3, int r4, DefaultConstructorMarker r5) {
                Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
                Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
                if ((r4 & 1) == 0) goto L6;
                r6 = null;
            L6:
                if ((r4 & 2) == 0) goto L8;
                r7 = null;
            L8:
                this(r6, r7);
            }

            public final Set<String> a() {
                return this.f6171a;
            }

            public final boolean a(String r4) {
                Intrinsics.checkNotNullParameter(r4, "pkg");
                Set<String> r0 = this.f6171a;
                if (r0 != null) goto L5;
            L7:
                boolean r1 = false;
            L8:
                if (r1 == true) goto L18;
                Set<String> r3 = this.f6172b;
                if (r3 != null) goto L12;
            L14:
                boolean r5 = false;
            L15:
                if (r5 == true) goto L18;
                return true;
            L12:
                if (r3.contains(r4) != true) goto L14;
                r5 = true;
            L18:
                return false;
            L5:
                if (r0.contains(r4) == true) goto L7;
                r1 = true;
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Context r14, int r15, boolean r16, List<? extends Pair<String, ? extends Object>> r17, b r18, Function0<Long> r19, Function0<Long> r20, PackageResourceManager.PresmConfig r21, C0273d r22, c r23, b r24, Map<String, e> r25, Map<String, String> r26) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
            List<Pair<String, Object>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r18, b.class, "com.obric.memorydata.plugin");
            Function0<Long> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
            Function0<Long> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
            c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r23, c.class, "com.obric.memorydata.plugin");
            b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r24, b.class, "com.obric.memorydata.plugin");
            Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
            Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r6, "inferNotResponseTimeMills");
            Intrinsics.checkNotNullParameter(r7, "updateInterval");
            Intrinsics.checkNotNullParameter(r21, "presmConfig");
            this.f6165a = ZeusTransformUtils.wrapperContext(r2, "com.obric.memorydata.plugin");
            this.f6166b = r15;
            this.c = r16;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r21;
            this.i = r22;
            this.j = r8;
            this.k = r9;
            this.l = r11;
            String r1 = Process.myProcessName();
            Intrinsics.checkNotNullExpressionValue(r1, "myProcessName()");
            this.m = r1;
            boolean r12 = true;
            if (r10 == null) goto L36;
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L6:
            if (r3.hasNext() == false) goto L35;
            Object r13 = r3.next();
            Set<String> r27 = ((e) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), e.class, "com.obric.memorydata.plugin")).a();
            if (r27 != null) goto L10;
        L12:
            Object[] r28 = false;
        L13:
            if (r28 == false) goto L6;
            String r29 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");
            Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r10.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L16:
            if (r30.hasNext() == false) goto L33;
            Object r31 = r30.next();
            if (((e) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r31, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), e.class, "com.obric.memorydata.plugin")).a("vlm_local") == false) goto L16;
            String r32 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r31, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "init config myProcessName:" + this.m + ", mainProcessName:" + r29 + " vlmProc:" + r32);
            Set r33 = null;
            Object[] r34 = 0;
            Object[] r35 = 0;
            if (Intrinsics.areEqual(this.m, r29) == false) goto L28;
            Map r36 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r37 = r10.entrySet().iterator();
        L23:
            if (r37.hasNext() == false) goto L27;
            Map.Entry r110 = (Map.Entry) ZeusTransformUtils.preCheckCast(r37.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(r110.getKey(), r29) == true) goto L23;
            r36.put(r110.getKey(), r110.getValue());
            goto L23
        L27:
            f r38 = new f(r32, true, r36, null);
        L37:
            this.n = r38;
            if (r38.c() != null) goto L40;
            boolean r39 = true;
        L41:
            this.o = r39;
            com.obric.aikernel.runtime.utils.d r40 = com.obric.aikernel.runtime.utils.d.f6216a;
            StringBuilder r41 = new StringBuilder();
            StringBuilder r42 = r41.append("runtime config process=").append(this.m).append(" mainController=").append(r38.b()).append(" inferProcess=").append(r39).append(" vlmProcess=").append(r38.a()).append(" subProcessCount=");
            Map<String, e> r43 = r38.c();
            if (r43 == null) goto L44;
            int r44 = r43.size();
        L45:
            StringBuilder r45 = r42.append(r44).append(" preInitPackage=");
            String r46 = this.h.getPreInitPackageName();
            if (r46 != null) goto L48;
            r46 = "";
        L48:
            StringBuilder r47 = r45.append(r46).append(" useObricDownloader=").append(this.h.getUseObricDownloader()).append(" parallelDownloadNum=").append(this.h.getParallelDownloadNum()).append(" downloadForegroundService=").append(this.h.getAppConfig().getEnableDownloadForegroundService()).append(" enableDebug=").append(this.c).append(" pythonExtensionCount=");
            List<Pair<String, Object>> r48 = this.d;
            if (r48 == null) goto L51;
            int r49 = r48.size();
        L52:
            r47.append(r49).append(" vmExternalEnvConfigured=");
            if (this.l != null) goto L56;
            r12 = false;
        L56:
            r41.append(r12);
            r40.e("AIInferRuntime", r41.toString());
            return;
        L51:
            r49 = 0;
            goto L52
        L44:
            r44 = 0;
            goto L45
        L40:
            r39 = false;
            goto L41
        L28:
            e r50 = (e) ZeusTransformUtils.preCheckCast(r10.get(this.m), e.class, "com.obric.memorydata.plugin");
            if (r50 != null) goto L31;
            r50 = new e(r33, r35 == true ? 1 : 0, 3, r34 == true ? 1 : 0);
        L31:
            r38 = new f(r32, false, null, r50);
            goto L37
        L33:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L10:
            if (r27.isEmpty() != true) goto L12;
            r28 = true;
            goto L13
        L35:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L36:
            r38 = new f(r1, false, null, null, 14, null);
            goto L37
        }

        public final int a() {
            return this.f6166b;
        }

        public final boolean b() {
            return this.c;
        }

        public final List<Pair<String, Object>> c() {
            return this.d;
        }

        public final b d() {
            return this.e;
        }

        public final Function0<Long> e() {
            return this.f;
        }

        public final Function0<Long> f() {
            return this.g;
        }

        public final PackageResourceManager.PresmConfig g() {
            return this.h;
        }

        public final Context getContext() {
            return this.f6165a;
        }

        public final C0273d h() {
            return this.i;
        }

        public final c i() {
            return this.j;
        }

        public final b j() {
            return this.k;
        }

        public final Map<String, String> k() {
            return this.l;
        }

        public final String l() {
            return this.m;
        }

        public final f m() {
            return this.n;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0017\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J0\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H&¨\u0006\u0015"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$KernelSessionLifeCycle;", "", "createSession", "", "callerUid", "destroySession", "", OaidModel.KEY_ID, "getNpuPowerGear", "isSessionForeground", "", "(I)Ljava/lang/Boolean;", "sessionAddThread", CrashBody.TID, "sessionRemoveThread", "setSessionInferenceInfo", "modelStage", "", "energyTendency", "sceneIndex", "targetNpuPowerGear", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface e {
        int a(int r1);

        void b(int r1);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$MultiProcessConfig;", "", "vlmProcessName", "", "mainController", "", "subProcessConfig", "", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config$VmPackageSettings;", "vmPackageSettings", "(Ljava/lang/String;ZLjava/util/Map;Lcom/obric/aikernel/runtime/AIInferRuntime$Config$VmPackageSettings;)V", "getMainController", "()Z", "<set-?>", "Lcom/obric/aikernel/runtime/subproc/MainHost$Proxy;", "mainProxy", "getMainProxy", "()Lcom/obric/aikernel/runtime/subproc/MainHost$Proxy;", "setMainProxy$infer_runtime_release", "(Lcom/obric/aikernel/runtime/subproc/MainHost$Proxy;)V", "proxyMap", "", "Lcom/obric/aikernel/runtime/subproc/SubProcHost$Proxy;", "getProxyMap", "()Ljava/util/Map;", "getSubProcessConfig", "getVlmProcessName", "()Ljava/lang/String;", "getVmPackageSettings", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Config$VmPackageSettings;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6174b;
        private final Map<String, d.e> c;
        private final d.e d;
        private com.obric.aikernel.runtime.subproc.a.c e;
        private final Map<String, com.obric.aikernel.runtime.subproc.b.c> f;

        public f(String r3, boolean r4, Map<String, d.e> r5, d.e r6) {
            Map<String, d.e> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "vlmProcessName");
            this.f6173a = r3;
            this.f6174b = r4;
            this.c = r7;
            this.d = r6;
            this.f = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ f(String r2, boolean r3, Map r4, d.e r5, int r6, DefaultConstructorMarker r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            if ((r6 & 2) == 0) goto L5;
            r3 = true;
        L5:
            Set r0 = null;
            Object[] r1 = 0;
            Object[] r9 = 0;
            if ((r6 & 4) == 0) goto L9;
            r8 = null;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r5 = new d.e(r0, r9 == true ? 1 : 0, 3, r1 == true ? 1 : 0);
        L11:
            this(r2, r3, r8, r5);
        }

        public final String a() {
            return this.f6173a;
        }

        public final void a(com.obric.aikernel.runtime.subproc.a.c r1) {
            this.e = r1;
        }

        public final boolean b() {
            return this.f6174b;
        }

        public final Map<String, d.e> c() {
            return this.c;
        }

        public final d.e d() {
            return this.d;
        }

        public final com.obric.aikernel.runtime.subproc.a.c e() {
            return this.e;
        }

        public final Map<String, com.obric.aikernel.runtime.subproc.b.c> f() {
            return this.f;
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001Bh\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001e\u0010\b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u001f\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u000b0'H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020+R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R+\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018X\u0080\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0018\u0018\u00010$X\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010%\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$PackageWrapper;", "", "src", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "sdkPkg", "Lcom/obric/aikernel/sdk/data/PackageResource;", "lora", "Lcom/obric/aikernel/res/metadata/data/Lora;", "vmPkgGetter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/obric/aee/res/PackageInfo;", "asyncScope", "Lkotlinx/coroutines/CoroutineScope;", "vmPkgDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "timeoutMills", "", "unNamedExceptionStrategy", "Lcom/obric/aikernel/model/device/UnNamedExceptionStrategy;", "(Lcom/obric/aikernel/res/metadata/data/AIPackage;Lcom/obric/aikernel/sdk/data/PackageResource;Lcom/obric/aikernel/res/metadata/data/Lora;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Long;Lcom/obric/aikernel/model/device/UnNamedExceptionStrategy;)V", "getLora", "()Lcom/obric/aikernel/res/metadata/data/Lora;", "pkgCache", "Lkotlin/Result;", "getPkgCache-xLWZpok$infer_runtime_release", "()Lkotlin/Result;", "setPkgCache$infer_runtime_release", "(Lkotlin/Result;)V", "getSdkPkg", "()Lcom/obric/aikernel/sdk/data/PackageResource;", "getSrc", "()Lcom/obric/aikernel/res/metadata/data/AIPackage;", "timeoutElapseTime", "Ljava/lang/Long;", "vmPkg", "Lkotlinx/coroutines/Deferred;", "Lkotlin/jvm/functions/Function1;", "getVmPackageInfo", "Lkotlin/Pair;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTimeout", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aikernel.res.metadata.data.b f6175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PackageResource f6176b;
        private final com.obric.aikernel.res.metadata.data.f c;
        private final Function1<Continuation<? super com.obric.aee.res.b>, Object> d;
        private final al e;
        private final ah f;
        private final Long g;
        private final com.obric.aikernel.model.device.a h;
        private Long i;
        private volatile ar<Result<com.obric.aee.res.b>> j;
        private volatile Result<com.obric.aee.res.b> k;

        public g(com.obric.aikernel.res.metadata.data.b r3, PackageResource r4, com.obric.aikernel.res.metadata.data.f r5, Function1<? super Continuation<? super com.obric.aee.res.b>, ? extends Object> r6, al r7, ah r8, Long r9, com.obric.aikernel.model.device.a r10) {
            Function1<Continuation<? super com.obric.aee.res.b>, Object> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            al r12 = (al) ZeusTransformUtils.wrapperContextForParams(r7, al.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "src");
            Intrinsics.checkNotNullParameter(r4, "sdkPkg");
            Intrinsics.checkNotNullParameter(r12, "asyncScope");
            Intrinsics.checkNotNullParameter(r8, "vmPkgDispatcher");
            Intrinsics.checkNotNullParameter(r10, "unNamedExceptionStrategy");
            this.f6175a = r3;
            this.f6176b = r4;
            this.c = r5;
            this.d = r11;
            this.e = r12;
            this.f = r8;
            this.g = r9;
            this.h = r10;
        }

        public /* synthetic */ g(com.obric.aikernel.res.metadata.data.b r12, PackageResource r13, com.obric.aikernel.res.metadata.data.f r14, Function1 r15, al r16, ah r17, Long r18, com.obric.aikernel.model.device.a r19, int r20, DefaultConstructorMarker r21) {
            Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
            al r7 = (al) ZeusTransformUtils.wrapperContextForParams(r16, al.class, "com.obric.memorydata.plugin");
            if ((r20 & 4) == 0) goto L5;
            com.obric.aikernel.res.metadata.data.f r5 = null;
        L7:
            if ((r20 & 64) == 0) goto L9;
            Long r9 = null;
        L10:
            this(r12, r13, r5, r6, r7, r17, r9, r19);
            return;
        L9:
            r9 = r18;
            goto L10
        L5:
            r5 = r14;
            goto L7
        }

        public static final /* synthetic */ com.obric.aikernel.model.device.a a(g r0) {
            return r0.h;
        }

        public static final /* synthetic */ void a(g r0, Long r1) {
            r0.i = r1;
        }

        public static final /* synthetic */ Long b(g r0) {
            return r0.g;
        }

        public final com.obric.aikernel.res.metadata.data.b a() {
            return this.f6175a;
        }

        public final Object a(Continuation<? super Pair<Integer, com.obric.aee.res.b>> r13) {
            Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r14, AIInferRuntime$PackageWrapper$getVmPackageInfo$1.class) == false) goto L7;
            AIInferRuntime$PackageWrapper$getVmPackageInfo$1 r0 = (AIInferRuntime$PackageWrapper$getVmPackageInfo$1) ZeusTransformUtils.preCheckCast(r14, AIInferRuntime$PackageWrapper$getVmPackageInfo$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r15 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            boolean r4 = true;
            Object r5 = null;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            g this = (g) ZeusTransformUtils.preCheckCast(r0.L$0, g.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
        L44:
            Result r16 = (Result) ZeusTransformUtils.preCheckCast(r15, Result.class, "com.obric.memorydata.plugin");
        L45:
            Result<com.obric.aee.res.b> r12 = this.k;
            if (r12 != null) goto L48;
        L50:
            r4 = false;
        L51:
            if (r4 == true) goto L60;
            Integer r3 = Boxing.boxInt(0);
            if (r12 == null) goto L59;
            Object r17 = r12.m1430unboximpl();
            if (Result.m1427isFailureimpl(r17) == true) goto L58;
            r5 = r17;
        L58:
            r5 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r5, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        L59:
            Pair r18 = new Pair(r3, r5);
        L67:
            return r18;
        L60:
            Throwable r19 = Result.m1424exceptionOrNullimpl(r12.m1430unboximpl());
            if (ZeusTransformUtils.instanceOf(r19, AIKernelException.class) == false) goto L64;
            int r110 = ((AIKernelException) ZeusTransformUtils.preCheckCast(r19, AIKernelException.class, "com.obric.memorydata.plugin")).getCode();
        L66:
            r18 = new Pair(Boxing.boxInt(r110), null);
            goto L67
        L64:
            if (ZeusTransformUtils.instanceOf(r19, IllegalStateException.class) == false) goto L68;
            r110 = 202;
            goto L66
        L68:
            if (r19 == null) goto L70;
            throw r19;
        L70:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new NullPointerException("getVmPackageInfo exception should not null!"), Throwable.class, "com.obric.memorydata.plugin"));
        L48:
            if (Result.m1428isSuccessimpl(r12.m1430unboximpl()) == true) goto L50;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r15);
            monitor-enter(this);
            ar<Result<com.obric.aee.res.b>> r111 = this.j;     // Catch: Throwable -> L71
            if (r111 != null) goto L19;
        L21:
            boolean r112 = false;
        L22:
            if (r112 == false) goto L33;
            Result<com.obric.aee.res.b> r113 = this.k;     // Catch: Throwable -> L71
            if (r113 == null) goto L29;
            Object r114 = r113.m1430unboximpl();     // Catch: Throwable -> L71
            if (Result.m1427isFailureimpl(r114) == false) goto L28;
            r114 = null;
        L28:
            com.obric.aee.res.b r115 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r114, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L71
        L30:
            if (r115 != null) goto L33;
            this.j = null;     // Catch: Throwable -> L71
            goto L33
        L29:
            r115 = null;
        L33:
            if (this.j != null) goto L37;
            Function1<Continuation<? super com.obric.aee.res.b>, Object> r116 = this.d;     // Catch: Throwable -> L71
            if (r116 == null) goto L37;
            this.j = kotlinx.coroutines.i.b(this.e, (CoroutineContext) ZeusTransformUtils.preCheckCast(this.f, CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1(r116, this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);     // Catch: Throwable -> L71
        L37:
            Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L71
            monitor-exit(this);
            ar<Result<com.obric.aee.res.b>> r118 = this.j;
            if (r118 == null) goto L45;
            r0.L$0 = this;
            r0.label = 1;
            r15 = r118.a(r0);
            if (r15 != r1) goto L44;
            return r1;
        L19:
            if (r111.q_() != true) goto L21;
            r112 = true;
        L71:
            th = move-exception;
            throw th;
        L7:
            r0 = new AIInferRuntime$PackageWrapper$getVmPackageInfo$1(this, r14);
            goto L8
        }

        public final void a(Result<com.obric.aee.res.b> r1) {
            this.k = r1;
        }

        public final PackageResource b() {
            return this.f6176b;
        }

        public final com.obric.aikernel.res.metadata.data.f c() {
            return this.c;
        }

        public final Result<com.obric.aee.res.b> d() {
            return this.k;
        }

        public final boolean e() {
            Long r5 = this.i;
            if (r5 == null) goto L8;
            long r1 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue();
            if (SystemClock.elapsedRealtime() > r1) goto L7;
            return false;
        L7:
            return true;
        L8:
            return false;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.AIInferRuntime$getDynamicPackageResources$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$getDynamicPackageResources$1", f = "AIInferRuntime.kt", i = {}, l = {242, 242}, m = "invokeSuspend", n = {}, s = {})
    static final class C10201 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
        final /* synthetic */ String $lora;
        final /* synthetic */ String $pkg;
        int label;
        final /* synthetic */ AIInferRuntime this$0;

        C10201(AIInferRuntime r3, String r4, String r5, Continuation<? super C10201> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$pkg = r4;
            this.$lora = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10201(this.this$0, this.$pkg, this.$lora, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super String> r4) {
            return ((C10201) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10201.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r13);
        L18:
            Pair r12 = (Pair) ZeusTransformUtils.preCheckCast(r13, Pair.class, "com.obric.memorydata.plugin");
            if (r12 == null) goto L25;
            com.obric.aee.res.b r14 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r12.getSecond(), com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L25;
            List<com.obric.aee.res.c> r15 = r14.getResources();
            if (r15 == null) goto L25;
            String r16 = new Gson().toJson(r15);
        L26:
            if (r16 != null) goto L29;
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        L29:
            return r16;
        L25:
            r16 = null;
            goto L26
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
        L13:
            g r17 = (g) ZeusTransformUtils.preCheckCast(r13, g.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L25;
            Continuation<? super Pair<Integer, com.obric.aee.res.b>> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 2;
            r13 = r17.a(r2);
            if (r13 != r0) goto L18;
            return r0;
        L10:
            ResultKt.throwOnFailure(r13);
            AIInferRuntime r5 = this.this$0;
            String r6 = this.$pkg;
            String r7 = this.$lora;
            Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r13 = AIInferRuntime.a(r5, r6, r7, null, r9, 4, null);
            if (r13 != r0) goto L13;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$PrepareScheduleState;", "", "running", "", "pending", "(ZZ)V", "getPending", "()Z", "setPending", "(Z)V", "getRunning", "setRunning", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6180b;

        public h() {
            boolean r0 = false;
            this(r0, r0, 3, null);
        }

        public h(boolean r1, boolean r2) {
            this.f6179a = r1;
            this.f6180b = r2;
        }

        public /* synthetic */ h(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = false;
        L8:
            this(r2, r3);
        }

        public final void a(boolean r1) {
            this.f6179a = r1;
        }

        public final boolean a() {
            return this.f6179a;
        }

        public final void b(boolean r1) {
            this.f6180b = r1;
        }

        public final boolean b() {
            return this.f6180b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
            if (this.f6179a == r6.f6179a) goto L12;
            return false;
        L12:
            if (this.f6180b == r6.f6180b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean r0 = this.f6179a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f6180b;
            if (r4 == true) goto L10;
            r1 = r4;
        L10:
            return r3 + r1;
        }

        public String toString() {
            return "PrepareScheduleState(running=" + this.f6179a + ", pending=" + this.f6180b + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J!\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$VmExecuteController;", "", "afterExecute", "", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "pkg", "Lcom/obric/aee/res/PackageInfo;", "preExecute", "", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lcom/obric/aee/res/PackageInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6181a = null;

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/obric/aikernel/runtime/AIInferRuntime$VmExecuteController$Companion;", "", "()V", "actIf", "", "Lcom/obric/aikernel/runtime/AIInferRuntime$VmExecuteController;", "pkg", "Lcom/obric/aee/res/PackageInfo;", "event", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lcom/obric/aikernel/runtime/AIInferRuntime$VmExecuteController;Lcom/obric/aee/res/PackageInfo;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ a f6182a = null;

            static {
                f6182a = new a();
            }

            private a() {
            }

            public final Object a(i r2, com.obric.aee.res.b r3, String r4, Function2<? super i, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r6) {
                i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
                Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                boolean r9 = true;
                if ((!((Collection) ZeusTransformUtils.preCheckCast(r3.getResources(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
                if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L8;
                r9 = false;
            L8:
                if (r9 == false) goto L10;
            L11:
                Object r10 = r7.invoke(r1, r8);
                if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
                return r10;
            L15:
                return Unit.INSTANCE;
            L10:
                if (Intrinsics.areEqual(r4, "preload") == true) goto L11;
            L17:
                return Unit.INSTANCE;
            }
        }

        static {
            f6181a = a.f6182a;
        }

        Object a(RequestParams r1, com.obric.aee.res.b r2, Continuation<? super Integer> r3);

        void a(RequestParams r1, com.obric.aee.res.b r2);
    }

    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016J \u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¨\u0006\u0015"}, d2 = {"com/obric/aikernel/runtime/AIInferRuntime$engineCallback$1", "Lcom/obric/aee/EngineCallback;", "enableDebug", "", "getContext", "Landroid/content/Context;", "getRootDir", "Ljava/io/File;", "onEvent", "", "event", "", "args", "Landroid/os/Bundle;", "onGetGlobalConfig", "", "onLog", "priority", "", LocationMonitorConst.TAG, Params.CONTENT, "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class j implements com.obric.aee.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIInferRuntime f6183a;

        j(AIInferRuntime r1) {
            this.f6183a = r1;
        }

        @Override // com.obric.aee.a
        public File a() {
            return AIInferRuntime.h(this.f6183a);
        }

        @Override // com.obric.aee.a
        public void a(int r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
            com.obric.aikernel.runtime.utils.d.f6216a.a(r1, r2, r3);
        }

        @Override // com.obric.aee.a
        public void a(String r11, Bundle r12) {
            Intrinsics.checkNotNullParameter(r11, "event");
            Intrinsics.checkNotNullParameter(r12, "args");
            com.obric.aikernel.runtime.utils.d.f6216a.f("aee-event", r11 + ' ' + r12);
            int r0 = r11.hashCode();
            if (r0 == (-1103336865)) goto L18;
            if (r0 == (-1016671705)) goto L14;
            if (r0 == 603014456) goto L10;
            return;
        L10:
            if (r11.equals("ServiceLoadFailed") == false) goto L28;
            String r13 = r12.getString("package", "");
            String r1 = r12.getString("version", "");
            com.obric.aikernel.runtime.utils.d.f6216a.g("aee-service-load-failed", "package=" + r13 + " version=" + r1 + " service=" + r12.getString("service", "") + " fd=" + r12.getInt("fd", -1) + " cache_ttl_ms=" + r12.getLong("cache_ttl_ms", 0) + " error_type=" + r12.getString("error_type", "") + " error_message=" + r12.getString(InfoRequestQPSOptTraceLogger.ERROR_MESSAGE, "") + " trace=" + r12.getString("trace", ""));
            com.obric.aikernel.model.device.a r10 = AIInferRuntime.i(this.f6183a);
            Intrinsics.checkNotNullExpressionValue(r13, "pkgName");
            Intrinsics.checkNotNullExpressionValue(r1, "pkgVersion");
            r10.a(r13, r1);
            return;
        L28:
            return;
        L14:
            if (r11.equals("GilHoldTooLong") == false) goto L29;
            AIInferRuntime.f6160a.a(this.f6183a.a().d(), r12);
            return;
        L29:
            return;
        L18:
            if (r11.equals("ServiceNotResponse") == false) goto L30;
            String r14 = r12.getString("package", "");
            b r15 = this.f6183a.a().d();
            if (r15 == null) goto L26;
            Intrinsics.checkNotNullExpressionValue(r14, "servName");
            r15.a(r14, "");
            return;
        L26:
            return;
        }

        @Override // com.obric.aee.a
        public boolean b() {
            return this.f6183a.a().b();
        }

        @Override // com.obric.aee.a
        public Map<String, String> c() {
            Map<String, String> r0 = this.f6183a.a().k();
            if (r0 == null) goto L5;
            return r0;
        L5:
            return MapsKt.emptyMap();
        }

        @Override // com.obric.aee.a
        public Context getContext() {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6183a.a().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/aikernel/runtime/AIInferRuntime$screenOffListener$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class k extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIInferRuntime f6184a;

        k(AIInferRuntime r1) {
            this.f6184a = r1;
        }

        public void onReceive(Context r8, Intent r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            bx r11 = AIInferRuntime.f(this.f6184a);
            boolean r12 = true;
            if (r11 != null) goto L5;
        L7:
            r12 = false;
        L8:
            if (r12 == false) goto L10;
            return;
        L10:
            AIInferRuntime r13 = this.f6184a;
            AIInferRuntime.a(r13, kotlinx.coroutines.i.a(r13.b(), (CoroutineContext) ZeusTransformUtils.preCheckCast(new ak("ScreenOffUsageFlush"), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$screenOffListener$1$onReceive$1(this.f6184a, null), Function2.class, "com.obric.memorydata.plugin"), 2, null));
            return;
        L5:
            if (r11.a() != true) goto L7;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class l extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public l(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r5, Throwable r6) {
            com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", ((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r5, CoroutineContext.class, "com.obric.memorydata.plugin")).get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ak.f17210a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")) + " crashed " + ExceptionsKt.stackTraceToString(r6));
        }
    }

    static {
        f6160a = new c(null);
        u = SetsKt.setOf(new String[]{IdlKeys.Args_SourcePackageName, IdlKeys.Args_Priority});
    }

    public AIInferRuntime(d r13) {
        Intrinsics.checkNotNullParameter(r13, "config");
        this.f6161b = r13;
        al r5 = am.a(new ak("AIInferRuntime").plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new l(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.c = r5;
        this.d = new File(r13.g().getResRootDir());
        com.obric.aikernel.model.device.a r0 = new com.obric.aikernel.model.device.a(this);
        this.e = r0;
        com.obric.aikernel.runtime.utils.k.f6232a.e();
        if (r13.m().b() == false) goto L5;
        PackageResourceManager r3 = new PackageResourceManager(r13.g());
    L6:
        this.h = r3;
        com.obric.aikernel.runtime.utils.k.f6232a.f();
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "init_stage PackageResourceManager cost " + (com.obric.aikernel.runtime.utils.k.f6232a.f() - com.obric.aikernel.runtime.utils.k.f6232a.e()) + "ms");
        if (r13.m().d() == null) goto L9;
        com.obric.aikernel.runtime.e r6 = new com.obric.aikernel.runtime.e(r5, r13, r0);
    L10:
        this.i = r6;
        this.j = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.k = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
        ExecutorService r1 = Executors.newFixedThreadPool(4);
        Intrinsics.checkNotNullExpressionValue(r1, "newFixedThreadPool(MAX_VM_PKG_BUILD_PARALLELISM)");
        this.l = (ah) ZeusTransformUtils.preCheckCast(bo.a(r1), ah.class, "com.obric.memorydata.plugin");
        ExecutorService r2 = Executors.newFixedThreadPool(2);
        Intrinsics.checkNotNullExpressionValue(r2, "newFixedThreadPool(MAX_PREPARE_PARALLELISM)");
        this.m = (ah) ZeusTransformUtils.preCheckCast(bo.a(r2), ah.class, "com.obric.memorydata.plugin");
        this.n = new ConcurrentHashMap();
        this.p = new k(this);
        j r4 = new j(this);
        this.q = r4;
        com.obric.aikernel.runtime.utils.k.f6232a.a();
        if (r13.m().b() == false) goto L13;
        com.obric.aee.b.f5869a.a((com.obric.aee.a) ZeusTransformUtils.preCheckCast(r4, com.obric.aee.a.class, "com.obric.memorydata.plugin"));
    L13:
        com.obric.aikernel.runtime.utils.k.f6232a.b();
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "init_stage ExecutionEngine.initRes cost " + (com.obric.aikernel.runtime.utils.k.f6232a.b() - com.obric.aikernel.runtime.utils.k.f6232a.a()) + "ms");
        this.r = kotlinx.coroutines.i.b(r5, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$initJob$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        this.t = SystemClock.elapsedRealtime();
        if (r3 == null) goto L16;
        r3.registerPackageObserver((com.obric.aikernel.res.metadata.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), com.obric.aikernel.res.metadata.a.class, "com.obric.memorydata.plugin"));
    L16:
        com.obric.aikernel.runtime.utils.k.f6232a.c();
        if (r3 == null) goto L24;
        Collection<com.obric.aikernel.res.metadata.data.b> r14 = r3.getPackageMap();
        if (r14 == null) goto L24;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r15.hasNext() == false) goto L24;
        d((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin"));
    L24:
        com.obric.aikernel.runtime.utils.k.f6232a.d();
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "init_stage addPackage cost " + (com.obric.aikernel.runtime.utils.k.f6232a.d() - com.obric.aikernel.runtime.utils.k.f6232a.c()) + "ms");
        PackageResourceManager r16 = this.h;
        if (r16 == null) goto L29;
        com.obric.aikernel.res.installer.c r17 = r16.getFusionInstaller();
        if (r17 == null) goto L29;
        r17.a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"));
    L29:
        PackageResourceManager r18 = this.h;
        if (r18 == null) goto L33;
        r18.setRunningDepsGetter((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this), Function0.class, "com.obric.memorydata.plugin"));
    L33:
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6161b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(this.p, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), new IntentFilter("android.intent.action.SCREEN_OFF"), "com.obric.memorydata.plugin");
        if (this.f6161b.m().b() == false) goto L43;
        this.f = new com.obric.aikernel.runtime.subproc.a(this);
        if (this.f6161b.j() == null) goto L39;
        this.f6161b.g().setNativeLibLifeCycle((PackageResourceManager.PresmConfig.b) ZeusTransformUtils.preCheckCast(new a(kotlinx.coroutines.i.b(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$5$syncNativeLib$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null), this), PackageResourceManager.PresmConfig.b.class, "com.obric.memorydata.plugin"));
    L39:
        if (this.f6161b.m().d() != null) goto L48;
        b r12 = this.f6161b.d();
        if (r12 == null) goto L49;
        r12.b();
        return;
    L49:
        return;
    L48:
        return;
    L43:
        this.g = new com.obric.aikernel.runtime.subproc.b(this);
        b r19 = this.f6161b.d();
        if (r19 == null) goto L51;
        r19.a();
        return;
    L51:
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private final g a(com.obric.aikernel.res.metadata.data.b r12, com.obric.aikernel.res.metadata.data.f r13) {
        Map<String, g> r0 = this.k;
        monitor-enter(r0);
        g r10 = new g(r12, a(r12), r13, (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$addLoraPackageInfo$1$wrapper$1(this, r12, r13, null), Function1.class, "com.obric.memorydata.plugin"), this.c, this.l, (Long) ZeusTransformUtils.preCheckCast(this.f6161b.f().invoke(), Long.class, "com.obric.memorydata.plugin"), this.e);     // Catch: Throwable -> L7
        this.k.put(r13.s(), r10);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ g a(AIInferRuntime r0, com.obric.aikernel.res.metadata.data.b r1) {
        return r0.b(r1);
    }

    private final g a(String r2) {
        return (g) ZeusTransformUtils.preCheckCast(this.j.get(r2), g.class, "com.obric.memorydata.plugin");
    }

    private final g a(String r3, String r4, String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return a(r3);
    L12:
        return b(r3, r4, r5);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final h a(Function1 r2, Object r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$tmp0");
        return (h) ZeusTransformUtils.preCheckCast(r4.invoke(r3), h.class, "com.obric.memorydata.plugin");
    }

    private final PackageResource a(com.obric.aikernel.res.metadata.data.a r9) {
        PackageResource r8 = new PackageResource(r9.s(), 1, 1, r9.t(), 0, 16, null);
        if (r9.J() == null) goto L6;
        r8.addFlag(new int[]{1});
    L6:
        if (r9.f() == false) goto L10;
        r8.addFlag(new int[]{4});
        if (r9.e() == false) goto L10;
        r8.addFlag(new int[]{2});
    L10:
        return r8;
    }

    private final PackageResource a(com.obric.aikernel.res.metadata.data.b r10) {
        PackageResource r8 = new PackageResource(r10.s(), 1, 0, r10.t(), 0, 16, null);
        if (r10.J() == null) goto L6;
        r8.addFlag(new int[]{1});
    L6:
        if (r10.f() == false) goto L10;
        r8.addFlag(new int[]{4});
        if (r10.d() == false) goto L10;
        r8.addFlag(new int[]{2});
    L10:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10.p(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L16;
        Object r2 = r12.next();
        if (ZeusTransformUtils.instanceOf(r2, com.obric.aikernel.res.metadata.data.a.class) == false) goto L12;
        r0.add(r2);
        goto L12
    L16:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L18:
        if (r14.hasNext() == false) goto L20;
        r1.add(a((com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin")));
        goto L18
    L20:
        r8.setSubRes((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"));
        if (this.f6161b.b() == false) goto L23;
        com.obric.aikernel.runtime.utils.d.f6216a.d("AIInferRuntime", "toPackageResource: " + r8);
    L23:
        return r8;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0293 -> B:54:0x0298). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x029e -> B:118:0x02a2). Please report as a decompilation issue!!! */
    private final Object a(com.obric.aikernel.res.metadata.data.b r24, Continuation<? super com.obric.aee.res.b> r25) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, AIInferRuntime$buildPackageInfo$1.class) == false) goto L7;
        AIInferRuntime$buildPackageInfo$1 r2 = (AIInferRuntime$buildPackageInfo$1) ZeusTransformUtils.preCheckCast(r0, AIInferRuntime$buildPackageInfo$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
        AIInferRuntime r3 = this;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        char r10 = '@';
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r2.L$6, Collection.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.L$5, String.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.data.d r11 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r2.L$4, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        Iterator r12 = (Iterator) ZeusTransformUtils.preCheckCast(r2.L$3, Iterator.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r2.L$2, Collection.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.data.b r14 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r2.L$1, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        AIInferRuntime r9 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r2.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);
    L54:
        AIInferRuntime r22 = r9;
        Collection r15 = r6;
        r3 = r22;
    L118:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L65
        if (Intrinsics.areEqual(r14.s(), "vlm_local") == false) goto L59;
        boolean r16 = true;
    L61:
        if ((!r11.a(r16)) == false) goto L64;
        Object r17 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L65
    L67:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);
        if (r18 != null) goto L70;
        String r19 = r11.s();
        String r110 = r11.t();
        Uri r111 = r11.i();
        if (r111 == null) goto L81;
        String r112 = r111.getPath();
        if (r112 == null) goto L81;
        String r20 = r112;
    L82:
        Object r21 = new com.obric.aee.res.c(r19, r110, r20, r7);
        r10 = '@';
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", new StringBuilder().append("buildPackageInfo config package=").append(r14.s()).append('@').append(r14.t()).append(" model=").append(r11.s()).append('@').append(r11.t()).append(" encryptedPreset=").append(((com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin")).g()).toString());
        r2 = r2;
        Collection r23 = r15;
        com.obric.aikernel.res.metadata.data.b r26 = r14;
    L85:
        r23.add(r21);
        r23 = r13;
    L16:
        if (r12.hasNext() == false) goto L86;
        r11 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, com.obric.aikernel.res.metadata.data.i.class) == false) goto L33;
        if (((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).g() == false) goto L24;
        String r27 = NativeLibVersionPolicy.INSTANCE.initOrGetVersion(r11.s());
        if (r27 == null) goto L24;
        r11 = new com.obric.aikernel.res.metadata.data.i(r11.s(), r27, r3.f6161b.g());
    L24:
        String r113 = r3.b(((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).s());
        String r114 = ((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).M();
        Uri r115 = ((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).i();
        if (r115 == null) goto L30;
        String r116 = r115.getPath();
        if (r116 == null) goto L30;
        String r117 = r116;
    L31:
        r21 = new com.obric.aee.res.a(r113, r114, r117, ((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).g(), ((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).l());
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "transferPackage config package=" + r26.s() + r10 + r26.t() + " library=" + ((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).s() + r10 + ((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).t() + " native=" + ((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).g());
        r13 = r23;
    L30:
        r117 = "";
        goto L31
    L33:
        if (ZeusTransformUtils.instanceOf(r11, com.obric.aikernel.res.metadata.data.a.class) == true) goto L35;
        r21 = Unit.INSTANCE;
        r13 = r23;
        goto L85
    L35:
        if (r26.j() == false) goto L47;
        com.obric.aikernel.res.metadata.config.a r28 = r26.J();
        if (r28 == null) goto L45;
        JsonObject r29 = r28.b();
        if (r29 == null) goto L45;
        JsonObject r30 = r29.getAsJsonObject("dependency");
        if (r30 == null) goto L45;
        JsonObject r31 = r30.getAsJsonObject("model_center_conf");
        if (r31 == null) goto L45;
        JsonObject r32 = r31.getAsJsonObject(r11.s() + r10 + r11.t());
    L46:
        String r33 = com.obric.aikernel.res.metadata.data.a.c.a(r32);
    L49:
        if (((com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin")).g() == false) goto L55;
        PackageResourceManager.PresmConfig.a r118 = r3.f6161b.g().getDecryptFeature();
        Collection<String> r119 = (Collection) ZeusTransformUtils.preCheckCast(SetsKt.setOf(r11.s() + r10 + r11.t()), Collection.class, "com.obric.memorydata.plugin");
        r2.L$0 = r3;
        r2.L$1 = r26;
        r2.L$2 = r23;
        r2.L$3 = r12;
        r2.L$4 = r11;
        r2.L$5 = r33;
        r2.L$6 = r23;
        r2.label = 1;
        if (r118.a(r119, r2) != r4) goto L53;
        return r4;
    L53:
        r13 = r23;
        r14 = r26;
        r7 = r33;
        r9 = r3;
        r6 = r13;
        goto L54
    L55:
        r13 = r23;
        r14 = r26;
        r7 = r33;
        r15 = r13;
    L45:
        r32 = null;
        goto L46
    L47:
        r33 = r11.l();
        goto L49
    L86:
        List r34 = (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");
        Iterator r35 = ((Iterable) ZeusTransformUtils.preCheckCast(r26.q(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L88:
        if (r35.hasNext() == false) goto L94;
        com.obric.aikernel.res.metadata.data.a.d r36 = (com.obric.aikernel.res.metadata.data.a.d) ZeusTransformUtils.preCheckCast(r35.next(), com.obric.aikernel.res.metadata.data.a.d.class, "com.obric.memorydata.plugin");
        if (r36.d() == true) goto L88;
        throw new IllegalStateException("check dependent aikernel model " + r36 + " not avail!");
    L94:
        String r120 = r26.s();
        String r121 = r26.M();
        Uri r37 = r26.i();
        if (r37 == null) goto L100;
        String r38 = r37.getPath();
        if (r38 == null) goto L100;
        String r122 = r38;
    L101:
        Iterable r39 = (Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.memorydata.plugin");
        Collection r40 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r41 = r39.iterator();
    L103:
        if (r41.hasNext() == false) goto L107;
        Object r42 = r41.next();
        if (ZeusTransformUtils.instanceOf(r42, com.obric.aee.res.a.class) == false) goto L103;
        r40.add(r42);
        goto L103
    L107:
        List r123 = (List) ZeusTransformUtils.preCheckCast(r40, List.class, "com.obric.memorydata.plugin");
        Iterable r43 = (Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.memorydata.plugin");
        Collection r44 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r45 = r43.iterator();
    L109:
        if (r45.hasNext() == false) goto L113;
        Object r46 = r45.next();
        if (ZeusTransformUtils.instanceOf(r46, com.obric.aee.res.c.class) == false) goto L109;
        r44.add(r46);
        goto L109
    L113:
        com.obric.aee.res.b r47 = new com.obric.aee.res.b(r120, r121, r122, "", r123, (List) ZeusTransformUtils.preCheckCast(r44, List.class, "com.obric.memorydata.plugin"), r26.l());
        b r48 = r3.f6161b.d();
        if (r48 == null) goto L116;
        r48.a(r47);
    L116:
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "buildPackageInfo " + r26 + " done!");
        return r47;
    L100:
        r122 = "";
    L81:
        r20 = "";
        goto L82
    L70:
        if (((com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r11, com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin")).g() == false) goto L72;
        int r49 = 202;
    L74:
        throw new AIKernelException(r49, "buildPackageInfo check model resource", r18, 0, 8, null);
    L72:
        r49 = 203;
        goto L74
    L64:
        throw new IllegalStateException(("model resource requires reinstall: " + r11.s() + r10 + r11.t()).toString());     // Catch: Throwable -> L65
    L59:
        r16 = false;
    L65:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L67
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r26 = r24;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "buildPackageInfo " + r26 + " start!");
        Iterable r50 = (Iterable) ZeusTransformUtils.preCheckCast(r24.p(), Iterable.class, "com.obric.memorydata.plugin");
        r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r50, 10)), Collection.class, "com.obric.memorydata.plugin");
        r12 = r50.iterator();
    L7:
        r3 = this;
        r2 = new AIInferRuntime$buildPackageInfo$1(r3, r0);
        goto L8
    }

    private final Object a(com.obric.aikernel.res.metadata.data.f r22, String r23, Continuation<? super PackageResource> r24) {
        AIInferRuntime r0 = this;
        com.obric.aikernel.res.metadata.data.f r1 = r22;
        String r2 = r23;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AIInferRuntime$toPackageResource$1.class) == false) goto L7;
        AIInferRuntime$toPackageResource$1 r5 = (AIInferRuntime$toPackageResource$1) ZeusTransformUtils.preCheckCast(r3, AIInferRuntime$toPackageResource$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        Boolean r8 = null;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        int r9 = r5.I$0;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5.L$2, String.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.res.metadata.data.f r11 = (com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r5.L$1, com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin");
        AIInferRuntime r12 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r5.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        int r13 = r9;
        r0 = r12;
        Object r14 = r4;
        r2 = r10;
        r1 = r11;
    L26:
        UpdateResult r15 = (UpdateResult) ZeusTransformUtils.preCheckCast(r14, UpdateResult.class, "com.obric.memorydata.plugin");
    L28:
        if (r1 == null) goto L33;
        String r16 = r1.s();
        if (r16 == null) goto L33;
        String r17 = r16;
    L34:
        String r18 = "";
        if (r1 == null) goto L43;
        String r19 = r1.t();
        if (r19 == null) goto L43;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L42;
        r19 = null;
    L42:
        if (r19 == null) goto L43;
    L50:
        String r110 = r19;
    L51:
        PackageResource r20 = new PackageResource(r17, 1, 3, r110, 0, 16, null);
        if (r13 != 0) goto L54;
        if (r15 != null) goto L54;
    L55:
        if (r1 != null) goto L57;
    L59:
        boolean r21 = false;
    L60:
        if (r21 == false) goto L62;
        r20.addFlag(new int[]{2});
    L62:
        if (r1 != null) goto L64;
    L66:
        boolean r25 = false;
    L67:
        if (r25 == false) goto L69;
        r20.addFlag(new int[]{4});
    L69:
        if (r1 == null) goto L77;
        List<com.obric.aikernel.res.metadata.data.a> r26 = r1.q();
        if (r26 == null) goto L77;
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r27.iterator();
    L74:
        if (r29.hasNext() == false) goto L76;
        r28.add(r0.a((com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r29.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin")));
        goto L74
    L76:
        List<PackageResource> r30 = (List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin");
    L78:
        r20.setSubRes(r30);
        if (r20.isDownloaded() == true) goto L94;
        com.obric.aikernel.runtime.utils.d r31 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r32 = new StringBuilder().append("toPackageResource lora downloaded=false loraType=").append(r2).append(" version=");
        if (r1 == null) goto L86;
        String r33 = r1.t();
        if (r33 == null) goto L86;
        r18 = r33;
    L86:
        StringBuilder r34 = r32.append(r18).append(" selfReady=");
        if (r1 == null) goto L89;
        Boolean r35 = Boxing.boxBoolean(r1.f());
    L90:
        StringBuilder r36 = r34.append(r35).append(" selfAvailable=");
        if (r1 == null) goto L93;
        r8 = Boxing.boxBoolean(r1.e());
    L93:
        r31.a("AIInferRuntime", r36.append(r8).append(" updateInfo=").append(r0.a(r15)).append(" reason=").append(r0.a(r2, r20, r15)).toString());
        goto L94
    L89:
        r35 = null;
    L94:
        return r20;
    L77:
        r30 = null;
        goto L78
    L64:
        if (r1.f() != true) goto L66;
        r25 = true;
        goto L67
    L57:
        if (r1.e() != true) goto L59;
        r21 = true;
    L54:
        r20.addFlag(new int[]{1});
    L43:
        if (r15 == null) goto L47;
        com.obric.aikernel.res.metadata.config.k r37 = r15.getCfg();
        if (r37 == null) goto L47;
        r19 = r37.c();
    L48:
        if (r19 != null) goto L50;
        r110 = "";
    L47:
        r19 = null;
    L33:
        r17 = r2;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        if (r1 == null) goto L17;
        com.obric.aikernel.res.metadata.config.a r38 = r22.J();
    L18:
        if (r38 == null) goto L20;
        r13 = 1;
    L21:
        PackageResourceManager r39 = r0.h;
        if (r39 == null) goto L27;
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r2;
        r5.I$0 = r13;
        r5.label = 1;
        r14 = r39.getPackageUpdateInfo(r2, r5);
        if (r14 != r6) goto L26;
        return r6;
    L27:
        r15 = null;
        goto L28
    L20:
        r13 = 0;
        goto L21
    L17:
        r38 = null;
    L7:
        r5 = new AIInferRuntime$toPackageResource$1(r0, r3);
        goto L8
    }

    private final Object a(g r2, Continuation<? super Unit> r3) {
        Object r1 = r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r1;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object a(AIInferRuntime r2, com.obric.aikernel.res.metadata.data.b r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AIInferRuntime r2, com.obric.aikernel.res.metadata.data.f r3, String r4, Continuation r5) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AIInferRuntime r2, String r3, Bundle r4, Continuation r5) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AIInferRuntime r2, String r3, String r4, String r5, Continuation r6) {
        return r2.b(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object a(AIInferRuntime r1, String r2, String r3, String r4, Continuation r5, int r6, Object r7) {
        Continuation<? super g> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "";
    L9:
        return r1.b(r2, r3, r4, r8);
    }

    public static final /* synthetic */ Object a(AIInferRuntime r2, String r3, String r4, Continuation r5) {
        return r2.b(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(AIInferRuntime r6, String r7, String r8, boolean r9, RequestParams r10, Continuation r11, int r12, Object r13) {
        Continuation<? super List<Pair<String, Boolean>>> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 2) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r12 & 4) == 0) goto L9;
        r9 = true;
    L9:
        boolean r3 = r9;
        if ((r12 & 8) == 0) goto L13;
        r10 = new RequestParams(null, null, 3, null);
    L13:
        return r6.a(r7, r2, r3, r10, r5);
    L5:
        r2 = r8;
        goto L7
    }

    public static /* synthetic */ Object a(AIInferRuntime r6, String r7, String r8, boolean r9, String r10, Continuation r11, int r12, Object r13) {
        Continuation<? super PackageResource> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L5;
        r9 = false;
    L5:
        boolean r3 = r9;
        if ((r12 & 8) == 0) goto L9;
        r10 = "";
    L9:
        return r6.a(r7, r8, r3, r10, r5);
    }

    public static final /* synthetic */ Object a(AIInferRuntime r7, String r8, String r9, boolean r10, String r11, boolean r12, Continuation r13) {
        return r7.a(r8, r9, r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AIInferRuntime r2, String r3, String r4, boolean r5, Continuation r6) {
        return r2.a(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AIInferRuntime r2, String r3, Continuation r4) {
        return r2.e(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(AIInferRuntime r1, String r2, boolean r3, Continuation r4, int r5, Object r6) {
        Continuation<? super Map<String, UpdateResult>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = PackageResourceManager.DEBUG_CALLER;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        return r1.a(r2, r3, r7);
    }

    public static final /* synthetic */ Object a(AIInferRuntime r2, Continuation r3) {
        return r2.c((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AIInferRuntime r8, Function1 r9, String r10, RequestParams r11, boolean r12, Continuation r13) {
        return r8.a((Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin"), r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r5, Bundle r6, Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AIInferRuntime$syncNativeLibInfo$1.class) == false) goto L7;
        AIInferRuntime$syncNativeLibInfo$1 r0 = (AIInferRuntime$syncNativeLibInfo$1) ZeusTransformUtils.preCheckCast(r8, AIInferRuntime$syncNativeLibInfo$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L26:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        Map<String, String> r10 = NativeLibVersionPolicy.INSTANCE.getNativeLibs(r6);
        if (r10 == null) goto L26;
        NativeLibVersionPolicy.INSTANCE.setSubProcessVersionMap(r5, r10);
        if (r10.isEmpty() == false) goto L26;
        PackageResourceManager r4 = this.h;
        if (r4 == null) goto L26;
        ar<Unit> r11 = r4.refreshAllPackageState();
        if (r11 == null) goto L26;
        r0.label = 1;
        if (r11.a(r0) != r1) goto L26;
        return r1;
    L7:
        r0 = new AIInferRuntime$syncNativeLibInfo$1(this, r8);
        goto L8
    }

    private final Object a(String r32, String r33, boolean r34, String r35, boolean r36, Continuation<? super PackageResource> r37) {
        AIInferRuntime r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r37, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AIInferRuntime$updatePackageInternal$1.class) == false) goto L7;
        AIInferRuntime$updatePackageInternal$1 r4 = (AIInferRuntime$updatePackageInternal$1) ZeusTransformUtils.preCheckCast(r2, AIInferRuntime$updatePackageInternal$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r4.label;
        boolean r16 = false;
        boolean r12 = true;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        ResultKt.throwOnFailure(r3);
    L76:
        return (PackageResource) ZeusTransformUtils.preCheckCast(r3, PackageResource.class, "com.obric.memorydata.plugin");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r7 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r4.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r12 = true;
    L61:
        com.obric.aikernel.res.metadata.data.b r8 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L65;
        PackageResource r9 = r7.a(r8);
        if (r9 == null) goto L65;
    L69:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L71;
        r16 = r12;
    L71:
        if (r16 == false) goto L77;
        r4.L$0 = null;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.L$3 = null;
        r4.L$4 = null;
        r4.label = 4;
        r3 = r7.a(r6, r1, r4);
        if (r3 != r14) goto L76;
        return r14;
    L77:
        return r9;
    L65:
        String r10 = r6;
        AIInferRuntime r30 = r7;
        String r11 = r1;
        r0 = r30;
    L67:
        r6 = r10;
        r9 = new PackageResource(r10, 1, 0, null, 0, 24, null);
        String r31 = r11;
        r7 = r0;
        r1 = r31;
        goto L69
    L18:
        boolean r13 = r4.Z$1;
        boolean r15 = r4.Z$0;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r20 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r4.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L39:
        com.obric.aikernel.res.metadata.data.b r21 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L45;
        String r23 = r19;
        if (r21.d() != r12) goto L44;
        boolean r110 = r12;
    L48:
        if (r110 == false) goto L50;
        boolean r22 = r13;
        r0 = r20;
        boolean r111 = r15;
        String r24 = r17;
        String r25 = r18;
    L53:
        boolean r26 = r22;
        String r27 = r24;
        r10 = r23;
    L55:
        PackageResourceManager r28 = r0.h;
        if (r28 == null) goto L66;
        r4.L$0 = r0;
        r4.L$1 = r10;
        r4.L$2 = r27;
        r4.L$3 = null;
        r4.L$4 = null;
        r4.label = 3;
        Object r29 = r28.updatePackage(r10, r25, r26, r111, r27, r4);
        if (r29 != r14) goto L60;
        return r14;
    L60:
        r6 = r10;
        r3 = r29;
        r7 = r0;
        r1 = r27;
        goto L61
    L66:
        r11 = r27;
        goto L67
    L50:
        return new PackageResource(r23, 1, 0, null, 0, 24, null);
    L44:
        r110 = false;
        goto L48
    L45:
        boolean r38 = r13;
        r0 = r20;
        boolean r112 = r15;
        String r113 = r17;
        r25 = r18;
        String r39 = r19;
    L47:
        r18 = r25;
        r23 = r39;
        r17 = r113;
        r15 = r112;
        r110 = false;
        r20 = r0;
        r13 = r38;
        goto L48
    L19:
        boolean r40 = r4.Z$1;
        boolean r41 = r4.Z$0;
        String r42 = (String) ZeusTransformUtils.preCheckCast(r4.L$4, String.class, "com.obric.memorydata.plugin");
        String r43 = (String) ZeusTransformUtils.preCheckCast(r4.L$3, String.class, "com.obric.memorydata.plugin");
        String r44 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        String r114 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r45 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r4.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r112 = r41;
        Object r46 = r3;
        r39 = r114;
        r113 = r43;
        r38 = r40;
        r0 = r45;
        r25 = r44;
    L26:
        PackageResource r47 = (PackageResource) ZeusTransformUtils.preCheckCast(r46, PackageResource.class, "com.obric.memorydata.plugin");
        if (r47 != null) goto L29;
    L31:
        boolean r48 = false;
    L32:
        if (r48 == true) goto L52;
        PackageResourceManager r49 = r0.h;
        if (r49 == null) goto L46;
        r4.L$0 = r0;
        r4.L$1 = r39;
        r4.L$2 = r25;
        r4.L$3 = r113;
        r4.L$4 = null;
        r4.Z$0 = r112;
        r4.Z$1 = r38;
        r4.label = 2;
        boolean r210 = r38;
        String r211 = r113;
        boolean r115 = r112;
        Object r50 = PackageResourceManager.updatePackage$default(r49, r42, r25, r38, r112, null, r4, 16, null);
        if (r50 != r14) goto L38;
        return r14;
    L38:
        r18 = r25;
        r19 = r39;
        r3 = r50;
        r15 = r115;
        r17 = r211;
        r20 = r0;
        r13 = r210;
        goto L39
    L46:
        r12 = true;
        goto L47
    L52:
        r22 = r38;
        r24 = r113;
        r12 = true;
        r111 = r112;
        r23 = r39;
        goto L53
    L29:
        if (r47.isAvailable() != true) goto L31;
        r48 = true;
        goto L32
    L20:
        ResultKt.throwOnFailure(r3);
        String r51 = r0.f6161b.g().getPreInitPackageName();
        if (r51 == null) goto L54;
        r4.L$0 = r0;
        r39 = r32;
        r4.L$1 = r39;
        r4.L$2 = r33;
        r4.L$3 = r35;
        r4.L$4 = r51;
        r4.Z$0 = r34;
        r38 = r36;
        r4.Z$1 = r38;
        r4.label = 1;
        Object r116 = r0.a(r51, r4);
        if (r116 != r14) goto L25;
        return r14;
    L25:
        r112 = r34;
        r42 = r51;
        r25 = r33;
        r46 = r116;
        r113 = r35;
        goto L26
    L54:
        r10 = r32;
        r27 = r35;
        r26 = r36;
        r12 = true;
        r25 = r33;
        r111 = r34;
    L7:
        r4 = new AIInferRuntime$updatePackageInternal$1(r0, r2);
        goto L8
    }

    private final Object a(String r8, String r9, boolean r10, Continuation<? super g> r11) {
        Continuation<? super g> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (r10 == false) goto L7;
        return c(r8, r9, r4);
    L7:
        return a(this, r8, r9, null, r4, 4, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x03b3 -> B:83:0x03b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x03d0 -> B:69:0x0354). Please report as a decompilation issue!!! */
    private final Object a(Function1<? super Continuation<? super g>, ? extends Object> r11, String r12, final RequestParams r13, final boolean r14, Continuation<? super Boolean> r15) {
        final Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, AIInferRuntime$prepareSubProcessPackageInfo$1.class) == false) goto L7;
        AIInferRuntime$prepareSubProcessPackageInfo$1 r1 = (AIInferRuntime$prepareSubProcessPackageInfo$1) ZeusTransformUtils.preCheckCast(r17, AIInferRuntime$prepareSubProcessPackageInfo$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r18 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r5 = false;
        switch(r1.label) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        com.obric.aikernel.runtime.subproc.b.C0279b r10 = (com.obric.aikernel.runtime.subproc.b.C0279b) ZeusTransformUtils.preCheckCast(r1.L$0, com.obric.aikernel.runtime.subproc.b.C0279b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L126:
        if (r10 == null) goto L131;
        if (r10.a() != true) goto L131;
        r5 = true;
    L131:
        return Boxing.boxBoolean(r5);
    L13:
        r10 = (com.obric.aikernel.runtime.subproc.b.C0279b) ZeusTransformUtils.preCheckCast(r1.L$3, com.obric.aikernel.runtime.subproc.b.C0279b.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.subproc.b.c r19 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r1.L$2, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r111 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L105:
        AIInferRuntime r0 = r111;
        String r112 = r110;
    L106:
        if (r10 != null) goto L108;
    L110:
        boolean r113 = false;
    L111:
        if (r113 == false) goto L120;
        if (r19 == null) goto L117;
        com.obric.aikernel.runtime.subproc.a r114 = r0.f;
        if (r114 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mainHost");
        r114 = null;
    L116:
        r19.a(r114);
        Unit r115 = Unit.INSTANCE;
    L118:
        if (r115 != null) goto L120;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "setHost to proc " + r112 + " but got null proxy.");
        goto L120
    L117:
        r115 = null;
    L120:
        if (r10 == null) goto L126;
        Bundle r116 = r10.c();
        if (r116 == null) goto L126;
        r1.L$0 = r10;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 10;
        if (r0.a(r112, r116, r1) != r3) goto L126;
        return r3;
    L108:
        if (r10.b() != true) goto L110;
        r113 = true;
        goto L111
    L14:
        r10 = (com.obric.aikernel.runtime.subproc.b.C0279b) ZeusTransformUtils.preCheckCast(r1.L$3, com.obric.aikernel.runtime.subproc.b.C0279b.class, "com.obric.memorydata.plugin");
        r19 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r1.L$2, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        r110 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        r111 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L100:
        g r117 = (g) ZeusTransformUtils.preCheckCast(r18, g.class, "com.obric.memorydata.plugin");
        if (r117 == null) goto L105;
        r1.L$0 = r111;
        r1.L$1 = r110;
        r1.L$2 = r19;
        r1.L$3 = r10;
        r1.label = 9;
        if (r111.a(r117, r1) != r3) goto L105;
        return r3;
    L15:
        com.obric.aikernel.runtime.subproc.b.c r118 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r1.L$5, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.subproc.b.c r119 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r1.L$4, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        Lazy r120 = (Lazy) ZeusTransformUtils.preCheckCast(r1.L$3, Lazy.class, "com.obric.memorydata.plugin");
        Function0 r121 = (Function0) ZeusTransformUtils.preCheckCast(r1.L$2, Function0.class, "com.obric.memorydata.plugin");
        String r122 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        r0 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L83:
        RequestParams r123 = (RequestParams) ZeusTransformUtils.preCheckCast(r18, RequestParams.class, "com.obric.memorydata.plugin");
        if (r123 == null) goto L86;
        r10 = r118.a(r123);
        String r8 = r122;
        com.obric.aikernel.runtime.subproc.b.c r124 = r119;
        Function0 r125 = r121;
        r112 = r8;
    L69:
        if (r10 != null) goto L89;
        r1.L$0 = r0;
        r1.L$1 = r112;
        r1.L$2 = r125;
        r1.L$3 = r120;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 5;
        if (au.a(1000, r1) != r3) goto L73;
        return r3;
    L73:
        Lazy r126 = r120;
        String r127 = r112;
        AIInferRuntime r128 = r0;
    L74:
        r1.L$0 = r128;
        r1.L$1 = r127;
        r1.L$2 = r125;
        r1.L$3 = r126;
        r1.label = 6;
        r18 = r128.e(r127, r1);
        if (r18 == r3) goto L76;
    L17:
        r122 = r127;
        r0 = r128;
        r120 = r126;
        r121 = r125;
        r118 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r18, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        if (r118 == null) goto L88;
        ar r129 = (ar) ZeusTransformUtils.preCheckCast(a(r120).getSecond(), ar.class, "com.obric.memorydata.plugin");
        r1.L$0 = r0;
        r1.L$1 = r122;
        r1.L$2 = r121;
        r1.L$3 = r120;
        r1.L$4 = r118;
        r1.L$5 = r118;
        r1.label = 7;
        r18 = r129.a(r1);
        if (r18 != r3) goto L82;
        return r3;
    L82:
        r119 = r118;
        goto L83
    L88:
        r125 = r121;
        r112 = r122;
        r124 = r118;
        r10 = null;
        goto L69
    L76:
        return r3;
    L89:
        r19 = r124;
    L90:
        if (r10 != null) goto L92;
    L94:
        boolean r130 = false;
    L95:
        if (r130 == false) goto L106;
        ar r131 = (ar) ZeusTransformUtils.preCheckCast(a(r120).getFirst(), ar.class, "com.obric.memorydata.plugin");
        r1.L$0 = r0;
        r1.L$1 = r112;
        r1.L$2 = r19;
        r1.L$3 = r10;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 8;
        r18 = r131.a(r1);
        if (r18 != r3) goto L99;
        return r3;
    L99:
        r110 = r112;
        r111 = r0;
        goto L100
    L92:
        if (r10.a() != true) goto L94;
        r130 = true;
        goto L95
    L86:
        r121.invoke();
        throw new KotlinNothingValueException();
    L16:
        r126 = (Lazy) ZeusTransformUtils.preCheckCast(r1.L$3, Lazy.class, "com.obric.memorydata.plugin");
        r125 = (Function0) ZeusTransformUtils.preCheckCast(r1.L$2, Function0.class, "com.obric.memorydata.plugin");
        r127 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        r128 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        goto L17
    L18:
        r126 = (Lazy) ZeusTransformUtils.preCheckCast(r1.L$3, Lazy.class, "com.obric.memorydata.plugin");
        r125 = (Function0) ZeusTransformUtils.preCheckCast(r1.L$2, Function0.class, "com.obric.memorydata.plugin");
        r127 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        r128 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        goto L74
    L19:
        com.obric.aikernel.runtime.subproc.b.c r132 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r1.L$5, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.subproc.b.c r133 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r1.L$4, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        r120 = (Lazy) ZeusTransformUtils.preCheckCast(r1.L$3, Lazy.class, "com.obric.memorydata.plugin");
        Function0 r134 = (Function0) ZeusTransformUtils.preCheckCast(r1.L$2, Function0.class, "com.obric.memorydata.plugin");
        String r135 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        r0 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L62:
        RequestParams r136 = (RequestParams) ZeusTransformUtils.preCheckCast(r18, RequestParams.class, "com.obric.memorydata.plugin");
        if (r136 == null) goto L65;
        r10 = r132.a(r136);
        String r9 = r135;
        r124 = r133;
        String r137 = r9;
    L68:
        Function0 r20 = r134;
        r112 = r137;
        r125 = r20;
        goto L69
    L65:
        r134.invoke();
        throw new KotlinNothingValueException();
    L20:
        Lazy r138 = (Lazy) ZeusTransformUtils.preCheckCast(r1.L$3, Lazy.class, "com.obric.memorydata.plugin");
        Function0 r139 = (Function0) ZeusTransformUtils.preCheckCast(r1.L$2, Function0.class, "com.obric.memorydata.plugin");
        String r140 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r141 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        r120 = r138;
        final AIInferRuntime this = r141;
        r134 = r139;
        r137 = r140;
    L56:
        r124 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r18, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        if (r124 == null) goto L67;
        ar r142 = (ar) ZeusTransformUtils.preCheckCast(a(r120).getSecond(), ar.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.L$1 = r137;
        r1.L$2 = r134;
        r1.L$3 = r120;
        r1.L$4 = r124;
        r1.L$5 = r124;
        r1.label = 4;
        r18 = r142.a(r1);
        if (r18 != r3) goto L61;
        return r3;
    L61:
        r0 = this;
        r132 = r124;
        r135 = r137;
        r133 = r132;
        goto L62
    L67:
        r0 = this;
        r10 = null;
        goto L68
    L21:
        com.obric.aikernel.runtime.subproc.b.c r143 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r1.L$5, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        r19 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(r1.L$4, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        r120 = (Lazy) ZeusTransformUtils.preCheckCast(r1.L$3, Lazy.class, "com.obric.memorydata.plugin");
        Function0 r144 = (Function0) ZeusTransformUtils.preCheckCast(r1.L$2, Function0.class, "com.obric.memorydata.plugin");
        String r145 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        r0 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L46:
        RequestParams r146 = (RequestParams) ZeusTransformUtils.preCheckCast(r18, RequestParams.class, "com.obric.memorydata.plugin");
        if (r146 == null) goto L49;
        r10 = r143.a(r146);
        r112 = r145;
        goto L90
    L49:
        r144.invoke();
        throw new KotlinNothingValueException();
    L22:
        Lazy r147 = (Lazy) ZeusTransformUtils.preCheckCast(r1.L$3, Lazy.class, "com.obric.memorydata.plugin");
        Function0 r148 = (Function0) ZeusTransformUtils.preCheckCast(r1.L$2, Function0.class, "com.obric.memorydata.plugin");
        r12 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r149 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        Lazy r150 = r147;
        this = r149;
        Object r151 = r18;
        Function0 r152 = r148;
    L37:
        Object r153 = ZeusTransformUtils.preCheckCast(r151, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
    L38:
        com.obric.aikernel.runtime.subproc.b.c r154 = (com.obric.aikernel.runtime.subproc.b.c) r153;
    L39:
        Lazy r21 = r150;
        AIInferRuntime r155 = this;
        r143 = r154;
        r112 = r12;
        r120 = r21;
        if (r143 == null) goto L51;
        ar r156 = (ar) ZeusTransformUtils.preCheckCast(a(r120).getSecond(), ar.class, "com.obric.memorydata.plugin");
        r1.L$0 = r155;
        r1.L$1 = r112;
        r1.L$2 = r152;
        r1.L$3 = r120;
        r1.L$4 = r143;
        r1.L$5 = r143;
        r1.label = 2;
        Object r157 = r156.a(r1);
        if (r157 != r3) goto L45;
        return r3;
    L45:
        r0 = r155;
        r19 = r143;
        r145 = r112;
        r144 = r152;
        r18 = r157;
        goto L46
    L51:
        r0 = r155;
        r19 = r143;
        r10 = null;
        goto L90
    L23:
        ResultKt.throwOnFailure(r18);
        r152 = (Function0) ZeusTransformUtils.preCheckCast(new AIInferRuntime$prepareSubProcessPackageInfo$throwGetPackageFailure$1(r13), Function0.class, "com.obric.memorydata.plugin");
        r150 = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AIInferRuntime$prepareSubProcessPackageInfo$initParams$2(this, r16, r13, r14), Function0.class, "com.obric.memorydata.plugin"));
        if (r14 == false) goto L52;
        r154 = (com.obric.aikernel.runtime.subproc.b.c) ZeusTransformUtils.preCheckCast(this.f6161b.m().f().get(r12), com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        if (r154 != null) goto L39;
        d.c r158 = this.f6161b.i();
        if (r158 != null) goto L30;
    L32:
        boolean r159 = false;
    L33:
        if (r159 == false) goto L40;
        r1.L$0 = this;
        r1.L$1 = r12;
        r1.L$2 = r152;
        r1.L$3 = r150;
        r1.label = 1;
        r151 = e(r12, r1);
        if (r151 != r3) goto L37;
        return r3;
    L40:
        r153 = ZeusTransformUtils.preCheckCast(null, com.obric.aikernel.runtime.subproc.b.c.class, "com.obric.memorydata.plugin");
        goto L38
    L30:
        if (r158.a(r12) != true) goto L32;
        r159 = true;
        goto L33
    L52:
        r1.L$0 = this;
        r1.L$1 = r12;
        r1.L$2 = r152;
        r1.L$3 = r150;
        r1.label = 3;
        Object r160 = e(r12, r1);
        if (r160 != r3) goto L55;
        return r3;
    L55:
        r120 = r150;
        r137 = r12;
        r18 = r160;
        r134 = r152;
        goto L56
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r1 = new AIInferRuntime$prepareSubProcessPackageInfo$1(this, r17);
        goto L8
    }

    private final String a(UpdateResult r2) {
        if (r2 == null) goto L5;
        String r1 = "stage=" + r2.getStage() + ",finished=" + r2.getFinished() + ",success=" + r2.getSuccess() + ",msg=" + r2.getMsg();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return "none";
    }

    public static final /* synthetic */ String a(AIInferRuntime r0, PackageResource r1) {
        return r0.a(r1);
    }

    private final String a(PackageResource r2) {
        int r1 = r2.getSelfFlag();
        if ((r1 & 2) != 2) goto L6;
        return "available";
    L6:
        if ((r1 & 4) != 4) goto L9;
        return "downloaded";
    L9:
        if ((r1 & 1) != 1) goto L11;
        return "provisioned";
    L11:
        return "not_found";
    }

    private final String a(String r12, PackageResource r13, UpdateResult r14) {
        if (r13 != null) goto L7;
        StringBuilder r11 = new StringBuilder().append("missing_lora_resource:").append(r12);
    L5:
        return r11.toString();
    L7:
        if (r13.isDownloaded() == true) goto L21;
        List<PackageResource> r15 = r13.getSubRes();
        if (r15 == null) goto L19;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L16;
        Object r2 = r17.next();
        if (((PackageResource) ZeusTransformUtils.preCheckCast(r2, PackageResource.class, "com.obric.memorydata.plugin")).isDownloaded() == true) goto L12;
        r0.add(r2);
        goto L12
    L16:
        String r18 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$describeLoraDownloadReasonForLog$missingChildren$2(this), Function1.class, "com.obric.memorydata.plugin"), 25, null);
        if (r18 == null) goto L19;
    L20:
        r11 = new StringBuilder().append("loraSelf=").append(a(r13)).append(" missingDownloadedSubRes=").append(r18).append(" updateInfo=").append(a(r14));
    L19:
        r18 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        goto L20
    L21:
        if (r14 != null) goto L30;
        return "downloaded";
    L30:
        return "downloaded_with_update_info(" + a(r14) + ')';
    }

    private final String a(Map<String, UpdateResult> r13) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12.values(), Iterable.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L5;
    L7:
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L15;
        if (((UpdateResult) ZeusTransformUtils.preCheckCast(r15.next(), UpdateResult.class, "com.obric.memorydata.plugin")).getSuccess() == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r12.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L17:
        if (r17.hasNext() == false) goto L22;
        Object r3 = r17.next();
        if (((UpdateResult) ZeusTransformUtils.preCheckCast(r3, UpdateResult.class, "com.obric.memorydata.plugin")).getSuccess() == true) goto L17;
        r1.add(r3);
        goto L17
    L22:
        return "resultCount=" + r12.size() + " success=" + r2 + " failed=" + (r12.size() - r2) + " failureSummary=[" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 5, null, (Function1) ZeusTransformUtils.preCheckCast(AIInferRuntime$summarizeUpdateResults$failureSummary$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 23, null) + ']';
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final Set<String> a(com.obric.aikernel.res.metadata.data.f r7) {
        Set<String> r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r6.add("lora@" + r7.s() + '@' + r7.t());
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.q(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        com.obric.aikernel.res.metadata.data.a r3 = (com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin");
        r0.add(r3.getType() + '@' + r3.s() + '@' + r3.t());
        goto L4
    L6:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return r6;
    }

    public static final /* synthetic */ Set a(AIInferRuntime r0, com.obric.aikernel.res.metadata.data.f r1) {
        return r0.a(r1);
    }

    private static final Pair<ar<g>, ar<RequestParams>> a(Lazy<? extends Pair<? extends ar<g>, ? extends ar<RequestParams>>> r2) {
        return (Pair) ZeusTransformUtils.preCheckCast(((Lazy) ZeusTransformUtils.wrapperContextForParams(r2, Lazy.class, "com.obric.memorydata.plugin")).getValue(), Pair.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ar a(AIInferRuntime r0) {
        return r0.r;
    }

    public static final /* synthetic */ void a(AIInferRuntime r0, long r1) {
        r0.t = r1;
    }

    public static /* synthetic */ void a(AIInferRuntime r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(AIInferRuntime r2, bx r3) {
        r2.o = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    private final void a(PrintWriter r6) {
        StringBuilder r0 = new StringBuilder("all pkgs:");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.j.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r5.next(), g.class, "com.obric.memorydata.plugin");
        r0.append('[' + r1.b().getName() + '@' + r1.b().getVersion() + ' ' + r1.b());
        goto L4
    L6:
        r6.println(r0.toString());
    }

    public static final /* synthetic */ PackageResourceManager b(AIInferRuntime r0) {
        return r0.h;
    }

    private final g b(com.obric.aikernel.res.metadata.data.b r19) {
        PackageResource r3 = a(r19);
        if (r19.d() == false) goto L20;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r19.p(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L15;
        Object r8 = r2.next();
        com.obric.aikernel.res.metadata.data.d r9 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r8, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aikernel.res.metadata.data.i.class) == true) goto L10;
    L12:
        boolean r10 = false;
    L13:
        if (r10 == false) goto L6;
        r7.add(r8);
        goto L6
    L10:
        if (((com.obric.aikernel.res.metadata.data.i) ZeusTransformUtils.preCheckCast(r9, com.obric.aikernel.res.metadata.data.i.class, "com.obric.memorydata.plugin")).g() == false) goto L12;
        r10 = true;
        goto L13
    L15:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r4.hasNext() == false) goto L19;
        com.obric.aikernel.res.metadata.data.d r6 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        NativeLibVersionPolicy.INSTANCE.recordVersion(r6.s(), r6.t());
        goto L17
    L19:
        Function1 r5 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$transferPackage$vmInfo$3(this, r19, null), Function1.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "transferPackage avail " + r19.s() + ':' + r19.t());
        Function1 r11 = r5;
        boolean r15 = true;
    L21:
        g r12 = new g(r19, r3, null, r11, this.c, this.l, null, this.e, 68, null);
        if (r15 == false) goto L26;
        g r13 = (g) ZeusTransformUtils.preCheckCast(this.j.get(r19.s()), g.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r19.s(), this.f6161b.g().getPreInitPackageName()) == true) goto L26;
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$transferPackage$1$1(r13, r19, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L26:
        this.j.put(r19.s(), r12);
        return r12;
    L20:
        com.obric.aikernel.runtime.utils.d r14 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r16 = new StringBuilder().append("transferPackage not avail ").append(r19.s()).append(':').append(r19.t()).append(". Self state is ");
        String r17 = Integer.toString(r3.getSelfFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r17, "toString(this, checkRadix(radix))");
        r14.f("AIInferRuntime", r16.append(r17).append('!').toString());
        r11 = (Function1) ZeusTransformUtils.preCheckCast(null, Function1.class, "com.obric.memorydata.plugin");
        r15 = false;
        goto L21
    }

    private final g b(String r8, String r9, String r10) {
        if (this.f6161b.m().b() == false) goto L5;
        g r1 = null;
        if (Intrinsics.areEqual(r10, "unload") == true) goto L37;
        g r0 = (g) ZeusTransformUtils.preCheckCast(this.k.get(r9), g.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (r0 != null) goto L11;
    L35:
        r2 = false;
    L36:
        if (r2 == true) goto L37;
    L48:
        g r11 = (g) ZeusTransformUtils.preCheckCast(this.k.get(r9), g.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L67;
        Map<String, g> r12 = this.k;
        monitor-enter(r12);
        g r3 = (g) ZeusTransformUtils.preCheckCast(this.k.get(r9), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        if (r3 != null) goto L62;
        AIInferRuntime r7 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(this, AIInferRuntime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        if (r7.h == null) goto L61;
        Pair<com.obric.aikernel.res.metadata.data.f, com.obric.aikernel.res.metadata.data.b> r13 = com.obric.aikernel.res.metadata.data.f.f6090a.a(r8, r9, r7.h.getContext());     // Catch: Throwable -> L64
        if (r13 == null) goto L59;
        r1 = r7.a((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r13.getSecond(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin"), (com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r13.getFirst(), com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L64
    L59:
        r3 = r1;
        goto L62
    L61:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L64
    L62:
        monitor-exit(r12);
        return r3;
    L64:
        th = move-exception;
        throw th;
    L67:
        return r11;
    L11:
        if (r0.e() == true) goto L32;
        com.obric.aikernel.res.metadata.data.f r4 = r0.c();
        if (r4 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L32;
        com.obric.aikernel.res.metadata.data.b r6 = com.obric.aikernel.res.metadata.c.f6058a.b();
        if (r6 != null) goto L23;
    L21:
        boolean r14 = false;
    L29:
        if (r14 == true) goto L32;
        boolean r15 = false;
    L33:
        if (r15 != true) goto L35;
    L23:
        if (Intrinsics.areEqual(r0.a().t(), r6.t()) == true) goto L25;
    L28:
        r14 = true;
        goto L29
    L25:
        if (Intrinsics.areEqual(r0.a().t(), "debug") == false) goto L21;
        if (Intrinsics.areEqual(r0.a().g(), r6.g()) == true) goto L21;
    L15:
        if (r4.d() != true) goto L17;
        r5 = true;
    L32:
        r15 = true;
    L37:
        g r16 = (g) ZeusTransformUtils.preCheckCast(this.k.remove(r9), g.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L48;
        com.obric.aikernel.runtime.utils.d r17 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r18 = new StringBuilder().append("getLoraPackageInfo remove ").append(r16.a()).append('-').append(r16.c()).append(" by event:").append(r10).append(" isAvailable:");
        com.obric.aikernel.res.metadata.data.f r19 = r16.c();
        if (r19 == null) goto L42;
        Boolean r20 = Boolean.valueOf(r19.d());
    L43:
        StringBuilder r110 = r18.append(r20).append(" VlmLocalVersion:");
        com.obric.aikernel.res.metadata.data.b r21 = com.obric.aikernel.res.metadata.c.f6058a.b();
        if (r21 == null) goto L46;
        String r22 = r21.t() + " debug:" + r21.g();
    L47:
        r17.e("AIInferRuntime", r110.append(r22).toString());
        goto L48
    L46:
        r22 = null;
        goto L47
    L42:
        r20 = null;
        goto L43
    L5:
        return (g) ZeusTransformUtils.preCheckCast(this.k.get(r9), g.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Object b(AIInferRuntime r2, String r3, String r4, Continuation r5) {
        return r2.c(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object b(AIInferRuntime r2, Continuation r3) {
        return r2.d((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(String r7, String r8, String r9, Continuation<? super g> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, AIInferRuntime$getVmPackageWrapper$1.class) == false) goto L7;
        AIInferRuntime$getVmPackageWrapper$1 r1 = (AIInferRuntime$getVmPackageWrapper$1) ZeusTransformUtils.preCheckCast(r11, AIInferRuntime$getVmPackageWrapper$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        AIInferRuntime r6 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$3, AIInferRuntime.class, "com.obric.memorydata.plugin");
        r9 = (String) ZeusTransformUtils.preCheckCast(r1.L$2, String.class, "com.obric.memorydata.plugin");
        r8 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r1.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L22:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
        g r13 = r6.a(r7, r8, r9);
    L26:
        return r13;
    L24:
        r13 = (g) ZeusTransformUtils.preCheckCast(null, g.class, "com.obric.memorydata.plugin");
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        g r14 = a(r7, r8, r9);
        if (r14 != null) goto L27;
        r6 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(this, AIInferRuntime.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.subproc.a.c r15 = r6.f6161b.m().e();
        if (r15 == null) goto L24;
        r1.L$0 = r7;
        r1.L$1 = r8;
        r1.L$2 = r9;
        r1.L$3 = r6;
        r1.label = 1;
        r12 = r15.a(r7, r8, r1);
        if (r12 != r3) goto L22;
        return r3;
    L27:
        return r14;
    L7:
        r1 = new AIInferRuntime$getVmPackageWrapper$1(this, r11);
        goto L8
    }

    private final Object b(String r19, String r20, Continuation<? super JsonObject> r21) {
        AIInferRuntime r0 = this;
        String r1 = r19;
        String r2 = r20;
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AIInferRuntime$buildDownloadStatus$1.class) == false) goto L7;
        AIInferRuntime$buildDownloadStatus$1 r6 = (AIInferRuntime$buildDownloadStatus$1) ZeusTransformUtils.preCheckCast(r4, AIInferRuntime$buildDownloadStatus$1.class, "com.obric.memorydata.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r6.label;
        String r13 = null;
        if (r8 == 0) goto L25;
        if (r8 == 1) goto L24;
        if (r8 == 2) goto L23;
        if (r8 == 3) goto L23;
        if (r8 == 4) goto L22;
        if (r8 != 5) goto L21;
        UpdateResult r3 = (UpdateResult) ZeusTransformUtils.preCheckCast(r6.L$5, UpdateResult.class, "com.obric.memorydata.plugin");
        PackageResource r9 = (PackageResource) ZeusTransformUtils.preCheckCast(r6.L$4, PackageResource.class, "com.obric.memorydata.plugin");
        JsonObject r10 = (JsonObject) ZeusTransformUtils.preCheckCast(r6.L$3, JsonObject.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.L$2, String.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r6.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r14 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r6.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L18
    L79:
        Object r15 = Result.m1421constructorimpl(Boxing.boxFloat(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).floatValue()));     // Catch: Throwable -> L18
    L84:
        Float r16 = Boxing.boxFloat(-1.0f);
        if (Result.m1427isFailureimpl(r15) == false) goto L87;
        r15 = r16;
    L87:
        float r17 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (r9 != null) goto L90;
    L92:
        boolean r18 = false;
    L93:
        r10.addProperty("available", Boxing.boxBoolean(r18));
        if (r9 != null) goto L96;
    L98:
        boolean r22 = false;
    L99:
        r10.addProperty("downloaded", Boxing.boxBoolean(r22));
        if (r9 != null) goto L102;
    L104:
        boolean r23 = false;
    L105:
        r10.addProperty("provisioned", Boxing.boxBoolean(r23));
        if (r9 == null) goto L108;
        String r24 = r9.getVersion();
    L109:
        String r25 = "";
        if (r24 != null) goto L112;
        r24 = "";
    L112:
        r10.addProperty("version", r24);
        r10.addProperty("progress", (Number) ZeusTransformUtils.preCheckCast(Boxing.boxFloat(r17), Number.class, "com.obric.memorydata.plugin"));
        if (r3 != null) goto L115;
    L118:
        boolean r26 = true;
    L119:
        r10.addProperty("updateFinished", Boxing.boxBoolean(r26));
        if (r3 != null) goto L122;
    L124:
        boolean r27 = false;
    L125:
        r10.addProperty("updateSuccess", Boxing.boxBoolean(r27));
        if (r3 == null) goto L128;
        int r28 = r3.getStage();
    L129:
        r10.addProperty("updateStage", (Number) ZeusTransformUtils.preCheckCast(Boxing.boxInt(r28), Number.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L132;
        String r29 = r3.getMsg();
    L133:
        if (r29 != null) goto L135;
        r29 = "";
    L135:
        r10.addProperty("updateMessage", r29);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L138;
        boolean r30 = true;
    L139:
        if (r30 == false) goto L180;
        if (r9 == null) goto L154;
        List<PackageResource> r31 = r9.getSubRes();
        if (r31 == null) goto L154;
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast(r31, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L145:
        if (r32.hasNext() == false) goto L152;
        Object r33 = r32.next();
        if (((PackageResource) ZeusTransformUtils.preCheckCast(r33, PackageResource.class, "com.obric.memorydata.plugin")).getType() != 3) goto L149;
        boolean r110 = true;
    L150:
        if (r110 == false) goto L145;
    L153:
        PackageResource r34 = (PackageResource) ZeusTransformUtils.preCheckCast(r33, PackageResource.class, "com.obric.memorydata.plugin");
    L155:
        com.obric.aikernel.runtime.utils.d r35 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r36 = new StringBuilder().append("buildDownloadStatus lora pkg=").append(r12).append(" loraType=").append(r11).append(" downloaded=");
        if (r9 != null) goto L158;
    L160:
        boolean r37 = false;
    L161:
        StringBuilder r38 = r36.append(r37).append(" available=");
        if (r9 != null) goto L164;
    L166:
        boolean r39 = false;
    L167:
        StringBuilder r40 = r38.append(r39).append(" provisioned=");
        if (r9 != null) goto L170;
    L172:
        boolean r111 = false;
    L173:
        StringBuilder r41 = r40.append(r111).append(" version=");
        if (r9 == null) goto L176;
        r13 = r9.getVersion();
    L176:
        if (r13 == null) goto L179;
        r25 = r13;
    L179:
        r35.a("AIInferRuntime", r41.append(r25).append(" updateInfo=").append(r14.a(r3)).append(" reason=").append(r14.a(r11, r34, r3)).toString());
        goto L180
    L170:
        if (r9.isProvisioned() != true) goto L172;
        r111 = true;
        goto L173
    L164:
        if (r9.isAvailable() != true) goto L166;
        r39 = true;
        goto L167
    L158:
        if (r9.isDownloaded() != true) goto L160;
        r37 = true;
        goto L161
    L149:
        r110 = false;
        goto L150
    L152:
        r33 = null;
    L154:
        r34 = null;
    L180:
        return r10;
    L138:
        r30 = false;
        goto L139
    L132:
        r29 = null;
        goto L133
    L128:
        r28 = 0;
        goto L129
    L122:
        if (r3.getSuccess() == false) goto L124;
        r27 = true;
        goto L125
    L115:
        if (r3.getFinished() == true) goto L118;
        r26 = false;
        goto L119
    L108:
        r24 = null;
        goto L109
    L102:
        if (r9.isProvisioned() != true) goto L104;
        r23 = true;
        goto L105
    L96:
        if (r9.isDownloaded() != true) goto L98;
        r22 = true;
        goto L99
    L90:
        if (r9.isAvailable() != true) goto L92;
        r18 = true;
    L18:
        th = th;
    L83:
        Result.Companion r42 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L84
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        String r43 = (String) ZeusTransformUtils.preCheckCast(r6.L$5, String.class, "com.obric.memorydata.plugin");
        PackageResource r44 = (PackageResource) ZeusTransformUtils.preCheckCast(r6.L$4, PackageResource.class, "com.obric.memorydata.plugin");
        JsonObject r45 = (JsonObject) ZeusTransformUtils.preCheckCast(r6.L$3, JsonObject.class, "com.obric.memorydata.plugin");
        String r46 = (String) ZeusTransformUtils.preCheckCast(r6.L$2, String.class, "com.obric.memorydata.plugin");
        String r112 = (String) ZeusTransformUtils.preCheckCast(r6.L$1, String.class, "com.obric.memorydata.plugin");
        r14 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r6.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L73:
        String r47 = r46;
        JsonObject r48 = r45;
        r9 = r44;
        r3 = (UpdateResult) ZeusTransformUtils.preCheckCast(r5, UpdateResult.class, "com.obric.memorydata.plugin");
        String r49 = r43;
    L181:
        Result.Companion r50 = Result.Companion;     // Catch: Throwable -> L81
        r6.L$0 = r14;     // Catch: Throwable -> L81
        r6.L$1 = r112;     // Catch: Throwable -> L81
        r6.L$2 = r47;     // Catch: Throwable -> L81
        r6.L$3 = r48;     // Catch: Throwable -> L81
        r6.L$4 = r9;     // Catch: Throwable -> L81
        r6.L$5 = r3;     // Catch: Throwable -> L81
        r6.label = 5;     // Catch: Throwable -> L81
        r5 = r14.c(r49, r6);     // Catch: Throwable -> L81
        if (r5 != r7) goto L78;
        return r7;
    L78:
        r10 = r48;
        r11 = r47;
        r12 = r112;
    L81:
        th = th;
        r10 = r48;
        r11 = r47;
        r12 = r112;
    L23:
        JsonObject r51 = (JsonObject) ZeusTransformUtils.preCheckCast(r6.L$3, JsonObject.class, "com.obric.memorydata.plugin");
        String r52 = (String) ZeusTransformUtils.preCheckCast(r6.L$2, String.class, "com.obric.memorydata.plugin");
        String r53 = (String) ZeusTransformUtils.preCheckCast(r6.L$1, String.class, "com.obric.memorydata.plugin");
        r14 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r6.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L57:
        r46 = r52;
        r44 = (PackageResource) ZeusTransformUtils.preCheckCast(r5, PackageResource.class, "com.obric.memorydata.plugin");
        String r113 = r53;
        r45 = r51;
        CharSequence r54 = (CharSequence) ZeusTransformUtils.preCheckCast(r46, CharSequence.class, "com.obric.memorydata.plugin");
        if (r54.length() != 0) goto L64;
        boolean r55 = true;
    L65:
        if (r55 == false) goto L67;
        r54 = r113;
    L67:
        r49 = (String) ZeusTransformUtils.preCheckCast(r54, String.class, "com.obric.memorydata.plugin");
        PackageResourceManager r56 = r14.h;
        if (r56 == null) goto L74;
        r6.L$0 = r14;
        r6.L$1 = r113;
        r6.L$2 = r46;
        r6.L$3 = r45;
        r6.L$4 = r44;
        r6.L$5 = r49;
        r6.label = 4;
        Object r57 = r56.getPackageUpdateInfo(r49, r6);
        if (r57 != r7) goto L72;
        return r7;
    L72:
        r112 = r113;
        r43 = r49;
        r5 = r57;
        goto L73
    L74:
        r112 = r113;
        r47 = r46;
        r48 = r45;
        r9 = r44;
        r3 = null;
        goto L181
    L64:
        r55 = false;
        goto L65
    L24:
        JsonObject r58 = (JsonObject) ZeusTransformUtils.preCheckCast(r6.L$5, JsonObject.class, "com.obric.memorydata.plugin");
        String r59 = (String) ZeusTransformUtils.preCheckCast(r6.L$4, String.class, "com.obric.memorydata.plugin");
        JsonObject r60 = (JsonObject) ZeusTransformUtils.preCheckCast(r6.L$3, JsonObject.class, "com.obric.memorydata.plugin");
        String r61 = (String) ZeusTransformUtils.preCheckCast(r6.L$2, String.class, "com.obric.memorydata.plugin");
        String r62 = (String) ZeusTransformUtils.preCheckCast(r6.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r63 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r6.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        JsonObject r64 = r58;
        r0 = r63;
        JsonObject r65 = r60;
        r2 = r61;
        String r66 = r59;
        r1 = r62;
        Object r67 = r5;
    L41:
        r64.add(r66, (JsonElement) ZeusTransformUtils.preCheckCast(r67, JsonElement.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L44;
        boolean r68 = true;
    L45:
        if (r68 == false) goto L48;
        return r65;
    L48:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L50;
        boolean r69 = true;
    L51:
        r6.L$0 = r0;
        r6.L$1 = r1;
        r6.L$2 = r2;
        r6.L$3 = r65;
        r6.L$4 = null;
        r6.L$5 = null;
        if (r69 == false) goto L58;
        r6.label = 2;
        r5 = r0.a(r1, r2, r6);
        if (r5 != r7) goto L56;
        return r7;
    L56:
        JsonObject r114 = r65;
        r14 = r0;
        r51 = r114;
        String r115 = r2;
        r53 = r1;
        r52 = r115;
        goto L57
    L58:
        r6.label = 3;
        r5 = r0.a(r1, r6);
        if (r5 != r7) goto L56;
        return r7;
    L50:
        r69 = false;
        goto L51
    L44:
        r68 = false;
        goto L45
    L25:
        ResultKt.throwOnFailure(r5);
        CharSequence r70 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r70.length() != 0) goto L28;
        boolean r71 = true;
    L29:
        if (r71 == false) goto L31;
        r70 = "*";
    L31:
        String r72 = (String) ZeusTransformUtils.preCheckCast(r70, String.class, "com.obric.memorydata.plugin");
        CharSequence r73 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r73.length() != 0) goto L34;
        boolean r74 = true;
    L35:
        if (r74 == false) goto L37;
        r73 = "-";
    L37:
        String r75 = (String) ZeusTransformUtils.preCheckCast(r73, String.class, "com.obric.memorydata.plugin");
        r64 = new JsonObject();
        r64.addProperty("pkgName", r72);
        r64.addProperty(Params.LORA_TYPE, r75);
        r6.L$0 = r0;
        r6.L$1 = r1;
        r6.L$2 = r2;
        r6.L$3 = r64;
        r6.L$4 = "downloadingSummary";
        r6.L$5 = r64;
        r6.label = 1;
        Object r76 = r0.b(r6);
        if (r76 != r7) goto L40;
        return r7;
    L40:
        r67 = r76;
        r66 = "downloadingSummary";
        r65 = r64;
        goto L41
    L34:
        r74 = false;
        goto L35
    L28:
        r71 = false;
    L7:
        r6 = new AIInferRuntime$buildDownloadStatus$1(r0, r4);
        goto L8
    }

    private final String b(String r1) {
        if (Intrinsics.areEqual(r1, "bridge") == false) goto L6;
        return "Bridge";
    L6:
        return r1;
    }

    public static final /* synthetic */ void b(AIInferRuntime r0, com.obric.aikernel.res.metadata.data.b r1) {
        r0.c(r1);
    }

    private final Object c(String r12, String r13, Continuation<? super g> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AIInferRuntime$getSubProcPackageInfo$1.class) == false) goto L7;
        AIInferRuntime$getSubProcPackageInfo$1 r0 = (AIInferRuntime$getSubProcPackageInfo$1) ZeusTransformUtils.preCheckCast(r15, AIInferRuntime$getSubProcPackageInfo$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        g r11 = (g) ZeusTransformUtils.preCheckCast(r0.L$0, g.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIInferRuntime this = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r0.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
    L19:
        g r17 = (g) ZeusTransformUtils.preCheckCast(r16, g.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L25;
        r0.L$0 = r17;
        r0.label = 2;
        if (this.a(r17, r0) != r9) goto L28;
        return r9;
    L28:
        return r17;
    L25:
        return null;
    L16:
        ResultKt.throwOnFailure(r16);
        r0.L$0 = this;
        r0.label = 1;
        r16 = a(this, r12, r13, null, r0, 4, null);
        if (r16 != r9) goto L19;
        return r9;
    L7:
        r0 = new AIInferRuntime$getSubProcPackageInfo$1(this, r15);
        goto L8
    }

    private final Object c(Continuation<? super Boolean> r23) {
        AIInferRuntime r0 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AIInferRuntime$preInitApp$1.class) == false) goto L7;
        AIInferRuntime$preInitApp$1 r3 = (AIInferRuntime$preInitApp$1) ZeusTransformUtils.preCheckCast(r2, AIInferRuntime$preInitApp$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        AIInferRuntime$preInitApp$1 r8 = r3;
        Object r4 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        boolean r10 = false;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r4);
    L51:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L54;
        r10 = true;
    L54:
        return Boxing.boxBoolean(r10);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        g r1 = (g) ZeusTransformUtils.preCheckCast(r8.L$1, g.class, "com.obric.memorydata.plugin");
        AIInferRuntime r6 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r8.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
    L32:
        com.obric.aee.res.b r7 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r4, Pair.class, "com.obric.memorydata.plugin")).getSecond(), com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L44;
        monitor-enter(r6);
    L41:
        th = move-exception;
        throw th;
    L36:
        if (r6.s != null) goto L38;
        r6.s = kotlinx.coroutines.i.b(r6.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$preInitApp$3$1$1$1(r7, r6, r1, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L41
    L38:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r6);
    L44:
        r0 = r6;
    L45:
        ar<Boolean> r12 = r0.s;
        if (r12 == null) goto L54;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 3;
        r4 = r12.a(r8);
        if (r4 != r9) goto L51;
        return r9;
    L17:
        r0 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r8.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
    L26:
        g r13 = (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L45;
        r8.L$0 = r0;
        r8.L$1 = r13;
        r8.label = 2;
        r4 = r13.a(r8);
        if (r4 != r9) goto L31;
        return r9;
    L31:
        r6 = r0;
        r1 = r13;
        goto L32
    L18:
        ResultKt.throwOnFailure(r4);
        if (r0.s != null) goto L45;
        String r14 = r0.f6161b.g().getPreInitPackageName();
        if (r14 != null) goto L23;
        r0.s = kotlinx.coroutines.i.b(r0.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$preInitApp$2(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L45
    L23:
        r8.L$0 = r0;
        r8.label = 1;
        r4 = a(this, r14, null, null, r8, 6, null);
        if (r4 != r9) goto L26;
        return r9;
    L7:
        r3 = new AIInferRuntime$preInitApp$1(r0, r2);
        goto L8
    }

    public static final /* synthetic */ Set c() {
        return u;
    }

    public static final /* synthetic */ ConcurrentHashMap c(AIInferRuntime r0) {
        return r0.n;
    }

    private final synchronized void c(com.obric.aikernel.res.metadata.data.b r4) {
        monitor-enter(this);
        String r0 = this.f6161b.g().getPreInitPackageName();     // Catch: Throwable -> L23
        if (r0 != null) goto L6;
    L11:
        g r1 = (g) ZeusTransformUtils.preCheckCast(this.j.get(r4.s()), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r1 != null) goto L14;
    L21:
        monitor-exit(this);
        return;
    L14:
        if (Intrinsics.areEqual(r1.b().getVersion(), r4.t()) == false) goto L21;
        if (com.obric.aikernel.res.metadata.c.f6058a.b(r4) == false) goto L20;
        e(r4);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L20:
        this.j.remove(r4.s());     // Catch: Throwable -> L23
        goto L21
    L6:
        if (Intrinsics.areEqual(r4.s(), r0) == false) goto L11;
        if (this.j.get(r0) == null) goto L11;
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void c(AIInferRuntime r0, com.obric.aikernel.res.metadata.data.b r1) {
        r0.d(r1);
    }

    private final void c(String r8) {
        ConcurrentHashMap<String, h> r0 = this.n;
        final Function1 r1 = (Function1) ZeusTransformUtils.preCheckCast(AIInferRuntime$schedulePreparePackage$state$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        h r2 = r0.computeIfAbsent(r8, new $$Lambda$AIInferRuntime$qOIfMSgKWHGlbnhNYSMz05N7vvk(r1));
        Intrinsics.checkNotNullExpressionValue(r2, "prepareScheduleState.com… PrepareScheduleState() }");
        h r3 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.memorydata.plugin");
        monitor-enter(r3);
        boolean r4 = true;
        if (r3.a() == false) goto L7;
        r3.b(true);     // Catch: Throwable -> L14
        r4 = false;
    L8:
        monitor-exit(r3);
        if (r4 == true) goto L12;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "schedulePreparePackage merge pending " + r8);
        return;
    L12:
        kotlinx.coroutines.i.a(this.c, this.m.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak("preparePackage-" + r8), CoroutineContext.class, "com.obric.memorydata.plugin")), null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$schedulePreparePackage$1(r3, r8, this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    L7:
        r3.a(true);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private final Object d(Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AIInferRuntime$waitLocalInit$1.class) == false) goto L7;
        AIInferRuntime$waitLocalInit$1 r0 = (AIInferRuntime$waitLocalInit$1) ZeusTransformUtils.preCheckCast(r8, AIInferRuntime$waitLocalInit$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIInferRuntime this = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r0.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L21:
        PackageResourceManager r6 = this.h;
        if (r6 == null) goto L29;
        r0.L$0 = null;
        r0.label = 2;
        if (r6.waitLocalPackageInit(r0) != r2) goto L27;
        return r2;
    L29:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r9);
        b r10 = this.f6161b.d();
        if (r10 == null) goto L21;
        r0.L$0 = this;
        r0.label = 1;
        if (r10.a(r0) != r2) goto L21;
        return r2;
    L7:
        r0 = new AIInferRuntime$waitLocalInit$1(this, r8);
        goto L8
    }

    public static final /* synthetic */ Map d(AIInferRuntime r0) {
        return r0.k;
    }

    public static final /* synthetic */ Set d(AIInferRuntime r0, com.obric.aikernel.res.metadata.data.b r1) {
        return r0.f(r1);
    }

    private final synchronized void d(com.obric.aikernel.res.metadata.data.b r8) {
        monitor-enter(this);
        String r0 = this.f6161b.g().getPreInitPackageName();     // Catch: Throwable -> L80
        if (r0 != null) goto L6;
    L14:
        g r1 = (g) ZeusTransformUtils.preCheckCast(this.j.get(r8.s()), g.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L80
        boolean r2 = false;
        if (r1 == null) goto L21;
        com.obric.aikernel.res.metadata.data.b r3 = r1.a();     // Catch: Throwable -> L80
        if (r3 == null) goto L21;
        if (r3.d() != true) goto L21;
        r2 = true;
    L21:
        Unit r4 = null;
        if (r1 != null) goto L25;
    L59:
        if (r8 != null) goto L61;
    L75:
        AIInferRuntime r5 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(this, AIInferRuntime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L80
        if (r8 == null) goto L78;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "addPackage ignore " + r8 + " subResource: " + r8.p().size());     // Catch: Throwable -> L80
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L80
    L78:
        monitor-exit(this);
        return;
    L61:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8.p(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L63;
        com.obric.aikernel.res.metadata.data.b r6 = r8;
    L64:
        if (r6 == null) goto L75;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "addPackage start transferPkg:" + r8);     // Catch: Throwable -> L80
        if (com.obric.aikernel.res.metadata.c.f6058a.a(r6.s()) == true) goto L68;
    L73:
        b(r6);     // Catch: Throwable -> L80
        c(r6.s());     // Catch: Throwable -> L80
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L80
    L74:
        if (r4 != null) goto L78;
    L68:
        if (com.obric.aikernel.res.metadata.c.f6058a.b(r6) == false) goto L71;
        e(r6);     // Catch: Throwable -> L80
        goto L74
    L71:
        if (com.obric.aikernel.res.metadata.c.f6058a.a() == true) goto L73;
    L63:
        r6 = null;
        goto L64
    L25:
        if (r2 == r1.b().isAvailable()) goto L35;
        if (r2 == true) goto L28;
    L34:
        com.obric.aikernel.res.metadata.data.b r7 = r1.a();     // Catch: Throwable -> L80
    L36:
        boolean r10 = r8.d();     // Catch: Throwable -> L80
        if (r2 == false) goto L54;
        if (r10 == true) goto L40;
    L58:
        r8 = r7;
        goto L59
    L40:
        if (com.obric.aikernel.res.metadata.data.b.e.a(r8.t()) > com.obric.aikernel.res.metadata.data.b.e.a(r1.a().t())) goto L59;
        if (Intrinsics.areEqual(r8.t(), "debug") == false) goto L50;
        if (Intrinsics.areEqual(r1.a().t(), "debug") == false) goto L59;
        if (Intrinsics.areEqual(r1.a().g(), r8.g()) == true) goto L58;
    L50:
        if (Intrinsics.areEqual(r8.s(), "vlm_local") == false) goto L58;
        if (com.obric.aikernel.res.metadata.c.f6058a.b(r8) == false) goto L58;
    L54:
        if (r10 == true) goto L59;
        if (com.obric.aikernel.res.metadata.data.b.e.a(r8.t()) <= com.obric.aikernel.res.metadata.data.b.e.a(r1.a().t())) goto L58;
    L28:
        if (Intrinsics.areEqual(r8.t(), r1.a().t()) == false) goto L33;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8.p(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L33;
        r7 = r8;
    L33:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1.a().p(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L34;
    L35:
        r7 = null;
        goto L36
    L6:
        if (Intrinsics.areEqual(r8.s(), r0) == false) goto L14;
        if (this.j.get(r8.s()) == null) goto L10;
    L12:
        monitor-exit(this);
        return;
    L10:
        if (r8.d() == false) goto L12;
        b(r8);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        throw th;
    }

    private final void d(String r12) {
        Map<String, d.e> r0 = this.f6161b.m().c();
        if (r0 == null) goto L19;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, d.e>> r2 = r0.entrySet().iterator();
    L5:
        String r4 = null;
        if (r2.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((d.e) ZeusTransformUtils.preCheckCast(r3.getValue(), d.e.class, "com.obric.memorydata.plugin")).a(r12) == false) goto L10;
        r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
    L10:
        if (r4 == null) goto L5;
        r1.add(r4);
        goto L5
    L12:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$scheduleRestartByPackage$2$1(r12, this, r5, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    }

    public static final /* synthetic */ com.obric.aikernel.runtime.e e(AIInferRuntime r0) {
        return r0.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, com.obric.aikernel.runtime.subproc.b$c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.Object] */
    private final Object e(String r20, Continuation<? super com.obric.aikernel.runtime.subproc.b.c> r21) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AIInferRuntime$getSubProcProxy$1.class) == false) goto L7;
        AIInferRuntime$getSubProcProxy$1 r2 = (AIInferRuntime$getSubProcProxy$1) ZeusTransformUtils.preCheckCast(r1, AIInferRuntime$getSubProcProxy$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        AIInferRuntime$getSubProcProxy$1 r8 = r2;
        Object r3 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r8.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(r8.L$0, Pair.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L46:
        return r0.getFirst();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        Map<String, com.obric.aikernel.runtime.subproc.b.c> r11 = this.f6161b.m().f();
        Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = r11.get(r20);
        if (r12.element != 0) goto L51;
        monitor-enter(r11);
        ar r5 = null;
        r5 = null;
        com.obric.aikernel.runtime.subproc.a r6 = null;
        if (r11.get(r20) != null) goto L38;
        d.c r7 = this.f6161b.i();     // Catch: Throwable -> L47
        if (r7 == null) goto L22;
        r7.b(r20);     // Catch: Throwable -> L47
    L22:
        d.c r10 = this.f6161b.i();     // Catch: Throwable -> L47
        if (r10 == null) goto L25;
        Bundle r13 = r10.b(r20);     // Catch: Throwable -> L47
    L26:
        if (r13 == null) goto L28;
        IBinder r14 = r13.getBinder("@sub_proc_host");     // Catch: Throwable -> L47
    L29:
        if (r13 == null) goto L37;
        if (r14 == null) goto L37;
        ?? r15 = new com.obric.aikernel.runtime.subproc.b.c(r20, r14);     // Catch: Throwable -> L47
        r11.put(r20, r15);     // Catch: Throwable -> L47
        r12.element = r15;     // Catch: Throwable -> L47
        com.obric.aikernel.runtime.subproc.a r16 = this.f;     // Catch: Throwable -> L47
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mainHost");     // Catch: Throwable -> L47
    L36:
        r15.a(r6);     // Catch: Throwable -> L47
        r5 = kotlinx.coroutines.i.b(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$getSubProcProxy$result$1$1$2(this, r20, r13, r14, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L47
        goto L37
    L35:
        r6 = r16;
    L37:
        r0 = new Pair(r12.element, r5);     // Catch: Throwable -> L47
    L39:
        monitor-exit(r11);
        ar r17 = (ar) ZeusTransformUtils.preCheckCast(r0.getSecond(), ar.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L46;
        r8.L$0 = r0;
        r8.label = 1;
        if (r17.a(r8) != r9) goto L46;
        return r9;
    L28:
        r14 = null;
        goto L29
    L25:
        r13 = null;
        goto L26
    L38:
        r0 = new Pair(r12.element, null);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L51:
        return r12.element;
    L7:
        r2 = new AIInferRuntime$getSubProcProxy$1(this, r1);
        goto L8
    }

    private final void e(com.obric.aikernel.res.metadata.data.b r1) {
        d(r1.s());
    }

    private final Set<String> f(com.obric.aikernel.res.metadata.data.b r7) {
        Set<String> r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r6.add("package@" + r7.s() + '@' + r7.t());
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7.p(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        com.obric.aikernel.res.metadata.data.d r3 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        r0.add(r3.getType() + '@' + r3.s() + '@' + r3.t());
        goto L4
    L6:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return r6;
    }

    public static final /* synthetic */ bx f(AIInferRuntime r0) {
        return r0.o;
    }

    public static final /* synthetic */ Map g(AIInferRuntime r0) {
        return r0.j;
    }

    public static final /* synthetic */ File h(AIInferRuntime r0) {
        return r0.d;
    }

    public static final /* synthetic */ com.obric.aikernel.model.device.a i(AIInferRuntime r0) {
        return r0.e;
    }

    public static final /* synthetic */ j j(AIInferRuntime r0) {
        return r0.q;
    }

    public static /* synthetic */ h lambda$qOIfMSgKWHGlbnhNYSMz05N7vvk(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public final d a() {
        return this.f6161b;
    }

    public final Object a(JsonObject r5, Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AIInferRuntime$pushDebugDistributeInfo$1.class) == false) goto L7;
        AIInferRuntime$pushDebugDistributeInfo$1 r0 = (AIInferRuntime$pushDebugDistributeInfo$1) ZeusTransformUtils.preCheckCast(r7, AIInferRuntime$pushDebugDistributeInfo$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L25
    L21:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Object r9 = Result.m1421constructorimpl(r4);     // Catch: Throwable -> L25
    L27:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L31;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "pushDebugDistributeInfo error " + ExceptionsKt.stackTraceToString(r10));
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L25
        PackageResourceManager r12 = this.h;     // Catch: Throwable -> L25
        if (r12 == null) goto L22;
        r0.label = 1;     // Catch: Throwable -> L25
        if (r12.pushDebugDistributeInfo(r5, r0) != r1) goto L21;
        return r1;
    L22:
        r4 = null;
    L25:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new AIInferRuntime$pushDebugDistributeInfo$1(this, r7);
        goto L8
    }

    public final Object a(final String r9, RequestParams r10, String r11, com.obric.aikernel.b r12, Continuation<? super Bundle> r13) {
        final com.obric.aikernel.b r14 = (com.obric.aikernel.b) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.aikernel.b.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AIInferRuntime$vmExecute$1.class) == false) goto L7;
        AIInferRuntime$vmExecute$1 r0 = (AIInferRuntime$vmExecute$1) ZeusTransformUtils.preCheckCast(r15, AIInferRuntime$vmExecute$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AIInferRuntime$vmExecute$1 r7 = r0;
        Object r16 = r7.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r7.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Ref.ObjectRef r8 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r7.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
    L19:
        if (r8.element != 0) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("ret");
        return null;
    L22:
        return (Bundle) ZeusTransformUtils.preCheckCast(r8.element, Bundle.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        Function1<? super Bundle, Unit> r6 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$2(this, r9, r17, r14), Function1.class, "com.obric.memorydata.plugin");
        r7.L$0 = r17;
        r7.label = 1;
        if (a(r9, r10, r11, r6, r7) != r1) goto L17;
        return r1;
    L17:
        r8 = r17;
    L7:
        r0 = new AIInferRuntime$vmExecute$1(this, r15);
        goto L8
    }

    public final Object a(String r27, RequestParams r28, String r29, Function1<? super Bundle, Unit> r30, Continuation<? super Unit> r31) {
        AIInferRuntime r0 = this;
        String r1 = r27;
        final RequestParams r2 = r28;
        String r3 = r29;
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r30, Function1.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r31, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AIInferRuntime$vmExecute$3.class) == false) goto L7;
        AIInferRuntime$vmExecute$3 r8 = (AIInferRuntime$vmExecute$3) ZeusTransformUtils.preCheckCast(r7, AIInferRuntime$vmExecute$3.class, "com.obric.memorydata.plugin");
        if ((r8.label & Integer.MIN_VALUE) == 0) goto L7;
        r8.label -= Integer.MIN_VALUE;
    L8:
        AIInferRuntime$vmExecute$3 r15 = r8;
        Object r9 = r15.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r15.label;
        boolean r12 = true;
        if (r11 == 0) goto L26;
        if (r11 != 1) goto L12;
        r5 = (Function1) ZeusTransformUtils.preCheckCast(r15.L$4, Function1.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r15.L$3, String.class, "com.obric.memorydata.plugin");
        RequestParams r6 = (RequestParams) ZeusTransformUtils.preCheckCast(r15.L$2, RequestParams.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r15.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r14 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r15.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        r3 = r4;
        r0 = r14;
        r2 = r6;
        r1 = r13;
    L29:
        c r16 = f6160a;
        Function1 r17 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$6(r0, null), Function1.class, "com.obric.memorydata.plugin");
        Function1<? super Long, Unit> r18 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$7(r2), Function1.class, "com.obric.memorydata.plugin");
        r15.L$0 = r0;
        r15.L$1 = r1;
        r15.L$2 = r2;
        r15.L$3 = r3;
        r15.L$4 = r5;
        r15.label = 2;
        r9 = r16.a(r17, r18, r15);
        if (r9 != r10) goto L32;
        return r10;
    L32:
        AIInferRuntime r19 = r0;
        Function1 r24 = r5;
        String r20 = r1;
        final Function1 r21 = r24;
        String r25 = r3;
        final RequestParams r22 = r2;
        String r23 = r25;
    L34:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L64;
        String r26 = f6160a.a(r22.getBackend());
        r15.L$0 = r19;
        r15.L$1 = r20;
        r15.L$2 = r22;
        r15.L$3 = r23;
        r15.L$4 = r21;
        r15.L$5 = r26;
        r15.label = 3;
        r9 = r19.b(r20, r26, r23, r15);
        if (r9 != r10) goto L38;
        return r10;
    L38:
        g r32 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.memorydata.plugin");
        c r33 = f6160a;
        Function1 r110 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$pkgInfo$1(r32, null), Function1.class, "com.obric.memorydata.plugin");
        Function1<? super Long, Unit> r111 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$pkgInfo$2(r22), Function1.class, "com.obric.memorydata.plugin");
        r15.L$0 = r19;
        r15.L$1 = r20;
        r15.L$2 = r22;
        r15.L$3 = r23;
        r15.L$4 = r21;
        r15.L$5 = r26;
        r15.L$6 = r32;
        r15.label = 4;
        Object r34 = r33.a(r110, r111, r15);
        if (r34 != r10) goto L41;
        return r10;
    L41:
        String r112 = r23;
        String r35 = r20;
        g r113 = r32;
        r9 = r34;
    L42:
        Pair r36 = (Pair) ZeusTransformUtils.preCheckCast(r9, Pair.class, "com.obric.memorydata.plugin");
        if (r36 != null) goto L47;
        Bundle r37 = BundleExtKt.setErr$default(new Bundle(), 109, "package " + r35 + " lora:" + r26 + " not available", false, 4, null);
    L45:
        r21.invoke(r37);
    L76:
        return Unit.INSTANCE;
    L47:
        if (((Number) ZeusTransformUtils.preCheckCast(r36.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue() != 0) goto L62;
        final com.obric.aee.res.b r114 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r36.getSecond(), com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        if (r114 == null) goto L57;
        com.obric.aikernel.runtime.utils.d.f6216a.d("AIInferRuntime", "vmExecute gotPkgInfo " + r35 + ' ' + r26 + " request " + r112 + ' ' + r22.getClientId() + ':' + r22.getTraceIdStr());
        com.obric.aikernel.runtime.e r38 = r19.i;
        if (r38 == null) goto L56;
        Function1<? super Bundle, Unit> r39 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$8$1(r114, r21), Function1.class, "com.obric.memorydata.plugin");
        r15.L$0 = r35;
        r15.L$1 = r21;
        r15.L$2 = r26;
        r15.L$3 = null;
        r15.L$4 = null;
        r15.L$5 = null;
        r15.L$6 = null;
        r15.label = 5;
        RequestParams r115 = r22;
        String r40 = " lora:";
        if (r38.a(r114, r115, r112, r113, r39, r15) != r10) goto L55;
        return r10;
    L55:
        Unit r116 = Unit.INSTANCE;
    L59:
        if (r116 != null) goto L76;
        Object r41 = null;
        Bundle r210 = new Bundle();
        int r211 = 201;
        String r212 = r14 + r35 + r40 + r26 + " may take valid after process restart.";
        boolean r213 = false;
        int r310 = 4;
    L61:
        Object r311 = r41;
    L63:
        r37 = BundleExtKt.setErr$default(r210, r211, r212, r213, r310, r311);
        goto L45
    L56:
        r40 = " lora:";
    L58:
        r116 = null;
        goto L59
    L57:
        r40 = " lora:";
        goto L58
    L62:
        Bundle r42 = new Bundle();
        r210 = r42;
        r211 = ((Number) ZeusTransformUtils.preCheckCast(r36.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
        r212 = "get package " + r35 + " lora:" + r26 + " info failed!";
        r213 = false;
        r310 = 4;
        r311 = null;
        goto L63
    L64:
        ar<Boolean> r43 = r19.s;
        if (r43 != null) goto L67;
    L69:
        r12 = false;
    L70:
        if (r12 == false) goto L72;
    L74:
        r41 = null;
        r210 = new Bundle();
        r211 = 109;
        r212 = "preInitApp not available";
        r213 = false;
        r310 = 4;
        goto L61
    L72:
        if ((SystemClock.elapsedRealtime() - r19.t) <= 5000) goto L74;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "preInitApp: reset init job");
        r19.s = null;
        goto L74
    L67:
        if (r43.a() != true) goto L69;
    L12:
        if (r11 != 2) goto L14;
        Function1 r44 = (Function1) ZeusTransformUtils.preCheckCast(r15.L$4, Function1.class, "com.obric.memorydata.plugin");
        String r45 = (String) ZeusTransformUtils.preCheckCast(r15.L$3, String.class, "com.obric.memorydata.plugin");
        RequestParams r46 = (RequestParams) ZeusTransformUtils.preCheckCast(r15.L$2, RequestParams.class, "com.obric.memorydata.plugin");
        String r47 = (String) ZeusTransformUtils.preCheckCast(r15.L$1, String.class, "com.obric.memorydata.plugin");
        r19 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r15.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        r20 = r47;
        r22 = r46;
        r23 = r45;
        r21 = r44;
        goto L34
    L14:
        if (r11 != 3) goto L16;
        r26 = (String) ZeusTransformUtils.preCheckCast(r15.L$5, String.class, "com.obric.memorydata.plugin");
        r21 = (Function1) ZeusTransformUtils.preCheckCast(r15.L$4, Function1.class, "com.obric.memorydata.plugin");
        r23 = (String) ZeusTransformUtils.preCheckCast(r15.L$3, String.class, "com.obric.memorydata.plugin");
        r22 = (RequestParams) ZeusTransformUtils.preCheckCast(r15.L$2, RequestParams.class, "com.obric.memorydata.plugin");
        r20 = (String) ZeusTransformUtils.preCheckCast(r15.L$1, String.class, "com.obric.memorydata.plugin");
        r19 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r15.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        goto L38
    L16:
        if (r11 != 4) goto L18;
        g r48 = (g) ZeusTransformUtils.preCheckCast(r15.L$6, g.class, "com.obric.memorydata.plugin");
        String r49 = (String) ZeusTransformUtils.preCheckCast(r15.L$5, String.class, "com.obric.memorydata.plugin");
        Function1 r50 = (Function1) ZeusTransformUtils.preCheckCast(r15.L$4, Function1.class, "com.obric.memorydata.plugin");
        String r51 = (String) ZeusTransformUtils.preCheckCast(r15.L$3, String.class, "com.obric.memorydata.plugin");
        RequestParams r52 = (RequestParams) ZeusTransformUtils.preCheckCast(r15.L$2, RequestParams.class, "com.obric.memorydata.plugin");
        String r53 = (String) ZeusTransformUtils.preCheckCast(r15.L$1, String.class, "com.obric.memorydata.plugin");
        r19 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r15.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        r113 = r48;
        r26 = r49;
        r21 = r50;
        r112 = r51;
        r22 = r52;
        r35 = r53;
        goto L42
    L18:
        if (r11 != 5) goto L21;
        r26 = (String) ZeusTransformUtils.preCheckCast(r15.L$2, String.class, "com.obric.memorydata.plugin");
        r21 = (Function1) ZeusTransformUtils.preCheckCast(r15.L$1, Function1.class, "com.obric.memorydata.plugin");
        r35 = (String) ZeusTransformUtils.preCheckCast(r15.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        r40 = " lora:";
        goto L55
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L26:
        ResultKt.throwOnFailure(r9);
        com.obric.aikernel.runtime.utils.d.f6216a.d("AIInferRuntime", "vmExecute receive " + r1 + " request " + r3 + ' ' + r28.getClientId() + ':' + r28.getTraceIdStr());
        c r54 = f6160a;
        Function1 r55 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$4(r0, null), Function1.class, "com.obric.memorydata.plugin");
        Function1<? super Long, Unit> r56 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$vmExecute$5(r2), Function1.class, "com.obric.memorydata.plugin");
        r15.L$0 = r0;
        r15.L$1 = r1;
        r15.L$2 = r2;
        r15.L$3 = r3;
        r15.L$4 = r5;
        r15.label = 1;
        if (r54.a(r55, r56, r15) != r10) goto L29;
        return r10;
    L7:
        r8 = new AIInferRuntime$vmExecute$3(r0, r7);
        goto L8
    }

    public final Object a(String r7, String r8, String r9, Continuation<? super Unit> r10) {
        Continuation<? super PackageResource> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (this.h != null) goto L14;
        com.obric.aikernel.runtime.subproc.a.c r6 = this.f6161b.m().e();
        if (r6 == null) goto L12;
        Object r11 = r6.a(r7, r8, r9, r5);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r11;
    L10:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        Object r12 = a(r7, r8, true, r9, r5);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r12;
    L20:
        return Unit.INSTANCE;
    }

    public final Object a(String r18, String r19, Continuation<? super PackageResource> r20) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AIInferRuntime$getLoraPackage$1.class) == false) goto L7;
        AIInferRuntime$getLoraPackage$1 r3 = (AIInferRuntime$getLoraPackage$1) ZeusTransformUtils.preCheckCast(r1, AIInferRuntime$getLoraPackage$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        AIInferRuntime$getLoraPackage$1 r11 = r3;
        Object r2 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r11.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        PackageResource r0 = (PackageResource) ZeusTransformUtils.preCheckCast(r11.L$1, PackageResource.class, "com.obric.memorydata.plugin");
        PackageResource r5 = (PackageResource) ZeusTransformUtils.preCheckCast(r11.L$0, PackageResource.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L35:
        List<PackageResource> r6 = CollectionsKt.mutableListOf(new PackageResource[]{(PackageResource) ZeusTransformUtils.preCheckCast(r2, PackageResource.class, "com.obric.memorydata.plugin")});
        List<PackageResource> r7 = r0.getSubRes();
        if (r7 != null) goto L39;
        r7 = CollectionsKt.emptyList();
    L39:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        r0.setSubRes(r6);
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        if (this.h == null) goto L42;
        Pair<com.obric.aikernel.res.metadata.data.f, com.obric.aikernel.res.metadata.data.b> r14 = com.obric.aikernel.res.metadata.data.f.f6090a.a(r18, r19, this.h.getContext());
        com.obric.aikernel.runtime.utils.d r8 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r9 = new StringBuilder().append("getLoraPackage end ").append(r18).append(", ").append(r19).append(", ");
        com.obric.aikernel.res.metadata.data.f r15 = null;
        if (r14 == null) goto L21;
        com.obric.aikernel.res.metadata.data.b r10 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r14.getSecond(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L21;
        PackageResource r13 = a(r10);
    L22:
        r8.d("AIInferRuntime", r9.append(r13).toString());
        if (r14 == null) goto L28;
        com.obric.aikernel.res.metadata.data.b r16 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r14.getSecond(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L28;
        PackageResource r17 = a(r16);
        if (r17 == null) goto L28;
    L29:
        if (r14 == null) goto L31;
        r15 = (com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r14.getFirst(), com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin");
    L31:
        r11.L$0 = r17;
        r11.L$1 = r17;
        r11.label = 1;
        Object r21 = a(r15, r19, r11);
        if (r21 != r12) goto L34;
        return r12;
    L34:
        r5 = r17;
        r2 = r21;
        r0 = r5;
    L28:
        r17 = new PackageResource(r18, 1, 0, null, 0, 28, null);
    L21:
        r13 = null;
        goto L22
    L42:
        throw new IllegalArgumentException("Required value was null.".toString());
    L7:
        r3 = new AIInferRuntime$getLoraPackage$1(this, r1);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x01a9 -> B:60:0x01ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01c5 -> B:48:0x01cf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0215 -> B:57:0x0218). Please report as a decompilation issue!!! */
    public final Object a(String r20, String r21, boolean r22, RequestParams r23, Continuation<? super List<Pair<String, Boolean>>> r24) {
        Class<AIInferRuntime> r1 = AIInferRuntime.class;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AIInferRuntime$preparePackage$1.class) == false) goto L7;
        AIInferRuntime$preparePackage$1 r4 = (AIInferRuntime$preparePackage$1) ZeusTransformUtils.preCheckCast(r2, AIInferRuntime$preparePackage$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        int r8 = 2;
        boolean r9 = true;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        boolean r7 = r4.Z$0;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.L$6, String.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, d.e>> r11 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$5, Iterator.class, "com.obric.memorydata.plugin");
        Function1<? super Continuation<? super g>, ? extends Object> r12 = (Function1) ZeusTransformUtils.preCheckCast(r4.L$4, Function1.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.preCheckCast(r4.L$3, List.class, "com.obric.memorydata.plugin");
        RequestParams r14 = (RequestParams) ZeusTransformUtils.preCheckCast(r4.L$2, RequestParams.class, "com.obric.memorydata.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r16 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r4.L$0, r1, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L15
        AIInferRuntime r17 = r16;
    L60:
        Object r0 = Result.m1421constructorimpl(Boxing.boxBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue()));     // Catch: Throwable -> L44
        AIInferRuntime r18 = r17;
    L48:
        Throwable r19 = Result.m1424exceptionOrNullimpl(r0);
        if (r19 == null) goto L53;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "prepareSubProcessPackageInfo failed, " + ExceptionsKt.stackTraceToString(r19));
    L53:
        if (Result.m1427isFailureimpl(r0) == false) goto L55;
        r0 = null;
    L55:
        boolean r25 = true;
        r13.add(new Pair(r10, Boxing.boxBoolean(Intrinsics.areEqual(r0, Boxing.boxBoolean(true)))));
    L57:
        r9 = r25;
        r1 = r1;
        r8 = 2;
    L31:
        if (r11.hasNext() == false) goto L59;
        Map.Entry r26 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r10 = (String) ZeusTransformUtils.preCheckCast(r26.getKey(), String.class, "com.obric.memorydata.plugin");
        if (((d.e) ZeusTransformUtils.preCheckCast(r26.getValue(), d.e.class, "com.obric.memorydata.plugin")).a(r15) == true) goto L62;
        r1 = r1;
        r25 = r9;
        goto L57
    L62:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L46
        AIInferRuntime r28 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r18, r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        if (r7 == false) goto L37;
        boolean r29 = r9;
    L38:
        r4.L$0 = r18;     // Catch: Throwable -> L46
        r4.L$1 = r15;     // Catch: Throwable -> L46
        r4.L$2 = r14;     // Catch: Throwable -> L46
        r4.L$3 = r13;     // Catch: Throwable -> L46
        r4.L$4 = r12;     // Catch: Throwable -> L46
        r4.L$5 = r11;     // Catch: Throwable -> L46
        r4.L$6 = r10;     // Catch: Throwable -> L46
        r4.Z$0 = r7;     // Catch: Throwable -> L46
        r4.label = r8;     // Catch: Throwable -> L46
        Object r30 = r28.a(r12, r10, r14, r29, r4);     // Catch: Throwable -> L46
        if (r30 != r5) goto L41;
        return r5;
    L41:
        r17 = r18;
        r3 = r30;
        goto L60
    L37:
        r29 = false;
    L46:
        Throwable th = th;
    L47:
        Result.Companion r31 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L48
    L59:
        return r13;
    L44:
        th = th;
        r18 = r17;
    L15:
        th = th;
        r18 = r16;
        goto L47
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        boolean r32 = r4.Z$0;
        RequestParams r33 = (RequestParams) ZeusTransformUtils.preCheckCast(r4.L$3, RequestParams.class, "com.obric.memorydata.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r4.L$2, String.class, "com.obric.memorydata.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r112 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r4.L$0, r1, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L27:
        List r34 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Function1<? super Continuation<? super g>, ? extends Object> r113 = (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$preparePackage$getWrapper$1(r112, r111, r110, r32, null), Function1.class, "com.obric.memorydata.plugin");
        Map<String, d.e> r114 = r112.f6161b.m().c();
        if (r114 == null) goto L66;
        r14 = r33;
        r15 = r111;
        r11 = r114.entrySet().iterator();
        r7 = r32;
        r13 = r34;
        r18 = r112;
        r12 = r113;
        goto L31
    L66:
        return r34;
    L20:
        ResultKt.throwOnFailure(r3);
        if (this.f6161b.m().b() == true) goto L23;
        return null;
    L23:
        r4.L$0 = this;
        r4.L$1 = r20;
        r4.L$2 = r21;
        r4.L$3 = r23;
        r4.Z$0 = r22;
        r4.label = 1;
        if (d(r4) != r5) goto L26;
        return r5;
    L26:
        r112 = this;
        r32 = r22;
        r111 = r20;
        r110 = r21;
        r33 = r23;
    L7:
        r4 = new AIInferRuntime$preparePackage$1(this, r2);
        goto L8
    }

    public final Object a(String r8, String r9, boolean r10, String r11, Continuation<? super PackageResource> r12) {
        return a(r8, r9, r10, r11, false, (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object a(String r14, Continuation<? super PackageResource> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, AIInferRuntime$getPackage$1.class) == false) goto L7;
        AIInferRuntime$getPackage$1 r0 = (AIInferRuntime$getPackage$1) ZeusTransformUtils.preCheckCast(r16, AIInferRuntime$getPackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        List<PackageResource> r4 = null;
        boolean r5 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        PackageResource r13 = (PackageResource) ZeusTransformUtils.preCheckCast(r0.L$2, PackageResource.class, "com.obric.memorydata.plugin");
        r14 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r1 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r0.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r17);
    L24:
        UpdateResult r18 = (UpdateResult) ZeusTransformUtils.preCheckCast(r17, UpdateResult.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L27;
        com.obric.aikernel.res.metadata.config.k r19 = r18.getCfg();
        String r7 = r14;
    L29:
        com.obric.aikernel.runtime.utils.d r110 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r6 = new StringBuilder().append("getPackage isAvailable= ");
        if (r13 == null) goto L32;
        Boolean r8 = Boxing.boxBoolean(r13.isAvailable());
    L33:
        r110.d("AIInferRuntime", r6.append(r8).append("  updateInfo = ").append(r19).toString());
        if (r13 != null) goto L36;
    L38:
        boolean r9 = false;
    L39:
        if (r9 == false) goto L70;
        String r10 = r1.f6161b.g().getPreInitPackageName();
        if (r10 == null) goto L53;
        g r11 = r1.a(r10);
        if (r11 == null) goto L49;
        PackageResource r12 = r11.b();
        if (r12 == null) goto L49;
        if (r12.isAvailable() != true) goto L49;
        boolean r20 = true;
    L51:
        if ((!r20) != true) goto L53;
        boolean r21 = true;
    L54:
        if (r21 == false) goto L57;
        PackageResource r22 = new PackageResource(r7, 1, 0, r13.getVersion(), 1);
    L56:
        r22.setSubRes(r13.getSubRes());
        return r22;
    L57:
        if (r19 == null) goto L66;
        String r111 = r19.c();
        if (r111 == null) goto L66;
        if (com.obric.aikernel.res.metadata.data.b.e.a(r13.getVersion()) >= com.obric.aikernel.res.metadata.data.b.e.a(r111)) goto L63;
        boolean r112 = true;
    L64:
        if (r112 != true) goto L66;
    L67:
        if (r5 == false) goto L77;
        r22 = new PackageResource(r7, 1, 0, r13.getVersion(), r13.getSelfFlag() & (-5));
        goto L56
    L77:
        return r13;
    L63:
        r112 = false;
    L66:
        r5 = false;
    L49:
        r20 = false;
    L53:
        r21 = false;
        goto L54
    L70:
        if (r19 == null) goto L78;
        PackageResource r113 = new PackageResource(r7, 1, 0, r19.c(), 1);
        if (r13 == null) goto L74;
        r4 = r13.getSubRes();
    L74:
        r113.setSubRes(r4);
        return r113;
    L78:
        return null;
    L36:
        if (r13.isAvailable() != true) goto L38;
        r9 = true;
        goto L39
    L32:
        r8 = null;
        goto L33
    L27:
        PackageResource r114 = r13;
        AIInferRuntime this = r1;
    L28:
        r1 = this;
        r7 = r14;
        r13 = r114;
        r19 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        g r115 = a(r14);
        if (r115 == null) goto L17;
        r114 = r115.b();
    L18:
        PackageResourceManager r23 = this.h;
        if (r23 == null) goto L28;
        r0.L$0 = this;
        r0.L$1 = r14;
        r0.L$2 = r114;
        r0.label = 1;
        Object r24 = r23.getPackageUpdateInfo(r14, r0);
        if (r24 != r2) goto L23;
        return r2;
    L23:
        r1 = this;
        r13 = r114;
        r17 = r24;
        goto L24
    L17:
        r114 = null;
    L7:
        r0 = new AIInferRuntime$getPackage$1(this, r16);
        goto L8
    }

    public final Object a(String r12, boolean r13, Continuation<? super Map<String, UpdateResult>> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AIInferRuntime$updateAll$1.class) == false) goto L7;
        AIInferRuntime$updateAll$1 r1 = (AIInferRuntime$updateAll$1) ZeusTransformUtils.preCheckCast(r15, AIInferRuntime$updateAll$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r6 = false;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        r13 = r1.Z$0;
        AIInferRuntime r11 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$1, AIInferRuntime.class, "com.obric.memorydata.plugin");
        r12 = (String) ZeusTransformUtils.preCheckCast(r1.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
    L37:
        Map<String, UpdateResult> r0 = (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        com.obric.aikernel.runtime.utils.d r2 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L14
        StringBuilder r5 = new StringBuilder().append("updateAll end caller=").append(r12).append(" background=");     // Catch: Throwable -> L14
        if (r13 == false) goto L40;
        r6 = true;
    L40:
        r2.e("AIInferRuntime", r5.append(r6).append(' ').append(r11.a(r0)).toString());     // Catch: Throwable -> L14
        Object r17 = Result.m1421constructorimpl((Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L43:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);
        if (r18 == null) goto L46;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "updateAll failed caller=" + r12 + " background=" + r13 + ' ' + ExceptionsKt.stackTraceToString(r18));
    L46:
        ResultKt.throwOnFailure(r17);
        return r17;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r16);
        com.obric.aikernel.runtime.utils.d r19 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r7 = new StringBuilder().append("updateAll start caller=").append(r12).append(" background=").append(r13).append(" aikPmsNull=");
        if (this.h != null) goto L21;
        boolean r10 = true;
    L22:
        r19.e("AIInferRuntime", r7.append(r10).toString());
        PackageResourceManager r110 = this.h;
        if (r110 != null) goto L26;
        com.obric.aikernel.runtime.utils.d.f6216a.f("AIInferRuntime", "updateAll skip caller=" + r12 + " background=" + r13 + " because aikPms is null");
        return MapsKt.emptyMap();
    L26:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L14
        r11 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(this, AIInferRuntime.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        com.obric.aikernel.runtime.utils.d r9 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L14
        StringBuilder r20 = new StringBuilder().append("updateAll enter PackageResourceManager.updateAll caller=").append(r12).append(" background=");     // Catch: Throwable -> L14
        if (r13 == false) goto L29;
        boolean r111 = true;
    L30:
        r9.e("AIInferRuntime", r20.append(r111).toString());     // Catch: Throwable -> L14
        if (r13 == false) goto L33;
        boolean r21 = true;
    L34:
        r1.L$0 = r12;     // Catch: Throwable -> L14
        r1.L$1 = r11;     // Catch: Throwable -> L14
        r1.Z$0 = r13;     // Catch: Throwable -> L14
        r1.label = 1;     // Catch: Throwable -> L14
        r16 = r110.updateAll(r12, r21, r1);     // Catch: Throwable -> L14
        if (r16 != r3) goto L37;
        return r3;
    L33:
        r21 = false;
        goto L34
    L29:
        r111 = false;
        goto L30
    L21:
        r10 = false;
    L14:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r1 = new AIInferRuntime$updateAll$1(this, r15);
        goto L8
    }

    public final Object a(Continuation<? super List<com.obric.aikernel.res.metadata.config.i>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AIInferRuntime$getAllPackageConfigs$1.class) == false) goto L7;
        AIInferRuntime$getAllPackageConfigs$1 r0 = (AIInferRuntime$getAllPackageConfigs$1) ZeusTransformUtils.preCheckCast(r7, AIInferRuntime$getAllPackageConfigs$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L19:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L22;
        return r5;
    L22:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        PackageResourceManager r9 = this.h;
        if (r9 == null) goto L22;
        r0.label = 1;
        r8 = r9.getAllPackageConfigs(r0);
        if (r8 != r2) goto L19;
        return r2;
    L7:
        r0 = new AIInferRuntime$getAllPackageConfigs$1(this, r7);
        goto L8
    }

    public final void a(FileDescriptor r10, PrintWriter r11, List<String> r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "fd");
        Intrinsics.checkNotNullParameter(r11, "fout");
        Intrinsics.checkNotNullParameter(r13, "args");
        a(r11);
        com.obric.aikernel.runtime.b r14 = com.obric.aikernel.runtime.c.f6192a.a(r13);
        Boolean r2 = null;
        if (r14 != null) goto L5;
        String r15 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r13), String.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L95;
        String r7 = "";
        switch(r15.hashCode()) {
            case -1557772738: goto L90;
            case -1333038649: goto L84;
            case -1298848381: goto L69;
            case -625596190: goto L65;
            case -518321244: goto L54;
            case 94746185: goto L50;
            case 1150401521: goto L46;
            case 1640790517: goto L42;
            case 1671308008: goto L29;
            case 1957569947: goto L21;
            default: goto L95;
        };
    L21:
        if (r15.equals("install") == false) goto L95;
        String r16 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r13, 1), String.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L100;
        PackageResourceManager r9 = this.h;
        if (r9 == null) goto L101;
        r9.installFromPath(r16);
        return;
    L101:
        return;
    L100:
        return;
    L29:
        if (r15.equals("disable") == false) goto L95;
        String r17 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r13, 1), String.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L38;
        StringBuilder r18 = new StringBuilder().append("AIInferRuntime ").append(r15).append(' ').append(r17).append(' ');
        PackageResourceManager r19 = this.h;
        if (r19 == null) goto L79;
        com.obric.aikernel.res.metadata.data.b r20 = r19.getPackage(r17);
        if (r20 == null) goto L79;
        boolean r21 = r20.o();
    L78:
        r2 = Boolean.valueOf(r21);
    L79:
        StringBuilder r22 = r18.append(r2);
    L96:
        r11.println(r22.toString());
        return;
    L38:
        PackageResourceManager r23 = this.h;
        if (r23 == null) goto L103;
        r23.disable("package", "", "");
        return;
    L103:
        return;
    L42:
        if (r15.equals("push_debug_package") == false) goto L95;
        al r3 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        CoroutineContext r4 = null;
        CoroutineStart r5 = null;
        Object r110 = new AIInferRuntime$dump$11(r13, this, null);
    L93:
        Object r24 = ZeusTransformUtils.preCheckCast(r110, Function2.class, "com.obric.memorydata.plugin");
    L94:
        kotlinx.coroutines.i.a(r3, r4, r5, (Function2) r24, 3, null);
        return;
    L46:
        if (r15.equals("request_all") == false) goto L95;
        r3 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        r4 = null;
        r5 = null;
        r110 = new AIInferRuntime$dump$4(r13, this, null);
        goto L93
    L50:
        if (r15.equals("clean") == false) goto L95;
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$dump$8(this, r11, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return;
    L54:
        if (r15.equals("check_time") == false) goto L95;
        com.obric.aikernel.res.task.b.a r111 = com.obric.aikernel.res.task.b.f6101a;
        StringBuilder r112 = new StringBuilder().append(this.d.getPath());
        String r113 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r13, 1), String.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L60;
        r7 = r113;
    L60:
        String r114 = r112.append(r7).toString();
        File r115 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f6161b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getExternalCacheDir() + "/usage.txt");
        r115.delete();
        File r0 = r115.getParentFile();
        if (r0 == null) goto L63;
        r0.mkdirs();
    L63:
        Unit r1 = Unit.INSTANCE;
        r111.a(r114, r115, this.f6161b.g());
        return;
    L65:
        if (r15.equals("uninstall") == false) goto L95;
        com.obric.aikernel.b.a.f5986a.a(r13, r11, (Function1) ZeusTransformUtils.preCheckCast(new AIInferRuntime$dump$7(this), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L69:
        if (r15.equals("enable") == false) goto L95;
        String r116 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r13, 1), String.class, "com.obric.memorydata.plugin");
        if (r116 == null) goto L80;
        r18 = new StringBuilder().append("AIInferRuntime ").append(r15).append(' ').append(r116).append(' ');
        PackageResourceManager r25 = this.h;
        if (r25 == null) goto L79;
        com.obric.aikernel.res.metadata.data.b r26 = r25.getPackage(r116);
        if (r26 == null) goto L79;
        r21 = r26.n();
        goto L78
    L80:
        PackageResourceManager r27 = this.h;
        if (r27 == null) goto L108;
        r27.enable("package", "", "");
        return;
    L108:
        return;
    L84:
        if (r15.equals("update_target") == false) goto L95;
        String r117 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r13, 1), String.class, "com.obric.memorydata.plugin");
        if (r117 == null) goto L110;
        r3 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        r4 = null;
        r5 = null;
        r24 = ZeusTransformUtils.preCheckCast(new AIInferRuntime$dump$5$1(this, r117, r13, null), Function2.class, "com.obric.memorydata.plugin");
        goto L94
    L110:
        return;
    L90:
        if (r15.equals("clean_debug_res") == false) goto L95;
        r3 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        r4 = null;
        r5 = null;
        r110 = new AIInferRuntime$dump$10(this, null);
    L95:
        r22 = new StringBuilder().append("AIInferRuntime ").append(r15).append(" not impl");
        goto L96
    L5:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aikernel.runtime.b.C0276b.class) == false) goto L9;
        al r6 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        CoroutineContext r8 = null;
        CoroutineStart r28 = null;
        Object r118 = new AIInferRuntime$dump$1$1(this, r14, null);
    L7:
        kotlinx.coroutines.i.a(r6, r8, r28, (Function2) ZeusTransformUtils.preCheckCast(r118, Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aikernel.runtime.b.c.class) == false) goto L12;
        r6 = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        r8 = null;
        r28 = null;
        r118 = new AIInferRuntime$dump$1$2(this, r14, null);
        goto L7
    L12:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.aikernel.runtime.b.a.class) == false) goto L99;
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AIInferRuntime$dump$1$3(r11, this, r14, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return;
    }

    public final void a(String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "pkg");
        Intrinsics.checkNotNullParameter(r4, "version");
        PackageResourceManager r0 = this.h;
        if (r0 == null) goto L7;
        r0.markPackageCorrupt(r3, r4);
        Unit r6 = Unit.INSTANCE;
        if (r5 == false) goto L11;
        d(r3);
        return;
    L11:
        return;
    L7:
        com.obric.aikernel.runtime.subproc.a.c r2 = ((AIInferRuntime) ZeusTransformUtils.preCheckCast(this, AIInferRuntime.class, "com.obric.memorydata.plugin")).f6161b.m().e();
        if (r2 == null) goto L13;
        r2.a(r3, r4, r5);
        return;
    }

    public final void a(List<String> r10, List<? extends com.obric.aikernel.res.metadata.data.b> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "infos");
        Intrinsics.checkNotNullParameter(r13, "pkgs");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin"));
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r14.hasNext() == false) goto L12;
        List r15 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"@"}, false, 0, 6, null);
        String r3 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r15), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3, "package") == true) goto L7;
        if (Intrinsics.areEqual(r3, "lora") == false) goto L4;
        com.obric.aikernel.res.metadata.data.d r4 = new com.obric.aikernel.res.metadata.data.f((String) ZeusTransformUtils.preCheckCast(r15.get(1), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r15.get(2), String.class, "com.obric.memorydata.plugin"), this.f6161b.g());
    L8:
        r0.add(r4);
        goto L4
    L7:
        r4 = new com.obric.aikernel.res.metadata.data.b((String) ZeusTransformUtils.preCheckCast(r15.get(1), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r15.get(2), String.class, "com.obric.memorydata.plugin"), this.f6161b.g());
        goto L8
    L12:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r16.hasNext() == false) goto L34;
        com.obric.aikernel.res.metadata.data.d r17 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, com.obric.aikernel.res.metadata.data.b.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r17, com.obric.aikernel.res.metadata.data.f.class) == true) goto L20;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "vmProcessAddPackageInfo: not configured type " + r17);
        goto L14
    L20:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r5.hasNext() == false) goto L32;
        Object r6 = r5.next();
        com.obric.aikernel.res.metadata.data.d r7 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r6, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aikernel.res.metadata.data.b.class) == true) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r8 == false) goto L22;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");
        a((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r6, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin"), (com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r17, com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin"));
        goto L14
    L26:
        if (Intrinsics.areEqual(r7.s(), ((com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r17, com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin")).p()) == false) goto L28;
        r8 = true;
        goto L29
    L32:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L17:
        d((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r17, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin"));
        goto L14
    }

    public final Object b(String r3, Continuation<? super com.obric.aikernel.res.metadata.config.i> r4) {
        Continuation<? super com.obric.aikernel.res.metadata.config.i> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        PackageResourceManager r2 = this.h;
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.getPackageConfig(r3, r5);
    }

    public final Object b(Continuation<? super JsonObject> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AIInferRuntime$getDownloadingSummary$1.class) == false) goto L7;
        AIInferRuntime$getDownloadingSummary$1 r0 = (AIInferRuntime$getDownloadingSummary$1) ZeusTransformUtils.preCheckCast(r7, AIInferRuntime$getDownloadingSummary$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L19:
        JsonObject r5 = (JsonObject) ZeusTransformUtils.preCheckCast(r8, JsonObject.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L22;
        return r5;
    L22:
        return new JsonObject();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        PackageResourceManager r9 = this.h;
        if (r9 == null) goto L22;
        r0.label = 1;
        r8 = r9.getDownloadingSummary(r0);
        if (r8 != r2) goto L19;
        return r2;
    L7:
        r0 = new AIInferRuntime$getDownloadingSummary$1(this, r7);
        goto L8
    }

    public final al b() {
        return this.c;
    }

    public final Object c(String r6, Continuation<? super Float> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AIInferRuntime$getPackageUpdateProgress$1.class) == false) goto L7;
        AIInferRuntime$getPackageUpdateProgress$1 r0 = (AIInferRuntime$getPackageUpdateProgress$1) ZeusTransformUtils.preCheckCast(r8, AIInferRuntime$getPackageUpdateProgress$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L19:
        float r5 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).floatValue();
    L22:
        return Boxing.boxFloat(r5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        PackageResourceManager r10 = this.h;
        if (r10 == null) goto L20;
        r0.label = 1;
        r9 = r10.getPackageUpdateProgress(r6, r0);
        if (r9 != r2) goto L19;
        return r2;
    L20:
        r5 = -1.0f;
    L7:
        r0 = new AIInferRuntime$getPackageUpdateProgress$1(this, r8);
        goto L8
    }

    public final Object d(String r11, Continuation<? super Unit> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIInferRuntime$stopVmPackage$1.class) == false) goto L7;
        AIInferRuntime$stopVmPackage$1 r1 = (AIInferRuntime$stopVmPackage$1) ZeusTransformUtils.preCheckCast(r13, AIInferRuntime$stopVmPackage$1.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        Unit r8 = null;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        AIInferRuntime r15 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L32:
        r8 = Unit.INSTANCE;
        AIInferRuntime r9 = r15;
        r11 = r10;
        AIInferRuntime this = r9;
    L33:
        if (r8 != null) goto L36;
        AIInferRuntime r16 = (AIInferRuntime) ZeusTransformUtils.preCheckCast(this, AIInferRuntime.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.utils.d.f6216a.f("AIInferRuntime", "try stopVmPackage " + r11 + " but no active service!");
    L36:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (String) ZeusTransformUtils.preCheckCast(r1.L$1, String.class, "com.obric.memorydata.plugin");
        this = (AIInferRuntime) ZeusTransformUtils.preCheckCast(r1.L$0, AIInferRuntime.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L19:
        g r17 = (g) ZeusTransformUtils.preCheckCast(r14, g.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L33;
        Result<com.obric.aee.res.b> r18 = r17.d();
        if (r18 == null) goto L33;
        Object r19 = r18.m1430unboximpl();
        if (Result.m1427isFailureimpl(r19) == false) goto L26;
        r19 = null;
    L26:
        com.obric.aee.res.b r110 = (com.obric.aee.res.b) ZeusTransformUtils.preCheckCast(r19, com.obric.aee.res.b.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L33;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "stopVmPackage " + r110);
        com.obric.aee.b r5 = com.obric.aee.b.f5869a;
        r1.L$0 = this;
        r1.L$1 = r11;
        r1.label = 2;
        if (r5.stopService(r110, r1) != r3) goto L31;
        return r3;
    L31:
        String r20 = r11;
        r15 = this;
        r10 = r20;
        goto L32
    L16:
        ResultKt.throwOnFailure(r14);
        r1.L$0 = this;
        r1.L$1 = r11;
        r1.label = 1;
        r14 = a(r11, null, false, r1);
        if (r14 != r3) goto L19;
        return r3;
    L7:
        r1 = new AIInferRuntime$stopVmPackage$1(this, r13);
        goto L8
    }

    @com.obric.aee.utils.a
    public final String getDynamicPackageResources(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "pkg");
        Intrinsics.checkNotNullParameter(r4, "lora");
        return (String) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C10201(this, r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), String.class, "com.obric.memorydata.plugin");
    }
}
