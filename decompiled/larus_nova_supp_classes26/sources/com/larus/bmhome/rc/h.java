package com.larus.bmhome.rc;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public final j a;
    public final ResourceAttachmentExtra b;
    public final UplinkFileEntity c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        UplinkFileEntity r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.d.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResourceUploadContext(originParam=" + this.a + ", preHandleExtraParam=" + this.b + ", uplinkEntityContent=" + this.c + ", sceneId=" + this.d + ')';
    }

    public h(j r2, ResourceAttachmentExtra r3, UplinkFileEntity r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "originParam");
        Intrinsics.checkNotNullParameter(r3, "preHandleExtraParam");
        Intrinsics.checkNotNullParameter(r5, "sceneId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
