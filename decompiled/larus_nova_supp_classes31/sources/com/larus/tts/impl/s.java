package com.larus.tts.impl;

import androidx.lifecycle.MutableLiveData;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.e1;
import com.larus.ui.arch.component.internal.attach.a;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s implements com.larus.bmhome.chat.component.cvs.y.a<e> {
    public final /* synthetic */ ChatTitleTtsComponent a;

    public s(ChatTitleTtsComponent r1) {
        this.a = r1;
    }

    public final void c(Object r5) {
        e r6 = (e) r5;
        Intrinsics.checkNotNullParameter(r6, "new");
        ChatTitleTtsComponent r0 = this.a;
        int r1 = ChatTitleTtsComponent.v;
        com.larus.platform.api.g0 r2 = r0.Y2();
        if (r2 == null) goto L5;
        r2.setMainBot(com.larus.bmhome.utils.i.f(r6));
    L5:
        e1 r7 = AudioServiceDelegate.a.L();
        ChatTitleTtsComponent r3 = this.a;
        MutableLiveData r4 = r3.j;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r7.b(r3, r4, a.b(r3, r3), this.a.P2());
    }
}
