package com.larksuite.component.card.datachannel;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/larksuite/component/card/datachannel/UniversalCardDataObserver;", "Ljava/io/Serializable;", "notify", "", "bizId", "", "cardEntity", "Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface UniversalCardDataObserver extends Serializable {
    void notify(String r1, UniversalCardEntity r2);
}
