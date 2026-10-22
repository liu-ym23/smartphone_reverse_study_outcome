package com.ss.android.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.utils.n;
import com.ss.android.token.AuthTokenMultiProcessSharedProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class PassportExtraHeaderManager {
    public static final /* synthetic */ KProperty[] k = null;
    public static volatile PassportExtraHeaderManager l;
    public static final a m = null;
    public final ConcurrentHashMap<String, String> a;
    public volatile int b;
    public final Object c;
    public final AtomicBoolean d;
    public final Lazy e;
    public final Handler f;
    public volatile c g;
    public final Context h;
    public final AuthTokenMultiProcessSharedProvider.b i;
    public final boolean j;

    public static final class a {
        public a() {
        }
    }

    static {
        k = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PassportExtraHeaderManager.class), "backupSp", "getBackupSp()Landroid/content/SharedPreferences;"))};
        m = new a();
    }

    public final SharedPreferences b() {
        Lazy r0 = this.e;
        KProperty r1 = k[0];
        return (SharedPreferences) r0.getValue();
    }

    public final void f() {
        boolean r2 = false;
        this.b = this.i.d("passport_extra_header_modify_flag", 0);
        e();
        if (this.j == false) goto L39;
        Object r0 = this.c;
        monitor-enter(r0);
        com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L29
        int r1 = com.bytedance.sdk.account.settings.common.b.f;     // Catch: Throwable -> L29
        AuthTokenMultiProcessSharedProvider.a r3 = this.i.b();     // Catch: Throwable -> L29
        if (r1 <= 0) goto L10;
        SharedPreferences.Editor r4 = b().edit();     // Catch: Throwable -> L29
    L11:
        com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L29
        Iterator r5 = com.bytedance.sdk.account.settings.common.b.d.c.iterator();     // Catch: Throwable -> L29
    L13:
        if (r5.hasNext() == false) goto L20;
        String r6 = (String) r5.next();     // Catch: Throwable -> L29
        if (this.a.containsKey(r6) == false) goto L13;
        this.a.remove(r6);     // Catch: Throwable -> L29
        r3.b.putNull(r6);     // Catch: Throwable -> L29
        if (r4 == null) goto L19;
        r4.remove(r6);     // Catch: Throwable -> L29
    L19:
        tb7.a.a("PassportExtraHeaderManager", "clear deprecate header " + r6);     // Catch: Throwable -> L29
        r2 = true;
        goto L13
    L20:
        if (r2 == false) goto L26;
        this.b++;     // Catch: Throwable -> L29
        int r7 = this.b;     // Catch: Throwable -> L29
        r3.b.put("passport_extra_header_modify_flag", Integer.valueOf(r7));     // Catch: Throwable -> L29
        r3.a();     // Catch: Throwable -> L29
        if (r4 == null) goto L24;
        r4.putInt("passport_extra_header_modify_flag", r7);     // Catch: Throwable -> L29
    L24:
        if (r4 == null) goto L26;
        r4.apply();     // Catch: Throwable -> L29
    L26:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r0);
        return;
    L10:
        r4 = null;
    L29:
        th = move-exception;
        throw th;
    }

    public final void g() {
        Uri r0 = UriProtector.parse("content://" + AuthTokenMultiProcessSharedProvider.d(this.h, AuthTokenMultiProcessSharedProvider.class.getName()) + "/passport_extra_header_modify_flag/integer");
        StringBuilder r1 = new StringBuilder("PassportExtraHeaderManager.registerContentResolver: uri=");
        r1.append(r0);
        tb7.a.a("PassportExtraHeaderManager", r1.toString());
        this.h.getContentResolver().registerContentObserver(r0, false, new g(this, r0, new Handler(Looper.getMainLooper())));
        e();
    }

    public final void h() {
        if (this.d.get() == false) goto L5;
        return;
    L5:
        AtomicBoolean r0 = this.d;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.d.get() == false) goto L12;
        monitor-exit(r0);
        return;
    L12:
        if (this.j == false) goto L14;
        f();     // Catch: Throwable -> L18
    L15:
        this.d.set(true);     // Catch: Throwable -> L18
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L14:
        g();     // Catch: Throwable -> L18
        goto L15
    }

    public final void e() {
        com.bytedance.sdk.account.settings.common.b.a();
        Collection r0 = com.bytedance.sdk.account.settings.common.b.c.c;
        StringBuilder r1 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        com.bytedance.sdk.account.settings.common.b.a();
        int r3 = com.bytedance.sdk.account.settings.common.b.f;
        Iterator r4 = r0.iterator();
    L4:
        if (r4.hasNext() == false) goto L41;
        String r5 = (String) r4.next();
        boolean r6 = true;
        if (r5 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L4;
        r1.append(r5);
        r1.append(',');
        String r9 = this.i.f(r5);
        if (r9 != null) goto L17;
    L20:
        String r7 = "";
        if (r6 == false) goto L28;
        if (r3 != 2) goto L28;
        r9 = b().getString(r5, "");
        if (n.a(r9) == false) goto L28;
        tb7.a.d("PassportExtraHeaderManager", "loadSaveHeaders(), " + r5 + " load from backup sp success");
    L28:
        if (n.a(r9) == false) goto L39;
        if (d(r5, r9, "load") == false) goto L34;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.P == false) goto L34;
        String r10 = b().getString(r5, "");
        d(r5, r10, "load-backup");
        r9 = r10;
    L34:
        ConcurrentHashMap<String, String> r11 = this.a;
        if (r9 == null) goto L37;
        r7 = r9;
    L37:
        r11.put(r5, r7);
    L39:
        if (n.a(r9) == false) goto L4;
        r2.append(r5);
        r2.append(',');
        goto L4
    L17:
        if (r9.length() == 0) goto L20;
        r6 = false;
        goto L20
    L8:
        if (r5.length() == 0) goto L11;
        r8 = false;
        goto L12
    L41:
        tb7.a.d("PassportExtraHeaderManager", "loadSaveHeaders(), settingsHeader=[" + r1 + "], loadSuccessHeader=[" + r2 + ']');
    }

    public PassportExtraHeaderManager(Context r1, AuthTokenMultiProcessSharedProvider.b r2, boolean r3) {
        this.h = r1;
        this.i = r2;
        this.j = r3;
        this.a = new ConcurrentHashMap();
        this.c = new Object();
        this.d = new AtomicBoolean(false);
        this.e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new PassportExtraHeaderManager$backupSp$2(this));
        this.f = new Handler(Looper.getMainLooper());
    }

    @JvmStatic
    public static final PassportExtraHeaderManager c(Context r2, AuthTokenMultiProcessSharedProvider.b r3, boolean r4) {
        m.getClass();
        if (l == null) goto L5;
    L15:
        PassportExtraHeaderManager r5 = l;
        if (r5 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        return r5;
    L5:
        monitor-enter(PassportExtraHeaderManager.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (l != null) goto L9;
        l = new PassportExtraHeaderManager(r2, r3, r4);     // Catch: Throwable -> L12
    L9:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(PassportExtraHeaderManager.class);
        goto L15
    }

    public final void a(String r12, int r13, Map<String, String> r14) {
        com.bytedance.sdk.account.settings.common.b.a();
        long r0 = com.bytedance.sdk.account.settings.common.b.g;
        if (r0 > 0) goto L5;
        return;
    L5:
        Runnable r2 = this.g;
        if (r2 == null) goto L8;
        this.f.removeCallbacks(r2);
    L8:
        Runnable r3 = new c(this, SystemClock.elapsedRealtime(), r12, r13, r14);
        this.g = r3;
        this.f.postDelayed(r3, r0);
    }

    public final boolean d(String r13, String r14, String r15) {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.M == true) goto L7;
        r13 = null;
    L7:
        if (r13 != null) goto L9;
        return false;
    L9:
        if (StringsKt.equals("x-tt-token-supplement", r13, true) == true) goto L12;
        r13 = null;
    L12:
        if (r13 == null) goto L67;
        com.bytedance.sdk.account.settings.common.a.a();
        String r16 = com.bytedance.sdk.account.settings.common.a.N;
        if (r16 != null) goto L16;
    L57:
        tb7.a.d("PassportExtraHeaderManager", "x-tt-token-supplement value ok, template=null/empty, supplement=" + r14 + ", scene=" + r15);
        return false;
    L16:
        if ((!StringsKt.isBlank(r16)) == false) goto L18;
        String r6 = r16;
    L19:
        if (r6 == null) goto L57;
        List r17 = StringsKt.split$default(r6, new String[]{","}, false, 0, 6, null);
        if (r17 == null) goto L57;
        List r18 = r17;
        if ((r18 instanceof Collection) == true) goto L25;
    L27:
        Iterator r19 = r18.iterator();
    L29:
        if (r19.hasNext() == false) goto L38;
        String r5 = (String) r19.next();
        if (r14 != null) goto L33;
    L35:
        boolean r7 = false;
    L36:
        if (r7 == false) goto L29;
        boolean r110 = true;
    L39:
        StringBuilder r1 = new StringBuilder("x-tt-token-supplement value ");
        if (r110 == false) goto L42;
        String r8 = "error";
    L43:
        r1.append(r8);
        r1.append(", template=");
        com.bytedance.sdk.account.settings.common.a.a();
        r1.append(com.bytedance.sdk.account.settings.common.a.N);
        r1.append(", supplement=");
        r1.append(r14);
        r1.append(", scene=");
        r1.append(r15);
        String r2 = r1.toString();
        if (r110 == false) goto L55;
        tb7.a.b("PassportExtraHeaderManager", r2);
        ConcurrentHashMap r3 = b.a;
        AtomicBoolean r4 = new AtomicBoolean(false);
        AtomicBoolean r9 = (AtomicBoolean) b.a.putIfAbsent(r15, r4);
        if (r9 == null) goto L49;
        r4 = r9;
    L49:
        if (r4.compareAndSet(false, true) == false) goto L68;
        com.bytedance.sdk.account.settings.common.a.a();
        String r0 = com.bytedance.sdk.account.settings.common.a.N;
        String r10 = this.a.toString();
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L53
        r11.put("supplement", r14);     // Catch: Throwable -> L53
        r11.put("match_template", r0);     // Catch: Throwable -> L53
        r11.put("map_info", r10);     // Catch: Throwable -> L53
        r11.put("scene", r15);     // Catch: Throwable -> L53
        com.bytedance.sdk.account.monitor.a.a("passport_supplement_value_error", r11);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        tb7.a.c("AccountMonitorUtil", "onSupplementValueError", th);
    L68:
        return r110;
    L55:
        tb7.a.d("PassportExtraHeaderManager", r2);
        goto L68
    L42:
        r8 = "ok";
        goto L43
    L33:
        if (StringsKt.contains$default(r14, r5, false, 2, null) != true) goto L35;
        r7 = true;
    L38:
        r110 = false;
        goto L39
    L25:
        if (r18.isEmpty() == false) goto L27;
    L18:
        r6 = null;
        goto L19
    L67:
        return false;
    }
}
