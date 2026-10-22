package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioComposePageViewPager;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordViewV3;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements js0.b {
    public final /* synthetic */ AudioSectionController a;

    public c(AudioSectionController r1) {
        this.a = r1;
    }

    public final void onSuccess(String r3) {
        Intrinsics.checkNotNullParameter(r3, "track");
        TextView r4 = this.a.d;
        if (r4 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r4);
    L5:
        this.a.b.M(false);
        this.a.b.N(false);
        AudioSectionController r5 = this.a;
        if (r5.i == false) goto L9;
        r5.i = false;
        return;
    L9:
        MainThreadPostUtils.d(r5.g());
        AudioRecordViewV3 r6 = this.a.e;
        if (r6 == null) goto L12;
        r6.b();
    L12:
        AudioComposePageViewPager r7 = this.a.n;
        if (r7 == null) goto L15;
        r7.setCanScroll(true);
    L15:
        com.bytedance.android.livesdk.interactivity.comment.audio.c r8 = this.a.j;
        if (r8 == null) goto L18;
        r8.stopRecordAudio(false, true);
    L18:
        UIUtils.setViewVisibility(this.a.e, 8);
        AudioSectionController r9 = this.a;
        r9.g = false;
        r9.f = false;
    }
}
