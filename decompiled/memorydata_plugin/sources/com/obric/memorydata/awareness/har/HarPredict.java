package com.obric.memorydata.awareness.har;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.RemoteException;
import android.provider.Settings;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.libs.bluetooth.SmartBluetoothEvent;
import com.obric.cae.libs.useraware.BtAwareInfo;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.HarEventData;
import com.obric.cae.libs.useraware.HarLevel2DataReq;
import com.obric.cae.libs.useraware.HarMonitorParams;
import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.libs.useraware.SensorEventInfo;
import com.obric.cae.libs.useraware.UnifiedDataPacket;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.bz;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.u;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0011*\u0003\u0006\u001f-\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0002fgB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0006\u0010&\u001a\u00020\"J\b\u0010'\u001a\u00020\"H\u0002J\u0006\u0010(\u001a\u00020\"J\u0006\u0010)\u001a\u00020\"J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\u0010\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u000203H\u0002J\b\u0010:\u001a\u000206H\u0002J\u0010\u0010;\u001a\u0002062\u0006\u00109\u001a\u000203H\u0002J\u0010\u0010<\u001a\u00020\"2\u0006\u00109\u001a\u000203H\u0002J\u0010\u0010=\u001a\u00020\"2\u0006\u00109\u001a\u000203H\u0002J\u0010\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020@H\u0002J>\u0010A\u001a\u00020\"2\u0006\u00109\u001a\u00020\u001c2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001c2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010D2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010DJ\b\u0010H\u001a\u00020\"H\u0007J\b\u0010I\u001a\u00020\"H\u0002J\u001c\u0010J\u001a\u00020\"2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020M0LH\u0002J\b\u0010N\u001a\u00020\"H\u0002J\u0010\u0010O\u001a\u00020\"2\u0006\u0010P\u001a\u000203H\u0002J.\u0010Q\u001a\u00020\"2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010D2\u0006\u0010R\u001a\u00020\u0014J0\u0010S\u001a\u00020\"2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010D2\u0006\u0010R\u001a\u00020\u0014H\u0002J\u0006\u0010T\u001a\u00020\"J\u0010\u0010U\u001a\u00020\"2\u0006\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020\"H\u0002J\f\u0010Y\u001a\u00060\u000fR\u00020\u0010H\u0003J\b\u0010Z\u001a\u00020\u0014H\u0003J\b\u0010[\u001a\u00020\u0014H\u0003J(\u0010\\\u001a\u00020\"2\u0006\u0010]\u001a\u00020\u001c2\u0016\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010LH\u0016J<\u0010_\u001a\u00020\"2\u0006\u0010`\u001a\u00020\u001c2\b\u0010a\u001a\u0004\u0018\u0001002\b\u0010b\u001a\u0004\u0018\u0001002\u0016\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010LH\u0016J\u0010\u0010c\u001a\u00020\"2\u0006\u0010d\u001a\u00020\u001cH\u0016J\u0006\u0010e\u001a\u00020\u001cR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R \u00102\u001a\u0014\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u000200040\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002060\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000203X\u0082D¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/obric/memorydata/awareness/har/HarPredict;", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "Lcom/obric/memorydata/awareness/api/EventListener;", "<init>", "()V", "workerHandler", "com/obric/memorydata/awareness/har/HarPredict$workerHandler$2$1", "getWorkerHandler", "()Lcom/obric/memorydata/awareness/har/HarPredict$workerHandler$2$1;", "workerHandler$delegate", "Lkotlin/Lazy;", "harShmPacketsReader", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/cae/libs/useraware/HarShmPacketsReader;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "allDayCollectEnabled", "", "harEnabled", "harSensorHandler", "Lcom/obric/memorydata/awareness/har/HarSensorHandler;", "harDemandGate", "Lcom/obric/memorydata/awareness/har/HarDemandGate;", "connectedBluetooth", "", "", "Lcom/obric/memorydata/awareness/har/HarPredict$BluetoothInfo;", "smartBluetoothEventCallback", "com/obric/memorydata/awareness/har/HarPredict$smartBluetoothEventCallback$1", "Lcom/obric/memorydata/awareness/har/HarPredict$smartBluetoothEventCallback$1;", "updateSensorThreshold", "", "updateHarAllDayCollect", "scheduleUpdateHarEnabled", "updateHarEnabled", CommonConsts.APM_INNER_EVENT_COST_INIT, "initInternal", "enable", "disable", "notifyHarDisabled", "requestSmartBluetoothEvent", "harLevel2DataResp", "com/obric/memorydata/awareness/har/HarPredict$harLevel2DataResp$1", "Lcom/obric/memorydata/awareness/har/HarPredict$harLevel2DataResp$1;", "harDataLock", "", ObricMemoryConstants.KEY_SESSION_ID, "typeBuffers", "", "", "typeFiles", "Ljava/io/File;", "bufferFlushSize", "typeNameOf", "type", "getSessionDir", "ensureTypeFileLocked", "flushType", "flushTypeLocked", "processPacket", "packet", "Lcom/obric/cae/libs/useraware/UnifiedDataPacket;", "collectData", "triggerType", "events", "", "Lcom/obric/memorydata/awareness/har/HarEvent;", "airPressures", "", "testTriggerCollectData", "stopCollectDataIfNeeded", "requestData", "requestMap", "", "Lcom/obric/memorydata/awareness/har/RequestType;", "runPredict", "notifyState", "harState", "startPredict", "isCache", "startPredictInternal", "notifyCellChanged", "holdWakeLock", "timeMillis", "", "releaseWakeLock", "newWakeLock", "isLocationServiceEnabled", "isBluetoothEnabled", "onEvent", "eventName", WsConstants.KEY_EXTRA, "onFeatureChanged", "feature", "oldValue", "newValue", "onSettingsChanged", "key", "getCurrentHarStateDesc", "Companion", "BluetoothInfo", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HarPredict implements com.obric.memorydata.awareness.api.a, SettingsChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8604a = null;
    private static long r;
    private static final Set<Integer> s = null;
    private static final Lazy<HarPredict> t = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f8605b;
    private final AtomicReference<com.obric.cae.libs.useraware.b> c;
    private PowerManager.WakeLock d;
    private AtomicBoolean e;
    private boolean f;
    private boolean g;
    private final com.obric.memorydata.awareness.har.b h;
    private final com.obric.memorydata.awareness.har.a i;
    private final Map<String, BluetoothInfo> j;
    private final f k;
    private final c l;
    private final Object m;
    private String n;
    private final Map<Integer, List<Object>> o;
    private final Map<Integer, File> p;
    private final int q;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/awareness/har/HarPredict$BluetoothInfo;", "", MemoryKeyInfoEntity.KEY_ADDRESS, "", ActivityLifecycle.NAME, "profiles", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getName", "setName", "getProfiles", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BluetoothInfo {
        private String address;
        private String name;
        private final Set<String> profiles;

        public BluetoothInfo(String r3, String r4, Set<String> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, MemoryKeyInfoEntity.KEY_ADDRESS);
            Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r6, "profiles");
            this.address = r3;
            this.name = r4;
            this.profiles = r6;
        }

        public static /* synthetic */ BluetoothInfo copy$default(BluetoothInfo r1, String r2, String r3, Set r4, int r5, Object r6) {
            Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = r1.address;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = r1.name;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r7 = r1.profiles;
        L12:
            return r1.copy(r2, r3, r7);
        }

        public final String component1() {
            return this.address;
        }

        public final String component2() {
            return this.name;
        }

        public final Set<String> component3() {
            return this.profiles;
        }

        public final BluetoothInfo copy(String r2, String r3, Set<String> r4) {
            Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, MemoryKeyInfoEntity.KEY_ADDRESS);
            Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r1, "profiles");
            return new BluetoothInfo(r2, r3, r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, BluetoothInfo.class) == true) goto L8;
            return false;
        L8:
            BluetoothInfo r6 = (BluetoothInfo) ZeusTransformUtils.preCheckCast(r5, BluetoothInfo.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.address, r6.address) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.profiles, r6.profiles) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getAddress() {
            return this.address;
        }

        public final String getName() {
            return this.name;
        }

        public final Set<String> getProfiles() {
            return this.profiles;
        }

        public int hashCode() {
            return (((this.address.hashCode() * 31) + this.name.hashCode()) * 31) + this.profiles.hashCode();
        }

        public final void setAddress(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.address = r2;
        }

        public final void setName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.name = r2;
        }

        public String toString() {
            return "BluetoothInfo(address=" + this.address + ", name=" + this.name + ", profiles=" + this.profiles + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/obric/memorydata/awareness/har/HarPredict$Companion;", "", "<init>", "()V", "TAG", "", "TASK_NAME", "PREDICT_TYPE", "TASK_TYPE_NOTIFY", "TASK_TYPE_ALL_DAY_COLLECT", "TASK_TYPE_TASK", "KEY_TRIGGER_TYPE", "TRIGGER_TYPE_LEVEL1", "TRIGGER_TYPE_CELL_CHANGE", "TRIGGER_TYPE_GPS_CHANGE", "KEY_CONNECTED_BT_LIST", "HAR_COLLECT_DATA", "KEY_SETTING_CAE_COLLECT_LOCAL", "KEY_LEVEL2_HAR_STATE", "CELL_INFO_NOTIFY_INTERVAL", "", "HAR_STATE_DISABLED", "", "MSG_NOTIFY_CELL_CHANGE", "lastNotifyCellTime", "TRAFFIC_MODES", "", "instanceLazy", "Lcom/obric/memorydata/awareness/har/HarPredict;", "getInstanceLazy", "()Lcom/obric/memorydata/awareness/har/HarPredict;", "instanceLazy$delegate", "Lkotlin/Lazy;", "getInstance", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final HarPredict b() {
            return (HarPredict) ZeusTransformUtils.preCheckCast(HarPredict.g().getValue(), HarPredict.class, "com.obric.memorydata.plugin");
        }

        public final HarPredict a() {
            return b();
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends RequestType>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/awareness/har/HarPredict$harLevel2DataResp$1", "Lcom/obric/cae/libs/useraware/HarLevel2DataResp$Stub;", "onCollectStats", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "pfd", "Landroid/os/ParcelFileDescriptor;", "onDataReady", "bufferIndex", "", "totalBatchSize", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends com.obric.cae.libs.useraware.a.AbstractBinderC0345a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HarPredict f8606a;

        c(HarPredict r1) {
            this.f8606a = r1;
        }

        private static final Unit a(int r3, int r4, Exception r5) {
            Intrinsics.checkNotNullParameter(r5, "e");
            RunLog.INSTANCE.error("HarPredict", "handle har shm batch failed, drop batch, bufferIndex=" + r3 + ", totalBatchSize=" + r4, (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }

        private static final Unit a(HarPredict r4, int r5, int r6) {
            com.obric.cae.libs.useraware.b r0 = (com.obric.cae.libs.useraware.b) ZeusTransformUtils.preCheckCast(HarPredict.f(r4).get(), com.obric.cae.libs.useraware.b.class, "com.obric.memorydata.plugin");
            Unit r1 = null;
            if (r0 == null) goto L22;
            AtomicReference r2 = HarPredict.f(r4);
            monitor-enter(r2);
            ByteBuffer r3 = r0.c();     // Catch: Throwable -> L19
            if (r3 == null) goto L17;
            ByteBuffer r7 = r3.duplicate();     // Catch: Throwable -> L19
            if (r7 == null) goto L17;
            List<UnifiedDataPacket> r8 = r0.a(r7, r5, r6);     // Catch: Throwable -> L19
            if (r8 == null) goto L17;
            Iterator<UnifiedDataPacket> r9 = r8.iterator();     // Catch: Throwable -> L19
        L14:
            if (r9.hasNext() == false) goto L16;
            HarPredict.a(r4, (UnifiedDataPacket) ZeusTransformUtils.preCheckCast(r9.next(), UnifiedDataPacket.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
            goto L14
        L16:
            r1 = Unit.INSTANCE;     // Catch: Throwable -> L19
        L17:
            monitor-exit(r2);
        L19:
            th = move-exception;
            throw th;
        L22:
            return r1;
        }

        private static final void a(final int r2, final int r3, final HarPredict r4) {
            y.a(new $$Lambda$HarPredict$c$Rr93gwoaC7SrjSF7ipfVjXIpW64(r2, r3), new $$Lambda$HarPredict$c$iFcGOxaiAsiIqtDGJx10lQwGHZg(r4, r2, r3));
        }

        public static /* synthetic */ Unit lambda$Rr93gwoaC7SrjSF7ipfVjXIpW64(int r0, int r1, Exception r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ Unit lambda$iFcGOxaiAsiIqtDGJx10lQwGHZg(HarPredict r0, int r1, int r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$nKVomHSSpMW7Jk_bcRqUgWqEkPw(int r0, int r1, HarPredict r2) {
            a(r0, r1, r2);
        }

        @Override // com.obric.cae.libs.useraware.a
        public void a(final int r3, final int r4) {
            g r0 = HarPredict.g(this.f8606a);
            final HarPredict r2 = this.f8606a;
            r0.post(new $$Lambda$HarPredict$c$nKVomHSSpMW7Jk_bcRqUgWqEkPw(r3, r4, r2));
        }

        @Override // com.obric.cae.libs.useraware.a
        public void a(boolean r8, ParcelFileDescriptor r9) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "onCollectStats start: " + r8 + ", pfd: " + r9, false, 4, null);
            AtomicReference r0 = HarPredict.f(this.f8606a);
            HarPredict r7 = this.f8606a;
            monitor-enter(r0);
            if (r8 == false) goto L20;
            if (r9 == null) goto L20;
            com.obric.cae.libs.useraware.b r10 = new com.obric.cae.libs.useraware.b();     // Catch: Throwable -> L26
            if (r10.a(r9) == false) goto L19;
            Object r11 = HarPredict.j(r7);     // Catch: Throwable -> L26
            monitor-enter(r11);     // Catch: Throwable -> L26
            HarPredict.a(r7, String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L16
            HarPredict.h(r7).clear();     // Catch: Throwable -> L16
            HarPredict.i(r7).clear();     // Catch: Throwable -> L16
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(r11);     // Catch: Throwable -> L26
            com.obric.cae.libs.useraware.b r12 = (com.obric.cae.libs.useraware.b) ZeusTransformUtils.preCheckCast(HarPredict.f(r7).getAndSet(r10), com.obric.cae.libs.useraware.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
            if (r12 == null) goto L24;
            r12.b();     // Catch: Throwable -> L26
        L15:
            Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L26
        L24:
            monitor-exit(r0);
            return;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L19:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "onCollectStats failed to open shm", null, 4, null);     // Catch: Throwable -> L26
            r10.b();     // Catch: Throwable -> L26
        L20:
            com.obric.cae.libs.useraware.b r14 = (com.obric.cae.libs.useraware.b) ZeusTransformUtils.preCheckCast(HarPredict.f(r7).getAndSet(null), com.obric.cae.libs.useraware.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
            RunLog.INSTANCE.debug("HarPredict", "close old reader " + r14);     // Catch: Throwable -> L26
            if (r14 == null) goto L15;
            r14.b();     // Catch: Throwable -> L26
            HarPredict.k(r7);     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements i<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f8607a;

        /* JADX INFO: renamed from: com.obric.memorydata.awareness.har.HarPredict$d$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f8608a;

            public AnonymousClass1(j r3) {
                this.f8608a = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, HarPredict$init$$inlined$filter$1$2$1.class) == false) goto L7;
                HarPredict$init$$inlined$filter$1$2$1 r0 = (HarPredict$init$$inlined$filter$1$2$1) ZeusTransformUtils.preCheckCast(r8, HarPredict$init$$inlined$filter$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L20:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                j r5 = this.f8608a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                if (((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L20;
                r0.label = 1;
                if (r5.emit(r6, r0) != r2) goto L20;
                return r2;
            L7:
                r0 = new HarPredict$init$$inlined$filter$1$2$1(this, r8);
                goto L8
            }
        }

        public d(i r3) {
            this.f8607a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(j<? super Boolean> r3, Continuation r4) {
            j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f8607a.collect((j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/har/HarPredict$initInternal$3", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HarPredict f8609a;

        e(HarPredict r1) {
            this.f8609a = r1;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r8) {
            h r9 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "data");
            RunLog.INSTANCE.debug("HarPredict", "onDataReceive: " + r9 + ' ' + ZeusTransformUtils.instanceOf(r9, p.class));
            if (ZeusTransformUtils.instanceOf(r9, p.class) == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L7;
            return;
        L7:
            if (HarPredict.d(this.f8609a) == false) goto L12;
            HarPredict.a(this.f8609a, "all_day_collect", null, null, null, 14, null);
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/awareness/har/HarPredict$smartBluetoothEventCallback$1", "Lcom/obric/cae/libs/bluetooth/ISmartBluetoothEventCallback$Stub;", "onEventReported", "", "smartBluetoothEvent", "Lcom/obric/cae/libs/bluetooth/SmartBluetoothEvent;", "onEBikeAware", CommonConsts.COUNT_TYPE, "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends com.obric.cae.libs.bluetooth.a.AbstractBinderC0318a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HarPredict f8610a;

        f(HarPredict r1) {
            this.f8610a = r1;
        }

        @Override // com.obric.cae.libs.bluetooth.a
        public void a(int r1) {
        }

        @Override // com.obric.cae.libs.bluetooth.a
        public void a(SmartBluetoothEvent r10) {
            String r0 = "";
            Intrinsics.checkNotNullParameter(r10, "smartBluetoothEvent");
            BluetoothDevice r3 = r10.getBluetoothDevice();
            if (r3 != null) goto L58;
            return;
        L58:
            String r4 = r3.getName();     // Catch: SecurityException -> L9
            if (r4 == null) goto L11;
            r0 = r4;
        L11:
            String r5 = r3.getAddress();
            if (r5 != null) goto L14;
            return;
        L14:
            String r6 = r10.getProfileName();
            if (r6 != null) goto L17;
            return;
        L17:
            String r11 = r10.getStateName();
            if (r11 != null) goto L20;
            return;
        L20:
            RunLog.INSTANCE.debug("HarPredict", "onBluetoothEvent, address: " + r5 + ", profile: " + r6 + ", state: " + r11);
            int r7 = r11.hashCode();
            if (r7 == (-1874807991)) goto L39;
            if (r7 == (-1594904421)) goto L31;
            if (r7 == 1632751168) goto L28;
            return;
        L28:
            if (r11.equals("STATE_PLAYING") == false) goto L61;
        L33:
            Map r12 = HarPredict.e(this.f8610a);
            Object r8 = r12.get(r5);
            if (r8 != null) goto L36;
            r8 = new BluetoothInfo(r5, r0, (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"));
            r12.put(r5, r8);
        L36:
            ((BluetoothInfo) ZeusTransformUtils.preCheckCast(r8, BluetoothInfo.class, "com.obric.memorydata.plugin")).getProfiles().add(r6);
            RunLog r13 = RunLog.INSTANCE;
            StringBuilder r1 = new StringBuilder();
        L37:
            r13.debug("HarPredict", r1.append("current connected bluetooth ").append(HarPredict.e(this.f8610a)).toString());
            return;
        L61:
            return;
        L31:
            if (r11.equals("STATE_CONNECTED") == true) goto L33;
            return;
        L39:
            if (r11.equals("STATE_DISCONNECTED") == false) goto L63;
            BluetoothInfo r14 = (BluetoothInfo) ZeusTransformUtils.preCheckCast(HarPredict.e(this.f8610a).get(r5), BluetoothInfo.class, "com.obric.memorydata.plugin");
            if (r14 == null) goto L46;
            Set<String> r15 = r14.getProfiles();
            if (r15 == null) goto L46;
            r15.remove(r6);
        L46:
            BluetoothInfo r16 = (BluetoothInfo) ZeusTransformUtils.preCheckCast(HarPredict.e(this.f8610a).get(r5), BluetoothInfo.class, "com.obric.memorydata.plugin");
            boolean r2 = true;
            if (r16 == null) goto L53;
            Set<String> r17 = r16.getProfiles();
            if (r17 == null) goto L53;
            if (r17.isEmpty() != true) goto L53;
        L54:
            if (r2 == false) goto L56;
            HarPredict.e(this.f8610a).remove(r5);
        L56:
            r13 = RunLog.INSTANCE;
            r1 = new StringBuilder();
        L53:
            r2 = false;
            goto L54
        L63:
            return;
        L9:
            e = move-exception;
            RunLog.INSTANCE.error("HarPredict", "get device name failed for SecurityException", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L11
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/har/HarPredict$workerHandler$2$1", "Landroid/os/Handler;", "dispatchMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HarPredict f8611a;

        g(HarPredict r1, Looper r2) {
            this.f8611a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message r9) {
            Intrinsics.checkNotNullParameter(r9, NotificationCompat.CATEGORY_MESSAGE);
            super.dispatchMessage(r9);
            if (r9.what != 1001) goto L6;
            HarPredict.a(this.f8611a, "notify", "cell_change", null, null, 12, null);
            return;
        }
    }

    static {
        f8604a = new a(null);
        s = SetsKt.setOf(new Integer[]{8, 5, 6, 7});
        t = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$HarPredict$bzI5IsrDH0FY7CDm0TNq_GWGiyg.INSTANCE);
    }

    private HarPredict() {
        this.f8605b = LazyKt.lazy(new $$Lambda$HarPredict$HafiOovz9WDUSSNh9IvXBMJ9h1U(this));
        this.c = new AtomicReference(null);
        this.e = new AtomicBoolean(false);
        this.h = new com.obric.memorydata.awareness.har.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.i = new com.obric.memorydata.awareness.har.a((Function0) ZeusTransformUtils.preCheckCast(new HarPredict$harDemandGate$1(this), Function0.class, "com.obric.memorydata.plugin"));
        this.j = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.k = new f(this);
        this.l = new c(this);
        this.m = new Object();
        this.o = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.p = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.q = 100;
    }

    private static final Boolean a(File r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return Boolean.valueOf(FilesKt.deleteRecursively(r0));
    }

    private final String a(int r1) {
        switch(r1) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L3;
        };
    L3:
        return "unknown";
    L4:
        return "sensor";
    L5:
        return "gnss";
    L6:
        return "gps";
    L7:
        return LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL;
    L8:
        return "bt";
    L9:
        return LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI;
    }

    private static final String a(Object r1) {
        return GsonUtil.INSTANCE.toJson(r1);
    }

    private static final Unit a(HarPredict r6, Object r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "debug onCollectData", false, 4, null);
        r6.e();
        return Unit.INSTANCE;
    }

    private final void a(long r2) {
        PowerManager.WakeLock r0 = t();
        this.d = r0;
        if (r0 == null) goto L6;
        r0.acquire(r2);
        return;
    }

    private final void a(UnifiedDataPacket r7) {
        Object r0 = this.m;
        monitor-enter(r0);
        Map<Integer, List<Object>> r1 = this.o;     // Catch: Throwable -> L34
        Integer r2 = Integer.valueOf(r7.getDataType());     // Catch: Throwable -> L34
        List<Object> r3 = r1.get(r2);     // Catch: Throwable -> L34
        if (r3 != null) goto L7;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        r1.put(r2, r3);     // Catch: Throwable -> L34
    L7:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        switch(r7.getDataType()) {
            case 1: goto L25;
            case 2: goto L22;
            case 3: goto L19;
            case 4: goto L16;
            case 5: goto L13;
            case 6: goto L10;
            default: goto L29;
        };     // Catch: Throwable -> L34
    L10:
        Parcelable r5 = (SensorEventInfo) ZeusTransformUtils.preCheckCast(r7.getData(), SensorEventInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r5 == null) goto L29;
    L12:
        r4.add(r5);     // Catch: Throwable -> L34
        goto L29
    L13:
        GnssSvAwareInfo r6 = (GnssSvAwareInfo) ZeusTransformUtils.preCheckCast(r7.getData(), GnssSvAwareInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r6 == null) goto L29;
        r4.add(new Triple(0, Integer.valueOf(r6.getVisibleSvCount()), Float.valueOf(r6.getVisibleSvMeanCn0())));     // Catch: Throwable -> L34
        goto L29
    L16:
        r5 = (LocationAwareInfo) ZeusTransformUtils.preCheckCast(r7.getData(), LocationAwareInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r5 == null) goto L29;
    L19:
        r5 = (CellAwareInfo) ZeusTransformUtils.preCheckCast(r7.getData(), CellAwareInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r5 == null) goto L29;
    L22:
        r5 = (BtAwareInfo) ZeusTransformUtils.preCheckCast(r7.getData(), BtAwareInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r5 == null) goto L29;
    L25:
        r5 = (WifiStandardData) ZeusTransformUtils.preCheckCast(r7.getData(), WifiStandardData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        if (r5 != null) goto L12;
    L29:
        if (r4.size() < this.q) goto L31;
        c(r7.getDataType());     // Catch: Throwable -> L34
    L31:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(r0);
        return;
    L34:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void a(HarPredict r0) {
        r0.l();
    }

    public static final /* synthetic */ void a(HarPredict r0, UnifiedDataPacket r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(HarPredict r0, String r1) {
        r0.n = r1;
    }

    public static /* synthetic */ void a(HarPredict r1, String r2, String r3, List r4, List r5, int r6, Object r7) {
        List<HarEvent> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<Float> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r8 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r9 = null;
    L11:
        r1.a(r2, r3, r8, r9);
    }

    private static final void a(HarPredict r2, List r3, List r4, boolean r5) {
        r2.b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), r5);
    }

    public static /* synthetic */ void a(HarPredict r1, List r2, List r3, boolean r4, int r5, Object r6) {
        List<HarEvent> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<Float> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r8 = null;
    L5:
        r1.a(r7, r8, r4);
    }

    private static final void a(String r11, List r12, HarPredict r13, String r14, List r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "start har package with task type " + r11 + ", events: " + r16, false, 4, null);
        if (Intrinsics.areEqual(r11, "notify") == false) goto L5;
        r13.q();
    L5:
        JSONObject r2 = new JSONObject();
        r2.put("type", r11);
        boolean r0 = false;
        if (Intrinsics.areEqual(r11, "notify") == false) goto L18;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L10;
    L13:
        boolean r19 = true;
    L14:
        if (r19 == true) goto L18;
        r2.put("trigger_type", r14);
        if (Intrinsics.areEqual(r14, "cell_change") == false) goto L18;
        r = System.currentTimeMillis();
        goto L18
    L10:
        if (r18.length() == 0) goto L13;
        r19 = false;
    L18:
        String r110 = u.a(r13.j.values());
        r2.put("connected_bluetooth_list", r110);
        RunLog.INSTANCE.debug("HarPredict", "bluetooth info: " + r110);
        JSONArray r111 = new JSONArray();
        if (r16 == null) goto L24;
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r112.hasNext() == false) goto L24;
        HarEvent r113 = (HarEvent) ZeusTransformUtils.preCheckCast(r112.next(), HarEvent.class, "com.obric.memorydata.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("har_state", r113.getState());
        r5.put("timestamp", r113.getTimestamp());
        r111.put(r5);
    L24:
        r2.put("har_sensor_list", r111.toString());
        if (r17 == null) goto L27;
        String r114 = u.a(r17);
        r2.put("air_pressure_list", r114);
        RunLog.INSTANCE.debug("HarPredict", "air pressure info: " + r114);
    L27:
        TaskResult r115 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("level_2_har").setInputParam(r2), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "notify return code: " + r115.getCode() + ", output: " + r115.getOutput(), false, 4, null);
        if (r115.getCode() == 0) goto L50;
        r13.s();
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "getRequestDataParam failed, code: " + r115.getCode() + ", msg: " + r115.getMsg(), null, 4, null);
        return;
    L50:
        r13.d(r115.getOutput().getInt("run_model_result"));     // Catch: JSONException -> L49
    L30:
        String r116 = r115.getOutput().optString("dispatch_result");
        int r117 = r115.getOutput().optInt("need_return_data", -1);
        if (r117 == 0) goto L35;
        if (r117 != 1) goto L37;
        RunLog.INSTANCE.debug("HarPredict", "set2 cae_user_har_collect_local to 0");
        Settings.Global.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_COLLECT_LOCAL, 0);
    L36:
        Thread.sleep(500);
    L37:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "collect task: " + r116, false, 4, null);
        Intrinsics.checkNotNull(r116);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L40;
        r0 = true;
    L40:
        if (r0 == false) goto L46;
        List r118 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r116, new b().getType()), List.class, "com.obric.memorydata.plugin");
        Map<String, RequestType> r119 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r120 = ((Iterable) ZeusTransformUtils.preCheckCast(r118, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L43:
        if (r120.hasNext() == false) goto L45;
        RequestType r121 = (RequestType) ZeusTransformUtils.preCheckCast(r120.next(), RequestType.class, "com.obric.memorydata.plugin");
        r119.put(r121.getRequestType(), r121);
        goto L43
    L45:
        r13.a(r119);
        return;
    L46:
        RunLog.INSTANCE.debug("HarPredict", "no need collect data");
        r13.s();
        return;
    L35:
        RunLog.INSTANCE.debug("HarPredict", "开始采集2小时的数据, " + r116);
        RunLog.INSTANCE.debug("HarPredict", "set cae_user_har_collect_local to 1");
        Settings.Global.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_COLLECT_LOCAL, 1);
        goto L36
    }

    private final void a(Map<String, RequestType> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        List<HarLevel2DataReq> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.entrySet().iterator();
        int r2 = 61000;
    L4:
        if (r11.hasNext() == false) goto L41;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
        RequestType r5 = (RequestType) ZeusTransformUtils.preCheckCast(r3.getValue(), RequestType.class, "com.obric.memorydata.plugin");
        switch(r4.hashCode()) {
            case -1992012396: goto L30;
            case -905948230: goto L25;
            case 3154: goto L21;
            case 102570: goto L17;
            case 3049826: goto L13;
            case 3649301: goto L9;
            default: goto L4;
        };
    L9:
        if (r4.equals(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI) == false) goto L4;
        HarLevel2DataReq r6 = new HarLevel2DataReq(1, r5.getCount(), r5.getInterval(), r5.getTimeout());
    L28:
        r0.add(r6);
        goto L4
    L13:
        if (r4.equals(LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL) == false) goto L4;
        r6 = new HarLevel2DataReq(3, r5.getCount(), r5.getInterval(), r5.getTimeout());
        goto L28
    L17:
        if (r4.equals("gps") == false) goto L4;
        r6 = new HarLevel2DataReq(4, r5.getCount(), r5.getInterval(), r5.getTimeout());
        goto L28
    L21:
        if (r4.equals("bt") == false) goto L4;
        r6 = new HarLevel2DataReq(2, r5.getCount(), r5.getInterval(), r5.getTimeout());
        goto L28
    L25:
        if (r4.equals("sensor") == false) goto L4;
        r6 = new HarLevel2DataReq(5, r5.getCount(), r5.getInterval(), r5.getTimeout());
        goto L28
    L30:
        if (r4.equals("duration") == false) goto L4;
        r2 = r5.getTimeout();
        goto L4
    L41:
        a(((long) r2) + 5000);     // Catch: RemoteException -> L38
        com.obric.cae.libs.useraware.f r12 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();     // Catch: RemoteException -> L38
        if (r12 == null) goto L66;
        r12.a(r0, r2, (com.obric.cae.libs.useraware.a) ZeusTransformUtils.preCheckCast(this.l, com.obric.cae.libs.useraware.a.class, "com.obric.memorydata.plugin"));     // Catch: RemoteException -> L38
        return;
    L66:
        return;
    L38:
        e = move-exception;
        RunLog.INSTANCE.error("HarPredict", "setLevel2DataCollection failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final File b(int r4) {
        Map<Integer, File> r0 = this.p;
        Integer r1 = Integer.valueOf(r4);
        File r2 = r0.get(r1);
        if (r2 != null) goto L6;
        r2 = new File(p(), a(r4) + ".ndjson");
        r0.put(r1, r2);
    L6:
        return (File) ZeusTransformUtils.preCheckCast(r2, File.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void b(HarPredict r0) {
        r0.m();
    }

    private final void b(List<HarEvent> r12, List<Float> r13, boolean r14) {
        List<HarEvent> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<Float> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        if (this.g == true) goto L6;
        RunLog.INSTANCE.debug("HarPredict", "har disabled, skip startPredict");
        return;
    L6:
        boolean r5 = false;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "startPredict with sensor events " + r15, false, 4, null);
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L9;
    L11:
        Iterator r18 = r17.iterator();
    L13:
        if (r18.hasNext() == false) goto L20;
        if (((HarEvent) ZeusTransformUtils.preCheckCast(r18.next(), HarEvent.class, "com.obric.memorydata.plugin")).getState() != 5) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L13;
        r5 = true;
        goto L20
    L17:
        r2 = false;
    L20:
        if (r5 == true) goto L22;
    L27:
        a("notify", "level_1", r15, r16);
        if (CollectionsKt.contains((Iterable) ZeusTransformUtils.preCheckCast(s, Iterable.class, "com.obric.memorydata.plugin"), FeatureManager.INSTANCE.getFeature("har_activity_state")) == false) goto L31;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "skip predict cache data in traffic mode", false, 4, null);
        return;
    L31:
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L33:
        if (r19.hasNext() == false) goto L45;
        HarEvent r110 = (HarEvent) ZeusTransformUtils.preCheckCast(r19.next(), HarEvent.class, "com.obric.memorydata.plugin");
        if (r110.getState() == 5) goto L37;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "setHarState, state: " + r110.getState() + ", timestamp: " + r110.getTimestamp(), false, 4, null);     // Catch: RemoteException -> L43
        com.obric.cae.libs.useraware.f r111 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();     // Catch: RemoteException -> L43
        if (r111 == null) goto L41;
        r111.a(r110.getState(), r110.getTimestamp(), 1);     // Catch: RemoteException -> L43
    L41:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "setHarState success", false, 4, null);     // Catch: RemoteException -> L43
        goto L33
    L37:
        a(5000);     // Catch: RemoteException -> L43
    L43:
        e = move-exception;
        RunLog.INSTANCE.error("HarPredict", "setHarState failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L33
    L45:
        return;
    L22:
        if (u() == true) goto L24;
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "skip startPredict: level2 wakeup but location or bluetooth disabled", false, 4, null);
        return;
    L24:
        if (v() == true) goto L27;
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L11;
        goto L11
    }

    private final void c(int r10) {
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.o.get(Integer.valueOf(r10)), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isEmpty() == false) goto L36;
        return;
    L36:
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(new BufferedWriter((Writer) ZeusTransformUtils.preCheckCast(new OutputStreamWriter((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(b(r10), true), OutputStream.class, "com.obric.memorydata.plugin"), Charsets.UTF_8), Writer.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25 IOException -> L27
        BufferedWriter r3 = (BufferedWriter) ZeusTransformUtils.preCheckCast(r1, BufferedWriter.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L20
    L12:
        if (r4.hasNext() == false) goto L17;
        final Object r5 = r4.next();     // Catch: Throwable -> L20
        String r6 = (String) ZeusTransformUtils.preCheckCast(y.a(null, new $$Lambda$HarPredict$3VTikw2YT3aaa2wbrteRb8Xvbg(r5), 1, null), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r6 == null) goto L12;
        r3.write(r6);     // Catch: Throwable -> L20
        r3.write("\n");     // Catch: Throwable -> L20
        goto L12
    L17:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L25 IOException -> L27
    L29:
        r0.clear();
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L25 IOException -> L27
        throw th;     // Catch: Throwable -> L25 IOException -> L27
    L27:
        e = move-exception;
        RunLog.INSTANCE.error("HarPredict", "flushType failed for " + a(r10), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r0.clear();
        throw th;
    }

    public static final /* synthetic */ void c(HarPredict r0) {
        r0.k();
    }

    private final void d(int r8) {
    L13:
        e = move-exception;
        RunLog.INSTANCE.error("HarPredict", "setHarState or notifyHarEvent failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L4:
        if (com.obric.memorydata.awareness.cae.a.f8559a.a().a() != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "setHarState or notifyHarEvent failed, service is null", null, 4, null);     // Catch: RemoteException -> L13
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "notifyState, harState: " + r8, false, 4, null);     // Catch: RemoteException -> L13
        com.obric.cae.libs.useraware.f r0 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();     // Catch: RemoteException -> L13
        if (r0 == null) goto L9;
        r0.a(r8, System.currentTimeMillis(), 2);     // Catch: RemoteException -> L13
    L9:
        com.obric.cae.libs.useraware.f r1 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();     // Catch: RemoteException -> L13
        if (r1 == null) goto L18;
        r1.a(new HarEventData(r8, System.currentTimeMillis()));     // Catch: RemoteException -> L13
        return;
    }

    public static final /* synthetic */ boolean d(HarPredict r0) {
        return r0.f;
    }

    public static final /* synthetic */ Map e(HarPredict r0) {
        return r0.j;
    }

    public static final /* synthetic */ AtomicReference f(HarPredict r0) {
        return r0.c;
    }

    public static final /* synthetic */ g g(HarPredict r0) {
        return r0.h();
    }

    public static final /* synthetic */ Lazy g() {
        return t;
    }

    private final g h() {
        return (g) ZeusTransformUtils.preCheckCast(this.f8605b.getValue(), g.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Map h(HarPredict r0) {
        return r0.o;
    }

    public static final /* synthetic */ Map i(HarPredict r0) {
        return r0.p;
    }

    private final void i() {
        SettingsManager r9 = SettingsManager.INSTANCE;
        String r0 = r9.getSettingsStr(SettingsManager.KEY_SENSORHUB_THRESHOLD_SETTINGS);
        Object r1 = null;
        if (r0 != null) goto L19;
    L9:
        HarMonitorParams r10 = (HarMonitorParams) ZeusTransformUtils.preCheckCast(r1, HarMonitorParams.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "update threshold " + u.a(r10), false, 4, null);
        com.obric.cae.libs.useraware.f r2 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();     // Catch: RemoteException -> L16
        if (r2 == null) goto L24;
        r2.a(r10);     // Catch: RemoteException -> L16
        Unit r11 = Unit.INSTANCE;     // Catch: RemoteException -> L16
        return;
    L24:
        return;
    L16:
        e = move-exception;
        RunLog.INSTANCE.error("HarPredict", "update threshold failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        Unit r12 = Unit.INSTANCE;
        return;
    L23:
        return;
    L19:
        r1 = r9.getGSON().fromJson(r0, HarMonitorParams.class);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        goto L9
    }

    public static final /* synthetic */ Object j(HarPredict r0) {
        return r0.m;
    }

    private final void j() {
        JSONObject r0 = SettingsManager.INSTANCE.getJson(SettingsManager.KEY_AB_SWITCH_SETTINGS);
        if (r0 == null) goto L11;
        boolean r2 = false;
        if (r0.optInt("har_all_day_collect_enabled", 0) != 1) goto L7;
        r2 = true;
    L7:
        this.f = r2;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "update all day collect " + this.f, false, 4, null);
        if (this.f == false) goto L12;
        q();
        return;
    L12:
        return;
    }

    private final void k() {
        kotlinx.coroutines.i.a(com.obric.memorydata.utils.j.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new HarPredict$scheduleUpdateHarEnabled$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ void k(HarPredict r0) {
        r0.r();
    }

    private static final g l(HarPredict r2) {
        HandlerThread r0 = new HandlerThread("har_predict");
        r0.start();
        return new g(r2, r0.getLooper());
    }

    private final synchronized void l() {
        monitor-enter(this);
        JSONObject r0 = SettingsManager.INSTANCE.getJson(SettingsManager.KEY_AB_SWITCH_SETTINGS);     // Catch: Throwable -> L24
        boolean r1 = false;
        if (r0 != null) goto L7;
    L5:
        boolean r2 = true;
    L10:
        boolean r3 = this.i.c();     // Catch: Throwable -> L24
        if (r2 == false) goto L17;
        if (com.obric.memorydata.b.a.f8796a.b() == false) goto L17;
        if (r3 == false) goto L17;
        r1 = true;
    L17:
        if (r1 == this.g) goto L22;
        this.g = r1;     // Catch: Throwable -> L24
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "HAR 开关更新：enabled=" + this.g + ", hasDemand=" + r3, false, 4, null);     // Catch: Throwable -> L24
        if (this.g == false) goto L21;
        c();     // Catch: Throwable -> L24
        goto L22
    L21:
        d();     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L7:
        if (r0.optInt("har_enabled", 1) == 1) goto L5;
        r2 = false;
    L24:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$3VTikw2YT3aaa2wbrteRb8Xv-bg, reason: not valid java name */
    public static /* synthetic */ String m497lambda$3VTikw2YT3aaa2wbrteRb8Xvbg(Object r0) {
        return a(r0);
    }

    public static /* synthetic */ g lambda$HafiOovz9WDUSSNh9IvXBMJ9h1U(HarPredict r0) {
        return l(r0);
    }

    /* JADX INFO: renamed from: lambda$NvQRe1ahzZ_aHyXe7T-H6ss-I8o, reason: not valid java name */
    public static /* synthetic */ Boolean m498lambda$NvQRe1ahzZ_aHyXe7TH6ssI8o(File r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$Qa_mXuwsh6F13nJ-a-TbKVhpfxM, reason: not valid java name */
    public static /* synthetic */ void m499lambda$Qa_mXuwsh6F13nJaTbKVhpfxM(HarPredict r0, List r1, List r2, boolean r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$SfRWJpsof8svtWoMKVmLmKkIoLQ(HarPredict r0) {
        return n(r0);
    }

    public static /* synthetic */ HarPredict lambda$bzI5IsrDH0FY7CDm0TNq_GWGiyg() {
        return w();
    }

    public static /* synthetic */ Unit lambda$dc7jU5Me0GgX4nSCPpfk03oGMSk(HarPredict r0, Object r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$jf3lQNUzlm50TD1I-Fod2S7TIN4, reason: not valid java name */
    public static /* synthetic */ void m500lambda$jf3lQNUzlm50TD1IFod2S7TIN4(String r0, List r1, HarPredict r2, String r3, List r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$sjslF27ZT190FgUraBPbeVuRhNM(HarPredict r0) {
        m(r0);
    }

    private final void m() {
        if (this.e.get() == false) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "initInternal", false, 4, null);
        this.e.set(true);
        SettingsManager.INSTANCE.registerChangeListener(SettingsManager.KEY_AB_SWITCH_SETTINGS, (SettingsChangeListener) ZeusTransformUtils.preCheckCast(this, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        SettingsManager.INSTANCE.registerChangeListener(SettingsManager.KEY_SENSORHUB_THRESHOLD_SETTINGS, (SettingsChangeListener) ZeusTransformUtils.preCheckCast(this, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.b.a.f8796a.a((Function0) ZeusTransformUtils.preCheckCast(new HarPredict$initInternal$1(this), Function0.class, "com.obric.memorydata.plugin"));
        this.i.b();
        l();
        j();
        if (AppContext.INSTANCE.isDebug() == false) goto L9;
        com.obric.memorydata.utils.eventbus.a.a(com.obric.memorydata.utils.eventbus.a.f13225a, "har_collect_data", null, new $$Lambda$HarPredict$dc7jU5Me0GgX4nSCPpfk03oGMSk(this), 2, null);
    L9:
        if (this.f == false) goto L11;
        a(this, "all_day_collect", null, null, null, 14, null);
    L11:
        new com.obric.memorydata.ability.d().a(new com.obric.memorydata.ability.f(100000005, MapsKt.mapOf(TuplesKt.to("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL))), (k) ZeusTransformUtils.preCheckCast(new e(this), k.class, "com.obric.memorydata.plugin"));
    }

    private static final void m(HarPredict r9) {
        Object r0 = r9.m;     // Catch: Throwable -> L50
        monitor-enter(r0);     // Catch: Throwable -> L50
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r9.o.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L47
    L6:
        if (r1.hasNext() == false) goto L8;
        r9.c(((Number) ZeusTransformUtils.preCheckCast(r1.next(), Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L47
        goto L6
    L8:
        Pair r2 = TuplesKt.to(r9.n, MapsKt.toMap(r9.p));     // Catch: Throwable -> L47
        monitor-exit(r0);     // Catch: Throwable -> L50
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.component1(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(r2.component2(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        if (r4.isEmpty() == false) goto L15;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "failed to runPredict, no data files", null, 4, null);     // Catch: Throwable -> L50
        r9.s();
        return;
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "runPredict start", false, 4, null);     // Catch: Throwable -> L50
        r9.a(5000);     // Catch: Throwable -> L50
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L50
        r5.put("type", "task");     // Catch: Throwable -> L50
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L50
        Iterator r7 = r4.entrySet().iterator();     // Catch: Throwable -> L50
    L17:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        r6.put(r9.a(((Number) ZeusTransformUtils.preCheckCast(r8.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue()), ((File) ZeusTransformUtils.preCheckCast(r8.getValue(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath());     // Catch: Throwable -> L50
        goto L17
    L19:
        r5.put("data_files", r6.toString());     // Catch: Throwable -> L50
        String r10 = u.a(r9.j.values());     // Catch: Throwable -> L50
        r5.put("connected_bluetooth_list", r10);     // Catch: Throwable -> L50
        RunLog.INSTANCE.debug("HarPredict", "runPredict, files: " + r6 + ", bluetooth info: " + r10);     // Catch: Throwable -> L50
        TaskResult r11 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("level_2_har").setInputParam(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();     // Catch: Throwable -> L50
        if (r11.getCode() != 0) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "runPredict success output " + r11.getOutput(), false, 4, null);     // Catch: Throwable -> L50
        r9.d(r11.getOutput().getInt("run_model_result"));     // Catch: JSONException -> L24 Throwable -> L50
    L28:
        if (r9.f == false) goto L31;
        a(r9, "all_day_collect", null, null, null, 14, null);     // Catch: Throwable -> L50
    L31:
        if (r3 == null) goto L33;
        final File r12 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "har_data/" + r3);     // Catch: Throwable -> L50
    L34:
        Object r13 = r9.m;     // Catch: Throwable -> L50
        monitor-enter(r13);     // Catch: Throwable -> L50
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L37:
        if (Intrinsics.areEqual(r9.n, r3) == false) goto L39;
        r9.o.clear();     // Catch: Throwable -> L44
        r9.p.clear();     // Catch: Throwable -> L44
        r9.n = null;     // Catch: Throwable -> L44
    L39:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r13);     // Catch: Throwable -> L50
        Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.sdk.d.a(new $$Lambda$HarPredict$NvQRe1ahzZ_aHyXe7TH6ssI8o(r12)), Boolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        r9.s();
        return;
    L33:
        r12 = null;
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L50
        goto L28
    L26:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "runPredict failed, code: " + r11.getCode() + ", msg: " + r11.getMsg(), null, 4, null);     // Catch: Throwable -> L50
        goto L28
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        r9.s();
        throw th;
    }

    private static final Unit n(HarPredict r2) {
        PowerManager.WakeLock r0 = r2.d;
        if (r0 != null) goto L5;
    L7:
        r2.d = null;
        return Unit.INSTANCE;
    L5:
        if (r0.isHeld() == false) goto L7;
        r0.release();
        goto L7
    }

    private final void n() {
        com.obric.cae.libs.useraware.f r0 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();     // Catch: RemoteException -> L9
        if (r0 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "setHarState disabled failed, service is null", null, 4, null);     // Catch: RemoteException -> L9
        return;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "setHarState disabled", false, 4, null);     // Catch: RemoteException -> L9
        r0.a(-1, System.currentTimeMillis(), 1);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        RunLog.INSTANCE.error("HarPredict", "setHarState disabled failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void o() {
        com.obric.cae.libs.useraware.f r1 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();     // Catch: RemoteException -> L7
        if (r1 == null) goto L12;
        r1.a((com.obric.cae.libs.bluetooth.a) ZeusTransformUtils.preCheckCast(this.k, com.obric.cae.libs.bluetooth.a.class, "com.obric.memorydata.plugin"));     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error("HarPredict", "registerSmartBluetoothEvent failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final File p() {
        String r0 = this.n;
        if (r0 != null) goto L5;
        r0 = String.valueOf(System.currentTimeMillis());
        this.n = r0;
    L5:
        File r4 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "har_data/" + r0);
        if (r4.exists() == true) goto L8;
        r4.mkdirs();
    L8:
        return r4;
    }

    private final void q() {
        boolean r3 = false;
        if (Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_COLLECT_LOCAL, 0) != 1) goto L6;
        r3 = true;
    L6:
        if (this.f == false) goto L12;
        if (r3 == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "stop collect", false, 4, null);
        com.obric.cae.libs.useraware.f r0 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();
        if (r0 == null) goto L14;
        r0.a(null, 1, (com.obric.cae.libs.useraware.a) ZeusTransformUtils.preCheckCast(this.l, com.obric.cae.libs.useraware.a.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        return;
    L13:
        return;
    }

    private final void r() {
        h().post(new $$Lambda$HarPredict$sjslF27ZT190FgUraBPbeVuRhNM(this));
    }

    private final void s() {
        com.obric.memorydata.sdk.d.a(new $$Lambda$HarPredict$SfRWJpsof8svtWoMKVmLmKkIoLQ(this));
    }

    private final PowerManager.WakeLock t() {
        s();
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock r3 = ((PowerManager) ZeusTransformUtils.preCheckCast(r2, PowerManager.class, "com.obric.memorydata.plugin")).newWakeLock(1, "HarPredict::MemoryData");
        Intrinsics.checkNotNullExpressionValue(r3, "newWakeLock(...)");
        return r3;
    }

    private final boolean u() {
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("location");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.location.LocationManager");
        return ((LocationManager) ZeusTransformUtils.preCheckCast(r2, LocationManager.class, "com.obric.memorydata.plugin")).isLocationEnabled();
    }

    private final boolean v() {
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("bluetooth");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter r3 = ((BluetoothManager) ZeusTransformUtils.preCheckCast(r2, BluetoothManager.class, "com.obric.memorydata.plugin")).getAdapter();
        if (r3 == null) goto L8;
        if (r3.isEnabled() != true) goto L8;
        return true;
    L8:
        return false;
    }

    private static final HarPredict w() {
        return new HarPredict();
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void a(String r9, Object r10, Object r11, Map<String, ? extends Object> r12) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "feature");
        if (Intrinsics.areEqual(r9, "har_activity_state") == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r11, Integer.class) == false) goto L8;
        Integer r13 = (Integer) ZeusTransformUtils.preCheckCast(r11, Integer.class, "com.obric.memorydata.plugin");
    L9:
        if (r13 == null) goto L12;
        int r1 = r13.intValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "har_activity_state changed: state=" + r1, false, 4, null);
        Tracker r14 = Tracker.INSTANCE;
        JSONObject r15 = new JSONObject();
        r15.put("state", r1);
        Unit r16 = Unit.INSTANCE;
        r14.reportEvent("har_activity_state", r15);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getHarStateDao().insert(new bz(r1, System.currentTimeMillis(), 0, 4, null));
        return;
    L12:
        return;
    L8:
        r13 = null;
        goto L9
    }

    public final void a(final String r9, final String r10, List<HarEvent> r11, List<Float> r12) {
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "type");
        if (this.f == true) goto L9;
        if (Intrinsics.areEqual(r9, "all_day_collect") == false) goto L9;
        RunLog.INSTANCE.debug("HarPredict", "all day collect disabled, skip collectData");
        return;
    L9:
        if (this.g == true) goto L12;
        RunLog.INSTANCE.debug("HarPredict", "har disabled, skip collectData");
        return;
    L12:
        h().post(new $$Lambda$HarPredict$jf3lQNUzlm50TD1IFod2S7TIN4(r9, r4, this, r10, r7));
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void a(String r2, Map<String, ? extends Object> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "eventName");
    }

    public final void a(List<HarEvent> r3, List<Float> r4, final boolean r5) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "events");
        h().post(new $$Lambda$HarPredict$Qa_mXuwsh6F13nJaTbKVhpfxM(this, r6, r7, r5));
    }

    @Override // com.obric.memorydata.awareness.api.a
    public boolean a() {
        return com.obric.memorydata.awareness.api.a.C0430a.a(this);
    }

    public final void b() {
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "har predict not supported on non-obric os device", false, 4, null);
        return;
    L7:
        if (this.h.a() == true) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "har sensor not supported", null, 4, null);
        return;
    L10:
        kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.f((i) ZeusTransformUtils.preCheckCast(new d((i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.awareness.cae.a.f8559a.a().b(), i.class, "com.obric.memorydata.plugin")), i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new HarPredict$init$2(this, null), Function2.class, "com.obric.memorydata.plugin")), com.obric.memorydata.utils.j.a());
    }

    @Override // com.obric.memorydata.awareness.api.a
    public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
        com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
    }

    public final void c() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "har enabled", false, 4, null);
        this.h.b();
        i();
        o();
        AwarenessManager.INSTANCE.registerAwarenessEvent("har_activity_state", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
    }

    public final void d() {
        if (this.e.get() == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "har disabled", false, 4, null);
        n();
        q();
        this.h.c();
        AwarenessManager.INSTANCE.unregisterAwarenessEvent("har_activity_state", (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));
        com.obric.cae.libs.useraware.f r0 = com.obric.memorydata.awareness.cae.a.f8559a.a().a();     // Catch: RemoteException -> L10
        if (r0 == null) goto L15;
        r0.b((com.obric.cae.libs.bluetooth.a) ZeusTransformUtils.preCheckCast(this.k, com.obric.cae.libs.bluetooth.a.class, "com.obric.memorydata.plugin"));     // Catch: RemoteException -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        RunLog.INSTANCE.error("HarPredict", "registerSmartBluetoothEvent failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void e() {
        RunLog.INSTANCE.debug("HarPredict", "testTriggerCollectData");
        a(CollectionsKt.listOf(new HarEvent(5, System.currentTimeMillis())), null, false);
    }

    public final void f() {
        if (this.g == true) goto L6;
        RunLog.INSTANCE.debug("HarPredict", "har disabled, skip notifyCellChanged");
        return;
    L6:
        h().removeMessages(1001);
        if (Math.abs(System.currentTimeMillis() - r) >= 60000) goto L10;
        Message r0 = Message.obtain();
        r0.what = 1001;
        h().sendMessageDelayed(r0, 60000);
        return;
    L10:
        h().sendEmptyMessage(1001);
    }

    @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
    public void onSettingsChanged(String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HarPredict", "onSettingsChanged " + r8, false, 4, null);
        if (Intrinsics.areEqual(r8, SettingsManager.KEY_SENSORHUB_THRESHOLD_SETTINGS) == false) goto L6;
        i();
        return;
    L6:
        if (Intrinsics.areEqual(r8, SettingsManager.KEY_AB_SWITCH_SETTINGS) == false) goto L10;
        j();
        k();
        return;
    }
}
