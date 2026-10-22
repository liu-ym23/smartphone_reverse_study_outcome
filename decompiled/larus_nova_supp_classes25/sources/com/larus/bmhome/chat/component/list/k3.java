package com.larus.bmhome.chat.component.list;

import androidx.activity.result.ActivityResultCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k3 implements ActivityResultCallback {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ k3(ChatListComponent r1) {
        this.a = r1;
    }

    public final void onActivityResult(Object r5) {
        ChatListComponent r0 = this.a;
        Boolean r6 = (Boolean) r5;
        int r1 = ChatListComponent.W3;
        ChatListComponentViewModel r2 = r0.U5();
        Intrinsics.checkNotNull(r6);
        r2.onLocationPermission(r6.booleanValue(), new ChatListComponent$onAttach$1$1(r0), new ChatListComponent$onAttach$1$2(r0));
    }
}
