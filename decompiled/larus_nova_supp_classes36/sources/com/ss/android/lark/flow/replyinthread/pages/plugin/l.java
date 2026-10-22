package com.ss.android.lark.flow.replyinthread.pages.plugin;

import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ ReplyInThreadMsgTipsPlugin b;
    public final /* synthetic */ UIGetDataCallback<List<MessageInfo>> c;

    public l(String r1, ReplyInThreadMsgTipsPlugin r2, UIGetDataCallback<List<MessageInfo>> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.ss.android.lark.im.sdk.service.b r0 = new com.ss.android.lark.im.sdk.service.b(this.a);     // Catch: Throwable -> L8
        com.ss.android.lark.im.sdk.service.p r1 = ImSdkService.f();     // Catch: Throwable -> L8
        CallbackManager r2 = ((BaseChatPlugin) this.b).b;     // Catch: Throwable -> L8
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("callBackManager");     // Catch: Throwable -> L8
        r2 = null;
    L6:
        r1.e8(r0, (IGetDataCallback) r2.wrapAndAddCallback(this.c));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
