package zy8;

import com.larus.bmhome.chat.bean.ChatPageContext;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s {
    public final a a;
    public final t b;
    public final ChatPageContext c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        ChatPageContext r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "GallerySendEventExt(imgSendEventExt=" + this.a + ", textSendEventExt=" + this.b + ", chatPageContext=" + this.c + ')';
    }

    public final Map<String, String> a() {
        Map r0 = MapsKt.createMapBuilder();
        String r1 = this.a.a;
        if (r1 == null) goto L5;
        String r2 = (String) r0.put("enter_method", r1);
    L5:
        String r3 = this.a.b;
        if (r3 == null) goto L8;
        String r4 = (String) r0.put("scene", r3);
    L8:
        String r5 = this.a.c;
        if (r5 == null) goto L11;
        String r6 = (String) r0.put("content_source", r5);
    L11:
        String r7 = this.a.d;
        if (r7 == null) goto L14;
        String r8 = (String) r0.put("content_source_entrance", r7);
    L14:
        String r9 = this.a.e;
        if (r9 == null) goto L18;
        r0.put("picture_source_message_id", r9);
    L18:
        return MapsKt.build(r0);
    }

    public final Map<String, String> b() {
        Map r0 = MapsKt.createMapBuilder();
        String r1 = this.b.a;
        if (r1 == null) goto L5;
        String r2 = (String) r0.put("enter_method", r1);
    L5:
        String r3 = this.b.b;
        if (r3 == null) goto L8;
        String r4 = (String) r0.put("scene", r3);
    L8:
        String r5 = this.b.c;
        if (r5 == null) goto L11;
        String r6 = (String) r0.put("content_source", r5);
    L11:
        String r7 = this.b.d;
        if (r7 == null) goto L14;
        String r8 = (String) r0.put("content_source_entrance", r7);
    L14:
        String r9 = this.b.e;
        if (r9 == null) goto L18;
        r0.put("picture_source_message_id", r9);
    L18:
        return MapsKt.build(r0);
    }

    public s(a r2, t r3, ChatPageContext r4) {
        Intrinsics.checkNotNullParameter(r2, "imgSendEventExt");
        Intrinsics.checkNotNullParameter(r3, "textSendEventExt");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
