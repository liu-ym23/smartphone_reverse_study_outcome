package qb2;

import com.bytedance.live.richcontent.ResourceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final List<ResourceInfo> a(ak6.g r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$getFailedResourceInfo");
        List r5 = r4.e;
        if (r5 == null) goto L13;
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L20;
        Object r1 = r6.next();
        if (((ResourceInfo) r1).c != ResourceInfo.State.FAILED) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L6;
        r0.add(r1);
        goto L6
    L10:
        r2 = false;
        goto L11
    L20:
        return r0;
    L13:
        return null;
    }

    public static final boolean b(ak6.g r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$hasFailedResource");
        List r7 = r6.e;
        Object r2 = null;
        if (r7 == null) goto L14;
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L13;
        Object r3 = r8.next();
        if (((ResourceInfo) r3).c != ResourceInfo.State.FAILED) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r2 = r3;
        goto L13
    L10:
        r4 = false;
    L13:
        r2 = (ResourceInfo) r2;
    L14:
        if (r2 != null) goto L23;
        return false;
    L23:
        return true;
    }
}
