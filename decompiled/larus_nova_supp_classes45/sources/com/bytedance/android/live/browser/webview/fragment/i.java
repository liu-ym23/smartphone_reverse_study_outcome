package com.bytedance.android.live.browser.webview.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.IH5AssistService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.livesdk.config.tq;
import com.bytedance.android.livesdk.config.us;
import com.bytedance.android.livesdkapi.base.ILiveBrowserFragment;
import com.bytedance.android.livesdkapi.base.ILiveWebCommonApi;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements ILiveBrowserFragment {
    public final HybridFragment a;
    public final ILiveBrowserFragment b;

    public final void setDialogFragment(DialogFragment r1) {
    }

    public final void setEnableTouchEventCheck(boolean r1) {
    }

    public final void setOnPageLoadListener(ILiveWebCommonApi.OnPageLoadListener r1) {
    }

    public final Fragment getFragment() {
        ILiveBrowserFragment r0 = this.b;
        HybridFragment r1 = this.a;
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFragment();
    }

    public final View getHybridView() {
        ILiveBrowserFragment r0 = this.b;
        HybridFragment r1 = this.a;
        if (r1 != null) goto L5;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.getHybridView();
    L5:
        return r1.getHybridView();
    }

    public final void onBackPressed() {
        ILiveBrowserFragment r0 = this.b;
        HybridFragment r1 = this.a;
        if (r1 != null) goto L5;
        if (r0 == null) goto L16;
        r0.onBackPressed();
        return;
    L16:
        return;
    L5:
        if (r1.canBackPresse() == true) goto L7;
        return;
    L7:
        if (this.a.canBack() == false) goto L9;
        this.a.back();
        return;
    L9:
        this.a.close();
    }

    public i(Bundle r5) {
        BaseHybridParamVo r0 = r5.getParcelable("hybrid_pop_vo");
        if (r0 == null) goto L9;
        if (TextUtils.isEmpty(r0.o) == true) goto L9;
        Uri r1 = UriProtector.parse(r0.o);
    L22:
        com.bytedance.android.live.browser.a r2 = new com.bytedance.android.live.browser.a(null);
        HybridFragment r3 = ((IBrowserService) jc1.k.f(IBrowserService.class)).getHybridFragment(jc1.a.b(), r1, r2, r5);
        this.a = r3;
        if (((Boolean) us.a.getValue()).booleanValue() == false) goto L27;
        if (r3 != null) goto L28;
        this.b = ((IH5AssistService) jc1.k.f(IH5AssistService.class)).createSaaSDeprecatedBrowserFragment(r5);
        return;
    L28:
        return;
    L27:
        return;
    L9:
        if (((Boolean) us.a.getValue()).booleanValue() == false) goto L12;
        this.b = ((IH5AssistService) jc1.k.f(IH5AssistService.class)).createSaaSDeprecatedBrowserFragment(r5);
        return;
    L12:
        String r4 = r5.getString(LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) tq.a.getValue()).booleanValue() == false) goto L21;
        Uri.Builder r6 = x6.a.a(r4);
        if (r5.getBoolean("use_anniex_container", false) == false) goto L18;
        r6.appendQueryParameter("mix_container_type", "annie");
    L18:
        if (r5.getBoolean("disable_bounces", false) == false) goto L20;
        r6.appendQueryParameter("disable_bounces", GamePromoteDataContext.GAME_TYPE_MOBILE);
    L20:
        r1 = r6.build();
        goto L22
    L21:
        r1 = x6.a.b(r4);
        goto L22
    }
}
