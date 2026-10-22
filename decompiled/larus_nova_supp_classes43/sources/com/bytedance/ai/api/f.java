package com.bytedance.ai.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final /* synthetic */ int d = 0;
    public final AppletBottomSheetAction a;
    public final AppletBottomSheetButtonRole b;
    public final AppletBottomSheetCancelSource c;

    public static final class a {
        public static f a(AppletBottomSheetCancelSource r10) {
            Intrinsics.checkNotNullParameter(r10, "source");
            return new f(AppletBottomSheetAction.CANCEL, null, r10, 2);
        }
    }

    static {
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
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
        AppletBottomSheetButtonRole r1 = this.b;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (r0 + r11) * 31;
        AppletBottomSheetCancelSource r13 = this.c;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletBottomSheetResult(action=" + this.a + ", role=" + this.b + ", source=" + this.c + ')';
    }

    public f(AppletBottomSheetAction r10, AppletBottomSheetButtonRole r11, AppletBottomSheetCancelSource r12, int r13) {
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
