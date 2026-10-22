package com.obric.memorydata.awareness.cae;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.fence.GeoFence;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.awareness.GeoFenceCallbackPolicy;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.awareness.impl.location.GeofenceRuntimeAvailabilityManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.da;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0089\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0013*\u0003P\u008c\u0001\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004Ö\u0001×\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010)\u001a\u00020\u000fH\u0000¢\u0006\u0002\b*J\b\u0010H\u001a\u00020\u000fH\u0002J\u000f\u0010I\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bJJ\u0012\u0010I\u001a\u0004\u0018\u00010\u00052\u0006\u0010K\u001a\u00020\u001bH\u0002J\b\u0010L\u001a\u00020\u0019H\u0002J\b\u0010M\u001a\u00020\u0019H\u0002J\u0016\u0010Y\u001a\u00020\u00192\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0010\u0010[\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u0005H\u0002J\u001a\u0010]\u001a\u00020\u00192\b\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010`\u001a\u00020\fH\u0002J\u0018\u0010a\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020bH\u0002J\u0018\u0010c\u001a\u00020\u00192\u0006\u0010d\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020_H\u0002J\u000f\u0010e\u001a\u0004\u0018\u00010/H\u0000¢\u0006\u0002\bfJ\u000f\u0010g\u001a\u0004\u0018\u000101H\u0000¢\u0006\u0002\bhJ\u0015\u0010i\u001a\u00020\u00192\u0006\u0010j\u001a\u00020\u0005H\u0000¢\u0006\u0002\bkJ\u0018\u0010l\u001a\u00020/2\u0006\u0010^\u001a\u00020_2\u0006\u0010d\u001a\u00020\u000fH\u0002J\u0012\u0010m\u001a\u0004\u0018\u0001012\u0006\u0010^\u001a\u00020_H\u0002J\u0017\u0010n\u001a\u0004\u0018\u00010\f2\u0006\u0010^\u001a\u00020_H\u0002¢\u0006\u0002\u0010oJ\r\u0010p\u001a\u00020\u000fH\u0000¢\u0006\u0002\bqJ\u0015\u0010r\u001a\u00020\u00192\u0006\u0010j\u001a\u00020\u0005H\u0000¢\u0006\u0002\bsJ$\u0010t\u001a\u00020\u00192\b\b\u0002\u0010u\u001a\u00020\f2\u0010\b\u0002\u0010v\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0002J\u0016\u0010w\u001a\u00020\u00192\f\u0010x\u001a\b\u0012\u0004\u0012\u00020_0EH\u0002J\"\u0010y\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010E2\u0010\b\u0002\u0010x\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010EH\u0002J\u0018\u0010z\u001a\u00020\u00192\u0006\u0010{\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u0005H\u0002J\n\u0010|\u001a\u0004\u0018\u00010}H\u0002J\u0014\u0010~\u001a\u0004\u0018\u00010\u00052\b\u0010\u007f\u001a\u0004\u0018\u00010FH\u0002J\u0015\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u007f\u001a\u0004\u0018\u00010FH\u0002J\u0019\u0010\u0081\u0001\u001a\u00020b2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\fH\u0002J\u001b\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020_2\u0007\u0010\u0084\u0001\u001a\u00020_H\u0002J\u001c\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010E2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010\u0087\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020\u001fH\u0002J\n\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0002J\u0014\u0010\u008e\u0001\u001a\u00020\u00192\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001dH\u0002J\u0014\u0010\u008f\u0001\u001a\u00020\u00192\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001dH\u0002J\t\u0010\u0090\u0001\u001a\u00020\u0019H\u0002J\u0014\u0010\u0091\u0001\u001a\u00020\u00192\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001fH\u0002J\u0014\u0010\u0092\u0001\u001a\u00020\u00192\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001fH\u0002J'\u0010\u0093\u0001\u001a\u00020\u000f2\b\u0010^\u001a\u0004\u0018\u00010\u00052\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001H\u0002J\u001d\u0010\u0097\u0001\u001a\u00020\u000f2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001H\u0002J\t\u0010\u0098\u0001\u001a\u00020\u0019H\u0002J\t\u0010\u0099\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u009a\u0001\u001a\u00020\u0019H\u0002J\t\u0010\u009b\u0001\u001a\u00020\u0019H\u0002J\u001b\u0010\u009c\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0007\u0010\u009d\u0001\u001a\u00020/H\u0002J1\u0010\u009e\u0001\u001a\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\r\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020/0E2\u000e\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020\u00050¡\u0001H\u0002J\f\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001H\u0002J\t\u0010¤\u0001\u001a\u00020\u0019H\u0007J\t\u0010¥\u0001\u001a\u00020\u0019H\u0002J\t\u0010¦\u0001\u001a\u00020\u0019H\u0003J\u0007\u0010§\u0001\u001a\u00020\u000fJ\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010©\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0003\u0010ª\u0001J\u0010\u0010«\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0003\u0010ª\u0001J\u0019\u0010¬\u0001\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020\u00052\b\u0010\u00ad\u0001\u001a\u00030®\u0001J\u001a\u0010¯\u0001\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020\u00052\u0007\u0010°\u0001\u001a\u00020\u000fH\u0002J&\u0010±\u0001\u001a\u00020\u00192\u0007\u0010²\u0001\u001a\u00020\u00052\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u0001H\u0002J\u0012\u0010µ\u0001\u001a\u00020\u000f2\u0007\u0010²\u0001\u001a\u00020\u0005H\u0002JN\u0010¶\u0001\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u00052\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\t\b\u0002\u0010·\u0001\u001a\u00020\f2\t\b\u0002\u0010¸\u0001\u001a\u00020\f2\u000b\b\u0002\u0010¹\u0001\u001a\u0004\u0018\u00010TH\u0000¢\u0006\u0003\bº\u0001J\u001d\u0010»\u0001\u001a\u00020}2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001H\u0002JK\u0010¼\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u00052\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010·\u0001\u001a\u00020\f2\b\u0010¸\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002JK\u0010À\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u00052\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010·\u0001\u001a\u00020\f2\b\u0010¸\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J]\u0010Á\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u00052\u0007\u0010Â\u0001\u001a\u00020\u00052\u0007\u0010Ã\u0001\u001a\u00020\u00052\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010·\u0001\u001a\u00020\f2\b\u0010¸\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002JW\u0010Ä\u0001\u001a\u00030Å\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\t\u0010Æ\u0001\u001a\u0004\u0018\u00010/2\u0006\u0010\\\u001a\u00020\u00052\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010·\u0001\u001a\u00020\f2\b\u0010¸\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J?\u0010Ç\u0001\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u00052\u0007\u0010Â\u0001\u001a\u00020\u00052\u0007\u0010Ã\u0001\u001a\u00020\u00052\u0007\u0010·\u0001\u001a\u00020\f2\u0007\u0010È\u0001\u001a\u00020\u00052\b\u0010É\u0001\u001a\u00030Å\u0001H\u0002J9\u0010Ê\u0001\u001a\u00020\u000f2\u0007\u0010Æ\u0001\u001a\u00020/2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0095\u00012\u0007\u0010·\u0001\u001a\u00020\f2\b\u0010¸\u0001\u001a\u00030½\u0001H\u0002J\u0012\u0010Ë\u0001\u001a\u00030¿\u00012\u0006\u0010\\\u001a\u00020\u0005H\u0002J\u001b\u0010Ì\u0001\u001a\u00020\u00192\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0007\u0010Â\u0001\u001a\u00020\u0005H\u0002J\u000f\u0010Í\u0001\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u0005J\u0016\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020/0E2\u0007\u0010Ï\u0001\u001a\u00020\u0005J\u0010\u0010Ð\u0001\u001a\u00020\f2\u0007\u0010Ï\u0001\u001a\u00020\u0005J\u001b\u0010Ñ\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0007\u0010\u009d\u0001\u001a\u00020/H\u0002J#\u0010Ò\u0001\u001a\u00020\u000f2\u0007\u0010\u0086\u0001\u001a\u00020\u001d2\u0007\u0010Ó\u0001\u001a\u00020/2\u0006\u0010j\u001a\u00020\u0005H\u0002J\u0012\u0010Ô\u0001\u001a\u00020\u00192\u0007\u0010Â\u0001\u001a\u00020\u0005H\u0002J\u0011\u0010Õ\u0001\u001a\u0004\u0018\u00010/2\u0006\u0010\\\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00107\u001a\n 9*\u0004\u0018\u00010808X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000f0<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000f0<¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>RP\u0010A\u001aB\u0012\f\u0012\n 9*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n 9*\u0004\u0018\u00010\u000f0\u000f 9* \u0012\f\u0012\n 9*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n 9*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010B0BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010CR\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020F0EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0004\n\u0002\u0010QR\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020T0SX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008d\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/obric/memorydata/awareness/cae/CaeLocationAware;", "", "<init>", "()V", "TAG", "", "SERVICE_PACKAGE", "SERVICE_CLASS_NAME", "SERVICE_ACTION", "AOI_SNAPSHOT_SYNC_RETRY_DELAY_MS", "", "AOI_SNAPSHOT_SYNC_MAX_RETRY", "", "LOGICAL_FENCE_BOUNDARY", "isFirstPartyDevice", "", "()Z", "isFirstPartyDevice$delegate", "Lkotlin/Lazy;", "STATUS_IN", "STATUS_OUT", "STATUS_ALL", "permissionListenerRegistered", "locationPermissionChangeListener", "Lkotlin/Function0;", "", "locationService", "Lcom/obric/cae/libs/location/IStarLocationService;", "geofenceManager", "Lcom/obric/cae/libs/location/geofence/IStarGeofenceManager;", "aoiBoardManager", "Lcom/obric/cae/libs/location/poi/IStarAoiBoardManager;", "geofenceRuntimeAvailabilityManager", "Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager;", "getGeofenceRuntimeAvailabilityManager", "()Lcom/obric/memorydata/awareness/impl/location/GeofenceRuntimeAvailabilityManager;", "geofenceRuntimeAvailabilityManager$delegate", "realtimeLocationEventsAvailable", "Lkotlinx/coroutines/flow/StateFlow;", "getRealtimeLocationEventsAvailable$awareness_obricRelease", "()Lkotlinx/coroutines/flow/StateFlow;", "shouldAcceptRealtimeLocationEvents", "shouldAcceptRealtimeLocationEvents$awareness_obricRelease", "transportHubCompanyFenceLock", "transportHubCompanyFenceInside", "Ljava/lang/Boolean;", "transportHubCompanyFence", "Lcom/obric/cae/libs/location/geofence/StarGeofence;", "transportHubCompanyInfo", "Lcom/obric/memorydata/awareness/cae/CaeLocationAware$AoiCompanyInfo;", "companyFenceHandledByTransportHubAoiCached", "transportHubAoiSupportChecked", "transportHubAoiSupported", "commSenseAARVersionChecked", "commSenseAARVersionCache", "aoiEventExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "serviceBindState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getServiceBindState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "geoFenceServiceReadyState", "getGeoFenceServiceReadyState", "dualBoundaryReadyFenceIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "transportHubAoiTypes", "", "Lcom/obric/cae/libs/location/poi/AoiBoard$Type;", "locationAoiTypes", "isTransportHubAoiSupported", "getCommSenseAARVersion", "getCommSenseAARVersion$awareness_obricRelease", "service", "resetCommSenseAARVersionCache", "resetTransportHubAoiSupportCache", "ACTION_GEOFENCE_RECOVER", "geofenceRecoverReceiver", "com/obric/memorydata/awareness/cae/CaeLocationAware$geofenceRecoverReceiver$1", "Lcom/obric/memorydata/awareness/cae/CaeLocationAware$geofenceRecoverReceiver$1;", "geoFenceListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/awareness/cae/GeoFenceListener;", "geofenceCallback", "Lcom/obric/cae/libs/location/geofence/IStarGeofenceCallback;", "aoiBoardCallback", "Lcom/obric/cae/libs/location/poi/IStarAoiBoardCallback;", "executeTransportHubAoiEvent", "block", "isTransportHubCircleGeofence", "geofenceId", "dispatchTransportHubAoiBoardEventsIfNeeded", "aoiBoard", "Lcom/obric/cae/libs/location/poi/AoiBoard;", "event", "dispatchCompanyFenceByTransportHubAoiIfNeeded", "Lcom/obric/cae/libs/location/poi/AoiBoard$Event;", "notifyCompanyFenceByTransportHubAoi", "enter", "getTransportHubCompanyFence", "getTransportHubCompanyFence$awareness_obricRelease", "getTransportHubCompanyInfo", "getTransportHubCompanyInfo$awareness_obricRelease", "clearTransportHubCompanyFenceState", InfoRequestQPSOptTraceLogger.REASON, "clearTransportHubCompanyFenceState$awareness_obricRelease", "createTransportHubCompanyFence", "createAoiCompanyInfo", "getAoiBoardGeofenceRadius", "(Lcom/obric/cae/libs/location/poi/AoiBoard;)Ljava/lang/Integer;", "isCompanyFenceHandledByTransportHubAoiCached", "isCompanyFenceHandledByTransportHubAoiCached$awareness_obricRelease", "syncCurrentTransportHubAoiBoardsIfNeeded", "syncCurrentTransportHubAoiBoardsIfNeeded$awareness_obricRelease", "syncCurrentTransportHubAoiBoards", "retryCount", "onSnapshotSubmitted", "syncCurrentCompanyFenceByTransportHubAoi", "boards", "listCompanyTransportHubAoiBoards", "updateCompanyFenceHandledByTransportHubAoi", "handled", "getCompanyLocationWgs84", "Landroid/location/Location;", "getTransportHubLocationType", "type", "getAoiType", "resolveAoiBoardEvent", "isSameAoiBoard", "first", "second", "listTransportHubAoiBoards", "manager", "isAoiBoardsRecovered", "locationConnection", "Landroid/content/ServiceConnection;", "newLocationConnection", "deathRecipient", "com/obric/memorydata/awareness/cae/CaeLocationAware$deathRecipient$1", "Lcom/obric/memorydata/awareness/cae/CaeLocationAware$deathRecipient$1;", "registerGeofenceCallback", "unregisterGeofenceCallback", "initAoiBoardManagerIfSupported", "registerAoiBoardCallback", "unregisterAoiBoardCallback", "isLocationInAoiBoard", "latitude", "", "longitude", "isValidCoordinate", "startLocationSnapshotReconciliation", "isLocationSnapshotSourceReady", "submitHomeCompanyReconciliationSnapshot", "ensureRecoveredDualBoundaryGeofences", "ensureRecoveredBoundaryPair", "logicalFence", "removeOrphanBoundaryFences", "fences", "logicalFenceIds", "", "readCaeGeoFenceSnapshot", "Lcom/obric/memorydata/awareness/cae/CaeLocationAware$CaeGeoFenceSnapshot;", CommonConsts.APM_INNER_EVENT_COST_INIT, "registerLocationPermissionListenerIfNeeded", "connectLocationService", "isReady", "getLocationServiceOrNull", "bindLocationServiceSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindServiceSync", "notifyGeoFenceEvent", "transitionEvent", "Lcom/obric/cae/libs/location/geofence/StarGeofence$GeoEvent;", "handleInitialGeofenceState", "isEnter", "notifyBoundaryGeofenceEvent", "physicalFenceId", "physicalFence", "Lcom/obric/memorydata/awareness/cae/DualBoundaryGeofence$PhysicalFence;", "isInitialGeofenceCallback", "addGeofence", "radius", "transitionType", "listener", "addGeofence$awareness_obricRelease", "convertGeofenceLocation", "upsertLogicalGeofenceSet", "Lcom/obric/cae/libs/location/geofence/StarGeofence$GeoTransitionType;", "geoType", "Lcom/obric/cae/libs/location/geofence/StarGeofence$GeoType;", "upsertPhysicalGeofence", "upsertPhysicalGeofenceInternal", "logicalFenceId", "boundary", "writePhysicalGeofence", "", "existing", "reportPhysicalGeofenceUpsert", "operation", "result", "isSamePhysicalGeofence", "resolveLogicalGeoType", "removeBoundaryPair", "removeGeofence", "getGeofencesByPrefix", "prefix", "removeGeofencesByPrefix", "deleteLogicalGeofenceSet", "deletePhysicalGeofence", GeoFence.BUNDLE_KEY_FENCE, "clearGeofenceCallbackPolicy", "getGeofence", "AoiCompanyInfo", "CaeGeoFenceSnapshot", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {
    private static final com.obric.cae.libs.location.poi.a A = null;
    private static ServiceConnection B;
    private static final e C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8563a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f8564b = null;
    private static boolean c;
    private static final Function0<Unit> d = null;
    private static com.obric.cae.libs.location.b e;
    private static com.obric.cae.libs.location.geofence.b f;
    private static com.obric.cae.libs.location.poi.b g;
    private static final Lazy h = null;
    private static final Object i = null;
    private static volatile Boolean j;
    private static volatile StarGeofence k;
    private static volatile a l;
    private static volatile boolean m;
    private static volatile boolean n;
    private static volatile boolean o;
    private static volatile boolean p;
    private static volatile String q;
    private static final ExecutorService r = null;
    private static final ae<Boolean> s = null;
    private static final ae<Boolean> t = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> u = null;
    private static final List<AoiBoard.Type> v = null;
    private static final List<AoiBoard.Type> w = null;
    private static final g x = null;
    private static final ConcurrentHashMap<String, com.obric.memorydata.awareness.cae.d> y = null;
    private static final com.obric.cae.libs.location.geofence.a z = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/awareness/cae/CaeLocationAware$AoiCompanyInfo;", "", "type", "", "radius", "", "<init>", "(Ljava/lang/String;I)V", "getType", "()Ljava/lang/String;", "getRadius", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f8566b;

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.f8565a = r2;
            this.f8566b = r3;
        }

        public final int a() {
            return this.f8566b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8565a, r6.f8565a) == true) goto L12;
            return false;
        L12:
            if (this.f8566b == r6.f8566b) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getType() {
            return this.f8565a;
        }

        public int hashCode() {
            return (this.f8565a.hashCode() * 31) + Integer.hashCode(this.f8566b);
        }

        public String toString() {
            return "AoiCompanyInfo(type=" + this.f8565a + ", radius=" + this.f8566b + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.cae.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/awareness/cae/CaeLocationAware$CaeGeoFenceSnapshot;", "", "insideGeoFenceIds", "", "", "insideOuterBoundaryFenceIds", "insideHomeCompanyFenceIds", "homeCompanyComplete", "", "totalFenceCount", "", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;ZI)V", "getInsideGeoFenceIds", "()Ljava/util/Set;", "getInsideOuterBoundaryFenceIds", "getInsideHomeCompanyFenceIds", "getHomeCompanyComplete", "()Z", "getTotalFenceCount", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0432b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f8567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f8568b;
        private final Set<String> c;
        private final boolean d;
        private final int e;

        public C0432b(Set<String> r3, Set<String> r4, Set<String> r5, boolean r6, int r7) {
            Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "insideGeoFenceIds");
            Intrinsics.checkNotNullParameter(r9, "insideOuterBoundaryFenceIds");
            Intrinsics.checkNotNullParameter(r10, "insideHomeCompanyFenceIds");
            this.f8567a = r8;
            this.f8568b = r9;
            this.c = r10;
            this.d = r6;
            this.e = r7;
        }

        public final Set<String> a() {
            return this.f8567a;
        }

        public final Set<String> b() {
            return this.f8568b;
        }

        public final Set<String> c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0432b.class) == true) goto L8;
            return false;
        L8:
            C0432b r6 = (C0432b) ZeusTransformUtils.preCheckCast(r5, C0432b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8567a, r6.f8567a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8568b, r6.f8568b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f8567a.hashCode() * 31) + this.f8568b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
        }

        public String toString() {
            return "CaeGeoFenceSnapshot(insideGeoFenceIds=" + this.f8567a + ", insideOuterBoundaryFenceIds=" + this.f8568b + ", insideHomeCompanyFenceIds=" + this.c + ", homeCompanyComplete=" + this.d + ", totalFenceCount=" + this.e + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8569a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f8570b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;

        static {
            int[] r0 = new int[AoiBoard.Event.values().length];
            r0[AoiBoard.Event.ENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[AoiBoard.Event.EXIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L6:
            f8569a = r0;
            int[] r1 = new int[AoiBoard.Type.values().length];
            r1[AoiBoard.Type.AIRPORT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L47:
            r1[AoiBoard.Type.TRAIN_STATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L37:
            r1[AoiBoard.Type.SUBWAY_STATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L39:
            r1[AoiBoard.Type.MALL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L11:
            f8570b = r1;
            int[] r2 = new int[StarGeofence.GeoState.values().length];
            r2[StarGeofence.GeoState.INSIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L29:
            r2[StarGeofence.GeoState.OUTSIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L14:
            c = r2;
            int[] r3 = new int[StarGeofence.GeoEvent.values().length];
            r3[StarGeofence.GeoEvent.ENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L43:
            r3[StarGeofence.GeoEvent.EXIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L17:
            d = r3;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/awareness/cae/CaeLocationAware$aoiBoardCallback$1", "Lcom/obric/cae/libs/location/poi/IStarAoiBoardCallback$Stub;", "onAoiBoardBreachReport", "", "aoiBoard", "Lcom/obric/cae/libs/location/poi/AoiBoard;", "location", "Landroid/location/Location;", "event", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends com.obric.cae.libs.location.poi.a.AbstractBinderC0337a {
        d() {
        }

        private static final Unit a(AoiBoard r1, int r2) {
            b.a(b.f8563a, r1, r2);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$kRS9OHry4Hk7WDmEVpP9IedAG6o(AoiBoard r0, int r1) {
            return a(r0, r1);
        }

        @Override // com.obric.cae.libs.location.poi.a
        public void a(final AoiBoard r7, Location r8, final int r9) {
            if (b.h(b.f8563a) == true) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "ignore AOI board event: transport hub AOI unsupported", false, 4, null);
            return;
        L6:
            RunLog r6 = RunLog.INSTANCE;
            StringBuilder r0 = new StringBuilder().append("收到原始 AOI 回调，poiId=");
            AoiBoard.State r1 = null;
            if (r7 == null) goto L9;
            String r2 = r7.getPoiId();
        L10:
            StringBuilder r3 = r0.append(r2).append("，type=");
            if (r7 == null) goto L13;
            AoiBoard.Type r4 = r7.getType();
        L14:
            StringBuilder r5 = r3.append(r4).append("，eventCode=").append(r9).append("，state=");
            if (r7 == null) goto L17;
            r1 = r7.getCurState();
        L17:
            r6.debug("CaeLocationAware", r5.append(r1).toString());
            if (b.c(b.f8563a).d() == true) goto L21;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "围栏运行环境未就绪，忽略实时 AOI 变化，eventCode=" + r9, false, 4, null);
            return;
        L21:
            b.a(b.f8563a, new $$Lambda$b$d$kRS9OHry4Hk7WDmEVpP9IedAG6o(r7, r9));
            return;
        L13:
            r4 = null;
            goto L14
        L9:
            r2 = null;
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/awareness/cae/CaeLocationAware$deathRecipient$1", "Landroid/os/IBinder$DeathRecipient;", "binderDied", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements IBinder.DeathRecipient {
        e() {
        }

        private static final Unit a() {
            ae<Boolean> r0 = b.f8563a.c();
        L3:
            Boolean r1 = r0.c();
            ((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (r0.a(r1, false) == false) goto L3;
            ae<Boolean> r2 = b.f8563a.d();
        L6:
            Boolean r3 = r2.c();
            ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (r2.a(r3, false) == false) goto L6;
            b r4 = b.f8563a;
            b.a(null);
            ServiceConnection r5 = b.r();
            if (r5 == null) goto L16;
            ZeusTransformUtils.unbindService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, "com.obric.memorydata.plugin");
            return Unit.INSTANCE;
        L16:
            return null;
        }

        private static final void b() {
            b.i(b.f8563a);
        }

        public static /* synthetic */ void lambda$9YgYNds0TwoOMsYFb9SSaulVdt4() {
            b();
        }

        /* JADX INFO: renamed from: lambda$qKOTWYwCbKktG7pgJq3i-t2fQ9A, reason: not valid java name */
        public static /* synthetic */ Unit m489lambda$qKOTWYwCbKktG7pgJq3it2fQ9A() {
            return a();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "binderDied", null, 4, null);
            b.a(b.f8563a, b.n());
            com.obric.memorydata.awareness.cae.c.f8571a.a();
            b.a(b.f8563a, b.o());
            com.obric.cae.libs.location.geofence.b r0 = b.n();
            if (r0 == null) goto L7;
            IBinder r1 = r0.asBinder();
            if (r1 == null) goto L7;
            r1.unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(this, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);
        L7:
            b r9 = b.f8563a;
            b.a(null);
            b r2 = b.f8563a;
            b.a(null);
            b.p().clear();
            GeoFenceCallbackPolicy.f8500a.a();
            b.a(b.f8563a);
            b.b(b.f8563a);
            b.f8563a.a("location service binder died");
            b.c(b.f8563a).b("CAE location service binder died");
            y.a(null, $$Lambda$b$e$qKOTWYwCbKktG7pgJq3it2fQ9A.INSTANCE, 1, null);
            b r3 = b.f8563a;
            b.a(null);
            GlobalHandlerUtil.Companion.getInstance().postDelay(6000, $$Lambda$b$e$9YgYNds0TwoOMsYFb9SSaulVdt4.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/awareness/cae/CaeLocationAware$geofenceCallback$1", "Lcom/obric/cae/libs/location/geofence/IStarGeofenceCallback$Stub;", "onBreachReport", "", "geofenceId", "", "location", "Landroid/location/Location;", "event", "", "onGeofenceStatusReport", "status", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends com.obric.cae.libs.location.geofence.a.AbstractBinderC0330a {
        f() {
        }

        @Override // com.obric.cae.libs.location.geofence.a
        public void a(int r3, Location r4) {
            RunLog.INSTANCE.debug("CaeLocationAware", "onGeofenceStatusReport status=" + r3 + " geoState=" + ((StarGeofence.GeoState) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(StarGeofence.GeoState.values(), r3), StarGeofence.GeoState.class, "com.obric.memorydata.plugin")));
        }

        @Override // com.obric.cae.libs.location.geofence.a
        public void a(String r7, Location r8, int r9) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L5;
        L8:
            boolean r10 = true;
        L9:
            if (r10 == false) goto L12;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "onBreachReport geofenceId is null", null, 4, null);
            return;
        L12:
            StarGeofence.GeoEvent r11 = (StarGeofence.GeoEvent) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(StarGeofence.GeoEvent.values(), r9), StarGeofence.GeoEvent.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L15;
            r11 = StarGeofence.GeoEvent.UNKNOWN;
        L15:
            RunLog.INSTANCE.debug("CaeLocationAware", "收到原始围栏回调，geofenceId=" + r7 + "，eventCode=" + r9 + "，transitionEvent=" + r11 + "，location=" + r8);
            if (b.c(b.f8563a).d() == true) goto L20;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "围栏运行环境未就绪，忽略实时围栏变化，geofenceId=" + r7 + "，event=" + r11, false, 4, null);
            return;
        L20:
            if (b.a(b.f8563a, r7) == false) goto L26;
            if (b.q() == false) goto L26;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "AOI 能力可用，忽略交通枢纽圆形围栏回调，event=" + r11, false, 4, null);
            return;
        L26:
            if (Intrinsics.areEqual(r7, "company_fence") == true) goto L28;
        L31:
            b.f8563a.a(r7, r11);
            return;
        L28:
            if (b.f8563a.h() == false) goto L31;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "公司位置由交通枢纽 AOI 维护，忽略圆形公司围栏回调，event=" + r11, false, 4, null);
            return;
        L5:
            if (StringsKt.isBlank(r6) == true) goto L8;
            r10 = false;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/awareness/cae/CaeLocationAware$geofenceRecoverReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends PluginBroadcastReceiver {
        g() {
        }

        private static final void a() {
            GeofenceRuntimeAvailabilityManager.a(b.c(b.f8563a), "CAE geofence recover completed", 0, 2, null);
            if (((Boolean) ZeusTransformUtils.preCheckCast(b.f8563a.c().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
            if (b.n() == null) goto L8;
            b.d(b.f8563a);
        L8:
            if (((Boolean) ZeusTransformUtils.preCheckCast(b.f8563a.c().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L10;
            return;
        L10:
            if (b.f(b.f8563a) == false) goto L14;
            b.c(b.f8563a).a("CAE geofence recover completed");
            return;
        }

        public static /* synthetic */ void lambda$z9ePCQSo8h5oLLfEOqxACaUwT6c() {
            a();
        }

        public void onReceive(Context r7, Intent r8) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L5;
            String r9 = r8.getAction();
        L7:
            if (Intrinsics.areEqual(r9, "com.obric.cae.location.GEOFENCE_RECOVER_COMPLETED") == false) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "geofence recover completed", false, 4, null);
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$b$g$z9ePCQSo8h5oLLfEOqxACaUwT6c.INSTANCE);
            return;
        L10:
            return;
        L5:
            r9 = null;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class h<T> implements Comparator {
        public h() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((AoiBoard) ZeusTransformUtils.preCheckCast(r2, AoiBoard.class, "com.obric.memorydata.plugin")).getEventTime()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((AoiBoard) ZeusTransformUtils.preCheckCast(r3, AoiBoard.class, "com.obric.memorydata.plugin")).getEventTime()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/awareness/cae/CaeLocationAware$newLocationConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "className", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "arg0", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class i implements ServiceConnection {
        i() {
        }

        private static final void a() {
            if (((Boolean) ZeusTransformUtils.preCheckCast(b.f8563a.c().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L31;
            return;
        L31:
            b r0 = b.f8563a;     // Catch: Throwable -> L28
            com.obric.cae.libs.location.b r1 = b.m();     // Catch: Throwable -> L28
            String r2 = null;
            if (r1 == null) goto L8;
            com.obric.cae.libs.location.geofence.b r3 = r1.b();     // Catch: Throwable -> L28
        L9:
            b.a(r3);     // Catch: Throwable -> L28
            com.obric.cae.libs.location.geofence.b r4 = b.n();     // Catch: Throwable -> L28
            if (r4 == null) goto L12;
            r2 = r4.getVendorVersion();     // Catch: Throwable -> L28
        L12:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "SDK and Service Version:" + r2, false, 4, null);     // Catch: Throwable -> L28
            if (b.n() != null) goto L15;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "Geofence manager is unavailable after service connected", null, 4, null);     // Catch: Throwable -> L28
        L16:
            ae<Boolean> r5 = b.f8563a.d();     // Catch: Throwable -> L28
        L17:
            Boolean r6 = r5.c();     // Catch: Throwable -> L28
            ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L28
            if (b.n() == null) goto L20;
            boolean r7 = true;
        L22:
            if (r5.a(r6, Boolean.valueOf(r7)) == false) goto L17;
            b.e(b.f8563a);     // Catch: Throwable -> L28
            if (b.f(b.f8563a) == false) goto L26;
            b.c(b.f8563a).a("CAE location service connected");     // Catch: Throwable -> L28
            return;
        L26:
            b.c(b.f8563a).b("CAE location snapshot source unavailable");     // Catch: Throwable -> L28
            return;
        L20:
            r7 = false;
            goto L22
        L15:
            b.d(b.f8563a);     // Catch: Throwable -> L28
            b.b(b.f8563a, b.n());     // Catch: Throwable -> L28
            goto L16
        L8:
            r3 = null;
        L28:
            th = move-exception;
            b.c(b.f8563a).b("CAE location service initialization failed");
            RunLog.INSTANCE.warn("CaeLocationAware", "async init onServiceConnected failed", th);
        }

        /* JADX INFO: renamed from: lambda$7dWdt4lNSivcKDfoUclUgm-wqJQ, reason: not valid java name */
        public static /* synthetic */ void m490lambda$7dWdt4lNSivcKDfoUclUgmwqJQ() {
            a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r8, IBinder r9) {
            IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r9, IBinder.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "className");
            Intrinsics.checkNotNullParameter(r7, "service");
            b r10 = b.f8563a;
            b.a(com.obric.cae.libs.location.b.a.a(r7));
            b.a(b.f8563a);
            r7.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(b.l(), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: RemoteException -> L8
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "CaeLocationAware is Connected!", false, 4, null);     // Catch: RemoteException -> L8
            ae<Boolean> r11 = b.f8563a.c();     // Catch: RemoteException -> L8
        L4:
            Boolean r12 = r11.c();     // Catch: RemoteException -> L8
            ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: RemoteException -> L8
            if (r11.a(r12, true) == false) goto L4;
            com.obric.memorydata.awareness.cae.c.f8571a.a(b.m());     // Catch: RemoteException -> L8
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$b$i$7dWdt4lNSivcKDfoUclUgmwqJQ.INSTANCE);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            e.printStackTrace();
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", e.toString(), null, 4, null);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r8) {
            Intrinsics.checkNotNullParameter(r8, "arg0");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "CaeLocationAware is Disconnected!", false, 4, null);
            b.a(b.f8563a, b.n());
            com.obric.memorydata.awareness.cae.c.f8571a.a();
            b.a(b.f8563a, b.o());
            ae<Boolean> r7 = b.f8563a.c();
        L3:
            Boolean r9 = r7.c();
            ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (r7.a(r9, false) == false) goto L3;
            ae<Boolean> r10 = b.f8563a.d();
        L6:
            Boolean r11 = r10.c();
            ((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            if (r10.a(r11, false) == false) goto L6;
            b r12 = b.f8563a;
            b.a(null);
            b r13 = b.f8563a;
            b.a(null);
            b r14 = b.f8563a;
            b.a(null);
            b.p().clear();
            GeoFenceCallbackPolicy.f8500a.a();
            b.a(b.f8563a);
            b.b(b.f8563a);
            b.f8563a.a("location service disconnected");
            b.c(b.f8563a).b("CAE location service disconnected");
        }
    }

    static {
        f8563a = new b();
        f8564b = LazyKt.lazy($$Lambda$b$yLtKIiZkBh6Ft2txskmG20IEbck.INSTANCE);
        d = $$Lambda$b$cmM4oSphxjC9pj83hV1G7bvSi8k.INSTANCE;
        h = LazyKt.lazy($$Lambda$b$6YztBGWnX3bvB6H3MQ1Sixc011c.INSTANCE);
        i = new Object();
        r = Executors.newSingleThreadExecutor($$Lambda$b$CRWuktmVDQuKefPKwzORBmjiNUo.INSTANCE);
        s = at.a(false);
        t = at.a(false);
        u = ConcurrentHashMap.newKeySet();
        v = CollectionsKt.listOf(new AoiBoard.Type[]{AoiBoard.Type.AIRPORT, AoiBoard.Type.TRAIN_STATION});
        w = CollectionsKt.listOf(new AoiBoard.Type[]{AoiBoard.Type.AIRPORT, AoiBoard.Type.TRAIN_STATION, AoiBoard.Type.SUBWAY_STATION, AoiBoard.Type.MALL});
        x = new g();
        y = new ConcurrentHashMap();
        z = (com.obric.cae.libs.location.geofence.a) ZeusTransformUtils.preCheckCast(new f(), com.obric.cae.libs.location.geofence.a.class, "com.obric.memorydata.plugin");
        A = (com.obric.cae.libs.location.poi.a) ZeusTransformUtils.preCheckCast(new d(), com.obric.cae.libs.location.poi.a.class, "com.obric.memorydata.plugin");
        C = new e();
    }

    private b() {
    }

    private final void A() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(s.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
    L19:
        t().b("位置快照读取前 CAE 通道不可用");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "位置快照通道不可用，本轮对账已终止", false, 4, null);
        return;
    L5:
        if (B() == false) goto L19;
        if (t().e() == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "位置快照条件尚未满足，本轮暂不读取", false, 4, null);
        return;
    L11:
        boolean r0 = u();
        com.obric.memorydata.awareness.impl.location.c.f8736a.a(r0, (Function0) ZeusTransformUtils.preCheckCast(new CaeLocationAware$startLocationSnapshotReconciliation$1(t()), Function0.class, "com.obric.memorydata.plugin"));
        if (r0 == true) goto L14;
    L17:
        C();
        return;
    L14:
        if (g == null) goto L17;
        a($$Lambda$b$xW7tlJLwoOln6trKuPD0mULwMmk.INSTANCE);
    }

    private final boolean B() {
        if (f != null) goto L6;
        return false;
    L6:
        if (u() == true) goto L8;
    L9:
        return true;
    L8:
        if (g != null) goto L9;
        return false;
    }

    private final void C() {
        if (t().e() == true) goto L5;
        return;
    L5:
        C0432b r0 = E();
        if (r0 != null) goto L9;
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).t().b("CAE 围栏快照读取失败");
        return;
    L9:
        com.obric.memorydata.awareness.impl.location.c.f8736a.a((Collection) ZeusTransformUtils.preCheckCast(r0.a(), Collection.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(r0.b(), Collection.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.awareness.impl.location.c.f8736a.a((Collection) ZeusTransformUtils.preCheckCast(r0.c(), Collection.class, "com.obric.memorydata.plugin"), r0.d());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "CAE 围栏恢复快照读取完成，fenceSize=" + r0.e() + "，insideGeoFenceSize=" + r0.a().size() + "，outerInsideSize=" + r0.b().size() + "，insideHomeCompanySize=" + r0.c().size() + "，homeCompanyComplete=" + r0.d(), false, 4, null);
    }

    private final void D() {
        final com.obric.cae.libs.location.geofence.b r1 = f;
        if (r1 != null) goto L5;
        return;
    L5:
        List<? extends StarGeofence> r2 = null;
        List<StarGeofence> r3 = r1.listGeofences(AppContext.INSTANCE.getPackageName());     // Catch: ArrayIndexOutOfBoundsException -> L10
        if (r3 == null) goto L12;
        r2 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: ArrayIndexOutOfBoundsException -> L10
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L16:
        if (r6.hasNext() == false) goto L23;
        Object r7 = r6.next();
        StarGeofence r8 = (StarGeofence) ZeusTransformUtils.preCheckCast(r7, StarGeofence.class, "com.obric.memorydata.plugin");
        DualBoundaryGeofence r9 = DualBoundaryGeofence.f8549a;
        String r10 = r8.getGeofenceId();
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        if (r9.d(r10) == true) goto L16;
        r5.add(r7);
        goto L16
    L23:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new HashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L29;
        String r15 = ((StarGeofence) ZeusTransformUtils.preCheckCast(r14.next(), StarGeofence.class, "com.obric.memorydata.plugin")).getGeofenceId();
        if (r15 == null) goto L25;
        r13.add(r15);
        goto L25
    L29:
        HashSet r16 = (HashSet) ZeusTransformUtils.preCheckCast(r13, HashSet.class, "com.obric.memorydata.plugin");
        u.clear();
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r18 = 0;
    L31:
        if (r17.hasNext() == false) goto L42;
        final StarGeofence r19 = (StarGeofence) ZeusTransformUtils.preCheckCast(r17.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        final String r20 = r19.getGeofenceId();
        if (r20 == null) goto L31;
        Boolean r21 = (Boolean) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$b$SmvwWuEiuzEtdDcmvcRodv84uZ0(r20), new $$Lambda$b$uRMNnAenI7caLINwqdIDmUzF50M(r1, r19)), Boolean.class, "com.obric.memorydata.plugin");
        if (r21 == null) goto L38;
        boolean r22 = r21.booleanValue();
    L39:
        if (r22 == true) goto L40;
        f8563a.a(r1, r20);
        goto L31
    L40:
        u.add(r20);
        r18 = r18 + 1;
        goto L31
    L38:
        r22 = false;
        goto L39
    L42:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "普通围栏双边界补齐完成，logicalCount=" + r11.size() + "，readyCount=" + r18 + "，orphanRemoved=" + a(r1, r2, (Set) ZeusTransformUtils.preCheckCast(r16, Set.class, "com.obric.memorydata.plugin")), false, 4, null);
        return;
    L10:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "reconcile dual-boundary geofences failed: malformed list, " + e, null, 4, null);
        goto L12
    }

    private final C0432b E() {
        com.obric.cae.libs.location.geofence.b r14 = f;
        if (r14 != null) goto L6;
        return null;
    L6:
        if (r14.asBinder().isBinderAlive() == true) goto L76;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "Geofence manager is not alive while reading bootstrap snapshot", null, 4, null);
        return null;
    L76:
        List<StarGeofence> r15 = r14.listGeofences(AppContext.INSTANCE.getPackageName());     // Catch: ArrayIndexOutOfBoundsException -> L11 RemoteException -> L14
    L16:
        if (r15 != null) goto L18;
        return null;
    L18:
        List r1 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L20:
        if (r5.hasNext() == false) goto L27;
        StarGeofence r6 = (StarGeofence) ZeusTransformUtils.preCheckCast(r5.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        String r7 = r6.getGeofenceId();
        if (r7 == null) goto L24;
        Pair r8 = TuplesKt.to(r7, r6);
    L25:
        if (r8 == null) goto L20;
        r4.add(r8);
        goto L20
    L24:
        r8 = null;
        goto L25
    L27:
        Map r9 = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        LinkedHashSet r10 = new LinkedHashSet();
        LinkedHashSet r11 = new LinkedHashSet();
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r13 = true;
    L29:
        if (r2.hasNext() == false) goto L75;
        StarGeofence r16 = (StarGeofence) ZeusTransformUtils.preCheckCast(r2.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("CaeLocationAware", "读取启动围栏快照，geofenceId=" + r16.getGeofenceId() + "，geoState=" + r16.getGeoState() + "，geoType=" + r16.getGeoType() + "，transitionType=" + r16.getTransitionType());
        String r17 = r16.getGeofenceId();
        if (r17 == null) goto L29;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L35;
    L37:
        boolean r18 = false;
    L38:
        if (r18 == true) goto L41;
        r17 = null;
    L41:
        if (r17 == null) goto L29;
        if (DualBoundaryGeofence.f8549a.d(r17) == true) goto L29;
        if (r16.getGeoState() != StarGeofence.GeoState.INSIDE) goto L49;
        r10.add(r17);
    L49:
        if (u.contains(r17) == false) goto L57;
        StarGeofence r19 = (StarGeofence) ZeusTransformUtils.preCheckCast(r9.get(DualBoundaryGeofence.f8549a.b(r17)), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L53;
        StarGeofence.GeoState r110 = r19.getGeoState();
    L55:
        if (r110 != StarGeofence.GeoState.INSIDE) goto L57;
        r11.add(r17);
        goto L57
    L53:
        r110 = null;
    L57:
        boolean r111 = com.obric.memorydata.awareness.impl.location.b.f8730a.c(r17);
        if (Intrinsics.areEqual(r17, "company_fence") == true) goto L60;
    L62:
        boolean r112 = false;
    L63:
        if (r111 == false) goto L29;
        if (r112 == true) goto L29;
        StarGeofence.GeoState r20 = r16.getGeoState();
        if (r20 != null) goto L68;
        int r21 = -1;
    L69:
        if (r21 != 1) goto L71;
        r12.add(r17);
        goto L29
    L71:
        if (r21 == 2) goto L29;
        r13 = false;
        goto L29
    L68:
        r21 = c.c[r20.ordinal()];
        goto L69
    L60:
        if (f8563a.h() == false) goto L62;
        r112 = true;
        goto L63
    L35:
        if (Intrinsics.areEqual(r17, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == false) goto L37;
        r18 = true;
        goto L38
    L75:
        return new C0432b((Set) ZeusTransformUtils.preCheckCast(r10, Set.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r11, Set.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.preCheckCast(r12, Set.class, "com.obric.memorydata.plugin"), r13, r15.size());
    L14:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "listGeofences failed while reading bootstrap snapshot: " + e, null, 4, null);
        r15 = null;
    L11:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "listGeofences returned malformed bootstrap data: " + e, null, 4, null);
        return new C0432b(SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), false, 0);
    }

    private final void F() {
        if (c == false) goto L5;
        return;
    L5:
        c = true;
        com.obric.memorydata.b.a.f8796a.a(d);
    }

    private final void G() {
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        final Intent r2 = new Intent("com.obric.cae.libs.location.IStarLocationService");
        if (f8563a.s() == false) goto L5;
        String r3 = UserAwareUtil.PACKAGE_NAME_CAE;
    L6:
        r2.setPackage(r3);
        r2.setComponent(new ComponentName(r3, "com.obric.cae.location.StarLocationService"));
        if (s() == true) goto L9;
        y.a($$Lambda$b$aw3BvQtE6esHIwiQ51iuh3B7ys.INSTANCE, new $$Lambda$b$N5ftzJcmYsR9axP1YNXgnatS7A(r0, r2));
    L9:
        ServiceConnection r4 = B;
        if (r4 != null) goto L12;
        r4 = y();
        B = r4;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "Binding location service result: " + ZeusTransformUtils.bindService(r0, r2, r4, 1, "com.obric.memorydata.plugin"), false, 4, null);
        return;
    L5:
        r3 = AppContext.INSTANCE.getPackageName();
        goto L6
    }

    private static final boolean H() {
        PackageManager r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        Intent r2 = new Intent("com.obric.cae.libs.location.IStarLocationService").setPackage(UserAwareUtil.PACKAGE_NAME_CAE);
        Intrinsics.checkNotNullExpressionValue(r2, "setPackage(...)");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        List<ResolveInfo> r1 = r0.queryIntentServices(r2, PackageManager.ResolveInfoFlags.of(0));
    L6:
        Intrinsics.checkNotNull(r1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "queryIntentServices resolveInfo=" + r1, false, 4, null);
        return !((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    L5:
        r1 = r0.queryIntentServices(r2, 0);
        goto L6
    }

    private static final boolean I() {
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(y.a(null, $$Lambda$b$fRxS3hKe4dX1O5CfI8DvNM6Ji8.INSTANCE, 1, null), Boolean.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    private static final Unit J() {
        b r0 = f8563a;
        if (r0.j() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "location permission changed, retry CaeLocationAware init", false, 4, null);
        r0.i();
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit K() {
        ThreadPoolContainer r0 = ThreadPoolContainer.Companion.getInstance();
        final b r1 = f8563a;
        r0.execute(new $$Lambda$b$kAXvT6MwnbA1JfW4_l5XHtej9Ig(r1));
        return Unit.INSTANCE;
    }

    private static final GeofenceRuntimeAvailabilityManager L() {
        return GeofenceRuntimeAvailabilityManager.f8718a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), $$Lambda$b$U5EEBCJqZ5olZrXw61agaVYhBq8.INSTANCE, (Function0) ZeusTransformUtils.preCheckCast(new CaeLocationAware$geofenceRuntimeAvailabilityManager$2$2(com.obric.memorydata.awareness.impl.location.c.f8736a), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new CaeLocationAware$geofenceRuntimeAvailabilityManager$2$3(com.obric.memorydata.awareness.impl.location.b.f8730a), Function0.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit M() {
        b r0 = f8563a;
        if (r0.t().e() == false) goto L6;
        a(r0, 0, (Function0) ZeusTransformUtils.preCheckCast(new CaeLocationAware$startLocationSnapshotReconciliation$2$1(r0), Function0.class, "com.obric.memorydata.plugin"), 1, null);
    L6:
        return Unit.INSTANCE;
    }

    private final byte a(com.obric.cae.libs.location.geofence.b r13, StarGeofence r14, String r15, double r16, double r18, int r20, StarGeofence.GeoTransitionType r21, StarGeofence.GeoType r22) {
        com.obric.cae.libs.location.geofence.b r2 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L6;
        StarGeofence r0 = new StarGeofence(AppContext.INSTANCE.getPackageName(), r15, r16, r18, r20, r21);
        r0.setGeoType(r22);
        return r2.addGeofence(r0);
    L6:
        r14.setLatitude(r16);
        r14.setLongitude(r18);
        r14.setRadius(r20);
        r14.setTransitionType(r21);
        r14.setGeoType(r22);
        r14.setAddress("");
        return r2.updateGeofence(r14);
    }

    private final int a(com.obric.cae.libs.location.geofence.b r5, List<? extends StarGeofence> r6, Set<String> r7) {
        com.obric.cae.libs.location.geofence.b r4 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L18;
        StarGeofence r1 = (StarGeofence) ZeusTransformUtils.preCheckCast(r10.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        String r2 = r1.getGeofenceId();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        if (DualBoundaryGeofence.f8549a.d(r2) == false) goto L4;
        DualBoundaryGeofence.a r3 = DualBoundaryGeofence.f8549a.c(r2);
        if (r3 == null) goto L16;
        if (r9.contains(r3.a()) == true) goto L4;
    L16:
        if (f8563a.a(r4, r1, "orphan_cleanup") == false) goto L4;
        r11 = r11 + 1;
        goto L4
    L18:
        return r11;
    }

    private final StarGeofence a(AoiBoard r11, boolean r12) {
        Location r10 = x();
        String r1 = AppContext.INSTANCE.getPackageName();
        double r2 = 0.0d;
        if (r10 == null) goto L5;
        double r4 = r10.getLatitude();
    L6:
        if (r10 == null) goto L8;
        r2 = r10.getLongitude();
    L8:
        StarGeofence r9 = new StarGeofence(r1, "company_fence", r4, r2, 0, StarGeofence.GeoTransitionType.ENTERED_AND_EXITED);
        r9.setGeoType(StarGeofence.GeoType.COMPANY);
        if (r12 == false) goto L11;
        StarGeofence.GeoState r13 = StarGeofence.GeoState.INSIDE;
    L12:
        r9.setGeoState(r13);
        Long r14 = Long.valueOf(r11.getEventTime());
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L15;
        boolean r15 = true;
    L17:
        if (Boolean.valueOf(r15).booleanValue() == true) goto L20;
        r14 = null;
    L20:
        if (r14 == null) goto L22;
        long r0 = r14.longValue();
    L23:
        r9.setEventTimestamp(r0);
        String r16 = r11.getPoiId();
        String r17 = "";
        if (r16 != null) goto L26;
        r16 = "";
    L26:
        r9.setPoiId(r16);
        String r18 = r11.getPoiName();
        if (r18 == null) goto L30;
        r17 = r18;
    L30:
        r9.setAddress(r17);
        return r9;
    L22:
        r0 = System.currentTimeMillis();
        goto L23
    L15:
        r15 = false;
        goto L17
    L11:
        r13 = StarGeofence.GeoState.OUTSIDE;
        goto L12
    L5:
        r4 = 0.0d;
        goto L6
    }

    private final a a(AoiBoard r2) {
        String r0 = a(r2.getType());
        if (r0 != null) goto L6;
        return null;
    L6:
        Integer r1 = b(r2);
        if (r1 == null) goto L9;
        int r3 = r1.intValue();
    L11:
        return new a(r0, r3);
    L9:
        r3 = 0;
        goto L11
    }

    private final String a(AoiBoard.Type r1) {
        if (r1 != null) goto L4;
        int r0 = -1;
    L6:
        if (r0 != 1) goto L8;
        return "airport";
    L8:
        if (r0 != 2) goto L10;
        return "railway_station";
    L10:
        if (r0 != 3) goto L12;
        return "subway_station";
    L12:
        if (r0 == 4) goto L14;
        return null;
    L14:
        return "mall";
    L4:
        r0 = c.f8570b[r1.ordinal()];
        goto L6
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "transport_hub_aoi_event");
    }

    static /* synthetic */ List a(b r1, List r2, int r3, Object r4) {
        List<AoiBoard> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.b(g);
    L6:
        return r1.b(r5);
    }

    private static final Unit a(Context r8, Intent r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Field r0 = UserHandle.class.getDeclaredField("SYSTEM");
        r0.setAccessible(true);
        Object r1 = r0.get(null);
        Method r3 = Context.class.getMethod("startServiceAsUser", new Class[]{Intent.class, UserHandle.class});
        r3.setAccessible(true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "startLocationServiceAsUser result: " + r3.invoke(r10, new Object[]{r9, r1}), false, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit a(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        RunLog.INSTANCE.warn("CaeLocationAware", "startLocationService failed", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final void a(final int r20, Function0<Unit> r21) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        if (u() == true) goto L6;
        t().b("AOI support changed during snapshot collection");
        return;
    L6:
        com.obric.cae.libs.location.poi.b r5 = g;
        if (r5 != null) goto L11;
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).t().b("AOI snapshot source unavailable");
        return;
    L11:
        if (((Boolean) ZeusTransformUtils.preCheckCast(s.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L15;
        t().b("CAE disconnected during AOI snapshot collection");
        return;
    L15:
        if (c(r5) == false) goto L17;
        List<AoiBoard> r1 = b(r5);
        if (r1 != null) goto L26;
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).t().b("AOI snapshot read failed");
        return;
    L26:
        List<AoiBoard> r2 = b(r1);
        if (r2 != null) goto L29;
        r2 = CollectionsKt.emptyList();
    L29:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L30:
        boolean r9 = false;
        com.obric.memorydata.awareness.impl.location.b.a r10 = null;
        if (r8.hasNext() == false) goto L70;
        AoiBoard r11 = (AoiBoard) ZeusTransformUtils.preCheckCast(r8.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r11.getCurState() != AoiBoard.State.INSIDE) goto L68;
        String r13 = f8563a.a(r11.getType());
        if (r13 == null) goto L68;
        String r12 = r11.getPoiId();
        if (r12 == null) goto L68;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L43;
        String r14 = r12;
    L44:
        if (r14 == null) goto L68;
        RunLog.INSTANCE.debug("CaeLocationAware", "恢复交通枢纽 AOI 快照，aoiId=" + r14 + "，type=" + r13);
        String r15 = r11.getPoiName();
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L49;
    L51:
        Iterator r17 = r16.iterator();
    L53:
        if (r17.hasNext() == false) goto L50;
        if (f8563a.a((AoiBoard) ZeusTransformUtils.preCheckCast(r17.next(), AoiBoard.class, "com.obric.memorydata.plugin"), r11) == false) goto L53;
        boolean r18 = true;
    L58:
        if (r18 == false) goto L60;
        String r19 = "company";
    L61:
        Long r22 = Long.valueOf(r11.getEventTime());
        if (((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L64;
        r9 = true;
    L64:
        if (r9 == false) goto L66;
        Long r110 = r22;
    L67:
        r10 = new com.obric.memorydata.awareness.impl.location.b.a(r13, r14, r15, r19, r110);
        goto L68
    L66:
        r110 = null;
        goto L67
    L60:
        r19 = null;
    L50:
        r18 = false;
        goto L58
    L49:
        if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L51;
    L43:
        r14 = null;
    L68:
        if (r10 == null) goto L30;
        r7.add(r10);
        goto L30
    L70:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        a(r1);
        com.obric.memorydata.awareness.impl.location.c.a(com.obric.memorydata.awareness.impl.location.c.f8736a, r4, false, 2, null);
        if (r3 == null) goto L81;
        r3.invoke();
        return;
    L81:
        return;
    L17:
        if (r20 < 5) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "Transport hub AOI recovery timed out; snapshot is incomplete", null, 4, null);
        t().b("AOI snapshot recovery timed out");
        return;
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "等待交通枢纽 AOI 恢复，retryCount=" + r20, false, 4, null);
        GlobalHandlerUtil.Companion.getInstance().postDelay(1000, new $$Lambda$b$Z0N6KTBtfV06EkK763euKsVE1wU(r20, r3));
    }

    public static final /* synthetic */ void a(ServiceConnection r2) {
        B = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r2, ServiceConnection.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(com.obric.cae.libs.location.b r2) {
        e = (com.obric.cae.libs.location.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.cae.libs.location.b.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(com.obric.cae.libs.location.geofence.b r2) {
        f = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
    }

    private final void a(com.obric.cae.libs.location.geofence.b r4, String r5) {
        com.obric.cae.libs.location.geofence.b r3 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{DualBoundaryGeofence.f8549a.a(r5), DualBoundaryGeofence.f8549a.b(r5)}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        StarGeofence r7 = r3.findGeofenceById((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        if (r7 == null) goto L4;
        f8563a.a(r3, r7, "boundary_cleanup");
        goto L4
    }

    private final void a(AoiBoard r23, int r24) {
        if (r23 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "Ignoring empty AOI callback payload", null, 4, null);
        return;
    L6:
        String r5 = b(r23.getType());
        if (r5 != null) goto L9;
        return;
    L9:
        String r3 = r23.getPoiId();
        if (r3 != null) goto L12;
    L52:
        b r0 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "Ignoring AOI callback because aoi_id is blank", null, 4, null);
        return;
    L12:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L52;
        AoiBoard.Event r4 = b(r23, r24);
        String r12 = "company";
        if (r4 != AoiBoard.Event.EXIT) goto L33;
        RunLog.INSTANCE.debug("CaeLocationAware", "准备发送 AOI 离开变化，aoiId=" + r3 + "，type=" + r5);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "收到交通枢纽 AOI 离开变化，locationType=" + r5, false, 4, null);
        boolean r1 = a(r23, r4);
        com.obric.memorydata.awareness.impl.location.b r6 = com.obric.memorydata.awareness.impl.location.b.f8730a;
        String r8 = r23.getPoiName();
        if (r1 == true) goto L23;
        r12 = null;
    L23:
        Long r2 = Long.valueOf(r23.getEventTime());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == false) goto L29;
        Long r10 = r2;
    L30:
        r6.a(r5, r3, false, r8, r12, r10);
        return;
    L29:
        r10 = null;
        goto L30
    L26:
        r7 = false;
        goto L27
    L33:
        if (r4 == AoiBoard.Event.ENTER) goto L36;
        return;
    L36:
        if (r23.getCurState() == AoiBoard.State.INSIDE) goto L39;
        RunLog.INSTANCE.debug("CaeLocationAware", "AOI 进入回调不是 INSIDE 状态，已忽略，state=" + r23.getCurState() + "，poiId=" + r23.getPoiId());
        return;
    L39:
        RunLog.INSTANCE.debug("CaeLocationAware", "准备发送 AOI 进入变化，aoiId=" + r3 + "，type=" + r5);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "收到交通枢纽 AOI 进入变化，locationType=" + r5, false, 4, null);
        boolean r9 = a(r23, r4);
        com.obric.memorydata.awareness.impl.location.b r11 = com.obric.memorydata.awareness.impl.location.b.f8730a;
        String r13 = r23.getPoiName();
        if (r9 == true) goto L43;
        r12 = null;
    L43:
        Long r14 = Long.valueOf(r23.getEventTime());
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L46;
        boolean r15 = true;
    L47:
        if (r15 == false) goto L49;
        Long r16 = r14;
    L50:
        r11.a(r5, r3, true, r13, r12, r16);
        return;
    L49:
        r16 = null;
        goto L50
    L46:
        r15 = false;
        goto L47
    }

    public static final /* synthetic */ void a(com.obric.cae.libs.location.poi.b r2) {
        g = (com.obric.cae.libs.location.poi.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.cae.libs.location.poi.b.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(b r0) {
        r0.v();
    }

    static /* synthetic */ void a(b r1, int r2, Function0 r3, int r4, Object r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        r1.a(r2, r6);
    }

    public static final /* synthetic */ void a(b r2, com.obric.cae.libs.location.geofence.b r3) {
        r2.c((com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(b r0, AoiBoard r1, int r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(b r2, com.obric.cae.libs.location.poi.b r3) {
        r2.e((com.obric.cae.libs.location.poi.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.poi.b.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(b r2, Function0 r3) {
        r2.a((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin"));
    }

    private final void a(String r10, DualBoundaryGeofence.a r11, StarGeofence.GeoEvent r12) {
        if (u.contains(r11.a()) == true) goto L7;
        RunLog.INSTANCE.debug("CaeLocationAware", "忽略未就绪的内部边界回调，fenceId=" + r11.a() + "，boundary=" + r11.b().getProtocolValue());
        return;
    L7:
        if (h(r10) == false) goto L10;
        RunLog.INSTANCE.debug("CaeLocationAware", "内部边界首次状态回调已忽略，fenceId=" + r11.a() + "，boundary=" + r11.b().getProtocolValue());
        return;
    L10:
        int r9 = c.d[r12.ordinal()];
        boolean r13 = true;
        if (r9 != 1) goto L13;
    L16:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder().append("收到双边界围栏变化，fenceId=").append(r11.a()).append("，boundary=").append(r11.b().getProtocolValue()).append("，action=");
        if (r13 == false) goto L19;
        String r15 = "enter";
    L20:
        IRunLog.a.a(r3, "CaeLocationAware", r14.append(r15).toString(), false, 4, null);
        com.obric.memorydata.awareness.impl.location.c.f8736a.a(r11.a(), r11.b().getProtocolValue(), r13);
        return;
    L19:
        r15 = "exit";
        goto L20
    L13:
        if (r9 == 2) goto L15;
        return;
    L15:
        r13 = false;
        goto L16
    }

    private final void a(String r8, boolean r9) {
        com.obric.memorydata.awareness.impl.location.c.f8736a.b(r8, r9);
        if (com.obric.memorydata.awareness.impl.location.b.f8730a.c(r8) == true) goto L5;
        return;
    L5:
        if (r9 == false) goto L7;
        GeofenceRuntimeAvailabilityManager.a(t(), "家司围栏首次状态已建立：" + r8, 0, 2, null);
    L7:
        com.obric.memorydata.awareness.cae.f.f8574a.a().a(r8);
    }

    private final void a(List<? extends AoiBoard> r12) {
        List<AoiBoard> r13 = b((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"));
        if (r13 != null) goto L6;
        return;
    L6:
        if (r13.isEmpty() == false) goto L9;
        a(false, "company not in transport hub AOI snapshot");
        a("company not in transport hub AOI snapshot");
        return;
    L9:
        a(true, "company in transport hub AOI snapshot");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        Object r5 = null;
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        if (((AoiBoard) ZeusTransformUtils.preCheckCast(r4, AoiBoard.class, "com.obric.memorydata.plugin")).getCurState() != AoiBoard.State.INSIDE) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L10;
    L19:
        AoiBoard r7 = (AoiBoard) ZeusTransformUtils.preCheckCast(r4, AoiBoard.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L23;
        RunLog.INSTANCE.debug("CaeLocationAware", "交通枢纽 AOI 快照显示已进入公司，poiId=" + r7.getPoiId());
        a(true, r7);
        return;
    L23:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r0.hasNext() == false) goto L35;
        r5 = r0.next();
        if (r0.hasNext() == false) goto L35;
        long r8 = ((AoiBoard) ZeusTransformUtils.preCheckCast(r5, AoiBoard.class, "com.obric.memorydata.plugin")).getEventTime();
    L30:
        Object r9 = r0.next();
        long r10 = ((AoiBoard) ZeusTransformUtils.preCheckCast(r9, AoiBoard.class, "com.obric.memorydata.plugin")).getEventTime();
        if (r8 >= r10) goto L34;
        r5 = r9;
        r8 = r10;
    L34:
        if (r0.hasNext() == true) goto L30;
    L35:
        AoiBoard r1 = (AoiBoard) ZeusTransformUtils.preCheckCast(r5, AoiBoard.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L38;
        r1 = (AoiBoard) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r13), AoiBoard.class, "com.obric.memorydata.plugin");
    L38:
        RunLog.INSTANCE.debug("CaeLocationAware", "交通枢纽 AOI 快照显示已离开公司，poiId=" + r1.getPoiId());
        a(false, r1);
        return;
    L15:
        r6 = false;
        goto L16
    L18:
        r4 = null;
        goto L19
    }

    private final void a(Function0<Unit> r2) {
        final Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        y.a(null, new $$Lambda$b$73Q4y6ihZ4gHlCT0Soluxd7oh_Q(r1), 1, null);
    }

    private final void a(boolean r8, AoiBoard r9) {
        Object r0 = i;
        monitor-enter(r0);
        boolean r2 = false;
        if (Intrinsics.areEqual(j, Boolean.valueOf(r8)) == false) goto L8;
        RunLog.INSTANCE.debug("CaeLocationAware", "company fence AOI state unchanged enter=" + r8 + ", poiId=" + r9.getPoiId());     // Catch: Throwable -> L37
        boolean r1 = false;
    L9:
        monitor-exit(r0);
        if (r1 == true) goto L12;
        return;
    L12:
        StarGeofence r3 = a(r9, r8);
        if (r8 == false) goto L15;
        a r4 = a(r9);
    L16:
        monitor-enter(r0);
    L34:
        th = move-exception;
        throw th;
    L18:
        if (Intrinsics.areEqual(j, Boolean.valueOf(r8)) == false) goto L20;
        RunLog.INSTANCE.debug("CaeLocationAware", "company fence AOI state unchanged enter=" + r8 + ", poiId=" + r9.getPoiId());     // Catch: Throwable -> L34
    L22:
        monitor-exit(r0);
        if (r2 == true) goto L25;
        return;
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "notify company fence by transport hub AOI enter=" + r8 + ", poiId=" + r9.getPoiId() + ", type=" + r9.getType(), false, 4, null);
        if (t().d() == true) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "位置恢复期间仅同步公司 AOI 围栏状态，不通知预测，enter=" + r8, false, 4, null);
        return;
    L29:
        com.obric.memorydata.awareness.cae.d r7 = com.obric.memorydata.awareness.cae.f.f8574a.a().c();
        if (r8 == false) goto L32;
        r7.a("company_fence");
        return;
    L32:
        r7.b("company_fence");
        return;
    L20:
        j = Boolean.valueOf(r8);     // Catch: Throwable -> L34
        k = r3;     // Catch: Throwable -> L34
        l = r4;     // Catch: Throwable -> L34
        r2 = true;
        goto L22
    L15:
        r4 = null;
        goto L16
    L8:
        r1 = true;
    L37:
        th = move-exception;
        throw th;
    }

    private final void a(boolean r7, String r8) {
        if (m != r7) goto L5;
        return;
    L5:
        m = r7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "company fence handled by transport hub AOI cached=" + r7 + ", reason=" + r8, false, 4, null);
    }

    private final boolean a(double r3, double r5) {
        if (Double.isNaN(r3) == false) goto L5;
    L19:
        return false;
    L5:
        if (Double.isNaN(r5) == true) goto L19;
        if (Double.isInfinite(r3) == true) goto L19;
        if (Double.isInfinite(r5) == true) goto L19;
        if (r3 < (-90.0d)) goto L19;
        if (r3 > 90.0d) goto L19;
        if (r5 < (-180.0d)) goto L19;
        if (r5 > 180.0d) goto L19;
        return true;
    }

    private final boolean a(StarGeofence r3, double r4, double r6, int r8, StarGeofence.GeoTransitionType r9) {
        if (r3.getLatitude() != r4) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L18;
        if (r3.getLongitude() != r6) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L18;
        if (r3.getRadius() != r8) goto L18;
        if (r3.getTransitionType() != r9) goto L18;
        return true;
    L10:
        r5 = false;
    L18:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    private static final boolean a(com.obric.cae.libs.location.geofence.b r19, double r20, double r22, String r24, int r25, int r26, com.obric.memorydata.awareness.cae.d r27) {
        com.obric.cae.libs.location.geofence.b r5 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r19, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.cae.d r12 = (com.obric.memorydata.awareness.cae.d) ZeusTransformUtils.wrapperContextForParams(r27, com.obric.memorydata.awareness.cae.d.class, "com.obric.memorydata.plugin");
        if (r5.asBinder().isBinderAlive() == true) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "addGeofence geofenceManager not alive", null, 4, null);
        return false;
    L6:
        b r6 = f8563a;
        Location r7 = r6.b(r20, r22);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "addGeofence: " + r24, false, 4, null);
        RunLog.INSTANCE.debug("CaeLocationAware", "longitude: " + r22 + ", latitude=" + r20 + ", radius=" + r25 + ", transitionType=" + r26 + ", converted=" + r7);
        boolean r0 = r6.a(r5, r24, r7.getLatitude(), r7.getLongitude(), r25, StarGeofence.GeoTransitionType.values()[r26], r6.i(r24));
        if (r0 == false) goto L10;
        if (r12 == null) goto L10;
        ((Map) ZeusTransformUtils.preCheckCast(y, Map.class, "com.obric.memorydata.plugin")).put(r24, r12);
    L10:
        return r0;
    }

    private final boolean a(com.obric.cae.libs.location.geofence.b r18, StarGeofence r19) {
        com.obric.cae.libs.location.geofence.b r0 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        String r12 = r19.getGeofenceId();
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r19.getRadius() > 100) goto L10;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder();
        String r3 = "skip dual boundary for small geofence: ";
    L8:
        IRunLog.a.a(r1, "CaeLocationAware", r2.append(r3).append(r12).toString(), null, 4, null);
        return false;
    L10:
        String r4 = DualBoundaryGeofence.f8549a.a(r12);
        double r5 = r19.getLatitude();
        double r7 = r19.getLongitude();
        int r9 = r19.getRadius() - 100;
        StarGeofence.GeoTransitionType r10 = r19.getTransitionType();
        Intrinsics.checkNotNullExpressionValue(r10, "getTransitionType(...)");
        boolean r16 = b(r0, r4, r5, r7, r9, r10, StarGeofence.GeoType.UNKNOWN);
        String r6 = DualBoundaryGeofence.f8549a.b(r12);
        double r8 = r19.getLatitude();
        double r11 = r19.getLongitude();
        int r13 = r19.getRadius() + 100;
        StarGeofence.GeoTransitionType r14 = r19.getTransitionType();
        Intrinsics.checkNotNullExpressionValue(r14, "getTransitionType(...)");
        boolean r15 = b(r0, r6, r8, r11, r13, r14, StarGeofence.GeoType.UNKNOWN);
        if (r16 == false) goto L16;
        if (r15 == false) goto L16;
        return true;
    L16:
        a(r0, r12);
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r2 = new StringBuilder();
        r3 = "dual-boundary migration failed, fallback to legacy: ";
        goto L8
    }

    private final boolean a(com.obric.cae.libs.location.geofence.b r10, final StarGeofence r11, final String r12) {
        final com.obric.cae.libs.location.geofence.b r2 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        final String r4 = r11.getGeofenceId();
        if (r4 != null) goto L5;
        return false;
    L5:
        DualBoundaryGeofence.a r13 = DualBoundaryGeofence.f8549a.c(r4);
        if (r13 == null) goto L11;
        String r1 = r13.a();
        if (r1 == null) goto L11;
        final String r5 = r1;
    L12:
        if (r13 == null) goto L17;
        DualBoundaryGeofence.Boundary r14 = r13.b();
        if (r14 == null) goto L17;
        String r15 = r14.getProtocolValue();
        if (r15 == null) goto L17;
    L18:
        final String r6 = r15;
        Boolean r16 = (Boolean) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$b$mVlPZTg7VyNhDSCZXNf3FE3Ens(r4, r5, r6, r12), new $$Lambda$b$JEiDbVgT1185pjBNCb8Lp9UGSA(r2, r11, r4, r5, r6, r12)), Boolean.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L21;
        return false;
    L21:
        return r16.booleanValue();
    L17:
        r15 = "logical";
    L11:
        r5 = r4;
        goto L12
    }

    private static final boolean a(com.obric.cae.libs.location.geofence.b r7, StarGeofence r8, String r9, String r10, String r11, String r12) {
        byte r13 = ((com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin")).deleteGeofence(r8);
        GeoFenceCallbackPolicy.f8500a.a(r9);
        if (r13 != 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "物理围栏删除完成，logicalFenceId=" + r10 + "，physicalFenceId=" + r9 + "，boundary=" + r11 + "，reason=" + r12, false, 4, null);
    L9:
        return r14;
    L8:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "delete_physical_geofence_failed logicalFenceId=" + r10 + " physicalFenceId=" + r9 + " boundary=" + r11 + " reason=" + r12 + " result=" + r13, null, 4, null);
        goto L9
    L5:
        r14 = false;
        goto L6
    }

    private final boolean a(com.obric.cae.libs.location.geofence.b r24, String r25, double r26, double r28, int r30, StarGeofence.GeoTransitionType r31, StarGeofence.GeoType r32) {
        com.obric.cae.libs.location.geofence.b r9 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r24, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        if (r30 > 100) goto L7;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "addGeofence radius is too small for dual boundary: " + r30, null, 4, null);
        return false;
    L7:
        if (b(r9, DualBoundaryGeofence.f8549a.a(r25), r26, r28, r30 - 100, r31, StarGeofence.GeoType.UNKNOWN) == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L16;
        com.obric.cae.libs.location.geofence.b r11 = r9;
        if (b(r9, r25, r26, r28, r30, r31, r32) == false) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == true) goto L21;
        a(r11, r25);
        u.remove(r25);
        return false;
    L21:
        u.add(r25);
        return true;
    L17:
        r1 = false;
        goto L18
    L16:
        r11 = r9;
        goto L17
    L9:
        if (b(r9, DualBoundaryGeofence.f8549a.b(r25), r26, r28, r30 + 100, r31, StarGeofence.GeoType.UNKNOWN) == false) goto L11;
        r0 = true;
        goto L12
    }

    private final boolean a(com.obric.cae.libs.location.geofence.b r17, String r18, String r19, String r20, double r21, double r23, int r25, StarGeofence.GeoTransitionType r26, StarGeofence.GeoType r27) {
        com.obric.cae.libs.location.geofence.b r1 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        StarGeofence r10 = r1.findGeofenceById(r18);
        if (r10 != null) goto L5;
    L8:
        GeoFenceCallbackPolicy.f8500a.a(r18, e());
        if (r10 != null) goto L11;
        String r0 = "add";
    L13:
        return a(r18, r19, r20, r25, r0, a(r1, r10, r18, r21, r23, r25, r26, r27));
    L11:
        r0 = BuildConfig.CHANNEL;
        goto L13
    L5:
        if (a(r10, r21, r23, r25, r26) == false) goto L8;
        RunLog.INSTANCE.debug("CaeLocationAware", "物理围栏配置未变化，logicalFenceId=" + r19 + "，physicalFenceId=" + r18 + "，boundary=" + r20 + "，radius=" + r25);
        return true;
    }

    private final boolean a(AoiBoard r8, AoiBoard.Event r9) {
        List r0 = a(this, null, 1, null);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.isEmpty() == false) goto L9;
        a(false, "AOI event company not in transport hub");
        return false;
    L9:
        a(true, "AOI event company in transport hub");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L12;
    L14:
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L13;
        if (f8563a.a((AoiBoard) ZeusTransformUtils.preCheckCast(r4.next(), AoiBoard.class, "com.obric.memorydata.plugin"), r8) == false) goto L16;
        boolean r5 = false;
    L20:
        if (r5 == false) goto L22;
        return false;
    L22:
        int r10 = c.f8569a[r9.ordinal()];
        if (r10 == 1) goto L46;
        if (r10 != 2) goto L48;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L30;
    L32:
        Iterator r12 = r11.iterator();
    L34:
        if (r12.hasNext() == false) goto L31;
        AoiBoard r1 = (AoiBoard) ZeusTransformUtils.preCheckCast(r12.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (f8563a.a(r1, r8) == false) goto L38;
    L40:
        boolean r2 = false;
    L41:
        if (r2 == false) goto L34;
        boolean r13 = true;
    L43:
        if (r13 == true) goto L48;
        a(false, r8);
        goto L48
    L38:
        if (r1.getCurState() != AoiBoard.State.INSIDE) goto L40;
        r2 = true;
    L31:
        r13 = false;
        goto L43
    L30:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L32;
    L48:
        return true;
    L46:
        if (r8.getCurState() != AoiBoard.State.INSIDE) goto L48;
        a(true, r8);
    L13:
        r5 = true;
        goto L20
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
        goto L13
    }

    private final boolean a(AoiBoard r4, AoiBoard r5) {
        String r3 = r4.getPoiId();
        String r0 = r5.getPoiId();
        if (r4.getType() != r5.getType()) goto L16;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L16;
        if (Intrinsics.areEqual(r3, r0) == false) goto L16;
        return true;
    L7:
        if (StringsKt.isBlank(r6) == true) goto L10;
        r7 = false;
    L16:
        return false;
    }

    public static final /* synthetic */ boolean a(b r0, String r1) {
        return r0.g(r1);
    }

    public static /* synthetic */ boolean a(b r11, String r12, double r13, double r15, int r17, int r18, com.obric.memorydata.awareness.cae.d r19, int r20, Object r21) {
        com.obric.memorydata.awareness.cae.d r0 = (com.obric.memorydata.awareness.cae.d) ZeusTransformUtils.wrapperContextForParams(r19, com.obric.memorydata.awareness.cae.d.class, "com.obric.memorydata.plugin");
        if ((r20 & 8) == 0) goto L5;
        int r8 = 250;
    L7:
        if ((r20 & 16) == 0) goto L9;
        int r9 = 3;
    L11:
        if ((r20 & 32) == 0) goto L14;
        r0 = null;
    L14:
        return r11.a(r12, r13, r15, r8, r9, r0);
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    private final boolean a(String r1, double r2, double r4) {
        return com.obric.cae.location.util.c.a(r1, r2, r4);
    }

    private static final boolean a(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        RunLog.INSTANCE.warn("CaeLocationAware", "dual_boundary_migration_failed fenceId=" + r3, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final boolean a(String r7, String r8, String r9, int r10, String r11, byte r12) {
        if (r12 != 0) goto L4;
        boolean r6 = true;
    L5:
        if (r6 == true) goto L8;
        GeoFenceCallbackPolicy.f8500a.a(r7);
    L8:
        if (r6 == false) goto L14;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r13 = new StringBuilder().append("物理围栏");
        if (Intrinsics.areEqual(r11, "add") == false) goto L12;
        String r14 = "添加";
    L13:
        IRunLog.a.a(r0, "CaeLocationAware", r13.append(r14).append("完成，logicalFenceId=").append(r8).append("，physicalFenceId=").append(r7).append("，boundary=").append(r9).append("，radius=").append(r10).toString(), false, 4, null);
    L15:
        return r6;
    L12:
        r14 = "更新";
        goto L13
    L14:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "physical_geofence_" + r11 + "_failed logicalFenceId=" + r8 + " physicalFenceId=" + r7 + " boundary=" + r9 + " radius=" + r10 + " result=" + r12, null, 4, null);
        goto L15
    L4:
        r6 = false;
        goto L5
    }

    private static final boolean a(String r3, String r4, String r5, Exception r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        GeoFenceCallbackPolicy.f8500a.a(r3);
        RunLog.INSTANCE.error("CaeLocationAware", "upsert_physical_geofence_failed logicalFenceId=" + r4 + " physicalFenceId=" + r3 + " boundary=" + r5, (Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private static final boolean a(String r3, String r4, String r5, String r6, Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "error");
        GeoFenceCallbackPolicy.f8500a.a(r3);
        RunLog.INSTANCE.error("CaeLocationAware", "delete_physical_geofence_failed logicalFenceId=" + r4 + " physicalFenceId=" + r3 + " boundary=" + r5 + " reason=" + r6, (Throwable) ZeusTransformUtils.preCheckCast(r7, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final Location b(double r2, double r4) {
        Location r1 = new Location("gps");
        r1.setLatitude(r2);
        r1.setLongitude(r4);
        Location r3 = CoordinateTransformUtils.a(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r1);
        Intrinsics.checkNotNullExpressionValue(r3, "convertLocation(...)");
        return r3;
    }

    private final AoiBoard.Event b(AoiBoard r8, int r9) {
        AoiBoard.Event[] r7 = AoiBoard.Event.values();
        int r0 = r7.length;
        boolean r1 = false;
        int r2 = 0;
    L3:
        AoiBoard.Event r3 = null;
        if (r2 >= r0) goto L12;
        AoiBoard.Event r5 = r7[r2];
        if (r5.getValue() != r9) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r5 != null) goto L15;
    L20:
        AoiBoard.Event r4 = r8.getEvent();
        if (r4 == null) goto L23;
        return r4;
    L23:
        return AoiBoard.Event.UNKNOWN;
    L15:
        if (r5 == AoiBoard.Event.UNKNOWN) goto L17;
        r1 = true;
    L17:
        if (r1 == false) goto L19;
        r3 = r5;
    L19:
        if (r3 == null) goto L20;
        return r3;
    L8:
        r6 = false;
        goto L9
    L12:
        r5 = null;
        goto L13
    }

    private final Integer b(AoiBoard r10) {
        String r9 = r10.getPoiId();
        if (r9 != null) goto L5;
    L7:
        r9 = null;
    L8:
        if (r9 != null) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "get AOI geofence radius failed: poiId is blank", null, 4, null);
        return null;
    L30:
        com.obric.cae.libs.location.geofence.b r1 = f;     // Catch: Throwable -> L15
        if (r1 == null) goto L17;
        StarGeofence r2 = r1.findGeofenceByPoiId(r9);     // Catch: Throwable -> L15
    L18:
        if (r2 == null) goto L20;
        Integer r3 = Integer.valueOf(r2.getRadius());
    L22:
        if (r3 != null) goto L24;
    L28:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "get AOI geofence radius failed poiId=" + r9 + ", radius=" + r3, null, 4, null);
        return null;
    L24:
        if (r3.intValue() <= 0) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "get AOI geofence radius poiId=" + r9 + ", radius=" + r3, false, 4, null);
        return r3;
    L20:
        r3 = null;
    L17:
        r2 = null;
    L15:
        th = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "findGeofenceByPoiId failed poiId=" + r9, th);
        goto L17
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        goto L7
    }

    private final String b(com.obric.cae.libs.location.b r3) {
        return ((com.obric.cae.libs.location.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.b.class, "com.obric.memorydata.plugin")).h();
    L5:
        th = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "getCommSenseAARVersion failed", th);
        return null;
    }

    private final String b(AoiBoard.Type r2) {
        String r1 = a(r2);
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (r2 == null) goto L15;
        String r3 = r2.name();
        if (r3 == null) goto L16;
        String r4 = r3.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r4, "toLowerCase(...)");
        if (r4 != null) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r4, "unknown") == false) goto L14;
        return null;
    L14:
        return r4;
    L16:
        return null;
    L15:
        return null;
    }

    private final List<AoiBoard> b(com.obric.cae.libs.location.poi.b r6) {
        com.obric.cae.libs.location.poi.b r7 = (com.obric.cae.libs.location.poi.b) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.cae.libs.location.poi.b.class, "com.obric.memorydata.plugin");
        if (u() == true) goto L5;
        return null;
    L5:
        if (r7 != null) goto L8;
        return null;
    L8:
        if (c(r7) == true) goto L25;
        return null;
    L25:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(w, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Iterator r8 = r5.iterator();     // Catch: Throwable -> L22
    L12:
        if (r8.hasNext() == false) goto L20;
        List<AoiBoard> r3 = r7.a(((AoiBoard.Type) ZeusTransformUtils.preCheckCast(r8.next(), AoiBoard.Type.class, "com.obric.memorydata.plugin")).ordinal());     // Catch: Throwable -> L22
        if (r3 == null) goto L16;
        List r4 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L17:
        if (r4 != null) goto L19;
        r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L22
    L19:
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
        goto L12
    L16:
        r4 = null;
        goto L17
    L20:
        return CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new h(), Comparator.class, "com.obric.memorydata.plugin"));
    L22:
        th = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "list transport hub AOI boards failed", th);
        return null;
    }

    private final List<AoiBoard> b(List<? extends AoiBoard> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L6;
        return null;
    L6:
        Location r11 = x();
        if (r11 == null) goto L9;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L12:
        if (r15.hasNext() == false) goto L22;
        Object r2 = r15.next();
        AoiBoard r3 = (AoiBoard) ZeusTransformUtils.preCheckCast(r2, AoiBoard.class, "com.obric.memorydata.plugin");
        if (v.contains(r3.getType()) == true) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L12;
        r0.add(r2);
        goto L12
    L16:
        if (f8563a.a(r3.getAoiBoard(), r11.getLatitude(), r11.getLongitude()) == false) goto L18;
        r4 = true;
        goto L19
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L9:
        return CollectionsKt.emptyList();
    }

    private static final Unit b(int r2, Function0 r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        f8563a.a(r2 + 1, r4);
        return Unit.INSTANCE;
    }

    private final void b(com.obric.cae.libs.location.geofence.b r9) {
        com.obric.cae.libs.location.geofence.b r10 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L10;
        return;
    L10:
        String r0 = AppContext.INSTANCE.getPackageName();     // Catch: Exception -> L7
        RunLog r2 = RunLog.INSTANCE;     // Catch: Exception -> L7
        StringBuilder r3 = new StringBuilder().append("registerGeofenceCallback packageName=").append(r0).append(", geofenceCallback=");     // Catch: Exception -> L7
        com.obric.cae.libs.location.geofence.a r4 = z;     // Catch: Exception -> L7
        r2.debug("CaeLocationAware", r3.append(r4).toString());     // Catch: Exception -> L7
        r10.registerGeofenceCallback(r0, r4);     // Catch: Exception -> L7
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "registerGeofenceCallback success", false, 4, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "registerGeofenceCallback failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void b(b r0) {
        r0.w();
    }

    public static final /* synthetic */ void b(b r2, com.obric.cae.libs.location.geofence.b r3) {
        r2.b((com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin"));
    }

    private static final void b(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private final boolean b(com.obric.cae.libs.location.geofence.b r6, StarGeofence r7) {
        com.obric.cae.libs.location.geofence.b r5 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        String r8 = r7.getGeofenceId();
        if (r8 != null) goto L5;
        return false;
    L5:
        boolean r3 = true;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOfNotNull(new StarGeofence[]{r5.findGeofenceById(DualBoundaryGeofence.f8549a.a(r8)), r5.findGeofenceById(DualBoundaryGeofence.f8549a.b(r8)), r7}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r9.hasNext() == false) goto L11;
        if (f8563a.a(r5, (StarGeofence) ZeusTransformUtils.preCheckCast(r9.next(), StarGeofence.class, "com.obric.memorydata.plugin"), "logical_fence_remove") == true) goto L7;
        r3 = false;
        goto L7
    L11:
        return r3;
    }

    private final boolean b(com.obric.cae.libs.location.geofence.b r16, final String r17, final double r18, final double r20, final int r22, final StarGeofence.GeoTransitionType r23, final StarGeofence.GeoType r24) {
        final com.obric.cae.libs.location.geofence.b r1 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r16, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        DualBoundaryGeofence.a r0 = DualBoundaryGeofence.f8549a.c(r17);
        if (r0 == null) goto L6;
        final String r3 = r0.a();
        if (r3 == null) goto L6;
    L7:
        if (r0 == null) goto L12;
        DualBoundaryGeofence.Boundary r2 = r0.b();
        if (r2 == null) goto L12;
        String r4 = r2.getProtocolValue();
        if (r4 == null) goto L12;
    L13:
        final String r5 = r4;
        Boolean r6 = (Boolean) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$b$c0LE7f0EIPvDE1dFnpx8QgKpyjM(r17, r3, r5), new $$Lambda$b$3oZnCe5gPcTpeSsJKKMFJv0qKeE(r1, r17, r3, r5, r18, r20, r22, r23, r24)), Boolean.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L18;
        return false;
    L18:
        return r6.booleanValue();
    L12:
        r4 = "logical";
    L6:
        r3 = r17;
        goto L7
    }

    private static final boolean b(com.obric.cae.libs.location.geofence.b r13, String r14, String r15, String r16, double r17, double r19, int r21, StarGeofence.GeoTransitionType r22, StarGeofence.GeoType r23) {
        com.obric.cae.libs.location.geofence.b r2 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        return f8563a.a(r2, r14, r15, r16, r17, r19, r21, r22, r23);
    }

    private static final boolean b(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        f8563a.j(r3);
        RunLog.INSTANCE.error("CaeLocationAware", "add_geofence_failed fenceId=" + r3, (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    public static final /* synthetic */ GeofenceRuntimeAvailabilityManager c(b r0) {
        return r0.t();
    }

    private static final Unit c(Function0 r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        r.execute(new $$Lambda$b$K1J41yeH0BTL61YStZr7hk2bpQM(r3));
        return Unit.INSTANCE;
    }

    private static final void c(final int r2, Function0 r3) {
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        b r0 = f8563a;
        if (r0.t().e() == true) goto L5;
        return;
    L5:
        r0.a(new $$Lambda$b$HHmIJKtZNQEe3UHFjAL8Viz1xU(r2, r4));
    }

    private final void c(com.obric.cae.libs.location.geofence.b r8) {
        com.obric.cae.libs.location.geofence.b r7 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        return;
    L10:
        r7.unregisterGeofenceCallback(AppContext.INSTANCE.getPackageName(), z);     // Catch: Exception -> L7
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "unregisterGeofenceCallback success", false, 4, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "unregisterGeofenceCallback failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final boolean c(com.obric.cae.libs.location.geofence.b r2, StarGeofence r3) {
        com.obric.cae.libs.location.geofence.b r4 = (com.obric.cae.libs.location.geofence.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.cae.libs.location.geofence.b.class, "com.obric.memorydata.plugin");
        return f8563a.a(r4, r3);
    }

    private final boolean c(com.obric.cae.libs.location.poi.b r3) {
        return ((com.obric.cae.libs.location.poi.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.poi.b.class, "com.obric.memorydata.plugin")).c();
    L5:
        th = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "isAoiBoardsRecovered failed", th);
        return false;
    }

    private final void d(com.obric.cae.libs.location.poi.b r9) {
        com.obric.cae.libs.location.poi.b r10 = (com.obric.cae.libs.location.poi.b) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.cae.libs.location.poi.b.class, "com.obric.memorydata.plugin");
        if (u() == true) goto L5;
        return;
    L5:
        if (r10 != null) goto L12;
        return;
    L12:
        r10.a(A);     // Catch: Exception -> L9
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "registerAoiBoardCallback success", false, 4, null);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "registerAoiBoardCallback failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void d(b r0) {
        r0.D();
    }

    private final void e(com.obric.cae.libs.location.poi.b r8) {
        com.obric.cae.libs.location.poi.b r7 = (com.obric.cae.libs.location.poi.b) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.libs.location.poi.b.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        return;
    L10:
        r7.a();     // Catch: Exception -> L7
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "unregisterAoiBoardCallback success", false, 4, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "unregisterAoiBoardCallback failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void e(b r0) {
        r0.z();
    }

    public static final /* synthetic */ boolean f(b r0) {
        return r0.B();
    }

    public static final /* synthetic */ void g(b r0) {
        r0.C();
    }

    private final boolean g(String r4) {
        if (StringsKt.startsWith$default(r4, "train_station_", false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (StringsKt.startsWith$default(r4, "airport_", false, 2, null) == true) goto L6;
        return false;
    }

    public static final /* synthetic */ boolean h(b r0) {
        return r0.u();
    }

    private final boolean h(final String r2) {
        if (GeoFenceCallbackPolicy.f8500a.a(r2, new $$Lambda$b$HBcsCVXgvSW3U6ZrG0DugiM0IHE(r2)) != GeoFenceCallbackPolicy.CallbackType.INITIAL_STATE) goto L5;
        return true;
    L5:
        return false;
    }

    private final StarGeofence.GeoType i(String r4) {
        if (Intrinsics.areEqual(r4, "home_fence") == true) goto L12;
        if (StringsKt.startsWith$default(r4, "home_fence_", false, 2, null) == true) goto L12;
        if (Intrinsics.areEqual(r4, "company_fence") == false) goto L14;
        return StarGeofence.GeoType.COMPANY;
    L14:
        return StarGeofence.GeoType.UNKNOWN;
    L12:
        return StarGeofence.GeoType.HOME;
    }

    public static final /* synthetic */ void i(b r0) {
        r0.G();
    }

    private final void j(String r2) {
        GeoFenceCallbackPolicy.f8500a.a(r2);
        GeoFenceCallbackPolicy.f8500a.a(DualBoundaryGeofence.f8549a.a(r2));
        GeoFenceCallbackPolicy.f8500a.a(DualBoundaryGeofence.f8549a.b(r2));
    }

    private static final Boolean k(String r1) {
        StarGeofence r2 = f8563a.f(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r2.isFirstBreach());
    }

    public static final /* synthetic */ e l() {
        return C;
    }

    public static /* synthetic */ boolean lambda$3oZnCe5gPcTpeSsJKKMFJv0qKeE(com.obric.cae.libs.location.geofence.b r0, String r1, String r2, String r3, double r4, double r6, int r8, StarGeofence.GeoTransitionType r9, StarGeofence.GeoType r10) {
        return b(r0, r1, r2, r3, r4, r6, r8, r9, r10);
    }

    public static /* synthetic */ GeofenceRuntimeAvailabilityManager lambda$6YztBGWnX3bvB6H3MQ1Sixc011c() {
        return L();
    }

    public static /* synthetic */ Unit lambda$73Q4y6ihZ4gHlCT0Soluxd7oh_Q(Function0 r0) {
        return c(r0);
    }

    public static /* synthetic */ Thread lambda$CRWuktmVDQuKefPKwzORBmjiNUo(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ Boolean lambda$HBcsCVXgvSW3U6ZrG0DugiM0IHE(String r0) {
        return k(r0);
    }

    /* JADX INFO: renamed from: lambda$HHmIJKtZNQEe3UHFjAL8-Viz1xU, reason: not valid java name */
    public static /* synthetic */ Unit m483lambda$HHmIJKtZNQEe3UHFjAL8Viz1xU(int r0, Function0 r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$JEiDbVgT1185pjBNCb8Lp9-UGSA, reason: not valid java name */
    public static /* synthetic */ boolean m484lambda$JEiDbVgT1185pjBNCb8Lp9UGSA(com.obric.cae.libs.location.geofence.b r0, StarGeofence r1, String r2, String r3, String r4, String r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$K1J41yeH0BTL61YStZr7hk2bpQM(Function0 r0) {
        b(r0);
    }

    /* JADX INFO: renamed from: lambda$N5ftz-JcmYsR9axP1YNXgnatS7A, reason: not valid java name */
    public static /* synthetic */ Unit m485lambda$N5ftzJcmYsR9axP1YNXgnatS7A(Context r0, Intent r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$SmvwWuEiuzEtdDcmvcRodv84uZ0(String r0, Exception r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$U5EEBCJqZ5olZrXw61agaVYhBq8() {
        return K();
    }

    public static /* synthetic */ void lambda$Z0N6KTBtfV06EkK763euKsVE1wU(int r0, Function0 r1) {
        c(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$aw3BvQtE6e-sHIwiQ51iuh3B7ys, reason: not valid java name */
    public static /* synthetic */ Unit m486lambda$aw3BvQtE6esHIwiQ51iuh3B7ys(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$c0LE7f0EIPvDE1dFnpx8QgKpyjM(String r0, String r1, String r2, Exception r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$cmM4oSphxjC9pj83hV1G7bvSi8k() {
        return J();
    }

    public static /* synthetic */ boolean lambda$ey6XsMm837eSEkfo9tUC8HfjTwQ(com.obric.cae.libs.location.geofence.b r0, double r1, double r3, String r5, int r6, int r7, com.obric.memorydata.awareness.cae.d r8) {
        return a(r0, r1, r3, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: lambda$fRx-S3hKe4dX1O5CfI8DvNM6Ji8, reason: not valid java name */
    public static /* synthetic */ boolean m487lambda$fRxS3hKe4dX1O5CfI8DvNM6Ji8() {
        return H();
    }

    public static /* synthetic */ void lambda$kAXvT6MwnbA1JfW4_l5XHtej9Ig(b r0) {
        r0.A();
    }

    /* JADX INFO: renamed from: lambda$mVlPZTg7VyNhDSCZXNf3FE3-Ens, reason: not valid java name */
    public static /* synthetic */ boolean m488lambda$mVlPZTg7VyNhDSCZXNf3FE3Ens(String r0, String r1, String r2, String r3, Exception r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean lambda$uRMNnAenI7caLINwqdIDmUzF50M(com.obric.cae.libs.location.geofence.b r0, StarGeofence r1) {
        return c(r0, r1);
    }

    public static /* synthetic */ Unit lambda$xW7tlJLwoOln6trKuPD0mULwMmk() {
        return M();
    }

    public static /* synthetic */ boolean lambda$xoGaokJXoXZgVeJQrJtJFO8I8vo(String r0, Exception r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ boolean lambda$yLtKIiZkBh6Ft2txskmG20IEbck() {
        return I();
    }

    public static final /* synthetic */ com.obric.cae.libs.location.b m() {
        return e;
    }

    public static final /* synthetic */ com.obric.cae.libs.location.geofence.b n() {
        return f;
    }

    public static final /* synthetic */ com.obric.cae.libs.location.poi.b o() {
        return g;
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView p() {
        return u;
    }

    public static final /* synthetic */ boolean q() {
        return o;
    }

    public static final /* synthetic */ ServiceConnection r() {
        return B;
    }

    private final boolean s() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(f8564b.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final GeofenceRuntimeAvailabilityManager t() {
        return (GeofenceRuntimeAvailabilityManager) ZeusTransformUtils.preCheckCast(h.getValue(), GeofenceRuntimeAvailabilityManager.class, "com.obric.memorydata.plugin");
    }

    private final boolean u() {
        if (n == true) goto L5;
        com.obric.cae.libs.location.b r0 = e;
        boolean r1 = false;
        if (r0 != null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "transport hub AOI support unknown: location service not ready", false, 4, null);
        return false;
    L10:
        String r2 = b(r0);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L13;
    L14:
        r1 = true;
    L15:
        boolean r4 = !r1;
        o = r4;
        n = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "transport hub AOI support=" + r4 + ", memoryVersion=com.obric.cae.commonsense:CommSenseAAR:1.0.10.22, serviceVersion=" + r2, false, 4, null);
        if (r4 == true) goto L18;
        a("transport hub AOI unsupported");
    L18:
        return r4;
    L13:
        if (StringsKt.isBlank(r3) == false) goto L15;
    L5:
        return o;
    }

    private final void v() {
        p = false;
        q = null;
    }

    private final void w() {
        n = false;
        o = false;
    }

    private final Location x() {
        Object r0 = FeatureManager.INSTANCE.getFeature("location_company_gps");
        if (ZeusTransformUtils.instanceOf(r0, List.class) == false) goto L5;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L9;
        return null;
    L9:
        if (r1.size() == 2) goto L11;
        return null;
    L11:
        Object r2 = r1.get(0);
        if (ZeusTransformUtils.instanceOf(r2, Double.class) == false) goto L14;
        Double r3 = (Double) ZeusTransformUtils.preCheckCast(r2, Double.class, "com.obric.memorydata.plugin");
    L15:
        if (r3 == null) goto L26;
        double r4 = r3.doubleValue();
        Object r5 = r1.get(1);
        if (ZeusTransformUtils.instanceOf(r5, Double.class) == false) goto L19;
        Double r6 = (Double) ZeusTransformUtils.preCheckCast(r5, Double.class, "com.obric.memorydata.plugin");
    L20:
        if (r6 == null) goto L26;
        double r7 = r6.doubleValue();
        if (a(r7, r4) == true) goto L24;
        return null;
    L24:
        CoordinateTransformUtils.CoordinateSystem r8 = CoordinateTransformUtils.CoordinateSystem.GCJ02;
        CoordinateTransformUtils.CoordinateSystem r9 = CoordinateTransformUtils.CoordinateSystem.WGS84;
        Location r10 = new Location("gps");
        r10.setLatitude(r7);
        r10.setLongitude(r4);
        Unit r11 = Unit.INSTANCE;
        return CoordinateTransformUtils.a(r8, r9, r10);
    L19:
        r6 = null;
    L26:
        return null;
    L14:
        r3 = null;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    private final ServiceConnection y() {
        return (ServiceConnection) ZeusTransformUtils.preCheckCast(new i(), ServiceConnection.class, "com.obric.memorydata.plugin");
    }

    private final void z() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(s.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        return;
    L6:
        if (u() == true) goto L22;
        return;
    L22:
        com.obric.cae.libs.location.b r1 = e;     // Catch: Throwable -> L19
        if (r1 == null) goto L12;
        com.obric.cae.libs.location.poi.b r2 = r1.f();     // Catch: Throwable -> L19
    L13:
        g = r2;     // Catch: Throwable -> L19
        if (r2 != null) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "AOI board manager is unavailable after service connected", null, 4, null);     // Catch: Throwable -> L19
        return;
    L17:
        d(r2);     // Catch: Throwable -> L19
        return;
    L12:
        r2 = null;
    L19:
        th = move-exception;
        RunLog.INSTANCE.warn("CaeLocationAware", "init AOI board manager failed", th);
        g = null;
        a("init AOI board manager failed");
    }

    public final Object a(Continuation<? super Boolean> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, CaeLocationAware$bindLocationServiceSync$1.class) == false) goto L7;
        CaeLocationAware$bindLocationServiceSync$1 r0 = (CaeLocationAware$bindLocationServiceSync$1) ZeusTransformUtils.preCheckCast(r13, CaeLocationAware$bindLocationServiceSync$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L27:
        Boolean r11 = (Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L31;
        r4 = r11.booleanValue();
    L31:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        t().b();
        if (((Boolean) ZeusTransformUtils.preCheckCast(s.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L21;
        if (e == null) goto L21;
        return Boxing.boxBoolean(true);
    L21:
        if (com.obric.memorydata.b.a.f8796a.a() == true) goto L24;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "bindLocationServiceSync: fine location permission not granted", null, 4, null);
        F();
        return Boxing.boxBoolean(false);
    L24:
        G();
        Function2 r5 = (Function2) ZeusTransformUtils.preCheckCast(new CaeLocationAware$bindLocationServiceSync$2(null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r14 = da.b(30000, r5, r0);
        if (r14 != r2) goto L27;
        return r2;
    L7:
        r0 = new CaeLocationAware$bindLocationServiceSync$1(this, r13);
        goto L8
    }

    public final ar<Boolean> a() {
        return t().a();
    }

    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, InfoRequestQPSOptTraceLogger.REASON);
        Object r6 = i;
        monitor-enter(r6);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (j == null) goto L7;
    L12:
        boolean r0 = true;
    L13:
        j = null;     // Catch: Throwable -> L18
        k = null;     // Catch: Throwable -> L18
        l = null;     // Catch: Throwable -> L18
        m = false;     // Catch: Throwable -> L18
        monitor-exit(r6);
        if (r0 == false) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "clear transport hub company fence state: " + r7, false, 4, null);
        return;
    L23:
        return;
    L7:
        if (k != null) goto L12;
        if (l != null) goto L12;
        r0 = false;
        goto L13
    }

    public final void a(String r13, StarGeofence.GeoEvent r14) {
        Intrinsics.checkNotNullParameter(r13, "geofenceId");
        Intrinsics.checkNotNullParameter(r14, "transitionEvent");
        RunLog.INSTANCE.debug("CaeLocationAware", "准备处理围栏变化，geofenceId=" + r13 + "，event=" + r14);
        DualBoundaryGeofence.a r0 = DualBoundaryGeofence.f8549a.c(r13);
        if (r0 == null) goto L6;
        a(r13, r0, r14);
        return;
    L6:
        int r1 = c.d[r14.ordinal()];
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        return;
    L10:
        boolean r2 = false;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "收到围栏变化，event=" + r14 + "，homeCompanyFence=" + com.obric.memorydata.awareness.impl.location.b.f8730a.c(r13), false, 4, null);
        if (h(r13) == false) goto L17;
        a(r13, r2);
        return;
    L17:
        if (Intrinsics.areEqual(r13, "home_fence") == false) goto L19;
    L22:
        com.obric.memorydata.awareness.cae.d r12 = com.obric.memorydata.awareness.cae.f.f8574a.a().b();
    L23:
        int r15 = c.d[r14.ordinal()];
        if (r15 == 1) goto L29;
        if (r15 != 2) goto L32;
        if (r12 == null) goto L32;
        r12.b(r13);
    L32:
        if (u.contains(r13) == false) goto L35;
        com.obric.memorydata.awareness.impl.location.c.f8736a.a(r13, "logical", r2);
        return;
    L35:
        com.obric.memorydata.awareness.impl.location.c.f8736a.a(r13, r2);
        return;
    L29:
        if (r12 == null) goto L32;
        r12.a(r13);
        goto L32
    L19:
        if (Intrinsics.areEqual(r13, "company_fence") == true) goto L22;
        r12 = (com.obric.memorydata.awareness.cae.d) ZeusTransformUtils.preCheckCast(y.get(r13), com.obric.memorydata.awareness.cae.d.class, "com.obric.memorydata.plugin");
        goto L23
    L11:
        r2 = true;
        goto L12
    }

    public final synchronized boolean a(final String r15, final double r16, final double r18, final int r20, final int r21, com.obric.memorydata.awareness.cae.d r22) {
        monitor-enter(this);
        final com.obric.memorydata.awareness.cae.d r10 = (com.obric.memorydata.awareness.cae.d) ZeusTransformUtils.wrapperContextForParams(r22, com.obric.memorydata.awareness.cae.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r15, "geofenceId");     // Catch: Throwable -> L18
        boolean r11 = false;
        if (DualBoundaryGeofence.f8549a.e(r15) == false) goto L9;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "addGeofence rejected reserved fence id", null, 4, null);     // Catch: Throwable -> L18
        monitor-exit(this);
        return false;
    L9:
        final com.obric.cae.libs.location.geofence.b r2 = f;     // Catch: Throwable -> L18
        if (r2 != null) goto L13;
        monitor-exit(this);
        return false;
    L13:
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$b$xoGaokJXoXZgVeJQrJtJFO8I8vo(r15), new $$Lambda$b$ey6XsMm837eSEkfo9tUC8HfjTwQ(r2, r18, r16, r15, r20, r21, r10)), Boolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r0 == null) goto L16;
        r11 = r0.booleanValue();     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return r11;
    L18:
        th = move-exception;
        throw th;
    }

    public final Object b(Continuation<? super Boolean> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, CaeLocationAware$bindServiceSync$1.class) == false) goto L7;
        CaeLocationAware$bindServiceSync$1 r0 = (CaeLocationAware$bindServiceSync$1) ZeusTransformUtils.preCheckCast(r8, CaeLocationAware$bindServiceSync$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L21:
        Boolean r6 = (Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L24;
        boolean r10 = r6.booleanValue();
    L26:
        return Boxing.boxBoolean(r10);
    L24:
        r10 = false;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        t().b();
        if (((Boolean) ZeusTransformUtils.preCheckCast(t.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L17;
        G();
        Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new CaeLocationAware$bindServiceSync$2(null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r9 = da.b(60000, r4, r0);
        if (r9 != r2) goto L21;
        return r2;
    L17:
        return Boxing.boxBoolean(true);
    L7:
        r0 = new CaeLocationAware$bindServiceSync$1(this, r8);
        goto L8
    }

    public final void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        if (u() == true) goto L5;
        return;
    L5:
        GeofenceRuntimeAvailabilityManager.a(t(), "交通枢纽 AOI 状态需要重新同步：" + r8, 0, 2, null);
    }

    public final boolean b() {
        return t().d();
    }

    public final ae<Boolean> c() {
        return s;
    }

    public final boolean c(String r9) {
        Intrinsics.checkNotNullParameter(r9, "geofenceId");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofence: " + r9 + " geofenceManager " + f, false, 4, null);
        if (DualBoundaryGeofence.f8549a.e(r9) == false) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofence rejected reserved fence id", null, 4, null);
        return false;
    L6:
        com.obric.cae.libs.location.geofence.b r8 = f;
        if (r8 != null) goto L10;
        RunLog.INSTANCE.error("CaeLocationAware", "removeGeofence " + r9 + " geofenceManager is null", new Throwable());
        return false;
    L10:
        if (r8 != null) goto L26;
    L25:
        return false;
    L26:
    L23:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofence error, msg: " + e, null, 4, null);
        goto L25
    L12:
        if (r8.asBinder().isBinderAlive() == false) goto L21;
        b r2 = f8563a;     // Catch: RemoteException -> L23
        StarGeofence r3 = r2.f(r9);     // Catch: RemoteException -> L23
        if (r3 == null) goto L25;
        if (r2.b(r8, r3) == true) goto L19;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofence set failed: " + r9, null, 4, null);     // Catch: RemoteException -> L23
        return false;
    L19:
        y.remove(r9);     // Catch: RemoteException -> L23
        u.remove(r9);     // Catch: RemoteException -> L23
        r2.j(r9);     // Catch: RemoteException -> L23
        com.obric.memorydata.awareness.impl.location.c.f8736a.a(r9);     // Catch: RemoteException -> L23
        return true;
    L21:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofence geofenceManager not alive", null, 4, null);     // Catch: RemoteException -> L23
        return false;
    }

    public final synchronized List<StarGeofence> d(String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "prefix");     // Catch: Throwable -> L51
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        List<StarGeofence> r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L51
        monitor-exit(this);
        return r9;
    L11:
        com.obric.cae.libs.location.geofence.b r1 = f;     // Catch: Throwable -> L51
        if (r1 != null) goto L54;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "getGeofencesByPrefix " + r8 + " geofenceManager is null", null, 4, null);     // Catch: Throwable -> L51
        List<StarGeofence> r10 = CollectionsKt.emptyList();     // Catch: Throwable -> L51
        monitor-exit(this);
        return r10;
    L54:
    L47:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "getGeofencesByPrefix error, msg: " + e, null, 4, null);     // Catch: Throwable -> L51
        return CollectionsKt.emptyList();
    L17:
        if (r1.asBinder().isBinderAlive() == true) goto L56;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "getGeofencesByPrefix geofenceManager not alive", null, 4, null);     // Catch: RemoteException -> L47 Throwable -> L51
        List<StarGeofence> r11 = CollectionsKt.emptyList();     // Catch: RemoteException -> L47 Throwable -> L51
        monitor-exit(this);
        return r11;
    L56:
        List<StarGeofence> r3 = r1.listGeofences(AppContext.INSTANCE.getPackageName());     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        if (r3 == null) goto L41;
        List r4 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        if (r4 == null) goto L41;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        Iterator r7 = r5.iterator();     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
    L27:
        if (r7.hasNext() == false) goto L34;
        Object r12 = r7.next();     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        StarGeofence r13 = (StarGeofence) ZeusTransformUtils.preCheckCast(r12, StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        DualBoundaryGeofence r14 = DualBoundaryGeofence.f8549a;     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        String r15 = r13.getGeofenceId();     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        if (r15 != null) goto L32;
        r15 = "";
    L32:
        if (r14.d(r15) == true) goto L27;
        r6.add(r12);     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        goto L27
    L34:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        Iterator r18 = r16.iterator();     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
    L36:
        if (r18.hasNext() == false) goto L40;
        Object r19 = r18.next();     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        String r20 = ((StarGeofence) ZeusTransformUtils.preCheckCast(r19, StarGeofence.class, "com.obric.memorydata.plugin")).getGeofenceId();     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        Intrinsics.checkNotNullExpressionValue(r20, "getGeofenceId(...)");     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        if (StringsKt.startsWith$default(r20, r8, false, 2, null) == false) goto L36;
        r17.add(r19);     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
        goto L36
    L40:
        List<StarGeofence> r21 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
    L45:
        monitor-exit(this);
        return r21;
    L41:
        r21 = CollectionsKt.emptyList();     // Catch: ArrayIndexOutOfBoundsException -> L43 RemoteException -> L47 Throwable -> L51
    L43:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "getGeofencesByPrefix listGeofences error: " + e, null, 4, null);     // Catch: RemoteException -> L47 Throwable -> L51
        r21 = CollectionsKt.emptyList();     // Catch: RemoteException -> L47 Throwable -> L51
        goto L45
    L6:
        r0 = false;
    L51:
        th = move-exception;
        throw th;
    }

    public final ae<Boolean> d() {
        return t;
    }

    public final synchronized int e(String r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r13, "prefix");     // Catch: Throwable -> L63
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofencesByPrefix: " + r13 + " geofenceManager " + f, false, 4, null);     // Catch: Throwable -> L63
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        monitor-exit(this);
        return 0;
    L12:
        com.obric.cae.libs.location.geofence.b r2 = f;     // Catch: Throwable -> L63
        if (r2 != null) goto L66;
        b r0 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        RunLog.INSTANCE.error("CaeLocationAware", "removeGeofencesByPrefix " + r13 + " geofenceManager is null", new Throwable());     // Catch: Throwable -> L63
        monitor-exit(this);
        return 0;
    L66:
    L59:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofencesByPrefix error, msg: " + e, null, 4, null);     // Catch: Throwable -> L63
        return 0;
    L18:
        if (r2.asBinder().isBinderAlive() == true) goto L67;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofencesByPrefix geofenceManager not alive", null, 4, null);     // Catch: RemoteException -> L59 Throwable -> L63
        monitor-exit(this);
        return 0;
    L67:
        List<StarGeofence> r4 = r2.listGeofences(AppContext.INSTANCE.getPackageName());     // Catch: ArrayIndexOutOfBoundsException -> L28 RemoteException -> L59 Throwable -> L63
        if (r4 == null) goto L27;
        List r5 = CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: ArrayIndexOutOfBoundsException -> L28 RemoteException -> L59 Throwable -> L63
    L30:
        if (r5 != null) goto L34;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L59 Throwable -> L63
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofencesByPrefix " + r13 + " skipped: geofence list not ready", null, 4, null);     // Catch: RemoteException -> L59 Throwable -> L63
        monitor-exit(this);
        return 0;
    L34:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L59 Throwable -> L63
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L59 Throwable -> L63
        Iterator r8 = r6.iterator();     // Catch: RemoteException -> L59 Throwable -> L63
    L36:
        if (r8.hasNext() == false) goto L43;
        Object r9 = r8.next();     // Catch: RemoteException -> L59 Throwable -> L63
        StarGeofence r10 = (StarGeofence) ZeusTransformUtils.preCheckCast(r9, StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L59 Throwable -> L63
        DualBoundaryGeofence r11 = DualBoundaryGeofence.f8549a;     // Catch: RemoteException -> L59 Throwable -> L63
        String r12 = r10.getGeofenceId();     // Catch: RemoteException -> L59 Throwable -> L63
        if (r12 != null) goto L41;
        r12 = "";
    L41:
        if (r11.d(r12) == true) goto L36;
        r7.add(r9);     // Catch: RemoteException -> L59 Throwable -> L63
        goto L36
    L43:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L59 Throwable -> L63
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L59 Throwable -> L63
        Iterator r16 = r14.iterator();     // Catch: RemoteException -> L59 Throwable -> L63
    L45:
        if (r16.hasNext() == false) goto L49;
        Object r17 = r16.next();     // Catch: RemoteException -> L59 Throwable -> L63
        String r18 = ((StarGeofence) ZeusTransformUtils.preCheckCast(r17, StarGeofence.class, "com.obric.memorydata.plugin")).getGeofenceId();     // Catch: RemoteException -> L59 Throwable -> L63
        Intrinsics.checkNotNullExpressionValue(r18, "getGeofenceId(...)");     // Catch: RemoteException -> L59 Throwable -> L63
        if (StringsKt.startsWith$default(r18, r13, false, 2, null) == false) goto L45;
        r15.add(r17);     // Catch: RemoteException -> L59 Throwable -> L63
        goto L45
    L49:
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: RemoteException -> L59 Throwable -> L63
        int r20 = 0;
    L51:
        if (r19.hasNext() == false) goto L56;
        StarGeofence r21 = (StarGeofence) ZeusTransformUtils.preCheckCast(r19.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: RemoteException -> L59 Throwable -> L63
        b r22 = f8563a;     // Catch: RemoteException -> L59 Throwable -> L63
        if (r22.b(r2, r21) == true) goto L54;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofencesByPrefix " + r21.getGeofenceId() + " failed", null, 4, null);     // Catch: RemoteException -> L59 Throwable -> L63
        goto L51
    L54:
        y.remove(r21.getGeofenceId());     // Catch: RemoteException -> L59 Throwable -> L63
        u.remove(r21.getGeofenceId());     // Catch: RemoteException -> L59 Throwable -> L63
        String r23 = r21.getGeofenceId();     // Catch: RemoteException -> L59 Throwable -> L63
        Intrinsics.checkNotNullExpressionValue(r23, "getGeofenceId(...)");     // Catch: RemoteException -> L59 Throwable -> L63
        r22.j(r23);     // Catch: RemoteException -> L59 Throwable -> L63
        com.obric.memorydata.awareness.impl.location.c r24 = com.obric.memorydata.awareness.impl.location.c.f8736a;     // Catch: RemoteException -> L59 Throwable -> L63
        String r25 = r21.getGeofenceId();     // Catch: RemoteException -> L59 Throwable -> L63
        Intrinsics.checkNotNullExpressionValue(r25, "getGeofenceId(...)");     // Catch: RemoteException -> L59 Throwable -> L63
        r24.a(r25);     // Catch: RemoteException -> L59 Throwable -> L63
        r20 = r20 + 1;     // Catch: RemoteException -> L59 Throwable -> L63
        goto L51
    L56:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofencesByPrefix " + r13 + " removed " + r20, false, 4, null);     // Catch: RemoteException -> L59 Throwable -> L63
        monitor-exit(this);
        return r20;
    L27:
        r5 = null;
    L28:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "removeGeofencesByPrefix listGeofences error: " + e, null, 4, null);     // Catch: RemoteException -> L59 Throwable -> L63
        r5 = CollectionsKt.emptyList();     // Catch: RemoteException -> L59 Throwable -> L63
        goto L30
    L8:
        r1 = false;
    L63:
        th = move-exception;
        throw th;
    }

    public final String e() {
        if (p == true) goto L5;
        com.obric.cae.libs.location.b r0 = e;
        if (r0 != null) goto L10;
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "getCommSenseAARVersion skipped: location service is null", false, 4, null);
        return null;
    L10:
        String r7 = b(r0);
        q = r7;
        p = true;
        return r7;
    L5:
        return q;
    }

    public final StarGeofence f() {
        if (u() == true) goto L7;
        return null;
    L7:
        return k;
    }

    public final StarGeofence f(String r10) {
        Intrinsics.checkNotNullParameter(r10, "geofenceId");
        com.obric.cae.libs.location.geofence.b r9 = f;
        if (r9 != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "getGeofence " + r10 + " geofenceManager is null", null, 4, null);
        return null;
    L6:
        if (r9 != null) goto L16;
    L15:
        return null;
    L16:
    L13:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "getGeofence error, msg: " + e, null, 4, null);
        goto L15
    L8:
        if (r9.asBinder().isBinderAlive() == true) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "getGeofence " + r10 + " geofenceManager not alive", null, 4, null);     // Catch: RemoteException -> L13
        goto L15
    L10:
        return r9.findGeofenceById(r10);
    }

    public final a g() {
        if (u() == true) goto L7;
        return null;
    L7:
        return l;
    }

    public final boolean h() {
        if (o == true) goto L5;
    L7:
        return false;
    L5:
        if (m == false) goto L7;
        return true;
    }

    public final void i() {
        t().b();
        if (j() == true) goto L10;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.b.a.f8796a.b() == true) goto L8;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CaeLocationAware", "init: location permission not granted, skip init", null, 4, null);
        F();
        return;
    L8:
        RunLog.INSTANCE.debug("CaeLocationAware", "CommsenseAAR version: com.obric.cae.commonsense:CommSenseAAR:1.0.10.22");
        G();
        ZeusTransformUtils.registerReceiver(r0, (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(x, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), new IntentFilter("com.obric.cae.location.GEOFENCE_RECOVER_COMPLETED"), 2, "com.obric.memorydata.plugin");
        return;
    }

    public final boolean j() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(s.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final com.obric.cae.libs.location.b k() {
        return e;
    }
}
