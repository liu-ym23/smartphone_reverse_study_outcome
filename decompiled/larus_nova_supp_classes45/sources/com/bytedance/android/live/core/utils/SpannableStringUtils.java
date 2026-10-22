package com.bytedance.android.live.core.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SpannableStringUtils {
    public SpannableStringUtils() {
    }

    public static int getFormatColor(String r1) {
        return Color.parseColor(r1);
    L4:
        e = move-exception;
        Logger.e("I18N_MESSAGE", e.getMessage());
        return s1.h(2131106926);
    }

    public static SpannableString getDiffColorSpannable(String r4, String r5, List<Pair<Integer, Integer>> r6) {
        SpannableString r0 = new SpannableString(r4);
        Iterator<Pair<Integer, Integer>> r7 = r6.iterator();     // Catch: Exception -> L8
    L5:
        if (r7.hasNext() == false) goto L10;
        Pair<Integer, Integer> r8 = r7.next();     // Catch: Exception -> L8
        r0.setSpan(new ForegroundColorSpan(getFormatColor(r5)), ((Integer) r8.first).intValue(), ((Integer) r8.second).intValue(), 33);     // Catch: Exception -> L8
    L10:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static SpannableString getDiffColorSpannable(String r1, int r2, int r3, int r4) {
        SpannableString r0 = new SpannableString(r1);
        r0.setSpan(new ForegroundColorSpan(r4), r2, r3, 33);
        return r0;
    }
}
