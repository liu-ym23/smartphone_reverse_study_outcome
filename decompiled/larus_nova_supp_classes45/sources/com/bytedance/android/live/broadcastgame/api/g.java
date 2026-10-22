package com.bytedance.android.live.broadcastgame.api;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcastgame.api.interactgame.IAudienceGameDataService;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static FragmentActivity a(Context r2) {
        IAudienceGameDataService r0 = (IAudienceGameDataService) k.f(IAudienceGameDataService.class);
        if (r0 == null) goto L14;
        if (r0.isGameFullPanelShowing() != true) goto L14;
        Activity r1 = k.n(IMiddlewareHostApp.class).getTopActivity();
        if ((r1 instanceof FragmentActivity) == true) goto L9;
        r1 = null;
    L9:
        FragmentActivity r3 = (FragmentActivity) r1;
        if (r3 == null) goto L12;
        return r3;
    L12:
        return ContextUtil.contextToFragmentActivity(r2);
    L14:
        return ContextUtil.contextToFragmentActivity(r2);
    }
}
