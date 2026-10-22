package com.obric.aikernel.middleware.impl.settings;

import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.store.IStoreManager;
import com.obric.aikernel.middleware.api.store.StoreManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSettingsConfig implements e4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t7.a f4584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f4585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<s7.f> f4587e;

    public AppSettingsConfig() {
        this.f4583a = "AppSettingsConfig";
        this.f4585c = new ConcurrentHashMap();
        this.f4586d = "aikernel_settings_config";
        this.f4587e = new LinkedHashSet();
    }

    public static final /* synthetic */ Set b(AppSettingsConfig r10) {
        return r10.f4587e;
    }

    public static final /* synthetic */ void c(AppSettingsConfig r10, List r11, String r12) {
        r10.j(r11, r12);
    }

    public static final /* synthetic */ List d(Lazy r10) {
        return k(r10);
    }

    private final String e(String r10) {
        String r11 = this.f4585c.get(r10);
        if (r11 != null) goto L6;
        String r12 = f(r10);
        this.f4585c.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    private final String f(String r10) {
        g();
        t7.a r11 = this.f4584b;
        if (r11 == null) goto L6;
        String r12 = r11.a(r10);
        if (r12 == null) goto L6;
        return r12;
    L6:
        return "";
    }

    private final void g() {
        if (this.f4584b == null) goto L5;
        return;
    L5:
        monitor-enter(AppSettingsConfig.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (this.f4584b != null) goto L11;
        StoreManager r10 = StoreManager.INSTANCE;     // Catch: Throwable -> L14
        if (r10.hasInit() == false) goto L11;
        this.f4584b = IStoreManager.a.a(r10, this.f4586d, 0, 2, null);     // Catch: Throwable -> L14
    L11:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(AppSettingsConfig.class);
    }

    private final void j(List<? extends s7.f> r10, String r11) {
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        s7.f r13 = (s7.f) r12.next();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L8
        r13.a(r11);     // Catch: Throwable -> L8
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L4
    }

    private static final List<s7.f> k(Lazy<? extends List<? extends s7.f>> r10) {
        return (List) r10.getValue();
    }

    @Override // e4.f
    public void a(f4.d r12) {
        if (r12 == null) goto L5;
        JSONObject r13 = r12.a();
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        Lazy r10 = LazyKt.lazy(new AppSettingsConfig$onSettingsUpdate$targetObservers$2(this));
        g();
        Iterator<String> r11 = r13.keys();
        Intrinsics.checkNotNullExpressionValue(r11, "data.keys()");
    L10:
        if (r11.hasNext() == false) goto L17;
        String r14 = r11.next();
        Object r15 = r13.opt(r14);
        if (r15 == null) goto L16;
        Intrinsics.checkNotNullExpressionValue(r15, "opt(key)");
        String r16 = r15.toString();
        ConcurrentHashMap<String, String> r17 = this.f4585c;
        Intrinsics.checkNotNullExpressionValue(r14, "key");
        r17.put(r14, r16);
        t7.a r18 = this.f4584b;
        if (r18 == null) goto L16;
        r18.b(r14, r16);
    L16:
        h.d(m0.a(new k0("settings-updater-" + r14).plus(z0.b())), null, null, new AppSettingsConfig$onSettingsUpdate$1$2(this, r14, r10, null), 3, null);
        goto L10
    L17:
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final String h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        String r11 = e(r10);
        AIKLog.INSTANCE.i(this.f4583a, "getAppValueWith key = " + r10 + " : " + r11);
        return r11;
    }

    public final void i() {
        e4.e.i(this, false);
    }

    public final void l(s7.f r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        Set<s7.f> r11 = this.f4587e;
        monitor-enter(r11);
        this.f4587e.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void m(s7.f r10) {
        Intrinsics.checkNotNullParameter(r10, "observer");
        Set<s7.f> r11 = this.f4587e;
        monitor-enter(r11);
        this.f4587e.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
