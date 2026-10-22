package com.bytedance.android.live.revlink.link.infra.lifecontrol;

import com.bytedance.android.livesdk.link.model.a5;
import com.bytedance.android.livesdk.message.model.v8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import yh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class PKLongBizHandler$attach$1 extends FunctionReferenceImpl implements Function1<c, Unit> {
    public PKLongBizHandler$attach$1(PKLongBizHandler r8) {
        super(1, r8, PKLongBizHandler.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(c r4) {
        PKLongBizHandler r0 = (PKLongBizHandler) ((CallableReference) this).receiver;
        r0.getClass();
        if (r4 != null) goto L6;
        return;
    L6:
        if ((r4 instanceof v8) == false) goto L21;
        a5 r5 = (a5) ((vh7.c) r4).castTo(a5.class);
        int r1 = r5.getEndReason();
        if (r1 == 1) goto L18;
        if (r1 != 6) goto L12;
        r0.b(r5);
        return;
    L12:
        if (r1 == 8) goto L18;
        if (r1 == 11) goto L18;
        return;
    L18:
        if (r0.b == false) goto L23;
        r0.b(r5);
        return;
    L23:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c) r1);
        return Unit.INSTANCE;
    }
}
