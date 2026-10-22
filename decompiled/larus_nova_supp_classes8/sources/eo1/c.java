package eo1;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.chatroom.ui.framework.base.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends i {
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

    public c() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.base.i
    public final void r(View r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        r1.setFitsSystemWindows(true);
        Fragment r3 = getContext().q;
        if ((r3 instanceof DialogFragment) == true) goto L5;
        r3 = null;
    L5:
        DialogFragment r4 = (DialogFragment) r3;
        if (r4 == null) goto L13;
        Dialog r5 = r4.getDialog();
        if (r5 == null) goto L14;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L15;
        r6.setStatusBarColor(-16777216);
        return;
    L15:
        return;
    L14:
        return;
    }
}
