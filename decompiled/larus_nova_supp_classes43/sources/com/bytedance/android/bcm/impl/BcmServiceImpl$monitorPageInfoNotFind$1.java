package com.bytedance.android.bcm.impl;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BcmServiceImpl$monitorPageInfoNotFind$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $biz;
    final /* synthetic */ BcmParams $content;
    final /* synthetic */ PageFinder $finder;
    final /* synthetic */ String $pageClassName;
    final /* synthetic */ String $resumedPageBtm;
    final /* synthetic */ String $resumedPageClassName;
    final /* synthetic */ String $type;

    public BcmServiceImpl$monitorPageInfoNotFind$1(String r1, String r10, BcmParams r11, PageFinder r12, String r13, String r14, String r15) {
        this.$type = r1;
        this.$pageClassName = r10;
        this.$content = r11;
        this.$finder = r12;
        this.$biz = r13;
        this.$resumedPageBtm = r14;
        this.$resumedPageClassName = r15;
        super(1);
    }

    public final void invoke(JSONObject r12) {
        r12.put("api", this.$type);
        r12.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, this.$pageClassName);
        BcmParams r0 = this.$content;
        String r1 = "null";
        if (r0 == null) goto L11;
        Map<String, Object> r10 = r0.toMap();
        if (r10 == null) goto L11;
        Set<String> r11 = r10.keySet();
        if (r11 == null) goto L11;
        String r13 = CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, null, 62, null);
        if (r13 == null) goto L11;
    L12:
        r12.put("keys", r13);
        int r14 = com.bytedance.android.btm.impl.util.c.a;
        r12.put("finder", com.bytedance.android.btm.impl.util.c.b(this.$finder));
        String r15 = this.$biz;
        if (r15 == null) goto L15;
        r1 = r15;
    L15:
        r12.put("biz", r1);
        r12.put("resumed_btm_page", this.$resumedPageBtm);
        r12.put("resumed_page_name", this.$resumedPageClassName);
        return;
    L11:
        r13 = "null";
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
