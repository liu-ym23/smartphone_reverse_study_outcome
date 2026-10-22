package com.ss.android.lark.parser.internal;

import android.util.Pair;
import com.bytedance.lark.pb.basic.v1.PickEntities;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final List<PickEntities> a(Collection<? extends PickChatEntity> r6) {
        Intrinsics.checkNotNullParameter(r6, "sourcePickEntities");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<? extends PickChatEntity> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L29;
        PickChatEntity r1 = r7.next();
        Integer r2 = Integer.valueOf(r1.a);
        if (r2 != null) goto L9;
    L11:
        if (r2 != null) goto L14;
    L16:
        if (r2 != null) goto L19;
    L21:
        PickEntities.PickType r3 = PickEntities.PickType.UNKNOWN;
    L22:
        Pair r4 = (Pair) r0.get(r3);
        if (r4 != null) goto L25;
        PickEntities.Builder r5 = new PickEntities.Builder().pick_type(r3);
        Pair r8 = new Pair(new ArrayList(), r5);
        r0.put(r3, r8);
        r4 = r8;
    L25:
        List r9 = (List) r4.first;
        String r10 = r1.b;
        if (r10 != null) goto L28;
        r10 = "";
    L28:
        r9.add(r10);
        goto L4
    L19:
        if (r2.intValue() != 3) goto L21;
        r3 = PickEntities.PickType.DEPT;
        goto L22
    L14:
        if (r2.intValue() != 1) goto L16;
        r3 = PickEntities.PickType.USER;
        goto L22
    L9:
        if (r2.intValue() != 2) goto L11;
        r3 = PickEntities.PickType.CHAT;
        goto L22
    L29:
        ArrayList r11 = new ArrayList(r0.values().size());
        Iterator r12 = r0.values().iterator();
    L31:
        if (r12.hasNext() == false) goto L33;
        Pair r13 = (Pair) r12.next();
        PickEntities.Builder r14 = (PickEntities.Builder) r13.second;
        r14.pick_ids((List) r13.first);
        r11.add(r14.build());
        goto L31
    L33:
        return r11;
    }
}
