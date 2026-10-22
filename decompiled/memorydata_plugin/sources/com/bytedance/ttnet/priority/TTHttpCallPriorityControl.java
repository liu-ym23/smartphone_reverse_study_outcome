package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public class TTHttpCallPriorityControl implements IHttpCallThrottleControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile TTHttpCallPriorityControl f3292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3293b = "TTHttpCallPriorityControl";
    private final AtomicBoolean c;
    private final Map<String, a> d;
    private a e;
    private final ReadWriteLock f;

    public static final enum ModeType extends Enum<ModeType> {
        private static final /* synthetic */ ModeType[] $VALUES = null;
        public static final ModeType DEFAULT = null;
        public static final ModeType NORMAL_DELAY = null;
        public static final ModeType NOT_REACHED = null;
        public static final ModeType PRIORITY = null;
        public static final ModeType RUNTIME_DELAY = null;
        private final int value;

        static {
            ModeType r0 = new ModeType("DEFAULT", 0, 0);
            DEFAULT = r0;
            ModeType r1 = new ModeType("NORMAL_DELAY", 1, 1);
            NORMAL_DELAY = r1;
            ModeType r3 = new ModeType("RUNTIME_DELAY", 2, 2);
            RUNTIME_DELAY = r3;
            ModeType r5 = new ModeType("PRIORITY", 3, 3);
            PRIORITY = r5;
            ModeType r7 = new ModeType("NOT_REACHED", 4, 4);
            NOT_REACHED = r7;
            $VALUES = new ModeType[]{r0, r1, r3, r5, r7};
        }

        private ModeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ModeType fromValue(int r5) {
            ModeType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            ModeType r3 = r0[r2];
            if (r3.getValue() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            throw new IllegalArgumentException("Invalid value: " + r5);
        }

        public static ModeType valueOf(String r2) {
            return (ModeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ModeType.class, r2), ModeType.class, "com.obric.memorydata.plugin");
        }

        public static ModeType[] values() {
            return (ModeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ModeType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.value;
        }
    }

    public static abstract class a implements IHttpCallThrottleControl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final e f3294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f3295b;
        private int c;
        private Date d;
        private Date e;
        private boolean f;
        private int g;
        private com.bytedance.frameworks.baselib.network.asynctask.a h;

        public a() {
            this.f3294a = new e();
            this.f3295b = "";
            this.c = -1;
            this.d = null;
            this.e = null;
            this.f = true;
            this.g = 1000;
            this.h = null;
        }

        static /* synthetic */ boolean a(a r0) {
            return r0.d();
        }

        private void b(JSONObject r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            String r6 = r5.optString("lifecycle");
            if ("".equals(r6) == false) goto L7;
            return;
        L7:
            ArrayList r0 = new ArrayList();
            if (com.bytedance.frameworks.baselib.network.http.util.f.b(r6, r0) == false) goto L17;
            if (r0.size() != 2) goto L17;
            this.f = true;
            this.d = (Date) ZeusTransformUtils.preCheckCast(r0.get(0), Date.class, "com.obric.memorydata.plugin");
            this.e = (Date) ZeusTransformUtils.preCheckCast(r0.get(1), Date.class, "com.obric.memorydata.plugin");
            if (Logger.debug() == false) goto L21;
            Logger.d(TTHttpCallPriorityControl.d(), "initLifecycle, stateName: " + this.f3295b + ", beginTime: " + this.d.toString() + ", endTime: " + this.e.toString());
            return;
        L21:
            return;
        L17:
            if (Logger.debug() == false) goto L19;
            Logger.d(TTHttpCallPriorityControl.d(), "initLifecycle, parse lifecycle failed");
        L19:
            this.f = false;
        }

        private boolean d() {
            if (Logger.debug() == false) goto L6;
            Logger.d(TTHttpCallPriorityControl.d(), "isInLifecycle, stateName: " + this.f3295b + ", beginTime: " + this.d + ", endTime: " + this.e);
        L6:
            if (this.f == true) goto L9;
            return false;
        L9:
            if (this.d != null) goto L11;
        L19:
            return true;
        L11:
            if (this.e == null) goto L19;
            Date r0 = new Date();
            if (r0.after(this.d) == true) goto L16;
            return false;
        L16:
            if (r0.before(this.e) == true) goto L18;
            return false;
        L18:
            return true;
        }

        public void a() {
            final long r2 = this.g;
            final long r4 = 0;
            com.bytedance.frameworks.baselib.network.asynctask.a r6 = new AnonymousClass1(this, r2, r4);
            this.h = r6;
            if (r6 == null) goto L6;
            com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).a(this.h);
            return;
        }

        boolean a(JSONObject r3) {
            String r0 = r3.optString("state_name", "");
            this.f3295b = r0;
            if (TextUtils.isEmpty(r0) == false) goto L6;
            return false;
        L6:
            this.c = r3.optInt("state", -1);
            int r1 = 1000;
            int r2 = r3.optInt("delay_disable_time_ms", 1000);
            this.g = r2;
            if (r2 <= 0) goto L10;
            r1 = r2;
        L10:
            this.g = r1;
            b(r3);
            return true;
        }

        void b() {
            if (this.h == null) goto L6;
            com.bytedance.frameworks.baselib.network.asynctask.b.a(NetworkAsyncTaskType.NETWORK).b(this.h);
            return;
        }

        ModeType c() {
            return ModeType.NOT_REACHED;
        }

        @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
        public void notifyRequestCompleted(Request r1) {
            this.f3294a.a(r1);
        }
    }

    static {
    }

    public TTHttpCallPriorityControl() {
        this.c = new AtomicBoolean(false);
        this.d = new ConcurrentHashMap();
        this.e = new com.bytedance.ttnet.priority.a();
        this.f = new ReentrantReadWriteLock();
    }

    public static TTHttpCallPriorityControl a() {
        if (f3292a != null) goto L15;
        monitor-enter(TTHttpCallThrottleControl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3292a != null) goto L9;
        f3292a = new TTHttpCallPriorityControl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTHttpCallThrottleControl.class);     // Catch: Throwable -> L11
    L15:
        return f3292a;
    }

    public static Integer a(Map<String, Integer> r5, String r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        Iterator r0 = r7.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r6.startsWith(r3) == false) goto L7;
        return (Integer) ZeusTransformUtils.preCheckCast(r7.get(r3), Integer.class, "com.obric.memorydata.plugin");
    L12:
        return null;
    }

    public static Set<String> a(JSONObject r3, String r4) {
        CopyOnWriteArraySet r0 = new CopyOnWriteArraySet();
        if (r3 != null) goto L5;
        return r0;
    L5:
        JSONArray r5 = r3.optJSONArray(r4);
        if (r5 != null) goto L8;
        return r0;
    L8:
        int r6 = 0;
    L10:
        if (r6 >= r5.length()) goto L15;
        String r1 = r5.optString(r6);
        if (TextUtils.isEmpty(r1) == true) goto L14;
        r0.add(r1);
    L14:
        r6 = r6 + 1;
        goto L10
    L15:
        return r0;
    }

    private void a(a r3) {
        if (r3 != null) goto L4;
    L6:
        this.f.writeLock().lock();
        this.e.b();     // Catch: Throwable -> L15
        if (r3 != null) goto L10;
        r3 = new com.bytedance.ttnet.priority.a();     // Catch: Throwable -> L15
    L10:
        this.e = r3;     // Catch: Throwable -> L15
        r3.a();     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L13;
        Logger.d(f3293b, "set mode " + this.e.c());     // Catch: Throwable -> L15
    L13:
        this.f.writeLock().unlock();
        return;
    L15:
        th = move-exception;
        this.f.writeLock().unlock();
        throw th;
    L4:
        if (a.a(r3) == true) goto L6;
    }

    private boolean a(Request r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r1.getPath()) == true) goto L6;
        return true;
    }

    public static boolean a(Set<String> r4, String r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        if (r6 != null) goto L7;
        return false;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        if (r5.startsWith((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L9;
        return true;
    L14:
        return false;
    }

    static /* synthetic */ String d() {
        return f3293b;
    }

    public void a(JSONObject r9) {
        int r1 = 0;
        this.c.set(false);
        this.d.clear();
        JSONArray r0 = r9.optJSONArray("tt_req_delay_config");
        if (r9.optInt("state_delay_enabled") <= 0) goto L5;
        boolean r2 = true;
    L7:
        if (r9.optInt("state_new_strategy_enabled", 1) <= 0) goto L9;
        boolean r10 = true;
    L11:
        if (TTNetInit.getStateDelayNewStrategyEnabled() == false) goto L14;
        if (r10 == false) goto L14;
        boolean r11 = true;
    L15:
        if (r2 == false) goto L49;
        if (r0 == null) goto L49;
        if (r11 == false) goto L49;
        ConcurrentHashMap r12 = new ConcurrentHashMap();
    L21:
        if (r1 >= r0.length()) goto L45;
        JSONObject r3 = r0.optJSONObject(r1);
        String r4 = r3.optString("state_name", "");
        if (r3 == null) goto L43;
        if (TextUtils.isEmpty(r4) == true) goto L43;
        ModeType r5 = ModeType.fromValue(r3.optInt("type", ModeType.NOT_REACHED.getValue()));
        a r6 = null;
        if (r5 != ModeType.NORMAL_DELAY) goto L31;
        r6 = new b();
    L36:
        if (r6 == null) goto L43;
        if (r6.a(r3) == false) goto L43;
        if (Logger.debug() == false) goto L42;
        Logger.d(f3293b, "mode name is " + r4);
    L42:
        r12.put(r4, r6);
        goto L43
    L31:
        if (r5 != ModeType.RUNTIME_DELAY) goto L34;
        r6 = new d();
        goto L36
    L34:
        if (r5 != ModeType.PRIORITY) goto L36;
        r6 = new c();
    L43:
        r1 = r1 + 1;
        goto L21
    L45:
        if (Logger.debug() == false) goto L47;
        Logger.d(f3293b, "mode size is " + r12.size());
    L47:
        this.d.putAll(r12);
        this.c.set(true);
        return;
    L49:
        b();
        return;
    L14:
        r11 = false;
        goto L15
    L9:
        r10 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    public void b() {
        a(null);
    }

    public ModeType c() {
        this.f.writeLock().lock();
        ModeType r0 = this.e.c();     // Catch: Throwable -> L6
        this.f.writeLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.f.writeLock().unlock();
        throw th;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request r4, Executor r5, Runnable r6) {
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(f3293b, "current mode is " + c());
    L6:
        if (this.c.get() == true) goto L11;
        if (this.e.c() == ModeType.DEFAULT) goto L11;
        return false;
    L11:
        if (a(r4) == true) goto L14;
        return false;
    L14:
        if (a.a(this.e) == true) goto L17;
        return false;
    L17:
        return this.e.maybeDropRequestOrAsyncDelay(r4, r7, r8);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f3293b, "current mode is " + c());
    L6:
        if (this.c.get() == true) goto L11;
        if (this.e.c() == ModeType.DEFAULT) goto L11;
        return;
    L11:
        if (a(r4) == true) goto L14;
        return;
    L14:
        if (a.a(this.e) == true) goto L16;
        return;
    L16:
        this.e.maybeDropRequestOrBlockingDelay(r4);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(Request r2) {
        if (this.c.get() == false) goto L8;
        if (r2 == null) goto L9;
        this.e.notifyRequestCompleted(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public Request setOriginalRequestProperties(Request r2) {
        if (this.c.get() == false) goto L8;
        if (r2 == null) goto L8;
        return this.e.setOriginalRequestProperties(r2);
    L8:
        return r2;
    }
}
