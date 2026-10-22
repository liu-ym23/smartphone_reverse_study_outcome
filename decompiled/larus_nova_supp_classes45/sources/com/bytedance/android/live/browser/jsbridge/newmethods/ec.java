package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.WebDialogFragmentForAnnie;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ec extends com.bytedance.ies.web.jsbridge2.g<a, Object> {
    public final BaseWebDialogFragment a;

    public static final class a {

        @SerializedName("args")
        C0115a args;

        @SerializedName("type")
        String type;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.newmethods.ec$a$a, reason: collision with other inner class name */
        public static final class C0115a {

            @SerializedName("close_by_mask")
            int close_by_mask;

            @SerializedName("height")
            int height;

            @SerializedName("radius")
            int radius;

            @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
            String url;

            @SerializedName("width")
            int width;

            public C0115a() {
            }
        }

        public a() {
        }
    }

    public ec(WebDialogFragmentForAnnie r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8, CallContext r9) throws Exception {
        a r11 = (a) r8;
        if (TextUtils.equals("webview_popup", r11.type) == false) goto L6;
        a.C0115a r12 = r11.args;
        this.a.W90(r12.url, r12.width, r12.height, r12.radius, r12.close_by_mask, BaseHybridParamVo.HybridType.H5);
        return null;
    L6:
        if (TextUtils.equals("lynxview_popup", r11.type) == false) goto L8;
        a.C0115a r13 = r11.args;
        this.a.W90(r13.url, r13.width, r13.height, r13.radius, r13.close_by_mask, BaseHybridParamVo.HybridType.LYNX);
        return null;
    L8:
        terminate();
        return null;
    }
}
