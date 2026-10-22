package o89;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.larus.common.apphost.AppHost;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public static void a(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        if (r6 != null) goto L29;
        r6 = new JSONObject();
    L29:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        BtmSDK r1 = BtmSDK.INSTANCE;     // Catch: Throwable -> L21
        Object r2 = r1.getCurrentResumedPage();     // Catch: Throwable -> L21
        if (r2 != null) goto L10;
        r2 = r1.getLastCreatedPage();     // Catch: Throwable -> L21
        if (r2 != null) goto L10;
        r2 = AppHost.a.a().getCurrentActivity();     // Catch: Throwable -> L21
    L10:
        PageFinder r3 = PageFinder.via(r2);     // Catch: Throwable -> L21
        com.bytedance.android.btm.api.model.e r4 = r1.getBtmPageInfo(r3);     // Catch: Throwable -> L21
        if (r4 == null) goto L14;
        String r7 = r4.b;     // Catch: Throwable -> L21
        if (r7 == null) goto L14;
    L15:
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L21
        Iterator r8 = r1.createReportParams(r7, r3).entrySet().iterator();     // Catch: Throwable -> L21
    L17:
        if (r8.hasNext() == false) goto L19;
        Map.Entry r9 = (Map.Entry) r8.next();     // Catch: Throwable -> L21
        r6.putOpt((String) r9.getKey(), r9.getValue());     // Catch: Throwable -> L21
        goto L17
    L19:
        r6.putOpt("app_name", "doubao_ecom");     // Catch: Throwable -> L21
        AtomicBoolean r10 = q.a;     // Catch: Throwable -> L21
        Result.constructor-impl(r6.putOpt("duration", Long.valueOf(System.currentTimeMillis() - q.d)));     // Catch: Throwable -> L21
    L23:
        int r11 = ECSdk.a;
        IECHostService r12 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r12 == null) goto L32;
        xi.a r13 = r12.getIECHostLogService();
        if (r13 == null) goto L33;
        r13.logV3(r5, r6);
        return;
    L33:
        return;
    L32:
        return;
    L14:
        r7 = "c0.d0";
    L21:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
