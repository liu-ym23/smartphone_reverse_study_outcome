package com.bytedance.android.livesdk.chatroom.utils.uhdLogin;

import com.bytedance.android.livesdk.config.y81;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class UhdLoginManager {
    public static final HashMap<Integer, a> a = null;
    public static final Lazy b = null;
    public static final y81 c = null;

    static {
        a = new HashMap();
        b = LazyKt.lazy(UhdLoginManager$uhdLoginTipShowStatistics$2.INSTANCE);
        c = (y81) SettingKeyUtils.a.getValue();
    }
}
