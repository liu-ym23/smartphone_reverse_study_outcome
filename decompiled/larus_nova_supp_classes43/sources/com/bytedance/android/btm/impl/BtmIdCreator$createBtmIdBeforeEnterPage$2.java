package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmIdCreator$createBtmIdBeforeEnterPage$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Ref.ObjectRef $page;
    final /* synthetic */ Ref.ObjectRef $pageInfo;

    public BtmIdCreator$createBtmIdBeforeEnterPage$2(Ref.ObjectRef r1, Ref.ObjectRef r10) {
        this.$page = r1;
        this.$pageInfo = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m608invoke() {
        return "Use top page backup, page:" + this.$page.element + ", pageInfo:" + ((PageInfo) this.$pageInfo.element);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m608invoke();
    }
}
