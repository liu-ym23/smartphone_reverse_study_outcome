package com.larus.bmhome.video.fragment;

import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w implements VideoPlayView.a {
    public final /* synthetic */ BaseVideoDetailFragment<ViewBinding> a;

    public w(BaseVideoDetailFragment<ViewBinding> r1) {
        this.a = r1;
    }

    public final void a(String r4) {
        FLogger.a.i(this.a.tag(), "User click play");
        this.a.ca0(false);
        boolean r0 = x19.a.a;
        x19.a.a = false;
        VideoPlayView.a r1 = this.a.u.f;
        if (r1 == null) goto L6;
        r1.a(r4);
        return;
    }

    public final void onPause(String r4) {
        FLogger.a.i(this.a.tag(), "User click pause");
        VideoPlayView.a r0 = this.a.u.f;
        if (r0 == null) goto L6;
        r0.onPause(r4);
        return;
    }
}
