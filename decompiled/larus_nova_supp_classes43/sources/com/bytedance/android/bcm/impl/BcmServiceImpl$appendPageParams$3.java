package com.bytedance.android.bcm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl.model.BcmPageInfo;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BcmServiceImpl$appendPageParams$3 extends Lambda implements Function0<String> {
    final /* synthetic */ String $biz;
    final /* synthetic */ BcmParams $content;
    final /* synthetic */ PageInfo $pageInfo;

    public BcmServiceImpl$appendPageParams$3(PageInfo r1, String r10, BcmParams r11) {
        this.$pageInfo = r1;
        this.$biz = r10;
        this.$content = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m489invoke() {
        StringBuilder r0 = new StringBuilder();
        if (this.$pageInfo != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(' ');
        r0.append(this.$pageInfo instanceof BcmPageInfo);
        r0.append(' ');
        r0.append(this.$biz);
        r0.append(' ');
        r0.append(this.$content);
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m489invoke();
    }
}
