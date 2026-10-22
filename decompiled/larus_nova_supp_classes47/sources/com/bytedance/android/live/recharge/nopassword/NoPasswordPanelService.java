package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.recharge.trace.RechargeTraceStep;
import com.bytedance.android.live.recharge.utils.s;
import com.bytedance.android.live.revenue.common.q;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NoPasswordPanelService implements com.bytedance.android.live.recharge.nopassword.a, o {
    public AnonymousClass1 a;
    public final BehaviorSubject<com.bytedance.android.live.recharge.platform.model.f> b;
    public final Lazy c;
    public final com.bytedance.android.live.recharge.panel.context.f d;
    public final com.bytedance.android.live.recharge.nopassword.b e;
    public final ILinkService f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ NoPasswordPanelService a;

        public a(NoPasswordPanelService r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.recharge.platform.model.f r5 = (com.bytedance.android.live.recharge.platform.model.f) r4;
            this.a.b.onNext(r5);
            NoPasswordPanelService r0 = this.a;
            boolean r6 = r5.g();
            Pair[] r1 = new Pair[2];
            r1[0] = TuplesKt.to("no_password_scene", ((NoPasswordScene) r0.c.getValue()).getValue());
            if (r6 == false) goto L5;
            String r7 = DataType.TRUE;
        L6:
            r1[1] = TuplesKt.to("sign_result", r7);
            LinkedHashMap r8 = new LinkedHashMap();
            MapsKt.putAll(r8, r1);
            dw0.c r2 = dw0.c.b;
            r2.b(r8, "", CollectionsKt.emptyList());
            r2.c("livesdk_no_password_sign_result", r8, CollectionsKt.emptyList());
            int r3 = s.a;
            s.a(RechargeTraceStep.STEP_NO_PASSWORD_SIGN_RESULT, q.c(r8));
            return;
        L5:
            r7 = DataType.FALSE;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.nopassword.NoPasswordPanelService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/recharge/nopassword/NoPasswordPanelService$onStart$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class AnonymousClass1 implements Observer<Long> {
        public final void onChanged(Object r1) {
            Long r2 = (Long) r1;
            if (r2 != null) goto L5;
            return;
        L5:
            r2.longValue();
            r2.longValue();
            throw null;
        }
    }

    @Override // com.bytedance.android.live.recharge.nopassword.a
    public final com.bytedance.revenue.platform.api.core.rx.a<com.bytedance.android.live.recharge.platform.model.f> observeSignInfo() {
        return new com.bytedance.revenue.platform.api.core.rx.b(this.b);
    }

    public final void onStart() {
        this.e.T0(this.d.i);
    }

    public final void onStop() {
        AnonymousClass1 r0 = this.a;
        if (r0 == null) goto L5;
        this.f.mo470getPkService().f(r0);
        this.f.mo468getMultiAnchorService().f(r0);
    L5:
        this.a = null;
    }

    public final void a(Long r7) {
        com.bytedance.android.live.recharge.nopassword.b r0 = this.e;
        long r1 = this.d.d;
        r0.p0();
        Pair[] r2 = {TuplesKt.to("no_password_scene", ((NoPasswordScene) this.c.getValue()).getValue())};
        LinkedHashMap r3 = new LinkedHashMap();
        MapsKt.putAll(r3, r2);
        dw0.c r4 = dw0.c.b;
        r4.b(r3, "", CollectionsKt.emptyList());
        r4.c("livesdk_no_password_sign_info", r3, CollectionsKt.emptyList());
        int r5 = s.a;
        s.a(RechargeTraceStep.STEP_NO_PASSWORD_SIGN_INFO, q.c(r3));
        if (r7 == null) goto L5;
        long r6 = r7.longValue();
    L6:
        long r8 = d.a.b;
        RechargeBizScene r9 = com.bytedance.android.live.recharge.panel.b.a(this.d.i);
        com.bytedance.android.live.recharge.nopassword.b r10 = this.e;
        if (r6 >= r8) goto L9;
        r6 = r8;
    L9:
        Single<com.bytedance.android.live.recharge.platform.model.f> r12 = r10.b0(r6, r9);
        int r13 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r12.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a), this.d.a);
        return;
    L5:
        r6 = this.d.i.d;
        goto L6
    }

    @Override // com.bytedance.android.live.recharge.nopassword.a
    public final void requestSignInfo(Long r1) {
        a(r1);
    }

    public NoPasswordPanelService(com.bytedance.android.live.recharge.panel.context.f r2, com.bytedance.android.live.recharge.nopassword.b r3, ILinkService r4) {
        Intrinsics.checkNotNullParameter(r2, "panelContext");
        Intrinsics.checkNotNullParameter(r3, "noPasswordService");
        Intrinsics.checkNotNullParameter(r4, "linkService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        int r5 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.b = BehaviorSubject.create();
        this.c = LazyKt.lazy(new NoPasswordPanelService$scene$2(this));
    }
}
