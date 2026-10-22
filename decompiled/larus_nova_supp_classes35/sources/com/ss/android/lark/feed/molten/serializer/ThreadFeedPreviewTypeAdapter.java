package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ThreadFeedPreviewTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/shared/data/preview/ThreadFeedPreview;", "fieldCodec", "Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;", "chatTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "<init>", "(Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreadFeedPreviewTypeAdapter extends JsonTreeTypeAdapter<ThreadFeedPreview> {
    public final c a;
    public final TypeAdapter<Chat.Type> b;

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ ThreadFeedPreview a(JsonObject r1) {
        return c(r1);
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ JsonObject b(ThreadFeedPreview r1) {
        return d(r1);
    }

    public final ThreadFeedPreview c(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "json");
        ThreadFeedPreview r0 = new ThreadFeedPreview();
        this.a.a(r4, r0);
        r0.setChatId(a.l(r4, "chatId"));
        Boolean r1 = a.c(r4, "isMsgThread");
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L6:
        r0.setMsgThread(r2);
        r0.setP2pChatterId(a.l(r4, "p2pChatterId"));
        Chat.Type r5 = (Chat.Type) a.k(r4, "chatType", this.b);
        if (r5 == null) goto L9;
        r0.setChatType(r5);
    L9:
        return r0;
    L5:
        r2 = false;
        goto L6
    }

    public final JsonObject d(ThreadFeedPreview r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        JsonObject r0 = new JsonObject();
        e.b(r0, r4);
        this.a.b(r0, r4);
        a.j(r0, "chatId", r4.getChatId());
        a.g(r0, "isMsgThread", Boolean.valueOf(r4.isMsgThread()));
        a.j(r0, "p2pChatterId", r4.getP2pChatterId());
        a.i(r0, "chatType", r4.getChatType(), this.b);
        return r0;
    }

    public ThreadFeedPreviewTypeAdapter(c r2, TypeAdapter<Chat.Type> r3) {
        Intrinsics.checkNotNullParameter(r2, "fieldCodec");
        Intrinsics.checkNotNullParameter(r3, "chatTypeAdapter");
        this.a = r2;
        this.b = r3;
    }
}
