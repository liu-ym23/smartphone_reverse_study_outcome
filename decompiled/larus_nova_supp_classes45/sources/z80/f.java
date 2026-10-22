package z80;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.livesdkapi.LiveSdkApiForSaaS;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.verify.VerifyErrorExtra;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import v80.g;
import v80.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements x80.a {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // x80.a
    public final void a(h r8) {
        if ((r8 instanceof g) == true) goto L5;
        h r0 = null;
    L6:
        g r1 = (g) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        VerifyErrorExtra r2 = (VerifyErrorExtra) GsonProtectorUtils.fromJson(new Gson(), null, VerifyErrorExtra.class);
        if (r2 != null) goto L12;
        return;
    L12:
        Integer r3 = r2.getRealNameVerify();
        if (r3 == null) goto L40;
        int r6 = 0;
        if (m2.a(r3, new Object[]{1, 3}) != true) goto L40;
        f2.c(r1.getActivity().getString(2131894066), 0);
        Context r9 = r1.getActivity();
        if (r9 == null) goto L38;
        Context r11 = (FragmentActivity) r9;
        Uri.Builder r4 = UriProtector.parse((String) LiveConfigSettingKeys.LIVE_REALNAME_VERIFY_URL.getValue()).buildUpon();
        IHostContext r5 = k.f(IHostContext.class);
        if (r5 == null) goto L21;
        r6 = r5.appId();
    L21:
        Uri.Builder r7 = r4.appendQueryParameter("open_app_id", String.valueOf(r6)).appendQueryParameter("third_user_id", String.valueOf(TTLiveSDK.hostService().user().hostUserId()));
        od1.a r12 = k.f(od1.a.class);
        if (r12 == null) goto L25;
        String r13 = r12.getAccessToken();
        if (r13 == null) goto L25;
    L26:
        Uri.Builder r14 = r7.appendQueryParameter("open_cert_token", r13).appendQueryParameter("enter_from", "live_take");
        if (y30.a.b() == null) goto L35;
        Integer r15 = (Integer) LiveConfigSettingKeys.LIVE_HAS_FACE_SDK.getValue();
        if (r15 == null) goto L35;
        if (r15.intValue() != 1) goto L35;
        String r16 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L36:
        ((t60.a) k.n(t60.a.class)).handle(r11, "sslocal://webcast_webview?hide_nav_bar=1&status_bar_color=white&url=" + Uri.encode(r14.appendQueryParameter("has_face_sdk", r16).build().toString()));
        return;
    L35:
        r16 = "0";
    L25:
        r13 = "12345";
        goto L26
    L38:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L40:
        if (Intrinsics.areEqual(r2.getLiveAgreement(), Boolean.FALSE) == false) goto L44;
        LiveSdkApiForSaaS.Companion.getClass();
        LiveSdkApiForSaaS.a.a().openAgreeToStartLiveDialog(r8);
        return;
    L44:
        return;
    L5:
        r0 = r8;
        goto L6
    }
}
