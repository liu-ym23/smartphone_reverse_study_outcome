package com.larksuite.component.card.protocol.context.action;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.IGetDataCallback;
import dz7.b;
import dz7.c;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH&¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/protocol/context/action/CardActionService;", "Ljava/io/Serializable;", "sendRequest", "", "context", "Lcom/larksuite/component/card/protocol/context/action/CardActionContext;", "cardActionRequestParams", "Lcom/larksuite/component/card/protocol/context/action/CardActionRequestParams;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/protocol/context/action/UniversalCardPutActionResponse;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface CardActionService extends Serializable {
    public static final String ACTION_ID = "action_id";
    public static final String CARD_ID = "card_id";
    public static final String CONTENT_VERSION = "content_version";
    public static final a Companion = null;
    public static final String IS_EPHEMERAL = "is_ephemeral";

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }

    void sendRequest(dz7.a r1, b r2, IGetDataCallback<c> r3);
}
