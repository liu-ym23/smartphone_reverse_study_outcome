package com.larus.uaigc.chat.creationsend;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ ICoreInputAbility a;

    public /* synthetic */ a(ICoreInputAbility r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ICoreInputAbility r0 = this.a;
        int r1 = CreationSendUiEventComponent.j;
        ICoreInputAbility.b.d(r0, "", false, false, null, null, false, 62);
    }
}
