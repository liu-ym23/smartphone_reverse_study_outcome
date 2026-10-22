package com.bytedance.lark.lark_bitable_android;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import com.bytedance.ai.event.MessageIndication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public final String a;
    public final String b;
    public final WorkspaceBitableMoveStatus c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "BitableWorkspaceMoveResult(token=" + this.a + ", msg=" + this.b + ", moveResult=" + this.c + ')';
    }

    public o(String r10, String r11, WorkspaceBitableMoveStatus r12) {
        Intrinsics.checkNotNullParameter(r10, BdpShareBaseInfo.CHANNEL_TOKEN);
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        Intrinsics.checkNotNullParameter(r12, "moveResult");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
