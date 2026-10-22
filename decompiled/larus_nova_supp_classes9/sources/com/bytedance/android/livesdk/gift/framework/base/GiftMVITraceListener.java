package com.bytedance.android.livesdk.gift.framework.base;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.q;
import com.bytedance.android.anya.s;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelEffect;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.BackpressureStrategy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lb.f;
import lb.i;
import lb.j;
import lb.k;
import lb.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITraceListener implements lb.b {
    public static final /* synthetic */ int e = 0;
    public volatile boolean a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r1) {
            ((Function0) r1).invoke();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            int r0 = x8.a.a;
            x8.a.b("GiftMVITraceListener", "report error" + ((Throwable) r3).getMessage(), false);
        }
    }

    public static final class c {
    }

    static {
    }

    public GiftMVITraceListener() {
        Lazy r0 = LazyKt.lazy(GiftMVITraceListener$compositeDisposable$2.INSTANCE);
        this.b = r0;
        Lazy r1 = LazyKt.lazy(GiftMVITraceListener$actionBus$2.INSTANCE);
        this.c = r1;
        this.d = LazyKt.lazy(GiftMVITraceListener$traceGson$2.INSTANCE);
        RxUtilKt.c(((PublishSubject) r1.getValue()).toFlowable(BackpressureStrategy.BUFFER).onBackpressureBuffer(127).observeOn(Schedulers.io()).subscribe(a.a, b.a), (CompositeDisposable) r0.getValue());
    }

    public final void b(q r2) {
        Intrinsics.checkNotNullParameter(r2, "bindingInstance");
        ((CompositeDisposable) this.b.getValue()).clear();
    }

    public final f j(s r3) {
        Intrinsics.checkNotNullParameter(r3, "dataEffect");
        com.bytedance.android.anya.a r4 = r3.a;
        if ((r4 instanceof com.bytedance.android.anya.a.a) == true) goto L5;
        r4 = null;
    L5:
        com.bytedance.android.anya.a.a r5 = (com.bytedance.android.anya.a.a) r4;
        if (r5 == null) goto L15;
        final p r6 = r5.a;
        if (r6 == null) goto L15;
        if ((r6 instanceof GiftAction) == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L15;
        ((PublishSubject) this.c.getValue()).onNext(new GiftMVITraceListener$onFlow$$inlined$let$lambda$1(r6, this));
    L15:
        return null;
    }

    public final void a(a0 r2, MVIState<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "viewEffect");
        Intrinsics.checkNotNullParameter(r3, "stateInstance");
        if ((r2 instanceof GiftPanelEffect) == true) goto L5;
        r2 = null;
    L5:
        final GiftPanelEffect r4 = (GiftPanelEffect) r2;
        if (r4 == null) goto L9;
        Function0<Unit> r5 = new GiftMVITraceListener$onViewEffect$$inlined$let$lambda$1(r4, this);
        ((PublishSubject) this.c.getValue()).onNext(r5);
        return;
    }

    public final void c(final i r2, BaseMVIViewModel<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "fullDiff");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Function0<Unit> r4 = new GiftMVITraceListener$onBind$1(this, r2);
        ((PublishSubject) this.c.getValue()).onNext(r4);
    }

    public final JSONObject d(i r6, JSONObject r7) {
        Iterator r0 = r6.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        k r1 = (k) r0.next();
        r7.put(r1.a.getName(), GsonProtectorUtils.toJson((Gson) this.d.getValue(), r1.b));
        goto L4
    L6:
        Iterator r2 = r6.b.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        l r3 = (l) r2.next();
        String r4 = r3.b.a.getName();
        i r5 = r3.a;
        JSONObject r8 = new JSONObject();
        d(r5, r8);
        r7.put(r4, r8);
        goto L8
    L10:
        Iterator r9 = r6.d.iterator();
    L12:
        if (r9.hasNext() == false) goto L18;
        j r10 = (j) r9.next();
        JSONArray r11 = new JSONArray();
        Iterator r13 = r10.b.iterator();
    L15:
        if (r13.hasNext() == false) goto L17;
        i r14 = ((j.a) r13.next()).a;
        JSONObject r15 = new JSONObject();
        d(r14, r15);
        r11.put(r15);
        goto L15
    L17:
        r7.put(r10.a.getName(), r11);
        goto L12
    L18:
        return r7;
    }
}
