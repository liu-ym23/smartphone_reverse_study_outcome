package com.larus.bmhome.bot.health;

import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.t0;
import com.larus.im.bean.bot.BotModel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/bot/health/IChatBotHealthService;", "", "showHealthTipFragmentDialog", "", "backListener", "Lkotlin/Function1;", "", "view", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "dismissDialog", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IChatBotHealthService {
    void a(t0 r1, WeakReference r2, FragmentManager r3, BotModel r4);

    void dismissDialog();
}
