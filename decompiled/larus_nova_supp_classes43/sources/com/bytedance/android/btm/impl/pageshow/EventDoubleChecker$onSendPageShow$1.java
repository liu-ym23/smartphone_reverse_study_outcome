package com.bytedance.android.btm.impl.pageshow;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class EventDoubleChecker$onSendPageShow$1 extends Lambda implements Function0<String> {
    final /* synthetic */ boolean $contains;
    final /* synthetic */ PageInfo $pageInfo;

    public EventDoubleChecker$onSendPageShow$1(PageInfo r1, boolean r10) {
        this.$pageInfo = r1;
        this.$contains = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m881invoke() {
        return "reissue btm_enter_page showId=" + this.$pageInfo.getPageShowId() + " contains=" + this.$contains;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m881invoke();
    }
}
