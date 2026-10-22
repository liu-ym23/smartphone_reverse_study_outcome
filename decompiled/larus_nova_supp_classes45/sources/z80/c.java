package z80;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import gu2.g;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v80.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements x80.a {

    public static final class a implements IHostOCRApiProxy.BytedCertCallback {
        public final /* synthetic */ v80.b.InterfaceC0287b a;

        public a(v80.b.InterfaceC0287b r1) {
            this.a = r1;
        }

        public final void onH5Close(JSONObject r8) {
            int r0 = -1;
            String r1 = null;
            if (r8 == null) goto L5;
            Integer r2 = Integer.valueOf(r8.optInt(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, -1));
        L6:
            if (r8 == null) goto L8;
            JSONObject r3 = r8.optJSONObject("ext_data");
        L9:
            if (r3 == null) goto L11;
            JSONObject r4 = r3.optJSONObject("state");
        L12:
            if (r4 == null) goto L14;
            Integer r5 = Integer.valueOf(r4.optInt("living_detect_state"));
        L16:
            if (r5 != null) goto L19;
        L24:
            if (r8 == null) goto L26;
            r1 = r8.optString(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG);
        L26:
            v80.b.InterfaceC0287b r9 = this.a;
            if (r2 == null) goto L29;
            r0 = r2.intValue();
        L29:
            if (r1 != null) goto L31;
            r1 = "取消";
        L31:
            if (r3 != null) goto L33;
            r3 = new JSONObject();
        L33:
            r9.a(false, r0, r1, r3);
            return;
        L19:
            if (r5.intValue() != 1) goto L24;
            v80.b.InterfaceC0287b r11 = this.a;
            if (r3 != null) goto L23;
            r3 = new JSONObject();
        L23:
            r11.a(true, 0, "成功", r3);
            return;
        L14:
            r5 = null;
            goto L16
        L11:
            r4 = null;
            goto L12
        L8:
            r3 = null;
            goto L9
        L5:
            r2 = null;
            goto L6
        }
    }

    public c() {
    }

    @Override // x80.a
    public final void a(h r11) {
        if ((r11 instanceof v80.b) == true) goto L5;
        return;
    L5:
        v80.b r12 = (v80.b) r11;
        if ((r12.getContext() instanceof Activity) == true) goto L8;
        return;
    L8:
        v80.b.InterfaceC0287b r0 = r12.g;
        if (r0 != null) goto L11;
        return;
    L11:
        boolean r3 = false;
        if (k.f(IHostContext.class) != null) goto L15;
        r0.a(false, -1, null, new JSONObject());
        return;
    L15:
        Context r1 = r12.getContext();
        if (r1 == null) goto L38;
        Activity r2 = (Activity) r1;
        HashMap<String, String> r13 = r12.h;
        a r4 = new a(r0);
        g r5 = g.a;
        if (k.f(IHostRealNameAuthorization.class) == null) goto L20;
        boolean r6 = true;
    L22:
        if (r6 == false) goto L27;
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r13, "certInfo");
        Intrinsics.checkNotNullParameter(r4, "certH5CloseCallback");
        IHostRealNameAuthorization r7 = k.f(IHostRealNameAuthorization.class);
        if (r7 == null) goto L41;
        r7.startBytedCert(r2, r13, g.b(r5), new gu2.h(r2, r4));
        return;
    L41:
        return;
    L27:
        y30.b r8 = y30.a.b();
        if (r8 == null) goto L40;
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r13, "dict");
        Intrinsics.checkNotNullParameter(r4, "certH5CloseCallback");
        if (k.f(IHostRealNameAuthorization.class) == null) goto L32;
        r3 = true;
    L32:
        if (r3 == false) goto L35;
        SafetyGuard.a(null, new Throwable("unexpected_liveauthsdk_code_exec"), "unexpected_liveauthsdk_code_exec");
    L35:
        fu2.a r14 = r8.a;
        y30.b.a(r8);
        r14.b();
        r8.a.c();
        r8.a.d();
        fu2.a r15 = r8.a;
        r15.f();
        r15.a();
        return;
    L40:
        return;
    L20:
        r6 = false;
        goto L22
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
