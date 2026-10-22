package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu;

import android.content.Intent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.SwipeActionHandler;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.SwipeActionItemDecoration;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager;
import com.ss.android.lark.chat.message.menu.v2.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import t6b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListMenuFeature implements com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a {
    public static final /* synthetic */ int h = 0;
    public final g a;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b b;
    public s2b.c c;
    public boolean d;
    public final List<com.ss.android.lark.biz.im.api.extension.chat_window.g<Object>> e;
    public RecyclerView f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a m() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r0 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a) r0.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a.class);
    }

    public MessageListMenuFeature(g r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        this.a = r2;
        this.d = true;
        this.e = new CopyOnWriteArrayList();
        this.g = LazyKt.lazy(new MessageListMenuFeature$menuHandlerHub$2(this));
    }

    public static final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a l(MessageListMenuFeature r1) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2 = r1.b;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r2 = null;
    L6:
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a) r2.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.a.class);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a
    public final void D6(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.f = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r19) {
        Intrinsics.checkNotNullParameter(r19, "initData");
        Intrinsics.checkNotNullParameter(r19, "initData");
        RecyclerView r5 = this.f;
        boolean r1 = true;
        if (r5 != null) goto L5;
        Log.e("MessageListMenuFeature", "recyclerView not set");
    L20:
        if (this.a.g() == false) goto L58;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r3 = this.b;
        if (r3 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r3 = null;
    L25:
        s2b.d r12 = r3.a();
        if (r12 == null) goto L59;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r4 = this.b;
        if (r4 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r4 = null;
    L31:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r2 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r4.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r2 == null) goto L57;
        RecyclerView r6 = r2.getRecyclerView();
        if (r6 == null) goto L60;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.f r7 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe.f(r12, new d(this));
        SwipeActionHandler r8 = new SwipeActionHandler(r12, r12.c.C(), new c(this), new e(this), new f(this), r7);
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        RecyclerView r9 = r8.j;
        if (r9 == null) goto L42;
        r9.removeOnItemTouchListener(r8.o);
        SwipeActionItemDecoration r10 = r8.p;
        if (r10 == null) goto L41;
        r9.removeItemDecoration(r10);
    L41:
        r9.removeOnChildAttachStateChangeListener(r8.q);
    L42:
        r8.j = null;
        jdb.g r11 = r8.b;
        if (r11 != null) goto L45;
    L47:
        r1 = false;
    L48:
        if (r1 == false) goto L61;
        SwipeActionItemDecoration r13 = new SwipeActionItemDecoration(r6, r8.m);
        r8.p = r13;
        r6.addOnItemTouchListener(r8.o);
        r6.addItemDecoration(r13);
        r6.addOnChildAttachStateChangeListener(r8.q);
        r8.j = r6;
        r8.k = ViewConfiguration.get(r6.getContext()).getScaledTouchSlop();
        return;
    L61:
        return;
    L45:
        if (r11.isEnable("messenger.swipe.reply") != true) goto L47;
    L60:
        return;
    L57:
        return;
    L59:
        return;
    L58:
        return;
    L5:
        b r14 = new b(this);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r15 = this.b;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r15 = null;
    L8:
        v r16 = r15.getContainer();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r17 = this.b;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r17 = null;
    L11:
        this.c = new s2b.c(r16, r5, r17.a(), (com.ss.android.lark.chat.chatwindow.chat.menu.handler.b) this.g.getValue(), r14, this.a);
        if ((!((CopyOnWriteArrayList) this.e).isEmpty()) == false) goto L20;
        Iterator r18 = ((CopyOnWriteArrayList) this.e).iterator();
    L15:
        if (r18.hasNext() == false) goto L20;
        com.ss.android.lark.biz.im.api.extension.chat_window.g<Object> r20 = (com.ss.android.lark.biz.im.api.extension.chat_window.g) r18.next();
        s2b.c r21 = this.c;
        if (r21 == null) goto L15;
        MessageActionPanelManager<y6b.c<?>> r22 = r21.f;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r20, "interceptor");
        r22.B.add(r20);
        goto L15
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.b = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a
    public final boolean B(y6b.c r4, com.ss.android.lark.chat.message.menu.context.a r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r5, "itemHook");
        s2b.c r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r4.K != MessageStreamStatus.Transport) goto L11;
        return true;
    L11:
        return r0.f.e(r4, r5);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a
    public final z D(y6b.c r2, com.ss.android.lark.chat.message.menu.context.a r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "itemHook");
        s2b.c r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f.i(r2, r3);
    }

    public final void F(String r4, int r5, PartialReplyInfo r6) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = m();
        if (r0 == null) goto L26;
        MessageInfo r7 = r0.getMessageInfoById(r4);
        if (r7 == null) goto L26;
        if (r6 == null) goto L13;
        RichText r1 = r6.getContent();
        if (r1 == null) goto L13;
        RichTextExtraInfo r2 = r1.getExtraInfo();
        if (r2 == null) goto L13;
        boolean r3 = Intrinsics.areEqual(r2.isPartialReplySelectTextEmpty(), Boolean.TRUE);
    L14:
        if (r3 == false) goto L17;
        Log.e(TitlebarViewModel.LOG_TAG, "onReplyMessage: isPartialReplySelectTextEmpty is true, stops reply message and returns null");
        return;
    L17:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r8 = this.b;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r8 = null;
    L20:
        IMessageListComponent.e r9 = r8.getDependency();
        if (r9 == null) goto L28;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.d.b r10 = r9.a();
        if (r10 == null) goto L29;
        r10.j(r7, r5, r6);
        return;
    L29:
        return;
    L28:
        return;
    L13:
        r3 = false;
    L26:
        Log.e(TitlebarViewModel.LOG_TAG, "onReEditMessage: get msg by id returns null");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a
    public final void u(y6b.c r5, com.ss.android.lark.chat.message.menu.context.a r6, List r7) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r6, "itemHook");
        Intrinsics.checkNotNullParameter(r7, "messageActionList");
        s2b.c r2 = this.c;
        if (r2 == null) goto L6;
        MessageActionPanelManager<y6b.c<?>> r3 = r2.f;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "item");
        Intrinsics.checkNotNullParameter(r6, "itemHook");
        Intrinsics.checkNotNullParameter(r7, "messageActionList");
        r3.h(r5, r6, MessageActionPanelManager.c(r5), r7);
        return;
    }
}
