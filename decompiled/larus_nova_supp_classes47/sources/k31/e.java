package k31;

import android.content.res.Configuration;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements kc0.p {
    public e() {
    }

    public final DeviceType getDeviceType() {
        Configuration r0 = s1.getResources().getConfiguration();
        boolean r1 = s1.F();
        if (PadConfigUtils.c() == false) goto L9;
        if (r1 == false) goto L7;
        return DeviceType.PAD_V;
    L7:
        return DeviceType.PAD_H;
    L9:
        if (FoldScreenUtils.f() == false) goto L21;
        if (FoldScreenUtils.b(s1.getContext(), r0) == 0) goto L13;
        int r2 = RangesKt.coerceAtMost(s1.y(), s1.w());
        int r3 = RangesKt.coerceAtLeast(s1.y(), s1.w());
        if (r3 == 0) goto L21;
        if ((r2 / r3) <= 0.75d) goto L21;
        return DeviceType.FOLD_FULL;
    L13:
        return DeviceType.FOLD_FULL;
    L21:
        return DeviceType.NORMAL_MOBILE;
    }

    public final boolean a(boolean r7, boolean r8, boolean r9) {
        if (r9 == false) goto L5;
        int r1 = StatusBarUtil.getDesiredTopSpaceHeight();
    L7:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L23;
        com.bytedance.android.live.revlink.impl.settings.live.a r2 = com.bytedance.android.live.revlink.impl.settings.live.a.j;
        r2.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.a.c.getValue(r2, com.bytedance.android.live.revlink.impl.settings.live.a.a[1])).booleanValue() == false) goto L15;
        if (r9 == false) goto L15;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == true) goto L15;
        return false;
    L15:
        if (r8 == false) goto L25;
        if (r7 == false) goto L26;
        if (r1 != 0) goto L22;
        return true;
    L22:
        return false;
    L26:
        return false;
    L25:
        return false;
    L23:
        return false;
    L5:
        r1 = 0;
        goto L7
    }
}
