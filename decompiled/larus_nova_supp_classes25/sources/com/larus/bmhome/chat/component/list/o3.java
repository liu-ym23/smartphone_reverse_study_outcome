package com.larus.bmhome.chat.component.list;

import androidx.core.view.GestureDetectorCompat;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.platform.service.i3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o3 implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ o3(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ChatListComponent r0 = this.a;
        Unit r4 = (Unit) r3;
        int r5 = ChatListComponent.W3;
        LarusPageChatBinding r6 = r0.h4();
        if (r6 == null) goto L12;
        ChatConstraintLayout r7 = r6.a;
        if (r7 == null) goto L12;
        if (i3.a.a() == false) goto L9;
        GestureDetectorCompat r1 = new GestureDetectorCompat(r7.getContext(), r7);
    L10:
        r7.m = r1;
        goto L12
    L9:
        r1 = null;
    L12:
        return Unit.INSTANCE;
    }
}
