package c72;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.comment.share.InteractivityShareAppLogger;
import com.bytedance.live.datacontext.j;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Unit;
import vh7.f;
import vlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ w22.a b;
    public final /* synthetic */ androidx.core.util.Consumer c;

    public a(long r1, w22.a r3, androidx.core.util.Consumer r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final void accept(Object r7) {
        Response r8 = (Response) r7;
        com.bytedance.android.livesdk.interactivity.comment.share.model.c r0 = (com.bytedance.android.livesdk.interactivity.comment.share.model.c) ((BaseResponse) r8).data;
        if (r0 == null) goto L16;
        m1 r9 = f.c(m1.class);
        m0 r1 = f.c(m0.class);
        r1.setCreateTime(System.currentTimeMillis());
        r1.setRoomId(this.a);
        r1.setMessageId(-1);
        r1.setShowMsg(true);
        r1.setMessageId(r0.c());
        r1.setMethod("WebcastItemShareMessage");
        Unit r4 = Unit.INSTANCE;
        r9.setBaseMessage(r1);
        r9.setShareText(r0.a());
        r9.setItemStyle(r0.b());
        r9.setPublicAreaCommon(r0.d());
        r9.setTrackingParams(this.b.e);
        r9.setMessageMethod("WebcastItemShareMessage");
        IRoomContextService r2 = k.f(IRoomContextService.class);
        if (r2 == null) goto L13;
        o r3 = IRoomContextService.a.a(r2, null, 0, 3);
        if (r3 == null) goto L13;
        j r5 = r3.getMessageManager();
        if (r5 == null) goto L13;
        d r6 = (d) r5.getValue();
        if (r6 == null) goto L13;
        r6.j(r9, true);
    L13:
        InteractivityShareAppLogger.c(this.b);
        androidx.core.util.Consumer r10 = this.c;
        if (r10 == null) goto L23;
        r10.accept(Boolean.TRUE);
        return;
    L23:
        return;
    L16:
        RequestError r11 = ((BaseResponse) r8).error;
        if (r11 == null) goto L20;
        String r13 = r11.prompts;
        if (r13 == null) goto L20;
    L21:
        f2.c(r13, 0);
        return;
    L20:
        r13 = s1.B(2131923435);
        goto L21
    }
}
