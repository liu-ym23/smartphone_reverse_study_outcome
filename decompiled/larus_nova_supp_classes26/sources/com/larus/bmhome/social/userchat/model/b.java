package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.showcase.Case;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements c0 {
    public final Case a;
    public List<Message> b;
    public ChatMessageReceiverModel.c c;

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void E4(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final boolean a() {
        return false;
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void b(vr8.b r1, Integer r2) {
        Intrinsics.checkNotNullParameter(r1, "callback");
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void c() {
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void clear() {
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void d(vr8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public b(Case r2) {
        Intrinsics.checkNotNullParameter(r2, "case");
        this.a = r2;
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final boolean O7(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        List<Message> r3 = this.b;
        if (r3 != null) goto L14;
    L24:
        return false;
    L14:
        if (r3.isEmpty() == false) goto L16;
    L15:
        boolean r6 = false;
    L22:
        if (r6 != true) goto L24;
        return true;
    L16:
        Iterator<T> r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((Message) r4.next()).getMessageId(), r5) == false) goto L18;
        r6 = true;
        goto L22
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void e(ChatListComponentViewModel.ChatListMessageChangeListener r50, ChatMessageReceiverModel.d r51, long r52, CoroutineScope r54) {
        Intrinsics.checkNotNullParameter(r50, "listener");
        this.c = r50;
        this.b = new ArrayList();
        List r1 = this.a.getMessageList();
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        Message r3 = (Message) r2.next();
        List<Message> r4 = this.b;
        if (r4 == null) goto L6;
        if (com.larus.bmhome.chat.bean.d.G0(r3) == false) goto L12;
        int r8 = 11;
    L13:
        Map r13 = r3.getBusinessExt();
        if (r13 != null) goto L16;
        r13 = new LinkedHashMap();
    L16:
        Map r15 = r13;
        r15.put("message_case_mode", "1");
        Unit r14 = Unit.INSTANCE;
        ArrayList r5 = (ArrayList) r4;
        r5.add(Message.copy$default(r3, null, null, null, 0, r8, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, r15, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194321, 31, null));
        goto L6
    L12:
        r8 = 21;
    L17:
        List<Message> r6 = this.b;
        boolean r7 = true;
        if (r6 == null) goto L22;
        ChatMessageReceiverModel.c r9 = this.c;
        if (r9 == null) goto L22;
        ChatMessageReceiverModel.c.a.a(r9, new com.larus.bmhome.social.page.datasource.event.c(r6, 0, CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(true))));
    L22:
        List<Message> r10 = this.b;
        if (r10 != null) goto L25;
    L28:
        if (r7 == false) goto L37;
        if (r54 == null) goto L38;
        BuildersKt.launch$default(r54, null, null, new CaseMessageReceiverModel$init$3(this, null), 3, null);
        return;
    L38:
        return;
    L37:
        return;
    L25:
        if (r10.isEmpty() == true) goto L28;
        r7 = false;
        goto L28
    }
}
