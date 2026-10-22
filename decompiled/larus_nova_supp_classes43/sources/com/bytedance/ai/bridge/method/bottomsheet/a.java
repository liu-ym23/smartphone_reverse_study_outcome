package com.bytedance.ai.bridge.method.bottomsheet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public final DoubaoBottomSheetAction a;
    public final DoubaoBottomSheetButtonRole b;
    public final DoubaoBottomSheetCancelSource c;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.bottomsheet.a$a, reason: collision with other inner class name */
    public static final class C0021a {
        public static a a(DoubaoBottomSheetCancelSource r10) {
            Intrinsics.checkNotNullParameter(r10, "source");
            return new a(DoubaoBottomSheetAction.CANCEL, null, r10, 2);
        }
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        DoubaoBottomSheetButtonRole r1 = this.b;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        DoubaoBottomSheetCancelSource r13 = this.c;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoubaoBottomSheetResult(action=" + this.a + ", role=" + this.b + ", source=" + this.c + ')';
    }

    public a(DoubaoBottomSheetAction r10, DoubaoBottomSheetButtonRole r11, DoubaoBottomSheetCancelSource r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        Intrinsics.checkNotNullParameter(r10, "action");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
