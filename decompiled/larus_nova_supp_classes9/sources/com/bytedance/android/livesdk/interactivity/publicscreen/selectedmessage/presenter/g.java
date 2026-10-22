package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.api.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements s {
    public final /* synthetic */ SelectedMsgViewManager a;

    public g(SelectedMsgViewManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.s
    public final void a(int r6) {
        SelectedMsgViewManager r0 = this.a;
        if (r0.e == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r0.c == true) goto L13;
        if (r1 == true) goto L13;
        return;
    L13:
        if (SelectedMsgABHelper.g(r0.i, Integer.valueOf(r6)) == false) goto L15;
        this.a.d().e(true, null, r1);
        return;
    L15:
        SelectedMsgViewManager r7 = this.a;
        if (r7.c == true) goto L18;
        return;
    L18:
        r7.d().e(false, s1.B(2131922406), false);
        return;
    L5:
        if (r0.c == true) goto L7;
        r1 = true;
        goto L9
    }
}
