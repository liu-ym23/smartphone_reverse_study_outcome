package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/shared/data/preview/FeedPreview;", "fieldCodec", "Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;", "registry", "Lcom/ss/android/lark/feed/molten/serializer/FeedCardTypeAdapterRegistry;", "<init>", "(Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;Lcom/ss/android/lark/feed/molten/serializer/FeedCardTypeAdapterRegistry;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedPreviewTypeAdapter extends JsonTreeTypeAdapter<FeedPreview> {
    public final c a;
    public final b b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PolymorphicFeedCardType.values().length];
            r0[PolymorphicFeedCardType.CHAT_FEED_PREVIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PolymorphicFeedCardType.THREAD_FEED_PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ FeedPreview a(JsonObject r1) {
        return c(r1);
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ JsonObject b(FeedPreview r1) {
        return d(r1);
    }

    public final FeedPreview c(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "json");
        PolymorphicFeedCardType r0 = e.a(r4);
        int r1 = a.a[r0.ordinal()];
        ChatFeedPreviewTypeAdapter r2 = null;
        ThreadFeedPreviewTypeAdapter r3 = null;
        if (r1 != 1) goto L5;
        ChatFeedPreviewTypeAdapter r5 = this.b.b;
        if (r5 == null) goto L15;
        r2 = r5;
    L17:
        return r2.c(r4);
    L15:
        Intrinsics.throwUninitializedPropertyAccessException("chatFeedPreviewAdapter");
        goto L17
    L5:
        if (r1 == 2) goto L7;
        FeedPreview r6 = new FeedPreview();
        this.a.a(r4, r6);
        return r6;
    L7:
        ThreadFeedPreviewTypeAdapter r7 = this.b.c;
        if (r7 == null) goto L10;
        r3 = r7;
    L19:
        return r3.c(r4);
    L10:
        Intrinsics.throwUninitializedPropertyAccessException("threadFeedPreviewAdapter");
        goto L19
    }

    public final JsonObject d(FeedPreview r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        ThreadFeedPreviewTypeAdapter r1 = null;
        ChatFeedPreviewTypeAdapter r2 = null;
        if ((r3 instanceof ChatFeedPreview) == false) goto L10;
        ChatFeedPreviewTypeAdapter r0 = this.b.b;
        if (r0 == null) goto L7;
        r2 = r0;
    L18:
        return r2.d((ChatFeedPreview) r3);
    L7:
        Intrinsics.throwUninitializedPropertyAccessException("chatFeedPreviewAdapter");
        goto L18
    L10:
        if ((r3 instanceof ThreadFeedPreview) == false) goto L16;
        ThreadFeedPreviewTypeAdapter r4 = this.b.c;
        if (r4 == null) goto L14;
        r1 = r4;
    L19:
        return r1.d((ThreadFeedPreview) r3);
    L14:
        Intrinsics.throwUninitializedPropertyAccessException("threadFeedPreviewAdapter");
        goto L19
    L16:
        JsonObject r5 = new JsonObject();
        e.b(r5, r3);
        this.a.b(r5, r3);
        return r5;
    }

    public FeedPreviewTypeAdapter(c r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "fieldCodec");
        Intrinsics.checkNotNullParameter(r3, "registry");
        this.a = r2;
        this.b = r3;
    }
}
