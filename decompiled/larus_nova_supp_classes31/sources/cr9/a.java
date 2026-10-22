package cr9;

import com.larus.platform.model.office.AiFilePreviewScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public final String a;
    public final AiFilePreviewScene b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.h;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.i;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiFilePreviewRequest(resourceUri=" + this.a + ", scene=" + this.b + ", fileName=" + this.c + ", fileType=" + this.d + ", directShareUrl=" + this.e + ", resourceId=" + this.f + ", sourceConversationId=" + this.g + ", sourceBotId=" + this.h + ", sourceMessageId=" + this.i + ')';
    }

    public a(String r2, AiFilePreviewScene r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "resourceUri");
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public /* synthetic */ a(String r14, AiFilePreviewScene r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, int r23) {
        if ((r23 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r23 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r23 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r23 & 32) == 0) goto L17;
        String r9 = null;
    L19:
        if ((r23 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r23 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r23 & 256) == 0) goto L29;
        String r12 = null;
    L30:
        this(r14, r15, r6, r7, r8, r9, r10, r11, r12);
        return;
    L29:
        r12 = r22;
        goto L30
    L25:
        r11 = r21;
        goto L27
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r8 = r18;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}
