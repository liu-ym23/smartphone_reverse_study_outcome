package com.ss.android.lark.location.service;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.location.service.LocationManagerWithTimeout$getOnceLocation$1", f = "LocationManagerWithTimeout.kt", i = {0, 0}, l = {59, 61}, m = "invokeSuspend", n = {"wfListener", "listenerList"}, s = {"L$0", "L$1"})
final class LocationManagerWithTimeout$getOnceLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Job> $job;
    final /* synthetic */ c $locationListener;
    final /* synthetic */ Set<String> $providerSet;
    final /* synthetic */ long $timeOut;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.location.service.LocationManagerWithTimeout$getOnceLocation$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.location.service.LocationManagerWithTimeout$getOnceLocation$1$2", f = "LocationManagerWithTimeout.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $timeOut;
        final /* synthetic */ WeakReference<c> $wfListener;
        int label;

        public AnonymousClass2(WeakReference<c> r1, long r2, Continuation<? super AnonymousClass2> r4) {
            this.$wfListener = r1;
            this.$timeOut = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$wfListener, this.$timeOut, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            c r4 = this.$wfListener.get();
            if (r4 == null) goto L7;
            r4.a();
        L7:
            Log.i("LocationManager.WithTimeout", "getOnceLocation callback with Timeout time is: " + this.$timeOut);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LocationManagerWithTimeout$getOnceLocation$1(c r1, Set<String> r2, long r3, Ref.ObjectRef<Job> r5, Continuation<? super LocationManagerWithTimeout$getOnceLocation$1> r6) {
        this.$locationListener = r1;
        this.$providerSet = r2;
        this.$timeOut = r3;
        this.$job = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        LocationManagerWithTimeout$getOnceLocation$1 r7 = new LocationManagerWithTimeout$getOnceLocation$1(this.$locationListener, this.$providerSet, this.$timeOut, this.$job, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L33:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ArrayList r2 = (ArrayList) this.L$1;
        WeakReference r3 = (WeakReference) this.L$0;
        ResultKt.throwOnFailure(r12);
    L29:
        LocationManagerWithTimeout.b(r2);
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass2 r4 = new AnonymousClass2(r3, this.$timeOut, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(r13, r4, this) != r0) goto L33;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        if (LocationManagerWithTimeout.a() == false) goto L14;
        Log.i("LocationManager.WithTimeout", "failed to getOnceLocation called. haven't permission.");
        return Unit.INSTANCE;
    L14:
        WeakReference r15 = new WeakReference(this.$locationListener);
        ArrayList r5 = new ArrayList();
        Set<String> r6 = this.$providerSet;
        Ref.ObjectRef<Job> r7 = this.$job;
        Iterator<T> r8 = r6.iterator();
    L16:
        if (r8.hasNext() == false) goto L25;
        String r9 = (String) r8.next();
        LocationManagerWithTimeout r10 = LocationManagerWithTimeout.a;
        j r11 = new j(r5, (Job) r7.element, r15);
        r5.add(r11);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L20
        INVOKEVIRTUAL_com_ss_android_lark_location_service_LocationManagerWithTimeout$getOnceLocation$1_com_obric_performance_power_monitor_gps_LocationLancet_requestSingleUpdate((LocationManager) LocationManagerWithTimeout.e.getValue(), r9, r11, Looper.getMainLooper());     // Catch: Throwable -> L20
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L16;
        Log.e("LocationManager.WithTimeout", "getOnceLocation requestSingleUpdate failed. provider:" + r9 + ", exception: ", r18);
    L20:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L25:
        long r20 = this.$timeOut;
        this.L$0 = r15;
        this.L$1 = r5;
        this.label = 1;
        if (DelayKt.delay(r20, this) != r0) goto L28;
        return r0;
    L28:
        r3 = r15;
        r2 = r5;
        goto L29
    }

    public static void INVOKEVIRTUAL_com_ss_android_lark_location_service_LocationManagerWithTimeout$getOnceLocation$1_com_obric_performance_power_monitor_gps_LocationLancet_requestSingleUpdate(LocationManager r1, String r2, LocationListener r3, Looper r4) {
        if (fna.g.d() == true) goto L6;
        a(r1, r2, r3, r4);
        return;
    L6:
        a(r1, r2, r3, r4);
        nna.a.a++;
    }

    public static void a(LocationManager r18, String r19, LocationListener r20, Looper r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20, r21};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100002);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100002, "android/location/LocationManager", "requestSingleUpdate", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.requestSingleUpdate(r19, r20, r21);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
