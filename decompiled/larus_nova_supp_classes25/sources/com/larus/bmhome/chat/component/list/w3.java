package com.larus.bmhome.chat.component.list;

import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.component.ext.ChatFragmentDelegateDialogExtKt;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.trace.tracknode.TraceFragment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w3 implements Function0 {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ List b;

    public /* synthetic */ w3(ChatListComponent r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        List r2 = this.b;
        int r1 = ChatListComponent.W3;
        FragmentManager r3 = a.c(r0).getChildFragmentManager();
        RecommendFrom r4 = r0.f1().d;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        TraceFragment r5 = com.larus.ui.arch.component.internal.attach.a.b(r0, r0);
        String r6 = null;
        if ((r5 instanceof TraceFragment) == false) goto L5;
        TraceFragment r7 = r5;
    L6:
        if (r7 == null) goto L8;
        String r8 = r7.k();
    L10:
        if (r0.f1().C() == false) goto L12;
        String r9 = "1";
    L13:
        String r10 = r9;
        SearchMobParam r11 = r0.f1().e;
        JSONObject r12 = new JSONObject();
        r12.put("conversation_id", r0.G4());
        r12.put("item_id", r0.getBotId());
        ChatControlTrace r13 = ChatControlTrace.b;
        wc9.e r14 = r0.R4();
        if (r14 == null) goto L16;
        Integer r15 = r14.v;
    L17:
        BotModel r16 = r0.j0();
        if (r16 == null) goto L20;
        Integer r17 = r16.getBotType();
    L21:
        BotModel r18 = r0.j0();
        if (r18 == null) goto L26;
        BotCreatorInfo r19 = r18.getBotCreatorInfo();
        if (r19 == null) goto L26;
        r6 = r19.getId();
    L26:
        r12.put("chat_type", r13.g(r15, r17, Intrinsics.areEqual(r6, AccountService.a.getUserId())));
        r12.put("group_type", "private");
        Unit r20 = Unit.INSTANCE;
        ChatFragmentDelegateDialogExtKt.d(r3, r2, r4, r8, 0, "", "", r10, r11, r12.toString(), null);
        return Unit.INSTANCE;
    L20:
        r17 = null;
        goto L21
    L16:
        r15 = null;
        goto L17
    L12:
        r9 = "0";
        goto L13
    L8:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
