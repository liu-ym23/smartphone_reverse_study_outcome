package com.ss.android.lark.chat.chatwindow.chat.scroll;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import s2b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0006-./012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010 \u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u0014J\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0011H\u0016J\"\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0018\u0010*\u001a\u00020!2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012H\u0016J\b\u0010+\u001a\u00020\u0012H\u0002J\b\u0010,\u001a\u00020\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR^\u0010\t\u001aR\u0012\u0004\u0012\u00020\u000b\u0012\u001e\u0012\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f0\nj(\u0012\u0004\u0012\u00020\u000b\u0012\u001e\u0012\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RV\u0010\u0010\u001aJ\u0012\u0004\u0012\u00020\u0011\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f0\nj$\u0012\u0004\u0012\u00020\u0011\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/scroll/ScrollBottomController;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Lcom/ss/android/lark/chat/chatwindow/chat/scroll/IScrollBottomController;", "scroller", "Lcom/ss/android/lark/chat/chatwindow/chat/MessageListScroller;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/MessageListScroller;)V", "getScroller$chat_core_productionChinaRelease", "()Lcom/ss/android/lark/chat/chatwindow/chat/MessageListScroller;", "updateStrategies", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/chat/chatwindow/chat/scroll/ScrollBottomController$UpdateStrategy;", "Lkotlin/Function2;", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", BuildConfig.FLAVOR, "Lkotlin/collections/LinkedHashMap;", "insertStrategies", "Lcom/ss/android/lark/chat/chatwindow/chat/scroll/ScrollBottomController$InsertStrategy;", BuildConfig.FLAVOR, "chatAdapter", "Lcom/ss/android/lark/chat/chatwindow/chat/scroll/IScrollBottomSupportAdapter;", "getChatAdapter", "()Lcom/ss/android/lark/chat/chatwindow/chat/scroll/IScrollBottomSupportAdapter;", "setChatAdapter", "(Lcom/ss/android/lark/chat/chatwindow/chat/scroll/IScrollBottomSupportAdapter;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "isAttached", "attachTo", BuildConfig.FLAVOR, "detach", "registerStrategy", "strategy", "onItemRangeChanged", "positionStart", "itemCount", "payload", BuildConfig.FLAVOR, "onItemRangeInserted", "getFirstVisiblePosition", "getLastVisiblePosition", "ScrollAction", "UpdateStrategy", "InsertStrategy", "ScrollContext", "BaseStrategy", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollBottomController extends RecyclerView.AdapterDataObserver {
    public final n a;
    public final LinkedHashMap<e, Function2<y6b.c<?>, y6b.c<?>, Boolean>> b;
    public final LinkedHashMap<b, Function2<Integer, y6b.c<?>, Boolean>> c;
    public com.ss.android.lark.chat.chatwindow.chat.scroll.a<y6b.c<?>> d;
    public RecyclerView e;
    public boolean f;

    public static final class a {
    }

    public static abstract class b {
        public ScrollBottomController a;

        public b() {
        }

        public abstract Function2<Integer, y6b.c<?>, Boolean> a();

        public abstract void c(d r1);

        public final ScrollBottomController b() {
            ScrollBottomController r0 = this.a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("scrollController");
            return null;
        }
    }

    public interface c {
        void a(d r1);
    }

    public static final class d {
        public final n a;
        public final int b;
        public final boolean c;
        public final int d;
        public final int e;
        public y6b.c<?> f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return ((((r0 + r1) * 31) + this.d) * 31) + this.e;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "ScrollContext(scroller=" + this.a + ", itemPosition=" + this.b + ", hasReachBottom=" + this.c + ", firstVisiblePosition=" + this.d + ", lastVisiblePosition=" + this.e + ')';
        }

        public d(n r2, int r3, boolean r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "scroller");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static abstract class e {
        public ScrollBottomController a;

        public e() {
        }

        public abstract Function2<y6b.c<?>, y6b.c<?>, Boolean> a();

        public abstract void c(d r1);

        public final ScrollBottomController b() {
            ScrollBottomController r0 = this.a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("scrollController");
            return null;
        }
    }

    static {
    }

    public final com.ss.android.lark.chat.chatwindow.chat.scroll.a<y6b.c<?>> c() {
        com.ss.android.lark.chat.chatwindow.chat.scroll.a<y6b.c<?>> r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chatAdapter");
        return null;
    }

    public final RecyclerView d() {
        RecyclerView r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public ScrollBottomController(n r2) {
        Intrinsics.checkNotNullParameter(r2, "scroller");
        this.a = r2;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public final void b(SceneCoordinateRecyclerView r2, com.ss.android.lark.chat.chatwindow.chat.scroll.a r3) {
        Intrinsics.checkNotNullParameter(r3, "chatAdapter");
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.d = r3;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
        this.f = true;
        r3.Y(new com.ss.android.lark.chat.chatwindow.chat.scroll.b(this));
        r3.e().registerAdapterDataObserver(this);
    }

    public final void onItemRangeInserted(int r10, int r11) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (c().getItemCount() != (r10 + 1)) goto L45;
        int r12 = r11 + r10;
        int r2 = r10;
    L7:
        if (r2 >= r12) goto L46;
        Iterator r13 = p.a(this.c.keySet()).iterator();
    L10:
        if (r13.hasNext() == false) goto L38;
        b r6 = (b) r13.next();
        Intrinsics.checkNotNull(r6);
        Function2<Integer, y6b.c<?>, Boolean> r0 = this.c.get(r6);
        y6b.c<?> r7 = (y6b.c) c().getItem(r2);
        if (r7 == null) goto L13;
        LinearLayoutManager r3 = null;
        if (r0 == null) goto L18;
        Boolean r1 = (Boolean) r0.invoke(Integer.valueOf(r2), r7);
    L20:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L10;
        Log.i("MessageListBottomScroll", "onItemRangeInserted: handle scrolling , target position is " + r2);
        n r4 = this.a;
        boolean r14 = com.ss.android.lark.chat.chatwindow.chat.scroll.c.a(d());
        LinearLayoutManager r5 = d().getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == false) goto L25;
        LinearLayoutManager r8 = r5;
    L27:
        if (r8 != null) goto L29;
        int r9 = -1;
    L30:
        RecyclerView.LayoutManager r15 = d().getLayoutManager();
        if ((r15 instanceof LinearLayoutManager) == false) goto L33;
        r3 = (LinearLayoutManager) r15;
    L33:
        if (r3 != null) goto L35;
        int r16 = -1;
    L36:
        d r17 = new d(r4, r2, r14, r9, r16);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r17.f = r7;
        r6.c(r17);
        return;
    L35:
        r16 = r3.findLastVisibleItemPosition();
        goto L36
    L29:
        r9 = r8.findFirstVisibleItemPosition();
        goto L30
    L25:
        r8 = null;
        goto L27
    L18:
        r1 = null;
        goto L20
    L13:
        Log.w("MessageListBottomScroll", "onItemRangeInserted: item is null , method return.");
        return;
    L38:
        r2 = r2 + 1;
        goto L7
    L46:
        return;
    }

    public final void onItemRangeChanged(int r8, int r9, Object r10) {
        if ((r10 instanceof c) == true) goto L6;
        return;
    L6:
        if (r9 == 1) goto L8;
        return;
    L8:
        c r11 = (c) r10;
        n r1 = this.a;
        boolean r3 = com.ss.android.lark.chat.chatwindow.chat.scroll.c.a(d());
        LinearLayoutManager r0 = d().getLayoutManager();
        LinearLayoutManager r4 = null;
        if ((r0 instanceof LinearLayoutManager) == false) goto L11;
        LinearLayoutManager r2 = r0;
    L13:
        if (r2 != null) goto L15;
        int r5 = -1;
    L16:
        RecyclerView.LayoutManager r6 = d().getLayoutManager();
        if ((r6 instanceof LinearLayoutManager) == false) goto L19;
        r4 = (LinearLayoutManager) r6;
    L19:
        if (r4 != null) goto L21;
        int r7 = -1;
    L22:
        r11.a(new d(r1, r8, r3, r5, r7));
        return;
    L21:
        r7 = r4.findLastVisibleItemPosition();
        goto L22
    L15:
        r5 = r2.findFirstVisibleItemPosition();
        goto L16
    L11:
        r2 = null;
        goto L13
    }
}
