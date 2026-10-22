package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.widget.EditText;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/flow/replyinthread/pages/plugin/ReplyInThreadKeyboardPlugin$initKeyBoardReplyStatus$callback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chatwindow/model/data/ReplyInfo;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ReplyInThreadKeyboardPlugin$initKeyBoardReplyStatus$callback$1 implements IGetDataCallback<i7b.c> {
    final /* synthetic */ ReplyInThreadKeyboardPlugin this$0;

    public ReplyInThreadKeyboardPlugin$initKeyBoardReplyStatus$callback$1(ReplyInThreadKeyboardPlugin r1) {
        this.this$0 = r1;
    }

    public void onError(ErrorResult r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        Log.e("ReplyInThreadKeyboard", "get reply info is null, err = " + r3.getDisplayMsg());
    }

    public void onSuccess(i7b.c r2) {
        if (r2 != null) goto L5;
        Log.e("ReplyInThreadKeyboard", "reply info is null");
        return;
    L5:
        IKeyboardComponent r3 = this.this$0.i;
        if (r3 == null) goto L15;
        com.ss.android.lark.keyboard.b r4 = r3.n();
        if (r4 == null) goto L16;
        com.ss.android.lark.keyboard.keyboard2.b r5 = r4.L();
        if (r5 == null) goto L17;
        EditText r6 = r5.c();
        if (r6 == null) goto L18;
        r6.requestFocus();
        r6.setSelection(r6.length());
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((i7b.c) r1);
    }
}
