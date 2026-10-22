package j2;

import com.bytedance.ai.api.model.output.AIOutputContentType;
import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.ai.model.objects.WidgetInfo;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final AIOutputContentType a;
    public final String b;
    public final Map<String, String> c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;
    public final List<String> h;
    public final List<String> i;

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
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r11.g) goto L30;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Map<String, String> r1 = this.c;
        int r10 = 0;
        if (r1 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = (((((((r0 + r11) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L9;
        int r13 = 1231;
    L10:
        int r14 = (r12 + r13) * 31;
        List<String> r15 = this.h;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        List<String> r18 = this.i;
        if (r18 == null) goto L19;
        r10 = r18.hashCode();
    L19:
        return r17 + r10;
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = 1237;
        goto L10
    L5:
        r11 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIOutputContent(type=" + this.a + ", content=" + this.b + ", extra=" + this.c + ", botId=" + this.d + ", queryId=" + this.e + ", conversationId=" + this.f + ", forHistoricalQuestion=" + this.g + ", suggests=" + this.h + ", suggestsV2=" + this.i + ')';
    }

    public final AIOutputContentType getType() {
        return this.a;
    }

    public b(AIOutputContentType r12, WidgetInfo r13, Map<String, String> r14, String r15, String r16, String r17, boolean r18, List<String> r19, List<String> r20) {
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "widgetInfo");
        Intrinsics.checkNotNullParameter(r15, "botId");
        Intrinsics.checkNotNullParameter(r16, "queryId");
        Intrinsics.checkNotNullParameter(r17, "conversationId");
        this(r12, e.c(r13), r14, r15, r16, r17, r18, r19, r20);
    }

    public b(AIOutputContentType r10, String r11, Map<String, String> r12, String r13, String r14, String r15, boolean r16, List<String> r17, List<String> r18) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r14, "queryId");
        Intrinsics.checkNotNullParameter(r15, "conversationId");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
    }
}
