package v89;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.router.SmartRouter;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i implements Function2 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Context e;
    public final /* synthetic */ Uri f;

    public /* synthetic */ i(Ref.BooleanRef r1, long r2, String r4, String r5, Context r6, Uri r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public final Object invoke(Object r13, Object r14) {
        Ref.BooleanRef r0 = this.a;
        long r1 = this.b;
        String r7 = this.c;
        String r8 = this.d;
        Context r10 = this.e;
        Uri r11 = this.f;
        String r15 = (String) r13;
        String r16 = (String) r14;
        if (r0.element == true) goto L20;
        boolean r3 = true;
        r0.element = true;
        long r5 = SystemClock.elapsedRealtime() - r1;
        if (r15 != null) goto L7;
    L10:
        Lazy r2 = p.a;
        if (r3 == false) goto L18;
        if (r16 != null) goto L14;
        String r4 = "unknown";
    L15:
        FLogger r17 = FLogger.a;
        r17.i("FlowTransferRedirect", "[route] schema is empty, fallback to handleECSchema, reason=".concat(r4));
        p.a("fallback", r4, r5, r7, r8, r10);
        r17.i("FlowTransferRedirect", "[fallback] handleECSchema " + r11);
        IECommerceService r18 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r18 == null) goto L20;
        r18.c(r10, r11);
        goto L20
    L14:
        r4 = r16;
        goto L15
    L18:
        FLogger.a.i("FlowTransferRedirect", "[route] openSchema: " + r15);
        p.a(FlowDoraConnectReason.SUCCESS, "", r5, r7, r8, r10);
        SmartRouter.buildRoute(r10, r15).d();
        goto L20
    L7:
        if (r15.length() == 0) goto L10;
        r3 = false;
    L20:
        return Unit.INSTANCE;
    }
}
