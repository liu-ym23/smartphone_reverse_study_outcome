package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleManager;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.AutoMuteMessageVisibleParams;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MyAIMessageVisibleParams;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.UnreadSummaryMessageVisibleParams;
import com.ss.android.lark.chat.entity.chat.AutoMuteConfig;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatUserAutoMuteSetting;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements Runnable {
    public final /* synthetic */ MessageListRendererFeature a;

    public l(MessageListRendererFeature r1) {
        this.a = r1;
    }

    public final void a() {
        MessageListRendererFeature r0 = this.a;
        RecyclerView r1 = r0.d;
        SceneCoordinateRecyclerView r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
        r1 = null;
    L5:
        LinearLayoutManager r3 = r1.getLayoutManager();
        int r4 = -1;
        if (r3 != null) goto L8;
    L10:
        int r5 = -1;
        int r6 = -1;
    L12:
        if (r6 != (-1)) goto L16;
        if (r5 != (-1)) goto L16;
        boolean r7 = false;
    L17:
        r0.u = r7;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a r8 = this.a.H();
        if (r8 != null) goto L20;
    L22:
        boolean r9 = false;
    L23:
        if (r9 == false) goto L68;
        final MessageListRendererFeature r10 = this.a;
        if (r10.u == true) goto L27;
        return;
    L27:
        if (r10.v == true) goto L70;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r11 = r10.c;
        if (r11 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r11 = null;
    L32:
        s2b.d r12 = r11.a();
        if (r10.s != null) goto L62;
        MessageVisibleHintPointParams.Builder r13 = new MessageVisibleHintPointParams.Builder(r12);
        LinkedList<Message.Type> r14 = new LinkedList();
        Intrinsics.checkNotNullParameter(r14, "types");
        r13.b = r14;
        Function0<com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.a> r15 = new MessageListRendererFeature$initializeMessageVisibleManagerIfNeed$1(r10);
        Intrinsics.checkNotNullParameter(r15, "provider");
        r13.c = r15;
        if (r12 != null) goto L37;
    L39:
        boolean r16 = false;
    L40:
        if (r12 != null) goto L42;
    L44:
        boolean r17 = false;
    L45:
        MyAIMessageVisibleParams r18 = new MyAIMessageVisibleParams(r16, r17);
        if (r12 == null) goto L48;
        Chat r19 = r12.getChat();
    L50:
        if (r19 == null) goto L53;
        Chat.Type r110 = r19.getType();
        if (r110 == null) goto L53;
    L54:
        if (r19 == null) goto L56;
        r4 = r19.getUserCount();
    L56:
        if (r19 == null) goto L60;
        ChatUserAutoMuteSetting r20 = r19.getUserAutoMuteSetting();
        if (r20 == null) goto L60;
        LinkedHashMap<Long, AutoMuteConfig> r21 = r20.getBotAutoMute();
    L61:
        r10.s = new MessageVisibleHintPointParams(r13.b, MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(MyAIMessageVisibleParams.class, r18), TuplesKt.to(AutoMuteMessageVisibleParams.class, new AutoMuteMessageVisibleParams(r110, r4, r21)), TuplesKt.to(UnreadSummaryMessageVisibleParams.class, new UnreadSummaryMessageVisibleParams(r13.c))}), null);
    L60:
        r21 = null;
    L53:
        r110 = Chat.Type.UNKNOWN;
        goto L54
    L48:
        r19 = null;
        goto L50
    L42:
        if (r12.d() != true) goto L44;
        r17 = true;
        goto L45
    L37:
        if (r12.isAIChat() != true) goto L39;
        r16 = true;
    L62:
        SceneCoordinateRecyclerView r22 = r10.d;
        if (r22 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mMessageRV");
    L66:
        r10.r = new MessageVisibleManager(r2, r10.s, new j(r10));
        r10.v = true;
        return;
    L65:
        r2 = r22;
        goto L66
    L70:
        return;
    L68:
        return;
    L20:
        if (r8.b0() != true) goto L22;
        r9 = true;
    L16:
        r7 = true;
        goto L17
    L8:
        if ((r3 instanceof LinearLayoutManager) == false) goto L10;
        LinearLayoutManager r23 = r3;
        r6 = r23.findFirstVisibleItemPosition();
        r5 = r23.findLastVisibleItemPosition();
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
