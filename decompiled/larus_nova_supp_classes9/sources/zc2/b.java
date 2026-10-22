package zc2;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetStickerInfoResultModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.v2;
import com.bytedance.android.livesdk.chatroom.viewmodule.w2;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.ta;
import w20.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends x2<ta, LiveGetStickerInfoResultModel> {
    public b() {
    }

    public final void invoke(Object r5, CallContext r6) {
        ta r7 = (ta) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        w2 r8 = v2.a();
        String r9 = r7.a();
        if (r9 == null) goto L7;
        Long r10 = StringsKt.toLongOrNull(r9);
        if (r10 == null) goto L7;
        long r2 = r10.longValue();
    L9:
        if (r2 == (-1)) goto L17;
        if (r8 == null) goto L17;
        int r11 = r8.wm(r2);
        LiveGetStickerInfoResultModel r13 = new LiveGetStickerInfoResultModel();
        r13.a(LiveGetStickerInfoResultModel.Code.Success);
        boolean r0 = true;
        if (r11 == 1) goto L16;
        r0 = false;
    L16:
        r13.b(Boolean.valueOf(r0));
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
        return;
    L17:
        LiveGetStickerInfoResultModel r15 = new LiveGetStickerInfoResultModel();
        r15.a(LiveGetStickerInfoResultModel.Code.Failed);
        r15.b(Boolean.FALSE);
        Unit r16 = Unit.INSTANCE;
        finishWithResult(r15);
        return;
    L7:
        r2 = -1;
        goto L9
    }
}
