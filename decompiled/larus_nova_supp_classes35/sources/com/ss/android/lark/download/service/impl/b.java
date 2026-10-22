package com.ss.android.lark.download.service.impl;

import com.ss.android.lark.download.service.FileDownloadState;
import com.ss.android.lark.download.service.NetworkType;
import com.ss.android.lark.http.netstate.NetworkUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.ss.android.lark.http.netstate.a {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void a(NetworkUtils.NetworkType r10) {
        switch(a.b.a[r10.ordinal()]) {
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L41;
        };
    L5:
        a r11 = this.a;
        r11.g = NetworkType.CELLULAR_DATA_NETWORK;
        if (a.a(r11) == false) goto L41;
        Iterator r12 = ((HashMap) this.a.a).values().iterator();
        boolean r0 = false;
        boolean r1 = false;
    L10:
        if (r12.hasNext() == false) goto L17;
        wbb.a r2 = (wbb.a) r12.next();
        if (r2.b != FileDownloadState.DOWNLOADING) goto L10;
        r0 = true;
        if ((0 - ((((long) r2.a) * 0) / 100)) <= 104857600) goto L10;
        this.a.getClass();
        r2.b = FileDownloadState.DOWNLOAD_CANCEL;
        r1 = true;
        goto L10
    L17:
        Set<wbb.b> r13 = this.a.c;
        if (r13 == null) goto L41;
        if (r13.size() == 0) goto L41;
        Iterator<wbb.b> r14 = this.a.c.iterator();
    L24:
        if (r14.hasNext() == false) goto L41;
        wbb.b r3 = r14.next();
        if (r1 == true) goto L27;
        if (r0 == false) goto L24;
        r3.c();
        goto L24
    L27:
        r3.a();
        goto L24
    L30:
        a r15 = this.a;
        r15.g = NetworkType.WIFI;
        goto L41
    L31:
        a r16 = this.a;
        r16.g = NetworkType.NO_INTERNET_CONNECTION;
        Set<wbb.b> r17 = r16.c;
        if (r17 == null) goto L41;
        if (r17.size() <= 0) goto L41;
        if (a.a(this.a) == false) goto L41;
        Iterator<wbb.b> r18 = this.a.c.iterator();
    L39:
        if (r18.hasNext() == false) goto L41;
        r18.next().b();
    L41:
        Iterator<wbb.c> r19 = this.a.e.iterator();
    L43:
        if (r19.hasNext() == false) goto L45;
        wbb.c r4 = r19.next();
        this.a.g.getNumber();
        r4.a();
        goto L43
    }
}
