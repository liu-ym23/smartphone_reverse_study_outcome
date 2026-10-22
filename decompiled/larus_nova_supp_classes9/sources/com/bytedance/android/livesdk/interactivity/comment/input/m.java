package com.bytedance.android.livesdk.interactivity.comment.input;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements IMiddlewareHostBusiness.AwemeVideoPlayFragmentCallback {
    public final /* synthetic */ VideoCommentSearchFragment a;

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

    public m(VideoCommentSearchFragment r1) {
        this.a = r1;
    }

    public final void onResumePlay(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        if ("click".equals(r3) == false) goto L9;
        VideoCommentSearchFragment r4 = this.a;
        if (r2 != null) goto L7;
        r2 = "0L";
    L7:
        String r0 = VideoCommentSearchFragment.O;
        r4.ca0(r2, "play");
        return;
    }

    public final void onPausePlay(String r4, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        if ("click".equals(r7) == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        String r6 = "0L";
    L8:
        long r8 = CastLongProtector.parseLong(r6);
        if (r8 <= 0) goto L15;
        VideoCommentSearchFragment r0 = this.a;
        String r1 = VideoCommentSearchFragment.O;
        int r9 = r0.Y90(r8);
        int r10 = r0.H;
        int r2 = r0.I;
        if (r10 > r9) goto L15;
        if (r2 < r9) goto L15;
        r0.M = r9;
    L15:
        VideoCommentSearchFragment r11 = this.a;
        if (r4 != null) goto L18;
        r4 = "0L";
    L18:
        String r13 = VideoCommentSearchFragment.O;
        r11.ca0(r4, "pause");
        return;
    L7:
        r6 = r4;
        goto L8
    }
}
