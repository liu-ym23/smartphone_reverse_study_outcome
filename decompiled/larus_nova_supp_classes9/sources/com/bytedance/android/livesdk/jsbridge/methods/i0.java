package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.CommentPinResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.IPinService;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.h8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "commentPin")
public final class i0 extends w20.a0<h8, CommentPinResultModel> {
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

    public i0() {
    }

    public final void invoke(Object r6, CallContext r7) {
        h8 r8 = (h8) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        ALogger.d("CommentPinMethod", "receive params: uid=" + r8.f() + ", nickName=" + r8.d() + ", msgId=" + r8.c() + ", content=" + r8.a() + ", scene=" + r8.e() + ", contentType=" + r8.b());
        Disposable r9 = this.a;
        if (r9 == null) goto L5;
        r9.dispose();
    L5:
        this.a = xs2.b.a().b(d42.a.class).subscribe(new j0(this));
        String r10 = r8.c();
        if (r10 == null) goto L8;
        CastLongProtector.parseLong(r10);
    L8:
        String r11 = r8.e();
        String r0 = BuildConfig.FLAVOR;
        if (r11 != null) goto L12;
    L17:
        String r1 = BuildConfig.FLAVOR;
    L18:
        String r13 = r8.b();
        if (r13 != null) goto L22;
    L27:
        IPinService r14 = (IPinService) jc1.k.n(IPinService.class);
        CommentPinContent r2 = new CommentPinContent();
        r2.setContent(r8.a());
        String r3 = r8.c();
        if (r3 == null) goto L30;
        long r4 = CastLongProtector.parseLong(r3);
    L31:
        r2.setCommentMsgId(r4);
        r2.setNickName(r8.d());
        String r15 = r8.f();
        if (r15 != null) goto L34;
        r15 = "0";
    L34:
        r2.setCommenterId(r15);
        r2.setScene(r1);
        r2.setContentType(r0);
        Unit r16 = Unit.INSTANCE;
        r14.pinComment(r2);
        return;
    L30:
        r4 = 0;
        goto L31
    L22:
        if (r13.hashCode() != 570709177) goto L27;
        if (r13.equals("gift_word") == false) goto L27;
        r0 = "gift_word";
        goto L27
    L12:
        if (r11.hashCode() != (-1622852519)) goto L17;
        r1 = "gift_msg_board";
        if (r11.equals("gift_msg_board") == false) goto L17;
        goto L17
    }
}
