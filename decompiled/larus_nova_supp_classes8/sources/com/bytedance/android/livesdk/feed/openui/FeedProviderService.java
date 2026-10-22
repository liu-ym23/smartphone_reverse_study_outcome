package com.bytedance.android.livesdk.feed.openui;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.feed.openui.view.LiveOuterFollowListView;
import jc1.k;
import ry.b;
import ry.d;
import ry.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class FeedProviderService implements d {
    public FeedProviderService() {
        k.l(d.class, this);
    }

    public b getFollowListView(Context r2, Bundle r3, f r4) {
        return new LiveOuterFollowListView(r2, r3, r4);
    }
}
