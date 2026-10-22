package rqa;

import a87.h;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alive.monitor.IMonitorCallback;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.android.ManifestData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.LocalSettings$;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.PushOnlineSettings$;
import com.bytedance.push.utils.f;
import com.ss.alive.monitor.model.StartType;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ttnet.org.chromium.base.TTProcessUtils;
import g77.c;
import j77.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends g77.a implements sqa.b {
    public final Context a;
    public final String b;
    public final AtomicBoolean c;
    public final ProcessEnum d;
    public k77.b e;
    public final boolean f;
    public final Map<String, String> g;
    public boolean h;
    public boolean i;
    public boolean j;
    public IMonitorCallback k;
    public final long l;
    public final List<String> m;
    public final List<String> n;
    public final List<String> o;
    public final Handler p;

    /* JADX INFO: renamed from: rqa.a$a, reason: collision with other inner class name */
    public class C0029a implements Handler.Callback {
        public final /* synthetic */ a a;

        public C0029a(a r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r3) {
            f.b("AssociationStartMonitorService", "handle msg:" + r3.what);
            switch(r3.what) {
                case 10141757: goto L10;
                case 10141758: goto L6;
                default: goto L4;
            };
        L4:
            return false;
        L6:
            a r4 = this.a;
            r4.i = true;
            IMonitorCallback r5 = r4.k;
            if (r5 == null) goto L9;
            r5.onHookActivityTaskManagerResult(true);
        L9:
            return true;
        L10:
            a r6 = this.a;
            r6.h = true;
            IMonitorCallback r7 = r6.k;
            if (r7 == null) goto L13;
            r7.onHookActivityManagerResult(true);
        L13:
            return true;
        }
    }

    public final void c() {
        if (c.e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.e != null) goto L9;
        c.e = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        if (c.e.a(this) == false) goto L17;
        ((tqa.a) tqa.a.c()).a().onHookResult("ActivityTaskManager", true, "success", ToolUtils.currentTimeMillis() - this.l);
        this.p.sendEmptyMessage(10141758);
        return;
    L17:
        ((tqa.a) tqa.a.c()).a().onHookResult("ActivityTaskManager", false, "hook failed", ToolUtils.currentTimeMillis() - this.l);
    }

    public final void i() {
        if (this.c.getAndSet(true) == false) goto L5;
        return;
    L5:
        ProcessEnum r0 = ToolUtils.getCurProcess(this.a);
        if (this.f == false) goto L8;
        PushOnlineSettings$.SettingImpl r3 = new PushOnlineSettings$.SettingImpl(new h(this.a, "push_multi_process_config"));
    L9:
        this.e = r3.I();
        f.b("AssociationStartMonitorService", "[" + r0.processSuffix + "] on monitorAssociationStart enableAssociationHook is " + this.e.a + " enableAssociationStartMonitor is " + this.e.b + " enableAssociationStartIntercept is " + this.e.d + " interceptComponentWhiteList is " + this.e.g + " interceptComponentBlackList is " + this.e.f + " isolationInterceptComponentBlackList is " + this.e.e + " monitorComponentWhiteList is " + this.e.c + " smpRedirectMap is " + this.e.h);
        if (this.e.b == false) goto L15;
        if (this.f == true) goto L15;
        ((tqa.a) tqa.a.c()).a().enableReport(true);
    L15:
        if (this.f == false) goto L18;
        ((HashMap) this.g).putAll(this.e.h);
    L18:
        if (this.f == false) goto L23;
        if (PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp() == true) goto L23;
        f.b("AssociationStartMonitorService", "[" + r0.processSuffix + "] enable hook because mCurIsSmpProcess and allowStartOthersProcessFromSmp is false");
        this.e.a = true;
    L23:
        if (ToolUtils.isMainProcess(this.a) == false) goto L28;
        if (PushServiceManager.get().getPushExternalService().allowStartNonMainProcess() == true) goto L28;
        f.b("AssociationStartMonitorService", "[" + r0.processSuffix + "] enable hook because allowStartNonMainProcess is false");
        this.e.a = true;
    L28:
        if (this.f == true) goto L31;
        this.j = r3.p().a;
    L31:
        if (this.j == false) goto L34;
        f.b("AssociationStartMonitorService", "[" + r0.processSuffix + "] enable hook because enableMonitorNotificationShow is true");
        this.e.a = true;
    L34:
        if (this.e.a == true) goto L36;
        return;
    L36:
        if (g77.b.e != null) goto L48;
        monitor-enter(g77.b.class);
    L44:
        th = move-exception;
        throw th;
    L40:
        if (g77.b.e != null) goto L42;
        g77.b.e = new g77.b();     // Catch: Throwable -> L44
    L42:
        monitor-exit(g77.b.class);     // Catch: Throwable -> L44
    L48:
        if (g77.b.e.a(this) == false) goto L50;
        ((tqa.a) tqa.a.c()).a().onHookResult("ActivityManager", true, "success", ToolUtils.currentTimeMillis() - this.l);
        this.p.sendEmptyMessage(10141757);
    L51:
        c();
        return;
    L50:
        f.e("AssociationStartMonitorService", "error when hook IActivityManager for AssociationStartMonitor");
        ((tqa.a) tqa.a.c()).a().onHookResult("ActivityManager", false, "hook failed", ToolUtils.currentTimeMillis() - this.l);
        goto L51
    L8:
        r3 = (PushOnlineSettings) i.a(this.a, PushOnlineSettings.class);
        goto L9
    }

    public static boolean d() {
        PushCommonConfiguration r0 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (r0 == null) goto L9;
        IPushCommonConfiguration r1 = r0.mIPushCommonConfiguration;
        if (r1 == null) goto L9;
        if (r1.fixAssociationStartMonitorServiceAnr() == true) goto L9;
        boolean r2 = true;
    L10:
        f.b("AssociationStartMonitorService", "[isForeGround]allowReadFile:" + r2);
        if (r2 == false) goto L13;
        boolean r3 = m67.a.d();
    L15:
        return !r3;
    L13:
        r3 = m67.a.g;
    L9:
        r2 = false;
        goto L10
    }

    public a(Context r8) {
        this.c = new AtomicBoolean(false);
        HashMap r0 = new HashMap();
        this.g = r0;
        this.h = false;
        this.i = false;
        this.j = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new Handler(PushThreadHandlerManager.inst().getLooper(), new C0029a(this));
        this.a = r8;
        this.b = r8.getPackageName();
        ProcessEnum r1 = ToolUtils.getCurProcess(r8);
        this.d = r1;
        this.l = ToolUtils.currentTimeMillis();
        this.f = ToolUtils.isSmpProcess(r8);
        String r2 = ToolUtils.getCurProcessName(r8);
        if (TextUtils.isEmpty(r2) == true) goto L11;
        if (r2.endsWith(ToolUtils.SMP_PROCESS_SUFFIX) == false) goto L8;
        r0.put("com.xiaomi.mipush.sdk.MessageHandleService", "com.xiaomi.mipush.sdk.SmpMessageHandleService");
        r0.put("com.xiaomi.mipush.sdk.MIPushMessageHandler", "com.xiaomi.mipush.sdk.SmpMIPushMessageHandler");
        r0.put("com.xiaomi.mipush.sdk.PushMessageHandler", "com.xiaomi.mipush.sdk.SmpPushMessageHandler");
        this.m = b(ToolUtils.SMP_PROCESS_SUFFIX);
        goto L11
    L8:
        if (r2.endsWith(ToolUtils.SMP_PROCESS_SUFFIX_V2) == false) goto L11;
        r0.put("com.xiaomi.mipush.sdk.MessageHandleService", "com.xiaomi.mipush.sdk.WidgetProviderMessageHandleService");
        r0.put("com.xiaomi.mipush.sdk.MIPushMessageHandler", "com.xiaomi.mipush.sdk.WidgetProviderMIPushMessageHandler");
        r0.put("com.xiaomi.mipush.sdk.PushMessageHandler", "com.xiaomi.mipush.sdk.WidgetProviderPushMessageHandler");
        this.m = b(ToolUtils.SMP_PROCESS_SUFFIX_V2);
    L11:
        if (ToolUtils.isMainProcess(r8) == true) goto L13;
        return;
    L13:
        if (PushServiceManager.get().getPushExternalService().allowStartNonMainProcess() == false) goto L16;
        return;
    L16:
        if (r1 == ProcessEnum.PUSH) goto L19;
        this.n = b(TTProcessUtils.MESSAGE_PROCESS_SUFFIX);
    L19:
        if (r1 == ProcessEnum.PUSH_SERVICE) goto L23;
        this.o = b(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX);
        return;
    }

    public final List<String> b(String r15) {
        ArrayList r1 = new ArrayList();
        String r2 = "[get " + r15 + " ProcessComponent]";
    L57:
        th = move-exception;
        f.f("AssociationStartMonitorService", r2 + " exception ", th);
    L59:
        return r1;
    L4:
        if (this.f == false) goto L6;
        Context r3 = this.a;     // Catch: Throwable -> L57
        LocalSettings$.SettingImpl r4 = new LocalSettings$.SettingImpl(r3, new h(r3, "push_multi_process_config"));     // Catch: Throwable -> L57
    L7:
        k77.c r5 = r4.V();     // Catch: Throwable -> L57
        int r6 = ManifestData.getInt(this.a, "UPDATE_VERSION_CODE");     // Catch: Throwable -> L57
        f.b("AssociationStartMonitorService", r2 + " updateVersionCode:" + r6 + " componentProcessInfo：" + r5);     // Catch: Throwable -> L57
        if (r6 != r5.b) goto L19;
        Map r7 = r5.a;     // Catch: Throwable -> L57
        List<String> r8 = null;
        if (r7 == null) goto L16;
        String r9 = (String) r7.get(r15);     // Catch: Throwable -> L57
        if (r9 == null) goto L16;
        r8 = ToolUtils.stringDividedByCommaToList(r9);     // Catch: Throwable -> L57
    L16:
        if (r8 == null) goto L20;
        f.b("AssociationStartMonitorService", r2 + " use cache component info,component size:" + r8.size());     // Catch: Throwable -> L57
        return r8;
    L20:
        PackageInfo r10 = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 15);     // Catch: Throwable -> L57
        ServiceInfo[] r11 = r10.services;     // Catch: Throwable -> L57
        int r12 = 0;
        if (r11 == null) goto L28;
        int r13 = r11.length;     // Catch: Throwable -> L57
        int r14 = 0;
    L23:
        if (r14 >= r13) goto L28;
        ServiceInfo r16 = r11[r14];     // Catch: Throwable -> L57
        if (r16.processName.endsWith(r15) == false) goto L27;
        f.b("AssociationStartMonitorService", r2 + " service:" + r16.name);     // Catch: Throwable -> L57
        r1.add(r16.name);     // Catch: Throwable -> L57
    L27:
        r14 = r14 + 1;     // Catch: Throwable -> L57
    L28:
        ActivityInfo[] r17 = r10.activities;     // Catch: Throwable -> L57
        if (r17 == null) goto L36;
        int r18 = r17.length;     // Catch: Throwable -> L57
        int r19 = 0;
    L31:
        if (r19 >= r18) goto L36;
        ActivityInfo r110 = r17[r19];     // Catch: Throwable -> L57
        if (r110.processName.endsWith(r15) == false) goto L35;
        f.b("AssociationStartMonitorService", r2 + " activity: " + r110.name);     // Catch: Throwable -> L57
        r1.add(r110.name);     // Catch: Throwable -> L57
    L35:
        r19 = r19 + 1;     // Catch: Throwable -> L57
    L36:
        ActivityInfo[] r20 = r10.receivers;     // Catch: Throwable -> L57
        if (r20 == null) goto L44;
        int r21 = r20.length;     // Catch: Throwable -> L57
        int r111 = 0;
    L39:
        if (r111 >= r21) goto L44;
        ActivityInfo r112 = r20[r111];     // Catch: Throwable -> L57
        if (r112.processName.endsWith(r15) == false) goto L43;
        f.b("AssociationStartMonitorService", r2 + " receiver: " + r112.name);     // Catch: Throwable -> L57
        r1.add(r112.name);     // Catch: Throwable -> L57
    L43:
        r111 = r111 + 1;     // Catch: Throwable -> L57
    L44:
        ProviderInfo[] r22 = r10.providers;     // Catch: Throwable -> L57
        if (r22 == null) goto L52;
        int r23 = r22.length;     // Catch: Throwable -> L57
    L47:
        if (r12 >= r23) goto L52;
        ProviderInfo r24 = r22[r12];     // Catch: Throwable -> L57
        if (r24.processName.endsWith(r15) == false) goto L51;
        f.b("AssociationStartMonitorService", r2 + " provider: " + r24.authority);     // Catch: Throwable -> L57
        r1.add(r24.authority);     // Catch: Throwable -> L57
    L51:
        r12 = r12 + 1;     // Catch: Throwable -> L57
    L52:
        String r25 = ToolUtils.listToStringDivideByComma(r1);     // Catch: Throwable -> L57
        f.b("AssociationStartMonitorService", r2 + " save cur component info,updateVersionCode:" + r6 + " componentInfo size:" + r1.size());     // Catch: Throwable -> L57
        if (r5.a != null) goto L55;
        r5.a = new HashMap();     // Catch: Throwable -> L57
    L55:
        r5.a.put(r15, r25);     // Catch: Throwable -> L57
        r5.b = r6;     // Catch: Throwable -> L57
        r4.X(r5);     // Catch: Throwable -> L57
        goto L59
    L19:
        f.b("AssociationStartMonitorService", r2 + "update version code changed,get new component info");     // Catch: Throwable -> L57
        goto L20
    L6:
        r4 = (LocalSettings) i.a(this.a, LocalSettings.class);     // Catch: Throwable -> L57
        goto L7
    }

    public final void e(pqa.a r5) {
        if (r5 == null) goto L29;
        String r1 = r5.f;     // Catch: Throwable -> L25
        if (TextUtils.equals(r5.c, this.b) == false) goto L7;
        f.e("AssociationStartMonitorService", "[onComponentStartInternal]not invoke onAssociationStartEvent because cur startRecord is not cross app");     // Catch: Throwable -> L25
    L14:
        if (ToolUtils.isMainProcess(this.a) == true) goto L16;
        return;
    L16:
        if (PushServiceManager.get().getPushExternalService().allowStartNonMainProcess() == false) goto L19;
        return;
    L19:
        if (this.n.contains(r5.d) == false) goto L22;
        ThreadPlus.submitRunnable(new c(this, r5, ProcessEnum.PUSH.processSuffix));     // Catch: Throwable -> L25
        return;
    L22:
        if (this.o.contains(r5.d) == false) goto L33;
        ThreadPlus.submitRunnable(new c(this, r5, ProcessEnum.PUSH_SERVICE.processSuffix));     // Catch: Throwable -> L25
        return;
    L33:
        return;
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L11:
        f.e("AssociationStartMonitorService", "[onComponentStartInternal]not invoke onAssociationStartEvent because loop invoke");     // Catch: Throwable -> L25
        goto L14
    L9:
        if (r1.contains("com.ss.alive.monitor.services.impl.AssociationStartMonitorEventServiceImpl.onAssociationStartEvent") == true) goto L11;
        ((tqa.a) tqa.a.c()).a().onAssociationStartEvent(r5);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        f.e("AssociationStartMonitorService", "onComponentStart error:" + th.getMessage());
        f.e("AssociationStartMonitorService", Log.getStackTraceString(th));
        return;
    }

    public final pqa.a f(StartType r6, Intent r7) {
        if (r7 == null) goto L9;
        String r0 = r7.getPackage();
        ComponentName r1 = r7.getComponent();
        if (r1 == null) goto L7;
        pqa.a r8 = new pqa.a();
        r8.a = r6;
        StackTraceElement[] r9 = new Throwable().getStackTrace();
        String r2 = Log.getStackTraceString(new Throwable());
        r8.g = ToolUtils.currentTimeMillis();
        r8.b = d();
        r8.c = r0;
        r8.d = r1.getClassName();
        r8.h = this.d.processSuffix;
        r8.e = r9;
        r8.f = r2;
        return r8;
    L7:
        if (TextUtils.isEmpty(r7.getAction()) == true) goto L9;
        pqa.a r3 = new pqa.a();
        r3.a = r6;
        StackTraceElement[] r10 = new Throwable().getStackTrace();
        String r4 = Log.getStackTraceString(new Throwable());
        r3.g = ToolUtils.currentTimeMillis();
        r3.b = d();
        r3.c = r0;
        r3.d = r7.getAction();
        r3.h = this.d.processSuffix;
        r3.e = r10;
        r3.f = r4;
        return r3;
    L9:
        return null;
    }

    public final pqa.a g(StartType r5, String r6) {
        pqa.a r0 = new pqa.a();
        r0.a = r5;
        StackTraceElement[] r7 = new Throwable().getStackTrace();
        String r1 = Log.getStackTraceString(new Throwable());
        r0.g = ToolUtils.currentTimeMillis();
        r0.d = r6;
        r0.h = this.d.processSuffix;
        r0.e = r7;
        r0.f = r1;
        return r0;
    }

    public final pqa.a h(StartType r5, Uri r6) {
        if (r6 == null) goto L4;
        r6.getHost();
        pqa.a r0 = new pqa.a();
        r0.a = r5;
        StackTraceElement[] r7 = new Throwable().getStackTrace();
        String r1 = Log.getStackTraceString(new Throwable());
        r0.g = ToolUtils.currentTimeMillis();
        r0.b = d();
        r0.d = r6.toString();
        r0.h = this.d.processSuffix;
        r0.e = r7;
        r0.f = r1;
        return r0;
    L4:
        return null;
    }

    public final g77.f a(Object r17, Method r18, Object[] r19) throws InvocationTargetException, IllegalAccessException {
        String r4 = "";
        String r0 = r18.getName();
        StartType r11 = StartType.START_SERVICE;     // Catch: Throwable -> L48
        if (TextUtils.equals(r0, r11.methodName) == false) goto L6;
        pqa.a r1 = f(r11, (Intent) r19[1]);     // Catch: Throwable -> L48
    L52:
        if (r1 != null) goto L54;
    L56:
        pqa.a r12 = r1;
    L58:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L60;
        ThreadPlus.submitRunnable(new b(this, r12));
    L61:
        g77.f r13 = new g77.f();
        if (r12 == null) goto L206;
        if (this.f == false) goto L193;
        if (PushServiceManager.get().getIAllianceService().allowStartOthersProcessFromSmp() == true) goto L193;
        List<String> r2 = this.m;
        if (r2 != null) goto L70;
    L73:
        f.b("AssociationStartMonitorService", "find non smp component on smp process:" + r18.getName() + " " + r12.d + " " + Log.getStackTraceString(new Throwable()));
        Boolean r3 = ToolUtils.isMainProcessStart(this.a);
        if (r3 != null) goto L76;
    L77:
        String r5 = r18.getName();
    L160:
        th = move-exception;
        f.f("AssociationStartMonitorService", "error when redirect ", th);
    L162:
        boolean r6 = false;
    L163:
        if (r6 == false) goto L166;
        return r13;
    L166:
        if (((ArrayList) this.e.e).contains(r12.d) == false) goto L191;
        f.b("AssociationStartMonitorService", "intercept ：" + r12.d + " because it's in smpInterceptComponentBlackList");
        String r7 = r18.getName();
        if (TextUtils.equals(r7, StartType.START_SERVICE.methodName) == false) goto L171;
        Intent r8 = (Intent) r19[1];
        r13.a = true;
        r13.b = r8.getComponent();
        goto L191
    L171:
        if (TextUtils.equals(r7, StartType.BIND_SERVICE.methodName) == false) goto L175;
        r13.b = 1;
        r13.a = true;
        return r13;
    L175:
        if (TextUtils.equals(r7, StartType.PROVIDER_GET_TYPE.methodName) == false) goto L179;
        r13.b = null;
        r13.a = true;
        return r13;
    L179:
        if (TextUtils.equals(r7, StartType.PROVIDER_QUERY.methodName) == false) goto L183;
        r13.b = null;
        r13.a = true;
        return r13;
    L183:
        if (TextUtils.equals(r7, StartType.SEND_BROADCAST.methodName) == false) goto L187;
        r13.b = 0;
        r13.a = true;
        return r13;
    L187:
        if (TextUtils.equals(r7, StartType.START_ACTIVITY.methodName) == false) goto L190;
        r13.b = 0;
        r13.a = true;
        return r13;
    L190:
        f.e("AssociationStartMonitorService", "intercept ：" + r12.d + " failed");
    L191:
        f.b("AssociationStartMonitorService", "smpProcessMonitor: redirectSuccess is false , report alliance_process_isolation_error event");
        ThreadPlus.submitRunnable(new b(r12));
        goto L193
    L80:
        if (TextUtils.equals(r5, StartType.START_SERVICE.methodName) == false) goto L91;
        Intent r9 = (Intent) r19[1];     // Catch: Throwable -> L160
        if (r9 == null) goto L162;
        ComponentName r10 = r9.getComponent();     // Catch: Throwable -> L160
        if (r10 == null) goto L162;
        String r14 = (String) ((HashMap) this.g).get(r10.getClassName());     // Catch: Throwable -> L160
        if (r14 == null) goto L162;
        if (TextUtils.isEmpty(r14) == true) goto L162;
        r9.setComponent(new ComponentName(this.a.getPackageName(), r14));     // Catch: Throwable -> L160
        r19[1] = r9;     // Catch: Throwable -> L160
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r10.getClassName() + " to " + r14);     // Catch: Throwable -> L160
    L159:
        r6 = true;
        goto L163
    L91:
        if (TextUtils.equals(r5, StartType.BIND_SERVICE.methodName) == false) goto L102;
        Intent r15 = (Intent) r19[2];     // Catch: Throwable -> L160
        if (r15 == null) goto L162;
        ComponentName r16 = r15.getComponent();     // Catch: Throwable -> L160
        if (r16 == null) goto L162;
        String r20 = (String) ((HashMap) this.g).get(r16.getClassName());     // Catch: Throwable -> L160
        if (r20 == null) goto L162;
        if (TextUtils.isEmpty(r20) == true) goto L162;
        r15.setComponent(new ComponentName(this.a.getPackageName(), r20));     // Catch: Throwable -> L160
        r19[2] = r15;     // Catch: Throwable -> L160
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r16.getClassName() + " to " + r20);     // Catch: Throwable -> L160
        goto L159
    L102:
        if (TextUtils.equals(r5, StartType.PROVIDER_GET_TYPE.methodName) == false) goto L109;
        Uri r21 = (Uri) r19[0];     // Catch: Throwable -> L160
        if (r21 == null) goto L162;
        String r22 = (String) ((HashMap) this.g).get(r21.toString());     // Catch: Throwable -> L160
        if (TextUtils.isEmpty(r22) == true) goto L162;
        r19[0] = UriProtector.parse(r22).buildUpon().build();     // Catch: Throwable -> L160
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r21 + " to " + r22);     // Catch: Throwable -> L160
        goto L159
    L109:
        if (TextUtils.equals(r5, StartType.PROVIDER_QUERY.methodName) == false) goto L128;
        Object r23 = r19[2];     // Catch: Throwable -> L160
        if ((r23 instanceof String) == false) goto L113;
        r4 = (String) r23;     // Catch: Throwable -> L160
    L117:
        if (TextUtils.isEmpty(r4) == true) goto L162;
        String r24 = (String) ((HashMap) this.g).get(r4);     // Catch: Throwable -> L160
        if (TextUtils.isEmpty(r24) == true) goto L162;
        if ((r19[2] instanceof String) == false) goto L124;
        r19[2] = r24;     // Catch: Throwable -> L160
    L126:
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r4 + " to " + r24);     // Catch: Throwable -> L160
        goto L159
    L124:
        if ((r19[1] instanceof String) == false) goto L126;
        r19[1] = r24;     // Catch: Throwable -> L160
        goto L126
    L113:
        Object r25 = r19[1];     // Catch: Throwable -> L160
        if ((r25 instanceof String) == false) goto L117;
        r4 = (String) r25;     // Catch: Throwable -> L160
        goto L117
    L128:
        if (TextUtils.equals(r5, StartType.SEND_BROADCAST.methodName) == false) goto L137;
        Intent r26 = (Intent) r19[1];     // Catch: Throwable -> L160
        ComponentName r27 = r26.getComponent();     // Catch: Throwable -> L160
        if (r27 == null) goto L162;
        String r28 = (String) ((HashMap) this.g).get(r27.getClassName());     // Catch: Throwable -> L160
        if (r28 == null) goto L162;
        if (TextUtils.isEmpty(r28) == true) goto L162;
        r26.setComponent(new ComponentName(this.a.getPackageName(), r28));     // Catch: Throwable -> L160
        r19[1] = r26;     // Catch: Throwable -> L160
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r27.getClassName() + " to " + r28);     // Catch: Throwable -> L160
        goto L159
    L137:
        if (TextUtils.equals(r5, StartType.START_ACTIVITY.methodName) == false) goto L162;
        Object r29 = r19[3];     // Catch: Throwable -> L160
        if ((r29 instanceof Intent) == false) goto L141;
        Intent r30 = (Intent) r29;     // Catch: Throwable -> L160
    L145:
        if (r30 == null) goto L162;
        ComponentName r31 = r30.getComponent();     // Catch: Throwable -> L160
        if (r31 == null) goto L162;
        String r32 = (String) ((HashMap) this.g).get(r31.getClassName());     // Catch: Throwable -> L160
        if (r32 == null) goto L162;
        if (TextUtils.isEmpty(r32) == true) goto L162;
        r30.setComponent(new ComponentName(this.a.getPackageName(), r32));     // Catch: Throwable -> L160
        if ((r19[3] instanceof Intent) == false) goto L156;
        r19[3] = r30;     // Catch: Throwable -> L160
    L158:
        f.b("AssociationStartMonitorService", "smpProcessMonitor: replace " + r31.getClassName() + " to " + r32);     // Catch: Throwable -> L160
        goto L159
    L156:
        if ((r19[2] instanceof Intent) == false) goto L158;
        r19[2] = r30;     // Catch: Throwable -> L160
        goto L158
    L141:
        Object r33 = r19[2];     // Catch: Throwable -> L160
        if ((r33 instanceof Intent) == false) goto L144;
        r30 = (Intent) r33;     // Catch: Throwable -> L160
        goto L145
    L144:
        r30 = null;
        goto L145
    L76:
        if (r3.booleanValue() == true) goto L193;
    L70:
        if (r2.size() == 0) goto L73;
        if (this.m.contains(r12.d) == false) goto L73;
    L193:
        if (((ArrayList) this.e.f).contains(r12.d) == false) goto L197;
        f.b("AssociationStartMonitorService", "intercept ：" + r12.d + " because it's in interceptComponentBlackList");
        return null;
    L197:
        if (this.e.d == true) goto L199;
        return r13;
    L199:
        f.b("AssociationStartMonitorService", "enableAssociationStartIntercept is true, try intercept it: " + r12.d);
        if (((ArrayList) this.e.g).contains(r12.d) == false) goto L203;
        f.b("AssociationStartMonitorService", "try intercept it：" + r12.d + " is in interceptComponentWhiteList so not intercept");
        return r13;
    L203:
        f.b("AssociationStartMonitorService", "try intercept it：" + r12.d + " is not in interceptComponentWhiteList so intercept");
        r13.a = true;
        return r13;
    L206:
        if (TextUtils.equals(r18.getName(), "setServiceForeground") == false) goto L228;
        if (this.j == false) goto L243;
        if (r19 == null) goto L243;
        int r34 = r19.length;
        Notification r35 = null;
        ComponentName r36 = null;
        int r37 = 0;
    L211:
        if (r37 >= r34) goto L222;
        Object r38 = r19[r37];
        if (r36 == null) goto L215;
    L217:
        if (r35 != null) goto L221;
        if ((r38 instanceof Notification) == false) goto L221;
        r35 = (Notification) r38;
    L221:
        r37 = r37 + 1;
        goto L211
    L215:
        if ((r38 instanceof ComponentName) == false) goto L217;
        r36 = (ComponentName) r38;
        goto L217
    L222:
        if (r35 == null) goto L243;
        if (PushServiceManager.get().getPushExternalService().getNotificationMonitorService().onForeGroundNotificationShow(r36, r35) == true) goto L243;
        return null;
    L243:
        return r13;
    L228:
        if (TextUtils.equals(r18.getName(), "getIntentSenderWithFeature") == false) goto L243;
        if (this.j == false) goto L243;
        if (r19 != null) goto L244;
    L239:
        Intent r39 = null;
    L240:
        if (r39 == null) goto L243;
        if (r17 == null) goto L243;
        Object r40 = r18.invoke(r17, r19);
        PushServiceManager.get().getPushExternalService().getNotificationMonitorService().onPendingIntent(r40, r39);
        r13.a = true;
        r13.b = r40;
        goto L243
    L244:
        Intent[] r41 = (Intent[]) r19[6];     // Catch: Throwable -> L237
        if (r41.length <= 0) goto L239;
        r39 = r41[0];     // Catch: Throwable -> L237
    L237:
        th = move-exception;
        f.f("AssociationStartMonitorService", "error when parse intent ", th);
        goto L239
    L60:
        e(r12);
        goto L61
    L54:
        if (((ArrayList) this.e.c).contains(r1.d) == false) goto L56;
        f.b("AssociationStartMonitorService", r1.d + " is in monitorComponentWhiteList so not monitor it , monitorComponentWhiteList is " + this.e.c.toString());
        r12 = null;
        goto L58
    L6:
        StartType r110 = StartType.BIND_SERVICE;     // Catch: Throwable -> L48
        if (TextUtils.equals(r0, r110.methodName) == false) goto L9;
        r1 = f(r110, (Intent) r19[2]);     // Catch: Throwable -> L48
        goto L52
    L9:
        StartType r111 = StartType.PROVIDER_GET_TYPE;     // Catch: Throwable -> L48
        if (TextUtils.equals(r0, r111.methodName) == false) goto L12;
        r1 = h(r111, (Uri) r19[0]);     // Catch: Throwable -> L48
        goto L52
    L12:
        StartType r112 = StartType.PROVIDER_QUERY;     // Catch: Throwable -> L48
        if (TextUtils.equals(r0, r112.methodName) == false) goto L33;
        Object r42 = r19[2];     // Catch: Throwable -> L48
        if ((r42 instanceof String) == false) goto L19;
        String r43 = (String) r42;     // Catch: Throwable -> L48
        if (TextUtils.equals(r43, this.b) == false) goto L22;
        String r113 = this.b;     // Catch: Throwable -> L48
    L25:
        if (TextUtils.isEmpty(r43) == true) goto L47;
        pqa.a r114 = g(r112, r43);     // Catch: Throwable -> L48
    L31:
        th = th;
    L50:
        f.f("AssociationStartMonitorService", "error when parse startRecord ", th);
    L51:
        r1 = r114;
        goto L52
    L28:
        if (TextUtils.isEmpty(r113) == true) goto L51;
        r114.c = r113;     // Catch: Throwable -> L31
    L47:
        r1 = null;
    L22:
        r113 = "";
        goto L25
    L19:
        Object r44 = r19[1];     // Catch: Throwable -> L48
        if ((r44 instanceof String) == false) goto L23;
        r43 = (String) r44;     // Catch: Throwable -> L48
        goto L22
    L23:
        r43 = "";
        r113 = r43;
        goto L25
    L33:
        StartType r115 = StartType.SEND_BROADCAST;     // Catch: Throwable -> L48
        if (TextUtils.equals(r0, r115.methodName) == false) goto L36;
        r1 = f(r115, (Intent) r19[1]);     // Catch: Throwable -> L48
        goto L52
    L36:
        StartType r116 = StartType.START_ACTIVITY;     // Catch: Throwable -> L48
        if (TextUtils.equals(r0, r116.methodName) == false) goto L47;
        Object r45 = r19[3];     // Catch: Throwable -> L48
        if ((r45 instanceof Intent) == false) goto L41;
        Intent r46 = (Intent) r45;     // Catch: Throwable -> L48
    L45:
        r1 = f(r116, r46);     // Catch: Throwable -> L48
        goto L52
    L41:
        Object r47 = r19[2];     // Catch: Throwable -> L48
        if ((r47 instanceof Intent) == false) goto L44;
        r46 = (Intent) r47;     // Catch: Throwable -> L48
        goto L45
    L44:
        r46 = null;
    L48:
        th = th;
        r114 = null;
        goto L50
    }
}
