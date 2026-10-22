package com.larus.bmhome.chat.larkforward;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.share.p0;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u001eJ\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H&J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0017J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0014H\u0016J4\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u001b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0017J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/larkforward/IChatLarkForwardService;", "", "deleteLarkMessagesInDoubao", "", "serMessages", "", "", "startForward", "context", "Landroid/content/Context;", "doubaoMsgIds", "", "callback", "Lcom/larus/bmhome/chat/larkforward/IChatLarkForwardService$ForwardCallback;", "openMergeForwardByHostMessageRef", "hostMessageRef", "", "openMergeForwardByDoubaoInput", "message", "openMergeForwardByDoubaoMsg", "Lcom/larus/im/bean/message/Message;", "openMergeForwardByDoubaoData", "doubaoMsgId", "subMsgIds", "contentByte", "Lokio/ByteString;", "forwardMergeForwardByHostMessageRef", "forwardDoubaoMergeForwardMsg", "releaseHostMessageRef", "", "ForwardCallback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IChatLarkForwardService {
    boolean B(List<byte[]> r1);

    boolean C(Context r1, List r2, ByteString r3);

    void D(String r1);

    boolean E(Context r1, String r2);

    boolean F(Context r1, List r2, p0 r3);

    boolean G(Context r1, String r2);

    boolean H(Context r1, Message r2);
}
