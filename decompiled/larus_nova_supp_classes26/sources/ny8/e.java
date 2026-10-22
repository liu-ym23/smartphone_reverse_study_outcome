package ny8;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.canvas.service.bean.IImageInfo;
import com.larus.canvas.service.bean.InstructionTabInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final Context a;
    public final String b;
    public final String c;
    public final IImageInfo d;
    public final InstructionTabInfo e;
    public final boolean f;
    public final Bundle g;
    public final String h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        IImageInfo r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        InstructionTabInfo r11 = this.e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        if (this.f == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r13 + r14) * 31;
        Bundle r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.h;
        if (r19 == null) goto L31;
        r2 = r19.hashCode();
    L31:
        return r18 + r2;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = 1237;
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
        return "GenImageConfig(context=" + this.a + ", prompt=" + this.b + ", title=" + this.c + ", imageInfo=" + this.d + ", instructionTabInfo=" + this.e + ", requireImage=" + this.f + ", extraParams=" + this.g + ", conversationId=" + this.h + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public e(FragmentActivity r3, String r4, IImageInfo r5, Bundle r6, String r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 8) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 64) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 128) == 0) goto L14;
        r7 = null;
    L14:
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        this.b = null;
        this.c = r4;
        this.d = r5;
        this.e = null;
        this.f = false;
        this.g = r6;
        this.h = r7;
    }
}
