package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final IncompatibleTag a;
    public final xh0.h b;
    public final HashMap<Integer, String> c;

    public final String c() {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<Integer, String>> r1 = this.c.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<Integer, String> r2 = r1.next();
        r0.append("[key: " + r2.getKey().intValue() + " toast: " + r2.getValue() + "], ");
        goto L4
    L7:
        return r0.toString();
    }

    public final void a(Pair<Integer, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "newRule");
        if (this.c.containsKey(r3.getFirst()) == true) goto L6;
        HashMap<Integer, String> r0 = this.c;
        Object r1 = r3.getFirst();
        r0.put((Integer) r1, (String) r3.getSecond());
        return;
    }

    public final xh0.g b(List<Integer> r10, Map<Integer, ? extends xh0.b> r11) {
        Intrinsics.checkNotNullParameter(r10, "currentRuleKeys");
        Intrinsics.checkNotNullParameter(r11, "loadedPlayModes");
        Iterator<Integer> r0 = r10.iterator();
    L4:
        if (r0.hasNext() == false) goto L34;
        int r5 = r0.next().intValue();
        if (this.c.containsKey(Integer.valueOf(r5)) == false) goto L4;
        String r12 = this.c.get(Integer.valueOf(r5));
        if (r12 != null) goto L10;
    L13:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L18;
        String r14 = this.c.get(Integer.valueOf(r5));
    L27:
        IncompatibleTag r4 = this.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.a);
        r1.append('_');
        r1.append(r5);
        String r7 = r1.toString();
        if (r14 != null) goto L30;
        String r8 = "";
    L32:
        return new xh0.g(r4, r5, false, r7, r8);
    L30:
        r8 = r14;
        goto L32
    L18:
        if (b.a[this.a.ordinal()] == 1) goto L20;
        r14 = "";
        goto L27
    L20:
        xh0.b r15 = (xh0.b) ((ConcurrentHashMap) r11).get(Integer.valueOf(r5));
        if (r15 == null) goto L25;
        xh0.h r16 = r15.getPlayModeInfo();
        if (r16 == null) goto L25;
        String r17 = r16.b;
    L26:
        r14 = s1.C(2131921603, new Object[]{r17, this.b.b});
    L25:
        r17 = null;
        goto L26
    L10:
        if (r12.length() == 0) goto L13;
        r13 = false;
        goto L15
    L34:
        if (r10.size() != 1) goto L38;
        Integer r18 = (Integer) CollectionsKt.firstOrNull(r10);
        if (r18 == null) goto L38;
        int r2 = r18.intValue();
    L40:
        return new xh0.g(this.a, r2, true, null, 24);
    L38:
        r2 = -1;
        goto L40
    }

    public c(IncompatibleTag r2, xh0.h r3, HashMap<Integer, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "incompatibleTag");
        Intrinsics.checkNotNullParameter(r3, "playModeInfo");
        Intrinsics.checkNotNullParameter(r4, "incompatibleRules");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
