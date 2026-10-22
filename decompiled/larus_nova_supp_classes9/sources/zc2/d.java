package zc2;

import com.bytedance.android.live.browser.jsbridge.base.LiveRemoveStickerResultModel;
import com.bytedance.android.livesdk.chatroom.model.e3;
import com.bytedance.android.livesdk.chatroom.viewmodule.v2;
import com.bytedance.android.livesdk.chatroom.viewmodule.w2;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.ab;
import w20.g3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends g3<ab, LiveRemoveStickerResultModel> {
    public d() {
    }

    public final void invoke(Object r6, CallContext r7) {
        ab r8 = (ab) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        w2 r9 = v2.a();
        if (r9 == null) goto L5;
        e3 r0 = r9.Qn();
    L6:
        if (r0 != null) goto L8;
        LiveRemoveStickerResultModel.Code r10 = LiveRemoveStickerResultModel.Code.FetchStickerListFail;
        LiveRemoveStickerResultModel r11 = new LiveRemoveStickerResultModel();
        r11.a(r10);
        Unit r13 = Unit.INSTANCE;
        finishWithResult(r11);
        return;
    L8:
        String r14 = r8.a();
        if (r14 == null) goto L13;
        Long r15 = StringsKt.toLongOrNull(r14);
        if (r15 == null) goto L13;
        long r3 = r15.longValue();
    L15:
        if (r3 != (-1)) goto L17;
    L23:
        LiveRemoveStickerResultModel.Code r16 = LiveRemoveStickerResultModel.Code.NotFoundSticker;
        LiveRemoveStickerResultModel r17 = new LiveRemoveStickerResultModel();
        r17.a(r16);
        Unit r18 = Unit.INSTANCE;
        finishWithResult(r17);
        return;
    L17:
        if (r0.a(r3) == null) goto L23;
        boolean r19 = r9.fi(r3);
        LiveRemoveStickerResultModel r20 = new LiveRemoveStickerResultModel();
        Object r21 = bi1.a(Boolean.valueOf(r19), LiveRemoveStickerResultModel.Code.Success);
        LiveRemoveStickerResultModel.Code r1 = LiveRemoveStickerResultModel.Code.CanNotOperateSticker;
        if (r21 != null) goto L22;
        r21 = r1;
    L22:
        r20.a((LiveRemoveStickerResultModel.Code) r21);
        Unit r23 = Unit.INSTANCE;
        finishWithResult(r20);
        return;
    L13:
        r3 = -1;
        goto L15
    L5:
        r0 = null;
        goto L6
    }
}
