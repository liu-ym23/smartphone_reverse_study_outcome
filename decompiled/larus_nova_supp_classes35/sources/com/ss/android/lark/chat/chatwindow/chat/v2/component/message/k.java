package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chatbase.BasePageStore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements z0 {
    public final v a;
    public final fxa.b b;

    public k(v r2, fxa.b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "chatBundle");
        this.a = r2;
        this.b = r3;
    }

    public final y0 a(BasePageStore r14, x4b.d r15, x4b.d r16, CallbackManager r17, String r18, MutableLiveData r19, int r20) {
        Intrinsics.checkNotNullParameter(r14, "pageStore");
        Intrinsics.checkNotNullParameter(r15, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(r16, "workExecutor");
        Intrinsics.checkNotNullParameter(r17, "callbackManager");
        Intrinsics.checkNotNullParameter(r18, "chatId");
        Intrinsics.checkNotNullParameter(r19, "currentChatLiveData");
        if ((r14 instanceof q3b.m) == false) goto L7;
        return new j((q3b.m) r14, this.a, this.b, r15, r16, r17, r18, r19, r20);
    L7:
        throw new IllegalStateException("Invalid data store:".concat(r14.getClass().getName()));
    }
}
