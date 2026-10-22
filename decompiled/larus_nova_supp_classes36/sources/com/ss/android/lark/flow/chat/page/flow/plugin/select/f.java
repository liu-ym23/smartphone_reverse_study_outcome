package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import android.content.Context;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.biz.im.api.extension.message.MultiSelectContext;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements MultiSelectContext {
    public final /* synthetic */ FlowMessageSelectPlugin a;

    public final boolean a() {
        IMessageListComponent r0 = this.a.j;
        Object r1 = null;
        if (r0 == null) goto L5;
        List r2 = r0.gK();
    L6:
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        Iterator r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        if (((y6b.c) r4).p0 == false) goto L10;
        r1 = r4;
    L14:
        if (r1 == null) goto L16;
        return true;
    L16:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final CallbackManager b() {
        FlowMessageSelectPlugin r0 = this.a;
        int r1 = FlowMessageSelectPlugin.f0;
        CallbackManager r2 = ((BaseChatPlugin) r0).b;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("callBackManager");
        return null;
    L7:
        return r2;
    }

    public final void c() {
        FlowMessageSelectPlugin r0 = this.a;
        int r1 = FlowMessageSelectPlugin.f0;
        r0.J();
    }

    public final Map<String, Message.Type> d() {
        FlowMessageSelectPlugin r0 = this.a;
        IMessageListComponent r1 = r0.j;
        if (r1 == null) goto L8;
        List<ccb.c.a> r2 = r0.S(r1.gK(), r1.pP());
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        ccb.c.a r5 = (ccb.c.a) r4.next();
        Pair r6 = TuplesKt.to(r5.a, r5.getType());
        r3.put(r6.getFirst(), r6.getSecond());
    L9:
        if (r3 == null) goto L11;
        return r3;
    L11:
        return MapsKt.emptyMap();
    L8:
        r3 = null;
        goto L9
    }

    public final List<String> e() {
        FlowMessageSelectPlugin r0 = this.a;
        IMessageListComponent r1 = r0.j;
        if (r1 == null) goto L8;
        List<ccb.c.a> r2 = r0.S(r1.gK(), r1.pP());
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L9;
        r3.add(((ccb.c.a) r4.next()).a);
    L9:
        if (r3 == null) goto L11;
        return r3;
    L11:
        return CollectionsKt.emptyList();
    L8:
        r3 = null;
        goto L9
    }

    public final Chat getChat() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r0 = this.a.h;
        Chat r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chatApp");
        r0 = null;
    L5:
        Chat r2 = (Chat) r0.getViewModel(ChatWindowOpenViewModel.class).getChat().getValue();
        if (r2 != null) goto L14;
        Chat r3 = this.a.i;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("chat");
    L13:
        return r1;
    L11:
        r1 = r3;
        goto L13
    L14:
        return r2;
    }

    public Context getContext() {
        FlowMessageSelectPlugin r0 = this.a;
        int r1 = FlowMessageSelectPlugin.f0;
        return r0.getContext();
    }

    public final MultiSelectContext.Page getPage() {
        return MultiSelectContext.Page.CHAT_WINDOW;
    }

    public f(FlowMessageSelectPlugin r1) {
        this.a = r1;
    }
}
