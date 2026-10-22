package vxb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.ee.lark.infra.sandbox.context.BizType;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import com.bytedance.ee.lark.infra.sandbox.context.IBaseService;
import com.bytedance.ee.lark.plugin_annotation.bean.LKOpenApiBizDomain;
import com.larksuite.component.openplatform.plugins.config.LKOpenApiAccessConfig;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.tt.refer.common.base.AppType;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import l18.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class b implements IAppContext {
    public final Context a;
    public volatile Activity b;
    public volatile String c;
    public volatile String d;
    public volatile Object e;
    public volatile j18.b f;
    public volatile LKOpenApiAccessConfig g;
    public final Map<String, IBaseService> h;
    public final Map<Class, fs5.c> i;
    public final d j;
    public final a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile fs5.b n;
    public volatile String o;
    public volatile OPTrace p;
    public jz7.a q;
    public boolean r;
    public String s;
    public int t;
    public final Map<String, IAppContext> u;
    public boolean v;

    public abstract void c();

    public final synchronized void destroy() {
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L4:
        if (this.l == false) goto L6;
    L35:
        Log.i("AppContextImpl", "this appContext is destroyed or destroying.");     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L6:
        if (this.m == true) goto L35;
        this.m = true;     // Catch: Throwable -> L38
        Iterator r1 = ((ConcurrentHashMap) this.u).keySet().iterator();     // Catch: Throwable -> L38
    L10:
        if (r1.hasNext() == false) goto L14;
        IAppContext r2 = (IAppContext) ((ConcurrentHashMap) this.u).get((String) r1.next());     // Catch: Throwable -> L38
        if (r2 == null) goto L10;
        r2.destroy();     // Catch: Throwable -> L38
        goto L10
    L14:
        ((ConcurrentHashMap) this.u).clear();     // Catch: Throwable -> L38
        this.n = null;     // Catch: Throwable -> L38
        d r3 = this.j;     // Catch: Throwable -> L38
        if (r3 == null) goto L17;
        r3.a();     // Catch: Throwable -> L38
    L17:
        a r4 = this.k;     // Catch: Throwable -> L38
        if (r4 == null) goto L20;
        r4.a();     // Catch: Throwable -> L38
    L20:
        this.c = null;     // Catch: Throwable -> L38
        Map<String, IBaseService> r5 = this.h;     // Catch: Throwable -> L38
        Map<AppType, yxb.a> r6 = zxb.a.a;     // Catch: Throwable -> L38
        ConcurrentHashMap r7 = (ConcurrentHashMap) r5;     // Catch: Throwable -> L38
        if (r7.size() <= 0) goto L29;
        Iterator r8 = r7.values().iterator();     // Catch: Throwable -> L38
    L24:
        if (r8.hasNext() == false) goto L29;
        yxb.c r9 = (IBaseService) r8.next();     // Catch: Throwable -> L38
        if ((r9 instanceof yxb.c) == false) goto L28;
        r9.unregister();     // Catch: Throwable -> L38
    L28:
        r9.release();     // Catch: Throwable -> L38
    L29:
        this.b = null;     // Catch: Throwable -> L38
        c();     // Catch: Throwable -> L38
        Log.i("AppContextImpl", "appContext destroyed: " + android.util.Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L38
        this.f = null;     // Catch: Throwable -> L38
        jz7.a r10 = this.q;     // Catch: Throwable -> L38
        if (r10 == null) goto L32;
        r10.e();     // Catch: Throwable -> L38
    L32:
        this.q = null;     // Catch: Throwable -> L38
        ((ConcurrentHashMap) this.i).clear();     // Catch: Throwable -> L38
        this.l = true;     // Catch: Throwable -> L38
        monitor-exit(this);
    }

    public final void startDestroy() {
        this.m = true;
    }

    public final String toString() {
        monitor-enter(this);
        String r0 = b();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final String b() {
        StringBuilder r0 = new StringBuilder("AppContextWrapper{context=");
        r0.append(this.a);
        r0.append(", currentActivity=");
        r0.append(this.b);
        r0.append(", appId='");
        r0.append(this.c);
        r0.append("', mAppIdentify='");
        r0.append(this.d);
        r0.append("', mAppContainer=");
        r0.append(this.f);
        r0.append(", mApiAccessConfig=");
        if (this.g == null) goto L5;
        String r1 = this.g.toString();
    L6:
        r0.append(r1);
        r0.append(", appServiceMap=");
        r0.append(this.h);
        r0.append(", serviceManager=");
        r0.append(this.j);
        r0.append(", iAppContextBundle=");
        r0.append(this.k);
        r0.append(", isDestroyed=");
        r0.append(this.l);
        r0.append(", isDestroying=");
        r0.append(this.m);
        r0.append(", gadgetInteractiveProxy=");
        r0.append(this.n);
        r0.append(", mTraceId='");
        r0.append(this.o);
        r0.append("', mTraceSpan=");
        r0.append(this.p);
        r0.append("}");
        return r0.toString();
    L5:
        r1 = "";
        goto L6
    }

    public final LKOpenApiAccessConfig getApiAccessConfig() {
        if (this.g != null) goto L6;
        LKOpenApiBizDomain r0 = LKOpenApiBizDomain.OPEN_PLATFORM;
        LKOpenApiAccessConfig r1 = new LKOpenApiAccessConfig(null);
        LKOpenApiAccessConfig.access$102(r1, r0);
        LKOpenApiAccessConfig.access$202(r1, true);
        LKOpenApiAccessConfig.access$302(r1, "");
        LKOpenApiAccessConfig.access$402(r1, null);
        this.g = r1;
    L6:
        return this.g;
    }

    public final i18.c getBridgeContext() {
        jz7.a r0 = this.f;
        if (r0 != null) goto L5;
        Log.i("AppContextImpl", "use basePM.");
        r0 = this.q;
    L5:
        if (r0 != null) goto L7;
        Log.e("AppContextImpl", "not set core node");
        return null;
    L7:
        return r0.getBridgeContext();
    }

    public final Activity getCurrentActivity() {
        if (this.b != null) goto L6;
        Log.e("AppContextImpl", "currentActivity is null");
    L6:
        return this.b;
    }

    public final j18.b getCurrentNode() {
        j18.b r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.q;
    }

    public final void initTrace() {
        if (this.p != null) goto L6;
        this.p = gyb.a.a();
        this.o = this.p.getTracingID();
        return;
    }

    public final boolean isEmbedContainer() {
        return TextUtils.equals(this.s, "embed");
    }

    public final boolean isNewContainer() {
        if (this.r == false) goto L5;
    L10:
        return true;
    L5:
        if (isEmbedContainer() == true) goto L10;
        if (isPanelContainer() == true) goto L10;
        return false;
    }

    public final boolean isPanelContainer() {
        return TextUtils.equals(this.s, "panel");
    }

    public final boolean isPanelOrEmbedContainer() {
        if (isPanelContainer() == false) goto L5;
    L8:
        return true;
    L5:
        if (isEmbedContainer() == true) goto L8;
        return false;
    }

    public final void unRegisterOnResultAllPlugin() {
        j18.b r0 = getCurrentNode();
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public final j18.b getAppContainer() {
        return this.f;
    }

    public final String getAppId() {
        return this.c;
    }

    public final String getAppIdentify() {
        return this.d;
    }

    public final Context getApplicationContext() {
        return this.a;
    }

    public final BizType getBizType() {
        return BizType.UNKNOWN;
    }

    public final String getContainerType() {
        return this.s;
    }

    public final int getCurrentTheme() {
        return this.t;
    }

    public final jz7.a getDefaultPluginContainer() {
        return this.q;
    }

    public final <T> T getExtra() {
        return (T) this.e;
    }

    public final fs5.b getGadgetInteractiveProxy() {
        return this.n;
    }

    public final String getTraceId() {
        return this.o;
    }

    public final OPTrace getTracingSpan() {
        return this.p;
    }

    public final boolean isDestroyed() {
        return this.l;
    }

    public final boolean isDestroying() {
        return this.m;
    }

    public final boolean needClearTempDir() {
        return this.v;
    }

    public b(Context r2) {
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = new d();
        this.k = new a();
        this.l = false;
        this.m = false;
        this.t = 0;
        this.u = new ConcurrentHashMap();
        this.v = true;
        this.a = r2;
        initTrace();
    }

    public final void bindAppContainer(j18.b r1) {
        this.f = r1;
        if (this.f == null) goto L6;
        this.r = true;
        return;
    }

    public final <T extends fs5.c> T findService(Class<T> r2) {
        return (T) ((ConcurrentHashMap) this.i).get(r2);
    }

    public final <T extends IBaseService> T findServiceByInterface(Class<T> r8) {
        Map<String, IBaseService> r0 = this.h;
        Map<AppType, yxb.a> r1 = zxb.a.a;
        String r2 = r8.getCanonicalName();
        if (r2 == null) goto L39;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r0;
        T r4 = (T) r3.get(r2);
        Object r5 = null;
        if (r4 == null) goto L8;
    L25:
        if (r4 == null) goto L27;
        return r4;
    L27:
        d r6 = this.j;
        if (r6 != null) goto L30;
        return null;
    L30:
        if (((ConcurrentHashMap) r6.a).containsKey(r8) == true) goto L32;
        AppBrandLogger.e("ServiceManagerImpl", new Object[]{"service name is not register:".concat(r8.getName())});
    L34:
        return (T) r5;
    L32:
        r5 = ((ConcurrentHashMap) r6.a).get(r8);
        goto L34
    L8:
        if (getAppType() != null) goto L10;
        AppBrandLogger.w("ModuleManager", new Object[]{"appContext.AppType is null"});
    L23:
        r4 = null;
        goto L25
    L10:
        monitor-enter(r8);
        r4 = (T) r3.get(r2);     // Catch: Throwable -> L35
        if (r4 != null) goto L24;
        yxb.a r7 = (yxb.a) ((ConcurrentHashMap) zxb.a.a).get(getAppType());     // Catch: Throwable -> L35
        if (r7 == null) goto L22;
        r4 = (T) r7.a();
        if (r4 == null) goto L20;
        r3.put(r2, r4);     // Catch: Throwable -> L35
        monitor-exit(r8);     // Catch: Throwable -> L35
        goto L25
    L20:
        monitor-exit(r8);     // Catch: Throwable -> L35
        goto L23
    L22:
        monitor-exit(r8);     // Catch: Throwable -> L35
        goto L23
    L24:
        monitor-exit(r8);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L39:
        throw new RuntimeException("getService fail : className is null");
    }

    public final <T> T getExtra(String r3) {
        a r0 = this.k;
        if (((ConcurrentHashMap) r0.a).containsKey(r3) == false) goto L7;
        T r4 = (T) ((ConcurrentHashMap) r0.a).get(r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return null;
    }

    public final void putExtras(fs5.a r3) {
        a r0 = this.k;
        r0.getClass();
        monitor-enter(a.class);
        Map<String, Object> r1 = r0.a;     // Catch: Throwable -> L7
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;     // Catch: Throwable -> L7
        r2.putAll(((a) r3).a);     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void removeExtra(String r3) {
        a r0 = this.k;
        if (((ConcurrentHashMap) r0.a).containsKey(r3) == false) goto L6;
        ((ConcurrentHashMap) r0.a).remove(r3);
        return;
    }

    public LKBasePluginResult sendEvent(LKEvent r10) {
        j18.b r0 = getCurrentNode();
        p18.b.a r1 = r10.m.b;
        boolean r3 = true;
        if ((r0 instanceof jz7.a) == true) goto L5;
    L8:
        if (r0 == null) goto L31;
        if ((r0 instanceof wxb.a) == true) goto L29;
        if (r1 == null) goto L14;
        r1.i("AppContextImpl", new Object[]{"bind appContext to LKEvent"});
    L15:
        p18.b.a r2 = r10.c();
        if (r2 == null) goto L18;
        r2.d("LKEvent", new Object[]{"setFindServiceContext"});
    L19:
        r10.h = this;
        e r4 = r0.getBridgeContext();
        if ((r4 instanceof e) == false) goto L29;
        if (r1 == null) goto L27;
        Object[] r6 = new Object[1];
        StringBuilder r7 = new StringBuilder("current activity:");
        if (getCurrentActivity() == null) goto L26;
        r3 = false;
    L26:
        r7.append(r3);
        r6[0] = r7.toString();
        r1.i("AppContextImpl", r6);
    L27:
        r4.a(getCurrentActivity());
        goto L29
    L18:
        Log.d("LKEvent", "setFindServiceContext");
        goto L19
    L14:
        Log.i("AppContextImpl", "bind appContext to LKEvent");
    L29:
        return r0.sendEvent(r10);
    L31:
        if (r1 == null) goto L33;
        r1.i("AppContextImpl", new Object[]{"core node is null"});
    L35:
        return LKBasePluginResult.f;
    L33:
        Log.i("AppContextImpl", "core node is null");
        goto L35
    L5:
        if (r1 == null) goto L7;
        r1.i("AppContextImpl", new Object[]{"eventName:" + r10.a + " use basePM"});
        goto L8
    L7:
        Log.i("AppContextImpl", "eventName:" + r10.a + " use basePM");
        goto L8
    }

    public final void setApiAccessConfig(LKOpenApiAccessConfig r1) {
        this.g = r1;
    }

    public final void setAppId(String r1) {
        this.c = r1;
    }

    public final void setAppIdentify(String r1) {
        this.d = r1;
    }

    public final void setContainerType(String r1) {
        this.s = r1;
    }

    public final void setCurrentActivity(Activity r1) {
        this.b = r1;
    }

    public final void setCurrentTheme(int r1) {
        this.t = r1;
    }

    public final void setDefaultPluginContainer(jz7.a r1) {
        this.q = r1;
    }

    public final void setExtra(Object r1) {
        this.e = r1;
    }

    public final void setGadgetInteractiveProxy(fs5.b r1) {
        this.n = r1;
    }

    public final void setNeedClearTempDir(boolean r1) {
        this.v = r1;
    }

    public final void setTracingSpan(OPTrace r1) {
        this.p = r1;
    }

    public final void unRegisterOnResultPlugin(i18.d r2) {
        j18.b r0 = getCurrentNode();
        if (r0 == null) goto L6;
        r0.d(r2);
        return;
    }

    public final LKBasePluginResult sendEvent(String r2) {
        return sendEvent(r2, null, null);
    }

    public final void bindDependAppContext(String r4, IAppContext r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (((ConcurrentHashMap) this.u).containsKey(r5.getAppId() + r4) == true) goto L8;
        ((ConcurrentHashMap) this.u).put(r5.getAppId() + r4, r5);
        return;
    }

    public final IAppContext getBoundDependAppContext(String r3, String r4) {
        return (IAppContext) ((ConcurrentHashMap) this.u).get(r3 + r4);
    }

    public final <T> void putExtra(String r3, T r4) {
        a r0 = this.k;
        r0.getClass();
        monitor-enter(a.class);
        ((ConcurrentHashMap) r0.a).put(r3, r4);     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final <T extends IBaseService> boolean registerService(Class<T> r7, T r8) {
        boolean r0 = r8 instanceof c;
        if (r0 == false) goto L5;
        ((c) r8).a = this;
    L5:
        d r1 = this.j;
        if (r1 == null) goto L17;
        if (r0 == false) goto L16;
        AppBrandLogger.i("ServiceManagerImpl", new Object[]{"register service:".concat(r7.getName())});
        if (r7.getName().contains("com.ss.android.lark.openplatform.common.service.AppSingletonInstance") == false) goto L12;
        AppBrandLogger.e("falcon ", new Object[]{r7.getName() + " registerService success onAppRoute  mServices:" + r1});
    L12:
        if (((ConcurrentHashMap) r1.a).put(r7, r8) != null) goto L18;
        return true;
    L18:
        return false;
    L16:
        throw new InvalidParameterException("register failed,need serviceImpl instance BaseService serviceName:".concat(r7.getName()));
    L17:
        return false;
    }

    public final void sendEvent(String r3, Bundle r4) {
        AppBrandLogger.i("AppContextImpl", new Object[]{"action: " + r3});
    }

    public void startActivityForResult(Intent r3, int r4) {
        xxb.a r0 = this.f;
        if ((r0 instanceof xxb.a) == false) goto L5;
        fs5.b r1 = r0.b();
    L6:
        if (r1 == null) goto L8;
    L15:
        if (r1 == null) goto L17;
        r1.startActivityForResult(r3, r4);
        return;
    L17:
        this.b.startActivityForResult(r3, r4);
        return;
    L8:
        if ((this instanceof mjb.a) == true) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L15;
        r1 = this.n;
        goto L15
    L10:
        if (((mjb.a) this).a() == false) goto L12;
        r2 = true;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void unBindDependAppContext(String r3, IAppContext r4) {
        if (r4 == null) goto L5;
        ((ConcurrentHashMap) this.u).remove(r4.getAppId() + r3);
        return;
    }

    public final void registerService(Class r2, fs5.c r3) {
        ((ConcurrentHashMap) this.i).put(r2, r3);
    }

    public final LKBasePluginResult sendEvent(String r2, JSONObject r3) {
        return sendEvent(r2, r3, null);
    }

    public final LKBasePluginResult sendEvent(String r3, JSONObject r4, j18.c r5) {
        j18.b r0 = getCurrentNode();
        if (r0 == null) goto L10;
        LKEvent.b r1 = new LKEvent.b();
        r1.a = r3;
        r1.b = r4;
        r1.c = r0.getContext();
        LKEvent r6 = new LKEvent(r1);
        if (r5 == null) goto L8;
        r6.g = r5;
    L8:
        return sendEvent(r6);
    L10:
        return LKBasePluginResult.f;
    }
}
