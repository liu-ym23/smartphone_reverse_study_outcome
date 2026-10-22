package jz7;

import android.content.Context;
import com.larksuite.component.openplatform.plugins.config.LKOpenApiAccessConfig;
import com.larksuite.component.openplatform.plugins.config.LKPluginConfig;
import com.ss.android.lark.log.Log;
import i18.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import l18.g;
import l18.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a extends l18.a {
    public lz7.a f;
    public final LKOpenApiAccessConfig g;
    public Context h;

    public final void b() {
        h r0 = this.a;
        LKOpenApiAccessConfig r1 = this.g;
        iz7.b r2 = null;
        if (r1 != null) goto L6;
        Log.e("AbsPluginManagerContainer", "open api access config is null");
        r1 = null;
    L6:
        lz7.a r3 = this.f;
        r3.getClass();
        if (r0 != null) goto L10;
        Log.e("OPPluginProviderImpl", "plugin manager is null");
    L12:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L21;
        Log.i("OPPluginProviderImpl", "scope:null");
        ArrayList r4 = new ArrayList();
        Iterator<LKPluginConfig> r6 = r3.a.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        LKPluginConfig r7 = r6.next();
        Log.d("OPPluginProviderImpl", "load config:" + r7.toString());
        r4.add(r7);
        goto L18
    L20:
        r2 = new iz7.b(r4, r0, r1);
    L21:
        if (r2 == null) goto L25;
        this.a.b(r2);
        return;
    L25:
        return;
    L10:
        if (r3.a.isEmpty() == false) goto L13;
        Log.i("OPPluginProviderImpl", "no add plugin config, pluginConfigs is empty!");
        goto L12
    L13:
        r5 = false;
        goto L14
    }

    public final void e() {
        this.e.i("LKCoreTarget", new Object[]{"onRelease"});
        h r0 = this.a;
        if (r0 == null) goto L16;
        r0.d.i("LKPluginManagerImpl", new Object[]{"onRelease"});
        Object r2 = r0.e;
        monitor-enter(r2);
        Iterator r3 = ((ArrayList) r0.a).iterator();     // Catch: Throwable -> L13
    L8:
        if (r3.hasNext() == false) goto L10;
        ((d) r3.next()).onRelease();     // Catch: Throwable -> L13
        goto L8
    L10:
        ((ArrayList) r0.a).clear();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        ((HashMap) r0.b).clear();
        ((ArrayList) ((g) r0.c).a).clear();
        this.a = null;
    L13:
        th = move-exception;
        throw th;
    L16:
        p18.a r1 = this.d;
        if (r1 == null) goto L19;
        r1.b();
        this.d = null;
    L19:
        this.h = null;
    }

    @Override // l18.a, j18.b
    public Context getContext() {
        return this.h;
    }

    public a(Context r4) {
        this.h = r4;
        this.g = null;
        this.f = new lz7.a();
        if (iz7.a.b == null) goto L5;
    L14:
        Iterator<LKPluginConfig> r5 = iz7.a.b.a.iterator();
    L16:
        if (r5.hasNext() == false) goto L24;
        LKPluginConfig r0 = r5.next();
        lz7.a r1 = this.f;
        r1.getClass();
        if (r0 == null) goto L23;
        if (r0.configInvalid() == true) goto L23;
        r1.a.add(r0);
    L23:
        Log.e("OPPluginProviderImpl", "invalid params!");
        goto L16
    L24:
        Log.i("AbsPluginManagerContainer", "plugin env is null ,so inject all plugins");
        b();
        return;
    L5:
        monitor-enter(iz7.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (iz7.a.b != null) goto L9;
        iz7.a.b = new iz7.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(iz7.a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
