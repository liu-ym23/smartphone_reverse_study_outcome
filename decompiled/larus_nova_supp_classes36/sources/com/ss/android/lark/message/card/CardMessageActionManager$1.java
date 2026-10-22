package com.ss.android.lark.message.card;

import com.bytedance.lark.pb.openplatform.v1.GetUuidResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class CardMessageActionManager$1 extends UIGetDataCallback<rrb.a> {
    final /* synthetic */ com.ss.android.lark.message.card.a this$0;
    final /* synthetic */ long val$actionStartTime;
    final /* synthetic */ com.ss.android.lark.message.card.a.C0179a val$cardMsgAction;

    public class a implements SdkSender.IParser<String> {
        public a() {
        }

        public final Object parse(byte[] r3) throws IOException {
            return "c-" + ((GetUuidResponse) GetUuidResponse.ADAPTER.decode(r3)).uuid;
        }
    }

    public class b implements SdkSender.IParser<String> {
        public b() {
        }

        public final Object parse(byte[] r3) throws IOException {
            return "c-" + ((GetUuidResponse) GetUuidResponse.ADAPTER.decode(r3)).uuid;
        }
    }

    public void onErrored(ErrorResult r3) {
        StringBuilder r0 = new StringBuilder("onPutActionError, errorResult: ");
        r0.append(r3);
        r0.append(", msgId: ");
        this.val$cardMsgAction.getClass();
        r0.append(null);
        r0.append(", actionId: ");
        this.val$cardMsgAction.getClass();
        r0.append(null);
        Log.e(r0.toString());
        this.this$0.getClass();
        this.val$cardMsgAction.getClass();
        throw null;
    }

    public void onSuccessed(rrb.a r1) {
        this.this$0.getClass();
        this.val$cardMsgAction.getClass();
        throw null;
    }

    public /* bridge */ /* synthetic */ void onSuccessed(Object r1) {
        onSuccessed((rrb.a) r1);
    }

    public CardMessageActionManager$1(com.ss.android.lark.message.card.a r1, com.ss.android.lark.message.card.a.C0179a r2, long r3) {
        this.this$0 = r1;
        this.val$cardMsgAction = r2;
        this.val$actionStartTime = r3;
    }
}
