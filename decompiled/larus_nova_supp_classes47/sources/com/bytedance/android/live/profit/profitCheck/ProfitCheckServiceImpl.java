package com.bytedance.android.live.profit.profitCheck;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.privilege.ProfitCheckConfig;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.profit.privilege.model.ReportType;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.trace.api.ProductId;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.kmp.util.e;
import io.reactivex.BackpressureStrategy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfitCheckServiceImpl implements com.bytedance.android.live.profit.privilege.c, o {
    public static final /* synthetic */ int h = 0;
    public final List<com.bytedance.android.live.profit.profitCheck.c> a;
    public final Handler b;
    public final PublishSubject<Function0<Unit>> c;
    public final CompositeDisposable d;
    public final ReentrantLock e;
    public final com.bytedance.android.livesdk.revenue.service.room.b f;
    public final l01.d g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ((Function0) r1).invoke();
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
            int r0 = x8.a.a;
            int r1 = ProfitCheckServiceImpl.h;
            x8.a.b("ProfitCheckServiceImpl", "report error" + ((Throwable) r3).getMessage(), false);
        }
    }

    static {
    }

    public final void onStart() {
        RxUtilKt.c(this.c.toFlowable(BackpressureStrategy.BUFFER).observeOn(Schedulers.io()).subscribe(b.a, c.a), this.d);
    }

    public final void onStop() {
        ((CopyOnWriteArrayList) this.a).clear();
        this.d.clear();
        this.b.removeCallbacksAndMessages(null);
    }

    public static Map f(Map r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("consume_time", Long.valueOf(e.b()));
        String r4 = (String) r3.get("to_user_id");
        if (r4 == null) goto L5;
        r0.put("to_user_id", r4);
    L5:
        return r0;
    }

    public final Map<String, String> g(Map<String, String> r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        IRoom r1 = this.f.getRoom();
        String r2 = DataType.FALSE;
        if (r1 == null) goto L6;
        String r3 = r1.getOwnerUserIdString();
        if (r3 == null) goto L6;
    L7:
        r0.put("anchor_id", r3);
        r0.put("user_id", this.g.getCurrentUserId());
        IRoom r4 = this.f.getRoom();
        if (r4 == null) goto L13;
        String r5 = String.valueOf(r4.getId());
        if (r5 == null) goto L13;
        r2 = r5;
    L13:
        r0.put("room_id", r2);
        r0.putAll(r6);
        return r0;
    L6:
        r3 = DataType.FALSE;
        goto L7
    }

    public ProfitCheckServiceImpl(com.bytedance.android.livesdk.revenue.service.room.b r2, l01.d r3) {
        Intrinsics.checkNotNullParameter(r2, "roomService");
        Intrinsics.checkNotNullParameter(r3, "userService");
        this.f = r2;
        this.g = r3;
        this.a = new CopyOnWriteArrayList();
        this.b = new Handler(Looper.getMainLooper());
        this.c = PublishSubject.create();
        this.d = new CompositeDisposable();
        this.e = new ReentrantLock(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v7, types: [org.json.JSONObject] */
    public static void h(com.bytedance.android.live.profit.profitCheck.c r8, Map r9) {
        j01.e r1 = new j01.e(r8.getType().a, "default");
        JSONObject r0 = new JSONObject();
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        Intrinsics.checkNotNullParameter(r1, "metaBuilder");
        Intrinsics.checkNotNullParameter(r2, "category");
        Intrinsics.checkNotNullParameter(r3, "metric");
        Intrinsics.checkNotNullParameter(r0, "extra");
        String r4 = r8.d.get("anchor_id");
        if (r4 == null) goto L5;
        r1.a(r4);
    L5:
        String r5 = r8.d.get("user_id");
        if (r5 == null) goto L8;
        r1.i(r5);
    L8:
        String r6 = r8.d.get("room_id");
        if (r6 == null) goto L11;
        r1.e(r6);
    L11:
        String r7 = r8.d.get("trace_id");
        if (r7 == null) goto L14;
        r1.h(r7);
    L14:
        String r10 = r8.d.get("log_id");
        if (r10 == null) goto L17;
        r1.c(r10);
    L17:
        r1.b(r8.e);
        r1.d(ProductId.REVENUE_PROFIT_CHECK);
        Intrinsics.checkNotNullParameter(r0, "json");
        Iterator r12 = r9.entrySet().iterator();
    L19:
        if (r12.hasNext() == false) goto L31;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        ?? r15 = r13.getValue();
        if ((r15 instanceof Map) == true) goto L23;
        ?? r16 = 0;
    L24:
        Map r17 = (Map) r16;
        if (r17 == null) goto L30;
        r15 = new JSONObject();
        Iterator r18 = r17.entrySet().iterator();
    L28:
        if (r18.hasNext() == false) goto L30;
        Map.Entry r19 = (Map.Entry) r18.next();
        Object r20 = r19.getKey();
        Object r22 = r19.getValue();
        d60.b.a(r15, String.valueOf(r20), r22);
    L30:
        Intrinsics.checkNotNullParameter(r14, "key");
        Intrinsics.checkNotNullParameter(r15, "value");
        j01.d.b(r0, r14, r15);
        goto L19
    L23:
        r16 = r15;
        goto L24
    L31:
        ((j01.b) f.a(j01.b.class)).R4(r1.a, r2, r3, r0);
    }

    @Override // com.bytedance.android.live.profit.privilege.c
    public final void w(final Map r2, final ProfitCheckConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "requestParam");
        Intrinsics.checkNotNullParameter(r3, "profitCheckConfigArg");
        if (r3.getNeedReport() == true) goto L5;
        return;
    L5:
        Function0<Unit> r0 = new ProfitCheckServiceImpl$createProfitCheckTasks$1(this, r3, r2);
        this.c.onNext(r0);
    }

    @Override // com.bytedance.android.live.profit.privilege.c
    public final void B1(final ProfitCheckType r9, final Map<String, ? extends Object> r10, final String r12) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, Constants.Keys.DATA);
        if (r9.getLocalReport() == false) goto L9;
        d r2 = new d(r9.getTypeName(), r9.getIndex());
        ReportType.Companion.getClass();
        ReportType r3 = ReportType.a.a(0);
        Map<String, String> r6 = g(new LinkedHashMap());
        if (r12 == null) goto L7;
        r6.put("trace_id", r12);
    L7:
        Unit r13 = Unit.INSTANCE;
        h(new com.bytedance.android.live.profit.profitCheck.c(r2, r3, Long.MAX_VALUE, r6, f(new LinkedHashMap())), r10);
        return;
    L9:
        Function0<Unit> r0 = new ProfitCheckServiceImpl$collectReportTask$1(this, r9, r12, r10);
        this.c.onNext(r0);
    }

    public static final void a(ProfitCheckServiceImpl r6, com.bytedance.android.live.profit.profitCheck.c r7, Map r8, long r9) {
        r6.getClass();
        long r0 = e.b();
        IRoom r2 = r6.f.getRoom();
        if (r2 == null) goto L5;
        String r3 = String.valueOf(r2.getId());
    L6:
        String r10 = r6.g.getCurrentUserId();
        if (r7.c >= r0) goto L9;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == false) goto L17;
        Map<String, Object> r13 = r7.e;
        r13.put("collect_time", Long.valueOf(e.b()));
        r13.put("report_time", Long.valueOf(e.b()));
        r13.put("unique_id", Long.valueOf(r9));
        h(r7, r8);
        return;
    L17:
        return;
    L9:
        if (Intrinsics.areEqual(r7.d.get("room_id"), r3) == false) goto L13;
        if (Intrinsics.areEqual(r7.d.get("user_id"), r10) == false) goto L13;
        r12 = true;
        goto L14
    L5:
        r3 = null;
        goto L6
    }
}
