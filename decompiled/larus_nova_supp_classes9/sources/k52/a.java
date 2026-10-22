package k52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePipelineType;
import h52.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final MessagePipelineType a;
    public final int b;
    public final int c;
    public final int d;
    public final e52.a e;
    public final k<c> f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L18;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        MessagePipelineType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((((r2 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        e52.a r4 = this.e;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        k<c> r7 = this.f;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ModelPipelineConfig(pipelineSymbol=" + this.a + ", defaultBufferSize=" + this.b + ", defaultTik=" + this.c + ", numPerTik=" + this.d + ", textMessageConfig=" + this.e + ", renderTextProcessor=" + this.f + ")";
    }

    public a(MessagePipelineType r2, int r3, int r4, int r5, e52.a r6, k<c> r7) {
        Intrinsics.checkNotNullParameter(r2, "pipelineSymbol");
        Intrinsics.checkNotNullParameter(r6, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r7, "renderTextProcessor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
