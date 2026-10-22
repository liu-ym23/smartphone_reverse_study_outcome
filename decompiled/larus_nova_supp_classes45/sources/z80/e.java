package z80;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import gu2.g;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements y80.a {

    public static final class a implements ILiveFaceCertCallback {
        public final /* synthetic */ v80.f a;

        public a(v80.f r1) {
            this.a = r1;
        }

        public final void onVerifyResult(LiveCertResult r2) {
            ILiveFaceCertCallback r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.onVerifyResult(r2);
            return;
        }
    }

    public static final class b implements com.bytedance.android.live.core.verify.utils.a.g {
        public final /* synthetic */ v80.f a;

        public b(v80.f r1) {
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

    public e() {
    }

    @Override // y80.a
    public final void a(Context r11, v80.f r12) {
        boolean r1 = true;
        if (r12.d == false) goto L14;
        v80.d.a r0 = new v80.d.a();
        r0.b = r12.c.get("scene");
        r0.d = GamePromoteDataContext.GAME_TYPE_MOBILE;
        r0.c = r12.e;
        r0.a = r11;
        r0.l = "true";
        r0.m = r12.c.get("flow");
        r0.k = new b(r12);
        v80.d r13 = new v80.d(r0);
        g r14 = g.a;
        if (k.f(IHostRealNameAuthorization.class) != null) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        g.a(r13);
        return;
    L10:
        y30.b r15 = y30.a.b();
        if (r15 == null) goto L47;
        r15.b(r13);
        return;
    L47:
        return;
    L14:
        if ((r11 instanceof Activity) == true) goto L16;
        r11 = null;
    L16:
        Activity r16 = (Activity) r11;
        if (r16 != null) goto L19;
        return;
    L19:
        HashMap r2 = new HashMap();
        String r7 = r12.c.get("scene");
        String r8 = "";
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        r2.put("scene", r7);
        r2.put("mode", "0");
        String r4 = r12.e;
        if (r4 != null) goto L25;
        r4 = "";
    L25:
        r2.put("ticket", r4);
        r2.put("cert_app_id", "1128");
        r2.put("use_new_api", "true");
        String r5 = r12.c.get("flow");
        if (r5 == null) goto L29;
        r8 = r5;
    L29:
        r2.put("flow", r8);
        a r3 = new a(r12);
        g r17 = g.a;
        if (k.f(IHostRealNameAuthorization.class) == null) goto L32;
        boolean r6 = true;
    L33:
        if (r6 == false) goto L35;
        r17.c(r16, r2, r3);
        return;
    L35:
        y30.b r18 = y30.a.b();
        if (r18 == null) goto L50;
        Intrinsics.checkNotNullParameter(r16, "activity");
        Intrinsics.checkNotNullParameter(r2, "dict");
        if (k.f(IHostRealNameAuthorization.class) != null) goto L41;
        r1 = false;
    L41:
        if (r1 == false) goto L44;
        SafetyGuard.a(null, new Throwable("unexpected_liveauthsdk_code_exec"), "unexpected_liveauthsdk_code_exec");
    L44:
        fu2.a r19 = r18.a;
        y30.b.a(r18);
        r19.b();
        r18.a.c();
        r18.a.d();
        fu2.a r110 = r18.a;
        r110.f();
        r110.a();
        return;
    L50:
        return;
    L32:
        r6 = false;
        goto L33
    }
}
