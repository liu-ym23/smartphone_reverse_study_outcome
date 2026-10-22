package z80;

import com.bytedance.android.live.core.verify.monitor.RealNameFullMonitor;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v80.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements x80.a {

    /* JADX INFO: renamed from: z80.a$a, reason: collision with other inner class name */
    public static final class C0299a implements IHostOCRApiProxy.OCRProxyCallback {
        public final /* synthetic */ h a;

        public C0299a(h r1) {
            this.a = r1;
        }

        public final void onDetectOCRFinish(int r7, int r8, String r9, JSONObject r11) {
            v80.e r0 = (v80.e) this.a;
            String r1 = r0.b;
            JSONObject r2 = new JSONObject();
            r2.put("errCode", r7);
            r2.put("server", r8);
            r2.put("server", r8);
            int r3 = RealNameFullMonitor.a;
            JSONObject r4 = new JSONObject();
            if (r0 == null) goto L5;
            r4.put("imageType", r0.g);
            r4.put("compress", r0.h);
            r4.put("scene", r0.b);
            r4.put("mode", r0.d);
        L5:
            RealNameFullMonitor.e("ttlive_cert_ziyan_ocr", r7, r1, RealNameFullMonitor.a(r4, r2));
            ((v80.e) this.a).i.onDetectOCRFinish(r7, r8, r9, r11);
        }
    }

    public a() {
    }

    @Override // x80.a
    public final void a(h r11) {
        if ((r11 instanceof v80.e) == true) goto L5;
        return;
    L5:
        v80.e r0 = (v80.e) r11;
        IHostOCRApiProxy.OCRProxyCallback r1 = r0.i;
        if (r1 != null) goto L8;
        return;
    L8:
        IHostOCRApiProxy r3 = k.f(IHostOCRApiProxy.class);
        IUserService r2 = k.f(IUserService.class);
        IHostContext r4 = k.f(IHostContext.class);
        if (r3 == null) goto L15;
        if (r2 == null) goto L15;
        if (r4 == null) goto L15;
        HashMap r7 = new HashMap();
        r7.put("scene", r0.b);
        r7.put("mode", r0.d);
        r7.put("ticket", r0.c);
        r3.doOCRDetect(r0.getContext(), r0.g, r0.h, r7, new C0299a(r11));
        return;
    L15:
        Intrinsics.checkNotNull(r1);
        r1.onDetectOCRFinish(-10000, -10000, "error_ocr_system", null);
    }
}
