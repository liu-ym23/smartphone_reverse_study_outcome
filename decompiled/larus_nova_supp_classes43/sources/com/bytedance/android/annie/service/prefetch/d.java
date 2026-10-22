package com.bytedance.android.annie.service.prefetch;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.param.ReadonlyJSONObjectMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final AnniePrefetchProcessor a;
    public JSONObject b;
    public View c;
    public final CompositeDisposable d;
    public r9.d e;
    public com.bytedance.ies.tools.prefetch.w f;
    public FetchTimingSession g;
    public String h;
    public final c i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ JSONObject b;

        public a(d r1, JSONObject r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void accept(Object r10) {
            JSONObject r11 = (JSONObject) r10;
            this.a.k();
            d r12 = this.a;
            JSONObject r0 = this.b;
            FetchTimingSession r1 = r12.g;
            if (r1 == null) goto L5;
            r1.recordJsbEndTiming(r0);
        L5:
            int r13 = com.bytedance.android.annie.bridge.g.a;
            com.bytedance.android.annie.bridge.g.b(r12.b, r0);
            r12.finishWithResult(r0);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            this.a.k();
            d r0 = this.a;
            r0.finishWithFailure((Throwable) r10);
        }
    }

    public static final class c extends com.bytedance.ies.tools.prefetch.m.a {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        public final void b(com.bytedance.ies.tools.prefetch.i.b r10) {
            Intrinsics.checkNotNullParameter(r10, "response");
            FetchTimingSession r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.recordNetEndTiming();
        L5:
            boolean r11 = true;
            if ((r10 instanceof PrefetchNetworkExecutorImpl.MultiFormatResponse.a) == false) goto L29;
            JSONObject r12 = (JSONObject) ((PrefetchNetworkExecutorImpl.MultiFormatResponse.a) r10).h.getValue();
            JSONObject r1 = this.a.b;
            if (r1 != null) goto L11;
            r11 = false;
        L11:
            if (r11 == false) goto L28;
            JSONObject r13 = r1.optJSONObject("_filter_keys");
            String r14 = r1.optString("process_name", null);
            if (r13 != null) goto L25;
            d r15 = this.a;
            View r16 = r15.c;
            if (r14 == null) goto L24;
            if (r16 == null) goto L24;
            r9.d r17 = r15.e;
            if (r17 == null) goto L24;
            Lazy r18 = UtilsKt.a;
            Intrinsics.checkNotNullParameter(r12, "<this>");
            Object r19 = r17.L(new ReadonlyJSONObjectMap(r12), r14);
            if (r19 == null) goto L24;
            r9.d r20 = r15.e;
            if (r20 == null) goto L24;
            r20.updateData(r16, r19, false);
        L24:
            this.a.j(r12);
            return;
        L25:
            d r21 = this.a;
            CompositeDisposable r22 = r21.d;
            Observable r23 = Observable.fromCallable(new e(r12, r13, r14, r21)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            d r24 = this.a;
            r22.add(r23.subscribe(new f(r24), new g(r24)));
            return;
        L28:
            throw new IllegalStateException("params shouldn't be null".toString());
        L29:
            PrefetchNetworkExecutorImpl.MultiFormatResponse.b r25 = (PrefetchNetworkExecutorImpl.MultiFormatResponse.b) r10;
            JSONObject r26 = this.a.b;
            if (r26 != null) goto L33;
            r11 = false;
        L33:
            if (r11 == false) goto L47;
            String r27 = r26.optString("process_name", null);
            d r28 = this.a;
            View r29 = r28.c;
            if (r27 == null) goto L44;
            if (r29 == null) goto L44;
            r9.d r30 = r28.e;
            if (r30 == null) goto L44;
            JSONObject r31 = (JSONObject) r25.h.getValue();
            Lazy r32 = UtilsKt.a;
            Intrinsics.checkNotNullParameter(r31, "<this>");
            Object r33 = r30.L(new ReadonlyJSONObjectMap(r31), r27);
            if (r33 == null) goto L44;
            r9.d r34 = r28.e;
            if (r34 == null) goto L44;
            r34.updateData(r29, r33, false);
        L44:
            this.a.j((JSONObject) r25.h.getValue());
            return;
        L47:
            throw new IllegalStateException("params shouldn't be null".toString());
        }

        public final void onFailed(Throwable r10) {
            Intrinsics.checkNotNullParameter(r10, "throwable");
            this.a.k();
            this.a.finishWithFailure(r10);
        }
    }

    public final void onTerminate() {
        FetchTimingSession r0 = this.g;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        com.bytedance.ies.tools.prefetch.w r1 = this.f;
        if (r1 == null) goto L10;
        PrefetchProcess r10 = r1.a;
        if (r10 == null) goto L10;
        r10.a.remove(r1);
    L10:
        this.d.clear();
    }

    public final Unit k() {
        CallContext r0 = getCallContext();
        if (r0 == null) goto L8;
        String r1 = r0.b;
        if (r1 == null) goto L9;
        ((ILatchService) Annie.getService$default(ILatchService.class, null, 2, null)).Q0(r1);
        return Unit.INSTANCE;
    L9:
        return null;
    L8:
        return null;
    }

    public d(AnniePrefetchProcessor r10) {
        Intrinsics.checkNotNullParameter(r10, "processor");
        this.a = r10;
        this.d = new CompositeDisposable();
        this.i = new c(this);
    }

    public final void j(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        if (AnnieConfigSettingKeys.LIVE_PREFETCH_SUPPORT_ASYNC_CALLBACK.a().booleanValue() == false) goto L11;
        JSONObject r0 = this.b;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L11;
        this.d.add(Observable.just(r10).subscribeOn(Schedulers.io()).subscribe(new a(this, r10), new b(this)));
        return;
    L7:
        if (r0.optInt("async_callback", 0) != 1) goto L9;
        r1 = true;
    L11:
        k();
        FetchTimingSession r11 = this.g;
        if (r11 == null) goto L14;
        r11.recordJsbEndTiming(r10);
    L14:
        int r12 = com.bytedance.android.annie.bridge.g.a;
        com.bytedance.android.annie.bridge.g.b(this.b, r10);
        finishWithResult(r10);
    }

    public final void invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        this.b = r12;
        if (this.h != null) goto L5;
        this.h = r11.a();
    L5:
        Object r13 = null;
        if (this.e != null) goto L8;
        this.e = (r9.d) Annie.getService$default(r9.d.class, null, 2, null);
    L8:
        FetchTimingSession.Companion.getClass();
        Intrinsics.checkNotNullParameter(r12, "params");
        boolean r0 = r12.optBoolean("enable_timing", false);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L13
        if (r0 == false) goto L15;
        FetchTimingSession r1 = new FetchTimingSession();     // Catch: Throwable -> L13
        r1.recordJsbStartTiming();     // Catch: Throwable -> L13
    L16:
        this.g = r1;
        View r15 = r11.d;
        this.c = r15;
        if ((r15 instanceof WebView) == false) goto L19;
        x46.a r16 = this.a.d(((WebView) r15).getUrl());
    L25:
        if (r16 == null) goto L53;
        this.f = new com.bytedance.ies.tools.prefetch.w(r16, this.i);
        FetchTimingSession r17 = this.g;
        if (r17 == null) goto L29;
        r17.recordNetStartTiming();
    L29:
        Set r18 = SecurityContextUtils.a;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        String r19 = SecurityContextUtils.b(r11);
        JSONObject r20 = r12.optJSONObject("headers");
        if (r20 != null) goto L32;
        JSONObject r21 = new JSONObject();
        r21.put("x-security-argus", r19);
        Unit r110 = Unit.INSTANCE;
        r12.put("headers", r21);
    L42:
        r12.put("headers", r20);
        com.bytedance.ies.tools.prefetch.w r111 = this.f;
        if (r111 != null) goto L45;
        return;
    L45:
        if (r12.optInt("force_fetch", 0) != 1) goto L47;
    L50:
        r111.c(r12);
        return;
    L47:
        if (AnnieConfigSettingKeys.HYBRID_PREFETCH_ENABLED.a().booleanValue() == false) goto L50;
        r111.b(r12);
        return;
    L32:
        Iterator r22 = SequencesKt.asSequence(r20.keys()).iterator();
    L34:
        if (r22.hasNext() == false) goto L38;
        Object r23 = r22.next();
        if (StringsKt.equals((String) r23, "x-security-argus", true) == false) goto L34;
        r13 = r23;
    L38:
        String r24 = (String) r13;
        if (r24 == null) goto L41;
        r20.remove(r24);
    L41:
        r20.put("x-security-argus", r19);
        goto L42
    L53:
        throw new IllegalStateException("Failed to create method stub.".toString());
    L19:
        String r25 = ((ILatchService) Annie.getService$default(ILatchService.class, null, 2, null)).R0(r15);
        if (r25 == null) goto L23;
        r16 = this.a.d(r25);
        goto L25
    L23:
        if (((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).c(r15) == false) goto L54;
        r16 = this.a.d(((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).Q(r15));
        goto L25
    L54:
        StringBuilder r112 = new StringBuilder("Unknown hybrid view class: ");
        if (r15 == null) goto L57;
        r13 = r15.getClass();
    L57:
        r112.append(r13);
        r112.append(". Failed to obtain url.");
        throw new IllegalStateException(r112.toString().toString());
    L15:
        r1 = null;
    L13:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
