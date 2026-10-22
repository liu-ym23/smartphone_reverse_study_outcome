package com.larus.extension.chat_extension.impl.ltm;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.bot.ltm.IChatBotLtmService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/FlowSaaSBotLtmServiceImpl;", "Lcom/larus/bmhome/bot/ltm/IChatBotLtmService;", "<init>", "()V", "showLtmHintFragmentDialog", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "botId", "", "conversationId", "previousPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FlowSaaSBotLtmServiceImpl implements IChatBotLtmService {
    public FlowSaaSBotLtmServiceImpl() {
    }

    public final void a(FragmentManager r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "fragmentManager");
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r9, "conversationId");
        Intrinsics.checkNotNullParameter(r10, "previousPage");
        ChatLtmHitFragment r2 = new ChatLtmHitFragment();
        Bundle r3 = new Bundle();
        r3.putString("currentPage", "chat");
        r3.putString("previousPage", r10);
        r3.putString("botID", r8);
        r3.putString("conversationId", r9);
        r2.setArguments(r3);
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "ChatLtmHitFragment", r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r2, r11) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r7, "ChatLtmHitFragment");
        return;
    }
}
