package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenVSMessageBoardInputPanelResultModel;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.interact.OpenVSMsgBoardInputEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openVSMessageBoardInputPanel")
public final class m9 extends w20.v4<w20.vc, OpenVSMessageBoardInputPanelResultModel> implements OpenVSMsgBoardInputEvent.Callback {
    public final void onCancel() {
        OpenVSMessageBoardInputPanelResultModel r0 = new OpenVSMessageBoardInputPanelResultModel();
        r0.a(OpenVSMessageBoardInputPanelResultModel.Code.Success);
        r0.b(new OpenVSMessageBoardInputPanelResultModel.a());
        Unit r1 = Unit.INSTANCE;
        finishWithResult(r0);
    }

    public m9() {
    }

    public final void j(w20.vc r15) {
        xs2.b r0 = xs2.b.a();
        JsonObject r1 = r15.a();
        if (r1 == null) goto L7;
        JsonElement r2 = r1.get("source");
        if (r2 == null) goto L7;
        String r3 = r2.getAsString();
    L8:
        JsonObject r4 = r15.a();
        if (r4 == null) goto L13;
        JsonElement r5 = r4.get(FeedApi.SHOW_TYPE);
        if (r5 == null) goto L13;
        String r6 = r5.getAsString();
    L14:
        JsonObject r7 = r15.a();
        if (r7 == null) goto L19;
        JsonElement r8 = r7.get("gradient_type");
        if (r8 == null) goto L19;
        int r9 = r8.getAsInt();
    L20:
        JsonObject r11 = r15.a();
        if (r11 == null) goto L27;
        JsonElement r12 = r11.get("tab_type");
        if (r12 == null) goto L27;
        if (r12.getAsInt() != 0) goto L27;
        String r13 = "hot";
    L35:
        String r14 = r13;
        JsonObject r16 = r15.a();
        if (r16 == null) goto L40;
        JsonElement r17 = r16.get("parent_comment_id");
        if (r17 == null) goto L40;
        String r18 = r17.getAsString();
    L41:
        JsonObject r19 = r15.a();
        if (r19 == null) goto L46;
        JsonElement r21 = r19.get("reply_comment_id");
        if (r21 == null) goto L46;
        String r22 = r21.getAsString();
    L47:
        JsonObject r23 = r15.a();
        if (r23 == null) goto L52;
        JsonElement r24 = r23.get("reply_user_id");
        if (r24 == null) goto L52;
        String r110 = r24.getAsString();
    L53:
        JsonObject r25 = r15.a();
        if (r25 == null) goto L58;
        JsonElement r26 = r25.get("enter_from_merge");
        if (r26 == null) goto L58;
        String r111 = r26.getAsString();
    L59:
        JsonObject r27 = r15.a();
        if (r27 == null) goto L64;
        JsonElement r28 = r27.get("is_select_to_story");
        if (r28 == null) goto L64;
        boolean r112 = r28.getAsBoolean();
    L65:
        JsonObject r113 = r15.a();
        if (r113 == null) goto L70;
        JsonElement r114 = r113.get("title");
        if (r114 == null) goto L70;
        String r115 = r114.getAsString();
    L71:
        r0.post(new OpenVSMsgBoardInputEvent(this, r3, r6, r9, r14, r18, r22, r110, r111, r112, r115));
        return;
    L70:
        r115 = null;
    L64:
        r112 = false;
    L58:
        r111 = null;
    L52:
        r110 = null;
    L46:
        r22 = null;
    L40:
        r18 = null;
    L27:
        JsonObject r29 = r15.a();
        if (r29 == null) goto L34;
        JsonElement r31 = r29.get("tab_type");
        if (r31 == null) goto L34;
        if (r31.getAsInt() != 1) goto L34;
        r13 = "latest";
    L34:
        r13 = "";
    L19:
        r9 = 0;
    L13:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.vc r7 = (w20.vc) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L10;
        if (r1.isLogin() != true) goto L10;
        j(r7);
        return;
    L10:
        IUserService r2 = jc1.k.f(IUserService.class);
        if (r2 == null) goto L19;
        com.bytedance.android.livesdk.user.f r3 = r2.user();
        if (r3 == null) goto L20;
        Observable r4 = r3.login(r6.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a()));
        if (r4 == null) goto L21;
        r4.subscribe(new k9(this, r7, r6), new l9(this));
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void onSend(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        OpenVSMessageBoardInputPanelResultModel r9 = new OpenVSMessageBoardInputPanelResultModel();
        r9.a(OpenVSMessageBoardInputPanelResultModel.Code.Success);
        OpenVSMessageBoardInputPanelResultModel.a r0 = new OpenVSMessageBoardInputPanelResultModel.a();
        r0.c(r2);
        r0.b(r3);
        r0.g(r4);
        r0.a(r5);
        r0.d(r6);
        r0.e(r7);
        r0.f(r7);
        Unit r11 = Unit.INSTANCE;
        r9.b(r0);
        finishWithResult(r9);
    }
}
