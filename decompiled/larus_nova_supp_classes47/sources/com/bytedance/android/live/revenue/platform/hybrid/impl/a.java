package com.bytedance.android.live.revenue.platform.hybrid.impl;

import a9.j;
import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wy0.f;
import wy0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements vy0.c, o {
    public final com.bytedance.android.livesdk.revenue.service.hybrid.d a;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.hybrid.impl.a$a, reason: collision with other inner class name */
    public static final class C0092a<T> implements SingleOnSubscribe {
        public final /* synthetic */ String a;

        /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.hybrid.impl.a$a$a, reason: collision with other inner class name */
        public static final class C0093a implements com.bytedance.android.live.schema.api.d.a {
            public final /* synthetic */ SingleEmitter a;

            public C0093a(SingleEmitter r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.live.schema.api.d.a
            public final void onSuccess(String r2) {
                Intrinsics.checkNotNullParameter(r2, "finalSchema");
                this.a.onSuccess(r2);
            }

            @Override // com.bytedance.android.live.schema.api.d.a
            public final void onFail(int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
                this.a.onError(com.bytedance.platform.aio.d.e(r3, null));
            }
        }

        public C0092a(String r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<String> r6) {
            Intrinsics.checkNotNullParameter(r6, "emitter");
            com.bytedance.android.live.schema.api.d r4 = null;
            if (StringsKt.contains$default(this.a, "webcast_redirect", false, 2, null) == false) goto L13;
            com.bytedance.android.live.schema.api.b r0 = com.bytedance.android.live.schema.api.utils.b.b(this.a);
            if (r0 != null) goto L8;
            r6.onSuccess(this.a);
            return;
        L8:
            IBrowserService r1 = k.f(IBrowserService.class);
            if (r1 == null) goto L11;
            r4 = r1.createRedirectProcessor();
        L11:
            if (r4 == null) goto L15;
            r4.a(r0, new C0093a(r6));
            return;
        L15:
            return;
        L13:
            r6.onSuccess(this.a);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ az0.b a;

        public b(az0.b r1) {
            this.a = r1;
        }

        public final void run() {
            j.a.x0(this.a);
        }
    }

    public static final class c implements f, wy0.d {
        public final /* synthetic */ wy0.d a;
        public final /* synthetic */ wy0.d b;

        @Override // wy0.d
        public final Map<String, h<Object, ?>> c(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return this.a.c(r2);
        }

        @Override // wy0.d
        public final Map<String, g<Object, ?>> f(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return this.a.f(r2);
        }

        public c(wy0.d r1) {
            this.b = r1;
            this.a = r1;
        }

        @Override // wy0.f
        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.emptyMap();
        }

        @Override // wy0.f
        public final Map<String, g<?, ?>> d(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.emptyMap();
        }
    }

    public static final class d<T, R> implements Function {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r2) {
            cq2.d r3 = (cq2.d) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return new az0.c(r3);
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a(com.bytedance.android.livesdk.revenue.service.hybrid.d r2) {
        Intrinsics.checkNotNullParameter(r2, "hostService");
        this.a = r2;
    }

    @Override // vy0.c, vy0.b
    public final Observable<wy0.g> B0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.a.registerJsEventSubscriber(r2).map(d.a);
    }

    @Override // vy0.c
    public final Disposable O3(f r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        az0.b r0 = new az0.b(r2);
        j.a.I0(r0);
        return Disposables.fromAction(new b(r0));
    }

    @Override // vy0.c
    public final Uri Q(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        this.a.sb().getClass();
        Intrinsics.checkNotNullParameter(r3, "key");
        return i2.c(r3);
    }

    @Override // vy0.b
    public final Disposable Sb(wy0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        if ((r2 instanceof f) == false) goto L7;
        return O3((f) r2);
    L7:
        return O3(new c(r2));
    }

    @Override // vy0.b
    public final String appendCommonParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return this.a.appendCommonParams(r2);
    }

    @Override // vy0.c
    public final void tn(zy0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
        this.a.to(r2.c());
    }

    @Override // vy0.c
    public final String appendFeedCommonParams(String r2, IRoom r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "room");
        return this.a.appendFeedCommonParams(r2, r3);
    }

    @Override // vy0.c
    public final void j1(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uriString");
        this.a.j1(r2, r3);
    }

    @Override // vy0.c, vy0.b
    public final void sendEventToAllJsBridges(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        this.a.sendEventToAllJsBridges(r2, r3);
    }

    @Override // vy0.c
    public final Single<String> v8(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "context");
        return Single.create(new C0092a(r2));
    }

    @Override // vy0.c
    public final e J8(Context r5, Uri r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        bz0.d r0 = new bz0.d();
        if (r6 == null) goto L5;
        Intrinsics.checkNotNullParameter(r6, "uri");
        r0.a = r6;
    L5:
        if (r7 == null) goto L7;
        Unit r8 = (Unit) r7.invoke(r0);
    L7:
        HybridCard r9 = this.a.w9(r5, new dz0.a(r0.a, r0.b, r0.d).a(), new cz0.a(r0.c));
        if (r9 != null) goto L12;
        return null;
    L12:
        return new e(r9, r0);
    }

    @Override // vy0.c, vy0.b
    public final HybridDialogImpl U0(Context r5, Uri r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        bz0.e r0 = new bz0.e();
        if (r6 == null) goto L5;
        Intrinsics.checkNotNullParameter(r6, "uri");
        r0.a = r6;
    L5:
        if (r7 == null) goto L7;
        Unit r8 = (Unit) r7.invoke(r0);
    L7:
        HybridDialog r9 = this.a.pn(r5, new dz0.a(r0.a, r0.b, r0.d).a(), new cz0.a(r0.c), null);
        if (r9 != null) goto L10;
        return null;
    L10:
        return new HybridDialogImpl(r0, r9);
    }

    @Override // vy0.c
    public final HybridDialogImpl mg(Context r2, Uri r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        IHybridComponent r5 = this.a.ck(r2, r3);
        if ((r5 instanceof HybridDialog) == true) goto L5;
        r5 = null;
    L5:
        HybridDialog r6 = (HybridDialog) r5;
        if (r6 != null) goto L8;
        return null;
    L8:
        bz0.e r7 = new bz0.e();
        if (r4 == null) goto L12;
        Unit r8 = (Unit) r4.invoke(r7);
    L12:
        return new HybridDialogImpl(r7, r6);
    }

    @Override // vy0.c
    public final com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a q8(Context r2, Uri r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return Ui(r2, r3, null, r4);
    }

    @Override // vy0.c
    public final void x6(Context r2, String r3, Function1<? super yy0.e, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        cq2.a r5 = this.a.buildFullScreenWebPage(r2, r3);
        Unit r6 = (Unit) r4.invoke(new bz0.h(r5));
        r5.b();
    }

    @Override // vy0.c
    public final com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a Ui(Context r9, Uri r10, Object r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        bz0.c r0 = new bz0.c();
        if (r10 == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, "uri");
        r0.a = r10;
    L5:
        if (r13 == null) goto L8;
        Unit r14 = (Unit) r13.invoke(r0);
    L8:
        return new com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class).Hh(r9, r0.a, new cz0.a(r0.c), r0.e, r12, r0.f));
    }

    @Override // vy0.c
    public final void addHybridDebugTool(Context r2, ViewGroup r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        Intrinsics.checkNotNullParameter(r4, "url");
        this.a.addHybridDebugTool(r2, r3, r4, r5);
    }
}
