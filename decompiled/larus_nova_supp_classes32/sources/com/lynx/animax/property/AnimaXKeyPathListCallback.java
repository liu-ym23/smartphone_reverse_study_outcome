package com.lynx.animax.property;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface AnimaXKeyPathListCallback {

    /* JADX INFO: renamed from: com.lynx.animax.property.AnimaXKeyPathListCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onKeyPathListCallback(AnimaXKeyPathListCallback r4, JavaOnlyArray r5) {
            if (r5 == null) goto L11;
            ArrayList r0 = new ArrayList();
            ArrayList<Object> r6 = r5.asArrayList();
            int r1 = 0;
        L5:
            if (r1 >= r6.size()) goto L10;
            if ((ListProtector.get(r6, r1) instanceof JavaOnlyArray) == false) goto L9;
            r0.add(new AnimaXKeyPath((JavaOnlyArray) ListProtector.get(r6, r1)));
        L9:
            r1 = r1 + 1;
            goto L5
        L10:
            r4.onCallback(r0);
            return;
        L11:
            r4.onCallback(new ArrayList());
        }
    }

    void onCallback(List<AnimaXKeyPath> r1);

    void onKeyPathListCallback(JavaOnlyArray r1);
}
