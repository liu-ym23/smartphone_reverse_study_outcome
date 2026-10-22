package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.ILinkerDetailKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final Map<String, Long> a;
    public final IRoomLinkExt b;
    public final u c;
    public final r d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L14;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Map<String, Long> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        IRoomLinkExt r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        u r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        r r10 = this.d;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("EnterRoomLinkInfo{");
        r0.append("linkMap=" + this.a);
        IRoomLinkExt r1 = this.b;
        if (r1 == null) goto L8;
        z5 r2 = IRoomKt_androidKt.getLinkerDetailKt(r1);
        if (r2 == null) goto L8;
        r0.append(",playModes=" + ILinkerDetailKt.getPlayModesEx(r2));
    L8:
        if (this.c == null) goto L10;
        r0.append("," + this.c);
    L32:
        return r0.toString();
    L10:
        Map<String, Long> r3 = this.a;
        if (r3 == null) goto L32;
        if (r3.containsKey(String.valueOf(1)) != true) goto L32;
        if (this.b == null) goto L30;
        StringBuilder r4 = new StringBuilder(", ");
        String r5 = null;
        if (this.b.getLinkMicInfo() == null) goto L22;
        a9 r6 = this.b.getLinkMicInfo();
        if (r6 == null) goto L21;
        String r7 = ef2.a.c(r6);
    L23:
        r4.append(r7);
        r0.append(r4.toString());
        StringBuilder r8 = new StringBuilder(", ");
        if (IRoomKt_androidKt.getLinkerDetailKt(this.b) == null) goto L28;
        vh7.c r9 = IRoomKt_androidKt.getLinkerDetailKt(this.b);
        if (r9 == null) goto L29;
        r5 = ef2.a.c(r9);
    L29:
        r8.append(r5);
        r0.append(r8.toString());
        goto L32
    L28:
        r5 = "linker_detail=null";
        goto L29
    L21:
        r7 = null;
        goto L23
    L22:
        r7 = "link_mic=null";
        goto L23
    L30:
        r0.append(", linkRoom is null");
        goto L32
    }

    public c(Map<String, Long> r1, IRoomLinkExt r2, u r3, r r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
