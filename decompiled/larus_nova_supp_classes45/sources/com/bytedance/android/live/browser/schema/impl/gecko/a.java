package com.bytedance.android.live.browser.schema.impl.gecko;

import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.browser.schema.core.RedirectRuleCreator;
import com.bytedance.android.live.browser.schema.core.RedirectRuleSettingsHandler;
import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements com.bytedance.android.live.schema.api.c, la1.a.a {
    public volatile com.bytedance.android.live.browser.schema.core.c a;
    public final Object b;
    public final Lazy c;
    public final d d;
    public final com.bytedance.android.live.browser.schema.core.strategy.d e;
    public final g f;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.impl.gecko.a$a, reason: collision with other inner class name */
    public static final class C0134a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.browser.schema.core.d r5 = (com.bytedance.android.live.browser.schema.core.d) r4;
            com.bytedance.android.live.schema.api.utils.a.d("GeckoCDNCacheInterceptor", "update from self");
            Object r0 = this.a.b;
            monitor-enter(r0);
            this.a.f.a(r5);     // Catch: Throwable -> L7
            a r1 = this.a;     // Catch: Throwable -> L7
            int r2 = com.bytedance.android.live.browser.schema.core.c.d;     // Catch: Throwable -> L7
            r1.a = com.bytedance.android.live.browser.schema.core.c.b.b(r5, r1.e);     // Catch: Throwable -> L7
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.schema.api.utils.a.b("GeckoCDNCacheInterceptor", "refresh gecko cache fail", (Throwable) r3);
        }
    }

    static {
    }

    public final boolean a() {
        return LiveHybridSettingKeys.LIVE_ROMA_SDK_POLL_CONFIG.getValue().booleanValue();
    }

    public final long d() {
        return LiveHybridSettingKeys.LIVE_ROMA_SDK_POLL_INTERNAL_CONFIG.getValue().longValue();
    }

    public final void e() {
        com.bytedance.android.live.schema.api.utils.a.a("GeckoCDNCacheInterceptor", "refresh cache");
        d r0 = this.d;
        r0.getClass();
        Observable.create(new e(r0)).subscribeOn(Schedulers.io()).subscribe(new b(this), c.a);
    }

    public final void b() {
        e();
    }

    public a(d r2, com.bytedance.android.live.browser.schema.core.strategy.d r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "geckoDataSource");
        Intrinsics.checkNotNullParameter(r3, "strategyRegister");
        Intrinsics.checkNotNullParameter(r4, "diskStorage");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.b = new Object();
        Lazy r5 = LazyKt.lazy(GeckoCDNCacheInterceptor$cacheUpdater$2.INSTANCE);
        this.c = r5;
        ((Subject) r5.getValue()).subscribe(new com.bytedance.android.live.browser.schema.impl.gecko.b(this), com.bytedance.android.live.browser.schema.impl.gecko.c.a);
    }

    public final void c(com.bytedance.android.live.schema.api.b r6, WebcastRedirectReportInfo r7, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r8, Function3<? super Integer, ? super String, ? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r6, "info");
        Intrinsics.checkNotNullParameter(r7, "reportInfo");
        Intrinsics.checkNotNullParameter(r8, "success");
        Intrinsics.checkNotNullParameter(r9, "fail");
        r7.a("schema_source", "api");
        Object r0 = this.b;
        monitor-enter(r0);
        com.bytedance.android.live.browser.schema.core.c r1 = this.a;     // Catch: Throwable -> L9
        com.bytedance.android.live.browser.schema.core.c r2 = null;
        if (r1 != null) goto L7;
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        r7.a("get_type", "memory");     // Catch: Throwable -> L9
    L21:
        monitor-exit(r0);
        if (r1 == null) goto L32;
        String r3 = r1.a.b;
        if (r3 != null) goto L27;
        r3 = "";
    L27:
        r7.a("version", r3);
        com.bytedance.android.live.schema.api.a r11 = new RedirectRuleSettingsHandler(r1, r7).a(r6.c);
        if (r11 == null) goto L30;
        r8.invoke(r11);
        return;
    L30:
        Unit r12 = (Unit) r9.invoke(Integer.valueOf(ColumnElement.typeLocalSimpleDivider), "cache exists", Boolean.FALSE);
        return;
    L32:
        r7.a("rule_type", "-1");
        r9.invoke(Integer.valueOf(ColumnElement.typeLocalSimpleDivider), "cache not exists", Boolean.FALSE);
        return;
    L14:
        com.bytedance.android.live.browser.schema.core.d r4 = this.f.restore();     // Catch: Throwable -> L9
        if (r4 == null) goto L17;
        int r5 = com.bytedance.android.live.browser.schema.core.c.d;     // Catch: Throwable -> L9
        com.bytedance.android.live.browser.schema.core.strategy.d r13 = this.e;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r4, "ruleSpec");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r13, "strategyRegister");     // Catch: Throwable -> L9
        r2 = new com.bytedance.android.live.browser.schema.core.c(r4, com.bytedance.android.live.browser.schema.core.c.a.C0132c.b, new RedirectRuleCreator(r4, r13));     // Catch: Throwable -> L9
    L17:
        this.a = r2;     // Catch: Throwable -> L9
        if (r2 == null) goto L20;
        r7.a("get_type", "disk");     // Catch: Throwable -> L9
    L20:
        r1 = r2;
        goto L21
    L7:
        if (r1.b.a() == false) goto L12;
        e();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
