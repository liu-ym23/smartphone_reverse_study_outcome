package pka;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import f06.b;
import f06.d;
import java.util.ArrayList;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final a a = null;
    public static final Uri b = null;

    public a() {
    }

    static {
        a = new a();
        b = UriProtector.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    public static ContentProviderClient a(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
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
        d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static MemoryResponse b(String r3, IntentParams r4, DispatchContext r5) {
        Bundle r0 = new Bundle();
        r0.putParcelable("memoryIntentExecutorParams", r4);
        Long r6 = r5.getQuestionId();
        if (r6 == null) goto L6;
        r0.putLong("questionId", r6.longValue());
    L6:
        return c(r5.getContext(), r3, r0);
    }

    public static MemoryResponse c(Context r3, String r4, Bundle r5) {
        if (yia.a.a(r3) == MemoryServiceStatus.AVAILABLE) goto L32;
        return new MemoryResponse(407, "Memory service component disabled", 4);
    L32:
        ContentProviderClient r6 = a(r3.getContentResolver(), b);     // Catch: Exception -> L29
        if (r6 == null) goto L10;
        Bundle r1 = null;
        r1 = r6.call(r4, null, r5);     // Catch: Throwable -> L14 Exception -> L16 DeadObjectException -> L18
    L20:
        r6.close();     // Catch: Exception -> L29
    L22:
        if (r1 == null) goto L38;
        r1.setClassLoader(a.class.getClassLoader());     // Catch: Exception -> L29
        MemoryResponse r7 = (MemoryResponse) r1.getParcelable("memory_response");     // Catch: Exception -> L29
        if (r7 == null) goto L37;
        return r7;
    L37:
        return new MemoryResponse(400, "internal error", 4);
    L38:
        return new MemoryResponse(400, "internal error", 4);
    L14:
        th = move-exception;
        r6.close();     // Catch: Exception -> L29
        throw th;     // Catch: Exception -> L29
    L18:
        e = move-exception;
        ExceptionsKt.stackTraceToString(e);     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        ExceptionsKt.stackTraceToString(e);     // Catch: Throwable -> L14
        goto L20
    L10:
        return new MemoryResponse(404, "provider client unavailable", 4);
    L29:
        e = move-exception;
        ExceptionsKt.stackTraceToString(e);
        return new MemoryResponse(404, e.getMessage(), 4);
    }

    public static MemoryResponse d(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        Bundle r0 = new Bundle();
        r0.putString("doubaoGlassesStateKey", r3);
        r0.putString("doubaoGlassesStateValue", r4);
        return c(r2, "notifyDoubaoGlassesState", r0);
    }

    public static void e(Context r4, int r5, String r6, long r7, String r9, String r10, String r11, String r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "pkg");
        Intrinsics.checkNotNullParameter(r9, "appName");
        Bundle r2 = new Bundle();
        r2.putInt("notificationId", r5);
        r2.putString("pkg", r6);
        r2.putLong("postTime", r7);
        r2.putString("appName", r9);
        r2.putString(DBDefinition.TITLE, r10);
        r2.putString("subTitle", r11);
        r2.putString("content", r12);
        r2.putString(EffectConfiguration.KEY_CHANNEL, r13);
        r2.putInt("flags", r14);
        Unit r8 = Unit.INSTANCE;
        c(r4, "receiveNotificationData", r2);
    }
}
