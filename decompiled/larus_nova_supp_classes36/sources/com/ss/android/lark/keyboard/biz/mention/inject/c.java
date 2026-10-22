package com.ss.android.lark.keyboard.biz.mention.inject;

import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ AtDoubaoTopPlugin a;

    public c(AtDoubaoTopPlugin r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Chat r4 = (Chat) r3;
        AtDoubaoTopPlugin r0 = this.a;
        Intrinsics.checkNotNull(r4);
        r0.getClass();
        boolean r5 = com.ss.android.lark.keyboard.utils.b.a(r4);
        if (Intrinsics.areEqual(this.a.h, Boolean.valueOf(r5)) == true) goto L11;
        Log.i("AtDoubaoTopPlugin", "Doubao top entry visibility changed, visible=" + r5);
        this.a.h = Boolean.valueOf(r5);
        if (r5 == false) goto L8;
        wnb.c r6 = this.a.h();
        this.a.getClass();
        r6.a(AtDoubaoTopPlugin.i);
        return;
    L8:
        this.a.f();
        wnb.c r7 = this.a.h();
        this.a.getClass();
        r7.b(AtDoubaoTopPlugin.i);
        return;
    }
}
