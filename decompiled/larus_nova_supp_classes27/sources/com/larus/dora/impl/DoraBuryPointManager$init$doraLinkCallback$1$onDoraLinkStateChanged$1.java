package com.larus.dora.impl;

import android.os.SystemClock;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsTracker;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.trace.DarEvent;
import com.larus.dora.impl.trace.a;
import g49.d;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraBuryPointManager$init$doraLinkCallback$1$onDoraLinkStateChanged$1", f = "DoraBuryPointManager.kt", i = {1}, l = {349, 370}, m = "invokeSuspend", n = {"params"}, s = {"L$0"})
public final class DoraBuryPointManager$init$doraLinkCallback$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ int $state;
    Object L$0;
    int label;

    public DoraBuryPointManager$init$doraLinkCallback$1$onDoraLinkStateChanged$1(int r1, DoraDevice r2, Continuation<? super DoraBuryPointManager$init$doraLinkCallback$1$onDoraLinkStateChanged$1> r3) {
        this.$state = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraBuryPointManager$init$doraLinkCallback$1$onDoraLinkStateChanged$1(this.$state, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        Map r1 = (Map) this.L$0;
        ResultKt.throwOnFailure(r23);
    L49:
        DoraBuryPointManager.a.getClass();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DoraBuryPointManager$getAntiSoundLeakStateAndReport$1(null), 2, null);
        Map r5 = r1;
    L124:
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L127;
        DarEvent r3 = DarEvent.DoraLinkStateChanged;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("status", Boxing.boxInt(this.$state));
        r3.setExtra(r4);
        a.a(r3);
    L127:
        DoraBuryPointManager r6 = DoraBuryPointManager.a;
        r6.M("dora_proprietary_protocol_status", r5, new nk4.c(CollectionsKt.listOf(this.$device)), this.$device);
        r6.M("dora_proprietary_protocol_status_new", r5, new nk4.c(CollectionsKt.listOf(this.$device)), this.$device);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r23);
    L13:
        Pair[] r7 = new Pair[4];
        r7[0] = TuplesKt.to("external_device_type", "earphone");
        r7[1] = TuplesKt.to("external_device_name", "dora");
        if (this.$state != 2) goto L16;
        String r8 = "active_connection";
    L17:
        r7[2] = TuplesKt.to("protocol_status", r8);
        DoraDevice r9 = this.$device;
        String r10 = "none";
        if (r9 == null) goto L21;
        String r11 = r9.softVersion;
        if (r11 == null) goto L21;
    L22:
        r7[3] = TuplesKt.to("dora_FW_version", r11);
        r5 = MapsKt.mutableMapOf(r7);
        DoraSetting.a.getClass();
        if (DoraSetting.g() == true) goto L35;
        DoraDevice r12 = this.$device;
        if (r12 == null) goto L28;
        String r13 = r12.getSerialNumber();
        if (r13 == null) goto L28;
    L29:
        r5.put("dora_series_no", r13);
        DoraDevice r14 = this.$device;
        if (r14 == null) goto L33;
        String r15 = r14.getSerialNumber();
        if (r15 == null) goto L33;
    L34:
        r5.put("series_no", r15);
    L33:
        r15 = "none";
    L28:
        r13 = "none";
    L35:
        long r16 = System.currentTimeMillis();
        long r17 = DoraBuryPointManager.i;
        long r18 = DoraBuryPointManager.j;
        if (this.$state != 2) goto L50;
        DoraBuryPointManager.Q(DoraBuryPointManager.a, false, 3);
        DoraBuryPointManager.i = r16;
        DoraBuryPointManager.k = SystemClock.elapsedRealtime();
        DoraBuryPointManager.k();
        Calendar r20 = Calendar.getInstance();     // Catch: Exception -> L43
        Calendar r21 = Calendar.getInstance();     // Catch: Exception -> L43
        r21.set(11, 23);     // Catch: Exception -> L43
        r21.set(12, 55);     // Catch: Exception -> L43
        r21.set(13, 0);     // Catch: Exception -> L43
        if (r20.after(r21) == false) goto L41;
        r21.add(5, 1);     // Catch: Exception -> L43
    L41:
        Intrinsics.checkNotNull(WorkManager.getInstance(AppHost.a.getApplication().getApplicationContext()).enqueueUniquePeriodicWork("DoraBuryPointManager_DailyWork", ExistingPeriodicWorkPolicy.REPLACE, new PeriodicWorkRequest.Builder(DoraBuryPointManager$DailyWorker.class, 24, TimeUnit.HOURS).setInitialDelay(r21.getTimeInMillis() - r20.getTimeInMillis(), TimeUnit.MILLISECONDS).build()));     // Catch: Exception -> L43
    L45:
        GestureSettingsTracker r22 = GestureSettingsTracker.a;
        this.L$0 = r5;
        this.label = 2;
        if (r22.e(this) != r2) goto L48;
        return r2;
    L48:
        r1 = r5;
    L43:
        e = move-exception;
        d.d(DoraBuryPointManager.b, "enqueueUniquePeriodicWork error : " + e.getMessage());
        goto L45
    L50:
        DoraBuryPointManager r24 = DoraBuryPointManager.a;
        r24.getClass();
        DoraBuryPointManager.k();
        if (DoraBuryPointManager.t.compareAndSet(true, false) == true) goto L53;
        r10 = "none";
    L63:
        if (r17 != 0) goto L65;
    L68:
        DoraBuryPointManager.j = 0;
        if (DoraSetting.g() == true) goto L71;
        DoraBuryPointManager.Q(r24, true, 2);
    L71:
        long r25 = DoraBuryPointManager.k;
        DoraBuryPointManager.k = 0;
        if (r25 <= 0) goto L121;
        DoraDevice r26 = this.$device;
        if (r26 == null) goto L121;
        int r110 = kj4.a.g().b();
        int r111 = kj4.a.g().d.c();
        int r112 = kj4.a.g().d.b();
        Pair[] r27 = new Pair[4];
        String r113 = "on";
        if (r110 == 0) goto L81;
        if (r110 == 1) goto L80;
        String r114 = r10;
    L82:
        r27[0] = TuplesKt.to("dora_wear_detection_settiings", r114);
        if (r111 == 0) goto L87;
        if (r111 == 1) goto L86;
        String r115 = r10;
    L88:
        r27[1] = TuplesKt.to("dora_photo_settings", r115);
        if (r112 == 0) goto L92;
        if (r112 == 1) goto L93;
        r113 = r10;
    L93:
        r27[2] = TuplesKt.to("dora_continuous_photo_settings", r113);
        r27[3] = TuplesKt.to("duration", Long.valueOf(SystemClock.elapsedRealtime() - r25));
        Map r28 = MapsKt.mutableMapOf(r27);
        if (r26.vendorId != 4096) goto L103;
        String r30 = r26.getSerialNumber();
        if (r30 != null) goto L98;
        r30 = r10;
    L98:
        r28.put("dora_hw_series_no", r30);
        String r31 = r26.softVersion;
        if (r31 != null) goto L101;
        r31 = r10;
    L101:
        r28.put("dora_hw_FW_version", r31);
    L120:
        r28.put("dora_forward_space", o59.a.f(r26));
        r24.L("dora_terminate_proprietary_protocol", MapsKt.toMap(r28));
        goto L121
    L103:
        if (o59.a.n(Integer.valueOf(r26.type)) == false) goto L112;
        String r32 = r26.getSerialNumber();
        if (r32 != null) goto L107;
        r32 = r10;
    L107:
        r28.put("dora_g_series_no", r32);
        String r33 = r26.softVersion;
        if (r33 != null) goto L110;
        r33 = r10;
    L110:
        r28.put("dora_g_FW_version", r33);
        goto L120
    L112:
        if (ProductNameType.DORA_E.deviceType != r26.type) goto L120;
        String r34 = r26.sn;
        if (r34 != null) goto L116;
        r34 = r10;
    L116:
        r28.put("dora_e_series_no", r34);
        String r35 = r26.softVersion;
        if (r35 != null) goto L119;
        r35 = r10;
    L119:
        r28.put("dora_e_FW_version", r35);
        goto L120
    L92:
        r113 = "off";
        goto L93
    L86:
        r115 = "on";
        goto L88
    L87:
        r115 = "off";
        goto L88
    L80:
        r114 = "on";
        goto L82
    L81:
        r114 = "off";
    L121:
        DoraBuryPointManager.i = 0;
        if (DoraSetting.g() == false) goto L124;
        DoraBuryPointManager.Q(r24, true, 2);
        goto L124
    L65:
        if (r18 != 0) goto L67;
        r5.put("protocol_time", Boxing.boxLong(r16 - r17));
        goto L68
    L67:
        r5.put("protocol_time", Boxing.boxLong(Math.min(r16 - r17, r16 - r18)));
        goto L68
    L53:
        if (DoraBuryPointManager.s <= DoraBuryPointManager.r) goto L55;
        long r116 = DoraBuryPointManager.s;
    L57:
        if (r116 <= 0) goto L59;
        long r36 = r16 - r116;
    L60:
        r24.N("active_disconnection_earphone_mode", r36);
        DoraBuryPointManager.r = 0;
        DoraBuryPointManager.s = 0;
        goto L63
    L59:
        r36 = 0;
        goto L60
    L55:
        r116 = DoraBuryPointManager.r;
    L21:
        r11 = "none";
        goto L22
    L16:
        r8 = "active_disconnection";
        goto L17
    L10:
        ResultKt.throwOnFailure(r23);
        d.d(DoraBuryPointManager.b, "onDoraLinkStateChanged " + this.$state);
        this.label = 1;
        if (DelayKt.delay(700, this) != r2) goto L13;
        return r2;
    }
}
