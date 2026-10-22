package com.bytedance.android.btm.impl.pageshow;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class PageShowLog$getOffsetDuration$1 extends Lambda implements Function0<String> {
    final /* synthetic */ PageInfo $pageInfo;

    public PageShowLog$getOffsetDuration$1(PageInfo r1) {
        this.$pageInfo = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m886invoke() {
        StringBuilder r0 = new StringBuilder("page: ");
        r0.append(this.$pageInfo.getPageBtm());
        r0.append(", enterTime: ");
        r0.append(this.$pageInfo.getEnterTime());
        r0.append(", lastBtmPageShowTime: ");
        KProperty[] r1 = PageShowLog.a;
        r0.append(PageShowLog.d);
        return r0.toString();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m886invoke();
    }
}
