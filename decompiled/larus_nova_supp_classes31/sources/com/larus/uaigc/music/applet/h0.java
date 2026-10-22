package com.larus.uaigc.music.applet;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class h0 implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ MusicTemplateAppletFragment b;

    public /* synthetic */ h0(boolean r1, MusicTemplateAppletFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = this.a;
        MusicTemplateAppletFragment r1 = this.b;
        int r2 = MusicTemplateAppletFragment.m;
        if (r0 == true) goto L10;
        va8.o r3 = s1a.a.g(r1).getAbility(va8.o.class);
        if (r3 == null) goto L8;
        String r4 = r3.u7();
    L9:
        if (r4 == null) goto L10;
    L11:
        String r5 = r4;
        ICoreInputAbility r6 = s1a.a.g(r1).getAbility(ICoreInputAbility.class);
        if (r6 == null) goto L15;
        r6.g2(1, true);
        ICoreInputAbility.b.d(r6, r5, true, true, null, null, false, 56);
        return;
    L15:
        return;
    L8:
        r4 = null;
    L10:
        r4 = "";
        goto L11
    }
}
