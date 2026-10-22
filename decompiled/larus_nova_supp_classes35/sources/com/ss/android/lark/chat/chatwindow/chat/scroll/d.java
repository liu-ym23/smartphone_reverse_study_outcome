package com.ss.android.lark.chat.chatwindow.chat.scroll;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollAlign;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.lark.biz.im.api.extension.scroll.e;
import com.ss.android.lark.biz.im.api.extension.scroll.f;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.configurator.AutoScrollBottomHandler;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s2b.m;
import s2b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements com.ss.android.lark.biz.im.api.extension.scroll.c {
    public final n a;
    public final ScrollBottomController b;
    public RecyclerView c;
    public final ArrayDeque<Pair<String, ScrollEvent>> d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ScrollAlign.values().length];
            r0[ScrollAlign.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ScrollAlign.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ScrollAlign.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements n.b {
        public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.scroll.b a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ScrollEvent c;

        public c(com.ss.android.lark.biz.im.api.extension.scroll.b r1, String r2, ScrollEvent r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // s2b.n.b
        public final void a() {
            this.a.a(this.b, this.c);
        }
    }

    static {
    }

    public final void a() {
    }

    public final boolean c(e.a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        return false;
    }

    public final boolean d(e.a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        return false;
    }

    public final void e(AutoScrollBottomHandler.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public final void detach() {
        this.a.d = null;
        ScrollBottomController r0 = this.b;
        if (r0.f == true) goto L10;
    L8:
        r0.f = false;
        this.c = null;
        this.d.clear();
        return;
    L10:
        r0.c().e().unregisterAdapterDataObserver(r0);     // Catch: IllegalStateException -> L6
    L6:
        e = move-exception;
        Log.e("MessageListBottomScroll", "unRegisterAdapter error" + e.getMessage(), e, true);
        goto L8
    }

    public d() {
        n r0 = new n();
        this.a = r0;
        ScrollBottomController r1 = new ScrollBottomController(r0);
        AppendNewMessageScrollStrategy r2 = new AppendNewMessageScrollStrategy();
        Intrinsics.checkNotNullParameter(r2, "strategy");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r2.a = r1;
        r1.c.put(r2, r2.a());
        UpdateLastMessageScrollStrategy r3 = new UpdateLastMessageScrollStrategy();
        Intrinsics.checkNotNullParameter(r3, "strategy");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r3.a = r1;
        r1.b.put(r3, r3.a());
        this.b = r1;
        this.d = new ArrayDeque();
    }

    public final String f(ScrollEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        AtomicLong r0 = f.a;
        String r1 = "scroll<" + f.a.incrementAndGet() + '>';
        if (this.c == null) goto L5;
        boolean r2 = true;
    L6:
        Log.i("ScrollDispatcherV1", "scroll attached:" + r2 + ",id" + r1);
        if (r2 == false) goto L9;
        g(r1, r5);
    L10:
        return r1;
    L9:
        this.d.addLast(TuplesKt.to(r1, r5));
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public final void b(RecyclerView r5, LinearLayoutManager r6) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Intrinsics.checkNotNullParameter(r6, "layoutManager");
        this.c = r5;
        n r7 = this.a;
        String r1 = null;
        Object r2 = null;
        if (r7.a == r5) goto L8;
        r7.a = r5;
        if (r7.d == null) goto L8;
        Log.i("MessageListScroller", "scroll pending request");
        r7.a(r7.d);
        r7.d = null;
    L8:
        com.ss.android.lark.chat.chatwindow.chat.scroll.a r8 = r5.getAdapter();
        if ((r8 instanceof com.ss.android.lark.chat.chatwindow.chat.a) == false) goto L12;
        Log.i("ScrollDispatcherV1", "attachTo chat adapter");
        this.b.b((SceneCoordinateRecyclerView) r5, r8);
    L27:
        Log.i("ScrollDispatcherV1", "eventQueue size:" + this.d.size());
    L29:
        if ((!this.d.isEmpty()) == false) goto L34;
        Pair r9 = (Pair) this.d.removeFirstOrNull();
        if (r9 == null) goto L40;
        g((String) r9.getFirst(), (ScrollEvent) r9.getSecond());
        goto L29
    L40:
        return;
    L34:
        return;
    L12:
        if ((r8 instanceof ConcatAdapter) == false) goto L23;
        Iterator r10 = ((ConcatAdapter) r8).getAdapters().iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        Object r0 = r10.next();
        if ((((RecyclerView.Adapter) r0) instanceof com.ss.android.lark.chat.chatwindow.chat.a) == false) goto L15;
        r2 = r0;
    L19:
        com.ss.android.lark.chat.chatwindow.chat.scroll.a r3 = (RecyclerView.Adapter) r2;
        if ((r3 instanceof com.ss.android.lark.chat.chatwindow.chat.a) == false) goto L22;
        Log.i("ScrollDispatcherV1", "attachTo first chat adapter");
        this.b.b((SceneCoordinateRecyclerView) r5, r3);
        goto L27
    L22:
        Log.e("ScrollDispatcherV1", "no chat adapter");
        goto L27
    L23:
        StringBuilder r11 = new StringBuilder("unsupported adapter:");
        if (r8 == null) goto L26;
        r1 = r8.getClass().getName();
    L26:
        r11.append(r1);
        Log.e("ScrollDispatcherV1", r11.toString());
        goto L27
    }

    public final void g(String r5, ScrollEvent r6) {
        n.a r0 = new n.a();
        RecyclerView r1 = this.c;
        if (r1 == null) goto L11;
        Function1 r2 = r6.b;
        if (r2 == null) goto L7;
        r0.a = new m(((Number) r2.invoke(r1)).intValue());
    L7:
        Function1 r3 = r6.c;
        if (r3 == null) goto L11;
        r0.e = ((Number) r3.invoke(r1)).intValue();
    L11:
        if (Intrinsics.areEqual(r6.b, ScrollEvent.j) == false) goto L13;
        r0.g = true;
    L13:
        ScrollAlign r4 = r6.d;
        if (r4 == null) goto L27;
        int r7 = b.a[r4.ordinal()];
        if (r7 != 1) goto L18;
        int r8 = 48;
    L26:
        r0.b = r8;
        goto L27
    L18:
        if (r7 != 2) goto L20;
        r8 = 80;
        goto L26
    L20:
        if (r7 != 3) goto L23;
        r8 = 17;
        goto L26
    L23:
        throw new NoWhenBranchMatchedException();
    L27:
        com.ss.android.lark.biz.im.api.extension.scroll.b r9 = r6.i;
        if (r9 == null) goto L30;
        r0.f = new c(r9, r5, r6);
    L30:
        r0.c = (int) r6.g;
        r0.d = r6.e;
        Integer r10 = r6.f;
        if (r10 == null) goto L33;
        r0.h = r10.intValue();
    L33:
        this.a.a(new n.c(r0));
    }
}
