package com.larus.dispatcher.api;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.im.internal.jni.bean.DeviceStatusChangeType;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class GetAllDevicesRepo {
    public static final GetAllDevicesRepo a = null;
    public static volatile AllDeviceResponse b;
    public static final MutexImpl c = null;
    public static final MutexImpl d = null;
    public static final Object e = null;
    public static final AtomicLong f = null;
    public static final AtomicLong g = null;
    public static final Lazy h = null;
    public static Deferred<AllDeviceResponse> i;
    public static Deferred<AllDeviceResponse> j;
    public static CoroutineScope k;
    public static final MutableLiveData<AllDeviceResponse> l = null;
    public static final MutableLiveData<Integer> m = null;
    public static volatile long n;
    public static final MutableLiveData o = null;
    public static final MutableLiveData p = null;
    public static boolean q;
    public static final GetAllDevicesRepo$dispatchCommandListener$1 r = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DeviceStatusChangeType.values().length];
            r0[DeviceStatusChangeType.DEVICE_STATUS_CHANGE_TYPE_ENABLE_CONTROL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DeviceStatusChangeType.DEVICE_STATUS_CHANGE_TYPE_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public GetAllDevicesRepo() {
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.dispatcher.api.GetAllDevicesRepo$dispatchCommandListener$1] */
    static {
        a = new GetAllDevicesRepo();
        c = kotlinx.coroutines.sync.b.a();
        d = kotlinx.coroutines.sync.b.a();
        e = new Object();
        f = new AtomicLong(0);
        g = new AtomicLong(0);
        h = LazyKt.lazy(new com.larus.dispatcher.api.a());
        MutableLiveData<AllDeviceResponse> r0 = new MutableLiveData();
        l = r0;
        MutableLiveData<Integer> r1 = new MutableLiveData();
        m = r1;
        o = r0;
        p = r1;
        r = new GetAllDevicesRepo$dispatchCommandListener$1();
    }

    public static AllDeviceResponse d() {
        AllDeviceResponse r0 = b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        AtomicLong r1 = f;
        long r2 = r1.get();
        AllDeviceResponse r3 = h("getCurrentDevicesInfo");
        if (r3 == null) goto L8;
        Object r4 = e;
        monitor-enter(r4);
        AllDeviceResponse r5 = b;     // Catch: Throwable -> L23
        if (r5 == null) goto L15;
        r3 = r5;
    L21:
        monitor-exit(r4);
        return r3;
    L15:
        if (r1.get() != r2) goto L17;
        b = r3;     // Catch: Throwable -> L23
        l.postValue(r3);     // Catch: Throwable -> L23
        FLogger.a.i("GetAllDevicesRepo", "[getCurrentDevicesInfo] disk cache restored");     // Catch: Throwable -> L23
    L17:
        AllDeviceResponse r6 = b;     // Catch: Throwable -> L23
        if (r6 == null) goto L21;
        r3 = r6;
    L23:
        th = move-exception;
        throw th;
    L8:
        return b;
    }

    public static CoroutineScope f() {
        CoroutineScope r0 = k;
        if (r0 != null) goto L6;
        CoroutineScope r1 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        k = r1;
        return r1;
    L6:
        return r0;
    }

    public static void g() {
        if (q == false) goto L5;
        return;
    L5:
        FLogger.a.i("GetAllDevicesRepo", "init");
        q = true;
        com.larus.im.d.b().registerDispatchCommandListener(r);
        long r0 = f.get();
        BuildersKt.launch$default(f(), null, null, new GetAllDevicesRepo$init$1(r0, null), 3, null);
    }

    public static Integer c(final String r2) {
        List<PcDevice> r0 = null;
        if (r2 != null) goto L5;
    L17:
        return null;
    L5:
        if ((!StringsKt.isBlank(r2)) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L17;
        AllDeviceResponse r1 = d();
        if (r1 == null) goto L13;
        r0 = r1.getDevices();
    L13:
        if (r0 != null) goto L16;
        r0 = CollectionsKt.emptyList();
    L16:
        return (Integer) SequencesKt.singleOrNull(SequencesKt.distinct(SequencesKt.mapNotNull(SequencesKt.filter(SequencesKt.filterNotNull(CollectionsKt.asSequence(r0)), new b(r2)), new c())));
    }

    public static AllDeviceResponse h(String r8) {
        FLogger r0 = FLogger.a;
        r0.d("GetAllDevicesRepo", "[" + r8 + "] readCurrentDevicesInfoFromDisk read cache");
        String r1 = AccountService.a.getUserId();
        if (StringsKt.isBlank(r1) == false) goto L27;
        r0.w("GetAllDevicesRepo", "[" + r8 + "] uid is empty, skip cache");
        return null;
    L27:
        String r2 = ((Keva) h.getValue()).getString(r1, null);     // Catch: Exception -> L17
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L31;
        return (AllDeviceResponse) HttpExtKt.f.fromJson(r2, AllDeviceResponse.class);
    L31:
        return null;
    L9:
        if (r2.length() == 0) goto L12;
        r4 = false;
    L17:
        e = move-exception;
        FLogger.a.e("GetAllDevicesRepo", "[" + r8 + "] read cache failed", e);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        ((Keva) h.getValue()).erase(r1);     // Catch: Throwable -> L21
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L33;
        FLogger.a.e("GetAllDevicesRepo", "[" + r8 + "] erase damaged cache failed", r6);
        return null;
    L33:
        return null;
    L21:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public static void j(AllDeviceResponse r10) {
        Object r0 = e;
        monitor-enter(r0);
        f.incrementAndGet();     // Catch: Throwable -> L12
        b = r10;     // Catch: Throwable -> L12
        l.postValue(r10);     // Catch: Throwable -> L12
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        if (r10 == null) goto L17;
        long r2 = g.incrementAndGet();
        String r4 = AccountService.a.getUserId();
        if (StringsKt.isBlank(r4) == false) goto L10;
        FLogger.a.w("GetAllDevicesRepo", "[persistCurrentDevicesInfoToDisk] uid is empty, skip cache");
        return;
    L10:
        BuildersKt.launch$default(f(), null, null, new GetAllDevicesRepo$persistCurrentDevicesInfoToDisk$1(r2, r4, r10, null), 3, null);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static Object e(String r2, Continuation r3) {
        return CoroutineScopeKt.coroutineScope(new GetAllDevicesRepo$getOrRequestAllDevices$2(r2, null), r3);
    }

    public static final Object a(GetAllDevicesRepo r4, long r5, Continuation r7) {
        r4.getClass();
        if ((r7 instanceof GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1) == false) goto L7;
        GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1 r0 = (GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = r0.J$0;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L38:
        AllDeviceResponse r10 = h("loadCurrentDevicesInfoFromDisk");     // Catch: Throwable -> L35
        r9.unlock(null);
        Object r11 = e;
        monitor-enter(r11);
        if (r10 != null) goto L40;
    L29:
        r3 = false;
    L30:
        monitor-exit(r11);
        if (r3 == false) goto L34;
        FLogger.a.i("GetAllDevicesRepo", "[loadCurrentDevicesInfoFromDisk] cache restored");
    L34:
        return Unit.INSTANCE;
    L40:
    L26:
        th = move-exception;
        throw th;
    L23:
        if (f.get() != r5) goto L29;
        b = r10;     // Catch: Throwable -> L26
        l.postValue(r10);     // Catch: Throwable -> L26
    L35:
        th = move-exception;
        r9.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.sync.a r12 = d;
        r0.L$0 = r12;
        r0.J$0 = r5;
        r0.label = 1;
        if (r12.a(null, r0) == r8) goto L42;
        r9 = r12;
        goto L38
    L42:
        return r8;
    L7:
        r0 = new GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1(r4, r7);
        goto L8
    }

    public static final Object b(GetAllDevicesRepo r8, String r9, Continuation r10) {
        r8.getClass();
        if ((r10 instanceof GetAllDevicesRepo$requestAllDevices$1) == false) goto L7;
        GetAllDevicesRepo$requestAllDevices$1 r0 = (GetAllDevicesRepo$requestAllDevices$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r9 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L17:
        dm9.a.b r13 = (dm9.a) r11;
        if ((r13 instanceof dm9.a.b) == false) goto L28;
        dm9.a.b r14 = r13;
        if (r14.a.isSuccess() == false) goto L22;
        FLogger.a.i("GetAllDevicesRepo", "[requestAllDevices][" + r9 + "] request success");
        AllDeviceResponse r15 = (AllDeviceResponse) r14.a.getData();
        j(r15);
        n = SystemClock.elapsedRealtime();
        return r15;
    L22:
        FLogger r16 = FLogger.a;
        StringBuilder r3 = new StringBuilder("[requestAllDevice][");
        r3.append(r9);
        r3.append("] request success but biz failed, code=");
        r3.append(r14.a.getCode());
        r3.append(", msg=");
        r3.append(r14.a.getMsg());
        r3.append(", error=");
        Throwable r17 = r14.b;
        if (r17 == null) goto L25;
        String r18 = r17.getLocalizedMessage();
    L26:
        r3.append(r18);
        r16.e("GetAllDevicesRepo", r3.toString(), r14.b);
        j(null);
    L35:
        return null;
    L25:
        r18 = null;
        goto L26
    L28:
        if ((r13 instanceof dm9.a.a) == false) goto L37;
        FLogger r110 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[requestAllDevice][");
        r4.append(r9);
        r4.append("] request failed, code=");
        dm9.a.a r20 = (dm9.a.a) r13;
        r4.append(r20.a);
        r4.append(", msg=");
        r4.append(r20.b);
        r4.append(", error=");
        Throwable r21 = r20.c;
        if (r21 == null) goto L32;
        String r22 = r21.getLocalizedMessage();
    L33:
        r4.append(r22);
        r110.e("GetAllDevicesRepo", r4.toString(), r20.c);
        j(null);
        goto L35
    L32:
        r22 = null;
        goto L33
    L37:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        FLogger.a.i("GetAllDevicesRepo", "[requestAllDevices][" + r9 + "] start");
        CoroutineDispatcher r23 = Dispatchers.getIO();
        GetAllDevicesRepo$requestAllDevices$result$1 r5 = new GetAllDevicesRepo$requestAllDevices$result$1(null);
        r0.L$0 = r9;
        r0.label = 1;
        r11 = BuildersKt.withContext(r23, r5, r0);
        if (r11 != r12) goto L17;
        return r12;
    L7:
        r0 = new GetAllDevicesRepo$requestAllDevices$1(r8, r10);
        goto L8
    }

    public final Object i(int r18, String r110, Continuation<? super AllDeviceResponse> r20) {
        if ((r20 instanceof GetAllDevicesRepo$requestAllDevicesWithTimeControl$1) == false) goto L7;
        GetAllDevicesRepo$requestAllDevicesWithTimeControl$1 r1 = (GetAllDevicesRepo$requestAllDevicesWithTimeControl$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) r1.L$2;
        Object r6 = r1.L$1;
        Deferred<AllDeviceResponse> r7 = (Deferred) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L50:
    L44:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L39:
        if (j != r7) goto L41;
        j = null;     // Catch: Throwable -> L44
    L41:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L44
        r5.unlock(null);
        return r6;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Deferred<AllDeviceResponse> r9 = (Deferred) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L34:
        AllDeviceResponse r10 = (AllDeviceResponse) r0;
        kotlinx.coroutines.sync.a r11 = c;
        r1.L$0 = r9;
        r1.L$1 = r0;
        r1.L$2 = r11;
        r1.label = 3;
        if (r11.a(null, r1) != r3) goto L37;
        return r3;
    L37:
        r7 = r9;
        r5 = r11;
        r6 = r0;
        goto L50
    L17:
        int r12 = r1.I$0;
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r1.L$1;
        String r14 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L52:
        Deferred<AllDeviceResponse> r15 = j;     // Catch: Throwable -> L47
        if (r15 != null) goto L25;
    L29:
        r15 = BuildersKt.async$default(f(), null, null, new GetAllDevicesRepo$requestAllDevicesWithTimeControl$deferred$1$2(r12, r14, null), 3, null);     // Catch: Throwable -> L47
        j = r15;     // Catch: Throwable -> L47
    L30:
        r13.unlock(null);
        r1.L$0 = r15;
        r1.L$1 = null;
        r1.label = 2;
        Object r16 = r15.await(r1);
        if (r16 != r3) goto L33;
        return r3;
    L33:
        r9 = r15;
        r0 = r16;
        goto L34
    L25:
        if (r15.isActive() == true) goto L28;
        r15 = null;
    L28:
        if (r15 != null) goto L30;
    L47:
        th = move-exception;
        r13.unlock(null);
        throw th;
    L18:
        ResultKt.throwOnFailure(r0);
        kotlinx.coroutines.sync.a r17 = c;
        r1.L$0 = r110;
        r1.L$1 = r17;
        r1.I$0 = r18;
        r1.label = 1;
        if (r17.a(null, r1) != r3) goto L21;
        return r3;
    L21:
        r13 = r17;
        r14 = r110;
        r12 = r18;
    L7:
        r1 = new GetAllDevicesRepo$requestAllDevicesWithTimeControl$1(this, r20);
        goto L8
    }
}
