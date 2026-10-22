package com.bytedance.android.btm.impl.pageshow;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class PageShowParamsChecker$checkParams$1 extends Lambda implements Function0<String> {
    final /* synthetic */ PageInfo $pageInfo;
    final /* synthetic */ String $ppreBtm;
    final /* synthetic */ String $preBtm;

    public PageShowParamsChecker$checkParams$1(PageInfo r1, String r10, String r11) {
        this.$pageInfo = r1;
        this.$preBtm = r10;
        this.$ppreBtm = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m900invoke() {
        PageShowLog r0 = PageShowLog.e;
        PageInfo r1 = this.$pageInfo;
        JSONObject r10 = new JSONObject();
        r10.put("preBtm", this.$preBtm);
        r10.put("ppreBtm", this.$ppreBtm);
        return PageShowLog.d(r0, r1, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m900invoke();
    }
}
