package v0b;

import android.util.Base64;
import com.ss.android.lark.chameleonv2.debug.CmlDebugSettingUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(boolean r5) {
        HashMap r0 = new HashMap();
        if (Intrinsics.areEqual(CmlDebugSettingUtil.a("chameleon_app_name", "doubao"), "doubao") == false) goto L17;
        if (r5 == true) goto L17;
        String r6 = CmlDebugSettingUtil.a("chameleon_header_username", BuildConfig.FLAVOR);
        String r1 = CmlDebugSettingUtil.a("chameleon_header_pwd", BuildConfig.FLAVOR);
        boolean r3 = true;
        if (r6.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L17;
        if (r1.length() == 0) goto L14;
        r3 = false;
    L14:
        if (r3 == true) goto L17;
        String r7 = Base64.encodeToString((r6 + ':' + r1).getBytes(Charsets.UTF_8), 2);
        StringBuilder r4 = new StringBuilder("Basic ");
        r4.append(r7);
        r0.put("Authorization", r4.toString());
        goto L17
    L8:
        r2 = false;
    L17:
        return r0;
    }
}
