package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollAlign;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponentInner;
import com.ss.android.lark.log.Log;
import cya.d;
import f5b.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends ChatKeyboardEventHandler {
    public final Function0<MessageListAnimationContainer> f;
    public final Function0<IMessageListComponentInner> g;
    public final boolean h;
    public final int i;

    public final Pair<Integer, List<c<?>>> v() {
        Pair<Integer, List<c<?>>> r0 = TuplesKt.to(-1, CollectionsKt.emptyList());
        IMessageListComponentInner r1 = (IMessageListComponentInner) this.g.invoke();
        if (r1 != null) goto L5;
        return r0;
    L5:
        RecyclerView r2 = r1.getRecyclerView();
        if (r2 != null) goto L8;
        return r0;
    L8:
        LinearLayoutManager r3 = r2.getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == false) goto L11;
        LinearLayoutManager r4 = r3;
    L12:
        if (r4 != null) goto L14;
        return r0;
    L14:
        int r5 = r4.findLastVisibleItemPosition();
        List<c<?>> r6 = r1.h20();
        return TuplesKt.to(Integer.valueOf(r5), r6);
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final boolean c() {
        IMessageListComponentInner r0 = (IMessageListComponentInner) this.g.invoke();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.pI();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final MessageListAnimationContainer m() {
        return (MessageListAnimationContainer) this.f.invoke();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final void n() {
        Log.i("ChatKeyboardEventHandle", "onScrollToBottom: method called");
        IMessageListComponentInner r0 = (IMessageListComponentInner) this.g.invoke();
        if (r0 == null) goto L6;
        r0.sf(ScrollScene.KEYBOARD);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final m2b.a r() {
        IMessageListComponentInner r0 = (IMessageListComponentInner) this.g.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.W2();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final boolean j() {
        d r0 = com.ss.android.lark.keyboard.a.a(g());
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.c(6) != true) goto L8;
        r1 = true;
    L8:
        return !r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final boolean k() {
        Pair<Integer, List<c<?>>> r0 = v();
        if (((Number) r0.component1()).intValue() == (((List) r0.component2()).size() - 1)) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final int f() {
        return this.i;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final boolean h() {
        return this.h;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final boolean l(String r3) {
        Pair<Integer, List<c<?>>> r0 = v();
        int r1 = ((Number) r0.component1()).intValue();
        c r2 = (c) CollectionsKt.getOrNull((List) r0.component2(), r1);
        if (r2 == null) goto L5;
        String r4 = r2.c;
    L7:
        return Intrinsics.areEqual(r4, r3);
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final void o(String r8) {
        Intrinsics.checkNotNullParameter(r8, "messageId");
        IMessageListComponentInner r0 = (IMessageListComponentInner) this.g.invoke();
        if (r0 == null) goto L24;
        Iterator<Object> r1 = r0.FX().h().iterator();
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L16;
        Object r4 = r1.next();
        if ((r4 instanceof c) == true) goto L10;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == true) goto L17;
        r3 = r3 + 1;
    L17:
        if (r3 >= 0) goto L20;
        Log.w("ChatKeyboardEventHandle", "Message not found,id:" + r8);
        return;
    L20:
        com.ss.android.lark.biz.im.api.extension.scroll.c r9 = r0.Ar();
        com.ss.android.lark.biz.im.api.extension.scroll.d r2 = new com.ss.android.lark.biz.im.api.extension.scroll.d(ScrollScene.KEYBOARD);
        r2.c(r3);
        ScrollAlign r6 = ScrollAlign.BOTTOM;
        Intrinsics.checkNotNullParameter(r6, "value");
        r2.d = r6;
        r2.e = true;
        r9.f(r2.a());
        return;
    L10:
        if (Intrinsics.areEqual(((c) r4).c, r8) == false) goto L12;
        r5 = true;
        goto L13
    L16:
        r3 = -1;
        goto L17
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final void p(int r3) {
        super.p(r3);
        if (this.d == false) goto L6;
        Log.i("ChatKeyboardEventHandle", "onSetMessageListMargin: suppressMessageListMarginChange");
        return;
    L6:
        MessageListAnimationContainer r0 = (MessageListAnimationContainer) this.f.invoke();
        if (r0 == null) goto L13;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L12;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        r2.bottomMargin = r3;
        r0.setLayoutParams(r2);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        IMessageListComponentInner r4 = (IMessageListComponentInner) this.g.invoke();
        if (r4 == null) goto L19;
        RecyclerView r5 = r4.getRecyclerView();
        if (r5 == null) goto L20;
        r5.invalidateItemDecorations();
        return;
    L20:
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.component.keyboard.ChatKeyboardEventHandler
    public final void q(List<? extends hya.c<String, b>> r2) {
        Intrinsics.checkNotNullParameter(r2, "updaters");
        IMessageListComponentInner r0 = (IMessageListComponentInner) this.g.invoke();
        if (r0 == null) goto L6;
        r0.batchUpdateMsg(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<MessageListAnimationContainer> r2, Function0<? extends IMessageListComponentInner> r3) {
        Intrinsics.checkNotNullParameter(r2, "msgListAnimContainerProvider");
        Intrinsics.checkNotNullParameter(r3, "msgListProvider");
        this.f = r2;
        this.g = r3;
        this.h = true;
        this.i = 1;
    }
}
