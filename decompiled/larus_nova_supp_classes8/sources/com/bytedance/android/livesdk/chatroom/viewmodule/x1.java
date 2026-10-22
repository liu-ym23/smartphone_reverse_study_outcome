package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livesdk.chatroom.ui.c9;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x1<T> implements Consumer {
    public final /* synthetic */ LiveEndRemindWidget a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ int c;

    public x1(LiveEndRemindWidget r1, Ref.ObjectRef r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        c9 r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.h.setText(((String) this.b.element) + '(' + ((((long) this.c) - r8.longValue()) - 1) + "s)");
        return;
    }
}
