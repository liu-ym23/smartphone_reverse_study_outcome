package com.bytedance.android.btm.impl.page.lifecycle.layer3;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmPageLifecycleCallbackV2$pollBufferAndPutSourceBtm$2 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Ref.ObjectRef $bufferBtm;
    final /* synthetic */ BufferBtm $pageBuffer;

    public BtmPageLifecycleCallbackV2$pollBufferAndPutSourceBtm$2(BufferBtm r1, Ref.ObjectRef r10) {
        this.$pageBuffer = r1;
        this.$bufferBtm = r10;
        super(1);
    }

    public final void invoke(JSONObject r10) {
        r10.put("type", 1);
        Lazy r0 = BtmFormatUtils.a;
        r10.put("page_buffer_btm", BtmFormatUtils.h(this.$pageBuffer.getBtm()));
        r10.put("buffer_btm", BtmFormatUtils.h(((BufferBtm) this.$bufferBtm.element).getBtm()));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
