package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b4 extends SettingKey<Boolean> {
    public static final b4 a = null;

    static {
        a = new b4();
    }

    public b4() {
        Boolean r1 = Boolean.TRUE;
        super("live_pad_adapt_multi_win", "pad分栏适配", r1, r1);
    }

    @JvmStatic
    public static final boolean a() {
        if (a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (PadConfigUtils.c() == false) goto L7;
        return true;
    }
}
