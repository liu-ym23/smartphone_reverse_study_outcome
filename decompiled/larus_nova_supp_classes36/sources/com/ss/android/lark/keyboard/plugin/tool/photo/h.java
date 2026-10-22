package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.app.Activity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.checker.VideoSendChecker;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements VideoSendChecker.a {
    public final /* synthetic */ PhotoKBPlugin a;
    public final /* synthetic */ List<Photo> b;
    public final /* synthetic */ boolean c;

    public final void a(VideoSendChecker.Result r12, ArrayList<String> r13) {
        Intrinsics.checkNotNullParameter(r12, "result");
        Intrinsics.checkNotNullParameter(r13, "invalidList");
        Activity r2 = this.a.n().l().getContext();
        if (r2.isFinishing() == false) goto L5;
        return;
    L5:
        if (r2.isDestroyed() == false) goto L7;
        return;
    L7:
        if (r12 != VideoSendChecker.Result.VALID) goto L9;
        Log.i("PhotoKBPlugin", "all videos are valid");
        this.a.V(this.b, null, this.c);
        return;
    L9:
        Log.i("PhotoKBPlugin", "some videos are invalid, result: " + r12);
        PhotoKBPlugin r3 = this.a;
        List<Photo> r8 = this.b;
        boolean r10 = this.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "photos");
        Intrinsics.checkNotNullParameter(r12, "result");
        Intrinsics.checkNotNullParameter(r13, "invalidList");
        if (r3.Q() == false) goto L12;
        com.ss.android.lark.videosend.checker.a r0 = new k(r12, r8, r3, r10, r13);
    L13:
        r0.b(r2);
        return;
    L12:
        r0 = new j(r12, r3, r8, r13, r10);
        goto L13
    }

    public h(PhotoKBPlugin r1, List<Photo> r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
