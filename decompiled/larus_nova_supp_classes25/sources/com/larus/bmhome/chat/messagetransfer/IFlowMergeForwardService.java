package com.larus.bmhome.chat.messagetransfer;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/messagetransfer/IFlowMergeForwardService;", "", "getDoubaoMessageDisplayText", "", "context", "Landroid/content/Context;", "payload", "", "deleteLocalDoubaoMessage", "", "openDoubaoMergeForwardPage", "request", "Lcom/larus/bmhome/chat/messagetransfer/FlowDoubaoMergeForwardRequest;", "prepareAskDoubao", "Lcom/larus/bmhome/chat/messagetransfer/FlowAskDoubaoResult;", "Lcom/larus/bmhome/chat/messagetransfer/FlowHumanMergeForwardRequest;", "fallbackTitle", "releasePreparedAskDoubao", "result", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IFlowMergeForwardService {
    d a(f r1, String r2);

    String b(d r1);

    boolean c(FragmentActivity r1, e r2);

    boolean d(byte[] r1);

    String e(Context r1, byte[] r2);
}
