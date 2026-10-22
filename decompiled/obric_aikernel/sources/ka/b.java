package ka;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"StaticFieldLeak"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f10144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f10145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ma.a f10146d;

    static {
        f10143a = new b();
    }

    private b() {
    }

    private final boolean a(String r10, Bundle r11) {
        ContentProviderClient r12 = d("com.obric.processservice.ProcessProvider");
        boolean r13 = false;
        Bundle r14 = r12.call("com.obric.processservice.ProcessProvider", r10, null, r11);     // Catch: Throwable -> L11 Exception -> L13
        if (r14 != null) goto L6;
    L10:
        r12.close();
        return r13;
    L6:
        if (r14.containsKey("result_boolean") == false) goto L10;
        if (r14.getBoolean("result_boolean") == false) goto L10;
        r13 = true;
        goto L10
    L11:
        th = move-exception;
        r12.close();
        throw th;
    L13:
        e = move-exception;
        a r15 = f10145c;     // Catch: Throwable -> L11
        if (r15 == null) goto L10;
        r15.e("ProcessServiceSdk", "callWithBooleanResult failed, method:" + r10 + ", extras:" + r11, e);     // Catch: Throwable -> L11
        goto L10
    }

    private final String c() {
        Context r10 = f10144b;
        if (r10 == null) goto L5;
        String r11 = r10.getPackageName();
    L6:
        if (r11 == null) goto L9;
        return r11;
    L9:
        throw new IllegalStateException("mContext is null, please init first");
    L5:
        r11 = null;
        goto L6
    }

    private final ContentProviderClient d(String r10) {
        Context r11 = f10144b;
        if (r11 == null) goto L7;
        ContentResolver r12 = r11.getContentResolver();
        if (r12 == null) goto L7;
        ContentProviderClient r13 = r12.acquireUnstableContentProviderClient(r10);
    L8:
        if (r13 == null) goto L11;
        return r13;
    L11:
        throw new IllegalStateException("acquireUnstableContentProviderClient failed");
    L7:
        r13 = null;
        goto L8
    }

    public final void b() {
        a r10 = f10145c;
        if (r10 == null) goto L9;
        StringBuilder r11 = new StringBuilder();
        r11.append("executeWakeUpCallback， mWakeUpCallback is null：");
        if (f10146d != null) goto L7;
        boolean r12 = true;
    L8:
        r11.append(r12);
        r10.d("ProcessServiceSdk", r11.toString());
        goto L9
    L7:
        r12 = false;
    L9:
        ma.a r13 = f10146d;
        if (r13 == null) goto L13;
        r13.a();
        return;
    }

    public final void e(Context r10, a r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "logger");
        Log.d("ProcessServiceSdk", "init, context:" + r10);
        f10144b = r10.getApplicationContext();
        f10145c = r11;
        la.a r12 = la.a.f10917a;
        r12.b(f10144b);
        r12.c(r11);
    }

    public final boolean f(String r10, int r11, String r12, long r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        if (r13 > 0) goto L8;
        StringBuilder r15 = new StringBuilder();
        String r16 = "registerKeepAlive, timeOutMs is invalid, timeOutMs:";
    L5:
        r15.append(r16);
        r15.append(r13);
        Log.e("ProcessServiceSdk", r15.toString());
        return false;
    L8:
        if (r13 < 1800000) goto L10;
        r15 = new StringBuilder();
        r16 = "registerUnfreeze, timeOutMs>=1800000, timeOutMs:";
        goto L5
    L10:
        String r17 = c();
        a r18 = f10145c;
        if (r18 == null) goto L13;
        r18.d("ProcessServiceSdk", "registerKeepAlive, caller packageName:" + r17 + ", packageName:" + r10 + ", uid:" + r11 + ", processName:" + r12 + " timeOut:" + r13);
    L13:
        Bundle r19 = new Bundle();
        r19.putString("extra_package_caller", r17);
        r19.putString("extra_package_name", r10);
        r19.putInt("extra_uid", r11);
        r19.putString("extra_process_name", r12);
        r19.putLong("extra_time_out", r13);
        r19.putString("extra_reason", r14);
        return a("method_register_keep_alive", r19);
    }

    public final boolean g(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        if (r11 > 0) goto L8;
        StringBuilder r12 = new StringBuilder();
        String r13 = "registerUnfreeze, timeOutMs<=0, timeOutMs:";
    L5:
        r12.append(r13);
        r12.append(r11);
        Log.e("ProcessServiceSdk", r12.toString());
        return false;
    L8:
        if (r11 < 1800000) goto L10;
        r12 = new StringBuilder();
        r13 = "registerUnfreeze, timeOutMs>=1800000, timeOutMs:";
        goto L5
    L10:
        String r14 = c();
        a r15 = f10145c;
        if (r15 == null) goto L13;
        r15.d("ProcessServiceSdk", "requestUnfreeze, caller packageName:" + r14 + ", packageName:" + r10 + ", timeOut:" + r11);
    L13:
        Bundle r16 = new Bundle();
        r16.putString("extra_package_caller", r14);
        r16.putString("extra_package_name", r10);
        r16.putLong("extra_time_out", r11);
        return a("method_register_unfreeze", r16);
    }

    public final boolean h(String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        String r13 = c();
        a r14 = f10145c;
        if (r14 == null) goto L5;
        r14.d("ProcessServiceSdk", "unregisterKeepAlive, caller packageName:" + r13 + ", packageName:" + r10);
    L5:
        Bundle r15 = new Bundle();
        r15.putString("extra_package_caller", r13);
        r15.putString("extra_package_name", r10);
        r15.putString("extra_process_name", r12);
        r15.putInt("extra_uid", r11);
        return a("method_unregister_keep_alive", r15);
    }
}
