package com.bytedance.android.live.broadcastgame.api.xplay;

import com.bytedance.android.live.broadcastgame.api.model.q0;
import com.bytedance.android.live.broadcastgame.api.model.u;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public static final l a(u r18) {
        Intrinsics.checkNotNullParameter(r18, "$this$toXplayGameItem");
        int r3 = r18.interactId;
        com.bytedance.android.live.broadcastgame.api.model.r r2 = r18.c();
        if (r2 == null) goto L8;
        String r4 = r2.b();
        if (r4 == null) goto L8;
        String r5 = r4;
    L9:
        String r6 = r18.name;
        com.bytedance.android.live.broadcastgame.api.model.r r7 = r18.c();
        if (r7 == null) goto L12;
        long r8 = r7.p();
    L13:
        String r9 = (String) CollectionsKt.firstOrNull(r18.iconUrl);
        if (r9 != null) goto L16;
        String r11 = "";
    L17:
        com.bytedance.android.live.broadcastgame.api.model.r r12 = r18.c();
        if (r12 == null) goto L22;
        com.bytedance.android.live.broadcastgame.api.model.g r13 = r12.n();
        if (r13 == null) goto L22;
        q0 r14 = r13.b();
    L23:
        q0 r15 = r14;
        com.bytedance.android.live.broadcastgame.api.model.r r16 = r18.c();
        if (r16 == null) goto L29;
        String r17 = r16.C();
        if (r17 == null) goto L29;
        String r19 = r17;
    L30:
        com.bytedance.android.live.broadcastgame.api.model.r r21 = r18.c();
        if (r21 == null) goto L33;
        int r110 = r21.g();
    L34:
        com.bytedance.android.live.broadcastgame.api.model.r r22 = r18.c();
        if (r22 == null) goto L40;
        String r23 = r22.c();
        if (r23 == null) goto L40;
        String r111 = r23;
    L41:
        com.bytedance.android.live.broadcastgame.api.model.r r24 = r18.c();
        if (r24 == null) goto L49;
        com.bytedance.android.live.broadcastgame.api.model.g r25 = r24.n();
        if (r25 == null) goto L49;
        String r26 = r25.a();
        if (r26 == null) goto L49;
        String r112 = r26;
    L50:
        com.bytedance.android.live.broadcastgame.api.model.r r27 = r18.c();
        if (r27 == null) goto L55;
        com.bytedance.android.live.broadcastgame.api.model.g r28 = r27.n();
        if (r28 == null) goto L55;
        boolean r113 = r28.c();
    L56:
        com.bytedance.android.live.broadcastgame.api.model.r r29 = r18.c();
        if (r29 == null) goto L62;
        String r31 = r29.j();
        if (r31 == null) goto L62;
        String r114 = r31;
    L63:
        com.bytedance.android.live.broadcastgame.api.model.r r32 = r18.c();
        if (r32 == null) goto L67;
        List<Integer> r33 = r32.H();
        if (r33 == null) goto L67;
    L68:
        List<Integer> r115 = r33;
        com.bytedance.android.live.broadcastgame.api.model.r r0 = r18.c();
        if (r0 == null) goto L72;
        String r1 = r0.A();
        if (r1 == null) goto L72;
    L74:
        return new l(r3, r5, r6, r8, r11, r19, r110, r114, r111, r112, r113, r15, r115, r1);
    L72:
        r1 = "";
    L67:
        r33 = CollectionsKt.emptyList();
    L62:
        r114 = "";
    L55:
        r113 = false;
    L49:
        r112 = "";
    L40:
        r111 = "";
        goto L41
    L33:
        r110 = 0;
    L29:
        r19 = "";
    L22:
        r14 = null;
        goto L23
    L16:
        r11 = r9;
        goto L17
    L12:
        r8 = 0;
    L8:
        r5 = "";
        goto L9
    }
}
