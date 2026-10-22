package com.ss.android.lark.chat.entity.media;

import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.image.entity.BaseImageSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class MediaImageSet extends ImageSet {
    private MediaExtra mediaExtra;

    public MediaImageSet() {
    }

    public MediaExtra getMediaExtra() {
        return this.mediaExtra;
    }

    public MediaImageSet(Message r6) {
        if (r6.getType() != Message.Type.MEDIA) goto L6;
        MediaContent r0 = (MediaContent) r6.getContent();
        ImageSet r1 = r0.getImageSet();
        ((BaseImageSet) this).key = r1.getKey();
        ((BaseImageSet) this).origin = r1.getOrigin();
        ((BaseImageSet) this).thumbnail = r1.getThumbnail();
        ((BaseImageSet) this).middle = r1.getMiddle();
        this.inlinePreview = r1.getInlinePreview();
        MediaExtra r2 = new MediaExtra();
        this.mediaExtra = r2;
        r2.setFilePath(r0.getPlayPath());
        this.mediaExtra.setKey(r0.getKey());
        this.mediaExtra.setSize(r0.getSize());
        this.mediaExtra.setMime(r0.getMime());
        this.mediaExtra.setUrl(r0.getUrl());
        this.mediaExtra.setDuration(r0.getDuration());
        setMediaExtra(this.mediaExtra);
        MessageIdentity r3 = new MessageIdentity(r6.getId(), r6.getChatId(), r6.getSourceId(), r6.getSourceType());
        r3.setSenderId(r6.getFromId());
        r3.setSenderTenantId(r6.getFromChatterTenantId());
        setMessageIdentity(r3);
        return;
    }

    public void setMediaExtra(MediaExtra r1) {
        this.mediaExtra = r1;
    }

    public MediaImageSet(ImageSet r8) {
        super(r8.getKey(), r8.getOrigin(), r8.getThumbnail(), r8.getMiddle(), r8.getInlinePreview(), r8.getMessageIdentity());
    }
}
