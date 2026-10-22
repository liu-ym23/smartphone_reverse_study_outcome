package com.larus.bmhome.upload.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0013\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/upload/audio/BaseAudioUploadContent;", "", "contentType", "", "<init>", "(I)V", "getContentType", "()I", "Lcom/larus/bmhome/upload/audio/AudioConversationImageUploadContent;", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class j {

    @SerializedName("content_type")
    private final int contentType;

    public j() {
        this.contentType = 1;
    }
}
