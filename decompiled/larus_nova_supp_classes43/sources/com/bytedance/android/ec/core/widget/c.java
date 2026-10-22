package com.bytedance.android.ec.core.widget;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.common.util.UriUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final void a(ECDraweeView r0, String r1, Integer r10) {
        if (r1 == null) goto L4;
        com.bytedance.android.ec.core.utils.y.d(r0, r1);
        return;
    L4:
        if (r10 == null) goto L8;
        com.bytedance.android.ec.core.utils.y.d(r0, UriUtil.getUriForResourceId(r10.intValue()).toString());
        return;
    }
}
