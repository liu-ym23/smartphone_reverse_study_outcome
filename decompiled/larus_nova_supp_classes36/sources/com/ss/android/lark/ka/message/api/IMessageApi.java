package com.ss.android.lark.ka.message.api;

import android.content.Context;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.ka.message.api.callback.Callback;
import com.ss.android.lark.ka.message.api.model.Message;
import com.ss.android.lark.ka.message.api.model.MessageInfo;
import com.ss.android.lark.message.action.model.ActionMessage;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.plugin.annotation.ScopeType;
import com.ss.android.lark.plugin.annotation.TrimisScope;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@TrimisScope(ScopeType.USER)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J*\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\rH&J\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/ka/message/api/IMessageApi;", "", "forward", "", "context", "Landroid/content/Context;", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/ka/message/api/model/Message;", "getMessageResource", "actionMessages", "", "Lcom/ss/android/lark/message/action/model/ActionMessage;", "callback", "Lcom/ss/android/lark/ka/message/api/callback/Callback;", "Lcom/ss/android/lark/ka/message/api/model/MessageInfo;", "downloadResource", "messageInfo", "message-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface IMessageApi {
    void downloadResource(MessageInfo r1, Callback<Message> r2);

    void forward(Context r1, Message r2);

    void getMessageResource(List<? extends ActionMessage> r1, Callback<List<MessageInfo>> r2);
}
