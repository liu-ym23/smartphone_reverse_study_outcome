package com.ss.android.lark.chatwindow.view.preview;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.message.PreviewVideo;
import com.ss.android.lark.chat.video.VideoPreviewActivity;
import com.ss.android.lark.statistics.video_site.VideoSiteHitPoint;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends OnSingleClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PreviewVideo c;
    public final /* synthetic */ ImageSet d;
    public final /* synthetic */ d.b e;

    public final void onSingleClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intent r6 = new Intent(this.a.a, VideoPreviewActivity.class);
        r6.putExtra("preview_origin_url", this.b);
        PreviewVideo r0 = this.c;
        if (r0 == null) goto L5;
        Lazy r1 = VideoSiteHitPoint.a;
        PreviewVideo.Site r2 = r0.getSite();
        Intrinsics.checkNotNullParameter(r2, "site");
        ((o5c.b) VideoSiteHitPoint.a.getValue()).sendEvent("video_url_play", new JSONObject().put("video_source", VideoSiteHitPoint.a(r2)));
        r6.putExtra("preview_i_frame_url", this.c.getIFrameUrl());
        r6.putExtra("preview_vid", this.c.getVid());
    L5:
        r6.putExtra("preview_cover", this.d.getOrigin());
        Context r3 = this.a.a;
        if ((r3 instanceof Activity) == false) goto L8;
        ((Activity) r3).startActivity(r6, ActivityOptions.makeSceneTransitionAnimation(ContextsKt.requireActivity(r3), this.e.g, "show_video_share_element").toBundle());
        return;
    L8:
        r3.startActivity(r6);
    }

    public f(d r1, String r2, PreviewVideo r3, ImageSet r4, d.b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
