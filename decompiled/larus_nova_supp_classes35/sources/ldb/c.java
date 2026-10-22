package ldb;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.j0;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregatingv2impl.entity.ErrorType;
import com.ss.android.lark.featuregatingv2impl.statistics.metrics.FeatureGatingMetricsTracker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.rust.lark_fg.Lark_fgKt;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class c extends c0c.b implements jdb.e, jdb.d {
    public static final Map<String, Boolean> r = null;
    public static final Map<String, Boolean> s = null;
    public static boolean t;
    public static final Object u = null;
    public final Map<String, Boolean> b;
    public final boolean c;
    public final Object d;
    public volatile boolean e;
    public final Map<String, HashSet<String>> f;
    public final Map<String, ConcurrentHashMap<String, CopyOnWriteArrayList<jdb.c>>> g;
    public final Set<String> h;
    public boolean i;
    public final Map<String, HashSet<String>> j;
    public Set<String> k;
    public final Set<String> l;
    public final Set<String> m;
    public boolean n;
    public final Map<String, ConcurrentHashMap<String, Boolean>> o;

    @Inject
    public j p;

    @Inject
    public Application q;

    public class a implements jdb.b<Set<String>> {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // jdb.b
        public final void onSuccess(Set<String> r4, String r5) {
            final Set<String> r6 = r4;
            if (r6 != null) goto L6;
            return;
        L6:
            if (TextUtils.isEmpty(r5) == true) goto L8;
            final String r7 = r5 + "_normal_fg";
        L9:
            c r0 = this.a;
            Object r1 = r0.d;
            monitor-enter(r1);
            ((HashMap) r0.f).put(r7, new HashSet(r6));     // Catch: Throwable -> L15
            monitor-exit(r1);     // Catch: Throwable -> L15
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new ldb.b(this, r6, r7));
            return;
        L15:
            th = move-exception;
            throw th;
        L8:
            r7 = BuildConfig.FLAVOR;
            goto L9
        }
    }

    public class b implements jdb.b<Set<String>> {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // jdb.b
        public final void onSuccess(Set<String> r6, String r7) {
            final Set<String> r8 = r6;
            if (r8 != null) goto L6;
            return;
        L6:
            if (TextUtils.isEmpty(r7) == false) goto L9;
            Log.w("GlobalFeatureGatingService", "syncSettingFeatureGatingData failed, settingsFGData: " + r8 + ", uid:" + j0.a(r7));
            return;
        L9:
            if (TextUtils.isEmpty(r7) == true) goto L11;
            final String r0 = r7 + "_no_user_fg";
        L12:
            c r2 = this.a;
            Object r3 = r2.d;
            monitor-enter(r3);
            ((HashMap) r2.f).put(r0, new HashSet(r8));     // Catch: Throwable -> L30
            monitor-exit(r3);     // Catch: Throwable -> L30
            final boolean r4 = false;
            if (TextUtils.isEmpty(r7) == false) goto L19;
        L21:
            boolean r9 = false;
        L22:
            if (r9 == false) goto L24;
            Log.i("GlobalFeatureGatingService", "isSettingsFGWithUserUpdated: true");
            this.a.n = true;
        L24:
            if (r9 == false) goto L26;
        L27:
            r4 = true;
        L28:
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new d(this, r4, r8, r0));
            return;
        L26:
            if (this.a.n == true) goto L28;
        L19:
            if (TextUtils.equals(r7, "absent_user") == true) goto L21;
            r9 = true;
        L30:
            th = move-exception;
            throw th;
        L11:
            r0 = BuildConfig.FLAVOR;
            goto L12
        }
    }

    /* JADX INFO: renamed from: ldb.c$c, reason: collision with other inner class name */
    public class C0251c implements jdb.b<Map<String, Boolean>> {
        public final /* synthetic */ c a;

        public C0251c(c r1) {
            this.a = r1;
        }

        @Override // jdb.b
        public final void onSuccess(Map<String, Boolean> r3, final String r4) {
            final Map<String, Boolean> r5 = r3;
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new e(this, r5, r4));
        }
    }

    static {
        r = new HashMap();
        s = new HashMap();
        u = new Object();
    }

    @Override // jdb.e
    public final void U1() {
        Object r0 = this.d;
        monitor-enter(r0);
        ((HashMap) this.f).clear();     // Catch: Throwable -> L7
        ((CopyOnWriteArraySet) this.h).clear();     // Catch: Throwable -> L7
        ((ConcurrentHashMap) this.j).clear();     // Catch: Throwable -> L7
        ((HashMap) this.o).clear();     // Catch: Throwable -> L7
        Log.i("GlobalFeatureGatingService", "clear global fg mem cache data.");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // jdb.e
    public final void Y9() {
        Log.i("GlobalFeatureGatingService", "spiInject called");
    }

    @Override // jdb.e
    public final Set<String> getSettingsFGKeys() {
        if (CollectionUtils.isNotEmpty(this.l) == false) goto L7;
        return this.l;
    L7:
        return pdb.a.a().getStringSet("key_feature_gating_no_user_keys", new CopyOnWriteArraySet());
    }

    @Override // jdb.e
    public final void init() {
        Object r0 = this.d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.e == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.e = true;     // Catch: Throwable -> L11
        a r1 = new a(this);     // Catch: Throwable -> L11
        b r2 = new b(this);     // Catch: Throwable -> L11
        C0251c r3 = new C0251c(this);     // Catch: Throwable -> L11
        gdb.b r4 = gdb.b.C0227b.a;     // Catch: Throwable -> L11
        r4.i = r1;     // Catch: Throwable -> L11
        r4.j = r2;     // Catch: Throwable -> L11
        r4.k = r3;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public final Set<String> wf() {
        boolean r2 = true;
        if (this.i == false) goto L6;
    L9:
        if (r2 == true) goto L11;
        Set<String> r0 = null;
    L17:
        if (r0 == null) goto L19;
        return r0;
    L19:
        return new HashSet();
    L11:
        if (CollectionUtils.isEmpty(this.k) == false) goto L15;
        String r1 = pdb.a.a().getString("key_feature_gating_no_user_config", BuildConfig.FLAVOR);
        if (r1 == null) goto L15;
        this.k.addAll(new HashSet(Arrays.asList(r1.split(","))));
    L15:
        r0 = this.k;
        goto L17
    L6:
        if (pdb.a.a().contains("key_feature_gating_no_user_config") == false) goto L8;
        this.i = true;
        goto L9
    L8:
        r2 = false;
        goto L9
    }

    @Override // jdb.e
    public final Set<String> allFg(String r9) {
        Object r4 = this.d;
        monitor-enter(r4);
        LinkedHashSet r5 = new LinkedHashSet();     // Catch: Throwable -> L27
        String r10 = r9 + "_normal_fg";     // Catch: Throwable -> L27
        if (this.c == false) goto L11;
        HashSet r6 = (HashSet) ((HashMap) this.f).get(r10);     // Catch: Throwable -> L27
        if (CollectionUtils.isNotEmpty(r6) == false) goto L11;
        r5.addAll(r6);     // Catch: Throwable -> L27
        Log.d("GlobalFeatureGatingServiceAllFG", "allFg from memory: " + r6.size());     // Catch: Throwable -> L27
        Set<String> r11 = Collections.unmodifiableSet(r5);     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L27
        return r11;
    L11:
        Set<String> r12 = xf(r10);     // Catch: Throwable -> L27
        if (CollectionUtils.isNotEmpty(r12) == false) goto L16;
        r5.addAll(r12);     // Catch: Throwable -> L27
        Log.d("GlobalFeatureGatingServiceAllFG", "allFg from disk cache: " + r12.size());     // Catch: Throwable -> L27
        Set<String> r13 = Collections.unmodifiableSet(r5);     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L27
        return r13;
    L16:
        Set<String> r14 = wf();     // Catch: Throwable -> L27
        if (CollectionUtils.isNotEmpty(r14) == false) goto L21;
        r5.addAll(r14);     // Catch: Throwable -> L27
        Log.d("GlobalFeatureGatingServiceAllFG", "allFg from absent user cache: " + r14.size());     // Catch: Throwable -> L27
        Set<String> r15 = Collections.unmodifiableSet(r5);     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L27
        return r15;
    L21:
        List<String> r16 = idb.d.a();     // Catch: Throwable -> L27
        if (CollectionUtils.isNotEmpty(r16) == false) goto L24;
        r5.addAll(r16);     // Catch: Throwable -> L27
        Log.d("GlobalFeatureGatingServiceAllFG", "allFg from package defaults: " + ((ArrayList) r16).size());     // Catch: Throwable -> L27
    L24:
        Set<String> r17 = Collections.unmodifiableSet(r5);     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L27
        return r17;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // jdb.e
    public final boolean isNoUserFGEnable(String r5) {
        Log.i("GlobalFeatureGatingService", "calling isNoUserFGEnable, FG key: " + r5);
        if (TextUtils.isEmpty(r5) == false) goto L7;
        Log.e("GlobalFeatureGatingService", "feature name is invalid.");
        return false;
    L7:
        if (CollectionUtils.isEmpty(this.b) == true) goto L13;
        if (this.b.containsKey(r5) == false) goto L13;
        Boolean r6 = this.b.get(r5);
        Log.i("GlobalFeatureGatingService", "from mock, value: " + r6);
        return Boolean.TRUE.equals(r6);
    L13:
        if (this.c == false) goto L22;
        HashSet r0 = (HashSet) ((HashMap) this.f).get("absent_user_no_user_fg");
        if (CollectionUtils.isNotEmpty(r0) == false) goto L19;
        boolean r7 = r0.contains(r5);
        Log.i("GlobalFeatureGatingService", "from mRuntimeFeaturesMap, value: " + r7);
        return r7;
    L19:
        if (CollectionUtils.isNotEmpty(this.m) == false) goto L22;
        boolean r8 = ((CopyOnWriteArraySet) this.m).contains(r5);
        Log.i("GlobalFeatureGatingService", "from mSettingsFGNoUserSet, value: " + r8);
        return r8;
    L22:
        Set<String> r1 = xf("absent_user_no_user_fg");
        if (CollectionUtils.isNotEmpty(r1) == false) goto L26;
        boolean r9 = r1.contains(r5);
        Log.i("GlobalFeatureGatingService", "from RuntimeFGSPCache cache, value: " + r9);
        return r9;
    L26:
        Set<String> r2 = wf();
        if (CollectionUtils.isNotEmpty(r2) == false) goto L30;
        boolean r10 = r2.contains(r5);
        Log.i("GlobalFeatureGatingService", "from FGNoUserSPCache, value: " + r10);
        return r10;
    L30:
        boolean r11 = FeatureGatingModule.getDependency().e9(r5);
        Log.i("GlobalFeatureGatingService", "form SettingsDefaultValue, value: " + r11);
        return r11;
    }

    public final void mf(f0c.g r8) {
        Log.i("GlobalFeatureGatingService", "destroy called");
        String r9 = r8.a.userId;
        Object r0 = this.d;
        monitor-enter(r0);
        Iterator r1 = Arrays.asList(new String[]{"_normal_fg", "_no_user_fg"}).iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) r1.next();     // Catch: Throwable -> L14
        String r3 = r9 + r2;     // Catch: Throwable -> L14
        HashSet r4 = (HashSet) ((HashMap) this.f).get(r3);     // Catch: Throwable -> L14
        if (r4 == null) goto L10;
        r4.clear();     // Catch: Throwable -> L14
    L10:
        ((CopyOnWriteArraySet) this.h).remove(r3);     // Catch: Throwable -> L14
        ((ConcurrentHashMap) this.j).remove(r3);     // Catch: Throwable -> L14
        ((HashMap) this.o).remove("absent_user" + r2);     // Catch: Throwable -> L14
        ((HashMap) this.o).remove(r3);     // Catch: Throwable -> L14
        ((ConcurrentHashMap) this.g).remove(r3);     // Catch: Throwable -> L14
        goto L6
    L11:
        this.n = false;     // Catch: Throwable -> L14
        Log.i("GlobalFeatureGatingService", "clear user fg mem cache data and update listeners.");     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void of(f0c.g r2) {
        Log.i("GlobalFeatureGatingService", "onPrepared called");
    }

    public final Set<String> xf(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
    L12:
        boolean r0 = false;
    L13:
        if (r0 == true) goto L15;
        Set<String> r6 = null;
    L22:
        if (r6 == null) goto L24;
        return r6;
    L24:
        return new HashSet();
    L15:
        if (((ConcurrentHashMap) this.j).containsKey(r5) == true) goto L20;
        String r1 = pdb.a.b(r5).getString("key_feature_gating_config", BuildConfig.FLAVOR);
        if (r1 == null) goto L19;
        ((ConcurrentHashMap) this.j).put(r5, new HashSet(Arrays.asList(r1.split(","))));
        goto L20
    L19:
        ((ConcurrentHashMap) this.j).put(r5, new HashSet());
    L20:
        r6 = (Set) ((ConcurrentHashMap) this.j).get(r5);
        goto L22
    L6:
        if (((CopyOnWriteArraySet) this.h).contains(r5) == false) goto L9;
    L11:
        r0 = true;
        goto L13
    L9:
        if (pdb.a.b(r5).contains("key_feature_gating_config") == false) goto L12;
        ((CopyOnWriteArraySet) this.h).add(r5);
        Log.i("GlobalFeatureGatingService", "hasRuntimeFGSPCache add " + j0.a(r5));
        goto L11
    }

    @Inject
    public c(j r2, jdb.f r3) {
        super(r2);
        this.d = new Object();
        this.e = false;
        this.f = new HashMap();
        this.g = new ConcurrentHashMap();
        this.h = new CopyOnWriteArraySet();
        this.j = new ConcurrentHashMap();
        this.k = new CopyOnWriteArraySet();
        this.l = new CopyOnWriteArraySet();
        this.m = new CopyOnWriteArraySet();
        this.o = new HashMap();
        boolean r4 = z.e(this.q);
        this.c = r4;
        this.b = r3.a();
        Log.i("GlobalFeatureGatingService", "GlobalFeatureGatingService called, main process:" + r4);
        h.a(this);
    }

    public static void tf(c r4, Set r5) {
        r4.getClass();
        Log.i("GlobalFeatureGatingService", "updateSettingsNoUserKeys called");
        Object r0 = r4.d;
        monitor-enter(r0);
        r4.i = true;     // Catch: Throwable -> L21
        Set<String> r2 = r4.wf();     // Catch: Throwable -> L21
        r4.k = new HashSet(r5);     // Catch: Throwable -> L21
        if (zf(r5, r2) == false) goto L13;
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L21
        Iterator r7 = ((HashSet) r5).iterator();     // Catch: Throwable -> L21
    L9:
        if (r7.hasNext() == false) goto L11;
        r6.append((String) r7.next());     // Catch: Throwable -> L21
        r6.append(",");     // Catch: Throwable -> L21
        goto L9
    L11:
        pdb.a.a().putString("key_feature_gating_no_user_config", r6.toString());     // Catch: Throwable -> L21
    L13:
        if (pdb.a.a().getBoolean("removed_legacy_no_user_keys", false) == true) goto L19;
        Log.i("GlobalFeatureGatingService", "removing no user legacy keys.");     // Catch: Throwable -> L21
        Iterator<String> r8 = r2.iterator();     // Catch: Throwable -> L21
    L16:
        if (r8.hasNext() == false) goto L18;
        String r9 = r8.next();     // Catch: Throwable -> L21
        pdb.a.a().remove(r9);     // Catch: Throwable -> L21
        goto L16
    L18:
        pdb.a.a().putBoolean("removed_legacy_no_user_keys", true);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public static void uf(c r2, Set r3) {
        Object r0 = r2.d;
        monitor-enter(r0);
        if (r3 != null) goto L11;
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        ((CopyOnWriteArraySet) r2.l).addAll(r3);     // Catch: Throwable -> L8
        pdb.a.a().putStringSet("key_feature_gating_no_user_keys", r3);     // Catch: Throwable -> L8
        goto L6
    }

    public static List vf(Set r3, Set r4) {
        ArrayList r0 = new ArrayList();
        if (r3 == null) goto L15;
        if (r4 == null) goto L15;
        Iterator r5 = r4.iterator();     // Catch: Exception -> L13
    L8:
        if (r5.hasNext() == false) goto L15;
        String r1 = (String) r5.next();     // Catch: Exception -> L13
        if (r3.contains(r1) == true) goto L8;
        r0.add(r1);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.i("GlobalFeatureGatingService", "compareDiffKey fail, e: " + e.getMessage());
    L15:
        return r0;
    }

    public static boolean zf(Set r2, Set r3) {
        if (CollectionUtils.isEmpty(r3) == false) goto L5;
        return true;
    L5:
        List r0 = vf(r2, r3);
        List r4 = vf(r3, r2);
        if (((ArrayList) r0).isEmpty() == true) goto L8;
        return true;
    L8:
        if (((ArrayList) r4).isEmpty() == false) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // jdb.e
    public final boolean B0(String r14, String r15) {
        Log.d("GlobalFeatureGatingService", "calling isEnable, FG key: " + r15);
        long r0 = System.nanoTime();
        boolean r3 = false;
        if (TextUtils.isEmpty(r15) == false) goto L7;
        Log.e("GlobalFeatureGatingService", "feature name is illegal.");
        return false;
    L7:
        if (TextUtils.isEmpty(r14) == false) goto L10;
        Log.w("GlobalFeatureGatingService", "uid is empty.");
        r14 = "absent_user";
    L12:
        String r16 = r14 + "_normal_fg";
        if (CollectionUtils.isEmpty(this.b) == false) goto L15;
    L18:
        kdb.a r2 = new kdb.a();
        odb.a r4 = r2.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r4.a = r15;
        Map r5 = (Map) ((HashMap) this.o).get("absent_user");
        if (CollectionUtils.isEmpty(r5) == false) goto L21;
    L23:
        Map r6 = (Map) ((HashMap) this.o).get(r16);
        if (CollectionUtils.isEmpty(r6) == false) goto L26;
    L28:
        String r7 = r16.replace("_normal_fg", BuildConfig.FLAVOR);
        if (com.ss.android.lark.featuregating.b.d.a().a("improve.safe.score.rust") == false) goto L46;
        if (FeatureGatingModule.getFeatureGatingService().isNoUserFGEnable("lazy_load_fg_barrier_before_login") == true) goto L36;
        Boolean r8 = (Boolean) ((HashMap) s).get(r7);
        if (r8 == null) goto L40;
        r3 = r8.booleanValue();
    L40:
        if (r3 == true) goto L90;
    L51:
        Set<String> r9 = xf(r16);
        if (CollectionUtils.isNotEmpty(r9) == false) goto L54;
        boolean r10 = r9.contains(r15);
        r2.setResult(r10);
        r2.b.a(ErrorType.SINGLE_ERROR_FROM_DISK.plus(ErrorType.SINGLE_ERROR_MOLTEN_FAIL));
        Log.d("GlobalFeatureGatingService", "from disk cache, value: " + r10);
    L58:
        boolean r11 = r2.a;
        ConcurrentHashMap r12 = (ConcurrentHashMap) ((HashMap) this.o).get(r16);
        if (r12 != null) goto L71;
        Object r13 = this.d;
        monitor-enter(r13);
        ConcurrentHashMap r17 = (ConcurrentHashMap) ((HashMap) this.o).get(r16);     // Catch: Throwable -> L68
        if (r17 != null) goto L65;
        ConcurrentHashMap r18 = new ConcurrentHashMap();     // Catch: Throwable -> L68
        r18.put(r15, Boolean.valueOf(r11));     // Catch: Throwable -> L68
        ((HashMap) this.o).put(r16, r18);     // Catch: Throwable -> L68
    L66:
        monitor-exit(r13);     // Catch: Throwable -> L68
    L72:
        ndb.c r19 = ndb.c.b.a;
        boolean r20 = r2.a;
        boolean r21 = yf(r15, r16).a;
        r19.getClass();
        if (Boolean.TRUE.equals(FeatureGatingModule.getDependency().Y()) == true) goto L84;
        ndb.d r22 = new ndb.d();
        String r23 = "1";
        if (r20 == false) goto L78;
        String r24 = "1";
    L79:
        r22.fgValueClient = r24;
        if (r21 == true) goto L83;
        r23 = DocTabPayload.DocType.UNKNOWN;
    L83:
        r22.fgValueServer = r23;
        r22.fgKey = r15;
        r22.fgInterfaceType = DocTabPayload.DocType.UNKNOWN;
        r22.pv = 1;
        r19.d(r16, r22);
        goto L84
    L78:
        r24 = DocTabPayload.DocType.UNKNOWN;
    L84:
        odb.a r110 = r2.b;
        r110.b = r0;
        r110.c = System.nanoTime();
        FeatureGatingMetricsTracker r111 = FeatureGatingMetricsTracker.a;
        FeatureGatingMetricsTracker.b(r2.b);
        return r2.a;
    L65:
        Log.i("GlobalFeatureGatingService", "should missed used fg.");     // Catch: Throwable -> L68
        r17.put(r15, Boolean.valueOf(r11));     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        throw th;
    L71:
        r12.put(r15, Boolean.valueOf(r11));
        goto L72
    L54:
        Set r25 = (Set) ((HashMap) this.f).get("absent_user_normal_fg");
        if (CollectionUtils.isEmpty(r25) == true) goto L57;
        boolean r26 = r25.contains(r15);
        Log.d("GlobalFeatureGatingService", "from no-user-state cache, value: " + r26);
        r2.setResult(r26);
        r2.b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE.plus(ErrorType.SINGLE_ERROR_MOLTEN_FAIL));
        goto L58
    L57:
        boolean r27 = idb.d.b(r15).booleanValue();
        Log.d("GlobalFeatureGatingService", "from package, value: " + r27);
        r2.setResult(r27);
        r2.b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE.plus(ErrorType.SINGLE_ERROR_MOLTEN_FAIL));
        goto L58
    L90:
        boolean r28 = Lark_fgKt.getImmutableFeatureGating(r7, r15);     // Catch: Exception -> L43
        Log.d("GlobalFeatureGatingService", "from molten, value: " + r28 + ", uidWithType: " + r16 + ", uid: " + r7);     // Catch: Exception -> L43
        r2.setResult(r28);     // Catch: Exception -> L43
        r2.b.a(ErrorType.NORMAL);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        r2.b.a(ErrorType.SINGLE_ERROR_MOLTEN_FAIL);
        Log.e("GlobalFeatureGatingService", "Lark_biz_fgKt err: " + e.getMessage() + ", uidWithType: " + r16 + ", uid: " + r7 + ", fg=" + r15);
        goto L51
    L36:
        Boolean r29 = (Boolean) ((HashMap) r).get(r7);
        if (r29 == null) goto L40;
        r3 = r29.booleanValue();
        goto L40
    L46:
        if (FeatureGatingModule.getDependency().e6(r7) == false) goto L51;
        boolean r30 = Lark_fgKt.getImmutableFeatureGating(r7, r15);     // Catch: Exception -> L49
        Log.d("GlobalFeatureGatingService", "from molten, value: " + r30 + ", uidWithType: " + r16 + ", uid: " + r7);     // Catch: Exception -> L49
        r2.setResult(r30);     // Catch: Exception -> L49
        r2.b.a(ErrorType.NORMAL);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        r2.b.a(ErrorType.SINGLE_ERROR_MOLTEN_FAIL);
        Log.e("GlobalFeatureGatingService", "Lark_biz_fgKt err: " + e.getMessage() + ", uidWithType: " + r16 + ", uid: " + r7 + ", fg=" + r15);
        goto L51
    L26:
        if (r6.containsKey(r15) == false) goto L28;
        Boolean r31 = (Boolean) r6.get(r15);
        Log.d("GlobalFeatureGatingService", "from usedMap, value: " + r31);
        r2.setResult(Boolean.TRUE.equals(r31));
        r2.b.a(ErrorType.NORMAL);
        goto L58
    L21:
        if (r5.containsKey(r15) == false) goto L23;
        Boolean r32 = (Boolean) r5.get(r15);
        Log.i("GlobalFeatureGatingService", "from absentUserUsedFG, value: " + r32);
        r2.setResult(Boolean.TRUE.equals(r32));
        r2.b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE);
        goto L58
    L15:
        if (this.b.containsKey(r15) == false) goto L18;
        Boolean r112 = this.b.get(r15);
        Log.d("GlobalFeatureGatingService", "from mock, value: " + r112);
        return Boolean.TRUE.equals(r112);
    L10:
        if (TextUtils.isDigitsOnly(r14) == true) goto L12;
        Log.w("GlobalFeatureGatingService", "uid is illegal, uid: " + r14);
        goto L12
    }

    @Override // jdb.e
    public final void Tc(String r3, boolean r4) {
        if (TextUtils.equals(r3, "absent_user") == false) goto L5;
    L6:
        r3 = "absent_user";
    L7:
        Map<String, Boolean> r0 = s;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, Boolean.valueOf(r4));
        if (t == false) goto L10;
        return;
    L10:
        Object r5 = u;
        monitor-enter(r5);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (t == false) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L19
        return;
    L16:
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_LAZY_LOAD_FEATURE_GATING_STARTED, new ldb.a(this));     // Catch: Throwable -> L19
        t = true;     // Catch: Throwable -> L19
        Log.i("GlobalFeatureGatingService", "RegisterMoltenPushInit");     // Catch: Throwable -> L19
        monitor-exit(r5);     // Catch: Throwable -> L19
        return;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        goto L6
    }

    @Override // jdb.e
    public final Map<String, String> getChangedKeysBySyncUpdate(String r7, Map<String, String> r8) {
        String r9 = r8.get("lark_features");
        gdb.b.C0227b.a.getClass();
        Set r10 = gdb.b.k(r9);
        Set<String> r11 = xf(r7 + "_normal_fg");
        List r0 = vf(r10, r11);
        List r12 = vf(r11, r10);
        HashMap r13 = new HashMap();
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = ((ArrayList) r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) r2.next();
        if (r1.length() <= 0) goto L8;
        r1.append(",");
    L8:
        r1.append(r3);
        goto L4
    L9:
        StringBuilder r4 = new StringBuilder();
        Iterator r5 = ((ArrayList) r12).iterator();
    L11:
        if (r5.hasNext() == false) goto L16;
        String r6 = (String) r5.next();
        if (r4.length() <= 0) goto L15;
        r4.append(",");
    L15:
        r4.append(r6);
        goto L11
    L16:
        r13.put("added_keys", r12.toString());
        r13.put("removed_keys", r0.toString());
        return r13;
    }

    @Override // jdb.e
    public final Set<String> getRuntimeFGSPCache(String r2, String r3) {
        return xf(r2 + r3);
    }

    @Override // jdb.e
    public final Map<String, Boolean> getUsedFGMap(String r5, String r6) {
        Log.d("GlobalFeatureGatingService", "getUsedFGMap, uid: " + r5);
        Map r0 = (Map) ((HashMap) this.o).get("absent_user" + r6);
        Map r7 = (Map) ((HashMap) this.o).get(r5 + r6);
        HashMap r8 = new HashMap();
        if (CollectionUtils.isNotEmpty(r0) == false) goto L6;
        r8.putAll(r0);
    L6:
        if (CollectionUtils.isNotEmpty(r7) == false) goto L9;
        r8.putAll(r7);
    L9:
        if (CollectionUtils.isEmpty(r8) == false) goto L13;
        Log.i("GlobalFeatureGatingService", "no used fg.");
        return new HashMap();
    L13:
        return new HashMap(r8);
    }

    @Override // jdb.e
    public final void notifySettingsFGChanged(Map<String, Boolean> r6, String r7) {
        gdb.b r0 = gdb.b.C0227b.a;
        r0.getClass();
        gdb.b.j();
        Log.i("FeatureGatingHandler", "getSettingsFGData called");
        HashSet r2 = new HashSet();
        Iterator<Map.Entry<String, Boolean>> r8 = r6.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Map.Entry<String, Boolean> r3 = r8.next();
        if (r3.getValue().booleanValue() == false) goto L4;
        r2.add(r3.getKey());
        goto L4
    L8:
        Log.i("FeatureGatingHandler", "settingsFGData: " + r2.toString());
        if (CollectionUtils.isEmpty(r2) == true) goto L19;
        jdb.b<Set<String>> r9 = r0.j;
        if (r9 == null) goto L20;
        r9.onSuccess(r2, r7);
        return;
    L20:
        return;
    }

    @Override // jdb.e
    public final void notifySettingsFGNoUserChanged(Map<String, Boolean> r3, String r4) {
        gdb.b r0 = gdb.b.C0227b.a;
        r0.getClass();
        gdb.b.j();
        if (CollectionUtils.isEmpty(r3) == true) goto L8;
        jdb.b<Map<String, Boolean>> r1 = r0.k;
        if (r1 == null) goto L9;
        r1.onSuccess(r3, r4);
        return;
    L9:
        return;
    }

    @Override // jdb.e
    public final boolean tb(String r4, String r5) {
        Log.d("GlobalFeatureGatingService", "calling isCrossUserEnable, FG key: " + r5);
        Log.d("GlobalFeatureGatingService", "calling isUserEnable, FG key: " + r5);
        if (CollectionUtils.isEmpty(this.b) == true) goto L8;
        if (this.b.containsKey(r5) == false) goto L8;
        Boolean r6 = this.b.get(r5);
        Log.d("GlobalFeatureGatingService", "from mock, value: " + r6);
        return Boolean.TRUE.equals(r6);
    L8:
        if (TextUtils.isEmpty(r5) == false) goto L11;
        Log.e("GlobalFeatureGatingService", "feature name is invalid.");
    L25:
        return false;
    L11:
        if (TextUtils.isEmpty(r4) == false) goto L13;
    L24:
        Log.w("GlobalFeatureGatingService", "uid is empty.");
        goto L25
    L13:
        if (TextUtils.equals(r4, "absent_user") == true) goto L24;
        String r7 = r4 + "_no_user_fg";
        if (this.c == false) goto L20;
        HashSet r0 = (HashSet) ((HashMap) this.f).get(r7);
        if (CollectionUtils.isEmpty(r0) == true) goto L20;
        boolean r8 = r0.contains(r5);
        Log.d("GlobalFeatureGatingService", "from mem cache, value: " + r8);
        return r8;
    L20:
        Set<String> r9 = xf(r7);
        if (CollectionUtils.isNotEmpty(r9) == false) goto L23;
        boolean r10 = r9.contains(r5);
        Log.d("GlobalFeatureGatingService", "from disk cache, value: " + r10);
        return r10;
    L23:
        boolean r11 = FeatureGatingModule.getDependency().e9(r5);
        Log.i("GlobalFeatureGatingService", "form SettingsDefaultValue, value: " + r11);
        return r11;
    }

    @Override // jdb.e
    public final boolean x(String r9, String r10) {
        Log.d("GlobalFeatureGatingService", "calling isCurrentEnable, FG key: " + r10);
        long r2 = System.nanoTime();
        if (TextUtils.isEmpty(r10) == false) goto L7;
        Log.e("GlobalFeatureGatingService", "feature name is invalid.");
        return false;
    L7:
        if (TextUtils.isEmpty(r9) == false) goto L10;
        Log.w("GlobalFeatureGatingService", "uid is empty.");
        r9 = "absent_user";
    L10:
        if (CollectionUtils.isEmpty(this.b) == false) goto L12;
    L15:
        String r11 = r9 + "_normal_fg";
        kdb.a r0 = yf(r10, r11);
        ndb.c r1 = ndb.c.b.a;
        boolean r4 = r0.a;
        r1.getClass();
        if (Boolean.TRUE.equals(FeatureGatingModule.getDependency().Y()) == true) goto L23;
        ndb.d r5 = new ndb.d();
        Log.d("FeatureGatingTracker", "for isEnable report, end.");
        if (r4 == false) goto L21;
        String r6 = "1";
    L22:
        r5.fgValueServer = r6;
        r5.fgKey = r10;
        r5.fgInterfaceType = "1";
        r5.pv = 1;
        r1.d(r11, r5);
        goto L23
    L21:
        r6 = DocTabPayload.DocType.UNKNOWN;
    L23:
        odb.a r12 = r0.b;
        r12.b = r2;
        r12.c = System.nanoTime();
        FeatureGatingMetricsTracker r13 = FeatureGatingMetricsTracker.a;
        FeatureGatingMetricsTracker.b(r0.b);
        return r0.a;
    L12:
        if (this.b.containsKey(r10) == false) goto L15;
        Boolean r14 = this.b.get(r10);
        Log.d("GlobalFeatureGatingService", "from mock, value: " + r14);
        return Boolean.TRUE.equals(r14);
    }

    public final kdb.a yf(String r5, String r6) {
        kdb.a r0 = new kdb.a();
        odb.a r1 = r0.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r1.a = r5;
        if (this.c == false) goto L8;
        HashSet r2 = (HashSet) ((HashMap) this.f).get(r6);
        if (CollectionUtils.isEmpty(r2) == true) goto L8;
        boolean r7 = r2.contains(r5);
        r0.setResult(r7);
        r0.b.a(ErrorType.NORMAL);
        Log.d("GlobalFeatureGatingService", "from mem cache, value: " + r7);
        return r0;
    L8:
        Set<String> r3 = xf(r6);
        if (CollectionUtils.isNotEmpty(r3) == false) goto L12;
        boolean r8 = r3.contains(r5);
        r0.setResult(r8);
        r0.b.a(ErrorType.SINGLE_ERROR_FROM_DISK);
        Log.d("GlobalFeatureGatingService", "from disk cache, value: " + r8);
        return r0;
    L12:
        String r4 = "_normal_fg";
        if (r6.endsWith("_normal_fg") == true) goto L16;
        r4 = "_no_user_fg";
    L16:
        Set r9 = (Set) ((HashMap) this.f).get("absent_user".concat(r4));
        if (CollectionUtils.isEmpty(r9) == true) goto L20;
        boolean r10 = r9.contains(r5);
        Log.d("GlobalFeatureGatingService", "from no-user-state cache, value: " + r10);
        r0.setResult(r10);
        r0.b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE);
        return r0;
    L20:
        boolean r11 = idb.d.b(r5).booleanValue();
        Log.d("GlobalFeatureGatingService", "from package, value:" + r11);
        r0.setResult(r11);
        r0.b.a(ErrorType.SINGLE_ERROR_FROM_PACKAGE);
        return r0;
    }

    public static void rf(c r11, Set r12, String r13) {
        r11.getClass();
        Log.i("GlobalFeatureGatingService", "onFeatureGatingUpdate:" + r13);
        if (r12 != null) goto L5;
        return;
    L5:
        if (((ConcurrentHashMap) r11.g).containsKey(r13) == false) goto L58;
        ConcurrentHashMap r0 = (ConcurrentHashMap) ((ConcurrentHashMap) r11.g).get(r13);
        if (CollectionUtils.isNotEmpty(r0) == false) goto L57;
        ArrayList r2 = new ArrayList(Arrays.asList(new Set[]{r11.xf(r13)}));
        if (TextUtils.equals("absent_user_no_user_fg", r13) == false) goto L12;
        r2.add(r11.wf());
    L12:
        Iterator r14 = r2.iterator();
    L14:
        if (r14.hasNext() == false) goto L59;
        Set r3 = (Set) r14.next();
        List r4 = vf(r12, r3);
        List r5 = vf(r3, r12);
        Iterator r6 = ((ArrayList) r4).iterator();
    L17:
        if (r6.hasNext() == false) goto L27;
        String r7 = (String) r6.next();
        if (TextUtils.isEmpty(r7) == true) goto L20;
        CopyOnWriteArrayList r8 = (CopyOnWriteArrayList) r0.get(r7);
        if (r8 == null) goto L17;
        Iterator r9 = r8.iterator();
    L25:
        if (r9.hasNext() == false) goto L17;
        ((jdb.c) r9.next()).a(false);
        Log.i("GlobalFeatureGatingService", "notify " + r7 + " close, , uidWithType=" + r13);
        goto L25
    L20:
        Log.w("GlobalFeatureGatingService", "removedKey is empty, uidWithType=" + r13);
        goto L17
    L27:
        Iterator r10 = ((ArrayList) r5).iterator();
    L29:
        if (r10.hasNext() == false) goto L14;
        String r15 = (String) r10.next();
        if (TextUtils.isEmpty(r15) == true) goto L32;
        CopyOnWriteArrayList r16 = (CopyOnWriteArrayList) r0.get(r15);
        if (r16 == null) goto L29;
        Iterator r17 = r16.iterator();
    L37:
        if (r17.hasNext() == false) goto L29;
        ((jdb.c) r17.next()).a(true);
        Log.i("GlobalFeatureGatingService", "notify " + r15 + " open, , uidWithType=" + r13);
        goto L37
    L32:
        Log.w("GlobalFeatureGatingService", "addedKey is empty, uidWithType=" + r13);
        goto L29
    L59:
        return;
    L57:
        return;
    }

    public static void sf(c r3, Set r4, String r5) {
        Object r0 = r3.d;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L21;
        if (r4 == null) goto L21;
        ((CopyOnWriteArraySet) r3.h).add(r5);     // Catch: Throwable -> L23
        Set<String> r1 = r3.xf(r5);     // Catch: Throwable -> L23
        Map<String, HashSet<String>> r6 = r3.j;     // Catch: Throwable -> L23
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;     // Catch: Throwable -> L23
        r7.put(r5, new HashSet(r4));     // Catch: Throwable -> L23
        if (zf(r4, r1) == false) goto L15;
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L23
        Iterator r9 = r4.iterator();     // Catch: Throwable -> L23
    L11:
        if (r9.hasNext() == false) goto L13;
        r8.append((String) r9.next());     // Catch: Throwable -> L23
        r8.append(",");     // Catch: Throwable -> L23
        goto L11
    L13:
        pdb.a.b(r5).putString("key_feature_gating_config", r8.toString());     // Catch: Throwable -> L23
    L15:
        if (pdb.a.b(r5).getBoolean("removed_legacy_keys", false) == true) goto L21;
        Log.i("GlobalFeatureGatingService", "removing legacy keys.");     // Catch: Throwable -> L23
        Iterator<String> r10 = r1.iterator();     // Catch: Throwable -> L23
    L18:
        if (r10.hasNext() == false) goto L20;
        String r11 = r10.next();     // Catch: Throwable -> L23
        pdb.a.b(r5).remove(r11);     // Catch: Throwable -> L23
        goto L18
    L20:
        pdb.a.b(r5).putBoolean("removed_legacy_keys", true);     // Catch: Throwable -> L23
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L23
    }

    @Override // jdb.e
    public final void Kb(String r5, jdb.c r6, String r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        String r1 = "absent_user";
        if (TextUtils.isEmpty(r5) == false) goto L7;
        Log.i("GlobalFeatureGatingService", "uid is empty, reassign.");
        String r8 = "absent_user" + r7;
    L9:
        if (TextUtils.isEmpty(r8) == false) goto L11;
        Log.i("GlobalFeatureGatingService", "uid is empty, reassign.");
    L12:
        ConcurrentHashMap r9 = (ConcurrentHashMap) ((ConcurrentHashMap) this.g).get(r1);
        if (r9 == null) goto L22;
        Iterator r10 = r9.values().iterator();
    L16:
        if (r10.hasNext() == false) goto L21;
        if (((CopyOnWriteArrayList) r10.next()).remove(r6) == false) goto L16;
        Log.i("GlobalFeatureGatingService", "remove fg update listener " + r6 + " success.");
        return;
    L21:
        Log.i("GlobalFeatureGatingService", "remove fg update listener " + r6 + " failed, not found.");
        return;
    L22:
        Log.i("GlobalFeatureGatingService", "remove fg update listener failed, not contains uid.");
        return;
    L11:
        r1 = r8;
        goto L12
    L7:
        r8 = r5 + r7;
        goto L9
    }

    @Override // jdb.e
    public final void T(String r7, String r8, jdb.c r9, String r10) {
        if (TextUtils.isEmpty(r8) == true) goto L45;
        if (r9 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r7) == false) goto L9;
        Log.i("GlobalFeatureGatingService", "uid is empty, reassign.");
        String r11 = "absent_user" + r10;
    L10:
        ConcurrentHashMap r12 = (ConcurrentHashMap) ((ConcurrentHashMap) this.g).get(r11);
        if (r12 != null) goto L26;
        Object r5 = this.d;
        monitor-enter(r5);
        ConcurrentHashMap r13 = (ConcurrentHashMap) ((ConcurrentHashMap) this.g).get(r11);     // Catch: Throwable -> L23
        if (r13 != null) goto L17;
        ConcurrentHashMap r14 = new ConcurrentHashMap();     // Catch: Throwable -> L23
        r14.put(r8, new CopyOnWriteArrayList(Collections.singletonList(r9)));     // Catch: Throwable -> L23
        ((ConcurrentHashMap) this.g).put(r11, r14);     // Catch: Throwable -> L23
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r9.getClass().getName() + " success. uidWithType: " + r11 + ", key: " + r8 + ". new uid.");     // Catch: Throwable -> L23
    L21:
        monitor-exit(r5);     // Catch: Throwable -> L23
        return;
    L17:
        Log.i("GlobalFeatureGatingService", "should missed fg update listener, new uid.");     // Catch: Throwable -> L23
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) r13.get(r8);     // Catch: Throwable -> L23
        if (r1 != null) goto L20;
        r13.put(r8, new CopyOnWriteArrayList(Collections.singletonList(r9)));     // Catch: Throwable -> L23
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r9.getClass().getName() + " success. uidWithType: " + r11 + ", key: " + r8 + ". new key.");     // Catch: Throwable -> L23
        goto L21
    L20:
        r1.add(r9);     // Catch: Throwable -> L23
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r9.getClass().getName() + " success. uidWithType: " + r11 + ", key: " + r8 + ".");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L26:
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) r12.get(r8);
        if (r0 != null) goto L39;
        Object r2 = this.d;
        monitor-enter(r2);
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) r12.get(r8);     // Catch: Throwable -> L36
        if (r3 != null) goto L33;
        CopyOnWriteArrayList r4 = new CopyOnWriteArrayList();     // Catch: Throwable -> L36
        r4.add(r9);     // Catch: Throwable -> L36
        r12.put(r8, r4);     // Catch: Throwable -> L36
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r9.getClass().getName() + " success. uidWithType: " + r11 + ", key: " + r8 + ". new key.");     // Catch: Throwable -> L36
    L34:
        monitor-exit(r2);     // Catch: Throwable -> L36
        return;
    L33:
        Log.i("GlobalFeatureGatingService", "should missed fg update listener, new key.");     // Catch: Throwable -> L36
        r3.add(r9);     // Catch: Throwable -> L36
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r9.getClass().getName() + " success. uidWithType: " + r11 + r8 + ".");     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    L39:
        r0.add(r9);
        Log.i("GlobalFeatureGatingService", "add fg update listener " + r9.getClass().getName() + " success. uidWithType: " + r11 + ", key: " + r8 + ".");
        return;
    L9:
        r11 = r7 + r10;
        goto L10
    }
}
