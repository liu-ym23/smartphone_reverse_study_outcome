package com.larus.avlink.gallery.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public static final Gson a = null;
    public static final Gson b = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/avlink/gallery/storage/MediaMetadataConverter$fromJsonList$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/avlink/gallery/model/MediaMetadata;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class a extends TypeToken<List<? extends MediaMetadata>> {
        public a() {
        }
    }

    static {
        a = new Gson();
        b = new GsonBuilder().registerTypeAdapter(MediaMetadata.class, new k()).create();
    }

    public static List a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "json");
        List r4 = (List) b.fromJson(r3, new a().getType());     // Catch: Exception -> L7
        if (r4 != null) goto L12;
        return CollectionsKt.emptyList();
    L12:
        return r4;
    L7:
        e = move-exception;
        FLogger.a.e("MediaMetadataConverter", "Error parsing JSON list to metadata: " + e.getMessage(), e);
        return CollectionsKt.emptyList();
    }
}
