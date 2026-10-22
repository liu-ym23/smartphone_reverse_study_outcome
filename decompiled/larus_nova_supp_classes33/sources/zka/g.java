package zka;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.alarm.w;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [zka.f] */
    public final void d(Context r5, final com.obric.miniapp.aibridge.f r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "onResult");
        final AtomicBoolean r0 = new AtomicBoolean(false);
        ?? r1 = new f(r0, r6);
        Messenger r7 = new Messenger(new k(r1, Looper.getMainLooper()));
        Bundle r2 = new Bundle();
        r2.putParcelable("callbackMessenger", r7);
        Bundle r8 = r5.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_GET_ALARM_IDS, null, r2);     // Catch: Exception -> L9
        if (r8 != null) goto L6;
    L7:
        r1.invoke(CollectionsKt.emptyList());     // Catch: Exception -> L9
        return;
    L6:
        if (r8.getBoolean("accepted", true) == false) goto L7;
        return;
    L9:
        e = move-exception;
        FLogger.a.e("AlarmOpsProxy", "getAlarmJsonById failed", e);
        r1.invoke(CollectionsKt.emptyList());
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [zka.d] */
    public final void b(Context r4, String r5, final com.obric.miniapp.aibridge.b r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "onResult");
        final AtomicBoolean r1 = new AtomicBoolean(false);
        ?? r2 = new d(r1, r6);
        Messenger r7 = new Messenger(new i(r2, Looper.getMainLooper()));
        Bundle r3 = new Bundle();
        r3.putString("id", r5);
        r3.putParcelable("callbackMessenger", r7);
        Bundle r8 = r4.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_DELETE_ALARM, null, r3);     // Catch: Exception -> L9
        if (r8 != null) goto L6;
    L7:
        r2.invoke(Boolean.FALSE);     // Catch: Exception -> L9
        return;
    L6:
        if (r8.getBoolean("accepted", true) == false) goto L7;
        return;
    L9:
        e = move-exception;
        FLogger.a.e("AlarmOpsProxy", "deleteAlarm failed", e);
        r2.invoke(Boolean.FALSE);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [zka.e] */
    public final void c(Context r4, String r5, final com.obric.miniapp.aibridge.d r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "onResult");
        final AtomicBoolean r1 = new AtomicBoolean(false);
        ?? r2 = new e(r1, r6);
        Messenger r7 = new Messenger(new j(r2, Looper.getMainLooper()));
        Bundle r3 = new Bundle();
        r3.putString("id", r5);
        r3.putParcelable("callbackMessenger", r7);
        Bundle r8 = r4.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_GET_ALARM_JSON_BY_ID, null, r3);     // Catch: Exception -> L9
        if (r8 != null) goto L6;
    L7:
        r2.invoke(null);     // Catch: Exception -> L9
        return;
    L6:
        if (r8.getBoolean("accepted", true) == false) goto L7;
        return;
    L9:
        e = move-exception;
        FLogger.a.e("AlarmOpsProxy", "getAlarmJsonById failed", e);
        r2.invoke(null);
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [zka.c] */
    public final void a(Context r9, String r10, String r11, String r12, w r13, Map r14, final Function1 r15) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r13, "triggerTime");
        Intrinsics.checkNotNullParameter(r14, "extraInfo");
        Intrinsics.checkNotNullParameter(r15, "onResult");
        long r4 = r13.b();
        if (StringsKt.isBlank(r10) == false) goto L5;
    L21:
        r15.invoke(Boolean.FALSE);
        return;
    L5:
        if (r4 == Long.MIN_VALUE) goto L21;
        final AtomicBoolean r16 = new AtomicBoolean(false);
        ?? r7 = new c(r16, r15);
        Messenger r17 = new Messenger(new h(r7, Looper.getMainLooper()));
        Bundle r18 = new Bundle();
        r18.putString("id", r10);
        r18.putString("title", r11);
        r18.putString("content", r12);
        r18.putLong("triggerAtMillis", r4);
        Bundle r19 = new Bundle(r14.size());
        Iterator r110 = r14.entrySet().iterator();
    L9:
        if (r110.hasNext() == false) goto L11;
        Map.Entry r111 = (Map.Entry) r110.next();
        r19.putString((String) r111.getKey(), (String) r111.getValue());
        goto L9
    L11:
        r18.putBundle("extraInfo", r19);
        r18.putLong("intervalMinutes", 0);
        r18.putInt("repeatCount", 0);
        r18.putParcelable("callbackMessenger", r17);
        Bundle r20 = r9.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_CREATE_OR_UPDATE_ALARM, null, r18);     // Catch: Exception -> L18
        if (r20 != null) goto L15;
    L16:
        r7.invoke(Boolean.FALSE);     // Catch: Exception -> L18
        return;
    L15:
        if (r20.getBoolean("accepted", true) == false) goto L16;
        return;
    L18:
        e = move-exception;
        FLogger.a.e("AlarmOpsProxy", "createOrUpdateAlarm failed", e);
        r7.invoke(Boolean.FALSE);
    }
}
