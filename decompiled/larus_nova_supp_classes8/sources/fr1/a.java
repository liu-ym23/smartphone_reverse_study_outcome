package fr1;

import android.content.Context;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import com.ss.android.videoshop.context.VideoContext;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;
import mq1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r6, int r7) {
        o r0 = s.d();
        if (r0 == null) goto L13;
        if (r6 == 0) goto L10;
        int r1 = 1;
        if (r6 != 1) goto L8;
    L11:
        o.a.a(r0, r1, r6, r7, null, 24);
        return;
    L8:
        if (r6 != 8) goto L11;
    L10:
        r1 = 2;
        goto L11
    }

    public static void b(boolean r1, Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        VideoContext r4 = VideoContext.n0(r2);
        if (r4.c != null) goto L5;
        return;
    L5:
        if (r1 == true) goto L7;
    L11:
        boolean r5 = false;
    L12:
        d0 r0 = ReplayRoomFragmentScopeUtil.b();
        if (r0 == null) goto L15;
        r0.f(r5);
    L15:
        if (r5 == false) goto L18;
        if (r3 == true) goto L18;
        r4.k0();
        return;
    L18:
        r4.l0();
        return;
    L7:
        if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == true) goto L9;
    L10:
        r5 = true;
        goto L12
    L9:
        if (FoldScreenUtils.e() == true) goto L11;
        goto L10
    }
}
