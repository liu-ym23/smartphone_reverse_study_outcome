package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.util.f;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTHttpCallPriorityControl implements s4.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile TTHttpCallPriorityControl f2865e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f2866f = "TTHttpCallPriorityControl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f2867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, a> f2868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f2869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReadWriteLock f2870d;

    public static final enum ModeType extends Enum<ModeType> {
        private static final /* synthetic */ ModeType[] $VALUES = null;
        public static final ModeType DEFAULT = null;
        public static final ModeType NORMAL_DELAY = null;
        public static final ModeType NOT_REACHED = null;
        public static final ModeType PRIORITY = null;
        public static final ModeType RUNTIME_DELAY = null;
        private final int value;

        static {
            ModeType r10 = new ModeType("DEFAULT", 0, 0);
            DEFAULT = r10;
            ModeType r11 = new ModeType("NORMAL_DELAY", 1, 1);
            NORMAL_DELAY = r11;
            ModeType r12 = new ModeType("RUNTIME_DELAY", 2, 2);
            RUNTIME_DELAY = r12;
            ModeType r13 = new ModeType("PRIORITY", 3, 3);
            PRIORITY = r13;
            ModeType r14 = new ModeType("NOT_REACHED", 4, 4);
            NOT_REACHED = r14;
            $VALUES = new ModeType[]{r10, r11, r12, r13, r14};
        }

        private ModeType(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static ModeType fromValue(int r10) {
            ModeType[] r11 = values();
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            ModeType r14 = r11[r13];
            if (r14.getValue() == r10) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            throw new IllegalArgumentException("Invalid value: " + r10);
        }

        public static ModeType valueOf(String r10) {
            return (ModeType) Enum.valueOf(ModeType.class, r10);
        }

        public static ModeType[] values() {
            return (ModeType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static abstract class a implements s4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final d5.a f2871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f2872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Date f2873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f2874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2875e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected long f2876f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private j2.a f2877g;

        /* JADX INFO: renamed from: com.bytedance.ttnet.priority.TTHttpCallPriorityControl$a$a, reason: collision with other inner class name */
        class C0074a extends j2.a {
            C0074a(a r10, long r11, long r12) {
                super(r11, r12);
            }

            @Override // java.lang.Runnable
            public void run() {
                TTHttpCallPriorityControl.h().m();
            }
        }

        public a() {
            this.f2871a = new d5.a();
            this.f2872b = "";
            this.f2873c = null;
            this.f2874d = null;
            this.f2875e = true;
            this.f2876f = 1000;
            this.f2877g = null;
        }

        static /* synthetic */ boolean e(a r10) {
            return r10.h();
        }

        private void f(JSONObject r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            String r11 = r10.optString("lifecycle");
            if ("".equals(r11) == false) goto L7;
            return;
        L7:
            ArrayList r12 = new ArrayList();
            if (f.c(r11, r12) == false) goto L17;
            if (r12.size() != 2) goto L17;
            this.f2875e = true;
            this.f2873c = (Date) r12.get(0);
            this.f2874d = (Date) r12.get(1);
            if (Logger.debug() == false) goto L21;
            Logger.d(TTHttpCallPriorityControl.e(), "initLifecycle, stateName: " + this.f2872b + ", beginTime: " + this.f2873c.toString() + ", endTime: " + this.f2874d.toString());
            return;
        L21:
            return;
        L17:
            if (Logger.debug() == false) goto L19;
            Logger.d(TTHttpCallPriorityControl.e(), "initLifecycle, parse lifecycle failed");
        L19:
            this.f2875e = false;
        }

        private boolean h() {
            if (Logger.debug() == false) goto L6;
            Logger.d(TTHttpCallPriorityControl.e(), "isInLifecycle, stateName: " + this.f2872b + ", beginTime: " + this.f2873c + ", endTime: " + this.f2874d);
        L6:
            if (this.f2875e == true) goto L9;
            return false;
        L9:
            if (this.f2873c != null) goto L11;
        L19:
            return true;
        L11:
            if (this.f2874d == null) goto L19;
            Date r10 = new Date();
            if (r10.after(this.f2873c) == true) goto L16;
            return false;
        L16:
            if (r10.before(this.f2874d) == true) goto L18;
            return false;
        L18:
            return true;
        }

        @Override // s4.b
        public void b(n4.c r10) {
            this.f2871a.e(r10);
        }

        boolean g(JSONObject r10) {
            String r11 = r10.optString("state_name", "");
            this.f2872b = r11;
            if (TextUtils.isEmpty(r11) == false) goto L6;
            return false;
        L6:
            r10.optInt("state", -1);
            long r12 = r10.optInt("delay_disable_time_ms", 1000);
            this.f2876f = r12;
            if (r12 > 0) goto L9;
            r12 = 1000;
        L9:
            this.f2876f = r12;
            f(r10);
            return true;
        }

        public void i() {
            this.f2877g = new C0074a(this, this.f2876f, 0);
            j2.b.d(NetworkAsyncTaskType.NETWORK).e(this.f2877g);
        }

        void j() {
            if (this.f2877g == null) goto L6;
            j2.b.d(NetworkAsyncTaskType.NETWORK).f(this.f2877g);
            return;
        }

        abstract ModeType k();
    }

    static {
    }

    public TTHttpCallPriorityControl() {
        this.f2867a = new AtomicBoolean(false);
        this.f2868b = new ConcurrentHashMap();
        this.f2869c = new com.bytedance.ttnet.priority.a();
        this.f2870d = new ReentrantReadWriteLock();
    }

    static /* synthetic */ String e() {
        return f2866f;
    }

    private boolean f(n4.c r10, RetrofitMetrics r11) {
        if (r10 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r10.A()) == true) goto L15;
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r10.z() != null) goto L14;
        r10.S(r11);
        return true;
    L14:
        return true;
    L15:
        return false;
    }

    public static TTHttpCallPriorityControl h() {
        if (f2865e != null) goto L15;
        monitor-enter(TTHttpCallThrottleControl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2865e != null) goto L9;
        f2865e = new TTHttpCallPriorityControl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTHttpCallThrottleControl.class);     // Catch: Throwable -> L11
    L15:
        return f2865e;
    }

    public static Integer i(Map<String, Integer> r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        Iterator<String> r12 = r10.keySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        String r13 = r12.next();
        if (r11.startsWith(r13) == false) goto L7;
        return r10.get(r13);
    L12:
        return null;
    }

    public static Set<String> j(JSONObject r10, String r11) {
        CopyOnWriteArraySet r12 = new CopyOnWriteArraySet();
        if (r10 != null) goto L5;
        return r12;
    L5:
        JSONArray r13 = r10.optJSONArray(r11);
        if (r13 != null) goto L8;
        return r12;
    L8:
        int r14 = 0;
    L10:
        if (r14 >= r13.length()) goto L15;
        String r15 = r13.optString(r14);
        if (TextUtils.isEmpty(r15) == true) goto L14;
        r12.add(r15);
    L14:
        r14 = r14 + 1;
        goto L10
    L15:
        return r12;
    }

    public static boolean k(Set<String> r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return false;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        Iterator<String> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        if (r11.startsWith(r12.next()) == false) goto L9;
        return true;
    L14:
        return false;
    }

    private void n(a r10) {
        if (r10 != null) goto L4;
    L6:
        if (r10 != null) goto L8;
    L10:
        this.f2870d.writeLock().lock();
        this.f2869c.j();     // Catch: Throwable -> L19
        if (r10 != null) goto L14;
        r10 = new com.bytedance.ttnet.priority.a();     // Catch: Throwable -> L19
    L14:
        this.f2869c = r10;     // Catch: Throwable -> L19
        r10.i();     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L17;
        Logger.d(f2866f, "set mode " + this.f2869c.k());     // Catch: Throwable -> L19
    L17:
        this.f2870d.writeLock().unlock();
        return;
    L19:
        th = move-exception;
        this.f2870d.writeLock().unlock();
        throw th;
    L8:
        if (a.e(r10) == true) goto L10;
        return;
    L4:
        if (this.f2867a.get() == true) goto L6;
    }

    @Override // s4.b
    public void a(n4.c r10, RetrofitMetrics r11) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f2866f, "current mode is " + g());
    L6:
        if (this.f2867a.get() == true) goto L11;
        if (this.f2869c.k() == ModeType.DEFAULT) goto L11;
        return;
    L11:
        if (f(r10, r11) == true) goto L14;
        return;
    L14:
        if (a.e(this.f2869c) == true) goto L16;
        return;
    L16:
        this.f2869c.a(r10, r11);
    }

    @Override // s4.b
    public void b(n4.c r10) {
        if (this.f2867a.get() == false) goto L8;
        if (r10 == null) goto L9;
        this.f2869c.b(r10);
        return;
    L9:
        return;
    }

    @Override // s4.b
    public n4.c c(n4.c r10) {
        if (this.f2867a.get() == false) goto L8;
        if (r10 == null) goto L8;
        return this.f2869c.c(r10);
    L8:
        return r10;
    }

    @Override // s4.b
    public boolean d(n4.c r10, RetrofitMetrics r11, Executor r12, Runnable r13) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f2866f, "current mode is " + g());
    L6:
        if (this.f2867a.get() == true) goto L11;
        if (this.f2869c.k() == ModeType.DEFAULT) goto L11;
        return false;
    L11:
        if (f(r10, r11) == true) goto L14;
        return false;
    L14:
        if (a.e(this.f2869c) == true) goto L17;
        return false;
    L17:
        return this.f2869c.d(r10, r11, r12, r13);
    }

    public ModeType g() {
        this.f2870d.writeLock().lock();
        ModeType r10 = this.f2869c.k();     // Catch: Throwable -> L6
        this.f2870d.writeLock().unlock();
        return r10;
    L6:
        th = move-exception;
        this.f2870d.writeLock().unlock();
        throw th;
    }

    public void l(JSONObject r10) {
        int r11 = 0;
        this.f2867a.set(false);
        this.f2868b.clear();
        JSONArray r12 = r10.optJSONArray("tt_req_delay_config");
        if (r10.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r13 = true;
    L7:
        if (r10.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r14 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r14 == false) goto L14;
        boolean r15 = true;
    L15:
        if (r13 == false) goto L50;
        if (r12 == null) goto L50;
        if (r15 == false) goto L50;
        ConcurrentHashMap r16 = new ConcurrentHashMap();
    L21:
        if (r11 >= r12.length()) goto L46;
        JSONObject r17 = r12.optJSONObject(r11);
        if (r17 == null) goto L24;
        String r18 = r17.optString("state_name", "");
        if (TextUtils.isEmpty(r18) == true) goto L44;
        ModeType r19 = ModeType.fromValue(r17.optInt(WsConstants.KEY_CONNECTION_TYPE, ModeType.NOT_REACHED.getValue()));
        a r20 = null;
        if (r19 != ModeType.NORMAL_DELAY) goto L32;
        r20 = new b();
    L37:
        if (r20 == null) goto L44;
        if (r20.g(r17) == false) goto L44;
        if (Logger.debug() == false) goto L43;
        Logger.d(f2866f, "mode name is " + r18);
    L43:
        r16.put(r18, r20);
        goto L44
    L32:
        if (r19 != ModeType.RUNTIME_DELAY) goto L35;
        r20 = new d();
        goto L37
    L35:
        if (r19 != ModeType.PRIORITY) goto L37;
        r20 = new c();
    L44:
        r11 = r11 + 1;
        goto L21
    L24:
        return;
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.d(f2866f, "mode size is " + r16.size());
    L48:
        this.f2868b.putAll(r16);
        this.f2867a.set(true);
        return;
    L50:
        m();
        return;
    L14:
        r15 = false;
        goto L15
    L9:
        r14 = false;
        goto L11
    L5:
        r13 = false;
        goto L7
    }

    public void m() {
        n(null);
    }
}
