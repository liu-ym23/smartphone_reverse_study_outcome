package com.larus.bmhome.upload.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/upload/audio/AudioConversationImageUploadContent;", "Lcom/larus/bmhome/upload/audio/BaseAudioUploadContent;", "key", "", "takePhotoTime", "", "dataByte", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getTakePhotoTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDataByte", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b extends j {

    @SerializedName("data")
    private final String dataByte;

    @SerializedName("key")
    private final String key;

    @SerializedName("pic_shooting_time")
    private final Long takePhotoTime;

    public b() {
        this("", 0L, "");
    }

    public final String a() {
        return this.key;
    }

    public b(String r1, Long r2, String r3) {
        this.key = r1;
        this.takePhotoTime = r2;
        this.dataByte = r3;
    }
}
