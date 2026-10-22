package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features;

import a4b.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.CoreMessageListComponent$featureManager$2;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.MessageListDataFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEventDispatchFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.MessageListMenuFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.MessageListRendererFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll.MessageListScrollFeature;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t6b.k;
import t6b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final o a;
    public final b b;
    public final h4b.c<com.ss.android.lark.chat.chatwindow.chat.a> c;
    public final z2b.a d;
    public final MessageListDataFeature.b<IMessageListViewModel> e;
    public final MessageListDataFeature.a f;
    public final Function0<Unit> g;
    public final LinkedHashMap<Class<?>, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a> h;
    public MessageListRendererFeature i;
    public MessageListMenuFeature j;
    public e4b.b k;
    public MessageListEventDispatchFeature l;
    public MessageListDataFeature m;
    public d n;
    public MessageListScrollFeature o;
    public b4b.b p;

    public static final class a {
    }

    static {
    }

    public final k a() {
        return (k) this.a.b(k.class);
    }

    public final void b(i7b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "initData");
        Iterator<T> r0 = this.h.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a) r0.next()).x(r3);
        goto L4
    }

    public c(o r2, b r3, h4b.c r4, w2b.a r5, CoreMessageListComponent$featureManager$2.a r6, MessageListDataFeature.a r7, Function0 r8) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        Intrinsics.checkNotNullParameter(r3, "env");
        Intrinsics.checkNotNullParameter(r4, "listRenderer");
        Intrinsics.checkNotNullParameter(r6, "viewModelProvider");
        Intrinsics.checkNotNullParameter(r8, "exitChat");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = new LinkedHashMap();
    }
}
