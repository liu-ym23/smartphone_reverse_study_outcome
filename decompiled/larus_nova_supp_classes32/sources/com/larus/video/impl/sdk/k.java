package com.larus.video.impl.sdk;

import com.larus.platform.api.l4;
import com.larus.utils.y;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ l4 b;

    public /* synthetic */ k(String r1, l4 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final String r0 = this.a;
        final l4 r1 = this.b;
        VideoRef r2 = new VideoRef();
        r2.extractFields(new JSONObject(r0));     // Catch: Throwable -> L5
    L7:
        VideoModel r3 = new VideoModel();
        r3.setVideoRef(r2);
        final a r4 = new a(r3);
        y.c(new l(r1, r0, r4));
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }
}
