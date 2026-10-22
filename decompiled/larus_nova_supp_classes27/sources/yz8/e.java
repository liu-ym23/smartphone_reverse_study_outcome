package yz8;

import android.app.Application;
import com.bytedance.sdk.account.platform.OnekeyLoginAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.larus.account.base.impl.p;
import com.larus.account.base.model.LoginPlatform;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e extends OnekeyLoginAdapter {
    public final /* synthetic */ n38.h a;
    public final /* synthetic */ String b;

    public final void onLoginError(AuthorizeErrorResponse r15) {
        Intrinsics.checkNotNullParameter(r15, "response");
        if ((r15 instanceof OnekeyLoginErrorResponse) == false) goto L24;
        String r0 = r15.platformErrorCode;
        Map r3 = null;
        if (r0 == null) goto L9;
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L9;
    L17:
        int r6 = r1.intValue();
    L19:
        n38.h r4 = this.a;
        LoginPlatform r5 = LoginPlatform.PHONE;
        String r7 = r15.platformErrorMsg;
        String r8 = this.b;
        OnekeyLoginErrorResponse r16 = (OnekeyLoginErrorResponse) r15;
        Integer r10 = Integer.valueOf(r16.mDetailErrorCode);
        String r11 = r16.mDetailErrorMsg;
        JSONObject r17 = r16.rawResult;
        if (r17 == null) goto L22;
        r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("raw_data", r17.toString())});
    L22:
        n38.h.a.a(r4, r5, r6, r7, r8, null, r10, r11, r3, 32);
        return;
    L9:
        r1 = Integer.valueOf(((OnekeyLoginErrorResponse) r15).error);
        if (r1.intValue() == 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == true) goto L16;
        r1 = null;
    L16:
        if (r1 != null) goto L17;
        r6 = -2;
        goto L19
    L12:
        r9 = false;
        goto L13
    }

    public final void onLoginSuccess(xa7.g r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        this.a.b(LoginPlatform.PHONE, this.b, Boolean.valueOf(((sc7.a) r4.v).g));
    }

    public e(p r1, Application r2) {
        this.a = r1;
        this.b = "phone_one_key";
        super(r2);
    }
}
