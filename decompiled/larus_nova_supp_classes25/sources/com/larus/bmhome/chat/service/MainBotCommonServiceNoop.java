package com.larus.bmhome.chat.service;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/service/MainBotCommonServiceNoop;", "Lcom/larus/bmhome/chat/service/IMainBotCommonService;", "<init>", "()V", "getMessageImages", "", "Lcom/larus/im/bean/message/SearchImageInfo;", "message", "Lcom/larus/im/bean/message/Message;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MainBotCommonServiceNoop implements IMainBotCommonService {
    public MainBotCommonServiceNoop() {
    }

    @Override // com.larus.bmhome.chat.service.IMainBotCommonService
    public final List<SearchImageInfo> a(Message r1) {
        return CollectionsKt.emptyList();
    }
}
