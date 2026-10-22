package com.larus.bmhome.upload.audio;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/upload/audio/AudioConversationImageUploadRequest;", "Lcom/larus/bmhome/upload/audio/AudioBaseUploadRequest;", "botId", "", "conversationId", "content", "", "Lcom/larus/bmhome/upload/audio/AudioConversationImageUploadContent;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBotId", "()Ljava/lang/String;", "getConversationId", "getContent", "()Ljava/util/List;", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c extends a {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("contents")
    private final List<b> content;

    @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
    private final String conversationId;

    public c() {
        this("", "", null);
    }

    public c(String r1, String r2, List<b> r3) {
        this.botId = r1;
        this.conversationId = r2;
        this.content = r3;
    }
}
