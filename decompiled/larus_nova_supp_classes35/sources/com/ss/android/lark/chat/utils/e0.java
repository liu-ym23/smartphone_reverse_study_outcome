package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final List<ReactionInfo> a(List<? extends Reaction> r7, Map<String, ? extends Chatter> r8) {
        ArrayList r0 = new ArrayList();
        if (r7 == null) goto L17;
        Iterator<T> r9 = r7.iterator();
    L6:
        if (r9.hasNext() == false) goto L17;
        Reaction r1 = (Reaction) r9.next();
        List<String> r2 = r1.getChatterIds();
        HashMap r3 = new HashMap();
        Intrinsics.checkNotNull(r2);
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L16;
        String r5 = (String) r4.next();
        if (r8 == null) goto L13;
        Chatter r6 = r8.get(r5);
    L14:
        if (r6 == null) goto L9;
        r3.put(r5, new ChatChatter(r6));
        goto L9
    L13:
        r6 = null;
        goto L14
    L16:
        r0.add(new ReactionInfo(r1, r3));
    L17:
        return r0;
    }
}
