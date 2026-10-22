package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o {
    static {
    }

    @JvmStatic
    public static final ItemConfig a(ItemIdentity r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "identity");
        if (r5 == false) goto L5;
        List<ItemConfig> r6 = com.bytedance.android.livesdk.config.setting.l.a();
    L6:
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L16;
        Object r0 = r7.next();
        String r1 = ((ItemConfig) r0).getIdentity();
        String r2 = r4.name();
        Locale r3 = Locale.ROOT;
        if (r2 == null) goto L15;
        if (Intrinsics.areEqual(r1, r2.toLowerCase(r3)) == false) goto L8;
    L17:
        ItemConfig r8 = (ItemConfig) r0;
        if (r8 == null) goto L20;
        return r8;
    L20:
        return new ItemConfig();
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L16:
        r0 = null;
        goto L17
    L5:
        r6 = com.bytedance.android.livesdk.config.setting.l.b();
        goto L6
    }
}
