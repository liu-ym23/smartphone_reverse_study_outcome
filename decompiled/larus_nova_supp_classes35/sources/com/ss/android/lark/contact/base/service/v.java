package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetMyGroupChatsRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ GetMyGroupChatsRequest.Type b;
    public final /* synthetic */ IGetDataCallback c;
    public final /* synthetic */ y d;

    public final void a() {
        y r0 = this.d;
        int r1 = this.a;
        GetMyGroupChatsRequest.Type r2 = this.b;
        r0.getClass();
        GetMyGroupChatsRequest.Builder r3 = new GetMyGroupChatsRequest.Builder().type(r2).time(0L).count(Integer.valueOf(r1));
        List r4 = (List) SdkSender.syncSend(Command.GET_MY_GROUP_CHATS, r3, new w(r0));
        IGetDataCallback r5 = this.c;
        if (r5 == null) goto L8;
        if (r4 == null) goto L6;
        r5.onSuccess(r4);
        return;
    L6:
        r5.onError(new ErrorResult("local group list null"));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public v(y r1, GetMyGroupChatsRequest.Type r2, IGetDataCallback r3) {
        this.d = r1;
        this.a = 50;
        this.b = r2;
        this.c = r3;
    }
}
