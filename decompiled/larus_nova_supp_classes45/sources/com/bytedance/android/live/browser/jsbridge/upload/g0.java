package com.bytedance.android.live.browser.jsbridge.upload;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 implements o60.e {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ CallContext b;
    public final /* synthetic */ i0 c;

    @Override // o60.e
    public final void onPermissionDenied(String... r3) {
        UIUtils.displayToastWithIcon(this.b.getContext(), 2131250233, 2131916011);
        this.c.finishWithFailure();
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r3) {
        int r4 = this.a.optInt("duration_limit", 10);
        Intent r0 = new Intent("android.media.action.VIDEO_CAPTURE");
        r0.putExtra("android.intent.extra.durationLimit", r4);
        r0.putExtra("android.intent.extra.videoQuality", 1);
        Fragment r5 = this.c.b;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getActivity() != null) goto L8;
        this.c.finishWithFailure();
        return;
    L8:
        this.c.b.startActivityForResult(r0, 9001);
    }

    public g0(i0 r1, JSONObject r2, CallContext r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
