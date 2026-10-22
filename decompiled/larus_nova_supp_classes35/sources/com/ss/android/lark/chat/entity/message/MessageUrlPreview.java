package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.chat.entity.image.ImageSet;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MessageUrlPreview implements Serializable {
    private int count;
    private ImageSet coverImage;
    private String description;
    private ImageSet icon;
    private boolean isDeleted;
    private String messageId;
    private int offset;
    private PreviewVideo previewVideo;
    private int sequenceId;
    private String title;
    private String url;

    public MessageUrlPreview() {
        this.isDeleted = false;
    }

    public int getCount() {
        return this.count;
    }

    public ImageSet getCoverImage() {
        return this.coverImage;
    }

    public String getDescription() {
        return this.description;
    }

    public ImageSet getIcon() {
        return this.icon;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getOffset() {
        return this.offset;
    }

    public PreviewVideo getPreviewVideo() {
        return this.previewVideo;
    }

    public int getSequenceId() {
        return this.sequenceId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setCount(int r1) {
        this.count = r1;
    }

    public void setCoverImage(ImageSet r1) {
        this.coverImage = r1;
    }

    public void setDeleted(boolean r1) {
        this.isDeleted = r1;
    }

    public void setDescription(String r1) {
        this.description = r1;
    }

    public void setIcon(ImageSet r1) {
        this.icon = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setOffset(int r1) {
        this.offset = r1;
    }

    public void setPreviewVideo(PreviewVideo r1) {
        this.previewVideo = r1;
    }

    public void setSequenceId(int r1) {
        this.sequenceId = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
