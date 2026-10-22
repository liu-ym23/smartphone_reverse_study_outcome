package com.larus.bmhome.chat;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.databinding.LarusPageChatBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u0 implements va8.m {
    public final /* synthetic */ ChatFragment a;

    @Override // va8.m
    public final va8.l iX() {
        LarusPageChatBinding r0 = this.a.u;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new com.larus.bmhome.view.l(r0);
    }

    @Override // va8.m
    public final Fragment getChatFragment() {
        return this.a;
    }

    public u0(ChatFragment r1) {
        this.a = r1;
    }
}
