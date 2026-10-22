package vz1;

import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CardStatus;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final int a;
    public final String b;
    public final int c;
    public final String d;
    public final boolean e;
    public final l1 f;
    public final n g;
    public final int h;

    public a() {
        this(0, null, 0, null, false, null, null, 0, 255);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L22;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((r0 + r3) * 31) + this.c) * 31;
        String r5 = this.d;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        boolean r8 = this.e;
        ?? r9 = r8;
        if (r8 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r7 + r9) * 31;
        l1 r11 = this.f;
        if (r11 == null) goto L16;
        int r13 = r11.hashCode();
    L17:
        int r14 = (r10 + r13) * 31;
        n r15 = this.g;
        if (r15 == null) goto L21;
        r2 = r15.hashCode();
    L21:
        return ((r14 + r2) * 31) + this.h;
    L16:
        r13 = 0;
        goto L17
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "CardInfo(locked=" + this.a + ", cell_text=" + this.b + ", diamondCount=" + this.c + ", sendButtonText=" + this.d + ", useCustomSendButtonColor=" + this.e + ", buffInfo=" + this.f + ", diyInfo=" + this.g + ", selectedStyle=" + this.h + ")";
    }

    public a(int r4, String r5, int r6, String r7, boolean r8, l1 r9, n r10, int r11, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r4 = CardStatus.INSTANCE.getUNLOCK();
    L6:
        if ((r13 & 2) == 0) goto L9;
        r5 = BuildConfig.FLAVOR;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r6 = 0;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r7 = BuildConfig.FLAVOR;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r8 = false;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r9 = null;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r10 = null;
    L24:
        if ((r13 & 128) == 0) goto L26;
        r11 = 0;
    L26:
        Intrinsics.checkNotNullParameter(r7, "sendButtonText");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
    }
}
