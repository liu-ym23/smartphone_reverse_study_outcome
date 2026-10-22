package com.bytedance.android.livesdk.feedback;

import android.content.Context;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mx1.d;
import mx1.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final boolean c(FeedItem r2, FeedItem r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$isSame");
        Intrinsics.checkNotNullParameter(r3, "item");
        FeedbackCard r0 = r2.feedbackCard;
        if (r0 != null) goto L10;
        if (r3.feedbackCard != null) goto L10;
        return Intrinsics.areEqual(r2, r3);
    L10:
        return Intrinsics.areEqual(r0, r3.feedbackCard);
    }

    public static final Pair<Float, Float> a(float r3, float r4, float r5) {
        int r0 = s1.y();
        float r1 = s1.w() - r4;
        float r6 = r1 * r3;
        float r2 = r0;
        if (r6 <= r2) goto L8;
        if (r3 == 0.0f) goto L8;
        r6 = r2 - r5;
        r1 = r6 / r3;
    L8:
        return new Pair(Float.valueOf(r6), Float.valueOf(r1));
    }

    public static final nx1.a b(Question r4, Context r5, mx1.b r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "$this$generateView");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "listener");
        Long r0 = r4.type;
        if (r0 == null) goto L19;
        long r1 = r0.longValue();
        if (r7 == false) goto L11;
        if (r1 != 1) goto L11;
        return new e(r5, r4, r6);
    L11:
        if (r1 != 1) goto L14;
        return new d(r5, r4, r6);
    L14:
        if (r1 != 2) goto L17;
        return new mx1.c(r5, r4, r6);
    L17:
        if (r1 != 3) goto L19;
        return new mx1.a(r5, r4, r6);
    L19:
        return null;
    }
}
