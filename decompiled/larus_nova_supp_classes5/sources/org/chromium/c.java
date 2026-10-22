package org.chromium;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend;
import com.bytedance.ttnet.cronet.AbsCronetDependAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static volatile c d;
    public Object a;
    public ICronetAppProvider b;
    public ICronetDepend c;

    public final List<String> a() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getAbSdkVersion();
    L10:
        Object r2 = this.a;     // Catch: Throwable -> L15
        if (r2 != null) goto L14;
        return null;
    L14:
        return (List) yx5.a.b(r2).call("getAbSdkVersion").get();
    }

    public final String b() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getBypassBOEJSON();
    L10:
        Object r2 = this.a;     // Catch: Throwable -> L15
        if (r2 != null) goto L14;
        return null;
    L14:
        return (String) yx5.a.b(r2).call("getBypassBOEJSON").get();
    }

    public final String c() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getCronetSoPath();
    L10:
        Object r2 = this.a;     // Catch: Throwable -> L15
        if (r2 != null) goto L14;
        return null;
    L14:
        return (String) yx5.a.b(r2).call("getCronetSoPath").get();
    }

    public final String d() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getStoreIdcRuleJSON();
    L10:
        Object r2 = this.a;     // Catch: Throwable -> L15
        if (r2 != null) goto L14;
        return null;
    L14:
        return (String) yx5.a.b(r2).call("getStoreIdcRuleJSON").get();
    }

    public final Map<String, String> f() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getTNCRequestHeader();
    L10:
        Object r2 = this.a;     // Catch: Throwable -> L15
        if (r2 != null) goto L14;
        return null;
    L14:
        return (Map) yx5.a.b(r2).call("getTNCRequestHeader").get();
    }

    public final Map<String, String> g() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return null;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getTNCRequestQuery();
    L10:
        Object r2 = this.a;     // Catch: Throwable -> L15
        if (r2 != null) goto L14;
        return null;
    L14:
        return (Map) yx5.a.b(r2).call("getTNCRequestQuery").get();
    }

    public final boolean i() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.isBOEProxyEnabled();
    L10:
        Object r2 = this.a;     // Catch: Throwable -> L15
        if (r2 != null) goto L14;
        return false;
    L14:
        return ((Boolean) yx5.a.b(r2).call("isBOEProxyEnabled").get()).booleanValue();
    }

    public final boolean j() {
    L15:
        th = move-exception;
        th.printStackTrace();
        return false;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L10;
        ICronetAppProvider r1 = this.b;     // Catch: Throwable -> L15
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.needCustomLoadLibrary();
    L10:
        Object r2 = this.a;     // Catch: Throwable -> L15
        if (r2 != null) goto L14;
        return false;
    L14:
        return ((Boolean) yx5.a.b(r2).call("needCustomLoadLibrary").get()).booleanValue();
    }

    public static c h() {
        if (d != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public c() {
    }

    public final String e(String r3) {
        Object r1 = this.a;     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return "";
    L6:
        return (String) yx5.a.b(r1).call(r3).get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public final void l(AbsCronetDependAdapter r4) {
        if (r4 == null) goto L19;
        List r0 = i.a(r4.getClass());     // Catch: Throwable -> L25
        if (r0 == null) goto L17;
        ArrayList r1 = (ArrayList) r0;     // Catch: Throwable -> L25
        if (r1.isEmpty() == true) goto L33;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L25
    L10:
        if (r2.hasNext() == false) goto L19;
        if ("com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider".equals(((Class) r2.next()).getName()) == false) goto L10;
        if (d.a().loggerDebug() == false) goto L16;
        d.a().loggerD("CronetAppProviderManager", "inject CronetAppProviderManager success");     // Catch: Throwable -> L25
    L16:
        this.a = r4;     // Catch: Throwable -> L25
        goto L19
    L33:
        return;
    L17:
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L19:
        if ((r4 instanceof ICronetAppProvider) == false) goto L22;
        this.b = r4;     // Catch: Throwable -> L25
    L22:
        if ((r4 instanceof ICronetDepend) == false) goto L34;
        this.c = r4;     // Catch: Throwable -> L25
        return;
    }

    public final void k(String r8, String r9) {
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "Send monitor json = " + r8 + ", log type =" + r9);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r0 = this.b;     // Catch: Throwable -> L16
        if (r0 != null) goto L10;
        return;
    L10:
        r0.sendAppMonitorEvent(r8, r9);     // Catch: Throwable -> L16
        return;
    L11:
        Object r1 = this.a;     // Catch: Throwable -> L16
        if (r1 != null) goto L14;
        return;
    L14:
        yx5.a.b(r1).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r8, r9});     // Catch: Throwable -> L16
    }
}
