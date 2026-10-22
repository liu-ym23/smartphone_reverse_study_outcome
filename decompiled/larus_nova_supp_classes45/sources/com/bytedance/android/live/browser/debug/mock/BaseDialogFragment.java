package com.bytedance.android.live.browser.debug.mock;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.utils.t6;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/BaseDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseDialogFragment extends LiveDialogFragment {
    public BaseDialogFragment() {
        setNoTitleAndCancelOutside(true);
    }

    public final void onActivityCreated(Bundle r5) {
        Dialog r0 = getDialog();
        super.onActivityCreated(r5);
        if (r0 == null) goto L5;
        Window r6 = r0.getWindow();
    L6:
        if (r6 == null) goto L12;
        int r1 = t6.c(getContext());
        int r2 = t6.b(getContext());
        r6.setBackgroundDrawable(new ColorDrawable(0));
        r6.setGravity(8388629);
        r6.setLayout(r1, r2);
        WindowManager.LayoutParams r3 = r6.getAttributes();
        if (getContext() == null) goto L10;
        r3.horizontalMargin = t6.a(getContext(), 8.0f) / t6.b(getContext());
    L10:
        r6.setAttributes(r3);
        r6.setFlags(RomUtils.SZ, RomUtils.SZ);
        WindowManager.LayoutParams r4 = r6.getAttributes();
        r4.dimAmount = 0.0f;
        r6.setAttributes(r4);
        return;
    L12:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
