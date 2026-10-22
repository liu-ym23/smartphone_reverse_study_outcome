package com.ss.android.lark.keyboard.base;

import com.bytedance.lark.pb.basic.v1.DraftAttachmentSnapshot;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final C0125a b = null;
    public final DraftAttachmentSnapshot a;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.base.a$a, reason: collision with other inner class name */
    public static final class C0125a implements n.a<a> {
        public C0125a() {
        }
    }

    static {
        b = new C0125a();
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        DraftAttachmentSnapshot r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "DraftAttachmentInfo(attachmentSnapshot=" + this.a + ')';
    }

    public a(DraftAttachmentSnapshot r1) {
        this.a = r1;
    }
}
