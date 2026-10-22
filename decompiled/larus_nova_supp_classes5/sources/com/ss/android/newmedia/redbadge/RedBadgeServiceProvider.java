package com.ss.android.newmedia.redbadge;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.push.service.manager.annotation.ServiceProvider;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.android.service.manager.redbadge.IRedBadgeExternalService;
import com.bytedance.push.settings.PushOnlineSettings;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kfc.a;
import lfc.b;
import lfc.c;
import lfc.d;
import lfc.e;
import lfc.f;
import lfc.g;
import lfc.h;
import lfc.i;
import lfc.j;
import lfc.k;
import lfc.l;
import lfc.m;
import lfc.n;
import lfc.o;
import lfc.p;
import lfc.q;
import lfc.r;
import lfc.s;
import lfc.t;
import lfc.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ServiceProvider
public class RedBadgeServiceProvider implements IRedBadgeExternalService {
    private static final List<Class<? extends a>> BADGERS = null;
    public static final int BADGE_NUMBER_NOT_GET = -2;
    private static volatile RedBadgeServiceProvider sInstance;
    private long MAX_RED_BADGE_SHOW_HISTORY_TIME;
    private final String TAG;
    private int mBadgeCountWhenAppLaunch;
    private ComponentName mComponentName;
    private volatile a mRedBadger;

    static {
        LinkedList r0 = new LinkedList();
        BADGERS = r0;
        r0.add(lfc.a.class);
        r0.add(b.class);
        r0.add(j.class);
        r0.add(k.class);
        r0.add(p.class);
        r0.add(s.class);
        r0.add(c.class);
        r0.add(f.class);
        r0.add(h.class);
        r0.add(m.class);
        r0.add(l.class);
        r0.add(q.class);
        r0.add(t.class);
        r0.add(u.class);
        r0.add(n.class);
        r0.add(e.class);
        r0.add(o.class);
        r0.add(g.class);
        r0.add(r.class);
        r0.add(i.class);
    }

    public boolean isSupportGetCurRedBadgeNumber() {
        if ((this.mRedBadger instanceof kfc.b) == true) goto L6;
        return false;
    L6:
        kfc.b r0 = (kfc.b) this.mRedBadger;
        r0.getClass();
        return !(r0 instanceof q);
    }

    public RedBadgeServiceProvider() {
        this.TAG = "RedBadgeServiceProvider";
        this.MAX_RED_BADGE_SHOW_HISTORY_TIME = DownloadConstants.DAY;
        this.mBadgeCountWhenAppLaunch = -2;
    }

    private boolean initBadger(Context r8) {
        boolean r1 = false;
        if (r8 != null) goto L76;
        return false;
    L76:
        Intent r3 = r8.getPackageManager().getLaunchIntentForPackage(r8.getPackageName());     // Catch: Throwable -> L12
        if (r3 != null) goto L10;
        com.bytedance.push.utils.f.b("RedBadgerManager", "Unable to find launch intent for package " + r8.getPackageName());     // Catch: Throwable -> L12
        return false;
    L10:
        this.mComponentName = r3.getComponent();     // Catch: Throwable -> L12
        Intent r0 = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L12
        r0.addCategory("android.intent.category.HOME");     // Catch: Throwable -> L12
        ResolveInfo r2 = r8.getPackageManager().resolveActivity(r0, 65536);     // Catch: Throwable -> L12
    L13:
        if (r2 != null) goto L75;
    L74:
        return false;
    L75:
        ActivityInfo r4 = r2.activityInfo;     // Catch: Exception -> L70
        if (r4 == null) goto L74;
        if (TextUtils.isEmpty(r4.name) == true) goto L74;
        if (r2.activityInfo.name.toLowerCase().contains("resolver") == true) goto L74;
        String r5 = r2.activityInfo.packageName;     // Catch: Exception -> L70
        Iterator<Class<? extends a>> r6 = BADGERS.iterator();     // Catch: Exception -> L70
    L23:
        if (r6.hasNext() == false) goto L34;
        a r7 = r6.next().newInstance();     // Catch: Throwable -> L27
    L29:
        if (r7 == null) goto L23;
        if (r7.b().contains(r5) == false) goto L23;
        this.mRedBadger = r7;     // Catch: Exception -> L70
        r1 = true;
        goto L34
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L70
        r7 = null;
    L34:
        if (this.mRedBadger != null) goto L73;
        String r9 = Build.MANUFACTURER;     // Catch: Exception -> L70
        if (r9.equalsIgnoreCase("OPPO") == true) goto L66;
        if (r9.equalsIgnoreCase("OnePlus") == true) goto L66;
        if (r9.equalsIgnoreCase("VIVO") == false) goto L44;
        this.mRedBadger = new q();     // Catch: Exception -> L70
        return true;
    L44:
        if (r9.equalsIgnoreCase("Xiaomi") == false) goto L47;
        this.mRedBadger = new s();     // Catch: Exception -> L70
        return true;
    L47:
        if (r9.equalsIgnoreCase("ZUK") == false) goto L50;
        this.mRedBadger = new u();     // Catch: Exception -> L70
        return true;
    L50:
        if (r9.equalsIgnoreCase("ZTE") == false) goto L53;
        this.mRedBadger = new t();     // Catch: Exception -> L70
        return true;
    L53:
        if (r9.equalsIgnoreCase("SONY") == false) goto L56;
        this.mRedBadger = new p();     // Catch: Exception -> L70
        return true;
    L56:
        if (r9.equalsIgnoreCase("Samsung") == false) goto L59;
        this.mRedBadger = new n();     // Catch: Exception -> L70
        return true;
    L59:
        if (r9.equalsIgnoreCase("HUAWEI") == false) goto L62;
        this.mRedBadger = new f();     // Catch: Exception -> L70
        return true;
    L62:
        if (r9.equalsIgnoreCase("HONOR") == false) goto L64;
        this.mRedBadger = new h();     // Catch: Exception -> L70
        return true;
    L64:
        this.mRedBadger = new d();     // Catch: Exception -> L70
        return true;
    L66:
        if (((PushOnlineSettings) j77.i.a(r8, PushOnlineSettings.class)).F() == false) goto L68;
        this.mRedBadger = new m();     // Catch: Exception -> L70
        return true;
    L68:
        this.mRedBadger = new l();     // Catch: Exception -> L70
        return true;
    L73:
        return r1;
    L70:
        e = move-exception;
        e.printStackTrace();
    L12:
        r2 = null;
        goto L13
    }

    public int getBadgeNumberWhenAppLaunch(Context r3) {
        int r0 = this.mBadgeCountWhenAppLaunch;     // Catch: Throwable -> L7
        if (r0 == (-2)) goto L5;
        return r0;
    L5:
        return getCurRedBadgeNumber(r3);
    L7:
        th = move-exception;
        com.bytedance.push.utils.f.f("RedBadgerManager", "Unable to getBadgeNumberWhenAppLaunch ", th);
        return -1;
    }

    public int getCurRedBadgeNumber(Context r9) {
        IPushSdkMonitorService r0 = PushServiceManager.get().getPushExternalService().getPushSdkMonitorService();
        if (this.mRedBadger != null) goto L9;
        if (initBadger(r9) == true) goto L9;
        com.bytedance.push.utils.f.e("RedBadgeServiceProvider", "No default launcher available");
        r0.onBadgeOperateFailed(2, null, "No default launcher available");
        return -1;
    L9:
        if ((this.mRedBadger instanceof kfc.b) == true) goto L12;
        r0.onBadgeOperateFailed(2, null, "not support");
        return -1;
    L12:
        kfc.b r1 = (kfc.b) this.mRedBadger;
        r1.getClass();
        if ((!(r1 instanceof q)) == true) goto L20;
        return -1;
    L20:
        int r10 = r1.d(r9, this.mComponentName);     // Catch: Exception -> L17
        r0.onBadgeOperateSuccess(2, null);     // Catch: Exception -> L17
        return r10;
    L17:
        e = move-exception;
        com.bytedance.push.utils.f.e("RedBadgeServiceProvider", "error when getCurRedBadgeNumber:" + e.getLocalizedMessage());
        r0.onBadgeOperateFailed(2, null, "error when getCurRedBadgeNumber:" + e.getLocalizedMessage());
        return -1;
    }

    public List<Long> getRedBadgeShowHistoryList(Context r1) {
        return ToolUtils.stringToList(getRedBadgeShowHistoryStr(r1));
    }

    public String getRedBadgeShowHistoryStr(Context r2) {
        return mfc.a.a(r2).a.e("red_badge_show_history");
    }

    public boolean isSupportAddRedBadgeNumber(int r2) {
        if ((this.mRedBadger instanceof kfc.b) == true) goto L7;
        return false;
    L7:
        return ((kfc.b) this.mRedBadger).e(r2);
    }

    public boolean isSupportReduceRedBadgeNumber(int r1) {
        if ((this.mRedBadger instanceof kfc.b) == true) goto L6;
        return false;
    L6:
        ((kfc.b) this.mRedBadger).getClass();
        return true;
    }

    public boolean removeCount(Context r2) {
        return applyCount(r2, 0);
    }

    public void removeCountOrThrow(Context r2) throws RedBadgerException {
        applyCountOrThrow(r2, 0);
    }

    public void startOnWorkerProcess(yfc.b r1) {
        kfc.d.d(r1);
    }

    private void onRedBadgeShow(Context r9, int r10) {
        if (r10 <= 0) goto L19;
        String r11 = mfc.a.a(r9).a.e("red_badge_show_history");
        List r1 = new ArrayList();
        if (TextUtils.isEmpty(r11) == true) goto L6;
        r1 = ToolUtils.stringToList(r11);
    L6:
        LinkedList r12 = new LinkedList();
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Long r3 = (Long) r2.next();
        if ((ToolUtils.currentTimeMillis() - r3.longValue()) > this.MAX_RED_BADGE_SHOW_HISTORY_TIME) goto L8;
        r12.add(r3);
        goto L8
    L12:
        r12.add(Long.valueOf(ToolUtils.currentTimeMillis()));
        String r13 = ToolUtils.listToString(r12);
        PushMultiProcessSharedProvider.a r14 = mfc.a.a(r9).a.b();
        r14.b.put("red_badge_show_history", r13);
        r14.a();
        return;
    }

    public boolean addRedBadgeNumber(Context r6, int r7) {
        IPushSdkMonitorService r0 = PushServiceManager.get().getPushExternalService().getPushSdkMonitorService();
        if (this.mRedBadger != null) goto L9;
        if (initBadger(r6) == true) goto L9;
        r0.onBadgeOperateFailed(3, Integer.valueOf(r7), "No default launcher available");
        return false;
    L9:
        if ((this.mRedBadger instanceof kfc.b) == true) goto L11;
        return false;
    L11:
        kfc.b r1 = (kfc.b) this.mRedBadger;
        if (r1.e(r7) == true) goto L23;
        r0.onBadgeOperateFailed(3, Integer.valueOf(r7), "not support");
        return false;
    L23:
        boolean r8 = r1.c(r6, this.mComponentName, r7);     // Catch: Exception -> L20
        if (r8 == false) goto L18;
        r0.onBadgeOperateSuccess(3, Integer.valueOf(r7));     // Catch: Exception -> L20
    L19:
        return r8;
    L18:
        r0.onBadgeOperateFailed(3, Integer.valueOf(r7), "return false");     // Catch: Exception -> L20
    L20:
        e = move-exception;
        r0.onBadgeOperateFailed(3, Integer.valueOf(r7), "error when addRedBadgeNumber:" + e.getLocalizedMessage());
        return false;
    }

    public boolean applyCount(Context r4, int r5) {
        com.bytedance.push.utils.f.b("RedBadgerManager", "applyCount " + r5 + " from " + Log.getStackTraceString(new Throwable()));     // Catch: RedBadgerException -> L6
        applyCountOrThrow(r4, r5);     // Catch: RedBadgerException -> L6
        return true;
    L6:
        e = move-exception;
        if (com.bytedance.push.utils.f.a == false) goto L14;
        com.bytedance.push.utils.f.c("RedBadgerManager", "Unable to execute badge", e);
        return false;
    L14:
        return false;
    }

    public void applyCountOrThrow(Context r5, int r6) throws RedBadgerException {
        IPushSdkMonitorService r0 = PushServiceManager.get().getPushExternalService().getPushSdkMonitorService();
        if (this.mRedBadger == null) goto L5;
    L19:
    L16:
        e = move-exception;
        r0.onBadgeOperateFailed(1, Integer.valueOf(r6), e.getLocalizedMessage());
        throw new RedBadgerException("Unable to execute badge", e);
    L10:
        if (m67.a.d() == false) goto L12;
    L14:
        this.mRedBadger.a(r5, this.mComponentName, r6);     // Catch: Exception -> L16
        r0.onBadgeOperateSuccess(1, Integer.valueOf(r6));     // Catch: Exception -> L16
        return;
    L12:
        if (this.mBadgeCountWhenAppLaunch != (-2)) goto L14;
        this.mBadgeCountWhenAppLaunch = getBadgeNumberWhenAppLaunch(r5);     // Catch: Exception -> L16
        goto L14
    L5:
        if (initBadger(r5) == true) goto L19;
        r0.onBadgeOperateFailed(1, Integer.valueOf(r6), "No default launcher available");
        throw new RedBadgerException("No default launcher available");
    }

    public JSONObject getRedBadgeRequestBody(Context r2, boolean r3) {
        zfc.a.a().W2();
        return kfc.d.d(w67.a.a.a).b(r2, r3);
    }

    public boolean reduceRedBadgeNumber(Context r6, int r7) {
        IPushSdkMonitorService r0 = PushServiceManager.get().getPushExternalService().getPushSdkMonitorService();
        if (this.mRedBadger != null) goto L9;
        if (initBadger(r6) == true) goto L9;
        r0.onBadgeOperateFailed(4, Integer.valueOf(r7), "No default launcher available");
        return false;
    L9:
        if ((this.mRedBadger instanceof kfc.b) == true) goto L11;
        return false;
    L11:
        kfc.b r1 = (kfc.b) this.mRedBadger;
        r1.getClass();
        boolean r8 = r1.f(r6, this.mComponentName, r7);     // Catch: Exception -> L17
        if (r8 == false) goto L15;
        r0.onBadgeOperateSuccess(4, Integer.valueOf(r7));     // Catch: Exception -> L17
    L16:
        return r8;
    L15:
        r0.onBadgeOperateFailed(4, Integer.valueOf(r7), "return false");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        r0.onBadgeOperateFailed(4, Integer.valueOf(r7), "error when reduceRedBadgeNumber:" + e.getLocalizedMessage());
        return false;
    }
}
