package com.bytedance.android.btm.impl.pageshow;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class PageShowLog$send$1 extends Lambda implements Function0<String> {
    final /* synthetic */ boolean $isBack;
    final /* synthetic */ PageInfo $pic;
    final /* synthetic */ ResumeFuncOrigin $resumeFuncOrigin;
    final /* synthetic */ String $resumedPageId;

    public PageShowLog$send$1(PageInfo r1, boolean r10, ResumeFuncOrigin r11, String r12) {
        this.$pic = r1;
        this.$isBack = r10;
        this.$resumeFuncOrigin = r11;
        this.$resumedPageId = r12;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m895invoke() {
        PageShowLog r0 = PageShowLog.e;
        PageInfo r1 = this.$pic;
        JSONObject r10 = new JSONObject();
        r10.put("isBack", this.$isBack);
        r10.put("resumeFuncOrigin", this.$resumeFuncOrigin);
        r10.put("resumedPageId", this.$resumedPageId);
        return PageShowLog.d(r0, r1, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m895invoke();
    }
}
