package com.larus.bmhome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import ug9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements ug9.a {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ AIChatServiceImpl b;
    public final /* synthetic */ Context c;

    public /* synthetic */ a(com.larus.xbridge.custom.v r1, AIChatServiceImpl r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onActivityResult(int r8, int r9, Intent r10) {
        Function1 r0 = this.a;
        AIChatServiceImpl r1 = this.b;
        b r2 = this.c;
        int r3 = AIChatServiceImpl.f;
        if (r8 != 100) goto L28;
        if (r9 != 100) goto L28;
        Bundle r11 = r10.getExtras();
        if (r11 == null) goto L10;
        Iterable r12 = r11.getStringArrayList("argChatMsgIds");
        if (r12 == null) goto L10;
    L11:
        Bundle r13 = r10.getExtras();
        if (r13 == null) goto L16;
        List r14 = r13.getStringArrayList("argChatMsgSenderIds");
        if (r14 == null) goto L16;
    L17:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r12.iterator();
        int r4 = 0;
    L19:
        if (r16.hasNext() == false) goto L27;
        Object r5 = r16.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        String r7 = (String) r5;
        String r17 = (String) CollectionsKt.getOrNull(r14, r4);
        if (r17 != null) goto L26;
        r17 = "";
    L26:
        r15.add(new Pair(r7, r17));
        r4 = r6;
        goto L19
    L27:
        r0.invoke(r15);
    L16:
        r14 = CollectionsKt.emptyList();
    L10:
        r12 = CollectionsKt.emptyList();
    L28:
        a r18 = r1.b;
        if (r18 != null) goto L31;
        return;
    L31:
        if ((r2 instanceof b) == false) goto L33;
        b r19 = r2;
    L34:
        if (r19 == null) goto L41;
        r19.S(r18);
        return;
    L41:
        return;
    L33:
        r19 = null;
        goto L34
    }
}
