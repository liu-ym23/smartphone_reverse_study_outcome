package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.revenue.platform.container.impl.core.NotifyServiceCenterStateRequest;
import com.bytedance.platform.aio.ServiceHub;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class m implements dy0.c, ny0.a, com.bytedance.android.live.revenue.platform.container.impl.core.g {
    public static final List<String> e = null;
    public final BehaviorSubject<a> a;
    public final ServiceHub b;
    public final Map<KClass<?>, Object> c;
    public final List<String> d;

    public static final class a {
        public final com.bytedance.platform.aio.a a;
        public final NotifyServiceCenterStateRequest.State b;

        public a() {
            this(0);
        }

        public /* synthetic */ a(int r2) {
            this(null, NotifyServiceCenterStateRequest.State.STOPPED);
        }

        public a(com.bytedance.platform.aio.a r2, NotifyServiceCenterStateRequest.State r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    static {
        e = CollectionsKt.listOf(new String[]{"webcast.revenue.biz.gift.dialog.expansion_controls.ExpansionControlsDataUseCase", "webcast.revenue.biz.gift.dialog.top.GiftTopPanelDataUseCase", "webcast.revenue.biz.gift.dialog.top.GiftDIYCardService", "webcast.revenue.biz.gift.dialog.top.GiftBuffCardService", "webcast.revenue.biz.gift.dialog.top.GiftOperationDataUseCase"});
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final void E() {
        this.a.onNext(new a(0));
        ((ArrayList) this.d).clear();
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final NotifyServiceCenterStateRequest.State b0() {
        Object r0 = this.a.getValue();
        Intrinsics.checkNotNull(r0);
        return ((a) r0).b;
    }

    public m() {
        int r0 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.a = BehaviorSubject.createDefault(new a(0));
        this.b = new ServiceHub();
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
    }

    @Override // ny0.a
    public final void J0(com.bytedance.platform.aio.a r3) {
        Intrinsics.checkNotNullParameter(r3, "driver");
        ServiceHub r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "driver");
        if (r1.a.add(r3) == false) goto L6;
        r3.g(r1);
        return;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final void L0(RevenueJsDriver r4) {
        Intrinsics.checkNotNullParameter(r4, "driver");
        jy0.b.d("[AioLink]", "preloadCenterDriver");
        this.a.onNext(new a(r4, NotifyServiceCenterStateRequest.State.PRE_STARTED));
        ((ArrayList) this.d).clear();
    }

    @Override // ny0.a
    public final void g(com.bytedance.platform.aio.a r2) {
        Intrinsics.checkNotNullParameter(r2, "driver");
        this.b.c(r2);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final void I(List r4, RevenueJsDriver r5) {
        Intrinsics.checkNotNullParameter(r4, "interfaceIds");
        Intrinsics.checkNotNullParameter(r5, "driver");
        jy0.b.d("[AioLink]", "loadedCenterDriver");
        Object r0 = this.a.getValue();
        Intrinsics.checkNotNull(r0);
        if (Intrinsics.areEqual(r5, ((a) r0).a) == false) goto L7;
        Object r1 = this.a.getValue();
        Intrinsics.checkNotNull(r1);
        if (((a) r1).b != NotifyServiceCenterStateRequest.State.STARTED) goto L7;
        this.a.onNext(new a(r5, NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED));
        ((ArrayList) this.d).addAll(r4);
        return;
    L7:
        jy0.b.c("RevenueContainerRpcServiceImpl", "wrong centerDriver state", null, 4);
        int r6 = com.bytedance.android.live.core.utils.w.a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L11;
        return;
    L11:
        throw new IllegalStateException("wrong centerDriver state");
    }

    @Override // ny0.a
    public final void a(String r2, com.bytedance.platform.aio.a r3) {
        Intrinsics.checkNotNullParameter(r2, "interfaceId");
        Intrinsics.checkNotNullParameter(r3, "driver");
        this.b.a(r2, r3);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final void w0(List r4, RevenueJsDriver r5) {
        Intrinsics.checkNotNullParameter(r4, "interfaceIds");
        Intrinsics.checkNotNullParameter(r5, "driver");
        jy0.b.d("[AioLink]", "startCenterDriver");
        this.a.onNext(new a(r5, NotifyServiceCenterStateRequest.State.STARTED));
        ((ArrayList) this.d).clear();
        ArrayList r6 = (ArrayList) this.d;
        r6.addAll(r4);
    }

    @Override // ny0.a
    public final Object A(String r10, String r12, JsonObject r13, String r14, i57.g r15) {
        Intrinsics.checkNotNullParameter(r10, "interfaceId");
        Intrinsics.checkNotNullParameter(r12, "methodId");
        Intrinsics.checkNotNullParameter(r13, "argument");
        Intrinsics.checkNotNullParameter(r14, "url");
        Intrinsics.checkNotNullParameter(r15, "callContext");
        com.bytedance.platform.aio.a r0 = this.b.b(r10);
        if (r0 == null) goto L5;
        j57.a r16 = r0.c(r10, r12, new v(r13, null, r14, "initial_prop", r15));
    L6:
        if (r16 == null) goto L11;
        Exception r17 = r16.c;
        if (r17 == null) goto L11;
        throw r17;
    L11:
        if (r16 != null) goto L13;
        return null;
    L13:
        return r16.b;
    L5:
        r16 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.g
    public final Observable K(Set r9, String r10, String r12, z r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r9, "waitForState");
        Intrinsics.checkNotNullParameter(r10, "interfaceId");
        Intrinsics.checkNotNullParameter(r12, "methodId");
        Intrinsics.checkNotNullParameter(r13, "arguments");
        CompositeDisposable r3 = new CompositeDisposable();
        if (r14 == false) goto L14;
        a r15 = (a) this.a.getValue();
        if (r15 == null) goto L10;
        NotifyServiceCenterStateRequest.State r16 = r15.b;
        if (r16 == null) goto L10;
        boolean r17 = r9.contains(r16);
    L11:
        if (r17 == true) goto L14;
        com.bytedance.revenue.platform.api.core.rx.l r18 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return Observable.error(com.bytedance.platform.aio.d.f(r10));
    L10:
        r17 = false;
    L14:
        com.bytedance.revenue.platform.api.core.rx.l r19 = com.bytedance.revenue.platform.api.core.rx.l.a;
        return Observable.create(new p(this, r3, r9, r10, r12, r13));
    }
}
