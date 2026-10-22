package ndb;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.util.share_preference.UserSP;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final ExecutorService a;
    public final Set<d> b;
    public int c;
    public int d;
    public final Object e;
    public final Object f;
    public final Map<String, CopyOnWriteArraySet<d>> g;
    public final ExecutorService h;

    public class a implements Runnable {
        public final /* synthetic */ Set a;

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = b.a;     // Catch: Throwable -> L4
            Set r1 = this.a;     // Catch: Throwable -> L4
            r0.a.execute(new ndb.b(r0, r1));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Set r1) {
            this.a = r1;
        }
    }

    public static class b {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public static Set a() {
        Log.i("FeatureGatingTracker", "getAndUpdateSpBeanSet called");
        Gson r1 = new Gson();
        Set r2 = (Set) GsonProtectorUtils.fromJson(r1, UserSP.getInstance().getString("user_sp_fg_params", BuildConfig.FLAVOR), Set.class);
        HashSet r3 = new HashSet();
        if (r2 != null) goto L13;
        r2 = new HashSet();
    L13:
        Iterator r4 = r2.iterator();     // Catch: Exception -> L10
    L7:
        if (r4.hasNext() == false) goto L12;
        r3.add((d) r1.fromJson(r4.next().toString(), d.class));     // Catch: Exception -> L10
    L12:
        return r3;
    L10:
        e = move-exception;
        Log.e("FeatureGatingTracker", "getSpBeanSet error", e);
        goto L12
    }

    public final void c() {
        Object r0 = this.f;
        monitor-enter(r0);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (CollectionUtils.isEmpty(this.g) == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L34
    L20:
        Set r1 = a();
        Gson r2 = new Gson();
        Iterator r3 = ((CopyOnWriteArraySet) this.b).iterator();
    L22:
        if (r3.hasNext() == false) goto L32;
        d r4 = (d) r3.next();
        HashSet r5 = (HashSet) r1;
        Iterator r6 = r5.iterator();
    L25:
        if (r6.hasNext() == false) goto L29;
        d r7 = (d) r6.next();
        if (TextUtils.equals(r7.a(), r4.a()) == false) goto L25;
        r7.pv += r4.pv;
        boolean r8 = true;
    L30:
        if (r8 == true) goto L22;
        r5.add(r4);
        goto L22
    L29:
        r8 = false;
        goto L30
    L32:
        UserSP.getInstance().putString("user_sp_fg_params", GsonProtectorUtils.toJson(r2, r1));
        ((CopyOnWriteArraySet) this.b).clear();
        return;
    L8:
        HashMap r9 = new HashMap(this.g);     // Catch: Throwable -> L34
        ((HashMap) this.g).clear();     // Catch: Throwable -> L34
        monitor-exit(r0);     // Catch: Throwable -> L34
        if (CollectionUtils.isEmpty(r9) == true) goto L20;
        Iterator r10 = r9.values().iterator();
    L15:
        if (r10.hasNext() == false) goto L20;
        Iterator r11 = ((Set) r10.next()).iterator();
    L18:
        if (r11.hasNext() == false) goto L15;
        b((d) r11.next());
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [ndb.a] */
    public c() {
        this.a = CoreThreadPool.getDefault().newSerialIODensityThreadPool("fg_use_client_collect");
        this.b = new CopyOnWriteArraySet();
        this.e = new Object();
        this.f = new Object();
        this.g = new HashMap();
        this.h = CoreThreadPool.getDefault().newSerialCpuDensityThreadPool("fg_use_client_collect_global_feature_gating_service");
        FeatureGatingModule.getDependency().ve(new ndb.a(this));
    }

    public final void b(d r5) {
        Iterator r0 = ((CopyOnWriteArraySet) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        d r1 = (d) r0.next();
        if (TextUtils.equals(r1.fgKey, r5.fgKey) == false) goto L4;
        if (TextUtils.equals(r1.fgValueClient, r5.fgValueClient) == false) goto L4;
        if (TextUtils.equals(r1.fgValueServer, r5.fgValueServer) == false) goto L4;
        if (TextUtils.equals(r1.fgInterfaceType, r5.fgInterfaceType) == false) goto L4;
        boolean r2 = true;
        r1.pv++;
    L15:
        if (r2 == true) goto L28;
        ((CopyOnWriteArraySet) this.b).add(r5);
        return;
    L28:
        return;
    L14:
        r2 = false;
        goto L15
    }

    public final void d(String r4, d r5) {
        Object r0 = this.f;
        monitor-enter(r0);
        CopyOnWriteArraySet r1 = (CopyOnWriteArraySet) ((HashMap) this.g).get(r4);     // Catch: Throwable -> L15
        if (r1 != null) goto L7;
        r1 = new CopyOnWriteArraySet();     // Catch: Throwable -> L15
        ((HashMap) this.g).put(r4, r1);     // Catch: Throwable -> L15
    L7:
        r1.add(r5);     // Catch: Throwable -> L15
        if (r1.size() < 100) goto L10;
        HashSet r6 = new HashSet(r1);     // Catch: Throwable -> L15
        ((HashMap) this.g).remove(r4);     // Catch: Throwable -> L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (r6 == null) goto L20;
        this.h.execute(new a(r6));
        return;
    L20:
        return;
    L10:
        r6 = null;
    L15:
        th = move-exception;
        throw th;
    }
}
