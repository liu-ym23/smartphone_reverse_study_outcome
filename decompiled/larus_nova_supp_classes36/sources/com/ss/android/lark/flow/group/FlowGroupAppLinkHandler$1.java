package com.ss.android.lark.flow.group;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ChatQRCodeInfoResponse;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.group.page.FlowQRCodeGroupCardActivity;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class FlowGroupAppLinkHandler$1 implements IGetDataCallback<ChatQRCodeInfoResponse> {
    final /* synthetic */ e this$0;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$qrToken;

    public static /* synthetic */ void a(FlowGroupAppLinkHandler$1 r0, ErrorResult r1, int r2, Chat r3) {
        r0.lambda$onError$1(r1, r2, r3);
    }

    public static /* synthetic */ Chat b(String r0) {
        return lambda$onError$0(r0);
    }

    private static /* synthetic */ Chat lambda$onError$0(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        Log.e("FlowGroupAppLinkHandler", "execInIO, chatId is null or empty");
        return null;
    L7:
        return ImSdkService.b().we(r1);
    }

    public void onError(final ErrorResult r7) {
        Log.i("FlowGroupAppLinkHandler", "openGroupByQrCode error, " + r7.getCode() + ", " + r7.getMessage() + ", " + r7.getDebugMsg() + ", " + r7.getExtra());
        final int r0 = r7.getCode();
        if (r0 != 4011) goto L5;
    L8:
        e r2 = this.this$0;
        String r3 = r7.getExtra();
        r2.getClass();
        final String r4 = "";
        if (TextUtils.isEmpty(r3) == false) goto L17;
        Log.e("FlowGroupAppLinkHandler", "getChatIdFromExtra, extraStr is null or empty");
    L15:
        RxScheduledExecutor.execInIO(new c(r4), new d(this, r7, r0));
        return;
    L17:
        r4 = new JSONObject(r3).optString("chat_id", "");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Log.e("FlowGroupAppLinkHandler", "parse jsonObject error, " + th.getMessage());
        goto L15
    L5:
        if (r0 == 4018) goto L8;
        e r1 = this.this$0;
        Context r5 = this.val$context;
        r1.getClass();
        LKUIToast.show(r5, r7.getDisplayMsg(UIHelper.getString(2131891517)));
    }

    public void onSuccess(ChatQRCodeInfoResponse r8) {
        if (r8 != null) goto L4;
    L13:
        onError(new ErrorResult(""));
        return;
    L4:
        if (r8.getChat() == null) goto L13;
        boolean r0 = r8.isAlreadyInChat();
        Chat r2 = r8.getChat();
        Activity r1 = ImSdkProxy.b().getTopActivity();
        if (r1 == null) goto L11;
        if (r0 == false) goto L10;
        int r9 = a.a;
        String r10 = r2.getId();
        Chat.ChatMode r3 = r2.getChatMode();
        boolean r4 = r2.isSecret();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "chatId");
        Intrinsics.checkNotNullParameter(r3, "chatMode");
        ChatBundle.a r5 = new ChatBundle.a();
        r5.a = r10;
        r5.a(r3);
        r5.m = r4;
        r5.h = SourceType.SEARCH;
        ChatBundle r11 = new ChatBundle(r5);
        int r6 = FlowChatModule.d;
        FlowChatModule r7 = FlowChatModule.a.a();
        Intrinsics.checkNotNull(r11);
        r7.e(r1, r11, null);
        return;
    L10:
        int r12 = FlowQRCodeGroupCardActivity.b;
        FlowQRCodeGroupCardActivity.a.a(r1, r2, r8.getInviterId(), this.val$qrToken, false, false);
        return;
    L11:
        Log.e("FlowGroupAppLinkHandler", "activity is null");
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((ChatQRCodeInfoResponse) r1);
    }

    public FlowGroupAppLinkHandler$1(e r1, String r2, Context r3) {
        this.this$0 = r1;
        this.val$qrToken = r2;
        this.val$context = r3;
    }

    private void lambda$onError$1(ErrorResult r8, int r9, Chat r10) {
        Activity r1 = ImSdkProxy.b().getTopActivity();
        if (r1 == null) goto L16;
        if (r10 != null) goto L6;
        this.this$0.getClass();
        LKUIToast.show(r1, r8.getDisplayMsg(UIHelper.getString(2131891517)));
        return;
    L6:
        int r11 = FlowQRCodeGroupCardActivity.b;
        if (r9 != 4011) goto L9;
        boolean r5 = true;
    L11:
        if (r9 != 4018) goto L13;
        boolean r6 = true;
    L14:
        FlowQRCodeGroupCardActivity.a.a(r1, r10, "", "", r5, r6);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r5 = false;
        goto L11
    }
}
