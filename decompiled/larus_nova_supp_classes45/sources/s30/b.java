package s30;

import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.browser.schema.core.RedirectRuleSettingsHandler;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements com.bytedance.android.live.schema.api.c {
    public volatile com.bytedance.android.live.browser.schema.core.c a;
    public final Object b;
    public final com.bytedance.android.live.browser.schema.core.strategy.d c;

    public static final class a {
    }

    /* JADX INFO: renamed from: s30.b$b, reason: collision with other inner class name */
    public static final class C0273b<T> implements Consumer {
        public final /* synthetic */ WebcastRedirectReportInfo a;
        public final /* synthetic */ com.bytedance.android.live.schema.api.b b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ Function3 d;

        public C0273b(WebcastRedirectReportInfo r1, com.bytedance.android.live.schema.api.b r2, Function1 r3, Function3 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            this.a.a("ugsettings_exist", GamePromoteDataContext.GAME_TYPE_MOBILE);
            com.bytedance.android.live.schema.api.a r5 = new RedirectRuleSettingsHandler((com.bytedance.android.live.browser.schema.core.c) r4, this.a).a(this.b.c);
            if (r5 == null) goto L5;
            this.a.a("get_type", IInteractGameMonitorService.LOCAL_SOURCE);
            this.c.invoke(r5);
            return;
        L5:
            Unit r6 = (Unit) this.d.invoke(Integer.valueOf(ColumnElement.typeLocalSimpleDivider), "UG Settings exists", Boolean.FALSE);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ WebcastRedirectReportInfo a;

        public c(WebcastRedirectReportInfo r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            WebcastRedirectReportInfo r5 = this.a;
            r5.a("ugsettings_exist", "0");
            r5.a("rule_type", "-1");
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.live.browser.schema.core.c r2 = (com.bytedance.android.live.browser.schema.core.c) r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Function3 a;

        public e(Function3 r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            boolean r0 = r7 instanceof TimeoutException;
            Integer r1 = Integer.valueOf(ColumnElement.typeLocalSimpleDivider);
            if (r0 == false) goto L5;
            com.bytedance.android.live.schema.api.utils.a.b("UGSettingsInterceptor", "UG Settings timeout", null);
            this.a.invoke(r1, "UG Settings timeout", Boolean.FALSE);
            return;
        L5:
            String r2 = r7.getMessage();
            String r4 = "UG Settings not exists";
            if (r2 != null) goto L8;
            r2 = "UG Settings not exists";
        L8:
            com.bytedance.android.live.schema.api.utils.a.b("UGSettingsInterceptor", r2, null);
            Function3 r3 = this.a;
            String r8 = r7.getMessage();
            if (r8 == null) goto L12;
            r4 = r8;
        L12:
            r3.invoke(r1, r4, Boolean.FALSE);
        }
    }

    static {
    }

    public b(com.bytedance.android.live.browser.schema.core.strategy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "strategyRegister");
        this.c = r2;
        this.b = new Object();
    }

    public final void c(com.bytedance.android.live.schema.api.b r5, WebcastRedirectReportInfo r6, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r7, Function3<? super Integer, ? super String, ? super Boolean, Unit> r8) {
        Intrinsics.checkNotNullParameter(r5, "info");
        Intrinsics.checkNotNullParameter(r6, "reportInfo");
        Intrinsics.checkNotNullParameter(r7, "success");
        Intrinsics.checkNotNullParameter(r8, "fail");
        if (((Boolean) com.bytedance.android.live.core.setting.c.a.getValue()).booleanValue() == true) goto L5;
    L8:
        r6.a("schema_source", "ugsettings");
        com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "request ugsettings, key data.common_info.extra.sjb_schema");
        Observable.concat(CollectionsKt.listOf(new Observable[]{Observable.create(new s30.e(this, r6)), Observable.create(new s30.d(this, r6)), Observable.create(new s30.c(this, r6))})).firstOrError().timeout(10, TimeUnit.SECONDS).doOnSuccess(new C0273b(r6, r5, r7, r8)).doOnError(new c(r6)).subscribe(d.a, new e(r8));
        return;
    L5:
        if (Intrinsics.areEqual(r5, com.bytedance.android.live.schema.api.utils.b.a) == false) goto L8;
        r8.invoke(Integer.valueOf(ColumnElement.typeLocalSimpleDivider), "UG Settings skip", Boolean.FALSE);
        com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "UG Settings skip");
    }
}
