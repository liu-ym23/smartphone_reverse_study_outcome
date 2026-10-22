package com.bytedance.android.bcm.impl.chain;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkc/a;", "", "it", "Lorg/json/JSONObject;", "invoke", "(Lkc/a;Z)Lorg/json/JSONObject;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class BcmChainEventParamAppender$append$1 extends Lambda implements Function2<kc.a, Boolean, JSONObject> {
    final /* synthetic */ String $event;

    public BcmChainEventParamAppender$append$1(String r1) {
        this.$event = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((kc.a) r1, ((Boolean) r10).booleanValue());
    }

    public final JSONObject invoke(kc.a r10, boolean r11) {
        ChainUtilsKt.b(r10, r11, this.$event);
        return r10.a();
    }
}
