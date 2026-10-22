package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j extends com.ss.android.lark.videosend.checker.b {
    public final /* synthetic */ PhotoKBPlugin b;
    public final /* synthetic */ List<Photo> c;
    public final /* synthetic */ List<String> d;
    public final /* synthetic */ boolean e;

    public final void d() {
        Log.i("PhotoKBPlugin", "send image and valid video, invalid video will be sent as file");
        this.b.V(this.c, this.d, this.e);
    }

    public j(VideoSendChecker.Result r1, PhotoKBPlugin r2, List<Photo> r3, List<String> r4, boolean r5) {
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        super(r1);
    }
}
