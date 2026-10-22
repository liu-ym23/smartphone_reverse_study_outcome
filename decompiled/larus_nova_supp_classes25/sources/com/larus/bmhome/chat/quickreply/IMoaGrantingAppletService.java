package com.larus.bmhome.chat.quickreply;

import android.content.Context;
import com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import mi8.g;
import mi8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/quickreply/IMoaGrantingAppletService;", "", "createCardView", "Lcom/larus/bmhome/chat/quickreply/IMoaGrantingCardView;", "context", "Landroid/content/Context;", "prepare", "", "request", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingPrepareRequest;", "operate", "Lcom/larus/bmhome/chat/quickreply/MoaGrantingOperateRequest;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IMoaGrantingAppletService {
    void a(g r1);

    PermissionApplyCardView b(Context r1);

    void c(h r1);
}
