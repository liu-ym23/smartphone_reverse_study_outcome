package oo1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        float r0 = r.o().a();
        if (r0 > 0) goto L5;
    L6:
        return true;
    L5:
        if (r0 >= ((Number) VSSettingKeys.LIVE_VS_INSIDE_RECORD_PERFORMANCE_LIMIT.getValue()).floatValue()) goto L6;
        return false;
    }

    static {
    }
}
