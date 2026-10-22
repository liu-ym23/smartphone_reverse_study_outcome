package com.bytedance.android.livesdk.interactivity.comment.input;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback {
    public final /* synthetic */ VideoCommentPreviewFragment a;

    public final void onDismiss() {
    }

    public final void onPlayCompletedFirstTime(String r1) {
    }

    public final void onPlayFailed(String r1, String r2) {
    }

    public final void onPlaying(String r1) {
    }

    public final void onRenderFirstFrame(String r1) {
    }

    public final void onShow() {
    }

    public j(VideoCommentPreviewFragment r1) {
        this.a = r1;
    }

    public final void onResumePlay(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        this.a.v = true;
        if ("click".equals(r3) == false) goto L6;
        VideoCommentPreviewFragment.U90(this.a);
        return;
    }

    public final void onPausePlay(String r1, long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a.v = false;
        if ("click".equals(r4) == false) goto L6;
        VideoCommentPreviewFragment.U90(this.a);
        return;
    }
}
