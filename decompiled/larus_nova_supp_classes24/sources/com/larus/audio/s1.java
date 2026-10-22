package com.larus.audio;

import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.structures.SAMICoreConnectPoolContextParameter;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class s1 implements Runnable {
    public /* synthetic */ s1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (u1.d == false) goto L13;
        f r0 = f.a;
        boolean r1 = f.b();
        u1 r2 = u1.a;
        if (r1 == false) goto L10;
        Iterator r3 = u1.e().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        String r4 = (String) r3.next();
        SAMICoreConnectPoolContextParameter r5 = new SAMICoreConnectPoolContextParameter();
        r5.business = r4;
        SAMICore.RemoveConnectPoolClient(r5);
    L10:
        u1.d = false;
        u1.e().clear();
        f r6 = f.a;
        f.a().clear();
        return;
    }
}
