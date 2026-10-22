package ga1;

import android.os.Parcelable;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.WebHybridParamVo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public c() {
    }

    public final Parcelable a(ia1.b r16, boolean r17) {
        ja1.a r1 = r16.d;
        if (r1 != null) goto L5;
        r1 = new ja1.a(r16.b, r16.a, r16.c);
    L5:
        String r3 = "";
        String r12 = (String) r1.a("referer", "");
        int r5 = ((Number) r1.a("bundle_sale_show_status", -1)).intValue();
        Boolean r2 = Boolean.FALSE;
        boolean r6 = ((Boolean) r1.a("bundle_no_hw_acceleration", r2)).booleanValue();
        boolean r7 = ((Boolean) r1.a("bundle_enable_app_cache", r2)).booleanValue();
        boolean r8 = ((Boolean) r1.a("bundle_user_webview_title", r2)).booleanValue();
        String r9 = (String) r1.a("wap_headers", "");
        boolean r10 = ((Boolean) r1.a("bundle_load_no_cache", r2)).booleanValue();
        boolean r13 = ((Boolean) r1.a("bundle_live_webview_offline_enable", Boolean.TRUE)).booleanValue();
        if (r17 == false) goto L9;
        BaseHybridParamVo r0 = null;
    L10:
        WebHybridParamVo r4 = new WebHybridParamVo(r5, r6, r7, r8, r9, r10, r13, r12, r0, false);
        String r14 = "H5ParamsParse->getFullScreenVo: " + r4;
        if (r14 == null) goto L14;
        r3 = r14;
    L14:
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", r3);
        return r4;
    L9:
        r0 = com.bytedance.android.live.schema.helper.a.a(r16.a, r16.b, r16.c, r1);
        goto L10
    }
}
