package com.obric.aikernel.request;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.ChargingStateListener;
import com.obric.aikernel.middleware.api.appcontext.receiver.d;
import com.obric.aikernel.middleware.api.appcontext.receiver.e;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class CallerActionLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CallerActionLogger f4835a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l0 f4836b = null;

    static {
        f4835a = new CallerActionLogger();
        f4836b = m0.a(z0.b());
    }

    private CallerActionLogger() {
    }

    private final void a(String r10, String r11, RequestParams r12, Bundle r13) {
        JSONObject r14 = new JSONObject();
        r14.put(NotificationCompat.CATEGORY_EVENT, r10);
        r14.put("bizs", r11);
        r14.put("caller", e8.a.j(r12.getBackend()));
        r14.put(ITrackerApi.CALLER_PKG, e8.a.j(r12.getBackend()));
        r14.put("pid", r12.getBackend().getInt(RequestParams.Args_Pid));
        r14.put("uid", r12.getBackend().getInt(RequestParams.Args_Uid));
        r14.put("loratype", com.obric.aikernel.utils.b.a(r12.getBackend()));
        r14.put("trace_id", r12.getTraceIdStr());
        r14.put("net_window", d.f4534a.e());
        r14.put("thermal", n7.a.f11264a.a().getValue().intValue());
        r14.put("battLev", com.obric.aikernel.middleware.api.appcontext.receiver.a.f4528a.c().getValue().intValue());
        r14.put("charging", ChargingStateListener.f4508a.e());
        r14.put("screen_on", e.f4540a.d());
        ApiPerfDetails.a r15 = ApiPerfDetails.Companion;
        boolean r16 = false;
        if (r15.b(r12.getBackend()).getBoolean("is_cloud") == true) goto L13;
        Bundle r17 = r15.d(r12.getBackend());
        if (r17 != null) goto L7;
    L9:
        boolean r18 = false;
    L10:
        if (r18 == true) goto L13;
        boolean r19 = false;
    L14:
        r14.put("is_cloud", r19);
        r14.put("version", r15.b(r12.getBackend()).getString("version"));
        Long r20 = Long.valueOf(r15.c(r12.getBackend(), ApiPerfDetails.onEndApiElapse));
        if (r20.longValue() <= 0) goto L18;
        r16 = true;
    L18:
        if (r16 == true) goto L21;
        r20 = null;
    L21:
        if (r20 == null) goto L23;
        long r21 = r20.longValue();
    L24:
        r14.put("duration", r15.h(r21, r12.getReqTime()));
        r14.put("device_id", AppContext.INSTANCE.getServerDeviceId());
        if (r13 == null) goto L27;
        r14.put("status", e8.a.f(r13));
    L27:
        h.d(f4836b, null, null, new CallerActionLogger$noteLog$1(r14, null), 3, null);
        return;
    L23:
        r21 = SystemClock.elapsedRealtime();
        goto L24
    L7:
        if (r17.getBoolean("is_cloud") != true) goto L9;
        r18 = true;
    L13:
        r19 = true;
        goto L14
    }

    static /* synthetic */ void b(CallerActionLogger r10, String r11, String r12, RequestParams r13, Bundle r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L5;
        r14 = null;
    L5:
        r10.a(r11, r12, r13, r14);
    }

    public static /* synthetic */ void d(CallerActionLogger r10, RequestParams r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.c(r11, r12);
    }

    public final void c(RequestParams r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        a("infer-end", e8.a.e(r10.getBackend()), r10, r11);
    }

    public final void e(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        b(this, "infer-start", e8.a.e(r10.getBackend()), r10, null, 8, null);
    }

    public final void f(RequestParams r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        List<PackageResource> r10 = e8.a.i(r11.getBackend());
        if (r10 == null) goto L6;
        String r12 = CollectionsKt.joinToString$default(r10, null, null, null, 0, null, CallerActionLogger$noteUpdatePackageEnd$1.INSTANCE, 31, null);
        if (r12 == null) goto L6;
    L7:
        b(this, "update-end", r12, r11, null, 8, null);
        return;
    L6:
        r12 = "";
        goto L7
    }

    public final void g(RequestParams r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        List<PackageResource> r10 = e8.a.i(r11.getBackend());
        if (r10 == null) goto L6;
        String r12 = CollectionsKt.joinToString$default(r10, null, null, null, 0, null, CallerActionLogger$noteUpdatePackageStart$1.INSTANCE, 31, null);
        if (r12 == null) goto L6;
    L7:
        b(this, "update-start", r12, r11, null, 8, null);
        return;
    L6:
        r12 = "";
        goto L7
    }
}
