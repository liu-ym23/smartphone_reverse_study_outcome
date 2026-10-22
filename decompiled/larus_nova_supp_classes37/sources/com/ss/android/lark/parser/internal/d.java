package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.widget.richtext.RichTextElement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static MediaImageSet a(MediaContentVO r4) {
        MediaImageSet r0 = new MediaImageSet((ImageSet) r4.f.getValue());
        MediaExtra r1 = new MediaExtra();
        r1.setUrl((String) r4.m.getValue());
        r1.setKey((String) r4.b.getValue());
        r1.setMime((String) r4.d.getValue());
        r1.setSize(0);
        r1.setFilePath(r4.f());
        r1.setDuration(r4.e());
        r0.setMediaExtra(r1);
        return r0;
    }

    public static MediaImageSet b(MediaContent r4) {
        MediaImageSet r0 = new MediaImageSet(r4.getImageSet());
        MediaExtra r1 = new MediaExtra();
        r1.setUrl(r4.getUrl());
        r1.setKey(r4.getKey());
        r1.setMime(r4.getMime());
        r1.setSize(r4.getSize());
        r1.setFilePath(r4.getPlayPath());
        r1.setDuration(r4.getDuration());
        r0.setMediaExtra(r1);
        return r0;
    }

    public static MediaImageSet d(y6b.a r3, RichTextElement.MediaProperty r4) {
        y6b.b r0 = r3.a();
        if (r0 == null) goto L5;
        String r1 = r0.w;
    L7:
        return c(r3.getId(), r3.getChatId(), r3.g(), r1, r4);
    L5:
        r1 = null;
        goto L7
    }

    public static MediaImageSet c(String r4, String r5, String r6, String r7, RichTextElement.MediaProperty r8) {
        MediaImageSet r0 = new MediaImageSet();
        r0.setKey(r8.getKey());
        r0.setOrigin(i0.a(r8.getOriginImage()));
        r0.setThumbnail(i0.a(r8.getThumbImage()));
        MediaExtra r1 = new MediaExtra();
        r1.setUrl(r8.getUrl());
        r1.setKey(r8.getKey());
        r1.setMime(r8.getMime());
        r1.setSize(r8.getSize());
        r1.setFilePath(r8.getOriginPath());
        r1.setDuration(r8.getDuration());
        r0.setMediaExtra(r1);
        MessageIdentity r9 = new MessageIdentity(r4, r5);
        r9.setSenderId(r6);
        r9.setSenderTenantId(r7);
        r0.setMessageIdentity(r9);
        return r0;
    }
}
