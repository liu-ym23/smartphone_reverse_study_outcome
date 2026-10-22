package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k extends com.ss.android.lark.videosend.checker.c {
    public final /* synthetic */ List<Photo> b;
    public final /* synthetic */ PhotoKBPlugin c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ List<String> e;

    public final void d() {
        Log.i("PhotoKBPlugin", "only send image and valid video");
        List<Photo> r0 = this.b;
        List<String> r1 = this.e;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((!r1.contains(((Photo) r4).getPath())) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        this.c.V(CollectionsKt.toMutableList(r2), null, this.d);
    }

    public k(VideoSendChecker.Result r1, List<Photo> r2, PhotoKBPlugin r3, boolean r4, List<String> r5) {
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        super(r1);
    }
}
