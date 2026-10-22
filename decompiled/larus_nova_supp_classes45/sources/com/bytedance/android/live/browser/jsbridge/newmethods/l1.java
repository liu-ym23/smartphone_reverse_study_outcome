package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.gson.ILiveGsonService;
import com.bytedance.android.livesdk.config.kt;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l1 extends com.bytedance.ies.web.jsbridge2.f<JsonObject, Object> {
    public final CompositeDisposable a;
    public final ICalendarManager b;
    public final Lazy c;
    public final ICalendarManager.IPermissionHandler d;

    public final void onTerminate() {
    }

    public final void onDestroy() {
        super.onDestroy();
        this.a.clear();
    }

    public final boolean j(Disposable r2) {
        return this.a.add(r2);
    }

    public l1(final Context r2, com.bytedance.android.live.browser.r.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "permissionHandler");
        this.d = r3;
        this.a = new CompositeDisposable();
        IMiddlewareLiveService r4 = TTLiveServiceMiddleware.getLiveService();
        Intrinsics.checkNotNull(r4);
        this.b = r4.getCalendarManager(r2);
        this.c = LazyKt.lazy(new CalendarMethod$timonCalendarManager$2(r2));
    }

    public final void invoke(Object r17, CallContext r18) {
        JsonObject r0 = (JsonObject) r17;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r18, "context");
        Gson r3 = ((ILiveGsonService) jc1.k.n(ILiveGsonService.class)).get();
        JsonObject r2 = r0.get("params").getAsJsonObject();
        String r1 = r0.get("action").getAsString();
        String r5 = "";
        if (((Boolean) kt.a.getValue()).booleanValue() == false) goto L48;
        if (r1 == null) goto L47;
        int r4 = r1.hashCode();
        boolean r15 = true;
        if (r4 == (-934610812)) goto L25;
        if (r4 == 96417) goto L15;
        if (r4 != 102230) goto L47;
        if (r1.equals("get") == false) goto L47;
        j(Single.fromCallable(new g1(this, r2.get("event_id").getAsString())).subscribeOn(Schedulers.io()).subscribe(new h1(this, r3), new i1(this)));
        return;
    L15:
        if (r1.equals("add") == false) goto L47;
        final i7 r6 = (i7) this.c.getValue();
        final ICalendarManager.EventParams r7 = (ICalendarManager.EventParams) GsonProtectorUtils.fromJson(r3, r2, ICalendarManager.EventParams.class);
        ICalendarManager.IPermissionHandler r8 = this.d;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r8, "handler");
        Function0<Single<ICalendarManager.ErrorCode>> r9 = new LiveTimonCalendarManager$requestPermissionAndAdd$proceed$1(r6, r7);
        if (r6.a() == false) goto L20;
        Single r11 = (Single) r9.invoke();
    L23:
        j(r11.subscribe(new c1(this), new d1(this)));
        return;
    L20:
        if (((Boolean) j40.f4.B.getValue()).booleanValue() == false) goto L22;
        r11 = Single.error(new Exception("user had denied calendar permission before"));
        goto L23
    L22:
        r11 = r8.requestWriteCalendarPermission().onErrorReturnItem(new int[]{-1}).observeOn(AndroidSchedulers.mainThread()).flatMap(new u7(r9));
        goto L23
    L25:
        if (r1.equals("remove") == false) goto L47;
        String r12 = r2.get("event_id").getAsString();
        JsonElement r13 = r2.get("anchor_id");
        if (r13 == null) goto L32;
        String r14 = r13.getAsString();
        if (r14 == null) goto L32;
        r5 = r14;
    L32:
        i7 r16 = (i7) this.c.getValue();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r12, "eventId");
        Intrinsics.checkNotNullParameter(r5, "anchorId");
    L44:
        th = move-exception;
        ALogger.throwable(5, "CalendarManager", "failed to add calendar event", th);
        Single r19 = Single.fromCallable(t7.a);
    L46:
        j(r19.subscribeOn(Schedulers.io()).subscribe(new e1(this), new f1(this)));
        return;
    L34:
        if (r12.length() == 0) goto L37;
        r15 = false;
    L37:
        if (r15 == false) goto L40;
        r19 = Single.fromCallable(q7.a);     // Catch: Throwable -> L44
    L72:
        goto L46
    L40:
        if (r16.a() == true) goto L42;
        r19 = Single.fromCallable(r7.a);     // Catch: Throwable -> L44
        goto L72
    L42:
        r19 = Single.create(new s7(r16, r12, r5));     // Catch: Throwable -> L44
    L47:
        finishWithFailure(new IllegalArgumentException("unknown action " + r1));
        return;
    L48:
        if (r1 == null) goto L70;
        int r21 = r1.hashCode();
        if (r21 == (-934610812)) goto L62;
        if (r21 == 96417) goto L59;
        if (r21 != 102230) goto L70;
        if (r1.equals("get") == false) goto L70;
        j(Single.fromCallable(new z0(this, r2.get("event_id").getAsString())).subscribeOn(Schedulers.io()).subscribe(new a1(this, r3), new b1(this)));
        return;
    L59:
        if (r1.equals("add") == false) goto L70;
        ICalendarManager r22 = this.b;
        Intrinsics.checkNotNull(r22);
        j(r22.requestPermissionAndAdd((ICalendarManager.EventParams) GsonProtectorUtils.fromJson(r3, r2, ICalendarManager.EventParams.class), this.d).subscribe(new j1(this), new k1(this)));
        return;
    L62:
        if (r1.equals("remove") == false) goto L70;
        String r23 = r2.get("event_id").getAsString();
        JsonElement r24 = r2.get("anchor_id");
        if (r24 == null) goto L69;
        String r25 = r24.getAsString();
        if (r25 == null) goto L69;
        r5 = r25;
    L69:
        j(Single.fromCallable(new w0(this, r23, r5)).subscribeOn(Schedulers.io()).subscribe(new x0(this), new y0(this)));
        return;
    L70:
        finishWithFailure(new IllegalArgumentException("unknown action " + r1));
    }

    public final void k(ICalendarManager.ErrorCode r3, JsonElement r4) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("status_code", Integer.valueOf(r3.getValue()));
        if (r4 == null) goto L5;
        r0.add("data", r4);
    L5:
        finishWithResult(r0);
    }
}
