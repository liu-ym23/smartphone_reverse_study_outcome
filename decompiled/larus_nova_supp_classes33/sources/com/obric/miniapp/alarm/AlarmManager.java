package com.obric.miniapp.alarm;

import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AlarmManager {
    public static final AlarmManager a = null;
    public static final CoroutineScope b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public AlarmManager() {
    }

    static {
        a = new AlarmManager();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        c = LazyKt.lazy(new g());
        d = LazyKt.lazy(new h());
        e = LazyKt.lazy(new i());
        f = LazyKt.lazy(new j());
    }

    public static b i() {
        return ((AlarmDatabase) c.getValue()).c();
    }

    public static SharedPreferences j() {
        return (SharedPreferences) d.getValue();
    }

    public static void k() {
        Lazy r0 = m0.a;
        BuildersKt.launch$default(b, null, null, new AlarmManager$init$1(null), 3, null);
    }

    public static void h(com.obric.miniapp.aibridge.g r7) {
        Intrinsics.checkNotNullParameter(r7, "onResult");
        BuildersKt.launch$default(b, null, null, new AlarmManager$getAllAlarmIds$1(r7, null), 3, null);
    }

    public static final Map<String, String> l(String r5) {
        JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L7
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Exception -> L7
        Iterator<String> r2 = r0.keys();     // Catch: Exception -> L7
    L4:
        if (r2.hasNext() == false) goto L14;
        String r3 = r2.next();     // Catch: Exception -> L7
        r1.put(r3, r0.optString(r3));     // Catch: Exception -> L7
        goto L4
    L14:
        return r1;
    L7:
        e = move-exception;
        FLogger.a.e("AlarmManager", "parse extraInfo failed " + r5, e);
        return null;
    }

    public final Object d(Continuation<? super Unit> r8) {
        if ((r8 instanceof AlarmManager$clearAll$1) == false) goto L7;
        AlarmManager$clearAll$1 r0 = (AlarmManager$clearAll$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Iterator r4 = (Iterator) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L29:
        if (r4.hasNext() == false) goto L33;
        a r10 = (a) r4.next();
        CoroutineDispatcher r5 = Dispatchers.getIO();
        AlarmManager$clearAll$3$1 r6 = new AlarmManager$clearAll$3$1(r10, null);
        r0.L$0 = r4;
        r0.label = 2;
        if (BuildersKt.withContext(r5, r6, r0) != r2) goto L29;
        return r2;
    L33:
        ((AlarmDatabase) c.getValue()).clearAllTables();
        ((android.app.AlarmManager) m0.d.getValue()).cancel((PendingIntent) m0.e.getValue());
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
    L21:
        ArrayList r7 = new ArrayList();
        Iterator r11 = ((Iterable) r9).iterator();
    L23:
        if (r11.hasNext() == false) goto L27;
        Object r12 = r11.next();
        if (((a) r12).k == false) goto L23;
        r7.add(r12);
        goto L23
    L27:
        r4 = r7.iterator();
        goto L29
    L16:
        ResultKt.throwOnFailure(r9);
        if (Build.VERSION.SDK_INT < 29) goto L33;
        b r13 = i();
        r0.label = 1;
        r9 = r13.a(r0);
        if (r9 != r2) goto L21;
        return r2;
    L7:
        r0 = new AlarmManager$clearAll$1(this, r8);
        goto L8
    }

    public final Object m(Continuation<? super Unit> r6) {
        if ((r6 instanceof AlarmManager$rescheduleAlarm$1) == false) goto L7;
        AlarmManager$rescheduleAlarm$1 r0 = (AlarmManager$rescheduleAlarm$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        w r8 = (w) r7;
        if (r8 == null) goto L32;
        Lazy r5 = m0.a;
        long r9 = r8.b();
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 31) goto L22;
    L25:
        if (r4 == true) goto L27;
        ((android.app.AlarmManager) m0.d.getValue()).setAndAllowWhileIdle(0, r9, (PendingIntent) m0.e.getValue());
        goto L32
    L27:
        if (r10 < 23) goto L29;
        ((android.app.AlarmManager) m0.d.getValue()).setExactAndAllowWhileIdle(0, r9, (PendingIntent) m0.e.getValue());
        goto L32
    L29:
        ((android.app.AlarmManager) m0.d.getValue()).setExact(0, r9, (PendingIntent) m0.e.getValue());
        goto L32
    L22:
        if (((android.app.AlarmManager) m0.d.getValue()).canScheduleExactAlarms() == true) goto L25;
        r4 = false;
    L32:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        b r11 = ((AlarmDatabase) c.getValue()).c();
        r0.label = 1;
        r7 = r11.e(r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new AlarmManager$rescheduleAlarm$1(this, r6);
        goto L8
    }

    public static void f(String r7, com.obric.miniapp.aibridge.c r8) {
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r8, "onResult");
        BuildersKt.launch$default(b, null, null, new AlarmManager$deleteAlarm$1(r7, r8, null), 3, null);
    }

    public static void g(String r7, com.obric.miniapp.aibridge.e r8) {
        Intrinsics.checkNotNullParameter(r7, "id");
        Intrinsics.checkNotNullParameter(r8, "onResult");
        BuildersKt.launch$default(b, null, null, new AlarmManager$getAlarmJsonById$1(r8, r7, null), 3, null);
    }

    public static final Object b(AlarmManager r10, String r11, Continuation r12) {
        r10.getClass();
        if ((r12 instanceof AlarmManager$doDeleteAlarm$1) == false) goto L7;
        AlarmManager$doDeleteAlarm$1 r0 = (AlarmManager$doDeleteAlarm$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L18;
        if (r3 != 5) goto L17;
        ResultKt.throwOnFailure(r13);
    L50:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        a r14 = (a) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L45:
        if (r14.k == true) goto L50;
        r0.L$0 = null;
        r0.label = 5;
        if (r10.m(r0) != r2) goto L50;
        return r2;
    L19:
        r14 = (a) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L41:
        b r15 = i();
        String r5 = r14.l;
        r0.L$0 = r14;
        r0.L$1 = null;
        r0.label = 4;
        if (r15.delete(r4, r5, r0) != r2) goto L45;
        return r2;
    L20:
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        a r16 = (a) r13;
        if (r16 != null) goto L34;
    L51:
        return Unit.INSTANCE;
    L34:
        if (r16.k == true) goto L36;
    L40:
        r4 = r11;
        r14 = r16;
        goto L41
    L36:
        if (Build.VERSION.SDK_INT < 29) goto L40;
        CoroutineDispatcher r6 = Dispatchers.getIO();
        AlarmManager$doDeleteAlarm$2 r7 = new AlarmManager$doDeleteAlarm$2(r16, null);
        r0.L$0 = r11;
        r0.L$1 = r16;
        r0.label = 3;
        if (BuildersKt.withContext(r6, r7, r0) != r2) goto L40;
        return r2;
    L21:
        ResultKt.throwOnFailure(r13);
        goto L51
    L22:
        ResultKt.throwOnFailure(r13);
        FLogger.a.i("AlarmManager", "Deleting alarm id=" + r11);
        if (Intrinsics.areEqual(r11, "clear_all_alarm") == false) goto L27;
        r0.label = 1;
        if (r10.d(r0) != r2) goto L51;
        return r2;
    L27:
        b r17 = i();
        r0.L$0 = r11;
        r0.label = 2;
        r13 = r17.c(r11, r0);
        if (r13 != r2) goto L30;
        return r2;
    L7:
        r0 = new AlarmManager$doDeleteAlarm$1(r10, r12);
        goto L8
    }

    public static final Object c(AlarmManager r6, PolarisFileWrapper r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof AlarmManager$loadExtraInfoFromFile$1) == false) goto L7;
        AlarmManager$loadExtraInfoFromFile$1 r0 = (AlarmManager$loadExtraInfoFromFile$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        r7 = (File) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L25
    L22:
        String r11 = (String) r9;     // Catch: Exception -> L25
        Map<String, String> r12 = l(r11);     // Catch: Exception -> L25
        FLogger.a.i("AlarmManager", "load from " + r7.getName() + " succeeded, " + r11.length() + " bytes");     // Catch: Exception -> L25
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        if (r7.exists() == false) goto L23;
        CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Exception -> L25
        AlarmManager$loadExtraInfoFromFile$jsonString$1 r3 = new AlarmManager$loadExtraInfoFromFile$jsonString$1(r7, null);     // Catch: Exception -> L25
        r0.L$0 = r7;     // Catch: Exception -> L25
        r0.label = 1;     // Catch: Exception -> L25
        r9 = BuildersKt.withContext(r13, r3, r0);     // Catch: Exception -> L25
        if (r9 != r10) goto L22;
        return r10;
    L23:
        FLogger.a.i("AlarmManager", "load from " + r7.getName() + ", not exists");     // Catch: Exception -> L25
    L28:
        return null;
    L25:
        e = move-exception;
        FLogger.a.e("AlarmManager", "load from " + r7.getName() + " failed", e);
    L7:
        r0 = new AlarmManager$loadExtraInfoFromFile$1(r6, r8);
        goto L8
    }

    public static void e(String r15, String r16, String r17, w r18, Map r19, Function1 r20) {
        Intrinsics.checkNotNullParameter(r15, "id");
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "content");
        Intrinsics.checkNotNullParameter(r18, "triggerTime");
        Intrinsics.checkNotNullParameter(r19, "extraInfo");
        Intrinsics.checkNotNullParameter(r20, "onResult");
        BuildersKt.launch$default(b, null, null, new AlarmManager$createOrUpdateAlarm$1(r15, r16, r17, r18, 0, 0, r20, r19, null), 3, null);
    }

    public static final Object a(AlarmManager r37, String r38, String r39, String r40, w r41, Map r42, long r43, int r45, Continuation r46) {
        r37.getClass();
        if ((r46 instanceof AlarmManager$doCreateOrUpdateAlarm$1) == false) goto L7;
        AlarmManager$doCreateOrUpdateAlarm$1 r3 = (AlarmManager$doCreateOrUpdateAlarm$1) r46;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r3.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r2);
    L91:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r2);
    L14:
        Object r6 = null;
    L87:
        r3.L$0 = r6;
        r3.label = 6;
        if (r37.m(r3) != r5) goto L91;
        return r5;
    L15:
        a r0 = (a) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L79:
        if (r0 == null) goto L14;
        if (r0.k == false) goto L14;
        if (Build.VERSION.SDK_INT < 29) goto L14;
        CoroutineDispatcher r1 = Dispatchers.getIO();
        r6 = null;
        AlarmManager$doCreateOrUpdateAlarm$5$1 r7 = new AlarmManager$doCreateOrUpdateAlarm$5$1(r0, null);
        r3.L$0 = null;
        r3.label = 5;
        if (BuildersKt.withContext(r1, r7, r3) != r5) goto L87;
        return r5;
    L16:
        ResultKt.throwOnFailure(r2);
    L95:
        return Unit.INSTANCE;
    L17:
        a r8 = (a) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r9 = null;
    L61:
        if (r8 == null) goto L95;
        if (r8.k == true) goto L95;
        AlarmManager r10 = a;
        r3.L$0 = r9;
        r3.label = 3;
        if (r10.m(r3) != r5) goto L95;
        return r5;
    L18:
        int r11 = r3.I$0;
        long r12 = r3.J$0;
        w r13 = (w) r3.L$5;
        Map r14 = (Map) r3.L$4;
        w r15 = (w) r3.L$3;
        String r16 = (String) r3.L$2;
        String r17 = (String) r3.L$1;
        String r18 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        int r19 = r11;
        Object r20 = r2;
        Map r21 = r14;
        String r110 = r17;
        String r22 = r18;
        long r111 = r12;
        w r112 = r15;
        String r113 = r16;
    L23:
        a r23 = (a) r20;
        if (r23 != null) goto L26;
        FLogger.a.i("AlarmManager", "Creating alarm id=" + r22);
    L42:
        String r24 = String.valueOf(((SecureRandom) e.getValue()).nextLong());
        String r25 = (String) r21.get("notify");
        if (r25 == null) goto L45;
        boolean r26 = StringsKt.equals(r25, "alarm", true);
    L46:
        if (r23 == null) goto L48;
        a r27 = a.a(r23, r22, r110, r113, r112, r111, r19, r21, r26, r24, 448);
    L49:
        if (r26 == false) goto L70;
        if (Build.VERSION.SDK_INT >= 29) goto L92;
    L68:
        FLogger.a.w("AlarmManager", "Schedule system alarm failed; fallback id=" + r22);
        r27 = a.a(r27, null, null, null, null, 0, 0, null, false, null, 3071);
        r27.j.put("notify", "notification");
        goto L70
    L92:
        boolean r28 = m0.d(r27);     // Catch: Exception -> L54
    L56:
        if (r28 == false) goto L68;
        b r29 = i();
        r3.L$0 = r23;
        r9 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.label = 2;
        if (r29.insert(r27, r3) == r5) goto L98;
        r8 = r23;
        goto L61
    L98:
        return r5;
    L54:
        e = move-exception;
        FLogger.a.e("AlarmManager", "scheduleSystemAlarm exception", e);
        r28 = false;
    L70:
        if (r27.d.a(r13) >= 0) goto L73;
        b0.a.getClass();
        b0.a.a().a(r27);
        return Unit.INSTANCE;
    L73:
        if (r27.d.a(r13) <= 0) goto L75;
        b0.a.getClass();
        b0.a.a().b(r27.a);
    L75:
        b r30 = i();
        r3.L$0 = r23;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.label = 4;
        if (r30.insert(r27, r3) == r5) goto L100;
        r0 = r23;
        goto L79
    L100:
        return r5;
    L48:
        r27 = new a(r22, r110, r113, r112, r111, r19, r13, r21, r26, r24, 192);
        goto L49
    L45:
        r26 = false;
        goto L46
    L26:
        if (Intrinsics.areEqual(r23.a, r22) == true) goto L28;
    L40:
        FLogger.a.i("AlarmManager", "Updating alarm id=" + r22);
        goto L42
    L28:
        if (Intrinsics.areEqual(r23.b, r110) == false) goto L40;
        if (Intrinsics.areEqual(r23.c, r113) == false) goto L40;
        if (Intrinsics.areEqual(r23.d, r112) == false) goto L40;
        if (r23.e != r111) goto L40;
        if (r23.f != r19) goto L40;
        if (Intrinsics.areEqual(r23.j, r21) == false) goto L40;
        FLogger.a.i("AlarmManager", "Duplicated alarm id=" + r22);
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r2);
        boolean r31 = w.b;
        r13 = w.a.a();
        b r32 = i();
        r3.L$0 = r38;
        r3.L$1 = r39;
        r3.L$2 = r40;
        r3.L$3 = r41;
        r3.L$4 = r42;
        r3.L$5 = r13;
        r3.J$0 = r43;
        r3.I$0 = r45;
        r3.label = 1;
        Object r33 = r32.c(r38, r3);
        if (r33 == r5) goto L97;
        r22 = r38;
        r20 = r33;
        r110 = r39;
        r21 = r42;
        r113 = r40;
        r19 = r45;
        r111 = r43;
        r112 = r41;
        goto L23
    L97:
        return r5;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r3 = new AlarmManager$doCreateOrUpdateAlarm$1(r37, r46);
        goto L8
    }
}
