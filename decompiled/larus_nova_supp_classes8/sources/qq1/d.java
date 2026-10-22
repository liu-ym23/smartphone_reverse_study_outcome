package qq1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.m;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.q6;
import com.bytedance.android.livesdk.utils.t6;
import i40.h;
import kotlin.jvm.internal.Intrinsics;
import vr1.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends c {
    public int c;
    public int d;

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // vr1.e
    public final e0 b(Context r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        int r8 = View.MeasureSpec.getSize(r7);
        Intrinsics.checkNotNullParameter(r6, "context");
        boolean r1 = true;
        if (m.a() == false) goto L15;
        Object r0 = r6.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r0 == null) goto L56;
        Point r3 = new Point();
        ((WindowManager) r0).getDefaultDisplay().getSize(r3);
        int r2 = r3.y;
        if (r8 > r2) goto L14;
        int r4 = this.a;
        if (r4 != 0) goto L13;
        this.a = r2;
        goto L15
    L13:
        if (r4 == r2) goto L15;
    L14:
        boolean r5 = true;
    L17:
        if (r5 == false) goto L20;
        h.a("on adapter vivo returen");
        return null;
    L20:
        h.a("lastHeight:" + this.b + "  maxHeight:" + this.c + "   height:" + r8);
        if (((Boolean) q6.a.getValue()).booleanValue() == false) goto L27;
        if (PadConfigUtils.a() == false) goto L27;
        if (r8 != 0) goto L27;
        return null;
    L27:
        if (this.b != 0) goto L34;
        this.b = r8;
        if (this.c != 0) goto L31;
        d(r8, r6);
    L31:
        h.a("on last height == 0 return");
        return null;
    L34:
        if (r8 <= this.c) goto L37;
        h.a("on height bigger than last screent height return height : " + r8 + " \t lastscreenheight " + this.c);
        d(r8, r6);
    L37:
        if (this.b != r8) goto L40;
        h.a("on last height equals height return height: " + this.b);
        return null;
    L40:
        int r9 = this.c - r8;
        this.b = r8;
        Float r10 = (Float) VSSettingKeys.LIVE_KEYBOARD_CHECK_THRESHOLD.getValue();
        h.a("offset:" + r9 + " threshold:" + t6.a(r6, r10.floatValue()));
        float r11 = (float) r9;
        if (r11 <= t6.a(r6, r10.floatValue())) goto L43;
        h.a("软键盘显示 diff:" + r9);
    L53:
        int r12 = Math.abs(r9);
        h.a("datas : lastheight " + this.b + ", offset " + r9 + ", isvisible " + r1);
        return new e0(r1, r12);
    L43:
        Configuration r13 = r6.getResources().getConfiguration();
        if (PadConfigUtils.a() == true) goto L46;
    L52:
        h.a("软键盘隐藏,diff:" + r9);
        r1 = false;
        goto L53
    L46:
        if (((Boolean) VSSettingKeys.JUDGE_KEYBOARD_QWERTY.getValue()).booleanValue() == false) goto L52;
        if (r13.keyboard != 2) goto L52;
        if (r11 <= t6.a(r6, 48.0f)) goto L52;
        h.a("软键盘显示，连接外接键盘 diff " + r9);
        goto L53
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    L15:
        r5 = false;
        goto L17
    }

    public final void d(int r3, Context r4) {
        if (s1.getContext() != null) goto L5;
    L13:
        int r5 = Math.min(r3, Math.min(s1.w(), s1.y()));
    L14:
        this.c = r5;
        h.a("set max height: " + r3 + ", after set: " + this.c);
        return;
    L5:
        if (s1.getContext().getResources().getConfiguration().orientation != 1) goto L13;
        if (((Boolean) VSSettingKeys.LIVE_KEYBOARD_STATUS_BAR_HEIGHT_ADAPT.getValue()).booleanValue() == true) goto L9;
        r5 = Math.max(r3, Math.max(s1.w(), s1.y()));
        goto L14
    L9:
        if (this.d != 0) goto L11;
        this.d = StatusBarUtil.getStatusBarHeight(r4);
    L11:
        r5 = Math.max(r3, Math.max(s1.w() - this.d, s1.y()));
        goto L14
    }
}
