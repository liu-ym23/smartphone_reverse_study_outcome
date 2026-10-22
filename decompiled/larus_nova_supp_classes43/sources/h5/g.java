package h5;

import com.bytedance.ai.model.objects.LLMData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final String a;
    public final String b;
    public final String c;
    public String d;
    public final long e;
    public final String f;
    public final String g;
    public final Map<String, String> h;
    public final String i;
    public LLMData j;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
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
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r11.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        long r1 = this.e;
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r11 = this.f;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        String r15 = this.g;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        Map<String, String> r18 = this.h;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        String r21 = this.i;
        if (r21 == null) goto L19;
        r12 = r21.hashCode();
    L19:
        return r20 + r12;
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatData(llmData=" + this.a + ", msgId=" + this.b + ", conversationId=" + this.c + ", botId=" + this.d + ", createTime=" + this.e + ", questionId=" + this.f + ", pluginId=" + this.g + ", featureMap=" + this.h + ", appletId=" + this.i + ')';
    }

    public g(String r10, String r11, String r12, String r13, long r14, String r15, String r16, Map<String, String> r17, String r18) {
        Intrinsics.checkNotNullParameter(r10, "llmData");
        Intrinsics.checkNotNullParameter(r11, "msgId");
        Intrinsics.checkNotNullParameter(r12, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "botId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        com.bytedance.ai.utils.f.j("ChatData: cvsId:" + r12 + ", " + r11 + " --> " + r10);
    }
}
