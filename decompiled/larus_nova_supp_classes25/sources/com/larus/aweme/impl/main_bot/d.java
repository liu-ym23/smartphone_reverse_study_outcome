package com.larus.aweme.impl.main_bot;

import android.widget.ImageView;
import android.widget.TextView;
import com.larus.aweme.impl.databinding.LarusDouyinWrapperFragmentLayoutBinding;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements pr9.b {
    public final /* synthetic */ DouYinWrapperFragment a;

    public final void b(CustomFeedPlayerEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void onLoadError(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final pr9.d a() {
        this.a.getClass();
        return null;
    }

    public final void onLoadSuccess() {
        DouYinWrapperFragment r0 = this.a;
        LarusDouyinWrapperFragmentLayoutBinding r1 = r0.d;
        if (r1 == null) goto L7;
        TextView r2 = r1.g;
        if (r2 == null) goto L7;
        r2.setText(r0.requireActivity().getString(2131909748));
    L7:
        LarusDouyinWrapperFragmentLayoutBinding r3 = this.a.d;
        if (r3 == null) goto L12;
        TextView r4 = r3.g;
        if (r4 == null) goto L12;
        r4.setVisibility(0);
    L12:
        LarusDouyinWrapperFragmentLayoutBinding r5 = this.a.d;
        if (r5 == null) goto L18;
        ImageView r6 = r5.e;
        if (r6 == null) goto L19;
        r6.setVisibility(0);
        return;
    L19:
        return;
    }

    public d(DouYinWrapperFragment r1) {
        this.a = r1;
    }

    public final void c(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "aid");
        if (r2 == false) goto L16;
        DouYinWrapperFragment r4 = this.a;
        if (r4.e == true) goto L16;
        LarusDouyinWrapperFragmentLayoutBinding r5 = r4.d;
        if (r5 == null) goto L11;
        TextView r6 = r5.g;
        if (r6 == null) goto L11;
        r6.setVisibility(8);
    L11:
        LarusDouyinWrapperFragmentLayoutBinding r7 = this.a.d;
        if (r7 == null) goto L16;
        ImageView r8 = r7.e;
        if (r8 == null) goto L16;
        r8.setVisibility(8);
    L16:
        this.a.e = false;
    }
}
