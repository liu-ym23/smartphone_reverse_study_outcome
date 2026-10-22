package com.bytedance.android.livesdk.feed.openui.view;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements com.bytedance.android.livesdk.feed.f.a {
    public final /* synthetic */ LiveListBlock a;

    public static final class a<T> implements com.bytedance.android.live.core.cache.j {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final boolean test(Object r3) {
            FeedItem r4 = (FeedItem) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            Room r5 = r4.getRoom();
            if (r5 == null) goto L5;
            String r6 = String.valueOf(r5.id);
        L7:
            return Intrinsics.areEqual(r6, this.a);
        L5:
            r6 = null;
            goto L7
        }
    }

    public f(LiveListBlock r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.feed.f.a
    public final void a(String r3) {
        FeedItem r4 = (FeedItem) LiveListBlock.c(this.a).find(new a(r3));
        if (r4 == null) goto L6;
        LiveListBlock.c(this.a).remove(r4);
        return;
    }
}
