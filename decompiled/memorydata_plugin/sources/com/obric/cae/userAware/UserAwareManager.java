package com.obric.cae.userAware;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.cae.libs.useraware.BtAwareInfo;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.HarLevel2DataReq;
import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.libs.useraware.SensorEventInfo;
import com.obric.cae.libs.useraware.UnifiedDataPacket;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.libs.useraware.a;
import com.obric.cae.libs.useraware.b;
import com.obric.cae.libs.useraware.d;
import com.obric.cae.libs.utils.h;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.mediaaware.AudioAwareInfoManger;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class UserAwareManager {
    private static final int BUFFER_CAPACITY = 0;
    private static final String HAR_LEVEL2_DATA_SHM = "HarLevel2DataShm";
    private static final int HIGH_POWER_MASK = 27;
    private static final int SHM_BUFFER_SIZE_THRESHOLD = 0;
    private static final String TAG = "UserAwareManager";
    private static final int TIMEOUT_SHM_BUFFER_SEND_MS = 500;
    private static UserAwareManager sInstance;
    private final AtomicBoolean isCaeActiveRecording;
    private final AtomicBoolean isHarRecordLocal;
    private final AtomicBoolean isThirdPartyRom;
    private AudioAwareInfoManger mAudioAwareInfoManager;
    private BtAwareInfoManager mBtAwareInfoManager;
    private CellAwareInfoManger mCellAwareInfoManager;
    private int mCurrentShmBufferIndex;
    private int mCurrentShmBufferOffset;
    private final ExecutorService mHarDataExecutor;
    private Thread mHarDataThread;
    private int mHarLevel2BtDataCount;
    private int mHarLevel2CellDataCount;
    private SharedMemory mHarLevel2DaraShm;
    private final List<a> mHarLevel2DataRespList;
    private int mHarLevel2GnssDataCount;
    private int mHarLevel2LocationDataCount;
    private final Map<Integer, Integer> mHarLevel2SensorDataCountMap;
    private int mHarLevel2WifiDataCount;
    private ByteBuffer mHarShmMappedBuffer;
    private final ConcurrentMap<Integer, ScheduledExecutorService> mHarTaskMap;
    private final List<InnerAwareInfoCallback> mInnerAwareInfoCallbacks;
    private final AtomicBoolean mIsHarLevel2DataRecording;
    private final AtomicBoolean mIsRecording;
    private final AtomicBoolean mIsRecordingByCallback;
    private String mLastDesc;
    private long mLastHarCollectEndTime;
    private long mLastHarCollectStartTime;
    private int mLastHarCollectTimeout;
    private long mLastNotifyTime;
    private LocationAwareInfoManager mLocationAwareInfoManager;
    private String mNearbyLogPath;
    private OemHarInfoManager mOemHarInfoManager;
    private Thread mRecordThread;
    private final AtomicInteger mRecordingAwakeCount;
    private int mRecordingMask;
    private SensorCollectManager mSensorCollectManager;
    private final Object mShmBufferLock;
    private final RemoteCallbackList<d> mUserAwareCallbacks;
    private PowerManager.WakeLock mWakeLock;
    private WifiAwareInfoManager mWifiAwareInfoManager;

    @FunctionalInterface
    public interface CallbackAction<T> {
        void execute(d r1, T r2);
    }

    public interface InnerCallbackAction<T> {
        void execute(InnerAwareInfoCallback r1, T r2);
    }

    public interface InnerCallbackAction2<T1, T2> {
        void execute(InnerAwareInfoCallback r1, T1 r2, T2 r3);
    }

    public interface InnerCallbackActionNoArg {
        void execute(InnerAwareInfoCallback r1);
    }

    public interface InnerCallbackActionSubway {
        void execute(InnerAwareInfoCallback r1, boolean r2, float r3, String r4, long r5, int r7, int r8, float r9, float r10, int r11, boolean r12, String r13);
    }

    static {
        int r0 = b.a();
        SHM_BUFFER_SIZE_THRESHOLD = r0;
        BUFFER_CAPACITY = r0 * 2;
    }

    private UserAwareManager() {
        this.mIsRecording = new AtomicBoolean(false);
        this.mRecordingAwakeCount = new AtomicInteger(0);
        this.mIsRecordingByCallback = new AtomicBoolean(false);
        this.mIsHarLevel2DataRecording = new AtomicBoolean(false);
        this.mUserAwareCallbacks = new RemoteCallbackList();
        this.mHarLevel2DataRespList = new CopyOnWriteArrayList();
        this.mHarDataExecutor = Executors.newCachedThreadPool();
        this.mHarTaskMap = new ConcurrentHashMap();
        this.isHarRecordLocal = new AtomicBoolean(false);
        this.isCaeActiveRecording = new AtomicBoolean(false);
        this.isThirdPartyRom = new AtomicBoolean(false);
        this.mInnerAwareInfoCallbacks = new ArrayList();
        this.mRecordingMask = 0;
        this.mHarLevel2DaraShm = null;
        this.mHarShmMappedBuffer = null;
        this.mCurrentShmBufferIndex = 0;
        this.mCurrentShmBufferOffset = 0;
        this.mLastNotifyTime = 0;
        this.mLastHarCollectStartTime = 0;
        this.mLastHarCollectEndTime = 0;
        this.mLastHarCollectTimeout = 0;
        this.mHarLevel2WifiDataCount = 0;
        this.mHarLevel2BtDataCount = 0;
        this.mHarLevel2CellDataCount = 0;
        this.mHarLevel2LocationDataCount = 0;
        this.mHarLevel2GnssDataCount = 0;
        this.mHarLevel2SensorDataCountMap = new HashMap();
        this.mShmBufferLock = new Object();
        this.mLastDesc = "";
        this.mNearbyLogPath = "";
    }

    private void createNearbyInfoFile(Context r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        String r14 = SceneCollectionSessionContext.sanitizeCollectionDesc(r13, r12);
        this.mLastDesc = r14;
        long r0 = System.currentTimeMillis();
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(r0);
        SceneCollectionSessionContext r1 = SceneCollectionSessionContext.getInstance();
        SceneCollectionSessionContext.Snapshot r3 = r1.snapshot();
        boolean r4 = r3.hasPathInfo();
        File r15 = UserAwareUtil.getNearbyLogPathFile(r13);
        if (r4 == false) goto L14;
        SceneCollectionPathBuilder.PathLayout r16 = r3.buildLayout(r15, r2.getTimeInMillis());
        if (r16 != null) goto L7;
        return;
    L7:
        File r17 = r16.sessionDir;
        if (r17.exists() == false) goto L10;
    L13:
        r14 = r3.getDescriptionFileStem();
        r1.updateLastDescriptionFileStem(r14);
    L20:
        this.mNearbyLogPath = r17.getAbsolutePath();
        if (new File(r17, r14 + ".txt").createNewFile() == true) goto L24;
        return;
    L24:
        String r18 = String.format(Locale.CHINA, "%tH.%tM.%tS", new Object[]{r2, r2, r2});
        this.mLocationAwareInfoManager.recordLocationFile(h.a("nearby_location", r18), new File(r17, "location.log"));
        this.mBtAwareInfoManager.recordBtFile(h.a("nearby_bt", r18), new File(r17, "bt_scan.log"));
        this.mWifiAwareInfoManager.recordWifiFile(h.a("nearby_wifi", r18), new File(r17, "wifi_scan.log"));
        this.mAudioAwareInfoManager.recordAudioFile("nearby_audio" + r18, r17);
        this.mSensorCollectManager.recordSensorFile(h.a("sensor_collect", r18), new File(r17, "sensor_collect.log"));
        return;
    L26:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "createNearbyInfoFile: IOException -- ", e);
        return;
    L10:
        if (r17.mkdirs() == true) goto L13;
        com.obric.cae.log.a.g(TAG, "createNearbyInfoFile: failed to create scene collection dir");
        return;
    L14:
        File r5 = new File(r15, String.format(Locale.CHINA, h.a("%ty%tm%td_%tH%tM%tS_", r14), new Object[]{r2, r2, r2, r2, r2, r2}));
        if (r5.exists() == false) goto L17;
    L19:
        r17 = r5;
        goto L20
    L17:
        if (r5.mkdirs() == true) goto L19;
    }

    private void finalizeRecordStop(boolean r2) {
        copyEventLogsToNearbyLogFile(true);
        if (r2 == false) goto L5;
        notifyInnerCallbacks($$Lambda$9yiqOkDQHNBBpPiKRHuZhtufJDA.INSTANCE, Boolean.FALSE);
    L5:
        this.mIsRecordingByCallback.set(false);
        if (this.mRecordingAwakeCount.get() <= 0) goto L9;
        releaseWakeLock();
        this.mRecordingAwakeCount.decrementAndGet();
    L9:
        if (this.mIsRecording.get() == true) goto L12;
        SceneCollectionSessionContext.getInstance().clear();
        return;
    }

    private String formatHarLevel2SensorDataCountLocked() {
        if (this.mHarLevel2SensorDataCountMap.isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringJoiner r0 = new StringJoiner(", ", "{", "}");
        Iterator r1 = new TreeMap(this.mHarLevel2SensorDataCountMap).entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r0.add(getSensorTypeName(r3) + "(type=" + r3 + ")=" + r2.getValue());
        goto L8
    L11:
        return r0.toString();
    }

    public static synchronized UserAwareManager getInstance() {
        monitor-enter(UserAwareManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new UserAwareManager();     // Catch: Throwable -> L10
    L7:
        UserAwareManager r1 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(UserAwareManager.class);
        return r1;
    }

    private String getSensorTypeName(int r2) {
        if (r2 != 8) goto L5;
        return "proximity";
    L5:
        if (r2 != 19) goto L7;
        return "step_counter";
    L7:
        if (r2 != 10) goto L9;
        return "linear_acceleration";
    L9:
        if (r2 == 11) goto L25;
        switch(r2) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            default: goto L12;
        };
    L13:
        return "pressure";
    L15:
        return "light";
    L17:
        return "gyroscope";
    L19:
        return "orientation";
    L21:
        return "magnetic_field";
    L23:
        return "accelerometer";
    L12:
        return "sensorType_" + r2;
    L25:
        return "rotation_vector";
    }

    private void interruptRecordThread() {
        Thread r0 = this.mRecordThread;
        if (r0 == null) goto L6;
        r0.interrupt();
        this.mRecordThread = null;
        return;
    }

    static /* synthetic */ Integer lambda$updateHarLevel2DataCountLocked$12(Integer r0, Integer r1) {
        int r2 = 1;
        if (r1 == null) goto L7;
        r2 = 1 + r1.intValue();
    L7:
        return Integer.valueOf(r2);
    }

    static /* synthetic */ void lambda$zppCollectLocation$2(Location[] r3, CountDownLatch r4, Location r5) {
        com.obric.cae.log.a.c(TAG, "zppCollectLocation: " + r5);
        if (r5 == r3[0]) goto L6;
        r3[0] = r5;
        r4.countDown();
        return;
    }

    private void logHarLevel2DataCount() {
        Object r1 = this.mShmBufferLock;
        monitor-enter(r1);
        com.obric.cae.log.a.c(TAG, com.obric.cae.location.util.d.c(), "stopHarLevel2DataCollection: dataCount, wifi=" + this.mHarLevel2WifiDataCount + ", bt=" + this.mHarLevel2BtDataCount + ", cell=" + this.mHarLevel2CellDataCount + ", location=" + this.mHarLevel2LocationDataCount + ", gnss=" + this.mHarLevel2GnssDataCount + ", sensor=" + formatHarLevel2SensorDataCountLocked(), com.obric.cae.location.util.d.b());     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyAndSwitchBuffer() {
        Object r0 = this.mShmBufferLock;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.isHarRecordLocal.get() == false) goto L7;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L7:
        if (this.mCurrentShmBufferOffset == 0) goto L20;
        Iterator<a> r1 = this.mHarLevel2DataRespList.iterator();     // Catch: Throwable -> L22
    L11:
        if (r1.hasNext() == false) goto L17;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r2.a(this.mCurrentShmBufferIndex, this.mCurrentShmBufferOffset);     // Catch: RemoteException -> L15 Throwable -> L22
    L15:
        e = move-exception;
        this.mHarLevel2DataRespList.remove(r2);     // Catch: Throwable -> L22
        com.obric.cae.log.a.a(TAG, "Error notifying client", e);     // Catch: Throwable -> L22
        goto L11
    L17:
        this.mCurrentShmBufferIndex = (this.mCurrentShmBufferIndex + 1) % 2;     // Catch: Throwable -> L22
        this.mCurrentShmBufferOffset = 0;     // Catch: Throwable -> L22
        this.mLastNotifyTime = System.currentTimeMillis();     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
    }

    private void postHarLevel2DataInternal(Parcelable r7) {
        Parcelable r8 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r7, Parcelable.class, "com.obric.memorydata.plugin");
        Object r1 = this.mShmBufferLock;
        monitor-enter(r1);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsHarLevel2DataRecording.get() == true) goto L7;
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L7:
        if (this.isHarRecordLocal.get() == true) goto L26;
        if (this.mHarShmMappedBuffer == null) goto L26;
        byte[] r2 = serializePacket(new UnifiedDataPacket(r8));     // Catch: Throwable -> L28
        updateHarLevel2DataCountLocked(r8);     // Catch: Throwable -> L28
        int r9 = r2.length + 4;     // Catch: Throwable -> L28
        int r3 = BUFFER_CAPACITY;     // Catch: Throwable -> L28
        if (r9 <= r3) goto L16;
        com.obric.cae.log.a.i(TAG, "postHarLevel2DataInternal, Dropping oversized packet. Size: " + r2.length + " is larger than buffer capacity " + r3);     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L16:
        int r10 = (this.mCurrentShmBufferOffset + 4) + r2.length;     // Catch: Throwable -> L28
        int r0 = SHM_BUFFER_SIZE_THRESHOLD;     // Catch: Throwable -> L28
        if (r10 <= r0) goto L19;
        notifyAndSwitchBuffer();     // Catch: Throwable -> L28
    L19:
        this.mHarShmMappedBuffer.position((this.mCurrentShmBufferIndex * r0) + this.mCurrentShmBufferOffset);     // Catch: Throwable -> L28
        this.mHarShmMappedBuffer.putInt(r2.length);     // Catch: Throwable -> L28
        this.mHarShmMappedBuffer.put(r2);     // Catch: Throwable -> L28
        int r4 = (r2.length + 4) + this.mCurrentShmBufferOffset;     // Catch: Throwable -> L28
        this.mCurrentShmBufferOffset = r4;     // Catch: Throwable -> L28
        if (r4 <= r0) goto L22;
    L23:
        notifyAndSwitchBuffer();     // Catch: Throwable -> L28
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L22:
        if ((System.currentTimeMillis() - this.mLastNotifyTime) < 500) goto L24;
        goto L23
    }

    private void processHarLevel2DataReq(List<HarLevel2DataReq> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L41;
        HarLevel2DataReq r0 = (HarLevel2DataReq) ZeusTransformUtils.preCheckCast(r7.next(), HarLevel2DataReq.class, "com.obric.memorydata.plugin");
        String r2 = TAG;
        com.obric.cae.log.a.e(r2, "processHarLevel2DataReq: " + r0.getRequestType() + ", count: " + r0.getCount() + ", interval: " + r0.getInterval() + ", timeout: " + r0.getTimeout());
        if (this.mIsHarLevel2DataRecording.get() == false) goto L65;
        if (r0.getCount() <= 0) goto L66;
        if (r0.getInterval() == 0) goto L17;
        if (r0.getTimeout() == 0) goto L17;
        if (r0.getInterval() >= r0.getTimeout()) goto L17;
    L40:
        throw new IllegalArgumentException("interval must be greater than timeout and non-negative");
    L17:
        if (r0.getInterval() < 0) goto L40;
        if (r0.getTimeout() < 0) goto L40;
        int r3 = r0.getRequestType();
        if (r3 != 1) goto L23;
        if (r0.getTimeout() > r0.getInterval()) goto L38;
        this.mHarTaskMap.put(Integer.valueOf(r0.getRequestType()), Executors.newSingleThreadScheduledExecutor());
        scheduleNextWifiRecord(r0.getCount(), r0.getInterval(), r0.getTimeout());
        goto L4
    L38:
        throw new IllegalArgumentException("timeout must be less than interval");
    L23:
        if (r3 != 2) goto L25;
        this.mHarTaskMap.put(Integer.valueOf(r0.getRequestType()), Executors.newSingleThreadScheduledExecutor());
        scheduleNextBtRecord(r0.getCount(), r0.getInterval(), r0.getTimeout());
        goto L4
    L25:
        if (r3 == 3) goto L4;
        if (r3 != 4) goto L29;
        this.mHarTaskMap.put(Integer.valueOf(r0.getRequestType()), Executors.newSingleThreadScheduledExecutor());
        scheduleNextLocationRecord(r0.getCount(), r0.getInterval(), r0.getTimeout());
        goto L4
    L29:
        if (r3 != 5) goto L30;
        this.mSensorCollectManager.startSensorCollect(4064);
        goto L4
    L30:
        com.obric.cae.log.a.i(r2, "processHarLevel2DataReq: unknown request type");
        goto L4
    L66:
        return;
    L65:
        return;
    }

    private void processRecordingTask(int r3) {
        if ((r3 & 1) != 1) goto L6;
        this.mWifiAwareInfoManager.startWifiRecord(true);
    L6:
        if ((r3 & 2) != 2) goto L9;
        this.mBtAwareInfoManager.startBleScan(5);
    L9:
        if ((r3 & 8) != 8) goto L12;
        this.mLocationAwareInfoManager.startLocationScan(false);
    L12:
        if ((r3 & 16) != 16) goto L14;
        this.mAudioAwareInfoManager.startRecordingExternal();
    L14:
        this.mSensorCollectManager.startSensorCollect(r3);
    }

    private void resetHarLevel2DataCountLocked() {
        this.mHarLevel2WifiDataCount = 0;
        this.mHarLevel2BtDataCount = 0;
        this.mHarLevel2CellDataCount = 0;
        this.mHarLevel2LocationDataCount = 0;
        this.mHarLevel2GnssDataCount = 0;
        this.mHarLevel2SensorDataCountMap.clear();
    }

    private void scheduleNextBtRecord(int r6, final int r7, final int r8) {
        this.mBtAwareInfoManager.startBleScan(5);
        ScheduledExecutorService r0 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.mHarTaskMap.get(2), ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 <= 0) goto L7;
        r0.schedule(new $$Lambda$UserAwareManager$E8mRRzEjrB4_fpRL0aTXCJxz8nA(this), r8, TimeUnit.MILLISECONDS);
    L7:
        final int r9 = r6 - 1;
        if (r9 <= 0) goto L12;
        if (r7 <= 0) goto L13;
        r0.schedule(new $$Lambda$UserAwareManager$dOe14wGojIHJhvYWlSosEK9jVA(this, r9, r7, r8), r7, TimeUnit.MILLISECONDS);
        return;
    L13:
        return;
    }

    private void scheduleNextLocationRecord(int r6, final int r7, final int r8) {
        this.mLocationAwareInfoManager.startLocationScan(false);
        ScheduledExecutorService r0 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.mHarTaskMap.get(4), ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 <= 0) goto L7;
        r0.schedule(new $$Lambda$UserAwareManager$Q1jEBEOHpBH2w5pw7NJdISQ1nXs(this), r8, TimeUnit.MILLISECONDS);
    L7:
        final int r9 = r6 - 1;
        if (r9 <= 0) goto L12;
        if (r7 <= 0) goto L13;
        r0.schedule(new $$Lambda$UserAwareManager$Bi9CLRtp1sDYeb9Q1YTyDnwcajw(this, r9, r7, r8), r7, TimeUnit.MILLISECONDS);
        return;
    L13:
        return;
    }

    private void scheduleNextWifiRecord(int r5, final int r6, final int r7) {
        if (isRecording() == true) goto L5;
    L6:
        this.mWifiAwareInfoManager.startHarLevel2WifiDataCollection(101, r7 - 100, r7);
    L7:
        ScheduledExecutorService r0 = (ScheduledExecutorService) ZeusTransformUtils.preCheckCast(this.mHarTaskMap.get(1), ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        return;
    L10:
        final int r8 = r5 - 1;
        if (r8 <= 0) goto L15;
        if (r6 <= 0) goto L16;
        r0.schedule(new $$Lambda$UserAwareManager$2penf2qUf9FZPq3OjP9IJiYihiE(this, r8, r6, r7), r6, TimeUnit.MILLISECONDS);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if ((this.mRecordingMask & 1) == 0) goto L7;
        goto L6
    }

    private byte[] serializePacket(Parcelable r2) {
        Parcelable r1 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r2, Parcelable.class, "com.obric.memorydata.plugin");
        Parcel r3 = Parcel.obtain();
        r1.writeToParcel(r3, 0);
        byte[] r4 = r3.marshall();
        r3.recycle();
        return r4;
    }

    private void startHarLevel2DataCollection(Context r10, List<HarLevel2DataReq> r11, final int r12, a r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        List<HarLevel2DataReq> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        final a r16 = (a) ZeusTransformUtils.wrapperContextForParams(r13, a.class, "com.obric.memorydata.plugin");
        Object r2 = this.mShmBufferLock;
        monitor-enter(r2);
        String r3 = TAG;     // Catch: Throwable -> L40
        com.obric.cae.log.a.e(r3, "startHarLevel2DataCollection: isLocalCollect: " + this.isHarRecordLocal.get());     // Catch: Throwable -> L40
        if (this.isHarRecordLocal.get() == false) goto L7;
        createNearbyInfoFile(r14, r14.getString(ZeusTransformUtils.mapRes(R.string.user_aware_har_req_collection_local, TypedValues.Custom.S_STRING, "user_aware_har_req_collection_local")));     // Catch: Throwable -> L40
        com.obric.cae.log.a.e(r3, "onCollectStats: true, null");     // Catch: RemoteException -> L28 Throwable -> L40
        r16.a(true, null);     // Catch: RemoteException -> L28 Throwable -> L40
    L30:
        monitor-exit(r2);     // Catch: Throwable -> L40
        acquireWakeLock(r14, r12 + 100);
        Thread r17 = new Thread(new $$Lambda$UserAwareManager$C1tZiK7j36_sHmkY94f0e5o6q60(this, r12, r16), "HarLevel2DataThread");
        this.mHarDataThread = r17;
        r17.start();
        Object r18 = this.mShmBufferLock;
        monitor-enter(r18);
        this.mLastNotifyTime = System.currentTimeMillis();     // Catch: Throwable -> L37
        monitor-exit(r18);     // Catch: Throwable -> L37
        processHarLevel2DataReq(r15);
        return;
    L37:
        th = move-exception;
        throw th;
    L28:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "startHarLevel2DataCollection: RemoteException1 -- ", e);     // Catch: Throwable -> L40
        goto L30
    L7:
        if (this.mHarLevel2DataRespList.isEmpty() == true) goto L52;
    L18:
        this.mHarLevel2DataRespList.add(r16);     // Catch: Throwable -> L40
        ParcelFileDescriptor r1 = this.mHarLevel2DaraShm.getFdDup();     // Catch: Throwable -> L21 Throwable -> L40
        com.obric.cae.log.a.e(r3, "onCollectStats: true, parcelFileDescriptor: " + r1);     // Catch: Throwable -> L21 Throwable -> L40
        r16.a(true, r1);     // Catch: Throwable -> L21 Throwable -> L40
    L21:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "startHarLevel2DataCollection: Exception2 -- ", e);     // Catch: Throwable -> L40
        return;
    L52:
        com.obric.cae.log.a.e(r3, "Create SharedMemory");     // Catch: ErrnoException -> L10 Throwable -> L40
        int r6 = BUFFER_CAPACITY;     // Catch: ErrnoException -> L10 Throwable -> L40
        SharedMemory r4 = SharedMemory.create(HAR_LEVEL2_DATA_SHM, r6);     // Catch: ErrnoException -> L10 Throwable -> L40
        this.mHarLevel2DaraShm = r4;     // Catch: ErrnoException -> L10 Throwable -> L40
        this.mHarShmMappedBuffer = r4.map(OsConstants.PROT_READ | OsConstants.PROT_WRITE, 0, r6);     // Catch: ErrnoException -> L10 Throwable -> L40
    L10:
        e = move-exception;
        String r19 = TAG;     // Catch: Throwable -> L40
        com.obric.cae.log.a.a(r19, "startHarLevel2DataCollection: ErrnoException|IOException -- ", e);     // Catch: Throwable -> L40
        com.obric.cae.log.a.e(r19, "onCollectStats: true, null");     // Catch: RemoteException -> L14 Throwable -> L40
        r16.a(true, null);     // Catch: RemoteException -> L14 Throwable -> L40
    L17:
        return;
    L14:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "startHarLevel2DataCollection: RemoteException1 -- ", e);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }

    private void startRecordTimeoutThread(final int r3) {
        interruptRecordThread();
        if (r3 > 0) goto L5;
        return;
    L5:
        Thread r0 = new Thread(new $$Lambda$UserAwareManager$vUJgjox0shfu8tMW_1dcCQT10xo(this, r3), "RecordNearbyThread");
        this.mRecordThread = r0;
        r0.start();
    }

    private void stopHarLevel2DataCollection(a r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        Thread r0 = this.mHarDataThread;
        if (r0 == null) goto L36;
        r0.interrupt();
        this.mHarDataThread = null;
    L36:
        com.obric.cae.log.a.e(TAG, "onCollectStats: false, null");     // Catch: RemoteException -> L8
        r6.a(false, null);     // Catch: RemoteException -> L8
    L9:
        String r2 = TAG;
        com.obric.cae.log.a.e(r2, "stopHarLevel2DataCollection");
        logHarLevel2DataCount();
        this.mHarLevel2DataRespList.remove(r6);
        Object r7 = this.mShmBufferLock;
        monitor-enter(r7);
    L33:
        th = move-exception;
        throw th;
    L12:
        if (this.mHarLevel2DataRespList.isEmpty() == true) goto L14;
    L26:
        this.mLastHarCollectEndTime = System.currentTimeMillis();     // Catch: Throwable -> L33
        monitor-exit(r7);     // Catch: Throwable -> L33
        if (this.mIsRecording.get() == false) goto L31;
        new Thread(new $$Lambda$UserAwareManager$H8m7_Tg43teqH7wi4w0peeBEmw(this), "restartRecording").start();
    L31:
        releaseWakeLock();
        return;
    L14:
        if (this.isHarRecordLocal.get() == true) goto L19;
        com.obric.cae.log.a.e(r2, "No HarLevel2DataResp registered, cleanup Shm.");     // Catch: Throwable -> L33
        SharedMemory.unmap(this.mHarShmMappedBuffer);     // Catch: Throwable -> L33
        this.mHarShmMappedBuffer = null;     // Catch: Throwable -> L33
        SharedMemory r3 = this.mHarLevel2DaraShm;     // Catch: Throwable -> L33
        if (r3 == null) goto L18;
        r3.close();     // Catch: Throwable -> L33
        this.mHarLevel2DaraShm = null;     // Catch: Throwable -> L33
    L18:
        this.mCurrentShmBufferIndex = 0;     // Catch: Throwable -> L33
        this.mCurrentShmBufferOffset = 0;     // Catch: Throwable -> L33
        this.mLastNotifyTime = 0;     // Catch: Throwable -> L33
    L19:
        this.mWifiAwareInfoManager.startWifiRecord(false);     // Catch: Throwable -> L33
        this.mBtAwareInfoManager.stopBleScan();     // Catch: Throwable -> L33
        this.mLocationAwareInfoManager.stopLocationScan();     // Catch: Throwable -> L33
        this.mSensorCollectManager.stopSensorCollect();     // Catch: Throwable -> L33
        Iterator<Map.Entry<Integer, ScheduledExecutorService>> r1 = this.mHarTaskMap.entrySet().iterator();     // Catch: Throwable -> L33
    L21:
        if (r1.hasNext() == false) goto L23;
        ((ScheduledExecutorService) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), ScheduledExecutorService.class, "com.obric.memorydata.plugin")).shutdownNow();     // Catch: Throwable -> L33
        goto L21
    L23:
        this.mHarTaskMap.clear();     // Catch: Throwable -> L33
        if (this.isHarRecordLocal.get() == false) goto L26;
        com.obric.cae.log.a.c(TAG, "Har record local, copy event logs");     // Catch: Throwable -> L33
        copyEventLogsToNearbyLogFile(true);     // Catch: Throwable -> L33
    L8:
        com.obric.cae.log.a.e(TAG, "Callback Server died, no need to notify");
        goto L9
    }

    private void stopRecordingSources() {
        this.mWifiAwareInfoManager.startWifiRecord(false);
        this.mBtAwareInfoManager.stopBleScan();
        this.mLocationAwareInfoManager.stopLocationScan();
        this.mAudioAwareInfoManager.stopRecordingExternal();
        this.mSensorCollectManager.stopSensorCollect();
        OemHarInfoManager r2 = this.mOemHarInfoManager;
        if (r2 == null) goto L6;
        r2.stopRecordHarStatus();
        return;
    }

    private void updateHarLevel2DataCountLocked(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, WifiStandardData.class) == false) goto L9;
        this.mHarLevel2WifiDataCount++;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, BtAwareInfo.class) == false) goto L12;
        this.mHarLevel2BtDataCount++;
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, CellAwareInfo.class) == false) goto L15;
        this.mHarLevel2CellDataCount++;
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, LocationAwareInfo.class) == false) goto L18;
        this.mHarLevel2LocationDataCount++;
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r4, GnssSvAwareInfo.class) == false) goto L21;
        this.mHarLevel2GnssDataCount++;
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(r4, SensorEventInfo.class) == false) goto L23;
        this.mHarLevel2SensorDataCountMap.compute(Integer.valueOf(((SensorEventInfo) ZeusTransformUtils.preCheckCast(r4, SensorEventInfo.class, "com.obric.memorydata.plugin")).getSensorType()), $$Lambda$UserAwareManager$vOjWB1Y4hTkoJeA7E4Prqk_Yk_M.INSTANCE);
        return;
    L23:
        com.obric.cae.log.a.g(TAG, "updateHarLevel2DataCountLocked: unknown data type ".concat(r4.getClass().getSimpleName()));
    }

    public synchronized void acquireWakeLock(Context r3, int r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (this.mWakeLock != null) goto L11;
        PowerManager r6 = (PowerManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r6 != null) goto L10;
        com.obric.cae.log.a.i(TAG, "acquireWakeLock, powerManager is null");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        this.mWakeLock = r6.newWakeLock(1, TAG);     // Catch: Throwable -> L14
    L11:
        this.mWakeLock.acquire(r4);     // Catch: Throwable -> L14
        com.obric.cae.log.a.e(TAG, "acquireWakeLock, totalTimeout: " + r4);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void cancelRecord(boolean r3) {
        com.obric.cae.log.a.e(TAG, "cancelRecord");
        interruptRecordThread();
        stopRecordingSources();
        finalizeRecordStop(r3);
    }

    public void clearInnerCallbacks() {
        List<InnerAwareInfoCallback> r0 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r0);
        this.mInnerAwareInfoCallbacks.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void copyEventLogsToNearbyLogFile(boolean r9) {
        File r0 = new File(this.mNearbyLogPath);
        if (r9 == false) goto L7;
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("smart_bt"), r0);
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("geofence"), r0);
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("cell_events"), r0);
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("sensor_events"), r0);
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("har_state"), r0);
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("user_aware"), r0);
    L5:
        UserAwareUtil.copyFile(com.obric.cae.log.a.a("poi", 0), r0);
        return;
    L7:
        if (UserAwareUtil.isFileExist(r0, com.obric.cae.log.a.b("smart_bt")) == true) goto L10;
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("smart_bt"), r0);
    L10:
        if (UserAwareUtil.isFileExist(r0, com.obric.cae.log.a.b("geofence")) == true) goto L13;
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("geofence"), r0);
    L13:
        if (UserAwareUtil.isFileExist(r0, com.obric.cae.log.a.b("cell_events")) == true) goto L16;
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("cell_events"), r0);
    L16:
        if (UserAwareUtil.isFileExist(r0, com.obric.cae.log.a.b("sensor_events")) == true) goto L19;
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("sensor_events"), r0);
    L19:
        if (UserAwareUtil.isFileExist(r0, com.obric.cae.log.a.b("har_state")) == true) goto L22;
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("har_state"), r0);
    L22:
        if (UserAwareUtil.isFileExist(r0, com.obric.cae.log.a.b("user_aware")) == true) goto L25;
        UserAwareUtil.copyFile(com.obric.cae.log.a.b("user_aware"), r0);
    L25:
        if (UserAwareUtil.isFileExist(r0, com.obric.cae.log.a.a("poi", 0)) == false) goto L5;
    }

    public void createNearbyInfoFile(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.e(TAG, "createNearbyInfoFile not desc, use last desc");
        String r0 = this.mLastDesc;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L9;
        createNearbyInfoFile(r4, this.mLastDesc);
        return;
    }

    public void finishNearbyInfoAfterPendingStop(boolean r3) {
        com.obric.cae.log.a.e(TAG, "finishNearbyInfoAfterPendingStop");
        interruptRecordThread();
        this.mIsRecording.set(false);
        finalizeRecordStop(r3);
    }

    public AudioAwareInfoManger getAudioAwareInfoManager() {
        return this.mAudioAwareInfoManager;
    }

    public BtAwareInfoManager getBtAwareInfoManager() {
        return this.mBtAwareInfoManager;
    }

    public CellAwareInfoManger getCellAwareInfoManager() {
        return this.mCellAwareInfoManager;
    }

    public LocationAwareInfoManager getLocationAwareInfoManager() {
        return this.mLocationAwareInfoManager;
    }

    public OemHarInfoManager getOemHarInfoManager() {
        return this.mOemHarInfoManager;
    }

    public SensorCollectManager getSensorCollectManager() {
        return this.mSensorCollectManager;
    }

    public String getSessionDir() {
        return this.mNearbyLogPath;
    }

    public WifiAwareInfoManager getWifiAwareInfoManager() {
        return this.mWifiAwareInfoManager;
    }

    public void initManager(WifiAwareInfoManager r3, BtAwareInfoManager r4, LocationAwareInfoManager r5, CellAwareInfoManger r6, AudioAwareInfoManger r7, SensorCollectManager r8, OemHarInfoManager r9) {
        com.obric.cae.log.a.c(TAG, "initManager");
        this.mWifiAwareInfoManager = r3;
        this.mBtAwareInfoManager = r4;
        this.mLocationAwareInfoManager = r5;
        this.mCellAwareInfoManager = r6;
        this.mAudioAwareInfoManager = r7;
        this.mSensorCollectManager = r8;
        this.mOemHarInfoManager = r9;
    }

    public boolean isActiveRecording() {
        if (this.mIsRecording.get() == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.mRecordingMask & 27) == 0) goto L7;
        return true;
    }

    public boolean isHarLevel2DataRecording() {
        return this.mIsHarLevel2DataRecording.get();
    }

    public boolean isMemDHarEnabled() {
        return ((UserAwareService) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(UserAwareService.getService(), "com.obric.memorydata.plugin"), UserAwareService.class, "com.obric.memorydata.plugin")).mIsMemDHarEnabled.get();
    }

    public boolean isRecording() {
        return this.mIsRecording.get();
    }

    public boolean isRecordingByCallback() {
        return this.mIsRecordingByCallback.get();
    }

    public boolean isWifiRecordingMask() {
        if ((this.mRecordingMask & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public /* synthetic */ void lambda$postHarLevel2Data$11$UserAwareManager(Parcelable r3) {
        postHarLevel2DataInternal((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ void lambda$scheduleNextBtRecord$6$UserAwareManager() {
        this.mBtAwareInfoManager.stopBleScan();
    }

    public /* synthetic */ void lambda$scheduleNextBtRecord$7$UserAwareManager(int r1, int r2, int r3) {
        scheduleNextBtRecord(r1, r2, r3);
    }

    public /* synthetic */ void lambda$scheduleNextLocationRecord$8$UserAwareManager() {
        this.mLocationAwareInfoManager.stopLocationScan();
    }

    public /* synthetic */ void lambda$scheduleNextLocationRecord$9$UserAwareManager(int r1, int r2, int r3) {
        scheduleNextLocationRecord(r1, r2, r3);
    }

    public /* synthetic */ void lambda$scheduleNextWifiRecord$5$UserAwareManager(int r1, int r2, int r3) {
        scheduleNextWifiRecord(r1, r2, r3);
    }

    public /* synthetic */ void lambda$startHarLevel2DataCollection$4$UserAwareManager(int r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Thread.sleep(r3);     // Catch: InterruptedException -> L7
        com.obric.cae.log.a.c(TAG, "startHarLevel2DataCollection timeout arrived");     // Catch: InterruptedException -> L7
        if (this.mIsHarLevel2DataRecording.get() == false) goto L11;
        this.mIsHarLevel2DataRecording.set(false);     // Catch: InterruptedException -> L7
        notifyAndSwitchBuffer();     // Catch: InterruptedException -> L7
        stopHarLevel2DataCollection(r5);     // Catch: InterruptedException -> L7
        return;
    L11:
        return;
    L7:
        com.obric.cae.log.a.e(TAG, "startHarLevel2DataCollection: Timer cancelled");
    }

    public /* synthetic */ void lambda$startLocationScan$1$UserAwareManager(int r3) {
        Thread.sleep(r3);     // Catch: InterruptedException -> L5
        this.mLocationAwareInfoManager.stopLocationScan();     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "startSingleLocationScan: InterruptedException -- ", e);
    }

    public /* synthetic */ void lambda$startRecordTimeoutThread$0$UserAwareManager(int r3) {
        Thread.sleep(r3);     // Catch: InterruptedException -> L7
        if (this.mIsRecording.get() == false) goto L11;
        com.obric.cae.log.a.c(TAG, "recordNearbyInfo timeout arrived");     // Catch: InterruptedException -> L7
        this.mIsRecording.set(false);     // Catch: InterruptedException -> L7
        cancelRecord(true);     // Catch: InterruptedException -> L7
        return;
    L11:
        return;
    L7:
        com.obric.cae.log.a.e(TAG, "recordNearbyInfo: Interrupted");
    }

    public /* synthetic */ void lambda$stopHarLevel2DataCollection$10$UserAwareManager() {
        Thread.sleep(500);     // Catch: InterruptedException -> L6
        com.obric.cae.log.a.e(TAG, "stopHarLevel2DataCollection, restart recording, mask:0x" + String.format("%02X", new Object[]{Integer.valueOf(this.mRecordingMask)}));
        processRecordingTask(this.mRecordingMask);
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public /* synthetic */ void lambda$zppCollectLocation$3$UserAwareManager(int r5) {
        final CountDownLatch r0 = new CountDownLatch(r5);
        final Location[] r1 = {null};
        LocationListener r2 = new $$Lambda$UserAwareManager$ankOwSB8yLarQi0M08OdZDjWX1M(r1, r0);
        LocationAwareInfoManager r4 = this.mLocationAwareInfoManager;
        if (r4 == null) goto L5;
        r4.resetLastLocationInfo();
    L5:
        com.obric.cae.location.util.d.a().a("fused", r2);
        r0.await(r5, TimeUnit.SECONDS);     // Catch: InterruptedException -> L8
    L10:
        com.obric.cae.location.util.d.a().a(r2);
        return;
    L8:
        e = move-exception;
        com.obric.cae.log.a.a(TAG, "zppCollectLocation: InterruptedException -- ", e);
        goto L10
    }

    public void notifyActiveRecording(boolean r1) {
        this.isCaeActiveRecording.set(r1);
    }

    public <T> void notifyCallbacks(CallbackAction<T> r8, T r9) {
        CallbackAction r10 = (CallbackAction) ZeusTransformUtils.wrapperContextForParams(r8, CallbackAction.class, "com.obric.memorydata.plugin");
        RemoteCallbackList<d> r0 = this.mUserAwareCallbacks;
        monitor-enter(r0);
        int r1 = this.mUserAwareCallbacks.beginBroadcast();     // Catch: Throwable -> L17
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        d r3 = (d) ZeusTransformUtils.preCheckCast(this.mUserAwareCallbacks.getBroadcastItem(r2), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r3 == null) goto L13;
        if (r9 == null) goto L13;
        r10.execute(r3, r9);     // Catch: Exception -> L11 Throwable -> L17
    L11:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "notifyCallbacks exception" + e);     // Catch: Throwable -> L17
    L13:
        r2 = r2 + 1;     // Catch: Throwable -> L17
        goto L5
    L14:
        this.mUserAwareCallbacks.finishBroadcast();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public <T1, T2> void notifyInnerCallbacks(InnerCallbackAction2<T1, T2> r5, T1 r6, T2 r7) {
        InnerCallbackAction2 r8 = (InnerCallbackAction2) ZeusTransformUtils.wrapperContextForParams(r5, InnerCallbackAction2.class, "com.obric.memorydata.plugin");
        List<InnerAwareInfoCallback> r0 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L8:
        ArrayList r1 = new ArrayList(this.mInnerAwareInfoCallbacks);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L18;
        r8.execute((InnerAwareInfoCallback) ZeusTransformUtils.preCheckCast(r4.next(), InnerAwareInfoCallback.class, "com.obric.memorydata.plugin"), r6, r7);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "notifyInnerCallbacks exception" + e);
        goto L12
    }

    public <T> void notifyInnerCallbacks(InnerCallbackAction<T> r5, T r6) {
        InnerCallbackAction r7 = (InnerCallbackAction) ZeusTransformUtils.wrapperContextForParams(r5, InnerCallbackAction.class, "com.obric.memorydata.plugin");
        List<InnerAwareInfoCallback> r0 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L8:
        ArrayList r1 = new ArrayList(this.mInnerAwareInfoCallbacks);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L18;
        r7.execute((InnerAwareInfoCallback) ZeusTransformUtils.preCheckCast(r4.next(), InnerAwareInfoCallback.class, "com.obric.memorydata.plugin"), r6);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "notifyInnerCallbacks exception" + e);
        goto L12
    }

    public void notifyInnerCallbacks(InnerCallbackActionNoArg r5) {
        InnerCallbackActionNoArg r6 = (InnerCallbackActionNoArg) ZeusTransformUtils.wrapperContextForParams(r5, InnerCallbackActionNoArg.class, "com.obric.memorydata.plugin");
        List<InnerAwareInfoCallback> r0 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L8:
        ArrayList r1 = new ArrayList(this.mInnerAwareInfoCallbacks);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L18;
        r6.execute((InnerAwareInfoCallback) ZeusTransformUtils.preCheckCast(r4.next(), InnerAwareInfoCallback.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "notifyInnerCallbacks exception" + e);
        goto L12
    }

    public void notifySubwayEvaluationEvent(boolean r16, float r17, String r18, long r19, int r21, int r22, float r23, float r24, int r25, boolean r26, String r27) {
        List<InnerAwareInfoCallback> r1 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.isEmpty() == false) goto L8;
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L8:
        ArrayList r2 = new ArrayList(this.mInnerAwareInfoCallbacks);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L18;
        ((InnerAwareInfoCallback) ZeusTransformUtils.preCheckCast(r3.next(), InnerAwareInfoCallback.class, "com.obric.memorydata.plugin")).onSubwayEvaluationEvent(r16, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.obric.cae.log.a.i(TAG, "notifySubwayEvaluationEvent exception" + e);
        goto L12
    }

    public boolean pauseNearbyInfoForPendingStop() {
        if (this.mIsRecording.get() == true) goto L6;
        com.obric.cae.log.a.c(TAG, "pauseNearbyInfoForPendingStop: already paused");
        return false;
    L6:
        com.obric.cae.log.a.e(TAG, "pauseNearbyInfoForPendingStop");
        interruptRecordThread();
        this.mIsRecording.set(false);
        stopRecordingSources();
        return true;
    }

    public void postHarLevel2Data(Parcelable r3) {
        final Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Object r0 = this.mShmBufferLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsHarLevel2DataRecording.get() == true) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.isHarRecordLocal.get() == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L14
        this.mHarDataExecutor.execute(new $$Lambda$UserAwareManager$clYV8vqIKQJB7YQHMiYQXGK0oc(this, r4));
    }

    public boolean recordNearbyInfo(Context r8, boolean r9, String r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        if (r9 != this.mIsRecording.get()) goto L10;
        String r7 = TAG;
        StringBuilder r14 = new StringBuilder("recordNearbyInfo, already in ");
        if (r9 == false) goto L7;
        String r15 = CommonConsts.APM_INNER_EVENT_COST_START;
    L8:
        com.obric.cae.log.a.c(r7, r14.append(r15).append(" state").toString());
        return false;
    L7:
        r15 = "stop";
        goto L8
    L10:
        String r0 = TAG;
        com.obric.cae.log.a.e(r0, "recordNearbyInfo: start: " + r9 + ", timeout: " + r11 + ", mask:0x" + String.format("%02X", new Object[]{Integer.valueOf(r12)}));
        this.mRecordingMask = r12;
        this.mIsRecording.set(r9);
        if (r9 == true) goto L13;
        cancelRecord(true);
    L27:
        return true;
    L13:
        if (this.mIsRecordingByCallback.get() == false) goto L16;
        com.obric.cae.log.a.i(r0, "recordNearbyInfo: already recording by callback, cancel it");
        cancelRecord(false);
    L16:
        if (this.mRecordingMask == 0) goto L19;
        acquireWakeLock(r13, r11 + 100);
        this.mRecordingAwakeCount.incrementAndGet();
    L19:
        if (this.mIsHarLevel2DataRecording.get() == false) goto L25;
        com.obric.cae.log.a.i(r0, "recordNearbyInfo: already recording har level 2 data, stop it");
        Iterator<a> r16 = this.mHarLevel2DataRespList.iterator();
    L22:
        if (r16.hasNext() == false) goto L24;
        stopHarLevel2DataCollection((a) ZeusTransformUtils.preCheckCast(r16.next(), a.class, "com.obric.memorydata.plugin"));
        goto L22
    L24:
        this.mIsHarLevel2DataRecording.set(false);
    L25:
        createNearbyInfoFile(r13, r10);
        notifyInnerCallbacks($$Lambda$9yiqOkDQHNBBpPiKRHuZhtufJDA.INSTANCE, Boolean.TRUE);
        startRecordTimeoutThread(r11);
        processRecordingTask(r12);
        goto L27
    }

    public void recordNearbyInfoByCallback(Context r4, boolean r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != this.mIsRecordingByCallback.get()) goto L11;
        String r3 = TAG;
        StringBuilder r8 = new StringBuilder("recordNearbyInfoByCallback, already in ");
        if (r5 == false) goto L7;
        String r9 = CommonConsts.APM_INNER_EVENT_COST_START;
    L8:
        com.obric.cae.log.a.c(r3, r8.append(r9).append(" state").toString());
        return;
    L7:
        r9 = "stop";
        goto L8
    L11:
        if (this.mIsRecording.get() == false) goto L16;
        if (r5 == false) goto L16;
        com.obric.cae.log.a.i(TAG, "recordNearbyInfoByCallback: already recording");
        return;
    L16:
        if (this.mIsHarLevel2DataRecording.get() == false) goto L20;
        if (r5 == false) goto L20;
        com.obric.cae.log.a.i(TAG, "recordNearbyInfoByCallback: already collecting level 2 data");
        return;
    L20:
        this.mIsRecordingByCallback.set(r5);
        com.obric.cae.log.a.e(TAG, "recordNearbyInfoByCallback: start: " + r5);
        createNearbyInfoFile(r7, r6);
        this.mSensorCollectManager.startSensorCollect(0);
        OemHarInfoManager r10 = this.mOemHarInfoManager;
        if (r10 == null) goto L24;
        r10.startRecordHarStatus();
        return;
    }

    public void registerCallback(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c(TAG, "registerCallback");
        RemoteCallbackList<d> r0 = this.mUserAwareCallbacks;
        monitor-enter(r0);
        this.mUserAwareCallbacks.register(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerInnerCallback(InnerAwareInfoCallback r3) {
        com.obric.cae.log.a.c(TAG, "registerInnerCallback");
        List<InnerAwareInfoCallback> r0 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mInnerAwareInfoCallbacks.contains(r3) == true) goto L7;
        this.mInnerAwareInfoCallbacks.add(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public synchronized void releaseWakeLock() {
        monitor-enter(this);
        PowerManager.WakeLock r0 = this.mWakeLock;     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r0.isHeld() == false) goto L8;
        this.mWakeLock.release();     // Catch: Throwable -> L10
        com.obric.cae.log.a.e(TAG, "releaseWakeLock");     // Catch: Throwable -> L10
        this.mWakeLock = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public boolean resumeNearbyInfoAfterPendingStop(int r4) {
        if (this.mIsRecording.get() == false) goto L6;
        com.obric.cae.log.a.c(TAG, "resumeNearbyInfoAfterPendingStop: already recording");
        return false;
    L6:
        com.obric.cae.log.a.e(TAG, "resumeNearbyInfoAfterPendingStop: timeout=" + r4);
        this.mIsRecording.set(true);
        startRecordTimeoutThread(r4);
        processRecordingTask(this.mRecordingMask);
        return true;
    }

    public void setLevel2DataCollection(Context r9, List<HarLevel2DataReq> r10, int r11, a r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        List<HarLevel2DataReq> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        a r15 = (a) ZeusTransformUtils.wrapperContextForParams(r12, a.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L32;
        if (r14.isEmpty() == true) goto L32;
        Object r1 = this.mShmBufferLock;
        monitor-enter(r1);
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L28
        long r4 = this.mLastHarCollectStartTime;     // Catch: Throwable -> L28
        if (r4 <= this.mLastHarCollectEndTime) goto L15;
        if ((r2 - r4) <= this.mLastHarCollectTimeout) goto L15;
        com.obric.cae.log.a.i(TAG, "workaround, for ap may sleep.");     // Catch: Throwable -> L28
        this.mIsHarLevel2DataRecording.set(false);     // Catch: Throwable -> L28
    L15:
        if (this.mIsHarLevel2DataRecording.get() == false) goto L19;
        com.obric.cae.log.a.i(TAG, "setLevel2DataCollection: Collecting already started");     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L19:
        this.isHarRecordLocal.set(AwareStateListener.isHarCollectLocal());     // Catch: Throwable -> L28
        if (this.isHarRecordLocal.get() == false) goto L24;
        com.obric.cae.log.a.i(TAG, "setLevel2DataCollection: already recording Locally");     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L24:
        this.mIsHarLevel2DataRecording.set(true);     // Catch: Throwable -> L28
        this.mLastHarCollectStartTime = r2;     // Catch: Throwable -> L28
        this.mLastHarCollectTimeout = r11;     // Catch: Throwable -> L28
        resetHarLevel2DataCountLocked();     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        com.obric.cae.log.a.e(TAG, "setLevel2DataCollection: true, totalTimeout: " + r11);
        startHarLevel2DataCollection(r13, r14, r11, r15);
        return;
    L28:
        th = move-exception;
        throw th;
    L32:
        if (this.mIsHarLevel2DataRecording.get() == true) goto L35;
        com.obric.cae.log.a.e(TAG, "setLevel2DataCollection: Collecting already stopped");
        return;
    L35:
        this.mIsHarLevel2DataRecording.set(false);
        com.obric.cae.log.a.e(TAG, "setLevel2DataCollection: false");
        stopHarLevel2DataCollection(r15);
    }

    public void startLocationScan(boolean r2, final int r3) {
        this.mLocationAwareInfoManager.startLocationScan(r2);
        new Thread(new $$Lambda$UserAwareManager$4SPwgBl2AOrlanV2WpEM_BHZtd0(this, r3), "StartLocationScanThread").start();
    }

    public void unregisterCallback(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        com.obric.cae.log.a.c(TAG, "unregisterCallback");
        RemoteCallbackList<d> r0 = this.mUserAwareCallbacks;
        monitor-enter(r0);
        this.mUserAwareCallbacks.unregister(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterInnerCallback(InnerAwareInfoCallback r3) {
        com.obric.cae.log.a.c(TAG, "unregisterInnerCallback");
        List<InnerAwareInfoCallback> r0 = this.mInnerAwareInfoCallbacks;
        monitor-enter(r0);
        this.mInnerAwareInfoCallbacks.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void zppCollectLocation(final int r3) {
        new Thread(new $$Lambda$UserAwareManager$P6ZGGDOjXzk7_Ue_P2MNMKL3ZI0(this, r3), "zppCollectLocationThread").start();
    }
}
