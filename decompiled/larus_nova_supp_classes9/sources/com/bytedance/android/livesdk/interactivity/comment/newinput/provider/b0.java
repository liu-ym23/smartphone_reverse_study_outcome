package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ FrequentCommentSectionProvider.FrequentChatController a;

    public b0(FrequentCommentSectionProvider.FrequentChatController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        FrequentCommentSectionProvider.FrequentChatController.g(this.a, FrequentChatShowMode.EDIT);
    }
}
