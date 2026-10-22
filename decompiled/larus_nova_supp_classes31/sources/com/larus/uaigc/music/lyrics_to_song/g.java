package com.larus.uaigc.music.lyrics_to_song;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g extends xc8.b {
    public final Message e;

    public final int d() {
        if (this.e.getContentType() != 70) goto L7;
        return 0;
    L7:
        if (this.e.getContentType() != 72) goto L10;
        return 3;
    L10:
        return -1;
    }

    public g(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "songMessage");
        super(r2);
        this.e = r2;
    }
}
