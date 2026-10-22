package com.bytedance.android.live.profit.format.voicechat.fragment;

import com.bytedance.android.live.profit.format.voicechat.model.CloseReason;
import com.bytedance.android.live.profit.format.voicechat.viewmodel.VoiceChatViewModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ FormatVoiceChatFragment a;

    public d(FormatVoiceChatFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        if (((Boolean) r8).booleanValue() == false) goto L6;
        FormatVoiceChatFragment r9 = this.a;
        int r0 = FormatVoiceChatFragment.A;
        VoiceChatViewModel.closeChat$default(r9.W90(), true, CloseReason.USER_CLOSE, null, 4, null);
        return;
    }
}
