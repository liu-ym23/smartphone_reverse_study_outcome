package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.feed.shared.data.preview.DocFeedPreview;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/DocFeedPreviewTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/shared/data/preview/DocFeedPreview;", "fieldCodec", "Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;", "docTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/doc/entity/DocType;", "docMessageTypeAdapter", "Lcom/ss/android/lark/doc/entity/DocMessage$Type;", "<init>", "(Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocFeedPreviewTypeAdapter extends JsonTreeTypeAdapter<DocFeedPreview> {
    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final DocFeedPreview a(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "json");
        new DocFeedPreview();
        throw null;
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(DocFeedPreview r2) {
        DocFeedPreview r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "value");
        e.b(new JsonObject(), r3);
        throw null;
    }
}
