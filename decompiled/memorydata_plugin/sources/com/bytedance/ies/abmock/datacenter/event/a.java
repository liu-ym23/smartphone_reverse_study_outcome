package com.bytedance.ies.abmock.datacenter.event;

import android.os.Looper;
import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Npth;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 S2\u00020\u0001:\u0001SB\u0005¢\u0006\u0002\u0010\u0002J]\u0010,\u001a\u0004\u0018\u0001H-\"\u0004\b\u0000\u0010-2\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u0001H-2\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0010\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H-06¢\u0006\u0002\u00107JE\u00108\u001a\u0004\u0018\u0001H-\"\u0004\b\u0000\u0010-2\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u0001H-2\u0010\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u0001042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H-0:¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060?J\b\u0010\u000e\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020\u0011H\u0002J\u0018\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0016\u0010D\u001a\u00020@2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0EH\u0002J\u001c\u0010F\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00042\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0EJ)\u0010G\u001a\u00020@2!\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020@0HJ$\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00112\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060EJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u0006J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u0006J\u0006\u0010R\u001a\u00020@R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/event/ABMockEvent;", "", "()V", "currentAppVersionKey", "", "currentRecordKeyConstCount", "", "currentRepo", "Lcom/bytedance/keva/Keva;", "errorMessageKey", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getRepoTimeConstJson", "Lorg/json/JSONObject;", "initRepoMessage", "Lorg/json/JSONArray;", "isHit", "", "isNeedSyncTimeConstGroup", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNeedSyncTimeConstJson", "lastMinConstKey", "lastMinConstKeyTime", "", "lastRepoSuffix", "lastRepoSuffixKey", "readKeyGroup01Count", "Ljava/util/concurrent/atomic/AtomicInteger;", "readKeyGroup10Time", "readKeyGroup15Count", "readKeyGroup510Time", "repoDataStoreMessage", "repoInitKey", "repoIsInit", "repoSample", "repoSampleKey", "repoSuffix1", "repoSuffix2", "sdkDataLoadGroupLevelKey", "sdkDataLoadKey", "sdkDataStoreKey", "sdkInitCodeKey", "sdkInitTimeKey", "sdkInitTypeKey", "getABValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "defaultValue", "needCache", "abType", "magicNumber", "clazz", "Ljava/lang/Class;", "provider", "Lcom/bytedance/ies/abmock/datacenter/event/IABValueProvider;", "(Ljava/lang/String;Ljava/lang/Object;ZIILjava/lang/Class;Lcom/bytedance/ies/abmock/datacenter/event/IABValueProvider;)Ljava/lang/Object;", "getSettingsValue", "targetClass", "Lcom/bytedance/ies/abmock/datacenter/event/ISettingsValueProvider;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;Lcom/bytedance/ies/abmock/datacenter/event/ISettingsValueProvider;)Ljava/lang/Object;", "initRepo", "repoName", "block", "Ljava/util/concurrent/Callable;", "", "isSubProcess", "recordGetValueConst", "constTime", "recordMessage", "Lkotlin/Function0;", "repoDataStore", "report", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "message", "sdkInit", "currentAppVersion", "isNUJ", "setErrorReportSample", "sample", "setSample", "setScheduleWithFixedDelay", "Companion", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {
    private static String G;
    private static a H;
    private static int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static String f2679J;
    private static Keva K;
    private static Object L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0135a f2680a = null;
    private AtomicInteger A;
    private AtomicInteger B;
    private AtomicBoolean C;
    private AtomicBoolean D;
    private final JSONArray E;
    private final JSONArray F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2681b;
    private String c;
    private String d;
    private ScheduledExecutorService e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private int p;
    private boolean q;
    private Keva r;
    private String s;
    private boolean t;
    private JSONObject u;
    private String v;
    private long w;
    private int x;
    private AtomicInteger y;
    private AtomicInteger z;

    /* JADX INFO: renamed from: com.bytedance.ies.abmock.datacenter.event.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\tH\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J6\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0018H\u0087\b¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/abmock/datacenter/event/ABMockEvent$Companion;", "", "()V", "TAG", "", "abRepo", "Lcom/bytedance/keva/Keva;", "abRepoManager", "instance", "Lcom/bytedance/ies/abmock/datacenter/event/ABMockEvent;", "lock", "reportErrorMessageSample", "", "reportErrorMessageSampleKey", "getInstance", "reportErrorMessage", "", "error", "", LocationMonitorConst.TAG, "tryCatchThrowable", ExifInterface.GPS_DIRECTION_TRUE, "message", "block", "Lcom/bytedance/ies/abmock/datacenter/event/IABMockEventBlock;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/abmock/datacenter/event/IABMockEventBlock;)Ljava/lang/Object;", "data-center_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0135a {
        private C0135a() {
        }

        public /* synthetic */ C0135a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final a a() {
            if (a.b() != null) goto L15;
            Object r1 = a.c();
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (a.b() != null) goto L9;
            C0135a r0 = a.f2680a;     // Catch: Throwable -> L12
            a.a(new a());     // Catch: Throwable -> L12
        L9:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r1);
        L15:
            a r3 = a.b();
            Intrinsics.checkNotNull(r3);
            return r3;
        }

        @JvmStatic
        public final void a(Throwable r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "error");
            Intrinsics.checkNotNullParameter(r5, LocationMonitorConst.TAG);
        L14:
            th = move-exception;
            th.printStackTrace();
            return;
        L5:
            if (a.d() != null) goto L11;
            a.a(Keva.getRepoSync(a.e(), 0));     // Catch: Throwable -> L14
            Keva r3 = a.d();     // Catch: Throwable -> L14
            int r1 = 10;
            if (r3 == null) goto L9;
            r1 = r3.getInt(a.f(), 10);     // Catch: Throwable -> L14
        L9:
            a.a(r1);     // Catch: Throwable -> L14
            Log.d("ABMockEvent", "reportErrorMessageSample:" + a.g());     // Catch: Throwable -> L14
        L11:
            if (Random.Default.nextInt(1000) > a.g()) goto L19;
            Npth.reportBizException("ABMock", r4, r5, null);     // Catch: Throwable -> L14
            Log.e("ABMockEvent", "--" + r5 + " ---- " + r4 + ", stack : " + Log.getStackTraceString(r4));     // Catch: Throwable -> L14
            return;
        }
    }

    static {
        f2680a = new C0135a(null);
        G = "abmock_manager";
        I = 10;
        f2679J = "abmock_error_report_sample";
        L = new Object();
    }

    public a() {
        this.f2681b = "last_ab_event_repo";
        this.c = "_1";
        this.d = "_2";
        this.e = Executors.newSingleThreadScheduledExecutor();
        this.f = "current_app_version";
        this.g = "sdk_init_time";
        this.h = InfoRequestQPSOptTraceLogger.ERROR_MESSAGE;
        this.i = "sdk_repo_init";
        this.j = "sdk_init_code";
        this.k = "sdk_init_type";
        this.l = "sdk_repo_data_store";
        this.m = "sdk_repo_sample";
        this.n = "sdk_repo_data_load";
        this.o = "sdk_repo_data_load_level";
        this.p = 10;
        this.u = new JSONObject();
        this.w = Long.MAX_VALUE;
        this.y = new AtomicInteger(0);
        this.z = new AtomicInteger(0);
        this.A = new AtomicInteger(0);
        this.B = new AtomicInteger(0);
        this.C = new AtomicBoolean(false);
        this.D = new AtomicBoolean(false);
        this.E = new JSONArray();
        this.F = new JSONArray();
    }

    @JvmStatic
    public static final a a() {
        return f2680a.a();
    }

    private static final Unit a(a r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$block");
        r2.i();
        if (r2.q == false) goto L6;
        r4.invoke();
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(int r0) {
        I = r0;
    }

    private final void a(long r5, String r7) {
        if (r5 >= 1000) goto L9;
        AtomicInteger r0 = this.y;     // Catch: Throwable -> L6
    L5:
        r0.incrementAndGet();     // Catch: Throwable -> L6
        this.D.set(true);     // Catch: Throwable -> L6
        JSONObject r1 = this.u;     // Catch: Throwable -> L6
        monitor-enter(r1);     // Catch: Throwable -> L6
        int r2 = this.x + 1;     // Catch: Throwable -> L30
        this.x = r2;     // Catch: Throwable -> L30
        if (r2 > 20) goto L25;
        this.u.put(r7, r5);     // Catch: Throwable -> L30
        if (r5 >= this.w) goto L22;
        this.w = r5;     // Catch: Throwable -> L30
        this.v = r7;     // Catch: Throwable -> L30
    L22:
        AtomicBoolean r4 = this.C;     // Catch: Throwable -> L30
    L23:
        r4.set(true);     // Catch: Throwable -> L30
    L27:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L6
        return;
    L25:
        if (r5 <= this.w) goto L27;
        this.u.remove(this.v);     // Catch: Throwable -> L30
        this.u.put(r7, r5);     // Catch: Throwable -> L30
        this.v = r7;     // Catch: Throwable -> L30
        this.w = r5;     // Catch: Throwable -> L30
        r4 = this.C;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L6
    L9:
        if (r5 >= 5000) goto L12;
        r0 = this.z;     // Catch: Throwable -> L6
        goto L5
    L12:
        if (r5 >= 10000) goto L14;
        r0 = this.A;     // Catch: Throwable -> L6
        goto L5
    L14:
        r0 = this.B;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public static final /* synthetic */ void a(a r0) {
        H = r0;
    }

    public static final /* synthetic */ void a(a r0, long r1, String r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(Keva r0) {
        K = r0;
    }

    @JvmStatic
    public static final void a(Throwable r1, String r2) {
        f2680a.a(r1, r2);
    }

    private final void a(Function0<Unit> r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        C0135a r0 = f2680a;
        new $$Lambda$a$kxmiLDQXo1x8nYGPS_dOLmCzDO8(this, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: recordMessage", th), "ABMockEvent");
    }

    public static final /* synthetic */ a b() {
        return H;
    }

    public static final /* synthetic */ Keva b(a r0) {
        return r0.r;
    }

    private static final void b(final a r3, Function0 r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$block");
        C0135a r0 = f2680a;
        new $$Lambda$a$5HkZR9geQSF8IxfNDjvWUgGkHng(r3, r5).call();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: recordMessage", th), "ABMockEvent");
    }

    public static final /* synthetic */ Object c() {
        return L;
    }

    public static final /* synthetic */ String c(a r0) {
        return r0.g;
    }

    private static final Unit c(final a r3, Function0 r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$block");
        ScheduledExecutorService r0 = r3.e;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        r3.e = Executors.newSingleThreadScheduledExecutor();
    L10:
        ScheduledExecutorService r2 = r3.e;
        if (r2 == null) goto L13;
        r2.execute(new $$Lambda$a$PC1gXg3ca2ZFgEcASCamPS7uYs(r3, r5));
        return Unit.INSTANCE;
    L13:
        return null;
    L5:
        if (r0.isShutdown() != true) goto L7;
        goto L7
    }

    public static final /* synthetic */ Keva d() {
        return K;
    }

    public static final /* synthetic */ String d(a r0) {
        return r0.j;
    }

    public static final /* synthetic */ String e() {
        return G;
    }

    public static final /* synthetic */ String e(a r0) {
        return r0.k;
    }

    public static final /* synthetic */ String f() {
        return f2679J;
    }

    public static final /* synthetic */ String f(a r0) {
        return r0.h;
    }

    public static final /* synthetic */ int g() {
        return I;
    }

    public static final /* synthetic */ JSONArray g(a r0) {
        return r0.E;
    }

    public static final /* synthetic */ String h(a r0) {
        return r0.i;
    }

    private final boolean h() {
        BufferedReader r0 = null;
        boolean r1 = false;
        BufferedReader r2 = new BufferedReader((Reader) ZeusTransformUtils.preCheckCast(new FileReader("/proc/" + Process.myPid() + "/cmdline"), Reader.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        String r3 = r2.readLine();     // Catch: Throwable -> L14
        if (r3 == null) goto L33;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(ParameterizedMessage.ERROR_MSG_SEPARATOR, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L33;
        r1 = true;
    L33:
        r2.close();     // Catch: IOException -> L11
    L13:
        return r1;
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        th = th;
        r0 = r2;
    L39:
        th.printStackTrace();     // Catch: Throwable -> L24
        if (r0 != null) goto L31;
    L23:
        return false;
    L31:
        r0.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        th = move-exception;
        if (r0 != null) goto L35;
    L30:
        throw th;
    L35:
        r0.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L16:
        th = th;
        goto L39
    }

    public static final /* synthetic */ JSONArray i(a r0) {
        return r0.F;
    }

    private final void i() {
        if (this.t == false) goto L5;
        return;
    L5:
        C0135a r0 = f2680a;
        new $$Lambda$a$FUmjs8E_9xMdRcS8zOY8AoTF3ZQ(this).call();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        r0.a(new Throwable("cause: " + th + "--message: initRepoMessage", th), "ABMockEvent");
    }

    public static final /* synthetic */ String j(a r0) {
        return r0.l;
    }

    private static final Unit k(a r6) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Boolean r0 = Boolean.valueOf(r6.t);
        monitor-enter(r0);
    L42:
        th = move-exception;
        throw th;
    L5:
        if (r6.t == true) goto L38;
        boolean r1 = true;
        r6.t = true;     // Catch: Throwable -> L42
        if (r6.h() == true) goto L38;
        if (K != null) goto L12;
        K = Keva.getRepoSync(G, 0);     // Catch: Throwable -> L42
    L12:
        Keva r2 = K;     // Catch: Throwable -> L42
        int r4 = 50;
        if (r2 == null) goto L15;
        r4 = r2.getInt(r6.m, 50);     // Catch: Throwable -> L42
    L15:
        r6.p = r4;     // Catch: Throwable -> L42
        if (Random.Default.nextInt(1000) < r6.p) goto L19;
        r1 = false;
    L19:
        r6.q = r1;     // Catch: Throwable -> L42
        Keva r3 = K;     // Catch: Throwable -> L42
        if (r3 == null) goto L22;
        String r5 = r3.getString(r6.f2681b, r6.d);     // Catch: Throwable -> L42
    L23:
        r6.s = r5;     // Catch: Throwable -> L42
        if (r6.q == true) goto L27;
        r6.e = null;     // Catch: Throwable -> L42
        goto L38
    L27:
        if (Intrinsics.areEqual(r5, r6.d) == false) goto L33;
        Keva r7 = K;     // Catch: Throwable -> L42
        if (r7 == null) goto L31;
        r7.storeString(r6.f2681b, r6.c);     // Catch: Throwable -> L42
    L31:
        Log.d("ABMockEvent", "initRepoMessage lastRepoSuffix: " + r6.s + ", currentRepoName: " + G + r6.c);     // Catch: Throwable -> L42
        String r8 = G + r6.c;     // Catch: Throwable -> L42
    L37:
        r6.r = Keva.getRepoSync(r8, 0);     // Catch: Throwable -> L42
        goto L38
    L33:
        Keva r9 = K;     // Catch: Throwable -> L42
        if (r9 == null) goto L36;
        r9.storeString(r6.f2681b, r6.d);     // Catch: Throwable -> L42
    L36:
        Log.d("ABMockEvent", "initRepoMessage lastRepoSuffix: " + r6.s + ", currentRepoName: " + G + r6.d);     // Catch: Throwable -> L42
        r8 = G + r6.d;     // Catch: Throwable -> L42
        goto L37
    L22:
        r5 = null;
    L38:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r0);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$5HkZR9geQSF8IxfNDjvWUgGkHng(a r0, Function0 r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$FUmjs8E_9xMdRcS8zOY8AoTF3ZQ(a r0) {
        return k(r0);
    }

    /* JADX INFO: renamed from: lambda$PC1g-Xg3ca2ZFgEcASCamPS7uYs, reason: not valid java name */
    public static /* synthetic */ void m94lambda$PC1gXg3ca2ZFgEcASCamPS7uYs(a r0, Function0 r1) {
        b(r0, r1);
    }

    public static /* synthetic */ Unit lambda$kxmiLDQXo1x8nYGPS_dOLmCzDO8(a r0, Function0 r1) {
        return c(r0, r1);
    }

    /* JADX WARN: Type inference failed for: r15v4, types: [T, java.lang.String] */
    public final a a(final String r14, Callable<Integer> r15) {
        Callable r16 = (Callable) ZeusTransformUtils.wrapperContextForParams(r15, Callable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "repoName");
        Intrinsics.checkNotNullParameter(r16, "block");
        final long r9 = System.nanoTime();
        final Ref.IntRef r5 = new Ref.IntRef();
        final Ref.IntRef r6 = new Ref.IntRef();
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        Object r17 = r16.call();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r17, "block.call()");     // Catch: Throwable -> L5
        r5.element = ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L5
    L7:
        final boolean r11 = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        final long r7 = System.nanoTime();
        a((Function0) ZeusTransformUtils.preCheckCast(new ABMockEvent$initRepo$1(this, r14, r5, r6, r7, r9, r11, r12), Function0.class, "com.obric.memorydata.plugin"));
        return this;
    L5:
        th = move-exception;
        r12.element = th.toString();
        r6.element = -1;
        f2680a.a(new Throwable("initRepo: " + r14), "initRepo");
        goto L7
    }

    public final <T> T a(final String r10, T r11, Class<Object> r12, d<T> r13) {
        d r14 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r14, "provider");
        final long r6 = System.nanoTime();
        r11 = (T) r14.provide(r10, r11, r12);
    L7:
        final long r4 = System.nanoTime();
        a((Function0) ZeusTransformUtils.preCheckCast(new ABMockEvent$getSettingsValue$1(this, r4, r6, r10), Function0.class, "com.obric.memorydata.plugin"));
        return r11;
    L5:
        th = move-exception;
        f2680a.a(new Throwable("getValue: " + r10 + ", --message: " + th.getMessage()), "ABMockEvent");
        goto L7
    }

    public final <T> T a(final String r14, T r15, boolean r16, int r17, int r18, Class<Object> r19, c<T> r20) {
        c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r20, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "key");
        Intrinsics.checkNotNullParameter(r1, "provider");
        final long r10 = System.nanoTime();
        T r0 = (T) r1.provide(r14, r15, Boolean.valueOf(r16), Integer.valueOf(r17), Integer.valueOf(r18), r19);
    L7:
        final long r3 = System.nanoTime();
        a((Function0) ZeusTransformUtils.preCheckCast(new ABMockEvent$getABValue$1(this, r3, r10, r14), Function0.class, "com.obric.memorydata.plugin"));
        return r0;
    L5:
        th = move-exception;
        f2680a.a(new Throwable("getValue: " + r14 + ",  --message: " + th.getMessage()), "ABMockEvent");
        r0 = r15;
        goto L7
    }
}
