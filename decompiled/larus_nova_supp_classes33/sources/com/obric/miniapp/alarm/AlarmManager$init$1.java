package com.obric.miniapp.alarm;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import androidx.work.WorkManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$init$1", f = "AlarmManager.kt", i = {}, l = {57, 72}, m = "invokeSuspend", n = {}, s = {})
public final class AlarmManager$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.obric.miniapp.alarm.AlarmManager$init$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public static final AnonymousClass1<T> a = null;

        static {
            a = new AnonymousClass1();
        }

        public AnonymousClass1() {
        }

        public final Object a(a r5, Continuation<? super Unit> r6) {
            if ((r6 instanceof AlarmManager$init$1$1$emit$1) == false) goto L7;
            AlarmManager$init$1$1$emit$1 r0 = (AlarmManager$init$1$1$emit$1) r6;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r5 = (a) r0.L$0;
            ResultKt.throwOnFailure(r7);
        L17:
            Lazy r8 = m0.a;
            Intrinsics.checkNotNullParameter(r5, "alarm");
            ((WorkManager) m0.c.getValue()).cancelUniqueWork("alarm_" + r5.a);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            AlarmManager.a.getClass();
            b r9 = AlarmManager.i();
            r0.L$0 = r5;
            r0.label = 1;
            if (r9.insert(r5, r0) != r2) goto L17;
            return r2;
        L7:
            r0 = new AlarmManager$init$1$1$emit$1(this, r6);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((a) r1, r2);
        }
    }

    public AlarmManager$init$1(Continuation<? super AlarmManager$init$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AlarmManager$init$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r19);
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
    L24:
        AlarmManager.a.getClass();
        SharedPreferences.Editor r3 = AlarmManager.j().edit();
        r3.clear();
        r3.putBoolean("removed", true);
        r3.apply();
        FLogger.a.i("AlarmManager", "Version transfer finished.");
    L25:
        ((WorkManager) m0.c.getValue()).cancelUniqueWork("AlarmManager-AlarmWorker");
        AlarmManager r4 = AlarmManager.a;
        this.label = 2;
        if (r4.m(this) != r1) goto L29;
        return r1;
    L10:
        ResultKt.throwOnFailure(r19);
        Lazy r5 = AlarmTtsNotificationDispatcher.a;
        yka.a r6 = yka.a.b;
        AppHost.Companion r7 = AppHost.a;
        Application r8 = r7.getApplication();
        Messenger r9 = new Messenger(new Handler(Looper.getMainLooper(), new p()));
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "messenger");
        zka.q r10 = yka.a.c;
        if (r10.e.c(r10.a) == false) goto L13;
        zka.m r11 = r10.b;
    L14:
        if (r11 == null) goto L16;
        r11.a(r8, r9);
    L16:
        BuildersKt.launch$default(AlarmTtsNotificationDispatcher.e, null, null, new AlarmTtsNotificationDispatcher$startWork$2(null), 3, null);
        if (Build.VERSION.SDK_INT < 26) goto L19;
        b0.a.getClass();
        b0.a.a().c();
    L19:
        AlarmManager.a.getClass();
        if (AlarmManager.j().contains("removed") == true) goto L25;
        FLogger.a.i("AlarmManager", "Start version transfer...");
        c1 r12 = new c1(new AlarmManager$loadAlarmsV0$1(AlarmManager.j().getInt("alarm_count", 0), new PolarisFileWrapper(r7.getApplication().getCacheDir(), "alarm_extra_info"), null));
        FlowCollector r13 = AnonymousClass1.a;
        this.label = 1;
        if (r12.collect(r13, this) != r1) goto L24;
        return r1;
    L13:
        r11 = null;
        goto L14
    }
}
