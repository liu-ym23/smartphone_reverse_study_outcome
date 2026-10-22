package com.ss.android.lark.chat.entity.sticker;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StickerFileInfo implements Serializable {
    public final String filePath;
    public final int height;
    public final String key;
    public String stickerId;
    public String stickerSetId;
    public final String url;
    public final int width;

    public StickerFileInfo(String r1, String r2, String r3, int r4, int r5, String r6, String r7) {
        this.key = r1;
        this.url = r2;
        this.filePath = r3;
        this.width = r4;
        this.height = r5;
        this.stickerSetId = r6;
        this.stickerId = r7;
    }
}
