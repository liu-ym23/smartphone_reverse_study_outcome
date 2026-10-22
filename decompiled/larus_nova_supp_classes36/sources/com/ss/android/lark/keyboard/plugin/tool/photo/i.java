package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.app.Activity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements VideoSendChecker.a {
    public final /* synthetic */ PhotoKBPlugin a;
    public final /* synthetic */ List<Photo> b;
    public final /* synthetic */ boolean c;

    public static final class a extends com.ss.android.lark.videosend.checker.c {
        public final /* synthetic */ List<Photo> b;
        public final /* synthetic */ PhotoKBPlugin c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ ArrayList<String> e;

        public final void d() {
            List<Photo> r0 = this.b;
            ArrayList<String> r1 = this.e;
            ArrayList r2 = new ArrayList();
            Iterator<T> r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r4 = r3.next();
            if ((!r1.contains(((Photo) r4).getPath())) == false) goto L4;
            r2.add(r4);
            goto L4
        L8:
            List<Photo> r5 = CollectionsKt.toMutableList(r2);
            PhotoKBPlugin r6 = this.c;
            boolean r7 = this.d;
            int r8 = PhotoKBPlugin.w;
            r6.K(r5, r7);
        }

        public a(VideoSendChecker.Result r1, List<Photo> r2, PhotoKBPlugin r3, boolean r4, ArrayList<String> r5) {
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            super(r1);
        }
    }

    public final void a(VideoSendChecker.Result r10, ArrayList<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "invalidList");
        Activity r0 = this.a.n().l().getContext();
        if (r0.isFinishing() == false) goto L5;
        return;
    L5:
        if (r0.isDestroyed() == false) goto L8;
        return;
    L8:
        if (r10 != VideoSendChecker.Result.VALID) goto L10;
        Log.i("PhotoKBPlugin", "all videos are valid, insert to input");
        this.a.K(this.b, this.c);
        return;
    L10:
        Log.i("PhotoKBPlugin", "some videos are invalid for insert, result: " + r10);
        new a(r10, this.b, this.a, this.c, r11).b(r0);
    }

    public i(PhotoKBPlugin r1, List<Photo> r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
