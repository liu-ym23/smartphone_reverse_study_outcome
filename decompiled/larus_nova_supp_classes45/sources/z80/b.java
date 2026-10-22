package z80;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import gu2.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import v80.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements x80.a {

    public static final class a {
    }

    /* JADX INFO: renamed from: z80.b$b, reason: collision with other inner class name */
    public static final class C0300b implements ILiveFaceCertCallback {
        public final /* synthetic */ v80.c a;

        public C0300b(v80.c r1) {
            this.a = r1;
        }

        public final void onVerifyResult(LiveCertResult r3) {
            if (r3 == null) goto L7;
            StringBuilder r0 = new StringBuilder("errorCode=");
            r0.append(r3.getErrorCode());
            r0.append(", errorMsg=");
            r0.append(r3.getErrorMsg());
            r0.append(", ext_data=");
            JSONObject r1 = r3.getExtraData();
            if (r1 != null) goto L6;
            r1 = new JSONObject();
        L6:
            r0.append(r1);
            ALogger.i("SaaSByteCertFaceNewStrategy", r0.toString());
        L7:
            ILiveFaceCertCallback r2 = this.a.b;
            if (r2 == null) goto L11;
            r2.onVerifyResult(r3);
            return;
        }
    }

    public static final class c implements com.bytedance.android.live.core.verify.utils.a.g {
        public final /* synthetic */ v80.c a;

        public c(v80.c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.verify.utils.a.g
        public final void onVerify(boolean r8, Map<String, ? extends Object> r9) {
            LiveCertStatus r1 = new LiveCertStatus(r8 ? 1 : 0, 0, 0);
            Object r2 = null;
            if (r9 == null) goto L5;
            Object r3 = r9.get("errorCode");
        L7:
            if ((r3 instanceof Integer) == true) goto L9;
            r3 = null;
        L9:
            Integer r4 = (Integer) r3;
            if (r4 == null) goto L12;
            int r11 = r4.intValue();
        L15:
            if (r9 == null) goto L17;
            Object r0 = r9.get("errorMsg");
        L19:
            if ((r0 instanceof String) == true) goto L21;
            r0 = null;
        L21:
            String r5 = (String) r0;
            if (r9 == null) goto L24;
            Object r6 = r9.get("ticket");
        L26:
            if ((r6 instanceof String) == true) goto L28;
            r6 = null;
        L28:
            String r7 = (String) r6;
            if (r9 == null) goto L31;
            Object r12 = r9.get("ext_data");
        L33:
            if ((r12 instanceof JSONObject) == false) goto L36;
            r2 = r12;
        L36:
            LiveCertResult r13 = new LiveCertResult(r1, r11, r5, r7, (JSONObject) r2);
            ILiveFaceCertCallback r14 = this.a.b;
            if (r14 == null) goto L40;
            r14.onVerifyResult(r13);
            return;
        L40:
            return;
        L31:
            r12 = null;
            goto L33
        L24:
            r6 = null;
            goto L26
        L17:
            r0 = null;
            goto L19
        L12:
            if (r8 == false) goto L14;
            r11 = 0;
            goto L15
        L14:
            r11 = -1;
            goto L15
        L5:
            r3 = null;
            goto L7
        }
    }

    static {
    }

    public b() {
    }

    @Override // x80.a
    public final void a(h r9) {
        Context r1 = null;
        if ((r9 instanceof v80.c) == true) goto L5;
        r9 = null;
    L5:
        v80.c r11 = (v80.c) r9;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.d == false) goto L18;
        v80.d.a r0 = new v80.d.a();
        r0.a = r11.getContext();
        String r2 = r11.e.get("ticket");
        String r4 = "";
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        r0.c = r2;
        String r3 = r11.e.get("scene");
        if (r3 == null) goto L17;
        r4 = r3;
    L17:
        r0.b = r4;
        r0.e = r11.c.get("identity_code");
        r0.f = r11.c.get("identity_name");
        r0.d = r11.e.get("mode");
        r0.l = "true";
        r0.m = r11.e.get("flow");
        r0.k = new c(r11);
        v80.d r12 = new v80.d(r0);
        g r5 = g.a;
        g.a(r12);
        return;
    L18:
        HashMap r6 = new HashMap();
        String r7 = r11.e.get("scene");
        if (r7 == null) goto L21;
        r6.put("scene", r7);
    L21:
        String r8 = r11.e.get("mode");
        if (r8 == null) goto L24;
        r6.put("mode", r8);
    L24:
        String r13 = r11.e.get("ticket");
        if (r13 == null) goto L27;
        r6.put("ticket", r13);
    L27:
        r6.put("cert_app_id", "1128");
        r6.put("use_new_api", "true");
        String r14 = r11.e.get("flow");
        if (r14 == null) goto L30;
        r6.put("flow", r14);
    L30:
        Context r15 = r11.getContext();
        if ((r15 instanceof Activity) == false) goto L34;
        r1 = r15;
    L34:
        Activity r16 = (Activity) r1;
        if (r16 != null) goto L37;
        return;
    L37:
        g.a.c(r16, r6, new C0300b(r11));
    }
}
