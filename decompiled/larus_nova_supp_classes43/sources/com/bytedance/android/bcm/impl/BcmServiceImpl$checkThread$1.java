package com.bytedance.android.bcm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.PageFinder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BcmServiceImpl$checkThread$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $biz;
    final /* synthetic */ PageFinder $finder;
    final /* synthetic */ String $resumedPageBtm;
    final /* synthetic */ String $resumedPageClassName;
    final /* synthetic */ String $type;

    public BcmServiceImpl$checkThread$1(String r1, PageFinder r10, String r11, String r12, String r13) {
        this.$type = r1;
        this.$finder = r10;
        this.$biz = r11;
        this.$resumedPageBtm = r12;
        this.$resumedPageClassName = r13;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        r10.put("type", this.$type);
        int r0 = com.bytedance.android.btm.impl.util.c.a;
        r10.put("finder", com.bytedance.android.btm.impl.util.c.b(this.$finder));
        String r1 = this.$biz;
        if (r1 != null) goto L6;
        r1 = "null";
    L6:
        r10.put("biz", r1);
        r10.put("resumed_btm_page", this.$resumedPageBtm);
        r10.put("resumed_page", this.$resumedPageClassName);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
