package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.internal.RpcUtils;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.ss.android.common.lib.AppLogNewUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class AppLog {
    private static long A = -1;
    private static int B = -1;
    private static volatile boolean C = false;
    private static boolean D = false;
    private static com.ss.android.common.applog.i H = null;
    private static volatile com.service.middleware.applog.a I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static String f15026J = null;
    private static volatile int K = 0;
    private static volatile com.ss.android.common.applog.a.a L = null;
    private static volatile com.ss.android.common.applog.a.a M = null;
    private static volatile boolean N = false;
    private static volatile boolean O = false;
    private static volatile boolean P = false;
    private static volatile boolean Q = true;
    private static volatile boolean R = false;
    private static volatile boolean S = false;
    private static volatile long T = 0;
    private static volatile int U = -1;
    private static volatile com.bytedance.applog.k V = null;
    private static long W = 0;
    private static com.ss.android.common.applog.k X = null;
    private static boolean Y = false;
    private static boolean Z = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile com.bytedance.applog.sampling.c f15027a = null;
    private static boolean aJ = false;
    private static com.ss.android.common.a aK = null;
    private static volatile boolean aL = false;
    private static volatile boolean aM = false;
    private static volatile e aN = null;
    private static volatile long aO = 0;
    private static final ConcurrentHashMap<String, String> aS = null;
    private static final Bundle aT = null;
    private static final Object aW = null;
    private static final ThreadLocal<Boolean> aX = null;
    private static WeakReference<c> aZ = null;
    private static boolean aa = false;
    private static boolean ab = false;
    private static boolean ac = false;
    private static boolean ad = false;
    private static af ae = null;
    private static final Object af = null;
    private static volatile AppLog ag = null;
    private static volatile JSONObject ah = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile long f15028b = 432000000;
    private static volatile boolean ba = false;
    private static volatile boolean bb = false;
    private static boolean bc = false;
    private static long bd = 0;
    private static volatile f be = null;
    private static long bf = 0;
    private static volatile boolean bg = false;
    private static volatile boolean bh = false;
    private static volatile IBDAccountCallback bi = null;
    private static volatile boolean bj = false;
    static volatile int c = 10;
    public static final String[] d = null;
    static final SimpleDateFormat e = null;
    static volatile boolean f;
    static AtomicLong g;
    static volatile long h;
    static volatile int i;
    static volatile int j;
    static volatile int k;
    static String l;
    static final List<i> m = null;
    static h n;
    static g o;
    static String p;
    static int u;
    public static int v;
    static volatile boolean w;
    static volatile aa x;
    private static boolean y;
    private static volatile String z;
    private int E;
    private boolean F;
    private boolean G;
    private JSONObject aA;
    private Random aB;
    private AtomicInteger aC;
    private AtomicInteger aD;
    private LinkedList<j> aE;
    private long aF;
    private volatile long aG;
    private volatile long aH;
    private volatile boolean aI;
    private final ConcurrentHashMap<String, String> aP;
    private final ConcurrentHashMap<String, String> aQ;
    private final ConcurrentHashMap<String, String> aR;
    private final AtomicLong aU;
    private final AtomicLong aV;
    private volatile long aY;
    private int ai;
    private final com.bytedance.common.utility.a aj;
    private long ak;
    private final Context al;
    private final JSONObject am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private final HashSet<Integer> aq;
    private String ar;
    private volatile boolean as;
    private final AtomicBoolean at;
    private w au;
    private long av;
    private long aw;
    private volatile long ax;
    private int ay;
    private int az;
    volatile boolean q;
    final LinkedList<a> r;
    final LinkedList<s> s;
    volatile v t;

    /* JADX INFO: renamed from: com.ss.android.common.applog.AppLog$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15034a = null;

        static {
            int[] r0 = new int[ActionQueueType.values().length];
            f15034a = r0;
            r0[ActionQueueType.EVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L64:
            f15034a[ActionQueueType.PAGE_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L48:
            f15034a[ActionQueueType.PAGE_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L60:
            f15034a[ActionQueueType.SAVE_MISC_LOG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L66:
            f15034a[ActionQueueType.IMAGE_SAMPLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L50:
            f15034a[ActionQueueType.API_SAMPLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L54:
            f15034a[ActionQueueType.CONFIG_UPDATE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L78:
            f15034a[ActionQueueType.UA_UPDATE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L44:
            f15034a[ActionQueueType.SAVE_ANR_TAG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L70:
            f15034a[ActionQueueType.SAVE_DNS_REPORT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L74:
            f15034a[ActionQueueType.CUSTOMER_HEADER_UPDATE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L56:
            f15034a[ActionQueueType.DEVICE_ID_UPDATE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L62:
            f15034a[ActionQueueType.UPDATE_GOOGLE_AID.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L46:
            f15034a[ActionQueueType.UPDATE_APP_LANGUAGE_REGION.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L52:
            f15034a[ActionQueueType.CLEAR_WHEN_SWITCH_CHILD_MODE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L76:
            f15034a[ActionQueueType.RESET_WHEN_SWITCH_CHILD_MODE.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L42:
            f15034a[ActionQueueType.FLUSH_EVENT.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L68:
            f15034a[ActionQueueType.UPDATE_USER_UNIQUE_ID.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L72:
            f15034a[ActionQueueType.DELAY_START_LOG_REAPER.ordinal()] = 19;     // Catch: NoSuchFieldError -> L41
            return;
        }
    }

    static final enum ActionQueueType extends Enum<ActionQueueType> {
        private static final /* synthetic */ ActionQueueType[] $VALUES = null;
        public static final ActionQueueType API_SAMPLE = null;
        public static final ActionQueueType CLEAR_WHEN_SWITCH_CHILD_MODE = null;
        public static final ActionQueueType CONFIG_UPDATE = null;
        public static final ActionQueueType CUSTOMER_HEADER_UPDATE = null;
        public static final ActionQueueType DELAY_START_LOG_REAPER = null;
        public static final ActionQueueType DEVICE_ID_UPDATE = null;
        public static final ActionQueueType EVENT = null;
        public static final ActionQueueType FLUSH_EVENT = null;
        public static final ActionQueueType IMAGE_SAMPLE = null;
        public static final ActionQueueType PAGE_END = null;
        public static final ActionQueueType PAGE_START = null;
        public static final ActionQueueType RESET_WHEN_SWITCH_CHILD_MODE = null;
        public static final ActionQueueType SAVE_ANR_TAG = null;
        public static final ActionQueueType SAVE_DNS_REPORT = null;
        public static final ActionQueueType SAVE_MISC_LOG = null;
        public static final ActionQueueType UA_UPDATE = null;
        public static final ActionQueueType UPDATE_APP_LANGUAGE_REGION = null;
        public static final ActionQueueType UPDATE_GOOGLE_AID = null;
        public static final ActionQueueType UPDATE_USER_UNIQUE_ID = null;
        final int nativeInt;

        static {
            ActionQueueType r0 = new ActionQueueType("PAGE_START", 0, 0);
            PAGE_START = r0;
            ActionQueueType r1 = new ActionQueueType("PAGE_END", 1, 1);
            PAGE_END = r1;
            ActionQueueType r3 = new ActionQueueType(PendingMemoryCalendar.TYPE_EVENT, 2, 2);
            EVENT = r3;
            ActionQueueType r5 = new ActionQueueType("IMAGE_SAMPLE", 3, 3);
            IMAGE_SAMPLE = r5;
            ActionQueueType r7 = new ActionQueueType("CONFIG_UPDATE", 4, 4);
            CONFIG_UPDATE = r7;
            ActionQueueType r9 = new ActionQueueType("API_SAMPLE", 5, 5);
            API_SAMPLE = r9;
            ActionQueueType r11 = new ActionQueueType("UA_UPDATE", 6, 6);
            UA_UPDATE = r11;
            ActionQueueType r13 = new ActionQueueType("SAVE_ANR_TAG", 7, 7);
            SAVE_ANR_TAG = r13;
            ActionQueueType r15 = new ActionQueueType("SAVE_DNS_REPORT", 8, 8);
            SAVE_DNS_REPORT = r15;
            ActionQueueType r14 = new ActionQueueType("SAVE_MISC_LOG", 9, 9);
            SAVE_MISC_LOG = r14;
            ActionQueueType r12 = new ActionQueueType("DEVICE_ID_UPDATE", 10, 10);
            DEVICE_ID_UPDATE = r12;
            ActionQueueType r10 = new ActionQueueType("CUSTOMER_HEADER_UPDATE", 11, 11);
            CUSTOMER_HEADER_UPDATE = r10;
            ActionQueueType r8 = new ActionQueueType("UPDATE_GOOGLE_AID", 12, 12);
            UPDATE_GOOGLE_AID = r8;
            ActionQueueType r6 = new ActionQueueType("UPDATE_APP_LANGUAGE_REGION", 13, 13);
            UPDATE_APP_LANGUAGE_REGION = r6;
            ActionQueueType r4 = new ActionQueueType("CLEAR_WHEN_SWITCH_CHILD_MODE", 14, 14);
            CLEAR_WHEN_SWITCH_CHILD_MODE = r4;
            ActionQueueType r2 = new ActionQueueType("RESET_WHEN_SWITCH_CHILD_MODE", 15, 15);
            RESET_WHEN_SWITCH_CHILD_MODE = r2;
            ActionQueueType r16 = new ActionQueueType("FLUSH_EVENT", 16, 16);
            FLUSH_EVENT = r16;
            ActionQueueType r17 = new ActionQueueType("UPDATE_USER_UNIQUE_ID", 17, 17);
            UPDATE_USER_UNIQUE_ID = r17;
            ActionQueueType r18 = new ActionQueueType("DELAY_START_LOG_REAPER", 18, 18);
            DELAY_START_LOG_REAPER = r18;
            $VALUES = new ActionQueueType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
        }

        private ActionQueueType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static ActionQueueType valueOf(String r2) {
            return (ActionQueueType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ActionQueueType.class, r2), ActionQueueType.class, "com.obric.memorydata.plugin");
        }

        public static ActionQueueType[] values() {
            return (ActionQueueType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ActionQueueType[].class, "com.obric.memorydata.plugin");
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionQueueType f15035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15036b;
        public long c;
        public String d;
        public CountDownLatch e;

        public a(ActionQueueType r1) {
            this.f15035a = r1;
        }
    }

    private class b extends Thread implements com.ss.android.deviceregister.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppLog f15037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15038b;

        public b(AppLog r1) {
            this.f15037a = r1;
            super("ActionReaper");
            this.f15038b = false;
        }

        private void a() {
            com.ss.android.deviceregister.f.a(this);
        }

        @Override // com.ss.android.deviceregister.f.a
        public void a(String r4, String r5) {
            a r0 = new a(ActionQueueType.DEVICE_ID_UPDATE);
            JSONObject r1 = new JSONObject();
            r1.put("device_id", r4);     // Catch: JSONException -> L5
            r1.put("install_id", r5);     // Catch: JSONException -> L5
            r0.f15036b = r1;     // Catch: JSONException -> L5
        L7:
            this.f15037a.a(r0);
            AppLog.a(this.f15037a, true);
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        @Override // com.ss.android.deviceregister.f.a
        public void a(boolean r3) {
            monitor-enter(AppLog.class);
            AppLog.a(true);     // Catch: Throwable -> L10
            if (AppLog.M() == false) goto L8;
            AppLog.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppLog.e(this.f15037a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        L8:
            monitor-exit(AppLog.class);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.deviceregister.f.a
        public void a(boolean r3, boolean r4) {
            if (AppLog.d(this.f15037a) == false) goto L6;
            AppLog.a(this.f15037a, false);
            return;
        L6:
            if (r3 == true) goto L8;
            return;
        L8:
            if (AppLog.L() == false) goto L12;
            AppLog.a(this.f15037a, false, true, r4);
            return;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a();
            if (AppLog.a(this.f15037a) == true) goto L6;
            Logger.w("AppLog", "can not setup LogReaper");
            return;
        L6:
            AppLog.b(this.f15037a);
            this.f15037a.q();
        L7:
            a r0 = null;
            LinkedList<a> r1 = this.f15037a.r;
            monitor-enter(r1);
        L37:
            th = move-exception;
            throw th;
        L10:
            if (AppLog.f == true) goto L11;
            if (this.f15037a.r.isEmpty() == true) goto L43;
            Object r2 = ZeusTransformUtils.preCheckCast(this.f15037a.r.poll(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        L27:
            r0 = (a) r2;     // Catch: Throwable -> L37
        L29:
            monitor-exit(r1);     // Catch: Throwable -> L37
            if (r0 == null) goto L34;
            this.f15037a.b(r0);
            this.f15038b = true;
        L36:
            this.f15037a.a(true, false);
            goto L7
        L34:
            if (this.f15038b == false) goto L36;
            this.f15038b = false;
            this.f15037a.q();
            goto L36
        L43:
            if (this.f15038b == false) goto L18;
            this.f15037a.r.wait(AppLog.c(this.f15037a));     // Catch: InterruptedException -> L40 Throwable -> L37
            goto L20
        L18:
            this.f15037a.r.wait();     // Catch: InterruptedException -> L40 Throwable -> L37
        L20:
            if (AppLog.f == true) goto L11;
            if (this.f15037a.r.isEmpty() == true) goto L29;
            r2 = ZeusTransformUtils.preCheckCast(this.f15037a.r.poll(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L37
            Logger.d("AppLog", "ActionReadper quit");
        }
    }

    public interface c {
        void a();

        void a(boolean r1);
    }

    public interface d extends c {
        void a(JSONObject r1);
    }

    public interface e {
        JSONObject a();
    }

    public interface f {
        String a(String r1);
    }

    public interface g extends com.ss.android.deviceregister.a.h {
    }

    public interface h {
        boolean a();

        boolean b();

        boolean c();
    }

    public interface i {
        void a(long r1);

        void a(long r1, String r3, JSONObject r4);

        void b(long r1, String r3, JSONObject r4);
    }

    static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15040b;
        public final long c;
        public final long d;

        public j(String r1, int r2, long r3, long r5) {
            this.f15039a = r1;
            this.f15040b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    private static class k implements com.ss.android.common.applog.k {
        private k() {
        }

        /* synthetic */ k(AnonymousClass1 r1) {
            this();
        }

        @Override // com.ss.android.common.applog.k
        public AppLog a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Object r4 = AppLog.O();
            monitor-enter(r4);
            AnonymousClass1 r1 = null;
            if (AppLog.f == false) goto L9;
            monitor-exit(r4);     // Catch: Throwable -> L16
            return null;
        L9:
            if (AppLog.N() != null) goto L13;
            AppLog.g(new AppLog(r2, r1));     // Catch: Throwable -> L16
            if (Logger.debug() == false) goto L13;
            Logger.d("Process", " AppLog = " + AppLog.N().toString() + " pid = " + String.valueOf(Process.myPid()));     // Catch: Throwable -> L16
        L13:
            monitor-exit(r4);     // Catch: Throwable -> L16
            return AppLog.N();
        L16:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.common.applog.k
        public String a() {
            return String.valueOf(AppLog.g.get());
        }

        @Override // com.ss.android.common.applog.k
        public void a(Context r11, String r12, String r13, String r14, long r15, long r17, boolean r19, JSONObject r20) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            com.ss.android.common.applog.b.a(r12, MonitorState.init);
            AppLog r1 = AppLog.N();
            if (r1 != null) goto L7;
            com.ss.android.common.applog.a.a().a(r12, r13, r14, r15, r17, r19, r20);
            Logger.w("AppLog", "null context when onEvent");
            return;
        L7:
            if (com.bytedance.common.utility.h.a(r12) == false) goto L9;
        L14:
            x.a(1, 0, null);
            com.ss.android.common.applog.b.a(r12, MonitorState.f_block);
            return;
        L9:
            if (com.bytedance.common.utility.h.a(r13) == true) goto L14;
            if (r1 == null) goto L16;
            r1.a(r12, r13, r14, r15, r17, r19, r20);
            return;
        }

        @Override // com.ss.android.common.applog.k
        public void a(com.service.middleware.applog.a r2) {
            AppLog.b((com.service.middleware.applog.a) ZeusTransformUtils.wrapperContextForParams(r2, com.service.middleware.applog.a.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.ss.android.common.applog.k
        public boolean a(String r1) {
            return y.a(r1);
        }

        @Override // com.ss.android.common.applog.k
        public String b() {
            if (AppLog.N() != null) goto L5;
            return null;
        L5:
            return com.ss.android.deviceregister.f.h();
        }

        @Override // com.ss.android.common.applog.k
        public String c() {
            AppLog r1 = AppLog.N();
            if (r1 != null) goto L5;
            return null;
        L5:
            if (AppLog.f(r1) != null) goto L7;
            return null;
        L7:
            return AppLog.f(r1).f15107b;
        }

        @Override // com.ss.android.common.applog.k
        public JSONObject d() {
            return AppLog.P();
        }

        @Override // com.ss.android.common.applog.k
        public JSONObject e() {
            AppLog r0 = AppLog.N();
            if (r0 != null) goto L5;
            return null;
        L5:
            return AppLog.h(r0);
        }

        @Override // com.ss.android.common.applog.k
        public String f() {
            f r3 = AppLog.Q();
            if (r3 == null) goto L10;
            long r0 = AppLog.g.get();
            IBDAccountCallback r2 = AppLog.R();
            if (r2 == null) goto L8;
            r0 = ((Long) ZeusTransformUtils.preCheckCast(r2.getOdinUserInfo().second, Long.class, "com.obric.memorydata.plugin")).longValue();
        L8:
            return r3.a(String.valueOf(r0));
        L10:
            return AppLog.S();
        }

        @Override // com.ss.android.common.applog.k
        public com.service.middleware.applog.a g() {
            return AppLog.T();
        }

        @Override // com.ss.android.common.applog.k
        public String h() {
            return com.ss.android.deviceregister.f.d();
        }

        @Override // com.ss.android.common.applog.k
        public String i() {
            return AppLog.U();
        }

        @Override // com.ss.android.common.applog.k
        public com.bytedance.applog.k j() {
            return AppLog.V();
        }
    }

    static {
        X = new k(null);
        Y = true;
        Z = true;
        aa = true;
        ab = true;
        ac = true;
        ad = false;
        d = new String[]{Api.KEY_APPKEY, "openudid", "sdk_version", "package", "channel", Api.KEY_DISPLAY_NAME, "app_version", "version_code", Api.KEY_TIMEZONE, Api.KEY_ACCESS, "os", "os_version", "os_api", "device_model", "device_brand", "device_manufacturer", Api.KEY_LANGUAGE, "resolution", "display_density", "density_dpi", Api.KEY_CARRIER, Api.KEY_MCC_MNC, "clientudid", "install_id", "device_id", Api.KEY_SIG_HASH, "aid", "push_sdk", Api.KEY_ROM, "release_build", "update_version_code", "manifest_version_code", Api.KEY_APP_VERSION_MINOR, "cpu_abi", Api.KEY_APP_TRACK, Api.KEY_NOT_REQUEST_SENDER, "rom_version", Api.KEY_REGION, Api.KEY_TZ_NAME, Api.KEY_TZ_OFFSET, Api.KEY_SIM_REGION, "custom", "google_aid", Api.KEY_APP_LANGUAGE, Api.KEY_APP_REGION, "ab_sdk_version", Api.KEY_USER_UNIQUE_ID, WsConstants.KEY_PLATFORM, "harmony_os_api", "harmony_os_version", "harmony_release_type", Cdid.KEY_CDID};
        e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        af = new Object();
        f = false;
        g = new AtomicLong();
        h = 0;
        i = 0;
        j = 0;
        k = 0;
        l = "";
        m = new ArrayList(2);
        p = null;
        ah = null;
        aJ = false;
        u = 0;
        aS = new ConcurrentHashMap();
        aT = new Bundle();
        aW = new Object();
        aX = new ThreadLocal();
        aZ = null;
        ba = false;
        bb = false;
        bc = false;
        bd = 0;
        bf = -1;
        bg = false;
        w = false;
        bh = false;
        bj = false;
    }

    private AppLog(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        this.F = false;
        this.G = false;
        this.ai = 1;
        this.q = false;
        this.r = new LinkedList();
        this.s = new LinkedList();
        this.t = null;
        this.ak = 0;
        this.an = false;
        this.ao = false;
        this.ap = false;
        this.aq = new HashSet();
        this.ar = "";
        this.as = false;
        this.at = new AtomicBoolean();
        this.av = 30000;
        this.aw = 60000;
        this.ax = 21600000;
        this.ay = 1;
        this.az = 0;
        this.aA = null;
        this.aB = new Random();
        this.aC = new AtomicInteger();
        this.aD = new AtomicInteger();
        this.aE = new LinkedList();
        this.aF = System.currentTimeMillis();
        this.aG = 0;
        this.aH = 0;
        this.aI = false;
        this.aP = new ConcurrentHashMap();
        this.aQ = new ConcurrentHashMap();
        this.aR = new ConcurrentHashMap();
        this.aU = new AtomicLong();
        this.aV = new AtomicLong();
        com.ss.android.deviceregister.f.a("2.14.0");
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.al = r0;
        com.ss.android.deviceregister.f.a(r0);
        this.am = new JSONObject();
        c(r10);
        this.q = true;
        new b(this).start();
        this.aj = new com.bytedance.common.utility.a(r0);
    }

    /* synthetic */ AppLog(Context r2, AnonymousClass1 r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static String A() {
        return X.h();
    }

    public static String B() {
        return X.i();
    }

    public static boolean C() {
        return N;
    }

    public static Map<String, String> D() {
        return aS;
    }

    public static boolean E() {
        return bh;
    }

    static boolean F() {
        return O;
    }

    public static boolean G() {
        return P;
    }

    public static boolean H() {
        return Q;
    }

    public static boolean I() {
        return R;
    }

    public static boolean J() {
        return S;
    }

    public static com.bytedance.applog.k K() {
        return X.j();
    }

    static /* synthetic */ boolean L() {
        return aL;
    }

    static /* synthetic */ boolean M() {
        return bb;
    }

    static /* synthetic */ AppLog N() {
        return ag;
    }

    static /* synthetic */ Object O() {
        return af;
    }

    static /* synthetic */ JSONObject P() {
        return ah;
    }

    static /* synthetic */ f Q() {
        return be;
    }

    static /* synthetic */ IBDAccountCallback R() {
        return bi;
    }

    static /* synthetic */ String S() {
        return z;
    }

    static /* synthetic */ com.service.middleware.applog.a T() {
        return I;
    }

    static /* synthetic */ String U() {
        return f15026J;
    }

    static /* synthetic */ com.bytedance.applog.k V() {
        return V;
    }

    private void W() {
        this.aU.set(0);
        this.aV.set(0);
    }

    private synchronized void X() {
        monitor-enter(this);
        ah = new JSONObject(this.am, com.ss.android.common.applog.c.f15072b);     // Catch: Throwable -> L5 JSONException -> L7
    L9:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        Logger.i("ensureHeaderCopy error");     // Catch: Throwable -> L5
        e.printStackTrace();     // Catch: Throwable -> L5
        goto L9
    }

    private void Y() {
        WeakReference<c> r2 = aZ;
        if (r2 == null) goto L11;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.get(), c.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        r3.a();     // Catch: Exception -> L8
        return;
    L13:
        return;
    L12:
        return;
    }

    private boolean Z() {
        Context r2 = this.al;     // Catch: Exception -> L9
        boolean r3 = this.F;     // Catch: Exception -> L9
        com.ss.android.deviceregister.a.i r4 = new AnonymousClass3(this);     // Catch: Exception -> L9
        boolean r5 = y;     // Catch: Exception -> L9
        boolean r6 = aJ;     // Catch: Exception -> L9
        boolean r7 = C;     // Catch: Exception -> L9
        if (ad == true) goto L6;
        boolean r8 = true;
    L7:
        com.ss.android.deviceregister.e.a(r2, r3, r4, r5, r6, r7, r8);     // Catch: Exception -> L9
    L12:
        this.q = a(this.am, this.al);     // Catch: Exception -> L46
        com.ss.android.common.applog.d r9 = com.ss.android.common.applog.d.a(this.al);     // Catch: Exception -> L46
        w r10 = r9.c(0);     // Catch: Exception -> L46
        this.au = r10;     // Catch: Exception -> L46
        a(r10);     // Catch: Exception -> L46
        Y();     // Catch: Exception -> L46
        if (this.au == null) goto L56;
        Logger.i("AppLog", "start with last session " + this.au.f15107b);     // Catch: Exception -> L46
        r r11 = new r();     // Catch: Exception -> L46
        r11.f15100a = this.au.f15106a;     // Catch: Exception -> L46
        a(r11);     // Catch: Exception -> L46
    L56:
        Bundle r12 = new Bundle();     // Catch: Throwable -> L30
        Bundle r13 = aT;     // Catch: Throwable -> L30
        monitor-enter(r13);     // Catch: Throwable -> L30
        r12.putAll(r13);     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
    L20:
        if (r12.size() <= 0) goto L32;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L30
        Iterator<String> r15 = r12.keySet().iterator();     // Catch: Throwable -> L30
    L23:
        if (r15.hasNext() == false) goto L25;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        r14.put(r16, r12.get(r16));     // Catch: Throwable -> L30
        goto L23
    L25:
        this.am.put("custom", r14);     // Catch: Throwable -> L30
    L32:
        this.t = new v(this.al, new JSONObject(this.am, com.ss.android.common.applog.c.f15072b), this.s, this.at, m, this.au, this.aP, this.aQ);     // Catch: Exception -> L46
        this.t.a(this.aw);     // Catch: Exception -> L46
        this.t.a(this.ay);     // Catch: Exception -> L46
        if (W <= 0) goto L35;
        ad.a().c(new AnonymousClass4(this), W);     // Catch: Exception -> L46
    L37:
        if (K > 0) goto L39;
    L43:
        r9.c();     // Catch: Exception -> L46
        return true;
    L39:
        if (this.E != this.ai) goto L42;
        com.ss.android.common.applog.a.a r17 = com.ss.android.common.applog.a.a.a(this.al);     // Catch: Exception -> L46
    L41:
        L = r17;     // Catch: Exception -> L46
        goto L43
    L42:
        this.aG = 0;     // Catch: Exception -> L46
        r17 = com.ss.android.common.applog.a.a.a(this.al, null);     // Catch: Exception -> L46
        goto L41
    L35:
        this.t.start();     // Catch: Exception -> L46
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L46
        goto L32
    L6:
        r8 = false;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L46
        if (Logger.debug() == false) goto L12;
        throw e;     // Catch: Exception -> L46
    L46:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, SQLiteException.class) == false) goto L50;
        com.ss.android.common.applog.b.a(MonitorKey.database, MonitorState.f_exception);
    L50:
        com.ss.android.common.b.b.d("failed to start LogReaper", e);
        return false;
    }

    public static AppLog a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return X.a(r3);
    }

    static String a(long r2) {
        return e.format(new Date(r2));
    }

    @Deprecated
    public static String a(String r0, boolean r1) {
        return y.a(r0, r1);
    }

    public static void a(Context r11, String r12, String r13, String r14, long r15, long r17, JSONObject r19) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin"), r12, r13, r14, r15, r17, false, r19);
    }

    public static void a(Context r12, String r13, String r14, String r15, long r16, long r18, boolean r20, JSONObject r21) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        b(r21);
        X.a(r2, r13, r14, r15, r16, r18, r20, r21);
    }

    private void a(Context r3, boolean r4) {
        com.ss.android.deviceregister.a.u.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), this.am, r4);
        if (this.t == null) goto L11;
        JSONObject r5 = new JSONObject(this.am, com.ss.android.common.applog.c.f15072b);     // Catch: JSONException -> L6
        this.t.b(r5);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        Logger.e("AppLog", "updateHeader", e);
        return;
    }

    private void a(Bundle r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.size() > 0) goto L8;
        return;
    L8:
        if (this.t == null) goto L26;
        JSONObject r1 = this.am.optJSONObject("custom");     // Catch: Throwable -> L21
        if (r1 != null) goto L12;
        r1 = new JSONObject();     // Catch: Throwable -> L21
    L12:
        Iterator<String> r2 = r7.keySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (r2.hasNext() == false) goto L16;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r1.put(r3, r7.get(r3));     // Catch: Throwable -> L21
        goto L14
    L16:
        this.am.put("custom", r1);     // Catch: Throwable -> L21
        if (this.t == null) goto L19;
        JSONObject r8 = new JSONObject(this.am, com.ss.android.common.applog.c.f15072b);     // Catch: Throwable -> L21
        this.t.b(r8);     // Catch: Throwable -> L21
    L19:
        X();     // Catch: Throwable -> L21
        return;
    L28:
        return;
    }

    public static void a(com.service.middleware.applog.a r2) {
        com.service.middleware.applog.a r3 = (com.service.middleware.applog.a) ZeusTransformUtils.wrapperContextForParams(r2, com.service.middleware.applog.a.class, "com.obric.memorydata.plugin");
        X.a(r3);
    }

    private void a(a r2, MonitorState r3) {
        if (r2 == null) goto L22;
        int r1 = AnonymousClass5.f15034a[r2.f15035a.ordinal()];
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L8;
        MonitorKey r4 = MonitorKey.launch;
    L15:
        com.ss.android.common.applog.b.a(r4, r3);
        return;
    L8:
        if (r1 != 3) goto L10;
        r4 = MonitorKey.terminate;
        goto L15
    L10:
        if (r1 != 4) goto L26;
        r4 = MonitorKey.log_data;
        goto L15
    L26:
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r2.f15036b, o.class) == false) goto L24;
        o r5 = (o) ZeusTransformUtils.preCheckCast(r2.f15036b, o.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L25;
        com.ss.android.common.applog.b.a(r5.f15095b, r3);
        return;
    L25:
        return;
    L24:
        return;
    }

    static /* synthetic */ void a(AppLog r0, boolean r1, boolean r2, boolean r3) {
        r0.a(r1, r2, r3);
    }

    static void a(JSONObject r3) {
        AppLog r0 = ag;
        if (r0 != null) goto L10;
        return;
    L10:
        r3.put("tea_event_index", r0.aU.getAndIncrement());     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    private void a(boolean r4, long r5, com.ss.android.deviceregister.q r7) {
        com.ss.android.deviceregister.q r8 = (com.ss.android.deviceregister.q) ZeusTransformUtils.wrapperContextForParams(r7, com.ss.android.deviceregister.q.class, "com.obric.memorydata.plugin");
        com.ss.android.common.a.a.a(this.al, g(), r4, false);
        com.ss.android.deviceregister.f.a(r4, r5, r8);
        a(this.al, r4);
    }

    private void a(boolean r16, boolean r17, final boolean r18) {
        if (this.aI == false) goto L5;
        return;
    L5:
        JSONObject r0 = this.am;
        if (r0 != null) goto L9;
        return;
    L9:
        if (a(r0.optString("device_id", null)) == false) goto L13;
        Log.e("AppLog", "tryUpdateConfig no did");
        return;
    L13:
        if (com.bytedance.common.utility.h.a(this.am.optString("install_id", null)) == false) goto L16;
        Log.e("AppLog", "tryUpdateConfig no iid");
        return;
    L16:
        long r3 = System.currentTimeMillis();
        long r5 = this.ax;
        long r7 = 60000;
        if (this.E != this.ai) goto L19;
        boolean r1 = true;
    L21:
        if (aJ == false) goto L23;
    L26:
        if (r1 == false) goto L28;
        r7 = 180000;
    L28:
        if (r17 == true) goto L37;
        if ((r3 - this.aG) >= r5) goto L33;
        return;
    L33:
        if ((r3 - this.aH) >= r7) goto L67;
        Logger.d("AppLog", "next query time : " + DateFormat.getDateTimeInstance().format(new Date(this.aH + r7)));
        return;
    L67:
        final long r6 = System.currentTimeMillis();     // Catch: Exception -> L66
        if (T > 0) goto L45;
        T = r6;     // Catch: Exception -> L66
    L45:
        if (bg == false) goto L48;
        return;
    L48:
        if (NetworkUtils.b(this.al) == true) goto L51;
        com.ss.android.common.applog.b.a(MonitorKey.config, MonitorState.f_no_network);     // Catch: Exception -> L66
        return;
    L51:
        this.aH = r3;     // Catch: Exception -> L66
        this.aI = true;     // Catch: Exception -> L66
        JSONObject r2 = new JSONObject(this.am, com.ss.android.common.applog.c.f15072b);     // Catch: Exception -> L66
        String r4 = com.ss.android.deviceregister.a.u.b(this.al);     // Catch: Exception -> L66
        if (com.bytedance.common.utility.h.a(r4) == true) goto L54;
        r2.put(Api.KEY_USER_AGENT, r4);     // Catch: Exception -> L66
    L54:
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L66
        r8.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Exception -> L66
        r8.put("header", r2);     // Catch: Exception -> L66
        r8.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L66
        if (aM == false) goto L61;
        e r9 = aN;     // Catch: Exception -> L66
        if (r9 == null) goto L61;
        JSONObject r10 = r9.a();     // Catch: Exception -> L66
        if (r10 == null) goto L61;
        r8.put("photoinfo", r10);     // Catch: Exception -> L66
    L61:
        final String r11 = r8.toString();     // Catch: Exception -> L66
        if (r16 == false) goto L64;
        new AnonymousClass2(this, r11, r18, r6).start();     // Catch: Exception -> L66
        return;
    L64:
        a(r11, r18, r6);     // Catch: Exception -> L66
        return;
    L69:
        return;
    L37:
        if (this.aH <= this.aG) goto L67;
        if ((r3 - this.aH) >= r7) goto L67;
        return;
    L23:
        if (this.ak >= 0) goto L26;
        if (r1 == false) goto L26;
        r5 = 2 * this.ax;
        goto L26
    L19:
        r1 = false;
        goto L21
    }

    public static boolean a() {
        if (U >= 0) goto L6;
        Logger.e("AppLog", Log.getStackTraceString(new RuntimeException("SwitchToBdtracker has not been set!")));
    L6:
        if (U <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    static /* synthetic */ boolean a(AppLog r0) {
        return r0.Z();
    }

    static /* synthetic */ boolean a(AppLog r0, String r1) {
        return r0.f(r1);
    }

    static /* synthetic */ boolean a(AppLog r0, boolean r1) {
        r0.G = r1;
        return r1;
    }

    public static boolean a(String r1) {
        return X.a(r1);
    }

    private boolean a(JSONObject r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        JSONArray r0 = new JSONArray();     // Catch: Exception -> L24
        if (Y == false) goto L7;
        r0.put(1);     // Catch: Exception -> L24
    L7:
        if (Z == false) goto L10;
        r0.put(2);     // Catch: Exception -> L24
    L10:
        if (aa == false) goto L13;
        r0.put(7);     // Catch: Exception -> L24
    L13:
        if (ab == false) goto L16;
        r0.put(8);     // Catch: Exception -> L24
    L16:
        if (ac == false) goto L18;
        r0.put(9);     // Catch: Exception -> L24
    L18:
        r3.put("push_sdk", r0);     // Catch: Exception -> L24
        String r1 = B();     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r1) == true) goto L21;
        r3.put(Api.KEY_USER_UNIQUE_ID, r1);     // Catch: Exception -> L24
    L21:
        c(r3);     // Catch: Exception -> L24
    L23:
        return com.ss.android.deviceregister.f.a(r5, r3, C);
    }

    private static boolean a(JSONObject r2, String r3, boolean r4) {
        if (r2 != null) goto L4;
    L14:
        return r4;
    L4:
        if (r2.isNull(r3) == true) goto L14;
        int r0 = r2.optInt(r3, -1);
        if (r0 < 1) goto L9;
        return true;
    L9:
        if (r0 != 0) goto L13;
        return false;
    L13:
        return r2.optBoolean(r3, r4);
    }

    static /* synthetic */ boolean a(boolean r0) {
        ba = r0;
        return r0;
    }

    private void aa() {
        if (this.au == null) goto L6;
        u r0 = new u();
        r0.f15102a = this.au;
        r0.e = true;
        a(r0);
        return;
    }

    public static long b() {
        return A;
    }

    static /* synthetic */ com.service.middleware.applog.a b(com.service.middleware.applog.a r2) {
        com.service.middleware.applog.a r3 = (com.service.middleware.applog.a) ZeusTransformUtils.wrapperContextForParams(r2, com.service.middleware.applog.a.class, "com.obric.memorydata.plugin");
        I = r3;
        return r3;
    }

    static /* synthetic */ void b(Context r2) {
        d((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void b(AppLog r0) {
        r0.X();
    }

    private void b(o r11) {
        com.ss.android.common.applog.i r0 = H;
        if (r0 == null) goto L6;
        r0.a(r11.f15095b, r11.c, r11.d, r11.e, r11.f, r11.o, r11.n);
        return;
    }

    private static void b(JSONObject r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.has("ab_sdk_version") == true) goto L15;
        String r1 = y();
        if (TextUtils.isEmpty(r1) == true) goto L16;
        r3.put("ab_sdk_version", r1);     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    }

    private void b(boolean r3) {
        WeakReference<c> r2 = aZ;
        if (r2 == null) goto L11;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2.get(), c.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        r4.a(r3);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L12:
        return;
    }

    static String[] b(JSONObject r7, boolean r8) {
        String[] r3 = null;
        if (r8 == false) goto L16;
        if (bh == false) goto L7;
        r7.put("uid_enable", 1);     // Catch: JSONException -> L26
        boolean r9 = true;
    L9:
        if (C() == false) goto L19;
        r7.put("event_sampling", 1);     // Catch: JSONException -> L26
        com.bytedance.applog.sampling.c r4 = f15027a;     // Catch: JSONException -> L26
        if (r4 == null) goto L19;
        JSONObject r5 = r7.optJSONObject("header");     // Catch: JSONException -> L26
        if (r5 == null) goto L19;
        r5.put("event_sampling_version", r4.a());     // Catch: JSONException -> L26
        r7.put("header", r5);     // Catch: JSONException -> L26
    L19:
        if (r9 == true) goto L21;
    L28:
        return r3;
    L21:
        if (k() == false) goto L28;
        r3 = com.ss.android.deviceregister.b.a.a.c.b();     // Catch: JSONException -> L26
        if (com.ss.android.deviceregister.b.a.a.c.a(r3) == false) goto L28;
        r7.put("key", r3[0]);     // Catch: JSONException -> L26
        r7.put("iv", r3[1]);     // Catch: JSONException -> L26
        goto L28
    L7:
        r9 = false;
        goto L9
    L16:
        if (K <= 0) goto L18;
        r7.put("event_filter", K);     // Catch: JSONException -> L26
        r9 = true;
        goto L19
    L18:
        r9 = false;
    L26:
        e = move-exception;
        Logger.e("AppLog", "fillKeyIvForEncryptResp", e);
        goto L28
    }

    static /* synthetic */ long c(AppLog r2) {
        return r2.av;
    }

    private void c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        w();
        W();
        boolean r1 = false;
        if (this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).getInt("forbid_report_phone_detail_info", 0) <= 0) goto L5;
        r1 = true;
    L5:
        this.F = r1;
        if (C() == false) goto L9;
        f15027a = com.bytedance.applog.sampling.d.a(this.al, null);
        return;
    }

    private void c(String r5) {
        if (com.bytedance.common.utility.h.a(r5) == false) goto L6;
        return;
    L6:
        if (this.t == null) goto L19;
        if (r5.equals(this.am.optString("google_aid", null)) == false) goto L10;
        return;
    L10:
        if (C == true) goto L14;
        this.am.put("google_aid", r5);     // Catch: Throwable -> L16
        if (this.t == null) goto L14;
        JSONObject r1 = new JSONObject(this.am, com.ss.android.common.applog.c.f15072b);     // Catch: Throwable -> L16
        this.t.b(r1);     // Catch: Throwable -> L16
    L14:
        this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit().putString("google_aid", r5).commit();     // Catch: Throwable -> L16
        return;
    L21:
        return;
    }

    private void c(JSONObject r5) {
        boolean r1 = com.ss.android.deviceregister.d.e.v();
        if (r1 == false) goto L6;
        String r3 = "Harmony";
    L20:
        r5.put(WsConstants.KEY_PLATFORM, r3);     // Catch: JSONException -> L9
    L11:
        if (r1 == true) goto L18;
        return;
    L18:
        r5.put("harmony_os_api", SystemPropertiesWithCache.get("hw_sc.build.os.apiversion"));     // Catch: Throwable -> L15
        r5.put("harmony_os_version", SystemPropertiesWithCache.get("hw_sc.build.platform.version"));     // Catch: Throwable -> L15
        r5.put("harmony_release_type", SystemPropertiesWithCache.get("hw_sc.build.os.releasetype"));     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        Logger.e("AppLog", "loadHarmonyInfo " + th.toString());
        return;
    L9:
        e = move-exception;
        Logger.e("AppLog", "loadHarmonyInfo " + e.toString());
        goto L11
    L6:
        r3 = LocationInfoConst.SYSTEM;
        goto L20
    }

    private void c(boolean r3) {
        com.ss.android.deviceregister.f.d(r3);
        if (r3 == false) goto L5;
        this.am.remove("openudid");
        this.am.remove("google_aid");
        this.am.remove("device_id");
        this.am.remove("install_id");
    L5:
        a(this.al, r3);
        com.ss.android.common.applog.d.a(this.al).b();
        w r4 = this.au;
        if (r4 == null) goto L8;
        boolean r5 = r4.i;
    L9:
        this.au = null;
        a(System.currentTimeMillis(), r5);
        return;
    L8:
        r5 = true;
        goto L9
    }

    static boolean c(long r2) {
        if (r2 >= 10000) goto L5;
    L7:
        return false;
    L5:
        if (r2 > 300000) goto L7;
        return true;
    }

    private boolean c(final o r13) {
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L36
        if (r13 == null) goto L35;
        if (r13.p == true) goto L35;
        if ((r4 - this.aY) < 900000) goto L35;
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r13.f15095b) == false) goto L35;
        ConcurrentHashMap<String, String> r5 = this.aR;     // Catch: Throwable -> L36
        if (r5 == null) goto L35;
        if (r5.size() <= 0) goto L35;
        if (com.bytedance.common.utility.h.a(r13.c) == true) goto L35;
        if (this.aR.containsKey(r13.c) == false) goto L35;
        if (com.bytedance.common.utility.h.a(r13.n) == true) goto L35;
        JSONObject r6 = new JSONObject(r13.n);     // Catch: Throwable -> L36
        if (r6.optInt(AppLogNewUtils.EVENT_SIGN, 0) != 1) goto L35;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L36
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L36
        if (r6.has("nt") == false) goto L28;
        r8.put("nt", r6.optInt("nt"));     // Catch: Throwable -> L36
    L28:
        if (r13.h <= 0) goto L30;
        r8.put(Header.KEY_USER_ID, r13.h);     // Catch: Throwable -> L36
        r8.put("user_is_login", r13.j);     // Catch: Throwable -> L36
        r8.put("user_type", r13.g);     // Catch: Throwable -> L36
        r8.put("user_is_auth", r13.k);     // Catch: Throwable -> L36
    L30:
        r6.remove("nt");     // Catch: Throwable -> L36
        r6.remove(AppLogNewUtils.EVENT_SIGN);     // Catch: Throwable -> L36
        r8.put("event", r13.c);     // Catch: Throwable -> L36
        r8.put(TrackerImpl.PARAMS, r6);     // Catch: Throwable -> L36
        r8.put("session_id", r13.m);     // Catch: Throwable -> L36
        r8.put("datetime", a(r13.l));     // Catch: Throwable -> L36
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L36
        r0.put(r8);     // Catch: Throwable -> L36
        r7.put(AppLogNewUtils.EVENT_V3_CATEGORY, r0);     // Catch: Throwable -> L36
        JSONObject r1 = this.aA;     // Catch: Throwable -> L36
        if (r1 == null) goto L33;
        r7.put("time_sync", r1);     // Catch: Throwable -> L36
    L33:
        r7.put(Api.KEY_MAGIC, Api.MSG_MAGIC);     // Catch: Throwable -> L36
        JSONObject r2 = com.ss.android.common.applog.c.b(this.al, this.am);     // Catch: Throwable -> L36
        final String r3 = r2.optString("device_id");     // Catch: Throwable -> L36
        r7.put("header", r2);     // Catch: Throwable -> L36
        r7.put("_gen_time", System.currentTimeMillis());     // Catch: Throwable -> L36
        final String r9 = r7.toString();     // Catch: Throwable -> L36
        new AnonymousClass1(this, r9, r13, r3).a();     // Catch: Throwable -> L36
        com.ss.android.common.applog.b.a(MonitorKey.real_event, MonitorState.init);     // Catch: Throwable -> L36
        return true;
    L35:
        return false;
    }

    static String[] c() {
        return ae.e;
    }

    private void d(long r5) {
        List<i> r4 = m;
        if (r4 != null) goto L5;
        return;
    L5:
        monitor-enter(r4);
        Iterator<i> r0 = r4.iterator();     // Catch: Throwable -> L12
    L8:
        if (r0.hasNext() == false) goto L10;
        ((i) ZeusTransformUtils.preCheckCast(r0.next(), i.class, "com.obric.memorydata.plugin")).a(r5);     // Catch: Throwable -> L12
        goto L8
    L10:
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static void d(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (ba == false) goto L5;
    L16:
        bb = false;
        long r0 = System.currentTimeMillis();
        if ((r0 - bd) >= 900000) goto L19;
        return;
    L19:
        if (NetworkUtils.b(r7) == false) goto L25;
        bd = r0;
        com.ss.android.common.a.a.a(r7, g(), C, D);
        return;
    L25:
        return;
    L5:
        monitor-enter(AppLog.class);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (ba == true) goto L11;
        bb = true;     // Catch: Throwable -> L13
        monitor-exit(AppLog.class);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(AppLog.class);     // Catch: Throwable -> L13
        goto L16
    }

    private void d(JSONObject r4) {
        String r0 = r4.optString(Api.KEY_APP_LANGUAGE, null);
        String r5 = r4.optString(Api.KEY_APP_REGION, null);
        if (d(r0) == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        com.ss.android.deviceregister.f.k();
        Logger.d("AppLog", "updateDeviceInfo call device_register");
        return;
    L12:
        return;
    L5:
        if (e(r5) == true) goto L8;
        r3 = false;
        goto L9
    }

    static /* synthetic */ boolean d(AppLog r0) {
        return r0.G;
    }

    private boolean d(String r6) {
        if (com.bytedance.common.utility.h.a(r6) == false) goto L15;
        return false;
    L15:
        if (r6.equals(this.am.optString(Api.KEY_APP_LANGUAGE, null)) == true) goto L13;
        this.am.put(Api.KEY_APP_LANGUAGE, r6);     // Catch: Throwable -> L14
        if (this.t == null) goto L10;
        JSONObject r1 = new JSONObject(this.am, com.ss.android.common.applog.c.f15072b);     // Catch: Throwable -> L14
        this.t.b(r1);     // Catch: Throwable -> L14
    L10:
        this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit().putString(Api.KEY_APP_LANGUAGE, r6).commit();     // Catch: Throwable -> L14
        return true;
    L13:
        return false;
    }

    static String[] d() {
        return ae.c;
    }

    static /* synthetic */ Context e(AppLog r0) {
        return r0.al;
    }

    static String e() {
        return ae.d;
    }

    private void e(JSONObject r6) {
        Log.d("AppLog", "updateDid " + r6);
        if (r6 != null) goto L5;
        return;
    L5:
        boolean r0 = a(this.am.optString("device_id", null));
        String r3 = r6.optString("device_id", null);
        String r7 = r6.optString("install_id", null);
        if (com.bytedance.common.utility.h.a(r3) == true) goto L12;
        this.am.put("device_id", r3);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        if (com.bytedance.common.utility.h.a(r7) == true) goto L18;
        this.am.put("install_id", r7);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    L18:
        if (this.t != null) goto L25;
    L23:
        X();
        a(true, true, r0);
        return;
    L25:
        this.t.b(new JSONObject(this.am, com.ss.android.common.applog.c.f15072b));     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    private boolean e(String r6) {
        if (com.bytedance.common.utility.h.a(r6) == false) goto L15;
        return false;
    L15:
        if (r6.equals(this.am.optString(Api.KEY_APP_REGION, null)) == true) goto L13;
        this.am.put(Api.KEY_APP_REGION, r6);     // Catch: Throwable -> L14
        if (this.t == null) goto L10;
        JSONObject r1 = new JSONObject(this.am, com.ss.android.common.applog.c.f15072b);     // Catch: Throwable -> L14
        this.t.b(r1);     // Catch: Throwable -> L14
    L10:
        this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit().putString(Api.KEY_APP_REGION, r6).commit();     // Catch: Throwable -> L14
        return true;
    L13:
        return false;
    }

    static /* synthetic */ w f(AppLog r0) {
        return r0.au;
    }

    static String f() {
        return ae.i;
    }

    private void f(JSONObject r3) {
        WeakReference<c> r2 = aZ;
        if (r2 == null) goto L11;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r2.get(), c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L12;
        ((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin")).a(r3);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L12:
        return;
    }

    private boolean f(String r24) {
        Logger.d("AppLog", "app_log_config: " + r24);     // Catch: Throwable -> L31
        byte[] r15 = r24.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L31
        if (c() != null) goto L6;
    L40:
        return false;
    L6:
        if (c().length == 0) goto L40;
        String[] r11 = c();     // Catch: Throwable -> L31
        int r10 = r11.length;     // Catch: Throwable -> L31
        int r9 = 0;
    L8:
        if (r9 >= r10) goto L40;
        String r16 = z.a(y.a(r11[r9], true), z.c);     // Catch: Throwable -> L31
        byte[] r4 = (byte[]) ZeusTransformUtils.preCheckCast(r15.clone(), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        Map<String, String> r17 = D();     // Catch: Throwable -> L31
        if (this.al != null) goto L12;
    L19:
        boolean r20 = true;
        int r21 = r9;
        int r22 = r10;
        String[] r18 = r11;
        String r2 = y.a(r16, r15, true, "application/octet-stream;tt-data=b", false, r17, false, true);     // Catch: Throwable -> L31
    L20:
        if (r2 == null) goto L30;
        if (r2.length() == 0) goto L30;
        JSONObject r0 = new JSONObject(r2);     // Catch: Throwable -> L31
        if (Api.MSG_MAGIC.equals(r0.optString(Api.KEY_MAGIC)) == false) goto L52;
        if ("success".equals(r0.optString("message")) == true) goto L29;
        return false;
    L29:
        return r20;
    L52:
        return false;
    L30:
        r9 = r21 + 1;
        r11 = r18;
        r10 = r22;
        goto L8
    L12:
        if (k() == false) goto L19;
        r20 = true;
        r21 = r9;
        r22 = r10;
        r18 = r11;
        r2 = y.a(K(), r16, r4, this.al, false, null, r17, r24, false, true);     // Catch: RuntimeException -> L41 Throwable -> L31
    L18:
        com.ss.android.common.applog.b.a(MonitorKey.real_event, MonitorState.f_to_bytes);     // Catch: Throwable -> L31
        r2 = y.a(r16, r15, true, "application/octet-stream;tt-data=b", false, r17, false, true);     // Catch: Throwable -> L31
    L17:
        r20 = true;
        r21 = r9;
        r22 = r10;
        r18 = r11;
    L31:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, CommonHttpException.class) == false) goto L39;
        int r3 = ((CommonHttpException) ZeusTransformUtils.preCheckCast(th, CommonHttpException.class, "com.obric.memorydata.plugin")).getResponseCode();
        if (r3 < 500) goto L39;
        if (r3 >= 600) goto L39;
        this.aY = System.currentTimeMillis();
    L39:
        Logger.w("AppLog", "updateConfig exception: " + th);
        goto L40
    }

    static /* synthetic */ AppLog g(AppLog r0) {
        ag = r0;
        return r0;
    }

    private void g(String r3) {
        if (this.t == null) goto L14;
        if (TextUtils.isEmpty(r3) == false) goto L8;
        this.am.remove(Api.KEY_USER_UNIQUE_ID);     // Catch: Exception -> L11
    L9:
        JSONObject r4 = new JSONObject(this.am, com.ss.android.common.applog.c.f15072b);     // Catch: Exception -> L11
        this.t.b(r4);     // Catch: Exception -> L11
        return;
    L8:
        this.am.put(Api.KEY_USER_UNIQUE_ID, r3);     // Catch: Exception -> L11
    L15:
        return;
    }

    static String[] g() {
        return ae.f;
    }

    public static int h() {
        return com.ss.android.deviceregister.f.j();
    }

    static /* synthetic */ JSONObject h(AppLog r0) {
        return r0.aA;
    }

    public static String i() {
        return X.a();
    }

    @Deprecated
    public static String j() {
        return X.b();
    }

    static boolean k() {
        h r0 = n;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.a();
    }

    static boolean l() {
        h r0 = n;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.b();
    }

    static boolean m() {
        h r0 = n;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.c();
    }

    public static String n() {
        return X.c();
    }

    static void s() {
        AppLog r0 = ag;
        if (r0 == null) goto L6;
        r0.aU.set(0);
        r0.aV.set(0);
        return;
    }

    static long t() {
        AppLog r0 = ag;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.aU.getAndIncrement();
    }

    public static JSONObject u() {
        return X.d();
    }

    public static String v() {
        return UUID.randomUUID().toString();
    }

    public static String y() {
        return X.f();
    }

    public static com.service.middleware.applog.a z() {
        return X.g();
    }

    void a(long r9, boolean r11) {
        com.ss.android.common.applog.d r0 = com.ss.android.common.applog.d.a(this.al);
        w r1 = this.au;
        if (r1 != null) goto L5;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L18;
        if (r11 == true) goto L39;
        this.au.k = true;
        this.au.h = r9;
        return;
    L39:
        return;
    L18:
        r();
        w r3 = this.au;
        w r4 = new w();
        r4.f15107b = v();
        r4.c = r9;
        s();
        r4.d = this.aU.getAndIncrement();
        r4.h = r4.c;
        r4.e = 0;
        r4.f = com.ss.android.deviceregister.a.u.e();
        r4.g = com.ss.android.deviceregister.a.u.c();
        r4.i = r11;
        if (r11 == true) goto L21;
        r4.k = true;
    L21:
        long r5 = r0.a(r4);
        if (r5 <= 0) goto L24;
        r4.f15106a = r5;
        this.au = r4;
        Logger.i("AppLog", "start new session " + r4.f15107b);
        d(r5);
    L25:
        if (r3 == null) goto L27;
    L28:
        u r6 = new u();
        r6.f15102a = r3;
        if (v > 0) goto L31;
        v = 6;
    L31:
        w r7 = this.au;
        if (r7 != null) goto L34;
    L36:
        a(r6);
    L37:
        m.a().a(String.valueOf(r5), r9, r11);
        return;
    L34:
        if (r7.i == true) goto L36;
        r6.f15103b = this.au;
        goto L36
    L27:
        if (this.au == null) goto L37;
    L24:
        this.au = null;
        goto L25
    L5:
        if (r1.k == true) goto L9;
        if ((r9 - this.au.h) >= this.av) goto L13;
    L9:
        if (this.au.i == false) goto L12;
        if (r11 == false) goto L13;
    L12:
        r2 = false;
        goto L14
    }

    void a(a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        LinkedList<a> r0 = this.r;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (f == false) goto L12;
        a(r5, MonitorState.f_stop);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L12:
        if (this.r.size() < 2000) goto L14;
        a((a) ZeusTransformUtils.preCheckCast(this.r.poll(), a.class, "com.obric.memorydata.plugin"), MonitorState.f_overflow);     // Catch: Throwable -> L17
    L14:
        this.r.add(r5);     // Catch: Throwable -> L17
        this.r.notify();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    void a(j r3) {
        if (this.aE.size() < 5) goto L5;
        this.aE.removeFirst();
    L5:
        this.aE.add(r3);
    }

    void a(o r5) {
        b(r5);
        a(r5.l, true);
        if (this.au != null) goto L7;
        x.a(1, 4, null);
        com.ss.android.common.applog.b.a(r5.f15095b, MonitorState.f_no_session);
        return;
    L7:
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r5.f15095b) == false) goto L9;
        AtomicLong r0 = this.aU;
    L10:
        r5.q = r0.getAndIncrement();
        r5.m = this.au.f15106a;
        if (c(r5) == false) goto L13;
        return;
    L13:
        long r1 = com.ss.android.common.applog.d.a(this.al).a(r5);
        if (r1 <= 0) goto L16;
        r5.f15094a = r1;
        o();
    L16:
        if (r1 >= 0) goto L19;
        com.ss.android.common.applog.b.a(r5.f15095b, MonitorState.f_db_insert);
        return;
    L19:
        return;
    L9:
        r0 = this.aV;
        goto L10
    }

    void a(q r7, long r8) {
        w r0 = this.au;
        if (r0 != null) goto L8;
        StringBuilder r6 = new StringBuilder();
        String r9 = "no session when onPause: ";
    L5:
        Logger.w("AppLog", r6.append(r9).append(r7.f15098a).toString());
        return;
    L8:
        if (r0.i == false) goto L10;
        r6 = new StringBuilder();
        r9 = "non-page session when onPause: ";
        goto L5
    L10:
        this.au.k = false;
        this.au.h = r8;
        r7.c = this.au.f15106a;
        com.ss.android.common.applog.d.a(this.al).a(r7, r8);
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L20
        int r11 = this.aC.get();     // Catch: Exception -> L20
        int r12 = this.aD.get();     // Catch: Exception -> L20
        r10.put("session_id", this.au.f15107b);     // Catch: Exception -> L20
        r10.put("cnt_success", r11);     // Catch: Exception -> L20
        r10.put("cnt_failure", r12);     // Catch: Exception -> L20
        JSONArray r13 = new JSONArray();     // Catch: Exception -> L20
        Iterator<j> r14 = this.aE.iterator();     // Catch: Exception -> L20
    L13:
        if (r14.hasNext() == false) goto L16;
        j r1 = (j) ZeusTransformUtils.preCheckCast(r14.next(), j.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L20
        r2.put("url", r1.f15039a);     // Catch: Exception -> L20
        r2.put("networktype", r1.f15040b);     // Catch: Exception -> L20
        r2.put(OaidModel.KEY_TIME, r1.c);     // Catch: Exception -> L20
        r2.put("timestamp", r1.d);     // Catch: Exception -> L20
        r13.put(r2);     // Catch: Exception -> L20
        goto L13
    L16:
        if (r13.length() <= 0) goto L18;
        r10.put("samples", r13);     // Catch: Exception -> L20
    L18:
        SharedPreferences.Editor r15 = this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit();     // Catch: Exception -> L20
        r15.putString("stats_value", r10.toString());     // Catch: Exception -> L20
        r15.commit();     // Catch: Exception -> L20
        return;
    }

    void a(s r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.aF = System.currentTimeMillis();
        LinkedList<s> r0 = this.s;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.s.size() >= 2000) goto L9;
    L11:
        this.s.add(r5);     // Catch: Throwable -> L14
        this.s.notify();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L9:
        if (((s) ZeusTransformUtils.preCheckCast(this.s.poll(), s.class, "com.obric.memorydata.plugin")) == null) goto L11;
        com.ss.android.common.applog.b.a(MonitorKey.pack, MonitorState.f_log_overflow);     // Catch: Throwable -> L14
        goto L11
    }

    void a(w r13) {
        this.aE.clear();     // Catch: Exception -> L42
        int r3 = 0;
        SharedPreferences r1 = this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0);     // Catch: Exception -> L42
        long r4 = r1.getLong("session_interval", 30000);     // Catch: Exception -> L42
        if (r4 >= SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME) goto L6;
    L8:
        this.aw = r1.getLong("batch_event_interval", 60000);     // Catch: Exception -> L42
        if (c(bf) == false) goto L13;
        long r5 = this.aw;     // Catch: Exception -> L42
        long r6 = bf;     // Catch: Exception -> L42
        if (r5 == r6) goto L13;
        this.aw = r6;     // Catch: Exception -> L42
    L13:
        this.ay = r1.getInt("send_launch_timely", 1);     // Catch: Exception -> L42
        this.ax = r1.getLong("fetch_interval", 21600000);     // Catch: Exception -> L42
        this.az = r1.getInt("http_monitor_port", 0);     // Catch: Exception -> L42
        com.ss.android.deviceregister.b.e.f15186a = r1.getBoolean("device_register_throttle", false);     // Catch: Exception -> L42
        if (r13 != null) goto L16;
        return;
    L16:
        String r2 = r1.getString("stats_value", null);     // Catch: Exception -> L42
        if (com.bytedance.common.utility.h.a(r2) == false) goto L19;
        return;
    L19:
        JSONObject r7 = new JSONObject(r2);     // Catch: Exception -> L42
        String r8 = r7.optString("session_id", null);     // Catch: Exception -> L42
        if (r8 != null) goto L22;
        return;
    L22:
        if (r8.equals(r13.f15107b) == false) goto L49;
        int r14 = r7.optInt("cnt_success", 0);     // Catch: Exception -> L42
        int r9 = r7.optInt("cnt_failure", 0);     // Catch: Exception -> L42
        if (r14 <= 0) goto L27;
        this.aC.addAndGet(r14);     // Catch: Exception -> L42
    L27:
        if (r9 <= 0) goto L30;
        this.aD.addAndGet(r9);     // Catch: Exception -> L42
    L30:
        if (r7.isNull("samples") == false) goto L32;
        return;
    L32:
        JSONArray r15 = r7.getJSONArray("samples");     // Catch: Exception -> L42
        int r0 = r15.length();     // Catch: Exception -> L42
        if (r0 <= 5) goto L35;
        r0 = 5;
    L35:
        if (r3 >= r0) goto L51;
        JSONObject r10 = r15.getJSONObject(r3);     // Catch: Exception -> L42
        String r11 = r10.optString("url", null);     // Catch: Exception -> L42
        int r12 = r10.getInt("networktype");     // Catch: Exception -> L42
        long r16 = r10.getLong(OaidModel.KEY_TIME);     // Catch: Exception -> L42
        long r17 = r10.getLong("timestamp");     // Catch: Exception -> L42
        if (com.bytedance.common.utility.h.a(r11) == true) goto L40;
        this.aE.add(new j(r11, r12, r16, r17));     // Catch: Exception -> L42
    L40:
        r3 = r3 + 1;
        goto L35
    L51:
        return;
    L49:
        return;
    L6:
        if (r4 > 300000) goto L8;
        this.av = r4;     // Catch: Exception -> L42
    }

    void a(String r20, String r21, String r22, long r23, long r25, boolean r27, JSONObject r28) {
        JSONObject r0 = r28;
        if (this.q == true) goto L153;
        x.a(1, 3, null);
        com.ss.android.common.applog.b.a(r20, MonitorState.f_not_init);
        return;
    L153:
        if (m() == false) goto L35;
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r20) == false) goto L22;
        ConcurrentHashMap<String, String> r15 = this.aQ;     // Catch: Throwable -> L145
        if (r15 == null) goto L35;
        if (r15.size() <= 0) goto L35;
        if (com.bytedance.common.utility.h.a(r21) == true) goto L35;
        if (this.aQ.containsKey(r21) == false) goto L35;
        Logger.d("AppLog", "hit block event v3");     // Catch: Throwable -> L145
        x.a(1, 2, null);     // Catch: Throwable -> L145
        com.ss.android.common.applog.b.a(r20, MonitorState.f_filter);     // Catch: Throwable -> L145
        return;
    L22:
        ConcurrentHashMap<String, String> r16 = this.aP;     // Catch: Throwable -> L145
        if (r16 == null) goto L35;
        if (r16.size() <= 0) goto L35;
        if (com.bytedance.common.utility.h.a(r22) == true) goto L29;
        String r17 = r21 + r22;     // Catch: Throwable -> L145
    L31:
        if (this.aP.containsKey(r17) == false) goto L35;
        Logger.d("AppLog", "hit block event v1");     // Catch: Throwable -> L145
        x.a(1, 2, null);     // Catch: Throwable -> L145
        com.ss.android.common.applog.b.a(r20, MonitorState.f_filter);     // Catch: Throwable -> L145
        return;
    L29:
        r17 = r21;
    L35:
        if (K > 0) goto L37;
    L44:
        com.ss.android.common.applog.a.a r11 = M;     // Catch: Throwable -> L145
        if (r11 == null) goto L50;
        if (r11.a(r21, r0) == true) goto L50;
        return;
    L50:
        if (N == false) goto L59;
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r20) == false) goto L59;
        com.bytedance.applog.sampling.c r12 = f15027a;     // Catch: Throwable -> L145
        if (r12 == null) goto L59;
        if (r12.isHitSamplingDrop(p(), r21, r0) == false) goto L59;
        com.ss.android.common.applog.b.a(MonitorKey.event_v3, MonitorState.f_sampling);     // Catch: Throwable -> L145
        return;
    L37:
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equalsIgnoreCase(r20) == false) goto L44;
        com.ss.android.common.applog.a.a r13 = L;     // Catch: Throwable -> L145
        if (r13 == null) goto L44;
        if (r13.a(r21, r0) == true) goto L44;
        com.ss.android.common.applog.b.a(r20, MonitorState.f_filter);     // Catch: Throwable -> L145
        return;
    L59:
        o r18 = new o();
        r18.f15095b = r20;
        r18.c = r21;
        r18.d = r22;
        r18.e = r23;
        r18.f = r25;
        NetworkUtils.NetworkType r14 = this.aj.a();
        if (r14 == null) goto L64;
        if (r0 != null) goto L151;
        r0 = new JSONObject();
    L151:
        r0.put("nt", r14.getValue());     // Catch: Exception -> L146
    L64:
        JSONObject r19 = r0;
        long r110 = g.get();
        IBDAccountCallback r1 = bi;
        if (bh == false) goto L74;
        if (r1 == null) goto L74;
        Pair<Integer, Long> r2 = r1.getOdinUserInfo();
        if (((Long) ZeusTransformUtils.preCheckCast(r2.second, Long.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L71;
        o r3 = r18;
        r3.h = ((Long) ZeusTransformUtils.preCheckCast(r2.second, Long.class, "com.obric.memorydata.plugin")).longValue();
        r3.j = 1;
        r3.k = 1;
        r3.g = ((Integer) ZeusTransformUtils.preCheckCast(r2.first, Integer.class, "com.obric.memorydata.plugin")).intValue();
        long r111 = ((Long) ZeusTransformUtils.preCheckCast(r2.second, Long.class, "com.obric.memorydata.plugin")).longValue();
    L70:
        r3.i = r111;
    L76:
        if (bj == false) goto L86;
        if (r19 == null) goto L86;
        String r4 = z;
        f r112 = be;
        if (r112 == null) goto L155;
        r4 = r112.a(String.valueOf(r3.h));
    L155:
        if (TextUtils.isEmpty(r4) == true) goto L85;
        r19.put("ab_sdk_version", r4);     // Catch: JSONException -> L147
    L154:
        goto L86
    L85:
        r19.remove("ab_sdk_version");     // Catch: JSONException -> L147
    L86:
        if (r19 != null) goto L88;
    L94:
        r3.l = System.currentTimeMillis();
    L96:
        if (r19 == null) goto L121;
        com.ss.android.common.a r5 = aK;
        if (r5 != null) goto L100;
    L102:
        boolean r113 = false;
    L159:
        r3.n = r19.toString();     // Catch: StackOverflowError -> L105 ConcurrentModificationException -> L112
    L105:
        e = e;
        String r114 = "ext json toString stack overflow tag: ";
        if (r113 == true) goto L111;
        StringBuilder r115 = new StringBuilder();
    L109:
        com.ss.android.common.b.b.d(r115.append(r114).append(r21).append(", label: ").append(r22).toString(), e);
        goto L121
    L111:
        throw new RuntimeException("ext json toString stack overflow tag: " + r21 + ", label: " + r22, e);
    L112:
        r3.n = r19.toString();     // Catch: Throwable -> L114
    L114:
        e = th;
        r114 = "ext json exception tag: ";
        if (r113 == true) goto L119;
        r115 = new StringBuilder();
        goto L109
    L119:
        throw new RuntimeException("ext json exception tag: " + r21 + ", label: " + r22, e);
    L100:
        if ("local_test".equalsIgnoreCase(r5.c()) == false) goto L102;
        r113 = true;
    L121:
        if (r3.n != null) goto L123;
    L125:
        r3.o = r27;
        r3.p = false;
        if (Logger.debug() == false) goto L149;
        StringBuilder r6 = new StringBuilder();
        r6.append("onEvent ").append(r20).append(" ").append(r21).append(" ").append(r22);
        if (r23 == 0) goto L130;
    L132:
        r6.append(" ").append(r23);
    L134:
        if (r25 != 0) goto L136;
        if (r19 != null) goto L136;
    L137:
        if (r19 == null) goto L139;
        r6.append(" ").append(r19);
    L139:
        Logger.v("AppLog", r6.toString());
    L136:
        r6.append(" ").append(r25);
        goto L137
    L130:
        if (r25 != 0) goto L132;
        if (r19 == null) goto L134;
    L149:
        if (com.ss.android.common.applog.f.a().b() == false) goto L143;
        com.ss.android.common.applog.f.a().a(r20, r21, r22, r23, r25, r3.h, r3.l, r19);     // Catch: Exception -> L148
    L143:
        a r7 = new a(ActionQueueType.EVENT);
        r7.f15036b = r3;
        a(r7);
        return;
    L123:
        if (r3.n.length() <= 50000) goto L125;
        x.a(5, 0, new Object[]{r20, r21, r22, Integer.valueOf(r3.n.length())});
        com.ss.android.common.applog.b.a(r20, MonitorState.f_log_size_limit);
        goto L125
    L88:
        if (r19.has(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP) == false) goto L94;
        r3.l = r19.getLong(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);     // Catch: Throwable -> L91
    L93:
        r19.remove(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);
    L91:
        th = move-exception;
        th.printStackTrace();
        r3.l = System.currentTimeMillis();
        goto L93
    L71:
        r3 = r18;
        if (j != 0) goto L76;
        r3.j = j;
        r3.k = k;
        r3.g = i;
        r111 = h;
    L74:
        r3 = r18;
        r3.h = r110;
        goto L76
    }

    void a(String r8, JSONObject r9) {
        w r0 = this.au;     // Catch: Exception -> L28
        if (r0 == null) goto L5;
        long r3 = r0.f15106a;     // Catch: Exception -> L28
    L7:
        if (this.q == false) goto L23;
        if (r3 <= 0) goto L23;
        if (com.bytedance.common.utility.h.a(r8) == true) goto L23;
        if (r9 == null) goto L23;
        String r10 = r9.toString();     // Catch: Exception -> L28
        long r4 = com.ss.android.common.applog.d.a(this.al).a(r3, r8, r10);     // Catch: Exception -> L28
        if (r10 == null) goto L19;
        if (r10.length() <= 50000) goto L19;
        x.a(5, 0, new Object[]{"misc", r8, "", Integer.valueOf(r10.length())});     // Catch: Exception -> L28
        com.ss.android.common.applog.b.a(MonitorKey.log_data, MonitorState.f_log_size_limit);     // Catch: Exception -> L28
    L19:
        if (r4 >= 0) goto L27;
        MonitorKey r7 = MonitorKey.log_data;     // Catch: Exception -> L28
        MonitorState r11 = MonitorState.f_db_insert;     // Catch: Exception -> L28
    L21:
        com.ss.android.common.applog.b.a(r7, r11);     // Catch: Exception -> L28
        return;
    L27:
        return;
    L23:
        if (this.q == true) goto L25;
        r7 = MonitorKey.log_data;     // Catch: Exception -> L28
        r11 = MonitorState.f_not_init;     // Catch: Exception -> L28
        goto L21
    L25:
        r7 = MonitorKey.log_data;     // Catch: Exception -> L28
        r11 = MonitorState.f_block;     // Catch: Exception -> L28
        goto L21
    L5:
        r3 = 0;
    }

    void a(HashSet<Integer> r3, JSONArray r4) {
        if (r3 == null) goto L11;
        if (r4 == null) goto L15;
        r3.clear();
        int r2 = r4.length();
        int r0 = 0;
    L6:
        if (r0 >= r2) goto L16;
        int r1 = r4.getInt(r0);
        if (r1 <= 0) goto L10;
        r3.add(Integer.valueOf(r1));
    L10:
        r0 = r0 + 1;
        goto L6
    L16:
        return;
    L15:
        return;
    }

    void a(JSONObject r14, boolean r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        this.aG = System.currentTimeMillis();
        this.E = this.ai;
        long r4 = r14.optLong("server_time");     // Catch: Exception -> L121
        if (r4 <= 0) goto L10;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L121
        r6.put("server_time", r4);     // Catch: Exception -> L121
        r6.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L121
        this.aA = r6;     // Catch: Exception -> L121
        if (this.t == null) goto L10;
        this.t.a(this.aA);     // Catch: Exception -> L121
    L10:
        JSONObject r16 = r14.optJSONObject("config");
        if (r16 != null) goto L13;
        r16 = new JSONObject();
    L13:
        String r5 = null;
        JSONArray r7 = r16.optJSONArray("allow_push_list");     // Catch: Exception -> L122
        if (r7 == null) goto L25;
        Object r8 = af;     // Catch: Exception -> L122
        monitor-enter(r8);     // Catch: Exception -> L122
        a(this.aq, r7);     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        r5 = r7.toString();     // Catch: Exception -> L122
        this.ar = r5;     // Catch: Exception -> L122
        goto L25
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L122
    L25:
        boolean r9 = a(r16, "allow_old_image_sample", false);
        if (r9 == this.as) goto L28;
        this.as = r9;
        boolean r10 = true;
    L29:
        long r0 = r16.optLong("session_interval", 0);
        if (r0 >= 15) goto L32;
    L36:
        boolean r1 = false;
    L37:
        long r11 = r16.optLong("batch_event_interval", 60) * 1000;
        if (c(r11) == true) goto L40;
    L49:
        long r12 = r16.optLong("fetch_interval", 21600) * 1000;
        if (r12 >= 1800000) goto L52;
    L53:
        r12 = 21600000;
    L55:
        if (r12 == this.ax) goto L57;
        this.ax = r12;
        r1 = true;
    L57:
        int r2 = r16.optInt("send_launch_timely");
        if (r2 == this.ay) goto L63;
        this.ay = r2;
        if (this.t == null) goto L62;
        this.t.a(this.ay);
    L62:
        r1 = true;
    L63:
        int r3 = r16.optInt("http_monitor_port");
        if (r3 > 0) goto L66;
    L68:
        boolean r13 = false;
    L70:
        if (r16.optInt("device_register_throttle", 0) == 0) goto L72;
        boolean r17 = true;
    L73:
        Logger.d("AppLog", "get_deviceRegisterThrottle: " + r17);
        if (r17 == com.ss.android.deviceregister.b.e.f15186a) goto L76;
        Logger.d("AppLog", "change_deviceRegisterThrottle: " + com.ss.android.deviceregister.b.e.f15186a);
        com.ss.android.deviceregister.b.e.f15186a = r17;
        boolean r18 = true;
    L78:
        if (K <= 0) goto L80;
        L = com.ss.android.common.applog.a.a.a(this.al, r16);
    L80:
        int r19 = r16.optInt("forbid_report_phone_detail_info", -1);
        SharedPreferences.Editor r20 = this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit();
        if (r19 < 0) goto L89;
        r20.putInt("forbid_report_phone_detail_info", r19);
        if (r19 <= 0) goto L85;
        boolean r21 = true;
    L86:
        this.F = r21;
        com.ss.android.deviceregister.f.b(r21);
        com.ss.android.deviceregister.a.u.a(this.am);
        X();
        if (this.t == null) goto L89;
        this.t.a();
        goto L89
    L85:
        r21 = false;
    L89:
        if (r1 == false) goto L91;
        r20.putLong("session_interval", this.av);
        r20.putLong("batch_event_interval", this.aw);
        r20.putLong("fetch_interval", this.ax);
        r20.putInt("send_launch_timely", this.ay);
    L91:
        if (r5 == null) goto L93;
        r20.putString("allow_push_list", r5);
    L93:
        if (r10 == false) goto L95;
        r20.putBoolean("allow_old_image_sample", this.as);
    L95:
        if (r13 == false) goto L97;
        r20.putInt("http_monitor_port", this.az);
    L97:
        if (r18 == false) goto L99;
        Logger.d("AppLog", "save_deviceRegisterThrottle: " + r17);
        r20.putBoolean("device_register_throttle", r17);
    L99:
        r20.putLong("app_log_last_config_time", this.aG);
        r20.putInt("app_log_last_config_version", this.E);
        JSONArray r22 = r16.optJSONArray("real_time_events");     // Catch: Throwable -> L113
        this.aR.clear();     // Catch: Throwable -> L113
        if (r22 != null) goto L103;
    L111:
        r20.remove("real_time_events");     // Catch: Throwable -> L113
    L115:
        r20.putInt("content_encode_method", r16.optInt("content_encode_method", 0));
        r20.apply();
        f(r16);
        Y();
        if (r15 == true) goto L118;
        return;
    L118:
        if (this.ap == true) goto L133;
        this.ap = true;
        a(true, true, false);
        return;
    L133:
        return;
    L103:
        if (r22.length() <= 0) goto L111;
        int r23 = r22.length();     // Catch: Throwable -> L113
        int r24 = 0;
    L105:
        if (r24 >= r23) goto L110;
        String r25 = r22.getString(r24);     // Catch: Throwable -> L113
        if (com.bytedance.common.utility.h.a(r25) == true) goto L109;
        this.aR.put(r25, "timely");     // Catch: Throwable -> L113
    L109:
        r24 = r24 + 1;     // Catch: Throwable -> L113
        goto L105
    L110:
        r20.putString("real_time_events", r22.toString());     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        th.printStackTrace();
        goto L115
    L76:
        r18 = false;
        goto L78
    L72:
        r17 = false;
        goto L73
    L66:
        if (r3 == this.az) goto L68;
        this.az = r3;
        r13 = true;
        goto L70
    L52:
        if (r12 <= 172800000) goto L55;
    L40:
        if (r11 == this.aw) goto L49;
        this.aw = r11;
        if (this.t == null) goto L48;
        v r26 = this.t;
        if (c(bf) == false) goto L46;
        long r27 = bf;
    L47:
        r26.a(r27);
        goto L48
    L46:
        r27 = this.aw;
    L48:
        r1 = true;
        goto L49
    L32:
        if (r0 > 300) goto L36;
        long r28 = r0 * 1000;
        if (r28 == this.av) goto L36;
        this.av = r28;
        r1 = true;
        goto L37
    L28:
        r10 = false;
        goto L29
    }

    void a(boolean r2, boolean r3) {
        a(r2, false, r3);
    }

    boolean a(String r9, boolean r10, long r11) {
        aX.set(Boolean.TRUE);
        boolean r12 = b(r9, r10);
        if (r12 == false) goto L8;
        long r0 = System.currentTimeMillis();
        if (T <= 0) goto L7;
        com.ss.android.common.applog.b.a(MonitorKey.config, MonitorState.total_success, r0 - T);
        T = 0;
    L7:
        com.ss.android.common.applog.b.a(MonitorKey.config, MonitorState.success, r0 - r11);
    L8:
        Object r13 = aW;
        monitor-enter(r13);
        this.aI = false;     // Catch: Throwable -> L18
        r13.notifyAll();     // Catch: Exception -> L21 Throwable -> L18
    L13:
        monitor-exit(r13);     // Catch: Throwable -> L18
        aX.remove();
        if (r12 == true) goto L17;
        b(false);
    L17:
        return r12;
    L18:
        th = move-exception;
        throw th;
    }

    void b(long r3) {
        SharedPreferences.Editor r2 = this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit();
        r2.putLong("dns_report_time", r3);
        r2.commit();
    }

    void b(a r10) {
        if (P == false) goto L16;
        if (Q == true) goto L16;
        if (ActionQueueType.PAGE_START != r10.f15035a) goto L9;
        return;
    L9:
        if (ActionQueueType.PAGE_END != r10.f15035a) goto L11;
        return;
    L11:
        if (ActionQueueType.EVENT != r10.f15035a) goto L13;
        return;
    L13:
        if (ActionQueueType.SAVE_MISC_LOG != r10.f15035a) goto L16;
        return;
    L16:
        if (this.q == true) goto L25;
        if (r10 != null) goto L19;
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, o.class) == false) goto L124;
        o r9 = (o) ZeusTransformUtils.preCheckCast(r10.f15036b, o.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L125;
        com.ss.android.common.applog.b.a(r9.f15095b, MonitorState.f_not_init);
        return;
    L125:
        return;
    L124:
        return;
    L25:
        if (f == false) goto L33;
        if (r10 != null) goto L28;
        return;
    L28:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, o.class) == false) goto L127;
        o r11 = (o) ZeusTransformUtils.preCheckCast(r10.f15036b, o.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L128;
        com.ss.android.common.applog.b.a(r11.f15095b, MonitorState.f_stop);
        return;
    L128:
        return;
    L127:
        return;
    L33:
        BlockHelper.tryBlock();
        String r2 = "";
        boolean r3 = true;
        boolean r6 = false;
        switch(AnonymousClass5.f15034a[r10.f15035a.ordinal()]) {
            case 1: goto L113;
            case 2: goto L106;
            case 3: goto L99;
            case 4: goto L95;
            case 5: goto L92;
            case 6: goto L157;
            case 7: goto L83;
            case 8: goto L80;
            case 9: goto L157;
            case 10: goto L77;
            case 11: goto L74;
            case 12: goto L71;
            case 13: goto L68;
            case 14: goto L65;
            case 15: goto L58;
            case 16: goto L46;
            case 17: goto L45;
            case 18: goto L44;
            case 19: goto L37;
            default: goto L157;
        };
    L44:
        g((String) ZeusTransformUtils.preCheckCast(r10.f15036b, String.class, "com.obric.memorydata.plugin"));
        return;
    L45:
        aa();
        return;
    L46:
        com.ss.android.deviceregister.q r0 = null;
        if (ZeusTransformUtils.instanceOf(r10.f15036b, Pair.class) == false) goto L49;
        r0 = (com.ss.android.deviceregister.q) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r10.f15036b, Pair.class, "com.obric.memorydata.plugin")).first, com.ss.android.deviceregister.q.class, "com.obric.memorydata.plugin");
        long r1 = ((Long) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r10.f15036b, Pair.class, "com.obric.memorydata.plugin")).second, Long.class, "com.obric.memorydata.plugin")).longValue();
    L51:
        if (r10.c > 0) goto L54;
        r3 = false;
    L54:
        a(r3, r1, r0);
        if (r10.e == null) goto L134;
    L63:
        r10.e.countDown();
        return;
    L134:
        return;
    L49:
        r1 = 0;
        goto L51
    L99:
        long r4 = r10.c;
        w r5 = this.au;
        if (r5 == null) goto L103;
        r2 = r5.f15107b;
    L103:
        com.ss.android.common.applog.b.c.a(this.al).b(r4, r2);
        if (ZeusTransformUtils.instanceOf(r10.f15036b, q.class) == false) goto L111;
        a((q) ZeusTransformUtils.preCheckCast((q) ZeusTransformUtils.preCheckCast(r10.f15036b, q.class, "com.obric.memorydata.plugin"), q.class, "com.obric.memorydata.plugin"), r10.c);
    L111:
        o();
        return;
    L106:
        a(r10.c, false);
        long r7 = r10.c;
        w r12 = this.au;
        if (r12 == null) goto L110;
        r2 = r12.f15107b;
    L110:
        com.ss.android.common.applog.b.c.a(this.al).a(r7, r2);
        goto L111
    L157:
        return;
    L37:
        if (this.t != null) goto L39;
        return;
    L39:
        if (this.t.isAlive() == true) goto L130;
        this.t.start();     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        Logger.e("AppLog", "delay start LogReaper", th);
        return;
    L130:
        return;
    L58:
        if (r10.c > 0) goto L61;
        r3 = false;
    L61:
        c(r3);
        if (r10.e != null) goto L63;
        return;
    L65:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, JSONObject.class) == false) goto L137;
        d((JSONObject) ZeusTransformUtils.preCheckCast(r10.f15036b, JSONObject.class, "com.obric.memorydata.plugin"));
        return;
    L137:
        return;
    L68:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, String.class) == false) goto L139;
        c((String) ZeusTransformUtils.preCheckCast(r10.f15036b, String.class, "com.obric.memorydata.plugin"));
        return;
    L139:
        return;
    L71:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, JSONObject.class) == false) goto L141;
        e((JSONObject) ZeusTransformUtils.preCheckCast(r10.f15036b, JSONObject.class, "com.obric.memorydata.plugin"));
        return;
    L141:
        return;
    L74:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, Bundle.class) == false) goto L143;
        a((Bundle) ZeusTransformUtils.preCheckCast(r10.f15036b, Bundle.class, "com.obric.memorydata.plugin"));
        return;
    L143:
        return;
    L77:
        if (r10.c <= 0) goto L145;
        b(r10.c);
        return;
    L145:
        return;
    L80:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, String.class) == false) goto L147;
        b((String) ZeusTransformUtils.preCheckCast(r10.f15036b, String.class, "com.obric.memorydata.plugin"));
        return;
    L147:
        return;
    L83:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, JSONObject.class) == true) goto L118;
    L90:
        b(true);
        return;
    L118:
        r6 = Boolean.valueOf(r10.d).booleanValue();     // Catch: Exception -> L87
    L89:
        a((JSONObject) ZeusTransformUtils.preCheckCast(r10.f15036b, JSONObject.class, "com.obric.memorydata.plugin"), r6);
    L87:
        e = move-exception;
        e.printStackTrace();
        goto L89
    L92:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, j.class) == false) goto L150;
        a((j) ZeusTransformUtils.preCheckCast(r10.f15036b, j.class, "com.obric.memorydata.plugin"));
        return;
    L150:
        return;
    L95:
        if (com.bytedance.common.utility.h.a(r10.d) == false) goto L97;
        return;
    L97:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, JSONObject.class) == false) goto L153;
        a(r10.d, (JSONObject) ZeusTransformUtils.preCheckCast(r10.f15036b, JSONObject.class, "com.obric.memorydata.plugin"));
        return;
    L153:
        return;
    L113:
        if (ZeusTransformUtils.instanceOf(r10.f15036b, o.class) == false) goto L156;
        a((o) ZeusTransformUtils.preCheckCast((o) ZeusTransformUtils.preCheckCast(r10.f15036b, o.class, "com.obric.memorydata.plugin"), o.class, "com.obric.memorydata.plugin"));
        return;
    }

    void b(String r1) {
        com.ss.android.deviceregister.f.b(this.al, r1);
    }

    boolean b(String r23, boolean r24) {
        JSONObject r0 = new JSONObject(r23);     // Catch: Throwable -> L66
        String[] r15 = b(r0, false);     // Catch: Throwable -> L66
        String r1 = r0.toString();     // Catch: Throwable -> L66
        Logger.d("AppLog", "app_log_config: " + r1);     // Catch: Throwable -> L66
        byte[] r16 = r1.getBytes(RpcUtils.CHARSET_UTF8);     // Catch: Throwable -> L66
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L66
        boolean r14 = true;
        if ((r5 - aO) >= 600000) goto L6;
        boolean r17 = true;
    L7:
        aO = r5;     // Catch: Throwable -> L66
        String r18 = null;
        boolean r2 = false;
        int r13 = 0;
    L9:
        if (r13 >= 2) goto L51;
        byte[] r7 = (byte[]) ZeusTransformUtils.preCheckCast(r16.clone(), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L66
        String r6 = e();     // Catch: Throwable -> L66
        if (r2 == false) goto L13;
        r6 = f();     // Catch: Throwable -> L66
    L13:
        String r3 = z.a(y.a(r6, r14), z.f15114b);     // Catch: Throwable -> L66
    L35:
        th = th;
        int r19 = r13;
        boolean r20 = r14;
    L37:
        if (r19 != 0) goto L40;
        com.ss.android.common.applog.b.a(MonitorKey.config, MonitorState.f_net);     // Catch: Throwable -> L66
    L40:
        if (ZeusTransformUtils.instanceOf(th, CommonHttpException.class) == false) goto L48;
        int r4 = ((CommonHttpException) ZeusTransformUtils.preCheckCast(th, CommonHttpException.class, "com.obric.memorydata.plugin")).getResponseCode();     // Catch: Throwable -> L66
        if (r4 < 500) goto L48;
        if (r4 >= 600) goto L48;
        this.aG = System.currentTimeMillis();     // Catch: Throwable -> L66
        this.E = this.ai;     // Catch: Throwable -> L66
        SharedPreferences.Editor r8 = this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit();     // Catch: Throwable -> L66
        r8.putLong("app_log_last_config_time", this.aG);     // Catch: Throwable -> L66
        r8.putInt("app_log_last_config_version", this.E);     // Catch: Throwable -> L66
        r8.commit();     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L48:
        if (r19 > 0) goto L50;
        r13 = r19 + 1;     // Catch: Throwable -> L66
        r2 = r20;
        r14 = r2;
        goto L9
    L50:
        throw th;     // Catch: Throwable -> L66
    L71:
        if (this.al == null) goto L28;
        if (k() == false) goto L28;
    L20:
        boolean r21 = r14;
        String r9 = y.a(K(), r3, r7, this.al, r17, r15, null, null, false, false);     // Catch: RuntimeException -> L69 Throwable -> L33
    L32:
        r18 = r9;
    L52:
        String r10 = r18;
        if (r10 != null) goto L55;
    L63:
        com.ss.android.common.applog.b.a(MonitorKey.config, MonitorState.f_resp_error);     // Catch: Throwable -> L66
        return false;
    L55:
        if (r10.length() == 0) goto L63;
        Logger.v("AppLog", "app_log_config response: " + r10);     // Catch: Throwable -> L66
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L66
        if (Api.MSG_MAGIC.equals(r11.optString(Api.KEY_MAGIC)) == true) goto L61;
        com.ss.android.common.applog.b.a(MonitorKey.config, MonitorState.f_resp_error);     // Catch: Throwable -> L66
        return false;
    L61:
        a r12 = new a(ActionQueueType.CONFIG_UPDATE);     // Catch: Throwable -> L66
        r12.f15036b = r11;     // Catch: Throwable -> L66
        r12.d = String.valueOf(r24);     // Catch: Throwable -> L66
        a(r12);     // Catch: Throwable -> L66
        return r21;
    L24:
        com.ss.android.common.applog.b.a(MonitorKey.config, MonitorState.f_to_bytes);     // Catch: Throwable -> L33
        if (r17 == false) goto L27;
        r3 = r3 + "&config_retry=b";     // Catch: Throwable -> L33
    L27:
        r9 = y.a(r3, r16, true, "application/octet-stream;tt-data=b", false, null, false, false);     // Catch: Throwable -> L33
    L23:
        r21 = r14;
    L28:
        r21 = r14;
        if (r17 == false) goto L31;
        r3 = r3 + "&config_retry=b";     // Catch: Throwable -> L33
    L31:
        r9 = y.a(r3, r16, true, "application/octet-stream;tt-data=b", false, null, false, false);     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L37
    L51:
        r21 = r14;
        goto L52
    L6:
        r17 = false;
    L66:
        th = move-exception;
        com.ss.android.common.applog.b.a(MonitorKey.config, MonitorState.f_exception);
        Logger.w("AppLog", "updateConfig exception: " + th);
        return false;
    }

    void o() {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.aF) <= 60000) goto L12;
        this.aF = r0;
        LinkedList<s> r1 = this.s;
        monitor-enter(r1);
        this.s.notify();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public com.bytedance.applog.sampling.j p() {
        com.bytedance.applog.sampling.j r5 = new com.bytedance.applog.sampling.j(String.valueOf(h()), j(), B());
        IBDAccountCallback r0 = bi;
        if (r0 == null) goto L11;
        Pair<Integer, Long> r1 = r0.getOdinUserInfo();
        if (((Long) ZeusTransformUtils.preCheckCast(r1.second, Long.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L9;
        r5.a(String.valueOf(r1.second));
        String r2 = String.valueOf(r1.first);
    L7:
        r5.b(r2);
    L12:
        return r5;
    L9:
        if (j != 0) goto L12;
        r5.a(String.valueOf(h));
        r2 = String.valueOf(i);
        goto L7
    L11:
        r5.a(String.valueOf(g.get()));
        goto L12
    }

    void q() {
        w r0 = this.au;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.i == true) goto L16;
        long r1 = System.currentTimeMillis();
        if (this.au.k == false) goto L10;
        return;
    L10:
        if ((r1 - this.au.h) < this.av) goto L17;
        w r2 = this.au;
        r();
        this.au = null;
        u r3 = new u();
        r3.f15102a = r2;
        a(r3);
        return;
    L17:
        return;
    }

    void r() {
        w r0 = this.au;
        if (r0 != null) goto L5;
        return;
    L5:
        com.ss.android.common.applog.d r1 = com.ss.android.common.applog.d.a(this.al);
        int r3 = 0;
        int r2 = this.aC.getAndSet(0);
        int r4 = this.aD.getAndSet(0);
        if (r0 != null) goto L8;
    L21:
        this.aE.clear();
        return;
    L8:
        if (r0.f15106a <= 0) goto L21;
        if (r2 > 0) goto L12;
        if (r4 > 0) goto L12;
    L14:
        if (this.as == true) goto L16;
        this.aE.clear();
    L16:
        Iterator<j> r5 = this.aE.iterator();
    L18:
        if (r5.hasNext() == false) goto L21;
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5.next(), j.class, "com.obric.memorydata.plugin");
        o r7 = new o();
        r7.f15095b = "image";
        r7.c = "sample";
        r7.d = r6.f15039a;
        r7.e = r6.f15040b;
        r7.f = r6.c;
        r7.l = r6.d;
        r7.m = r0.f15106a;
        r1.a(r7);
        r3 = r3 + 1;
        if (r3 < 5) goto L18;
    L12:
        o r8 = new o();
        r8.f15095b = "image";
        r8.c = "stats";
        r8.e = r2;
        r8.f = r4;
        r8.l = r0.h;
        r8.m = r0.f15106a;
        r1.a(r8);
        goto L14
    }

    void w() {
        com.ss.android.common.a r0 = aK;     // Catch: Exception -> L39
        if (r0 == null) goto L5;
        this.ai = r0.e();     // Catch: Exception -> L39
    L5:
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L39
        int r4 = 0;
        SharedPreferences r2 = this.al.getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0);     // Catch: Exception -> L39
        int r3 = r2.getInt("app_log_last_config_version", 0);     // Catch: Exception -> L39
        this.E = r3;     // Catch: Exception -> L39
        if (r3 != this.ai) goto L43;
        long r5 = r2.getLong("app_log_last_config_time", 0);     // Catch: Exception -> L39
        if (r5 > r1) goto L11;
        r1 = r5;
    L11:
        this.aG = r1;     // Catch: Exception -> L39
    L43:
        String r6 = r2.getString("allow_push_list", null);     // Catch: Exception -> L23
        this.ar = r6;     // Catch: Exception -> L23
        if (r6 == null) goto L25;
        Object r7 = af;     // Catch: Exception -> L23
        monitor-enter(r7);     // Catch: Exception -> L23
        a(this.aq, new JSONArray(r6));     // Catch: Throwable -> L20
        monitor-exit(r7);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L23
    L25:
        this.as = r2.getBoolean("allow_old_image_sample", false);     // Catch: Exception -> L39
        String r8 = r2.getString("real_time_events", null);     // Catch: Throwable -> L36
        if (com.bytedance.common.utility.h.a(r8) == true) goto L49;
        JSONArray r9 = new JSONArray(r8);     // Catch: Throwable -> L36
        if (r9.length() <= 0) goto L50;
        int r10 = r9.length();     // Catch: Throwable -> L36
    L31:
        if (r4 >= r10) goto L52;
        String r11 = r9.getString(r4);     // Catch: Throwable -> L36
        if (com.bytedance.common.utility.h.a(r11) == true) goto L35;
        this.aR.put(r11, "timely");     // Catch: Throwable -> L36
    L35:
        r4 = r4 + 1;
        goto L31
    L52:
        return;
    L50:
        return;
    L49:
        return;
    L36:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L39
        return;
    L23:
        e = move-exception;
        Logger.w("AppLog", "load allow_push_list exception: " + e);     // Catch: Exception -> L39
    }

    public JSONObject x() {
        return X.e();
    }
}
