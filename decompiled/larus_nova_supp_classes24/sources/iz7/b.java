package iz7;

import com.larksuite.component.openplatform.plugins.config.LKOpenApiAccessConfig;
import com.larksuite.component.openplatform.plugins.config.LKPluginConfig;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.larksuite.framework.apiplugin.entity.LKPluginInterceptResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import i18.d;
import j18.e;
import j18.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import l18.f;
import l18.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends f {
    public l a;
    public final Map<String, List<a>> b;
    public final LKOpenApiAccessConfig c;

    public static class a {
        public d a;
        public List<LKOpenApiAccessConfig> b;
        public String c;
        public volatile boolean d;

        public a() {
        }
    }

    @Override // i18.d
    public final void onRelease() {
        this.a = null;
        Map<String, List<a>> r0 = this.b;
        if (r0 == null) goto L34;
        Iterator r1 = ((HashMap) r0).keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        String r2 = (String) r1.next();
        List r3 = (List) ((HashMap) this.b).get(r2);
        if (r3 == null) goto L6;
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L6;
        a r5 = (a) r4.next();
        if (r5 == null) goto L11;
        if (r5.a == null) goto L11;
        if (r5.d == true) goto L11;
        r5.a.onRelease();
        goto L11
    L19:
        ((HashMap) this.b).clear();
        return;
    }

    @Override // l18.f, j18.h
    public final LKPluginInterceptResult a(LKEvent r10) {
        String r0 = r10.a;
        List<a> r1 = (List) ((HashMap) this.b).get(r0);
        if (r1 != null) goto L5;
    L34:
        Log.i("OPPluginProxy", "invalid proxyInfos:" + r0);
        return LKPluginInterceptResult.g;
    L5:
        if (r1.isEmpty() == true) goto L34;
        List<d> r2 = e(r10, r1);
        ArrayList r3 = (ArrayList) r2;
        if (r3.isEmpty() == false) goto L12;
        Log.i("OPPluginProxy", "proceed to plugin：" + r0);
        return LKPluginInterceptResult.g;
    L12:
        if (r3.size() <= 1) goto L14;
        Collections.sort(r2);
    L14:
        ListIterator r4 = r3.listIterator();
    L16:
        if (r4.hasNext() == false) goto L19;
        r4.next();
    L19:
        if (r4.hasPrevious() == false) goto L32;
        d r5 = (d) r4.previous();
        LKPluginInterceptResult r6 = LKPluginInterceptResult.g;
    L25:
        e = move-exception;
        Log.e("OPPluginProxy", "interceptEvent exception.", e);
    L28:
        if (r6.a == true) goto L30;
        Log.i("OPPluginProxy", "[" + r0 + "] intercept pass " + r5.getClass().getName());
        goto L19
    L30:
        Log.i("OPPluginProxy", "[" + r0 + "] intercepted by " + r5.getClass().getName());
        return r6;
    L22:
        if ((r5 instanceof f) == false) goto L28;
        r6 = ((f) r5).a(r10);     // Catch: Exception -> L25
        goto L28
    L32:
        Log.i("OPPluginProxy", "[" + r0 + "] intercept pass ");
        return LKPluginInterceptResult.g;
    }

    @Override // i18.d
    public final void addEvents(e r4) {
        Iterator r0 = ((HashMap) this.b).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        ((ArrayList) ((l18.d) r4).a).add(r1);
        goto L4
    }

    @Override // i18.d, j18.g
    public final LKPluginHandleResult handleEvent(LKEvent r10) {
        String r0 = r10.a;
        List<a> r1 = (List) ((HashMap) this.b).get(r0);
        if (r1 == null) goto L33;
        if (r1.isEmpty() == true) goto L33;
        List<d> r2 = e(r10, r1);
        ArrayList r3 = (ArrayList) r2;
        if (r3.isEmpty() == false) goto L12;
        Log.i("OPPluginProxy", "proceed to plugin：" + r0);
        return LKPluginHandleResult.g;
    L12:
        if (r3.size() <= 1) goto L14;
        Collections.sort(r2);
    L14:
        ListIterator r4 = r3.listIterator();
    L16:
        if (r4.hasNext() == false) goto L19;
        r4.next();
    L19:
        if (r4.hasPrevious() == false) goto L30;
        d r5 = (d) r4.previous();
        LKPluginHandleResult r6 = LKPluginHandleResult.g;
        r6 = r5.handleEvent(r10);     // Catch: Exception -> L23
    L26:
        if (r6.a == true) goto L28;
        Log.i("OPPluginProxy", "[" + r0 + "] handle pass " + r5.getClass().getName());
        goto L19
    L28:
        Log.i("OPPluginProxy", "[" + r0 + "] handle by " + r5.getClass().getName());
        return r6;
    L23:
        e = move-exception;
        Log.e("OPPluginProxy", "handle exception.", e);
        goto L26
    L30:
        Log.i("OPPluginProxy", "[" + r0 + "] handle pass ");
        return LKPluginHandleResult.g;
    L33:
        return LKPluginHandleResult.g;
    }

    public final d b(a r7, boolean r8) {
        if (r7.a == null) goto L10;
        if (r8 == false) goto L9;
        if (r7.d == true) goto L9;
        ((h) this.a).b(r7.a);
        r7.d = true;
    L9:
        return r7.a;
    L10:
        String r1 = r7.c;
        Class r2 = mz7.a.a(r1);     // Catch: ClassNotFoundException -> L13
    L14:
        if (r2 != null) goto L28;
    L25:
        return null;
    L28:
        Object r3 = r2.newInstance();     // Catch: InstantiationException -> L21 IllegalAccessException -> L23
        if ((r3 instanceof d) == false) goto L25;
        d r4 = (d) r3;     // Catch: InstantiationException -> L21 IllegalAccessException -> L23
        r7.a = r4;     // Catch: InstantiationException -> L21 IllegalAccessException -> L23
        if (r8 == false) goto L20;
        ((h) this.a).b(r4);     // Catch: InstantiationException -> L21 IllegalAccessException -> L23
        r7.d = true;     // Catch: InstantiationException -> L21 IllegalAccessException -> L23
    L20:
        return r4;
    L23:
        e = move-exception;
        Log.e("OPPluginProxy", "IllegalAccessException", e);
    L21:
        e = move-exception;
        Log.e("OPPluginProxy", "InstantiationException", e);
    L13:
        Log.w("PluginUtils", "cls not found!! classPath:" + r1);
        r2 = null;
        goto L14
    }

    public final List<d> e(LKEvent r9, List<a> r10) {
        ArrayList r0 = new ArrayList();
        Iterator<a> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L32;
        a r1 = r11.next();
        if (r1.d == true) goto L4;
        if (CollectionUtils.isEmpty(r1.b) == false) goto L9;
        Log.d("OPPluginProxy", "not set OpenConditions:" + r1.toString());
        d r2 = b(r1, true);
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L9:
        Iterator<LKOpenApiAccessConfig> r3 = r1.b.iterator();
    L11:
        if (r3.hasNext() == false) goto L4;
        LKOpenApiAccessConfig r5 = r3.next();
        LKOpenApiAccessConfig r6 = this.c;
        if (r6 != null) goto L15;
        Log.i("OPPluginProxy", "container not set ApiAccessConfig:" + r5.toString());
        goto L11
    L15:
        if (r6.getDomain() != r5.getDomain()) goto L11;
        if (this.c.getBizType() != r5.getBizType()) goto L11;
        if (r5.getScene().equals(this.c.getScene()) == false) goto L11;
        if (r5.isPublicToJS() == true) goto L25;
        if (r9.n == true) goto L25;
        Log.i("OPPluginProxy", "not public to JS and not innerEvent. skip:" + r5.toString());
    L25:
        d r7 = b(r1, !r9.n);
        if (r7 == null) goto L11;
        r0.add(r7);
        goto L4
    L32:
        return r0;
    }

    public b(List<LKPluginConfig> r4, l r5, LKOpenApiAccessConfig r6) {
        this.c = r6;
        this.a = r5;
        this.b = new HashMap();
        ArrayList r7 = (ArrayList) r4;
        if (r7.isEmpty() == true) goto L15;
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L20;
        LKPluginConfig r9 = (LKPluginConfig) r8.next();
        List<String> r10 = r9.getEventList();
        a r0 = new a();
        r0.a = r9.mLkPlugin;
        r0.b = r9.mOpenConditions;
        r0.d = false;
        r0.c = r9.mPluginClassName;
        Iterator<String> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L7;
        String r12 = r11.next();
        List r1 = (List) ((HashMap) this.b).get(r12);
        if (r1 != null) goto L14;
        r1 = new ArrayList();
        ((HashMap) this.b).put(r12, r1);
    L14:
        r1.add(r0);
        goto L10
    L20:
        return;
    }
}
