package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.live.core.utils.TimeUtils;
import j40.f4;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n {
    public static final List<Integer> a = null;
    public static final List<Integer> b = null;

    static {
        a = new ArrayList();
        b = new ArrayList();
    }

    public static boolean a(com.bytedance.android.live.base.model.n r9) {
        if (r9 == null) goto L44;
        com.bytedance.android.live.base.model.q r1 = r9.shortTouchInfo;
        if (r1 == null) goto L44;
        if (r1.a == true) goto L10;
        return false;
    L10:
        int r3 = 1;
        if (r1.showAnimation == 1) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r1.imageUrl) == false) goto L16;
        return false;
    L16:
        int r2 = r9.type;
        com.bytedance.android.live.base.model.q r4 = r9.shortTouchInfo;
        int r5 = r4.animationType;
        if (r5 != 1) goto L19;
        return true;
    L19:
        if (r5 == 2) goto L42;
        if (r5 == 3) goto L40;
        if (r5 != 4) goto L25;
        Map r10 = (Map) f4.n.getValue();
        if (r10.containsKey(String.valueOf(r2)) == true) goto L37;
        return true;
    L37:
        return !TextUtils.equals((String) r10.get(String.valueOf(r2)), new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()));
    L25:
        if (r5 == 5) goto L27;
        return false;
    L27:
        long r6 = r9.timeStamp;
        int r11 = r4.animationShowTimes;
        int r7 = q.a;
        com.bytedance.android.livesdk.sharedpref.e r8 = f4.o;
        Pair r12 = (Pair) ((SparseArray) r8.getValue()).get(r2);
        if (r12 != null) goto L30;
    L32:
        ((SparseArray) r8.getValue()).put(r2, new Pair(Long.valueOf(r6), Integer.valueOf(r3)));
        return false;
    L30:
        if (TimeUtils.isToday(((Number) r12.getFirst()).longValue(), r6) == false) goto L32;
        r3 = 1 + ((Number) r12.getSecond()).intValue();
        goto L32
    L40:
        return !((ArrayList) a).contains(Integer.valueOf(r2));
    L42:
        return !((ArrayList) b).contains(Integer.valueOf(r2));
    L44:
        return false;
    }
}
