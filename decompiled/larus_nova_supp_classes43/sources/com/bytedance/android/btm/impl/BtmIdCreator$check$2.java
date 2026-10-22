package com.bytedance.android.btm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.b;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmIdCreator$check$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ com.bytedance.android.btm.api.model.c $btmItem;
    final /* synthetic */ boolean $fromSourceBtmToken;

    public BtmIdCreator$check$2(com.bytedance.android.btm.api.model.c r1, boolean r10) {
        this.$btmItem = r1;
        this.$fromSourceBtmToken = r10;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        Lazy r0 = BtmFormatUtils.a;
        r10.put("btm", BtmFormatUtils.h(this.$btmItem.a));
        int r1 = com.bytedance.android.btm.impl.util.c.a;
        r10.put("finder", com.bytedance.android.btm.impl.util.c.b(this.$btmItem.e));
        Object r11 = b.b;
        if (r11 == null) goto L15;
        String r12 = BtmPageRecorder.a;
        PageInfo r13 = BtmPageRecorder.j(r11);
        String r14 = "null";
        if (r13 == null) goto L9;
        String r15 = r13.getPageBtm();
        if (r15 == null) goto L9;
    L10:
        r10.put("resumed_btm_page", r15);
        String r16 = r11.getClass().getCanonicalName();
        if (r16 == null) goto L13;
        r14 = r16;
    L13:
        r10.put("resumed_page_name", r14);
    L9:
        r15 = "null";
    L15:
        if (this.$btmItem.a() == true) goto L17;
        return;
    L17:
        if (this.$fromSourceBtmToken == false) goto L19;
        String r17 = "1";
    L20:
        r10.put("is_source_btm_token", r17);
        return;
    L19:
        r17 = "0";
        goto L20
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
