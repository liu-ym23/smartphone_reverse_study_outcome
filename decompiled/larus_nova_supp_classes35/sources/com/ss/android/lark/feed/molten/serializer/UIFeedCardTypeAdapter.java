package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/UIFeedCardTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "fieldCodec", "Lcom/ss/android/lark/feed/molten/serializer/UIFeedCardFieldCodec;", "registry", "Lcom/ss/android/lark/feed/molten/serializer/FeedCardTypeAdapterRegistry;", "subTypeRegistry", "Lcom/ss/android/lark/feed/shared/data/preview/gson/FeedPreviewSubTypeRegistry;", "<init>", "(Lcom/ss/android/lark/feed/molten/serializer/UIFeedCardFieldCodec;Lcom/ss/android/lark/feed/molten/serializer/FeedCardTypeAdapterRegistry;Lcom/ss/android/lark/feed/shared/data/preview/gson/FeedPreviewSubTypeRegistry;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIFeedCardTypeAdapter extends JsonTreeTypeAdapter<UIFeedCard> {
    public final f a;
    public final b b;
    public final meb.c c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PolymorphicFeedCardType.values().length];
            r0[PolymorphicFeedCardType.CHAT_FEED_PREVIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PolymorphicFeedCardType.THREAD_FEED_PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PolymorphicFeedCardType.FEED_PREVIEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final UIFeedCard a(JsonObject r6) {
        Intrinsics.checkNotNullParameter(r6, "json");
        String r0 = com.ss.android.lark.feed.molten.serializer.a.l(r6, "_runtimeType");
        ChatFeedPreviewTypeAdapter r1 = null;
        FeedPreviewTypeAdapter r2 = null;
        ThreadFeedPreviewTypeAdapter r3 = null;
        if (r0 == null) goto L14;
        Iterator r4 = ((ArrayList) this.c.b).iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((meb.c.a) r5).a, r0) == false) goto L6;
    L11:
        meb.c.a r7 = (meb.c.a) r5;
        if (r7 == null) goto L14;
        return r7.c.b(r6);
    L10:
        r5 = null;
    L14:
        int r8 = a.a[e.a(r6).ordinal()];
        if (r8 != 1) goto L17;
        ChatFeedPreviewTypeAdapter r9 = this.b.b;
        if (r9 == null) goto L34;
        r1 = r9;
    L36:
        return r1.c(r6);
    L34:
        Intrinsics.throwUninitializedPropertyAccessException("chatFeedPreviewAdapter");
        goto L36
    L17:
        if (r8 != 2) goto L19;
        ThreadFeedPreviewTypeAdapter r10 = this.b.c;
        if (r10 == null) goto L29;
        r3 = r10;
    L43:
        return r3.c(r6);
    L29:
        Intrinsics.throwUninitializedPropertyAccessException("threadFeedPreviewAdapter");
        goto L43
    L19:
        if (r8 == 3) goto L21;
        UIFeedCard r11 = new UIFeedCard();
        this.a.b(r6, r11);
        return r11;
    L21:
        FeedPreviewTypeAdapter r12 = this.b.a;
        if (r12 == null) goto L24;
        r2 = r12;
    L42:
        return r2.c(r6);
    L24:
        Intrinsics.throwUninitializedPropertyAccessException("feedPreviewAdapter");
        goto L42
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(UIFeedCard r5) {
        UIFeedCard r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        Iterator r0 = ((ArrayList) this.c.b).iterator();
    L3:
        FeedPreviewTypeAdapter r2 = null;
        ChatFeedPreviewTypeAdapter r3 = null;
        ThreadFeedPreviewTypeAdapter r4 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((meb.c.a) r1).b.isInstance(r6) == false) goto L3;
    L9:
        meb.c.a r7 = (meb.c.a) r1;
        if (r7 == null) goto L13;
        meb.b<T> r8 = r7.c;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.feed.shared.data.preview.gson.FeedPreviewSubTypeAdapter<com.ss.android.lark.feed.app.entity.UIFeedCard>");
        JsonObject r9 = r8.a(r6);
        r9.addProperty("_runtimeType", r7.a);
        return r9;
    L13:
        if ((r6 instanceof ChatFeedPreview) == false) goto L20;
        ChatFeedPreviewTypeAdapter r10 = this.b.b;
        if (r10 == null) goto L17;
        r3 = r10;
    L39:
        return r3.d((ChatFeedPreview) r6);
    L17:
        Intrinsics.throwUninitializedPropertyAccessException("chatFeedPreviewAdapter");
        goto L39
    L20:
        if ((r6 instanceof ThreadFeedPreview) == false) goto L27;
        ThreadFeedPreviewTypeAdapter r11 = this.b.c;
        if (r11 == null) goto L24;
        r4 = r11;
    L40:
        return r4.d((ThreadFeedPreview) r6);
    L24:
        Intrinsics.throwUninitializedPropertyAccessException("threadFeedPreviewAdapter");
        goto L40
    L27:
        if ((r6 instanceof FeedPreview) == false) goto L33;
        FeedPreviewTypeAdapter r12 = this.b.a;
        if (r12 == null) goto L31;
        r2 = r12;
    L41:
        return r2.d((FeedPreview) r6);
    L31:
        Intrinsics.throwUninitializedPropertyAccessException("feedPreviewAdapter");
        goto L41
    L33:
        JsonObject r13 = new JsonObject();
        e.b(r13, r6);
        this.a.a(r13, r6);
        return r13;
    L8:
        r1 = null;
        goto L9
    }

    public UIFeedCardTypeAdapter(f r2, b r3, meb.c r4) {
        Intrinsics.checkNotNullParameter(r2, "fieldCodec");
        Intrinsics.checkNotNullParameter(r3, "registry");
        Intrinsics.checkNotNullParameter(r4, "subTypeRegistry");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
