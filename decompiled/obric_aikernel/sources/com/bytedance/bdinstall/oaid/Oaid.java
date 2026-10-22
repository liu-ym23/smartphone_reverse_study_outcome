package com.bytedance.bdinstall.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.event.ParamsMonitor;
import com.bytedance.bdinstall.util.EventUtils;
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

    @SuppressLint({"CI_StaticFieldLeak", "StaticFieldLeak"})
    private static volatile Oaid sOaid;
    private final Context context;
    private CallbackCenter mCallbackCenter;
    private final OaidApi mImpl;
    private OaidModel mModel;
    private Future<OaidModel> mOaidGetFuture;
    private InstallOptions mOptions;
    private Runnable mPendingNotifyTask;
    private final boolean maySupport;
    private final OaidSp oaidSp;
    private final AtomicBoolean sInitializing;

    @WorkerThread
    private Oaid(Context r10) {
        this.sInitializing = new AtomicBoolean(false);
        Context r11 = r10.getApplicationContext();
        this.context = r11;
        OaidApi r12 = OaidFactory.createOaidImpl(r10);
        this.mImpl = r12;
        if (r12 == null) goto L5;
        this.maySupport = r12.support(r10);
    L6:
        this.oaidSp = new OaidSp(r11);
        return;
    L5:
        this.maySupport = false;
        goto L6
    }

    static /* synthetic */ OaidModel access$000(Oaid r10) {
        return r10.resolveOaid();
    }

    static /* synthetic */ Context access$100(Oaid r10) {
        return r10.context;
    }

    static /* synthetic */ InstallOptions access$200(Oaid r10) {
        return r10.mOptions;
    }

    static /* synthetic */ OaidModel access$300(Oaid r10) {
        return r10.mModel;
    }

    static /* synthetic */ CallbackCenter access$400(Oaid r10) {
        return r10.mCallbackCenter;
    }

    static /* synthetic */ boolean access$500(Oaid r10) {
        return r10.maySupport;
    }

    static /* synthetic */ Runnable access$602(Oaid r10, Runnable r11) {
        r10.mPendingNotifyTask = r11;
        return r11;
    }

    @WorkerThread
    private OaidModel callSysOaid(Context r13, OaidModel r14) {
        long r10 = SystemClock.elapsedRealtime();
        OaidApi r12 = this.mImpl;
        String r11 = null;
        if (r12 == null) goto L25;
        OaidApi.Result r15 = r12.getOaid(r13);
        if (r15 == null) goto L26;
        int r16 = -1;
        int r17 = 1;
        if (r14 == null) goto L14;
        r11 = r14.reqId;
        Integer r18 = r14.queryTimes;
        if (r18 != null) goto L11;
        int r19 = 0;
    L12:
        r16 = r19 + 1;
        goto L14
    L11:
        r19 = r18.intValue();
    L14:
        if (TextUtils.isEmpty(r11) == false) goto L16;
        r11 = UUID.randomUUID().toString();
    L16:
        String r20 = r11;
        if (r16 <= 0) goto L20;
        r17 = r16;
    L20:
        long r110 = SystemClock.elapsedRealtime() - r10;
        long r21 = 0;
        if ((r15 instanceof HWOaidImpl.HWOaid) == false) goto L24;
        r21 = ((HWOaidImpl.HWOaid) r15).versionCode;
    L24:
        return new OaidModel(r15.oaid, r20, Boolean.valueOf(r15.isTrackLimit), Long.valueOf(r110), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r17), Long.valueOf(r21));
    L26:
        return null;
    L25:
        return null;
    }

    @NonNull
    @WorkerThread
    public static Oaid instance(Context r10) {
        if (sOaid != null) goto L15;
        monitor-enter(Oaid.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sOaid != null) goto L9;
        sOaid = new Oaid(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(Oaid.class);     // Catch: Throwable -> L11
    L15:
        return sOaid;
    }

    static boolean isPackageExisted(Context r10, String r11) {
        if (r10.getPackageManager().getPackageInfo(r11, 128) == null) goto L10;
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
        OaidModel r10 = this.oaidSp.fetch();     // Catch: Throwable -> L14
        DrLog.d("Oaid#initOaid fetch=" + r10);     // Catch: Throwable -> L14
        if (r10 == null) goto L6;
        this.mModel = r10;     // Catch: Throwable -> L14
    L6:
        OaidMonitor.onStartSystemCall();     // Catch: Throwable -> L14
        OaidModel r11 = callSysOaid(this.context, r10);     // Catch: Throwable -> L14
        OaidMonitor.onSystemCallFinished();     // Catch: Throwable -> L14
        if (r11 == null) goto L9;
        this.oaidSp.save(r11);     // Catch: Throwable -> L14
    L9:
        if (r11 == null) goto L11;
        this.mModel = r11;     // Catch: Throwable -> L14
    L11:
        DrLog.d("Oaid#initOaid oaidModel=" + r11);     // Catch: Throwable -> L14
        OaidMonitor.onOaidFinished();
        this.mPendingNotifyTask = new AnonymousClass2(this);
        trySendOaidGetEvent();
        return r11;
    L14:
        th = move-exception;
        OaidMonitor.onOaidFinished();
        this.mPendingNotifyTask = new AnonymousClass2(this);
        trySendOaidGetEvent();
        throw th;
    }

    static void safePutNonEmptyValue(JSONObject r10, String r11, Object r12) {
        if (TextUtils.isEmpty(r11) == true) goto L12;
        if (r12 == null) goto L13;
        r10.put(r11, r12);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    static <K, V> void safePutNonNullValue(Map<K, V> r10, K r11, V r12) {
        if (r11 == null) goto L6;
        if (r12 == null) goto L7;
        r10.put(r11, r12);
        return;
    L7:
        return;
    }

    private synchronized void trySendOaidGetEvent() {
        monitor-enter(this);
        Runnable r10 = this.mPendingNotifyTask;     // Catch: Throwable -> L8
        if (r10 == null) goto L6;
        r10.run();     // Catch: Throwable -> L8
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
        OaidApi r10 = this.mImpl;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getName();
    }

    @Nullable
    @WorkerThread
    public Map<String, String> getOaid(long r10) {
        Map<String, String> r11 = null;
        if (this.maySupport == true) goto L5;
        return null;
    L5:
        init();
        DrLog.v("Oaid#getOaid timeoutMills=" + r10);
        OaidModel r12 = this.mModel;
        if (r12 != null) goto L16;
        long r13 = SystemClock.elapsedRealtime();
        OaidModel r14 = this.mOaidGetFuture.get(r10, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r13) + " ms");
        r12 = r14;
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r13) + " ms");
    L13:
        th = move-exception;
        DrLog.d("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r13) + " ms");
        throw th;
    L16:
        if (r12 != null) goto L18;
        r12 = this.mModel;
    L18:
        if (r12 == null) goto L30;
        r11 = r12.toApiMap();
        if (this.mOptions == null) goto L30;
        ParamsMonitor r15 = EventUtils.getInstance().getParamsMonitor(this.mOptions.getAid());
        if (r15 == null) goto L30;
        Boolean r16 = r12.isTrackLimited;
        if (r16 != null) goto L26;
    L28:
        r15.setFlag(0);
    L29:
        r15.setState(!TextUtils.isEmpty(r12.oaid) ? 1 : 0);
        r15.setType(1);
        r15.setDuration(OaidMonitor.getSystemCallFinished() - OaidMonitor.getStartSystemCall());
        goto L30
    L26:
        if (r16.booleanValue() == false) goto L28;
        r15.setFlag(1);
    L30:
        InstallOptions r17 = this.mOptions;
        if (r17 == null) goto L33;
        EventUtils.onRegisterParams(r17);
    L33:
        DrLog.v("Oaid#getOaid return apiMap=" + r11);
        return r11;
    }

    @Nullable
    @AnyThread
    public String getOaidId() {
        init();
        OaidModel r10 = this.mModel;
        if (r10 == null) goto L5;
        String r11 = r10.oaid;
    L6:
        DrLog.v("Oaid#getOaidId sOaidId=" + r11);
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public void init() {
        if (this.sInitializing.compareAndSet(false, true) == false) goto L6;
        OaidMonitor.onInit();
        this.mOaidGetFuture = ExecutorUtil.submitToFirstIOExecutor(new AnonymousClass1(this));
        return;
    }

    @WorkerThread
    public boolean maySupport() {
        init();
        return this.maySupport;
    }

    public void setCallbackCenter(CallbackCenter r10) {
        this.mCallbackCenter = r10;
    }

    public void setInstallOptions(InstallOptions r10) {
        this.mOptions = r10;
    }

    public void startNotify() {
        trySendOaidGetEvent();
    }
}
