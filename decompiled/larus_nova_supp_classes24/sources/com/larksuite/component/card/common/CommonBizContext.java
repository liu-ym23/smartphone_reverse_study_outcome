package com.larksuite.component.card.common;

import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.google.gson.JsonObject;
import com.larksuite.component.card.protocol.context.BizContext;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larksuite/component/card/common/CommonBizContext;", "Lcom/larksuite/component/card/protocol/context/BizContext;", "bizId", "", "<init>", "(Ljava/lang/String;)V", "toJson", "Lcom/google/gson/JsonObject;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CommonBizContext extends BizContext {
    @Override // com.larksuite.component.card.protocol.context.BizContext
    public JsonObject toJson() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("biz_id", getBizId());
        r0.addProperty("biz_type", Integer.valueOf(getBizType().getValue()));
        return r0;
    }

    public CommonBizContext(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bizId");
        super(r2, UniversalCardBizType.BIZ_TYPE_UNKNOWN);
    }
}
