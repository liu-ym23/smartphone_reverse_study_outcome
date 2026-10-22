package com.larus.chat.search.impl.chat;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.api.model.SectionViewType;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.r2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import tx9.i3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p implements lz8.a {
    public final /* synthetic */ ChatSearchFragment a;

    public p(ChatSearchFragment r1) {
        this.a = r1;
    }

    @Override // lz8.a
    public final void a(SectionItemData r33) {
        Intrinsics.checkNotNullParameter(r33, "data");
        if (r33.getViewType() != SectionViewType.EXTERNAL) goto L12;
        Function0<Unit> r1 = r33.getUrlJumpCallback();
        if (r1 == null) goto L7;
        r1.invoke();
    L7:
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L51;
        r2 r3 = r2.A0();
        if (r3 == null) goto L52;
        r3.a(this.a.getContext(), UriProtector.parse(r33.getUrl()));
        return;
    L52:
        return;
    L51:
        return;
    L12:
        String r4 = r33.getConversationId();
        boolean r5 = false;
        if (r4 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        String r7 = null;
        if (r6 == false) goto L32;
        ChatSearchFragment r8 = this.a;
        int r9 = ChatSearchFragment.A;
        r8.getClass();
        String r10 = r33.getMessageId();
        if (r10 != null) goto L24;
    L25:
        r5 = true;
    L26:
        if (r5 == true) goto L55;
        wc9.e r11 = r8.Z90().getConversation();
        BotModel r12 = r8.Z90().getBotModel();
        long r13 = r33.getLocalIndex();
        if (r33.isSectionName() == false) goto L31;
        r7 = r33.getMessageId();
    L31:
        r8.ga0();
        r8.ca0(r11, r12, r13, r7, null);
        i3.e(null, null, "bot_setting_search", null, null, null, null, "chat_history_session", "user_and_bot", "chat_search", null, r8, 25591);
        return;
    L55:
        return;
    L24:
        if (r10.length() != 0) goto L26;
    L32:
        ChatSearchFragment r14 = this.a;
        int r15 = ChatSearchFragment.A;
        r14.getClass();
        String r16 = r33.getConversationId();
        if (r16 != null) goto L35;
    L38:
        boolean r17 = true;
    L39:
        if (r17 == true) goto L56;
        r14.ga0();
        String r18 = r33.getConversationId();
        if (r18 != null) goto L44;
    L45:
        r5 = true;
    L46:
        if (r5 == true) goto L49;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new ChatSearchFragment$openSubConversation$1(r18, r14, null), 3, null);
    L49:
        i3.e(null, "default_new", "bot_setting_search", null, null, null, null, "chat_history_session", "user_and_bot", "chat_search", null, r14, 25589);
        return;
    L44:
        if (r18.length() != 0) goto L46;
    L56:
        return;
    L35:
        if (r16.length() == 0) goto L38;
        r17 = false;
        goto L39
    L15:
        if (r4.length() == 0) goto L18;
        r6 = false;
        goto L19
    }
}
