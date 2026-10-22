package com.larus.bmhome.chat.api;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H&J&\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\u0014\u001a\u00020\u0003H&J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0005H&¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/chat/api/IAppletGrantingWidgetService;", "", "bindData", "Lcom/larus/bmhome/chat/api/CardModel;", "permissionData", "", "msgData", "Lcom/larus/bmhome/chat/api/MsgData;", "delegate", "Ljava/lang/ref/WeakReference;", "Lcom/larus/bmhome/chat/api/Delegate;", "unbindData", "", "onExpose", "onUnexpose", "operateResult", "agree", "", "weakReference", "Landroid/content/Context;", "cardModel", "onNewMessageInput", "latestMsgID", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IAppletGrantingWidgetService {
    void a(String r1);

    void b(boolean r1, WeakReference<Context> r2, f r3);

    f c(String r1, r0 r2, WeakReference<k> r3);

    void d(r0 r1);

    void e(r0 r1);
}
