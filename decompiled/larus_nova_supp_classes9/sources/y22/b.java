package y22;

import com.bytedance.android.livesdk.event.c0;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentBusinessType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentContentType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final boolean a(CommentFlowContext r0) {
        if (r0 == null) goto L6;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L6;
        return r1.o;
    L6:
        return false;
    }

    public static final boolean b(c0 r4) {
        Object r0 = null;
        if (r4 == null) goto L5;
        Object r1 = r4.g;
    L7:
        if ((r1 instanceof CommentFlowContext) == false) goto L10;
        r0 = r1;
    L10:
        CommentFlowContext r2 = (CommentFlowContext) r0;
        if (r2 != null) goto L14;
        return false;
    L14:
        CommentContentType r3 = CommentContentType.Image;
        CommentBusinessType r5 = CommentBusinessType.Normal;
        Intrinsics.checkNotNullParameter(r3, "contentType");
        Intrinsics.checkNotNullParameter(r5, "businessType");
        Intrinsics.checkNotNullParameter(r4, "emojiEvent");
        r2.a = CommentFlowContext.State.Send;
        r2.e = r3;
        r2.f = r5;
        r2.h = r4;
        return r2.a();
    L5:
        r1 = null;
        goto L7
    }
}
