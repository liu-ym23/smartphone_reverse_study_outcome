package ulb;

import com.ss.android.lark.inline.ai.api.citation.CitationReferenceType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L8;
        return false;
    L8:
        ((a) r4).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final CitationReferenceType getType() {
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "CopyReference(id=null, type=null, title=null, url=null, content=null)";
    }
}
