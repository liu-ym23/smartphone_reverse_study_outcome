package com.larus.bmhome.bot.ltm;

import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/bot/ltm/IChatBotLtmService;", "", "showLtmHintFragmentDialog", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "botId", "", "conversationId", "previousPage", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IChatBotLtmService {
    void a(FragmentManager r1, String r2, String r3, String r4);
}
