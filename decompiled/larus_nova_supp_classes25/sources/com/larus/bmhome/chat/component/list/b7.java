package com.larus.bmhome.chat.component.list;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b7 implements Observer {
    public final /* synthetic */ ChatListComponentViewModel a;

    public /* synthetic */ b7(ChatListComponentViewModel r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ChatListComponentViewModel.Zo(this.a, (wc9.e) r2);
    }
}
