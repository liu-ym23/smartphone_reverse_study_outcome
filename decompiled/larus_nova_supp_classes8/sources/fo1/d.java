package fo1;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends com.bytedance.android.livesdk.chatroom.ui.framework.base.i {
    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void h() {
        Fragment r0 = getContext().q;
        if ((r0 instanceof DialogFragment) == true) goto L5;
        r0 = null;
    L5:
        DialogFragment r1 = (DialogFragment) r0;
        if (r1 == null) goto L9;
        r1.setStyle(1, 2131954674);
        r1.setCancelable(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void n() {
        if (getContext().a == true) goto L5;
        return;
    L5:
        if (PadConfigUtils.c() == false) goto L13;
        FragmentActivity r0 = getContext().q.getActivity();
        if (r0 == null) goto L14;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L15;
        r1.clearFlags(1024);
        return;
    L15:
        return;
    L14:
        return;
    }

    public d() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void g(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        if (getContext().a == true) goto L5;
        return;
    L5:
        if (PadConfigUtils.c() == false) goto L7;
    L8:
        FragmentActivity r3 = getContext().q.getActivity();
        if (r3 == null) goto L16;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L17;
        r4.clearFlags(1024);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (FoldScreenUtils.f() == true) goto L8;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void i(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        if ((!getContext().a) == false) goto L8;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L9;
        r3.addFlags(1024);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void r(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L8;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L8;
        r2.setFitsSystemWindows(false);
        return;
    L8:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L10;
        r2.setFitsSystemWindows(false);
        return;
    L10:
        r2.setFitsSystemWindows(true);
    }
}
