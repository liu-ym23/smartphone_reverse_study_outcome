package com.ss.android.lark.flow.chat.message.block.sharegroup;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class FlowShareGroupChatHelper$4 implements IGetDataCallback<Boolean> {
    final /* synthetic */ TextView val$button;
    final /* synthetic */ Chat val$chat;
    final /* synthetic */ ShareGroupChatContent val$content;
    final /* synthetic */ Context val$context;
    final /* synthetic */ TextView val$hint;

    public void onError(ErrorResult r3) {
        if (TextUtils.isEmpty(r3.getDisplayMsg()) == true) goto L5;
        UDToast.show(this.val$context, r3.getDisplayMsg());
    L5:
        Log.e("FlowShareGroupChatHelper", r3.toString());
    }

    public void onSuccess(Boolean r3) {
        UDToast.show(this.val$context, 2131892133);
        ShareGroupChatContent.GroupState r4 = ShareGroupChatContent.GroupState.PENDING_APPROVAL;
        e.b(r4, this.val$button, this.val$hint);
        this.val$content.setJoinChatErrState(r4);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Boolean) r1);
    }

    public FlowShareGroupChatHelper$4(Context r1, Chat r2, TextView r3, TextView r4, ShareGroupChatContent r5) {
        this.val$context = r1;
        this.val$chat = r2;
        this.val$button = r3;
        this.val$hint = r4;
        this.val$content = r5;
    }
}
