package com.obric.assistant.chat.component.bottom.core.mention;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ ObricMentionInputController a;

    public /* synthetic */ d(ObricMentionInputController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricMentionInputController r0 = this.a;
        if (r0.k == false) goto L13;
        ICoreInputAbility r1 = r0.f;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L14;
        r0.f();
        return;
    L14:
        return;
    L7:
        if (r1.Rp() != 2) goto L9;
        r2 = true;
        goto L10
    }
}
