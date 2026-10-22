package kfc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.push.utils.f;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.log.PushLog;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements WeakHandler.IHandler {
    public static volatile d t;
    public static boolean u;
    public final boolean a;
    public final yfc.b b;
    public final Context c;
    public final WeakHandler d;
    public boolean e;
    public int f;
    public int g;
    public String h;
    public String i;
    public String j;
    public long k;
    public long l;
    public long m;
    public long n;
    public int o;
    public boolean p;
    public final boolean q;
    public final a r;
    public final AtomicBoolean s;

    public class a extends BroadcastReceiver {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r2, Intent r3) {
            if (r2 == null) goto L18;
            if (r3 == null) goto L22;
        L13:
            th = move-exception;
            th.printStackTrace();
            return;
        L6:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r3.getAction()) == true) goto L8;
            return;
        L8:
            if (NetworkUtils.isNetworkAvailable(r2) == false) goto L20;
            d r4 = this.a;     // Catch: Throwable -> L13
            if (r4.a == false) goto L21;
            r4.d.sendEmptyMessage(0);     // Catch: Throwable -> L13
            return;
        L21:
            return;
        L20:
            return;
        L22:
            return;
        }
    }

    public class b extends ContentObserver {
        public final /* synthetic */ d a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r2) {
            if (f.a == false) goto L5;
            f.b("RedBadgeController", "KEY_IS_DESKTOP_RED_BADGE_SHOW");
        L5:
            d r3 = this.a;
            r3.e(r3.c);
        }

        public b(d r1, WeakHandler r2) {
            this.a = r1;
            super(r2);
        }
    }

    public class c extends ContentObserver {
        public final /* synthetic */ d a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r2) {
            if (f.a == false) goto L5;
            f.b("RedBadgeController", "KEY_DESKTOP_RED_BADGE_ARGS");
        L5:
            d r3 = this.a;
            r3.e(r3.c);
        }

        public c(d r1, WeakHandler r2) {
            this.a = r1;
            super(r2);
        }
    }

    /* JADX INFO: renamed from: kfc.d$d, reason: collision with other inner class name */
    public class C0020d extends ContentObserver {
        public final /* synthetic */ d a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r2) {
            if (f.a == false) goto L5;
            f.b("RedBadgeController", "KEY_LAST_TIME_PARAS");
        L5:
            d r3 = this.a;
            r3.f(r3.c);
        }

        public C0020d(d r1, WeakHandler r2) {
            this.a = r1;
            super(r2);
        }
    }

    public final void c() {
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.q == false) goto L8;
        return;
    L8:
        if (f.a == false) goto L51;
        f.b("RedBadgeController", "handleOnSchedule");
    L51:
        this.d.removeMessages(0);     // Catch: Throwable -> L48
        long r6 = ToolUtils.currentTimeMillis();     // Catch: Throwable -> L48
        if (r6 >= this.n) goto L15;
        this.n = r6 - ((long) (this.o * 1000));     // Catch: Throwable -> L48
        mfc.a.a(this.c).c(this.n);     // Catch: Throwable -> L48
    L15:
        if (com.ss.android.pushmanager.setting.a.b().d() == false) goto L23;
        if (zfc.a.a().n0() == false) goto L23;
        if (f.a == false) goto L21;
        f.b("RedBadgeController", "isApplicationForeground = true now = " + r6 + " mIsForeground = " + this.p);     // Catch: Throwable -> L48
    L21:
        WeakHandler r0 = this.d;     // Catch: Throwable -> L48
        r0.sendMessage(r0.obtainMessage(4, Long.valueOf(r6)));     // Catch: Throwable -> L48
        return;
    L23:
        if (f.a == false) goto L26;
        f.b("RedBadgeController", "isApplicationForeground = false now = " + r6 + " mIsForeground = " + this.p);     // Catch: Throwable -> L48
    L26:
        if (f.a == false) goto L28;
        f.b("RedBadgeController", "mLastLeaveTime = " + this.l + " mLastLaunchTime = " + this.k);     // Catch: Throwable -> L48
    L28:
        long r1 = this.l;     // Catch: Throwable -> L48
        long r3 = this.k;     // Catch: Throwable -> L48
        if (r1 >= r3) goto L31;
        long r2 = (r6 - r3) - 900000;     // Catch: Throwable -> L48
    L33:
        if (f.a == false) goto L36;
        f.b("RedBadgeController", "duration = " + (r2 / 1000) + " mQueryWaitingDuration = " + this.g + " mNextQueryInterval = " + this.o + " mLastRequestTime = " + this.n);     // Catch: Throwable -> L48
    L36:
        if (r2 >= (this.g * 1000)) goto L38;
    L46:
        WeakHandler r4 = this.d;     // Catch: Throwable -> L48
        r4.sendMessage(r4.obtainMessage(4, Long.valueOf(r6)));     // Catch: Throwable -> L48
        return;
    L38:
        if ((r6 - this.n) < (this.o * 1000)) goto L46;
        if (f.a == false) goto L43;
        f.b("RedBadgeController", "doSendRequest");     // Catch: Throwable -> L48
    L43:
        if (this.s.get() == true) goto L54;
        this.s.getAndSet(true);     // Catch: Throwable -> L48
        ThreadPlus.submitRunnable(new e(this, r6));     // Catch: Throwable -> L48
        return;
    L54:
        return;
    L31:
        r2 = r6 - r1;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
    }

    public d(yfc.b r10) {
        this.a = false;
        WeakHandler r1 = new WeakHandler(PushThreadHandlerManager.inst().getLooper(), this);
        this.d = r1;
        this.p = false;
        this.r = new a(this);
        this.s = new AtomicBoolean(false);
        b r2 = new b(this, r1);
        c r3 = new c(this, r1);
        C0020d r4 = new C0020d(this, r1);
        this.b = r10;
        Context r11 = r10.getContext().getApplicationContext();
        this.c = r11;
        e(r11);
        if (r11 != null) goto L20;
    L8:
        f.b("RedBadgeController", "init on RedBadgeController");
        if (this.e == false) goto L11;
    L12:
        PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.registerReceiver(this.c, this.r, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        f(this.c);
    L13:
        boolean r5 = PushServiceManager.get().getPullExternalService().isUseNewOnlineRedBadgeApi();
        this.q = r5;
        if (this.e == false) goto L17;
        if (r5 == true) goto L17;
        f.b("RedBadgeController", "init on RedBadgeController:start red badge pull");
        this.d.sendEmptyMessageDelayed(0, 10000);
    L18:
        this.a = true;
        return;
    L17:
        f.b("RedBadgeController", "init on RedBadgeController:not start red badge pull because mIsAllowRedBadgeShow:" + this.e + " mUseNewOnlineRedBadgeApi:" + r5);
        goto L18
    L11:
        if (PushServiceManager.get().getPullExternalService().isUseNewApi() == false) goto L13;
    L20:
        r11.getContentResolver().registerContentObserver(PushMultiProcessSharedProvider.c(r11, "is_desktop_red_badge_show", "boolean"), true, r2);     // Catch: Throwable -> L7
        r11.getContentResolver().registerContentObserver(PushMultiProcessSharedProvider.c(r11, "desktop_red_badge_args", "string"), true, r3);     // Catch: Throwable -> L7
        r11.getContentResolver().registerContentObserver(PushMultiProcessSharedProvider.c(r11, "red_badge_last_time_paras", "string"), true, r4);     // Catch: Throwable -> L7
        goto L8
    }

    public static d d(yfc.b r2) {
        if (t != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (t != null) goto L9;
        t = new d(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return t;
    }

    public static JSONObject h(String r2) {
        JSONObject r0 = new JSONObject();
        if (StringUtils.isEmpty(r2) == false) goto L15;
        return r0;
    L15:
        JSONObject r1 = new JSONObject(r2);     // Catch: Throwable -> L10
        a(r1, "launch");     // Catch: Throwable -> L8
        a(r1, "leave");     // Catch: Throwable -> L8
        a(r1, "badge");     // Catch: Throwable -> L8
        return r1;
    L8:
        th = th;
        r0 = r1;
    L11:
        th.printStackTrace();
        return r0;
    L10:
        th = th;
        goto L11
    }

    public final void e(Context r4) {
        if (r4 != null) goto L16;
        return;
    L16:
        this.e = mfc.a.a(this.c).a.c("is_desktop_red_badge_show", false);     // Catch: Throwable -> L13
        String r5 = mfc.a.a(this.c).a.e("desktop_red_badge_args");     // Catch: Throwable -> L13
        if (StringUtils.isEmpty(r5) == false) goto L7;
        return;
    L7:
        JSONObject r0 = new JSONObject(r5);     // Catch: Throwable -> L13
        this.f = r0.optInt("max_show_times", 5);     // Catch: Throwable -> L13
        this.g = r0.optInt("query_waiting_duration", 30);     // Catch: Throwable -> L13
        this.h = r0.optString("strategy");     // Catch: Throwable -> L13
        if (this.e == true) goto L10;
    L11:
        this.d.removeMessages(0);     // Catch: Throwable -> L13
        this.d.removeMessages(1);     // Catch: Throwable -> L13
        this.d.removeMessages(2);     // Catch: Throwable -> L13
        return;
    L10:
        if (this.q == true) goto L11;
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public final void f(Context r3) {
        if (r3 != null) goto L12;
        return;
    L12:
        this.n = mfc.a.a(this.c).b();     // Catch: Throwable -> L9
        this.o = mfc.a.a(this.c).a.d("red_badge_next_query_interval", 600);     // Catch: Throwable -> L9
        this.i = mfc.a.a(this.c).a.e("red_badge_last_time_paras");     // Catch: Throwable -> L9
        this.j = mfc.a.a(this.c).a.e("red_badge_last_last_time_paras");     // Catch: Throwable -> L9
        if (StringUtils.isEmpty(this.i) == false) goto L7;
        return;
    L7:
        JSONObject r4 = new JSONObject(this.i);     // Catch: Throwable -> L9
        this.k = r4.optLong("launch");     // Catch: Throwable -> L9
        this.l = r4.optLong("leave");     // Catch: Throwable -> L9
        this.m = r4.optLong("badge");     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public final void handleMsg(Message r13) {
        if (r13 != null) goto L52;
        return;
    L52:
        int r1 = r13.what;     // Catch: Throwable -> L49
        if (r1 != 0) goto L8;
        c();     // Catch: Throwable -> L49
        return;
    L8:
        if (r1 == 1) goto L37;
        if (r1 == 2) goto L28;
        if (r1 != 3) goto L14;
        long r0 = ((Long) r13.obj).longValue();     // Catch: Throwable -> L49
        long r6 = this.o * 1000;     // Catch: Throwable -> L49
        if (f.a == false) goto L26;
        f.b("RedBadgeController", "next schedule time = " + DateFormat.getDateTimeInstance().format(new Date(r0 + r6)));     // Catch: Throwable -> L49
    L26:
        this.d.sendEmptyMessageDelayed(0, r6);     // Catch: Throwable -> L49
        return;
    L14:
        if (r1 != 4) goto L62;
        long r2 = ((Long) r13.obj).longValue();     // Catch: Throwable -> L49
        int r14 = this.o;     // Catch: Throwable -> L49
        long r7 = r14 * 1000;     // Catch: Throwable -> L49
        long r8 = this.n + ((long) (r14 * 1000));     // Catch: Throwable -> L49
        if (r2 > r8) goto L20;
        r7 = r8 - r2;     // Catch: Throwable -> L49
    L20:
        if (f.a == false) goto L22;
        f.b("RedBadgeController", "now=" + r2 + "mNextQueryInterval=" + this.o + ",mLastRequestTime=" + this.n + "next schedule time = " + DateFormat.getDateTimeInstance().format(new Date(r2 + r7)));     // Catch: Throwable -> L49
    L22:
        this.d.sendEmptyMessageDelayed(0, r7);     // Catch: Throwable -> L49
        return;
    L62:
        return;
    L28:
        if (f.a == false) goto L31;
        f.b("RedBadgeController", "handleOnAppExit");     // Catch: Throwable -> L49
    L31:
        if (this.e == true) goto L33;
        return;
    L33:
        if (this.q == true) goto L56;
        this.p = false;     // Catch: Throwable -> L49
        this.d.removeMessages(0);     // Catch: Throwable -> L49
        this.d.sendEmptyMessageDelayed(0, this.g * 1000);     // Catch: Throwable -> L49
        return;
    L56:
        return;
    L37:
        if (f.a == false) goto L40;
        f.b("RedBadgeController", "handleOnAppEntrance");     // Catch: Throwable -> L49
    L40:
        if (this.e == true) goto L42;
        return;
    L42:
        if (this.q == true) goto L59;
        this.p = true;     // Catch: Throwable -> L49
        if (this.d.hasMessages(0) == true) goto L60;
        this.d.sendEmptyMessageDelayed(0, this.o * 1000);     // Catch: Throwable -> L49
        return;
    L60:
        return;
    L59:
        return;
    L49:
        th = move-exception;
        th.printStackTrace();
    }

    public final void i(String r13) {
        String r3 = mfc.a.a(this.c).a.e("red_badge_last_valid_response");
        f.b("RedBadgeController", "tryUseLastValidResponse: lastRes = " + r3 + "  isUseRedBadgeLastValidResponse() = " + mfc.a.a(this.c).a.c("red_badge_is_use_last_valid_response", true));
        if (mfc.a.a(this.c).a.c("red_badge_is_use_last_valid_response", true) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L40;
        int r5 = mfc.a.a(this.c).a.d("red_badge_show_times", 0);     // Catch: Exception -> L32
        if (DateUtils.isToday(this.m) == true) goto L11;
        if (r5 <= 0) goto L11;
        r5 = 0;
    L11:
        if (r5 >= this.f) goto L13;
        JSONObject r2 = new JSONObject(r3);     // Catch: Exception -> L32
        if ("success".equals(JSONObjectProtectorUtils.getString(r2, "reason")) == false) goto L30;
        r2.put("content", r2.optInt("content", 0) + 1);     // Catch: Exception -> L32
        f.b("RedBadgeController", "tryUseLastValidResponse: res = " + r2);     // Catch: Exception -> L32
        PushLog.onEvent(this.c, "red_badge", "use_last_valid_response", new JSONObject[]{r2});     // Catch: Exception -> L32
        this.n = ToolUtils.currentTimeMillis();     // Catch: Exception -> L32
        this.o = r2.optInt("next_query_interval", 0) + 600;     // Catch: Exception -> L32
        mfc.a r0 = mfc.a.a(this.c);     // Catch: Throwable -> L27
        String r1 = r2.toString();     // Catch: Throwable -> L27
        PushMultiProcessSharedProvider.a r4 = r0.a.b();     // Catch: Throwable -> L27
        r4.b.put("red_badge_last_valid_response", r1);     // Catch: Throwable -> L27
        r4.a();     // Catch: Throwable -> L27
        Intent r6 = new Intent("com.ss.android.redbadge.message");     // Catch: Throwable -> L27
        r6.putExtra("message_data", r2.toString());     // Catch: Throwable -> L27
        r6.setPackage(this.c.getPackageName());     // Catch: Throwable -> L27
        r6.putExtra("red_data_from", "last_valid_response");     // Catch: Throwable -> L27
        r6.putExtra("use_last_resp_reason", r13);     // Catch: Throwable -> L27
        if (Build.VERSION.SDK_INT >= 26) goto L23;
    L25:
        this.c.startService(r6);     // Catch: Throwable -> L27
    L35:
    L29:
        mfc.a.a(this.c).c(this.n);     // Catch: Exception -> L32
        mfc.a r14 = mfc.a.a(this.c);     // Catch: Exception -> L32
        int r7 = this.o;     // Catch: Exception -> L32
        PushMultiProcessSharedProvider.a r15 = r14.a.b();     // Catch: Exception -> L32
        r15.b.put("red_badge_next_query_interval", Integer.valueOf(r7));     // Catch: Exception -> L32
        r15.a();     // Catch: Exception -> L32
        goto L30
    L23:
        if (AppProvider.getTargetSdkVersion() < 26) goto L25;
        Context r16 = this.c;     // Catch: Throwable -> L27
        r16.bindService(r6, new g(r6, r16), 1);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L32
    L30:
        mfc.a.a(this.c).c(this.n);     // Catch: Exception -> L32
        return;
    L13:
        if (f.a == false) goto L15;
        f.b("RedBadgeController", "badge_show_times = " + r5);     // Catch: Exception -> L32
    L15:
        PushLog.onEvent(this.c, "event_v1", "red_badge", "outdo_max_show_times", r5, this.f);     // Catch: Exception -> L32
        return;
    L32:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void a(JSONObject r4, String r5) {
        if (StringUtils.isEmpty(r5) == true) goto L10;
        r4.put(r5, r4.optLong(r5) / 1000);     // Catch: Throwable -> L7
        return;
    L11:
        return;
    }

    public final JSONObject b(Context r12, boolean r13) {
        JSONObject r0 = new JSONObject();
        int r3 = 0;
        int r1 = mfc.a.a(r12).a.d("red_badge_launch_times", 0);     // Catch: Throwable -> L31
        long r4 = this.k;     // Catch: Throwable -> L31
        long r6 = this.m;     // Catch: Throwable -> L31
        String r2 = this.i;     // Catch: Throwable -> L31
        String r8 = this.j;     // Catch: Throwable -> L31
        String r9 = this.h;     // Catch: Throwable -> L31
        if (r13 == false) goto L12;
        r2 = mfc.a.a(r12).a.e("red_badge_last_time_paras");     // Catch: Throwable -> L31
        r8 = mfc.a.a(r12).a.e("red_badge_last_last_time_paras");     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r2) == true) goto L8;
        JSONObject r14 = new JSONObject(r2);     // Catch: Throwable -> L31
        r4 = r14.optLong("launch");     // Catch: Throwable -> L31
        r6 = r14.optLong("badge");     // Catch: Throwable -> L31
    L8:
        String r15 = mfc.a.a(this.c).a.e("desktop_red_badge_args");     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r15) == true) goto L12;
        r9 = new JSONObject(r15).optString("strategy");     // Catch: Throwable -> L31
    L12:
        if (DateUtils.isToday(r4) == true) goto L15;
        if (r1 <= 0) goto L15;
        r1 = 0;
    L15:
        int r16 = mfc.a.a(r12).a.d("red_badge_show_times", 0);     // Catch: Throwable -> L31
        if (DateUtils.isToday(r6) == true) goto L19;
        if (r16 <= 0) goto L19;
    L20:
        r0.put("launch_times", r1);     // Catch: Throwable -> L31
        r0.put("badge_show_times", r3);     // Catch: Throwable -> L31
        r0.put("last_time_paras", h(r2));     // Catch: Throwable -> L31
        r0.put("last_last_time_paras", h(r8));     // Catch: Throwable -> L31
        r0.put("desktop_red_badge_strategy", r9);     // Catch: Throwable -> L31
        r0.put("client_current_time", ToolUtils.currentTimeMillis() / 1000);     // Catch: Throwable -> L31
        r0.put(EffectConfiguration.KEY_DEVICE_ID, com.ss.android.pushmanager.setting.a.b().a());     // Catch: Throwable -> L31
        yfc.b r17 = this.b;     // Catch: Throwable -> L31
        if (r17 == null) goto L32;
        r0.put("app_id", r17.getAid());     // Catch: Throwable -> L31
    L32:
        r0.put("rom", ToolUtils.getRomInfo());     // Catch: Throwable -> L25
        r0.put("brand", Build.BRAND);     // Catch: Throwable -> L25
        r0.put("model", Build.MODEL);     // Catch: Throwable -> L25
        r0.put("os_api", Build.VERSION.SDK_INT);     // Catch: Throwable -> L25
    L27:
        yfc.b r18 = this.b;     // Catch: Throwable -> L31
        if (r18 == null) goto L30;
        r0.put("ver", r18.getVersionCode());     // Catch: Throwable -> L31
        goto L30
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L31
    L19:
        r3 = r16;
    L30:
        return r0;
    }

    public final void g(String r11, Bundle r12) {
        if (StringUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        JSONObject r9 = new JSONObject();
        r9.optString("");
        r9.put(AppLogNewUtils.EVENT_SIGN, 1);     // Catch: Throwable -> L11
        r9.put("has_app_foreground", u);     // Catch: Throwable -> L11
        Iterator<String> r0 = r12.keySet().iterator();     // Catch: Throwable -> L11
    L8:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();     // Catch: Throwable -> L11
        r9.put(r1, r12.get(r1));     // Catch: Throwable -> L11
    L13:
        PushLog.onEvent(this.c, AppLogNewUtils.EVENT_V3_CATEGORY, r11, null, 0, 0, r9);
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }
}
