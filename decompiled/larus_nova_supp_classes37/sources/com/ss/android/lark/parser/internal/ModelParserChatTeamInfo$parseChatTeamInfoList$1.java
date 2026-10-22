package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.ChatTeamInfo;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class ModelParserChatTeamInfo$parseChatTeamInfoList$1 extends FunctionReferenceImpl implements Function1<ChatTeamInfo, com.ss.android.lark.chat.entity.chat.ChatTeamInfo> {
    public ModelParserChatTeamInfo$parseChatTeamInfoList$1(Object r8) {
        super(1, r8, ModelParserChatTeamInfo.class, "parseChatTeamInfo", "parseChatTeamInfo(Lcom/bytedance/lark/pb/basic/v1/ChatTeamInfo;)Lcom/ss/android/lark/chat/entity/chat/ChatTeamInfo;", 0);
    }

    public final com.ss.android.lark.chat.entity.chat.ChatTeamInfo invoke(ChatTeamInfo r6) {
        ModelParserChatTeamInfo r0 = ModelParserChatTeamInfo.a;
        if (r6 == null) goto L5;
        Long r1 = r6.team_id;
    L6:
        if (r1 == null) goto L10;
        long r2 = r6.team_id.longValue();
        TeamChatType.a r3 = TeamChatType.Companion;
        int r4 = r6.team_chat_type.getValue();
        r3.getClass();
        return new com.ss.android.lark.chat.entity.chat.ChatTeamInfo(r2, TeamChatType.a.a(r4), r6.discoverable.booleanValue());
    L10:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ChatTeamInfo) r1);
    }
}
