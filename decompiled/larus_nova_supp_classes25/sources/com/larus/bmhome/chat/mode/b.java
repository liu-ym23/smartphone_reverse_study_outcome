package com.larus.bmhome.chat.mode;

import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.auth.ConversationModeConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    static {
    }

    public static ConversationModeConfig a() {
        AuthModelDelegate r0 = AuthModelDelegate.b;
        LaunchInfo r1 = (LaunchInfo) r0.x().getValue();
        if (r1 == null) goto L6;
        ConversationModeConfig r2 = r1.I();
        if (r2 == null) goto L6;
    L14:
        List r3 = r2.b();
        if (r3 != null) goto L17;
        r3 = CollectionsKt.emptyList();
    L17:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L18:
        boolean r6 = true;
        boolean r7 = false;
        if (r5.hasNext() == false) goto L33;
        ConversationMode r8 = (ConversationMode) r5.next();
        if (r8 == null) goto L30;
        String r9 = r8.a();
        if (r9 != null) goto L25;
    L26:
        r7 = true;
    L28:
        if ((true ^ r7) == false) goto L30;
    L31:
        if (r8 == null) goto L18;
        r4.add(r8);
        goto L18
    L25:
        if (r9.length() != 0) goto L28;
    L30:
        r8 = null;
        goto L31
    L33:
        HashSet r10 = new HashSet();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r4.iterator();
    L35:
        if (r12.hasNext() == false) goto L40;
        Object r13 = r12.next();
        if (r10.add(((ConversationMode) r13).a()) == false) goto L35;
        r11.add(r13);
        goto L35
    L40:
        if (Intrinsics.areEqual(r2.e(), Boolean.TRUE) == true) goto L42;
    L44:
        r6 = false;
    L45:
        if (r6 == true) goto L48;
        r2 = null;
    L48:
        if (r2 != null) goto L50;
        return null;
    L50:
        return ConversationModeConfig.a(r2, r11, null, null, 14);
    L42:
        if (r11.size() <= 1) goto L44;
    L6:
        e0 r14 = (e0) r0.e().getValue();
        if (r14 == null) goto L11;
        LaunchInfo r15 = r14.a;
        if (r15 == null) goto L11;
        r2 = r15.I();
    L12:
        if (r2 != null) goto L14;
        return null;
    L11:
        r2 = null;
        goto L12
    }
}
