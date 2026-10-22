package com.ss.android.lark.chat.configurator;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollAlign;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.q0;
import com.ss.android.lark.biz.im.api.r0;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.k;
import com.ss.android.lark.log.Log;
import jdb.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import s2b.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements ChatWindowMessageList.a {
    public final IMessageListComponent a;
    public final Function0<Integer> b;
    public final String c;
    public final g d;
    public final Function0<Boolean> e;
    public final boolean f;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.configurator.a$a, reason: collision with other inner class name */
    public static final class C0083a {
    }

    static {
    }

    public final void b() {
    }

    public final void a() {
        s2b.d r0 = this.a.W2();
        if (r0 != null) goto L6;
        Log.e("InitialPositionHandler", "messageContext == null");
        return;
    L6:
        int r2 = ((Number) this.b.invoke()).intValue();
        Log.i("InitialPositionHandler", "scroll position:" + r2 + ",size:" + this.a.Tc().getItemCount());
        if (r2 < 0) goto L10;
        Log.i("InitialPositionHandler", "scrollToSpecifiedPosition useNewScroller:" + this.f);
        final q r1 = new q(this.a.Tc(), r2);
        r1.b = this.a.rY().k;
        ScrollScene r5 = ScrollScene.INITIAL_SPECIFIED_POSITION;
        Intrinsics.checkNotNullParameter(r5, "scene");
        Function1<RecyclerView, Integer> r6 = new InitialPositionHandler$scrollToSpecifiedPosition$event$1$1(r1);
        Intrinsics.checkNotNullParameter(r6, "value");
        ScrollAlign r8 = ScrollAlign.CENTER;
        Intrinsics.checkNotNullParameter(r8, "value");
        this.a.Ar().f(new ScrollEvent(r5, r6, null, r8, true, 0, new c(this, r2, r1)));
        return;
    L10:
        Chat r3 = r0.getChat();
        if (k.c(r3) != Chat.MessagePosition.NEWEST_UNREAD) goto L14;
        c();
        return;
    L14:
        if (r3 != null) goto L16;
        Log.e("InitialPositionHandler", "scrollToRecentPosition chat == null");
        return;
    L16:
        int r4 = r3.getRecentReadPosition();
        final Ref.BooleanRef r7 = new Ref.BooleanRef();
        float r9 = r3.getRecentReadOffset();
        final boolean r10 = this.d.isCurrentEnable("im.chat.position.record");
        r0 r11 = this.a.rY().n;
        if (r11 == null) goto L19;
        q0 r12 = r11.a(r3);
    L20:
        if (r12 == null) goto L22;
        int r13 = r12.a;
    L23:
        if (r12 == null) goto L25;
        int r14 = r12.b;
    L26:
        if (r12 == null) goto L29;
        if (r13 > 0) goto L29;
        Log.i("InitialPositionHandler", "scrollToRecentPosition custom position has no unread, scrollToNewestMessage");
        c();
        return;
    L29:
        if (r4 >= 0) goto L35;
        if (r13 <= 0) goto L34;
        if (r10 == true) goto L34;
        Log.i("InitialPositionHandler", "scrollToRecentPosition position unreadReadBadgeCount > 0");
        r7.element = true;
        r9 = 2.1474836E9f;
        r4 = r14;
    L34:
        Log.i("InitialPositionHandler", "scrollToRecentPosition position unreadReadBadgeCount <= 0 and fg: " + r10 + ", scrollToNewestMessage");
        c();
        return;
    L35:
        Log.i("InitialPositionHandler", "scrollToRecentPosition position:" + r4 + ",offset:" + r9);
        final q r15 = new q(this.a.Tc(), r4);
        r15.b = this.a.rY().k;
        com.ss.android.lark.biz.im.api.extension.scroll.d r16 = new com.ss.android.lark.biz.im.api.extension.scroll.d(ScrollScene.INITIAL_PREVIOUS_POSITION);
        Function1<RecyclerView, Integer> r17 = new InitialPositionHandler$scrollToRecentRead$event$1$1(r10, r15, r7);
        Intrinsics.checkNotNullParameter(r17, "value");
        r16.b = r17;
        r16.b((int) r9);
        ScrollAlign r18 = ScrollAlign.TOP;
        Intrinsics.checkNotNullParameter(r18, "value");
        r16.d = r18;
        r16.g = new b(this);
        this.a.Ar().f(r16.a());
        return;
    L25:
        r14 = r3.getReadPosition();
        goto L26
    L22:
        r13 = r3.getUnReadBadgeCount();
        goto L23
    L19:
        r12 = null;
        goto L20
    }

    public final void c() {
        Log.i("InitialPositionHandler", "scrollToNewestMessage useNewScroller:" + this.f);
        com.ss.android.lark.biz.im.api.extension.scroll.a.a(this.a.Ar(), ScrollScene.INITIAL_NEWEST_MESSAGE, 0, false);
    }

    public a(IMessageListComponent r2, Function0<Integer> r3, String r4, g r5, Function0<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r2, "component");
        Intrinsics.checkNotNullParameter(r3, "showPosition");
        Intrinsics.checkNotNullParameter(r5, "fgService");
        Intrinsics.checkNotNullParameter(r6, "showNotFoundTip");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r2.Qv();
    }
}
