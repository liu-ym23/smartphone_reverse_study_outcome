package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.event.ParamsMonitor;
import com.bytedance.bdinstall.util.EventUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Oaid {
    public static final String KEY_OAID_ID = "oaid";
    private static volatile Oaid sOaid;
    private final Context context;
    private CallbackCenter mCallbackCenter;
    private final OaidApi mImpl;
    private OaidModel mModel;
    private Future<OaidModel> mOaidGetFuture;
    private volatile InstallOptions mOptions;
    private Runnable mPendingNotifyTask;
    private final boolean maySupport;
    private final OaidSp oaidSp;
    private final AtomicBoolean sInitializing;

    private Oaid(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.sInitializing = new AtomicBoolean(false);
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.context = r0;
        OaidApi r1 = OaidFactory.createOaidImpl(r6);
        this.mImpl = r1;
        if (r1 == null) goto L5;
        this.maySupport = r1.support(r6);
    L6:
        this.oaidSp = new OaidSp(r0);
        return;
    L5:
        this.maySupport = false;
        goto L6
    }

    static /* synthetic */ OaidModel access$000(Oaid r0) {
        return r0.resolveOaid();
    }

    static /* synthetic */ Context access$100(Oaid r0) {
        return r0.context;
    }

    static /* synthetic */ InstallOptions access$200(Oaid r0) {
        return r0.mOptions;
    }

    static /* synthetic */ OaidModel access$300(Oaid r0) {
        return r0.mModel;
    }

    static /* synthetic */ CallbackCenter access$400(Oaid r0) {
        return r0.mCallbackCenter;
    }

    static /* synthetic */ boolean access$500(Oaid r0) {
        return r0.maySupport;
    }

    static /* synthetic */ Runnable access$602(Oaid r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        r2.mPendingNotifyTask = r4;
        return r4;
    }

    private OaidModel callSysOaid(Context r14, OaidModel r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        long r2 = SystemClock.elapsedRealtime();
        OaidApi r13 = this.mImpl;
        String r0 = null;
        if (r13 == null) goto L25;
        OaidApi.Result r17 = r13.getOaid(r16);
        if (r17 == null) goto L26;
        int r18 = -1;
        int r4 = 1;
        if (r15 == null) goto L14;
        r0 = r15.reqId;
        if (r15.queryTimes != null) goto L11;
        int r19 = 0;
    L12:
        r18 = r19 + 1;
        goto L14
    L11:
        r19 = r15.queryTimes.intValue();
    L14:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        r0 = UUID.randomUUID().toString();
    L16:
        String r7 = r0;
        if (r18 <= 0) goto L20;
        r4 = r18;
    L20:
        long r110 = SystemClock.elapsedRealtime() - r2;
        long r3 = 0;
        if (ZeusTransformUtils.instanceOf(r17, HWOaidImpl.HWOaid.class) == false) goto L24;
        r3 = ((HWOaidImpl.HWOaid) ZeusTransformUtils.preCheckCast(r17, HWOaidImpl.HWOaid.class, "com.obric.memorydata.plugin")).versionCode;
    L24:
        return new OaidModel(r17.oaid, r7, Boolean.valueOf(r17.isTrackLimit), Long.valueOf(r110), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r4), Long.valueOf(r3));
    L26:
        return null;
    L25:
        return null;
    }

    public static Oaid instance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sOaid != null) goto L15;
        monitor-enter(Oaid.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sOaid != null) goto L9;
        sOaid = new Oaid(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(Oaid.class);     // Catch: Throwable -> L11
    L15:
        return sOaid;
    }

    static boolean isPackageExisted(Context r2, String r3) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r3, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    private OaidModel resolveOaid() {
        DrLog.d("Oaid#initOaid");
        OaidMonitor.onRealStartInit();
        DrLog.d("Oaid#initOaid exec");     // Catch: Throwable -> L14
        OaidModel r0 = this.oaidSp.fetch();     // Catch: Throwable -> L14
        DrLog.d("Oaid#initOaid fetch=" + r0);     // Catch: Throwable -> L14
        if (r0 == null) goto L6;
        this.mModel = r0;     // Catch: Throwable -> L14
    L6:
        OaidMonitor.onStartSystemCall();     // Catch: Throwable -> L14
        OaidModel r1 = callSysOaid(this.context, r0);     // Catch: Throwable -> L14
        OaidMonitor.onSystemCallFinished();     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        this.oaidSp.save(r1);     // Catch: Throwable -> L14
    L9:
        if (r1 == null) goto L11;
        this.mModel = r1;     // Catch: Throwable -> L14
    L11:
        DrLog.d("Oaid#initOaid oaidModel=" + r1);     // Catch: Throwable -> L14
        OaidMonitor.onOaidFinished();
        this.mPendingNotifyTask = new AnonymousClass2(this);
        trySendOaidGetEvent();
        return r1;
    L14:
        th = move-exception;
        OaidMonitor.onOaidFinished();
        this.mPendingNotifyTask = new AnonymousClass2(this);
        trySendOaidGetEvent();
        throw th;
    }

    static void safePutNonEmptyValue(JSONObject r1, String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r3 == null) goto L13;
        r1.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    static <K, V> void safePutNonNullValue(Map<K, V> r2, K r3, V r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        if (r4 == null) goto L8;
        r5.put(r3, r4);
        return;
    L8:
        return;
    }

    private synchronized void trySendOaidGetEvent() {
        monitor-enter(this);
        Runnable r0 = this.mPendingNotifyTask;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.run();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void clear() {
        this.oaidSp.clear();
    }

    public String getImplName() {
        OaidApi r0 = this.mImpl;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getName();
    }

    public Map<String, String> getOaid(long r9) {
        Map<String, String> r3 = null;
        if (this.maySupport == true) goto L5;
        return null;
    L5:
        init();
        OaidModel r2 = this.mModel;
        if (r2 != null) goto L19;
        long r4 = SystemClock.elapsedRealtime();
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
    L16:
        th = move-exception;
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        throw th;
    L9:
        if (ZeusTransformUtils.instanceOf(this.mImpl, HonorOaidImpl.class) == false) goto L11;
        r9 = r9 + 100;     // Catch: Throwable -> L13
    L11:
        DrLog.v("Oaid#getOaid timeoutMills=" + r9);     // Catch: Throwable -> L13
        OaidModel r10 = (OaidModel) ZeusTransformUtils.preCheckCast(this.mOaidGetFuture.get(r9, TimeUnit.MILLISECONDS), OaidModel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        r2 = r10;
    L19:
        if (r2 != null) goto L21;
        r2 = this.mModel;
    L21:
        if (r2 == null) goto L34;
        r3 = r2.toApiMap();
        if (this.mOptions == null) goto L34;
        ParamsMonitor r11 = EventUtils.getInstance().getParamsMonitor(this.mOptions.getAid());
        if (r11 == null) goto L34;
        if (r2.isTrackLimited != null) goto L29;
    L31:
        r11.setFlag(0);
    L32:
        r11.setState(!TextUtils.isEmpty(r2.oaid) ? 1 : 0);
        r11.setType(1);
        r11.setDuration(OaidMonitor.getSystemCallFinished() - OaidMonitor.getStartSystemCall());
        goto L34
    L29:
        if (r2.isTrackLimited.booleanValue() == false) goto L31;
        r11.setFlag(1);
    L34:
        if (this.mOptions == null) goto L36;
        EventUtils.onRegisterParams(this.mOptions);
    L36:
        DrLog.v("Oaid#getOaid return apiMap=" + r3);
        return r3;
    }

    public String getOaidId() {
        init();
        OaidModel r2 = this.mModel;
        if (r2 == null) goto L5;
        String r3 = r2.oaid;
    L6:
        DrLog.v("Oaid#getOaidId sOaidId=" + r3);
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public void init() {
        if (this.sInitializing.compareAndSet(false, true) == false) goto L6;
        OaidMonitor.onInit();
        this.mOaidGetFuture = ExecutorUtil.submitToFirstIOExecutor(new AnonymousClass1(this));
        return;
    }

    public boolean maySupport() {
        init();
        return this.maySupport;
    }

    public void setCallbackCenter(CallbackCenter r1) {
        this.mCallbackCenter = r1;
    }

    public void setInstallOptions(InstallOptions r1) {
        this.mOptions = r1;
    }

    public void startNotify() {
        trySendOaidGetEvent();
    }
}
