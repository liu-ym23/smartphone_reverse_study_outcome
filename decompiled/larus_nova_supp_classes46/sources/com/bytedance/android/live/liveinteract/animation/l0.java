package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0 {
    public static final List<HSImageView> a = null;

    static {
        a = new ArrayList();
    }

    public static HSImageView a() {
        List<HSImageView> r0 = a;
        if (((ArrayList) r0).size() != 0) goto L7;
        return null;
    L7:
        return (HSImageView) ListProtector.remove(r0, 0);
    }

    public static boolean b() {
        if (((ArrayList) a).size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void c(HSImageView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ArrayList r0 = (ArrayList) a;
        if (r0.size() >= 8) goto L6;
        r0.add(r3);
        return;
    }
}
