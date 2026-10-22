package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.GiftMessageBoardLinkmicResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import w20.u9;
import w20.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "giftMessageBoardLinkmic")
public final class q extends z1<u9, GiftMessageBoardLinkmicResultModel> {
    public Disposable a;

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.ies.web.jsbridge2.f*/.onDestroy();
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public q() {
    }

    public final void invoke(Object r9, CallContext r10) {
        u9 r11 = (u9) r9;
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "context");
        ALogger.d("GiftMessageBoardLinkmicMethod", "receive params: uid=" + r11.g() + ", secUid=" + r11.f() + ", isActive=" + r11.h() + ", isSubscriber=" + r11.i() + ", inRoom=" + r11.d() + ", messageBoardId=" + r11.e() + ", content=" + r11.a() + ", giftId=" + r11.b() + ", giftMoney=" + r11.c());
        Disposable r12 = this.a;
        if (r12 == null) goto L5;
        r12.dispose();
    L5:
        this.a = xs2.b.a().b(jd0.b.class).subscribe(new r(this));
        IMessageBoardInfo r6 = (IMessageBoardInfo) vh7.f.c(IMessageBoardInfo.class);
        String r13 = r11.e();
        long r0 = 0;
        if (r13 == null) goto L8;
        long r2 = CastLongProtector.parseLong(r13);
    L9:
        r6.setId(r2);
        String r14 = r11.a();
        String r3 = "";
        if (r14 != null) goto L12;
        r14 = "";
    L12:
        Intrinsics.checkNotNullParameter(r6, "$this$setMsgBoardContent");
        Intrinsics.checkNotNullParameter(r14, "content");
        r6.setContent(r14);
        String r15 = r11.b();
        if (r15 == null) goto L15;
        r0 = CastLongProtector.parseLong(r15);
    L15:
        r6.setGiftId(r0);
        if ((r6 instanceof MessageBoardInfo) == true) goto L18;
        IMessageBoardInfo r16 = null;
    L19:
        MessageBoardInfo r17 = (MessageBoardInfo) r16;
        if (r17 == null) goto L26;
        Integer r1 = r11.c();
        if (r1 == null) goto L24;
        int r4 = r1.intValue();
    L25:
        r17.setGiftMoney(r4);
        goto L26
    L24:
        r4 = 0;
    L26:
        xs2.b r18 = xs2.b.a();
        String r5 = r11.g();
        if (r5 != null) goto L29;
        r5 = "";
    L29:
        String r7 = r11.f();
        if (r7 == null) goto L33;
        r3 = r7;
    L33:
        Boolean r8 = r11.h();
        if (r8 == null) goto L36;
        boolean r19 = r8.booleanValue();
    L37:
        Boolean r20 = r11.i();
        if (r20 == null) goto L40;
        boolean r21 = r20.booleanValue();
    L41:
        Boolean r22 = r11.d();
        if (r22 == null) goto L44;
        boolean r23 = r22.booleanValue();
    L45:
        r18.post(new jd0.c(r5, r3, r19, r21, r23, r6));
        return;
    L44:
        r23 = false;
        goto L45
    L40:
        r21 = false;
        goto L41
    L36:
        r19 = false;
        goto L37
    L18:
        r16 = r6;
        goto L19
    L8:
        r2 = 0;
        goto L9
    }
}
