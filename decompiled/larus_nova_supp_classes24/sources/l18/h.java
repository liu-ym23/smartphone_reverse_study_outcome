package l18;

import android.text.TextUtils;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.larksuite.framework.apiplugin.entity.LKPluginInterceptResult;
import j18.j;
import j18.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h implements l {
    public final List<i18.d> a;
    public final Map<String, List<i18.d>> b;
    public final j c;
    public hyb.a d;
    public final Object e;

    public h(g r2) {
        this.e = new Object();
        this.a = new ArrayList();
        this.b = new HashMap();
        this.c = r2;
        this.d = new p18.b.a(gyb.a.a().subTrace());
    }

    @Override // j18.h
    public final LKPluginInterceptResult a(LKEvent r13) {
        if (r13 != null) goto L6;
        this.d.e("LKPluginManagerImpl", new Object[]{"event is null!"});
        return LKPluginInterceptResult.g;
    L6:
        String r3 = r13.a;
        if (TextUtils.isEmpty(r3) == false) goto L10;
        this.d.e("LKPluginManagerImpl", new Object[]{"eventName is empty!"});
        return LKPluginInterceptResult.g;
    L10:
        List r4 = (List) ((HashMap) this.b).get(r3);
        if (r4 != null) goto L13;
    L38:
        this.d.e("LKPluginManagerImpl", new Object[]{"no plugin event:" + r3});
        return LKPluginInterceptResult.g;
    L13:
        if (r4.isEmpty() == true) goto L38;
        if (r4.size() <= 1) goto L18;
        Collections.sort(r4);
    L18:
        this.d.i("LKPluginManagerImpl", new Object[]{"intercept event:" + r3 + " plugin size:" + r4.size()});
        ListIterator r5 = r4.listIterator();
    L20:
        if (r5.hasNext() == false) goto L23;
        r5.next();
    L23:
        if (r5.hasPrevious() == false) goto L37;
        i18.d r6 = (i18.d) r5.previous();
        LKPluginInterceptResult r7 = LKPluginInterceptResult.g;
    L29:
        e = move-exception;
        this.d.e("LKPluginManagerImpl", new Object[]{"interceptEvent exception." + r6.getClass(), e});
    L31:
        String r8 = r18.b.b(r6);
        if (r7.a == true) goto L34;
        this.d.i("LKPluginManagerImpl", new Object[]{"[" + r3 + "] intercept pass " + r8});
        goto L23
    L34:
        this.d.i("LKPluginManagerImpl", new Object[]{"[" + r3 + "] intercepted by " + r8});
        return r7;
    L26:
        if ((r6 instanceof f) == false) goto L31;
        r7 = ((f) r6).a(r13);     // Catch: Exception -> L29
        goto L31
    L37:
        return LKPluginInterceptResult.g;
    }

    public final boolean b(i18.d r9) {
        if (r9 != null) goto L7;
        this.d.e("LKPluginManagerImpl", new Object[]{"invalid plugin parameter!"});
        return false;
    L7:
        if (((ArrayList) this.a).contains(r9) == false) goto L10;
        this.d.w("LKPluginManagerImpl", new Object[]{"plugin already registered!"});
        return false;
    L10:
        d r2 = new d();
        r9.addEvents(r2);
        List<String> r3 = r2.a;
        if (r3 == null) goto L37;
        ArrayList r4 = (ArrayList) r3;
        if (r4.isEmpty() == true) goto L37;
        Object r5 = this.e;
        monitor-enter(r5);
        ((ArrayList) this.a).add(r9);     // Catch: Throwable -> L34
        monitor-exit(r5);     // Catch: Throwable -> L34
        Iterator r6 = r4.iterator();
    L21:
        if (r6.hasNext() == false) goto L32;
        String r7 = (String) r6.next();
        if (TextUtils.isEmpty(r7) == true) goto L24;
        if (((HashMap) this.b).containsKey(r7) == true) goto L28;
        List r8 = new LinkedList();
        ((HashMap) this.b).put(r7, r8);
    L31:
        r8.add(r9);
        goto L21
    L28:
        r8 = (List) ((HashMap) this.b).get(r7);
        if (r8 != null) goto L31;
        this.d.i("LKPluginManagerImpl", new Object[]{"plugin list is null"});
        r8 = new ArrayList();
        ((HashMap) this.b).put(r7, r8);
        goto L31
    L24:
        this.d.e("LKPluginManagerImpl", new Object[]{"event can`t be empty!"});
        goto L21
    L32:
        this.d.d("LKPluginManagerImpl", new Object[]{"register plugin name:".concat(r9.getClass().getName())});
        return true;
    L34:
        th = move-exception;
        throw th;
    L37:
        this.d.e("LKPluginManagerImpl", new Object[]{"empty actions!" + r18.b.b(r9)});
        return false;
    }

    @Override // j18.g
    public final LKPluginHandleResult handleEvent(LKEvent r13) {
        if (r13 != null) goto L6;
        this.d.e("LKPluginManagerImpl", new Object[]{"event is null!"});
        return LKPluginHandleResult.g;
    L6:
        String r3 = r13.a;
        if (TextUtils.isEmpty(r3) == false) goto L10;
        this.d.e("LKPluginManagerImpl", new Object[]{"eventName is empty!"});
        return LKPluginHandleResult.g;
    L10:
        List r4 = (List) ((HashMap) this.b).get(r3);
        if (r4 != null) goto L13;
    L41:
        this.d.e("LKPluginManagerImpl", new Object[]{"no handle event:" + r3});
        return LKPluginHandleResult.g;
    L13:
        if (r4.isEmpty() == true) goto L41;
        if (r4.size() <= 1) goto L18;
        Collections.sort(r4);
    L18:
        this.d.i("LKPluginManagerImpl", new Object[]{"handle event:" + r3 + " plugin size:" + r4.size()});
        ListIterator r5 = r4.listIterator();
    L20:
        if (r5.hasNext() == false) goto L23;
        r5.next();
    L23:
        if (r5.hasPrevious() == false) goto L40;
        i18.d r6 = (i18.d) r5.previous();
        if (r6.shouldHandleActivityResult() == false) goto L29;
        this.d.i("LKPluginManagerImpl", new Object[]{"event:" + r3 + " registerActivityResult"});
        g r7 = (g) this.c;
        if (((ArrayList) r7.a).contains(r6) == true) goto L29;
        ((ArrayList) r7.a).add(r6);
    L29:
        LKPluginHandleResult r8 = LKPluginHandleResult.g;
        r8 = r6.handleEvent(r13);     // Catch: Exception -> L32
    L34:
        String r9 = r18.b.b(r6);
        if (r8.a == true) goto L37;
        this.d.i("LKPluginManagerImpl", new Object[]{"[" + r3 + "] handle pass " + r9});
        goto L23
    L37:
        this.d.i("LKPluginManagerImpl", new Object[]{"[" + r3 + "] handled by " + r9});
        return r8;
    L32:
        e = move-exception;
        this.d.e("LKPluginManagerImpl", new Object[]{"handleEvent exception." + r6.getClass(), e});
        goto L34
    L40:
        return LKPluginHandleResult.g;
    }
}
