package w40;

import android.app.Activity;
import com.bytedance.android.live.core.ILiveCoreService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.verify.interceptor.MinorInterceptor;
import com.bytedance.android.live.core.verify.monitor.RealNameFullMonitor;
import com.bytedance.android.live.network.impl.interceptor.u;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.vs.f;
import java.util.Arrays;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a implements ILiveCoreService {
    public a() {
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public boolean realNameUseTracePlatform() {
        int r0 = RealNameFullMonitor.a;
        return true;
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public void sendLog(String r3, Map<String, String> r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "extraParams");
        Intrinsics.checkNotNullParameter(r5, "args");
        f.c.c(r3, r4, Arrays.copyOf(r5, r5.length));
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public void reportUseTrace(String r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r3, "serviceName");
        int r1 = RealNameFullMonitor.a;
        Intrinsics.checkNotNullParameter(r3, "serviceName");
        int r0 = e.m;
        e.a r7 = e.b.a(r3, LiveTracingMonitor.EventModule.REAL_NAME.getName());
        r7.c = "webcast_client_community";
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(k.n(IUserService.class).user().n());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = "";
    L10:
        r7.g = (String) r8;
        e r9 = r7.a();
        a60.e r11 = c.a;
        Intrinsics.checkNotNullParameter(r9, "traceMeta");
        TraceMonitor.i(r9, r4, r5, r6);
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public boolean liveRechargeIntercept(String r8, int r9, BaseResponse<?, ?> r11, String r12, RequestError r13) {
        Intrinsics.checkNotNullParameter(r11, "response");
        Intrinsics.checkNotNullParameter(r12, "requestPage");
        return u.b.a(r8, r9, r11, r12, r13);
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public void minorInterceptOld(Activity r8, int r9, String r11, RequestError r12, t80.a r13) {
        Intrinsics.checkNotNullParameter(r11, "requestPage");
        MinorInterceptor.d.h(r8, r9, r11, r12, r13);
    }

    @Override // com.bytedance.android.live.core.ILiveCoreService
    public void minorIntercept(Activity r15, int r16, String r17, RequestError r18, t80.a r19, JSONObject r21) {
        Intrinsics.checkNotNullParameter(r17, "requestPage");
        Intrinsics.checkNotNullParameter(r21, "result");
        MinorInterceptor r4 = MinorInterceptor.d;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r17, "requestPage");
        Intrinsics.checkNotNullParameter(r21, "result");
        if (MinorInterceptor.b.contains(Integer.valueOf(r16)) == false) goto L30;
        JSONObject r0 = r21.optJSONObject("raw");
        if (r0 == null) goto L8;
        JSONObject r1 = r0.optJSONObject("extra");
    L10:
        if (r1 == null) goto L12;
        String r11 = r1.optString("scene", "");
    L13:
        if (r1 == null) goto L15;
        String r12 = r1.optString("flow", "");
    L16:
        if (r1 == null) goto L18;
        String r13 = r1.optString("ticket", "");
    L19:
        if (r11 != null) goto L21;
    L24:
        boolean r2 = true;
    L25:
        if (r2 == false) goto L27;
        r4.h(r15, r16, "live_detail", r18, r19);
        return;
    L27:
        r4.g(r15, r16, "live_detail", r18, r19, r11, r12, r13, true);
        return;
    L21:
        if (r11.length() == 0) goto L24;
        r2 = false;
        goto L25
    L18:
        r13 = null;
        goto L19
    L15:
        r12 = null;
        goto L16
    L12:
        r11 = null;
        goto L13
    L8:
        r1 = null;
        goto L10
    }
}
