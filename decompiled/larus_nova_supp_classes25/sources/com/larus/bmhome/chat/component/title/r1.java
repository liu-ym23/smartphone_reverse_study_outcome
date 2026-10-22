package com.larus.bmhome.chat.component.title;

import android.view.View;
import com.larus.bmhome.chat.component.immerse.a;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import nf9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r1 implements e {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ ChatTitleComponent b;
    public final /* synthetic */ com.larus.platform.api.g0 c;
    public final /* synthetic */ wc9.e d;

    public final String a() {
        ChatTitleComponent r0 = this.b;
        int r1 = ChatTitleComponent.P1;
        a r2 = r0.G3();
        ChatImmersFragment r3 = null;
        if (r2 == null) goto L5;
        ChatImmersFragment r4 = r2.Z5();
    L7:
        if ((r4 instanceof ChatImmersFragment) == false) goto L9;
        r3 = r4;
    L9:
        if (r3 == null) goto L14;
        if (this.b.b1 == true) goto L14;
        return "";
    L14:
        return this.d.a;
    L5:
        r4 = null;
        goto L7
    }

    public final void onUpdate(final int r5) {
        if (this.a == false) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        ChatTitleComponent r1 = this.b;
        int r2 = ChatTitleComponent.P1;
        r0.i(r1.d4(), "red badge update: " + r5);
        View r3 = this.b.F2();
        final com.larus.platform.api.g0 r4 = this.c;
        final ChatTitleComponent r6 = this.b;
        SafeExtKt.b(r3, new q1(r4, r5, r6), 0);
    }

    public r1(boolean r1, ChatTitleComponent r2, com.larus.platform.api.g0 r3, wc9.e r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
