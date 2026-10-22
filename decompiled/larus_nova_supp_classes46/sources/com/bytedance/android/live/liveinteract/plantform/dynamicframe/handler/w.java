package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ v a;

    public w(v r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        List r6 = (List) r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L3:
        ArrayList r2 = null;
        String r3 = null;
        r3 = null;
        r3 = null;
        r2 = null;
        r2 = null;
        if (r7.hasNext() == false) goto L13;
        ch0.e r1 = (ch0.e) r7.next();
        if (r1 == null) goto L12;
        ILinkPlayerInfoBridge r4 = r1.a;
        if (r4 == null) goto L12;
        IBaseUser r8 = r4.getUser();
        if (r8 == null) goto L12;
        r3 = r8.getIdString();
    L12:
        r0.add(r3);
        goto L3
    L13:
        HashMap<String, tf0.d> r9 = this.a.e;
        if (r9 == null) goto L25;
        Set<String> r10 = r9.keySet();
        if (r10 == null) goto L25;
        Iterator<T> r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L25;
        String r12 = (String) r11.next();
        if (r0.contains(r12) == true) goto L19;
        if (r2 != null) goto L24;
        r2 = new ArrayList();
    L24:
        r2.add(r12);
    L25:
        if (r2 == null) goto L32;
        Iterator<T> r13 = r2.iterator();
    L28:
        if (r13.hasNext() == false) goto L48;
        String r14 = (String) r13.next();
        ALogger.e(this.a.d, "移除数据" + r14);
        HashMap<String, tf0.d> r15 = this.a.e;
        if (r15 == null) goto L28;
        tf0.d r16 = r15.remove(r14);
        goto L28
    L48:
        return;
    }
}
