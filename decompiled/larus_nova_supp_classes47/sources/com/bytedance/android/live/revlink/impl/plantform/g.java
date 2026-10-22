package com.bytedance.android.live.revlink.impl.plantform;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static final List<p> a(List<? extends p> r7, List<? extends p> r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$subtractList");
        Intrinsics.checkNotNullParameter(r8, "target");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        IBaseUser r1 = ((p) r9.next()).getUser();
        if (r1 == null) goto L9;
        String r2 = r1.getIdString();
        if (r2 == null) goto L9;
    L10:
        r0.add(r2);
    L9:
        r2 = "";
        goto L10
    L11:
        ArrayList r10 = new ArrayList();
        Iterator<T> r12 = r7.iterator();
    L13:
        if (r12.hasNext() == false) goto L38;
        Object r3 = r12.next();
        p r4 = (p) r3;
        String r5 = null;
        if (r4 == null) goto L19;
        IBaseUser r6 = r4.getUser();
        if (r6 == null) goto L19;
        String r13 = r6.getIdString();
    L20:
        boolean r14 = true;
        if (r13 != null) goto L23;
    L26:
        boolean r15 = true;
    L27:
        if (r15 == true) goto L35;
        if (r4 == null) goto L33;
        IBaseUser r16 = r4.getUser();
        if (r16 == null) goto L33;
        r5 = r16.getIdString();
    L33:
        if (CollectionsKt.contains(r0, r5) == true) goto L35;
    L36:
        if (r14 == false) goto L13;
        r10.add(r3);
    L35:
        r14 = false;
        goto L36
    L23:
        if (r13.length() == 0) goto L26;
        r15 = false;
    L19:
        r13 = null;
        goto L20
    L38:
        return r10;
    }
}
