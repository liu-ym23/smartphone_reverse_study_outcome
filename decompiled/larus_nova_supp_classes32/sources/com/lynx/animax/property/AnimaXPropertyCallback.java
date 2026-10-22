package com.lynx.animax.property;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface AnimaXPropertyCallback {

    /* JADX INFO: renamed from: com.lynx.animax.property.AnimaXPropertyCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onPropertyCallback(AnimaXPropertyCallback r4, JavaOnlyArray r5) {
            if (r5 != null) goto L4;
        L15:
            r4.onSuccess();
            return;
        L4:
            if (r5.isEmpty() == true) goto L15;
            ArrayList r0 = new ArrayList();
            ArrayList<Object> r6 = r5.asArrayList();
            int r1 = 0;
        L8:
            if (r1 >= r6.size()) goto L13;
            Object r2 = ListProtector.get(r6, r1);
            if ((r2 instanceof String) == false) goto L12;
            r0.add((String) r2);
        L12:
            r1 = r1 + 1;
            goto L8
        L13:
            r4.a(r0);
        }
    }

    void a(List<String> r1);

    void onPropertyCallback(JavaOnlyArray r1);

    void onSuccess();
}
