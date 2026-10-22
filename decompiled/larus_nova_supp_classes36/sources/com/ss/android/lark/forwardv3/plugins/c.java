package com.ss.android.lark.forwardv3.plugins;

import com.ss.android.lark.picker.config.OnPickerFinishListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements OnPickerFinishListener {
    public final /* synthetic */ ForwardCreateGroupChatFragment a;

    public final void onFinished() {
        this.a.h.onBack();
    }

    public c(ForwardCreateGroupChatFragment r1) {
        this.a = r1;
    }
}
