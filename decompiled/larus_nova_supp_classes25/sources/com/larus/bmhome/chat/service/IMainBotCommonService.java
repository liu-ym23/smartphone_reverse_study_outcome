package com.larus.bmhome.chat.service;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SearchImageInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/service/IMainBotCommonService;", "", "getMessageImages", "", "Lcom/larus/im/bean/message/SearchImageInfo;", "message", "Lcom/larus/im/bean/message/Message;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IMainBotCommonService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/service/IMainBotCommonService$Companion;", "Lcom/larus/bmhome/chat/service/IMainBotCommonService;", "<init>", "()V", "getMessageImages", "", "Lcom/larus/im/bean/message/SearchImageInfo;", "message", "Lcom/larus/im/bean/message/Message;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class Companion implements IMainBotCommonService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IMainBotCommonService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.bmhome.chat.service.IMainBotCommonService
        public final List<SearchImageInfo> a(Message r2) {
            return this.b.a(r2);
        }

        private Companion() {
            IMainBotCommonService r0 = (IMainBotCommonService) ServiceManager.get().getService(IMainBotCommonService.class);
            if (r0 != null) goto L5;
            r0 = new MainBotCommonServiceNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    List<SearchImageInfo> a(Message r1);
}
