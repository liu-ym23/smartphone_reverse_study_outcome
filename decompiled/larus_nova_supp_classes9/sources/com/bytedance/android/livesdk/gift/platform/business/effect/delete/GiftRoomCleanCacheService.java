package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.push.LivePushInfo;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftRoomCleanCacheService implements dy0.d, com.bytedance.android.scope.o, yz0.m {
    public static final /* synthetic */ int i = 0;
    public com.bytedance.android.livesdk.gift.platform.business.effect.delete.b a;
    public LivePushInfo.d b;
    public final Function1<LivePushInfo.f, Unit> c;
    public Disposable d;
    public final CompositeDisposable e;
    public final c f;
    public final yz0.k g;
    public final com.bytedance.android.livesdk.revenue.service.room.c h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GiftRoomCleanCacheService a;

        public b(GiftRoomCleanCacheService r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            Long r14 = (Long) r13;
            GiftRoomCleanCacheService r15 = this.a;
            r15.getClass();
            LinkedList r2 = null;
            LinkedList r0 = (LinkedList) ay1.b.z0.getValue(null, ay1.b.a[92]);
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            if ((System.currentTimeMillis() - (com.bytedance.android.livesdk.gift.platform.business.i.d().T8() * 1000)) <= ((Number) r1.next()).longValue()) goto L8;
            r1.remove();
        L8:
            r0.size();
            boolean r3 = true;
            if ((!r0.isEmpty()) == false) goto L11;
            r2 = r0;
        L11:
            if (r2 == null) goto L14;
            Long r4 = (Long) r2.getFirst();
        L14:
            if (r0.size() >= com.bytedance.android.livesdk.gift.platform.business.i.d().H5()) goto L16;
            boolean r5 = true;
        L17:
            if (r5 == true) goto L19;
            return;
        L19:
            if (((Integer) r15.h.getDataCenter().get("data_member_count", 0)).intValue() > com.bytedance.android.livesdk.gift.platform.business.i.d().Q4()) goto L21;
            boolean r6 = true;
        L22:
            if (r6 == true) goto L24;
            return;
        L24:
            if (r15.f.a() > com.bytedance.android.livesdk.gift.platform.business.i.d().d4()) goto L27;
            r3 = false;
        L27:
            if (r3 == false) goto L35;
            RxUtilKt.c(Single.create(d.a).toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r15)), r15.e);
            return;
        L35:
            return;
        L21:
            r6 = false;
            goto L22
        L16:
            r5 = false;
            goto L17
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onViewReady() {
    }

    public final void onWidgetLoaded() {
    }

    public final void x() {
    }

    public final void c() {
        com.bytedance.android.livesdk.gift.platform.business.effect.delete.b r0 = this.a;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.a = null;
    }

    public final void onStop() {
        this.e.clear();
        c();
        LivePushInfo.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        Iterator r1 = ((ArrayList) this.f.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) r1.next()).e(CleanOpportunity.MANUAL_CLEAN_IN_ROOM);
        goto L7
    L9:
        ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).g(1);
    }

    public final void i() {
        if (com.bytedance.android.livesdk.gift.platform.business.i.d().getEnable() == true) goto L6;
        return;
    L6:
        if (this.g.isAnchor() == false) goto L8;
        return;
    L8:
        RxUtilKt.c(Observable.timer(com.bytedance.android.livesdk.gift.platform.business.i.d().Q8(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.e);
    }

    public GiftRoomCleanCacheService(c r2, yz0.k r3, com.bytedance.android.livesdk.revenue.service.room.c r4) {
        Intrinsics.checkNotNullParameter(r2, "cleanGlobalManagerService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "revRoomService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.c = new GiftRoomCleanCacheService$reportAction$1(this);
        this.e = new CompositeDisposable();
    }

    public static final void a(GiftRoomCleanCacheService r2, com.bytedance.android.live.base.model.push.b r3, String r4, Map r5) {
        r2.getClass();
        HashMap r6 = new HashMap();
        String r0 = r3.getScene();
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        r6.put("business_scene", r0);
        r6.put("action_type", r4);
        r6.put("content", String.valueOf(r3.getContent()));
        r6.put("push_reason", "cache_optimize");
        r6.putAll(r5);
        mz0.n r7 = new mz0.n();
        Map r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r8.putAll(r6);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        List r10 = r7.b;
        ArrayList r11 = (ArrayList) r10;
        r11.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_live_common_inner_push", r7.a, r7.b);
    }
}
