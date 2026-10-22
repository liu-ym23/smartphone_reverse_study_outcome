package l18;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.larksuite.framework.apiplugin.entity.LKPluginInterceptResult;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class a implements j18.b {
    public h a;
    public final c b;
    public final g c;
    public p18.a d;
    public final p18.b.a e;

    @Override // j18.b
    public abstract /* synthetic */ Context getContext();

    @Override // j18.b
    public final void getParent() {
    }

    @Override // j18.b
    public final void c() {
        ((ArrayList) this.c.a).clear();
    }

    @Override // j18.b
    public final i18.c getBridgeContext() {
        if (this.d != null) goto L6;
        this.e.i("LKCoreTarget", new Object[]{"build bridge context"});
        this.d = new p18.a(this);
    L6:
        return this.d;
    }

    public a() {
        p18.b.a r0 = new p18.b.a(gyb.a.a().subTrace());
        this.e = r0;
        g r1 = new g();
        this.c = r1;
        h r2 = new h(r1);
        r2.d = r0;
        this.a = r2;
        new ArrayList();
        this.b = new c();
    }

    @Override // j18.h
    public final LKPluginInterceptResult a(LKEvent r5) {
        h r0 = this.a;
        if (r0 == null) goto L9;
        return r0.a(r5);
    L6:
        e = move-exception;
        this.e.e("LKCoreTarget", new Object[]{"interceptEvent exception", e});
    L9:
        return LKPluginInterceptResult.g;
    }

    @Override // j18.b
    public final void d(i18.d r2) {
        ((ArrayList) this.c.a).remove(r2);
    }

    @Override // j18.g
    public final LKPluginHandleResult handleEvent(LKEvent r5) {
        h r0 = this.a;
        if (r0 == null) goto L9;
        return r0.handleEvent(r5);
    L6:
        e = move-exception;
        this.e.e("LKCoreTarget", new Object[]{"handleEvent exception", e});
    L9:
        return LKPluginHandleResult.g;
    }

    @Override // j18.b
    public final LKBasePluginResult sendEvent(LKEvent r15) {
        r15.e(this);
        this.b.getClass();
        if (r15.c != null) goto L5;
        ((p18.b.a) c.a(r15)).i("LKEventDispatcher", new Object[]{"source node is null"});
        boolean r0 = false;
    L6:
        if (r0 == true) goto L8;
        ((p18.b.a) c.a(r15)).i("LKEventDispatcher", new Object[]{"invalid event."});
        return LKBasePluginResult.f;
    L8:
        String r1 = r15.a;
        if (TextUtils.isEmpty(r1) == false) goto L11;
        ((p18.b.a) c.a(r15)).e("LKEventDispatcher", new Object[]{"eventName is empty!"});
        return LKBasePluginResult.f;
    L11:
        j18.b r4 = r15.c;
        ArrayList r5 = new ArrayList();
    L12:
        if (r4 == null) goto L15;
        r5.add(r4);
        r4.getParent();
        r4 = null;
        goto L12
    L15:
        if (r5.isEmpty() == false) goto L17;
        ((p18.b.a) c.a(r15)).e("LKEventDispatcher", new Object[]{"target list is empty!"});
        return LKBasePluginResult.f;
    L17:
        int r6 = r5.size();
        p18.b.a r7 = (p18.b.a) c.a(r15);
        r7.i("LKEventDispatcher", new Object[]{"event: " + r1 + " targetList size:" + r6});
        int r8 = r6 + (-1);
    L19:
        if (r8 < 0) goto L28;
        j18.h r9 = (j18.h) ListProtector.get(r5, r8);
        LKBasePluginResult r10 = r9.a(r15);     // Catch: Exception -> L25
        if (r10.a == false) goto L27;
        r7.i("LKEventDispatcher", new Object[]{"intercept:" + r9.getClass().getName()});     // Catch: Exception -> L25
    L56:
        return r10;
    L27:
        r8 = r8 - 1;
    L25:
        e = move-exception;
        r7.i("LKEventDispatcher", new Object[]{"dispatch intercept exception", e});
        goto L27
    L28:
        int r11 = 0;
    L29:
        if (r11 >= r6) goto L38;
        j18.h r12 = (j18.h) ListProtector.get(r5, r11);
        r10 = r12.handleEvent(r15);     // Catch: Exception -> L35
        if (r10.a == false) goto L37;
        r7.i("LKEventDispatcher", new Object[]{"success handle:" + r12.getClass().getName()});     // Catch: Exception -> L35
    L37:
        r11 = r11 + 1;
    L35:
        e = move-exception;
        r7.e("LKEventDispatcher", new Object[]{"dispatch handle exception", e});
        goto L37
    L38:
        r7.i("LKEventDispatcher", new Object[]{"[" + r1 + "] handled by nobody"});
        return LKBasePluginResult.f;
    L5:
        r0 = true;
        goto L6
    }
}
