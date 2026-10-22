package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"shouldPrioritizeOver", "", "Landroidx/paging/ViewportHint;", "previous", "loadType", "Landroidx/paging/LoadType;", "paging-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HintHandlerKt {
    public static final boolean shouldPrioritizeOver(ViewportHint r4, ViewportHint r5, LoadType r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, "loadType");
        if (r5 != null) goto L6;
    L23:
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ViewportHint.Initial.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, ViewportHint.Access.class) == true) goto L23;
    L11:
        if (ZeusTransformUtils.instanceOf(r4, ViewportHint.Initial.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r5, ViewportHint.Access.class) == false) goto L16;
        return false;
    L16:
        if (r4.getOriginalPageOffsetFirst() != r5.getOriginalPageOffsetFirst()) goto L23;
        if (r4.getOriginalPageOffsetLast() != r5.getOriginalPageOffsetLast()) goto L23;
        if (r5.presentedItemsBeyondAnchor$paging_common(r6) > r4.presentedItemsBeyondAnchor$paging_common(r6)) goto L23;
        return false;
    }
}
