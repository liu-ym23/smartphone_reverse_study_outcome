package com.bytedance.android.live.browser.schema.impl.gecko;

import com.bytedance.android.live.base.model.morepanel.ColumnElement;
import com.bytedance.android.live.browser.schema.core.RedirectRuleCreator;
import com.bytedance.android.live.browser.schema.core.RedirectRuleSettingsHandler;
import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements com.bytedance.android.live.schema.api.c {
    public final d a;
    public final com.bytedance.android.live.browser.schema.core.strategy.d b;
    public final Subject<com.bytedance.android.live.browser.schema.core.d> c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f a;
        public final /* synthetic */ WebcastRedirectReportInfo b;
        public final /* synthetic */ com.bytedance.android.live.schema.api.b c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ Function3 e;

        public a(f r1, WebcastRedirectReportInfo r2, com.bytedance.android.live.schema.api.b r3, Function1 r4, Function3 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.browser.schema.core.d r6 = (com.bytedance.android.live.browser.schema.core.d) r5;
            this.a.c.onNext(r6);
            WebcastRedirectReportInfo r0 = this.b;
            String r1 = r6.b;
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.a("version", r1);
            int r2 = com.bytedance.android.live.browser.schema.core.c.d;
            com.bytedance.android.live.browser.schema.core.strategy.d r3 = this.a.b;
            Intrinsics.checkNotNullParameter(r6, "ruleSpec");
            Intrinsics.checkNotNullParameter(r3, "strategyRegister");
            com.bytedance.android.live.schema.api.a r4 = new RedirectRuleSettingsHandler(new com.bytedance.android.live.browser.schema.core.c(r6, com.bytedance.android.live.browser.schema.core.c.a.C0132c.b, new RedirectRuleCreator(r6, r3)), this.b).a(this.c.c);
            if (r4 == null) goto L8;
            this.b.a("get_type", "remote");
            this.d.invoke(r4);
            return;
        L8:
            Unit r7 = (Unit) this.e.invoke(Integer.valueOf(ColumnElement.typeLocalSimpleDivider), "Gecko CDN version " + r6.b, Boolean.FALSE);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ WebcastRedirectReportInfo a;
        public final /* synthetic */ Function3 b;

        public b(WebcastRedirectReportInfo r1, Function3 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            this.a.a("rule_type", "-1");
            this.b.invoke(Integer.valueOf(ColumnElement.typeLocalSimpleDivider), "Gecko CDN request fail, " + ((Throwable) r5).getMessage(), Boolean.FALSE);
        }
    }

    public f(d r2, com.bytedance.android.live.browser.schema.core.strategy.d r3, Subject<com.bytedance.android.live.browser.schema.core.d> r4) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r3, "strategyRegister");
        Intrinsics.checkNotNullParameter(r4, "publisher");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void c(com.bytedance.android.live.schema.api.b r9, WebcastRedirectReportInfo r11, Function1<? super com.bytedance.android.live.schema.api.a, Unit> r12, Function3<? super Integer, ? super String, ? super Boolean, Unit> r13) {
        Intrinsics.checkNotNullParameter(r9, "info");
        Intrinsics.checkNotNullParameter(r11, "reportInfo");
        Intrinsics.checkNotNullParameter(r12, "success");
        Intrinsics.checkNotNullParameter(r13, "fail");
        r11.a("schema_source", "api");
        d r0 = this.a;
        r0.getClass();
        Observable.create(new e(r0)).subscribeOn(Schedulers.io()).subscribe(new a(this, r11, r9, r12, r13), new b(r11, r13));
    }
}
