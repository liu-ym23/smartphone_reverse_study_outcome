package re;

import com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements be.b {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // be.b
    public final void onClickPromotion(String r10, String r11, String r12, JSONObject r13) {
        ILiveRoomFunctionHandler r0 = this.a.a;
        if ((r0 instanceof ILiveRoomFunctionHandler) == false) goto L10;
        if (r0 == null) goto L8;
        r0.getLogger(ILivePromotionActionListener.class).onClickPromotion(r10, r11, r12, r13);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.room.handler.ILiveRoomFunctionHandler");
    L10:
        throw new Exception("realHandler must be ILiveRoomFunctionHandler");
    }
}
