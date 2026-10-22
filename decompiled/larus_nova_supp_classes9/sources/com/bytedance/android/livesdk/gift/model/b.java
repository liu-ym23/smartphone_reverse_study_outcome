package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final a a(c r7) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        if (r7 == null) goto L22;
        Iterator<T> r2 = r7.getEffectMixImageInfoList().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        s r3 = (s) r2.next();
        r0.add(new q2(r3.getImageKey(), r3.getMixImage()));
        goto L6
    L8:
        List<t> r8 = r7.getEffectMixTextInfoList();
        if (r8 == null) goto L22;
        Iterator<T> r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L22;
        t r4 = (t) r9.next();
        String r5 = r4.getPlaceholderKey();
        String r6 = BuildConfig.FLAVOR;
        if (r5 != null) goto L16;
        r5 = BuildConfig.FLAVOR;
    L16:
        String r10 = r4.getContent();
        if (r10 == null) goto L20;
        r6 = r10;
    L20:
        r1.add(new r3(r5, r6, r4.getFontSize(), r4.getFontColor()));
    L22:
        return new a(r0, r1, null, null);
    }
}
