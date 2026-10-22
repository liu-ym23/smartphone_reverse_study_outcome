package meb;

import com.google.gson.JsonObject;
import com.larus.larkfeed.impl.mixedfeed.model.DouBaoConversationFeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface b<T extends UIFeedCard> {
    JsonObject a(T r1);

    DouBaoConversationFeedCard b(JsonObject r1);
}
