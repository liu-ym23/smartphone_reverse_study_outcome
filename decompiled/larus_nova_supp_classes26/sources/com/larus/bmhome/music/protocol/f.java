package com.larus.bmhome.music.protocol;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.block.MusicCreationContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f extends MusicCreationContent {
    public final transient String a;

    public f() {
        this.a = "";
    }

    public f(String r2, String r3, String r4, Image r5, String r6, String r7, String r8, String r9, String r10) {
        this.a = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        setVideoModel(r2);
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        setTitle(r3);
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        setLyrics(r4);
        setCover(r5);
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        setShareInfo(r6);
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        setCoverMainColor(r7);
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        setVid(r8);
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        setLyricsSeekContent(r9);
        setContentType(2);
        this.a = r10;
    }
}
