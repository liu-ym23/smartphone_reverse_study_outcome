package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public static final PolymorphicFeedCardType a(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = a.l(r2, "_runtimeType");
        PolymorphicFeedCardType r0 = PolymorphicFeedCardType.CHAT_FEED_PREVIEW;
        if (Intrinsics.areEqual(r3, r0.getValue()) == true) goto L13;
        PolymorphicFeedCardType r1 = PolymorphicFeedCardType.THREAD_FEED_PREVIEW;
        if (Intrinsics.areEqual(r3, r1.getValue()) == true) goto L14;
        PolymorphicFeedCardType r4 = PolymorphicFeedCardType.FEED_PREVIEW;
        if (Intrinsics.areEqual(r3, r4.getValue()) == false) goto L12;
        return r4;
    L12:
        return PolymorphicFeedCardType.UI_FEED_CARD;
    L14:
        return r1;
    L13:
        return r0;
    }

    public static final void b(JsonObject r1, UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        if ((r2 instanceof ChatFeedPreview) == false) goto L6;
        String r3 = PolymorphicFeedCardType.CHAT_FEED_PREVIEW.getValue();
    L12:
        a.j(r1, "_runtimeType", r3);
        return;
    L6:
        if ((r2 instanceof ThreadFeedPreview) == false) goto L9;
        r3 = PolymorphicFeedCardType.THREAD_FEED_PREVIEW.getValue();
        goto L12
    L9:
        if ((r2 instanceof FeedPreview) == false) goto L11;
        r3 = PolymorphicFeedCardType.FEED_PREVIEW.getValue();
        goto L12
    L11:
        r3 = PolymorphicFeedCardType.UI_FEED_CARD.getValue();
        goto L12
    }
}
