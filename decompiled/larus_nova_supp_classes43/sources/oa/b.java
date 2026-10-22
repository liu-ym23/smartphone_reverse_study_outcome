package oa;

import android.net.Uri;
import com.bytedance.android.anniex.lite.flow.base.dispatch.FlowTaskType;
import com.lynx.tasm.TemplateData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final FlowTaskType a;
    public final String b;
    public final String c;
    public final Uri d;
    public final TemplateData e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        TemplateData r1 = this.e;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return r0 + r10;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "LoadFlowTask(taskType=" + this.a + ", bid=" + this.b + ", sessionId=" + this.c + ", uri=" + this.d + ", initData=" + this.e + ')';
    }

    public b(FlowTaskType r10, String r11, String r12, Uri r13) {
        Intrinsics.checkNotNullParameter(r10, "taskType");
        Intrinsics.checkNotNullParameter(r11, "bid");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(r13, "uri");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = null;
    }
}
