package com.bytedance.android.live.core.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.Item;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y0 {
    public static String b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        r4 = String.valueOf(-1);
    L6:
        if (r4.contains(Item.MIX_ID_SEPERATOR) == false) goto L8;
        return r4;
    L8:
        return TextUtils.concat(new CharSequence[]{r4, Item.MIX_ID_SEPERATOR, String.valueOf(0)}).toString();
    }

    public static boolean a(String r0, String r1) {
        return TextUtils.equals(b(r0), b(r1));
    }
}
