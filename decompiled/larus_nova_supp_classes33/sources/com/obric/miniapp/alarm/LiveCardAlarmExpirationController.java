package com.obric.miniapp.alarm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.CalendarContract;
import androidx.core.content.ContextCompat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.obric.livecard.api.entity.IslandSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LiveCardAlarmExpirationController {
    public static final LiveCardAlarmExpirationController a = null;
    public static final CoroutineScope b = null;
    public static final ConcurrentHashMap<String, a> c = null;
    public static final AtomicBoolean d = null;
    public static final LiveCardAlarmExpirationController$eventsContentObserver$1 e = null;

    public static final class a {
        public final IslandSession a;
        public final Long b;
        public final long c;
        public final long d;
        public final PendingIntent e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Long r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            long r4 = this.c;
            int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
            long r6 = this.d;
            return ((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Record(session=" + this.a + ", eventId=" + this.b + ", createAtMs=" + this.c + ", durationMs=" + this.d + ", expirePendingIntent=" + this.e + ')';
        }

        public a(IslandSession r2, Long r3, long r4, long r6, PendingIntent r8) {
            Intrinsics.checkNotNullParameter(r2, "session");
            Intrinsics.checkNotNullParameter(r8, "expirePendingIntent");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r8;
        }
    }

    public LiveCardAlarmExpirationController() {
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.obric.miniapp.alarm.LiveCardAlarmExpirationController$eventsContentObserver$1] */
    static {
        a = new LiveCardAlarmExpirationController();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("LiveCardAlarmExpirationController");
        ThreadMethodProxy.start(r0);
        final Handler r1 = new Handler(r0.getLooper());
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(HandlerDispatcherKt.from$default(r1, null, 1, null)));
        c = new ConcurrentHashMap();
        d = new AtomicBoolean(false);
        e = new LiveCardAlarmExpirationController$eventsContentObserver$1(r1);
    }

    public static final /* synthetic */ Application a() {
        return a.getContext();
    }

    public static final void d() {
        Set<Map.Entry<String, a>> r0 = c.entrySet();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();
        r1.add(TuplesKt.to(r3.getKey(), r3.getValue()));
        goto L4
    L6:
        Iterator r4 = SequencesKt.filter(CollectionsKt.asSequence(r1), new x()).iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        Pair r5 = (Pair) r4.next();
        String r6 = (String) r5.component1();
        Long r7 = ((a) r5.component2()).b;
        if (r7 == null) goto L8;
        long r8 = r7.longValue();
        if (f(a.getContext(), Long.valueOf(r8)) == true) goto L8;
        Intrinsics.checkNotNullParameter(r6, "id");
        BuildersKt.launch$default(b, null, null, new LiveCardAlarmExpirationController$destroySession$1(r6, null), 3, null);
        goto L8
    }

    public static final void e() {
        LiveCardAlarmExpirationController r0 = a;
        Application r1 = r0.getContext();
        if (r1 == null) goto L55;
        Intrinsics.checkNotNullParameter(r1, "context");
        if (ContextCompat.checkSelfPermission(r1, "android.permission.READ_CALENDAR") == 0) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L14;
        return;
    L14:
        if ((!c.isEmpty()) == false) goto L31;
        if (d.get() == true) goto L57;
        Application r3 = r0.getContext();
        if (r3 == null) goto L50;
        ContentResolver r4 = r3.getContentResolver();
        if (r4 == null) goto L58;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L25
        r4.registerContentObserver(CalendarContract.Events.CONTENT_URI, true, e);     // Catch: Throwable -> L25
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L28:
        if (Result.isSuccess-impl(r6) == false) goto L51;
        Unit r7 = (Unit) r6;
        d.set(true);
        return;
    L51:
        return;
    L25:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L58:
        return;
    L50:
        return;
    L57:
        return;
    L31:
        if (d.get() == false) goto L59;
        Application r9 = r0.getContext();
        if (r9 == null) goto L53;
        ContentResolver r10 = r9.getContentResolver();
        if (r10 == null) goto L60;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L40
        r10.unregisterContentObserver(e);     // Catch: Throwable -> L40
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L43:
        if (Result.isSuccess-impl(r12) == false) goto L54;
        Unit r13 = (Unit) r12;
        d.set(false);
        return;
    L54:
        return;
    L40:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L60:
        return;
    L53:
        return;
    L59:
        return;
    L8:
        if (ContextCompat.checkSelfPermission(r1, "android.permission.WRITE_CALENDAR") != 0) goto L10;
        r2 = true;
        goto L11
    }

    private final Application getContext() {
        return AppHost.a.getApplication();
    }

    public final android.app.AlarmManager h() {
        Object r0 = getContext().getSystemService("alarm");
        if ((r0 instanceof android.app.AlarmManager) == true) goto L7;
        return null;
    L7:
        return (android.app.AlarmManager) r0;
    }

    public static final long c(IslandSession r2) {
        JsonObject r3 = r2.getExt();
        if (r3 == null) goto L7;
        JsonElement r4 = r3.get("timestamp");
        if (r4 == null) goto L7;
        return r4.getAsLong();
    L7:
        return 0;
    }

    public static boolean f(Context r5, Long r6) {
        if (r5 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullParameter(r5, "context");
        boolean r2 = true;
        if (ContextCompat.checkSelfPermission(r5, "android.permission.READ_CALENDAR") == 0) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
        return true;
    L13:
        if (r6 == null) goto L45;
        long r3 = r6.longValue();
        Object r7 = null;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L30
        Uri r8 = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, r3);     // Catch: Throwable -> L30
        Cursor r9 = g(r5.getContentResolver(), r8, new String[]{"_id"});     // Catch: Throwable -> L30
        if (r9 == null) goto L27;
        Cursor r10 = r9;     // Catch: Throwable -> L30
        boolean r11 = r10.moveToFirst();     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r10, null);     // Catch: Throwable -> L30
        if (r11 != true) goto L27;
    L28:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r12) == true) goto L36;
        r7 = r12;
    L36:
        Boolean r13 = (Boolean) r7;
        if (r13 != null) goto L39;
        return false;
    L39:
        return r13.booleanValue();
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L27:
        r2 = false;
    L30:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L45:
        return false;
    L8:
        if (ContextCompat.checkSelfPermission(r5, "android.permission.WRITE_CALENDAR") != 0) goto L10;
        r1 = true;
        goto L11
    }

    public static final PendingIntent b(String r4, long r5, long r7) {
        LiveCardAlarmExpirationController r0 = a;
        Intent r1 = new Intent(r0.getContext(), LiveCardAlarmExpireReceiver.class);
        r1.setAction("com.obric.miniapp.alarm.action.EXPIRE_LIVE_CARD." + r4);
        r1.putExtra("extra_id", r4);
        r1.putExtra("extra_task_id", r5);
        r1.putExtra("extra_expire_at_ms", r7);
        return PendingIntent.getBroadcast(r0.getContext(), 0, r1, 201326592);
    }

    public static Cursor g(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }
}
