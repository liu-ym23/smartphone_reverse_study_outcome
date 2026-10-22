package g80;

import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    static {
    }

    @JvmStatic
    public static final void requestPermissions(Fragment r3, String[] r4, int r5, Cert r6) throws BPEAException {
        Intrinsics.checkNotNullParameter(r3, "$this$requestPermissions");
        Intrinsics.checkNotNullParameter(r4, "permissions");
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_REQUEST.getValue().booleanValue() == false) goto L5;
        com.bytedance.bpea.entry.common.a.a.getClass();
        com.bytedance.bpea.entry.common.a.a.a(r6, new String[]{"permission"}, "PermissionUtils", "requestPermission");
    L5:
        r3.requestPermissions(r4, r5);
    }
}
