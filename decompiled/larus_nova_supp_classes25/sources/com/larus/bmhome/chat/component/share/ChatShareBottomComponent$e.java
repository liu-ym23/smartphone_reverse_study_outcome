package com.larus.bmhome.chat.component.share;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import de8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatShareBottomComponent$e implements MessageShareViewModel.b {
    public final /* synthetic */ ChatShareBottomComponent a;

    @Override // com.larus.bmhome.chat.model.MessageShareViewModel.b
    public final Fragment f() {
        return s1a.a.c(this.a);
    }

    @Override // com.larus.bmhome.chat.model.MessageShareViewModel.b
    public final c g() {
        ChatShareBottomComponent r0 = this.a;
        int r1 = ChatShareBottomComponent.R;
        return r0.f1();
    }

    public ChatShareBottomComponent$e(ChatShareBottomComponent r1) {
        this.a = r1;
    }
}
