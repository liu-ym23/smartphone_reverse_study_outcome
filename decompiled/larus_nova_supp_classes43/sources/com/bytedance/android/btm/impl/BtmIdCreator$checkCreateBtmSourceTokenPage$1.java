package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.b;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class BtmIdCreator$checkCreateBtmSourceTokenPage$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ com.bytedance.android.btm.api.model.c $btmItem;
    final /* synthetic */ Object $page;

    public BtmIdCreator$checkCreateBtmSourceTokenPage$1(Object r1, com.bytedance.android.btm.api.model.c r10) {
        this.$page = r1;
        this.$btmItem = r10;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        String r0 = BtmPageRecorder.a;
        PageInfo r1 = BtmPageRecorder.j(b.b);
        r10.putOpt("page_class_name", this.$page.getClass().getCanonicalName());
        Object r11 = b.b;
        if (r11 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r10.putOpt("top_page_class_name", r11.getClass().getCanonicalName());
        if (r1 == null) goto L8;
        String r12 = r1.getPageBtm();
    L9:
        r10.putOpt("top_page_btm", r12);
        r10.putOpt("btm", this.$btmItem.a);
        r10.putOpt(com.bytedance.android.ec.core.event.a.KEY_MSG, "发起跳转页面不是顶部页面，可能导致btm链路缺失节点！");
        return;
    L8:
        r12 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
