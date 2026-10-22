package com.larus.bmhome.chat.component.list;

import android.os.Bundle;
import android.os.SystemClock;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponent$g implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatListComponent a;

    public ChatListComponent$g(ChatListComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.component.list.g6] */
    public final void c(Object r14) {
        wc9.e r15 = (wc9.e) r14;
        Intrinsics.checkNotNullParameter(r15, "new");
        c r0 = this.a.U;
        if (r0 != null) goto L5;
    L8:
        String r16 = r15.a;
        final ChatListComponent r1 = this.a;
        ?? r3 = new g6(r1);
        int r4 = ChatListComponent.W3;
        long r5 = -1;
        if (r1.f1().B() == false) goto L11;
        long r6 = this.a.Mg();
    L13:
        if (r6 == (-1)) goto L15;
    L24:
        List r2 = this.a.getCurrentList();
        if (r2 != null) goto L27;
        r2 = CollectionsKt.emptyList();
    L27:
        this.a.V3(r2, r16);
        if (r6 != (-1)) goto L49;
        if (this.a.f1().y() == false) goto L33;
        r6 = this.a.E5(r2);
        goto L49
    L33:
        if (this.a.G7() == false) goto L41;
        ChatListComponent r7 = this.a;
        if (r7.G7() == false) goto L47;
        long r8 = r7.f1().s();
        if (r8 != 0) goto L40;
        FLogger.a.i(r7.n, "load latest messages for red dot entry without a read position");
        goto L47
    L40:
        r6 = (r8 + 1) * 1000;
    L47:
        r6 = -1;
        goto L49
    L41:
        ChatListComponent r9 = this.a;
        r9.getClass();
        if (z2.a.G1() == true) goto L44;
        boolean r10 = r9.M3;
    L45:
        if (r10 == false) goto L47;
        this.a.getClass();
        r6 = ChatListComponent.i5(r2);
        goto L49
    L44:
        r10 = r9.I7();
    L49:
        if (r6 != (-1)) goto L57;
        Bundle r11 = this.a.f1().b;
        boolean r12 = false;
        if (r11 == null) goto L53;
        r12 = r11.getBoolean("is_push_source", false);
    L53:
        if (r12 == false) goto L55;
        r5 = this.a.z5();
    L55:
        r6 = r5;
    L57:
        if (com.larus.utils.o0.d(r16) == false) goto L59;
        this.a.U5().setStartAnchor(Long.valueOf(r6));
    L60:
        r3.invoke(Long.valueOf(r6));
        return;
    L59:
        this.a.U5().setStartAnchor(Long.valueOf(r6));
        goto L60
    L15:
        if (this.a.o6() == false) goto L24;
        Bundle r13 = this.a.f1().b;
        if (r13 == null) goto L19;
        long r17 = r13.getLong("unread_query_read_message_index", -1);
    L21:
        if (r17 < 0) goto L23;
        r6 = (r17 + 1) * 1000;
        goto L24
    L23:
        r6 = -1;
        goto L24
    L19:
        r17 = -1;
        goto L21
    L11:
        r6 = -1;
        goto L13
    L5:
        if (r0.e == true) goto L8;
        r0.e = true;
        r0.f = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r0.i, 0);
        goto L8
    }
}
