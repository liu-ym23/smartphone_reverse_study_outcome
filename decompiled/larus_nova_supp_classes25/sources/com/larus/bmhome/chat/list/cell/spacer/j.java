package com.larus.bmhome.chat.list.cell.spacer;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j extends xc8.b {
    public final String e;
    public final int f;
    public final SpacerAnimationState g;
    public final boolean h;
    public final com.larus.bmhome.chat.list.cell.spacer.a i;
    public final boolean j;
    public final i k;

    public static final class a {
    }

    static {
    }

    @Override // xc8.b
    public final boolean b(wq8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "newItem");
        if ((r3 instanceof j) == false) goto L22;
        j r4 = (j) r3;
        if (r4.f != this.f) goto L22;
        if (r4.g != this.g) goto L22;
        if (r4.h != this.h) goto L22;
        if (r4.j != this.j) goto L22;
        com.larus.bmhome.chat.list.cell.spacer.a r5 = r4.i;
        String r0 = null;
        if (r5 == null) goto L15;
        String r6 = k.a(r5);
    L16:
        com.larus.bmhome.chat.list.cell.spacer.a r1 = this.i;
        if (r1 == null) goto L20;
        r0 = k.a(r1);
    L20:
        if (Intrinsics.areEqual(r6, r0) == false) goto L22;
        return true;
    L15:
        r6 = null;
    L22:
        return false;
    }

    @Override // xc8.b
    public final boolean c(wq8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "newItem");
        if ((r2 instanceof j) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((j) r2).e, this.e) == false) goto L7;
        return true;
    }

    public j(String r51, int r52, String r53, Message r54, SpacerAnimationState r55, boolean r56, com.larus.bmhome.chat.list.cell.spacer.a r57, boolean r58, vd8.b r59) {
        Intrinsics.checkNotNullParameter(r51, "spacerId");
        Intrinsics.checkNotNullParameter(r53, "conversationId");
        Intrinsics.checkNotNullParameter(r54, "baseMessage");
        Intrinsics.checkNotNullParameter(r55, "animationState");
        Intrinsics.checkNotNullParameter(r59, "delegate");
        String r20 = "spacer_cell_" + r51;
        super(new Message(r53, null, null, 0, 21, null, 0, false, null, null, null, null, null, null, r20, r20, r54.getLocalIndex() + 1, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -114770, 31, null));
        this.e = r51;
        this.f = r52;
        this.g = r55;
        this.h = r56;
        this.i = r57;
        this.j = r58;
        this.k = r59;
    }
}
