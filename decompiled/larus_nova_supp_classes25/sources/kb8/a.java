package kb8;

import com.larus.bmhome.chat.bean.DeepThinkFoldStatus;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final Message a;
    public final String b;
    public final List<String> c;
    public final List<Reference> d;
    public final o e;
    public final boolean f;
    public boolean g;
    public DeepThinkFoldStatus h;

    public a() {
        throw null;
    }

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
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        List<String> r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((r0 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        int r4 = 1231;
        if (this.f == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.g == true) goto L15;
        r4 = 1237;
    L15:
        return ((r6 + r4) * 31) + this.h.hashCode();
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "QueryKeywordReferencesVMData(message=" + this.a + ", messageId=" + this.b + ", queries=" + this.c + ", referenceList=" + this.d + ", referenceData=" + this.e + ", isDeepThinkingStreaming=" + this.f + ", needNotifyLastItemChanged=" + this.g + ", foldStatus=" + this.h + ')';
    }

    public a(Message r3, String r4, List r5, List r6, o r7, boolean r8, int r9) {
        if ((r9 & 32) == 0) goto L6;
        r8 = false;
    L6:
        if ((r9 & 128) == 0) goto L8;
        DeepThinkFoldStatus r10 = DeepThinkFoldStatus.CompleteExpand;
    L9:
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "messageId");
        Intrinsics.checkNotNullParameter(r6, "referenceList");
        Intrinsics.checkNotNullParameter(r7, "referenceData");
        Intrinsics.checkNotNullParameter(r10, "foldStatus");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = false;
        this.h = r10;
        return;
    L8:
        r10 = null;
        goto L9
    }
}
