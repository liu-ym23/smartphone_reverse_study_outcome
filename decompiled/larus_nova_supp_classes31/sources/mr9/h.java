package mr9;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public final boolean a;
    public final ResourceAttachmentExtra b;
    public final UplinkFileEntity c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;

    public h() {
        ResourceAttachmentExtra r0 = null;
        boolean r2 = false;
        this(r2, r0, r0, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
        UplinkFileEntity r2 = this.c;
        if (r2 != null) goto L9;
        int r3 = 0;
    L11:
        return ((((r1 + r3) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L9:
        r3 = r2.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceCenterUploadParam(enabled=" + this.a + ", preParseExtraParam=" + this.b + ", entity=" + this.c + ", onLocalProcessReady=" + this.d + ", onUploadedToServer=" + this.e + ')';
    }

    public static h a(h r6, UplinkFileEntity r7) {
        boolean r1 = r6.a;
        ResourceAttachmentExtra r2 = r6.b;
        Function0<Unit> r4 = r6.d;
        Function0<Unit> r5 = r6.e;
        Intrinsics.checkNotNullParameter(r2, "preParseExtraParam");
        Intrinsics.checkNotNullParameter(r4, "onLocalProcessReady");
        Intrinsics.checkNotNullParameter(r5, "onUploadedToServer");
        return new h(r1, r2, r7, r4, r5);
    }

    public /* synthetic */ h(boolean r11, ResourceAttachmentExtra r12, UplinkFileEntity r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r14 & 2) == 0) goto L9;
        ResourceAttachmentExtra r2 = new ResourceAttachmentExtra(null, null, null, null, null, 31, null);
    L11:
        if ((r14 & 4) == 0) goto L13;
        UplinkFileEntity r3 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Function0 r4 = new f();
    L19:
        if ((r14 & 16) == 0) goto L21;
        Function0 r5 = new g();
    L22:
        this(r1, r2, r3, r4, r5);
        return;
    L21:
        r5 = null;
        goto L22
    L17:
        r4 = null;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public h(boolean r2, ResourceAttachmentExtra r3, UplinkFileEntity r4, Function0<Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "preParseExtraParam");
        Intrinsics.checkNotNullParameter(r5, "onLocalProcessReady");
        Intrinsics.checkNotNullParameter(r6, "onUploadedToServer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
